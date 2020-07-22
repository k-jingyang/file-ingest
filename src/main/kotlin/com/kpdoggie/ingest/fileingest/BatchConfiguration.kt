package com.kpdoggie.ingest.fileingest

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.time.LocalDate


@Configuration
@EnableBatchProcessing
class BatchConfiguration(@Autowired private val jobBuilderFactory: JobBuilderFactory, @Autowired private val stepBuilderFactory: StepBuilderFactory) {
    @Bean
    fun reader(): FlatFileItemReader<Person> {
        // Should read file based on location stated in properties (application.yml)
        return (FlatFileItemReaderBuilder<Person>()).name("personItemReader")
                .resource(ClassPathResource("input.csv"))
                .delimited().delimiter(",")
                .names("name", "dateOfBirth", "gender")
                .fieldSetMapper {
                    val name = it.readString("name")
                    val dob = it.readString("dateOfBirth")
                    val gender = it.readChar("gender")
                    Person(name, LocalDate.parse(dob), gender)
                }
                .linesToSkip(1)
                .build()
    }

    /*
    @Bean
    fun writer(dataSource: DataSource): JdbcBatchItemWriter<Person>? {
        return JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(
                        BeanPropertyItemSqlParameterSourceProvider())
                .sql("INSERT INTO PEOPLE (NAME, GENDER, DOB, AGE) VALUES (:name, :gender, :dateOfBirth, :age)")
                .dataSource(dataSource).build()
    }*/

    @Bean
    fun processor(): ItemProcessor<Person, Person> {
        return ItemProcessor<Person, Person> {
            Person(it.name.toLowerCase(), it.dateOfBirth, it.gender)
        }
    }

    @Bean
    fun importUserJob(listener: JobCompletionNotificationListener, step1: Step): Job {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(RunIdIncrementer())
                .listener(listener).flow(step1).end().build()
    }

    @Bean
    fun step1(writer: DBItemWriter): Step {
        return stepBuilderFactory.get(
                "step1").chunk<Person, Person>(10).reader(reader())
                .processor(processor()).writer(writer).build()
    }

}
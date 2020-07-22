package com.kpdoggie.ingest.fileingest

import com.kpdoggie.ingest.fileingest.schema.Tables
import com.kpdoggie.ingest.fileingest.schema.Tables.PEOPLE
import org.jooq.DSLContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDate


@Component
class JobCompletionNotificationListener() : JobExecutionListenerSupport() {

    // Just to try out that field injection still works (Not recommended though)
    @Autowired
    private lateinit var dslContext: DSLContext

    override fun afterJob(jobExecution: JobExecution) {

        if (jobExecution.getStatus() === BatchStatus.COMPLETED) {
            val result = dslContext.select(Tables.PEOPLE.NAME).from(
                    Tables.PEOPLE)
                    .fetchInto(String.javaClass)

            System.out.println(result)

            log.info(
                    "Job completed. Verify the results.")

            dslContext.select(PEOPLE.NAME, PEOPLE.DOB, PEOPLE.GENDER,
                    PEOPLE.AGE).from(PEOPLE).fetch().map {
                val fetched = Person(it.get(0) as String,
                        it.get(1) as LocalDate,
                        (it.get(2) as String)[0])
                
                log.info("{} Age: {}", fetched, it.get(3) as Int)
            }
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(
                JobCompletionNotificationListener::class.java)
    }

}
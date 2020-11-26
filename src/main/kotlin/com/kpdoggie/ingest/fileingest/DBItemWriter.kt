package com.kpdoggie.ingest.fileingest

import org.jooq.DSLContext
import org.springframework.batch.item.ItemWriter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DBItemWriter(@Autowired private val dslContext: DSLContext) : ItemWriter<Person> {

    override fun write(items: MutableList<out Person>) {
        items.forEach {
    /*        dslContext
                    .insertInto(PEOPLE)
                    .columns(PEOPLE.NAME,
                            PEOPLE.GENDER,
                            PEOPLE.DOB,
                            PEOPLE.AGE)
                    .values(it.name,
                            it.gender.toString(),
                            it.dateOfBirth,
                            it.age).execute()*/
        }
    }


}
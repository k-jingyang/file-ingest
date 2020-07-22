package com.kpdoggie.ingest.fileingest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.listener.JobExecutionListenerSupport
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.time.LocalDate


@Component
class JobCompletionNotificationListener(@Autowired private val jdbcTemplate: JdbcTemplate) : JobExecutionListenerSupport() {

    override fun afterJob(jobExecution: JobExecution) {

        if (jobExecution.getStatus() === BatchStatus.COMPLETED) {
            log.info(
                    "Job completed. Verify the results.")
            jdbcTemplate
                    .query("SELECT NAME, DOB, GENDER, AGE FROM people"
                    ) { rs: ResultSet, row: Int ->
                        log.info("{} {} {} {}",
                                rs.getString(1),
                                LocalDate.parse(rs.getString(2)),
                                rs.getString(3)[0],
                                rs.getString(4))
                    }
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(
                JobCompletionNotificationListener::class.java)
    }

}
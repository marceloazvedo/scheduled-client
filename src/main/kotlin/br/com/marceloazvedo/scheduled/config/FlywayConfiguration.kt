package br.com.marceloazvedo.scheduled.config

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class FlywayConfiguration {

    @Autowired
    fun FlywayConfiguration(dataSource: DataSource?) {
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate()
    }

}
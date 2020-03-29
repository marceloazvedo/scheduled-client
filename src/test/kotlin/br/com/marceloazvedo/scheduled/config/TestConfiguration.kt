package br.com.marceloazvedo.scheduled.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


@TestConfiguration
@PropertySource("test.properties")
@EnableTransactionManagement
class TestConfiguration {

    @Autowired
    private val env: Environment? = null

    private final val H2_DRIVER_CLASS_NAME = "org.h2.Driver"
    private final val H2_DATABASE_URL = "jdbc:h2:file:/home/marcelo/dbh2test"
    private final val H2_USER = "org.h2.Driver"
    private final val H2_PASSWORD = "org.h2.Driver"

    @Bean
    fun dataSource(): DataSource? {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName(H2_DRIVER_CLASS_NAME)
        dataSource.url = H2_DATABASE_URL
        dataSource.username = H2_USER
        dataSource.password = H2_PASSWORD
        return dataSource
    }

}
package restaurant.management;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * DataSourceConfiguration
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/5/20 - created by zhe.jiang
 */
@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("restaurant-management-schema-1.0.0.sql")
                .addScript("restaurant-management-data-1.0.0.sql")
                .build();
    }

}

package pe.edu.I202330006.cl1_jpa_data_dellepiane_jorge.config.Tomcat;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {

    @Value("${DB_WORLD_URL}")
    private String dbworldUrl;
    @Value("${DB_ WORLD_USER}")
    private String dbworldUser;
    @Value("${DB_WORLD_PASS}")
    private String dbworldPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbworldDriver;

    @Bean
    public HikariDataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbworldUrl);
        config.setUsername(dbworldUser);
        config.setPassword(dbworldPass);
        config.setDriverClassName(dbworldDriver);

        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(45000);

        return new HikariDataSource(config);
    }
}

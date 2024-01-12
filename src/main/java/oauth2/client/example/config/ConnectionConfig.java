package oauth2.client.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConnectionConfig {

    @Value("${oauth2.property.database.address}")
    private String PROPERTY_ADDRESS;

    @Value("${oauth2.property.database.port}")
    private int PROPERTY_PORT;

    @Value("${oauth2.property.database.user}")
    private String PROPERTY_USER;

    @Value("${oauth2.property.database.password}")
    private String PROPERTY_PASSWORD;

    @Value("${oauth2.property.database}")
    private String PROPERTY_DATABASE;

    @Value("${oauth2.property.database.integrated_security}")
    private boolean PROPERTY_INTEGRATED_SECURITY;

    @Bean
    public DataSource getDataSource(){
        String url = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;integratedSecurity=%b", PROPERTY_ADDRESS, PROPERTY_PORT, PROPERTY_DATABASE, PROPERTY_INTEGRATED_SECURITY);

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        dataSourceBuilder.url(url);
        dataSourceBuilder.username(PROPERTY_USER);
        dataSourceBuilder.password(PROPERTY_PASSWORD);
        return dataSourceBuilder.build();
    }

}

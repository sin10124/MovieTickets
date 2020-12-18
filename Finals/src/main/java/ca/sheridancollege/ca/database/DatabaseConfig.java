package ca.sheridancollege.ca.database;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DatabaseConfig {
	
  
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource)
	{
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DataSource datasource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:mem:testdb");
		datasource.setUsername("sa");
		datasource.setPassword("");
		
		return datasource;
	}
	@Bean
	public DataSource loadSchema()
	{
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:customers.sql")
				.build();
	}
	
}


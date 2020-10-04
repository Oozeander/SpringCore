package com.oozeander.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.ConfigurableEnvironment;

import com.oozeander.model.DatabaseConnection;

@Configuration
@PropertySource(value = "classpath:db.properties", ignoreResourceNotFound = false)
public class MessagingConfig {
	@Autowired
	ConfigurableEnvironment env;

	@Bean
	@Scope("singleton")
	MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(new String[] { "classpath:messages/messages" });
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setAlwaysUseMessageFormat(true);
		return messageSource;
	}

	@Bean(name = "DBCo")
	@Scope("prototype")
	DatabaseConnection databaseConnection() {
		return new DatabaseConnection(env.getRequiredProperty("db.url"), env.getRequiredProperty("db.driver"),
				env.getRequiredProperty("db.user"), env.getRequiredProperty("db.pass"));
	}
}
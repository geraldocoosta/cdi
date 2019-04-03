package br.com.ultcode.lib.configurantion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import br.com.ultcode.lib.configurantion.annotation.Configuration;

public class ConfigurationFactory {

	@ApplicationScoped
	@Configuration
	@Produces
	public Properties getProperties() throws IOException {
		InputStream inputStream = ConfigurationFactory.class.getResourceAsStream("/livraria.properties");

		Properties properties = new Properties();
		properties.load(inputStream);

		return properties;
	}
}

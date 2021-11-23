package com.tokenizer.rest;

import com.tokenizer.rest.config.AppConfiguration;
import com.tokenizer.rest.resources.AuthResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.Properties;

import static com.tokenizer.rest.util.Constants.*;

public class App extends Application<AppConfiguration> {

	public static final Properties properties = new Properties();

	@Override
	public void initialize(Bootstrap<AppConfiguration> b) {
	}

	@Override
	public void run(AppConfiguration c, Environment e) throws Exception
	{
		e.jersey().register(new AuthResource());
		configureProperties(c);
	}

	private void configureProperties(AppConfiguration c) {
		properties.put(BOOTSTRAP_SERVER, c.getBootstrapServer());
        properties.put(KEY_SERIALIZER, c.getKeySerializer());
        properties.put(VALUE_SERIALIZER, c.getValueSerializer());
        properties.put(TOPIC, c.getTopic());
	}

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}
}

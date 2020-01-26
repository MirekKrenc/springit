package com.miro.springit;

import com.miro.springit.config.SpringitConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringitApplication {

	@Autowired
	private SpringitConfiguration springitConfiguration;

	@Autowired
	private ApplicationContext applicationContext;

	private static Logger log = LoggerFactory.getLogger(SpringitApplication.class);

	public static void main(String[] args) {


		SpringApplication.run(SpringitApplication.class, args);
		System.out.println("Welcome message for git branching test - Welcome from Springit!");
	}

	@Bean
	@Profile("dev")
	CommandLineRunner runner() {
		return args -> {
			System.out.println("Welcome message from properties displayed only in dev profile is: " + springitConfiguration.getWelcomeMsg());
			String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
			Arrays.stream(beanDefinitionNames).sorted().forEach(bean -> System.out.println("BEAN: " + bean));
		};
	}


	@Bean
	CommandLineRunner loggingRunner() {
		return args -> {
			log.error("CommandLineRunner.run();");
			log.warn("CommandLineRunner.run();");
			log.info("CommandLineRunner.run();");
			log.debug("CommandLineRunner.run();");
			log.trace("CommandLineRunner.run();");
		};
	}

}

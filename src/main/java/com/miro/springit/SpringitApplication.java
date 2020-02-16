package com.miro.springit;

import com.miro.springit.config.SpringitConfiguration;
import com.miro.springit.domain.Comment;
import com.miro.springit.domain.Link;
import com.miro.springit.repository.CommentRepository;
import com.miro.springit.repository.LinkRepository;
import org.ocpsoft.prettytime.PrettyTime;
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
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
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
	PrettyTime prettyTime()
	{
		return new PrettyTime();
	}

//	@Bean
//	@Profile("dev")
//	CommandLineRunner runner() {
//		return args -> {
//			System.out.println("Welcome message from properties displayed only in dev profile is: " + springitConfiguration.getWelcomeMsg());
//			String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//			//Arrays.stream(beanDefinitionNames).sorted().forEach(bean -> System.out.println("BEAN: " + bean));
//		};
//	}


	//@Bean
	CommandLineRunner loggingRunner() {
		return args -> {
			log.error("CommandLineRunner.run();");
			log.warn("CommandLineRunner.run();");
			log.info("CommandLineRunner.run();");
			log.debug("CommandLineRunner.run();");
			log.trace("CommandLineRunner.run();");
		};
	}

//	@Bean
//	CommandLineRunner databaseRunner(LinkRepository linkRepository, CommentRepository commentRepository)
//	{
//		return args -> {
//			Link link = new Link("Drogie borowki w sklepie", "https://sklep6028485.homesklep.pl/pl/p/Borowki/23");
//			linkRepository.save(link);
//
////			Comment comment = new Comment("Borowki sa drogie ale bardzo smaczne", link);
////			commentRepository.save(comment);
//
//			//link.addComment(comment);
//
////			Comment comment1 = new Comment("Pychotki te borowki", link);
////			commentRepository.save(comment1);
//
//			//link.addComment(comment1);
//
//			Link link2 = new Link("Zlociutkie banany", "https://sklep6028485.homesklep.pl/pl/p/Banany/3");
//			linkRepository.save(link2);
//			//System.out.println(link.getComments());
//		};
//	}

}

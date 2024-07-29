package EAGLE04.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Eagle04Application {

	public static void main(String[] args) {
		SpringApplication.run(Eagle04Application.class, args);
	}

}

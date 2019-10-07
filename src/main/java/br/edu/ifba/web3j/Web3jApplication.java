package br.edu.ifba.web3j;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Web3jApplication {

	private static ConfigurableApplicationContext ctx;
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Web3jApplication.class);
		ctx = application.run(args);
	}

	@PreDestroy
	public void onShutDown() {
	  System.out.println("closing application context..let's do the final resource cleanup");
	  ctx.close();
	}
}
package vending;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class MaintananceServerApp {
	@Value("${message:NI_MESSAGE}")
	static String message;
	
	public static void main(String[] args) {
		SpringApplication.run(MaintananceServerApp.class, args);
		System.out.println("MESSAGE: " + message);
	}
}

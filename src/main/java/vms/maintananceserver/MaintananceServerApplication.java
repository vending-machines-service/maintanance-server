package vms.maintananceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class MaintananceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaintananceServerApplication.class, args);
	}

}


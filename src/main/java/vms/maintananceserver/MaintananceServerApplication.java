package vms.maintananceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@SpringBootApplication
@RefreshScope
@EnableAutoConfiguration
@ManagedResource
public class MaintananceServerApplication {

	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		ctx = SpringApplication.run(MaintananceServerApplication.class, args);
	}

	@ManagedOperation
	public static void stop() {
		ctx.close();
	}
}

package vms.maintananceserver;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MaintananceServerApplication.class)
public class StreamTest {
	ConfigurableApplicationContext ctx;
	@Autowired
	private Sink channels;


	@Test
	public void testMessages() {
		this.channels.input().send(new GenericMessage<>("foo"));

	}
}

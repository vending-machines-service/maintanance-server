package vending;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vending.dto.SensorDTO;
import vending.jpa.RecordJPA;
import vending.repository.RecordRepository;
import vending.service.MaintananceService;

@SpringBootApplication
class MaintananceServerTest {
	ConfigurableApplicationContext ctx;
	
	MaintananceService mService;
	
	RecordRepository recRepo;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@BeforeEach
	void setUp() throws Exception {
		ctx = SpringApplication.run(MaintananceServerApp.class);
		this.mService = ctx.getBean(MaintananceService.class);
		this.recRepo = ctx.getBean(RecordRepository.class);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		ctx.close();
	}

	@Test
	void createMaintananceEventTest() throws IOException {
		SensorDTO sensor = TestDataFactory.getSensorsData(1).get(0);
		String sensorDataJSON = this.mapper.writeValueAsString(sensor);

		this.mService.createMaintananceEvent(sensorDataJSON);
		RecordJPA rec = this.recRepo.findById(RecordJPA.makeId(sensor.getMachineId(), sensor.getSensorId())).orElse(null);
		assertEquals(rec.getMachineId(), sensor.getMachineId());
		
		this.mService.createMaintananceEvent(sensorDataJSON);
		assertTrue(this.recRepo.findAll().size() == 1);
		
	}
}

package vms.maintananceserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import vms.maintananceserver.dto.RecordDTO;
import vms.maintananceserver.dto.SensorDTO;
import vms.maintananceserver.jpa.RecordJPA;
import vms.maintananceserver.repository.RecordRepository;
import vms.maintananceserver.service.MaintananceService;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
class MaintananceServerTest {
  ConfigurableApplicationContext ctx;
  MaintananceService mService;
  RecordRepository recRepo;

  ObjectMapper mapper = new ObjectMapper();

  @BeforeEach
  void setUp() throws Exception {
    ctx = SpringApplication.run(MaintananceServerApplication.class);
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
    RecordJPA rec = this.recRepo.findById(RecordDTO.makeId(sensor.getMachineId(), sensor.getSensorId())).orElse(null);
    assertEquals(rec.getMachineId(), sensor.getMachineId());

    this.mService.createMaintananceEvent(sensorDataJSON);
    assertTrue(this.recRepo.findAll().size() == 1);
  }
}

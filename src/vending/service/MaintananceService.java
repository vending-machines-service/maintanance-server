package vending.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vending.dto.RecordDTO;
import vending.dto.SensorDTO;
import vending.jpa.RecordJPA;
import vending.repository.RecordRepository;

@EnableBinding(Sink.class)
public class MaintananceService {
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	RecordRepository repo;
	
	@StreamListener(Sink.INPUT)
	public void createMaintananceEvent(String sensorDataJSON) throws JsonParseException, JsonMappingException, IOException {
		SensorDTO sensor = mapper.readValue(sensorDataJSON, SensorDTO.class);
		RecordJPA recordJpa = new RecordJPA(sensor.getMachineId(), sensor.getSensorId(), LocalDate.now());
		saveRecord(recordJpa);
	}

	private void saveRecord(RecordJPA recordJpa) {
		if (this.repo.existsById(recordJpa.getId())) {
			return;
		}
		this.repo.save(recordJpa);
	}
}

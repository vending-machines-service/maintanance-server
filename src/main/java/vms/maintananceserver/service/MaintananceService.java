package vms.maintananceserver.service;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import vms.maintananceserver.dto.RecordDTO;
import vms.maintananceserver.dto.SensorDTO;
import vms.maintananceserver.jpa.RecordJPA;
import vms.maintananceserver.repository.RecordRepository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableBinding(Sink.class)
@Service
@Slf4j
public class MaintananceService {
	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	RecordRepository repo;

	@StreamListener(Sink.INPUT)
	public void createMaintananceEvent(String sensorDataJSON)
			throws JsonParseException, JsonMappingException, IOException {
		SensorDTO sensor = mapper.readValue(sensorDataJSON, SensorDTO.class);
		log.info("[RECEIVED]: MACHINE: {}; SENSOR: {}; VALUE: {}", sensor.getMachineId(), sensor.getSensorId(), sensor.getValue());
		RecordDTO record = new RecordDTO(sensor.getMachineId(), sensor.getSensorId(), sensor.getValue(), LocalDate.now());

		saveRecord(record.toRecordJPA());
	}

	private void saveRecord(RecordJPA record) {
		if (this.repo.existsById(record.getId())) {
			return;
		}
		this.repo.save(record);
	}
}

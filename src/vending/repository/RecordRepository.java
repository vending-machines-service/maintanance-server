package vending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vending.jpa.RecordJPA;

public interface RecordRepository extends JpaRepository<RecordJPA, String> {
	public boolean existsByMachineIdAndSensorId(Integer machineId, String sensorId);
}

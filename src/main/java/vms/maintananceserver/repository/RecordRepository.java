package vms.maintananceserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vms.maintananceserver.jpa.RecordJPA;

public interface RecordRepository extends JpaRepository<RecordJPA, String> {
	public boolean existsByMachineIdAndSensorId(Integer machineId, String sensorId);
}
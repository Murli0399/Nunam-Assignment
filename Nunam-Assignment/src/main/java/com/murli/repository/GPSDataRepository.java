package com.murli.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murli.entity.GPSData;

@Repository
public interface GPSDataRepository extends JpaRepository<GPSData, Integer> {
	List<GPSData> findByVehicleIdInAndTimestampBetween(List<Integer> vehicleIds, LocalDateTime startDate,
			LocalDateTime endDate);

}

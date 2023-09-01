package com.murli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murli.entity.GPSData;

@Repository
public interface GPSDataRepository extends JpaRepository<GPSData, Integer> {

}

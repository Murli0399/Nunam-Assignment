package com.murli.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murli.entity.GPSData;
import com.murli.exception.GPSDataException;
import com.murli.repository.GPSDataRepository;

@Service
public class GPSDataServiceImpl implements GPSDataService {

	@Autowired
	private GPSDataRepository gr;

	@Override
	public List<GPSData> getAllGPSData() throws GPSDataException {
		List<GPSData> list = gr.findAll();
		if (list.isEmpty()) {
			throw new GPSDataException("GPSData Not Present");
		}
		return list;
	}

	public List<GPSData> getGPSDataDateRange(List<Integer> vehicleIds, LocalDate startDate, LocalDate endDate) {
        return gr.findByVehicleIdInAndTimestampBetween(vehicleIds, startDate.atStartOfDay(), endDate.plusDays(1).atStartOfDay());
    }
	
	@Override
	public GPSData getGPSData(Integer id) throws GPSDataException {
		Optional<GPSData> v = gr.findById(id);

		if (v.isEmpty()) {
			throw new GPSDataException("GPSData Not Found");
		}
		return v.get();
	}

	@Override
	public GPSData saveGPSData(GPSData gpsData) throws GPSDataException {
		return gr.save(gpsData);
	}

	@Override
	public GPSData updateGPSData(Integer id, GPSData gpsData) throws GPSDataException {
		Optional<GPSData> v = gr.findById(id);

		if (v.isEmpty()) {
			throw new GPSDataException("GPSData Not Found");
		}
		GPSData vh = v.get();

		vh.setLatitude(gpsData.getLatitude());
		vh.setLongitude(gpsData.getLongitude());
		vh.setTimestamp(gpsData.getTimestamp());
		vh.setVehicle(gpsData.getVehicle());

		return gr.save(vh);
	}

	@Override
	public GPSData deleteGPSData(Integer id) throws GPSDataException {
		Optional<GPSData> v = gr.findById(id);

		if (v.isEmpty()) {
			throw new GPSDataException("GPSData Not Found");
		}
		GPSData vh = v.get();
		gr.deleteById(id);
		return vh;
	}

}

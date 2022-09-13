package com.text.orchard.vehicle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.text.orchard.vehicle.exception.ResourceNotFoundException;
import com.text.orchard.vehicle.model.Vehicle;
import com.text.orchard.vehicle.repository.VehicleRepository;



@RestController
@RequestMapping("/api/v1")
public class VehicleController {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	//get all vehicles
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicle(){
		return vehicleRepository.findAll();
		
	}
	
	//create vehicle rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/vehicles")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	
	//get vehicle by id rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id){
		Vehicle vehicle=vehicleRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Vehicle not exist with id:"+id));
		return ResponseEntity.ok(vehicle);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails){
		Vehicle vehicle=vehicleRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Vehicle not exist with id:"+id));
		
		vehicle.setVehicleName(vehicleDetails.getVehicleName());
		vehicle.setTypeVehicle(vehicle.getTypeVehicle());
		vehicle.setState(vehicleDetails.getState());
		vehicle.setCity(vehicleDetails.getCity());
		
		Vehicle updatedVehicle=vehicleRepository.save(vehicle);
		return ResponseEntity.ok(updatedVehicle);
		
		
		
		}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteVehicle(@PathVariable Long id){
		Vehicle vehicle=vehicleRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Vehicle not exist with id:"+id));
		
		vehicleRepository.delete(vehicle);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
				
	}
}

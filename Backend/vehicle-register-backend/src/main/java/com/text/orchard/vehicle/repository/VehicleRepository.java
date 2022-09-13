package com.text.orchard.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.text.orchard.vehicle.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

}

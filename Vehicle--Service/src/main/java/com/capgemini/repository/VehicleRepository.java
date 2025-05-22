package com.capgemini.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.entity.Vehicle;
import com.capgemini.entity.VehicleStatus;

// Repository interface for Vehicle entity
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    // Custom method to find vehicles by their status
    List<Vehicle> findByStatus(VehicleStatus status);
}
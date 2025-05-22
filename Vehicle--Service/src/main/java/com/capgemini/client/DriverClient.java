package com.capgemini.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.dto.DriverDTO;

@FeignClient(name="driverrentalModule")
public interface DriverClient {
@GetMapping("/drivers/{id}")  
DriverDTO getDriverDetails(@PathVariable("id") int id);
}
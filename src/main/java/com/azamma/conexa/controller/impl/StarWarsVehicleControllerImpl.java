package com.azamma.conexa.controller.impl;

import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehicleResponseDTO;
import com.azamma.conexa.client.starwarsapi.dto.response.vehicles.VehiclesResponseDTO;
import com.azamma.conexa.controller.StarWarsVehicleController;
import com.azamma.conexa.service.StarWarsVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class StarWarsVehicleControllerImpl implements StarWarsVehicleController {

    @Autowired
    private StarWarsVehicleService starWarsVehiclesService;

    @Override
    @GetMapping()
    public ResponseEntity<VehiclesResponseDTO> getAllVehicles(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        VehiclesResponseDTO response = starWarsVehiclesService.getAllVehicles(page, limit);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> getVehicleById(@PathVariable int id) {
        VehicleResponseDTO response = starWarsVehiclesService.getVehicleById(id);
        return ResponseEntity.ok(response);
    }

}

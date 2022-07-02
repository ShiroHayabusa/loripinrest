package com.loripin.loripinrest.controller;

import com.loripin.loripinrest.model.Car;
import com.loripin.loripinrest.service.CarService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private final
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.findAll();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Car car = carService.getById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/cars/")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        HttpHeaders httpHeaders = new HttpHeaders();
        carService.save(car);
        return new ResponseEntity<>(car, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> editCar(@RequestBody Car car, @PathVariable Long id) {
        Car carFromDb = carService.getById(id);
        BeanUtils.copyProperties(car, carFromDb, "id");
        carService.save(carFromDb);
        return new ResponseEntity<>(carFromDb, HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

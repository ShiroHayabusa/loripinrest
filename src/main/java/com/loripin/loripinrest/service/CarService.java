package com.loripin.loripinrest.service;

import com.loripin.loripinrest.model.Car;
import com.loripin.loripinrest.repo.CarRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final
    CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public List<Car> findAll() {
        return carRepo.findAll();
    }

    public Car getById(Long id) {
        return carRepo.findById(id).get();
    }

    public Car save(Car car) {
        return carRepo.save(car);
    }

    public void delete(Long id) {
        carRepo.deleteById(id);
    }
}

package com.loripin.loripinrest.repo;

import com.loripin.loripinrest.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}

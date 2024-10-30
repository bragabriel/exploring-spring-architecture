package io.github.bragabriel.springarchitecture.automaker.api;

import io.github.bragabriel.springarchitecture.automaker.Car;
import io.github.bragabriel.springarchitecture.automaker.CarStatus;
import io.github.bragabriel.springarchitecture.automaker.Engine;
import io.github.bragabriel.springarchitecture.automaker.Key;
import io.github.bragabriel.springarchitecture.automaker.annotations.Combustion;
import io.github.bragabriel.springarchitecture.automaker.cars.HondaHRV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class FactoryController {

    @Autowired
    @Combustion
    //@Qualifier("turbineEngine")
    private Engine engine;

    @PostMapping
    public CarStatus startCar(@RequestBody Key key){
        Car car = new HondaHRV(engine);
        return car.startEngine(key);
    }
}

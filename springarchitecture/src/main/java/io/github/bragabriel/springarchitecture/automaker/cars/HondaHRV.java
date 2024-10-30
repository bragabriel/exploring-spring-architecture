package io.github.bragabriel.springarchitecture.automaker.cars;

import io.github.bragabriel.springarchitecture.automaker.Automaker;
import io.github.bragabriel.springarchitecture.automaker.Car;
import io.github.bragabriel.springarchitecture.automaker.Engine;

import java.awt.*;

public class HondaHRV extends Car {
    public HondaHRV(Engine engine) {
        super(engine);
        setModel("HRV");
        setColor(Color.BLACK);
        setAutomaker(Automaker.HONDA);
    }
}

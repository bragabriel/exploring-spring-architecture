package io.github.bragabriel.springarchitecture.automaker.configuration;

import io.github.bragabriel.springarchitecture.automaker.Engine;
import io.github.bragabriel.springarchitecture.automaker.EngineType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AutomakerConfiguration {

    @Primary
    @Bean(name = "combustionEngine")
    public Engine combustionEngine() {
        var engine = new Engine();
        engine.setHorsepower(120);
        engine.setCylinders(4);
        engine.setModel("XPTO-0");
        engine.setDisplacement(2.0);
        engine.setType(EngineType.COMBUSTION);
        return engine;
    }

    @Bean(name = "electricEngine")
    public Engine electricEngine() {
        var engine = new Engine();
        engine.setHorsepower(110);
        engine.setCylinders(3);
        engine.setModel("THO-10");
        engine.setDisplacement(1.4);
        engine.setType(EngineType.ELECTRIC);
        return engine;
    }

    @Bean(name = "turbineEngine")
    public Engine turbineEngine() {
        var engine = new Engine();
        engine.setHorsepower(180);
        engine.setCylinders(4);
        engine.setModel("XPTO-1");
        engine.setDisplacement(1.5);
        engine.setType(EngineType.TURBINE);
        return engine;
    }
}

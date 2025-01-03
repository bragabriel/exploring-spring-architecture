package io.github.bragabriel.springarchitecture.automaker.configuration;

import io.github.bragabriel.springarchitecture.automaker.Engine;
import io.github.bragabriel.springarchitecture.automaker.EngineType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Lazy(false) //Default = false
// if it is true = It will only be instantiated when the application uses it.
@Configuration
@Scope(BeanDefinition.SCOPE_SINGLETON) //Default Scope = Singleton
//"request", "prototype", "session", "application", "websocket"
public class AutomakerConfiguration {

    @Primary
    @Bean(name = "combustionEngine")
    @Scope("singleton")
    public Engine combustionEngine(@Value("${app.config.montadora.motor-padrao}") Integer horsePowers) {
        var engine = new Engine();
        engine.setHorsepower(horsePowers);
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

package unlar.edu.ar.ecoride_parcial.repositorio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import unlar.edu.ar.ecoride_parcial.model.BicicletaElectrica;
import unlar.edu.ar.ecoride_parcial.model.Monopatin;
import unlar.edu.ar.ecoride_parcial.tarifa.CriterioEstacional;

@Configuration
public class EstacionAnclajeConfig {

    @Bean
    public EstacionAnclaje estacionAnclaje() {
        EstacionAnclaje estacion = new EstacionAnclaje();

        // Datos de prueba con criterio estacional por defecto
        Monopatin m1 = new Monopatin("ABC123", 15, 2.50, false);
        m1.setCriterio(new CriterioEstacional());

        Monopatin m2 = new Monopatin("DEF456", 80, 3.00, true);
        m2.setCriterio(new CriterioEstacional());

        BicicletaElectrica b1 = new BicicletaElectrica("GHI789", 45, 1.80, 5, 100.0);
        b1.setCriterio(new CriterioEstacional());

        BicicletaElectrica b2 = new BicicletaElectrica("JKL012", 5, 4.50, 3, 80.0);
        b2.setCriterio(new CriterioEstacional());

        estacion.agregarVehiculo(m1);
        estacion.agregarVehiculo(m2);
        estacion.agregarVehiculo(b1);
        estacion.agregarVehiculo(b2);

        return estacion;
    }
}

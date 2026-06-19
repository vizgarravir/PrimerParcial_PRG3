package unlar.edu.ar.ecoride_parcial.tarifa;

import unlar.edu.ar.ecoride_parcial.model.Vehiculo;
import java.util.Comparator;

public class ComparadorTarifa implements Comparator<Vehiculo> {

    // Ordena por tarifaBase de mayor a menor (más caros primero)
    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        return Double.compare(v2.getTarifaBase(), v1.getTarifaBase());
    }
}

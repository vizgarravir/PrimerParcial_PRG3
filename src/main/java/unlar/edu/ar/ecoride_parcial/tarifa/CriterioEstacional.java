package unlar.edu.ar.ecoride_parcial.tarifa;

public class CriterioEstacional implements CriterioTarifa {

    @Override
    public double calcularCosto(int minutos, double tarifaBase) {
        return minutos * tarifaBase;
    }
}

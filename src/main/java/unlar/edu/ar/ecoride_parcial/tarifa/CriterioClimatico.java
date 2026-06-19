package unlar.edu.ar.ecoride_parcial.tarifa;

public class CriterioClimatico implements CriterioTarifa {

    private static final double RECARGO_SEGURO = 150.0;

    @Override
    public double calcularCosto(int minutos, double tarifaBase) {
        return (minutos * tarifaBase) + RECARGO_SEGURO;
    }
}

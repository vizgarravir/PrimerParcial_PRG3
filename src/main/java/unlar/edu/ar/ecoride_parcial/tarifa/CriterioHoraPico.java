package unlar.edu.ar.ecoride_parcial.tarifa;

public class CriterioHoraPico implements CriterioTarifa {

    @Override
    public double calcularCosto(int minutos, double tarifaBase) {
        double costoBase = minutos * tarifaBase;
        return costoBase + (costoBase * 0.40);
    }
}

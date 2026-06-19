package unlar.edu.ar.ecoride_parcial.tarifa;

public interface CriterioTarifa {
    double calcularCosto(int minutos, double tarifaBase);
}

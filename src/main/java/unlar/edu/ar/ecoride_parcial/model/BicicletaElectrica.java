package unlar.edu.ar.ecoride_parcial.model;

public class BicicletaElectrica extends Vehiculo {

    private int capacidadCanasto;
    private double capacidadBateria;

    public BicicletaElectrica(String patente, int porcentajeBateria, double tarifaBase,
                               int capacidadCanasto, double capacidadBateria) {
        super(patente, porcentajeBateria, tarifaBase);
        this.capacidadCanasto = capacidadCanasto;
        this.capacidadBateria = capacidadBateria;
    }

    public int getCapacidadCanasto() { return capacidadCanasto; }
    public double getCapacidadBateria() { return capacidadBateria; }
}

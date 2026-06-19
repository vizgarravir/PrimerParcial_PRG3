package unlar.edu.ar.ecoride_parcial.model;

public class Monopatin extends Vehiculo {

    private boolean tenenciaUnica;
    private boolean duranteReparacion;

    public Monopatin(String patente, int porcentajeBateria, double tarifaBase, boolean tenenciaUnica) {
        super(patente, porcentajeBateria, tarifaBase);
        this.tenenciaUnica = tenenciaUnica;
        this.duranteReparacion = false;
    }

    public boolean isTenenciaUnica() { return tenenciaUnica; }
    public boolean isDuranteReparacion() { return duranteReparacion; }
    public void setDuranteReparacion(boolean duranteReparacion) { this.duranteReparacion = duranteReparacion; }
}

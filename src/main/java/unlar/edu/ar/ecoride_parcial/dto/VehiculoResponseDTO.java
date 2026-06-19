package unlar.edu.ar.ecoride_parcial.dto;

public class VehiculoResponseDTO {

    private String patente;
    private String estadoActual;
    private int porcentajeBateria;
    private double tarifaBase;

    public VehiculoResponseDTO(String patente, String estadoActual, int porcentajeBateria, double tarifaBase) {
        this.patente = patente;
        this.estadoActual = estadoActual;
        this.porcentajeBateria = porcentajeBateria;
        this.tarifaBase = tarifaBase;
    }

    public String getPatente() { return patente; }
    public String getEstadoActual() { return estadoActual; }
    public int getPorcentajeBateria() { return porcentajeBateria; }
    public double getTarifaBase() { return tarifaBase; }
}

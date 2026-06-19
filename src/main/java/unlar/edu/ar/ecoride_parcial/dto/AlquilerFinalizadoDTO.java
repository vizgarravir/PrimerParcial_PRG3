package unlar.edu.ar.ecoride_parcial.dto;

public class AlquilerFinalizadoDTO {

    private String patente;
    private double costoFinalCalculado;
    private long tiempoTranscurridoMinutos;
    private String faseActualVehiculo;

    public AlquilerFinalizadoDTO(String patente, double costoFinalCalculado,
                                  long tiempoTranscurridoMinutos, String faseActualVehiculo) {
        this.patente = patente;
        this.costoFinalCalculado = costoFinalCalculado;
        this.tiempoTranscurridoMinutos = tiempoTranscurridoMinutos;
        this.faseActualVehiculo = faseActualVehiculo;
    }

    public String getPatente() { return patente; }
    public double getCostoFinalCalculado() { return costoFinalCalculado; }
    public long getTiempoTranscurridoMinutos() { return tiempoTranscurridoMinutos; }
    public String getFaseActualVehiculo() { return faseActualVehiculo; }
}

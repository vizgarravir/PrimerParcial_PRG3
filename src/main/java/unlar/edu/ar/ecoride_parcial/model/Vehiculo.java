package unlar.edu.ar.ecoride_parcial.model;

import unlar.edu.ar.ecoride_parcial.model.estado.EstadoEnEspera;
import unlar.edu.ar.ecoride_parcial.model.estado.EstadoVehiculo;
import unlar.edu.ar.ecoride_parcial.tarifa.CriterioTarifa;

public class Vehiculo implements Comparable<Vehiculo> {

    private String patente;
    private int porcentajeBateria;
    private double tarifaBase;
    private EstadoVehiculo estado;
    private CriterioTarifa criterio;

    public Vehiculo(String patente, int porcentajeBateria, double tarifaBase) {
        this.patente = patente;
        this.porcentajeBateria = porcentajeBateria;
        this.tarifaBase = tarifaBase;
        this.estado = new EstadoEnEspera();
    }

    // Delegación de transiciones al estado
    public void iniciarViaje() {
        estado.iniciarViaje(this);
    }

    public void finalizarViaje() {
        estado.finalizarViaje(this);
    }

    public void enviarReparacion() {
        estado.enviarReparacion(this);
    }

    public void terminarReparacion() {
        estado.terminarReparacion(this);
    }

    // Cálculo de tarifa usando Strategy
    public double calcularTarifa(int minutos) {
        if (criterio == null) {
            throw new IllegalStateException("No hay criterio de tarifa configurado.");
        }
        return criterio.calcularCosto(minutos, tarifaBase);
    }

    public void setCriterio(CriterioTarifa criterio) {
        this.criterio = criterio;
    }

    // Comparable natural: por porcentajeBateria ascendente (menor batería primero)
    @Override
    public int compareTo(Vehiculo otro) {
        return Integer.compare(this.porcentajeBateria, otro.porcentajeBateria);
    }

    // Getters y Setters
    public String getPatente() { return patente; }
    public int getPorcentajeBateria() { return porcentajeBateria; }
    public void setPorcentajeBateria(int porcentajeBateria) { this.porcentajeBateria = porcentajeBateria; }
    public double getTarifaBase() { return tarifaBase; }
    public void setTarifaBase(double tarifaBase) { this.tarifaBase = tarifaBase; }
    public EstadoVehiculo getEstado() { return estado; }
    public void setEstado(EstadoVehiculo estado) { this.estado = estado; }
    public CriterioTarifa getCriterio() { return criterio; }
}

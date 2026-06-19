package unlar.edu.ar.ecoride_parcial.model.estado;

import unlar.edu.ar.ecoride_parcial.model.Vehiculo;

public class EstadoEnViaje implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculo vehiculo) {
        throw new IllegalStateException("El vehiculo ya está en viaje.");
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        vehiculo.setEstado(new EstadoEnEspera());
    }

    @Override
    public void enviarReparacion(Vehiculo vehiculo) {
        throw new IllegalStateException("No se puede enviar a reparación un vehiculo en viaje.");
    }

    @Override
    public void terminarReparacion(Vehiculo vehiculo) {
        throw new IllegalStateException("El vehiculo no está en reparación.");
    }

    @Override
    public String getNombre() {
        return "EN_VIAJE";
    }
}

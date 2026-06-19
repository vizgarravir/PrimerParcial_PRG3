package unlar.edu.ar.ecoride_parcial.model.estado;

import unlar.edu.ar.ecoride_parcial.model.Vehiculo;

public class EstadoEnEspera implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculo vehiculo) {
        vehiculo.setEstado(new EstadoEnViaje());
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        throw new IllegalStateException("El vehiculo no está en viaje, no se puede finalizar.");
    }

    @Override
    public void enviarReparacion(Vehiculo vehiculo) {
        vehiculo.setEstado(new EstadoEnReparacion());
    }

    @Override
    public void terminarReparacion(Vehiculo vehiculo) {
        throw new IllegalStateException("El vehiculo no está en reparación.");
    }

    @Override
    public String getNombre() {
        return "EN_ESPERA";
    }
}

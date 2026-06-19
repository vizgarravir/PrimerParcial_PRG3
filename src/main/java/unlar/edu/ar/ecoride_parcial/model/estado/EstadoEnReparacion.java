package unlar.edu.ar.ecoride_parcial.model.estado;

import unlar.edu.ar.ecoride_parcial.model.Vehiculo;

public class EstadoEnReparacion implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculo vehiculo) {
        throw new IllegalStateException("El vehiculo está en reparación y no puede iniciar un viaje.");
    }

    @Override
    public void finalizarViaje(Vehiculo vehiculo) {
        throw new IllegalStateException("El vehiculo no está en viaje.");
    }

    @Override
    public void enviarReparacion(Vehiculo vehiculo) {
        throw new IllegalStateException("El vehiculo ya está en reparación.");
    }

    @Override
    public void terminarReparacion(Vehiculo vehiculo) {
        vehiculo.setEstado(new EstadoEnEspera());
    }

    @Override
    public String getNombre() {
        return "EN_REPARACION";
    }
}

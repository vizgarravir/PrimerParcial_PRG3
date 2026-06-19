package unlar.edu.ar.ecoride_parcial.model.estado;

import unlar.edu.ar.ecoride_parcial.model.Vehiculo;

public interface EstadoVehiculo {

    void iniciarViaje(Vehiculo vehiculo);
    void iniciarViaje(unlar.edu.ar.ecoride_parcial.model.Vehiculo vehiculo);
    void finalizarViaje(unlar.edu.ar.ecoride_parcial.model.Vehiculo vehiculo);
    void enviarReparacion(unlar.edu.ar.ecoride_parcial.model.Vehiculo vehiculo);
    void terminarReparacion(unlar.edu.ar.ecoride_parcial.model.Vehiculo vehiculo);
    String getNombre();
}

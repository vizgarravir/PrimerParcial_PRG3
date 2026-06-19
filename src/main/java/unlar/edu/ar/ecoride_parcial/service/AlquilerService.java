package unlar.edu.ar.ecoride_parcial.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.ecoride_parcial.dto.AlquilerFinalizadoDTO;
import unlar.edu.ar.ecoride_parcial.model.Vehiculo;
import unlar.edu.ar.ecoride_parcial.repositorio.EstacionAnclaje;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlquilerService {

    private final EstacionAnclaje estacion;
    // Guarda el tiempo de inicio del viaje: patente -> milliseconds
    private final Map<String, Long> viajesActivos = new HashMap<>();

    public AlquilerService(EstacionAnclaje estacion) {
        this.estacion = estacion;
    }

    public void desbloquearVehiculo(String patente) {
        Vehiculo v = obtenerVehiculoOFallar(patente);
        v.iniciarViaje();
        viajesActivos.put(patente, System.currentTimeMillis());
    }

    public AlquilerFinalizadoDTO finalizarAlquiler(String patente, int minutos) {
        Vehiculo v = obtenerVehiculoOFallar(patente);

        long tiempoMs = viajesActivos.getOrDefault(patente, System.currentTimeMillis());
        long tiempoTranscurrido = minutos > 0 ? minutos
                : (System.currentTimeMillis() - tiempoMs) / 60000;

        double costo = v.calcularTarifa((int) tiempoTranscurrido);
        v.finalizarViaje();
        viajesActivos.remove(patente);

        return new AlquilerFinalizadoDTO(
                patente,
                costo,
                tiempoTranscurrido,
                v.getEstado().getNombre()
        );
    }

    private Vehiculo obtenerVehiculoOFallar(String patente) {
        Vehiculo v = estacion.buscarPorPatente(patente);
        if (v == null) {
            throw new IllegalArgumentException("Vehículo no encontrado: " + patente);
        }
        return v;
    }
}

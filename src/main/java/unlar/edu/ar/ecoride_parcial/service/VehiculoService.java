package unlar.edu.ar.ecoride_parcial.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.ecoride_parcial.dto.VehiculoResponseDTO;
import unlar.edu.ar.ecoride_parcial.model.Vehiculo;
import unlar.edu.ar.ecoride_parcial.repositorio.EstacionAnclaje;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService {

    private final EstacionAnclaje estacion;

    public VehiculoService(EstacionAnclaje estacion) {
        this.estacion = estacion;
    }

    public List<VehiculoResponseDTO> obtenerOrdenadosPorCarga() {
        List<Vehiculo> ordenados = estacion.obtenerOrdenadosPorCarga();
        return mapearADTO(ordenados);
    }

    public List<VehiculoResponseDTO> obtenerOrdenadosPorTarifaDescendente() {
        List<Vehiculo> ordenados = estacion.obtenerOrdenadosPorTarifaDescendente();
        return mapearADTO(ordenados);
    }

    private List<VehiculoResponseDTO> mapearADTO(List<Vehiculo> vehiculos) {
        List<VehiculoResponseDTO> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            resultado.add(new VehiculoResponseDTO(
                    v.getPatente(),
                    v.getEstado().getNombre(),
                    v.getPorcentajeBateria(),
                    v.getTarifaBase()
            ));
        }
        return resultado;
    }
}

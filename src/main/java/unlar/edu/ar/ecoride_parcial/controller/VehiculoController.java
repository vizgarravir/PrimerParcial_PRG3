package unlar.edu.ar.ecoride_parcial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unlar.edu.ar.ecoride_parcial.dto.VehiculoResponseDTO;
import unlar.edu.ar.ecoride_parcial.service.VehiculoService;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    /**
     * Reporte de vehículos ordenados por prioridad de carga (batería ASC - menor primero).
     * Usa el Comparable natural de Vehiculo.
     * GET /api/vehiculos/prioridad-carga
     */
    @GetMapping("/prioridad-carga")
    public ResponseEntity<List<VehiculoResponseDTO>> prioridadCarga() {
        return ResponseEntity.ok(vehiculoService.obtenerOrdenadosPorCarga());
    }

    /**
     * Reporte de vehículos ordenados por tarifa base DESC (más caros primero).
     * Usa el Comparator externo ComparadorTarifa.
     * GET /api/vehiculos/tarifa-descendente
     */
    @GetMapping("/tarifa-descendente")
    public ResponseEntity<List<VehiculoResponseDTO>> tarifaDescendente() {
        return ResponseEntity.ok(vehiculoService.obtenerOrdenadosPorTarifaDescendente());
    }
}

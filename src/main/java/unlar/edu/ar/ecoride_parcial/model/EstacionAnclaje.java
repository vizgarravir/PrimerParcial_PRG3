package unlar.edu.ar.ecoride_parcial.repositorio;

import unlar.edu.ar.ecoride_parcial.model.Vehiculo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstacionAnclaje {

    // HashMap para O(1) en búsqueda por patente
    private final Map<String, Vehiculo> vehiculos = new HashMap<>();

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.put(vehiculo.getPatente(), vehiculo);
    }

    public Vehiculo buscarPorPatente(String patente) {
        return vehiculos.get(patente);
    }

    public List<Vehiculo> obtenerTodos() {
        return new ArrayList<>(vehiculos.values());
    }

    /**
     * Ordenamiento natural (Comparable): por porcentaje de batería ASC (menor primero).
     * Usa Collections.sort que aplica el compareTo de Vehiculo.
     */
    public List<Vehiculo> obtenerOrdenadosPorCarga() {
        List<Vehiculo> lista = obtenerTodos();
        Collections.sort(lista);
        return lista;
    }

    /**
     * Ordenamiento externo (Comparator): por tarifaBase DESC (más caros primero).
     * No altera ni usa el criterio natural del vehículo.
     */
    public List<Vehiculo> obtenerOrdenadosPorTarifaDescendente() {
        List<Vehiculo> lista = obtenerTodos();
        Collections.sort(lista, new unlar.edu.ar.ecoride_parcial.tarifa.ComparadorTarifa());
        return lista;
    }

    public int cantidadVehiculos() {
        return vehiculos.size();
    }
}

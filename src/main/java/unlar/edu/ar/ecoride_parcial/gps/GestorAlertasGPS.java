package unlar.edu.ar.ecoride_parcial.gps;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestorAlertasGPS {

    /**
     * Deduplicación en una sola pasada usando HashSet.
     * O(n) tiempo, O(n) espacio — sin bucles anidados.
     */
    public Set<Coordenada> limpiarDuplicados(List<Coordenada> reportes) {
        Set<Coordenada> unicos = new HashSet<>();
        for (Coordenada c : reportes) {
            unicos.add(c);
        }
        return unicos;
    }
}

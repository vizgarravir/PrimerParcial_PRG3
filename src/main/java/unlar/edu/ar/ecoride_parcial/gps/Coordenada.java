package unlar.edu.ar.ecoride_parcial.gps;

import java.util.Objects;

public class Coordenada {

    private final double latitud;
    private final double longitud;

    public Coordenada(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenada)) return false;
        Coordenada that = (Coordenada) o;
        return Double.compare(that.latitud, latitud) == 0
                && Double.compare(that.longitud, longitud) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }

    @Override
    public String toString() {
        return "(" + latitud + ", " + longitud + ")";
    }
}
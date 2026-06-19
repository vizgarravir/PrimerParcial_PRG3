# Anexo Técnico de Rendimiento — EcoRide Pro

## 1. Por qué la nueva estructura de búsqueda es más rápida que la búsqueda lineal anterior

En la versión anterior, la lista de vehículos se recorría secuencialmente de punta a punta para encontrar un vehículo por patente. En el peor caso esto requería comparar contra **todos** los elementos: complejidad **O(n)**.

En la versión actual, `EstacionAnclaje` almacena los vehículos en un `HashMap<String, Vehiculo>` donde la clave es la patente. La operación `vehiculos.get(patente)` calcula el hash de la clave y accede directamente al bucket correspondiente, sin recorrer ninguna lista. Esto da un tiempo de respuesta **O(1) constante**, independientemente de si hay 10 o 100.000 vehículos registrados.

---

## 2. Cómo el algoritmo de deduplicación de alertas GPS evita el problema de los bucles anidados

El enfoque naive compara cada coordenada contra todas las demás para detectar duplicados:
```
for cada reporte A:
    for cada reporte B:
        si A == B: ignorar
```
Esto es **O(n²)**, inaceptable con miles de coordenadas.

La implementación de `GestorAlertasGPS.limpiarDuplicados()` usa un `HashSet<Coordenada>`. La clase `Coordenada` implementa correctamente `equals()` y `hashCode()` basándose en latitud y longitud. Al insertar cada elemento en el set con `unicos.add(c)`, el `HashSet` detecta automáticamente si el elemento ya existe mediante el hash — todo en una sola pasada. Complejidad: **O(n)** tiempo, **O(n)** espacio. Sin bucles anidados.

---

## 3. Cómo se resolvió el ordenamiento natural sin romper la posibilidad de ordenar por tarifas de forma concurrente en memoria

Se aplicaron **dos mecanismos de comparación independientes**:

- **Comparable intrínseco** (`Vehiculo implements Comparable<Vehiculo>`): el método `compareTo()` define el orden natural por `porcentajeBateria` ascendente. Esto es lo que usa `Collections.sort(lista)` sin argumentos adicionales. Este criterio es parte del modelo del negocio: la prioridad operativa de la flota.

- **Comparator externo** (`ComparadorTarifa implements Comparator<Vehiculo>`): es un objeto separado, desacoplado del modelo, que implementa la comparación por `tarifaBase` descendente. Se pasa explícitamente a `Collections.sort(lista, new ComparadorTarifa())`.

Ambos ordenamientos coexisten en memoria sin interferencia: `obtenerOrdenadosPorCarga()` produce una copia de la lista ordenada por batería, y `obtenerOrdenadosPorTarifaDescendente()` produce otra copia ordenada por tarifa. El `HashMap` subyacente nunca se modifica; cada método de ordenamiento trabaja sobre su propia lista independiente. Esto garantiza consistencia de datos y correcta separación de responsabilidades.

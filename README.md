# Modelo Depredador-Presa en Java

Este proyecto implementa una simulación del modelo depredador-presa en Java. 
La simulación calcula las interacciones entre dos poblaciones (depredadores y presas) en un ecosistema, 
considerando parámetros como tasas de natalidad, mortalidad, índices de caza y alimentación, y la capacidad máxima del ecosistema.

## Estructura del Proyecto

### Archivos principales:
- **Main.java**: Contiene la lógica principal para inicializar y ejecutar la simulación. Permite al usuario introducir los parámetros de la simulación y muestra los resultados en la consola.
- **Dato.java**: Modelo que representa el estado de las poblaciones y sus cambios en cada ciclo de simulación. Calcula las variaciones en las poblaciones basadas en los parámetros proporcionados.

## Cómo funciona

1. **Inicialización del programa**:
    - Se solicita al usuario que introduzca los parámetros de la simulación, como tasas de natalidad y mortalidad, índices de caza y alimentación, y el número inicial de depredadores y presas.
    - El usuario también define el número de años para la simulación.

2. **Cálculo de los datos**:
    - Cada año, se calculan las variaciones en las poblaciones utilizando las fórmulas establecidas en `Dato.java`.
    - Los resultados de cada año se almacenan en un array de objetos `Dato`.

3. **Salida de datos**:
    - Se imprimen los resultados de cada año, mostrando el número de depredadores, presas, natalidad, mortalidad, presas cazadas, depredadores hambrientos, diff depredador, diff presa.

## Ejemplo de salida

```
Tiempo: 2017, Depredador: 150, Presa: 4000, Natalidad depredador: 22, Moratalida depredador: 7, Presa natalidad: 2000, Presa mortalidad: 3200, Presa cazada: 1200, Depredador hambriento 0, Diff depredador: 15, Diff presa: -2400.
Tiempo: 2018, Depredador: 165, Presa: 1600, Natalidad depredador: 24, Moratalida depredador: 8, Presa natalidad: 800, Presa mortalidad: 512, Presa cazada: 528, Depredador hambriento 0, Diff depredador: 16, Diff presa: -240.
Tiempo: 2019, Depredador: 181, Presa: 1360, Natalidad depredador: 27, Moratalida depredador: 9, Presa natalidad: 680, Presa mortalidad: 369, Presa cazada: 492, Depredador hambriento 0, Diff depredador: 18, Diff presa: -181.
Tiempo: 2020, Depredador: 199, Presa: 1179, Natalidad depredador: 29, Moratalida depredador: 9, Presa natalidad: 589, Presa mortalidad: 278, Presa cazada: 469, Depredador hambriento 0, Diff depredador: 20, Diff presa: -158.
```

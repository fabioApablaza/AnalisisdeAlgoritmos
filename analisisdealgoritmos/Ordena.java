/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdealgoritmos;

/**
 *
 * @author Apablaza
 */
public class Ordena {

    /**
     * Metodo de ordenamiento Burbuja
     *
     * @param a Pre: array de enteros desordenado. Post: array ordenado
     */
    public static void burbuja(int[] a) {
        int temp = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < (a.length - 1); j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * Metodo de ordenamiento Burbuja Mejorado
     *
     * @param a Pre: array de enteros desordenado. Post: array ordenado
     */
    public static void burbujaMejorado(int[] a) {
        boolean orden = false;
        int longitud = a.length - 1, i = 0, temp;
        while (i < longitud && (!orden)) {
            orden = true;
            for (int j = 0; j < longitud - 1; j++) {
                if (a[j] > a[j + 1]) {
                    orden = false;
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
            i++;
        }

    }

    /**
     * Metodo de ordenamiento por selección
     *
     * @param a Pre: array de enteros desordenado. Post: array ordenado
     */
    public static void seleccion(int[] a) {
        int i, j, menor, pos, temp;
        for (i = 0; i < a.length - 1; i++) { // tomamos como menor el primero
            menor = a[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (j = i + 1; j < a.length; j++) { // buscamos en el resto
                if (a[j] < menor) { // del array algún elemento
                    menor = a[j]; // menor que el actual
                    pos = j;
                }
            }
            if (pos != i) { // si hay alguno menor se intercambia
                temp = a[i];
                a[i] = a[pos];
                a[pos] = temp;
            }
        }
    }

    /**
     * Metodo de ordenamiento por inserción directa
     *
     * @param a Pre: array de enteros desordenado. Post: array ordenado
     */
    public static void insercion(int[] a) {
        int n = a.length, temp, j;
        for (int i = 1; i < n; i++) {
            j = i;
            while (j > 0 && a[j] < a[j - 1]) {
                temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }
    }

    /**
     * Metodo de ordenamiento quicksort
     *
     * @param a Pre: array de enteros desordenado. Post: array ordenado
     */
    public static void quicksort(int[] a) {
        quicksortR(a, 0, (a.length - 1));
    }

    public static void quicksortR(int a[], int izq, int der) {

        int pivote = a[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int temp;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (a[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote
            }
            while (a[j] > pivote) {
                j--;         // busca elemento menor que pivote
            }
            if (i < j) {                      // si no se han cruzado                      
                temp = a[i];                  // los intercambia
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[izq] = a[j]; // se coloca el pivote en su lugar de forma que tendremos
        a[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            quicksortR(a, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksortR(a, j + 1, der); // ordenamos subarray derecho
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 9, 4, 7, 3, 8, 2, 1, 6};

        quicksort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
    /*El mejor es quicksort, ya que en el mejor de los casos (cuando el pivote queda en el centro) tiene un orden de O(n·log n)
     y en el peor (cuando el pivote queda en un extremo del arreglo) es de O(n²). La cantidad de recorridas que le da al arreglo, la cantidad de recursos que usa del sistema*/

}

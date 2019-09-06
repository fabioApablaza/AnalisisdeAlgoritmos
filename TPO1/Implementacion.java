/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Apablaza
 */
public class Implementacion {

    public static void burbuja(int[] a) {
        for (int i = 0; i <= a.length - 2; i++) {
            for (int j = 0; j <= a.length - 2 - i; j++) {
                if (a[j + 1] < a[j]) {
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;

                }

            }
        }
    }

    private static int[] obtenerValorMinMax(int[] arr) {
        int[] aux = new int[2];
        if (arr.length >= 2) {
            aux[0] = arr[0];
            aux[1] = arr[1];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < aux[0]) {
                    aux[0] = arr[i];
                } else if (arr[i] > aux[1]) {
                    aux[1] = arr[i];
                }
            }
        } else {
            aux[0] = arr[0];
            aux[1] = arr[0];
        }

        return aux;
    }

    public static void bucketsort(int[] ar) {
        int[] valores = obtenerValorMinMax(ar);
        int minVal = valores[0];
        int maxVal = valores[1];

        int n = ar.length; // n es el numero de elementos
        int m = maxVal - minVal; // m es el rango de valores
        int cantBuckets = m / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(cantBuckets);
        for (int i = 0; i < cantBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Ubicar cada elemento en un bucket
        for (int i = 0; i < n; i++) {
            int bi = (ar[i] - minVal) / m;
            List<Integer> bucket = buckets.get(bi);
            bucket.add(ar[i]);
        }

        // Ordenar los buckets y mezclarlos en un solo arreglo
        for (int bi = 0, j = 0; bi < cantBuckets; bi++) {
            List<Integer> bucket = buckets.get(bi);
            if (bucket != null) {
                Object[] lista = bucket.toArray();
                int[] listaInt = Arrays.stream(lista).mapToInt(o -> (int) o).toArray();
                if (listaInt.length > 1) {
                    burbuja(listaInt);
                }
                for (int k = 0; k < listaInt.length; k++) {
                    ar[j++] = listaInt[k];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {14, 30, 55, 83, 24, 52, 11, 46};// 5 3 10 11 24 52 11        
        bucketsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

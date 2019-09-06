/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1;

/**
 *
 * @author Apablaza
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ordena {

    public static void burbuja(int[] a) {
        for (int i = 0; i <= a.length - 2; i++) {
            for (int j = 0; j <= a.length - 2 - i; j++) {
                if (sumaDigitos(a[j + 1]) < sumaDigitos(a[j])) {
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;

                }
                if (sumaDigitos(a[j + 1]) == sumaDigitos(a[j])) {
                    if (a[j + 1] < a[j]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }

                }
            }
        }
    }

    public static void burbujaMejorado(int[] a) {
        int i = 0, j, bandera = 1, aux;
        while (i <= a.length - 2 && bandera == 1) {
            bandera = 0;
            for (j = 0; j <= a.length - 2 - i; j++) {
                if (a[j + 1] < a[j]) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;
                    bandera = 1;
                }
            }
            i++;
        }
    }

    public static void seleccion(int[] a) {
        int i, j, min;
        for (i = 0; i <= a.length - 2; i++) {
            min = i;
            for (j = i + 1; j <= a.length - 1; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int aux = a[i];
            a[i] = a[min];
            a[min] = aux;
        }
    }

    public static void insercion(int[] a) {
        int p;
        for (p = 0; p <= a.length - 1; p++) {
            int temp = a[p];
            int j = p;
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j = j - 1;
            }
            a[j] = temp;
        }
    }

    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static void quicksort(int[] a, int izq, int der) {
        int pivote = sumaDigitos(a[izq]);
        int k = particion(a, izq, der, pivote);
        if (izq < k - 1) {
            quicksort(a, izq, k - 1);
        }
        if (k + 1 < der) {
            quicksort(a, k + 1, der);
        }
    }

    private static int particion(int[] a, int izq, int der, int pivote) {
        int i = izq;
        int j = der;
        int aux;
        while (i < j) {
            while (sumaDigitos(a[i]) <= pivote && i < j) {
                i++;
            }
            while (sumaDigitos(a[j]) > pivote) {
                j--;
            }
            if (i < j) {
                aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
        }
        a[izq] = a[j];
        a[j] = pivote;
        return j;
    }

    public static void mergesort(int[] a) {
        mergesort(a, 0, a.length - 1);
    }

    private static void mergesort(int[] a, int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(a, izq, m);
            mergesort(a, m + 1, der);
            merge(a, izq, m, der);
        }
    }

    private static void merge(int A[], int izq, int m, int der) {
        int i, j, k;
        int[] B = new int[A.length];
        for (i = izq; i <= der; i++) {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) {
            A[k++] = B[i++];
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
        int[] temp=arregloSuma(ar);
        int[] valores = obtenerValorMinMax(temp);
        int minVal = valores[0];
        int maxVal = valores[1];


        int n = ar.length; // n es el numero de elementos
        int m = maxVal - minVal+1; // m es el rango de valores
        int cantBuckets = m / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(cantBuckets);
        for (int i = 0; i < cantBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // Ubicar cada elemento en un bucket
        for (int i = 0; i < n; i++) {
            int bi = (temp[i] - minVal) / m;
            //System.out.println(buckets.size()+" n: "+n+" bi: "+bi);
            if(bi==buckets.size()){
                bi--;
            }
            List<Integer> bucket = buckets.get(bi);
            bucket.add(ar[i]);
        }

        // Ordenar los buckets y mezclarlos en un solo arreglo
        for (int bi = 0, j=0; bi < cantBuckets; bi++) {
            List<Integer> bucket = buckets.get(bi);
            if (bucket != null) {
                //Collections.sort(bucket);
                Object[] lista = bucket.toArray();
                int[] listaInt = Arrays.stream(lista).mapToInt(o -> (int)o).toArray();
                if(listaInt.length>1){
                    burbuja(listaInt);
                }
                for (int k = 0; k < listaInt.length; k++) {
                    ar[j++] = listaInt[k];
                }
            }
        }
    }
    public static int sumaDigitos(int num) {
        int temp=0;
        while (num>1) {
            temp = temp+num % 10;
            num= num/10;
        }        
            temp = temp+num % 10;
        return temp;
    }
    public static int[] arregloSuma(int[] arr){
        int[] temp= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=sumaDigitos(arr[i]);
        }
        return temp;
    } 
    
    public static void main(String[] args) {
        
        int[] arr = {14,30,55,83,24,52,11,46};// 5 3 10 11 24 52 11
        
        bucketsort(arr);
        int[] arr2 =arregloSuma(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }        
        System.out.println(" ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
    }
}

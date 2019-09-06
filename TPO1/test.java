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
public class test {

    public static void main(String[] args) {
        int[] arr = {32, 33, 24, 40, 55, 14}, temp;// 5 6 6 4 10
        //System.out.println("main "+sumaDigitos(123445));        
        burbuja(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println(" ");
        temp = arregloSuma(arr);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
            System.out.print(" ");
        }
    }

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

    public static int[] arregloSuma(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = sumaDigitos(arr[i]);
        }
        return temp;
    }

    public static int sumaDigitos(int num) {
        int temp = 0;
        while (num > 1) {
            temp = temp + num % 10;
            num = num / 10;
        }
        temp = temp + num % 10;
        return temp;
    }

    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static void quicksort(int[] a, int izq, int der) {
        int pivote = sumaDigitos(a[izq]);
        int k = particion(a, izq, der, pivote, a[izq]);
        if (izq < k - 1) {
            quicksort(a, izq, k - 1);
        }
        if (k + 1 < der) {
            quicksort(a, k + 1, der);
        }
    }

    private static int particion(int[] a, int izq, int der, int pivote, int piv) {
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
        a[j] = piv;
        return j;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inout;

/**
 *
 * @author Apablaza
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;


public class RandomInts {
    static final int CANTNUMEROS = 15000;
    static final int MAX_VALOR = 10000;
    static final String NOMBRE_ARCHIVO = "src/inout/numeros.txt";

    private static void generarArchivo(){
    	try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    		Random generador = new Random();
    		for (int i = 0; i < CANTNUMEROS ; i++){
    			int num = generador.nextInt(MAX_VALOR);
    			buff.write( num +"\n");
    		}
    		buff.close();

    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static int[] leerArchivo(){
    	int [] arreglo = new int[CANTNUMEROS];
    	try{
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
    		for (int i = 0; i < CANTNUMEROS  ; i++)	arreglo[i] = Integer.parseInt(buff.readLine());
    		buff.close();
    	}
    	catch (FileNotFoundException ex) {
    		System.err.println(ex.getMessage() + "\nEl archivo de lectura no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    	return arreglo;
    }
    public static void main(String[] args) {
    	
    	generarArchivo();
    }
}

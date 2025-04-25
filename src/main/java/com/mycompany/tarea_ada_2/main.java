/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea_ada_2;

/**
 *
 * @author Sistema
 */
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Ingrese el tamaño de la secuencia: ");
        int n = scanner.nextInt();

       
        int[] numeros = new int[n];

     
        System.out.println("Ingrese los numeros de la secuencia (pueden ser positivos o negativos): ");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }

     
        Resultado resultado = maxSubsecuencia(numeros);

      
        System.out.println("La suma maxima es: " + resultado.suma);
        System.out.println("Subsecuencia que da la suma maxima: ");
        for (int i = resultado.inicio; i <= resultado.fin; i++) {
            System.out.print(numeros[i] + " ");
        }

       
        scanner.close();
    }

    public static Resultado maxSubsecuencia(int[] nums) {
        int n = nums.length;

      
        int maxSuma = nums[0];
        int sumaActual = nums[0];
        int inicio = 0;
        int fin = 0;
        int tempInicio = 0;

        for (int i = 1; i < n; i++) {
            if (sumaActual + nums[i] < nums[i]) {
                sumaActual = nums[i];
                tempInicio = i;
            } else {
                sumaActual += nums[i];
            }

            if (sumaActual > maxSuma) {
                maxSuma = sumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }

        return new Resultado(maxSuma, inicio, fin);
    }

 
    static class Resultado {
        int suma;
        int inicio;
        int fin;

        Resultado(int suma, int inicio, int fin) {
            this.suma = suma;
            this.inicio = inicio;
            this.fin = fin;
        }
    }
}
package com.exemple0102;

import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         // Boolean: només pot ser "true" o "false"
//         boolean esDilluns = true;
//         System.out.println("Boolean: " + esDilluns);
        
//         // Char: Guarda un sol caràcter 
//         // (lletra, número o símbol).
//         char lletra = 'a';
//         System.out.println("Char: " + lletra);
        
//         // String: Guarda una cadena de text
//         // (més d'un caràcter).
//         String text = "Hola";
//         System.out.println("String: " + text);
        
//         // Int: Guarda números enters.
//         int numero = 45;
//         System.out.println("Int: " + numero);
        
//         // Float: Guarda números decimals
//         float preu = 32.5f;
//         System.out.println("Float: " + preu);
//     }
// }

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Llegir informació del teclat
        // i guardar-la en una variable 'nom'
        System.out.print("Escriu un nombre: ");
        String nombreString = scanner.nextLine();
        
        int nombre = Integer.parseInt(nombreString);
        

        System.out.println("La teva edat en anys de gos són,");
        
        // Tancar la lectura del teclat
        scanner.close();
    }
}

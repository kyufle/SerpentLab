package com.exemple0103;

import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         // Iniciar la capacitat de llegir informació del teclat
//         Scanner scanner = new Scanner(System.in);

//         // Demanar l'edat com un String
//         System.out.print("Escriu la teva edat: ");
//         String edatString = scanner.nextLine();

//         // Convertir el String a un enter
//         int edat = Integer.parseInt(edatString);

//         // Mostrar el resultat
//         System.out.println("Hola, tens " + edat + " anys!");

//         // Tancar la lectura del teclat
//         scanner.close();
//     }
// }

public class Main {
    public static void main(String[] args) {
        // Iniciar la capacitat de llegir informació del teclat
        Scanner scanner = new Scanner(System.in);

        // Demanar l'edat com un String
        System.out.print("Escriu el nom d'un país: ");
        String paisString = scanner.nextLine();
        System.out.print("Escriu el nom d'una ciutat: ");
        String ciutatString= scanner.nextLine();
        System.out.print("Escriu el nombre d'habitats: ");
        String habitats= scanner.nextLine();

        // Convertir el String a un enter
        int habitant = Integer.parseInt(habitats);

        // Mostrar el resultat
        System.out.println("\""ciutatString"és una ciutat situada a"+paisString+"amb");

        // Tancar la lectura del teclat
        scanner.close();
    }
}
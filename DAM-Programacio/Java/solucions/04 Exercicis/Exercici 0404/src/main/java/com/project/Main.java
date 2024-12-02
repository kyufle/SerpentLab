package com.project;

public class Main {
    public static void main(String[] args) {
        // Creació d'estudiants
        Estudiant estudiant1 = new Estudiant("Joan", 20);
        Estudiant estudiant2 = new Estudiant("Maria", 19);

        // Actualització de la nota mitjana
        estudiant1.actualitzaNotaMitjana(9.5);
        estudiant2.actualitzaNotaMitjana(8.0);

        // Creació del curs i afegiment d'estudiants
        Curs curs = new Curs("Matemàtiques", "Sr. Albert");
        curs.afegeixEstudiant(estudiant1);
        curs.afegeixEstudiant(estudiant2);

        // Mostrar estudiants del curs
        curs.mostraEstudiants();
    }
}

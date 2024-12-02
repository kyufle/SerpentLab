package com.project;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestMain {

    @Test
    public void testMainOutput() throws Exception {
        // Redirigeix la sortida estàndard a un flux de sortida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Executa el main per a provar la seva sortida
        String[] args = {}; // Passa els arguments necessaris si n'hi ha
        Main.main(args);

        // Restaura els fluxos originals
        System.setOut(originalOut);

        // Comprova que la sortida conté el text esperat
        String text = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
        String expectedOutput = "Electrodomèstic de la marca Samsung amb un consum energètic de 120 watts.\n" +
            "Aquesta nevera té una capacitat de 350 litres.\n" +
            "Electrodomèstic de la marca LG amb un consum energètic de 200 watts.\n" +
            "Aquesta rentadora té una capacitat de càrrega de 8 kg.\n";
        String diff = TestStringUtils.findFirstDifference(text, expectedOutput);
        assertTrue(diff.compareTo("identical") == 0, 
            "\n>>>>>>>>>> >>>>>>>>>>\n" +
            diff +
            "<<<<<<<<<< <<<<<<<<<<\n");
    }

    @Test
    public void testMainValidation() throws Exception {
        // Crea objectes de prova amb dades diferents
        Electrodomestic microones = new Electrodomestic("Panasonic", 800);
        Nevera nevera = new Nevera("Bosch", 150, 250);
        Rentadora rentadora = new Rentadora("Samsung", 180, 5);
    
        // Comprova les propietats de la classe base Electrodomestic
        assertEquals("Panasonic", microones.marca, "La marca de l'electrodomèstic no coincideix");
        assertEquals(800, microones.consumEnergetic, "El consum energètic de l'electrodomèstic no coincideix");
    
        // Comprova la sortida del mètode mostrarInformacio per a Electrodomestic
        String expectedOutputMicroones = "Electrodomèstic de la marca Panasonic amb un consum energètic de 800 watts.";
        ByteArrayOutputStream outContentMicroones = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentMicroones));
        System.out.println(microones);
        String outputMicroones = outContentMicroones.toString().trim();
        System.setOut(System.out);
        assertTrue(outputMicroones.equals(expectedOutputMicroones), "La sortida de mostrarInformacio per Electrodomestic no és l'esperada");
    
        // Comprova les propietats i el mètode mostrarInformacio de Nevera
        assertEquals("Bosch", nevera.marca, "La marca de la nevera no coincideix");
        assertEquals(150, nevera.consumEnergetic, "El consum energètic de la nevera no coincideix");
        assertEquals(250, nevera.getCapacitat(), "La capacitat de la nevera no coincideix");
    
        String expectedOutputNevera = expectedOutputMicroones.replace("Panasonic", "Bosch").replace("800", "150") + "\nAquesta nevera té una capacitat de 250 litres.";
        ByteArrayOutputStream outContentNevera = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentNevera));
        System.out.println(nevera);
        String outputNevera = outContentNevera.toString().trim();
        System.setOut(System.out);
        assertTrue(outputNevera.equals(expectedOutputNevera), "La sortida de mostrarInformacio per Nevera no és l'esperada");
    
        // Comprova les propietats i el mètode mostrarInformacio de Rentadora
        assertEquals("Samsung", rentadora.marca, "La marca de la rentadora no coincideix");
        assertEquals(180, rentadora.consumEnergetic, "El consum energètic de la rentadora no coincideix");
        assertEquals(5, rentadora.getCapacitat(), "La capacitat de càrrega de la rentadora no coincideix");
    
        String expectedOutputRentadora = "Electrodomèstic de la marca Samsung amb un consum energètic de 180 watts.\nAquesta rentadora té una capacitat de càrrega de 5 kg.";
        ByteArrayOutputStream outContentRentadora = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentRentadora));
        System.out.println(rentadora);
        String outputRentadora = outContentRentadora.toString().trim();
        System.setOut(System.out);
        assertTrue(outputRentadora.equals(expectedOutputRentadora), "La sortida de mostrarInformacio per Rentadora no és l'esperada");
    }
    
    @Test
    public void testMainPrivateAttributes() {
        // Obtenim tots els camps de la classe Electrodomestic
        Field[] fields = Electrodomestic.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui protected
        for (Field field : fields) {
            assertTrue(Modifier.isProtected(field.getModifiers()), "El camp " + field.getName() + " (Electrodomestic) hauria de ser protected");
        }

        // Obtenim tots els camps de la classe Nevera
        fields = Nevera.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Nevera) hauria de ser privat");
        }

        // Obtenim tots els camps de la classe Rentadora
        fields = Rentadora.class.getDeclaredFields();

        // Iterem per cada camp per verificar que sigui privat
        for (Field field : fields) {
            assertTrue(Modifier.isPrivate(field.getModifiers()), "El camp " + field.getName() + " (Rentadora) hauria de ser privat");
        }
    }
}

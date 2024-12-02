package com.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class TestMain {

    @Test
    public void testEdatsOrdenades() throws Exception {
        Locale defaultLocale = Locale.getDefault(); // Guarda la configuració regional per defecte
        Locale.setDefault(Locale.US); // Estableix la configuració regional a US

        try {
            String[] inputs = {
                "25\n18\n30\n",
                "30\n25\n18\n",
                "18\n30\n25\n",
                "22\n22\n22\n",
                "40\n20\n30\n"
            };
            String[] expectedOutputs = {
                "Introdueix la primera edat: Introdueix la segona edat: Introdueix la tercera edat: Les edats ordenades són 18, 25, 30\n",
                "Introdueix la primera edat: Introdueix la segona edat: Introdueix la tercera edat: Les edats ordenades són 18, 25, 30\n",
                "Introdueix la primera edat: Introdueix la segona edat: Introdueix la tercera edat: Les edats ordenades són 18, 25, 30\n",
                "Introdueix la primera edat: Introdueix la segona edat: Introdueix la tercera edat: Les edats ordenades són 22, 22, 22\n",
                "Introdueix la primera edat: Introdueix la segona edat: Introdueix la tercera edat: Les edats ordenades són 20, 30, 40\n"
            };

            for (int i = 0; i < inputs.length; i++) {
                String input = inputs[i];
                String expectedOutput = expectedOutputs[i];

                // Redirigeix la sortida estàndard a un flux de sortida
                ByteArrayOutputStream outContent = new ByteArrayOutputStream();
                PrintStream originalOut = System.out;
                System.setOut(new PrintStream(outContent));

                // Simula l'entrada de l'usuari
                System.setIn(new ByteArrayInputStream(input.getBytes()));

                // Executa el main per a provar la seva sortida
                Main.main(new String[]{});

                // Comprova que la sortida conté el text esperat
                String actualOutput = outContent.toString().replace("\r\n", "\n"); // Normalitza les noves línies
                String diff = TestStringUtils.findFirstDifference(actualOutput, expectedOutput);
                assertTrue(diff.compareTo("identical") == 0,
                    "\n>>>>>>>>>> >>>>>>>>>>\n" +
                    diff +
                    "<<<<<<<<<< <<<<<<<<<<\n");

                // Restaura els fluxos originals
                System.setOut(originalOut);
            }
        } finally {
            Locale.setDefault(defaultLocale); // Restaura la configuració regional per defecte
        }
    }
}

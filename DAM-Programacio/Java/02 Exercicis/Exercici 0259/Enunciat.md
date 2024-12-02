<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 59

Fes un programa que mostri el següent menú:
```text
    CALCULADORA
    Menú Principal

    1 - Sumar
    2 - Restar
    3 - Multiplicar
    4 - Dividir
    0 - Sortir
    Opció: 
```
L'usuari escriu el número d'opció, si s'escull una opció no coneguda 
es mostra el menú de nou amb el text "Opció incorrecta" a sobre de la línia "Opció: "

Un cop escollida una

* Si és la 0 s'acaba el programa.
* Si és una altra, demana dos números i mostra el resultat de l'operació.

Fes les següents funcions:
```java
    public static void mostrarMenu() {
    // Mostra el menú per pantalla
    }

    public static void operar(Scanner scanner, String operacio) {
    // Crida a obtenirNumeros i realitza la operació
    // finalment mostra el resultat amb: "El resultat de %s %f i %f és: %f\n"
    }

    public static double[] obtenirNumeros(Scanner scanner) {
    // Obté els números des de l'entrada de teclat
    }
```

Exemple:
```text
    CALCULADORA
    Menú Principal
    1 - Sumar
    2 - Restar
    3 - Multiplicar
    4 - Dividir
    0 - Sortir
Opció: 2
Introdueix el primer número: 4
Introdueix el segon número: 7
El resultat de Restar 4.000000 i 7.000000 és: -3.000000
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```
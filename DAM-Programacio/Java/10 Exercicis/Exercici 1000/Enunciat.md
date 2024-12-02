<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 0

Fent servir SWING bàsic i el model MVC, fes una panell de configuració com el que es mostra a la imatge.

* Quan es modifica una configuració ha d'apereixer en temps real al text infomatiu

* Quan s'apreta el botó 'Reset' s'han de recuperar les configuracions inicials: Opció 0, 50%, Text buit


<center><img src="./captura.gif" height="250" alt="Calculadora" style="max-height: 250px;"></center>


Per tal que passi el test, cal que:

A l'objecte 'MainWindow' la vista i el controlador han de ser públics:

```java
    public View view;
    public Controller controller;
```

Al 'View.java' hi hagi els següents elements:

```java
    public JRadioButton option1, option2, option3;
    public JSlider volumeSlider;
    public JTextField textField; 
    public JLabel configDisplay;
    public JButton resetButton;
```
package com.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Controller {

    private Model model;
    private ViewForm vForm;
    private ViewInfo vInfo;
    
    private CardLayout cardLayout;
    private JPanel cards; // Contenidor de CardLayout

    public Controller(Model model, ViewForm vForm, ViewInfo vInfo, CardLayout cardLayout, JPanel cards) {
        this.model = model;
        this.vForm = vForm;
        this.vInfo = vInfo;
        this.cardLayout = cardLayout;
        this.cards = cards;
    }

    // Accions per iniciar el controlador
    public void start() {
        updateModelWithRandomInfo();
        setupActionListeners();
    }

    private void setupActionListeners() {
        // Definir les funcions que es criden al fer 'click' als botons
        vForm.infoButton.addActionListener(this::controllerInfoButtonAction);
        vInfo.backButton.addActionListener(this::controllerBackButtonAction);
        vInfo.randomInfoButton.addActionListener(this::controllerRandomButtonAction);

    /*  Aquestes últimes crides signifiquen:
        - Quan s'apreti el botó 'infoButton' de l'objecte 'ViewForm'
          s'executa el codi de la funció 'controllerInfoButtonAction' de l'objecte 'Controller'
    */
    }

    // Estableix l'acció del botó a la vista de formulari
    private void controllerInfoButtonAction(ActionEvent e) {
        updateModelFromView();
        updateViews();
        if (model.getAge() >= 0) {
            showInfoView();
        }
    }

    // Estableix l'acció del botó 'backButton' a la vista d'informació
    private void controllerBackButtonAction(ActionEvent e) {
        showFormView();
    }

    // Estableix l'acció del botó 'randomButton' a la vista de informació
    private void controllerRandomButtonAction(ActionEvent e) {
        updateModelWithRandomInfo();
    }

    // Canvia a la vista FORM
    private void showFormView() {
        cardLayout.show(cards, "FORM");
    }

    // Canvia a la vista INFO
    private void showInfoView() {
        cardLayout.show(cards, "INFO");
    }

    // Actualitza el model amb les dades del formuari vForm
    private void updateModelFromView() {

        // Aquí s'hauria de validar el 'nom'

        // Transformar el camp 'age' a 'int' i validar-lo
        int tmpAge = 0;
        Boolean wrongAge = false;
        try {
            tmpAge = Integer.parseInt(vForm.ageField.getText());
            if (tmpAge < 0) {
                wrongAge = true;
            }
        } catch (NumberFormatException e) {
            wrongAge = true;
            System.out.println("Error: " + e);
        }

        // Si l'edat és errònia mostrar l'error i definir l'edat com a -1
        if (!wrongAge) {
            vForm.ageErrorLabel.setVisible(false);
        } else {
            vForm.ageErrorLabel.setVisible(true);
            tmpAge = -1;
        }

        // Definir els valors de 'nom' i 'edat' un cop validats
        model.setName(vForm.nameField.getText());
        model.setAge(tmpAge);
    }

    // Actualitza les vistes amb les dades del model
    private void updateViews() {
        String name = model.getName();
        int age = model.getAge();

        vForm.nameField.setText(name);
        vForm.ageField.setText(String.valueOf(age));
        vInfo.nameValueLabel.setText(name);
        vInfo.ageValueLabel.setText(String.valueOf(age));
    }

    // Genera informació aleatòria i actualitza les vistes
    public void updateModelWithRandomInfo() {
        Random random = new Random();
        String[] names = {"Albert", "Laura", "Marc", "Olga", "Pere", "Ana", "Jordi", "Maria"};
        String name = names[random.nextInt(names.length)];
        int age = 18 + random.nextInt(59); // Edat entre 18 i 76

        model.setName(name);
        model.setAge(age);

        // Actualitza les vistes
        updateViews();
    }
}

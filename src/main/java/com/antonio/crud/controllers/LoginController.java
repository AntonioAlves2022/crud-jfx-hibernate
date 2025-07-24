/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.antonio.crud.controllers;
// com.antonio.crud.controllers.LoginController

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Professor
 */
public class LoginController {
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Label lblMessage;
    private Stage dialogStage;
    private boolean loginSuccess = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public boolean isLoginSuccess() {
        return loginSuccess;
    }
    @FXML
    private void handleLogin(){
        System.out.println("Fazer login");
    }
    @FXML
    private void handleCancelar(){
        System.out.println("Saindo do sistema");
        dialogStage.close();
    }
}

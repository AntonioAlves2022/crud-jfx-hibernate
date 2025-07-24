/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.antonio.crud.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

/**
 *
 * @author Professor
 */
public class SplashController {
    @FXML
    private ProgressBar bar;
    @FXML
    private Label lblMensagens;
    
    public void setProgress(double value){
        bar.setProgress(value);
    }
    
    public void setMessages(String status){
        lblMensagens.setText(status);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.antonio.crud;

import com.antonio.crud.controllers.LoginController;
import com.antonio.crud.controllers.SplashController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Professor
 */
public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showSplashScreen();
    }

    private void showSplashScreen() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/splash-screen.fxml"));
            Parent root = loader.load();
            Stage splashStage = new Stage();
            splashStage.initStyle(StageStyle.UNDECORATED);
            splashStage.setScene(new Scene(root));
            splashStage.show();

            //Configurando o Controller
            SplashController controller = loader.getController();
            //Simular o carregamento
            new Thread(() -> {
                try {
                    for (int i = 0; i <= 100; i++) {
                        final int progress = i;
                        Platform.runLater(() -> {
                            controller.setProgress(progress / 100);
                            controller.setMessages("Carregando " + progress + "%");
                        });
                        Thread.sleep(30);
                    }
                    Platform.runLater(() -> {
                        splashStage.close();
                        showLoginScreen();
                    });
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    private void showLoginScreen() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/tela-login.fxml"));
        Parent root = loader.load();
        Stage loginStage = new Stage();
        loginStage.setTitle("Tela de login");
        loginStage.setScene(new Scene(root));
        loginStage.setResizable(false);
        LoginController controller = loader.getController();
        controller.setDialogStage(loginStage);
        loginStage.showAndWait();
       
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}

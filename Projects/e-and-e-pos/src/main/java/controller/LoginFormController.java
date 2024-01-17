package controller;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private BorderPane paneLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private JFXButton btnLogin;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        Stage stage = (Stage)paneLogin.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserInterfaceForm.fxml"))));
        stage.setTitle("User Interface Form");
        stage.setResizable(true);
        stage.show();


    }

}
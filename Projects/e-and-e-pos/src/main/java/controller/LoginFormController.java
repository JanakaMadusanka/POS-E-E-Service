package controller;

import BO.custom.UserLoginBo;
import BO.custom.impl.UserLoginBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.UserLoginDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class LoginFormController {

    @FXML
    private BorderPane paneLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private JFXButton btnLogin;

    private UserLoginBo userLoginBo = new UserLoginBoImpl();
    private UserInterfaceController userInterfaceController = new UserInterfaceController();

    private void clearFields(){
        txtEmail.clear();
        txtPassword.clear();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

//                Stage stage = (Stage)paneLogin.getScene().getWindow();
//                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MyAccountForm.fxml"))));
//                stage.setTitle("Admin User Interface Form");
//                stage.setResizable(true);
//                stage.show();
//                clearFields();

        try {
            String userRole = userLoginBo.loginRole(new UserLoginDto(
                    txtEmail.getText(),
                    txtPassword.getText()
            ));

            if (userRole == "admin"){
                new Alert(Alert.AlertType.INFORMATION,"Admin-Login Successfull").show();
                Stage stage = (Stage)paneLogin.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserInterface.fxml"))));
                stage.setTitle("Admin User Interface Form");
                stage.setResizable(true);
                stage.show();
                clearFields();

            }else if (userRole == "default-user"){
                new Alert(Alert.AlertType.INFORMATION,"Default-Login Successfull").show();
                Stage stage = (Stage)paneLogin.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UserInterface-default.fxml"))));
                stage.setTitle("Default User Interface Form");
                stage.setResizable(true);
                stage.show();
                clearFields();
            }else{
                new Alert(Alert.AlertType.INFORMATION,"Incorrect Login Details...").show();
                clearFields();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
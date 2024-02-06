package controller;

import BO.custom.UserLoginBo;
import BO.custom.impl.UserLoginBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.UserDto;
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

        try {
            boolean isUser = userLoginBo.isUser(new UserDto(
                    "",
                    "",
                    "",
                    txtEmail.getText(),
                    txtPassword.getText()
            ));

            Stage stage = (Stage)paneLogin.getScene().getWindow();

            if (isUser){

                new Alert(Alert.AlertType.INFORMATION,"Login Successfull...").show();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/UserInterface.fxml"));
                Parent root = loader.load();

                UserInterfaceController controller = loader.getController();
                controller.setLoginData(txtEmail.getText());

                stage.setScene(new Scene(root));
                stage.setTitle("User Interface Form");
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
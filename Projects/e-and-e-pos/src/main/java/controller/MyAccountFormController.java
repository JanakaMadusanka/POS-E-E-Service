package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MyAccountFormController {

    @FXML
    private BorderPane paneMyAccount;

    @FXML
    private GridPane gridMyAccount;

    @FXML
    private Label lblUserProfileHeading;

    @FXML
    private Label lblUserId;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblNIC;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblRole;

    @FXML
    private Label lblRoleId;

    @FXML
    private Label lblUserName;

    @FXML
    private TextField lblNewPassword1;

    @FXML
    private TextField lblNewPassword2;

    @FXML
    private TextField txtOldPassword;

    @FXML
    private JFXButton btnSave;

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}


package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class UserInterfaceDefaultController {

    @FXML
    private BorderPane paneUserInterface;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnCustomers;

    @FXML
    private JFXButton btnRepairDetail;

    @FXML
    private JFXButton btnPlaceRepairOrder;

    @FXML
    private JFXButton btnParts;

    @FXML
    private JFXButton btnMyAccount;

    @FXML
    private ImageView imgProfile;

    @FXML
    private Label lblProfileName;

    @FXML
    private Label lblProfileRole;

    @FXML
    private BorderPane paneLoader;

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)paneUserInterface.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
        stage.show();
    }

    @FXML
    void btnExitOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)paneUserInterface.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
        stage.show();
    }
    @FXML
    void btnMyAccount(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/MyAccountForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneLoader.getChildren().clear();
        this.paneLoader.getChildren().add(load);

    }

    @FXML
    void btnPartsOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/PartsForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneLoader.getChildren().clear();
        this.paneLoader.getChildren().add(load);
    }

    @FXML
    void btnPlaceRepairOrderOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/PlaceRepairOrderForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneLoader.getChildren().clear();
        this.paneLoader.getChildren().add(load);
    }

    @FXML
    void btnRepairDetailOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/RepairDetailForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneLoader.getChildren().clear();
        this.paneLoader.getChildren().add(load);
    }

    @FXML
    void btnCustomersOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/CustomerForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneLoader.getChildren().clear();
        this.paneLoader.getChildren().add(load);
    }
}


package controller;

import BO.custom.UserInterfaceBo;
import BO.custom.impl.UserInterfaceBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.UserDto;
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
import java.sql.SQLException;

public class UserInterfaceController {

    public Label lblWelcome;
    public JFXButton btnReports;
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
    private JFXButton btnUserRegistration;
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

    private final UserInterfaceBo bo = new UserInterfaceBoImpl();

    public void setLoginData(String email) throws SQLException, ClassNotFoundException {
        UserDto dto = bo.getMyAccount(email);

        if("Admin".equals(dto.getRole())){
            lblWelcome.setText("Welcome to Admin-User");
        }else{
            lblWelcome.setText("Welcome to Default-User");
            btnUserRegistration.setVisible(false);
            btnReports.setVisible(false);
        }
        lblProfileName.setText(dto.getName());
        lblProfileRole.setText(dto.getRole());
    }

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
    void btnUserRegistrationOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/UserRegistrationForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneLoader.getChildren().clear();
        this.paneLoader.getChildren().add(load);
    }
    @FXML
    void btnReportsOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/ReportsForm.fxml");
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

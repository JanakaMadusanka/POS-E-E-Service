package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

public class ReportsFormController {

    @FXML
    private BorderPane paneReports;

    @FXML
    private Label lblUserProfileHeading1;

    @FXML
    private JFXButton btnCustomerReports;

    @FXML
    private JFXButton btnSalesReports;

    @FXML
    private JFXButton btnOrderReports;

    @FXML
    private BorderPane paneReportsLoader;

    @FXML
    void btnCustomerReportsOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/CustomerReportsForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneReportsLoader.getChildren().clear();
        this.paneReportsLoader.getChildren().add(load);

    }

    @FXML
    void btnOrderReportsOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/OrderReportsForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneReportsLoader.getChildren().clear();
        this.paneReportsLoader.getChildren().add(load);

    }

    @FXML
    void btnSalesReportsOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("../view/SalesReportsForm.fxml");
        assert resource != null;
        Parent load = FXMLLoader.load(resource);
        this.paneReportsLoader.getChildren().clear();
        this.paneReportsLoader.getChildren().add(load);

    }

}

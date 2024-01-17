package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class PlaceRepairOrderFormController {

    @FXML
    private BorderPane panePlaceRepairOrder;

    @FXML
    private Label lblUserProfileHeading1;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    @FXML
    private JFXButton btnSaveCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TableView<?> tblInvoice;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private JFXButton btnPrint;

    @FXML
    private Label lblUserProfileHeading11;

    @FXML
    private TextField txtItemNumber;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtDate;

    @FXML
    private JFXButton btnGenerateInvoice;

    @FXML
    private Label lblStatus;

    @FXML
    void btnGenerateInvoiceOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveCustomerOnAction(ActionEvent event) {

    }

}

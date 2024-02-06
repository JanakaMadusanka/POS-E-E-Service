package controller;

import BO.custom.CustomerBo;
import BO.custom.RepairOrderBo;
import BO.custom.impl.CustomerBoImpl;
import BO.custom.impl.RepairOrderBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.CustomerDto;
import dto.RepairOrderDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class PlaceRepairOrderFormController {

    public TextField txtOrderNo;
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
    private JFXButton btnPlaceOrder;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtDate;

    @FXML
    private JFXButton btnGenerateInvoice;

    @FXML
    private Label lblStatus;

    private CustomerBo<CustomerDto> customerBo = new CustomerBoImpl();
    private RepairOrderBo repairOrderBo = new RepairOrderBoImpl();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private void clearFields(){
        txtContact.clear();
        txtName.clear();
        txtAddress.clear();
        txtOrderNo.clear();
        txtDate.clear();
        txtDescription.clear();
        txtContact.setEditable(true);
    }

    public void initialize(){

    }

    private void loadInvoiceTable() {
    }
    @FXML
    void btnSaveCustomerOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            boolean isSaved = customerBo.saveCustomer(new CustomerDto(
                    txtContact.getText(),
                    txtName.getText(),
                    txtAddress.getText()
            ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Customer Saved!...").show();
                txtOrderNo.setText(String.valueOf(repairOrderBo.generateOrderId()));
                txtOrderNo.setEditable(false);
            }

        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Registerd Customer...").show();
            txtName.clear();
            txtAddress.clear();
            txtOrderNo.setText(String.valueOf(repairOrderBo.generateOrderId()));
            txtOrderNo.setEditable(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        try {
            boolean isSaved = repairOrderBo.saveOrder(new RepairOrderDto(
                    Integer.parseInt(txtOrderNo.getText()),
                    dateFormat.parse(txtDate.getText()),
                    txtDescription.getText(),
                    txtContact.getText(),
                    "",
                    ""
            ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Repair Order Saved!").show();
                clearFields();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            // Handle the case where the order number cannot be parsed as an integer
            new Alert(Alert.AlertType.ERROR, "Invalid Order Number").show();
        }
    }
    @FXML
    void btnGenerateInvoiceOnAction(ActionEvent event) {
    }
    @FXML
    void btnPrintOnAction(ActionEvent event) {

    }

}

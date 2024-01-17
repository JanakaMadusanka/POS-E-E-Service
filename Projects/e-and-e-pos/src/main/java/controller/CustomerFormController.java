package controller;

import BO.custom.CustomerBo;
import BO.custom.impl.CustomerBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.CustomerDto;
import dto.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.sql.*;
import java.util.List;

public class CustomerFormController {

    @FXML
    private BorderPane paneUserRegistration;

    @FXML
    private Label lblUserProfileHeading1;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtName;

    @FXML
    private JFXButton btnAddCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colOpction;

    @FXML
    private JFXButton btnReload;

    private CustomerBo<CustomerDto> customerBo = new CustomerBoImpl();

    private void clearFields(){
        tblCustomer.refresh();
        txtAddress.clear();
        txtName.clear();
        txtContact.clear();
        txtContact.setEditable(true);
    }

    public void initialize(){
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colOpction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadCustomerTable();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData(newValue);
        });
    }
    private void setData(CustomerTm newValue) {
        if (newValue != null) {
            txtContact.setEditable(false);
            txtContact.setText(newValue.getContact());
            txtName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
        }
    }
    private void loadCustomerTable() {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList = customerBo.allCustomers();

            for (CustomerDto dto:dtoList) {
                Button btn = new Button("Delete");

                CustomerTm c = new CustomerTm(
                        dto.getContact(),
                        dto.getName(),
                        dto.getAddress(),
                        btn
                );

                btn.setOnAction(actionEvent -> {
                    deleteCustomer(c.getContact());
                });

                tmList.add(c);
            }

            tblCustomer.setItems(tmList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = customerBo.saveCustomer(new CustomerDto(
                    txtContact.getText(),
                    txtName.getText(),
                    txtAddress.getText()
            ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Customer Saved!").show();
                loadCustomerTable();
                clearFields();
            }

        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void btnUpdateOnAction(ActionEvent actionEvent){
        try {
            boolean isUpdated = customerBo.updateCustomer(new CustomerDto(
                txtContact.getText(),
                txtName.getText(),
                txtAddress.getText()
            ));
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Customer Updated!").show();
                loadCustomerTable();
                clearFields();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private void deleteCustomer(String id) {
        try {
            boolean isDeleted = customerBo.deleteCustomer(id);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!").show();
                loadCustomerTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadCustomerTable();
        tblCustomer.refresh();
        clearFields();
    }
}

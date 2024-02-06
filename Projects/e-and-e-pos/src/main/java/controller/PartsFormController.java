package controller;

import BO.custom.PartBo;
import BO.custom.impl.PartBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.CustomerDto;
import dto.PartDto;
import dto.tm.PartTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class PartsFormController {

    public TextField txtQty;
    @FXML
    private BorderPane paneParts;

    @FXML
    private Label lblUserProfileHeading1;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtCode;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TextField tstQty;

    @FXML
    private TextField txtDescription;

    @FXML
    private TableView<PartTm> tblParts;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colOpction;

    @FXML
    private JFXButton btnReload;

    private PartBo<PartDto> partBo = new PartBoImpl();

    private void clearFields(){
        tblParts.refresh();
        txtCode.clear();
        txtDescription.clear();
        txtUnitPrice.clear();
        txtQty.clear();
        txtCode.setEditable(true);
        txtDescription.setEditable(true);
        txtUnitPrice.setEditable(true);
    }
    public void initialize() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colOpction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadPartTable();

        tblParts.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData(newValue);
        });
    }
    private void setData(PartTm newValue) {
        if (newValue != null) {
            txtCode.setEditable(false);
            txtDescription.setEditable(false);
            txtUnitPrice.setEditable(false);
            txtCode.setText(newValue.getCode());
            txtDescription.setText(newValue.getName());
            txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
            txtQty.setText(String.valueOf(newValue.getQtyOnHand()));
        }
    }
    private void loadPartTable() {
        ObservableList<PartTm> tmList = FXCollections.observableArrayList();

        try {
            List<PartDto> dtoList = partBo.allParts();

            for (PartDto dto:dtoList) {
                Button btn = new Button("Delete");

                PartTm tm = new PartTm(
                        dto.getCode(),
                        dto.getName(),
                        dto.getUnitPrice(),
                        dto.getQtyOnHand(),
                        btn
                );
                btn.setOnAction(actionEvent -> {
                    deletePart(tm.getCode());
                });

                tmList.add(tm);
            }
            tblParts.setItems(tmList);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deletePart(String code) {
        try {
            boolean isDeleted = partBo.deletePart(code);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Part Deleted!").show();
                loadPartTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        try {
            boolean isSaved = partBo.savePart(new PartDto(
                    txtCode.getText(),
                    txtDescription.getText(),
                    new BigDecimal(txtUnitPrice.getText()),
                    Integer.parseInt(txtQty.getText())
            ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Part Saved!...").show();
                loadPartTable();
                clearFields();
            }

        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = partBo.addQuantity(new PartDto(
                    txtCode.getText(),
                    txtDescription.getText(),
                    new BigDecimal(txtUnitPrice.getText()),
                    Integer.parseInt(txtQty.getText())
            ));
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Part Updated!").show();
                loadPartTable();
                clearFields();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}

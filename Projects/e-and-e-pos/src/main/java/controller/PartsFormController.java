package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class PartsFormController {

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
    private TableView<?> tblParts;

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

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

}

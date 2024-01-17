package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class RepairDetailFormController {

    @FXML
    private BorderPane paneRepairDetail;

    @FXML
    private Label lblUserProfileHeading1;

    @FXML
    private TableView<?> tblRepairDetail;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colRepairItemCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private JFXButton btnReload;

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

}

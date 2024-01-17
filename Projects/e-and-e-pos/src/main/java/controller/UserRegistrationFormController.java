package controller;

import BO.custom.UserBo;
import BO.custom.impl.UserBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.UserDto;
import dto.tm.UserTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class UserRegistrationFormController {

    @FXML
    private BorderPane paneUserRegistration;

    @FXML
    private JFXButton btnSave;

    @FXML
    private Label lblUserProfileHeading1;

    @FXML
    private TextField txtRoleId;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtName;

    @FXML
    private TableView<UserTm> tblUser;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colRoleId;

    @FXML
    private TableColumn<?, ?> colRole;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colPassword;

    @FXML
    private TableColumn<?, ?> colOpction;

    @FXML
    private JFXButton btnReload;

    private UserBo<UserDto> userBo = new UserBoImpl();

    private void clearFields(){
        tblUser.refresh();
        txtId.clear();
        txtName.clear();
        txtRole.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtId.setEditable(true);
    }

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colOpction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadUserTable();

        tblUser.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((UserTm) newValue);
        });
    }
    private void setData(UserTm newValue) {
        if (newValue != null) {
            txtId.setEditable(false);
            txtName.setText(newValue.getId());
            txtRole.setText(newValue.getName());
            txtEmail.setText(newValue.getRole());
            txtPassword.setText(newValue.getEmail());
            txtPassword.setText(newValue.getPassword());
        }
    }
    private void loadUserTable() {
        ObservableList<UserTm> tmList = FXCollections.observableArrayList();

        try {
            List<UserDto> dtoList = userBo.allUsers();

            for (UserDto dto:dtoList) {
                Button btn = new Button("Delete");

                UserTm c = new UserTm(
                        dto.getId(),
                        dto.getName(),
                        dto.getRole(),
                        dto.getEmail(),
                        dto.getPassword(),
                        btn
                );

                btn.setOnAction(actionEvent -> {
                    deleteUser(c.getId());
                });

                tmList.add(c);
            }

            tblUser.setItems(tmList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void deleteUser(String id) {
        try {
            boolean isDeleted = userBo.deleteUser(id);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"User Deleted!").show();
                loadUserTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadUserTable();
        tblUser.refresh();
        clearFields();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {
            boolean isSaved = userBo.saveUser(new UserDto(
                    txtId.getText(),
                    txtName.getText(),
                    txtRole.getText(),
                    txtEmail.getText(),
                    txtPassword.getText()
            ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"User Saved!").show();
                loadUserTable();
                clearFields();
            }

        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}

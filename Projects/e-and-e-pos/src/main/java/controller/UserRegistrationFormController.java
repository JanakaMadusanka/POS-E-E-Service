package controller;

import BO.custom.RoleBo;
import BO.custom.UserBo;
import BO.custom.impl.RoleBoImpl;
import BO.custom.impl.UserBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.RoleDto;
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
import java.util.stream.Collectors;

public class UserRegistrationFormController {

    @FXML
    public ChoiceBox choiceRole;
    public JFXButton btnUpdate;

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

    private UserBo<UserDto> userBo = new UserBoImpl();
    private RoleBo roleBo = new RoleBoImpl();

    private void clearFields(){
        tblUser.refresh();
        txtId.clear();
        txtName.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtId.setEditable(true);
    }

    public void initialize() throws SQLException, ClassNotFoundException {

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

        setChoiceRole();
    }

    private void setChoiceRole() {
        try {
            List<RoleDto> roleList = roleBo.allRoles();

            ObservableList<RoleDto> roles = FXCollections.observableArrayList(roleList);

            choiceRole.setItems(FXCollections.observableArrayList(
                    roleList.stream()
                            .map(RoleDto::getRole)
                            .collect(Collectors.toList())
            ));
            choiceRole.setValue("Select Role");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setData(UserTm newValue) {
        if (newValue != null) {
            txtId.setEditable(false);
            txtId.setText(newValue.getId());
            txtName.setText(newValue.getName());
            choiceRole.setValue(newValue.getRole());
            txtEmail.setText(newValue.getEmail());
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
    public void onChoiceBoxSelection() {
//        String selectedOption = (String) choiceRole.getValue();
//        txtRole.setText(selectedOption);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try {
            boolean isSaved = userBo.saveUser(new UserDto(
                    txtId.getText(),
                    txtName.getText(),
                    (String) choiceRole.getValue(),
                    txtEmail.getText(),
                    txtPassword.getText()
            ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"User Saved!").show();
                loadUserTable();
                //tblUser.refresh();
                clearFields();
            }
        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = userBo.updateUser(new UserDto(
                    txtId.getText(),
                    txtName.getText(),
                    (String) choiceRole.getValue(),
                    txtEmail.getText(),
                    txtPassword.getText()
            ));
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"User Updated!").show();
                loadUserTable();
                clearFields();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

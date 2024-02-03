package controller;

import BO.custom.MyAccountBo;
import BO.custom.impl.MyAccountBoImpl;
import com.jfoenix.controls.JFXButton;
import dto.PasswordDto;
import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.sql.SQLException;

public class MyAccountFormController {

    public JFXButton btnUpdate;
    public TextField txtNewPassword2;
    public TextField txtNewPassword1;
    public TextField txtOldPassword;
    @FXML
    private BorderPane paneMyAccount;

    @FXML
    private GridPane gridMyAccount;

    @FXML
    private Label lblUserProfileHeading;

    @FXML
    private Label lblUserId;

    @FXML
    private Label lblMobile;

    @FXML
    private Label lblNIC;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblRole;

    @FXML
    private Label lblRoleId;

    @FXML
    private Label lblUserName;

    private MyAccountBo<PasswordDto> myAccountBo = new MyAccountBoImpl();

    private void clearFields(){
        txtOldPassword.clear();
        txtNewPassword1.clear();
        txtNewPassword2.clear();
    }

    public void initialize() throws SQLException, ClassNotFoundException {

        setMyAccount("U010");

    }

    public void setMyAccount(String id) throws SQLException, ClassNotFoundException {
        UserDto dto = myAccountBo.getMyAccount(id);
        lblUserId.setText(dto.getId());
        lblUserName.setText(dto.getName());
        lblRole.setText(dto.getRole());
        lblEmail.setText(dto.getEmail());
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        try {
            if((txtOldPassword.getText()).equals("janaka")){
                if((txtNewPassword2.getText()).equals(txtNewPassword1.getText())){
                    boolean isUpdated = myAccountBo.updatePassword(new PasswordDto(
                            lblUserId.getText(),
                            txtNewPassword2.getText()
                    ));

                    if (isUpdated){
                        new Alert(Alert.AlertType.INFORMATION,"Password Changed!").show();
                        clearFields();
                    }
                }else {
                    new Alert(Alert.AlertType.INFORMATION,"The New passwords entered do not match.!").show();
                }
            }else {
                new Alert(Alert.AlertType.INFORMATION,"The Old password entered do not match.!").show();
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}


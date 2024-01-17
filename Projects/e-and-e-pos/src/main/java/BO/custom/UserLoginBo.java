package BO.custom;

import BO.SupperBo;
import dto.UserLoginDto;

import java.sql.SQLException;

public interface UserLoginBo extends SupperBo {
    boolean validateLogin(UserLoginDto userLoginDto) throws SQLException, ClassNotFoundException;
}

package BO.custom;

import BO.SupperBo;
import dto.UserDto;

import java.sql.SQLException;

public interface UserLoginBo extends SupperBo {
    boolean isUser(UserDto userDto) throws SQLException, ClassNotFoundException;
}

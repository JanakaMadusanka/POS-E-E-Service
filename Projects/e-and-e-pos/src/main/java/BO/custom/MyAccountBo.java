package BO.custom;

import BO.SupperBo;
import dto.UserDto;
import dto.UserLoginDto;

import java.sql.SQLException;
import java.util.List;

public interface MyAccountBo<T> extends SupperBo {
    boolean updatePassword(T dto) throws SQLException, ClassNotFoundException;
    UserDto getMyAccount(String id) throws SQLException, ClassNotFoundException;
}

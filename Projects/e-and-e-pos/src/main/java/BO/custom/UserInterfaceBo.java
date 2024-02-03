package BO.custom;

import BO.SupperBo;
import dto.UserDto;

import java.sql.SQLException;

public interface UserInterfaceBo<T> extends SupperBo {
    public UserDto getMyAccount(String email) throws SQLException, ClassNotFoundException ;
}

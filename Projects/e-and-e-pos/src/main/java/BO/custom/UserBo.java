package BO.custom;

import BO.SupperBo;
import dto.UserDto;
import java.sql.SQLException;
import java.util.List;

public interface UserBo<T> extends SupperBo {
    boolean saveUser(T dto) throws SQLException, ClassNotFoundException;
    boolean updateUser(T dto) throws SQLException, ClassNotFoundException;
    boolean deleteUser(String id) throws SQLException, ClassNotFoundException;
    List<UserDto> allUsers() throws SQLException, ClassNotFoundException;
}

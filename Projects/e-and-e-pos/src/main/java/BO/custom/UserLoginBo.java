package BO.custom;

import BO.SupperBo;
import dto.UserLoginDto;
import java.sql.SQLException;

public interface UserLoginBo extends SupperBo {
    String loginRole(UserLoginDto userLoginDto) throws SQLException, ClassNotFoundException;
}

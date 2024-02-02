package BO.custom;

import dto.RoleDto;
import dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface RoleBo {
    List<RoleDto> allRoles() throws SQLException, ClassNotFoundException;
}

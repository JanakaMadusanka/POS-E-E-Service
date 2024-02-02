package BO.custom.impl;

import BO.custom.RoleBo;
import dao.custom.RoleDao;
import dao.custom.UserDao;
import dao.custom.impl.RoleDaoImpl;
import dao.custom.impl.UserDaoImpl;
import dto.RoleDto;
import dto.UserDto;
import entity.RoleEntity;
import entity.UserEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleBoImpl implements RoleBo {
    private RoleDao roleDao = new RoleDaoImpl();
    @Override
    public List<RoleDto> allRoles() throws SQLException, ClassNotFoundException {
        List<RoleEntity> entityList = roleDao.getAll();
        List<RoleDto> list = new ArrayList<>();

        for(RoleEntity entity : entityList){
            list.add(new RoleDto(
                    entity.getRoleId(),
                    entity.getRole()
            ));
        }
        return list;
    }
}

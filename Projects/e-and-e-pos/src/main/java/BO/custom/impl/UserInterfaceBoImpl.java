package BO.custom.impl;

import BO.custom.UserInterfaceBo;
import dao.custom.UserDao;
import dao.custom.impl.UserDaoImpl;
import dto.UserDto;
import entity.UserEntity;
import java.sql.SQLException;

public class UserInterfaceBoImpl implements UserInterfaceBo {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public UserDto getMyAccount(String email) throws SQLException, ClassNotFoundException {
        UserEntity entity = userDao.searchByEmail(email);
        return new UserDto(
                entity.getId(),
                entity.getName(),
                entity.getRole(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}

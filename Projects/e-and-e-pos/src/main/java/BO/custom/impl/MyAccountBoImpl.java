package BO.custom.impl;

import BO.custom.MyAccountBo;
import dao.custom.UserDao;
import dao.custom.impl.UserDaoImpl;
import dto.PasswordDto;
import dto.UserDto;
import entity.UserEntity;
import java.sql.SQLException;

public class MyAccountBoImpl implements MyAccountBo<PasswordDto> {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean updatePassword(PasswordDto dto) throws SQLException, ClassNotFoundException {
        return userDao.updatePassword(new UserEntity(
                dto.getId(),
                "",
                "",
                "",
                dto.getPassword()
        ));
    }

    @Override
    public UserDto getMyAccount(String id) throws SQLException, ClassNotFoundException {
        UserEntity entity = userDao.search(id);
        return new UserDto(
                entity.getId(),
                entity.getName(),
                entity.getRole(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}

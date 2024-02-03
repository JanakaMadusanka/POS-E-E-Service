package BO.custom.impl;

import BO.custom.UserLoginBo;
import dao.custom.UserDao;
import dao.custom.impl.UserDaoImpl;
import dto.UserDto;
import entity.UserEntity;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UserLoginBoImpl implements UserLoginBo {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean isUser(UserDto userDto) throws SQLException, ClassNotFoundException {
        List<UserEntity> entityList = userDao.getAll();

        for(UserEntity user : entityList){
            if((Objects.equals(user.getEmail(), userDto.getEmail())) && (Objects.equals(user.getPassword(), userDto.getPassword()))){
                return true;
            }
        }
        return false;
    }
}

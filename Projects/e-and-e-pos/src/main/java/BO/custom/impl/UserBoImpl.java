package BO.custom.impl;

import BO.custom.UserBo;
import dao.custom.UserDao;
import dao.custom.impl.UserDaoImpl;
import dto.UserDto;
import entity.UserEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBo<UserDto> {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.save(new UserEntity(
                dto.getId(),
                dto.getName(),
                dto.getRole(),
                dto.getEmail(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean updateUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.update(new UserEntity(
                dto.getId(),
                dto.getName(),
                dto.getRole(),
                dto.getEmail(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        return userDao.delete(id);
    }

    @Override
    public List<UserDto> allUsers() throws SQLException, ClassNotFoundException {
        List<UserEntity> entityList = userDao.getAll();
        List<UserDto> list = new ArrayList<>();

        for(UserEntity user : entityList){
            list.add(new UserDto(
                    user.getId(),
                    user.getName(),
                    user.getRole(),
                    user.getEmail(),
                    user.getPassword()
            ));
        }
        return list;
    }
}

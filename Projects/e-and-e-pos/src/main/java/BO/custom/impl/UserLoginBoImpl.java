package BO.custom.impl;

import BO.custom.UserLoginBo;
import dao.custom.UserLoginDao;
import dao.custom.impl.UserLoginDaoImpl;
import dto.UserLoginDto;
import entity.UserEntity;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UserLoginBoImpl implements UserLoginBo {
    private UserLoginDao userLoginDao = new UserLoginDaoImpl();

    @Override
    public String loginRole(UserLoginDto userLoginDto) throws SQLException, ClassNotFoundException {
        List<UserEntity> entityList = userLoginDao.getAll();

        for(UserEntity user : entityList){
            if((Objects.equals(user.getEmail(), userLoginDto.getEmail())) && (Objects.equals(user.getPassword(), userLoginDto.getPassword()))){
                if((Objects.equals(user.getRole(), "Admin"))){
                    return "admin";
                }else{
                    return "default-user";
                }
            }
        }
        return "wrong-user";
    }
}

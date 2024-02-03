package dao.custom;

import dao.CrudDao;
import entity.UserEntity;

import java.sql.SQLException;

public interface UserDao extends CrudDao<UserEntity> {
    boolean updatePassword(UserEntity entity) throws SQLException, ClassNotFoundException;
    UserEntity search(String id) throws SQLException, ClassNotFoundException;
}

package dao.custom.impl;

import dao.custom.UserLoginDao;
import db.DBConnection;
import entity.UserEntity;
import entity.UserLoginEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserLoginDaoImpl implements UserLoginDao {
    @Override
    public boolean save(UserEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public boolean update(UserEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }
    @Override
    public List<UserEntity> getAll() throws SQLException, ClassNotFoundException {
        List<UserEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM User";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            list.add(new UserEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return list;
    }
}

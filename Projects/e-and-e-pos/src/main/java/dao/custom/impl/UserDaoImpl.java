package dao.custom.impl;

import dao.custom.UserDao;
import db.DBConnection;
import entity.UserEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(UserEntity entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO User VALUES(?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,entity.getId());
        pstm.setString(2,entity.getName());
        pstm.setString(3,entity.getRole());
        pstm.setString(4,entity.getEmail());
        pstm.setString(5,entity.getPassword());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean update(UserEntity entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE User SET name=?, role=?, email=?, password=? WHERE id=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,entity.getName());
        pstm.setString(2,entity.getRole());
        pstm.setString(3,entity.getEmail());
        pstm.setString(4,entity.getPassword());
        pstm.setString(5,entity.getId());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        String sql = "DELETE from User WHERE id=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,value);
        return pstm.executeUpdate()>0;
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

package dao.custom.impl;

import dao.custom.RoleDao;
import db.DBConnection;
import entity.RoleEntity;
import entity.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {


    @Override
    public boolean save(RoleEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(RoleEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<RoleEntity> getAll() throws SQLException, ClassNotFoundException {
        List<RoleEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM Role";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            list.add(new RoleEntity(
                    resultSet.getString(1),
                    resultSet.getString(2)
            ));
        }
        return list;
    }
}

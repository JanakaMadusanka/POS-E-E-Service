package dao.custom.impl;

import dao.custom.PartDao;
import db.DBConnection;
import entity.CustomerEntity;
import entity.PartEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartDaoImpl implements PartDao {
    @Override
    public boolean save(PartEntity entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Part VALUES(?,?,?,?)";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,entity.getCode());
        pstm.setString(2,entity.getName());
        pstm.setBigDecimal(3,entity.getUnitPrice());
        pstm.setInt(4,entity.getQtyOnHand());
        return pstm.executeUpdate()>0;
    }


    @Override
    public boolean update(PartEntity entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Part SET unitPrice=?, qtyOnHand=? WHERE code=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setBigDecimal(1,entity.getUnitPrice());
        pstm.setInt(2,entity.getQtyOnHand());
        pstm.setString(3,entity.getCode());

        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        String sql = "DELETE from Part WHERE code=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,value);
        return pstm.executeUpdate()>0;
    }

    @Override
    public List<PartEntity> getAll() throws SQLException, ClassNotFoundException {
        List<PartEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM Part";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            list.add(new PartEntity(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getBigDecimal(3),
                resultSet.getInt(4)
            ));
        }
        return list;
    }

    @Override
    public PartEntity searchByCode(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Part WHERE code = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,code);
        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new PartEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getBigDecimal(3),
                    resultSet.getInt(4)
            );
        } else {
            return null; // Return null if no user with the given id is found
        }
    }

    @Override
    public PartEntity searchByName(String name) throws SQLException, ClassNotFoundException {
        return null;
    }
}

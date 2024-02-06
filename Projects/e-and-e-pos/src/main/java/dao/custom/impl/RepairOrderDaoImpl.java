package dao.custom.impl;

import dao.custom.RepairOrderDao;
import db.DBConnection;
import entity.RepairOrderEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepairOrderDaoImpl implements RepairOrderDao {


    @Override
    public boolean save(RepairOrderEntity entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO RepairOrder VALUES(?,?,?,?,?,?)";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setInt(1, entity.getOrderId());
        pstm.setDate(2, new java.sql.Date(entity.getDate().getTime()));
        pstm.setString(3,entity.getDescription());
        pstm.setString(4,entity.getCustomerContact());
        pstm.setString(5,entity.getItem());
        pstm.setString(6,entity.getItemCode());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean update(RepairOrderEntity entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<RepairOrderEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public int getMaxOrderId()throws SQLException, ClassNotFoundException {
        String sql = "SELECT MAX(orderId) AS maxOrderId FROM RepairOrder";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            return id;
        } else {
            return 0; // Return 0 if no orderId is found
        }
    }
}

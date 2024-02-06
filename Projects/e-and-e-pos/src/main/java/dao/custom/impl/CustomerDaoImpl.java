package dao.custom.impl;

import dao.custom.CustomerDao;
import db.DBConnection;
import entity.CustomerEntity;
import entity.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(CustomerEntity entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO customer VALUES(?,?,?)";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,entity.getContact());
        pstm.setString(2,entity.getName());
        pstm.setString(3,entity.getAddress());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean update(CustomerEntity entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE customer SET name=?, address=? WHERE contact=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,entity.getName());
        pstm.setString(2,entity.getAddress());
        pstm.setString(3,entity.getContact());

        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        String sql = "DELETE from customer WHERE contact=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,value);
        return pstm.executeUpdate()>0;
    }

    @Override
    public List<CustomerEntity> getAll() throws SQLException, ClassNotFoundException {
        List<CustomerEntity> list = new ArrayList<>();

        String sql = "SELECT * FROM customer";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            list.add(new CustomerEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        return list;
    }
    public CustomerEntity searchByContact(String contact) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM Customer WHERE contact = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,contact);
        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next()) {
            return new CustomerEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        } else {
            return null; // Return null if no user with the given id is found
        }
    }
}

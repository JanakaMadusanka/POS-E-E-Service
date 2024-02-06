package dao.custom;

import dao.CrudDao;
import entity.CustomerEntity;

import java.sql.SQLException;

public interface CustomerDao extends CrudDao<CustomerEntity> {
    public CustomerEntity searchByContact(String contact) throws SQLException, ClassNotFoundException;
}

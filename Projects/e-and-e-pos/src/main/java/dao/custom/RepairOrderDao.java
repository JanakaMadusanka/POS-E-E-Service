package dao.custom;

import dao.CrudDao;
import entity.RepairOrderEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RepairOrderDao extends CrudDao<RepairOrderEntity> {
    public int getMaxOrderId()throws SQLException, ClassNotFoundException;
}

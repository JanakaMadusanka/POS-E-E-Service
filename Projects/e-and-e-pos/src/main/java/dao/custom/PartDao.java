package dao.custom;

import dao.CrudDao;
import entity.CustomerEntity;
import entity.PartEntity;

import java.sql.SQLException;

public interface PartDao extends CrudDao<PartEntity> {
    public PartEntity searchByCode(String code) throws SQLException, ClassNotFoundException;
    public PartEntity searchByName(String name) throws SQLException, ClassNotFoundException;
}

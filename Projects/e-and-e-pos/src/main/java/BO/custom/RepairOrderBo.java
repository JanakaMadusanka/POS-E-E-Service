package BO.custom;

import BO.SupperBo;
import dto.CustomerDto;
import dto.RepairOrderDto;

import java.sql.SQLException;

public interface RepairOrderBo<T> extends SupperBo {

    CustomerDto getContactById(String contact) throws SQLException, ClassNotFoundException;
    int generateOrderId() throws SQLException, ClassNotFoundException;

    boolean saveOrder(RepairOrderDto repairOrderDto)throws SQLException, ClassNotFoundException;
}

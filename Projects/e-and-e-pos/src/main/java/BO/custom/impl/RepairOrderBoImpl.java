package BO.custom.impl;

import BO.custom.RepairOrderBo;
import dao.custom.CustomerDao;
import dao.custom.RepairOrderDao;
import dao.custom.impl.CustomerDaoImpl;
import dao.custom.impl.RepairOrderDaoImpl;
import dto.CustomerDto;
import dto.RepairOrderDto;
import entity.CustomerEntity;
import entity.RepairOrderEntity;

import java.sql.SQLException;

public class RepairOrderBoImpl implements RepairOrderBo<CustomerDto> {
    private CustomerDao customerDao = new CustomerDaoImpl();
    private RepairOrderDao repairOrderDao = new RepairOrderDaoImpl() ;

    @Override
    public CustomerDto getContactById(String contact) throws SQLException, ClassNotFoundException {
        CustomerEntity entity = customerDao.searchByContact(contact);
        return new CustomerDto(
                entity.getContact(),
                entity.getName(),
                entity.getAddress()
        );
    }

    @Override
    public int generateOrderId() throws SQLException, ClassNotFoundException {
        int lastId = repairOrderDao.getMaxOrderId();
        int id = lastId+1;
        return id;
    }

    public boolean saveOrder(RepairOrderDto repairOrderDto)throws SQLException, ClassNotFoundException {
        return repairOrderDao.save(new RepairOrderEntity(
                repairOrderDto.getOrderId(),
                repairOrderDto.getDate(),
                repairOrderDto.getDescription(),
                repairOrderDto.getCustomerContact(),
                repairOrderDto.getItem(),
                repairOrderDto.getItemCode()
        ));
    }
}

package BO.custom.impl;

import BO.custom.CustomerBo;
import dao.custom.CustomerDao;
import dao.custom.impl.CustomerDaoImpl;
import dto.CustomerDto;
import entity.CustomerEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo<CustomerDto> {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.save(new CustomerEntity(
                dto.getContact(),
                dto.getName(),
                dto.getAddress()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return customerDao.update(new CustomerEntity(
                dto.getContact(),
                dto.getName(),
                dto.getAddress()
        ));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }

    @Override
    public List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException {
        List<CustomerEntity> entityList = customerDao.getAll();
        List<CustomerDto> list = new ArrayList<>();

        for(CustomerEntity customer : entityList){
            list.add(new CustomerDto(
                    customer.getContact(),
                    customer.getName(),
                    customer.getAddress()
            ));
        }
        return list;
    }
}

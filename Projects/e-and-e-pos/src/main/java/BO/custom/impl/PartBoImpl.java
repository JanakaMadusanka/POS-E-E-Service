package BO.custom.impl;


import BO.custom.PartBo;
import dao.custom.PartDao;
import dao.custom.impl.PartDaoImpl;
import dto.PartDto;
import entity.PartEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartBoImpl implements PartBo<PartDto> {
    private PartDao partDao = new PartDaoImpl();

    @Override
    public boolean savePart(PartDto dto) throws SQLException, ClassNotFoundException {
        return partDao.save(new PartEntity(
                dto.getCode(),
                dto.getName(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()
        ));
    }

    @Override
    public boolean addQuantity(PartDto dto) throws SQLException, ClassNotFoundException {

        //QTY on hand, before added new QTY
        int qtyBalance = getPartByCode(dto.getCode()).getQtyOnHand();

        return partDao.update(new PartEntity(
                dto.getCode(),
                dto.getName(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()+qtyBalance//Balance QTY added new QTY
        ));
    }

    @Override
    public boolean deletePart(String code) throws SQLException, ClassNotFoundException {
        return partDao.delete(code);
    }

    @Override
    public List<PartDto> allParts() throws SQLException, ClassNotFoundException {
        List<PartEntity> entityList = partDao.getAll();
        List<PartDto> list = new ArrayList<>();

        for(PartEntity part : entityList){
            list.add(new PartDto(
                    part.getCode(),
                    part.getName(),
                    part.getUnitPrice(),
                    part.getQtyOnHand()
            ));
        }
        return list;
    }

    @Override
    public PartDto getPartByCode(String code) throws SQLException, ClassNotFoundException {
        PartEntity entity = partDao.searchByCode(code);
        return new PartDto(
                entity.getCode(),
                entity.getName(),
                entity.getUnitPrice(),
                entity.getQtyOnHand()
        );
    }
}

package BO.custom;

import BO.SupperBo;
import dto.CustomerDto;
import dto.PartDto;
import dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface PartBo<T> extends SupperBo {
    boolean savePart(T dto) throws SQLException, ClassNotFoundException;
    public boolean addQuantity(PartDto dto) throws SQLException, ClassNotFoundException;
    boolean deletePart(String id) throws SQLException, ClassNotFoundException;
    List<PartDto> allParts() throws SQLException, ClassNotFoundException;
    PartDto getPartByCode(String code) throws SQLException, ClassNotFoundException;
}

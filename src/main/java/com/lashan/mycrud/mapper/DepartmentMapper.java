package com.lashan.mycrud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTACE = Mappers.getMapper(DepartmentMapper.class);

}

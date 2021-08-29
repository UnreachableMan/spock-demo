package com.spock.demo.util;

import com.spock.demo.dto.OrderDto;
import com.spock.demo.param.OrderCreateParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DataMapperUtil {
    DataMapperUtil INSTANCE  = Mappers.getMapper(DataMapperUtil.class);

    OrderDto toOrderDto(OrderCreateParam param);

}

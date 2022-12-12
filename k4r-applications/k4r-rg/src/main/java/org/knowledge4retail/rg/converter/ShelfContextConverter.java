package org.knowledge4retail.rg.converter;

import org.knowledge4retail.rg.dto.ShelfContextDto;
import org.knowledge4retail.rg.model.ShelfContext;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShelfContextConverter {

    ShelfContextConverter INSTANCE = Mappers.getMapper(ShelfContextConverter.class);

    ShelfContextDto ShelfContextToDto(ShelfContext ShelfContext);
    ShelfContext dtoToShelfContext(ShelfContextDto dto);
    List<ShelfContextDto> shelfContextsToDtos(List<ShelfContext> ShelfContexts);
    List<ShelfContext> dtosToShelveContexts(List<ShelfContextDto> shelves);
}

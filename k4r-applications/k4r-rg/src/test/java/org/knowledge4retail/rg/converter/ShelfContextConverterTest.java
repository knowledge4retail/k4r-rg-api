package org.knowledge4retail.rg.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.knowledge4retail.rg.dto.ShelfContextDto;
import org.knowledge4retail.rg.model.ShelfContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ShelfContextConverterTest {

    private static final String TEST_ITEM_NO = "TEST";

    private ShelfContextDto shelfContextDto;
    private ShelfContext shelfContext;

    @Before
    public void setUp() {

        shelfContextDto = ShelfContextDto.builder().imageUrl("MFS001").build();
        shelfContext = ShelfContext.builder().imageUrl("MFS002").build();
    }

    @Test
    public void testConvertDtoToModel()
    {
        ShelfContext newShelfContext = ShelfContextConverter.INSTANCE.dtoToShelfContext(shelfContextDto);
        Assert.assertEquals(shelfContextDto.getImageUrl(), newShelfContext.getImageUrl());
    }

    @Test
    public  void  testConvertModelToDto()
    {
        ShelfContextDto newDto = ShelfContextConverter.INSTANCE.ShelfContextToDto(shelfContext);
        Assert.assertEquals(shelfContext.getImageUrl(), newDto.getImageUrl());
    }


}

package org.knowledge4retail.rg.service;

import org.knowledge4retail.rg.dto.ShelfContextDto;

import java.util.List;

public interface ShelfContextService  {


    List<ShelfContextDto> read(String storeId, String productId);


    boolean exists(String storeId);
}

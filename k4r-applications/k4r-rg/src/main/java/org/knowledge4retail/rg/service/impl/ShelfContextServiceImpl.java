package org.knowledge4retail.rg.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.knowledge4retail.rg.converter.ShelfContextConverter;
import org.knowledge4retail.rg.dto.ShelfContextDto;
import org.knowledge4retail.rg.model.ShelfContext;
import org.knowledge4retail.rg.service.ShelfContextService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class ShelfContextServiceImpl implements ShelfContextService {


    @Override
    public List<ShelfContextDto> read(String storeId, String productId) {
        return ShelfContextConverter.INSTANCE.shelfContextsToDtos(assemble(storeId, productId));
    }

    public List<ShelfContext> assemble(String storeId, String productId) {

        //product -> List von ShelfId_ShelfMeter
        //  1) store: Entität mit dan und shelfId
        //  2) erstelle pro dan ein Bild
        return new ArrayList<ShelfContext> (){{ add(ShelfContext.builder().imageUrl("http://localhost:8090/k4r-rg/api/v0/ShelfContextImage/1212").build());}};
    }

    @Override
    public boolean exists(String storeId) {
        return false;
    }
    // Anbindung an DT API oder sonst keine Möglichkeit zu prüfen

}
package org.knowledge4retail.rg.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.knowledge4retail.rg.model.ShelfContext;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class ShelfContextServiceImplTest {

    private ShelfContextServiceImpl service;

    private ShelfContext shelfContext;


    @Before
    public void setUp() {

        service = new ShelfContextServiceImpl();

        shelfContext = ShelfContext.builder().imageUrl("http://localhost:8090/k4r-rg/api/v0/ShelfContextImage/1212").build();
    }



    @Test
    public void readShelfContexts() {

        service.read(any(), any());

    }


}
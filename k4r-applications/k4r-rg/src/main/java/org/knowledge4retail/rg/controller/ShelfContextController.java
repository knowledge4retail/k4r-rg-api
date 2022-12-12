package org.knowledge4retail.rg.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.knowledge4retail.rg.dto.ShelfContextDto;
import org.knowledge4retail.rg.service.ShelfContextService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
public class ShelfContextController {

    private final ShelfContextService shelfContextService;

    public ShelfContextController(ShelfContextService shelfContextService) {

        this.shelfContextService = shelfContextService;
    }


    @ApiOperation(
            value = "Returns ShelfContext with StoreId and ProductId given as Query Parameter.",
            response = ShelfContextDto.class,
            responseContainer = "List",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "ShelfContext successfully returned"),
                    @ApiResponse(code = 404, message = "ShelfContext with given Ids does not exist"),
            }
    )
    @GetMapping("api/v0/ShelfContexts")
    public ResponseEntity<List<ShelfContextDto>> getShelfContextByStoreAndProductId(@RequestParam("StoreId") String storeId, @RequestParam("ProductId") String productId, HttpServletRequest request) {

        log.debug(String.format("ShelfContextController getShelfContextById at %1$s called with storeId %2$s and productId %3$s"
                , request.getRequestURL()
                , storeId, productId));
        return new ResponseEntity<>(shelfContextService.read(storeId, productId), HttpStatus.OK);
    }

}

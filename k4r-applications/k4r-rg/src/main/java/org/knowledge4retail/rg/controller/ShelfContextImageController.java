package org.knowledge4retail.rg.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.knowledge4retail.rg.service.ShelfContextImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ShelfContextImageController {

    private final ShelfContextImageService shelfContextImageService;


    @ApiOperation(
            value = "/get-image-with-media-type",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "ShelfContextImage successfully returned"),
                    @ApiResponse(code = 404, message = "ShelfContextImage with given Ids does not exist"),
            }
    )
    @GetMapping("api/v0/ShelfContextImage/{imageId}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getShelfContextImageById(@PathVariable("imageId") String imageId, HttpServletRequest request) {

        log.debug(String.format("ShelfContextImageController getShelfContextImageById at %1$s called with imageId %2$s"
                , request.getRequestURL()
                , imageId));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s.jpg", imageId));
        ByteArrayResource resource = new ByteArrayResource(shelfContextImageService.loadImage(imageId));

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


    @ApiOperation(
            value = "Upload Image file"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "ShelfContextImage successfully uploaded"),
                    @ApiResponse(code = 422, message = "ShelfContextImage could nor be uploaded"),
            }
    )
    @PostMapping("/api/v0/ShelfContextImage/")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        log.debug(String.format("ShelfContextImageController handleFileUpload at %1$s called with File %2$s"
                , request.getRequestURL()
                , file.getOriginalFilename()));

        shelfContextImageService.storeImage(file);

        return ResponseEntity.ok().body(String.format("Uploaded file %1$s", file.getOriginalFilename()));
    }


    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> handleStorageFileNotFound(IOException exc) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
}

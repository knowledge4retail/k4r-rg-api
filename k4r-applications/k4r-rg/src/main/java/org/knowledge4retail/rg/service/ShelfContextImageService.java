package org.knowledge4retail.rg.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ShelfContextImageService {
    byte[] loadImage(String imageId);
    void storeImage(MultipartFile file) throws IOException;
}

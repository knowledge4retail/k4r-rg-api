package org.knowledge4retail.rg.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Slf4j
@Service
public class ShelfContextImageServiceImpl implements org.knowledge4retail.rg.service.ShelfContextImageService {

    @Value("${org.knowledge4retail.rg-api.folder}")
    private String folder;

    @Override
    public byte[] loadImage(String imageId){ //Todo: Implement download

        log.debug(String.format(folder + "%s", imageId));
        //InputStream in = getClass().getResourceAsStream(String.format("/images/%s.webp", imageId));
        InputStream in = null;
        try {

            in = new FileInputStream(String.format(folder + "%s.jpg", imageId));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        byte[] bytes;
        try {
            bytes = IOUtils.toByteArray(in);
        } catch (IOException e) {
            e.printStackTrace();
            return "Picture not found".getBytes();
        }
        return bytes;
    }

    @Override
    public void storeImage(MultipartFile file) throws IOException {

        log.debug(folder + file.getOriginalFilename());
        file.transferTo(new File(folder + file.getOriginalFilename())); //Todo: Get path to Store
        //file.transferTo(new File("resources\\images\\" + file.getOriginalFilename()));

        log.debug(String.format("ShelfContextImageServiceImpl getShelfContextImageById called with filename %1$s",
                file.getOriginalFilename()));
    }


}

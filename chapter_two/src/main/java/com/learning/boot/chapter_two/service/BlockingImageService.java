package com.learning.boot.chapter_two.service;

import com.learning.boot.chapter_two.domain.Image;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class BlockingImageService {

    private final ImageService imageService;

    public BlockingImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    public List<Image> findAllImages() {
        return imageService.findAllImages()
                .collectList()
                .block(Duration.ofSeconds(10));
    }

    public Resource findOneImage(String filename) {
        return imageService
                .findOne(filename)
                .block(Duration.ofSeconds(10));
    }

    public void createImage(List<FilePart> files) {
        imageService.createImage(Flux.fromIterable(files))
                .block(Duration.ofMinutes(1));
    }
}

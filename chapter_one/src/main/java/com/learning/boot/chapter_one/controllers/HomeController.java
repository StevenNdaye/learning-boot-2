package com.learning.boot.chapter_one.controllers;

import com.learning.boot.chapter_one.domain.Image;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController(value = "api")
public class HomeController {

    @GetMapping
    public String greeting(@RequestParam(required = false, defaultValue = "") String name) {
        return name.equals("") ? "Hey!" : String.format("Hey, %s!", name);
    }

    @GetMapping("images")
    Flux<Image> images() {
        return Flux.just(
                new Image("1", "learning-spring-boot-cover.jpg"),
                new Image("1", "learning-spring-boot-2nd-edition-cover.jpg"),
                new Image("1", "bazinga.png")
        );
    }

    @PostMapping("images")
    Mono<Void> create(@RequestBody Flux<Image> images) {
        return images
                .map(image -> image)
                .then();
    }

}

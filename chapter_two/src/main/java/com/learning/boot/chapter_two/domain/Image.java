package com.learning.boot.chapter_two.domain;

import lombok.Data;

@Data
public class Image {
    private String id;
    private String name;

    public Image(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

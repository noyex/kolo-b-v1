package com.westeros.webapi.contract;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class PictureDto {
    private Long id;
    private Long movieId;
    private int height;
    private int width;
    private String filePath;
    private int voteCount;
    private double voteAverage;
}

package com.westeros.movies.mappers;

import com.westeros.data.model.Picture;
import com.westeros.moviesclient.contract.PictureDto;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper {

    public Picture toEntity(PictureDto dto) {
        Picture picture = new Picture();
        picture.setHeight(dto.height());
        picture.setWidth(dto.width());
        picture.setFilePath(dto.filePath());
        picture.setVoteAverage(dto.voteAverage());
        picture.setVoteCount(dto.voteCount());
        return picture;
    }

    public PictureDto toDto(Picture entity) {
        return new PictureDto(
                entity.getHeight(),
                entity.getWidth(),
                entity.getFilePath(),
                entity.getVoteAverage(),
                entity.getVoteCount()
        );
    }
}

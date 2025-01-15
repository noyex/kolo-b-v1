package com.westeros.webapi.services;


import com.westeros.data.repositories.ICatalogData;
import com.westeros.webapi.contract.PictureDto;
import com.westeros.webapi.services.mappers.IMappers;
import com.westeros.webapi.services.mappers.Mappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PictureService implements IPictureService {

    private final IMappers mappers;
    private final ICatalogData db;



    @Override
    public List<PictureDto> getPicturesForMovie(long movieId) {
        var movieOpt = db.getMovies().findById(movieId);
        var movie = movieOpt.get();

        var pictures = db.getPictures().findAll().stream()
                .filter(p -> p.getMovie() != null && p.getMovie().getId().equals(movieId))
                .toList();

        return pictures.stream()
                .map(p -> mappers.getPictureToDtoMapper().map(p))
                .toList();
    }

    @Override
    public PictureDto addPictureToMovie(long movieId, PictureDto dto) {
        var movieOpt = db.getMovies().findById(movieId);
        if (movieOpt.isEmpty()) {
            return null;
        }
        var movie = movieOpt.get();

        var picture = mappers.getPictureDtoToEntityMapper().map(dto);
        picture.setMovie(movie);

        db.getPictures().save(picture);

        var result = mappers.getPictureToDtoMapper().map(picture);
        result.setMovieId(movieId);
        return result;
    }

    @Override
    public List<PictureDto> getPicturesWithVoteCountAbove(long movieId, int voteCount) {
        var movieOpt = db.getMovies().findById(movieId);
        if (movieOpt.isEmpty()) {
            return null;
        }

        var pictures = db.getPictures().findAll().stream()
                .filter(p -> p.getMovie() != null
                        && p.getMovie().getId().equals(movieId)
                        && p.getVoteCount() > voteCount)
                .toList();

        return pictures.stream()
                .map(p -> mappers.getPictureToDtoMapper().map(p))
                .toList();
    }

    @Override
    public void deletePicture(long picId) {
        var pictureOpt = db.getPictures().findById(picId);
        if (pictureOpt.isEmpty()) {
            return;
        }
        db.getPictures().delete(pictureOpt.get());
    }
}

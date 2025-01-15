package com.westeros.movies.updater;

import com.westeros.data.model.Movie;
import com.westeros.data.model.Picture;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.data.repositories.PictureRepository;
import com.westeros.movies.mappers.PictureMapper;
import com.westeros.moviesclient.IMoviesPicturesClient;
import com.westeros.moviesclient.contract.PictureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicturesUpdater implements IUpdatePictures {

    private final ICatalogData catalogData;
    private final IMoviesPicturesClient picturesClient;
    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;

    @Autowired
    public PicturesUpdater(ICatalogData data, IMoviesPicturesClient picturesClient, PictureRepository pictureRepository, PictureMapper pictureMapper) {
        this.catalogData = data;
        this.picturesClient = picturesClient;
        this.pictureRepository = pictureRepository;
        this.pictureMapper = pictureMapper;
    }

    @Override
    public void updatePictures() {

        try {
            List<Movie> movies = catalogData.getMovies().findAll();

            for(Movie movie : movies){
                List<PictureDto> pictureDtos = picturesClient.getPictures(movie.getSourceId());

                for(PictureDto pictureDto : pictureDtos){
                    Picture picture = pictureMapper.toEntity(pictureDto);
                    picture.setMovie(movie);
                    pictureRepository.save(picture);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

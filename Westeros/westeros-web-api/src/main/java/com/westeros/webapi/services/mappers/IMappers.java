package com.westeros.webapi.services.mappers;

import com.westeros.data.model.Movie;
import com.westeros.data.model.Picture;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;
import com.westeros.webapi.contract.PictureDto;

public interface IMappers {

    IMap<MovieDto, Movie> getMovieDtoToEntityMapper();
    IMap<Movie, MovieSummaryDto> getMovieToSummaryDtoMapper();
    IMap<Movie, MovieDto> getMovieToDtoMapper();
    IMap<Picture, PictureDto> getPictureToDtoMapper();
    IMap<PictureDto, Picture> getPictureDtoToEntityMapper();
}

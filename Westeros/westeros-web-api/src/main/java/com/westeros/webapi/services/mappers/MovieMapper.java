package com.westeros.webapi.services.mappers;

import com.westeros.data.model.Movie;
import com.westeros.data.model.Picture;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;
import com.westeros.webapi.contract.PictureDto;
import org.springframework.stereotype.Component;

@Component
class MovieEntityMapper implements IMap<MovieDto, Movie>{

    public Movie map(MovieDto dto) {
        var movieEntity = new Movie();
        movieEntity.setRuntime(dto.getRuntime());
        movieEntity.setOverview(dto.getOverview());
        movieEntity.setReleaseDate(dto.getReleaseDate());
        movieEntity.setBudget(dto.getBudget());
        movieEntity.setOriginalTitle(dto.getTitle());
        movieEntity.setHomepage(dto.getHomepage());
        movieEntity.setOriginalLanguage(dto.getLanguage());
        return movieEntity;
    }
}

@Component
class MovieSummaryMapper implements IMap<Movie, MovieSummaryDto>{
    @Override
    public MovieSummaryDto map(Movie movie) {
        var dto = new MovieSummaryDto();
        dto.setId(movie.getId());
        dto.setLanguage(movie.getOriginalLanguage());
        dto.setTitle(movie.getOriginalTitle());
        dto.setHomepage(movie.getHomepage());
        return dto;
    }
}

@Component
class MovieDtoMapper implements IMap<Movie, MovieDto>{
    @Override
    public MovieDto map(Movie movie) {
        var dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setLanguage(movie.getOriginalLanguage());
        dto.setTitle(movie.getOriginalTitle());
        dto.setHomepage(movie.getHomepage());
        dto.setAdult(movie.isAdult());
        dto.setOverview(movie.getOverview());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setRuntime(movie.getRuntime());
        dto.setBudget(movie.getBudget());
        return dto;
    }
}

@Component
class PictureToDtoMapper implements IMap<Picture, PictureDto>{
    @Override
    public PictureDto map(Picture picture) {
        var dto = new PictureDto();
        dto.setId(picture.getId());
        dto.setHeight(picture.getHeight());
        dto.setWidth(picture.getWidth());
        dto.setFilePath(picture.getFilePath());
        dto.setVoteCount(picture.getVoteCount());
        dto.setVoteAverage(picture.getVoteAverage());
        return dto;
    }
}

@Component
class PictureDtoToEntityMapper implements IMap<PictureDto, Picture>{
    @Override
    public Picture map(PictureDto dto) {
        var picture = new Picture();
        picture.setId(dto.getId());
        picture.setHeight(dto.getHeight());
        picture.setWidth(dto.getWidth());
        picture.setFilePath(dto.getFilePath());
        picture.setVoteCount(dto.getVoteCount());
        picture.setVoteAverage(dto.getVoteAverage());
        return picture;
    }
}

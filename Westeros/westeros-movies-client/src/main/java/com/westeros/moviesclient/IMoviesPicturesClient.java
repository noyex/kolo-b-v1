package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.PictureDto;

import java.util.List;

public interface IMoviesPicturesClient {
    List<PictureDto> getPictures(long movieId);
}

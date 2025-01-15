package com.westeros.webapi.services;

import com.westeros.webapi.contract.PictureDto;

import java.util.List;

public interface IPictureService {
    List<PictureDto> getPicturesForMovie(long movieId);
    PictureDto addPictureToMovie(long movieId, PictureDto dto);
    List<PictureDto> getPicturesWithVoteCountAbove(long movieId, int voteCount);
    void deletePicture(long picId);
}
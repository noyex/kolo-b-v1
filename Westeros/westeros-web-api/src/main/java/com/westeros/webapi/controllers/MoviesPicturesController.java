package com.westeros.webapi.controllers;

import com.westeros.webapi.contract.PictureDto;
import com.westeros.webapi.services.IPictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pictures")
@RequiredArgsConstructor
public class MoviesPicturesController {

    private final IPictureService pictureService;
    @GetMapping("/{movie_id}")
    public ResponseEntity<List<PictureDto>> getPictures(@PathVariable("movie_id") long movieId, @RequestParam(name="vote_count", required=false) Integer voteCount){
        if (voteCount != null) {
            var pics = pictureService.getPicturesWithVoteCountAbove(movieId, voteCount);
            if (pics == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(pics);
        } else {
            var pics = pictureService.getPicturesForMovie(movieId);
            if (pics == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(pics);
        }
    }

    @PostMapping("/{movie_id}")
    public ResponseEntity<PictureDto> addPicture(@PathVariable("movie_id") long movieId, @RequestBody PictureDto pictureDto){
        var saved = pictureService.addPictureToMovie(movieId, pictureDto);
        if (saved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{pic_id}")
    public ResponseEntity<Void> deletePicture(@PathVariable("pic_id") long picId){

        var picturesBefore = pictureService.getPicturesForMovie(0);

        pictureService.deletePicture(picId);
        return ResponseEntity.noContent().build();
    }
}
package com.westeros.webapi.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/pictures")
@RequiredArgsConstructor
public class MoviesPicturesController {

    @GetMapping
    public ResponseEntity getPictures(@RequestParam long movieId){
        return ResponseEntity.ok("pictures");
    }
}

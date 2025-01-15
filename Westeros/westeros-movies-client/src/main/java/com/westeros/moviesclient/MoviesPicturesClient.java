package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.PictureDto;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MoviesPicturesClient implements IMoviesPicturesClient{

    RestTemplate restClient;

    IMoviesClientUriBuilderProvider provider;

    public MoviesPicturesClient(IMoviesClientUriBuilderProvider provider) {
        restClient = new RestTemplate();
        this.provider=provider;
    }

    record PicturesResponseDto(List<PictureDto> backdrops, List<PictureDto> posters){}

    @Override
    public List<PictureDto> getPictures(long movieId) {
        String url = provider.builder()
                .pathSegment("movie", movieId+"", "images")
                .build()
                .toUriString();
        System.out.println(url);
        return restClient.getForObject(url, PicturesResponseDto.class).backdrops();
    }
}

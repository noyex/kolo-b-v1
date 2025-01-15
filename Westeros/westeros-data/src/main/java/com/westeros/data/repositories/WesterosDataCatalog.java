package com.westeros.data.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class WesterosDataCatalog implements ICatalogData {

    private final CompanyRepository companies;
    private final MoviesRepository movies;
    private final ActorRepository actors;
    private final CharacterRepository character;
    private final CountryRepository countries;
    private final GenreRepository genres;
    private final LanguageRepository languages;
    private final PictureRepository pictures;


    public WesterosDataCatalog(CompanyRepository companies, MoviesRepository movies, ActorRepository actors, CharacterRepository character, CountryRepository countries, GenreRepository genres, LanguageRepository languages, PictureRepository pictures) {
        this.companies = companies;
        this.movies = movies;
        this.actors = actors;
        this.character = character;
        this.countries = countries;
        this.genres = genres;
        this.languages = languages;
        this.pictures = pictures;
    }

    public ActorRepository getActors() {
        return actors;
    }

    public CharacterRepository getCharacter() {
        return character;
    }

    public CountryRepository getCountries() {
        return countries;
    }

    public GenreRepository getGenres() {
        return genres;
    }

    public LanguageRepository getLanguages() {
        return languages;
    }

    @Override
    public PictureRepository getPictures() {
        return pictures;
    }

    @Override
    public CompanyRepository getCompanies() {
        return companies;
    }

    @Override
    public MoviesRepository getMovies() {
        return movies;
    }
}

package com.westeros;

import com.westeros.movies.updater.IUpdateMovies;
import com.westeros.movies.updater.IUpdatePictures;
import com.westeros.movies.updater.PicturesUpdater;
import com.westeros.moviesclient.IMoviesPicturesClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDate;

@EnableAsync
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = "com.westeros")
public class WesterosMoviesUpdaterApplication implements CommandLineRunner {

    private final IUpdateMovies updater;
    private final IUpdatePictures picturesUpdater;

    public WesterosMoviesUpdaterApplication(IUpdateMovies updater, PicturesUpdater picturesUpdater) {
        this.updater = updater;
        this.picturesUpdater = picturesUpdater;
    }

    public static void main(String[] args) {
        SpringApplication.run(WesterosMoviesUpdaterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        updater.updateByDateRange(LocalDate.now().minusDays(1), LocalDate.now());
        picturesUpdater.updatePictures();
    }
}

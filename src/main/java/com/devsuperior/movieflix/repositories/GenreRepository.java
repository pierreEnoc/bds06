package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	@Query("SELECT DISTINCT obj FROM Genre obj INNER JOIN obj.movies mov WHERE "
			+ "(COALESCE(:movies) IS NULL OR mov IN :movies) AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%') ) )")
	Page<Genre> find(List<Movie> movies, String name, Pageable pageable);

}

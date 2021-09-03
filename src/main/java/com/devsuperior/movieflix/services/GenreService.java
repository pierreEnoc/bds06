package com.devsuperior.movieflix.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	//@Autowired
	//private AuthService authService;
	
	//@PreAuthorize("hasAnyRole('ROLE_MEMBER')")
	@Transactional(readOnly = true)
	public Page<GenreDTO> findAllPaged(Long genreId, String name, PageRequest pageRequest) {
		List<Movie> movies = (genreId == 0)? null : Arrays.asList(movieRepository.getOne(genreId));
		Page<Genre> list = genreRepository.find(movies, name.trim(), pageRequest);
		return list.map(x -> new GenreDTO(x));
	}
	
	@Transactional(readOnly = true)
	public GenreDTO findById(Long id) {
		Optional<Genre> obj = genreRepository.findById(id);
		Genre entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new GenreDTO(entity, entity.getMovies());
	}
	
}

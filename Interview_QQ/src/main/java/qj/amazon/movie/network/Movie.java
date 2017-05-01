package qj.amazon.movie.network;

import java.util.List;

public class Movie {
	private int id;
	List<Movie> similarMovies;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Movie> getSimilarMovies() {
		return similarMovies;
	}
	public void setSimilarMovies(List<Movie> similarMovies) {
		this.similarMovies = similarMovies;
	}
	
	
}

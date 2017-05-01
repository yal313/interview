package qj.amazon.movie.network;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MovieNetwork {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setId(0);
		List<Movie> movieList1 = new ArrayList<Movie>();
		Movie m1 = new Movie();
		m1.setId(1);
		Movie m2 = new Movie();
		m2.setId(2);
		Movie m3 = new Movie();
		m3.setId(3);
		movieList1.add(m1);
		movieList1.add(m2);
		movieList1.add(m3);
		movie.setSimilarMovies(movieList1);
		List<Movie> movieList2 = new ArrayList<Movie>();
		Movie m4 = new Movie();
		m4.setId(4);		
		Movie m5 = new Movie();
		m5.setId(5);
		Movie m6 = new Movie();
		m6.setId(6);
		movieList2.add(m4);
		movieList2.add(m5);
		movieList2.add(m6);
		m1.setSimilarMovies(movieList2);
		List<Movie> movieList3 = new ArrayList<Movie>();
		Movie m7 = new Movie();
		m7.setId(7);
		m4.setSimilarMovies(movieList3);
		movieList3.add(m7);	
		
		List<Integer> list = printMovieDFS(movie);
		for(Integer n: list){
			System.out.println(n);
		}
		
		System.out.println("----------------");
		List<Integer> list1 = printMovieBFS(movie);
		for(Integer n: list1){
			System.out.println(n);
		}
	}
	
	public static List<Integer> printMovieDFS(Movie movie){
		List<Integer> visited = new ArrayList<Integer>();
		if(movie.similarMovies!=null){
			visited.add(movie.getId());
			dfsMovie(visited, movie.similarMovies);
		}
		
		return visited;
	}

	private static void dfsMovie(List<Integer> visited, List<Movie> similarMovies) {		
		for(Movie movie: similarMovies){
			if(!visited.contains(movie.getId())){
				visited.add(movie.getId());
				if(movie.similarMovies!=null){
					dfsMovie(visited, movie.similarMovies);
				}
			}
		}
	}
	
	public static List<Integer> printMovieBFS(Movie movie){
		List<Integer> list = new ArrayList<Integer>();
		LinkedList<Movie> queue = new LinkedList<Movie>();
		queue.add(movie);
		list.add(movie.getId());
		
		bfsMovie(list, queue);
		return list;
	}

	private static void bfsMovie(List<Integer> list,LinkedList<Movie> queue) {
		while(queue.size()!=0){
			Movie movie = queue.poll();
			if(movie.getSimilarMovies()!=null){
				for(Movie m1: movie.getSimilarMovies()){
					if(!list.contains(m1)){
						queue.add(m1);
						list.add(m1.getId());
					}
				}
			}
		}
	}
}

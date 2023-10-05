package br.com.fiap.seriesapi.data;

import java.util.List;

import br.com.fiap.seriesapi.model.Serie;

public class SerieDao {

	List<Serie> series = new List<>;
	
	public SerieDao() {
		var serie1 = new Serie(
				1L, 
				"Lost", 
				"Todos morreram...",
				"http..",
				4.0
			);
		var serie2 = new Serie(
				1L, 
				"Os Outros", 
				"Todos brigam...",
				"http..",
				5.0
			);
		series.add(serie1);
		series.add(serie2);
	}
	
	public List<Serie> findAll() {
		return series;
	}

}

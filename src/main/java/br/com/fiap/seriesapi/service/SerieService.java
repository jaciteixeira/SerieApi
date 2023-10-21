package br.com.fiap.seriesapi.service;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.seriesapi.data.SerieDao;
import br.com.fiap.seriesapi.model.Serie;

public class SerieService {
	
	SerieDao dao = new SerieDao();
	
	public List<Serie> findAll(){
		List<Serie> series;
		try {
			series = dao.findAll();
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
	}

	public Serie findById(Long id) {
		return dao.findById(id);
	}

	public void delete(Serie serie) {
		dao.delete(serie);
	}
}

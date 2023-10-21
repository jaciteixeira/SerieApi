package br.com.fiap.seriesapi.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.seriesapi.model.Serie;

public class SerieDao {

	private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private final String USER = "rm99627";
	private final String PASS = "051298";
	List<Serie> series = new ArrayList<>();

	public List<Serie> findAll() throws SQLException {
		var con = DriverManager.getConnection(URL, USER, PASS);
		var rs = con.createStatement().executeQuery("SELECT * FROM SERIES;");

		while(rs.next()) {
			series.add(new Serie(
							rs.getLong("id"),
							rs.getString("titulo"),
							rs.getString("sinopse"),
							rs.getString("poster"),
							rs.getDouble("nota")
					)
			);
		}
		con.close();
		return series;
	}

	public Serie findById(Long id){
//		
//		var con = DriverManager.getConnection(URL, USER, PASS);
//		var rs = con.createStatement().executeQuery("SELECT * FROM SERIES WHERE id = ?;");
//
//		Serie ser = rs.stream().filter(serie -> serie.id() == id).findFirst().orElse(null) ;
//		
//		con.close();
//		return ser;
		return series.stream().filter(serie -> serie.id() == id).findFirst().orElse(null);

	}

	public void delete(Serie serie) {
		series.remove(serie);
		System.out.println(series);
	}


}

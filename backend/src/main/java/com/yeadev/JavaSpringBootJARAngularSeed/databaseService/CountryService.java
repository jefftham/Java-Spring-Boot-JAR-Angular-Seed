package com.yeadev.JavaSpringBootJARAngularSeed.databaseService;

import com.yeadev.JavaSpringBootJARAngularSeed.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CountryService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CountryService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// inner class for row mapper
	class CountryRowMapper implements RowMapper<Country> {

		@Override
		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new Country();
			country.setId(rs.getLong("id"));
			country.setCountryName(rs.getString("countryname"));
			return country;
		}

	}

	public List<Country> findAll() {
		return jdbcTemplate.query("select * from country", new CountryRowMapper());
	}

	public Country findById(long id) {
		return jdbcTemplate.queryForObject("select * from country where id=?", new Object[] { id },
				new BeanPropertyRowMapper<>(Country.class));
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from country where id=?", id);
	}

	public int insert(Country country) {
		return jdbcTemplate.update("insert into country (id, countryname) " + "values(?, ?)",
				country.getId(), country.getCountryName());
	}

	public int update(Country country) {
		return jdbcTemplate.update("update country " + " set countryname = ? " + " where id = ?",
				country.getCountryName(), country.getId());
	}



}

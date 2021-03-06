package com.yeadev.JavaSpringBootJARAngularSeed.jdbc;

import com.yeadev.JavaSpringBootJARAngularSeed.jdbc.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// it can be annotate as @Repository or @Service
// normally, programmers named it CountryDao
// i prefer to use @Repository for JPA

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
		try {
			return jdbcTemplate.queryForObject("select * from country where id=?", new Object[] { id },
                    new BeanPropertyRowMapper<>(Country.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
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

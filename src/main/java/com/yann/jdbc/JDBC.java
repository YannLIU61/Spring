package com.yann.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import beans.Employee;

public class JDBC {
	private ApplicationContext ac;
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	{
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource = (DataSource) ac.getBean("dataSource");
		jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
		namedJdbcTemplate = (NamedParameterJdbcTemplate)ac.getBean("namedParameterJdbcTemplete");
	}

	public void getConnection() {
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Can not connect to database!");
		}
	}

	public void closeConnection() {
		try {
			dataSource.getConnection().close();
		} catch (Exception e) {
			System.out.println("Can not close the connection!");
		}
	}
	@Test
	public void queryForObjectList() {
		getConnection();
		String sql = "SELECT nom, prenom, solde_compte FROM USERS WHERE solde_compte > ?";
	
		closeConnection();
		System.out.println();
	}
	@Test
	public void queryForObject() {
		getConnection();
		System.out.println("Connected!");
		String sql = "SELECT nom, prenom, solde_compte FROM USERS WHERE id_user = ?";
		Employee em = jdbcTemplate.queryForObject(sql, Employee.class, 2);
		closeConnection();
		System.out.println(em);
	}

	@Test
	public void update() {
		getConnection();
		String sql = "UPDATE USERS SET prenom = ? WHERE id_user = ?";
		jdbcTemplate.update(sql, "Hello", 2);
		closeConnection();
	}

	/*
	 * Batch Insert
	 */
	@Test
	public void batchInsert() {
		String sql = "INSERT INTO USERS (login, mot_de_passe, nom, prenom, numero_compte,profil_user,solde_compte ) VALUES(?,?,?,?,?,?,?) ";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] { "test4", "111", "ha", "ha", "00004", "USER", 500000 });
		batchArgs.add(new Object[] { "test5", "112", "hei", "hei", "00005", "USER", 500000 });
		jdbcTemplate.batchUpdate(sql, batchArgs);
		closeConnection();
	}
	
	/*
	 * 也可以直接传一个对象
	 */
	@Test
	public void testNamedParamTemplate() {
		getConnection();
		String sql = "INSERT INTO USERS (login, mot_de_passe, nom, prenom, numero_compte,profil_user,solde_compte ) VALUES(:login,:mdp,:nom,:prenom,:nc,:pu,:sc) ";
		HashMap<String, Object> param = new HashMap<>();
		param.put("login", "T");
		param.put("mdp", "TTTT");
		param.put("nom", "T");
		param.put("prenom", "T");
		param.put("nc", 011);
		param.put("pu", "T");
		param.put("sc", 100);
		namedJdbcTemplate.update(sql, param);
//		SqlParameterSource paramSource= new BeanPropertySqlParameterSource(employee);
//		namedJdbcTemplate.update(sql, paramSource);
		closeConnection();
	}
}

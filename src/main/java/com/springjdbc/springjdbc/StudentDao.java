package com.springjdbc.springjdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Boolean saveStudent(final Student student) {
		String query="insert into student value(?,?,?)";
		return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, student.getRoll());
				ps.setString(2, student.getName());
				ps.setString(3, student.getCourse());
				return ps.execute();
			}
		});
	}
	
	public Boolean updatestu(final int id) {
		String query = "update student set  course=? where id=? ";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, "btech");
				ps.setInt(2, id);
				return ps.execute();
			}
		});
	}
	
	public Boolean delete(final int id) {
		String query = "delete from student where id=? ";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, id);
				return ps.execute();
			}
		});
	}
	public List<Student> getAllStu(){
		return jdbcTemplate.query("select *from student", new ResultSetExtractor<List<Student>>() {
		
			public List<Student> extractData(ResultSet rs)  throws SQLException, DataAccessException{
				List<Student> list = new ArrayList<Student>();
				while(rs.next()) {
					Student st = new Student();
					st.setRoll(rs.getInt(1));
					st.setName(rs.getString(2));
					st.setCourse(rs.getString(3));
					list.add(st);
				}
				return list;
			}
			
		});
	}

}

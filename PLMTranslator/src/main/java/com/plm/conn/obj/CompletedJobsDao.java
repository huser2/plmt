package com.plm.conn.obj;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class CompletedJobsDao implements QueueDataAccessObject {
	
	private DataSource dataSource;

	@Override
	public Queue saveQueue(Queue queue) {
		double i= Math.random();
		try {
			if(dataSource.getConnection()!=null){
			JdbcTemplate jdbcTemplate =  new JdbcTemplate(dataSource);
			int j = jdbcTemplate.update("INSERT INTO QUEUE(ID, CONTAINER, MSGID_PROD, MSGID_SEQ, EXPIRATION, MSG, PRIORITY, XID) VALUES("+132323+i+", 'Hellooo', 'Testing', 0, 0, '', 0, 'Waht');");
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Queue> getQueueList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQueue(Queue queue) {
		// TODO Auto-generated method stub

	}

	@Override
	public Queue getQueueById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource=ds;
		
	}

	@Override
	public DataSource getDataSource(DataSource ds) {
		return ds;
	}

}

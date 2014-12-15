package com.plm.conn.obj;

import java.util.List;

import javax.sql.DataSource;

public class QueueDao implements QueueDataAccessObject {

	@Override
	public Queue saveQueue(Queue queue) {
		// TODO Auto-generated method stub
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

	}

	@Override
	public DataSource getDataSource(DataSource ds) {
		return ds;

	}

}

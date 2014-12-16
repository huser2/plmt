package com.plm.conn.obj;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

public interface QueueDataAccessObject {

	void setDataSource(DataSource ds);

	DataSource getDataSource(DataSource ds);

	public Queue saveQueue(Queue queue);

	public ResultSet getQueueList();

	public void deleteQueue(Queue queue);

	public ResultSet getQueueById(String id);

}

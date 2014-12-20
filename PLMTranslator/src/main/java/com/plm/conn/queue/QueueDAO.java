package com.plm.conn.queue;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

public interface QueueDAO {

	void setDataSource(DataSource ds);

	public DataSource getDataSource();

	public Queue saveQueue(Queue queue);

	public ResultSet getQueueList();

	public void deleteQueue(Queue queue);

	public ResultSet getQueueById(String id);

}

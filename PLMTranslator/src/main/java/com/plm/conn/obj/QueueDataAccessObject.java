package com.plm.conn.obj;

import java.util.List;

import javax.sql.DataSource;

public interface QueueDataAccessObject {

	void setDataSource(DataSource ds);

	DataSource getDataSource(DataSource ds);

	public Queue saveQueue(Queue queue);

	public List<Queue> getQueueList();

	public void deleteQueue(Queue queue);

	public Queue getQueueById(String id);

}

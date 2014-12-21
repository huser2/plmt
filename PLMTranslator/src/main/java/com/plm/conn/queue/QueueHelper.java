package com.plm.conn.queue;

import javax.sql.DataSource;

public class QueueHelper {
	
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

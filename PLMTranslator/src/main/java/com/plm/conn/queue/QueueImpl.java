package com.plm.conn.queue;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

public class QueueImpl implements QueueDAO {

	private DataSource dataSource;
	public int queue_Id;

	@Override
	public Queue saveQueue(Queue queue) {
		try {
			if (dataSource.getConnection() != null) {
				Connection conn = dataSource.getConnection();

				String insetSql = "INSERT INTO PLMT.QUEUE"
						+ "(CONTAINER, MSGID_PROD, MSGID_SEQ, EXPIRATION, PRIORITY, XID, MSG, ID)"
						+ "VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(insetSql,
						Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, queue.getDestination().getPhysicalName());
				stmt.setString(2, queue.getProducerId().toString());
				stmt.setInt(3, (int) queue.getProducerId().getValue());
				stmt.setInt(4, (int) queue.getJMSExpiration());

				byte[] chuck = { (byte) 0x00, (byte) 0x00, (byte) 0x00,
						(byte) 0x00, (byte) 0x00, (byte) 0x00 };

				Blob blob = conn.createBlob();
				blob.setBytes(1, chuck);

				stmt.setInt(5, queue.getPriority());
				stmt.setString(6, queue.getJMSXMimeType());
				stmt.setBlob(7, blob);
				stmt.setString(8, queue.getMessageId().toString());
				stmt.execute();

				int generatedkey = 0;
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs != null && rs.next()) {
					generatedkey = rs.getInt(1);
				}
				queue.setQueue_Id(generatedkey);
				
				stmt.close();
				conn.close();

			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queue;
	}

	@Override
	public ResultSet getQueueList() {
		ResultSet result = null;
		try {
			if (dataSource.getConnection() != null) {
				Connection conn = dataSource.getConnection();
				String selectSql = "SELECT * FROM PLMT.QUEUE";
				PreparedStatement stmt = conn.prepareStatement(selectSql);
				result = stmt.executeQuery();
				stmt.close();
				conn.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void deleteQueue(Queue queue) {

		try {
			if (dataSource.getConnection() != null) {
				Connection conn = dataSource.getConnection();
				String msgId = queue.getMessageId().toString();
				String deleteSql = "DELETE FROM  PLMT.QUEUE WHERE QUEUE_ID="
						+ msgId;
				PreparedStatement stmt = conn.prepareStatement(deleteSql);
				stmt.execute();
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet getQueueById(String id) {
		ResultSet result = null;

		try {
			String selectSql = "SELECT ID, CONTAINER, MSGID_PROD, MSGID_SEQ, EXPIRATION, MSG, PRIORITY, XID"
					+ "FROM PLMT.QUEUE WHERE QUEUE_ID=" + id;
			Connection conn = dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(selectSql);
			result = stmt.executeQuery();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;

	}

	
	@Override
	public DataSource getDataSource() {
		// TODO Auto-generated method stub
		return null;
	}

}

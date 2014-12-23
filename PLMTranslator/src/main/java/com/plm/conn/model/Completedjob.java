package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the COMPLETEDJOBS database table.
 * 
 */
@Entity
@Table(name="COMPLETEDJOBS")
@NamedQuery(name="Completedjob.findAll", query="SELECT c FROM Completedjob c")
public class Completedjob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMPLETED_ID", unique=true, nullable=false)
	private int completedId;

	@Column(name="COMPLETED_DATE")
	private Timestamp completedDate;

	@Column(length=250)
	private String container;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	private long expiration;

	@Lob
	private byte[] msg;

	@Column(name="MSGID_PROD", length=250)
	private String msgidProd;

	@Column(name="MSGID_SEQ")
	private long msgidSeq;

	private long priority;

	@Column(length=250)
	private String xid;

	//bi-directional many-to-one association to Queue
	@ManyToOne
	@JoinColumn(name="QUEUE_ID", nullable=false)
	private Queue queue;

	public Completedjob() {
	}

	public int getCompletedId() {
		return this.completedId;
	}

	public void setCompletedId(int completedId) {
		this.completedId = completedId;
	}

	public Timestamp getCompletedDate() {
		return this.completedDate;
	}

	public void setCompletedDate(Timestamp completedDate) {
		this.completedDate = completedDate;
	}

	public String getContainer() {
		return this.container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public long getExpiration() {
		return this.expiration;
	}

	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}

	public byte[] getMsg() {
		return this.msg;
	}

	public void setMsg(byte[] msg) {
		this.msg = msg;
	}

	public String getMsgidProd() {
		return this.msgidProd;
	}

	public void setMsgidProd(String msgidProd) {
		this.msgidProd = msgidProd;
	}

	public long getMsgidSeq() {
		return this.msgidSeq;
	}

	public void setMsgidSeq(long msgidSeq) {
		this.msgidSeq = msgidSeq;
	}

	public long getPriority() {
		return this.priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public String getXid() {
		return this.xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public Queue getQueue() {
		return this.queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

}
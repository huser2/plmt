package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the FAILEDJOBS database table.
 * 
 */
@Entity
@Table(name="FAILEDJOBS")
@NamedQuery(name="Failedjob.findAll", query="SELECT f FROM Failedjob f")
public class Failedjob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FAILED_ID", unique=true, nullable=false)
	private int failedId;

	@Column(length=250)
	private String container;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	private long expiration;

	@Column(name="FAILED_DATE")
	private Timestamp failedDate;

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

	public Failedjob() {
	}

	public int getFailedId() {
		return this.failedId;
	}

	public void setFailedId(int failedId) {
		this.failedId = failedId;
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

	public Timestamp getFailedDate() {
		return this.failedDate;
	}

	public void setFailedDate(Timestamp failedDate) {
		this.failedDate = failedDate;
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
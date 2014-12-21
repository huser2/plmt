package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUEUE_ID", unique=true, nullable=false)
	private int queueId;

	@Column(length=250)
	private String container;

	private long expiration;

	@Column(nullable=false, length=100)
	private String id;

	@Lob
	private byte[] msg;

	@Column(name="MSGID_PROD", length=250)
	private String msgidProd;

	@Column(name="MSGID_SEQ")
	private long msgidSeq;

	private long priority;

	@Column(length=250)
	private String xid;

	//bi-directional one-to-one association to Queue
	@OneToOne
	@JoinColumn(name="QUEUE_ID", nullable=false, insertable=false, updatable=false)
	private Queue queue;

	public Failedjob() {
	}

	public int getQueueId() {
		return this.queueId;
	}

	public void setQueueId(int queueId) {
		this.queueId = queueId;
	}

	public String getContainer() {
		return this.container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public long getExpiration() {
		return this.expiration;
	}

	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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
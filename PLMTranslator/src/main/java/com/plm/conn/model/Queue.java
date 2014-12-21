package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the QUEUE database table.
 * 
 */
@Entity
@Table(name="QUEUE")
@NamedQuery(name="Queue.findAll", query="SELECT q FROM Queue q")
public class Queue implements Serializable {
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

	//bi-directional one-to-one association to Completedjob
	@OneToOne(mappedBy="queue")
	private Completedjob completedjob;

	//bi-directional one-to-one association to Failedjob
	@OneToOne(mappedBy="queue")
	private Failedjob failedjob;

	public Queue() {
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

	public Completedjob getCompletedjob() {
		return this.completedjob;
	}

	public void setCompletedjob(Completedjob completedjob) {
		this.completedjob = completedjob;
	}

	public Failedjob getFailedjob() {
		return this.failedjob;
	}

	public void setFailedjob(Failedjob failedjob) {
		this.failedjob = failedjob;
	}

}
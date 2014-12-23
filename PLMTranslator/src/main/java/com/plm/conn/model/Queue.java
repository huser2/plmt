package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="QUEUE_ID", unique=true, nullable=false)
	private int queueId;

	@Column(length=250)
	private String container;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	private long expiration;

	@Lob
	private byte[] msg;

	@Column(name="MSG_ID", nullable=false, length=100)
	private String msgId;

	@Column(name="MSGID_PROD", length=250)
	private String msgidProd;

	@Column(name="MSGID_SEQ")
	private long msgidSeq;

	private long priority;

	@Column(name="PROCESS_DATE")
	private Timestamp processDate;

	@Column(length=250)
	private String xid;

	//bi-directional many-to-one association to Completedjob
	@OneToMany(mappedBy="queue")
	private Set<Completedjob> completedjobs;

	//bi-directional many-to-one association to Failedjob
	@OneToMany(mappedBy="queue")
	private Set<Failedjob> failedjobs;

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

	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
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

	public Timestamp getProcessDate() {
		return this.processDate;
	}

	public void setProcessDate(Timestamp processDate) {
		this.processDate = processDate;
	}

	public String getXid() {
		return this.xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	public Set<Completedjob> getCompletedjobs() {
		return this.completedjobs;
	}

	public void setCompletedjobs(Set<Completedjob> completedjobs) {
		this.completedjobs = completedjobs;
	}

	public Completedjob addCompletedjob(Completedjob completedjob) {
		getCompletedjobs().add(completedjob);
		completedjob.setQueue(this);

		return completedjob;
	}

	public Completedjob removeCompletedjob(Completedjob completedjob) {
		getCompletedjobs().remove(completedjob);
		completedjob.setQueue(null);

		return completedjob;
	}

	public Set<Failedjob> getFailedjobs() {
		return this.failedjobs;
	}

	public void setFailedjobs(Set<Failedjob> failedjobs) {
		this.failedjobs = failedjobs;
	}

	public Failedjob addFailedjob(Failedjob failedjob) {
		getFailedjobs().add(failedjob);
		failedjob.setQueue(this);

		return failedjob;
	}

	public Failedjob removeFailedjob(Failedjob failedjob) {
		getFailedjobs().remove(failedjob);
		failedjob.setQueue(null);

		return failedjob;
	}

}
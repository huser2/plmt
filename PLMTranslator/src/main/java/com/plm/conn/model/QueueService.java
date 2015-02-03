/*
 * 
 */
package com.plm.conn.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class QueueService.
 */
@Repository
@Transactional
public class QueueService implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(QueueService.class);

	/** The em. */
	@PersistenceContext
	private EntityManager em;

	
	public QueueService(){
		
	}
	/**
	 * Save.
	 *
	 * @param queue
	 *            the queue
	 * @return the queue
	 */
	public Queue save(Queue queue) {
		logger.info(" adding..." + queue);
		em.persist(queue);
		em.refresh(queue);
		return queue;
	}

	/**
	 * Save.
	 *
	 * @param completedjob
	 *            the completedjob
	 * @return the completedjob
	 */
	public Completedjob save(Completedjob completedjob) {
		logger.info(" adding..." + completedjob);
		Completedjob cjob = em.merge(completedjob);
		em.refresh(cjob);
		return cjob;

	}

	/**
	 * Save.
	 *
	 * @param failedjob
	 *            the failedjob
	 * @return the failedjob
	 */
	public Failedjob save(Failedjob failedjob) {
		logger.info(" adding..." + failedjob);
		Failedjob fjob = em.merge(failedjob);
		em.refresh(fjob);
		return fjob;
	}

	/**
	 * Removes the.
	 *
	 * @param queue
	 *            the queue
	 */
	public void remove(Object queue) {
		em.remove(queue);
	}

	/**
	 * Gets the completed job by msg id.
	 *
	 * @param id
	 *            the id
	 * @return the completed job by msg id
	 */
	public Completedjob getCompletedJobByMsgId(String id) {
		Completedjob completedjob = em.find(Completedjob.class, id);
		logger.info(" info..." + completedjob);
		return completedjob;

	}

	/**
	 * Gets the failed job by msg id.
	 *
	 * @param id
	 *            the id
	 * @return the failed job by msg id
	 */
	public Failedjob getFailedJobByMsgId(String id) {
		Failedjob failedjob = em.find(Failedjob.class, id);
		logger.info(" info..." + failedjob);
		return failedjob;

	}

	/**
	 * Gets the queue by queue id.
	 *
	 * @param id
	 *            the id
	 * @return the queue by queue id
	 */
	public Queue getQueueByQueueId(String id) {
		Queue queue = em.find(Queue.class, id);
		logger.info(" info..." + queue);
		return queue;

	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Queue> getQueues() {
		TypedQuery<Queue> query = em.createNamedQuery("Queue.findAll",
				Queue.class);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Completedjob> getCompletedQueues() {
		TypedQuery<Completedjob> query = em.createNamedQuery(
				"Completedjob.findAll", Completedjob.class);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<Failedjob> getFailedQueues() {
		TypedQuery<Failedjob> query = em.createNamedQuery("Failedjob.findAll",
				Failedjob.class);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}

	public void savePlmMapping(PlmMapping plmMapping) {
		em.persist(plmMapping);
	}

	public void deletePlmMapping(PlmMapping plmMapping) {
		em.remove(em.contains(plmMapping) ? plmMapping : em.merge(plmMapping));
	}

	public PlmMapping getPlmMapping(String plm) {
		PlmMapping mapping = em.find(PlmMapping.class, plm);
		return mapping;
	}

	public List<PlmMapping> getPlmMapping() {
		TypedQuery<PlmMapping> query = em.createNamedQuery(
				"PlmMapping.findAll", PlmMapping.class);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}

	public void savePlmAttributeList(PlmAttributeList plmAttributeList) {
		em.persist(plmAttributeList);
	}
	
	public void savePlmAttributeMappingList(PlmAttributeMapping plmAttributeMapping) {
		em.persist(plmAttributeMapping);
	}

	public void savePlmTypeList(PlmTypeList plmTypeList) {
		em.persist(plmTypeList);
	}

	public void deletePlmAttributeList(PlmAttributeList plmAttributeList) {
		em.remove(em.contains(plmAttributeList) ? plmAttributeList : em
				.merge(plmAttributeList));
	}

	public void deletePlmAttributeMapping(PlmAttributeMapping plmAttributeMapping) {
		em.remove(em.contains(plmAttributeMapping) ? plmAttributeMapping : em
				.merge(plmAttributeMapping));
	}
	
	public void deletePlmTypeList(PlmTypeList plmTypeList) {
		em.remove(em.contains(plmTypeList) ? plmTypeList : em
				.merge(plmTypeList));
	}

	public List<PlmAttributeList> getPlmAttributeList() {
		TypedQuery<PlmAttributeList> query = em.createNamedQuery(
				"PlmAttributeList.findAll", PlmAttributeList.class);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}

	public List<PlmAttributeList> getPlmAttributeListbyPlmName(String plmName) {

		TypedQuery<PlmAttributeList> query = em.createQuery(
				"SELECT p FROM PlmAttributeList p WHERE p.plmName = :name",
				PlmAttributeList.class);
		query.setParameter("name", plmName);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}

	public List<PlmAttributeMapping> getPlmAttributeMappingListbyPlmName(String plmName) {

		TypedQuery<PlmAttributeMapping> query = em.createQuery(
				"SELECT p FROM PlmAttributeMapping p WHERE p.id.plm1Name = ?1 AND p.id.plm2Name=?2",
				PlmAttributeMapping.class);
		query.setParameter(1, "Windchill");
		query.setParameter(2, plmName);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}
	
	public List<PlmTypeList> getPlmObjectTypeListbyPlmName(String plmName) {
		TypedQuery<PlmTypeList> query = em.createQuery(
				"SELECT p FROM PlmTypeList p WHERE p.plmName = :name",
				PlmTypeList.class);
		query.setParameter("name", plmName);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}

}

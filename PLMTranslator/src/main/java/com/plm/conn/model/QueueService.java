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

@Repository
@Transactional
public class QueueService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(QueueService.class);

	@PersistenceContext
	private EntityManager em;

	
	public void addQueue(Queue queue) {
		logger.info(" adding..." + queue.getId());
		em.persist(queue);
	}

	
	public List<Queue> getAll() {
		TypedQuery<Queue> query = em.createNamedQuery("Queue.findAll",
				Queue.class);
		logger.info(" info..." + query.getResultList());
		return query.getResultList();
	}

}

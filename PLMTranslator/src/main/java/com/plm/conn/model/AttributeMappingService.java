package com.plm.conn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.xbean.spring.generator.AttributeMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public class AttributeMappingService implements JpaRepository<AttributeMapping, Serializable> {

	@Override
	public Page<AttributeMapping> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Serializable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AttributeMapping arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends AttributeMapping> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Serializable arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AttributeMapping findOne(Serializable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AttributeMapping> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<AttributeMapping> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AttributeMapping> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttributeMapping> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AttributeMapping> findAll(Iterable<Serializable> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AttributeMapping getOne(Serializable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AttributeMapping> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AttributeMapping> S saveAndFlush(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}

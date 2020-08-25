package com.ma.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.ma.spring5webapp.model.Dummy;

public interface DummyRepository extends CrudRepository<Dummy, Long>{

}

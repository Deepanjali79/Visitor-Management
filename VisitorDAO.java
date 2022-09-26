package com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demo.entities.VisitorEntity;

@Repository
public interface VisitorDAO extends CrudRepository<VisitorEntity, Long> {

}

package com.saif.demo.solr.repo;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.saif.demo.model.solr.SolrEmployee;

@Repository
public interface EmployeeSolrDao extends SolrCrudRepository<SolrEmployee, String> {

    List<SolrEmployee> findByEmployeeName(String name);

}

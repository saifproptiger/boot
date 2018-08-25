package com.saif.demo.solr.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saif.demo.pojo.APIResponse;
import com.saif.demo.solr.service.EmployeeSolrIndexingService;

@RestController
@RequestMapping(value = "cron/solr-index/employee")
public class EmployeeSolrIndexingController {

    @Autowired
    private EmployeeSolrIndexingService employeeSolrIndexingService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public APIResponse solrIndexImployee(@RequestParam(required = false) Set<Integer> employeeIds) {
        return new APIResponse(employeeSolrIndexingService.indexEmployee(employeeIds));
    }

}

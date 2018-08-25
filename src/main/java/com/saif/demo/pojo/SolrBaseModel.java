package com.saif.demo.pojo;

import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;

public abstract class SolrBaseModel extends BaseModel {

    private static final long serialVersionUID = 2051537325598015702L;

    @Id
    @Indexed
    @Field("id")
    protected String          id;

    @PrePersist
    public abstract void prePersist();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

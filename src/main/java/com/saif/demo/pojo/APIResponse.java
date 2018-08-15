package com.saif.demo.pojo;

import java.io.Serializable;

public class APIResponse implements Serializable {

    public enum APIVersion {
        A, B, C, D
    }

    private static final long serialVersionUID = 8033303766487038967L;

    private APIVersion        version;

    private Integer           totalCount;

    private Serializable      data;

    public APIResponse(Serializable data) {
        this.data = data;
    }

    public APIResponse(Serializable data, Integer totalCount) {
        this.totalCount = totalCount;
        this.data = data;
    }

    public APIResponse(Serializable data, Integer totalCount, APIVersion version) {
        this.totalCount = totalCount;
        this.data = data;
        this.version = version;
    }

    public Serializable getData() {
        return data;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public APIVersion getVersion() {
        return version;
    }

    public void setData(Serializable data) {
        this.data = data;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setVersion(APIVersion version) {
        this.version = version;
    }

}

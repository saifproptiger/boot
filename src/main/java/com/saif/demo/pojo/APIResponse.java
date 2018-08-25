package com.saif.demo.pojo;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class APIResponse implements Serializable {

    public enum APIVersion {
        A, B, C, D
    }

    private static final long serialVersionUID = 8033303766487038967L;

    private APIVersion        version          = APIVersion.A;

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

    public APIResponse(Collection<?> data) {
        this.data = (Serializable) data;
    }

    public APIResponse(Collection<?> data, Integer totalCount) {
        this.totalCount = totalCount;
        this.data = (Serializable) data;
    }

    public APIResponse(Collection<?> data, Integer totalCount, APIVersion version) {
        this.totalCount = totalCount;
        this.data = (Serializable) data;
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

package com.saif.demo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StatusCode {

    SUCCESS("2XX"), BAD_REQUEST("400"), SERVER_ERROR("500");

    @JsonProperty
    private String name;

    private StatusCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

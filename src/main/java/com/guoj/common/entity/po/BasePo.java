package com.guoj.common.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
public class BasePo implements Serializable {
    public final static String DEFAULT_USERNAME = "system";
    private Long id = 0L;
    private String createdBy;
    private String updatedBy;
    private Date createdTime = Date.from(ZonedDateTime.now().toInstant());
    private Date updatedTime = Date.from(ZonedDateTime.now().toInstant());

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? DEFAULT_USERNAME : createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? DEFAULT_USERNAME : updatedBy;
    }
}

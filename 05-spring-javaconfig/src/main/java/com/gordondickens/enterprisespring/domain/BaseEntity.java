package com.gordondickens.enterprisespring.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Timestamp lastUpdateDate;

    public BaseEntity() {
        super();
    }

    public BaseEntity(BaseEntity baseEntity) {
        super();
        this.setLastUpdateDate(baseEntity.getLastUpdateDate());
    }

    @Column(name = "LAST_UPDATE_DATE")
    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @PrePersist
    protected void beforePersist() {
        this.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    protected void beforeUpdate() {
        this.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

package com.gordondickens.enterprisespring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Date: 11/18/12
 *
 * @author Gordon Dickens Dickens
 */
@Entity
public class ItemEntity extends BaseEntity {
    @Id
    Integer id;

    String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

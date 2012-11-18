package com.gordondickens.enterprisespring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author gordon
 * Date: 11/18/12
 * Time: 5:29 PM
 */
@Entity
public class ItemEntity {
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

package com.gordondickens.enterprisespring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Date: 11/18/12
 *
 * @author Gordon Dickens Dickens
 */
@Entity
@Table(name = "ITEM")
public class ItemEntity extends BaseEntity {
    @Id
    Integer id;

    String name;

    public Integer getId() {
        return id;
    }

    @Column(name = "ITEM_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

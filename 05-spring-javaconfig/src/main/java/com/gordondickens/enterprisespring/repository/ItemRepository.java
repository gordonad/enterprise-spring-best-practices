package com.gordondickens.enterprisespring.repository;

import com.gordondickens.enterprisespring.domain.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Date: 11/18/12
 *
 * @author Gordon Dickens
 */
@Repository
@Transactional
public interface ItemRepository extends JpaRepository<ItemEntity, Integer>,
        JpaSpecificationExecutor<ItemEntity>,
        QueryDslPredicateExecutor<ItemEntity> {
}

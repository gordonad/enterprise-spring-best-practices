package com.gordondickens.enterprisespring.service;

import com.gordondickens.enterprisespring.domain.ItemEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Date: 11/18/12
 *
 * @author Gordon Dickens
 */
@Service
@Transactional
public interface ItemService {

    public ItemEntity findItemById(final Integer id);

}

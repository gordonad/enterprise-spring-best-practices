package com.gordondickens.enterprisespring.service.internal;

import com.gordondickens.enterprisespring.domain.ItemEntity;
import com.gordondickens.enterprisespring.repository.ItemRepository;
import com.gordondickens.enterprisespring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * enterprise-spring-parent
 * <p/>
 * Date: 12/15/12
 * <p/>
 *
 * @author Gordon Dickens
 */
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public ItemEntity findItemById(final Integer id) {
        return itemRepository.findOne(id);
    }
}

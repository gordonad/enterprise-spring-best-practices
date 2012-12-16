package com.gordondickens.enterprisespring.service;

import com.gordondickens.enterprisespring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gordon Dickens
 *         Date: 11/18/12
 *         Time: 5:35 PM
 */
@Service
@Transactional
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
}

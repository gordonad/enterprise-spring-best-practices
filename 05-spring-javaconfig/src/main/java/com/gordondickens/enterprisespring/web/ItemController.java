package com.gordondickens.enterprisespring.web;

import com.gordondickens.enterprisespring.domain.ItemEntity;
import com.gordondickens.enterprisespring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * enterprise-spring-parent
 * <p/>
 * Date: 12/15/12
 * <p/>
 *
 * @author Gordon Dickens
 */
@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    @RequestMapping("/{id}")
    public ItemEntity getItemById(@PathVariable("id") final Integer id) {
        return itemService.findItemById(id);

    }

}

package com.fresh_produce.fresh_produce_api.service;

import com.fresh_produce.fresh_produce_api.controllers.dto.ItemDTO;
import com.fresh_produce.fresh_produce_api.repositories.entities.Item;

public interface ItemService {
    Item save(ItemDTO itemDTO);
    Item update(ItemDTO itemDTO, Integer itemID);
    void delete(Integer itemId);
    Iterable<Item> findAll();
    Item findById(Integer itemId);

}

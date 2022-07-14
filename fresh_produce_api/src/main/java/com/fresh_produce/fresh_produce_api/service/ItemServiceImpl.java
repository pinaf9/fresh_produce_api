package com.fresh_produce.fresh_produce_api.service;


import com.fresh_produce.fresh_produce_api.controllers.dto.ItemDTO;
import com.fresh_produce.fresh_produce_api.repositories.ItemRepository;
import com.fresh_produce.fresh_produce_api.repositories.entities.Item;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(ItemDTO itemDTO) {
        Item item = new Item(itemDTO);
        return itemRepository.save(item);
    }

    @Override
    public Item update(ItemDTO itemDTO, Integer itemId) {
        Item itemFromDb = findById(itemId);

//        update the players information
        if(itemDTO.getName() == null){
            itemFromDb.setName(itemFromDb.getName());
        } else if(itemDTO.getName().isEmpty()) {
            itemFromDb.setName(itemFromDb.getName());
        } else {
            itemFromDb.setName(itemDTO.getName());
        }

        if(itemDTO.getImageUrl() == null){
            itemFromDb.setImageUrl(itemFromDb.getImageUrl());
        } else if(itemDTO.getImageUrl().isEmpty()) {
            itemFromDb.setImageUrl(itemFromDb.getImageUrl());
        } else {
            itemFromDb.setImageUrl(itemDTO.getImageUrl());
        }


        itemFromDb.setQuantity(itemDTO.getQuantity() != null ? itemDTO.getQuantity() : itemFromDb.getQuantity());
        itemFromDb.setPrice(itemDTO.getPrice() != null ? itemDTO.getPrice() : itemFromDb.getPrice());

//        save the player back to the DB
//        return the player to the client
        return itemRepository.save(itemFromDb);
    }

    @Override
    public void delete(Integer itemId) {

        Optional<Item> itemToDelete = itemRepository.findById(itemId);

        if(itemToDelete.isPresent()){
            itemRepository.deleteById(itemId);
            throw new ResponseStatusException(HttpStatus.OK, "The item has been successfully deleted");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The item was not found.");
        }

    }

    @Override
    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(Integer itemId) {
        Optional<Item> optionalItem = itemRepository.findById(itemId);
        if(optionalItem.isEmpty()){
            return null;
        }
        return optionalItem.get();
    }
}


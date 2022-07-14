package com.fresh_produce.fresh_produce_api.controllers;

import com.fresh_produce.fresh_produce_api.controllers.dto.ItemDTO;
import com.fresh_produce.fresh_produce_api.repositories.entities.Item;
import com.fresh_produce.fresh_produce_api.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public Item createItem(@RequestBody ItemDTO newItemDTO){
        return itemService.save(newItemDTO);
    }

    @GetMapping
    public Iterable<Item> getItem(){
        return itemService.findAll();
    }

//    @GetMapping("/find")
//    public Item findItemByName(@RequestParam String name){
//        return itemService.findByName(name);
//    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable("id") Integer itemId){
        return itemService.findById(itemId);
    }

    @PutMapping("/update/{id}")
    public Item updateItem(@RequestBody ItemDTO itemDTO, @PathVariable("id") Integer itemId){
        return itemService.update(itemDTO, itemId);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") Integer itemId){
        itemService.delete(itemId);
    }
}

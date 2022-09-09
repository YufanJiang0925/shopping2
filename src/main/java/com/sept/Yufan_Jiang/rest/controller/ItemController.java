package com.sept.Yufan_Jiang.rest.controller;

import com.sept.Yufan_Jiang.rest.dao.ItemDao;
import com.sept.Yufan_Jiang.rest.exception.ItemException;
import com.sept.Yufan_Jiang.rest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody Item item) throws ItemException {
        if(item == null){
            throw new ItemException("item is null");
        }
        String id = item.getId();
        Item item1 = itemDao.getItem(id);
        if(item1 != null){
            return "item " + id + " exists!";
        }
        itemDao.createItem(item);
        return "Create succeeded";
    }

    @RequestMapping(value = "/item{id}",method = RequestMethod.GET)
    public String getItem(@PathVariable String id) throws ItemException {
        if(id == null || id.equals("")){
            throw new ItemException("id is null");
        }
        Item item = itemDao.getItem(id);
        if(item == null){
            return "no result";
        }
        return item.toString();
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String getItemList() throws ItemException {
        List<Item> itemList = itemDao.getItemList();
        if(itemList == null){
            return "no result";
        }
        return itemList.toString();
    }

    @RequestMapping(value = "/item",method = RequestMethod.PUT)
    public String update(Item item) throws ItemException{
        if(item.getId() == null || item.getId().equals("")){
            throw new ItemException("id is null");
        }
        itemDao.updateItem(item);
        return "Update succeeded";
    }

    @RequestMapping(value = "/item",method = RequestMethod.DELETE)
    public String delete(String id) throws ItemException {
        if(id == null || id.equals("")){
            throw new ItemException("id is null");
        }
        itemDao.deleteItem(id);
        return "Delete succeeded";
    }

}

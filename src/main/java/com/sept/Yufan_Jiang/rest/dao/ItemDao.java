package com.sept.Yufan_Jiang.rest.dao;

import com.sept.Yufan_Jiang.rest.exception.ItemException;
import com.sept.Yufan_Jiang.rest.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemDao {

    private List<Item> itemList = new ArrayList<Item>();

    public ItemDao(){
        Item item = new Item("001","item001","this is item001",99,"image/item001.jpg");
        Item item2 = new Item("002","item002","this is item002",199,"image/item002.jpg");
        Item item3 = new Item("003","item003","this is item003",299,"image/item003.jpg");
        itemList.add(item);
        itemList.add(item2);
        itemList.add(item3);
    }

    public void createItem(Item item){
        itemList.add(item);
    }

    public List<Item> getItemList() throws ItemException {
        return itemList;
    }

    public Item getItem(String id) throws ItemException{
        for(Item item : itemList){
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public void updateItem(Item item2) throws ItemException{
        for(int i = 0 ; i < itemList.size() ; i ++){
            Item item = itemList.get(i);
            if(item.getId().equals(item2.getId())){
                if(item2.getName() != null) item.setName(item2.getName());
                if(item2.getPrice() != 0.0d) item.setPrice(item2.getPrice());
                if(item2.getDesc() != null) item.setDesc(item2.getDesc());
                if(item2.getImagePath() != null) item.setImagePath(item2.getImagePath());
                itemList.set(i,item);
                break;
            }
        }
    }

    public void deleteItem(String id) throws ItemException{
        for(int i = 0 ; i < itemList.size() ; i ++){
            if(itemList.get(i).getId().equals(id)){
                itemList.remove(i);
                break;
            }
        }
    }

}

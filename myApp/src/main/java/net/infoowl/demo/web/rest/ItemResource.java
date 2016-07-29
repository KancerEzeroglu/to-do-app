package net.infoowl.demo.web.rest;

import net.infoowl.demo.domain.Item;
import net.infoowl.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kancer on 26.07.2016.
 */

@RestController
@RequestMapping("/items")
public class ItemResource {

    @Autowired
    private ItemRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List findItems(){
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item){
        item.setId(null);
        return repo.saveAndFlush(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id){
        updatedItem.setId(id);
        return repo.saveAndFlush(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Integer id) {
        repo.delete(id);
    }
}

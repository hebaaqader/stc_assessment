package com.filemanager.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.model.Item;
import com.filemanager.model.PermissionGroup;
import com.filemanager.model.enums.ItemType;
import com.filemanager.repository.ItemRepository;
import com.filemanager.service.interfaces.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(ItemType type, String name, PermissionGroup permissionGroup) {
        if (checkItemExists(type, name)) {
            throw new IllegalArgumentException("Item with type " + type.name() + " and name " + name + " already exists");
        }
        Item item = new Item(type, name, permissionGroup);
        return itemRepository.save(item);
    }

    @Override
    public Item createItem(ItemType type, String name, Item parenItem) {
        if (checkItemExists(type, name)) {
            throw new IllegalArgumentException("Item with type " + type.name() + " and name " + name + " already exists");
        }
        Item item = new Item(type, name, parenItem);
        return itemRepository.save(item);
    }

    private boolean checkItemExists(ItemType type, String name) {
        return itemRepository.findByNameAndTypeIgnoreCase(name, type.name()) != null;
    }

    @Override
    public Item getItemByNameAndType(ItemType type, String name) {
        return itemRepository.findByNameAndTypeIgnoreCase(type.name(), name);
    }

    
}

package com.filemanager.service.interfaces;

import com.filemanager.model.Item;
import com.filemanager.model.PermissionGroup;
import com.filemanager.model.enums.ItemType;

public interface ItemService {

    Item createItem(ItemType type, String name, PermissionGroup permissionGroup);
    
    Item createItem(ItemType type, String name, Item parenItem);

    Item getItemByNameAndType(ItemType type, String name);
}

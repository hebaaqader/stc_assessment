package com.filemanager.facade.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.facade.interfaces.SpaceFacade;
import com.filemanager.model.Item;
import com.filemanager.model.PermissionGroup;
import com.filemanager.model.enums.ItemType;
import com.filemanager.service.interfaces.ItemService;
import com.filemanager.service.interfaces.PermissionGroupService;

@Service
public class SpaceFacadeImpl implements SpaceFacade {

    @Autowired
    private ItemService itemService;

    @Autowired
    private PermissionGroupService permissionGroupService;

    @Override
    public Item createSpace(String spaceName, String permissionGroupName) {
        
        PermissionGroup permissionGroup = permissionGroupService.creatPermissionGroup(permissionGroupName);
        Item item = itemService.createItem(ItemType.SPACE, spaceName, permissionGroup);
        return item;

    }

}

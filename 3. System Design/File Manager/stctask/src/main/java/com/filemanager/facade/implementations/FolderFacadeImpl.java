package com.filemanager.facade.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.facade.interfaces.FolderFacade;
import com.filemanager.model.Item;
import com.filemanager.model.enums.ItemType;
import com.filemanager.service.interfaces.ItemService;

@Service
public class FolderFacadeImpl implements FolderFacade {

    @Autowired
    private ItemService itemService;

    @Override
    public Item createFolder(String spaceName, String folderName){

        return itemService.createItem(ItemType.FOLDER, folderName, validateFolderAndSpace(spaceName, folderName));

    }

    private Item validateFolderAndSpace(String spaceName, String folderName) {

        Item space = itemService.getItemByNameAndType(ItemType.SPACE, spaceName);
        if( space == null){
            throw new IllegalArgumentException("Space " + spaceName + " does not exist. Please Enter a valid space.");
        }

        Item folder = itemService.getItemByNameAndType(ItemType.FOLDER, spaceName);
        if(folder != null && folder.getParent().getId() == space.getId() ){
            throw new IllegalArgumentException("Folder  " + folderName + " already exists under Space " + spaceName);
        }

        return space;
    }
}

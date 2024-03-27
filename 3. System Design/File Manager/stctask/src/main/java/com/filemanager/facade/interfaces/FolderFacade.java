package com.filemanager.facade.interfaces;

import com.filemanager.model.Item;

public interface FolderFacade {

    Item createFolder(String spaceName, String folderName);
    
}

package com.filemanager.facade.interfaces;

import com.filemanager.model.Item;

public interface SpaceFacade {
    
    Item createSpace(String spaceName, String permissionGroupName);

}

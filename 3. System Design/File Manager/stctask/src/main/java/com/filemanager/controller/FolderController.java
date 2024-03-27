package com.filemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.facade.interfaces.FolderFacade;
import com.filemanager.model.Item;

@RestController
@RequestMapping("/api/folders")
public class FolderController {
    
   @Autowired
   private FolderFacade folderFacade;

    @PostMapping
    public ResponseEntity<Item> createFolder(@RequestParam String spaceName, @RequestParam String folderName) {
        
        Item createdFolder = folderFacade.createFolder(spaceName, folderName);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdFolder);

    }

}

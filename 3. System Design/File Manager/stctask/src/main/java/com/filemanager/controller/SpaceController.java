package com.filemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filemanager.dto.SpaceDTO;
import com.filemanager.facade.interfaces.SpaceFacade;
import com.filemanager.model.Item;
import com.filemanager.model.Permission;
import com.filemanager.service.interfaces.PermissionService;

@RestController
@RequestMapping("/api/spaces")
public class SpaceController {
    
     @Autowired
    private SpaceFacade spaceService;

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public ResponseEntity<SpaceDTO> createSpace(@RequestBody SpaceDTO requestBody) {
        
        Item space = spaceService.createSpace(requestBody.getSpaceName(), requestBody.getPermissionGroupName());
        List<Permission> createdPermissions = permissionService.createPermissions(requestBody.getPermissions(), space.getPermissionGroup());

        return ResponseEntity.status(HttpStatus.CREATED).body(new SpaceDTO(space.getName(), space.getPermissionGroup().getGroupName(), createdPermissions));

    }
}

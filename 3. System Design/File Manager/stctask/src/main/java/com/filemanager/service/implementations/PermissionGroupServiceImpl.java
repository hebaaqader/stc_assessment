package com.filemanager.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.model.PermissionGroup;
import com.filemanager.repository.PermissionGroupRepository;
import com.filemanager.service.interfaces.PermissionGroupService;

@Service
public class PermissionGroupServiceImpl implements PermissionGroupService {

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Override
    public PermissionGroup creatPermissionGroup(String permissionGroupName) {
        // Create permission group if not exists
        PermissionGroup permissionGroup = permissionGroupRepository.findByGroupName(permissionGroupName);
        if (permissionGroup == null) {
            permissionGroup = new PermissionGroup(permissionGroupName);
            permissionGroup = permissionGroupRepository.save(permissionGroup);
        }
        return permissionGroup;
    }

}

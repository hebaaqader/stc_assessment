package com.filemanager.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filemanager.model.Permission;
import com.filemanager.model.PermissionGroup;
import com.filemanager.model.enums.PermissionLevel;
import com.filemanager.repository.PermissionsRepository;
import com.filemanager.service.interfaces.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionsRepository permissionsRepository;

    @Override
    public Permission createPermission(String userName, PermissionLevel permissionLevel, PermissionGroup group) {
        Permission permission = new Permission(userName, permissionLevel, group);
        return permissionsRepository.save(permission);
    }

    @Override
    public List<Permission> createPermissions(List<Permission> permissions, PermissionGroup group) {
        for (Permission permission : permissions) {
            permission.setGroup(group);
        }
        return permissionsRepository.saveAll(permissions);
    }
    
}

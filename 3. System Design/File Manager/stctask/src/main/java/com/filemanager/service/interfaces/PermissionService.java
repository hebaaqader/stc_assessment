package com.filemanager.service.interfaces;

import java.util.List;

import com.filemanager.model.Permission;
import com.filemanager.model.PermissionGroup;
import com.filemanager.model.enums.PermissionLevel;

public interface PermissionService {

    Permission createPermission(String userName, PermissionLevel permissionLevel, PermissionGroup group);

    List<Permission> createPermissions(List<Permission> permissions, PermissionGroup group);
}

package com.filemanager.dto;

import java.util.List;

import com.filemanager.model.Permission;

public class SpaceDTO {

    private String spaceName;
    private String permissionGroupName;
    private List<Permission> permissions;

    
    public SpaceDTO() {
    }

    public SpaceDTO(String spaceName, String permissionGroupName, List<Permission> permissions) {
        this.spaceName = spaceName;
        this.permissionGroupName = permissionGroupName;
        this.permissions = permissions;
    }

    public String getSpaceName() {
        return spaceName;
    }
    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }
    public String getPermissionGroupName() {
        return permissionGroupName;
    }
    public void setPermissionGroupName(String permissionGroupName) {
        this.permissionGroupName = permissionGroupName;
    }
    public List<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    
}

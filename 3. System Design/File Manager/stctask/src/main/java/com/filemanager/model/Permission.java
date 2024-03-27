package com.filemanager.model;

import javax.persistence.*;

import com.filemanager.model.enums.PermissionLevel;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    @Enumerated(EnumType.STRING)
    private PermissionLevel permissionLevel;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private PermissionGroup group;
    
    public Permission() {
    }

    public Permission(String userEmail, PermissionLevel permissionLevel, PermissionGroup group) {
        this.userEmail = userEmail;
        this.permissionLevel = permissionLevel;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public PermissionGroup getGroup() {
        return group;
    }

    public void setGroup(PermissionGroup group) {
        this.group = group;
    }

    
}
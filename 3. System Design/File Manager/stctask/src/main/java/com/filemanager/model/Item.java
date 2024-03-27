package com.filemanager.model;

import javax.persistence.*;

import com.filemanager.model.enums.ItemType;

@Entity
@Table( name = "item" )
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ItemType type;

    private String name;

    @ManyToOne
    @JoinColumn(name = "permission_group_id")
    private PermissionGroup permissionGroup;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Item parent;

    public Item(){

    }
    
    public Item(ItemType type, String name, PermissionGroup permissionGroup) {
        this.type = type;
        this.name = name;
        this.permissionGroup = permissionGroup;
    }

    public Item(ItemType type, String name, Item parent) {
        this.type = type;
        this.name = name;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionGroup getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(PermissionGroup permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    public Item getParent() {
        return parent;
    }

    public void setParent(Item parent) {
        this.parent = parent;
    }
    
    
}

package com.filemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filemanager.model.Permission;

@Repository
public interface PermissionsRepository extends JpaRepository<Permission, Long> {

}
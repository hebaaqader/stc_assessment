package com.filemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filemanager.model.File;

@Repository
public interface FilesRepository extends JpaRepository<File, Long> {

}
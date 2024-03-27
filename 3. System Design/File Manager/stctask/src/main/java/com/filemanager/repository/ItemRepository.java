package com.filemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.filemanager.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE UPPER(i.type) = UPPER(:type) AND i.name = :name")
    Item findByNameAndTypeIgnoreCase(@Param("type") String type ,@Param("name") String name);

}
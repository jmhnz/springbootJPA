package com.springbootpractice.jpa.repository;

import com.springbootpractice.jpa.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {

    @Query(value = "select l.* from sale s join line_item l on s.id = l.order_id where s.id = :id", nativeQuery = true)
    List<LineItem> findLineItems(@Param("id") Long id);
}

package com.todolist.core.repository;

import com.todolist.core.model.ListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository of the lists
 */
@Repository
public interface ListRepository extends JpaRepository<ListModel, Long> {
}

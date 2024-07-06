package com.todolist.core.services;

import com.todolist.core.model.ListModel;
import com.todolist.core.repository.ListRepository;
import org.springframework.stereotype.Service;

/**
 * Service that can be used to work with the list repository
 */
@Service
public class ListService {
    private ListRepository listRepository;

    public ListService(ListRepository listRepository){
        this.listRepository = listRepository;

    }
}

package com.example.TO_DO_LIST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final List<Todo> todoList = new ArrayList<>();
    private Long idCounter = 1L;

    public Todo addTodo(Todo todo) {
        todo.setId(idCounter++);
        todoList.add(todo);
        return todo;
    }

    public List<Todo> getAllTodos() {
        return todoList;
    }
    
    public Todo updateTodo(Long id, Todo updatedTodo) {
        for (Todo t : todoList) {
            if (t.getId().equals(id)) {
                t.setTitle(updatedTodo.getTitle());
                t.setStatus(updatedTodo.getStatus());
                return t;
            }
        }
        return null;
    }

    public String deleteTodo(Long id) {
        todoList.removeIf(t -> t.getId().equals(id));
        return "Deleted Successfully";
    }
}
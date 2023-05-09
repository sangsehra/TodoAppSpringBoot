package com.todoapp.todoapp.Controller;

import com.todoapp.todoapp.Entities.Todo;
import com.todoapp.todoapp.Repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller("/todo")
@NoArgsConstructor
@AllArgsConstructor
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public String getAllTodos(Model model) {
        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        model.addAttribute("newTodo", new Todo());
        return "todos";
    }

    @PostMapping("/todos")
    public String addTodo(@ModelAttribute("newTodo") Todo todo) {
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/todos/{id}/edit")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/todos/{id}/edit")
    public String saveEditForm(@PathVariable("id") long id, Todo todo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            todo.setId(id);
            return "edit";
        }

        todoRepository.save(todo);
        return "redirect:/";
    }
}

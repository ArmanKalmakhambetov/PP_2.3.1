package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.model.User;
import web.service.UserService;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "home";
    }

    @PostMapping(value = "/save")
    public String saveUser(Model model, String name, String lastName, Byte age) {

        userService.add(name, lastName, age);
        model.addAttribute("users", userService.getAllUsers());
        return "home";

    }

    @PostMapping(value = "/remove")
    public String deleteUser(Model model, @RequestParam(name = "id") Long id) {
        userService.deleteUser(id);
        model.addAttribute("users", userService.getAllUsers());
        return "home";
    }

    @GetMapping(value = "/edit")
    public String editUser(Model model, @RequestParam(name = "id") Long id) {

        model.addAttribute("userEdit", userService.findById(id));
        model.addAttribute("users", userService.getAllUsers());
        return "home";
    }

    @PostMapping(value = "/update")
    public String updateUser(Model model, @RequestParam(name = "id") Long id,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "lastName") String lastName,
                             @RequestParam(name = "age") byte age) {
        userService.updateUser(new User(id, name, lastName, age));
        model.addAttribute("users", userService.getAllUsers());
        return "home";

    }


}

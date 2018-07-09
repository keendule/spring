package mvc.controller;

import mvc.model.User;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model model){

        List<User> users = userService.getUsers();

        model.addAttribute("users",users);

        return "user/list-users";
    }

    @GetMapping("user-add-form")
    public String userAddForm(Model model){

        User user = new User();

        model.addAttribute("user",user);

        return "user/user-form";
    }

    @GetMapping("user-update-form")
    public String userUpdateForm(@RequestParam("userId") int id, Model model) {
        User user = userService.getUser(id);

        model.addAttribute("user",user);
        model.addAttribute("update", true);

        return "user/user-form";
    }

    @PostMapping("save-user")
    public String saveUser(@ModelAttribute("user") User user){

        userService.addUser(user);

        return "redirect:/user/list";
    }

    @PostMapping("update-user")
    public String updateUser(@ModelAttribute("user") User user){

        userService.updateUser(user);

        return "redirect:/user/list";
    }

    @GetMapping("delete-user")
    public String deleteUser(@ModelAttribute("userId") int id) {

        userService.deleteUser(id);

        return "redirect:/user/list";
    }



}

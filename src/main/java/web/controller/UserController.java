package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;


@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUserList(ModelMap module) {
        module.addAttribute("user", userService.getUserList());

        return "listUs";
    }
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, ModelMap module) {
        module.addAttribute("idUser", userService.getUserById(id));
        return "idUs";
    }

    @GetMapping("/new")
    public String saveUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String getUserById(ModelMap module,@PathVariable("id") int id) {
        module.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {

        userService.update(id, user);
        return  "redirect:/";

    }
    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

}

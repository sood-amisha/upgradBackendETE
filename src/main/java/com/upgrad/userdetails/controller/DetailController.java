package com.upgrad.userdetails.controller;

import com.upgrad.userdetails.model.Detail;
import com.upgrad.userdetails.model.User;
import com.upgrad.userdetails.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DetailController {

    @Autowired
    private DetailService postService;

   /* @RequestMapping("/posts")
    public String getUserPost(Model model, HttpSession session) {
        User user = (User) session.getAttribute("LoggedUser");
        List<Detail> posts = postService.getAllPosts(user.getId());
        model.addAttribute("posts", posts);
        return "home";
    }*/

    // AGENDA 1: Map the GET request to "/posts/newpost" -> to get the view of the newpost
    // AGENDA 2: Map the POST request to "/posts/create" -> to create the post for the user

    @RequestMapping(method = RequestMethod.GET, value = "/posts/newpost")
    public String newPost() {
        return "posts/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts/create")
    public String createNewPost(Detail newPhone, HttpSession session) {
        // Pick the User
        User user = (User) session.getAttribute("LoggedUser");
        newPhone.setUser(user);

        postService.createPost(newPhone);
        return "redirect:/posts";
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deletepost")
    public String deletePost(@RequestParam(name = "postId") Integer postId) {
        postService.deletePost(postId);
        return "redirect:/posts";
    }
}

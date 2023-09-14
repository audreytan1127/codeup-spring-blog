package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    @GetMapping("")
    @ResponseBody
    public String postIndex(){
        return "posts index page";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public String individualPost(@PathVariable long id){
        return "view an individual post";
    }
    @GetMapping("/create")
    @ResponseBody
    public String createPost(){
        return "view the form for creating a post";
    }
    @PostMapping("/create")
    @ResponseBody
    public String postCreatedPost(){
        return "create a new post";

    }
}

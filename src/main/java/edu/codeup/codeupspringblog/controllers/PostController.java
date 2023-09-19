package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.BlogPost;
import edu.codeup.codeupspringblog.repositories.BlogPostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private BlogPostRepository blogsDao;

    public PostController(BlogPostRepository blogsDao) {
        this.blogsDao = blogsDao;
    }


    @GetMapping("")
    public String postIndex(Model model) {
        model.addAttribute("blogposts", blogsDao.findAll());
        return "blogposts/index";
    }

    @GetMapping("/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        model.addAttribute("blogposts", blogsDao.getById(id));
        return "blogposts/show";
    }

    @GetMapping("/create")
    public String createPost() {
        return "blogposts/create";
    }

    @PostMapping("/create")
    public String postCreatedPost(@RequestParam(name = "title") String title, @RequestParam(name = "content") String content, Model model) {
        BlogPost newBlog = new BlogPost();
        newBlog.setTitle(title);
        newBlog.setBody(content);
        blogsDao.save(newBlog);
        return "redirect:/posts";

    }
}

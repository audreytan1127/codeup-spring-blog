package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.BlogPost;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.BlogPostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
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
    private UserRepository userDao;

    public PostController(BlogPostRepository blogsDao, UserRepository userDao) {
        this.blogsDao = blogsDao;
        this.userDao = userDao;
    }

    @GetMapping("")
    public String postIndex(Model model) {
        model.addAttribute("blogposts", blogsDao.findAll());
        return "blogposts/index";
    }

    @GetMapping("/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        if (blogsDao.existsById(id)) {
            BlogPost post = blogsDao.findById(id).get();
            model.addAttribute("blogpost", post);
            return "blogposts/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String createPost() {
        return "blogposts/create";
    }

    @PostMapping("/create")
    public String postCreatedPost(@RequestParam(name = "title") String title,
                                  @RequestParam(name = "content") String content) {
        User newUser = userDao.findById(1L).get();
        BlogPost newBlog = new BlogPost(title, content, newUser);
        blogsDao.save(newBlog);
        return "redirect:/posts";

    }
}

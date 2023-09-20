package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.BlogPost;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.BlogPostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import edu.codeup.codeupspringblog.services.EmailService;
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
    private EmailService emailService;

    public PostController(BlogPostRepository blogsDao, UserRepository userDao, EmailService emailService) {
        this.blogsDao = blogsDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    public String createPost(Model model) {
        model.addAttribute("blogpost", new BlogPost());
        return "blogposts/create";
    }

    @PostMapping("/create")
    public String postCreatedPost(@ModelAttribute BlogPost newPost) {
        User newUser = userDao.findById(1L).get();
        BlogPost newBlog = new BlogPost(
                newPost.getTitle(),
                newPost.getBody(),
                newUser
        );
        blogsDao.save(newBlog);
        emailService.prepareAndSendBlogs(newBlog, "You've created a new blog post!", "You have submitted a blog post!");
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String showEditPost(@PathVariable long id, Model model){
        BlogPost blogToEdit = blogsDao.findById(id).get();
        model.addAttribute("blogpost", blogToEdit);
        return "blogposts/edit";
    }
    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute BlogPost editPost){
        BlogPost blogToEdit = blogsDao.findById(id).get();
        blogToEdit.setTitle(editPost.getTitle());
        blogToEdit.setBody(editPost.getBody());
        blogsDao.save(blogToEdit);
        return "redirect:/posts";
    }
}

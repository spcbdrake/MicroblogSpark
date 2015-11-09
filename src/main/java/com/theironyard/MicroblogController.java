package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by benjamindrake on 11/9/15.
 */
@Controller
public class MicroblogController {

    ArrayList<Message> messages = new ArrayList();

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username =(String) session.getAttribute("username");
        model.addAttribute("username", username);
        model.addAttribute("messages", messages);
        return "home";
    }


    @RequestMapping("/login")
    public String login(HttpServletRequest request, String username) {
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping("/create-post")
    public String message(String post) {
        Message m = new Message(post, messages.size()+1);
        messages.add(m);
        return "redirect:/";
    }

    @RequestMapping("/delete-post")
    public String deletePost(Integer postid) {
        messages.remove(postid -1);
        return "redirect:/";
    }

}

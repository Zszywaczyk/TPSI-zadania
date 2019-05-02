package wizut.tpsi.lab9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class BlogPostController {

    @Autowired
    private BlogRepository blogRepository;

    @RequestMapping("/")
    public String home(Model model){

        try {
            model.addAttribute("Posts", blogRepository.getAllPosts());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "home";
    }

    @PostMapping("/newpost")
    public String newpost(BlogPost post) throws SQLException{
        blogRepository.createPost(post);
        return "redirect:/";
    }

    @PostMapping("/deletePost")
    public String deletePost(BlogPost post) throws SQLException{
        blogRepository.deletePost(post.getId());
        return "redirect:/";
    }

}

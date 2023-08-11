package shop.mtcoding.blogv2.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class BoardController {
    
    
    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
    
    
    @PostMapping("/board/save")
    public String save(BoardRequest.SaveDTO saveDTO){
        

        return "redirect:/";
    }

}

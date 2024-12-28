package org.mysite.myboard;


import lombok.RequiredArgsConstructor;
import org.mysite.myboard.write.WriteDTO;
import org.mysite.myboard.write.WriteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final WriteService writeService;

    @GetMapping("/")
    public String index(Model model) {
        List<WriteDTO> writeList = this.writeService.getAllWrites();
        model.addAttribute("writeList", writeList);
        return "index";
    }
}

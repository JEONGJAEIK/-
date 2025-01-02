package org.mysite.myboard.presentation.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.mysite.myboard.business.WriteService;
import org.mysite.myboard.dto.WriteDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final WriteService writeService;

    @GetMapping("/")
    public String Main(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<WriteDTO> writeList = this.writeService.getAllWrites(page);
        model.addAttribute("writeList", writeList);
        return "main";
    }
}

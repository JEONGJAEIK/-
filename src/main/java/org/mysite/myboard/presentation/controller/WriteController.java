package org.mysite.myboard.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.mysite.myboard.business.WriteService;
import org.mysite.myboard.dto.WriteDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class WriteController {

    private final WriteService writeService;

    @GetMapping(value = "/write/{id}")
    public String write(Model model, @PathVariable("id") Long id) {
        WriteDTO write = this.writeService.getWriteDTOById(id);
        model.addAttribute("write", write);
        return "write";
    }

    @GetMapping("/write/create")
    public String WriteCreate() {
        return "write_form";
    }

    @PostMapping("/write/create")
    public String WriteCreate(@RequestParam(value = "subject") String subject,
                              @RequestParam(value = "content") String content,
                              @RequestParam(value = "writer") String writer) {
        this.writeService.create(subject, content, writer, LocalDateTime.now());
        return "redirect:/";
    }


}

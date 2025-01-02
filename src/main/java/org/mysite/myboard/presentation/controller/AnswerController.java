package org.mysite.myboard.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.mysite.myboard.business.AnswerService;
import org.mysite.myboard.business.WriteService;
import org.mysite.myboard.presentation.entity.Write;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final AnswerService answerService;
    private final WriteService writeService;

    @PostMapping("/answer/{id}")
    public String AnswerCreate(Model model, @PathVariable("id") Long id,
                               @RequestParam(value = "content") String content,
                               @RequestParam(value = "writer") String writer) {
        Write write = this.writeService.getWriteById(id);
        this.answerService.create(write,content,writer);
        return String.format("redirect:/write/%s", id);
    }
}

package org.mysite.myboard.business;
import lombok.RequiredArgsConstructor;
import org.mysite.myboard.presentation.entity.Answer;
import org.mysite.myboard.presentation.entity.Write;
import org.mysite.myboard.data_access.AnswerRepositroy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepositroy answerRepository;

    public void create(Write write, String content, String writer) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setWriter(writer);
        answer.setCreateDate(LocalDateTime.now());
        answer.setWrite(write);
        this.answerRepository.save(answer);
    }
}

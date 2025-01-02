package org.mysite.myboard.dto;

import lombok.Getter;
import org.mysite.myboard.presentation.entity.Answer;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class WriteDTO {
    private Long id;
    private String subject;
    private String content;
    private String writer;
    private LocalDateTime createTime;
    private List<Answer> answers;

    public WriteDTO(Long id, String subject, String content, String writer, LocalDateTime createTime, List<Answer> answers) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.writer = writer;
        this.createTime = createTime;
        this.answers = answers;
    }

    public WriteDTO(String subject, String content) {
        this.subject = subject;
        this.content = content;
        this.writer = writer;
        this.createTime = createTime;
    }
}

package org.mysite.myboard.dto;

import lombok.Getter;
import org.mysite.myboard.presentation.entity.Write;

import java.time.LocalDateTime;

@Getter
public class AnswerDTO {
    private Long id;
    private String content;
    private String writer;
    private LocalDateTime createTime;
    private Write write;

    public AnswerDTO(Long id, String content, String writer, LocalDateTime createTime, Write write) {
        this.id = id;
        this.content = content;
        this.writer = writer;
        this.createTime = createTime;
        this.write = write;
    }
}

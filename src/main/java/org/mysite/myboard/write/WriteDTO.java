package org.mysite.myboard.write;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WriteDTO {
    private Integer id;
    private String subject;
    private String content;
    private String writer;
    private LocalDateTime createTime;

    public WriteDTO(Integer id, String subject, String content, String writer, LocalDateTime createTime) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.writer = writer;
        this.createTime = createTime;
    }

    public WriteDTO(String subject, String content, String writer, LocalDateTime createTime) {
        this.subject = subject;
        this.content = content;
        this.writer = writer;
        this.createTime = createTime;
    }
}

package org.mysite.myboard.write;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Write {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String writer;

    private LocalDateTime createTime;
}

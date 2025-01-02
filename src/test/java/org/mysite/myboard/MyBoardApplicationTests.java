package org.mysite.myboard;

import org.junit.jupiter.api.Test;
import org.mysite.myboard.business.WriteService;
import org.mysite.myboard.data_access.WriteRepositroy;
import org.mysite.myboard.presentation.entity.Write;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class MyBoardApplicationTests {

    @Autowired
    private WriteService writeService;

    @Test
    void contextLoads() {
        for (int i = 1; i < 300; i++) {
            String subject = String.format("테스트 데이터:[%03d]",i);
            String content = "내용x";
            String writer = "홍길동";
            LocalDateTime now = LocalDateTime.now();

            this.writeService.create(subject,content,writer,now);
        }
    }

}

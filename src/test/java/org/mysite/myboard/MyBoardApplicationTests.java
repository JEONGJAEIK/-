package org.mysite.myboard;

import org.junit.jupiter.api.Test;
import org.mysite.myboard.write.Write;
import org.mysite.myboard.write.WriteRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class MyBoardApplicationTests {

    @Autowired
    private WriteRepositroy writeRepositroy;

    @Test
    void contextLoads() {
        Write w1 = new Write();
        w1.setSubject("갖고싶다 고양이");
        w1.setContent("나만없어 고양이");
        w1.setWriter("고양이 없는 사람");
        w1.setCreateTime(LocalDateTime.now());
        this.writeRepositroy.save(w1);
    }

}

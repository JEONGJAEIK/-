package org.mysite.myboard.data_access;

import org.mysite.myboard.presentation.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepositroy extends JpaRepository<Answer, Long> {
}

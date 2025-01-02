package org.mysite.myboard.data_access;

import org.mysite.myboard.presentation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositroy extends JpaRepository<User, Long> {

}

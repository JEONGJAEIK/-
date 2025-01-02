package org.mysite.myboard.data_access;

import org.mysite.myboard.presentation.entity.Write;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface WriteRepositroy extends JpaRepository<Write, Long> {
    Page<Write> findAll(Pageable pageable);
}

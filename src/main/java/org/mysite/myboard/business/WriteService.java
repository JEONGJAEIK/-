package org.mysite.myboard.business;

import lombok.RequiredArgsConstructor;
import org.mysite.myboard.exception.DataNotFoundException;
import org.mysite.myboard.presentation.entity.Write;
import org.mysite.myboard.dto.WriteDTO;
import org.mysite.myboard.data_access.WriteRepositroy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WriteService {
    private final WriteRepositroy writeRepository;

    public Page<WriteDTO> getAllWrites(int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<Write> writes = writeRepository.findAll(pageable);
        Page<WriteDTO> writeDTOs = writes.map(write -> new WriteDTO(
                        write.getId(),
                        write.getSubject(),
                        write.getContent(),
                        write.getWriter(),
                        write.getCreateTime(),
                        write.getAnswers()));
        return writeDTOs;
    }

    public WriteDTO getWriteDTOById(Long id) {
        Optional<Write> write = writeRepository.findById(id);
        if (write.isPresent()) {
            return new WriteDTO(write.get().getId(),
                    write.get().getSubject(),
                    write.get().getContent(),
                    write.get().getWriter(),
                    write.get().getCreateTime(),
                    write.get().getAnswers());
        } else {
            throw new DataNotFoundException("없는 페이지 데스요");
        }
    }

    public Write getWriteById(Long id) {
        Optional<Write> write = writeRepository.findById(id);
        if (write.isPresent()) {
            return write.get();
        } else {
            throw new DataNotFoundException("없는 페이지 데스요");
        }
    }

    public void create(String subject, String content, String writer, LocalDateTime createTime) {
        Write write = new Write();
        write.setSubject(subject);
        write.setContent(content);
        write.setWriter(writer);
        write.setCreateTime(LocalDateTime.now());
        this.writeRepository.save(write);
    }
}

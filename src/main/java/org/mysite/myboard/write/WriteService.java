package org.mysite.myboard.write;

import lombok.RequiredArgsConstructor;
import org.mysite.myboard.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WriteService {
    private final WriteRepositroy writeRepository;

    public List<WriteDTO> getAllWrites() {
        List<Write> writes = writeRepository.findAll();
        return writes.stream()
                .map(write -> new WriteDTO(
                        write.getId(),
                        write.getSubject(),
                        write.getContent(),
                        write.getWriter(),
                        write.getCreateTime()))
                .collect(Collectors.toList());
    }

    public WriteDTO getWriteById(Integer id) {
        Optional<Write> write = writeRepository.findById(id);
        if (write.isPresent()) {
            return new WriteDTO(write.get().getId(),
                    write.get().getSubject(),
                    write.get().getContent(),
                    write.get().getWriter(),
                    write.get().getCreateTime());
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

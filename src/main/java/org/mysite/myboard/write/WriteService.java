package org.mysite.myboard.write;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
}

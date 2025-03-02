package webflux.webfluxStudy.domain.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import webflux.webfluxStudy.domain.entity.TestEntity;
import webflux.webfluxStudy.domain.repository.TestEntityRepository;

@Service
@AllArgsConstructor
public class TestEntityService {
    private final TestEntityRepository testEntityRepository;

    public Mono<TestEntity> createTest(TestEntity testEntity) {
        return testEntityRepository.save(testEntity);
    }


}

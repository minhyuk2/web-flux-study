package webflux.webfluxStudy.domain.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import webflux.webfluxStudy.domain.entity.TestEntity;

public interface TestEntityRepository extends ReactiveCrudRepository<TestEntity, Long> {
    Flux<TestEntity> findAll();
}


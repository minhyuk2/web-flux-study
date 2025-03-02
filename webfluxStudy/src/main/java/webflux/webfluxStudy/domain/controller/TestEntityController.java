package webflux.webfluxStudy.domain.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import webflux.webfluxStudy.domain.entity.TestEntity;
import webflux.webfluxStudy.domain.service.TestEntityService;

@RestController
@AllArgsConstructor
public class TestEntityController {

    private final TestEntityService testEntityService;

    @PostMapping
    public Mono<ResponseEntity<TestEntity>> createTestEntity(@RequestBody TestEntity testEntity) {
        return testEntityService.createTest(testEntity)
                .map(savedEntity -> ResponseEntity.status(HttpStatus.CREATED).body(savedEntity));
    } //mono 내부에 map으로 저장되기 때문에 Map으로 사용하는 것이라고 한다.

}

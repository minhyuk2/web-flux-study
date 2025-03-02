package webflux.webfluxStudy.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import webflux.webfluxStudy.domain.entity.TestEntity;
import webflux.webfluxStudy.domain.repository.TestEntityRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static reactor.core.publisher.Mono.when;

class TestEntityServiceTest {


    @InjectMocks
    private TestEntityService testEntityService;

    @Mock
    private TestEntityRepository testEntityRepository;

    private TestEntity testEntity;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testEntity = new TestEntity(1L, "testEntity1");
    }

    @Test
    void createTest() {
        // Given
//        when(testEntityRepository.save(testEntity)).thenReturn(Mono.just(testEntity));
        doReturn(Mono.just(testEntity)).when(testEntityRepository).save(testEntity);
        //doReturn을 통해 null이 리턴되지 않고 강제적으로 Mono가 리턴이 되게끔 설정하는 것이다.

        // When
        Mono<TestEntity> result = testEntityService.createTest(testEntity);

        // Then
        StepVerifier.create(result)
                .expectNextMatches(entity -> entity.getId().equals(1L))
                .verifyComplete();

        verify(testEntityRepository, times(1)).save(testEntity);

    }
}
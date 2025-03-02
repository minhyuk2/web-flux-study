package webflux.webfluxStudy.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//mongoDB를 쓰기 때문에 Document로 사용해야 한다.
@Document("test")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
    @Id
    private Long id;
    private String name;
}

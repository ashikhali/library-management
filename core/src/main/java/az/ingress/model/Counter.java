package az.ingress.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "counter")
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long counter;
}

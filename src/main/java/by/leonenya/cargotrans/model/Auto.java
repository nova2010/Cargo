package by.leonenya.cargotrans.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String number;

    String brand;

    String color;

    @Column(name = "lifting_capacity")
    String liftingCapacity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Auto auto = (Auto) o;
        return id != null && Objects.equals(id, auto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

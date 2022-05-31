package techCallenge.Argonaute.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import techCallenge.Argonaute.Entity.Argonaute;

@Repository
public interface ArgonauteRepository extends JpaRepository<Argonaute, Long > {

}

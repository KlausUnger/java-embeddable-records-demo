package at.spengergasse.jpaembeddablerecordsdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    private @Autowired PersonRepository personRepository;

    @Test
    void ensureSave() {
        Person p = Person.builder()
                         .username(new EmailAddress("u@spg.at"))
                         .password("geheim")
                         .build()
                         .addEmailAddress("unger@spg.at");

        personRepository.save(p);

        assertThat(p.getId()).isNotNull();
        assertThat(p.getVersion()).isNotNull();
    }
}
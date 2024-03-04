package at.spengergasse.jpaembeddablerecordsdemo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "persons")
public class Person extends AbstractPersistable<Long> {
    private @Version Integer version;
    private EmailAddress username;
    private String password;

    @ElementCollection
    @CollectionTable(name = "person_email_addresses",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "FK_person_email_addresses_2_person")))
    @Builder.Default
    private List<EmailAddress> emailAddresses = new ArrayList<>(3);

    public Person addEmailAddress(String eMail) {
        return addEmailAddress(new EmailAddress(eMail));
    }

    public Person addEmailAddress(EmailAddress emailAddress) {
        this.emailAddresses.add(emailAddress);
        return this;
    }
}

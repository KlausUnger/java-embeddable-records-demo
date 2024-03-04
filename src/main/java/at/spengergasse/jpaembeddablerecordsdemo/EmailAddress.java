package at.spengergasse.jpaembeddablerecordsdemo;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailAddress(
        @Column(name="email_address")
        @Email @NotBlank String value) {
}

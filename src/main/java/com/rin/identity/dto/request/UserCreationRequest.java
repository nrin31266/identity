package com.rin.identity.dto.request;

import com.rin.identity.validator.DobConstraint;
import com.rin.identity.validator.TextConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;
    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    @TextConstraint(value = "First name", message = "NOT_EMPTY")
    String firstName;
    @TextConstraint(value = "Last name", message = "NOT_EMPTY")
    String lastName;

    @DobConstraint(min = 16, message = "INVALID_DOB")
    LocalDate dob;
    List<String> roles;

}

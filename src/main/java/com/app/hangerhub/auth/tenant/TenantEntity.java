package com.app.hangerhub.auth.tenant;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "tenant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TenantEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tenant Name Can't Be Null")
    @Column(nullable = false, unique = true)
    @Size(min = 10, max = 100)
    private String name;

    @NotBlank(message = "subdomain Can't Be Null")
    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 30, message = "Subdomain must be between 3 and 30 characters.")
    @Pattern(regexp = "^[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$",
            message = "Subdomain must be lowercase, alphanumeric, and can only use hyphens internally.")
    private String subdomain;

    @Enumerated(EnumType.STRING)
    private TenantStatus status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

}

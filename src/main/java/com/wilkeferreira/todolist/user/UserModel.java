
package com.wilkeferreira.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * cria getter e setter automaticos
 * https://projectlombok.org/setup/maven
 ********************************
 * import lombok.Data;
 * import lombok.Getter;
 * import lombok.Setter;
 ********************************
 * @Data -> cria getter e setter
 * @Getter -> cria getter
 * @Setter -> cria setter
 ********************************
 */
@Data
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

}

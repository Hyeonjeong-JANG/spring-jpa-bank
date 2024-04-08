package org.example.bank.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Table(name = "user_tb")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    private String fullname;

    @CreationTimestamp // pc -> db (날짜주입)
    private LocalDateTime createdAt;

    @Builder
    public User(Integer id, String username, String password, String fullname, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.createdAt = createdAt;
    }
}
package org.example.bank.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessionUser {
    private Integer id;
    private String username;
    private String fullname;
    private LocalDateTime createdAt;

    @Builder
    public SessionUser(Integer id, String username, String fullname, LocalDateTime createdAt) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.createdAt = createdAt;
    }

    public SessionUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullname = user.getFullname();
        this.createdAt = user.getCreatedAt();
    }
}

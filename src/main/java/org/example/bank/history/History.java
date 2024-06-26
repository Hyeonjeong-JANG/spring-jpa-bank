package org.example.bank.history;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bank.account.Account;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@NoArgsConstructor
@Data
@Table(name = "history_tb")
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // select * from history_tb where sender = 1111 or receiver = 1111;
    @JsonIgnoreProperties({"user"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Account sender; // 보낸이 (1)

    @JsonIgnoreProperties({"user"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Account receiver; // 받는이 (2)

    @Column(nullable = false)
    private Long amount; // 이체 금액

    @Column(nullable = false)
    private Long senderBalance; // 보낸이 잔액

    @Column(nullable = false)
    private Long receiverBalance; // 받는이 잔액

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public History(Long id, Account sender, Account receiver, Long amount, Long senderBalance, Long receiverBalance, Timestamp createdAt) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.senderBalance = senderBalance;
        this.receiverBalance = receiverBalance;
        this.createdAt = createdAt;
    }
}
/**
 * // 이렇게 중복해서 정보를 받아두면 조인을 줄일 수 있음. 역정규화.
 * // 데이터를 이렇게 넣으려면 자주 바뀌지 않는 정보여야 한다.
 * // 계좌 히스토리에 풀네임이 있다면?
 * private String  senderFullname;
 * private String  receiverFullname;
 * // 계좌 히스토리에 계좌번호가 있다면?
 * private Long senderNumber;
 * private Long receiverNumber;
 * // 우리는 공부하기 위해서 조인을 할 것임.
 */

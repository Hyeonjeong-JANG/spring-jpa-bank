-- user_tb
INSERT INTO user_tb(username, password, fullname, created_at)
VALUES ('ssar', '1234', '홍길동', now()),
       ('cos', '1234', '임꺽정', now()),
       ('love', '1234', '이순신', now());

-- account_tb
INSERT INTO account_tb(user_id, number, password, balance, status, created_at)
VALUES (1, 1111, '1234', 600, true, now()),  --ssar
       (2, 2222, '1234', 1000, true, now()), --cos
       (3, 3333, '1234', 1300, true, now()), --love
       (1, 4444, '1234', 1000, true, now()), --ssar
       (2, 5555, '1234', 1100, true, now());
--cos

-- history_tb
INSERT INTO history_tb(sender_id, receiver_id, amount, sender_balance, receiver_balance, created_at)
VALUES (1, 2, 100, 900, 1100, now()),
       (1, 3, 100, 800, 1100, now()),
       (1, 4, 100, 700, 1100, now()),
       (1, 5, 100, 600, 1100, now()),
       (2, 3, 100, 1000, 1200, now()),
       (4, 3, 100, 1000, 1300, now()),
       (1, 3, 100, 500, 1400, now()),
       (3, 1, 100, 1300, 600, now());
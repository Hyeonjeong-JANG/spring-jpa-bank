package org.example.bank.account;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.bank._core.utils.ApiUtil;
import org.example.bank.user.SessionUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountController {
    private final AccountService accountService;
    private final HttpSession session;

    @GetMapping("/api/accounts")
    public ResponseEntity<?> accountList(){
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        AccountResponse.MainDTO respDTO = accountService.계좌목록보기(sessionUser.getId());
        return ResponseEntity.ok(new ApiUtil(respDTO));
    }
}
package org.example.bank.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    @Query("select h from History h join fetch h.sender s join fetch h.receiver where h.sender.number =:number or h.receiver.number = :number")
    List<History> findBySenderOrReceiver(@Param("number") int number);

}
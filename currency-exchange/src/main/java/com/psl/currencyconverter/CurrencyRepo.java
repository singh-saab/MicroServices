package com.psl.currencyconverter;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<CurrencyExchange,Long> {

    CurrencyExchange findByFromAndTo(String from ,String to);
}

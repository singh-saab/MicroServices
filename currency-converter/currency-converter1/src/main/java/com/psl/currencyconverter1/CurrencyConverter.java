package com.psl.currencyconverter1;


import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CurrencyConverter {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
    private BigDecimal totalCaluculatedAmount;
}

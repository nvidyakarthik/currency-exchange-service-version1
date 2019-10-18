package com.gymnasticbodies.microservices.currencyexchangeservice;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class ExchangeValue {
    @Id
    @NonNull private long id;
    @Column(name = "currency_from")
    @NonNull private String from;
    @Column(name = "currency_to")
    @NonNull private  String to;
    @NonNull private BigDecimal conversionMultiple;
    private int port;

}

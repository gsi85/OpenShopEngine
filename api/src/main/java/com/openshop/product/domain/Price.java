package com.openshop.product.domain;

import static com.openshop.validation.Validation.notNull;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Domain object representing a price.
 *
 * @author Laszlo_Sisa
 */
public class Price {

    private static final Currency NATIVE_CURRENCY = Currency.getInstance("USD");

    private final BigDecimal nativeAmount;
    private final Currency nativeCurrency;

    public Price(final BigDecimal nativeAmount, final Currency nativeCurrency) {
        notNull(nativeAmount, "nativeAmount can't be null!");
        notNull(nativeCurrency, "nativeCurrency can't be null!");

        this.nativeAmount = nativeAmount;
        this.nativeCurrency = nativeCurrency;
    }

    public BigDecimal getNativeAmount() {
        return nativeAmount;
    }

    public Currency getNativeCurrency() {
        return nativeCurrency;
    }
}

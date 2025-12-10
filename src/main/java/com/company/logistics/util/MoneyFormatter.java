package com.company.logistics.util;

import java.text.NumberFormat;
import java.util.Locale;

public final class MoneyFormatter {

    private static final NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private MoneyFormatter() {}

    public static String format(double value) {
        return fmt.format(value);
    }
}

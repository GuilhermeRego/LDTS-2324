package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    private int divisor;

    public DivisibleByFilter(int divisor) {
        this.divisor = divisor;
    }

    public boolean accept(Integer number) {
        return number % divisor == 0;
    }
}

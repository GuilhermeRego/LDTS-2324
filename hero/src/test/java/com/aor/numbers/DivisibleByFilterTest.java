package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivisibleByFilterTest {

    @Test
    public void TwoMustBeDivisibleByTwo() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        Assertions.assertTrue(divisibleByFilter.accept(2));
    }

    @Test
    public void ThreeMustNotBeDivisibleByTwo() {
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        Assertions.assertFalse(divisibleByFilter.accept(3));
    }
}
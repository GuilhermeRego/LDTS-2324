package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Filter;

import static org.junit.jupiter.api.Assertions.*;

class PositiveFilterTest {

    @Test
    public void TwoMustBePositive() {
        PositiveFilter positiveFilter = new PositiveFilter();
        Assertions.assertTrue(positiveFilter.accept(2));
    }

    @Test
    public void MinusTwoMustBeNotFalse() {
        PositiveFilter positiveFilter = new PositiveFilter();
        Assertions.assertFalse(positiveFilter.accept(-2));
    }

    @Test
    public void ZeroMustBeNotFalse() {
        PositiveFilter positiveFilter = new PositiveFilter();
        Assertions.assertFalse(positiveFilter.accept(0));
    }
}
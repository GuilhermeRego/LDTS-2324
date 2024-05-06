package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFiltererTest {

    @Test
    void filter_positives() {
        List<Integer> actual = Arrays.asList(1, -1, 7, 3, -2);
        List<Integer> expected = Arrays.asList(1, 7, 3);

        ListFilterer listFilterer = new ListFilterer(new PositiveFilter());
        List<Integer> positives = listFilterer.filter(actual);

        Assertions.assertEquals(positives, expected);
    }

    @Test
    void filter_no_positives() {
        List<Integer> actual = Arrays.asList(-1, -7, -3);
        List<Integer> expected = Arrays.asList();

        ListFilterer listFilterer = new ListFilterer(new PositiveFilter());
        List<Integer> positives = listFilterer.filter(actual);

        Assertions.assertEquals(positives, expected);
    }

    @Test
    void filter_divisibles_by_two() {
        List<Integer> actual = Arrays.asList(1, 8, 3, -2, 5, 4);
        List<Integer> expected = Arrays.asList(8, -2, 4);

        ListFilterer listFilterer = new ListFilterer(new DivisibleByFilter(2));
        List<Integer> divisibles = listFilterer.filter(actual);

        Assertions.assertEquals(divisibles, expected);
    }
}
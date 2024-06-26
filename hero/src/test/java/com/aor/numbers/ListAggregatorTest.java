package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    @Test
    public void sum() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = Arrays.asList(1,2,4,2,5);

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, new ListDeduplicator(), new ListSorter());

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        List<Integer> list = Arrays.asList(-1, -4, -5);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726() {
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);

        Mockito.when(deduplicator.deduplicate(Mockito.anyList(), Mockito.any())).thenReturn(Arrays.asList(1, 2, 4));

        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        ListAggregator aggregator = new ListAggregator();

        int distinct = aggregator.distinct(list, deduplicator, new ListSorter());

        Assertions.assertEquals(3, distinct);
    }
}

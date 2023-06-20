package filter.src.main.test.java;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import filter.src.main.java.AdminFilter;
import filter.src.main.java.AggregateFilter;
import filter.src.main.java.BasicFilter;
import filter.src.main.java.Filter;

public class AggregateFilterTest {

    private Filter filter1;
    private Filter filter2;

    private Filter aggregateFilter;

    @Before
    public void setup() {
        Map<String, String> property = new HashMap<String, String>();
        property.put("fruit", "mango");
        this.filter1 = new BasicFilter(property);

        this.filter2 = new AdminFilter(40);

        this.aggregateFilter = new AggregateFilter(List.of(filter1, filter2));
    }

    @Test
    public void testCase_MatchesBothFilters() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("fruit", "mango");
        testResource.put("role", "ADMINISTRATOR");
        testResource.put("age", "50");

        assertTrue(aggregateFilter.matches(testResource));
    }

    @Test
    public void testCase_DoesNotMatchAnyFilters() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("random", "value");
        assertFalse(aggregateFilter.matches(testResource));
    }

    @Test
    public void testCase_MatchOnlyFirstFilter() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("fruit", "mango");
        assertFalse(aggregateFilter.matches(testResource));
    }
    
    @Test
    public void testCase_MatchOnlySecondFilter() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("role", "administrator");
        testResource.put("age", "45");
        assertFalse(aggregateFilter.matches(testResource));
    }

    @Test
    public void testCase_EmptyFilterList() {
        Filter emptyAggregateFilter = new AggregateFilter(Collections.emptyList());
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("role", "administrator");
        // there is nothing to filter, so all resources are matched successfully
        assertTrue(emptyAggregateFilter.matches(testResource));
    }
    
}

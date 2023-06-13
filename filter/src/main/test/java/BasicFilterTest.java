package filter.src.main.test.java;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import filter.src.main.java.BasicFilter;
import filter.src.main.java.Filter;

public class BasicFilterTest {
 
    private Filter basicFilter;
    private Map<String, String> mockPropertiesToMatch;

    @Before
    public void setup() {
        this.mockPropertiesToMatch = new HashMap<String, String>();
        mockPropertiesToMatch.put("sport", "pingpong");
        mockPropertiesToMatch.put("fruit", "mango");

        this.basicFilter = new BasicFilter(this.mockPropertiesToMatch);
    }

    @Test
    public void testEmptyResource() {
        Map<String, String> emptyResource = new HashMap<String, String>();
        assertFalse(basicFilter.matches(emptyResource));
    }

    @Test
    public void testEmptyFilter() {
        BasicFilter emptyBasicFilter = new BasicFilter(new HashMap<String, String>());
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("sport", "pingpong");
        // an empty basic filter is True for every input since there is nothing to match/filter by
        assertTrue(emptyBasicFilter.matches(testResource));
    }

    @Test
    public void testFilterMatchesProperty(){
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("sport", "pingpong");
        testResource.put("fruit", "mango");
        assertTrue(basicFilter.matches(testResource));
    }

    @Test
    public void testFilterDoesNotMatchAnyProperty() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("random", "value");
        assertFalse(basicFilter.matches(testResource));
    }
    
    @Test
    public void testFilterDoesNotMatchOneProperty() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("sport", "pingpong");
        testResource.put("random", "value");
        assertFalse(basicFilter.matches(testResource));
    }

    @Test
    public void testFilter_KeyIsCaseSensitive() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("SPORT", "pingpong");
        assertFalse(basicFilter.matches(testResource));
    }

    @Test
    public void testFilter_ValueIsCaseInsensitive() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("sport", "PINGPONG");
        testResource.put("fruit", "MANGO");
        assertTrue(basicFilter.matches(testResource));
    }
}

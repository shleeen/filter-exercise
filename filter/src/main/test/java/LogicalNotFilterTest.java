package filter.src.main.test.java;

import filter.src.main.java.Filter;
import filter.src.main.java.LogicalNotFilter;
import filter.src.main.java.PropertyIsPresentFilter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class LogicalNotFilterTest {


    private Filter logicalNotFilter;
    private static String MOCK_KEY = "pet";
    private static String MOCK_VALUE = "dog";
    private Filter isPresentFilter = new PropertyIsPresentFilter(MOCK_KEY, MOCK_VALUE);

    @Before
    public void setup() {
        this.logicalNotFilter = new LogicalNotFilter(isPresentFilter);
    }
    
    @Test
    public void testNotFilter_WhenPropertyPresent() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put(MOCK_KEY, MOCK_VALUE);
        assertFalse(logicalNotFilter.matches(testResource));
    }

    @Test
    public void testNotFilter_WhenPropertyNotPresent() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("test", "random");
        assertTrue(logicalNotFilter.matches(testResource));
    }

    @Test
    public void testNotFilter_WhenPropertyKeyPresent() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put(MOCK_KEY, "");
        assertTrue(logicalNotFilter.matches(testResource));
    }
}

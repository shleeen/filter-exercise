package filter.src.main.test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import filter.src.main.java.Filter;
import filter.src.main.java.LessThanFilter;

public class LessThanFilterTest {
    
    private Filter lessThanFilter;
    private static final String MOCK_KEY_STRING = "count";
    private static final Integer MOCK_VALUE_THRESHOLD = 8;

    @Before
    public void setup() {
        this.lessThanFilter = new LessThanFilter(MOCK_KEY_STRING, MOCK_VALUE_THRESHOLD);
    }

    @Test
    public void testKeyNotFound() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("randomKey", "randomValue");
        assertFalse(lessThanFilter.matches(testResource));
    }

    @Test
    public void testStringValueIsProvidedForKey() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put(MOCK_KEY_STRING, "stringValue");
        assertThrows(NumberFormatException.class, () -> lessThanFilter.matches(testResource));
    }

    @Test
    public void testCharValueIsProvidedForKey() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put(MOCK_KEY_STRING, "$$$%");
        assertThrows(NumberFormatException.class, () -> lessThanFilter.matches(testResource));
    }


    @Test
    public void testBooleanValueIsProvidedForKey() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put(MOCK_KEY_STRING, "true");
        assertThrows(NumberFormatException.class, () -> lessThanFilter.matches(testResource));
    }

    @Test
    public void testNumericalValueIsLessThanThreshold() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put(MOCK_KEY_STRING, "3");
        testResource.put("randomKey", "2");
        assertTrue(lessThanFilter.matches(testResource));
    }

    @Test
    public void testNumericalValueIsGreaterThanThreshold() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put(MOCK_KEY_STRING, "30");
        testResource.put("randomKey", "2");
        assertFalse(lessThanFilter.matches(testResource));
    }
}

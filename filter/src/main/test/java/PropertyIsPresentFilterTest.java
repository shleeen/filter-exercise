package filter.src.main.test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import filter.src.main.java.Filter;
import filter.src.main.java.PropertyIsPresentFilter;

public class PropertyIsPresentFilterTest {
    
    private Filter propertyIsPresentFilter;
    private static final String MOCK_KEY_TO_MATCH = "fruit";
    private static final String MOCK_VALUE_TO_MATCH = "mango";

    @Before
    public void setup() {
        this.propertyIsPresentFilter = new PropertyIsPresentFilter(MOCK_KEY_TO_MATCH, MOCK_VALUE_TO_MATCH);
    }

    @Test
    public void testPropertyKeyIsPresent() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("animal", "lion");
        testResource.put(MOCK_KEY_TO_MATCH, "");
        assertFalse(propertyIsPresentFilter.matches(testResource));
    }

    @Test
    public void testPropertyValueIsPresent() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("animal", "lion");
        testResource.put("randomKey", MOCK_VALUE_TO_MATCH);
        assertFalse(propertyIsPresentFilter.matches(testResource));
    }

    @Test
    public void testPropertyIsPresent() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("animal", "lion");
        testResource.put("role", "admin");
        testResource.put(MOCK_KEY_TO_MATCH, MOCK_VALUE_TO_MATCH);
        assertTrue(propertyIsPresentFilter.matches(testResource));
    }

    @Test
    public void testPropertyIsNotPresent() {
        Map<String, String> testResource = new HashMap<String, String>();
        testResource.put("animal", "lion");
        assertFalse(propertyIsPresentFilter.matches(testResource));
    }

}

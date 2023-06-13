package filter.src.main.test.java;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import filter.src.main.java.AdminFilter;
import filter.src.main.java.Filter;

public class AdminFilterTest {

    private Filter adminFilter;
    private static final String INVALID_ROLE_KEY = "Role";
    private static final String INVALID_AGE_KEY = "Age";

    @Before
    public void setup() {
        this.adminFilter = new AdminFilter(20);
    }

    @Test
    public void test_EmptyResource() {
        Map<String, String> resource = new HashMap<String, String>();
        assertFalse(adminFilter.matches(resource));
    }

    @Test
    public void testAdminUser_OlderThanMinAge() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put("role", "administrator");
        resource.put("age", "35");
        assertTrue(adminFilter.matches(resource));
    }

    @Test
    public void testAdminUser_YoungerThanMinAge() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put("role", "administrator");
        resource.put("age", "15");
        assertFalse(adminFilter.matches(resource));
    }

    @Test
    public void testNonAdminUser() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put("role", "customer");
        assertFalse(adminFilter.matches(resource));
    }

    @Test
    public void testAdminUser_AgeKeyNotFound() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put("role", "administrator");
        assertFalse(adminFilter.matches(resource));
    }

    @Test
    public void testAdminUser_AgeKeyIsCaseSensitive() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put("role", "administrator");
        resource.put(INVALID_AGE_KEY, "15");
        assertFalse(adminFilter.matches(resource));
    }

    @Test
    public void testAdminUser_AgeValueIsCaseInsensitive() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put("role", "ADMINistrator");
        resource.put(INVALID_AGE_KEY, "15");
        assertFalse(adminFilter.matches(resource));
    }

    @Test
    public void testAdminUser_RoleKeyIsCaseSensitive() {
        Map<String, String> resource = new HashMap<String, String>();
        resource.put(INVALID_ROLE_KEY, "administrator");
        assertFalse(adminFilter.matches(resource));
    }
    
}

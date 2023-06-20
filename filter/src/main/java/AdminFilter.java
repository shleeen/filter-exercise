package filter.src.main.java;

import java.util.Map;

/**
 * A filter that matches Users with role "administrator" that are older than the
 * minimum age provided.
 */
public class AdminFilter implements Filter {

    private static final String AGE_KEY = "age";
    private static final String ROLE_KEY = "role";
    private static final String ADMIN_VALUE = "administrator";

    Integer minimumAge = 0;

    public AdminFilter(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        // Resource should contain the agekey and rolekey
        if (resource.containsKey(ROLE_KEY) && resource.containsKey(AGE_KEY)) {
            // role should be admin and age should be > 35
            return resource.get(ROLE_KEY).toLowerCase().equals(ADMIN_VALUE.toLowerCase())
                    && Integer.valueOf(resource.get(AGE_KEY)) > minimumAge;
        }
        return false;
    }

    @Override
    public String filterToString() {
        return "";
    }

}

package filter.src.main.java;

import java.util.Map;

/**
 * PropertyIsPresentFilter matches if the given resource contains the configured property.
 */
public class PropertyIsPresentFilter implements Filter {

    private String keyToMatch;
    private String valueToMatch;

    public PropertyIsPresentFilter(String keyToMatch, String valueToMatch) {
        this.keyToMatch = keyToMatch;
        this.valueToMatch = valueToMatch;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        if (resource.containsKey(keyToMatch) && resource.get(keyToMatch).equals(valueToMatch)) {
            return true;
        }
        return false;
    }

    @Override
    public String filterToString() {
        return "";
    }
}

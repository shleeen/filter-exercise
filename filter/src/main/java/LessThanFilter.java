package filter.src.main.java;

import java.util.Map;

/**
 * LessThanFilter matches if the numerical value for a given property 
 * is less than the configured numerical threshold value.
 * Note: This Filter can only be used for properties that have a numerical value.
 */
public class LessThanFilter implements Filter {
    
    private String keyToMatch;
    private Integer valueThreshold;

    public LessThanFilter(String keyToMatch, Integer valueThreshold) {
        this.keyToMatch = keyToMatch;
        this.valueThreshold = valueThreshold;
    }

    public boolean matches(Map<String, String> resource) {

        if (resource.containsKey(keyToMatch)) {
            String value = resource.get(keyToMatch) ;
            return Integer.parseInt(value) < valueThreshold;
        }
        return false;
    }

    @Override
    public String filterToString() {
        return "";
    }
}

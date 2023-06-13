package filter.src.main.java;

import java.util.Map;

/**
 * A filter that matches when every element in the propertiesToMatch map are present in user given map.
 */
public class BasicFilter implements Filter {

    Map<String, String> propertiesToMatch;

    public BasicFilter(Map<String, String> propertiesToMatch) {
        this.propertiesToMatch = propertiesToMatch;
    }

    public boolean matches(Map<String, String> resource) {
        // For every k,v pair in propertiesToMatch, check if it is contained in the resource Map
        for (Map.Entry<String, String> entry : propertiesToMatch.entrySet()) {
            String key   = entry.getKey();
            String value = entry.getValue();

            if (!resource.containsKey(key) || !resource.get(key).toLowerCase().equals(value.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String filterToString() {
        return "";
    }
}

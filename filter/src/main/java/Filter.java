package filter.src.main.java;


import java.util.Map;

/**
 * An interface for Filters.
 */
public interface Filter {

    /**
     * Function that applies the configured filter to the Resource passed in argument 
     * and returns true or false based on if the resource is matched.
     * @param resource to be matched
     * @return wether the filter matches a resource
     */
    boolean matches(Map<String, String> resource);

    /**
     * @return A string representation of the filter logic.
     */
    String filterToString();
}

package filter.src.main.java;

import java.util.List;
import java.util.Map;

/**
 * AggregateFilter applies all the filters in the given list
 * and successfully matches only if all filters have matched for a given resource input.
 */
public class AggregateFilter implements Filter {

    private List<Filter> filters;

    public AggregateFilter(List<Filter> filtersList) {
        this.filters = filtersList;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        for (Filter f : this.filters) {
            if (!f.matches(resource)) {
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

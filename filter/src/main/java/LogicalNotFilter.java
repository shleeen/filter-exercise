package filter.src.main.java;

import java.util.Map;

/**
 * LogicalNotFilter matches the negation of the the provided filter.
 */
public class LogicalNotFilter implements Filter {
    
    private Filter filter;

    public LogicalNotFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public boolean matches(Map<String, String> resource) {
        return !filter.matches(resource);
    }

    @Override
    public String filterToString() {
        return "";
    }
}

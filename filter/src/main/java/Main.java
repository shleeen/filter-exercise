package filter.src.main.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Create user resource having various properties:
        Map<String, String> user = new LinkedHashMap<String, String>();
        user.put("firstname", "Joe");
        user.put("surname", "Bloggs");
        user.put("role", "administrator");
        user.put("age", "35");

        // Admin Filter usage
        // Create a filter which matches all administrators older than 30
        Filter adminFilter = new AdminFilter(30);

        assert adminFilter.matches(user); // Filter should match.

        user.put("age", "25");
        assert !adminFilter.matches(user); // Filter should not match.


        // Basic Filter usage
        Map<String, String> propertiesToMatch = new HashMap<String, String>();
        propertiesToMatch.put("firstname", "joe");
        propertiesToMatch.put("age", "35");

        Filter basicFilter = new BasicFilter(propertiesToMatch);
        assert !basicFilter.matches(user); // Filter should not match as the Age property doesnt match.

        // Aggregate Filter usage
        Filter aggregateFilter = new AggregateFilter(List.of(adminFilter, basicFilter));
        
        assert !aggregateFilter.matches(user);
    }
}
# Filter Java API

Provides an interface called Filter which can be used to implement any specific filtering capability.

A BasicFilter and an AdminFilter has been provided. 

Examples of usage are present in the Main.java file:

```
    // Create a filter which matches all administrators older than 30
    Filter adminFilter = new AdminFilter(30);
    assert adminFilter.matches(user);

    user.put("age", "25");
    assert !adminFilter.matches(user);

    // Basic Filter usage
    Map<String, String> propertiesToMatch = new HashMap<String, String>();
    propertiesToMatch.put("firstname", "joe");
    propertiesToMatch.put("age", "35");

    Filter basicFilter = new BasicFilter(propertiesToMatch);
    assert !basicFilter.matches(user); // Filter should not match as the Age property doesn't match.

    // Aggregate Filter usage
    Filter aggregateFilter = new AggregateFilter(List.of(adminFilter, basicFilter));
    
    assert !aggregateFilter.matches(user); // Filter doesnt match as the age property for Admin Filter doesn't match.
```

## How to execute
This project has not been configured with any build tools. Instead it uses VS Code build configuration to compile and run through the IDE.
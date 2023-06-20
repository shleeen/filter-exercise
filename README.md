# Filter Java API

Provides an interface called Filter which can be used to implement any specific filtering capability.

Provided filters are:
1. AdminFilter - This filter matches resources that have the role 'administrator' and have age that is above the provided threshold.
2. AggregateFilter - The aggregate filter can be used to combine any number of filters. All filters provided to the AggregateFilter have to match for a resource to be matched.
3. BasicFilter - This filter can be used to determine whether or not a filter matches a given resource (represented by  `Map<String, String>`).
4. LessThanFilter - This filter is used to match resources that contain a property and the numerical values of the property is less than the provided threshold value.
5. LogicalNotFilter - This filter is a means to negate the matching logic of another filter.
6. PropertyIsPresentFilter - Matches a resources if the configured propety is present in the resource.

Examples of usage of some of the filters are present in the Main.java file:

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
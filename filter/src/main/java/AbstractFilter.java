package filter.src.main.java;

// import java.util.List;
// import java.util.function.Predicate;
import java.util.Map;

public abstract class AbstractFilter {

    /**
     * Returns a list of Resource objects that match the predicate
     */
    abstract boolean matches(Map<String, String> r);
    
}

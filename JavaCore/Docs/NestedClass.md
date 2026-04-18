```markdown
# Java Nested Classes & Lambda Expressions Guide

## When to Use Different Types of Class Declarations

Nested classes enable you to logically group classes that are only used in one place, increase encapsulation, and create more readable and maintainable code. Local classes, anonymous classes, and lambda expressions also provide these advantages, but each is intended for specific situations.

## Quick Decision Guide

| **Use Case** | **Recommended Choice** |
|-------------|----------------------|
| Single unit of behavior to pass to other code | **Lambda Expression** |
| Need to declare fields or additional methods | **Anonymous Class** |
| Need multiple instances, constructor access, or named type | **Local Class** |
| Need wider availability & no local variable access | **Nested Class** |

## Detailed Guidelines

### 1. Lambda Expression

**Use when:**
- Encapsulating a single unit of behavior to pass to other code
- You need a simple instance of a functional interface
- None of the other criteria apply (no need for constructor, named type, fields, or additional methods)

**Common scenarios:**
- Performing actions on each element of a collection
- When a process is completed
- When a process encounters an error
- Event handling
- Sorting/comparison logic

**Example:**
```java
// Collection operation
list.forEach(item -> System.out.println(item));

// Sorting
Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));

// Error handling
Optional.ofNullable(value).orElseThrow(() -> new RuntimeException("Value is null"));
```

### 2. Anonymous Class

**Use when:**
- You need to declare fields or additional methods

**Example:**
```java
Runnable complexTask = new Runnable() {
    private int retryCount = 0;  // Additional field
    
    private void logAttempt() {  // Additional method
        System.out.println("Attempt " + retryCount);
    }
    
    @Override
    public void run() {
        logAttempt();
        // task implementation
    }
};
```

### 3. Local Class

**Use when:**
- You need to create more than one instance of a class
- You need to access its constructor
- You need to introduce a new named type (because you need to invoke additional methods later)

**Example:**
```java
public void processUsers(List<User> users) {
    class UserValidator {
        private String name;
        
        UserValidator(String name) {
            this.name = name;
        }
        
        boolean isValid() {
            return name != null && !name.isEmpty();
        }
        
        void logValidation() {
            System.out.println("Validating: " + name);
        }
    }
    
    for (User user : users) {
        UserValidator validator = new UserValidator(user.getName());
        validator.logValidation();
        if (validator.isValid()) {
            // process user
        }
    }
}
```

### 4. Nested Class

**Use when:**
- Your requirements are similar to a local class
- You want to make the type more widely available
- You don't require access to local variables or method parameters

#### Non-static Nested Class (Inner Class)

**Use when:** You require access to an enclosing instance's non-public fields and methods

**Example:**
```java
public class OuterClass {
    private String secret = "secret data";
    
    class InnerClass {
        void accessOuter() {
            System.out.println(secret); // Can access private members
        }
    }
}
```

#### Static Nested Class

**Use when:** You don't require access to an enclosing instance's non-public fields and methods

**Example:**
```java
public class Calculator {
    public static class Operation {
        private String name;
        
        public Operation(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }
    }
}
```

## Comparison Table

| Feature | Lambda | Anonymous Class | Local Class | Static Nested | Inner Class |
|---------|--------|-----------------|-------------|---------------|-------------|
| Has a name | No | No | Yes | Yes | Yes |
| Can have constructors | No | No | Yes | Yes | Yes |
| Can have fields | No | Yes | Yes | Yes | Yes |
| Can have additional methods | No | Yes | Yes | Yes | Yes |
| Requires functional interface | Yes | No | No | No | No |
| Accesses local variables | Yes* | Yes* | Yes* | No | No |
| Accesses enclosing instance | Yes** | Yes** | Yes** | No | Yes |
| Can be instantiated multiple times | Yes*** | Yes | Yes | Yes | Yes |

*Variables must be effectively final
**If in non-static context
***Via method references

## Real-World Examples

### Event Handling
```java
// Lambda (simple case)
button.setOnAction(event -> System.out.println("Clicked!"));

// Anonymous class (need state)
button.setOnAction(new EventHandler() {
    private int clickCount = 0;
    
    @Override
    public void handle(Event event) {
        clickCount++;
        System.out.println("Clicked " + clickCount + " times");
    }
});
```

### Data Processing
```java
public class DataProcessor {
    // Static nested class for reusable components
    public static class Filter {
        private String criteria;
        
        public Filter(String criteria) {
            this.criteria = criteria;
        }
        
        public boolean apply(String data) {
            return data.contains(criteria);
        }
    }
    
    public void process(List<String> data) {
        // Local class for complex processing
        class DataTransformer {
            private String prefix;
            
            DataTransformer(String prefix) {
                this.prefix = prefix;
            }
            
            String transform(String input) {
                return prefix + ": " + input.toUpperCase();
            }
        }
        
        // Lambda for simple behavior
        data.stream()
            .filter(item -> item != null)
            .forEach(System.out::println);
    }
}
```

## Best Practices

1. **Start with the simplest solution** - Use lambda expressions when possible
2. **Consider readability** - Named classes (local or nested) are better for complex logic
3. **Memory matters** - Static nested classes don't hold references to outer instances
4. **Testing** - Named classes are easier to test in isolation

## Common Mistakes to Avoid

❌ **Don't use anonymous classes when a lambda would suffice**
```java
// Bad
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};

// Good
Runnable r = () -> System.out.println("Hello");
```

❌ **Don't use inner classes when static nested classes would work**
```java
// Bad - unnecessary reference to outer instance
public class Calculator {
    class Operation { }
}

// Good - independent of Calculator instance
public class Calculator {
    static class Operation { }
}
```

## Summary

- **Lambda Expression** → Simple behavior passing, functional interfaces
- **Anonymous Class** → Need fields or additional methods
- **Local Class** → Need multiple instances or constructors
- **Static Nested Class** → Utility classes, builders, no outer instance needed
- **Inner Class** → Need access to outer instance's private members

Choose the right tool based on your requirements for state, complexity, reusability, and scope.
```

Just copy everything above and save as `README.md`
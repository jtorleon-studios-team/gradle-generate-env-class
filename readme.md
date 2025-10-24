# Gradle Plugin : Generate Env Class

Automatically generates a Java class containing constants defined in the Gradle build configuration.

- **License:** MIT
- **Author:** JTorleon Studios Team
- **Public Maven Repository:** https://jtorleon-studios-team-github-io.pages.dev/

## Installation

Add the public Maven repository in your `settings.gradle`:

```groovy
pluginManagement {
  repositories {
    maven {
      url = 'https://jtorleon-studios-team-github-io.pages.dev/'
    }
  }
}

```

Then apply the plugin in your `build.gradle`:


```groovy
plugin {
  id 'gradle-generate-env-class' version "1.0.0"
}
```

Configuration:

```groovy
setupEnvClass {
   
  outputPackage = "com.hello.world"
   
  className = "HelloWorld"

  // (optional default value is "Constant")
  classSuffix = "Const"
 
  constants = [
    example_boolean: true,
    
    example_byte: (byte) 0,
    
    example_char: (char) 'B',
    
    example_double: 0D,
    
    example_float: 0F,
    
    example_int: 0,
    
    example_long: 0L,
    
    example_short: (short) 123,
    
    example_string: "Hello World"
  ]
  
}
```
 
```
      ███                                    ███    ██████             ███  
     ░░░                                    ███    ███░░███           ░░███ 
     █████  ██████   █████ █████  ██████   ███    ░███ ░░░  ████████   ░░███
    ░░███  ░░░░░███ ░░███ ░░███  ░░░░░███ ░███   ███████   ░░███░░███   ░███
     ░███   ███████  ░███  ░███   ███████ ░███  ░░░███░     ░███ ░███   ░███
     ░███  ███░░███  ░░███ ███   ███░░███ ░░███   ░███      ░███ ░███   ███ 
     ░███ ░░████████  ░░█████   ░░████████ ░░███  █████     ████ █████ ██░  
     ░███  ░░░░░░░░    ░░░░░     ░░░░░░░░   ░░░  ░░░░░     ░░░░ ░░░░░ ░░░   
 ███ ░███                                                                   
░░██████                                                                    
 ░░░░░░                                                                     
```

`java(fn)` utils is a lightweight library with no dependencies, adding various utilities that don't fit in any other library.


## ToDo

`java(fn)` offers a ToDo class that can be used as a placeholder to make your IDE's typechecker happy.  It throws an exception at runtime, so you shouldn't be using this in production code, but if you have a method you want to stub out, perhaps the return type is going to change, but you don't want to deal with the error of "this is not yet implemented".

```java
public List<Result<Exception, String>> doSomethingCrazy() {
    return ToDo.TODO("this actually compiles, but will throw an exception at runtime");
}
```

This class is a valid target for generic types too, for when you don't have a type defined but you want to
focus on how a collection of that type might be handled.

```java
final List<ToDo> complexTypeContainer = new ArrayList<>();
complexTypeContainer.stream()
     .map(...)
```

You can even use it as a member variable.

```java
class Demo {
    private final ToDo todo = new ToDo();
    public ComplexDataType get() { return todo.todo("Compiles but barfs when called"); }
}
```
And of course, the primary benefit is you can search for usages of the class to make sure things actually are done,
unlike the TODO comment that hangs around forever

## Using

Simply include the dependency in your build tool, for example, using maven

```xml
<dependency>
    <groupId>org.javafn</groupId>
    <artifactId>javafn-utils</artifactId>
    <version>1.0.x</version>
</dependency>
```

or gradle

```gradle
implementation 'org.javafn:javafn-utils:1.0.x'
```

## Contact

Contact us by email `org.javafn`at`javafn.org` or create a ticket in this repo's issues.

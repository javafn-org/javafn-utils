package org.javafn.utils;

/**
 * Placeholder class for something that hasn't been implemented or even defined yet that uses generics
 * to make the code compile but which throws exceptions when called at runtime.
 * <pre>{@code
 * public List<Result<Exception, String>> doSomethingCrazy() {
 *     return ToDo.TODO("this actually compiles, but will throw an exception at runtime");
 * }
 * }</pre>
 * This class is a valid target for generic types too, for when you don't have a type defined but you want to
 * focus on how a collection of that type might be handled.
 * <pre>{@code
 * final List<ToDo> complexTypeContainer = new ArrayList<>();
 * complexTypeContainer.stream()
 *      .map(...)
 * }</pre>
 * You can even use it as a member variable.
 * <pre>{@code
 * class Demo {
 *     private final ToDo todo = new ToDo();    // This is the only call that does not throw an exception
 *     public ComplexDataType get() { return todo.todo("Compiles but barfs when called"); }
 * }
 * }</pre>
 * And of course, the primary benefit is you can search for usages of the class to make sure things actually are done,
 * unlike the TODO comment that hangs around forever.
 */
public class ToDo {

	public static class ToDoException extends RuntimeException {
		public ToDoException(final String msg) { super("Not yet implemented: " + msg); }
	}

	public static <T> T TODO(final String details) { throw new ToDoException(details); }
	public static <R, P> R TODO(final P p, final String details) { throw new ToDoException(details); }
	public <T> T todo(final String details) { throw new ToDoException(details); }
	public <R, P> R todo(final P p, final String details) { throw new ToDoException(details); }
}
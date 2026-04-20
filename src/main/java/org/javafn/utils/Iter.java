package org.javafn.utils;

import jakarta.annotation.Nonnull;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Iter {

	/**
	 * Turn an Iterable into a stream.  The code to do this is just painful enough that it warrants a specialized method.
	 * @param iter the iterable to turn into a stream
	 * @param <T> the type of the iterable
	 * @return a Stream of the elements in this iterable
	 */
	public static <T> Stream<T> toStream(@Nonnull final Iterable<T> iter) {
		return StreamSupport.stream(Objects.requireNonNull(iter).spliterator(), false);
	}

	/**
	 * Turn an Iterator into a stream.  The code to do this is just painful enough that it warrants a specialized method.
	 * <p>An iterator is inherently one-shot, so this function consumes the iterator; it should not be used
	 * once the returned stream is consumed.</p>
	 * @param iter the iterator to turn into a stream
	 * @param <T> the type of the iterator
	 * @return a Stream of the elements in this iterator
	 */
	public static <T> Stream<T> toStream(@Nonnull final Iterator<T> iter) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
				Objects.requireNonNull(iter),
				Spliterator.ORDERED),
				false);
	}

	/**
	 * Turn an Iterable into a parallel stream.  The code to do this is just painful enough that it warrants a specialized method.
	 * @param iter the iterable to turn into a parallel stream
	 * @param <T> the type of the iterable
	 * @return a Stream of the elements in this iterable
	 */
	public static <T> Stream<T> toParStream(@Nonnull final Iterable<T> iter) {
		return StreamSupport.stream(Objects.requireNonNull(iter).spliterator(), true);
	}

	private Iter() { throw new IllegalStateException("This is a static class and should never be instantiated"); }
}

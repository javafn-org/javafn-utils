package org.javafn.utils;

import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Data {

	/**
	 * Return a new list containing all the elements from src with toAppend added, without modifying src.
	 * The returned list is unmodifiable.
	 */
	@Nonnull
	public static <T> List<T> append(@Nonnull final List<T> src, @Nonnull final T toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final List<T> mut = new ArrayList<>(src);
		mut.add(toAppend);
		return List.copyOf(mut);
	}

	/**
	 * Return a new list containing all the elements from src and toAppend, without modifying either list.
	 * The returned list is unmodifiable.
	 */
	@Nonnull
	public static <T> List<T> append(@Nonnull final List<T> src, @Nonnull final List<T> toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final List<T> mut = new ArrayList<>(src);
		mut.addAll(toAppend);
		return List.copyOf(mut);
	}

	/**
	 * Return a new set containing all the elements from src with toAppend added, without modifying src.
	 * The returned set is unmodifiable.
	 */
	@Nonnull
	public static <T> Set<T> append(@Nonnull final Set<T> src, @Nonnull final T toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final Set<T> mut = new HashSet<>(src);
		mut.add(toAppend);
		return Set.copyOf(mut);
	}

	/**
	 * Return a new set containing all the elements from src and toAppend, without modifying either set.
	 * The returned set is unmodifiable.
	 */
	@Nonnull
	public static <T> Set<T> append(@Nonnull final Set<T> src, @Nonnull final Set<T> toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final Set<T> mut = new HashSet<>(src);
		mut.addAll(toAppend);
		return Set.copyOf(mut);
	}

	/**
	 * Return a new Map containing all the elements from src with the supplied key/value added, without modifying src.
	 * The returned Map is unmodifiable.
	 */
	@Nonnull
	public static <K, V> Map<K, V> append(@Nonnull final Map<K, V> src, @Nonnull final K key, @Nonnull final V value) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(key);
		Objects.requireNonNull(value);
		final Map<K, V> mut = new HashMap<>(src);
		mut.put(key, value);
		return Map.copyOf(mut);
	}

	/**
	 * Return a new map containing all the elements from src and toAppend, without modifying either map.
	 * The returned map is unmodifiable.
	 */
	@Nonnull
	public static <K, V> Map<K, V> append(@Nonnull final Map<K, V> src, @Nonnull final Map<K, V> toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final Map<K, V> mut = new HashMap<>(src);
		mut.putAll(toAppend);
		return Map.copyOf(mut);
	}

	private Data() { throw new AssertionError("This is a static class and should not be instantiated"); }
}

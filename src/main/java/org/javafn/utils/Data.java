package org.javafn.utils;

import jakarta.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Utilities for manipulating collections without modifying the original.  Except for arrays,
 * which cannot be made immutable, all the methods in this class return immutable copies.
 * They are implemented using standard mutable copies because this is more efficient,
 * but from an API perspective, this class enables fully immutable data structures.
 */
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
		final List<T> mut = new ArrayList<>(src.size() + toAppend.size());
		mut.addAll(src);
		mut.addAll(toAppend);
		return List.copyOf(mut);
	}

	@Nonnull
	public static <T> T[] append(@Nonnull final T[] src, @Nonnull final T toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final T[] dst = Arrays.copyOf(src, src.length + 1);
		dst[src.length] = toAppend;
		return dst;
	}

	@Nonnull
	public static <T> T[] append(@Nonnull final T[] src, @Nonnull final T[] toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final int k = src.length;
		final T[] dst = Arrays.copyOf(src, k + toAppend.length);
        System.arraycopy(toAppend, 0, dst, k, toAppend.length);
		return dst;
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
		final Set<T> mut = new HashSet<>(src.size() + toAppend.size());
		mut.addAll(src);
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
		final Map<K, V> mut = new HashMap<>(src.size() + toAppend.size());
		mut.putAll(src);
		mut.putAll(toAppend);
		return Map.copyOf(mut);
	}

	@Nonnull
	public static int[] append(@Nonnull final int[] src, final int toAppend) {
		Objects.requireNonNull(src);
		final int[] dst = Arrays.copyOf(src, src.length + 1);
		dst[src.length] = toAppend;
		return dst;
	}

	@Nonnull
	public static int[] append(@Nonnull final int[] src, @Nonnull final int[] toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final int k = src.length;
		final int[] dst = Arrays.copyOf(src, k + toAppend.length);
		System.arraycopy(toAppend, 0, dst, k, toAppend.length);
		return dst;
	}

	@Nonnull
	public static long[] append(@Nonnull final long[] src, final long toAppend) {
		Objects.requireNonNull(src);
		final long[] dst = Arrays.copyOf(src, src.length + 1);
		dst[src.length] = toAppend;
		return dst;
	}

	@Nonnull
	public static long[] append(@Nonnull final long[] src, @Nonnull final long[] toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final int k = src.length;
		final long[] dst = Arrays.copyOf(src, k + toAppend.length);
		System.arraycopy(toAppend, 0, dst, k, toAppend.length);
		return dst;
	}

	@Nonnull
	public static double[] append(@Nonnull final double[] src, final double toAppend) {
		Objects.requireNonNull(src);
		final double[] dst = Arrays.copyOf(src, src.length + 1);
		dst[src.length] = toAppend;
		return dst;
	}

	@Nonnull
	public static double[] append(@Nonnull final double[] src, @Nonnull final double[] toAppend) {
		Objects.requireNonNull(src);
		Objects.requireNonNull(toAppend);
		final int k = src.length;
		final double[] dst = Arrays.copyOf(src, k + toAppend.length);
		System.arraycopy(toAppend, 0, dst, k, toAppend.length);
		return dst;
	}

	private Data() { Expect.staticConstructorNotCalled(this.getClass()); }
}

/* Copyright (c) 2017 FastJAX
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package org.fastjax.util;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A {@code FilterMap} contains some other {@link Map}, which it uses as its
 * basic source of data, possibly transforming the data along the way or
 * providing additional functionality. The class {@code FilterMap} itself simply
 * overrides all methods of {@link AbstractMap} with versions that pass all
 * requests to the source {@link Map}. Subclasses of {@code FilterMap} may
 * further override some of these methods and may also provide additional
 * methods and fields.
 */
public class FilterMap<K,V> extends AbstractMap<K,V> {
  /**
   * The Map to be filtered.
   */
  @SuppressWarnings("rawtypes")
  protected volatile Map source;

  /**
   * Creates a new {@code FilterMap} with the specified {@code source}.
   *
   * @param source The source {@link Map} object.
   * @throws NullPointerException If {@code source} is null.
   */
  public FilterMap(final Map<K,V> source) {
    this.source = Objects.requireNonNull(source);
  }

  /**
   * Creates a new {@code FilterMap} with a null source.
   */
  protected FilterMap() {
  }

  @Override
  public int size() {
    return source.size();
  }

  @Override
  public boolean isEmpty() {
    return source.isEmpty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public V get(final Object key) {
    return (V)source.get(key);
  }

  @Override
  public boolean containsKey(final Object key) {
    return source.containsKey(key);
  }

  @Override
  @SuppressWarnings("unchecked")
  public V put(final K key, final V value) {
    return (V)source.put(key, value);
  }

  @Override
  public void putAll(final Map<? extends K,? extends V> m) {
    source.putAll(m);
  }

  @Override
  @SuppressWarnings("unchecked")
  public V remove(final Object key) {
    return (V)source.remove(key);
  }

  @Override
  public void clear() {
    source.clear();
  }

  @Override
  public boolean containsValue(final Object value) {
    return source.containsKey(value);
  }

  @Override
  public Set<K> keySet() {
    return source.keySet();
  }

  @Override
  public Collection<V> values() {
    return source.values();
  }

  @Override
  public Set<Map.Entry<K,V>> entrySet() {
    return source.entrySet();
  }

  @Override
  @SuppressWarnings("unchecked")
  public V getOrDefault(final Object key, final V defaultValue) {
    return (V)source.getOrDefault(key, defaultValue);
  }

  @Override
  @SuppressWarnings("unchecked")
  public V putIfAbsent(final K key, final V value) {
    return (V)source.putIfAbsent(key, value);
  }

  @Override
  public boolean remove(final Object key, final Object value) {
    return source.remove(key, value);
  }

  @Override
  public boolean replace(final K key, final V oldValue, final V newValue) {
    return source.replace(key, oldValue, newValue);
  }

  @Override
  @SuppressWarnings("unchecked")
  public V replace(final K key, final V value) {
    return (V)source.replace(key, value);
  }

  @Override
  @SuppressWarnings("unchecked")
  public V computeIfAbsent(final K key, final Function<? super K,? extends V> mappingFunction) {
    return (V)source.computeIfAbsent(key, mappingFunction);
  }

  @Override
  @SuppressWarnings("unchecked")
  public V computeIfPresent(final K key, final BiFunction<? super K,? super V,? extends V> remappingFunction) {
    return (V)source.computeIfPresent(key, remappingFunction);
  }

  @Override
  @SuppressWarnings("unchecked")
  public V compute(final K key, final BiFunction<? super K,? super V,? extends V> remappingFunction) {
    return (V)source.compute(key, remappingFunction);
  }

  @Override
  @SuppressWarnings("unchecked")
  public V merge(final K key, final V value, final BiFunction<? super V,? super V,? extends V> remappingFunction) {
    return (V)source.merge(key, value, remappingFunction);
  }

  @Override
  public void forEach(final BiConsumer<? super K,? super V> action) {
    source.forEach(action);
  }

  @Override
  public void replaceAll(final BiFunction<? super K,? super V,? extends V> function) {
    source.replaceAll(function);
  }
}
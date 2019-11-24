/* Copyright (c) 2019 LibJ
 *
 * Permission is hereby granted, final free of charge, final to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), final to deal
 * in the Software without restriction, final including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, final and/or sell
 * copies of the Software, final and to permit persons to whom the Software is
 * furnished to do so, final subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package org.libj.util;

/**
 * A comparison function, which imposes a <i>total ordering</i> on some
 * collection of {@code int}s.
 */
@FunctionalInterface
public interface IntComparator {
  /**
   * Comparator that compares two {@code int} values numerically.
   *
   * @see Integer#compare(int,int)
   */
  public static final IntComparator NATURAL = Integer::compare;

  /**
   * Comparator that compares two {@code int} values reverse numerically.
   *
   * @see #reverse()
   */
  public static final IntComparator REVERSE = NATURAL.reverse();

  /**
   * Compares its two arguments for order. Returns a negative integer, zero, or
   * a positive integer as the first argument is less than, equal to, or greater
   * than the second.
   *
   * @param i1 The first {@code int} to be compared.
   * @param i2 the second {@code int} to be compared.
   * @return A negative integer, zero, or a positive integer as the first
   *         argument is less than, equal to, or greater than the second.
   * @see java.util.Comparator#compare(Object,Object)
   */
  int compare(int i1, int i2);

  /**
   * Returns a comparator that imposes the reverse ordering of this comparator.
   *
   * @return A comparator that imposes the reverse ordering of this comparator.
   */
  default IntComparator reverse() {
    return (i1, i2) -> compare(i2, i1);
  }
}
package company.tothepoint.functionallist;

import java.util.function.BiFunction;
import java.util.function.Function;

public interface FList<T> {

    int size();

    T head();

    FList<T> tail();

    <Q> FList<Q> map(Function<T, Q> f);

    <Q> FList<Q> flatMap(Function<T, FList<Q>> f);

    <A> A foldLeft(A initial, BiFunction<T, A, A> reducingFunction);

    FList<T> addAll(FList<T> other);

    boolean equals(Object other);

    FList<T> reverse();
}

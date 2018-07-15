package company.tothepoint.functionallist;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Nil<T> implements FList<T> {

    public Nil() {
    }

    public FList<T> of() {
        return new Nil<>();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T head() {
        throw new UnsupportedOperationException("head of empty FList");
    }

    @Override
    public FList<T> tail() {
        throw new UnsupportedOperationException("tail of empty FList");
    }

    @Override
    public <Q> FList<Q> map(Function<T, Q> f) {
        return new Nil<>();
    }

    @Override
    public <Q> FList<Q> flatMap(Function<T, FList<Q>> f) {
        return new Nil<>();
    }

    @Override
    public <A> A foldLeft(A initial, BiFunction<T, A, A> reducingFunction) {
        return initial;
    }

    @Override
    public FList<T> addAll(FList<T> other) {
        return other;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Nil;
    }

    @Override
    public FList<T> reverse() {
        return this;
    }

    @Override
    public String toString() {
        return "[]";
    }

    public String stringify(boolean first) {
        return first ? "[]" : " ]";
    }

    @Override
    public List<T> toList() {
        return new ArrayList<>();
    }

    @Override
    public T[] toArray() {
        return (T[]) new Object[0];
    }
}

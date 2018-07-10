package company.tothepoint.functionallist;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Cons<T> implements FList<T> {

    private T head;
    private FList<T> tail;

    public Cons(T head, FList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public int size() {
        return 1 + tail.size();
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public FList<T> tail() {
        return tail;
    }

    @Override
    public <Q> FList<Q> map(Function<T, Q> f) {
        return new Cons<>(f.apply(head), tail.map(f));
    }

    @Override
    public <Q> FList<Q> flatMap(Function<T, FList<Q>> f) {
        return foldLeft(new Nil<Q>().of(), (list, acc) -> acc.addAll(f.apply(list)));
    }

    @Override
    public <A> A foldLeft(A initial, BiFunction<T, A, A> reducingFunction) {
        return tail.foldLeft(reducingFunction.apply(head, initial), reducingFunction);
    }


    public FList<T> addAll(FList<T> other) {
        return other.foldLeft(this.reverse(), (elem, acc) -> new Cons<>(elem, acc)).reverse();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cons)) return false;

        Cons<?> cons = (Cons<?>) o;

        if (head != null ? !head.equals(cons.head) : cons.head != null) return false;
        return tail != null && tail.equals(cons.tail);
    }

    @Override
    public FList<T> reverse() {
        return foldLeft(new Nil<T>().of(), (x, acc) -> new Cons<>(x, acc));
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + (tail != null ? tail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cons(" + head + ',' + tail + ')';
    }
}

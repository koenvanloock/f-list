package company.tothepoint.functionallist;

import java.util.ArrayList;
import java.util.List;

public class FLists {

    public static <T> FList<T> from(T... args) {
        return from(args, new Nil<>());
    }

    public static <T> FList<T> from(List<T> args) {
        return from(args, new Nil<>());
    }

    private static <T> FList<T> from(List<T> ts, FList<T> listUntilNow) {
        if(ts.size() > 1) {
            return new Cons<>(ts.get(0), from(allButFirst(ts)));
        } else if(ts.size() == 1) {
            return new Cons<>(ts.get(0), listUntilNow);
        } else {
            return listUntilNow;
        }
    }

    private static <T> FList<T> from(T[] ts, FList<T> listUntilNow) {
        if(ts.length > 1) {
            return new Cons<>(ts[0], from(allButFirst(ts)));
        } else if(ts.length == 1) {
            return new Cons<>(ts[0], listUntilNow);
        } else {
            return listUntilNow;
        }
    }

    private static <T> T[] allButFirst(T[] ts) {
        if(ts.length > 0) {
            T[] newTs = (T[]) new Object[ts.length - 1];
            System.arraycopy(ts, 1, newTs, 0, ts.length - 1);
            return newTs;
        } else {
            return ts;
        }
    }

    private static <T> List<T> allButFirst(List<T> list) {
        return list.size() > 0
                ? list.subList(1, list.size())
                : new ArrayList<>();
    }
}

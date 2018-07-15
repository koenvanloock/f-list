package company.tothepoint.functionallist;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FListTest {
    private FList<Character> helloWorld = FLists.from('H', 'e','l','l','o','W','o','r','l','d', '!');
    private FList<Character> hello = FLists.from('H', 'e','l','l','o');
    private FList<Character> world = FLists.from('W','o','r','l','d', '!');



    @Test
    public void testListMaps() {
        FList<String> fList = new Cons<>("Hello", new Cons<>("World!", new Nil<>()));

        assertThat(fList.map(String::length).head()).isEqualTo(5);
        assertThat(fList.map(String::length).tail().head()).isEqualTo(6);
    }

    @Test
    public void addAllWorks() {
       assertThat(hello.addAll(world)).isEqualTo(helloWorld);
    }

    @Test
    public void testListFlatMaps() {
        FList<String> fList = new Cons<>("Hello", new Cons<>("World!", new Nil<>()));

        assertThat(fList.flatMap(this::convertStringToCharFList)).isEqualTo(helloWorld);
    }


    @Test
    public void foldLeftNonEmptyFListWorks() {
        assertThat(helloWorld.foldLeft("", (character, acc) -> acc + character)).isEqualTo("HelloWorld!");
    }

    @Test
    public void reverseFListWorks() {
        FList<Character> fCharsReversed = new Cons<>('!', new Cons<>('d', new Cons<>('l', new Cons<>('r', new Cons<>('o', new Cons<>('W', new Cons<>('o', new Cons<>('l', new Cons<>('l', new Cons<>('e', new Cons<>('H', new Nil<>())))))))))));

        assertThat(helloWorld.reverse()).isEqualTo(fCharsReversed);
    }

    @Test
    public void toStringOfConsReturnsExpected(){
        assertThat(helloWorld.toString()).isEqualTo("[ H, e, l, l, o, W, o, r, l, d, ! ]");
    }

    @Test
    public void toStringOfNilReturnsExpected(){
        FList<Character> fChars = new Nil<>();
        assertThat(fChars.toString()).isEqualTo("[]");
    }

    @Test
    public void toListWorks() {
        assertThat(helloWorld.toList()).isEqualTo(Arrays.asList('H', 'e','l','l','o','W','o','r','l','d', '!'));
    }

    @Test
    public void toArrayWorks() {
        assertThat(helloWorld.toArray()).isEqualTo(new Character[]{'H', 'e','l','l','o','W','o','r','l','d', '!'});
    }

    private FList<Character> convertStringToCharFList(String word) {
        return word.length() == 0
                ? new Nil<>()
                : new Cons<>(word.charAt(0), convertStringToCharFList(word.substring(1)));
    }
}

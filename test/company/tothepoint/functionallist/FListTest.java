package company.tothepoint.functionallist;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FListTest {

    @Test
    public void testListMaps() {
        FList<String> fList = new Cons<>("Hello", new Cons<>("World!", new Nil<>()));

        assertThat(fList.map(String::length).head()).isEqualTo(5);
        assertThat(fList.map(String::length).tail().head()).isEqualTo(6);
    }

    @Test
    public void addAllWorks() {
        FList<Character> helloWorld = new Cons<>('H', new Cons<>('e', new Cons<>('l', new Cons<>('l', new Cons<>('o', new Cons<>('W', new Cons<>('o', new Cons<>('r', new Cons<>('l', new Cons<>('d', new Cons<>('!', new Nil<>())))))))))));
        FList<Character> hello = new Cons<>('H', new Cons<>('e', new Cons<>('l', new Cons<>('l', new Cons<>('o', new Nil<>())))));
        FList<Character> world = new Cons<>('W', new Cons<>('o', new Cons<>('r', new Cons<>('l', new Cons<>('d', new Cons<>('!', new Nil<>()))))));
        assertThat(hello.addAll(world)).isEqualTo(helloWorld);
    }

    @Test
    public void testListFlatMaps() {
        FList<String> fList = new Cons<>("Hello", new Cons<>("World!", new Nil<>()));

        FList<Character> fChars = new Cons<>('H', new Cons<>('e', new Cons<>('l', new Cons<>('l', new Cons<>('o', new Cons<>('W', new Cons<>('o', new Cons<>('r', new Cons<>('l', new Cons<>('d', new Cons<>('!', new Nil<>())))))))))));
        assertThat(fList.flatMap(this::convertStringToCharFList)).isEqualTo(fChars);
    }


    @Test
    public void foldLeftNonEmptyFListWorks() {
        FList<Character> fChars = new Cons<>('H', new Cons<>('e', new Cons<>('l', new Cons<>('l', new Cons<>('o', new Cons<>('W', new Cons<>('o', new Cons<>('r', new Cons<>('l', new Cons<>('d', new Cons<>('!', new Nil<>())))))))))));

        assertThat(fChars.foldLeft("", (character, acc) -> acc + character)).isEqualTo("HelloWorld!");
    }

    @Test
    public void reverseFListWorks() {
        FList<Character> fChars = new Cons<>('H', new Cons<>('e', new Cons<>('l', new Cons<>('l', new Cons<>('o', new Cons<>('W', new Cons<>('o', new Cons<>('r', new Cons<>('l', new Cons<>('d', new Cons<>('!', new Nil<>())))))))))));
        FList<Character> fCharsReversed = new Cons<>('!', new Cons<>('d', new Cons<>('l', new Cons<>('r', new Cons<>('o', new Cons<>('W', new Cons<>('o', new Cons<>('l', new Cons<>('l', new Cons<>('e', new Cons<>('H', new Nil<>())))))))))));

        assertThat(fChars.reverse()).isEqualTo(fCharsReversed);
    }

    private FList<Character> convertStringToCharFList(String word) {
        return word.length() == 0
                ? new Nil<>()
                : new Cons<>(word.charAt(0), convertStringToCharFList(word.substring(1)));
    }
}

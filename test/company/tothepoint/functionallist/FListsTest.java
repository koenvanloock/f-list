package company.tothepoint.functionallist;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FListsTest {

    @Test
    public void testFromHelloWorldCreatesCorrectFList() {
        FList<Character> helloWorld = new Cons<>('H', new Cons<>('e', new Cons<>('l', new Cons<>('l', new Cons<>('o', new Cons<>('W', new Cons<>('o', new Cons<>('r', new Cons<>('l', new Cons<>('d', new Cons<>('!', new Nil<>())))))))))));
        FList<Character> generated = FLists.from('H', 'e','l','l','o','W','o','r','l','d', '!');
        assertThat(generated).isEqualTo(helloWorld);
    }

    @Test
    public void testFromHelloWorldListCreatesCorrectFList() {
        FList<Character> helloWorld = new Cons<>('H', new Cons<>('e', new Cons<>('l', new Cons<>('l', new Cons<>('o', new Cons<>('W', new Cons<>('o', new Cons<>('r', new Cons<>('l', new Cons<>('d', new Cons<>('!', new Nil<>())))))))))));
        FList<Character> generated = FLists.from('H', 'e','l','l','o','W','o','r','l','d', '!');
        assertThat(generated).isEqualTo(helloWorld);
    }
}

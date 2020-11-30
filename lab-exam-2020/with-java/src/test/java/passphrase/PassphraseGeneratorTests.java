package passphrase;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassphraseGeneratorTests {

    private final List<String> lowers;
    private final List<String> uppers;
    private final List<String> numbers;

    PassphraseGeneratorTests() {
        this.lowers = Arrays.asList("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(","));
        this.uppers = Arrays.asList("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(","));
        this.numbers = Arrays.asList("1,2,3,4,5,6,7,8,9,0".split(","));
    }

    @RepeatedTest(10000)
    void generatePassphraseNotContainUppers(){
        PassphraseGenerator passphraseGenerator = new PassphraseGenerator(true,false,true);
        int passLength = 1024;
        String pass = passphraseGenerator.generate(passLength);
        for (int j = 0; j <passLength ; j++) {
            if(!Character.isDigit(pass.charAt(j))) {
                assertTrue(Character.isLowerCase(pass.charAt(j)));
            }
        }
    }

    @Test
    void generatePassphraseBySpecifiedLength(){
        PassphraseGenerator passphraseGenerator = new PassphraseGenerator(true,true,true);
        int passLength = 7;
        String pass = passphraseGenerator.generate(passLength);
        assertEquals(passLength, pass.length());
    }

    @Test
    void generateEmptyWhenAllCongiglsFalse(){
        PassphraseGenerator passphraseGenerator = new PassphraseGenerator(false,false,false);
        String pass = passphraseGenerator.generate(7);
        assertEquals("", pass);
    }
}

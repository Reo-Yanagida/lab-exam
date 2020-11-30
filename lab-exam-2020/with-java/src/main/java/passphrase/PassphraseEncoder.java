package passphrase;

public class PassphraseEncoder {

    static String encode(String n){
        char[] a = n.toCharArray();
        for (int i = 0; i <a.length ; i++) {
            if (Character.isLowerCase(a[i])){
                a[i] = Character.toUpperCase(a[i]);
            }else if(Character.isUpperCase(a[i])){
                a[i] = Character.toLowerCase(a[i]);
            }
        }
        return String.valueOf(a);
    }

    static String decode(String m){
        char[] a = m.toCharArray();
        for (int i = 0; i <a.length ; i++) {
            if (Character.isLowerCase(a[i])){
                a[i] = Character.toUpperCase(a[i]);
            }else if(Character.isUpperCase(a[i])){
                a[i] = Character.toLowerCase(a[i]);
            }
        }
        return String.valueOf(a);
    }

}

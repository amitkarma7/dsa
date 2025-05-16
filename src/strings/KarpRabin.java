package strings;

public class KarpRabin {

    private final int PRIME =101;

    double calculateHash(String value) {
        double hash = 0;

        for (int i = 0; i <value.length(); i++) {
            hash =hash+value.charAt(i) * Math.pow(PRIME,i);
        }
        return hash;
    }

    double updateHash(double prevhash , char prevChar, char newChar , int patternLength) {
        double newHash = (prevhash-prevChar)/PRIME;
        newHash = newHash+newChar * Math.pow(PRIME,patternLength-1);
        return newHash;
    }

    void search(String text,String pattern) {
        double patternHash =   calculateHash(pattern);
        int patternLength =   pattern.length();
        double texthash = calculateHash(text.substring(0,patternLength));
        for (int i = 0; i <= text.length() -  patternLength; i++) {

            if(texthash ==patternHash) {
                if(text.substring(i,i+patternLength).equals(pattern)) {
                    System.out.println("Match found at index : " +i);
                }
            }
            if(i< text.length() -  patternLength) {
                texthash = updateHash(texthash , text.charAt(i) , text.charAt(i+patternLength),patternLength);
            }

        }

    }

    public static void main(String[] args) {
        KarpRabin karpRabin =new KarpRabin();

        karpRabin.search("karmaasgkAmitasdhjkagh" , "Amit");

    }

}

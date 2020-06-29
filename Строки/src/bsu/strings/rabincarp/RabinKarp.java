package bsu.strings.rabincarp;

public class RabinKarp {
    private String pat;

    public RabinKarp(String pat) {
        this.pat = pat;
    }

    public String getPat() {
        return pat;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }


    public int count(String string, String pat) {
        String[] splitedText;
        int c = 0;
//        System.out.println(string);
        splitedText = string.split("[ ,!]");
        for (int i = 0; i < splitedText.length; i++) {
//            System.out.println(splitedText[i]);
            if (splitedText[i].equals(pat)) {
                c++;
            }
        }
        return c;
    }

    public int[] searchAll(String text, String pat) {
        String[] splitedText = text.split("[ ,!]");
        int[] positions = new int[this.count(text, pat) + 1];
        int[] entryPositions = new int[this.count(text, pat)];
        int count = 0;
        for (int i = 0; i < splitedText.length; i++) {
            if (splitedText[i].equals(pat)) {
                positions[count++] = i;
            }
        }
        for (int i = 0, c = 0; i < splitedText.length; i++) {
            for (int j = 0; ; j++) {
                if (i == positions[c]) {
                    entryPositions[c] = j;
                    c++;
                    i = 0;
                    break;
                } else if (text.charAt(j) == ' ' || text.charAt(j) == ',' || text.charAt(j) == '!') {
                    i++;
                }
                if (j == text.length() - 1) {
                    return entryPositions;
                }
            }
        }
        return entryPositions;
    }


    @Override
    public String toString() {
        return "RabinKarp{" +
                "pat='" + pat + '\'' +
                '}';
    }
}

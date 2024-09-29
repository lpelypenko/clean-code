package com.b.simple.design.business.text;

public class TextHelper {

    public String swapLastTwoCharactersMine(String str) {
		int len = str.length();
        if (len <= 1) {
            return str;
        }

        StringBuilder res = new StringBuilder();
		res.append(str, 0, len - 2);
		char lastCharacter = str.charAt(len - 1);
		char prevLast = str.charAt(len - 2);
		res.append(lastCharacter);
		res.append(prevLast);

        return res.toString();
    }

    public String swapLastTwoCharacters(String str) {
        int len = str.length();
        if (len <= 1) {
            return str;
        }
        char lastCharacter = str.charAt(len - 1);
        char prevLast = str.charAt(len - 2);

        String restOfString = str.substring(0, len - 2);

        return restOfString + lastCharacter + prevLast;
    }

    public String truncateAInFirst2PositionsAttempt1(String str) {
        int len = str.length();
        if (len == 0) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        char firstCharacter = str.charAt(0);
        if (firstCharacter != 'A') {
            res.append(firstCharacter);
        }
        if (len >= 2) {
            char secondCharacter = str.charAt(2);
             if (secondCharacter != 'A') {
                 res.append(secondCharacter);
             }
        }
        if (len >= 3) {
            String restOfString = str.substring(3);
            res.append(restOfString);
        }

        return res.toString();
    }

    public String truncateAInFirst2PositionsAttempt2(String str) {
        if (str.length() <= 2) {
            return str.replaceAll("^A+", "");
        }
        String firstTwo = str.substring(0, 2).replaceAll("A", "");
        return firstTwo + str.substring(2);
    }

    public String truncateAInFirst2Positions(String str) {
        if (str.length() <= 2) {
            return str.replaceAll("A", "");
        }
        String firstTwo = str.substring(0, 2);
        String firstTwoCharactersRemoved = firstTwo.replaceAll("A", "");
        String restOfTheString = str.substring(2);

        return firstTwoCharactersRemoved + restOfTheString;
    }
}

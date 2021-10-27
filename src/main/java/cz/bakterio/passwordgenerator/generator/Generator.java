package cz.bakterio.passwordgenerator.generator;

import java.util.LinkedList;
import java.util.Random;

public class Generator {

    private boolean lowerCase = true;
    private boolean upperCase = true;
    private boolean numbers = true;
    private boolean special = true;
    private int length;

    private String stringPassword = "password";
    private LinkedList<Character> password = new LinkedList<>();

    public boolean isLowerCase() {
        return lowerCase;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setLowerCase(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    public boolean isUpperCase() {
        return upperCase;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public boolean isNumbers() {
        return numbers;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public Generator() {}

    public Generator(int length) {
        this.length = length;
    }

    private char[] letters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] specialChar = new char[] {',', '?', '.', ':', '-', '_', '"', '!', '§', '/', '(', ')', ';', '@', '°', '#', '{', '}', '^', '~', '[', ']', '`', '\\', '€',};
    private char[] numbersChar = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    Random r = new Random();

    public void generate() {

        for (int i = 0; i < length; i++) {
            password.add(letters[r.nextInt(letters.length)]);
        }

        if (upperCase) {
            for (int i = 0; i < length/3; i++) {
                password.set(r.nextInt(password.size()), String.valueOf(letters[r.nextInt(letters.length)]).toUpperCase().toCharArray()[0]);
            }
        }

        if (special)
            addPassword(specialChar);
        if (numbers)
            addPassword(numbersChar);

        makePassword();
    }

    private void addPassword(char[] a) {
        for (int i = 0; i < this.length/3; i++) {
            password.set(r.nextInt(password.size()), a[r.nextInt(a.length)]);
        }
    }

    public String getStringPassword() {
        return stringPassword;
    }

    private void makePassword() {
        StringBuilder builder = new StringBuilder();

        for (Character i : password) {
            builder.append(i);
        }

        stringPassword = builder.toString();
    }
}

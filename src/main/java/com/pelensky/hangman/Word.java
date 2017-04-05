package com.pelensky.hangman;

class Word {
    String word;
    private char[] characters;

    Word(String word) {
        this.word = word.toUpperCase();
        this.characters = new char[this.word.length()];
    }

    String showCharacters() {
        return String.valueOf(this.characters);
    }

    void setUnderscoresForCharacters() {
        for (int i = 0; i < this.word.length(); i++) {
            this.characters[i] = '_';
        }
    }

    void guessLetter(char letter) {
        letter = Character.toUpperCase(letter);
        if (containsLetter(letter)){
            replaceCharacter(letter);
        }
    }

    private boolean containsLetter(char letter) {
        return (this.word.contains(String.valueOf(letter)));
    }

    private void replaceCharacter(char letter) {
        for (int x = 0; x < this.word.length(); x++) {
            if (this.word.charAt(x) == letter) {
                this.characters[x] = letter;
            }
        }
    }

}
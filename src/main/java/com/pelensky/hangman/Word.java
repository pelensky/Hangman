package com.pelensky.hangman;

class Word {
    String word;
    private char[] characters;
    private String[] wordList = {"Rat", "Mouse", "Hamster", "Squirrel", "Chinchilla", "Gerbil", "Beaver", "Gopher", "Lemming", "Capybara" };

    Word(String word) {
        this.word = word.toUpperCase();
        this.characters = new char[this.word.length()];
    }

    Word(){
        chooseRandomWord();
    }

   void chooseRandomWord(){
        this.word = wordList[(int) (Math.random() * wordList.length)].toUpperCase();
        this.characters = new char[this.word.length()];
        setUnderscoresForCharacters();
   }

    String showWord(){
       return this.word;
    }

    String showCharacters() {
        return String.valueOf(this.characters);
    }

    void setUnderscoresForCharacters() {
        for (int i = 0; i < this.word.length(); i++) {
            this.characters[i] = '_';
        }
    }

    boolean guessLetter(char letter) {
        letter = Character.toUpperCase(letter);
        if (containsLetter(letter)){
            replaceCharacter(letter);
           }
           return containsLetter(letter);

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

    boolean checkWordMatchesGuesses(){
        return this.word.equals(showWordCharacters());
    }

    private String showWordCharacters(){
        return String.valueOf(this.characters);
    }

}
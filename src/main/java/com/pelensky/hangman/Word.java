package com.pelensky.hangman;

class Word {
    String word;
    private char[] characters;

    Word(String word){
        this.word = word;
        this.characters = new char[this.word.length()];
    }

    String showCharacters(){
        return String.valueOf(this.characters);
    }

    void setUnderscoresForCharacters(){
        for(int i=0; i < this.word.length(); i++){
            this.characters[i] = '_';
        }
    }
}

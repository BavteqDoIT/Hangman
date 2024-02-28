import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    List<String> words = List.of("plumber","watch","elephant","matches");
    String word;
    char[] userWord;
    int lives = 3;

    public void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's the game begin!");

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord,'_');

        while(!gameEnded()){
            System.out.println(userWord);
            System.out.println();
            System.out.println("Lives left: " + lives);
            System.out.print("Enter another letter: ");


            char letter = scanner.nextLine().charAt(0);

            checkletter(letter);
        }
        if (lives == 0){
            System.out.println();
            System.out.println("You Lost!");
        }else{
            System.out.println();
            System.out.println("Your word was: "+word);
            System.out.println("Congratulations!\n" + "You won!");
        }

        scanner.close();
    }

    private void checkletter(char letter) {
        boolean foundLetter = false;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == letter){
                userWord[i] = letter;
                foundLetter = true;
            }
        }

        if(!foundLetter){
            System.out.println("There's no letter '" + letter + "' in your word! :(");
            lives--;
        }
    }

    private boolean gameEnded() {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }

}

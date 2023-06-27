import com.lilittlecat.chatgpt.offical.ChatGPT;
import java.util.Scanner;

// This software tells ChatGPT to respond to a user's questions
// with typical Magic 8-Ball answers, but adding slurred speech
// and digressions emblematic of inebriation.
// It is based on Yi Liu's ChatGPTTest.java found here:
// https://github.com/LiLittleCat/ChatGPT
// The ask() method opens a REST call to the OpenAI API, and POSTs
// a text string, and stores a result in a string.
// This software prompts the user for the OpenAI API key.
// Apply for your own here: https://platform.openai.com/account/api-keys

public class Magic8Ball {

    // Hard-coded integer limit on the number of questions the user may pose before the program ends
    public static int limit = 4;

    public static void main(String[] args) {

        // Request user's OpenAI API key:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your API key: ");
        String apiKey = scanner.nextLine();

        // WELCOME
        System.out.println("THE MAGIC 8-BALL HAS BEEN DRINKING");

        // Initial narration and prompt
        System.out.println("In the musty bar, the crowd noise and dim lighting make the 8-Ball " +
                "difficult to read. A liquid covers half\nthe table surface, attesting that 8-Ball's " +
                "evening began long ago. It occurs to you that you would do well\nto get your answers " +
                "quickly, as even now 8-Ball stares insolently at you. Its glossy black face reads" +
                "\n'Ask me anything.': ");

        try {
            ChatGPT chatGPT = new ChatGPT(apiKey);
            Scanner scannerNext = new Scanner(System.in);

            for (int i = 0; i < limit; i++) {

                System.out.println("Please enter your question: ");
                String currentQuestion = scannerNext.nextLine();

                String currentQuery = chatGPT.ask(currentQuestion + " is the question. Please respond " +
                        "in the manner of a typical Magic 8-Ball, but with a few slurred words as though drunk. " +
                        "Address the questioner as buddy, pal, or with some synonym for the word friend.");
                System.out.println(currentQuery);

                if (i == limit - 1) {
                    System.out.println("The crowd gives way, and the bouncer suddenly looms large behind 8-Ball. " +
                            "'HEY! You and YOU are OUTTA here.' Standing unsteadily, you quickly follow Magic 8-Ball " +
                            "out the door, and into the night...disoriented, but wiser.");
                    System.exit(0);
                }
            }
        } catch (IllegalStateException ise) {
            System.err.println("THIS ERROR PROBABLY OCCURRED BECAUSE THE API KEY IS BAD OR YOU HAVE HIT QUOTA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


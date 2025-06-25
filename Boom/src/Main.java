import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    public static void main(String[] args) {
        String filePath = "Vine-boom-sound-effect.wav";
        
        File file = new File(filePath);

        try(Scanner scanner = new Scanner(System.in);AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("Press ENTER to play sound, or Q to quit.");
            while (true) {
                String input = scanner.nextLine().trim().toUpperCase();

                if (input.equals("Q")) break;

                clip.setFramePosition(0);
                clip.start();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not locate file");
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file not supported");
        }
        catch (LineUnavailableException e) {
            System.out.println("Cannot access audio resource.");
        }
        catch (IOException e) {
            System.out.println("Something Went Wrong.");
        }
        finally {
            System.out.println("Bye!");
        }
    }
}

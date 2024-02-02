import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicBg {

    File file = new File("/Users/aleksandrtian/Desktop/IT/JAVA/Projects/Educational project/Meditation_app/src/alarm.wav");
    AudioInputStream audioStream;

    {
        try {
            audioStream = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Clip clip;

    {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void musicBg() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        clip.open(audioStream);

        clip.start();

    }

    public void stopMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        clip.stop();

    }


}

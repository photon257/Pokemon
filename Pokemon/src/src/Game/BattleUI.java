package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import Constructors.*;
import Libraries.Attackdex;

public class BattleUI {
	
 static int hp;
 static int ehp;

public static void main(String[] args) {

	BattleFrame b = new BattleFrame("Absol", "Pikachu");
	BattleFrame.battle(b);
	music();


}


public static void music() {
	final int BUFFER_SIZE = 128000;
    File soundFile = null;
    AudioInputStream audioStream = null;
    AudioFormat audioFormat;
    SourceDataLine sourceLine = null;
    String filename = "H:\\Computer Programming\\src\\Music\\Gyms\\videoplayback.wav";
   

        String strFilename = filename;
        try {
            soundFile = new File(strFilename);
            audioStream = AudioSystem.getAudioInputStream(soundFile);
            audioFormat = audioStream.getFormat();
	        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }
}
}

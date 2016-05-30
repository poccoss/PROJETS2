import javazoom.jl.player.advanced.*;
import java.io.*;
        
        // MP3, WMA, MPEG, WAV compatible
        
        public class Sound {
                public Sound(String path) throws Exception {
                        InputStream in = (InputStream)new BufferedInputStream(new FileInputStream(new File(path)));
                        player = new AdvancedPlayer(in);
                }
                
                public Sound(String path,PlaybackListener listener) throws Exception {
                        InputStream in = (InputStream)new BufferedInputStream(new FileInputStream(new File(path)));
                        player = new AdvancedPlayer(in);
                        player.setPlayBackListener(listener);
                }
                
                public void play() throws Exception {
                        if (player != null) {
                                isPlaying = true;
                                player.play();
                        }
                }
                
                public void play(int begin,int end) throws Exception {
                        if (player != null) {
                                isPlaying = true;
                                player.play(begin,end);
                        }
                }
                
                public void stop() throws Exception {
                        if (player != null) {
                                isPlaying = false;
                                player.stop();
                        }
                }
                
                public boolean isPlaying() {
                        return isPlaying;
                }

                private boolean isPlaying = false;
                private AdvancedPlayer player = null;
        }
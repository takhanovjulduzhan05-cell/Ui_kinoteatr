public class HomeTheaterFacade {
    private final Projector projector = new Projector();
    private final SoundSystem sound = new SoundSystem();
    private final Lights lights = new Lights();
    private final VideoPlayer player = new VideoPlayer();
    private boolean playing;

    public void watchMovie(String movie) {
        if (playing) { System.out.println("Фильм қосылып тұр!"); return; }
        lights.dim();
        projector.on();
        sound.on();
        sound.setVolume(50);
        player.play(movie);
        playing = true;
        System.out.println("Кинотеатр дайын!");
    }
    public void endMovie() {
        if (!playing) { System.out.println("Фильм қосылмаған."); return; }
        player.stop();
        sound.off();
        projector.off();
        lights.on();
        playing = false;
        System.out.println("Кинотеатр өшірілді.");
    }
    public void setVolume(int volume) {
        if (!playing) { System.out.println("Алдымен фильм қосыңыз."); return; }
        if (volume < 0 || volume > 100) { System.out.println("0-100 аралығын енгізіңіз."); return; }
        sound.setVolume(volume);
    }
    public boolean isPlaying() { return playing; }
}

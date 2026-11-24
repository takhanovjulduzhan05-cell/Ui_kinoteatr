import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
        HomeTheaterFacade cinema = new HomeTheaterFacade();
        while (true) {
            System.out.println("\n=== ҮЙ КИНОТЕАТРЫ | FACADE ===");
            System.out.println("1. Фильм қосу\n2. Фильмді тоқтату\n3. Дыбысты реттеу\n4. Жүйе күйі\n0. Шығу");
            System.out.print("Таңдау: ");
            if (!scanner.hasNextLine()) break;
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Фильм атауы: ");
                    String movie = scanner.nextLine().trim();
                    if (movie.isEmpty()) System.out.println("Атау бос болмауы керек.");
                    else cinema.watchMovie(movie);
                    break;
                case "2": cinema.endMovie(); break;
                case "3":
                    System.out.print("Дыбыс (0-100): ");
                    try { cinema.setVolume(Integer.parseInt(scanner.nextLine().trim())); }
                    catch (NumberFormatException e) { System.out.println("Сан енгізіңіз."); }
                    break;
                case "4": System.out.println(cinema.isPlaying() ? "Кинотеатр қосулы" : "Кинотеатр өшірулі"); break;
                case "0":
                    if (cinema.isPlaying()) cinema.endMovie();
                    System.out.println("Сау болыңыз!");
                    scanner.close(); return;
                default: System.out.println("Қате таңдау.");
            }
        }
        if (cinema.isPlaying()) cinema.endMovie();
        scanner.close();
    }
}

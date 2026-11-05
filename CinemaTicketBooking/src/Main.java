import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Inception", 148);
        Movie movie2 = new Movie("The Dark Knight", 152);

        boolean[][] seats1 = new boolean[5][5];
        boolean[][] seats2 = new boolean[5][5];

        ShowTime st1 = new ShowTime(movie1, 12, seats1, "14:30 PM");
        ShowTime st2 = new ShowTime(movie2, 15, seats2, "18:00 PM");

        try (Scanner scanner = new Scanner(System.in)) {
            CinemaReservationSystem system = new CinemaReservationSystem();
            system.addShowTime(st1);
            system.addShowTime(st2);

            boolean running = true;

            while (running) {
                System.out.println("\n=== CINEMA RESERVATION SYSTEM ===");
                System.out.println("1. View Available Showtimes");
                System.out.println("2. Book a Ticket");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");

                int choice = getValidIntInput(scanner);

                switch (choice) {
                    case 1:
                        system.displayShowtimes();
                        break;
                    case 2:
                        system.handleBookingProcess(scanner);
                        break;
                    case 3:
                        System.out.println("Thank you for using the Cinema System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please select 1, 2, or 3.");
                }
            }
        }
    }

    private static int getValidIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
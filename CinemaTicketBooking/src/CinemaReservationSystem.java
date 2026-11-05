import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CinemaReservationSystem {
    private List<ShowTime> showTimes;
    private Random random;

    public CinemaReservationSystem() {
        this.showTimes = new ArrayList<>();
        this.random = new Random();
    }

    public void addShowTime(ShowTime showTime) {
        showTimes.add(showTime);
    }

    public void displayShowtimes() {
        if (showTimes.isEmpty()) {
            System.out.println("\nNo showtimes available.");
            return;
        }

        System.out.println("\n--- SCHEDULED SHOWTIMES ---");
        for (int i = 0; i < showTimes.size(); i++) {
            ShowTime st = showTimes.get(i);
            System.out.printf("%d. %s | Time: %s | Price: $%d%n",
                    (i + 1), st.getMovie().toString(), st.getTime(), st.getTicketPrice());
        }
    }

    public void handleBookingProcess(Scanner scanner) {
        if (showTimes.isEmpty()){
            System.out.println("\nNo showtimes available to book.");
            return;
        }

        displayShowtimes();
        System.out.print("Select a showtime number: ");
        int showtimeIndex = getValidIntInput(scanner) - 1;

        if (showtimeIndex < 0 || showtimeIndex >= showTimes.size()) {
            System.out.println("Invalid showtime selection.");
            return;
        }

        ShowTime selectedShowTime = showTimes.get(showtimeIndex);
        System.out.println(selectedShowTime.getSeatMap());

        System.out.print("Enter Row Number: ");
        int row = getValidIntInput(scanner) - 1;

        System.out.print("Enter Seat/Column Number: ");
        int col = getValidIntInput(scanner) - 1;

        if (selectedShowTime.bookSeat(row, col)) {
            int ticketId = random.nextInt(100000, 1000000);
            String seatLabel = "Row " + (row + 1) + ", Seat " + (col + 1);

            Ticket ticket = new Ticket(ticketId, seatLabel, selectedShowTime.getTicketPrice(), selectedShowTime);

            System.out.println("\n" + ticket.ticketRecipe());
        } else {
            System.out.println("\n[ERROR] Seat is occupied or out of bounds. Booking failed.");
        }
    }

    private int getValidIntInput(Scanner scanner){
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
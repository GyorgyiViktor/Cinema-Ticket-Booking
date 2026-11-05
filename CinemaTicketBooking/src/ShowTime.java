public class ShowTime {
    private Movie movie;
    private int ticketPrice;
    private boolean[][] seats;
    private String time;

    public ShowTime(Movie movie, int ticketPrice, boolean[][] seats, String time){
        setMovie(movie);
        setTicketPrice(ticketPrice);
        setSeats(seats);
        setTime(time);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean[][] getSeats() {
        return seats;
    }

    public void setSeats(boolean[][] seats) {
        this.seats = seats;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeatMap() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n  --- SEAT MAP (").append(movie.getTitle()).append(", ").append(time).append(") ---\n");
        sb.append("  [ MOVIE SCREEN ]\n");

        sb.append("   ");
        for (int col = 0; col < seats[0].length; col++) {
            sb.append(col + 1).append(" ");
        }
        sb.append("\n");

        for (int row = 0; row < seats.length; row++) {
            sb.append(row + 1).append(" ");
            for (int col = 0; col < seats[row].length; col++) {
                if (seats[row][col]) {
                    sb.append("[X]");
                } else {
                    sb.append("[O]");
                }
            }
            sb.append("\n");
        }
        sb.append("Hint: [O] Available | [X] Booked\n");

        return sb.toString();
    }

    public boolean isSeatAvailable(int row, int col) {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) return false;
        return !seats[row][col];
    }

    public boolean bookSeat(int row, int col) {
        if (isSeatAvailable(row, col)) {
            seats[row][col] = true;
            return true;
        }
        return false;
    }
}

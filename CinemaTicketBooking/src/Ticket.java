public class Ticket {
    private int ticketId;
    private String seatNumber;
    private ShowTime showTime;
    private int price;

    public Ticket(int ticketId, String seatNumber, int price, ShowTime showTime) {
        this.setTicketId(ticketId);
        this.setSeatNumber(seatNumber);
        this.setPrice(price);
        this.setShowTime(showTime);
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ShowTime getShowTime(){
        return showTime;
    }

    public void setShowTime(ShowTime showTime){
        this.showTime = showTime;
    }

    public String ticketRecipe(){
        return  "--- Ticket Recipe ---" +
                "Ticket id: " + this.getTicketId() +
                "\nSeat number: " + this.getSeatNumber() +
                "\nShowtime: " + this.getShowTime() +
                "\nPrice: " + this.getPrice();
    }
}

public class Movie {
    private String title;
    private int duration;

    public Movie(String title, int duration) {
        this.setTitle(title);
        this.setDuration(duration);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie title: " + this.getTitle() + ", duration: " + this.getDuration();
    }
}

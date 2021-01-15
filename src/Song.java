public class Song
{
    private String title;
    private double songLength;

    public Song(String title, double songLength)
    {
        this.title = title;
        this.songLength = songLength;
    }

    public String getTitle() {
        return title;
    }

    public double getSongLength() {
        return songLength;
    }

    public String toString()
    {
        return title;
    }
}

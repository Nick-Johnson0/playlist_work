import java.util.ArrayList;

public class Album
{
    private ArrayList<Song> songs;
    private String albumName;

    public Album(String albumName)
    {
        songs = new ArrayList<Song>();
        this.albumName = albumName;
    }

    public Song getSong(String songName)
    {
        for (int i = 0; i < songs.size(); i++)
        {
            if (songs.get(i).getTitle().equalsIgnoreCase(songName))
            {
                return songs.get(i);
            }
        }
        System.out.println("Song doesn't exist in album");
        return null;
    }

    public String getAlbumName() {
        return albumName;
    }

    public boolean doesSongExist(String songName)
    {
        for (int i = 0; i < songs.size(); i++)
        {
            if (songs.get(i).getTitle().equalsIgnoreCase(songName))
            {
                return true;
            }
        }
        return false;
    }

    public boolean addSong(Song song)
    {
        boolean songAlreadyExists = doesSongExist(song.getTitle());
        boolean successfullyAddedSong = false;
        if (!songAlreadyExists)
        {
            songs.add(song);
            return true;
        }
        return false;
    }

    public String toString()
    {
        return albumName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}

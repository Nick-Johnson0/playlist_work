import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist
{
    private LinkedList<Song> playlist;
    private ListIterator<Song> iterator;
    private ArrayList<Album> albums;
    private boolean goingForward;

    public Playlist()
    {
        playlist = new LinkedList<Song>();
        iterator = playlist.listIterator();
        albums = new ArrayList<Album>();
        goingForward = true;
        generateAlbums();
    }
    private boolean doesSongExist(String name)
    {
        ListIterator<Song> iterator = playlist.listIterator();
        while(iterator.hasNext())
        {
            if(iterator.next().getTitle().equalsIgnoreCase(name))
            {
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String songName)
    {
       for (int i = 0; i < albums.size(); i++)
       {
           for (int j = 0; j < albums.get(i).getSongs().size(); j++)
           {
               Song song = albums.get(i).getSongs().get(j);
               if (song.getTitle().equalsIgnoreCase(songName) && !doesSongExist(songName))
               {
                   playlist.add(song);
                   iterator = playlist.listIterator();
                   return true;
               }
           }
       }
        System.out.println("Sorry either the song doesn't exist or it's already in the playlist");
       return false;
    }

    public boolean skipSong()
    {
        if (goingForward)
        {
            if (iterator.hasNext())
            {
                Song nextSong = iterator.next();
                playSong(nextSong.getTitle());
                return true;
            }
            else
            {
                System.out.println("Reached the end of the playlist...");
                return false;
            }
        }
        else
        {
            if (iterator.hasNext())
            {
                iterator.next();
            }
            goingForward = true;
            if (iterator.hasNext())
            {
                Song nextSong = iterator.next();
                playSong(nextSong.getTitle());
                return true;
            }
            return false;
        }
    }

    public boolean playPreviousSong()
    {
        if (goingForward)
        {
            if (iterator.hasPrevious())
            {
                iterator.previous();
                goingForward = false;
            }
            if (iterator.hasPrevious())
            {
                Song song = iterator.previous();
                playSong(song.getTitle());
                return true;
            }
        }
        else
        {
            if (iterator.hasPrevious())
            {
                Song song = iterator.previous();
                playSong(song.getTitle());
                return false;
            }
        }
        return false;
    }

    public boolean replaySong()
    {
        if(goingForward)
        {
            if (iterator.hasPrevious())
            {
                Song song = iterator.previous();
                playSong(song.getTitle());
                goingForward = false;
                return true;
            }
        }
        else
        {
            if (iterator.hasNext())
            {
                Song song = iterator.next();
                playSong(song.getTitle());
                goingForward = true;
                return true;
            }
        }
        return false;
    }

    public void removeSong() // have to work on this
    {
        iterator.remove();
        skipSong();

    }

    private void playSong(String songName)
    {
        StringBuilder sb = new StringBuilder();
        ListIterator<Song> tempList = playlist.listIterator();
        while(tempList.hasNext())
        {
            String songTitle = tempList.next().getTitle();
            if (songTitle.equalsIgnoreCase(songName))
            {
                sb.append(songTitle + " is now playing...\n");
            }
            else
            {
                sb.append(songTitle + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    private void generateAlbums()
    {
        Album one = new Album("DRFL");
        one.addSong(new Song("a", 1.5));
        one.addSong(new Song("b", 1.5));
        one.addSong(new Song("c", 1.5));
        one.addSong(new Song("d", 1.5));
        Album two = new Album("ABC");
        two.addSong(new Song("e", 1.5));
        two.addSong(new Song("f", 1.5));
        two.addSong(new Song("g", 1.5));
        albums.add(one);
        albums.add(two);

    }

    public void showSongSelection()
    {
        System.out.println("Songs that you own:");
        for (int i = 0; i < albums.size(); i++) {
            System.out.println(albums.get(i).getAlbumName() + ":");
            for (int j = 0; j < albums.get(i).getSongs().size(); j++) {
                Song song = albums.get(i).getSongs().get(j);
                System.out.println(song.getTitle());
            }
        }
    }

    public void displayPlaylist()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Your playlist:\n");
        ListIterator<Song> one = playlist.listIterator();

        while(one.hasNext())
        {
            Song song = one.next();
            sb.append(song.getTitle() + "\n");
        }
        System.out.println(sb.toString());
    }

    public void displayMenuOptions()
    {
        System.out.println("1: Add song to playlist");
        System.out.println("2: Begin playing songs");
        System.out.println("3: Skip song");
        System.out.println("4: Play previous song");
        System.out.println("5: Replay song");
        System.out.println("6: Remove song");
        System.out.println("7: Show available songs to be added to the playlist");
        System.out.println("8: Show playlist");
        System.out.println("9: Quit music player");

    }
}

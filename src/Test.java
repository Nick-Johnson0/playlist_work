import java.util.Scanner;
public class Test
{
    public static void main(String[] args)
    {
        Playlist one = new Playlist();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running)
        {
            one.displayMenuOptions();
            System.out.print("Please select your choice 1-9:");
            int selection = input.nextInt();
            while (selection < 1 || selection > 9)
            {
                System.out.print("Please select a valid choice 1-9: ");
                selection = input.nextInt();
            }

            switch(selection)
            {
                case 1:
                    System.out.println("You have selected to add a song");
                    System.out.print("What song would you like to add?: ");
                    input.nextLine();
                    String choice = input.nextLine();
                    one.addSong(choice);
                    break;

                case 2:
                    one.skipSong();
                    break;

                case 3:
                    one.skipSong();
                    break;

                case 4:
                    one.playPreviousSong();
                    break;

                case 5:
                    one.replaySong();
                    break;

                case 6:
                    System.out.println("Removing current song...");
                    one.removeSong();
                    break;

                case 7:
                    one.showSongSelection();
                    break;

                case 8:
                    one.displayPlaylist();
                    break;

                case 9:
                    running = false;
                    break;
            }
        }
    }
}

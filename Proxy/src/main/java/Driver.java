import java.util.List;

public class Driver {
    public static void main(String[] args) {
        RealSongServer realServer = new RealSongServer();

        // Add some songs to the real server
        realServer.addSong(new Song(1, "Song1", "Artist1", "Album1", 180));
        realServer.addSong(new Song(2, "Song2", "Artist2", "Album2", 240));
        realServer.addSong(new Song(3, "Song3", "Artist3", "Album1", 200));
        realServer.addSong(new Song(4, "Song4", "Artist2", "Album2", 220));
        realServer.addSong(new Song(5, "Song5", "Artist1", "Album3", 190));

        SongService proxyService = new SongServiceProxy(realServer);

        System.out.println("Searching for songs:");
        System.out.println("------------------------------");

        System.out.println("Searching for song with ID 1:");
        Song song1 = proxyService.searchById(1);
        printSongInfo(song1);
        System.out.println();

        System.out.println("Searching for songs with title 'Song2':");
        List<Song> songsWithTitle2 = proxyService.searchByTitle("Song2");
        for (Song song : songsWithTitle2) {
            printSongInfo(song);
        }
        System.out.println();

        System.out.println("Searching for songs in album 'Album1':");
        List<Song> songsInAlbum1 = proxyService.searchByAlbum("Album1");
        for (Song song : songsInAlbum1) {
            printSongInfo(song);
        }
    }

    private static void printSongInfo(Song song) {
        if (song != null) {
            System.out.println("Title: " + song.getTitle());
            System.out.println("Artist: " + song.getArtist());
            System.out.println("Album: " + song.getAlbum());
            System.out.println("Duration: " + song.getDuration() + " seconds");
        } else {
            System.out.println("Song not found.");
        }
        System.out.println("------------------------------");
    }
}
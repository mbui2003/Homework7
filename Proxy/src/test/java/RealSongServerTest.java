import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealSongServerTest {
    private RealSongServer songServer;
    private Song expectedSong;

    @BeforeEach
    public void setUp() {
        songServer = new RealSongServer();
        expectedSong = new Song(1, "Song1", "Artist1", "Album1", 180);
        songServer.addSong(expectedSong);
    }

    @Test
    public void testAddSong() {
        Song actualSong = songServer.searchById(1);

        assertEquals(expectedSong, actualSong);
    }

    @Test
    public void testAddToIndex() {
        // Check if the song is indexed correctly by title and album
        List<Song> songsByTitle = songServer.searchByTitle("Song1");
        List<Song> songsByAlbum = songServer.searchByAlbum("Album1");

        assertEquals(expectedSong, songsByTitle.get(0));

        assertEquals(expectedSong, songsByAlbum.get(0));
    }

    @Test
    public void testSearchById() {
        Song actualSong = songServer.searchById(1);

        assertEquals(expectedSong, actualSong);
    }

    @Test
    public void testSearchByTitle() {
        List<Song> songsByTitle = songServer.searchByTitle("Song1");
        Song actualSong = songsByTitle.get(0);

        assertEquals(expectedSong, actualSong);
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> songsByAlbum = songServer.searchByAlbum("Album1");
        Song actualSong = songsByAlbum.get(0);

        assertEquals(expectedSong, actualSong);
    }
}
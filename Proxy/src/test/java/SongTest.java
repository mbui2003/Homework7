import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {
    private Song song;

    @BeforeEach
    public void setUp() {
        song = new Song(1, "Song1", "Artist1", "Album1", 180);
    }

    @Test
    public void testGetId() {
        int expectedID = 1;
        int actualID = song.getId();

        assertEquals(expectedID, actualID);
    }

    @Test
    public void testGetTitle() {
        String expectedTitle = "Song1";
        String actualTitle = song.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testGetArtist() {
        String expectedArtist = "Artist1";
        String actualArtist = song.getArtist();

        assertEquals(expectedArtist, actualArtist);
    }

    @Test
    public void testGetAlbum() {
        String expectedAlbum = "Album1";
        String actualArtist = song.getAlbum();

        assertEquals(expectedAlbum, actualArtist);
    }

    @Test
    public void testGetDuration() {
        int expectedDuration = 180;
        int actualDuration = song.getDuration();

        assertEquals(expectedDuration, actualDuration);
    }
}
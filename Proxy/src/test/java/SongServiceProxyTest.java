import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SongServiceProxyTest {
    private SongServiceProxy songServiceProxy;
    private SongService realService;

    @BeforeEach
    public void setUp() {
        realService = mock(SongService.class);
        songServiceProxy = new SongServiceProxy(realService);
    }

    @Test
    public void testSearchByIdCacheHit() {
        Song expectedSong = new Song(1, "Song1", "Artist1", "Album1", 180);

        when(realService.searchById(1)).thenReturn(expectedSong);

        // Perform initial search to fetch the song from the real service and store it in the cache
        songServiceProxy.searchById(1);

        // Configure the mock to throw an error if realService.searchById(1) is called again
        when(realService.searchById(1)).thenThrow(new AssertionError("Real service should not be called"));

        Song actualSong = songServiceProxy.searchById(1);

        assertNotNull(actualSong);
        assertEquals(expectedSong, actualSong);
    }

    @Test
    public void testSearchByIdCacheMiss() {
        Song expectedSong = new Song(1, "Song1", "Artist1", "Album1", 180);
        when(realService.searchById(1)).thenReturn(expectedSong);

        Song actualSong = songServiceProxy.searchById(1);

        assertEquals(expectedSong, actualSong);
        verify(realService, times(1)).searchById(1);
    }

    @Test
    public void testSearchByTitleCacheHit() {
        List<Song> expectedSongs = new ArrayList<>();
        expectedSongs.add(new Song(1, "Song1", "Artist1", "Album1", 180));

        when(realService.searchByTitle("Song1")).thenReturn(expectedSongs);

        // Perform initial search to fetch the song from the real service and store it in the cache
        songServiceProxy.searchByTitle("Song1");

        // Configure the mock to throw an error if realService.searchByTitle("Song1") is called again
        when(realService.searchByTitle("Song1")).thenThrow(new AssertionError("Real service should not be called"));

        List<Song> actualSongs = songServiceProxy.searchByTitle("Song1");

        assertNotNull(actualSongs);
        assertEquals(expectedSongs, actualSongs);
    }

    @Test
    public void testSearchByTitleCacheMiss() {
        List<Song> expectedSongs = new ArrayList<>();
        expectedSongs.add(new Song(1, "Song1", "Artist1", "Album1", 180));
        when(realService.searchByTitle("Song1")).thenReturn(expectedSongs);

        List<Song> actualSongs = songServiceProxy.searchByTitle("Song1");

        assertEquals(expectedSongs, actualSongs);
        verify(realService, times(1)).searchByTitle("Song1");
    }

    @Test
    public void testSearchByAlbumCacheHit() {
        List<Song> expectedSongs = new ArrayList<>();
        expectedSongs.add(new Song(1, "Song1", "Artist1", "Album1", 180));

        when(realService.searchByAlbum("Album1")).thenReturn(expectedSongs);

        // Perform initial search to fetch the song from the real service and store it in the cache
        songServiceProxy.searchByAlbum("Album1");

        // Configure the mock to throw an error if realService.searchByAlbum("Album1") is called again
        when(realService.searchByAlbum("Album1")).thenThrow(new AssertionError("Real service should not be called"));

        List<Song> actualSongs = songServiceProxy.searchByAlbum("Album1");

        assertNotNull(actualSongs);
        assertEquals(expectedSongs, actualSongs);
    }

    @Test
    public void testSearchByAlbumCacheMiss() {
        List<Song> expectedSongs = new ArrayList<>();
        expectedSongs.add(new Song(1, "Song1", "Artist1", "Album1", 180));
        when(realService.searchByAlbum("Album1")).thenReturn(expectedSongs);

        List<Song> actualSongs = songServiceProxy.searchByAlbum("Album1");

        assertEquals(expectedSongs, actualSongs);
        verify(realService, times(1)).searchByAlbum("Album1");
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RealSongServer implements SongService {
    private Map<Integer, Song> songDatabase;
    private Map<String, List<Song>> titleIndex;
    private Map<String, List<Song>> albumIndex;

    public RealSongServer() {
        this.songDatabase = new HashMap<>();
        this.titleIndex = new HashMap<>();
        this.albumIndex = new HashMap<>();
    }

    // Public method to add a song to the database and indexes
    public void addSong(Song song) {
        songDatabase.put(song.getId(), song);
        addToIndex(titleIndex, song.getTitle(), song);
        addToIndex(albumIndex, song.getAlbum(), song);
    }

    private void addToIndex(Map<String, List<Song>> index, String key, Song song) {
        List<Song> songs = index.getOrDefault(key, new ArrayList<>());
        songs.add(song);
        index.put(key, songs);
    }

    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        return songDatabase.getOrDefault(songID, null);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        return titleIndex.getOrDefault(title, new ArrayList<>());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        return albumIndex.getOrDefault(album, new ArrayList<>());
    }
}
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SongServiceProxy implements SongService {
    private Map<Integer, Song> songCache;
    private Map<String, List<Song>> titleCache;
    private Map<String, List<Song>> albumCache;
    private SongService realService;

    public SongServiceProxy(SongService realService) {
        this.realService = realService;
        this.songCache = new HashMap<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (cacheContainsID(songID)) {
            return songCache.get(songID);
        } else {
            Song song = realService.searchById(songID);
            if (song != null) {
                songCache.put(songID, song);
            }
            return song;
        }
    }

    private boolean cacheContainsID(Integer songID) {
        return songCache.containsKey(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (cacheContainsTitle(title)) {
            return titleCache.get(title);
        } else {
            List<Song> songs = realService.searchByTitle(title);
            if (songs != null) {
                titleCache.put(title, songs);
            }
            return songs;
        }
    }

    private boolean cacheContainsTitle(String title) {
        return titleCache.containsKey(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (cacheContainsAlbum(album)) {
            return albumCache.get(album);
        } else {
            List<Song> songs = realService.searchByAlbum(album);
            if (songs != null) {
                albumCache.put(album, songs);
            }
            return songs;
        }
    }

    private boolean cacheContainsAlbum(String album) {
        return albumCache.containsKey(album);
    }
}
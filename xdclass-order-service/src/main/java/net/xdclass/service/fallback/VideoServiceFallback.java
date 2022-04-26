package net.xdclass.service.fallback;

import net.xdclass.domain.Video;
import net.xdclass.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceFallback implements VideoService {

    @Override
    public Video findById(int videoId) {
        Video video = new Video();
        video.setTitle("fallback");
        return video;
    }

    @Override
    public int save(Video video) {
        return 0;
    }
}

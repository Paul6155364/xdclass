package net.xdclass.service;

import net.xdclass.domain.Video;
import net.xdclass.service.fallback.VideoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 选择feign
 * 默认集成了ribbon
 * 写起来更加思路清晰和方便
 * 采用注解方式进行配置，配置熔断等方式方便
 */
@FeignClient(name="xdclass-video-service",fallback = VideoServiceFallback.class)
public interface VideoService {

    @GetMapping(value = "/api/v1/video/find_by_id")
    Video findById(@RequestParam("videoId") int videoId);

    @PostMapping(value = "/api/v1/video/save")
    int save(@RequestBody Video video);

}

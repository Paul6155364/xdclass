package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.domain.VideoOrder;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description 旭瑶&小滴课堂 xdclass.net
 * @Author 二当家小D  代码、笔记和技术指导联系我即可
 * @Version 1.0
 **/

@RestController
@RequestMapping("api/v1/video_order")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private VideoService videoService;


    @RequestMapping("/find_by_id")
    public Object findById(int videoId){

        //Video video = restTemplate.getForObject("http://localhost:9000/api/v1/video/find_by_id?videoId="+videoId, Video.class);
//        List<ServiceInstance> list= discoveryClient.getInstances("xdclass-video-service");
//        ServiceInstance serviceInstance = list.get(0);
        //Video video = restTemplate.getForObject("http://xdclass-video-service/api/v1/video/find_by_id?videoId="+videoId, Video.class);
        Video video = videoService.findById(videoId);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(new Date());
        videoOrder.setServerInfo(video.getServeInfo());
        return videoOrder;

    }

    @RequestMapping("/save")
    public Object save(@RequestBody Video video){
        int rows = videoService.save(video);
        return new HashMap<>().put("rows",rows);

    }




}

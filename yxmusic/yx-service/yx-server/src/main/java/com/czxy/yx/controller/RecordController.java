package com.czxy.yx.controller;

import com.czxy.yx.util.SpeechRecognizerDemo1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/yx-record")
public class RecordController {

    String appKey = "ZRb414AGFhVbLTet"; // "填写你的appkey";
    String id = "LTAIK0uS1smz1Y7t"; // "填写你在阿里云网站上的AccessKeyId";
    String secret = "nDep3Tadkwy9Na2zKDCfbKo5lzRD1b"; // "填写你在阿里云网站上的AccessKeySecret";
    String url = ""; // 默认即可，默认值：wss://nls-gateway.cn-shanghai.aliyuncs.com/ws/v1


    @PostMapping("/record")
    public ResponseEntity<String> record(@RequestParam("record.pcm") MultipartFile  file) throws IOException {

        System.out.println(file);
        System.out.println(file.getSize());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());

        for (byte aByte : file.getBytes()) {
            System.out.print(aByte);
        }
        System.out.println("---------------------------------");

        int read = file.getInputStream().read();

        System.out.println(read+":");



        SpeechRecognizerDemo1 demo = new SpeechRecognizerDemo1(appKey, id, secret, url);
        // TODO 重要提示： 这里用一个本地文件来模拟发送实时流数据，实际使用时，用户可以从某处实时采集或接收语音流并发送到ASR服务端

        demo.process(file.getInputStream(), 16000);
        demo.shutdown();

        return ResponseEntity.ok("");
    }

}

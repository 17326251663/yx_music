package com.czxy.yx.util;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;

public class BaiDu {
    public void asr(AipSpeech client) throws IOException {
        // 对本地语音文件进行识别
        String path = "D:\\code\\java-sdk\\speech_sdk\\src\\test\\resources\\16k_test.pcm";
        org.json.JSONObject asrRes = client.asr(path, "pcm", 16000, null);
        System.out.println(asrRes);

        // 对语音二进制数据进行识别
        byte[] data = Util.readFileByBytes(path);     //readFileByBytes仅为获取二进制数据示例
        JSONObject asrRes2 = client.asr(data, "wav", 16000, null);
        System.out.println(asrRes2);

    }

    public static void main(String[] args) {

    }
}

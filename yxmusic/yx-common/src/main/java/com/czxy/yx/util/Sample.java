package com.czxy.yx.util;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;

import java.io.IOException;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "17399426";
    public static final String API_KEY = "agfzrW2OGp1XXKsvae6diRS0";
    public static final String SECRET_KEY = "ehUUjnVerfSYiO4PaGQofz0rzLMe4GSh";

    public static void main(String[] args) throws IOException {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        JSONObject res = client.asr("E://123.mp3", "pcm", 16000, null);
        System.out.println(res.toString(2));

       /* // 对本地语音文件进行识别
        String path = "D:\\code\\java-sdk\\speech_sdk\\src\\test\\resources\\16k_test.pcm";
        JSONObject asrRes = client.asr(path, "pcm", 16000, null);
        System.out.println(asrRes);

        // 对语音二进制数据进行识别
        byte[] data = Util.readFileByBytes(path);     //readFileByBytes仅为获取二进制数据示例
        JSONObject asrRes2 = client.asr(data, "pcm", 16000, null);
        System.out.println(asrRes2);
*/

    }
}
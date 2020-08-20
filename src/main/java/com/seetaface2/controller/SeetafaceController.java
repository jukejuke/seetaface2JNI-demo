package com.seetaface2.controller;

import com.cnsugar.ai.face.FaceHelper;
import com.cnsugar.ai.face.bean.Result;
import com.seetaface2.model.FaceLandmark;
import com.seetaface2.model.SeetaRect;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 人脸识别
 * @author Yaosh
 * @version 1.0
 * @commpany 星瑞国际
 * @date 2020/8/20 14:34
 * @return
 */
@RequestMapping("/seetaFace")
@RestController
public class SeetafaceController {

    @RequestMapping("/compare")
    public Map<String,Object> compare() throws IOException {
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("code",1);
        retMap.put("Message","Success");
        String img1 = "D:\\BaiduNetdiskDownload\\img\\pic04.jpg";
        String img2 = "D:\\BaiduNetdiskDownload\\img\\pic05.jpg";
        long l = System.currentTimeMillis();
        float result = FaceHelper.compare(new File(img1), new File(img2));
        long timeDiff = (System.currentTimeMillis() - l);
        retMap.put("timeDiff",timeDiff);
        retMap.put("result",result);
        return retMap;
    }

    /**
     * 初始化人脸库
     * @return
     */
    @RequestMapping("/init")
    public Map<String,Object> init(){
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("code",1);
        retMap.put("Message","初始化人脸库成功!");
        Collection<File> files = FileUtils.listFiles(new File("D:\\BaiduNetdiskDownload\\img"), new String[]{"jpg", "png"}, false);
        for (File file : files) {
            String key = file.getName();
            try {
                FaceHelper.register(key, FileUtils.readFileToByteArray(file));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return retMap;
    }

    @RequestMapping("/search")
    public Map<String,Object> search() throws IOException {
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("code",1);
        retMap.put("Message","Success");
        long l = System.currentTimeMillis();
        Result result = FaceHelper.search(FileUtils.readFileToByteArray(new File("D:\\BaiduNetdiskDownload\\test.jpg")));
        long timeDiff = (System.currentTimeMillis() - l);
        retMap.put("timeDiff",timeDiff);
        retMap.put("result",result);
        return retMap;
    }

    @RequestMapping("/detect")
    public Map<String,Object> detect() throws IOException {
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("code",1);
        retMap.put("Message","Success");
        long l = System.currentTimeMillis();
        SeetaRect[] seetaRects = FaceHelper.detect(FileUtils.readFileToByteArray(new File("D:\\BaiduNetdiskDownload\\img\\pic01.jpg")));
        long timeDiff = (System.currentTimeMillis() - l);
        retMap.put("timeDiff",timeDiff);
        retMap.put("seetaRects",seetaRects);
        return retMap;
    }

    @RequestMapping("/detectLandmark")
    public Map<String,Object> detectLandmark() throws IOException {
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("code",1);
        retMap.put("Message","Success");
        long l = System.currentTimeMillis();
        FaceLandmark faceLandmark = FaceHelper.detectLandmark(ImageIO.read(new File("D:\\BaiduNetdiskDownload\\img\\pic04.jpg")));
        long timeDiff = (System.currentTimeMillis() - l);
        retMap.put("timeDiff",timeDiff);
        retMap.put("faceLandmark",faceLandmark);
        return retMap;
    }

    /**
     * 清除人脸库
     * @return
     */
    @RequestMapping("/clear")
    public Map<String,Object> clear() throws IOException {
        Map<String,Object> retMap = new HashMap<String,Object>();
        retMap.put("code",1);
        retMap.put("Message","清除人脸库成功!");
        FaceHelper.clear();
        return retMap;
    }
}

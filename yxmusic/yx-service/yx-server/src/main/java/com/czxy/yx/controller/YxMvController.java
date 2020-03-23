package com.czxy.yx.controller;

import com.czxy.pojo.Classify;
import com.czxy.pojo.Yxmv;
import com.czxy.yx.service.YxMvService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/yx-mv")
public class YxMvController {

    @Resource
    YxMvService yxMvService;


    @PostMapping("/mv")
    public ResponseEntity<PageInfo<Yxmv>> getAllMV(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam("condition") String condition){

        System.out.println("zhixingle:");

       PageInfo<Yxmv> list = yxMvService.selectMvByPage(pageNum,condition);

        System.out.println(list);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/mv")
    public ResponseEntity<List<Classify>> getMvByIfy(){

       List<Classify> classifies = yxMvService.selectMvByIfy();

       return ResponseEntity.ok(classifies);
    }


}

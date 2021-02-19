package com.xiaoge.system.controller;

import com.xiaoge.response.Result;
import com.xiaoge.system.service.AliOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.CredentialException;

@Api
@RestController
@CrossOrigin
public class AliOssController {

    @Autowired
    private AliOssService aliOssService;

    @ApiOperation(value = "上传图片文件")
    @PostMapping("/uploadImgFile")
    public Result uploadImgFile(MultipartFile file){
        String upload = aliOssService.upload(file);
        return Result.ok().data("url",upload);
    }

    @ApiOperation(value = "删除替换之后的头像")
    @PostMapping("/deleteImgFile")
    public Result deleteImgFile(String file){
        try {
            String[] split = file.split(".com/");
            System.out.println(split[1]);
            aliOssService.deleteFile(split[1]);
            return Result.ok();
        }catch (Exception e){
            //需要打印错误日志到本地系统中(服务器系统)
            return Result.error();
        }
    }
}

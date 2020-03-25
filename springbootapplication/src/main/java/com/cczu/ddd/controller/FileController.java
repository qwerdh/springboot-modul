package com.cczu.ddd.controller;


import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


/**
 * @author ddd
 * @create 2020-03-25    20:09
 **/
@Controller
public class FileController {
    // 文件上传
    @RequestMapping("importExcel2.action")
    public String importExcel2(@RequestParam("file_excel") MultipartFile files, HttpServletRequest request) throws Exception{
        JSONObject rs = new JSONObject();
        int code = 200;
        //判断文件是否为空
        if(files.isEmpty()){
            rs.put("message","文件为空");
            return "redirect:/Tocpmquarterlybusinessdata.action";
        }

        //判断文件类型是否错误(xlsx/xls)
        if(files.getOriginalFilename().indexOf("xlsx")<0||files.getOriginalFilename().indexOf("xls")<0){
            rs.put("message","文件类型错误");
            return "redirect:/Tocpmquarterlybusinessdata.action";
        }
        // 获取文件保存地址
        String path = request.getSession().getServletContext().getRealPath("/")+files.getOriginalFilename();


        try{
            files.transferTo(new File(path)); //这里是上传文件
            // 这是删除上传的文件
            // new File(path).delete();
        }catch (IOException e) {

            e.printStackTrace();
            rs.put("message","文件读取错误");
        }
        File localFile = new File(path);
        // 这是删除上传的文件
        new File(path).delete();

        //这里的result就是整个excel的数据。根据需求自行确定校验规则及后续加数据库等操作
        return "redirect:/Tocpmquarterlybusinessdata.action";


    }
}

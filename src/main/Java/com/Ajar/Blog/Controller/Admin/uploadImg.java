package com.Ajar.Blog.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class uploadImg {

    //上传图片并返回图片路径(json格式)，接收的图片名和wangEditor定义的图片名保持一致MultipartFile
    @RequestMapping(value = "/Admin/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImg(@RequestParam("myFileName") MultipartFile myFileName, HttpSession session, HttpServletRequest request) throws IllegalStateException, IOException {
        String realName = "";
        String realPath = "";
        if (myFileName != null) {
            String fileName = myFileName.getOriginalFilename();
            String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length());
            // 生成实际存储的真实文件名

            realName = UUID.randomUUID().toString() + fileNameExtension;

            // "/upload"是你自己定义的上传目录

//			String realPath = session.getServletContext().getRealPath("/upload");
            realPath = session.getServletContext().getRealPath("/upload");


//			realPath = "E:\\work\\Java\\DMS\\WebContent\\upload";
            File uploadFile = new File(realPath, realName);
            myFileName.transferTo(uploadFile);
        }
//		String [] str = {request.getContextPath() + "/upload/" + realName};
//		String [] strPath = {realPath + "\\" + realName};
//		List<String> stringB = Arrays.asList(strPath);
//		List<Map<String, Object>> resultMap = new ArrayList<Map<String,Object>>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
//		String resultStr =  ResultUtil.success(strPath).toString();
        resultMap.put("url", request.getContextPath() + "/upload/" + realName); //【注意】这个配置本地路径前端无法加载
        return resultMap;
    }

}

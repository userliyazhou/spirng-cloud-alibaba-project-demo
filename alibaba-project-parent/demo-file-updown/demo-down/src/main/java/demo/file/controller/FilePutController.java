package demo.file.controller;

import demo.file.config.WebConfig;
import demo.file.utils.FileUploadUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@RestController
public class FilePutController {


    /**
     * 保存文件
     *
     * @param file 文件
     * @return 结果
     */
    @PutMapping("/updateFilePut")
    @ResponseBody
    public Object updateFile(@RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = FileUploadUtils.uploadText(WebConfig.getUploadPath(), file);
                System.out.println("fileName:" + fileName);
                // TODO: 此处可以根据项目需求的业务进行操作，例如将fileName保存到数据库
            }
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * 保存头像
     *
     * @param file 头像文件
     * @return 结果
     */
    @PutMapping("/updateAvatarPut")
    @ResponseBody
    public Object updateAvatar(@RequestParam("avatarfile") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String avatar = FileUploadUtils.uploadPicture(WebConfig.getAvatarPath(), file);
                System.out.println("avatar:" + avatar);
                // TODO: 此处可以根据项目需求的业务进行操作，例如此处操作的是头像，可以将头像url保存到数据库，用户登录后，获取相应的url获取头像图片。
            }
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
    /**
     * 查看文件
     *
     * @param url 图片url
     * @param response 请求响应
     */
    @RequestMapping(value = "/noLogin/readImageFilePut",method = RequestMethod.GET)
    @ResponseBody
    public void getUrlFile(String url, HttpServletResponse response) {
        // 这里的url，我为了测试，直接就写静态的。
        url = "D:/profile/avatar/2019/05/20/d025ba6f937f59999a021989a12a1aab.jpg";
        File file = new File(url);
        // 后缀名
        String suffixName = url.substring(url.lastIndexOf("."));
        //判断文件是否存在如果不存在就返回默认图片或者进行异常处理
        if (!(file.exists() && file.canRead())) {
//            file = new File("xxx/xxx.jpg");
            System.out.println("文件不存在");
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            inputStream.close();
            response.setContentType("image/png;charset=utf-8");
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/noLogin/readFileToStringPut",method = RequestMethod.GET)
    @ResponseBody
    public String getUrlFile(String url, HttpServletRequest request, HttpServletResponse response) {
//        url = "D:/profile/upload/2019/05/20/01017f12b88d9f4e79dc38060e3883da.txt";

        // 通过url创建文件
        File file = new File(url);
        // 后缀名
        String suffixName = url.substring(url.lastIndexOf("."));

        //判断文件是否存在如果不存在就进行异常处理
        if (!(file.exists() && file.canRead())) {
            System.out.println("文件不存在");
        }

        FileInputStream inputStream = null;
        String content = "";
        try {
            inputStream = new FileInputStream(file);
            inputStream.close();
            // 使用FileUtils将File内容以UTF-8的编码写到String里
            content = FileUtils.readFileToString(file, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    /**
     * 下载文件
     *
     * @param url 文件url
     * @param response 请求响应
     */
    @RequestMapping(value = "/noLogin/downloadFilePut",method =RequestMethod.GET)
    @ResponseBody
    public void getUrlDownload(String url, HttpServletResponse response) {
        url = "D:/profile/avatar/2019/05/20/d025ba6f937f59999a021989a12a1aab.jpg";
        File file = new File(url);
        // 后缀名
        String suffixName = url.substring(url.lastIndexOf("."));
        //判断文件是否存在如果不存在就进行异常处理
        if (!(file.exists() && file.canRead())) {
            System.out.println("文件不存在");
        }
        FileInputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            int length = inputStream.read(data);
            inputStream.close();
            response.setContentType("application/force-download");
            //通过设置头信息给文件命名，也即是，在前端，文件流被接受完还原成原文件的时候会以你传递的文件名来命名
            response.addHeader("Content-Disposition",String.format("attachment; filename=\"%s\"", file.getName()));
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

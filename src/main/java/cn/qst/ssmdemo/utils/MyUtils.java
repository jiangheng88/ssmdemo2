package cn.qst.ssmdemo.utils;


import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.PublicKey;

/**
 * @author jiangheng
 * @date 2019/9/20 14:41
 * @description 整个项目用到的工具类
 */
public class MyUtils {

    /**
     * @param multipartFile      文件流对象
     * @param object             实体类对象
     * @param serverFileSavePath 保存文件的路径
     * @param fileNamePrefix     保存文件名的前缀
     */
    public static void singleFileUpload(MultipartFile multipartFile, Object object, String serverFileSavePath, String fileNamePrefix) {
        // 将文件对象 multipartFile中的文件流上传到服务器
        // 获取文件的服务器的保存路径
        System.out.println("basepath:" + System.getProperty("server.basePath"));
        // 当前项目在web服务器上的部署的绝对路径//
        String serverBasePath = System.getProperty("server.basePath");
        // 设置服务器的保存文件的路径名
        //String serverFileSavePath = "uploadfiles/userimgfiles/";
        // 完整的服务器保存路径为 serverBasePath+ serverFileSavePath
        String serverSavePath = serverBasePath + serverFileSavePath;
        // 验证服务器是否已经创建了该目录
        File fileSave = new File(serverSavePath);
        // 判断保存路径文件对象是否存在
        if (!fileSave.exists()) {
            // 创建该目录
            fileSave.mkdirs();
        }
        // 文件需要在服务器上进行重命名，然后进行保存
        // 命名规则： 前缀+系统时间毫秒数+文件后缀
        // 获取文件类型
        String fileContentType = multipartFile.getContentType();
        // 获取文件后缀
        String fileType = fileContentType.substring(fileContentType.indexOf("/") + 1);
        // 文件名前缀
        //String fileNamePrefix = "userimg";
        // 生成新的文件名
        String fileNewName = fileNamePrefix + System.currentTimeMillis() + "." + fileType;
        System.out.println("新文件名：" + fileNewName);
        // 将文件流写出到服务器保存路径
        try {
            multipartFile.transferTo(new File(serverSavePath + fileNewName));
        } catch (IOException e) {
            System.out.println("文件上传异常：" + e.getMessage());
            e.printStackTrace();
        }
        // 需要保存的文件的访问路径
        String fileRelativePath = serverFileSavePath + fileNewName;
        System.out.println("文件的访问路径：" + fileRelativePath);
        // 将文件对象的访问路径映射给实体类对象的成员属性上
        // 使用反射，将设置属性的方法具有通用性
        // 提取需要保存的属性名
        //multipartFile.getName() 返回的是表单中文件流的name中的值
        String propertyName = multipartFile.getName().replace("file_", "");
        try {
            //功能是给customer的propertyName这个变量代表的属性赋值，赋值的是fileRelativePath，这里使用了反射，
            // BeanUtils这个工具类封装了反射，可以直接使用
            BeanUtils.setProperty(object, propertyName, fileRelativePath);
        } catch (Exception e) {
            System.out.println("文件上传异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /*public static void singleFileupload(Object object){
        //文件保存的路径
        String path = "G:\\temps";
        //定义保存文件的位置的数据库列名
        String sqlPath = null;
        //定义上传文件的原始名
        String fileName = null;
        if (object != null) {
            //得到上传的文件
            MultipartFile multipartFile = object.getMultipartFile();
            if (!multipartFile.isEmpty()) {//如果文件不为空
                //文件的名字
                fileName = multipartFile.getOriginalFilename();
                //创建文件
                File filePath = new File(path, fileName);
                if (!filePath.getParentFile().exists()) {//如果父文件夹不存在
                    //注意mkdirs()和mkdir()的区别，mkdirs()他可以直接创建文件夹，不管父文件夹是否存在，
                    //mkdir()创建文件夹时，父文件夹一定的存在
                    filePath.getParentFile().mkdirs();
                }
                //文件在硬盘中的位置
                sqlPath = path + File.separator + fileName;
                System.out.println(sqlPath);
                try {
                    //将文件上传到指定位置
                    multipartFile.transferTo(new File(sqlPath));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }*/
}

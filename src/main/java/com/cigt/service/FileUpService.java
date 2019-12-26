package com.cigt.service;

import com.cigt.base.R;
import com.cigt.my_util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 上传事务层
 */
@Service
@Slf4j
@Transactional
public class FileUpService {

    private static final String IMAGE_PATH="CIGTimages";

    @Autowired
    private FileUtils fileUtils;

    @Value("${image.ImagePath}")
    private String ImagePath;

    /**
     *
     * @param file 文件
     * @return
     */
    public R upload(MultipartFile file,int type){

        if (file.isEmpty()) {
            // 设置错误状态码
            return R.error("上传失败");
        }
        // 拿到文件名
        String fileName = file.getOriginalFilename();

        //判断是哪种类型的图片
        String imagePath = getImagePath(type);

        //指定文件夹
        String path = ImagePath+imagePath;

        // 生成新的文件名
        String newName = fileUtils.getFileName(fileName);

        // 新的路径
        String filePath = path+"/"+newName;

        File dest = new File(filePath);
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            file.transferTo(dest);
            //返回文件名
            return R.ok("/"+IMAGE_PATH+"/"+imagePath+"/"+newName);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            log.error("环境问题"+e);
            return R.error();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            log.error("读写文件出错"+e);
            return R.error("文件存取出错");
        }

    }

    private String getImagePath(int type) {
        switch (type) {
            case 1:
                return "/userImage";
            case 2:
                return "/goodsImage";
            default:
                return "/unkonwType";
        }
    }
}

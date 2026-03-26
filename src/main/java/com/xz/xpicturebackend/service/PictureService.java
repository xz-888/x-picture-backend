package com.xz.xpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xz.xpicturebackend.model.dto.picture.PictureQueryRequest;
import com.xz.xpicturebackend.model.dto.picture.PictureUploadRequest;
import com.xz.xpicturebackend.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xz.xpicturebackend.model.entity.User;
import com.xz.xpicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2026-03-14 21:30:57
*/
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return uploadPicture
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);


    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);
}


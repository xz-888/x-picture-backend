package com.xz.xpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xz.xpicturebackend.model.dto.picture.PictureQueryRequest;
import com.xz.xpicturebackend.model.dto.picture.PictureReviewRequest;
import com.xz.xpicturebackend.model.dto.picture.PictureUploadByBatchRequest;
import com.xz.xpicturebackend.model.dto.picture.PictureUploadRequest;
import com.xz.xpicturebackend.model.entity.Picture;
import com.xz.xpicturebackend.model.entity.User;
import com.xz.xpicturebackend.model.vo.PictureVO;

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
     * @param inputSource object
     * @param pictureUploadRequest 图片上传请求
     * @param loginUser 登录用户
     * @return uploadPicture
     */
    PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);


    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest 批量抓图请求
     * @param loginUser 登录用户
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(
            PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser
    );



    void fillReviewParams(Picture picture, User loginUser);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);


    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);


    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);
}


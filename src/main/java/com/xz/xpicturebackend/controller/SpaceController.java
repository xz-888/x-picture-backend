package com.xz.xpicturebackend.controller;

import com.xz.xpicturebackend.annotation.AuthCheck;
import com.xz.xpicturebackend.common.BaseResponse;
import com.xz.xpicturebackend.common.ResultUtils;
import com.xz.xpicturebackend.constant.UserConstant;
import com.xz.xpicturebackend.exception.BusinessException;
import com.xz.xpicturebackend.exception.ErrorCode;
import com.xz.xpicturebackend.exception.ThrowUtils;
import com.xz.xpicturebackend.model.dto.space.SpaceUpdateRequest;
import com.xz.xpicturebackend.model.entity.Space;
import com.xz.xpicturebackend.service.SpaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/space")
public class SpaceController {

    @Resource
    private SpaceService spaceService;



    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateSpace(@RequestBody SpaceUpdateRequest spaceUpdateRequest) {
        if (spaceUpdateRequest == null || spaceUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 将实体类和 DTO 进行转换
        Space space = new Space();
        BeanUtils.copyProperties(spaceUpdateRequest, space);
        // 自动填充数据
        spaceService.fillSpaceBySpaceLevel(space);
        // 数据校验
        spaceService.validSpace(space, false);
        // 判断是否存在
        long id = spaceUpdateRequest.getId();
        Space oldSpace = spaceService.getById(id);
        ThrowUtils.throwIf(oldSpace == null, ErrorCode.NOT_FOUND_ERROR);
        // 操作数据库
        boolean result = spaceService.updateById(space);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(true);
    }



}

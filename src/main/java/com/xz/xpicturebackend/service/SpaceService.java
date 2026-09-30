package com.xz.xpicturebackend.service;

import com.xz.xpicturebackend.model.dto.space.SpaceAddRequest;
import com.xz.xpicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xz.xpicturebackend.model.entity.User;

/**
* @author Windows11
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2026-07-26 20:15:49
*/
public interface SpaceService extends IService<Space> {

    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);
}

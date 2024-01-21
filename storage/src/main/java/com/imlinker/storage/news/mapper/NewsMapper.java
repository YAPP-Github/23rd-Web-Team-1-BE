package com.imlinker.storage.news.mapper;

import com.imlinker.domain.common.URL;
import com.imlinker.domain.news.News;
import com.imlinker.storage.news.NewsEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NewsMapper {
    public static News toModel(NewsEntity entity){
        return News.builder()
                .id(entity.getId())
                .tagId(entity.getTagId())
                .title(entity.getTitle())
                .thumbnailImgUrl(URL.of(entity.getThumbnailImgUrl()))
                .company(entity.getCompany())
                .build();
    }

    public static NewsEntity toEntity(News model) {
        return NewsEntity.builder()
                .id(model.getId())
                .tagId(model.getTagId())
                .title(model.getTitle())
                .thumbnailImgUrl(model.getThumbnailImgUrl().getValue())
                .company(model.getCompany())
                .build();
    }
}

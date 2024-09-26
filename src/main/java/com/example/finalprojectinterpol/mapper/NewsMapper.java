package com.example.finalprojectinterpol.mapper;

import com.example.finalprojectinterpol.dto.news.NewsCreateDTO;
import com.example.finalprojectinterpol.dto.news.NewsDTO;
import com.example.finalprojectinterpol.entities.News;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface NewsMapper {
    News toEntity (NewsCreateDTO newsCreateDTO);
    NewsDTO toDTO(News news);
    List<NewsDTO> toDTOList(List<News> news);
}

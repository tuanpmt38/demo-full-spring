package com.example.demo.service.impl;

import com.example.demo.dto.NewDto;
import com.example.demo.dto.NewEditDto;
import com.example.demo.entity.News;
import com.example.demo.handler.BizException;
import com.example.demo.handler2.BIZException;
import com.example.demo.repository.NewRepository;
import com.example.demo.service.NewService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewServiceImpl implements NewService {

  @Autowired
  private NewRepository repository;

  @Override
  public List<News> getAll() {
    return repository.findAll();
  }

  @Override
  public News findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new BizException().buildException(Arrays.asList("data.not-found")));
  }

  @Override
  public News save(NewDto newDto) {

    News news = News.builder().content(newDto.getContent())
        .imageUrl(newDto.getImageUrl()).build();
    return repository.save(news);

  }

  @Override
  public News update(NewEditDto newEditDto) {

    News news = repository.findById(newEditDto.getId())
        .orElseThrow(() -> new BIZException()
            .buildResourceNotFoundException("data.not-found"));

    news.setContent(newEditDto.getContent());
    news.setImageUrl(newEditDto.getImageUrl());

    return repository.save(news);

  }
}

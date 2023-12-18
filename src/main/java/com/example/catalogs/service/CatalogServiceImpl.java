package com.example.catalogs.service;

import com.example.catalogs.jpa.CatalogEntity;
import com.example.catalogs.jpa.CatalogRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService{
    private final CatalogRepository catalogRepository;

    @Override
    public Iterable<CatalogEntity> getAllcatalogs() {
        return catalogRepository.findAll();
    }
}

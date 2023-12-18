package com.example.catalogs.controller;

import com.example.catalogs.jpa.CatalogEntity;
import com.example.catalogs.service.CatalogService;
import com.example.catalogs.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {
    private final Environment env;
    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's working in Catalog service on PORT %s",  env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs(){
        Iterable<CatalogEntity> catalog = catalogService.getAllcatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        catalog.forEach(v->{
            result.add(new ModelMapper().map(v, ResponseCatalog.class));
        });

        return  ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

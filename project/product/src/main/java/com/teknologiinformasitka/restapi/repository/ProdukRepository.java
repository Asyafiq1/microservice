package com.teknologiinformasitka.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasitka.restapi.model.Produk;


@Repository
public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
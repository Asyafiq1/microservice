package com.teknologiinformasitka.restapi.order.model;

// @Entity
// @Table(name = "produk")
public class Produk {


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   private String nama;
   private Double harga;
   private String deskripsi;


   // Constructor tanpa parameter
   public Produk() {}


   // Constructor dengan parameter
   public Produk(String nama, Double harga, String deskripsi) {
       this.nama = nama;
       this.harga = harga;
       this.deskripsi = deskripsi;
   }


   // Getters dan Setters
   public Long getId() {
       return id;
   }


   public void setId(Long id) {
       this.id = id;
   }


   public String getNama() {
       return nama;
   }


   public void setNama(String nama) {
       this.nama = nama;
   }


   public Double getHarga() {
       return harga;
   }


   public void setHarga(Double harga) {
       this.harga = harga;
   }


   public String getDeskripsi() {
       return deskripsi;
   }


   public void setDeskripsi(String deskripsi) {
       this.deskripsi = deskripsi;
   }
}

// package com.teknologiinformasitka.restapi.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.teknologiinformasitka.restapi.model.Produk;
// import com.teknologiinformasitka.restapi.service.ProdukService;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;


// @RestController
// @RequestMapping("/api/produk")
// public class ProdukController {


//    @Autowired
//    private ProdukService produkService;


//    // Endpoint untuk mengambil semua produk
//    @GetMapping
//    public List<Produk> getAllProduk() {
//        return produkService.getAllProduk();
//    }


//    // Endpoint untuk mengambil produk berdasarkan id
//    @GetMapping("/{id}")
//    public ResponseEntity<Produk> getProdukById(@PathVariable Long id) {
//        return produkService.getProdukById(id)
//                .map(produk -> ResponseEntity.ok().body(produk))
//                .orElse(ResponseEntity.notFound().build());
//    }


//    // Endpoint untuk membuat produk baru
//    @PostMapping
//    public Produk createProduk(@RequestBody Produk produk) {
//        return produkService.createProduk(produk);
//    }


//    // Endpoint untuk mengupdate produk yang sudah ada
//    @PutMapping("/{id}")
//    public ResponseEntity<Produk> updateProduk(@PathVariable Long id, @RequestBody Produk produkDetails) {
//        try {
//            Produk updatedProduk = produkService.updateProduk(id, produkDetails);
//            return ResponseEntity.ok(updatedProduk);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }


//    // Endpoint untuk menghapus produk
//   @DeleteMapping("/{id}")
// public ResponseEntity<Map<String, String>> deleteProduk(@PathVariable Long id) {
//    try {
//        produkService.deleteProduk(id);
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Produk berhasil dihapus");
//        return ResponseEntity.ok(response);
//    } catch (RuntimeException e) {
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "Produk tidak ditemukan dengan id " + id);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//    }
// }
// }

package com.teknologiinformasitka.restapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.teknologiinformasitka.restapi.model.Produk;
import com.teknologiinformasitka.restapi.service.ProdukService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@RestController
@RequestMapping("/api/produk")
public class ProdukController {


    private static final Logger log = LoggerFactory.getLogger(ProdukController.class);


   @Autowired
   private ProdukService produkService;




   // Endpoint untuk mengambil semua produk
   @GetMapping
   public List<Produk> getAllProduk() {
    log.info("GET /api/produk accessed");
       return produkService.getAllProduk();
   }




   // Endpoint untuk mengambil produk berdasarkan id
   @GetMapping("/{id}")
   public ResponseEntity<Produk> getProdukById(@PathVariable Long id) {
    log.info("GET /api/produk/{} accessed", id);
       return produkService.getProdukById(id)
               .map(produk -> ResponseEntity.ok().body(produk))
               .orElse(ResponseEntity.notFound().build());
   }




   // Endpoint untuk membuat produk baru
   @PostMapping
   public Produk createProduk(@RequestBody Produk produk) {
    log.info("POST /api/produk accessed with body: {}", produk);
       return produkService.createProduk(produk);
   }




   // Endpoint untuk mengupdate produk yang sudah ada
   @PutMapping("/{id}")
   public ResponseEntity<Produk> updateProduk(@PathVariable Long id, @RequestBody Produk produkDetails) {
    log.info("PUT /api/produk/{} accessed with body: {}", id, produkDetails);
          
    try {
           Produk updatedProduk = produkService.updateProduk(id, produkDetails);
           return ResponseEntity.ok(updatedProduk);
       } catch (RuntimeException e) {
        log.warn("PUT /api/produk/{} failed: {}", id, e.getMessage());
           return ResponseEntity.notFound().build();
       }
   }




//     Endpoint untuk menghapus produk
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProduk(@PathVariable Long id) {
        log.info("DELETE /api/produk/{} accessed", id);
        Map<String, String> response = new HashMap<>();
        try {
            produkService.deleteProduk(id);
            response.put("message", "Produk berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Produk tidak ditemukan dengan id " + id);
            log.warn("DELETE /api/produk/{} failed: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

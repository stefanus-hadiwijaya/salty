package com.task.salty.controller.api;

import com.task.salty.model.Konsumen;
import com.task.salty.service.api.KonsumenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/konsumen")
public class KonsumenApiController {
    @Autowired
    KonsumenApiService konsumenApiService;

    @GetMapping("/")
    public ResponseEntity<List<Konsumen>> getAll(@RequestParam(required = false) String nama,
                                                 @RequestParam(required = false) String alamat,
                                                 @RequestParam(required = false) String kota,
                                                 @RequestParam(required = false) String provinsi,
                                                 @RequestParam(required = false) String status,
                                                 @RequestParam(value = "tgl_registrasi", required = false) String tglRegistrasi) {
        List<Konsumen> konsumenList = konsumenApiService.getAllKonsumen(nama, alamat, kota, provinsi, tglRegistrasi, status);
        return ResponseEntity.status(HttpStatus.OK).body(konsumenList);
    }

    @PostMapping("/")
    public ResponseEntity<String> create(@RequestBody Konsumen konsumen) {
        if (konsumenApiService.saveKonsumen(konsumen) == 1) {
            return ResponseEntity.status(HttpStatus.OK).body("Success save new konsumen.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Failed to save konsumen!");
        }
    }

    @GetMapping("/seed")
    public ResponseEntity<String> seed() {
        konsumenApiService.seed();
        return ResponseEntity.status(HttpStatus.OK).body("Seed data has been inserted");
    }
}

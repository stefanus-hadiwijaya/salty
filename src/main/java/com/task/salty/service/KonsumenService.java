package com.task.salty.service;

import com.task.salty.model.Konsumen;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class KonsumenService {

    public String saveKonsumen(Konsumen konsumen, BindingResult result) {
        // validation
        if (konsumen.getNama().trim().isEmpty() || konsumen.getNama() == null) {
            result.addError(new FieldError("konsumen", "nama", "*Nama tidak boleh kosong"));
        }
        if (konsumen.getAlamat().trim().isEmpty() || konsumen.getAlamat() == null) {
            result.addError(new FieldError("konsumen", "alamat", "*Alamat tidak boleh kosong"));
        }
        if (konsumen.getKota().trim().isEmpty() || konsumen.getKota() == null) {
            result.addError(new FieldError("konsumen", "kota", "*Kota tidak boleh kosong"));
        }
        if (konsumen.getProvinsi().trim().isEmpty() || konsumen.getProvinsi() == null) {
            result.addError(new FieldError("konsumen", "provinsi", "*Provinsi tidak boleh kosong"));
        }
        if (result.hasErrors()) {
            return "add-konsumen";
        }
        konsumen.setTglRegistrasi(new Date());

        final String uri = "http://localhost:8080/api/konsumen/";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(uri, konsumen, String.class);
        System.out.println(response);
        return "redirect:/";
    }
}

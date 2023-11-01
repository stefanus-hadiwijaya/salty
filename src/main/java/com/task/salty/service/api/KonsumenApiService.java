package com.task.salty.service.api;

import com.task.salty.model.Konsumen;
import com.task.salty.repository.KonsumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class KonsumenApiService {

    @Autowired
    KonsumenRepository konsumenRepository;

    public int saveKonsumen(Konsumen konsumen) {
        return konsumenRepository.saveData(konsumen);
    }

    public List<Konsumen> getAllKonsumen() {
        return konsumenRepository.findAll("");
    }

    public List<Konsumen> getAllKonsumen(String nama, String alamat, String kota, String provinsi, String tglRegistrasi, String status) {
        String conditions = " WHERE";
        int counter = 0;

        if (nama != null && !nama.trim().isEmpty()) {
            conditions = conditions + " nama ILIKE '%" + nama.trim() + "%'";
            counter++;
        }
        if (alamat != null && !alamat.trim().isEmpty()) {
            conditions = checkCondition(counter, conditions) + " alamat ILIKE '%" + alamat.trim() + "%'";
            counter++;
        }
        if (kota != null && !kota.trim().isEmpty()) {
            conditions = checkCondition(counter, conditions) + " kota ILIKE '%" + kota.trim() + "%'";
            counter++;
        }
        if (provinsi != null && !provinsi.trim().isEmpty()) {
            conditions = checkCondition(counter, conditions) + " provinsi ILIKE '%" + provinsi.trim() + "%'";
            counter++;
        }
        if (tglRegistrasi != null && !tglRegistrasi.trim().isEmpty()) {
            conditions = checkCondition(counter, conditions) + " tgl_registrasi = '" + tglRegistrasi.trim() + "'";
            counter++;
        }
        if (status != null && !status.trim().isEmpty()) {
            conditions = checkCondition(counter, conditions) + " status ILIKE '%" + status.trim() + "%'";
            counter++;
        }
        if (counter == 0) {
            conditions = "";
        }
        return konsumenRepository.findAll(conditions);
    }

    public String checkCondition(int counter, String condition) {
        if (counter > 0) {
            condition = condition + " AND";
        }
        return condition;
    }

    public void seed() {
        if (getAllKonsumen().size() == 0) {
            List<Konsumen> listKonsumen = new ArrayList<>();
            listKonsumen.add(new Konsumen("Arlong", "jl Sudirman", "Bandung", "Jawa Barat", new Date(), "aktif"));
            listKonsumen.add(new Konsumen("Boni", "jl Moh Toha", "Jakarta", "Jawa Barat", new Date(), "aktif"));
            listKonsumen.add(new Konsumen("Cory", "jl Kartini", "Cirebon", "Jawa Barat", new Date(), "non-aktif"));

            for (Konsumen k : listKonsumen) {
                konsumenRepository.saveData(k);
            }
        }
    }
}

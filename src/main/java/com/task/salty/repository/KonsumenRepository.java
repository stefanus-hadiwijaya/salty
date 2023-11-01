package com.task.salty.repository;

import com.task.salty.model.Konsumen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KonsumenRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Konsumen> findAll(String conditions) {
        String query = "SELECT * from konsumen" + conditions;
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Konsumen.class));
    }

    public int saveData(Konsumen konsumen) {
        return jdbcTemplate.update("INSERT INTO konsumen (nama, alamat, kota, provinsi, tgl_registrasi, status) VALUES(?,?,?,?,?,?)",
                new Object[]{konsumen.getNama().trim(), konsumen.getAlamat().trim(), konsumen.getKota().trim(), konsumen.getProvinsi().trim(),
                konsumen.getTglRegistrasi(), konsumen.getStatus().trim()});
    }

}

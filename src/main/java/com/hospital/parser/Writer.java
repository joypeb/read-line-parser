package com.hospital.parser;

import com.hospital.Hospital;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Writer {
    public void writeSQL(List<Hospital> hospital) {
        List<Hospital> hospitals = hospital;

        try {
            File file2 = new File("./Files/seoul-hospitals2.sql");
            int cnt = 1;

            if (!file2.exists()) { // 파일이 존재하지 않으면
                file2.createNewFile(); // 신규생성
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));

            writer.append(hospitals.get(0).getSqlQuery());

            for (Hospital hos : hospitals) {
                writer.append(hos.getSqlQueryValue());

                //마지막 쉼표 체크용
                if (cnt != hospitals.size()) {
                    writer.append(",\n");
                }
                cnt++;
            }
            writer.append(";");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

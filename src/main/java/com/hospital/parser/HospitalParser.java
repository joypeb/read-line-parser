package com.hospital.parser;

import com.hospital.Hospital;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class HospitalParser implements Parser<Hospital>{
    @Override
    public Hospital parse(String str) {
        String replaceStr = str.replaceAll("\'", "\\\\'");
        String[] splitted = replaceStr.split(",");

        return new Hospital("\'"+splitted[0]+"\'","\'"+splitted[1]+"\'","\'"+divideDistrict(splitted[1])+"\'","\'"+splitted[2]+"\'",
                Integer.parseInt(splitted[6]),"\'"+splitted[10]+"\'",searchDivision(splitted[10]));
    }


    public int changeInt(String str) {
        return Integer.parseInt(str.replaceAll("\'",""));
    }

    public String divideDistrict(String addr) {
        String[] divideAddr = addr.split(" ");
        return divideAddr[0] + " " + divideAddr[1];
    }

    public String searchDivision(String name) {
        String[] department = {"신경","산부","소아","정형","성형","피부","이비인후","안과","신경정신","흉부","응급","치과","한의원"};
        for(int i=0; i<department.length; i++) {
            if(name.contains(department[i])) {
                return "\'" + department[i] + "\'";
            }
        }
        return null;
    }

    public void writeSQL(List<Hospital> hospital) {
        List<Hospital> hospitals = hospital;
        File file = new File("./Files/seoul-hospitals.sql");
        int cnt = 1;

        try {
            if (!file.exists()) { // 파일이 존재하지 않으면
                file.createNewFile(); // 신규생성
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            String insert = String.format("INSERT INTO `likelionDB`.`seoul_hospital`\n" +
                    "(`id`," + "`address`," + "`district`," + "`category`," + "`emergency_room`," + "`name`," + "`subdivision`)\n" +
                    "VALUES\n");
            String values;
            writer.append(insert);

            for (Hospital hos : hospitals) {
                values = String.format("(" + hos.getId() + "," + hos.getAddress() + "," + hos.getDistrict() + "," + hos.getCategory()
                        + "," + hos.getEmergencyRoom() + "," + hos.getName() + "," + hos.getSubdivision() + ")");
                writer.append(values);

                if (cnt != hospitals.size()) {
                    writer.append(",\n");
                }
                cnt++;
            }
            writer.append(";");
            writer.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

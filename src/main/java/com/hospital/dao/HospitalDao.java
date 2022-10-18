package com.hospital.dao;

import com.hospital.Hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class HospitalDao {
    public void add(List<Hospital> hospital) {
        ConnectionMaker connectionMaker = new ConnectionMaker();

        try{
            Connection conn = connectionMaker.makeConnection();

            String sql = "INSERT INTO `likelionDB`.`seoul_hospital2` (`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(sql);

            for(Hospital h : hospital) {
                st.setString(1, h.getId());
                st.setString(2, h.getAddress());
                st.setString(3, h.getDistrict());
                st.setString(4,h.getCategory());
                st.setInt(5,h.getEmergencyRoom());
                st.setString(6,h.getName());
                st.setString(7,h.getSubdivision());
                st.addBatch();
                st.clearParameters();
            }

            st.executeBatch();
            st.clearParameters();
            System.out.printf("INSERT성공");

            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
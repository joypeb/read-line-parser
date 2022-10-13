package com.hospital;

import com.hospital.parser.HospitalParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        String filename = "./Files/hospitals-info.csv";
        List<Hospital> hospitals = hospitalLineReader.readLine(filename);

        HospitalParser hp = new HospitalParser();
        hp.writeSQL(hospitals);
    }
}
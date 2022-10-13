package com.hospital;


import com.hospital.parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {
    Parser<T> parser;
    boolean isRemoveColumnName = true;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    List<T> readLine(String filename) {
        List<T> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String str;

            if(isRemoveColumnName) {
                br.readLine();
            }

            while ((str = br.readLine()) != null) {
                result.add(parser.parse(str));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

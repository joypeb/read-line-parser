package com.hospital.parser;

public interface Parser<T> {
    T parse(String str); //T가 어떤파일을 파싱하냐에 따라 바뀌기 때문에 T로 설정 ex)인구조사, 병원,,,
}

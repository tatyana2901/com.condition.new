package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondService {
    List<String> list = new ArrayList<>();

    public void add(String t1, String t2, String operation) {
        list.add("t1 = " + t1 + "; t2 = " + t2 + "; operation = " + operation);
    }

    public List<String> getList() {
        return list;
    }
}

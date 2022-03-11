package com.solution.model;

import lombok.Getter;

import java.util.List;

@Getter
public class JsonContent {

    private int page;

    private int per_page;

    private int total;

    private List<Task> data;
}

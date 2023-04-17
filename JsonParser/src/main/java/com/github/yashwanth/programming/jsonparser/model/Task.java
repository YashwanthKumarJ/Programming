package com.github.yashwanth.programming.jsonparser.model;

import lombok.Getter;

@Getter
public class Task {

    private int task_id;

    private String task_name;

    private long timestamp;

    private TaskStatus status;

    private float priority;
}

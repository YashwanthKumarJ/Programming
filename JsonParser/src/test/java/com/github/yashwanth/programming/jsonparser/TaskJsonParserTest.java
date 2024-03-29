/*
  Unit testing TasKJsonParser

  @author Yashwanth
 */
package com.github.yashwanth.programming.jsonparser;


import com.github.yashwanth.programming.jsonparser.model.Task;
import com.github.yashwanth.programming.jsonparser.model.TaskStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Unit testing of TasKJsonParser")
public class TaskJsonParserTest {

    private TaskJsonParser taskJsonParser;

    @BeforeEach
    public void setUpStreams() {
        taskJsonParser = new TaskJsonParser();
    }

    @Test
    public void shouldReturnEmptyListForEmptyStatus() {
        List<Task> task = taskJsonParser.getDataByStatus("");
        assertEquals(0, task.size());
    }

    @Test
    public void shouldReturnCorrectTaskForTheStatus() {
        List<Task> task = taskJsonParser.getDataByStatus("ACTIVE");
        assertEquals(1, task.size());
        Assertions.assertEquals(TaskStatus.ACTIVE, task.get(0).getStatus());
    }

    @Test
    public void shouldNotFailForNullStatus() {
        List<Task> task = taskJsonParser.getDataByStatus(null);
        assertEquals(0, task.size());
    }
}

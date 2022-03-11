/*
  This program tries to parse a JSON file (present in resource folder) with name task.json.
  The json file contains query output of the db which contains task list.
  The program should provide a method/API to get tasks based on the task status

  @author Yashwanth
 */
package com.solution;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.solution.model.JsonContent;
import com.solution.model.Task;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaskJsonParser {

    private static final Type CONTENT_TYPE = new TypeToken<JsonContent>() {
    }.getType();
    private final Gson gson = new Gson();
    private List<Task> data;

    public TaskJsonParser() {
        init();
    }

    private void init() {
        try (Reader reader = new InputStreamReader(Objects.requireNonNull(TaskJsonParser.class.getResourceAsStream("/task.json")))) {
            JsonContent jsonContent = gson.fromJson(reader, CONTENT_TYPE);
            data = jsonContent.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Task> getDataByStatus(String status) {
        return data.stream()
                .filter((r) -> r.getStatus().name().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}

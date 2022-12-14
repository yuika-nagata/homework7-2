package com.example.task7;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class Task7Controller {

    @GetMapping("/name")
    public ResponseEntity<Map<String, String>> getUser(@RequestParam(value = "name") String name, @RequestParam @Pattern(regexp = "(0[1-9]|1[0-2])(0[1-9]|1\\d|2\\d|3[0-1])$") String birthday) {

        return ResponseEntity.ok(Map.of("name", name, "birthday", birthday));
    }

    @PostMapping("/names")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated CreateForm form,UriComponentsBuilder uriBuilder) {
        URI url = uriBuilder
                .path("/name/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody @Validated UpdateForm from) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully delete"));
    }
}

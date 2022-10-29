package com.example.task7;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CreateForm {
    @NotBlank
    @Length(max = 20)
    private String name;
    @NotBlank
    @Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$")
    private String birthday;

    public String getName() {
        return name;

    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

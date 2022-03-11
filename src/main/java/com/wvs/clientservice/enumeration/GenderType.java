package com.wvs.clientservice.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderType {

    MALE("Male", "M"),
    FEMALE("Female", "F"),
    NONE("None", "N");

    private String description;
    private String initial;

}

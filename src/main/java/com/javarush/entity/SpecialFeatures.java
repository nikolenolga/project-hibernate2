package com.javarush.entity;

import lombok.Getter;

import java.util.Arrays;

import static java.util.Objects.isNull;

@Getter
public enum SpecialFeatures {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    SpecialFeatures(String value) {
        this.value = value;
    }

    public static SpecialFeatures getByValue(String value) {
        if (isNull(value) || value.isEmpty()) {
            return null;
        }
        return Arrays.stream(SpecialFeatures.values())
                .filter(feature -> feature.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}

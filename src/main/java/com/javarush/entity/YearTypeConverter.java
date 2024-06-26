package com.javarush.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.Year;


@Converter(autoApply = true)
public class YearTypeConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year year) {
        return year == null
                ? null
                : (short) year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Short dbData) {
        return dbData == null
                ? null
                : Year.of(dbData);
    }
}
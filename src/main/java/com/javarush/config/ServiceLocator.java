package com.javarush.config;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ServiceLocator {
    private static Map<Class<?>, Object> services = new HashMap<>();

    @SneakyThrows
    public static <T> T getService(Class<T> clazz) {
        Object service = services.get(clazz);
        if (service == null) {
            Constructor<?> constructor = clazz.getConstructors()[0];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameters = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                parameters[i] = ServiceLocator.getService(parameterTypes[i]);
            }
            Object newInstance = constructor.newInstance(parameters);
            services.put(clazz, newInstance);
        }

        return (T) services.get(clazz);
    }
}

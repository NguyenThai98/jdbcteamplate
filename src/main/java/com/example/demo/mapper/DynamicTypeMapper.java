package com.example.demo.mapper;

import com.example.demo.anotation.TypeJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.jdbc.core.RowMapper;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Date: 5/12/2023<br/>
 * Time: 9:48 AM<br/>
 */
public class DynamicTypeMapper<T> implements RowMapper<T> {

    private static final Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }

    private Class<T> type;
    private T data;

    public DynamicTypeMapper(Class<T> aClazz) {
        this.type = aClazz ;

    }

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            data = type.getConstructor().newInstance();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        ResultSetMetaData metadata = rs.getMetaData();
        // count column
        int columnCount = metadata.getColumnCount();
        // get private arrays fields
        Field[] fields = type.getDeclaredFields();

        for (int i = 1; i <= columnCount; i++) {

            int fieldCount = i;
            //find field mapper with column db
            Field field =  Stream.of(fields).filter(
                    (f -> {
                        try {
                            return f.getName().equals(snakeToCamelCase(metadata.getColumnName(fieldCount)));
                        } catch (SQLException e) {
                            return false;
                        }
                    })
            ).collect(toSingleton());

            if(field != null){
                try{
                    field.setAccessible(true);

                    Annotation typeJson = field.getAnnotation(TypeJson.class);

                    if(typeJson != null){
                        // get data json
                        String dto = rs.getString(i);
                        // mapper json to object
                        if(dto != null){
                            ObjectMapper mapper = new ObjectMapper();
                            Object dataJson = null;
                            try {
                                dataJson = mapper.readValue (dto,  field.getType());
                            } catch (JsonProcessingException e) {
                                e.printStackTrace();
                            }
                            field.set(data,dataJson);
                        }
                    }else{
                        // mapper data type to field
                        if(field.getClass().isEnum()){
                            field.set(data, Enum.valueOf((Class<Enum>) field.getType(), (String) rs.getObject(metadata.getColumnName(i))));
                        }else{
                            field.set(data, rs.getObject(metadata.getColumnName(i)));
                        }
                    }
                }catch (IllegalAccessException e){

                }

            }
        }
        return data;
    }

    private String snakeToCamelCase(String text){
        return Pattern.compile("_([a-z])")
                .matcher(text)
                .replaceAll(m -> m.group(1).toUpperCase());
    }
    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        return null;
                    }
                    return list.get(0);
                }
        );
    }

}

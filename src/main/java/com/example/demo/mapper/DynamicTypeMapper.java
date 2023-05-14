package com.example.demo.mapper;

import com.example.demo.anotation.TypeJson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import org.springframework.jdbc.core.RowMapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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

    public DynamicTypeMapper(Class<T> aClazz)
            throws InstantiationException, IllegalAccessException {
        this.type = aClazz ;
        data = (T) aClazz.newInstance();
    }

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResultSetMetaData metadata = rs.getMetaData();
        int columnCount = metadata.getColumnCount();
        Field[] fields = type.getDeclaredFields();
        for (int i = 1; i <= columnCount; i++) {

            Field field = fields[i];
            field.setAccessible(true);


            Annotation typeJson = field.getAnnotation(TypeJson.class);
            if(typeJson != null){
                TypeJson jsonData = (TypeJson) typeJson;
                String dto = rs.getString(i);

                String dataJson = getGson().fromJson(dto, (Type) jsonData.typeClass());
                try {
                    field.set(data,dataJson);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            // check type db mapper to dto
            //
            try {
                field.set(data, rs.getObject(metadata.getColumnName(i)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return data;
    }
}

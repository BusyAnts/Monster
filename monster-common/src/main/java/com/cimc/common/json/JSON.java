package com.cimc.common.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * JSON解析处理
 *
 * @author chenz
 */
public class JSON {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();

    /**
     * 将JSON数据写入文件
     * @param file
     * @param value
     * @throws Exception
     */
    public static void marshal(File file, Object value) throws Exception {
        try {
            objectWriter.writeValue(file, value);
        } catch (JsonGenerationException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    /**
     * 将JSON数据输出
     * @param os
     * @param value
     * @throws Exception
     */
    public static void marshal(OutputStream os, Object value) throws Exception {
        try {
            objectWriter.writeValue(os, value);
        } catch (JsonGenerationException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    /**
     * 将JSON数据变成字符串输出
     * @param value
     * @return
     * @throws Exception
     */
    public static String marshal(Object value) throws Exception {
        try {
            return objectWriter.writeValueAsString(value);
        } catch (JsonGenerationException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    /**
     * 将JSON数据变成byte数组
     * @param value
     * @return
     * @throws Exception
     */
    public static byte[] marshalBytes(Object value) throws Exception {
        try {
            return objectWriter.writeValueAsBytes(value);
        } catch (JsonGenerationException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    /**
     * 从文件中解析JSON
     * @param file
     * @param valueType
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T unmarshal(File file, Class<T> valueType) throws Exception {
        try {
            return objectMapper.readValue(file, valueType);
        } catch (JsonParseException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    /**
     * 从输入流中解析JSON
     * @param is
     * @param valueType
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T unmarshal(InputStream is, Class<T> valueType) throws Exception {
        try {
            return objectMapper.readValue(is, valueType);
        } catch (JsonParseException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    /**
     * 从字符串中解析JSON
     * @param str
     * @param valueType
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T unmarshal(String str, Class<T> valueType) throws Exception {
        try {
            return objectMapper.readValue(str, valueType);
        } catch (JsonParseException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

    /**
     * 从字符数组解析JSON
     * @param bytes
     * @param valueType
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T unmarshal(byte[] bytes, Class<T> valueType) throws Exception {
        try {
            if (bytes == null) {
                bytes = new byte[0];
            }
            return objectMapper.readValue(bytes, 0, bytes.length, valueType);
        } catch (JsonParseException e) {
            throw new Exception(e);
        } catch (JsonMappingException e) {
            throw new Exception(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }
}
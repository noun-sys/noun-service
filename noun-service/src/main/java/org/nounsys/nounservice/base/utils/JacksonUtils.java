package org.nounsys.nounservice.base.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * @author:gaoxu
 * @create:2020-03-17 13:48
 **/
public class JacksonUtils {

    private static final String EMPTY_JSON = "{}";
    private static final String EMPTY_JSONS = "[]";
    private static final ObjectMapper MAPPER;
    private static final ObjectMapper MAPPER_HAS_NULL;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER_HAS_NULL = new ObjectMapper();
        MAPPER_HAS_NULL.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER_HAS_NULL.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }


    public static String toJsonString(Object object) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T parseObject(String jsonContent, Class<T> clazz) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.readValue(jsonContent, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * java实体对象转换成json字符串 </br> 默认对象中出现值为null时 隐藏json中的key
     */
    public static String toJsonNotNullKey(Object obj) {
        return JacksonUtils.toJson(obj, MAPPER);
    }

    /**
     * java实体对象转换成json字符串 </br> 默认对象中出现值为null时 显示json中的key,其值为null
     */
    public static String toJsonHasNullKey(Object obj) {
        return JacksonUtils.toJson(obj, MAPPER_HAS_NULL);
    }

    /**
     * java实体对象转换成json字符串
     */
    private static String toJson(Object obj, ObjectMapper mapper) {
        if (obj == null) {
            return StringUtils.EMPTY;
        }

        try {
            StringWriter writer = new StringWriter();
            MAPPER.writeValue(writer, obj);
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    /**
     * json字符串转换为对应的java实体对象
     */
    public static <T> T toObj(String jsonStr, Class<T> objClass) {
        if (isEmpty(jsonStr)) {
            return newInstance(objClass);
        }

        try {
            return MAPPER.readValue(jsonStr, objClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newInstance(objClass);
    }

    /**
     * byte[]转换为对应的java实体对象
     */
    public static <T> T toObj(byte[] jsonBytes, Class<T> objClass) {
        if (ArrayUtils.isEmpty(jsonBytes)) {
            return newInstance(objClass);
        }

        try {
            return MAPPER.readValue(jsonBytes, objClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newInstance(objClass);
    }

    private static <T> T newInstance(Class<T> objClass) {
        try {
            return objClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("cannot create new instance", e);
        }
    }

    public static <T> List<T> toObjList(String jsonStr, Class<T> objClass) {
        if (isEmpty(jsonStr)) {
            return Collections.emptyList();
        }

        try {
            return MAPPER.readValue(jsonStr,
                    MAPPER.getTypeFactory().constructParametrizedType(ArrayList.class, List.class, objClass));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static boolean isEmpty(String content) {
        return StringUtils.isBlank(content) || EMPTY_JSON.equals(content) || EMPTY_JSONS
                .equals(content);
    }

    public static boolean isNotEmpty(String content) {
        return !isEmpty(content);
    }


    public static JavaType getCollectionType(Class<?> paramClass, Class<?>... elementClasses) {
        return MAPPER.getTypeFactory().constructParametricType(paramClass, elementClasses);
    }


    public static <T> T parse(String jsonStr, Class<T> paramClass, Class<?>... elementClass) {
        try {
            return MAPPER.readValue(jsonStr, getCollectionType(paramClass, elementClass));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parse(String jsonStr, TypeReference<T> typeReference) {
        try {
            return MAPPER.readValue(jsonStr, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转换为ObjectNode（允许是个数组）
     */
    public static JsonNode tree(String jsonString) {
        try {
            return MAPPER.readTree(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map toMap(String jsonStr, Class<?> keyClass, Class<?> valueClass) {
        try {
            return MAPPER.readValue(jsonStr,
                    MAPPER.getTypeFactory().constructParametricType(HashMap.class, keyClass, valueClass));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_MAP;
    }


    /**
     * 创建新ObjectNode
     */
    public static ObjectNode createObjectNode() {
        return MAPPER.createObjectNode();
    }

    /**
     * 创建新ArrayNode
     */
    public static ArrayNode createArrayNode() {
        return MAPPER.createArrayNode();
    }
}

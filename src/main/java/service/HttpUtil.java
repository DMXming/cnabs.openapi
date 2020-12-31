
package service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.*;

public class HttpUtil{

    /**
     * get请求
     * @return
     */
    public static <T> T doGet(Class<T> t,StringBuilder url, String token,IdentityHashMap<String, Object> params) {
        try {
            int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE & ~Feature.UseBigDecimal.getMask();
//            int features = 0;
//            features |= Feature.UseBigDecimal.getMask();

            String body = HttpGetResult(url,token,params);
            Result<T> jo= JSONObject.parseObject(body,Result.class);
            if(jo.code!=200) {
                throw new IllegalArgumentException (jo.message);
            }
            if(jo.data instanceof String
                || jo.data instanceof BigDecimal
              )
                return (T)jo.data;

          //return JSONObject.parseObject(jo.data.toString(),t,disableDecimalFeature);
         // return JSONObject.parseObject(jo.data.toString(),t);
             return JSON.toJavaObject((JSONObject)jo.data,t);
        }
        catch (Exception ex)
        {
            throw ex;
          //  return null;
        }
    }

//    public static Map<String,Object> doGetMap(StringBuilder url, String token,IdentityHashMap<String, Object> params) {
//        String body = HttpGetResult(url,token,params);
//        Result<Object> jo= JSONObject.parseObject(body,Result.class);
//        if(jo.code!=200) {
//            throw new IllegalArgumentException (jo.message);
//        }
//        return JSONObject.parseObject(jo.data.toString(),new TypeReference<Map<String, Object>>(){});
////        JSON.toJavaObject((JSONObject)jo.data,new TypeReference<Map<String, Object>>(){});
////        JSONObject.parseObject((JSONObject)jo.data, new TypeReference<Map<String, Object>>(){});
//    //    return JSON.toJavaObject((JSONObject)jo.data,t);
//    }



//    public static <T> T doGetList(StringBuilder url, String token, IdentityHashMap<String,Object> params)
//    {
////        try {
//            String body = HttpGetResult(url,token,params);
//            Result<T> jo= JSONObject.parseObject(body,Result.class);
//            if(jo.code!=200) {
//                throw new IllegalArgumentException (jo.message);
//            }
//            var isList=  jo.data instanceof List;
//            if(isList){
//                var dataStr = JSONObject.parseObject(body).getString("data");
//                return  (T)JSONArray.parseArray(dataStr);
//               }
//
//            return null;
////        }
////        catch (Exception ex)
////        {
////            var ss= ex.getMessage();
////            return null;
////        }
//    }

    public static <T> List<T> doGetList(Class<T> t, StringBuilder url, String token, IdentityHashMap<String,Object> params)
    {
        try {
            String body = HttpGetResult(url,token,params);
            Result<T> jo= JSONObject.parseObject(body,Result.class);
            if(jo.code!=200) {
                throw new IllegalArgumentException (jo.message);
            }
            var isList=  jo.data instanceof List;
            if(isList){
                var dataStr = JSONObject.parseObject(body).getString("data");
                return JSONArray.parseArray(dataStr,t);
            }

            return null;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

//    public static <T> List<T> doGetList(Class<T> t, StringBuilder url, String token, IdentityHashMap<String,Object> params,Feature feature)
//    {
//        try {
//            String body = HttpGetResult(url,token,params);
//            Result<T> jo= JSONObject.parseObject(body,Result.class);
//            if(jo.code!=200) {
//                throw new IllegalArgumentException (jo.message);
//            }
//            var isList=  jo.data instanceof List;
//            if(isList){
//                List<T> result = new ArrayList<T>(((List<?>) jo.data).size());
//
//                var dataStr = JSONObject.parseObject(body).getString("data");
//                ((List<?>) jo.data).forEach((element)->{
//                    if (element instanceof String
//                            || element instanceof Number
//                            || element instanceof Boolean
//                    ){
//                        result.add((T)element);
//                    }else {
//                        T tc = JSONObject.parseObject(element.toString(),t,feature);
//                        result.add(tc);
//                    }
//
//                });
//                return result;
//            }
//
//            return null;
//        }
//        catch (Exception ex)
//        {
//            throw ex;
//        }
//    }


    public static <T> String HttpGetResult(StringBuilder url, String token, IdentityHashMap<String, Object> params)
    {
        try {
        if(params!=null) {
            url.append("?");
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                var value=entry.getValue();
                if(value!=null) {
                    if(value instanceof Date)
                    {
                       value= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
                    }
                    url.append(entry.getKey()).append("=").append(value).append("&");
                }
            }
        }

        if(url.charAt(url.length()-1)=='&') url.deleteCharAt(url.length()-1);
        HttpClient client = HttpClient.newHttpClient();
        var urlstr= url.toString().replaceAll(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlstr))
                .setHeader("Authorization",token)
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return body;
        }
        catch (Exception ex){
                ex.printStackTrace();
            return null;
        }
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class Result<T> {
        public String status;
        public String message;
        public int code;
        public T data;
    }

    public class  StringObjectHashMap extends HashMap<String,Object>{}
}
package com.example.demo.service;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Component
public class OpenApiManager {


    private final String AUTH_KEY = "kGT7pWzM0LnYgWCLxqd%2Bi9x82cpVdrd4oFX28ih9uq1WsQmVWGnivGTMoTztrYTiOBQ2oB6nv43Irl4N6n0xIg%3D%3D";

    public String openApi(String pageNum) throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/3510500/medical_institution/getList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=kGT7pWzM0LnYgWCLxqd%2Bi9x82cpVdrd4oFX28ih9uq1WsQmVWGnivGTMoTztrYTiOBQ2oB6nv43Irl4N6n0xIg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNum, "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*JSON/XML(default : JSON)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        JSONObject jsonObject = XML.toJSONObject(result.toString());
        String jsonPrintString = jsonObject.toString();

        rd.close();
        conn.disconnect();

        return jsonPrintString;

    }
}

package com.example.demo.service;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class Parser {

    public Elements getElements(String url,String stringClass,int index ) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new MyResponseHandler();
        HttpGet httpget = new HttpGet(url);
        String httpResponse = httpclient.execute(httpget, responseHandler);
        Document document = Jsoup.parse(httpResponse);

        Elements elements = document.getElementsByAttributeValue("class", stringClass);
        Element elementXNew = elements.get(index);
        Elements elementXNewChild = elementXNew.children();

        return elementXNewChild;
    }

}

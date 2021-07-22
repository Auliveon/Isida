package utils;

import models.Link;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class PageParser {

    public static ArrayList<Link> parsePage(String url) throws IOException {

        ArrayList<Link> links = new ArrayList<Link>();
        Document doc = Jsoup.connect(linkValidator(url)).get();
        Elements elements = doc.select("a");

        for (Element elem : elements) {
            elem.absUrl("href");
            if (!elem.absUrl("href").equals(""))
                links.add(new Link(elem.ownText().equals("") ? "<empty>" : elem.ownText(), elem.absUrl("href")));
        }

        return links;
    }

    public static String linkValidator(String url) {
        if(!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
            return url;
        }

        return url;
    }
}

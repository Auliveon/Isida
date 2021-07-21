package utils;

import models.Link;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class PageParser {

    public static ArrayList<Link> parsePage(String query) throws IOException {

        ArrayList<Link> links = new ArrayList<Link>();
        String url = linkValidator(query);
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("a");

        for (Element elem : elements) {
            elem.absUrl("href");
            if (!elem.absUrl("href").equals(""))
                links.add(new Link(elem.ownText().equals("") ? "<empty>" : elem.ownText(), elem.absUrl("href")));
        }

        return links;
    }

    public static String linkValidator(String link) {
        if(!link.startsWith("http://") && !link.startsWith("https://")) {
            link = "http://" + link;
            return link;
        }
        return link;
    }
}

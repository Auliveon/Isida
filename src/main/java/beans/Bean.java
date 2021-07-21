package beans;

import models.Link;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.primefaces.PrimeFaces;
import utils.PageParser;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@ManagedBean(name = "parse")
@ViewScoped
public class Bean {

    private String query;

    private ArrayList<Link> linkList;

    public void clearLinkList() {
        this.linkList = null;
    }

    public ArrayList<Link> getLinkList() {
        return linkList;
    }

    public void waitingBoxOpen() {
        Map<String,Object> options = new HashMap<String,Object>();
        options.put("modal", true);
        options.put("width", 640);
        options.put("height", 340);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
        PrimeFaces.current().dialog().openDynamic("waitingBox", options, null);

    }

    public void showErrorMessage() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Ошибка", "Анализ завершился ошибкой"));

    }

    public void setLinkList(ArrayList<Link> linkList) throws IOException {
        this.linkList = linkList;
    }

    public ArrayList<Link> getParsedNodes()  {
        try {
            waitingBoxOpen();
            setLinkList(PageParser.parsePage(query));
            PrimeFaces.current().dialog().closeDynamic(null);

        } catch (Exception e) {
            showErrorMessage();
        }

        return null;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {


        this.query = query;
    }

    public void ajaxInputHandler(AjaxBehaviorEvent event) {
        System.out.println(123);
    }


}

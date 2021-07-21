package beans;


import models.Link;
import utils.PageParser;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;

@ManagedBean(name = "bean")
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

    public void showErrorMessage() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Ошибка", "Анализ завершился ошибкой"));
    }

    public void setLinkList(ArrayList<Link> linkList) throws IOException {
        this.linkList = linkList;
    }

    public void analyze() {
        try {
            Thread.sleep(3000); //delay imitation
            setLinkList(PageParser.parsePage(query));
        } catch (Exception e) {
            showErrorMessage();
        }
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}

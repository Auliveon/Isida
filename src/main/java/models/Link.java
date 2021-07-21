package models;

public class Link {

    private String linkName;

    private String value;

    public Link(String linkName, String value) {
        this.linkName = linkName;
        this.value = value;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

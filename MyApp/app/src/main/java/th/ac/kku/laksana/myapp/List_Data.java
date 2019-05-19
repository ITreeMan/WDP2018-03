package th.ac.kku.laksana.myapp;

public class List_Data {
    private String image;
    private String name;
    private String subject;
    private String linkPdf;

    public List_Data(){


    }

    public List_Data(String image, String name, String subject, String linkPdf) {
        this.image = image;
        this.name = name;
        this.subject = subject;
        this.linkPdf = linkPdf;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }
    public String getLinkPdf(){
        return linkPdf;
    }
}
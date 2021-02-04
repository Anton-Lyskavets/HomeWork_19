package JavaPVT.HW_19_1;

public class Email {
    private String important;
    private int id;
    private String to;
    private String from;
    private String heading;
    private String body;

    public void setImportant(String important) {
        this.important = important;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public void setFrom(String from) {
        this.from = from;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email{" +
                "important=" + important +
                ", id=" + id +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", heading='" + heading + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

package serialization;

public class Chapter {
    public short getPage() {
        return page;
    }
    private short page;

    public String getName() {
        return name;
    }
    private String name;

    public String getText() {
        return text;
    }
    private String text;

    public Chapter () {this((short)0, "Unknown", "Unknown");}
    public Chapter(short page, String name, String text) {
        if (page > 0)
            this.page = page;
        this.name = name;
        this.text = text;
    }
}

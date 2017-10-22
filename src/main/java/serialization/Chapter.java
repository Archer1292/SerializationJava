package serialization;

public class Chapter {
    public short getPage() {
        return page;
    }
    private short page;

    public String getTitle() {
        return title;
    }
    private String title;

    public String getText() {
        return text;
    }
    private String text;

    public Chapter () {this((short)0, "Unknown", "Unknown");}
    public Chapter(short page, String title, String text) {
        if (page > 0)
            this.page = page;
        this.title = title;
        this.text = text;
    }

    public Chapter clone() { return new Chapter(this.page, this.title, this.text); }

    public boolean equals(Chapter chapter) {
        if (this.page == chapter.page && this.title.equals(chapter.title) && this.text.equals(chapter.text))
            return true;

        return false;
    }
    @Override
    public boolean equals(Object object) {
        return (object instanceof Chapter) && (this.equals((Chapter)object));
    }
}

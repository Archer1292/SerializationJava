package serialization;

import java.util.ArrayList;
import java.util.List;

public class Book {
    public short getPageCount() {
        return pageCount;
    }
    private short pageCount;

    public String getName() {
        return name;
    }
    private String name;

    public String getAuthor() {
        return author;
    }
    private String author;

    public List<Chapter> getChapters() {
        return chapters;
    }
    private List<Chapter> chapters;

    public Book() {this((short) 0, "Unknown", "Unknown");}
    public Book(short pageCount, String name, String author) {
        this.pageCount = pageCount;
        this.name = name;
        this.author =  author;
        chapters = new ArrayList<>();
    }
    public Book(short pageCount, String name, String author, List<Chapter> chapters) {
        this(pageCount, name, author);
        this.chapters = chapters;
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }
    public void addChapter(short page, String name, String text) {
        addChapter(new Chapter(page, name, text));
    }

    @Override
    public String toString() {
        return "\'" + name + "\' written by " + author + ", " + chapters.size() + " chapters";
    }

    public Book clone() {
        ArrayList<Chapter> chapters = new ArrayList<>();
        for (Chapter chapter:this.chapters)
            chapters.add(chapter.clone());
        return new Book(pageCount, name, author, chapters);
    }

    public boolean equals(Book book) {
        if (this.pageCount == book.pageCount && this.name.equals(book.name) && this.author.equals(book.author)
            && this.chapters.size() == book.chapters.size()) {
            for (int i = 0; i < this.chapters.size(); i++)
                if (!chapters.get(i).equals(book.chapters.get(i)))
                    return false;
            return true;
        }

        return false;
    }
    @Override
    public boolean equals(Object object) {
        return (object instanceof Book) && (this.equals((Book)object));
    }
}

import java.time.LocalDate;

public class History
{

    public History(String type, int id, String title, int seq, int year, double rating, LocalDate date)
    {
        this.type = type;
        this.id = id;
        this.title = title;
        this.seq = seq;
        this.year = year;
        this.rating = rating;
        this.date = date;
    }

    // atributter
    private String type;
    private int id;
    private String title; 
    private int seq;
    private int year;
    private double rating; 
    private LocalDate date;

    // Metoder
    public String getType(){
        return type;
    }

    public int getId()
    {
        return id;
    }


    public String getTitle()
    {
        return title;
    }

    public int getSeq()
    {
        return seq;
    }

    public int getYear()
    {
        return year;
    }
    
    public double getRating()
    {
        return rating;
    }

    public LocalDate getDate()
    {
        return date;
    }
}
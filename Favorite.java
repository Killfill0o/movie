import java.time.LocalDate;

public class Favorite
{

    public Favorite(String line1, String line2)
    {
        this.line1 = line1;
        this.line2 = line2;
    }

    // atributter
    private String line1;
    private String line2;

    // Metoder
    public String getLine1(){
        return line1;
    }

    public String getLine2()
    {
        return line2;
    }
}
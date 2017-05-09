import java.time.LocalDate;

public class Login
{

    public Login(String username, int userpin, int userid, LocalDate date)
    {
        this.username = username;
        this.userid = userid;
        this.userpin = userpin;
        this.date = date;
    }

    // atributter
    private String username; 
    private int userid;
    private int userpin; 
    private LocalDate date;

    // Metoder
    public String getUsername()
    {
        return username;
    }

    public int getUserid()
    {
        return userid;
    }
    
    public int getUserpin()
    {
        return userpin;
    }

    public LocalDate getDate()
    {
        return date;
    }
}
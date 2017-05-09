public class Actor
{

    public Actor(int id, String actor1, String char1, String actor2, String char2){
        this.id = id;
        this.actor1 = actor1;
        this.actor1 = actor2;
        this.actor1 = char1;
        this.actor1 = char2;
    }

    // atributter
    private int id;
    private String actor1;
    private String char1;
    private String actor2;
    private String char2; 

    public int getId()
    {
        return id;
    }

    public String getActor1()
    {
        return actor1;
    }

    public String getChar1()
    {
        return char1;
    }
    

    public String getActor2()
    {
        return actor2;
    }

    public String getChar2()
    {
        return char2;
    }

}
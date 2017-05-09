// Imports
import java.io.PrintStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.time.LocalDate;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

//Class start
public class MovieSL{
    private String string;
    
        public MovieSL() {
        this.string = string;
        }

        public static void search(){
            try{
            ArrayList<Movie> movies = new ArrayList<Movie>();
            Display ds = new Display();

            File f = new File("_main"+".log");
            Scanner scanfile = new Scanner(new File("_main"+".log"));
            scanfile.useLocale(Locale.US);
            int i = 0;
            LocalDate date = LocalDate.now();

            PrintStream file = new PrintStream(new File("_search"+".log"));

            ds.clear();
            ds.print("Sort movies by: ");
            ds.print("1. Genre"+"\r\n"+"2. Title"+"\r\n"+"3. ID"+"\r\n"+"4. Year");
            ds.center(4);
            String sorttype = System.console().readLine();

            if(sorttype.equals("1")){ // sort type
            ds.clear();
            ds.print("action - horror - love"+"\r\n");
            ds.print("Which genre do you want to search for? ");
            ds.center(6);
            String search = System.console().readLine();
            
            while (scanfile.hasNextLine()){
                String temptype = scanfile.next();
                if(temptype.equals(search)){
                    movies.add(new Movie(temptype, scanfile.nextInt(), scanfile.next(), scanfile.nextInt(), scanfile.nextInt(), scanfile.nextDouble(), LocalDate.parse(scanfile.next())));
                    file.print(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                    System.out.println(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                    i++;
                }
            } // while-loop end
            } // sort type end

            if(sorttype.equals("2")){ // sort title
            ds.clear();
            ds.print("Which title do you want to search for? ");
            ds.center(6);
            String search = System.console().readLine();
            
            while (scanfile.hasNextLine()){
                String temptype = scanfile.next();
                int tempid = scanfile.nextInt();
                String tempname = scanfile.next();
                int tempseq = scanfile.nextInt();
                int tempyear = scanfile.nextInt();
                double temprating = scanfile.nextDouble();
                String tempdate = scanfile.next();
    
                ds.print("type "+temptype+" name "+tempname+" id "+tempid);
                if(tempname.equals(search)){
                    movies.add(new Movie(temptype, tempid, tempname, tempseq, tempyear, temprating, LocalDate.parse(tempdate)));
                    ds.print("Printing:");
                    file.print(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                    System.out.println(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                    i++;
                }
                // temptype = tempname; // når string (genren) ikke er titlen, bliver temp2 sat til string (genren) og næste er så en title (tilhørende den genre)
            } // while-loop end
            } // sort title end
            
            if(sorttype.equals("3")){ // sort id
            ds.clear();
            ds.print("What ID do you want to search for? ");
            ds.center(6);
            String search = System.console().readLine();
            int sint = Integer.parseInt(search);
            ds.print("CHECK HERE "+sint);
            String tempname = "null";
            int tempseq = 0;
            int tempyear = 0;
            String temptype = "null";
            int tempid = 1;
            double temprating = 1.0;
            String tempdate = "null";

            while (scanfile.hasNextLine()){
                temptype = scanfile.next();
                tempid = scanfile.nextInt();
                ds.print("type "+temptype+" id "+tempid+" name "+tempname+" year "+tempyear);
                if(tempid == sint){
                    movies.add(new Movie(temptype, tempid, scanfile.next(), scanfile.nextInt(), scanfile.nextInt(), scanfile.nextDouble(), LocalDate.parse(scanfile.next())));

                    ds.print("printing: ");

                    file.print(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                    System.out.println(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                    i++;
                }
                tempname = scanfile.next();
                tempseq = scanfile.nextInt();
                tempyear = scanfile.nextInt();
                temprating = scanfile.nextDouble();
                tempdate = scanfile.next();
                
            } // while-loop end
            } // sort id end

            if(sorttype.equals("4")){ // sort year
            ds.clear();
            ds.print("What year do you want to search for? ");
            ds.center(6);
            String search = System.console().readLine();
            int sint = Integer.parseInt(search);
            String tempname = "null";
            int tempseq = 0;
            int tempyear = 0;
            String temptype = "null";
            int tempid = 1;
            double temprating = 1.0;
            String tempdate = "null";

            while (scanfile.hasNextLine()){
                temptype = scanfile.next();
                tempid = scanfile.nextInt();
                tempname = scanfile.next();
                tempseq = scanfile.nextInt();
                tempyear = scanfile.nextInt();
                if(tempyear == sint){
                    movies.add(new Movie(temptype, tempid, tempname, tempseq, tempyear, scanfile.nextDouble(), LocalDate.parse(scanfile.next())));
                    ds.print("naar vi her?");
                    file.print(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                    System.out.println(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                    i++;
                } else {
                temprating = scanfile.nextDouble();
                tempdate = scanfile.next();
                }

            } // while-loop end
            } // sort year end

            }
        catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);} 
        } // search

        public static void save(){
        try{
            //arraylisten "movies" oprettes
            ArrayList<Movie> movies = new ArrayList<Movie>();
            Display ds = new Display();
            
            //Tager input "scanname" og laver filen scanname.log
            ds.clear();
            System.out.println("Database name?");
            
            File f = new File("_main.log");
            

            //laver en "scan" der scanner scanname.log med brug af US locale. (altså er double 2.0 og ikke 2,0)
            Scanner scan = new Scanner(new File("_main.log"));
            scan.useLocale(Locale.US);

            while(scan.hasNext())
            {
                movies.add(new Movie(scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextDouble(), LocalDate.parse(scan.next())));
            }
            
            //opretter en printstream
            PrintStream file = new PrintStream(new File("_main.log"));

            //spørger om typen af movie
            ds.clear();
            System.out.println("Category? ");
            ds.center(5);
            String movieType = System.console().readLine();

            //sætter movie id
            int movieID = movies.size() + 001;

            //tager input og opretter title
            ds.clear();
            System.out.println("Enter title: ");
            ds.print("(- = space || & = and) ");
            ds.center(5);
            String title = System.console().readLine();

            //tager input og opretter title
            ds.clear();
            System.out.println("Enter sequal (0 if not): ");
            ds.center(5);
            String s_seq = System.console().readLine();
            int seq = Integer.parseInt(s_seq);

            //tager input og converter fra string to int.
            ds.clear();
            System.out.println("Enter year: ");
            ds.center(5);
            String s_year = System.console().readLine();
            int year = Integer.parseInt(s_year);

            //tager input og converter fra string til double.
            ds.clear();
            System.out.println("Enter rating: ");
            ds.center(5);
            String s_rating = System.console().readLine();
            double rating  = Double.parseDouble(s_rating);

            //sætter date til den lokale dato (dags dato.)
            LocalDate date = LocalDate.now();
            
             //while-loop som scanner en string, int, double og date.

            //tilføjer de 7 inputs type/id/title/seq/year/rating/date til movie arraylisten.
            movies.add(new Movie(movieType,movieID,title,seq,year,rating,date));
           
            /** 
            for-loop som kører efter arraylisten movies længde.
            inde i loopet printer den til file (altså scanname.log) title/year/rating/date og så en ny linje (\r\n)
            Dernæst printer den til consolen de samme 4 variabler.
            */
            for(int i = 0; i < movies.size(); i++){
                file.print(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
            }                   
            ds.print("\r\n"+movieType+movieID+title+seq+year+rating+date);
            
            ds.print("  "+"Press enter to continue: ");
            String pause = System.console().readLine();
            //Besked der vises når for-loop'et er færdigt, bruger date variablen
            System.out.println("Document have been updated: " + date.toString());
            
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}   



    }//save end
    
    public static void load(String type){
            try{
            //arraylisten "movies" oprettes
            ArrayList<Movie> movies = new ArrayList<Movie>();
            Display ds = new Display();
            
             Scanner curuser = new Scanner(new File(".current"+".user"));
            String currentuser = curuser.next();

            String scanty = "_search.log";
            //while-loop som scanner en string, int, double og date.
            if(type.equals("load")){ scanty = "_search"+".log";}
            if(type.equals("fav")){ scanty = "."+currentuser+".fav";}
            if(type.equals("his")){ scanty = "."+currentuser+".his";}
           
           
           Scanner scan = new Scanner(new File(scanty));

            //laver en "scan" der scanner scanname.log med brug af US locale. (altså er double 2.0 og ikke 2,0)

            scan.useLocale(Locale.US);
            while(scan.hasNext())
            {
                movies.add(new Movie(scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextDouble(), LocalDate.parse(scan.next())));
            }
            
            ds.clear();
            
            LocalDate date = LocalDate.now();
            
            /** 
            for-loop som kører efter arraylisten movies længde.
            inde i loopet printer den til file (altså scanname.log) title/year/rating/date og så en ny linje (\r\n)
            Dernæst printer den til consolen de samme 4 variabler.
            */ 

            int moviepage = movies.size()+10;
            int moviesize = movies.size();
            int pagesize = 10;
            String np = "next";
            int i = 0;
            int jo = 1;
            int j = 1;

            while(j <= moviepage/10){
                pagesize = 10;

                if(moviesize == 0){
                    moviesize = 2; 
                }

                if(moviesize >= jo){
                    if(i<0){i=0;jo=1;pagesize=10;j=1;}
                    ds.clear();
                    System.out.println("   Page "+j);
                    ds.center(2);
                    pagesize = j*10;
                    if(moviesize < j*10){pagesize = moviesize;}
                    for(i = i; i < pagesize; i++){
                        String seq = String.valueOf(movies.get(i).getSeq());
                        if(seq.equals("0")){seq = " ";}
                        String formattedString = "";
                        String tempString = movies.get(i).getTitle()

                        .replace("-", " ")  //replacer - med mellemrum
                        .replace("&", " and ")  //replacer & med "and"
                        .trim();
                        formattedString = formattedString + tempString;

                     int titlelen = formattedString.length();
                        int fixlen = 25 - formattedString.length();
                        String addlen = "";
                        for(int fl = 0; fl<fixlen;){
                            addlen += " ";
                            fl++;
                        }

                    ds.print(""+i+"     "+formattedString+" "+seq+addlen+" -   year: "+movies.get(i).getYear()+" -   rating: "+movies.get(i).getRating());
                    } // print
                    i = j*10;
                    ds.center(2);
                    System.out.print("   < last "+j+" | exit | index | "+moviepage/10+" next >   ");
                    np = System.console().readLine();
            
                    if(np.equals("next")){
                    j += 1;
                    jo += 10;
                    }

                    if(np.equals("last")){
                            j -= 1;
                            jo -= 10;
                            i -= 20;
                    }

                    if(np.equals("exit")){
                        ds.clear();
                        ds.print("EXIT");
                        j = moviepage/10 +1;
                    }

                    if(!np.equals("next")&&!np.equals("last")&&!np.equals("exit")){
                        int npx = Integer.parseInt(np);
                        
                        int idx = movies.get(npx).getId() - 1;

                        view(idx,type);
                    }

                    
                } // nextpage
            } // j < moviepage/10                       
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e); String pause = System.console().readLine();}


        } //load end
      

     public static void view(int x, String intype){
        try{
        ArrayList<Movie> movies = new ArrayList<Movie>();
        ArrayList<History> history = new ArrayList<History>();
        ArrayList<Favorite> favorite = new ArrayList<Favorite>();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Display ds = new Display();

        ds.print(""+x);

        Scanner scan = new Scanner(new File("_main"+".log"));
        scan.useLocale(Locale.US);

        while(scan.hasNext())
        {
            movies.add(new Movie(scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextInt(), scan.nextDouble(), LocalDate.parse(scan.next())));
        }

        Scanner scanac = new Scanner(new File("_mainactors"+".log"));

        String actor1 = " "; String char1 = " "; String actor2 = " "; String char2 = " ";

         while(scanac.hasNext())
        {
           String temp = scanac.next();
           String i = String.valueOf(x+1);
           ds.print(" "+temp);

            if(temp.equals(i)){actor1 = scanac.next(); char1 = scanac.next(); actor2 = scanac.next(); char2 = scanac.next(); 
            } else{
            scanac.next();scanac.next();scanac.next();scanac.next();
        }}
        
    
        ds.clear();

        String seq = String.valueOf(movies.get(x).getSeq());
        if(seq.equals("0")){seq = "";}

        String title = "";
        String tempString = movies.get(x).getTitle()
        .replace("-", " ")  //replacer - med mellemrum
        .replace("&", " and ")  //replacer & med " and "
        .trim();
        title = title + tempString;

        tempString = actor1
        .replace("-", " ")  //replacer - med mellemrum
        .replace("/", " / ")  //replacer & med " and "
        .trim();
        actor1 = tempString;

        tempString = actor2
        .replace("-", " ")  //replacer - med mellemrum
        .replace("/", " / ")  //replacer & med " and "
        .trim();
        actor2 = tempString;

        tempString = char1
        .replace("-", " ")  //replacer - med mellemrum
        .replace("/", " / ")  //replacer & med " and "
        .trim();
        char1 = tempString;

        tempString = char2
        .replace("-", " ")  //replacer - med mellemrum
        .replace("/", " / ")  //replacer & med " and "
        .trim();
        char2 = tempString;
        String ixtype = "added";
        if(intype.equals("his")){ixtype = "viewed";}

        ds.print("   "+title+" "+seq+" ("+movies.get(x).getYear()+") \r\n"+ "   rating "+movies.get(x).getRating()+"/10");
        ds.print("   ID: "+movies.get(x).getId()+"\r\n   genre: "+movies.get(x).getType()+"\r\n   "+ixtype+": "+movies.get(x).getDate()+"");
        ds.center(1);
        ds.print("   Staring:\r\n"+"   "+actor1);
        ds.print("   "+actor2);
        ds.center(3);
        System.out.print("   play | add | exit  ");
        String menu = System.console().readLine();
        int i = x;

        if(menu.equals("play")){
            // Play movie...

            Scanner curuser = new Scanner(new File(".current"+".user"));
            String currentuser = curuser.next();

            Scanner schis = new Scanner(new File("."+currentuser+".his"));
            while(schis.hasNext())
            {
            String hline1 = String.valueOf(schis.nextLine());
            String hline2 = String.valueOf(schis.nextLine());

            ds.print(""+hline1);
            ds.print(""+hline2);
            


            history.add(new History(hline1,hline2));
        
            }  

            PrintStream his = new PrintStream(new File("."+currentuser+".his"));
            String htype = movies.get(i).getType();
            int hid = movies.get(i).getId();
            String htitle = movies.get(i).getTitle();
            int hseq = movies.get(i).getSeq();
            int hyear = movies.get(i).getYear();
            double hrating = movies.get(i).getRating();
            LocalDate hdate = LocalDate.now();

            String hnline1 = htype +" "+ String.valueOf(hid) +" "+ htitle +" "+ String.valueOf(hseq);
            String hnline2 = String.valueOf(hyear) + " " + String.valueOf(hrating) + " " + String.valueOf(hdate);

            history.add(new History(hnline1,hnline2));

            for(int j = 0; j<history.size();){
            his.print(history.get(j).getLine1() +"\r\n"+ history.get(j).getLine2()+"\r\n");
            j++;

            }

            ds.clear();
            ds.print("   Playing: "+title+" "+seq);
            ds.center(1);
            ds.print("   Staring: \r\n   "+actor1+" as "+char1);
            ds.print("   "+actor2+" as "+char2);
            ds.center(5);
            System.out.print("   "+"add | exit   ");
            menu = System.console().readLine();


        }



        if(menu.equals("add")){
            // add favorite
            ds.print("   "+title+" add to favorite");
            Scanner curuser = new Scanner(new File(".current"+".user"));
            String currentuser = curuser.next();

            Scanner scfav = new Scanner(new File("."+currentuser+".fav"));
            while(scfav.hasNext())
            {
            String hline1 = String.valueOf(scfav.nextLine());
            String hline2 = String.valueOf(scfav.nextLine());

            ds.print(""+hline1);
            ds.print(""+hline2);
            


            favorite.add(new Favorite(hline1,hline2));
        
            }  

            PrintStream fav = new PrintStream(new File("."+currentuser+".fav"));
            String htype = movies.get(i).getType();
            int hid = movies.get(i).getId();
            String htitle = movies.get(i).getTitle();
            int hseq = movies.get(i).getSeq();
            int hyear = movies.get(i).getYear();
            double hrating = movies.get(i).getRating();
            LocalDate hdate = LocalDate.now();

            String hnline1 = htype +" "+ String.valueOf(hid) +" "+ htitle +" "+ String.valueOf(hseq);
            String hnline2 = String.valueOf(hyear) + " " + String.valueOf(hrating) + " " + String.valueOf(hdate);

            favorite.add(new Favorite(hnline1,hnline2));

            for(int j = 0; j<favorite.size();){
            fav.print(favorite.get(j).getLine1() +"\r\n"+ favorite.get(j).getLine2()+"\r\n");
            j++;}
        }

        if(menu.equals("exit")){
            // exit menu
            ds.clear();
            ds.print("Closing movie");
            ds.center(1);
        }

        ds.print("Hit enter to continue: ");
        ds.center(5);
        String pause = System.console().readLine();
        // catch med FileNotFoundException og en Exception
        }catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}
     } //view end

//Class end
}
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

            //tilføjer de 4 inputs title/year/rating/date til movie arraylisten.
            movies.add(new Movie(movieType,movieID,title,seq,year,rating,date));
           
            /** 
            for-loop som kører efter arraylisten movies længde.
            inde i loopet printer den til file (altså scanname.log) title/year/rating/date og så en ny linje (\r\n)
            Dernæst printer den til consolen de samme 4 variabler.
            */
            for(int i = 0; i < movies.size(); i++){
                file.print(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
                System.out.println(movies.get(i).getType() + movies.get(i).getId() + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
            }                
            
            //Besked der vises når for-loop'et er færdigt, bruger date variablen
            System.out.println("Document have been updated: " + date.toString());
            
        //catch med FileNotFoundException og en Exception
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}   



    }//save end
    
    public static void load(){
            try{
            //arraylisten "movies" oprettes
            ArrayList<Movie> movies = new ArrayList<Movie>();
            Display ds = new Display();
                    
            //laver en "scan" der scanner scanname.log med brug af US locale. (altså er double 2.0 og ikke 2,0)
            Scanner scan = new Scanner(new File("_search"+".log"));
            scan.useLocale(Locale.US);

            //while-loop som scanner en string, int, double og date.
            ds.print("loop3");
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

            ds.print("moviepage "+moviepage+" size "+movies.size()+" jo "+jo+" i "+i);
            ds.print("loop4");

            while(j <= moviepage/10){
                ds.print("loop5");
                pagesize = 10;

                if(moviesize == 0){
                    moviesize = 2; //hotfix loop4?
                    ds.print("loop 4 fixed");
                }

                if(moviesize >= jo){
                    ds.print("loop5.2?");
                    if(i<0){i=0;jo=1;pagesize=10;j=1;}
                    ds.clear();
                    System.out.println("   Page "+j);
                    ds.center(2);
                    pagesize = j*10;
                    if(moviesize < j*10){pagesize = moviesize;}
                    for(i = i; i < pagesize; i++){
                        String seq = String.valueOf(movies.get(i).getSeq());
                        if(seq.equals("0")){seq = "";}
                        String formattedString = "";
                        String tempString = movies.get(i).getTitle()

                        .replace("-", " ")  //replacer - med mellemrum
                        .replace("&", " and ")  //replacer & med "and"
                        .trim();
                        formattedString = formattedString + tempString;

                    System.out.println(i+"     "+formattedString+" "+seq+" - year: "+movies.get(i).getYear()+" - rating: "+movies.get(i).getRating());
                    } // print
                    i = j*10;
                    ds.center(2);
                    System.out.print("   < last "+j+" | "+moviepage/10+" next >");
                    ds.center(1);
                    np = System.console().readLine();
                    //if(j==moviepage/10 && np.equals("last")){j-=1;jo-=10;np="last";};

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

                        view(idx);
                    }

                    
                } // nextpage
                ds.print("loop8");
            } // j < moviepage/10                       
            
            //Besked der vises når for-loop'et er færdigt, bruger date variablen
            // System.out.println("Document have been updated: " + date.toString());
            ds.clear();
        
            String pause = System.console().readLine();
        //catch med FileNotFoundException og en Exception
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e); String pause = System.console().readLine();}


        } //load end
      
       public static void fav(){
            try{
            //arraylisten "movies" oprettes
            ArrayList<Movie> movies = new ArrayList<Movie>();
            Display ds = new Display();
                    
            //laver en "scan" der scanner scanname.log med brug af US locale. (altså er double 2.0 og ikke 2,0)
            Scanner curuser = new Scanner(new File(".current"+".user"));
            String currentuser = curuser.next();

            Scanner scan = new Scanner(new File("."+currentuser+".fav"));
            scan.useLocale(Locale.US);

            //while-loop som scanner en string, int, double og date.
            ds.print("loop3");
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

            ds.print("moviepage "+moviepage+" size "+movies.size()+" jo "+jo+" i "+i);
            ds.print("loop4");

            while(j <= moviepage/10){
                ds.print("loop5");
                pagesize = 10;

                if(moviesize == 0){
                    moviesize = 2; //hotfix loop4?
                    ds.print("loop 4 fixed");
                }

                if(moviesize >= jo){
                    ds.print("loop5.2?");
                    if(i<0){i=0;jo=1;pagesize=10;j=1;}
                    ds.clear();
                    System.out.println("Page "+j +" | pagesize " +pagesize +"| i "+ i);
                    ds.center(2);
                    pagesize = j*10;
                    if(moviesize < j*10){pagesize = moviesize;}
                    for(i = i; i < pagesize; i++){
                        String seq = String.valueOf(movies.get(i).getSeq());
                        if(seq.equals("0")){seq = "";}
                        String formattedString = "";
                        String tempString = movies.get(i).getTitle()

                        .replace("-", " ")  //replacer - med mellemrum
                        .replace("&", " and ")  //replacer & med "and"
                        .trim();
                        formattedString = formattedString + tempString;

                    System.out.println(i+"     "+formattedString+" "+seq+" - year: "+movies.get(i).getYear()+" - rating: "+movies.get(i).getRating());
                    } // print
                    i = j*10;
                    ds.center(2);
                    System.out.print("< last "+j+" | "+moviepage/10+" next >");
                    ds.center(1);
                    np = System.console().readLine();
                    //if(j==moviepage/10 && np.equals("last")){j-=1;jo-=10;np="last";};

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

                        view(idx);
                    }

                    
                } // nextpage
                ds.print("loop8");
            } // j < moviepage/10                       
            
            //Besked der vises når for-loop'et er færdigt, bruger date variablen
            // System.out.println("Document have been updated: " + date.toString());
            ds.clear();
        
            String pause = System.console().readLine();
        //catch med FileNotFoundException og en Exception
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e); String pause = System.console().readLine();}


        } //load end

     public static void view(int x){
        try{
        ArrayList<Movie> movies = new ArrayList<Movie>();
        ArrayList<Movie> history = new ArrayList<Movie>();
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
        .replace("&", " and ")  //replacer & med " and "
        .trim();
        actor2 = tempString;

        tempString = char1
        .replace("-", " ")  //replacer - med mellemrum
        .replace("&", " and ")  //replacer & med " and "
        .trim();
        char1 = tempString;

        tempString = char2
        .replace("-", " ")  //replacer - med mellemrum
        .replace("&", " and ")  //replacer & med " and "
        .trim();
        char2 = tempString;

        ds.print("   "+title+" "+seq+" ("+movies.get(x).getYear()+") \r\n"+ "   rating "+movies.get(x).getRating()+"/10");
        ds.print("   ID: "+movies.get(x).getId()+"\r\n   genre: "+movies.get(x).getType()+"\r\n   added: "+movies.get(x).getDate()+"");
        ds.center(1);
        ds.print("   Staring:\r\n"+"   "+actor1);
        ds.print("   "+actor2);
        ds.center(3);
        ds.print("   play | add | exit  ");
        String menu = System.console().readLine();

        if(menu.equals("play")){
            // Play movie...

            Scanner curuser = new Scanner(new File(".current"+".user"));
            String currentuser = curuser.next();
            Scanner schis = new Scanner(new File("."+currentuser+".his"));
            PrintStream his = new PrintStream(new File("."+currentuser+".his"));

            while(schis.hasNext())
            {
                history.add(new Movie(schis.next(), schis.nextInt(), schis.next(), schis.nextInt(), schis.nextInt(), schis.nextDouble(), LocalDate.parse(schis.next())));
            }

            his.print(history.get(i).getType() + " " + history.get(i).getId() + " " + history.get(i).getTitle() + " " + history.get(i).getSeq() + "\r\n" + history.get(i).getYear() + " " + history.get(i).getRating() + " " + new String(history.get(i).getDate().toString()) + "\r\n" + "\r\n");

            ds.clear();
            ds.print("   Playing: "+title);
            ds.center(1);
            ds.print("   Staring: \r\n   "+actor1+" as "+char1);
            ds.print("   "+actor2+" as "+char2);
            ds.center(5);
            ds.print("   "+"add | exit");
            menu = System.console().readLine();


        }



        if(menu.equals("add")){
            // add favorite
            ds.print("   "+title+" add to favorite");
            Scanner curuser = new Scanner(new File(".current"+".user"));
            String currentuser = curuser.next();
            PrintStream fav = new PrintStream(new File("."+currentuser+".fav"));
            
            int i = x;
            
            fav.print(movies.get(i).getType() + " " + movies.get(i).getId() + " " + movies.get(i).getTitle() + " " + movies.get(i).getSeq() + "\r\n" + movies.get(i).getYear() + " " + movies.get(i).getRating() + " " + new String(movies.get(i).getDate().toString()) + "\r\n" + "\r\n");
        }

        if(menu.equals("exit")){
            // exit menu
            ds.print("Closing movie");
        }
        


        String pause = System.console().readLine();
        // catch med FileNotFoundException og en Exception
        }catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}
     } //view end

//Class end
}
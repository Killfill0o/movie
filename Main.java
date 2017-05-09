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
public class Main
{
    //Main start
    public static void main(String[] args)
    {
        ArrayList<Login> logins = new ArrayList<Login>();
        LoginMenu log = new LoginMenu();
        Display ds = new Display();
        MovieSL msl = new MovieSL();
        boolean main_run = true;
        String login_run = "null";

while(main_run){
        
    while(login_run.equals("null")){ //imens du ikke er logget ind kør login-loop'et
        try{
        Scanner bosc = new Scanner(new File(".current.user")); //scanner om du er logget ind.
        login_run = bosc.next();
        System.out.println(" "+login_run);
        } catch(Exception e){System.out.println(e);
        }

        if(login_run.equals("null")){ //HVIS du ikke er logget ind, kør login-menu'en
        ds.clear();
        ds.print("Welcome "+login_run+"\r\n");
        ds.print("1. Register a new account"+"\r\n"+"2. Login with excisting account "+"\r\n"+"3. Exit the program.");
        ds.center(4);

        Scanner login_menu_input = new Scanner(System.in);
        int swi = login_menu_input.nextInt();
                
                if(swi == 123){
                        ds.size();
                    }

                switch (swi) {
                    case 1:
                        log.userCreate();
                        break;

                    case 2:
                        log.userLogin();
                        break;

                    case 3:
                        login_run = "exit";
                        main_run = false;
                        ds.clear();
                        System.out.println("EXIT");
                        ds.center(6);
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Please choose one of the given options!");
                        break;
                }
        } // if login-menu

    } // login_run
        ds.clear();
        ds.print("Welcome "+login_run+"\r\n");
        ds.print("1. Add new movie"+"\r\n"+"2. Search for movies "+"\r\n"+"3. Load last search "+"\r\n"+"4. Watch favorite(s) "+"\r\n"+"5. View History"+"\r\n"+"6. Log out"+"\r\n"+"7. Exit the program");
        ds.center(3);
        Scanner main_menu_input = new Scanner(System.in);
        int swit = main_menu_input.nextInt();
                
                switch (swit) {
                    case 1:
                        msl.save();
                        break;

                    case 2:
                        msl.search();
                        msl.load("load");
                        break;

                    case 3:
                        msl.load("load");
                        break;

                    case 4:
                        msl.load("fav");
                        break;

                    case 5:
                        msl.load("his");
                        break;

                    case 6:
                        String[] nar;
                        nar = new String[10];
                        try{
                        PrintStream bopr = new PrintStream(new File(".current.user"));
                        bopr.print("null"+"\r\n");
                        main(nar);
                        } catch(Exception e){System.out.println(e);}
                        break;

                    case 7:
                        main_run = false;
                        try{
                        PrintStream bopr = new PrintStream(new File(".current.user"));
                        bopr.print("null"+"\r\n");
                        } catch(Exception e){System.out.println(e);}
                        break;
                        
                    default:
                        ds.print("Please choose one of the given options!");
                        break;

                }
            ds.print("CLOSING");

        }
    
    } // main_run

}
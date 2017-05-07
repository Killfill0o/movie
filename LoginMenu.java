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
public class LoginMenu
{
    private String string;
    ArrayList<Login> logins = new ArrayList<Login>();
    Display ds = new Display();

    public LoginMenu() {
        this.string = string;
        }

    private String current_user;

    public static void userLogin(){
        try{
        //opretter en printstream
        ArrayList<Login> logins = new ArrayList<Login>();
        Display ds = new Display();
        LocalDate date = LocalDate.now();
        String current_user = "";

        //Scanning users in user.data
        Scanner scan = new Scanner(new File(".list.user"));
        while(scan.hasNext()){logins.add(new Login(scan.next(), scan.nextInt(), scan.nextInt(), LocalDate.parse(scan.next())));}

            //Tager input "input_name" og laver filen user.data
            ds.clear();
            ds.print("Enter your username: ");
            ds.center(6);
            String input_name = System.console().readLine();
            ds.clear();
            PrintStream file = new PrintStream(new File(".list.user"));

            for(int i = 0; i < logins.size(); i++){
                file.print(logins.get(i).getUsername() + "\r\n" + logins.get(i).getUserpin() + " " + logins.get(i).getUserid() + " " + new String(logins.get(i).getDate().toString()) + "\r\n");
                if(input_name.equalsIgnoreCase(logins.get(i).getUsername())){
                    ds.clear();
                    ds.print("Welcome "+input_name);
                    ds.print("Enter pincode");
                    ds.center(6);
                    String input_pin = System.console().readLine();
                    int int_pin = Integer.parseInt(input_pin);

                    if(int_pin == logins.get(i).getUserpin()){
                        ds.print("Login Succesfull " + input_name);
                        PrintStream curf = new PrintStream(new File(".current.user"));
                        current_user = input_name;
                        curf.print(current_user+"\r\n");
                        ds.center(1);
                    }
                    
                    else{
                        ds.clear();
                        ds.print("Wrong Pin");
                        ds.center(1);
                    }
               }

               else{
                   ds.print("Wrong Username");
                   ds.center(5);
               }
        }                
            
            //Besked der vises når for-loop'et er færdigt, bruger date variablen
            ds.print("file have been recreated: " + date.toString());
            ds.center(5);

            //catch med FileNotFoundException og en Exception
        } catch(FileNotFoundException e){System.out.println(e);}
        catch(Exception e){System.out.println(e);}  

} //userload

public String getCurrent(){
        try{
        Scanner scancurf = new Scanner(new File(".current.user"));
        current_user = scancurf.next();
        } catch(Exception e){System.out.println(e);}
        return current_user;
    }

public static void userCreate(){
            try{
            ArrayList<Login> logins = new ArrayList<Login>();
            Display ds = new Display();
            LocalDate date = LocalDate.now();

            //Scanning users in user.data
            Scanner scan = new Scanner(new File(".list.user"));
            while(scan.hasNext()){logins.add(new Login(scan.next(), scan.nextInt(), scan.nextInt(), LocalDate.parse(scan.next())));}

            PrintStream file = new PrintStream(new File(".list.user"));

            ds.clear();
            ds.print("Welcome"+"\r\n");
            //tager input og opretter title
            ds.print("Please enter a username: ");
            ds.center(5);
            String username = System.console().readLine();
            //tager input og converter fra string to int.
            
            ds.clear();
            ds.print("Please enter a 4 digit pincode: ");
            ds.center(5);
            String s_userpin = System.console().readLine();
            int userpin = Integer.parseInt(s_userpin);

            //
            while(userpin < 999){
                ds.clear();
                ds.print("Pincode to short. Please enter a 4 digit pincode: ");
                ds.center(5);
                s_userpin = System.console().readLine();
                userpin = Integer.parseInt(s_userpin);
            }

            while(userpin > 10000){
                ds.clear();
                ds.print("Pincode to long. Please enter a 4 digit pincode: ");
                ds.center(5);
                s_userpin = System.console().readLine();
                userpin = Integer.parseInt(s_userpin);
            } 
            
            //tager og sætter userid til antal af users (fra logins arraylisten) og sætter tallet +1
            int userid = logins.size() + 1;
            
            //tilføjer de 4 inputs title/year/rating/date til login arraylisten.
            logins.add(new Login(username,userpin,userid,date));

            /** 
            for-loop som kører efter arraylisten logins længde.
            inde i loopet printer den til file (altså scanname.log) title/year/rating/date og så en ny linje (\r\n)
            Dernæst printer den til consolen de samme 4 variabler.
            */
            for(int i = 0; i < logins.size(); i++){
                file.print(logins.get(i).getUsername() + "\r\n" + logins.get(i).getUserpin() + " " + logins.get(i).getUserid() + " " + new String(logins.get(i).getDate().toString()) + "\r\n");
            }                
            
            //Besked der vises når for-loop'et er færdigt, bruger date variablen
            ds.clear();
            ds.print("Username: "+username);
            ds.print("Pincode: "+userpin);
            ds.print("Your ID: "+userid);
            ds.print("Created: " + date.toString());
            ds.center(2);

            //catch med FileNotFoundException og en Exception
            } catch(FileNotFoundException e){System.out.println(e);}
            catch(Exception e){System.out.println(e);}  

} //usercreate

    } //Class end
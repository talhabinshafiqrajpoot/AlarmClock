
import java.util.Scanner;
public class ClockMain
{
    public static void main(String []args) throws Exception
    {
        System.out.println("-------------------- It is a 12- hour Clock with Alarm -----------------------------");
        System.out.println("-------------------- We Default start this clock from Shift-Am -------------------");
        int hours, minutes, seconds; //variables assigned
        String s = "am"; 
        int hours1=0, minutes1 = 0, seconds1=0;
        int index = 0;
        String s1 = "  ";

        Scanner sc = new Scanner(System.in); //Scanner object is created to read the data from the user.
        System.out.println("Enter Hours, Minutes & Seconds: ");
        
        hours = sc.nextInt(); //for hours
        minutes = sc.nextInt(); //for minutes
        seconds = sc.nextInt(); //for seconds

        Clock c = new Clock(hours, minutes, seconds, "am"); //we create the object of a clock to assign the values to statr the clock. 
        // For ease we start our clock from any time in "Am".
        boolean Alarmstart = false;
        System.out.println("You want to set Alarm:");
        s1 = sc.nextLine();
        System.out.println("1. Yes = write true");
        System.out.println("2. No = write false");
        Alarmstart = sc.nextBoolean(); //we ask user whether he/she wants to set an alarm or not. 

        MusicOrganizer m = new MusicOrganizer(); //make an object of a music organizer class to play music in the clock.
        

        if(Alarmstart){ //if the user agrees to setup the alarm then this "If condition" is used.
            System.out.println("Enter Hours, Minutes & Seconds for Alarm: ");
            
            hours1 = sc.nextInt(); //this will ask the user to input the alarm hour.
            minutes1 = sc.nextInt(); //this will ask the user to input the alarm minutes.
            seconds1 = sc.nextInt(); //this will ask the user to input the alarm seconds.
            m.getNumberOfTracks(); //this will call the method of Music Organizer Class to tell the number of Tracks available in the folder.
            m.listAllTracks(); // this will all Tracks
            //System.out.println("Enter the index number of song you want to play if there is more than one song....(0 to onwards) ");
            //index = sc.nextInt(); //this will ask user to enter the index number of track to be played.
            //m.listTrack(index);

            

        }

        while(true) //we make this infinite loop because we did'nt want to stop our clock when started.
        {
            c.displayClock(); //this will display clock on screen
            for(int i = 0 ; i < 1 ; i++){ //this for loop is used for break statement in the if condition.
                if (Alarmstart) {
                    if (c.hours.getValue() == hours1 && c.minutes.getValue() == minutes1 && c.seconds.getValue() == seconds1 && c.getShift().equals(s1)) {
                        //this is a important condition in which we compare the alarm values to clock values to play song.
                        System.out.println("Alarm is Playing"); //if above statement is true then Alarm starts playing.
                        //m.playTrack(index); //the index we specify previosly is played accordingly.
                        m.playFirst();
                        break; //break statement will take the execution of a program to the outer "while Loop". 
                    }
                }
            }
            
            Thread.sleep(1000); // this will delayed the execution of a  program.
            c.tick(); //this method will do increment Accordingly.
            if (c.hours.getValue()==0 && c.minutes.getValue()==0 && c.seconds.getValue()==0 ) 
            //this "If condition" is used to shift between "AM/PM". 
            {
                if (c.getShift()=="am")
                { //if its Am then converts to pm.
                    c.setShift("pm");
                    System.out.println("**");
                }
                else if (c.getShift()=="pm")
                {   //if its pm then to Am.
                    c.setShift("am");
                    System.out.println("--");
                }
            }

            
        }
    }
}

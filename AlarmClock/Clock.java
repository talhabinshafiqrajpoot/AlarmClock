public class Clock {
    //declare variables of type Digit B
    DigitB hours; 
    DigitB minutes;
    DigitB seconds;
    //declare variables for use.
    String time;
    private String shift;
    int count = 0;

    //     public void setTime(Digit hours, Digit minutes) {}
    //Constructor of a Clock Class.
    public Clock(int hours, int minutes, int seconds, String shift)
    {
        this.hours = new DigitB(hours, 12);
        this.minutes = new DigitB(minutes, 60);
        this.seconds = new DigitB(seconds, 60);
        count = minutes;
        this.shift=shift;
        time = this.hours.display() + ":" + this.minutes.display() + ":" + this.seconds.display()+ " "+ shift;
    }

    public void setTime(int hours, int minutes, int seconds)
    {
        this.hours.setValue(hours);
        this.minutes.setValue(minutes);
        this.seconds.setValue(seconds);
        time = this.hours.display() + ":" + this.minutes.display() + ":" + this.seconds.display()+ " "+ shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }
    
    //this method is used to increment in the hours,minutes,seconds.
    public void tick()
    {
        seconds.increment();

        if(seconds.getValue() == 0)
        {
            minutes.increment();
            count++;
        }

        if(minutes.getValue() == 0 && count == 60)
        {
            hours.increment();
            count = 0;
        }

        time = this.hours.display() + ":" + this.minutes.display() + ":" + this.seconds.display()+ " "+ shift;
    }
    //this method will display time.
    public void displayClock()
    {
        System.out.println(time);
    }

}
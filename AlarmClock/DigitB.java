public class DigitB
{
private int value, limit;

public DigitB(int v, int l)
{
value=v;
limit=l;
}
public void setValue(int v)
{
value=v;
}
public int  getValue()
{
return(value);
}
public void increment()
{
value=(value+1)%limit;
}
public String display()
{
    if(value<10)
        return("0"+value);
    else 
        return(""+value);
}

}
package hi.hbv201g.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Leikur {
    private IntegerProperty stigin = new SimpleIntegerProperty(0);

    public int getStig(){
        return stigin.get();
    }

    public void setStigin(int stig){
        stigin.set(stig);
    }
    public void haekkaStig(){
        stigin.set(stigin.get() + 1);
    }
    public IntegerProperty stiginproperty(){
        return stigin;
    }


}

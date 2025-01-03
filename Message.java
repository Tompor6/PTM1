package test;

import java.util.Date;

public class Message {
    public final byte[] data;
    public final String asText;
    public final double asDouble;
    public final Date date;


    public Message(String asText) {
        this.data = asText.getBytes();
        this.asText = asText;
        this.asDouble = tryParse(this.asText);
        this.date = new Date();
    }

    public Message(byte[] data){
        this(new String(data)) ;
    }

    public Message(double asDouble){
        this(Double.toString(asDouble));
    }

    private double tryParse(String data){
        try{
            return Double.parseDouble(data);
        }catch(NumberFormatException e){
            return Double.NaN;
        }
    }
}

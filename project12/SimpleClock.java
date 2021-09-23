/**
 * SimpleClock.java
 *
 * A class that implements a simple
 *
 * @author Zhenli Min
 *
 */
package osu.cse1223;
public class SimpleClock {

    /* -------- Private member variables --------------------- */
    private int hours;
    private int minutes;
    private int seconds;
    private boolean morning;

    /* -------- Constructor --------------------------------- */
    /**
     * The constructor should set the intial value of the clock to 12:00:00AM.
     */
    public SimpleClock() {
        this.hours=12;
        this.minutes=0;
        this.seconds=0;
        this.morning=true;
    }

    /* --------- Instance methods ------------------------- */

    /**
     * Sets the time showing on the clock.
     * 
     * @param hh
     *            - the hours to display
     * @param mm
     *            - the minutes to display
     * @param ss
     *            - the seconds to display
     * @param morning
     *            - true for AM, false for PM
     */
    public void set(int hh, int mm, int ss, boolean morning) {
    	this.hours=hh;
        this.minutes=mm;
        this.seconds=ss;
        this.morning=morning;
    }

    /**
     * Advances the clock by 1 second. Make sure when implementing this method
     * that the seconds "roll over" correctly - 11:59:59AM should become
     * 12:00:00PM for example.
     */
    public void tick() {
        this.seconds++;
        if(this.seconds==60) {
        	this.seconds=0;
        	this.minutes++;
        }
        if(this.minutes==60) {
        	this.hours++;
        	if(this.hours==12) {
        		this.morning=!this.morning;
        	}
        }
        if(this.hours==13) {
        	this.hours=1;
        }
    }

    /**
     * Returns a string containing the current time formatted as a digital clock
     * format. For example, midnight should return the string "12:00:00AM" while
     * one in the morning would return the string "1:00:00AM" and one in the
     * afternoon the string "1:00:00PM".
     *
     * @return - the current time formatted in AM/PM format
     */
    public String time() {
        String time = getPrintTime(this.hours)+":"
        		+getPrintTime(this.minutes)+":"
        		+getPrintTime(this.seconds)
        		+(morning?"AM":"PM");

        // Note - the return statement below is included only to
        // remove errors from the skeleton.  Remove this comment and
        // replace it with the correct return value.
        return time;
    }
    
    private static String getPrintTime(int originTime) {
    	String result="";
    	if(originTime/10==0) {
    		result+="0"+originTime;
    	}
    	else {result+=originTime;
    	}
    	return result;
    }

}

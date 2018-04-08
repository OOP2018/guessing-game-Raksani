/**
 * A simple counter.
 */

public class Counter extends java.util.Observable {
	private int count;
	private String msg;

	public Counter() {
		this.msg = "Let Play";
		this.count = 0;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
    public void resetMsg(){
		msg = "Let Play";
	}
	public void newSet(){
		setChanged();
		notifyObservers();
	}
	public void add(int howMuch) {
		count += howMuch;
	}

	public void resetCount(){
		this.count = 0;
	}
	public int getCount() {
		return count;
	}
}

package main;

public class File extends Document{

	private String pathname;
	
	public String toString(){
		return "Path: " + getPathname() + "\n" + this.text;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}
}

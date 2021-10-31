package second;

public class Main {
	public static void main(String[] args) {
		Storing_Device str1 = new Storing_Device("USB");
		str1.addSong("singer1", "song1");
		str1.addSong("1", "123");
		str1.printListOfSongs();

		Storing_Device str2 = new Storing_Device("CD");

		Play_Device pl1 = new Play_Device("USB");
		pl1.setStoringDevice(str1);
		pl1.setSong(1);
		pl1.printCurrentSong();

		pl1.setStoringDevice(str2);
	}

}
package second;

public class Main {
	public static void main(String[] args) {
		CD_Storage str1 = new CD_Storage();
		str1.addSong("singer1", "song1");
		str1.addSong("1", "123");
		str1.printListOfSongs();

		USB_Storage str2 = new USB_Storage();

		CD_Player pl1 = new CD_Player();
		pl1.setStoringDevice(str1);
		pl1.setSong(1);
		pl1.printCurrentSong();

		System.out.println(str2.toString());

		pl1.setStoringDevice(str2);
	}

}
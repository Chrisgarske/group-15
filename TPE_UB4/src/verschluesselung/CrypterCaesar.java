package verschluesselung;

public class CrypterCaesar implements Crypter {
	// Methode für verschlüsselung
	private String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };


	public String klartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	@Override
	public String verschluesseln(String key, String message)
		//	throws IllegalKeyException, IllegalMessageException 
	{

		int stelle = 0;

		boolean gefunden = true;
		for (int i = 0; i < alpha.length && gefunden; i++) {
			if (key == alpha[i]) {
				stelle = i + 1;
				gefunden = false;
			}
		}
		int caesar = -1;
		String text = "";
		String geheimText = "";
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if(klartext.charAt(j) == message.charAt(i)){
					caesar = j + stelle;
					if(caesar > 25){
						caesar = caesar - 26; 
					}
//					System.out.println(klartext.substring(caesar, caesar+1));
					text = klartext.substring(caesar, caesar + 1); 
					geheimText += text;
				}
			}
			
		}

		return geheimText;
	};

	@Override
	public String entschluesseln(String key, String cypherText)
			//throws IllegalKeyException, IllegalMessageException 
	{
		
		int stelle = 0;

		boolean gefunden = true;
		for (int i = 0; i < alpha.length && gefunden; i++) {
			if (key == alpha[i]) {
				stelle = i + 1;
				gefunden = false;
			}
		}
		int caesar = -1;
		String text = "";
		String decodierung = "";
		for (int i = 0; i < cypherText.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if(klartext.charAt(j) == cypherText.charAt(i)){
					caesar = j - stelle;
					if(caesar < 0){
						caesar = 26 + caesar; 
					}
					text = klartext.substring(caesar, caesar + 1); 
					decodierung += text;
				}
			}
			
		}
		
		return decodierung;
	};

}

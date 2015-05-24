package verschluesselung;

public class CrypterSubstitution implements Crypter {
	// Methode f�r verschl�sselung

	private String klartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String verschlusselt = "UFLPWDRASJMCONQYBVTEXHZKGI";

	@Override
	public String verschluesseln(String key, String message){
	// throws IllegalKeyException, IllegalMessageException
		String geheimeBotschaft = " ";
		String endergebnis = "";
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if (message.charAt(i) == klartext.charAt(j)) {
					geheimeBotschaft = verschlusselt.substring(j, j + 1);
					endergebnis = endergebnis + geheimeBotschaft;
				}

			}

		}

		return endergebnis;

	}

	@Override
	public String entschluesseln(String key, String cypherText){
	// throws IllegalKeyException, IllegalMessageException
			String decodierung = " ";
			String endDecodierung = "";
			for (int i = 0; i < cypherText.length(); i++) {
				for (int j = 0; j < verschlusselt.length(); j++) {
					if (cypherText.charAt(i) == verschlusselt.charAt(j)) {
						decodierung = klartext.substring(j, j + 1);
						endDecodierung = endDecodierung + decodierung;
					}

				}

			}

			return endDecodierung;

		}

}

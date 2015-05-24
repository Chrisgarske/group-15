package verschluesselung;

public class CrypterSubstitution implements Crypter {
	// Methode für verschlüsselung

	private String klartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String verschlusselt = "UFLPWDRASJMCONQYBVTEXHZKGI";

	@Override
	public String verschluesseln(String key, String message)
	// throws IllegalKeyException, IllegalMessageException
	{
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
	public String entschluesseln(String key, String cypherText)
			throws IllegalKeyException, IllegalMessageException {
		// TODO Auto-generated method stub
		return null;
	}
}

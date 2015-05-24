package verschluesselung;

public class CrypterSubstitution implements Crypter {
	// Methode für verschlüsselung

	private String klartext = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String verschlusselt = "UFLPWDRASJMCONQYBVTEXHZKGI";

	@Override
	public String verschluesseln(String key, String message)
	// throws IllegalKeyException, IllegalMessageException
	{
		String geheimeBotschaft= " ";
		for (int i = 0; i < message.length(); i++) {
			for (int j = 0; j < klartext.length(); j++) {
				if(message.charAt(i)==klartext.charAt(j)){
					i=j;
					char c=' ';
					c=verschlusselt.charAt(i);
					System.out.println(c);
					//ich komme nicht mehr weiter :D
				}
				
			}
			
		}
		return geheimeBotschaft;
		
	}
@Override
public String entschluesseln(String key, String cypherText)
		throws IllegalKeyException, IllegalMessageException {
	// TODO Auto-generated method stub
	return null;
}
}

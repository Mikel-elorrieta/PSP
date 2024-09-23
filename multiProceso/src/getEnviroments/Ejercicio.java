package getEnviroments;

import java.util.Map;

public class Ejercicio {

	public static void main(String[] args) {

		// obtener la infromacion del proceso

		Map<String, String> enviroment = new ProcessBuilder().environment();

	

		for (String key : enviroment.keySet()) {
			System.out.println("Variable " + key + " : " + enviroment.get(key));

		}

	}

}

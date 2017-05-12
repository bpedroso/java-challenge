package com.bpedroso.challenge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Desciption: 
 * 	Dada uma stream, encontre o primeiro caractere Vogal, após uma consoante, onde a mesma é antecessora a uma vogal 
 * e que não se repita no resto da stream. O termino da leitura da stream deve ser garantido através do método hasNext(), 
 * ou seja, retorna falso para o termino da leitura da stream. Voce tera acesso a leitura da stream através dos métodos de 
 * interface fornecidos ao termino do enunciado.
 * 
 * Premissas:
 * 	Uma chamada para hasNext() ir retornar se a stream ainda contem caracteres para processar.
 * 	Uma chamada para getNext() ir retornar o proximo caractere a ser processado na stream.
 * 	Não será possível reiniciar o fluxo da leitura da stream.
 * 	Não poderá ser utilizado nenhum framework Java, apenas código nativo.
 * 
 * Exemplo:
 * 	Input:  aAbBABacafe
 * 	Output: e
 */
public class FindVowel {

	public static char firstChar(Stream input) throws VowelNotFoundException {
		// Key - Character - caracter encontrato
		// value - Boolean - indica se é repitido
		final LinkedHashMap<Character, Boolean> chars = new LinkedHashMap<Character, Boolean>();
		char last = 0, nextToLast = 0;

		while (input.hasNext()) {
			char cur = input.next();
			if (isVowel(cur) && !isVowel(last) && isVowel(nextToLast)) {
				// verify repeated char
				if (chars.containsKey(cur))
					chars.put(cur, false);
				else
					chars.put(cur, true);
			}
			nextToLast = last;
			last = cur;
		}

		// map to first repeated word
		return chars.entrySet().stream().filter(Entry::getValue).findFirst().map(Map.Entry::getKey).orElseThrow(VowelNotFoundException::new);
	}

	private static boolean isVowel(char c) {
		final String vowels = "aeiouAEIOU";
		return vowels.indexOf(c) >= 0;
	}

}

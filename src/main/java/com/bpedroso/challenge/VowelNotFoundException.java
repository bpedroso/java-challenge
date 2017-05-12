package com.bpedroso.challenge;

public class VowelNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public VowelNotFoundException() {
		super("Não foi encontrada vogal seguida de consoante que segue outra vogal.");
	}
}

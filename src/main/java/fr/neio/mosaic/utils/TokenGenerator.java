package fr.neio.mosaic.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TokenGenerator {

	private SecureRandom random = new SecureRandom();

	public String nextToken() {
		return new BigInteger(130, random).toString(32);
	}
}

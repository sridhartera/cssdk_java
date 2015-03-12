package com.demo;

import org.apache.log4j.Logger;

import com.interwoven.cssdk.access.CSAuthorizationException;
import com.interwoven.cssdk.access.CSExpiredSessionException;
import com.interwoven.cssdk.common.CSClient;
import com.interwoven.cssdk.common.CSRemoteException;

public class HelloWorld {
	private static CSClient myclient;
	private static Logger LOGGER = Logger.getLogger(HelloWorld.class);
	
	public static void main (String[] args) throws CSAuthorizationException, CSExpiredSessionException, CSRemoteException, com.interwoven.cssdk.common.CSException {
			GetClient gc = new GetClient();
			myclient = gc.getClient();
			
			
		
		
		
	}
	
	
	
}

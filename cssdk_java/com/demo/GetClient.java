package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import com.interwoven.cssdk.common.CSClient;
import com.interwoven.cssdk.common.CSException;
import com.interwoven.cssdk.factory.CSFactory;
import com.interwoven.cssdk.factory.CSFactoryInitializationException;

public class GetClient {
     private CSFactory factory = null;
     private CSClient client = null;

    public GetClient(){
    	loadProperties();		
    }
    
    public CSFactory getFactory() {
		return factory;
	}
	public CSClient getClient() {
		return client;
	}
    
	public void loadProperties(){    
    	String username, password, role;
    	String name = null;
    	// read the factory type from a properties file
		Properties props=new Properties();
	    try {
	      props.load(new FileInputStream("sample.properties"));
	    } catch ( FileNotFoundException fnf ) {
	      System.out.println( "The properties file was not found" );
	    } catch ( IOException io ) {
	      System.out.println( "Some type of I/O exception has occurred" );
	    }
	    // create the factory
	    try {
	      factory=CSFactory.getFactory(props);
	      name = factory.getClass().getName();
	    } catch (CSFactoryInitializationException fie) {
	      System.out.println("The factory cannot be initialized");
	      fie.printStackTrace();
	    }
		System.out.println( "Factory of type " + name + " created" );
		System.out.println("Factory object created!");
		

		username = props.getProperty("username");
		password = props.getProperty("password");
		role = props.getProperty("role");

	    try {
	      System.out.println( "Getting client with username " + username + ", password " + password + ", and role " + role );
	      client = factory.getClient( username, role,
	                                  password, Locale.getDefault(),
	                                  "mydemo", null );
	
	      System.out.println( "Client object obtained" );
	
	    } catch ( CSException e ) {
	      System.out.println( "An exception occurred" );
	      e.printStackTrace();
	    } 
	    /*finally {
	      if ( client != null ) {
	        client.endSession();
	      }
	    }*/
	}
	public void endClientSession(CSClient client){
		this.client = client;
		if ( client != null ) {
	          client.endSession();
	          System.out.println("Session ended");
		}
	       				
	}
}

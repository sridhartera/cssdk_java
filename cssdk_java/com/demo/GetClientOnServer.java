package com.demo;

/*
 * INTERWOVEN, INC. PROPRIETARY AND CONFIDENTIAL
 *
 *
 * Copyright 2003 Interwoven, Inc.  All rights reserved.
 *
 * Use of this product is subject to license terms.  If this product
 * is acquired by the United States Government or any contractor
 * therefor, then the Government's rights in this product and related
 * documentation, which are "commercial computer software" and
 * "commercial computer documentation", respectively, will be only as
 * set forth in such license terms as specified in: (i) for
 * acquisitions by or on behalf of civilian agencies, 48 C.F.R. 12.212
 * of the Federal Acquisition Regulations and its successors; and (ii)
 * for acquisition by or on behalf of units of the Department of
 * Defense ("DoD"), in 48 C.F.R. 227.7202-1 through 227.7202-4 of the
 * DoD F.A.R. Supplement and its successors.  All United States
 * Government end users acquire this product with only those rights
 * set forth in such license terms.
 *
 *
 *
 */

import com.interwoven.cssdk.factory.*;
import com.interwoven.cssdk.common.*;
import com.interwoven.cssdk.access.*;
import java.util.*;
import java.io.*;


@SuppressWarnings("unused")
public class GetClientOnServer {
    
  public static void main(String[] args) {

    CSFactory factory = null;
    CSClient client = null;
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
      System.out.println("Type read from properties file");

    try {
      client = factory.getClientForCurrentUser(Locale.getDefault(), "mydemo", null);
      
      System.out.println( "Client object obtained" );
      System.out.println( "Client object String: "+ client.toString() );

    } catch ( CSException e ) {
      System.out.println( "An exception occurred" );
      e.printStackTrace();
    } 
      finally {
      if ( client != null ) {
        client.endSession();
      }
    }
  }
}
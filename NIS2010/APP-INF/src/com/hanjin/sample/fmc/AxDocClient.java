/**
* <pre>
* Class ����   :   Document Type WebServices Class
*
* </pre>
* 
* Get Information : http://www.hanjin.com 
* 
* Copyright (C) 2007   Hyunsu Ryu, hsyoo71@cyberlogitec.com
* 
* @FileName : AxDocClient.java
* @FileTitle : Axis Synchronous Document type Client. 
* @LastModifyDate : 2007. 01. 22. 
* @LastModifier : Hyunsu, Ryu. 
* @LastVersion 	: 1.5
*  
*/
package com.hanjin.sample.fmc;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPBodyElement;
import org.apache.axis.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.jf.transfer.AbstractSendEai;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.common.EaiLogExecutor;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.eai.util.DateFormat4Performance;
import com.jf.transfer.eai.util.FrmCommon;


/**    
 * <pre>
 * This client for late binding invocation
 * of a wrapped document-style Web Service with Axis 1_4 .</b>
 * - You have to set target URL and Message or XmlObject . 
 *  
 * When you have to call constructor with target URL. 
 * example below : 
 * 
 *      String reString = "" ;
 *      TransferEAI eai = new AxDocClient("http://203.246.152.72:9700/orabpel/default/HelloWorld/1.0/HelloWorld");
 *      eai.setMessage(<< XmlObject >>);
 *      try{
 *              reString = eai.Commit();
 *              
 *      } catch (EAIException e) {
 *          e.printStackTrace();
 *      } 
 *      
 * <pre>
 * 
 * @author          :   Hyunsu, Ryu 
 * @version         :   1.0
 * @since           :   JDK1.4.2_09
 * @see             :   com.jf.transfer.AbstractEai
*/
public class AxDocClient extends AbstractSendEai {

    protected String SOAPACTION_URI_PROPERTY = "process";
    protected String OPERATION_STYLE_PROPERTY = "document";
    
    
    /**
     * Apache Log4j Logger !
     */
     protected transient org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(this.getClass().getName());

    String error_head = "Synchronous Document-style Web Service : ERROR_MESSAGE=";

        
    /**
     *  Axis Document Type Client Constructor whit Target URL ! 
     *  
     * @param tu
     * @throws IOException 
     */
    public AxDocClient( String tu, Class c )
    {
    	setTarget(tu);
    	setEaiType(TransferEAI.WS_SY_DOC);
        setBound("O");
    	setCaller(c.getName());
    }

    
    /**
     * Execute transfer message to EAI 
     */
    public String commit( String instanceID ) throws EAIException {
    			
    	if (isLoggable()) {
    		logger.info("Current Instance ID: " + instanceID);
    	}
    	setIntegrationID(instanceID);
        // 1. Service and connection related stuff
        // 1.1 Create a new service ...
        Service  service = new Service();
              
        Call call;
        Element resultElement;
        Document doc;
        Vector resultVector;
        
        // Start count by StopWatch
        setElapsedTime(System.currentTimeMillis());

        // seperate log file 
        if(isLoggable())
        {
        	logger = org.apache.log4j.Logger.getLogger(this.getClass().getName()+"."+getDestination());
        }

        if( logger.isDebugEnabled())
        {
        	logger.debug(FrmCommon.makeLog4EaiString("Synchronous Document-style Web Service STARTED("+ 
    	    DateFormat4Performance.getCurrentTimestampString() +")!"));
        }
        
        try {

    		call = (Call) service.createCall();
        
            call.setProperty(Call.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
            call.setProperty(Call.SOAPACTION_URI_PROPERTY, SOAPACTION_URI_PROPERTY);
            call.setProperty(Call.OPERATION_STYLE_PROPERTY , OPERATION_STYLE_PROPERTY);
        
            // 1.2 ... an define the endpoint (service address)
            call.setTargetEndpointAddress( new URL(getTarget()) );
            
            if(!super.getUserId().equals("")){
            	call.setProperty(call.USERNAME_PROPERTY, super.getUserId());
    		}
            
            if(!super.getUserPasswd().equals("")){
            	call.setProperty(call.PASSWORD_PROPERTY, super.getUserPasswd());
            }
            
            if(!super.getDestination().equals("")){
            	call.setSOAPActionURI(super.getDestination());
            }
            
            if( logger.isDebugEnabled())
            {
            	logger.debug("AxDocClient getCallTimeOut() ["+    getCallTimeOut() +"]");
            }
           	call.setTimeout( new Integer((int)getCallTimeOut()) );
            
            // 3. Invocation of the service
            // 3.1 Now we have to create one new SOAPBody element for our request ...
            SOAPBodyElement[] request = new SOAPBodyElement[1];
            // 3.2 ... and we add to this our request document

            // Create a builder factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true); // xml validation check 

            // Create the builder and parse the file
            if( getObj() == null ) doc = factory.newDocumentBuilder()
                            .parse(new ByteArrayInputStream(getMessage().getBytes(getEncodingType())));
            else  doc = factory.newDocumentBuilder()
                            .parse(new ByteArrayInputStream(getObj().toString().getBytes(getEncodingType())));

            // seperate log file 
            if(isLoggable())
            {
            	logger.info(doc.toString());
            }
            
            // Make SOAP Body Element 
            request[0] = new SOAPBodyElement(doc.getDocumentElement());
        
            // 3.3 And now the real invocation
            resultVector = (Vector) call.invoke( request );

            // Process Completed.   
            if( logger.isDebugEnabled())
            {
            	logger.debug(FrmCommon.makeLog4EaiString("Synchronous Document-style Web Service SUCCESS(Elapsed:"+ 
        	    getElapsedTime() +"/1000) !"));
            }

            // 4. Extracting the result document
            // 4.1 Wrapped document style web services will return only one document
            SOAPBodyElement resultElements = (SOAPBodyElement) resultVector.get(0);
            // 4.2 We convert it to a DOM object for later processing
            resultElement  = resultElements.getAsDOM();

//            logger.info( FrmCommon.makeLog4Eai("O", "T("+super.getElapsedTime()+")", getObj()==null?getMessage():getObj().toString(), "") );
            
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, null);
            
        } catch (ServiceException e) {
            String eXception = error_head + super.getEaiInfo() +"\n Service Exception : " + getStackTraceString(e);
			setConnResult("CF(" + getElapsedTime() + ")");
			setResultMessage(eXception);
            if( logger.isInfoEnabled())
            {
            	logger.info( FrmCommon.makeLog4EaiSQL(this) );
            }
            
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, eXception);
            
            throw new EAIException(eXception);
        } catch (MalformedURLException e) {
        	String eXception = error_head + super.getEaiInfo() +"\n Malformed URL Exception : " + getStackTraceString(e);
			setConnResult("CF(" + getElapsedTime() + ")");
			setResultMessage(eXception);
            if( logger.isInfoEnabled())
            {
            	logger.info( FrmCommon.makeLog4EaiSQL(this) );
            }
            
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, eXception);
            
            throw new EAIException(eXception);
		} catch (UnsupportedEncodingException e) {
	        String eXception = error_head + super.getEaiInfo() +"\n Unsupported Encoding Exception : " + getStackTraceString(e);
			setConnResult("CF(" + getElapsedTime() + ")");
			setResultMessage(eXception);
            if( logger.isInfoEnabled())
            {
            	logger.info( FrmCommon.makeLog4EaiSQL(this) );
            }
	        
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, eXception);
            
            throw new EAIException(eXception);
		} catch (SAXException e) {
	        String eXception = error_head + super.getEaiInfo() +"\n SAX Exception : " + getStackTraceString(e);
			setConnResult("CF(" + getElapsedTime() + ")");
			setResultMessage(eXception);
            if( logger.isInfoEnabled())
            {
            	logger.info( FrmCommon.makeLog4EaiSQL(this) );
            }
	        
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, eXception);
            
            throw new EAIException(eXception);
		} catch (IOException e) {
	        String eXception = error_head + super.getEaiInfo() +"\n IO Exception : " + getStackTraceString(e);
			setConnResult("CF(" + getElapsedTime() + ")");
			setResultMessage(eXception);
            if( logger.isInfoEnabled())
            {
            	logger.info( FrmCommon.makeLog4EaiSQL(this) );
            }
	        
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, eXception);
            
            throw new EAIException(eXception);
		} catch (ParserConfigurationException e) {
	        String eXception = error_head + super.getEaiInfo() +"\n Parser Configuration Exception : " + getStackTraceString(e);
			setConnResult("CF(" + getElapsedTime() + ")");
			setResultMessage(eXception);
            if( logger.isInfoEnabled())
            {
            	logger.info( FrmCommon.makeLog4EaiSQL(this) );
            }
            
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, eXception);
            
	        throw new EAIException(eXception);
		} catch (InterruptedException e) {
	        String eXception = error_head + super.getEaiInfo() +"\n Interrupted Exception : " + getStackTraceString(e);
			setConnResult("CF(" + getElapsedTime() + ")");
			setResultMessage(eXception);
            if( logger.isInfoEnabled())
            {
            	logger.info( FrmCommon.makeLog4EaiSQL(this) );
            }
            
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, eXception);
            
	        throw new EAIException(eXception);
		} catch (Exception e) {
	        String eXception = error_head + super.getEaiInfo() +"\n Exception : " + getStackTraceString(e);
			setConnResult("CF(" + getElapsedTime() + ")");
			setResultMessage(eXception);
            if( logger.isInfoEnabled())
            {
            	logger.info( FrmCommon.makeLog4EaiSQL(this) );
            }
            
         // Adds new log data into EAI_FW_IF_LOG table
            saveLogData(instanceID, eXception);
			
	        throw new EAIException(eXception);
		}
       
  
		setConnResult("CT("+getElapsedTime()+")");
		setResultMessage("COMMIT");
        if( logger.isInfoEnabled())
        {
        	logger.info( FrmCommon.makeLog4EaiSQL(this) );
        }
		return XMLUtils.ElementToString(resultElement);
    }
    
    /*
     * Helper Method - Fills out parameters for SQL Statement
     */
    private void saveLogData(String instanceID, String errorMsg) {
    	try {
    		new EaiLogExecutor(instanceID, "O", errorMsg, "WS");
    	} catch (Exception e) {
//    		logger.info("Save Log Data Execute Error : [" + e.getMessage()+"] Data["+instanceID+"]");
    	}

    }

	public void close()
	{
		setConnResult("CT("+getElapsedTime()+")");
		setResultMessage("CLOSE");
//        if( logger.isInfoEnabled())
//        {
//        	logger.info( FrmCommon.makeLog4EaiSQL(this) );
//        }
		setMessage("");
		setObj(null);
	}

	public void rollback(Exception e)
	{
	    StringBuilder eString = new StringBuilder(error_head + getEaiInfo() + "\n WS SY DOC RollBack : " + getStackTraceString(e) );
		setConnResult("RF("+getElapsedTime()+")");
		setResultMessage(eString.toString());
//		logger.error( FrmCommon.makeLog4EaiSQL(this));
	}


	@Override
	public String getHeaderMessage() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUsrHeaderMsg(String property) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setHeaderMessage(String Msg) {
		// TODO Auto-generated method stub
		
	}

    
}
/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : FaxResultUpdate.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Sep 30, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.syscommon.fax.servicesio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import weblogic.jws.WLHttpTransport;

import com.hanjin.framework.component.fax.servicesio.FaxResultUpdate;

/**
 * It's FaxResultUpdate.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Sep 30, 2009
 */
@WebService(name="FaxResultUpdatePortType", serviceName="FaxResultUpdate",
        targetNamespace="http://www.hanjin.com/integration")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/FaxResultUpdate",
             portName="FaxResultUpdatePort")
public class FaxResultUpdateProxy extends FaxResultUpdate{
	
	/**
	 * This method 
	 * @author Jeong-Hoon, KIM
	 * @param sendMsg
	 * @return
	 */
	@WebMethod()
	public String updateResult(String sendMsg) {
		return super.updateResult(sendMsg);
	}
}

/*========================================================
*Copyright(c) 2011 CyberLogitec
*ProcessChain    : BST
*@FileName       : Sap0030001ReceiveWSProxy.java
*@FileTitle      : Homepage Admin에서 User 정보 ALPS 로 I/F
*@Author         : Kuk-Hee, Kim
*Open Issues     :
*Change history  : 
*@LastModifyDate : 2013. 9. 23.
*@LastModifier   : Kuk-Hee, Kim
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.syscommon.management.alps.servicesio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.syscommon.management.alps.UserManagementSC;
import com.hanjin.syscommon.management.alps.user.event.UserManagementEvent;
import com.hanjin.syscommon.management.alps.user.vo.ComUserVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alpsws.SAP0030001Document;
import com.hanjin.irep.alpsws.SAP0030001Document.SAP0030001;
import com.hanjin.irep.alpsws.SAP0030001Document.SAP0030001.DataArea;
import com.hanjin.irep.alpsws.SAP0030001Document.SAP0030001.DataArea.ADMCollection;
import com.hanjin.irep.alpsws.SAP0030001Document.SAP0030001.DataArea.ADMCollection.ADMRequest;
import com.hanjin.irep.alpsws.SAP0030001Document.SAP0030001.DataArea.ADMCollection.ADMResponse;


/**
 * Sap0030001ReceiveWSProxy.java
 * @author Kuk-Hee, Kim
 * @see 
 * @since J2SE 1.6
 * 2013. 9. 23.
 */
@WebService(name="Sap0030001ReceiveWSProxyPortType", serviceName="Sap0030001ReceiveWSProxy",
targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
 use=SOAPBinding.Use.LITERAL,
 parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/Sap0030001ReceiveWSProxy",
     portName="Sap0030001ReceiveWSProxyPort")

public class Sap0030001ReceiveWSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * Homepage 에서 I/B 한국 세관 Bonded Type 정보 생성시 ALPS 로 I/F<br>
	 * 
	 * @author Kuk-Hee, Kim
	 * @category SAP003_0001
	 * 
	 * @param SAP0030001Document sap0030001Document
	 * @return String
	 */
	@WebMethod()
	public String sap0030001ReceiveWS(SAP0030001Document sap0030001Document){
		
		//WebService EAI Result
		String result = "N";
		
		ComUserVO vo = new ComUserVO();
		UserManagementSC userManagementSC = new UserManagementSC();
		
		try{
			// ========= Validation Parameters for WebServices ========= 
			if( sap0030001Document == null || "".equals(sap0030001Document) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI02);
			// ========= Command Add ===============
			
			UserManagementEvent event = new UserManagementEvent();
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
			SAP0030001 sap0030001doc = sap0030001Document.getSAP0030001();
			
			DataArea dataArea = sap0030001doc.getDataArea();
			ADMCollection admCollection = dataArea.getADMCollection();
			ADMRequest[] admRequests = admCollection.getADMRequestArray();
			ADMResponse documentResponse = admCollection.getADMResponse();
			
			//USER ID
			String usrId = "";
			//MOBILE APPROVAL STATUS CODE
			String mblApstsCd = "";
			//MOBILE DEVICE ID
			String mblDvcId = "";
			//UPDATE USER ID
			String updUsrId = "";
			//UPDATE DATE
			String updDt = "";

			
			for(ADMRequest admRequest:admRequests){
				usrId = admRequest.getUsrId();
				mblApstsCd = admRequest.getMblApstsCd();
				mblDvcId = admRequest.getMblDvcId();
				updUsrId = admRequest.getUpdUsrId();
				updDt = admRequest.getUpdDt();
				
				vo.setUsrId(usrId);
				vo.setMblApstsCd(mblApstsCd);
				vo.setMblDvcId(mblDvcId);
				vo.setUpdUsrId(updUsrId);
				vo.setUpdDt(updDt);
		        event.setComuservo(vo);
		        
		        log.info(":::::>>> sap0030001Document : " + vo.getColumnValues());
				
				//존재하지 않는 경우 EAI처리 실패
				if ((usrId == null || "".equals(usrId))
						|| (mblApstsCd == null || "".equals(mblApstsCd))
						|| (mblDvcId == null || "".equals(mblDvcId))
						|| (updUsrId == null || "".equals(updUsrId))
						|| (updDt == null || "".equals(updDt))) {	
					
					throw new EventException("Invalid RQST DATE");
					
				} else {
					
					EventResponse eventResponse = userManagementSC.perform(event);
					if (eventResponse != null) {
						if(eventResponse.getUserMessage() != null && !"".equals(eventResponse.getUserMessage())){
							result = "Y";
						}
					} else {
						log.debug("eventResponse is null.");
					}
				}
				if (documentResponse != null) {
					result = "Y";
					documentResponse.setComUserScsFlg(result);
				}
			}
			
			log.info(":::::>>> sap0030001Document : " + sap0030001Document);
		
		}  catch (Exception ex){
			log.error(ex.getMessage(), ex);
		}
		
		return result;
	}
}


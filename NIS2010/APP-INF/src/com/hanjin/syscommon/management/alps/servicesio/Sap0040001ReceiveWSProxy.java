/*========================================================
*Copyright(c) 2013 CyberLogitec
*ProcessChain    : BST
*@FileName       : Sap0040001ReceiveWSProxy.java
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
import com.hanjin.irep.alpsws.SAP0040001Document;
import com.hanjin.irep.alpsws.SAP0040001Document.SAP0040001;
import com.hanjin.irep.alpsws.SAP0040001Document.SAP0040001.DataArea;
import com.hanjin.irep.alpsws.SAP0040001Document.SAP0040001.DataArea.ADMCollection;
import com.hanjin.irep.alpsws.SAP0040001Document.SAP0040001.DataArea.ADMCollection.ADMRequest;
import com.hanjin.irep.alpsws.SAP0040001Document.SAP0040001.DataArea.ADMCollection.ADMResponse;


/**
 * Sap0040001ReceiveWSProxy.java
 * @author Kuk-Hee, Kim
 * @see 
 * @since J2SE 1.6
 * 2013. 9. 23.
 */
@WebService(name="Sap0040001ReceiveWSProxyPortType", serviceName="Sap0040001ReceiveWSProxy",
targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
 use=SOAPBinding.Use.LITERAL,
 parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/Sap0040001ReceiveWSProxy",
     portName="Sap0040001ReceiveWSProxyPort")

public class Sap0040001ReceiveWSProxy {
	
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	  
	/**
	 * Homepage 에서 I/B 한국 세관 Bonded Type 정보 생성시 ALPS 로 I/F<br>
	 * 
	 * @author Kuk-Hee, Kim
	 * @category SAP004_0001
	 * 
	 * @param SAP0040001Document sap0040001Document
	 * @return String
	 */
	@WebMethod()
	public String sap0040001ReceiveWS(SAP0040001Document sap0040001Document){
		
		//WebService EAI Result
		String result = "N";
		
		ComUserVO vo = new ComUserVO();
		UserManagementSC userManagementSC = new UserManagementSC();
		
		try{
			// ========= Validation Parameters for WebServices ========= 
			if( sap0040001Document == null || "".equals(sap0040001Document) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI03);
			// ========= Command Add ===============
			
			UserManagementEvent event = new UserManagementEvent();
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
			SAP0040001 sap0040001doc = sap0040001Document.getSAP0040001();
			
			DataArea dataArea = sap0040001doc.getDataArea();
			ADMCollection admCollection = dataArea.getADMCollection();
			ADMRequest[] admRequests = admCollection.getADMRequestArray();
			ADMResponse documentResponse = admCollection.getADMResponse();
			
			//USER ID
			String usrId = "";
			//MBL_SPR_ADM_FLG
			String mblSprAdmFlg = "";
			//UPDATE USER ID
			String updUsrId = "";
			//UPDATE DATE
			String updDt = "";

			
			for(ADMRequest admRequest:admRequests){
				usrId = admRequest.getUsrId();
				mblSprAdmFlg = admRequest.getMblSprAdmFlg();
				updUsrId = admRequest.getUpdUsrId();
				updDt = admRequest.getUpdDt();
				
				vo.setUsrId(usrId);
				vo.setMblSprAdmFlg(mblSprAdmFlg);
				vo.setUpdUsrId(updUsrId);
				vo.setUpdDt(updDt);
		        event.setComuservo(vo);
		        
		        log.info(":::::>>> sap0040001Document : " + vo.getColumnValues());
				
				//존재하지 않는 경우 EAI처리 실패
				if ((usrId == null || "".equals(usrId))
						|| (mblSprAdmFlg == null || "".equals(mblSprAdmFlg))
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
			
			log.info(":::::>>> sap0040001Document : " + sap0040001Document);
		
		}  catch (Exception ex){
			log.error(ex.getMessage(), ex);
		}
		
		return result;
	}
}


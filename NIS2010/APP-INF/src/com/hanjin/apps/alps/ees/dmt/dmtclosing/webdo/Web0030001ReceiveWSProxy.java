/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Web0030001ReceiveWSProxy.java
*@FileTitle : Web0030001ReceiveWSProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2011-10-20
*@LastModifier : Kwon Min
*@LastVersion : 1.0
* 2011-10-20 Kwon Min 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.event.WebDoLinkEvent;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo.IfSchemaVO;
//import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
//import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.irep.alpsws.WEB0030001Document;
import com.hanjin.irep.alpsws.WEB0030001Document.WEB0030001;
import com.hanjin.irep.alpsws.WEB0030001Document.WEB0030001.DataArea;
import com.hanjin.irep.alpsws.WEB0030001Document.WEB0030001.DataArea.InfoCollection;
import com.hanjin.irep.alpsws.WEB0030001Document.WEB0030001.DataArea.InfoCollection.Request;
import com.hanjin.irep.alpsws.WEB0030001Document.WEB0030001.DataArea.InfoCollection.Response;

/**
 * EtsLink 에 대한 WebService Proxy<br>
 *
 * @author	Kwon Min
 * @see		Web0030001ReceiveRSC 참조
 * @since	J2EE 1.6
 */

@WebService(name="Web0030001ReceiveWSProxyPortType", serviceName="Web0030001ReceiveWSProxy",
        targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/Web0030001ReceiveWSProxy",
             portName="Web0030001ReceiveWSProxyPort")
        
public class Web0030001ReceiveWSProxy {
    /**
     * Log
     */
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 서비스명 제공
     * 
     * @param id String
     * @return String response
     */
    public String getServiceName(String id) {
    	return "WebDoLink Web-Service : " + id + " >> Deployed Date is 2011.10.20";
    }

    /**
     * CUP Delivery Order Creaion I/F
     * 
     * @param docIn WEB0030001Document
     * @return  boolean
     */
    @WebMethod()
    //public boolean multiUsDo (IfSchemaVO docIn) {
    public String web0030001ReceiveWS(WEB0030001Document docIn){
    	Web0030001ReceiveRSC	rsc		= new Web0030001ReceiveRSC();
    	IfSchemaVO vo = new IfSchemaVO();
    	String returnFlag = "N";
    	try {
			// ========= Validation Parameters for WebServices ========= 
			if( docIn == null || "".equals(docIn) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			// ========= Command Add ===============
			
			WebDoLinkEvent event = new WebDoLinkEvent();
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
			WEB0030001 web0030001doc = docIn.getWEB0030001();
			
			DataArea dataArea = web0030001doc.getDataArea();
			InfoCollection infoCollection = dataArea.getInfoCollection();
			Request[] web0030001Requests = infoCollection.getRequestArray();
			Response documentResponse = infoCollection.getResponse();
	
			String sysAreaGrpId			= null;
			String cntrNo				= null;
			String cntrCycNo			= null;
			String dmdtTrfCd			= null;
			String dmdtChgLocDivCd		= null;
			String chgSeq				= null;
			String toMvmtStsCd			= null;
			String toMvmtDt				= null;
			String webMtyDt				= null;
			String toMvmtYdCd			= null;
			String webIndFlg			= null;
			String webCreUsrId			= null;
			String webCreDt				= null;
			String webNtfyPicNm			= null;
			String webNtfyPicTelcmNo	= null;

			for(Request request:web0030001Requests){
				sysAreaGrpId = request.getSYSAREAGRPID();
				cntrNo = request.getCNTRNO();
				cntrCycNo = request.getCNTRCYCNO();
				dmdtTrfCd = request.getDMDTTRFCD();
				dmdtChgLocDivCd = request.getDMDTCHGLOCDIVCD();
				chgSeq = request.getCHGSEQ();
				toMvmtStsCd = request.getTOMVMTSTSCD();
				toMvmtDt = request.getTOMVMTDT();
				webMtyDt = request.getWEBMTYDT();
				toMvmtYdCd = request.getTOMVMTYDCD();
				webIndFlg = request.getWEBINDFLG();
				webCreUsrId = request.getWEBCREUSRID();
				webCreDt = request.getWEBCREDT();
				webNtfyPicNm = request.getWEBNTFYPICNM();
				webNtfyPicTelcmNo = request.getWEBNTFYPICTELCMNO();
	        
				vo.setSysAreaGrpId(sysAreaGrpId);
				vo.setCntrNo(cntrNo);
				vo.setCntrCycNo(cntrCycNo);
				vo.setDmdtTrfCd(dmdtTrfCd);
				vo.setDmdtChgLocDivCd(dmdtChgLocDivCd);
				vo.setChgSeq(chgSeq);
				vo.setToMvmtStsCd(toMvmtStsCd);
				vo.setToMvmtDt(toMvmtDt);
				vo.setWebMtyDt(webMtyDt);
				vo.setToMvmtYdCd(toMvmtYdCd);
				vo.setWebIndFlg(webIndFlg);
				vo.setWebCreUsrId(webCreUsrId);
				vo.setWebCreDt(webCreDt);
				vo.setWebNtfyPicNm(webNtfyPicNm);
				vo.setWebNtfyPicTelcmNo(webNtfyPicTelcmNo);

				event.setIfSchema(vo);
			
				//PF, PK에 해당하는 값이 존재하지 않는 경우 EAI처리 실패
				if ((sysAreaGrpId == null || "".equals(sysAreaGrpId))
						|| (cntrNo == null || "".equals(cntrNo))
						|| (cntrCycNo == null || "".equals(cntrCycNo))
						|| (dmdtTrfCd == null || "".equals(dmdtTrfCd))
						|| (dmdtChgLocDivCd == null || "".equals(dmdtChgLocDivCd))
						|| (chgSeq == null || "".equals(chgSeq))) {	
					throw new EventException("Invalid Data");
				} else {
					EventResponse eventResponse = rsc.perform(event);
					//result = "Invalid Data\n" + dmdtTrfCd + "|" + dmdtChgLocDivCd + "|" + chgSeq;
					String retVal = eventResponse.getUserMessage();
					if(("1").equals(retVal)){
						returnFlag = "OK";
					}
				}
				
				log.debug("@@@@@@WSProxy : checking documentResponse");
				if (documentResponse != null) {
					log.debug("@@@@@@WSProxy : documentResponse is not null");
					documentResponse.setRESULT(returnFlag);
				}
			}
    	} catch (EventException e) {
    		log.error(e.getMessage(), e);
    		//throw new EventException(e.getMessage());
    	} catch (Exception de){
    		log.error(de.getMessage(), de);
    		//throw new EventException(de.getMessage());
    	}
    	return returnFlag;
    }
}

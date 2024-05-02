/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Web0070001ReceiveWSProxy.java
*@FileTitle : Web0070001ReceiveWSProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2012-01-02
*@LastModifier : Kwon Min
*@LastVersion : 1.0
* 2012-01-02 Kwon Min 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo;

import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.event.WebDoLinkEvent;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo.IfSchemaVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.irep.alpsws.WEB0070001Document;
import com.hanjin.irep.alpsws.WEB0070001Document.WEB0070001;
import com.hanjin.irep.alpsws.WEB0070001Document.WEB0070001.DataArea;
import com.hanjin.irep.alpsws.WEB0070001Document.WEB0070001.DataArea.InfoCollection;
import com.hanjin.irep.alpsws.WEB0070001Document.WEB0070001.DataArea.InfoCollection.Request;
import com.hanjin.irep.alpsws.WEB0070001Document.WEB0070001.DataArea.InfoCollection.Response;

/**
 * HJS Hompage의 DEM/DET CHARGE INQUIRY의 PRE-CALCULATION 수신 WebService Proxy<br>
 *
 * @author	Kwon Min
 * @see		Web0070001ReceiveRSC 참조
 * @since	J2EE 1.6
 */

@WebService(name="Web0070001ReceiveWSProxyPortType", serviceName="Web0070001ReceiveWSProxy",
        targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/Web0070001ReceiveWSProxy",
             portName="Web0070001ReceiveWSProxyPort")
        
public class Web0070001ReceiveWSProxy {
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
    	return "WebDoLink Web-Service : " + id + " >> Deployed Date is 2012.01.02";
    }

    /**
     * HJS Hompage의 DEM/DET CHARGE INQUIRY의 PRE-CALCULATION 수신 I/F
     * 
     * @param docIn WEB0070001Document
     * @return  WEB0070001Document
     */
    @WebMethod()
    //public boolean multiUsDo (IfSchemaVO docIn) {
    public WEB0070001Document web0070001ReceiveWS(WEB0070001Document docIn){
    	Web0070001ReceiveRSC rsc	= new Web0070001ReceiveRSC();
    	Response documentResponse	= null;
    	IfSchemaVO vo = new IfSchemaVO();
    	String result = "N";
    	try {
			// ========= Validation Parameters for WebServices ========= 
			if( docIn == null || "".equals(docIn) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH);
			// ========= Command Add ===============
			
			WebDoLinkEvent event = new WebDoLinkEvent();
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
			WEB0070001 web0070001doc = docIn.getWEB0070001();
			
			DataArea dataArea = web0070001doc.getDataArea();
			InfoCollection infoCollection = dataArea.getInfoCollection();
			Request[] web0070001Requests = infoCollection.getRequestArray();
			documentResponse = infoCollection.getResponse();
	
			String sysAreaGrpId			= null;
			String cntrNo				= null;
			String cntrCycNo			= null;
			String dmdtTrfCd			= null;
			String dmdtChgLocDivCd		= null;
			String chgSeq				= null;
			String fmMvmtDt				= null;
			String toMvmtDt				= null;
			String webCreUsrId			= null;
			String ofcCd				= null;
			
			String actCntCd				= null;
			String actCustSeq			= null;
			String bkgNo				= null;
			String cntrTpszCd			= null;
			String custCntCd			= null;
			String custSeq				= null;
			String fmMvmtStsCd			= null;
			String fmMvmtYdCd			= null;
			String ioBndCd				= null;
			String toMvmtStsCd			= null;
			String toMvmtYdCd			= null;

			for(Request request:web0070001Requests){
				sysAreaGrpId = request.getSYSAREAGRPID();
				cntrNo = request.getCNTRNO();
				cntrCycNo = request.getCNTRCYCNO();
				dmdtTrfCd = request.getDMDTTRFCD();
				dmdtChgLocDivCd = request.getDMDTCHGLOCDIVCD();
				chgSeq = request.getCHGSEQ();
				fmMvmtDt = request.getFMMVMTDT();
				toMvmtDt = request.getTOMVMTDT();
				webCreUsrId = request.getWEBCREUSRID();
				ofcCd		= request.getOFCCD();
				
				actCntCd	= request.getACTCNTCD();
				actCustSeq	= request.getACTCUSTSEQ();
				bkgNo		= request.getBKGNO();
				cntrTpszCd	= request.getCNTRTPSZCD();
				custCntCd	= request.getCUSTCNTCD();
				custSeq		= request.getCUSTSEQ();
				fmMvmtStsCd	= request.getFMMVMTSTSCD();
				fmMvmtYdCd	= request.getFMMVMTYDCD();
				ioBndCd		= request.getIOBNDCD();
				toMvmtStsCd	= request.getTOMVMTSTSCD();
				toMvmtYdCd	= request.getTOMVMTYDCD();
	        
				vo.setSysAreaGrpId(sysAreaGrpId);
				vo.setCntrNo(cntrNo);
				vo.setCntrCycNo(cntrCycNo);
				vo.setDmdtTrfCd(dmdtTrfCd);
				vo.setDmdtChgLocDivCd(dmdtChgLocDivCd);
				vo.setChgSeq(chgSeq);
				vo.setFmMvmtDt(fmMvmtDt);
				vo.setToMvmtDt(toMvmtDt);
				vo.setWebCreUsrId(webCreUsrId);
				vo.setActCntCd(actCntCd);
				vo.setActCustSeq(actCustSeq);
				vo.setBkgNo(bkgNo);
				vo.setCntrTpszCd(cntrTpszCd);
				vo.setCustCntCd(custCntCd);
				vo.setCustSeq(custSeq);
				vo.setFmMvmtStsCd(fmMvmtStsCd);
				vo.setFmMvmtYdCd(fmMvmtYdCd);
				vo.setIoBndCd(ioBndCd);
				vo.setToMvmtStsCd(toMvmtStsCd);
				vo.setToMvmtYdCd(toMvmtYdCd);
				vo.setOfcCd(ofcCd);

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
					Map resultMap		= eventResponse.getETCData();
					
					String retVal		= (String)resultMap.get("msg"); 
					IfSchemaVO resultVO	= (IfSchemaVO)resultMap.get("resultVO");

					if(("1").equals(retVal)){
						result = "OK";
					}
					
					log.debug("@@@@@@WSProxy : checking documentResponse");
					if (documentResponse != null) {
						log.debug("@@@@@@WSProxy : documentResponse is not null");
						documentResponse.setRESULT(result);
						documentResponse.setFXFTOVRDYS(resultVO.getFxFtOvrDys());
						documentResponse.setBZCTRFCURRCD(resultVO.getBzcTrfCurrCd());
						documentResponse.setBILLAMT(resultVO.getBilAmt());
					}
				}
			}
    	} catch (EventException e) {
    		log.error(e.getMessage(), e);
    		//throw new EventException(e.getMessage());
    	} catch (Exception de){
    		log.error(de.getMessage(), de);
    		//throw new EventException(de.getMessage());
    	}
    	return docIn;
    }
}

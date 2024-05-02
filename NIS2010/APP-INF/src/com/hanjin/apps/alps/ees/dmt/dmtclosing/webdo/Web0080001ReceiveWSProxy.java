/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Web0080001ReceiveWSProxy.java
*@FileTitle : Web0080001ReceiveWSProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-21
*@LastModifier : Chang Bin Lim
*@LastVersion : 1.0
* 2013-05-21 Chang Bin Lim 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo;

import java.util.ArrayList;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3003Event;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.irep.alpsws.WEB0080001Document;
import com.hanjin.irep.alpsws.WEB0080001Document.WEB0080001;
import com.hanjin.irep.alpsws.WEB0080001Document.WEB0080001.DataArea;
import com.hanjin.irep.alpsws.WEB0080001Document.WEB0080001.DataArea.CSInfoCollection;
import com.hanjin.irep.alpsws.WEB0080001Document.WEB0080001.DataArea.CSInfoCollection.CSInfoRequest;
import com.hanjin.irep.alpsws.WEB0080001Document.WEB0080001.DataArea.CSInfoCollection.CSInfoResponse;

/**
 * HJS Homepage ( CUP_HOM_3708 )에서 Clock Stop 기능 내 Save 버튼 클릭시 DMT(EES_DMT_3003 : Charge Calculation by CNTR)화면에
 * Save 기능을 호출하는 WebService Proxy<br>
 *
 * @author	Chang Bin Lim
 * @see		Web0080001ReceiveRSC 참조
 * @since	J2EE 1.6
 */

@WebService(name="Web0080001ReceiveWSProxyPortType", serviceName="Web0080001ReceiveWSProxy",
        targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/Web0080001ReceiveWSProxy",
             portName="Web0080001ReceiveWSProxyPort")
        
public class Web0080001ReceiveWSProxy {
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 서비스명 제공
     * 
     * @param id String
     * @return String response
     */
    public String getServiceName(String id) {
    	return "WebDoLink Web-Service : " + id + " >> Deployed Date is 2013.05.28";
    }

    /**
     * HJS Hompage의 Clock Stop 화면내 Save 버튼에서 호출 -> 수신 I/F
     * 
     * @param docIn WEB0080001Document
     * @return  WEB0080001Document
     */
    @WebMethod()
    public WEB0080001Document web0080001ReceiveWS(WEB0080001Document docIn){
    	log.debug("\n<<<<<<<<<< WEB0080001Document JMS Start >>>>>>>>>>>>>>>>\n");	
    	
    	Web0080001ReceiveRSC rsc = new Web0080001ReceiveRSC();

    	String returnVal = "NO";
    	
    	try {
    		
			// ========= Validation Parameters for WebServices ========= 
			if( docIn == null || "".equals(docIn) )
			{
				throw new EventException("Parameter is not valided !");
			}
			// ========= Validation Parameters for WebServices ========= 
			
			// ========= Command Add ===============
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MODIFY);
			// ========= Command Add ===============
			log.debug("\n<<<<<<<<<< WEB0080001Document 1\n");	
			EesDmt3003Event event = new EesDmt3003Event ();
			
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
			WEB0080001 web0080001doc = docIn.getWEB0080001();
			
			DataArea dataArea = web0080001doc.getDataArea();
			CSInfoCollection infoCollection = dataArea.getCSInfoCollection();
			CSInfoRequest[] web0080001Requests = infoCollection.getCSInfoRequestArray();
			CSInfoResponse documentResponse	= infoCollection.getCSInfoResponse();
			
			log.debug("\n" + docIn.toString() + "\n");
			
			log.debug("\n<<<<<<<<<< WEB0080001Document 2 [" + web0080001Requests.length +"]");
			
			ArrayList<ChargeCalculationContainerVO> list = new ArrayList<ChargeCalculationContainerVO>();
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs = new ChargeCalculationContainerVO[web0080001Requests.length];

			log.debug("\n<<<<<<<<<< WEB0080001Document 3\n");	
			
			String svrId    			= null;
			String cntrNo				= null;
			String cntrCycNo			= null;
			String dmdtTrfCd			= null;
			String dmdtChgLocDivCd		= null;
			String chgSeq				= null;
			String toMvmtStsCd			= null;
			String toMvmtDt				= null;
			
			for(CSInfoRequest request:web0080001Requests){
			
				svrId 			= request.getSvrId           ();
				cntrNo 		 	= request.getCntrNo          ();
				cntrCycNo    	= request.getCntrCycNo       ();
				dmdtTrfCd		= request.getDmdtTrfCd       ();
				dmdtChgLocDivCd = request.getDmdtChgLocDivCd ();
				chgSeq 			= request.getChgSeq          ();
				toMvmtStsCd 	= request.getToMvmtStsCd     ();
				toMvmtDt 		= request.getToMvmtDt        ();
				
				//PF, PK에 해당하는 값이 존재하지 않는 경우 EAI처리 실패
				if ((svrId 				== null || "".equals(svrId			))	||
					(cntrNo 			== null || "".equals(cntrNo			))	||
					(cntrCycNo 			== null || "".equals(cntrCycNo		))	||
					(dmdtTrfCd 			== null || "".equals(dmdtTrfCd		))	||
					(dmdtChgLocDivCd 	== null || "".equals(dmdtChgLocDivCd))	||
					(chgSeq 			== null || "".equals(chgSeq			))	||
					(toMvmtStsCd 		== null || "".equals(toMvmtStsCd	))	||
					(toMvmtDt 			== null || "".equals(toMvmtDt		))
					) 
				{
					throw new EventException("Invalid data!");
				}
				
				ChargeCalculationContainerVO vo = new ChargeCalculationContainerVO();
				
				vo.setSvrId          ( svrId			);
				vo.setCntrNo         ( cntrNo			);
				vo.setCntrCycNo      ( cntrCycNo		);
				vo.setDmdtTrfCd      ( dmdtTrfCd		);
				vo.setDmdtChgLocDivCd( dmdtChgLocDivCd	);
				vo.setChgSeq         ( chgSeq			);
				vo.setToMvmtStsCd    ( toMvmtStsCd		);
				vo.setToMvmtDt       ( toMvmtDt			);
				
				list.add(vo);
			}
			
			list.toArray(chargeCalculationContainerVOs); // List를 Array로 변환
	
			((EesDmt3003Event) event).setChargeCalculationContainerVOS(chargeCalculationContainerVOs);

			log.debug("\n<<<<<<<<<< WEB0080001Document 6\n");	
			EventResponse eventResponse = rsc.perform(event);	//SC 호출
			log.debug("\n<<<<<<<<<< WEB0080001Document 7\n");
			
			Map resultMap		= eventResponse.getETCData();
			log.debug("\n<<<<<<<<<< WEB0080001Document 8 GetETC!");
			String retVal		= (String)resultMap.get("RESULT");
		
			log.debug("\n<<<<<<<<<< WEB0080001Document 8.1 [" + retVal +"]");
			
			if(("1").equals(retVal)){
				returnVal = "OK";
			} 
			
			log.debug("\n<<<<<<<<<< WEB0080001Document 8.2 [" + returnVal +"]");	
			
			if (documentResponse != null) {
				log.debug("\n@@@@@@WSProxy : documentResponse is not null \n");
				documentResponse.setRESULT(returnVal);
				log.info("\n:::::>>> WEB0080001Document 8.3 : \n" + documentResponse.toString() + "\n");
			}

			log.info("\n:::::>>> WEB0080001Document 9 : [ Return Value Change!!]");
			
    	} catch (EventException e) {
    		log.error(e.getMessage(), e);
    	} catch (Exception de){
    		log.error(de.getMessage(), de);
    	}
    	
    	return docIn;
    }
}

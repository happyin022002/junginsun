/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Sap0010001ReceiveWSProxy.java
*@FileTitle : Sap0010001ReceiveWSProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2013-09-02
*@LastModifier : Chang Bin Lim
*@LastVersion : 1.0
* 2013-09-02 Chang Bin Lim 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo;

import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGRequestVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event.EesDmt2008Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.irep.alpsws.SAP0010001Document;
import com.hanjin.irep.alpsws.SAP0010001Document.SAP0010001;
import com.hanjin.irep.alpsws.SAP0010001Document.SAP0010001.DataArea;
import com.hanjin.irep.alpsws.SAP0010001Document.SAP0010001.DataArea.DMTCollection;
import com.hanjin.irep.alpsws.SAP0010001Document.SAP0010001.DataArea.DMTCollection.DMTRequest;
import com.hanjin.irep.alpsws.SAP0010001Document.SAP0010001.DataArea.DMTCollection.DMTResponse;

/**
 * HJS 모바일 ( HANSAP 시스템 )에서  기능 내 Save 버튼 클릭시 DMT(EES_DMT_2008 : DEM/DET Adjustment Request - After Booking Request)화면에
 * Request 기능을 호출하는 WebService Proxy<br>
 *
 * @author	Chang Bin Lim
 * @see		SAP0010001ReceiveRSC 참조
 * @since	J2EE 1.6
 */

@WebService(name="Sap0010001ReceiveWSProxyPortType", serviceName="Sap0010001ReceiveWSProxy",
        targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/Sap0010001ReceiveWSProxy",
             portName="Sap0010001ReceiveWSProxyPort")
        
public class Sap0010001ReceiveWSProxy {
    protected transient Logger log = Logger.getLogger(this.getClass().getName());
    
    /**
     * 서비스명 제공
     * 
     * @param id String
     * @return String response
     */
    public String getServiceName(String id) {
    	return "WebDoLink Web-Service : " + id + " >> Deployed Date is 2013.09.04";
    }

    /**
     * HJS Hompage의 Clock Stop 화면내 Save 버튼에서 호출 -> 수신 I/F
     * 
     * @param SAP0010001Document docIn
     * @return  SAP0010001Document
     */
    @SuppressWarnings("null")
	@WebMethod()
    public SAP0010001Document sap0010001ReceiveWS(SAP0010001Document docIn){
    	log.debug("\n<<<<<<<<<< SAP0010001Document JMS Start >>>>>>>>>>>>>>>>\n");	
    	
    	Sap0010001ReceiveRSC rsc = new Sap0010001ReceiveRSC();

    	String returnVal = "";
    	
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
			log.debug("\n<<<<<<<<<< SAP0010001Document 1\n");	
			EesDmt2008Event event = new EesDmt2008Event ();
			
	        event.setFormCommand(f);
			
			// EAI에서 제공된 XSD파일을 Reading
	        SAP0010001 sap0010001doc = docIn.getSAP0010001();
			
			DataArea dataArea = sap0010001doc.getDataArea();
			DMTCollection infoCollection = dataArea.getDMTCollection();
			DMTRequest[] sap0010001Requests = infoCollection.getDMTRequestArray();
			DMTResponse documentResponse	= infoCollection.getDMTResponse();
			
			log.debug("\n" + docIn.toString() + "\n");
			
			log.debug("\n<<<<<<<<<< SAP0010001Document 2 [" + sap0010001Requests.length +"]");

			if (sap0010001Requests[0] == null) throw new EventException("There is no requested data!");		// 입력된 Request Data가 없을 경우 Return.
			
			log.debug("\n<<<<<<<<<< SAP0010001Document 3\n");	
			
			String aproOfcCd    			= null;
			String dmdtExptRqstRsnCd		= null;
			String usrId                    = null;
			String ofcCd                    = null;
			String dmdtTrfCd                = null;
			String bkgNo                    = null;
			String blNo                     = null;
			String dmdtChgLocDivCd          = null;
			String locCd                    = null;
			String ftAdjFlg                 = null;
			String ftAddDys                 = null;
			String ftTtlDys                 = null;
			String xcldSatFlg               = null;
			String xcldSunFlg               = null;
			String xcldHolFlg               = null;
			String dcFlg                    = null;
			String currCd                   = null;
			String dcAmt                    = null;
			String dcRto                    = null;
			String progRmk    				= null;
			String errMsg					= "";
			
			aproOfcCd				= sap0010001Requests[0].getAproOfcCd		();
			dmdtExptRqstRsnCd		= sap0010001Requests[0].getDmdtExptRqstRsnCd();
			usrId                   = sap0010001Requests[0].getUsrId            ();
			ofcCd                   = sap0010001Requests[0].getOfcCd            ();
			dmdtTrfCd               = sap0010001Requests[0].getDmdtTrfCd        ();
			bkgNo                   = sap0010001Requests[0].getBkgNo            ();
			blNo                    = sap0010001Requests[0].getBlNo             ();
			dmdtChgLocDivCd         = sap0010001Requests[0].getDmdtChgLocDivCd  ();
			locCd                   = sap0010001Requests[0].getLocCd            ();
			ftAdjFlg                = sap0010001Requests[0].getFtAdjFlg         ();
			ftAddDys                = sap0010001Requests[0].getFtAddDys         ();
			ftTtlDys                = sap0010001Requests[0].getFtTtlDys         ();
			xcldSatFlg              = sap0010001Requests[0].getXcldSatFlg       ();
			xcldSunFlg              = sap0010001Requests[0].getXcldSunFlg       ();
			xcldHolFlg              = sap0010001Requests[0].getXcldHolFlg       ();
			dcFlg                   = sap0010001Requests[0].getDcFlg            ();
			currCd                  = sap0010001Requests[0].getCurrCd           ();
			dcAmt                   = sap0010001Requests[0].getDcAmt            ();
			dcRto                   = sap0010001Requests[0].getDcRto            ();
			progRmk					= sap0010001Requests[0].getProgRmk          ();
			
			//PF, PK에 해당하는 값이 존재하지 않는 경우 EAI처리 실패
			if ((bkgNo 					== null || "".equals(bkgNo			))){
				errMsg	= "Invalid data [BKG No.]!";
			}
			else if ((blNo 				== null || "".equals(blNo			))){
				errMsg	= "Invalid data [BL No.]!";
			}
			else if ((dmdtTrfCd 		== null || "".equals(dmdtTrfCd		))){
				errMsg	= "Invalid data [Tariff Code]!";
			}
			else if ((usrId 			== null || "".equals(usrId			))){
				errMsg	= "Invalid data [User ID]!";
			}
			else if ((ofcCd 			== null || "".equals(ofcCd			))){ 
				errMsg	= "Invalid data [Office Code]!";
			}
			else if ((progRmk 			== null || "".equals(progRmk		))){ 
				errMsg	= "Invalid data [Request Remark]!";
			}
			
			if (!errMsg.equals("")) {
				throw new EventException(errMsg);		// 필요 항목에 Data를 입력 받지 못했을 경우 Return.
			}
			
			AfterProgressVO afterProgressVO = new AfterProgressVO();
			afterProgressVO.setIbflag				( "I"         		);
			afterProgressVO.setDmdtExptRqstStsCd	( "R"         		);	// Dar No. Request를 의미
			afterProgressVO.setBackendJobFlag		( "N"               );	// Back End Job 실행 여부 (N : 미실행을 의미).
			
			afterProgressVO.setAproOfcCd  			( aproOfcCd         );
			afterProgressVO.setDmdtExptRqstRsnCd	( dmdtExptRqstRsnCd );
			afterProgressVO.setRqstUsrId            ( usrId             );
			afterProgressVO.setRqstOfcCd            ( ofcCd             );
			afterProgressVO.setCreUsrId             ( usrId             );
			afterProgressVO.setCreOfcCd             ( ofcCd             );
			afterProgressVO.setProgRmk		        ( progRmk           );
			
			log.debug("\n<<<<<<<<<< SAP0010001Document 61 [" + progRmk + "]");	
			
			AfterBKGRequestVO[] afterBKGRequestVOS = new AfterBKGRequestVO[sap0010001Requests.length];
			
			for (int i=0; i<afterBKGRequestVOS.length; i++) {
				afterBKGRequestVOS[i] = new AfterBKGRequestVO();
				
				afterBKGRequestVOS[i].setIbflag                  ( "I"               	);
				afterBKGRequestVOS[i].setDmdtTrfCd               ( dmdtTrfCd         	);
				afterBKGRequestVOS[i].setBkgNo                   ( bkgNo            	);
				afterBKGRequestVOS[i].setBlNo                    ( blNo               	);
				afterBKGRequestVOS[i].setAftExptAdjSeq			 ( Integer.toString(i + 1));	// 입력된 Booking 개수. 현재까지는 Booking 단건만 입력되고 있음			
				afterBKGRequestVOS[i].setDmdtChgLocDivCd         ( dmdtChgLocDivCd   	);
				afterBKGRequestVOS[i].setLocCd                   ( locCd             	);
				afterBKGRequestVOS[i].setFtAdjFlg                ( ftAdjFlg          	);
				afterBKGRequestVOS[i].setFtAddDys                ( ftAddDys          	);
				afterBKGRequestVOS[i].setFtTtlDys                ( ftTtlDys          	);
				afterBKGRequestVOS[i].setXcldSatFlg              ( xcldSatFlg        	);
				afterBKGRequestVOS[i].setXcldSunFlg              ( xcldSunFlg        	);
				afterBKGRequestVOS[i].setXcldHolFlg              ( xcldHolFlg        	);
				afterBKGRequestVOS[i].setDcFlg                   ( dcFlg             	);
				afterBKGRequestVOS[i].setCurrCd                  ( currCd            	);
				afterBKGRequestVOS[i].setDcAmt                   ( dcAmt             	);
				afterBKGRequestVOS[i].setDcRto                   ( dcRto             	);
			}
				
			((EesDmt2008Event) event).setAfterProgressVO(afterProgressVO);
			((EesDmt2008Event) event).setAfterBKGRequestVOS(afterBKGRequestVOS);

			log.debug("\n<<<<<<<<<< SAP0010001Document 6\n");	
			EventResponse eventResponse = rsc.perform(event);	//SC 호출
			log.debug("\n<<<<<<<<<< SAP0010001Document 7\n");
			
			Map resultMap		= eventResponse.getETCData();
			log.debug("\n<<<<<<<<<< SAP0010001Document 8 GetETC!");
			
			String darNo		= (String)resultMap.get("RESULT");
		
			log.debug("\n<<<<<<<<<< SAP0010001Document 9 [" + darNo +"]");
			
			if(darNo != null && !darNo.equals("")){
				returnVal = darNo;
			} 
			
			log.debug("\n<<<<<<<<<< SAP0010001Document 10 [" + returnVal +"]");	
			
			if (documentResponse != null) {
				log.debug("\n@@@@@@WSProxy : documentResponse is not null \n");
				documentResponse.setAftExptDarNo(returnVal);
				log.info("\n:::::>>> SAP0010001Document 11 : \n" + documentResponse.toString() + "\n");
			}
			
			log.info("\n:::::>>> SAP0010001Document 12 : [ Return Value Change!!]");
			
    	} catch (EventException e) {
    		log.error(e.getMessage(), e);
    	} catch (Exception de){
    		log.error(de.getMessage(), de);
    	}
    	
    	return docIn;
    }
}

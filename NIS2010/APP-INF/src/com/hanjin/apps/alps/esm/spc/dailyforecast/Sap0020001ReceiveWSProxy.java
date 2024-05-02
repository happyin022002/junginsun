/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Sap0020001ReceiveWSProxy.java
*@FileTitle : Sap0020001ReceiveWSProxy
*Open Issues :
*Change history :
*@LastModifyDate : 2013-09-02
*@LastModifier : 김시몬
*@LastVersion : 1.0
* 2013-09-02 김시몬
* 1.0 최초 생성
* 2013.10.17 [CHM-201325350] Split 04-영업지원 Application 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast;

import java.util.Map;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0102Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.alpsws.SAP0020001Document;
import com.hanjin.irep.alpsws.SAP0020001Document.SAP0020001;
import com.hanjin.irep.alpsws.SAP0020001Document.SAP0020001.DataArea.SPCCollection.SPCRequest;
import com.hanjin.irep.alpsws.SAP0020001Document.SAP0020001.DataArea.SPCCollection.SPCResponse;
import com.hanjin.syscommon.common.table.SpcDlyFcastCustVO;

 

/**
 * HJS 모바일 ( HANSAP 시스템 )에서  기능 내 Save 버튼 클릭시 SPC(ESM_SPC_0102 : SPC Daily Fcast Request )화면에
 * Request 기능을 호출하는 WebService Proxy<br>
 *
 * @author	Chang Bin Lim
 * @see		DailyForecastSC 참조
 * @since	J2EE 1.6
 */

@WebService(name="Sap0020001ReceiveWSProxyPortType", serviceName="Sap0020001ReceiveWSProxy",
        targetNamespace="http://www.hanjin.com/integration/alps")

@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
         use=SOAPBinding.Use.LITERAL,
         parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)

@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/Sap0020001ReceiveWSProxy",
             portName="Sap0020001ReceiveWSProxyPort")
        
public class Sap0020001ReceiveWSProxy {
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
     * HJS Hompage의 Forecast Input 화면내 Save 버튼에서 호출 -> 수신 I/F
     * 
     * @param docIn Sap0020001Document
     * @return  SAP0020001Document
     */
	  @WebMethod()
    public String sap0020001ReceiveWS(SAP0020001Document docIn){
    	log.debug("\n<<<<<<<<<< SAP0020001Document JMS Start >>>>>>>>>>>>>>>>\n");	
    	
    	DailyForecastSC rsc = new DailyForecastSC();
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
			f.setCommand(FormCommand.MULTI02);
			// ========= Command Add ===============
			log.debug("\n<<<<<<<<<< SAP0020001Document 1\n");	
			EsmSpc0102Event event = new EsmSpc0102Event ();
			event.setFormCommand(f); 
			
			// EAI에서 제공된 XSD파일을 Reading
            SAP0020001 sap0020001 = docIn.getSAP0020001();
      
            SAP0020001.DataArea data = sap0020001.getDataArea();
            SAP0020001.DataArea.SPCCollection infoCollection = data.getSPCCollection();
			SPCRequest[] sap0020001Requests = infoCollection.getSPCRequestArray();
			SPCResponse documentResponse	= infoCollection.getSPCResponse();
			
			log.debug("\n<<<<<<<<<< SAP0020001Document 2 [" + sap0020001Requests.length +"]");
			
			ArrayList<SpcDlyFcastCustVO> list = new ArrayList<SpcDlyFcastCustVO>();
			SpcDlyFcastCustVO[] spcDlyFcastCustVOs = new SpcDlyFcastCustVO[sap0020001Requests.length];

			if (sap0020001Requests[0] == null) throw new EventException("There is no requested data!");		// 입력된 Request Data가 없을 경우 Return.
			
			log.debug("\n<<<<<<<<<< SAP0020001Document 3\n");	
			
			for ( SPCRequest request : sap0020001Requests) {
				log.debug("\n<<<<<<<<<< SAP0020001Document 3-1\n");
				String errMsg = "";
				String rlaneCd = request.getRlaneCd();
				String dirCd = request.getDirCd();
				String vslCd = request.getVslCd();
				String skdVoyNo = request.getSkdVoyNo();
				String skdDirCd = request.getSkdDirCd();
				String iocTsCd = request.getIocTsCd();
				String srepUsrId = request.getSrepUsrId();
				String fcastOfcCd = request.getFcastOfcCd();
				String fcastCustTpCd = request.getFcastCustTpCd();
				String updUsrId = request.getUpdUsrId();
				String modiGdt = request.getModiGdt();
				
				SpcDlyFcastCustVO vo = new SpcDlyFcastCustVO();
				
				vo.setIbflag("I");
				vo.setTrdCd               ( request.getTrdCd          ()  );
				vo.setSubTrdCd            ( request.getSubTrdCd       ()  );
				vo.setRlaneCd             ( rlaneCd );
				vo.setDirCd               ( dirCd );
				vo.setVslCd               ( vslCd );
				vo.setSkdVoyNo            ( skdVoyNo );
				vo.setSkdDirCd            ( skdDirCd );
				vo.setIocTsCd             ( iocTsCd );
				vo.setSrepUsrId           ( srepUsrId );
				vo.setCustCntCd           ( request.getCustCntCd      ()  );
				vo.setCustSeq             ( request.getCustSeq        ()  );
				vo.setFcastSeq            ( request.getFcastSeq       ()  );
				vo.setScNo                ( request.getScNo           ()  );
				vo.setPolYdCd             ( request.getPolYdCd        ()  );
				vo.setPodYdCd             ( request.getPodYdCd        ()  );
				vo.setFcastOfcCd          ( fcastOfcCd );
				vo.setFcastCustTpCd       ( fcastCustTpCd );
				vo.setViewType            ( "TEU" );
				vo.setFcastTtlQty         ( request.getFcastTtlQty    ()  );
				vo.setFcast40ftQty        ( request.getFcast40FtQty   ()  );
				vo.setFcast20ftQty        ( request.getFcast20FtQty   ()  );
				vo.setFcast40ftHcQty      ( request.getFcast40FtHcQty ()  );
				vo.setFcast45ftHcQty      ( request.getFcast45FtHcQty ()  );
				vo.setFcast53ftQty        ( request.getFcast53FtQty   ()  );
				vo.setFcastRfQty          ( request.getFcastRfQty     ()  );
				vo.setFcastTtlWgt         ( request.getFcastTtlWgt    ()  );
				vo.setUsdBkgTtlQty        ( request.getUsdBkgTtlQty   ()  );
				vo.setUsdBkg20ftQty       ( request.getUsdBkg20FtQty  ()  );
				vo.setUsdBkg40ftQty       ( request.getUsdBkg40FtQty  ()  );
				vo.setUsdBkg40ftHcQty     ( request.getUsdBkg40FtHcQty()  );
				vo.setUsdBkg45ftHcQty     ( request.getUsdBkg45FtHcQty()  );
				vo.setUsdBkg53ftQty       ( request.getUsdBkg53FtQty  ()  );
				vo.setUsdBkgRfQty         ( request.getUsdBkgRfQty    ()  );
				vo.setUsdBkgTtlWgt        ( request.getUsdBkgTtlWgt   ()  );
				vo.setCtrlLvlCd           ( request.getCtrlLvlCd      ()  );
				vo.setUpdUsrId            ( updUsrId );
				vo.setModiGdt             ( modiGdt );
				vo.setCreDt               ( request.getCreDt          ()  );
				vo.setCreUsrId            ( updUsrId );
				vo.setRfaNo               ( request.getRfaNo         ()  );
				
				if ((rlaneCd 					== null || "".equals(rlaneCd			))){
					errMsg	= "Invalid data [Rlane Cd.]!";
				}
				else if ((dirCd 				== null || "".equals(dirCd			))){
					errMsg	= "Invalid data [Dir Cd.]!";
				}
				else if ((vslCd 		== null || "".equals(vslCd		))){
					errMsg	= "Invalid data [Vsl Cd]!";
				}	
				else if ((skdVoyNo 		== null || "".equals(skdVoyNo		))){
					errMsg	= "Invalid data [Skd Voy No]!";
				}
				else if ((skdDirCd 		== null || "".equals(skdDirCd		))){
					errMsg	= "Invalid data [Skd Dir Cd]!";
				}
				else if ((iocTsCd 		== null || "".equals(iocTsCd		))){
					errMsg	= "Invalid data [Ioc Ts Cd]!";
				}	
				else if ((srepUsrId 		== null || "".equals(srepUsrId		))){
					errMsg	= "Invalid data [Srep Usr Id]!";
				}	
				else if ((fcastOfcCd 		== null || "".equals(fcastOfcCd		))){
					errMsg	= "Invalid data [Fcast Ofc Cd]!";
				}	
				else if ((fcastCustTpCd 		== null || "".equals(fcastCustTpCd		))){
					errMsg	= "Invalid data [Fcast Cust Tp Cd]!";
				}	
				else if ((updUsrId 			== null || "".equals(updUsrId			))){
					errMsg	= "Invalid data [Upd Usr ID]!";
				}
				else if ((modiGdt 			== null || "".equals(modiGdt			))){ 
					errMsg	= "Invalid data [Modi Gdt]!";
				}
				log.debug("\n<<<<<<<<<< SAP0020001Document 3-2"+errMsg+"\n");
				
				if (!errMsg.equals("")) { 
					throw new EventException(errMsg);		// 필요 항목에 Data를 입력 받지 못했을 경우 Return.
				}
				list.add(vo);
			}
			
			list.toArray(spcDlyFcastCustVOs); // List를 Array로 변환
			log.debug("\n<<<<<<<<<< SAP0020001Document 4\n");
			((EsmSpc0102Event) event).setSpcDlyFcastCustVOS(spcDlyFcastCustVOs);
			
			EventResponse eventResponse = rsc.perform(event);	//SC 호출
			log.debug("\n<<<<<<<<<< SAP0020001Document 5 SC END\n");
			
			Map resultMap		= eventResponse.getETCData();
			
			String rslt		= (String)resultMap.get("status");
		
			if(rslt != null && !rslt.equals("")){
				returnVal = "Y";
			} else{
				returnVal = "F";
			}
			
			log.debug("\n<<<<<<<<<< SAP0020001Document 6 [" + returnVal +"]");	
			
			if (documentResponse != null) {
				log.debug("\n@@@@@@WSProxy : documentResponse is not null \n");
				documentResponse.setSpcIfScsFlg(returnVal);
				log.info("\n:::::>>> SAP0020001Document 8.1 : \n" + documentResponse.toString() + "\n");
			}else{
			  log.debug("\n:@@@@@@WSProxy : documentResponse is null \n");
			}
      
			
    	} catch (EventException e) {
    		log.error(e.getMessage(), e);
    	} catch (Exception de){
    		log.error(de.getMessage(), de);
    	}
    	
    	return returnVal;
    }
}

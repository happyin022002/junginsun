/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName 			: ScheduleTransmitManagementWSProxy.java
*@FileTitle 		: e-Service(스케쥴) Web Service 연동 
*Open Issues 		:
*Change history 	:
*@LastModifyDate 	: 2012.12.24
*@LastModifier 		: 진마리아
*@LastVersion 		: 1.0
* 2012-12-14
* 1.0 최초 생성
* 
* History
* 
 =========================================================*/

package com.hanjin.apps.alps.vop.vsk.servicesio;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;
import weblogic.jws.WLHttpTransport;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.ScheduleUtilityManagementSC;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0006Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0007Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0008Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0011Event;
import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.event.VopVskSPPVSK0012Event;

import com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.vo.EtaSendTgtVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 *  WebService를 통해서 SPP와 연동한다
 *
 *
 * @author 	정상기
 * @see 	ScheduleTransmitManagementWSProxy
 * @since 	J2EE 1.4
 */

@WebService(name="ScheduleTransmitManagementWSProxyPortType", serviceName="ScheduleTransmitManagementWSProxy", targetNamespace="http://www.smlines.com/integration/alps")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@WLHttpTransport(contextPath="/hanjin/webservices", serviceUri="/ScheduleTransmitManagementWSProxy", portName="ScheduleTransmitManagementWSProxyPort")
             
public class ScheduleTransmitManagementWSProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
     * e-Service(SPP)에서 입력한 조회조건으로 Telex/Fax 전송대상 Costal Schedule 조회.
     * 
     * @param EtaSendTgtVO etaSendTgtVO
     * @return EtaSendTgtVO[]
     */
	@WebMethod()
	@SuppressWarnings("unchecked")
    public EtaSendTgtVO[] searchTransmitTargetPortSkdList(EtaSendTgtVO etaSendTgtVO) {
    	
		//Interface ID  SPP_VSK-0006
		Event 						event 				= null;
		ScheduleUtilityManagementSC sc 					= new ScheduleUtilityManagementSC();
		List<EtaSendTgtVO> 			etaSendTgtVOList 	= null;
		EtaSendTgtVO[] 				rtnEtaSendTgtVOs 	= null;
		
		//::2013-05-20::ETA RESEND PURPOSE:://
		final String				sTrsmPurposeCd		= "ETA";
		
    	
    	log.debug("ScheduleTransmitManagementWSProxy searchTransmitTargetPortSkdList");
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		event 							= new VopVskSPPVSK0006Event();
    		EtaSendTgtVO tmpEtaSendTgtVO 	= new EtaSendTgtVO();
    		
    		tmpEtaSendTgtVO.setFmEtaDt		(etaSendTgtVO.getFmEtaDt		());
    		tmpEtaSendTgtVO.setToEtaDt		(etaSendTgtVO.getToEtaDt		());
    		tmpEtaSendTgtVO.setActCrrCd		(etaSendTgtVO.getActCrrCd		());
    		tmpEtaSendTgtVO.setVpsPortCd	(etaSendTgtVO.getVpsPortCd		());
    		tmpEtaSendTgtVO.setSlanCd		(etaSendTgtVO.getSlanCd			());
    		tmpEtaSendTgtVO.setVslCd		(etaSendTgtVO.getVslCd			());
    		tmpEtaSendTgtVO.setSkdVoyNo		(etaSendTgtVO.getSkdVoyNo		());
    		tmpEtaSendTgtVO.setSkdDirCd		(etaSendTgtVO.getSkdDirCd		());
    		
    		tmpEtaSendTgtVO.setTrsmPurpCd	(sTrsmPurposeCd						);
    		
    		
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0006Event) event).setEtaSendTgtVO((tmpEtaSendTgtVO));
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

            EventResponse eventResponse = (EventResponse)sc.perform(event);
            
            etaSendTgtVOList 			= (List)eventResponse.getRsVoList();
            
            if(etaSendTgtVOList != null && etaSendTgtVOList.size() > 0){
            	rtnEtaSendTgtVOs = new EtaSendTgtVO[etaSendTgtVOList.size()];
            	
            	for(int i=0; i<etaSendTgtVOList.size(); i++){
            		rtnEtaSendTgtVOs[i] = etaSendTgtVOList.get(i);
            	}
            }
           
    	}catch(EventException ee) {
            log.error("ScheduleTransmitManagementWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("ScheduleTransmitManagementWSProxy Error : " + e.toString(), e);
    	}
    	
    	return rtnEtaSendTgtVOs;
    }
	
	/**
     * e-Service(SPP)에서 입력한 Telex/Fax 전송내역에 OLD/NEW RPM, Adjustment Date Update
     * 
     * @param EtaSendTgtVO[] EtaSendTgtVOs
     * @return String
     */
	@WebMethod()
    public String modifyTransmitPortSkdList(EtaSendTgtVO[]  etaSendTgtVOs) {
    	
		//Interface ID  SPP_VSK-0007
		Event 							event 	= null;
		ScheduleUtilityManagementSC 	sc 		= new ScheduleUtilityManagementSC();
		String 							result 	= "";
		
		//::2013-05-20::ETA RESEND PURPOSE:://
		final String				sTrsmPurposeCd		= "ETA";		
    	
    	log.debug("ScheduleTransmitManagementWSProxy modifyTransmitPortSkdList");
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		for(int i=0; i<etaSendTgtVOs.length; i++){
    			etaSendTgtVOs[i].setTrsmOwnrCd("ESVC");
    			etaSendTgtVOs[i].setTrsmPurpCd(sTrsmPurposeCd);
    			//::comment:://etaSendTgtVOs[i].setUpdUsrId("ESVCUSER");
    		}
    		event = new VopVskSPPVSK0007Event();
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0007Event) event).setEtaSendTgtVOs(etaSendTgtVOs);
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

            sc.perform(event);
            
            result	= "Success";
           
    	}catch(EventException ee) {
    		log.error("ScheduleTransmitManagementWSProxy Error : " + ee.toString(), ee);
    		result = ee.toString();
    		
    	}catch(Exception e) {
    		log.error("ScheduleTransmitManagementWSProxy Error : " + e.toString(), e);
    		result = e.toString();
    	}
    	return result;
    }	
	
	

	/**
     * e-Service(SPP)에서 실행한 Fax 전송내역생성.
     * 
     * @param EtaSendTgtVO etaSendTgtVO
     * @return String
     */
	@WebMethod()
    public String createTransmitPortSkdHistory(EtaSendTgtVO etaSendTgtVO) {
    	
		//Interface ID  SPP_VSK-0008
		Event 						event 	= null;
		ScheduleUtilityManagementSC sc 		= new ScheduleUtilityManagementSC();
		String 						result 	= "";
    	
		//::2013-05-20::ETA RESEND PURPOSE:://
		final String				sTrsmPurposeCd		= "ETA";	
		
    	log.debug("ScheduleTransmitManagementWSProxy createTransmitPortSkdHistory");
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		if(etaSendTgtVO != null){
    			etaSendTgtVO.setTrsmOwnrCd("ESVC");
    			etaSendTgtVO.setTrsmPurpCd(sTrsmPurposeCd);
    			//::comment:://etaSendTgtVO.setUpdUsrId("ESVCUSER");
    		}

    		event = new VopVskSPPVSK0008Event();
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0008Event) event).setEtaSendTgtVO(etaSendTgtVO);
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

            sc.perform(event);
            
            result	= "Success";
           
    	}catch(EventException ee) {
    		log.error("ScheduleTransmitManagementWSProxy Error : " + ee.toString(), ee);
    		result = ee.toString();
    		
    	}catch(Exception e) {
    		log.error("ScheduleTransmitManagementWSProxy Error : " + e.toString(), e);
    		result = e.toString();
    	}
    	return result;
    }	
	
	/**
     * e-Service(SPP)에서 입력한 조회조건으로 Prestowage Notice목적의 Telex 전송대상 Coastal Schedule 조회.
     * 
     * @param EtaSendTgtVO etaSendTgtVO
     * @return EtaSendTgtVO[]
     */
	@WebMethod()
	@SuppressWarnings("unchecked")
    public EtaSendTgtVO[] searchTransmitTargetPortSkdPrestowageNoticeList(EtaSendTgtVO etaSendTgtVO) {
    	
		//Interface ID  SPP_VSK-0011
		Event 						event 				= null;
		ScheduleUtilityManagementSC sc 					= new ScheduleUtilityManagementSC();
		List<EtaSendTgtVO> 			etaSendTgtVOList 	= null;
		EtaSendTgtVO[] 				rtnEtaSendTgtVOs 	= null;
		
		//::2013-05-20::PRE-STOWAGE NOTICE PURPOSE:://
		final String				sTrsmPurposeCd		= "STW";
		
    	
    	log.debug("ScheduleTransmitManagementWSProxy searchTransmitTargetPortSkdPrestowageNoticeList");
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		event 							= new VopVskSPPVSK0011Event();
    		EtaSendTgtVO tmpEtaSendTgtVO 	= new EtaSendTgtVO();
    		
    		tmpEtaSendTgtVO.setFmEtaDt		(etaSendTgtVO.getFmEtaDt		());
    		tmpEtaSendTgtVO.setToEtaDt		(etaSendTgtVO.getToEtaDt		());
    		tmpEtaSendTgtVO.setActCrrCd		(etaSendTgtVO.getActCrrCd		());
    		tmpEtaSendTgtVO.setVpsPortCd	(etaSendTgtVO.getVpsPortCd		());
    		tmpEtaSendTgtVO.setSlanCd		(etaSendTgtVO.getSlanCd			());
    		tmpEtaSendTgtVO.setVslCd		(etaSendTgtVO.getVslCd			());
    		tmpEtaSendTgtVO.setSkdVoyNo		(etaSendTgtVO.getSkdVoyNo		());
    		tmpEtaSendTgtVO.setSkdDirCd		(etaSendTgtVO.getSkdDirCd		());
    		
    		tmpEtaSendTgtVO.setTrsmPurpCd	(sTrsmPurposeCd						);
    		
    		
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.SEARCH);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0011Event) event).setEtaSendTgtVO((tmpEtaSendTgtVO));
            
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

            EventResponse eventResponse = (EventResponse)sc.perform(event);
            
            etaSendTgtVOList 			= (List)eventResponse.getRsVoList();
            
            if(etaSendTgtVOList != null && etaSendTgtVOList.size() > 0){
            	rtnEtaSendTgtVOs = new EtaSendTgtVO[etaSendTgtVOList.size()];
            	
            	for(int i=0; i<etaSendTgtVOList.size(); i++){
            		rtnEtaSendTgtVOs[i] = etaSendTgtVOList.get(i);
            	}
            }
           
    	}catch(EventException ee) {
            log.error("ScheduleTransmitManagementWSProxy Error : " + ee.toString(), ee);
            
    	}catch(Exception e) {
            log.error("ScheduleTransmitManagementWSProxy Error : " + e.toString(), e);
    	}
    	
    	return rtnEtaSendTgtVOs;
    }
		
	/**
     * e-Service(SPP)에서 입력한 조회조건으로 대상 Coastal SKD에 대한 Prestowage Notice 목적의 Telex 전송내역 저장.
     * 
     * @param EtaSendTgtVO etaSendTgtVO
     * @return String
     */
	@WebMethod()
    public String createTransmitPortSkdPrestowageNotice(EtaSendTgtVO etaSendTgtVO) {
    	
		//Interface ID  SPP_VSK-0012
		Event 						event 	= null;
		ScheduleUtilityManagementSC sc 		= new ScheduleUtilityManagementSC();
		String 						result 	= "";
		
		//::2013-05-20::PRE-STOWAGE NOTICE PURPOSE:://
		final String				sTrsmPurposeCd		= "STW";		
    	
    	log.debug("ScheduleTransmitManagementWSProxy createTransmitPortSkdPrestowageNotice");
    	
    	try {
            /**
             * EVENT 생성 / 전송 
             */
    		if(etaSendTgtVO != null){
    			etaSendTgtVO.setTrsmOwnrCd("ESVC");
    			etaSendTgtVO.setTrsmPurpCd(sTrsmPurposeCd);
    			//::comment:://etaSendTgtVO.setUpdUsrId("ESVCUSER");
    		}

    		event = new VopVskSPPVSK0012Event();
            
            FormCommand f = new FormCommand();
            f.setCommand(FormCommand.MULTI);
            event.setFormCommand(f);
            
            ((VopVskSPPVSK0012Event) event).setEtaSendTgtVO(etaSendTgtVO);
            /**
             * EventResponse로 부터 전송 객체의 생성 
             */

            sc.perform(event);
            
            result	= "Success";
           
    	}catch(EventException ee) {
    		log.error("ScheduleTransmitManagementWSProxy Error : " + ee.toString(), ee);
    		result = ee.toString();
    		
    	}catch(Exception e) {
    		log.error("ScheduleTransmitManagementWSProxy Error : " + e.toString(), e);
    		result = e.toString();
    	}
    	return result;
    }		
	
	
}

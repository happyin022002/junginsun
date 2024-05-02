/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingReqCreateRSC.java
*@FileTitle : Rail Billing Request Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation;

import java.util.HashMap;
import java.util.Iterator;

import com.clt.apps.opus.esd.trs.servicesio.common.vo.CommonVo;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.basic.RailBillingReqCreateBC;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.basic.RailBillingReqCreateBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.BookingDetail;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0010Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0015Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0015EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0018Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0018EventResponse;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0020Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0014Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0016Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.ExpPap0017Event;
import com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event.Usa404EDISendVO;
import com.clt.apps.opus.esd.trs.workordermanage.WorkOrderManageSC;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS 에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author leebh
 * @see EventResponse,RailBillingReqCreateDBDAO 참조
 * @since J2EE 1.4
 */
public class RailBillingReqCreateRSC extends ServiceCommandSupport {
	
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * ESD-TRS 업무 시나리오 선행작업<br>
     * RailBillingRequestCreation 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("RailBillingReqCreateRSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * ESD-TRS 업무 시나리오 마감작업<br>
     * RailBillingRequestCreation 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("RailBillingReqCreateRSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        
        //log.debug("event : " + e);

        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if (e.getEventName().equalsIgnoreCase("ExpPap0010Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRailBillingReqCreateFull(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("ExpPap0014Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = verifyRailBillingReqCreateFull(e);
            }
	    } else if (e.getEventName().equalsIgnoreCase("ExpPap0015Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = insertRailBillingReqCreateFull(e);
	    	}
	    } else if (e.getEventName().equalsIgnoreCase("ExpPap0016Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchRailBillingReqCreateEmpty(e);
	    	}
	    } else if (e.getEventName().equalsIgnoreCase("ExpPap0017Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = verifyRailBillingReqCreateEmpty(e);
	    	}
	    } else if (e.getEventName().equalsIgnoreCase("ExpPap0018Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = insertRailBillingReqCreateEmpty(e);
	    	}
	    } else if (e.getEventName().equalsIgnoreCase("ExpPap0020Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchRailBillingReqCreateExcelFull(e);
	    	}
	    }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * RailBillingRequestCreation Search (Full)의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRailBillingReqCreateFull(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	ExpPap0010Event event = (ExpPap0010Event)e;
        	RailBillingReqCreateBC command = new RailBillingReqCreateBCImpl();
            eventResponse = command.searchRailBillingReqCreateFull(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }

        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * RailBillingRequestCreation Search Excel (Full)의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRailBillingReqCreateExcelFull(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	EventResponse eventResponse = null;
    	
    	try {
    		ExpPap0020Event event = (ExpPap0020Event)e;
    		RailBillingReqCreateBC command = new RailBillingReqCreateBCImpl();
    		eventResponse = command.searchRailBillingReqCreateExcelFull(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	return eventResponse;
    }
    
    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse verifyRailBillingReqCreateFull(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	EventResponse eventResponse = null;
    	
    	try {
    		ExpPap0014Event event = (ExpPap0014Event)e;
    		RailBillingReqCreateBC command = new RailBillingReqCreateBCImpl();
    		eventResponse = command.verifyRailBillingReqCreateFull(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	return eventResponse;
    }

    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse insertRailBillingReqCreateFull(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	EventResponse eventResponse = null;
    	RailBillingReqCreateBC command = null;
    	String successFlag = "FAIL";
    	ExpPap0015Event event = null;
    	
    	BLDocumentationCMBC updVgmToBkg = null;
    	BookingDetail[] bookingDetailList = null;
    	//log.error("#WRS# Full Creation Start");
    	String destYdCd = "";
    	
    	try {
    		event = (ExpPap0015Event)e;
    		command = new RailBillingReqCreateBCImpl();

    		// Creation 처리
    		begin();
    		eventResponse = command.insertRailBillingReqCreateFull(event);
    		commit();
    		//rollback();
    		successFlag = ((ExpPap0015EventResponse)eventResponse).getSuccessFlag();
    		
    		log.error("#WRS#     -- Full Billing BkgNo:["+event.getBkg_no()+"]");
    		log.error("#WRS#     -- Full Billing Status:"+successFlag);
    		
//    		destYdCd = event.getRailRampLocation().getDest_yd_cd();
//    		if(destYdCd != null && !"".equals(destYdCd))
//    			destYdCd = destYdCd.substring(0, 2);
    		
//    		if(destYdCd != null && !"".equals(destYdCd) && !"CA".equals(destYdCd)){
//	    		if(Constants.PROC_SUCCESS.equals(successFlag)) {
//	    			updVgmToBkg = new BLDocumentationCMBCImpl();
//	    			bookingDetailList = event.getBookingDetailList();
//	    			for(int i = 0; i < bookingDetailList.length; i++) {
//	    				ContainerVO cntrVo =new ContainerVO();
//	    				log.debug("getVgm_wgt   :  " +bookingDetailList[i].getVgm_wgt());
//	    				log.debug("getCntr_no   :  " +bookingDetailList[i].getCntr_no());
//	    				log.debug("getBkg_no   :  " +event.getBkg_no());
//	    				log.debug("getUser_id   :  " +event.getUser_id());
//	    				
//	    				cntrVo.setVgmWgt(bookingDetailList[i].getVgm_wgt());
//	    				cntrVo.setVgmWgtUtCd("LBS");
//	    				cntrVo.setCntrNo(bookingDetailList[i].getCntr_no());
//	    				cntrVo.setBkgNo(event.getBkg_no());
//	    				cntrVo.setUpdUsrId("SPPID:"+event.getUser_id());
//	    				
//	    				updVgmToBkg.updateVGMFromTrs(cntrVo);			
//	    			}
//	    		}
//    		}
    		
        } catch (EventException ee) {
        	rollback();
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	rollback();
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    		
        log.error("#WRS#     -- Full EDI Send Start");
        if(Constants.PROC_SUCCESS.equals(successFlag)) {
        	log.debug("#WRS#     -- Full EDI Send Processing...1");
	    	try {
	    		// EDI 전송처리 
	    		// Creation 처리 성공한 경우만 처리 
	    		// EDI 전송 실패해도 상관없이 정상 리턴
	        	String cntr_ofc_cd = "";
	        	String user_id = "";
	        	int ediSendErrCnt = 0;
	        	
	        	Usa404EDISendVO ediSendInfo = ((ExpPap0015EventResponse)eventResponse).getEdiSendInfo();
	        	cntr_ofc_cd = ediSendInfo.getCntr_ofc_cd();
	        	user_id = ediSendInfo.getUser_id();
	        	
	    		Iterator it = ediSendInfo.getEdi_send_list().iterator();
	    		TrsTrspEdiRailOrdVO ediSendVOs[] = new TrsTrspEdiRailOrdVO[ediSendInfo.getEdi_send_list().size()];
	    		int nCnt = 0;
	    		while (it.hasNext()) {
	    			ediSendVOs[nCnt] = (TrsTrspEdiRailOrdVO)it.next();
	    			
	    			log.error("#WRS#     -- Full EDI Send Processing...2 CntrNo["+ediSendVOs[nCnt].getEqNo()+"]");

	    			if(ediSendVOs[nCnt].getRailCmbThruTpCd()!= null) {
	    				if("S2R".equals(ediSendVOs[nCnt].getRailCmbThruTpCd())) {
	    					ediSendErrCnt++;
	    				} else if("S3R".equals(ediSendVOs[nCnt].getRailCmbThruTpCd())) {
	    					ediSendErrCnt++;
	    				} 
	    			}
        			log.error("getIbflag : " +ediSendVOs[nCnt].getIbflag());
	        		log.error("getTrspSoOfcCtyCd : "+ediSendVOs[nCnt].getTrspSoOfcCtyCd());
	        		log.error("getTrspSoSeq : "+ediSendVOs[nCnt].getTrspSoSeq());
	        		log.error("getRailCmbThruTpCd : "+ediSendVOs[nCnt].getRailCmbThruTpCd());
	        		log.error("getBkgNo : "+ediSendVOs[nCnt].getBkgNo());
	        		log.error("getBkgCgoTpCd : "+ediSendVOs[nCnt].getBkgCgoTpCd());
	        		log.error("getVndrSeq : "+ediSendVOs[nCnt].getVndrSeq());
	        		log.error("getEqNo : "+ediSendVOs[nCnt].getEqNo());
	        		log.error("getEqTpszCd : "+ediSendVOs[nCnt].getEqTpszCd());
	        		log.error("getFmNodCd : "+ediSendVOs[nCnt].getFmNodCd());
	        		log.error("getToNodCd : "+ediSendVOs[nCnt].getToNodCd());
	        		log.error("getMtcEdiIndCd : "+ediSendVOs[nCnt].getMtcEdiIndCd());
	        		log.error("getCgoTpCd : "+ediSendVOs[nCnt].getCgoTpCd());
	        		log.error("getCopNo : "+ediSendVOs[nCnt].getCopNo());
	        		log.error("getCostActGrpSeq : "+ediSendVOs[nCnt].getCostActGrpSeq());
	        		nCnt++;
	    			
	    		}
	    		log.error("#WRS#     -- Full EDI Send Processing...3");
	    		if(ediSendErrCnt > 0) {
	    			throw new DAOException("EDI Send Error : RAIL COMBINED THROUGH TYPE CODE IS S2R, S3R");
	    		}
	    		log.error("#WRS#     -- Full EDI Send Processing...4 cntr_ofc_cd:[" + (cntr_ofc_cd == null ? "<null>" : cntr_ofc_cd) +"]");
	    		log.error("#WRS#     -- Full EDI Send Processing...5 user_id:[" + (user_id == null ? "<null>" : user_id) +"]");
	    		log.error("#WRS#     -- Full EDI Send Processing...6 list cnt:[" + (ediSendInfo.getEdi_send_list() == null ? "<null>" : String.valueOf(ediSendInfo.getEdi_send_list().size())) +"]");
	    		if( cntr_ofc_cd != null && !Constants.EMPTY.equals(cntr_ofc_cd) &&
	    			user_id != null && !Constants.EMPTY.equals(user_id) &&
	    			ediSendInfo.getEdi_send_list() != null && ediSendInfo.getEdi_send_list().size() > 0 ) {
	    			
	    			log.error("#WRS#     -- Full EDI Send Processing...7");
	    			
	    			//HashMap hashParams = new HashMap();
	    			//hashParams.put("ctrl_ofc_cd", cntr_ofc_cd);
	    			//hashParams.put("user_id", user_id);
	    			
	    			WorkOrderManageSC ediSC = new WorkOrderManageSC();
	    			EsdTrs0028Event ediEvent = new EsdTrs0028Event(null,ediSendVOs);
	    			FormCommand f = new FormCommand();
	    			f.setCommand(FormCommand.MULTI);	    			
	    			ediEvent.setFormCommand(f);
	    			ediEvent.setCtrlOfcCd(cntr_ofc_cd);
	    			ediEvent.setUserId(user_id);
	    			//ediEvent.setEventParams(hashParams);
	    			log.error("ediEvent.getCtrlOfcCd() ctrl_ofc_cd :	"+ ediEvent.getCtrlOfcCd());
	    			log.error("ediEvent.getUserId() user_id :	"+ ediEvent.getUserId());
	    			
	    			log.error("#WRS#     -- Full EDI Send Processing...8");
	    			ediSC.perform(ediEvent);
	    			log.error("#WRS#     -- Full EDI Send Processing...9");
	    		}
	        } catch (EventException ee) {
	        	log.error("err "+ee.getMessage(),ee);
	            // EDI 전송 에러는 무시한다.
	        	throw ee;
	        } catch (Exception ex) {
	        	log.error("err "+ex.toString(),ex);
	        	// EDI 전송 에러는 무시한다.
	        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
	        }
	        log.error("#WRS# Full EDI Send End");
        }
        log.error("#WRS# Full Creation End");
    	return eventResponse;
    }
    
    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchRailBillingReqCreateEmpty(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        
        try {
        	ExpPap0016Event event = (ExpPap0016Event)e;
        	RailBillingReqCreateBC command = new RailBillingReqCreateBCImpl();
            eventResponse = command.searchRailBillingReqCreateEmpty(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
        return eventResponse;
    }
    
    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse verifyRailBillingReqCreateEmpty(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	EventResponse eventResponse = null;
    	
    	try {
    		ExpPap0017Event event = (ExpPap0017Event)e;
    		RailBillingReqCreateBC command = new RailBillingReqCreateBCImpl();
    		eventResponse = command.verifyRailBillingReqCreateEmpty(event);
        } catch (EventException ee) {
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	return eventResponse;
    }
    
    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse insertRailBillingReqCreateEmpty(Event e) throws EventException {
    	// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	EventResponse eventResponse = null;
    	RailBillingReqCreateBC command = null;
    	String successFlag = "FAIL";
    	ExpPap0018Event event = null;
    	
    	//log.error("#WRS# MT Creation Start");
    	
    	try {
    		event = (ExpPap0018Event)e;
    		command = new RailBillingReqCreateBCImpl();
    		
    		// Creation 처리
    		begin();
    		eventResponse = command.insertRailBillingReqCreateEmpty(event);
    		commit();
    		//rollback();
    		successFlag = ((ExpPap0018EventResponse)eventResponse).getSuccessFlag();
    		
    		//log.error("#WRS#     -- MT Billing Status:"+successFlag);    		
    		
        } catch (EventException ee) {
        	rollback();
        	log.error("err "+ee.getMessage(),ee);
            throw ee;
        } catch (Exception ex) {
        	rollback();
        	log.error("err "+ex.toString(),ex);
        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
        }
    	
        log.error("#WRS#     -- MT EDI Send Start");
        if(Constants.PROC_SUCCESS.equals(successFlag)) {
        	log.error("#WRS#     -- MT EDI Send Processing...1");
	    	try {
	    		// EDI 전송처리 
	    		// Creation 처리 성공한 경우만 처리 
	    		// EDI 전송 실패해도 상관없이 정상 리턴
	        	String cntr_ofc_cd = "";
	        	String user_id = "";
	        	int ediSendErrCnt = 0;
	        	
	        	Usa404EDISendVO ediSendInfo = ((ExpPap0018EventResponse)eventResponse).getEdiSendInfo();
	        	cntr_ofc_cd = ediSendInfo.getCntr_ofc_cd();
	        	user_id = ediSendInfo.getUser_id();
	        	
	    		Iterator it = ediSendInfo.getEdi_send_list().iterator();
	    		TrsTrspEdiRailOrdVO ediSendVOs[] = new TrsTrspEdiRailOrdVO[ediSendInfo.getEdi_send_list().size()];
	    		int nCnt = 0;
	    		while (it.hasNext()) {
	    			ediSendVOs[nCnt] = (TrsTrspEdiRailOrdVO)it.next();
	    			
	    			log.error("#WRS#     -- MT EDI Send Processing...2 CntrNo["+ediSendVOs[nCnt].getEqNo()+"]");
	    			
	    			if(ediSendVOs[nCnt].getRailCmbThruTpCd() != null) {
	    				if("S2R".equals(ediSendVOs[nCnt].getRailCmbThruTpCd())) {
	    					ediSendErrCnt++;
	    				} else if("S3R".equals(ediSendVOs[nCnt].getRailCmbThruTpCd())) {
	    					ediSendErrCnt++;
	    				} 
	    			}
	    			nCnt++;
	    		}
	    		
	    		log.error("#WRS#     -- MT EDI Send Processing...3");
	    		if(ediSendErrCnt > 0) {
	    			throw new DAOException("EDI Send Error : RAIL COMBINED THROUGH TYPE CODE IS S2R, S3R");
	    		}
	    		
	    		log.error("#WRS#     -- MT EDI Send Processing...4 cntr_ofc_cd:[" + (cntr_ofc_cd == null ? "<null>" : cntr_ofc_cd) +"]");
	    		log.error("#WRS#     -- MT EDI Send Processing...5 user_id:[" + (user_id == null ? "<null>" : user_id) +"]");
	    		log.error("#WRS#     -- MT EDI Send Processing...6 list cnt:[" + (ediSendInfo.getEdi_send_list() == null ? "<null>" : String.valueOf(ediSendInfo.getEdi_send_list().size())) +"]");	    		
	    		if( cntr_ofc_cd != null && !Constants.EMPTY.equals(cntr_ofc_cd) &&
	    			user_id != null && !Constants.EMPTY.equals(user_id) &&
	    			ediSendInfo.getEdi_send_list() != null && ediSendInfo.getEdi_send_list().size() > 0 ) {
	    		
	    			log.error("#WRS#     -- MT EDI Send Processing...7");
	    			
	    			HashMap hashParams = new HashMap();
	    			hashParams.put("ctrl_ofc_cd", cntr_ofc_cd);
	    			hashParams.put("user_id", user_id);
	    			
	    			WorkOrderManageSC ediSC = new WorkOrderManageSC();
	    			EsdTrs0028Event ediEvent = new EsdTrs0028Event(null,ediSendVOs);
	    			FormCommand f = new FormCommand();
	    			f.setCommand(FormCommand.MULTI);	    			
	    			ediEvent.setFormCommand(f);	    			
	    			ediEvent.setCtrlOfcCd(cntr_ofc_cd);
	    			ediEvent.setUserId(user_id);
	    			//ediEvent.setEventParams(hashParams);
	    			log.debug("ediEvent.getCtrlOfcCd() ctrl_ofc_cd :	"+ ediEvent.getCtrlOfcCd());
	    			log.debug("ediEvent.getUserId() user_id :	"+ ediEvent.getUserId());
	    			
	    			log.error("#WRS#     -- MT EDI Send Processing...8");
	    			ediSC.perform(ediEvent);
	    			log.error("#WRS#     -- MT EDI Send Processing...9");
	    		}
	        } catch (EventException ee) {
	        	log.error("err "+ee.getMessage(),ee);
	            // EDI 전송 에러는 무시한다.
	        	throw ee;
	        } catch (Exception ex) {
	        	log.error("err "+ex.toString(),ex);
	        	// EDI 전송 에러는 무시한다.
	        	throw new EventException(Constants.UNHANDLED_EXPT_MSG);
	        }
	        log.error("#WRS# MT EDI Send End");
        }
        log.error("#WRS# MT Creation End");
        
    	return eventResponse;
    }
}
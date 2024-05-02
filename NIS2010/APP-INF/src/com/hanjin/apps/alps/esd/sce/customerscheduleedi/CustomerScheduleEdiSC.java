/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomerScheduleEdiSC.java
*@FileTitle : CustomerScheduleEdiSC
*Open Issues :
*Change history :
*@LastModifyDate : 2010-01-13
*@LastModifier : 이윤정
*@LastVersion : 1.01
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.basic.LaneServiceBC;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.basic.LaneServiceBCImpl;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.event.EsdSce0122Event;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchLaneServiceVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.basic.PortPairExceptionBC;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.basic.PortPairExceptionBCImpl;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0123Event;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0124Event;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0125Event;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0127Event;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.CustomerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentLaneVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.ExceptionalRouteVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.PartnerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.basic.PortPairRouteBC;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.basic.PortPairRouteBCImpl;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.event.EsdSce0120Event;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.event.EsdSce0121Event;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.event.EsdSce0126Event;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairOceanRouteInformationVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ENIS-SCE 모든 VisibilityManage Business Logic ServiceCommand<br>
 * - ENIS-SCE에 VisibilityManage대한 비지니스 트랜잭션을 처리한다.<br>
 * @param 
 * @author Seong-mun Kang
 * @see VisibilityManageEvent, VisibilityManageEventResponse
 * @since J2EE 1.4
 */
public class CustomerScheduleEdiSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;

	/**
	 * SCE 업무 시나리오 선행작업<br>
	 * ExceptionManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
//			account.getOfc_cd();
//			log.info("\n account.getOfc_cd "+account.getOfc_cd());
		} catch (Exception e) {  
			log.error("ExceptionManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * SCE 업무 시나리오 마감작업<br>
	 * ExceptionManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ExceptionManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-SCE 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		log.debug("\n 여기는 SC perform");
		
		if (e.getEventName().equalsIgnoreCase("EsdSce0120Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchPortPairMasters(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				   eventResponse = searchPartnerName(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = modifyPortPairMaster(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				   eventResponse = insertPartnerCode(e);
			   }
			   
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0121Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchPortPairDetails(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				   eventResponse = searchPartnerName(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = modifyPortPairDetail(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
//				   eventResponse = searchPartnerCombo(e);
				   eventResponse = searchPortPairPartner(e);
			   }
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchLaneServiceList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageLaneService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0123Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchEdi323Adjustment(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { 
				eventResponse = searchRouteListForBlockLane(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageEdi323Adjustment(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchPortPairPartner(e);
			}
			/*if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchRouteListForAdjustment(e);
			}*/
			/*else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageAdjustment(e);
			}*/
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0124Event")) {
		   if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			    eventResponse = searchBlockLaneList(e);
		   }
		   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageBlockLane(e);
		   }			//화면 Open시 코드성 data읽어오기
			else{
				eventResponse = searchLaneCombo(e);	
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdSce0125Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchExceptionalRouteList(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				   eventResponse = searchCustomerName(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				   eventResponse = manageExceptionRoute(e);
			   }
			   else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				   eventResponse = insertPartnerCode(e);
			   }
		}else if (e.getEventName().equalsIgnoreCase("EsdSce0126Event")) {
			   if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				   eventResponse = searchPortPairOceanRouteInformation(e);
			   }
		}else if (e.getEventName().equalsIgnoreCase("EsdSce0127Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			    eventResponse = searchEdi323AdjustmentLane(e);
		   }			//화면 Open시 코드성 data읽어오기
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchLaneCombo0127(e);	
			}
		}	   	   
		return eventResponse;
	}
	
    private EventResponse searchEdi323AdjustmentLane(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)

    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0127Event event = (EsdSce0127Event) e;

    	PortPairExceptionBC command = new PortPairExceptionBCImpl();
    	List<Edi323AdjustmentLaneVO> list = command.searchEdi323AdjustmentLane(event);
    	
    	eventResponse.setRsVoList(list);
    	return eventResponse;
	}

	private EventResponse manageEdi323Adjustment(Event e) throws EventException  {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0123Event event = (EsdSce0123Event)e ;
    	PortPairExceptionBC command = new PortPairExceptionBCImpl();
        try {
        	Edi323AdjustmentVO[] adjustmentVOs = event.getEdi323AdjustmentVOs();
        	
        	
			if(adjustmentVOs!=null && adjustmentVOs.length!=0){
				begin();
				command.manageEdi323Adjustment(adjustmentVOs, account);
				commit();
			}
			
        } catch (EventException de) {
			rollback();        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
	}

	/**
     * Edi323Adjustment 조회<br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchEdi323Adjustment(Event e) throws EventException {
    	EsdSce0123Event event = (EsdSce0123Event) e;
    	Edi323AdjustmentVO vo = event.getEdi323AdjustmentVO();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		List<Edi323AdjustmentVO> list = command.searchEdi323Adjustment(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
     * PortPairPartner 조회<br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchPortPairPartner(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	PortPairExceptionBC command = new PortPairExceptionBCImpl();
		try{
			List<PartnerVO> list = command.searchPortPairPartner();
				
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	

	/**
     * PortPairOceanRouteInformation 조회<br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchPortPairOceanRouteInformation(Event e) throws EventException {
        EsdSce0126Event event = (EsdSce0126Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PortPairRouteBC command = new PortPairRouteBCImpl();
//        String partnerId = event.getString("cust_trd_prnr_id");
        PortPairRouteDetailVO portPairRouteDetailVO = event.getPortPairRouteDetailVO();
//        PortPairRouteDetailVO portPairRouteDetailVO = detailVOs[0];
        try {
        	List<PortPairOceanRouteInformationVO> list = command.searchPortPairOceanRouteInformation(portPairRouteDetailVO);
        	eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
	}

	/**
     * TP Name 조회<br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCustomerName(Event e) throws EventException {
        EsdSce0122Event event = (EsdSce0122Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        LaneServiceBC command = new LaneServiceBCImpl();
        String partnerId = event.getString("cust_trd_prnr_id");
        try {
        	List<SearchGetPartnerVO> list = command.searchCustomerInfo(partnerId);
            String custTrdPrnrId = "";	String custTrdPrnrNm = "";	String ediSvcTpNm = "";
        	//if(!partnerId.equals(null)){
        	if(partnerId != null){
        		Iterator<SearchGetPartnerVO> iter = list.iterator(); 
        		SearchGetPartnerVO getPartnerVO = new SearchGetPartnerVO();
        		
        		while(iter.hasNext()){
        			getPartnerVO = (SearchGetPartnerVO)iter.next();
        			custTrdPrnrId = getPartnerVO.getCustTrdPrnrId();
        			custTrdPrnrNm = getPartnerVO.getCustTrdPrnrNm();
        			ediSvcTpNm	  =	getPartnerVO.getEdiSvcTpNm();
        			
        			break;
        		}
        	}
        	
    		//if(!custTrdPrnrNm.equals(null)){
    		if(custTrdPrnrNm != null){
    			eventResponse.setETCData("partnerName", custTrdPrnrNm);
    		}else{
    			eventResponse.setETCData("partnerName", "");
    		}
    		//if(!custTrdPrnrId.equals(null)){
    		if(custTrdPrnrId != null){
    			eventResponse.setETCData("custTrdPrnrId", custTrdPrnrId);
    			eventResponse.setETCData("ediSvcTpNm", ediSvcTpNm);
    		}else{
    			eventResponse.setETCData("custTrdPrnrId", "");
    			eventResponse.setETCData("ediSvcTpNm", "");
    		}
        	

        } catch (EventException de) {
			rollback();        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * Port Pair Master 조회<br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchLaneServiceList(Event e) throws EventException {
        EsdSce0122Event event = (EsdSce0122Event)e ;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        LaneServiceBC command = new LaneServiceBCImpl();
        String partnerId = event.getString("cust_trd_prnr_id");
        try {
        	List<SearchLaneServiceVO> list = command.searchLaneServiceList(partnerId);
        	eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * Port Pair Detail 등록<br>
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageLaneService(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0122Event event = (EsdSce0122Event)e ;
    	LaneServiceBC command = new LaneServiceBCImpl();
        try {
        	SearchLaneServiceVO[] portPairRVOs = event.getSearchLaneServiceVOs();
        	
			if(portPairRVOs!=null && portPairRVOs.length!=0){
				begin();
				command.manageLaneService(portPairRVOs, account);
				commit();
			}
			//eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
        } catch (EventException de) {
			rollback();        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
	/**
	 * ESD_SCE_0123 : 저장화면<br>
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */
    /*
    private EventResponse manageAdjustment(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0123Event event = (EsdSce0123Event)e ;
    	PortPairExceptionBC command = new PortPairExceptionBCImpl();
        try {
        	AdjustmentVO[] adjustmentVOs = event.getAdjustmentVOs(); 
        	
			if(adjustmentVOs!=null && adjustmentVOs.length!=0){
				begin();
				command.manageAdjustment(adjustmentVOs, account);
				commit();
			}
			
        } catch (EventException de) {
			rollback();        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    */
    
    /**
     * Port Pair Detail 조회<br>
     * @param e 
     * @return EventResponse
     * @exception EventException
     *//*
    private EventResponse searchRouteListForAdjustment(Event e) throws EventException {
		EsdSce0123Event event = (EsdSce0123Event) e;
		AdjustmentVO vo = event.getAdjustmentVO();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		List<AdjustmentVO> list = command.searchRouteListForAdjustment(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    	 
    }
    */
	/**
	 * BlockLane List 조회<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchRouteListForBlockLane(Event e) throws EventException {
		EsdSce0123Event event = (EsdSce0123Event) e;
		RouteForBLVO vo = event.getRouteForBLVO();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		List<RouteForBLVO> list = command.searchRouteListForBlockLane(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
    	 
    }
    
	 /**
	  * ESD_SCE_124 : list조회<br>
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse searchBlockLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0124Event event = (EsdSce0124Event) e;
		BlockLaneVO vo = event.getBlockLaneVO();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		List<BlockLaneVO> list = command.searchBlockLaneList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	 }
	 
	 /**
	  * ESD_SCE_124 : CUS<br>
	  * @param Event e
	  * @return EventResponse
	  * @exception EventException
	  */
	 private EventResponse manageBlockLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0124Event event = (EsdSce0124Event) e;
		BlockLaneVO[] vos = event.getBlockLaneVOs();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		PortPairExceptionBC command = new PortPairExceptionBCImpl();

		try {
			begin();
			command.manageBlockLane(vos, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		}
		return eventResponse;
	 }
	 
	/**
	 * ESD_SCE_124 : 화면 open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CustomerVO customerVO = new CustomerVO();	//

		//Lane Code 조회
		 List<CustomerVO> list = command.searchLaneCombo(customerVO);
		
		Iterator iterator = (Iterator) list.iterator();

		String rlaneComboList = "";
		String rlaneNmComboList = "";
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(iterator.hasNext()){
			customerVO = (CustomerVO)iterator.next();
			sb1.append(customerVO.getCode()+"|");
			sb2.append(customerVO.getName()+"|");
		}
		
		rlaneComboList = sb1.toString();
		rlaneNmComboList = sb2.toString();
		
		if (rlaneComboList.length() > 0){
			rlaneComboList = rlaneComboList.substring(0,rlaneComboList.length()-1);
			rlaneNmComboList = rlaneNmComboList.substring(0,rlaneNmComboList.length()-1);;
		}

		eventResponse.setETCData("rlaneSheetList", rlaneComboList);
		eventResponse.setETCData("rlaneNmSheetList", rlaneNmComboList);
		return eventResponse;
	}
	
	/**
	 * ESD_SCE_127 : 화면 open
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchLaneCombo0127(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0127Event event = (EsdSce0127Event) e;
		PortPairExceptionBC command = new PortPairExceptionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CustomerVO customerVO = new CustomerVO();	//

		//Lane Code 조회
		 List<CustomerVO> list = command.searchLaneCombo(customerVO);
		
		Iterator iterator = (Iterator) list.iterator();

		String rlaneComboList = "";
		String rlaneNmComboList = "";
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(iterator.hasNext()){
			customerVO = (CustomerVO)iterator.next();
			sb1.append(customerVO.getCode()+"|");
			sb2.append(customerVO.getName()+"|");
		}
		
		rlaneComboList = sb1.toString();
		rlaneNmComboList = sb2.toString();
		
		if (rlaneComboList.length() > 0){
			rlaneComboList = rlaneComboList.substring(0,rlaneComboList.length()-1);
			rlaneNmComboList = rlaneNmComboList.substring(0,rlaneNmComboList.length()-1);;
		}

		eventResponse.setETCData("rlaneSheetList", rlaneComboList);
		eventResponse.setETCData("rlaneNmSheetList", rlaneNmComboList);
		/*eventResponse.setETCData("adj_rgst_dt", event.getEdi323AdjustmentLaneVO().getAdjRgstDt());
		eventResponse.setETCData("adj_seq", event.getEdi323AdjustmentLaneVO().getAdjSeq());*/
		eventResponse.setETCData("slan_cd", (String) event.getAttribute("slan_cd"));
		return eventResponse;
	}
	
//	/**
//	 * List를 IBMultiCombo나 IBSheet내의 Combo의 item으로 넣기 위해 String으로 변환해준다.
//	 * @param List<CustomerVO> list
//	 * @param int flg
//	 * @return String
//	 * @throws EventException
//	 */
//	private String makeComboString(List<CustomerVO> list, int flg) throws EventException{
//		String rtnVal = null;
//		StringBuilder sb = new StringBuilder();
//
//		Iterator iterator = (Iterator) list.iterator();
//
//		while(iterator.hasNext()){
//			CustomerVO customerVO = (CustomerVO)iterator.next();
//			//일반적인 IBCombo용(name, code|)
//			if (flg==0){
//				sb.append(customerVO.getName()+","+customerVO.getCode()+"|");				
//			//IBCombo (code, code|)
//			}else if (flg==1){
//				sb.append(customerVO.getCode()+","+customerVO.getCode()+"|");				
//			//IBSheet의 코드부분(code|)
//			}else if (flg==2){
//				sb.append(customerVO.getCode()+"|");				
//			//IBSheet의 코드명부분(name|)
//			}else if (flg==3){
//				sb.append(customerVO.getName()+"|");				
//			//SuperCd조회
//			}else if (flg==4){
//				sb.append(customerVO.getSuperCd1()+","+customerVO.getSuperCd2()+","+customerVO.getCode()+"|");				
//			}else if (flg==5){
//				sb.append(customerVO.getCode()+"\t"+customerVO.getName()+"|");				
//			}
//		}
//		
//		rtnVal = sb.toString();
//		
//		if (rtnVal.length() > 0){
//			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
//		}
//		
//		return rtnVal;
//	}
	
	/**
	 * Port Pair Detail 검색 리스트 조회<br>
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExceptionalRouteList(Event e) throws EventException {
	    EsdSce0125Event event = (EsdSce0125Event)e ;
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    PortPairExceptionBC command = new PortPairExceptionBCImpl();
	    try {
	    	List<ExceptionalRouteVO> list = command.searchExceptionalRouteList(event.getExceptionalRouteVO());
	    	eventResponse.setRsVoList(list);
	    } catch (EventException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(de.getMessage());
	    }
	    return eventResponse;
	}
	
	/**
	 * ESD_SCE_0125 : 저장화면<br>
	 * @param e 
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse manageExceptionRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0125Event event = (EsdSce0125Event)e ;
		PortPairExceptionBC command = new PortPairExceptionBCImpl();
	    try {
	    	ExceptionalRouteVO[] exceptionalRouteVOs = event.getExceptionalRouteVOs(); 
	    	
			if(exceptionalRouteVOs!=null && exceptionalRouteVOs.length!=0){
				begin();
				command.manageExceptionRoute(exceptionalRouteVOs, account);
				commit();
			}
			//eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
	    } catch (EventException de) {
	    	rollback();        	
	        log.error("err " + de.toString(), de);
	        throw new EventException(de.getMessage());
	    }
	    return eventResponse;
	}
	
		/**
	     * Port Pair Master 조회<br>
	     * @param e 
	     * @return EventResponse
	     * @exception EventException
	     */
	    private EventResponse searchPartnerName(Event e) throws EventException {
	        EsdSce0120Event event = (EsdSce0120Event)e ;
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        PortPairRouteBC command = new PortPairRouteBCImpl();
	        try {
	        	String ret = command.searchPartnerName(event.getPartnerId());
	        	eventResponse.setETCData("partner_name", ret);
	        } catch (EventException de) {
	            log.error("err " + de.toString(), de);
	            throw new EventException(de.getMessage());
	        }
	        return eventResponse;
	    }
	    
	    
		/**
	     * Port Pair Master 조회<br>
	     * @param Event e 
	     * @return EventResponse
	     * @exception EventException
	     */
	    private EventResponse searchPortPairMasters(Event e) throws EventException {
	        EsdSce0120Event event = (EsdSce0120Event)e ;
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        PortPairRouteBC command = new PortPairRouteBCImpl();
	        try {
	        	List<PortPairRouteMstVO> list = command.searchPortPairMasters(event.getPortPairRouteConditionVO());
	        	eventResponse.setRsVoList(list);
	        } catch (EventException de) {
	            log.error("err " + de.toString(), de);
	            throw new EventException(de.getMessage());
	        }
	        return eventResponse;
	    }
	    
	    /**
	     * Port Pair Detail 검색 리스트 조회<br>
	     * @param Event e 
	     * @return EventResponse
	     * @exception EventException
	     */
	    private EventResponse searchPortPairDetails(Event e) throws EventException {
	        EsdSce0121Event event = (EsdSce0121Event)e ;
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        PortPairRouteBC command = new PortPairRouteBCImpl();
	        try {
	        	List<PortPairRouteDetailVO> list = command.searchPortPairDetails(event.getPortPairRouteConditionVO());
	        	eventResponse.setRsVoList(list);
	        } catch (EventException de) {
	            log.error("err " + de.toString(), de);
	            throw new EventException(de.getMessage());
	        }
	        return eventResponse;
	    }
	    
	    /**
	     * 파트너 등록한다.<br>
	     * @param Event e 
	     * @return EventResponse
	     * @exception EventException
	     */
	    private EventResponse insertPartnerCode(Event e) throws EventException {
	    	PortPairRouteConditionVO portPairRouteConditionVO = null;
			if (e.getEventName().equalsIgnoreCase("EsdSce0120Event")) {
				EsdSce0120Event event = (EsdSce0120Event) e;
				portPairRouteConditionVO = event.getPortPairRouteConditionVO();
			} else {
				EsdSce0125Event event = (EsdSce0125Event) e;
				portPairRouteConditionVO = event.getPortPairRouteConditionVO();
			}
	    	
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        PortPairRouteBC command = new PortPairRouteBCImpl();
	        try {
	        	if (!command.searchPartnerName(portPairRouteConditionVO.getPartnerId()).equals("")){
	        		throw new EventException(new ErrorHandler("This Partner ID already existed.").getMessage());	
	        	}
	        	begin();
	        	command.insertPartnerCode(portPairRouteConditionVO);
	        	commit();
	        } catch (EventException de) {
	        	rollback();
	            log.error("err " + de.toString(), de);
	            throw new EventException(de.getMessage());
	        }
	        return eventResponse;
	    }
	    
	    /**
	     * PortPairMaster 정보 관리.<br>
	     * @param Event e 
	     * @return EventResponse
	     * @exception EventException
	     */
	    private EventResponse modifyPortPairMaster(Event e) throws EventException {
	        EsdSce0120Event event = (EsdSce0120Event)e ;
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        PortPairRouteBC command = new PortPairRouteBCImpl();
	        Collection<PortPairRouteMstVO> allMasters = new ArrayList<PortPairRouteMstVO>();
	        Collection<PortPairRouteMstVO> noUseMasters = new ArrayList<PortPairRouteMstVO>();
//	        Collection<PortPairRouteDetailVO> noUseDetails = new ArrayList<PortPairRouteDetailVO>();
	        
	        try {
	        	PortPairRouteConditionVO condition = event.getPortPairRouteConditionVO();
	        	PortPairRouteMstVO[] mstVOs = event.getPortPairRouteMstVOs();
	        	
	        	for (int i=0; i<mstVOs.length; i++) {
	        		if (mstVOs[i].getIbflag().equals("I")){	// if add Port Pair
	        			
	        			// POL, POD만 넣고 Save가능 해야함.
	        			// POR 미 입력시 POL=POR, DEL 미 입력시 POD=DEL
	        			if (mstVOs[i].getPorCd() == null || mstVOs[i].getPorCd().equals("")){
	        				mstVOs[i].setPorCd(mstVOs[i].getPolCd());
	        			}
	        			
	        			if (mstVOs[i].getDelCd() == null || mstVOs[i].getDelCd().equals("")){
	        				mstVOs[i].setDelCd(mstVOs[i].getPodCd());
	        			}
	        			
	        			DBRowSet dbRowset=command.searchPortPairMaster(mstVOs[i]);
	        			
	        			//중복 체크 로직
	        			if(dbRowset.getRowCount()>0){	// if that be duplicated..
	        				throw new EventException(new ErrorHandler("PRD00051").getMessage());	
	        			}
	        		} else if (mstVOs[i].getIbflag().equals("U")){	// modify Port Pair
	        			if(mstVOs[i].getUseFlg().equals("N")){	// if no use
	        				noUseMasters.add(mstVOs[i]);
//	        				noUseDetails.addAll(command.searchPortPairDetails(mstVOs[i]));
	        			}
	        		}	
	        		allMasters.add(mstVOs[i]);
	        		
	        	}
	        	
	        	begin();
	        	// Masters will be Added Or Modified.
	        	if ( allMasters.size  () > 0 )	command.modifyPortPairMaster(condition, (PortPairRouteMstVO[])allMasters.toArray(new PortPairRouteMstVO[0]));
	        	// Details of Useless Master will be Added Or Modified.
	        	if ( noUseMasters.size() > 0 )	command.modifyPortPairDetail(condition, (PortPairRouteMstVO[])noUseMasters.toArray(new PortPairRouteMstVO[0]));
	        	// send Useless Port Pair Route to EDI I/F.
//	        	if ( noUseDetails.size() > 0 )	command.addPortPairRouteIF	(condition, noUseDetails);
	        	commit();
	        	
	        } catch (EventException de) {
	        	rollback();
	            log.error("err " + de.toString(), de);
	            throw new EventException(de.getMessage());
	        } catch (Exception ae) {
	        	log.error("err " + ae.toString(), ae);
		        throw new EventException(ae.getMessage());
	        }
	        return eventResponse;
	    }
	    
	    /**
	     * PortPairMaster 정보 관리.<br>
	     * @param Event e 
	     * @return EventResponse
	     * @exception EventException
	     */
	    private EventResponse modifyPortPairDetail(Event e) throws EventException {
	        EsdSce0121Event event = (EsdSce0121Event)e ;
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        PortPairRouteBC command = new PortPairRouteBCImpl();
	        Collection<PortPairRouteDetailVO> allDetails = new ArrayList<PortPairRouteDetailVO>();
//	        StringBuffer sbRoutRcvDt = new StringBuffer();
//	        StringBuffer sbRoutSeq 	 = new StringBuffer();
//	        PortPairRouteDetailVO model = new PortPairRouteDetailVO();
	        
	        try {
	        	PortPairRouteConditionVO condition = event.getPortPairRouteConditionVO();
	        	PortPairRouteDetailVO[] detailVOs = event.getPortPairRouteDetailVOs();
	        	
	        	for (int i=0; i<detailVOs.length; i++) {
	        		if (detailVOs[i].getIbflag().equals("I")){	// add Port Pair
	        			detailVOs[i].setCustTrdPrnrId(condition.getPartnerId());
	        			
	        			//최초 pol_cd, 최종 pod_cd 설정
	        			if (detailVOs[i].getPorCd()==null || detailVOs[i].getPorCd().length() == 0){
	        				detailVOs[i].setPorCd(detailVOs[i].getPolCd());
	        			}
	        			if (detailVOs[i].getDelCd()==null || detailVOs[i].getDelCd().length() == 0){
	        				detailVOs[i].setDelCd(detailVOs[i].getPodCd());
	        			}
	        			detailVOs[i].setN1stPolCd(detailVOs[i].getPolCd());
	        			
	        			if ( (detailVOs[i].getN2ndPolCd()==null || detailVOs[i].getN2ndPolCd().length() == 0) &&
	        				 (detailVOs[i].getN3rdPolCd()==null || detailVOs[i].getN3rdPolCd().length() == 0) &&
	        				 (detailVOs[i].getN4thPolCd()==null || detailVOs[i].getN4thPolCd().length() == 0) ){
	        				detailVOs[i].setN1stPodCd(detailVOs[i].getPodCd());
	        			}
	        			
	        			
	        			if ( (detailVOs[i].getN2ndPolCd()!=null && detailVOs[i].getN2ndPolCd().length() > 0) &&
		        			 (detailVOs[i].getN3rdPolCd()==null || detailVOs[i].getN3rdPolCd().length() == 0) &&
		        			 (detailVOs[i].getN4thPolCd()==null || detailVOs[i].getN4thPolCd().length() == 0) ){
		        				detailVOs[i].setN2ndPodCd(detailVOs[i].getPodCd());
		        				detailVOs[i].setN1stPodCd(detailVOs[i].getN2ndPolCd());
		        		}
	        			
	        			
	        			if ( (detailVOs[i].getN2ndPolCd()!=null && detailVOs[i].getN2ndPolCd().length() > 0) &&
			        		 (detailVOs[i].getN3rdPolCd()!=null && detailVOs[i].getN3rdPolCd().length() > 0) &&
			        		 (detailVOs[i].getN4thPolCd()==null || detailVOs[i].getN4thPolCd().length() == 0) ){
			        				detailVOs[i].setN3rdPodCd(detailVOs[i].getPodCd());
			        				detailVOs[i].setN1stPodCd(detailVOs[i].getN2ndPolCd());
			        				detailVOs[i].setN2ndPodCd(detailVOs[i].getN3rdPolCd());
	        			}
	        			
	        			
	        			if ( (detailVOs[i].getN2ndPolCd()!=null && detailVOs[i].getN2ndPolCd().length() > 0) &&
				        	 (detailVOs[i].getN3rdPolCd()!=null && detailVOs[i].getN3rdPolCd().length() > 0) &&
				        	 (detailVOs[i].getN4thPolCd()!=null && detailVOs[i].getN4thPolCd().length() > 0) ){
				        				detailVOs[i].setN3rdPodCd(detailVOs[i].getPodCd());
				        				detailVOs[i].setN1stPodCd(detailVOs[i].getN2ndPolCd());
				        				detailVOs[i].setN2ndPodCd(detailVOs[i].getN3rdPolCd());
				        				detailVOs[i].setN3rdPodCd(detailVOs[i].getN4thPolCd());
		        		}
	        			
	        			
	        			//master 에 존재하는지 체크
//	        			DBRowSet dbRowset=command.searchPortPairMaster(detailVOs[i]);
//	        			if(dbRowset.getRowCount()<1){	// if had no master.
//	        				throw new DAOException(new ErrorHandler("PRD00018").getMessage());
//	        			}
	        			
	        			//중복 체크 로직
	        			if(command.hasSameRoute(detailVOs[i])){	// has same route? 
	        				throw new EventException(new ErrorHandler("PRD00051").getMessage());	
	        			}
	        			
	        			detailVOs[i].setRoutRcvDt( command.getCurrentDate  () );
	        			detailVOs[i].setRoutSeq  ( command.getNextRouteSeq () );
	        			detailVOs[i].setMnlUseFlg( "Y" );
	        			
	        		} else if (detailVOs[i].getIbflag().equals("D")){	// no use.
	        			detailVOs[i].setMnlUseFlg( "N" );
	        		}	
	        		
	        		allDetails.add(detailVOs[i]);
	        		
//	        		if ( i < detailVOs.length-1)  sbRoutRcvDt.append(detailVOs[i].getRoutRcvDt()).append(",");
//	        		else						  sbRoutRcvDt.append(detailVOs[i].getRoutRcvDt());
//	        		
//	        		if ( i < detailVOs.length-1)  sbRoutSeq.append(detailVOs[i].getRoutSeq()).append(",");
//	        		else						  sbRoutSeq.append(detailVOs[i].getRoutSeq());
	        		
	        	}
	        	
	        	// Details of Useless Port Pair Route Master will be Added Or Modified.
	        	if ( allDetails.size() > 0 )	{
	        		begin();
	        		command.modifyPortPairDetail( condition, (PortPairRouteDetailVO[])allDetails.toArray(new PortPairRouteDetailVO[0]));
//	        		model.setRoutRcvDt(sbRoutRcvDt.toString());
//	        		model.setRoutSeq  (sbRoutSeq.toString());
//	        		command.addPortPairRouteIF  ( condition, command.searchPortPairDetailForEAI(model));
	        		commit();
	        	}
	        	
	        } catch (EventException de) {
	        	rollback();
	            log.error("err " + de.toString(), de);
	            throw new EventException(de.getMessage());
	        } catch (Exception ae) {
	        	log.error("err " + ae.toString(), ae);
		        throw new EventException(ae.getMessage());
	        }
	        return eventResponse;
	    }
	    
}
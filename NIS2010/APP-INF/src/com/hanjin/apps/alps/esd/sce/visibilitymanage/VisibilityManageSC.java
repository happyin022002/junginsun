/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VisibilityManageSC.java
*@FileTitle : Visibility Manage SC
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
* 2012.02.22 채창호 [CHM-201115166-01]:Split 01-US Inland Operation Report 내, 324 EDI 기능 추가
* 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage;

import java.sql.ResultSetMetaData;
import java.util.List;

import monfox.toolkit.snmp.agent.modules.SnmpV2Mib.SysOREntry;

import com.hanjin.apps.alps.esd.sce.common.setup.basic.CustomizedReportSetupBC;
import com.hanjin.apps.alps.esd.sce.common.setup.basic.CustomizedReportSetupBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.basic.CommodityGroupCodeManageBC;
import com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.basic.CommodityGroupCodeManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.event.EsdTrs0075Event;
import com.hanjin.apps.alps.esd.sce.edi324send.basic.Edi324SendBC;
import com.hanjin.apps.alps.esd.sce.edi324send.basic.Edi324SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.SearchEdi324SendVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.basic.CargoTrackingBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.basic.CargoTrackingBCImpl;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.event.EsdSce0038Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.basic.RailTransitReportBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.basic.RailTransitReportBCImpl;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0043Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0044Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0045Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0046Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0048Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListPopVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBKGNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBLNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputCntrVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputVVDVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.basic.VesselReportBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.basic.VesselReportBCImpl;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.event.EsdSce0056Event;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.vo.SearchUSIORListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0746Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ENIS-SCE 모든 VisibilityManage Business Logic ServiceCommand<br>
 * - ENIS-SCE에 VisibilityManage대한 비지니스 트랜잭션을 처리한다.<br>
 * @param 
 * @author Seong-mun Kang
 * @see VisibilityManageEvent , VisibilityManageEventResponse
 * @since J2EE 1.4
 */
public class VisibilityManageSC extends ServiceCommandSupport {
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
		log.info("ExceptionManageSC 종료");
	}
 
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-SCE 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException ... 
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdSce0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchUSCargoTrackingList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCustomerName(e);     
            }
		}		
		else if (e.getEventName().equalsIgnoreCase("EsdSce0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchCLMList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchCLMCountPop(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 
				eventResponse = searchCLMListPop(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0045Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchRTRCnt(e, "single");
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 

				eventResponse = searchRTRList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 
				eventResponse = searchRTRList(e, "single_excel");
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = searchRTRList(e, "multi");
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyRTRReport(e);
        	}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = modifyRTRReportRemark(e);
        	}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRTRSmmyList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRTRSmmyDetail(e);
        	}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchTRCList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { 
				eventResponse = searchMultiInput(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = searchRTRList(e, "multi");
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchUSIORList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUSIORListExcelDown(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {	// Customized RPT Setup 왼쪽 SHEET
				eventResponse = searchCustmRptForm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {	// Customized RPT Setup 오른쪽 SHEET
				eventResponse = searchCustmRptForm2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	// Customized RPT Setup 등록/삭제 -- eventResponse return 값 없이 실행되면 두 번 호출된다.
				eventResponse = modifyCustmRptForm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = sendEdi324Process(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)){
				eventResponse = searchVender(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchCostPod(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchEqmtOfcCd(e);
			}
			
		}
		
		return eventResponse;
	}
 
	/************************************* 강성문 수석 *************************************/
	
	/**
     * Car Location Message 조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCLMList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        EsdSce0043Event event = (EsdSce0043Event)e;
        try {
        	RailTransitReportBC command = new RailTransitReportBCImpl();
            eventResponse = command.searchCLMList(event.getSchClmlOpts());
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }

    /**
     * Car Location Message 조회(pop)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCLMCountPop(Event e) throws EventException {
    	log.info("\n searchCLMCountPop start ");
    	EventResponse eventResponse = new GeneralEventResponse();
        EsdSce0044Event event         = (EsdSce0044Event)e ;
        RailTransitReportBC command = new RailTransitReportBCImpl();
        
        try {
        	eventResponse = command.searchCLMCountPop(event.getSearchRTRInfo());
            return eventResponse; 
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    }
    /**
     * Car Location Message 조회(pop)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCLMListPop(Event e) throws EventException {
    	log.info("\n searchCLMListPop start ");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0044Event event         = (EsdSce0044Event)e ;
        RailTransitReportBC command = new RailTransitReportBCImpl();
        
        try {
        	List<SearchCLMListPopVO> list = command.searchCLMListPop(event.getSearchRTRInfo());
            eventResponse.setRsVoList(list);
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
    }
    
    /**
     * Train & Rail Car 조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchTRCList(Event e) throws EventException {
        EventResponse    eventResponse = null;
        //ESD_SCE_046Event event         = (ESD_SCE_046Event)e ;
        EsdSce0046Event event = (EsdSce0046Event)e;
        try {
            RailTransitReportBC command = new RailTransitReportBCImpl();
            eventResponse = command.searchTRCList(event.getSchTrclOpts());
            log.info("VO 생성");
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * Rail Transit Report<br>
     * 
     * @param Event e
     * @param String type
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRTRCnt(Event e, String type) throws EventException {
    	log.info("\n searchRTRList-Count start ");
        EventResponse    eventResponse = null;
        EsdSce0045Event event         = (EsdSce0045Event)e ;
        RailTransitReportBC command = new RailTransitReportBCImpl();
        
        try {
            
            eventResponse = command.searchRTRCnt(event.getSearchRTRInfo(), type);
            return eventResponse;
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    }
    /**
     * search Rail Transit Report<br>
     * 
     * @param Event e
     * @param String type
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRTRList(Event e, String type) throws EventException {
    	log.info("\n searchRTRList(multi) start ");
//    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0045Event event         = (EsdSce0045Event)e ;
        RailTransitReportBC command = new RailTransitReportBCImpl();
        
        try {
            
        	EventResponse eventresponse = command.searchRTRList(event.getSearchRTRInfo(), event.getSearchRTRLists());
        	//eventResponse.setRsVoList(list);
            return eventresponse;
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    }
    /**
     * search Rail Transit Report<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRTRList(Event e) throws EventException {
    	log.info("\n searchRTRList(single) start "); 
//    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0045Event event         = (EsdSce0045Event)e ;
        RailTransitReportBC command = new RailTransitReportBCImpl();
        
        try {
            EventResponse eventresponse = command.searchRTRList(event.getSearchRTRInfo());
            //eventResponse.setRsVoList(list);
            return eventresponse;
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    }

    /**
     * searchRTRSmmyList<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRTRSmmyList(Event e) throws EventException {
        RailTransitReportBC command 	= new RailTransitReportBCImpl();
        
        try {
            EventResponse eventresponse = command.searchRTRSmmyList(e);
            return eventresponse;
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}
    }

    /**
     * searchRTRSmmyDetail<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchRTRSmmyDetail(Event e) throws EventException {
        RailTransitReportBC command 	= new RailTransitReportBCImpl();
        
        try {
            EventResponse eventresponse = command.searchRTRSmmyDetail(e);
            return eventresponse;
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    }
    
    /**
     * Vessel Inbound Operation Report<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchUSIORList(Event e) throws EventException {
    	log.info("\n searchMultiInput start!! ");
    
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsdSce0056Event event         = (EsdSce0056Event)e ;
    	VesselReportBC command = new VesselReportBCImpl();
    	log.info("OfcCd ====================== " + account.getOfc_cd());
    
    	try {
    		DBRowSet dbrowSet = command.searchUSIORList(event.getSearchUSIORInfo(), account.getOfc_cd());
          //  eventResponse.setRsVoList(list);
            eventResponse.setRs(dbrowSet);
    	}catch(EventException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new EventException(ex.getMessage(), ex);
    	}		
    	return eventResponse;
     }
    
 
	/**
	 * 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSIORListExcelDown(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdSce0056Event event = (EsdSce0056Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {			
			VesselReportBC command = new VesselReportBCImpl();

			eventResponse.setCustomData("rowset", command.searchUSIORInquiry(event.getSearchUSIORInfo(), account.getOfc_cd()));
			eventResponse.setCustomData("title", command.getTitle());
			eventResponse.setCustomData("columns", command.getColumns());
			eventResponse.setCustomData("fileName", "SCE_0205_EXCEL.xls");
			eventResponse.setCustomData("isZip", true);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
     * Multi Input<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchMultiInput(Event e) throws EventException {
    	log.info("\n searchMultiInput start!! ");
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0048Event event         = (EsdSce0048Event)e ;
        RailTransitReportBC command = new RailTransitReportBCImpl();
        
        String type = event.getSearchRTRInfo().getType();
        log.info("type===" + type);
        try {
        	if (type.equals("0")) {
        		List<SearchMultiInputCntrVO> list = command.searchMultiInput(event.getCntrVos());        	
        		eventResponse.setRsVoList(list);
        	} else if (type.equals("1")) {
        		List<SearchMultiInputBKGNoVO> list = command.searchMultiInputBkgNo(event.getBkgVos());        	
        		eventResponse.setRsVoList(list);
        	} else if (type.equals("2")) {
        		List<SearchMultiInputBLNoVO> list = command.searchMultiInputBlNo(event.getBlNoVos());        	
        		eventResponse.setRsVoList(list);
        	} else if (type.equals("3")) {
        		List<SearchMultiInputVVDVO> list = command.searchMultiInputVvd(event.getVvdVos());        	
        		eventResponse.setRsVoList(list);
        	}
        } catch (EventException de) {
        	
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
//    /**
//     * Customer Service S/O<br>
//     * 
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//    private EventResponse searchCustomerServiceInfoList(Event e) throws EventException {
//        EventResponse    eventResponse = null;
//        EsdSce0058Event event         = (EsdSce0058Event)e ;
//        log.info("\n yoon. searchCustomerServiceInfoList - sc");
//        try {
//        	CustomerServiceBC command = new CustomerServiceBCImpl();
//            eventResponse = command.searchCustomerServiceInfoList(event);
//            
//        } catch (EventException de) {
//        	
//            log.error("err " + de.toString(), de);
//            throw new EventException(de.getMessage());
//        }
//        return eventResponse;
//    }           
    
    /**
     * US Cagro Tracking<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchUSCargoTrackingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	log.info("SC 호출 완료");
        EventResponse eventResponse = null;
        EsdSce0038Event event = (EsdSce0038Event)e;
        try {
        	CargoTrackingBC command = new CargoTrackingBCImpl();
            eventResponse = command.searchUSCargoTrackingList(event.getCtopt());
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
     * Customer Name 조회<br>
     * @param e 
     * 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCustomerName(Event e) throws EventException {
    	log.info("VisibilityManageSC is invoked.");
        EventResponse    eventResponse = null;
        EsdSce0038Event event         = (EsdSce0038Event)e ;
        
        try {
        	CargoTrackingBC command = new CargoTrackingBCImpl();
            eventResponse = command.searchCustomerName(event.getCtopt());
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EsdSce0057 : [이벤트]
	 * 기본 default report setup 정보를 조회한다 (master table: SCE_USA_INLND_OP_RPT_COL)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustmRptForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CustomizedReportSetupBC command = new CustomizedReportSetupBCImpl(); 
		try{
			
			begin();
			// 로그인 유저 Setup 정보 조회
			DBRowSet rs = 
				command.searchRptForm(account.getUsr_id(),	// 사번
									  account.getOfc_cd());	// 소속 office
			
			commit();	

			eventResponse.setRs(rs);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdSce0057 : [이벤트]
	 * user별로 등록되어 저장된 report 정보를 조회한다 (customized table: SCE_USA_INLND_OP_RPT_FOM)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustmRptForm2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CustomizedReportSetupBC command = new CustomizedReportSetupBCImpl(); 
		try{
			
			begin();
						// 로그인 유저 Setup 정보 조회
			DBRowSet rs = 
				command.searchCustmRptForm(account.getUsr_id(),	// 사번
										   account.getOfc_cd());	// 소속 office									   			
			commit();	

			eventResponse.setRs(rs);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * user가 customizing하여 선택한 항목에 대한 report setup 정보를 등록/삭제 한다.
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse modifyCustmRptForm(Event e) throws EventException { // 저장할 때
		EsdSce0056Event event = (EsdSce0056Event)e;
		CustomizedReportSetupBC command = new CustomizedReportSetupBCImpl();
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			
			String usrId = account.getUsr_id();	// 사번
			String usrOfcCd = account.getOfc_cd();	// 소속 office
			String[] coldesc2 = event.getColdesc2();
			String[] chk2 = event.getChk2();
			
			// customize Report Form Setup
			begin();
			
			// 로그인 유저의 Setup 정보 존재 여부 확인
			DBRowSet rs = 
				command.searchCustmRptForm(usrId, usrOfcCd);

				if ( rs.getRowCount() > 0 ) {
					command.deleteCustmRptForm(usrId, usrOfcCd);
				}
							
				command.insertCustmRptForm(usrId, usrOfcCd, coldesc2, chk2);	// add
				
			commit();
			
		} catch (EventException ee) {
			rollback();
			throw new EventException(ee.getMessage());
		}
		return eventResponse;
		
	}
	
	
    /**
	 * 멀티 이벤트 처리<br>
	 * RTR의 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
 	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRTRReport(Event e) throws EventException {
		log.info("modifyRTRReport is invoked.");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			RailTransitReportBC command = new RailTransitReportBCImpl();
			command.modifyRTRReport( ((EsdSce0045Event)e).getSearchRTRLists() );
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}	
		return eventResponse;
	}
	
    /**
	 * 멀티 이벤트 처리<br>
	 * RTR의 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
 	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRTRReportRemark(Event e) throws EventException {
		log.info("modifyRTRReport is invoked.");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			RailTransitReportBC command = new RailTransitReportBCImpl();
			command.modifyRTRReportRemark( ((EsdSce0045Event)e).getSearchRTRLists() );
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}	
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * EDI 324 발송을 위한  등록/수정<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse sendEdi324Process(Event e) throws EventException {
		EsdSce0056Event event = (EsdSce0056Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Edi324SendBC command = new Edi324SendBCImpl();
		
		try {
			
			begin();
			//EDI 324을 발송을 위해서 Edi324BC 의 메소드를 호출
		//	sendEdi324(event.getSearchEdi324SendVOs());
			command.edi324SendGetTarget(event.getSearchEdi324SendVOs() ,account.getUsr_id());
			commit();
			
		} catch (EventException ee) {
			rollback();
			throw new EventException(ee.getMessage());
		}
		return eventResponse;
	}
	
//	/**
//	 * Edi 324 Document Send
//	 * 화면에서 가져온 데이터의 빠진 정보를 보정을 하기 위한 메소드 호출
//	 * @param List<SearchEdi324SendVO> searchEdi324SendVOs
//	 * @return EventResponse
//	 * @throws EventException
//	 */
//	public EventResponse sendEdi324(List<SearchEdi324SendVO> searchEdi324SendVOs)
//			throws EventException {
//		log.info("In sendEdi324");
//		Edi324SendBC command = new Edi324SendBCImpl();
////		EventResponse eventResponse = null;
//    	GeneralEventResponse eventResponse = new GeneralEventResponse();
//		
//		try {
//			if (searchEdi324SendVOs != null && searchEdi324SendVOs.size() > 0) {
//					command.edi324SendGetTarget(searchEdi324SendVOs);
//			}// if
//
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * vendor code를 가져온다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchVender(Event e) throws EventException {
		
		CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
		EsdSce0056Event event         = (EsdSce0056Event)e ;
		EventResponse eventResponse = null;
	  	EsdTrs0075Event event01 = new EsdTrs0075Event();
    	event01.setVndrCd(event.getSearchUSIORInfo().getVndrSeq());
        event01.setFormCommand(event.getFormCommand());
    	
    	try {
    		eventResponse = command.search_vndr(event01);
    		
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	/**
	 * 조회조건(combo)을 위한 West Cost, East Cost의 POD code를 가져온다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCostPod(Event e) throws EventException {
		
		VesselReportBC command = new VesselReportBCImpl();
		EsdSce0056Event event  = (EsdSce0056Event)e ;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
    	
    	try {
    		List<SearchUSIORListVO> list = command.searchCostPod(event.getCostDiv());
    		eventResponse.setRsVoList(list); 
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회조건(combo)을 위한 Equipment Office code를 가져온다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEqmtOfcCd(Event e) throws EventException {
		
		VesselReportBC command = new VesselReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
    	
    	try {
    		List<SearchUSIORListVO> list = command.searchEqmtOfcCd();
    		eventResponse.setRsVoList(list); 
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
//	GeneralEventResponse eventResponse = new GeneralEventResponse();
//	EsmBkg0746Event event = (EsmBkg0746Event)e;
//	PerformanceReportBC command = new PerformanceReportBCImpl();
//
//	List<VesselUtilizationStatusReportInVO> list = command.searchVesselUtilizationSubTrade(event.getVesselUtilizationStatusReportInVO()); 
//
//	eventResponse.setRsVoList(list);
//	
//	return eventResponse;
}
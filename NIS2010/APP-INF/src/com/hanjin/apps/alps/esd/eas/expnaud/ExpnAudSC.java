/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TrsauditSC.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2014.10.29 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.audperf.basic.AudPerfBC;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.basic.AudPerfBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchLgsCostCdVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfCostDtlListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfOfcListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.audperf.vo.SearchPerfSpDtlListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.basic.AutoAuditRptBC;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.basic.AutoAuditRptBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.event.EsdEas0227Event;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.event.EsdEas0228Event;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditChangeHistoryVO;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditStatisticsVO;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.basic.MnrAudBC;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.basic.MnrAudBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.event.EsdEas0309Event;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.event.EsdEas0323Event;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByBkgVO;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByHistoryVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.basic.TesAudBC;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.basic.TesAudBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.event.EsdEas0311Event;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.event.EsdEas0312Event;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.event.EsdEas0320Event;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.event.EsdEas0321Event;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.CostCodeListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCoincidenceVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.StorageCostCalculationVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailCostCalculationVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesOnDockRailVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesaud.vo.TesRowDataVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.basic.TesBkgAudBC;
import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.basic.TesBkgAudBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.event.EsdEas0316Event;
import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.vo.RehandlingBkgCodVO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.basic.TesMvmtAudBC;
import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.basic.TesMvmtAudBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.tesmvmtaud.vo.SearchMvmtLegListVO;
import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.basic.TesTorAudBC;
import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.basic.TesTorAudBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.event.EsdEas0310Event;
import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.vo.RehandlingExpenseTorVsTpbVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.basic.TrsAudBC;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.basic.TrsAudBCImpl;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event.EsdEas0304Event;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event.EsdEas0305Event;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event.EsdEas0306Event;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event.EsdEas0307Event;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event.EsdEas0308Event;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.CodeVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.DropOffChargeInquiryVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.SpecialSoOfTrsVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.SurchargeReportVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.TrffCmprsnByTRSAgrmntVO;
import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.UnmatchRouteBkgVsSoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * TransportmanageSC PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @see ServiceCommandSupport 참조
 * @since J2EE 1.4
 */
public class ExpnAudSC extends ServiceCommandSupport {

	
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * EAS 업무 시나리오 선행작업<br>
     * ExpnAud업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("ExpnAud 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * EAS 업무 시나리오 마감작업<br>
     * ExpnAud업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("ExpnAud 종료");
    }

	/**
	 * 조회 이벤트 처리<br>
	 * Transportmanage event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

        EventResponse eventResponse = null;
       
        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
	    if (e.getEventName().equalsIgnoreCase("EsdEas0315Event")) { //Reefer Monitoring 
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	            eventResponse = searchMvmtLegList(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsdEas0317Event")) { // Logistics Expense Result
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	            eventResponse = searchPerfOfcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchLgsCostCd(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsdEas0318Event")) { // Logistics Expense Result - S/P Detail
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	            eventResponse = searchPerfSpDtlList(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsdEas0319Event")) { // Logistics Expense Result - Cost Detail
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	            eventResponse = searchPerfCostDtlList(e);
			}
	    }else if (e.getEventName().equalsIgnoreCase("EsdEas0304Event")) { // Special S/O
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpecialSoOfTrs(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0305Event")) { // Surcharge(TPB/BKG)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSurchargeReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		// Surcharge Code 조회  for CobmboBox
				eventResponse = searchScgCd(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsdEas0306Event")) { // Carriers Haulage(MSC Checking)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInlandCostList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdEas0307Event")) { // Un-match Route(BKG vs S/O)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUmchList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0308Event")) { // Drop Off Charge
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDodList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		// Container Type Size Code
				eventResponse = searchCntrTpSz(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		// Customer Code
				eventResponse = searchCustCd(e);
			} 	
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0309Event")) { // H/Bar Inquiry by BKG
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBkgHngrList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		// Container Type Size Code
				eventResponse = searchCntrTpSz(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0310Event")) { // Rehandling(TOR vs. TPB)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRhndList(e);
			} 			
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0311Event")) { // MR Invoice
	    	//Port (Service) Charge
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	            eventResponse = searchTesRowDataList(e);
			}
	    }else if (e.getEventName().equalsIgnoreCase("EsdEas0312Event")) { // On Dock Rail Invoice - Coincidence
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	            eventResponse = searchOnDockRailDataList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsdEas0316Event")) { // Rehandling(BKG COD)
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCodCostList(e);
			}
	    }else if (e.getEventName().equalsIgnoreCase("EsdEas0320Event")) { // On Dock Rail Invoice - Cost Calculation
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	            eventResponse = searchOnDockRailCostCalculationList(e);
			}
	    }else if (e.getEventName().equalsIgnoreCase("EsdEas0321Event")) { // Storage Calculation
	        if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	            eventResponse = searchStorageCostCalculationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
	            eventResponse = searchCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
	            eventResponse = searchStorageCoincidenceList(e);
			}
	    }else if (e.getEventName().equalsIgnoreCase("EsdEas0323Event")) {
	    	//Port (Service) Charge
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchHngrHisList(e);
			}
	    }else if (e.getEventName().equalsIgnoreCase("EsdEas0227Event")) { // Auto Audit Chagne History
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutoAuditChangeHistory(e);
			}
	    }else if (e.getEventName().equalsIgnoreCase("EsdEas0228Event")) { //  Auto Audit Statistics 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutoAuditStatistics(e);
			}
	    }
		return eventResponse;
	}
    
    /**
	 * EDS_EAS_0315 : OPEN
	 * Contianer Movement - Reefer 조회.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchMvmtLegList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	TesMvmtAudBC command = new TesMvmtAudBCImpl();
        	List<SearchMvmtLegListVO> list = command.searchMvmtLegList(e);
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EDS_EAS_0317 : OPEN
	 * Performance For Logistics Expense 조회.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPerfOfcList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	AudPerfBC command = new AudPerfBCImpl();
        	List<SearchPerfOfcListVO> list = command.searchPerfOfcList(e);
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EDS_EAS_0317 : OPEN
	 * Performance For Logistics Expense - Cost Code 조회.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchLgsCostCd(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	AudPerfBC command = new AudPerfBCImpl();
        	List<SearchLgsCostCdVO> list = command.searchLgsCostCd(e);
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EDS_EAS_0318 : OPEN
	 * Performance For Logistics Expense - S/P Detail 議고쉶.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPerfSpDtlList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	AudPerfBC command = new AudPerfBCImpl();
        	List<SearchPerfSpDtlListVO> list = command.searchPerfSpDtlList(e);
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EDS_EAS_0319 : OPEN
	 * Performance For Logistics Expense - Cost Detail 議고쉶.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPerfCostDtlList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	AudPerfBC command = new AudPerfBCImpl();
        	List<SearchPerfCostDtlListVO> list = command.searchPerfCostDtlList(e);
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EsdEas0304  <br>
	 * Rejection Notice Send History 내역 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSpecialSoOfTrs(Event e) throws EventException {
		try{
			EsdEas0304Event event = (EsdEas0304Event)e;
			TrsAudBC command = new TrsAudBCImpl();
			List<SpecialSoOfTrsVO> list = command.searchSpecialSoOfTrs(event.getSpecialSoOfTrsVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSpecialSoOfTrs"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0305  <br>
	 * Surcharge Report 조회 <br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSurchargeReport(Event e) throws EventException {
		try{
			EsdEas0305Event event = (EsdEas0305Event)e;
			TrsAudBC command = new TrsAudBCImpl();
			List<SurchargeReportVO> list = command.searchSurchargeReport(event.getSurchargeReportVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchSurchargeReport"}).getMessage(), ex);
		}
	}

	/**
	 * EsdEas0305  <br>
	 * Surcharge Item Code 조회 <br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchScgCd(Event e) throws EventException {
		try{
			TrsAudBC command = new TrsAudBCImpl();
			List<CodeVO> list = command.searchScgCd();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchScgCd"}).getMessage(), ex);
		}
	}

	/**
	 * EsdEas0306  <br>
	 * Tariff Comparison by TRS Agreement 조회 <br>
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchInlandCostList(Event e) throws EventException {
		try{
			EsdEas0306Event event = (EsdEas0306Event)e;
			TrsAudBC command = new TrsAudBCImpl();
			List<TrffCmprsnByTRSAgrmntVO> list = command.searchInlandCostList(event.getTrffCmprsnByTRSAgrmntVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchInlandCostList"}).getMessage(), ex);
		}
	}

	/**
	 * EsdEas0307  <br>
	 * Tariff Comparison by TRS Agreement 議고쉶 <br>
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchUmchList(Event e) throws EventException {
		try{
			EsdEas0307Event event = (EsdEas0307Event)e;
			TrsAudBC command = new TrsAudBCImpl();
			List<UnmatchRouteBkgVsSoVO> list = command.searchUmchList(event.getUnmatchRouteBkgVsSoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchUmchList"}).getMessage(), ex);
		}
	}
	
	
	/**
	 * EsdEas0308  <br>
	 * Container Type Size Code <br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCntrTpSz(Event e) throws EventException {
		try{
			TrsAudBC command = new TrsAudBCImpl();
			List<CodeVO> list = command.searchCntrTpSz();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCntrTpSz"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0308  <br>
	 * Customer Code <br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCustCd(Event e) throws EventException {
		try{
			EsdEas0308Event event = (EsdEas0308Event)e;
			TrsAudBC command = new TrsAudBCImpl();
			List<CodeVO> list = command.searchCustCd(event.getDropOffChargeInquiryVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCustCd"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0308  <br>
	 * Drop-Off Charge Inquiry 조회 <br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchDodList(Event e) throws EventException {
		try{
			EsdEas0308Event event = (EsdEas0308Event)e;
			TrsAudBC command = new TrsAudBCImpl();
			List<DropOffChargeInquiryVO> list = command.searchDodList(event.getDropOffChargeInquiryVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchDodList"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0309  <br>
	 * H/Bar Inquiry by BKG 議고쉶 <br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBkgHngrList(Event e) throws EventException {
		try{
			EsdEas0309Event event = (EsdEas0309Event)e;
			MnrAudBC command = new MnrAudBCImpl();
			List<HbarInquiryByBkgVO> list = command.searchBkgHngrList(event.getHbarInquiryByBkgVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchBkgHngrList"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0323  <br>
	 * HBar Inquiry by History <br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchHngrHisList(Event e) throws EventException {
		try{
			EsdEas0323Event event = (EsdEas0323Event)e;
			MnrAudBC command = new MnrAudBCImpl();
			List<HbarInquiryByHistoryVO> list = command.searchHngrHisList(event.getHbarInquiryByHistoryVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchHngrHisList"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0310  <br>
	 * Rehandling Expense - TOR vs. TPB 조회한다.<br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchRhndList(Event e) throws EventException {
		try{
			EsdEas0310Event event = (EsdEas0310Event)e;
			TesTorAudBC command = new TesTorAudBCImpl();
			List<RehandlingExpenseTorVsTpbVO> list = command.searchRhndList(event.getRehandlingExpenseTorVsTpbVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchRhndList"}).getMessage(), ex);
		}
	}

	/**
	 * EsdEas0316  <br>
	 * Rehandling(BKG COD) 조회한다.<br>
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCodCostList(Event e) throws EventException {
		try{
			EsdEas0316Event event = (EsdEas0316Event)e;
			TesBkgAudBC command = new TesBkgAudBCImpl();
			List<RehandlingBkgCodVO> list = command.searchCodCostList(event.getRehandlingBkgCodVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchCodCostList"}).getMessage(), ex);
		}
	}
	
    /**
	 * EDS_EAS_0311 : OPEN
	 * MR invoice Report 조회.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchTesRowDataList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0311Event event = (EsdEas0311Event)e;
        TesAudBC command = new TesAudBCImpl();
        try {
        	
        	List<TesRowDataVO> list = command.searchTesRowDataList(event.getTesRowDataVO());
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
	
    /**
	 * EDS_EAS_0312 : OPEN
	 * On Dock Rail Data Inquiry - Coincidence
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOnDockRailDataList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0312Event event = (EsdEas0312Event)e;
        TesAudBC command = new TesAudBCImpl();
        try {
        	
        	List<TesOnDockRailVO> list = command.searchOnDockRailDataList(event.getTesOnDockRailVO());
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EDS_EAS_0320 : OPEN
	 * MR invoice Report 조회.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOnDockRailCostCalculationList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0320Event event = (EsdEas0320Event)e;
        TesAudBC command = new TesAudBCImpl();
        try {
        	
        	List<TesOnDockRailCostCalculationVO> list = command.searchOnDockRailCostCalculationList(event.getTesOnDockRailCostCalculationVO());
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EDS_EAS_0321,EDS_EAS_0322 : OPEN
	 * Storage MR 과 Off-Dock의 Cost Calculaton(FD OR FP) List 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchStorageCostCalculationList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0321Event event = (EsdEas0321Event)e;
        TesAudBC command = new TesAudBCImpl();
        try {
        	
        	List<StorageCostCalculationVO> list = command.searchStorageCostCalculationList(event.getStorageCostCalculationVO());
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EDS_EAS_0321,EDS_EAS_0322 : OPEN
	 * CostCodeList search
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCostCodeList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0321Event event = (EsdEas0321Event)e;
        TesAudBC command = new TesAudBCImpl();
        try {
        	List<CostCodeListVO> list = command.searchCostCodeList(event.getCostCodeListVO());
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
    /**
	 * EDS_EAS_0313 : OPEN
	 * Storage MR 과 Off-Dock의 Coincidence List 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchStorageCoincidenceList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdEas0321Event event = (EsdEas0321Event)e;
        TesAudBC command = new TesAudBCImpl();
        try {
        	
        	List<StorageCoincidenceVO> list = command.searchStorageCoincidenceList(event.getStorageCoincidenceVO());
			eventResponse.setRsVoList(list);
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
	/**
	 * EsdEas0227 <br>
	 * Auto Audit Chagne History 내역 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAutoAuditChangeHistory(Event e) throws EventException {
		try{
			EsdEas0227Event event = (EsdEas0227Event)e;
			AutoAuditRptBC command = new AutoAuditRptBCImpl();
			List<SearchAutoAuditChangeHistoryVO> list = command.searchAutoAuditChangeHistory(event.getSearchAutoAuditChangeHistoryVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchAutoAuditChangeHistory"}).getMessage(), ex);
		}
	}
	
	/**
	 * EsdEas0228 <br>
	 * Auto Audit Statistics 조회 <br>
	 * 
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAutoAuditStatistics(Event e) throws EventException {
		try{
			EsdEas0228Event event = (EsdEas0228Event)e;
			AutoAuditRptBC command = new AutoAuditRptBCImpl();
			List<SearchAutoAuditStatisticsVO> list = command.searchAutoAuditStatistics(event.getSearchAutoAuditStatisticsVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("error:"+ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12203", new String[]{"searchAutoAuditStatistics"}).getMessage(), ex);
		}
	}
}
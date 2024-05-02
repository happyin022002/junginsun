/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReportManageSC.java
*@FileTitle : Disposal PFMC by Region
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.09.28 민정호
* 1.0 Creation
* =======================================================
* 2010.11.30 남궁진호 [CHM-201007327-01] Disposal Performance를 장비별 Detail 내역 조회 추가
*            searchDisposalPFMCByEqDetailListService
* 2010.12.06 남궁진호 [CHM-201007441-01]Disposal Result Equipment list 팝업 신규개발 
* 2011.03.02 김영오 [CHM-201108369] M&R PFMC by Eq No  신규화면 개발에 따른 매소드 추가 
* 			 searchPFMCByEqNoListService, searchComBackEndJobEqNoListStatusService, loadFileBackEndJobEqNoListResultService
* 2013.05.30 조경완 [CHM-201324809-01] [MNR-자체개선] M&R > Guideline & PFMC > General Performance > PFMC by Estimate 수행시 ALPS OLTP Rule에 따라 Timeout SQL 발생 방지를 위한 BackEndJob 으로의 기능 전환
* 2015.01.19 Chang Young Kim 품질결함으로 인한 소스명변경을 이유로 소스 수정(EesMnr0119_01Event.java -> EesMnr011901Event.java)
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0102Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0115Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0118Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0119Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr011901Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0120Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0121Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0165Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0166Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0202Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0203Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0204Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0205Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0230Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0236Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0237Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0238Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0244Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0245Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0246Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0247Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0248Event;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.integration.PerformanceReportDBDAO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.ACEPListGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByBuyerVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEQGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEQListVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEqDetailVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByMonthVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByOfficeVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRCCVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.DisposalResultEquipmentVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffGRPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairExpensePFMCRPTVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByEqNoVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.SearchFoodQualityDetailKeyVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TireReplacementHistoryVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceVO;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ReportManage Business Logic ServiceCommand - ALPS-ReportManage 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Jung Ho Min
 * @see PerformanceReportDBDAO
 * @since J2EE 1.6
 */

public class ReportManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ReportManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ReportManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ReportManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ReportManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ReportManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesMnr0165EventOLD")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByRegionListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0166EventOLD")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByEQListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0204Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTireReplacementListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0205Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTireReplacementHistoryListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0202Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTirePurchaseByItemListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0203Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTirePurchaseBySupplierListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossPerformanceListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchBackEndExpensePFMCListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = searchComBackEndJobStatusService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
				eventResponse = loadFileBackEndJobResultService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchBackEndRepairPFMCByESTListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = searchComBackEndJobStatusService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
				eventResponse = loadFilePFMCbyEstimateBackEndJobResultService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0119Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairPFMCByRepairCodeListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0118Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairPFMCByTSListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairPFMCBySPListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0230Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchACEPListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0238Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairPFMCByWOListService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0236Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPMFCByAgreementTariffService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0237Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairPFMCByACCTListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0244Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByRCCListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0245Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByMonthListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0165Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByOfficeListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0246Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByBuyerListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0166Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByEqDetailListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0247Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalResultEquipmentListService(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0248Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchPFMCByEqNoListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = searchComBackEndJobEqNoListStatusService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
				eventResponse = loadFileBackEndJobEqNoListResultService(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EesMnr011901Event")) {
			//log.debug("EesMnr011901Event 시작");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFoodQualityDetailKeyListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = searchFoodQualityDetailMultiListService(e);
			}
			//log.debug("EesMnr0119_01Event 종료");
		}

		return eventResponse;
	}

	/**
	 * EES_MNR_0165 : Retrieve<br>
	 * Region에 의한 Disposal PFMC를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @deprecated 2010.10.18 현재 [CSR] CHM-201005770-01 Disposal Tariff by Region 기능변경 요청건에 의해 설계문서 현행화시 삭제요망.
	 * @see com.hanjin.apps.alps.ees.mnr.reportmanage.ReportManageSC#searchDisposalPFMCByOfficeListService(Event e)
	 */
	private EventResponse searchDisposalPFMCByRegionListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0165Event event = (EesMnr0165Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<DisposalPFMCByEQGRPVO> list = command.searchDisposalPFMCByRegionListBasic(event.getDisposalPFMCByRegionGRPVO());
			eventResponse.setETCData("TITLE", list.get(0).getTitle());
			list.remove(0);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0166 : Retrieve<br>
	 * EQ에 의한 Disposal PFMC를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @deprecated 2010.11.08 현재 [CSR] 예정 Disposal Performance by Equipment 기능변경 요청건에 의해 설계문서 현행화시 삭제요망.
	 * @see com.hanjin.apps.alps.ees.mnr.reportmanage.ReportManageSC#searchDisposalPFMCByEqDetailListService(Event e)
	 */
	private EventResponse searchDisposalPFMCByEQListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0166Event event = (EesMnr0166Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<DisposalPFMCByEQListVO> list = command.searchDisposalPFMCByEQListBasic(event.getDisposalPFMCByEQVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0204 : Retrieve<br>
	 * Tire Replacement Report를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTireReplacementListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0204Event event = (EesMnr0204Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<TireReplacementHistoryVO> list = command.searchTireReplacementListBasic(event.getTireReplacementINVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0205 : Retrieve<br>
	 * Tire Replacement History Report를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTireReplacementHistoryListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0205Event event = (EesMnr0205Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<TireReplacementHistoryVO> list = command.searchTireReplacementHistoryListBasic(event.getTireReplacementINVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0202 : Retrieve<br>
	 * Tire Purchase Report by Item를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTirePurchaseByItemListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0202Event event = (EesMnr0202Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<TirePurcharseByItemVO> list = command.searchTirePurchaseByItemListBasic(event.getTirePurcharseByItemINVO(), account);
			eventResponse.setETCData("TITLE", list.get(0).getTitle());
			list.remove(0);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0203 : Retrieve<br>
	 * Tire Purchase Report by Supplier를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTirePurchaseBySupplierListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0203Event event = (EesMnr0203Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<TirePurcharseBySupplierVO> list = command.searchTirePurchaseBySupplierListBasic(event.getTirePurcharseBySupplierINVO(), account);
			eventResponse.setETCData("TITLE", list.get(0).getTitle());
			list.remove(0);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0105 : Retrieve<br>
	 * Total Loss Payment to Lessor Report를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossPerformanceListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0102Event event = (EesMnr0102Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<TotalLossPerformanceVO> list = command.searchTotalLossPerformanceListBasic(event.getTotalLossPerformanceINVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0238 : Retrieve<br>
	 * Work Order에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairPFMCByWOListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0238Event event = (EesMnr0238Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<RepairPFMCByWOVO> list = command.searchRepairPFMCByWOListBasic(event.getRepairPFMCByWOINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0119 : Retrieve<br>
	 * AGMT TRIFF에 의한MNR PFMC를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairPFMCByRepairCodeListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0119Event event = (EesMnr0119Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<RepairPFMCByRepairCodeVO> list = command.searchRepairPFMCByRepairCodeListBasic(event.getRepairPFMCByRepairCodeINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0119_01 : Retrieve<br>
	 * PFMC by CEDEX Code에 의한 Damge FQ에 대한 장비 Key목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFoodQualityDetailKeyListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr011901Event event = (EesMnr011901Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			List<SearchFoodQualityDetailKeyVO> list = command.searchFoodQualityDetailKey(event.getSearchFoodQualityDetailKeyVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * EES_MNR_0119_01 : Retrieve<br>
	 * PFMC by CEDEX Code에 의한 Damge FQ에 대한 장비 Key목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFoodQualityDetailMultiListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr011901Event event = (EesMnr011901Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			List<SearchFoodQualityDetailKeyVO> list = command.searchFoodQualityDetailMulti(event.getSearchFoodQualityDetailMultiVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * EES_MNR_0118 : Retrieve<br>
	 * Type/Size에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairPFMCByTSListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0118Event event = (EesMnr0118Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<RepairPFMCByTSVO> list = command.searchRepairPFMCByTSListBasic(event.getRepairPFMCByTSINVO());
			eventResponse.setETCData("TITLE", list.get(0).getTitle());
			list.remove(0);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0120 : Retrieve<br>
	 * VNDR/Manufacturer에 의한 MNR PFMC를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairPFMCBySPListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0120Event event = (EesMnr0120Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<RepairPFMCBySPVO> list = command.searchRepairPFMCBySPListBasic(event.getRepairPFMCBySPINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0230 : Retrieve<br>
	 * ACEP Candidate Cntr List를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchACEPListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0230Event event = (EesMnr0230Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		ACEPListGRPVO aCEPListGRPVO = event.getACEPListGRPVO();
		try{
			aCEPListGRPVO = command.searchACEPListBasic(aCEPListGRPVO);
			eventResponse.setRsVoList(aCEPListGRPVO.getListACEPListVO());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0236 : Retrieve<br>
	 * MNR PFMC by Agreement/Tariff List를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPMFCByAgreementTariffService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0236Event event = (EesMnr0236Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		PMFCByAgreementTariffGRPVO pMFCByAgreementTariffGRPVO = event.getPMFCByAgreementTariffGRPVO();
		try{
			pMFCByAgreementTariffGRPVO = command.searchPMFCByAgreementTariffBasic(pMFCByAgreementTariffGRPVO);

			eventResponse.setRsVoList(pMFCByAgreementTariffGRPVO.getListPMFCByAgreementTariffListVOs());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0237 : Retrieve<br>
	 * PFMC by Account/Cost Code List를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairPFMCByACCTListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0237Event event = (EesMnr0237Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<RepairPFMCByACCTVO> list = command.searchRepairPFMCByACCTListBasic(event.getRepairPFMCByACCTINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0244 : Retrieve <br>
	 * [EES_MNR_0244] RCC/LCC/SCC 지역별 매각실적 현황목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalPFMCByRCCListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0244Event event = (EesMnr0244Event)e;
			PerformanceReportBC command = new PerformanceReportBCImpl();
			List<DisposalPFMCByRCCVO> list = command.searchDisposalPFMCByRCCListBasic(event.getDisposalPFMCByRCCVO());

			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0245 : Retrieve <br>
	 * [EES_MNR_0245] 월별 매각실적 현황목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalPFMCByMonthListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0245Event event = (EesMnr0245Event)e;
			PerformanceReportBC command = new PerformanceReportBCImpl();
			List<DisposalPFMCByMonthVO> list = command.searchDisposalPFMCByMonthListBasic(event.getDisposalPFMCByMonthVO());

			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0165 : Retrieve<br>
	 * [EES_MNR_0165] Office별 계획대비 매각실적 현황목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalPFMCByOfficeListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0165Event event = (EesMnr0165Event)e;
			PerformanceReportBC command = new PerformanceReportBCImpl();
			List<DisposalPFMCByOfficeVO> list = command.searchDisposalPFMCByOfficeListBasic(event.getDisposalPFMCByOfficeVO());

			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0246 : Retrieve<br>
	 * [EES_MNR_0246] Buyer별 매각실적 현황목록을 조회합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalPFMCByBuyerListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0246Event event = (EesMnr0246Event)e;
			PerformanceReportBC command = new PerformanceReportBCImpl();
			List<DisposalPFMCByBuyerVO> list = command.searchDisposalPFMCByBuyerListBasic(event.getDisposalPFMCByBuyerVO());

			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0166 : Retrieve<br>
	 * [EES_MNR_0166] 장비별 매각실적 상세정보를 조회합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalPFMCByEqDetailListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0166Event event = (EesMnr0166Event)e;
			PerformanceReportBC command = new PerformanceReportBCImpl();
			List<DisposalPFMCByEqDetailVO> list = command.searchDisposalPFMCByEqDetailListBasic(event.getDisposalPFMCByEqDetailVO());

			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0247 : Retrieve<br>
	 * [EES_MNR_0247] 장비별 매각실적 상세결과 정보를 조회합니다.(Popup) <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalResultEquipmentListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0247Event event = (EesMnr0247Event)e;
			PerformanceReportBC command = new PerformanceReportBCImpl();
			List<DisposalResultEquipmentVO> list = command.searchDisposalResultEquipmentListBasic(event.getDisposalResultEquipmentVO());

			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0115 : Retrieve-BackEndJob <br>
	 * Expense Plan and PFMC를 조회합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchBackEndExpensePFMCListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0115Event event = (EesMnr0115Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			String status = command.searchBackEndExpensePFMCListBasic(event.getRepairExpensePFMCINVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);

		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001",new String[]{"[M&R Expense Plan/PFMC Inquiry] searchBackEndExpensePFMCListService"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0115 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = "";
		if(e.getEventName().equalsIgnoreCase("EesMnr0115Event")){
			EesMnr0115Event event = (EesMnr0115Event)e;
			key = event.getRepairExpensePFMCINVO().getBackendjobKey();
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0121Event")){
			EesMnr0121Event event = (EesMnr0121Event)e;
			key = event.getRepairPFMCByESTINVO().getBackendjobKey();
		}
		try {
			PerformanceReportBC command = new PerformanceReportBCImpl();

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001",new String[]{"[M&R Expense Plan/PFMC Inquiry] searchComBackEndJobStatusService"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0115 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0115Event event = (EesMnr0115Event)e;
		String key = event.getRepairExpensePFMCINVO().getBackendjobKey();
		List list = null;

		try {
			//if(e.getEventName().equalsIgnoreCase("EesMnr0115Event")) {
				list = (List<RepairExpensePFMCRPTVO>)BackEndJobResult.loadFromFile(key);
			//}
			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**     
	 * EES_MNR_0248 : Retrieve<br>
	 * [EES_MNR_0248] M&R PFMC by PFMC by EQ No에 의한 PFMC by EQ No를 조회합니다.<br>
	 *               
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
	private EventResponse searchPFMCByEqNoListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0248Event event = (EesMnr0248Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			String status = command.searchPFMCByEqNoListBasic(event.getRepairPFMCByEqNoINVO(), account);
			eventResponse.setETCData("BackEndJobkey", status);
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001",new String[]{"[M&R Expense Plan/PFMC Inquiry] searchBackEndExpensePFMCListService"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0248 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobEqNoListStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0248Event event = (EesMnr0248Event)e;
		String key = event.getRepairPFMCByEqNoINVO().getBackendjobKey();

		try {
			PerformanceReportBC command = new PerformanceReportBCImpl();

			String status = command.searchComBackEndJobEqNoListStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001",new String[]{"[M&R Expense Plan/PFMC Inquiry] searchComBackEndJobStatusService"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0248 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobEqNoListResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0248Event event = (EesMnr0248Event)e;
		String key = event.getRepairPFMCByEqNoINVO().getBackendjobKey();
		List list = null;

		try {
				list = (List<RepairPFMCByEqNoVO>)BackEndJobResult.loadFromFile(key);
			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_MNR_0121 : Retrieve-BackEndJob <br>
	 * Estimation Creation에 의한 MNR PFMC를 조회합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchBackEndRepairPFMCByESTListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0121Event event = (EesMnr0121Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			String status = command.searchRepairPFMCByESTListBasic(event.getRepairPFMCByESTINVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);

		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001",new String[]{"PFMC by Estimate - searchBackEndRepairPFMCByESTListService"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0121 : BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFilePFMCbyEstimateBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0121Event event = (EesMnr0121Event)e;
		String key = event.getRepairPFMCByESTINVO().getBackendjobKey();
		List list = null;

		try {
			list = (List<RepairPFMCByESTVO>)BackEndJobResult.loadFromFile(key);

			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

}
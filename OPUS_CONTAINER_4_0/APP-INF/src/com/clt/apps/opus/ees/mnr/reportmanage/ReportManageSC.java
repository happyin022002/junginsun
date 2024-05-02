/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReportManageSC.java
*@FileTitle : Disposal PFMC by Region
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage;

import java.util.List;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.basic.PerformanceReportBC;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0102Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0118Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0119Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0120Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0121Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0166Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0202Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0203Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0204Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0205Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0230Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0236Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0237Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0238Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0244Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0245Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0246Event;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.integration.PerformanceReportDBDAO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.ACEPListGRPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByBuyerVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByEqDetailVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByMonthVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.DisposalPFMCByRCCVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.PMFCByAgreementTariffGRPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseByItemVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TirePurcharseBySupplierVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TireReplacementHistoryVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.TotalLossPerformanceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * COM-ReportManage Business Logic ServiceCommand - COM-ReportManage handling business transaction
 *
 * @author 
 * @see PerformanceReportDBDAO
 * @since J2EE 1.6
 */

public class ReportManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ReportManage system preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("ReportManageSC Start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ReportManage system biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ReportManageSC End");
	}

	/**
	 * COM-ReportManage system <br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if(e.getEventName().equalsIgnoreCase("EesMnr0204Event")) {
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
		}else if(e.getEventName().equalsIgnoreCase("EesMnr0121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairPFMCByESTListService(e);
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
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0246Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByBuyerListService(e);
			}					
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0166Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalPFMCByEqDetailListService(e);	
			}
		}  						 
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0204 : Retrieve<br>
	 * retrieving Tire Replacement Report.<br>
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
	 * retrieving Tire Replacement History Report.<br>
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
	 * retrieving Tire Purchase Report by Item.<br>
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
	 * EES_MNR_0166 : Retrieve<br>
	 * [EES_MNR_0166] retrieving sold results per Equipment. <br>
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
	 * EES_MNR_0203 : Retrieve<br>
	 * retrieving Tire Purchase Report by Supplier.<br>
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
	 * retrieving Total Loss Payment to Lessor Report.<br>
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
	 * EES_MNR_0121 : Retrieve<br>
	 * retrieving MNR PFMC by Estimation Creation.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairPFMCByESTListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0121Event event = (EesMnr0121Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		try{
			List<RepairPFMCByESTVO> list = command.searchRepairPFMCByESTListBasic(event.getRepairPFMCByESTINVO());
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
	 * retrieving MNR PFMC by Work Order.<br>
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
	 * retrieving MNR PFMC by AGMT TRIFF.<br>
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
	 * EES_MNR_0118 : Retrieve<br>
	 * retrieving MNR PFMC by Type/Size.<br>
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
	 * retrieving MNR PFMC by VNDR/Manufacturer.<br>
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
	 * retrieving ACEP Candidate Cntr List.<br>
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
	 * retrieving MNR PFMC by Agreement/Tariff List.<br>
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
	 * retrieving PFMC by Account/Cost Code List.<br>
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
	 * [EES_MNR_0244] retrieving sold Results per RCC/LCC/SCC.<br>
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
	 * [EES_MNR_0245] retrieving Monthly sold Results.<br>
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
	 * EES_MNR_0246 : Retrieve<br>
	 * [EES_MNR_0246] retrieving Sold Results by buyer. <br>
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
}
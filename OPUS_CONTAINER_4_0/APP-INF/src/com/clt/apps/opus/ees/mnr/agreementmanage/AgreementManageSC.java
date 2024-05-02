/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementManageSC.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage;

import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.basic.RateMgtBC;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.basic.RateMgtBCImpl;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event.EesMnr0015Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event.EesMnr0016Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event.EesMnr0018Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.event.EesMnr0218Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBC;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBCImpl;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0011Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0014Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0136Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0154Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0171Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0188Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0190Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0232Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnrS011Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnrS171Event;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.integration.TariffMgtDBDAO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.RepairTariffMgtGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-AgreementManage Business Logic ServiceCommand - COM-AgreementManage handling business transaction
 *
 * @author 
 * @see TariffMgtDBDAO
 * @since J2EE 1.6
 */

public class AgreementManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AgreementManage system preceding process for biz scenario<br>
	 * ees_mnr_0188 related objects creation<br>
	 */
	public void doStart() {
		log.debug("AgreementManageSC Start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AgreementManage system biz scenario closing<br>
	 * ees_mnr_0188 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("AgreementManageSC End");
	}

	/**
	 * COM-AgreementManage system <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EesMnr0188Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffPopUpListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0015Event")) {
			//retrieving
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementService(e);
			}
			//deleting
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeAgreementService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgreementService(e);
			}
			//getting menu.
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAgreementMenuService(e);
			}
			//retrieving combo data
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAgreementComboListService(e);
			}
			//retrieving combo data of Tarrif 
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRepairTariffComboListService(e);
			}
			// retrieving estimate list
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchUsedEstimateByAGMTService(e);
			}
			// checking unapproved estimate before version up
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchNotApprovalESTByAGMTService(e);
			}
			// checking agreement duplication
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchAgmtDupInfoService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0016Event")) {
			//retrieving
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementInfoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0018Event")) {
			//retrieving
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementInfoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffService(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepairTariffService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0154Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalTariffRegionListService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalTariffRegionListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndDisposalTariffRegionListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0232Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalTariffQuarterListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0190Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyRepairTariffService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0218Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = searchAgreementService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDefaultRepairTariffDetailService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0136Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffApprovalListService(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyRepairTariffStatusService(e);
			}

		}
		else if (e.getEventName().equalsIgnoreCase("EesMnr0171Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffApprovalListService(e);
			}
		}	
		
		//**************** SPP FUNCTION *******************************//
		else if (e.getEventName().equalsIgnoreCase("EesMnrS011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDefaultRepairTariffDetailService(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EesMnrS171Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairTariffApprovalListService(e);
			}
		}
		
		
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : IBSEARCH_ASYNC04 <br>
	 * [EES_MNR_0015] retrieving estimate list <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsedEstimateByAGMTService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();
		AgreementGRPVO agreementGRPVO = new AgreementGRPVO();
		EesMnr0015Event event = (EesMnr0015Event)e;
		agreementGRPVO = event.getAgreementGRPVO();

		try{
			agreementGRPVO = command.searchUsedEstimateByAGMTBasic(agreementGRPVO);

			List<CustomMnrOrdHdrVO> customMnrOrdHdrVOs = agreementGRPVO.getCustomMnrOrdHdrVOS();

			StringBuilder retResultList = new StringBuilder("");
			for (int i = 0; i < customMnrOrdHdrVOs.size(); i++) {
				retResultList.append("Work Order No. : ").append(customMnrOrdHdrVOs.get(i).getMnrOrdOfcCtyCd()+customMnrOrdHdrVOs.get(i).getMnrOrdSeq()).append("\n");
			}

			eventResponse.setETCData("EST_LIST",retResultList.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : IBSEARCH_ASYNC05 <br>
	 * [EES_MNR_0015] checking unapproved estimate before version up.. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNotApprovalESTByAGMTService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();
		AgreementGRPVO agreementGRPVO = new AgreementGRPVO();
		EesMnr0015Event event = (EesMnr0015Event)e;
		agreementGRPVO = event.getAgreementGRPVO();

		try{
			agreementGRPVO = command.searchNotApprovalESTByAGMTBasic(agreementGRPVO);

			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOs = agreementGRPVO.getCustomMnrRprRqstHdrVOS();

			StringBuilder retResultList = new StringBuilder("");
			for (int i = 0; i < customMnrRprRqstHdrVOs.size(); i++) {
				retResultList.append("EQ No. : ").append(customMnrRprRqstHdrVOs.get(i).getRqstEqNo()).append("\t").append("Estimate No. : ").append(customMnrRprRqstHdrVOs.get(i).getRqstRefNo()).append("\n");
			}

			eventResponse.setETCData("EST_LIST",retResultList.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0188 : Retrieve <br>
	 * [EES_MNR_0188] retrieving M&R Tariff No Inquiry_Pop Up. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairTariffPopUpListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TariffMgtBC command = new TariffMgtBCImpl();

		TariffPopupGRPVO tariffPopupGRPVO = new TariffPopupGRPVO();

		EesMnr0188Event event = (EesMnr0188Event)e;
		TariffPopupINVO tariffPopupINVO = event.getTariffPopupINVO();
		tariffPopupGRPVO.setTariffPopupINVO(tariffPopupINVO);

		try{
			tariffPopupGRPVO = command.searchRepairTariffPopUpListBasic(tariffPopupGRPVO,account);
			eventResponse.setRsVoList(tariffPopupGRPVO.getCustomMnrRprTrfHdrVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : Retrieve <br>
	 * [EES_MNR_0188] retrieving M&R Tariff No Combo. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairTariffComboListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TariffMgtBC command = new TariffMgtBCImpl();
		TariffPopupGRPVO tariffPopupGRPVO = new TariffPopupGRPVO();
		EesMnr0015Event event = (EesMnr0015Event)e;
		tariffPopupGRPVO = event.getTariffPopupGRPVO();

		try{
			tariffPopupGRPVO = command.searchRepairTariffComboListBasic(tariffPopupGRPVO);
			eventResponse.setRsVoList(tariffPopupGRPVO.getCustomMnrRprTrfHdrVOs());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0218 : Retrieve <br>
	 * [EES_MNR_0218] retrieving M&R Agreement. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = null;
		//EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();

		try{
			if (e.getEventName().equalsIgnoreCase("EesMnr0015Event")) {
				EesMnr0015Event event = (EesMnr0015Event)e;
				AgreementGRPVO agreementGRPVO = command.searchAgreementBasic(event.getAgreementGRPVO());
				eventResponse = agreementGRPVO.getGeneralEventResponse();
			} else if (e.getEventName().equalsIgnoreCase("EesMnr0218Event")) {
				EesMnr0218Event event = (EesMnr0218Event)e;
				AgreementGRPVO agreementGRPVO = command.searchAgreementBasic(event.getAgreementGRPVO());
				eventResponse = agreementGRPVO.getGeneralEventResponse();
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : doActionIBSheet <br>
	 * [EES_MNR_0015] deleting M&R Agreement. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeAgreementService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();
		event.getAgreementGRPVO().setAccount(account);

		try{
			begin();
			command.removeAgreementBasic(event.getAgreementGRPVO());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0015 : Save <br>
	 * [EES_MNR_0015] adding/modification/deletion M&R Agreement. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgreementService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();
		PartnerMgtBC command1 = new PartnerMgtBCImpl();

		event.getAgreementGRPVO().setAccount(account);
		event.getRepairPartnerGRPVO().setAccount(account);

		try{
			begin();
			AgreementGRPVO agreementGRPVO = command.manageAgreementBasic(event.getAgreementGRPVO());
			RepairPartnerGRPVO repairPartnerGRPVO = event.getRepairPartnerGRPVO();
			repairPartnerGRPVO.setCustomMnrAgmtHdrVO(agreementGRPVO.getCustomMnrAgmtHdrVO());
			command1.manageRepairPartnerBasic(repairPartnerGRPVO,account);
			commit();
			agreementGRPVO = command.searchAgreementBasic(agreementGRPVO);
			eventResponse = agreementGRPVO.getGeneralEventResponse();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception eex){
			rollback();
			throw new EventException(eex.getMessage(), eex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0218 : doActionIBSheet <br>
	 * [EES_MNR_0218] retrieving M&R Agreement. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementMenuService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();

		try{
			AgreementGRPVO agreementGRPVO = command.searchAgreementMenuBasic(event.getAgreementGRPVO());
			eventResponse.setRsVoList(agreementGRPVO.getCustomAgreementMenuDataVOS());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0018 : Retrieve <br>
	 * [EES_MNR_0018] retrieving M&R Agreement List. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementInfoListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RateMgtBC command = new RateMgtBCImpl();

		try{
			AgreementInfoListGRPVO agreementInfoListGRPVO = new AgreementInfoListGRPVO();

			if (e.getEventName().equalsIgnoreCase("EesMnr0016Event")) {
				EesMnr0016Event event = (EesMnr0016Event)e;
				agreementInfoListGRPVO = command.searchAgreementInfoListBasic(event.getAgreementInfoListGRPVO());
			}else if (e.getEventName().equalsIgnoreCase("EesMnr0018Event")) {
				EesMnr0018Event event = (EesMnr0018Event)e;
				agreementInfoListGRPVO = command.searchAgreementInfoListBasic(event.getAgreementInfoListGRPVO());
			}

			eventResponse.setRsVoList(agreementInfoListGRPVO.getCustomAgreementInfoListDataVOs());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0215 : Retrieve <br>
	 * [EES_MNR_0215] retrieving Tariff Detail Information_Pop_Up. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairTariffService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0014Event event = (EesMnr0014Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		RepairTariffMgtGRPVO repairTariffMgtGRPVO = new RepairTariffMgtGRPVO();
		repairTariffMgtGRPVO.setRepairTariffMgtINVO((event.getRepairTariffMgtINVO()));

		try{
			repairTariffMgtGRPVO = command.searchRepairTariffBasic(repairTariffMgtGRPVO,account);
			//retrieving(Header)
			eventResponse.setRsVoList(repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVOs());
			//multiple search(Detail)
			for (int i = 0; i < repairTariffMgtGRPVO.getListCustomMnrRprTrfDtlVOs().size(); i++) {
				eventResponse.setRsVoList(repairTariffMgtGRPVO.getListCustomMnrRprTrfDtlVOs().get(i));
			}

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0014 : Save <br>
	 * [EES_MNR_0014] adding/modification/deletion M&R Standard Tariff Creation & Inquiry. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRepairTariffService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0014Event event = (EesMnr0014Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			begin();

			RepairTariffMgtGRPVO repairTariffMgtGRPVO = new RepairTariffMgtGRPVO();
			repairTariffMgtGRPVO.setCustomMnrRprTrfHdrVO(event.getCustomMnrRprTrfHdrVO());
			repairTariffMgtGRPVO.setArrayCustomMnrRprTrfDtlVOs(event.getArrayCustomMnrRprTrfDtlVOs());
			repairTariffMgtGRPVO = command.manageRepairTariffBasic(repairTariffMgtGRPVO,account);

			//Tariff No return
			eventResponse.setRsVo(repairTariffMgtGRPVO.getCustomMnrRprTrfHdrVO());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0190 : Verify <br>
	 * [EES_MNR_0190] verifying Local Tariff File Import_Pop Up. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyRepairTariffService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0190Event event = (EesMnr0190Event)e;

		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOs());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		VerifyTariffFileListGRPVO verifyTariffFileListGRPVO = new VerifyTariffFileListGRPVO();
		verifyTariffFileListGRPVO.setVerifyTariffFileListINVO(event.getVerifyTariffFileListINVO());

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			begin();

			// getting sequense after saving on temple table by common function
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);

			// modifying for Validation Check and getting modified value
			verifyTariffFileListGRPVO.getVerifyTariffFileListINVO().setTmpSeq(seqValue);  				//set tmp_seq
			String programId = verifyTariffFileListGRPVO.getVerifyTariffFileListINVO().getProgramId();
			//ees_mnr_0011 : Local Tariff
			if(programId.equals("ees_mnr_0011")) {
				verifyTariffFileListGRPVO = command.verifyLocalTariffFileListBasic(verifyTariffFileListGRPVO);	//update and search
			//ees_mnr_0014 : Sandard Tariff
			} else {
				verifyTariffFileListGRPVO = command.verifyTariffFileListBasic(verifyTariffFileListGRPVO);	//update and search
			}

			commit();

			//set return to event
			eventResponse.setRsVoList(verifyTariffFileListGRPVO.getCustomMnrDatVrfyVOS());

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0226 : New <br>
	 * [EES_MNR_0226] retrieving W/O Creation. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementComboListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0015Event event = (EesMnr0015Event)e;
		RateMgtBC command = new RateMgtBCImpl();

		try{
			AgreementGRPVO agreementGRPVO = command.searchAgreementComboListBasic(event.getAgreementGRPVO());
			eventResponse.setRsVoList(agreementGRPVO.getCustomMnrAgmtHdrVOS());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0011 : searchDefault <br>
	 * [EES_MNR_0011] retrieving M&R Local Tariff Creation & Verify. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDefaultRepairTariffDetailService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairTariffMgtGRPVO repairTariffMgtGRPVO = new RepairTariffMgtGRPVO();

/*		EesMnr0011Event event = (EesMnr0011Event)e;
		repairTariffMgtGRPVO.setRepairTariffMgtINVO((event.getRepairTariffMgtINVO()));
*/
		if(e.getEventName().equalsIgnoreCase("EesMnr0011Event")){
			EesMnr0011Event event = (EesMnr0011Event)e;
			repairTariffMgtGRPVO.setRepairTariffMgtINVO((event.getRepairTariffMgtINVO()));
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS011Event")) {
			EesMnrS011Event event = (EesMnrS011Event)e;
			repairTariffMgtGRPVO.setRepairTariffMgtINVO((event.getRepairTariffMgtINVO()));
		}

		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			repairTariffMgtGRPVO = command.searchDefaultRepairTariffDetailBasic(repairTariffMgtGRPVO,account);
			//multiple search(Detail)
			for (int i = 0; i < repairTariffMgtGRPVO.getListCustomMnrRprTrfDtlVOs().size(); i++) {
				eventResponse.setRsVoList(repairTariffMgtGRPVO.getListCustomMnrRprTrfDtlVOs().get(i));
			}

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0171 : Retrieve <br>
	 * [EES_MNR_0171] retrieving M&R Tariff Inquiry. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairTariffApprovalListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		TariffApprovalGRPVO tariffApprovalGRPVO = new TariffApprovalGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0136Event")){
			EesMnr0136Event event = (EesMnr0136Event)e;
			tariffApprovalGRPVO.setTariffApprovalINVO(event.getTariffApprovalINVO());
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0171Event")) {
			EesMnr0171Event event = (EesMnr0171Event)e;
			tariffApprovalGRPVO.setTariffApprovalINVO(event.getTariffApprovalINVO());
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS171Event")) {
			EesMnrS171Event event = (EesMnrS171Event)e;
			tariffApprovalGRPVO.setTariffApprovalINVO(event.getTariffApprovalINVO());
		}
		
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			tariffApprovalGRPVO = command.searchRepairTariffApprovalListBasic(tariffApprovalGRPVO,account);
			eventResponse.setRsVoList(tariffApprovalGRPVO.getListCustomTariffApprovalVO());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0136 : Delete <br>
	 * [EES_MNR_0136] modifying M&R Regional Tariff Approval. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRepairTariffStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0136Event event = (EesMnr0136Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			begin();

			TariffApprovalGRPVO tariffApprovalGRPVO = new TariffApprovalGRPVO();
			tariffApprovalGRPVO.setArrayCustomTariffApprovalVOs((event.getArrayCustomTariffApprovalVOs()));
			command.modifyRepairTariffStatusBasic(tariffApprovalGRPVO,account);

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Retrieve <br>
	 * [EES_MNR_0154] retrieving Quarterly selling prices based. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalTariffRegionListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0154Event event = (EesMnr0154Event)e;
			TariffMgtBC command = new TariffMgtBCImpl();
			List<DisposalTariffRegionVO> list = command.searchDisposalTariffRegionListBasic(event.getDisposalTariffRegionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Save <br>
	 * [EES_MNR_0154] adding/modification/deletion Quarterly selling prices based. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalTariffRegionListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0154Event event = (EesMnr0154Event)e;
		TariffMgtBC command = new TariffMgtBCImpl();

		try{
			begin();
			command.manageDisposalTariffRegionListBasic(event.getDisposalTariffRegionVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : Save - BackEndJob<br>
	 * [EES_MNR_0154] adding/modification/deletion Quarterly selling prices based.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndDisposalTariffRegionListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesMnr0154Event event = (EesMnr0154Event)e;
			TariffMgtBC command = new TariffMgtBCImpl();
			String status = command.backEndDisposalTariffRegionListBasic(event.getDisposalTariffRegionVOs(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0154 : BackEndJob<br>
	 * retrieving status result of BackEndJob.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			TariffMgtBC command = new TariffMgtBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0232 : Retrieve <br>
	 * [EES_MNR_0232] retrieving Based on local selling prices. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalTariffQuarterListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesMnr0232Event event = (EesMnr0232Event)e;
			TariffMgtBC command = new TariffMgtBCImpl();
			DisposalTariffQuarterGRPVO resultVO = command.searchDisposalTariffQuarterListBasic(event.getDisposalTariffQuarterVO());
			List<List<DisposalTariffQuarterVO>> lists = resultVO.getDisposalTariffQuarterVOs();

			eventResponse.setRsVoList(lists.get(0));
			eventResponse.setRsVoList(lists.get(1));
			eventResponse.setRsVoList(lists.get(2));
			eventResponse.setRsVoList(lists.get(3));
			eventResponse.setRsVoList(lists.get(4));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0015 : IBSEARCH_ASYNC05 <br>
	 * [EES_MNR_0015] Checking Duplicate Agreement <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtDupInfoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RateMgtBC command = new RateMgtBCImpl();
		AgreementGRPVO agreementGRPVO = new AgreementGRPVO();
		EesMnr0015Event event = (EesMnr0015Event)e;
		agreementGRPVO = event.getAgreementGRPVO();
		String agmtNo = "";

		try{
			agmtNo = command.searchAgmtDupInfoBasic(agreementGRPVO); 
			eventResponse.setETCData("agmt_no", agmtNo);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}
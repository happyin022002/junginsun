/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtSC.java
*@FileTitle : Territories Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBC;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0426Event;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0428Event;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0429Event;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0451Event;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration.EmptyReleaseRedeliveryOrderMgtDBDAO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.CimTerritoryVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo.SearchTerritoryForMultiComboVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-EmptyReleaseRedeliveryOrderMgt Business Logic ServiceCommand - OPUS-EmptyReleaseRedeliveryOrderMgt 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author 
 * @see EmptyReleaseRedeliveryOrderMgtDBDAO
 * @since J2EE 1.6
 */
public class EmptyReleaseRedeliveryOrderMgtSC extends ServiceCommandSupport {

	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding business scenario job for EmptyReleaseRedeliveryOrderMgt system 
	 * creating Object when calling business scenario
	 */
	public void doStart() {
		log.debug("EmptyReleaseRedeliveryOrderMgtSC 시작");
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * closing EmptyReleaseRedeliveryOrderMgt system business scenario
	 */
	public void doEnd() {
		log.debug("EmptyReleaseRedeliveryOrderMgtSC 종료");
	}

	/**
	 * processing business scenarios for events
	 * handling event for OPUS-EmptyReleaseRedeliveryOrderMgt system 
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// in case of handling multiple event with single SC
		if (e.getEventName().equalsIgnoreCase("EesCtm0428Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerritoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTerritory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0426Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIssueList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerritoryForMultiCombo();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getYardFaxEmailInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = settleIssuedOrder(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendFaxEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = checkEdiYardSetup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0451Event")) {
			eventResponse = searchRDContent(e);
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0429Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {             // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {    // It starts a job of backend. 1
				eventResponse = doBackEndJobSettledOrderList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){    // It returns a result. 3
				eventResponse = searchSettledOrderList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRecovery(e);
			}
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0428 : onload<br>
	 * retrieving CimTerritory list, Combo1-MdmCountry, Combo2-MdmOrganization 
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerritoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCtm0428Event event = (EesCtm0428Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			// CimTerritory list
			List<CimTerritoryVO> list0 = command.searchTerritoryList(event.getCimTerritoryVO());
			// Combo1-MdmCountry
			List<MdmCountryVO> list1 = command.selectComboCountry(event.getMdmCountryVO());
			// Combo2-MdmOrganization
			List<MdmOrganizationVO> list2 = command.selectComboOrganization(event.getMdmOrganizationVO());

			eventResponse.setRsVoList(list0);
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0428 : btn_save<br>
	 * handling multiple event for CimTerritory list
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTerritory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0428Event event = (EesCtm0428Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			begin();
			command.manageTerritory(event.getCimTerritoryVOS(), account);
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0426 : onload
	 * retrieving TerritoryList for Multicombo
	 *
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerritoryForMultiCombo() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			List<SearchTerritoryForMultiComboVO> list = command.searchTerritoryForMultiCombo(account.getOfc_cd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0426 : btn_retrieve
	 * retrieving CimCStock IssueList
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIssueList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0426Event event = (EesCtm0426Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			List<CimCStockVO> list = command.searchIssueList(event.getCimCStockVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0426 : btn_settled
	 * settling CimCStock IssuedOrder
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse settleIssuedOrder(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0426Event event = (EesCtm0426Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			begin();
			command.settleIssuedOrder(event.getCimCStockVOS(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0426 : Validation
	 * getting FAX No and Email for Yard Code
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getYardFaxEmailInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0426Event event = (EesCtm0426Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			String[] returnValues = command.getYardFaxEmailInfo(event.getCimCStockVO().getEmptyCy());
			eventResponse.setETCData("ydCd", returnValues[0]);
			eventResponse.setETCData("faxNo", returnValues[1]);
			eventResponse.setETCData("ydEml", returnValues[2]);
		}catch(EventException ex){
			log.error("\n\n[SC - getYardFaxEmailInfo] EventException :  " + ex.getMessage(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("\n\n[SC - getYardFaxEmailInfo] Exception :  " + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0451 : onload
	 * retrieving RD contents
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDContent(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0451Event event = (EesCtm0451Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			event.getCimCStockVOS()[0].setUserId(event.getRDFaxMailEAIVO().getSenderUsrId());
			event.getCimCStockVOS()[0].setUserOfc(event.getRDFaxMailEAIVO().getSenderUsrOfc());
			event.getCimCStockVOS()[0].setUserCnt(event.getRDFaxMailEAIVO().getSenderUsrCnt());
			event.getCimCStockVOS()[0].setEmail(event.getRDFaxMailEAIVO().getReceiverEml());
			event.getCimCStockVOS()[0].setFaxNo(event.getRDFaxMailEAIVO().getReceiverFax());
			String stringForRD = command.searchRDContent(event.getCimCStockVOS());
			eventResponse.setETCData("RD", stringForRD);
		}catch(EventException ex){
			log.error("\n\n[SC - searchRDContents] EventException :  " + ex.getMessage(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("\n\n[SC - searchRDContents] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0451 : btn_confirm
	 * modifying FAX result information
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendFaxEmail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0426Event event = (EesCtm0426Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		List<CimCStockVO> manageList = new ArrayList<CimCStockVO>();
		String[] returnValues = null;
		String sendFaxMailKey = "";

		try{
			String userLoc = command.getUserLocCd(event.getRDFaxMailEAIVO().getSenderUsrId());
			for ( int i=0; i<event.getCimCStockVOS().length; i++ ) {
				begin();

				event.getCimCStockVOS()[i].setType(event.getCimCStockVOS()[0].getType());
				event.getCimCStockVOS()[i].setIssueFlag(event.getCimCStockVOS()[0].getIssueFlag());
				event.getCimCStockVOS()[i].setIssueType(event.getCimCStockVOS()[0].getIssueType());
				// you can use account method but in RD server you can not account method
				// so use etRDFaxMailEAIVO() to get account information
				event.getCimCStockVOS()[i].setUserId(event.getRDFaxMailEAIVO().getSenderUsrId());
				event.getCimCStockVOS()[i].setUserOfc(event.getRDFaxMailEAIVO().getSenderUsrOfc());
				event.getCimCStockVOS()[i].setUserLoc(userLoc);

				manageList = new ArrayList<CimCStockVO>();
				/* Release */
				if ("RLS".equals(event.getCimCStockVOS()[0].getType())) {
					manageList.addAll(command.searchForSendFaxEmail(event.getCimCStockVOS()[i]));
				/* Redelivery */
				} else {
					/* Redelivery - M - Issue */
					if ("RDV".equals(event.getCimCStockVOS()[0].getType()) && "M".equals(event.getCimCStockVOS()[i].getTypeCd()) && "I".equals(event.getCimCStockVOS()[0].getIssueFlag())) {
						returnValues = command.getSoOfcNextVal(event.getRDFaxMailEAIVO().getSenderUsrOfc());
						event.getCimCStockVOS()[i].setSoOfcCtyCd(returnValues[0]);
						event.getCimCStockVOS()[i].setSoSeq(returnValues[1]);
					}
					manageList.add(event.getCimCStockVOS()[i]);
				}

				if (manageList == null || manageList.size() < 1) {
					throw new EventException(new ErrorHandler("There is no issue data.").getMessage());

				} else {
					//// RD Fax/Mail (S) ///////////////////////////////////////////////////////////////////////////////
					if ("F".equals(event.getCimCStockVOS()[0].getIssueType()) || "E".equals(event.getCimCStockVOS()[0].getIssueType())) {
						if (i == 0) {
							event.getRDFaxMailEAIVO().setTitle("MT " + manageList.get(manageList.size()-1).getSoSeq() + "(YARD# "+event.getCimCStockVOS()[0].getEmptyCy()+")");
							event.getRDFaxMailEAIVO().setContent("Empty Release_Redelivery Order  - MT " + manageList.get(manageList.size()-1).getSoSeq() );
							// set receiver name(yard name)
							event.getRDFaxMailEAIVO().setReceiverNm(command.getYardFaxEmailInfo(event.getCimCStockVOS()[0].getEmptyCy())[3]);
							// sending RD Fax/Mail
							sendFaxMailKey = command.rdFaxMailSend(event.getCimCStockVOS()[0].getIssueType(), event.getRDFaxMailEAIVO());
							log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% sendFaxMailKey : " + sendFaxMailKey + "\n");
						}
						if (sendFaxMailKey != null && !"".equals(sendFaxMailKey)) {
							for ( int h=0; h<manageList.size(); h++ ) {
								manageList.get(h).setSendKey(sendFaxMailKey);
							}
						}
					}else if("D".equals(event.getCimCStockVOS()[i].getIssueType())){
						/* D일 때 EDI 송신 */
						if(i == 0){
							// EDI 전송
							sendFaxMailKey = command.sendEdi(event.getCimCStockVOS());
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% sendFaxMailKey : " + sendFaxMailKey + "\n");
						if (sendFaxMailKey != null && !"".equals(sendFaxMailKey)) {
							for ( int h=0; h<manageList.size(); h++ ) {
								manageList.get(h).setSendKey(sendFaxMailKey);
							}
						}
					}
					//// RD Fax/Mail (E) ///////////////////////////////////////////////////////////////////////////////
					
					command.manageSTKsendFaxEmail(manageList);

					/* calling BKG module in case of C or M and IssueFlag <> R(Resend/Correction) OR O(Correction)  */
					if (("C".equals(event.getCimCStockVOS()[i].getTypeCd()) || "M".equals(event.getCimCStockVOS()[i].getTypeCd())) && (!event.getCimCStockVOS()[0].getIssueFlag().equals("R") || !event.getCimCStockVOS()[0].getIssueFlag().equals("O"))) {
						com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC bkgCommand =
							new com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl();
						com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO =
							new com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO();

						for ( int k=0; k<manageList.size(); k++ ) {
							eurTroMtyRelByCtmVO.setBkgNo(manageList.get(k).getBkgNo());
							eurTroMtyRelByCtmVO.setBoundCd(manageList.get(k).getBd());
							if (event.getCimCStockVOS()[0].getIssueFlag().equals("C")) {
								eurTroMtyRelByCtmVO.setCfmFlag("N");
							} else {
								eurTroMtyRelByCtmVO.setCfmFlag("Y");
							}
							eurTroMtyRelByCtmVO.setHaulageCd(manageList.get(k).getTypeCd());
							if (manageList.get(k).getType().equals("RLS")) {
								eurTroMtyRelByCtmVO.setJobDivCd("RELEASE");
							} else {
								eurTroMtyRelByCtmVO.setJobDivCd("REDELIVERY");
							}
							eurTroMtyRelByCtmVO.setJobDt(manageList.get(k).getPdDate().replace("-", ""));
							eurTroMtyRelByCtmVO.setSoCityCd(manageList.get(k).getSoOfcCtyCd());
							eurTroMtyRelByCtmVO.setSoSeq(manageList.get(k).getSoSeq());
							eurTroMtyRelByCtmVO.setTroSeq(manageList.get(k).getTroSeq());
							eurTroMtyRelByCtmVO.setYdCd(manageList.get(k).getEmptyCy());
							bkgCommand.modifyEurTroByEmptyRelease(eurTroMtyRelByCtmVO, account);
						}
					}
				}
				commit();
			}

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BackEndJob - returning BackEndJob status
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBackEndJob(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			String status = command.comBackEndJob((String) e.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0429 : btn_retrive
	 * starting BackEndJob
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobSettledOrderList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0429Event event = (EesCtm0429Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobSettledOrderList(account, event.getCimCStockVO()));
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0429 : BackEndJob
	 * retrieving SettledOrderList
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSettledOrderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			List<CimCStockVO> list = command.searchSettledOrderList((String) e.getAttribute("KEY"));
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0429 : btn_recovery<br>
	 * Recovering SettledOrderList
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRecovery(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0429Event event = (EesCtm0429Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();

		try{
			begin();
			
			command.manageSTKRecovery(event.getCimCStockVOS(), account);

			for ( int i=0; i<event.getCimCStockVOS().length; i++ ) {
				/* calling BKG module in case of C or M */
				if ("C".equals(event.getCimCStockVOS()[i].getTypeCd()) || "M".equals(event.getCimCStockVOS()[i].getTypeCd())) {

					com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC bkgCommand =
						new com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl();
					com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO eurTroMtyRelByCtmVO =
						new com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMtyRelByCtmVO();

					eurTroMtyRelByCtmVO.setBkgNo(event.getCimCStockVOS()[i].getBkgNo());
					eurTroMtyRelByCtmVO.setBoundCd(event.getCimCStockVOS()[i].getBd());
					eurTroMtyRelByCtmVO.setHaulageCd(event.getCimCStockVOS()[i].getTypeCd());
					if (event.getCimCStockVOS()[i].getTypeCd().equals("M")) {
						eurTroMtyRelByCtmVO.setSoCityCd(event.getCimCStockVOS()[i].getSoOfcCtyCd());
						eurTroMtyRelByCtmVO.setSoSeq(event.getCimCStockVOS()[i].getSoSeq());
					}
					eurTroMtyRelByCtmVO.setCfmFlag("N");
					eurTroMtyRelByCtmVO.setJobDivCd("RECOVERY");
					eurTroMtyRelByCtmVO.setJobDt(event.getCimCStockVOS()[i].getPdDate().replace("-", ""));
					eurTroMtyRelByCtmVO.setTroSeq(event.getCimCStockVOS()[i].getTroSeq());
					eurTroMtyRelByCtmVO.setYdCd(event.getCimCStockVOS()[i].getEmptyCy());
					bkgCommand.modifyEurTroByEmptyRelease(eurTroMtyRelByCtmVO, account);
				}
			}
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CTM_0426 : send<br>
	 * EDI Yard Setup이 되어있는지 확인합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkEdiYardSetup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0426Event event = (EesCtm0426Event)e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try{
			String ediYardSetup = command.checkEdiYardSetup(event.getCimCStockVO().getEmptyCy());
			eventResponse.setETCData("edi_yard_setup", ediYardSetup);
			eventResponse.setETCData("yard_cd", event.getCimCStockVO().getEmptyCy());
		}catch(EventException ex){
			log.error("\n\n[SC - searchRDContents] EventException :  " + ex.getMessage(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("\n\n[SC - searchRDContents] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}	
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffSC.java
*@FileTitle : Tariff Rule Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.common.diff.DiffList;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.basic.InlandRatesBC;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.basic.InlandRatesBCImpl;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3514Event;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3515Event;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3516Event;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3517Event;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3521Event;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.event.EsmPri3522Event;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.PriTrfInlndParamVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndRtVO;
import com.clt.apps.opus.esm.pri.tariff.inlandrates.vo.RsltPriTrfInlndVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.basic.TariffCodeBC;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.basic.TariffCodeBCImpl;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.event.EsmPri3502Event;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.event.EsmPri3503Event;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeALLVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeUsedVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffScopeDupVO;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.basic.TariffGeneralInformationBC;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.basic.TariffGeneralInformationBCImpl;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3501Event;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3504Event;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3505Event;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3511Event;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event.EsmPri3518Event;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryAmendVO;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryVO;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcListVO;
import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.RsltPriTrfBzcVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.basic.TariffRuleBC;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.basic.TariffRuleBCImpl;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3507Event;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3509Event;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3510Event;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3512Event;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3519Event;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.event.EsmPri3599Event;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.integration.TariffRuleDBDAO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.RsltPriTrfRuleVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTariffVO;
import com.clt.syscommon.common.table.PriTrfBzcVO;
import com.clt.syscommon.common.table.PriTrfInlndVO;


/**
 * handling business transaction about Tariff Business Logic ServiceCommand
 * 
 * @author 
 * @see TariffRuleDBDAO
 * @since J2EE 1.6
 */

public class TariffSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario Tariff system <br>
	 */
	public void doStart() {
		log.debug("TariffSC start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Tariff system biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("TariffSC Finish");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmPri3507Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffRuleList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkTariffRuleNumber(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTariffRule(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {	//Amend Cancel
				eventResponse = cancelAmendTariffRule(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {	//Request
				eventResponse = requestTariffRule(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {	//Approve
				eventResponse = approveTariffRule(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) {	//Cancel
				eventResponse = cancelStatusTariffRule(e);
			}
			else {
				eventResponse = initTariffRuleComboData(e);
			}
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmPri3519Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {		//Amend
				eventResponse = amendTariffRule(e);
			}
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmPri3510Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {		//Publish
				eventResponse = publishTariffRule(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3512Event")) {	//Rule Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffRuleInquiryList(e);
			}
			else {
				eventResponse = initTariffRuleInquiryComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3509Event")) {	//Rule History
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffRuleHistoryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTariffRuleAmendHistoryList(e);
			}
			else {
				eventResponse = initTariffRuleHistoryComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3514Event")) {	//Inland Rates List
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInlandRatesName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Inland Rates Detail
				eventResponse = searchInlandRates(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	//Inland Rates Detail DownLoad
				eventResponse = searchInlandRatesExcel(e);
			}
			/*
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	//Excel Upload check
				eventResponse = searchInlandRatesCheck(e);
			}
			*/
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	//Inland Rates Max seq
				eventResponse = searchInlandRatesMaxSeq(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {	//Delete
				eventResponse = removeInlandRates(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {	//Cancel
				eventResponse = cancelInlandRates(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	//Save
				eventResponse = manageInlandRates(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {	//Attach 
				eventResponse = manageInlandRatesFile (e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {	//Request
				eventResponse = requestInlandRates(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {	//Approve
				eventResponse = approveInlandRates(e);
			}
			/*
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {	//EsmPri3517Event
				eventResponse = approveInlandRates(e);
			}
			*/
			else {
				eventResponse = initInlandRatesComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3521Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {		//Amend
				eventResponse = amendInlandRates(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3522Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			//Excel Check
				eventResponse = searchInlandRatesCheck(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		//Save
				eventResponse = manageInlandRatesExcel(e);
			}
			else {
				eventResponse = initInlandRatesComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3517Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {		//Publish
				eventResponse = publishInlandRates(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {       //FOCUS_OUT
				eventResponse = searchTariffCodeName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //Retrieve
				eventResponse = searchTariffCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {  //Save
				eventResponse = manageTariffCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //Delete
				eventResponse = removeTariffCode(e);
			}
			else{
				eventResponse = initTariffCodeCreationComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTariffGeneralInformation(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {	// SAVE
				eventResponse = manageTariffGeneralInformation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {	// DELETE
				eventResponse = removeTariffGeneralInformation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {	// REQUEST
				eventResponse = requestTariffGeneralInformation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {	// APPROVE
				eventResponse = approveTariffGeneralInformation(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) {	// CANCEL
				eventResponse = cancelTariffGeneralInformation(e);
			}
			else{
				eventResponse = initTariffGeneralInformationComboData(e);	
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3518Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {		// AMEND
				eventResponse = amendTariffGeneralInformation(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3503Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		//Retrieve
				eventResponse = searchTariffCodeList(e);
			}
			else{
				eventResponse = initTariffCodeComboData(e);                //FOCUS_OUT
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3505Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {		// PUBLISH
				eventResponse = publishTariffGeneralInformation(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3511Event")) {		// Tariff General Information Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {		// RETRIEVE
				eventResponse = searchTariffGeneralInformationInquiryList(e);
			}			
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		// DOUBLE CLICK
				eventResponse = searchTariffGeneralInformationInquiry(e);
			}
			else{																
				eventResponse = initTariffGeneralInformationInquiryComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3515Event")) {		// Inland Rates Inquiry
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {		// RETRIEVE
				eventResponse = searchInlandRatesInquiryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		// SHEET CLICK
				eventResponse = searchInlandRatesInquiry(e);
			}
			else {																
				eventResponse = initInlandRatesInquiryComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3504Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {		// RETRIEVE
				eventResponse = searchTariffGeneralHistoryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {		// SHEET 1 DOUBLE CLICK
				eventResponse = searchTariffGeneralAmendHistoryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {		// SHEET 2 DOUBLE CLICK
				eventResponse = searchTariffGeneralHistory(e);
			} 
			else{
				eventResponse = initTariffGeneralHistoryComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3516Event")) {		// Inland Rates History
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {		// RETRIEVE
				eventResponse = searchInlandRatesHistoryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {	// SHEET1 CLICK
				eventResponse = searchInlandRatesAmendHistoryList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// SHEET2 CLICK
				eventResponse = searchInlandRatesHistory(e);
			}
			else {																
				eventResponse = initInlandRatesHistoryComboData(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri3599Event")) {
			//Diff Popup
			eventResponse = searchTariffRuleDiff(e);
		}
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_3507 : [OPEN]<br>
	 * retrieving combo data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffRuleComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EsmPri3507Event event = (EsmPri3507Event)e;
		PRICommonBC command = new PRICommonBCImpl();
		TariffRuleBC command2 = new TariffRuleBCImpl();
        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try{
            //Amend Type
            vo.setCd("CD02760");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_RULE_AMDT_TP_CD", list);

            //Status
            vo.setCd("CD02395");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_RULE_STS_CD", list);

            //Charge Code
            list = command.searchChargeCdList(vo);
            eventResponse.setCustomData("TRF_RULE_CHG_CD", list);

            //Approval Office
            list = command.searchApprovalOfficeList(vo);
            eventResponse.setCustomData("APRO_OFC_CD", list);
          	
        	//TARIFF CODE
        	list = command2.searchTariffCodeList(vo);
            eventResponse.setCustomData("TARIFF_CD", list);
        	            
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3507 : [Retrieve]<br>
	 * retrieving [Tariff Rule Creation & Amendment information]<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try{			
			event.getPriTrfRuleVO().setRqstOfcCd(account.getOfc_cd());
			event.getPriTrfRuleVO().setAproOfcCd(account.getRhq_ofc_cd());
			
			List<RsltPriTrfRuleVO> list = command.searchTariffRuleList(event.getPriTrfRuleVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3507 : [Retrieve]<br>
	 * checking duplicate Tariff Rule Creation & Amendment<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkTariffRuleNumber(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try{
			String dupLen = command.checkTariffRuleNumber(event.getPriTrfRuleVO());
	        eventResponse.setETCData("DUP_LEN", dupLen);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3507 : [Save]<br>
	 * saving Tariff Rule Creation & Amendment<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try{
			begin();			
			//command.manageTariffRule(event.getPriTrfRuleVOS(),account);
			command.manageTariffRule(event.getPriTrfRuleListVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3519 : [Amend]<br>
	 * amending Tariff Rule Creation & Amendment <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse amendTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3519Event event = (EsmPri3519Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try{
			begin();
			command.amendTariffRule(event.getPriTrfRuleVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3507 : [Amend Cancel]<br>
	 * AMEND canceling Tariff Rule Creation & Amendment <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAmendTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try{
			begin();
			command.cancelAmendTariffRule(event.getPriTrfRuleVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3507 : [Request]<br>
	 * request Tariff Rule Creation & Amendment <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try{
			begin();
			command.requestTariffRule(event.getPriTrfRuleVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Request"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_3507 : [Approve]<br>
	 * APPROVE Tariff Rule Creation & Amendment <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approveTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try{
			begin();
			command.approveTariffRule(event.getPriTrfRuleVO(),account);			
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Approve"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_3510 : [Publish]<br>
	 * PUBLISH Tariff Rule Creation & Amendment<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse publishTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3510Event event = (EsmPri3510Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try{
			begin();
			command.publishTariffRule(event.getPriTrfRuleVO(),account);			
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Publish"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
		
	/**
	 * ESM_PRI_3507 : [Cancel]<br>
	 * modifying Tariff Rule Creation & Amendment state<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelStatusTariffRule(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3507Event event = (EsmPri3507Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();
		try{
			begin();
			command.cancelStatusTariffRule(event.getPriTrfRuleVO(),account);	
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Cancel"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3512 : [OPEN]<br>
	 * retrieving combo data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffRuleInquiryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EsmPri3507Event event = (EsmPri3507Event)e;
		PRICommonBC command = new PRICommonBCImpl();
		TariffRuleBC command2 = new TariffRuleBCImpl();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try{
            //Amend Type
            vo.setCd("CD02760");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_RULE_AMDT_TP_CD", list);

            //Status
            vo.setCd("CD02395");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_RULE_STS_CD", list);

            //Charge Code
            list = command.searchChargeCdList(vo);
            eventResponse.setCustomData("TRF_RULE_CHG_CD", list);

            //Approval Office
            list = command.searchApprovalOfficeList(vo);
            eventResponse.setCustomData("APRO_OFC_CD", list);
          	
        	//TARIFF CODE
        	list = command2.searchTariffCodeList(vo);
            eventResponse.setCustomData("TARIFF_CD", list);
        	            
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3512 : [Retrieve]<br>
	 * retrieving Tariff Rule <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3512Event event = (EsmPri3512Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try{
			List<RsltPriTrfRuleVO> list = command.searchTariffRuleInquiryList(event.getPriTrfRuleVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_3509 : [OPEN]<br>
	 * retrieving combo data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffRuleHistoryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		TariffRuleBC command2 = new TariffRuleBCImpl();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try{
            //Status
            vo.setCd("CD02395");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_RULE_STS_CD", list);

            //Approval Office
            list = command.searchApprovalOfficeList(vo);
            eventResponse.setCustomData("APRO_OFC_CD", list);
          	
        	//TARIFF CODE
        	list = command2.searchTariffCodeList(vo);
            eventResponse.setCustomData("TARIFF_CD", list);
        	            
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3514 : [OPEN]<br>
	 * retrieving combo data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initInlandRatesComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EsmPri3514Event event = (EsmPri3514Event)e;
		PRICommonBC command = new PRICommonBCImpl();
		InlandRatesBC command2 = new InlandRatesBCImpl();
		
        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try{ 
			
			if("EsmPri3514Event".equals(e.getEventName())) {
				 //Approval Office
	            list = command.searchApprovalOfficeList(vo);
	            eventResponse.setCustomData("APRO_OFC_CD", list);
	          	
	        	//TARIFF CODE
	        	list = command2.searchTariffCodeList(vo);
	            eventResponse.setCustomData("TARIFF_CD", list);

	            //Amend Type
	            vo.setCd("CD02760");
	            list = command.searchComCodeDescList(vo);
	            eventResponse.setCustomData("TRF_INLND_AMDT_TP_CD", list);
	            
	            //Status
	            vo.setCd("CD02395");
	            list = command.searchComCodeDescList(vo);
	            eventResponse.setCustomData("TRF_RULE_STS_CD", list);

	            //Source
	            vo.setCd("CD01734");
	            list = command.searchComCodeDescList(vo);
	            eventResponse.setCustomData("SRC_INFO_CD", list);
			}

        	//Currency
        	list = command.searchAllCurrencyCodeList(vo);
            eventResponse.setCustomData("CURR_CD", list);
          
            //Term
            vo.setCd("CD01725");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("INLND_RT_TERM_CD", list);

            //Trans. Mode
            vo.setCd("CD02772");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_INLND_RT_TRSP_MOD_CD", list);

            //Weght Unit
            vo.setCd("CD02764");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("INLND_RT_LMT_WGT_UT_CD", list);

            //Type
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            //list = command.searchComCodeList(vo);
            eventResponse.setCustomData("PRC_CGO_TP_CD", list);

		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3514 : [Save]<br>
	 * retrieving Inland Rate Max Seq<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesMaxSeq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try{
			String maxSeq = command.searchInlandRatesMaxSeq(event.getPriTrfInlndVO());
			eventResponse.setETCData("MAX_SEQ", maxSeq);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}	
		
	/**
	 * ESM_PRI_3514 : [Retrieve]<br>
	 * retrieving Inland Rate Name <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try{
			List<PriTrfInlndVO> list = command.searchInlandRatesName(event.getPriTrfInlndVO());
			eventResponse.setRsVoList(list);	
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3514 : [Retrieve]<br>
	 * retrieving Inland Rate detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		PriTrfInlndParamVO priTrfInlndParamVO = new PriTrfInlndParamVO();
		try{
			String searchFlg = event.getPriTrfInlndParamVO().getEtc1();
			
			//List<RsltPriTrfInlndVO> list1 = command.searchInlandRates(event.getPriTrfInlndParamVO());
			//eventResponse.setRsVoList(list1);
			
			event.getPriTrfInlndParamVO().setRqstOfcCd(account.getOfc_cd());
			event.getPriTrfInlndParamVO().setAproOfcCd(account.getRhq_ofc_cd());
						
			if(searchFlg.equals("ONLY_MAIN")) {
				List<RsltPriTrfInlndVO> list1 = command.searchInlandRates(event.getPriTrfInlndParamVO());
				eventResponse.setRsVoList(list1);
			} else if(searchFlg.equals("ONLY_DETAIL")) {
				List<RsltPriTrfInlndVO> list1 = command.searchInlandRates(event.getPriTrfInlndParamVO());
				//eventResponse.setRsVoList(list1);

				if(list1.isEmpty()) {
					throw new EventException(new ErrorHandler("PRI06014",new String[]{}).getMessage());
				}
				
				ObjectCloner.build(list1.get(0), priTrfInlndParamVO);	
				priTrfInlndParamVO.setEtc2(event.getPriTrfInlndParamVO().getEtc2());
				List<RsltPriTrfInlndRtVO> list2 = command.searchInlandRatesLocation(priTrfInlndParamVO);
				eventResponse.setRsVoList(list2);
				
				String maxSeq = command.searchInlandRatesLocationMaxSeq(priTrfInlndParamVO);
				eventResponse.setETCData("LOC_MAX_SEQ", maxSeq);

				String maxUpdate = command.searchInlandRatesMaxUpdate(priTrfInlndParamVO);
				eventResponse.setETCData("MAX_UPD_DT", maxUpdate);
			} else if(searchFlg.equals("CHECK_VIEW")) {				
				List<RsltPriTrfInlndRtVO> list2 = command.searchInlandRatesLocation(event.getPriTrfInlndParamVO());
				eventResponse.setRsVoList(list2);

				String maxSeq = command.searchInlandRatesLocationMaxSeq(event.getPriTrfInlndParamVO());
				eventResponse.setETCData("LOC_MAX_SEQ", maxSeq);

				String maxUpdate = command.searchInlandRatesMaxUpdate(priTrfInlndParamVO);
				eventResponse.setETCData("MAX_UPD_DT", maxUpdate);
			} else {
				List<RsltPriTrfInlndVO> list1 = command.searchInlandRates(event.getPriTrfInlndParamVO());
				eventResponse.setRsVoList(list1);

				if(list1.isEmpty()) {
					throw new EventException(new ErrorHandler("PRI06014",new String[]{}).getMessage());
				}
				
				ObjectCloner.build(list1.get(0), priTrfInlndParamVO);	
				priTrfInlndParamVO.setEtc2(event.getPriTrfInlndParamVO().getEtc2());		
				List<RsltPriTrfInlndRtVO> list2 = command.searchInlandRatesLocation(priTrfInlndParamVO);
				eventResponse.setRsVoList(list2);

				String maxSeq = command.searchInlandRatesLocationMaxSeq(priTrfInlndParamVO);
				eventResponse.setETCData("LOC_MAX_SEQ", maxSeq);

				String maxUpdate = command.searchInlandRatesMaxUpdate(priTrfInlndParamVO);
				eventResponse.setETCData("MAX_UPD_DT", maxUpdate);
			}
			
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3514 : [Down Excel]<br>
	 * Downloading Inland Rate detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		
		try{		
			List<RsltPriTrfInlndRtVO> list = command.searchInlandRatesExcel(event.getPriTrfInlndRtVO());			
			eventResponse.setRsVoList(list);	
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3522 : [check]<br>
	 * checking Inland Rate <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3522Event event = (EsmPri3522Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		
		try{		
			List<RsltCdListVO> list = command.searchInlandRatesCheck(event.getPriTrfInlndRtVOS());
			eventResponse.setRsVoList(list);	
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_3514 : [Delete]<br>
	 * deleting Inland Rate  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try{
			begin();
			
			String sValue = command.searchInlandRatesExistCheck(event.getPriTrfInlndVO());			

			if(sValue == null) {
					throw new EventException(new ErrorHandler("PRI01135",new String[]{"Inland Rates"}).getMessage());
			}
			
			command.removeInlandRates(event.getPriTrfInlndVO());	
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00102",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3514 : [Cancel]<br>
	 * canceling Inland Rate <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try{
			begin();

			String sValue = command.searchInlandRatesExistCheck(event.getPriTrfInlndVO());			
			// handling exception : current Amend Seq. doesn't exist 
			if(sValue == null) {
					throw new EventException(new ErrorHandler("PRI01135",new String[]{"Inland Rates"}).getMessage());
			}
			
			command.cancelInlandRates(event.getPriTrfInlndVO(),account);	
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Cancel"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3514 : [Save]<br>
	 * saving Inland Rate  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		PriTrfInlndVO tVo = new PriTrfInlndVO();
		try{
			begin();
			
			ObjectCloner.build(event.getPriTrfInlndListVO().getPriTrfInlndParamVO(), tVo);	
			String sFlag = event.getPriTrfInlndListVO().getPriTrfInlndVOs()[0].getIbflag();
			String sValue = command.searchInlandRatesExistCheck(tVo);
			
			
			// handling exception : current Amend Seq. doesn't exist 
			if("I".equals(sFlag) && sValue != null) {
				throw new EventException(new ErrorHandler("PRI01135",new String[]{"Inland Rates"}).getMessage());
			} else if(!"I".equals(sFlag) && sValue == null) {
				throw new EventException(new ErrorHandler("PRI01135",new String[]{"Inland Rates"}).getMessage());
			}
			
			command.manageInlandRates(event.getPriTrfInlndListVO(),account);
			
			//last update date
			String maxUpdate = command.searchInlandRatesMaxUpdate(event.getPriTrfInlndListVO().getPriTrfInlndParamVO());
			eventResponse.setETCData("MAX_UPD_DT", maxUpdate);
			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3522 : [Save]<br>
	 * saving Inland Rate <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInlandRatesExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3522Event event = (EsmPri3522Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try{
			begin();
			command.manageInlandRates(event.getPriTrfInlndListVO(),account);
			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3517 : [Publish]<br>
	 * PUBLISH Inland Rate <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse publishInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3517Event event = (EsmPri3517Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try{
			begin();
			command.publishInlandRates(event.getPriTrfInlndVO(),account);			
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Publish"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3521 : [Amend]<br>
	 * AMENDing Inland Rate  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse amendInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3521Event event = (EsmPri3521Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try{
			begin();
			command.amendInlandRates(event.getPriTrfInlndVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
		
	/**
	 * ESM_PRI_3507 : [Request]<br>
	 * [REQUEST] [Inland Rate]<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try{
			begin();

			String sValue = command.searchInlandRatesExistCheck(event.getPriTrfInlndVO());			
			// handling exception : current Amend Seq. doesn't exist 
			if(sValue == null) {
					throw new EventException(new ErrorHandler("PRI01135",new String[]{"Inland Rates"}).getMessage());
			}
			
			command.requestInlandRates(event.getPriTrfInlndVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Request"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3507 : [Approve]<br>
	 * approve [Inland Rate ] <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approveInlandRates(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try{
			begin();

			String sValue = command.searchInlandRatesExistCheck(event.getPriTrfInlndVO());			
			// handling exception : current Amend Seq. doesn't exist 
			if(sValue == null) {
					throw new EventException(new ErrorHandler("PRI01135",new String[]{"Inland Rates"}).getMessage());
			}
			
			command.approveInlandRates(event.getPriTrfInlndVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Approve"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
		
	/**
	 * ESM_PRI_3514 : [Save]<br>
	 * uploading [Inland Rate file] <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInlandRatesFile (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3514Event event = (EsmPri3514Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();
		try{
			begin();
			List<String> keys = event.getKeys();			
			command.manageInlandRatesFile (event.getPriTrfInlndVO(), keys, account);	
			
           eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_3509 : [Retrieve]<br>
	 * retrieving [Tariff Rule Amend History ] <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleAmendHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3509Event event = (EsmPri3509Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try{
			List<RsltPriTrfRuleVO> list = command.searchTariffRuleAmendHistoryList(event.getPriTrfRuleHistoryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_3514 : [Retrieve]<br>
	 * retrieving [Tariff Rule History ] <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3509Event event = (EsmPri3509Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();

		try{
			List<RsltPriTrfRuleVO> list = command.searchTariffRuleHistoryList(event.getPriTrfRuleHistoryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3502 : [Retrieve] <br>
	 * retrieving [Tariff Scope] <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3502Event event = (EsmPri3502Event)e;
		TariffCodeBC command = new TariffCodeBCImpl();
		
		try{
			List<RsltSvcScpCdVO> list = command.searchTariffCode(event.getRsltSvcScpCdVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3502 : Tariff Code Focus out <br>
	 * retrieving [Tariff Name] <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3502Event event = (EsmPri3502Event)e;
		PRICommonBC command = new PRICommonBCImpl();
		TariffCodeBC command2 = new TariffCodeBCImpl();
		try{           
			List<PriTariffVO> list = command.searchTariffCodeName(event.getPriTariffVO());
			List<PriTariffVO> list2 = command2.searchInlandRates(event.getPriTariffVO());

			if(list.size() > 0){
				eventResponse.setETCData("trf_nm",list.get(0).getTrfNm()); 
	        	eventResponse.setETCData("cre_flg","N"); 
	        	eventResponse.setETCData("trf_inlnd_flg",list2.get(0).getTrfInlndFlg()); 
			}
		}
		catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3502 : [OPEN]
	 * retrieving [Combo Data] <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffCodeCreationComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		
		RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
        
		try {
			list = command.searchServiceScopeCodeList(vo);
			eventResponse.setCustomData("scopeList", list);		
		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	} 	
	
	/**
	 * ESM_PRI_3502 : [SAVE] <br>
	 * creating Tariff Name , adding and deleting Tariff Scope  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException    
	 */
	private EventResponse manageTariffCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3502Event event = (EsmPri3502Event)e;
		TariffCodeBC command = new TariffCodeBCImpl();
		try{
			
			List<SearchTariffScopeDupVO> checkList = command.searchTariffScopeDuplicate(event.getRsltSvcScpCdVOs());
			
			if(checkList.size() != 0){
				StringBuffer dup = new StringBuffer() ;
				 for(int i = 0 ; i < checkList.size() ; i++ ){
					 if(i!=0){
						 dup.append(",");
					 }
					 dup.append(checkList.get(i).getSvcScpCd());
				 }
				 throw new EventException(new ErrorHandler("PRI06010",new String[]{dup.toString()}).getMessage());

			}  
			
			begin();
			command.manageTariffCode(event.getInPriTariffVO(),event.getRsltSvcScpCdVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		}
		catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
	        throw ex;
	    }catch(Exception ex){
	    	rollback();
	    	log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3502 : DELETE <br>
	 * deleting Tariff  
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse removeTariffCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3502Event event = (EsmPri3502Event)e;
		TariffCodeBC command = new TariffCodeBCImpl();
			
		try{   			
			SearchTariffCodeUsedVO usedVO = command.searchTariffCodeUsed(event.getPriTariffVO());

			if(!usedVO.getUsedFlg().equals("0")){
				 throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage());
			}
			begin();
			command.removeTariffCode(event.getPriTariffVO());
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00102",new String[]{}).getUserMessage());
			commit();
		}
		catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3501 : Open<br>
	 * retrieving Combo Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffGeneralInformationComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try{
			
        	//TARIFF CODE
        	list = command.searchTariffCodeList(vo);
            eventResponse.setCustomData("TARIFF_CD", list);
            
            //Approval Office
            list = command.searchApprovalOfficeList(vo);
            eventResponse.setCustomData("APRO_OFC_CD", list);
            
            //Tariff Type
            vo.setCd("CD02761");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_BZC_TP_CD", list);

            //Weight Ton Unit
            vo.setCd("CD02764");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_BZC_WGT_UT_CD", list);

            //Volume Ton Unit
            vo.setCd("CD02762");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_BZC_VOL_UT_CD", list);
            
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//SOURCE
            vo.setCd("CD02064");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);
            
//			//STATUS
//            vo.setCd("CD02395");
//            list = command.searchComCodeDescList(vo);
//            eventResponse.setCustomData("TRF_BZC_STS_CD", list);
            
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3501 : Retrieve<br>
	 * retrieving Tariff Code's General Information <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try{
			RsltPriTrfBzcListVO vo = command.searchTariffGeneralInformation(event.getPriTrfBzcVO(), account);
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs2());
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3501 : [Save]<br>
	 * saving Tariff Code's General Information <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try{
			PriTrfBzcVO priTrfBzcVO = event.getTrfBzcMnVO().getPriTrfBzcVO();
			int cnt1 = command.searchTariffCodeExistCheck(priTrfBzcVO);
			int cnt2 = command.searchTariffBasicExistCheck(priTrfBzcVO);
			
			if(priTrfBzcVO != null){

				if(cnt1 == 0)
					throw new EventException(new ErrorHandler("PRI06003",new String[]{}).getMessage());

				if(("I".equals(priTrfBzcVO.getIbflag()) && cnt2 > 0))
					throw new EventException(new ErrorHandler("PRI01135",new String[]{"Tariff General Information"}).getMessage());

				if(!"I".equals(priTrfBzcVO.getIbflag()) && cnt2 == 0)
								throw new EventException(new ErrorHandler("PRI01135",new String[]{"Tariff General Information"}).getMessage());
			}
			
			begin();
			command.manageTariffGeneralInformation(event.getTrfBzcMnVO(),account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3501 : [Delete]<br>
	 * deleting Tariff Code's General Information <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try{
			PriTrfBzcVO priTrfBzcVO = event.getPriTrfBzcVO();
			int cnt = command.searchTariffBasicExistCheck(priTrfBzcVO);

				if(cnt == 0)
					throw new EventException(new ErrorHandler("PRI01135",new String[]{"Tariff General Information"}).getMessage());
			
			begin();
			command.removeTariffGeneralInformation(event.getPriTrfBzcVO());
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00102",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3501 : [Request]<br>
	 * Request Tariff Code's General Information <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try{
			PriTrfBzcVO priTrfBzcVO = event.getTrfBzcMnVO().getPriTrfBzcVO();
			int cnt = command.searchTariffBasicExistCheck(priTrfBzcVO);
			
			// handling Exception : 4. request in case of deleted Basic data
				if(cnt == 0)
					throw new EventException(new ErrorHandler("PRI01135",new String[]{"Tariff General Information"}).getMessage());
			
			begin();
			command.requestTariffGeneralInformation(event.getTrfBzcMnVO(),account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Request"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3501 : [Approve]<br>
	 * Approve : Tariff Code's General Information <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approveTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try{
			begin();
			command.approveTariffGeneralInformation(event.getTrfBzcMnVO(),account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Approve"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3501 : [Cancel]<br>
	 * Cancel : Tariff Code's General Information <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3501Event event = (EsmPri3501Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try{
			PriTrfBzcVO priTrfBzcVO = event.getTrfBzcMnVO().getPriTrfBzcVO();
			int cnt = command.searchTariffBasicExistCheck(priTrfBzcVO);
			
			// handling Exception : 5.canceling deleted Basic data
				if(cnt == 0)
					throw new EventException(new ErrorHandler("PRI01135",new String[]{"Tariff General Information"}).getMessage());
			
			begin();
			command.cancelTariffGeneralInformation(event.getTrfBzcMnVO(),account);
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Cancel"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3518 : [event]<br>
	 * Amend : Tariff Code's General Information <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse amendTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3518Event event = (EsmPri3518Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try{
			begin();
			command.amendTariffGeneralInformation(event.getTrfBzcMnVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3503 : [Retrieve] <br>
	 * retrieving [Tariff Code] <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3503Event event = (EsmPri3503Event)e;
		TariffCodeBC command = new TariffCodeBCImpl();
		
		try{			
			List<SearchTariffCodeALLVO> list = command.searchTariffCodeList(event.getSearchTariffCodeALLVO());			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	

	/**
	 * ESM_PRI_3503 : [OPEN]<br>
	 * retrieving combo data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffCodeComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TariffRuleBC command = new TariffRuleBCImpl();
		
		RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
        
		try {
			list = command.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);	

		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	} 
	

	/**
	 * ESM_PRI_3505 : [Publish]<br>
	 * Publish : Tariff Code's General Information <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse publishTariffGeneralInformation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3505Event event = (EsmPri3505Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		try{
			begin();
			command.publishTariffGeneralInformation(event.getTrfBzcMnVO(),account);			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00341",new String[]{"Publish"}).getUserMessage());
			commit();
		} catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3511 : Open<br>
	 * retrieving Combo Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffGeneralInformationInquiryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try{
			
        	//TARIFF CODE
        	list = command.searchTariffCodeList(vo);
            eventResponse.setCustomData("TARIFF_CD", list);
			//STATUS
            vo.setCd("CD02395");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_BZC_STS_CD", list);
            
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3511 : Retrieve<br>
	 * retrieving Tariff General Information List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralInformationInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3511Event event = (EsmPri3511Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try{
			List<RsltPriTrfBzcVO> vo = command.searchTariffGeneralInformationInquiryList(event.getPriTrfBzcVO());
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3511 : Sheet Double Click<br>
	 * retrieving Tariff General Information Detail <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralInformationInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3511Event event = (EsmPri3511Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try{
			RsltPriTrfBzcListVO vo = command.searchTariffGeneralInformationInquiry(event.getPriTrfBzcVO());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs2());
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3515 : Open<br>
	 * retrieving Combo Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initInlandRatesInquiryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		InlandRatesBC command2 = new InlandRatesBCImpl();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
        
		try{
			
        	//TARIFF CODE
        	list = command2.searchTariffCodeList(vo);
            eventResponse.setCustomData("TARIFF_CD", list);
			//STATUS
            vo.setCd("CD02395");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_INLND_STS_CD", list);
            //Amend Type
            vo.setCd("CD02760");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_INLND_AMDT_TP_CD", list);
            
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3515 : Retrieve<br>
	 * retrieving Inland Rate List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3515Event event = (EsmPri3515Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try{
			List<RsltPriTrfInlndVO> vo = command.searchInlandRatesInquiryList(event.getPriTrfInlndVO());
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3515 : Sheet Click<br>
	 * retrieving Inland Rate Detail <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3515Event event = (EsmPri3515Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try{
			List<RsltPriTrfInlndRtVO> vo = command.searchInlandRatesInquiry(event.getPriTrfInlndRtVO());
			eventResponse.setRsVoList(vo);

		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3504 : [OPEN]<br>
	 * retrieving combo data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initTariffGeneralHistoryComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TariffRuleBC command = new TariffRuleBCImpl();
		
		RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
        
		try {
			list = command.searchTariffCodeList(vo);
			eventResponse.setCustomData("TARIFF_CD", list);	

		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3504 : [Retrieve] <br>
	 * retrieving [Tariff General Information History] <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3504Event event = (EsmPri3504Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		
		try{
			List<PriTrfBzcHistoryVO> list = command.searchTariffGeneralHistoryList(event.getPriTrfBzcHistoryVO());			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_3504 : sheet1 double click <br>
	 * retrieving [Tariff General Information Amend History] <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralAmendHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3504Event event = (EsmPri3504Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();
		
		try{			
			List<PriTrfBzcHistoryAmendVO> list = command.searchTariffGeneralAmendHistoryList(event.getPriTrfBzcHistoryAmendVO());			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3504 : sheet2 double click <br>
	 * retrieving [Tariff General Information Amend History Detail] <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffGeneralHistory(Event e) throws EventException {
		 //PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3504Event event = (EsmPri3504Event)e;
		TariffGeneralInformationBC command = new TariffGeneralInformationBCImpl();

		try{
			RsltPriTrfBzcListVO vo = command.searchTariffGeneralHistory(event.getPriTrfBzcVO());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs());
			eventResponse.setRsVoList(vo.getRsltPriTrfBzcRoutPntVOs2());
			
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3516 : Open<br>
	 * retrieving Combo Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initInlandRatesHistoryComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PRICommonBC command = new PRICommonBCImpl();
		InlandRatesBC command2 = new InlandRatesBCImpl();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

		try{
			
        	//TARIFF CODE
        	list = command2.searchTariffCodeList(vo);
            eventResponse.setCustomData("TARIFF_CD", list);
			//STATUS
            vo.setCd("CD02395");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_INLND_STS_CD", list);
            //Amend Type
            vo.setCd("CD02760");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("TRF_INLND_AMDT_TP_CD", list);
            
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3516 : Retrieve<br>
	 * retrieving Inland Rates Name <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3516Event event = (EsmPri3516Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try{
			List<RsltPriTrfInlndVO> vo = command.searchInlandRatesHistoryList(event.getPriTrfInlndHistoryVO());
			eventResponse.setRsVoList(vo);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3516 : Sheet1 Click<br>
	 * retrieving Inland Rates Amend  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesAmendHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3516Event event = (EsmPri3516Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try{
			List<RsltPriTrfInlndVO> vo = command.searchInlandRatesAmendHistoryList(event.getPriTrfInlndHistoryVO());
			eventResponse.setRsVoList(vo);

		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_3516 : Sheet2 Click<br>
	 * retrieving Inland Rates Location <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandRatesHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3516Event event = (EsmPri3516Event)e;
		InlandRatesBC command = new InlandRatesBCImpl();

		try{
			List<RsltPriTrfInlndRtVO> vo = command.searchInlandRatesHistory(event.getPriTrfInlndHistoryVO());
			eventResponse.setRsVoList(vo);

		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
	
	
	/**
	 * ESM_PRI_3599 : Retrieve <br>
	 * Tariff Rule Diff
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse searchTariffRuleDiff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri3599Event event = (EsmPri3599Event)e;
		TariffRuleBC command = new TariffRuleBCImpl();
		
		try{			 
			DiffList list = command.searchTariffRuleDiff(event.getInPriTrfRuleDiffVO());			
			eventResponse.setCustomData("DIFF_LIST", list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
	    }	
		return eventResponse;
	}
}
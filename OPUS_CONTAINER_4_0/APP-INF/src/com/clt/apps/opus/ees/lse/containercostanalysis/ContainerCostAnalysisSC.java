/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerCostAnalysisSC.java
*@FileTitle : On off Hire Audit
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containercostanalysis;

import java.util.List;


import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.basic.OnOffHireAuditBC;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.basic.OnOffHireAuditBCImpl;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.event.EesLse0055Event;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.event.EesLse0056Event;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.integration.OnOffHireAuditDBDAO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditDetailVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditGroupVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.vo.OnOffHireAuditSearchVO;
import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.basic.PayableEstimateAuditBC;
import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.basic.PayableEstimateAuditBCImpl;
import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.event.EesLse0018Event;
import com.clt.apps.opus.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ContainerCostAnalysis Business Logic ServiceCommand - handling business transaction ContainerCostAnalysis
 *
 * @author
 * @see OnOffHireAuditDBDAO
 * @since J2EE 1.6
 */

public class ContainerCostAnalysisSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario ContainerCostAnalysis system <br>
	 * related objects creation EES_LSE_0055<br>
	 */
	@Override
	public void doStart() {
		log.debug("ContainerCostAnalysisSC start");
		try {

			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing ContainerCostAnalysis system <br>
	 * clearing related objects EES_LSE_0055<br>
	 */
	@Override
	public void doEnd() {
		log.debug("ContainerCostAnalysisSC end");
	}

	/**
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EesLse0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuditResultOnOffHirelistService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAuditResultOnOffHireVersionlistService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAuditResultOnOffHireService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createOnOffHireListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0056Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = movecopyLessorOnlyListService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = createLessorOnlyListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPayableEstimateAuditService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = calculationPayableEstimateAuditService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = savePayableEstimateAuditService (e);
			}
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0055 : <br>
	 * retrieving for audi result onoff hire <br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAuditResultOnOffHirelistService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0055Event event = (EesLse0055Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();

		try{
			OnOffHireAuditGroupVO resultVO = command.searchAuditResultOnOffHirelistBasic (event.getOnOffHireAuditSearchVO());
			List<List<OnOffHireAuditSearchVO>> lists = resultVO.getOnOffHireAuditSearchVOs();

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
	 * EES_LSE_0056 : <br>
	 * verifying LSE_CTRT_NO<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse movecopyLessorOnlyListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0056Event event = (EesLse0056Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();

		try{
			List<OnOffHireAuditSearchVO> list = command.verifyImportOnOffHireListBasic(event.getOnOffHireAuditSearchVO() );
			eventResponse.setRsVoList(list);
			if(list.size() > 0){
				eventResponse.setETCData("contract_no" , "T");
			}else{
				eventResponse.setETCData("contract_no" , "F");
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0055 : <br>
	 * creating excel import data<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createLessorOnlyListService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0056Event event = (EesLse0056Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();

		try{
			begin();
			String audSeq = command.createImportOnOffHireListBasic(event.getOnOffHireAuditSearchVOS() , account);
			eventResponse.setETCData("aud_ver_seq" , audSeq);
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
	 * EES_LSE_0055 : <br>
	 * retrieving for Audit version list
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAuditResultOnOffHireVersionlistService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0055Event event = (EesLse0055Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();
		try{
			List<OnOffHireAuditSearchVO> list = command.searchAuditResultOnOffHireVersionlistBasic(event.getOnOffHireAuditSearchVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0055 : <br>
	 * retrieving for Audit Result 
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAuditResultOnOffHireService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0055Event event = (EesLse0055Event)e;
		OnOffHireAuditBC command = new OnOffHireAuditBCImpl();

		try{
			OnOffHireAuditGroupVO resultVO = command.searchAuditResultOnOffHireBasic(event.getOnOffHireAuditDetailVO());
			List<List<OnOffHireAuditDetailVO>> lists = resultVO.getOnOffHireAuditDetailVOs();

			eventResponse.setRsVoList(lists.get(0));
			eventResponse.setRsVoList(lists.get(1));
			eventResponse.setRsVoList(lists.get(2));
			eventResponse.setRsVoList(lists.get(3));


		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_LSE_0055 : <br>
	 * saving On/Off-Hire Audit result<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createOnOffHireListService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0055Event event = (EesLse0055Event)e;
		OnOffHireAuditBCImpl command = new OnOffHireAuditBCImpl();
		OnOffHireAuditDetailVO onOffHireAuditDetailVO = new OnOffHireAuditDetailVO();
		try{
			begin();
			onOffHireAuditDetailVO.setVndrSeq(event.getVndrSeq());
			onOffHireAuditDetailVO.setAudVerSeq(event.getAudVerSeq());
			onOffHireAuditDetailVO.setBilFmDt(event.getSearchStdt());
			onOffHireAuditDetailVO.setBilToDt(event.getSearchEndt());
			onOffHireAuditDetailVO.setAuditType(event.getAuditType());
			String audVerSeq = command.createOnOffHireListBasic( onOffHireAuditDetailVO , event.getOnOffHireAuditDetailVOS() , account);
			eventResponse.setETCData("aud_ver_seq" , audVerSeq);
			commit();
			//eventResponse.setUserMessage(new ErrorHandler("LSE10001").getMessage());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * UI_LSE_0018 : Retrieve<br>
	 * retrieving for payable estimate audit<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPayableEstimateAuditService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0018Event event = (EesLse0018Event)e;
			PayableEstimateAuditBC command = new PayableEstimateAuditBCImpl();
			List<EstimatedAuditVO> list = command.searchPayableEstimateAuditBasic (event.getEstimatedAuditVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_LSE_0018 : Calculation<br>
	 * calculation payalbe estivate audit<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse calculationPayableEstimateAuditService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0018Event event = (EesLse0018Event)e;
			PayableEstimateAuditBC command = new PayableEstimateAuditBCImpl();
			List<EstimatedAuditVO> list = command.calculationPayableEstimateAuditBasic (event.getEstimatedAuditVO());

			if ( list.size() > 0 ) {
				for ( int i = 0 ; i < list.size(); i++ ) {
					(list.get(i)).setCreUsrId(account.getUsr_id());
					(list.get(i)).setUpdUsrId(account.getUsr_id());
				}

				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_LSE_0018 : Save<br>
	 * saving payable estimate audit<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse savePayableEstimateAuditService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0018Event event = (EesLse0018Event)e;
		PayableEstimateAuditBC command = new PayableEstimateAuditBCImpl();

		try{
			begin();
			command.savePayableEstimateAuditBasic(event.getEstimatedAuditVOS() , event.getYearMonth() , account);
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
}
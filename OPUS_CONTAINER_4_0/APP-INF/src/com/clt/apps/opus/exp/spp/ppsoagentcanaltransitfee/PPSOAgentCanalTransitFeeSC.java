/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PPSOAgentCanalTransitFeeSC.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee;

import java.util.List;

import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.basic.AgentCanalTransitFeeBC;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.basic.AgentCanalTransitFeeBCImpl;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0001Event;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0002Event;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0003Event;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0004Event;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0005Event;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0006Event;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration.AgentCanalTransitFeeBCDBDAO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTransitScheduleVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzAllowanceTEUVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzBkgVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeInvDtlByVvdVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeSumVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzInvAllowanceTEUVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzVVDListVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaBalVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaDisbVO;
import com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaRemVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PsoCnlTzFeeDtlVO;
import com.clt.syscommon.common.table.PsoCnlTzFeeVO;


/**
 * Handling the business transaction of ALPS-PPSOAgentCanalTransitFee Business Logic ServiceCommand - ALPS-PPSOAgentCanalTransitFee
 * 
 * @author 
 * @see AgentCanalTransitFeeBCDBDAO
 * @since J2EE 1.6
 */

public class PPSOAgentCanalTransitFeeSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Preceding the business scenario of PPSOAgentCanalTransitFee system<br>
	 * Creating the related objects<br>
	 */
	public void doStart() {
		log.debug("Start of PPSOAgentCanalTransitFeeSC");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Closing the business scenario of PPSOAgentCanalTransitFee system<br>
	 * Clearing the related objects<br>
	 */
	public void doEnd() {
		log.debug("End of PPSOAgentCanalTransitFeeSC");
	}

	/**
	 * Calling the method by the event name and the form command<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if(e.getEventName().equalsIgnoreCase("ExpSpp0001Event")){//EXP_SPP_0001 Canal Invoce UI
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//when Retreive button click
				eventResponse = searchCanalTzFeeSumRpt(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//when transit date insert 
				eventResponse = searchCanalTzVVDList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("ExpSpp0002Event")){//EXP_SPP_0002 Requested Advance Payment
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//when open
				eventResponse = searchCanalTzFeeEstDtlByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//when save
				eventResponse = manageCanalTzFeeByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//when request
				eventResponse = manageCanalTzFeeByVvd(e);
			}			
		} else if(e.getEventName().equalsIgnoreCase("ExpSpp0003Event")){//EXP_SPP_0003 Request Actual Invoice
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//when open
				eventResponse = searchCanalTzFeeInvDtlByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//when save
				eventResponse = manageCanalTzFeeByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//when request
				eventResponse = manageCanalTzFeeByVvd(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("ExpSpp0004Event")) {//EXP_SPP_0004 Requested MSA
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  //when open(MSA Balance)
				eventResponse = searchMsaBal(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//when save
				eventResponse = manageMsaBal(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//when request
				eventResponse = manageMsaBal(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {  //when tab2 click(MSA Remittance)
				eventResponse = searchMsaRem(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {  //when tab3 click(MSA Disbursement)
				eventResponse = searchMsaDisb(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("ExpSpp0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve Button Click    
				eventResponse = searchCanalTzBkgVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//when save
				eventResponse = manageCanalTzBkgList(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("ExpSpp0006Event")) {	//EXP_SPP_0006 Canal Transit Schedule
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve Button Click 처리   
				eventResponse = searchCanalTransitScheduleList(e);
			}
		}
		
		return eventResponse;
	}
	
	
	/**
	 * Retrieving the list of Canal Transit<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCanalTzFeeSumRpt(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ExpSpp0001Event event = (ExpSpp0001Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			List<CanalTzFeeSumVO> list = command.searchCanalTzFeeSumRpt(event.getCanalTzFeeSumVO());
			
			if( list.size() == 1){
				list = null;
			}
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Retrieving the list of Canal Transit VVD<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCanalTzVVDList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ExpSpp0001Event event = (ExpSpp0001Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			
			List<CanalTzVVDListVO> list = command.searchCanalTzVVDList(event.getCanalTzVVDListVO());
			StringBuilder data = new StringBuilder();
			StringBuilder data1 = new StringBuilder();
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
			
					data.append(list.get(i).getVslNm()+"\t"+list.get(i).getSkdVoyNo()+"\t"+list.get(i).getSkdDirCd()+"\t"+list.get(i).getLane());
					data.append(",");
					data.append(list.get(i).getVslCd()+list.get(i).getSkdVoyNo()+list.get(i).getSkdDirCd());
					data1.append(list.get(i).getTrnsDt()+","+list.get(i).getPyDueDt()+","+list.get(i).getAdvPySts());
					data1.append(","+list.get(i).getAdvPyRevMon()+","+list.get(i).getYdCd()+","+list.get(i).getEseq()+","+list.get(i).getIseq());
					if (i < list.size() - 1){
						data.append("|");
						data1.append("|");
					}
				}
			}
			
			eventResponse.setETCData("vvd", data.toString());	
			eventResponse.setETCData("vvd_etc", data1.toString());	
			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieving the Advance Payment by VVD<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCanalTzFeeEstDtlByVvd(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0002Event event = (ExpSpp0002Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			
			List<CanalTzFeeEstDtlByVvdVO> list = command.searchCanalTzFeeEstDtlByVvd(event.getCanalTzFeeEstDtlByVvdCondVO());
			eventResponse.setRsVoList(list);
			
			//Retrieving Allowance TEU
			String strRslt = "";
			CanalTzAllowanceTEUVO canalTzAllowanceTEUVO = command.searchCanalTzAllowanceTEU(event.getCanalTzFeeEstDtlByVvdCondVO());
			if(canalTzAllowanceTEUVO!=null){
				strRslt = canalTzAllowanceTEUVO.getRevYrmon()+","
						+canalTzAllowanceTEUVO.getTtlAmt()+","
						+canalTzAllowanceTEUVO.getSuzNetTongWgt()+","
						+canalTzAllowanceTEUVO.getLoclXchRt()+","
						+canalTzAllowanceTEUVO.getTrVolVal()+","
						+canalTzAllowanceTEUVO.getCnlTzProcStsCd()+","
						+canalTzAllowanceTEUVO.getCntrPnmCapa();
			}else{
				strRslt	= ",,,,,,";
			}
			eventResponse.setETCData("cntr_pnm_capa", strRslt);	
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Requesting and saving advance payment and Invoice<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageCanalTzFeeByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PsoCnlTzFeeVO 		psoCnlTzFeeVO = null;
		PsoCnlTzFeeDtlVO[] 	psoCnlTzFeeDtlVOs = null; 
		
		if(e.getEventName().equalsIgnoreCase("ExpSpp0002Event")){
			ExpSpp0002Event event = (ExpSpp0002Event)e;
			psoCnlTzFeeVO = event.getPsoCnlTzFeeVO();
			psoCnlTzFeeDtlVOs = event.getPsoCnlTzFeeDtlVOS();
		}else{
			ExpSpp0003Event event = (ExpSpp0003Event)e;
			psoCnlTzFeeVO = event.getPsoCnlTzFeeVO();
			psoCnlTzFeeDtlVOs = event.getPsoCnlTzFeeDtlVOS();			
		}
		
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			begin();
			command.manageCanalTzFeeByVvd(psoCnlTzFeeVO, psoCnlTzFeeDtlVOs, account);
			commit();	
			if(psoCnlTzFeeVO.getCnlTzProcStsCd().equals("R")){
				eventResponse.setUserMessage(new ErrorHandler("SPP00002").getUserMessage());  //Data saved successfully.
			}else if(psoCnlTzFeeVO.getCnlTzProcStsCd().equals("Q")){
				eventResponse.setUserMessage(new ErrorHandler("SPP00001").getUserMessage());  //Data requested successfully.
			}
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
	 * Retrieving the Invoice by VVD<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCanalTzFeeInvDtlByVvd(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0003Event event = (ExpSpp0003Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			
			List<CanalTzFeeInvDtlByVvdVO> list = command.searchCanalTzFeeInvDtlByVvd(event.getCanalTzFeeEstDtlByVvdCondVO());
			eventResponse.setRsVoList(list);
			
			//Retrieving Allowance TEU
			String strRslt = "";
			CanalTzInvAllowanceTEUVO canalTzInvAllowanceTEUVO = command.searchCanalTzInvAllowanceTEU(event.getCanalTzFeeEstDtlByVvdCondVO());
			if(canalTzInvAllowanceTEUVO!=null){
				strRslt = canalTzInvAllowanceTEUVO.getRevYrmon()+","
						+canalTzInvAllowanceTEUVO.getTtlAmt()+","
						+canalTzInvAllowanceTEUVO.getSuzNetTongWgt()+","
						+canalTzInvAllowanceTEUVO.getLoclXchRt()+","
						+canalTzInvAllowanceTEUVO.getTrVolVal()+","
						+canalTzInvAllowanceTEUVO.getCnlTzProcStsCd()+","
						+canalTzInvAllowanceTEUVO.getCntrPnmCapa()+","
						+canalTzInvAllowanceTEUVO.getScgRtAmt();
			}else{
				strRslt	= ",,,,,,,";
			}
			eventResponse.setETCData("cntr_pnm_capa", strRslt);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * Retrieving MSA<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMsaBal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0004Event event = (ExpSpp0004Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			List<MsaBalVO> list = command.searchMsaBal(event.getMsaBalVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Requesting and saving MSA<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageMsaBal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0004Event event = (ExpSpp0004Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			begin();
			command.manageMsaBal(event.getPsoMsaVO(), event.getMsaBalVOS(), account);
			commit();	
			if(event.getPsoMsaVO().getPsoMsaStsCd().equals("R")){
				eventResponse.setUserMessage(new ErrorHandler("SPP00002").getUserMessage());  //Data saved successfully.
			}else if(event.getPsoMsaVO().getPsoMsaStsCd().equals("Q")){
				eventResponse.setUserMessage(new ErrorHandler("SPP00001").getUserMessage());  //Data requested successfully.
			}
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
	 * Retrieving MSA remittance<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMsaRem(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0004Event event = (ExpSpp0004Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			List<MsaRemVO> list = command.searchMsaRem(event.getMsaRemVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Retrieving MSA disbursement <br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMsaDisb(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0004Event event = (ExpSpp0004Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			List<MsaDisbVO> list = command.searchMsaDisb(event.getMsaDisbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Retrieving Canal Booking<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCanalTzBkgVvd(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ExpSpp0005Event event = (ExpSpp0005Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			List<CanalTzBkgVvdVO> list = command.searchCanalTzBkgVvd(event.getCanalTzBkgVvdVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Saving the data of Canal Booking<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageCanalTzBkgList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0005Event event = (ExpSpp0005Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			begin();
			command.manageCanalTzBkgList(event.getCanalTzBkgVvdVOS(), account);
			commit();			
			eventResponse.setUserMessage(new ErrorHandler("COM12191",new String[]{"Data"}).getUserMessage());  //Data saved successfully.
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
	 * EXP_SPP_0006 : Canal Transit Schedule List조회 이벤트 처리<br>
	 * Canal Transit Schedule List조회<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchCanalTransitScheduleList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ExpSpp0006Event event = (ExpSpp0006Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		try{
			List<CanalTransitScheduleVO> list = command.searchCanalTransitSchedule(event.getCanalTransitScheduleVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
}
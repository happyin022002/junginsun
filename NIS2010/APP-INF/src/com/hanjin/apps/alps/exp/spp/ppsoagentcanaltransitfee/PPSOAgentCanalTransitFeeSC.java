/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PPSOAgentCanalTransitFeeSC.java
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.07.15 김성광
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee;

import java.util.List;

import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.basic.AgentCanalTransitFeeBC;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.basic.AgentCanalTransitFeeBCImpl;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0001Event;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0002Event;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0003Event;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0004Event;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0005Event;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0006Event;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration.AgentCanalTransitFeeBCDBDAO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTransitScheduleVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzAllowanceTEUVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzBkgVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeEstDtlByVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeInvDtlByVvdVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzFeeSumVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzInvAllowanceTEUVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.CanalTzVVDListVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaBalVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaDisbVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.MsaRemVO;
import com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo.PsoCanalInvAttachFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoCnlTzAtchFileVO;
import com.hanjin.syscommon.common.table.PsoCnlTzFeeDtlVO;
import com.hanjin.syscommon.common.table.PsoCnlTzFeeVO;


/**
 * ALPS-PPSOAgentCanalTransitFee Business Logic ServiceCommand - ALPS-PPSOAgentCanalTransitFee 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Seong Kwang
 * @see AgentCanalTransitFeeBCDBDAO
 * @since J2EE 1.4
 */

public class PPSOAgentCanalTransitFeeSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * PPSOAgentCanalTransitFee system 업무 시나리오 선행작업<br>
	 * EXP_SPP_0001 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("PPSOAgentCanalTransitFeeSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * PPSOAgentCanalTransitFee system 업무 시나리오 마감작업<br>
	 * EXP_SPP_0001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("PPSOAgentCanalTransitFeeSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-PPSOAgentCanalTransitFee system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if(e.getEventName().equalsIgnoreCase("ExpSpp0001Event")){//EXP_SPP_0001 Canal Invoce UI
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//when Retreive button click
				eventResponse = searchCanalTzFeeSumRpt(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {//when transit date insert 
				eventResponse = searchCanalTzVVDList(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("ExpSpp0002Event")){//EXP_SPP_0002 Requested Advance Payment
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//when open
				eventResponse = searchCanalTzFeeEstDtlByVvd(e);
			}
			
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//when save
				eventResponse = manageCanalTzFeeByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//when request
				eventResponse = manageCanalTzFeeByVvd(e);
			}			
		}
		else if(e.getEventName().equalsIgnoreCase("ExpSpp0003Event")){//EXP_SPP_0003 Request Actual Invoice
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//when open
				eventResponse = searchCanalTzFeeInvDtlByVvd(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//when open
				eventResponse = searchPsoCanalInvAttachFileList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//when save
				eventResponse = manageCanalTzFeeByVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {//when request
				eventResponse = manageCanalTzFeeByVvd(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("ExpSpp0004Event")) {//EXP_SPP_0004 Requested MSA
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
		}
		else if (e.getEventName().equalsIgnoreCase("ExpSpp0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve Button Click 처리   
				eventResponse = searchCanalTzBkgVvd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//when save
				eventResponse = manageCanalTzBkgList(e);
			}			
		}
		else if (e.getEventName().equalsIgnoreCase("ExpSpp0006Event")) {	//EXP_SPP_0006 Canal Transit Schedule
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Retrieve Button Click 처리   
				eventResponse = searchCanalTransitScheduleList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {//when save
				eventResponse = manageCanalTransitBookingList(e);
			}
		}
		return eventResponse;
	}
	
	
	/**
	 * EXP_SPP_0001 : 조회 이벤트 처리<br>
	 * Canal Transit List 조회<br>
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
			
			if(list != null){
				if( list.size() == 1){
					list = null;
				}
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
	 * EXP_SPP_0001 : VVD조회 이벤트 처리<br>
	 * Canal Transit List VVD조회<br>
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
	 * EXP_SPP_0002 : Advance Payment 조회 이벤트 처리<br>
	 * Advance Payment 조회<br>
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
			
			//Allowance TEU 조회
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
			//attach File 조회
			/*strRslt = "";
			List<PsoCanalInvAttachFileVO> list2 = command.searchPsoCanalInvAttachFileList(event.getCanalTzFeeEstDtlByVvdCondVO());
			for (int i = 0; i < list2.size(); i++) {
				PsoCanalInvAttachFileVO resultVo = list2.get(i);
				strRslt = strRslt + resultVo.getFileNm()+ (i == list2.size()-1 ? "":"\n");
			}
			eventResponse.setETCData("attach_file", strRslt);	
			eventResponse.setRsVoList(list2);
			*/
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	/**
	 * EXP_SPP_0003 : Canal Invoice Attach File List 조회 이벤트 처리<br>
	 * Advance Payment 조회<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPsoCanalInvAttachFileList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0003Event event = (ExpSpp0003Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			
			List<PsoCanalInvAttachFileVO> list = command.searchPsoCanalInvAttachFileList(event.getCanalTzFeeEstDtlByVvdCondVO());
			eventResponse.setRsVoList(list);
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EXP_SPP_0002, EXP_SPP_0003 : 전도금,Invoice  저장,요청 이벤트 처리<br>
	 * 전도금,Invoice 저장 요청<br>
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
		PsoCnlTzAtchFileVO[] psoCnlTzAtchFileVOs = null;
		
		
		
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			if(e.getEventName().equalsIgnoreCase("ExpSpp0002Event")){
				ExpSpp0002Event event = (ExpSpp0002Event)e;
				psoCnlTzFeeVO = event.getPsoCnlTzFeeVO();
				psoCnlTzFeeDtlVOs = event.getPsoCnlTzFeeDtlVOS();
				
			}else{
				ExpSpp0003Event event = (ExpSpp0003Event)e;
				psoCnlTzFeeVO = event.getPsoCnlTzFeeVO();
				psoCnlTzFeeDtlVOs = event.getPsoCnlTzFeeDtlVOS();
				if(event.getPsoCnlTzAtchFileVOS() != null){
					psoCnlTzAtchFileVOs = event.getPsoCnlTzAtchFileVOS();
				}
			}
			begin();
			command.manageCanalTzFeeByVvd(psoCnlTzFeeVO, psoCnlTzFeeDtlVOs, psoCnlTzAtchFileVOs, account);
			commit();	
			if(psoCnlTzFeeVO.getCnlTzProcStsCd().equals("R")){
				eventResponse.setUserMessage("Data was saved successfully.");
			}else if(psoCnlTzFeeVO.getCnlTzProcStsCd().equals("Q")){
				eventResponse.setUserMessage("Data was requested successfully.");
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
	 * EXP_SPP_0003 : Invoice 조회 이벤트 처리<br>
	 * Invoice 조회<br>
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
			
			//Allowance TEU 조회
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
	 * EXP_SPP_0004-1 : MSA 조회 이벤트 처리<br>
	 * MSA 조회<br>
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
	 * EXP_SPP_0004 : MSA 저장,요청 이벤트 처리<br>
	 * MSA 저장,요청<br>
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
				eventResponse.setUserMessage("Data was saved successfully.");
			}else if(event.getPsoMsaVO().getPsoMsaStsCd().equals("Q")){
				eventResponse.setUserMessage("Data was requested successfully.");
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
	 * EXP_SPP_0004-2 : MSA remittance 조회 이벤트 처리<br>
	 * MSA remittance 조회<br>
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
	 * EXP_SPP_0004-3 : MSA disbursement 조회 이벤트 처리<br>
	 * MSA disbursement 조회<br>
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
	 * EXP_SPP_0005 : Canal Booking 조회 이벤트 처리<br>
	 * Canal Booking 조회<br>
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
	 * EXP_SPP_0005 : Canal Booking 저장 이벤트 처리<br>
	 * Canal Booking 저장<br>
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
	
	/**
	 * EXP_SPP_0006 : Canal Booking 저장 이벤트 처리<br>
	 * Canal Booking 저장<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageCanalTransitBookingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExpSpp0006Event event = (ExpSpp0006Event)e;
		AgentCanalTransitFeeBC command = new AgentCanalTransitFeeBCImpl();
		
		try{
			begin();
			command.manageCanalTransitBookingList(event.getCanalTransitScheduleVOs(), account);
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
	
	
}
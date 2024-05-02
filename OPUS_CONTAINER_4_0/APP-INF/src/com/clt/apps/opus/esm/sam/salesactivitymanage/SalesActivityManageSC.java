/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesActivityManageSC.java
*@FileTitle : Sales Activity Management
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage;

import java.util.List;

import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.basic.SalesActivityManageBC;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.basic.SalesActivityManageBCImpl;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event.EsmSam0007Event;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event.EsmSam0008Event;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event.EsmSam0009Event;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event.EsmSam0901Event;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.integration.SalesActivityManageDBDAO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SRepInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInputVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamPFMCbyCustInputVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic.SalesAdminCommonBC;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic.SalesAdminCommonBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SamSlsActVO;



/**
 * ALPS-SalesActivityManage Business Logic ServiceCommand - ALPS-SalesActivityManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author LEEKUANSIAN
 * @see SalesActivityManageDBDAO
 * @since J2EE 1.6
 */
public class SalesActivityManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SalesActivityManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SalesActivityManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SalesActivityManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SalesActivityManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SalesActivityManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSam0901Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSalesActivityList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkSlsRepCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = checkCustCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = checkOfcTeamCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSam0009Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPFMCbyCustList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkSlsRepCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = checkCustCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSam0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSalesActivityList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSalesActivityInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkSlsRepCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = checkCustCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = checkOfcTeamCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchCustName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchSrepsManageCustList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmSam0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSalesReportInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCustSatisFaction(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCustCodeName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchSalesRepName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkSrepByActivity(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		
				eventResponse = manageSalesReportInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageCustSatisFaction(e);
			}
		}
		return eventResponse;
	}
	
	
	
	/**
	 * ESM_SAM_0008 : [이벤트]<br>
	 * [Sheet1]을 [조회]합니다.<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesReportInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0008Event event = (EsmSam0008Event)e;
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		
		try{
			List<SRepInfoVO> list = command.searchSalesReportInfo(event.getSRepInfoVO());
			//System.out.println("1111"+event.getSRepInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0008 : [이벤트]<br>
	 * [Sheet1]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSalesReportInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0008Event event = (EsmSam0008Event)e;
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		try{
			int iRtnCnt = 0;	
			
			for(int i=0; i<event.getSRepInfoVOS().length; i++){
		    	event.getSRepInfoVOS()[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
		    	event.getSRepInfoVOS()[i].setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
			}
			
			begin();			
			command.manageSalesReportInfo(event.getSRepInfoVOS(), account);		
			commit();	
	
			eventResponse.setETCData("modCnt", iRtnCnt+"");
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0008 : [이벤트]<br>
	 * [Sheet2]을 [조회]합니다.<br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustSatisFaction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0008Event event = (EsmSam0008Event)e;
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		
		try{
			List<SRepInfoVO> list = command.searchCustSatisFaction(event.getSRepInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0008 : [이벤트]<br>
	 * [Sheet2]을 [저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustSatisFaction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0008Event event = (EsmSam0008Event)e;
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		try{
			int iRtnCnt = 0;
			for(int i=0; i<event.getSRepInfoVOS().length; i++){
		    	event.getSRepInfoVOS()[i].setCreUsrId(event.getSignOnUserAccount().getUsr_id());
			}
			
			begin();
			command.manageCustSatisFaction(event.getSRepInfoVOS(), account);
			commit();
			
			eventResponse.setETCData("modCnt", iRtnCnt+"");
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0008 : CUST_CD onChange<br>
	 * CUST_CD를 확인하고 Customer name을 호출합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCustCodeName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String custCdNm = null;
		
		try{
			if(e instanceof EsmSam0008Event){
				SRepInfoVO sRepInfoVO = ((EsmSam0008Event)e).getSRepInfoVO();
				custCdNm = sRepInfoVO.getCustCd();
			}
			
			if(custCdNm != null) {
				String result = command.checkCustCodeName(custCdNm);
				String result_cd = command.checkCustCodeName(custCdNm);
				
				if(!"".equals(result)) {
					String ret[] = result.split("@@@");
					
					if(e instanceof EsmSam0008Event){
						result = ret[1];
						result_cd = ret[0];
					}
				}
				eventResponse.setETCData("result", result);
				eventResponse.setETCData("result_cd", result_cd);
			}

		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	
	/**
	 * ESM_SAM_0901 : Retrieve<br>
	 * ESM_SAM_0007 : Retrieve<br>
	 * Activity No 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesActivityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		SamActivityInputVO samAct = null;
		
		if(e instanceof EsmSam0901Event){
			EsmSam0901Event event = (EsmSam0901Event)e;
			samAct = event.getSamActivityInputVO();
		}else if(e instanceof EsmSam0007Event){
			EsmSam0007Event event = (EsmSam0007Event)e;
			samAct = event.getSamActivityInputVO();
		}
		if(samAct != null) {
			try{
				List<SamActivityInputVO> list = command.searchSalesActivityList(samAct);
				eventResponse.setRsVoList(list);
				
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0009 : Retrieve<br>
	 * Customer 의 Booking 실적 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPFMCbyCustList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0009Event event = (EsmSam0009Event)e;
		SalesActivityManageBC command = new SalesActivityManageBCImpl();

		try{
			List<SamPFMCbyCustInputVO> list = command.searchPFMCbyCustList(event.getSamPFMCbyCustInputVO());
			eventResponse.setRsVoList(list);
			
			if(list.size() > 0){
				eventResponse.setETCData("total_bkg",list.get(0).getTotalBkg()); 
	        	eventResponse.setETCData("total_qty",list.get(0).getTotalQty()); 
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0007 : Save<br>
	 * Customer Info 저장합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSalesActivityInfo (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0007Event event = (EsmSam0007Event)e;
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		try{
			begin();
			command.manageSalesActivityInfo(event.getSamActivityInfoVOs(),account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("MST00003").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0007 : OFC_CD onChange<br>
	 * OFC_CD를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfcCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String ofcCd = null;
		
		if(e instanceof EsmSam0901Event){
			EsmSam0901Event event = (EsmSam0901Event)e;
			ofcCd = event.getHiddenOfcCd();
		}else if(e instanceof EsmSam0007Event){
			EsmSam0007Event event = (EsmSam0007Event)e;
			ofcCd = event.getHiddenOfcCd();
		}else if(e instanceof EsmSam0009Event){
			EsmSam0009Event event = (EsmSam0009Event)e;
			ofcCd = event.getHiddenOfcCd();
		}
		if(ofcCd != null) {
			try{
				String result = command.checkOfficeCd(ofcCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0007 : SREP_CD onChange<br>
	 * SREP_CD를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSlsRepCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String sRepCd = null;
		
		if(e instanceof EsmSam0901Event){
			EsmSam0901Event event = (EsmSam0901Event)e;
			sRepCd = event.getHiddenOfcCd();
		}else if(e instanceof EsmSam0007Event){
			EsmSam0007Event event = (EsmSam0007Event)e;
			sRepCd = event.getHiddenOfcCd();
		}else if(e instanceof EsmSam0009Event){
			EsmSam0009Event event = (EsmSam0009Event)e;
			sRepCd = event.getHiddenOfcCd();
		}
		if(sRepCd != null) {
			try{
				String result = command.checkSalesRepCode(sRepCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}

	/**
	 * ESM_SAM_0009 : CUST_CD onChange<br>
	 * ESM_SAM_0007 : CUST_CD onChange<br>
	 * CUST_CD를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCustCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String custCd = null;
		
		if(e instanceof EsmSam0009Event){
			EsmSam0009Event event = (EsmSam0009Event)e;
			custCd = event.getHiddenOfcCd();
		}else if(e instanceof EsmSam0007Event){
			EsmSam0007Event event = (EsmSam0007Event)e;
			custCd = event.getHiddenOfcCd();
		}
		if(custCd != null) {
			try{
				String result = command.checkCustomerCode(custCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_SAM_0901 : TEAM_CODE onChange<br>
	 * ESM_SAM_0007 : TEAM_CODE onChange<br>
	 * TEAM_CODE 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfcTeamCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String teamCd = null;
		
		if(e instanceof EsmSam0901Event){
			EsmSam0901Event event = (EsmSam0901Event)e;
			teamCd = event.getHiddenOfcCd();
		}else if(e instanceof EsmSam0007Event){
			EsmSam0007Event event = (EsmSam0007Event)e;
			teamCd = event.getHiddenOfcCd();
		}
		if(teamCd != null) {
			try{
				String result = command.checkOfcTeamCode(teamCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
		return eventResponse;
	}
	
	/** ESM_SAM_0007 <br>
	 * S.Rep Code 별 데이타를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustName(Event e) throws EventException
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		SamActivityInfoVO samActivityInfoVO = null;
		if(e instanceof EsmSam0007Event){
			EsmSam0007Event event = (EsmSam0007Event)e;
			samActivityInfoVO = event.getSamActivityInfoVO();
		}
		if(samActivityInfoVO != null) {
			try {				
				String repInfo = command.searchCustName(samActivityInfoVO);
				eventResponse.setETCData("cus_name", repInfo);
				
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
		}
		return eventResponse;
	}
	
	
	/** ESM_SAM_0007 <br>
	 * S.Rep Code 별 데이타를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSrepsManageCustList (Event e) throws EventException
	{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		SamActivityInfoVO samActivityInfoVO = null;
		if(e instanceof EsmSam0007Event){
			EsmSam0007Event event = (EsmSam0007Event)e;
			samActivityInfoVO = event.getSamActivityInfoVO();
		}
		if(samActivityInfoVO != null) {
			try {				
				String repInfo = command.searchSrepsManageCustList(samActivityInfoVO);
				eventResponse.setETCData("cus_code", repInfo);
				
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}	
		}
		return eventResponse;
	}
	/** ESM_SAM_0008<br>
	 * SalesRepName 조회<br>
	 * On_change
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepName(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0008Event event = (EsmSam0008Event)e;
		SalesActivityManageBC command = new SalesActivityManageBCImpl();
		
		try {				
			String repInfo = command.searchSalesRepName(event.getSRepInfoVO());
			if(repInfo != null){
			String[] repInfoData = repInfo.split("\t");
			eventResponse.setETCData("srep_nm", repInfoData[0]);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		}
	
	
	/**
	 * ESM_SAM_0008 : Activity No. onChange<br>
	 * Customer의 Activity를 실행한 Sales Rep을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	 private EventResponse checkSrepByActivity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		SamSlsActVO input_VO = null;
		if(e instanceof EsmSam0008Event){
			EsmSam0008Event event = (EsmSam0008Event)e;
			input_VO = event.getSamSlsActVO();
		}
		if(input_VO != null) {
			try{
				String result = command.checkSrepByActivity(input_VO);
				eventResponse.setETCData("result", result);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}
}
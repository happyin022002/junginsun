/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostSC.java
*@FileTitle : Inland Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2012-05-04
*@LastModifier : 
*@LastVersion : 1.0
* -------------------------------------------------------
* history
* 2012.05.04 변종건 [] Inland Cost Batch Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.costbatch;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsUtil;
import com.hanjin.apps.alps.esd.trs.common.trscommon.vo.TrsComboVO;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.basic.CostBatchBC;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.basic.CostBatchBCImpl;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.event.EsdTrs3004Event;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.event.EsdTrs3011Event;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.event.EsdTrs3020Event;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.event.EsdTrs3021Event;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchCostCalcListVO;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchFdrCostBatchErrorVO;
import com.hanjin.apps.alps.esd.trs.costbatch.costbatch.vo.SearchInlandCostBatchErrorVO;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.basic.InlandCostManageBC;
import com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.basic.InlandCostManageBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author 
 * @see ESD_TRS_3004EventResponse,CostBatchDBDAO 참조
 * @since J2EE 1.4
 */
public class CostBatchSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * InlandCostManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("InlandCostSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("InlandCostSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTrs3004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Retrieve : 
				eventResponse = searchCostCalcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 	//RHQ : RHQ Office Code List Search
				eventResponse = searchRHQOfficeCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 	//Combo : Combo List Search
				eventResponse = searchCombo3004(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 	//Verify : Country Code Verify
				eventResponse = verifyCountryCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { 		//Batch Creation : 
				eventResponse = insertBatchQueue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 	//Batch Creation Cancel : 
				eventResponse = modifyBatchCancel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 	//Confirm : Cost Tariff 0건인 대상의 Confirm
				eventResponse = modifyInlandCostCfm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { 	//Confirm Cancel : Cost Tariff Confirm Cancel
				eventResponse = modifyInlandCostCfmCxl(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs3011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Retrieve : 
				eventResponse = searchFeederCostCalcList(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){ //RHQ : RHQ Office Code List Search
				eventResponse= searchRHQOfficeCode(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Combo : Combo List Search
				eventResponse= searchCombo3011(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { 		//Batch Creation: 
				eventResponse = insertFeederBatchQueue(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs3020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Retrieve : 
				eventResponse = searchInlandCostBatchError(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs3021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Retrieve : 
				eventResponse = searchFdrCostBatchError(e);
			} else {
				eventResponse = null;
			}
		}
		
		return eventResponse;
	}

	
	/**
	 * ESD_TRS_3004 : 화면에 대한 RHQ Office Code 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQOfficeCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TrsCommonBC commCommand = new TrsCommonBCImpl();
		InlandCostManageBC command = new InlandCostManageBCImpl();

		try {
			/* RHQ Office Code */
			String rhqCd = commCommand.searchRHQOfficeCode(account.getOfc_cd());
			String shqFlg = command.searchShqOfcFlg(account.getOfc_cd());
			eventResponse.setETCData("rhq_cd", rhqCd);
			eventResponse.setETCData("shq_flg", shqFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3011 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3011(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		TrsUtil trsUtil = new TrsUtil();
		List<TrsComboVO> list = new ArrayList<TrsComboVO>();
		TrsComboVO combovo = new TrsComboVO();
		
		try {
			/* RHQ Office Combo List */
			list = trsUtil.searchCombo("CD00961");
			combovo.setVal("");
			combovo.setName("All");
			list.add(0,combovo);
			eventResponse.setRsVoList(list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3004 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3004(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		TrsUtil trsUtil = new TrsUtil();
		List<TrsComboVO> list = new ArrayList<TrsComboVO>();
		TrsComboVO combovo = new TrsComboVO();
		
		try {
			/* Status Combo List */
			list = trsUtil.searchCombo("CD03047");
			combovo.setVal("");
			combovo.setName("All");
			list.add(0,combovo);
			//Cancel(X) 제외
			for( int idx = list.size() - 1; idx >= 0; idx-- ){
				if( "X".equals(list.get(idx).getVal()) ){
					list.remove(idx);
				}
			}
			eventResponse.setRsVoList(list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3004 : Country Code Verify.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCountryCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3004Event event = (EsdTrs3004Event)e;
		TrsCommonBC commCommand = new TrsCommonBCImpl();

		try {
			/* Country Code Verify */
			String errFlg = commCommand.verifyCountryCode(event.getSearchCostCalcListVO().getCntCd());
			eventResponse.setETCData("err_flg", errFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3004 : 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCalcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3004Event event = (EsdTrs3004Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		
		try{
			List<SearchCostCalcListVO> list = command.searchCostCalcList(event.getSearchCostCalcListVO(), account);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3004 : Inland Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse insertBatchQueue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3004Event event = (EsdTrs3004Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		String progFlg = "";
		
		try{
			begin();
			progFlg = command.monitorBatchExec(event.getSearchCostCalcListVOs());
			if( !"Y".equals(progFlg) ){
				command.insertBatchQueue(event.getSearchCostCalcListVOs(), account);
			} else{
				eventResponse.setUserMessage(new ErrorHandler("TRS50112").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3011 : 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederCostCalcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3011Event event = (EsdTrs3011Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		
		try{
			List<SearchCostCalcListVO> list = command.searchFeederCostCalcList(event.getSearchCostCalcListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3011 : Ocean Feeder Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse insertFeederBatchQueue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3011Event event = (EsdTrs3011Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		String progFlg = "";
		
		try{
			begin();
			progFlg = command.monitorFeederBatchExec(event.getSearchCostCalcListVOs());
			if( !"Y".equals(progFlg) ){
				command.insertFeederBatchQueue(event.getSearchCostCalcListVOs(), account);
			} else{
				eventResponse.setUserMessage(new ErrorHandler("TRS50112").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3011 : 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInlandCostBatchError(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3020Event event = (EsdTrs3020Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		
		try{
			List<SearchInlandCostBatchErrorVO> list = command.searchInlandCostBatchError(event.getSearchInlandCostBatchErrorVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3011 : 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFdrCostBatchError(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3021Event event = (EsdTrs3021Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		
		try{
			List<SearchFdrCostBatchErrorVO> list = command.searchFdrCostBatchError(event.getSearchFdrCostBatchErrorVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3011 : Ocean Feeder Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBatchCancel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3004Event event = (EsdTrs3004Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		String errFlg = "";
		
		try{
			begin();
			errFlg = command.monitorWaitingSts(event.getSearchCostCalcListVOs());
			if( "N".equals(errFlg) ){
				command.modifyBatchCancel(event.getSearchCostCalcListVOs(), account);
			} else{
				eventResponse.setUserMessage(new ErrorHandler("COM12151", new String[]{"Inland Cost Batch Creation Cancel"}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3011 : Ocean Feeder Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInlandCostCfm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3004Event event = (EsdTrs3004Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		
		try{
			begin();
			command.modifyInlandCostCfm(event.getSearchCostCalcListVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * ESD_TRS_3011 : Ocean Feeder Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInlandCostCfmCxl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs3004Event event = (EsdTrs3004Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		
		String errFlg = "";
		
		try{
			begin();
			errFlg = command.searchGuidelineExist(event.getSearchCostCalcListVOs());
			if( !"Y".equals(errFlg) ){
				command.modifyInlandCostCfmCxl(event.getSearchCostCalcListVOs(), account);
			} else{
				eventResponse.setUserMessage(new ErrorHandler("TRS50113").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostBatchSC.java
*@FileTitle : Cost Batch
*Open Issues :
*Change history :
*@LastModifyDate : 2012-10-04
*@LastModifier : 
*@LastVersion : 1.0
* -------------------------------------------------------
* history
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.costbatch;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBC;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocCommonBCImpl;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic.AocUtil;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.vo.AocComboVO;
import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.basic.CostBatchBC;
import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.basic.CostBatchBCImpl;
import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.event.EsdAoc3001Event;
import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.event.EsdAoc3021Event;
import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.integration.CostBatchDBDAO;
import com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.vo.SearchCostCalcListVO;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.basic.EurInlandCostManageBC;
import com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.basic.EurInlandCostManageBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-AOC Business Logic ServiceCommand<br>
 * - ESD-AOC에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author 
 * @see CostBatchDBDAO 참조
 * @since J2EE 1.4
 */
public class CostBatchSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AOC 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * AOC 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("InlandCostSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-AOC 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdAoc3001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Retrieve : 
				eventResponse = searchCostCalcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 	//RHQ : RHQ Office Code List Search
				eventResponse = searchRHQOfficeCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 	//Combo : Combo List Search
				eventResponse = searchCombo3001(e);
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
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { 	//Re-Batch : Error 인 대상에 한해 Re-Batch 생성
				eventResponse = addReBatQue(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdAoc3021Event")) {
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
		}
		
		return eventResponse;
	}

	
	/**
	 * ESD_AOC_3001 : 화면에 대한 RHQ Office Code 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRHQOfficeCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AocCommonBC commCommand = new AocCommonBCImpl();
		EurInlandCostManageBC command = new EurInlandCostManageBCImpl();

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
	 * ESD_AOC_3011 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3011(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		AocUtil aocUtil = new AocUtil();
		List<AocComboVO> list = new ArrayList<AocComboVO>();
		AocComboVO combovo = new AocComboVO();
		
		try {
			/* RHQ Office Combo List */
			list = aocUtil.searchCombo("CD00961");
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
	 * ESD_AOC_3001 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo3001(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		AocUtil aocUtil = new AocUtil();
		List<AocComboVO> list = new ArrayList<AocComboVO>();
		AocComboVO combovo = new AocComboVO();
		
		try {
			/* Status Combo List */
			list = aocUtil.searchCombo("CD03051");
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
	 * ESD_AOC_3001 : Country Code Verify.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCountryCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3001Event event = (EsdAoc3001Event)e;
		AocCommonBC commCommand = new AocCommonBCImpl();

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
	 * ESD_AOC_3001 : 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCalcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3001Event event = (EsdAoc3001Event)e;
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
	 * ESD_AOC_3001 : Inland Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse insertBatchQueue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3001Event event = (EsdAoc3001Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		String progFlg = "";
		
		try{
			begin();
			for( int idx = 0; idx < event.getSearchCostCalcListVOs().length; idx++ ){
				event.getSearchCostCalcListVOs()[idx].setStsCd("W");
			}
			
			progFlg = command.monitorBatchExec(event.getSearchCostCalcListVOs());
			if( !"Y".equals(progFlg) ){
				command.insertBatchQueue(event.getSearchCostCalcListVOs(), account);
			} else{
				eventResponse.setUserMessage(new ErrorHandler("AOC00001").getUserMessage());
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
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse addReBatQue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3001Event event = (EsdAoc3001Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		String progFlg = "";
		
		try{
			begin();
			for( int idx = 0; idx < event.getSearchCostCalcListVOs().length; idx++ ){
				event.getSearchCostCalcListVOs()[idx].setStsCd("A");
			}
			
			progFlg = command.monitorBatchExec(event.getSearchCostCalcListVOs());
			
			if( !"Y".equals(progFlg) ){
				command.insertBatchQueue(event.getSearchCostCalcListVOs(), account);
				command.modifyBatchSeq(event.getSearchCostCalcListVOs(), account);
				command.modifyUsaBatchDtlSeq(event.getSearchCostCalcListVOs(), account);
			} else{
				eventResponse.setUserMessage(new ErrorHandler("AOC00001").getUserMessage());
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
	 * ESD_AOC_3011 : 화면 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederCostCalcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3021Event event = (EsdAoc3021Event)e;
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
	 * ESD_AOC_3011 : Ocean Feeder Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse insertFeederBatchQueue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3021Event event = (EsdAoc3021Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		String progFlg = "";
		
		try{
			begin();
			progFlg = command.monitorFeederBatchExec(event.getSearchCostCalcListVOs());
			if( !"Y".equals(progFlg) ){
				command.insertFeederBatchQueue(event.getSearchCostCalcListVOs(), account);
			} else{
				eventResponse.setUserMessage(new ErrorHandler("AOC00001").getUserMessage());
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
	 * ESD_AOC_3011 : Ocean Feeder Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBatchCancel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3001Event event = (EsdAoc3001Event)e;
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
	 * ESD_AOC_3011 : Ocean Feeder Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInlandCostCfm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3001Event event = (EsdAoc3001Event)e;
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
	 * ESD_AOC_3011 : Ocean Feeder Cost Batch Creation.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInlandCostCfmCxl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdAoc3001Event event = (EsdAoc3001Event)e;
		CostBatchBC command = new CostBatchBCImpl();
		
		String errFlg = "";
		
		try{
			begin();
			errFlg = command.searchGuidelineExist(event.getSearchCostCalcListVOs());
			if( !"Y".equals(errFlg) ){
				command.modifyInlandCostCfmCxl(event.getSearchCostCalcListVOs(), account);
			} else{
				eventResponse.setUserMessage(new ErrorHandler("AOC00002").getUserMessage());
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
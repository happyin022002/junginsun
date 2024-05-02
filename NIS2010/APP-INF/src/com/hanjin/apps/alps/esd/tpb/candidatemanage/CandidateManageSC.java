/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CandidateManageSC.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage;

import java.util.List;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.basic.CandidateConfirmBC;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.basic.CandidateConfirmBCImpl;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.event.EsdTpb0105Event;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.event.EsdTpb0814Event;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.integration.CandidateConfirmDBDAO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchNonTPBDescVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.basic.InterfacedCancelBC;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.basic.InterfacedCancelBCImpl;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.event.EsdTpb0133Event;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.interfacedcancel.vo.SearchInterfacedCancelListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.basic.ManualRegisterBC;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.basic.ManualRegisterBCImpl;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0103Event;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0104Event;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0801Event;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0811Event;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.event.EsdTpb0813Event;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchContainerInfoVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchEQKindVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBDuplicationListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBOfficeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 

/**
 * ALPS-CandidateManage Business Logic ServiceCommand - ALPS-CandidateManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author GUN-HA HWANG
 * @see CandidateConfirmDBDAO
 * @since J2EE 1.6
 */ 

public class CandidateManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CandidateManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CandidateManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CandidateManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CandidateManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CandidateManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsdTpb0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI) 
					|| e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createTPBCandidate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkEqNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEQKindCd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBkgVVDFincDirCd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI) 
					|| e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createEACRegistration(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkEqNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEQKindCd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCandidateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCandidateConfirm(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0801Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBDuplicationList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0811Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0133Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCanceledTPB(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				interfacedTPBCancel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0813Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBOfficeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0814Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNonTPBDesc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiNonTPBDesc(e);
			}
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0105 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCandidateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0105Event event = (EsdTpb0105Event)e;
		CandidateConfirmBC command = new CandidateConfirmBCImpl();

		try{
			List<SearchCandidateListVO> list = command.searchCandidateList(event.getSearchCandidateListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0801 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBDuplicationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0801Event event = (EsdTpb0801Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		
		try{
			List<SearchTPBDuplicationListVO> list = command.searchTPBDuplicationList(event.getSearchTPBDuplicationListVO(), account);
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EsdTpb0811 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0811Event event = (EsdTpb0811Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		
		try{
			List<SearchContainerInfoVO> list = command.searchContainerInfo(event.getSearchContainerInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb1330 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanceledTPB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0133Event event = (EsdTpb0133Event)e;
		InterfacedCancelBC command = new InterfacedCancelBCImpl();
		
		try{
			List<SearchInterfacedCancelListVO> list = command.searchCanceledTPB(event.getSearchInterfacedCancelListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdTpb0103 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTPBCandidate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0103Event event = (EsdTpb0103Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		try{
			begin();
			command.createTPBCandidate(event.getCreateTPBCandidateVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0104 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createEACRegistration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0104Event event = (EsdTpb0104Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		try{
			begin();
			command.createEACRegistration(event.getCreateEACRegistrationVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0105 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCandidateConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0105Event event = (EsdTpb0105Event)e;
		CandidateConfirmBC command = new CandidateConfirmBCImpl();
		try{
			begin();
			SearchCandidateListVO[] scVO = event.getSearchCandidateListVOS();
			
			for(int i=0;i<scVO.length;i++){
				scVO[i].setUserOfcCd(account.getOfc_cd());
			}
			List<SearchCandidateListVO> list =  command.multiCandidateConfirm(scVO,account);
			command.multiNonTPBCfmDt(event.getSearchCandidateListVOS(),account);
			eventResponse.setRsVoList(list);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0133 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse interfacedTPBCancel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0133Event event = (EsdTpb0133Event)e;
		InterfacedCancelBC command = new InterfacedCancelBCImpl();
		try{
			begin();
			command.interfacedTPBCancel(event.getSearchInterfacedCancelListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsdTpb0916 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0813Event event = (EsdTpb0813Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();

		try{
			List<SearchTPBOfficeListVO> list = command.searchTPBOfficeList(event.getSearchTPBOfficeListVO());
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
	 * EsdTpb0814 : [EsdTpb0814Event]<br>
	 * [ESD_TPB_0814]을 [search]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonTPBDesc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0814Event event = (EsdTpb0814Event)e;
		CandidateConfirmBC command = new CandidateConfirmBCImpl();

		try{
			List<SearchNonTPBDescVO> list = command.searchNonTPBDesc(event.getSearchNonTPBDescVO());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("n3pty_non_cfm_rsn", list.get(0).getN3ptyNonCfmRsn());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdTpb0814 : [EsdTpb0814Event]<br>
	 * [ESD_TPB_0814]을 [multi]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiNonTPBDesc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0814Event event = (EsdTpb0814Event)e;
		CandidateConfirmBC command = new CandidateConfirmBCImpl();
		try{
			begin();
			command.multiNonTPBDesc(event.getSearchNonTPBDescVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0103 : VVD_CD onChange<br>
	 * VVD_CD를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkEqNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManualRegisterBC command = new ManualRegisterBCImpl();
		
		String eqNo = null;
		
		if(e instanceof EsdTpb0103Event){
			EsdTpb0103Event event = (EsdTpb0103Event)e;
			eqNo = event.getEqNo();
		}else if(e instanceof EsdTpb0104Event){
			EsdTpb0104Event event = (EsdTpb0104Event)e;
			eqNo = event.getEqNo();
		}
		try{
			String result = command.checkEqNo(eqNo);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0103 , 0104: <br>
	 * EQ_KIND를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQKindCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManualRegisterBC command = new ManualRegisterBCImpl();
		
		String n3ptyEexpnTpCd = null;
		List<SearchEQKindVO> list = null;
		if(e instanceof EsdTpb0103Event){
			EsdTpb0103Event event = (EsdTpb0103Event)e;
			n3ptyEexpnTpCd = event.getSN3ptyExpnTpCd();
		}else if(e instanceof EsdTpb0104Event){
			EsdTpb0104Event event = (EsdTpb0104Event)e;
			n3ptyEexpnTpCd = event.getSN3ptyExpnTpCd();
		}
		try{
			list = command.searchEQKindCd(n3ptyEexpnTpCd);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0103 <br>
	 * FincDirCd을 구하고 REV VVD 존재 여부를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgVVDFincDirCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0103Event event = (EsdTpb0103Event)e;
		ManualRegisterBC command = new ManualRegisterBCImpl();
		
		String vvd   = null;
		String bkgNo = null;
		String ydCd  = null;
		String fincDirCd = null;
		
		vvd   = event.getrVvd();
		bkgNo = event.getBkgNo();
		ydCd  = event.getYdCd();
	
		try{
			fincDirCd = command.searchBkgVVDFincDirCd(vvd, ydCd, bkgNo);
			
			eventResponse.setETCData("fincDirCd", fincDirCd);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOCaseManageSC.java
*@FileTitle : JOStatusInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.basic.JOCandidateConfirmBC;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.basic.JOCandidateConfirmBCImpl;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.event.EsdTpb0122Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.vo.SearchJOCandidateConfirmListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.basic.JOInvoiceManageBC;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.basic.JOInvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0123Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0124Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0126Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0127Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchTPBHandlingListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.basic.JOOutstandinggroupManageBC;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.basic.JOOutstandinggroupManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.event.EsdTpb0125Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jooutstandinggroupmanage.vo.SearchTPBGroupModifyListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.basic.JOStatusInquiryBC;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.basic.JOStatusInquiryBCImpl;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0128Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0129Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.event.EsdTpb0130Event;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.integration.JOStatusInquiryDBDAO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOInvoiceListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailInfoVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchJOTPBDetailListVO;
import com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo.SearchProcessListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic.InvoiceManageBC;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic.InvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
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
 * @author Sun, CHOI
 * @see JOStatusInquiryDBDAO
 * @since J2EE 1.6
 */

public class JOCaseManageSC extends ServiceCommandSupport {
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
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		
		if (e.getEventName().equalsIgnoreCase("EsdTpb0122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCandidateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiCandidateConfirm(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0124Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBHandlingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0123Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceSheetSet(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createInvoiceSheetSet(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0125Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBGroupModifyList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiTPBGroupModify(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = updateJOTPBCancel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0126Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCreation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			}else{
				eventResponse = searchInvoiceInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0127Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceDetailListForRevision(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchInvoiceDefaultData(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0128Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBDetailInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01 )) {
				eventResponse = searchTPBDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0129Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0130Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProcessList(e);
			}
		} 
		return eventResponse;
	}
	/**
	 * EsdTpb0122 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCandidateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0122Event event = (EsdTpb0122Event)e;
		JOCandidateConfirmBC command = new JOCandidateConfirmBCImpl();

		try{
			List<SearchJOCandidateConfirmListVO> list = command.searchCandidateList(event.getSearchJOCandidateConfirmListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0122 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCandidateConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0122Event event = (EsdTpb0122Event)e;
		JOCandidateConfirmBC command = new JOCandidateConfirmBCImpl();
		try{
			begin();
			List<SearchJOCandidateConfirmListVO> list = command.multiCandidateConfirm(event.getSearchJOCandidateConfirmListVOS(),account);
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
	 * EsdTpb0124 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBHandlingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0124Event event = (EsdTpb0124Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();

		try{
			List<SearchTPBHandlingListVO> list = command.searchTPBHandlingList(event.getSearchTPBHandlingListVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0124 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse createERPInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceManageBC invCommand = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		InvoiceCreationVO invoiceVo = new InvoiceCreationVO();
		
		if( e.getEventName().equalsIgnoreCase("EsdTpb0124Event") ){
			EsdTpb0124Event event = (EsdTpb0124Event)e;
			invoiceVo = event.getInvoiceCreationVO();
		} else if( e.getEventName().equalsIgnoreCase("EsdTpb0126Event") ){
			EsdTpb0126Event event = (EsdTpb0126Event)e;
			invoiceVo = event.getInvoiceCreationVO();
		} else if( e.getEventName().equalsIgnoreCase("EsdTpb0127Event") ){
			EsdTpb0127Event event = (EsdTpb0127Event)e;
			invoiceVo = event.getInvoiceCreationVO();
		}
		
		try{
			begin();
			eventResponse = invCommand.createERPInterface(invoiceVo, account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			List<ARInterfaceCreationVO> genIfVOs = (List<ARInterfaceCreationVO>)eventResponse.getRsVoList();
			if(genIfVOs.size() > 0){
				rGenIfVOs = arInterFace.interfaceGeneralARInvoiceToIF(genIfVOs);
				// AR INTERFACE CALL
			}
			if(rGenIfVOs.size() > 0){
				String arReturnVal = arInterFace.interfaceGeneralARInvoiceToINV(rGenIfVOs);
				// AR INTERFACE END
				if(arReturnVal == null || arReturnVal.equals("")){
	            	eventResponse.setUserMessage("Cancelled! A/R I/F failed!");//메시지 처리
				}else if(arReturnVal != null && !arReturnVal.equals("")){
					eventResponse.setETCData("ARReturnVal", arReturnVal);
					String[] arReturnVals =  arReturnVal.split("::");
					if(arReturnVals[0].equals("E")){
						eventResponse.setUserMessage(arReturnVal);
						throw new EventException(new ErrorHandler("TPB00040",new String[]{arReturnVals[1]}).getMessage());
					} else if(arReturnVals[0].equals("S")) {
						arInterFace.interfaceARInvoiceToERPAR(arReturnVals[1]);
					}					
				}
			}
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
	 * EsdTpb0123 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceSheetSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0123Event event = (EsdTpb0123Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
		try{
			List<SearchInvoiceSheetSetVO> list = command.searchInvoiceSheetSet(event.getSearchInvoiceSheetSetVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0123 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createInvoiceSheetSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0123Event event = (EsdTpb0123Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		try{
			begin();
			command.createInvoiceSheetSet(event.getSearchInvoiceSheetSetVOS(),account);
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
	 * EsdTpb0125 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBGroupModifyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0125Event event = (EsdTpb0125Event)e;
		JOOutstandinggroupManageBC command = new JOOutstandinggroupManageBCImpl();
		
		try{
			List<SearchTPBGroupModifyListVO> list = command.searchTPBGroupModifyList(event.getSearchTPBGroupModifyListVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0125 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTPBGroupModify(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0125Event event = (EsdTpb0125Event)e;
		JOOutstandinggroupManageBC command = new JOOutstandinggroupManageBCImpl();
		try{
			begin();
			List<SearchTPBGroupModifyListVO> list = command.multiTPBGroupModify(event.getSearchTPBGroupModifyListVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setRsVoList(list);
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
	 * EsdTpb0125 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateJOTPBCancel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0125Event event = (EsdTpb0125Event)e;
		JOOutstandinggroupManageBC command = new JOOutstandinggroupManageBCImpl();
		try{
			begin();
			List<SearchTPBGroupModifyListVO> list = command.updateJOTPBCancel(event.getSearchTPBGroupModifyListVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setRsVoList(list);
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
	* EsdTpb0126 : [이벤트]<br>
	* [비즈니스대상]을 [행위]합니다.<br>
	* 
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchInvoiceCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0126Event event = (EsdTpb0126Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchInvoiceCreation(event, eventResponse);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0126 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0126Event event = (EsdTpb0126Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
		try{
			List<InvoiceCreationVO> list = command.searchInvoiceInfo(event.getInvoiceCreationVO());
			eventResponse.setRsVoList(list); 
		}catch(EventException ex){ 
			throw ex; 
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0126 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		EsdTpb0126Event event = (EsdTpb0126Event)e;
		
		try{
			begin();
			////// Invoice Creation Start /////
			eventResponse = command.createInvoice(event.getInvoiceCreationVOs(), eventResponse,  account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			////// Invoice Creation End /////
			
			
			///// AR ERP Interface Start /////
			List<ARInterfaceCreationVO> genIfVOs = (List<ARInterfaceCreationVO>)eventResponse.getRsVoList();
			if(genIfVOs.size() > 0){
				rGenIfVOs = arInterFace.interfaceGeneralARInvoiceToIF(genIfVOs);
			}
			if(rGenIfVOs.size() > 0){
				String arReturnVal = arInterFace.interfaceGeneralARInvoiceToINV(rGenIfVOs);
				if(arReturnVal == null || arReturnVal.equals("")){
	            	eventResponse.setUserMessage("Cancelled! A/R I/F failed!");//메시지 처리
				}else if(arReturnVal != null && !arReturnVal.equals("")){
					eventResponse.setETCData("ARReturnVal", arReturnVal);
					String[] arReturnVals =  arReturnVal.split("::");
					if(arReturnVals[0].equals("E")){
						eventResponse.setUserMessage(arReturnVal);
						throw new Exception(new ErrorHandler("TPB00040",new String[]{arReturnVals[1]}).getMessage());
					} else if(arReturnVals[0].equals("S")) {
						arInterFace.interfaceARInvoiceToERPAR(arReturnVals[1]);
					}
				}
			}
			///// AR ERP Interface End /////
			
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
	 * EsdTpb0127 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDetailListForRevision(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0127Event event = (EsdTpb0127Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchInvoiceDetailListForRevision(event, eventResponse);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * EsdTpb0127 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDefaultData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0127Event event = (EsdTpb0127Event)e;
		JOInvoiceManageBC command = new JOInvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchInvoiceDefaultData(event.getSearchInvoiceDefaultDataVO(), eventResponse, account);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTpb0127 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0127Event event = (EsdTpb0127Event)e;
		InvoiceManageBC invCommand = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		try{
			begin();
			////// Invoice Modify Start /////
			eventResponse = invCommand.modifyInvoice(event.getInvoiceCreationVOs(),account, eventResponse);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			////// Invoice Modify End /////
			
			
			///// AR ERP Interface Start /////
			List<ARInterfaceCreationVO> genIfVOs = (List<ARInterfaceCreationVO>)eventResponse.getRsVoList();
			if(genIfVOs.size() > 0){
				rGenIfVOs = arInterFace.interfaceGeneralARInvoiceToIF(genIfVOs);
			}
			if(rGenIfVOs.size() > 0){
				String arReturnVal = arInterFace.interfaceGeneralARInvoiceToINV(rGenIfVOs);
				if(arReturnVal == null || arReturnVal.equals("")){
	            	eventResponse.setUserMessage("Cancelled! A/R I/F failed!");//메시지 처리
				}else if(arReturnVal != null && !arReturnVal.equals("")){
					eventResponse.setETCData("ARReturnVal", arReturnVal);
					String[] arReturnVals =  arReturnVal.split("::");
					if(arReturnVals[0].equals("E")){
						eventResponse.setUserMessage(arReturnVal);
						throw new Exception(new ErrorHandler("TPB00040",new String[]{arReturnVals[1]}).getMessage());
					} else if(arReturnVals[0].equals("S")) {
						arInterFace.interfaceARInvoiceToERPAR(arReturnVals[1]);
					}
				}
			}
			///// AR ERP Interface End /////
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
	 * EsdTpb0128 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBDetailInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0128Event event = (EsdTpb0128Event)e;
		JOStatusInquiryBC command = new JOStatusInquiryBCImpl();
		
		try{
			List<SearchJOTPBDetailInfoVO> list = command.searchTPBDetailInfo(event.getSearchJOTpbDetailInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0128 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0128Event event = (EsdTpb0128Event)e;
		JOStatusInquiryBC command = new JOStatusInquiryBCImpl();
		
		try{
			List<SearchJOTPBDetailListVO> list = command.searchTPBDetailList(event.getSearchJOTpbDetailListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * EsdTpb0127 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse removeInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0127Event event = (EsdTpb0127Event)e;
		InvoiceManageBC invCommand = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBCImpl arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		try{
			begin();
			eventResponse = invCommand.removeInvoice(event.getInvoiceCreationVO(),account, eventResponse);
			List<ARInterfaceCreationVO> genIfVOs = (List<ARInterfaceCreationVO>)eventResponse.getRsVoList();
			if(genIfVOs.size() > 0){
				rGenIfVOs = arInterFace.interfaceGeneralARInvoiceToIF(genIfVOs);
			}
			if(rGenIfVOs.size() > 0){
				String arReturnVal = arInterFace.interfaceGeneralARInvoiceToINV(rGenIfVOs);
				if(arReturnVal != null && !arReturnVal.equals("")){		
					eventResponse.setETCData("ARReturnVal", arReturnVal);
					String[] arReturnVals =  arReturnVal.split("::");
					if(arReturnVals[0].equals("E")){
						eventResponse.setUserMessage(arReturnVal);
						throw new EventException(new ErrorHandler("TPB00040",new String[]{arReturnVals[1]}).getMessage());
					} else if(arReturnVals[0].equals("S")) {
						arInterFace.interfaceARInvoiceToERPAR(arReturnVals[1]);						
					}
				}
			}
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
	 * EsdTpb0129 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0129Event event = (EsdTpb0129Event)e;
		JOStatusInquiryBC command = new JOStatusInquiryBCImpl();
		
		try{
			List<SearchJOInvoiceListVO> list = command.searchInvoiceList(event.getSearchJOInvoiceListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EsdTpb0130 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProcessList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0130Event event = (EsdTpb0130Event)e;
		JOStatusInquiryBC command = new JOStatusInquiryBCImpl();
		
		try{
			List<SearchProcessListVO> list = command.searchProcessList(event.getSearchProcessListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
}
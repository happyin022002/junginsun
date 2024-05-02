/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProcessManageSC.java
*@FileTitle : ProcessManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 최 선
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.10.01 변종건 [CHM-201005566-01] [TPB] 지역본부/본사의 ROC 결정 후 2ND REVIEW를 위한 보완
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBC;
import com.hanjin.apps.alps.esd.tpb.common.combo.basic.CommonCodeBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.combo.vo.TpbComboVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.basic.AdjustmentManageBC;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.basic.AdjustmentManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0113Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0114Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0138Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0804Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.integration.AdjustmentManageDBDAO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchROCToOfficeListVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeInquiryVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchResponsibleOfficeChangeVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryReviewVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffInquiryVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffReviewVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchWriteOffVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic.InvoiceManageBC;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic.InvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0106Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0109Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0110Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0111Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0112Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0812Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.basic.OutstandinggroupManageBC;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.basic.OutstandinggroupManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0107Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.event.EsdTpb0108Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBGroupRemakingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.outstandinggroupmanage.vo.SearchTPBModificationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.basic.RecoveryActivityManageBC;
import com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.basic.RecoveryActivityManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.event.EsdTpb0807Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.vo.SearchRecoveryActivityListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ProcessManage Business Logic ServiceCommand - ALPS-ProcessManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Sun, CHOI
 * @see AdjustmentManageDBDAO
 * @since J2EE 1.6
 */

public class ProcessManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ProcessManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ProcessManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ProcessManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ProcessManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ProcessManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdTpb0106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBHandling(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createERPInterface(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkRocRollback(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBGroupRemaking(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyTPBGroupRemaking(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTPBModification(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyTPBModification(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceSheetSet(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createInvoiceSheetSet(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceCreation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createInvoice(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)) { // erp i/f ... Added in 2008-12-03
				eventResponse = createERPInterface(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Account Code, Name Combo
				eventResponse = searchAcctCd(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){ //Terminal Name, ATD 값 가져오기
				eventResponse = searchInvYdNmAtd(e);
			} else{
				eventResponse = searchInvoiceInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0111Event")) {
			if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchInvoiceDetailListForRevision(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCHLIST) ){
				eventResponse = searchInvoiceDefaultData(e);
			} else if( e.getFormCommand().isCommand(FormCommand.MULTI) ){
				eventResponse = modifyInvoice(e);
			} else if( e.getFormCommand().isCommand(FormCommand.REMOVE) ){
				eventResponse = removeInvoice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.ADD) ){ // erp i/f ... Added in 2008-12-03
				eventResponse = createERPInterface(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){ //Account Code, Name Combo
				eventResponse = searchAcctCd(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){ //Terminal Name, ATD 값 가져오기
				eventResponse = searchInvRvisYdNmAtd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceStatus(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateInvoiceIssue(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = transmitTPBEDI(e);		
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = backEndJobResult(e);				
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchResponsibleOfficeChangeInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchResponsibleOfficeChange(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchResponsibleOfficeChange(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = createResponsibleOfficeChangeRequest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = createResponsibleOfficeChangeApprove(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				removeResponsibleOfficeChangeRequest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchCheckTPBROCOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0114Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchWriteOffInquiry(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchWriteOff(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = createWriteOffRequest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = createWriteOffApprove(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				removeWriteOffRequest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0138Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchWriteOffInquiryReview(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchWriteOffReview(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				eventResponse = createWriteOffRequestReview(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = createWriteOffApproveReview(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				removeWriteOffRequestReview(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0804Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchROCToOfficeList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0807Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRecoveryActivity(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01) ){
				eventResponse = multiRecoveryActivity(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTpb0812Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIndiaTaxInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse = searchIndiaTaxInfoByEffDate(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI) ){
				eventResponse = multiIndiaTaxInfo(e);
			}
		}
		return eventResponse;
	}
	
	
	/**esd_tpb_0112: transmit EDI
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse transmitTPBEDI(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceManageBC command = null;
		//ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		try
		{
			begin();
		
		// TPB Flat File 생성)
		EsdTpb0112Event event =(EsdTpb0112Event) e;

		// transmit
		command = new InvoiceManageBCImpl();

		String key = command.startBackEndJob(account, event.getSearchInvoiceStatusVO(), "ESD_TPB_0112");

		eventResponse.setETCData("KEY", key);
		eventResponse.setUserMessage(new ErrorHandler("TPB00079").getUserMessage());
		commit();
		
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("TPB00080").getMessage(), ex);
		}

		return eventResponse;	
		
	}

/**
 * esd_tpb_0112 : backEndJob의 결과를 판단
 * @param Event e
 * @return EventResponse
 * @throws EventException
 */
private EventResponse backEndJobResult(Event e) throws EventException{
	GeneralEventResponse eventResponse = new GeneralEventResponse();
	String sKey = "";
	if(e.getEventName().equalsIgnoreCase("EsdTpb0112Event"))
	{
		EsdTpb0112Event event =(EsdTpb0112Event) e;
		sKey = event.getKey();
	}
	
	String strResult = "";
	try
	{
		BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
		DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		while(rowSet.next()){
			if("2".equals(rowSet.getString("JB_STS_FLG")))
			{
				// BackEndJob 처리중
				strResult = "PROCESSING";
			}
			else if("3".equals(rowSet.getString("JB_STS_FLG")))
			{

				if(e.getEventName().equalsIgnoreCase("EsdTpb0112Event"))
				{
//					 Data Transmitted successufully!						
					eventResponse.setUserMessage(new ErrorHandler("TPB00079").getUserMessage());
				}

				strResult = "SUCCESS";
			}
			else if("4".equals(rowSet.getString("JB_STS_FLG")))
			{ 
				// 에러메시지세팅
				if(e.getEventName().equalsIgnoreCase("EsdTpb0112Event"))
				{
					if(!"".equals(rowSet.getString("JB_USR_ERR_MSG"))){
						StringTokenizer st = new StringTokenizer(rowSet.getString("JB_USR_ERR_MSG"), "<||>");
						st.nextToken();
						st.nextToken();
						st.nextToken();
						String strErrMsg = st.nextToken();
						eventResponse.setUserMessage(strErrMsg);
					}else{
						eventResponse.setUserMessage(new ErrorHandler("TPB00080").getUserMessage());
					}
				}

				strResult = "FAIL";
			}
		}
		eventResponse.setETCData("jb_sts_flg", strResult);
	}
	catch(Exception ex)
	{
		rollback();
		throw new EventException(new ErrorHandler("TPB00080").getMessage(), ex);
	}
	return eventResponse;
}

	/**
	 * ESD_TPB_0106 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBHandling(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0106Event event = (EsdTpb0106Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<SearchTPBHandlingVO> list = command.searchTPBHandling(event.getSearchTPBHandlingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0109 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceSheetSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0109Event event = (EsdTpb0109Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<SearchInvoiceSettingVO> list = command.searchInvoiceSheetSet(event.getSearchInvoiceSettingVO());
			// list을 ETC-DATA로 setting
			eventResponse.setETCData("data_knt", list.size() + "");
			for (int i = 0; i < list.size(); i++) {
				eventResponse.setETCData(list.get(i).getColumnValues());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0107 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBGroupRemaking(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0107Event event = (EsdTpb0107Event)e;
		OutstandinggroupManageBC command = new OutstandinggroupManageBCImpl();
		
		try{
			List<SearchTPBGroupRemakingVO> list = command.searchTPBGroupRemaking(event.getSearchTPBGroupRemakingVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0108 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBModification(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0108Event event = (EsdTpb0108Event)e;
		OutstandinggroupManageBC command = new OutstandinggroupManageBCImpl();
		
		try{
			List<SearchTPBModificationVO> list = command.searchTPBModification(event.getSearchTPBModificationVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0110 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0110Event event = (EsdTpb0110Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
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
	 * ESD_TPB_0110 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0110Event event = (EsdTpb0110Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
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
	 * ESD_TPB_0111 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDetailListForRevision(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
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
	 * ESD_TPB_0111 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceDefaultData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
//		log.debug("searchInvoiceDefaultDataSC");
		try{
			eventResponse = command.searchInvoiceDefaultData(event.getSearchInvoiceDefaultDataVO(), eventResponse, account);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 *  : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceStatus(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0112Event event = (EsdTpb0112Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			eventResponse = command.searchInvoiceStatus(event, eventResponse);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 *  : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private EventResponse updateInvoiceIssue(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0112Event event = (EsdTpb0112Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();

		String fax_eml_snd_no = null;
		
		try{
			begin();
			fax_eml_snd_no = command.updateInvoiceIssue(event.getSearchInvoiceStatusVO(),account);
			//eventResponse.setCustomData(SubSystemConfigFactory.get("COM.MAIL.KEYS"), mailInvoice.send2(vo1));
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return this.searchInvoiceStatus(e);
	}
	/**
	 * ESD_TPB_0113 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchResponsibleOfficeChange(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchResponsibleOfficeChangeVO> list = command.searchResponsibleOfficeChange(event.getSearchResponsibleOfficeChangeVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0113 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchResponsibleOfficeChangeInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchResponsibleOfficeChangeInquiryVO> list = command.searchResponsibleOfficeChangeInquiry(event.getSearchResponsibleOfficeChangeInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOff(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchWriteOffVO> list = command.searchWriteOff(event.getSearchWriteOffVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOffInquiry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchWriteOffInquiryVO> list = command.searchWriteOffInquiry(event.getSearchWriteOffInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0138 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOffReview(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0138Event event = (EsdTpb0138Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchWriteOffReviewVO> list = command.searchWriteOffReview(event.getSearchWriteOffReviewVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0138 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWriteOffInquiryReview(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0138Event event = (EsdTpb0138Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchWriteOffInquiryReviewVO> list = command.searchWriteOffInquiryReview(event.getSearchWriteOffInquiryReviewVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0804 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchROCToOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0804Event event = (EsdTpb0804Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		
		try{
			List<SearchROCToOfficeListVO> list = command.searchROCToOfficeList(event.getSearchROCToOfficeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0807 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRecoveryActivity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0807Event event = (EsdTpb0807Event)e;
		RecoveryActivityManageBC command = new RecoveryActivityManageBCImpl();
		
		try{
			List<SearchRecoveryActivityListVO> list = command.searchRecoveryActivity(event.getSearchRecoveryActivityListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0812 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIndiaTaxInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0812Event event = (EsdTpb0812Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<SearchIndiaTaxInfoVO> list = command.searchIndiaTaxInfo(event.getSearchIndiaTaxInfoVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESD_TPB_0812 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */ 
	private EventResponse searchIndiaTaxInfoByEffDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0812Event event = (EsdTpb0812Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		
		try{
			List<SearchIndiaTaxInfoVO> list = command.searchIndiaTaxInfoByEffDate(event.getSearchIndiaTaxInfoVO(),account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESD_TPB_0107 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTPBGroupRemaking(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0107Event event = (EsdTpb0107Event)e;
		OutstandinggroupManageBC command = new OutstandinggroupManageBCImpl();
		try{
			begin();
			command.modifyTPBGroupRemaking(event.getModifyTPBGroupRemakingVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0106 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse createERPInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//abcd
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceManageBC command = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		InvoiceCreationVO invoiceVo = new InvoiceCreationVO();
		
		if( e.getEventName().equalsIgnoreCase("EsdTpb0110Event") ){
			EsdTpb0110Event event = (EsdTpb0110Event)e;
			invoiceVo = event.getInvoiceCreationVO();
		} else if( e.getEventName().equalsIgnoreCase("EsdTpb0111Event") ){
			EsdTpb0111Event event = (EsdTpb0111Event)e;
			invoiceVo = event.getInvoiceCreationVO();
		} else if( e.getEventName().equalsIgnoreCase("EsdTpb0106Event") ){
			EsdTpb0106Event event = (EsdTpb0106Event)e;
			invoiceVo = event.getInvoiceCreationVO();
		}
		
		try{
			begin();
			eventResponse = command.createERPInterface(invoiceVo, account);
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
	 * ESD_TPB_0108 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTPBModification(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0108Event event = (EsdTpb0108Event)e;
		OutstandinggroupManageBC command = new OutstandinggroupManageBCImpl();
		try{
			begin();
			command.modifyTPBModification(event.getModifyTPBModificationVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0109 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createInvoiceSheetSet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0109Event event = (EsdTpb0109Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		try{
			begin();
			command.createInvoiceSheetSet(event.getSearchInvoiceSettingVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0110 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//abcd
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceManageBC command = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		EsdTpb0110Event event = (EsdTpb0110Event)e;
		
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
		} catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0111 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//abcd
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		
		try{
			begin();
			////// Invoice Modify Start /////
			eventResponse = command.modifyInvoice(event.getInvoiceCreationVOs(),account, eventResponse);
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
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESD_TPB_0111 : [이벤트]<br>
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
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		GeneralARInvoiceCreationBC arInterFace = new GeneralARInvoiceCreationBCImpl();
		List<ARInterfaceCreationVO> rGenIfVOs = new ArrayList<ARInterfaceCreationVO>();
		try{
			begin();
			eventResponse = command.removeInvoice(event.getInvoiceCreationVO(),account, eventResponse);
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
	 * ESD_TPB_0113 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createResponsibleOfficeChangeRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createResponsibleOfficeChangeRequest(event.getCreateResponsibleOfficeChangeRequestVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0113 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createResponsibleOfficeChangeApprove(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createResponsibleOfficeChangeApprove(event.getCreateResponsibleOfficeChangeApproveVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0113 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeResponsibleOfficeChangeRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0113Event event = (EsdTpb0113Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.removeResponsibleOfficeChangeRequest(event.getDeleteResponsibleOfficeChangeRequestVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ROC Office Code 조회.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckTPBROCOffice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdTpb0113Event event = (EsdTpb0113Event)e;
        CommonCodeBC command = new CommonCodeBCImpl();
        String r_ofc_cd = null;
        try{
        	r_ofc_cd = command.searchCheckTPBROCOffice(event.getSearchResponsibleOfficeChangeVO().getN3ptyNo());
        	eventResponse.setETCData("r_ofc_cd", r_ofc_cd);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESD_TPB_0114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createWriteOffRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createWriteOffRequest(event.getCreateWriteOffRequestVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0138 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createWriteOffRequestReview(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0138Event event = (EsdTpb0138Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createWriteOffRequest(event.getCreateWriteOffRequestVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createWriteOffApprove(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createWriteOffApprove(event.getCreateWriteOffApproveVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0138 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createWriteOffApproveReview(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0138Event event = (EsdTpb0138Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.createWriteOffApprove(event.getCreateWriteOffApproveVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0114 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeWriteOffRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0114Event event = (EsdTpb0114Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.removeWriteOffRequest(event.getDeleteWriteOffRequestVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0138 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeWriteOffRequestReview(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0138Event event = (EsdTpb0138Event)e;
		AdjustmentManageBC command = new AdjustmentManageBCImpl();
		try{
			begin();
			command.removeWriteOffRequest(event.getDeleteWriteOffRequestVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0807 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRecoveryActivity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0807Event event = (EsdTpb0807Event)e;
		RecoveryActivityManageBC command = new RecoveryActivityManageBCImpl();
		try{
			begin();
			command.multiRecoveryActivity(event.getSearchRecoveryActivityListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * ESD_TPB_0812 : [이벤트]<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiIndiaTaxInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0812Event event = (EsdTpb0812Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();
		try{
			begin();
			command.multiIndiaTaxInfo(event.getSearchIndiaTaxInfoVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
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
	 * Account Code, Name<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAcctCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceManageBC command = new InvoiceManageBCImpl();
		try{
			List<TpbComboVO> list = command.searchAcctCd();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Terminal Name, ATD 조회<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchInvYdNmAtd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0110Event event = (EsdTpb0110Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();

		try{
			List<SearchOutstandingDetailListForInvoiceCreationVO> outputVO = command.searchYdNmAtd(event.getInvoiceCreationVO());
			eventResponse.setETCData("atd", outputVO.get(0).getAtd());
			eventResponse.setETCData("yd_nm", outputVO.get(0).getYdNm());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Terminal Name, ATD 조회<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchInvRvisYdNmAtd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTpb0111Event event = (EsdTpb0111Event)e;
		InvoiceManageBC command = new InvoiceManageBCImpl();

		try{
			List<SearchOutstandingDetailListForInvoiceCreationVO> outputVO = command.searchYdNmAtd(event.getInvoiceCreationVO());
			eventResponse.setETCData("atd", outputVO.get(0).getAtd());
			eventResponse.setETCData("yd_nm", outputVO.get(0).getYdNm());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Roc Rollback 수행<br>
	 *
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkRocRollback(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceManageBC command = new InvoiceManageBCImpl();

		String ofcCd = (String)e.getAttribute("ofcCd");
		String userId = (String)e.getAttribute("userId");
		String n3ptyNo = (String)e.getAttribute("n3ptyNo");

		try{
			String result= command.checkRocRollback(ofcCd, userId, n3ptyNo);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse; 
	}	
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DodDropOffSC.java
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.28
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.10.28 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.basic.DropOffCreationBC;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.basic.DropOffCreationBCImpl;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event.EesDod0001Event;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event.EesDod0002Event;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event.EesDod0012Event;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.event.EesDod0013Event;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration.DropOffCreationDBDAO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.DropOffDiscountDetailVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.vo.SearchDodDrpOffChgVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.basic.DropOffInquiryBC;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.basic.DropOffInquiryBCImpl;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.event.EesDod0003Event;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.event.EesDod0004Event;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.event.EesDod0011Event;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryDetailListVO;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.vo.DropOffInvoiceInquiryListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.bizcommon.authorization.util.AuthorizationApprovalUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-DodDropOff Business Logic ServiceCommand - ALPS-DodDropOff 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Son, Jin-Hwan
 * @see DropOffCreationDBDAO
 * @since J2EE 1.6
 */

public class DodDropOffSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * DodDropOff system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("DodDropOffSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * DodDropOff system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("DodDropOffSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-DodDropOff system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesDod0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDodDrpOffChgVOList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	
				eventResponse = searchDodDrpOffChgVOList2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //Save > AR-IF
				eventResponse = manageArInvList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //Save
				eventResponse = manageRemarkList(e);	
			}
			/*
			else if ( e.getFormCommand().isCommand(FormCommand.COMMAND01) ) { //AR-IF
        		eventResponse = createInvoiceData(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.COMMAND02) ) { //BackEndJob (DOD_DRP_OFF_CHG 테이블 insert)
        		eventResponse = doBackEndJob(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.COMMAND03) ) { //BackEndJob
        		eventResponse = checkBackEndJob(e);
        	}
        	*/
		}else if (e.getEventName().equalsIgnoreCase("EesDod0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMnlDodDrpOffChgVOList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchTariffForRTNCY(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageArInvList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesDod0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDropOffQueueListInquiryList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesDod0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDropOffInoviceInquiryList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesDod0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDropOffInoviceInquiryListDetail(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesDod0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDropOffDiscountDetail(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesDod0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCrrDodDrpOffChgVO(e); //opner EES_DOD_0001
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCrrDodDrpOffChgVOList(e); //opner EES_DOD_0004
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchInvErpIfStsCd(e); // Correction AR INV 수행 전에 이전 AR INV 수행 건에 대한 I/F 상태값을 가져온다.
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchTariffForRTNCY1(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchTariffForRTNCY2(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageArInvList(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchDodDrpOffChgVOList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0001Event event = (EesDod0001Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			List<SearchDodDrpOffChgVO> list = command.searchDodDrpOffChgVOList(event.getSearchDodDrpOffChgVO());
			eventResponse.setRsVoList(list);
			
			// 면제 대상을 조회합니다
			List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOs = command.searchDodDrpOffChgVOExptList(event.getSearchDodDrpOffChgVO());
			
			// 면제건에 대상을 DOD_DRP_OFF_CHG 테이블에 저장합니다.
			begin();
			   //if(!event.getSearchDodDrpOffChgVO().getOfcCd().equals("GOASC")) {
			      command.manageDodDrpOffChgVOExptList(searchDodDrpOffChgVOs, account.getUsr_id());
			   //}   
			commit();
			
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0001 : [SEARCH]<br>
	 * [Drop Off Charge 대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchDodDrpOffChgVOList2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0001Event event = (EesDod0001Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			List<SearchDodDrpOffChgVO> list = command.searchDodDrpOffChgVOList2(event.getSearchDodDrpOffChgVO());
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0001 : [COMMAND01]<br>
	 * [ARInterface]을 [생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse createInvoiceData(Event e) throws EventException {
		DropOffCreationBC command = new DropOffCreationBCImpl();
		GeneralARInvoiceCreationBC commandAR	= new GeneralARInvoiceCreationBCImpl("DEFAULTXA");//2011.01.07 XA DataSource생성
		
		GeneralEventResponse eventResponse 		= new GeneralEventResponse();
		
        List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
		
		Map<String,String> etcData = new HashMap<String,String>();
		String ar_if_no = "";
		String msg = "";
		
		SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs = null;
		
		try {
			if(e instanceof EesDod0001Event) { // Invoice Creation
				EesDod0001Event event = (EesDod0001Event)e;
				searchDodDrpOffChgVOs = event.getSearchDodDrpOffChgVOS();
				
				for(int i = 0; i < searchDodDrpOffChgVOs.length; i ++) {
					genIfVOs = new ArrayList<ARInterfaceCreationVO>();
					arInterfaceCreationVO = command.searchARInterfaceInvoice(searchDodDrpOffChgVOs[i]);
					
					genIfVOs.add(arInterfaceCreationVO);
					
					//----> AR INTERFACE CALL
					begin();
					
					rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
					ar_if_no = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);

					if(ar_if_no == null || ar_if_no.equals("")) {
		            	etcData.put("SUCCESS_YN", "N");
		            	log.error("\n AR_IF_NO NULL===============");
		            	msg = new ErrorHandler("DOD00003").getUserMessage();
		            	eventResponse.setUserMessage(JSPUtil.replace(msg, "XXXXXXXXX", arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()));
		            	log.error("\n "+JSPUtil.replace(msg, "XXXXXXXXX", arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()));
		            	
		                rollback();
		            }else{
		            	String ar_if_no_arr[] = ar_if_no.split("::");
		            	if(ar_if_no_arr[0].equals("S")){
		            		
		            		commit();
		            		// <---- AR INTERFACE CALL
		            		
		            		// DOD_DRP_OFF_CHG table update
		            		command.modifyARInterface(searchDodDrpOffChgVOs[i].getBkgNo(), searchDodDrpOffChgVOs[i].getCntrNo(), searchDodDrpOffChgVOs[i].getDrpOffChgSeq(), ar_if_no_arr[1], arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo());
		        			
		    				etcData.put("SUCCESS_YN", "Y");
		    				
		    				log.debug("event.getAuthAproRqstNo() : " + event.getAuthAproRqstNo());
		    				
		    				//사후결재 AUTH_APRO_RQST_NO update
		    				if(event.getAuthAproRqstNo() != null && !"".equals(event.getAuthAproRqstNo())){
		    					AuthorizationApprovalUtil authorizationApprovalUtil = new AuthorizationApprovalUtil();
		    					authorizationApprovalUtil.updateAuthAproCfm(event.getAuthAproRqstNo());
		    				}
		    				
		            	}else{
		            		commit();
			            	etcData.put("SUCCESS_YN", "N");
			            	log.error("\n AR_IF_NO NULL===============");
			            	msg = new ErrorHandler("DOD00003").getUserMessage();
			            	eventResponse.setUserMessage(JSPUtil.replace(msg, "XXXXXXXXX", arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()));
			            	log.error("\n "+JSPUtil.replace(msg, "XXXXXXXXX", arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()));

		            	}
		            }

				}// for end
				
				eventResponse.setETCData(etcData);
			}else if(e instanceof EesDod0002Event) { // Manual Invoice Creation
				
			}else if(e instanceof EesDod0013Event) { // Correction
				if(e instanceof EesDod0002Event) { // before AR INV
					
				}else if(e instanceof EesDod0002Event) { // after AR INV
					
				}
			}
		} catch(EventException ex) {
            etcData.put("SUCCESS_YN", "N");
            log.error("EventException " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch(Exception ex){
            etcData.put("SUCCESS_YN", "N");
            log.error("Exception " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
		return eventResponse;
	}
	*/
	/**
	 * EES_DOD_0001 : [COMMAND02]<br>
	 * [Drop Off Charge대상]을 [DOD_DRP_OFF_CHG 테이블에 저장]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse doBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DropOffCreationBC command = new DropOffCreationBCImpl();
		
		try{
			EesDod0001Event event = (EesDod0001Event)e;
			String backEndJobKey = null;
			
			//BackEndJob 모듈을 호출한다.
			backEndJobKey = command.doBackEndJob(event.getSearchDodDrpOffChgVOS(), account);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		} 
		return eventResponse;
	}
	*/
	/**
	 * EES_DOD_0001 : [COMMAND03]<br>
	 * Long Tx 상태 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	/*
	private EventResponse checkBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DropOffCreationBC command = new DropOffCreationBCImpl();
		
		try{
			EesDod0001Event event = (EesDod0001Event)e;
			
			//BackEndJob 모듈의 현재 작업상태와  오류 발생시 오류 메세지를 조회한다.
			String[] result = command.checkBackEndJob(event.getSearchDodDrpOffChgVO().getBackendjobKey());
			eventResponse.setETCData("jb_sts_flg",		result[0]);
			eventResponse.setETCData("jb_usr_err_msg",	result[1]);
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}  
	*/
	/**
	 * EES_DOD_0002 : [SEARCH]<br>
	 * [Drop Off Charge 대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMnlDodDrpOffChgVOList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0002Event event = (EesDod0002Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			List<SearchDodDrpOffChgVO> list = command.searchMnlDodDrpOffChgVOList(event.getSearchDodDrpOffChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0002 : [SEARCH09]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffForRTNCY(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0002Event event = (EesDod0002Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			SearchDodDrpOffChgVO chgVO = command.searchTariffForRTNCY(event.getBkgNo(), event.getCntrNo(), event.getCntrRtnYdCd(), event.getSpclCdSeq());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("currCd", chgVO.getCurrCd());
			etcData.put("drpOffChgTrfSeq", chgVO.getDrpOffChgTrfSeq());
			etcData.put("genTrfAmt", chgVO.getGenTrfAmt());
			etcData.put("drpOffChgTrfSpclSeq", chgVO.getDrpOffChgTrfSpclSeq());
			etcData.put("spclTrfAmt", chgVO.getSpclTrfAmt());
			
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * EES_DOD_0013 : [SEARCH]<br>
	 * [EES_DOD_0001에서 호출하여 AR INV 보내기전 RTN CY를 변경할 대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrrDodDrpOffChgVO(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0013Event event = (EesDod0013Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			List<SearchDodDrpOffChgVO> list = command.searchCrrDodDrpOffChgVO(event.getSearchDodDrpOffChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH01]<br>
	 * [EES_DOD_0004에서 호출하여 AR INV 보내고 난 후 CY를 변경할 대상]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrrDodDrpOffChgVOList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0013Event event = (EesDod0013Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			List<SearchDodDrpOffChgVO> list = command.searchCrrDodDrpOffChgVOList(event.getSearchDodDrpOffChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH02]<br>
	 * [Correction AR INV 수행 전에 이전 AR INV 수행 건에 대한 I/F 상태값]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvErpIfStsCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0013Event event = (EesDod0013Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			String invErpIfStsCd = command.searchInvErpIfStsCd(event.getSearchDodDrpOffChgVO());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("INV_ERP_IF_STS_CD", invErpIfStsCd);
			
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH08]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffForRTNCY1(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0013Event event = (EesDod0013Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			SearchDodDrpOffChgVO chgVO = command.searchTariffForRTNCY1(event.getBkgNo(), event.getCntrNo(), event.getCntrRtnYdCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("currCd", chgVO.getCurrCd());
			etcData.put("drpOffChgTrfSeq", chgVO.getDrpOffChgTrfSeq());
			etcData.put("genTrfAmt", chgVO.getGenTrfAmt());
			etcData.put("drpOffChgTrfSpclSeq", chgVO.getDrpOffChgTrfSpclSeq());
			etcData.put("spclTrfAmt", chgVO.getSpclTrfAmt());
			
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0013 : [SEARCH09]<br>
	 * [RTN CY에 해당 하는]을 [Curruncy, General Tariff, Special Tariff를 조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTariffForRTNCY2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0013Event event = (EesDod0013Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			SearchDodDrpOffChgVO chgVO = command.searchTariffForRTNCY2(event.getBkgNo(), event.getCntrNo(), event.getCntrRtnYdCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("currCd", chgVO.getCurrCd());
			etcData.put("drpOffChgTrfSeq", chgVO.getDrpOffChgTrfSeq());
			etcData.put("genTrfAmt", chgVO.getGenTrfAmt());
			etcData.put("drpOffChgTrfSpclSeq", chgVO.getDrpOffChgTrfSpclSeq());
			etcData.put("spclTrfAmt", chgVO.getSpclTrfAmt());
			

			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0001 / EES_DOD_0002 / EES_DOD_0013 : [MULTI]<br>
	 * [Drop Off Charge대상]을 [AR로 보내어 Invoice를 생성]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageArInvList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		DropOffCreationBC command = new DropOffCreationBCImpl();
		GeneralARInvoiceCreationBC commandAR = new GeneralARInvoiceCreationBCImpl();
		
		List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList = null;
		
        List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
		
		Map<String,String> etcData = new HashMap<String,String>();
		String ar_if_no = "";
		String msg = "";
		String authAproRqstNo = "";
		String opener = "";
		
		StringBuffer sb_ar_err_msg = new StringBuffer();
		StringBuffer sb_err_inv = new StringBuffer(); 
		
		int total_cnt = 0;
		int success_cnt = 0;
		int fail_cnt = 0;
		
		String curBkgNo = "";
		String curCntrNo = "";
		String curDrpOffChgSeq = "";
		
		SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs = null;
		
		try {
			
			
			if(e instanceof EesDod0001Event) { // Invoice Creation				
				EesDod0001Event event = (EesDod0001Event)e;
				
				authAproRqstNo = event.getAuthAproRqstNo();
				searchDodDrpOffChgVOs = event.getSearchDodDrpOffChgVOS();
				
				log.debug("\r >>> Creation >>>>>>> searchDodDrpOffChgVOs.length : " + searchDodDrpOffChgVOs.length );
				
				if(account.getUsr_id().equals("2000362")){
					searchDodDrpOffChgVOList = command.manageArInvList(searchDodDrpOffChgVOs, "SYSTEM");
				}
				else{
				    searchDodDrpOffChgVOList = command.manageArInvList(searchDodDrpOffChgVOs, account.getUsr_id());
				}
				
			}else if(e instanceof EesDod0002Event) { // Manual Invoice Creation
				EesDod0002Event event = (EesDod0002Event)e;
				
				authAproRqstNo = event.getAuthAproRqstNo();
				searchDodDrpOffChgVOs = event.getSearchDodDrpOffChgVOS();
				
				log.debug("\r >>> Manual >>>>>>> searchDodDrpOffChgVOs.length : " + searchDodDrpOffChgVOs.length );
				searchDodDrpOffChgVOList = command.manageMnlArInvList(searchDodDrpOffChgVOs, account.getUsr_id(), account.getOfc_cd());
				
			}else if(e instanceof EesDod0013Event) { // Correction
				EesDod0013Event event = (EesDod0013Event)e;
				
				opener = event.getOpener();
				authAproRqstNo = event.getAuthAproRqstNo();
				searchDodDrpOffChgVOs = event.getSearchDodDrpOffChgVOS();
				
				log.debug("\r >>> Correction >>>>>>> searchDodDrpOffChgVOs.length : " + searchDodDrpOffChgVOs.length );
				searchDodDrpOffChgVOList = command.manageCrrArInvList(searchDodDrpOffChgVOs, account.getUsr_id(), event.getOpener(), account.getOfc_cd());
				
			}
			
			total_cnt = searchDodDrpOffChgVOList.size();
			log.debug("\r >>>>>>>>>> total_cnt : " + total_cnt );
			
			for(int i = 0; i < searchDodDrpOffChgVOList.size(); i ++) {
				/* 현재 BKG_NO, CNTR_NO, DOD_DRP_OFF_SEQ를 저장 > I/F중 에러발생시 제거할 용도. */
				curBkgNo = searchDodDrpOffChgVOList.get(i).getBkgNo();
				curCntrNo = searchDodDrpOffChgVOList.get(i).getCntrNo();
				curDrpOffChgSeq = searchDodDrpOffChgVOList.get(i).getDrpOffChgSeq();
				/* --------------------------------------------------------------- */
				
				genIfVOs = new ArrayList<ARInterfaceCreationVO>();

				arInterfaceCreationVO = command.searchARInterfaceInvoice(searchDodDrpOffChgVOList.get(i));
				
				genIfVOs.add(arInterfaceCreationVO);
				
				//--Start--> AR INTERFACE CALL
				begin();
				
				rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
				ar_if_no = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
				
				if(ar_if_no == null || ar_if_no.equals("")) {
					log.error("\n AR_IF_NO NULL===============");
					fail_cnt++;
					sb_err_inv.append(arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()).append(" ");
					rollback();
				}else{
					String ar_if_no_arr[] = ar_if_no.split("::");
					if(ar_if_no_arr[0].equals("S")){
						
						commit();
						// <--End-- AR INTERFACE CALL
						
						success_cnt++;
						log.error("\n DOD_DRP_OFF_CHG table update=============== " + searchDodDrpOffChgVOList.get(i).getBkgNo() + " | " + searchDodDrpOffChgVOList.get(i).getCntrNo() + " | " + searchDodDrpOffChgVOList.get(i).getDrpOffChgSeq() + " | " + ar_if_no_arr[1] + " | " + searchDodDrpOffChgVOList.get(i).getInvSrcNo());
						// DOD_DRP_OFF_CHG table update
						command.modifyARInterface(searchDodDrpOffChgVOList.get(i).getBkgNo(), searchDodDrpOffChgVOList.get(i).getCntrNo(), searchDodDrpOffChgVOList.get(i).getDrpOffChgSeq(), ar_if_no_arr[1], searchDodDrpOffChgVOList.get(i).getInvSrcNo());
						
						etcData.put("SUCCESS_YN", "Y");
						
						log.debug("event.getAuthAproRqstNo() : " + authAproRqstNo);
						
						
						// send ERP
						begin();
						commandAR.interfaceARInvoiceToERPAR(ar_if_no_arr[1]);
						commit();
						
						log.debug("event.getOpener() : " + opener);
						
						if("EES_DOD_0004".equals(opener)) { // Invoice Inquiry에서 호출시에는 BKG TRO테이블에도 적용한다.
							if(i%2 != 0){// Correction하면 2개의 Invoice가 생성되니 변경된 Invoice를 발행했을 때 업데이트해준다.
								log.debug("Booking TRO - [ CNTR_RTN_YD_CD ] Update : Start");
								// Correction에서 변경한 RTN_CY를 Booking TRO에 반영한다.
								TransferOrderIssueBC commandTRO  = new TransferOrderIssueBCImpl();
								EurTroMstVO eurTroMstVO = new EurTroMstVO();
								eurTroMstVO.setBkgNo(searchDodDrpOffChgVOList.get(i).getBkgNo());
								eurTroMstVO.setCntrNo(searchDodDrpOffChgVOList.get(i).getCntrNo());
								eurTroMstVO.setCntrRtnYdCd(searchDodDrpOffChgVOList.get(i).getCntrRtnYdCd());
								eurTroMstVO.setUpdUsrId(account.getUsr_id());								
								commandTRO.modifyEurTroCyInfo(eurTroMstVO);
								
								log.debug("bkg_no : " + eurTroMstVO.getBkgNo() + ", cntr_no : " + eurTroMstVO.getCntrNo() + ", cntr_rtn_yd_cd : " + eurTroMstVO.getCntrRtnYdCd());								
								log.debug("Booking TRO - [ CNTR_RTN_YD_CD ] Update : End");
							}
						}

						log.debug("\r >>>>>>>>>>>>>> Discount Amount : " + searchDodDrpOffChgVOList.get(i).getDcAmt());
						//사후결재 AUTH_APRO_RQST_NO update
						if(authAproRqstNo != null && !"".equals(authAproRqstNo)){
							AuthorizationApprovalUtil authorizationApprovalUtil = new AuthorizationApprovalUtil();
							authorizationApprovalUtil.updateAuthAproCfm(authAproRqstNo);
							log.debug("Aproval - [ CFM_FLG ] : Updated");
							
							//DOD_DRP_OFF_CHG - AUTH_APRO_RQST_NO 컬럼 값 update
							command.modifyARInterfaceAuth(searchDodDrpOffChgVOList.get(i).getBkgNo(), searchDodDrpOffChgVOList.get(i).getCntrNo(), searchDodDrpOffChgVOList.get(i).getDrpOffChgSeq(), authAproRqstNo);
							log.debug("Aproval - [ AUTH_APRO_RQST_NO ] : Updated");
						}
						
					}else{
						fail_cnt++;
						commit();
						etcData.put("SUCCESS_YN", "N");
						// AR Interface 전송에 실패한 대상을 DOD_DRP_OFF_CHG테이블에서 삭제한다.
						command.deleteDodDrpOffChg(curBkgNo, curCntrNo, curDrpOffChgSeq);
						sb_ar_err_msg.append(arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()).append("|");
						
						log.debug("\n AR_IF_ERROR MSG===============>["+arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()+"]"+ar_if_no_arr[1]);
						sb_err_inv.append(arInterfaceCreationVO.getInvArIfMnVO().getInvSrcNo()).append(" ");
					}
				}
				
			}// for end
			
			if(total_cnt > 1) {
				msg = new ErrorHandler("DOD00007").getUserMessage();
				log.debug("ErrorHandler(DOD00007).getUserMessage() >>>> " + msg);
				msg = JSPUtil.replace(msg, "$1", ""+total_cnt);
				msg = JSPUtil.replace(msg, "$2", ""+success_cnt);
				msg = JSPUtil.replace(msg, "$3", ""+fail_cnt);
				
				if(fail_cnt > 0) {
					msg = JSPUtil.replace(msg, "XXX123456", ""+sb_err_inv.toString());				
				}else{
					msg = JSPUtil.replace(msg, "(Fail ==> Invoice No: XXX123456)", "");
				}
				
			}else{
				msg = new ErrorHandler("DOD00001").getUserMessage();
			}
			
			eventResponse.setUserMessage(msg);
			eventResponse.setETCData(etcData);
		} catch(EventException ex) {
			rollback();
            etcData.put("SUCCESS_YN", "N");
            // AR Interface 전송에 실패한 대상을 DOD_DRP_OFF_CHG테이블에서 삭제한다.
			command.deleteDodDrpOffChg(curBkgNo, curCntrNo, curDrpOffChgSeq);
            log.error("EventException " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch(Exception ex){
        	rollback();
            etcData.put("SUCCESS_YN", "N");
            // AR Interface 전송에 실패한 대상을 DOD_DRP_OFF_CHG테이블에서 삭제한다.
			command.deleteDodDrpOffChg(curBkgNo, curCntrNo, curDrpOffChgSeq);
            log.error("Exception " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
        	throw new EventException(ex.getMessage(), ex);
        } 
		/*
		 * BackEndJob 사용할때
		try{
			String key = event.getSearchDodDrpOffChgVO().getBackendjobKey();
			List<SearchDodDrpOffChgVO> list = (List<SearchDodDrpOffChgVO>)BackEndJobResult.loadFromFile(key);
			eventResponse.setRsVoList(list);
			eventResponse.setUserMessage((String) new ErrorHandler("DOD00001",new String[]{}).getUserMessage());
			
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		*/	
		return eventResponse;
	}

	/**
	 * EES_DOD_0003 : [SEARCH]<br>
	 * DOD Queue List Inqiury<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDropOffQueueListInquiryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0003Event event = (EesDod0003Event)e;
		DropOffInquiryBC command = new DropOffInquiryBCImpl();

		try{
			List<SearchDodDrpOffChgVO> list = command.searchDropOffQueueListInquiryList(event.getSearchDodDrpOffChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0004 : [SEARCH]<br>
	 * Drop Off Invoice Inqiury<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDropOffInoviceInquiryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0004Event event = (EesDod0004Event)e;
		DropOffInquiryBC command = new DropOffInquiryBCImpl();

		try{
			List<DropOffInvoiceInquiryListVO> list = command.searchDropOffInvoiceInquiryList(event.getDropOffInvoiceInquiryINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0011 : [SEARCH]<br>
	 * Drop Off Invoice Inqiury Detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDropOffInoviceInquiryListDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0011Event event = (EesDod0011Event)e;
		DropOffInquiryBC command = new DropOffInquiryBCImpl();

		try{
			List<DropOffInvoiceInquiryDetailListVO> list = command.searchDropOffInvoiceInquiryDetailList(event.getDropOffInvoiceInquiryINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0012 : [SEARCH]<br>
	 * Discount Detail<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDropOffDiscountDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EesDod0012Event event = (EesDod0012Event)e;
		DropOffCreationBC command = new DropOffCreationBCImpl();

		try{
			List<DropOffDiscountDetailVO> list = command.searchDropOffDiscountDetail(event.getAuthAproRqstNo());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * EES_DOD_0001 : [MULTI01]<br>
	 * [Drop Off Charge대상]을 [AR로 보내지 않고 GOASC 오피스만 저장한다]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRemarkList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		Map<String,String> etcData = new HashMap<String,String>();
		DropOffCreationBC command = new DropOffCreationBCImpl();
		List<SearchDodDrpOffChgVO> searchDodDrpOffChgVOList = null;

		SearchDodDrpOffChgVO[] searchDodDrpOffChgVOs = null;
		
		try {

			if(e instanceof EesDod0001Event) { // Invoice Creation Save - GOASC			
				EesDod0001Event event = (EesDod0001Event)e;
	
				searchDodDrpOffChgVOs = event.getSearchDodDrpOffChgVOS();
				
				log.debug("\r >>> Creation >>>>>>> searchDodDrpOffChgVOs.length : " + searchDodDrpOffChgVOs.length );
				searchDodDrpOffChgVOList = command.manageRemarkList(searchDodDrpOffChgVOs, account.getUsr_id());
				
			}
			
			etcData.put("SUCCESS_YN", "Y");
			eventResponse.setETCData(etcData);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
}
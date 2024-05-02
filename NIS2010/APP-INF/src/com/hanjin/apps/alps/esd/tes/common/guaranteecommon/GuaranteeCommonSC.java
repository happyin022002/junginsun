/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeCommonSC.java
*@FileTitle : GuaranteeCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.22 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.guaranteecommon;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBC;
import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.event.EsdTes2004Event;
import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.event.GuaranteeCommonEvent;
import com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration.GuaranteeCommonDBDAO;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBC;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;


/**
 * ALPS-GuaranteeCommon Business Logic ServiceCommand - ALPS-GuaranteeCommon 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author yOng hO lEE
 * @see GuaranteeCommonDBDAO
 * @since J2EE 1.6
 */

public class GuaranteeCommonSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * GuaranteeCommon system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("GuaranteeCommonSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * GuaranteeCommon system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("GuaranteeCommonSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-GuaranteeCommon system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
			/* Guarantee Reference No	*/ 
			if (e.getEventName().equalsIgnoreCase("EsdTes2004Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					//Reference No. Select
					eventResponse = searchRefNoList(e);
				}
			}
				
			/* Guarantee Common	*/ 
			if (e.getEventName().equalsIgnoreCase("GuaranteeCommonEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					// Guarantee Container Info ( Bkg No, Bl No, VVD ) Search
					eventResponse = searchUSGuaranteeCntrInfo(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					// Customer Code Valid Check
					eventResponse = validateCustomerCode(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					// NonTPB Delete Flag Check
					eventResponse = checkNonTPB(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					// Container No. Duplication Check.
					eventResponse = checkDupCntr(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
					// Guarantee Container Booking No Search => SEARCH01
					eventResponse = searchCntrBkgNo(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
					// TPB I/F and Irregular Type Valid Check for Print
					eventResponse = searchValidChkForPrint(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
					// CNTR Count Valid Check for Irregular Print
					eventResponse = searchIrrPrintChk(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
					// Guarantee Container Info ( Bkg No, Bl No, VVD ) Search
					eventResponse = searchMstCntrExist(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
					// Guarantee Creation Grid에 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인
					eventResponse = searchUSGuaranteeCntrDupChk(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
					// Guarantee Creation Save 시 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인
					eventResponse = searchUSGuaranteeCntrDupChk2(e);
				}
		}
		return eventResponse;
	}

	/**
	 * ESD_TES_2004 : [이벤트]<br>
	 * [Reference No(Guarantee No. Or Irregular No.)]를 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRefNoList(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchRefNoList] \n");
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2004Event			event			= (EsdTes2004Event)e;

		try {
			eventResponse.setRsVoList( command.searchRefNoList( event.getGuaranteeCommonVO() ) );
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * GuaranteeCommon : [이벤트]<br>
	 * [Guarantee Container Info]를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSGuaranteeCntrInfo(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchUSGuaranteeCntrInfo] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

		try{
			eventResponse.setRs		( command.searchUSGuaranteeCntrInfo	( event.getGuaranteeCommonVO() ) );
			
			eventResponse.setETCData	("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );
			
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
	 * GuaranteeCommon : [이벤트]<br>
	 * Guarantee Creation Grid에 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSGuaranteeCntrDupChk(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchUSGuaranteeCntrDupChk] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

		try{
			eventResponse.setRs		( command.searchUSGuaranteeCntrDupChk	( event.getGuaranteeCommonVO() ) );
			
			eventResponse.setETCData	("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );
			
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
	 * GuaranteeCommon : [이벤트]<br>
	 * Guarantee Creation Save 시 CNTR NO, BKG NO, Vendor code, Cust Code로 기존에 존재하는 data가 있는지 여부를 확인.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSGuaranteeCntrDupChk2(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchUSGuaranteeCntrDupChk] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;
		
		try{
			eventResponse.setRs		( command.searchUSGuaranteeCntrDupChk2	( event.getGuaranteeCommonVO() ) );
			eventResponse.setETCData	("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );
			
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
	 * GuaranteeCommon : [이벤트]<br>
	 * [Master Container 에 CNTR 존재여부]를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMstCntrExist(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchMstCntrExist] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

		try{
			eventResponse.setRs		( command.searchMstCntrExist	( event.getGuaranteeCommonVO() ) );
			
			eventResponse.setETCData	("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );
			
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
	 * GuaranteeCommon : [이벤트]<br>
	 * [Customer Code Validate]를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateCustomerCode(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][validateCustomerCode] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

		try{
			eventResponse.setRs	( command.validateCustomerCode	( event.getGuaranteeCommonVO() ) );
			
			eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );

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
	 * GuaranteeCommon : [이벤트]<br>
	 * [TPB I/F된 대상 Delete 여부 Flag]를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkNonTPB(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][checkNonTPB] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

		TPBInterfaceBC			tpbIfCommand	= new TPBInterfaceBCImpl();
		List<TesGnteCntrListVO>	list			= null;
		TesGnteCntrListVO		tesGnteCntrListVO	= null;
		TPBInterfaceVO	[]		tpbInterfaceVOs	= null;
		String	[]				tpbResult		= null;
		String					retStr			= "";

		try{
			// TPB I/F checkNonTPB SC로 이동.
			list	= command.checkNonTPB	( event.getTesGnteCntrListVO() );
			
			tpbInterfaceVOs = new TPBInterfaceVO[list.size()];
			
			for ( int i = 0; list != null && i < list.size(); i++ ) {
				tesGnteCntrListVO	= (TesGnteCntrListVO)list.get(i); //new TPBInterfaceVO();
				tpbInterfaceVOs[i]	= new TPBInterfaceVO();

				tpbInterfaceVOs[i].setTmlIfOfcCd	( tesGnteCntrListVO.getTmlIfOfcCd() );
				tpbInterfaceVOs[i].setTmlIfSeq		( tesGnteCntrListVO.getTmlIfSeq() );
			}

			tpbResult = tpbIfCommand.searchTpbTesDltFlg( tpbInterfaceVOs );

			for ( int i = 0; tpbResult != null && i < tpbResult.length; i++ ) {
				if ( retStr.length() > 0 ) retStr	= retStr + "|";
				retStr	= retStr + tpbResult[i];
			}

			
			// ETC_KEY_NAME 으로 대신.
			eventResponse.setETCData(event.getGuaranteeCommonVO().getOid(), retStr );
			
//			eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );

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
	 * GuaranteeCommon : [이벤트]<br>
	 * [Container No. Duplication]을 [Check] 합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDupCntr(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchCntrBkgNo] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

//		boolean			isSuccess	= false;
		
		try{
//			isSuccess	= command.checkDupCntr	( event.getGuaranteeCommonVO() );
			
			eventResponse.setETCData("success_flg", String.valueOf( command.checkDupCntr	( event.getGuaranteeCommonVO() ) ) );
			
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
	 * GuaranteeCommon : [이벤트]<br>
	 * [Guarantee Container Booking No]를 [Select]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrBkgNo(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchCntrBkgNo] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

		try{
			eventResponse.setRs	( command.searchCntrBkgNo	( event.getGuaranteeCommonVO() ) );
			eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );
			
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
	 * GuaranteeCommon : [이벤트]<br>
	 * Guarantee Inquiry Print valid check를 위한 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchValidChkForPrint(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchValidChkForPrint] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

		try{
			eventResponse.setRs	( command.searchValidChkForPrint	( event.getGuaranteeCommonVO() ) );
			eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );
			
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
	 * GuaranteeCommon : [이벤트]<br>
	 * Irregular Inquiry Print valid check를 위한 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrrPrintChk(Event e) throws EventException {
		log.debug("\n\n [GuaranteeCommonSC][searchIrrPrintChk] \n");
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeCommonBC		command			= new GuaranteeCommonBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		GuaranteeCommonEvent	event			= (GuaranteeCommonEvent)e;

		try{
			eventResponse.setRs	( command.searchIrrPrintChk	( event.getGuaranteeCommonVO() ) );
			eventResponse.setETCData("ETC_KEY_NAME", event.getGuaranteeCommonVO().getOid() );
			
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
}
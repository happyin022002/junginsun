/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeManageSC.java
*@FileTitle : Guarantee Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.guaranteemanage;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.basic.GuaranteeManageBC;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.basic.GuaranteeManageBCImpl;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2001Event;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2002Event;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2003Event;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.integration.GuaranteeManageDBDAO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeListVO;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.basic.IrregularManageBC;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.basic.IrregularManageBCImpl;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2006Event;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2007Event;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.basic.TPBInterfaceManageBC;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.basic.TPBInterfaceManageBCImpl;
import com.hanjin.apps.alps.esd.tes.guaranteemanage.tpbinterfacemanage.event.EsdTes2008Event;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.hanjin.apps.alps.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesGnteCntrListVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;


/**
 * ALPS-GuaranteeManage Business Logic ServiceCommand - ALPS-GuaranteeManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author yOng hO lEE
 * @see GuaranteeManageDBDAO
 * @since J2EE 1.6
 */
public class GuaranteeManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * GuaranteeManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("GuaranteeManageSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * GuaranteeManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("GuaranteeManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-GuaranteeManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		/**
		 * Guarantee Creation & Adjustment
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Guarantee Search ( Header & Container List )
				eventResponse = searchUSGuaranteeHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				// Guarantee Creation Save ( Header )
				eventResponse = addUSGuaranteeHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				// Guarantee Creation Save ( Header )
				eventResponse = modifyUSGuaranteeHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// Guarantee Creation Save ( Container List )
				eventResponse = multiUSGuaranteeCntrList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				// Guarantee Creation Delete ( Header )
				eventResponse = deleteUSGuarantee(e);
			}
		}
		
		
		/**
		 * Guarantee Inquiry Service
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes2002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Guarantee List Inquiry
				eventResponse = searchUSGuaranteeList(e);
			}
		}
		

		/**
		 * printGuaranteeReport
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Send E-mail or Fax
				eventResponse = sendRD(e);
			}
		}
		
		
		/**
		 * Irregular Creation & Adjustment
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes2006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Irregular Search ( Header & Container List )
				eventResponse = searchIrregularHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Guarantee 에서 Irregular 등록할 Container List Search
				eventResponse = searchGuaranteeIrregularList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				// Irregular Creation Save ( Header )
				eventResponse = addIrregularHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				// Irregular Creation Save ( Header )
				eventResponse = modifyIrregularHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// Irregular Creation Save ( Container List )
				eventResponse = multiIrregularCntrList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Guarantee > Irregular Creation Save ( Container List )
				eventResponse = multiGuaranteeIrregularHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				// Irregular Creation Delete ( Header )
				eventResponse = deleteIrregular(e);
			}
		}

		/**
		 * Irregular Inquiry Service
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes2007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Guarantee List Inquiry
				eventResponse = searchIrregularList(e);
			}
		}
		

		/**
		 * Guarantee TPB I/F
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes2008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Guarantee TPB I/F inquiry
				eventResponse = searchGuaranteeTPBIfData(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				// Guarantee TPB I/F Save ( Header )
				eventResponse = sendGuaranteeTPBIfData(e);
			}

		}

		return eventResponse;
	}
	
	/**
	 * ESD_TES_2001 : [이벤트]<br>
	 * [Guarantee Header Info]를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSGuaranteeHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		command			= new GuaranteeManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2001Event			event			= (EsdTes2001Event)e;

		try{
			
			eventResponse.setRsVoList	( command.searchUSGuaranteeCntrList	( event.getTesGnteHdrVO() ) );
			eventResponse.setRsVoList	( command.searchUSGuaranteeHdr		( event.getTesGnteHdrVO() ) );
			
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
	 * ESD_TES_2001 : [이벤트]<br>
	 * [Guarantee Header Info]을 [Insert] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addUSGuaranteeHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		command			= new GuaranteeManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2001Event			event			= (EsdTes2001Event)e;
		
		String			gnteNo	= "";
		
		try{
			begin();
			gnteNo	= command.addUSGuaranteeHdr(event.getTesGnteHdrVO(), account);
			
			eventResponse.setETCData("gnte_no", gnteNo);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}
	
	/**
	 * ESD_TES_2001 : [이벤트]<br>
	 * [Guarantee Header Info]을 [Update] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyUSGuaranteeHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		command			= new GuaranteeManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2001Event			event			= (EsdTes2001Event)e;
		
		try{
			begin();
			command.modifyUSGuaranteeHdr(event.getTesGnteHdrVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}
	
	/**
	 * ESD_TES_2001 : [이벤트]<br>
	 * [Guarantee Container List]을 [Insert/Update/Delete] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiUSGuaranteeCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		command			= new GuaranteeManageBCImpl();
		EsdTes2001Event			event			= (EsdTes2001Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		try{
			// 컨테이너 중복 조회후 처리.
//			GuaranteeCommonSC.checkDupCntr();
			
			begin();
			command.multiUSGuaranteeCntrList(event.getTesGnteHdrVO(), event.getTesGnteCntrListVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
//		return eventResponse;
		return this.searchUSGuaranteeHdr(e);
	}
	
	
	/**
	 * ESD_TES_2001 : [이벤트]<br>
	 * [Guarantee Header Info ]을 [Delete] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteUSGuarantee(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		command			= new GuaranteeManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2001Event			event			= (EsdTes2001Event)e;
		
		try{
			begin();
			command.deleteUSGuarantee(event.getTesGnteHdrVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}

	
	/**
	 * ESD_TES_2002 : [이벤트]<br>
	 * [Guarantee Header & Container List]을 [Select]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSGuaranteeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		command			= new GuaranteeManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2002Event			event			= (EsdTes2002Event)e;
		SearchUSGuaranteeListVO	searchUSGuaranteeListVO	= new SearchUSGuaranteeListVO();
		
		float		ttlAmt		= 0;
		int			ttlCnt		= 0;
		
		try{
			List<SearchUSGuaranteeListVO>	list	= command.searchUSGuaranteeList(event.getTesGnteHdrVO(), event.getGuaranteeCommonVO() );
			
			if ( list.size() > 0 ) {
				ttlCnt	= list.size();
				for ( int i = 0; i < list.size(); i++ ) {
					searchUSGuaranteeListVO = (SearchUSGuaranteeListVO)list.get(i);
					
					ttlAmt	= ttlAmt + Float.parseFloat( searchUSGuaranteeListVO.getGnteAmt() );
				}
				
			}
			eventResponse.setRsVoList( list );
			eventResponse.setETCData( "ttlCnt", String.valueOf(ttlCnt) );
			eventResponse.setETCData( "ttlAmt", String.valueOf(ttlAmt) );
			
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
	 * ESD_TES_2006 : [이벤트]<br>
	 * [Irregular Header Info]를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrregularHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		IrregularManageBC		command			= new IrregularManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2006Event			event			= (EsdTes2006Event)e;

		try{
			eventResponse.setRsVoList	( command.searchIrregularCntrList 	( event.getTesIrrHdrVO() ) );
			eventResponse.setRsVoList	( command.searchIrregularHdr		( event.getTesIrrHdrVO() ) );
			
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
	 * ESD_TES_2006 : [이벤트]<br>
	 * [Irregular Header Info]을 [Insert] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addIrregularHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		commandGnte		= new GuaranteeManageBCImpl();
		IrregularManageBC		command			= new IrregularManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2006Event			event			= (EsdTes2006Event)e;
		
		String		gnteNo		= "";
		String		irrNo		= "";
		
		try{
			begin();
			// Guarantee Header 에서 넘어(생성)된게 아닌경우. (자체 생성)
			if ( "N".equals( event.getGuaranteeCommonVO().getGnteFlg() ) ) {
				event.getTesGnteHdrVO().setDmyFlg("Y");	// Y 인 경우는 IRR 생성으로 DUMMY GUARANTEE 를 생성해야하는 경우
				gnteNo	= commandGnte.addUSGuaranteeHdr(event.getTesGnteHdrVO(), account);
				
				if ( !"".equals( gnteNo ) ) {
					event.getTesIrrHdrVO().setGnteNo(gnteNo);
				}
			} else {
				gnteNo	= event.getTesIrrHdrVO().getGnteNo();
			}
			
			irrNo	= command.addIrregularHdr(event.getTesIrrHdrVO(), account);
			eventResponse.setETCData("gnte_no", gnteNo);
			eventResponse.setETCData("irr_no", irrNo);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}
	
	/**
	 * ESD_TES_2006 : [이벤트]<br>
	 * [Irregular Header Info]을 [Update] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyIrregularHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
//		GuaranteeManageBC		commandGnte		= new GuaranteeManageBCImpl();
		IrregularManageBC		command			= new IrregularManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2006Event			event			= (EsdTes2006Event)e;
		
		try{
			begin();
			command.modifyIrregularHdr(event.getTesIrrHdrVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}
	
	/**
	 * ESD_TES_2006 : [이벤트]<br>
	 * [Irregular Header Info ]을 [Delete] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteIrregular(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		commandGnte		= new GuaranteeManageBCImpl();
		IrregularManageBC		command			= new IrregularManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2006Event			event			= (EsdTes2006Event)e;
		
		try{
			begin();
			command.deleteIrregular(event.getTesIrrHdrVO(), account);

			// Guarantee Header 에서 넘어(생성)된게 아닌경우. (자체 생성)
			if ( "N".equals( event.getGuaranteeCommonVO().getGnteFlg() ) ) {
				commandGnte.deleteUSGuarantee(event.getTesGnteHdrVO(), account);
			}
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return this.searchIrregularHdr(e);
	}

	
	/**
	 * ESD_TES_2006 : [이벤트]<br>
	 * [Irregular Container List]을 [Insert/Update/Delete] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiIrregularCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		IrregularManageBC		command			= new IrregularManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2006Event			event			= (EsdTes2006Event)e;
		
		try{
			begin();
			command.multiIrregularCntrList(event.getTesIrrHdrVO(), event.getTesGnteCntrListVOs(), event.getGuaranteeCommonVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		
		return this.searchIrregularHdr(e);
	}
	
	
	/**
	 * ESD_TES_2006 : [이벤트]<br>
	 * [Guarantee 에서 Irregular 등록할 Header & Container List Info]를 [Select]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuaranteeIrregularList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		commandGnte		= new GuaranteeManageBCImpl();
		IrregularManageBC		command			= new IrregularManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2006Event			event			= (EsdTes2006Event)e;

		try{
			eventResponse.setRsVoList	( command.searchGuaranteeIrregularCntrList 	( event.getGuaranteeCommonVO() ) );
			eventResponse.setRsVoList	( commandGnte.searchUSGuaranteeHdr			( event.getTesGnteHdrVO() ) );
			
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
	 * ESD_TES_2006 : [이벤트]<br>
	 * [Guarantee 에서 Irregular 등록할 Header]을 [Update/Insert] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiGuaranteeIrregularHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC		commandGnte		= new GuaranteeManageBCImpl();
		IrregularManageBC		command			= new IrregularManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2006Event			event			= (EsdTes2006Event)e;
		
		String					irrNo			= "";
		
		try{
			begin();
			// Guarantee Header Update.
			commandGnte.modifyUSGuaranteeHdr(event.getTesGnteHdrVO(), event.getGuaranteeCommonVO(), account);
			// Irregular Header Insert.
			irrNo	= command.addIrregularHdr(event.getTesIrrHdrVO(), account);
			
			eventResponse.setETCData("irr_no", irrNo);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}
	
	
	/**
	 * ESD_TES_2007 : [이벤트]<br>
	 * [Irregular Header & Container List]을 [Select]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrregularList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		IrregularManageBC		command			= new IrregularManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2007Event			event			= (EsdTes2007Event)e;
		
		try{

			eventResponse.setRsVoList( command.searchIrregularList(event.getTesIrrHdrVO(), event.getGuaranteeCommonVO() ) );
			
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
	 * ESD_TES_2008 : [이벤트]<br>
	 * [Guarantee TPB I/F]을 [Select]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuaranteeTPBIfData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBInterfaceManageBC	command			= new TPBInterfaceManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2008Event			event			= (EsdTes2008Event)e;
		
		try{

			eventResponse.setRsVoList( command.searchGuaranteeTPBIfData( event.getGuaranteeCommonVO() ) );
			
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
	 * ESD_TES_2008 : [이벤트]<br>
	 * [Guarantee TPB I/F]을 [Sending(Insert/Update)] 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendGuaranteeTPBIfData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBInterfaceManageBC	command			= new TPBInterfaceManageBCImpl();
		TPBInterfaceBCImpl		commandTbpIF	= new TPBInterfaceBCImpl();
		EsdTes2008Event			event			= (EsdTes2008Event)e;
		
		TesGnteCntrListVO[]		tesGnteCntrListVOs	= null;
		TesN3rdPtyIfVO[]		tesN3rdPtyIfVOs		= null;

		String		cntrNo		= "";
		String		bkgNo		= "";
		
		int			tpbNotCnt	= 0;
		
		try{
			begin();
			// Revenue VVD Select ( 재무항차 가져오기 )
			tesN3rdPtyIfVOs	= command.searchRevVVDList(event.getTesGnteHdrVO(), event.getTesGnteCntrListVOs(), event.getTesN3rdPtyIfVOs());
			
			// TES_N3RD_PTY_IF에 TPB 정보 저장. 
			// Guarantee 에는 저장이 됐는데 TPB I/F 에러 발생 롤백됐다면..??
			tesGnteCntrListVOs = command.addGuaranteeTPBIfData(event.getTesGnteHdrVO(), event.getTesGnteCntrListVOs(), tesN3rdPtyIfVOs, account);
			commit();

			begin();
			TPBInterfaceVO[]		tpbInterfaceVOs	= new TPBInterfaceVO[tesGnteCntrListVOs.length];

			// TPB IF 값을 설정.
			for ( int i = 0; tpbInterfaceVOs != null && i < tpbInterfaceVOs .length; i++ ) {
				tpbInterfaceVOs[i]	= new TPBInterfaceVO();
				
				tpbInterfaceVOs[i].setTmlIfOfcCd	( (String)tesGnteCntrListVOs[i].getTmlIfOfcCd() );
				tpbInterfaceVOs[i].setTmlIfSeq		( (String)tesGnteCntrListVOs[i].getTmlIfSeq() );
				tpbInterfaceVOs[i].setCsrNoCxlFlg("N");
			}
			
			
			// Revenue VVD 조회 TPB IF 건중에 하나라도 없으면 Return False.
			for ( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) {
				if ("".equals(tesN3rdPtyIfVOs[i].getFincVslCd()) || 
					"".equals(tesN3rdPtyIfVOs[i].getFincSkdVoyNo()) || 
					"".equals(tesN3rdPtyIfVOs[i].getFincSkdDirCd()) ) {
					tpbNotCnt++;
					cntrNo	= tesN3rdPtyIfVOs[i].getCntrNo();
					bkgNo	= tesN3rdPtyIfVOs[i].getBkgNo();
				}
			}
			
			// 재무항차가 한건이라도 없는 경우 IF를 하지 않는다.
			if ( tpbNotCnt > 0 ) {
				throw new EventException(new ErrorHandler("TES00075", new String[]{ cntrNo, bkgNo }).getMessage());
			}
			else {
				// TPB IF 처리.
				if ( commandTbpIF.createTESTPB(tpbInterfaceVOs, account) ) {
					// TES_GNTE_CNTR_LIST 에 IF OFC, IF SEQ UPDATE.
					command.updateGuaranteeTPBIfDataSts(event.getTesGnteHdrVO(), tesGnteCntrListVOs, account);
				}
			}
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return this.searchGuaranteeTPBIfData(e);
	}

	
	/**
	 * Report Designer EMail, FAX 발송.<br> 
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendRD(Event e) throws EventException {
		
		GuaranteeManageBC		command			= new GuaranteeManageBCImpl();
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		EsdTes2003Event			event			= (EsdTes2003Event)e;
		       
		GuaranteeCommonVO		commonVO		= event.getGuaranteeCommonVO();
		
		try{
			/*[E-mail(Start)]*/
			if( commonVO.getEmailAddr() != null && !"".equals(commonVO.getEmailAddr()) ) {
				command.sendEmail(commonVO, account);
			}
			/*[E-mail(End)]*/
			
			/*[FAX(Start)]*/
			if( commonVO.getFaxNum() != null && !"".equals(commonVO.getFaxNum()) ) {
				command.sendFax(commonVO, account);
			}
			/*[FAX(End)]*/
			
			eventResponse.setETCData("email_addrs", commonVO.getEmailAddr());
			eventResponse.setETCData("fax_nums", commonVO.getFaxNum());
			     	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}
	
}
/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : GuaranteeManageSC.java
 * @FileTitle : Guarantee Creation
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion : 1.0
 */
package com.clt.apps.opus.esd.tes.guaranteemanage;

import java.util.List;

import com.clt.apps.opus.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBCImpl;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.basic.GuaranteeManageBC;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.basic.GuaranteeManageBCImpl;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2001Event;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2002Event;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2003Event;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.integration.GuaranteeManageDBDAO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeHdrVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.SearchUSGuaranteeListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.basic.IrregularManageBC;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.basic.IrregularManageBCImpl;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2006Event;
import com.clt.apps.opus.esd.tes.guaranteemanage.irregularmanage.event.EsdTes2007Event;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.basic.TPBInterfaceManageBC;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.basic.TPBInterfaceManageBCImpl;
import com.clt.apps.opus.esd.tes.guaranteemanage.tpbinterfacemanage.event.EsdTes2008Event;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;

/**
 * GuaranteeManage Business Logic ServiceCommand
 * 
 * @author yOng hO lEE
 * @see GuaranteeManageDBDAO
 * @since J2EE 1.6
 */
public class GuaranteeManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Checking login.<br>
	 */
	public void doStart() {
		log.debug("GuaranteeManageSC start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Completing business logic.
	 */
	public void doEnd() {
		log.debug("GuaranteeManageSC end");
	}

	/**
	 * Executing business logic.
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Executing event process.
		/**
		 * Guarantee Creation & Adjustment
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Guarantee Search ( Header & Container List )
				eventResponse = searchUSGuaranteeHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				// Guarantee Creation Save ( Header )
				eventResponse = addUSGuaranteeHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				// Guarantee Creation Save ( Header )
				eventResponse = modifyUSGuaranteeHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// Guarantee Creation Save ( Container List )
				eventResponse = multiUSGuaranteeCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				// Guarantee Creation Delete ( Header )
				eventResponse = deleteUSGuarantee(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				// Guarantee Search ( Header & Container List )
				eventResponse = new GuaranteeCommonBCImpl().validateCustomerCode2(((EsdTes2001Event) e).getGuaranteeCommonVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				// Guarantee Search ( Header & Container List )
				eventResponse = new GuaranteeCommonBCImpl().validateYardCode(((EsdTes2001Event) e).getTesGnteHdrVO());
			}
		}

		/**
		 * Guarantee Inquiry Service
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes2002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// Guarantee List Inquiry
				eventResponse = searchUSGuaranteeList(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				// Guarantee Search ( Header & Container List )
				eventResponse = new GuaranteeCommonBCImpl().validateCustomerCode2(((EsdTes2002Event) e).getGuaranteeCommonVO());
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
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Searcing container list.
				eventResponse = searchGuaranteeIrregularList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				// Irregular Creation Save ( Header )
				eventResponse = addIrregularHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				// Irregular Creation Save ( Header )
				eventResponse = modifyIrregularHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// Irregular Creation Save ( Container List )
				eventResponse = multiIrregularCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Guarantee > Irregular Creation Save ( Container List )
				eventResponse = multiGuaranteeIrregularHdr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
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
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				// Guarantee TPB I/F Save ( Header )
				eventResponse = sendGuaranteeTPBIfData(e);
			}

		}

		return eventResponse;
	}

	/**
	 * ESD_TES_2001 : [event]<br>
	 * Retrieve Gurantee header information.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSGuaranteeHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC command = new GuaranteeManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2001Event event = (EsdTes2001Event) e;

		try {

			eventResponse.setRsVoList(command.searchUSGuaranteeCntrList(event.getTesGnteHdrVO()));
			eventResponse.setRsVoList(command.searchUSGuaranteeHdr(event.getTesGnteHdrVO()));

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_TES_2001 : [event]<br>
	 * Insert Guarantee header information.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addUSGuaranteeHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC command = new GuaranteeManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2001Event event = (EsdTes2001Event) e;

		String gnteNo = "";

		try {
			begin();
			gnteNo = command.addUSGuaranteeHdr(event.getTesGnteHdrVO(), account);

			eventResponse.setETCData("gnte_no", gnteNo);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}

	/**
	 * ESD_TES_2001 : [event]<br>
	 * Update Guarantee header information.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyUSGuaranteeHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC command = new GuaranteeManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2001Event event = (EsdTes2001Event) e;

		try {
			begin();
			command.modifyUSGuaranteeHdr(event.getTesGnteHdrVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}

	/**
	 * ESD_TES_2001 : [event]<br>
	 * [Guarantee Container List] [Insert/Update/Delete]<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiUSGuaranteeCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC command = new GuaranteeManageBCImpl();
		EsdTes2001Event event = (EsdTes2001Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			command.multiUSGuaranteeCntrList(event.getTesGnteHdrVO(), event.getTesGnteCntrListVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
		//return this.searchUSGuaranteeHdr(e);
	}

	/**
	 * ESD_TES_2001 : [event]<br>
	 * Delete Guarantee header information.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteUSGuarantee(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC command = new GuaranteeManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2001Event event = (EsdTes2001Event) e;

		try {
			begin();
			command.deleteUSGuarantee(event.getTesGnteHdrVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}

	/**
	 * ESD_TES_2002 : [event]<br>
	 * Searching Guarantee header and container list.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSGuaranteeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC command = new GuaranteeManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2002Event event = (EsdTes2002Event) e;
		SearchUSGuaranteeListVO searchUSGuaranteeListVO = new SearchUSGuaranteeListVO();

		float ttlAmt = 0;
		int ttlCnt = 0;

		try {
			List<SearchUSGuaranteeListVO> list = command.searchUSGuaranteeList(event.getTesGnteHdrVO(), event.getGuaranteeCommonVO());

			if (list.size() > 0) {
				ttlCnt = list.size();
				for (int i = 0; i < list.size(); i++) {
					searchUSGuaranteeListVO = (SearchUSGuaranteeListVO) list.get(i);

					ttlAmt = ttlAmt + Float.parseFloat(searchUSGuaranteeListVO.getGnteAmt());
				}

			}
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("ttlCnt", String.valueOf(ttlCnt));
			eventResponse.setETCData("ttlAmt", String.valueOf(ttlAmt));

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_TES_2006 : [event]<br>
	 * Retrieve Irregular header information<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrregularHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		IrregularManageBC command = new IrregularManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2006Event event = (EsdTes2006Event) e;

		try {
			eventResponse.setRsVoList(command.searchIrregularCntrList(event.getTesIrrHdrVO()));
			eventResponse.setRsVoList(command.searchIrregularHdr(event.getTesIrrHdrVO()));

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_TES_2006 : [event]<br>
	 * Insert Irregular header information.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addIrregularHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC commandGnte = new GuaranteeManageBCImpl();
		IrregularManageBC command = new IrregularManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2006Event event = (EsdTes2006Event) e;

		String gnteNo = "";
		String irrNo = "";
		String gnteDmyFlg = ""; //2017.01.02 Add

		try {
			begin();
			if ("N".equals(event.getGuaranteeCommonVO().getGnteFlg())) {
				event.getTesGnteHdrVO().setDmyFlg("Y");
				gnteNo = commandGnte.addUSGuaranteeHdr(event.getTesGnteHdrVO(), account);

				if (!"".equals(gnteNo)) {
					event.getTesIrrHdrVO().setGnteNo(gnteNo);
				}
				
				gnteDmyFlg = "Y"; //2017.01.02 Add
			} else {
				gnteNo = event.getTesIrrHdrVO().getGnteNo();
				
				//2017.01.02 Add dummy flag를 구한다. : 해당 BIZ 가 dmy_flg <> 'Y' 인 데이타만 조회 되므로 존재하면 N
				List<SearchUSGuaranteeHdrVO> gHdrList = commandGnte.searchUSGuaranteeHdr(event.getTesGnteHdrVO());
				if(null != gHdrList && gHdrList.size() > 0){
					gnteDmyFlg = "N"; //2017.01.02 Add
				}else{
					gnteDmyFlg = "Y"; //2017.01.02 Add
				}
			}

			irrNo = command.addIrregularHdr(event.getTesIrrHdrVO(), account);
			eventResponse.setETCData("gnte_no", gnteNo);
			eventResponse.setETCData("irr_no", irrNo);
			eventResponse.setETCData("dmy_flg", gnteDmyFlg);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}

	/**
	 * ESD_TES_2006 : [event]<br>
	 * Update Irregular header information.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyIrregularHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// GuaranteeManageBC commandGnte = new GuaranteeManageBCImpl();
		IrregularManageBC command = new IrregularManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2006Event event = (EsdTes2006Event) e;

		try {
			begin();
			command.modifyIrregularHdr(event.getTesIrrHdrVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}

	/**
	 * ESD_TES_2006 : [event]<br>
	 * Delete Irregular header information.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteIrregular(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC commandGnte = new GuaranteeManageBCImpl();
		IrregularManageBC command = new IrregularManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2006Event event = (EsdTes2006Event) e;

		try {
			begin();
			command.deleteIrregular(event.getTesIrrHdrVO(), account);

			if ("N".equals(event.getGuaranteeCommonVO().getGnteFlg())) {
				commandGnte.deleteUSGuarantee(event.getTesGnteHdrVO(), account);
			}
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return this.searchIrregularHdr(e);
	}

	/**
	 * ESD_TES_2006 : [event]<br>
	 * [Irregular Container List] [Insert/Update/Delete]<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiIrregularCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		IrregularManageBC command = new IrregularManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2006Event event = (EsdTes2006Event) e;

		try {
			begin();
			command.multiIrregularCntrList(event.getTesIrrHdrVO(), event.getTesGnteCntrListVOs(), event.getGuaranteeCommonVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}

		return this.searchIrregularHdr(e);
	}

	/**
	 * ESD_TES_2006 : [event]<br>
	 * Searching Irregular header and container list.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuaranteeIrregularList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC commandGnte = new GuaranteeManageBCImpl();
		IrregularManageBC command = new IrregularManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2006Event event = (EsdTes2006Event) e;

		try {
			eventResponse.setRsVoList(command.searchGuaranteeIrregularCntrList(event.getGuaranteeCommonVO()));
			eventResponse.setRsVoList(commandGnte.searchUSGuaranteeHdr(event.getTesGnteHdrVO()));

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_TES_2006 : [event]<br>
	 * Upadte/Insert Irregular header on Guarantee.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiGuaranteeIrregularHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GuaranteeManageBC commandGnte = new GuaranteeManageBCImpl();
		IrregularManageBC command = new IrregularManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2006Event event = (EsdTes2006Event) e;

		String irrNo = "";

		try {
			begin();
			// Guarantee Header Update.
			commandGnte.modifyUSGuaranteeHdr(event.getTesGnteHdrVO(), event.getGuaranteeCommonVO(), account);
			// Irregular Header Insert.
			irrNo = command.addIrregularHdr(event.getTesIrrHdrVO(), account);

			eventResponse.setETCData("irr_no", irrNo);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;

	}

	/**
	 * ESD_TES_2007 : [event]<br>
	 * Searching Irregular header and container list.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrregularList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		IrregularManageBC command = new IrregularManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2007Event event = (EsdTes2007Event) e;

		try {

			eventResponse.setRsVoList(command.searchIrregularList(event.getTesIrrHdrVO(), event.getGuaranteeCommonVO()));

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_TES_2008 : [event]<br>
	 * Searching Guarantee TPB I/F.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGuaranteeTPBIfData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBInterfaceManageBC command = new TPBInterfaceManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2008Event event = (EsdTes2008Event) e;

		try {

			eventResponse.setRsVoList(command.searchGuaranteeTPBIfData(event.getGuaranteeCommonVO()));

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_TES_2008 : [event]<br>
	 * Insert/Update Guarantee TPB I/F.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendGuaranteeTPBIfData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBInterfaceManageBC command = new TPBInterfaceManageBCImpl();
		TPBInterfaceBCImpl commandTbpIF = new TPBInterfaceBCImpl();
		EsdTes2008Event event = (EsdTes2008Event) e;

		TesGnteCntrListVO[] tesGnteCntrListVOs = null;
		TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;

		String cntrNo = "";
		String bkgNo = "";

		int tpbNotCnt = 0;

		try {
			begin();
			// Revenue VVD Select
			tesN3rdPtyIfVOs = command.searchRevVVDList(event.getTesGnteHdrVO(), event.getTesGnteCntrListVOs(), event.getTesN3rdPtyIfVOs());

			// TES_N3RD_PTY_IF TPB information save.
			tesGnteCntrListVOs = command.addGuaranteeTPBIfData(event.getTesGnteHdrVO(), event.getTesGnteCntrListVOs(), tesN3rdPtyIfVOs, account);
			commit();

			begin();
			TPBInterfaceVO[] tpbInterfaceVOs = new TPBInterfaceVO[tesGnteCntrListVOs.length];

			// Setting TPB IF values.
			for (int i = 0; tpbInterfaceVOs != null && i < tpbInterfaceVOs.length; i++) {
				tpbInterfaceVOs[i] = new TPBInterfaceVO();

				tpbInterfaceVOs[i].setTmlIfOfcCd((String) tesGnteCntrListVOs[i].getTmlIfOfcCd());
				tpbInterfaceVOs[i].setTmlIfSeq((String) tesGnteCntrListVOs[i].getTmlIfSeq());
			}

			for (int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++) {
				if ("".equals(tesN3rdPtyIfVOs[i].getFincVslCd()) || "".equals(tesN3rdPtyIfVOs[i].getFincSkdVoyNo()) || "".equals(tesN3rdPtyIfVOs[i].getFincSkdDirCd())) {
					tpbNotCnt++;
					cntrNo = tesN3rdPtyIfVOs[i].getCntrNo();
					bkgNo = tesN3rdPtyIfVOs[i].getBkgNo();
				}
			}

			if (tpbNotCnt > 0) {
				throw new EventException(new ErrorHandler("TES00075", new String[] { cntrNo, bkgNo }).getMessage());
			} else {
				if (commandTbpIF.createTESTPB(tpbInterfaceVOs, account)) {
					// TES_GNTE_CNTR_LIST IF OFC, IF SEQ UPDATE.
					command.updateGuaranteeTPBIfDataSts(event.getTesGnteHdrVO(), tesGnteCntrListVOs, account);
				}
			}
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return this.searchGuaranteeTPBIfData(e);
	}

	/**
	 * Report Designer EMail, FAX send.<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendRD(Event e) throws EventException {

		GuaranteeManageBC command = new GuaranteeManageBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes2003Event event = (EsdTes2003Event) e;

		GuaranteeCommonVO commonVO = event.getGuaranteeCommonVO();

		try {
			/* [E-mail(Start)] */
			if (commonVO.getEmailAddr() != null && !"".equals(commonVO.getEmailAddr())) {
				command.sendEmail(commonVO, account);
			}
			/* [E-mail(End)] */

			/* [FAX(Start)] */
			if (commonVO.getFaxNum() != null && !"".equals(commonVO.getFaxNum())) {
				command.sendFax(commonVO, account);
			}
			/* [FAX(End)] */

			eventResponse.setETCData("email_addrs", commonVO.getEmailAddr());
			eventResponse.setETCData("fax_nums", commonVO.getFaxNum());

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

}
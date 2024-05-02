/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ServiceProviderAgreementManageSC.java
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage;

import java.util.List;

import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBC;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0034Event;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0039Event;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0040Event;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes0041Event;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9070Event;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9160Event;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9170Event;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event.EsdTes9180Event;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration.TerminalAgreementManageDBDAO;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.ChinaFdCodVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ServiceProviderAgreementManage Business Logic ServiceCommand - Handling business transaction for ServiceProviderAgreementManage
 * 
 * @author yOng hO lEE
 * @see TerminalAgreementManageDBDAO
 * @since J2EE 1.6
 */
public class ServiceProviderAgreementManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;
 
	/**
	 * ESD preceding process for biz scenario<br>
	 * TerminalAgreementManage preceding process for biz scenario<br>
	 */
	public void doStart() {
		try {
			// comment --> Login check
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ServiceProviderAgreementManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * ESD Handling for the end of working scenario<br>
	 * TerminalAgreementManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("ServiceProviderAgreementManageSC 종료");
	}

	/**
	 * ESD Handling working scenario of each event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		/**
		 * Agreement Creation && Correction
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0034Event")) {
			// Terminal Info Add
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createTerminalAgreementBasicInfo(e);
			// Agreement Header Info Search
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalAgreementInfo(e);
			// Throughput Cost Code Save Search
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchThorougputCostCode(e);
			// Terminal Rate List Search
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTerminalAgreementDetail(e);
			// Storage Rate List Search
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchStorageAgreementDetail(e);
			// lane code Search
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTerminalAgreement(e);
			// 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCostCodeVerifyList(e);
			// Yard, Vendor Search
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchAgreementYardVendor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = verifySheetTerminalAgreement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchEqStorageAgreementDetail(e);
			// lane code Search
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyTerminalAgreementInfo(e);
			// Throughput Cost Code Save
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createTerminalAgreementNo(e);
			// Register Agreement Confirm Save. ( Terminal Rate, Storage Rate )
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = registerAgreementConfirm(e);
			// Terminal Storage Rate List Confirm Save
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = mutilAgreement(e);
			// Agreement Register Before
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = regBeforeCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = modifyTerminalAgreementDelete(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeAgreement(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectYdNm(((EsdTes0034Event)e).getTesTmlSoHdrVO());
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0034Event)e).getTesTmlSoHdrVO());
			}
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = multiTerminalAgreement(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
//				eventResponse = searchTerminalAgreementInfoCheck(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
//				eventResponse = createStorageAgreement(e);				
//			} else {
//				eventResponse = searchTerminalAgreement(e);
//			}
		}

		/**
		 * Terminal Agreement Summary Inquiry
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalAgreeementSummaryList(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectYdNm(((EsdTes0039Event)e).getTesTmlSoHdrVO());
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0039Event)e).getTesTmlSoHdrVO());
			}
		}

		/**
		 * Terminal Agreement Detail Inquery
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				if(log.isDebugEnabled()) log.debug("\n "+e.getEventName()+" - SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
				eventResponse = searchTerminalAgreementManage(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				if(log.isDebugEnabled()) log.debug("\n "+e.getEventName()+" - SC.e.getFormCommand():"+e.getFormCommand().getCommand() + "<<<<<\n");
				eventResponse = searchTerminalAgreementTerminalRateDetail(e);
			}
		}


		/**
		 * Cost Code Remark
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreementPopUpList(e);
			}
		}

		/**
		 * Terminal Rate List Excel Load
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9160Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyExcelTerminalAgreement(e);
			}
		}
		
		/**
		 * Storage Rate List Excel Load
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyExcelStorageAgreement(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9175Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyExcelStorageAgreement(e);
			}
		}
		
		/**
		 * Throughput Cost Code
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9180Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createThoroughputCC(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchThoroughputCC(e);
			} else {
				eventResponse = searchThoroughputCC(e);
			}
		}

		/**
		 * Volume Accumulate Method
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes9200Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVolumeAccumulateMethodManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiVolumeAccumulateMethodManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeVolumeAccumulate(e);
			}else {
				eventResponse = searchVolumeAccumulateMethodManage(e);
			}
		}
		
		/**
		 * China Special Feeder
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialFeederList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSpecialFeeder(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSpecialFeeder(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkCntCd(e);
			}  
		}




		return eventResponse;
	}


	/**
	 * retrieve event process
	 * TerminalAgreementManage retrieve event process
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementYardVendor(Event e) throws EventException {
		// Object including the result of user request (DB Result Set, Object and etc)
		EsdTes0034Event event = (EsdTes0034Event)e;

		EventResponse	eventResponse	= null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchAgreementYardVendor(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * TerminalAgreementManage Specific list retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalAgreementDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event	event			= (EsdTes0034Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse	eventResponse	= null;

		try {
			TerminalAgreementManageBC	command	= new TerminalAgreementManageBCImpl();
			eventResponse	= command.searchTerminalAgreementDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * TerminalAgreementManage Specific list retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event		event	= (EsdTes0034Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse		eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchTerminalAgreement(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * TerminalAgreementManage Specific list retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageAgreementDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchStorageAgreementDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	private EventResponse searchEqStorageAgreementDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchEqStorageAgreementDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	

	/**
	 * retrieve event process
	 * Terminal Agreement Info retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalAgreementInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event		event	= (EsdTes0034Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse		eventResponse	= null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchTerminalAgreementInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * Creation yard, vender, eff date duplication retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
//	private EventResponse searchTerminalAgreementInfoCheck(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		EsdTes0034Event event = (EsdTes0034Event)e;
//		// Object including the result of user request (DB Result Set, Object and etc)
//		EventResponse eventResponse = null;
//
//		try {
//			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
////			eventResponse = command.searchTerminalAgreementInfoCheck(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * retrieve event process
	 * Cost Code Verify Logic Cost Code Verify retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeVerifyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event	event			= (EsdTes0034Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse	eventResponse	= null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchCostCodeVerifyList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 *  retrieve event process
	 * Thorougput CostCode event List  retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchThorougputCostCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchThorougputCostCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * Verify Terminal Agreement event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifySheetTerminalAgreement(Event e) throws EventException {
		// Object including the result of user request (DB Result Set, Object and etc)
		EsdTes0034Event		event			= (EsdTes0034Event)e;
		EventResponse		eventResponse	= null;

		try {
			TerminalAgreementManageBC	command	= new TerminalAgreementManageBCImpl();
			eventResponse	= command.verifySheetTerminalAgreement(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}


//	private EventResponse verifySheetStorageAgreement(Event e) throws EventException {
//		// Object including the result of user request (DB Result Set, Object and etc)
//		EsdTes0034Event event = (EsdTes0034Event)e;
//		EventResponse eventResponse = null;
//
//		try {
//			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
//			eventResponse = command.verifySheetStorageAgreement(event);
//		} catch (EventException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//		return eventResponse;
//	}

	private EventResponse verifyExcelTerminalAgreement(Event e) throws EventException {
		// Object including the result of user request (DB Result Set, Object and etc)
		EsdTes9160Event event = (EsdTes9160Event)e;
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.verifyExcelTerminalAgreement(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	private EventResponse verifyExcelStorageAgreement(Event e) throws EventException {
		// Object including the result of user request (DB Result Set, Object and etc)
		EsdTes9170Event event = (EsdTes9170Event)e;
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.verifyExcelStorageAgreement(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/** regBeforeCheck
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse regBeforeCheck(Event e) throws EventException {
		// Object including the result of user request (DB Result Set, Object and etc)
		EsdTes0034Event event = (EsdTes0034Event)e;
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.regBeforeCheck(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Add Event Process<br>
	 * TerminalAgreementManage Cofirm Add Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse registerAgreementConfirm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.registerAgreementConfirm(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalAgreement(e);
	}

	/**
	 * Add Event Process<br>
	 * TerminalAgreementManage Add Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createTerminalAgreementBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.createTerminalAgreementBasicInfo(event);
			commit();
			eventResponse = command.searchTerminalAgreementInfo(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Add Event Process<br>
	 * TerminalAgreementManage Add Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createTerminalAgreementNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.createTerminalAgreementNo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalAgreementInfo(e);
	}


	/**
	 * Update Event Process<br>
	 * TerminalAgreementManage Update Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalAgreementInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.modifyTerminalAgreementInfo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalAgreement(e);
	}

	/**
	 * Delete Event Process<br>
	 * TerminalAgreementManage Delete Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalAgreementDelete(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0034Event event = (EsdTes0034Event)e;
		EventResponse eventResponse = null;
		
		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.modifyTerminalAgreementDelete(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

//		return this.searchTerminalAgreement(e);
		return eventResponse;
	}

	/**
	 * Multi Event Process<br>
	 * TerminalAgreementManage Multi Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse mutilAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//EsdTes0034Event event = (EsdTes0034Event)e;
		//Object including the result of user request (DB Result Set, Object and etc)
		EventResponse	eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			String	invoiceUseFlg	= command.searchInvoiceHDR(e);
			begin();
			// New FrameWork 적용후 eventResponse 를 Return 해 준다. ( 2009-10-13 )
			eventResponse = command.mutilAgreement(e,invoiceUseFlg);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * Multi Event Process<br>
	 * TerminalAgreementManage Multi Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//EsdTes0034Event event = (EsdTes0034Event)e;
		//Object including the result of user request (DB Result Set, Object and etc)
		EventResponse	eventResponse = null;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			// New FrameWork 적용후 eventResponse 를 Return 해 준다. ( 2009-10-13 )
			eventResponse = command.removeAgreement(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}


	/**
	 * retrieve event process
	 * TerminalAgreement Summary retrieve event process
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalAgreeementSummaryList(Event e) throws EventException {
		EsdTes0039Event			event			= (EsdTes0039Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		GeneralEventResponse	eventResponse	= null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = (GeneralEventResponse)command.searchTerminalAgreeementSummaryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * TerminalAgreementManage retrieve event process
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreementPopUpList(Event e) throws EventException {
		EsdTes9070Event event = (EsdTes9070Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchAgreementPopUpList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * Throughput Cost Code retrieve event process
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchThoroughputCC(Event e) throws EventException {
		EsdTes9180Event event = (EsdTes9180Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchThoroughputCC(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Add Event Process<br>
	 * TerminalAgreementManage Add Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createThoroughputCC(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9180Event event = (EsdTes9180Event)e;

		try {

			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.deleteThoroughputCC(event);
			command.createThoroughputCC(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchThoroughputCC(e);
	}


//	===== Vol. Accumulate Method ========================================================
	/**
	 *  retrieve event process
	 * searchVolumeAccumulateMethodManage event Multi Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVolumeAccumulateMethodManage(Event e) throws EventException {

		//EsdTes9200Event event = (EsdTes9200Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchVolumeAccumulatedMethod(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Multi Event Process<br>
	 * multiVolumeAccumulateMethodManage event Multi Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiVolumeAccumulateMethodManage(Event e) throws EventException {

		try {
			begin();

			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();

			command.multiVolumeAccumulatedMethod(e);
			command.removeListVolumeAccumulatedCostCode(e);
			command.multiVolumeAccumulatedCostCode(e);
			command.multiVolumeAccumulatedYard(e);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchVolumeAccumulateMethodManage(e);
	}


	/**
	 * Delete Event Process<br>
	 * multiVolumeAccumulateMethodManage event Multi Event Process<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeVolumeAccumulate(Event e) throws EventException {
		if(log.isDebugEnabled())log.debug("\n[ServiceProviderAgreementManageSC][removeVolumeAccumulate]");
//		EsdTes9200Event event = (EsdTes9200Event)e;
		//EventResponse eventResponse = null;

		try {
			begin();

			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			command.removeVolumeAccumulate(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchVolumeAccumulateMethodManage(e);
	}


	/**
	 * Terminal Agreement Detail Inquiry
	 */

	/**
	 * retrieve event process
	 * terminalagreementmanage Specific list retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	private EventResponse searchTerminalAgreementManage(Event e) throws EventException {
		log.debug("\n\n=================== ServiceProviderAgreementManageSC :::: searchTerminalAgreementManage============\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0040Event event = (EsdTes0040Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchTerminalAgreementManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process
	 * TerminalAgreementManage Specific list retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	private EventResponse searchTerminalAgreementTerminalRateDetail(Event e) throws EventException {
		log.debug("\n\n=================== ServiceProviderAgreementManageSC :::: searchTerminalAgreementTerminalRateInquiryDetail============\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0040Event event = (EsdTes0040Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
			eventResponse = command.searchTerminalAgreementTerminalRateDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		//return this.searchTerminalRateList(e);
		return eventResponse;
	}


	/**EsdTes4034Event retrieve event process<br>
	 * China Special Feeder List retrieve<br>
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 * @author JEONGMIN CHO
	 */
	private EventResponse searchSpecialFeederList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0041Event event = (EsdTes0041Event)e;
		TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();

		try{
			List<ChinaFdCodVO> list = command.searchSpecialFeederList(event.getChinaFdCodVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * EsdTes4034Event save event process<br>
	 * China Special Feeder List save<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageSpecialFeeder(Event e) throws EventException {
    	EsdTes0041Event event = (EsdTes0041Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
    	
        try {
            begin();
            command.manageSpecialFeeder(event.getChinaFdCodVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("COM12240",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 
	/**EsdTes4034Event retrieve event process<br>
	 * mdm location data retrieve<br>
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 * @author JEONGMIN CHO
	 */
	private EventResponse searchMdmLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0041Event event = (EsdTes0041Event)e;
		TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
		String searchCd = null;
		String loc_fullname = null;
		
		try{

			searchCd = event.getChinaFdCodVO().getSearchCd();
			loc_fullname = command.searchMdmLocation(searchCd);
			eventResponse.setETCData("loc_fullname", loc_fullname);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTes4034Event check event process<br>
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 * @author JEONGMIN CHO
	 */
	private EventResponse checkSpecialFeeder(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0041Event event = (EsdTes0041Event)e;
		TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
		String chkPolCd = null;
		String chkPodCd = null;
		String samecd_cnt = null;
		
		try{

			chkPolCd = event.getChinaFdCodVO().getChkPolCd();
			chkPodCd = event.getChinaFdCodVO().getChkPodCd();
			samecd_cnt = command.checkSpecialFeeder(chkPolCd,chkPodCd);
			eventResponse.setETCData("samecd_cnt", samecd_cnt);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * EsdTes4034Event check event process <br>
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 * @author JEONGMIN CHO
	 */

	private EventResponse checkCntCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTes0041Event event = (EsdTes0041Event)e;
		TerminalAgreementManageBC command = new TerminalAgreementManageBCImpl();
		String searchCd = null;
		String check_cn = null;
		
		try{

			searchCd = event.getChinaFdCodVO().getSearchCd();
			check_cn = command.checkCntCd(searchCd);
			eventResponse.setETCData("check_cn", check_cn);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
}
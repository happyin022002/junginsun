/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ScemSetupSC.java
 *@FileTitle : Exception Alert/Registration Notice
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBC;
import com.clt.apps.opus.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.basic.ActivityDataBC;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.basic.ActivityDataBCImpl;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.event.EsdSce0024Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.vo.SearchActivityListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.basic.CustomerEdiBC;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.basic.CustomerEdiBCImpl;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0032Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0035Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0060Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0061Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0062Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0063Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0065Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0066Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0067Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0068Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0072Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0073Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0074Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCsInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.UpdateCargoTrackingDataVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.basic.ExceptionDataBC;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.basic.ExceptionDataBCImpl;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0026Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0028Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0029Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0049Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0112Event;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcList3VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMasterOfcListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailList3VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStr2VO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStrVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchSubscriberGroupMappingVO;
import com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * SCEM Business Logic ServiceCommand<br>
 * - Handling Business Transaction for SCEM<br>
 * 
 * @author yong_cheon_shin
 * @see UI_EsdSce0028EventResponse,ScemSetupDBDAO
 * @since J2EE 1.4
 */
public class MasterDataManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for SCEM<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		try {
			// checking Login 
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("Error at Pre ScemSetupSC " + e.toString(), e);
		}
	}

	/**
	 * biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("Closing ScemSetupSC");
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdSce0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchActivityList();
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSKDLogicList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSKDLogic(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0026Event")) {
			log.debug("\n EsdSce0026Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpTypeList();
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				log.debug("026 command MULTI");
				multiExpType(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				log.debug("026 command MULTI01");
				multiExpTypeDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExpTypeDetailList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				log
						.debug("026 command SEARCH03:: exception type sheet DblClick");
				eventResponse = searchExptDetailList3(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				log.debug("\n 026-SEARCH");
				eventResponse = searchExptDetail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExptNoticeSubscriberList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiExptNoticeSubscriber(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSubscriberGroupMapping(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				multiSubscriberGroupMapping(e);
			}

			if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { // Exception
																		// Type
				eventResponse = searchExptTPList();
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { // Exception
																		// Type
				eventResponse = searchExptDTLTPList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchToleranceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				log.debug("\n MULTI");
				eventResponse = multiTolerance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				log.debug("\n 029-SEARCH");
				// eventResponse = searchExptTolAct (e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { // Exception
																				// Type
				log.debug("\n 029-SEARCH12-Exception Type");
				eventResponse = searchTOLExptTPList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { // Exception
																				// Type
				log.debug("\n 029-SEARCH13-Exception Type Detail");
				eventResponse = searchTOLExptDTLTPList(e);
			}

		} 

		/*
		 * EventResponse eventResponse = null;
		 * 
		 * // setting logic in case of multi event   //if
		 * (e.getEventName().equalsIgnoreCase("EsdSce0011Event")) { // if
		 * (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // eventResponse
		 * = searchExpSummaryList(e); // } if
		 * (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { eventResponse=
		 * searchExpSummaryList(e); }else if
		 * (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { //Sub-Office
		 * eventResponse = searchSubOfficeList(e); }else if
		 * (e.getFormCommand().isCommand(FormCommand.MULTI)) {
		 * modifyExptReason(e); } } return eventResponse;
		 */
		else if (e.getEventName().equalsIgnoreCase("EsdSce0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getCustomerData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEdiStatusData(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsdSce0035Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				log.debug("EsdSce0035Event - SEARCH01");
				eventResponse = searchEdiSummaryReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				log.debug("EsdSce0035Event - SEARCH02");
				eventResponse = searchDetailMvmtReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				log.debug("EsdSce0035Event - SEARCH03");
				eventResponse = searchDetailOtherReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				log.debug("EsdSce0035Event - MULTI01");
				eventResponse = updateDetailReportMvmtSave(e, "SAVE");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				log.debug("EsdSce0035Event - MULTI02");
				eventResponse = updateDetailReportMvmtSave(e, "SEND");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = updateDetailReportOtherSave(e, "SAVE");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = updateDetailReportOtherSave(e, "SEND");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				log.debug("EsdSce0035Event - MULTI05");
				eventResponse = searchCsInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				/* This Section may use the same function as one of 0072 program */
				log.debug("EsdSce0035Event - MULTI06");
				EsdSce0035Event mainEvent = (EsdSce0035Event) e;
				EsdSce0072Event e0072tempEvent = new EsdSce0072Event();
				e0072tempEvent.setSchEpOpts(mainEvent.getSchEpOpts());
				eventResponse = searchPerCsTpIdInfo(e0072tempEvent);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0060Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEdiActivityInquiryData(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsdSce0061Event")) {
			log.debug("\n searchCargoTrackingData");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCargoTrackingData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				log.debug("MasterDataManageSC - 0061 : Command :Save");
				eventResponse = updateCargoTrackingData(e, "SAVE");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = updateCargoTrackingData(e, "SEND");
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0062Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerInquery(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCustomercnt(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsdSce0063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				log.debug("EsdSce0063Event - SEARCH");
				eventResponse = searchVvdList(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsdSce0067Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				EsdSce0067Event decisionEvent = (EsdSce0067Event) e;
				if (decisionEvent.getSchEpOpts() != null) {
					eventResponse = searchStsList(e);
				}// if
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsdSce0065Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = updateCargoTrackingSave(e);
			}

		}

		else if (e.getEventName().equalsIgnoreCase("EsdSce0066Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = updateCargoTrackingSend(e);
			}

		}
		else if (e.getEventName().equalsIgnoreCase("EsdSce0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomTpId(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0072Event")) {
			log.debug("EsdSce0072Event Created");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				log.debug("EsdSce0072Event - FormCommand.SEARCH01");
				eventResponse = searchEDIPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				log.debug("EsdSce0072Event - FormCommand.SEARCH02");
				eventResponse = searchEDITotalPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				log.debug("EsdSce0072Event - SEARCH03");
				eventResponse = searchComboPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				log.debug("EsdSce0072Event - SEARCH04");
				eventResponse = searchCustSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				log.debug("EsdSce0072Event - SEARCH05");
				eventResponse = getMyPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				log.debug("EsdSce0072Event - MULTI01");
				eventResponse = searchPerCsInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				log.debug("EsdSce0072Event - MULTI02");
				eventResponse = searchPerCsTpIdInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPerRepPupModi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = updatePerformanceCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = updatePerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {

				updatePerformanceModify(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchGroupID(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchPerCsTpIdInfo1(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0074Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMissingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOnTimeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateMissingListSave(e, "SEND");
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMyCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMyPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				deleteMyCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				deleteMyPerformance(e);
			}
		}
		// Added Exception Office Mapping
		else if (e.getEventName().equalsIgnoreCase("EsdSce0112Event")) {
			log.debug("\n EsdSce0112Event");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpMasterOfcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				log.debug("112 command MULTI01");
				multiExpMapgOfc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExpMapgOfcList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				log.debug("112 command SEARCH03:: ExpMasterOfc sheet DblClick");
				eventResponse = searchExpMapgOfcList3(e);
			}
		}
		return eventResponse;
	}

	/*
	 */
	/**
	 * retrieving Activity Attribute Management<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActivityList() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			ActivityDataBC command = new ActivityDataBCImpl();
			List<SearchActivityListVO> list = command.searchActivityList();
			eventResponse.setRsVoList(list);
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * retrievingCOP Scheduling Logic Registration<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSKDLogicList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0024Event event = (EsdSce0024Event) e;

		try {
			begin();
			ActivityDataBC command = new ActivityDataBCImpl();
			List<SearchSKDLogicListVO> list = command.searchSKDLogicList(event
					.getSearchSKDLogicListVO());
			eventResponse.setRsVoList(list);
			commit();
			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * editing COP Scheduling Logic Registration<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiSKDLogic(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0024Event event = (EsdSce0024Event) e;

		try {
			begin();
			ActivityDataBC command = new ActivityDataBCImpl();
			command.multiSKDLogic(event.getSceCopSkdLgcVOs());
			commit();
			return (eventResponse);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * retrieving Exception Type Registration<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpTypeList() throws EventException {
		log.debug("\n searchExpTypeList start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			List<SearchExpTypeListVO> list = command.searchExpTypeList();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Exception Type Detail Registration <br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpTypeDetailList() throws EventException {
		log.debug("\n searchExpTypeDetailList start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			List<SearchExpTypeDetailListVO> list = command
					.searchExpTypeDetailList();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * managing Exception Type Registration <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void multiExpType(Event e) throws EventException {

		log.debug("\n multiExpType start!! ");
		try {
			begin();
			ExceptionDataBC command = new ExceptionDataBCImpl();
			command.multiExpType(e, account.getUsr_id());
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * managing Exception Type Detail Registration <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void multiExpTypeDetail(Event e) throws EventException {

		log.debug("\n multiExpTypeDetail start!! ");
		try {
			begin();
			ExceptionDataBC command = new ExceptionDataBCImpl();
			command.multiExpTypeDetail(e, account.getUsr_id());
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	
	/**
	 * retrieving Exception Tolerance Registration <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchToleranceList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0029Event event = (EsdSce0029Event) e;
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			List<SearchToleranceListVO> list = command
					.searchToleranceList(event.getTolInfo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * managing Exception Tolerance Registration<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTolerance(Event e) throws EventException {
		ExceptionDataBC command = new ExceptionDataBCImpl();
		GeneralEventResponse rtnGel = new GeneralEventResponse();
		try {
			begin();
			command.multiTolerance(e, account.getUsr_id());
			commit();

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return rtnGel;
	}

	
	/**
	 *managing  minestar - Subscriber Registration<br>
	 * 
	 * @param Event e
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse multiExptNoticeSubscriber(Event e)
			throws EventException {

		ExceptionDataBC command = new ExceptionDataBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			command.multiExptNoticeSubscriber(e, account.getUsr_id());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * managing minestar - Exception Subscriber Registration <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void multiSubscriberGroupMapping(Event e) throws EventException {
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			begin();
			command.multiSubscriberGroupMapping(e, account.getUsr_id());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving minestar - Exception Subscriber Registration
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExptNoticeSubscriberList(Event e)
			throws EventException {

		log.debug("\n searchExptNoticeSubscriberList start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();
		EsdSce0028Event event = (EsdSce0028Event) e;

		try {
			List<SearchExptSubReqListVO> list = command
					.searchExptSubscriberRegistration(event.getReqInfo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Rail Delay Exception Tolerance/old minestar/COP Exception Tp
	 * 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubscriberGroupMapping(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0049Event event = (EsdSce0049Event) e;
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			List<SearchSubscriberGroupMappingVO> list = command
					.searchSubscriberGroupMapping(event.getTolInfo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Rail Delay Exception Tolerance
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExptDetail(Event e) throws EventException {
		log.debug("\n searchExptDetail start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();
		EsdSce0026Event event = (EsdSce0026Event) e;
		log.debug("type == "
				+ event.getExpTypeDetailSep().getFCopExptTpCd().equals("2"));
		try {
			if (event.getExpTypeDetailSep().getFCopExptTpCd().equals("2")) {
				List<SearchExptDetailQueryStrVO> list = command
						.searchExptDetail(event.getExpTypeDetailSep());
				eventResponse.setRsVoList(list);

				SearchExptDetailQueryStrVO vo = null;
				if (list.size() > 0) {
					vo = (SearchExptDetailQueryStrVO) list.get(0);
					eventResponse.setETCData("f_fm_expt_cd", vo.getFFmExptCd());
					eventResponse.setETCData("f_to_expt_cd", vo.getFToExptCd());
					eventResponse.setETCData("f_cop_expt_tp_dtl_cd", vo
							.getFCopExptTpDtlCd());
					eventResponse.setETCData("f_validation", vo
							.getFValidation());
				}
			} else {
				List<SearchExptDetailQueryStr2VO> list = command
						.searchExptDetail2(event.getExpTypeDetailSep());
				eventResponse.setRsVoList(list);

				SearchExptDetailQueryStr2VO vo = null;
				if (list.size() > 0) {
					vo = (SearchExptDetailQueryStr2VO) list.get(0);
					eventResponse.setETCData("f_fm_expt_cd", vo.getFFmExptCd());
					eventResponse.setETCData("f_to_expt_cd", vo.getFToExptCd());
					eventResponse.setETCData("f_cop_expt_tp_dtl_cd", vo
							.getFCopExptTpDtlCd());
					eventResponse.setETCData("f_validation", vo
							.getFValidation());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Exception Detail by Exception Type
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExptDetailList3(Event e) throws EventException {
		log.debug("\n searchExptDetailList3 start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();
		EsdSce0026Event event = (EsdSce0026Event) e;

		try {
			List<SearchExptDetailList3VO> list = command
					.searchExptDetailList3(event.getFExpTp());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Edi Customer data
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse getCustomerData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0032Event event = (EsdSce0032Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {

			List<SearchCustomerDataVO> list = command.searchCustomerData(event
					.getCusEdiOpt());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Edi Status data Event 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEdiStatusData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0032Event event = (EsdSce0032Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			// List<SearchEdiStatusDataVO> list =
			// command.searchEdiStatusData(event.getSchEdit());
			List<SearchEdiStatusDataVO> list = command
					.searchEdiStatusData(event.getCusEdiOpt());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * updating Detail Report data
	 * 
	 * @param Event e
	 * @param String dist
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateDetailReportMvmtSave(Event e, String dist) throws EventException {
		log.debug("\n updateDetailReportMvmtSave start ");
		EventResponse eventResponse = null;
		EsdSce0035Event event = (EsdSce0035Event) e;
		List<Edi315SendVO> edi315SendVOs = null;

		edi315SendVOs = event.getEdi315SendVOs();
		if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
			log.debug("vos size : " + edi315SendVOs.size());
			/* setting creation user/update user id  */
			for (int n = 0; n < edi315SendVOs.size(); n++) {
				edi315SendVOs.get(n).setCreId(account.getUsr_id());
				edi315SendVOs.get(n).setUpdId(account.getUsr_id());
				log.debug("vo[" + n + "]: Cre ID :"+ edi315SendVOs.get(n).getCreId());
				log.debug("vo[" + n + "]: Udp ID :"+ edi315SendVOs.get(n).getUpdId());
			}// for
		}// if

		try {
			if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
				// checking  mdm_location
				String locCd = searchMdmLocation(edi315SendVOs, false);
				if (locCd != null && locCd.length() > 0) {
					throw new EventException(new ErrorHandler("BKG00061",new String[] { locCd }).getMessage());
	
				}
				sendEdi315(edi315SendVOs);
				eventResponse = searchDetailMvmtReport(e);
			}
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * sending Edi Document.
	 * 
	 * @param List<Edi315SendVO> edi315SendVOs
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse sendEdi315(List<Edi315SendVO> edi315SendVOs) throws EventException {
		log.debug("In sendEdi315");
		Edi315SendBC command = new Edi315SendBCImpl();
		//2015.04.14 Modify Critical
		//EventResponse eventResponse = null; 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
				int len = edi315SendVOs.size();
				String[] result_str = new String[len];
				for (int m = 0; m < len; m++) {
					begin();
					result_str[m] = command.edi315Send((Edi315SendVO) edi315SendVOs.get(m));
					commit();
				}// for
			}// if

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * updating Detail Report (Others List)
	 *
	 * @param Event e
	 * @param String dist
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateDetailReportOtherSave(Event e, String dist)throws EventException {
		log.debug("\n updateDetailReportOtherSave start ");
		EventResponse eventResponse = null;
		EsdSce0035Event event = (EsdSce0035Event) e;
		List<Edi315SendVO> edi315SendVOs = null;

		edi315SendVOs = event.getEdi315SendVOs();
		if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
			log.debug("vos size : " + edi315SendVOs.size());
			for (int n = 0; n < edi315SendVOs.size(); n++) {
				edi315SendVOs.get(n).setCreId(account.getUsr_id());
				edi315SendVOs.get(n).setUpdId(account.getUsr_id());
				log.debug("vo[" + n + "]: Cre ID :"+ edi315SendVOs.get(n).getCreId());
				log.debug("vo[" + n + "]: Udp ID :"+ edi315SendVOs.get(n).getUpdId());
			}// for
		}// if

		try {
			// cheking mdm_location
			if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
				String locCd = searchMdmLocation(edi315SendVOs, false);
				if (locCd != null && locCd.length() > 0) {
					throw new EventException(new ErrorHandler("BKG00061",new String[] { locCd }).getMessage());
	
				}
				sendEdi315(edi315SendVOs);
				eventResponse = searchDetailOtherReport(e);
			}
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	
	/**
	 * retrieving Edi Summary Report
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEdiSummaryReport(Event e) throws EventException {
		log
				.debug("\n ###EsdSce0035:MasterDataManageSC - searchEdiSummaryReport start ");
		EventResponse eventResponse = null;
		EsdSce0035Event event = (EsdSce0035Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchEdiSummaryReport(event
					.getSchSROptsVO());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Edi Detail Report - Mvmt list
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDetailMvmtReport(Event e) throws EventException {
		
		log.debug("\n ###EsdSce0035:MasterDataManageSC - searchDetailMvmtReport start ");
		EventResponse eventResponse = null;
		EsdSce0035Event event = (EsdSce0035Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchDetailMvmtReport(event
					.getSchSROptsVO());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Edi Detail Report - Others list
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDetailOtherReport(Event e) throws EventException {
		log
				.debug("\n ###EsdSce0035:MasterDataManageSC - searchDetailMvmtReport start ");

		EventResponse eventResponse = null;
		EsdSce0035Event event = (EsdSce0035Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchDetailOtherReport(event
					.getSchSROptsVO());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Customer Information
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCsInfo(Event e) throws EventException {
		log.debug("MasterSC is called");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0035Event event = (EsdSce0035Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();
		try {
			List<SearchCsInfoVO> list = command.searchCsInfo(event
					.getSchSROptsVO());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Activity Inquery Data
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEdiActivityInquiryData(Event e)
			throws EventException {
		log
				.debug("\n ###EsdSce0035:MasterDataManageSC - searchEdiActivityInquiryData start ");
		EventResponse eventResponse = null;
		EsdSce0060Event event = (EsdSce0060Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchEdiActivityInquiryData(event
					.getSearchEdiActivityInquiryDataOptionsVO());
			return (eventResponse);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieving Cargo Tracking Data
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */

	public EventResponse searchCargoTrackingData(Event e) throws EventException {
		log
				.debug("\n ###EsdSce0061:MasterDataManageSC - searchCargoTrackingData start ");

		EventResponse eventResponse = null;
		EsdSce0061Event event = (EsdSce0061Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchCargoTrackingData(event
					.getSchCtdOpts());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	
	/**
	 * updating Cargo Tracking Info(EDI)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateCargoTrackingSave(Event e) throws EventException {
		log.debug("EsdSce0065 -  updateCargoTrackingSave ");
		EventResponse eventResponse = null;
		EsdSce0065Event event = (EsdSce0065Event) e;
		List<UpdateCargoTrackingDataVO> list = event.getUCTDVOs();
		List<Edi315SendVO> edi315SendVOs = null;
		//EsdSce0035Event event_search = new EsdSce0035Event();

		try {
			edi315SendVOs = new ArrayList<Edi315SendVO>();
			for (int i = 0; i < list.size(); i++) {

				UpdateCargoTrackingDataVO vo = list.get(i);
				vo.setUsrId(account.getUsr_id());
				log.debug("vo[" + i + "][bkg_no]" + vo.getBkgNo());
				log.debug("vo[" + i + "][cntr_no]" + vo.getCntrNo());
				log.debug("vo[" + i + "][usr_id]" + vo.getUsrId());

				vo.setCallFrom("LOG");
				/*
				 * in order to send objects to EDI function, vo change into
				 * HashMap named model
				 */
				HashMap<String, String> model = new HashMap<String, String>();
				model = vo.getColumnValues();

				Set<String> keySet = model.keySet();
				Object[] keys = keySet.toArray();
				log
						.debug("Checking Data And Key Value in the Set Collection....");
				for (int b = 0; b < keySet.size(); b++) {
					log.debug("key[" + keys[b] + "]" + " value["
							+ model.get(keys[b]) + "]");
				}// for

				/*
				 * Mating VO's values from Screen Cells with VO's values for
				 * send function
				 */
				Edi315SendVO sendvo = new Edi315SendVO();
				sendvo.setCreId(account.getUsr_id());
				sendvo.setUpdId(account.getUsr_id());
				// sendvo.setCallFrom("COP");
				sendvo.setCallFrom("MAN");
				/* seperator(Save/Send)  */
				sendvo.setLogFlg("Y");
				sendvo.setManFlg("Y");
				sendvo.setBkgNo(vo.getBkgNo());
				sendvo.setCntrNo(vo.getCntrNo());
				sendvo.setEdiStatus(vo.getEdiSts());
				sendvo.setCustStatus(vo.getCustSts());
				sendvo.setEventYard(vo.getNod());
				sendvo.setEventDt(vo.getEventDt());

				sendvo.setIbflag("I");
				edi315SendVOs.add(sendvo);
				log.debug("sendvo[" + i + "]" + "  - Cre ID    :"
						+ sendvo.getCreId());
				log.debug("sendvo[" + i + "]" + "  - Upd ID    :"
						+ sendvo.getUpdId());
				log.debug("sendvo[" + i + "]" + "  - EdiStatus :"
						+ sendvo.getEdiStatus());
				log.debug("sendvo[" + i + "]" + "  - CustStatus:"
						+ sendvo.getCustStatus());
				log.debug("sendvo[" + i + "]" + "  - event dt  :"
						+ sendvo.getEventDt());
				log.debug("sendvo[" + i + "]" + "  - no        :"
						+ sendvo.getEventYard());

			}// for
			// checking mdm_location
			String locCd = searchMdmLocation(edi315SendVOs, false);
			if (locCd != null && locCd.length() > 0) {
				throw new EventException(new ErrorHandler("BKG00061",
						new String[] { locCd }).getMessage());
			}
			/* Saving Function for edi315 */
			sendEdi315(edi315SendVOs);
			eventResponse = new GeneralEventResponse();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}// try
		return eventResponse;
	}

	/**
	 * updating Cargo Tracking.(EDI)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateCargoTrackingSend(Event e) throws EventException {
		log.debug("EsdSce0066 -  updateCargoTrackingSave ");
		EventResponse eventResponse = null;
		EsdSce0066Event event = (EsdSce0066Event) e;
		List<UpdateCargoTrackingDataVO> list = event.getUCTDVOs();
		List<Edi315SendVO> edi315SendVOs = null;
		//EsdSce0035Event event_search = new EsdSce0035Event();

		try {
			edi315SendVOs = new ArrayList<Edi315SendVO>();
			for (int i = 0; i < list.size(); i++) {

				UpdateCargoTrackingDataVO vo = list.get(i);
				vo.setUsrId(account.getUsr_id());

				log.debug("vo[" + i + "][bkg_no]" + vo.getBkgNo());
				log.debug("vo[" + i + "][cntr_no]" + vo.getCntrNo());
				log.debug("vo[" + i + "][usr_id]" + vo.getUsrId());

				vo.setCallFrom("LOG");
				/*
				 * in order to send objects to EDI function, vo change into
				 * HashMap named model
				 */
				HashMap<String, String> model = new HashMap<String, String>();
				model = vo.getColumnValues();

				Set<String> keySet = model.keySet();
				Object[] keys = keySet.toArray();
				
				log.debug("Checking Data And Key Value in the Set Collection....");
				for (int b = 0; b < keySet.size(); b++) {
					log.debug("key[" + keys[b] + "]" + " value["
							+ model.get(keys[b]) + "]");
				}// for

				/*
				 * Mating VO's values from Screen Cells with VO's values for
				 * send function
				 */
				Edi315SendVO sendvo = new Edi315SendVO();
				sendvo.setCreId(account.getUsr_id());
				sendvo.setUpdId(account.getUsr_id());
				sendvo.setCallFrom("MAN");

				sendvo.setLogFlg("");
				sendvo.setManFlg("Y");
				log.debug("setLogFlg - " + sendvo.getLogFlg());
				sendvo.setBkgNo(vo.getBkgNo());
				sendvo.setCntrNo(vo.getCntrNo());
				sendvo.setEdiStatus(vo.getEdiSts());
				sendvo.setCustStatus(vo.getCustSts());
				sendvo.setEventYard(vo.getNod());
				sendvo.setEventDt(vo.getEventDt());
				sendvo.setIbflag(vo.getIbflag());
				/* TestCode */
				edi315SendVOs.add(sendvo);
				log.debug("sendvo[" + i + "]" + "  - Cre ID    :"
						+ sendvo.getCreId());
				log.debug("sendvo[" + i + "]" + "  - Upd ID    :"
						+ sendvo.getUpdId());
				log.debug("sendvo[" + i + "]" + "  - EdiStatus :"
						+ sendvo.getEdiStatus());
				log.debug("sendvo[" + i + "]" + "  - CustStatus:"
						+ sendvo.getCustStatus());
				log.debug("sendvo[" + i + "]" + "  - event dt  :"
						+ sendvo.getEventDt());
				log.debug("sendvo[" + i + "]" + "  - no        :"
						+ sendvo.getEventYard());

			}// for
			// checking mdm_location
			String locCd = searchMdmLocation(edi315SendVOs, false);
			if (locCd != null && locCd.length() > 0) {
				throw new EventException(new ErrorHandler("BKG00061",
						new String[] { locCd }).getMessage());
			}
			/* Saving Function for edi315 */
			sendEdi315(edi315SendVOs);
			eventResponse = new GeneralEventResponse();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}// try
		return eventResponse;
	}

	/**
	 * updating CargoTrackingData
	 * 
	 * @param Event e
	 * @param String dist
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateCargoTrackingData(Event e, String dist)
			throws EventException {
		log.debug("EsdSce0061 -  updateCargoTrackingData ");
		EventResponse eventResponse = null;
		EsdSce0061Event event = (EsdSce0061Event) e;
		List<UpdateCargoTrackingDataVO> list = event.getUCTDVOs();
		List<Edi315SendVO> edi315SendVOs = null;

		try {

			edi315SendVOs = new ArrayList<Edi315SendVO>();
			for (int i = 0; i < list.size(); i++) {

				UpdateCargoTrackingDataVO vo = list.get(i);
				String isSave = (String) vo.getIbflg();
				vo.setDist(dist);
				vo.setUsrId(account.getUsr_id());

				log.debug("vo[" + i + "][ibflg]" + vo.getIbflg());
				log.debug("vo[" + i + "][dist]" + vo.getDist());
				log.debug("vo[" + i + "][bkg_no]" + vo.getBkgNo());
				log.debug("vo[" + i + "][bkg_no_split]" + vo.getBkgNoSplit());
				log.debug("vo[" + i + "][cntr_no]" + vo.getCntrNo());
				log.debug("vo[" + i + "][edi_sts]" + vo.getEdiSts());
				log.debug("vo[" + i + "][nod]" + vo.getNod());
				log.debug("vo[" + i + "][event_dt]" + vo.getEventDt());
				log.debug("vo[" + i + "][usr_id]" + vo.getUsrId());

				if (isSave.equals("I")) {
					log.debug("The vo[" + i
							+ "] says it has the property of Savable");
					if (dist.equals("SAVE")) {
						vo.setCallFrom("LOG");
					} else {
						vo.setCallFrom("MAN");
					}// if
					/*
					 * in order to send objects to EDI function, vo change into
					 * HashMap named model
					 */
					HashMap<String, String> model = new HashMap<String, String>();
					model = vo.getColumnValues();

					Set<String> keySet = model.keySet();
					Object[] keys = keySet.toArray();
					log
							.debug("Checking Data And Key Value in the Set Collection....");
					for (int b = 0; b < keySet.size(); b++) {
						log.debug("key[" + keys[b] + "]" + " value["
								+ model.get(keys[b]) + "]");
					}// for

					/*
					 * Mating VO's values from Screen Cells with VO's values for
					 * send function
					 */
					Edi315SendVO sendvo = new Edi315SendVO();
					sendvo.setCreId(account.getUsr_id());
					sendvo.setUpdId(account.getUsr_id());
					// sendvo.setCallFrom("COP");
					sendvo.setCallFrom("MAN");

					if ("SAVE".equalsIgnoreCase(dist)) {
						sendvo.setLogFlg("Y");
					} else if ("SEND".equalsIgnoreCase(dist)) {
						sendvo.setLogFlg("");
					}// if
					sendvo.setManFlg("Y");

					sendvo.setEdiStatus(vo.getEdiSts());
					sendvo.setCustStatus(vo.getCustSts());
					sendvo.setEventDt(vo.getEventDt());
					sendvo.setBkgNo(vo.getBkgNo());
					sendvo.setCntrNo(vo.getCntrNo());
					sendvo.setEventYard(vo.getNod());
					sendvo.setIbflag(isSave);

					edi315SendVOs.add(sendvo);

					log.debug("sendvo[" + i + "]" + "  - Cre ID    :"
							+ sendvo.getCreId());
					log.debug("sendvo[" + i + "]" + "  - Upd ID    :"
							+ sendvo.getUpdId());
					log.debug("sendvo[" + i + "]" + "  - EdiStatus :"
							+ sendvo.getEdiStatus());
					log.debug("sendvo[" + i + "]" + "  - CustStatus:"
							+ sendvo.getCustStatus());

				}// if
			}// for

			// checking mdm_location
			String locCd = searchMdmLocation(edi315SendVOs, true);
			if (locCd != null && locCd.length() > 0) {
				throw new EventException(new ErrorHandler("BKG00061",
						new String[] { locCd }).getMessage());
			}

			/* Saving Function for edi315 */
			sendEdi315(edi315SendVOs);
			eventResponse = searchCargoTrackingData(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}// try
		return eventResponse;
	}

	/**
	 * retrieving EDI Customer data
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCustomerInquery(Event e) throws EventException {
		log.debug("\n searchCustomerInquery start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0062Event event = (EsdSce0062Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			List<SearchCustomerInqueryVO> list = command
					.searchCustomerInquery(event.getCustChoice());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving customer data for duplication customer
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCustomercnt(Event e) throws EventException {
		log.debug("\n searchCustomercnt start ");
		EsdSce0062Event event = (EsdSce0062Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();
		EventResponse eventResponse = null;

		try {
			eventResponse = command.searchCustomercnt(event.getCustChoice());
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		// return eventResponse;
	}

	/**
	 * retrieving customer tp id for duplication
	 * 
	 * @param Event e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCustomTpId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		log.debug("masterdataSC is called out");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0068Event event = (EsdSce0068Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			// List<SearchEdiStatusDataVO> list =
			// command.searchEdiStatusData(event.getSchEdit());
			List<SearchCustomTpIdVO> list = command.searchCustomTpId(event
					.getSchEpOpts());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving VVD List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		log.debug("EsdSce0063 - searchVvdList");
		EventResponse eventResponse = null;
		EsdSce0063Event event = (EsdSce0063Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchVvdList(event.getSchVSlVO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving status list<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		log.debug("masterdataSC is called out");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0067Event event = (EsdSce0067Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();
		try {
			List<SearchStsListVO> list = command.searchStsList(event
					.getSchEpOpts());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retreving Edi Performance Report Missing list
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEDIPerformance(Event e) throws EventException {
		log.debug("MasterDataManageSC -  searchEDIPerformance");

		EventResponse eventResponse = null;
		EsdSce0072Event event = (EsdSce0072Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchEDIPerformance(event.getSchEpOpts());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Edi Performance Report on-time-performance
	 * 
	 * @param Event e

	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEDITotalPerformance(Event e)
			throws EventException {
		log.debug("MasterDataManageSC -  searchEDITotalPerformance");
		EventResponse eventResponse = null;
		EsdSce0072Event event = (EsdSce0072Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchEDITotalPerformance(event
					.getSchEpOpts());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Edi Performance Report Combo List
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchComboPerformance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		log.debug("MasterDataManageSC calling.");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0072Event event = (EsdSce0072Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();
		try {
			List<SearchComboPerformanceVO> list = command
					.searchComboPerformance(event.getSchEpOpts());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Edi Customer status
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCustSts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		log.debug("EsdSce0072 - MasterDataSC has been colled out");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0072Event event = (EsdSce0072Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			// List<SearchCustomerDataVO> list =
			// command.searchCustomerData(event.getSchCust());
			List<SearchCustStsVO> list = command.searchCustSts(event
					.getSchEpOpts());
			// setting ETCData
			SearchCustStsVO vo = null;
			if (list.size() > 0) {
				vo = (SearchCustStsVO) list.get(0);
				eventResponse.setETCData(vo.getColumnValues());
			}// if
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Customer Information
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPerCsInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0072Event event = (EsdSce0072Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();
		try {
			List<SearchPerCsInfoVO> list = command.searchPerCsInfo(event
					.getSchEpOpts());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Customer TP ID Information
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPerCsTpIdInfo(Event e) throws EventException {
		log.debug("\n searchPerCsTpIdInfo start ");
		EventResponse eventResponse = null;
		EsdSce0072Event event = (EsdSce0072Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			eventResponse = command.searchPerCsTpIdInfo(event.getSchEpOpts());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Customer TP ID Information
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPerCsTpIdInfo1(Event e) throws EventException {
		log.debug("\n searchPerCsTpIdInfo1 start ");
		EsdSce0073Event event = (EsdSce0073Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();
		EventResponse eventResponse = null;

		try {
			eventResponse = command.searchPerCsTpIdInfo1(event.getSchEpOpts());
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving Missing List popup
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchMissingList(Event e) throws EventException {
		log.debug("\n searchMissingList start ");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0074Event event = (EsdSce0074Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			List<SearchMissingListVO> list = command.searchMissingList(event
					.getSearchMissingList());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			if (de.getMessage() == null)
				throw new EventException(de.toString());
			else
				throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Missing List popup 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchOnTimeList(Event e) throws EventException {
		log.debug("\n searchOnTimeList start ");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0074Event event = (EsdSce0074Event) e;

		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			List<SearchMissingListVO> list = command.searchOnTimeList(event
					.getSearchMissingList());

			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			if (de.getMessage() == null)
				throw new EventException(de.toString());
			else
				throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieving Missing Detail Report
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse searchDetailMissingList(Event e)
			throws EventException {
		log.debug("\n searchDetailMissingList start ");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0074Event event = (EsdSce0074Event) e;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			List<SearchMissingListVO> list = command
					.searchDetailMissingList(event.getSearchMissingList());
			eventResponse.setRsVoList(list);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			if (de.getMessage() == null)
				throw new EventException(de.toString());
			else
				throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Missing List Update
	 * 
	 * @param Event e
	 * @param String dist
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateMissingListSave(Event e, String dist)
			throws EventException {
		log.debug("\n updateMissingListSave start  ");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0074Event event = (EsdSce0074Event) e;

		try {
			
			SearchMissingListVO[] list = event.getSelectedMissingList();
			List<Edi315SendVO> edi315SendVOs = new ArrayList<Edi315SendVO>();
			
			//edi315SendVOs = event.getEdi315SendVOs();
			if (list != null && list.length > 0) {
				log.debug("vos size : " + list.length);
				for (int n = 0; n < list.length; n++) {
					Edi315SendVO vo = new Edi315SendVO();
					vo.setCreId(account.getUsr_id());
					vo.setUpdId(account.getUsr_id());
					vo.setBkgNo(list[n].getSBkgNo());
					vo.setEdiStatus(list[n].getEdiStsCd());
					vo.setEventYard(list[n].getNodCd());
					vo.setEventDt(list[n].getActDt1()
								+ list[n].getActDt2());
					vo.setCustStatus( list[n].getEdiSubStsCd());					
					if (dist.equals("SAVE")) {
						vo.setCallFrom("LOG");
					} else {
						vo.setCallFrom("MAN");
					}	
					edi315SendVOs.add(vo);
					log.debug("vo[" + n + "]: Cre ID :"
							+ edi315SendVOs.get(n).getCreId());
					log.debug("vo[" + n + "]: Udp ID :"
							+ edi315SendVOs.get(n).getUpdId());
					
				}// for
				sendEdi315(edi315SendVOs);
			}// if



			eventResponse = searchDetailMissingList(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * My Performance Report Modify 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPerRepPupModi(Event e) throws EventException {

		log.debug("\n searchPerRepPupModi start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0073Event event = (EsdSce0073Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			List<SearchPerRepPupModiVO> list = command
					.searchPerRepPupModi(event.getMyCustInfo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * checking duplidate My Performance Report Modify
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updatePerformanceCnt(Event e) throws EventException {
		log.debug("\n updatePerformanceCnt start ");
		EsdSce0073Event event = (EsdSce0073Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();
		EventResponse eventResponse = null;

		try {
			eventResponse = command.updatePerformanceCnt(event.getMyUserInfo(),
					event.getMyUserInfos(), event);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * updating My Performance Report Modify
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updatePerformance(Event e) throws EventException {
		log.debug("\n updatePerformance start!! ");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CustomerEdiBC command = new CustomerEdiBCImpl();
			command.updatePerformance(e);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * updating My Performance Report Modify
	 * 
	 * @param Event e
	 * @throws EventException
	 */
	public void updatePerformanceModify(Event e) throws EventException {
		log.debug("\n updatePerformanceModify start!! ");
		// GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CustomerEdiBC command = new CustomerEdiBCImpl();
			command.updatePerformanceModify(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		// return eventResponse;
	}

	/**
	 * retrieving My Page - My Customer
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchMyCustomer(Event e) throws EventException {
		log.debug("\n searchMyCustomer start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EsdSce0090Event event = (EsdSce0090Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			List<SearchMyCustomerVO> list = command.searchMyCustomer(account
					.getUsr_id());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving My Page - My Performance Report
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchMyPerformance(Event e) throws EventException {
		log.debug("\n searchMyPerformance start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//EsdSce0090Event event = (EsdSce0090Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			List<SearchMyPerformanceVO> list = command
					.searchMyPerformance(account.getUsr_id());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * delete My Page - My Customer
	 * 
	 * @param Event e
	 * @throws EventException
	 */
	public void deleteMyCustomer(Event e) throws EventException {
		log.debug("\n deleteMyCustomer start!! ");

		try {
			begin();
			CustomerEdiBC command = new CustomerEdiBCImpl();
			command.deleteMyCustomer(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * delete My Page - My Performance
	 * 
	 * @param Event e
	 * @throws EventException
	 */
	public void deleteMyPerformance(Event e) throws EventException {
		log.debug("\n deleteMyPerformance start ");

		try {
			begin();
			CustomerEdiBC command = new CustomerEdiBCImpl();
			command.deleteMyPerformance(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieving Customer Information
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchGroupID(Event e) throws EventException {
		log.debug("\n searchGroupID start ");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0073Event event = (EsdSce0073Event) e;

		CustomerEdiBC command = new CustomerEdiBCImpl();
		//Map<String, String> data = new HashMap<String, String>();
		//DBRowSet dbRowSet = null;
		try {
			List<SearchCsInfoVO> list = command.searchCsInfo(event
					.getSchSROptsVO());
			SearchCsInfoVO vo = null;
			if (list.size() > 0) {
				vo = (SearchCsInfoVO) list.get(0);
				eventResponse.setETCData("edi_grp_id", vo.getCsGrpId());
				eventResponse.setETCData("tp_id", vo.getTpId());
				eventResponse.setETCData("grp_nm", vo.getCsDesc());
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * retrieving Exception Type List
	 * 
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchExptTPList() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			log.debug("SC - searchExptTPList");
			List<SearchExptTPListVO> list = command.searchExptTPList();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Exception Detail Type list
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchExptDTLTPList(Event e) throws EventException {
		EsdSce0049Event event = (EsdSce0049Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			log.debug("SC - searchExptDTLTPList");

			List<SearchExptDTLTPListVO> list = command
					.searchExptDTLTPList(event.getExpInfo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Exception Type
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTOLExptTPList() throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();
		// EsdSce0029Event event = (EsdSce0029Event)e;

		try {
			log.debug("\n searchTOLExptTPList");
			List<SearchExptTPListVO> list = command.searchTOLExptTPList();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Exception Detail Type List
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTOLExptDTLTPList(Event e) throws EventException {
		EsdSce0029Event event = (EsdSce0029Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			log.debug("\n searchTOLExptDTLTPList");

			List<SearchExptDTLTPListVO> list = command
					.searchTOLExptDTLTPList(event.getExpInfo());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Exception Office Mapping(searchExpMapgOfcList3) &&&
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExpMapgOfcList3(Event e) throws EventException {
		EsdSce0112Event event = (EsdSce0112Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			log.debug("\n sc-searchExpMapgOfcList3");
			List<SearchExpMapgOfcList3VO> list = command
					.searchExpMapgOfcList3(event.getExpMastOfc());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Exception Office Mapping(master office)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpMasterOfcList(Event e) throws EventException {

		EsdSce0112Event event = (EsdSce0112Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();

		try {
			log.debug("\n searchExpMasterOfcList");

			List<SearchExpMasterOfcListVO> list = command
					.searchExpMasterOfcList(event.getExpMastOfc());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Exception Office Mapping(searchExpMapgOfcList) &&&
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpMapgOfcList() throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ExceptionDataBC command = new ExceptionDataBCImpl();
		try {
			log.debug("\n searchExpMapgOfcList");
			List<SearchExpMapgOfcListVO> list = command.searchExpMapgOfcList();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Exception Office Mapping(multiExpMapgOfc) &&&
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void multiExpMapgOfc(Event e) throws EventException {

		ExceptionDataBC command = new ExceptionDataBCImpl();
		log.debug("usr_id:" + account.getUsr_id());

		try {
			begin();
			command.multiExpMapgOfc(e, account.getUsr_id());
			commit();

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * retrieving My Performance
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getMyPerformance(Event e) throws EventException {
		log.debug("EsdSce0072 - getMyPerformance");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0072Event event = (EsdSce0072Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			List<GetMyPerformanceSelectVO> list = command
					.getMyPerformance(event.getSchEpOpts());
			// ETCData 적용
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving Mdm Location Info
	 * 
	 * @param List<Edi315SendVO> models
	 * @param boolean ibflgChk
	 * @return String
	 * @exception EventException
	 */
	private String searchMdmLocation(List<Edi315SendVO> models, boolean ibflgChk)
			throws EventException {

		String resultFlag = null;
		try {
			CustomerEdiBC command = new CustomerEdiBCImpl();
			resultFlag = command.searchMdmLocation(models, ibflgChk);
			return resultFlag;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

}

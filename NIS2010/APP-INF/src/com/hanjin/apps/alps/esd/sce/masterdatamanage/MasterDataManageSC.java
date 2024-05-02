/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ScemSetupSC.java
 *@FileTitle : Exception Alert/통지 대상 등록 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-28
 *@LastModifier : yong_cheon_shin
 *@LastVersion : 1.0
 * 2006-08-28 yong_cheon_shin
 * 1.0 최초 생성
 * 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거
 * 2011.12.01 전준영 [CLT-111121289]Split R4J 소스품질 결함 조치 - Null Dereferencing(객체에 NULL이 배정된 이후 객체에 대한 참조를 하지 말아야 한다
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBC;
import com.hanjin.apps.alps.esd.sce.edi315send.basic.Edi315SendBCImpl;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.basic.ActivityDataBC;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.basic.ActivityDataBCImpl;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event.EsdSce0022Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.event.EsdSce0024Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo.SearchActivityListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.basic.ActualDataBC;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.basic.ActualDataBCImpl;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.event.EsdSce0030Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.basic.CustomerEdiBC;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.basic.CustomerEdiBCImpl;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0032Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0035Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0060Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0061Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0062Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0063Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0065Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0066Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0067Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0068Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0072Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0073Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0074Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0080Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.GetMyPerformanceSelectVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchComboPerformanceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCsInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustStsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomTpIdVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerInqueryVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEstimationListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMissingListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyCustomerVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchMyPerformanceVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerCsInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchPerRepPupModiVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchStsListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.UpdateCargoTrackingDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.basic.ExceptionDataBC;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.basic.ExceptionDataBCImpl;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0026Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0028Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0029Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0049Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0112Event;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMapgOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpMasterOfcListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeDetailListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExpTypeListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDTLTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailList3VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStr2VO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptDetailQueryStrVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptSubReqListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchExptTPListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchSubscriberGroupMappingVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.exceptiondata.vo.SearchToleranceListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmActivityVO;

/**
 * ENIS-SCEM Business Logic ServiceCommand<br>
 * - ENIS-SCEM에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author yong_cheon_shin
 * @see UI_EsdSce0028EventResponse,ScemSetupDBDAO 참조
 * @since J2EE 1.4
 */
public class MasterDataManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SCEM 업무 시나리오 선행작업<br>
	 * ScemSetup업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ScemSetupSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * SCEM 업무 시나리오 마감작업<br>
	 * ScemSetup업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("ScemSetupSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ENIS-SCEM 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
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
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyActivityAttribute(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchSKDLogicList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiSKDLogic(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpTypeList();
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				multiExpType(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				multiExpTypeDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExpTypeDetailList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchExptDetailList3(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
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
				eventResponse = multiTolerance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { 
				eventResponse = searchTOLExptTPList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) { 
				eventResponse = searchTOLExptDTLTPList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsdSce0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchActualSourceList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse= searchActivityCombo(e);
			}
		}

		/*
		 * EventResponse eventResponse = null;
		 * 
		 * // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분 if
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
		// Shin yong cheon start
		else if (e.getEventName().equalsIgnoreCase("EsdSce0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				log.debug("1:032이번트발생");
				eventResponse = getCustomerData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEdiStatusData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCsInfoList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsdSce0035Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEdiSummaryReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDetailMvmtReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDetailOtherReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateDetailReportMvmtSave(e, "SAVE");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = updateDetailReportMvmtSave(e, "SEND");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = updateDetailReportOtherSave(e, "SAVE");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = updateDetailReportOtherSave(e, "SEND");
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = searchCsInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				/* This Section may use the same function as one of 0072 program */
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCargoTrackingData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
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
			/* Person who was in charge: Jun Byoung Suk */
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEDIPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEDITotalPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchComboPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCustSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = getMyPerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPerCsInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchPerCsTpIdInfo(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchUsrPerformanceSettingInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPerRepPupModi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = updatePerformanceCnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEdiGrpCgoSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = updatePerformance(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				updatePerformanceModify(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchGroupID(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchPerCsTpIdInfo1(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removePerRepPupModi(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0074Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMissingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOnTimeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateMissingListSave(e, "SEND");
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdSce0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimation(e);
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
		// Exception Office Mapping 추가 &&&
		else if (e.getEventName().equalsIgnoreCase("EsdSce0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchExpMasterOfcList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				multiExpMapgOfc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExpMapgOfcList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchExpMapgOfcList3(e);
			}
		}
		// shin yong cheon end
		return eventResponse;
	}

	/*
	 * ============================================= 강성문
	 * =========================================================
	 */
	/**
	 * Activity Attribute Management 조회<br>
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
	 * Activity Attribute Management 수정<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyActivityAttribute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0022Event event = (EsdSce0022Event) e;

		try {
			begin();
			ActivityDataBC command = new ActivityDataBCImpl();
			command.modifyActivityAttribute(event.getMdmActivityVOs());
			commit();
			return (eventResponse);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * COP Scheduling Logic Registration 조회<br>
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
	 * COP Scheduling Logic Registration 입력/수정<br>
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
	 * Exception Type Registration 조회<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpTypeList() throws EventException {

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
	 * Exception Type Detail Registration 議고쉶<br>
	 * 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExpTypeDetailList() throws EventException {

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
	 * Exception Type Registration ?낅젰/?섏젙<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void multiExpType(Event e) throws EventException {

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
	 * Exception Type Detail Registration ?낅젰/?섏젙<br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	public void multiExpTypeDetail(Event e) throws EventException {

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
	 * Actual Source Registration 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualSourceList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0030Event event = (EsdSce0030Event) e;
		ActualDataBC command = new ActualDataBCImpl();

		try {

			List<SearchActualDataListVO> list = command
					.searchActualSourceList(event.getActualInfo());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Actual Combo 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActivityCombo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ActualDataBC command = new ActualDataBCImpl();

		try {
			List<MdmActivityVO> list = command.searchActivityCombo();
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Exception Tolerance Registration 조회<br>
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
	 * Exception Tolerance Registration 입력/수정<br>
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
	 * minestar - 수정 Subscriber Registration 입력/수정<br>
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
	 * minestar - 수정 Exception Subscriber Registration 입력/수정<br>
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
	 * minestar - 수정 Exception Subscriber Registration 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExptNoticeSubscriberList(Event e)
			throws EventException {

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
	 * Rail Delay Exception Tolerance 가져오기 - old minestar - 수정 : COP Exception
	 * Tp 정보 가져오기
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
	 * Rail Delay Exception Tolerance 媛?몄삤湲?
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchExptDetail(Event e) throws EventException {

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
	 * Edi Customer data Event 처리
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
			// List<SearchCustomerDataVO> list =
			// command.searchCustomerData(event.getSchCust());
			// 조회용 VO 적용
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
	 * Edi Status data Event 처리
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
	 * Detail Report 정보를 수정한다.
	 * 
	 * @param Event e
	 * @param String dist
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateDetailReportMvmtSave(Event e, String dist)
			throws EventException {
		EventResponse eventResponse = null;
		EsdSce0035Event event = (EsdSce0035Event) e;
		List<Edi315SendVO> edi315SendVOs = null;

		edi315SendVOs = event.getEdi315SendVOs();
		if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
			log.debug("vos size : " + edi315SendVOs.size());
			/* Cre ID 및 Upd ID 를 세팅하는 부분 */
			for (int n = 0; n < edi315SendVOs.size(); n++) {
				edi315SendVOs.get(n).setCreId(account.getUsr_id());
				edi315SendVOs.get(n).setUpdId(account.getUsr_id());
			}// for
		}// if

		try {
			// 저장전 mdm_location 체크
			String locCd = searchMdmLocation(edi315SendVOs, false);
			if (locCd != null && locCd.length() > 0) {
				throw new EventException(new ErrorHandler("BKG00061",
						new String[] { locCd }).getMessage());

			}
			sendEdi315(edi315SendVOs);
			eventResponse = searchDetailMvmtReport(e);
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Edi Document Send
	 * 
	 * @param List<Edi315SendVO> edi315SendVOs
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse sendEdi315(List<Edi315SendVO> edi315SendVOs)
			throws EventException {
		Edi315SendBC command = new Edi315SendBCImpl();
//		EventResponse eventResponse = null;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
				int len = edi315SendVOs.size();
				String[] result_str = new String[len];
				for (int m = 0; m < len; m++) {
					begin();
					result_str[m] = command
							.edi315Send((Edi315SendVO) edi315SendVOs.get(m));
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
	 * Detail Report (Others 리스트) 정보를 수정한다.
	 *
	 * @param Event e
	 * @param String dist
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateDetailReportOtherSave(Event e, String dist)
			throws EventException {
		EventResponse eventResponse = null;
		EsdSce0035Event event = (EsdSce0035Event) e;
		List<Edi315SendVO> edi315SendVOs = null;

		edi315SendVOs = event.getEdi315SendVOs();
		if (edi315SendVOs != null && edi315SendVOs.size() > 0) {
			/* Cre ID 및 Upd ID 를 세팅하는 부분 */
			for (int n = 0; n < edi315SendVOs.size(); n++) {
				edi315SendVOs.get(n).setCreId(account.getUsr_id());
				edi315SendVOs.get(n).setUpdId(account.getUsr_id());
			}// for
		}// if

		try {
			// 저장전 mdm_location 체크
			String locCd = searchMdmLocation(edi315SendVOs, false);
			if (locCd != null && locCd.length() > 0) {
				throw new EventException(new ErrorHandler("BKG00061",
						new String[] { locCd }).getMessage());

			}
			sendEdi315(edi315SendVOs);
			eventResponse = searchDetailOtherReport(e);
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * Edi Summary Report 리스트 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEdiSummaryReport(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Edi Detail Report - Mvmt 리스트 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDetailMvmtReport(Event e) throws EventException {
		
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Edi Detail Report - Others 리스트 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDetailOtherReport(Event e) throws EventException {

		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Customer Information 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCsInfo(Event e) throws EventException {
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
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Cargo Tracking Data 를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */

	public EventResponse searchCargoTrackingData(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Cargo Tracking 정보를 수정한다.(EDI전송)
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateCargoTrackingSave(Event e) throws EventException {
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
				vo.setCallFrom("LOG");
				/*
				 * in order to send objects to EDI function, vo change into
				 * HashMap named model
				 */
				HashMap model = new HashMap();
				model = vo.getColumnValues();

				Set keySet = model.keySet();
				Object[] keys = keySet.toArray();
				for (int b = 0; b < keySet.size(); b++) {
					log.debug("key[" + keys[b] + "]" + " value["
							+ model.get(keys[b]) + "]");
				}// for

				/*
				 * Mating VO's values from Screen Cells with VO's values for
				 * send function
				 */
				Edi315SendVO sendvo = new Edi315SendVO();
				/* 기 정의된값 세팅 */
				sendvo.setCreId(account.getUsr_id());
				sendvo.setUpdId(account.getUsr_id());
				// sendvo.setCallFrom("COP");
				sendvo.setCallFrom("MAN");
				/* Save 기능과 Send 기능을 구분함 */
				sendvo.setLogFlg("Y");
				sendvo.setManFlg("Y");
				/* 화면에서 받아온 값을 VO 에 정의함 */
				sendvo.setBkgNo(vo.getBkgNo());
				sendvo.setCntrNo(vo.getCntrNo());
				sendvo.setEdiStatus(vo.getEdiSts());
				sendvo.setCustStatus(vo.getCustSts());
				sendvo.setEventYard(vo.getNod());
				sendvo.setEventDt(vo.getEventDt());

				/* 2010.02.09 추가 */
				sendvo.setIbflag("I");
				/* I 일경우에만 add 하기때문에 for 문의 i 값과 다를수 있다 */
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
			// 저장전 mdm_location 체크
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
	 * Cargo Tracking 정보를 수정한다.(EDI전송)
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
				HashMap model = new HashMap();
				model = vo.getColumnValues();

				Set keySet = model.keySet();
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
				/* 기 정의된값 세팅 */
				sendvo.setCreId(account.getUsr_id());
				sendvo.setUpdId(account.getUsr_id());
				sendvo.setCallFrom("MAN");
				/* Save 기능과 Send 기능을 구분함 */

				sendvo.setLogFlg("");
				sendvo.setManFlg("Y");
				log.debug("setLogFlg - " + sendvo.getLogFlg());
				/* 화면에서 받아온 값을 VO 에 정의함 */
				sendvo.setBkgNo(vo.getBkgNo());
				sendvo.setCntrNo(vo.getCntrNo());
				sendvo.setEdiStatus(vo.getEdiSts());
				sendvo.setCustStatus(vo.getCustSts());
				sendvo.setEventYard(vo.getNod());
				sendvo.setEventDt(vo.getEventDt());
				/* 2010.02.09 추가 */
				sendvo.setIbflag(vo.getIbflag());
				/* TestCode */
				/* I 일경우에만 add 하기때문에 for 문의 i 값과 다를수 있다 */
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
			// 저장전 mdm_location 체크
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
	 * updateCargoTrackingData - Save 기능을 구현함
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
					HashMap model = new HashMap();
					model = vo.getColumnValues();

					Set keySet = model.keySet();
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
					/* 기 정의된값 세팅 */
					sendvo.setCreId(account.getUsr_id());
					sendvo.setUpdId(account.getUsr_id());
					// 2010-03-10 MAN 변경
					// sendvo.setCallFrom("COP");
					sendvo.setCallFrom("MAN");

					/* Save 기능과 Send 기능을 구분함 */
					if ("SAVE".equalsIgnoreCase(dist)) {
						sendvo.setLogFlg("Y");
					} else if ("SEND".equalsIgnoreCase(dist)) {
						sendvo.setLogFlg("");
					}// if
					sendvo.setManFlg("Y");

					/* 화면에서 받아온 값을 VO 에 정의함 */
					sendvo.setEdiStatus(vo.getEdiSts());
					sendvo.setCustStatus(vo.getCustSts());
					sendvo.setEventDt(vo.getEventDt());
					sendvo.setBkgNo(vo.getBkgNo());
					sendvo.setCntrNo(vo.getCntrNo());
					sendvo.setEventYard(vo.getNod());
					/* 2010.02.09 추가 */
					sendvo.setIbflag(isSave);

					/* I 일경우에만 add 하기때문에 for 문의 i 값과 다를수 있다 */
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

			// 저장전 mdm_location 체크
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
	 * EDI Customer 관련 data Search
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
	 * Customer Inquiry 에서 중복 저장을 막기위에 해당 데이터를 찾음~~
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
	 * customer tp id가 2개 이상이 었을 경우
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
	 * 조회 이벤트 처리<br>
	 * VVD 화면에 대한 조회 이벤트 처리<br>
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
	 * 조회 이벤트 처리<br>
	 * VVD 화면에 대한 조회 이벤트 처리<br>
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
	 * Edi Performance Report Missing 리스트 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEDIPerformance(Event e) throws EventException {
		log.debug("MasterDataManageSC -  searchEDIPerformance");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Edi Performance Report on-time-performance 리스트 조회
	 * 
	 * @param Event e

	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEDITotalPerformance(Event e)
			throws EventException {
		log.debug("MasterDataManageSC -  searchEDITotalPerformance");
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Edi Performance Report Combo 리스트 조회
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
			// 조회용 VO 적용
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
	 * Edi CustSts 조회
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
			// 조회용 VO 적용
			List<SearchCustStsVO> list = command.searchCustSts(event
					.getSchEpOpts());
			// ETCData 적용
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
	 * Customer Information 조회
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
	 * Customer TP ID Information 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPerCsTpIdInfo(Event e) throws EventException {
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
	 * Customer TP ID Information 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPerCsTpIdInfo1(Event e) throws EventException {
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
	 * Missing List popup 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchMissingList(Event e) throws EventException {
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
	 * Missing List popup 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchOnTimeList(Event e) throws EventException {
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
	 * Missing Detail Report 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse searchDetailMissingList(Event e)
			throws EventException {
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
				/* Cre ID 및 Upd ID 를 세팅하는 부분 */
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

	
				/*
				 * Iterator itr = models.iterator(); HashMap model = null;
				 * String isSave = ""; int i = 1; while (itr.hasNext()) { model
				 * = (HashMap)itr.next();
				 * 
				 * isSave = (String)model.get("ibflgs"); if(isSave.equals("I")
				 * || isSave.equals("U")){ log.debug("\n isSave : " + isSave);
				 * // EAI 호출을 통한 EDI send
				 * log.debug("\n updateMissingListSave count : " + i++);
				 * 
				 * //model = getParameterMap(model); model.put("bkg_no",
				 * (String)model.get("bkg_no")); model.put("bkg_no_split",
				 * (String)model.get("bkg_no_split")); model.put("cntr_no",
				 * (String)model.get("cntr_no")); model.put("edi_sts",
				 * (String)model.get("edi_sts"));
				 * 
				 * model.put("nod", (String)model.get("nod"));
				 * model.put("event_dt", (String)model.get("act_dt_days") +
				 * (String)model.get("act_dt_hours"));
				 * 
				 * log.debug("\n bkg_no : " + (String)model.get("bkg_no"));
				 * if(dist.equals("SAVE")){ model.put("call_from","LOG"); }else{
				 * model.put("call_from","MAN"); }
				 * 
				 * log.debug("\n cust_st : " + (String)model.get("cust_st"));
				 * model.put("cust_st", (String)model.get("cust_st"));
				 * 
				 * //20071018 유저에 의해 로그인 ID저장하기 START model.put("usr_id",
				 * account.getUsr_id()); //20071018 유저에 의해 로그인 ID저장하기 END
				 * 
				 * sendEDIData_document(model); }
				 */
			//}

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
	 * Vessel Schedule Accuracy 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEstimation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0080Event event = (EsdSce0080Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
			List<SearchEstimationListVO> list = command.searchEstimation(event
					.getSearchEstimationListVO());
			eventResponse.setRsVoList(list);

		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
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
        	// edi_usr_cust table check 0이면 기본 테이블 아니면 사용자 테이블
			List<SearchPerRepPupModiVO> list = null;
        	int cnt = 0;
        	cnt = command.checkUsrPerformanceSettingInfo(event.getMyCustInfo());
        	if(cnt == 0){
        		list = command.searchUsrPerformanceBasicForm(event.getMyCustInfo());
        	}else if(cnt != 0){
        		list = command.searchPerRepPupModi(event.getMyCustInfo());
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
	 * My Performance Report Edi Group code 별 EDI Standard Status Code 및 Customer Status Code 정보 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchEdiGrpCgoSts(Event e) throws EventException {

		log.debug("\n searchEdiGrpCgoSts start!! ");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0073Event event = (EsdSce0073Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();

		try {
        	// edi_usr_cust table check 0이면 기본 테이블 아니면 사용자 테이블
			List<SearchPerRepPupModiVO> list = null;
        		list = command.searchEdiGrpCgoSts(event.getMyCustInfo());
        	eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * My Performance Report Modify 중복 체크
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
	 * My Performance Report Modify 저장
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
	 * My Performance Report Modify 저장
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
	 * My Page - My Customer 조회
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
	 * My Page - My Performance Report 조회
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
	 * My Page - My Customer 삭제
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
	 * My Page - My Performance 삭제
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
	 * Customer Information 조회
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
	 * Exception Type을 선택하는 Function
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
	 * Exception Detail Type을 선택하는 Function
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
	 * Exception Type을 선택하는 Function
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
	 * Exception Detail Type을 선택하는 Function
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTOLExptDTLTPList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
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
	 * Exception Office Mapping(master office) 조회 &&&
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

		log.debug("SC - multiExpMapgOfc 호출 완료");
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
	 * My Performance 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getMyPerformance(Event e) throws EventException {
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
	 * Mdm Location 정보 유효성 조회
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
	
	/**
	 * Customer Information List 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCsInfoList(Event e) throws EventException {
		log.debug("MasterSC is called");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0032Event event = (EsdSce0032Event) e;
		CustomerEdiBC command = new CustomerEdiBCImpl();
		String[] csGrpId = new String[4];
		try {
			csGrpId = command.searchCsInfoList(event.getCusEdiOpt());
			eventResponse.setETCData("cs_grp_id", csGrpId[0]);
			eventResponse.setETCData("tp_id", csGrpId[1]);
			eventResponse.setETCData("grp_nm", csGrpId[2]);
			eventResponse.setETCData("grp_desc", csGrpId[3]);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	
    /**
     * 조회 이벤트 처리<br>
     * Performance Setting Info 조회 이벤트 처리<br>
     *
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchUsrPerformanceSettingInfo(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsdSce0073Event event         = (EsdSce0073Event)e ;
        List<SearchPerRepPupModiVO> list = null;
        try {
        	CustomerEdiBC command = new CustomerEdiBCImpl();
        		list = command.searchUsrPerformanceSettingInfo(event.getMySearchperPup());
			eventResponse.setRsVoList(list);      
        } catch (EventException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        return eventResponse;
    }
    
	/**
	 * My Performance Report 삭제
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse removePerRepPupModi(Event e) throws EventException {
		log.debug("\n removePerRepPupModi start!! ");
		 GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdSce0073Event event = (EsdSce0073Event) e;
		try {
			begin();
			CustomerEdiBC command = new CustomerEdiBCImpl();
			command.removePerRepPupInfo(event.getMyCustInfo());
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}

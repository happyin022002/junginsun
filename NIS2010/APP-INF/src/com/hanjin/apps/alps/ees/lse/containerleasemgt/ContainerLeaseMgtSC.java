/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerLeaseMgtSC.java
*@FileTitle : Long Term Lease CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
* =======================================================
* 2011.06.13 남궁진호 [CHM-201111467-01] [LSE] MDM에 R9 등록에 따른 추가 업무 진행 요청
* 2013.08.13 채창호 [CHM-201325598]Split 02-EQR T/F 관련 LEGACY 연계 방안 및 일정
* 2013.11.04 채창호[CHM-201327356]EQR RE-OPEN과 관련하여 ALPS LEASE ON-HIRE APPROVAL CREATION/UPDATE/INQUIRY 화면 INTERFACE 요청
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EesLse0020Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EesLse0021Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EesLse0022Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EesLse0101Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EesLse0104Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireContainerListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.basic.EqInterchangeRequestBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.basic.EqInterchangeRequestBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0107Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0108Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0109Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0110Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0111Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0112Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.event.EesLse0113Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.AvailableOnewayInventoryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeReqVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.EqInterchangeVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo.SearchOfferInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.basic.ImmediateExitBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.basic.ImmediateExitBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.event.EesLse0025Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.basic.LeasePlanBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.basic.LeasePlanBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0024Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0034Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0037Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0046Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0046PopEvent;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0048Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0049Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.event.EesLse0051Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration.LeasePlanDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanPerformanceDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.LeasePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePerformanceVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanRccVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo.OffHirePlanVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.basic.LeaseReportBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.basic.LeaseReportBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0036Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0039Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0040Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0052Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0053Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0054Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0057Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0058Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0087Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0088Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0089Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0090Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0092Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0094Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.InventoryDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.InventorySummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutSummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.UsingDayDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.vo.UsingDaySummaryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.basic.MisUseApprovalBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.basic.MisUseApprovalBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.event.EesLse0027Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.event.EesLse0028Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.event.EesLse0093Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseContainerInfoVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseInOutInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.basic.OnhireApprovalBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.basic.OnhireApprovalBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0029Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0030Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0031Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0032Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0047Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.event.EesLse0103Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.vo.SearchRequestListVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.basic.TermChangeBC;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.basic.TermChangeBCImpl;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.event.EesLse0005Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.event.EesLse0006Event;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBCImpl;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LseOnhAproVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;


/**
 * ALPS-ContainerLeaseMgt Business Logic ServiceCommand - ALPS-ContainerLeaseMgt 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Nho Jung Yong
 * @see LeasePlanDBDAO
 * @since J2EE 1.4
 */

public class ContainerLeaseMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ContainerLeaseMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * ContainerLeaseMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd() {
		log.debug("ContainerLeaseMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-ContainerLeaseMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		// EesLse0048Event : Long Term Lease CNTR Delivery Plan
		if (e.getEventName().equalsIgnoreCase("EesLse0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLongTermCNTRDeliveryPlanService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLongTermCNTRDeliveryPlanAgreementCheckService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLongTermCNTRDeliveryPlanService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0049Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLongTermCNTRDeliveryPerformanceService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchLongTermCNTRDeliveryPerformanceDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnhireApprovalNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnhireApprovalNumberBrieflyService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createOnhireApprovalNumberService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnhireApprovalLiftOnChargeService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOnhireApprovalDolListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchOnhireApprovalEccListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHirePlanService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOffHirePlanService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = createOffHirePlanNewVerService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0030Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {

				eventResponse = searchOnhireApprovalNumber2Service(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {

				eventResponse = cancelOnhireApprovalNumberService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {

				eventResponse = modifyOnhireApprovalNumberService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOnhireApprovalDolListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchOnhireApprovalEccListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalOwnListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createApprovalOwnContainerService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNewVanCNTRDeliveryPlanAvailService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNewVanCNTRDeliveryPlanListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageNewVanCNTRDeliveryPlanListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNewVanCNTRDeliveryPlanPerformanceListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchNewVanCNTRDeliveryPlanPerformanceDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAvailParamActivityDateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTermChangeCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createTermChangeCreationListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTermChangeInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPickupStatusSummaryService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPickupStatusDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchImmediateExitCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createImmediateExitCreationListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHirePlanByRCCService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOffHirePlanByRCCService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//화면오픈
				eventResponse = initPage(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNewMisUseRequestNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMisUseReqContainerExistService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMisUseRequestContainerService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createMisUseRequestNumberListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHirePerformanceService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNewMisUseApprovalNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMisUseRequestNoItemsService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMisUseRequestInfoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMisUseReqContainerListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createMisUseApprovalNumberListService(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EesLse0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireResultbyLocationAgreementSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnHireResultbyLocationAgreementDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireResultbyLocationAgreementSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffHireResultbyLocationAgreementDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0093Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMisUseInOutInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyMisUseApprovalCancelListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireResultAvgUsingDaySummaryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffHireResultAvgUsingDayDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireResultbyTermLessorSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnHireResultbyTermLessorDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireResultByTermLessorSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffHireResultByTermLessorDetailService (e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireResultvsDOLSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffHireResultvsDOLDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalContainerInventorySummaryListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTotalContainerInventoryDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNewContainerReceivingDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0094Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSubLeaseOutContainerSummaryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSubLeaseOutContainerDetailService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0087Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireReportbyRccSummaryService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0088Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireReportbyMonthSummaryService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0089Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireReportbyRccSummaryService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0090Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireReportbyMonthSummaryService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0020Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireContainerSummaryService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndAvailableOffHireContainerSummaryService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0021Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireContainerDetailService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndAvailableOffHireContainerDetailService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendToEmailAvailableOffHireContainerService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0046PopEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHirePlanByRCCDOLService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//화면오픈
				eventResponse = initPage(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0022Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireContainerConfirmService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndAvailableOffHireContainerConfirmService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyAvailableOffHireContainerConfirmService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0092Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireTotalSummaryByLeaseTermYearService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireYardCodeListService(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesLse0103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchReqListTietleCodeService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchEqrReqListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireContainerListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndSearchAvailableOffHireContainerListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqInterchangeReqService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyEqInterchangeReqService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEqInterchangeReqNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEqInterchangeEMUCostService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqInterchangeApprovalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyEqInterchangeApprovalService(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesLse0109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqInterchangeUpdateService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEqInterchangeAuthNumberService(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyEqInterchangeUpdateService(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyEqInterchangeUpdateCancelService(e);
		    }	
		}else if (e.getEventName().equalsIgnoreCase("EesLse0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfferInquiryService(e);
			}
		
        } else if (e.getEventName().equalsIgnoreCase("EesLse0111Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEqInterchangeSummaryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEqInterchangeDetailListService(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("EesLse0112Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAvailableOnewayService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//화면오픈
				eventResponse = initPage(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("EesLse0113Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnewayLoadingPFMCService(e);
			} else if ( e.getFormCommand().isCommand(FormCommand.MULTI) ) {
				eventResponse = manageOnewayLoadingPFMCService(e);	
			} else if ( e.getFormCommand().isCommand(FormCommand.DEFAULT) ) {
				//화면오픈
				eventResponse = initPage(e);
			}
		} 
		return eventResponse;
	}

	/**
	 * 각 페이지 초기 Loading 시 처리 <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initPage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if ( e.getEventName().equalsIgnoreCase("EesLse0046Event")
			  || e.getEventName().equalsIgnoreCase("EesLse0046PopEvent")
		      || e.getEventName().equalsIgnoreCase("EesLse0112Event")
			  || e.getEventName().equalsIgnoreCase("EesLse0113Event")) { 	
				ContainerTypeSizeBC command = new ContainerTypeSizeBCImpl();
				List<MdmCntrTpSzVO> cntrTpSzlist = command.searchCntrTpSzListBasic();

				StringBuffer sCntrTpSzCd = new StringBuffer();

				for ( int i = 0 ; i < cntrTpSzlist.size() ; i++ ) {
					if ( sCntrTpSzCd.toString().equals("") ) {
						sCntrTpSzCd.append(cntrTpSzlist.get(i).getCntrTpszCd());
					} else {
						sCntrTpSzCd.append("|").append(cntrTpSzlist.get(i).getCntrTpszCd());
					}
				}

				eventResponse.setCustomData("cntr_tpsz_cd", sCntrTpSzCd.toString());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0048 : Retrieve<br>
	 * Long Term Lease CNTR Delivery Plan 리스트 조회<br>
	 *
	 * @param Event e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLongTermCNTRDeliveryPlanService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0048Event event = (EesLse0048Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<LeasePlanVO> list = command.searchLongTermCNTRDeliveryPlanBasic(event.getPlanSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0048 : RowAdd<br>
	 * Long Term Lease CNTR Delivery Plan 에 적합한 Agreement 여부 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLongTermCNTRDeliveryPlanAgreementCheckService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0048Event event = (EesLse0048Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			int cnt = command.searchLongTermCNTRDeliveryPlanAgreementCheckBasic(event.getPlanSearchVO());

			eventResponse.setETCData("agmt_cnt" , Integer.toString(cnt));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}


	/**
	 * EES_LSE_0048 : Save<br>
	 * Long Term Lease CNTR Delivery Plan 데이터 저장 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageLongTermCNTRDeliveryPlanService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0048Event event = (EesLse0048Event)e;
		LeasePlanBC command = new LeasePlanBCImpl();
		try{
			begin();
			command.manageLongTermCNTRDeliveryPlanBasic(event.getPlanSearchVO(), event.getLeasePlanVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10001").getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0049 : Retrieve<br>
	 * Long Term Lease CNTR Delivery Plan & Performance 의 리스트 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLongTermCNTRDeliveryPerformanceService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0049Event event = (EesLse0049Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<LeasePlanPerformanceVO> list = command.searchLongTermCNTRDeliveryPerformanceBasic(event.getPlanSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0049 : Grid DbClick<br>
	 * Long Term Lease CNTR Delivery Plan & Performance 의 Detail 리스트 조회<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchLongTermCNTRDeliveryPerformanceDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0049Event event = (EesLse0049Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<LeasePlanPerformanceDetailVO> list = command.searchLongTermCNTRDeliveryPerformanceDetailBasic(event.getPlanSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

    /**
	 * EES_LSE_0031 : Retrieve<br>
	 * Onhire 될 장비의 Approval number 내용을 조회하는 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0031Event event = (EesLse0031Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<OnhireApprovalVO> list = command.searchOnhireApprovalNumberBasic(event.getOnhireApprovalVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0031 : Onblur<br>
	 * OnhireApproval화면에 대한  Auth No조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalNumberBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0031Event event = (EesLse0031Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();

			List<LseOnhAproVO> list = command.searchOnhireApprovalNumberBrieflyBasic(event.getOnhLocCd() ,event.getLstmcd() , event.getPeriodStdt() , event.getPeriodEddt() );

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * EES_LSE_0029 : Save<br>
	 * 임차 컨테이너(장기.단기,OF) 임차 계약 후, 상세한 pick-up 승인 저장<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse createOnhireApprovalNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// Container Type/Size
		ContainerTypeSizeBC comCommand = new ContainerTypeSizeBCImpl();
		List<MdmCntrTpSzVO> cntrTpSzlist = comCommand.searchCntrTpSzListBasic();

		EesLse0029Event event = (EesLse0029Event)e;
		OnhireApprovalBC command = new OnhireApprovalBCImpl();
		OnhireApprovalVO onhireApprovalVO = new OnhireApprovalVO();
		try{
			begin();
			onhireApprovalVO.setLocCd(event.getLocCd());
			onhireApprovalVO.setLeaseTerm(event.getLeaseTerm());
			onhireApprovalVO.setPkupDueDt(event.getPkupDueDt());
			onhireApprovalVO.setAproRmk(event.getAproRmk());
			onhireApprovalVO.setTpszCd(event.getTpszCd());
			onhireApprovalVO.setReqNo(event.getReqno());
			onhireApprovalVO.setLocCod(event.getLocCod());
			onhireApprovalVO.setEccCd(event.getEccCd());

			String authNo = command.createOnhireApprovalNumberBasic( onhireApprovalVO, event.getOnhireApprovalVOs(),account, cntrTpSzlist);
			eventResponse.setETCData("cntr_onh_auth_no" , authNo);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
	 * EES_LSE_0030 : Retreive<br>
	 * Onhire 될 장비의 Approval number 내용을 조회하는 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalNumber2Service(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0030Event event = (EesLse0030Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<OnhireApprovalVO> list = command.searchOnhireApprovalNumber2Basic(event.getCntrOnhAuthNo() , event.getTysz());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * EES_LSE_0030 : Cancel<br>
	 * 장/단기 컨테이너 임차 계약 후, 상세한 pick-up 승인에 대하여 취소상황 발생시 취소처리<br>
	 *
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse cancelOnhireApprovalNumberService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0030Event event = (EesLse0030Event)e;
		OnhireApprovalBC command = new OnhireApprovalBCImpl();
		try{
			begin();
			command.cancelOnhireApprovalNumberBasic( event.getCntrOnhAuthNo(),event.getAgmtCtyCd(),event.getAgmtSeq(),account);
		    commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0030 : Save<br>
	 * 장/단기 컨테이너 임차 계약 후, 상세한 pick-up 승인에 대하여 변경 상황 발생시 up-date <br>
	 *
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyOnhireApprovalNumberService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// Container Type/Size
		ContainerTypeSizeBC comCommand = new ContainerTypeSizeBCImpl();
		List<MdmCntrTpSzVO> cntrTpSzlist = comCommand.searchCntrTpSzListBasic();

		EesLse0030Event event = (EesLse0030Event)e;
		OnhireApprovalBC command = new OnhireApprovalBCImpl();
		OnhireApprovalVO onhireApprovalVO = new OnhireApprovalVO();

		try{
			onhireApprovalVO.setLocCd(event.getOnhLocCd());
			onhireApprovalVO.setLstmCd(event.getLstmcd());
			onhireApprovalVO.setPkupDueDt(event.getPkupDueDt());
			onhireApprovalVO.setAproRmk(event.getAproRmk());
			onhireApprovalVO.setTpszCd(event.getTpszCd());
			onhireApprovalVO.setCntrOnhAuthNo(event.getCntrOnhAuthNo());
			onhireApprovalVO.setReqNo(event.getReqno());
			onhireApprovalVO.setLocCod(event.getLocCod());
			onhireApprovalVO.setEccCd(event.getEccCd());

			begin();
			command.modifyOnhireApprovalNumberBasic( onhireApprovalVO ,account, event.getOnhireApprovalVOs(), cntrTpSzlist);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0024 : Retrieve<br>
	 * Off-Hire Plan by H/Q 데이터 조회<br>
	 *
	 * @param  Event e
	 * @return EventResponse response
	 * @throws EventException
	 */
	private EventResponse searchOffHirePlanService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0024Event event = (EesLse0024Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<OffHirePlanVO> list = command.searchOffHirePlanBasic(event.getOffHirePlanSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0024 : Save<br>
	 * Off-Hire Plan by H/Q 데이터 저장 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @throws EventException
	 */
	private EventResponse manageOffHirePlanService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0024Event event = (EesLse0024Event)e;
		LeasePlanBC command = new LeasePlanBCImpl();
		try{
			begin();
			command.manageOffHirePlanBasic(event.getOffHirePlanVOs(), account);
			commit();
			//eventResponse.setUserMessage(new ErrorHandler("LSE10001").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0024 : Version Up<br>
	 * Off-Hire Plan by H/Q 데이터의 Vesrion UP 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @throws EventException
	 */
	private EventResponse createOffHirePlanNewVerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0024Event event = (EesLse0024Event)e;
		LeasePlanBC command = new LeasePlanBCImpl();
		try{
			begin();
			command.createOffHirePlanNewVerBasic(event.getOffHirePlanSearchVO(), account);
			commit();
			//eventResponse.setUserMessage(new ErrorHandler("LSE10004").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0034 : Condition<br>
	 * 입력받은 AGMT No.에 대한 유효성을 검증합니다.<br>
	 *
     * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewVanCNTRDeliveryPlanAvailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0034Event event = (EesLse0034Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			String checkDupYrmon = command.searchNewVanCNTRDeliveryPlanAvailBasic(event.getPlanSearchVO());
			eventResponse.setETCData("checkDupYrmon", checkDupYrmon);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0034 : Retrieve<br>
	 * 신조장비(OW/LP/OL) 계획목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewVanCNTRDeliveryPlanListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0034Event event = (EesLse0034Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<LeasePlanVO> list = command.searchNewVanCNTRDeliveryPlanListBasic(event.getPlanSearchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0034 : Save<br>
	 * 신조장비(OW/LP/OL) 계획목록을 일괄 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse manageNewVanCNTRDeliveryPlanListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0034Event event = (EesLse0034Event)e;
		LeasePlanBC command = new LeasePlanBCImpl();
		try{
			begin();
			command.manageNewVanCNTRDeliveryPlanListBasic(event.getLeasePlanVOs(),account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"NewVanContainerDeliveryPlanList Manage"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0037 : Retrieve<br>
	 * 신조(자가/장기)장비 인수계획 대비 실적목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewVanCNTRDeliveryPlanPerformanceListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0037Event event = (EesLse0037Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<LeasePlanPerformanceVO> list = command.searchNewVanCNTRDeliveryPlanPerformanceListBasic(event.getPlanSearchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0037 : Summary Grid(DbClick)<br>
	 * 신조(자가/장기)장비 인수계획 대비 실적별 상세내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewVanCNTRDeliveryPlanPerformanceDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0037Event event = (EesLse0037Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<LeasePlanPerformanceDetailVO> list = command.searchNewVanCNTRDeliveryPlanPerformanceDetailBasic(event.getPlanSearchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

    /**
	 * EES_LSE_0032 : Retrieve<br>
	 * 자가컨테이너 pick up 한 장비를 auth no를 부여하기위하여 내용을 조회하는 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchApprovalOwnListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0032Event event = (EesLse0032Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<OnhireApprovalOwnListVO> list = command.searchApprovalOwnListBasic(event.getLocCd() , event.getLocTp());

			List<OnhireApprovalOwnListVO> list2 = command.searchApprovalOwnSumListBasic(event.getLocCd() , event.getLocTp());


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}

			if ( list2.size() > 0 ) {
				eventResponse.setRsVoList(list2);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0005 : Condition<br>
	 * 입력받은 Activity Date에 대한 유효성을 검증합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailParamActivityDateService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0005Event event = (EesLse0005Event)e;
			TermChangeBC command = new TermChangeBCImpl();
			boolean availFlag = command.searchAvailParamActivityDateBasic(event.getSearchParamVO());

			eventResponse.setETCData("checkResult", availFlag ? "TRUE" : "FALSE");
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0005 : Retrieve<br>
	 * Term Change Creation 대상 장비목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTermChangeCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0005Event event = (EesLse0005Event)e;
			TermChangeBC command = new TermChangeBCImpl();
			List<TermChangeCreationVO> list = command.searchTermChangeCreationListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0005 : Save<br>
	 * Term Change Creation 대상 장비목록을 일괄 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createTermChangeCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0005Event event = (EesLse0005Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			//WAS JTX 설정을 위한 대용량 자료 필터링 기능을 추가
			TermChangeCreationVO[] termChangeCreationVOs = event.getTermChangeCreationVOs();
			List<TermChangeCreationVO> termChangeCreationVoList = new ArrayList<TermChangeCreationVO>();

			for(int i = 0; i < termChangeCreationVOs.length; i++) {
				if(termChangeCreationVOs[i].getDelChk().equals("-1")) {
					termChangeCreationVoList.add(termChangeCreationVOs[i]);
				}
			}

			begin();
			TermChangeCreationVO[] termChangeExtractVOs = termChangeCreationVoList.toArray(new TermChangeCreationVO[termChangeCreationVoList.size()]);
			command.createTermChangeCreationListBasic(termChangeCreationVoList. toArray(termChangeExtractVOs), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"TermChangeCreationList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0006 : Retrieve<br>
	 * Term Change Creation 장비 처리이력을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTermChangeInquiryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0006Event event = (EesLse0006Event)e;
			TermChangeBC command = new TermChangeBCImpl();
			List<TermChangeInquiryVO> list = command.searchTermChangeInquiryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0047 : Retrieve<br>
	 * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPickupStatusSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0047Event event = (EesLse0047Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			SearchApprovalVO rsVo = command.searchPickupStatusSummaryBasic(event.getSearchApprovalVO());
			eventResponse.setRsVo(rsVo);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0047 : Sheet DblClick<br>
	 * 장/단기 컨테이너 임차계약후 pick-up 승인에 대한 pick-up 수량을 상세조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPickupStatusDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0047Event event = (EesLse0047Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<SearchApprovalDetailVO> list = command.searchPickupStatusDetailBasic(event.getSearchApprovalDetailVO());
			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0025 : Retrieve<br>
	 * Immediate Exit Creation 대상 장비목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchImmediateExitCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0025Event event = (EesLse0025Event)e;
			ImmediateExitBC command = new ImmediateExitBCImpl();
			List<ImmediateExitCreationVO> list = command.searchImmediateExitCreationListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0025 : Save<br>
	 * Immediate Exit Creation 대상 장비목록을 일괄 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createImmediateExitCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0025Event event = (EesLse0025Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();
			command.updateImmediateExitCreationListBasic(event.getImmediateExitCreationVOs(),account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ImmediateExitCreationList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0046 : Retrieve<br>
	 * Off-Hire Plan by RCC 데이터 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @throws EventException
	 */
	private EventResponse searchOffHirePlanByRCCService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0046Event event = (EesLse0046Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<OffHirePlanRccVO> list = command.searchOffHirePlanByRCCBasic(event.getOffHirePlanSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0046 : Save<br>
	 * Off-Hire Plan by RCC 데이터 저장 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @throws EventException
	 */
	private EventResponse manageOffHirePlanByRCCService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0046Event event = (EesLse0046Event)e;
		LeasePlanBC command = new LeasePlanBCImpl();

		try{
			begin();
			command.manageOffHirePlanByRCCBasic(event.getOffHirePlanSearchVO(), event.getOffHirePlanRccVOs(), account);
			commit();
			//eventResponse.setUserMessage(new ErrorHandler("LSE10001").getMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0027 : Open<br>
	 * Miss Use 최대 Request No.를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewMisUseRequestNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0027Event event = (EesLse0027Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			String rqstNo = command.searchNewMisUseRequestNumberBasic(event.getOfcCd());

			if ( rqstNo != null ) {
				eventResponse.setETCData("rqst_no", rqstNo);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0027 : Condition<br>
	 * 입력된 컨테이너 번호에 대한 요청내역 중복여부를 확인합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseReqContainerExistService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0027Event event = (EesLse0027Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();

			boolean existFlag = command.searchMisUseReqContainerExistBasic(event.getCntrNo());
			eventResponse.setETCData("exist_flag", existFlag ? "TRUE" : "FALSE");
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0027 : Condition<br>
	 * 입력된 컨테이너 번호에 대한 기본정보를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseRequestContainerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0027Event event = (EesLse0027Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseContainerInfoVO> list = command.searchMisUseRequestContainerBasic(event.getCntrNo());

			if ( list.size() == 1 ) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0027 : Save<br>
	 * Miss Use Request 요청내역 및 장비목록을 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createMisUseRequestNumberListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0027Event event = (EesLse0027Event)e;
		MisUseApprovalBC command = new MisUseApprovalBCImpl();

		try{
			begin();
			command.createMisUseRequestNumberListBasic(event.getMisUseRequestVO(),event.getMisUseReqContainerVOs(),account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"MissUseRequestNumberList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0051 : Retrieve<br>
	 * Off-Hire Performance 의 리스트 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHirePerformanceService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0051Event event = (EesLse0051Event)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<OffHirePerformanceVO> list = command.searchOffHirePerformanceBasic(event.getOffHirePlanSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Open<br>
	 * Miss Use 최대 Approval No.를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewMisUseApprovalNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0028Event event = (EesLse0028Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			String aproNo = command.searchNewMisUseApprovalNumberBasic(event.getOfcCd());

			if ( aproNo != null ) {
				eventResponse.setETCData("apro_no", aproNo);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Open<br>
	 * 승인대상 Miss Use Request No. 목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseRequestNoItemsService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseRequestVO> list = command.searchMisUseRequestNoItemsBasic();
			StringBuffer sRqstNo = new StringBuffer();

			for ( int i = 0 ; i < list.size() ; i++ ) {
				if ( sRqstNo.toString().equals("") ) {
					sRqstNo.append(list.get(i).getRqstNo());
				} else {
					sRqstNo.append("|").append(list.get(i).getRqstNo());
				}
			}

			eventResponse.setETCData("rqst_no", sRqstNo.toString());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Retrieve<br>
	 * 선택 Request No.에 대한 요청정보을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseRequestInfoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0028Event event = (EesLse0028Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseRequestVO> list = command.searchMisUseRequestInfoBasic(event.getRqstNo());

			if ( list.size() == 1 ) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Retrieve<br>
	 * 선택 Request No.에 대한 장비내역 목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseReqContainerListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0028Event event = (EesLse0028Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseReqContainerVO> list = command.searchMisUseReqContainerListBasic(event.getRqstNo());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Save<br>
	 * Miss Use Approval 승인내역 및 장비목록을 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createMisUseApprovalNumberListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0028Event event = (EesLse0028Event)e;
		MisUseApprovalBC command = new MisUseApprovalBCImpl();

		try{
			begin();
			command.createMisUseApprovalNumberListBasic(event.getMisUseRequestVO(),event.getMisUseApprovalVO(),event.getMisUseReqContainerVOs(),account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"MissUseApprovalNumberList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0036 : Retrieve<br>
	 * 임차장비 임차실적(ON장비) 조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireResultbyLocationAgreementSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0036Event event = (EesLse0036Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			ReportSearchVO  rsVo = command.searchOnHireResultbyLocationAgreementSummaryBasic(event.getReportSearchVO());
			
			eventResponse.setRsVo(rsVo);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0036 : sheet1_OnDblClick<br>
	 * 임차장비 임차실적(ON장비) 상세조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireResultbyLocationAgreementDetailService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0036Event event = (EesLse0036Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireResultbyLocationAgreementDetailBasic(event.getReportSearchVO());


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0039 : Retrieve<br>
	 * 임차장비 임차실적(Off장비) 조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultbyLocationAgreementSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0039Event event = (EesLse0039Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			ReportSearchVO  rsVo = command.searchOffHireResultbyLocationAgreementSummaryBasic(event.getReportSearchVO());

			eventResponse.setRsVo(rsVo);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0039 : sheet1_OnDblClick<br>
	 * 임차장비 임차실적(Off장비) 상세조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultbyLocationAgreementDetailService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0039Event event = (EesLse0039Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireResultbyLocationAgreementDetailBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0093 : Retrieve<br>
	 * 자사 및 타사장비의 Miss Use된 장비의 현황을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseInOutInquiryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0093Event event = (EesLse0093Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseInOutInquiryVO> list = command.searchMisUseInOutInquiryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0040 : Retrieve<br>
	 * 반납 임차장비에 대한 계약번호별 평균사용 실적목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultAvgUsingDaySummaryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0040Event event = (EesLse0040Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<UsingDaySummaryVO> list = command.searchOffHireResultAvgUsingDaySummaryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0040 : Summary Grid(DbClick)<br>
	 * 임차장비별 사용실적에 대한 상세내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultAvgUsingDayDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0040Event event = (EesLse0040Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<UsingDayDetailVO> list = command.searchOffHireResultAvgUsingDayDetailBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0052 : Retrieve<br>
	 * 임차장비 임차실적  Summary조회(On-Hire Result by Lease Term/Lessor-Option)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireResultbyTermLessorSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0052Event event = (EesLse0052Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			ReportSearchVO rsVo = command.searchOnHireResultbyTermLessorSummaryBasic(event.getReportSearchVO());

			eventResponse.setRsVo(rsVo);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0052 : sheet1_OnDbClick<br>
	 * 임차장비 임차실적  상세조회(On-Hire Result by Lease Term/Lessor-Option)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireResultbyTermLessorDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0052Event event = (EesLse0052Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireResultbyTermLessorDetailBasic (event.getReportSearchVO());


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0053 : Retrieve<br>
	 * 임차장비 임차실적  Summary조회(Off-Hire Result by Lease Term/Lessor-Option)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultByTermLessorSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0053Event event = (EesLse0053Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			ReportSearchVO rsVo = command.searchOffHireResultByTermLessorSummaryBasic(event.getReportSearchVO());

			eventResponse.setRsVo(rsVo);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0053 : sheet1_OnDbClick<br>
	 * 임차장비 임차실적  상세조회(Off-Hire Result by Lease Term/Lessor-Option)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultByTermLessorDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0053Event event = (EesLse0053Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireResultByTermLessorDetailBasic(event.getReportSearchVO());


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0054 : Retrieve<br>
	 * 임차장비 임차실적  Summary조회(Off-Hire Vs DOL)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultvsDOLSummaryService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0054Event event = (EesLse0054Event)e;

		LeaseReportBC command = new LeaseReportBCImpl();
		ReportSearchVO rsVo = command.searchOffHireResultvsDOLSummaryBasic(event.getReportSearchVO());

		eventResponse.setRsVo(rsVo);
		return eventResponse;
	}

	/**
	 * EES_LSE_0054 : sheet1_OnDbClick<br>
	 * 임차장비 임차실적  상세조회(Off-Hire Vs DOL)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultvsDOLDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0054Event event = (EesLse0054Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireResultvsDOLDetailBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0057 : Retrieve<br>
	 * HJS의 관리하는 자가 및 임차장비의 현황목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTotalContainerInventorySummaryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0057Event event = (EesLse0057Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<InventorySummaryVO> list = command.searchTotalContainerInventorySummaryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0057 : Summary Grid(DbClick)<br>
	 * HJS의 관리하는 자가 및 임차장비의 상세내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTotalContainerInventoryDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0057Event event = (EesLse0057Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<InventoryDetailVO> list = command.searchTotalContainerInventoryDetailBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0058 : Retrieve<br>
	 * 신조장비인수 여부 리스트 조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewContainerReceivingDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0058Event event = (EesLse0058Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO> list = command.searchNewContainerReceivingDetailBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
				ReportSearchVO temp = list.get(0);
				eventResponse.setETCData("data_cnt", temp.getGTtl());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0094 : Retrieve<br>
	 * Sub Lease 자사장비 및 Mis Use 타사장비의 현황목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSubLeaseOutContainerSummaryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0094Event event = (EesLse0094Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<SubLeaseOutSummaryVO> list = command.searchSubLeaseOutContainerSummaryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0094_01 : Summary Grid(DbClick)<br>
	 * Sub Lease 자사장비 및 Mis Use 타사장비의 상세내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSubLeaseOutContainerDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0094Event event = (EesLse0094Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<SubLeaseOutDetailVO> list = command.searchSubLeaseOutContainerDetailBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0034 : Save<br>
	 * On hire Approval  된 OW Term 컨테이너에 Approval Number 를 Update 시킨다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createApprovalOwnContainerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0032Event event = (EesLse0032Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();
			command.updateAuthNoBasic(event.getOnhireApprovalOwnListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ApprovalOwnContainer Manage"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0087 : Retrieve<br>
	 * 임차 실적을 RCC별로 조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireReportbyRccSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0087Event event = (EesLse0087Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			ReportSearchVO rsVo = command.searchOnHireReportbyRccSummaryBasic(event.getReportSearchVO());

			eventResponse.setRsVo(rsVo);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0088 : Retrieve<br>
	 * 월별로 임차한 실적을 조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireReportbyMonthSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0088Event event = (EesLse0088Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			ReportSearchVO rsVo = command.searchOnHireReportbyMonthSummaryBasic(event.getReportSearchVO());

			eventResponse.setRsVo(rsVo);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0089 : Retrieve<br>
	 * 반납한 실적을 RCC별로 조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireReportbyRccSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0089Event event = (EesLse0089Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			ReportSearchVO rsVo = command.searchOffHireReportbyRccSummaryBasic(event.getReportSearchVO());

			eventResponse.setRsVo(rsVo);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0090 : Retrieve<br>
	 * 월별로 반납한 실적조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireReportbyMonthSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0090Event event = (EesLse0090Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			ReportSearchVO rsVo = command.searchOffHireReportbyMonthSummaryBasic(event.getReportSearchVO());

			eventResponse.setRsVo(rsVo);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0029 : Retrieve<br>
	 * Onhire 될 장비의 Lift On Charge  내용을 조회하는 이벤트 처리
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalLiftOnChargeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0029Event event = (EesLse0029Event)e;

			OnhireApprovalBC  command = new OnhireApprovalBCImpl();

			List<OnhireApprovalVO> list = command.searchOnhireApprovalLiftOnChargeBasic(event.getOnhireApprovalVO());
			eventResponse.setETCData("rowCnt" , list.size() + "");

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0020 : Retrieve<br>
	 * 지역별 반납가능 대상 장비의 현황을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireContainerSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0020Event event = (EesLse0020Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireSummaryVO> list = command.searchAvailableOffHireContainerSummaryBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0020 : Retrieve - BackEndJob<br>
	 * 지역별 반납가능 대상 장비의 현황을 요청합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndAvailableOffHireContainerSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0020Event event = (EesLse0020Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String status = command.backEndAvailableOffHireContainerSummaryBasic(event.getSearchParamVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0021 : Retrieve<br>
	 * 선택된 반납가능 대상 장비의 내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireContainerDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0021Event event = (EesLse0021Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireDetailVO> list = command.searchAvailableOffHireContainerDetailBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0021 : Retrieve - BackEndJob<br>
	 * 선택된 반납가능 대상 장비의 내역을 요청합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndAvailableOffHireContainerDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0021Event event = (EesLse0021Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String status = command.backEndAvailableOffHireContainerDetailBasic(event.getSearchParamVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0021 : E-mail<br>
	 * 선택된 반납가능 대상 장비에 대한 내역을 메일로 발송합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse sendToEmailAvailableOffHireContainerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0021Event event = (EesLse0021Event)e;
		AvailableOffHireBC command = new AvailableOffHireBCImpl();
		try{
			begin();
			command.sendToEmailAvailableOffHireContainerBasic(event.getEmailSendInfoVO(), event.getAvailableOffHireDetailVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"EmailAvailableOffHireContainer SendTo"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0046_01 : Retrieve<br>
	 * 입력된 Location 의 Lease Agreement DOL 데이터 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHirePlanByRCCDOLService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0046PopEvent event = (EesLse0046PopEvent)e;
			LeasePlanBC command = new LeasePlanBCImpl();
			List<OffHirePlanRccVO> list = command.searchOffHirePlanByRCCDOLBasic(event.getOffHirePlanSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0022 : Retrieve<br>
	 * 지역별 지정된 반납대상 장비의 현황을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireContainerConfirmService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0022Event event = (EesLse0022Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireConfirmVO> list = command.searchAvailableOffHireContainerConfirmBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0022 : Retrieve - BackEndJob<br>
	 * 지역별 지정된 반납대상 장비의 현황을 요청합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndAvailableOffHireContainerConfirmService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0022Event event = (EesLse0022Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String status = command.backEndAvailableOffHireContainerConfirmBasic(event.getSearchParamVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0022 : Save<br>
	 * 선정된 대상장비의 내역을 반납확정 자료로 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyAvailableOffHireContainerConfirmService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0022Event event = (EesLse0022Event)e;
		AvailableOffHireBC command = new AvailableOffHireBCImpl();

		try{
			begin();
			command.modifyAvailableOffHireContainerConfirmBasic(event.getAvailableOffHireConfirmVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"AvailableOffHireContainerConfirm Modify"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0092 : retrieve<br>
	 * 년도별/계약별 자가 및 장기 장비 인수 계획 대비 실적 조회
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireTotalSummaryByLeaseTermYearService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0092Event event = (EesLse0092Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireTotalSummaryByLeaseTermYearBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0093 : Cancel<br>
	 * Miss Use Approval 승인장비 목록을 일괄 취소합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyMisUseApprovalCancelListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0093Event event = (EesLse0093Event)e;
		MisUseApprovalBC command = new MisUseApprovalBCImpl();

		try{
			begin();
			command.modifyMisUseApprovalCancelListBasic(event.getMisUseInOutInquiryVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"MisUseApprovalCancelList Modify"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0020/EES_LSE_0021/EES_LSE_0022 : BackEndJob<br>
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0020/EES_LSE_0021/EES_LSE_0022/EES_LSE_0104: BackEndJob<br>
	 * BackEndJob의 실행결과로 생성된 파일을 로드합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("KEY");
		List list = null;

		try {
			if(e.getEventName().equalsIgnoreCase("EesLse0020Event")) {
				list = (List<AvailableOffHireSummaryVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EesLse0021Event")) {
				list = (List<AvailableOffHireDetailVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EesLse0022Event")) {
				list = (List<AvailableOffHireConfirmVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EesLse0104Event")) {
				list = (List<AvailableOffHireContainerListVO>)BackEndJobResult.loadFromFile(key);
			}

			eventResponse.setRsVoList(list);
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0101 : Retrieve<br>
	 * AvailableOffHire Yard 코드 목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireYardCodeListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0101Event event = (EesLse0101Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireYardCodeVO> list = command.searchAvailableOffHireYardCodeListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0103 : Retrieve<br>
	 * Req List Title 코드 목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchReqListTietleCodeService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OnhireApprovalBC commonImpl = new OnhireApprovalBCImpl();
		try{
			String result = commonImpl.searchReqListTietleCodeService();
			eventResponse.setCustomData("title", result);
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
	 * EES_LSE_0103 : Retrieve<br>
	 * EQR의 테이블에서 Req 대상 장비목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEqrReqListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0103Event event = (EesLse0103Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<SearchRequestListVO> list = command.searchEqrReqListService(event.getSearchRequestListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0104 : Retrieve<br>
	 * Location별 Off-Hire Container 장비목록을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireContainerListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0104Event event = (EesLse0104Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireContainerListVO> list = command.searchAvailableOffHireContainerListBasic(event.getAvailableOffHireContainerListVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	/**
	 * EES_LSE_0104 : Retrieve - BackEndJob<br>
	 * 지역별 지정된 반납대상 장비의 현황을 요청합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndSearchAvailableOffHireContainerListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0104Event event = (EesLse0104Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String status = command.backEndSearchAvailableOffHireContainerListService(event.getAvailableOffHireContainerListVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0107 : Retrieve<br>
	 * EQ Interchange Request 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEqInterchangeReqService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0107Event event = (EesLse0107Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();
			List<EqInterchangeReqVO> list = command.searchEqInterchangeRequestBasic(event.getEqInterchangeReqVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0107 : Save<br>
	 * EQ Interchange Request 자료를 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyEqInterchangeReqService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0107Event event = (EesLse0107Event)e;
		EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();

		try{
			begin();
			String req_no = command.modifyEqInterchangeRequestBasic(event.getEqInterchangeReqVOS(), account);
			eventResponse.setETCData("req_no", req_no);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0107 : Onblur<br>
	 * EQ interChange 화면에 대한 Req No조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEqInterchangeReqNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0107Event event = (EesLse0107Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();

			List<EqInterchangeReqVO> list = command.searchEqInterchangeReqNumberService(event.getEqInterchangeReqVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0107 : Onblur<br>
	 * EQ interChange 화면에 대한 EMU Cost를 조회 이벤트 처리 <br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEqInterchangeEMUCostService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0107Event event = (EesLse0107Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();
			EqInterchangeReqVO 	volist = new EqInterchangeReqVO();
			volist = command.searchEqInterchangeEMUCostService(event.getEqInterchangeReqVO());
            
			eventResponse.setETCData("por_cost", volist.getPorCost());
			eventResponse.setETCData("del_cost", volist.getDelCost());
			eventResponse.setETCData("sbo_cost", volist.getSboCost());
			eventResponse.setETCData("sbi_cost", volist.getSbiCost());
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_LSE_0108 : Retrieve<br>
	 * EQ Interchange Approval 처리합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEqInterchangeApprovalService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0108Event event = (EesLse0108Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();
			List<EqInterchangeReqVO> list = command.searchEqInterchangeApprovalBasic(event.getEqInterchangeApprovalVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0108 : Creation<br>
	 * EQ Interchange Approval 자료를 생성합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyEqInterchangeApprovalService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0108Event event = (EesLse0108Event)e;
		EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();

		try{
			begin();
			String auth_no = command.modifyEqInterchangeApprovalBasic(event.getEqInterchangeApprovalVOS(), account);
			eventResponse.setETCData("auth_no", auth_no);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0109 : Retrieve<br>
	 * EQ Interchange Update 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEqInterchangeUpdateService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0109Event event = (EesLse0109Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();
			List<EqInterchangeVO> list = command.searchEqInterchangeUpdateBasic(event.getEqInterchangeVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0109 : Onblur<br>
	 * EQ interChange Update화면에 대한 Auth No조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEqInterchangeAuthNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0109Event event = (EesLse0109Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();

			List<EqInterchangeVO> list = command.searchEqInterchangeAuthNumberDataService(event.getEqInterchangeVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_LSE_0109 : Save<br>
	 * EQ Interchange Update 자료를 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyEqInterchangeUpdateService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0109Event event = (EesLse0109Event)e;
		EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();

		try{
			begin();
			command.modifyEqInterchangeUpdateService(event.getEqInterchangeVOS(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_LSE_0109 : Save<br>
	 * EQ Interchange Update 자료를 Cancel 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyEqInterchangeUpdateCancelService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0109Event event = (EesLse0109Event)e;
		EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();

		try{
			begin();
			command.modifyEqInterchangeUpdateCancelService(event.getEqInterchangeVOS(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_LSE_0111 : Retrieve<br>
	 * EQ interchange pick-up/off-hire 장비의 상세내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchEqInterchangeSummaryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0111Event event = (EesLse0111Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();
			List<EqInterchangeSummaryVO> list = command.searchEqInterchangeSummaryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0111 : Retrieve<br>
	 * EQ interchange pick-up/off-hire 장비의 상세내역을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */

	private EventResponse searchEqInterchangeDetailListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0111Event event = (EesLse0111Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();
			List<EqInterchangeDetailVO> list = command.searchEqInterchangeContainerDetailBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0110 : Retrieve<br>
	 * EQ Interchange offer Inquiry 조회 처리합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOfferInquiryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0110Event event = (EesLse0110Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();
			log.info("===aaaaaaaa===" );
			List<SearchOfferInquiryVO> list = command.searchOfferInquiryService(event.getSearchOfferInquiryVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0029 : Onblur<br>
	 * Onhire Approval Creation 화면에서 Agmt seq에 대한 DOL List 조회 이벤트 처리 <br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalDolListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			EesLse0029Event event = (EesLse0029Event)e;
			OnhireApprovalBC  command = new OnhireApprovalBCImpl();
			List<OnhireApprovalVO> list = command.searchOnhireApprovalDolListBasic(event.getOnhireApprovalVO());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("total_count", list.size() + "");
		
	        for ( int i = 0 ; i < list.size(); i++ ) {
	            eventResponse.setETCData("loc_cod"+i, list.get(i).getLocCd());
	        }
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
		
	}	
	/**
	 * EES_LSE_0029 : Onblur<br>
	 * Onhire Approval Creation 화면에서 ECC List 조회 이벤트 처리 <br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalEccListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			EesLse0029Event event = (EesLse0029Event)e;
			OnhireApprovalBC  command = new OnhireApprovalBCImpl();
			List<OnhireApprovalVO> list = command.searchOnhireApprovalEccListBasic(event.getOnhireApprovalVO());
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("total_count", list.size() + "");
			
	        for ( int i = 0 ; i < list.size(); i++ ) {
	            eventResponse.setETCData("ecc_cd"+i, list.get(i).getEccCd());
	        }
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
		
	}
	
	/**
	 * EES_LSE_0112 : Retrieve <br>
	 * Available Oneway Inventory 조회 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAvailableOnewayService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0112Event event = (EesLse0112Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();

			List<AvailableOnewayInventoryVO> list1 = command.searchAvailableOnewaySummaryBasic(event.getLocFmTp(),event.getLocFm(),event.getDpsl(),event.getOrgCntrTpszCd(),event.getTrd(),event.getLocTp(),event.getLocTo(),event.getSts(),event.getStay(),event.getDys(),event.getAgmtSeq(),event.getVndrSeq());
			List<AvailableOnewayInventoryVO> list2 = command.searchAvailableOnewayListBasic(event.getLocFmTp(),event.getLocFm(),event.getDpsl(),event.getOrgCntrTpszCd(),event.getTrd(),event.getLocTp(),event.getLocTo(),event.getSts(),event.getStay(),event.getDys(),event.getAgmtSeq(),event.getVndrSeq());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
	
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0113 : Retrieve <br>
	 * Oneway Loading PFMC 조회 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOnewayLoadingPFMCService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0113Event event = (EesLse0113Event)e;
			EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();

			String tabFlg = event.getTabFlg();
			
			if("1".equals(tabFlg)){
				List<AvailableOnewayInventoryVO> list = command.searchOnewayLoadingPFMCSummaryBasic(event.getPeriod(),event.getFroms(),event.getDpsl(),event.getOrgCntrTpszCd(),event.getTrd(),event.getLocTp(),event.getLocTo(),event.getTos(),event.getDelDol(),event.getPorDol(),event.getIfFlg(),event.getMvmt());
				eventResponse.setRsVoList(list);
			}else{
				List<AvailableOnewayInventoryVO> list = command.searchOnewayLoadingPFMCListBasic(event.getPeriod(),event.getFroms(),event.getDpsl(),event.getOrgCntrTpszCd(),event.getTrd(),event.getLocTp(),event.getLocTo(),event.getTos(),event.getDelDol(),event.getPorDol(),event.getIfFlg(),event.getMvmt());
				eventResponse.setRsVoList(list);
			}

		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0113 : save <br>
	 * Oneway Loading PFMC 등록, 수정 <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOnewayLoadingPFMCService(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0113Event event = (EesLse0113Event)e;
		EqInterchangeRequestBC command = new EqInterchangeRequestBCImpl();
		try{
			begin();
			command.manageOnewayLoadingPFMCBasic(event.getAvailableOnewayInventoryVOS(),account);
			eventResponse.setUserMessage("Save Complete!");
			commit();
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

}
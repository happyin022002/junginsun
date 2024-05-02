/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SchedulePlanningOperationSC.java
*@FileTitle : P/F SKD Type Help (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.30 서창열
* 1.0 Creation
* 
* History
* 2010.10.04 유혁 CHM-201006129-01 ALPS SKD 생성시 KTNET I/F 확인요청
* 2010.10.28 유혁 CHM-201006456-01 SKD Auto Update 기능 보완. ERP 전송 로그 내역 기록.
* 2010.12.08 진마리아 CHM-201007135-01 Actaul Carrier update 로직 변경 요청건
* 2010.12.27 진마리아 CHM-201007036-01 Down Excel Format 변경 요청건
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2011.04.20 진마리아 CHM-201110283-01 Daily Berth Window 로직 변경
* 2011.08.09 진마리아 CHM-201111568-01 [VOP-VSK] LRS SKD inquiry 화면 및 로직 수정 요청건
* 2011.10.26 김민아   CHM-201114112-01 VSL SKD History Inquiry 화면 로직 변경
* 2012.08.16 이혜민   CHM-201219190-01 Port SKD inquiry group registration 추가
* 2012.10.24 진마리아 CHM-201220527-01 Departure/Noon Report 데이터를 FCM 데이터와 I/F하도록 변경 요청
* 2012.12.12 김상수 [CHM-201221818-01] VVD SKD INTERFACE TO ERP 보완 요청
* 2012.12.18 김상수 [CHM-201221884-01] CNTR 진행기준 대상항차 선정기능 보완
* 2013.09.10 정상기 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능
* 2015.07.22 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.09.04 이병훈	[CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBC;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.basic.GeneralInvoiceAuditBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.CalcTariffResultVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationConditionVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.SimulationObjectListVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffGRPVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffInfoVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo.TariffSimByVvdVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBC;
import com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBC;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.event.UbizhjsAlpsvskSkdAllianceEvent;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic.ProformaScheduleMgtBC;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic.ProformaScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0001Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0003Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0004Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0053Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0066Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0220Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0238Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0241Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0243Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0248Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration.ProformaScheduleMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.BunkerCostVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.CoaSimRsltVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.HireBaseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpSumVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdHisGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PortExpenseVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.SlotPriceVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.CoastalScheduleMgtBC;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.LongRangeScheduleMgtBC;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.SchedulePlanningOperationEvent;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0010Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0012Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0014Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0015Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0017Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0018Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0019Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0020Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0021Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0024Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0054Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0057Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0058Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0059Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0065Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0095Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0211Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0215Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0229Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0245Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0246Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0247Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0249Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0250Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskSPPVSK0004Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskSPPVSK0005Event;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdHisByVvdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SkipPortGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VskVslSkdPhsIoHisVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdCngHistGroupVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdRepeatErpIfVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdPortTariffVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBC;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserDefinedLanePortGroupVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.SearchDateVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MasSimInfoVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskCustSkdEdiSetVO;
import com.hanjin.syscommon.common.table.VskPfSkdVO;
import com.hanjin.syscommon.common.table.VskPortDistVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdHisVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * ALPS-SchedulePlanningOperation Business Logic ServiceCommand - ALPS-SchedulePlanningOperation 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author SEO CHANG YUL
 * @see ProformaScheduleMgtDBDAO
 * @since J2EE 1.4
 */

public class SchedulePlanningOperationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SchedulePlanningOperation system 업무 시나리오 선행작업<br>
	 * UI_VSK-0241업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {log.error(e.getMessage());}
	}

	/**
	 * SchedulePlanningOperation system 업무 시나리오 마감작업<br>
	 * UI_VSK-0241 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SchedulePlanningOperationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SchedulePlanningOperation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		//P/F SKD Type Help (UI_VSK-0241화면에서 호출)
		if (e.getEventName().equalsIgnoreCase("VopVsk0241Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfTpHelp(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSvcLane(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslSkdListByLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSvcLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = removeCstSkdByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Manual Close/Open
				eventResponse = manageVslSkdListByLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// P/F 등록
				eventResponse = manageVvdPf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				// SKD Activate
				eventResponse = manageSkdActivate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				// 입력한 crr_cd 체크
				eventResponse = searchCrrCd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0220Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		// LANE CODE에 따른 P/F SKD 조회
				eventResponse = searchPfSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// VSL CODE에 따른 Vessel 조회
				eventResponse = searchVslList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// Simulation 처리
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	// Phase In 처리
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	// Phase In Cancel 처리
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	// Add Calling 처리
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {	// Add Calling Cancel 처리
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Save
				// Save 클릭
				eventResponse = createLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {	//pf use
				eventResponse = checkDeltYardByPF(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0245Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCallingPortList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVslCntr(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPfLaneTypeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstSkdByPfSkdUse(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDirectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkSvcLaneDir(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstSkdByRmk(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPfLaneTypeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstSkdByPfSkdUse(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDirectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkSvcLaneDir(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstSkdByRmk(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0248Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdHis(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0238Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdBerthWdo(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = checkBkgStsByVvd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0015Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSim(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVskPortDist(e);		// skip cancel, add cancel, reverse call
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstSkdSimBaseInfo(e);	// port change
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBunkerQtyBySpeed(e);	// speed change
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchYardList(e);			// yard change
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchAddCallInfo(e);		// add call
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchDirectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchCstSkdByPfSkdSim(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchCstSkdByPfSkdSim(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchSkipCallInfo(e);		// skip call
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchYardChageByAddCall(e);		// yard change(of add call)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchPortTariffCalculation					(e);	//::Port Tariff Calculation:://
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = checkPortTariffSurchargeDiscountExistList	(e);	//::Port Tariff Calculation >> Surcharge/Discount Exist Checking:://
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstSkdSim(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageSettleByVvd(e);
			} else {
				eventResponse = initCstSkdSim(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSim(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchDirectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdBerthWdo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDirectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUserLaneGroup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdBerthWdo(e);
//			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				log.debug(FormCommand.MULTI01);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendEdiToKlNet(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0249Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSvcLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = removeCstSkdByVvd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0250Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvdPort(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRqstSimScnr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPortInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchYardList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchYardListByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkPfType(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = calPfSkdManual(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createRqstSimScnrCfm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createCoaSimRqst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = calRowDelete(e);
			}

//		} else if (e.getEventName().equalsIgnoreCase("VopVsk0251Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchPfLaneTypeList(e);
//			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				//eventResponse = searchYardListByPort(e);
				eventResponse = searchPortInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				//eventResponse = searchYardListByPort(e);
				eventResponse = searchYardList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchYardListByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = calPfSkdManual(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = calPfSkdAuto(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createRqstSimScnrCfm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removePfSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = calRowDelete(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByPolPod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVslCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRhqList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchControlOfficeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchDate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchLanePortGroupByUserId(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0065Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCstSkdHisByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchActSkdHisByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVslCntr(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchYardListByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSvcLaneDirList (e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = calPfSkdManual(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createRqstSimScnrCfm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removePfSkd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0247Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = calLoadableWgt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchCallIndicator(e);
				eventResponse = searchBayPlanInputPort(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSvcLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVslList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVslSlanCdListByVessel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchYardName(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		// LANE CODE에 따른 P/F SKD 조회
				eventResponse = searchPfSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Save
				// Save 클릭
				eventResponse = createLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {		// LANE CODE에 따른 P/F SKD 조회
				try{
					eventResponse = searchPfSkd(e);
				}catch(EventException ex) {
					throw new EventException(new ErrorHandler("VSK10023").getMessage());
				}
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0229Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListByVvd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslSkdListByLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSvcLaneList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = removeCstSkdByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Manual Close
				eventResponse = manageVslSkdListByLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				// SKD Activate
				eventResponse = manageSkdActivate(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0066Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlotPrice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = calSlotPrice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSlotPrice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchYardListByPort(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0243Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdEotpSum(e);
			}if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPfSkdEotpDtl(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCanalTzList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVendorList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = createCanalTzList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = searchCanalTzListScg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCanalTzBkg(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0246Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = calCanalBunkerSaving(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("SchedulePlanningOperationEvent")) {	//JMS EDI0110001
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = esdSettingReceiveJMS(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0215Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("VopVsk0095Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslSkdRepeatErpIf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendVslSkdRepeatErpIf(e);
			}
		}

		return eventResponse;
}


	/**
	 * VOP_VSK_0241 : Retrieve
	 *
	 * Proforma Type 정보를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfTpHelp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0241Event event = (VopVsk0241Event)e;
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		List<PfSkdTypeHelpVO> list = command.searchPfTpHelp(event.getPfSkdTypeHelpVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * VOP_VSK_0018 : Retrieve
	 * VOP_VSK_0059 : Retrieve
	 *
	 * Lane 또는 Vessel에 따른 Vessel Schedule을 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse searchVslSkdListByLane(Event e) throws EventException {
		ActivationVvdVO vo = null;
		if(e instanceof VopVsk0018Event){
			VopVsk0018Event event = (VopVsk0018Event)e;
			vo = event.getActivationVvdVO();
		}else if(e instanceof VopVsk0059Event){
			VopVsk0059Event event = (VopVsk0059Event)e;
			vo = event.getActivationVvdVO();
		}
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<ActivationVvdVO> list = command.searchVslSkdListByLane(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * VOP_VSK_0018 : Delete
	 * VOP_VSK_0059 : Delete
	 * VOP_VSK_0249 : OK
	 *
	 * 선택한 Vessel Schedule을 삭제합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse removeCstSkdByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 			eventResponse 		= new GeneralEventResponse();
		CoastalScheduleMgtBC 			costalCommand 		= new VesselScheduleMgtBCImpl();
		ActualScheduleMgtBC 			actCommand 			= new ActualScheduleMgtBCImpl();
		GeneralBookingSplitCombineBC 	bkgCommand 			= new GeneralBookingSplitCombineBCImpl();
		
		String 							sFromEventSystem	= "";

		////Map<String, List<VskVslSkdVO>>	hmVskVslSkdVOs	= new HashMap<String, List<VskVslSkdVO>>();
		
		try{
			
			begin();

			if(e instanceof VopVsk0018Event || e instanceof VopVsk0059Event){
				ActivationVvdVO[] srcVOs = null;
				if(e instanceof VopVsk0018Event){
					VopVsk0018Event event 	= (VopVsk0018Event)e;
					srcVOs 					= event.getActivationVvdVOS();
					
					sFromEventSystem		= "DELETE_CST_DeletionVvd_OnNoneBKG(VOP_VSK_0018)";
				}else if(e instanceof VopVsk0059Event){
					VopVsk0059Event event 	= (VopVsk0059Event)e;
					srcVOs 					= event.getActivationVvdVOS();
					
					sFromEventSystem		= "DELETE_CST_Feeder_DeletionVvd_OnNoneBKG(VOP_VSK_0059)";
				}		

				StringBuffer laneData 		= new StringBuffer();
				StringBuffer vvdData 		= new StringBuffer();
				StringBuffer hisData 		= new StringBuffer();
				StringBuffer turnVoyData 	= new StringBuffer();
				StringBuffer turnDirData 	= new StringBuffer();

				if (srcVOs != null) {
					for(int i=0; i<srcVOs.length; i++){
	
						if("BKG".equals(srcVOs[i].getSkdStsCd()) && srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
							hisData.append("ALL|");	// 해당 VVD와 Virtual Port 모두에 History를 남겨야 하는 경우
						}else if("BKG".equals(srcVOs[i].getSkdStsCd())){
							hisData.append("VVD|");	// 해당 VVD에 History를 남겨야 하는 경우
						}else if(srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
							hisData.append("VIR|");	// Virtual Port에 History를 남겨야 하는 경우
						}
	
						// VOP_VSK_0249 화면에 전송하기 위한 데이터 조립
						if("BKG".equals(srcVOs[i].getSkdStsCd()) || srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
							vvdData.append(srcVOs[i].getVslCd() + srcVOs[i].getSkdVoyNo() + srcVOs[i].getSkdDirCd());
							vvdData.append("|");
							laneData.append(srcVOs[i].getVslSlanCd() + "|");
	
							turnVoyData.append(srcVOs[i].getTurnSkdVoyNo() + "|");
							turnDirData.append(srcVOs[i].getTurnSkdDirCd() + "|");
	
							// Booking이 연결된 VVD는 VOP_VSK_0249 화면에 의해 삭제되어야 하므로 여기서는 삭제되지 않도록 한다.
							// 따라서 이 VVD 정보를 null 처리해서 costalCommand.removeCstSkdByVvd() 에서 삭제되지 않도록 한다.
							srcVOs[i] = null;
						}
	
					}
				}

				List<VvdVO> vvdVOs = new ArrayList<VvdVO>();
				List<VvdVO> turnVvdVOs = new ArrayList<VvdVO>();

				if(srcVOs!=null){
					for(ActivationVvdVO activationVvdVO : srcVOs){
						// Booking이 연결된 VVD는 VOP_VSK_0249 화면의 동작에의해 처리되도록 null 처리하여 유도
						if(activationVvdVO==null) continue;

						VvdVO vo = new VvdVO();
						vo.setVslSlanCd(activationVvdVO.getVslSlanCd());
						vo.setVslCd(activationVvdVO.getVslCd());
						vo.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
						vo.setSkdDirCd(activationVvdVO.getSkdDirCd());
						vvdVOs.add(vo);

						// TURN 정보가 있으면
						if(activationVvdVO.getTurnSkdDirCd()!=null && activationVvdVO.getTurnSkdDirCd().length()!=0){
							VvdVO turnVo = new VvdVO();
							turnVo.setVslSlanCd(activationVvdVO.getVslSlanCd());
							turnVo.setVslCd(activationVvdVO.getVslCd());
							turnVo.setSkdVoyNo(activationVvdVO.getTurnSkdVoyNo());
							turnVo.setSkdDirCd(activationVvdVO.getTurnSkdDirCd());
							turnVvdVOs.add(turnVo);
						}
					}
				}
				actCommand.removeVskActPortSkd(vvdVOs);

				/** 운항스케쥴 History 관리용 VO Getting **/
				costalCommand.removeCstSkdByVvd(srcVOs, null, null, account, sFromEventSystem);

				List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = costalCommand.searchBkgBdrLog(vvdVOs);
				sendBkgVvdBdrLog(bkgVvdBdrLogVOs);

				// ERP 전송
				List<VskVslSkdVO> vskVslSkdVOs = new ArrayList<VskVslSkdVO>();
				for(VvdVO vvdVO : vvdVOs){
					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
					vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
					vskVslSkdVO.setVslCd(vvdVO.getVslCd());
					vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
					vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
					vskVslSkdVOs.add(vskVslSkdVO);
				}
				for(VvdVO vvdVO : turnVvdVOs){
					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
					vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
					vskVslSkdVO.setVslCd(vvdVO.getVslCd());
					vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
					vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
					vskVslSkdVOs.add(vskVslSkdVO);
				}

				for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
					vskVslSkdVO.setCreUsrId(account.getUsr_id());
					vskVslSkdVO.setUpdUsrId(account.getUsr_id());
				}
				sendVslSkdErpIf(vskVslSkdVOs);

				eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());
				eventResponse.setETCData("lane", laneData.toString());
				eventResponse.setETCData("vvd", vvdData.toString());
				eventResponse.setETCData("his", hisData.toString());

				eventResponse.setETCData("turn_voy", turnVoyData.toString());
				eventResponse.setETCData("turn_dir", turnDirData.toString());

			}else if(e instanceof VopVsk0249Event) {
				
				sFromEventSystem		= "DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)";
				
				VopVsk0249Event 		event 				= (VopVsk0249Event)e;
				ActivationVvdVO[] 		nonBkgVOs 			= event.getActivationVvdVO1S();
				ActivationVvdVO[] 		bkgVOs 				= event.getActivationVvdVO2S();
				VskVslSkdHisVO 			hisVO 				= event.getVskVslSkdHisVO();

				List<VvdVO> 			vvdVOs 				= new ArrayList<VvdVO>();
				List<VvdVO> 			turnVvdVOs 			= new ArrayList<VvdVO>();
				List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs 	= new ArrayList<VslSkdCngNoticeVO>();

				if(nonBkgVOs!=null){
					for(ActivationVvdVO activationVvdVO : nonBkgVOs){
						VvdVO vo = new VvdVO();
						vo.setVslSlanCd	(activationVvdVO.getVslSlanCd());
						vo.setVslCd		(activationVvdVO.getVslCd());
						vo.setSkdVoyNo	(activationVvdVO.getSkdVoyNo());
						vo.setSkdDirCd	(activationVvdVO.getSkdDirCd());
						vvdVOs.add		(vo);
					}
				}
				if(bkgVOs!=null){
					for(ActivationVvdVO activationVvdVO : bkgVOs){
						VvdVO vo = new VvdVO();
						vo.setVslSlanCd	(activationVvdVO.getVslSlanCd());
						vo.setVslCd		(activationVvdVO.getVslCd());
						vo.setSkdVoyNo	(activationVvdVO.getSkdVoyNo());
						vo.setSkdDirCd	(activationVvdVO.getSkdDirCd());
						vvdVOs.add		(vo);

						VslSkdCngNoticeVO noticeVO = new VslSkdCngNoticeVO();
						noticeVO.setVslCd		(activationVvdVO.getVslCd());
						noticeVO.setSkdVoyNo	(activationVvdVO.getSkdVoyNo());
						noticeVO.setSkdDirCd	(activationVvdVO.getSkdDirCd());
						vslSkdCngNoticeVOs.add	(noticeVO);

						// TURN 정보가 있으면
						if(activationVvdVO.getTurnSkdDirCd()!=null && activationVvdVO.getTurnSkdDirCd().length()!=0){
							VvdVO turnVo = new VvdVO();
							turnVo.setVslSlanCd	(activationVvdVO.getVslSlanCd());
							turnVo.setVslCd		(activationVvdVO.getVslCd());
							turnVo.setSkdVoyNo	(activationVvdVO.getTurnSkdVoyNo());
							turnVo.setSkdDirCd	(activationVvdVO.getTurnSkdDirCd());
							turnVvdVOs.add		(turnVo);
						}
					}
				}

				actCommand.removeVskActPortSkd	(vvdVOs);
				costalCommand.removeCstSkdByVvd	(nonBkgVOs, bkgVOs, hisVO, account, sFromEventSystem);
				bkgCommand.sendVslSkdCngNotice	(vslSkdCngNoticeVOs);

				List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = costalCommand.searchBkgBdrLog(vvdVOs);
				sendBkgVvdBdrLog(bkgVvdBdrLogVOs);

				// ERP 전송
				List<VskVslSkdVO> vskVslSkdVOs = new ArrayList<VskVslSkdVO>();
				for(VvdVO vvdVO : vvdVOs){
					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
					vskVslSkdVO.setVslSlanCd	(vvdVO.getVslSlanCd());
					vskVslSkdVO.setVslCd		(vvdVO.getVslCd());
					vskVslSkdVO.setSkdVoyNo		(vvdVO.getSkdVoyNo());
					vskVslSkdVO.setSkdDirCd		(vvdVO.getSkdDirCd());
					vskVslSkdVOs.add			(vskVslSkdVO);
				}
				for(VvdVO vvdVO : turnVvdVOs){
					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
					vskVslSkdVO.setVslSlanCd	(vvdVO.getVslSlanCd());
					vskVslSkdVO.setVslCd		(vvdVO.getVslCd());
					vskVslSkdVO.setSkdVoyNo		(vvdVO.getSkdVoyNo());
					vskVslSkdVO.setSkdDirCd		(vvdVO.getSkdDirCd());
					vskVslSkdVOs.add			(vskVslSkdVO);
				}
				
				//::jskjskjsk::///////////////////////////////////////////////////////////////////
				for(int i=0; i<vskVslSkdVOs.size(); i++){
					log.info("\n\n ========== ::jskjskjsk::vsk.delete.erp.if================== \n");
					log.info("\n   getVslCd   		["+vskVslSkdVOs.get(i).getVslCd()+"]");
					log.info("\n   getSkdVoyNo   	["+vskVslSkdVOs.get(i).getSkdVoyNo()+"]");
					log.info("\n   getSkdDirCd   	["+vskVslSkdVOs.get(i).getSkdDirCd()+"]");
					log.info("\n   getVslSlanCd   	["+vskVslSkdVOs.get(i).getVslSlanCd()+"]");
					
							
				}
				/////////////////////////////////////////////////////////////////////////////////
					
				sendVslSkdErpIf(vskVslSkdVOs);

				eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());
			}

			commit();

			/* ============================================================================
			 * Vessel Schedule History 관리(Header+Detail) Started ::2013-08-27::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
			 * ============================================================================
			 */
			////if(!hmVskVslSkdVOs.isEmpty()){
			////	for(int i=0; i<hmVskVslSkdVOs.size(); i++){
			////		Collection<String>	collection	= hmVskVslSkdVOs.keySet();
			////		Iterator<String>	itrKey		= collection.iterator();
			////		
			////		while(itrKey.hasNext()){
			////			String 				sKey			= (String)itrKey.next();
			////			List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
			////			vskVslSkdVOs						= hmVskVslSkdVOs.get(sKey);
			////			
			////			costalCommand.createVesselScheduleChangeHistory(vskVslSkdVOs, null, sKey);		
			////		}
			////	}
			////}
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0010 : P/F Schedule Type 변경
	 * VOP_VSK_0220 : P/F Schedule Type Search
	 * VOP_VSK_0003 : P/F Schedule Type Search
	 * VOP_VSK_0053 : Lane Code Search
	 * VOP_VSK_0004 : P/F Schedule Type Search
	 * VOP_VSK_0054 : Lane Code Search
	 *
	 * Lane 에 해당하는 기본 Proforma Type 혹은 지정된 Proforma Type 정보를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("static-access")
	private EventResponse searchPfSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PfSkdVO pfSkdVO =  null;
		VskPfSkdVO vskPfSkdVO = new VskPfSkdVO();
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = new ArrayList<VskPfSkdDtlVO>();
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();

		String uiVesselType = null;
		String fdrDivCd = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if(e instanceof VopVsk0010Event){
			VopVsk0010Event event = (VopVsk0010Event)e;
			pfSkdVO = event.getPfSkdVO();
			uiVesselType = pfSkdVO.getVslSvcTpCd();
		}else if(e instanceof VopVsk0220Event){
			VopVsk0220Event event = (VopVsk0220Event)e;
			pfSkdVO = event.getPfSkdVO();
			pfSkdVO.setSlanStndFlg("");
		}else if(e instanceof VopVsk0003Event){
			VopVsk0003Event event = (VopVsk0003Event)e;
			pfSkdVO = event.getPfSkdVO();
			pfSkdVO.setVslSvcTpCd("");
			pfSkdVO.setSlanStndFlg("");
		}else if(e instanceof VopVsk0053Event){
			VopVsk0053Event event = (VopVsk0053Event)e;
			pfSkdVO = event.getPfSkdVO();
			pfSkdVO.setVslSvcTpCd("");
			pfSkdVO.setSlanStndFlg("");
		}else if(e instanceof VopVsk0004Event){
			VopVsk0004Event event = (VopVsk0004Event)e;
			pfSkdVO = event.getPfSkdVO();
			pfSkdVO.setVslSvcTpCd("");
			pfSkdVO.setSlanStndFlg("");
		}else if(e instanceof VopVsk0054Event){
			VopVsk0054Event event = (VopVsk0054Event)e;
			pfSkdVO = event.getPfSkdVO();
			uiVesselType = pfSkdVO.getVslSvcTpCd();
		}

		if(e instanceof VopVsk0010Event || e instanceof VopVsk0054Event){

			MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
			if(e instanceof VopVsk0010Event){
				vo.setVslSlanCd(((VopVsk0010Event)e).getPfSkdVO().getVslSlanCd());
			}else if(e instanceof VopVsk0054Event){
				vo.setVslSlanCd(((VopVsk0054Event)e).getPfSkdVO().getVslSlanCd());
			}

			VSKCodeFinderBC combc = new VSKCodeFinderBCImpl();
			List<MdmVslSvcLaneVO> checkList = combc.checkSvcLane(vo);

			if(checkList==null || checkList.size()==0){
				eventResponse.setUserMessage(new ErrorHandler("VSK10019").getUserMessage());
				return eventResponse;
			}else{
				MdmVslSvcLaneVO checkVO = checkList.get(0);
				fdrDivCd = checkVO.getFdrDivCd();
				if("F".equals(uiVesselType) &&
						(!"O".equals(checkVO.getVslSvcTpCd()) && !"O".equals(fdrDivCd))
						){
					eventResponse.setUserMessage(new ErrorHandler("VSK10049").getUserMessage());
					return eventResponse;
				}else if("T".equals(uiVesselType) && "O".equals(checkVO.getVslSvcTpCd())){
					eventResponse.setUserMessage(new ErrorHandler("VSK10048").getUserMessage());
					return eventResponse;
				}
			}
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		List<PfSkdVO> list = command.searchPfSkd(pfSkdVO);

		if(e instanceof VopVsk0010Event || e instanceof VopVsk0220Event){

			int vslCount = 0;
			String vslSlanNm = "";

			if(e instanceof VopVsk0010Event || e instanceof VopVsk0220Event){
				if (pfSkdVO != null) {
					if(list==null || list.size()==0){
	
						if("N".equals(pfSkdVO.getSlanStndFlg())){
							// PF_SVC_TP_CD 가 Standard 타입이 아니라 화면에서 입력한 경우임.
							// 조회결과가 없을때는 해당 PF_SVC_TP_CD이 존재하지 않음.
							// VSK10023 : 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
							throw new EventException(new ErrorHandler("VSK10023").getMessage());
						}else{
							// Proforma Schedule이 등록 되지 않았을 경우에 표시
							throw new EventException(new ErrorHandler("VSK10020").getMessage());
						}
					}
	
					if("F".equals(pfSkdVO.getVslSvcTpCd()) || "F".equals(uiVesselType)){
						pfSkdVO = list.get(0);
						if(!"O".equals(pfSkdVO.getVslSvcTpCd())){
							// Lane Type을 Feeder 로 조회했으나
							// 해당 레인의 타입이 Feeder 타입이 아닌경우
							// VSK10049 오류발생
							throw new EventException(new ErrorHandler("VSK10049").getMessage());
						}
					}
				}
			}

			if(list != null && list.size()>0){
				pfSkdVO = list.get(0);
//				vslCount = Integer.parseInt((!"".equals(Utils.isNotNull(pfSkdVO.getN1stVslClssKnt())))?"0":pfSkdVO.getN1stVslClssKnt())
//							 + Integer.parseInt((!"".equals(Utils.isNotNull(pfSkdVO.getN2ndVslClssKnt())))?"0":pfSkdVO.getN2ndVslClssKnt())
//							 + Integer.parseInt((!"".equals(Utils.isNotNull(pfSkdVO.getN3rdVslClssKnt())))?"0":pfSkdVO.getN3rdVslClssKnt());

				vslCount = Integer.parseInt((pfSkdVO.getN1stVslClssKnt()==null || "".equals(pfSkdVO.getN1stVslClssKnt()))?"0":pfSkdVO.getN1stVslClssKnt())
				 + Integer.parseInt((pfSkdVO.getN2ndVslClssKnt()==null || "".equals(pfSkdVO.getN2ndVslClssKnt()))?"0":pfSkdVO.getN2ndVslClssKnt())
				 + Integer.parseInt((pfSkdVO.getN3rdVslClssKnt()==null || "".equals(pfSkdVO.getN3rdVslClssKnt()))?"0":pfSkdVO.getN3rdVslClssKnt());

				vslSlanNm = pfSkdVO.getVslSlanNm();

				StringBuilder portCdSb = new StringBuilder();
				StringBuilder portDirCdSb = new StringBuilder();
				StringBuilder skdDirCdSb = new StringBuilder();
				StringBuilder etbDyCdSb = new StringBuilder();
				StringBuilder clptSeqSb = new StringBuilder();

				for(int i=0; i<list.size(); i++){
					pfSkdVO = list.get(i);
					portCdSb.append("|" + pfSkdVO.getPortCd());
					portDirCdSb.append("|" + pfSkdVO.getPortCd() + " [" + pfSkdVO.getSkdDirCd() + "]");
					skdDirCdSb.append("|" + pfSkdVO.getSkdDirCd());
					etbDyCdSb.append("|" + pfSkdVO.getEtbDyCd());
					clptSeqSb.append("|" + pfSkdVO.getClptSeq());
				}

				eventResponse.setETCData("vsl_count", Integer.toString(vslCount));
				eventResponse.setETCData("pf_svc_tp_cd", pfSkdVO.getPfSvcTpCd());
				eventResponse.setETCData("port_cd", portCdSb.toString());
				eventResponse.setETCData("port_dir_cd", portDirCdSb.toString());
				eventResponse.setETCData("skd_dir_cd", skdDirCdSb.toString());
				eventResponse.setETCData("etb_dy_cd", etbDyCdSb.toString());
				eventResponse.setETCData("vsl_slan_nm", vslSlanNm);
				eventResponse.setETCData("brth_itval_dys", pfSkdVO.getBrthItvalDys());
				eventResponse.setETCData("svc_dur_dys", pfSkdVO.getSvcDurDys());
				eventResponse.setETCData("clpt_seq", clptSeqSb.toString());

				eventResponse.setRsVoList(list);
			}
		}else if(e instanceof VopVsk0003Event || e instanceof VopVsk0004Event){
			if(list != null && list.size()>0){
				vskPfSkdVO.setVslSlanCd(list.get(0).getVslSlanCd());

				vskPfSkdVO.setPfSvcTpCd(list.get(0).getPfSvcTpCd());
				vskPfSkdVO.setSlanStndFlg(list.get(0).getSlanStndFlg());
				vskPfSkdVO.setSvcDurDys(list.get(0).getSvcDurDys());
				vskPfSkdVO.setStndSvcSpd(list.get(0).getStndSvcSpd());
				vskPfSkdVO.setBrthItvalDys(list.get(0).getBrthItvalDys());

				vskPfSkdVO.setMmlUsdFlg(list.get(0).getMmlUsdFlg());
				vskPfSkdVO.setSimDt(list.get(0).getSimDt());
				vskPfSkdVO.setSimNo(list.get(0).getSimNo());
				vskPfSkdVO.setN1stVslClssCd(list.get(0).getN1stVslClssCd());
				vskPfSkdVO.setN1stVslClssKnt(list.get(0).getN1stVslClssKnt());

				vskPfSkdVO.setN2ndVslClssCd(list.get(0).getN2ndVslClssCd());
				vskPfSkdVO.setN2ndVslClssKnt(list.get(0).getN2ndVslClssKnt());
				vskPfSkdVO.setN3rdVslClssCd(list.get(0).getN3rdVslClssCd());
				vskPfSkdVO.setN3rdVslClssKnt(list.get(0).getN3rdVslClssKnt());
				vskPfSkdVO.setClptKnt(list.get(0).getClptKnt());

				vskPfSkdVO.setTtlDist(list.get(0).getTtlDist());
				vskPfSkdVO.setMaxSpd(list.get(0).getMaxSpd());
				vskPfSkdVO.setAvgSpd(list.get(0).getAvgSpd());
				vskPfSkdVO.setDeltFlg(list.get(0).getDeltFlg());
				vskPfSkdVO.setPfSkdRmk(list.get(0).getPfSkdRmk());

				vskPfSkdVO.setCreDt(list.get(0).getCreDt());
				vskPfSkdVO.setUpdDt(list.get(0).getUpdDt());

				for(int i=0; i<list.size(); i++){
					VskPfSkdDtlVO vskPfSkdDtlVO = new VskPfSkdDtlVO();
					vskPfSkdDtlVO.setRowSeq(list.get(i).getRowSeq());
					vskPfSkdDtlVO.setVslSlanCd(list.get(i).getVslSlanCd());

					vskPfSkdDtlVO.setPfSvcTpCd(list.get(i).getPfSvcTpCd());
					vskPfSkdDtlVO.setPortCd(list.get(i).getPortCd());
					vskPfSkdDtlVO.setSkdDirCd(list.get(i).getSkdDirCd());
					vskPfSkdDtlVO.setClptSeq(list.get(i).getClptSeq());
					vskPfSkdDtlVO.setPortRotnSeq(list.get(i).getPortRotnSeq());

					vskPfSkdDtlVO.setYdCd(list.get(i).getTempYdCd());
					vskPfSkdDtlVO.setYdNm(list.get(i).getYdNm());

					vskPfSkdDtlVO.setCallYdIndSeq(list.get(i).getCallYdIndSeq());
					vskPfSkdDtlVO.setTurnPortFlg(list.get(i).getTurnPortFlg());
					vskPfSkdDtlVO.setTurnPortIndCd(list.get(i).getTurnPortIndCd());
					vskPfSkdDtlVO.setEtbDyCd(list.get(i).getEtbDyCd());

					vskPfSkdDtlVO.setEtbDyNo(list.get(i).getEtbDyNo());
					vskPfSkdDtlVO.setEtbTmHrmnt(list.get(i).getEtbTmHrmnt());
					vskPfSkdDtlVO.setEtdDyCd(list.get(i).getEtdDyCd());
					vskPfSkdDtlVO.setEtdDyNo(list.get(i).getEtdDyNo());
					vskPfSkdDtlVO.setEtdTmHrmnt(list.get(i).getEtdTmHrmnt());

					vskPfSkdDtlVO.setLnkDist(list.get(i).getLnkDist());
					vskPfSkdDtlVO.setLnkSpd(list.get(i).getLnkSpd());
					vskPfSkdDtlVO.setTztmHrs(list.get(i).getTztmHrs());
					vskPfSkdDtlVO.setSeaBufHrs(list.get(i).getSeaBufHrs());
					vskPfSkdDtlVO.setSeaBufSpd(list.get(i).getSeaBufSpd());
					vskPfSkdDtlVO.setAvgSeaBufSpd(list.get(i).getAvgSeaBufSpd());

					vskPfSkdDtlVO.setMnvrInHrs(list.get(i).getMnvrInHrs());
					vskPfSkdDtlVO.setMnvrOutHrs(list.get(i).getMnvrOutHrs());
					vskPfSkdDtlVO.setIbIpcgoQty(list.get(i).getIbIpcgoQty());
					vskPfSkdDtlVO.setIbOcnCgoQty(list.get(i).getIbOcnCgoQty());
					vskPfSkdDtlVO.setObIpcgoQty(list.get(i).getObIpcgoQty());

					vskPfSkdDtlVO.setObOcnCgoQty(list.get(i).getObOcnCgoQty());
					vskPfSkdDtlVO.setTmlProdQty(list.get(i).getTmlProdQty());
					vskPfSkdDtlVO.setCrnKnt(list.get(i).getCrnKnt());
					vskPfSkdDtlVO.setActWrkHrs(list.get(i).getActWrkHrs());
					vskPfSkdDtlVO.setPortBufHrs(list.get(i).getPortBufHrs());

					vskPfSkdDtlVO.setZd(list.get(i).getZd());
					//2009 09 30 임창빈 수석 수정요청 :
					//Maximum Speed,P/F Speed,Speed (Incl. buffer),Total Buffer Ratio,Sea buffer Ratio,Port buffer Ratio,P/F Speed Ratio,Buffer Speed Ratio
					//기존의 쿼리에서 계산되어서 가져오는 방법에서  화면에 마지막 로우의 숨긴 데이타를 빼고 계산한다
					/*
					vskPfSkdDtlVO.setTotMaxSpd(list.get(i).getTotMaxSpd());
					vskPfSkdDtlVO.setTotAvgSpd(list.get(i).getTotAvgSpd());
					vskPfSkdDtlVO.setBufSpd(list.get(i).getSeaBufSpd());

					vskPfSkdDtlVO.setTotBufRat(list.get(i).getTotBufRat());
					vskPfSkdDtlVO.setSeaBufRat(list.get(i).getSeaBufRat());
					vskPfSkdDtlVO.setPortBufRat(list.get(i).getPortBufRat());
					vskPfSkdDtlVO.setPfSpdRat(list.get(i).getPfSpdRat());
					vskPfSkdDtlVO.setBufSpdRat(list.get(i).getBufSpdRat());
*/
					vskPfSkdDtlVO.setMinMaxSpd(list.get(i).getMinMaxSpd());

					vskPfSkdDtlVO.setCheckWkTm(list.get(i).getCheckWkTm());
					vskPfSkdDtlVO.setCraneWkTm(list.get(i).getCraneWkTm());

					vskPfSkdDtlVOs.add(vskPfSkdDtlVO);

				}

				//2009 09 30 임창빈 수석 수정요청 :
				//Maximum Speed,P/F Speed,Speed (Incl. buffer),Total Buffer Ratio,Sea buffer Ratio,Port buffer Ratio,P/F Speed Ratio,Buffer Speed Ratio
				//기존의 쿼리에서 계산되어서 가져오는 방법에서  화면에 마지막 로우의 숨긴 데이타를 빼고 계산한다
				//마지막 로우는 계산에서 제한다
				double cnt = list.size()-1;
				//SEA SPEED TOTLAL
				double totLinkSpd = 0;
				//SEA BUFFER SPEED TOTAL
				double totBufSpd = 0;
				//SEA BUFFER TOTAL
				double totSeaBufHrs = 0;
				//SEA TIME TOTAL
				double totSeaTime = 0;
				//MANU IN HRS TOTAL
				double totMnvrInHrs = 0;
				//MANU OUT HRS TOTAL
				double totMnvrOutHrs = 0;
				//WORKING HOUR TOTAL
				double totActWrkHrs = 0;
				//PORT BUFFER HRS TOTLA
				double totPortBufHrs = 0;
				//VSL CALSS MAX SPD
				double dMinMaxSpd = 0;
				//MAX SPEED
				float totMaxSpd = 0;
				//P/F SPEED
				float totAvgSpd = 0;
				// P/F SPEED INCLUDE SEA BUFFER
				double avgSpdIncludeSeaBuf = 0;

				BigDecimal bufSpd = null;
				BigDecimal totBufRat = null;
				BigDecimal seaBufRat = null;
				BigDecimal portBufRat = null;
				BigDecimal pfSpdRat = null;
				BigDecimal bufSpdRat = null;

				float max = 0;
				for(int k=0; k<list.size()-1; k++){

					if(Float.compare(Float.parseFloat(list.get(k).getLnkSpd()), max)>0){
						max = Float.parseFloat(list.get(k).getLnkSpd());
					}

					if(k==0){
						dMinMaxSpd = Double.parseDouble(list.get(0).getMinMaxSpd());
						avgSpdIncludeSeaBuf = Double.parseDouble(list.get(0).getAvgSpd());
					}

					if(list.get(k).getLnkSpd() != null && !"".equals(list.get(k).getLnkSpd())){
						totLinkSpd 	+= Float.parseFloat(list.get(k).getLnkSpd());
					}
					if(list.get(k).getSeaBufSpd() != null && !"".equals(list.get(k).getSeaBufSpd())){
						totBufSpd += Float.parseFloat(list.get(k).getSeaBufSpd());
					}
					if(list.get(k).getSeaBufHrs() != null && !"".equals(list.get(k).getSeaBufHrs())){
						totSeaBufHrs += Float.parseFloat(list.get(k).getSeaBufHrs());
					}
					if(list.get(k).getTztmHrs() != null && !"".equals(list.get(k).getTztmHrs())){
						totSeaTime += Float.parseFloat(list.get(k).getTztmHrs());
					}
					if(list.get(k+1).getMnvrInHrs() != null && !"".equals(list.get(k+1).getMnvrInHrs())){
						totMnvrInHrs += Float.parseFloat(list.get(k+1).getMnvrInHrs());
					}
					if(list.get(k).getMnvrOutHrs() != null && !"".equals(list.get(k).getMnvrOutHrs())){
						totMnvrOutHrs += Float.parseFloat(list.get(k).getMnvrOutHrs());
					}
					if(list.get(k).getActWrkHrs() != null && !"".equals(list.get(k).getActWrkHrs())){
						totActWrkHrs += Float.parseFloat(list.get(k).getActWrkHrs());
					}
					if(list.get(k).getPortBufHrs() != null && !"".equals(list.get(k).getPortBufHrs())){
						totPortBufHrs += Float.parseFloat(list.get(k).getPortBufHrs());
					}

				}
				//Manu In은  마지막 로우는 보여준다
//				totMnvrInHrs = totMnvrInHrs + Float.parseFloat(list.get(list.size()-1).getMnvrInHrs());
				//Max Speed
				totMaxSpd = max;
				//Avg Speed
				totAvgSpd = Math.round(totLinkSpd/cnt); // <-- P/F Speed

				//Vsl Class Min_Max_Speed
//				dMinMaxSpd = totBufSpd/cnt;//Math.round(totBufSpd/cnt);

				//Sea Buffer Speed
				double tempBufSpd = Double.parseDouble(list.get(0).getSeaBufSpd());
				BigDecimal bigBufSpd = new BigDecimal(tempBufSpd);
				bufSpd = bigBufSpd.setScale(1,bigBufSpd.ROUND_HALF_UP);

				double tempTotBufRat = (totBufSpd+totSeaBufHrs)/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs+totActWrkHrs)*100;
				if(Double.toString(tempTotBufRat).equals("NaN") || Double.toString(tempTotBufRat).equals("Infinity")){
					tempTotBufRat = 0;
		        }
				BigDecimal bigTotBufRat = new BigDecimal(tempTotBufRat);
				totBufRat = bigTotBufRat.setScale(2,bigTotBufRat.ROUND_HALF_UP);

		        double tempSeaBufRat = totSeaBufHrs/(totSeaTime+totSeaBufHrs+totMnvrInHrs+totMnvrOutHrs)*100;
		        if(Double.toString(tempSeaBufRat).equals("NaN") || Double.toString(tempSeaBufRat).equals("Infinity")){
		        	tempSeaBufRat = 0;
		        }
		        BigDecimal bigSeaBufRat = new BigDecimal(tempSeaBufRat);
		        seaBufRat = bigSeaBufRat.setScale(2,bigSeaBufRat.ROUND_HALF_UP);

		        double tempPortBufRat = totPortBufHrs/(totActWrkHrs+totPortBufHrs)*100;
		        if(Double.toString(tempPortBufRat).equals("NaN") || Double.toString(tempPortBufRat).equals("Infinity")){
		        	tempPortBufRat = 0;
		        }
		        BigDecimal bigPortBufRat = new BigDecimal(tempPortBufRat);
		        portBufRat = bigPortBufRat.setScale(2,bigPortBufRat.ROUND_HALF_UP);

		        double tempPfSpdRat = 0;
		        if(dMinMaxSpd!=0){
		        	// P/F Speed Ratio = P/F Speed / MIN_MAX_SPEED
		        	tempPfSpdRat = totAvgSpd / dMinMaxSpd;
		        }

		        BigDecimal bigPfSpdRat = new BigDecimal(tempPfSpdRat);
		        pfSpdRat = bigPfSpdRat.setScale(2,bigPfSpdRat.ROUND_HALF_UP);

		        double tempBufSpdRat = 0;
		        if(dMinMaxSpd!=0){
		        	tempBufSpdRat = avgSpdIncludeSeaBuf/dMinMaxSpd*100;
		        }

		        BigDecimal bigBufSpdRat = new BigDecimal(tempBufSpdRat);
		        bufSpdRat = bigBufSpdRat.setScale(2,bigBufSpdRat.ROUND_HALF_UP);


		        list.get(0).setTotMaxSpd(Float.toString(totMaxSpd));
		        list.get(0).setTotAvgSpd(Float.toString(totAvgSpd));
		        list.get(0).setSeaBufSpd(bufSpd.toString());
		        list.get(0).setTotBufRat(totBufRat.toString());
		        list.get(0).setSeaBufRat(seaBufRat.toString());
		        list.get(0).setPortBufRat(portBufRat.toString());
		        list.get(0).setPfSpdRat(pfSpdRat.toString());
		        list.get(0).setBufSpdRat(bufSpdRat.toString());

				sb.append(list.get(0).getTempYdCd());
				for(int i=1; i<list.size(); i++){
					sb.append("|");
					sb.append(list.get(i).getTempYdCd());
				}

				sb2.append(list.get(0).getTotMaxSpd());
				sb2.append("|");
				sb2.append(list.get(0).getTotAvgSpd());
				sb2.append("|");
				sb2.append(list.get(0).getSeaBufSpd());
				sb2.append("|");
				sb2.append(list.get(0).getTotBufRat());
				sb2.append("|");
				sb2.append(list.get(0).getSeaBufRat());
				sb2.append("|");
				sb2.append(list.get(0).getPortBufRat());
				sb2.append("|");
				sb2.append(list.get(0).getPfSpdRat());
				sb2.append("|");
				sb2.append(list.get(0).getBufSpdRat());
				sb2.append("|");
				sb2.append(list.get(0).getMinMaxSpd());
				sb2.append("|");
				sb2.append(list.get(0).getVslSvcTpCd());
				sb2.append("|");
				sb2.append(list.get(0).getCheckVslSkd());
				sb2.append("|");
				sb2.append(list.get(0).getCreUsrId());
				sb2.append("|");
				sb2.append(list.get(0).getUpdUsrId());


				eventResponse.setRsVo(vskPfSkdVO);
				eventResponse.setRsVoList(vskPfSkdDtlVOs);
				eventResponse.setETCData("ydCd", sb.toString());
				eventResponse.setETCData("etcdt", sb2.toString());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"P/F SKD Creation"}).getUserMessage());
			}
		}else if(e instanceof VopVsk0053Event){
			if(list != null && list.size()>0){
				vskPfSkdVO.setVslSlanCd(list.get(0).getVslSlanCd());

				vskPfSkdVO.setPfSvcTpCd(list.get(0).getPfSvcTpCd());
				vskPfSkdVO.setSlanStndFlg(list.get(0).getSlanStndFlg());
				vskPfSkdVO.setSvcDurDys(list.get(0).getSvcDurDys());
				vskPfSkdVO.setStndSvcSpd(list.get(0).getStndSvcSpd());
				vskPfSkdVO.setBrthItvalDys(list.get(0).getBrthItvalDys());

				vskPfSkdVO.setMmlUsdFlg(list.get(0).getMmlUsdFlg());
				vskPfSkdVO.setSimDt(list.get(0).getSimDt());
				vskPfSkdVO.setSimNo(list.get(0).getSimNo());
				vskPfSkdVO.setN1stVslClssCd(list.get(0).getN1stVslClssCd());
				vskPfSkdVO.setN1stVslClssKnt(list.get(0).getN1stVslClssKnt());

				vskPfSkdVO.setN2ndVslClssCd(list.get(0).getN2ndVslClssCd());
				vskPfSkdVO.setN2ndVslClssKnt(list.get(0).getN2ndVslClssKnt());
				vskPfSkdVO.setN3rdVslClssCd(list.get(0).getN3rdVslClssCd());
				vskPfSkdVO.setN3rdVslClssKnt(list.get(0).getN3rdVslClssKnt());
				vskPfSkdVO.setClptKnt(list.get(0).getClptKnt());

				vskPfSkdVO.setTtlDist(list.get(0).getTtlDist());
				vskPfSkdVO.setMaxSpd(list.get(0).getMaxSpd());
				vskPfSkdVO.setAvgSpd(list.get(0).getAvgSpd());
				vskPfSkdVO.setDeltFlg(list.get(0).getDeltFlg());
				vskPfSkdVO.setPfSkdRmk(list.get(0).getPfSkdRmk());

				vskPfSkdVO.setCreDt(list.get(0).getCreDt());
				vskPfSkdVO.setUpdDt(list.get(0).getUpdDt());


				for(int i=0; i<list.size(); i++){
					VskPfSkdDtlVO vskPfSkdDtlVO = new VskPfSkdDtlVO();
					vskPfSkdDtlVO.setRowSeq(list.get(i).getRowSeq());
					vskPfSkdDtlVO.setVslSlanCd(list.get(i).getVslSlanCd());

					vskPfSkdDtlVO.setPfSvcTpCd(list.get(i).getPfSvcTpCd());
					vskPfSkdDtlVO.setPortCd(list.get(i).getPortCd());
					vskPfSkdDtlVO.setSkdDirCd(list.get(i).getSkdDirCd());
					vskPfSkdDtlVO.setClptSeq(list.get(i).getClptSeq());
					vskPfSkdDtlVO.setPortRotnSeq(list.get(i).getPortRotnSeq());

					vskPfSkdDtlVO.setYdCd(list.get(i).getTempYdCd());
					vskPfSkdDtlVO.setCallYdIndSeq(list.get(i).getCallYdIndSeq());
					vskPfSkdDtlVO.setTurnPortFlg(list.get(i).getTurnPortFlg());
					vskPfSkdDtlVO.setTurnPortIndCd(list.get(i).getTurnPortIndCd());
					vskPfSkdDtlVO.setEtbDyCd(list.get(i).getEtbDyCd());

					vskPfSkdDtlVO.setEtbDyNo(list.get(i).getEtbDyNo());
					vskPfSkdDtlVO.setEtbTmHrmnt(list.get(i).getEtbTmHrmnt());
					vskPfSkdDtlVO.setEtdDyCd(list.get(i).getEtdDyCd());
					vskPfSkdDtlVO.setEtdDyNo(list.get(i).getEtdDyNo());
					vskPfSkdDtlVO.setEtdTmHrmnt(list.get(i).getEtdTmHrmnt());

					vskPfSkdDtlVO.setLnkDist(list.get(i).getLnkDist());
					vskPfSkdDtlVO.setLnkSpd(list.get(i).getLnkSpd());
					vskPfSkdDtlVO.setTztmHrs(list.get(i).getTztmHrs());
					vskPfSkdDtlVO.setSeaBufHrs(list.get(i).getSeaBufHrs());
					vskPfSkdDtlVO.setSeaBufSpd(list.get(i).getSeaBufSpd());

					vskPfSkdDtlVO.setMnvrInHrs(list.get(i).getMnvrInHrs());
					vskPfSkdDtlVO.setMnvrOutHrs(list.get(i).getMnvrOutHrs());
					vskPfSkdDtlVO.setIbIpcgoQty(list.get(i).getIbIpcgoQty());
					vskPfSkdDtlVO.setIbOcnCgoQty(list.get(i).getIbOcnCgoQty());
					vskPfSkdDtlVO.setObIpcgoQty(list.get(i).getObIpcgoQty());

					vskPfSkdDtlVO.setObOcnCgoQty(list.get(i).getObOcnCgoQty());
					vskPfSkdDtlVO.setTmlProdQty(list.get(i).getTmlProdQty());
					vskPfSkdDtlVO.setCrnKnt(list.get(i).getCrnKnt());
					vskPfSkdDtlVO.setActWrkHrs(list.get(i).getActWrkHrs());
					vskPfSkdDtlVO.setPortBufHrs(list.get(i).getPortBufHrs());

					vskPfSkdDtlVO.setZd(list.get(i).getZd());
					vskPfSkdDtlVO.setTotMaxSpd(list.get(i).getTotMaxSpd());
					vskPfSkdDtlVO.setTotAvgSpd(list.get(i).getTotAvgSpd());
					vskPfSkdDtlVO.setBufSpd(list.get(i).getSeaBufSpd());

					vskPfSkdDtlVO.setTotBufRat(list.get(i).getTotBufRat());
					vskPfSkdDtlVO.setSeaBufRat(list.get(i).getSeaBufRat());
					vskPfSkdDtlVO.setPortBufRat(list.get(i).getPortBufRat());
					vskPfSkdDtlVO.setPfSpdRat(list.get(i).getPfSpdRat());
					vskPfSkdDtlVO.setBufSpdRat(list.get(i).getBufSpdRat());
					vskPfSkdDtlVO.setMinMaxSpd(list.get(i).getMinMaxSpd());

					vskPfSkdDtlVOs.add(vskPfSkdDtlVO);

				}

			sb.append(list.get(0).getTempYdCd());
			for(int i=1; i<list.size(); i++){
				sb.append("|");
				sb.append(list.get(i).getTempYdCd());
			}


			sb2.append(list.get(0).getMinMaxSpd());

			eventResponse.setRsVo(vskPfSkdVO);
			eventResponse.setRsVoList(vskPfSkdDtlVOs);
			eventResponse.setETCData("ydCd", sb.toString());
			eventResponse.setETCData("etcdt", sb2.toString());
			}else{
				eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"P/F SKD Creation(CCA)"}).getUserMessage());
			}
		}else if(e instanceof VopVsk0054Event){

			if(list==null || list.size()==0){

				if (pfSkdVO != null) {
					if("N".equals(pfSkdVO.getSlanStndFlg())){
						// PF_SVC_TP_CD 가 Standard 타입이 아니라 화면에서 입력한 경우임.
						// 조회결과가 없을때는 해당 PF_SVC_TP_CD이 존재하지 않음.
						// VSK10023 : 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
	//					throw new EventException(new ErrorHandler("VSK10023").getUserMessage());
						eventResponse.setUserMessage(new ErrorHandler("VSK10023").getUserMessage());
					}else{
						// Proforma Schedule이 등록 되지 않았을 경우에 표시
	//					throw new EventException(new ErrorHandler("VSK10020").getUserMessage());
						eventResponse.setUserMessage(new ErrorHandler("VSK10020").getUserMessage());
					}
				}
				return eventResponse;
			}

			if("F".equals(uiVesselType)){
				pfSkdVO = list.get(0);
				// Lane Type을 Feeder 로 조회했으나
				// 해당 레인의 타입이 Feeder 타입이 아닌경우
				// VSL_SVC_TP_CD 가 'O'가 아닐때, FDR_DIV_CD도 'O'이 아닌 경우
				if(!"O".equals(pfSkdVO.getVslSvcTpCd()) && !"O".equals(fdrDivCd)){
					eventResponse.setUserMessage(new ErrorHandler("VSK10049").getUserMessage());
					return eventResponse;
				}
			}

			int vslCount = 0;
			String vslSlanNm = "";

			if(list != null && list.size()>0){
				pfSkdVO = list.get(0);
				vslCount = Integer.parseInt(pfSkdVO.getN1stVslClssKnt()==null||pfSkdVO.getN1stVslClssKnt().trim().length()==0?"0":pfSkdVO.getN1stVslClssKnt())
							+ Integer.parseInt(pfSkdVO.getN2ndVslClssKnt()==null||pfSkdVO.getN2ndVslClssKnt().trim().length()==0?"0":pfSkdVO.getN2ndVslClssKnt())
							+ Integer.parseInt(pfSkdVO.getN3rdVslClssKnt()==null||pfSkdVO.getN3rdVslClssKnt().trim().length()==0?"0":pfSkdVO.getN3rdVslClssKnt());

				vslSlanNm = pfSkdVO.getVslSlanNm();

				StringBuilder portCdSb = new StringBuilder();
				StringBuilder portDirCdSb = new StringBuilder();
				StringBuilder skdDirCdSb = new StringBuilder();
				StringBuilder etbDyCdSb = new StringBuilder();

				for(int i=0; i<list.size(); i++){
					pfSkdVO = list.get(i);
					portCdSb.append("|" + pfSkdVO.getPortCd());
					portDirCdSb.append("|" + pfSkdVO.getPortCd() + " [" + pfSkdVO.getSkdDirCd() + "]");
					skdDirCdSb.append("|" + pfSkdVO.getSkdDirCd());
					etbDyCdSb.append("|" + pfSkdVO.getEtbDyCd());
				}

				eventResponse.setETCData("vsl_count", Integer.toString(vslCount));
				eventResponse.setETCData("pf_svc_tp_cd", pfSkdVO.getPfSvcTpCd());
				eventResponse.setETCData("port_cd", portCdSb.toString());
				eventResponse.setETCData("port_dir_cd", portDirCdSb.toString());
				eventResponse.setETCData("skd_dir_cd", skdDirCdSb.toString());
				eventResponse.setETCData("etb_dy_cd", etbDyCdSb.toString());
				eventResponse.setETCData("vsl_slan_nm", vslSlanNm);
				eventResponse.setETCData("brth_itval_dys", pfSkdVO.getBrthItvalDys());
				eventResponse.setETCData("svc_dur_dys", pfSkdVO.getSvcDurDys());

				eventResponse.setRsVoList(list);
			}

		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0012 : Vessel Code Input
	 *
	 * 특정 Port Skd 목록에서 해당 Vessel Code를 가지는 Lane 정보 목록을 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse searchVslSlanCdListByVessel(Event e) throws EventException {

		try{
			VesselVO vesselVO = new VesselVO();
			VopVsk0012Event event = (VopVsk0012Event)e;
			PortSkdOnLongRangeVO portSkdOnLongRangeVO = event.getPortSkdOnLongRangeVO();

			vesselVO.setVslCd(portSkdOnLongRangeVO.getVslCd());
			vesselVO.setIncDelVsl(portSkdOnLongRangeVO.getIncDelVsl());

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			VSKCodeFinderBC comCommand = new VSKCodeFinderBCImpl();
			LongRangeScheduleMgtBC lrsCommand = new VesselScheduleMgtBCImpl();

			List<VesselVO> list = comCommand.searchVslList(vesselVO);

			if(list!=null && list.size()==1){
				eventResponse.setETCData("vsl_eng_nm", list.get(0).getVslEngNm());

				List<PortSkdOnLongRangeVO> portSkdOnLongRangeVOs = lrsCommand.searchPortSkd(portSkdOnLongRangeVO);
				Set<String> vslSlanCdSet = new HashSet<String>();
				String vslSlanCd = null;

				// 조회된 스케쥴에서 VSL_SLAN_CD 만 추려낸다.
				for(PortSkdOnLongRangeVO vo : portSkdOnLongRangeVOs){
					vslSlanCd = VSKGeneralUtil.getCheckNullToString(vo.getVslSlanCd());
					if(vslSlanCd.length()!=0){
						vslSlanCdSet.add(vslSlanCd);
					}
				}

				if(vslSlanCdSet.size()>0){
					StringBuilder vslSlanCdArr = new StringBuilder().append("");
					for(Iterator<String> i = vslSlanCdSet.iterator(); i.hasNext(); ){
						vslSlanCdArr.append("|").append(i.next());
					}
					eventResponse.setETCData("vsl_slan_cd_arr", vslSlanCdArr.toString());
				}

			}

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0012 : LRS SKD Inquiry
	 *
	 * Yard Code 정보로 Yard Name을 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardName(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			VopVsk0012Event event = (VopVsk0012Event)e;
			LongRangeScheduleMgtBC command = new VesselScheduleMgtBCImpl();
			
			String ydNm = command.searchYardName(event.getYdCd());
			eventResponse.setETCData("yd_nm", ydNm);
			
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_0010 : Vessel Code Input
	 * VOP_VSK_0012 : Vessel Code Input
	 *
	 * 해당 Vessel Code를 가지는 Vessel 정보를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse searchVslList(Event e) throws EventException {
		VesselVO vo = new VesselVO();
		if(e instanceof VopVsk0010Event){
			VopVsk0010Event event = (VopVsk0010Event)e;
			vo.setVslCd((String)event.getAttribute("vsl_cd"));
		}else if(e instanceof VopVsk0012Event){
			VopVsk0012Event event = (VopVsk0012Event)e;
			vo.setVslCd(event.getPortSkdOnLongRangeVO().getVslCd());
			vo.setIncDelVsl(event.getPortSkdOnLongRangeVO().getIncDelVsl());
		}

		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<VesselVO> list = command.searchVslList(vo);

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);

		if(list!=null && list.size()==1){
			eventResponse.setETCData("vsl_eng_nm", list.get(0).getVslEngNm());
		}

		return eventResponse;
	}

	/**
	 * VOP_VSK_0010, VOP_VSK_0054 : Save
	 *
	 * Long Range Schedule 정보를 생성합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse createLongRngSkd(Event e) throws EventException {

		LongRangeSkdGRPVO 	longRangeSkdGRPVO 	= null;
		VskVslSkdHisVO 		vskVslSkdHisVO 		= null;
		String				sFromEventSystem	= "";
		
		if(e instanceof VopVsk0010Event){
			VopVsk0010Event event 	= (VopVsk0010Event)e;
			longRangeSkdGRPVO 		= event.getLongRangeSkdGRPVO();
			longRangeSkdGRPVO.setPfSkdVOs(event.getPfSkdVOs());
			vskVslSkdHisVO 			= event.getVskVslSkdHisVO();
			
			sFromEventSystem		= "DELETE_LRS_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0010)";
		}else if(e instanceof VopVsk0054Event){
			VopVsk0054Event event 	= (VopVsk0054Event)e;
			longRangeSkdGRPVO 		= event.getLongRangeSkdGRPVO();
			longRangeSkdGRPVO.setPfSkdVOs(event.getPfSkdVOs());
//			vskVslSkdHisVO = event.getVskVslSkdHisVO();
			
			sFromEventSystem		= "DELETE_LRS_Feeder_DeletedGroupVVD_OnNoneBKG(VOP_VSK_0054)";
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			LongRangeScheduleMgtBC 			command 		= new VesselScheduleMgtBCImpl();
			CoastalScheduleMgtBC 			costalCommand 	= new VesselScheduleMgtBCImpl();
			ActualScheduleMgtBC 			actCommand 		= new ActualScheduleMgtBCImpl();
			GeneralBookingSplitCombineBC 	bkgCommand 		= new GeneralBookingSplitCombineBCImpl();

			if (longRangeSkdGRPVO != null) {
				longRangeSkdGRPVO.setCreUsrId(account.getUsr_id());
				longRangeSkdGRPVO.setUpdUsrId(account.getUsr_id());
			}

			// 이미 존재하는 VVD를 삭제한다.
			// Booking이 없는 VVD
			ActivationVvdVO[] nonBkgVOs = new ActivationVvdVO[0];
			if (longRangeSkdGRPVO != null) {
				nonBkgVOs = longRangeSkdGRPVO.getNonBkgVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getNonBkgVVDs();
			}
			for(int i=0; i<nonBkgVOs.length; i++){
				nonBkgVOs[i].setCreUsrId(account.getUsr_id());
				nonBkgVOs[i].setUpdUsrId(account.getUsr_id());
			}

			// Booking이 있는 VVD
			ActivationVvdVO[] bkgVVDs 		= new ActivationVvdVO[0];
			ActivationVvdVO[] virVVDs 		= new ActivationVvdVO[0];
			ActivationVvdVO[] bkgVirVVDs 	= new ActivationVvdVO[0];
			if (longRangeSkdGRPVO != null) {
				bkgVVDs 		= longRangeSkdGRPVO.getBkgVVDs()	==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getBkgVVDs();
				virVVDs 		= longRangeSkdGRPVO.getVirVVDs()	==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getVirVVDs();
				bkgVirVVDs 	= longRangeSkdGRPVO.getBkgVirVVDs()	==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getBkgVirVVDs();
			}
			ActivationVvdVO[] bkgVOs 		= new ActivationVvdVO[bkgVVDs.length + virVVDs.length + bkgVirVVDs.length];

			int m = 0;
			for(int i=0; i<bkgVVDs.length; i++){
				bkgVOs[m] = new ActivationVvdVO();
				bkgVOs[m].setVslSlanCd(bkgVVDs[i].getVslSlanCd());
				bkgVOs[m].setVslCd(bkgVVDs[i].getVslCd());
				bkgVOs[m].setSkdVoyNo(bkgVVDs[i].getSkdVoyNo());
				bkgVOs[m].setSkdDirCd(bkgVVDs[i].getSkdDirCd());
				bkgVOs[m].setTurnSkdVoyNo(bkgVVDs[i].getSkdVoyNo());
				bkgVOs[m].setTurnSkdDirCd(bkgVVDs[i].getSkdDirCd());
				bkgVOs[m].setHisflag("VVD");
				bkgVOs[m].setCreUsrId(account.getUsr_id());
				bkgVOs[m].setUpdUsrId(account.getUsr_id());
				m++;
			}
			for(int i=0; i<virVVDs.length; i++){
				bkgVOs[m] = new ActivationVvdVO();
				bkgVOs[m].setVslSlanCd(virVVDs[i].getVslSlanCd());
				bkgVOs[m].setVslCd(virVVDs[i].getVslCd());
				bkgVOs[m].setSkdVoyNo(virVVDs[i].getSkdVoyNo());
				bkgVOs[m].setSkdDirCd(virVVDs[i].getSkdDirCd());
				bkgVOs[m].setTurnSkdVoyNo(virVVDs[i].getSkdVoyNo());
				bkgVOs[m].setTurnSkdDirCd(virVVDs[i].getSkdDirCd());
				bkgVOs[m].setHisflag("VIR");
				bkgVOs[m].setCreUsrId(account.getUsr_id());
				bkgVOs[m].setUpdUsrId(account.getUsr_id());
				m++;
			}
			for(int i=0; i<bkgVirVVDs.length; i++){
				bkgVOs[m] = new ActivationVvdVO();
				bkgVOs[m].setVslSlanCd(bkgVirVVDs[i].getVslSlanCd());
				bkgVOs[m].setVslCd(bkgVirVVDs[i].getVslCd());
				bkgVOs[m].setSkdVoyNo(bkgVirVVDs[i].getSkdVoyNo());
				bkgVOs[m].setSkdDirCd(bkgVirVVDs[i].getSkdDirCd());
				bkgVOs[m].setTurnSkdVoyNo(bkgVirVVDs[i].getSkdVoyNo());
				bkgVOs[m].setTurnSkdDirCd(bkgVirVVDs[i].getSkdDirCd());
				bkgVOs[m].setHisflag("ALL");
				bkgVOs[m].setCreUsrId(account.getUsr_id());
				bkgVOs[m].setUpdUsrId(account.getUsr_id());
				m++;
			}

			costalCommand.removeCstSkdByVvd(nonBkgVOs, bkgVOs, vskVslSkdHisVO, account, sFromEventSystem);

			// Actual Schedule을 삭제하고 Booking 모듈에 VVD 변경 공지를 전송한다.
			List<VvdVO> vvdVOs = new ArrayList<VvdVO>();
			List<VvdVO> turnVvdVOs = new ArrayList<VvdVO>();
			List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = new ArrayList<VslSkdCngNoticeVO>();

			if(nonBkgVOs.length!=0){
				for(ActivationVvdVO activationVvdVO : nonBkgVOs){
					VvdVO vo = new VvdVO();
					vo.setVslSlanCd(activationVvdVO.getVslSlanCd());
					vo.setVslCd(activationVvdVO.getVslCd());
					vo.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
					vo.setSkdDirCd(activationVvdVO.getSkdDirCd());
					vvdVOs.add(vo);

					// TURN 정보가 있으면
					if(activationVvdVO.getTurnSkdDirCd()!=null && activationVvdVO.getTurnSkdDirCd().length()!=0){
						VvdVO turnVo = new VvdVO();
						turnVo.setVslSlanCd(activationVvdVO.getVslSlanCd());
						turnVo.setVslCd(activationVvdVO.getVslCd());
						turnVo.setSkdVoyNo(activationVvdVO.getTurnSkdVoyNo());
						turnVo.setSkdDirCd(activationVvdVO.getTurnSkdDirCd());
						turnVvdVOs.add(turnVo);
					}
				}
			}

			if(bkgVOs.length!=0){
				for(ActivationVvdVO activationVvdVO : bkgVOs){
					VvdVO vo = new VvdVO();
					vo.setVslSlanCd(activationVvdVO.getVslSlanCd());
					vo.setVslCd(activationVvdVO.getVslCd());
					vo.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
					vo.setSkdDirCd(activationVvdVO.getSkdDirCd());
					vvdVOs.add(vo);

					VslSkdCngNoticeVO noticeVO = new VslSkdCngNoticeVO();
					noticeVO.setVslCd(activationVvdVO.getVslCd());
					noticeVO.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
					noticeVO.setSkdDirCd(activationVvdVO.getSkdDirCd());
					vslSkdCngNoticeVOs.add(noticeVO);

					// TURN 정보가 있으면
					if(activationVvdVO.getTurnSkdDirCd()!=null && activationVvdVO.getTurnSkdDirCd().length()!=0){
						VvdVO turnVo = new VvdVO();
						turnVo.setVslSlanCd(activationVvdVO.getVslSlanCd());
						turnVo.setVslCd(activationVvdVO.getVslCd());
						turnVo.setSkdVoyNo(activationVvdVO.getTurnSkdVoyNo());
						turnVo.setSkdDirCd(activationVvdVO.getTurnSkdDirCd());
						turnVvdVOs.add(turnVo);
					}
				}
			}

			actCommand.removeVskActPortSkd(vvdVOs);
			bkgCommand.sendVslSkdCngNotice(vslSkdCngNoticeVOs);

			//--------------------------- VVD 정리 끝 ---------------------------


			//--------------------------- 신규 VVD 생성 시작 ---------------------------
			longRangeSkdGRPVO = command.createLongRngSkd(longRangeSkdGRPVO);
			List<VskVslSkdVO> createdSkdVOs = longRangeSkdGRPVO.getVskVslSkdList(); // 생성된 VVD 목록

			//-------------------------- 외부인터페이스 대상 VO 작업 ---------------------------
			// 삭제된 VVD 목록 생성
			List<VskVslSkdVO> vskVslSkdVOs = new ArrayList<VskVslSkdVO>();
			for(VvdVO vvdVO : vvdVOs){
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
				vskVslSkdVO.setVslCd(vvdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
				vskVslSkdVOs.add(vskVslSkdVO);
			}
			for(VvdVO vvdVO : turnVvdVOs){
				VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
				vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
				vskVslSkdVO.setVslCd(vvdVO.getVslCd());
				vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
				vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
				vskVslSkdVOs.add(vskVslSkdVO);
			}

			// 삭제된 VVD 목록 + 생성된 VVD 목록
			vskVslSkdVOs.addAll(createdSkdVOs);

			//--------------------------- BKG BDR 전송 시작 ------------------------------
			vvdVOs = new ArrayList<VvdVO>();
			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
				VvdVO vvdVO = new VvdVO();
				vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
				vvdVO.setVslCd(vskVslSkdVO.getVslCd());
				vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
				vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
				vvdVOs.add(vvdVO);
			}

			List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = costalCommand.searchBkgBdrLog(vvdVOs);
			sendBkgVvdBdrLog(bkgVvdBdrLogVOs);

			//--------------------------- ERP 전송 시작 ---------------------------
			// ERP에 전송
			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
				vskVslSkdVO.setCreUsrId(account.getUsr_id());
				vskVslSkdVO.setUpdUsrId(account.getUsr_id());
			}
			sendVslSkdErpIf(vskVslSkdVOs);

			//--------------------------- EDI 전송 시작 ---------------------------
			// EDI에는 생성된 VVD 목록만 전송한다.
			vvdVOs = new ArrayList<VvdVO>();
			for(VskVslSkdVO vskVslSkdVO : createdSkdVOs){
				VvdVO vvdVO 		= new VvdVO();
				vvdVO.setVslSlanCd	(vskVslSkdVO.getVslSlanCd	());
				vvdVO.setVslCd		(vskVslSkdVO.getVslCd		());
				vvdVO.setSkdVoyNo	(vskVslSkdVO.getSkdVoyNo	());
				vvdVO.setSkdDirCd	(vskVslSkdVO.getSkdDirCd	());
				// CHM-201006129-01
				vvdVO.setCreUsrId	(account.getUsr_id			());
				vvdVO.setUpdUsrId	(account.getUsr_id			());
				
				vvdVOs.add			(vvdVO);
			}
			costalCommand.sendEdiToDLS(vvdVOs); //EDI 전송 막음. 2010.04.06 유혁

			// 성공메시지
			// VSK10016 : 저장 작업이 성공했습니다.
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			
			/*******************************************************************************************************************
			 *                				::CREATION/UPDATE 	::UI ID + UI NAME						::Method Name
			 * -----------------------------------------------------------------------------------------------------------------
			 * CREATION_LRS 				::CREATION          ::VOP_VSK_0010(LONG RANGE SKD CREATION)::createLongRngSkd
			 * -----------------------------------------------------------------------------------------------------------------
			 * UPDATE_CST_ByVvd				::UPDATE			::VOP_VSK_0015(COSTAL SKD UPDATE)		::manageCstSkdByVvd
			 * INSERT_CST_ByVvd_NormalPort	::INSERT			::VOP_VSK_0014/0015						::manageCstSkdByVvd
			 * INSERT_CST_ByVvd_VirtualPort	::INSERT			::VOP_VSK_0014/0015						::manageCstSkdByVvd 
			 * -----------------------------------------------------------------------------------------------------------------
			 * UPDATE_ACT_AutoUpdate		::UPDATE			::VOP_VSK_0025+EDI+ESVC					::manageCstSkdByActual
			 * -----------------------------------------------------------------------------------------------------------------
			 * UPDATE_CST_ByBrthWdo			::UPDATE			::VOP_VSK_0017(DAILY BERTH WINDOW)		::manageCstSkdBerthWdo
			 * -----------------------------------------------------------------------------------------------------------------
			 */
			/* ============================================================================
			 * Vessel Schedule History 관리(Header+Detail) Started ::2013-08-27::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
			 * ============================================================================
			 */
			costalCommand.createVesselScheduleChangeHistory(longRangeSkdGRPVO.getVskVslSkdList(), null, "CREATION_LRS");
			
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * Booking VVD BDR Log 정보를 전송합니다.
	 *
	 * @param List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs
	 */
	private void sendBkgVvdBdrLog(List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs){
		if(bkgVvdBdrLogVOs != null && bkgVvdBdrLogVOs.size()>0){
			BookingProcessMgtBC bkgPrsCmd = new BookingProcessMgtBCImpl();
			for(BkgVvdBdrLogVO bkgVvdBdrLogVO : bkgVvdBdrLogVOs){
				
				//::2013-10-25::BKG BackEndJob 호출시 Timestamp Logging을 위한 추가:://
				Calendar 	cal 	= Calendar.getInstance();
				Date 		date	= cal.getTime();
				//////////////////////////////////////////////////////////////////
				
				try{
					bkgPrsCmd.manageBKGBDRLOGBackEndJob(bkgVvdBdrLogVO, account);
					
				}catch(Exception ex){
					// Exception 발생해도 업무는 그냥 진행되도록 처리(2010.06.07 Booking 에서 요청).
					log.error(ex.getMessage() 	+ "VSK (SC.sendBkgVvdBdrLog) Logging VVD ["+bkgVvdBdrLogVO.getVslCd()+bkgVvdBdrLogVO.getSkdVoyNo()+bkgVvdBdrLogVO.getSkdDirCd()+"], PORT ["
												+ bkgVvdBdrLogVO.getVpsPortCd() +"]-["+bkgVvdBdrLogVO.getClptIndSeq()+"] ["+bkgVvdBdrLogVO.getSkdCngStsCd()+"] :: S.Lane ["+bkgVvdBdrLogVO.getVslSlanCd()+"] :: timestamp ["+date+"]");
					
				}
			}
		}
	}

	/**
	 * Long Range Creation에서 생성된 VVD를 ERP로 송신합니다.<br>
	 *
	 * @param List<VskVslSkdVO> vskVslSkdVOs
	 * @throws EventException
	 * @author Hyuk Ryu
	 * @date 2009. 11. 4.
	 */
	private void sendVslSkdErpIf(List<VskVslSkdVO> vskVslSkdVOs) throws EventException {
		try{
			CoastalScheduleMgtBC 	command 	= new VesselScheduleMgtBCImpl();
			List<VvdVO> 			erpVvdVOs 	= new ArrayList<VvdVO>();

			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
				VvdVO vvdVO = new VvdVO();
//				vvdVO.setIbflag("I");
				vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
				vvdVO.setVslCd(vskVslSkdVO.getVslCd());
				vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
				vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
				vvdVO.setCreUsrId(vskVslSkdVO.getCreUsrId());
				vvdVO.setUpdUsrId(vskVslSkdVO.getUpdUsrId());
				erpVvdVOs.add(vvdVO);
			}
			command.sendVslSkdErpIf(erpVvdVOs);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_0010 : Simulation
	 * Long Range SKD Schedule을 simulation 합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 */
	private EventResponse simulateLongRngSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0010Event event = (VopVsk0010Event)e;

//		ProformaScheduleMgtBC command1 = new ProformaScheduleMgtBCImpl();
		LongRangeScheduleMgtBC command2 = new VesselScheduleMgtBCImpl();

		LongRangeSkdGRPVO longRangeSkdGRPVO = event.getLongRangeSkdGRPVO();
//		List<PfSkdVO> pfSkdVOList = command1.searchPfSkd(
//				longRangeSkdGRPVO.getVslSlanCd(),
//				longRangeSkdGRPVO.getPfSvcTpCd(),
//				longRangeSkdGRPVO.getVslSvcTpCd());


		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if (e.getFormCommand().isCommand(FormCommand.SEARCH02) // Simulation
				|| e.getFormCommand().isCommand(FormCommand.SEARCH03)){  // Phase In

			List<LongRangeSkdVO> longRangeSkdVOList = command2.simulateLongRngSkd(longRangeSkdGRPVO);
			eventResponse.setRsVoList(longRangeSkdVOList);

			// simulation 거래는 아직 헤더에 대한 조작이 없는 최초의 상태이므로
			// P/F 만을 가지고 헤더를 생성한다.

			// 헤더정보
			StringBuilder headTitle1 = new StringBuilder(); // SKD_DIR_CD
			StringBuilder headTitle2 = new StringBuilder(); // VPS_PORT_CD
			StringBuilder headTitle3 = new StringBuilder(); // ETB_DY_CD/ETD_DY_CD
			StringBuilder headTitle4 = new StringBuilder(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			StringBuilder headTitle5 = new StringBuilder(); // CLPT_SEQ
			StringBuilder headTitle6 = new StringBuilder(); // YARD_CD

			for(PfSkdVO vo : longRangeSkdGRPVO.getPfSkdVOs()){

				headTitle1.append("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd());
				headTitle2.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
				headTitle3.append("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd());
				headTitle4.append("|").append(vo.getEtbTmHrmnt().substring(0,2)).append("|").append(vo.getEtdTmHrmnt().substring(0,2));
				headTitle5.append("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq());
				headTitle6.append("|").append(vo.getYdCd()).append("|").append(vo.getYdCd());

			}

			eventResponse.setETCData("HeadTitle1", headTitle1.toString());
			eventResponse.setETCData("HeadTitle2", headTitle2.toString());
			eventResponse.setETCData("HeadTitle3", headTitle3.toString());
			eventResponse.setETCData("HeadTitle4", headTitle4.toString());
			eventResponse.setETCData("HeadTitle5", headTitle5.toString());
			eventResponse.setETCData("HeadTitle6", headTitle6.toString());

		}
//		else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) // phasein
//		{
//
//			// phase in 될 vessel 정보 조회
////			List<PfSkdVO>phaseinPortSkdVOList = command1.searchPfSkd(longRangeSkdGRPVO.getVslSlanCd(), longRangeSkdGRPVO.getPfSvcTpCd(), longRangeSkdGRPVO.getVslSvcTpCd());
//
//			PfSkdVO[] pfSkdVOS = longRangeSkdGRPVO.getPfSkdVOs();
//			List<String[]> phaseInVslInfo = new ArrayList<String[]>();
//			String[] phaseinVslInfo = new String[]{
//					longRangeSkdGRPVO.getPhaseinStartDate(),
//					longRangeSkdGRPVO.getPhaseinVslCd(),
//					longRangeSkdGRPVO.getPhaseinVoyNo()
//			};
//			phaseInVslInfo.add(phaseinVslInfo);
//
//			// PhaseIn 된 Vessel에 대한 스케쥴만 생성. 기존 Vessel 리스트는 백업
//			List<String[]> orgVslInfo = longRangeSkdGRPVO.getVslInfo();
//			longRangeSkdGRPVO.setVslInfo(phaseInVslInfo);
//			List<LongRangeSkdVO> phaseInVOList = command2.simulateLongRngSkd(longRangeSkdGRPVO);
//
//			longRangeSkdGRPVO.setVslInfo(orgVslInfo);
//
//			// 화면 스케쥴 정보 획득
//
//			List<PfSkdVO> simHeaderPortList = loadSimHeaderPortList(longRangeSkdGRPVO);
////			List<LongRangeSkdVO> simDataList = loadSimDataList(simHeaderPortList, longRangeSkdGRPVO);
////
////			// 화면스케쥴 상의 정보에서 phase in 되어 들어갈 위치에 데이터 삽입
////			int phaseinStartRow = findPhaseinRow(longRangeSkdGRPVO, simHeaderPortList, simDataList);
////
////			List<List<LongRangeSkdVO>> skdSplitList = new ArrayList<List<LongRangeSkdVO>>();
////			List<List<LongRangeSkdVO>> phaseInSplitList = new ArrayList<List<LongRangeSkdVO>>();
////			List<List<LongRangeSkdVO>> finalList = new ArrayList<List<LongRangeSkdVO>>();
////
////			int pos = 0;
////			for(int i=0; i<simDataList.size(); i++){
////				// split
////				if(simDataList.get(i).getVslCd()==null){
////					skdSplitList.add(simDataList.subList(pos, i));
////					pos = i+1;
////				}
////			}
////
////			pos = 0;
////			for(int i=0; i<phaseInVOList.size(); i++){
////				// split
////				if(phaseInVOList.get(i).getVslCd()==null){
////					phaseInSplitList.add(phaseInVOList.subList(pos, i));
////					pos = i+1;
////				}
////			}
////
////			// 최종 조합
////
////			List<String[]> vslInfos = longRangeSkdGRPVO.getVslInfo();
////			int m = 0;
////			int k = 0;
////
////			while(m!=skdSplitList.size() || k!=phaseInSplitList.size()){
////				if(m<phaseinStartRow){
////					finalList.add(skdSplitList.get(m++));
////				}else{
////					if(k<phaseInSplitList.size()){
////						finalList.add(phaseInSplitList.get(k++));
////						finalList.add(phaseInSplitList.get(k++));
////						finalList.add(phaseInSplitList.get(k++));
////					}
////					for(int i=0; i<vslInfos.size()*3;i++){
////						if(m<skdSplitList.size()){
////							finalList.add(skdSplitList.get(m++));
////						}
////					}
////				}
////			}
////
////			List<LongRangeSkdVO> skdList = new ArrayList<LongRangeSkdVO>();
////
////			for(int i=0; i<finalList.size(); i++){
////				List<LongRangeSkdVO> list = finalList.get(i);
////				for(int j=0; j<list.size(); j++){
////					skdList.add(list.get(j));
////				}
////				skdList.add(new LongRangeSkdVO());
////			}
////
////			eventResponse.setRsVoList(skdList);
//
//			eventResponse.setETCData("HeadTitle1", longRangeSkdGRPVO.getHeadTitle1());
//			eventResponse.setETCData("HeadTitle2", longRangeSkdGRPVO.getHeadTitle2());
//			eventResponse.setETCData("HeadTitle3", longRangeSkdGRPVO.getHeadTitle3());
//			eventResponse.setETCData("HeadTitle4", longRangeSkdGRPVO.getHeadTitle4());
//			eventResponse.setETCData("HeadTitle5", longRangeSkdGRPVO.getHeadTitle5());
//			eventResponse.setETCData("HeadTitle6", longRangeSkdGRPVO.getHeadTitle6());
//			return eventResponse;
//
//		}
		else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) // phasein cancel
		{
			// 화면 스케쥴 정보 획득

//			List<PfSkdVO> simHeaderPortList = loadSimHeaderPortList(longRangeSkdGRPVO);
//			List<LongRangeSkdVO> simDataList = loadSimDataList(simHeaderPortList, longRangeSkdGRPVO);
//
//			eventResponse.setRsVoList(simDataList);

			eventResponse.setETCData("HeadTitle1", longRangeSkdGRPVO.getHeadTitle1());
			eventResponse.setETCData("HeadTitle2", longRangeSkdGRPVO.getHeadTitle2());
			eventResponse.setETCData("HeadTitle3", longRangeSkdGRPVO.getHeadTitle3());
			eventResponse.setETCData("HeadTitle4", longRangeSkdGRPVO.getHeadTitle4());
			eventResponse.setETCData("HeadTitle5", longRangeSkdGRPVO.getHeadTitle5());
			eventResponse.setETCData("HeadTitle6", longRangeSkdGRPVO.getHeadTitle6());
			return eventResponse;

		}
		else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) // add calling
		{
			int addCallPos = Integer.parseInt(longRangeSkdGRPVO.getAddCallPoint());
			String addCallPosition = longRangeSkdGRPVO.getAddCallPosition();
			if("before".equals(addCallPosition)){
				addCallPos = addCallPos + 0;
			}else if("after".equals(addCallPosition)){
				addCallPos = addCallPos + 1;
			}

//			int addVvdPos = Integer.parseInt(longRangeSkdGRPVO.getAddVvdPoint());
			String addPortCd = longRangeSkdGRPVO.getAddCallPortCd();
			String addYardCd = longRangeSkdGRPVO.getAddCallYardCd();

			// 헤더정보
			String headTitle1 = longRangeSkdGRPVO.getHeadTitle1();
			String headTitle2 = longRangeSkdGRPVO.getHeadTitle2();
			String headTitle3 = longRangeSkdGRPVO.getHeadTitle3();
			String headTitle4 = longRangeSkdGRPVO.getHeadTitle4();
			String headTitle5 = longRangeSkdGRPVO.getHeadTitle5();
			String headTitle6 = longRangeSkdGRPVO.getHeadTitle6();

			// 파이프라인(|)은 정규식에서는 특수문자 이므로
			// 일반문자로 인식시키기 위해 \\를 사용한다.
			String[] titles1 = headTitle1.split("\\|");
			String[] titles2 = headTitle2.split("\\|");
			String[] titles3 = headTitle3.split("\\|");
			String[] titles4 = headTitle4.split("\\|");
			String[] titles5 = headTitle5.split("\\|");
			String[] titles6 = headTitle6.split("\\|");

			if(!(
					(titles1.length==titles2.length)
					&& (titles2.length==titles3.length)
					&& (titles3.length==titles4.length)
					&& (titles4.length==titles1.length)
			))
			{
				// 헤더 길이가 다르면 오류
				//throw new EventException(new ErrorHandler("VSKXXXXX").getUserMessage());
				throw new EventException("헤더길이가다름");
			}


			// 헤더정보조작
			StringBuilder sbHeadTitle1 = new StringBuilder();
			for(int i=1; i<titles1.length; i++){
				if(i==addCallPos*2-1){
					// Add Port를 시도한 방향을 그대로 유지한다. 예를 들어 W에서 Add Port했으면 W, E에서 Add Port 했으면 E이다.
					if("before".equals(addCallPosition)){
//						sbHeadTitle1.append("|").append(titles1[i+2]).append("|").append(titles1[i+2]);
						sbHeadTitle1.append("|").append(titles1[i]).append("|").append(titles1[i]);
					}else if("after".equals(addCallPosition)){
						sbHeadTitle1.append("|").append(titles1[i-2]).append("|").append(titles1[i-2]);
					}
				}
				sbHeadTitle1.append("|").append(titles1[i]);
			}

			StringBuilder sbHeadTitle2 = new StringBuilder();
			for(int i=1; i<titles2.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle2.append("|").append(addPortCd).append("|").append(addPortCd);
				}
				sbHeadTitle2.append("|").append(titles2[i]);
			}

			StringBuilder sbHeadTitle3 = new StringBuilder();
			for(int i=1; i<titles3.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle3.append("|*|*");
				}
				sbHeadTitle3.append("|").append(titles3[i]);
			}

			StringBuilder sbHeadTitle4 = new StringBuilder();
			for(int i=1; i<titles4.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle4.append("|*|*");
				}
				sbHeadTitle4.append("|").append(titles4[i]);
			}

			StringBuilder sbHeadTitle5 = new StringBuilder();
			for(int i=1; i<titles5.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle5.append("|*|*");
				}
				sbHeadTitle5.append("|").append(titles5[i]);
			}

			StringBuilder sbHeadTitle6 = new StringBuilder();
			for(int i=1; i<titles6.length; i++){
				if(i==addCallPos*2-1){
					sbHeadTitle6.append("|").append(addYardCd).append("|").append(addYardCd);
				}
				sbHeadTitle6.append("|").append(titles6[i]);
			}

			if(titles1.length==addCallPos*2-1){
				sbHeadTitle1.append("|").append(titles1[titles1.length-1]).append("|").append(titles1[titles1.length-1]);
				sbHeadTitle2.append("|").append(addPortCd).append("|").append(addPortCd);
				sbHeadTitle3.append("|*|*");
				sbHeadTitle4.append("|*|*");
				sbHeadTitle5.append("|*|*");
				sbHeadTitle6.append("|").append(addYardCd).append("|").append(addYardCd);
			}

			List<LongRangeSkdVO> list = command2.simulateLongRngSkd(longRangeSkdGRPVO);
			eventResponse.setRsVoList(list);

			eventResponse.setETCData("HeadTitle1", sbHeadTitle1.toString());
			eventResponse.setETCData("HeadTitle2", sbHeadTitle2.toString());
			eventResponse.setETCData("HeadTitle3", sbHeadTitle3.toString());
			eventResponse.setETCData("HeadTitle4", sbHeadTitle4.toString());
			eventResponse.setETCData("HeadTitle5", sbHeadTitle5.toString());
			eventResponse.setETCData("HeadTitle6", sbHeadTitle6.toString());
			return eventResponse;

		}
		else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) // add calling cancel
		{
			int addCallPos = Integer.parseInt(longRangeSkdGRPVO.getAddCallPoint());
//			String addCallPosition = longRangeSkdGRPVO.getAddCallPosition();
//			if("before".equals(addCallPosition)){
//				addCallPos = addCallPos + 0;
//			}else if("after".equals(addCallPosition)){
//				addCallPos = addCallPos + 1;
//			}

//			int addVvdPos = Integer.parseInt(longRangeSkdGRPVO.getAddVvdPoint());

			// 화면 스케쥴 정보 획득
			List<PfSkdVO> simHeaderPortList = loadSimHeaderPortList(longRangeSkdGRPVO);
//			List<LongRangeSkdVO> simDataList = loadSimDataList(simHeaderPortList, longRangeSkdGRPVO, addCallPos, addVvdPos, null, true);
			List<LongRangeSkdVO> list = command2.simulateLongRngSkd(longRangeSkdGRPVO);

			StringBuilder headTitle1 = new StringBuilder();
			StringBuilder headTitle2 = new StringBuilder();
			StringBuilder headTitle3 = new StringBuilder();
			StringBuilder headTitle4 = new StringBuilder();
			StringBuilder headTitle5 = new StringBuilder();
			StringBuilder headTitle6 = new StringBuilder();

			// 헤더정보조작
			for(int i=0; i<simHeaderPortList.size(); i++){
				if(i==addCallPos-1){
					continue;
				}
				headTitle1.append("|").append(simHeaderPortList.get(i).getSkdDirCd()).append("|").append(simHeaderPortList.get(i).getSkdDirCd());
				headTitle2.append("|").append(simHeaderPortList.get(i).getPortCd()).append("|").append(simHeaderPortList.get(i).getPortCd());
				headTitle3.append("|").append(simHeaderPortList.get(i).getEtbDyCd()).append("|").append(simHeaderPortList.get(i).getEtdDyCd());
				headTitle4.append("|").append(simHeaderPortList.get(i).getEtbTmHrmnt()).append("|").append(simHeaderPortList.get(i).getEtdTmHrmnt());
				headTitle5.append("|").append(simHeaderPortList.get(i).getClptSeq()).append("|").append(simHeaderPortList.get(i).getClptSeq());
				headTitle6.append("|").append(simHeaderPortList.get(i).getYdCd()).append("|").append(simHeaderPortList.get(i).getYdCd());
			}

			eventResponse.setRsVoList(list);

			eventResponse.setETCData("HeadTitle1", headTitle1.toString());
			eventResponse.setETCData("HeadTitle2", headTitle2.toString());
			eventResponse.setETCData("HeadTitle3", headTitle3.toString());
			eventResponse.setETCData("HeadTitle4", headTitle4.toString());
			eventResponse.setETCData("HeadTitle5", headTitle5.toString());
			eventResponse.setETCData("HeadTitle6", headTitle6.toString());
			return eventResponse;
		}


		return eventResponse;
	}

//	private int findPhaseinRow(LongRangeSkdGRPVO grpvo, List<PfSkdVO> simHeaderPortList, List<LongRangeSkdVO> simDataList){
//		int phaseinStartRow = -1;
//		int phaseinPort = Integer.parseInt(grpvo.getPhaseinCol()) - 1;
//		Map<String, String[]> simInfoMap = grpvo.getSimInfoMap();
//		String phaseinStartDate = grpvo.getPhaseinStartDate();
//		String[] vvd1 = grpvo.getVVD1();
//		String initEtbDate = null;
//
//		for(int m=0; m<vvd1.length; m++){
//			for(int k=0; k<simHeaderPortList.size(); k++){
//				initEtbDate = simInfoMap.get("ETB" + k)[m];
//				initEtbDate = Utils.changeDateFormat(initEtbDate, "MM/ddyyyyHHmm", "yyyyMMddHHmm");
//				if(phaseinStartRow==-1 && k==phaseinPort){
//					// phase in 되어 들어가는 포트와 시간 비교하여 큰 시점을 탐색
//					if(initEtbDate.compareTo(phaseinStartDate) > 0){
//						phaseinStartRow = m;
//					}
//				}
//			}
//		}
//		return phaseinStartRow;
//	}

	private List<PfSkdVO> loadSimHeaderPortList(LongRangeSkdGRPVO grpvo) throws EventException {

		// 헤더정보
		String headTitle1 = grpvo.getHeadTitle1();
		String headTitle2 = grpvo.getHeadTitle2();
		String headTitle3 = grpvo.getHeadTitle3();
		String headTitle4 = grpvo.getHeadTitle4();
		String headTitle5 = grpvo.getHeadTitle5();
		String headTitle6 = grpvo.getHeadTitle6();

		// 파이프라인(|)은 정규식에서는 특수문자 이므로
		// 일반문자로 인식시키기 위해 \\를 사용한다.
		String[] titles1 = headTitle1.split("\\|");
		String[] titles2 = headTitle2.split("\\|");
		String[] titles3 = headTitle3.split("\\|");
		String[] titles4 = headTitle4.split("\\|");
		String[] titles5 = headTitle5.split("\\|");
		String[] titles6 = headTitle6.split("\\|");

		if(!(
				(titles1.length==titles2.length)
				&& (titles2.length==titles3.length)
				&& (titles3.length==titles4.length)
				&& (titles4.length==titles1.length)
		))
		{
			// 헤더 길이가 다르면 오류
			//throw new EventException(new ErrorHandler("VSKXXXXX").getUserMessage());
			throw new EventException("헤더길이가다름");
		}

		// 헤더정보로 포트스케쥴리스트 구성
		List<PfSkdVO> headerPortList = new ArrayList<PfSkdVO>();

		for(int i=1; i<titles1.length; i=i+2){

			PfSkdVO portSkdVO = new PfSkdVO();
			portSkdVO.setPortCd(titles2[i]);
			portSkdVO.setEtbDyCd(titles3[i]);
			portSkdVO.setEtdDyCd(titles3[i+1]);
			portSkdVO.setEtbTmHrmnt(titles4[i]);
			portSkdVO.setEtdTmHrmnt(titles4[i+1]);
			portSkdVO.setSkdDirCd(titles1[i]);
			portSkdVO.setClptSeq(titles5[i]);
			portSkdVO.setYdCd(titles6[i]);

			headerPortList.add(portSkdVO);

		}

		return headerPortList;

	}

//	private List<LongRangeSkdVO> loadSimDataList(List<PfSkdVO> headerPortList, LongRangeSkdGRPVO grpvo) throws EventException {
//	return loadSimDataList(headerPortList, grpvo, 0, 0, null, false);
//}
//
//private List<LongRangeSkdVO> loadSimDataList(
//		List<PfSkdVO> headerPortList,
//		LongRangeSkdGRPVO longRangeSkdGRPVO,
//		int addCallPos,
//		int addVvdPos,
//		LongRangeSkdVO addPort,
//		boolean addCancel) throws EventException {
//
//	PfSkdVO[] pfSkdVOs = longRangeSkdGRPVO.getPfSkdVOs();
//	String[] skdRmk = longRangeSkdGRPVO.getSkdRmk();
//	String headTitle1 = longRangeSkdGRPVO.getHeadTitle1();
//	String headTitle2 = longRangeSkdGRPVO.getHeadTitle2();
//	String headTitle3 = longRangeSkdGRPVO.getHeadTitle3();
//	String headTitle4 = longRangeSkdGRPVO.getHeadTitle4();
//
//	Map<String, String[]> simInfoMap = longRangeSkdGRPVO.getSimInfoMap();
//
//	// 파이프라인(|)은 정규식에서는 특수문자 이므로
//	// 일반문자로 인식시키기 위해 \\를 사용한다.
//	String[] titles1 = headTitle1.split("\\|");
//	String[] titles2 = headTitle2.split("\\|");
//	String[] titles3 = headTitle3.split("\\|");
//	String[] titles4 = headTitle4.split("\\|");
//
//	if(!(
//			(titles1.length==titles2.length)
//			&& (titles2.length==titles3.length)
//			&& (titles3.length==titles4.length)
//			&& (titles4.length==titles1.length)
//	))
//	{
//		// 헤더 길이가 다르면 오류
//		//throw new EventException(new ErrorHandler("VSKXXXXX").getUserMessage());
//		throw new EventException("헤더길이가다름");
//	}
//
//
//	// CLPT_IND_SEQ, CLPT_SEQ, CALL_YD_IND_SEQ 설정
//
//	// ---------- Step1. PfSkdVO 리스트를 생성 시작 ----------
//
//	// PF 정보에 헤더 정보를 추가한다.(Add Call 정보가 추가될것임)
//	List<PfSkdVO> pfSkdList = new ArrayList<PfSkdVO>();
//	for(int i=1,k=0; i<titles1.length; i=i+2){
//		PfSkdVO pfSkdVO = pfSkdVOs[k];
//		if(titles2[i].equals(pfSkdVO.getPortCd())){
//			pfSkdList.add(pfSkdVO);
//			k++;
//		}else{
//			// add call 되어 title 정보에는 있지만 P/F에는 없는 상태
//			// title 정보를 이용해서 PfSkdVO를 생성한다.
//			// ETB/ETD Day Code(요일) 값이 NULL 이므로,
//			// 이를 이용하여 Add Call Port로 인식할 수 있다.
//			PfSkdVO vo = new PfSkdVO();
//			vo.setPortCd(titles2[i]);
//			vo.setSkdDirCd(titles1[i]);
//			pfSkdList.add(vo);
//		}
//	}
//
//	// ---------- Step1. PfSkdVO 리스트를 생성 완료 ----------
//
//	// ---------- Step2. 화면의 시뮬레이션 정보를 Vessel별 리스트로 전환 시작 ----------
//
//	String[] vvd1 = longRangeSkdGRPVO.getVVD1();
//	String[] vvd2 = longRangeSkdGRPVO.getVVD2();
//
//	List<LongRangeSkdVO> skdList = new ArrayList<LongRangeSkdVO>(); // 화면 스케쥴 정보
//	List<LongRangeSkdVO> tmpList = new ArrayList<LongRangeSkdVO>();
//
//	String initEtbDate = null;
//	String initEtbDay = null;
//	String initEtdDate = null;
//	String initEtdDay = null;
//
//	LongRangeSkdVO dummy = new LongRangeSkdVO();
//	LongRangeSkdVO empty = new LongRangeSkdVO();
//
//	String uiFormat = "MM/ddyyyyHHmm";
//	String dataFormat = "yyyyMMddHHmm";
//
//	if(!addCancel){
//		empty.setPortCd(addPort.getPortCd());
//		empty.setEtbDyCd("");
//		empty.setEtdDyCd("");
//		empty.setInitEtbDay("");
//		empty.setInitEtdDay("");
////		empty.setEtbTmHrmnt("");
////		empty.setEtdTmHrmnt("");
//	}
//
//	for(int m=0; m<vvd1.length; m++){
//
//		if(vvd1[m].equals(longRangeSkdGRPVO.getPhaseinVslCd())){
//			continue;
//		}
//
//		tmpList.clear();
//
//		for(int k=0; k<pfSkdList.size(); k++){
//
//			if(addCancel && k==addCallPos-1){
//				continue;
//			}
//
//			LongRangeSkdVO skdVo = new LongRangeSkdVO();
//			PfSkdVO pfSkdVO = pfSkdList.get(k);
//
//			skdVo.setVslCd(vvd1[m]);
//			skdVo.setVoyNo(vvd2[m]);
//			skdVo.setSkdDirCd(pfSkdVO.getSkdDirCd());
//
//			skdVo.setPortCd(pfSkdVO.getPortCd());
//			skdVo.setEtbDyCd(pfSkdVO.getEtbDyCd());
////			skdVo.setEtbTmHrmnt(pfSkdVO.getEtbTmHrmnt());
//			skdVo.setEtdDyCd(pfSkdVO.getEtdDyCd());
////			skdVo.setEtdTmHrmnt(pfSkdVO.getEtdTmHrmnt());
//
//			//skdVo.setInitEtbDate(titleVo.getInitEtbDate());
//			//skdVo.setInitEtdDate(titleVo.getInitEtdDate());
//
//			initEtbDate = simInfoMap.get("ETB" + k)[m];
//			initEtdDate = simInfoMap.get("ETD" + k)[m];
//
//			initEtbDate = Utils.changeDateFormat(initEtbDate, uiFormat, dataFormat);
//			initEtdDate = Utils.changeDateFormat(initEtdDate, uiFormat, dataFormat);
//
//			initEtbDay = Utils.getDay(initEtbDate);
//			initEtdDay = Utils.getDay(initEtdDate);
//
//			skdVo.setInitEtbDate(initEtbDate);
//			skdVo.setInitEtdDate(initEtdDate);
//			skdVo.setInitEtbDay(initEtbDay);
//			skdVo.setInitEtdDay(initEtdDay);
//
//			tmpList.add(skdVo);
//
//		}
//
//		tmpList.add(dummy);
//		if(!addCancel && addPort!=null){
//			if(m==addVvdPos){
//				tmpList.add(addCallPos, addPort);
//			}else{
//				tmpList.add(addCallPos, empty);
//			}
//
//		}
//			skdList.addAll(tmpList);
//	}
//
//	return skdList;
//
//	// ---------- Step2. 화면의 시뮬레이션 정보를 Vessel별 리스트로 전환 완료 ----------
//
//}

	/**
	 * VOP_VSK_0245 : Retrieve
	 * 입력 받은 VVD가 Calling 하는 Port List 정보를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCallingPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VopVsk0245Event event = (VopVsk0245Event)e;
		VvdVO[] vvdVOs = event.getVvdVOs();
//		List<VvdVO> list = new ArrayList<VvdVO>();

		if(vvdVOs.length > 0){
			for(int n=0; n<vvdVOs.length; n++){
				VvdVO vo = new VvdVO();
				vo.setVslCd(vvdVOs[n].getVslCd());
				vo.setSkdVoyNo(vvdVOs[n].getSkdVoyNo());
				vo.setSkdDirCd(vvdVOs[n].getSkdDirCd());

				SkipPortGRPVO skipPortGRPVO = command.searchCallingPortList(vo);

				if(skipPortGRPVO != null){

					List<VskVslPortSkdVO> tsPortList = skipPortGRPVO.getTsPortList();
					List<VskVslPortSkdVO> reasonPortList = skipPortGRPVO.getReasonPortList();

					if(tsPortList.size()>0){
						StringBuilder sb = new StringBuilder();
						StringBuilder infoSB = new StringBuilder();
						VskVslPortSkdVO tsPortVO = tsPortList.get(0);
						sb.append(tsPortVO.getVpsPortCd());
						infoSB.append(tsPortVO.getSkdVoyNo() + "\t" + tsPortVO.getSkdDirCd() + "\t" + tsPortVO.getVpsPortCd() + "\t" + tsPortVO.getClptIndSeq());

						for(int i=1; i<tsPortList.size(); i++){
							tsPortVO = tsPortList.get(i);

							sb.append("|" + tsPortVO.getVpsPortCd());
							infoSB.append("|" + tsPortVO.getSkdVoyNo() + "\t" + tsPortVO.getSkdDirCd() + "\t" + tsPortVO.getVpsPortCd() + "\t" + tsPortVO.getClptIndSeq());
						}
						eventResponse.setETCData("ts_port_cd"+n, sb.toString());
						eventResponse.setETCData("ts_port_info"+n, infoSB.toString());
					}

					if(reasonPortList.size()>0){
						StringBuilder sb = new StringBuilder();
						StringBuilder infoSB = new StringBuilder();
						VskVslPortSkdVO reasonPortVO = reasonPortList.get(0);
						sb.append(reasonPortVO.getVpsPortCd());
						infoSB.append(reasonPortVO.getSkdVoyNo() + "\t" + reasonPortVO.getSkdDirCd() + "\t" + reasonPortVO.getVpsPortCd() + "\t" + reasonPortVO.getClptIndSeq());

						for(int i=1; i<reasonPortList.size(); i++){
							reasonPortVO = reasonPortList.get(i);

							sb.append("|" + reasonPortVO.getVpsPortCd());
							infoSB.append("|" + reasonPortVO.getSkdVoyNo() + "\t" + reasonPortVO.getSkdDirCd() + "\t" + reasonPortVO.getVpsPortCd() + "\t" + reasonPortVO.getClptIndSeq());
						}
						eventResponse.setETCData("reason_port_cd"+n, sb.toString());
						eventResponse.setETCData("reason_port_info"+n, infoSB.toString());
					}
				}
			}
		}

		eventResponse.setETCData("code", VSKGeneralUtil.comnCodeList("CD01830", "onlycode"));
		eventResponse.setETCData("code_desc", VSKGeneralUtil.comnCodeList("CD01830", ""));

		return eventResponse;
	}


	/**
	 * VOP_VSK_0019, VOP_VSK_0014, VOP_VSK_0057 : Retrieve
	 *
	 * VVD에 대한 Costal Schedule을 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByVvd(Event e) throws EventException {
		CstSkdByVvdVO paramVO = null;
		PfLaneTypeVO pfLaneTypeVO = new PfLaneTypeVO();
		String vslSlanCd = "";
		String vslSvcTpCd = "";
		String pfSkdTpCd = "";
		String skdRmk = "";
		String bookChk = "";

		boolean chkFlag = false;	//Booking, Actual Check.

		if(e instanceof VopVsk0019Event){
			VopVsk0019Event event = (VopVsk0019Event)e;
			paramVO = event.getCstSkdByVvdVO();

			//
			paramVO.setVslSlanCd("");
		}else if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			paramVO = event.getCstSkdByVvdVO();

			chkFlag = true;
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getCstSkdByVvdVO();

			chkFlag = true;
		}else if(e instanceof VopVskSPPVSK0004Event){
			VopVskSPPVSK0004Event event = (VopVskSPPVSK0004Event)e;
			paramVO = event.getCstSkdByVvdVO();

			chkFlag = true;
		}


		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<CstSkdByVvdVO> list = null;

		if(e instanceof VopVsk0014Event || e instanceof VopVsk0057Event){
			if(chkFlag){
				int chkCnt = 0;

				VvdVO vvdVO = new VvdVO();
				vvdVO.setVslCd(paramVO.getVslCd());
				vvdVO.setSkdVoyNo(paramVO.getSkdVoyNo());
				vvdVO.setSkdDirCd(paramVO.getSkdDirCd());

				String chkStr = command.checkReuseVvd(vvdVO);
				if("Y".equals(chkStr)){
					/*
					 * MSG - 2008년 이전 이행 VVD중에 재무 VVD로 사용하고 있을 경우.
					 */
					throw new EventException(new ErrorHandler("VSK10002").getMessage());
				}else{
					chkCnt = command.checkVvdApplyBooking(vvdVO);
					if(chkCnt > 0){
						/*
						 * MSG - 이미 Book시스템 해당 VVD를 사용하고 있습니다. Coastal Simulation 화면을 사용해 주세요.
						 */
//						throw new EventException(new ErrorHandler("VSK10029").getMessage());
						bookChk = "X";
					}else{
						chkCnt = command.checkVvdActualSkdInput(vvdVO);
						if(chkCnt > 0){
							/*
							 * MSG - Actual Schedule 정보가 입력되였습니다. Coastal Simulation 화면을 사용해 주세요.
							 */
//							throw new EventException(new ErrorHandler("VSK10030").getMessage());
							bookChk = "A";
						}
					}
				}
			}
		}

		list = command.searchCstSkdByVvd(paramVO);
		List<PfLaneTypeVO> pfLaneTypeVOList = null;

		if(list != null && list.size()>0){
			if(e instanceof VopVsk0014Event || e instanceof VopVsk0057Event){
				// ************** Turnning Port 의 Booking 정보 확인 START **************
				int cnt = list.size();
				for(int i=0; i<cnt; i++){
					CstSkdByVvdVO rtnVO = list.get(i);
					if("Y".equals(rtnVO.getTurnPortFlg())){
						VvdVO vvdVO = new VvdVO();
						vvdVO.setVslCd(rtnVO.getVslCd());
						vvdVO.setSkdVoyNo(rtnVO.getTurnSkdVoyNo());
						vvdVO.setSkdDirCd(rtnVO.getTurnSkdDirCd());

						int chkCnt = command.checkVvdApplyBooking(vvdVO);
						if(chkCnt > 0){
							/*
							 * MSG - 이미 Book시스템 해당 VVD를 사용하고 있습니다. Coastal Simulation 화면을 사용해 주세요.
							 */
//							throw new EventException(new ErrorHandler("VSK10029").getMessage());
							bookChk = "X";
						}

						break;
					}
				}
				// ************** Turnning Port 의 Booking 정보 확인 END **************
			}


			//0057일 경우 Feeder 만 조회 가능하도록.
			if(e instanceof VopVsk0057Event){
				MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
				mdmVslSvcLaneVO.setVslSlanCd(list.get(0).getVslSlanCd());
				List<MdmVslSvcLaneVO> chkList = codeCommand.checkSvcLane(mdmVslSvcLaneVO);

				if(chkList != null && chkList.size() > 0){
					MdmVslSvcLaneVO chkSvcTpVO 	= chkList.get(0);
					String 			svcTpCd 	= chkSvcTpVO.getVslSvcTpCd();
					
					if(svcTpCd == null || "".equals(svcTpCd)){
					/*
					 * MSG - 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
					 */
					throw new EventException(new ErrorHandler("VSK10023").getMessage());
					}else if(!"O".equals(svcTpCd)){
						String vvd = list.get(0).getVslCd() + list.get(0).getSkdVoyNo() + list.get(0).getSkdDirCd();
					/*
					 * MSG - 입력한 [$s]은 Trunk Schedule 입니다. Feeder Schedule를 입력해 주세요
					 */
						throw new EventException(new ErrorHandler("VSK10033", new String[]{vvd}).getMessage());
					}					
					
					//::2007816:2014-03-27:://
					//if(svcTpCd == null || "".equals(svcTpCd)){
						/*
						 * MSG - 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
						 */
					//	throw new EventException(new ErrorHandler("VSK10023").getMessage());
					//}else if(!"O".equals(svcTpCd)){
					//	String vvd = list.get(0).getVslCd() + list.get(0).getSkdVoyNo() + list.get(0).getSkdDirCd();
						/*
						 * MSG - 입력한 [$s]은 Trunk Schedule 입니다. Feeder Schedule를 입력해 주세요
						 */
					//	throw new EventException(new ErrorHandler("VSK10033", new String[]{vvd}).getMessage());
					//}
					//::2007816:2014-03-27:://
					//////////////////////////
					
				}else{
					/*
					 * MSG - 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
					 */
					throw new EventException(new ErrorHandler("VSK10023").getMessage());
				}
			}


			StringBuilder sb = new StringBuilder();

			CstSkdByVvdVO vo = list.get(0);
			vslSlanCd = vo.getVslSlanCd();
			pfSkdTpCd = vo.getPfSkdTpCd();
			skdRmk = vo.getSkdRmk();

			sb.append(vo.getTmlCd());
			for (int i = 1; i < list.size(); i++) {
				sb.append("|");
				sb.append(list.get(i).getTmlCd());
			}

			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();

			pfLaneTypeVO.setVslSlanCd(vslSlanCd);
			pfLaneTypeVOList = codeCommand.searchPfLaneTypeList(pfLaneTypeVO);

			if(pfLaneTypeVOList != null && pfLaneTypeVOList.size() > 0){
				sb2.append(pfLaneTypeVOList.get(0).getPfSvcTpCd());
				sb3.append(pfLaneTypeVOList.get(0).getSlanStndFlg());

				vslSvcTpCd = pfLaneTypeVOList.get(0).getVslSvcTpCd();

				for (int i = 1; i < pfLaneTypeVOList.size(); i++) {
					sb2.append("|");
					sb2.append(pfLaneTypeVOList.get(i).getPfSvcTpCd());

					sb3.append("|");
					sb3.append(pfLaneTypeVOList.get(i).getSlanStndFlg());
				}
			}

			eventResponse.setETCData("booking_chk", bookChk);
			eventResponse.setETCData("tml_cd", sb.toString());
			eventResponse.setETCData("vsl_slan_cd", vslSlanCd);
			eventResponse.setETCData("pf_skd_tp_cd", pfSkdTpCd);
			eventResponse.setETCData("vsl_svc_tp_cd", vslSvcTpCd);
			eventResponse.setETCData("skd_rmk", skdRmk.trim());
			eventResponse.setETCData("pf_svc_type_list", sb2.toString());
			eventResponse.setETCData("slan_stnd_flag_list", sb3.toString());
			eventResponse.setETCData("slan_stnd_flag_list", sb3.toString());
			eventResponse.setETCData("call_ind_cd", VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
			eventResponse.setETCData("call_ind_nm", VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));
		}

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0014, VOP_VSK_0015, VOP_VSK_0057, VOP_VSK_0058, VOP_VSK_0017 : Yard Code Focus<br>
	 * 입력 받은 Port[Location] Code에 대한 등록된 Yard 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardListByPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<YardVO> list = null;
		YardVO yardVO = null;

		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0001Event){
			VopVsk0001Event event = (VopVsk0001Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0003Event){
			VopVsk0003Event event = (VopVsk0003Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0053Event){
			VopVsk0053Event event = (VopVsk0053Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0058Event){
			VopVsk0058Event event = (VopVsk0058Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0017Event){
			VopVsk0017Event event = (VopVsk0017Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0066Event){
			VopVsk0066Event event = (VopVsk0066Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0215Event){
			VopVsk0215Event event = (VopVsk0215Event)e;
			yardVO = event.getYardVO();
		}

		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		String chkPort = null;
		
		if (yardVO != null) {
			chkPort = command.checkPort(yardVO.getLocCd());
		}

		if(chkPort != null && !"".equals(chkPort)){
			list = command.searchYardListByPort(yardVO);

			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			if(list != null && list.size() > 0){
				if(e instanceof VopVsk0001Event || e instanceof VopVsk0003Event ||e instanceof VopVsk0053Event){
					sb.append(" ");
					sb1.append(" ");
					sb2.append(" ");
					for (int i = 0; i < list.size(); i++) {
						sb.append("|");
						sb1.append("|");
						sb2.append("|");
						sb.append(list.get(i).getYdKind());
						sb1.append(list.get(i).getYdCd());
						sb2.append(list.get(i).getYdNm());
					}
				}else{
					sb.append(list.get(0).getYdKind());
					sb1.append(list.get(0).getYdCd());
					sb2.append(list.get(0).getYdNm());
					for (int i = 1; i < list.size(); i++) {
						sb.append("|");
						sb1.append("|");
						sb2.append("|");
						sb.append(list.get(i).getYdKind());
						sb1.append(list.get(i).getYdCd());
						sb2.append(list.get(i).getYdNm());
					}
				}
			}

			eventResponse.setETCData("yd_kind", sb.toString());
			eventResponse.setETCData("yd_cd", sb1.toString());
			eventResponse.setETCData("yd_nm", sb2.toString());
		}else{
			eventResponse.setETCData("yd_kind", "");
			eventResponse.setETCData("yd_cd", "");
			eventResponse.setETCData("yd_nm", "");
		}

		eventResponse.setETCData("check_port", chkPort);
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0248 : Open
	 *
	 * P/F SKD History Data를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfSkdHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0248Event event = (VopVsk0248Event)e;
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		PfSkdHisGRPVO grpVO = command.searchPfSkdHis(event.getVskPfSkdHisVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<VskPfSkdHisVO> vskPfSkdHisVOs = grpVO.getVskPfSkdHisVOs();
		List<VskVslSkdVO> vskVslSkdVOs = grpVO.getVskVslSkdVOs();


		eventResponse.setRsVoList(vskPfSkdHisVOs);
		eventResponse.setRsVoList(vskVslSkdVOs);
		return eventResponse;
	}

	/**
	 * VOP_VSK_0014, VOP_VSK_0057 : Vsl Slan Cd Button Click<br>
	 * 입력 받은 Lane Code로 생성된 PF SKD Type 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfLaneTypeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PfLaneTypeVO pfLaneTypeVO = null;

		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			pfLaneTypeVO = event.getPfLaneTypeVO();
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			pfLaneTypeVO = event.getPfLaneTypeVO();
		}
//		else if(e instanceof VopVsk0251Event){
//			VopVsk0251Event event = (VopVsk0251Event)e;
//			pfLaneTypeVO = event.getPfLaneTypeVO();
//		}
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();

		MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
		if (pfLaneTypeVO != null) {
			mdmVslSvcLaneVO.setVslSlanCd(pfLaneTypeVO.getVslSlanCd());
		}
		List<MdmVslSvcLaneVO> chkList = command.checkSvcLane(mdmVslSvcLaneVO);

		if(chkList != null && chkList.size() > 0){
			//0057일 경우 Feeder 만 조회 가능하도록.
			MdmVslSvcLaneVO chkSvcTpVO = chkList.get(0);
			String svcTpCd = chkSvcTpVO.getVslSvcTpCd();

			if(e instanceof VopVsk0057Event){
				
				if(svcTpCd == null || "".equals(svcTpCd)){
					/*
					 * MSG - 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
					 */
					throw new EventException(new ErrorHandler("VSK10023").getMessage());
				}else if(!"O".equals(svcTpCd)){
					/*
					 * MSG - Trunk Service Lane Code을 입력하셨습니다. Feeder Service Lane Code를 입력해 주세요.
					 */
					throw new EventException(new ErrorHandler("VSK10049").getMessage());
				}
				
				
				//::2007816:2014-03-27:://
				//if(svcTpCd == null || "".equals(svcTpCd)){
					/*
					 * MSG - 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
					 */
				//	throw new EventException(new ErrorHandler("VSK10023").getMessage());
				//}else if(!"O".equals(svcTpCd)){
					/*
					 * MSG - Trunk Service Lane Code을 입력하셨습니다. Feeder Service Lane Code를 입력해 주세요.
					 */
				//	throw new EventException(new ErrorHandler("VSK10049").getMessage());
				//}
				/////////////////////////
				
			}

			eventResponse.setETCData("svc_tp_cd", svcTpCd);
		}else{
			/*
			 * MSG - Service Lane Code가 등록되여 있지 않을 경우에 표시.
			 */
			throw new EventException(new ErrorHandler("VSK10019").getMessage());
		}

		List<PfLaneTypeVO> list = command.searchPfLaneTypeList(pfLaneTypeVO);

		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();

		if(list != null && list.size() > 0){
			sb2.append(list.get(0).getPfSvcTpCd());
			sb3.append(list.get(0).getSlanStndFlg());

			for (int i = 1; i < list.size(); i++) {
				sb2.append("|");
				sb2.append(list.get(i).getPfSvcTpCd());

				sb3.append("|");
				sb3.append(list.get(i).getSlanStndFlg());
			}
		}

		eventResponse.setETCData("pf_svc_type_list", sb2.toString());
		eventResponse.setETCData("slan_stnd_flag_list", sb3.toString());
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0014, VOP_VSK_0057 : VVD Search Button Click<br>
	 * 입력받은 Proforma Schedule에 Service Lane Code, Type, Direction, Port을 이용하여 Coastal Schedule를 작성하기 위해 ETA, ETB, ETD을 반환한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByPfSkdUse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CstSkdByVvdVO paramVO = null;

		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			paramVO = event.getCstSkdByVvdVO();
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getCstSkdByVvdVO();
		}

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();

		List<CstSkdByVvdVO> list = command.searchCstSkdByPfSkdUse(paramVO);

		PfLaneTypeVO pfLaneTypeVO = new PfLaneTypeVO();
		if (paramVO != null) {
			pfLaneTypeVO.setVslSlanCd(paramVO.getVslSlanCd());
		}
		List<PfLaneTypeVO> pfLaneTypeVOList = codeCommand.searchPfLaneTypeList(pfLaneTypeVO);

		String vslSvcTpCd = null;
		if (paramVO != null) {
			vslSvcTpCd = getVslSvcTpCd(paramVO.getVslSlanCd());
		}
		
		eventResponse.setETCData("vsl_svc_tp_cd", vslSvcTpCd);

		if(list != null && list.size()>0){
			StringBuilder sb = new StringBuilder();

			sb.append(list.get(0).getTmlCd());

			for (int i = 1; i < list.size(); i++) {
				sb.append("|");
				sb.append(list.get(i).getTmlCd());
			}

			eventResponse.setETCData("tml_cd", sb.toString());
		}

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		if(pfLaneTypeVOList != null && pfLaneTypeVOList.size()>0){
			if(pfLaneTypeVOList != null && pfLaneTypeVOList.size() > 0){
				sb.append(pfLaneTypeVOList.get(0).getPfSvcTpCd());
				sb2.append(pfLaneTypeVOList.get(0).getSlanStndFlg());

				for (int i = 1; i < pfLaneTypeVOList.size(); i++) {
					sb.append("|");
					sb2.append("|");
					sb.append(pfLaneTypeVOList.get(i).getPfSvcTpCd());
					sb2.append(pfLaneTypeVOList.get(i).getSlanStndFlg());
				}
			}
		}
		eventResponse.setETCData("pf_svc_type_list", sb.toString());
		eventResponse.setETCData("slan_stnd_flag_list", sb2.toString());
		eventResponse.setETCData("call_ind_cd", VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
		eventResponse.setETCData("call_ind_nm", VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0015, VOP_VSK_0058 : Phase Out Cancel Button Click<br>
	 * 입력받은 Proforma Schedule에 Service Lane Code, Type, Direction, Port을 이용하여 Coastal Schedule를 작성하기 위해 ETA, ETB, ETD을 반환한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByPfSkdSim(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SwapCstSkdSimVO paramVO = new SwapCstSkdSimVO();

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			SwapCstSkdSimVO[] swapCstSkdSimVOs = event.getSwapCstSkdSimVOs();

			if(swapCstSkdSimVOs != null){
				int pIdx = 0;
				int voSize = swapCstSkdSimVOs.length;
				for(int i=0; i<voSize; i++){
					if("O".equals(swapCstSkdSimVOs[i].getSkdCngStsCd())){
						pIdx = i;
						break;
					}
				}

				paramVO.setVslCd(swapCstSkdSimVOs[pIdx].getVslCd());
				paramVO.setSkdVoyNo(swapCstSkdSimVOs[pIdx].getSkdVoyNo());
				paramVO.setSkdDirCd(swapCstSkdSimVOs[pIdx].getSkdDirCd());
				paramVO.setPfEtbDt(swapCstSkdSimVOs[pIdx].getPfEtbDt());
				paramVO.setVpsEtdDt(swapCstSkdSimVOs[pIdx].getVpsEtdDt());
				paramVO.setVslSlanCd(swapCstSkdSimVOs[pIdx].getVslSlanCd());
				paramVO.setPfSvcTpCd(swapCstSkdSimVOs[pIdx].getPfSvcTpCd());
				paramVO.setPfSkdTpCd(swapCstSkdSimVOs[pIdx].getPfSkdTpCd());
				paramVO.setVpsPortCd(swapCstSkdSimVOs[pIdx].getVpsPortCd());
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				log.debug(paramVO.getVslCd());
				log.debug(paramVO.getSkdVoyNo());
				log.debug(paramVO.getSkdDirCd());
				log.debug(paramVO.getPfEtbDt());
				log.debug(paramVO.getVpsEtdDt());
				log.debug(paramVO.getVslSlanCd());
				log.debug(paramVO.getPfSvcTpCd());
				log.debug(paramVO.getPfSkdTpCd());
				log.debug(paramVO.getVpsPortCd());
				log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}
		}

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();

		List<SwapCstSkdSimVO> list = command.searchCstSkdByPfSkdSim(paramVO);

		PfLaneTypeVO pfLaneTypeVO = new PfLaneTypeVO();
		pfLaneTypeVO.setVslSlanCd(paramVO.getVslSlanCd());
		List<PfLaneTypeVO> pfLaneTypeVOList = codeCommand.searchPfLaneTypeList(pfLaneTypeVO);

		eventResponse.setETCData("vsl_svc_tp_cd", getVslSvcTpCd(paramVO.getVslSlanCd()));

		if(list != null && list.size()>0){
			StringBuilder sb = new StringBuilder();

			sb.append(list.get(0).getTmlCd());

			for (int i = 1; i < list.size(); i++) {
				sb.append("|");
				sb.append(list.get(i).getTmlCd());
			}

			eventResponse.setETCData("tml_cd", sb.toString());
		}

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		if(pfLaneTypeVOList != null && pfLaneTypeVOList.size()>0){
			if(pfLaneTypeVOList != null && pfLaneTypeVOList.size() > 0){
				sb.append(pfLaneTypeVOList.get(0).getPfSvcTpCd());
				sb2.append(pfLaneTypeVOList.get(0).getSlanStndFlg());

				for (int i = 1; i < pfLaneTypeVOList.size(); i++) {
					sb.append("|");
					sb2.append("|");
					sb.append(pfLaneTypeVOList.get(i).getPfSvcTpCd());
					sb2.append(pfLaneTypeVOList.get(i).getSlanStndFlg());
				}
			}
		}
		eventResponse.setETCData("pf_svc_type_list", sb.toString());
		eventResponse.setETCData("slan_stnd_flag_list", sb2.toString());
		eventResponse.setETCData("call_ind_cd", VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
		eventResponse.setETCData("call_ind_nm", VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	private String getVslSvcTpCd(String vslSlanCd) throws EventException{
		String vslSvcTpCd = "";

		PfLaneTypeVO pfLaneTypeVO = new PfLaneTypeVO();
		pfLaneTypeVO.setVslSlanCd(vslSlanCd);

		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();
		List<PfLaneTypeVO> pfLaneTypeVOList = codeCommand.searchPfLaneTypeList(pfLaneTypeVO);

		if(pfLaneTypeVOList != null && pfLaneTypeVOList.size() > 0){
			vslSvcTpCd = pfLaneTypeVOList.get(0).getVslSvcTpCd();
		}

		return vslSvcTpCd;
	}

	/**
	 * VOP_VSK_0014, VOP_VSK_0015, VOP_VSK_0017, VOP_VSK_0057 : Open<br>
	 * Direction 정보를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDirectionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setETCData("direction_cd", VSKGeneralUtil.comnCodeList("CD00593", "onlycode"));
		return eventResponse;
	}

	/**
	 * VOP_VSK_0017 : Group Combo Change<br>
	 * User Lane Group 을 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserLaneGroup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();

		List<UserLaneGroupVO> list = command.searchLaneGrpByUsrId(account.getUsr_id());

		StringBuilder sb = new StringBuilder();
		if(list != null && list.size() > 0){
			sb.append(list.get(0).getLaneGrpNm());
			for (int i=1; i<list.size(); i++) {
				sb.append("|");
				sb.append(list.get(i).getLaneGrpNm());
			}
		}

		eventResponse.setETCData("usr_lane_grp", sb.toString());
		return eventResponse;
	}

	/**
	 * VOP_VSK_0238 : Open
	 *
	 * P/F SKD Simulation  기항지별  Berth window 정보를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfSkdBerthWdo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0238Event event = (VopVsk0238Event)e;
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		List<PfSkdBerthWdoVO> list = command.searchPfSkdBerthWdo(event.getVskPfSkdDtlVOs());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	private EventResponse checkBkgStsByVvd(Event e) throws EventException {
		VopVsk0211Event event = (VopVsk0211Event)e;

		SimulationVvdCheckVO simulationVvdCheckVO = event.getSimulationVvdCheckVO();
		LongRangeScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		List<VvdBkgStsVO> list = command.checkBkgStsByVvd(simulationVvdCheckVO);

		boolean bkgStatus = false;
		boolean virBkgStatus = false;
		boolean ruseProhiFlg = false;

		for(VvdBkgStsVO vvdBkgStsVO: list){
			if("Booking".equals(vvdBkgStsVO.getBkgStatus())){
				bkgStatus = true;
			}
			if("BKG".equals(vvdBkgStsVO.getVirBkgStatus()) || "BKGNOD".equals(vvdBkgStsVO.getVirBkgStatus())){
				virBkgStatus = true;
			}
			if("Y".equals(vvdBkgStsVO.getRuseProhiFlg())){
				ruseProhiFlg = true;
			}
		}

		StringBuilder remark = new StringBuilder("");
		if(bkgStatus){
			//remark.append("Booking 상태를 가지는 VVD가 존재합니다.");
			remark.append("Booking data already exists on Creating VVD and User have to record delete history.");
		}
		if(virBkgStatus){
			if(remark.length()>0){
				remark.append("\n");
			}
			//remark.append("Virtual Port가 Booking 상태인 VVD가 존재합니다.");
			remark.append("Booking data already exists on Virtual calling port  and User have to record delete history.");
		}
		if(ruseProhiFlg){
			if(remark.length()>0){
				remark.append("\n");
			}
			//remark.append("재무 VVD에 등록된 VVD가 존재합니다.");
			remark.append("VVD of creating LRS already exists on financial system and can’t create vessel SKD.");
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("remark", remark.toString());
		return eventResponse;
	}

	/**
	 * VOP_VSK_0014, VOP_VSK_0057, VOP_VSK_0015, VOP_VSK_0058 : Save<br>
	 * 입력받은 Vessel Port Schedule 정보를 등록 및 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageCstSkdByVvd(Event e) throws EventException {

		//::2007816::2014-04-12:://private EventResponse manageCstSkdByVvd(Event e) throws EventException {
//		log.error("\n\n.....manageCstSkdByVvd   SCSCSCSCSCSCSCSC.....................");
		GeneralEventResponse 	eventResponse 			= new GeneralEventResponse();
		CstSkdByVvdVO 			paramVO 				= null;
		CstSkdByVvdVO[] 		paramVOs 				= null;
		SwapCstSkdSimVO 		swapCstSkdSimVO 		= null;
		SwapCstSkdSimVO[] 		swapCstSkdSimVOs 		= null;
//		VskVslSkdPhsIoHisVO 	vskVslSkdPhsIoHisVO 	= null;
		VskVslSkdPhsIoHisVO[] 	vskVslSkdPhsIoHisVOs 	= null;

		String					sFromEventSystem		= "";
		String					sCvntFromEventSystem	= "";
		
		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event 	= (VopVsk0014Event)e;
			paramVO 				= event.getCstSkdByVvdVO();
			paramVOs 				= event.getCstSkdByVvdVOS();

			sFromEventSystem	= "VOP_VSK_0014";
			
			if(paramVO != null && paramVOs != null){
				if(paramVOs.length > 0){
					for(int i=0; i<paramVOs.length; i++){
						paramVOs[i].setVslSlanCd(paramVO.getVslSlanCd());
						paramVOs[i].setSlanCd(paramVO.getVslSlanCd());
						paramVOs[i].setPfSvcTpCd(paramVO.getPfSvcTpCd());
						paramVOs[i].setSkdRmk(paramVO.getSkdRmk());
					}
				}
			}
			
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getCstSkdByVvdVO();
			paramVOs = event.getCstSkdByVvdVOS();

			sFromEventSystem	= "VOP_VSK_0057";
			
			if(paramVO != null && paramVOs != null){
				if(paramVOs.length > 0){
					for(int i=0; i<paramVOs.length; i++){
						paramVOs[i].setVslSlanCd(paramVO.getVslSlanCd());
						paramVOs[i].setSlanCd(paramVO.getVslSlanCd());
						paramVOs[i].setPfSvcTpCd(paramVO.getPfSvcTpCd());
						paramVOs[i].setSkdRmk(paramVO.getSkdRmk());
					}
				}
			}
			
		}else if(e instanceof VopVsk0015Event){
			VopVsk0015Event event 	= (VopVsk0015Event)e;
			swapCstSkdSimVO 		= event.getSwapCstSkdSimVO();
			swapCstSkdSimVOs 		= event.getSwapCstSkdSimVOs();
//			vskVslSkdPhsIoHisVO		= event.getVskVslSkdPhsIoHisVO();
			vskVslSkdPhsIoHisVOs	= event.getVskVslSkdPhsIoHisVOs();
			
			sFromEventSystem	= "VOP_VSK_0015";
			
			if(swapCstSkdSimVOs != null){
				int len 	= swapCstSkdSimVOs.length;
				paramVOs 	= new CstSkdByVvdVO[len];

				for(int i=0; i<len; i++){
					paramVOs[i] = new CstSkdByVvdVO();
					ObjectCloner.build(swapCstSkdSimVOs[i], paramVOs[i]);
				}
			}
			
		}else if(e instanceof VopVsk0058Event){
			VopVsk0058Event event = (VopVsk0058Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			swapCstSkdSimVOs = event.getSwapCstSkdSimVOs();
			

			sFromEventSystem	= "VOP_VSK_0058";
			
			paramVOs = new CstSkdByVvdVO[swapCstSkdSimVOs.length];

			for(int i=0; i<swapCstSkdSimVOs.length; i++){
				paramVOs[i] = new CstSkdByVvdVO();

				ObjectCloner.build(swapCstSkdSimVOs[i], paramVOs[i]);

				paramVOs[i].setVslSlanCd(swapCstSkdSimVO.getVslSlanCd());
				paramVOs[i].setSlanCd(swapCstSkdSimVO.getVslSlanCd());
				paramVOs[i].setSkdRmk(swapCstSkdSimVO.getSkdRmk());
			}
			
		}else if(e instanceof VopVskSPPVSK0005Event){
			VopVskSPPVSK0005Event event = (VopVskSPPVSK0005Event)e;
			paramVOs = event.getCstSkdByVvdVOs();
			
			sFromEventSystem	= "VOP_VSK_SPP_VSK_0005";
			
		//::2007816::2014-04-12:://
		}else if(e instanceof UbizhjsAlpsvskSkdAllianceEvent){
			UbizhjsAlpsvskSkdAllianceEvent event = (UbizhjsAlpsvskSkdAllianceEvent)e;
			paramVOs = event.getCstSkdByVvdVOs();
			
			sFromEventSystem	= "EDI_XCH_AUTO_MAPPING";
			sCvntFromEventSystem= "EDI_XCH_AUTO_MAPPING";
		}

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		try{
			
//			log.info("\n\n ::============= scscsc::jsk::scscsc tr started!!! ====================== ::");
//			log.error("\n\n 2014 06....LOG FOR LIVE...................................................");
//			log.error("\n\n 2014 06....LOG FOR LIVE...................................................");
//			log.error("\n\n 2014 06....LOG FOR LIVE...................................................");
			
			begin();

			VvdVO vvdVO = new VvdVO();
			if(paramVO != null){
				vvdVO.setVslCd		(paramVO.getVslCd	());
				vvdVO.setSkdVoyNo	(paramVO.getSkdVoyNo());
				vvdVO.setSkdDirCd	(paramVO.getSkdDirCd());
			}else if(swapCstSkdSimVO != null){
				vvdVO.setVslCd		(swapCstSkdSimVO.getVslCd	());
				vvdVO.setSkdVoyNo	(swapCstSkdSimVO.getSkdVoyNo());
				vvdVO.setSkdDirCd	(swapCstSkdSimVO.getSkdDirCd());
			}
//			log.error("\n\n...................................................");
 			
//			log.error("\n vvdVO.getVslCd() ::"+vvdVO.getVslCd	());
//			log.error("\n vvdVO.getSkdVoyNo() ::"+vvdVO.getSkdVoyNo	());
//			log.error("\n vvdVO.getSkdDirCd() ::"+vvdVO.getSkdDirCd	());
//			
//			log.error("\n\n...................................................");
			String chkStr = command.checkReuseVvd(vvdVO);
			if("Y".equals(chkStr)){
				/*
				 * MSG - 2008년 이전 이행 VVD중에 재무 VVD로 사용하고 있을 경우.
				 */
				throw new EventException(new ErrorHandler("VSK10002").getMessage());
			}

//			log.info("\n\n################### account ["+account+"] :: sCvntFromEventSystem ["+sCvntFromEventSystem+"]###################");
			
/*			if(account == null){
				
				log.info("\n\n################### account manual allocation start ###################");
				
				account	= this.getSignOnUserAccount();
				
				log.info("\n\n################### account manual allocation end ###################");

			}*/
			
			//log.info("\n\n################### account.getUsr_id ["+account.getUsr_id()+"]###################");

			
			VslSkdChgStsGRPVO vslSkdChgStsGRPVO = command.manageCstSkdByVvd(paramVOs, account);
//			log.error("\n\n...................................................");
//			log.error("\n vslSkdChgStsGRPVO.getEdiVvdVOs() ::"+vslSkdChgStsGRPVO.getEdiVvdVOs());
			
//			List<VvdVO> tmp_vvdVOs = vslSkdChgStsGRPVO.getEdiVvdVOs();
//			if(tmp_vvdVOs != null && tmp_vvdVOs.size() > 0){
//				for(int i=0; i<tmp_vvdVOs.size(); i++){

//					VvdVO tmp_vvdVO = new VvdVO();
//					tmp_vvdVO = tmp_vvdVOs.get(i);
//					log.error("\n tmp_vvdVOs ::"+tmp_vvdVO.getVslCd());
//					log.error("\n tmp_vvdVOs ::"+tmp_vvdVO.getSkdVoyNo());
//					log.error("\n tmp_vvdVOs ::"+tmp_vvdVO.getSkdDirCd());
					
//				}
//			} 
//			log.error("\n\n...................................................");
			//Booking 에 변경된 스케줄 전송. + Booking BKG.POD.ETA Delay NOTICE 전송.
			//sendBkgByVslSkdChg(vslSkdChgStsGRPVO);                        //2013-12-05 :: LYJLYJ :: TRANSACTION TIME으로 인한  OLD ETD이 BDR에 적용으로  COMMIT이후로 이동//

			//COP 에 변경된 스케줄 전송.
			sendCopByVslSkdChg(vslSkdChgStsGRPVO);

			//EDI 전송
			if(vslSkdChgStsGRPVO.getEdiVvdVOs() != null && vslSkdChgStsGRPVO.getEdiVvdVOs().size() > 0){
				command.sendEdiToDLS(vslSkdChgStsGRPVO.getEdiVvdVOs());
			}
//			log.error("\n\n...................................................");
//			log.error("\n\n.........EDI SEND.AFTER............................");
//			log.error("\n\n...................................................");
//			log.error("\n\n...................................................");
			//ERP 전송
			if(vslSkdChgStsGRPVO.getErpVvdVOs() != null && vslSkdChgStsGRPVO.getErpVvdVOs().size() > 0){
				for(VvdVO vo : vslSkdChgStsGRPVO.getErpVvdVOs()){
					if(account == null){
						vo.setCreUsrId(paramVOs[0].getUpdUsrId());
						vo.setUpdUsrId(paramVOs[0].getUpdUsrId());
					}else{
						vo.setCreUsrId(account.getUsr_id());
						vo.setUpdUsrId(account.getUsr_id());
					}
				}

				////::jskjskjskjskjsk::2013-09-03::////				
				command.sendVslSkdErpIf(vslSkdChgStsGRPVO.getErpVvdVOs());
			}
//			log.error("\n\n...................................................");
//			log.error("\n\n.........ERP SEND.AFTER............................");
//			log.error("\n\n...................................................");
//			log.error("\n\n...................................................");
			//eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			
			//Booking 에 변경된 스케줄 전송. + Booking BKG.POD.ETA Delay NOTICE 전송.
			sendBkgByVslSkdChg(vslSkdChgStsGRPVO);  
			
//			log.info("\n\n ::============= scscsc::jsk::scscsc tr finished!!! ====================== ::");
//			
//			
//			log.error("\n\n...................................................");
//			log.error("\n\n.........BOOKING SEND.AFTER............................");
//			log.error("\n\n...................................................");
//			log.error("\n\n...................................................");
			/* ============================================================================
			 * Vessel Schedule History 관리(Header+Detail) Started ::2013-08-27::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
			 * ============================================================================
			 */
			Map<String, List<VskVslSkdVO>>	hmVskVslSkdVOs			= new HashMap<String, List<VskVslSkdVO>>();
			VslSkdCngHistGroupVO			vslSkdCngHistGroupVO	= new VslSkdCngHistGroupVO();
			hmVskVslSkdVOs											= vslSkdChgStsGRPVO.getHmVskVslSkdVOs();	
			
			if(!hmVskVslSkdVOs.isEmpty()){
				for(int i=0; i<hmVskVslSkdVOs.size(); i++){
					Collection<String>	collection	= hmVskVslSkdVOs.keySet();
					Iterator<String>	itrKey		= collection.iterator();
					
					while(itrKey.hasNext()){
						String 				sKey			= (String)itrKey.next();
						List<VskVslSkdVO>	vskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
						vskVslSkdVOs						= hmVskVslSkdVOs.get(sKey);
//						log.error("\n\n...................................................");
//						log.error("\n\n....."+vskVslSkdVOs.get(i).getVslCd());
//						log.error("\n\n....."+vskVslSkdVOs.get(i).getSkdVoyNo());
//						log.error("\n\n....."+vskVslSkdVOs.get(i).getSkdDirCd());
//						log.error("\n\n...................................................");
//						log.error("\n\n...................................................");
						if(			"INSERT_CST_ByVvd_NormalPort"	.equals(sKey)){
							
							if(			"VOP_VSK_0014"			.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_NormalPort(VOP_VSK_0014)";
							}else if(	"VOP_VSK_0015"			.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_NormalPort(VOP_VSK_0015)";
							}else if(	"VOP_VSK_0057"			.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_NormalPort(VOP_VSK_0057)";
							}else if(	"VOP_VSK_0058"			.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_NormalPort(VOP_VSK_0058)";
							}else if(	"VOP_VSK_SPP_VSK_0005"	.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_NormalPort(VOP_VSK_SPP_VSK_0005)";
							}
							
						}else if(	"INSERT_CST_ByVvd_VirtualPort"	.equals(sKey)){
							
							if(			"VOP_VSK_0014"			.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0014)";
							}else if(	"VOP_VSK_0015"			.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0015)";
							}else if(	"VOP_VSK_0057"			.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0057)";
							}else if(	"VOP_VSK_0058"			.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_VirtualPort(VOP_VSK_0058)";
							}else if(	"VOP_VSK_SPP_VSK_0005"	.equals(sFromEventSystem)){
								sCvntFromEventSystem	= "INSERT_CST_ByVvd_VirtualPort(VOP_VSK_SPP_VSK_0005)";
							}
							
						}
						
						command.createVesselScheduleChangeHistory(vskVslSkdVOs, null, sCvntFromEventSystem);		
					}
				}
			}
			
			vslSkdCngHistGroupVO	= vslSkdChgStsGRPVO.getVslSkdCngHistGroupVO();
			
			if("UPDATE_CST_ByVvd"	.equals(vslSkdCngHistGroupVO.getFromEventSystem())){
				
				if(			"VOP_VSK_0014"			.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_CST_ByVvd(VOP_VSK_0014)";
				}else if(	"VOP_VSK_0015"			.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_CST_ByVvd(VOP_VSK_0015)";
				}else if(	"VOP_VSK_0057"			.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_CST_ByVvd(VOP_VSK_0057)";
				}else if(	"VOP_VSK_0058"			.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_CST_ByVvd(VOP_VSK_0058)";
				}else if(	"VOP_VSK_SPP_VSK_0005"	.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_CST_ByVvd(VOP_VSK_SPP_VSK_0005)";
				}
			}

//			log.error("\n\n ::============= scscsc::sCvntFromEventSystem ["+sCvntFromEventSystem+"] =============");
//			
//			log.error("\n\n ::============= scscsc::vslSkdCngHistGroupVO.getVskVslSkdVOs() ["+vslSkdCngHistGroupVO.getVskVslSkdVOs()+"] =============");
//			log.error("\n\n ::============= scscsc::vslSkdCngHistGroupVO.getVslSkdCngHisDtlVOs() ["+vslSkdCngHistGroupVO.getVslSkdCngHisDtlVOs()+"] =============");
			
			command.createVesselScheduleChangeHistory(vslSkdCngHistGroupVO.getVskVslSkdVOs(), vslSkdCngHistGroupVO.getVslSkdCngHisDtlVOs(), sCvntFromEventSystem);		
			
			if(vskVslSkdPhsIoHisVOs != null){
				command.createVslSkdPhaseInOutHistory(vskVslSkdPhsIoHisVOs, account);
			}
			
//			log.info("\n\n ::============= scscsc::jsk::history generation finished ["+sCvntFromEventSystem+"] =============");
				
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
	 * manageCstSkdByVvd, manageCstSkdBerthWdo : Call
	 * Schedule 이 변경되면 Booking 에 해당 내용을 전송한다.
	 *
	 * @param VslSkdChgStsGRPVO vslSkdCngStsGRPVO
	 * @throws EventException
	 */
	private void sendBkgByVslSkdChg(VslSkdChgStsGRPVO vslSkdChgStsGRPVO) throws EventException {
	//::2007816::2014-04-12:://public void sendBkgByVslSkdChg(VslSkdChgStsGRPVO vslSkdChgStsGRPVO) throws EventException {
		
		GeneralBookingSplitCombineBC 	bkgScbCmd 	= new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC 		bkgRctCmd 	= new GeneralBookingReceiptBCImpl();

		log.debug("=================== Booking START ===================");
		List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = vslSkdChgStsGRPVO.getVslSkdCngNoticeVOs();
		if(vslSkdCngNoticeVOs != null && vslSkdCngNoticeVOs.size()>0){
			try{
				log.debug("=================== Booking START <<::bkgScbCmd.sendVslSkdCngNotice::>> ===================");
				//::local-impossible & server enable...jskjskjsk::2013-07-03:://
				bkgScbCmd.sendVslSkdCngNotice		(vslSkdCngNoticeVOs);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10045").getMessage());
			}
		}

		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs = vslSkdChgStsGRPVO.getVslSkdCngUpdateVOs();
		if(vslSkdCngUpdateVOs != null && vslSkdCngUpdateVOs.size()>0){
			try{
				log.debug("=================== Booking START <<::bkgRctCmd.modifyBkgVvdForVslSkdCng::>> ===================");
				//::local-impossible & server enable...jskjskjsk::2013-07-03:://
				bkgRctCmd.modifyBkgVvdForVslSkdCng	(vslSkdCngUpdateVOs, account);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10047").getMessage());
			}
		}
		
		//::VSK to BKG ::BKG.POD.ETA DELAY NOTICE :://
		List<VslSkdCngUpdateVO> vslSkdEtaDelayNoticeVOs = vslSkdChgStsGRPVO.getVslSkdEtaDelayNoticeVOs();
		
		//log.info("\n\n ::jskjskjskjsk:: VO.size() ["+vslSkdEtaDelayNoticeVOs.size()+"]\n");
		//for(VslSkdCngUpdateVO tmpVo:vslSkdEtaDelayNoticeVOs){
		//	log.info("\n\n ::jskjskjskjsk:: ["+tmpVo.getVvd()+tmpVo.getPortCd()+tmpVo.getOldClptIndSeq()+tmpVo.getNewClptIndSeq()+"]\n");
		//}
		
		if(vslSkdEtaDelayNoticeVOs != null && vslSkdEtaDelayNoticeVOs.size()>0){
			try{
				log.debug("=================== Booking START <<::bkgRctCmd.sendVslSkdCngNotice::>> ===================");
				//::local-impossible & server enable...jskjskjsk::2013-07-03:://
				bkgRctCmd.sendVslSkdCngNotice		(vslSkdEtaDelayNoticeVOs, account);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10045").getMessage());
			}
		}		

//		List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = vslSkdChgStsGRPVO.getBkgVvdBdrLogVOs();
//		if(bkgVvdBdrLogVOs != null && bkgVvdBdrLogVOs.size()>0){
//			try{
//				for(BkgVvdBdrLogVO bkgVvdBdrLogVO : bkgVvdBdrLogVOs){
//					bkgPrsCmd.manageBKGBDRLOG(bkgVvdBdrLogVO, account);
//				}
//			}catch(Exception ex){
//				throw new EventException(new ErrorHandler("VSK10014").getMessage());
//			}
//		}

		
		List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = vslSkdChgStsGRPVO.getBkgVvdBdrLogVOs();
		//::local-impossible & server enable...jskjskjsk::2013-07-03:://
		sendBkgVvdBdrLog(bkgVvdBdrLogVOs);

		log.debug("=================== Booking END ===================");
	}
	
	/**
	 * manageCstSkdByVvd, manageCstSkdBerthWdo : Call
	 * Schedule 이 변경되면 COP 에 해당 내용을 전송한다.
	 *
	 * @param vslSkdChgStsGRPVO vslSkdCngStsGRPVO
	 * @throws EventException
	 */
	private void sendCopByVslSkdChg(VslSkdChgStsGRPVO vslSkdChgStsGRPVO) throws EventException {
	//::2007816::2014-04-12:://public void sendCopByVslSkdChg(VslSkdChgStsGRPVO vslSkdChgStsGRPVO) throws EventException {
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();

		log.debug("=================== COP START ===================");
		List<SceActRcvIfVO> sceActRcvIfVOs = vslSkdChgStsGRPVO.getSceActRcvIfVOs();
		if(sceActRcvIfVOs != null && sceActRcvIfVOs.size()>0){
			try{
				log.debug(">>> Notice Size : " + sceActRcvIfVOs.size());
				for(SceActRcvIfVO sceActRcvIfVO : sceActRcvIfVOs){
					//::local-impossible & server enable...jskjskjsk::2013-07-03:://
					command.sendVslSkdSceIf(sceActRcvIfVO);
				}
			}catch(Exception ex){
				/*
				 * MSG - SCE 시스템과 통신 중 에러가 발생했습니다.
				 */
				throw new EventException(new ErrorHandler("VSK10051").getMessage());
			}
		}
		log.debug("=================== COP END ===================");
	}

	/**
	 * VOP_VSK_0014, VOP_VSK_0057 : Save<br>
	 * Remark를 저장합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstSkdByRmk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		CstSkdByVvdVO paramVO = null;

		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			paramVO = event.getCstSkdByVvdVO();
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getCstSkdByVvdVO();
		}

		try{
			begin();
			command.manageCstSkdByRmk(paramVO, account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0015 : Open<br>
	 * 게시판에 스케줄을 올리기 위한 정보.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse initCstSkdSim(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String targetServer = SiteConfigFactory.get("COM.HANJIN.RDEXP.SERVICE_MODE");
		eventResponse.setETCData("target_server", targetServer);

		String gwUrl = "";
		String pBoardID = "{000000000000000000000000000000000145}";

		if("TEST".equals(targetServer)){
			gwUrl = "http://gwdev.smlines.com/myoffice/ezBoardSTD/NewBoardItem.aspx?BoardID=" + pBoardID + "&Mode=new";
		}else{
			gwUrl = "http://gwdev.smlines.com/myoffice/ezBoardSTD/NewBoardItem.aspx?BoardID=" + pBoardID + "&Mode=new";
		}

		String encodeGwUrl = VSKGeneralUtil.encode(gwUrl);

		eventResponse.setETCData("encode_gw_url", encodeGwUrl);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0015, VOP_VSK_0058 : Retrieve<br>
	 * Coastal Simulation 정보를 조회 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSim(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		SwapCstSkdSimVO 		swapCstSkdSimVO = new SwapCstSkdSimVO();

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
		}else if(e instanceof VopVsk0058Event){
			VopVsk0058Event event = (VopVsk0058Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
		}

		try{
			CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
			VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();

			List<SwapCstSkdSimVO> list = command.searchCstSkdSim(swapCstSkdSimVO);

			if(list != null && list.size()>0){
				//0058일 경우 Feeder 만 조회 가능하도록.
				if(e instanceof VopVsk0058Event){
					MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
					mdmVslSvcLaneVO.setVslSlanCd(list.get(0).getVslSlanCd());
					List<MdmVslSvcLaneVO> chkList = codeCommand.checkSvcLane(mdmVslSvcLaneVO);

					if(chkList != null && chkList.size() > 0){
						MdmVslSvcLaneVO chkSvcTpVO = chkList.get(0);
						String svcTpCd = chkSvcTpVO.getVslSvcTpCd();
						if(svcTpCd == null || "".equals(svcTpCd)){
							/*
							 * MSG - 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
							 */
							throw new EventException(new ErrorHandler("VSK10023").getMessage());
						}else if(!"O".equals(svcTpCd)){
							String vvd = list.get(0).getVslCd() + list.get(0).getSkdVoyNo() + list.get(0).getSkdDirCd();
							/*
							 * MSG - 입력한 [$s]은 Trunk Schedule 입니다. Feeder Schedule를 입력해 주세요
							 */
							throw new EventException(new ErrorHandler("VSK10033", new String[]{vvd}).getMessage());
						}
					}else{
						/*
						 * MSG - 입력하신  Proforma Type은 존재하지 않습니다. 다시 확인하세요!
						 */
						throw new EventException(new ErrorHandler("VSK10023").getMessage());
					}
				}

				SwapCstSkdSimVO vo = list.get(0);

				StringBuilder sb = new StringBuilder();
				sb.append(vo.getTmlCd());
				for (int i = 1; i < list.size(); i++) {
					sb.append("|");
					sb.append(list.get(i).getTmlCd());
				}
				eventResponse.setETCData("tml_cd", sb.toString());
				
				if (command.checkVesselLaneLastPort(list.get(list.size()-1))) {
					eventResponse.setETCData("last_port_warn_flg", "Y");
				} else {
					eventResponse.setETCData("last_port_warn_flg", "N");
				}
			}

			VesselVO vslParamVO = new VesselVO();
			vslParamVO.setVslCd(swapCstSkdSimVO.getVslCd());
			List<VesselVO> vslVOList = codeCommand.searchVslList(vslParamVO);

			if(vslVOList != null && vslVOList.size() > 0){
				String vslEngNm = vslVOList.get(0).getVslEngNm();
				String vslKrnNm = vslVOList.get(0).getVslKrnNm();

				eventResponse.setETCData("vsl_eng_nm", vslEngNm);
				eventResponse.setETCData("vsl_krn_nm", vslKrnNm);
			}

			eventResponse.setETCData("dlay_rsn_cd", VSKGeneralUtil.comnCodeList("CD01830", "onlycode"));
			eventResponse.setETCData("dlay_rsn_nm", VSKGeneralUtil.comnCodeList("CD01830", "codeNname"));
			eventResponse.setETCData("chg_sts_cd", VSKGeneralUtil.comnCodeList("CD01825", "onlycode"));
			eventResponse.setETCData("chg_sts_nm", VSKGeneralUtil.comnCodeList("CD01825", "onlyname"));
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}


	/**
	 * VOP_VSK_0249 : Open
	 * VOP_VSK_0012 : Retrieve
	 *
	 * Service Lane 리스트 정보를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneList(Event e) throws EventException {
		MdmVslSvcLaneVO vo = null;
		if(e instanceof VopVsk0249Event){
			VopVsk0249Event event = (VopVsk0249Event)e;
			vo = event.getMdmVslSvcLaneVO();
		}else if(e instanceof VopVsk0012Event){
			VopVsk0012Event event = (VopVsk0012Event)e;
			vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(event.getPortSkdOnLongRangeVO().getVslSlanCd());
		}else if(e instanceof VopVsk0018Event){
			VopVsk0018Event event = (VopVsk0018Event)e;
			vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(event.getActivationVvdVO().getVslSlanCd());
		}else if(e instanceof VopVsk0059Event){
			VopVsk0059Event event = (VopVsk0059Event)e;
			vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(event.getActivationVvdVO().getVslSlanCd());
		}

		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<MdmVslSvcLaneVO> list = command.searchSvcLaneList(vo);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		if(list!=null && list.size()==1){

			if(e instanceof VopVsk0018Event){
				eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
			}else if(e instanceof VopVsk0059Event){
				if(!"O".equals(list.get(0).getVslSvcTpCd())){
					throw new EventException(new ErrorHandler("VSK10049").getMessage());
				}else{
					eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
				}
			}else{
				eventResponse.setETCData("vsl_slan_nm", list.get(0).getVslSlanNm());
			}
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0249 : VVD Input<br>
	 *
	 * VVD 정보를 검증합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVvd(Event e) throws EventException {
		VopVsk0249Event event = (VopVsk0249Event)e;
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<VvdVO> list = command.checkVvd(event.getVvdVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		if(list!=null && list.size()==1){
			VvdVO vo = list.get(0);
			eventResponse.setETCData("vvd", vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd());
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0014, VOP_VSK_0015, VOP_VSK_0019, VOP_VSK_0057, VOP_VSK_0058 : Vessel Code Change<br>
	 * MDM_VSL_CNTR 에 Vessel Code가 존재하는지 확인한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVslCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VvdVO paramVO = null;
		VesselVO vesselVO = null;

		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0058Event){
			VopVsk0058Event event = (VopVsk0058Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0019Event){
			VopVsk0019Event event = (VopVsk0019Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0065Event){
			VopVsk0065Event event = (VopVsk0065Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0021Event){
			VopVsk0021Event event = (VopVsk0021Event)e;
			paramVO = event.getVvdVO();
		}

		int chkCnt = 0;

		if (paramVO != null) {
			if(paramVO.getVslCd() == null){
				log.debug("paramVO.getVslCd() == null");
	//			throw new EventException(new ErrorHandler("VSK10028").getMessage());
			}else{
				vesselVO = new VesselVO();
				vesselVO.setVslCd(paramVO.getVslCd());
				vesselVO.setIncDelVsl(paramVO.getIncDelVsl());
				chkCnt = command.checkVslCntr(vesselVO);
			}
		}

		if(chkCnt > 0){
			eventResponse.setETCData("vsl_chk", "Y");
		}else{
			eventResponse.setETCData("vsl_chk", "N");
			/*
			 * MSG - Vessel Code가 존재하지 않습니다. MDM 시스템에서 Vessel Code를 등록해 주세요.
			 */
			throw new EventException(new ErrorHandler("VSK10028").getMessage());
		}

		return eventResponse;
	}


	/**
	 * VOP_VSK_0014, VOP_VSK_0057 : Direction Code Change<br>
	 * 등록된 LANE CODE, DIRECTION이 있는지 확인한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSvcLaneDir(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		MdmVslSvcLaneDirVO paramVO = null;

		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			paramVO = event.getMdmVslSvcLaneDirVO();
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getMdmVslSvcLaneDirVO();
		}

		int laneCnt = command.checkSvcLaneDir(paramVO);

		if(laneCnt > 0){
			eventResponse.setETCData("lane_chk", "Y");
		}else{
			eventResponse.setETCData("lane_chk", "N");
		}

		return eventResponse;
	}

	/**
	 * VOP_VSK_0249 : Port Input<br>
	 * Port 정보를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortList(Event e) throws EventException {
		LocationVO locationVO = null;
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		if (e instanceof VopVsk0249Event){
			VopVsk0249Event event = (VopVsk0249Event)e;
			locationVO = event.getLocationVO();
		}else if(e instanceof VopVsk0215Event){
			VopVsk0215Event event = (VopVsk0215Event)e;
			locationVO = event.getLocationVO();
		}
		List<LocationVO> list = command.searchPortList(locationVO);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		if(list!=null && list.size()==1){
			eventResponse.setETCData("loc_nm", list.get(0).getLocNm());
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0250 : Open<br>
	 * 해당 Port의 ETA/ETB/ETD 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByVvdPort(Event e) throws EventException {
		VopVsk0250Event event = (VopVsk0250Event)e;
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VslPortSkdVO vo = command.searchCstSkdByVvdPort(event.getVslPortSkdVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		if(vo==null){
			eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Schedule"}).getUserMessage());
		}else{
			eventResponse.setRsVo(vo);
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0017 : Retrieve<br>
	 * Daily Berth Window Updated by Port - 일간 단위로 선박 스케줄을 Updated
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdBerthWdo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CstSkdBerthWdoVO paramVO = null;
		YardVO yardVO = null;

		if(e instanceof VopVsk0017Event){
			VopVsk0017Event event = (VopVsk0017Event)e;
			paramVO = event.getCstSkdBerthWdoVO();
			paramVO.setUsrId(account.getUsr_id());
			yardVO = event.getYardVO();
		}

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		List<CstSkdBerthWdoVO> list = command.searchCstSkdBerthWdo(paramVO);

		// 페이징에 관계없이 전체 건수 표현
		if(list!=null && list.size()>0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}

		//====================================================================
		VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl();
		List<YardVO> yardList = vskCodeFinderBC.searchYardListByPort(yardVO);

		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		if(yardList != null && yardList.size() > 0){
			sb.append(yardList.get(0).getYdKind());
			sb1.append(yardList.get(0).getYdCd());
			sb2.append(yardList.get(0).getYdNm());
			for (int i = 1; i < yardList.size(); i++) {
				sb.append("|");
				sb1.append("|");
				sb2.append("|");
				sb.append(yardList.get(i).getYdKind());
				sb1.append(yardList.get(i).getYdCd());
				sb2.append(yardList.get(i).getYdNm());
			}
		}
		eventResponse.setETCData("yd_kind", sb.toString());
		eventResponse.setETCData("yd_cd", sb1.toString());
		eventResponse.setETCData("yd_nm", sb2.toString());
		//====================================================================

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0017 : Save<br>
	 * 기간별 Por에 기항하는 Coastal 정보, ETA, ETB, ETD, Next ETA등 기타 정보를 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstSkdBerthWdo(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		CoastalScheduleMgtBC 	command 		= new VesselScheduleMgtBCImpl();

		CstSkdBerthWdoVO[] 		paramVOs 		= null;

		if(e instanceof VopVsk0017Event){
			VopVsk0017Event event 	= (VopVsk0017Event)e;
			paramVOs 				= event.getCstSkdBerthWdoVOs();
		}
		 

		try{
			begin();
			
			VslSkdChgStsGRPVO vslSkdChgStsGRPVO = command.manageCstSkdBerthWdo(paramVOs, account);

			//Booking 에 변경된 스케줄 전송.
			//sendBkgByVslSkdChg(vslSkdChgStsGRPVO); //2013-12-05 :: LYJLYJ :: TRANSACTION TIME으로 인한  OLD ETD이 BDR에 적용으로  COMMIT이후로 이동//

			//COP 에 변경된 스케줄 전송.
			sendCopByVslSkdChg(vslSkdChgStsGRPVO);

			//ERP 전송
			if(vslSkdChgStsGRPVO.getErpVvdVOs() != null && vslSkdChgStsGRPVO.getErpVvdVOs().size() > 0){
				for(VvdVO vo : vslSkdChgStsGRPVO.getErpVvdVOs()){
					if(account == null){
						vo.setCreUsrId(paramVOs[0].getUpdUsrId());
						vo.setUpdUsrId(paramVOs[0].getUpdUsrId());
					}else{
						vo.setCreUsrId(account.getUsr_id());
						vo.setUpdUsrId(account.getUsr_id());
					}
				}
				command.sendVslSkdErpIf(vslSkdChgStsGRPVO.getErpVvdVOs());
			}

			String msgOkCnt = vslSkdChgStsGRPVO.getOkCnt();
			String msgFailCnt = vslSkdChgStsGRPVO.getFailCnt();
			
			List<String> failPortInfos = vslSkdChgStsGRPVO.getFailPortInfos();
			List<String> reversedPortInfos = vslSkdChgStsGRPVO.getReversedPortInfos();

			String msgFailPortInfo 		= " ";
			String msgReversedPortInfo 	= "";
			
			//::Adding:2014-05-08:://
			StringBuffer sbMsgFailPortInfo		= new StringBuffer();
			//StringBuffer sbMsgReversedPortInfo	= new StringBuffer();
			
			
			if(failPortInfos != null && failPortInfos.size() > 0){
				
				msgFailPortInfo = "\n\nSaved Berth window, except [Fail VVD] : ";
				for(String failPortInfo : failPortInfos){
					//::2014-05-08:://msgFailPortInfo = msgFailPortInfo + "\n"+ failPortInfo;//String.format("%32s", failPortInfo);
					
					sbMsgFailPortInfo.append(msgFailPortInfo);
					sbMsgFailPortInfo.append("\n");
					sbMsgFailPortInfo.append(failPortInfo);
					
				}
			}
			
			if(reversedPortInfos != null && reversedPortInfos.size() > 0){
				msgReversedPortInfo = "\n\nSaved Berth window, except [Reversed VVD] : ";
				for(String reversedPortInfo : reversedPortInfos){
					sbMsgFailPortInfo.append(msgReversedPortInfo);
					sbMsgFailPortInfo.append("\n");
					sbMsgFailPortInfo.append(reversedPortInfo);
				}
			}

			//::2014-05-08:://String[] msgs = new String[]{msgOkCnt, msgFailCnt, msgFailPortInfo};
			String[] msgs = new String[]{msgOkCnt, msgFailCnt, sbMsgFailPortInfo.toString()};
//			throw new EventException(new ErrorHandler("VSK10075", errMsgs).getMessage());
			eventResponse.setUserMessage(new ErrorHandler("VSK10078", msgs).getUserMessage());
			
			commit();
			
			//Booking 에 변경된 스케줄 전송. + Booking BKG.POD.ETA Delay NOTICE 전송.
			sendBkgByVslSkdChg(vslSkdChgStsGRPVO); 
			
			/* ============================================================================
			 * Vessel Schedule History 관리(Header+Detail) Started ::2013-08-27::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
			 * ============================================================================
			 */
			command.createVesselScheduleChangeHistory(vslSkdChgStsGRPVO.getVskVslSkdVOs(), null, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	

		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0017 : Send EDI<br>
	 * EDI 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEdiToKlNet(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CoastalScheduleMgtBC 	command 			= new VesselScheduleMgtBCImpl();
		CstSkdBerthWdoVO[] 		cstSkdBerthWdoVOs 	= null;

		if(e instanceof VopVsk0017Event){
			VopVsk0017Event event 	= (VopVsk0017Event)e;
			cstSkdBerthWdoVOs 		= event.getCstSkdBerthWdoVOs();
		}

		try{
			String sResult = command.sendEdiToKlNet(cstSkdBerthWdoVOs, account);
			//String sResult = command.sendEdiToKlNet();

			if("SUCCESS".equals(sResult)){
				/*
				 * EAI 전송 성공.
				 * MSG - EDI 메세지 전송이 성공했습니다.
				 */
				eventResponse.setUserMessage(new ErrorHandler("VSK10052").getUserMessage());
			}else{
				/*
				 * EAI 전송 실패.
				 * MSG - EDI 메세지 전송시 에러가 발생했습니다.
				 */
				eventResponse.setUserMessage(new ErrorHandler("VSK10053").getMessage());
			}
		}catch(EventException ex){
//			rollback();
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다. BA 담당자에게 문의하세요.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}

		return eventResponse;
	}


	/**
	 * VOP_VSK_0001 : Retrieve<br>
	 *  P/F Schedule Simulation 정보를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRqstSimScnr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0001Event event = (VopVsk0001Event)e;
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		PfSkdGRPVO grpVO = command.searchRqstSimScnr(event.getPfSkdRequestVO());

		VskPfSkdVO masterVO = grpVO.getVskPfSkdVO();
		List<VskPfSkdDtlVO> detailVOs  = grpVO.getVskPfSkdDtlVOs();
		//2009 12 30 임창빈 수석 요청
		//L/F,RPB,G.REV,OP 데이타를 조회한다
		CoaSimRsltVO coaSimRsltVO = grpVO.getCoaSimRsltVO();

		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = new StringBuffer();

		if(detailVOs.size() > 0 && detailVOs != null){
			sb.append(detailVOs.get(0).getYdCd());
			for(int i=1; i<detailVOs.size(); i++){
				sb.append("|");
				sb.append(detailVOs.get(i).getYdCd());
			}

			sb2.append(detailVOs.get(0).getTotMaxSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getTotAvgSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getBufSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getTotBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getSeaBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getPortBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getPfSpdRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getBufSpdRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getMinMaxSpd());
 
			//2009 12 30 임창빈 수석 요청
			//L/F,RPB,G.REV,OP 데이타를 조회한다
			if(!"X".equals(coaSimRsltVO.getTot())){
				sb3.append(coaSimRsltVO.getLf());
				sb3.append("|");
				sb3.append(coaSimRsltVO.getRpb());
				sb3.append("|");
				sb3.append(coaSimRsltVO.getRev());
				sb3.append("|");
				sb3.append(coaSimRsltVO.getOp());
			}else{
				sb3.append("");
				sb3.append("|");
				sb3.append("");
				sb3.append("|");
				sb3.append("");
				sb3.append("|");
				sb3.append("");
			}

			eventResponse.setRsVo(masterVO);
			eventResponse.setRsVoList(detailVOs);
			eventResponse.setETCData("ydCd", sb.toString());
			eventResponse.setETCData("etcdt", sb2.toString());
			eventResponse.setETCData("coadt", sb3.toString());
			eventResponse.setETCData("mdm_skd_dir_cd", detailVOs.get(0).getMdmSkdDirCd());
		}else{
			eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"Not Found Simulation NO."}).getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * VOP_VSK_0001, VOP_VSK_0003, VOP_VSK_0053 : M/Calculation<br>
	 * P/F Schedule 을 Manual로 계산합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calPfSkdManual(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PfSkdGRPVO grpVO = null;
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = null;

		try{
			if(e instanceof VopVsk0001Event){
				VopVsk0001Event event = (VopVsk0001Event)e;
				grpVO = event.getPfSkdGRPVO();
				vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
				VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(0);
				vskPfSkdDtlVO.setEventNav("A");
				vskPfSkdDtlVOs.set(0, vskPfSkdDtlVO);
				grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			}else if(e instanceof VopVsk0003Event){
				VopVsk0003Event event = (VopVsk0003Event)e;
				grpVO = event.getPfSkdGRPVO();
				vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
				VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(0);
				vskPfSkdDtlVO.setEventNav("A");
				vskPfSkdDtlVOs.set(0, vskPfSkdDtlVO);
				grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			}else if(e instanceof VopVsk0053Event){
				VopVsk0053Event event = (VopVsk0053Event)e;
				grpVO = event.getPfSkdGRPVO();vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
				VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(0);
				vskPfSkdDtlVO.setEventNav("B");
				vskPfSkdDtlVOs.set(0, vskPfSkdDtlVO);
				grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
			}



			ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
			PfSkdGRPVO pfSkdGRPVO = command.calPfSkdManual(grpVO);

			VskPfSkdVO masterVO = pfSkdGRPVO.getVskPfSkdVO();
			List<VskPfSkdDtlVO> detailVOs  = pfSkdGRPVO.getVskPfSkdDtlVOs();

			StringBuffer sb = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			StringBuffer sb3 = new StringBuffer();

			if(detailVOs.size() > 0 && detailVOs != null){
				sb.append(detailVOs.get(0).getYdCd());
				for(int i=1; i<detailVOs.size(); i++){
					sb.append("|");
					sb.append(detailVOs.get(i).getYdCd());
				}

				sb2.append(detailVOs.get(0).getTotMaxSpd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getTotAvgSpd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getBufSpd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getTotBufRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getSeaBufRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getPortBufRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getPfSpdRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getBufSpdRat());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getMinMaxSpd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getVslSvcTpCd());
				sb2.append("|");
				sb2.append(detailVOs.get(0).getCheckVslSkd());
				

				sb3.append(detailVOs.get(0).getCurrPos());
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setRsVo(masterVO);
			eventResponse.setRsVoList(detailVOs);
			eventResponse.setETCData("ydCd", sb.toString());
			eventResponse.setETCData("etcdt", sb2.toString());
			eventResponse.setETCData("currPos", sb3.toString());
			eventResponse.setUserMessage(new ErrorHandler("VSK09001").getUserMessage());
			return eventResponse;
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * VOP_VSK_0001, VOP_VSK_0003, VOP_VSK_0053 : Save<br>
	 * P/F Simulation 정보를 생성합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createRqstSimScnrCfm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PfSkdGRPVO grpVO = null;

		//vskPfSkdHisVO.setPfSkdStsCd("E"); 셋팅
		// Settlete : 0001 = A
		// Creation : 0003 = B
		if(e instanceof VopVsk0001Event){
			VopVsk0001Event event = (VopVsk0001Event)e;
			grpVO = event.getPfSkdGRPVO();
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
//			List<VskPfSkdVO> vskPfSkdVOs = grpVO.getVskPfSkdVOs();

			//History를 남기기위해
			vskPfSkdDtlVOs.get(0).setPfSkdStsCd("A");
			vskPfSkdDtlVOs.get(0).setUiEvent("0001");
			//ProformaScheduleMgtBC.confirmSimScnr 메소드에서는
			//0001 -> Settlement
			//0003 -> Save
			//0053 -> Save를  같이 사용하므로
			//0053에서는  UI에서 turn_port_ind_cd,turn_port_flg를 셋팅한다
			//ex) 초기에는 Feeder 전용으로 개발을 했지만(단방향)
			//후에 Trunk 형식으로도 데이타가  저장되므로 (양방향)
			//화면에서 입력한 데이타를 저장해야 함
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
		}else if(e instanceof VopVsk0003Event){
			VopVsk0003Event event = (VopVsk0003Event)e;
			grpVO = event.getPfSkdGRPVO();
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
			vskPfSkdDtlVOs.get(0).setPfSkdStsCd("B");
			vskPfSkdDtlVOs.get(0).setUiEvent("0003");
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
		}else if(e instanceof VopVsk0053Event){
			VopVsk0053Event event = (VopVsk0053Event)e;
			grpVO = event.getPfSkdGRPVO();
			List<VskPfSkdDtlVO> vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
			vskPfSkdDtlVOs.get(0).setUiEvent("0053");
			grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();

		try{
			begin();

			command.confirmSimScnr(grpVO, account);
			//VSK 저장 성공 메시지가 없기에 임시로 대체
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());

			commit();
		}catch(EventException ex){
			rollback();

			throw ex;
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0015 : Save<br>
	 * 입력받은 Recovery Vessel Schedule 정보를 등록 및 변경한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstSkdSim(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SwapCstSkdSimVO swapCstSkdSimVO = null;
		SwapCstSkdSimVO[] swapCstSkdSimVOs = null;

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			swapCstSkdSimVOs = event.getSwapCstSkdSimVOs();

			for(int i=0; i<swapCstSkdSimVOs.length; i++){
				swapCstSkdSimVOs[i].setVslSimTpCd(swapCstSkdSimVO.getVslSimTpCd());
//				swapCstSkdSimVOs[i].setVslSlanCd(swapCstSkdSimVO.getVslSlanCd());
				swapCstSkdSimVOs[i].setDiffRmk(swapCstSkdSimVO.getSkdRmk());
				swapCstSkdSimVOs[i].setSimDt(swapCstSkdSimVO.getSimDt());
				swapCstSkdSimVOs[i].setSimNo(swapCstSkdSimVO.getSimNo());
			}
		}
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		try{
			begin();

			String simCode = command.manageCstSkdSim(swapCstSkdSimVOs, account);

			if(VSKGeneralUtil.isNotNull(simCode)){
				/*
				 * MASSAGE : 저장 작업이 성공했습니다.(VSK10016) - Simulation No.
				 */
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage() + "-" + simCode);
			}else{
				/*
				 * MASSAGE : 저장 작업이 성공했습니다.(VSK10016)
				 */
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0015 : Settlement<br>
	 * Simulation Schedule 을 Coastal Schedule 에 반영한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageSettleByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CstSkdByVvdVO[] paramVOs = null;
		SwapCstSkdSimVO swapCstSkdSimVO = null;
		SwapCstSkdSimVO[] swapCstSkdSimVOs = null;

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			swapCstSkdSimVOs = event.getSwapCstSkdSimVOs();

			paramVOs = new CstSkdByVvdVO[swapCstSkdSimVOs.length];

			for(int i=0; i<swapCstSkdSimVOs.length; i++){
				paramVOs[i] = new CstSkdByVvdVO();

				ObjectCloner.build(swapCstSkdSimVOs[i], paramVOs[i]);

				paramVOs[i].setVslSlanCd(swapCstSkdSimVO.getVslSlanCd());
				paramVOs[i].setSkdRmk(swapCstSkdSimVO.getSkdRmk());

				swapCstSkdSimVOs[i].setVslSimTpCd(swapCstSkdSimVO.getVslSimTpCd());
//				swapCstSkdSimVOs[i].setVslSlanCd(swapCstSkdSimVO.getVslSlanCd());
				swapCstSkdSimVOs[i].setDiffRmk(swapCstSkdSimVO.getSkdRmk());
				swapCstSkdSimVOs[i].setSimDt(swapCstSkdSimVO.getSimDt());
				swapCstSkdSimVOs[i].setSimNo(swapCstSkdSimVO.getSimNo());
			}
		}

		try{
			begin();
			String simCode = command.manageCstSkdSim(swapCstSkdSimVOs, account);

			VslSkdChgStsGRPVO vslSkdChgStsGRPVO = command.manageSettleByVvd(paramVOs, swapCstSkdSimVO, account);

			//Booking 에 변경된 스케줄 전송.
			//sendBkgByVslSkdChg(vslSkdChgStsGRPVO); //2013-12-05 :: LYJLYJ :: TRANSACTION TIME으로 인한  OLD ETD이 BDR에 적용으로  COMMIT이후로 이동//

			//COP 에 변경된 스케줄 전송.
			sendCopByVslSkdChg(vslSkdChgStsGRPVO);

			//EDI 전송
			if(vslSkdChgStsGRPVO.getEdiVvdVOs() != null && vslSkdChgStsGRPVO.getEdiVvdVOs().size() > 0){
				command.sendEdiToDLS(vslSkdChgStsGRPVO.getEdiVvdVOs());
			}

			//ERP 전송
			if(vslSkdChgStsGRPVO.getErpVvdVOs() != null && vslSkdChgStsGRPVO.getErpVvdVOs().size() > 0){
				for(VvdVO vo : vslSkdChgStsGRPVO.getErpVvdVOs()){
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
				}
				command.sendVslSkdErpIf(vslSkdChgStsGRPVO.getErpVvdVOs());
			}

			if(VSKGeneralUtil.isNotNull(simCode)){
				/*
				 * MASSAGE : 저장 작업이 성공했습니다.(VSK10016) - Simulation No.
				 */
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage() + "-" + simCode);
			}else{
				/*
				 * MASSAGE : 저장 작업이 성공했습니다.(VSK10016)
				 */
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			}
			commit();
			
			//Booking 에 변경된 스케줄 전송. + Booking BKG.POD.ETA Delay NOTICE 전송.
			sendBkgByVslSkdChg(vslSkdChgStsGRPVO);  
			
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0015 : Skip<br>
	 * Skip Call시 필요한 정보를 조회한다.<br>
	 * From ~ To Port간 Distance, Port Expense 등등.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchSkipCallInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		CstSkdSimDtlCalcInfoVO paramVO = null;

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			paramVO = event.getCstSkdSimDtlCalcInfoVO();
		}

		CstSkdSimDtlCalcInfoVO returnVO = command.searchSkipCallInfo(paramVO);

		eventResponse.setETCData("ttl_chg_amt", returnVO.getTtlChgAmt());
		eventResponse.setETCData("stnd_dist", returnVO.getStndDist());
		eventResponse.setETCData("tml_hndl_20ft_unit_amt", returnVO.getTmD2());
		eventResponse.setETCData("tml_hndl_40ft_unit_amt", returnVO.getTmD4());
		eventResponse.setETCData("tml_hndl_20ft_ttl_qty", returnVO.getTp20Qty());
		eventResponse.setETCData("tml_hndl_40ft_ttl_qty", returnVO.getTp40Qty());

		return eventResponse;
	}

	/**
	 * VOP_VSK_0015 : Add Call<br>
	 * Port Pair 간에 Distance 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddCallInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		CstSkdSimDtlCalcInfoVO paramVO = null;

		List<VskPortDistVO> vskPortDistVOs = null;
		VskPortDistVO vskPortDistVO = null;
		YardVO yardVO = null;
		StringBuilder sb = null;
		StringBuilder sb1 = null;

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			paramVO = event.getCstSkdSimDtlCalcInfoVO();

			vskPortDistVO = event.getVskPortDistVO();
			yardVO = event.getYardVO();
		}


		//***********************************************************************
		try{
			VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl();
			List<YardVO> yardList = null;
			String chkPort = null;
			
			if (yardVO != null) {
				chkPort = vskCodeFinderBC.checkPort(yardVO.getLocCd());
			}

			if(chkPort == null || "".equals(chkPort)){
				eventResponse.setETCData("yd_kind", "");
				eventResponse.setETCData("yd_nm", "");
			}else{
				yardList = vskCodeFinderBC.searchYardListByPort(yardVO);

				sb = new StringBuilder();
				sb1 = new StringBuilder();
				if(yardList != null && yardList.size() > 0){
					sb.append(yardList.get(0).getYdKind());
					sb1.append(yardList.get(0).getYdNm());
					for (int i = 1; i < yardList.size(); i++) {
						sb.append("|");
						sb1.append("|");
						sb.append(yardList.get(i).getYdKind());
						sb1.append(yardList.get(i).getYdNm());
					}
				}
				eventResponse.setETCData("yd_kind", sb.toString());
				eventResponse.setETCData("yd_nm", sb1.toString());
			}

			eventResponse.setETCData("check_port", chkPort);
			//***********************************************************************

			//***********************************************************************
			vskPortDistVOs = vskPortDistParam(vskPortDistVO);

			List<VskPortDistVO> distList = command.searchVskPortDist(vskPortDistVOs);

			if(distList != null && distList.size()>0){
				sb = new StringBuilder();

				VskPortDistVO vo = distList.get(0);

				sb.append(vo.getStndDist());
				for (int i = 1; i < distList.size(); i++) {
					sb.append("|");
					sb.append(distList.get(i).getStndDist());
				}

				eventResponse.setETCData("stnd_dist", sb.toString());
			}
			//***********************************************************************

			//***********************************************************************
			//LNK_DIST(PORT_DIST), Manu In/Out, PORT_BUF_HRS, CRN_KNT, TML_PROD_QTY, SPD, Time Diff
//			swapCstGRPVO.setVslCd(swapCstSkdSimVO.getVslCd());
//			swapCstGRPVO.setPortCd(yardVO.getLocCd());
//			swapCstGRPVO.setYardCd(yardCd);
//			SwapCstSkdSimVO rtnVO = command.searchAddCallInfo(paramVO);
			CstSkdSimDtlCalcInfoVO returnVO = command.searchAddCallInfo(paramVO);

			eventResponse.setETCData("lnk_spd", returnVO.getSpd());				//SPD
			eventResponse.setETCData("time_diff", returnVO.getTimeDiff());			//Time Diff
			eventResponse.setETCData("mnvr_in_hrs", returnVO.getMnvrInHrs());		//Manu In
			eventResponse.setETCData("mnvr_out_hrs", returnVO.getMnvrOutHrs());	//Manu Out
			eventResponse.setETCData("crn_knt", returnVO.getCrnKnt());				//TMNL Prod(CRANE_QTY)
			eventResponse.setETCData("tml_prod_qty", returnVO.getTmlProdQty());	//TMNL Prod
			eventResponse.setETCData("port_buf_hrs", returnVO.getPortBufHrs());	//Port Buffer Time(PORT_BUF_TIME)
			eventResponse.setETCData("ttl_chg_amt", returnVO.getTtlChgAmt());
			//***********************************************************************

	//		List<SwapCstSkdSimVO> list = null;

			eventResponse.setRsVoList(yardList);
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}

		return eventResponse;
	}

	/**
	 * VOP_VSK_0015 : Add Call 이후 Yard Code Change<br>
	 * Port Charge 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchYardChageByAddCall(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		CstSkdSimDtlCalcInfoVO paramVO = null;
		List<YardVO> list = null;
		YardVO yardVO = null;

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			paramVO = event.getCstSkdSimDtlCalcInfoVO();
			yardVO = event.getYardVO();
		}

		list = codeCommand.searchYardList(yardVO);

		if(list != null && list.size() > 0){

			// VSK_PORT_MNVR 테이블에 해당 Yard에 대한 manuvering time이 등록되어 있지 않은 경우, 즉 0인 경우
			// 1 시간씩 가지도록 수정한다.
			String mnvrInHrs = list.get(0).getMnvrInHrs();
			String mnvrOutHrs = list.get(0).getMnvrOutHrs();

			if("0".equals(mnvrInHrs)){
				mnvrInHrs = "1";
			}

			if("0".equals(mnvrOutHrs)){
				mnvrOutHrs = "1";
			}

			eventResponse.setETCData("mnvr_in_hrs", mnvrInHrs);
			eventResponse.setETCData("mnvr_out_hrs", mnvrOutHrs);
		}

		String ttlChgAmt = command.searchPortExpenceByVessel(paramVO);
		eventResponse.setETCData("ttl_chg_amt", ttlChgAmt);

		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0015 : Port Tariff Calculation<br>
	 * Port Charge 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPortTariffCalculation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		SwapCstSkdSimVO 		swapCstSkdSimVO 	= null;
		GeneralInvoiceAuditBC   psoCommand			= new GeneralInvoiceAuditBCImpl();
		
		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event 	= (VopVsk0015Event)e;
			swapCstSkdSimVO 		= event.getSwapCstSkdSimVO();
		}
		
		List<VvdPortTariffVO>		vvdPortTariffVOs	= new ArrayList<VvdPortTariffVO>();

		StringBuffer	sbRepVvd	= new StringBuffer();
		
		String sRepVslCd = null;
		String sRepSkdVoyNo = null;
		String sRepSkdDirCd = null;
		
		if (swapCstSkdSimVO != null) {
			sRepVslCd = swapCstSkdSimVO.getVslCd();
			sRepSkdVoyNo = swapCstSkdSimVO.getSkdVoyNo();
			sRepSkdDirCd = swapCstSkdSimVO.getSkdDirCd();
		}
		
		String sRepVvd				= sbRepVvd.append(sRepVslCd).append(sRepSkdVoyNo).append(sRepSkdDirCd).toString();
		
		TariffSimByVvdVO tmpTariffSimByVvdVO	= new TariffSimByVvdVO();
		tmpTariffSimByVvdVO.setVvd	(sRepVvd);
		//::조회대상테이블:GeneralInvoiceAuditDBDAOSearchYardsByVvdRSQL {src_pso_bztp_cd} <== Value "" or "2" Setting VSK_VSL_PORT_SKD:://
		tmpTariffSimByVvdVO.setSrcPsoBztpCd	("");	
		tmpTariffSimByVvdVO.setExpRto		("Y");	/* "Y":APPLY EXPENSE RATIO "N"+NULL:NONE EXPENSE RATIO */

		TariffGRPVO tariffGRPVO = new TariffGRPVO();
		tariffGRPVO				= psoCommand.searchSimulationByVvd(tmpTariffSimByVvdVO);
		
		/////////////////////////////////////////////////////
		// logging //////////////////////////////////////////
		//log.info("\n\n ::jskjskjsk::for loop::[tariffGRPVO.getTariffSimByVvdVOs().size = ["+tariffGRPVO.getTariffSimByVvdVOs().size()+"]");
		
/*		for(int mm=0; mm<tariffGRPVO.getTariffSimByVvdVOs().size(); mm++){
			
			CalcTariffResultVO		calcTariffResultVO		= new CalcTariffResultVO();
			
			calcTariffResultVO								= tariffGRPVO.getCalcTariffResultVOs().get(mm);
			String				sTmpTariffYdCd				= calcTariffResultVO.getYdCd();
			int len = calcTariffResultVO.getCalcTariffResultVOs().length;
			
			log.info("\n\n ::jskjskjsk::for loop::[calcTariffResultVO.getCalcTariffResultVOs().length] = ["+len+"]");
			
			log.info("\n\n ::jskjskjsk::for loop::[tariffGRPVO.getTariffSimByVvdVOs()] mm = ["+mm+"] :: repVVD ["+sTmpTariffYdCd+"]");
			
		}*/
		
		/////////////////////////////////////////////////////
		
		////eventResponse.setRsVoList(tariffGRPVO.getTariffSimByVvdVOs());//화면에 보여지는 grid
		
		
		//calcTariffResultVOs		= tariffGRPVO.getCalcTariffResultVOs();
		

		//for(int m=0; m<tariffGRPVO.getTariffSimByVvdVOs().size(); m++){
		for(int m=0; m<tariffGRPVO.getTariffSimByVvdVOs().size(); m++){
			
			CalcTariffResultVO		calcTariffResultVO		= new CalcTariffResultVO();
			
			calcTariffResultVO								= tariffGRPVO.getCalcTariffResultVOs().get(m);
			String				sTmpTariffYdCd				= calcTariffResultVO.getYdCd();
			
			log.info("\n\n ::jskjskjsk::for loop::[tariffGRPVO.getTariffSimByVvdVOs()] m = ["+m+"] :: repVVD ["+sRepVslCd+sRepSkdVoyNo+sRepSkdDirCd+"]");
			
			
				////////////////////////////////////////////////////////////////////////
				
			//String				sTmpTmnlCd			= tariffGRPVO.getCalcTariffResultVOs().get(m).getYdCd			();
			String 				sPortTariffUsdAmt	= tariffGRPVO.getCalcTariffResultVOs().get(m).getTariffUsdAmount();
			
			VvdPortTariffVO		tmpTariffVO			= new VvdPortTariffVO();
			
			tmpTariffVO.setVslCd				(sRepVslCd			);
			tmpTariffVO.setSkdVoyNo				(sRepSkdVoyNo		);
			tmpTariffVO.setSkdDirCd				(sRepSkdDirCd		);
			//tmpTariffVO.setVpsPortCd			(sTmpVpsPortCd		);
			//tmpTariffVO.setClptIndSeq			(sTmpClptIndSeq		);
			tmpTariffVO.setYdCd					(sTmpTariffYdCd			);
			tmpTariffVO.setPortTariffUsdAmt		(sPortTariffUsdAmt	);
			tmpTariffVO.setPortSurOrDcExistYn	("Y"				);
			
			vvdPortTariffVOs.add				(tmpTariffVO);	
			
			//log.info("\n\n ::jskjskjsk::for loop::[vvdPortTariffVOs <== setting] VVD ["+sTmpVslCd+sTmpSkdVoyNo+sTmpSkdDirCd+"]--["+sTmlCd+"]["+sPortTariffUsdAmt+"]");
			}
		
		//eventResponse.setRsVoList(vvdPortTariffVOs);//화면에 보여지는 grid
		eventResponse.setRsVoList(tariffGRPVO.getTariffSimByVvdVOs());
		//eventResponse.setETCData("PortTariffList", vvdPortTariffVOs.toString());//화면에 보여지는 grid
		
		return eventResponse;
		
	}
		
	
	/**
	 * VOP_VSK_0015 : Port Tariff Surcharge or Discount 존재여부조회<br>
	 * Port Charge 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkPortTariffSurchargeDiscountExistList(Event e) throws EventException {
		
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		List<VvdPortTariffVO>	rtnList				= new ArrayList<VvdPortTariffVO>();
		List<VvdPortTariffVO>	inpList				= new ArrayList<VvdPortTariffVO>();
		CoastalScheduleMgtBC 	command 			= new VesselScheduleMgtBCImpl();

		VvdPortTariffVO[] 		vvdPortTariffVOs	= null;
		
		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event 	= (VopVsk0015Event)e;
			vvdPortTariffVOs 		= event.getVvdPortTariffVOs();
		}
		
		if(vvdPortTariffVOs == null)	return null;
		
		for(int i=0; i<vvdPortTariffVOs.length; i++){
			VvdPortTariffVO	tmpVO	= vvdPortTariffVOs[i];
			
			inpList.add(tmpVO);
		}
		
		rtnList	= command.checkPortTariffSurchargeDiscountExistList(inpList);
		
		eventResponse.setRsVoList	(rtnList);
		
		////eventResponse.setETCData("yards"	, yardEtcData.length()>0?yardEtcData.toString():"");//detail grid의 header

		return eventResponse;

	}
		

	/**
	 * VOP_VSK_0015 : Add, Reverse<br>
	 * Port Pair 간에 Distance 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVskPortDist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskPortDistVO vskPortDistVO = new VskPortDistVO();
		List<VskPortDistVO> vskPortDistVOs = null;

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			vskPortDistVO = event.getVskPortDistVO();
		}

		vskPortDistVOs = vskPortDistParam(vskPortDistVO);

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		List<VskPortDistVO> list = command.searchVskPortDist(vskPortDistVOs);

		if(list != null && list.size()>0){
			StringBuilder sb = new StringBuilder();

			VskPortDistVO vo = list.get(0);

			sb.append(vo.getStndDist());
			for (int i = 1; i < list.size(); i++) {
				sb.append("|");
				sb.append(list.get(i).getStndDist());
			}

			eventResponse.setETCData("stnd_dist", sb.toString());
		}

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0020 : Retrieve<br>
	 * 기간별(Weekly, Monthly) POL, POD간에 Vessel Port SKD 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByPolPod(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CstSkdByPolPodVO cstSkdByPolPodVO = null;
		List<YardVO> polYardList = null;
		List<YardVO> podYardList = null;
		YardVO yardVO = new YardVO();

		if(e instanceof VopVsk0020Event){
			VopVsk0020Event event = (VopVsk0020Event)e;
			cstSkdByPolPodVO = event.getCstSkdByPolPodVO();
		}
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<CstSkdByPolPodVO> list = command.searchCstSkdByPolPod(cstSkdByPolPodVO);

		//====================================================================
		VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl();
		
		if (cstSkdByPolPodVO != null) {
			yardVO.setLocCd(cstSkdByPolPodVO.getPolPort());
		}
		polYardList = vskCodeFinderBC.searchYardListByPort(yardVO);
		
		if (cstSkdByPolPodVO != null) {
			yardVO.setLocCd(cstSkdByPolPodVO.getPodPort());
		}
		podYardList = vskCodeFinderBC.searchYardListByPort(yardVO);

		StringBuffer sb = new StringBuffer();
		if(polYardList != null && polYardList.size() > 0){
			sb.append(polYardList.get(0).getYdKind());
			for (int i = 1; i < polYardList.size(); i++) {
				sb.append("|");
				sb.append(polYardList.get(i).getYdKind());
			}
		}
		eventResponse.setETCData("pol_yd_kind", sb.toString());

		sb = new StringBuffer();
		if(podYardList != null && podYardList.size() > 0){
			sb.append(podYardList.get(0).getYdKind());
			for (int i = 1; i < podYardList.size(); i++) {
				sb.append("|");
				sb.append(podYardList.get(i).getYdKind());
			}
		}
		eventResponse.setETCData("pod_yd_kind", sb.toString());
		//====================================================================


		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * VOP_VSK_0021 : Retrieve<br>
	 * 기간별 Por에 기항하는 Coastal 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdByPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CstSkdByPortVO cstSkdByPortVO = null;
		List<YardVO> yardList = null;
		YardVO yardVO = new YardVO();

		if(e instanceof VopVsk0021Event){
			VopVsk0021Event event = (VopVsk0021Event)e;
			cstSkdByPortVO = event.getCstSkdByPortVO();
		}
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<CstSkdByPortVO> list = command.searchCstSkdByPort(cstSkdByPortVO);

		//====================================================================
		VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl();
		if (cstSkdByPortVO != null) {
			yardVO.setLocCd(cstSkdByPortVO.getVpsPortCd());
		}
		yardList = vskCodeFinderBC.searchYardListByPort(yardVO);

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		if(yardList != null && yardList.size() > 0){
			sb.append(yardList.get(0).getYdKind());
			sb2.append(yardList.get(0).getYdNm());
			for (int i = 1; i < yardList.size(); i++) {
				sb.append("|");
				sb2.append("|");
				sb.append(yardList.get(i).getYdKind());
				sb2.append(yardList.get(i).getYdNm());
			}
		}
		eventResponse.setETCData("yd_kind", sb.toString());
		eventResponse.setETCData("yd_nm", sb2.toString());
		//====================================================================

		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * VOP_VSK_0015 : Add Call<br>
	 * Port Pair 간에 Distance 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdSimBaseInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SwapCstSkdSimVO swapCstSkdSimVO = new SwapCstSkdSimVO();
		SwapCstSkdSimVO rtnVO = null;
		SwapCstGRPVO swapCstGRPVO = new SwapCstGRPVO();
		List<VskPortDistVO> vskPortDistVOs = null;
		VskPortDistVO vskPortDistVO = null;
		YardVO yardVO = null;
		StringBuilder sb = null;
		StringBuilder sb1 = null;

		String yardCd = "";

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			vskPortDistVO = event.getVskPortDistVO();
			yardVO = event.getYardVO();
		}
//		else if(e instanceof VopVsk0058Event){
//			VopVsk0058Event event = (VopVsk0058Event)e;
//			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
//			vskPortDistVO = event.getVskPortDistVO();
//			yardVO = event.getYardVO();
//		}
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		//***********************************************************************
		try{
			VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl();
			List<YardVO> yardList = null;
			String chkPort = null;
			
			if (yardVO != null) {
				chkPort = vskCodeFinderBC.checkPort(yardVO.getLocCd());
			}

			if(chkPort == null || "".equals(chkPort)){
				eventResponse.setETCData("yd_kind", "");
				eventResponse.setETCData("yd_nm", "");
			}else{
				yardList = vskCodeFinderBC.searchYardListByPort(yardVO);

				sb = new StringBuilder();
				sb1 = new StringBuilder();
				if(yardList != null && yardList.size() > 0){
					sb.append(yardList.get(0).getYdKind());
					sb1.append(yardList.get(0).getYdNm());
					for (int i = 1; i < yardList.size(); i++) {
						sb.append("|");
						sb1.append("|");
						sb.append(yardList.get(i).getYdKind());
						sb1.append(yardList.get(i).getYdNm());
					}
				}
				eventResponse.setETCData("yd_kind", sb.toString());
				eventResponse.setETCData("yd_nm", sb1.toString());
			}

			eventResponse.setETCData("check_port", chkPort);
			//***********************************************************************

			//***********************************************************************
			vskPortDistVOs = vskPortDistParam(vskPortDistVO);

			List<VskPortDistVO> distList = command.searchVskPortDist(vskPortDistVOs);

			if(distList != null && distList.size()>0){
				sb = new StringBuilder();

				VskPortDistVO vo = distList.get(0);

				sb.append(vo.getStndDist());
				for (int i = 1; i < distList.size(); i++) {
					sb.append("|");
					sb.append(distList.get(i).getStndDist());
				}

				eventResponse.setETCData("stnd_dist", sb.toString());
			}
			//***********************************************************************

			//***********************************************************************
			//LNK_DIST(PORT_DIST), Manu In/Out, PORT_BUF_HRS, CRN_KNT, TML_PROD_QTY, SPD, Time Diff
			swapCstGRPVO.setVslCd(swapCstSkdSimVO.getVslCd());
			if (yardVO != null) {
				swapCstGRPVO.setPortCd(yardVO.getLocCd());
			}
			swapCstGRPVO.setYardCd(yardCd);
			rtnVO = command.searchCstSkdSimBaseInfo(swapCstGRPVO);

			eventResponse.setETCData("lnk_spd", rtnVO.getLnkSpd());				//SPD
			eventResponse.setETCData("time_diff", rtnVO.getTimeDiff());			//Time Diff
			eventResponse.setETCData("mnvr_in_hrs", rtnVO.getMnvrInHrs());		//Manu In
			eventResponse.setETCData("mnvr_out_hrs", rtnVO.getMnvrOutHrs());	//Manu Out
			eventResponse.setETCData("crn_knt", rtnVO.getCrnKnt());				//TMNL Prod(CRANE_QTY)
			eventResponse.setETCData("tml_prod_qty", rtnVO.getTmlProdQty());	//TMNL Prod
			eventResponse.setETCData("port_buf_hrs", rtnVO.getPortBufHrs());	//Port Buffer Time(PORT_BUF_TIME)
			//***********************************************************************

	//		List<SwapCstSkdSimVO> list = null;

			eventResponse.setRsVoList(yardList);
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}

		return eventResponse;
	}

	/**
	 * searchCstSkdSimBaseInfo, searchVskPortDist : Call
	 * VSK_PORT_DIST 정보를 갖고 오기 위한 Parameter를 셋팅한다.
	 *
	 * @param vskPortDistVO VskPortDistVO
	 * @return List<VskPortDistVO>
	 */
	private List<VskPortDistVO> vskPortDistParam(VskPortDistVO vskPortDistVO){
		List<VskPortDistVO> list = new ArrayList<VskPortDistVO>();

		String[] fmLocCds = null;
		String[] toLocCds = null;
		String fmLocCd = vskPortDistVO.getFmLocCd();
		String toLocCd = vskPortDistVO.getToLocCd();

		if(fmLocCd.indexOf("|") > 0){
			fmLocCds = fmLocCd.split("\\|");
			toLocCds = toLocCd.split("\\|");
			for(int i=0; i<fmLocCds.length; i++){
				VskPortDistVO vo = new VskPortDistVO();
				vo.setFmLocCd(fmLocCds[i]);
				vo.setToLocCd(toLocCds[i]);

				list.add(vo);
			}
		}else{
			VskPortDistVO vo = new VskPortDistVO();
			vo.setFmLocCd(fmLocCd);
			vo.setToLocCd(toLocCd);

			list.add(vo);
		}

		return list;
	}

	/**
	 * VOP_VSK_0015 : lnk_spd Change<br>
	 * Coastal SKD Simulation의 Bunker Additional Cost 정보를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBunkerQtyBySpeed(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		CstSkdSimDtlCalcInfoVO paramVO = null;

		if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			paramVO = event.getCstSkdSimDtlCalcInfoVO();
		}
//		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>"+paramVO.getVslCd());
//		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>"+paramVO.getFmSpd());
//		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>"+paramVO.getToSpd());
//		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>"+paramVO.getPreEtd());
//		log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>"+paramVO.getNxtEta());
		CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO = command.searchBunkerQtyBySpeed(paramVO);

		eventResponse.setETCData("bnk_unit_qty", cstSkdSimDtlCalcInfoVO.getBnkUnitQty());
		eventResponse.setETCData("bnk_unit_amt", cstSkdSimDtlCalcInfoVO.getBnkUnitAmt());

		return eventResponse;
	}

	/**
	 * VOP_VSK_0020, VOP_VSK_0021 : Port Change<br>
	 * Port Code 존재유무를 확인한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MdmLocationVO mdmLocationVO = null;

		if(e instanceof VopVsk0020Event){
			VopVsk0020Event event = (VopVsk0020Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}else if(e instanceof VopVsk0021Event){
			VopVsk0021Event event = (VopVsk0021Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}

		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		String chkPort = null;
		
		if (mdmLocationVO != null) {
			chkPort = command.checkPort(mdmLocationVO.getLocCd());
		}

		eventResponse.setETCData("check_port", chkPort);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0065 : Retrieve<br>
	 * VSL SKD History 정보를 조회해 온다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdHisByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VvdPortLaneOtherVO vvdPortLaneOtherVO = null;
		List<CstSkdHisByVvdVO> list = null;

		if(e instanceof VopVsk0065Event){
			VopVsk0065Event event = (VopVsk0065Event)e;
			vvdPortLaneOtherVO = event.getVvdPortLaneOtherVO();
		}

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		list = command.searchCstSkdHisByVvd(vvdPortLaneOtherVO);

		// 페이징에 관계없이 전체 건수 표현
		if(list!=null && list.size()>0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}

		eventResponse.setETCData("chg_sts_cd", VSKGeneralUtil.comnCodeList("CD01831", "onlycode"));
		eventResponse.setETCData("chg_sts_nm", VSKGeneralUtil.comnCodeList("CD01831", "onlyname"));

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0065 : Retrieve<br>
	 * Actual SKD History 정보를 조회해 온다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActSkdHisByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VvdPortLaneOtherVO vvdPortLaneOtherVO = null;
		List<ActPortSkdHisVO> list = null;

		if(e instanceof VopVsk0065Event){
			VopVsk0065Event event = (VopVsk0065Event)e;
			vvdPortLaneOtherVO = event.getVvdPortLaneOtherVO();
		}

		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
		list = command.searchActPortSkdHis(vvdPortLaneOtherVO);

		// 페이징에 관계없이 전체 건수 표현
		if(list!=null && list.size()>0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}

		eventResponse.setETCData("chg_sts_cd", VSKGeneralUtil.comnCodeList("CD01831", "onlycode"));
		eventResponse.setETCData("chg_sts_nm", VSKGeneralUtil.comnCodeList("CD01831", "onlyname"));

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

//	/**
//	 *
//	 * Call Indicator를 조회
//	 *
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchCallIndicator(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		eventResponse.setETCData("call_ind_cd", VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
//		eventResponse.setETCData("call_ind_nm", VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));
//
//		return eventResponse;
//	}

	/**
	 * VOP_VSK_0247 : Open
	 * CNSHA Port 및 이전 Boud에 기항지 정보를 찾고 Bay Plan이 입력되는 Port를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBayPlanInputPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VskVslPortSkdVO paramVO = null;
		List<VskVslPortSkdVO> list = null;

		if(e instanceof VopVsk0247Event){
			VopVsk0247Event event = (VopVsk0247Event)e;
			paramVO = event.getVskVslPortSkdVO();
		}

		list = command.searchBayPlanInputPort(paramVO);

		StringBuilder vslCdSB = new StringBuilder();
		StringBuilder skdVoyNoSB = new StringBuilder();
		StringBuilder skdDirCdSB = new StringBuilder();
		StringBuilder vpsPortCdSB = new StringBuilder();
		StringBuilder clptIndSeqSB = new StringBuilder();

		if(list != null && list.size() > 0){
			vslCdSB.append(list.get(0).getVslCd());
			skdVoyNoSB.append(list.get(0).getSkdVoyNo());
			skdDirCdSB.append(list.get(0).getSkdDirCd());
			vpsPortCdSB.append(list.get(0).getVpsPortCd());
			clptIndSeqSB.append(list.get(0).getClptIndSeq());
			for(int i=1; i<list.size(); i++){
				vslCdSB.append("|"+list.get(i).getVslCd());
				skdVoyNoSB.append("|"+list.get(i).getSkdVoyNo());
				skdDirCdSB.append("|"+list.get(i).getSkdDirCd());
				vpsPortCdSB.append("|"+list.get(i).getVpsPortCd());
				clptIndSeqSB.append("|"+list.get(i).getClptIndSeq());
			}
		}

		eventResponse.setETCData("vsl_cd_list", vslCdSB.toString());
		eventResponse.setETCData("skd_voy_no_list", skdVoyNoSB.toString());
		eventResponse.setETCData("skd_dir_cd_list", skdDirCdSB.toString());
		eventResponse.setETCData("vps_port_cd_list", vpsPortCdSB.toString());
		eventResponse.setETCData("clpt_ind_seq_list", clptIndSeqSB.toString());
		eventResponse.setETCData("call_ind_cd", VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
		eventResponse.setETCData("call_ind_nm", VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));

		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0247 : Open
	 * 입출항일시 기준으로 최대 선적 화물량을 계산 및 조회
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calLoadableWgt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		LoadWgtGRPVO loadWgtGRPVO = new LoadWgtGRPVO();
		LoadWgtGRPVO paramGRPVO = new LoadWgtGRPVO();
		List<LoadWgtVO> list = new ArrayList<LoadWgtVO>();

		if(e instanceof VopVsk0247Event){
			VopVsk0247Event event = (VopVsk0247Event)e;
			paramGRPVO.setLoadWgtVO(event.getLoadWgtVO());
		}

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		loadWgtGRPVO = command.calLoadableWgt(paramGRPVO);

		/*
		 * VSL_CLASS(Vessel Class)
		 * LIGHT_SHIP(Light Ship)
		 */
		eventResponse.setETCData("vsl_class", loadWgtGRPVO.getVslClass());
		eventResponse.setETCData("light_ship", loadWgtGRPVO.getLightShip());

		eventResponse.setETCData("fuel_oil", loadWgtGRPVO.getFuelOil());
		eventResponse.setETCData("diesel_oil", loadWgtGRPVO.getDieselOil());
		eventResponse.setETCData("fresh_water", loadWgtGRPVO.getFreshWater());
		eventResponse.setETCData("ballast", loadWgtGRPVO.getBallast());

		eventResponse.setETCData("draft", loadWgtGRPVO.getDraft());

		eventResponse.setETCData("tpc", loadWgtGRPVO.getTpc());
		eventResponse.setETCData("displacement", loadWgtGRPVO.getDisplacement());

		eventResponse.setETCData("cargo_weight", loadWgtGRPVO.getCargoWeight());

		StringBuilder sb = new StringBuilder();
		List<LoadWgtVO> loadWgtVOList = loadWgtGRPVO.getLoadWgtVOList();
		if(loadWgtVOList != null && loadWgtVOList.size() > 0){
			sb.append(loadWgtVOList.get(0).getCol01());
			sb.append("|"+loadWgtVOList.get(0).getCol02());
			sb.append("|"+loadWgtVOList.get(0).getCol03());
			sb.append("|"+loadWgtVOList.get(0).getCol04());
			sb.append("|"+loadWgtVOList.get(0).getCol05());
			sb.append("|"+loadWgtVOList.get(0).getCol06());
		}else{
			sb.append(" | | | | | ");
		}
		eventResponse.setETCData("title", sb.toString());

		if(loadWgtGRPVO.getLoadWgtVOList() != null){
			for(int i=1; i<loadWgtGRPVO.getLoadWgtVOList().size(); i++){
				list.add(loadWgtGRPVO.getLoadWgtVOList().get(i));
			}
		}
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0003 : A/Calculation<br>
	 * P/F Schedule을 Auto Simulation 합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calPfSkdAuto(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		VopVsk0003Event event = (VopVsk0003Event)e;

		PfSkdGRPVO grpVO = event.getPfSkdGRPVO();
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs = grpVO.getVskPfSkdDtlVOs();
		VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOs.get(0);
		//같은 Method(M/Calculation)을 호출하지만 Feeder에서는 Calling Port등은 계산하지 않기 때문에
		//0053에서는 B로 셋팅, 0001,0003은 A로 셋팅
		vskPfSkdDtlVO.setEventNav("A");
		vskPfSkdDtlVOs.set(0, vskPfSkdDtlVO);
		grpVO.setVskPfSkdDtlVOs(vskPfSkdDtlVOs);

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		PfSkdGRPVO pfSkdGRPVO = command.calPfSkdAuto(grpVO);

		VskPfSkdVO masterVO = pfSkdGRPVO.getVskPfSkdVO();
		List<VskPfSkdDtlVO> detailVOs  = pfSkdGRPVO.getVskPfSkdDtlVOs();

		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();

		if(detailVOs.size() > 0 && detailVOs != null){
			sb.append(detailVOs.get(0).getYdCd());
			for(int i=1; i<detailVOs.size(); i++){
				sb.append("|");
				sb.append(detailVOs.get(i).getYdCd());
			}

			sb2.append(detailVOs.get(0).getTotMaxSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getTotAvgSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getBufSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getTotBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getSeaBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getPortBufRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getPfSpdRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getBufSpdRat());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getMinMaxSpd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getVslSvcTpCd());
			sb2.append("|");
			sb2.append(detailVOs.get(0).getCheckVslSkd());
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setRsVo(masterVO);
		eventResponse.setRsVoList(detailVOs);
		eventResponse.setETCData("ydCd", sb.toString());
		eventResponse.setETCData("etcdt", sb2.toString());
		eventResponse.setUserMessage(new ErrorHandler("VSK09001").getUserMessage());
		return eventResponse;
	}

	/**
	 * 화면에 표현될 그리드의 헤더 정보를 생성한다.
	 *
	 * @param List<PfSkdDetailVO> pfSkdDetailVOs
	 * @param int headerIdx
	 * @param GeneralEventResponse eventResponse
	 * @param String unitTp
	 * @exception EventException
	 */
	private void makeHeader(List<PfSkdDetailVO> pfSkdDetailVOs, int headerIdx, GeneralEventResponse eventResponse, String unitTp) throws EventException {
		try {
			StringBuilder headTitle1 = null; // SKD_DIR_CD
			StringBuilder headTitle2 = null; // VPS_PORT_CD
			StringBuilder headTitle3 = null; // ETB_DY_CD
			StringBuilder headTitle4 = null; // ETB_TM_HRMNT
			StringBuilder headTitle5 = null; // CLPT_IND_SEQ
			StringBuilder headTitle6 = null; // YD_CD
			StringBuilder headTitle7 = null; // CALL_YD_IND_SEQ

			headTitle1 = new StringBuilder();
			headTitle2 = new StringBuilder();
			headTitle3 = new StringBuilder();
			headTitle4 = new StringBuilder();
			headTitle5 = new StringBuilder();
			headTitle6 = new StringBuilder();
			headTitle7 = new StringBuilder();

			for(PfSkdDetailVO vo : pfSkdDetailVOs){
				headTitle1.append("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd());
				headTitle2.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
				headTitle3.append("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd());
				if(vo.getEtbTmHrmnt().length()>2){
					headTitle4.append("|").append(vo.getEtbTmHrmnt().substring(0, 2)).append("|").append(vo.getEtdTmHrmnt().substring(0, 2));
				}else{
					headTitle4.append("|").append(vo.getEtbTmHrmnt()).append("|").append(vo.getEtdTmHrmnt());
				}
				headTitle5.append("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq());
				if("1".equals(unitTp)){
					headTitle6.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
				}else{
					headTitle6.append("|").append(vo.getYdCd()).append("|").append(vo.getYdCd());
				}
				headTitle7.append("|").append(vo.getCallYdIndSeq()).append("|").append(vo.getCallYdIndSeq());

				// UI에서는 두개의 컬럼이 하나의 포트 정보로 표시된다.
				// UI의 원할한 성능을 위해 두개의 컬럼 이후에 pseudo 컬럼을 둔다.
				headTitle1.append("|").append(vo.getSkdDirCd());
				headTitle2.append("|");
				headTitle3.append("|");
				headTitle4.append("|");
				headTitle5.append("|");
				headTitle6.append("|");
				headTitle7.append("|");
			}

			eventResponse.setETCData("HeadTitle1_" + headerIdx, headTitle1.toString());
			eventResponse.setETCData("HeadTitle2_" + headerIdx, headTitle2.toString());
			eventResponse.setETCData("HeadTitle3_" + headerIdx, headTitle3.toString());
			eventResponse.setETCData("HeadTitle4_" + headerIdx, headTitle4.toString());
			eventResponse.setETCData("HeadTitle5_" + headerIdx, headTitle5.toString());
			eventResponse.setETCData("HeadTitle6_" + headerIdx, headTitle6.toString());
			eventResponse.setETCData("HeadTitle7_" + headerIdx, headTitle7.toString());
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}

	/**
	 * VOP_VSK_0012 : Retrieve<br>
	 * Long Range Schedule을 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLongRngSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		//VopVsk0012_1Event event = (VopVsk0012_1Event)e;
		VopVsk0012Event 		event 			= (VopVsk0012Event)e;

		LongRangeScheduleMgtBC 	command 		= new VesselScheduleMgtBCImpl();

		try{
			PortSkdOnLongRangeVO 	portSkdOnLongRangeVO 	= event.getPortSkdOnLongRangeVO();
			String 					unitTp 					= portSkdOnLongRangeVO.getUnitTp();		//by port, by yard 구분자
			
			LongRangeSkdInqGRPVO 				longRangeSkdInqGRPVO 	= command.searchPortSkdOnLongRange(portSkdOnLongRangeVO);
			//Map<String, List<PfSkdDetailVO>> pfSkdDetails = longRangeSkdInqGRPVO.getPfSkdDetails();
			Map<String, List<PfSkdDetailVO>> 	pfSkdDetailsByGroup 	= longRangeSkdInqGRPVO.getPfSkdDetailsByGroup();
			List<List<PortSkdOnLongRangeVO>> 	portSkdOnLongRangeVOs 	= longRangeSkdInqGRPVO.getPortSkdVOs();

			if(portSkdOnLongRangeVOs==null || portSkdOnLongRangeVOs.size()==0){
				eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Schedule"}).getMessage());
			}else{

				// EventResponse에 Remark 정보 등록
				eventResponse.setRsVoList(longRangeSkdInqGRPVO.getRemarks());

				PortSkdOnLongRangeVO portSkdVO = null;
				List<List<List<PortSkdOnLongRangeVO>>> groupByPf = longRangeSkdInqGRPVO.getPortSkdVOsByPf();

				// portSkdByPf ( List<PortSkdOnLongRangeVO> 타입 ) ==> 그리드에서 한 Row에 해당 ==> rowData( List<LongRangeSkdInqVO> 타입 ) 으로 변환
				// sameGroupData ( List<List<PortSkdOnLongRangeVO>> 타입) ==> 하나의 그리드에 해당  ==> gridData ( rowData + rowData ...  타입 ) 으로 변환
				int pfGroupCnt = 1;
				for(List<List<PortSkdOnLongRangeVO>> sameGroupData : groupByPf){

					List<PortSkdOnLongRangeVO> 	portSkdByPf = null;
					List<LongRangeSkdInqVO> 	rowData 	= null;
					List<LongRangeSkdInqVO> 	gridData 	= new ArrayList<LongRangeSkdInqVO>();
					List<PfSkdDetailVO> 		pfSkds 		= null;
					LongRangeSkdInqVO 			inqVO 		= null;

					for(int i=0; i<sameGroupData.get(0).size(); i++){
						portSkdVO = sameGroupData.get(0).get(i);
						if(!portSkdVO.isEmptySkd()){
							break;
						}
					}

					for(int i=0; i<sameGroupData.size(); i++){

						portSkdByPf = sameGroupData.get(i); //new ArrayList<PortSkdOnLongRangeVO>();
						if(i==0){
							if (portSkdVO != null) {
								pfSkds = pfSkdDetailsByGroup.get(portSkdVO.getVslSlanCd() + portSkdVO.getPfSkdTpCd() + portSkdVO.getVslCd() + portSkdVO.getSkdVoyNo());
							}
							makeHeader(pfSkds, pfGroupCnt++, eventResponse, unitTp);
						}

						// 앞선 로직에서 헤더부(P/F SKD) 와 데이터부(PORT SKD)의 사이즈를 맞췄기 때문에
						// list와 pfSkds의 size는 동일하다.
						rowData = new ArrayList<LongRangeSkdInqVO>();

						confirmCreUsrInfo(portSkdByPf);

						if (pfSkds != null) {
							for(int m=0; m<pfSkds.size(); m++){
								inqVO = new LongRangeSkdInqVO();
								portSkdVO = portSkdByPf.get(m);
	
								inqVO.setVslSlanCd	(portSkdVO.getVslSlanCd	());
								inqVO.setPfSkdTpCd	(portSkdVO.getPfSkdTpCd	());
								inqVO.setVslCd		(portSkdVO.getVslCd		());
								inqVO.setSkdVoyNo	(portSkdVO.getSkdVoyNo	());
								inqVO.setSkdDirCd	(portSkdVO.getSkdDirCd	());
								inqVO.setVpsPortCd	(portSkdVO.getVpsPortCd	());
								inqVO.setClptSeq	(portSkdVO.getClptSeq	());
								inqVO.setVslEngNm	(portSkdVO.getVslEngNm  ());
								inqVO.setActCrrCd	(portSkdVO.getActCrrCd	());
	
								inqVO.setVpsEtaDt	(portSkdVO.getVpsEtaDt	());
								inqVO.setVpsEtbDt	(portSkdVO.getVpsEtbDt	());
								inqVO.setVpsEtdDt	(portSkdVO.getVpsEtdDt	());
								inqVO.setPfEtaDt	(portSkdVO.getPfEtaDt	());
								inqVO.setPfEtbDt	(portSkdVO.getPfEtbDt	());
								inqVO.setPfEtdDt	(portSkdVO.getPfEtdDt	());
								inqVO.setInitEtaDt	(portSkdVO.getInitEtaDt	());
								inqVO.setInitEtbDt	(portSkdVO.getInitEtbDt	());
								inqVO.setInitEtdDt	(portSkdVO.getInitEtdDt	());
	
								inqVO.setSkdCngStsCd(portSkdVO.getSkdCngStsCd());
								inqVO.setVpsRmk		(portSkdVO.getVpsRmk	());
								inqVO.setCreDt		(portSkdVO.getCreDt		());
								inqVO.setCreUsrId	(portSkdVO.getCreUsrId	());
								inqVO.setUpdDt		(portSkdVO.getUpdDt		());
								inqVO.setUpdUsrId	(portSkdVO.getUpdUsrId	());
								inqVO.setEmptySkd	(portSkdVO.isEmptySkd	());
								inqVO.setAddingSkd	(portSkdVO.isAddingSkd	());
								inqVO.setReverse	(portSkdVO.isReverse	());
								inqVO.setPhsIoRsnCd(portSkdVO.getPhsIoRsnCd());
								
								rowData.add(inqVO);
							}
						}

						gridData.addAll(rowData);
						if(i != sameGroupData.size()-1){
							gridData.add(null); // Row 구분자로 활용하기 위해 NULL 추가. LongRangeInqViewAdapter에서 활용함.
						}
					}
					eventResponse.setRsVoList(gridData);
				}

				/*
				 * CHM-201007036-01 Port 정보와 Vseel 정보도 조회
				 */
				Map<String, String> portNms 	= longRangeSkdInqGRPVO.getPortNms();
				Map<String, String> vslEngNms 	= longRangeSkdInqGRPVO.getVslEngNms();

				StringBuffer portNmEtcData 		= new StringBuffer();
				StringBuffer vslEngNmEtcData 	= new StringBuffer();

				if(portNms != null){
					for(Iterator<String> i = portNms.keySet().iterator(); i.hasNext(); ){
						String key = i.next();
						portNmEtcData.append(key).append("|").append(portNms.get(key));
						if(i.hasNext()){
							portNmEtcData.append(";");
						}
					}
				}

				if(vslEngNms != null){
					for(Iterator<String> i = vslEngNms.keySet().iterator(); i.hasNext(); ){
						String key = i.next();
						vslEngNmEtcData.append(key).append("|").append(vslEngNms.get(key));
						if(i.hasNext()){
							vslEngNmEtcData.append(";");
						}
					}
				}

				if(portNmEtcData.length()>0){
					eventResponse.setETCData("port_nms", portNmEtcData.toString());
				}

				if(vslEngNmEtcData.length()>0){
					eventResponse.setETCData("vsl_eng_nms", vslEngNmEtcData.toString());
				}

			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 스케쥴 리스트에서 가장 오래된 Create 정보와, 가장 최근의 Update 정보를 구한후에
	 * 해당 리스트의 모든 스케쥴 정보에 반영한다.
	 *
	 * @param portSkdOnLongRangeVOs
	 */
	private void confirmCreUsrInfo(List<PortSkdOnLongRangeVO> portSkdOnLongRangeVOs){

		String creDt = null;
		String creUsrId = null;
		String updDt = null;
		String updUsrId = null;


		PortSkdOnLongRangeVO vo = null;

		for(int i=0; i<portSkdOnLongRangeVOs.size(); i++){
			vo = portSkdOnLongRangeVOs.get(i);
			if(vo.isEmptySkd()){
				continue;
			}
			if(creDt==null || creDt.compareTo(vo.getCreDt()) < 0){
				creDt = vo.getCreDt();
				creUsrId = vo.getCreUsrId();
			}
			if(updDt==null || updDt.compareTo(vo.getUpdDt()) > 0){
				updDt = vo.getUpdDt();
				updUsrId = vo.getUpdUsrId();
			}
		}

		for(int i=0; i<portSkdOnLongRangeVOs.size(); i++){
			vo = portSkdOnLongRangeVOs.get(i);
			vo.setCreDt(creDt);
			vo.setCreUsrId(creUsrId);
			vo.setUpdDt(updDt);
			vo.setUpdUsrId(updUsrId);
		}

	}

	/**
	 * VOP_VSK_0053 : Retrieve
	 * Lane Code가 유효한지 조회하고 Dir_Cd를 조회한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneDirList (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0053Event event = (VopVsk0053Event)e;
		MdmVslSvcLaneVO mdmVslSvcLaneVO = event.getMdmVslSvcLaneVO();
		String vslSlanCd = mdmVslSvcLaneVO.getVslSlanCd();

		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<MdmVslSvcLaneVO> list = command.checkSvcLane(event.getMdmVslSvcLaneVO());
		StringBuffer data = new StringBuffer();
		StringBuffer data2 = new StringBuffer();
		String vslSvcTpCd = "";
		String fdrDivCd = "";

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getVslSlanNm());
				vslSvcTpCd = list.get(i).getVslSvcTpCd();
				fdrDivCd = list.get(i).getFdrDivCd();
				if (i < list.size()-1)
					data.append("|");
			}

			MdmVslSvcLaneDirVO dirVo = new MdmVslSvcLaneDirVO();
			dirVo.setVslSlanCd(vslSlanCd);
			List<MdmVslSvcLaneDirVO> list2 = command.searchSvcLaneDirList (dirVo);

			for(int k=0; k < list2.size(); k++){
				data2.append(list2.get(k).getVslSlanDirCd());
				if (k < list2.size()-1)
					data2.append("|");
			}
		}else{

		}

		eventResponse.setETCData("checkLane", data.toString());
		eventResponse.setETCData("checkLaneTpCd", vslSvcTpCd);
		eventResponse.setETCData("checkFdrDivCd", fdrDivCd);
		eventResponse.setETCData("checkDirCd", data2.toString());
		return eventResponse;
	}

	/**
	 * VOP_VSK_0229 : Retrieve
	 * VVD별 연결되어 잇는 Booking List를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgListByVvd(Event e) throws EventException {
		VopVsk0229Event event = (VopVsk0229Event)e;
		BkgListByVvdVO bkgListByVvdVO = event.getBkgListByVvdVO();

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<BkgListByVvdVO> list = command.searchBkgListByVvd(
				bkgListByVvdVO.getVslCd(), bkgListByVvdVO.getSkdVoyNo(), bkgListByVvdVO.getSkdDirCd());

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * VOP_VSK_0018 : SKD Closing
	 * VOP_VSK_0059 : SKD Closing
	 *
	 * 해당 Vessel Schedule을 수동 Close 처리합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVslSkdListByLane(Event e) throws EventException {
		ActivationVvdVO[] vos = null;
		if(e instanceof VopVsk0018Event){
			VopVsk0018Event event = (VopVsk0018Event)e;
			vos = event.getActivationVvdVOS();
		}else if(e instanceof VopVsk0059Event){
			VopVsk0059Event event = (VopVsk0059Event)e;
			vos = event.getActivationVvdVOS();
		}

		CoastalScheduleMgtBC 	command 		= new VesselScheduleMgtBCImpl();
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		try{
			begin();
			command.manageVslSkdListByLane(vos, account);
			// Close 성공
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			
			
			/* ============================================================================
			 * Vessel Schedule History 관리(Header+Detail) Started ::2013-08-27::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * 1. VSK_VSL_SKD_CNG_HIS
			 * 2. VSK_VSL_SKD_CNG_HIS_DTL
			 * ----------------------------------------------------------------------------
			 * VSK_VSL_SKD_CNG_HIS 		: INSERT (MERGE)
			 * VSK_VSL_SKD_CNG_HIS_DTL 	: INSERT ONLY
			 * ============================================================================
			 */
			//command.createVesselScheduleChangeHistory(vskVslSkdVOs, null, "MODIFY_VvdStatusChange");
			
		}catch(EventException ex){
			rollback();
			// Close 실패
			eventResponse.setUserMessage(new ErrorHandler("VSK09003").getUserMessage());
			throw ex;
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0018 : SKD Activate
	 * VOP_VSK_0059 : SKD Activate
	 *
	 * 해당 Vessel Schedule을 Activate 처리합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSkdActivate(Event e) throws EventException {
		ActivationVvdVO activationVvdVO = null;
		if(e instanceof VopVsk0018Event){
			VopVsk0018Event event = (VopVsk0018Event)e;
			activationVvdVO = event.getActivationVvdVO();
		}else if(e instanceof VopVsk0059Event){
			VopVsk0059Event event = (VopVsk0059Event)e;
			activationVvdVO = event.getActivationVvdVO();
		}

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.manageSkdActivate(activationVvdVO, account);
			// Activate 성공
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			
		}catch(EventException ex){
			rollback();
			// Activate 실패
			eventResponse.setUserMessage(new ErrorHandler("VSK09003").getUserMessage());
			throw ex;
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0066 : Retrieve<br>
	 * 기존의 입력된 Slot Price 정보가 없으면  신규로 searchPfSkd로 데이타를 가져온다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("static-access")
	private EventResponse searchSlotPrice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SlotPriceGRPVO grpVO = null;

		if(e instanceof VopVsk0066Event){
			VopVsk0066Event event = (VopVsk0066Event)e;
			grpVO = event.getSlotPriceGRPVO();
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		SlotPriceGRPVO rtnGRPVO = command.searchSlotPrice(grpVO);

		//Bunker Expense 계산
		// R/Voyage
		double dDurHrs = 0;
		double dDurDay = 0;
		// Sea Time
		int iTotTztmHrs = 0;
		double dTotTztmDay = 0;
		int iTotTztmHrsSum = 0;
		// Maneuvering
		int iTotManeHrs = 0;
		double dTotManeDay = 0;
		int iTotManeSum = 0;
		//Port Days
		double dTotActPortHrs = 0;
		double dTotActPortDay = 0;
		double dTotActPortSum = 0;
		//Service Speed
		double dTotServiceSpd = 0;
		double dServiceAvg = 0;

		StringBuffer data = new StringBuffer();
		StringBuffer data2 = new StringBuffer();

		//slot price에 vsl_class 데이타가 없으면()
		List<PfSkdVO> psSkdVO = rtnGRPVO.getPfSkdVOs();

		for(int i=0; i<psSkdVO.size(); i++){

			iTotTztmHrsSum += Integer.parseInt(psSkdVO.get(i).getTztmHrs());  //Sea Time
			double tempMnvrInHrs = 0;
			double tempMnvrOutHrs = 0;
			if(VSKGeneralUtil.isNotNull(psSkdVO.get(i).getMnvrInHrs())){
				tempMnvrInHrs = Double.parseDouble(psSkdVO.get(i).getMnvrInHrs());
			}

			if(VSKGeneralUtil.isNotNull(psSkdVO.get(i).getMnvrOutHrs())){
				tempMnvrOutHrs = Double.parseDouble(psSkdVO.get(i).getMnvrOutHrs());
			}

			iTotManeSum += tempMnvrInHrs + tempMnvrOutHrs;
			double tempActWrkHrs = 0;
			double tempPortBufHrs = 0;
			if(VSKGeneralUtil.isNotNull(psSkdVO.get(i).getActWrkHrs())){
				tempActWrkHrs = Double.parseDouble(psSkdVO.get(i).getActWrkHrs());
			}

			if(VSKGeneralUtil.isNotNull(psSkdVO.get(i).getPortBufHrs())){
				tempPortBufHrs = Double.parseDouble(psSkdVO.get(i).getPortBufHrs());
			}

			dTotActPortSum += tempActWrkHrs + tempPortBufHrs;
			dTotServiceSpd += Double.parseDouble(psSkdVO.get(i).getLnkSpd());
		}

		dDurDay = Double.parseDouble(psSkdVO.get(0).getSvcDurDys());  // Duration 시간을 구한다
		dDurHrs = dDurDay * 24;

		data.append((int)dDurHrs);
		data.append("|");
		//Duration 날짜를 구한다
		BigDecimal bRDurDay = null;
		BigDecimal bDurDay = new BigDecimal(dDurDay);
		bRDurDay = bDurDay.setScale(1,bDurDay.ROUND_HALF_UP);
		data.append(bRDurDay.toString());
		data.append("|");

		//Sea Time 날짜를 구한다
		iTotTztmHrs = iTotTztmHrsSum;
		dTotTztmDay = iTotTztmHrsSum / 24;
		data.append(iTotTztmHrs);
		data.append("|");

		BigDecimal bRTztmDay = null;
		BigDecimal bTztmDay = new BigDecimal(dTotTztmDay);
		bRTztmDay = bTztmDay.setScale(1,bTztmDay.ROUND_HALF_UP);
		data.append(bRTztmDay.toString());
		data.append("|");

		 //Maneuvering 날짜를 구한다
		iTotManeHrs = iTotManeSum;
		dTotManeDay = iTotManeSum / 24;
		data.append(iTotManeHrs);
		data.append("|");

		BigDecimal bManeDay = null;
		BigDecimal bManeDayTemp = new BigDecimal(dTotManeDay);
		bManeDay = bManeDayTemp.setScale(1,bManeDayTemp.ROUND_HALF_UP);
		data.append(bManeDay.toString());
		data.append("|");

		 //Port Days
		dTotActPortHrs = dTotActPortSum;
		dTotActPortDay = dTotActPortHrs / 24;
		data.append(dTotActPortHrs);
		data.append("|");

		BigDecimal bActPort = null;
		BigDecimal bActPortTemp = new BigDecimal(dTotActPortDay);
		bActPort = bActPortTemp.setScale(1,bActPortTemp.ROUND_HALF_UP);
		data.append(bActPort.toString());
		data.append("|");

		//Service Speed 날짜를 구한다
		dServiceAvg = dTotServiceSpd / (psSkdVO.size()+1);

		BigDecimal bServiceAvg = null;
		BigDecimal bServiceAvgTemp = new BigDecimal(dServiceAvg);
		bServiceAvg = bServiceAvgTemp.setScale(1,bServiceAvgTemp.ROUND_HALF_UP);
		bServiceAvg.toString();

		data.append(bServiceAvg.toString());


		//Master Data
		SlotPriceVO slotPriceVO = rtnGRPVO.getSlotPriceVO();
		//Port Expense
		List<PortExpenseVO> portExpenseVOs = rtnGRPVO.getPortExpenseVOs();
		//Bunker Cost
		List<BunkerCostVO> bunkerCostTempVO = rtnGRPVO.getBunkerCostVOs();
		//Hire Base
		List<BunkerCostVO> bunkerCostVOs = new ArrayList<BunkerCostVO>();

		data2.append(portExpenseVOs.get(0).getYdCd());
		for(int i=1; i<portExpenseVOs.size(); i++){
			data2.append("|");
			data2.append(portExpenseVOs.get(i).getYdCd());
		}

		//Bunker Cost
		//조회된 데이타가 있으면 데이타를 만들고 좌측 헤더를 만들어 준다
		if(bunkerCostTempVO != null && bunkerCostTempVO.size() > 0){
			for(int i=0; i<bunkerCostTempVO.size(); i++){
				BunkerCostVO valueVO = bunkerCostTempVO.get(i);
				bunkerCostVOs.add(valueVO);
			}
			bunkerCostVOs.get(0).setLeftHeader("Daily Com.Bunker");
			bunkerCostVOs.get(1).setLeftHeader("MFO(Sea)");
			bunkerCostVOs.get(2).setLeftHeader("MFO(MAN)");
			bunkerCostVOs.get(3).setLeftHeader("MFO(Port)");
			bunkerCostVOs.get(4).setLeftHeader("Total MFO");
			bunkerCostVOs.get(5).setLeftHeader("Total Bunker Charge");
		//조회된 데이타가 없으면 좌측 헤러만 만들어 준다
		}else{
			for(int i=0; i<6; i++){
				BunkerCostVO valueVO = new BunkerCostVO();
				bunkerCostVOs.add(valueVO);
			}
			bunkerCostVOs.get(0).setLeftHeader("Daily Com.Bunker");
			bunkerCostVOs.get(1).setLeftHeader("MFO(Sea)");
			bunkerCostVOs.get(2).setLeftHeader("MFO(MAN)");
			bunkerCostVOs.get(3).setLeftHeader("MFO(Port)");
			bunkerCostVOs.get(4).setLeftHeader("Total MFO");
			bunkerCostVOs.get(5).setLeftHeader("Total Bunker Charge");
		}

		//Hire Base
		List<HireBaseVO> hireBaseTempVOs = rtnGRPVO.getHireBaseVOs();
		List<HireBaseVO> rtnHireBaseVOs = new ArrayList<HireBaseVO>();

		if(hireBaseTempVOs != null && hireBaseTempVOs.size() > 0){
			for(int i=0; i<hireBaseTempVOs.size(); i++){
				HireBaseVO valueVO = hireBaseTempVOs.get(i);
				rtnHireBaseVOs.add(valueVO);
			}

			rtnHireBaseVOs.get(0).setLeftHeader("Declared Capacity");
			rtnHireBaseVOs.get(1).setLeftHeader("Hire/TEU(Owner)");
			rtnHireBaseVOs.get(2).setLeftHeader("Hire/TEU(Charter)");
		}else{
			for(int i=0; i<3; i++){
				HireBaseVO valueVO = new HireBaseVO();
				rtnHireBaseVOs.add(valueVO);
			}
			rtnHireBaseVOs.get(0).setLeftHeader("Declared Capacity");
			rtnHireBaseVOs.get(1).setLeftHeader("Hire/TEU(Owner)");
			rtnHireBaseVOs.get(2).setLeftHeader("Hire/TEU(Charter)");
		}

		List<SlotPriceVO> slotPriceTempVOs = rtnGRPVO.getSlotPriceVOs();
		List<SlotPriceVO> slotPriceVOs = new ArrayList<SlotPriceVO>();

		if(slotPriceTempVOs != null && slotPriceTempVOs.size() > 0){
			for(int i=0; i<slotPriceTempVOs.size(); i++){
				SlotPriceVO valueVO = slotPriceTempVOs.get(i);
				slotPriceVOs.add(valueVO);
			}

			slotPriceVOs.get(0).setLeftHeader("Sub Total");
			slotPriceVOs.get(1).setLeftHeader("Slot Price(Round)");
			slotPriceVOs.get(2).setLeftHeader("Slot Price(LEG)");
		}

		//vsl_class는 기존 slot price의 데이타가 있으면 slot price(VSK_SLT_PRC_PORT_DTL)테이블의 데이타를 출력하고
		//없으면 searchPfSkd의 데이타를 출력한다
		//html의 Voyage 정보는 pfskd의 데이타를 etc_data 변화하여 추력한다

		eventResponse.setRsVo(slotPriceVO);
		eventResponse.setRsVoList(portExpenseVOs);
		eventResponse.setRsVoList(bunkerCostVOs);
		eventResponse.setRsVoList(rtnHireBaseVOs);
		eventResponse.setRsVoList(slotPriceVOs);
		eventResponse.setETCData("pfSkd", data.toString());
		eventResponse.setETCData("ydCd", data2.toString());

		return eventResponse;
	}

	/**
	 * VOP_VSK_0066 : Retrieve<br>
	 * 사용자가 해당 Service Lane에 Vessel Class 정보를 변경할 수 있기 때문에 PSO Tariff 정보를 다시 조회해야 한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calSlotPrice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SlotPriceGRPVO grpVO = null;

		if(e instanceof VopVsk0066Event){
			VopVsk0066Event event = (VopVsk0066Event)e;
			grpVO = event.getSlotPriceGRPVO();
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		SlotPriceGRPVO rtnGRPVO = command.calSlotPrice(grpVO);

		//Master Data
		SlotPriceVO slotPriceVO = rtnGRPVO.getSlotPriceVO();
		//Port Expense
		List<PortExpenseVO> portExpenseVOs = rtnGRPVO.getPortExpenseVOs();

		StringBuffer data = new StringBuffer();
		StringBuffer data2 = new StringBuffer();

		data.append(slotPriceVO.getDurHrs());
		data.append("|");
		data.append(slotPriceVO.getDurDay());
		data.append("|");
		data.append(slotPriceVO.getSeaHrs());
		data.append("|");
		data.append(slotPriceVO.getSeaDay());
		data.append("|");
		data.append(slotPriceVO.getManeHrs());
		data.append("|");
		data.append(slotPriceVO.getManeDay());
		data.append("|");
		data.append(slotPriceVO.getPortHrs());
		data.append("|");
		data.append(slotPriceVO.getPortDay());


		data2.append(portExpenseVOs.get(0).getYdCd());
		for(int i=1; i<portExpenseVOs.size(); i++){
			data2.append("|");
			data2.append(portExpenseVOs.get(i).getYdCd());
		}

		//Bunker Cost
		List<BunkerCostVO> bunkerCostVOs = rtnGRPVO.getBunkerCostVOs();
		bunkerCostVOs.get(0).setLeftHeader("Daily Com.Bunker");
		bunkerCostVOs.get(1).setLeftHeader("MFO(Sea)");
		bunkerCostVOs.get(2).setLeftHeader("MFO(MAN)");
		bunkerCostVOs.get(3).setLeftHeader("MFO(Port)");
		bunkerCostVOs.get(4).setLeftHeader("Total MFO");
		bunkerCostVOs.get(5).setLeftHeader("Total Bunker Charge");

		//Hire Base
		List<HireBaseVO> rtnHireBaseVOs = rtnGRPVO.getHireBaseVOs();
		//Slot Price
		List<SlotPriceVO> slotPriceVOs = rtnGRPVO.getSlotPriceVOs();
		slotPriceVOs.get(0).setLeftHeader("Sub Total");
		slotPriceVOs.get(1).setLeftHeader("Slot Price(Round)");
		slotPriceVOs.get(2).setLeftHeader("Slot Price(LEG)");

		eventResponse.setRsVo(slotPriceVO);
		eventResponse.setRsVoList(portExpenseVOs);
		eventResponse.setRsVoList(bunkerCostVOs);
		eventResponse.setRsVoList(rtnHireBaseVOs);
		eventResponse.setRsVoList(slotPriceVOs);
		eventResponse.setETCData("pfSkd", data.toString());
		eventResponse.setETCData("ydCd", data2.toString());

		return eventResponse;
	}

	/**
	 * VOP_VSK_0066 : Save<br>
	 * Slot Price를 저장합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSlotPrice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SlotPriceGRPVO grpVO = null;

		if(e instanceof VopVsk0066Event){
			VopVsk0066Event event = (VopVsk0066Event)e;
			grpVO = event.getSlotPriceGRPVO();
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();

		try{
			begin();

			command.manageSlotPrice(grpVO, account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());

			commit();
		}catch(EventException ex){
			rollback();

			throw ex;
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0243 : Retrieve<br>
	 * 시뮬레이션을 하고 있는 Proforma Type에 예상 정시율을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfSkdEotpSum(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PfSkdGRPVO grpVO = null;

		if(e instanceof VopVsk0243Event){
			VopVsk0243Event event = (VopVsk0243Event)e;
			grpVO = event.getPfSkdGRPVO();
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		PfSkdEotpGRPVO rtnGRPVO = command.searchPfSkdEotpSum(grpVO);

		List<PfSkdEotpSumVO> summaryVO = rtnGRPVO.getPfSkdEotpSummaryVOs();
		List<PfSkdEotpDtlVO> detailVO = rtnGRPVO.getPfSkdEotpDetailVOs();


		eventResponse.setRsVoList(summaryVO);
		eventResponse.setRsVoList(detailVO);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0243 : Retrieve<br>
	 * 시뮬레이션을 하고 있는 Proforma Type에 예상 정시율을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPfSkdEotpDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PfSkdGRPVO grpVO = null;

		if(e instanceof VopVsk0243Event){
			VopVsk0243Event event = (VopVsk0243Event)e;
			grpVO = event.getPfSkdGRPVO();
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		PfSkdEotpGRPVO rtnGRPVO = command.searchPfSkdEotpDtl(grpVO);

		//List<PfSkdEotpSummaryVO> summaryVO = rtnGRPVO.getPfSkdEotpSummaryVOs();
		List<PfSkdEotpDtlVO> detailVO = rtnGRPVO.getPfSkdEotpDetailVOs();


		//eventResponse.setRsVoList(summaryVO);
		eventResponse.setRsVoList(detailVO);

		return eventResponse;
	}


//	/**
//	 * VOP_VSK_0206 : Popup Open
//	 * 전배가 계획으로 발생할 수 있는 Cost 정보를 조회합니다.
//	 *
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchPhsIOSkdCost(Event e) throws EventException {
//		VopVsk0206Event event = (VopVsk0206Event)e;
//		VskSwapCstCostVO vo = event.getVskSwapCstCostVO();
//
//		LongRangeScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//		List<VskSwapCstCostVO> list = command.searchPhsIOSkdCost(vo.getSimNo(), vo.getSimDt());
//
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		if(list.size()==0){
//			eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Transfer Cost"}).getUserMessage());
//		}
//
//		eventResponse.setRsVoList(list);
//		return eventResponse;
//	}

	/**
	 * VOP_VSK_0024 : Retrieve<br>
	 * 운하별 통항 선박의 스케뷸 및 Surcharge를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanalTzList(Event e) throws EventException {
		VopVsk0024Event event = (VopVsk0024Event)e;
		CanalTransitTargetVvdVO vo = event.getCanalTransitTargetVvdVO();

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<CanalTransitTargetVvdVO> list = command.searchCanalTzList(vo);

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//String port = vo.getPortCd();
//		if(list.size()==0){
//			eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Canal Transit Surcharge"}).getUserMessage());
//		}
		
		/* PSO 														*/ 
		/* 2014.10.08 Canal Transit List 							*/
		/* Modify by :: kang jihye..								*/
		/*
		String esti_trf = "";
		String esti_trf_diff = "";
		String cost_cd = "CNTFCT";
		String acct_cd = "511911";
		String vndr_seq = "2132";
		int amt = 0;
		String st_amt = "";
		GeneralInvoiceAuditBC command_pso = new GeneralInvoiceAuditBCImpl();
		
		HashMap<String, SimulationObjectListVO> autoObjMap = new HashMap<String, SimulationObjectListVO>();
		HashMap<String, SimulationObjectListVO> manuObjMap = new HashMap<String, SimulationObjectListVO>();
		
		HashMap<String, SimulationObjectListVO> autoObjMap_diff = new HashMap<String, SimulationObjectListVO>();
		HashMap<String, SimulationObjectListVO> manuObjMap_diff = new HashMap<String, SimulationObjectListVO>();

		//CalcTariffVO calcTariffVO = new CalcTariffVO();
		if( list.size() > 0 && port.equals("EGSUZ")){
			for( int i = 0 ; i < list.size() ; i++ ){
				
				String mTier = list.get(i).getScgCarTier();
				if(mTier.length() > 0){  
				
				String vsl_cd = list.get(i).getVslCd();
				String skd_voy_no = list.get(i).getSkdVoyNo();
				String skd_dir_cd = list.get(i).getSkdDirCd();
				String port_cd = vo.getPortCd();
				String yd_cd = list.get(i).getYdCd().substring(5, 7);
				String issue_dt = vo.getStartDate();//list.get(i).getStartDate();
				
				SimulationConditionVO simVo = new SimulationConditionVO();
				
				simVo.setVslCd(vsl_cd);
				simVo.setSkdVoyNo(skd_voy_no);
				simVo.setSkdDirCd(skd_dir_cd);
				simVo.setPortCd(port_cd);
				simVo.setYardCd(yd_cd);
				simVo.setCostCd(cost_cd);
				simVo.setAcctCd(acct_cd);
				simVo.setIssueDate(issue_dt);
				simVo.setVndrSeq(vndr_seq);
				
				List<TariffInfoVO> tariff_list =command_pso.getTariff(simVo);
				if( tariff_list.size() > 0 ){
					SimulationConditionVO[] simVos =  new SimulationConditionVO[tariff_list.size()];
					
					
					for( int j = 0 ; j < tariff_list.size() ; j++ ){
						
						String yd_chg_no = tariff_list.get(j).getYdChgNo();
						String yd_chg_ver_seq = tariff_list.get(j).getYdChgVerSeq();
						String curr_cd = tariff_list.get(j).getCurrCd();
						String t_acct_cd = tariff_list.get(j).getAcctCd();
						String t_cost_cd = tariff_list.get(j).getCostCd();
						String t_vndr_seq = tariff_list.get(j).getVndrSeq();
						String t_vndr_lgl_eng_nm = tariff_list.get(j).getVndrLglEngNm();
						
						
						simVo.setVslCd(vsl_cd);
						simVo.setSkdVoyNo(skd_voy_no);
						simVo.setSkdDirCd(skd_dir_cd);
						simVo.setVvd(vsl_cd+skd_voy_no+skd_dir_cd);
						simVo.setYdChgNo(yd_chg_no);
						simVo.setYdChgVerSeq(yd_chg_ver_seq);
						simVo.setYardCd(yd_cd);
						simVo.setCostCd(t_cost_cd);
						simVo.setCurrCd(curr_cd);
						
						simVos[j] = simVo;
						
					}
						List<SimulationObjectListVO> objectsList = command_pso.searchObjectListBySimulation(simVo, simVos);
						///////////////////////////////////////////		
						String tempObj = null;
						
						// tariff simulation의 화면과 같이 12(FLAG), 14(CODE), 17(DAY), 16(DATE)의 DfltVal 변환
						for(int a=0; a<objectsList.size(); a++){
							
							// acct_cd가 all일 때는 IN & OUT 의 value는 "Y"
							if("77".equals(objectsList.get(a).getObjListNo()) || "89".equals(objectsList.get(a).getObjListNo())){
								objectsList.get(a).setDfltVal("Y");
							}
							
							tempObj = objectsList.get(a).getPsoMeasUtCd();
												
							if("12".equals(tempObj) || "14".equals(tempObj) || "17".equals(tempObj)){
								tempObj = objectsList.get(a).getDfltVal().replaceAll("'", "");
								objectsList.get(a).setDfltVal("'" + tempObj + "'");
							}else if("16".equals(tempObj)){
								tempObj = objectsList.get(a).getDfltVal().replaceAll("'", "");
								objectsList.get(a).setDfltVal("TO_DATE(" + "'" + tempObj + "'" + ", 'YYYYMMDD')");
							}
							
						}
						
						List<SimulationObjectListVO> autoObjectList = new ArrayList<SimulationObjectListVO>();
						List<SimulationObjectListVO> manualObjectList = new ArrayList<SimulationObjectListVO>();
						
						for(int t=0; t<objectsList.size(); t++){
							if("A".equals(objectsList.get(t).getPsoObjListTpCd())){
								autoObjMap.put(objectsList.get(t).getObjListNo(), objectsList.get(t)); 
							} else if("M".equals(objectsList.get(t).getPsoObjListTpCd())){
								if( "115".equals(objectsList.get(t).getObjListNo())){
									
									SimulationObjectListVO tmp1 = new SimulationObjectListVO();
									
									tmp1.setObjListNo(objectsList.get(t).getObjListNo());
									tmp1.setObjListNm(objectsList.get(t).getObjListNm());
									tmp1.setDfltVal(list.get(i).getScgCarTier());
									tmp1.setPsoObjListTpCd(objectsList.get(t).getPsoObjListTpCd());
									tmp1.setRegVal(list.get(i).getScgCarTier());
									tmp1.setPsoMeasUtCd(objectsList.get(t).getPsoMeasUtCd());
									tmp1.setPsoMeasUtNm(objectsList.get(t).getPsoMeasUtNm());
									
									manuObjMap.put(objectsList.get(t).getObjListNo(), tmp1);
										
								}else{
									manuObjMap.put(objectsList.get(t).getObjListNo(), objectsList.get(t));
								}
							}
						}
						
						for(SimulationObjectListVO simulationObjectListVO : autoObjMap.values()){
							autoObjectList.add(simulationObjectListVO);
						}
						
						for(SimulationObjectListVO simulationObjectListVO : manuObjMap.values()){
							manualObjectList.add(simulationObjectListVO);
						}
						
						
						simVo.setYardCd(list.get(i).getYdCd());
						simVo.setIssueDate(list.get(i).getVpsEtbDt());
						List<CalcTariffResultVO> calVOs = command_pso.calculateTariff(simVo,simVos, autoObjectList.toArray(new SimulationObjectListVO[autoObjectList.size()]),
	                              																	manualObjectList.toArray(new SimulationObjectListVO[manualObjectList.size()]));
					
						st_amt=calVOs.get(0).getDisplayFormulaDesc();
						
						if( st_amt.length() > 0 ){
							String[] str = st_amt.split("\n");
							esti_trf = str[1].replace("[S]:", "");
						}
						/////////////////////////////////////////////////////////////
						//Diff Surcharge 를 구하기 위해서는 BayPlan에 Tier정보가 존재할 경우만 구한다.//
						/////////////////////////////////////////////////////////////
						
						
						
						List<SimulationObjectListVO> autoObjectList_diff = new ArrayList<SimulationObjectListVO>();
						List<SimulationObjectListVO> manualObjectList_diff = new ArrayList<SimulationObjectListVO>();
						
						for(int r=0; r<objectsList.size(); r++){
							if("A".equals(objectsList.get(r).getPsoObjListTpCd())){
								autoObjMap_diff.put(objectsList.get(r).getObjListNo(), objectsList.get(r)); 
							} else if("M".equals(objectsList.get(r).getPsoObjListTpCd())){
								if( "115".equals(objectsList.get(r).getObjListNo())){
									
									int tier = Integer.parseInt(mTier)-1;
									//objectsList.get(t).setRegVal(""+tier);
									
									SimulationObjectListVO tmp = new SimulationObjectListVO();
									
									tmp.setObjListNo(objectsList.get(r).getObjListNo());
									tmp.setObjListNm(objectsList.get(r).getObjListNm());
									tmp.setDfltVal("" + tier);
									tmp.setPsoObjListTpCd(objectsList.get(r).getPsoObjListTpCd());
									tmp.setRegVal("" + tier);
									tmp.setPsoMeasUtCd(objectsList.get(r).getPsoMeasUtCd());
									tmp.setPsoMeasUtNm(objectsList.get(r).getPsoMeasUtNm());
									
									manuObjMap_diff.put(objectsList.get(r).getObjListNo(), tmp);
								}else{
									manuObjMap_diff.put(objectsList.get(r).getObjListNo(), objectsList.get(r));
								}
							}
						}
						
						for(SimulationObjectListVO simulationObjectListVO : autoObjMap_diff.values()){
							autoObjectList_diff.add(simulationObjectListVO);
						}
						
						for(SimulationObjectListVO simulationObjectListVO : manuObjMap_diff.values()){
							manualObjectList_diff.add(simulationObjectListVO);
						}
													
						List<CalcTariffResultVO> calVOs_diff = command_pso.calculateTariff(simVo,simVos, autoObjectList_diff.toArray(new SimulationObjectListVO[autoObjectList_diff.size()]),
	                              																	manualObjectList_diff.toArray(new SimulationObjectListVO[manualObjectList_diff.size()]));
					
						String st_amt_diff = calVOs_diff.get(0).getDisplayFormulaDesc();
						
						if( st_amt_diff.length() > 0 ){
							String[] str_diff = st_amt_diff.split("\n");
							esti_trf_diff = str_diff[1].replace("[S]:", "");
						}
					
				}
				
				
				list.get(i).setScgCarEstiScg(esti_trf);
				list.get(i).setScgCarDiffScg(esti_trf_diff);

			}
			}
		
		}
		*/
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * VOP_VSK_0024 : Window Open<br>
	 * Vendor 리스트를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorList(Event e) throws EventException {

		VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();
		//int vndrSeq  = -1;
		CanelRegistGRPVO grpVO = command.searchLaneListByCanalAgency();
		List<VendorVO> list = grpVO.getVendorVOs();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if(list.size()==0){
			eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Canal Service Provider"}).getUserMessage());
		}else{
			StringBuilder vendorSeqList = new StringBuilder();
			StringBuilder vendorNmList = new StringBuilder();
			for(int i=0; i<list.size(); i++){
				VendorVO vo = list.get(i);
				vendorSeqList.append(vo.getVndrSeq());
				vendorNmList.append(vo.getVndrAbbrNm());
				if(i!=list.size()-1){
					vendorSeqList.append("|");
					vendorNmList.append("|");
				}
			}
			eventResponse.setETCData("vendorSeq", vendorSeqList.toString());
			eventResponse.setETCData("vendorNm", vendorNmList.toString());
		}
		return eventResponse;
	}

	/**
	 * VOP_VSK_0024 : Send to SPP<br>
	 * 운하별 통항 선박의 스케뷸 및 Surcharge 정보를 SPP로 전달합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCanalTzList(Event e) throws EventException {
		VopVsk0024Event event = (VopVsk0024Event)e;
		BudgetPortChargeMgtBC command = new BudgetPortChargeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			begin();

			CanalTransitTargetVvdVO  canalTransitTargetVvdVO = event.getCanalTransitTargetVvdVO();
			String portCd = canalTransitTargetVvdVO.getPortCd();
			String targetDate = canalTransitTargetVvdVO.getStartDate().substring(0, 7); // YYYY-MM 까지 추출

			if("TBCreate".equals(canalTransitTargetVvdVO.getBkgSts())){
				command.sendToSppTargetVvd(portCd, targetDate, true, account);
			}else{
				command.sendToSppTargetVvd(portCd, targetDate, false, account);
			}
			eventResponse.setUserMessage(new ErrorHandler("VSK10032", new String[]{"SPP"}).getUserMessage());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return eventResponse;

	}
	
	/**
	 * VOP_VSK_0024 : Save<br>
	 * Panama 운하의 통항을 위한 Booking 정보를 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCanalTzBkg(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		CoastalScheduleMgtBC 	command 		= new VesselScheduleMgtBCImpl();
		
		VopVsk0024Event event = (VopVsk0024Event)e;
		CanalTransitTargetVvdVO[] 		paramVOs 		= null;
		paramVOs = event.getCanalTransitTargetVvdVOS();
		
		try{
			begin();
			command.manageCanalTzBkg(paramVOs, account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
        } catch (EventException ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("VSK10018", new String[]{"Canal Transit List Booking Info"}).getMessage(), ex);
        }
		return eventResponse;
	}


	/**
	 * VOP_VSK_0246 : Window OPEN<br>
	 * 선박의 최대 선속으로 인한 Bunker 비용과 Canal Surcharge 비용 차이를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calCanalBunkerSaving(Event e) throws EventException {
		VopVsk0246Event event = (VopVsk0246Event)e;
		CanalBnkSavVO canalBnkSavVO = event.getCanalBnkSavVO();

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<CanalBnkSavVO> list = command.calCanalBunkerSaving(canalBnkSavVO);

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		if(list==null || list.size()==0){
			eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Canal Transit Surcharge Detail"}).getUserMessage());
		}

		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * VOP_VSK_0001, VOP_VSK_0003 : Retrieve<br>
	 * Port 정보를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<YardVO> list = null;
		YardVO yardVO = null;
		PfSkdVO pfSkdVO = null;

		if(e instanceof VopVsk0001Event){
			VopVsk0001Event event = (VopVsk0001Event)e;
			pfSkdVO = event.getPfSkdVO();
			yardVO = new YardVO();
			yardVO.setLocCd(pfSkdVO.getLocCd());
		}else if(e instanceof VopVsk0003Event){
			VopVsk0003Event event = (VopVsk0003Event)e;
			pfSkdVO = event.getPfSkdVO();
			yardVO = new YardVO();
			yardVO.setLocCd(pfSkdVO.getLocCd());
		}

		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		ProformaScheduleMgtBC proformaCommand = new ProformaScheduleMgtBCImpl();

		String chkPort = null;
		
		if (pfSkdVO != null) {
			chkPort = command.checkPort(pfSkdVO.getLocCd());
		}

		if(chkPort != null && !"".equals(chkPort)){
			list = command.searchYardListByPort(yardVO);

			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			if(list != null && list.size() > 0){
				if(e instanceof VopVsk0001Event || e instanceof VopVsk0003Event ||e instanceof VopVsk0053Event){
					sb.append(" ");
					sb1.append(" ");
					sb2.append(" ");
					for (int i = 0; i < list.size(); i++) {
						sb.append("|");
						sb1.append("|");
						sb2.append("|");
						sb.append(list.get(i).getYdKind());
						sb1.append(list.get(i).getYdCd());
						sb2.append(list.get(i).getYdNm());
					}
				}else{
					sb.append(list.get(0).getYdKind());
					sb1.append(list.get(0).getYdCd());
					sb2.append(list.get(0).getYdNm());
					for (int i = 1; i < list.size(); i++) {
						sb.append("|");
						sb1.append("|");
						sb2.append("|");
						sb.append(list.get(i).getYdKind());
						sb1.append(list.get(i).getYdCd());
						sb2.append(list.get(i).getYdNm());
					}
				}
			}

			List<PfSkdVO> pfSkdVOs = new ArrayList<PfSkdVO>();
			int portCnt = 0;
			String dataPos = null;
			
			if (pfSkdVO != null) {
				portCnt = Integer.parseInt(pfSkdVO.getPortInfoCnt());
				dataPos = pfSkdVO.getDataPos();
			}

			if(portCnt == 1){
				PfSkdVO paramVO = new PfSkdVO();
				if("S".equals(dataPos) && pfSkdVO != null){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("T".equals(dataPos) && pfSkdVO != null){
					paramVO.setPortCd(pfSkdVO.getSecondPortCd());
					paramVO.setPodLocCd(pfSkdVO.getThirdPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("F".equals(dataPos) && pfSkdVO != null){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("E".equals(dataPos) && pfSkdVO != null){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}
				pfSkdVOs.add(paramVO);
			}else if(portCnt > 1){
				PfSkdVO firstParamVO = new PfSkdVO();
				if (pfSkdVO != null) {
					firstParamVO.setPortCd(pfSkdVO.getFirstPortCd());
					firstParamVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					firstParamVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}
				pfSkdVOs.add(firstParamVO);
				PfSkdVO secondParamVO = new PfSkdVO();
				if (pfSkdVO != null) {
					secondParamVO.setPortCd(pfSkdVO.getSecondPortCd());
					secondParamVO.setPodLocCd(pfSkdVO.getThirdPortCd());
					secondParamVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}
				pfSkdVOs.add(secondParamVO);
			}

			List<PfSkdVO> profomaList = proformaCommand.searchPortInfo(pfSkdVOs);
			if(profomaList != null && profomaList.size() > 0){
				if(profomaList.size() == 1){
					//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
					eventResponse.setETCData("one_row", profomaList.get(0).getLnkDist()+"|"+profomaList.get(0).getFmZd()+"|"+profomaList.get(0).getToZd()+"|"+profomaList.get(0).getPortBufHrs()+"|"+profomaList.get(0).getCrnKnt()+"|"+profomaList.get(0).getTmlProdQty());
				}else{
					//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
					eventResponse.setETCData("one_row", profomaList.get(0).getLnkDist()+"|"+profomaList.get(0).getFmZd()+"|"+profomaList.get(0).getToZd()+"|"+profomaList.get(0).getPortBufHrs()+"|"+profomaList.get(0).getCrnKnt()+"|"+profomaList.get(0).getTmlProdQty());
					//TWO_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
					eventResponse.setETCData("two_row", profomaList.get(1).getLnkDist()+"|"+profomaList.get(1).getFmZd()+"|"+profomaList.get(1).getToZd()+"|"+profomaList.get(1).getPortBufHrs()+"|"+profomaList.get(1).getCrnKnt()+"|"+profomaList.get(1).getTmlProdQty());
				}

				if (pfSkdVO != null) {
					//그리드에 데이타를 출력한 로우 갯수
					eventResponse.setETCData("portInfoCnt", pfSkdVO.getPortInfoCnt());
					//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
					eventResponse.setETCData("currPos", pfSkdVO.getCurrPos());
					//전 포트가 존재 하지 않기때문에 자기 자신의 현재 포트에 데이타를 출력한다 S = SELF
					eventResponse.setETCData("dataPos", pfSkdVO.getDataPos());
				}
			}

		eventResponse.setETCData("yd_kind", sb.toString());
			eventResponse.setETCData("yd_cd", sb1.toString());
			eventResponse.setETCData("yd_nm", sb2.toString());
		}else{
			eventResponse.setETCData("yd_kind", "");
			eventResponse.setETCData("yd_cd", "");
			eventResponse.setETCData("yd_nm", "");
		}

		eventResponse.setETCData("check_port", chkPort);
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0001, VOP_VSK_0003, VOP_VSK_0053, VOP_VSK_0015 : Retrieve
	 * Yard 정보를 조회합니다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<YardVO> list = null;
		YardVO yardVO = null;

		if(e instanceof VopVsk0001Event){
			VopVsk0001Event event = (VopVsk0001Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0003Event){
			VopVsk0003Event event = (VopVsk0003Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0053Event){
			VopVsk0053Event event = (VopVsk0053Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			yardVO = event.getYardVO();
		}

		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		list = command.searchYardList(yardVO);

		if(e instanceof VopVsk0015Event){
			if(list != null && list.size() > 0){
				// VSK_PORT_MNVR 테이블에 해당 Yard에 대한 manuvering time이 등록되어 있지 않은 경우, 즉 0인 경우
				// 1 시간씩 가지도록 수정한다.
				String mnvrInHrs = list.get(0).getMnvrInHrs();
				String mnvrOutHrs = list.get(0).getMnvrOutHrs();

				if("0".equals(mnvrInHrs)){
					mnvrInHrs = "1";
				}

				if("0".equals(mnvrOutHrs)){
					mnvrOutHrs = "1";
				}

				eventResponse.setETCData("mnvr_in_hrs", mnvrInHrs);
				eventResponse.setETCData("mnvr_out_hrs", mnvrOutHrs);
			}
		}else{
			if(list != null && list.size() > 0){
				eventResponse.setETCData("mnvr_in_hrs", list.get(0).getMnvrInHrs());
				eventResponse.setETCData("mnvr_out_hrs", list.get(0).getMnvrOutHrs());
			}
		}

		return eventResponse;
	}

	/**
	 * VOP_VSK_0003, VOP_VSK_0053 : Delete<br>
	 * P/F Schedule 정보를 삭제합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removePfSkd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskPfSkdVO vskPfSkdVO = null;

		if(e instanceof VopVsk0003Event){
			VopVsk0003Event event = (VopVsk0003Event)e;
			vskPfSkdVO = event.getVskPfSkdVO();
		}else if(e instanceof VopVsk0053Event){
			VopVsk0053Event event = (VopVsk0053Event)e;
			vskPfSkdVO = event.getVskPfSkdVO();
			if(vskPfSkdVO.getSimDt() == null || "".equals(vskPfSkdVO.getSimDt())){
				vskPfSkdVO.setSimDt(" ");
			}
			if(vskPfSkdVO.getSimNo() == null || "".equals(vskPfSkdVO.getSimNo())){
				vskPfSkdVO.setSimNo(" ");
			}
		}
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();

		try{
			begin();

			command.removePfSkd(vskPfSkdVO, account);

			eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());

			commit();
		}catch(EventException ex){
			rollback();

			throw ex;
		}
		return eventResponse;
	}

	/**
	 * VOP_VSk_0241 : Retrieve<br>
	 * Lane Code가 유효한지 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSvcLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskPfSkdVO vskPfSkdVO = null;
		MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
		if(e instanceof VopVsk0241Event){
			VopVsk0241Event event = (VopVsk0241Event)e;
			vskPfSkdVO = event.getVskPfSkdVO();
			vo.setVslSlanCd(vskPfSkdVO.getVslSlanCd());
		}
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<MdmVslSvcLaneVO> list = command.checkSvcLane(vo);
		StringBuffer data = new StringBuffer();
		String vslSvcTpCd = "";

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				data.append(list.get(i).getVslSlanNm());
				vslSvcTpCd = list.get(i).getVslSvcTpCd();
				if (i < list.size()-1)
					data.append("|");
			}
			eventResponse.setETCData("checkLane", data.toString());
			eventResponse.setETCData("checkLaneTpCd", vslSvcTpCd);
		}else{
			eventResponse.setUserMessage(new ErrorHandler("VSK10019").getUserMessage());
		}

		return eventResponse;
	}

	/**
	 * VOP_VSK_0001 : Save<br> 
	 * COA SAVE
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCoaSimRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		PfSkdGRPVO grpVO = null;
		String newSimData = "";

		if(e instanceof VopVsk0001Event){
			VopVsk0001Event event = (VopVsk0001Event)e;
			grpVO = event.getPfSkdGRPVO();
			List<VskPfSkdDtlVO> vskPfSkdDtls = grpVO.getVskPfSkdDtlVOs();
			newSimData = vskPfSkdDtls.get(0).getNewSimData();
		}

		try{

			begin();
			
			List<MasSimInfoVO>  coaSimInfoVOs = command.createCoaSimRqst(grpVO, newSimData, account);
			if(coaSimInfoVOs != null && coaSimInfoVOs.size() > 0){

				String simDt = coaSimInfoVOs.get(0).getSimDt();
				String simNo = coaSimInfoVOs.get(0).getSimNo();
				
				log.debug("--------yyyyyyyy--------["+coaSimInfoVOs.get(0).getSimDt()+"]--["+coaSimInfoVOs.get(0).getSimNo()+"]--------");

				eventResponse.setETCData("simDt", simDt);
				eventResponse.setETCData("simNo", simNo);
//				eventResponse.setETCData("simNo", simNo);

				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());

			}

			commit();

		}catch(EventException ex){
			rollback();

			throw ex;
		}

		return eventResponse;
	}

	/**
	 * VOP_VSk_0001 : P/F Type Cd Change시<br>
	 * P/F Type Cd가 존재하는지 여부.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPfType(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskPfSkdVO vskPfSkdVO = null;
		if(e instanceof VopVsk0001Event){
			VopVsk0001Event event = (VopVsk0001Event)e;
			vskPfSkdVO = event.getVskPfSkdVO();
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		String checkPfTypeData = command.checkPfType(vskPfSkdVO);

		if(!"".equals(checkPfTypeData)){
			eventResponse.setETCData("pfTypeData", checkPfTypeData);
		}

		return eventResponse;
	}

	/**
	 * VOP_VSK_0018 : Save<br>
	 * 해당 VVD의 P/F Type 정보를 수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Hyuk Ryu
	 * @date 2009. 11. 11.
	 */
	private EventResponse manageVvdPf(Event e) throws EventException {
		
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<ActivationVvdVO> activationVvdVOs = null;
			if(e instanceof VopVsk0018Event){
				VopVsk0018Event event = (VopVsk0018Event)e;
				activationVvdVOs = Arrays.asList(event.getActivationVvdVOS());
			}

			if (activationVvdVOs != null) {
				for(ActivationVvdVO vo : activationVvdVOs){
					vo.setUpdUsrId(account.getUsr_id());
				}
			}

			LongRangeScheduleMgtBC command = new VesselScheduleMgtBCImpl();
			command.manageVvdPf(activationVvdVOs);

			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			return eventResponse;
			
		}catch(EventException ex){
			rollback();
			log.error("err " + e.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	} 

	/**
	 * VOP_VSK_0001, VOP_VSK_000 : Row Delete<br>
	 * 선택한 로우(들)을 삭제하고 존재하는 포트에 대한 정보를 재 조합한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calRowDelete(Event e) throws EventException {
		PfSkdGRPVO grpVO = null;
		VskPfSkdVO masterVO = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			if(e instanceof VopVsk0001Event){
				VopVsk0001Event event = (VopVsk0001Event)e;
				grpVO = event.getPfSkdGRPVO();
				masterVO = grpVO.getVskPfSkdVO();
			}else if(e instanceof VopVsk0003Event){
				VopVsk0003Event event = (VopVsk0003Event)e;
				grpVO = event.getPfSkdGRPVO();
				masterVO = grpVO.getVskPfSkdVO();
			}

			ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
			List<VskPfSkdDtlVO> dtlVOs = command.calRowDelete(grpVO);
			StringBuffer sb = new StringBuffer();

			if(dtlVOs.size() > 0 && dtlVOs != null){
				sb.append(dtlVOs.get(0).getYdCd());
				for(int i=1; i<dtlVOs.size(); i++){
					sb.append("|");
					sb.append(dtlVOs.get(i).getYdCd());
				}


				eventResponse.setRsVo(masterVO);
				eventResponse.setRsVoList(dtlVOs);
				eventResponse.setETCData("ydCd", sb.toString());
			}




			return eventResponse;
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * EDI011-0001 : Receive<br>
	 * VesdSettingReceiveJMS<br>
	 * @param  e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse esdSettingReceiveJMS(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskCustSkdEdiSetVO[] vskCustSkdEdiSetVOs = null;
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();

		if(e instanceof SchedulePlanningOperationEvent){
			SchedulePlanningOperationEvent event = (SchedulePlanningOperationEvent)e;
			vskCustSkdEdiSetVOs = event.getVskCustSkdEdiSetVOs();
		}

		try{
			begin();

			command.esdSettingReceiveJMS(vskCustSkdEdiSetVOs);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());	//
		}

		return eventResponse;

	}

	/*
	 * CHM-201007135-01
	 */
	/**
	 * VOP_VSK_0018 : crr_cd 입력<br>
	 * @param  e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrrCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VopVsk0018Event event = (VopVsk0018Event)e;
		try{
			String strRet = command.searchCrrCd(event.getCrrCd());
			eventResponse.setETCData("crr_cd", strRet);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());	//
		}
		return eventResponse;
	}

	/**
	 * PF 사용하여 SKD 생성하려고 할 때, 삭제된 yard가 존재하는지 check한다.
	 * @param  e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkDeltYardByPF(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongRangeScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		String vslSlanCd = null;
		String pfSvcTpCd = null;
		try{
			if(e instanceof VopVsk0010Event){
				VopVsk0010Event event = (VopVsk0010Event)e;
				vslSlanCd = event.getLongRangeSkdGRPVO().getVslSlanCd();
				pfSvcTpCd = event.getLongRangeSkdGRPVO().getPfSvcTpCd();
//			}else if(e instanceof VopVsk0014Event){
//				VopVsk0014Event event = (VopVsk0014Event)e;
//				CstSkdByVvdVO paramVO = event.getCstSkdByVvdVO();
//				vslSlanCd = paramVO.getVslSlanCd();
//				pfSvcTpCd = paramVO.getPfSvcTpCd();
			}
			List<String> list = command.checkDeltYardByPF(vslSlanCd, pfSvcTpCd);
			StringBuilder ydList = new StringBuilder();
			if(list.size()>0){
				for(int i=0; i<list.size(); i++){
					if(i==0){
						ydList.append(list.get(i));
					}else{
						ydList.append(", ");
						ydList.append(list.get(i));
					}
				}
			}
			eventResponse.setETCData("yd_list", ydList.toString());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}


	/**
	 * VOP_VSK_0021 : Open<BR>
	 * Port 정보를 관리하는 상위 Office 정보를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRhqList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<OfficeVO> list = null;

		list = command.searchRhqList();

		StringBuilder sb = new StringBuilder();
		if(list != null){
			sb.append(list.get(0).getPrntOfcCd());
			for(int i=1; i<list.size(); i++){
				sb.append("|"+list.get(i).getPrntOfcCd());
			}
		}
		eventResponse.setETCData("rhq_list", sb.toString());
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0021 : CTRL H/Q 선택시<br>
	 * RHQ산하에 있는 Control Office Code 정보를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchControlOfficeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		MdmLocationVO paramVO = null;
		List<LocationVO> list = null;

		if(e instanceof VopVsk0021Event){
			VopVsk0021Event event = (VopVsk0021Event)e;
			paramVO = event.getMdmLocationVO();
		}

		if (paramVO != null) {
			list = command.searchYardCtrlOfficeList(paramVO.getVskdPortRhqCd());
		}

		StringBuilder sb = new StringBuilder();
		if(list != null){
			sb.append(list.get(0).getVopPortCtrlOfcCd());
			for(int i=1; i<list.size(); i++){
				sb.append("|"+list.get(i).getVopPortCtrlOfcCd());
			}
		}
		eventResponse.setETCData("ctrl_ofc_list", sb.toString());
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0021 : Retrieve<br>
	 * 입력된 Month/Week에 해당하는 날짜를 조회한다.
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		SearchDateVO dateVO = null;
		List<SearchDateVO> list = null;

		if(e instanceof VopVsk0021Event){
			VopVsk0021Event event = (VopVsk0021Event)e;
			dateVO = event.getSearchDateVO();
		}

		list = command.searchDate(dateVO);

		StringBuilder sb = new StringBuilder();
		if(list != null){
			sb.append(list.get(0).getRtnDate());
			for(int i=1; i<list.size(); i++){
				sb.append("|"+list.get(i).getRtnDate());
			}
		}
		eventResponse.setETCData("rtn_date", sb.toString());
		eventResponse.setRsVoList(list);

		return eventResponse;
	}

	/**
	 * VOP_VSK_0021 : Group을 Setting한 User가 화면을 오픈했을 경우<br>
	 * User별 Group을 조회 한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLanePortGroupByUserId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0021Event event = (VopVsk0021Event)e;
		VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();

		try{
			UserDefinedLanePortGroupVO userDefinedLanePortGroupVO = event.getUserDefinedLanePortGroupVO();
			String usr_id = userDefinedLanePortGroupVO.getUsrId();

			List<UserDefinedLanePortGroupVO> list = command.searchLanePortGroupByUserId(usr_id);
			StringBuffer sb = new StringBuffer();

			if(list != null && list.size() > 0){
				sb.append(list.get(0).getUsrDefGrpNm());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getUsrDefGrpNm());
				}
			}

			eventResponse.setETCData("grp_nm", sb.toString());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [VOP_VSK_0095] Retrive<br>
	 * ERP로 전송 할 VVD SKD 목록을 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslSkdRepeatErpIf(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VopVsk0095Event 		event 			= (VopVsk0095Event)e;
		CoastalScheduleMgtBC 	command 		= new VesselScheduleMgtBCImpl();

		try{
			List<VslSkdRepeatErpIfVO> list = command.searchVslSkdRepeatErpIf(event.getVslSkdRepeatErpIfVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [VOP_VSK_0095] I/F to ERP<br>
	 * 선택된 VVD SKD 목록을 ERP로 전송<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendVslSkdRepeatErpIf(Event e) throws EventException {
		
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VopVsk0095Event 		event 			= (VopVsk0095Event)e;
		CoastalScheduleMgtBC 	command 		= new VesselScheduleMgtBCImpl();

		try{
			
			for (VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO: event.getVslSkdRepeatErpIfVOs()) {
				begin();
				VvdVO vvdVO 		= new VvdVO();
				vvdVO.setVslSlanCd	(vslSkdRepeatErpIfVO.getVslSlanCd());
				vvdVO.setVslCd		(vslSkdRepeatErpIfVO.getVslCd());
				vvdVO.setSkdVoyNo	(vslSkdRepeatErpIfVO.getSkdVoyNo());
				vvdVO.setSkdDirCd	(vslSkdRepeatErpIfVO.getSkdDirCd());
				vvdVO.setCreUsrId	(account.getUsr_id());
				vvdVO.setUpdUsrId	(account.getUsr_id());
				
				command.sendVslSkdRepeatErpIf(vvdVO);
				commit();
			}
			
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * VOP_VSK_0024 : Retrieve<br>
	 * 운하별 통항 선박의 스케뷸 및 Surcharge를 조회합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanalTzListScg(Event e) throws EventException {
		VopVsk0024Event event = (VopVsk0024Event)e;
		CanalTransitTargetVvdVO vo = event.getCanalTransitTargetVvdVO();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		/* PSO 														*/ 
		/* 2014.10.08 Canal Transit List 							*/
		/* Modify by :: kang jihye..								*/
		String esti_trf = "";
		String esti_trf_diff = "";
		
		String cost_cd = "CNTFCT";
		String acct_cd = "511911";
		String vndr_seq = "2132";

		String st_amt = "";
		GeneralInvoiceAuditBC command_pso = new GeneralInvoiceAuditBCImpl();
		
		HashMap<String, SimulationObjectListVO> autoObjMap = new HashMap<String, SimulationObjectListVO>();
		HashMap<String, SimulationObjectListVO> manuObjMap = new HashMap<String, SimulationObjectListVO>();
		
		HashMap<String, SimulationObjectListVO> autoObjMap_diff = new HashMap<String, SimulationObjectListVO>();
		HashMap<String, SimulationObjectListVO> manuObjMap_diff = new HashMap<String, SimulationObjectListVO>();
		
		//int i=0;
		//CalcTariffVO calcTariffVO = new CalcTariffVO();
		if(vo != null ){
			//for( int i = 0 ; i < list.size() ; i++ ){
				
				String mTier = vo.getScgCarTier();
				
				String vsl_cd = vo.getVslCd();
				String skd_voy_no = vo.getSkdVoyNo();
				String skd_dir_cd = vo.getSkdDirCd();
				String port_cd = vo.getPortCd();
				String yd_cd = vo.getYdCd().substring(5, 7);
				String issue_dt = vo.getStartDate();//list.get(i).getStartDate();
				
				SimulationConditionVO simVo = new SimulationConditionVO();
				
				simVo.setVslCd(vsl_cd);
				simVo.setSkdVoyNo(skd_voy_no);
				simVo.setSkdDirCd(skd_dir_cd);
				simVo.setPortCd(port_cd);
				simVo.setYardCd(yd_cd);
				simVo.setCostCd(cost_cd);
				simVo.setAcctCd(acct_cd);
				simVo.setIssueDate(issue_dt);
				simVo.setVndrSeq(vndr_seq);
				
				List<TariffInfoVO> tariff_list =command_pso.getTariff(simVo);
				if( tariff_list.size() > 0 ){
					SimulationConditionVO[] simVos =  new SimulationConditionVO[tariff_list.size()];
					
					
					for( int j = 0 ; j < tariff_list.size() ; j++ ){
						
						String yd_chg_no = tariff_list.get(j).getYdChgNo();
						String yd_chg_ver_seq = tariff_list.get(j).getYdChgVerSeq();
						String curr_cd = tariff_list.get(j).getCurrCd();
						//String t_acct_cd = tariff_list.get(j).getAcctCd();
						String t_cost_cd = tariff_list.get(j).getCostCd();
						//String t_vndr_seq = tariff_list.get(j).getVndrSeq();
						//String t_vndr_lgl_eng_nm = tariff_list.get(j).getVndrLglEngNm();
						
						
						simVo.setVslCd(vsl_cd);
						simVo.setSkdVoyNo(skd_voy_no);
						simVo.setSkdDirCd(skd_dir_cd);
						simVo.setVvd(vsl_cd+skd_voy_no+skd_dir_cd);
						simVo.setYdChgNo(yd_chg_no);
						simVo.setYdChgVerSeq(yd_chg_ver_seq);
						simVo.setYardCd(yd_cd);
						simVo.setCostCd(t_cost_cd);
						simVo.setCurrCd(curr_cd);
						
						simVos[j] = simVo;
						
					}
						List<SimulationObjectListVO> objectsList = command_pso.searchObjectListBySimulation(simVo, simVos);
						///////////////////////////////////////////		
						String tempObj = null;
						
						// tariff simulation의 화면과 같이 12(FLAG), 14(CODE), 17(DAY), 16(DATE)의 DfltVal 변환
						for(int a=0; a<objectsList.size(); a++){
							
							// acct_cd가 all일 때는 IN & OUT 의 value는 "Y"
							if("77".equals(objectsList.get(a).getObjListNo()) || "89".equals(objectsList.get(a).getObjListNo())){
								objectsList.get(a).setDfltVal("Y");
							}
							
							tempObj = objectsList.get(a).getPsoMeasUtCd();
												
							if("12".equals(tempObj) || "14".equals(tempObj) || "17".equals(tempObj)){
								tempObj = objectsList.get(a).getDfltVal().replaceAll("'", "");
								objectsList.get(a).setDfltVal("'" + tempObj + "'");
							}else if("16".equals(tempObj)){
								tempObj = objectsList.get(a).getDfltVal().replaceAll("'", "");
								objectsList.get(a).setDfltVal("TO_DATE(" + "'" + tempObj + "'" + ", 'YYYYMMDD')");
							}
							
						}
						
						List<SimulationObjectListVO> autoObjectList = new ArrayList<SimulationObjectListVO>();
						List<SimulationObjectListVO> manualObjectList = new ArrayList<SimulationObjectListVO>();
						
						for(int t=0; t<objectsList.size(); t++){
							if("A".equals(objectsList.get(t).getPsoObjListTpCd())){
								autoObjMap.put(objectsList.get(t).getObjListNo(), objectsList.get(t)); 
							} else if("M".equals(objectsList.get(t).getPsoObjListTpCd())){
								if( "115".equals(objectsList.get(t).getObjListNo())){
									
									SimulationObjectListVO tmp1 = new SimulationObjectListVO();
									
									tmp1.setObjListNo(objectsList.get(t).getObjListNo());
									tmp1.setObjListNm(objectsList.get(t).getObjListNm());
									tmp1.setDfltVal(mTier);
									tmp1.setPsoObjListTpCd(objectsList.get(t).getPsoObjListTpCd());
									tmp1.setRegVal(mTier);
									tmp1.setPsoMeasUtCd(objectsList.get(t).getPsoMeasUtCd());
									tmp1.setPsoMeasUtNm(objectsList.get(t).getPsoMeasUtNm());
									
									manuObjMap.put(objectsList.get(t).getObjListNo(), tmp1);
										
								}else{
									manuObjMap.put(objectsList.get(t).getObjListNo(), objectsList.get(t));
								}
							}
						}
						
						for(SimulationObjectListVO simulationObjectListVO : autoObjMap.values()){
							autoObjectList.add(simulationObjectListVO);
						}
						
						for(SimulationObjectListVO simulationObjectListVO : manuObjMap.values()){
							manualObjectList.add(simulationObjectListVO);
						}
						
						
						simVo.setYardCd(vo.getYdCd());
						simVo.setIssueDate(vo.getVpsEtbDt());
						List<CalcTariffResultVO> calVOs = command_pso.calculateTariff(simVo,simVos, autoObjectList.toArray(new SimulationObjectListVO[autoObjectList.size()]),
	                              																	manualObjectList.toArray(new SimulationObjectListVO[manualObjectList.size()]));
					
						st_amt=calVOs.get(0).getDisplayFormulaDesc();
						
						if( st_amt.length() > 0 ){
							String[] str = st_amt.split("\n");
							esti_trf = str[1].replace("[S]:", "");
						}
						/////////////////////////////////////////////////////////////
						//Diff Surcharge 를 구하기 위해서는 BayPlan에 Tier정보가 존재할 경우만 구한다.//
						/////////////////////////////////////////////////////////////
						
						
						
						List<SimulationObjectListVO> autoObjectList_diff = new ArrayList<SimulationObjectListVO>();
						List<SimulationObjectListVO> manualObjectList_diff = new ArrayList<SimulationObjectListVO>();
						
						for(int r=0; r<objectsList.size(); r++){
							if("A".equals(objectsList.get(r).getPsoObjListTpCd())){
								autoObjMap_diff.put(objectsList.get(r).getObjListNo(), objectsList.get(r)); 
							} else if("M".equals(objectsList.get(r).getPsoObjListTpCd())){
								if( "115".equals(objectsList.get(r).getObjListNo())){
									
									int tier = Integer.parseInt(mTier)-1;
									//objectsList.get(t).setRegVal(""+tier);
									
									SimulationObjectListVO tmp = new SimulationObjectListVO();
									
									tmp.setObjListNo(objectsList.get(r).getObjListNo());
									tmp.setObjListNm(objectsList.get(r).getObjListNm());
									tmp.setDfltVal("" + tier);
									tmp.setPsoObjListTpCd(objectsList.get(r).getPsoObjListTpCd());
									tmp.setRegVal("" + tier);
									tmp.setPsoMeasUtCd(objectsList.get(r).getPsoMeasUtCd());
									tmp.setPsoMeasUtNm(objectsList.get(r).getPsoMeasUtNm());
									
									manuObjMap_diff.put(objectsList.get(r).getObjListNo(), tmp);
								}else{
									manuObjMap_diff.put(objectsList.get(r).getObjListNo(), objectsList.get(r));
								}
							}
						}
						
						for(SimulationObjectListVO simulationObjectListVO : autoObjMap_diff.values()){
							autoObjectList_diff.add(simulationObjectListVO);
						}
						
						for(SimulationObjectListVO simulationObjectListVO : manuObjMap_diff.values()){
							manualObjectList_diff.add(simulationObjectListVO);
						}
													
						List<CalcTariffResultVO> calVOs_diff = command_pso.calculateTariff(simVo,simVos, autoObjectList_diff.toArray(new SimulationObjectListVO[autoObjectList_diff.size()]),
	                              																	manualObjectList_diff.toArray(new SimulationObjectListVO[manualObjectList_diff.size()]));
					
						String st_amt_diff = calVOs_diff.get(0).getDisplayFormulaDesc();
						
						if( st_amt_diff.length() > 0 ){
							String[] str_diff = st_amt_diff.split("\n");
							esti_trf_diff = str_diff[1].replace("[S]:", "");
						}
					
				}
				
				eventResponse.setETCData("scgAmt", esti_trf);
				eventResponse.setETCData("scgDiffAmt", esti_trf_diff);
						
					
					
				}

				
			//}
		
		
		//eventResponse.setRsVoList(list);
		return eventResponse;
	}
}

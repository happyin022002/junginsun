/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TonnageTaxOutputSC.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.21 장창수
* 1.0 Creation
* ------------------------------------------------------------------------
* 2010.11.25 이병훈 [CHM-201007005-01] 톤세 신고관련 국토해양부 제출자료용 프로그램 개발
* 2010.12.29 이준범 [CHM-201007155-01] ALPS 톤세 프로그램 기능 변경 및 보완에 대한 요청 (Tax-Recalculation)
* 2011.03.22 이준범 [CHM-201109639-01] [TOT] 배치 관련 로그 파일 테이블 삭제 처리 기능 보완
* 2012.01.27 이준범[CHM-201113807-01]
* 제목 : ALPS 톤세 시스템 기능보완 - T/TAX Recalculation
* 내용 : 1) T/Tax Recalculated 옆에 Lane이 추가 되면 추가된 선박만 재배치 할 수 있게 처리
*       2) T/Tax Recalculated 작업 후, 변경된 내역을 표시해주는 팝업창 또는 화면을 추가하여
*          변경사항 확인할 수 있게 처리
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput;

import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.basic.TonnageTaxFillingBC;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.basic.TonnageTaxFillingBCImpl;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.event.FnsTot0024Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.event.FnsTot0025Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.event.FnsTot0026Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.event.FnsTot0027Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.FnsTot0027ConditionVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchActualBsaSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchBasicBsaSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchHiringOutAndLayingUpSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchSummaryCreationBatchVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.basic.TonnageTaxOutputMasterDataMgtBC;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.basic.TonnageTaxOutputMasterDataMgtBCImpl;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event.FnsTot0001Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event.FnsTot0003Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event.FnsTot0004Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event.FnsTot0006Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event.FnsTot0008Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event.FnsTot0028Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event.FnsTot0029Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.LaneVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.MissLaneChkVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.NrtBsaChgVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.PndlmPortVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.basic.TonnageTaxStandardProfitConclusionBC;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.basic.TonnageTaxStandardProfitConclusionBCImpl;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0010Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0011Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0012Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0013Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0015Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0016Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0017Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0018Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0019Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0020Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0021Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0022Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0023Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0030Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0031Event;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.FdrStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.JbSkdVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.PortStlAmtVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.StlCfmVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.VvdStlAmtVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.basic.TOTFindCodeBC;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.basic.TOTFindCodeBCImpl;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.CustomVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeInfoVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TotBsaVO;
import com.hanjin.syscommon.common.table.TotPortStlAmtVO;
import com.hanjin.syscommon.common.table.TotStlCfmVO;
import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * ALPS-TonnageTaxOutput Business Logic ServiceCommand - ALPS-TonnageTaxOutput 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jang Chang Soo
 * @see TonnageTaxOutputSC
 * @since J2EE 1.6
 */

public class TonnageTaxOutputSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TonnageTaxOutput system 업무 시나리오 선행작업<br>
	 * FNS_TOT_0001업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("TonnageTaxOutputSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * TonnageTaxOutput system 업무 시나리오 마감작업<br>
	 * FNS_TOT_0001 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TonnageTaxOutputSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-TonnageTaxOutput system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("FnsTot0001Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUseTonnageVesselList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUseTonnageVessel (e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createUseTonnageVessel(e);
				
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
			    eventResponse = openFnsTot0001(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0003Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUnusedVesselList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUnusedVessel(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
			    eventResponse = openFnsTot0003(e);
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0004Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLaneTradeGroupList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLaneTradeGroup(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				//eventResponse = createLaneTradeGroupFromPreMonth(e);
				eventResponse = createLaneTradeGroupByVesselSchedule(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0004(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0006Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBSAListByVVD(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBSAListByVVDCnt(e);
			}/*else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBSAModiFlgYCnt(e);
			}*/else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBSAByVVD(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeBSAByVVD(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageIFBSAByVVD(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRecalculateBSA(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTotLaneByTrdList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0006(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0008Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPendulumLanePortCodeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = managePendulumLanePortCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0008(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0010Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNrtNCapaNBsaListByLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNrtNCapaNBsaTrdCmbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchNrtNCapaNBsaLaneCmbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0010(e);	
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0011Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTaxableAmountConfirmationCheck (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTaxableAmountConfirmationList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = checkSettlementClosing0011(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createTaxableAmountConfirmationMark (e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0011(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0012Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchTaxableAmountConfirmationDetailListByVVD(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = recalculateTaxableAmountForVoyageDay(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = recalculateTaxableAmountForLoadCapa(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
			   eventResponse = openFnsTot0012(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0013Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTaxableAmountListByVessel (e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0013(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0015Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTaxableAmountListByLane(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTaxableAmountListByLaneTrdCmbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTaxableAmountListByLaneLaneCmbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0015(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0016Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFeederTaxableAmountListByVessel(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyFeederTaxableAmountByVessel(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0016(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0017Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFeederTaxableAmountListByMonthly(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createFeederTaxableAmount(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = checkSettlementClosing(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0017(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchFeederTaxableAmountListByDetailDown(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0018Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTaxableAmountList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				log.debug("::CALL::> SC closeTonnageTaxStlYear 마감처리> :::::::::");
				eventResponse =  closeTonnageTaxStlYear(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createTaxableAmountIF(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0018(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0019Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTaxableAmountStatusList(e);	
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0020Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTaxableAmountListByERPInterface(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0020(e);	
			}	
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0021Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNonFeederNFeederTaxBatchHis(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createNonFeederNFeederTaxBatch(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = cancelNonFeederNFeederTaxBatch(e);
			//}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){				
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0022Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInquiryActVsDays(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchZeroDaysVsActualLoadTrdCmbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchZeroDaysVsActualLoadLaneCmbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0022(e);	
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0023Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExceptedVslPortSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPortVskTotTrdCmbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPortVskTotLaneCmbList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0023(e);	
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0024Event")) {
			
//			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
//				eventResponse = doBackEndJobBasicBsaSummary(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = comBackEndJob(e);
//			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
//				eventResponse = searchBasicBsaSummary(e);
//			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBasicBsaSummary(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0025Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActualBsaSummary(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0026Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHiringOutAndLayingUpSummary(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0027Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSummaryCreationBatch(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createSummaryCreationBatch(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = cancelSummaryCreationBatch(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0028Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNrtBsaChg(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyNrtBsaChgBsa(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0029Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMissLaneChk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageNonFeederCalculation(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0030Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTaxableAmountConfirmationCheck (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInquiryVslOwnerCharterList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = checkSettlementClosing0011(e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = openFnsTot0011(e);	
			}
		}else if (e.getEventName().equalsIgnoreCase("FnsTot0031Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInquiryVslOwnerCharterDetailList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){
			   eventResponse = openFnsTot0012(e);
			}
		}
		
		return eventResponse;
	}

	

	
	/**
	 * FNS_TOT_0001 : SAVE <br>
	 * 해당년도에 필요한 VESSEL 데이터를 저장합니다. <br>
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse createLaneTradeGroupByVesselSchedule(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0004Event event = (FnsTot0004Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();
		try{
			begin();
			command.createLaneTradeGroupByVesselSchedule (event.getLaneVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0001 : OPEN <br>
	 * Vessel Information 화면 OPEN시 Owner Ship Combo code list와 마감여부를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse openFnsTot0001(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
	
			String stlClzFlg = null;
	
			log.debug("::CALL::> openFnsTot0001 SC >open :::::::::");
			CustomVO vo = command.searchComboCodeList("CD02109");
			
			List<TotStlClzVO> list = command.checkSettlementClosing(DateTime.getYear()+"");
			//eventResponse.setRsVoList(list);
	        
			if(list.size() > 0){
	        	stlClzFlg = list.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
			
			eventResponse.setCustomData("CustomVO",vo);
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}

	/**
	 * FNS_TOT_0003 : OPEN <br>
	 * Unused Vessel over 30 Days 화면 OPEN시 마감여부를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openFnsTot0003(Event e) throws EventException {

		TOTFindCodeBC command = new TOTFindCodeBCImpl();

		String stlClzFlg = null;

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {

			List<TotStlClzVO> list = command.checkSettlementClosing(DateTime.getYear()	+ "");
			// eventResponse.setRsVoList(list);

			if (list.size() > 0) {
				stlClzFlg = list.get(0).getStlClzFlg();
			} else {
				stlClzFlg = "N";
			}

			eventResponse.setETCData("stlClzFlg", stlClzFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;

	}

	/**
	 * FNS_TOT_0004 : OPEN <br>
	 * Lane Group 화면 OPEN시 IBSHEET 에 셑팅할 Trade combo list와 마감여부를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse openFnsTot0004(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			String stlClzFlg = null;
	
			//log.debug("::CALL::> openFnsTot0004  >ddd :::::::::");
			//Carrier 조회
			List<TotCodeInfoVO> list = command.searchTradeCodeList(totCodeParamVO);
			List<TotStlClzVO> cltFlag = command.checkSettlementClosing(DateTime.getYear()+"");
			//eventResponse.setRsVoList(list);
	        
			String trdSheetByOnload = makeComboString(list, 2);//IBSheet 내 combo용
			String trdSheetByOnclick = makeComboString(list, 6);//IBSheet 내 combo용
	        
			if(cltFlag.size() > 0){
	        	stlClzFlg = cltFlag.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
	
			eventResponse.setETCData("sheet1_trd_cd_by_onload"       , trdSheetByOnload );
			eventResponse.setETCData("sheet1_trd_cd_by_click"        , trdSheetByOnclick );
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * FNS_TOT_0006 : OPEN <br>
	 * BSA Creation by Vessel Voyage 화면 OPEN시 Trade combo list와 마감여부를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0006(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
	
			String stlClzFlg = null;
	
			log.debug("::CALL::> openFnsTot0006  >ddd :::::::::");
			//Carrier 조회
			List<TotCodeInfoVO> list = command.searchBSATradeCodeList(totCodeParamVO);
			List<TotStlClzVO> cltFlag = command.checkSettlementClosing(DateTime.getYear()+"");
			
			String bsaTrdList = makeComboString(list, 2);//IBSheet 내 combo용
	        
			log.debug("::CALL::> openFnsTot0006  >bsaTrdList :::::::::"+bsaTrdList);
	
			if(cltFlag.size() > 0){
	        	stlClzFlg = cltFlag.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
	
			eventResponse.setETCData("bsaTrdList"       , bsaTrdList );
			eventResponse.setETCData("stlClzFlg", stlClzFlg);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * FNS_TOT_0008 : OPEN <br>
	 * Pendulum Service Port by Bound Creation 화면 OPEN시 Pendulum Lane combo list, Trade combo list와 마감여부를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */		
	private EventResponse openFnsTot0008(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
	
			String stlClzFlg = null;
	
			log.debug("::CALL::> openFnsTot0008  >ddd :::::::::");
			//Carrier 조회
			List<TotCodeInfoVO>  lane_list = command.searchPLaneCodeList(totCodeParamVO);
			List<TotCodeInfoVO>  trd_list = command.searchPLaneTrdCodeList(totCodeParamVO);
			List<TotStlClzVO> cltFlag = command.checkSettlementClosing(DateTime.getYear()+"");
			
			String laneCmb = makeComboString(lane_list, 2);//IBSheet 내 combo용
			String trdBylaneCmb = makeComboString(trd_list, 6);//IBSheet 내 combo용
	        
			log.debug("::CALL::> openFnsTot0008  >laneCmb :::::::::"+laneCmb);
			log.debug("::CALL::> openFnsTot0008  >trdBylaneCmb :::::::::"+trdBylaneCmb);
	
			if(cltFlag.size() > 0){
	        	stlClzFlg = cltFlag.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
	
			eventResponse.setETCData("laneCmb"       , laneCmb );
			eventResponse.setETCData("trdBylaneCmb"       , trdBylaneCmb );
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0010 : OPEN <br>
	 * NRT/CAPA/BSA Allocation Inquiry by Lane 화면 OPEN시 Lane combo list, Trade combo list를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0010(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//FnsTot0010Event event = (FnsTot0010Event)e;

		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
			
			log.debug("::CALL::> openFnsTot0010  >ddd :::::::::");
			
			String yrmon = DateTime.getShortDateString();
	
			totCodeParamVO.setSuperCd1(yrmon.substring(0, 4)+"01");
			totCodeParamVO.setSuperCd2(yrmon.substring(0, 6));
	
			List<TotCodeInfoVO>  trd_list = command.searchBsaTrdCodeList(totCodeParamVO);
			
			String trdCmb = makeComboString(trd_list, 2);//IBSheet 내 combo용
	        
			log.debug("::CALL::> openFnsTot0010  >trdCmb :::::::::"+trdCmb);
			
			eventResponse.setETCData("trdCmb"       , trdCmb );
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0011 : OPEN <br>
	 * Taxable Amount Confirmation by Monthly 화면 OPEN시 Trade combo list를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0011(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//FnsTot0011Event event = (FnsTot0011Event)e;
		String stlClzFlg = null;
		// PDTO(Data Transfer Object including Parameters)
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{

			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
			
			log.debug("::CALL::> openFnsTot0011  >ddd :::::::::");
			//Carrier 조회
			List<TotCodeInfoVO> list = command.searchBSATradeCodeList(totCodeParamVO);
			List<TotStlClzVO> cltFlag = command.checkSettlementClosing(DateTime.getYear()+"");
			//String crrCombo = makeComboString(list, 1);
	
			String bsaTrdList = makeComboString(list, 2);//IBSheet 내 combo용
			bsaTrdList = bsaTrdList+"|ZZZ|FFF|YYY";
			log.debug("::CALL::> openFnsTot0011  >bsaTrdList :::::::::"+bsaTrdList);
			
			if(cltFlag.size() > 0){
	        	stlClzFlg = cltFlag.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
	
			String yyyyMM = DateTime.addMonths(JSPUtil.getKST("yyyyMM"),-1,"yyyyMM")+"";
			String jbEndDt = this.searchJbEndDt("ALL", yyyyMM);
			
			eventResponse.setETCData("jbEndDt", jbEndDt);
			eventResponse.setETCData("bsaTrdList"       , bsaTrdList );
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		
		return eventResponse;
	}	

	/**
	 * FNS_TOT_0012 : OPEN <br>
	 * Taxable Amount Confirmation by Monthly 화면 OPEN시 마감여부를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0012(Event e) throws EventException {
		log.debug("::CALL::> openFnsTot0012  >ddd :::::::::");
		TOTFindCodeBC command = new TOTFindCodeBCImpl();

		String stlClzFlg = null;

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<TotStlClzVO> list = command.checkSettlementClosing(DateTime.getYear()+"");
			//eventResponse.setRsVoList(list);
	        
			if(list.size() > 0){
	        	stlClzFlg = list.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
			log.debug("::CALL::> stlClzFlg  >ddd :::::::::  "+stlClzFlg);
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
		
	}
	
	/**
	 * FNS_TOT_0013 : OPEN <br>
	 * Taxable Amount Inquiry by Vessel 화면 OPEN시 VVD 최종년월을 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */		
	private EventResponse openFnsTot0013(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{

			log.debug("::CALL::> openFnsTot0013  >ddd :::::::::");
			//Carrier 조회
			List<VvdStlAmtVO> list = command.searchMaxCosingYearMmByVessel();
			String e_stl_yrmon = list.get(0).getStlYrmon();
			
			if (e_stl_yrmon != null && !"".equals(e_stl_yrmon))
				e_stl_yrmon = e_stl_yrmon.substring(0, 4)+ "-" + e_stl_yrmon.substring(4, 6);
	
			
			eventResponse.setETCData("e_stl_yrmon"       , e_stl_yrmon );
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	
	
	/**
	 * FNS_TOT_0015 : OPEN <br>
	 * Taxable Amount Inquiry by Lane 화면 OPEN시 OPEN시 Lane combo list, Trade combo list, VVD 최종년월을 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0015(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		TonnageTaxStandardProfitConclusionBC command2 = new TonnageTaxStandardProfitConclusionBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
			
			log.debug("::CALL::> openFnsTot0015  >ddd :::::::::");
	
			List<VvdStlAmtVO> closeYn = command2.searchMaxCosingYearMmByVessel();
	
			String e_stl_yrmon = closeYn.get(0).getStlYrmon();
			String trdCmb = "";
			if (e_stl_yrmon != null && !"".equals(e_stl_yrmon)){
				totCodeParamVO.setSuperCd1(e_stl_yrmon.substring(0, 4)+"01");
				totCodeParamVO.setSuperCd2(e_stl_yrmon.substring(0, 6));
		
				List<TotCodeInfoVO>  trd_list = command.searchBsaTrdCodeList(totCodeParamVO);
		
				trdCmb = makeComboString(trd_list, 2);//IBSheet 내 combo용
		
				e_stl_yrmon = e_stl_yrmon.substring(0, 4)+ "-" + e_stl_yrmon.substring(4, 6);
			}
			eventResponse.setETCData("trdCmb"       , trdCmb );
			eventResponse.setETCData("e_stl_yrmon"       , e_stl_yrmon );
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_TOT_0016 : OPEN <br>
	 * Feeder Taxable Amount Inquiry by Day 화면 OPEN시 마감여부와 Data Type combo list를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0016(Event e) throws EventException {
		log.debug("::CALL::> openFnsTot0016  > :::::::::");
		TOTFindCodeBC command = new TOTFindCodeBCImpl();

		String stlClzFlg = null;

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			//eventResponse.setRsVoList(list);
			CustomVO vo = command.searchComboCodeList("CD01873");
			List<TotStlClzVO> list = command.checkSettlementClosing(DateTime.getYear()+"");
	
			if(list.size() > 0){
	        	stlClzFlg = list.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
			log.debug("::CALL::> stlClzFlg  > :::::::::  "+stlClzFlg);
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
			eventResponse.setCustomData("CustomVO",vo);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
		
	}

	/**
	 * FNS_TOT_0017 : OPEN <br>
	 * Feeder Taxable Amount Summary 화면 OPEN시 마감여부를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0017(Event e) throws EventException {
		log.debug("::CALL::> openFnsTot0017  > :::::::::");
		TOTFindCodeBC command = new TOTFindCodeBCImpl();

		String stlClzFlg = null;

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<TotStlClzVO> list = command.checkSettlementClosing(DateTime.getYear()+"");
	
			if(list.size() > 0){
	        	stlClzFlg = list.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
			log.debug("::CALL::> stlClzFlg  > :::::::::  "+stlClzFlg);
			String yyyyMM = DateTime.addMonths(JSPUtil.getKST("yyyyMM"),-1,"yyyyMM")+"";
			String jbEndDt = this.searchJbEndDt("FEEDER", yyyyMM);
			
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
			eventResponse.setETCData("jbEndDt", jbEndDt);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		
	}

	/**
	 * FNS_TOT_0018 : OPEN <br>
	 * ERP I/F by Monthly 화면 OPEN시 마감여부를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0018(Event e) throws EventException {
		log.debug("::CALL::> openFnsTot0018  >ddd :::::::::");
		TOTFindCodeBC command = new TOTFindCodeBCImpl();

		String stlClzFlg = null;

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<TotStlClzVO> list = command.checkSettlementClosing(DateTime.getYear()+"");
			//eventResponse.setRsVoList(list);
	        
			if(list.size() > 0){
	        	stlClzFlg = list.get(0).getStlClzFlg();
	        }else{
	        	stlClzFlg = "N";
	        }
			log.debug("::CALL::> stlClzFlg  >ddd :::::::::  "+stlClzFlg);
			eventResponse.setETCData("stlClzFlg", stlClzFlg);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
		
	}

	/**
	 * FNS_TOT_0020 : OPEN <br>
	 * ERP I/F Inquiry 화면 OPEN시 최종마감년월을 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0020(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{

			log.debug("::CALL::> openFnsTot0020  >ddd :::::::::");
			//Carrier 조회
			List<ErpIfVO> list = command.searchMaxCosingYearMm();
			String e_stl_yrmon = list.get(0).getStlYrmon();
			if(e_stl_yrmon.equals("")|| e_stl_yrmon == null){
				e_stl_yrmon = "";
			}else{
			    e_stl_yrmon = e_stl_yrmon.substring(0, 4)+ "-" + e_stl_yrmon.substring(4, 6);
			}
			
			eventResponse.setETCData("e_stl_yrmon"       , e_stl_yrmon );
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}	

	/**
	 * FNS_TOT_0022 : OPEN <br>
	 * NRT/CAPA/BSA Allocation Inquiry by Lane 화면 OPEN시 Trade combo list를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0022(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//FnsTot0010Event event = (FnsTot0010Event)e;

		// PDTO(Data Transfer Object including Parameters)
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		TonnageTaxStandardProfitConclusionBC command2 = new TonnageTaxStandardProfitConclusionBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
			
			log.debug("::CALL::> openFnsTot0022  > :::::::::");
	
			List<ErpIfVO> closeYn = command2.searchMaxCosingYearMm();
			
			String e_stl_yrmon = closeYn.get(0).getStlYrmon();
			String trdCmb      = "";
	
			if (e_stl_yrmon == null || "".equals(e_stl_yrmon)){
				e_stl_yrmon = JSPUtil.getKST("yyyyMM");
			}
	
			totCodeParamVO.setSuperCd1(e_stl_yrmon.substring(0, 4)+"01");
			totCodeParamVO.setSuperCd2(e_stl_yrmon.substring(0, 6));
	
			List<TotCodeInfoVO>  trd_list = command.searchBsaTrdCodeList(totCodeParamVO);
			
			trdCmb = makeComboString(trd_list, 2);//IBSheet 내 combo용
	        e_stl_yrmon = e_stl_yrmon.substring(0, 4)+ "-" + e_stl_yrmon.substring(4, 6);
			eventResponse.setETCData("trdCmb"       , trdCmb );
			eventResponse.setETCData("e_stl_yrmon"       , e_stl_yrmon );
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0023 : OPEN <br>
	 * Inquiry Port ERP vs TOT 화면 OPEN시 Trade combo list를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse openFnsTot0023(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//FnsTot0010Event event = (FnsTot0010Event)e;

		// PDTO(Data Transfer Object including Parameters)
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		TonnageTaxStandardProfitConclusionBC command2 = new TonnageTaxStandardProfitConclusionBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
			
			log.debug("::CALL::> openFnsTot0023  >ddd :::::::::");
	
			List<ErpIfVO> closeYn = command2.searchMaxCosingYearMm();
			
			String e_stl_yrmon = closeYn.get(0).getStlYrmon();
			String trdCmb = "";
			
			if (e_stl_yrmon == null || "".equals(e_stl_yrmon)){
				e_stl_yrmon = JSPUtil.getKST("yyyyMM");
			}
	
			totCodeParamVO.setSuperCd1(e_stl_yrmon.substring(0, 4)+"01");
			totCodeParamVO.setSuperCd2(e_stl_yrmon.substring(0, 6));
	
			List<TotCodeInfoVO>  trd_list = command.searchBsaTrdCodeList(totCodeParamVO);
			
			trdCmb = makeComboString(trd_list, 2);//IBSheet 내 combo용
	
			e_stl_yrmon = e_stl_yrmon.substring(0, 4)+ "-" + e_stl_yrmon.substring(4, 6);
			
			eventResponse.setETCData("trdCmb"       , trdCmb );
			eventResponse.setETCData("e_stl_yrmon"       , e_stl_yrmon );
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * FNS_TOT_0001 : SEARCH <br>
	 * SHEET에 보여질 VESSEL 정보와 가장 최근업데이트된 날짜를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchUseTonnageVesselList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0001Event event = (FnsTot0001Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			List<VslVO> list = command.searchUseTonnageVesselList(event.getVslVO());
			//log.debug("::CALL::> FNS_TOT_0001 SC 그리드 조회끝> :::::::::");
			List<VslVO> recentlist =   command.searchRecentUpdateDt(event.getVslVO());
			eventResponse.setRsVoList(list);
			
			String recentDt = recentlist.get(0).getUpdDt();
			eventResponse.setETCData("recentDt", recentDt);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0001 : SAVE <br>
	 * VESSEL 정보의 전년도 데이터를 저장합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse createUseTonnageVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0001Event event = (FnsTot0001Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			begin();
			command.createUseTonnageVessel(event.getVslVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * FNS_TOT_0001 : SAVE <br>
	 * SHEET에 추가,수정 또는 삭제된 VESSEL 정보를 저장합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse manageUseTonnageVessel (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0001Event event = (FnsTot0001Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			begin();
			log.debug("::CALL::> FNS_TOT_0001 SC >manageUseTonnageVessel :::::::::");
			

			
			command.manageUseTonnageVessel (event.getTotVesselVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0002 : SEARCH <br>
	 * SHEET에 보여질 30일이상 사용하지 않은 VESSEL 정보와 가장 최근업데이트된 날짜를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchUnusedVesselList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0003Event event = (FnsTot0003Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			List<VslVO> list = command.searchUnusedVesselList(event.getVslVO());
			//log.debug("::CALL::> FNS_TOT_0003 SC 그리드 조회끝> :::::::::");
			List<VslVO> recentlist =   command.searchRecentUpdateDt(event.getVslVO());
			eventResponse.setRsVoList(list);
			
			String recentDt = recentlist.get(0).getUpdDt();
			eventResponse.setETCData("recentDt", recentDt);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0002 : SAVE <br>
	 * SHEET에 추가,수정 또는 삭제된 30일 이상 사용하지 않은 VESSEL 정보를 저장합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse manageUnusedVessel (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0003Event event = (FnsTot0003Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();
		try{
			begin();
			//log.debug("::CALL::> FNS_TOT_0003 SC >manageUnusedVessel :::::::::");
			command.manageUnusedVessel (event.getTotVesselVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0004 : SEARCH <br>
	 * SHEET에 보여질 해당월 [VSL_PORT_SKD] 테이블 기준대상 Lane의 Trade정보와 가장 최근업데이트된 날짜를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchLaneTradeGroupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0004Event event = (FnsTot0004Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();
		//LaneVO vo = new LaneVO();
		//String[] ln_seq =  null;
		try{
	  
			List<LaneVO> list = command.searchLaneTradeGroupList(event.getLaneVO());

			//log.debug("::CALL::> FNS_TOT_0003 SC 그리드 조회끝> :::::::::");
			List<LaneVO> recentlist =   command.searchRcLaneUpdateDt(event.getLaneVO());
			eventResponse.setRsVoList(list);
			
			String recentDt = recentlist.get(0).getUpdDt();
			eventResponse.setETCData("recentDt", recentDt);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0004 : SAVE <br>
	 * SHEET에 추가,수정 또는 삭제된 Trade정보를 저장합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse manageLaneTradeGroup (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0004Event event = (FnsTot0004Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();
		try{
			begin();
			command.manageLaneTradeGroup (event.getLaneVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0004 : COPY <br>
	 * 전월의 Lane group정보를 해당년월에 저장합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	/*private EventResponse createLaneTradeGroupFromPreMonth (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0004Event event = (FnsTot0004Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();
		try{
			begin();
			command.createLaneTradeGroupFromPreMonth (event.getLaneVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	*/

	/**
	 * FNS_TOT_0008 : SEARCH <br>
	 * SHEET에 Pendulm port Start Port List, End Port List 정보와 가장 최근업데이트된 날짜를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchPendulumLanePortCodeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0008Event event = (FnsTot0008Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			
			String stlYrmon = event.getPndlmPortVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getPndlmPortVO().setStlYrmon(stlYrmon);
			
			event.getPndlmPortVO().setPndlmStEndPortTpCd("S");
			List<PndlmPortVO> list1 = command.searchPendulumLanePortCodeList(event.getPndlmPortVO());
			
			event.getPndlmPortVO().setPndlmStEndPortTpCd("E");
			List<PndlmPortVO> list2 = command.searchPendulumLanePortCodeList(event.getPndlmPortVO());
            
			log.debug("::CALL::> FNS_TOT_0008 SC  조회끝> :::::::::");
			List<PndlmPortVO> recentlist =   command.searchPendulumRecentUpdateDt(event.getPndlmPortVO());
			
			String recentDt = recentlist.get(0).getUpdDt();
			eventResponse.setETCData("recentDt", recentDt);

			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0008 : SAVE <br>
	 * SHEET에 추가, 수정, 삭제된 Pendulm port Start Port List, End Port List 정보를 저장합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse managePendulumLanePortCode (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0008Event event = (FnsTot0008Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();
		int res =0;
		try{
			begin();
			log.debug("::CALL::> FNS_TOT_0008 SC >managePendulumLanePortCode :::::::::");
			//TotPndlmPortVO[] totPndlmPortVO = event.getTotPndlmPortVOs();
			log.debug("::CALL::> FNS_TOT_0008 SC2 >managePendulumLanePortCode :::::::::");
			if(event.getPndlmPortVOs() != null){
				log.debug("::CALL::> FNS_TOT_0008 SC3 >managePendulumLanePortCode :::::::::");
				res = command.managePendulumLanePortCode (event.getPndlmPortVOs(),account);
				log.debug("::CALL::> FNS_TOT_0008 SC3 >res :::::::::"+res);
				if(res == -999){
					throw new EventException(new ErrorHandler("TOT00010").getMessage());
				}
			}
			//log.debug("length :::::::::::::::::::: "+event.getOtherPndlmPortVOs().length);
			if(event.getOtherPndlmPortVOs() != null){
				log.debug("::CALL::> FNS_TOT_0008 SC4 >managePendulumLanePortCode :::::::::");
				res = command.managePendulumLanePortCode (event.getOtherPndlmPortVOs(),account);
				if(res == -999){
					throw new EventException(new ErrorHandler("TOT10002").getMessage());
				}
			}
			
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0006 : SEARCH <br>
	 * SHEET에 BSA 정보와 가장 최근업데이트된 날짜를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSAListByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0006Event event = (FnsTot0006Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			
			String stlYrmon = event.getBsaVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getBsaVO().setStlYrmon(stlYrmon);
			event.getBsaVO().setSearchFlg("A");
			List<BsaVO> list = command.searchBSAListByVVD(event.getBsaVO());
			//log.debug("::CALL::> FNS_TOT_0006 SC 그리드 조회끝> :::::::::");
			List<BsaVO> recentlist =   command.searchBSARecentUpdateDt(event.getBsaVO());
			eventResponse.setRsVoList(list);
			
			String recentDt = recentlist.get(0).getUpdDt();
			eventResponse.setETCData("recentDt", recentDt);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0006 : SAVE <br>
	 * SHEET에 수정된 정보를 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBSAByVVD (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0006Event event = (FnsTot0006Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			begin();
			log.debug("::CALL::> FNS_TOT_0006 SC >manageBSAByVVD :::::::::");
			
			command.manageBSAByVVD (event.getTotBsaVOs(),account);
			log.debug("::CALL::> FNS_TOT_0006 SC >manageBSAByVVD 끝:::::::::");
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0006 : DELETE <br>
	 * 해당년월의 정보를 모두 삭제한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeBSAByVVD (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0006Event event = (FnsTot0006Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			begin();
			log.debug("::CALL::> FNS_TOT_0006 SC >removeBSAByVVD :::::::::");
			
            
			String stlYrmon = event.getBsaVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getBsaVO().setStlYrmon(stlYrmon);
			
			//List<BsaVO> list = command.searchBSAListByVVD(event.getBsaVO());
			
			command.removeBSAByVVD (event.getBsaVO());
			eventResponse.setUserMessage(new ErrorHandler("TOT10005").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * FNS_TOT_0006 : I/F <br>
	 * 해당년월의 BSA 정보건수를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBSAListByVVDCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0006Event event = (FnsTot0006Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			
			String stlYrmon = event.getBsaVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getBsaVO().setStlYrmon(stlYrmon);
			event.getBsaVO().setSearchFlg("C");
			List<BsaVO> list = command.searchBSAListByVVD(event.getBsaVO());
			log.debug("::CALL::> FNS_TOT_0006 SC searchBSAListByVVDCnt 그리드 조회끝> :::::::::");

			eventResponse.setETCData("delCnt", Integer.toString(list.size()));
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0006 : I/F <br>
	 * 해당년월의 BSA 정보를 생성하여 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIFBSAByVVD (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0006Event event = (FnsTot0006Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			begin();
			log.debug("::CALL::> FNS_TOT_0006 SC >manageIFBSAByVVD :::::::::");
			
			String stlYrmon = event.getTotBsaVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getTotBsaVO().setStlYrmon(stlYrmon);
			
			String key = command.manageIFBSAByVVD(event.getTotBsaVO(),account);
			eventResponse.setETCData("KEY", key);
			//eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * FNS_TOT_0006 : trade 변경시 <br>
	 * 해당기간의 LANE COMBO LIST를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotLaneByTrdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0006Event event = (FnsTot0006Event)e;
		
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		log.debug("::CALL::> 006 ::::::::: ::::::::::::::::::::::::시작    ");
		try{
			
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
			event.getBsaVO().getStlYrmon();
			String stlYrmon = event.getBsaVO().getStlYrmon();
			log.debug("::CALL:dfdfd:> stlYrmon :::::::::    "+stlYrmon);
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);

			totCodeParamVO.setSuperCd1(stlYrmon);
			totCodeParamVO.setSuperCd2(event.getBsaVO().getTrdCd());
			
			List<TotCodeInfoVO>  lane_list = command.searchTotLaneByTrdList(totCodeParamVO);

			String laneCmb = makeComboString(lane_list, 2);//IBSheet 내 combo용
			
			log.debug("::CALL::> openFnsTot0006  >laneCmb :::::::::"+laneCmb);

			eventResponse.setETCData("laneCmb"       , laneCmb );

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * FNS_TOT_0006 : T/Tax Recalculated <br>
	 * tax 재계산전 변경된 데이터가 있는지 여부와 배치처리된 데이터가 있는지 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 
	private EventResponse searchBSAModiFlgYCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0006Event event = (FnsTot0006Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

		try{
			
			String stlYrmon = event.getTotBsaVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getTotBsaVO().setStlYrmon(stlYrmon);
			List<TotBsaVO> list = command.searchBSAModiFlgYCnt(event.getTotBsaVO());
			List<TotBsaVO> list2 = command.searchBSABatchCnt(event.getTotBsaVO());		
			log.debug("::CALL::> FNS_TOT_0006 SC searchBSAModiFlgYCnt 그리드 조회끝> :::::::::");
            
			String batchCnt = list2.get(0).getVslCd();
			eventResponse.setETCData("modiFlagYCnt", Integer.toString(list.size()));
			eventResponse.setETCData("batchCnt", batchCnt);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
*/
	/**
	 * FNS_TOT_0006 : T/Tax Recalculated <br>
	 * 변경된(MODIFY FLAG = 'Y') 정보를 재계산하여 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRecalculateBSA (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0006Event event = (FnsTot0006Event)e;
		TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();
		TonnageTaxStandardProfitConclusionBC command2 = new TonnageTaxStandardProfitConclusionBCImpl();
		try{
			begin();
			
			String stlYrmon = event.getTotBsaVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			event.getTotBsaVO().setStlYrmon(stlYrmon);
			
			List<TotBsaVO> modi_list = command.searchBSAModiFlgYCnt(event.getTotBsaVO());
			List<TotBsaVO> batch_list = command.searchBSABatchCnt(event.getTotBsaVO());		

			String batchCnt = batch_list.get(0).getVslCd();
			if(modi_list.size() > 0 && Integer.parseInt(batchCnt) > 0){
				command2.manageRecalculateBSA (event.getTotBsaVO(),account);
				command.manageRecalculateBsaForModiFlg(event.getTotBsaVO(),account);
			}
			command2.manageRecalculateNrt (event.getTotBsaVO(),account);
			
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0020 : SEARCH <br>
	 * SHEET의 월별 선박당 사용율 및 톤세 관련 데이터를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxableAmountListByERPInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0020Event event = (FnsTot0020Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String s_stlYrmon = event.getErpIfVO().getSStlYrmon();
			s_stlYrmon = s_stlYrmon.substring(0, 4)+ s_stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
			event.getErpIfVO().setSStlYrmon(s_stlYrmon);

			String e_stlYrmon = event.getErpIfVO().getEStlYrmon();
			e_stlYrmon = e_stlYrmon.substring(0, 4)+ e_stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
			event.getErpIfVO().setEStlYrmon(e_stlYrmon);

			List<ErpIfVO> list = command.searchTaxableAmountListByERPInterface(event.getErpIfVO());
			
			int total_cnt = list.size();
			
			double total_txAmt = 0;
			for(int i= 0; i<total_cnt; i++){
				total_txAmt = total_txAmt + Double.parseDouble(list.get(i).getTongTaxAmt());
			}
		
			eventResponse.setETCData("total_cnt", total_cnt+"");
			eventResponse.setETCData("total_txAmt", total_txAmt+"");
			
			eventResponse.setRsVoList(list);			
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0010 : 기간 onchange시 <br>
	 * NRT/CAPA/BSA Allocation Inquiry by Lane 화면 기간 onchange시 Trade combo list를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchNrtNCapaNBsaTrdCmbList(Event e) throws EventException {

		FnsTot0010Event event = (FnsTot0010Event)e;
		
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
			
			String s_stlYrmon = event.getBsaVO().getStlYrmon();
			s_stlYrmon = s_stlYrmon.replace("-", "");
			log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
	
			String e_stlYrmon = event.getBsaVO().getEStlYrmon();
			e_stlYrmon = e_stlYrmon.replace("-", "");
			log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
	
			totCodeParamVO.setSuperCd1(s_stlYrmon);
			totCodeParamVO.setSuperCd2(e_stlYrmon);
			
			List<TotCodeInfoVO>  trd_list = command.searchBsaTrdCodeList(totCodeParamVO);
			
			String trdCmb = makeComboString(trd_list, 2);//IBSheet 내 combo용
			log.debug("::CALL::> searchBsaTrdCodeList  >trdCmb :::::::::"+trdCmb);
			
			eventResponse.setETCData("trdCmb"       , trdCmb );
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0010 : trade 콤보 onchange시 <br>
	 * NRT/CAPA/BSA Allocation Inquiry by Lane 화면 trade 콤보 onchange시 Lane combo list를 조회합니다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchNrtNCapaNBsaLaneCmbList(Event e) throws EventException {

		FnsTot0010Event event = (FnsTot0010Event)e;
		
		TOTFindCodeBC command = new TOTFindCodeBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
			
			String s_stlYrmon = event.getBsaVO().getStlYrmon();
			s_stlYrmon = s_stlYrmon.replace("-", "");
			log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
	
			String e_stlYrmon = event.getBsaVO().getEStlYrmon();
			e_stlYrmon = e_stlYrmon.replace("-", "");
			log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
	
			String trd_cd = event.getBsaVO().getTrdCd();
			
			totCodeParamVO.setSuperCd1(s_stlYrmon);
			totCodeParamVO.setSuperCd2(e_stlYrmon);
			totCodeParamVO.setCode(trd_cd);
			
			List<TotCodeInfoVO>  lane_list = command.searchBsaLaneCodeList(totCodeParamVO);
			
			String laneCmb = makeComboString(lane_list, 2);//IBSheet 내 combo용
			log.debug("::CALL::> searchBsaLaneCodeList  >laneCmb :::::::::"+laneCmb);
	
			eventResponse.setETCData("laneCmb"       , laneCmb );
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_TOT_0010 : SEARCH <br>
	 * SHEET의 Lane별 NRT/CAPA/BSA Allocation을 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNrtNCapaNBsaListByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0010Event event = (FnsTot0010Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String s_stlYrmon = event.getBsaVO().getStlYrmon();
			s_stlYrmon = s_stlYrmon.substring(0, 4)+ s_stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
			event.getBsaVO().setStlYrmon(s_stlYrmon);

			String e_stlYrmon = event.getBsaVO().getEStlYrmon();
			e_stlYrmon = e_stlYrmon.substring(0, 4)+ e_stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
			event.getBsaVO().setEStlYrmon(e_stlYrmon);

			List<BsaVO> list = command.searchNrtNCapaNBsaListByLane(event.getBsaVO());

			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	
	/**
	 * FNS_TOT_0019 : STATUS (FNS_TOT_0018) POPUP <br>
	 * ERP I/F by Monthly (FNS_TOT_0018) SHEET의 데이터선택후 STATUS 클릭시 ERP TAX로 I/F 결과를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxableAmountStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0019Event event = (FnsTot0019Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{

			List<TotStlCfmVO> list = command.searchTaxableAmountStatusList(event.getTotStlCfmVO());

			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0011 : 조건 TRADE 또는 MONTH 변경시 <br>
	 * 해당 년월, TRADE의 NRT, USE, DAYS 체크여부를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxableAmountConfirmationCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0011Event event = (FnsTot0011Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getStlCfmVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getStlCfmVO().setStlYrmon(stlYrmon);

			List<StlCfmVO> list = command.searchTaxableAmountConfirmationCheck(event.getStlCfmVO());

			eventResponse.setRsVoList(list);

			String nrt_yn = list.get(0).getNrtYn();
			String use_yn = list.get(0).getUseYn();
			String day_yn = list.get(0).getDayYn();
			
			eventResponse.setETCData("c_nrt_yn", nrt_yn);
			eventResponse.setETCData("c_use_yn", use_yn);
			eventResponse.setETCData("c_day_yn", day_yn);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0011 : SAVE <br>
	 * 해당 년월, TRADE의 배치처리된 데이터가(TOT_PORT_STL_AMT) 있는지 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 
	private EventResponse searchPortStlAmtCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0011Event event = (FnsTot0011Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getTotPortStlAmtVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getTotPortStlAmtVO().setStlYrmon(stlYrmon);

			List<TotPortStlAmtVO> list = command.searchPortStlAmtCheck(event.getTotPortStlAmtVO());

			eventResponse.setRsVoList(list);
			
			int total_port = list.size();
			
			eventResponse.setETCData("total_port", total_port+"");
	

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}*/

	/**
	 * FNS_TOT_0011 : SEARCH <br>
	 * SHEET 에 해당 년월, TRADE의 데이터를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxableAmountConfirmationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0011Event event = (FnsTot0011Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getVvdStlAmtVO().setStlYrmon(stlYrmon);

			List<VvdStlAmtVO> list = command.searchTaxableAmountConfirmationList(event.getVvdStlAmtVO());
			
			eventResponse.setRsVoList(list);
			
			int total_cnt = list.size();
			double total_txAmt = 0;
			
			for(int i= 0; i<total_cnt; i++){
				total_txAmt = total_txAmt + Double.parseDouble(list.get(i).getTongTaxAmt());
			}
		
			log.debug("::CALL::> total_txAmt :::::::::    "+total_txAmt);
			eventResponse.setETCData("total_txAmt", total_txAmt+"");

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0011 : SAVE <br>
	 * 체크된 NRT, USE, DAYS 데이터를 TOT_STL_CFM에 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTaxableAmountConfirmationMark (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0011Event event = (FnsTot0011Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			begin();
			
			
			String stlYrmon = event.getTotPortStlAmtVO().getStlYrmon();
			String trd = event.getTotPortStlAmtVO().getTrdCd();
			String msgYrmon = stlYrmon.substring(0, 4)+"."+ stlYrmon.substring(5, 7);
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			String bat_yn = "N";
			
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getTotPortStlAmtVO().setStlYrmon(stlYrmon);
			//해당 년월, TRADE의 배치처리된 데이터가(TOT_PORT_STL_AMT) 있는지 조회한다.
			List<TotPortStlAmtVO> batChkList = command.searchPortStlAmtCheck(event.getTotPortStlAmtVO());

			int total_port = batChkList.size();
			log.debug("total_port :::::::::"+total_port);
			if(total_port == 0){
				log.debug("0인 경우");
				
				eventResponse.setUserMessage(new ErrorHandler("TOT10002", "[Year/Month:"+msgYrmon +"] There is no trade("+ trd +") batched.").getMessage());
			}else{
				log.debug("::CALL::> FNS_TOT_0011 SC >createTaxableAmountConfirmationMark :::::::::");

				event.getStlCfmVO().setStlYrmon(stlYrmon);
				
				command.createTaxableAmountConfirmationMark (event.getStlCfmVO(),account);
				eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
				bat_yn = "Y";
			}
			eventResponse.setETCData("batch_yn", bat_yn);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_TOT_0013 : SEARCH <br>
	 * SHEET 에 해당 VESSEL, 기간의  Taxable Amount 데이터를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxableAmountListByVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0013Event event = (FnsTot0013Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);

			String eStlYrmon = event.getVvdStlAmtVO().getEStlYrmon();
			eStlYrmon = eStlYrmon.substring(0, 4)+ eStlYrmon.substring(5, 7);

			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			log.debug("::CALL::> eStlYrmon :::::::::    "+eStlYrmon);
			event.getVvdStlAmtVO().setStlYrmon(stlYrmon);
			event.getVvdStlAmtVO().setEStlYrmon(eStlYrmon);
			List<VvdStlAmtVO> list = command.searchTaxableAmountListByVessel(event.getVvdStlAmtVO());

			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0012 : OPEN <br>
	 * FNS_TOT_0013 DETAIL 버튼 클릭시 SHEET 에 상세데이터를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchTaxableAmountConfirmationDetailListByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0012Event event = (FnsTot0012Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getPortStlAmtVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
			log.debug("::CALL::> stlYrmon ::::::::: DDDD   "+stlYrmon);
			event.getPortStlAmtVO().setStlYrmon(stlYrmon);

			List<PortStlAmtVO> list = command.searchTaxableAmountConfirmationDetailListByVVD(event.getPortStlAmtVO());

			eventResponse.setRsVoList(list);


		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0012 : ONCHANGE시  <br>
	 * 수정후 재계산하여 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse recalculateTaxableAmountForVoyageDay (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0012Event event = (FnsTot0012Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
		try{
			begin(); 
			command.recalculateTaxableAmountForVoyageDay (event.getPortStlAmtVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * FNS_TOT_0012 : ONCHANGE시  <br>
	 * 수정후 재계산하여 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse recalculateTaxableAmountForLoadCapa (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0012Event event = (FnsTot0012Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
		try{
			begin(); 
			command.recalculateTaxableAmountForLoadCapa (event.getPortStlAmtVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * FNS_TOT_0015 : SEARCH <br>
	 * SHEET 에 LANE, TRADE, 기간에 해당하는 데이터를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTaxableAmountListByLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0015Event event = (FnsTot0015Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);

			String eStlYrmon = event.getVvdStlAmtVO().getEStlYrmon();
			eStlYrmon = eStlYrmon.substring(0, 4)+ eStlYrmon.substring(5, 7);

			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			log.debug("::CALL::> eStlYrmon :::::::::    "+eStlYrmon);
			event.getVvdStlAmtVO().setStlYrmon(stlYrmon);
			event.getVvdStlAmtVO().setEStlYrmon(eStlYrmon);
			List<VvdStlAmtVO> list = command.searchTaxableAmountListByLane(event.getVvdStlAmtVO());

			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0018 : SEARCH <br>
	 * SHEET 에 해당년월의 톤세 관련 데이터와 현재상태 그리고 총건수및 총합계를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchTaxableAmountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0018Event event = (FnsTot0018Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getErpIfVO().getStlYrmon();
			String stlYrmon2 = event.getStlCfmVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			stlYrmon2 = stlYrmon2.substring(0, 4)+ stlYrmon2.substring(5, 7);
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			
			event.getErpIfVO().setStlYrmon(stlYrmon);
			event.getStlCfmVO().setStlYrmon(stlYrmon2);
			
			List<ErpIfVO> list = command.searchTaxableAmountList(event.getErpIfVO());
			List<StlCfmVO> status = command.searchTaxableAmountStatus(event.getStlCfmVO());


			
			int total_cnt = list.size();
			double total_txAmt = 0;
			int feederCnt = 0;
			
			for(int i= 0; i<total_cnt; i++){
				if(list.get(i).getTongFletTpCd().equals("Feeder")){
					feederCnt = feederCnt+1;
				}
				total_txAmt = total_txAmt + Double.parseDouble(list.get(i).getTongTaxAmt());
			}
			
			if(total_cnt == 0){
				eventResponse.setETCData("status", "");
			}else{
				eventResponse.setETCData("status", status.get(0).getStatus());
			}
			
			if(feederCnt > 0){
				eventResponse.setETCData("feederYn", "Y");
			}else{
				eventResponse.setETCData("feederYn", "N");
			}
			
			eventResponse.setETCData("total_cnt", total_cnt+"");
			eventResponse.setETCData("total_txAmt", total_txAmt+"");
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0018 : year close <br>
	 * 해당년도를 마감한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse closeTonnageTaxStlYear (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0018Event event = (FnsTot0018Event)e;
		
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			begin();

			log.debug("::CALL::> stlYr :::::::::    "+event.getTotStlClzVO().getStlYr());
				
			command.closeTonnageTaxStlYear (event.getTotStlClzVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("SPC00010").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_TOT_0018 : ERP I/F<br>
	 * 해당년월의 톤세 관련 데이터를 재생성하여 ERP 연동처리한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse createTaxableAmountIF(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0018Event event = (FnsTot0018Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
		
		try{
			log.debug("::CALL::> createTaxableAmountIF :::::::::    ");

			begin();

			String stlYrmon = event.getErpIfVO().getStlYrmon();
			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			
			String key = command.createTaxableAmountIF(stlYrmon,account);
			eventResponse.setETCData("KEY", key);
			//eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * FNS_TOT_0016 : Retrive <br>
	 * SHEET에 해당년월, data type, 선박 기준 feeder 데이터를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederTaxableAmountListByVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0016Event event = (FnsTot0016Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getFdrStlAmtVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);

			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getFdrStlAmtVO().setStlYrmon(stlYrmon);

			List<FdrStlAmtVO> list = command.searchFeederTaxableAmountListByVessel(event.getFdrStlAmtVO());

			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * FNS_TOT_0016 : Save <br>
	 * SHEET에 수정한 데이터를 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyFeederTaxableAmountByVessel (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0016Event event = (FnsTot0016Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
		try{
			begin();
			command.modifyFeederTaxableAmountByVessel(event.getFdrStlAmtVOs(),account);
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_TOT_0017 : Retrive <br>
	 * SHEET에 해당년월의 feeder summary 데이터를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFeederTaxableAmountListByMonthly(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0017Event event = (FnsTot0017Event)e;
		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

		try{
			
			String stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
			stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);

			log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
			event.getVvdStlAmtVO().setStlYrmon(stlYrmon);

			List<VvdStlAmtVO> list = command.searchFeederTaxableAmountListByMonthly(event.getVvdStlAmtVO());

			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}	

	/**
	 * FNS_TOT_0017 : Save <br>
	 * SHEET에 해당년월의 feeder summary 데이터를 TOT_VVD_STL_AMT로 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createFeederTaxableAmount (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsTot0017Event event = (FnsTot0017Event)e;

		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
		try{
			begin();

			command.createFeederTaxableAmount(event.getVvdStlAmtVOs(),account);

			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_TOT_0021 : Retrive <br>
	 * 해당기간의 배치정보를 조회한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonFeederNFeederTaxBatchHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsTot0021Event event = (FnsTot0021Event)e;


		try{
			
			TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
			
			List<JbSkdVO> list = command.searchNonFeederNFeederTaxBatchHis(event.getJbSkdVO(),"search");
			
			String jobID = "";
			String s_schdl_dt  = "";
			String e_schdl_dt  = "";
			String batID = "";
			
			int jobStatus = 10;
			
			if(list.size() > 0){
				for(int i=0; i<list.size();i++){
	            	jobID = list.get(i).getJbId();
	            	s_schdl_dt = list.get(i).getEffDt();
	            	batID = list.get(i).getBatId();
	
	                ScheduleUtil su = new ScheduleUtil();
	                
	    			jobStatus = su.getJobStatus(jobID,batID);	
	    			e_schdl_dt  = su.getJobEndTime(jobID,batID);	
	    			
	    			if(e_schdl_dt == null){
	    				e_schdl_dt = "";
	    			}
	    			
	    			log.debug(":: jobID :::::::::    "+jobID);
	    			log.debug(":: jobStatus :::::::::    "+jobStatus);
	    			log.debug(":: e_schdl_dt :::::::::    "+e_schdl_dt);	   
	    			log.debug(":: batID :::::::::    "+batID);
	    			
	    			if(jobStatus == 0){
	    				log.debug("here:::::::::::::::::::::::::::::::::::::::::::::::");
	    				list.get(i).setJbStatus("Scheduled");
	    			}else if(jobStatus == 1){
	    				list.get(i).setJbStatus("Proceeding");
	    			}else if(jobStatus == 4){
	    				list.get(i).setJbStatus("Completed");
	    			}else if(jobStatus == 5){
	    				list.get(i).setJbStatus("Failure");
	    			}else if(jobStatus == 7){
	    				list.get(i).setJbStatus("Canceled");
	    			}else{
	    				list.get(i).setJbStatus("Null");
	    			}
	    			
	    			list.get(i).setJbEndDt(e_schdl_dt);
				}
             }

			 eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
		
		
	}	
	
	/**
	 * FNS_TOT_0021 : Submit <br>
	 *  해당기간의 배치스케쥴과 history정보를 저장한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createNonFeederNFeederTaxBatch (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		FnsTot0021Event event = (FnsTot0021Event)e;

		TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
		
		try{
			log.debug("::CALL::> createNonFeederNFeederTaxBatch :::::::::    ");
			
			
			String stDt = event.getStDate();
			String runJb = event.getRunJob();
			String paramStDt = event.getParamStartDate();
			String paramEndDt = event.getParamEndDate();
			//String paramDt  = paramStDt +"#"+paramEndDt;
			String batId = event.getBatId();
			String batItmNm = null;
			log.debug(":: stDt :::::::::    "+stDt);
			log.debug(":: runJb :::::::::    "+runJb);
			log.debug(":: paramStDt :::::::::    "+paramStDt);
			log.debug(":: paramEndDt :::::::::    "+paramEndDt);
			log.debug(":: batId :::::::::    "+batId);

			event.getJbSkdVO().setJbFmYrmon(paramStDt);
			event.getJbSkdVO().setJbToYrmon(paramEndDt);   //임시
			
			if(batId.equals("FNS_TOT_B001")){
				batItmNm ="ALL";
			}else if(batId.equals("FNS_TOT_B002")){
				batItmNm = "MAIN TRADE";
			}else if(batId.equals("FNS_TOT_B003")){
				batItmNm = "FEEDER";
			}
			event.getJbSkdVO().setBatItmNm(batItmNm);
//			log.debug(":: getBatItmNm :::::::::    "+event.getJbSkdVO().getBatItmNm());
//			List<JbSkdVO> list = command.searchNonFeederNFeederTaxBatchHis(event.getJbSkdVO(),"status");
//			
//			String resJobID = "";
//			String resBatID = "";
//			int jobStatus = 10;
//			String e_schdl_dt = "";
//			
//			if(list.size() > 0){
//				for(int i=0; i<list.size();i++){
//				    resJobID = list.get(i).getJbId();
//				    resBatID = list.get(i).getBatId();
//				    
//	            	ScheduleUtil su = new ScheduleUtil();
//	                
//	    			jobStatus = su.getJobStatus(resJobID,resBatID);	
//	    			e_schdl_dt  = su.getJobEndTime(resJobID,resBatID);	
//	    			
//	    			if(e_schdl_dt == null){
//	    				e_schdl_dt = "";
//	    			}
//	    			
//	    			log.debug(":: resJobID :::::::::    "+resJobID);
//	    			log.debug(":: jobStatus :::::::::    "+jobStatus);
//	    			log.debug(":: e_schdl_dt :::::::::    "+e_schdl_dt);	   
//	    			
//	    			if(jobStatus == 0){
//	    				eventResponse.setETCData("exp_msg", "0");
//	    				return eventResponse;
//	    				//throw new EventException(new ErrorHandler("TOT10002", "One of batch is already scheduled in this period.").getMessage());
//	    			}else if(jobStatus == 1){
//	    				eventResponse.setETCData("exp_msg", "1");
//	    				return eventResponse;
//	    				//throw new EventException(new ErrorHandler("TOT10002", "One of batch is running right now.").getMessage());
//	    			}
//				}	
//             }

            boolean status = command.isRunningBatch(batId);
            
            if (status == true) {
				eventResponse.setUserMessage(new ErrorHandler("TOT00078").getUserMessage());
				return eventResponse;
			}
			
			String jobID = excuteNonFeederNFeederJob (paramStDt, paramEndDt, runJb, stDt, batId);		
			log.debug(":: jobID :::::::::    "+jobID);
			begin();
			log.debug(":: 11111 :::::::::    ");
			command.createNonFeederNFeederTaxBatch(paramStDt, paramEndDt ,stDt ,jobID, batItmNm ,account);
			log.debug(":: 22222 :::::::::    ");
			eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
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
	 * FNS_TOT_0021 : Cancel <br>
	 * 해당 job_id의 배치스케쥴을 cancel하고 history정보를 삭제한다. <br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
		private EventResponse cancelNonFeederNFeederTaxBatch(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			FnsTot0021Event event = (FnsTot0021Event)e;
			TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

			try{
				log.debug("::CALL::> cancelNonFeederNFeederTaxBatch :::::::::    ");
				
				JbSkdVO[] jbSkdVOs = event.getJbSkdVOs();
				String resJobID = "";
				begin();
				for ( int i=0; i<jbSkdVOs.length; i++ ) {
				     log.debug("upd_chk.............................."+jbSkdVOs[i].getUpdChk());
					if ( jbSkdVOs[i].getUpdChk().equals("1")){
						log.debug("::CALL::> FNS_TOT_0021 BC >cancel :  :::::::::"+i);
						resJobID = jbSkdVOs[i].getJbId();
						log.debug("::CALL::> FNS_TOT_0021 BC >resJobID :  :::::::::"+jbSkdVOs[i].getJbId());
						ScheduleUtil su = new ScheduleUtil();
						 
						boolean cancelYn = su.cancelJob(resJobID);
						log.debug(":: cancelYn :::::::::    "+cancelYn);
						command.removeNonFeederNFeederTaxBatch(resJobID);
					}
				}
				
				eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
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
		 * FNS_TOT_0021 : Submit <br>
		 * 해당년월의 입력한 배치정보로 실시간 수행 또는 스케쥴 예약을 수행한다. <br>
		 * 
		 * @param String paramStDt
		 * @param String paramEndDt
		 * @param String runJb
		 * @param String stDt
		 * @param String batId
		 * @return String
		 * @exception EventException
		 */
		private String excuteNonFeederNFeederJob (String paramStDt, String paramEndDt, String runJb, String stDt, String batId) throws EventException {
			
			String jobID = "";
			
			try{
				log.debug("::CALL::> excuteNonFeederNFeederJob :::::::::    ");


				log.debug(":: stDt :::::::::    "+stDt);
				log.debug(":: runJb :::::::::    "+runJb);
				log.debug(":: paramStDt :::::::::    "+paramStDt);
				log.debug(":: paramEndDt :::::::::    "+paramEndDt);
				log.debug(":: batId :::::::::    "+batId);
				
//				String paramDt =paramStDt;
//				String param_yymm  = paramStDt;
//				
//				int res = DateTime.monthsBetween(param_yymm,paramEndDt,"yyyyMM");
//			
//				log.debug(":: res :::::::::    "+res);
//				
//				for(int i=0; i<res; i++){
//					
//					param_yymm = DateTime.addMonths(param_yymm, 1, "yyyyMM") ;
//					paramDt = paramDt+"#"+param_yymm;
//								
//				}
				
				String paramDt = paramStDt+"#"+paramEndDt;
				log.debug("::::::::::::::::::::::: paramDt :::::::::    "+paramDt);
				ScheduleUtil su = new ScheduleUtil();
				
				if(runJb.equals("1")){
					//작업 즉시 실행 API
					log.debug(":: runJb 1:::::::::    "+paramDt);
					jobID = su.directExecuteJob(batId,paramDt);
				}else if(runJb.equals("0")){
					// 작업 예약 실행 API (프로그램번호, 예약시간, 파라미터문자열)
					log.debug(":: runJb 0:::::::::    "+paramDt);
					jobID = su.reserveExecuteJob(batId, stDt,paramDt);
				}else{
					log.debug(":: nothing:::::::::   ");
				}

				//jobID = "2222222222";
//			}catch(EventException ex){
//				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}				
			return jobID;
		}		

		/**
		 * FNS_TOT_0022 : Retrive <br>
		 * 해당년월의 Actual vol과 일수정보를 조회한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchInquiryActVsDays(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0022Event event = (FnsTot0022Event)e;
			TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();


			try{
				
				String stlYrmon = event.getPortStlAmtVO().getStlYrmon();
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);

				String e_stlYrmon = event.getPortStlAmtVO().getEStlYrmon();
				e_stlYrmon = e_stlYrmon.substring(0, 4)+ e_stlYrmon.substring(5, 7);
				log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
				event.getPortStlAmtVO().setStlYrmon(stlYrmon);
				event.getPortStlAmtVO().setEStlYrmon(e_stlYrmon);
				
				List<PortStlAmtVO> list = command.searchInquiryActVsDays(event.getPortStlAmtVO());

				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
			
			
			
		}	

		/**
		 * FNS_TOT_0023 : Retrive <br>
		 * 해당년월의 배치후 누락된 port 스케쥴을 조회한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchExceptedVslPortSkd(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0023Event event = (FnsTot0023Event)e;
			TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();


			try{
				
				String stlYrmon = event.getPortStlAmtVO().getStlYrmon();
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);

				String e_stlYrmon = event.getPortStlAmtVO().getEStlYrmon();
				e_stlYrmon = e_stlYrmon.substring(0, 4)+ e_stlYrmon.substring(5, 7);
				log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
				event.getPortStlAmtVO().setStlYrmon(stlYrmon);
				event.getPortStlAmtVO().setEStlYrmon(e_stlYrmon);
				
				List<PortStlAmtVO> list = command.searchExceptedVslPortSkd(event.getPortStlAmtVO());

				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
			
			
			
		}	
		
		/**
		 * FNS_TOT_0022 : 기간 onchange시 <br>
		 * Inquiry port Zero Days vs Actual Load 화면 기간 onchange시 Trade combo list를 조회합니다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */	
		private EventResponse searchZeroDaysVsActualLoadTrdCmbList(Event e) throws EventException {

			FnsTot0022Event event = (FnsTot0022Event)e;
			
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			try{
				TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
				
				String s_stlYrmon = event.getPortStlAmtVO().getStlYrmon();
				s_stlYrmon = s_stlYrmon.replace("-", "");
				log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
	
				String e_stlYrmon = event.getPortStlAmtVO().getEStlYrmon();
				e_stlYrmon = e_stlYrmon.replace("-", "");
				log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
	
				totCodeParamVO.setSuperCd1(s_stlYrmon);
				totCodeParamVO.setSuperCd2(e_stlYrmon);
				
				List<TotCodeInfoVO>  trd_list = command.searchBsaTrdCodeList(totCodeParamVO);
				
				String trdCmb = makeComboString(trd_list, 2);//IBSheet 내 combo용
				log.debug("::CALL::> searchBsaTrdCodeList  >trdCmb :::::::::"+trdCmb);
				
				eventResponse.setETCData("trdCmb"       , trdCmb );
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}

		/**
		 * FNS_TOT_0022 : trade 콤보 onchange시 <br>
		 * Inquiry port Zero Days vs Actual Load 화면 trade 콤보 onchange시 Lane combo list를 조회합니다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */	
		private EventResponse searchZeroDaysVsActualLoadLaneCmbList(Event e) throws EventException {

			FnsTot0022Event event = (FnsTot0022Event)e;
			
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			try{
				TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
				
				String s_stlYrmon = event.getPortStlAmtVO().getStlYrmon();
				s_stlYrmon = s_stlYrmon.replace("-", "");
				log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
	
				String e_stlYrmon = event.getPortStlAmtVO().getEStlYrmon();
				e_stlYrmon = e_stlYrmon.replace("-", "");
				log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
	
				String trd_cd = event.getPortStlAmtVO().getTrdCd();
				
				totCodeParamVO.setSuperCd1(s_stlYrmon);
				totCodeParamVO.setSuperCd2(e_stlYrmon);
				totCodeParamVO.setCode(trd_cd);
				
				List<TotCodeInfoVO>  lane_list = command.searchBsaLaneCodeList(totCodeParamVO);
				
				String laneCmb = makeComboString(lane_list, 2);//IBSheet 내 combo용
				log.debug("::CALL::> searchBsaLaneCodeList  >laneCmb :::::::::"+laneCmb);
	
				eventResponse.setETCData("laneCmb"       , laneCmb );
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}

		/**
		 * FNS_TOT_0015 : 기간 onchange시 <br>
		 * Taxable Amount Inquiry by Lane 화면 기간 onchange시 Trade combo list를 조회합니다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */	
		private EventResponse searchTaxableAmountListByLaneTrdCmbList(Event e) throws EventException {

			FnsTot0015Event event = (FnsTot0015Event)e;
			
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			try{
				TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
				
				String s_stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
				s_stlYrmon = s_stlYrmon.replace("-", "");
				log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
	
				String e_stlYrmon = event.getVvdStlAmtVO().getEStlYrmon();
				e_stlYrmon = e_stlYrmon.replace("-", "");
				log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
	
				totCodeParamVO.setSuperCd1(s_stlYrmon);
				totCodeParamVO.setSuperCd2(e_stlYrmon);
				
				List<TotCodeInfoVO>  trd_list = command.searchBsaTrdCodeList(totCodeParamVO);
				
				String trdCmb = makeComboString(trd_list, 2);//IBSheet 내 combo용
				log.debug("::CALL::> searchBsaTrdCodeList  >trdCmb :::::::::"+trdCmb);
				
				eventResponse.setETCData("trdCmb"       , trdCmb );
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}

		/**
		 * FNS_TOT_0015 : trade 콤보 onchange시 <br>
		 * Taxable Amount Inquiry by Lane 화면 trade 콤보 onchange시 Lane combo list를 조회합니다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */	
		private EventResponse searchTaxableAmountListByLaneLaneCmbList(Event e) throws EventException {

			FnsTot0015Event event = (FnsTot0015Event)e;
			
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			try{
				TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
				
				String s_stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
				s_stlYrmon = s_stlYrmon.replace("-", "");
				log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
	
				String e_stlYrmon = event.getVvdStlAmtVO().getEStlYrmon();
				e_stlYrmon = e_stlYrmon.replace("-", "");
				log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
	
				String trd_cd = event.getVvdStlAmtVO().getTrdCd();
				
				totCodeParamVO.setSuperCd1(s_stlYrmon);
				totCodeParamVO.setSuperCd2(e_stlYrmon);
				totCodeParamVO.setCode(trd_cd);
				
				List<TotCodeInfoVO>  lane_list = command.searchBsaLaneCodeList(totCodeParamVO);
				
				String laneCmb = makeComboString(lane_list, 2);//IBSheet 내 combo용
				log.debug("::CALL::> searchBsaLaneCodeList  >laneCmb :::::::::"+laneCmb);
	
				eventResponse.setETCData("laneCmb"       , laneCmb );
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}

		/**
		 * FNS_TOT_0023 : 기간 onchange시 <br>
		 * Inquiry port VSK vs TOT 화면 기간 onchange시 Trade combo list를 조회합니다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */	
		private EventResponse searchPortVskTotTrdCmbList(Event e) throws EventException {

			FnsTot0023Event event = (FnsTot0023Event)e;
			
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			try{
				TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
				
				String s_stlYrmon = event.getPortStlAmtVO().getStlYrmon();
				s_stlYrmon = s_stlYrmon.replace("-", "");
				log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
	
				String e_stlYrmon = event.getPortStlAmtVO().getEStlYrmon();
				e_stlYrmon = e_stlYrmon.replace("-", "");
				log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
	
				totCodeParamVO.setSuperCd1(s_stlYrmon);
				totCodeParamVO.setSuperCd2(e_stlYrmon);
				
				List<TotCodeInfoVO>  trd_list = command.searchBsaTrdCodeList(totCodeParamVO);
				
				String trdCmb = makeComboString(trd_list, 2);//IBSheet 내 combo용
				log.debug("::CALL::> searchBsaTrdCodeList  >trdCmb :::::::::"+trdCmb);
				
				eventResponse.setETCData("trdCmb"       , trdCmb );
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}

		/**
		 * FNS_TOT_0023 : trade 콤보 onchange시 <br>
		 * Inquiry port VSK vs TOT 화면 trade 콤보 onchange시 Lane combo list를 조회합니다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */	
		private EventResponse searchPortVskTotLaneCmbList(Event e) throws EventException {

			FnsTot0023Event event = (FnsTot0023Event)e;
			
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			try{
				TotCodeParamVO totCodeParamVO = new TotCodeParamVO();
				
				String s_stlYrmon = event.getPortStlAmtVO().getStlYrmon();
				s_stlYrmon = s_stlYrmon.replace("-", "");
				log.debug("::CALL::> s_stlYrmon :::::::::    "+s_stlYrmon);
	
				String e_stlYrmon = event.getPortStlAmtVO().getEStlYrmon();
				e_stlYrmon = e_stlYrmon.replace("-", "");
				log.debug("::CALL::> e_stlYrmon :::::::::    "+e_stlYrmon);
	
				String trd_cd = event.getPortStlAmtVO().getTrdCd();
				
				totCodeParamVO.setSuperCd1(s_stlYrmon);
				totCodeParamVO.setSuperCd2(e_stlYrmon);
				totCodeParamVO.setCode(trd_cd);
				
				List<TotCodeInfoVO>  lane_list = command.searchBsaLaneCodeList(totCodeParamVO);
				
				String laneCmb = makeComboString(lane_list, 2);//IBSheet 내 combo용
				log.debug("::CALL::> searchBsaLaneCodeList  >laneCmb :::::::::"+laneCmb);
	
				eventResponse.setETCData("laneCmb"       , laneCmb );
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * 공통함수 <br>
		 * List를 combo용 String으로 변환합니다. <br>
		 * 
		 * @param List<TotCodeInfoVO> list, int flg 
		 * @return String
		 * @exception EventException
		 */
		@SuppressWarnings("unchecked")
		private String makeComboString(List<TotCodeInfoVO> list, int flg) throws EventException{
			String rtnVal = null;
			
			try{
				StringBuilder sb = new StringBuilder();
	
				Iterator iterator = (Iterator) list.iterator();
	
				while(iterator.hasNext()){
					TotCodeInfoVO totCodeInfoVO = (TotCodeInfoVO)iterator.next();
					
					//일반적인 IBCombo용(name, code|)
					if (flg==0){
						sb.append(totCodeInfoVO.getName()+","+totCodeInfoVO.getCode()+"|");
					//IBCombo (code, code|)
					}else if (flg==1){
						sb.append(totCodeInfoVO.getCode()+","+totCodeInfoVO.getCode()+"|");
					//IBSheet의 코드부분(code|)
					}else if (flg==2){
						sb.append(totCodeInfoVO.getCode()+"|");
					//IBSheet의 코드명부분(name|)
					}else if (flg==3){
						sb.append(totCodeInfoVO.getName()+"|");
					//SuperCd조회
					}else if (flg==4){
						sb.append(totCodeInfoVO.getSuperCd1()+","+totCodeInfoVO.getSuperCd2()+","+totCodeInfoVO.getCode()+"|");
					//Code, Name
					}else if (flg==5){
						sb.append(totCodeInfoVO.getCode()+","+totCodeInfoVO.getName()+"|");
					//Port 
					}else if (flg==6){
						sb.append(totCodeInfoVO.getSuperCd1()+","+totCodeInfoVO.getCode()+"|");
					}else if (flg==7){
						sb.append(totCodeInfoVO.getSuperCd1()+"|");
					}
				}
	
				rtnVal = sb.toString();
				
				if (rtnVal.length() > 0){
					rtnVal = rtnVal.substring(0,rtnVal.length()-1);
				}
//			}catch(EventException ex){
//				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return rtnVal;
		}

		/**
		 * 배치의 수행완료 시각을 return한다. 
		 * @param String batItmNm
		 * @param String stlYrmon
		 * @return String
		 * @throws EventException
		 */
		private String searchJbEndDt(String batItmNm, String stlYrmon) throws EventException {
			String jbEndDt = "";
			try {
				TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
	
				JbSkdVO jbSkdVO = new JbSkdVO();
	
				jbSkdVO.setBatItmNm(batItmNm);
				jbSkdVO.setJbFmYrmon(stlYrmon);
	
				List<JbSkdVO> list = command.searchJbIdList(jbSkdVO);

				for (int i=0; i < list.size(); i++ ) {
					jbEndDt = list.get(i).getCreDt();
				}
/*	
				2012-09-10 CHM-201220130
				String jobID = "";
				String batID = "";
	
				int jobStatus = 10;
	
				ScheduleUtil su = new ScheduleUtil();
	
				for (int i = 0; i < list.size(); i++) {
					jobID = list.get(i).getJbId ();
					batID = list.get(i).getBatId();
	
					jobStatus  = su.getJobStatus(jobID, batID);
					
					if (jobStatus == 4){
						jbEndDt = su.getJobEndTime(jobID, batID);
						break;
					}
				}
*/				
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return jbEndDt;
		}	

		/**
		 * 월이 변경될때 마감여부와 해당 배치의 최종 수행일시를 조회한다.
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse checkSettlementClosing(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0017Event event = (FnsTot0017Event)e;
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
			String stlClzFlg = null;
			try{
				String stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
				List<TotStlClzVO> list = command.checkSettlementClosing(stlYrmon.substring(0,4));

				if(list.size() > 0){
	            	stlClzFlg = list.get(0).getStlClzFlg();
	            }else{
	            	stlClzFlg = "N";
	            }
				// 2012-09-10 CHM-201220130
				//String jbEndDt = this.searchJbEndDt("FEEDER", stlYrmon);
				eventResponse.setETCData("stlClzFlg", stlClzFlg);
				//eventResponse.setETCData("jbEndDt"  , jbEndDt);
				
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
			return eventResponse;
		}
		/**
		 * 월이 변경될때 마감여부와 해당 배치의 최종 수행일시를 조회한다.
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse checkSettlementClosing0011(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0011Event event = (FnsTot0011Event)e;
			TOTFindCodeBC command = new TOTFindCodeBCImpl();
			String stlClzFlg = null;
			try{
				String stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
				List<TotStlClzVO> list = command.checkSettlementClosing(stlYrmon.substring(0,4));

				if(list.size() > 0){
	            	stlClzFlg = list.get(0).getStlClzFlg();
	            }else{
	            	stlClzFlg = "N";
	            }
				// 2012-09-10 CHM-201220130
				//String jbEndDt = this.searchJbEndDt("ALL", stlYrmon);
				eventResponse.setETCData("stlClzFlg", stlClzFlg);
				//eventResponse.setETCData("jbEndDt"  , jbEndDt);
				
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
			return eventResponse;
		}
		
		/**
		 * FNS_TOT_0024 : SEARCHLIST<br>
		 * 운항중인 모든 선박(피더선박 제외)들의 기본 BSA 변동별 내역을 조회한다.<br>
		 *
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchBasicBsaSummary(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0024Event event = (FnsTot0024Event)e;
			TonnageTaxFillingBC command = new TonnageTaxFillingBCImpl();
			
			String year = event.getYear();

			try{
				List<SearchBasicBsaSummaryVO> list = command.searchBasicBsaSummary(year);
				String upd_dt = command.searchBasicBsaSummaryUpdate(year);
				
				eventResponse.setRsVoList(list);
				eventResponse.setETCData("upd_dt", upd_dt);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * FNS_TOT_0025 : SEARCH <br>
		 * 운항중인 모든 선박(피더선박 제외)들의 초과 BSA 변동별 내역을 조회한다.<br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchActualBsaSummary(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0025Event event = (FnsTot0025Event)e;
			TonnageTaxFillingBC command = new TonnageTaxFillingBCImpl();
			
			String year = event.getYear();

			try{
				List<SearchActualBsaSummaryVO> list = command.searchActualBsaSummary(year);
				String upd_dt = command.searchBasicBsaSummaryUpdate(year);
				
				eventResponse.setRsVoList(list);
				eventResponse.setETCData("upd_dt", upd_dt);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * FNS_TOT_0026 : SEARCH <br>
		 * 대선선박과 계선선박의 내역을 조회한다.<br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchHiringOutAndLayingUpSummary(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0026Event event = (FnsTot0026Event)e;
			TonnageTaxFillingBC command = new TonnageTaxFillingBCImpl();
			
			String year = event.getYear();

			try{
				List<SearchHiringOutAndLayingUpSummaryVO> list = command.searchHiringOutAndLayingUpSummary(year);
				String upd_dt = command.searchBasicBsaSummaryUpdate(year);
				
				eventResponse.setRsVoList(list);
				eventResponse.setETCData("upd_dt", upd_dt);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * FNS_TOT_0027 : Retrive <br>
		 * 해당기간의 배치정보를 조회한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchSummaryCreationBatch(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0027Event event = (FnsTot0027Event)e;
			
			String jobID = "";
			String e_schdl_dt  = "";
			String batID = "";
			int jobStatus = 10;

			try{
				TonnageTaxFillingBC command = new TonnageTaxFillingBCImpl();
				List<SearchSummaryCreationBatchVO> list = command.searchSummaryCreationBatch(event.getFnsTot0027ConditionVO(), "search");
				
				if(list.size() > 0){
					for(int i=0; i<list.size();i++){
		            	jobID = list.get(i).getJobId();
		            	batID = list.get(i).getBatId();
		
		                ScheduleUtil su = new ScheduleUtil();
		    			jobStatus = su.getJobStatus(jobID,batID);	
		    			e_schdl_dt  = su.getJobEndTime(jobID,batID);	
		    			
		    			if(e_schdl_dt == null){
		    				e_schdl_dt = "";
		    			}
		    			
		    			if(jobStatus == 0){
		    				list.get(i).setJbStatus("Scheduled");
		    			}else if(jobStatus == 1){
		    				list.get(i).setJbStatus("Proceeding");
		    			}else if(jobStatus == 4){
		    				list.get(i).setJbStatus("Completed");
		    			}else if(jobStatus == 5){
		    				list.get(i).setJbStatus("Failure");
		    			}else if(jobStatus == 7){
		    				list.get(i).setJbStatus("Canceled");
		    			}else{
		    				list.get(i).setJbStatus("Null");
		    			}
		    			
		    			list.get(i).setJbEndDt(e_schdl_dt);
					}
	             }
				 eventResponse.setRsVoList(list);

			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			
			return eventResponse;
		}
		
		/**
		 * FNS_TOT_0027 : Submit <br>
		 *  해당기간의 배치스케쥴과 history정보를 저장한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse createSummaryCreationBatch (Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0027Event event = (FnsTot0027Event)e;
			TonnageTaxFillingBC command = new TonnageTaxFillingBCImpl();
			FnsTot0027ConditionVO conditionVO = null;
			
//			String resJobID = "";
//			String resBatID = "";
//			int jobStatus = 10;
			String exeJobID = "";
			
			try{
				begin();
				conditionVO = event.getFnsTot0027ConditionVO();
//				List<SearchSummaryCreationBatchVO> list = command.searchSummaryCreationBatch(conditionVO, "status");
				
			/* 2011.03.22 이준범 [CHM-201109639-01]
			 * 현상 : 로그 파일이 오래 것들은 자등으로 삭제되는데 TOT 기능에서 로그 파일 테이블에서 건수가 있으면 배치가 수행될 수 있게  되어 있음
			 * 처리 : 위 처리 기능을 삭제하면 됨(업무에 문제가 없음) - **설계자 의견**
			 * < 대상 배치 >
			 * FNS_TOT_B004   Basic BSA Summary
			 * FNS_TOT_B005   Actual BSA Summary
			 */
				
//				if(list.size() > 0){
//					for(int i=0; i<list.size();i++){
//					    resJobID = list.get(i).getJobId();
//					    resBatID = list.get(i).getBatId();
//					    
//		            	ScheduleUtil su = new ScheduleUtil();
//		                
//		    			jobStatus = su.getJobStatus(resJobID, resBatID);
//		    			
//		    			if(jobStatus == 0){
//		    				eventResponse.setETCData("exp_msg", "0");
//		    				return eventResponse;
//		    			}else if(jobStatus == 1){
//		    				eventResponse.setETCData("exp_msg", "1");
//		    				return eventResponse;
//		    			}
//					}	
//	             }
				
	            boolean status = true;
				
				// Item에서 ALL을 선택한 경우 FNS_TOT_B004, FNS_TOT_B005 를 다 실행한다.
				if ("ALL".equals(conditionVO.getBatId())) {
					
		            status = command.isRunningBatch("FNS_TOT_B004");
		            if (status == true) {
						eventResponse.setUserMessage(new ErrorHandler("TOT00078").getUserMessage());
						return eventResponse;
					}				
					
		            status = command.isRunningBatch("FNS_TOT_B005");
		            if (status == true) {
						eventResponse.setUserMessage(new ErrorHandler("TOT00078").getUserMessage());
						return eventResponse;
					}
					
					conditionVO.setBatId("FNS_TOT_B004");
					conditionVO.setBatItmNm("Basic BSA Summary");
					exeJobID = excuteSummaryCreation(conditionVO);
					conditionVO.setJobId(exeJobID);
					command.createSummaryCreationBatch(conditionVO, account);
					
					conditionVO.setBatId("FNS_TOT_B005");
					conditionVO.setBatItmNm("Actual BSA Summary");
					exeJobID = excuteSummaryCreation(conditionVO);
					conditionVO.setJobId(exeJobID);
					command.createSummaryCreationBatch(conditionVO, account);
					
				// Item에서 ALL 이외의 값을 선택한 경우 선택된 Batch를 실행한다.
				} else {
					
		            status = command.isRunningBatch(conditionVO.getBatId());
		            if (status == true) {
						eventResponse.setUserMessage(new ErrorHandler("TOT00078").getUserMessage());
						return eventResponse;
					}				
					
					exeJobID = excuteSummaryCreation(conditionVO);
					conditionVO.setJobId(exeJobID);
					command.createSummaryCreationBatch(conditionVO, account);
				}
				
				eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
				
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
		 * FNS_TOT_0027 : Submit <br>
		 * 해당년월의 입력한 배치정보로 실시간 수행 또는 스케쥴 예약을 수행한다. <br>
		 * 
		 * @param conditionVO FnsTot0027ConditionVO
		 * @return String
		 * @exception EventException
		 */
		private String excuteSummaryCreation (FnsTot0027ConditionVO conditionVO) throws EventException {
			
			String jobID = "";
			
			try{
				String runJob = conditionVO.getRunJob();
				String batId = conditionVO.getBatId();
				String stDt = conditionVO.getStDate();
				String paramDt = conditionVO.getBatchYear();
				ScheduleUtil su = new ScheduleUtil();
				log.debug("################");
				log.debug("runJob=["+runJob+"]");
				log.debug("################");
				if("1".equals(runJob)){
					
					jobID = su.directExecuteJob(batId,paramDt);
				}else if("0".equals(runJob)){
					
					jobID = su.reserveExecuteJob(batId, stDt, paramDt);
				}
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}				
			return jobID;
		}
		
		/**
		 * FNS_TOT_0027 : Cancel <br>
		 * 해당 job_id의 배치스케쥴을 cancel하고 history정보를 삭제한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse cancelSummaryCreationBatch(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			FnsTot0027Event event = (FnsTot0027Event)e;
			TonnageTaxFillingBC command = new TonnageTaxFillingBCImpl();

			try{
				begin();
				FnsTot0027ConditionVO[] conditionVOs = event.getFnsTot0027ConditionVOs();
				String resJobID = "";
				
				for ( int i=0; i < conditionVOs.length; i++ ) {
					if ("1".equals(conditionVOs[i].getUpdChk())) {
						resJobID = conditionVOs[i].getJobId();
						ScheduleUtil su = new ScheduleUtil();
						 
						boolean cancelYn = su.cancelJob(resJobID);
						log.debug(":: cancelYn :::::::::    "+cancelYn);
						command.removeSummaryCreationBatch(resJobID);
					}
				}
				
				eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
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
		 * FNS_TOT_0028 : Retrive <br>
		 * NRT & BSA Change 정보를 조회한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchNrtBsaChg(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0028Event event = (FnsTot0028Event)e;
			TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

			try{
				
				String stlYrmon = event.getStlYrmon();
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
				List<NrtBsaChgVO> list = command.searchNrtBsaChg(stlYrmon);

				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		} 

		/**
		 * FNS_TOT_0028 : Retrive <br>
		 * NRT & BSA Change 화면에서 BSA Before 를 After로 업데이트 한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse modifyNrtBsaChgBsa(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0028Event event = (FnsTot0028Event)e;
			TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

			try{
				
				begin();

				NrtBsaChgVO[] nrtBsaChgVOs = event.getNrtBsaChgVOs();
				
				String userId = account.getUsr_id();
				String stlYrmon = event.getStlYrmon();
				
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
				
				for (int i = 0; i < nrtBsaChgVOs.length; i++) {
					NrtBsaChgVO nrtBsaChgVO = nrtBsaChgVOs[i];
					
					nrtBsaChgVO.setStlYrmon(stlYrmon);
					nrtBsaChgVO.setUpdUsrId(userId);
					
					command.modifyNrtBsaChgBsa(nrtBsaChgVO);
				}								
				
				commit();
				
				
//				String stlYrmon = event.getStlYrmon();
//				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
//			
//				List<NrtBsaChgVO> list = command.searchNrtBsaChg(stlYrmon);

			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * FNS_TOT_0029 : Retrive <br>
		 * Missing Lane Check 정보를 조회한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchMissLaneChk(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0029Event event = (FnsTot0029Event)e;
			TonnageTaxOutputMasterDataMgtBC command = new TonnageTaxOutputMasterDataMgtBCImpl();

			try{
				
				String stlYrmon = event.getStlYrmon();
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
			
				List<MissLaneChkVO> list = command.searchMissLaneChk(stlYrmon);

				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
		
//		/**
//		 * FNS_TOT_0027 : Submit <br>
//		 *  해당기간의 배치스케쥴과 history정보를 저장한다. <br>
//		 * 
//		 * @param Event e 
//		 * @return EventResponse
//		 * @exception EventException
//		 */
//		private EventResponse createSummaryCreationBatch (Event e) throws EventException {
//			// PDTO(Data Transfer Object including Parameters)
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			FnsTot0027Event event = (FnsTot0027Event)e;
//			TonnageTaxFillingBC command = new TonnageTaxFillingBCImpl();
//			FnsTot0027ConditionVO conditionVO = null;
//			
////			String resJobID = "";
////			String resBatID = "";
////			int jobStatus = 10;
//			String exeJobID = "";
//			
//			try{
//				begin();
//				conditionVO = event.getFnsTot0027ConditionVO();
////				List<SearchSummaryCreationBatchVO> list = command.searchSummaryCreationBatch(conditionVO, "status");
//				
//			/* 2011.03.22 이준범 [CHM-201109639-01]
//			 * 현상 : 로그 파일이 오래 것들은 자등으로 삭제되는데 TOT 기능에서 로그 파일 테이블에서 건수가 있으면 배치가 수행될 수 있게  되어 있음
//			 * 처리 : 위 처리 기능을 삭제하면 됨(업무에 문제가 없음) - **설계자 의견**
//			 * < 대상 배치 >
//			 * FNS_TOT_B004   Basic BSA Summary
//			 * FNS_TOT_B005   Actual BSA Summary
//			 */
//				
////				if(list.size() > 0){
////					for(int i=0; i<list.size();i++){
////					    resJobID = list.get(i).getJobId();
////					    resBatID = list.get(i).getBatId();
////					    
////		            	ScheduleUtil su = new ScheduleUtil();
////		                
////		    			jobStatus = su.getJobStatus(resJobID, resBatID);
////		    			
////		    			if(jobStatus == 0){
////		    				eventResponse.setETCData("exp_msg", "0");
////		    				return eventResponse;
////		    			}else if(jobStatus == 1){
////		    				eventResponse.setETCData("exp_msg", "1");
////		    				return eventResponse;
////		    			}
////					}	
////	             }
//				
//				// Item에서 ALL을 선택한 경우 FNS_TOT_B004, FNS_TOT_B005 를 다 실행한다.
//				if ("ALL".equals(conditionVO.getBatId())) {
//					conditionVO.setBatId("FNS_TOT_B004");
//					conditionVO.setBatItmNm("Basic BSA Summary");
//					exeJobID = excuteSummaryCreation(conditionVO);
//					conditionVO.setJobId(exeJobID);
//					command.createSummaryCreationBatch(conditionVO, account);
//					
//					conditionVO.setBatId("FNS_TOT_B005");
//					conditionVO.setBatItmNm("Actual BSA Summary");
//					exeJobID = excuteSummaryCreation(conditionVO);
//					conditionVO.setJobId(exeJobID);
//					command.createSummaryCreationBatch(conditionVO, account);
//					
//				// Item에서 ALL 이외의 값을 선택한 경우 선택된 Batch를 실행한다.
//				} else {
//					exeJobID = excuteSummaryCreation(conditionVO);
//					conditionVO.setJobId(exeJobID);
//					command.createSummaryCreationBatch(conditionVO, account);
//				}
//				
//				eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
//				
//				commit();
//			}catch(EventException ex){
//				rollback();
//				throw ex;
//			}catch(Exception ex){
//				rollback();
//				throw new EventException(ex.getMessage(), ex);
//			}
//			
//			return eventResponse;
//		}
		
		
		/**
		 * FNS_TOT_0029 : Missing Lane Check <br>
		 * Missing Lane Check 하여 상이한 Vessel 에 대하여 NonFeederCalculation 한다 <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse manageNonFeederCalculation (Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			FnsTot0029Event event = (FnsTot0029Event)e;
			
			TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();
			
			try{
				begin();
				
				String stlYrmon = event.getStlYrmon();
				String creUsrId = account.getUsr_id();
				String vslCdChk = ""; 
				
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
				
				MissLaneChkVO[] missLaneChkVOs = event.getMissLaneChkVOs();

				for (int i = 0; i < missLaneChkVOs.length; i++) {
					
					MissLaneChkVO missLaneChkVO = missLaneChkVOs[i];
					
					String vslCd = missLaneChkVO.getVslCd();

					// 화면는 Trd_cd 단위로 Vsl_cd 두개 이므로, 한개만 처리					
					if (vslCd.equals(vslCdChk)){
						continue;
					} else {
						vslCdChk = vslCd;
					}

					command.createNonFeederPortCalculation(stlYrmon, vslCd, creUsrId);
					command.createNonFeederVvdCalculation(stlYrmon, vslCd, creUsrId);
					
				}
				
				eventResponse.setUserMessage(new ErrorHandler("TOT10003").getUserMessage());
				commit();
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
		

		/**
		 * FNS_TOT_0017 : Retrive <br>
		 * SHEET에 해당년월의 DETAIL_DOWN 데이터를 조회한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchFeederTaxableAmountListByDetailDown(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0017Event event = (FnsTot0017Event)e;
			TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

			try{
				
				String stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);

				log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
				event.getVvdStlAmtVO().setStlYrmon(stlYrmon);

				List<VvdStlAmtVO> list = command.searchFeederTaxableAmountListByDetailDown(event.getVvdStlAmtVO());

				eventResponse.setRsVoList(list);

			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
			return eventResponse;
		}
		

	
		/**
		 * FNS_TOT_0030 : SEARCH <br>
		 * SHEET 에 해당 년월, TRADE의 데이터를 조회한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchInquiryVslOwnerCharterList(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0030Event event = (FnsTot0030Event)e;
			TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

			try{
				
				String stlYrmon = event.getVvdStlAmtVO().getStlYrmon();
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
				
				log.debug("::CALL::> stlYrmon :::::::::    "+stlYrmon);
				event.getVvdStlAmtVO().setStlYrmon(stlYrmon);

				List<VvdStlAmtVO> list = command.searchInquiryVslOwnerCharterList(event.getVvdStlAmtVO());
				
				eventResponse.setRsVoList(list);
				
				int total_cnt = list.size();
				double total_txAmt = 0;
				
				for(int i= 0; i<total_cnt; i++){
					total_txAmt = total_txAmt + Double.parseDouble(list.get(i).getTongTaxAmt());
				}
			
				log.debug("::CALL::> total_txAmt :::::::::    "+total_txAmt);
				eventResponse.setETCData("total_txAmt", total_txAmt+"");

			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
			return eventResponse;
		}
		

		/**
		 * FNS_TOT_0031 : OPEN <br>
		 * FNS_TOT_0030 DETAIL 버튼 클릭시 SHEET 에 상세데이터를 조회한다. <br>
		 * 
		 * @param Event e 
		 * @return EventResponse
		 * @exception EventException
		 */
		
		private EventResponse searchInquiryVslOwnerCharterDetailList(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			FnsTot0031Event event = (FnsTot0031Event)e;
			TonnageTaxStandardProfitConclusionBC command = new TonnageTaxStandardProfitConclusionBCImpl();

			try{
				
				String stlYrmon = event.getPortStlAmtVO().getStlYrmon();
				stlYrmon = stlYrmon.substring(0, 4)+ stlYrmon.substring(5, 7);
				
				log.debug("::CALL::> stlYrmon ::::::::: DDDD   "+stlYrmon);
				event.getPortStlAmtVO().setStlYrmon(stlYrmon);

				List<PortStlAmtVO> list = command.searchInquiryVslOwnerCharterDetailList(event.getPortStlAmtVO());

				eventResponse.setRsVoList(list);


			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
			return eventResponse;
		}
}
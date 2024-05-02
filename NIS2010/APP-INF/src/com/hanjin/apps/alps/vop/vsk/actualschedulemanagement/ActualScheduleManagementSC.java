/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleManagementSC.java
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.27
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.07.06 정진우  1.0 Creation
*
* History
* 2010.09.17 CHM-201006029-01 이준범 Actual SKD Creation내 Delete 버튼에 대하여 권한 변경 / 현재 : PUSCOV, CLTCO 인 경우만 활성화 / 변경 : 지역(RHQ) 운항 담당자 권한이 있는 모든 사람에게 권한 부여
* 2010.11.02 CHM-201006736-01 유혁 터미널에서 전송되는 Actual SKD 수신시 ERP 전송 누락되는 문제 수정
* 2010.12.22 CHM-201007901-01 진마리아 SPP에서 전송된 Actual Port SKD에 대한 처리 로직 수정
* 2011.04.11 CHM-201109577-01 진마리아 Delete Vessel Code에 대한 조회 로직 보완
* 2011.08.09 CHM-201112647-01 김민아 Actual SKD input Ratio Tab 및 조회 로직 변경 요청. 페이징 처리에 따른 maxRows 셋팅
* 2011.10.04 CHM-201112983-01 김민아 Actual SKD Creation 및 Inquiry 화면 및 로직 변경. 조회 조건 Port및 Terminal, Calling Seq, 입력칼럼을 Select Box로 변경 / ATA,ATB,ATD 별 Remark 칼럼 추가 / Delay Time을 Hrs로 로직 변경
* 2012.06.15 CHM-201218003-01 이혜민 VSK와 SCE간에 data Interface 프로그램 수정.  VSK에서 EDI 수신 시 SCE연계 테이블에도 EDI  수신 구분 될 수 있도록 해당 정보 Interface
* 2012.08.14 CHM-201219281-01 진마리아 타선사 SKD에 대해 PAPAC, EGSUZ 입력필수항목 제외처리
* 2013.01.25 황태진    CHM-201322271-01 정시율 조회 조건 변경 및 멀티 저장 처리  
* 2013.02.28 CHM-201323017    정상기  IFTSAI  EDI setup 변경 (MYPKGTM)
* 2013.09.10 정상기 [CHM-201325067]   [VOP-VSK] 스케줄 변경 시 개인별 설정 시간에 따라 개별 메일 통지 기능
* 2015.07.08 이병훈 [CHM-201536635] Split11-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBC;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.UdevhjsAlpsvskTActskdEvent;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0025Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0026Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0027Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0001Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0002Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0003Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration.ActualScheduleMgtDBDAO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.EdiLogDataGRPVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ServiceLaneVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic.OnTimeResultAnalysisBC;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic.OnTimeResultAnalysisBCImpl;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0028Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0029Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0030Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0031Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0032Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0034Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0231Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0232Event;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwPortListVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwTrdInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultDelayStatusVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.CoastalScheduleMgtBC;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstGRPVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBC;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBCImpl;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskActPortSkdEdiLogVO;
import com.hanjin.syscommon.common.table.VskActPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;


/**
 * NIS2010-ActualScheduleManagement Business Logic ServiceCommand - NIS2010-ActualScheduleManagement 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jung Jinwoo
 * @see ActualScheduleMgtDBDAO
 * @since J2EE 1.6
 */

public class ActualScheduleManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ActualScheduleManagement system 업무 시나리오 선행작업<br>
	 * vop_vsk_0027업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("ActualScheduleManagementSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ActualScheduleManagement system 업무 시나리오 마감작업<br>
	 * vop_vsk_0027 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("ActualScheduleManagementSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-ActualScheduleManagement system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("VopVsk0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActPortSkd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCallIndicator(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageActPortSkd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeVskActPortSkd(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopVsk0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActPortSkd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCallIndicator(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPort(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("VopVsk0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRhqList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchControlOfficeList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkPort(e);
			}
//			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
//				eventResponse = checkPort(e);
//			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchActPortSkdTgtLaneList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchActPortSkdInputSum(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchActPortSkdInputDtl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {
				eventResponse = searchActPortSkdUnCmplDtl(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {
				eventResponse = searchActPortSkdEdiMntr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = manageRetryEDIMsg(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0232Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRsltRmkDtlList(e);
			} else{
				
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0231Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRsltConvVslSkd(e);
			} else{
				
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRsltDlayStsList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchLaneGrpByUsrId(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = searchRsltSkipStsList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchRsltCngStsList(e);
			}else{
				eventResponse = searchDelayReason(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("UdevhjsAlpsvskTActskdEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) 
			{
				eventResponse = receiveEDIToTerminal(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // btn_Retrieve
				eventResponse = searchRsltOnTimeRtoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01) ||
					e.getFormCommand().isCommand(FormCommand.SEARCH02) ||
					e.getFormCommand().isCommand(FormCommand.SEARCH03) ||
					e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = searchValidation(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchSppVvdListByPort(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchActPortSkd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) 
			{
				eventResponse = manageActPortSkd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchRsltByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeRsltByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)){
				eventResponse = manageRsltByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyRsltByVvd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchDrwSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchDrwPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)){
				eventResponse = manageDrwRptByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeDrwRptByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyDrwRptByVvd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchDrwPorInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)){
				eventResponse = manageDrwPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeDrwPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchDrwTrdInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)){
				eventResponse = manageDrwTrdInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeDrwTrdInfo(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * Call Indicator를 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCallIndicator(Event e) throws EventException {
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
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Port Change<br>
	 * Port Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MdmLocationVO mdmLocationVO = null; 
		
		if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}else if(e instanceof VopVsk0031Event){
			VopVsk0031Event event = (VopVsk0031Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		String chkPort = command.checkPort(mdmLocationVO.getLocCd());
		
		eventResponse.setETCData("check_port", chkPort);
		return eventResponse;
	}
		
	/**
	 * VOP_VSK_0025, VOP_VSK_0026, VOP_VSK_0027 : Vessel Code Change<br>
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
		
		if(e instanceof VopVsk0025Event){
			VopVsk0025Event event = (VopVsk0025Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0026Event){
			VopVsk0026Event event = (VopVsk0026Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
			paramVO = event.getVvdVO();
		}
		
		int chkCnt = 0;
		
		if (paramVO != null) {
			if (paramVO.getVslCd() != null) {
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
			
			// MSG - Vessel Code가 존재하지 않습니다. MDM 시스템에서 Vessel Code를 등록해 주세요.
			throw new EventException(new ErrorHandler("VSK10028").getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0002 : Retrieve<br>
	 * 선박이 기항한 Port에 작업한 실제 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActPortSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
			ActSkdMgtVO paramVO = null;
			ActSkdMgtVO actSkdMgtVO = null;
			
			if(e instanceof VopVsk0025Event){
				VopVsk0025Event event = (VopVsk0025Event)e;
				paramVO = event.getActSkdMgtVO();
			}else if(e instanceof VopVsk0026Event){
				VopVsk0026Event event = (VopVsk0026Event)e;
				paramVO = event.getActSkdMgtVO();
			}else if(e instanceof VopVskSPPVSK0002Event){
				VopVskSPPVSK0002Event event = (VopVskSPPVSK0002Event)e;
				paramVO = event.getActSkdMgtVO();
			}
			
			actSkdMgtVO = command.searchActPortSkd(paramVO);
			
			if(actSkdMgtVO != null){
				/*
				 * Table의 Column명을 대문자로 치환(VO 의 Field Name 을 치환)하여 eventResponse 의 ETCData명으로 화면에 전달.
				 * 예) actSkdMgtVO.vslCD => eventResponse.setETCData("VSL_CD", actSkdMgtVO.getVslCd())
				 */
				Field[] fields = actSkdMgtVO.getClass().getDeclaredFields();
				HashMap<String, String> hashMapValues = actSkdMgtVO.getColumnValues();
//				HashMap<String, String> hashMapFieldNames = actSkdMgtVO.getFieldNames();
				for(Field field : fields){
					String keyName = VSKGeneralUtil.convertFiledName(field.getName());
					eventResponse.setETCData(keyName.toUpperCase(), hashMapValues.get(keyName));
//					log.debug(">>>>>>>>>>>>>>>>fieldName:"+keyName.toUpperCase()+"/Value:"+hashMapValues.get(keyName));
				}
				
				eventResponse.setETCData("dlay_rsn_cd", VSKGeneralUtil.comnCodeList("CD01830", "onlycode"));
				eventResponse.setETCData("dlay_rsn_nm", VSKGeneralUtil.comnCodeList("CD01830", "onlyname"));
				
				eventResponse.setETCData("vsl_cond_cd", VSKGeneralUtil.comnCodeList("CD00137", "onlycode"));
				eventResponse.setETCData("vsl_cond_nm", VSKGeneralUtil.comnCodeList("CD00137", "onlyname"));
				
				List<ActSkdMgtVO> list = new ArrayList<ActSkdMgtVO>();
				list.add(actSkdMgtVO);
				eventResponse.setRsVoList(list);
			}else{
				// ERROR MESSAGE
				eventResponse.setUserMessage(new ErrorHandler("VSK09005").getMessage());
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0025 : Save<br>
	 * Actual Schedule Report Creation (Vessel Movement). 생성된 Actual 스케줄 정보를 생성 및 변경
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageActPortSkd(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		
		ActualScheduleMgtBC 	command 			= new ActualScheduleMgtBCImpl();
		CoastalScheduleMgtBC 	cstScheduleMgtBC 	= new VesselScheduleMgtBCImpl();
		
		ActSkdMgtVO 			actSkdMgtVO 		= null;
		
		SwapCstGRPVO 			swapCstGRPVO 		= new SwapCstGRPVO();
		VskVslPortSkdVO 		vskVslPortSkdVO 	= new VskVslPortSkdVO();
//		List<VskVslPortSkdVO> portList = new ArrayList<VskVslPortSkdVO>();
		String 					usrId 				= "";
		String 					ediMsgTpCd 			= "";
		
		String					sFromEventSystem	= "";
		String					sCvntFromEventSystem= "";
		
		//VskVslDrwSkdVO			vskVslDrwSkdVO		= null;
		
		/* ============================================================================================
		 * Actual Schedule 처리 Process
		 * 1. Input Method	:	VOP_VSK_0025			--- UI(Actual SKD Creation)
		 * 						E-SERVCE(SPP)			--- UI(SPP WebServices Call)
		 * 						EDI						--- EDI(IFTSAI)
		 * 						VOP_VSK_0027			--- UI(Actual SKD Input Ratio Report)
		 * 2. Actual SKD	:	[ActualScheduleMgtBCImpl][manageActPortSkd]
		 * 						VSK_ACT_PORT_SKD
		 * 						VSK_ACT_PORT_SKD_HIS
		 * 3. Actual SKD	:
		 * 						VSK_VSL_PORT_SKD		--- ATA, ATB, ATD 중 하나라도 들어오면 ACT_INP_FLG = "Y" 로 셋팅
		 * 4. SKD Transfer	:
		 * 						TO BKG
		 * 						[GeneralBookingReceiptBCImpl]
		 * 												--- Actual SKD, Coastal SKD
		 * 													BKG_BOOKING
		 * 													BKG_VVD
		 * 						TO SCE[COP]				--- 
		 * 													SCE_ACT_RCV_IF
		 * 							<ACT_RCV_TP_CD>
		 * 							21 : ATA
		 * 							22 : ATB
		 * 							23 : ATD
		 * 							24 : ETA
		 * 							25 : ETB
		 * 							26 : ETD
		 * 							27 : YARD CHANGE
		 * ============================================================================================
		 */
		
		if(e instanceof VopVsk0025Event){
			VopVsk0025Event 			event 	= (VopVsk0025Event)e;
			actSkdMgtVO 						= event.getActSkdMgtVO();
			if(account == null){
				usrId = actSkdMgtVO.getUpdUsrId();
			}else{
				usrId = account.getUsr_id();
			}
			
			sFromEventSystem	= "VOP_VSK_0025";
			
		}else if(e instanceof VopVskSPPVSK0003Event){
			VopVskSPPVSK0003Event 		event 	= (VopVskSPPVSK0003Event)e;
			actSkdMgtVO 						= event.getActSkdMgtVO();
			if(account == null){
				usrId = actSkdMgtVO.getUpdUsrId();
			}else{
				usrId = account.getUsr_id();
			}
			
			sFromEventSystem	= "VOP_VSK_SPP_VSK_0003";
			
		}else if(e instanceof UdevhjsAlpsvskTActskdEvent){
			UdevhjsAlpsvskTActskdEvent 	event 	= (UdevhjsAlpsvskTActskdEvent)e;
			actSkdMgtVO 						= event.getActSkdMgtVO();
			usrId 								= "IF_EDI_SVC";
			ediMsgTpCd 							= "323";
			
			sFromEventSystem	= "IF_EDI_SVC";
			
		}else if(e instanceof VopVsk0027Event){
			VopVsk0027Event 			event 	= (VopVsk0027Event)e;
			actSkdMgtVO 						= event.getActSkdMgtVO();
			usrId 								= "IF_EDI_SVC";
			ediMsgTpCd 							= "323";
			
			sFromEventSystem	= "IF_EDI_SVC(VOP_VSK_0027)";
		}
		
		try{
			
			begin();
			
			if (actSkdMgtVO != null) {
				actSkdMgtVO.setCreUsrId(usrId);
				actSkdMgtVO.setUpdUsrId(usrId);
			
	//			[PORT]===========================================================================
				VslSkdChgStsGRPVO actualGRPVO = command.manageActPortSkd(actSkdMgtVO);	// Actual Schedule 정보를 생성 및 변경
																						// Actual Schedule History 생성
																						// 다른 모듈 인터페이스를 위한 정보 준비
	
				actSkdMgtVO.setPortSkdStsCd(actualGRPVO.getPortSkdStsCd());

				// CHM-201007901-01
				// SPP에서 입력된 Actual Port SKD 정보에 Lane 정보가 없으므로
				// VSK의 Lane 정보를 사용하도록 변경한다.
				if(VSKGeneralUtil.isNull(actSkdMgtVO.getSlanCd())){
					actSkdMgtVO.setSlanCd(actualGRPVO.getSlanCd());
				}
			
				vskVslPortSkdVO.setVslCd			(actSkdMgtVO.getVslCd			());
				vskVslPortSkdVO.setSkdVoyNo			(actSkdMgtVO.getSkdVoyNo		());
				vskVslPortSkdVO.setSkdDirCd			(actSkdMgtVO.getSkdDirCd		());
				vskVslPortSkdVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd		());
				vskVslPortSkdVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq		());
				vskVslPortSkdVO.setPortSkdStsCd		(actSkdMgtVO.getPortSkdStsCd	());
				vskVslPortSkdVO.setYdCd				(actSkdMgtVO.getYdCd			());
				vskVslPortSkdVO.setVpsEtaDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActArrDt	()));
				vskVslPortSkdVO.setVpsEtbDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActBrthDt()));
				vskVslPortSkdVO.setVpsEtdDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActDepDt	()));
				vskVslPortSkdVO.setTurnPortFlg		(actSkdMgtVO.getTurnPortFlg		());
				vskVslPortSkdVO.setTurnPortIndCd	(actSkdMgtVO.getTurnPortIndCd	());
				vskVslPortSkdVO.setTurnSkdVoyNo		(actSkdMgtVO.getTurnSkdVoyNo	());
				vskVslPortSkdVO.setTurnSkdDirCd		(actSkdMgtVO.getTurnSkdDirCd	());
				vskVslPortSkdVO.setTurnClptIndSeq	(actSkdMgtVO.getTurnClptIndSeq	());
				vskVslPortSkdVO.setSlanCd			(actSkdMgtVO.getSlanCd			());			
			
				if(VSKGeneralUtil.isNotNull(actSkdMgtVO.getActArrDt())
						|| VSKGeneralUtil.isNotNull(actSkdMgtVO.getActBrthDt())
						|| VSKGeneralUtil.isNotNull(actSkdMgtVO.getActDepDt())){
					//ATA, ATB, ATD 가 입력될 경우에 VSK_VSL_PORT_SKD.ACT_INP_FLG = 'Y' 를 업데이트 함
					//ATD가 들어올 경우에 셋팅(임창빈 수석 - 2009.09.08).
					//[변경] ATA, ATB, ATD 중 하나라도 들어오면 Y 로 셋팅(임창빈 수석 - 2009.11.16)
					vskVslPortSkdVO.setActInpFlg("Y"); 
				}
				vskVslPortSkdVO.setUpdUsrId(usrId);
				
				swapCstGRPVO.setVskVslPortSkdVO(vskVslPortSkdVO);
				
				List<SceActRcvIfVO> sceAllList = new ArrayList<SceActRcvIfVO>();
				
				
				VslSkdChgStsGRPVO coastalGRPVO = cstScheduleMgtBC.manageCstSkdByActual(swapCstGRPVO);
				
				//Booking 에 변경된 스케줄 전송.
				sendBkgByVslSkdChg(actualGRPVO, coastalGRPVO);
			
				/*
				 * COP 관련
				 * Cop 전송 목록 중 Actual 관련 List 와 Coastal 관련 List 를 같이 담는다.
				 * 
				 * 2009.11.19 변경요청.
				 * Actual 변경 시 Actual 변경 사항만 Cop 전송.
				 */
				// Actual Data
				List<SceActRcvIfVO> sceActualRcvList = actualGRPVO.getSceActRcvIfVOs();
				if(sceActualRcvList != null && sceActualRcvList.size() > 0){
					for(SceActRcvIfVO sceVO : sceActualRcvList){
						sceVO.setEdiMsgTpCd(ediMsgTpCd);
						sceAllList.add(sceVO);
					}
				}
				// Coastal Data
				List<SceActRcvIfVO> sceCoastalList = coastalGRPVO.getSceActRcvIfVOs();		//Coastal 에서 체크하고 넘어 온 전송할 List
	
				if(sceCoastalList != null && sceCoastalList.size() > 0){
					for(SceActRcvIfVO sceVO : sceCoastalList){
						sceVO.setEdiMsgTpCd(ediMsgTpCd);
						// Yard 변경 건만 Coastal 로직 사용.
						if("27".equals(sceVO.getActRcvTpCd())){
							sceAllList.add(sceVO);
						}else{
	//						Actual 변경 시 Actual 변경 사항만 Cop 전송(2009.11.19).
							boolean isCstFlg = true;
							if(sceActualRcvList != null && sceActualRcvList.size()>0){
								if("24".equals(sceVO.getActRcvTpCd())){
									for(SceActRcvIfVO actVO : sceActualRcvList){
										if("21".equals(actVO.getActRcvTpCd()) 
												&& sceVO.getVslCd().equals(actVO.getVslCd())
												&& sceVO.getSkdVoyNo().equals(actVO.getSkdVoyNo())
												&& sceVO.getSkdDirCd().equals(actVO.getSkdDirCd())
												&& sceVO.getVpsPortCd().equals(actVO.getVpsPortCd()) 
												&& sceVO.getClptIndSeq().equals(actVO.getClptIndSeq())){
											isCstFlg = false;
										}
									}
								}else if("25".equals(sceVO.getActRcvTpCd())){
									for(SceActRcvIfVO actVO : sceActualRcvList){
										if("22".equals(actVO.getActRcvTpCd()) 
												&& sceVO.getVslCd().equals(actVO.getVslCd())
												&& sceVO.getSkdVoyNo().equals(actVO.getSkdVoyNo())
												&& sceVO.getSkdDirCd().equals(actVO.getSkdDirCd())
												&& sceVO.getVpsPortCd().equals(actVO.getVpsPortCd()) 
												&& sceVO.getClptIndSeq().equals(actVO.getClptIndSeq())){
											isCstFlg = false;
										}
									}
								}else if("26".equals(sceVO.getActRcvTpCd())){
									for(SceActRcvIfVO actVO : sceActualRcvList){
										if("23".equals(actVO.getActRcvTpCd()) 
												&& sceVO.getVslCd().equals(actVO.getVslCd())
												&& sceVO.getSkdVoyNo().equals(actVO.getSkdVoyNo())
												&& sceVO.getSkdDirCd().equals(actVO.getSkdDirCd())
												&& sceVO.getVpsPortCd().equals(actVO.getVpsPortCd()) 
												&& sceVO.getClptIndSeq().equals(actVO.getClptIndSeq())){
											isCstFlg = false;
										}
									}
								}
							}
							
							if(isCstFlg){
								sceAllList.add(sceVO);
							}
						}
					}
				}
				
				// Actual List 와 Coastal List 를 같이 담은 List 를 COP 전송.
				sendCopByVslSkdChg(sceAllList);
				
				//ERP 전송
				if(coastalGRPVO.getErpVvdVOs() != null && coastalGRPVO.getErpVvdVOs().size() > 0){
					
					for(VvdVO vo : coastalGRPVO.getErpVvdVOs()){
						vo.setCreUsrId(usrId);
						vo.setUpdUsrId(usrId);
					}
				
					cstScheduleMgtBC.sendVslSkdErpIf(coastalGRPVO.getErpVvdVOs());
				}
	
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
				
				if(			"VOP_VSK_0025"				.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_ACT_AutoUpdate(VOP_VSK_0025)";
				}else if(	"VOP_VSK_SPP_VSK_0003"		.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_ACT_AutoUpdate(VOP_VSK_SPP_VSK_0003)";
				}else if(	"IF_EDI_SVC"				.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_ACT_AutoUpdate(IF_EDI_SVC)";
				}else if(	"IF_EDI_SVC(VOP_VSK_0027)"	.equals(sFromEventSystem)){
					sCvntFromEventSystem	= "UPDATE_ACT_AutoUpdate(IF_EDI_SVC(VOP_VSK_0027))";
				}
				cstScheduleMgtBC.createVesselScheduleChangeHistory(coastalGRPVO.getVskVslSkdVOs(), null, sCvntFromEventSystem);	
			}

		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			rollback();
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse removeVskActPortSkd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ActualScheduleMgtBC actualScheduleMgtBC = new ActualScheduleMgtBCImpl();
		CoastalScheduleMgtBC cstScheduleMgtBC = new VesselScheduleMgtBCImpl();
		
		ActSkdMgtVO actSkdMgtVO = null;
		VskActPortSkdVO vskActPortSkdVO = new VskActPortSkdVO();
		VskVslPortSkdVO vskVslPortSkdVO = new VskVslPortSkdVO();
		List<VskVslPortSkdVO> vskVslPortSkdVOs = new ArrayList<VskVslPortSkdVO>();
		
		VopVsk0025Event event = (VopVsk0025Event)e;
		actSkdMgtVO = event.getActSkdMgtVO();
		
		try{
			begin();
			
			String updUsrId = account.getUsr_id();
			
			vskActPortSkdVO.setVslCd(actSkdMgtVO.getVslCd());
			vskActPortSkdVO.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
			vskActPortSkdVO.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
			vskActPortSkdVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
			vskActPortSkdVO.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
			vskActPortSkdVO.setUpdUsrId(updUsrId);
			
			actualScheduleMgtBC.removeVskActPortSkd(vskActPortSkdVO);
						
			vskVslPortSkdVO.setVslCd(actSkdMgtVO.getVslCd());
			vskVslPortSkdVO.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
			vskVslPortSkdVO.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
			vskVslPortSkdVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
			vskVslPortSkdVO.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
			vskVslPortSkdVO.setUpdUsrId(updUsrId);
			
			vskVslPortSkdVOs.add(vskVslPortSkdVO);
			
			if("Y".equals(actSkdMgtVO.getTurnPortFlg())){
				// Turning Port 일 경우 - Virtual Port 도 Update 를 한다.
				
				vskVslPortSkdVO = new VskVslPortSkdVO();
				vskVslPortSkdVO.setVslCd(actSkdMgtVO.getVslCd());
				vskVslPortSkdVO.setSkdVoyNo(actSkdMgtVO.getTurnSkdVoyNo());
				vskVslPortSkdVO.setSkdDirCd(actSkdMgtVO.getTurnSkdDirCd());
				vskVslPortSkdVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
				vskVslPortSkdVO.setClptIndSeq(actSkdMgtVO.getTurnClptIndSeq());
				vskVslPortSkdVO.setUpdUsrId(updUsrId);
				
				vskVslPortSkdVOs.add(vskVslPortSkdVO);
			}
			
			cstScheduleMgtBC.modifyVskVslPortSkdByActSkdDelelet(vskVslPortSkdVOs);
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			rollback();
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * manageActPortSkd : Call<br>
	 * Schedule 이 변경되면 Booking 에 해당 내용을 전송한다.
	 * @param VslSkdChgStsGRPVO actualGRPVO
	 * @param VslSkdChgStsGRPVO coastalGRPVO
	 * @exception EventException
	 */
	private void sendBkgByVslSkdChg(VslSkdChgStsGRPVO actualGRPVO, VslSkdChgStsGRPVO coastalGRPVO) throws EventException {
		GeneralBookingSplitCombineBC bkgScbCmd = new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC bkgRctCmd = new GeneralBookingReceiptBCImpl();
		BLIssuanceBC bkgbliCmd = new BLIssuanceBCImpl();
		BookingProcessMgtBC bkgPrsCmd = new BookingProcessMgtBCImpl();
		
		log.debug("=================== Booking START ===================");
		List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = coastalGRPVO.getVslSkdCngNoticeVOs();
		if(vslSkdCngNoticeVOs != null && vslSkdCngNoticeVOs.size()>0){
			try{
				bkgScbCmd.sendVslSkdCngNotice(vslSkdCngNoticeVOs);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10045").getMessage());
			}
		}
		
		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs = coastalGRPVO.getVslSkdCngUpdateVOs();
		if(vslSkdCngUpdateVOs != null && vslSkdCngUpdateVOs.size()>0){
			try{
				bkgRctCmd.modifyBkgVvdForVslSkdCng(vslSkdCngUpdateVOs, account);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10047").getMessage());
			}
		}
		
		List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = coastalGRPVO.getBkgVvdBdrLogVOs();
		if(bkgVvdBdrLogVOs != null && bkgVvdBdrLogVOs.size()>0){
			try{
				for(BkgVvdBdrLogVO bkgVvdBdrLogVO : bkgVvdBdrLogVOs){
					//bkgPrsCmd.manageBKGBDRLOG(bkgVvdBdrLogVO, account);
					bkgPrsCmd.manageBKGBDRLOGBackEndJob(bkgVvdBdrLogVO, account);
				}
			}catch(Exception ex){
				// Exception 발생해도 Actual 업무는 그냥 진행되도록 처리(2010.06.07 Booking 에서 요청).
				log.error(ex.getMessage());
			}
		}
		
		List<CanonEmlVO> canonEmlVOs = actualGRPVO.getCanonEmlVOs();
		if(canonEmlVOs != null && canonEmlVOs.size()>0){
			try{
				for(CanonEmlVO canonEmlVO : canonEmlVOs){
					bkgbliCmd.sendCanonEmlBkg(canonEmlVO, account);
				}
			}catch(Exception ex){
				// Exception 발생해도 Actual 업무는 그냥 진행되도록 처리(2010.04.13 Booking 에서 요청).
				log.error(ex.getMessage());
			}
		}
		
		log.debug("=================== Booking END ===================");
	}
	
	/**
	 * manageCstSkdByVvd, manageCstSkdBerthWdo : Call
	 * Schedule 이 변경되면 COP 에 해당 내용을 전송한다.
	 * 
	 * @param List<SceActRcvIfVO> sceActRcvIfVOs
	 * @exception EventException
	 */
	private void sendCopByVslSkdChg(List<SceActRcvIfVO> sceActRcvIfVOs) throws EventException {
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();
		
		log.debug("=================== COP START ===================");
		if(sceActRcvIfVOs != null && sceActRcvIfVOs.size()>0){
			try{
				log.debug(">>> Notice Size : " + sceActRcvIfVOs.size());
				for(SceActRcvIfVO sceActRcvIfVO : sceActRcvIfVOs){
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
	 * VOP_VSK_0027 : Retrieve<br>
	 * 등록된 관린 대상 Lane List를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActPortSkdTgtLaneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
//		VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();
//		ServiceLaneVO paramVO = null;
//		MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
		ActSkdRtoVO paramVO = null;
		List<ServiceLaneVO> list = new ArrayList<ServiceLaneVO>();
		
		if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
//			paramVO = event.getServiceLaneVO();
			paramVO = event.getActSkdRtoVO();
		}

//		mdmVslSvcLaneVO.setVslSvcTpCd(paramVO.getVslSvcTpCd());
//		mdmVslSvcLaneVO.setActSkdTgtFlg("Y");
		List<MdmVslSvcLaneVO> nList = command.searchActualTargetLaneList(paramVO);
		
		if(nList != null){
			int cnt = 0;
			try{
				cnt = Integer.parseInt(Math.round(nList.size()/2.0)+"");
			}catch(NumberFormatException ex){
				throw new EventException(ex.getMessage(), ex);
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
			for(int i=0; i<cnt; i++){
				ServiceLaneVO serviceLaneVO = new ServiceLaneVO();
				
				serviceLaneVO.setSeq1((i+1)+"");
				serviceLaneVO.setVslSlanCd1(nList.get(i).getVslSlanCd());
				serviceLaneVO.setVslSlanNm1(nList.get(i).getVslSlanNm());
				if(nList.size() > i+cnt){
					serviceLaneVO.setSeq2((i+cnt+1)+"");
					serviceLaneVO.setVslSlanCd2(nList.get(i+cnt).getVslSlanCd());
					serviceLaneVO.setVslSlanNm2(nList.get(i+cnt).getVslSlanNm());
				}
				
				list.add(serviceLaneVO);
			}
		}
		
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * 사용자가 입력한 조건에 맞는 Port들에 Actual Report 입력 현황을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActPortSkdInputSum(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
		
		ActSkdRtoVO paramVO = null;
		List<ActSkdSumVO> list = null;
		
		if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
			paramVO = event.getActSkdRtoVO();
		}
		
		list = command.searchActPortSkdInputSum(paramVO);
		
		// 페이징에 관계없이 전체 건수 표현
		if(list!=null && list.size()>0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * 사용자가 입력한 조건에 맞는 Port들의 Actual Report 현황을 상세 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActPortSkdInputDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
		
		ActSkdRtoVO paramVO = null;
		List<ActSkdDtlVO> list = null;
		
		if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
			paramVO = event.getActSkdRtoVO();
		}
		
		list = command.searchActPortSkdInputDtl(paramVO);
		
		// 페이징에 관계없이 전체 건수 표현
		if(list!=null && list.size()>0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * Actual Schedule이 작성되지 않는 Report를 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActPortSkdUnCmplDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
		
		ActSkdRtoVO paramVO = null;
		List<ActSkdDtlVO> list = null;
		
		if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
			paramVO = event.getActSkdRtoVO();
		}
		
		list = command.searchActPortSkdUnCmplDtl(paramVO);
		
		// 페이징에 관계없이 전체 건수 표현
		if(list!=null && list.size()>0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * EDI로 수신된 Actual SKD 접수 정보를 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActPortSkdEdiMntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
		
		ActSkdEdiMntrVO paramVO = null;
		List<ActSkdEdiMntrVO> list = null;
		
		if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
			paramVO = event.getActSkdEdiMntrVO();
		}
		
		list = command.searchActPortSkdEdiMntr(paramVO);
		
		// 페이징에 관계없이 전체 건수 표현
		if(list!=null && list.size()>0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * OnTimeResultAnalysis의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * Target VVD & Remark(s)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsltRmkDtlList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		ResultRemarkVO paramVO = null;
		List<ResultRemarkVO> list = null;
		
		if(e instanceof VopVsk0232Event){
			VopVsk0232Event event = (VopVsk0232Event)e;
			paramVO = event.getResultRemarkVO();
		}
		
		list = command.searchRsltRmkDtlList(paramVO);
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Open<BR>
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
		
//		if(e instanceof VopVsk0027Event){
//			VopVsk0027Event event = (VopVsk0027Event)e;
//		}
		
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
	 * VOP_VSK_0027 : Retrieve<br>
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
		ActSkdRtoVO paramVO = null;
		List<LocationVO> list = null;
		
		if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
			paramVO = event.getActSkdRtoVO();
		
			list = command.searchControlOfficeList(paramVO.getVskdPortRhqCd());
			
			StringBuilder sb = new StringBuilder();
			if(list != null){
				sb.append(list.get(0).getVopPortCtrlOfcCd());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getVopPortCtrlOfcCd());
				}
			}
			eventResponse.setETCData("ctrl_ofc_list", sb.toString());
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retry<br>
	 * 수신된 EDI 메세지(Error)에 대해서 다시 Actual Port Schedule에 반영한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRetryEDIMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
		ActSkdEdiMntrVO[] 	actSkdEdiMntrVOs 	= null;
		VopVsk0027Event 	event 				= null;
		
		if(e instanceof VopVsk0027Event){
			event = (VopVsk0027Event)e;
			actSkdEdiMntrVOs = event.getActSkdEdiMntrVOs();
		}
		
		try{
			if(actSkdEdiMntrVOs != null){
				List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs = new ArrayList<VskActPortSkdEdiLogVO>();
				for(ActSkdEdiMntrVO actSkdEdiMntrVO : actSkdEdiMntrVOs){
					VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO = new VskActPortSkdEdiLogVO();
					
					vskActPortSkdEdiLogVO.setRcvDt			(actSkdEdiMntrVO.getRcvDt			());
					vskActPortSkdEdiLogVO.setRcvSeq			(actSkdEdiMntrVO.getRcvSeq			());
					vskActPortSkdEdiLogVO.setEdiVslNm		(actSkdEdiMntrVO.getEdiVslNm		());
					vskActPortSkdEdiLogVO.setEdiSkdVoyNo	(actSkdEdiMntrVO.getEdiSkdVoyNo		());
					vskActPortSkdEdiLogVO.setEdiSkdDirNm	(actSkdEdiMntrVO.getEdiSkdDirNm		());
					vskActPortSkdEdiLogVO.setVpsPortCd		(actSkdEdiMntrVO.getVpsPortCd		());
					vskActPortSkdEdiLogVO.setClptIndSeq		(actSkdEdiMntrVO.getClptIndSeq		());
					vskActPortSkdEdiLogVO.setYdCd			(actSkdEdiMntrVO.getYdCd			());
					vskActPortSkdEdiLogVO.setEdiActArrDt	(actSkdEdiMntrVO.getEdiActArrDt		());
					vskActPortSkdEdiLogVO.setEdiActBrthDt	(actSkdEdiMntrVO.getEdiActBrthDt	());
					vskActPortSkdEdiLogVO.setEdiActDepDt	(actSkdEdiMntrVO.getEdiActDepDt		());
					vskActPortSkdEdiLogVO.setScsFlg			("N"								  );
//					vskActPortSkdEdiLogVO.setRsltMsg(rsltMsg);
					vskActPortSkdEdiLogVO.setSndrTrdPrnrId	(actSkdEdiMntrVO.getSndrTrdPrnrId	());
					vskActPortSkdEdiLogVO.setRcvrTrdPrnrId	(actSkdEdiMntrVO.getRcvrTrdPrnrId	());
					vskActPortSkdEdiLogVO.setEdiMsgTpId		(actSkdEdiMntrVO.getEdiMsgTpId		());
					vskActPortSkdEdiLogVO.setEdiMsgProcId	(actSkdEdiMntrVO.getEdiMsgProcId	());
					vskActPortSkdEdiLogVO.setLloydNo		(actSkdEdiMntrVO.getLloydNo			());
					vskActPortSkdEdiLogVO.setCallSgnNo		(actSkdEdiMntrVO.getCallSgnNo		());
					vskActPortSkdEdiLogVO.setShpCallNo		(actSkdEdiMntrVO.getShpCallNo		());
					vskActPortSkdEdiLogVO.setUpdUsrId		("IF_EDI_SVC"						  );
					
					vskActPortSkdEdiLogVOs.add(vskActPortSkdEdiLogVO);
				}
				
				EdiLogDataGRPVO 			rtnGRPVO 			= this.auditReceivedEdiData		(vskActPortSkdEdiLogVOs);
				List<VskActPortSkdEdiLogVO> auditVOs 			= rtnGRPVO.getVskActPortSkdEdiLogVOs();
				List<VskVslPortSkdVO> 		vskVslPortSkdVOs 	= rtnGRPVO.getVskVslPortSkdVOs		();
				List<VskActPortSkdVO> 		vskActPortSkdVOs 	= rtnGRPVO.getVskActPortSkdVOs		();
				
				int successCnt 	= rtnGRPVO.getValue1();
				int failCnt 	= rtnGRPVO.getValue2();

//				################ MQ 메세지 전문 저장 ################
				if(auditVOs != null && auditVOs.size() > 0){
					int voCnt = auditVOs.size();
					for(int i=0; i<voCnt; i++){
						VskActPortSkdEdiLogVO paramVO 	= auditVOs.get(i);
						ActSkdMgtVO actSkdMgtVO 		= new ActSkdMgtVO();
						actSkdMgtVO.setSlanCd			(paramVO.getVslSlanCd						());
						actSkdMgtVO.setVslCd			(paramVO.getVslCd							());
						actSkdMgtVO.setSkdVoyNo			(paramVO.getSkdVoyNo						());
						actSkdMgtVO.setSkdDirCd			(paramVO.getSkdDirCd						());
						actSkdMgtVO.setVpsPortCd		(paramVO.getVpsPortCd						());
						actSkdMgtVO.setClptIndSeq		(vskVslPortSkdVOs.get(i).getClptIndSeq		());
						
						actSkdMgtVO.setPortSkdStsCd		(portSkdStsCdControl(paramVO));
						
						actSkdMgtVO.setTurnPortFlg		(vskVslPortSkdVOs.get(i).getTurnPortFlg		());
						actSkdMgtVO.setTurnPortIndCd	(vskVslPortSkdVOs.get(i).getTurnPortIndCd	());
						actSkdMgtVO.setTurnSkdVoyNo		(vskVslPortSkdVOs.get(i).getTurnSkdVoyNo	());
						actSkdMgtVO.setTurnSkdDirCd		(vskVslPortSkdVOs.get(i).getTurnSkdDirCd	());
						actSkdMgtVO.setTurnClptIndSeq	(vskVslPortSkdVOs.get(i).getTurnClptIndSeq	());
						
						actSkdMgtVO.setYdCd				(paramVO.getYdCd							());
						
						actSkdMgtVO.setActArrDt			(paramVO.getActArrDt						()); //ATA
						actSkdMgtVO.setActBrthDt		(paramVO.getActBrthDt						()); //ATB
						actSkdMgtVO.setActDepDt			(paramVO.getActDepDt						()); //ATD
						
						if (vskActPortSkdVOs != null && vskActPortSkdVOs.size() > 0) {
							//[Vessel ACT SKD 정보]
//							actSkdMgtVO.setLstEtaDt(vskActPortSkdVOs.get(i).getLstEtaDt());
							actSkdMgtVO.setVslArrDlayRsnCd(vskActPortSkdVOs.get(i).getVslArrDlayRsnCd());
							
//							actSkdMgtVO.setLstEtbDt(vskActPortSkdVOs.get(i).getLstEtbDt());
							actSkdMgtVO.setVslBrthDlayRsnCd(vskActPortSkdVOs.get(i).getVslBrthDlayRsnCd());
							
//							actSkdMgtVO.setLstEtdDt(vskActPortSkdVOs.get(i).getLstEtdDt());
							actSkdMgtVO.setVslDepDlayRsnCd(vskActPortSkdVOs.get(i).getVslDepDlayRsnCd());
							
							//[Vessel Condition 정보 - Arrival]
							actSkdMgtVO.setArrFoilWgt(vskActPortSkdVOs.get(i).getArrFoilWgt());
							actSkdMgtVO.setArrLowSulpFoilWgt(vskActPortSkdVOs.get(i).getArrLowSulpFoilWgt());
							actSkdMgtVO.setArrDoilWgt(vskActPortSkdVOs.get(i).getArrDoilWgt());
							actSkdMgtVO.setArrLowSulpDoilWgt(vskActPortSkdVOs.get(i).getArrLowSulpDoilWgt());
							actSkdMgtVO.setArrFrshWtrWgt(vskActPortSkdVOs.get(i).getArrFrshWtrWgt());
							actSkdMgtVO.setArrBlstWgt(vskActPortSkdVOs.get(i).getArrBlstWgt());
							actSkdMgtVO.setArrFwddrHgt(vskActPortSkdVOs.get(i).getArrFwddrHgt());
							actSkdMgtVO.setArrAftdrHgt(vskActPortSkdVOs.get(i).getArrAftdrHgt());
							actSkdMgtVO.setArrGmHgt(vskActPortSkdVOs.get(i).getArrGmHgt());
							actSkdMgtVO.setArrTugBotKnt(vskActPortSkdVOs.get(i).getArrTugBotKnt());
							
							//[Vessel Condition 정보 - Supply]
							actSkdMgtVO.setSplFoilWgt(vskActPortSkdVOs.get(i).getSplFoilWgt());
							actSkdMgtVO.setSplLowSulpFoilWgt(vskActPortSkdVOs.get(i).getSplLowSulpFoilWgt());
							actSkdMgtVO.setSplDoilWgt(vskActPortSkdVOs.get(i).getSplDoilWgt());
							actSkdMgtVO.setSplLowSulpDoilWgt(vskActPortSkdVOs.get(i).getSplLowSulpDoilWgt());
							actSkdMgtVO.setSplFrshWtrWgt(vskActPortSkdVOs.get(i).getSplFrshWtrWgt());
							
							//[Vessel Condition 정보 - Departure]
							actSkdMgtVO.setDepFoilWgt(vskActPortSkdVOs.get(i).getDepFoilWgt());
							actSkdMgtVO.setDepLowSulpFoilWgt(vskActPortSkdVOs.get(i).getDepLowSulpFoilWgt());
							actSkdMgtVO.setDepDoilWgt(vskActPortSkdVOs.get(i).getDepDoilWgt());
							actSkdMgtVO.setDepLowSulpDoilWgt(vskActPortSkdVOs.get(i).getDepLowSulpDoilWgt());
							actSkdMgtVO.setDepFrshWtrWgt(vskActPortSkdVOs.get(i).getDepFrshWtrWgt());
							actSkdMgtVO.setDepBlstWgt(vskActPortSkdVOs.get(i).getDepBlstWgt());
							actSkdMgtVO.setDepFwddrHgt(vskActPortSkdVOs.get(i).getDepFwddrHgt());
							actSkdMgtVO.setDepAftdrHgt(vskActPortSkdVOs.get(i).getDepAftdrHgt());
							actSkdMgtVO.setDepGmHgt(vskActPortSkdVOs.get(i).getDepGmHgt());
							actSkdMgtVO.setDepTugBotKnt(vskActPortSkdVOs.get(i).getDepTugBotKnt());
							
							//[Vessel Condition 정보 - 기타]
							actSkdMgtVO.setTtlSlgWgt(vskActPortSkdVOs.get(i).getTtlSlgWgt());
							actSkdMgtVO.setTtlGbgQty(vskActPortSkdVOs.get(i).getTtlGbgQty());
							
							actSkdMgtVO.setPltLstUnldDt(vskActPortSkdVOs.get(i).getPltLstUnldDt());
							actSkdMgtVO.setBfrBrthAnkDrpDt(vskActPortSkdVOs.get(i).getBfrBrthAnkDrpDt());
							actSkdMgtVO.setBfrBrthAnkOffDt(vskActPortSkdVOs.get(i).getBfrBrthAnkOffDt());
							actSkdMgtVO.setAftUnbrthAnkDrpDt(vskActPortSkdVOs.get(i).getAftUnbrthAnkDrpDt());
							actSkdMgtVO.setAftUnbrthAnkOffDt(vskActPortSkdVOs.get(i).getAftUnbrthAnkOffDt());
							
							actSkdMgtVO.setDiffRmk(vskActPortSkdVOs.get(i).getDiffRmk());
							actSkdMgtVO.setActArrRmk(vskActPortSkdVOs.get(i).getActArrRmk());
							actSkdMgtVO.setActBrthRmk(vskActPortSkdVOs.get(i).getActBrthRmk());
							actSkdMgtVO.setActDepRmk(vskActPortSkdVOs.get(i).getActDepRmk());
						}
						
						actSkdMgtVO.setCreUsrId(paramVO.getCreUsrId());	// MQ 전문에선 세션 정보가 없기에 세팅한다.
						actSkdMgtVO.setUpdUsrId(paramVO.getUpdUsrId());	// MQ 전문에선 세션 정보가 없기에 세팅한다.
	
						event.setActSkdMgtVO(actSkdMgtVO);
						
						manageActPortSkdByEDI(event, paramVO);
					} // end for
				}
				
				/*
				 * Process Result : Success ($s) Items, Failure ($s) Items.
				 */
				String[] errMsgs = new String[]{successCnt+"", failCnt+""};
				eventResponse.setUserMessage(new ErrorHandler("VSK10069", errMsgs).getUserMessage());
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * SKD for Conversion<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsltConvVslSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0231Event event = (VopVsk0231Event)e;
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();

		try{
			List<VskVslPortSkdVO> list = command.searchRsltConvVslSkd(event.getOnTimeRsltAnalGRPVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0029 TAB1 : Retrieve<br> 
	 * SKD Status (Delay Status) 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDelayReason(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();

		try{
			String intgCdId = "CD01830";
			String headerVal = command.searchDelayReason(intgCdId);

			//eventResponse.setRsVoList(list);
			eventResponse.setETCData("header", headerVal);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0029 TAB2 : Retrieve<br>  
	 * Skip Status  조회 한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsltDlayStsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0029Event event = (VopVsk0029Event)e;
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();

		try{
			String intgCdId = "CD01830";
			ResultChangeStatusVO resultChangeStatusVO = event.getResultChangeStatusVO();
			resultChangeStatusVO.setIntgCdId(intgCdId);
			resultChangeStatusVO.setGrpFlg(resultChangeStatusVO.getGrpFlgCd());
			String fromDt = resultChangeStatusVO.getActInpFmDt();
			String toDt = resultChangeStatusVO.getActInpToDt();
			fromDt = fromDt.replace("-", "");
			toDt = toDt.replace("-", "");
			resultChangeStatusVO.setActInpFmDt(fromDt);
			resultChangeStatusVO.setActInpToDt(toDt);
			
			
			List<ResultDelayStatusVO> list = command.searchRsltDlayStsList(resultChangeStatusVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0029 TAB3 : Retrieve<br>  
	 * Skip Change Status 조회 한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneGrpByUsrId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0029Event event = (VopVsk0029Event)e;
		VesselScheduleMasterDataBC command = new VesselScheduleMasterDataBCImpl();

		try{
			ResultChangeStatusVO resultChangeStatusVO = event.getResultChangeStatusVO();
			String usr_id = resultChangeStatusVO.getUsrId();
						
			List<UserLaneGroupVO> list = command.searchLaneGrpByUsrId(usr_id);
			StringBuffer sb = new StringBuffer();
			
			if(list != null && list.size() > 0){
				sb.append(list.get(0).getLaneGrpNm());
				for(int i=1; i<list.size(); i++){
					sb.append("|"+list.get(i).getLaneGrpNm());
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
	 * SKD Status (Skip Status) 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsltSkipStsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0029Event event = (VopVsk0029Event)e;
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();

		try{
			String intgCdId = "CD01830";//CD01825
			ResultSkipStatusVO resultSkipStatusVO = event.getResultSkipStatusVO();

			resultSkipStatusVO.setIntgCdId(intgCdId);
			resultSkipStatusVO.setGrpFlg(resultSkipStatusVO.getGrpFlgCd());
			String fromDt = resultSkipStatusVO.getActInpFmDt();
			String toDt = resultSkipStatusVO.getActInpToDt();
			fromDt = fromDt.replace("-", "");
			toDt = toDt.replace("-", "");
			resultSkipStatusVO.setActInpFmDt(fromDt);
			resultSkipStatusVO.setActInpToDt(toDt);
			
			
			List<ResultSkipStatusVO> list = command.searchRsltSkipStsList(resultSkipStatusVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * SKD Status (Skip Change Status) 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsltCngStsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0029Event event = (VopVsk0029Event)e;
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();

		try{
			// 2009 0916 임창빈수석 수정요청
			//String intgCdId = "CD01830";
			String intgCdId = "CD01825";
			
			ResultChangeStatusVO resultChangeStatusVO = event.getResultChangeStatusVO();

			resultChangeStatusVO.setIntgCdId(intgCdId);
			resultChangeStatusVO.setGrpFlg(resultChangeStatusVO.getGrpFlgCd());
			String fromDt = resultChangeStatusVO.getActInpFmDt();
			String toDt = resultChangeStatusVO.getActInpToDt();
			fromDt = fromDt.replace("-", "");
			toDt = toDt.replace("-", "");
			resultChangeStatusVO.setActInpFmDt(fromDt);
			resultChangeStatusVO.setActInpToDt(toDt);
			
			
			List<ResultChangeStatusVO> list = command.searchRsltCngStsList(resultChangeStatusVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * MQ 메세지 전문 저장 및 체크<br>
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIToTerminal(Event e) throws EventException { //KKK
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try { 
			
			/* ###############################################################
			 * ######### METHOD CALL PROCESS #################################
			 * 1. this.createVskActPortSkdEdiLog
			 *    - 
			 * 2. this.auditReceivedEdiData
			 *    - 
			 * 3-1. this.manageActPortSkdByEDI >> this.manageActPortSkd 
			 *    :: BKG에 변경된 SCHEDULE 전송
			 *    :: VSK_ACT_PORT_SKD, VSK_ACT_PRT_SKD_HIS
			 *    :: SCE_ACT_RCV_IF
			 *    :: and so on...
			 * 3-2. this.manageActPortSkdByEDI >> this.modifyVskActPortSkdEdiLog
			 *    - 
			 * ###############################################################
			 */
			
			if (e.getEventName().equalsIgnoreCase("UdevhjsAlpsvskTActskdEvent")){
				UdevhjsAlpsvskTActskdEvent event = (UdevhjsAlpsvskTActskdEvent)e;
				
				log.info("################### ACTUAL EDI START ###################");
				
//				################ MQ 메세지 원본 전문 저장. ################
				String 						flatFile 				= event.getFlatFile					();
				List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs 	= createVskActPortSkdEdiLog			(flatFile);
				
//				################ MQ 메세지  체크 및 Parsing. ################
				EdiLogDataGRPVO 			rtnGRPVO 				= auditReceivedEdiData				(vskActPortSkdEdiLogVOs);
				List<VskActPortSkdEdiLogVO> auditVOs 				= rtnGRPVO.getVskActPortSkdEdiLogVOs();
				List<VskVslPortSkdVO> 		vskVslPortSkdVOs 		= rtnGRPVO.getVskVslPortSkdVOs		();
				List<VskActPortSkdVO> 		vskActPortSkdVOs 		= rtnGRPVO.getVskActPortSkdVOs		();
				
//				################ MQ 메세지 Parsing 된 전문 저장 ################
				if(auditVOs != null && auditVOs.size() > 0){
					int voCnt = auditVOs.size();
					for(int i=0; i<voCnt; i++){
						VskActPortSkdEdiLogVO paramVO 	= auditVOs.get(i);
						ActSkdMgtVO actSkdMgtVO 		= new ActSkdMgtVO();
						
						actSkdMgtVO.setSlanCd			(paramVO.getVslSlanCd						());
						actSkdMgtVO.setVslCd			(paramVO.getVslCd							());
						actSkdMgtVO.setSkdVoyNo			(paramVO.getSkdVoyNo						());
						actSkdMgtVO.setSkdDirCd			(paramVO.getSkdDirCd						());
						actSkdMgtVO.setVpsPortCd		(paramVO.getVpsPortCd						());
						actSkdMgtVO.setClptIndSeq		(paramVO.getClptIndSeq						());
						actSkdMgtVO.setPortSkdStsCd		(portSkdStsCdControl						(paramVO));
																		
						actSkdMgtVO.setTurnPortFlg		(vskVslPortSkdVOs.get(i).getTurnPortFlg		());
						actSkdMgtVO.setTurnPortIndCd	(vskVslPortSkdVOs.get(i).getTurnPortIndCd	());
						actSkdMgtVO.setTurnSkdVoyNo		(vskVslPortSkdVOs.get(i).getTurnSkdVoyNo	());
						actSkdMgtVO.setTurnSkdDirCd		(vskVslPortSkdVOs.get(i).getTurnSkdDirCd	());
						actSkdMgtVO.setTurnClptIndSeq	(vskVslPortSkdVOs.get(i).getTurnClptIndSeq	());						
						actSkdMgtVO.setYdCd				(paramVO.getYdCd							());
						
						actSkdMgtVO.setActArrDt			(paramVO.getActArrDt						()); //ATA
						actSkdMgtVO.setActBrthDt		(paramVO.getActBrthDt						()); //ATB
						actSkdMgtVO.setActDepDt			(paramVO.getActDepDt						()); //ATD
						
						if (vskActPortSkdVOs != null && vskActPortSkdVOs.size() > 0) {
							//[Vessel ACT SKD 정보]
//							actSkdMgtVO.setLstEtaDt(vskActPortSkdVOs.get(i).getLstEtaDt());
							actSkdMgtVO.setVslArrDlayRsnCd	(vskActPortSkdVOs.get(i).getVslArrDlayRsnCd	());
							
//							actSkdMgtVO.setLstEtbDt(vskActPortSkdVOs.get(i).getLstEtbDt());
							actSkdMgtVO.setVslBrthDlayRsnCd	(vskActPortSkdVOs.get(i).getVslBrthDlayRsnCd());
							
//							actSkdMgtVO.setLstEtdDt(vskActPortSkdVOs.get(i).getLstEtdDt());
							actSkdMgtVO.setVslDepDlayRsnCd	(vskActPortSkdVOs.get(i).getVslDepDlayRsnCd	());
							
							//[Vessel Condition 정보 - Arrival]
							actSkdMgtVO.setArrFoilWgt		(vskActPortSkdVOs.get(i).getArrFoilWgt			());
							actSkdMgtVO.setArrLowSulpFoilWgt(vskActPortSkdVOs.get(i).getArrLowSulpFoilWgt	());
							actSkdMgtVO.setArrDoilWgt		(vskActPortSkdVOs.get(i).getArrDoilWgt			());
							actSkdMgtVO.setArrLowSulpDoilWgt(vskActPortSkdVOs.get(i).getArrLowSulpDoilWgt	());
							actSkdMgtVO.setArrFrshWtrWgt	(vskActPortSkdVOs.get(i).getArrFrshWtrWgt		());
							actSkdMgtVO.setArrBlstWgt		(vskActPortSkdVOs.get(i).getArrBlstWgt			());
							actSkdMgtVO.setArrFwddrHgt		(vskActPortSkdVOs.get(i).getArrFwddrHgt			());
							actSkdMgtVO.setArrAftdrHgt		(vskActPortSkdVOs.get(i).getArrAftdrHgt			());
							actSkdMgtVO.setArrGmHgt			(vskActPortSkdVOs.get(i).getArrGmHgt			());
							actSkdMgtVO.setArrTugBotKnt		(vskActPortSkdVOs.get(i).getArrTugBotKnt		());
							
							//[Vessel Condition 정보 - Supply]
							actSkdMgtVO.setSplFoilWgt		(vskActPortSkdVOs.get(i).getSplFoilWgt			());
							actSkdMgtVO.setSplLowSulpFoilWgt(vskActPortSkdVOs.get(i).getSplLowSulpFoilWgt	());
							actSkdMgtVO.setSplDoilWgt		(vskActPortSkdVOs.get(i).getSplDoilWgt			());
							actSkdMgtVO.setSplLowSulpDoilWgt(vskActPortSkdVOs.get(i).getSplLowSulpDoilWgt	());
							actSkdMgtVO.setSplFrshWtrWgt	(vskActPortSkdVOs.get(i).getSplFrshWtrWgt		());
							
							//[Vessel Condition 정보 - Departure]
							actSkdMgtVO.setDepFoilWgt		(vskActPortSkdVOs.get(i).getDepFoilWgt			());
							actSkdMgtVO.setDepLowSulpFoilWgt(vskActPortSkdVOs.get(i).getDepLowSulpFoilWgt	());
							actSkdMgtVO.setDepDoilWgt		(vskActPortSkdVOs.get(i).getDepDoilWgt			());
							actSkdMgtVO.setDepLowSulpDoilWgt(vskActPortSkdVOs.get(i).getDepLowSulpDoilWgt	());
							actSkdMgtVO.setDepFrshWtrWgt	(vskActPortSkdVOs.get(i).getDepFrshWtrWgt		());
							actSkdMgtVO.setDepBlstWgt		(vskActPortSkdVOs.get(i).getDepBlstWgt			());
							actSkdMgtVO.setDepFwddrHgt		(vskActPortSkdVOs.get(i).getDepFwddrHgt			());
							actSkdMgtVO.setDepAftdrHgt		(vskActPortSkdVOs.get(i).getDepAftdrHgt			());
							actSkdMgtVO.setDepGmHgt			(vskActPortSkdVOs.get(i).getDepGmHgt			());
							actSkdMgtVO.setDepTugBotKnt		(vskActPortSkdVOs.get(i).getDepTugBotKnt		());
							
							//[Vessel Condition 정보 - 기타]
							actSkdMgtVO.setTtlSlgWgt		(vskActPortSkdVOs.get(i).getTtlSlgWgt			());
							actSkdMgtVO.setTtlGbgQty		(vskActPortSkdVOs.get(i).getTtlGbgQty			());
							
							actSkdMgtVO.setPltLstUnldDt		(vskActPortSkdVOs.get(i).getPltLstUnldDt		());
							actSkdMgtVO.setBfrBrthAnkDrpDt	(vskActPortSkdVOs.get(i).getBfrBrthAnkDrpDt		());
							actSkdMgtVO.setBfrBrthAnkOffDt	(vskActPortSkdVOs.get(i).getBfrBrthAnkOffDt		());
							actSkdMgtVO.setAftUnbrthAnkDrpDt(vskActPortSkdVOs.get(i).getAftUnbrthAnkDrpDt	());
							actSkdMgtVO.setAftUnbrthAnkOffDt(vskActPortSkdVOs.get(i).getAftUnbrthAnkOffDt	());
							
							actSkdMgtVO.setDiffRmk			(vskActPortSkdVOs.get(i).getDiffRmk				());
							actSkdMgtVO.setActArrRmk		(vskActPortSkdVOs.get(i).getActArrRmk			());
							actSkdMgtVO.setActBrthRmk		(vskActPortSkdVOs.get(i).getActBrthRmk			());
							actSkdMgtVO.setActDepRmk		(vskActPortSkdVOs.get(i).getActDepRmk			());
						}
						actSkdMgtVO.setCreUsrId(paramVO.getCreUsrId());	// MQ 전문에선 세션 정보가 없기에 세팅한다.
						actSkdMgtVO.setUpdUsrId(paramVO.getUpdUsrId());	// MQ 전문에선 세션 정보가 없기에 세팅한다.
	
						event.setActSkdMgtVO(actSkdMgtVO);
						
						manageActPortSkdByEDI(event, paramVO);
						
					} // end for
				}
				
				log.info("###################  ACTUAL EDI END  ###################");
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EDI Data 를 Actual 에 반영.
	 * 
	 * @param Event event
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	private void manageActPortSkdByEDI(Event event, VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws EventException{
		try{
			manageActPortSkd(event);	// Actual 에 반영
			modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
		}catch(EventException ex){
			String rsltUserMsg = new ErrorHandler(ex).getUserMessage();
			manageActPortSkdByEDIErrMsg(vskActPortSkdEdiLogVO, rsltUserMsg);
			throw ex;
		}
	}
	
	/**
	 * EDI Data 를 Actual 에 반영 중 Exception 처리
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @param String rsltMsg
	 * @exception EventException
	 */
	private void manageActPortSkdByEDIErrMsg(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO, String rsltUserMsg) throws EventException{
		try {
			begin();
			ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
			vskActPortSkdEdiLogVO.setRsltMsg(rsltUserMsg);
			command.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO, null);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * MQ 메세지 원본 전문 저장.
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.
	 * 
	 * @param String flatFile
	 * @return List<VskActPortSkdEdiLogVO>
	 * @exception EventException
	 */
	private List<VskActPortSkdEdiLogVO> createVskActPortSkdEdiLog(String flatFile) throws EventException{
		List<VskActPortSkdEdiLogVO> rtnVOList = null;
		try {
			begin();
			log.info("################### ACTUAL EDI createVskActPortSkdEdiLog START ###################");
			ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
			rtnVOList = command.createVskActPortSkdEdiLog(flatFile);
			log.info("###################  ACTUAL EDI createVskActPortSkdEdiLog END  ###################");
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnVOList;
	}
	
	/**
	 * MQ 메세지 전문 저장 및 체크.
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.
	 * 
	 * @param List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs
	 * @return EdiLogDataGRPVO
	 * @exception EventException
	 */
	private EdiLogDataGRPVO auditReceivedEdiData(List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs) throws EventException{
		EdiLogDataGRPVO rtnGRPVO = null;
		try {
			begin();
			log.info("################### ACTUAL EDI auditReceivedEdiData START ###################");
			ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
			if(vskActPortSkdEdiLogVOs != null){
				log.info("################### auditReceivedEdiData PROCESS CALL ###################");
				rtnGRPVO = command.auditReceivedEdiData(vskActPortSkdEdiLogVOs, null);
			}
			log.info("###################  ACTUAL EDI auditReceivedEdiData END  ###################");
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnGRPVO;
	}
	
	/**
	 * MQ 메세지 전문 저장
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	private void modifyVskActPortSkdEdiLog(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws EventException{
		
		try {
			begin();
			
			ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
			vskActPortSkdEdiLogVO.setScsFlg("Y");
			/* VSK10058 :: [Success] OK Process. */
			vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10058").getUserMessage());
			command.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO, null);
			
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * EDI Data 의 Port SKD Status 를 설정.
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @return String
	 */
	private String portSkdStsCdControl(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO){
		String portSkdStsCd = "";
		if(vskActPortSkdEdiLogVO != null){
			if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActDepDt())){
				portSkdStsCd = "D";
			}else if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActBrthDt())){
				portSkdStsCd = "B";
			}else if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActArrDt())){
				portSkdStsCd = "A";
			}
		}
		
		return portSkdStsCd;
	}
	
	/**
	 * VOP_VSK_0032 : Retrieve
	 * Lane/Port/Vessel 별 스케쥴의 지연 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsltOnTimeRtoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0032Event event = (VopVsk0032Event)e;
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();

		try{
			List<ResultOnTimeRatioVO> list = command.searchRsltOnTimeRtoList(event.getResultOnTimeRatioVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0032 : Lane Code, Vessel Code, Port Code, Carrier Code
	 * 각 코드에 대해 공통 모듈을 이용하여 validation 체크합니다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchValidation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0032Event event = (VopVsk0032Event)e;
		ResultOnTimeRatioVO resultOnTimeRatioVO = event.getResultOnTimeRatioVO();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		
		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Lane Code 조회
			
			MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(resultOnTimeRatioVO.getVslSlanCd());
			List<MdmVslSvcLaneVO> list = command.checkSvcLane(vo);
			if(list.size()>0){
				eventResponse.setETCData("vsl_slan_cd",  list.get(0).getVslSlanCd());
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Vessel Code 조회
			
			VesselVO vo = new VesselVO();
			vo.setVslCd(resultOnTimeRatioVO.getVslCd());
			vo.setIncDelVsl(resultOnTimeRatioVO.getIncDelVsl());
			List<VesselVO> list = command.searchVslList(vo);
			if(list.size()>0){
				eventResponse.setETCData("vsl_cd", list.get(0).getVslCd());
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Port Code 조회
			
			String flag = command.checkPort(resultOnTimeRatioVO.getVpsPortCd());
			if(flag!=null && flag.length()>0){
				eventResponse.setETCData("vps_port_cd", flag);
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Carrier Code 조회
			
			CarrierVO vo = new CarrierVO();
			vo.setCrrCd(resultOnTimeRatioVO.getCrrCd());
			List<CarrierVO> list = command.checkCarrier(vo);
			if(list.size()>0){
				eventResponse.setETCData("crr_cd", list.get(0).getCrrCd());
			}
			
		}
		return eventResponse;
	}
	
	/**
	 * 외부 인터페이스 처리<br>
	 * WEBSERVICE 처리<br>
	 * Actual Skd를 입력 대상 Port를 Calling하는 VVD 리스트 조회 (SPP).
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSppVvdListByPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVskSPPVSK0001Event event = (VopVskSPPVSK0001Event)e;
		VvdListByPortVO vvdListByPortVO = event.getVvdListByPortVO();
		ActualScheduleMgtBC command = null;
		
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // SPP_VSK-0001
			command = new ActualScheduleMgtBCImpl();
			
			String vps_port_cd = vvdListByPortVO.getVpsPortCd();
			String vsl_svc_tp_cd = vvdListByPortVO.getVslSvcTpCd();
			
			List<VvdListByPortVO> list = command.searchSppVvdListByPort(vps_port_cd,vsl_svc_tp_cd );
			if(list.size()>0){
				eventResponse.setRsVoList(list);
			}
			
		}/* 
		else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Vessel Code 조회
			
			VesselVO vo = new VesselVO();
			vo.setVslCd(resultOnTimeRatioVO.getVslCd());
			List<VesselVO> list = command.searchVslList(vo);
			if(list.size()>0){
				eventResponse.setETCData("vsl_cd", list.get(0).getVslCd());
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Port Code 조회
			
			String flag = command.checkPort(resultOnTimeRatioVO.getVpsPortCd());
			if(flag!=null && flag.length()>0){
				eventResponse.setETCData("vps_port_cd", flag);
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Carrier Code 조회
			
			VskCarrierVO vo = new VskCarrierVO();
			vo.setCrrCd(resultOnTimeRatioVO.getCrrCd());
			List<VskCarrierVO> list = command.checkCarrier(vo);
			if(list.size()>0){
				eventResponse.setETCData("crr_cd", list.get(0).getCrrCd());
			}
			
		}
		*/
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0028 : Retrieve<br>
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRsltByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0028Event event = (VopVsk0028Event)e;
		OnTimeRsltAnalGRPVO onTimeRsltAnalVO = event.getOnTimeRsltAnalGRPVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			OnTimeRsltAnalGRPVO resultVO = command.searchRsltByVvd(onTimeRsltAnalVO);
			eventResponse.setRsVoList(resultVO.getSkdResultVOs());

			eventResponse.setETCData("vsl_slan_cd", resultVO.getVslSlanCd());
			eventResponse.setETCData("exist", resultVO.getExist());
			eventResponse.setETCData("dlay_rsn_cd", VSKGeneralUtil.comnCodeList("CD01830", "onlycode"));
			eventResponse.setETCData("dlay_rsn_nm", VSKGeneralUtil.comnCodeList("CD01830", "codeNname"));
			eventResponse.setETCData("act_crr_cd", resultVO.getActCrrCd());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0028 : Delete
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 삭제합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeRsltByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0028Event event = (VopVsk0028Event)e;
		OnTimeRsltAnalGRPVO onTimeRsltAnalVO = event.getOnTimeRsltAnalGRPVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			begin();
			command.removeRsltByVvd(onTimeRsltAnalVO);
			eventResponse.setETCData("vsl_slan_cd", "");
			eventResponse.setETCData("exist", "");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0028 : Save
	 * VVD에 대해서 VSK VESSEL SCHEDULE RESULT 정보를 저장합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRsltByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0028Event event = (VopVsk0028Event)e;
		OnTimeRsltAnalGRPVO onTimeRsltAnalVO = event.getOnTimeRsltAnalGRPVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			begin();
			command.manageRsltByVvd(onTimeRsltAnalVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0028 : Update
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRsltByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0028Event event = (VopVsk0028Event)e;
		OnTimeRsltAnalGRPVO onTimeRsltAnalVO = event.getOnTimeRsltAnalGRPVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();

		try{
			begin();
			command.modifyRsltByVvd(onTimeRsltAnalVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0025, VOP_VSK_0026<br>
	 * VVD 가 지나는 Port 를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		List<VskComboVO> list = null;
		VvdVO paramVO = null;
		
		if(e instanceof VopVsk0025Event){
			VopVsk0025Event event = (VopVsk0025Event)e;
			paramVO = event.getVvdVO();
		}else if(e instanceof VopVsk0026Event){
			VopVsk0026Event event = (VopVsk0026Event)e;
			paramVO = event.getVvdVO();
			//Inquiry 화면은 생성된 Port만 조회되도록 구분자 셋팅
			paramVO.setStatusflag("I");
		}
		
		
		list = command.searchPort(paramVO);
		StringBuilder sb = new StringBuilder();
		if(list != null){
			for(int i=0;i<list.size();i++){
				if(i == 0 ){
					sb.append(((VskComboVO)list.get(i)).getName());
				}else{
					sb.append("|" + ((VskComboVO)list.get(i)).getName());
				}
			}
		} 
		eventResponse.setETCData("port_list", sb.toString());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	 
	
	/**
	 * VOP_VSK_0030 : Retrieve<br>
	 * Drewry SKD 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDrwSkd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0030Event event = (VopVsk0030Event)e;
		DrwSkdSearchVO drwSkdSearchVO = event.getDrwSkdSearchVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		List<DrwSkdSearchVO> list = null;
		try{
			list = command.searchDrwSkd(drwSkdSearchVO);
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0030 : Retrieve<br>
	 * Drewry SKD 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDrwPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopVsk0030Event event = (VopVsk0030Event)e;
//		VskVslDrwSkdVO vskVslDrwSkdVO = event.getVskVslDrwSkdVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		List<DrwPortListVO> list = null;
			list = command.searchDrwPortList();
			StringBuilder sb = new StringBuilder();
			if(list != null){
				sb.append(list.get(0).getPortCd());
				for(int i=1; i<list.size(); i++){
					sb.append("|" + list.get(i).getPortCd());
				}
			} 
			eventResponse.setETCData("port_cd", sb.toString());

		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0030 : Save
	 * VVD에 대해서 VSK Drewry Report 정보를 저장합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDrwRptByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0030Event event = (VopVsk0030Event)e;
		DrwSkdSearchVO drwSkdSearchVO = event.getDrwSkdSearchVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			begin();
			command.manageDrwRptByVvd(drwSkdSearchVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0030 : Delete
	 * VVD에 대해서  VSK Drewry Report 정보를 삭제합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDrwRptByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0030Event event = (VopVsk0030Event)e;
		DrwSkdSearchVO drwSkdSearchVO = event.getDrwSkdSearchVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			begin();
			command.removeDrwRptByVvd(drwSkdSearchVO);
//			eventResponse.setETCData("vsl_slan_cd", "");
//			eventResponse.setETCData("exist", "");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0030 : Update
	 * VVD에 대해서  VSK Drewry Report 정보를 업데이트합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyDrwRptByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0030Event event = (VopVsk0030Event)e;
		DrwSkdSearchVO drwSkdSearchVO = event.getDrwSkdSearchVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();

		try{
			begin();
			command.modifyDrwRptByVvd(drwSkdSearchVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0031 : Retrieve<br>
	 * Drewry SKD PORT 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDrwPorInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0031Event event = (VopVsk0031Event)e;
		//VskVslDrwSkdVO vskVslDrwSkdVO = event.getVskVslDrwSkdVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		List<DrwPortInfoVO> list = null;
		DrwPortInfoVO paramVo = event.getDrwPortInfoVO();
		try{
			list = command.searchDrwPortInfo(paramVo);
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0031 : Insert
	 * VSK Drewry Report의 Port Setup에서 Port를 추가하여  저장합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDrwPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0031Event event = (VopVsk0031Event)e;
		DrwPortListVO drwPortListVO = event.getDrwPortListVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			begin();
			command.manageDrwPortList(drwPortListVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0031 : Delete
	 * VSK Drewry Report의 Port Setup에서 Port를 삭제합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDrwPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0031Event event = (VopVsk0031Event)e;
		DrwPortListVO drwPortListVO = event.getDrwPortListVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			begin();
			command.removeDrwPortList(drwPortListVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0034 : Retrieve<br>
	 * Drewry Target Trade 정보를 조회합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDrwTrdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		VopVsk0034Event event = (VopVsk0034Event)e;
		//VskVslDrwSkdVO vskVslDrwSkdVO = event.getVskVslDrwSkdVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		List<DrwTrdInfoVO> list = null;
		try{
			list = command.searchDrwTrdInfo();
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0034 : Save
	 * VSK Drewry Report의 Trade Setup에서  추가하여  저장합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDrwTrdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0034Event event = (VopVsk0034Event)e;
		DrwTrdInfoVO drwTrdInfoVO = event.getDrwTrdInfoVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			begin();
			command.manageDrwTrdInfo(drwTrdInfoVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0034 : Delete
	 * VSK Drewry Report의 Trade Setup에서 Trade를 삭제합니다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDrwTrdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VopVsk0034Event event = (VopVsk0034Event)e;
		DrwTrdInfoVO drwTrdInfoVO = event.getDrwTrdInfoVO();
		OnTimeResultAnalysisBC command = new OnTimeResultAnalysisBCImpl();
		
		try{
			begin();
			command.removeDrwTrdInfo(drwTrdInfoVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		}		
		return eventResponse;
	}
}
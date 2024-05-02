/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleManagementSC.java
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.vop.vsk.actualschedulemanagement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBC;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.UdevVskTActskdEvent;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0025Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0026Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVsk0027Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0001Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0002Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.VopVskSPPVSK0003Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration.ActualScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.EdiLogDataGRPVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ServiceLaneVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic.OnTimeResultAnalysisBC;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.basic.OnTimeResultAnalysisBCImpl;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0028Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0029Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0032Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0231Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.event.VopVsk0232Event;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.OnTimeRsltAnalGRPVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultChangeStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultDelayStatusVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultOnTimeRatioVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultRemarkVO;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.ResultSkipStatusVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.CoastalScheduleMgtBC;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBC;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBCImpl;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedforrevenuevvd.basic.InterfaceScheduleForRevenueVVDBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedforrevenuevvd.basic.InterfaceScheduleForRevenueVVDBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic.InterfaceScheduleToExternalBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic.InterfaceScheduleToExternalBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic.InterfaceScheduleToIBISBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic.InterfaceScheduleToIBISBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskActPortSkdEdiLogVO;
import com.clt.syscommon.common.table.VskActPortSkdVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * ActualScheduleManagement Business Logic ServiceCommand
 * 
 * @author
 * @see ActualScheduleMgtDBDAO
 * @since J2EE 1.6
 */

public class ActualScheduleManagementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ActualScheduleManagement system preceding process for biz scenario<br>
	 * vop_vsk_0027 related objects creation<br>
	 */
	public void doStart() {
		log.debug("ActualScheduleManagementSC Start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ActualScheduleManagement system biz scenario closing<br>
	 * vop_vsk_0027 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ActualScheduleManagementSC End");
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("VopVsk0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActPortSkd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCallIndicator(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkPort(e);
			}
			//::FOR.NYK.START::by TOP:2014-09-10:://
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPort(e);
			}
			//::FOR.NYK.FINISH::by TOP:2014-09-10:://
			//::FOR.NYK.START::by DONGSOO:2014-10-13:://
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchFutureDate(e);
			}
			//::FOR.NYK.FINISH::by TOP:2014-10-13:://	
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
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkPort(e);
			}
			//::FOR.NYK.START::by TOP:2014-09-13:://
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPort(e);
			}
			//::FOR.NYK.FINISH::by TOP:2014-09-13:://
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
		}else if (e.getEventName().equalsIgnoreCase("UdevVskTActskdEvent")) {
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
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchRsltByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeRsltByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.ADD)){
				eventResponse = manageRsltByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyRsltByVvd(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * Inquiry Call Indicator
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCallIndicator(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		eventResponse.setETCData("call_ind_cd", VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
		eventResponse.setETCData("call_ind_nm", VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));
		
		/*
		 * Authorized office has permission to delete actual schedule. 
		 */
		StringBuilder sb = new StringBuilder();
		eventResponse.setETCData("auth_ofc", sb.toString());
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0025, VOP_VSK_0026, VOP_VSK_0027 : Port Change<br>
	 * Port Code 가 존재하는지 여부를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MdmLocationVO mdmLocationVO = new MdmLocationVO(); 
		
		if(e instanceof VopVsk0025Event){
			VopVsk0025Event event = (VopVsk0025Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}else if(e instanceof VopVsk0026Event){
			VopVsk0026Event event = (VopVsk0026Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}else if(e instanceof VopVsk0027Event){
			VopVsk0027Event event = (VopVsk0027Event)e;
			mdmLocationVO = event.getMdmLocationVO();
		}
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		String chkPort = command.checkPort(mdmLocationVO.getLocCd());
		
		eventResponse.setETCData("check_port", chkPort);
		
		return eventResponse;
	}
	
	//::FOR.NYK.START::by TOP:2014-09-10:://
	/**
	 * VOP_VSK_0025, VOP_VSK_0026<br>
	 * VVD 가 지나는 Port 를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPort(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		VSKCodeFinderBC 		command 		= new VSKCodeFinderBCImpl();
		List<VskComboVO> 		list 			= null;
		VvdVO 					paramVO 		= new VvdVO();
		
		if(e instanceof VopVsk0025Event){
			VopVsk0025Event event 	= (VopVsk0025Event)e;
			paramVO 				= event.getVvdVO();
		}else if(e instanceof VopVsk0026Event){
			VopVsk0026Event event 	= (VopVsk0026Event)e;
			paramVO 				= event.getVvdVO();
			//Inquiry 화면은 생성된 Port만 조회되도록 구분자 셋팅
			paramVO.setStatusflag("I");
		}
		
		list 				= command.searchPort(paramVO);
		StringBuilder sb 	= new StringBuilder();
		if(list != null){
			for(int i=0;i<list.size();i++){
				if(i == 0 ){
					sb.append(((VskComboVO)list.get(i)).getName());
				}else{
					sb.append("|" + ((VskComboVO)list.get(i)).getName());
				}
			}
			
			eventResponse.setETCData	("port_list", sb.toString());
			eventResponse.setRsVoList	(list);
		}
		
		return eventResponse;
	}	
	//::FOR.NYK.FINISH::by TOP:2014-09-10:://
	
	//::FOR.NYK.START::by dongsoo:2014-10-13:://
	/**
	 * VOP_VSK_0025, VOP_VSK_0026<br>
	 * VVD 가 지나는 Port 를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFutureDate(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		
		ActSkdMgtVO 			actSkdMgtVO 		= null;
		
		VopVsk0025Event event = (VopVsk0025Event)e;
		
		actSkdMgtVO = event.getActSkdMgtVO();
		ActualScheduleMgtBC 	command 			= new ActualScheduleMgtBCImpl();
		
		ActSkdDtlVO tmpVO		= command.checkInputActDateEffectiveness(actSkdMgtVO);
		StringBuffer	sbIneffectivenessMsg	= new StringBuffer("");
		int iInvalKnt = 0;
		if(tmpVO != null){
			
			String 			sInputATADateInvalid	= tmpVO.getInputATADateEffectiveness();
			String 			sInputATBDateInvalid	= tmpVO.getInputATBDateEffectiveness();
			String 			sInputATDDateInvalid	= tmpVO.getInputATDDateEffectiveness();
			
			
			if(sInputATADateInvalid != null && !"".equals(sInputATADateInvalid)){
				sbIneffectivenessMsg.append(sInputATADateInvalid);
				iInvalKnt++;
			}
			
			if(sInputATBDateInvalid != null && !"".equals(sInputATBDateInvalid)){
				if(sbIneffectivenessMsg.length() > 0) {
					sbIneffectivenessMsg.append("/").append(sInputATBDateInvalid);
				} else {
					sbIneffectivenessMsg.append(sInputATBDateInvalid);
				}
				iInvalKnt++;
			}
			
			if(sInputATDDateInvalid != null && !"".equals(sInputATDDateInvalid)){
				if(sbIneffectivenessMsg.length() > 0) {
					sbIneffectivenessMsg.append("/").append(sInputATDDateInvalid);
				} else {
					sbIneffectivenessMsg.append(sInputATDDateInvalid);
				}
				iInvalKnt++;
			}
		}

		eventResponse.setETCData("iCnt"   , String.valueOf(iInvalKnt));
		eventResponse.setETCData("infoMsg", sbIneffectivenessMsg.toString());
	
		return eventResponse;
	}	
	//::FOR.NYK.FINISH::by TOP:2014-10-13:://
	
	/**
	 * VOP_VSK_0025, VOP_VSK_0026, VOP_VSK_0027 : Vessel Code Change<br>
	 * Checking Vessel Code in MDM_VSL_CNTR
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVslCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VvdVO paramVO = new VvdVO();
		
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
			
		if(paramVO.getVslCd() == null){
			log.debug("");
			/*
			 * TODO
			 * MSG - 
			 */
//			throw new EventException(new ErrorHandler("VSK10028").getMessage());
		}else{
			chkCnt = command.checkVslCntr(paramVO.getVslCd());
		}
		
		if(chkCnt > 0){
			eventResponse.setETCData("vsl_chk", "Y");
		}else{
			eventResponse.setETCData("vsl_chk", "N");
			throw new EventException(new ErrorHandler("VSK10028").getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0025, VOP_VSK_0026 : Retrieve<br>
	 * Retrieving Actual Information of Vessel Calling Port.
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
			VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl();
			ActSkdMgtVO paramVO = new ActSkdMgtVO();
			ActSkdMgtVO actSkdMgtVO = null;
			YardVO yardVO = new YardVO();
			List<YardVO> yardList = null;
			
			if(e instanceof VopVsk0025Event){
				VopVsk0025Event event = (VopVsk0025Event)e;
				paramVO = event.getActSkdMgtVO();
				yardVO = event.getYardVO();
			}else if(e instanceof VopVsk0026Event){
				VopVsk0026Event event = (VopVsk0026Event)e;
				paramVO = event.getActSkdMgtVO();
				yardVO = event.getYardVO();
			}else if(e instanceof VopVskSPPVSK0002Event){
				VopVskSPPVSK0002Event event = (VopVskSPPVSK0002Event)e;
				paramVO = event.getActSkdMgtVO();
				yardVO = event.getYardVO();
			}
			
			actSkdMgtVO = command.searchActPortSkd(paramVO);
			
			if(actSkdMgtVO != null){
				/*
				 * Converting field name of VO to upper case, Setting ETCData name with it.
				 * ex) actSkdMgtVO.vslCD => eventResponse.setETCData("VSL_CD", actSkdMgtVO.getVslCd())
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
				
				//=====================================================================
				// No retrieving YardList in case EAI calling
				if(!(e instanceof VopVskSPPVSK0002Event)){
					yardVO.setLocCd(paramVO.getVpsPortCd());
					yardList = vskCodeFinderBC.searchYardListByPort(yardVO);
					StringBuilder sbCd = new StringBuilder();
					StringBuilder sbNm = new StringBuilder();
					
					if(yardList != null && yardList.size() > 0){
						sbCd.append(yardList.get(0).getYdCd());
						sbNm.append(yardList.get(0).getYdNm());
						for (int i = 1; i < yardList.size(); i++) {
							sbCd.append("|" + yardList.get(i).getYdCd());
							sbNm.append("|" + yardList.get(i).getYdNm());
						}
					}
					eventResponse.setETCData("yd_cd_list", sbCd.toString());
					eventResponse.setETCData("yd_nm_list", sbNm.toString());
				}
				//=====================================================================
				
				List<ActSkdMgtVO> list = new ArrayList<ActSkdMgtVO>();
				list.add(actSkdMgtVO);
				eventResponse.setRsVoList(list);
				
			}else{
				/*
				 * TODO
				 * ERROR MESSAGE
				 */
				eventResponse.setUserMessage(new ErrorHandler("VSK09005").getMessage());
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0025 : Save<br>
	 * Actual Schedule Report Creation (Vessel Movement). Creating and Updating created actual schedule information
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageActPortSkd(Event e) throws EventException {
		GeneralEventResponse 				eventResponse 		= new GeneralEventResponse();
		
		ActualScheduleMgtBC 				command 			= new ActualScheduleMgtBCImpl();
		CoastalScheduleMgtBC 				cstScheduleMgtBC 	= new VesselScheduleMgtBCImpl();
		
		ActSkdMgtVO 						actSkdMgtVO 		= new ActSkdMgtVO();
		
		SwapCstGRPVO 						swapCstGRPVO 		= new SwapCstGRPVO();
		VskVslPortSkdVO 					vskVslPortSkdVO 	= new VskVslPortSkdVO();
		InterfaceScheduleForRevenueVVDBC 	revenueCommand		= new InterfaceScheduleForRevenueVVDBCImpl();
//		List<VskVslPortSkdVO> portList = new ArrayList<VskVslPortSkdVO>();
		String 								usrId 				= "";
		
		String								sFromEventSystem	= "";
		String								sCvntFromEventSystem= "";
		
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
			VopVsk0025Event event = (VopVsk0025Event)e;
			actSkdMgtVO = event.getActSkdMgtVO();
			if(account == null){
				usrId = actSkdMgtVO.getUpdUsrId();
			}else{
				usrId = account.getUsr_id();
			}
			
			sFromEventSystem			= "VOP_VSK_0025";
			
		}else if(e instanceof VopVskSPPVSK0003Event){
			VopVskSPPVSK0003Event event = (VopVskSPPVSK0003Event)e;
			actSkdMgtVO = event.getActSkdMgtVO();
			if(account == null){
				usrId = actSkdMgtVO.getUpdUsrId();
			}else{
				usrId = account.getUsr_id();
			}
			
			sFromEventSystem			= "VOP_VSK_SPP_VSK_0003";
			
		}else if(e instanceof UdevVskTActskdEvent){
			UdevVskTActskdEvent event 	= (UdevVskTActskdEvent)e;
			actSkdMgtVO 				= event.getActSkdMgtVO();
			usrId 						= "IF_EDI_SVC";
			
			sFromEventSystem			= "IF_EDI_SVC";
			
		}else if(e instanceof VopVsk0027Event){
			VopVsk0027Event event 		= (VopVsk0027Event)e;
			actSkdMgtVO 				= event.getActSkdMgtVO();
			usrId 						= "IF_EDI_SVC";
			
			sFromEventSystem			= "IF_EDI_SVC(VOP_VSK_0027)";
		}
		
		try{
			
			begin();
			
			actSkdMgtVO.setCreUsrId				(usrId);
			actSkdMgtVO.setUpdUsrId				(usrId);
			
//			[PORT]===========================================================================
			VslSkdChgStsGRPVO actualGRPVO 		= command.manageActPortSkd		(actSkdMgtVO);	// Creating and Updating Actual Schedule Information
																								// Creating Actual Schedule History
																								// Preparing Information for interface to other module
			
			actSkdMgtVO.setPortSkdStsCd			(actualGRPVO.getPortSkdStsCd	());

			if(VSKGeneralUtil.isNull(actSkdMgtVO.getSlanCd())){
				actSkdMgtVO.setSlanCd			(actualGRPVO.getSlanCd			());
			}
			
			vskVslPortSkdVO.setVslCd			(actSkdMgtVO.getVslCd			());
			vskVslPortSkdVO.setSkdVoyNo			(actSkdMgtVO.getSkdVoyNo		());
			vskVslPortSkdVO.setSkdDirCd			(actSkdMgtVO.getSkdDirCd		());
			vskVslPortSkdVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd		());
			vskVslPortSkdVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq		());
			vskVslPortSkdVO.setPortSkdStsCd		(actSkdMgtVO.getPortSkdStsCd	());
			vskVslPortSkdVO.setYdCd				(actSkdMgtVO.getYdCd			());
			
			if(		vskVslPortSkdVO.getVpsPortCd() != null 
				&&	vskVslPortSkdVO.getYdCd		() != null
				&&	!vskVslPortSkdVO.getVpsPortCd().equals(vskVslPortSkdVO.getYdCd().substring(0,5))
				)
			{
				/**	Unexpected system error took place during data processing. Please try again. : ($s)	**/
				throw new EventException(new ErrorHandler("VSK00011").getMessage());
			}
			
			vskVslPortSkdVO.setVpsEtaDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActArrDt()));
			vskVslPortSkdVO.setVpsEtbDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActBrthDt()));
			vskVslPortSkdVO.setVpsEtdDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActDepDt()));
			vskVslPortSkdVO.setTurnPortFlg		(actSkdMgtVO.getTurnPortFlg		());
			vskVslPortSkdVO.setTurnPortIndCd	(actSkdMgtVO.getTurnPortIndCd	());
			vskVslPortSkdVO.setTurnSkdVoyNo		(actSkdMgtVO.getTurnSkdVoyNo	());
			vskVslPortSkdVO.setTurnSkdDirCd		(actSkdMgtVO.getTurnSkdDirCd	());
			vskVslPortSkdVO.setTurnClptIndSeq	(actSkdMgtVO.getTurnClptIndSeq	());
			vskVslPortSkdVO.setSlanCd			(actSkdMgtVO.getSlanCd			());
			
			if(		VSKGeneralUtil.isNotNull	(actSkdMgtVO.getActArrDt		())
				||	VSKGeneralUtil.isNotNull	(actSkdMgtVO.getActBrthDt		())
				||	VSKGeneralUtil.isNotNull	(actSkdMgtVO.getActDepDt		()))
			{
				//Setting VSK_VSL_PORT_SKD.ACT_INP_FLG = 'Y' in case ATA or ATB or ATD input
				vskVslPortSkdVO.setActInpFlg	("Y");
			}
			
			vskVslPortSkdVO.setUpdUsrId			(usrId);
//			portList.add(vskVslPortSkdVO);
			
//			swapCstGRPVO.setVskVslPortSkdVOList(portList);
			swapCstGRPVO.setVskVslPortSkdVO		(vskVslPortSkdVO);
			
			List<SceActRcvIfVO> sceAllList 		= new ArrayList<SceActRcvIfVO>();
			
			VslSkdChgStsGRPVO 	coastalGRPVO 	= cstScheduleMgtBC.manageCstSkdByActual(swapCstGRPVO);
			
			//Transmitting Changed Schedule to Booking
			this.sendBkgByVslSkdChg				(actualGRPVO, coastalGRPVO);
			
			/*
			 * about COP
			 * Setting Actual List and Coastal List of Cop Transmitting List.
			 */
			// Actual Data
			List<SceActRcvIfVO> sceActualRcvList = actualGRPVO.getSceActRcvIfVOs();
			if(sceActualRcvList != null && sceActualRcvList.size() > 0){
				for(SceActRcvIfVO sceVO : sceActualRcvList){
					sceAllList.add(sceVO);
				}
			}
			// Coastal Data
			List<SceActRcvIfVO> sceCoastalList = coastalGRPVO.getSceActRcvIfVOs();

			if(sceCoastalList != null && sceCoastalList.size() > 0){
				for(SceActRcvIfVO sceVO : sceCoastalList){
					// Using Coastal Logic in case of Yard Changing.
					if("27".equals(sceVO.getActRcvTpCd())){
						sceAllList.add(sceVO);
					}else{
//						Transmitting Actual Change to COP in case Actual Change
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
			
			// Transmitting Actual List and Coastal List to COP
			this.sendCopByVslSkdChg(sceAllList);
			
//			// Transmitting ERP
//			if(coastalGRPVO.getErpVvdVOs() != null && coastalGRPVO.getErpVvdVOs().size() > 0){
//				
//				for(VvdVO vo : coastalGRPVO.getErpVvdVOs()){
//					vo.setCreUsrId(usrId);
//					vo.setUpdUsrId(usrId);
//				}
//				
//				cstScheduleMgtBC.sendVslSkdErpIf(coastalGRPVO.getErpVvdVOs());
//			}
			//::FOR.NYK.START::by KJH:2014-11-24:://
			
			List<VvdVO> vvdVOs = new ArrayList<VvdVO>();
			
			if( actSkdMgtVO != null ){
				VvdVO vvdVO 		= new VvdVO();
				vvdVO.setVslCd		(actSkdMgtVO.getVslCd	());
				vvdVO.setSkdVoyNo	(actSkdMgtVO.getSkdVoyNo());
				vvdVO.setSkdDirCd	(actSkdMgtVO.getSkdDirCd());
				vvdVO.setStatusflag	("N");
				
				vvdVOs.add			(vvdVO);
			}
			
			////VSKCodeFinderBC combc = new VSKCodeFinderBCImpl();
			////combc.sendRevenueVVD(vvdVOs);
			//::FOR.NYK.FINISH::by KJH:2014-11-24:://
			
			commit();
			
			//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://
			begin();
			revenueCommand.interfaceScheduleForRevenueVVD	(vvdVOs);	
			commit();
			//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			
			//::by TOP:2015-05-08:://
			/* ============================================================================
			 * Creation for Vessel Schedule History ::2015-05-08::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * VSK_VSL_SKD_HIS
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
			//::by TOP:2015-05-08:://cstScheduleMgtBC.createVesselScheduleChangeHistory(coastalGRPVO.getVskVslSkdVOs(), null, sCvntFromEventSystem);	
			//::by TOP:2015-05-08:://
			
			// :: VIPS START ::
			List<VskVslPortSkdVO> 	mVslPortSkdList 		= mergeVslPortSkdList(command.getVslPortSkdList()		, command.getVslPortSkdList()	);
			List<VskVipsIfMstVO>	mVslSkdList				= cnvtToIfMst(makePortToVsl(command.getVskVslSkdList()	,  mVslPortSkdList)				);
			
			InterfaceScheduleToExternalBC 	ifCommand 		= new InterfaceScheduleToExternalBCImpl();
			ifCommand.createVskVipsIf						(mVslSkdList, cnvtToIfDtl(mVslPortSkdList, command.getVskActPortSkdList()), "N");
			// :: VIPS END ::

			//IBIS START
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			List<VskVslSkdVO> vskVslSkdList = makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList());
			if (command.getVskActPortSkdList().size() > 0 ) {
				vskVslSkdList  = makeActPortToVsl(vskVslSkdList, command.getVskActPortSkdList());
			}
			ibisIfCommand.createVskVslSkdIbisIfBackEndJob(cnvtToIfVskVslSkd(vskVslSkdList), null, "VskVslSkd");
			//IBIS END
			
			List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
			for(int i=0; i<mVslSkdList.size(); i++){
				VslSkdXtraHisVO		tmpVO				= new VslSkdXtraHisVO();
				VskVipsIfMstVO		tmpVskVslSkdVO		= mVslSkdList.get(i);
				
				tmpVO.setVskdTpCd		("M");							/** 'M':VVD Schedule, 'P':Port Schedule **/
				tmpVO.setVskdCngTpCd	("U");							/** 'N':Create, 'D':VVD Deletion		**/
				tmpVO.setBfrVslSlanCd	(tmpVskVslSkdVO.getVslSlanCd	());
				tmpVO.setBfrVslCd		(tmpVskVslSkdVO.getVslCd		());
				tmpVO.setBfrSkdVoyNo	(tmpVskVslSkdVO.getSkdVoyNo		());
				tmpVO.setBfrSkdDirCd	(tmpVskVslSkdVO.getSkdDirCd		());
				
				String sTmpUsrId		= null;
				if(usrId != null || !"".equals(usrId)){
					sTmpUsrId	= usrId;
				}else{
					sTmpUsrId	= "NO-LOGIN_SESSION";
				}
				
				//tmpVO.setUpdUsrId		(NO-LOGIN_SESSION.getUsr_id()==null || "".equals(account.getUsr_id()) ?"NO-LOGIN_SESSION":account.getUsr_id());
				tmpVO.setUpdUsrId		(sTmpUsrId);
				
				vslSkdXtraHisVOs.add	(tmpVO);				
			}
			
			if(vslSkdXtraHisVOs != null && vslSkdXtraHisVOs.size()>0)	cstScheduleMgtBC.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, sCvntFromEventSystem);
			
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse removeVskActPortSkd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ActualScheduleMgtBC 	actualScheduleMgtBC = new ActualScheduleMgtBCImpl();
		CoastalScheduleMgtBC 	cstScheduleMgtBC 	= new VesselScheduleMgtBCImpl();
		
		ActSkdMgtVO 			actSkdMgtVO 		= null;
		VskActPortSkdVO 		vskActPortSkdVO 	= new VskActPortSkdVO();
		VskVslPortSkdVO 		vskVslPortSkdVO 	= new VskVslPortSkdVO();
		List<VskVslPortSkdVO> 	vskVslPortSkdVOs 	= new ArrayList<VskVslPortSkdVO>();
		
		VopVsk0025Event 		event 				= (VopVsk0025Event)e;
		actSkdMgtVO 								= event.getActSkdMgtVO();
		
		String					sCvntFromEventSystem= "DELETE_ACT_SKD(VOP_VSK_0025)";
		
		
		try{
			
		    String updUsrId  = "";
		    if(account == null){
		    	updUsrId    = "NO-LOGIN_SESSION";
		    }else{
		    	updUsrId    = account.getUsr_id();
		    }
			
			begin();
			
			vskActPortSkdVO.setVslCd(actSkdMgtVO.getVslCd());
			vskActPortSkdVO.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
			vskActPortSkdVO.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
			vskActPortSkdVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
			vskActPortSkdVO.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
			vskActPortSkdVO.setUpdUsrId(updUsrId);
			
			actualScheduleMgtBC.removeVskActPortSkd(vskActPortSkdVO, actSkdMgtVO);
			
			vskVslPortSkdVO.setVslCd(actSkdMgtVO.getVslCd());
			vskVslPortSkdVO.setSkdVoyNo(actSkdMgtVO.getSkdVoyNo());
			vskVslPortSkdVO.setSkdDirCd(actSkdMgtVO.getSkdDirCd());
			vskVslPortSkdVO.setVpsPortCd(actSkdMgtVO.getVpsPortCd());
			vskVslPortSkdVO.setClptIndSeq(actSkdMgtVO.getClptIndSeq());
			vskVslPortSkdVO.setUpdUsrId(updUsrId);
			
			vskVslPortSkdVOs.add(vskVslPortSkdVO);
			
			if("Y".equals(actSkdMgtVO.getTurnPortFlg())){
				// Updating Virtual Port in case of Turning Port
				
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
			
			// :: VIPS START ::
			List<VskVslPortSkdVO> 			mVslPortSkdList = mergeVslPortSkdList(actualScheduleMgtBC.getVslPortSkdList(), actualScheduleMgtBC.getVslPortSkdList());
			List<VskVipsIfMstVO>			mVslSkdList		= cnvtToIfMst(makePortToVsl(actualScheduleMgtBC.getVskVslSkdList(), mVslPortSkdList));
			
			InterfaceScheduleToExternalBC 	ifCommand 		= new InterfaceScheduleToExternalBCImpl();
			ifCommand.createVskVipsIf						(mVslSkdList, cnvtToIfDtl(mVslPortSkdList, actualScheduleMgtBC.getVskActPortSkdList()), "D");
			// :: VIPS END ::
			
			//IBIS START
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			List<VskVslSkdVO> vskVslSkdList = makePortToVsl(actualScheduleMgtBC.getVskVslSkdList(), actualScheduleMgtBC.getVslPortSkdList());
			if (actualScheduleMgtBC.getVskActPortSkdList().size() > 0 ) {
				vskVslSkdList  = makeActPortToVsl(vskVslSkdList, actualScheduleMgtBC.getVskActPortSkdList());
			}
			ibisIfCommand.createVskVslSkdIbisIfBackEndJob(cnvtToIfVskVslSkd(vskVslSkdList), null, "VskVslSkd");
			//IBIS END
			
			List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
			for(int i=0; i<mVslSkdList.size(); i++){
				VslSkdXtraHisVO		tmpVO				= new VslSkdXtraHisVO();
				VskVipsIfMstVO		tmpVskVslSkdVO		= mVslSkdList.get(i);
				
				tmpVO.setVskdTpCd		("M");							/** 'M':VVD Schedule, 'P':Port Schedule **/
				tmpVO.setVskdCngTpCd	("U");							/** 'N':Create, 'D':VVD Deletion		**/
				tmpVO.setBfrVslSlanCd	(tmpVskVslSkdVO.getVslSlanCd	());
				tmpVO.setBfrVslCd		(tmpVskVslSkdVO.getVslCd		());
				tmpVO.setBfrSkdVoyNo	(tmpVskVslSkdVO.getSkdVoyNo		());
				tmpVO.setBfrSkdDirCd	(tmpVskVslSkdVO.getSkdDirCd		());
				
				tmpVO.setUpdUsrId		(updUsrId);
				vslSkdXtraHisVOs.add	(tmpVO);				
			}
			
			if(vslSkdXtraHisVOs != null && vslSkdXtraHisVOs.size()>0)	cstScheduleMgtBC.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, sCvntFromEventSystem);
			
			
		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * manageActPortSkd : Call<br>
	 * Transmitting information to Booking in case Schedule Change
	 * 
	 * @param VslSkdChgStsGRPVO vslSkdCngStsGRPVO
	 * @exception EventException
	 */
	private void sendBkgByVslSkdChg(VslSkdChgStsGRPVO actualGRPVO, VslSkdChgStsGRPVO coastalGRPVO) throws EventException {
		
		GeneralBookingSplitCombineBC 	bkgScbCmd = new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC 		bkgRctCmd = new GeneralBookingReceiptBCImpl		();
		BLIssuanceBC 					bkgbliCmd = new BLIssuanceBCImpl				();
		BookingProcessMgtBC 			bkgPrsCmd = new BookingProcessMgtBCImpl			();
		
		log.error("\n=================== Booking START <<sendBkgByVslSkdChg>> ===================\n");
		
		List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = coastalGRPVO.getVslSkdCngNoticeVOs();
		
		if(vslSkdCngNoticeVOs != null && vslSkdCngNoticeVOs.size()>0){
			try{
				bkgScbCmd.sendVslSkdCngNotice(vslSkdCngNoticeVOs);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10045").getMessage());
			}
		}
		
		log.error("\n=================== <<sendBkgByVslSkdChg.sendVslSkdCngNotice step#1 Finished>> ===================\n");
		
		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs = coastalGRPVO.getVslSkdCngUpdateVOs();
		if(vslSkdCngUpdateVOs != null && vslSkdCngUpdateVOs.size()>0){
			try{
				//GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL
				//GeneralBookingReceiptDBDAOmodifyPolForVslSkdCngUSQL
				//GeneralBookingReceiptDBDAOmodifyPodForVslSkdCngUSQL
				
				bkgRctCmd.modifyBkgVvdForVslSkdCng(vslSkdCngUpdateVOs, account);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10047").getMessage());
			}
		}
		
		log.error("\n=================== <<sendBkgByVslSkdChg.modifyBkgVvdForVslSkdCng step#2 Finished>> ===================\n");
		
		List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = coastalGRPVO.getBkgVvdBdrLogVOs();
		if(bkgVvdBdrLogVOs != null && bkgVvdBdrLogVOs.size()>0){
			try{
				for(BkgVvdBdrLogVO bkgVvdBdrLogVO : bkgVvdBdrLogVOs){
					
					//bkgPrsCmd.manageBKGBDRLOG(bkgVvdBdrLogVO, account);
					bkgPrsCmd.manageBKGBDRLOGBackEndJob(bkgVvdBdrLogVO, account);
				}
			}catch(Exception ex){
				log.error(ex.getMessage());
			}
		}
		
		log.error("\n=================== <<sendBkgByVslSkdChg.manageBKGBDRLOGBackEndJob step#3 Finished>> ===================\n");
		
		List<CanonEmlVO> canonEmlVOs = actualGRPVO.getCanonEmlVOs();
		if(canonEmlVOs != null && canonEmlVOs.size()>0){
			try{
				for(CanonEmlVO canonEmlVO : canonEmlVOs){
					bkgbliCmd.sendCanonEmlBkg(canonEmlVO, account);
				}
			}catch(Exception ex){
				log.error(ex.getMessage());
			}
		}
		
		log.error("\n=================== Booking END <<sendBkgByVslSkdChg>> ===================\n");
	}
	
	/**
	 * manageCstSkdByVvd, manageCstSkdBerthWdo : Call
	 * Transmitting Information to COP in case Schedule change
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
				throw new EventException(new ErrorHandler("VSK10051").getMessage());
			}
		}
		log.debug("=================== COP END ===================");
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * Retrieving Target Lane List
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
		}

//		mdmVslSvcLaneVO.setVslSvcTpCd(paramVO.getVslSvcTpCd());
//		mdmVslSvcLaneVO.setActSkdTgtFlg("Y");
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * Retrieving Actual Report input state of Ports
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
			
			list = command.searchActPortSkdInputSum(paramVO);
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * Retrieving Detail Actual Report input state of Ports
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
			
			list = command.searchActPortSkdInputDtl(paramVO);
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * Retrieving Uncompleted Actual Schedule Report
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
			
			list = command.searchActPortSkdUnCmplDtl(paramVO);
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * Retrieving Actual SKD Information through EDI
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
			
			list = command.searchActPortSkdEdiMntr(paramVO);
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieving OnTimeResultAnalysis<br>
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
			
			list = command.searchRsltRmkDtlList(paramVO);
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Open<BR>
	 * Retrieving Office of Managing Port Information
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
			sb.append(list.get(0).getOfcCd());
			for(int i=1; i<list.size(); i++){
				sb.append("|"+list.get(i).getOfcCd());
			}
			
			eventResponse.setETCData("rhq_list", sb.toString());
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0027 : Retrieve<br>
	 * Retrieving Control Office Code of affiliated RHQ
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
	 * Retrying to Manage Actual Port Schedule in case Error EDI Message Receive
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRetryEDIMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
		ActSkdEdiMntrVO[] actSkdEdiMntrVOs = null;
		VopVsk0027Event event = null;
		
		if(e instanceof VopVsk0027Event){
			event = (VopVsk0027Event)e;
			actSkdEdiMntrVOs = event.getActSkdEdiMntrVOs();
		}
		
		try{
			if(actSkdEdiMntrVOs != null){
				List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs = new ArrayList<VskActPortSkdEdiLogVO>();
				for(ActSkdEdiMntrVO actSkdEdiMntrVO : actSkdEdiMntrVOs){
					VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO = new VskActPortSkdEdiLogVO();
					
					vskActPortSkdEdiLogVO.setRcvDt(actSkdEdiMntrVO.getRcvDt());
					vskActPortSkdEdiLogVO.setRcvSeq(actSkdEdiMntrVO.getRcvSeq());
					vskActPortSkdEdiLogVO.setEdiVslNm(actSkdEdiMntrVO.getEdiVslNm());
					vskActPortSkdEdiLogVO.setEdiSkdVoyNo(actSkdEdiMntrVO.getEdiSkdVoyNo());
					vskActPortSkdEdiLogVO.setEdiSkdDirNm(actSkdEdiMntrVO.getEdiSkdDirNm());
					vskActPortSkdEdiLogVO.setVpsPortCd(actSkdEdiMntrVO.getVpsPortCd());
					vskActPortSkdEdiLogVO.setClptIndSeq(actSkdEdiMntrVO.getClptIndSeq());
					vskActPortSkdEdiLogVO.setYdCd(actSkdEdiMntrVO.getYdCd());
					vskActPortSkdEdiLogVO.setEdiActArrDt(actSkdEdiMntrVO.getEdiActArrDt());
					vskActPortSkdEdiLogVO.setEdiActBrthDt(actSkdEdiMntrVO.getEdiActBrthDt());
					vskActPortSkdEdiLogVO.setEdiActDepDt(actSkdEdiMntrVO.getEdiActDepDt());
					vskActPortSkdEdiLogVO.setScsFlg("N");
//					vskActPortSkdEdiLogVO.setRsltMsg(rsltMsg);
					vskActPortSkdEdiLogVO.setSndrTrdPrnrId(actSkdEdiMntrVO.getSndrTrdPrnrId());
					vskActPortSkdEdiLogVO.setRcvrTrdPrnrId(actSkdEdiMntrVO.getRcvrTrdPrnrId());
					vskActPortSkdEdiLogVO.setEdiMsgTpId(actSkdEdiMntrVO.getEdiMsgTpId());
					vskActPortSkdEdiLogVO.setEdiMsgProcId(actSkdEdiMntrVO.getEdiMsgProcId());
					vskActPortSkdEdiLogVO.setLloydNo(actSkdEdiMntrVO.getLloydNo());
					vskActPortSkdEdiLogVO.setCallSgnNo(actSkdEdiMntrVO.getCallSgnNo());
					vskActPortSkdEdiLogVO.setShpCallNo(actSkdEdiMntrVO.getShpCallNo());
					vskActPortSkdEdiLogVO.setUpdUsrId("IF_EDI_SVC");
					
					vskActPortSkdEdiLogVOs.add(vskActPortSkdEdiLogVO);
				}
				
				EdiLogDataGRPVO rtnGRPVO = auditReceivedEdiData(vskActPortSkdEdiLogVOs);
				List<VskActPortSkdEdiLogVO> auditVOs = rtnGRPVO.getVskActPortSkdEdiLogVOs();
				List<VskVslPortSkdVO> vskVslPortSkdVOs = rtnGRPVO.getVskVslPortSkdVOs();
				List<VskActPortSkdVO> vskActPortSkdVOs = rtnGRPVO.getVskActPortSkdVOs();
				
				int successCnt = rtnGRPVO.getValue1();
				int failCnt = rtnGRPVO.getValue2();

//				################ Saving MQ Full Message ################
				if(auditVOs != null && auditVOs.size() > 0){
					int voCnt = auditVOs.size();
					for(int i=0; i<voCnt; i++){
						VskActPortSkdEdiLogVO paramVO = auditVOs.get(i);
						ActSkdMgtVO actSkdMgtVO = new ActSkdMgtVO();
						actSkdMgtVO.setSlanCd(paramVO.getVslSlanCd());
						actSkdMgtVO.setVslCd(paramVO.getVslCd());
						actSkdMgtVO.setSkdVoyNo(paramVO.getSkdVoyNo());
						actSkdMgtVO.setSkdDirCd(paramVO.getSkdDirCd());
						actSkdMgtVO.setVpsPortCd(paramVO.getVpsPortCd());
						actSkdMgtVO.setClptIndSeq(vskVslPortSkdVOs.get(i).getClptIndSeq());
						
						actSkdMgtVO.setPortSkdStsCd(portSkdStsCdControl(paramVO));
						
						actSkdMgtVO.setTurnPortFlg(vskVslPortSkdVOs.get(i).getTurnPortFlg());
						actSkdMgtVO.setTurnPortIndCd(vskVslPortSkdVOs.get(i).getTurnPortIndCd());
						actSkdMgtVO.setTurnSkdVoyNo(vskVslPortSkdVOs.get(i).getTurnSkdVoyNo());
						actSkdMgtVO.setTurnSkdDirCd(vskVslPortSkdVOs.get(i).getTurnSkdDirCd());
						actSkdMgtVO.setTurnClptIndSeq(vskVslPortSkdVOs.get(i).getTurnClptIndSeq());
						
						actSkdMgtVO.setYdCd(paramVO.getYdCd());
						
						actSkdMgtVO.setActArrDt(paramVO.getActArrDt()); //ATA
						actSkdMgtVO.setActBrthDt(paramVO.getActBrthDt()); //ATB
						actSkdMgtVO.setActDepDt(paramVO.getActDepDt()); //ATD
						
						if (vskActPortSkdVOs != null && vskActPortSkdVOs.size() > 0) {
							//[Vessel ACT SKD Info]
//							actSkdMgtVO.setLstEtaDt(vskActPortSkdVOs.get(i).getLstEtaDt());
							actSkdMgtVO.setVslArrDlayRsnCd(vskActPortSkdVOs.get(i).getVslArrDlayRsnCd());
							
//							actSkdMgtVO.setLstEtbDt(vskActPortSkdVOs.get(i).getLstEtbDt());
							actSkdMgtVO.setVslBrthDlayRsnCd(vskActPortSkdVOs.get(i).getVslBrthDlayRsnCd());
							
//							actSkdMgtVO.setLstEtdDt(vskActPortSkdVOs.get(i).getLstEtdDt());
							actSkdMgtVO.setVslDepDlayRsnCd(vskActPortSkdVOs.get(i).getVslDepDlayRsnCd());
							
							//[Vessel Condition Info - Arrival]
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
							
							//[Vessel Condition Info - Supply]
							actSkdMgtVO.setSplFoilWgt(vskActPortSkdVOs.get(i).getSplFoilWgt());
							actSkdMgtVO.setSplLowSulpFoilWgt(vskActPortSkdVOs.get(i).getSplLowSulpFoilWgt());
							actSkdMgtVO.setSplDoilWgt(vskActPortSkdVOs.get(i).getSplDoilWgt());
							actSkdMgtVO.setSplLowSulpDoilWgt(vskActPortSkdVOs.get(i).getSplLowSulpDoilWgt());
							actSkdMgtVO.setSplFrshWtrWgt(vskActPortSkdVOs.get(i).getSplFrshWtrWgt());
							
							//[Vessel Condition Info - Departure]
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
							
							//[Vessel Condition Info - Etc.]
							actSkdMgtVO.setTtlSlgWgt(vskActPortSkdVOs.get(i).getTtlSlgWgt());
							actSkdMgtVO.setTtlGbgQty(vskActPortSkdVOs.get(i).getTtlGbgQty());
							
							actSkdMgtVO.setPltLstUnldDt(vskActPortSkdVOs.get(i).getPltLstUnldDt());
							actSkdMgtVO.setBfrBrthAnkDrpDt(vskActPortSkdVOs.get(i).getBfrBrthAnkDrpDt());
							actSkdMgtVO.setBfrBrthAnkOffDt(vskActPortSkdVOs.get(i).getBfrBrthAnkOffDt());
							actSkdMgtVO.setAftUnbrthAnkDrpDt(vskActPortSkdVOs.get(i).getAftUnbrthAnkDrpDt());
							actSkdMgtVO.setAftUnbrthAnkOffDt(vskActPortSkdVOs.get(i).getAftUnbrthAnkOffDt());
							
							actSkdMgtVO.setDiffRmk(vskActPortSkdVOs.get(i).getDiffRmk());
						}
						
						actSkdMgtVO.setCreUsrId(paramVO.getCreUsrId());	// Setting Session Info
						actSkdMgtVO.setUpdUsrId(paramVO.getUpdUsrId());	// Setting Session Info
	
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
	 * Retrieving SKD Status (Delay Status)<br>
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
	 * Retrieving Skip Status<br>
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
	 * Retrieving Skip Change Status<br>
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
	 * Handling Retrieving Event of SKD Status (Skip Status)<br>
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
	 * Handling Retrieving Event of SKD Status (Skip Change Status)<br>
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
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDIToTerminal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try { 
			if (e.getEventName().equalsIgnoreCase("UdevVskTActskdEvent")){
				UdevVskTActskdEvent event = (UdevVskTActskdEvent)e;
				
				log.info("################### ACTUAL EDI START ###################");
				
//				################ Saving MQ Full Flat File ################
				String flatFile = event.getFlatFile();
				List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs 	= createVskActPortSkdEdiLog(flatFile);
				
//				################ Checking MQ Message and Parsing. ################
				EdiLogDataGRPVO 			rtnGRPVO 				= auditReceivedEdiData(vskActPortSkdEdiLogVOs);
				
				List<VskActPortSkdEdiLogVO> auditVOs 				= rtnGRPVO.getVskActPortSkdEdiLogVOs();
				List<VskVslPortSkdVO> 		vskVslPortSkdVOs 		= rtnGRPVO.getVskVslPortSkdVOs();
				List<VskActPortSkdVO> 		vskActPortSkdVOs 		= rtnGRPVO.getVskActPortSkdVOs();
				
//				################ Saving MQ and Parsing Full Message ################
				if(auditVOs != null && auditVOs.size() > 0){
					int voCnt = auditVOs.size();
					for(int i=0; i<voCnt; i++){
						VskActPortSkdEdiLogVO paramVO = auditVOs.get(i);
						ActSkdMgtVO actSkdMgtVO = new ActSkdMgtVO();
						actSkdMgtVO.setSlanCd(paramVO.getVslSlanCd());
						actSkdMgtVO.setVslCd(paramVO.getVslCd());
						actSkdMgtVO.setSkdVoyNo(paramVO.getSkdVoyNo());
						actSkdMgtVO.setSkdDirCd(paramVO.getSkdDirCd());
						actSkdMgtVO.setVpsPortCd(paramVO.getVpsPortCd());
						actSkdMgtVO.setClptIndSeq(paramVO.getClptIndSeq());
						actSkdMgtVO.setPortSkdStsCd(portSkdStsCdControl(paramVO));
																		
						actSkdMgtVO.setTurnPortFlg(vskVslPortSkdVOs.get(i).getTurnPortFlg());
						actSkdMgtVO.setTurnPortIndCd(vskVslPortSkdVOs.get(i).getTurnPortIndCd());
						actSkdMgtVO.setTurnSkdVoyNo(vskVslPortSkdVOs.get(i).getTurnSkdVoyNo());
						actSkdMgtVO.setTurnSkdDirCd(vskVslPortSkdVOs.get(i).getTurnSkdDirCd());
						actSkdMgtVO.setTurnClptIndSeq(vskVslPortSkdVOs.get(i).getTurnClptIndSeq());						
						actSkdMgtVO.setYdCd(paramVO.getYdCd());
						
						actSkdMgtVO.setActArrDt(paramVO.getActArrDt()); //ATA
						actSkdMgtVO.setActBrthDt(paramVO.getActBrthDt()); //ATB
						actSkdMgtVO.setActDepDt(paramVO.getActDepDt()); //ATD
						
						if (vskActPortSkdVOs != null && vskActPortSkdVOs.size() > 0) {
							//[Vessel ACT SKD Info]
//							actSkdMgtVO.setLstEtaDt(vskActPortSkdVOs.get(i).getLstEtaDt());
							actSkdMgtVO.setVslArrDlayRsnCd(vskActPortSkdVOs.get(i).getVslArrDlayRsnCd());
							
//							actSkdMgtVO.setLstEtbDt(vskActPortSkdVOs.get(i).getLstEtbDt());
							actSkdMgtVO.setVslBrthDlayRsnCd(vskActPortSkdVOs.get(i).getVslBrthDlayRsnCd());
							
//							actSkdMgtVO.setLstEtdDt(vskActPortSkdVOs.get(i).getLstEtdDt());
							actSkdMgtVO.setVslDepDlayRsnCd(vskActPortSkdVOs.get(i).getVslDepDlayRsnCd());
							
							//[Vessel Condition Info - Arrival]
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
							
							//[Vessel Condition Info - Supply]
							actSkdMgtVO.setSplFoilWgt(vskActPortSkdVOs.get(i).getSplFoilWgt());
							actSkdMgtVO.setSplLowSulpFoilWgt(vskActPortSkdVOs.get(i).getSplLowSulpFoilWgt());
							actSkdMgtVO.setSplDoilWgt(vskActPortSkdVOs.get(i).getSplDoilWgt());
							actSkdMgtVO.setSplLowSulpDoilWgt(vskActPortSkdVOs.get(i).getSplLowSulpDoilWgt());
							actSkdMgtVO.setSplFrshWtrWgt(vskActPortSkdVOs.get(i).getSplFrshWtrWgt());
							
							//[Vessel Condition Info - Departure]
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
							
							//[Vessel Condition Info - Etc.]
							actSkdMgtVO.setTtlSlgWgt(vskActPortSkdVOs.get(i).getTtlSlgWgt());
							actSkdMgtVO.setTtlGbgQty(vskActPortSkdVOs.get(i).getTtlGbgQty());
							
							actSkdMgtVO.setPltLstUnldDt(vskActPortSkdVOs.get(i).getPltLstUnldDt());
							actSkdMgtVO.setBfrBrthAnkDrpDt(vskActPortSkdVOs.get(i).getBfrBrthAnkDrpDt());
							actSkdMgtVO.setBfrBrthAnkOffDt(vskActPortSkdVOs.get(i).getBfrBrthAnkOffDt());
							actSkdMgtVO.setAftUnbrthAnkDrpDt(vskActPortSkdVOs.get(i).getAftUnbrthAnkDrpDt());
							actSkdMgtVO.setAftUnbrthAnkOffDt(vskActPortSkdVOs.get(i).getAftUnbrthAnkOffDt());
							
							actSkdMgtVO.setDiffRmk(vskActPortSkdVOs.get(i).getDiffRmk());
							
							actSkdMgtVO.setDchgCmplDt(vskActPortSkdVOs.get(i).getDchgCmplDt());
							
						}
						actSkdMgtVO.setCreUsrId(paramVO.getCreUsrId());	// Setting Session Info
						actSkdMgtVO.setUpdUsrId(paramVO.getUpdUsrId());	// Setting Session Info
	
						event.setActSkdMgtVO(actSkdMgtVO);
						
						this.manageActPortSkdByEDI(event, paramVO);
						
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
	 * Saving EDI Data in Actual
	 * 
	 * @param Event event
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	private void manageActPortSkdByEDI(Event event, VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws EventException{
		
		try{
		
			this.manageActPortSkd		(event);					// Applying to Actual
			modifyVskActPortSkdEdiLog	(vskActPortSkdEdiLogVO);
		
		}catch(EventException ex){
			String rsltUserMsg = new ErrorHandler(ex).getUserMessage();
			manageActPortSkdByEDIErrMsg(vskActPortSkdEdiLogVO, rsltUserMsg);
			throw ex;
		}
	}
	
	/**
	 * Handling Exception in the process of Saving EDI Data in Actual
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
	 * Saving MQ Full Flat File
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
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
	 * Saving and Checking MQ Full Message<br>
	 * Saving EDI Message from terminal to DB[VSK_ACT_PORT_SKD_EDI_LOG]
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
	 * Saving MQ Full Message
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	private void modifyVskActPortSkdEdiLog(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO) throws EventException{
		try {
			begin();
			ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
			vskActPortSkdEdiLogVO.setScsFlg("Y");
			vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10058").getUserMessage());
			command.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO, null);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Setting Port SKD Status of EDI Data
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
	 * Retrieving Delay Information of Schedule per Lane/Port/Vessel
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
	 * Checking validation using common module of each code
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
		
		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Retrieving Lane Code
			
			MdmVslSvcLaneVO vo = new MdmVslSvcLaneVO();
			vo.setVslSlanCd(resultOnTimeRatioVO.getVslSlanCd());
			List<MdmVslSvcLaneVO> list = command.checkSvcLane(vo);
			if(list.size()>0){
				eventResponse.setETCData("vsl_slan_cd",  list.get(0).getVslSlanCd());
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Retrieving Vessel Code
			
			VesselVO vo = new VesselVO();
			vo.setVslCd(resultOnTimeRatioVO.getVslCd());
			List<VesselVO> list = command.searchVslList(vo);
			if(list.size()>0){
				eventResponse.setETCData("vsl_cd", list.get(0).getVslCd());
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // Retrieving Port Code
			
			String flag = command.checkPort(resultOnTimeRatioVO.getVpsPortCd());
			if(flag!=null && flag.length()>0){
				eventResponse.setETCData("vps_port_cd", flag);
			}
			
		} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // Retrieving Carrier Code
			
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
	 * Handling external interface<br>
	 * Handling WEBSERVICE<br>
	 * Retrieving VVD List by Calling Port (SPP).
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
	 * Retrieving VSK VESSEL SCHEDULE RESULT Information of VVD
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
			if("0".equals(resultVO.getExist())){ // Report Data exist
				eventResponse.setRsVoList(resultVO.getVskVslSkdRsltVOs());	
			}else if("1".equals(resultVO.getExist())){ // Retrieving Report Data using SKD
				eventResponse.setRsVoList(resultVO.getSkdResultVOs());
			}
			eventResponse.setETCData("vsl_slan_cd", resultVO.getVslSlanCd());
			eventResponse.setETCData("exist", resultVO.getExist());
			eventResponse.setETCData("dlay_rsn_cd", VSKGeneralUtil.comnCodeList("CD01830", "onlycode"));
			eventResponse.setETCData("dlay_rsn_nm", VSKGeneralUtil.comnCodeList("CD01830", "codeNname"));
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0028 : Delete
	 * Deleting VSK VESSEL SCHEDULE RESULT information of VVD
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
			command.removeRsltByVvd(onTimeRsltAnalVO);
			
			eventResponse.setETCData("vsl_slan_cd", "");
			eventResponse.setETCData("exist", "");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0028 : Save
	 * Saving VSK VESSEL SCHEDULE RESULT Information of VVD
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
			command.manageRsltByVvd(onTimeRsltAnalVO, account);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
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
			command.modifyRsltByVvd(onTimeRsltAnalVO, account);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		}		
		return eventResponse;
	}

	// :: VIPS START ::
	/**
	 * VskVslSkdVO를 VskVipsIfMstVO로 변환한다.
	 * @param List<VskVslSkdVO> vskVslSkdList
	 * @return List<VskVipsIfMstVO>
	 */
	private List<VskVipsIfMstVO> cnvtToIfMst(List<VskVslSkdVO> vskVslSkdList) {
		List<VskVipsIfMstVO> vskVipsIfMstList = new ArrayList<VskVipsIfMstVO>();
		for(int i=0;i<vskVslSkdList.size();i++) {
			VskVslSkdVO vo = (VskVslSkdVO) vskVslSkdList.get(i);
			VskVipsIfMstVO vskVipsIfMstVO = new VskVipsIfMstVO();
			vskVipsIfMstVO.setSkdDirCd(vo.getSkdDirCd());
			vskVipsIfMstVO.setSkdVoyNo(vo.getSkdVoyNo());
			vskVipsIfMstVO.setVslCd(vo.getVslCd());
			vskVipsIfMstVO.setVslSlanCd(vo.getVslSlanCd());
			vskVipsIfMstVO.setPfSvcTpCd(vo.getPfSkdTpCd());
			vskVipsIfMstList.add(vskVipsIfMstVO);
		}
		return vskVipsIfMstList;
	}
	
	/**
	 * VskActPortSkdVO,VskVslPortSkdVO를 VskVipsIfDtlVO로 변환한다.
	 * @param List<VslPortSkdVO> vslPortSkdList
	 * @return List<VskVipsIfDtlVO>
	 */
	private List<VskVipsIfDtlVO> cnvtToIfDtl(List<VskVslPortSkdVO> vslPortSkdList, List<VskActPortSkdVO> vskActPortSkdList){
		List<VskVipsIfDtlVO> vskVipsIfDtlList = new ArrayList<VskVipsIfDtlVO>();
		for(int i=0;i<vslPortSkdList.size();i++) {
			VskVslPortSkdVO vo = (VskVslPortSkdVO) vslPortSkdList.get(i);
			String vslPortKey = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd() 
				      + vo.getVpsPortCd() + vo.getClptIndSeq();
			VskVipsIfDtlVO vskVipsIfDtlVO = setIfDtl(vo);
			// actual정보 설정
			for(VskActPortSkdVO actVO : vskActPortSkdList) {
				String actKey = actVO.getVslCd() + actVO.getSkdVoyNo() + actVO.getSkdDirCd() 
						      + actVO.getVpsPortCd() + actVO.getClptIndSeq();
				if(vslPortKey.equals(actKey)) {
					vskVipsIfDtlVO.setVipsActArrDt(actVO.getActArrDt());
					vskVipsIfDtlVO.setVipsActBrthDt(actVO.getActBrthDt());
					vskVipsIfDtlVO.setVipsActDepDt(actVO.getActDepDt());
					break;
				}
			}
			
			vskVipsIfDtlList.add(vskVipsIfDtlVO);
		}
		return vskVipsIfDtlList;
	}

	private List<VskVslSkdIbisIfVO> cnvtToIfVskVslSkd(List<VskVslSkdVO> vslPortSkdList){
		List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs = new ArrayList<VskVslSkdIbisIfVO>();

		String sTmpUsrId	= "";
		if(account == null){
			sTmpUsrId		= "NO_ACCOUNT";
		}else{
			sTmpUsrId		= account.getUsr_id();
		}
		
		for(int i = 0 ; i < vslPortSkdList.size() ;i++) {
			VskVslSkdVO vskVslSkdVO = (VskVslSkdVO) vslPortSkdList.get(i);
			VskVslSkdIbisIfVO vskVslSkdIbisIfVO = new VskVslSkdIbisIfVO();
			
			vskVslSkdIbisIfVO.setVslCd	        (vskVslSkdVO.getVslCd());
			vskVslSkdIbisIfVO.setSkdVoyNo	    (vskVslSkdVO.getSkdVoyNo());
			vskVslSkdIbisIfVO.setSkdDirCd	    (vskVslSkdVO.getSkdDirCd());
			vskVslSkdIbisIfVO.setVslSlanCd	    (vskVslSkdVO.getVslSlanCd());
			vskVslSkdIbisIfVO.setSkdStsCd	    (vskVslSkdVO.getSkdStsCd());
			vskVslSkdIbisIfVO.setSkdStsMnlFlg	(vskVslSkdVO.getSkdStsMnlFlg());
			vskVslSkdIbisIfVO.setSkdVoyTpCd	    (vskVslSkdVO.getSkdVoyTpCd());
			vskVslSkdIbisIfVO.setPfSkdTpCd	    (vskVslSkdVO.getPfSkdTpCd());
			vskVslSkdIbisIfVO.setStPortCd	    (vskVslSkdVO.getStPortCd());
			vskVslSkdIbisIfVO.setN1stPortBrthDt (vskVslSkdVO.getN1stPortBrthDt());
			vskVslSkdIbisIfVO.setActCrrCd	    (vskVslSkdVO.getActCrrCd());
			vskVslSkdIbisIfVO.setSkdRmk	        (vskVslSkdVO.getSkdRmk());
			vskVslSkdIbisIfVO.setCreUsrId	    (sTmpUsrId);
			vskVslSkdIbisIfVO.setCreDt	        (vskVslSkdVO.getCreDt());
			vskVslSkdIbisIfVO.setUpdUsrId	    (sTmpUsrId);
			vskVslSkdIbisIfVO.setUpdDt	        (vskVslSkdVO.getUpdDt());
			vskVslSkdIbisIfVO.setIbflag		    (vskVslSkdVO.getIbflag());
			vskVslSkdIbisIfVOs.add(vskVslSkdIbisIfVO);
		}
		
		return vskVslSkdIbisIfVOs;
	}
	
	/*
	private List<VskVslPortSkdIbisIfVO> cnvtToIfVskVslPortSkd(List<VskVslPortSkdVO> vslPortSkdList){
		List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs = new ArrayList<VskVslPortSkdIbisIfVO>();
		
	    String sTmpUsrId  = "";
	    if(account == null){
	      sTmpUsrId    = "NO_ACCOUNT";
	    }else{
	      sTmpUsrId    = account.getUsr_id();
	    }
		
		for(int i = 0 ; i < vslPortSkdList.size() ;i++) {
			VskVslPortSkdIbisIfVO vskVslPortSkdIbisIfVO = new VskVslPortSkdIbisIfVO();
			VskVslPortSkdVO vskVslPortSkdVO = vslPortSkdList.get(i);
			
			vskVslPortSkdIbisIfVO.setVslCd	            (vskVslPortSkdVO.getVslCd());
			vskVslPortSkdIbisIfVO.setSkdVoyNo	        (vskVslPortSkdVO.getSkdVoyNo());
			vskVslPortSkdIbisIfVO.setSkdDirCd	        (vskVslPortSkdVO.getSkdDirCd());
			vskVslPortSkdIbisIfVO.setVpsPortCd	        (vskVslPortSkdVO.getVpsPortCd());
			vskVslPortSkdIbisIfVO.setClptIndSeq	        (vskVslPortSkdVO.getClptIndSeq());
			vskVslPortSkdIbisIfVO.setClptSeq	        (vskVslPortSkdVO.getClptSeq());
			vskVslPortSkdIbisIfVO.setPortSkdStsCd	    (vskVslPortSkdVO.getPortSkdStsCd());
			vskVslPortSkdIbisIfVO.setYdCd	            (vskVslPortSkdVO.getYdCd());
			vskVslPortSkdIbisIfVO.setSlanCd	            (vskVslPortSkdVO.getSlanCd());
			vskVslPortSkdIbisIfVO.setCallYdIndSeq	    (vskVslPortSkdVO.getCallYdIndSeq());
			vskVslPortSkdIbisIfVO.setSkdCngStsCd	    (vskVslPortSkdVO.getSkdCngStsCd());
			vskVslPortSkdIbisIfVO.setPfEtaDt	        (vskVslPortSkdVO.getPfEtaDt());
			vskVslPortSkdIbisIfVO.setPfEtbDt	        (vskVslPortSkdVO.getPfEtbDt());
			vskVslPortSkdIbisIfVO.setPfEtdDt	        (vskVslPortSkdVO.getPfEtdDt());
			vskVslPortSkdIbisIfVO.setInitEtaDt	        (vskVslPortSkdVO.getInitEtaDt());
			vskVslPortSkdIbisIfVO.setInitEtbDt	        (vskVslPortSkdVO.getInitEtbDt());
			vskVslPortSkdIbisIfVO.setInitEtdDt	        (vskVslPortSkdVO.getInitEtdDt());
			vskVslPortSkdIbisIfVO.setVpsEtaDt	        (vskVslPortSkdVO.getVpsEtaDt());
			vskVslPortSkdIbisIfVO.setVpsEtbDt	        (vskVslPortSkdVO.getVpsEtbDt());
			vskVslPortSkdIbisIfVO.setVpsEtdDt	        (vskVslPortSkdVO.getVpsEtdDt());
			vskVslPortSkdIbisIfVO.setTurnPortFlg	    (vskVslPortSkdVO.getTurnPortFlg());
			vskVslPortSkdIbisIfVO.setTurnPortIndCd	    (vskVslPortSkdVO.getTurnPortIndCd());
			vskVslPortSkdIbisIfVO.setTurnSkdVoyNo	    (vskVslPortSkdVO.getTurnSkdVoyNo());
			vskVslPortSkdIbisIfVO.setTurnSkdDirCd	    (vskVslPortSkdVO.getTurnSkdDirCd());
			vskVslPortSkdIbisIfVO.setTurnClptIndSeq	    (vskVslPortSkdVO.getTurnClptIndSeq());
			vskVslPortSkdIbisIfVO.setLnkDist	        (vskVslPortSkdVO.getLnkDist());
			vskVslPortSkdIbisIfVO.setLnkSpd	            (vskVslPortSkdVO.getLnkSpd());
			vskVslPortSkdIbisIfVO.setTztmHrs	        (vskVslPortSkdVO.getTztmHrs());
			vskVslPortSkdIbisIfVO.setSeaBufHrs	        (vskVslPortSkdVO.getSeaBufHrs());
			vskVslPortSkdIbisIfVO.setMnvrInHrs	        (vskVslPortSkdVO.getMnvrInHrs());
			vskVslPortSkdIbisIfVO.setMnvrOutHrs	        (vskVslPortSkdVO.getMnvrOutHrs());
			vskVslPortSkdIbisIfVO.setPortWrkHrs	        (vskVslPortSkdVO.getPortWrkHrs());
			vskVslPortSkdIbisIfVO.setPortBufHrs	        (vskVslPortSkdVO.getPortBufHrs());
			vskVslPortSkdIbisIfVO.setVslDlayRsnCd	    (vskVslPortSkdVO.getVslDlayRsnCd());
			vskVslPortSkdIbisIfVO.setVslDlayRsnDesc	    (vskVslPortSkdVO.getVslDlayRsnDesc());
			vskVslPortSkdIbisIfVO.setVslDlayRsnLocCd	(vskVslPortSkdVO.getVslDlayRsnLocCd());
			vskVslPortSkdIbisIfVO.setIbCgoQty	        (vskVslPortSkdVO.getIbCgoQty());
			vskVslPortSkdIbisIfVO.setObCgoQty	        (vskVslPortSkdVO.getObCgoQty());
			vskVslPortSkdIbisIfVO.setVpsRmk	            (vskVslPortSkdVO.getVpsRmk());
			vskVslPortSkdIbisIfVO.setPhsIoRsnCd	        (vskVslPortSkdVO.getPhsIoRsnCd());
			vskVslPortSkdIbisIfVO.setPhsIoRmk	        (vskVslPortSkdVO.getPhsIoRmk());
			vskVslPortSkdIbisIfVO.setSkdBrthNo	        (vskVslPortSkdVO.getSkdBrthNo());
			vskVslPortSkdIbisIfVO.setInitSkdInpFlg	    (vskVslPortSkdVO.getInitSkdInpFlg());
			vskVslPortSkdIbisIfVO.setOfcInpFlg	        (vskVslPortSkdVO.getOfcInpFlg());
			vskVslPortSkdIbisIfVO.setNoonRptInpFlg	    (vskVslPortSkdVO.getNoonRptInpFlg());
			vskVslPortSkdIbisIfVO.setDepRptInpFlg	    (vskVslPortSkdVO.getDepRptInpFlg());
			vskVslPortSkdIbisIfVO.setActInpFlg	        (vskVslPortSkdVO.getActInpFlg());
			vskVslPortSkdIbisIfVO.setPrtChkFlg	        (vskVslPortSkdVO.getPrtChkFlg());
			vskVslPortSkdIbisIfVO.setShpCallNo	        (vskVslPortSkdVO.getShpCallNo());
			vskVslPortSkdIbisIfVO.setShpCallNoUpdUsrId	(vskVslPortSkdVO.getShpCallNoUpdUsrId());
			vskVslPortSkdIbisIfVO.setShpCallNoUpdDt	    (vskVslPortSkdVO.getShpCallNoUpdDt());
			vskVslPortSkdIbisIfVO.setTmlVslCd	        (vskVslPortSkdVO.getTmlVslCd());
			vskVslPortSkdIbisIfVO.setTmlVoyNo	        (vskVslPortSkdVO.getTmlVoyNo());
			vskVslPortSkdIbisIfVO.setFtDt	            (vskVslPortSkdVO.getFtDt());
			vskVslPortSkdIbisIfVO.setSkdAutoUpdFlg	    (vskVslPortSkdVO.getSkdAutoUpdFlg());
			vskVslPortSkdIbisIfVO.setPortSkpTpCd	    (vskVslPortSkdVO.getPortSkpTpCd());
			vskVslPortSkdIbisIfVO.setPortSkpRsnCd	    (vskVslPortSkdVO.getPortSkpRsnCd());
			vskVslPortSkdIbisIfVO.setPortSkpRsnOffrRmk	(vskVslPortSkdVO.getPortSkpRsnOffrRmk());
			vskVslPortSkdIbisIfVO.setTtlDlayHrs	        (vskVslPortSkdVO.getTtlDlayHrs());
			vskVslPortSkdIbisIfVO.setTsPortCd	        (vskVslPortSkdVO.getTsPortCd());
			vskVslPortSkdIbisIfVO.setUsdFlg	            (vskVslPortSkdVO.getUsdFlg());
			vskVslPortSkdIbisIfVO.setAutoSkdCngFlg	    (vskVslPortSkdVO.getAutoSkdCngFlg());
			vskVslPortSkdIbisIfVO.setCreUsrId	        (sTmpUsrId);
			vskVslPortSkdIbisIfVO.setCreDt	            (vskVslPortSkdVO.getCreDt());
			vskVslPortSkdIbisIfVO.setUpdUsrId	        (sTmpUsrId);
			vskVslPortSkdIbisIfVO.setUpdDt	            (vskVslPortSkdVO.getUpdDt());
			vskVslPortSkdIbisIfVO.setIbflag		    	(vskVslPortSkdVO.getIbflag());
			vskVslPortSkdIbisIfVOs.add(vskVslPortSkdIbisIfVO);
		}
		
		return vskVslPortSkdIbisIfVOs;
	}
	*/
	
	/**
	 * setIfDtl : VskVipsIfDtlVO common setting
	 * @param VskVslPortSkdVO vo
	 * @return VskVipsIfDtlVO
	 */
	private VskVipsIfDtlVO setIfDtl(VskVslPortSkdVO vo) {
		VskVipsIfDtlVO vskVipsIfDtlVO = new VskVipsIfDtlVO();
		vskVipsIfDtlVO.setVipsIbConsortiumVoyNo(vo.getIbCssmVoyNo());
		vskVipsIfDtlVO.setVipsObConsortiumVoyNo(vo.getObCssmVoyNo());
		vskVipsIfDtlVO.setVipsVpsEtaDt(vo.getVpsEtaDt());
		vskVipsIfDtlVO.setVipsVpsEtbDt(vo.getVpsEtbDt());
		vskVipsIfDtlVO.setVipsVpsEtdDt(vo.getVpsEtdDt());
		vskVipsIfDtlVO.setVslCd(vo.getVslCd());
		vskVipsIfDtlVO.setSkdVoyNo(vo.getSkdVoyNo());
		vskVipsIfDtlVO.setSkdDirCd(vo.getSkdDirCd());
		vskVipsIfDtlVO.setVpsPortCd(vo.getVpsPortCd());
		vskVipsIfDtlVO.setClptIndSeq(vo.getClptIndSeq());
		vskVipsIfDtlVO.setClptSeq(vo.getClptSeq());
		vskVipsIfDtlVO.setPortSkdStsCd(vo.getPortSkdStsCd());
		vskVipsIfDtlVO.setYdCd(vo.getYdCd());
		vskVipsIfDtlVO.setCallYdIndSeq(vo.getCallYdIndSeq());
		vskVipsIfDtlVO.setSkdCngStsCd(vo.getSkdCngStsCd());
		vskVipsIfDtlVO.setPfEtaDt(vo.getPfEtaDt());
		vskVipsIfDtlVO.setPfEtbDt(vo.getPfEtbDt());
		vskVipsIfDtlVO.setPfEtdDt(vo.getPfEtdDt());
		vskVipsIfDtlVO.setInitEtaDt(vo.getInitEtaDt());
		vskVipsIfDtlVO.setInitEtbDt(vo.getInitEtbDt());
		vskVipsIfDtlVO.setInitEtdDt(vo.getInitEtdDt());
		vskVipsIfDtlVO.setTurnPortFlg(vo.getTurnPortFlg());
		vskVipsIfDtlVO.setTurnPortIndCd(vo.getTurnPortIndCd());
		vskVipsIfDtlVO.setTurnSkdVoyNo(vo.getTurnSkdVoyNo());
		vskVipsIfDtlVO.setTurnSkdDirCd(vo.getTurnSkdDirCd());
		vskVipsIfDtlVO.setTurnClptIndSeq(vo.getTurnClptIndSeq());
		vskVipsIfDtlVO.setSkdUpdUsrId(vo.getUpdUsrId());
		vskVipsIfDtlVO.setSkdUpdDt(vo.getUpdDt());
		vskVipsIfDtlVO.setAddCallFlg(vo.getAddCallFlg());
		vskVipsIfDtlVO.setVtAddCallFlg(vo.getVtAddCallFlg());
		return vskVipsIfDtlVO;
	}
	
	/**
	 * makePortToVsl:port정보로 Vessel정보를 작성한다.
	 * @param List<VskVslSkdVO> vslSkdList
	 * @param List<VskActPortSkdVO> vslActPortSkdList
	 * @return List<VskVslSkdVO>
	 * @throws Exception
	 */
	private List<VskVslSkdVO> makeActPortToVsl(List<VskVslSkdVO> vslSkdList, List<VskActPortSkdVO> vslActPortSkdList) throws Exception {
		List<VskVslSkdVO> vskVslSkdList = new ArrayList<VskVslSkdVO>();
		List<String> vvds = new ArrayList<String>();
		for(VskVslSkdVO vo : vslSkdList) {
			// duplication check(vessel info)
			String vvd = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();
			if(!vvds.contains(vvd)) {
				vskVslSkdList.add(vo);
				vvds.add(vvd);
			}
		}
		// vsl정보가 없는 port의 경우 port로 vsl정보를 만든다.
		for(VskActPortSkdVO vo : vslActPortSkdList) {
			// duplication check(vessel info)
			String vvd = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();
			if(!vvds.contains(vvd)) {
				VskVslSkdVO vsl = new VskVslSkdVO();
				vsl.setVslCd(vo.getVslCd());
				vsl.setSkdVoyNo(vo.getSkdVoyNo());
				vsl.setSkdDirCd(vo.getSkdDirCd());
				vskVslSkdList.add(vsl);
				vvds.add(vvd);
			}
		}
		return vskVslSkdList;
	}

	/**
	 * makePortToVsl:port정보로 Vessel정보를 작성한다.
	 * @param List<VskVslSkdVO> vslSkdList
	 * @param List<VskVslPortSkdVO> vslPortSkdList
	 * @return List<VskVslSkdVO>
	 * @throws Exception
	 */
	private List<VskVslSkdVO> makePortToVsl(List<VskVslSkdVO> vslSkdList, List<VskVslPortSkdVO> vslPortSkdList) throws Exception {
		List<VskVslSkdVO> vskVslSkdList = new ArrayList<VskVslSkdVO>();
		List<String> vvds = new ArrayList<String>();
		for(VskVslSkdVO vo : vslSkdList) {
			// duplication check(vessel info)
			String vvd = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();
			if(!vvds.contains(vvd)) {
				vskVslSkdList.add(vo);
				vvds.add(vvd);
			}
		}
		// vsl정보가 없는 port의 경우 port로 vsl정보를 만든다.
		for(VskVslPortSkdVO vo : vslPortSkdList) {
			// duplication check(vessel info)
			String vvd = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd();
			if(!vvds.contains(vvd)) {
				VskVslSkdVO vsl = new VskVslSkdVO();
				vsl.setVslCd(vo.getVslCd());
				vsl.setSkdVoyNo(vo.getSkdVoyNo());
				vsl.setSkdDirCd(vo.getSkdDirCd());
				vsl.setVslSlanCd(vo.getSlanCd());
				vskVslSkdList.add(vsl);
				vvds.add(vvd);
			}
		}
		return vskVslSkdList;
	}
	/**
	 * mergeVslPortSkdList : 두개의 PortList에서 중복을 제거하야 하나의 PortList로 만든다.
	 * @param List<VskVslPortSkdVO> vslPortSkdList1
	 * @param List<VskVslPortSkdVO> vslPortSkdList2
	 * @return List<VskVslPortSkdVO>
	 */
	private List<VskVslPortSkdVO> mergeVslPortSkdList(List<VskVslPortSkdVO> vslPortSkdList1, List<VskVslPortSkdVO> vslPortSkdList2) {
		List<VskVslPortSkdVO> portSkdList = new ArrayList<VskVslPortSkdVO>();
		Map<String, String> keys = new HashMap<String, String>(); // vvd, update_date
		for(VskVslPortSkdVO vo : vslPortSkdList1) {
			String key = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd() + vo.getVpsPortCd() + vo.getClptIndSeq();
			if(!keys.containsKey(key)) { // 1st add
				portSkdList.add(vo);
				keys.put(key, vo.getUpdDt());
			} else {
				int vvdUpdateDt = 0;
				int currUpdateDt = 0;
				if(keys.get(key) != null && !"".equals(keys.get(key))) {
					vvdUpdateDt = Integer.parseInt(keys.get(key));
				}
				if(vo.getUpdDt() != null && !"".equals(vo.getUpdDt())) {
					currUpdateDt = Integer.parseInt(vo.getUpdDt());
				}
				if(vvdUpdateDt < currUpdateDt) { // 현재 읽는 데이타가 최신의 경우, 덮어쓴다.
					for(int index=0;index< portSkdList.size();index++) {
						VskVslPortSkdVO listVO = portSkdList.get(index);
						String listVvd = listVO.getVslCd() + listVO.getSkdVoyNo() + listVO.getSkdDirCd();
						if(listVvd.equals(key)) {
							portSkdList.remove(index);
							break;
						}
					}
					portSkdList.add(vo);
					keys.put(key, vo.getUpdDt());
				}
			}
		}
		return portSkdList;
	}
	// :: VIPS END ::
}
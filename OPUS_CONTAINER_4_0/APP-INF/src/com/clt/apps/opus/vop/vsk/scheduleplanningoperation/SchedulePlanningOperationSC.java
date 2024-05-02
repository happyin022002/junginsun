/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SchedulePlanningOperationSC.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBC;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic.BudgetPortChargeMgtBCImpl;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBC;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.basic.ActualScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdHisVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic.ProformaScheduleMgtBC;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.basic.ProformaScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0001Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0003Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0004Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0053Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0220Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0238Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0241Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0243Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0248Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration.ProformaScheduleMgtDBDAO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.CoaSimRsltVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdBerthWdoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpDtlVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdEotpSumVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdHisGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdTypeHelpVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.PfSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdDtlVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.CoastalScheduleMgtBC;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.LongRangeScheduleMgtBC;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.basic.VesselScheduleMgtBCImpl;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0010Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0012Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0014Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0015Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0017Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0018Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0019Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0020Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0021Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0024Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0054Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0057Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0058Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0059Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0065Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0211Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0215Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0229Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0245Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0246Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0247Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0249Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0250Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskESD0610001Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskESD0620001Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskSPPVSK0004Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVskSPPVSK0005Event;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.BkgListByVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalBnkSavVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CanalTransitTargetVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdBerthWdoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPolPodVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByPortVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdByVvdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PfSkdDetailVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SimulationVvdCheckVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SkipPortGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisGroupVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdXtraHisVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdBkgStsVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBC;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.basic.VesselScheduleMasterDataBCImpl;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CanelRegistGRPVO;
import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.UserLaneGroupVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedforrevenuevvd.basic.InterfaceScheduleForRevenueVVDBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedforrevenuevvd.basic.InterfaceScheduleForRevenueVVDBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic.InterfaceScheduleToExternalBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic.InterfaceScheduleToExternalBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.CSSMVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic.InterfaceScheduleToIBISBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.basic.InterfaceScheduleToIBISBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdDtlIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslPortSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.apps.opus.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskActPortSkdVO;
import com.clt.syscommon.common.table.VskDepRptVO;
import com.clt.syscommon.common.table.VskNoonRptVO;
import com.clt.syscommon.common.table.VskPfSkdVO;
import com.clt.syscommon.common.table.VskPortDistVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdHisVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.basic.InterfaceScheduleToExternalScnBC;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.basic.InterfaceScheduleToExternalScnBCImpl;

/**
 * SchedulePlanningOperation Business Logic ServiceCommand - Handling Business Transaction about SchedulePlanningOperation
 * 
 * @author
 * @see ProformaScheduleMgtDBDAO
 * @since J2EE 1.4
 */

public class SchedulePlanningOperationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
 
	/**
	 * SchedulePlanningOperation system preceding process for biz scenario<br>
	 * UI_VSK-0241 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {log.error(e.getMessage());}
	}

	/**
	 * SchedulePlanningOperation system biz scenario closing<br>
	 * UI_VSK-0241 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("SchedulePlanningOperationSC END");
	}

	/**
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("VopVsk0241Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfTpHelp(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = checkSvcLane(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopVsk0018Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslSkdListByLane(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchSvcLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = removeCstSkdByVvd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				// Manual Close/Open
				eventResponse = manageVslSkdListByLane(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				// Manage P/F
				eventResponse = manageVvdPf(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				// SKD Activate
				eventResponse = manageSkdActivate(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				// Checking crr_cd
				eventResponse = searchCrrCd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0220Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {		// Retrieving P/F SKD by LANE CODE
				eventResponse = searchPfSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	// Retrieving Vessel by VSL CODE
				eventResponse = searchVslList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	// Simulation - Long Range SKD for Feeder Service Lane
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {	// Simulation - Long Range SKD for Trunk Service Lane
				eventResponse = simulateLongRngSkd(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	// Phase In
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	// Phase In Cancel
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {	// Add Calling
				eventResponse = simulateLongRngSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {	// Add Calling Cancel
				eventResponse = simulateLongRngSkd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){ // Save
				eventResponse = createLongRngSkd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0245Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCallingPortList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVslCntr(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPfLaneTypeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstSkdByPfSkdUse(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDirectionList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkSvcLaneDir(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = checkVskVslPortSkdEtd(e);	
			
			/** For checking Vessel Port Schedule Date Reverse or not **/
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = isReverseVesselPortSchedule(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstSkdByRmk(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPfLaneTypeList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstSkdByPfSkdUse(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDirectionList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkSvcLaneDir(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = checkVskVslPortSkdEtd(e);
				
			/** For checking Vessel Port Schedule Date Reverse or not **/
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = isReverseVesselPortSchedule(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstSkdByRmk(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = checkPortRotnSeq(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0248Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdHis(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0238Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdBerthWdo(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopVsk0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = checkBkgStsByVvd(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("VopVsk0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSim(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVskPortDist(e);		// skip cancel, add cancel, reverse call
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstSkdSimBaseInfo(e);	// port change
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBunkerQtyBySpeed(e);	// speed change
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchYardList(e);			// yard change
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchAddCallInfo(e);		// add call
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchDirectionList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)) {		//:PHASE OUT for C/SKD Update screen:/ 
				eventResponse = searchCstSkdByPfSkdSim(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH09)) {		//:PHASE OUT for C/SKD Simulation screen:/ 
				eventResponse = searchCstSkdByPfSkdSim(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchSkipCallInfo(e);		// skip call
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchYardChageByAddCall(e);		// yard change(of add call)
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = checkVskVslPortSkdEtd(e);
				
			/** For checking Vessel Port Schedule Date Reverse or not **/
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = isReverseVesselPortSchedule(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstSkdSim(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageSettleByVvd(e);
			} 
			
		}else if(e.getEventName().equalsIgnoreCase("VopVsk0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSim(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchDirectionList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkVslCntr(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = checkVskVslPortSkdEtd(e);
				
			/** For checking Vessel Port Schedule Date Reverse or not **/
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = isReverseVesselPortSchedule(e);				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdBerthWdo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDirectionList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUserLaneGroup(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdBerthWdo(e);
			}
//			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
//				eventResponse = sendEdiToKlNet(e);
//			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0249Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSvcLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkVvd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPortList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = removeCstSkdByVvd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0250Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 
				eventResponse = searchCstSkdByVvdPort(e);
			}
//VOP_VSK_0001 ADD 2013-09-24 BY HWANG
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
			} /*else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = createCoaSimRqst(e);
			} */else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = calRowDelete(e);
			}
		
		}else if(e.getEventName().equalsIgnoreCase("VopVsk0003Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdInclFinalVirPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				//eventResponse = searchYardListByPort(e);
				eventResponse = searchPortInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				//eventResponse = searchYardListByPort(e);
				eventResponse = searchYardList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchYardListByPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = calPfSkdManual(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = calPfSkdAuto(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createRqstSimScnrCfm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removePfSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = calRowDelete(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByPolPod(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByPort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkVslCntr(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0065Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCstSkdHisByVvd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchActSkdHisByVvd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVslCntr(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdInclFinalVirPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchYardListByPort(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSvcLaneDirList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = calPfSkdManual(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createRqstSimScnrCfm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removePfSkd(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0247Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = calLoadableWgt(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBayPlanInputPort(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdInclFinalVirPortList(e);
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSvcLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVslList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLongRngSkd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVslSlanCdListByVessel(e);				
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){ // Save
				eventResponse = createLongRngSkd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				try{
					eventResponse = searchPfSkd(e);
				}catch(EventException ex){
					throw new EventException(new ErrorHandler("VSK10023").getMessage());
				}
			}
			
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0229Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListByVvd(e);
			}
			
		}else if(e.getEventName().equalsIgnoreCase("VopVsk0059Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVslSkdListByLane(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchSvcLaneList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = removeCstSkdByVvd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				// Manual Close
				eventResponse = manageVslSkdListByLane(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				// SKD Activate
				eventResponse = manageSkdActivate(e);
			}
//		}else if (e.getEventName().equalsIgnoreCase("VopVsk0066Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchSlotPrice(e);
//			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
//				eventResponse = calSlotPrice(e);
//			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
//				eventResponse = manageSlotPrice(e);
//			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
//				eventResponse = searchYardListByPort(e);
//			}
		}else if (e.getEventName().equalsIgnoreCase("VopVskESD0610001Event")) {	//JMS ESD0610001
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createNoonReport(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("VopVskESD0620001Event")) {	//JMS ESD0620001
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createDepartureReport(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("VopVsk0243Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPfSkdEotpSum(e);
			}if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPfSkdEotpDtl(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCanalTzList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchVendorList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = createCanalTzList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVsk0246Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = calCanalBunkerSaving(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstSkdByVvd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("VopVskSPPVSK0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstSkdByVvd(e);
			}
	    }else if (e.getEventName().equalsIgnoreCase("VopVsk0215Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPortList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardListByPort(e);
			}
	    }
		return eventResponse;
	}
	/**
	 * VOP_VSK_0241 : Retrieve
	 * 
	 * Retrieving Proforma Type
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
	 * Retrieving Vessel Schedule by Lane or Vessel 
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	private EventResponse searchVslSkdListByLane(Event e) throws EventException {
		ActivationVvdVO vo = null;
		if(e instanceof VopVsk0018Event){
			VopVsk0018Event event = (VopVsk0018Event)e;
			vo = event.getActivationVvdVO();
		}else if(e instanceof VopVsk0059Event){
			VopVsk0059Event event = (VopVsk0059Event)e;
			vo = event.getActivationVvdVO();
		} else {
			vo = new ActivationVvdVO();
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
	 * Deleting selected Vessel Schedule
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCstSkdByVvd(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse 				eventResponse 		= new GeneralEventResponse();
		CoastalScheduleMgtBC 				costalCommand 		= new VesselScheduleMgtBCImpl();
		ActualScheduleMgtBC 				actCommand 			= new ActualScheduleMgtBCImpl();
		GeneralBookingSplitCombineBC 		bkgCommand 			= new GeneralBookingSplitCombineBCImpl();
		InterfaceScheduleForRevenueVVDBC 	revenueCommand		= new InterfaceScheduleForRevenueVVDBCImpl();
		
		String 								sFromEventSystem	= "";
		
		List<VskVslSkdVO>					scnVskVslSkdVOs	= new ArrayList<VskVslSkdVO>();
		
		try{
			
			begin();
			
			if(e instanceof VopVsk0018Event || e instanceof VopVsk0059Event){
				
				ActivationVvdVO[] srcVOs = null;
				if(e instanceof VopVsk0018Event){
					VopVsk0018Event event = (VopVsk0018Event)e;
					srcVOs = event.getActivationVvdVOS();
					
					sFromEventSystem		= "DELETE_CST_DeletionVvd_OnNoneBKG(VOP_VSK_0018)";
					
				}else if(e instanceof VopVsk0059Event){
					VopVsk0059Event event = (VopVsk0059Event)e;
					srcVOs = event.getActivationVvdVOS();
					
					sFromEventSystem		= "DELETE_CST_Feeder_DeletionVvd_OnNoneBKG(VOP_VSK_0059)";
				}
				
				StringBuffer laneData 		= new StringBuffer();
				StringBuffer vvdData 		= new StringBuffer();
				StringBuffer hisData 		= new StringBuffer();
				StringBuffer turnVoyData 	= new StringBuffer();
				StringBuffer turnDirData 	= new StringBuffer();
				
				if(srcVOs != null) {
					
					for(int i=0; i<srcVOs.length; i++){
						
						if("BKG".equals(srcVOs[i].getSkdStsCd()) && srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
							hisData.append("ALL|");	// in case Creating History to VVD and Virtual Port
						}else if("BKG".equals(srcVOs[i].getSkdStsCd())){
							hisData.append("VVD|");	// in case Creating History to VVD
						}else if(srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
							hisData.append("VIR|");	// in case Creating History to Virtual Port
						}
	
						// Setting Data to Transmit VOP_VSK_0249
						if("BKG".equals(srcVOs[i].getSkdStsCd()) || srcVOs[i].getVirSkdStsCd().startsWith("BKG")){
							vvdData.append(srcVOs[i].getVslCd() + srcVOs[i].getSkdVoyNo() + srcVOs[i].getSkdDirCd());
							vvdData.append("|");
							laneData.append(srcVOs[i].getVslSlanCd() + "|");
							
							turnVoyData.append(srcVOs[i].getTurnSkdVoyNo() + "|");
							turnDirData.append(srcVOs[i].getTurnSkdDirCd() + "|");
							
							// Existing Booking VVD can delete only by VOP_VSK_0249, then handling it to null
							srcVOs[i] = null;
						}
						
					}
				}
				
				List<VvdVO> vvdVOs 		= new ArrayList<VvdVO>();
				List<VvdVO> turnVvdVOs 	= new ArrayList<VvdVO>();
				
				if(srcVOs != null){
					
					VvdVO 				vo 		= new VvdVO();
					
					List<String>    tmpStrList	= new ArrayList<String>();
					
					for(int i=0; i<srcVOs.length; i++){

						// Existing Booking VVD can be deleted only by VOP_VSK_0249, then handling it to null
						if(srcVOs[i] == null) continue;
						
						vo.setVslSlanCd		(srcVOs[i].getVslSlanCd	());
						vo.setVslCd			(srcVOs[i].getVslCd		());
						vo.setSkdVoyNo		(srcVOs[i].getSkdVoyNo	());
						vo.setSkdDirCd		(srcVOs[i].getSkdDirCd	());
						vo.setStatusflag	("Y");
						vvdVOs.add			(vo);
						
						
						/********************************************************************************
						 * Add new functionality interfaced to SCN(NYK Legacy System related with EDI)
						 * 2016-10-07
						 * 
						 ********************************************************************************/
				        String     sTmpStr	= srcVOs[i].getVslCd()+srcVOs[i].getSkdVoyNo()+srcVOs[i].getSkdDirCd();
				        VskVslSkdVO  tmpVO  = new VskVslSkdVO();
				        
				        tmpVO.setVslCd    	(srcVOs[i].getVslCd		());
						tmpVO.setSkdVoyNo	(srcVOs[i].getSkdVoyNo	());
						tmpVO.setSkdDirCd	(srcVOs[i].getSkdDirCd	());
						
						if(tmpVO != null && !tmpStrList.contains(sTmpStr))	scnVskVslSkdVOs.add(tmpVO);
						
						tmpStrList.add		(sTmpStr);
						/********************************************************************************/
						
						
						// in case existing Turn Info 
						if(srcVOs[i].getTurnSkdDirCd()!=null && srcVOs[i].getTurnSkdDirCd().length()!=0){
							VvdVO turnVo = new VvdVO();
							turnVo.setVslSlanCd	(srcVOs[i].getVslSlanCd		());
							turnVo.setVslCd		(srcVOs[i].getVslCd			());
							turnVo.setSkdVoyNo	(srcVOs[i].getTurnSkdVoyNo	());
							turnVo.setSkdDirCd	(srcVOs[i].getTurnSkdDirCd	());
							turnVvdVOs.add		(turnVo);
						}
						
						ActivationVvdVO[] activationVvdVOs 	= new ActivationVvdVO[1];
						activationVvdVOs[0] 				= srcVOs[i];

						actCommand.removeVskActPortSkd(vvdVOs);
						
						//::by TOP:2015-05-08:://
						/** �댄빆�ㅼ�伊�History 愿�━��VO Getting **/
						//::by TOP:2015-05-08:://costalCommand.removeCstSkdByVvd(activationVvdVOs, null, null, account);			//original
						//::by TOP:2015-05-08:://costalCommand.removeCstSkdByVvd(srcVOs, null, null, account, sFromEventSystem);
						costalCommand.removeCstSkdByVvd(activationVvdVOs, null, null, account, sFromEventSystem);
						//::by TOP:2015-05-08:://
						
						List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = costalCommand.searchBkgBdrLog(vvdVOs);
						this.sendBkgVvdBdrLog(bkgVvdBdrLogVOs);
						
						
						commit();
						//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://
						begin();
						revenueCommand.interfaceScheduleForRevenueVVD(vvdVOs);
						
						
						vvdVOs.clear();
						
						if (i % 10 == 0 && i != 0) { // 10 
							commit();
							begin();
						}
						
					}
				}
				
				eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());
				eventResponse.setETCData("lane", laneData.toString());
				eventResponse.setETCData("vvd", vvdData.toString());	
				eventResponse.setETCData("his", hisData.toString());
				
				eventResponse.setETCData("turn_voy", turnVoyData.toString());
				eventResponse.setETCData("turn_dir", turnDirData.toString());
			
			}else if(e instanceof VopVsk0249Event) {
				
				sFromEventSystem			= "DELETE_CST_DeletionVvd_NormalVvdOnlyOnBKG(VOP_VSK_0249)";
				
				VopVsk0249Event event 		= (VopVsk0249Event)e;
				ActivationVvdVO[] nonBkgVOs = event.getActivationVvdVO1S();
				ActivationVvdVO[] bkgVOs    = event.getActivationVvdVO2S();
				VskVslSkdHisVO hisVO        = event.getVskVslSkdHisVO();
				
				List<VvdVO> vvdVOs 			= new ArrayList<VvdVO>();
				List<VvdVO> turnVvdVOs 		= new ArrayList<VvdVO>();
				List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = new ArrayList<VslSkdCngNoticeVO>();
				
				if(nonBkgVOs!=null){
					for(ActivationVvdVO activationVvdVO : nonBkgVOs){
						VvdVO vo = new VvdVO();
						vo.setVslSlanCd(activationVvdVO.getVslSlanCd());
						vo.setVslCd(activationVvdVO.getVslCd());
						vo.setSkdVoyNo(activationVvdVO.getSkdVoyNo());
						vo.setSkdDirCd(activationVvdVO.getSkdDirCd());
						vvdVOs.add(vo);
					}
				}
				
				if(bkgVOs!=null){
					
					for(ActivationVvdVO activationVvdVO : bkgVOs){
						VvdVO vo 			= new VvdVO();
						vo.setVslSlanCd		(activationVvdVO.getVslSlanCd	());
						vo.setVslCd			(activationVvdVO.getVslCd		());
						vo.setSkdVoyNo		(activationVvdVO.getSkdVoyNo	());
						vo.setSkdDirCd		(activationVvdVO.getSkdDirCd	());
						vvdVOs.add			(vo);
						
						VslSkdCngNoticeVO noticeVO = new VslSkdCngNoticeVO();
						noticeVO.setVslCd	(activationVvdVO.getVslCd		());
						noticeVO.setSkdVoyNo(activationVvdVO.getSkdVoyNo	());
						noticeVO.setSkdDirCd(activationVvdVO.getSkdDirCd	());
						
						/************************************************************
						 * Sending the reason of VVD deletion when deleting VVD
						 * ==========================================================
						 * 2015-05-15 by TOP
						 * ---------------------------------------------------------- 
						 ***/
						noticeVO.setTypeCd				("V"			);
						noticeVO.setRemark				("VVD Deletion"	);
						
						vslSkdCngNoticeVOs.add			(noticeVO		);
						/************************************************************/
						
						// in case existing Turn Info 
						if(activationVvdVO.getTurnSkdDirCd()!=null && activationVvdVO.getTurnSkdDirCd().length()!=0){
							VvdVO turnVo = new VvdVO();
							turnVo.setVslSlanCd(activationVvdVO.getVslSlanCd());
							turnVo.setVslCd(activationVvdVO.getVslCd());
							turnVo.setSkdVoyNo(activationVvdVO.getTurnSkdVoyNo());
							turnVo.setSkdDirCd(activationVvdVO.getTurnSkdDirCd());
							turnVvdVOs.add(turnVo);
						}
						
						
						/********************************************************************************
						 * Add new functionality interfaced to SCN(NYK Legacy System related with EDI)
						 * 2016-10-07
						 * 
						 ********************************************************************************/
				        VskVslSkdVO  tmpVO  = new VskVslSkdVO();
				        
				        tmpVO.setVslCd    	(activationVvdVO.getVslCd		());
						tmpVO.setSkdVoyNo	(activationVvdVO.getSkdVoyNo	());
						tmpVO.setSkdDirCd	(activationVvdVO.getSkdDirCd	());
						
						scnVskVslSkdVOs.add	(tmpVO);
						/********************************************************************************/				
						
					}
				}
				
				
				/********************************************************************************
				 * Add new functionality interfaced to SCN(NYK Legacy System related with EDI)
				 * 2016-10-07
				 * 
				 ********************************************************************************/
				List<String>    tmpStrList    = new ArrayList<String>();
				
				for(VvdVO tmpVO2 : vvdVOs){
					
			        String     sTmpStr  = tmpVO2.getVslCd()+tmpVO2.getSkdVoyNo()+tmpVO2.getSkdDirCd();
			        VskVslSkdVO  tmpVO  = new VskVslSkdVO();
			        
			        tmpVO.setVslCd    	(tmpVO2.getVslCd	());
					tmpVO.setSkdVoyNo	(tmpVO2.getSkdVoyNo	());
					tmpVO.setSkdDirCd	(tmpVO2.getSkdDirCd	());
					
					if(tmpVO != null && !tmpStrList.contains(sTmpStr))	scnVskVslSkdVOs.add(tmpVO);
					
					tmpStrList.add		(sTmpStr);
					
				}
				/********************************************************************************/
				
				actCommand.removeVskActPortSkd(vvdVOs);
				
				commit();
				
				
				//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://
				begin();
				revenueCommand.interfaceScheduleForRevenueVVD(vvdVOs);
				
				
				//::by TOP:2015-05-08:://
				//::by TOP:2015-05-08:://costalCommand.removeCstSkdByVvd(nonBkgVOs, bkgVOs, hisVO, account);		//original
				if(nonBkgVOs != null && bkgVOs !=null) {
					costalCommand.removeCstSkdByVvd	(nonBkgVOs, bkgVOs, hisVO, account, sFromEventSystem);
				} else if(nonBkgVOs != null && bkgVOs ==null) {
					costalCommand.removeCstSkdByVvd	(nonBkgVOs, null, hisVO, account, sFromEventSystem);
				} else if(nonBkgVOs == null && bkgVOs !=null) {
					costalCommand.removeCstSkdByVvd	(null, bkgVOs, hisVO, account, sFromEventSystem);
				} else {
					costalCommand.removeCstSkdByVvd	(null, null, hisVO, account, sFromEventSystem);
				}
				
				//::by TOP:2015-05-08:://
				
				bkgCommand.sendVslSkdCngNotice(vslSkdCngNoticeVOs);
				
				List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs = costalCommand.searchBkgBdrLog(vvdVOs);
				this.sendBkgVvdBdrLog(bkgVvdBdrLogVOs);
				
//				// ERP
//				List<VskVslSkdVO> vskVslSkdVOs = new ArrayList<VskVslSkdVO>();
//				for(VvdVO vvdVO : vvdVOs){
//					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
//					vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
//					vskVslSkdVO.setVslCd(vvdVO.getVslCd());
//					vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
//					vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
//					vskVslSkdVOs.add(vskVslSkdVO);
//				}
//				for(VvdVO vvdVO : turnVvdVOs){
//					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
//					vskVslSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
//					vskVslSkdVO.setVslCd(vvdVO.getVslCd());
//					vskVslSkdVO.setSkdVoyNo(vvdVO.getSkdVoyNo());
//					vskVslSkdVO.setSkdDirCd(vvdVO.getSkdDirCd());
//					vskVslSkdVOs.add(vskVslSkdVO);
//				}
//				sendVslSkdErpIf(vskVslSkdVOs);
				eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());
			}

			commit(); 
			
			/* ============================================================================
			 * Vessel Schedule History 愿�━(Header+Detail) Started ::2013-08-27::
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
			
			// :: VIPS START ::
			List<VskVslPortSkdVO> 			mVslPortSkdList = mergeVslPortSkdList(actCommand.getVslPortSkdList(), costalCommand.getVslPortSkdList());
			InterfaceScheduleToExternalBC 	ifCommand 		= new InterfaceScheduleToExternalBCImpl();
			
			if(		(actCommand.getVslPortSkdList() 		!= null	|| actCommand.getVslPortSkdList().size() 	> 0)
				&& 	(costalCommand.getVslPortSkdList() 		== null	|| costalCommand.getVslPortSkdList().size() == 0)){
				ifCommand.createVskVipsIf		(cnvtToIfMst(makePortToVsl(mVslPortSkdList)), cnvtToIfDtl(mVslPortSkdList, actCommand.getVskActPortSkdList()), "U");	
			}else if(	(actCommand.getVslPortSkdList() 	== null || actCommand.getVslPortSkdList().size() 	== 0)
					&& 	(costalCommand.getVslPortSkdList() 	!= null || costalCommand.getVslPortSkdList().size() > 0)){
				//:2015-12-09://ifCommand.createVskVipsIf		(cnvtToIfMst(makePortToVsl(mVslPortSkdList)), cnvtToIfDtl(mVslPortSkdList, actCommand.getVskActPortSkdList()), "D");
				ifCommand.createVskVipsIf		(cnvtToIfMst(makePortToVsl(mVslPortSkdList)), null, "D");
			}else{
				ifCommand.createVskVipsIf		(cnvtToIfMst(makePortToVsl(mVslPortSkdList)), cnvtToIfDtl(mVslPortSkdList, actCommand.getVskActPortSkdList()), "X");
			}
			// :: VIPS END ::
			
			
			/********************************************************************************
			 * Add new functionality interfaced to SCN(NYK Legacy System related with EDI)
			 * 2016-10-07
			 * 
			 ********************************************************************************/
			InterfaceScheduleToExternalScnBC scnCmd = new InterfaceScheduleToExternalScnBCImpl();
			
			if(scnVskVslSkdVOs != null && scnVskVslSkdVOs.size() > 0){
				scnCmd.manageScnCssmIf(scnVskVslSkdVOs);
			}
			/********************************************************************************/
			
			
			// IBIS START
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			List<VskVslSkdVO> vskVslSkdList = makePortToVsl(actCommand.getVskVslSkdList(), actCommand.getVslPortSkdList());
			if (actCommand.getVskActPortSkdList().size() > 0 ) {
				vskVslSkdList  = makeActPortToVsl(vskVslSkdList, actCommand.getVskActPortSkdList());
			}
			ibisIfCommand.createVskVslSkdIbisIfBackEndJob(cnvtToIfVskVslSkd(makePortToVsl(costalCommand.getVskVslSkdList(), costalCommand.getVslPortSkdList())), cnvtToIfVskVslPortSkd(costalCommand.getVslPortSkdList()), "VskVslSkd");
			//IBIS END
		
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
	 * VOP_VSK_0010 : P/F Schedule Type Change
	 * VOP_VSK_0220 : P/F Schedule Type Search
	 * VOP_VSK_0003 : P/F Schedule Type Search
	 * VOP_VSK_0053 : Lane Code Search
	 * VOP_VSK_0004 : P/F Schedule Type Search
	 * VOP_VSK_0054 : Lane Code Search
	 * 
	 * Retrieving Base Proforma Type or Selected Proforma Type by Lane
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
		} else {
			pfSkdVO = new PfSkdVO();
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
				if(uiVesselType != null) {
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
		}
		
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		List<PfSkdVO> list = command.searchPfSkd(pfSkdVO);
		
		if(e instanceof VopVsk0010Event || e instanceof VopVsk0220Event){
		
			int vslCount = 0;
			String vslSlanNm = "";
			
			if(e instanceof VopVsk0010Event || e instanceof VopVsk0220Event){
				if(list==null || list.size()==0){
					
					if("N".equals(pfSkdVO.getSlanStndFlg())){
						// in case PF_SVC_TP_CD is not Standard Type, input by Screen
						// if Result is null, then PF_SVC_TP_CD is not exist
						throw new EventException(new ErrorHandler("VSK10023").getMessage());
					}else{
						// Showing when Proforma Schedule is not registered
						throw new EventException(new ErrorHandler("VSK10020").getMessage());
					}
				}
				
				if("F".equals(pfSkdVO.getVslSvcTpCd()) || "F".equals(uiVesselType)){
					pfSkdVO = list.get(0);
					if(!"O".equals(pfSkdVO.getVslSvcTpCd())){
						// in case Lane Type is not Feeder
						throw new EventException(new ErrorHandler("VSK10049").getMessage()); 
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
				//in case of Manu In, Showing Last Row
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
				sb2.append(list.get(0).getCreUsrId());
				sb2.append("|");
				sb2.append(list.get(0).getUpdUsrId());
			
				eventResponse.setRsVo(vskPfSkdVO);
				eventResponse.setRsVoList(vskPfSkdDtlVOs);
				eventResponse.setETCData("ydCd", sb.toString());
				eventResponse.setETCData("etcdt", sb2.toString());
				eventResponse.setETCData("chkVslSkd", list.get(0).getCheckVslSkd());
			}else{
				//eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"P/F SKD Creation"}).getUserMessage());
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
			eventResponse.setETCData("chkVslSkd", list.get(0).getCheckVslSkd());
			}else{
//				eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"P/F SKD Creation(CCA)"}).getUserMessage());
				eventResponse.setRsVo(null);
				eventResponse.setRsVoList(null);

			}
		}else if(e instanceof VopVsk0054Event){
			
			if(list==null || list.size()==0){
				
				if("N".equals(pfSkdVO.getSlanStndFlg())){
					// in case PF_SVC_TP_CD is not Standard Type, input by Screen
					// if Result is null, then PF_SVC_TP_CD is not exist
//					throw new EventException(new ErrorHandler("VSK10023").getUserMessage());
					eventResponse.setUserMessage(new ErrorHandler("VSK10023").getUserMessage());
				}else{
					// Showing when Proforma Schedule is not registered
//					throw new EventException(new ErrorHandler("VSK10020").getUserMessage());
					eventResponse.setUserMessage(new ErrorHandler("VSK10020").getUserMessage());
				}
				return eventResponse;
			}
			
			if("F".equals(uiVesselType)){
				pfSkdVO = list.get(0);
				// in case of Lane Type is not Feeder
				// VSL_SVC_TP_CD != 'O' && FDR_DIV_CD != 'O'
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
	 * VOP_VSK_0010 : P/F Schedule Type Change
	 * VOP_VSK_0220 : P/F Schedule Type Search
	 * VOP_VSK_0003 : P/F Schedule Type Search
	 * VOP_VSK_0053 : Lane Code Search
	 * VOP_VSK_0004 : P/F Schedule Type Search
	 * VOP_VSK_0054 : Lane Code Search
	 * 
	 * Retrieving Base Proforma Type or Selected Proforma Type by Lane
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("static-access")
	private EventResponse searchPfSkdInclFinalVirPortList(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		PfSkdVO 			pfSkdVO 		=  null;
		VskPfSkdVO 			vskPfSkdVO 		= new VskPfSkdVO();
		List<VskPfSkdDtlVO> vskPfSkdDtlVOs 	= new ArrayList<VskPfSkdDtlVO>();
		StringBuffer 		sb 				= new StringBuffer();
		StringBuffer 		sb2 			= new StringBuffer();
		
		//String 				uiVesselType 	= null;
		//String 				fdrDivCd 		= null;
		
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		
		if(e instanceof VopVsk0003Event){
			VopVsk0003Event event 			= (VopVsk0003Event)e;
			pfSkdVO 						= event.getPfSkdVO();
			pfSkdVO.setVslSvcTpCd			("");
			pfSkdVO.setSlanStndFlg			("");
			
		}else if(e instanceof VopVsk0004Event){
			VopVsk0004Event event 			= (VopVsk0004Event)e;
			pfSkdVO 						= event.getPfSkdVO();
			pfSkdVO.setVslSvcTpCd			("");
			pfSkdVO.setSlanStndFlg			("");
			
		}else if(e instanceof VopVsk0053Event){
			VopVsk0053Event event 			= (VopVsk0053Event)e;
			pfSkdVO 						= event.getPfSkdVO();
			pfSkdVO.setVslSvcTpCd			("");
			pfSkdVO.setSlanStndFlg			("");
			
		}
		
		ProformaScheduleMgtBC 	command 	= new ProformaScheduleMgtBCImpl				();
		List<PfSkdVO> 			list 		= command.searchPfSkdInclFinalVirPortList	(pfSkdVO);
		
		if(e instanceof VopVsk0003Event || e instanceof VopVsk0004Event){
			
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
				//in case of Manu In, Showing Last Row
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
				sb2.append(list.get(0).getCreUsrId());
				sb2.append("|");
				sb2.append(list.get(0).getUpdUsrId());
			
				eventResponse.setRsVo(vskPfSkdVO);
				eventResponse.setRsVoList(vskPfSkdDtlVOs);
				eventResponse.setETCData("ydCd", sb.toString());
				eventResponse.setETCData("etcdt", sb2.toString());
				eventResponse.setETCData("chkVslSkd", list.get(0).getCheckVslSkd());
			}else{
				//eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"P/F SKD Creation"}).getUserMessage());
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
			eventResponse.setETCData("chkVslSkd", list.get(0).getCheckVslSkd());
			}else{
//				eventResponse.setUserMessage(new ErrorHandler("VSK10018",new String[]{"P/F SKD Creation(CCA)"}).getUserMessage());
				eventResponse.setRsVo(null);
				eventResponse.setRsVoList(null);

			}
			
		}
		
		return eventResponse;
	}
	
	
	/**
	 * VOP_VSK_0012 : Vessel Code Input
	 * 
	 * Retrieving Lane List having Vessel Code in specific Port Skd
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
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			VSKCodeFinderBC comCommand = new VSKCodeFinderBCImpl();
			LongRangeScheduleMgtBC lrsCommand = new VesselScheduleMgtBCImpl();
			
			List<VesselVO> list = comCommand.searchVslList(vesselVO);
			
			if(list!=null && list.size()==1){
				eventResponse.setETCData("vsl_eng_nm", list.get(0).getVslEngNm());
				
				List<PortSkdOnLongRangeVO> portSkdOnLongRangeVOs = lrsCommand.searchPortSkd(portSkdOnLongRangeVO);
				Set<String> vslSlanCdSet = new HashSet<String>();
				String vslSlanCd = null;
				
				// Picking out  from Retrieved SKD
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
	 * VOP_VSK_0010 : Vessel Code Input
	 * VOP_VSK_0012 : Vessel Code Input
	 * 
	 * Retrieving Vessel List
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslList(Event e) throws EventException {
		VesselVO vo = new VesselVO();
		if(e instanceof VopVsk0010Event){
			VopVsk0010Event event = (VopVsk0010Event)e;
			vo.setVslCd((String)event.getAttribute("vsl_cd"));
		}else if(e instanceof VopVsk0012Event){
			VopVsk0012Event event = (VopVsk0012Event)e;
			vo.setVslCd(event.getPortSkdOnLongRangeVO().getVslCd());
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
	 * Create Long Range Schedule
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
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
			
		} else {
			longRangeSkdGRPVO = new LongRangeSkdGRPVO(); 
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			
			begin();
			
			LongRangeScheduleMgtBC 				command 		= new VesselScheduleMgtBCImpl();
			CoastalScheduleMgtBC 				costalCommand 	= new VesselScheduleMgtBCImpl();
			//ActualScheduleMgtBC 				actCommand 		= new ActualScheduleMgtBCImpl();
			GeneralBookingSplitCombineBC 		bkgCommand 		= new GeneralBookingSplitCombineBCImpl();
			
			InterfaceScheduleForRevenueVVDBC 	revenueCommand	= new InterfaceScheduleForRevenueVVDBCImpl();
			
			longRangeSkdGRPVO.setCreUsrId(account.getUsr_id());
			longRangeSkdGRPVO.setUpdUsrId(account.getUsr_id());
			
			// Deleting already existed VVD
			// in case VVD without Booking
			ActivationVvdVO[] nonBkgVOs = longRangeSkdGRPVO.getNonBkgVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getNonBkgVVDs();
			for(int i=0; i<nonBkgVOs.length; i++){
				nonBkgVOs[i].setCreUsrId(account.getUsr_id());
				nonBkgVOs[i].setUpdUsrId(account.getUsr_id());
			}
			
			// in case VVD with Booking
			ActivationVvdVO[] bkgVVDs = longRangeSkdGRPVO.getBkgVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getBkgVVDs();
			ActivationVvdVO[] virVVDs = longRangeSkdGRPVO.getVirVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getVirVVDs();
			ActivationVvdVO[] bkgVirVVDs = longRangeSkdGRPVO.getBkgVirVVDs()==null?new ActivationVvdVO[0]:longRangeSkdGRPVO.getBkgVirVVDs();
			ActivationVvdVO[] bkgVOs = new ActivationVvdVO[bkgVVDs.length + virVVDs.length + bkgVirVVDs.length];
			
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
			
			//::by TOP:2015-05-08:://
			//::by TOP:2015-05-08:://costalCommand.removeCstSkdByVvd(nonBkgVOs, bkgVOs, vskVslSkdHisVO, account);		//original
			costalCommand.removeCstSkdByVvd(nonBkgVOs, bkgVOs, vskVslSkdHisVO, account, sFromEventSystem);
			//::by TOP:2015-05-08:://
			
			// Deleting Actual Schedule and Transmitting VVD Change Information to Booking
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
					
					// in case TURN information Exist 
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
					
					// in case TURN information Exist
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

			//::2015-05-13:by TOP:No Need:://
			////actCommand.removeVskActPortSkd					(vvdVOs);
			bkgCommand.sendVslSkdCngNotice					(vslSkdCngNoticeVOs);
			
			//--------------------------- VVD arrangement END ---------------------------
			
			
			//--------------------------- new VVD Creation Start ---------------------------	
			
			//::FOR.NYK.START::by DONGSOO:2014-09-10:://
			if(e instanceof VopVsk0010Event){

				longRangeSkdGRPVO = command.createLongRngSkdMultiple(longRangeSkdGRPVO);
				
			}//::FOR.NYK.FINISH::by DONGSOO:2014-09-10:://
			else{
				longRangeSkdGRPVO = command.createLongRngSkd(longRangeSkdGRPVO);
					
			}
			List<VskVslSkdVO> createdSkdVOs = longRangeSkdGRPVO.getVskVslSkdList(); // Created VVD List
			
			
			//-------------------------- VO for interface ---------------------------
			// Creating deleted VVD List
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
			
			// deleted VVD List + created VVD List
			vskVslSkdVOs.addAll(createdSkdVOs);
			
			//--------------------------- BKG BDR Transmit Start ------------------------------
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
			this.sendBkgVvdBdrLog(bkgVvdBdrLogVOs);
			
//			//--------------------------- ERP Transmit Start ---------------------------
//			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
//				vskVslSkdVO.setCreUsrId(account.getUsr_id());
//				vskVslSkdVO.setUpdUsrId(account.getUsr_id());
//			}
//			sendVslSkdErpIf(vskVslSkdVOs);
//			
//			//--------------------------- EDI Transmit Start ---------------------------
//			vvdVOs = new ArrayList<VvdVO>();
//			for(VskVslSkdVO vskVslSkdVO : createdSkdVOs){
//				VvdVO vvdVO = new VvdVO();
//				vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
//				vvdVO.setVslCd(vskVslSkdVO.getVslCd());
//				vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
//				vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
//				// CHM-201006129-01
//				vvdVO.setCreUsrId(account.getUsr_id());
//				vvdVO.setUpdUsrId(account.getUsr_id());
//				vvdVOs.add(vvdVO);
//			}
//			costalCommand.sendEdiToDLS(vvdVOs);
			
			commit();
			
			
			//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://
			begin();
			revenueCommand.interfaceScheduleForRevenueVVD(vvdVOs);	
			commit();
			//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://
			
			
			//::FOR.NYK.START::by KJH:2014-11-24:://
			////VSKCodeFinderBC combc = new VSKCodeFinderBCImpl();
			////combc.sendRevenueVVD(vvdVOs);
			//::FOR.NYK.FINISH::by KJH:2014-11-24:://
			// ?源껊궗筌롫뗄�놅쭪�
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			
			//::by TOP:2015-05-08:://
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
			 * Creation for Vessel Schedule History ::2015-05-08::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * VSK_VSL_SKD_HIS
			 * ============================================================================
			 */
			
			List<VskVslSkdVO> 		tmpVskVslSkdVOs		= longRangeSkdGRPVO.getVskVslSkdList();
			
			List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
			for(int i=0; i<tmpVskVslSkdVOs.size(); i++){
				VslSkdXtraHisVO	tmpVO				= new VslSkdXtraHisVO();
				VskVslSkdVO		tmpVskVslSkdVO		= tmpVskVslSkdVOs.get(i);
				
				tmpVO.setVskdTpCd		("M");							/** 'M':VVD Schedule, 'P':Port Schedule **/
				tmpVO.setVskdCngTpCd	("N");							/** 'N':Create, 'D':VVD Deletion		**/
				tmpVO.setBfrVslSlanCd	(tmpVskVslSkdVO.getVslSlanCd	());
				tmpVO.setBfrVslCd		(tmpVskVslSkdVO.getVslCd		());
				tmpVO.setBfrSkdVoyNo	(tmpVskVslSkdVO.getSkdVoyNo		());
				tmpVO.setBfrSkdDirCd	(tmpVskVslSkdVO.getSkdDirCd		());
				
				tmpVO.setBfrPfSvcTpCd	(tmpVskVslSkdVO.getPfSkdTpCd	());
				
				tmpVO.setUpdUsrId		(account.getUsr_id				());
				vslSkdXtraHisVOs.add	(tmpVO);				
			}
			
			costalCommand.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, "CREATION_LRS");
			//::by TOP:2015-05-08:://
			
			
			// :: VIPS START ::
			InterfaceScheduleToExternalBC ifCommand = new InterfaceScheduleToExternalBCImpl();
			ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "N");
			//ifCommand.createVskVipsIf(this.cnvtToIfHdr(command.getVskVslSkdList()), cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "N");
			// :: VIPS END ::
			
			
			/********************************************************************************
			 * Add new functionality interfaced to SCN(NYK Legacy System related with EDI)
			 * 2016-10-07
			 * 
			 ********************************************************************************/
			List<VskVslSkdVO>	scnVskVslSkdVOs	= command.getVskVslSkdList();
			
			InterfaceScheduleToExternalScnBC externalScnCmd = new InterfaceScheduleToExternalScnBCImpl();
			
			if(scnVskVslSkdVOs != null && scnVskVslSkdVOs.size() > 0){
				externalScnCmd.manageScnCssmIf(scnVskVslSkdVOs);
			}
			/********************************************************************************/
			
			
			//IBIS START
			List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs =  new ArrayList<VskVslSkdIbisIfVO>(); 
			List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs = new ArrayList<VskVslPortSkdIbisIfVO>();
			
			vskVslSkdIbisIfVOs.addAll(cnvtToIfVskVslSkd(makePortToVsl(costalCommand.getVskVslSkdList(), costalCommand.getVslPortSkdList())));
			vskVslPortSkdIbisIfVOs.addAll(cnvtToIfVskVslPortSkd(costalCommand.getVslPortSkdList()));
			
			vskVslSkdIbisIfVOs.addAll(cnvtToIfVskVslSkd(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())));
			vskVslPortSkdIbisIfVOs.addAll(cnvtToIfVskVslPortSkd(command.getVslPortSkdList()));
			
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			ibisIfCommand.createVskVslSkdIbisIfBackEndJob(vskVslSkdIbisIfVOs, vskVslPortSkdIbisIfVOs, "VskVslSkd");
			//IBIS END
			
			
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
	 * Transmitting Booking VVD BDR Log
	 * 
	 * @param List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs
	 */
	private void sendBkgVvdBdrLog(List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs){
		if(bkgVvdBdrLogVOs != null && bkgVvdBdrLogVOs.size()>0){
			BookingProcessMgtBC bkgPrsCmd = new BookingProcessMgtBCImpl();
			for(BkgVvdBdrLogVO bkgVvdBdrLogVO : bkgVvdBdrLogVOs){
				try{
					bkgPrsCmd.manageBKGBDRLOGBackEndJob(bkgVvdBdrLogVO, account);
				}catch(Exception ex){
					log.error(ex.getMessage());
				}
			}
		}
	}
	
//	/**
//	 * Transmitting Created VVD from Long Range Creation to ERP 
//	 * 
//	 * @param List<VskVslSkdVO> vskVslSkdVOs
//	 * @throws EventException
//	 * @date 2009. 11. 4.
//	 */
//	private void sendVslSkdErpIf(List<VskVslSkdVO> vskVslSkdVOs) throws EventException {
//		try{
//			CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
//			List<VvdVO> erpVvdVOs = new ArrayList<VvdVO>();
//			for(VskVslSkdVO vskVslSkdVO : vskVslSkdVOs){
//				VvdVO vvdVO = new VvdVO();
////				vvdVO.setIbflag("I");
//				vvdVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
//				vvdVO.setVslCd(vskVslSkdVO.getVslCd());
//				vvdVO.setSkdVoyNo(vskVslSkdVO.getSkdVoyNo());
//				vvdVO.setSkdDirCd(vskVslSkdVO.getSkdDirCd());
//				vvdVO.setCreUsrId(vskVslSkdVO.getCreUsrId());
//				vvdVO.setUpdUsrId(vskVslSkdVO.getUpdUsrId());
//				erpVvdVOs.add(vvdVO);
//			}
//			command.sendVslSkdErpIf(erpVvdVOs);
//		}catch(EventException ex){
//			throw ex;
//		}catch(Exception ex){
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * VOP_VSK_0010 : Simulation
	 * Simulation Long Range SKD Schedule
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
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
		
		/** Long Term Schedule Creation for Feeder(CCA) Service Lane **/
		if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){  // Feeder SKD Simulation - Feeder SKD - VOP_VSK_0054

			List<LongRangeSkdVO> longRangeSkdVOList = command2.simulateLongRngSkd(longRangeSkdGRPVO);
			eventResponse.setRsVoList(longRangeSkdVOList);
			
			// Creation Header using P/F
				
			// Header
			StringBuilder headTitle1 = new StringBuilder(); // SKD_DIR_CD
			StringBuilder headTitle2 = new StringBuilder(); // VPS_PORT_CD
			StringBuilder headTitle3 = new StringBuilder(); // ETB_DY_CD/ETD_DY_CD
			StringBuilder headTitle4 = new StringBuilder(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			StringBuilder headTitle5 = new StringBuilder(); // CLPT_SEQ
			StringBuilder headTitle6 = new StringBuilder(); // YARD_CD
			
			String		tmpVslSvcLane	= null;
			String		tmpPfSkdTpCd	= null;
			
			for(PfSkdVO vo : longRangeSkdGRPVO.getPfSkdVOs()){
				
				if(tmpVslSvcLane == null){
					tmpVslSvcLane	= vo.getVslSlanCd(); 
					tmpPfSkdTpCd	= longRangeSkdGRPVO.getPfSvcTpCd(); 
				}
				
				headTitle1.append("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd());
				headTitle2.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
				headTitle3.append("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd());
				headTitle4.append("|").append(vo.getEtbTmHrmnt().substring(0,2)).append("|").append(vo.getEtdTmHrmnt().substring(0,2));
				headTitle5.append("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq());
				////::2015-04-21:by TOP:://headTitle6.append("|").append(vo.getYdCd()).append("|").append(vo.getYdCd());
				headTitle6.append("|").append(vo.getYdCd().substring(5, 7)).append("|").append(vo.getYdCd().substring(5, 7));
				
			}
			
			eventResponse.setETCData("HeadTitle1", headTitle1.toString());
			eventResponse.setETCData("HeadTitle2", headTitle2.toString());
			eventResponse.setETCData("HeadTitle3", headTitle3.toString());
			eventResponse.setETCData("HeadTitle4", headTitle4.toString());
			eventResponse.setETCData("HeadTitle5", headTitle5.toString());
			eventResponse.setETCData("HeadTitle6", headTitle6.toString());
			
			/*****************************************************/
			/** Adding P/F Service Type Code in EventResponse	**/
			eventResponse.setETCData("HeadPfSvcTp", tmpVslSvcLane + "/" + tmpPfSkdTpCd);
			/**			
			
		/** Multiple Long Term Schedule Creation for Trunk Service Lane **/
		}else if (e.getFormCommand().isCommand(FormCommand.SEARCH12) 	// Simulation
				|| e.getFormCommand().isCommand(FormCommand.SEARCH03)){	// Phase In

			// Creation Header using P/F
			
			// Header
			StringBuilder headTitle1 = new StringBuilder(); // SKD_DIR_CD
			StringBuilder headTitle2 = new StringBuilder(); // VPS_PORT_CD
			StringBuilder headTitle3 = new StringBuilder(); // ETB_DY_CD/ETD_DY_CD
			StringBuilder headTitle4 = new StringBuilder(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			StringBuilder headTitle5 = new StringBuilder(); // CLPT_SEQ
			StringBuilder headTitle6 = new StringBuilder(); // YARD_CD
			
			StringBuilder headTitle21 = new StringBuilder(); // SKD_DIR_CD
			StringBuilder headTitle22 = new StringBuilder(); // VPS_PORT_CD
			StringBuilder headTitle23 = new StringBuilder(); // ETB_DY_CD/ETD_DY_CD
			StringBuilder headTitle24 = new StringBuilder(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			StringBuilder headTitle25 = new StringBuilder(); // CLPT_SEQ
			StringBuilder headTitle26 = new StringBuilder(); // YARD_CD
			
			StringBuilder headTitle31 = new StringBuilder(); // SKD_DIR_CD
			StringBuilder headTitle32 = new StringBuilder(); // VPS_PORT_CD
			StringBuilder headTitle33 = new StringBuilder(); // ETB_DY_CD/ETD_DY_CD
			StringBuilder headTitle34 = new StringBuilder(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			StringBuilder headTitle35 = new StringBuilder(); // CLPT_SEQ
			StringBuilder headTitle36 = new StringBuilder(); // YARD_CD
			
			StringBuilder sTmpHeadTitle1 = new StringBuilder(); // SKD_DIR_CD
			StringBuilder sTmpHeadTitle2 = new StringBuilder(); // VPS_PORT_CD
			StringBuilder sTmpHeadTitle3 = new StringBuilder(); // ETB_DY_CD/ETD_DY_CD
			StringBuilder sTmpHeadTitle4 = new StringBuilder(); // ETB_TM_HRMNT/ETD_TM_HRMNT
			StringBuilder sTmpHeadTitle5 = new StringBuilder(); // CLPT_SEQ
			StringBuilder sTmpHeadTitle6 = new StringBuilder(); // YARD_CD
						
			int iHeadTitleCnt 	= 0;
			
			String sTmpPortList = "";
			//String sPortList1 	= "";
			//String sPortList2 	= "";
			//String sPortList3 	= "";
			
//						String sSheetNo = "1";
			List<String> lSheet1 = new ArrayList<String>();
			List<String> lSheet2 = new ArrayList<String>();
			List<String> lSheet3 = new ArrayList<String>();

			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			///////////////////// by TOP ///////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*			PfSkdVO[]	tmpPfArr				= longRangeSkdGRPVO.getPfSkdVOs();
			
			List<PfSkdVO>	tmpList				= new ArrayList<PfSkdVO>();
			//List<PfSkdVO>	sortedList			= new ArrayList<PfSkdVO>();
			List<String>	pfSkdTpCdGrpList	= new ArrayList<String>();
			
			for(int i=1; i<tmpPfArr.length; i++){
				tmpList.add(tmpPfArr[i]);
			}
			
			String beforePfSkdTpCd 	= null;
			String currentPfSkdTpCd = null;
			
			for(int i=1; i<tmpList.size(); i++){
				currentPfSkdTpCd	= tmpList.get(i).getPfSvcTpCd();
				
				if(beforePfSkdTpCd == null){
					//sortedList.add(currentVO);
					pfSkdTpCdGrpList.add(currentPfSkdTpCd);
					
					beforePfSkdTpCd	= currentPfSkdTpCd;
				}else{
					if(!pfSkdTpCdGrpList.contains(currentPfSkdTpCd)){
						//sortedList.add(currentVO);
						pfSkdTpCdGrpList.add(currentPfSkdTpCd);
					}
				}
			}*/
			
/*			if(pfSkdTpCdGrpList != null && pfSkdTpCdGrpList.size()>3){
				eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Schedule"}).getMessage());		
			}*/
			
/*			for(int i=0; i<pfSkdTpCdGrpList.size(); i++){
				for(PfSkdVO tmpVO : tmpList){
					if(pfSkdTpCdGrpList.get(i).equals(tmpVO.getPfSvcTpCd())){
						sortedList.add(tmpVO);
					}
				}
				
			}*/
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			///////////////////// by TOP ///////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			
			String sPfSvcTpCd 		= "";
			
			String curPfSkdTpCd1 	= "";
			String curPfSkdTpCd2 	= "";
			String curPfSkdTpCd3 	= "";
			
			String tmpPfSkdTpCd 	= "";
			
			String tmpVslSvcLane	= "";
			
			for(PfSkdVO vo : longRangeSkdGRPVO.getPfSkdVOs()){	
			//for(PfSkdVO vo : sortedList){	
				
				if("".equals(sPfSvcTpCd) || sPfSvcTpCd.equals(vo.getPfSvcTpCd())){
				
					tmpVslSvcLane	= vo.getVslSlanCd();
					
					sTmpHeadTitle1.append("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd());
					sTmpHeadTitle2.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
					sTmpHeadTitle3.append("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd());
					sTmpHeadTitle4.append("|").append(vo.getEtbTmHrmnt().substring(0,2)).append("|").append(vo.getEtdTmHrmnt().substring(0,2));
					sTmpHeadTitle5.append("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq());
					//sTmpHeadTitle6.append("|").append(vo.getYdCd()).append("|").append(vo.getYdCd());
					sTmpHeadTitle6.append("|").append(vo.getYdCd().substring(5,7)).append("|").append(vo.getYdCd().substring(5,7));
					
				}else{
					
					////if("".equals(sPortList1)){
					if("".equals(curPfSkdTpCd1)){	
						headTitle1.append(sTmpHeadTitle1);
						headTitle2.append(sTmpHeadTitle2);
						headTitle3.append(sTmpHeadTitle3);
						headTitle4.append(sTmpHeadTitle4);
						headTitle5.append(sTmpHeadTitle5);
						headTitle6.append(sTmpHeadTitle6);
						
						//sPortList1 = sTmpPortList;
						//sTmpPortList = "";
						
						curPfSkdTpCd1	= tmpPfSkdTpCd;
						tmpPfSkdTpCd	= "";
						
						iHeadTitleCnt 	= 1;
						
						lSheet1.add(sPfSvcTpCd);
											
					////}else if(sTmpPortList.equals(sPortList1)){
					}else if(tmpPfSkdTpCd.equals(curPfSkdTpCd1)){
						
						if(!headTitle1.equals(sTmpHeadTitle1)){
							headTitle1 = checkStringBuilder(headTitle1, sTmpHeadTitle1, 0);
						}
						if(!headTitle3.equals(sTmpHeadTitle3)){
							headTitle3 = checkStringBuilder(headTitle3, sTmpHeadTitle3, 2);
						}
						if(!headTitle4.equals(sTmpHeadTitle4)){
							headTitle4 = checkStringBuilder(headTitle4, sTmpHeadTitle4, 2);
						}
						if(!headTitle6.equals(sTmpHeadTitle6)){
							headTitle6 = checkStringBuilder(headTitle6, sTmpHeadTitle6, 1);
						}
						
						//sPortList1 = sTmpPortList;
						//sTmpPortList = "";
						
						curPfSkdTpCd1	= tmpPfSkdTpCd;
						tmpPfSkdTpCd	= "";
						
						lSheet1.add(sPfSvcTpCd);
						
					////}else if("".equals(sPortList2)){
					}else if("".equals(curPfSkdTpCd2)){
						
						headTitle21.append(sTmpHeadTitle1);
						headTitle22.append(sTmpHeadTitle2);
						headTitle23.append(sTmpHeadTitle3);
						headTitle24.append(sTmpHeadTitle4);
						headTitle25.append(sTmpHeadTitle5);
						headTitle26.append(sTmpHeadTitle6);
						
						//sPortList2 = sTmpPortList;
						//sTmpPortList = "";
						
						curPfSkdTpCd2	= tmpPfSkdTpCd;
						tmpPfSkdTpCd	= "";
						
						iHeadTitleCnt = 2;
						
						lSheet2.add(sPfSvcTpCd);
						
					////}else if(sTmpPortList.equals(sPortList2)){
					}else if(tmpPfSkdTpCd.equals(curPfSkdTpCd2)){
						
						if(!headTitle21.equals(sTmpHeadTitle1)){
							headTitle21 = checkStringBuilder(headTitle21, sTmpHeadTitle1, 0);
						}
						if(!headTitle23.equals(sTmpHeadTitle3)){
							headTitle23 = checkStringBuilder(headTitle23, sTmpHeadTitle3, 2);
						}
						if(!headTitle24.equals(sTmpHeadTitle4)){
							headTitle24 = checkStringBuilder(headTitle24, sTmpHeadTitle4, 2);
						}
						if(!headTitle26.equals(sTmpHeadTitle6)){
							headTitle26 = checkStringBuilder(headTitle26, sTmpHeadTitle6, 1);
						}
										
						//sPortList2 = sTmpPortList;
						//sTmpPortList = "";
						
						curPfSkdTpCd2	= tmpPfSkdTpCd;
						tmpPfSkdTpCd	= "";						

						lSheet2.add(sPfSvcTpCd);
						
					// ?��뼣 野껋럩��?獄쏆뮇源��� ?�놁벉. - �닌딄쉐???�쀬겱
					////}else if("".equals(sPortList3)){
					}else if("".equals(curPfSkdTpCd3)){
						
						headTitle31.append(sTmpHeadTitle1);
						headTitle32.append(sTmpHeadTitle2);
						headTitle33.append(sTmpHeadTitle3);
						headTitle34.append(sTmpHeadTitle4);
						headTitle35.append(sTmpHeadTitle5);
						headTitle36.append(sTmpHeadTitle6);
						
						//sPortList3 = sTmpPortList;
						//sTmpPortList = "";
						
						curPfSkdTpCd3	= tmpPfSkdTpCd;
						tmpPfSkdTpCd	= "";
						
						iHeadTitleCnt = 3;
						
						lSheet3.add(sPfSvcTpCd);
						
					////}else if(sTmpPortList.equals(sPortList3)){
					}else if(tmpPfSkdTpCd.equals(curPfSkdTpCd3)){
						
						if(!headTitle31.equals(sTmpHeadTitle1)){
							headTitle31 = checkStringBuilder(headTitle31, sTmpHeadTitle1, 0);
						}
						if(!headTitle33.equals(sTmpHeadTitle3)){
							headTitle33 = checkStringBuilder(headTitle33, sTmpHeadTitle3, 2);
						}
						if(!headTitle34.equals(sTmpHeadTitle4)){
							headTitle34 = checkStringBuilder(headTitle34, sTmpHeadTitle4, 2);
						}
						if(!headTitle36.equals(sTmpHeadTitle6)){
							headTitle36 = checkStringBuilder(headTitle36, sTmpHeadTitle6, 1);
						}
						
						//sPortList3 = sTmpPortList;
						//sTmpPortList = "";
						
						curPfSkdTpCd3	= tmpPfSkdTpCd;
						tmpPfSkdTpCd	= "";

						lSheet3.add(sPfSvcTpCd);
						
					} 
					
					sTmpHeadTitle1 = new StringBuilder("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd()); 
					sTmpHeadTitle2 = new StringBuilder("|").append(vo.getPortCd()).append("|").append(vo.getPortCd()); 
					sTmpHeadTitle3 = new StringBuilder("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd()); 
					sTmpHeadTitle4 = new StringBuilder("|").append(vo.getEtbTmHrmnt().substring(0,2)).append("|").append(vo.getEtdTmHrmnt().substring(0,2)); 
					sTmpHeadTitle5 = new StringBuilder("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq()); 
//								sTmpHeadTitle6 = new StringBuilder("|").append(vo.getYdCd()).append("|").append(vo.getYdCd()); 
					sTmpHeadTitle6 = new StringBuilder("|").append(vo.getYdCd().substring(5,7)).append("|").append(vo.getYdCd().substring(5,7));
					
//								vo.setPortRotnSeq(sSheetNo);
					
				}
				
				sPfSvcTpCd 		= vo.getPfSvcTpCd();
				tmpPfSkdTpCd	= vo.getPfSvcTpCd(); ////by top
				sTmpPortList 	= sTmpPortList + vo.getPortCd();
				
			}	/** END OF FOR LOOP **/
			
			
			
			////if("".equals(sPortList1)){
			if("".equals(curPfSkdTpCd1)){
					
				headTitle1.append(sTmpHeadTitle1);
				headTitle2.append(sTmpHeadTitle2);
				headTitle3.append(sTmpHeadTitle3);
				headTitle4.append(sTmpHeadTitle4);
				headTitle5.append(sTmpHeadTitle5);
				headTitle6.append(sTmpHeadTitle6);
				
				iHeadTitleCnt = 1;
				lSheet1.add(sPfSvcTpCd);

			////}else if(sTmpPortList.equals(sPortList1)){
			}else if(tmpPfSkdTpCd.equals(curPfSkdTpCd1)){
				
				if(!headTitle1.equals(sTmpHeadTitle1)){
					headTitle1 = checkStringBuilder(headTitle1, sTmpHeadTitle1, 0);
				}
				if(!headTitle3.equals(sTmpHeadTitle3)){
					headTitle3 = checkStringBuilder(headTitle3, sTmpHeadTitle3, 2);
				}
				if(!headTitle4.equals(sTmpHeadTitle4)){
					headTitle4 = checkStringBuilder(headTitle4, sTmpHeadTitle4, 2);
				}
				if(!headTitle6.equals(sTmpHeadTitle6)){
					headTitle6 = checkStringBuilder(headTitle6, sTmpHeadTitle6, 1);
				}
				
				lSheet1.add(sPfSvcTpCd);

			////}else if("".equals(sPortList2)){
			}else if("".equals(curPfSkdTpCd2)){
				
				headTitle21.append(sTmpHeadTitle1);
				headTitle22.append(sTmpHeadTitle2);
				headTitle23.append(sTmpHeadTitle3);
				headTitle24.append(sTmpHeadTitle4);
				headTitle25.append(sTmpHeadTitle5);
				headTitle26.append(sTmpHeadTitle6);

				iHeadTitleCnt = 2;
				lSheet2.add(sPfSvcTpCd);
	
			////}else if(sTmpPortList.equals(sPortList2)){
			}else if(tmpPfSkdTpCd.equals(curPfSkdTpCd2)){
				
				if(!headTitle21.equals(sTmpHeadTitle1)){
					headTitle21 = checkStringBuilder(headTitle21, sTmpHeadTitle1, 0);
				}
				if(!headTitle23.equals(sTmpHeadTitle3)){
					headTitle23 = checkStringBuilder(headTitle23, sTmpHeadTitle3, 2);
				}
				if(!headTitle24.equals(sTmpHeadTitle4)){
					headTitle24 = checkStringBuilder(headTitle24, sTmpHeadTitle4, 2);
				}
				if(!headTitle26.equals(sTmpHeadTitle6)){
					headTitle26 = checkStringBuilder(headTitle26, sTmpHeadTitle6, 1);
				}
				
				lSheet2.add(sPfSvcTpCd);
	
			////}else if("".equals(sPortList3)){
			}else if("".equals(curPfSkdTpCd3)){
				
				headTitle31.append(sTmpHeadTitle1);
				headTitle32.append(sTmpHeadTitle2);
				headTitle33.append(sTmpHeadTitle3);
				headTitle34.append(sTmpHeadTitle4);
				headTitle35.append(sTmpHeadTitle5);
				headTitle36.append(sTmpHeadTitle6);
				
				iHeadTitleCnt = 3;
				lSheet3.add(sPfSvcTpCd);
		
			////}else if(sTmpPortList.equals(sPortList3)){
			}else if(tmpPfSkdTpCd.equals(curPfSkdTpCd3)){
				
				if(!headTitle31.equals(sTmpHeadTitle1)){
					headTitle31 = checkStringBuilder(headTitle31, sTmpHeadTitle1, 0);
				}
				if(!headTitle33.equals(sTmpHeadTitle3)){
					headTitle33 = checkStringBuilder(headTitle33, sTmpHeadTitle3, 2);
				}
				if(!headTitle34.equals(sTmpHeadTitle4)){
					headTitle34 = checkStringBuilder(headTitle34, sTmpHeadTitle4, 2);
				}
				if(!headTitle36.equals(sTmpHeadTitle6)){
					headTitle36 = checkStringBuilder(headTitle36, sTmpHeadTitle6, 1);
				}
				
				lSheet3.add(sPfSvcTpCd);
				
			} 
			
//						for(PfSkdVO vo : longRangeSkdGRPVO.getPfSkdVOs()){	
//							
//							headTitle1.append("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd());
//							headTitle2.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
//							headTitle3.append("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd());
//							headTitle4.append("|").append(vo.getEtbTmHrmnt().substring(0,2)).append("|").append(vo.getEtdTmHrmnt().substring(0,2));
//							headTitle5.append("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq());
//							headTitle6.append("|").append(vo.getYdCd()).append("|").append(vo.getYdCd());
//								
//						}	
			
			eventResponse.setETCData("HeadTitle1", headTitle1.toString());
			eventResponse.setETCData("HeadTitle2", headTitle2.toString());
			eventResponse.setETCData("HeadTitle3", headTitle3.toString());
			eventResponse.setETCData("HeadTitle4", headTitle4.toString());
			eventResponse.setETCData("HeadTitle5", headTitle5.toString());
			eventResponse.setETCData("HeadTitle6", headTitle6.toString());
			
			eventResponse.setETCData("HeadTitle21", headTitle21.toString());
			eventResponse.setETCData("HeadTitle22", headTitle22.toString());
			eventResponse.setETCData("HeadTitle23", headTitle23.toString());
			eventResponse.setETCData("HeadTitle24", headTitle24.toString());
			eventResponse.setETCData("HeadTitle25", headTitle25.toString());
			eventResponse.setETCData("HeadTitle26", headTitle26.toString());
			
			eventResponse.setETCData("HeadTitle31", headTitle31.toString());
			eventResponse.setETCData("HeadTitle32", headTitle32.toString());
			eventResponse.setETCData("HeadTitle33", headTitle33.toString());
			eventResponse.setETCData("HeadTitle34", headTitle34.toString());
			eventResponse.setETCData("HeadTitle35", headTitle35.toString());
			eventResponse.setETCData("HeadTitle36", headTitle36.toString());
			
			eventResponse.setETCData("HeadTitleCnt", Integer.toString(iHeadTitleCnt));
			
			
			/*****************************************************/
			switch(iHeadTitleCnt){
			case 1:
				curPfSkdTpCd1	= tmpPfSkdTpCd;
				break;
			case 2:
				curPfSkdTpCd2	= tmpPfSkdTpCd;
				break;
			case 3:
				curPfSkdTpCd3	= tmpPfSkdTpCd;
				break;				
			}
			
			/** Adding P/F Service Type Code in EventResponse	**/
			eventResponse.setETCData("HeadPfSvcTp1", tmpVslSvcLane + "/" + curPfSkdTpCd1);
			eventResponse.setETCData("HeadPfSvcTp2", tmpVslSvcLane + "/" + curPfSkdTpCd2);
			eventResponse.setETCData("HeadPfSvcTp3", tmpVslSvcLane + "/" + curPfSkdTpCd3);
			/*****************************************************/
			
			for(PfSkdVO vo : longRangeSkdGRPVO.getPfSkdVOs()){
				if(lSheet1.contains(vo.getPfSvcTpCd())){
					vo.setSheetObjNo("1");
				}else if(lSheet2.contains(vo.getPfSvcTpCd())){
					vo.setSheetObjNo("2");
				}else if(lSheet3.contains(vo.getPfSvcTpCd())){
					vo.setSheetObjNo("3");	
				}
			}
			
			List<LongRangeSkdVO> longRangeSkdVOList = command2.simulateLongRngSkd(longRangeSkdGRPVO);
			eventResponse.setRsVoList(longRangeSkdVOList);
						
			return eventResponse;
			
		}
		else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) // phasein cancel
		{
			
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
			
			// Header
			String headTitle1 = longRangeSkdGRPVO.getHeadTitle1();
			String headTitle2 = longRangeSkdGRPVO.getHeadTitle2();
			String headTitle3 = longRangeSkdGRPVO.getHeadTitle3();
			String headTitle4 = longRangeSkdGRPVO.getHeadTitle4();
			String headTitle5 = longRangeSkdGRPVO.getHeadTitle5();
			String headTitle6 = longRangeSkdGRPVO.getHeadTitle6();
			
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
			)){
				// when Header lengths are different, throw Exception
				throw new EventException(new ErrorHandler("VSK10035").getUserMessage());			
			}

			
			// Handling Header
			StringBuilder sbHeadTitle1 = new StringBuilder();
			for(int i=1; i<titles1.length; i++){
				if(i==addCallPos*2-1){
					// Keeping Direction with direction of Add Port
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
			
			List<PfSkdVO> simHeaderPortList = loadSimHeaderPortList(longRangeSkdGRPVO);
//			List<LongRangeSkdVO> simDataList = loadSimDataList(simHeaderPortList, longRangeSkdGRPVO, addCallPos, addVvdPos, null, true);
			List<LongRangeSkdVO> list = command2.simulateLongRngSkd(longRangeSkdGRPVO);
			
			StringBuilder headTitle1 = new StringBuilder();
			StringBuilder headTitle2 = new StringBuilder();
			StringBuilder headTitle3 = new StringBuilder();
			StringBuilder headTitle4 = new StringBuilder();
			StringBuilder headTitle5 = new StringBuilder();
			StringBuilder headTitle6 = new StringBuilder();
			
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
	
	private List<PfSkdVO> loadSimHeaderPortList(LongRangeSkdGRPVO grpvo) throws EventException {
		
		// Header
		String headTitle1 = grpvo.getHeadTitle1();
		String headTitle2 = grpvo.getHeadTitle2();
		String headTitle3 = grpvo.getHeadTitle3();
		String headTitle4 = grpvo.getHeadTitle4();
		String headTitle5 = grpvo.getHeadTitle5();
		String headTitle6 = grpvo.getHeadTitle6();
		
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
		)){
			throw new EventException(new ErrorHandler(VSKGeneralUtil.VSK00011, "The length of the header is different.").getUserMessage());			
		}
		
		// Creating Port SKD List with Header Info
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
	
	/**
	 * VOP_VSK_0245 : Retrieve
	 * Retrieving Calling Port List
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
						infoSB.append(reasonPortVO.getVpsPortCd() + "\t" + reasonPortVO.getSkdVoyNo() + "\t" + reasonPortVO.getSkdDirCd() + "\t" + reasonPortVO.getClptIndSeq());
						
						for(int i=1; i<reasonPortList.size(); i++){
							reasonPortVO = reasonPortList.get(i);
							
							sb.append("|" + reasonPortVO.getVpsPortCd());
							infoSB.append("|" + reasonPortVO.getVpsPortCd() + "\t" + reasonPortVO.getSkdVoyNo() + "\t" + reasonPortVO.getSkdDirCd() + "\t" + reasonPortVO.getClptIndSeq());
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
	 * Retrieving Costal Schedule
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
		} else {
			paramVO = new CstSkdByVvdVO();
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
					throw new EventException(new ErrorHandler("VSK10002").getMessage());
				}else{
					chkCnt = command.checkVvdApplyBooking(vvdVO);
					if(chkCnt > 0){
						bookChk = "X";
					}else{
						chkCnt = command.checkVvdActualSkdInput(vvdVO);
						if(chkCnt > 0){
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
				// ************** Checking Booking of Turnning Port START **************
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
							bookChk = "X";
						}
						
						break;
					}
				}
				// ************** Checking Booking of Turnning Port END **************
			}
			
			
			//Retrieving only Feeder in case of 0057
			if(e instanceof VopVsk0057Event){
				MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
				mdmVslSvcLaneVO.setVslSlanCd(list.get(0).getVslSlanCd());
				List<MdmVslSvcLaneVO> chkList = codeCommand.checkSvcLane(mdmVslSvcLaneVO);
				
				if(chkList != null && chkList.size() > 0){
					MdmVslSvcLaneVO chkSvcTpVO = chkList.get(0);
					String svcTpCd = chkSvcTpVO.getVslSvcTpCd();
					if(svcTpCd == null || "".equals(svcTpCd)){
						throw new EventException(new ErrorHandler("VSK10023").getMessage());
					}else if(!"O".equals(svcTpCd)){
						String vvd = list.get(0).getVslCd() + list.get(0).getSkdVoyNo() + list.get(0).getSkdDirCd();
						throw new EventException(new ErrorHandler("VSK10033", new String[]{vvd}).getMessage());
					}
				}else{
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
		
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0014, VOP_VSK_0015, VOP_VSK_0057, VOP_VSK_0058, VOP_VSK_0017 : Yard Code Focus<br>
	 * Retrieving Yard List with Port
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
//		}else if(e instanceof VopVsk0066Event){
//			VopVsk0066Event event = (VopVsk0066Event)e;
//			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0215Event){
			VopVsk0215Event event = (VopVsk0215Event)e;
			yardVO = event.getYardVO();
		} else {
			yardVO = new YardVO();
		}
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl(); 
		String chkPort = command.checkPort(yardVO.getLocCd());
		
//		if(chkPort != null && !"".equals(chkPort)){		
		if(!"".equals(chkPort)){		
			list = command.searchYardListByPort(yardVO);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
	
			if(list != null && list.size() > 0){
				if(e instanceof VopVsk0003Event ||e instanceof VopVsk0053Event){
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
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0248 : Open
	 * 
	 * Retrieving P/F SKD History Data
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
	 * Retrieving PF SKD Type with Lane Code
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
		} else {
			pfLaneTypeVO = new PfLaneTypeVO();
		}
//		else if(e instanceof VopVsk0251Event){
//			VopVsk0251Event event = (VopVsk0251Event)e;
//			pfLaneTypeVO = event.getPfLaneTypeVO();
//		}
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		
		MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
		mdmVslSvcLaneVO.setVslSlanCd(pfLaneTypeVO.getVslSlanCd());
		List<MdmVslSvcLaneVO> chkList = command.checkSvcLane(mdmVslSvcLaneVO);
		
		if(chkList != null && chkList.size() > 0){
			//Retrieving only Feeder in case of 0057
			MdmVslSvcLaneVO chkSvcTpVO = chkList.get(0);
			String svcTpCd = chkSvcTpVO.getVslSvcTpCd();
			
			if(e instanceof VopVsk0057Event){
				if(svcTpCd == null || "".equals(svcTpCd)){
					throw new EventException(new ErrorHandler("VSK10023").getMessage());
				}else if(!"O".equals(svcTpCd)){
					throw new EventException(new ErrorHandler("VSK10049").getMessage());
				}
			}
			
			eventResponse.setETCData("svc_tp_cd", svcTpCd);
		}else{
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
		eventResponse.setETCData("pf_skd_tp_cd", pfLaneTypeVO.getPfSvcTpCd());
		eventResponse.setETCData("pf_svc_type_list", sb2.toString());
		eventResponse.setETCData("slan_stnd_flag_list", sb3.toString());
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0014, VOP_VSK_0057 : VVD Search Button Click<br>
	 * Returning ETA, ETB, ETD for Creating Coastal SKD with Service Lane Code, Type, Direction, Port from P/F SKD
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
		} else {
			paramVO = new CstSkdByVvdVO();
		}
		
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VSKCodeFinderBC codeCommand = new VSKCodeFinderBCImpl();

		List<CstSkdByVvdVO> list = command.searchCstSkdByPfSkdUse(paramVO);
		
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
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0015, VOP_VSK_0058 : Phase Out Cancel Button Click<br>
	 * Returning ETA, ETB, ETD for Creating Coastal SKD with Service Lane Code, Type, Direction, Port from P/F SKD
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
				
				paramVO.setVslCd		(swapCstSkdSimVOs[pIdx].getVslCd		());
				paramVO.setSkdVoyNo		(swapCstSkdSimVOs[pIdx].getSkdVoyNo		());
				paramVO.setSkdDirCd		(swapCstSkdSimVOs[pIdx].getSkdDirCd		());
				paramVO.setPfEtbDt		(swapCstSkdSimVOs[pIdx].getPfEtbDt		());
				paramVO.setInitEtbDt	(swapCstSkdSimVOs[pIdx].getInitEtbDt	());
				paramVO.setVpsEtdDt		(swapCstSkdSimVOs[pIdx].getVpsEtdDt		());
				paramVO.setVslSlanCd	(swapCstSkdSimVOs[pIdx].getVslSlanCd	());
				paramVO.setPfSvcTpCd	(swapCstSkdSimVOs[pIdx].getPfSvcTpCd	());
				paramVO.setPfSkdTpCd	(swapCstSkdSimVOs[pIdx].getPfSkdTpCd	());
				paramVO.setVpsPortCd	(swapCstSkdSimVOs[pIdx].getVpsPortCd	());
				
				if(swapCstSkdSimVOs[pIdx].getPfEtbDt() == null || "".equals(swapCstSkdSimVOs[pIdx].getPfEtbDt())){
					for(int i=pIdx-1; i>=0; i--){
						
						log.debug("<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><>");
						log.debug(" i ["+i+"] :: port rotn seq value ["+swapCstSkdSimVOs[i].getPortRotnSeq()+"]");
						log.debug("<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><>");
						
						if(swapCstSkdSimVOs[i].getPortRotnSeq() != null && !"".equals(swapCstSkdSimVOs[i].getPortRotnSeq()) && Integer.parseInt(swapCstSkdSimVOs[i].getPortRotnSeq())>0){
							paramVO.setPortRotnSeq	(swapCstSkdSimVOs[i].getPortRotnSeq());
							break;
						}
					}
				}else{
					paramVO.setPortRotnSeq	(swapCstSkdSimVOs[pIdx].getPortRotnSeq());
				}
				
				log.debug("<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><>");
				log.debug(paramVO.getVslCd());
				log.debug(paramVO.getSkdVoyNo());
				log.debug(paramVO.getSkdDirCd());
				log.debug(paramVO.getPfEtbDt());
				log.debug(paramVO.getInitEtbDt());
				log.debug(paramVO.getVpsEtdDt());
				log.debug(paramVO.getVslSlanCd());
				log.debug(paramVO.getPfSvcTpCd());
				log.debug(paramVO.getPfSkdTpCd());
				log.debug(paramVO.getVpsPortCd());
				log.debug(paramVO.getPortRotnSeq());
				log.debug("<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><>");
			}
		}
		
		CoastalScheduleMgtBC 	command 			= new VesselScheduleMgtBCImpl();
		VSKCodeFinderBC 		codeCommand 		= new VSKCodeFinderBCImpl();

		List<SwapCstSkdSimVO> 	list 				= command.searchCstSkdByPfSkdSim(paramVO);
		
		PfLaneTypeVO 			pfLaneTypeVO 		= new PfLaneTypeVO();
		pfLaneTypeVO.setVslSlanCd(paramVO.getVslSlanCd());
		List<PfLaneTypeVO> 		pfLaneTypeVOList 	= codeCommand.searchPfLaneTypeList(pfLaneTypeVO);
		
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
		eventResponse.setETCData("pf_svc_type_list"		, sb.toString());
		eventResponse.setETCData("slan_stnd_flag_list"	, sb2.toString());
		eventResponse.setETCData("call_ind_cd"			, VSKGeneralUtil.comnCodeList("CD00976", "onlycode"));
		eventResponse.setETCData("call_ind_nm"			, VSKGeneralUtil.comnCodeList("CD00976", "onlyname"));
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
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
	 * Retrieving Direction
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
	 * Retrieving User Lane Group
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
	
	private EventResponse checkBkgStsByVvd(Event e) throws EventException {
		VopVsk0211Event event = (VopVsk0211Event)e;
		
		SimulationVvdCheckVO simulationVvdCheckVO = event.getSimulationVvdCheckVO();
		LongRangeScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		
		List<VvdBkgStsVO> list = command.checkBkgStsByVvd(simulationVvdCheckVO);
		
		boolean bkgStatus      = false;
		boolean virBkgStatus   = false;
		boolean ruseProhiFlg   = false;
		boolean actSkdInputFlg = false;
		
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
			if("Y".equals(vvdBkgStsVO.getActSkdInputFlg())){
				actSkdInputFlg = true;
			}
		}
		
		StringBuilder remark = new StringBuilder("");
		if(bkgStatus){
			remark.append("Booking data already exists on Creating VVD and User have to record delete history.");
		}
		if(virBkgStatus){
			if(remark.length()>0){
				remark.append("\n");
			}
			remark.append("Booking data already exists on Virtual calling port  and User have to record delete history.");
		}
		
		if(ruseProhiFlg){
			if(remark.length()>0){
				remark.append("\n");
			}
			remark.append("VVD of creating LRS already exists on financial system and can?占쏙옙create vessel SKD.");
		}
		
		if(actSkdInputFlg){
			if(remark.length()>0){
				remark.append("\n");
			}
			remark.append("Actual skd already exists. So You can't create these VVDs");
		}
				
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("remark", remark.toString());
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0014, VOP_VSK_0057, VOP_VSK_0015, VOP_VSK_0058 : Save<br>
	 * Saving and Changing inputted Vessel Port Schedule<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstSkdByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CstSkdByVvdVO                     paramVO = null;
		CstSkdByVvdVO[]                  paramVOs = null;
		SwapCstSkdSimVO           swapCstSkdSimVO = null;
		SwapCstSkdSimVO[]        swapCstSkdSimVOs = null;
		
		String					sFromEventSystem		= "";
		String					sCvntFromEventSystem	= "";
		
		if(e instanceof VopVsk0014Event){
			
			sFromEventSystem	= "VOP_VSK_0014";
			
			VopVsk0014Event event = (VopVsk0014Event)e;
			paramVO = event.getCstSkdByVvdVO();
			paramVOs = event.getCstSkdByVvdVOS();
			
			if(paramVO != null && paramVOs != null){
				if(paramVOs.length > 0){
					for(int i=0; i<paramVOs.length; i++){
//						paramVOs[i].setVslCd(paramVO.getVslCd());
//						paramVOs[i].setSkdVoyNo(paramVO.getSkdVoyNo());
//						paramVOs[i].setSkdDirCd(paramVO.getSkdDirCd());
						paramVOs[i].setVslSlanCd(paramVO.getVslSlanCd());
						paramVOs[i].setSlanCd(paramVO.getVslSlanCd());
						paramVOs[i].setPfSvcTpCd(paramVO.getPfSvcTpCd());
						paramVOs[i].setSkdRmk(paramVO.getSkdRmk());
						
					}
				}
			}
		}else if(e instanceof VopVsk0057Event){
			
			sFromEventSystem	= "VOP_VSK_0057";
			
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getCstSkdByVvdVO();
			paramVOs = event.getCstSkdByVvdVOS();
			
			if(paramVO != null && paramVOs != null){
				if(paramVOs.length > 0){
					for(int i=0; i<paramVOs.length; i++){
//						paramVOs[i].setVslCd(paramVO.getVslCd());
//						paramVOs[i].setSkdVoyNo(paramVO.getSkdVoyNo());
//						paramVOs[i].setSkdDirCd(paramVO.getSkdDirCd());
						paramVOs[i].setVslSlanCd(paramVO.getVslSlanCd());
						paramVOs[i].setSlanCd(paramVO.getVslSlanCd());
						paramVOs[i].setPfSvcTpCd(paramVO.getPfSvcTpCd());
						paramVOs[i].setSkdRmk(paramVO.getSkdRmk());		
						
					}
				}
			}
			
		}else if(e instanceof VopVsk0015Event){
			
			sFromEventSystem	= "VOP_VSK_0015";
			
			VopVsk0015Event event = (VopVsk0015Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			swapCstSkdSimVOs = event.getSwapCstSkdSimVOs();

			if(swapCstSkdSimVOs != null){
				int len = swapCstSkdSimVOs.length;
				paramVOs = new CstSkdByVvdVO[len];
	
				for(int i=0; i<len; i++){
					paramVOs[i] = new CstSkdByVvdVO();
					ObjectCloner.build(swapCstSkdSimVOs[i], paramVOs[i]);
//					paramVOs[i].setSkdRmk(swapCstSkdSimVO.getSkdRmk());
					
				}
			}
			
		}else if(e instanceof VopVsk0058Event){
			
			sFromEventSystem	= "VOP_VSK_0058";
			
			VopVsk0058Event event = (VopVsk0058Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			swapCstSkdSimVOs = event.getSwapCstSkdSimVOs();

			paramVOs = new CstSkdByVvdVO[swapCstSkdSimVOs.length];

			for(int i=0; i<swapCstSkdSimVOs.length; i++){
				paramVOs[i] = new CstSkdByVvdVO();
				
				ObjectCloner.build(swapCstSkdSimVOs[i], paramVOs[i]);

				paramVOs[i].setVslSlanCd(swapCstSkdSimVO.getVslSlanCd());
				paramVOs[i].setSlanCd(swapCstSkdSimVO.getVslSlanCd());
				paramVOs[i].setSkdRmk(swapCstSkdSimVO.getSkdRmk());

//				if (!"XXX".equals(paramVOs[i].getPortSkpTpCd()) && (paramVOs[i].getVpsRmk() == null || "".equals(paramVOs[i].getVpsRmk()))) {
//					paramVOs[i].setVpsRmk("XXX");
//				}
				
			}
			
		}else if(e instanceof VopVskSPPVSK0005Event){
			
			sFromEventSystem	= "VOP_VSK_SPP_VSK_0005";
			
			VopVskSPPVSK0005Event event = (VopVskSPPVSK0005Event)e;
			paramVOs = event.getCstSkdByVvdVOs();
		}
		
		CoastalScheduleMgtBC 				command 		= new VesselScheduleMgtBCImpl();		
		InterfaceScheduleForRevenueVVDBC 	revenueCommand	= new InterfaceScheduleForRevenueVVDBCImpl();	
		
		try{	
			
			begin();
			
			VvdVO vvdVO = new VvdVO();
			if(paramVO != null){
				vvdVO.setVslCd(paramVO.getVslCd());
				vvdVO.setSkdVoyNo(paramVO.getSkdVoyNo());
				vvdVO.setSkdDirCd(paramVO.getSkdDirCd());
			}else if(swapCstSkdSimVO != null){
				vvdVO.setVslCd(swapCstSkdSimVO.getVslCd());
				vvdVO.setSkdVoyNo(swapCstSkdSimVO.getSkdVoyNo());
				vvdVO.setSkdDirCd(swapCstSkdSimVO.getSkdDirCd());
			}
			
			String chkStr = command.checkReuseVvd(vvdVO);
			if("Y".equals(chkStr)){
				throw new EventException(new ErrorHandler("VSK10002").getMessage());
			}
			
			// VIPS ADD START
//			List<VvdVO> mstParamList = new ArrayList<VvdVO>();
//			List<VvdVO> dtlParamList = new ArrayList<VvdVO>();
//
//			for(CstSkdByVvdVO param:paramVOs) {
//				VvdVO vo = new VvdVO();
//				vo.setVslCd(param.getVslCd());
//				vo.setSkdVoyNo(param.getSkdVoyNo());
//				vo.setSkdDirCd(param.getSkdDirCd());
//				mstParamList.add(vo);
//				dtlParamList.add(vo);
//			}
//			this.insetVskVipsIf(mstParamList, mstParamList);
			// VIPS ADD END
			
			VslSkdChgStsGRPVO vslSkdChgStsGRPVO = command.manageCstSkdByVvd(paramVOs, account);
			
			// :: VIPS START ::
			InterfaceScheduleToExternalBC ifCommand = new InterfaceScheduleToExternalBCImpl();
			
//			System.out.println("########### command.getDelNextVslPortSkdList().size()="+command.getDelNextVslPortSkdList().size());
//			System.out.println("########### command.getDelNextVslPortSkdList()="+command.getDelNextVslPortSkdList());
//			
//			if (command.getDelNextVslPortSkdList().size() > 0 ) {
//				ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getDelNextVslPortSkdList())), cnvtToIfDtl(command.getDelNextVslPortSkdList()), "N");
//			}else{
//				System.out.println("########### cnvtToIfMst="+cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())));
//				System.out.println("########### cnvtToIfDtl="+cnvtToIfDtl(command.getVslPortSkdList()));
//				
//				ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "D");
//			}
			// :: VIPS END ::
			
			//Transmitting Changed SKD to Booking
			sendBkgByVslSkdChg(vslSkdChgStsGRPVO);

			//Transmitting Changed SKD to COP
			sendCopByVslSkdChg(vslSkdChgStsGRPVO);
			
			//Send RevenueVVD//
			//::FOR.NYK.START::by KJH:2014-11-24:://
			List<VvdVO> vvdVOs = vslSkdChgStsGRPVO.getErpVvdVOs();
			////combc.sendRevenueVVD(vvdVOs);
			//::FOR.NYK.FINISH::by KJH:2014-11-24:://
			
			/**************************************************************************
			 * ========================================================================
			 * Adding the logic of calling booking's BDR method
			 * APR07 2015 by TOP
			 * ========================================================================
			 */
			List<BkgVvdBdrLogVO> bkgVvdBdrLogVOs 	= command.searchBkgBdrLog(vvdVOs);
			this.sendBkgVvdBdrLog(bkgVvdBdrLogVOs);		
			///////////////////////////////////////////////////////////////////////////
			
			commit();
			
			//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://
			begin();
			revenueCommand.interfaceScheduleForRevenueVVD(vvdVOs);			
			//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://


			//::FOR.NYK.START::by KJH:2014-11-26:://
/////////////////////////////////////////////////////////////////////////////////////////////			
//			if (list != null && list.size() > 0) {
//				//::Modified Interface area in VSK :: by KTW 2015-10-30
//				ifbc.deleteCSSMIF(list);
//			}
/////////////////////////////////////////////////////////////////////////////////////////////			
			//::FOR.NYK.FINISH::by KJH:2014-11-26:://
			
			
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
//			if(list != null && list.size() > 0){ //DEL
//				if (command.getDelNextVslPortSkdList().size() > 0 ) { // port delete 
//					ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getDelNextVslPortSkdList())), cnvtToIfDtl(command.getDelNextVslPortSkdList()), "N");
//				}else{ // all port delete
//					if(command.getDelNextDirVslPortSkdList().size() > 0){ //exist dir port
//						ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), null, "D");	
//					}else{
//						ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "D");
//					}
//				}
//			}else{
//				ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "N");
//			}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			if (command.getDelNextVslPortSkdList().size() > 0 ) { // port delete 
				ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getDelNextVslPortSkdList())), cnvtToIfDtl(command.getDelNextVslPortSkdList()), "U");
			}else{ 
				if(command.getDelNextDirVslPortSkdList().size() > 0){ //exist dir port
					ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), null, "U");	
				}else{
					ifCommand.createVskVipsIf(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "U");
				}
			}
			
			/********************************************************************************
			 * Add new functionality interfaced to SCN(NYK Legacy System related with EDI)
			 * 2016-10-07
			 * 
			 ********************************************************************************/
			InterfaceScheduleToExternalScnBC externalScnCmd = new InterfaceScheduleToExternalScnBCImpl();
			
			List<VskVslSkdVO>	scnVskVslSkdVOs	= command.getVskVslSkdList();
			
			if(scnVskVslSkdVOs != null && scnVskVslSkdVOs.size() > 0){
				externalScnCmd.manageScnCssmIf(scnVskVslSkdVOs);
			}
			/********************************************************************************/
			
			
			//IBIS START
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			List<VskVslSkdVO> vskVslSkdList = makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList());
			if (command.getDelNextVslPortSkdList().size() > 0 ) {
				vskVslSkdList  = makePortToVsl(vskVslSkdList, command.getDelNextVslPortSkdList());
			}
			ibisIfCommand.createVskVslSkdIbisIfBackEndJob(cnvtToIfVskVslSkd(vskVslSkdList), cnvtToIfVskVslPortSkd(command.getVslPortSkdList()), "VskVslSkd");
			//IBIS END

			//::by TOP:2015-05-08:://
			/* ============================================================================
			 * Creation for Vessel Schedule History ::2015-05-08::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * VSK_VSL_SKD_HIS
			 * ============================================================================
			 */
			Map<String, List<VslSkdXtraHisVO>>	hmVskVslSkdVOs			= new HashMap<String, List<VslSkdXtraHisVO>>();
			hmVskVslSkdVOs												= vslSkdChgStsGRPVO.getHmVslSkdXtraHisVOs();	
			
			if(!hmVskVslSkdVOs.isEmpty()){
				for(int i=0; i<hmVskVslSkdVOs.size(); i++){
					Collection<String>	collection	= hmVskVslSkdVOs.keySet();
					Iterator<String>	itrKey		= collection.iterator();
					
					while(itrKey.hasNext()){
						String 					sKey				= (String)itrKey.next();
						List<VslSkdXtraHisVO>	vslSkdXtraHisVOs	= new ArrayList<VslSkdXtraHisVO>();
						vslSkdXtraHisVOs							= hmVskVslSkdVOs.get(sKey);
						
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
						
						command.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, sCvntFromEventSystem);		
					}
				}
			}
			
			VslSkdXtraHisGroupVO vslSkdXtraHisGroupVO	= vslSkdChgStsGRPVO.getVslSkdXtraHisGroupVO();
			
			if("UPDATE_CST_ByVvd"	.equals(vslSkdXtraHisGroupVO.getFromEventSystem())){
				
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
				
				command.createVesselScheduleExtraChangeHistory(vslSkdXtraHisGroupVO.getVslSkdXtraHisVOs(), sCvntFromEventSystem);
			}

			////command.createVesselScheduleExtraChangeHistory(vslSkdXtraHisGroupVO.getVslSkdXtraHisVOs(), sCvntFromEventSystem);		
			//::by TOP:2015-05-08:://
			
			
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
	 * Transmitting Information to Booking when Schedule Change
	 * 
	 * @param VslSkdChgStsGRPVO vslSkdCngStsGRPVO
	 * @throws EventException
	 */
	private void sendBkgByVslSkdChg(VslSkdChgStsGRPVO vslSkdChgStsGRPVO) throws EventException {
		GeneralBookingSplitCombineBC bkgScbCmd = new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC bkgRctCmd = new GeneralBookingReceiptBCImpl();
		
		log.debug("=================== Booking START ===================");
		List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = vslSkdChgStsGRPVO.getVslSkdCngNoticeVOs();
		if(vslSkdCngNoticeVOs != null && vslSkdCngNoticeVOs.size()>0){
			try{
				bkgScbCmd.sendVslSkdCngNotice(vslSkdCngNoticeVOs);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10045").getMessage());
			}
		}
		
		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs = vslSkdChgStsGRPVO.getVslSkdCngUpdateVOs();
		if(vslSkdCngUpdateVOs != null && vslSkdCngUpdateVOs.size()>0){
			try{
				bkgRctCmd.modifyBkgVvdForVslSkdCng(vslSkdCngUpdateVOs, account);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler("VSK10047").getMessage());
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
		this.sendBkgVvdBdrLog(bkgVvdBdrLogVOs);
		
		log.debug("=================== Booking END ===================");
	}
	
	/**
	 * manageCstSkdByVvd, manageCstSkdBerthWdo : Call
	 * Transmitting Information to COP when Schedule Change
	 * 
	 * @param vslSkdChgStsGRPVO vslSkdCngStsGRPVO
	 * @throws EventException
	 */
	private void sendCopByVslSkdChg(VslSkdChgStsGRPVO vslSkdChgStsGRPVO) throws EventException {
		CopDetailReceiveBC command = new CopDetailReceiveBCImpl();
		
		log.debug("=================== COP START ===================");
		List<SceActRcvIfVO> sceActRcvIfVOs = vslSkdChgStsGRPVO.getSceActRcvIfVOs();
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
	 * VOP_VSK_0014, VOP_VSK_0057 : Save<br>
	 * Saving Remark
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
		} else {
			paramVO = new CstSkdByVvdVO();
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
	 * VOP_VSK_0015, VOP_VSK_0058 : Retrieve<br>
	 * Retrieving Coastal Simulation<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSim(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SwapCstSkdSimVO swapCstSkdSimVO = new SwapCstSkdSimVO();
		
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
				//in case 0058, Retrieving only Feeder
				if(e instanceof VopVsk0058Event){
					MdmVslSvcLaneVO mdmVslSvcLaneVO = new MdmVslSvcLaneVO();
					mdmVslSvcLaneVO.setVslSlanCd(list.get(0).getVslSlanCd());
					List<MdmVslSvcLaneVO> chkList = codeCommand.checkSvcLane(mdmVslSvcLaneVO);
					
					if(chkList != null && chkList.size() > 0){
						MdmVslSvcLaneVO chkSvcTpVO = chkList.get(0);
						String svcTpCd = chkSvcTpVO.getVslSvcTpCd();
						if(svcTpCd == null || "".equals(svcTpCd)){
							throw new EventException(new ErrorHandler("VSK10023").getMessage());
						}else if(!"O".equals(svcTpCd)){
							String vvd = list.get(0).getVslCd() + list.get(0).getSkdVoyNo() + list.get(0).getSkdDirCd();
							throw new EventException(new ErrorHandler("VSK10033", new String[]{vvd}).getMessage());
						}
					}else{
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
			}
			
			VesselVO vslParamVO = new VesselVO();
			vslParamVO.setVslCd(swapCstSkdSimVO.getVslCd());
			List<VesselVO> vslVOList = codeCommand.searchVslList(vslParamVO);
	
			if(vslVOList != null && vslVOList.size() > 0){
				String vslEngNm = vslVOList.get(0).getVslEngNm();
				
				eventResponse.setETCData("vsl_eng_nm", vslEngNm);
			}
			
			eventResponse.setETCData("dlay_rsn_cd", VSKGeneralUtil.comnCodeList("CD01830", "onlycode"));
			eventResponse.setETCData("dlay_rsn_nm", VSKGeneralUtil.comnCodeList("CD01830", "codeNname"));
			eventResponse.setETCData("chg_sts_cd", VSKGeneralUtil.comnCodeList("CD01825", "onlycode"));
			eventResponse.setETCData("chg_sts_nm", VSKGeneralUtil.comnCodeList("CD01825", "onlyname"));
			if(list != null) {
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage(), ex);
		}
			
		return eventResponse;
	}

	
	/**
	 * VOP_VSK_0249 : Open 
	 * VOP_VSK_0012 : Retrieve
	 * 
	 * Retrieving Service Lane List
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
		} else {
			vo = new MdmVslSvcLaneVO();
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
	 * Checking VVD<br>
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
	 * Checking Exist Vessel Code in MDM_VSL_CNTR
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVslCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		VvdVO paramVO = null;
		
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
		} else {
			paramVO = new VvdVO();
		}
		
		int chkCnt = 0;
			
		if(paramVO.getVslCd() == null){
			log.debug("paramVO.getVslCd() == null");
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
	 * VOP_VSK_0014, VOP_VSK_0057 : Direction Code Change<br>
	 * Checking registered LANE CODE, DIRECTION
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
		} else {
			paramVO = new MdmVslSvcLaneDirVO();
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
	 * VOP_VSK_0014, VOP_VSK_0057 : Direction Code Change<br>
	 * Checking registered LANE CODE, DIRECTION
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVskVslPortSkdEtd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		CstSkdByVvdVO paramVO = null;
		SwapCstSkdSimVO swapCstSkdSimVO = null;
		VslPortSkdVO vslPortSkdVO 	= new VslPortSkdVO();
		
		
		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			paramVO = event.getCstSkdByVvdVO();
			
			vslPortSkdVO.setVslCd		    (paramVO.getVslCd());
			vslPortSkdVO.setSkdVoyNo		(paramVO.getTurnSkdVoyNo());
			vslPortSkdVO.setSkdDirCd		(paramVO.getTurnSkdDirCd());
			vslPortSkdVO.setTurnSkdVoyNo	(paramVO.getSkdVoyNo());
			vslPortSkdVO.setTurnSkdDirCd	(paramVO.getSkdDirCd());
			vslPortSkdVO.setVpsEtaDt    	(paramVO.getVpsEtaDt());
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getCstSkdByVvdVO();
			
			vslPortSkdVO.setVslCd		    (paramVO.getVslCd());
			vslPortSkdVO.setSkdVoyNo		(paramVO.getTurnSkdVoyNo());
			vslPortSkdVO.setSkdDirCd		(paramVO.getTurnSkdDirCd());
			vslPortSkdVO.setTurnSkdVoyNo	(paramVO.getSkdVoyNo());
			vslPortSkdVO.setTurnSkdDirCd	(paramVO.getSkdDirCd());
			vslPortSkdVO.setVpsEtaDt    	(paramVO.getVpsEtaDt());
		}else if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			
			vslPortSkdVO.setVslCd		    (swapCstSkdSimVO.getVslCd());
			vslPortSkdVO.setSkdVoyNo		(swapCstSkdSimVO.getTurnSkdVoyNo());
			vslPortSkdVO.setSkdDirCd		(swapCstSkdSimVO.getTurnSkdDirCd());
			vslPortSkdVO.setTurnSkdVoyNo	(swapCstSkdSimVO.getSkdVoyNo());
			vslPortSkdVO.setTurnSkdDirCd	(swapCstSkdSimVO.getSkdDirCd());
			vslPortSkdVO.setVpsEtaDt    	(swapCstSkdSimVO.getVpsEtaDt());
		}else if(e instanceof VopVsk0058Event){
			VopVsk0058Event event = (VopVsk0058Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			
			vslPortSkdVO.setVslCd		    (swapCstSkdSimVO.getVslCd());
			vslPortSkdVO.setSkdVoyNo		(swapCstSkdSimVO.getTurnSkdVoyNo());
			vslPortSkdVO.setSkdDirCd		(swapCstSkdSimVO.getTurnSkdDirCd());
			vslPortSkdVO.setTurnSkdVoyNo	(swapCstSkdSimVO.getSkdVoyNo());
			vslPortSkdVO.setTurnSkdDirCd	(swapCstSkdSimVO.getSkdDirCd());
			vslPortSkdVO.setVpsEtaDt    	(swapCstSkdSimVO.getVpsEtaDt());
		} else {
			vslPortSkdVO 	= new VslPortSkdVO();
		}
		
		int etdChk 				= command.checkVskVslPortSkdEtd			(vslPortSkdVO);

		if(etdChk >= 0){
			eventResponse.setETCData("etd_chk", "Y");
		}else{
			eventResponse.setETCData("etd_chk", "N");
		}
		
		return eventResponse;
	}
	

	/**
	 * VOP_VSK_0014, VOP_VSK_0057 : Direction Code Change<br>
	 * Checking registered LANE CODE, DIRECTION
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse isReverseVesselPortSchedule(Event e) throws EventException {
		
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		CoastalScheduleMgtBC 	command 		= new VesselScheduleMgtBCImpl();
		CstSkdByVvdVO 			paramVO 		= null;
		VslPortSkdVO 			vslPortSkdVO 	= new VslPortSkdVO();
		SwapCstSkdSimVO 		swapCstSkdSimVO = null;
		
		if(e instanceof VopVsk0014Event){
			VopVsk0014Event event = (VopVsk0014Event)e;
			paramVO = event.getCstSkdByVvdVO();
			
			vslPortSkdVO.setVslCd		    (paramVO.getVslCd		());
			vslPortSkdVO.setSkdVoyNo		(paramVO.getSkdVoyNo	());
			vslPortSkdVO.setSkdDirCd		(paramVO.getSkdDirCd	());
			vslPortSkdVO.setVpsPortCd		(paramVO.getVpsPortCd	());
			vslPortSkdVO.setClptIndSeq		(paramVO.getClptIndSeq	());
			vslPortSkdVO.setVpsEtdDt		(paramVO.getVpsEtdDt	());
		}else if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			
			vslPortSkdVO.setVslCd		    (swapCstSkdSimVO.getVslCd		());
			vslPortSkdVO.setSkdVoyNo		(swapCstSkdSimVO.getSkdVoyNo	());
			vslPortSkdVO.setSkdDirCd		(swapCstSkdSimVO.getSkdDirCd	());
			vslPortSkdVO.setVpsPortCd		(swapCstSkdSimVO.getVpsPortCd	());
			vslPortSkdVO.setClptIndSeq		(swapCstSkdSimVO.getClptIndSeq	());
			vslPortSkdVO.setVpsEtdDt		(swapCstSkdSimVO.getVpsEtdDt	());
		}else if(e instanceof VopVsk0057Event){
			VopVsk0057Event event = (VopVsk0057Event)e;
			paramVO = event.getCstSkdByVvdVO();
			
			vslPortSkdVO.setVslCd		    (paramVO.getVslCd		());
			vslPortSkdVO.setSkdVoyNo		(paramVO.getSkdVoyNo	());
			vslPortSkdVO.setSkdDirCd		(paramVO.getSkdDirCd	());
			vslPortSkdVO.setVpsPortCd		(paramVO.getVpsPortCd	());
			vslPortSkdVO.setClptIndSeq		(paramVO.getClptIndSeq	());
			vslPortSkdVO.setVpsEtdDt		(paramVO.getVpsEtdDt	());
		}else if(e instanceof VopVsk0058Event){
			VopVsk0058Event event = (VopVsk0058Event)e;
			swapCstSkdSimVO = event.getSwapCstSkdSimVO();
			
			vslPortSkdVO.setVslCd		    (swapCstSkdSimVO.getVslCd		());
			vslPortSkdVO.setSkdVoyNo		(swapCstSkdSimVO.getSkdVoyNo	());
			vslPortSkdVO.setSkdDirCd		(swapCstSkdSimVO.getSkdDirCd	());
			vslPortSkdVO.setVpsPortCd		(swapCstSkdSimVO.getVpsPortCd	());
			vslPortSkdVO.setClptIndSeq		(swapCstSkdSimVO.getClptIndSeq	());
			vslPortSkdVO.setVpsEtdDt		(swapCstSkdSimVO.getVpsEtdDt	());
		} else {
			vslPortSkdVO 					= new VslPortSkdVO();
		}
		
		boolean	isReverseVPS				= command.isReverseVesselPortSchedule	(vslPortSkdVO);
		
		if(isReverseVPS){
			eventResponse.setETCData("IS_REVERSE_VPS", "Y");
		}else{
			eventResponse.setETCData("IS_REVERSE_VPS", "N");
		}

		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0249 : Port Input<br>
	 * Retrieving Port<br>
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
		} else {
			locationVO = new LocationVO();
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
	 * Retrieving ETA/ETB/ETD of Port<br>
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
	 * Saving Daily Berth Window Updated by Port
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
		} else {
			paramVO = new CstSkdBerthWdoVO();
			yardVO = new YardVO();
		}
		
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		
		List<CstSkdBerthWdoVO> list = command.searchCstSkdBerthWdo(paramVO);
		
		
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
	 * Changing Coastal SKD, ETA, ETB, ETD, Next ETA of Port
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstSkdBerthWdo(Event e) throws EventException {
		
		GeneralEventResponse 				eventResponse 	= new GeneralEventResponse();
		CoastalScheduleMgtBC 				command 		= new VesselScheduleMgtBCImpl();
		InterfaceScheduleForRevenueVVDBC 	revenueCommand	= new InterfaceScheduleForRevenueVVDBCImpl();
		CstSkdBerthWdoVO[] 					paramVOs 		= null;
		
		if(e instanceof VopVsk0017Event){
			VopVsk0017Event event = (VopVsk0017Event)e;
			paramVOs = event.getCstSkdBerthWdoVOs();
		}
		
		try{
			
			begin();
			
			VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
			if(paramVOs != null) {
				vslSkdChgStsGRPVO = command.manageCstSkdBerthWdo(paramVOs, account);
			}
			
			//Transmitting Changed SKD to Booking
			sendBkgByVslSkdChg(vslSkdChgStsGRPVO);
			
			//Transmitting Changed SKD to COP
			sendCopByVslSkdChg(vslSkdChgStsGRPVO);
			
			String msgOkCnt = vslSkdChgStsGRPVO.getOkCnt();
			String msgFailCnt = vslSkdChgStsGRPVO.getFailCnt();
			String msgFailPortInfo = " ";
			List<String> failPortInfos = vslSkdChgStsGRPVO.getFailPortInfos();
			if(failPortInfos != null && failPortInfos.size() > 0){
				msgFailPortInfo = "\nFail VVD : ";
				for(String failPortInfo : failPortInfos){
					msgFailPortInfo = msgFailPortInfo + "\n"+ failPortInfo;//String.format("%32s", failPortInfo);
				}
			}
			//Send RevenueVVD//
			//::FOR.NYK.START::by KJH:2014-11-24:://
			List<VvdVO> vvdVOs = vslSkdChgStsGRPVO.getErpVvdVOs();
			////VSKCodeFinderBC combc = new VSKCodeFinderBCImpl();
			////combc.sendRevenueVVD(vvdVOs);
			//::FOR.NYK.FINISH::by KJH:2014-11-24:://
			
			commit();
			
			//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://
			begin();
			revenueCommand.interfaceScheduleForRevenueVVD(vvdVOs);
			commit();
			//::INTERFACE TO AR_MST_REV_VVD::BY TOP::2015-01-10:://

			String[] msgs = new String[]{msgOkCnt, msgFailCnt, msgFailPortInfo};
//			throw new EventException(new ErrorHandler("VSK10075", errMsgs).getMessage());
			eventResponse.setUserMessage(new ErrorHandler("VSK10078", msgs).getUserMessage());
			
			//::by TOP:2015-05-08:://
			/* ============================================================================
			 * Creation for Vessel Schedule History ::2015-05-08::
			 * ----------------------------------------------------------------------------
			 * <TABLE NAME>
			 * VSK_VSL_SKD_HIS
			 * ============================================================================
			 */
			List<VslSkdXtraHisVO> 	vslSkdXtraHisVOs	= vslSkdChgStsGRPVO.getVslSkdXtraHisVOs();
			if(vslSkdXtraHisVOs != null && vslSkdXtraHisVOs.size()>0)	command.createVesselScheduleExtraChangeHistory(vslSkdXtraHisVOs, "UPDATE_CST_ByBrthWdo(VOP_VSK_0017)");	
			//::by TOP:2015-05-08:://
			
			// :: VIPS START ::
			InterfaceScheduleToExternalBC 	ifCommand = new InterfaceScheduleToExternalBCImpl();
			ifCommand.createVskVipsIf		(cnvtToIfMst(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfDtl(command.getVslPortSkdList()), "U");
			// :: VIPS END ::
			
			//IBIS START
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			ibisIfCommand.createVskVslSkdIbisIfBackEndJob(cnvtToIfVskVslSkd(makePortToVsl(command.getVskVslSkdList(), command.getVslPortSkdList())), cnvtToIfVskVslPortSkd(command.getVslPortSkdList()), "VskVslSkd");
			//IBIS END

		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0003, VOP_VSK_0053 : M/Calculation<br>
	 * Calculating P/F Schedule Manually<br>
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
			} else {
				grpVO = new PfSkdGRPVO();
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
			if(detailVOs != null) {
				eventResponse.setRsVoList(detailVOs);
			}
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
	 * VOP_VSK_0003, VOP_VSK_0053 : Save<br>
	 * Creating P/F Simulation<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createRqstSimScnrCfm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PfSkdGRPVO grpVO = null;

		if(e instanceof VopVsk0003Event){
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
		} else {
			grpVO = new PfSkdGRPVO();
		}
		
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		
		try{
			begin();
			
			command.confirmSimScnr(grpVO, account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
		
			commit();
			
			//IBIS START
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			ibisIfCommand.createVskPfSkdIbisIfBackEndJob(cnvtToIfVskPfSkd(makeSlanToSvcTypeIbis(command.getPfSkdList(), command.getVskPfSkdDtlList())), cnvtToIfVskPfSkdDtl(command.getVskPfSkdDtlList()), "VskPfSkd");
			//IBIS END
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
	 * VOP_VSK_0015 : Save<br>
	 * Creating and Changing inputted Recovery Vessel Schedule
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
			String simCode = "";
			if(swapCstSkdSimVOs != null) {
			 command.manageCstSkdSim(swapCstSkdSimVOs, account);
			}
			if(VSKGeneralUtil.isNotNull(simCode)){
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage() + "-" + simCode);
			}else{
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
	 * Setting Simulation Schedule to Coastal Schedule
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
			String simCode = "";
			VslSkdChgStsGRPVO vslSkdChgStsGRPVO = new VslSkdChgStsGRPVO();
			if(swapCstSkdSimVOs != null) {
				command.manageCstSkdSim(swapCstSkdSimVOs, account);
				if(paramVOs != null) {
					vslSkdChgStsGRPVO = command.manageSettleByVvd(paramVOs, swapCstSkdSimVO, account);
				}
			}
			
			//Transmitting changed SKD to Booking
			sendBkgByVslSkdChg(vslSkdChgStsGRPVO);
			
			//Transmitting changed SKD to COP
			sendCopByVslSkdChg(vslSkdChgStsGRPVO);
			
			if(VSKGeneralUtil.isNotNull(simCode)){
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage() + "-" + simCode);
			}else{
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
	 * VOP_VSK_0015 : Skip<br>
	 * Retrieving info for Skip Call<br>
	 * From ~ To Port Distance, Port Expense, etc.
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
		} else {
			paramVO = new CstSkdSimDtlCalcInfoVO();
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
	 * Retrieving Distance with Port Pair
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
		} else {
			yardVO = new YardVO();
			vskPortDistVO = new VskPortDistVO();
			paramVO = new CstSkdSimDtlCalcInfoVO();
		}
		
		
		//***********************************************************************
		try{
			
			VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl();
			List<YardVO> yardList = null;
			String chkPort = vskCodeFinderBC.checkPort(yardVO.getLocCd());
			
//			if(chkPort == null || "".equals(chkPort)){
			if("".equals(chkPort)){
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
			
			
			
			//::2015-04-25 by top temporary comment starting:://
			////List<VskPortDistVO> distList = command.searchVskPortDist(vskPortDistVOs);
			
/*			if(distList != null && distList.size()>0){
				sb = new StringBuilder();
				
				VskPortDistVO vo = distList.get(0);
				
				sb.append(vo.getStndDist());
				for (int i = 1; i < distList.size(); i++) {
					sb.append("|");
					sb.append(distList.get(i).getStndDist());
				}
	
				eventResponse.setETCData("stnd_dist", sb.toString());
			}*/
			//::2015-04-25 by top temporary comment finished:://
			
			
			
			//***********************************************************************
			
			//***********************************************************************
			//LNK_DIST(PORT_DIST), Manu In/Out, PORT_BUF_HRS, CRN_KNT, TML_PROD_QTY, SPD, Time Diff
//			swapCstGRPVO.setVslCd(swapCstSkdSimVO.getVslCd());
//			swapCstGRPVO.setPortCd(yardVO.getLocCd());
//			swapCstGRPVO.setYardCd(yardCd);
//			SwapCstSkdSimVO rtnVO = command.searchAddCallInfo(paramVO);
			

			CstSkdSimDtlCalcInfoVO 	returnVO 		= command.searchAddCallInfo(paramVO);

			//*******************************************************************************************************
			eventResponse.setETCData("lnk_dist"		, returnVO.getPortDist	());	//LINK DIST
			eventResponse.setETCData("lnk_spd"		, returnVO.getSpd		());	//SPD
			eventResponse.setETCData("tztm_hrs"     , returnVO.getTztmHrs	());	//SEA HOURS
			//-----------------------------------------------------------------------
			eventResponse.setETCData("time_diff"	, returnVO.getTimeDiff	());	//Time Diff
			eventResponse.setETCData("mnvr_in_hrs"	, returnVO.getMnvrInHrs	());	//Manu In
			eventResponse.setETCData("mnvr_out_hrs"	, returnVO.getMnvrOutHrs());	//Manu Out
			eventResponse.setETCData("crn_knt"		, returnVO.getCrnKnt	());	//TMNL Prod(CRANE_QTY)
			eventResponse.setETCData("tml_prod_qty"	, returnVO.getTmlProdQty());	//TMNL Prod
			eventResponse.setETCData("port_buf_hrs"	, returnVO.getPortBufHrs());	//Port Buffer Time(PORT_BUF_TIME)
			eventResponse.setETCData("ttl_chg_amt"	, returnVO.getTtlChgAmt	());
			//*******************************************************************************************************
			
	//		List<SwapCstSkdSimVO> list = null;
			if(yardList != null) {
				eventResponse.setRsVoList(yardList);
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0015 : Yard Code Change after Add Call <br>
	 * Retrieving Port Charge<br>
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
		} else {
			paramVO = new CstSkdSimDtlCalcInfoVO();
			yardVO = new YardVO();
		}
		
		list = codeCommand.searchYardList(yardVO);
		
		if(list != null && list.size() > 0){
			
			// in case maneuvering time of yard is not registered in VSK_PORT_MNVR
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
	 * VOP_VSK_0015 : Add, Reverse<br>
	 * Retrieving Distance with Port Pair<br>
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
		if(list != null) {		
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0020 : Retrieve<br>
	 * Retrieving Vessel Port SKD per (Weekly, Monthly) POL, POD
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
		} else {
			cstSkdByPolPodVO = new CstSkdByPolPodVO();
		}
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<CstSkdByPolPodVO> list = command.searchCstSkdByPolPod(cstSkdByPolPodVO);
		
		//====================================================================
		VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl(); 
		yardVO.setLocCd(cstSkdByPolPodVO.getPolPort());
		polYardList = vskCodeFinderBC.searchYardListByPort(yardVO);
		yardVO.setLocCd(cstSkdByPolPodVO.getPodPort());
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
	 * Retrieving Coastal SKD of Port per Period<br>
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
		} else {
			cstSkdByPortVO = new CstSkdByPortVO();
		}
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		List<CstSkdByPortVO> list = command.searchCstSkdByPort(cstSkdByPortVO);
		
		//====================================================================
		VSKCodeFinderBC vskCodeFinderBC = new VSKCodeFinderBCImpl(); 
		yardVO.setLocCd(cstSkdByPortVO.getVpsPortCd());
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
	 * Retrieving Distance with Port Pair<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdSimBaseInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SwapCstSkdSimVO swapCstSkdSimVO = new SwapCstSkdSimVO();
		
		//by top//SwapCstSkdSimVO rtnVO = null;
		
		CstSkdSimDtlCalcInfoVO	rtnVO	= null;
		
		//by top//SwapCstGRPVO swapCstGRPVO = new SwapCstGRPVO();
		CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO = new CstSkdSimDtlCalcInfoVO();
		
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
		} else {
			vskPortDistVO = new VskPortDistVO();
			yardVO = new YardVO();
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
			String chkPort = vskCodeFinderBC.checkPort(yardVO.getLocCd());
			
//			if(chkPort == null || "".equals(chkPort)){
			if("".equals(chkPort)){
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
			cstSkdSimDtlCalcInfoVO.setVslCd(swapCstSkdSimVO.getVslCd());
			cstSkdSimDtlCalcInfoVO.setLocCd(yardVO.getLocCd());
			cstSkdSimDtlCalcInfoVO.setYdCd(yardCd);
			
			rtnVO = command.searchCstSkdSimBaseInfo(cstSkdSimDtlCalcInfoVO);
			
			eventResponse.setETCData("lnk_spd", rtnVO.getSpd());				//SPD
			eventResponse.setETCData("time_diff", rtnVO.getTimeDiff());			//Time Diff
			eventResponse.setETCData("mnvr_in_hrs", rtnVO.getMnvrInHrs());		//Manu In
			eventResponse.setETCData("mnvr_out_hrs", rtnVO.getMnvrOutHrs());	//Manu Out
			eventResponse.setETCData("crn_knt", rtnVO.getCrnKnt());				//TMNL Prod(CRANE_QTY)
			eventResponse.setETCData("tml_prod_qty", rtnVO.getTmlProdQty());	//TMNL Prod
			eventResponse.setETCData("port_buf_hrs", rtnVO.getPortBufHrs());	//Port Buffer Time(PORT_BUF_TIME)
			//***********************************************************************
			
	//		List<SwapCstSkdSimVO> list = null;
			if(yardList != null) {
				eventResponse.setRsVoList(yardList);
			}
		}catch(EventException ex){
			throw new EventException(ex.getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * searchCstSkdSimBaseInfo, searchVskPortDist : Call
	 * Setting parameter for VSK_PORT_DIST
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
	 * Retrieving Bunker Additional Cost of Coastal SKD Simulation
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
		} else {
			paramVO = new CstSkdSimDtlCalcInfoVO();
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
	 * Checking Port Code is exist 
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
		} else {
			mdmLocationVO = new MdmLocationVO();
		}
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		String chkPort = command.checkPort(mdmLocationVO.getLocCd());
		
		eventResponse.setETCData("check_port", chkPort);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0065 : Retrieve<br>
	 * Retrieving VSL SKD History
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstSkdHisByVvd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VvdPortLaneOtherVO vvdPortLaneOtherVO = null;
		List<VskVslSkdHisVO> list = null;
		
		if(e instanceof VopVsk0065Event){
			VopVsk0065Event event = (VopVsk0065Event)e;
			vvdPortLaneOtherVO = event.getVvdPortLaneOtherVO();
		} else {
			vvdPortLaneOtherVO = new VvdPortLaneOtherVO();
		}
		
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		list = command.searchCstSkdHisByVvd(vvdPortLaneOtherVO);
		
		eventResponse.setETCData("chg_sts_cd", VSKGeneralUtil.comnCodeList("CD01831", "onlycode"));
		eventResponse.setETCData("chg_sts_nm", VSKGeneralUtil.comnCodeList("CD01831", "onlyname"));
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0065 : Retrieve<br>
	 * Retrieving Actual SKD History
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
		} else {
			vvdPortLaneOtherVO = new VvdPortLaneOtherVO();
		}
		
		ActualScheduleMgtBC command = new ActualScheduleMgtBCImpl();
		list = command.searchActPortSkdHis(vvdPortLaneOtherVO);
		
		eventResponse.setETCData("chg_sts_cd", VSKGeneralUtil.comnCodeList("CD01831", "onlycode"));
		eventResponse.setETCData("chg_sts_nm", VSKGeneralUtil.comnCodeList("CD01831", "onlyname"));
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0247 : Open
	 * Retrieving Bay Plan Input Port
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
		} else {
			paramVO = new VskVslPortSkdVO();
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
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0247 : Open
	 * Calculating and Retrieving max Load Weight by ETA, ETD
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
			sb.append("|"+loadWgtVOList.get(0).getCol07());
		}else{
			sb.append(" | | | | | | ");
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
	 * Auto Simulating P/F Schedule<br>
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
		//Setting 0053 - B, 0001,0003 - A
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
		if(detailVOs!=null) {
			eventResponse.setRsVoList(detailVOs);
		}
		eventResponse.setETCData("ydCd", sb.toString());
		eventResponse.setETCData("etcdt", sb2.toString());
		eventResponse.setUserMessage(new ErrorHandler("VSK09001").getUserMessage());
		return eventResponse;
	}
	
	/**
	 * Creating Header
	 * 
	 * @param List<PfSkdDetailVO> pfSkdDetailVOs
	 * @param int headerIdx
	 * @param GeneralEventResponse eventResponse
	 * @exception EventException
	 */
	private void makeHeader(List<PfSkdDetailVO> pfSkdDetailVOs, int headerIdx, GeneralEventResponse eventResponse) throws EventException {
		
		try {
			
			if(pfSkdDetailVOs == null)	return;
			
			StringBuilder headTitle1 = null; // SKD_DIR_CD
			StringBuilder headTitle2 = null; // VPS_PORT_CD
			StringBuilder headTitle3 = null; // ETB_DY_CD
			StringBuilder headTitle4 = null; // ETB_TM_HRMNT
			StringBuilder headTitle5 = null; // CLPT_IND_SEQ	
			StringBuilder headTitle6 = null; // YD_CD
			StringBuilder headTitle7 = null; // CALL_YD_IND_SEQ
			
			headTitle1 = new StringBuilder("");
			headTitle2 = new StringBuilder("");
			headTitle3 = new StringBuilder("");
			headTitle4 = new StringBuilder("");
			headTitle5 = new StringBuilder("");
			headTitle6 = new StringBuilder("");
			headTitle7 = new StringBuilder("");
			
			for(PfSkdDetailVO vo : pfSkdDetailVOs){
				
				headTitle1.append("|").append(vo.getSkdDirCd()).append("|").append(vo.getSkdDirCd());
				headTitle2.append("|").append(vo.getPortCd()).append("|").append(vo.getPortCd());
				headTitle3.append("|").append(vo.getEtbDyCd()).append("|").append(vo.getEtdDyCd());
				
				if(vo.getEtbTmHrmnt() != null && vo.getEtbTmHrmnt().length()>2){
					headTitle4.append("|").append(vo.getEtbTmHrmnt().substring(0, 2)).append("|").append(vo.getEtdTmHrmnt().substring(0, 2));
				}else{
					headTitle4.append("|").append(vo.getEtbTmHrmnt()).append("|").append(vo.getEtdTmHrmnt());
				}
				headTitle5.append("|").append(vo.getClptSeq()).append("|").append(vo.getClptSeq());	
				headTitle6.append("|").append(vo.getYdCd()).append("|").append(vo.getYdCd());
				headTitle7.append("|").append(vo.getCallYdIndSeq()).append("|").append(vo.getCallYdIndSeq());
				
				// Showing 2 columns to 1 port at UI
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
	 * Retrieving Long Range Schedule<br>
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
			
			PortSkdOnLongRangeVO 				portSkdOnLongRangeVO 	= event.getPortSkdOnLongRangeVO();
			
			LongRangeSkdInqGRPVO 				longRangeSkdInqGRPVO 	= command.searchPortSkdOnLongRange(portSkdOnLongRangeVO);
			//Map<String, List<PfSkdDetailVO>> pfSkdDetails = longRangeSkdInqGRPVO.getPfSkdDetails();
			Map<String, List<PfSkdDetailVO>> 	pfSkdDetailsByGroup 	= longRangeSkdInqGRPVO.getPfSkdDetailsByGroup();
			List<List<PortSkdOnLongRangeVO>> 	portSkdOnLongRangeVOs 	= longRangeSkdInqGRPVO.getPortSkdVOs();
			
			if(portSkdOnLongRangeVOs==null || portSkdOnLongRangeVOs.size()==0){
				eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Schedule"}).getMessage());				
			}else{

				// Registering Remark at EventResponse
				eventResponse.setRsVoList				(longRangeSkdInqGRPVO.getRemarks());
				
				PortSkdOnLongRangeVO 					portSkdVO 			= null;
				List<List<List<PortSkdOnLongRangeVO>>> 	groupByPfSkdType 	= longRangeSkdInqGRPVO.getPortSkdVOsByPf();
				
				// portSkdByPf ( List<PortSkdOnLongRangeVO> ) ==> a row in a grid ==> rowData( List<LongRangeSkdInqVO> type )
				// samePfSkdTypeVVDsData ( List<List<PortSkdOnLongRangeVO>> ) ==> a grid  ==> gridData ( rowData + rowData ... type)
				
				int pfGroupCnt = 1;
				
				for(List<List<PortSkdOnLongRangeVO>> samePfSkdTypeVVDs : groupByPfSkdType){
					
					List<PortSkdOnLongRangeVO> 	portSkdByPf = null;
					List<LongRangeSkdInqVO> 	rowData 	= null; 
					List<LongRangeSkdInqVO> 	gridData 	= new ArrayList<LongRangeSkdInqVO>();
					List<PfSkdDetailVO> 		pfSkds 		= null;
					LongRangeSkdInqVO 			inqVO 		= null;
					
					for(int i=0; i<samePfSkdTypeVVDs.get(0).size(); i++){
						portSkdVO = samePfSkdTypeVVDs.get(0).get(i);
						if(!portSkdVO.isEmptySkd()){
							break;
						}
					}
					
					
					/** samePfSkdTypeVVDs processing STARTED **/
					for(int i=0; i<samePfSkdTypeVVDs.size(); i++){
						
						portSkdByPf = samePfSkdTypeVVDs.get(i); //new ArrayList<PortSkdOnLongRangeVO>();
						
						if(i==0){
							if(portSkdVO != null) {
								pfSkds = pfSkdDetailsByGroup.get(portSkdVO.getVslSlanCd() + portSkdVO.getPfSkdTpCd() + portSkdVO.getVslCd() + portSkdVO.getSkdVoyNo());
							} 
							
							if(pfSkds != null)	this.makeHeader(pfSkds, pfGroupCnt++, eventResponse);
						}
						
						rowData = new ArrayList<LongRangeSkdInqVO>();
						
						confirmCreUsrInfo(portSkdByPf);
						
						if(pfSkds != null){
							
							for(int m=0; m<pfSkds.size(); m++){
							//:2016-11-01://for(int m=0; m<portSkdByPf.size(); m++){//:Back to original because broken grid://
									
								inqVO 				= new LongRangeSkdInqVO();
								portSkdVO 			= portSkdByPf.get(m);
								
								inqVO.setVslSlanCd	(portSkdVO.getVslSlanCd	());
								inqVO.setPfSkdTpCd	(portSkdVO.getPfSkdTpCd	());
								inqVO.setVslCd		(portSkdVO.getVslCd		());
								inqVO.setSkdVoyNo	(portSkdVO.getSkdVoyNo	());
								inqVO.setObCssmVoyNo(portSkdVO.getObCssmVoyNo());
								inqVO.setSkdDirCd	(portSkdVO.getSkdDirCd	());
								inqVO.setVpsPortCd	(portSkdVO.getVpsPortCd	());
								inqVO.setClptSeq	(portSkdVO.getClptSeq	());
								inqVO.setClptIndSeq	(portSkdVO.getClptIndSeq());
								
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
								
								rowData.add			(inqVO);
							}	
							
							gridData.addAll(rowData);
							
							////log.info("\n\n TOP.TOP.TOP i vs samePfSkdTypeVVDs.size() vs ["+i+"] ["+samePfSkdTypeVVDs.size()+"]  gridData.size ["+gridData.size()+"]  <<< P/F TYPE ["+portSkdByPf.get(0).getPfSkdTpCd()+"]\n\n");
							
							////////////////////////////////////////////////////////////////////////////////
							if(i+1 != samePfSkdTypeVVDs.size()){
								gridData.add(null); 			/** Adding Null row to split to each VVD for LongRangeInqViewAdapter **/
								
								////log.info("\n\n INNER ADDING ONE ROW *** TOP.TOP.TOP i vs samePfSkdTypeVVDs.size() vs ["+i+"] ["+samePfSkdTypeVVDs.size()+"] gridData.size ["+gridData.size()+"]\n\n");
								
							}
							////////////////////////////////////////////////////////////////////////////////
							
						}
						
						
					}
					////gridData.add(null); 		//::Adding empty row to split seperately in LongRangeInqViewAdapter class:://
					
					/** samePfSkdTypeVVDs processing FINISHED **/
					
					
					eventResponse.setRsVoList(gridData);
				}
				
				Map<String, String> portNms 		= longRangeSkdInqGRPVO.getPortNms();
				Map<String, String> vslEngNms 		= longRangeSkdInqGRPVO.getVslEngNms();
				
				StringBuffer 		portNmEtcData 	= new StringBuffer();
				StringBuffer 		vslEngNmEtcData = new StringBuffer();
				
				ArrayList<String> arrPortNms = new ArrayList<String>();
				if(portNms!=null){
					for(Iterator<String> i = portNms.keySet().iterator(); i.hasNext(); ){
						StringBuffer portNmEtcTemp = new StringBuffer();
						String key = i.next();
//						portNmEtcData.append(key).append("|").append(portNms.get(key));
						portNmEtcTemp.append(key).append("|").append(portNms.get(key));
//						if(i.hasNext()){
//							portNmEtcData.append(";");
//						}
						arrPortNms.add(portNmEtcTemp.toString());
					}
					Collections.sort(arrPortNms); // PortCode Sort
					for(int j=0; j<arrPortNms.size();j++){
						portNmEtcData.append(arrPortNms.get(j).toString());
						if(j<arrPortNms.size()-1){
						 portNmEtcData.append(";");
						}
					}
				}
				
				if(vslEngNms!=null){
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
	 * Retrieving the oldest Create info and the newest update info, Reflecting it to all SKD in list
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
			if(vo != null) {
				vo.setCreDt(creDt);
				vo.setCreUsrId(creUsrId);
				vo.setUpdDt(updDt);
				vo.setUpdUsrId(updUsrId);
			}
		}
		
	}
	
	/**
	 * VOP_VSK_0053 : Retrieve
	 * Checking Lane Code is invalid, and Dir_Cd<br>
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
	 * Retrieving Booking List linked VVD
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
	 * Auto Closing by Vessel Schedule
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

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			if(vos != null) {
				begin();
				command.manageVslSkdListByLane(vos, account);
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
				commit();
				
				// IBIS START
				InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
				ibisIfCommand.createVskVslSkdIbisIfBackEndJob(cnvtToIfVskVslSkd(command.getVskVslSkdList()), null, "VskVslSkd");
				//IBIS END
			}
		}catch(EventException ex){
			rollback();
			eventResponse.setUserMessage(new ErrorHandler("VSK09003").getUserMessage());
			throw ex;
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0018 : SKD Activate
	 * VOP_VSK_0059 : SKD Activate
	 * 
	 * Activating Vessel Schedule
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
		} else {
			activationVvdVO = new ActivationVvdVO();
		}

		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.manageSkdActivate(activationVvdVO, account);
			eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
			commit();
			
			// IBIS START
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			ibisIfCommand.createVskVslSkdIbisIfBackEndJob(cnvtToIfVskVslSkd(command.getVskVslSkdList()), null, "VskVslSkd");
			//IBIS END

		}catch(EventException ex){
			rollback();
			eventResponse.setUserMessage(new ErrorHandler("VSK09003").getUserMessage());
			throw ex;
		}
		return eventResponse;
	}
	
	/**
	 * ESD061-0001 : Receive<br>
	 * Receiving Noon Report from VMS(Vessel Management System)
	 * 
	 * @param  e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createNoonReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskNoonRptVO[] vskNoonRptVOs = null;
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		
		if(e instanceof VopVskESD0610001Event){
			VopVskESD0610001Event event = (VopVskESD0610001Event)e;
			vskNoonRptVOs = event.getVskNoonRptVOs();
		}
		
		try{
			if(vskNoonRptVOs != null) {
				begin();
				command.createNoonReport(vskNoonRptVOs);
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
				
				commit();
			}
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
	 * ESD062-0001 : Receive<br>
	 * Receiving Departure Report from VMS(Vessel Management System)
	 * 
	 * @param  e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createDepartureReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VskDepRptVO[] vskDepRptVOs = null;
		CoastalScheduleMgtBC command = new VesselScheduleMgtBCImpl();
		
		if(e instanceof VopVskESD0620001Event){
			VopVskESD0620001Event event = (VopVskESD0620001Event)e;
			vskDepRptVOs = event.getVskDepRptVOs();
		}
		
		try{
			
			if(vskDepRptVOs != null) {
				begin();
				command.createDepartureReport(vskDepRptVOs);
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());
				
				commit();
			}
			
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
	 * VOP_VSK_0024 : Retrieve<br>
	 * Retrieving Canal Transit List and Surcharge
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
		
//		if(list.size()==0){
//			eventResponse.setUserMessage(new ErrorHandler("VSK10018", new String[]{"Canal Transit Surcharge"}).getUserMessage());
//		}
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0024 : Window Open<br>
	 * Retrieving Vendor<br>
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
	 * Transmitting Canal Transit List and Surcharge to SPP
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
			String targetDate = canalTransitTargetVvdVO.getStartDate().substring(0, 7); // YYYY-MM
			
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
	 * VOP_VSK_0246 : Window OPEN<br>
	 * Retrieving different between Bunker Charge of Max speed and Canal Surcharge
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
	 * VOP_VSK_0003 : Retrieve<br>
	 * Retrieving Port<br>
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
		
		if(e instanceof VopVsk0003Event){
			VopVsk0003Event event = (VopVsk0003Event)e;
			pfSkdVO = event.getPfSkdVO();
			yardVO = new YardVO();
			yardVO.setLocCd(pfSkdVO.getLocCd());
		} else {
			pfSkdVO = new PfSkdVO();
			yardVO = new YardVO();
		}
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();
		ProformaScheduleMgtBC proformaCommand = new ProformaScheduleMgtBCImpl();
		
		String chkPort = command.checkPort(pfSkdVO.getLocCd());
		
//		if(chkPort != null && !"".equals(chkPort)){	
		if(!"".equals(chkPort)){	
			list = command.searchYardListByPort(yardVO);
			
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
	
			if(list != null && list.size() > 0){
				if(e instanceof VopVsk0003Event ||e instanceof VopVsk0053Event){
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
			int portCnt = Integer.parseInt(pfSkdVO.getPortInfoCnt());
			String dataPos = pfSkdVO.getDataPos();

			if(portCnt == 1){
				PfSkdVO paramVO = new PfSkdVO();
				if("S".equals(dataPos)){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("T".equals(dataPos)){
					paramVO.setPortCd(pfSkdVO.getSecondPortCd());
					paramVO.setPodLocCd(pfSkdVO.getThirdPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("F".equals(dataPos)){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}else if("E".equals(dataPos)){
					paramVO.setPortCd(pfSkdVO.getFirstPortCd());
					paramVO.setPodLocCd(pfSkdVO.getSecondPortCd());
					paramVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				}
				pfSkdVOs.add(paramVO);
			}else if(portCnt > 1){
				PfSkdVO firstParamVO = new PfSkdVO();
				firstParamVO.setPortCd(pfSkdVO.getFirstPortCd());
				firstParamVO.setPodLocCd(pfSkdVO.getSecondPortCd());
				firstParamVO.setChgLocCd(pfSkdVO.getSecondPortCd());
				pfSkdVOs.add(firstParamVO);
				PfSkdVO secondParamVO = new PfSkdVO();
				secondParamVO.setPortCd(pfSkdVO.getSecondPortCd());
				secondParamVO.setPodLocCd(pfSkdVO.getThirdPortCd());
				secondParamVO.setChgLocCd(pfSkdVO.getSecondPortCd());
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
				
				//count of data to show in grid
				eventResponse.setETCData("portInfoCnt", pfSkdVO.getPortInfoCnt());
				//setting current row of now port
				eventResponse.setETCData("currPos", pfSkdVO.getCurrPos());
				//because pre port is not exist, S = SELF
				eventResponse.setETCData("dataPos", pfSkdVO.getDataPos());
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
		if(list != null) {
			eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}
	
	/**
	 * VOP_VSK_0003, VOP_VSK_0053, VOP_VSK_0015 : Retrieve
	 * Retrieving Yard
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
		
		if(e instanceof VopVsk0003Event){
			VopVsk0003Event event = (VopVsk0003Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0053Event){
			VopVsk0053Event event = (VopVsk0053Event)e;
			yardVO = event.getYardVO();
		}else if(e instanceof VopVsk0015Event){
			VopVsk0015Event event = (VopVsk0015Event)e;
			yardVO = event.getYardVO();
		} else {
			yardVO = new YardVO();
		}
		
		VSKCodeFinderBC command = new VSKCodeFinderBCImpl();		
		list = command.searchYardList(yardVO);
		
		if(e instanceof VopVsk0015Event){
			if(list != null && list.size() > 0){
				// in case maneuvering time of yard is not registered in VSK_PORT_MNVR
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
	 * Deleting P/F Schedule
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
		} else {
			vskPfSkdVO = new VskPfSkdVO();
		}
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		
		try{
			begin();
			
			command.removePfSkd(vskPfSkdVO, account);

			eventResponse.setUserMessage(new ErrorHandler("VSK10026").getUserMessage());
			
			commit();
			
			//IBIS START
			InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
			ibisIfCommand.createVskPfSkdIbisIfBackEndJob(cnvtToIfVskPfSkd(makeSlanToSvcTypeIbis(command.getPfSkdList(), command.getVskPfSkdDtlList())), cnvtToIfVskPfSkdDtl(command.getVskPfSkdDtlList()), "VskPfSkd");
			//IBIS END
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
	 * VOP_VSk_0241 : Retrieve<br>
	 * Retrieving Lane Code is invalid
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
	 * VOP_VSK_0018 : Save<br>
	 * Modifying P/F Type of VVD
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
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
			if(activationVvdVOs != null) {
				for(ActivationVvdVO vo : activationVvdVOs){
					vo.setUpdUsrId(account.getUsr_id());
				}
				LongRangeScheduleMgtBC command = new VesselScheduleMgtBCImpl();
				command.manageVvdPf(activationVvdVOs);

				// IBIS START
				InterfaceScheduleToIBISBC ibisIfCommand = new InterfaceScheduleToIBISBCImpl();
				ibisIfCommand.createVskVslSkdIbisIfBackEndJob(cnvtToIfVskVslSkd(command.getVskVslSkdList()), null, "VskVslSkd");
				//IBIS END
				
			}
			
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
	 * VOP_VSK_000 : Row Delete<br>
	 * Deleting selected row(s), recombining information of existed ports
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
			} else {
				grpVO = new PfSkdGRPVO();
				masterVO = new VskPfSkdVO();
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
	 * VOP_VSK_0018 : crr_cd input<br>
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
	

//VOP_VSK_0001 ADD 2013-09-24 BY HWANG	
	
	/**
	 * VOP_VSK_0001 : Retrieve<br>
	 *  P/F Schedule Simulation ?筌먲퐢沅뽳옙占썽댖怨뚰�占쏙옙占쎈챶鍮�?
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
		//2009 12 30 ?熬곣뫕媛�옙占�占쎈ㅎ��?�븐슙��
		//L/F,RPB,G.REV,OP ?�⑥�逾�占쏙옙占썽댖怨뚰�占쏙옙占쎈베堉�
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

			//2009 12 30 ?熬곣뫕媛�옙占�占쎈ㅎ��?�븐슙��
			//L/F,RPB,G.REV,OP ?�⑥�逾�占쏙옙占썽댖怨뚰�占쏙옙占쎈베堉�
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
	 * VOP_VSk_0001 : P/F Type Cd Change??br>
	 * P/F Type Cd�띠럾占썽댖怨뺣샍占쏙옙占쎈∥裕됬춯�뽳옙?占�.<br>
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
		} else {
			vskPfSkdVO = new VskPfSkdVO();
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		String checkPfTypeData = command.checkPfType(vskPfSkdVO);

		if(!"".equals(checkPfTypeData)){
			eventResponse.setETCData("pfTypeData", checkPfTypeData);
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
	/*private EventResponse createCoaSimRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LaneSimulationBC command = new LaneSimulationBCImpl();
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
			List<CoaSimInfoVO>  coaSimInfoVOs = command.createCoaSimRqst(grpVO, newSimData, account);
			if(coaSimInfoVOs != null && coaSimInfoVOs.size() > 0){

				String simDt = coaSimInfoVOs.get(0).getSimDt();
				String simNo = coaSimInfoVOs.get(0).getSimNo();

				eventResponse.setETCData("simDt", simDt);
				eventResponse.setETCData("simNo", simNo);
				eventResponse.setUserMessage(new ErrorHandler("VSK10016").getUserMessage());

			}

			commit();

		}catch(EventException ex){
			rollback();

			throw ex;
		}

		return eventResponse;
	}*/
	
	/**
	 * VOP_VSK_0238 : Open
	 *
	 * P/F SKD Simulation  �リ옇�ч뜮�낆�占썹솻占�Berth window ?筌먲퐢沅뽳옙占썽댖怨뚰�占쏙옙占쎈챶鍮�?
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
	
	/**
	 * VOP_VSK_0243 : Retrieve<br>
	 * ?��?�됱뵠?�륁뱽 ?�랁� ?�덈뮉 Proforma Type???�됯맒 ?類ㅻ뻻?�μ뱽 鈺곌퀬���뺣뼄.<br>
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
		} else {
			grpVO = new PfSkdGRPVO();
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
	 * ?��?�됱뵠?�륁뱽 ?�랁� ?�덈뮉 Proforma Type???�됯맒 ?類ㅻ뻻?�μ뱽 鈺곌퀬���뺣뼄.<br>
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
		} else {
			grpVO = new PfSkdGRPVO();
		}

		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		PfSkdEotpGRPVO rtnGRPVO = command.searchPfSkdEotpDtl(grpVO);

		//List<PfSkdEotpSummaryVO> summaryVO = rtnGRPVO.getPfSkdEotpSummaryVOs();
		List<PfSkdEotpDtlVO> detailVO = rtnGRPVO.getPfSkdEotpDetailVOs();


		//eventResponse.setRsVoList(summaryVO);
		eventResponse.setRsVoList(detailVO);

		return eventResponse;
	}
	
private StringBuilder checkStringBuilder(StringBuilder sbA, StringBuilder sbB, int typ){
		
		String tmpBuf = "";
		if(!sbA.equals(sbB)){
			String strA = new String();
			String strB = new String();
			strA = sbA.toString();
			strB = sbB.toString();
						
			String[] arrA= strA.split("\\|");
			String[] arrB= strB.split("\\|");
			
			for(int i=0 ; i<arrA.length ; i++){
				if(!arrA[i].equals(arrB[i])){
					if(typ == 0)
						arrA[i] = "*"+arrA[i];
					else if(typ == 1)
						arrA[i] = arrA[i] + "/" + arrB[i] ;
					else 
						arrA[i] = "*";
				}
				if(i == 0){
					tmpBuf = tmpBuf + arrA[i];
				}else{
					tmpBuf = tmpBuf + "|" + arrA[i];
				}
			}
			sbA= new StringBuilder(tmpBuf);
		}
		
		return sbA;
	}

	/**
	 * VOP_VSK_0057 : PortRotnSeq Check<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPortRotnSeq(Event e) throws EventException {
		String result = "F";
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ProformaScheduleMgtBC command = new ProformaScheduleMgtBCImpl();
		
		VopVsk0057Event event = (VopVsk0057Event)e;
		CstSkdByVvdVO[] vvdVOs = event.getCstSkdByVvdVOS();
		CstSkdByVvdVO vvdVO = event.getCstSkdByVvdVO();
		
		if(vvdVOs != null && vvdVOs.length > 0) {
			int index = -1;
			for(int i=0;i<vvdVOs.length;i++) {
				if(!vvdVOs[i].getIbflag().equals("D")) {
					index = i;
					break;
				}
			}
			if(index>=0) {
				CstSkdByVvdVO vo = vvdVOs[index];
				PfSkdVO pfSkdVO = new PfSkdVO();
				pfSkdVO.setVslSlanCd(vvdVO.getVslSlanCd());
				pfSkdVO.setPfSvcTpCd(vvdVO.getPfSvcTpCd());
				List<PfSkdVO> list = command.searchPfSkd(pfSkdVO);
				if(list!=null && list.size() > 0) {
					PfSkdVO first = list.get(0);
					if(vo.getSkdDirCd().equals(first.getSkdDirCd())
							&& vo.getVpsPortCd().equals(first.getPortCd())
							&& vo.getTurnPortFlg().equals(first.getTurnPortFlg())
						    && vo.getTmlCd().equals(first.getTempYdCd())) {
						result= "T";
					}
				}
			}
		}
		
		eventResponse.setETCData("result", result);
		return eventResponse;
	}
	
	// :: VIPS START ::
	/**
	 * VskVslSkdVO瑜�VskVipsIfMstVO濡�蹂�솚�쒕떎.
	 * @param List<VskVslSkdVO> vskVslSkdList
	 * @return List<VskVipsIfHdrVO>
	 */
//	private List<VskVipsIfHdrVO> cnvtToIfHdr(List<VskVslSkdVO> vskVslSkdList) {
//		
//		List<VskVipsIfHdrVO> vskVipsIfHdrList = new ArrayList<VskVipsIfHdrVO>();
//		String preVoyage	= "";
//		String curVoayge	= "";
//		
//		for(int i=0;i<vskVslSkdList.size();i++) {
//			VskVslSkdVO vo = (VskVslSkdVO) vskVslSkdList.get(i);
//			
//			curVoayge	= vo.getVslCd() + vo.getSkdVoyNo();
//			
//			if(!curVoayge.equals(preVoyage)){
//				
//				VskVipsIfHdrVO vskVipsIfHdrVO 	= new VskVipsIfHdrVO();
//				
//				vskVipsIfHdrVO.setVslCd			(vo.getVslCd		());
//				vskVipsIfHdrVO.setSkdVoyNo		(vo.getSkdVoyNo		());
//				
//				vskVipsIfHdrList.add			(vskVipsIfHdrVO);				
//			}
//			
//			preVoyage	= curVoayge;
//
//		}
//		return vskVipsIfHdrList;
//	}
	
	
	/**
	 * VskVslSkdVO瑜�VskVipsIfMstVO濡�蹂�솚�쒕떎.
	 * @param List<VskVslSkdVO> vskVslSkdList
	 * @return List<VskVipsIfMstVO>
	 */
	private List<VskVipsIfMstVO> cnvtToIfMst(List<VskVslSkdVO> vskVslSkdList) {
		List<VskVipsIfMstVO> vskVipsIfMstList = new ArrayList<VskVipsIfMstVO>();
		for(int i=0;i<vskVslSkdList.size();i++) {
			VskVslSkdVO vo = (VskVslSkdVO) vskVslSkdList.get(i);
			VskVipsIfMstVO vskVipsIfMstVO 	= new VskVipsIfMstVO();
			vskVipsIfMstVO.setSkdDirCd		(vo.getSkdDirCd		());
			vskVipsIfMstVO.setSkdVoyNo		(vo.getSkdVoyNo		());
			vskVipsIfMstVO.setVslCd			(vo.getVslCd		());
			vskVipsIfMstVO.setVslSlanCd		(vo.getVslSlanCd	());
			vskVipsIfMstVO.setPfSvcTpCd		(vo.getPfSkdTpCd	());
			
			vskVipsIfMstList.add			(vskVipsIfMstVO);
		}
		return vskVipsIfMstList;
	}
	
	/**
	 * VslPortSkdVO瑜�VskVipsIfDtlVO濡�蹂�솚�쒕떎.
	 * @param List<VslPortSkdVO> vslPortSkdList
	 * @return List<VskVipsIfDtlVO>
	 */
	private List<VskVipsIfDtlVO> cnvtToIfDtl(List<VskVslPortSkdVO> vslPortSkdList){
		List<VskVipsIfDtlVO> vskVipsIfDtlList = new ArrayList<VskVipsIfDtlVO>();

		List<String> portList = new ArrayList<String>();
		for(int i=0;i<vslPortSkdList.size();i++) {
			VskVslPortSkdVO vo = (VskVslPortSkdVO) vslPortSkdList.get(i);
			String vslPortKey = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd() 
				      + vo.getVpsPortCd() + vo.getClptIndSeq();
			if(!portList.contains(vslPortKey)) {
				portList.add(vslPortKey);
				VskVipsIfDtlVO vskVipsIfDtlVO = setIfDtl(vo);
				vskVipsIfDtlList.add(vskVipsIfDtlVO);
			}
		}
		return vskVipsIfDtlList;
	}
	
	/**
	 * VskActPortSkdVO,VskVslPortSkdVO瑜�VskVipsIfDtlVO濡�蹂�솚�쒕떎.
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
			// actual�뺣낫 �ㅼ젙
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
	 * makePortToVsl:port�뺣낫濡�Vessel�뺣낫瑜��묒꽦�쒕떎.
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
		// vsl�뺣낫媛��녿뒗 port��寃쎌슦 port濡�vsl�뺣낫瑜�留뚮뱺��
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
	 * makeSlanToSvcTypeIbis Vessel�뺣낫瑜��묒꽦�쒕떎.
	 * @param List<VskVslSkdVO> vslSkdList
	 * @param List<VskVslPortSkdVO> vslPortSkdList
	 * @return List<VskVslSkdVO>
	 * @throws Exception
	 */
	private List<PfSkdVO> makeSlanToSvcTypeIbis(List<PfSkdVO> vskPfSkdVOs, List<VskPfSkdDtlVO> vskPfSkdDtlVOs) throws Exception {
		List<PfSkdVO> vskPfSkdList = new ArrayList<PfSkdVO>();
		List<String> vvds = new ArrayList<String>();
		for(PfSkdVO vo : vskPfSkdVOs) {
			// duplication check(vessel info)
			String vvd = vo.getVslSlanCd() + vo.getPfSvcTpCd();
			if(!vvds.contains(vvd)) {
				vskPfSkdList.add(vo);
				vvds.add(vvd);
			}
		}
		// vsl�뺣낫媛��녿뒗 port��寃쎌슦 port濡�vsl�뺣낫瑜�留뚮뱺��
		for(VskPfSkdDtlVO vo : vskPfSkdDtlVOs) {
			// duplication check(vessel info)
			String vvd = vo.getVslSlanCd() + vo.getPfSvcTpCd();
			if(!vvds.contains(vvd)) {
				PfSkdVO vsl = new PfSkdVO();
				vsl.setVslSlanCd(vo.getVslSlanCd());
				vsl.setPfSvcTpCd(vo.getPfSvcTpCd());
				vsl.setIbflag(vo.getIbflag());
				vsl.setCreDt(vo.getCreDt());
				vskPfSkdList.add(vsl);
				vvds.add(vvd);
			}
		}
		return vskPfSkdList;
	}
	
	/**
	 * makePortToVsl:port�뺣낫濡�Vessel�뺣낫瑜��묒꽦�쒕떎.
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
		// vsl�뺣낫媛��녿뒗 port��寃쎌슦 port濡�vsl�뺣낫瑜�留뚮뱺��
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
	 * makePortToVsl:port�뺣낫濡�Vessel�뺣낫瑜��묒꽦�쒕떎.
	 * @param List<VskVslPortSkdVO> vslPortSkdList
	 * @return List<VskVslSkdVO>
	 * @throws Exception
	 */
	private List<VskVslSkdVO> makePortToVsl(List<VskVslPortSkdVO> vslPortSkdList) throws Exception {
		List<VskVslSkdVO> vskVslSkdList = new ArrayList<VskVslSkdVO>();
		List<String> vvds = new ArrayList<String>();
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
	 * mergeVslPortSkdList : �먭컻��PortList�먯꽌 以묐났���쒓굅�섏빞 �섎굹��PortList濡�留뚮뱺��
	 * @param List<VskVslPortSkdVO> vslPortSkdList1
	 * @param List<VskVslPortSkdVO> vslPortSkdList2
	 * @return List<VskVslPortSkdVO>
	 */
	private List<VskVslPortSkdVO> mergeVslPortSkdList(List<VskVslPortSkdVO> vslPortSkdList1, List<VskVslPortSkdVO> vslPortSkdList2) {
		
		List<VskVslPortSkdVO> 	portSkdList = new ArrayList<VskVslPortSkdVO>();
		Map<String, String> 	keys 		= new HashMap<String, String>(); // vvd, update_date
		
		
		for(VskVslPortSkdVO vo : vslPortSkdList1) {
			
			String key = vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd() + vo.getVpsPortCd() + vo.getClptIndSeq();
			if(!keys.containsKey(key)) { // 1st add
				portSkdList.add(vo);
				keys.put(key, vo.getUpdDt());
			} else {
				float vvdUpdateDt = 0;
				float currUpdateDt = 0;
				if(keys.get(key) != null && !"".equals(keys.get(key))) {
					vvdUpdateDt = Float.parseFloat(keys.get(key));
				}
				if(vo.getUpdDt() != null && !"".equals(vo.getUpdDt())) {
					currUpdateDt = Float.parseFloat(vo.getUpdDt());
				}
				//if(vvdUpdateDt < currUpdateDt) { // �꾩옱 �쎈뒗 �곗씠��� 理쒖떊��寃쎌슦, ��뼱�대떎.
				if(Float.compare(vvdUpdateDt, currUpdateDt)<0) { // �꾩옱 �쎈뒗 �곗씠��� 理쒖떊��寃쎌슦, ��뼱�대떎.
							
					for(int index=0;index < portSkdList.size();index++) {
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
		
		
		for(VskVslPortSkdVO vo2 : vslPortSkdList2) {
			
			String key = vo2.getVslCd() + vo2.getSkdVoyNo() + vo2.getSkdDirCd() + vo2.getVpsPortCd() + vo2.getClptIndSeq();
			if(!keys.containsKey(key)) { // 1st add
				portSkdList.add(vo2);
				keys.put(key, vo2.getUpdDt());
			} else {
				float vvdUpdateDt = 0;
				float currUpdateDt = 0;
				if(keys.get(key) != null && !"".equals(keys.get(key))) {
					vvdUpdateDt = Float.parseFloat(keys.get(key)==null||"".equals(keys.get(key))?"0.0f":keys.get(key));
				}
				if(vo2.getUpdDt() != null && !"".equals(vo2.getUpdDt())) {
					currUpdateDt = Float.parseFloat(vo2.getUpdDt()==null||"".equals(vo2.getUpdDt())?"0":vo2.getUpdDt());
				}
				//if(vvdUpdateDt < currUpdateDt) { // �꾩옱 �쎈뒗 �곗씠��� 理쒖떊��寃쎌슦, ��뼱�대떎.
				if(Float.compare(vvdUpdateDt, currUpdateDt)<0) { // �꾩옱 �쎈뒗 �곗씠��� 理쒖떊��寃쎌슦, ��뼱�대떎.
					for(int index=0;index < portSkdList.size();index++) {
						VskVslPortSkdVO listVO = portSkdList.get(index);
						String listVvd = listVO.getVslCd() + listVO.getSkdVoyNo() + listVO.getSkdDirCd();
						if(listVvd.equals(key)) {
							portSkdList.remove(index);
							break;
						}
					}
					portSkdList.add(vo2);
					keys.put(key, vo2.getUpdDt());
				}
			}
		}		
		
		return portSkdList;
	}
	// :: VIPS END ::
	
	private List<VskVslSkdIbisIfVO> cnvtToIfVskVslSkd(List<VskVslSkdVO> vslPortSkdList){
		List<VskVslSkdIbisIfVO> vskVslSkdIbisIfVOs = new ArrayList<VskVslSkdIbisIfVO>();

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
			vskVslSkdIbisIfVO.setCreUsrId	    (account.getUsr_id());
			vskVslSkdIbisIfVO.setCreDt	        (vskVslSkdVO.getCreDt());
			vskVslSkdIbisIfVO.setUpdUsrId	    (account.getUsr_id());
			vskVslSkdIbisIfVO.setUpdDt	        (vskVslSkdVO.getUpdDt());
			vskVslSkdIbisIfVO.setIbflag		    (vskVslSkdVO.getIbflag());
			vskVslSkdIbisIfVOs.add(vskVslSkdIbisIfVO);
		}
		
		return vskVslSkdIbisIfVOs;
	}
	
	private List<VskVslPortSkdIbisIfVO> cnvtToIfVskVslPortSkd(List<VskVslPortSkdVO> vslPortSkdList){
		List<VskVslPortSkdIbisIfVO> vskVslPortSkdIbisIfVOs = new ArrayList<VskVslPortSkdIbisIfVO>();
		
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
			vskVslPortSkdIbisIfVO.setCreUsrId	        (account.getUsr_id());
			vskVslPortSkdIbisIfVO.setCreDt	            (vskVslPortSkdVO.getCreDt());
			vskVslPortSkdIbisIfVO.setUpdUsrId	        (account.getUsr_id());
			vskVslPortSkdIbisIfVO.setUpdDt	            (vskVslPortSkdVO.getUpdDt());
			vskVslPortSkdIbisIfVO.setIbflag		    	(vskVslPortSkdVO.getIbflag());
			vskVslPortSkdIbisIfVOs.add(vskVslPortSkdIbisIfVO);
		}
		
		return vskVslPortSkdIbisIfVOs;
	}
	
	private List<VskPfSkdIbisIfVO> cnvtToIfVskPfSkd(List<PfSkdVO> vskPfSkdVOList){
		List<VskPfSkdIbisIfVO> vskPfSkdIbisIfVOs = new ArrayList<VskPfSkdIbisIfVO>();
		
		for(int i = 0 ; i < vskPfSkdVOList.size() ;i++) {
			PfSkdVO vskPfSkdVO = vskPfSkdVOList.get(i);
			VskPfSkdIbisIfVO vskPfSkdIbisIfVO = new VskPfSkdIbisIfVO();
		
			vskPfSkdIbisIfVO.setVslSlanCd     (vskPfSkdVO.getVslSlanCd());
			vskPfSkdIbisIfVO.setPfSvcTpCd     (vskPfSkdVO.getPfSvcTpCd());
			vskPfSkdIbisIfVO.setSlanStndFlg   (vskPfSkdVO.getSlanStndFlg());
			vskPfSkdIbisIfVO.setSvcDurDys     (vskPfSkdVO.getSvcDurDys());
			vskPfSkdIbisIfVO.setStndSvcSpd    (vskPfSkdVO.getStndSvcSpd());
			vskPfSkdIbisIfVO.setBrthItvalDys  (vskPfSkdVO.getBrthItvalDys());
			vskPfSkdIbisIfVO.setMmlUsdFlg     (vskPfSkdVO.getMmlUsdFlg());
			vskPfSkdIbisIfVO.setSimDt         (vskPfSkdVO.getSimDt());
			vskPfSkdIbisIfVO.setSimNo         (vskPfSkdVO.getSimNo());
			vskPfSkdIbisIfVO.setN1stVslClssCd (vskPfSkdVO.getN1stVslClssCd());
			vskPfSkdIbisIfVO.setN1stVslClssKnt(vskPfSkdVO.getN1stVslClssKnt());
			vskPfSkdIbisIfVO.setN2ndVslClssCd (vskPfSkdVO.getN2ndVslClssCd());
			vskPfSkdIbisIfVO.setN2ndVslClssKnt(vskPfSkdVO.getN2ndVslClssKnt());
			vskPfSkdIbisIfVO.setN3rdVslClssCd (vskPfSkdVO.getN3rdVslClssCd());
			vskPfSkdIbisIfVO.setPfSkdRmk      (vskPfSkdVO.getPfSkdRmk());
			vskPfSkdIbisIfVO.setN3rdVslClssKnt(vskPfSkdVO.getN3rdVslClssKnt());
			vskPfSkdIbisIfVO.setClptKnt       (vskPfSkdVO.getClptKnt());
			vskPfSkdIbisIfVO.setTtlDist       (vskPfSkdVO.getTtlDist());
			vskPfSkdIbisIfVO.setMaxSpd        (vskPfSkdVO.getMaxSpd());
			vskPfSkdIbisIfVO.setAvgSpd        (vskPfSkdVO.getAvgSpd());
			vskPfSkdIbisIfVO.setDeltFlg       (vskPfSkdVO.getDeltFlg());
			vskPfSkdIbisIfVO.setCreUsrId      (account.getUsr_id());
			vskPfSkdIbisIfVO.setCreDt         (vskPfSkdVO.getCreDt());
			vskPfSkdIbisIfVO.setUpdUsrId      (account.getUsr_id());
			vskPfSkdIbisIfVO.setUpdDt         (vskPfSkdVO.getUpdDt());
			vskPfSkdIbisIfVO.setIbflag        (vskPfSkdVO.getIbflag());
			
			vskPfSkdIbisIfVOs.add(vskPfSkdIbisIfVO);
		}
		return vskPfSkdIbisIfVOs;
	}

	private List<VskPfSkdDtlIbisIfVO> cnvtToIfVskPfSkdDtl(List<VskPfSkdDtlVO> vskPfSkdDtlVOList){

		List<VskPfSkdDtlIbisIfVO> vskPfSkdDtlIbisIfVOs = new ArrayList<VskPfSkdDtlIbisIfVO>();
		
		for(int i = 0 ; i < vskPfSkdDtlVOList.size() ;i++) {
			VskPfSkdDtlIbisIfVO vskPfSkdDtlIbisIfVO = new VskPfSkdDtlIbisIfVO();
			VskPfSkdDtlVO vskPfSkdDtlVO = vskPfSkdDtlVOList.get(i);
			
			vskPfSkdDtlIbisIfVO.setVslSlanCd	 (vskPfSkdDtlVO.getVslSlanCd());
			vskPfSkdDtlIbisIfVO.setPfSvcTpCd	 (vskPfSkdDtlVO.getPfSvcTpCd());
			vskPfSkdDtlIbisIfVO.setPortCd	     (vskPfSkdDtlVO.getPortCd());
			vskPfSkdDtlIbisIfVO.setSkdDirCd	     (vskPfSkdDtlVO.getSkdDirCd());
			vskPfSkdDtlIbisIfVO.setClptSeq	     (vskPfSkdDtlVO.getClptSeq());
			vskPfSkdDtlIbisIfVO.setPortRotnSeq	 (vskPfSkdDtlVO.getPortRotnSeq());
			vskPfSkdDtlIbisIfVO.setYdCd	         (vskPfSkdDtlVO.getYdCd());
			vskPfSkdDtlIbisIfVO.setCallYdIndSeq  (vskPfSkdDtlVO.getCallYdIndSeq());
			vskPfSkdDtlIbisIfVO.setTurnPortFlg	 (vskPfSkdDtlVO.getTurnPortFlg());
			vskPfSkdDtlIbisIfVO.setTurnPortIndCd (vskPfSkdDtlVO.getTurnPortIndCd());
			vskPfSkdDtlIbisIfVO.setEtbDyCd	     (vskPfSkdDtlVO.getEtbDyCd());
			vskPfSkdDtlIbisIfVO.setEtbDyNo	     (vskPfSkdDtlVO.getEtbDyNo());
			vskPfSkdDtlIbisIfVO.setEtbTmHrmnt	 (vskPfSkdDtlVO.getEtbTmHrmnt());
			vskPfSkdDtlIbisIfVO.setEtdDyCd	     (vskPfSkdDtlVO.getEtdDyCd());
			vskPfSkdDtlIbisIfVO.setEtdDyNo	     (vskPfSkdDtlVO.getEtdDyNo());
			vskPfSkdDtlIbisIfVO.setEtdTmHrmnt	 (vskPfSkdDtlVO.getEtdTmHrmnt());
			vskPfSkdDtlIbisIfVO.setLnkDist	     (vskPfSkdDtlVO.getLnkDist());
			vskPfSkdDtlIbisIfVO.setLnkSpd	     (vskPfSkdDtlVO.getLnkSpd());
			vskPfSkdDtlIbisIfVO.setTztmHrs	     (vskPfSkdDtlVO.getTztmHrs());
			vskPfSkdDtlIbisIfVO.setSeaBufHrs	 (vskPfSkdDtlVO.getSeaBufHrs());
			vskPfSkdDtlIbisIfVO.setSeaBufSpd	 (vskPfSkdDtlVO.getSeaBufSpd());
			vskPfSkdDtlIbisIfVO.setMnvrInHrs	 (vskPfSkdDtlVO.getMnvrInHrs());
			vskPfSkdDtlIbisIfVO.setMnvrOutHrs	 (vskPfSkdDtlVO.getMnvrOutHrs());
			vskPfSkdDtlIbisIfVO.setIbIpcgoQty	 (vskPfSkdDtlVO.getIbIpcgoQty());
			vskPfSkdDtlIbisIfVO.setIbOcnCgoQty	 (vskPfSkdDtlVO.getIbOcnCgoQty());;
			vskPfSkdDtlIbisIfVO.setObIpcgoQty	 (vskPfSkdDtlVO.getObIpcgoQty());
			vskPfSkdDtlIbisIfVO.setObOcnCgoQty	 (vskPfSkdDtlVO.getObOcnCgoQty());
			vskPfSkdDtlIbisIfVO.setTmlProdQty	 (vskPfSkdDtlVO.getTmlProdQty());
			vskPfSkdDtlIbisIfVO.setCrnKnt	     (vskPfSkdDtlVO.getCrnKnt());
			vskPfSkdDtlIbisIfVO.setActWrkHrs	 (vskPfSkdDtlVO.getActWrkHrs());
			vskPfSkdDtlIbisIfVO.setPortBufHrs	 (vskPfSkdDtlVO.getPortBufHrs());
			vskPfSkdDtlIbisIfVO.setCreUsrId	     (account.getUsr_id());
			vskPfSkdDtlIbisIfVO.setCreDt	     (vskPfSkdDtlVO.getCreDt());
			vskPfSkdDtlIbisIfVO.setUpdUsrId	     (account.getUsr_id());
			vskPfSkdDtlIbisIfVO.setUpdDt	     (vskPfSkdDtlVO.getUpdDt());
			vskPfSkdDtlIbisIfVO.setIbflag        (vskPfSkdDtlVO.getIbflag());
			
			vskPfSkdDtlIbisIfVOs.add(vskPfSkdDtlIbisIfVO);
		}
		return vskPfSkdDtlIbisIfVOs;
	}

}
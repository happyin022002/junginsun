/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlySalesQuotaManageSC.java
 *@FileTitle : MonthlySalesQuotaManageSC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.basic.MonthlyQuotaAdjustmentRHQBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.basic.MonthlyQuotaAdjustmentRHQBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0075Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0149Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0161Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0162Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.basic.MonthlyQuotaAdjustmentSlsRHQBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.basic.MonthlyQuotaAdjustmentSlsRHQBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event.EsmSaq0156Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event.EsmSaq0158Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.basic.MonthlyQuotaAdjustmentTradeBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.basic.MonthlyQuotaAdjustmentTradeBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0048Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0147Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0176Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.basic.MonthlyQuotaAdjustmentTradeRHQBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.basic.MonthlyQuotaAdjustmentTradeRHQBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event.EsmSaq0085Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event.EsmSaq0148Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.basic.MonthlyQuotaCfmAdjustmentBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.basic.MonthlyQuotaCfmAdjustmentBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0164Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0165Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0166Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0167Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.basic.MonthlyQuotaCreationBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.basic.MonthlyQuotaCreationBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0047Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0077Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0078Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0178Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0181Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0182Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0183Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0184Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataInterfaceVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaCheckListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaInfoList0077VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaModelLogListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.basic.MonthlyQuotaGuidelineBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.basic.MonthlyQuotaGuidelineBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.event.EsmSaq0076Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration.MonthlyQuotaGuidelineDBDAO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.basic.MonthlyQuotaReleaseBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.basic.MonthlyQuotaReleaseBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.event.EsmSaq0052Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.basic.MonthlyQuotaStatusInquiryBC;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.basic.MonthlyQuotaStatusInquiryBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.event.EsmSaq0153Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.event.EsmSaq0179Event;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.basic.BasicDataBC;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.basic.BasicDataBCImpl;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.event.EsmSpc0100Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * MonthlySalesQuotaManage Business Logic ServiceCommand - handling business transaction.
 * 
 * @author
 * @see MonthlyQuotaGuidelineDBDAO
 * @since J2EE 1.6
 */

public class MonthlySalesQuotaManageSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("MonthlySalesQuotaManageSC Start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("MonthlySalesQuotaManageSC End");
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmSaq0076Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Tab 1 (Trade Tab)
				eventResponse = searchMonthlyGuidelineTargetGroup0076Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // Tab 2 (Sub Trade Tab)
				eventResponse = searchMonthlyGuidelineSubTrade0076Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // Cancel Current Version
				eventResponse = procGlineCancelCurrentVersion0076(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // Confirm
				eventResponse = procGlineConfirmDraft0076(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { // Cancel Confirmation
				eventResponse = procGlineCancelConfirmation0076(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // Notify
				eventResponse = procGlineNotifyDraft0076(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) { // Cancel Notification
				eventResponse = procGlineCancelNotification0076(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) { // Confirm As Final Version
				eventResponse = procGlineConfirmAsFinalVersion0076(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY07)) { // Cancel Final Version
				eventResponse = procGlineCancelFinalVersion0076(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //
				eventResponse = searchMonthlyQuotaAdjustmentTrade0048List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // TopTrade
				eventResponse = searchMonthlyAdjustmentTabTargetGroup0048Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // Top Trade
				eventResponse = searchMonthlyAdjustmentTabTrade0048Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // Top SubTrade
				eventResponse = searchMonthlyAdjustmentTabTrade0048Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { // Top RegionalGroup/Lane
				eventResponse = searchMonthlyAdjustmentTabTrade0048Tab03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) { // Remark
				eventResponse = searchMonthlyQuotaAdjustmentTradeRMK0048List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = updateMonthlyAdjustmentTrade0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // Save As New Version
				//
				eventResponse = createMonthlyAdjustmentTradeInfo0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { //
				//
				eventResponse = updateMonthlyAdjustmentFinal0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // Cancel CurrentVersion (01 step)
				// COMMAND08 ->MODIFY04
				eventResponse = procAdjustmentTradeCancelCurrentVersion0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) { // Cancel Current Version (03 step)
				// COMMAND09 ->MODIFY05
				eventResponse = procAdjustmentFinalCancelCurrentVersion0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) { // Confirm (01 step)
				// COMMAND11 ->MODIFY06
				eventResponse = procAdjustmentTradeConfirmDraft0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY07)) { // Cancel Confirmation (01 step)
				// COMMAND12 ->MODIFY07
				eventResponse = procAdjustmentTradeCancelConfirmation0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY08)) { // Confirm (03 step)
				// COMMAND13 ->MODIFY08
				eventResponse = procAdjustmentFinalConfirmDraft0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY09)) { // Cancel Confirm (03 step)
				// COMMAND14 ->MODIFY09
				eventResponse = procAdjustmentFinalCancelConfirmation0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY10)) { // Notify (01 step)
				// COMMAND21 ->MODIFY10
				eventResponse = procAdjustmentTradeNotifyDraft0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) { // Cancel Notification (01 step)
				// COMMAND22 ->MODIFY11
				eventResponse = procAdjustmentTradeCancelNotification0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY12)) { // Notify (03 step)
				// COMMAND23 ->MODIFY12
				eventResponse = procAdjustmentFinalNotifyDraft0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY13)) { // Concel Notification (03 step)
				// COMMAND24 ->MODIFY13
				eventResponse = procAdjustmentFinalCancelNotification0048(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY14)) { // Check whether there are zero load
				// COMMAND30 ->MODIFY14
				eventResponse = searchAdjustmentTradeLoadZero0048List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY15)) { // Check whether there are zero load
				// COMMAND31 ->MODIFY15
				eventResponse = searchAdjustmentTradeMonthLoadZero0048List(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Tab1 (Execution Item)
				eventResponse = searchMonthlyQuotaCheckList0047Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // Tab2 (Execution Log)
				eventResponse = searchMonthlyQuotaModelLogList0047Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Create Button
				eventResponse = createMonthlyQuotaModelExecute0047(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0077Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchMonthlyQuotaInfoList0077(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchMonthlyQuotaInfoList0077(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchMonthlyQuotaInfoList0077(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmMonthlyQuotaFinalVersion0077(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // Base Data Creation
				eventResponse = procMonthlyInitSmryCreation(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0075Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {// Top Trade
				eventResponse = searchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {// Top Trade
				eventResponse = searchMonthlyAdjustmentRHQTabTrade0075Tab01List02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {// Top Sub Trade
				eventResponse = searchMonthlyAdjustmentRHQTabSubTrade0075Tab02List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) {// Top Regional Group/Lane
				eventResponse = searchMonthlyAdjustmentRHQTabRhqLane0075Tab03List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) {// Remark
				eventResponse = searchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // Save As New Version
				// COMMAND02 ->MODIFY01
				eventResponse = createMonthlyAdjustmentRhqInfo0075(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { //
				// COMMAND03 ->MODIFY02
				eventResponse = updateMonthlyAdjustmentRhqFinal0075(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { // Cancel Current Version (06 step)
				// COMMAND09 ->MODIFY03
				eventResponse = procAdjustmentRhqCancelCurrentVersion0075(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // Confirm (06 step)
				// COMMAND13 ->MODIFY04
				eventResponse = procAdjustmentRhqFinalConfirmDraft0075(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) { // Cancel Confirmation (06 step)
				// COMMAND14 ->MODIFY05
				eventResponse = procAdjustmentRhqFinalCancelConfirmation0075(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) { // Notify (06 step)
				// COMMAND23 ->MODIFY06
				eventResponse = procAdjustmentRhqFinalNotifyDraft0075(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY07)) { // Cancel Notification (06 step)
				// COMMAND24 ->MODIFY07
				eventResponse = procAdjustmentRhqFinalCancelNotification0075(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY08)) { // Check whether there are zero load
				// COMMAND30 ->MODIFY08
				eventResponse = searchAdjustmentRhqLoadZero0075List(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0147Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentTradeModify0147List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = updateMonthlyQuotaAdjustmentTradeModify0147(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0148Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentTradeRhqModify0148List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiMonthlyQuotaAdjustmentTradeRhqModify0148(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0149Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentRhqModify0149List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiMonthlyQuotaAdjustmentRhqModify0149(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0085Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentTradeRhq0085List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { // Top Regional Group/Lane
				eventResponse = searchMonthlyAdjustmentTradeRhq0085Tab03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				// COMMAND01 ->MODIFY01
				eventResponse = updateMonthlyAdjustmentTradeRhq0085(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // Save As New Version
				// COMMAND02 ->MODIFY02
				eventResponse = createMonthlyAdjustmentTradeRhqInfo0085(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) { // Cancel Current Version (02 step)
				// COMMAND09 ->MODIFY03
				eventResponse = procAdjustmentTradeRhqCancelCurrentVersion0085(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // Confirm (02 step)
				// COMMAND11 ->MODIFY04
				eventResponse = procAdjustmentTradeRhqConfirmDraft0085(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) { // Cancel Confirm (02 step)
				// COMMAND12 ->MODIFY05
				eventResponse = procAdjustmentTradeRhqCancelConfirmation0085(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) { // Final Confirm
				// COMMAND13 ->MODIFY06
				eventResponse = procAdjustmentTradeRhqFinalConfirmDraft0085(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY07)) { // Notify (02 step)
				// COMMAND21 ->MODIFY07
				eventResponse = procAdjustmentTradeRhqNotifyDraft0085(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY08)) { // Cancel Notification (02 step)
				// COMMAND22 ->MODIFY08
				eventResponse = procAdjustmentTradeRhqCancelNotification0085(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY09)) { // Check whether there are zero load
				// COMMAND30 ->MODIFY09
				eventResponse = searchAdjustmentTradeRhqLoadZero0085List(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0161Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaForExcel0161List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				// COMMAND01 ->MODIFY01
				eventResponse = updateMonthlyQuotaForExcel0161(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0162Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaOfficeAdd0162List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = insertMonthlyQuotaOfficeAdd0162(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0156Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentSlsRhq0156List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Top Trade
				eventResponse = searchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // Top Trade
				eventResponse = searchMonthlyAdjustmentSlsRHQTabTrade0156Tab01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // Top Sub Trade
				eventResponse = searchMonthlyAdjustmentSlsRHQTabTrade0156Tab02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04)) { // Top Regional Group/Lane
				eventResponse = searchMonthlyAdjustmentSlsRHQTabTrade0156Tab03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05)) { // Remark
				eventResponse = searchMonthlyQuotaAdjustmentSlsRHQRMK0156List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = updateMonthlyAdjustmentSlsRhq0156(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { // Save As New Version
				eventResponse = createMonthlyAdjustmentSlsRhqInfo0156(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) { // Cancel Current Version
				// COMMAND03 -> MODIFY03
				// COMMAND08 -> MODIFY04
				// COMMAND09 -> MODIFY05
				eventResponse = procAdjustmentSlsRhqCancelCurrentVersion0156(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY06)) { // Confirm (step 08)
				// COMMAND11 -> MODIFY06
				eventResponse = procAdjustmentSlsRhqConfirmDraft0156(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY07)) { // Cancel Confirmation (step 08)
				// COMMAND12 -> MODIFY07
				// COMMAND13 -> MODIFY08
				// COMMAND14 -> MODIFY09
				eventResponse = procAdjustmentSlsRhqCancelConfirmation0156(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY10)) { // Notify (step 08)
				// COMMAND21 -> MODIFY10
				eventResponse = procAdjustmentSlsRhqNotifyDraft0156(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) { // Cancel Notification (step 08)
				// COMMAND22 -> MODIFY11
				// COMMAND23 -> MODIFY12
				// COMMAND24 -> MODIFY13
				eventResponse = procAdjustmentSlsRhqCancelNotification0156(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY14)) { // Check whether there are zero load
				// COMMAND30 -> MODIFY14
				eventResponse = searchAdjustmentSlsRhqLoadZero0156List(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0158Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentSlsRhqModify0158List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiMonthlyQuotaAdjustmentSlsRhqModify0158(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0153Event")) { // Process Status
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaStatusInquiry0153List01(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0052Event")) { // Confirmation and Distribution 
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // Confirmation and Distribution Main
				eventResponse = searchMonthlyQuotaRelease0052List01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Confirmation and Distribution Detail
				eventResponse = searchMonthlyQuotaRelease0052ListSub01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = appendMonthlyQuotaRelease0052(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = distributeMonthlyQuota0052(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0164Event")) { // Quota Management
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // VVD Mapping
				eventResponse = searchMonthlyTargetVVDMapping0164List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // VVD Mapping Save
				eventResponse = multiMonthlyTargetVVD0164(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0165Event")) { // Quota Management
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // QTA Editing
				eventResponse = searchMonthlyQtaEdit0165List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // QTA Editing Save
				eventResponse = updateMonthlyQtaEdit0165(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0166Event")) { // Quota Management - VVD Select Popup
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // VVD List
				eventResponse = searchMonthlyVVD0166List(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0167Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // QTA Edit Office Add
				eventResponse = searchMonthlyQuotaEditOfficeAdd0167List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Office Add
				eventResponse = searchMonthlyQuotaEditOfficeAddNew0167List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // QTA Edit Office Add Save
				eventResponse = multiMonthlyQuotaEditOfficeAdd0167(e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmSaq0176Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchMonthlyQuotaAdjustmentTradeForExcel0176List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				// COMMAND01 ->MODIFY01
				eventResponse = updateMonthlyQuotaAdjustmentTradeForExcel0176(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0178Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = createCoaInterfaceList(e); // COA I/F data creation
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0078Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInterfaceList(e); // Base Data interface list
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = updateConfirm(e); // Confirm
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = updateCancel(e); // Cancel Confirmation
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = updateNotify(e); // Notify
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0179Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCOfcVerify(e); // Base Data Contract Office Verify
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchLOfcVerify(e); // Base Data Loading Office Verify
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkOfficeValid(e); // Check Office Validation
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateOfcVerify(e); // Base Data Office Update
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0181Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchLaneAdjust(e); // Base Data Lane Adjust
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateLaneAdjust(e); // Base Data Lane Adjust 
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0182Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchGuidelineInitList(e); // Guideline Input Initial Search
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchGuidelineList(e); // Guideline Input Search
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateGuideline(e); // Guideline Input Save
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { 
				eventResponse = confirmMonthlyQuotaFinalVersion0182(e); //Save As Final Version
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { 
				eventResponse = procMonthlyInitSmryCreation0182(e); // Base Data Creation
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { 
				eventResponse = updateGuidelineConfirm(e); // Confirm
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { 
				eventResponse = updateGuidelineCancelConfirm(e); // Cancel Confirmation
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { 
				eventResponse = updateGuidelineNotify(e); // Notify
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) { 
				eventResponse = updateGuidelineCancelNotify(e); // Cancel Notification
			}  
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0183Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCPBAdjust(e); // Base Data CPB Adjust
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateCPBAdjust(e); // Base Data CPB Adjust 
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmSaq0184Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOfcAdjust(e); // Base Data Office Adjust
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = updateOfcAdjust(e); // Base Data Office Adjust 
			}
		}
		return eventResponse;
	}

	/**
	 * handling event in case of changing ESM_SAQ_0048<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentTrade <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentTrade0048List01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");

			ReturnVO list = command.searchMonthlyQuotaAdjustmentTrade0048List01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);
			eventResponse.setETCData("version", null);
			eventResponse.setETCData("mqtaMdlVerNo", event.getQuotaConditionVO().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getQuotaConditionVO().getSlsFcastPubNo());
			eventResponse.setETCData("saqStsCd", event.getQuotaConditionVO().getSaq_sts_cd());
			eventResponse.setETCData("isZeroLoad", event.getQuotaConditionVO().getIsZeroLoad());

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing Top TAB<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentRHQ<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentTabTargetGroup0048Tab01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST01");
			ReturnVO list = command.searchMonthlyAdjustmentTabTargetGroup0048Tab01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing Top TAB<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentRHQ<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentTabTrade0048Tab01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {
			event.getQuotaConditionVO().setChkCommand("SEARCHLIST02");

			if (event.getQuotaConditionVO().getUserId() == null || "".equals(event.getQuotaConditionVO().getUserId())) {
				event.getQuotaConditionVO().setUserId(event.getSignOnUserAccount().getUsr_id());
			}

			ReturnVO list = command.searchMonthlyAdjustmentTabTrade0048Tab01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing Top/TAB<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentTrade<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentTabTrade0048Tab02(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {
			event.getQuotaConditionVO().setChkCommand("SEARCHLIST03");

			if (event.getQuotaConditionVO().getUserId() == null || "".equals(event.getQuotaConditionVO().getUserId())) {
				event.getQuotaConditionVO().setUserId(event.getSignOnUserAccount().getUsr_id());
			}

			ReturnVO list = command.searchMonthlyAdjustmentTabTrade0048Tab02(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentTrade<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentTabTrade0048Tab03(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {
			event.getQuotaConditionVO().setChkCommand("SEARCHLIST04");

			if (event.getQuotaConditionVO().getUserId() == null || "".equals(event.getQuotaConditionVO().getUserId())) {
				event.getQuotaConditionVO().setUserId(event.getSignOnUserAccount().getUsr_id());
			}

			ReturnVO list = command.searchMonthlyAdjustmentTabTrade0048Tab03(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * handling event in case of changing YMonthyQuotaAdjustmentTradeRHQ<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentTradeRMK0048List01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST05");

			ReturnVO list = command.searchMonthlyQuotaAdjustmentTradeRMK0048List01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentTrade<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyAdjustmentTrade0048(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.updateMonthlyAdjustmentTrade0048(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			eventResponse.setETCData("saqStsCd", event.getQuotaConditionVO().getSaq_sts_cd());
			eventResponse.setETCData("mqtaMdlVerNo", event.getQuotaConditionVO().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getQuotaConditionVO().getSlsFcastPubNo());
			eventResponse.setETCData("isZeroLoad", event.getQuotaConditionVO().getIsZeroLoad());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentTrade<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMonthlyAdjustmentTradeInfo0048(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {
			begin();
			command.createMonthlyAdjustmentTradeInfo0048(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			eventResponse.setETCData("saqStsCd", "00");
			eventResponse.setETCData("version", event.getQuotaConditionVO().getNewVersion());
			eventResponse.setETCData("isZeroLoad", event.getQuotaConditionVO().getIsZeroLoad());
			eventResponse.setETCData("status", "OK");

			commit();

			event.getQuotaConditionVO().setChkCommand("MODIFY02");
			ReturnVO listVO = command.searchMonthlyQuotaAdjustmentTrade0048List01(event.getQuotaConditionVO());
			listVO.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(listVO);

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentTrade<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyAdjustmentFinal0048(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();

			command.updateMonthlyAdjustmentFinal0048(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			eventResponse.setETCData("saqStsCd", event.getQuotaConditionVO().getSaq_sts_cd());
			eventResponse.setETCData("mqtaMdlVerNo", event.getQuotaConditionVO().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getQuotaConditionVO().getSlsFcastPubNo());
			eventResponse.setETCData("isZeroLoad", event.getQuotaConditionVO().getIsZeroLoad());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentTrade<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeCancelCurrentVersion0048(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentTradeCancelCurrentVersion0048(event.getQuotaConditionVO(), account);
			commit();

			command.createQtaAdjSmry(event.getQuotaConditionVO().getMQtaStepCd(), event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "XX");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentFinalCancelCurrentVersion0048(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentFinalCancelCurrentVersion0048(event.getQuotaConditionVO());
			commit();

			command.createQtaAdjSmry(event.getQuotaConditionVO().getMQtaStepCd(), event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "XX");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeConfirmDraft0048(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {
			begin();
			command.procAdjustmentTradeConfirmDraft0048(event.getQuotaConditionVO(), account);
			commit();

			// begin();
			// Summary careate
			command.createQtaAdjSmry(event.getQuotaConditionVO().getMQtaStepCd(), event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "DC");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {

			// log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			// log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeCancelConfirmation0048(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentTradeCancelConfirmation0048(event.getQuotaConditionVO(), account);
			commit();

			// begin();
			command.createQtaAdjSmry(event.getQuotaConditionVO().getMQtaStepCd(), event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "00");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : Final handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentFinalConfirmDraft0048(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentFinalConfirmDraft0048(event.getQuotaConditionVO(), account);
			commit();

			// begin();
			command.createQtaAdjSmry("03", event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "FC");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : Final handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentFinalCancelConfirmation0048(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentFinalCancelConfirmation0048(event.getQuotaConditionVO(), account);
			commit();

			// begin();
			// Summary careate
			command.createQtaAdjSmry("03", event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "DR");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeNotifyDraft0048(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentTradeNotifyDraft0048(event.getQuotaConditionVO(), account);
			commit();

			// begin();
			// Summary careate
			command.createQtaAdjSmry(event.getQuotaConditionVO().getMQtaStepCd(), event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "DN");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeCancelNotification0048(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentTradeCancelNotification0048(event.getQuotaConditionVO(), account);
			commit();

			// begin();
			// Summary careate
			command.createQtaAdjSmry(event.getQuotaConditionVO().getMQtaStepCd(), event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "DC");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : Final handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentFinalNotifyDraft0048(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentFinalNotifyDraft0048(event.getQuotaConditionVO(), account);
			commit();

			// begin();
			command.createQtaAdjSmry("03", event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "FN");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : Final handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentFinalCancelNotification0048(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.procAdjustmentFinalCancelNotification0048(event.getQuotaConditionVO(), account);
			commit();

			// begin();
			command.createQtaAdjSmry("03", event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_quarter(), event.getQuotaConditionVO().getTrade(), event.getQuotaConditionVO().getBound(), event.getQuotaConditionVO().getMQtaVerNo(), event.getQuotaConditionVO().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "FC");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : Confirm event processing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjustmentTradeLoadZero0048List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		String retMsg = "";

		try {

			// log.debug("getETCData  :"+eventResponse.getETCData());

			retMsg = command.searchAdjustmentTradeLoadZero0048List(event.getQuotaConditionVO());
			eventResponse.setETCData("zeroList", retMsg);
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0048 : Confirm event processing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjustmentTradeMonthLoadZero0048List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0048Event event = (EsmSaq0048Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		String retMsg = "";

		try {
			retMsg = command.searchAdjustmentTradeMonthLoadZero0048List(event.getQuotaConditionVO());
			eventResponse.setETCData("zeroList", retMsg);
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0147 : event processing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentTradeModify0147List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0147Event event = (EsmSaq0147Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");

			ReturnVO list = command.searchMonthlyQuotaAdjustmentTradeModify0147List(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0147 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyQuotaAdjustmentTradeModify0147(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0147Event event = (EsmSaq0147Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.updateMonthlyQuotaAdjustmentTradeModify0147(event, account);
			// eventResponse.setUserMessage(new
			// ErrorHandler("ORA09999X").getUserMessage());
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			eventResponse.setETCData("command", String.valueOf(FormCommand.MULTI));

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0148 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentTradeRhqModify0148List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0148Event event = (EsmSaq0148Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");

			ReturnVO list = command.searchMonthlyQuotaAdjustmentTradeRhqModify0148List(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0148 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("static-access")
	private EventResponse multiMonthlyQuotaAdjustmentTradeRhqModify0148(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		;
		EsmSaq0148Event event = (EsmSaq0148Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();
		try {
			begin();
			command.multiMonthlyQuotaAdjustmentTradeRhqModify0148(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			eventResponse.setETCData("command", String.valueOf(e.getFormCommand().MULTI));

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0149 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentRhqModify0149List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0149Event event = (EsmSaq0149Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");

			ReturnVO list = command.searchMonthlyQuotaAdjustmentRhqModify0149List(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0149 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("static-access")
	private EventResponse multiMonthlyQuotaAdjustmentRhqModify0149(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0149Event event = (EsmSaq0149Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			command.multiMonthlyQuotaAdjustmentRhqModify0149(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			eventResponse.setETCData("command", String.valueOf(e.getFormCommand().MULTI));

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0161 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaForExcel0161List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0161Event event = (EsmSaq0161Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");
			ReturnVO list = command.searchMonthlyQuotaForExcel0161List(event.getQuotaConditionVO());
			list.addList(event);
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0161 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyQuotaForExcel0161(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0161Event event = (EsmSaq0161Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			command.updateMonthlyQuotaForExcel0161(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0162 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaOfficeAdd0162List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0162Event event = (EsmSaq0162Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");
			ReturnVO list = command.searchMonthlyQuotaOfficeAdd0162List(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0162 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse insertMonthlyQuotaOfficeAdd0162(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0162Event event = (EsmSaq0162Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			command.insertMonthlyQuotaOfficeAdd0162(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("status", "OK");
			eventResponse.setETCData("saveList", event.getQuotaConditionVO().getSaveList());

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentTradeRhq0085List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");

			// Tab 1 (Trade Tab) 및 조건 VO List에 셋팅
			ReturnVO list = command.searchMonthlyQuotaAdjustmentTradeRhq0085List01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

			// ETC data setting
			eventResponse.setETCData("version", null);
			eventResponse.setETCData("saqStsCd", event.getQuotaConditionVO().getSaq_sts_cd());
			eventResponse.setETCData("mqtaMdlVerNo", event.getQuotaConditionVO().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getQuotaConditionVO().getSlsFcastPubNo());
			eventResponse.setETCData("inclPortFlag", event.getQuotaConditionVO().getInclPortFlag());

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentTradeRhq0085Tab03(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST04");

			ReturnVO list = command.searchMonthlyAdjustmentTradeRhq0085Tab03(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

			// ETC data setting
			eventResponse.setETCData("mqtaMdlVerNo", event.getQuotaConditionVO().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getQuotaConditionVO().getSlsFcastPubNo());
			eventResponse.setETCData("inclPortFlag", event.getQuotaConditionVO().getInclPortFlag());

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyAdjustmentTradeRhq0085(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();
		try {
			begin();
			command.updateMonthlyAdjustmentTradeRhq0085(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("saqStsCd", event.getQuotaConditionVO().getSaq_sts_cd());
			eventResponse.setETCData("mqtaMdlVerNo", event.getQuotaConditionVO().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getQuotaConditionVO().getSlsFcastPubNo());
			eventResponse.setETCData("inclPortFlag", event.getQuotaConditionVO().getInclPortFlag());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMonthlyAdjustmentTradeRhqInfo0085(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();

		try {
			begin();
			command.createMonthlyAdjustmentTradeRhqInfo0085(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("version", event.getQuotaConditionVO().getNewVersion());
			eventResponse.setETCData("status", "OK");

			commit();

			// new Version LIST
			log.debug("NewVersion   >>>>>>>:" + event.getQuotaConditionVO().getNewVersion());
			ReturnVO list = command.searchMonthlyQuotaAdjustmentTradeRhq0085List01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeRhqCancelCurrentVersion0085(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();
		try {
			begin();
			command.procAdjustmentTradeRhqCancelCurrentVersion0085(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "XX");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeRhqConfirmDraft0085(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();
		try {
			begin();
			command.procAdjustmentTradeRhqConfirmDraft0085(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "DC");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeRhqCancelConfirmation0085(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();
		try {
			begin();
			command.procAdjustmentTradeRhqCancelConfirmation0085(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "00");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : Final handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeRhqFinalConfirmDraft0085(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();
		try {
			begin();
			command.procAdjustmentTradeRhqFinalConfirmDraft0085(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "FC");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeRhqNotifyDraft0085(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();
		try {
			begin();
			command.procAdjustmentTradeRhqNotifyDraft0085(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "DN");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentTradeRhqCancelNotification0085(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();
		try {
			begin();
			command.procAdjustmentTradeRhqCancelNotification0085(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "DC");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0085 : Confirm checking event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjustmentTradeRhqLoadZero0085List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0085Event event = (EsmSaq0085Event) e;
		MonthlyQuotaAdjustmentTradeRHQBC command = new MonthlyQuotaAdjustmentTradeRHQBCImpl();

		String retMsg = "";

		try {

			retMsg = command.searchAdjustmentTradeRhqLoadZero0085List(event.getQuotaConditionVO());
			eventResponse.setETCData("zeroList", retMsg);
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentSlsRhq0156List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");

			ReturnVO list = command.searchMonthlyQuotaAdjustmentSlsRhq0156List01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

			// ETC data setting
			eventResponse.setETCData("version", null);
			eventResponse.setETCData("saqStsCd", event.getQuotaConditionVO().getSaq_sts_cd());
			eventResponse.setETCData("mqtaMdlVerNo", event.getQuotaConditionVO().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getQuotaConditionVO().getSlsFcastPubNo());
			eventResponse.setETCData("inclPortFlag", event.getQuotaConditionVO().getInclPortFlag());
			eventResponse.setETCData("qta_mst_ver_no", event.getQuotaConditionVO().getQtaMstVerNo());
			eventResponse.setETCData("trade_group_cd", event.getQuotaConditionVO().getTradeGroupCd());

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing Top TAB<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST01");

			ReturnVO list = command.searchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing Top TAB<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentSlsRHQTabTrade0156Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST02");

			ReturnVO list = command.searchMonthlyAdjustmentSlsRHQTabTrade0156Tab01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing Top TAB<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentSlsRHQTabTrade0156Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST03");

			ReturnVO list = command.searchMonthlyAdjustmentSlsRHQTabTrade0156Tab02(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing Top TAB<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentSlsRHQTabTrade0156Tab03(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST04");

			// Tab 1 (Trade Tab) 및 조건 VO List에 셋팅
			ReturnVO list = command.searchMonthlyAdjustmentSlsRHQTabTrade0156Tab03(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

			// ETC data setting
			// eventResponse.setETCData("version" ,
			// event.getQuotaConditionVO().getVersion());
			// eventResponse.setETCData("isZeroLoad" ,
			// event.getQuotaConditionVO().getIsZeroLoad());

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentSlsRHQRMK0156List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST05");

			ReturnVO list = command.searchMonthlyQuotaAdjustmentSlsRHQRMK0156List01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyAdjustmentSlsRhq0156(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();
		try {
			begin();
			command.updateMonthlyAdjustmentSlsRhq0156(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("saqStsCd", event.getQuotaConditionVO().getSaq_sts_cd());
			eventResponse.setETCData("mqtaMdlVerNo", event.getQuotaConditionVO().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getQuotaConditionVO().getSlsFcastPubNo());
			eventResponse.setETCData("inclPortFlag", event.getQuotaConditionVO().getInclPortFlag());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMonthlyAdjustmentSlsRhqInfo0156(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		try {
			begin();
			command.createMonthlyAdjustmentSlsRhqInfo0156(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("version", event.getQuotaConditionVO().getNewVersion());
			eventResponse.setETCData("status", "OK");

			commit();

			// new Version LIST
			ReturnVO list = command.searchMonthlyQuotaAdjustmentSlsRhq0156List01(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentSlsRhqCancelCurrentVersion0156(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();
		try {
			begin();
			command.procAdjustmentSlsRhqCancelCurrentVersion0156(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "XX");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentSlsRhqConfirmDraft0156(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();
		try {
			begin();
			String rtn = command.procAdjustmentSlsRhqConfirmDraft0156(event.getQuotaConditionVO(), account);
			// 2010.04.20 EventException 발생 시키지 않고 Return String으로 수정 @*@
			if (!("").equals(rtn)) {
				eventResponse.setETCData("saqStsCd", "00");
				eventResponse.setETCData("status", "MSG");
				eventResponse.setETCData("validationMsg", rtn);
				rollback();
			} else {
				eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
				eventResponse.setETCData("saqStsCd", "FC");
				eventResponse.setETCData("status", "OK");
				commit();
			}
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentSlsRhqCancelNotification0156(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();
		try {
			begin();
			command.procAdjustmentSlsRhqCancelNotification0156(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "FC");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentSlsRhqCancelConfirmation0156(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();
		try {
			begin();
			command.procAdjustmentSlsRhqCancelConfirmation0156(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "00");
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentSlsRhqNotifyDraft0156(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();
		try {
			begin();
			command.procAdjustmentSlsRhqNotifyDraft0156(event.getQuotaConditionVO(), account);

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", event.getQuotaConditionVO().getStatusCd());
			eventResponse.setETCData("status", "OK");
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0156 : Confirm checking process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjustmentSlsRhqLoadZero0156List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0156Event event = (EsmSaq0156Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		String retMsg = "";

		try {

			retMsg = command.searchAdjustmentSlsRhqLoadZero0156List(event.getQuotaConditionVO());
			eventResponse.setETCData("zeroList", retMsg);
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0158 : handing event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentSlsRhqModify0158List(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0158Event event = (EsmSaq0158Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");
			// POPUP List에 셋팅
			ReturnVO list = command.searchMonthlyQuotaAdjustmentSlsRhqModify0158List(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0158 : handing event in case of changing <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMonthlyQuotaAdjustmentSlsRhqModify0158(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0158Event event = (EsmSaq0158Event) e;
		MonthlyQuotaAdjustmentSlsRHQBC command = new MonthlyQuotaAdjustmentSlsRHQBCImpl();
		try {
			begin();
			command.multiMonthlyQuotaAdjustmentSlsRhqModify0158(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("command", event.getQuotaConditionVO().getChkCommand());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [SEARCHLIST01]<br>
	 * retriving Trade Tab<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchMonthlyGuidelineTargetGroup0076Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		ReturnVO returnVO = new ReturnVO();

		try {
			// 1. Tab 1 (Trade Tab)
			ReturnVO resultVO = command.searchMonthlyGuidelineTargetGroup0076Tab01(event.getQuotaConditionVO());

			String mqtaMdlVerNo = "";
			String slsFcastPubNo = "";
			String saqStsCd = "";
			StringBuffer trdCd = new StringBuffer();

			// 2. ReturnVO setting
			returnVO.addList(resultVO.getList(0));
			returnVO.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(returnVO);

			// 3. ETC data setting
			QuotaConditionVO etcVO = resultVO.getConditionVO();
			saqStsCd = etcVO.getSts();
			mqtaMdlVerNo = etcVO.getMqtaMdlVerNo();
			slsFcastPubNo = etcVO.getSlsFcastPubNo();

			List<QuotaConditionVO> etcVOList = (List<QuotaConditionVO>) resultVO.getList(1);
			if (etcVOList.size() > 0) {
				for (int i = 0; i < etcVOList.size(); i++) {
					QuotaConditionVO etcVO2 = etcVOList.get(i);
					trdCd.append(etcVO2.getTrade()).append("|").append(etcVO2.getDirCd()).append(";");
				}
			}

			eventResponse.setETCData("saqStsCd", saqStsCd);
			eventResponse.setETCData("mqtaMdlVerNo", mqtaMdlVerNo);
			eventResponse.setETCData("slsFcastPubNo", slsFcastPubNo);
			eventResponse.setETCData("TRADE_BOUND", trdCd.toString());

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [SEARCHLIST02]<br>
	 * retriving Sub Trade Tab<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchMonthlyGuidelineSubTrade0076Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		ReturnVO returnVO = new ReturnVO();
		try {
			// 1.Tab 2 (Sub Trade Tab)
			ReturnVO resultVO = command.searchMonthlyGuidelineSubTrade0076Tab02(event.getQuotaConditionVO());

			String mqtaMdlVerNo = "";
			String slsFcastPubNo = "";
			String saqStsCd = "";
			StringBuffer trdCd = new StringBuffer();

			// 2. ReturnVO 셋팅
			returnVO.addList(resultVO.getList(0));
			returnVO.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(returnVO);

			// 3. ETC data setting
			QuotaConditionVO etcVO = resultVO.getConditionVO();
			saqStsCd = etcVO.getSts();
			mqtaMdlVerNo = etcVO.getMqtaMdlVerNo();
			slsFcastPubNo = etcVO.getSlsFcastPubNo();

			List<QuotaConditionVO> etcVOList = (List<QuotaConditionVO>) resultVO.getList(1);
			if (etcVOList.size() > 0) {
				for (int i = 0; i < etcVOList.size(); i++) {
					QuotaConditionVO etcVO2 = etcVOList.get(i);
					trdCd.append(etcVO2.getTrade()).append("|").append(etcVO2.getDirCd()).append(";");
				}
			}

			eventResponse.setETCData("saqStsCd", saqStsCd);
			eventResponse.setETCData("mqtaMdlVerNo", mqtaMdlVerNo);
			eventResponse.setETCData("slsFcastPubNo", slsFcastPubNo);
			eventResponse.setETCData("TRADE_BOUND", trdCd.toString());

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [MODIFY01]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procGlineCancelCurrentVersion0076(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		try {
			begin();
			QuotaConditionVO etcVO = command.procGlineCancelCurrentVersion0076(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", etcVO.getSaqStsCd());
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [MODIFY02]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procGlineConfirmDraft0076(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		try {
			begin();
			QuotaConditionVO etcVO = command.procGlineConfirmDraft0076(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", etcVO.getSaqStsCd());
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [MODIFY03]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procGlineCancelConfirmation0076(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		try {
			begin();
			QuotaConditionVO etcVO = command.procGlineCancelConfirmation0076(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", etcVO.getSaqStsCd());
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [MODIFY04]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procGlineNotifyDraft0076(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		try {
			begin();
			QuotaConditionVO etcVO = command.procGlineNotifyDraft0076(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", etcVO.getSaqStsCd());
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [MODIFY05]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procGlineCancelNotification0076(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		try {
			begin();
			QuotaConditionVO etcVO = command.procGlineCancelNotification0076(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", etcVO.getSaqStsCd());
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [MODIFY06]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procGlineConfirmAsFinalVersion0076(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		try {
			begin();
			QuotaConditionVO etcVO = command.procGlineConfirmAsFinalVersion0076(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", etcVO.getSaqStsCd());
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0076 : [MODIFY07]<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procGlineCancelFinalVersion0076(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0076Event event = (EsmSaq0076Event) e;
		MonthlyQuotaGuidelineBC command = new MonthlyQuotaGuidelineBCImpl();
		try {
			begin();
			QuotaConditionVO etcVO = command.procGlineCancelFinalVersion0076(event.getQuotaConditionVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", etcVO.getSaqStsCd());
			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0047 : <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaCheckList0047Tab01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0047Event event = (EsmSaq0047Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<SearchMonthlyQuotaCheckListVO> list = command.searchMonthlyQuotaCheckList0047Tab01(event.getQuotaConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0047 : <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaModelLogList0047Tab02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0047Event event = (EsmSaq0047Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<SearchMonthlyQuotaModelLogListVO> list = command.searchMonthlyQuotaModelLogList0047Tab02(event.getQuotaConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0047 : <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMonthlyQuotaModelExecute0047(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0047Event event = (EsmSaq0047Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			// begin();
			command.transferMonthlyProcess0047(event.getQuotaConditionVO(), account);
			// commit();
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());

		}

		return eventResponse;
	}

	/**
	 * ESM_SAQ_0077 : <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaInfoList0077(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0077Event event = (EsmSaq0077Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<SearchMonthlyQuotaInfoList0077VO> list = command.searchMonthlyQuotaInfoList0077(event.getQuotaConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0182 : <br>
	 * [MonthlyQuotaCreation]을 [MULTI01] 합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmMonthlyQuotaFinalVersion0182(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			begin();
			command.confirmMonthlyQuotaFinalVersion0077(event.getQuotaConditionVO(), account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0077 : <br>
	 * [MonthlyQuotaCreation]을 [MULTI01] 합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmMonthlyQuotaFinalVersion0077(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0077Event event = (EsmSaq0077Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			begin();
			command.confirmMonthlyQuotaFinalVersion0077(event.getQuotaConditionVO(), account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0077 : <br>
	 * [MonthlyInitSmryCreation]을 [MODIFY01] 합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procMonthlyInitSmryCreation0182(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		try {
			begin();
			command.procMonthlyInitSmryCreation0077(event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_qtr_cd(), account);
			commit();

			eventResponse.setUserMessage("Master data creation is running by batch process. \nIt might time several minutes accoding to the processing volume. \nPlease try to retrieve to check result after certain period. "); 		

		} catch (EventException ex) {			
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0077 : <br>
	 * [MonthlyInitSmryCreation]을 [MODIFY01] 합니다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procMonthlyInitSmryCreation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0077Event event = (EsmSaq0077Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		try {
			begin();
			command.procMonthlyInitSmryCreation0077(event.getQuotaConditionVO().getYear(), event.getQuotaConditionVO().getBse_qtr_cd(), account);
			commit();

			// eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

		} catch (EventException ex) {
			;
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0153 : <br>
	 * Sales. Rep
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaStatusInquiry0153List01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0153Event event = (EsmSaq0153Event) e;
		MonthlyQuotaStatusInquiryBC command = new MonthlyQuotaStatusInquiryBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaStatusInquiry0153List01(condition, account);
			eventResponse.setRsVo(returnVO);
			eventResponse.setETCData("status", "OK");
		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0075 : <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			ReturnVO list = command.searchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01(event.getCondition());
			eventResponse.setRsVo(list);
			// eventResponse.setETCData("status", "OK");
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
	 * ESM_SAQ_0075 : <br>
	 * retriving Trade group List Top<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			ReturnVO list = command.searchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01(event.getCondition());
			eventResponse.setRsVo(list);
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
	 * ESM_SAQ_0075 : <br>
	 * retriving Trade List Top<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentRHQTabTrade0075Tab01List02(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			ReturnVO list = command.searchMonthlyAdjustmentRHQTabTrade0075Tab01List02(event.getCondition());
			eventResponse.setRsVo(list);
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
	 * ESM_SAQ_0075 : <br>
	 * retrieving Sub Trade List Top<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentRHQTabSubTrade0075Tab02List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			ReturnVO list = command.searchMonthlyAdjustmentRHQTabSubTrade0075Tab02List01(event.getCondition());
			eventResponse.setRsVo(list);
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
	 * ESM_SAQ_0075 : <br>
	 * retrieving Top Regional Group/Lane Tab<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyAdjustmentRHQTabRhqLane0075Tab03List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			ReturnVO list = command.searchMonthlyAdjustmentRHQTabRhqLane0075Tab03List01(event.getCondition());
			eventResponse.setRsVo(list);
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
	 * ESM_SAQ_0075 : event process<br>
	 * Remark retrieve event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			ReturnVO list = command.searchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01(event.getCondition());
			eventResponse.setRsVo(list);
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
	 * ESM_SAQ_0075 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createMonthlyAdjustmentRhqInfo0075(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();

		try {
			begin();
			command.createMonthlyAdjustmentRhqInfo0075(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("version", event.getCondition().getNewVersion());
			eventResponse.setETCData("status", "OK");

			commit();

			// new Version LIST
			ReturnVO list = command.searchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01(event.getCondition());
			eventResponse.setRsVo(list);

		} catch (EventException ex) {
			rollback();

			throw ex;
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0075 : Final handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyAdjustmentRhqFinal0075(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			command.updateMonthlyAdjustmentRhqFinal0075(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("version", null);
			eventResponse.setETCData("saqStsCd", event.getCondition().getSaqStsCd());
			eventResponse.setETCData("mqtaMdlVerNo", event.getCondition().getMqtaMdlVerNo());
			eventResponse.setETCData("slsFcastPubNo", event.getCondition().getSlsFcastPubNo());
			eventResponse.setETCData("inclPortFlag", event.getCondition().getInclPortFlag());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();

			throw ex;
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0075 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentRhqCancelCurrentVersion0075(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			command.procAdjustmentRhqCancelCurrentVersion0075(event.getCondition(), account);
			commit();

			// begin();
			// Summary careate
			command.createQtaAdjSmry(event.getCondition().getMQtaStepCd(), event.getCondition().getYear(), event.getCondition().getBse_quarter(), event.getCondition().getTrade(), event.getCondition().getBound(), event.getCondition().getMQtaVerNo(), event.getCondition().getUserId());
			// commit();

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			// ETC data setting
			eventResponse.setETCData("saqStsCd", "XX");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw ex;
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0075 : Final handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentRhqFinalConfirmDraft0075(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			String rtn = command.procAdjustmentRhqFinalConfirmDraft0075(event.getCondition(), account);
			if (!("").equals(rtn)) {
				eventResponse.setETCData("saqStsCd", "00");
				eventResponse.setETCData("status", "MSG");
				eventResponse.setETCData("validationMsg", rtn);
				rollback();
			} else {
				commit();

				command.createQtaAdjSmry("04", event.getCondition().getYear(), event.getCondition().getBse_quarter(), event.getCondition().getTrade(), event.getCondition().getBound(), event.getCondition().getMQtaVerNo(), event.getCondition().getUserId());

				eventResponse.setETCData("saqStsCd", "FC");
				eventResponse.setETCData("status", "OK");
				eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			}

		} catch (EventException ex) {
			rollback();

			throw ex;
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0075 : Final handling event in case of changing<br>
	 * of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentRhqFinalCancelConfirmation0075(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			command.procAdjustmentRhqFinalCancelConfirmation0075(event.getCondition(), account);
			commit();
			command.createQtaAdjSmry("04", event.getCondition().getYear(), event.getCondition().getBse_quarter(), event.getCondition().getTrade(), event.getCondition().getBound(), event.getCondition().getMQtaVerNo(), event.getCondition().getUserId());
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", "00");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw ex;
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0075 : Final handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentRhqFinalNotifyDraft0075(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			command.procAdjustmentRhqFinalNotifyDraft0075(event.getCondition(), account);
			commit();
			command.createQtaAdjSmry("04", event.getCondition().getYear(), event.getCondition().getBse_quarter(), event.getCondition().getTrade(), event.getCondition().getBound(), event.getCondition().getMQtaVerNo(), event.getCondition().getUserId());
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("saqStsCd", event.getCondition().getStatusCd());
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw ex;
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0075 : Final handling event in case of changing<br>
	 * handling event in case of changing MonthlyQuotaAdjustmentRhq<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse procAdjustmentRhqFinalCancelNotification0075(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();
		try {
			begin();
			command.procAdjustmentRhqFinalCancelNotification0075(event.getCondition(), account);
			commit();

			command.createQtaAdjSmry("04", event.getCondition().getYear(), event.getCondition().getBse_quarter(), event.getCondition().getTrade(), event.getCondition().getBound(), event.getCondition().getMQtaVerNo(), event.getCondition().getUserId());

			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());

			eventResponse.setETCData("saqStsCd", "FC");
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			rollback();

			throw ex;
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0075 : Confirm check event process<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjustmentRhqLoadZero0075List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0075Event event = (EsmSaq0075Event) e;
		MonthlyQuotaAdjustmentRHQBC command = new MonthlyQuotaAdjustmentRHQBCImpl();

		ReturnVO listVO = new ReturnVO();
		String retMsg = "";

		try {

			retMsg = command.searchAdjustmentRhqLoadZero0075List(event.getCondition());

			event.getCondition().setZeroList(retMsg);

			eventResponse.setETCData("version", null);
			eventResponse.setETCData("zeroList", retMsg);
			eventResponse.setETCData("status", "OK");

			listVO.addList(event.getCondition());

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0052 : handling event in case of changing<br>
	 * Confirmation and Distribution
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaRelease0052List01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0052Event event = (EsmSaq0052Event) e;
		MonthlyQuotaReleaseBC command = new MonthlyQuotaReleaseBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaRelease0052List01(condition, account.getOfc_cd());
			eventResponse.setRsVo(returnVO);
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0052 : handling event in case of changing<br>
	 * Confirmation and Distribution
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaRelease0052ListSub01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0052Event event = (EsmSaq0052Event) e;
		MonthlyQuotaReleaseBC command = new MonthlyQuotaReleaseBCImpl();

		try {

			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.searchMonthlyQuotaRelease0052ListSub01(condition, event.getIsNewVersion(), event.getMqtaRlseVerNo());
			eventResponse.setRsVo(returnVO);
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0052 : handling event in case of changing<br>
	 * Confirmation and Distribution
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse appendMonthlyQuotaRelease0052(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0052Event event = (EsmSaq0052Event) e;
		MonthlyQuotaReleaseBC command = new MonthlyQuotaReleaseBCImpl();

		try {
			QuotaConditionVO condition = event.getQuotaConditionVO();
			condition.setFormCommand(e.getFormCommand());

			ReturnVO returnVO = command.appendMonthlyQuotaRelease0052(condition);
			eventResponse.setRsVo(returnVO);
			eventResponse.setETCData("status", "OK");

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0052 : handling event in case of changing<br>
	 * Confirmation and Distribution
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse distributeMonthlyQuota0052(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0052Event event = (EsmSaq0052Event) e;
		MonthlyQuotaReleaseBC command = new MonthlyQuotaReleaseBCImpl();

		try {
			begin();
			command.distributeMonthlyQuota0052(event.getMqtaRlseVerNo(), event.getYear(), event.getQuarter(), event.getIsNewVersion(), event.getSaqMonQtaRlseVO(), event.getSaqMonQtaRlseTrdVOs(), account.getUsr_id());
			commit();
			log.debug("::::::::::::getYear::::::::::::"+event.getYear()+":::::::::::::::::getQuarter::::::::::::::::"+event.getQuarter()+":::::::::::::::::getMqtaRlseVerNo::::::::::::::"+event.getMqtaRlseVerNo());
			
			String strYear =  event.getYear();
			String strQuarter =  event.getQuarter();
			String strMqtaRlseVerNo =  event.getMqtaRlseVerNo();
			
			command.transferSaqMonQtaCrePrc(strYear, strQuarter, strMqtaRlseVerNo, account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0164 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyTargetVVDMapping0164List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0164Event event = (EsmSaq0164Event) e;
		MonthlyQuotaCfmAdjustmentBC command = new MonthlyQuotaCfmAdjustmentBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");
			ReturnVO list = command.searchMonthlyTargetVVDMapping0164List(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

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
	 * ESM_SAQ_0164 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMonthlyTargetVVD0164(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0164Event event = (EsmSaq0164Event) e;
		MonthlyQuotaCfmAdjustmentBC command = new MonthlyQuotaCfmAdjustmentBCImpl();
		try {
			begin();
			command.multiMonthlyTargetVVD0164(event, account);
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0165 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQtaEdit0165List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0165Event event = (EsmSaq0165Event) e;
		MonthlyQuotaCfmAdjustmentBC command = new MonthlyQuotaCfmAdjustmentBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");
			ReturnVO list = command.searchMonthlyQtaEdit0165List(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

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
	 * ESM_SAQ_0165 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyQtaEdit0165(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0165Event event = (EsmSaq0165Event) e;
		MonthlyQuotaCfmAdjustmentBC command = new MonthlyQuotaCfmAdjustmentBCImpl();
		try {
			begin();
			command.updateMonthlyQtaEdit0165(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0166 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyVVD0166List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0166Event event = (EsmSaq0166Event) e;
		MonthlyQuotaCfmAdjustmentBC command = new MonthlyQuotaCfmAdjustmentBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");
			ReturnVO list = command.searchMonthlyVVD0166List(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

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
	 * ESM_SAQ_0167 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaEditOfficeAdd0167List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0167Event event = (EsmSaq0167Event) e;
		MonthlyQuotaCfmAdjustmentBC command = new MonthlyQuotaCfmAdjustmentBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");
			ReturnVO list = command.searchMonthlyQuotaEditOfficeAdd0167List(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

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
	 * ESM_SAQ_0167 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaEditOfficeAddNew0167List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0167Event event = (EsmSaq0167Event) e;
		MonthlyQuotaCfmAdjustmentBC command = new MonthlyQuotaCfmAdjustmentBCImpl();

		try {

			event.getQuotaConditionVO().setChkCommand("SEARCHLIST01");
			ReturnVO list = command.searchMonthlyQuotaEditOfficeAddNew0167List(event.getQuotaConditionVO());
			list.setConditionVO(event.getQuotaConditionVO());
			eventResponse.setRsVo(list);

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
	 * ESM_SAQ_0167 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMonthlyQuotaEditOfficeAdd0167(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0167Event event = (EsmSaq0167Event) e;
		MonthlyQuotaCfmAdjustmentBC command = new MonthlyQuotaCfmAdjustmentBCImpl();
		try {
			begin();
			command.multiMonthlyQuotaEditOfficeAdd0167(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0176 : handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMonthlyQuotaAdjustmentTradeForExcel0176List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0176Event event = (EsmSaq0176Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();

		try {
			event.getQuotaConditionVO().setChkCommand("SEARCHLIST");
			ReturnVO list = command.searchMonthlyQuotaAdjustmentTradeForExcel0176List(event.getQuotaConditionVO());
			list.addList(event);
			eventResponse.setRsVo(list);

		} catch (EventException ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {

			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0176 : handling event in case of changing<br>
	 * handling event in case of changing<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse updateMonthlyQuotaAdjustmentTradeForExcel0176(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0176Event event = (EsmSaq0176Event) e;
		MonthlyQuotaAdjustmentTradeBC command = new MonthlyQuotaAdjustmentTradeBCImpl();
		try {
			begin();
			command.updateMonthlyQuotaAdjustmentTradeForExcel0176(event, account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");

			commit();
		} catch (EventException ex) {
			rollback();

			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();

			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0178 : COA I/F data creation
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse createCoaInterfaceList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0178Event event = (EsmSaq0178Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			begin();
			command.createCoaInterfaceList(event.getBaseDataFromCoaListVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0078 : COA interface data 를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchInterfaceList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0078Event event = (EsmSaq0078Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<BaseDataInterfaceVO> list = command.searchInterfaceList(event.getBaseDataInterfaceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0179 : Contract Office Verify data 를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCOfcVerify(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0179Event event = (EsmSaq0179Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<BaseDataInterfaceVO> list = command.searchCOfcVerify(event.getBaseDataInterfaceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_SAQ_0179 : Loading Office Verify data 를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLOfcVerify(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0179Event event = (EsmSaq0179Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<BaseDataInterfaceVO> list = command.searchLOfcVerify(event.getBaseDataInterfaceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0179 : Check Office Validation 
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkOfficeValid(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0179Event event = (EsmSaq0179Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {			
			String flg = command.checkOfficeValid(event.getBaseDataInterfaceVO());
			eventResponse.setETCData("valid_flg", flg);
			
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;		
	}
	
	/**
	 * ESM_SAQ_0179 : Office data 를 수정한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateOfcVerify(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0179Event event = (EsmSaq0179Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateOfcVerify(event.getBaseDataInterfaceVOS(), account);
			command.updateReCalRpbCpb(event.getBaseDataInterfaceVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0078 : Base Data Preparation Confirm
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0078Event event = (EsmSaq0078Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			String strFlg = command.checkConfirmFlg(event.getBaseDataInterfaceVO());
			
			if("O".equals(strFlg)){
				eventResponse.setETCData("status", "NO");
				eventResponse.setUserMessage("Office data is existed on Office Verify pop-up screen. \nPlease check before confirm?");	
				
			} else if("L".equals(strFlg)){
				eventResponse.setETCData("status", "NO");
				eventResponse.setUserMessage("Lane data is existed on Lane Adjust pop-up screen. \nPlease check before confirm?");	
				
			} else if("OL".equals(strFlg)){
				eventResponse.setETCData("status", "NO");
				eventResponse.setUserMessage("Office/Lane data is existed on Office Verify/Lane Adjust pop-up screen. \nPlease check before confirm?");	
				
			} else if("Y".equals(strFlg)){
				begin();
				command.updateConfirm(event.getBaseDataInterfaceVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
				eventResponse.setETCData("status", "OK");
				commit();
			}
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0078 : Base Data Preparation Cancel Confirmation
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateCancel(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0078Event event = (EsmSaq0078Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateCancel(event.getBaseDataInterfaceVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0078 : Base Data Preparation Notify
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateNotify(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0078Event event = (EsmSaq0078Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateNotify(event.getBaseDataInterfaceVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0184 : Office Adjust data 를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOfcAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0184Event event = (EsmSaq0184Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<BaseDataInterfaceVO> list = command.searchOfcAdjust(event.getBaseDataInterfaceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0184 : Office Adjust
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateOfcAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0184Event event = (EsmSaq0184Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateOfcAdjust(event.getBaseDataInterfaceVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0181 : Lane Adjust data 를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLaneAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0181Event event = (EsmSaq0181Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<BaseDataInterfaceVO> list = command.searchLaneAdjust(event.getBaseDataInterfaceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0181 : Lane Adjust
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateLaneAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0181Event event = (EsmSaq0181Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateLaneAdjust(event.getBaseDataInterfaceVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0183 : CPB Adjust data 를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCPBAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0183Event event = (EsmSaq0183Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<BaseDataInterfaceVO> list = command.searchCPBAdjust(event.getBaseDataInterfaceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0183 : CPB Adjust
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateCPBAdjust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0183Event event = (EsmSaq0183Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateCPBAdjust(event.getBaseDataInterfaceVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline Initial Data 를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchGuidelineInitList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<BaseDataInterfaceVO> list = command.searchGuidelineInitList(event.getBaseDataInterfaceVO(), account);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline Data를 조회한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchGuidelineList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();

		try {
			List<BaseDataInterfaceVO> list = command.searchGuidelineList(event.getBaseDataInterfaceVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline Data를 수정한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateGuideline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateGuideline(event.getBaseDataInterfaceVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SAQ_0182 : Guideline Data를 Confirm한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateGuidelineConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateGuidelineConfirm(event.getBaseDataInterfaceVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SAQ_0182 : Guideline Data를 Confirm Cancel 한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateGuidelineCancelConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateGuidelineCancelConfirm(event.getBaseDataInterfaceVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SAQ_0182 : Guideline Data를 Notify 한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateGuidelineNotify(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateGuidelineNotify(event.getBaseDataInterfaceVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline Data를 Cancel Notification 한다.
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateGuidelineCancelNotify(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSaq0182Event event = (EsmSaq0182Event) e;
		MonthlyQuotaCreationBC command = new MonthlyQuotaCreationBCImpl();
		
		try {
			begin();
			command.updateGuidelineCancelNotify(event.getBaseDataInterfaceVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("SAQ00010").getUserMessage());
			eventResponse.setETCData("status", "OK");
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("ORA09999").getMessage());
		}
		return eventResponse;
	}
}

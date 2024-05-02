/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ServiceProviderInvoiceManageSC.java
 *@FileTitle : Off-dock CY Invoice Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage;

import java.util.List;

import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBC;
import com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBC;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0023Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0025Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0078Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0080Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0100Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0101Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.basic.MarineTerminalInvoiceManageBC;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.basic.MarineTerminalInvoiceManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0014Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0017Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9001Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9010Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9232Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9300Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCostCodeDetailListVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic.MarineTerminalStorageInvoiceManageBC;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic.MarineTerminalStorageInvoiceManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0009Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0019Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9142Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9234Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes9254Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic.OffdockCYInvoiceManageBC;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic.OffdockCYInvoiceManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0004Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0018Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9030Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9050Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9074Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9075Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9140Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9233Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9240Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes9253Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic.OndockRailChargeInvoiceManageBC;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic.OndockRailChargeInvoiceManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0064Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes0068Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9060Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9130Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9231Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event.EsdTes9251Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.TesJbExePerfLogVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;

/**
 * ESD Business Logic ServiceCommand<br>
 * Handling business transaction for ESD<br>
 * 
 * @author byungheeyoo
 * @see ESD_TES_004EventResponse,OffdockCYInvoiceManageDBDAO
 * @since J2EE 1.4
 */
public class ServiceProviderInvoiceManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * ESD preceding process for biz scenario<br>
	 * OffdockCYInvoiceManage preceding process for biz scenario<br>
	 */
	public void doStart() {
		try {
			// get sign user
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ServiceProviderInvoiceManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * ESD Handling for the end of working scenario<br>
	 * OffdockCYInvoiceManage Clearing object by the end of work scenario<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("ServiceProviderInvoiceManageSC 종료");
	}

	/**
	 * ESD Handling working scenario of each event<br>
	 * 
	 * @param e Event event object
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

		log.debug("\n\n SC ... event name : " + e.getEventName());

		/** Start ***/
		if (e.getEventName().equalsIgnoreCase("EsdTes0004Event")) {
			log.debug("\n##################" + e.getEventName() + " - SC.e.getFormCommand() : " + e.getFormCommand().getCommand() + "##################\n");

			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = createOffdockCYInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffdockCYInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Header
				eventResponse = searchOffdockCYCostCalcSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // Container List(CO, DC) Search
				eventResponse = searchOffdockCYContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Cost Calc.
				eventResponse = calOffdockCYInvoiceCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { // DTL
				eventResponse = searchOffdockCYInvoiceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) { // get all sheets
				eventResponse = searchOffdockCYInvoiceAllSheets(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyOffdockCYInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { // reject
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyOffdockCYInvoiceReject(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) { // COIN, DSCP, CALC.TMNL, CALC.ByDay sheet data delete
				eventResponse = removeOffdockCYInvoice01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) { // CALC.ByPool sheet data delete
				eventResponse = removeOffdockCYInvoice02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE03)) { // Calc.TMNL, Calc.ByDay sheet calculation data delete
				eventResponse = removeOffdockCYInvoiceAutoCalcData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE04)) {
				eventResponse = removeOffdockCYInvoiceAutoCalcDataAllCalcTab(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE05)) { // Calc.ByPool sheet calculation data delete
				eventResponse = removeOffdockCYInvoiceAutoCalcData2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE06)) { // Calc.TMNL, Calc.ByDay, Calc.ByPool sheet calculation data delete
				eventResponse = removeOffdockCYInvoiceAllCalcData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE07)) { // Calc.TMNL, Calc.ByDay, Calc.ByPool sheet calculation data delete
				eventResponse = removeOffdockCYInvoice03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Container List CUD
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = createOffdockCYInvoiceContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = createOffdockCYInvoiceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // connfirm
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyOffdockCYInvoiceConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0004Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_CF);
				eventResponse = cancelOffdockCYInvoiceConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // reject ('NL') set
				eventResponse = cancelOffdockCYInvoiceReject(e);
				// testCreateEDIinvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // reject ('NL') set
				eventResponse = multiOffDockTerminalInvoiceDBVerify(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectYdNm(((EsdTes0004Event) e).getTesTmlSoHdrVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0004Event) e).getTesTmlSoHdrVO());

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = this.searchDBCheckOffDockTerminalInvoice(e);

			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0009Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.ADD)) { // main hidden add
				eventResponse = createStorageInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // main hidden search
				eventResponse = searchStorageInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyStorageInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeStorageInvoice01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = removeStorageInvoice02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE03)) {
				eventResponse = removeStorageInvoiceAutoCalcData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE04)) {
				eventResponse = removeStorageInvoiceAutoCalcDataAllCalcTab(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE05)) {
				eventResponse = removeStorageInvoiceAutoCalcData2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE06)) {
				eventResponse = removeStorageInvoiceAllCalcData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE07)) {
				eventResponse = removeStorageInvoice03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyStorageInvoiceReject(e); // Reject
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchStorageContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = calStorageInvoiceCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchStorageInvoiceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				eventResponse = searchStorageInvoiceAllSheets(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // container list cud
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = createStorageInvoiceContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = createStorageInvoiceDetail(e); // Cost Calc.(SR by FD)
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_RC);
				eventResponse = modifyStorageInvoiceConfirm(e); // Confirm
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes0009Event) e).getTesTmlSoHdrVO(), TESInvoiceCommonBC.INV_STS_CF);
				eventResponse = cancelStorageInvoiceConfirm(e); // Cancel Confirm
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = cancelStorageInvoiceReject(e); // Cancel Reject
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) { // reject ('NL') set
				eventResponse = multiStorageTerminalInvoiceDBVerify(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectYdNm(((EsdTes0009Event) e).getTesTmlSoHdrVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0009Event) e).getTesTmlSoHdrVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = this.searchDBCheckStorageTerminalInvoice(e);

			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9030Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiReviseCalculatedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiReviseCalculatedVolumeM(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockRevisedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchOffdockRevisedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffdockCYReviseMode(e);
				// } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// eventResponse = searchOffdockCYRvisCntrListCdN(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOffdockCYRvisCntrListCdMT(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchOffdockCYRvisCntrListCdDG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOffdockCYRvisCntrListCdRF(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchOffdockCYRvisCntrListCdAK(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9050Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockCYTotalAmount(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9060Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchStorageTotalAmount(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9074Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockRevisedVolume2(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9075Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdockRevisedVolumeSeparate2(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9140Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = verifyOffdockCYInvoiceVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkDigitOffdock(e);
				// eBilling - B
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEDIOffdockCYInvoiceContainerList(e);
				// eBilling - E
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBkgCntrTPCD9140List(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9142Event")) {
			log.debug("\n xxx EsdTes9142Event " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = verifyStorageInvoiceVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Check Disit
				eventResponse = checkDigitStorage(e);
				// eBilling - B
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEDIStorageInvoiceContainerList(e);
				// eBilling - E
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBkgCntrTPCD9142List(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9233Event")) {
			log.debug("\n >>>>>>>>>>>>>>>>>>>>>> " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<<<<<<<<<<<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdock3rdIFlist(e);
				// } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				// eventResponse = searchOffdock3rdIFlistByPool(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchOffdock3rdIFlistByDay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiOffdock3rdIFlist(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9234Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			// if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
			// eventResponse = searchStorage3rdIFlist(e);
			// } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
			// eventResponse = searchStorage3rdIFlistByPool(e);
			// } else
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchStorage3rdIFlistByDay(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiStorage3rdIFlist(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9240Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiReviseCalculatedVolumeSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiReviseCalculatedVolumeSeparateM(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { // Auto
				eventResponse = searchOffdockRevisedVolumeSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { // Manual
				eventResponse = searchOffdockRevisedVolumeSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Manual - Get RVIS_CNTR_LIST_CD
				eventResponse = searchOffdockCYReviseModeSeparate(e);

				// } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //RVIS_CNTR_LIST_CD - N
				// eventResponse = searchOffdockCYRvisCntrListCdNSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // RVIS_CNTR_LIST_CD - MT
				eventResponse = searchOffdockCYRvisCntrListCdMTSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // RVIS_CNTR_LIST_CD - DG
				eventResponse = searchOffdockCYRvisCntrListCdDGSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // RVIS_CNTR_LIST_CD - RF
				eventResponse = searchOffdockCYRvisCntrListCdRFSeparate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // RVIS_CNTR_LIST_CD - AK
				eventResponse = searchOffdockCYRvisCntrListCdAKSeparate(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9253Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffdock3rdIFlistOnly(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9254Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchStorage3rdIFlistOnly(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes0025Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSOlist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiRejectedCSRCancellation(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0100Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRAPiflist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiConfirmCSR(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// new TESInvoiceCommonBCImpl().checkInvoiceStatus(((EsdTes100Event)e).getAP_INV_HDR().getCsr_no() ,TESInvoiceCommonBC.INV_STS_AR);
				eventResponse = cancelCSR(e);
			}
			// else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)){
			// eventResponse = modifyStsCdSOHDRBack(e);
			// }

		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0101Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSOlist2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCSRSOhdr(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes0018Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffdockCYInvoiceBasicInfoInquiry(e);
				/*
				 * }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) { //eventResponse = searchOffdockCYContainerListInquiry(e); log.debug("SEARCHLIST "+e.getFormCommand().getCommand()); }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) { log.debug("SEARCHLIST01 "+e.getFormCommand().getCommand()); //eventResponse = calOffdockCYInvoiceCostInquiry(e); }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) { log.debug("SEARCHLIST02 "+e.getFormCommand().getCommand()); //eventResponse = searchOffdockCYInvoiceDetailInquiry(e);
				 */} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
				log.debug("SEARCHLIST03 " + e.getFormCommand().getCommand());
				eventResponse = searchOffdockCYInvoiceAllSheetsInquiry(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0018Event) e).getTesTmlSoHdrVO());
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCSRSummary1(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSoIfCd(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0024Event")) {
			log.debug("EsdTes0024Event FormCommand=====================" + e.getFormCommand().getCommand());
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPreVeiw(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = tmpSearchCSRSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = tmpSearchPreVeiw(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = approvalRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchCSRSummaryDetail1(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes0078Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTAXInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchApEviNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTAXCode(e);
			}
		}

		// if (e.getEventName().equalsIgnoreCase("EsdTes0079Event")) {
		// if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
		// eventResponse = searchCSRSummaryDetail(e);
		// }
		// }

		if (e.getEventName().equalsIgnoreCase("EsdTes0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail2(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes0019Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStorageInvoiceBasicInfo2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchStorageContainerList2(e);
				// }else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
				// eventResponse = searchStorageInvoiceDetail2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0019Event) e).getTesTmlSoHdrVO());
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyTerminalInvoiceConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeTerminalInvoice(e);
				// } else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
				// eventResponse = validateEDIInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0013Event) e).getTesTmlSoHdrVO());
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalExpenseSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalExpenseVolumeSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0014Event) e).getTesTmlSoHdrVO());
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9300Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeHierarchy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSubOffice(e);
			}
		}

		/**
		 * On-Dock Rail Charge Container List Retrieve
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0068Event")) {
			if (log.isDebugEnabled())
				log.debug("\n\n" + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOndockRailChargeBasicInfo2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOndockRailChargeContainerList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0068Event) e).getTesTmlSoHdrVO());
			}
		}

		/**
		 * Marine Terminal Container List Retrieve
		 */

		if (e.getEventName().equalsIgnoreCase("EsdTes0017Event")) {
			log.debug("start EsdTes0017Event");
			if (log.isDebugEnabled())
				log.debug("\n\n" + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceBasicInfo2(e);
				// eventResponse = addMarineTerminalInvoiceManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalContainerList2(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0017Event) e).getTesTmlSoHdrVO());
			}
			/*
			 * else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { eventResponse = searchAccumulatedVolume2(e); } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { eventResponse = searchTerminalInvoiceCalculationList2(e); }
			 */
		}

		/**
		 * Terminal Invoice Part Start
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0001Event")) {
			log.debug("\n\n ### SC.EsdTes0001Event ####################### \n\n");
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchTerminalInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchMarineTerminalInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchMarineTerminalCNTRList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = this.calculateTerminalInvoiceCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchManualRvisDivision(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = this.createTerminalInvoiceBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = this.modifyTerminalInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = this.confirmMarineTerminalInvoice(e);// confirm
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = this.modifyTerminalInvoice(e);// reject
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = this.rejectLiftTerminalInvoice(e);// reject Lift
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = this.removeTerminalInvoiceContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE02)) {
				eventResponse = this.removeTerminalInvoiceCosts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE03)) {
				eventResponse = this.removeTerminalInvoiceContainerList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.multiTerminalInvoiceContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = this.multiTerminalInvoiceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = this.multiTerminalInvoiceDBVerify(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = this.searchTerminalInvoiceATBDt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = this.searchAccumulatedVolume(e);
				// }else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				// eventResponse = this.searchOtherCarrierAccountCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = this.modifyN3rdPartyAmount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI14)) {
				eventResponse = this.reVerifyTerminalInvoiceContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = this.searchTerminalInvoiceVVDDual(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectYdNm(((EsdTes0001Event) e).getTesTmlSoHdrVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0001Event) e).getTesTmlSoHdrVO());
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = this.searchDBCheckTerminalInvoice(e);

			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes1003Event")) {
			if (log.isDebugEnabled())
				log.debug("\n\n" + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceAutoBoundList(e);
				// eventResponse = addMarineTerminalInvoiceManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiTerminalInvoiceAutoBoundList(e);
			}
		}

		// File Import
		if (e.getEventName().equalsIgnoreCase("EsdTes9010Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = checkTerminalInvoiceContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkDigit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCOMListOnlyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchContainerListByWorkOrder(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchBkgCntrTPCD9010List(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchTemplateDownList(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9032Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutoRevisedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchManualRevisedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateContainerListRvisFlg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = updateContainerListRvisFlgManual(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9072Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMarineTerminalAutoRevisedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMarineTerminalManualRevisedVolume(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9190Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRehandlingVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = multiRehandlingVolume(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9191Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMarineTerminalRehandlingVolume(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9220Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccumulatedVolumeList(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9232Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutoTrdPartyVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchManualTrdPartyVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = multiTerminalInvoiceN3rdParyIF2(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9252Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMarineTerminalTrdPartyVolume(e);
			}
		}

		/*
		 * Terminal Invoice Part End
		 */

		/*
		 * On-Dock Rail Charge Invoice Part Start
		 */
		if (e.getEventName().equalsIgnoreCase("EsdTes0064Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " - 0064 SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = this.createOndockRailChargeBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = this.modifyOndockRailChargeBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchOndockRailChargeBasicInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiOndockRailChargeContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.multiOndockRailChargeInvoiceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = this.multiOnDockTerminalInvoiceDBVerify(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchOndockRailChargeContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchOndockRailChargeCostCalculationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = this.searchOnDockChargeInvoiceCostCalcComboCodeList(e);
				// }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				// eventResponse = this.searchOndockRailChargeInvoiceRvisList(e);
				// }else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				// eventResponse = this.searchOndockRailChargeInvoiceN3ptyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = this.removeOndockRailChargeInvoiceCost(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectYdNm(((EsdTes0064Event) e).getTesTmlSoHdrVO());

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = new TESInvoiceCommonBCImpl().selectVndrNm(((EsdTes0064Event) e).getTesTmlSoHdrVO());

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
				eventResponse = this.searchDBCheckOnDockTerminalInvoice(e);

			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9031Event")) {
			log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceRevisedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnDockAutoRevisedVolume(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTerminalInvoiceRevisedVolume9031(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = updateOnDockContainerListRvisFlg(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9130Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = verifyOndockRailChargeContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBkgCntrTPCD9130List(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTes9231Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalInvoiceN3ptyAutoCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalInvoiceN3ptyManualCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiTerminalInvoiceN3rdParyIF(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTes9251Event")) {
			if (log.isDebugEnabled())
				log.debug("\n " + e.getEventName() + " -  SC.e.getFormCommand():" + e.getFormCommand().getCommand() + "<<<<<\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnDockTrdPartyVolume(e);
			}
		}

		// MG Set
		if (e.getEventName().equalsIgnoreCase("EsdTes1004Event")) {
			log.debug("\n##################" + e.getEventName() + " - SC.e.getFormCommand() : " + e.getFormCommand().getCommand() + "##################\n");

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMGSetFuelingChargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiMGSetFuelingCharge(e);
			}
		}

		// ESD_TES_9001 popup
		if (e.getEventName().equalsIgnoreCase("EsdTes9001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCostCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCostCodeDetailList(e);
			}
		}

		return eventResponse;
	}

	/**
	 * 9001 팝업화면 searchCostCodeDetailList
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MarineTerminalInvoiceManageBCImpl command = null;
		try {
			// creating Impl each event
			EsdTes9001Event event = (EsdTes9001Event) e;
			command = new MarineTerminalInvoiceManageBCImpl();
			List<SearchCostCodeDetailListVO> list = command.searchCostCodeDetailList(event.getInfoVO(), event.getCmnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 9001 팝업화면 searchCostCodeList
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCostCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MarineTerminalInvoiceManageBCImpl command = null;
		try {
			// creating Impl each event
			EsdTes9001Event event = (EsdTes9001Event) e;
			command = new MarineTerminalInvoiceManageBCImpl();
			String cost_cd_inv_tp_cd = event.getCost_cd_inv_tp_cd();

			List<SearchCostCodeDetailListVO> list = command.searchCostCodeList(event.getInfoVO(), event.getCmnVO(), cost_cd_inv_tp_cd, event.getSignOnUserAccount());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Cost Calc. Automatic calculation
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calOffdockCYInvoiceCost(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.calOffdockCYInvoiceCost(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Cost Calc. Automatic calculation
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calStorageInvoiceCost(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.calStorageInvoiceCost(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * check digit process
	 * 
	 * @param e Event EsdTes914Event
	 * @return eventResponse ESD_TES_914EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDigitOffdock(Event e) throws EventException {
		log.debug("\n\n SC.checkDigitOffdock ----------------------------- \n");

		EsdTes9140Event event = (EsdTes9140Event) e;
		EventResponse eventResponse = null;
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);

			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);

			log.debug("\n checkDigit  ------------------------  \n");

			begin();
			command.updateCNTRNumber(event);
			commit();

			eventResponse = command.searchTES_FILE_IMP_TMP(event);

		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}

	/*
	 * // public EventResponse checkDigitOffdock(Event e) throws EventException { // // log.debug("\n\n SC.checkDigitOffdock ----------------------------- \n"); // // EsdTes9140Event event = (EsdTes9140Event)e; // EventResponse eventResponse = null; // OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl(); // // try { // log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n"); // command.removeTES_FILE_IMP_TMP(event); // // log.debug("\n 임시 TABLE에 넣고 ------------------------  \n"); // command.createTES_FILE_IMP_TMP(event); // // log.debug("\n checkDigit  ------------------------  \n"); // eventResponse = command.searchCNTRNumber(event); // // ESD_TES_914EventResponse er = (ESD_TES_914EventResponse)eventResponse; // event.setRowSet(er.getRs()); // log.debug("\n CNTR_LIST에 넣고 ------------------------  \n"); // // begin(); // command.updateCNTRNumber(event); // commit(); // eventResponse = command.searchTES_FILE_IMP_TMP(event); // } catch (EventException de) { // log.debug("\n EventException rollback ------------------------  \n"); // rollback(); // log.error("err " + de.toString(), de); // throw new EventException(de.getMessage()); // } finally { // log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n"); // command.removeTES_FILE_IMP_TMP(event); // } // return eventResponse; // }
	 */

	/**
	 * check digit process
	 * 
	 * @param e Event EsdTes9142Event
	 * @return eventResponse ESD_TES_9142EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDigitStorage(Event e) throws EventException {

		log.debug("\n\n SC.checkDigitStorage ----------------------------- \n");

		EsdTes9142Event event = (EsdTes9142Event) e;
		EventResponse eventResponse = null;
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);

			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);

			log.debug("\n checkDigit  ------------------------  \n");

			begin();
			command.updateCNTRNumber(event);
			commit();

			eventResponse = command.searchTES_FILE_IMP_TMP(event);
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}

	/**
	 * Search EDI CNTR List - eBilling
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIOffdockCYInvoiceContainerList(Event e) throws EventException {

		// log.debug("\n\n SC.searchEDIOffdockCYInvoiceContainerList ----------------------------- \n");
		log.debug(e.toString());
		// ESD_TES_914Event event = (ESD_TES_914Event)e;
		// EventResponse eventResponse = null;
		// OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

		// try {
		// eventResponse = command.searchEDIOffdockCYInvoiceContainerList(event);
		// } catch (EventException de) {
		// log.error("err " + de.toString(), de);
		// throw new EventException(de.getMessage());
		// }
		// return eventResponse;
		return null;
	}

	/**
	 * Search EDI CNTR List - eBilling
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerList(Event e) throws EventException {
		log.debug(e.toString());
		log.debug("\n\n SC.searchEDIStorageInvoiceContainerList ----------------------------- \n");

		EsdTes9142Event event = (EsdTes9142Event) e;
		EventResponse eventResponse = null;
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();

		try {
			eventResponse = command.searchEDIStorageInvoiceContainerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Off-dock verify
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyOffdockCYInvoiceVolume(Event e) throws EventException {

		log.debug("\n SC.verifyOffdockCYInvoiceVolume ------------------------  \n");

		EsdTes9140Event event = (EsdTes9140Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
		int insCnt = 0;

		String curr_seq = null;
		try {// 2009-03-12
			String pageURL = event.getPageURL();
			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
			tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setExeRowKnt(event.getTesFileImpTmpVOs() != null ? Integer.toString((event.getTesFileImpTmpVOs()).length) : "");
			tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
			tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			curr_seq = beginJobExecutionPerformance(tesJbExePerfLogVO);
		} catch (Exception ex) {
			// 본 업무에 영향을 안주기 위해 Exception을 던지지 않는다.
			log.error(ex.getMessage());
			// 20150413 소스 품질때문에 수정
			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		try {
			// 무조건 임시 TABLE 지우기 1
			log.debug("\n 무조건 임시 TABLE 지우기 1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);

			// 임시 TABLE에 넣고
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);

			// 계산하기
			log.debug("\n 계산하기 ------------------------  \n");
			eventResponse = command.verifyOffdockCYInvoiceVolume(event); // 계산하기
			event.setRowSet(eventResponse.getRs());

			// CNTR_LIST에 넣고
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			insCnt = command.insertOffdockCYInvoiceContainerList(event);
			commit();

			eventResponse.setETCData("insCnt", String.valueOf(insCnt));
			eventResponse.setETCData("successFlag", "SUCCESS");
		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(curr_seq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기 2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}

		endJobExecutionPerformance(curr_seq);

		return eventResponse;
	}

	/**
	 * Storage verify
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyStorageInvoiceVolume(Event e) throws EventException {

		log.debug("\n SC.verifyStorageInvoiceVolume ------------------------  \n");

		EsdTes9142Event event = (EsdTes9142Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
		int insCnt = 0;

		String curr_seq = null;
		try {// 2009-03-12
			String pageURL = event.getPageURL();
			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
			tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setExeRowKnt(event.getTesFileImpTmpVOs() != null ? Integer.toString((event.getTesFileImpTmpVOs()).length) : "");
			tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
			tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			curr_seq = beginJobExecutionPerformance(tesJbExePerfLogVO);
		} catch (Exception ex) {
			log.error(ex.getMessage());

			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		try {
			log.debug("\n 무조건 임시 TABLE 지우기 1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);

			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event); // 임시에 넣고

			log.debug("\n 계산하기 ------------------------  \n");
			eventResponse = command.verifyStorageInvoiceVolumne(event); // 계산하기
			event.setRowSet(eventResponse.getRs());

			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			insCnt = command.insertStorageInvoiceContainerList(event);
			commit();

			log.debug("insCnt ------------------------ " + insCnt);

			eventResponse.setETCData("insCnt", String.valueOf(insCnt));
			eventResponse.setETCData("successFlag", "SUCCESS");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			/**
			 * 2) DB에 성능LOG에 SC에서의 오류 발생 시각을 남기는 부분
			 */
			errorJobExecutionPerformance(curr_seq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기 2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}

		endJobExecutionPerformance(curr_seq);

		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceDetail(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchOffdockCYInvoiceDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceAllSheets(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchOffdockCYInvoiceAllSheets(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceDetail(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageInvoiceDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceAllSheets(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageInvoiceAllSheets(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolume(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolume() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchRevisedVolume(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolumeSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolumeSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchRevisedVolumeSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolume2(Event e) throws EventException {

		EsdTes9074Event event = (EsdTes9074Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolume2() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchRevisedVolume2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockRevisedVolumeSeparate2(Event e) throws EventException {

		EsdTes9075Event event = (EsdTes9075Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockRevisedVolumeSeparate2() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchRevisedVolumeSeparate2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYReviseMode(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYReviseMode() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYReviseMode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYReviseModeSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYReviseModeSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYReviseModeSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	// private EventResponse searchOffdockCYRvisCntrListCdNSeparate(Event e) throws EventException {
	//
	// EsdTes9240Event event = (EsdTes9240Event)e;
	//
	// EventResponse eventResponse = null;
	//
	// try {
	// log.debug("\n\n SC - searchOffdockCYRvisCntrListCdN() \n\n");
	// OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
	// eventResponse = command.searchOffdockCYRvisCntrListCdNSeparate(event);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdMT(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdMT() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdMT(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdMTSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdMTSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdMTSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdDG(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdDG() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdDG(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdDGSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdDGSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdDGSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdRF(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdRF() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdRF(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdRFSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdRFSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdRFSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdAK(Event e) throws EventException {

		EsdTes9030Event event = (EsdTes9030Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdAK() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdAK(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYRvisCntrListCdAKSeparate(Event e) throws EventException {

		EsdTes9240Event event = (EsdTes9240Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYRvisCntrListCdAKSeparate() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYRvisCntrListCdAKSeparate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * TPB 조회용 POPUP창에서 사용...
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdock3rdIFlistOnly(Event e) throws EventException {

		EsdTes9253Event event = (EsdTes9253Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdock3rdIFlistOnly() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchOffdock3rdIFlistOnly(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdock3rdIFlist(Event e) throws EventException {

		EsdTes9233Event event = (EsdTes9233Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdock3rdIFlist() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdock3rdIFlist(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdock3rdIFlistByDay(Event e) throws EventException {

		EsdTes9233Event event = (EsdTes9233Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdock3rdIFlistByDay() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdock3rdIFlistByDay(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOffdock3rdIFlist(Event e) throws EventException {
		log.debug("at dbdao.multiOffdock3rdIFlist()");

		EsdTes9233Event event = (EsdTes9233Event) e;
		TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
		String currSeq = null;

		// TPB IF 누락건 분석위한 로그추가.(2010-05-03)
		try {
			tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();

			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			StringBuilder sbuPerfRmk = new StringBuilder();
			int insFlgCnt = 0; // INSERT
			int updFlgCnt = 0; // UPDATE

			for (int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++) {
				if ("I".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
					insFlgCnt++;
				}
				if ("U".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
					updFlgCnt++;
				}
			}

			if (insFlgCnt > 0) {
				sbuPerfRmk.append("C");
			}
			if (updFlgCnt > 0) {
				sbuPerfRmk.append("U");
			}

			// TPB DELETE.
			String delIfSeq = JSPUtil.getNull(event.getOffdockCYInvoiceManageVO().getDelIfSeq());
			if (delIfSeq.length() > 0) {
				delIfSeq = delIfSeq.substring(0, delIfSeq.length() - 1); // .replaceAll("\\|", ",");
				String[] arrIfSeq = delIfSeq.split("\\|");

				sbuPerfRmk.append("D(" + arrIfSeq.length + ")");
			}

			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_TPB);
			tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setExeRowKnt(tesN3rdPtyIfVOs != null ? Integer.toString(tesN3rdPtyIfVOs.length) : "");
			tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesN3rdPtyIfVO().getTmlSoOfcCtyCd());
			tesJbExePerfLogVO.setTmlSoSeq(event.getTesN3rdPtyIfVO().getTmlSoSeq());
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			tesJbExePerfLogVO.setPerfRmk(sbuPerfRmk.toString());

			currSeq = beginJobExecutionPerformance(tesJbExePerfLogVO);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		String calc_cost_grp_cd = JSPUtil.getNull(event.getOffdockCYInvoiceManageVO().getCalcCostGrpCd());

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeSeparateMTPB(e);
			// command.recalculateReviseCalculatedVolumeCountSeparateMTPB(e);
			command.multiOffdock3rdIFlist(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(currSeq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		} finally {
			endJobExecutionPerformance(currSeq);
		}

		if ("SD".equals(calc_cost_grp_cd) || "EQ".equals(calc_cost_grp_cd)) {
			return searchOffdock3rdIFlistByDay(e);
		} else {
			return searchOffdock3rdIFlist(e);
		}
	}

	// private EventResponse searchOffdock3rdIFlistByPool(Event e) throws EventException {
	//
	// EsdTes9233Event event = (EsdTes9233Event)e;
	//
	// EventResponse eventResponse = null;
	//
	// try {
	// log.debug("\n\n SC - searchOffdock3rdIFlistByPool() \n\n");
	// OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
	// eventResponse = command.searchOffdock3rdIFlistByPool(event);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorage3rdIFlistOnly(Event e) throws EventException {
		log.debug("SC.searchStorage3rdIFlistOnly ###############################");
		EsdTes9254Event event = (EsdTes9254Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchStorage3rdIFlistOnly() \n\n");
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchStorage3rdIFlistOnly(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	// private EventResponse searchStorage3rdIFlist(Event e) throws EventException {
	// log.debug("SC.searchStorage3rdIFlist ###############################");
	// EsdTes9234Event event = (EsdTes9234Event)e;
	//
	// EventResponse eventResponse = null;
	//
	// try {
	// log.debug("\n\n SC - searchStorage3rdIFlist() \n\n");
	// MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
	// eventResponse = command.searchStorage3rdIFlist(event);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// private EventResponse searchStorage3rdIFlistByPool(Event e) throws EventException {
	// log.debug("SC.searchStorage3rdIFlistByPool ###############################");
	// EsdTes9234Event event = (EsdTes9234Event)e;
	//
	// EventResponse eventResponse = null;
	//
	// try {
	// log.debug("\n\n SC - searchStorage3rdIFlistByPool() \n\n");
	// MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
	// eventResponse = command.searchStorage3rdIFlistByPool(event);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorage3rdIFlistByDay(Event e) throws EventException {
		log.debug("SC.searchStorage3rdIFlistByDay ###############################");
		EsdTes9234Event event = (EsdTes9234Event) e;

		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchStorage3rdIFlistByDay() \n\n");
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorage3rdIFlistByDay(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiStorage3rdIFlist(Event e) throws EventException {

		EsdTes9234Event event = (EsdTes9234Event) e;

		TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
		String currSeq = null;

		try {
			tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();

			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			StringBuilder sbuPerfRmk = new StringBuilder();
			int insFlgCnt = 0; // INSERT
			int updFlgCnt = 0; // UPDATE

			for (int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++) {
				if ("I".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
					insFlgCnt++;
				}
				if ("U".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
					updFlgCnt++;
				}
			}

			if (insFlgCnt > 0) {
				sbuPerfRmk.append("C");
			}
			if (updFlgCnt > 0) {
				sbuPerfRmk.append("U");
			}

			// TPB DELETE.
			String delIfSeq = JSPUtil.getNull(event.getMarineTerminalStorageInvoiceManageVO().getDelIfSeq());
			if (delIfSeq.length() > 0) {
				delIfSeq = delIfSeq.substring(0, delIfSeq.length() - 1); // .replaceAll("\\|", ",");
				String[] arrIfSeq = delIfSeq.split("\\|");

				sbuPerfRmk.append("D(" + arrIfSeq.length + ")");
			}

			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_TPB);
			tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setExeRowKnt(tesN3rdPtyIfVOs != null ? Integer.toString(tesN3rdPtyIfVOs.length) : "");
			tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
			tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			tesJbExePerfLogVO.setPerfRmk(sbuPerfRmk.toString());

			currSeq = beginJobExecutionPerformance(tesJbExePerfLogVO);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.multiStorage3rdIFlist(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(currSeq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		} finally {
			endJobExecutionPerformance(currSeq);
		}
		return searchStorage3rdIFlistByDay(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYTotalAmount(Event e) throws EventException {

		EsdTes9050Event event = (EsdTes9050Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchOffdockCYTotalAmount() \n\n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchOffdockCYTotalAmount(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageTotalAmount(Event e) throws EventException {
		EsdTes9060Event event = (EsdTes9060Event) e;
		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchStorageTotalAmount() \n\n");
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOnDockTotalAmount(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYContainerList(Event e) throws EventException {
		// Object including the result of user request (DB Result Set, Object and etc)
		EsdTes0004Event event = (EsdTes0004Event) e;
		EventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYContainerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageContainerList(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageContainerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceBasicInfo(Event e) throws EventException {
		log.debug("at SC.searchOffdockCYInvoiceBasicInfo");
		EsdTes0004Event event = (EsdTes0004Event) e;

		EventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYInvoiceBasicInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceRejectInfo(Event e) throws EventException {

		log.debug("\n\n\n  SC.searchOffdockCYInvoiceRejectInfo  \n");

		EsdTes0004Event event = (EsdTes0004Event) e;

		EventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYInvoiceRejectInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceBasicInfo(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;
		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageInvoiceBasicInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceRejectInfo(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		EventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = command.searchStorageInvoiceRejectInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYCostCalcSts(Event e) throws EventException {
		log.debug("\n searchOffdockCYCostCalcSts \n");

		EsdTes0004Event event = (EsdTes0004Event) e;

		EventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = command.searchOffdockCYCostCalcSts(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOffdockCYInvoiceConfirm(Event e) throws EventException {
		log.debug("\n SC.modifyOffdockCYInvoiceConfirm  \n");

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			TESInvoiceCommonBC commandCom = new TESInvoiceCommonBCImpl();
			// CSRExternalFinderBC commandCSR = new CSRExternalFinderBCImpl();

			log.debug("(EsdTes0004Event)e).getTesTmlSoHdrVO().getTmlInvStsCd()============>" + ((EsdTes0004Event) e).getTesTmlSoHdrVO().getTmlInvStsCd());
			// String ofc_cd = ((EsdTes0004Event)e).getSignOnUserAccount().getOfc_cd();
			// if(!ofc_cd.equals("SELTOB")){
			commandCom.checkInvCalcCostCD(((EsdTes0004Event) e).getTesTmlSoHdrVO());
			// }

			command.modifyOffdockCYInvoiceConfirm(event);
			command.updateOffdockCYAccountCode(event);

			// ApPayInvVO apPayInvVO = commandCom.searchApPayInv(((EsdTes0004Event)e).getTesTmlSoHdrVO());
			// ApPayInvDtlVO[] apPayInvDtlVOs = commandCom.searchApPayInvDtl(((EsdTes0004Event)e).getTesTmlSoHdrVO(), ((EsdTes0004Event)e).getApPayInvVO());
			// String strInvRgstNo = commandCSR.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelOffdockCYInvoiceConfirm(Event e) throws EventException {
		log.debug("\n SC.cancelOffdockCYInvoiceConfirm  \n");

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			TESInvoiceCommonBC commandCom = new TESInvoiceCommonBCImpl();
			command.cancelOffdockCYInvoiceConfirm(event);
			commandCom.cancelApPayInvAll(event.getTesTmlSoHdrVO(), event.getApPayInvVO());

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * reject ('NL') set
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelOffdockCYInvoiceReject(Event e) throws EventException {
		log.debug("\n SC.cancelOffdockCYInvoiceReject  \n");

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.cancelOffdockCYInvoiceReject(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceRejectInfo(e);
	}

	/**
	 * multiOffDockTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiOffDockTerminalInvoiceDBVerify(Event e) throws EventException {

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    multiOffDockTerminalInvoiceDBVerify()");
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiOffDockTerminalInvoiceDBVerify(e);
			commit();

			return searchOffdockCYContainerList(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

	}

	/**
	 * searchDBCheckOffDockTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckOffDockTerminalInvoice(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchDBCheckOffDockTerminalInvoice() ============");

			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (EventResponse) command.searchDBCheckOffDockTerminalInvoice(e);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyStorageInvoiceConfirm(Event e) throws EventException {
		log.debug("\n SC.modifyStorageInvoiceConfirm  \n");

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			TESInvoiceCommonBC commandCom = new TESInvoiceCommonBCImpl();
			// CSRExternalFinderBC commandCSR = new CSRExternalFinderBCImpl();

			log.debug("(EsdTes0009Event)e).getTesTmlSoHdrVO().getTmlInvStsCd()============>" + ((EsdTes0009Event) e).getTesTmlSoHdrVO().getTmlInvStsCd());
			// String ofc_cd = ((EsdTes0009Event)e).getSignOnUserAccount().getOfc_cd();
			// if(!ofc_cd.equals("SELTOB")){
			commandCom.checkInvCalcCostCD(((EsdTes0009Event) e).getTesTmlSoHdrVO());
			// }

			command.modifyStorageInvoiceConfirm(event);
			command.updateStorageAccountCode(event);

			// ApPayInvVO apPayInvVO = commandCom.searchApPayInv(((EsdTes0009Event)e).getTesTmlSoHdrVO());
			// ApPayInvDtlVO[] apPayInvDtlVOs = commandCom.searchApPayInvDtl(((EsdTes0009Event)e).getTesTmlSoHdrVO(), ((EsdTes0009Event)e).getApPayInvVO());
			// String strInvRgstNo = commandCSR.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelStorageInvoiceConfirm(Event e) throws EventException {
		log.debug("\n SC.cancelStorageInvoiceConfirm  \n");

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			TESInvoiceCommonBC commandCom = new TESInvoiceCommonBCImpl();
			command.cancelStorageInvoiceConfirm(event);
			commandCom.cancelApPayInvAll(event.getTesTmlSoHdrVO(), event.getApPayInvVO());

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * Off Dock CY Invoice Creation & Correction - insert TES_TML_SO_HDR
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOffdockCYInvoiceBasicInfo(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.createOffdockCYInvoiceBasicInfo(event);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStorageInvoiceBasicInfo(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.createStorageInvoiceBasicInfo(event);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOffdockCYInvoice(Event e) throws EventException {

		log.debug("\n\n\n  SC.modifyOffdockCYInvoice  \n");

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.modifyOffdockCYInvoice(event);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOffdockCYInvoiceReject(Event e) throws EventException {

		log.debug("\n\n\n  SC.modifyOffdockCYInvoiceReject  \n");

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.modifyOffdockCYInvoiceReject(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceRejectInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyStorageInvoiceReject(Event e) throws EventException {

		log.debug("\n\n\n  SC.modifyStorageInvoiceReject  \n");

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.modifyStorageInvoiceReject(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceRejectInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelStorageInvoiceReject(Event e) throws EventException {

		log.debug("\n\n\n  SC.cancelStorageInvoiceReject  \n");

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.cancelStorageInvoiceReject(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceRejectInfo(e);
	}

	/**
	 * multiStorageTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiStorageTerminalInvoiceDBVerify(Event e) throws EventException {

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    multiStorageTerminalInvoiceDBVerify()");
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.multiStorageTerminalInvoiceDBVerify(e);
			commit();

			return searchStorageContainerList(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * searchDBCheckStorageTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckStorageTerminalInvoice(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchDBCheckStorageTerminalInvoice() ============");

			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = (EventResponse) command.searchDBCheckStorageTerminalInvoice(e);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyStorageInvoice(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.modifyStorageInvoice(event);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoice01(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYInvoiceContainerList(event);
			command.removeOffdockCYInvoiceRvis(event);
			command.removeOffdockCYInvoiceN3rd01(event);
			command.removeOffdockCYInvoiceDetailTMNL(event);
			command.removeOffdockCYInvoiceDetailByDay(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoice02(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYInvoiceN3rd02(event);
			command.removeOffdockCYInvoiceDetailByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * removeOffdockCYInvoice03
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse removeOffdockCYInvoice03(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYInvoiceN3rd03(event);
			command.removeOffdockCYInvoiceDetailByEQ(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceBasicInfo(e);
	}

	/**
	 * Calc.TMNL, Calc.ByDay sheet data delete
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoiceAutoCalcData(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYAutoCalcTMNL(event);
			command.removeOffdockCYAutoCalcByDay(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoiceAutoCalcData2(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYAutoCalcByPool(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoiceAllCalcData(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

			command.removeOffdockCYInvoiceRvis(event);
			command.removeOffdockCYInvoiceN3rd01(event);

			command.removeOffdockCYInvoiceDetailTMNL(event);
			command.removeOffdockCYInvoiceDetailByDay(event);
			command.removeOffdockCYInvoiceDetailByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOffdockCYInvoiceAutoCalcDataAllCalcTab(Event e) throws EventException {

		EsdTes0004Event event = (EsdTes0004Event) e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.removeOffdockCYAutoCalcTMNL(event);
			command.removeOffdockCYAutoCalcByDay(event);
			command.removeOffdockCYAutoCalcByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoice01(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageInvoiceContainerList(event);
			command.removeStorageInvoiceN3rd01(event);
			command.removeStorageInvoiceDetailByDay(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoice02(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageInvoiceN3rd02(event);
			command.removeStorageInvoiceDetailByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoice03(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageInvoiceN3rd03(event);
			command.removeStorageInvoiceDetailByEq(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceBasicInfo(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoiceAutoCalcData(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageAutoCalcByDay(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoiceAutoCalcData2(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageAutoCalcByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoiceAllCalcData(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageInvoiceN3rd01(event);
			command.removeStorageInvoiceDetailByDay(event);
			command.removeStorageInvoiceDetailByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeStorageInvoiceAutoCalcDataAllCalcTab(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.removeStorageAutoCalcByDay(event);
			command.removeStorageAutoCalcByPool(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * OffdockCYInvoiceContainerList Multi event process<br>
	 * OffdockCYInvoiceContainerList OffdockCYInvoiceContainerList Multi event process<br>
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOffdockCYInvoiceContainerList(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.createOffdockCYInvoiceContainerList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYContainerList(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStorageInvoiceContainerList(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.createStorageInvoiceContainerList(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageContainerList(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolume(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolume(e);
			command.recalculateReviseCalculatedVolumeCount(e);
			command.recalculateOffdocCYInvoiceCostAmount(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolume(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolumeM(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeM(e);
			command.recalculateReviseCalculatedVolumeCountM(e);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolume(e);
	}

	/**
	 * Revised Vol. Separate - Auto
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolumeSeparate(Event e) throws EventException {

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeSeparate(e);
			command.recalculateReviseCalculatedVolumeCountSeparate(e);
			command.recalculateOffdocCYInvoiceCostAmountSeparate(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolumeSeparate(e);
	}

	/**
	 * multiReviseCalculatedVolumeSeparateM
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiReviseCalculatedVolumeSeparateM(Event e) throws EventException {

		// ESD_TES_924Event event = (ESD_TES_924Event)e;

		try {
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.multiReviseCalculatedVolumeSeparateM(e);
			command.recalculateReviseCalculatedVolumeCountSeparateM(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockRevisedVolumeSeparate(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createOffdockCYInvoiceDetail(Event e) throws EventException {
		try {
			log.debug("in createOffdockCYInvoiceDetail");
			begin();
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			command.createOffdockCYInvoiceDetail(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchOffdockCYInvoiceDetail(e);
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createStorageInvoiceDetail(Event e) throws EventException {

		EsdTes0009Event event = (EsdTes0009Event) e;

		try {
			begin();
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			command.createStorageInvoiceDetail(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchStorageInvoiceDetail(e);
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceBasicInfoInquiry(Event e) throws EventException {

		log.debug(">>>>>>>>>>> searchOffdockCYInvoiceBasicInfoInquiry");

		EsdTes0018Event event = (EsdTes0018Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchOffdockCYInvoiceBasicInfoInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	// private EventResponse searchOffdockCYContainerListInquiry(Event e) throws EventException {
	// // Object including the result of user request (DB Result Set, Object and etc)
	// EsdTes0018Event event = (EsdTes0018Event)e;
	// GeneralEventResponse eventResponse = null;
	//
	// try {
	// OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
	// eventResponse = (GeneralEventResponse)command.searchOffdockCYContainerListInquiry(event);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// private EventResponse calOffdockCYInvoiceCostInquiry(Event e) throws EventException {
	//
	// EsdTes0018Event event = (EsdTes0018Event)e;
	//
	// EventResponse eventResponse = null;
	//
	// try {
	// OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
	// eventResponse = command.calOffdockCYInvoiceCostInquiry(event);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	// private EventResponse searchOffdockCYInvoiceDetailInquiry(Event e) throws EventException {
	//
	// EsdTes0018Event event = (EsdTes0018Event)e;
	//
	// GeneralEventResponse eventResponse = null;
	//
	// try {
	// OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();
	// eventResponse = (GeneralEventResponse)command.searchOffdockCYInvoiceDetailInquiry(event);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffdockCYInvoiceAllSheetsInquiry(Event e) throws EventException {

		log.debug("\n SC.searchOffdockCYInvoiceAllSheetsInquiry 111 -------------- \n");

		EsdTes0018Event event = (EsdTes0018Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			log.debug("\n SC.searchOffdockCYInvoiceAllSheetsInquiry 222 debug -------------- \n");
			log.error("\n SC.searchOffdockCYInvoiceAllSheetsInquiry 222 error -------------- \n");
			OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

			eventResponse = (GeneralEventResponse) command.searchOffdockCYInvoiceAllSheetsInquiry(event);

			log.debug("\n SC.searchOffdockCYInvoiceAllSheetsInquiry 333 -------------- \n");
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	// private EventResponse searchStorageInvoiceDetail2(Event e) throws EventException {
	//
	// ESD_TES_019Event event = (ESD_TES_019Event)e;
	//
	// EventResponse eventResponse = null;
	//
	// try {
	// MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
	// eventResponse = command.searchStorageInvoiceDetail2(event);
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	/**
	 * Storage Container List
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageContainerList2(Event e) throws EventException {

		EsdTes0019Event event = (EsdTes0019Event) e;

		GeneralEventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchStorageContainerList2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Search header info(main sheet)
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStorageInvoiceBasicInfo2(Event e) throws EventException {

		EsdTes0019Event event = (EsdTes0019Event) e;
		if (log.isDebugEnabled())
			log.debug("\n\n***********ServiceProviderInvoiceManageSC : searchStorageInvoiceBasicInfo2 ************\n");
		GeneralEventResponse eventResponse = null;

		try {
			MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();
			eventResponse = (GeneralEventResponse) command.searchStorageInvoiceBasicInfo2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/*
	 * On-Dock Rail Charge ContanerList Inquiry Start
	 */
	/**
	 * User Input Inv No, Vndr Seq TerminalInvoice retrieve event process On-dockRa Rail Charge Container List Event Process<br>
	 * 
	 * @param e Event EsdTes0068Event
	 * @return eventResponse ESD_TES_0068EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeBasicInfo2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		EsdTes0068Event event = (EsdTes0068Event) e;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeBasicInfo2(event);
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeBasicInfo2() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeBasicInfo2() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Retrieve event process OnDockRailChargeInvoiceManage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOndockRailChargeContainerList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0068Event event = (EsdTes0068Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		if (log.isDebugEnabled())
			log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeContainerList2() ============");
		try {
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeContainerList2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Terminal Invoice Inquery - Summary
	 */

	/**
	 * retrieve event process marineterminalinvoicemanage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceSummary(Event e) throws EventException {
		log.debug("*******ServiceProviderInvoiceManageSC : searchTerminalInvoiceSummary********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0013Event event = (EsdTes0013Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		String curr_seq = null;
		try {

			/*
			 * HashMap param_map = new HashMap(); param_map.put("ofc_cd",e.getSignOnUserAccount().getOfc_cd()); param_map.put("usr_id",e.getSignOnUserAccount().getUsr_id()); param_map.put("jb_tp_cd",TESCommonBC.PERF_JOB_TYPE_ON_LINE); param_map.put("pgm_url",(pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName()))); param_map.put("f_cmd",event.getEventParams().get("f_cmd")); param_map.put("param_val",TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0013Event)e).getEventParams())); log.debug("\n\n  ##### SC..beginJobExecutionPerformance  \n\n"); curr_seq = beginJobExecutionPerformance(param_map);
			 */
			// TESCommonEvent tESCommonEvent = new TESCommonEvent();
			//
			// tESCommonEvent.getTesCommonVO().setOfcCd(e.getSignOnUserAccount().getOfc_cd());
			// tESCommonEvent.getTesCommonVO().setUsrId(e.getSignOnUserAccount().getUsr_id());
			// tESCommonEvent.getTesCommonVO().setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
			// tESCommonEvent.getTesCommonVO().setPgmUrl((pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
			// tESCommonEvent.getTesCommonVO().setFCmd(event.getFormCommand().toString());
			// tESCommonEvent.getTesCommonVO().setParamVal(TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0013Event)e).getEventParams()));
			// curr_seq = beginJobExecutionPerformance(tESCommonEvent.getTesJbExePerfLogVO());

			String pageURL = event.getPageURL();
			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
			tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			curr_seq = beginJobExecutionPerformance(tesJbExePerfLogVO);

		} catch (Exception ex) {
			log.error(ex.getMessage());

			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(curr_seq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		}

		endJobExecutionPerformance(curr_seq);

		return eventResponse;
	}

	// private EventResponse searchTerminalInvoiceSummary(Event e) throws EventException {
	// // PDTO(Data Transfer Object including Parameters)
	// GeneralEventResponse eventResponse = new GeneralEventResponse();
	// MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
	// EsdTes0013Event event = (EsdTes0013Event)e;
	//
	// try{
	// List<searchTerminalInvoiceSummaryVO> list = command.searchTerminalInvoiceSummary(event.getsearchTerminalInvoiceSummaryVO());
	// eventResponse.setRsVoList(list);
	// }catch(EventException ex){
	// throw ex;
	// }catch(Exception ex){
	// throw new EventException(ex.getMessage(), ex);
	// }
	// return eventResponse;
	// }

	/**
	 * Terminal Invoice Inquery - Summary
	 */

	/**
	 * Retrieve event process marineterminalinvoicemanage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalExpenseSummary(Event e) throws EventException {
		log.debug("*******ServiceProviderInvoiceManageSC : searchTerminalExpenseSummary $$$********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0014Event event = (EsdTes0014Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		String curr_seq = null;
		try {

			// HashMap param_map = new HashMap();
			// param_map.put("ofc_cd",e.getSignOnUserAccount().getOfc_cd());
			// param_map.put("usr_id",e.getSignOnUserAccount().getUsr_id());
			// param_map.put("jb_tp_cd",TESCommonBC.PERF_JOB_TYPE_ON_LINE);
			// param_map.put("pgm_url",(pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
			// param_map.put("f_cmd",event.getParam_map().get("f_cmd"));
			// param_map.put("param_val",TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0014Event)e).getParam_map()));
			// log.debug("\n\n  ##### SC..beginJobExecutionPerformance  \n\n");
			// curr_seq = beginJobExecutionPerformance(param_map);
			//
			// TESCommonEvent tESCommonEvent = new TESCommonEvent();
			//
			// //TesCommonVO tesCommonVO = new TesCommonVO();
			// tESCommonEvent.getTesCommonVO().setOfcCd(e.getSignOnUserAccount().getOfc_cd());
			// tESCommonEvent.getTesCommonVO().setUsrId(e.getSignOnUserAccount().getUsr_id());
			// tESCommonEvent.getTesCommonVO().setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
			// tESCommonEvent.getTesCommonVO().setPgmUrl((pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
			// tESCommonEvent.getTesCommonVO().setFCmd(event.getFormCommand().toString());
			// tESCommonEvent.getTesCommonVO().setParamVal(TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0013Event)e).getEventParams()));
			// curr_seq = beginJobExecutionPerformance(tESCommonEvent.getTesJbExePerfLogVO());

			String pageURL = event.getPageURL();
			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
			tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			curr_seq = beginJobExecutionPerformance(tesJbExePerfLogVO);

		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalExpenseSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(curr_seq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		}

		endJobExecutionPerformance(curr_seq);

		return eventResponse;
	}

	/**
	 * Retrieve event process marineterminalinvoicemanage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeHierarchy(Event e) throws EventException {

		log.debug("*******ServiceProviderInvoiceManageSC : searchOfficeHierarchy********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9300Event event = (EsdTes9300Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchOfficeHierarchy(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Retrieve event process marineterminalinvoicemanage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubOffice(Event e) throws EventException {

		log.debug("*******ServiceProviderInvoiceManageSC : searchSubOffice********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes9300Event event = (EsdTes9300Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchSubOffice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process marineterminalinvoicemanage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalExpenseVolumeSummary(Event e) throws EventException {

		log.debug("*******ServiceProviderInvoiceManageSC : searchTerminalExpenseVolumeSummary********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0014Event event = (EsdTes0014Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		String curr_seq = null;
		try {// 2009-03-12

			// HashMap param_map = new HashMap();
			// param_map.put("ofc_cd",e.getSignOnUserAccount().getOfc_cd());
			// param_map.put("usr_id",e.getSignOnUserAccount().getUsr_id());
			// param_map.put("jb_tp_cd",TESCommonBC.PERF_JOB_TYPE_ON_LINE);
			// param_map.put("pgm_url",(pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
			// param_map.put("f_cmd",event.getParam_map().get("f_cmd"));
			// param_map.put("param_val",TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0014Event)e).getParam_map()));
			// log.debug("\n\n  ##### SC..beginJobExecutionPerformance  \n\n");
			// curr_seq = beginJobExecutionPerformance(param_map);

			// TESCommonEvent tESCommonEvent = new TESCommonEvent();
			//
			// //TesCommonVO tesCommonVO = new TesCommonVO();
			// tESCommonEvent.getTesCommonVO().setOfcCd(e.getSignOnUserAccount().getOfc_cd());
			// tESCommonEvent.getTesCommonVO().setUsrId(e.getSignOnUserAccount().getUsr_id());
			// tESCommonEvent.getTesCommonVO().setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
			// tESCommonEvent.getTesCommonVO().setPgmUrl((pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
			// tESCommonEvent.getTesCommonVO().setFCmd(event.getFormCommand().toString());
			// tESCommonEvent.getTesCommonVO().setParamVal(TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes0013Event)e).getEventParams()));
			// curr_seq = beginJobExecutionPerformance(tESCommonEvent.getTesJbExePerfLogVO());

			String pageURL = event.getPageURL();
			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
			tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			curr_seq = beginJobExecutionPerformance(tesJbExePerfLogVO);

		} catch (Exception ex) {
			log.error(ex.getMessage());

			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalExpenseVolumeSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(curr_seq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		}

		endJobExecutionPerformance(curr_seq);

		return eventResponse;
	}

	/**
	 * Update Event Process<br>
	 * marineterminalinvoicemanage Specific list Update Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalInvoiceConfirm(Event e) throws EventException {
		log.debug("*******ServiceProviderInvoiceManageSC : modifyTerminalInvoiceConfirm********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0013Event event = (EsdTes0013Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.modifyTerminalInvoiceConfirm(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Update Event Process<br>
	 * marineterminalinvoicemanage Specific list Update Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */

	private EventResponse removeTerminalInvoice(Event e) throws EventException {
		log.debug("*******ServiceProviderInvoiceManageSC : RemoveTerminalInvoice********\n");
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0013Event event = (EsdTes0013Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.removeTerminalInvoice(event);
			log.info("\n\n [SC][removeTerminalInvoice][] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + eventResponse.toString());

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * EDI Invoice Validation TEST<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	// private EventResponse validateEDIInvoice(Event e)throws EventException{
	// log.debug(e.toString());
	// log.debug("*******ServiceProviderInvoiceManageSC : validateEDIInvoice********\n");
	//
	// EsdTes0013Event event = (EsdTes0013Event)e;
	// EventResponse eventResponse = null;
	//
	// try {
	// begin();
	// com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC comBC =
	// new com.clt.apps.opus.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl();
	// //Change
	// comBC.validateEDIInvoice(event.getEventParams().get("tml_edi_so_ofc_cty_cd").toString(), event.getEventParams().get("tml_edi_so_seq").toString());
	// commit();
	// } catch (EventException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// // return null;
	// }

	/**
	 * MarineTerminal ContainerList Inquery
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceBasicInfo2(Event e) throws EventException {
		if (log.isDebugEnabled())
			log.debug("\n\nServiceProvider Invoice ManageSC :::::::: searchTerminalInvoiceBasicInfo2\n");

		EsdTes0017Event event = (EsdTes0017Event) e;
		EventResponse eventResponse = null;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceBasicInfo2(event);
		} catch (EventException de) {
			log.error("err" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalContainerList2(Event e) throws EventException {
		if (log.isDebugEnabled())
			log.debug("\n\nServiceProvider Invoice ManageSC :::::::: searchTerminalContainerList2\n");
		EsdTes0017Event event = (EsdTes0017Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalContainerList2(event);
		} catch (EventException de) {
			log.error("err" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	// /**
	// * @param e
	// * @return EventResponse
	// * @exception EventException
	// */
	// private EventResponse searchAccumulatedVolume2(Event e) throws EventException{
	// if(log.isDebugEnabled()) log.debug("\n\nServiceProvider Invoice ManageSC :::::::: searchAccumulatedVolume2\n");
	// EsdTes0017Event event = (EsdTes0017Event)e;
	// EventResponse eventResponse = null;
	//
	// try{
	// MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
	// eventResponse = command.searchAccumulatedVolume2(event);
	// }catch(EventException de){
	// log.error("err" + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// return eventResponse;
	// }

	/*
	 * private EventResponse searchTerminalInvoiceCalculationList2(Event e) throws EventException{ if(log.isDebugEnabled()) log.debug("\n\nServiceProvider Invoice ManageSC :::::::: searchTerminalInvoiceCalculationList2\n");
	 * 
	 * EsdTes0017Event event = (EsdTes0017Event)e; EventResponse eventResponse = null;
	 * 
	 * try{ MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl(); eventResponse = command.searchTerminalInvoiceCalculationList2(event); }catch(EventException de){ log.error("err" + de.toString(), de); throw new EventException(de.getMessage()); } return eventResponse; }
	 */

	/**
	 * retrieve event process MarineTerminalInvoiceManage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceBasicInfo() ============");
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceBasicInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process MarineTerminalInvoiceManage retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMarineTerminalInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalInvoice() ============");
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalInvoice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process MarineTerminalInvoiceManage retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMarineTerminalCNTRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalInvoice() ============");
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalCNTRList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process MarineTerminalInvoiceManage retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMarineTerminalInvoiceCNTRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalInvoiceCNTRList() ============");
		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalInvoiceCNTRList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process MarineTerminalInvoiceManage retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMarineTerminalInvoiceCosts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalInvoiceCosts() ============");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalInvoiceCosts(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * TerminalInvoiceCalculationList retrieve event process ESD_TES_0001 TerminalInvoiceCalculationList retrieve event process
	 * 
	 * @param e EsdTes0001Event
	 * @return EventResponse ESD_TES_001EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateTerminalInvoiceCost(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTes0001Event event = (EsdTes0001Event) e;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    calculateTerminalInvoiceCost()");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.calculateTerminalInvoiceCost(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * ATB DATE retrieve event process MarineTerminalInvoiceManage ATB DATE retrieve event process
	 * 
	 * @param e EsdTes001Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceATBDt(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceATBDt() ============");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceATBDt(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Revised Container Division retrieve event process MarineTerminalInvoiceManage Revised Container Division retrieve event process
	 * 
	 * @param e EsdTes001Event
	 * @return eventResponse ESD_TES_001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRvisDivision(Event e) throws EventException {
		EventResponse eventResponse = null;
		// EsdTes0001Event event =(EsdTes0001Event)e;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchManualRvisDivision()");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchManualRvisDivision(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Accumulate Vol retrieve event process MarineTerminalInvoiceManage Accumulate Vol retrieve event process
	 * 
	 * @param e EsdTes001Event
	 * @return eventResponse ESD_TES_001EventResponse
	 * @exception EventException
	 */

	public EventResponse searchAccumulatedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchAccumulatedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchAccumulatedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	// /**
	// * Accumulate Vol retrieve event process
	// * MarineTerminalInvoiceManage Accumulate Vol retrieve event process
	// *
	// * @param e EsdTes001Event
	// * @return eventResponse EventResponse
	// * @exception EventException
	// */
	//
	// public EventResponse searchOtherCarrierAccountCode(Event e) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// if(log.isDebugEnabled())log.debug("\n==========ServiceProviderInvoiceManageSC    searchOtherCarrierAccountCode()");
	// MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
	// eventResponse = command.searchOtherCarrierAccountCode(e);
	//
	// } catch (EventException de) {
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	//
	// return eventResponse;
	// }

	/**
	 * Add Event Process<br>
	 * MarineTerminalInvoiceManage Add Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createTerminalInvoiceBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event) e;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    createTerminalInvoiceBasicInfo() ============");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.createTerminalInvoiceBasicInfo(event);
			// VVD Creation
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchTerminalInvoiceBasicInfo(e);
	}

	/**
	 * Update Event Process<br>
	 * MarineTerminalInvoiceManage Update Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTerminalInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event) e;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    modifyTerminalInvoice() ============");

			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			TESInvoiceCommonBC commandCom = new TESInvoiceCommonBCImpl();
			command.modifyTerminalInvoice(event);
			commandCom.cancelApPayInvAll(event.getTesTmlSoHdrVO(), event.getApPayInvVO());

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalInvoiceBasicInfo(e);
	}

	/**
	 * Update Event Process<br>
	 * MarineTerminalInvoiceManage Update Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyN3rdPartyAmount(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTes0001Event event = (EsdTes0001Event) e;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    modifyN3rdPartyAmount() ============");

			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.modifyN3rdPartyAmount(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Update Event Process<br>
	 * MarineTerminalInvoiceManage Update Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmMarineTerminalInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    confirmMarineTerminalInvoice() ============");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			TESInvoiceCommonBC commandCom = new TESInvoiceCommonBCImpl();
			// CSRExternalFinderBC commandCSR = new CSRExternalFinderBCImpl();

			begin();
			// command.searchMgsetCount(e);

			// String ofc_cd = ((EsdTes0001Event)e).getSignOnUserAccount().getOfc_cd();
			// if(!ofc_cd.equals("SELTOB")){
			commandCom.checkInvCalcCostCD(((EsdTes0001Event) e).getTesTmlSoHdrVO());
			// }

			command.multiTerminalInvoiceVVD(e);
			command.checkMissingVVD(e);
			command.multiTerminalInvoiceDetail(e);
			command.modifyTerminalInvoice(e);

			// ApPayInvVO apPayInvVO = commandCom.searchApPayInv(((EsdTes0001Event)e).getTesTmlSoHdrVO());
			// ApPayInvDtlVO[] apPayInvDtlVOs = commandCom.searchApPayInvDtl(((EsdTes0001Event)e).getTesTmlSoHdrVO(), ((EsdTes0001Event)e).getApPayInvVO());
			// String strInvRgstNo = commandCSR.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}

		return this.searchTerminalInvoiceBasicInfo(e);
	}

	/**
	 * Update Event Process<br>
	 * MarineTerminalInvoiceManage Update Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectLiftTerminalInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0001Event event = (EsdTes0001Event) e;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    rejectLiftTerminalInvoice() ============");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.rejectLiftTerminalInvoice(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchTerminalInvoiceBasicInfo(e);
	}

	/**
	 * retrieve event process MarineTerminalInvoiceManage retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceContainerList(Event e) throws EventException {
		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    multiTerminalInvoiceContainerList()");

			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.multiTerminalInvoiceVVD(e);
			command.checkMissingVVD(e);
			command.multiTerminalInvoiceContainerList(e);

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMarineTerminalInvoiceCNTRList(e);
	}

	/**
	 * Multi Event Process<br>
	 * MarineTerminalInvoiceManage Multi Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// Object including the result of user request (DB Result Set, Object and etc)

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    multiTerminalInvoiceDetail()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.multiTerminalInvoiceVVD(e);
			command.checkMissingVVD(e);
			command.multiTerminalInvoiceDetail(e);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMarineTerminalInvoiceCosts(e);
	}

	/**
	 * multiTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiTerminalInvoiceDBVerify(Event e) throws EventException {

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    multiTerminalInvoiceDBVerify()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.multiTerminalInvoiceDBVerify(e);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMarineTerminalCNTRList(e);
	}

	/**
	 * Delete Event Process<br>
	 * MarineTerminalInvoiceManage Delete Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    removeTerminalInvoiceContainerList()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.removeTerminalInvoiceContainerList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Delete Event Process<br>
	 * MarineTerminalInvoiceManage Delete Event Process<br>
	 * removeTerminalInvoiceContainerList Difference : VVD List does not delete
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    removeTerminalInvoiceContainerList2()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.removeTerminalInvoiceContainerList2(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Delete Event Process<br>
	 * MarineTerminalInvoiceManage Delete Event Process<br>
	 * Delete TES_TML_SO_DTL, TES_TML_SO_RVIS_LIST, TES_N3RD_PTY_IF
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceCosts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// Object including the result of user request (DB Result Set, Object and etc)

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    removeTerminalInvoiceCosts()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.removeTerminalInvoiceCosts(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMarineTerminalInvoiceCosts(e);
	}

	/**
	 * retrieve event process MarineTerminalInvoiceManage retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse updateContainerListRvisFlg(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    updateContainerListRvisFlg()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.updateContainerListRvisFlg(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Terminal invoice Update manual rvis.vol
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateContainerListRvisFlgManual(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			log.debug("\n ServiceProviderInvoiceManageSC - updateContainerListRvisFlgManual()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.updateContainerListRvisFlgManual(e);
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
	 * MarineTerminalInvoiceManage Multi Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse reVerifyTerminalInvoiceContainerList(Event e) throws EventException {
		// ESD_TES_901EventResponse eventResponse = null;
		EsdTes0001Event event = (EsdTes0001Event) e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    reVerifyTerminalInvoiceContainerList()");

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP2(event);
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMPforReverify(event);
			log.debug("\n CNTR List 삭제하고 ------------------------  \n");
			command.removeTerminalInvoiceContainerList2(event);
			// Verify
			log.debug("\n Verify : Imported File ------------------------  \n");
			eventResponse = command.reVerifyTerminalInvoiceContainerList(event);
			// ESD_TES_001EventResponse er = (ESD_TES_001EventResponse)eventResponse;
			// er = (ESD_TES_001EventResponse)eventResponse;
			event.setRowSet(eventResponse.getRs());

			// CNTR_LIST
			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.createTerminalInvoiceContainerList2(event);
			commit();
			// eventResponse = er;

		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP2(event);
		}
		return searchMarineTerminalCNTRList(e);
	}

	/******************************************* EsdTes9010Event : File Import Start *******************************************/
	/**
	 * FinalBayFlanSource COMListOnly Search Event Process<br>
	 * CotainerList PopUp FinalBayFlanSource COMListOnly Search Event Process<br>
	 * 
	 * @param e EsdTes9010Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCOMListOnlyList(Event e) throws EventException {
		EsdTes9010Event event = (EsdTes9010Event) e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    searchCOMListOnlyList()");

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);

			String costCdFtrRmk = new TESInvoiceCommonBCImpl().selectCostCdFtrRmk(event.getTesTmlSoHdrVO());
			event.getTesTmlSoHdrVO().setCostCdFtrRmk(costCdFtrRmk);

			// Verify
			log.debug("\n Verify : COM LIST ONLY ------------------------  \n");
			eventResponse = command.searchCOMListOnlyList(event);
			event.setRowSet(eventResponse.getRs());

			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.createTerminalInvoiceVVD(event);
			// command.deleteTerminalInvoiceContainerList(event);
			command.createTerminalInvoiceContainerList(event);
			commit();

		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}
	
	/**
	 * Search Template Down Event Process<br>
	 * CotainerList PopUp Search Template Down Event Process<br>
	 * 
	 * @param e EsdTes9010Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTemplateDownList(Event e) throws EventException {
		EsdTes9010Event event = (EsdTes9010Event) e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC searchCOMListOnlyList()");

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);

			String costCdFtrRmk = new TESInvoiceCommonBCImpl().selectCostCdFtrRmk(event.getTesTmlSoHdrVO());
			event.getTesTmlSoHdrVO().setCostCdFtrRmk(costCdFtrRmk);

			// Verify
			log.debug("\n Verify : Template Down ------------------------  \n");
			eventResponse = command.searchCOMListOnlyList(event);
			event.setRowSet(eventResponse.getRs());

		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}

	/**
	 * FinalBayFlanSource COMListOnly Search Event Process<br>
	 * CotainerList PopUp FinalBayFlanSource COMListOnly Search Event Process<br>
	 * 
	 * @param e EsdTes901Event
	 * @return eventResponse ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDigit(Event e) throws EventException {
		EsdTes9010Event event = (EsdTes9010Event) e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    checkDigit()");

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);
			log.debug("\n checkDigit  ------------------------  \n");
			eventResponse = command.searchCNTRNumber(event);
			event.setRowSet(eventResponse.getRs());

			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.updateCNTRNumber(event);
			commit();
			eventResponse = command.searchTES_FILE_IMP_TMP(event);

		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}
		return eventResponse;
	}

	/**
	 * Multi Event Process<br>
	 * MarineTerminalInvoiceManage Multi Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse checkTerminalInvoiceContainerList(Event e) throws EventException {
		// ESD_TES_901EventResponse eventResponse = null;
		EsdTes9010Event event = (EsdTes9010Event) e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    checkTerminalInvoiceContainerList()");

		String curr_seq = null;
		try {// 2009-03-12

			// HashMap param_map = new HashMap();
			// param_map.put("ofc_cd",e.getSignOnUserAccount().getOfc_cd());
			// param_map.put("usr_id",e.getSignOnUserAccount().getUsr_id());
			// param_map.put("jb_tp_cd",TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
			// param_map.put("pgm_url",(pageURL!=null&&!pageURL.equals("")?pageURL.trim():JSPUtil.getNull(event.getEventName())));
			// param_map.put("f_cmd",event.getParams().get("f_cmd"));
			// param_map.put("row_cnt",((EsdTes901Event)e).getTES_TML_SO_CNTR_LISTS()!=null?Integer.toString(((EsdTes901Event)e).getTES_TML_SO_CNTR_LISTS().size()):"");
			// param_map.put("tml_so_ofc_cty_cd",event.getParams().get("tml_so_ofc_cty_cd"));
			// param_map.put("tml_so_seq",event.getParams().get("tml_so_seq"));
			// param_map.put("param_val",TESUtil.getParamNotNullValueChkPerfParamSize(((EsdTes901Event)e).getParams()));
			// log.debug("\n\n  ##### SC..beginJobExecutionPerformance  \n\n");
			// curr_seq = beginJobExecutionPerformance(param_map);

			String pageURL = event.getPageURL();
			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
			tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setExeRowKnt(event.getTesFileImpTmpVOs() != null ? Integer.toString((event.getTesFileImpTmpVOs()).length) : "");
			tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
			tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			curr_seq = beginJobExecutionPerformance(tesJbExePerfLogVO);

		} catch (Exception ex) {
			log.error(ex.getMessage());

			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		try {
			log.debug("\n sc 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			log.debug("\n sc 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);

			String costCdFtrRmk = new TESInvoiceCommonBCImpl().selectCostCdFtrRmk(event.getTesTmlSoHdrVO());
			event.getTesTmlSoHdrVO().setCostCdFtrRmk(costCdFtrRmk);

			// Verify
			log.debug("\n sc Verify : Imported File ------------------------  \n");
			eventResponse = command.checkTerminalInvoiceContainerList(event);
			// ESD_TES_901EventResponse er = (ESD_TES_901EventResponse)eventResponse;
			// er = (ESD_TES_901EventResponse)eventResponse;
			event.setRowSet(eventResponse.getRs());

			log.debug("\n sc CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.createTerminalInvoiceVVD(event);
			// command.deleteTerminalInvoiceContainerList(event);
			command.createTerminalInvoiceContainerList(event);
			commit();
			// eventResponse = er;

			log.debug(":::::::::::::::  checkTerminalInvoiceContainerList getTesCommonVO :::::::::::::::::::" + event.getTesCommonVO().toString());

			if (event.getTesCommonVO().getComListYn().equals("Y")) {
				// Verify
				log.debug("\n sc Verify : COM LIST ONLY ------------------------  \n");
				eventResponse = command.searchCOMListOnlyList(event);
				// er = (ESD_TES_901EventResponse)eventResponse;
				event.setRowSet(eventResponse.getRs());

				log.debug("\n sc CNTR_LIST에 넣고 ------------------------  \n");
				begin();
				command.createTerminalInvoiceContainerList(event);
				commit();
				// eventResponse = er;
			}

		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(curr_seq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
		}

		endJobExecutionPerformance(curr_seq);

		return eventResponse;
	}

	/**
	 * Search Container List by WorkOrder input<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerListByWorkOrder(Event e) throws EventException {
		// ESD_TES_901EventResponse eventResponse = null;

		log.debug("\n========== ServiceProviderInvoiceManageSC    searchContainerListByWorkOrder()");
		EventResponse eventResponse = null;
		EsdTes9010Event event = (EsdTes9010Event) e;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    searchContainerListByWorkOrder()");

		try {
			eventResponse = command.searchContainerListByWorkOrder(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;

	}

	/******************************************* EsdTes903_2Event : Revised Volume Popup *******************************************/

	/**
	 * Revised Vol List retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes9032Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRevisedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchManualRevisedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchManualRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Revised Vol List retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes907_2Event
	 * @return eventResponse ESD_TES_907_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalManualRevisedVolume(Event e) throws EventException {

		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalManualRevisedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalManualRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;

	}

	/**
	 * Revised Vol List retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes9032Event
	 * @return eventResponse EventResponse
	 * @exception EventExceptionfor
	 */
	public EventResponse searchAutoRevisedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchAutoRevisedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchAutoRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Revised Vol List retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes907_2Event
	 * @return eventResponse ESD_TES_907_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalAutoRevisedVolume(Event e) throws EventException {
		log.debug("============start sc searchMarineTerminalAutoRevisedVolume =============== ");

		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalAutoRevisedVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalAutoRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/******************************************* ESD_TES_9232Event : 3rd Party Popup *******************************************/

	/**
	 * 3rd Party retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes9232Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTrdPartyVolume(Event e) throws EventException {

		EventResponse evnetResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchAutoTrdPartyVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			evnetResponse = command.searchAutoTrdPartyVolume(e);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return evnetResponse;
	}

	/**
	 * 3rd Party retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes9232Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTrdPartyVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC searchManualTrdPartyVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchManualTrdPartyVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceN3rdParyIF2(Event e) throws EventException {
		EventResponse eventResponse = null;

		// EsdTes9232Event event = (EsdTes9232Event)e;

		// TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
		String currSeq = null;
		/*
		 * try { tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
		 * 
		 * TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO(); StringBuilder sbuPerfRmk = new StringBuilder(); int joCnt = 0; // SVXXJO 건 int insFlgCnt = 0; // INSERT int updFlgCnt = 0; // UPDATE
		 * 
		 * for( int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++ ) { if ( "SVXXJO".equals(tesN3rdPtyIfVOs[i].getLgsCostCd() ) ) { joCnt++; } if ( "I".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) { insFlgCnt++; } if ( "U".equals(tesN3rdPtyIfVOs[i].getIbflag() ) ) { updFlgCnt++; } }
		 * 
		 * if ( joCnt > 0 ) { sbuPerfRmk.append("JO "); if ( sbuPerfRmk.length() > 0 ) { if ( insFlgCnt > 0 ) { sbuPerfRmk.append("C"); } if ( updFlgCnt > 0 ) { sbuPerfRmk.append("U"); } } }
		 * 
		 * // TPB DELETE. String delIfSeq = JSPUtil.getNull(event.getMarineTerminalInvoiceCommonVO().getDelIfSeq()); if ( delIfSeq.length() > 0 ) { delIfSeq = delIfSeq.substring( 0, delIfSeq.length() - 1 ); //.replaceAll("\\|", ","); String [] arrIfSeq = delIfSeq.split("\\|");
		 * 
		 * sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); }
		 * 
		 * tesJbExePerfLogVO.setInvOfcCd ( e.getSignOnUserAccount().getOfc_cd() ); tesJbExePerfLogVO.setExeUsrId ( e.getSignOnUserAccount().getUsr_id() ); tesJbExePerfLogVO.setJbTpCd ( TESCommonBC.PERF_JOB_TYPE_TPB ); tesJbExePerfLogVO.setPgmUrl ( (event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim():JSPUtil.getNull( event.getEventName() ) ) ); tesJbExePerfLogVO.setFuncDivCd ( String.valueOf(event.getFormCommand().getCommand()) ); tesJbExePerfLogVO.setExeRowKnt ( tesN3rdPtyIfVOs != null ? Integer.toString( tesN3rdPtyIfVOs.length ) : "" ); tesJbExePerfLogVO.setTmlSoOfcCtyCd ( event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd() ); tesJbExePerfLogVO.setTmlSoSeq ( event.getTesTmlSoHdrVO().getTmlSoSeq() ); tesJbExePerfLogVO.setJbParaCtnt ( event.getPerfParams() ); tesJbExePerfLogVO.setPerfRmk ( sbuPerfRmk.toString() );
		 * 
		 * currSeq = beginJobExecutionPerformance( tesJbExePerfLogVO ); } catch (Exception ex){ log.error(ex.getMessage()); if (false){ throw new EventException(ex.getMessage()); } }
		 */
		currSeq = searchCurrSeq(e);

		try {
			log.debug("\n ServiceProviderInvoiceManageSC    multiTerminalInvoiceN3rdParyIF2()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.updateContainerListRvisFlgManual2(e);// 20150526 add
			eventResponse = command.multiTerminalInvoiceN3rdParyIF(e);
			// if ( 1 != 2 ) {
			// throw new EventException("Error Remark TPB IF TEST");
			// }
			commit();
		} catch (EventException de) {
			rollback();
			log.error("\n\n[][][catch] >>>>>>>>>>>>>>> err " + de.toString(), de);

			errorJobExecutionPerformance(currSeq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark

			throw new EventException(de.getMessage());
		} finally {
			endJobExecutionPerformance(currSeq);
		}

		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTerminalInvoiceN3rdParyIF(Event e) throws EventException {
		EsdTes9231Event event = (EsdTes9231Event) e;

		TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
		String currSeq = null;

		try {
			tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();

			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();
			StringBuilder sbuPerfRmk = new StringBuilder();
			int insFlgCnt = 0; // INSERT
			int updFlgCnt = 0; // UPDATE

			for (int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++) {
				if ("I".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
					insFlgCnt++;
				}
				if ("U".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
					updFlgCnt++;
				}
			}

			if (insFlgCnt > 0) {
				sbuPerfRmk.append("C");
			}
			if (updFlgCnt > 0) {
				sbuPerfRmk.append("U");
			}

			// TPB DELETE.
			String delIfSeq = JSPUtil.getNull(event.getOndockRailChargeInvoiceCommonVO().getDelIfSeq());
			if (delIfSeq.length() > 0) {
				delIfSeq = delIfSeq.substring(0, delIfSeq.length() - 1); // .replaceAll("\\|", ",");
				String[] arrIfSeq = delIfSeq.split("\\|");

				sbuPerfRmk.append("D(" + arrIfSeq.length + ")");
			}

			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_TPB);
			tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setExeRowKnt(tesN3rdPtyIfVOs != null ? Integer.toString(tesN3rdPtyIfVOs.length) : "");
			tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
			tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			tesJbExePerfLogVO.setPerfRmk(sbuPerfRmk.toString());

			currSeq = beginJobExecutionPerformance(tesJbExePerfLogVO);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			command.multiTerminalInvoiceN3rdParyIF(e);
			commit();

			// eventResponse = command.searchStorage3rdIFlistByDay(event);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(currSeq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		} finally {
			endJobExecutionPerformance(currSeq);
		}

		return searchTerminalInvoiceN3ptyAutoCntrList(e);
	}

	/**
	 * 3rd Party retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes9252Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalTrdPartyVolume(Event e) throws EventException {
		log.debug("start searchMarineTerminalTrdPartyVolume =======================>");

		// EsdTes9252Event event = (EsdTes9252Event)e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchMarineTerminalTrdPartyVolume()");
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMarineTerminalTrdPartyVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * retrieve event process MarineTerminalInvoiceManage retrieve event process
	 * 
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */

	/**
	 * Accumulate Vol List retrieve event process MarineTerminalInvoiceManage Accumulate Vol List retrieve event process
	 * 
	 * @param e EsdTes922Event
	 * @return eventResponse ESD_TES_922EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAccumulatedVolumeList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchAccumulatedVolumeList(e);
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchAccumulatedVolumeList() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchAccumulatedVolumeList() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * RehandlingVolume List retrieve event process MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 * 
	 * @param e EsdTes919Event
	 * @return eventResponse ESD_TES_919EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandlingVolume(Event e) throws EventException {
		EventResponse eventResponse = null;
		log.debug("==========ServiceProviderInvoiceManageSC    searchRehandlingVolume()");

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchRehandlingVolume(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * RehandlingVolume List retrieve event process MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 * 
	 * @param e EsdTes9191Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalRehandlingVolume(Event e) throws EventException {

		EventResponse eventResponse = null;

		if (log.isDebugEnabled())
			log.debug("========== ServiceProviderInvoiceManageSC    searchMarineTerminalRehandlingVolume() commit Before");
		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = (EventResponse) command.searchMarineTerminalRehandlingVolume(e);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * RehandlingVolume List Save Event Process<br>
	 * MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRehandlingVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			log.debug("\n ServiceProviderInvoiceManageSC    multiRehandlingVolume()");
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.multiRehandlingVolume(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * retrieve event process OnDockRailChargeInvoiceManage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOndockRailChargeBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		if (log.isDebugEnabled())
			log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeBasicInfo() ============");
		try {
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeBasicInfo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Add Event Process<br>
	 * OnDockRailChargeInvoiceManage Add Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createOndockRailChargeBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event) e;
		if (log.isDebugEnabled())
			log.debug("==========ServiceProviderInvoiceManageSC    createOndockRailChargeBasicInfo() ============");

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			command.createOndockRailChargeBasicInfo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchOndockRailChargeBasicInfo(e);
	}

	/**
	 * Update Event Process<br>
	 * OnDockRailChargeInvoiceManage Update Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOndockRailChargeBasicInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event) e;
		if (log.isDebugEnabled())
			log.debug("==========ServiceProviderInvoiceManageSC    modifyOndockRailChargeBasicInfo() ============");

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			TESInvoiceCommonBC commandCom = new TESInvoiceCommonBCImpl();

			if (((EsdTes0064Event) e).getTesTmlSoHdrVO().getTmlInvStsCd().equals("C") // && !ofc_cd.equals("SELTOB")
			) {
				commandCom.checkInvCalcCostCD(((EsdTes0064Event) e).getTesTmlSoHdrVO());
			}

			command.modifyOndockRailChargeBasicInfo(event);

			log.debug("event.getTesTmlSoHdrVO().getTmlInvStsCd()==========>" + event.getTesTmlSoHdrVO().getTmlInvStsCd());

			// if(event.getTesTmlSoHdrVO().getTmlInvStsCd().equals("C")){
			// apPayInvVO = commandCom.searchApPayInv(((EsdTes0064Event)e).getTesTmlSoHdrVO());
			// apPayInvDtlVOs = commandCom.searchApPayInvDtl(((EsdTes0064Event)e).getTesTmlSoHdrVO(), ((EsdTes0064Event)e).getApPayInvVO());
			//
			// String strInvRgstNo = commandCSR.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
			//
			// }else{
			// commandCom.cancelApPayInvAll(event.getTesTmlSoHdrVO(), event.getApPayInvVO());
			// }

			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchOndockRailChargeBasicInfo(e);
	}

	/**
	 * OndockRailChargeContainerList verify Event Process<br>
	 * OndockRailChargeContainerList event OndockRailChargeContainerList verify Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyOndockRailChargeContainerList(Event e) throws EventException {
		if (log.isDebugEnabled())
			log.debug("\n==========ServiceProviderInvoiceManageSC    verifyOndockRailChargeContainerList()");

		EsdTes9130Event event = (EsdTes9130Event) e;
		EventResponse eventResponse = null;
		OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();

		String currSeq = null;

		try {
			TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();

			tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
			tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
			tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
			tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
			tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
			tesJbExePerfLogVO.setExeRowKnt(event.getTesFileImpTmpVOs() != null ? Integer.toString((event.getTesFileImpTmpVOs()).length) : "");
			tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
			tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
			tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());

			currSeq = beginJobExecutionPerformance(tesJbExePerfLogVO);
		} catch (Exception ex) {
			log.error(ex.getMessage());

			// if (false){
			// throw new EventException(ex.getMessage());
			// }
		}

		try {
			log.debug("\n 무조건 임시 TABLE 지우기1 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			log.debug("\n 임시 TABLE에 넣고 ------------------------  \n");
			command.createTES_FILE_IMP_TMP(event);
			log.debug("\n 계산하기 ------------------------  \n");

			String costCdFtrRmk = new TESInvoiceCommonBCImpl().selectCostCdFtrRmk(event.getTesTmlSoHdrVO());
			event.getTesTmlSoHdrVO().setCostCdFtrRmk(costCdFtrRmk);

			eventResponse = command.verifyOndockRailChargeContainerList(event);

			event.setRowSet(eventResponse.getRs());

			log.debug("\n CNTR_LIST에 넣고 ------------------------  \n");
			begin();
			command.createOndockRailChargeContainerList(event);
			commit();

		} catch (EventException de) {
			log.debug("\n EventException rollback ------------------------  \n");
			rollback();
			log.error("err " + de.toString(), de);
			errorJobExecutionPerformance(currSeq);
			// errorJobExecutionPerformance(currSeq, de.toString()); // Error Remark
			throw new EventException(de.getMessage());
		} finally {
			log.debug("\n 무조건 임시 TABLE 지우기2 ------------------------  \n");
			command.removeTES_FILE_IMP_TMP(event);
			endJobExecutionPerformance(currSeq);
		}
		return eventResponse;
	}

	/**
	 * OndockRailChargeContainerList Multi Event Process<br>
	 * OndockRailChargeContainerList event OndockRailChargeContainerList Multi Event Process<br>
	 * 
	 * @param e EsdTes0064Event
	 * @return EventResponse ESD_TES_0064EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeContainerList(Event e) throws EventException {
		log.debug("start multiOndockRailChargeContainerList");

		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.multiOndockRailChargeContainerList(e);
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    multiOndockRailChargeContainerList() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    multiOndockRailChargeContainerList() commit After");

		} catch (EventException de) {
			// rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * retrieve event process OnDockRailChargeInvoiceManage Specific list retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOndockRailChargeContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		if (log.isDebugEnabled())
			log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeContainerList() ============");
		try {
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeContainerList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process OnDockRailChargeInvoiceManage searchOndockRailChargeCostCalculationList retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOndockRailChargeCostCalculationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTes0064Event event = (EsdTes0064Event) e;
		// Object including the result of user request (DB Result Set, Object and etc)
		EventResponse eventResponse = null;
		if (log.isDebugEnabled())
			log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeCostCalculationList() ============");
		try {
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOndockRailChargeCostCalculationList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event process OnDockRailChargeInvoiceManage retrieve event process
	 * 
	 * @param e EsdTes064Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockChargeInvoiceCostCalcComboCodeList(Event e) throws EventException {
		// ESD_TES_064EventResponse eventResponse = null;
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = (EventResponse) command.searchOnDockChargeInvoiceCostCalcComboCodeList(e);
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchOnDockChargeInvoiceCostCalcComboCodeList() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchOnDockChargeInvoiceCostCalcComboCodeList() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Multi Event Process<br>
	 * MarineTerminalInvoiceManage Multi Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeInvoiceDetail(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.multiOndockRailChargeInvoiceDetail(e);
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    multiOnDockChargeInvoiceDetail() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    multiOnDockChargeInvoiceDetail() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * multiOnDockTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiOnDockTerminalInvoiceDBVerify(Event e) throws EventException {

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    multiOnDockTerminalInvoiceDBVerify()");
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			command.multiOnDockTerminalInvoiceDBVerify(e);
			commit();

			return command.searchOndockRailChargeContainerList3(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

	}

	/**
	 * Multi Event Process<br>
	 * MarineTerminalInvoiceManage Multi Event Process<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOndockRailChargeInvoiceCost(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.removeOndockRailChargeInvoiceCost(e);
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    multiOnDockChargeInvoiceDetail() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    multiOnDockChargeInvoiceDetail() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * searchDBCheckOnDockTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckOnDockTerminalInvoice(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchDBCheckTerminalInvoice() ============");

			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = (EventResponse) command.searchDBCheckOnDockTerminalInvoice(e);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	private String searchCurrSeq(Event e) {

		String curr_seq = null;
		TesJbExePerfLogVO tesJbExePerfLogVO = new TesJbExePerfLogVO();

		if (e instanceof EsdTes9140Event) {
			EsdTes9140Event event = (EsdTes9140Event) e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
				tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setExeRowKnt(event.getTesFileImpTmpVOs() != null ? Integer.toString((event.getTesFileImpTmpVOs()).length) : "");
				tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes9142Event) {
			EsdTes9142Event event = (EsdTes9142Event) e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
				tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setExeRowKnt(event.getTesFileImpTmpVOs() != null ? Integer.toString((event.getTesFileImpTmpVOs()).length) : "");
				tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes9233Event) {
			EsdTes9233Event event = (EsdTes9233Event) e;
			TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
			try {
				tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
				StringBuilder sbuPerfRmk = new StringBuilder();
				int insFlgCnt = 0; // INSERT
				int updFlgCnt = 0; // UPDATE

				for (int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++) {
					if ("I".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
						insFlgCnt++;
					}
					if ("U".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
						updFlgCnt++;
					}
				}

				if (insFlgCnt > 0) {
					sbuPerfRmk.append("C");
				}
				if (updFlgCnt > 0) {
					sbuPerfRmk.append("U");
				}

				// TPB DELETE.
				String delIfSeq = JSPUtil.getNull(event.getOffdockCYInvoiceManageVO().getDelIfSeq());
				if (delIfSeq.length() > 0) {
					delIfSeq = delIfSeq.substring(0, delIfSeq.length() - 1); // .replaceAll("\\|", ",");
					String[] arrIfSeq = delIfSeq.split("\\|");
					sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
				}

				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_TPB);
				tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setExeRowKnt(tesN3rdPtyIfVOs != null ? Integer.toString(tesN3rdPtyIfVOs.length) : "");
				tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesN3rdPtyIfVO().getTmlSoOfcCtyCd());
				tesJbExePerfLogVO.setTmlSoSeq(event.getTesN3rdPtyIfVO().getTmlSoSeq());
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
				tesJbExePerfLogVO.setPerfRmk(sbuPerfRmk.toString());

			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes9234Event) {
			EsdTes9234Event event = (EsdTes9234Event) e;
			TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
			try {
				tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
				StringBuilder sbuPerfRmk = new StringBuilder();
				int insFlgCnt = 0; // INSERT
				int updFlgCnt = 0; // UPDATE

				for (int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++) {
					if ("I".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
						insFlgCnt++;
					}
					if ("U".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
						updFlgCnt++;
					}
				}

				if (insFlgCnt > 0) {
					sbuPerfRmk.append("C");
				}
				if (updFlgCnt > 0) {
					sbuPerfRmk.append("U");
				}

				// TPB DELETE.
				String delIfSeq = JSPUtil.getNull(event.getMarineTerminalStorageInvoiceManageVO().getDelIfSeq());
				if (delIfSeq.length() > 0) {
					delIfSeq = delIfSeq.substring(0, delIfSeq.length() - 1); // .replaceAll("\\|", ",");
					String[] arrIfSeq = delIfSeq.split("\\|");
					sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
				}

				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_TPB);
				tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setExeRowKnt(tesN3rdPtyIfVOs != null ? Integer.toString(tesN3rdPtyIfVOs.length) : "");
				tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
				tesJbExePerfLogVO.setPerfRmk(sbuPerfRmk.toString());

			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes0013Event) {
			EsdTes0013Event event = (EsdTes0013Event) e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
				tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes0014Event) {
			EsdTes0014Event event = (EsdTes0014Event) e;
			try {// 2009-03-12
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE);
				tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes9010Event) {
			EsdTes9010Event event = (EsdTes9010Event) e;
			try {
				String pageURL = event.getPageURL();
				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
				tesJbExePerfLogVO.setPgmUrl((pageURL != null && !pageURL.equals("") ? pageURL.trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setExeRowKnt(event.getTesFileImpTmpVOs() != null ? Integer.toString((event.getTesFileImpTmpVOs()).length) : "");
				tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes9232Event) {
			EsdTes9232Event event = (EsdTes9232Event) e;
			TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;

			// TPB IF SVXXJO 누락건 분석위한 로그추가.(2010-04-27)
			try {
				tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
				StringBuilder sbuPerfRmk = new StringBuilder();
				int joCnt = 0; // SVXXJO 건
				int insFlgCnt = 0; // INSERT
				int updFlgCnt = 0; // UPDATE

				// SVXXJO 건인지 확인하기 위함.
				for (int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++) {
					if ("SVXXJO".equals(tesN3rdPtyIfVOs[i].getLgsCostCd())) {
						joCnt++;
					}
					if ("I".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
						insFlgCnt++;
					}
					if ("U".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
						updFlgCnt++;
					}
				}

				if (joCnt > 0) {
					sbuPerfRmk.append("JO ");
					if (sbuPerfRmk.length() > 0) {
						if (insFlgCnt > 0) {
							sbuPerfRmk.append("C");
						}
						if (updFlgCnt > 0) {
							sbuPerfRmk.append("U");
						}
					}
				}

				// TPB DELETE.
				String delIfSeq = JSPUtil.getNull(event.getMarineTerminalInvoiceCommonVO().getDelIfSeq());
				if (delIfSeq.length() > 0) {
					delIfSeq = delIfSeq.substring(0, delIfSeq.length() - 1); // .replaceAll("\\|", ",");
					String[] arrIfSeq = delIfSeq.split("\\|");
					sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
				}

				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_TPB);
				tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setExeRowKnt(tesN3rdPtyIfVOs != null ? Integer.toString(tesN3rdPtyIfVOs.length) : "");
				tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
				tesJbExePerfLogVO.setPerfRmk(sbuPerfRmk.toString());

			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes9231Event) {
			EsdTes9231Event event = (EsdTes9231Event) e;
			TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;

			// TPB IF 누락건 분석위한 로그추가.(2010-05-03)
			try {
				tesN3rdPtyIfVOs = event.getTesN3rdPtyIfVOs();
				StringBuilder sbuPerfRmk = new StringBuilder();
				int insFlgCnt = 0; // INSERT
				int updFlgCnt = 0; // UPDATE

				// 건인지 확인하기 위함.
				for (int i = 0; tesN3rdPtyIfVOs != null && i < tesN3rdPtyIfVOs.length; i++) {
					if ("I".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
						insFlgCnt++;
					}
					if ("U".equals(tesN3rdPtyIfVOs[i].getIbflag())) {
						updFlgCnt++;
					}
				}

				if (insFlgCnt > 0) {
					sbuPerfRmk.append("C");
				}
				if (updFlgCnt > 0) {
					sbuPerfRmk.append("U");
				}

				// TPB DELETE.
				String delIfSeq = JSPUtil.getNull(event.getOndockRailChargeInvoiceCommonVO().getDelIfSeq());
				if (delIfSeq.length() > 0) {
					delIfSeq = delIfSeq.substring(0, delIfSeq.length() - 1); // .replaceAll("\\|", ",");
					String[] arrIfSeq = delIfSeq.split("\\|");
					sbuPerfRmk.append("D(" + arrIfSeq.length + ")"); // 삭제 건수.
				}

				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_TPB);
				tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setExeRowKnt(tesN3rdPtyIfVOs != null ? Integer.toString(tesN3rdPtyIfVOs.length) : "");
				tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
				tesJbExePerfLogVO.setPerfRmk(sbuPerfRmk.toString());

			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		} else if (e instanceof EsdTes9130Event) {
			EsdTes9130Event event = (EsdTes9130Event) e;
			try {
				tesJbExePerfLogVO.setInvOfcCd(e.getSignOnUserAccount().getOfc_cd());
				tesJbExePerfLogVO.setExeUsrId(e.getSignOnUserAccount().getUsr_id());
				tesJbExePerfLogVO.setJbTpCd(TESCommonBC.PERF_JOB_TYPE_ON_LINE_INVOICE);
				tesJbExePerfLogVO.setPgmUrl((event.getPageURL() != null && !"".equals(event.getPageURL()) ? event.getPageURL().trim() : JSPUtil.getNull(event.getEventName())));
				tesJbExePerfLogVO.setFuncDivCd(String.valueOf(event.getFormCommand().getCommand()));
				tesJbExePerfLogVO.setExeRowKnt(event.getTesFileImpTmpVOs() != null ? Integer.toString((event.getTesFileImpTmpVOs()).length) : "");
				tesJbExePerfLogVO.setTmlSoOfcCtyCd(event.getTesTmlSoHdrVO().getTmlSoOfcCtyCd());
				tesJbExePerfLogVO.setTmlSoSeq(event.getTesTmlSoHdrVO().getTmlSoSeq());
				tesJbExePerfLogVO.setJbParaCtnt(event.getPerfParams());
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}
		}

		curr_seq = beginJobExecutionPerformance(tesJbExePerfLogVO);

		return curr_seq;
	}

	// /**
	// * TML_SO_RVIS_LIST retrieve event process
	// * MarineTerminalInvoiceManage TML_SO_RVIS_LIST retrieve event process
	// *
	// * @param e EsdTes064Event
	// * @return eventResponse ESD_TES_064EventResponse
	// * @exception EventException
	// */
	// public EventResponse searchOndockRailChargeInvoiceRvisList(Event e) throws EventException {
	// ESD_TES_064EventResponse eventResponse = null;
	//
	// try {
	// begin();
	// OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
	// eventResponse = (ESD_TES_064EventResponse)command.searchOndockRailChargeInvoiceRvisList(e);
	// if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeInvoiceRvisList() commit Before");
	// commit();
	// if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeInvoiceRvisList() commit After");
	//
	// } catch (EventException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	//
	// return eventResponse;
	// }

	// /**
	// * TerminalInvoiceN3rdPartyIF LIST retrieve event process
	// * MarineTerminalInvoiceManage TerminalInvoiceN3rdPartyIF LIST retrieve event process
	// *
	// * @param e EsdTes064Event
	// * @return eventResponse ESD_TES_064EventResponse
	// * @exception EventException
	// */
	// public EventResponse searchOndockRailChargeInvoiceN3ptyList(Event e) throws EventException {
	// ESD_TES_064EventResponse eventResponse = null;
	//
	// try {
	// begin();
	// OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
	// eventResponse = (ESD_TES_064EventResponse)command.searchOndockRailChargeInvoiceN3ptyList(e);
	// if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeInvoiceN3ptyList() commit Before");
	// commit();
	// if(log.isDebugEnabled())log.debug("==========ServiceProviderInvoiceManageSC    searchOndockRailChargeInvoiceN3ptyList() commit After");
	//
	// } catch (EventException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	//
	// return eventResponse;
	// }

	/**
	 * TerminalInvoiceN3ptyAutoCntrList retrieve event process MarineTerminalInvoiceManage TerminalInvoiceN3ptyAutoCntrList retrieve event process
	 * 
	 * @param e EsdTes9231Event
	 * @return eventResponse ESD_TES_9231EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyAutoCntrList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceN3ptyAutoCntrList(e);

			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceN3ptyAutoCntrList() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceN3ptyAutoCntrList() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * TerminalInvoiceN3ptyManualCntrList retrieve event process MarineTerminalInvoiceManage TerminalInvoiceN3ptyManualCntrList retrieve event process
	 * 
	 * @param e EsdTes9231Event
	 * @return eventResponse ESD_TES_9231EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyManualCntrList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceN3ptyManualCntrList(e);

			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceN3ptyManualCntrList() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceN3ptyManualCntrList() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 3rd Party retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes9251Event
	 * @return eventResponse ESD_TES_9251EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockTrdPartyVolume(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTes9251Event event = (EsdTes9251Event) e;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchOnDockTrdPartyVolume()");
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchOnDockTrdPartyVolume(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Revised Vol List retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes9031Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockAutoRevisedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchOnDockAutoRevisedVolume()");
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchAutoRevisedVolume(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * retrieve event process MarineTerminalInvoiceManage retrieve event process
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse updateOnDockContainerListRvisFlg(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    updateOnDockContainerListRvisFlg()");
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.updateOnDockContainerListRvisFlg(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Revised Vol List retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes9031Event
	 * @return eventResponse ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceRevisedVolume(e);
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceRevisedVolume() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceRevisedVolume() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Revised Vol List retrieve event process MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 * 
	 * @param e EsdTes903_1Event
	 * @return eventResponse ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume9031(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceRevisedVolume9031(e);
			if (log.isDebugEnabled())
				log.debug("========== ServiceProviderInvoiceManageSC    searchTerminalInvoiceRevisedVolume903_1() commit Before");
			commit();
			if (log.isDebugEnabled())
				log.debug("========== ServiceProviderInvoiceManageSC    searchTerminalInvoiceRevisedVolume903_1() commit After");

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummary(Event e) throws EventException {

		EsdTes0023Event event = (EsdTes0023Event) e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummary1(Event e) throws EventException {
		EsdTes0023Event event = (EsdTes0023Event) e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummary1(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSoIfCd(Event e) throws EventException {
		EsdTes0023Event event = (EsdTes0023Event) e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchSoIfCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummaryDetail1(Event e) throws EventException {

		EsdTes0024Event event = (EsdTes0024Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummaryDetail1(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchCSRSummaryDetail
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummaryDetail(Event e) throws EventException {
		log.debug("start searchCSRSummaryDetail ==========================");

		EsdTes0024Event event = (EsdTes0024Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummaryDetail(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchCSRSummaryDetail
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSummaryDetail2(Event e) throws EventException {
		log.debug("start searchCSRSummaryDetail2 ==========================");

		EsdTes0080Event event = (EsdTes0080Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSummaryDetail2(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse tmpSearchCSRSummary(Event e) throws EventException {

		EsdTes0024Event event = (EsdTes0024Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.tmpSearchCSRSummary(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse tmpSearchPreVeiw(Event e) throws EventException {
		log.debug("start tmpSearchPreVeiw ======================== FormCommand:" + FormCommand.SEARCH03);

		EsdTes0024Event event = (EsdTes0024Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.tmpSearchPreVeiw(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalRequest(Event e) throws EventException {
		log.debug("\n\n SC.approvalRequest ----------------------  \n\n");

		EsdTes0024Event event = (EsdTes0024Event) e;
		EventResponse eventResponse = null;
		CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
		DBRowSet[] autoRevVVDList = null;
		DBRowSet[] manualRevVVDList = null;
		DBRowSet[] dtrbRowSet = null;

		// HashMap param_map = (HashMap)event.getParam_map();
		// String cnt_cd = param_map!=null?(String)param_map.get("cnt_cd"):"";

		try {
			autoRevVVDList = command.getAutoRevVVDList(event);
			event.setAutoRowSetArr01(autoRevVVDList);
			manualRevVVDList = command.getManualRevVVDList(event);
			event.setManualRowSetArr01(manualRevVVDList);

			begin();
			command.modifyAutoRevVVD(event);
			command.modifyManualRevVVD(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}

		try {
			// if (event.getCARIssueTransferSlipManageCommonVO().getCntCd().equals("KR")){
			// dtrbRowSet =command.searchApInvDTRBIn(event);
			// event.setDtrbRowSetArr(dtrbRowSet);
			// } else {
			dtrbRowSet = command.searchApInvDTRBOut(event);
			event.setDtrbRowSetArr(dtrbRowSet);
			// }

			begin();
			eventResponse = command.approvalRequest(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreVeiw(Event e) throws EventException {
		log.debug("\n\n SC.searchPreVeiw ============================= \n\n");

		EsdTes0024Event event = (EsdTes0024Event) e;
		CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
		EventResponse eventResponse = null;
		DBRowSet[] autoRevVVDList = null;
		DBRowSet[] manualRevVVDList = null;
		DBRowSet[] dtrbRowSet = null;

		// HashMap param_map = (HashMap)event.getParam_map();
		// String cnt_cd = param_map!=null?(String)param_map.get("cnt_cd"):"";

		try {
			autoRevVVDList = command.getAutoRevVVDList(event);
			event.setAutoRowSetArr01(autoRevVVDList);

			manualRevVVDList = command.getManualRevVVDList(event);
			event.setManualRowSetArr01(manualRevVVDList);

			begin();
			command.modifyAutoRevVVD(event);
			command.modifyManualRevVVD(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("searchPreVeiw err " + de.toString(), de);
			throw de;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}

		try {
			// if (event.getCARIssueTransferSlipManageCommonVO().getCntCd().equals("KR")){
			// dtrbRowSet =command.searchApInvDTRBIn(event);
			// event.setDtrbRowSetArr(dtrbRowSet);
			//
			// } else {
			dtrbRowSet = command.searchApInvDTRBOut(event);
			event.setDtrbRowSetArr(dtrbRowSet);
			// }

			begin();
			eventResponse = command.searchPreVeiw(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("searchPreVeiw err " + de.toString(), de);
			throw de;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("XXXXXXXX").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTAXInfo(Event e) throws EventException {
		log.debug("start searchTAXInfo ================");

		EsdTes0078Event event = (EsdTes0078Event) e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchTAXInfo(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApEviNo(Event e) throws EventException {
		log.debug("start searchApEviNo ================");

		EsdTes0078Event event = (EsdTes0078Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchApEviNo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTAXCode(Event e) throws EventException {
		log.debug("start searchTAXCode ========================");

		EsdTes0078Event event = (EsdTes0078Event) e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchTAXCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchDBCheckTerminalInvoice
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDBCheckTerminalInvoice(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchDBCheckTerminalInvoice() ============");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = (EventResponse) command.searchDBCheckTerminalInvoice(e);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * searchTerminalInvoiceVVDDual
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchTerminalInvoiceVVDDual(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			if (log.isDebugEnabled())
				log.debug("\n==========ServiceProviderInvoiceManageSC    searchTerminalInvoiceVVDDual() ============");

			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = (EventResponse) command.searchTerminalInvoiceVVDDual(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTerminalInvoiceAutoBoundList(Event e) throws EventException {
		if (log.isDebugEnabled())
			log.debug("\n\nServiceProvider Invoice ManageSC :::::::: searchTerminalInvoiceAutoBoundList\n");
		EventResponse eventResponse = null;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchTerminalInvoiceAutoBoundList(e);
		} catch (EventException de) {
			log.error("err" + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiTerminalInvoiceAutoBoundList(Event e) throws EventException {

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.checkDualVVD(e);
			command.multiTerminalInvoiceAutoBoundList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchTerminalInvoiceAutoBoundList(e);
	}

	/**
	 * 
	 * @param param_map
	 * @return String
	 * @exception EventException
	 */
	private String beginJobExecutionPerformance(TesJbExePerfLogVO tesJbExePerfLogVO) {
		String curr_seq = null;
		try {
			begin();
			// TESCommonEvent com_event = null;
			// String param_name = null;
			// java.util.Enumeration enums = request.getParameterNames();
			// while (enums.hasMoreElements()){
			// param_name = (String)enums.nextElement();
			// param_map.put(param_name,request.getParameter(param_name));
			// log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
			// }
			// com_event = new TESCommonEvent(param_map);
			// curr_seq = new TESCommonBCImpl().beginJobExecutionPerformance(com_event);

			// com_event = new TESCommonEvent();
			// com_event.setTesCommonVO(tesCommonVO);
			curr_seq = new TESCommonBCImpl().beginJobExecutionPerformance(tesJbExePerfLogVO);

			commit();
		} catch (Exception de) {
			rollback();
			log.error("\n  beginJobExecutionPerformance - ERROR!  \n");
			log.error("err " + de.toString(), de);
		}
		return curr_seq;
	}

	/**
	 * 
	 * @param curr_seq
	 */
	private void errorJobExecutionPerformance(String currSeq) {
		try {
			if (currSeq != null && !currSeq.trim().equals("")) {
				begin();
				new TESCommonBCImpl().errorJobExecutionPerformance(currSeq);
				commit();
			} else {
				log.error("\n\n  errorJobExecutionPerformance - NO PERF_SEQUENCE FOUND ERROR! \n\n");
			}
		} catch (Exception de) {
			rollback();
			log.error("\n  errorJobExecutionPerformance - ERROR!  \n");
			log.error("err " + de.toString(), de);
		}
	}

	/**
	 * 
	 * @param currSeq
	 * @param errRmk
	 */
	// private void errorJobExecutionPerformance(String currSeq, String errRmk) {
	// try {
	// if (currSeq!=null && !currSeq.trim().equals("")){
	// begin();
	// // new TESCommonBCImpl().errorJobExecutionPerformance(currSeq, errRmk);
	// commit();
	// } else {
	// log.error("\n\n  errorJobExecutionPerformance - NO PERF_SEQUENCE FOUND ERROR! \n\n");
	// }
	// } catch (Exception de) {
	// rollback();
	// log.error("\n  errorJobExecutionPerformance - ERROR!  \n");
	// log.error("err " + de.toString(), de);
	// }
	// }

	/**
	 * 
	 * @param currSeq
	 */
	private void endJobExecutionPerformance(String currSeq) {
		try {
			log.info("\n\n [SC][endJobExecutionPerformance][] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> currSeq = " + currSeq);
			if (currSeq != null && !currSeq.trim().equals("")) {
				begin();
				new TESCommonBCImpl().endJobExecutionPerformance(currSeq);
				commit();
			} else {
				log.error("\n\n  endJobExecutionPerformance - NO PERF_SEQUENCE FOUND ERROR! \n\n");
			}
		} catch (Exception de) {
			rollback();
			log.error("\n  endJobExecutionPerformance - ERROR!  \n");
			log.error("err " + de.toString(), de);
		}
	}

	/**
	 * EDI test
	 */
	// public void testCreateEDIinvoice() throws EventException {
	// log.debug("\n\n\n BEGIN~~~~~~~~~~~~~~~~~~~~~~~~");
	// log.debug("\n\n RSC.testCreateEDIinvoice --- \n\n");
	// log.error("\n\n RSC.testCreateEDIinvoice --- \n\n");
	// EventResponse eventResponse = new com.clt.apps.opus.esd.tes.common.tesinterface.event.IF_ESD_TES_200EventResponse();
	// TESInterfaceManageBC if_command = null;
	// TESInvoiceCommonBC inv_com_command = null;
	// String str = null;
	//
	// try {
	// if_command = new TESInterfaceManageBCImpl();
	// inv_com_command = new TESInvoiceCommonBCImpl();
	//
	// // test data
	// // java.io.FileReader fr = new java.io.FileReader(new java.io.File("C:\\Temp\\EDI_test_StorageFull.txt"));
	// // java.io.FileReader fr = new java.io.FileReader(new java.io.File("C:\\Temp\\EDI_HIT_TEST_CYHandling_tmp.txt"));
	// java.io.FileReader fr = new java.io.FileReader(new java.io.File("C:\\Temp\\EDI_HIT_TEST_CYHandling_B.txt"));
	// // java.io.FileReader fr = new java.io.FileReader(new java.io.File("C:\\Temp\\HIT_INVOICE_SC.TXT"));
	// // java.io.FileReader fr = new java.io.FileReader(new java.io.File("/sitewlst/DocUp/OPUS/TES/D.COM.20081031181834.41615623"));
	//
	// java.io.BufferedReader br = new java.io.BufferedReader(fr);
	// int i = 1;
	// String buffer = "";
	// StringBuffer sb = new StringBuffer();
	// log.debug("\n\n ~~~~~~~~~~~~~~~~~~~~~~~~");
	// while ((buffer = br.readLine())!=null){
	// log.debug("("+i+")"+buffer);
	// sb.append(buffer+"\n");
	// i++;
	// }
	// log.debug("\n\n ~~~~~~~~~~~~~~~~~~~~~~~~");
	// str = sb.toString();
	// log.debug("\n\n @@@@@ file->str: \n"+str+" \n\n");
	//
	//
	// eventResponse = if_command.getEDIinvoiceInTESformat(str);
	// log.error(" \n done - SC.getEDIinvoiceInTESformat ");
	// begin();
	// if_command.createEDIinvoiceTmpData(eventResponse);
	// log.error(" \n done - SC.createEDIinvoiceTmpData ");
	// commit();
	//
	// log.debug("\n\n TML_EDI_SO_OFC_CTY_CD:"+
	// JSPUtil.getNull((String)((com.clt.apps.opus.esd.tes.common.tesinterface.event.IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("TML_EDI_SO_OFC_CTY_CD"))
	// +"   -   TML_EDI_SO_SEQ:"+
	// JSPUtil.getNull((String)((com.clt.apps.opus.esd.tes.common.tesinterface.event.IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("TML_EDI_SO_SEQ"))
	// +"   -   INV_OFC_CD:"+
	// JSPUtil.getNull((String)((com.clt.apps.opus.esd.tes.common.tesinterface.event.IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("INV_OFC_CD"))
	// +"\n\n"
	// );
	//
	// begin();
	// if_command.createEDIinvoiceTmpData2(eventResponse);
	// commit();
	//
	// begin();
	// log.debug("\n\n RSC.validateEDIInvoice ~~~~~~~ ");
	// inv_com_command.validateEDIInvoice(
	// JSPUtil.getNull((String)((com.clt.apps.opus.esd.tes.common.tesinterface.event.IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("TML_EDI_SO_OFC_CTY_CD")),
	// JSPUtil.getNull((String)((com.clt.apps.opus.esd.tes.common.tesinterface.event.IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("TML_EDI_SO_SEQ"))
	// );
	// commit();
	//
	// } catch (EventException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// } catch (java.io.IOException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	// log.debug("END~~~~~~~~~~~~~~~~~~~~~~~~~~");
	// }

	/**
	 * Search MGSet List
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMGSetFuelingChargeList(Event e) throws EventException {
		EventResponse eventResponse = null;
		// EsdTes1004Event event = (EsdTes1004Event)e;

		try {
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			eventResponse = command.searchMGSetFuelingChargeList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiMGSetFuelingCharge(Event e) throws EventException {

		try {
			begin();
			MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();
			command.multiMGSetFuelingCharge(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchMGSetFuelingChargeList(e);
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSOlist(Event e) throws EventException {
		log.debug("start searchCSRSOlist ===================");

		EsdTes0025Event event = (EsdTes0025Event) e;
		EventResponse eventResponse = null;

		try {
			log.debug("\n\n SC - searchCSRSOlist() ================================ \n\n");
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSOlist(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiRejectedCSRCancellation(Event e) throws EventException {
		log.debug("\n\n SC - multiRejectedCSRCancellation() ==================== \n\n");
		EsdTes0025Event event = (EsdTes0025Event) e;

		try {
			begin();
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			command.multiRejectedCSRCancellation(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchCSRSOlist(e);
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRAPiflist(Event e) throws EventException {

		log.debug("\n\n SC - searchCSRAPiflist() \n\n");

		EsdTes0100Event event = (EsdTes0100Event) e;

		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRAPiflist(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiConfirmCSR(Event e) throws EventException {
		log.debug("\n\n SC - multiConfirmCSR() =================== \n\n");
		EsdTes0100Event event = (EsdTes0100Event) e;
		CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();

		try {
			begin();
			command.multiConfirmCSR(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchCSRAPiflist(e);
	}

	/**
	 * Approval Requested CSR cancel Module provided by the BC method to cancel the deletion and AP information is Processing. *
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCSR(Event e) throws EventException {
		log.debug("\n\n SC - cancelCSR() \n");
		EsdTes0100Event event = (EsdTes0100Event) e;
		CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();

		try {
			begin();
			new com.clt.bizcommon.approval.basic.ApprovalBCImpl().cancelApproval(JSPUtil.getNull((String) event.getApInvHdrVO().getCsrNo()));
			command.cancelCSR(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return searchCSRAPiflist(e);
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSOlist2(Event e) throws EventException {
		log.debug("\n\n SC - searchCSRSOlist2()  ================================== \n\n");

		EsdTes0101Event event = (EsdTes0101Event) e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSOlist2(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRSOhdr(Event e) throws EventException {
		log.debug("\n\n start SC - searchCSRSOhdr() ========================= \n\n");
		EsdTes0101Event event = (EsdTes0101Event) e;
		EventResponse eventResponse = null;

		try {
			CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRSOhdr(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 9140 Search CNTR TYPE CD List
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCD9140List(Event e) throws EventException {
		EsdTes9140Event event = (EsdTes9140Event) e;
		EventResponse eventResponse = null;
		OffdockCYInvoiceManageBC command = new OffdockCYInvoiceManageBCImpl();

		try {
			eventResponse = command.searchBkgCntrTPCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 9010 Search CNTR TYPE CD List
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCD9010List(Event e) throws EventException {
		EsdTes9010Event event = (EsdTes9010Event) e;
		EventResponse eventResponse = null;
		MarineTerminalInvoiceManageBC command = new MarineTerminalInvoiceManageBCImpl();

		try {
			eventResponse = command.searchBkgCntrTPCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 9130 Search CNTR TYPE CD List
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCD9130List(Event e) throws EventException {
		EsdTes9130Event event = (EsdTes9130Event) e;
		EventResponse eventResponse = null;
		OndockRailChargeInvoiceManageBC command = new OndockRailChargeInvoiceManageBCImpl();

		try {
			eventResponse = command.searchBkgCntrTPCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 9142 Search CNTR TYPE CD List
	 * 
	 * @param e Event event object
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCD9142List(Event e) throws EventException {
		EsdTes9142Event event = (EsdTes9142Event) e;
		EventResponse eventResponse = null;
		MarineTerminalStorageInvoiceManageBC command = new MarineTerminalStorageInvoiceManageBCImpl();

		try {
			eventResponse = command.searchBkgCntrTPCDList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	// /**
	// *
	// * @param e
	// * @return EventResponse
	// * @exception EventException
	// */
	// private EventResponse modifyStsCdSOHDRBack(Event e) throws EventException {
	// EventResponse eventResponse = null;
	//
	// try {
	// CARIssueTransferSlipManageBC command = new CARIssueTransferSlipManageBCImpl();
	// eventResponse = command.modifyStsCdSOHDRBack(e);
	//
	// } catch (EventException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	//
	// return eventResponse;
	// }

	/**
	 * EDI test
	 */
	// public void testCreateEDIinvoice(Event e) throws EventException {
	// log.debug("\n\n\n BEGIN~~~~~~~~~~~~~~~~~~~~~~~~");
	// log.debug("\n\n RSC.testCreateEDIinvoice --- \n\n");
	// //EventResponse eventResponse = new com.clt.apps.opus.esd.tes.common.tesinterface.event.IF_ESD_TES_200EventResponse();
	// EventResponse eventResponse = null;
	// com.clt.apps.opus.esd.tes.common.tesinterface.basic.TESInterfaceManageBC if_command = null;
	// TESInvoiceCommonBC inv_com_command = null;
	// String str = null;
	// java.io.FileReader fr = null;
	// java.io.BufferedReader br = null;
	//
	// try {
	// if_command = new com.clt.apps.opus.esd.tes.common.tesinterface.basic.TESInterfaceManageBCImpl();
	// inv_com_command = new TESInvoiceCommonBCImpl();
	//
	// String fileName = "C:\\Temp\\TEST_EDI_SAMPLE.txt";
	//
	// log.error("\n\n RSC.testCreateEDIinvoice --- fileName -- "+fileName);
	//
	// fr = new java.io.FileReader(new java.io.File(fileName));
	// br = new java.io.BufferedReader(fr);
	// int i = 1;
	// String buffer = "";
	// StringBuffer sb = new StringBuffer();
	// log.debug("\n\n ~~~~~~~~~~~~~~~~~~~~~~~~");
	// while ((buffer = br.readLine())!=null){
	// log.debug("("+i+")"+buffer);
	// sb.append(buffer+"\n");
	// i++;
	// }
	// log.debug("\n\n ~~~~~~~~~~~~~~~~~~~~~~~~");
	// str = sb.toString();
	// log.debug("\n\n @@@@@ file->str: \n"+str+" \n\n");
	//
	//
	// eventResponse = if_command.getEDIinvoiceInTESformat(str);
	//
	// if_command.createEDIinvoiceTmpData(eventResponse);
	//
	// begin();
	// if_command.createEDInvoiceHDRTmpData(eventResponse);
	// commit();
	//
	// begin();
	// if_command.createEDInvoiceCNTRTmpData(eventResponse);
	// commit();
	//
	// begin();
	// if_command.createEDInvoiceDTLTmpData(eventResponse);
	// commit();
	//
	// begin();
	// if_command.createEDInvoiceAUTOFPTmpData(eventResponse);
	// commit();
	//
	// } catch (EventException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// } catch (java.io.IOException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// } finally {
	// try {
	// if (br!=null)br.close();
	// if (fr!=null)fr.close();
	// } catch(Exception ex){
	// log.error(ex.getMessage());
	// }
	// }
	//
	// try {
	// begin();
	// if_command.createEDIinvoiceTmpData2(eventResponse);
	// commit();
	// } catch (EventException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	//
	// try {
	// HashMap<String, String> hdr = (HashMap<String, String>)((GeneralEventResponse)eventResponse).getCustomData("HDR");
	//
	// TesEdiSoHdrVO tesEdiSoHdrVO = new TesEdiSoHdrVO();
	// tesEdiSoHdrVO.setTmlEdiSoOfcCtyCd((String)JSPUtil.getNull(hdr.get("TML_EDI_SO_OFC_CTY_CD")) );
	// tesEdiSoHdrVO.setTmlEdiSoSeq((String)JSPUtil.getNull(hdr.get("TML_EDI_SO_SEQ")) );
	// // tesEdiSoHdrVO.setInvOfcCd((String)JSPUtil.getNull(hdr.get("INV_OFC_CD")));
	//
	// log.debug(
	// "\n\n TML_EDI_SO_OFC_CTY_CD: " + tesEdiSoHdrVO.getTmlEdiSoOfcCtyCd()
	// + "\n TML_EDI_SO_SEQ: " + tesEdiSoHdrVO.getTmlEdiSoSeq()
	// + "\n INV_OFC_CD: " + tesEdiSoHdrVO.getInvOfcCd()
	// + "\n\n"
	// );
	//
	// // com.clt.apps.opus.esd.tes.common.tesinterface.event.IfEsdTes0200Event event = (com.clt.apps.opus.esd.tes.common.tesinterface.event.IfEsdTes0200Event)e;
	// com.clt.apps.opus.esd.tes.common.tesinterface.event.IfEsdTes0200Event event = new com.clt.apps.opus.esd.tes.common.tesinterface.event.IfEsdTes0200Event();
	// event.setTesEdiSoHdrVO(tesEdiSoHdrVO);
	//
	// begin();
	// log.debug("\n\n RSC.validateEDIInvoice ~~~~~~~ ");
	// inv_com_command.validateEDIInvoice( event );
	// commit();
	// log.debug("\n\n RSC.validateEDIInvoice ~~~~~~~ EEE ");
	// } catch (EventException de) {
	// rollback();
	// log.error("err " + de.toString(), de);
	// throw new EventException(de.getMessage());
	// }
	//
	// // HashMap<String, String> hdr = (HashMap<String, String>)((GeneralEventResponse)eventResponse).getCustomData("HDR");
	// //
	// // TesEdiSoHdrVO tesEdiSoHdrVO = new TesEdiSoHdrVO();
	// // tesEdiSoHdrVO.setTmlEdiSoOfcCtyCd((String)JSPUtil.getNull(hdr.get("TML_EDI_SO_OFC_CTY_CD")) );
	// // tesEdiSoHdrVO.setTmlEdiSoSeq((String)JSPUtil.getNull(hdr.get("TML_EDI_SO_SEQ")) );
	// //
	// // IfEsdTes0200Event event = new IfEsdTes0200Event();
	// //// IfEsdTes0200Event event = (IfEsdTes0200Event)ex;
	// // event.setTesEdiSoHdrVO(tesEdiSoHdrVO);
	// //
	// // begin();
	// // log.debug("\n\n RSC.validateEDIInvoice ~~~~~~~ ");
	// // inv_com_command.validateEDIInvoice( event );
	// // commit();
	// // log.debug("\n\n RSC.validateEDIInvoice ~~~~~~~ EEE ");
	// // } catch (EventException de) {
	// // rollback();
	// // log.error("err " + de.toString(), de);
	// // throw new EventException(de.getMessage());
	// // }
	//
	// // try {
	// // log.debug("\n\n RSC.getFTPPDFfile ~~~~~~~ ");
	// // TESFTPCommonBC tescom = new TESFTPCommonBCImpl();
	// // java.util.HashMap ftphm = new java.util.HashMap();
	// // ftphm.put("VNDR_SEQ", ((IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("VNDR_SEQ"));
	// // ftphm.put("INV_NO", ((IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("INV_NO"));
	// // ftphm.put("TML_EDI_SO_OFC_CTY_CD", ((IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("TML_EDI_SO_OFC_CTY_CD"));
	// // ftphm.put("TML_EDI_SO_SEQ", ((IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("TML_EDI_SO_SEQ"));
	// // ftphm.put("FILE_TYPE", "PDF");
	// // log.debug("\n\n @@@@ ftphm:"+ftphm+"\n\n");
	// // begin();
	// // tescom.getFTPfile(ftphm);
	// // commit();
	// // } catch (EventException de) {
	// // rollback();
	// // log.error("\n @@@@@ RSC.getFTPPDFfile @@@@@ \n"+"err " + de.toString(), de);
	// // throw new EventException(de.getMessage());
	// // } catch (Exception de) {
	// // rollback();
	// // log.error("\n @@@@@ RSC.getFTPPDFfile @@@@@ \n"+"err " + de.toString(), de);
	// // throw new EventException(de.getMessage());
	// // }
	//
	// log.debug("END~~~~~~~~~~~~~~~~~~~~~~~~~~");
	// }
}
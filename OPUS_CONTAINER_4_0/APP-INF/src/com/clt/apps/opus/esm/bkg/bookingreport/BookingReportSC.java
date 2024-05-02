/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingReportSC.java
*@FileTitle : BookingReport
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchSrepCdListVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.StaffListByOfcCdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0072Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0110Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0174Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0214Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0274Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0568Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0570Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0595Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0631Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0632Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0651Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0746Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0753Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0767Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0940Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0984Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0985Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg1057Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg1073Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg1081Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg1083Event;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkgChnEdiReceiveEvent;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.AutoratingReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BDRBookingStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BkgRptDfltVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCaDetailListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaInquiryReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaIssueDateOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocPFMCBLListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocPFMCOfcListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.FreightChargeSummaryReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.InBoundReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.RbcvesselVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchEDIGrpIDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchFCLListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.SearchUserGroupIdVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.VesselVVDListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.basic.SpecialReportBC;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.basic.SpecialReportBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event.EsmBkg0104Event;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event.EsmBkg0485Event;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event.EsmBkg0588Event;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event.EsmBkg0896Event;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.integration.SpecialReportDBDAO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.BkgRptSetVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoManifestInfoVO;
import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.SpecialCargoSummaryReportVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.basic.StatusReportBC;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.basic.StatusReportBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0068Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0071Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0103Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0111Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0116Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0162Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0168Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0169Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0171Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0172Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0619Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0625Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0647Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0727Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0772Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0775Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0814Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0953Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1004Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1006Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1007Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1110Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1143Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1701Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1702Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1703Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1704Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1705Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1706Event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByBLVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListoutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgClearanceCrossCheckListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListByBLVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlCntrInfoReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BokCntrListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CllCdlVslSumForRDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CustVipReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsUserGroupCdVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsTPSZSumListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsYardSumListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.SearchTradeListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportSpecialCargoOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportSummaryOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmDashboardVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmEdiSupVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTmlBlByVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBackEndJob;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration.CndManifestListDownloadDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgVgmWgtVO;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBC;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBCImpl;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
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
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * BookingReport Business Logic ServiceCommand - opus-handling business transaction abound BookingReport .
 * 
 * @author kang dong yun
 * @param <UseManifestSearchDetailVO>
 * @param <ManifestTransmitVO>
 * @param <UsaCustomsTransmissionBC>
 * @see SpecialReportDBDAO
 * @since J2EE 1.6
 */
 
public class BookingReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	// report file delimiter
	private final String SP = "|&&|";
	private final String EOR = "//EOR//";
	
	/**
	 * BookingReport system business scenario Predecessor<br>
	 * ESM_BKG-0896 business scenarios related internal object creation during calls<br>
	 */
	public void doStart() {
		log.debug("BookingReportSC start");
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 *  Finishing BookingReport system business scenarios<br>
	 *  Released at the end of ESM_BKG-0896 business scenarios related internal objects<br>
	 */
	public void doEnd() {
		log.debug("BookingReportSC end");
	}

	/**
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmBkg0896Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportTemplateId(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyReportTemplate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUserInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0753Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVVDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = checkVVDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVVD(e);
			} 			
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0767Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportTemplateList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addReportTemplate(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = removeReportTemplate(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0071Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBDRBookingStatusList(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchCombo(e);
	    	}
	    	
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = bkgClearanceCrossCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCombo0068(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = bkgClearanceCrossCheckListForRD(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0168Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVgmList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCombo0168(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = bkgClearanceCrossCheckListForRD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVgmDashboard(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchCllCdlRdParam(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)){
				eventResponse = manageVgmClz(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0169Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVgmHistory(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0171Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVgmEdiSup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendVgmEdi(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0172Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVgmEdiSupMlt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendVgmEdiMlt(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0772Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = bkgClearanceCrossCheckListForRD(e);
	    	}
			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0162Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerStowageList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0162(e);
			}
						
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0814Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = report0814(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = report0815(e);
			}

	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportTemplateBstVipList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCombo0103_0104_01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchStaffListByOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCombo0625_0104_02(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReportTemplateBstVipList(e);
			} 			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0103Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBLStatusList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = searchBLStatusListSpecialCargo(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
	    		eventResponse = searchBLStatusListSummary(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
	    		eventResponse = searchBLStatusList2(e);	    		
	    	} /*else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    	} 	*/		
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0775Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = report0775(e);
	    	} 			

	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0422Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//User Group Id Search
	    		eventResponse = searchUserGroupId(e);
	    	}

	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0274Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBLCargoManifestList(e);
	    	} /*else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    	} */
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0953Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchTsLoadingReportByLocation(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = search0953SortList(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0984Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = manageQueueRtnToRtn(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0985Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchQueueDetailReturn(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = manageQueueDetailReturn(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1004Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchDPSCUserGroup(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = modifyDocsUserGroupCd(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1006Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Queue Detail Amend Reason 조회
	    		eventResponse = searchAmendDetail(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1007Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Queue Detail Return Reason 조회
	    		eventResponse = searchQueueDetail(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0647Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBLStsReportList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchCombo0647(e);
	    	}			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0588Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialCargoSummaryReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0588(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0727Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBDRBookingNoList(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCMCrossCheckList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCMCode(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0116Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCMPrintList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0116(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0651Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBLCaDetailList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBLCaDetailHisList(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCAPerformanceReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0110(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0174Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchReportTemplateListMain(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCaSummaryReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchCaSummaryReportBLList(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0568Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchCaIssueDateList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = modifyCaIssueRemark(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCaIssueDateHisList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageManifestFlatFile (e);
			}
	    } else if(e.getEventName().equalsIgnoreCase("EsmBkg0570Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
		    		eventResponse = searchCaByBLno(e);
		    }
		} else if(e.getEventName().equalsIgnoreCase("EsmBkg0952Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
	    		eventResponse = searchCaSummaryReport(e);
	    	 }
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1073Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchEDIGrpId(e);
	    	}
	    } else if(e.getEventName().equalsIgnoreCase("EsmBkg1081Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.INIT)){
		    		eventResponse = searchComCode1081(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
		    		eventResponse = searchAutoratingReport (e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
		    		eventResponse = searchNonAutoratingReport (e);
	    	 }	
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg1083Event")) {	    	 
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){	
				 eventResponse = searchBookingTrendReportBLDetail(e);
	    	 }
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0485Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialCargoManifestInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgChnEdiReceiveEvent")) {
			eventResponse = loadRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0619Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOutBdMovementStsList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0619(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = report0814(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = report0815(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0072Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBDRBookingPfmcStatusList(e);
	    	}
	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0214Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDOCPerformanceReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	
				eventResponse = searchDOCPerformanceReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0214(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0595Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFrtSumList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0595(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmBkg0631Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
	    		eventResponse = searchRBCVesselList(e);
	    	}
	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0632Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchSalesPerformanceReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {				
				eventResponse = searchComCode0632(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchVVDByLane(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmBkg0746Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.INIT)){
		    		eventResponse = searchVesselUtilizationTrade(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
		    		eventResponse = searchVesselUtilizationSubTrade(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
		    		eventResponse = searchVesselUtilizationBound(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
		    		eventResponse = searchVesselUtilizationStatusReport(e);
	    	 }
	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0940Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchInBoundPfmcReport(e);
	    	} 
	    }
		else if(e.getEventName().equalsIgnoreCase("EsmBkg1057Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
	    		eventResponse = searchFCLList(e);
	    	 }
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0625Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchCustVipReport(e);
	    	} 	
	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1110Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchOutBdEirMovementStatusList(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
	    		eventResponse = searchComCode0619(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = report0814(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = report0815(e);
	    	}

	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1143Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCrossCheckList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCMCode(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1701Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBokCntrList(e);
//	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
//	    		eventResponse = searchBLStatusListSummary(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
	    		eventResponse = searchBokCntrDownExcel(e);
	    	}		
		//SJH.20150112.ADD : 1702신규
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1702Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComBoCdList1702(e); 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchBLCntrInfoList(e); 
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = searchCmBkgRptDownExcel(e, "1702");
	    	}
	    //SJH.20150130.ADD : 1703신규
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1703Event")) {			
	    	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
	    		eventResponse = searchComBoCdList1703(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchCmBkgRptDownExcel(e, "1703");
	    	}
	    //SJH.20150202.ADD : 1704신규
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1704Event")) {			
	    	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
	    		eventResponse = searchComBoCdList1704(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchCmBkgRptDownExcel(e, "1704");
	    	}
	    //SJH.20150202.ADD : 1705신규
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1705Event")) {			
	    	if (e.getFormCommand().isCommand(FormCommand.INIT)||e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = searchComBoCdList1705(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchCmBkgRptDownExcel(e, "1705");
	    	}
	    //SJH.20150202.ADD : 1706신규
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1706Event")) {			
	    	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
	    		eventResponse = searchComBoCdList1706(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchCmBkgRptDownExcel(e, "1706");
	    	}	    	
	    }
		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0896 : Report Share List ID retrieve<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportTemplateId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0896Event event = (EsmBkg0896Event)e;
		
		String usrId 		= "";
        String rptId 		= event.getRptId();
        String bkgRptKndCd 	= event.getBkgRptKndCd();
		
		SpecialReportBC command = new SpecialReportBCImpl();

		try{
			List<BkgRptSetVO> list = command.searchReportTemplateId(usrId, rptId, bkgRptKndCd);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0896 : Report Share List User Info Retrieve<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0896Event event = (EsmBkg0896Event)e;
		
		String usrId 		= event.getUsrId();
		String rptId 		= event.getRptId();
        String bkgRptKndCd 	= event.getBkgRptKndCd();
        
		String usrNm		= "";
		String ofcCd		= "";
		String check		= "N";

		SpecialReportBC command = new SpecialReportBCImpl();

		try{
			List<BkgRptSetVO> list = command.searchUserInfo(usrId);
			
			if (list.size() > 0){
				
				List<BkgRptSetVO> list2 = command.searchReportTemplateId(usrId, rptId, bkgRptKndCd);
				
				if (list2.size() > 0){
				
					check = "Y:N";
				}else{
					
					check = "Y:Y";
				}
				
				BkgRptSetVO vo = (BkgRptSetVO)list.get(0);
				log.debug("usrNm = " + vo.getUsrNm());
				log.debug("ofcCd = " + vo.getOfcCd());
				usrNm = vo.getUsrNm();
				ofcCd = vo.getOfcCd();
			}
			
			eventResponse.setETCData("check",check);
			eventResponse.setETCData("usrNm",usrNm);
			eventResponse.setETCData("ofcCd",ofcCd);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0896 : Report Share List Report input/modify <br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse copyReportTemplate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0896Event event = (EsmBkg0896Event)e;
		SpecialReportBC command = new SpecialReportBCImpl();
		
		try{
			begin();
			
			command.copyReportTemplate(event.getReportTemplateListVOS(),account);
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
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
	 * retrieve event process<br>
	 * ESM_BKG_0753 : VVD Selection Inquiry result retrieve.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchVVDList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0753Event event = (EsmBkg0753Event) e;
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        List<VesselVVDListVO> list = command.searchVVDList(event.getVesselVVDListVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);

        return eventResponse;
    }
    
    /**
	 * retrieve event process<br>
	 * ESM_BKG_0753 : VVD Selection Inquiry VVD checking.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse checkVVD(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0753Event event = (EsmBkg0753Event) e;
        
        String check = "";
        String lane	 = "";
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        List<VesselVVDListVO> list = command.searchVVDList(event.getVesselVVDListVO());
        
        if (list.size() > 0){
        	
        	check = "Y";
        	
        	VesselVVDListVO vo = (VesselVVDListVO)list.get(0);
        	
        	lane  = vo.getSlanCd();
        }else{
        	
        	check = "N";
        }
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setETCData("check", check);
        eventResponse.setETCData("lane", lane);
        
        return eventResponse;
    }
    
    /**
	 * retrieve event process<br>
	 * ESM_BKG_0753 : VVD Selection Inquiry VVD list checking.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0753Event event = (EsmBkg0753Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			
			command.checkVVDList(event.getVesselVVDListVOS());
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0767 : C/A Summary Template result retrieve.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportTemplateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0767Event event = (EsmBkg0767Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		BkgRptDfltVO returnVo = null;
		
		try{
			EBookingReceiptBC command2 = new EBookingReceiptBCImpl();
			// Delivery - conti_cd
			List<BkgComboVO> conti_cd = command2.searchComboMdmConti();
			BkgComboVO combovo = new BkgComboVO();
			combovo.setVal(" ");
			combovo.setName("All");
			conti_cd.add(0,combovo);

			BkgRptDfltVO vo = event.getBkgRptDfltVO();
			
			vo.setOwnrUsrId(account.getUsr_id());

	        List<BkgRptDfltVO> list = command.searchReportTemplateList(vo);
	        
	        eventResponse.setRsVoList(list);
	        
	        String listSize			= Integer.toString(list.size());
	        
	        if (list.size() > 0){
	        	
	        	for (int i = 0 ; i < list.size() ; i++){
	
	        		returnVo = (BkgRptDfltVO)list.get(i);
	        		
	        		eventResponse.setETCData("rptNm_" + Integer.toString(i), returnVo.getRptNm());
	        		eventResponse.setETCData("rptId_" + Integer.toString(i), returnVo.getRptId());
	        		eventResponse.setETCData("kndCd_" + Integer.toString(i), returnVo.getBkgRptKndCd());
	        		eventResponse.setETCData("seq_" + Integer.toString(i), returnVo.getBzcCondSqlCtnt());
	        		eventResponse.setETCData("ord_" + Integer.toString(i), returnVo.getBzcOrdCtnt());
	        	}
	        }
	        
	        eventResponse.setETCData("listSize",listSize);
	        eventResponse.setRsVoList(conti_cd);
	        
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0767 : C/A Summary Template info input<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse addReportTemplate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0767Event event = (EsmBkg0767Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		BookingUtil command2 = new BookingUtil();
		BkgReferenceNoGenerationVO vo = new BkgReferenceNoGenerationVO();
		
		BkgRptDfltVO[] bkgRptDfltVOS = event.getBkgRptDfltVOS();
		
		try{
			
			for ( int i=0 ; i < bkgRptDfltVOS.length ; i++) {
				
				if ( bkgRptDfltVOS[i].getIbflag().equals("I")){
					
					vo = command2.manageBkgReferenceNumberGeneration("RPT", account.getOfc_cd(), account.getUsr_id());		
					
					bkgRptDfltVOS[i].setRptId(vo.getRptNo());
				}
				
				bkgRptDfltVOS[i].setUpdUsrId(account.getUsr_id());
			}	
			
			begin();
			
			command.addReportTemplate(bkgRptDfltVOS);
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0767 : C/A Summary Template info delete.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse removeReportTemplate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0767Event event = (EsmBkg0767Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		BkgRptDfltVO[] bkgRptDfltVOS = event.getBkgRptDfltVOS();
		
		try{
			
			for ( int i=0 ; i < bkgRptDfltVOS.length ; i++) {
				
				bkgRptDfltVOS[i].setUpdUsrId(account.getUsr_id());
			}	
			
			begin();
			
			command.addReportTemplate(bkgRptDfltVOS);
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * BDR Status Inquiry info retrieve.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchBDRBookingStatusList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0071Event event = (EsmBkg0071Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchBDRBookingStatusListVO> list = command.searchBDRBookingStatusList(event.getInfoVO());
		
		eventResponse.setRsVoList(list);
		
		list = command.getRuntime();
		if(list.size() > 0){
			SearchBDRBookingStatusListVO vo =  list.get(0);
			eventResponse.setETCData("runtime", vo.getRuntime());
		}
		
		return eventResponse;
		
	}	
	/**
	 * retrieve event process<br>
	 * Lane,Direction combo event process<br>
	 * 0071 combo list retrieve.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		searchSvcLaneByLoc(e,eventResponse);
		searchDirection(e,eventResponse);
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0071 :  combo list retrieve.<br>
	 * Service Lane combo event process<br>
	 * 
	 * @param Event e
	 * @param GeneralEventResponse eventResponse
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneByLoc(Event e,GeneralEventResponse eventResponse) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		List<MdmVslSvcLaneVO> list = command.searchSvcLaneCd();
		list.add(0,new MdmVslSvcLaneVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0071 :  combo list retrieve.<br>
	 * 
	 * @param Event e
	 * @param GeneralEventResponse eventResponse
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDirection(Event e,GeneralEventResponse eventResponse) throws EventException {
		
		 
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		
		
		//Service Lane Direction combo event process
		List<BkgComboVO> list = command.searchCombo("CD00714");
	
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
	/**
	 * ESM_BKG_0068 : combo event process.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0068(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		
       
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		RASCommonBC command1 = new RASCommonBCImpl();
		RsltContiListVO contiVo = null;
		List<RsltContiListVO> contiData = null;
		
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("All");
		combovo.setName("All");
		
		
		/*EQ TYPE - CONTAINER TYPE SIZE*/
		List<MdmCntrTpSzVO> eqlist = command.searchTypeSize(null);
		MdmCntrTpSzVO eqvo = new MdmCntrTpSzVO();
		eqvo.setCntrTpszDesc("All");
		eqvo.setCntrTpszRmk("All");
		eqvo.setCntrTpszPsaCd("All");
		eqlist.add(0,eqvo);
		eventResponse.setRsVoList(eqlist);
		

		
		/*R/D R- OUTBOUND RECEIVED*/
		List<BkgComboVO> list = command.searchCombo("CD00764");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		
		/*R/D D- INBOUND DELIVERY*/
		list = command.searchCombo("CD00765");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*BOOKING STATUS*/
		list = command.searchCombo("CD00769");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*CARGO STATUS*/
//		list = command.searchCombo("CD00767");
		list = command.searchCombo("CD02716");
//		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*CUSTOMER TYPE*/
		list = command.searchCombo("CD00880");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*DEL CONTINENT*/
//		list = command.searchCombo("CD02169");
//	    list.add(0,combovo);
//		eventResponse.setRsVoList(list);
		
	
        contiVo = new RsltContiListVO();
        contiData = command1.seacrhRasContiList(contiVo);
        eventResponse.setRsVoList(contiData);
        //eventResponse.setCustomData("contiCd", contiData);
		
		return eventResponse;
		
	}	

	/**
	 * ESM_BKG_0068 : B/L Data  input complete checking report function.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse bkgClearanceCrossCheckList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0068Event event = (EsmBkg0068Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<BkgClearanceCrossCheckListInVO> list = command.bkgClearanceCrossCheckList(event.getInfoVO());
		
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			BkgClearanceCrossCheckListInVO vo =  list.get(0);
			eventResponse.setETCData("total_bkg",      vo.getTotalBkg());
			eventResponse.setETCData("total_bl",       vo.getTotalBl());
			eventResponse.setETCData("total_bkg_f",    vo.getTotalBkgF());
			eventResponse.setETCData("total_bkg_t",    vo.getTotalBkgT());
			eventResponse.setETCData("total_ctrl_f",   vo.getTotalCtrlF());
			eventResponse.setETCData("total_ctrl_t",   vo.getTotalCtrlT());
			eventResponse.setETCData("total_cfm",      vo.getTotalCfm());
			eventResponse.setETCData("total_vl",       vo.getTotalVl());
			eventResponse.setETCData("total_cm",       vo.getTotalCm());
			eventResponse.setETCData("total_md",       vo.getTotalMd());
			eventResponse.setETCData("total_charge",   vo.getTotalCharge());
			eventResponse.setETCData("total_apprval",  vo.getTotalApprval());
			eventResponse.setETCData("total_issue",    vo.getTotalIssue());
			eventResponse.setETCData("total_receiving", vo.getTotalReceiving());
			eventResponse.setETCData("aes_yn", vo.getAesYn());
		}
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0068 : B/L Data  input complete checking report function - RD print.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse bkgClearanceCrossCheckListForRD(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0772Event event = (EsmBkg0772Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<BkgClearanceCrossCheckListInVO> list = command.bkgClearanceCrossCheckList(event.getInfoVO());
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
	    Map<String, String> colValues = null;
		//main page 
		for (int i = 0; i < list.size(); i++) {			
			colValues = list.get(i).getColumnValues();		
			
			    
			pw.print(colValues.get("bkg_no") +SP);	         //bkg_no          
			pw.print(colValues.get("bl_no") +SP);	         //bl_no           
			pw.print(colValues.get("bkg_sts_cd") +SP);	     //bkg_sts_cd      
			pw.print(colValues.get("bkg_cgo_tp_cd") +SP);	 //bkg_cgo_tp_cd   
			pw.print(colValues.get("qty_bkg") +SP);	         //qty_bkg         
			pw.print(colValues.get("qty_cntr") +SP);	     //qty_cntr        
			pw.print(colValues.get("cntr_cfm_flg") +SP);	 //cntr_cfm_flg    
			pw.print(colValues.get("cntr_no") +SP);	         //cntr_no         
			pw.print(colValues.get("sz") +SP);	             //sz              
			pw.print(colValues.get("vol") +SP);	             //vol             
			pw.print(colValues.get("firm") +SP);	         //firm            
			pw.print(colValues.get("st") +SP);	             //st              
			pw.print(colValues.get("cm") +SP);	             //cm              
			pw.print(colValues.get("shipper") +SP);	         //shipper         
			pw.print(colValues.get("ff") +SP);	             //ff              
			pw.print(colValues.get("md") +SP);	             //md              
			pw.print(colValues.get("aes") +SP);	             //aes
			pw.print(colValues.get("tax_id") +SP);	         //tax_id   
			pw.print(colValues.get("pod_cd") +SP);	         //pod_cd          
			pw.print(colValues.get("del_cd") +SP);	         //del_cd          
			pw.print(colValues.get("rcv_term_cd") +SP);	     //rcv_term_cd     
			pw.print(colValues.get("de_term_cd") +SP);	     //de_term_cd      
			pw.print(colValues.get("charge") +SP);	         //charge          
			pw.print(colValues.get("apprval") +SP);	         //apprval         
			pw.print(colValues.get("issue") +SP);	         //issue           
			pw.print(colValues.get("receiving") +SP);	     //receiving       
			pw.print(colValues.get("total_bkg") +SP);	     //total_bkg       
			pw.print(colValues.get("total_bl") +SP);	     //total_bl        
			pw.print(colValues.get("total_bkg_f") +SP);	     //total_bkg_f     
			pw.print(colValues.get("total_bkg_t") +SP);	     //total_bkg_t     
			pw.print(colValues.get("total_ctrl_f") +SP);	 //total_ctrl_f    
			pw.print(colValues.get("total_ctrl_t") +SP);	 //total_ctrl_t    
			pw.print(colValues.get("total_cfm") +SP);	     //total_cfm       
			pw.print(colValues.get("total_vl") +SP);	     //total_vl        
			pw.print(colValues.get("total_cm") +SP);	     //total_cm        
			pw.print(colValues.get("total_md") +SP);	     //total_md        
			pw.print(colValues.get("total_charge") +SP);	 //total_charge    
			pw.print(colValues.get("total_apprval") +SP);	 //total_apprval   
			pw.print(colValues.get("total_issue") +SP);	     //total_issue     
			pw.print(colValues.get("total_receiving") +SP);	 //total_receiving 		     	                     
			pw.print(colValues.get("dense_rank2") +SP);	     //dense_rank2 																				     	                     
			pw.print("\r\n");
				
		}
		pw.println(EOR);
		
		//log.debug("#####################################"+sw.toString());
		eventResponse.setCustomData("RD", sw.toString());
		
		return eventResponse;
	}
	
    /**
	 * ESM_BKG_0162 : retrieve event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerStowageList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0162Event event = (EsmBkg0162Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<CntrStowageintVO> list = command.searchContainerStowageList(event.getCntrStowageintVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	
	/**
     * ESM_BKG_0162 : combo list retrieve.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0162(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal("ALL");
		combovo.setDesc("All");
		combovo.setName("All");

        List<BkgComboVO> list = command.searchCombo("CD00592");
        eventResponse.setRsVoList(list);
        
        List<BkgComboVO> list2 = command.searchCombo("CD02136");
        eventResponse.setRsVoList(list2);
        

        List<BkgComboVO> list3 = command.searchCombo("CD02135");
        eventResponse.setRsVoList(list3);
        

        List<BkgComboVO> list4 = command.searchCombo("CD01053");
        eventResponse.setRsVoList(list4);
        

        List<BkgComboVO> list5 = command.searchCombo("CD00136");
        list5.add(0,combovo);
        eventResponse.setRsVoList(list5);
        
        return eventResponse;
    }
	
	
//    
//    /**
//     * ESM_BKG_0618 :  0618  MAIL,  FAX send.<br>
//     * 
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//	private EventResponse sendLoadingConfirmation(Event e) throws EventException {
//    	
//    	// PDTO(Data Transfer Object including Parameters)
//		EsmBkg0618Event event = (EsmBkg0618Event)e;
//		StatusReportBC statusBc = new StatusReportBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		List<BkgNtcHisVO> bkgNtcHisVOs = null;
//		//String msg_cd="";	
//		try{	
//			begin();
//			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//				//msg_cd = "BKG00243";
//				/*MAIL 전송*/
//				bkgNtcHisVOs =statusBc.sendEmailByBkgNoList(event.getLoadingConfirmationinVO(),event.getLoadingConfirmationinVOS(),account);
//				
//			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
//				//msg_cd = "BKG00242";
//				/*FAX 전송*/
//				bkgNtcHisVOs =statusBc.sendFaxByBkgNoList(event.getLoadingConfirmationinVO(),event.getLoadingConfirmationinVOS(),account);
//			}
//			
//			/*msgs['BKG00242'] = "Failed to transmit to the fax server. Contact the server admin";
//			msgs['BKG00243'] = "Failed to transmit to the email server. Contact the server admin";
//			*/ 
//			BookingHistoryMgtBC hisBc = new BookingHistoryMgtBCImpl();
//			//HisBc.createBookingNoticeHistory(bkgNtcHisVOs);
//			hisBc.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0618");
//			commit();
//			
//		} catch(EventException ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw ex;
//		} catch(Exception ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//		}
//
//	    return eventResponse;
//    }
    
	
	 /**
     * ESM_BKG_0814 : Outbound Container Movement Status by Yard print screen.<br>
     * call screen: ESM_BKG_0619 
     * 
     * @category ESM_BKG_0814
     * @category report0814
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse report0814(Event e) throws EventException {

		// BC object creation|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|100|&&|0|&&|0|&&| MYPKGTM|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|12|&&|1|&&|0|&&|0|&&| SGSINKA|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&|0|&&| VNSGNY6|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|18|&&|0|&&|0|&&| USLGBPT|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&| IDJKTY7|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|2|&&|25|&&|0|&&|0|&&| KRPUSYG|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|60|&&|12|&&|0|&&|72|&&|65|&&|103|&&|0|&&|64|&&| USOAKM1|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|27|&&|0|&&|27|&&|0|&&|0|&&|0|&&|0|&&| AUSYDCT|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|3|&&|1|&&|0|&&|0|&&| THBKKY6|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&| JPTOYY1|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|6|&&|0|&&|0|&&| //EOR// 
		StatusReportBC command = new StatusReportBCImpl();
		
		// return object 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// event creation
		EsmBkg0814Event event = (EsmBkg0814Event)e;
		List<OutBdMovementStsYardSumListOutVO> list = command.searchOutBdMovementByYardSum(event.getOutBdMovementStsListInVO());
	    
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
		//main page
		for (int i = 0; i < list.size(); i++) {			
			OutBdMovementStsYardSumListOutVO vo = list.get(i);		
			
			pw.print(vo.getOrgYdCd()+SP); 
			
			pw.print(vo.getOpDr2()+SP); 
			pw.print(vo.getOpDr4()+SP);
			pw.print(vo.getOpRf2()+SP);
			pw.print(vo.getOpRf4()+SP);
			
			pw.print(vo.getOcDr2()+SP); 
			pw.print(vo.getOcDr4()+SP);
			pw.print(vo.getOcRf2()+SP);
			pw.print(vo.getOcRf4()+SP);
			
			pw.print(vo.getEtnDr2()+SP); 
			pw.print(vo.getEtnDr4()+SP);
			pw.print(vo.getEtnRf2()+SP);
			pw.print(vo.getEtnRf4()+SP);
			
			pw.print(vo.getMtDr2()+SP); 
			pw.print(vo.getMtDr4()+SP);
			pw.print(vo.getMtRf2()+SP);
			pw.print(vo.getMtRf4()+SP);
			
			pw.print(vo.getOtDr2()+SP); 
			pw.print(vo.getOtDr4()+SP);
			pw.print(vo.getOtRf2()+SP);
			pw.print(vo.getOtRf4()+SP);
			pw.print("\r\n");
				
		}
		pw.println(EOR);
		
		//log.debug(sw.toString());
		eventResponse.setCustomData("RD", sw.toString());
		
		return eventResponse;
	}			
	
	/**
     * ESM_BKG_0815 : Outbound Container Movement Status by Type/Size  print screen.<br>
     * call screen: ESM_BKG_0619 
     * 
     * @category ESM_BKG_0815
     * @category report0815
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse report0815(Event e) throws EventException {

		// BC object creation 
		StatusReportBC command = new StatusReportBCImpl();
		
		// return object 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// event creation
		EsmBkg0814Event event = (EsmBkg0814Event)e;
		List<OutBdMovementStsTPSZSumListOutVO> list = command.searchOutBdMovementByTPSZSum(event.getOutBdMovementStsListInVO());
	    
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
		//main page 
		for (int i = 0; i < list.size(); i++) {			
			OutBdMovementStsTPSZSumListOutVO vo = list.get(i);		
			
			pw.print(vo.getCntrTpszCdMv()+SP); 
			
			pw.print(vo.getBkgQty()+SP); 
			pw.print(vo.getOp()+SP);
			pw.print(vo.getOc()+SP);
			pw.print(vo.getEtn()+SP);
			
			pw.print(vo.getCy()+SP); 
			pw.print(vo.getVl()+SP);
			pw.print(vo.getMt()+SP);
			pw.print(vo.getOt()+SP);
			
			pw.print(vo.getTtl()+SP); 
			pw.print(vo.getDiffQty()+SP);
			pw.print("\r\n");
				
		}
		pw.println(EOR);
		
		//System.out.println(sw.toString());
		eventResponse.setCustomData("RD", sw.toString());
		
		return eventResponse;
	}	

	
	

	
//	/**
//     * ESM_BKG_0620 : combo list retrieve.<br>
//     * 
//     * @param  Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//	private EventResponse searchComCode0620(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        BookingUtil command = new BookingUtil();
//        
//    	//BKG Status
//        List<BkgComboVO> list = command.searchCombo("CD00769");
//        eventResponse.setRsVoList(list);
//        
//        //Zone
//        List<BkgComboVO> list2 = command.searchCombo("CD00206");
//        eventResponse.setRsVoList(list2);
//        
//        return eventResponse;
//    }
    
//    /**
//     * ESM_BKG_0620 :  Staff list retrieve.<br>
//     * 
//     * @param  Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//	private EventResponse searchStaffList0620(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        BookingUtil command = new BookingUtil();
//        EsmBkg0620Event event = (EsmBkg0620Event)e;
//    	String ofc_cd = event.getTroStatusListInVO().getBkgOfcCd();
//    	//StaffList
//        List<StaffListByOfcCdVO> list = command.searchStaffListByOfcCd(ofc_cd);
//        eventResponse.setRsVoList(list);
//            
//        
//        return eventResponse;
//    }
    
    /**
	 * ESM_BKG_0104 : 0104 Report template(Default, Detail, User Set) retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportTemplateBstVipList(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		SpecialReportBC command = new SpecialReportBCImpl();
		event.getInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> list = command.searchReportTemplateBstVipList(event.getInfoVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0104_01 : Staff List retrieve by Office.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStaffListByOfcCd(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		BookingUtil command = new BookingUtil();
		
		if(event.getOfcGubun().equals("LO")){
			List<SearchSrepCdListVO> list = command.searchSrepCdList(event.getOfcCd());
			eventResponse.setRsVoList(list);
		}else {
			List<StaffListByOfcCdVO> list = command.searchStaffListByOfcCd(event.getOfcCd());
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}    
	/**
	 * ESM_BKG_0104 : 0104 Report template(Default, Detail, User Set) Transaction process.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReportTemplateBstVipList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try{
			ReportTemplateListVO[] reportTemplateListVO = event.getInfoVOs();
			BkgReferenceNoGenerationVO vo = null;
			if(reportTemplateListVO != null){
				for ( int i=0; i<reportTemplateListVO.length; i++ ) {
					if ( reportTemplateListVO[i].getIbflag().equals("I")){
						vo = command2.manageBkgReferenceNumberGeneration("RPT", account.getOfc_cd(), account.getUsr_id());		
						reportTemplateListVO[i].setRptId(vo.getRptNo());					
					}
				}
				begin();
				command.manageReportTemplateBstVipList(reportTemplateListVO,account);
				commit();
			}
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	} 
	
	/**
	 * retrieve event process<br>
	 * Direction,R/D Term....combo event process<br>
	 * 0103,0104_01 combo list retrieve.<br>
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0103_0104_01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil command = new BookingUtil();
		SpecialReportBC command2 = new SpecialReportBCImpl();
		
		/* Dir */
		searchDirection(e,eventResponse);
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("");
		combovo.setName("All");
		
		/* R/D Term R- OUTBOUND RECEIVED */
		List<BkgComboVO> list = command.searchCombo("CD00764");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* R/D Term D- INBOUND DELIVERY */
		list = command.searchCombo("CD00765");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* DELIVERY Mode */
//		list = command.searchCombo("CD01661");
		
		list = command.searchCombo("CD02455");
		list.add(0,combovo);

		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* Booking Kind */
		list = command.searchCombo("CD01619");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*EQ TYPE - CONTAINER TYPE SIZE */
		List<MdmCntrTpSzVO> eqlist = command.searchTypeSize(null);
		MdmCntrTpSzVO eqvo = new MdmCntrTpSzVO();
		eqvo.setCntrTpszDesc("All");
		eqvo.setCntrTpszRmk("All");
		eqvo.setCntrTpszPsaCd("All");
		//eqlist.add(0,eqvo);
		eventResponse.setRsVoList(eqlist);
		
		/* S Mode */
		list = command.searchCombo("CD02149");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* S Route */
		list = command2.searchScontiCd();
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*CUSTOMER TYPE */
//		list = command.searchCombo("CD00704");
//		//list.add(0,combovo);
//		eventResponse.setRsVoList(list);
		
		/* Report Type List */
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		event.getInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = command2.searchReportTemplateBstVipList(event.getInfoVO());
		eventResponse.setRsVoList(rlist);
		
		return eventResponse;
			
	}
	/**
	 * retrieve event process<br>
	 * Direction,R/D Term....combo event process<br>
	 * 0625,0104_02 combo list retrieve.<br>
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0625_0104_02(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		SpecialReportBC command2 = new SpecialReportBCImpl();
		
//		BkgComboVO combovo = new BkgComboVO();
//		combovo.setDesc("");
//		combovo.setName("All");
		
		/* Customer Type CD */
		List<BkgComboVO> list = command.searchCombo("CD00880");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		
		/* Report Type List */
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		event.getInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = command2.searchReportTemplateBstVipList(event.getInfoVO());
		eventResponse.setRsVoList(rlist);
		
		
		return eventResponse;
		
	}	
	
	/**
	 * retrieve event process<br>
	 * 0103 Booking Status Report retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStatusList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0103Event event = (EsmBkg0103Event)e;
		StatusReportBC command = new StatusReportBCImpl();		
		List<StatusReportOutVO> list = command.searchBLStatusList(event.getInfoVO());
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * 0103 BKG OFC SUB info retrieve for Booking Status Report info .<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStatusList2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0103Event event = (EsmBkg0103Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		String sub_ofc_cds = command.searchBLStatusList2(event.getInfoVO());
		
		/* 사용하지 않는 Local Variable 주석 처리 */
//		BookingUtil command2 = new BookingUtil();
//		
//        List<BkgComboVO> list1 = command2.searchCombo("CD00912");
        //eventResponse.setRsVoList(list1);
        eventResponse.setETCData("sub_ofc_cds",sub_ofc_cds);

		return eventResponse;
	}
	
	/**
	 * retrieve event process<br>
	 * 0103 Booking Status Special Cargo Report retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStatusListSpecialCargo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0103Event event = (EsmBkg0103Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<StatusReportSpecialCargoOutVO> list = command.searchBLStatusListSpecialCargo(event.getInfoVO());
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	/**
	 * retrieve event process<br>
	 * 0103 Booking Status Summary Report retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStatusListSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0103Event event = (EsmBkg0103Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<StatusReportSummaryOutVO> list = command.searchBLStatusListSummary(event.getInfoVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	
	 /**
     * ESM_BKG_0814 : Outbound Container Movement Status by Yard print screen.<br>
     * call screen: ESM_BKG_0619 
     * 
     * @category ESM_BKG_0814
     * @category report0814
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse report0775(Event e) throws EventException {

		// BC object creation |&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|100|&&|0|&&|0|&&| MYPKGTM|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|12|&&|1|&&|0|&&|0|&&| SGSINKA|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&|0|&&| VNSGNY6|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|18|&&|0|&&|0|&&| USLGBPT|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&| IDJKTY7|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|2|&&|25|&&|0|&&|0|&&| KRPUSYG|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|60|&&|12|&&|0|&&|72|&&|65|&&|103|&&|0|&&|64|&&| USOAKM1|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|27|&&|0|&&|27|&&|0|&&|0|&&|0|&&|0|&&| AUSYDCT|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|3|&&|1|&&|0|&&|0|&&| THBKKY6|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&| JPTOYY1|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|6|&&|0|&&|0|&&| //EOR// 
		StatusReportBC command = new StatusReportBCImpl();
		
		// return object
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmBkg0775Event event = (EsmBkg0775Event)e;
		
		if(event.getInfoVO() != null ) event.getInfoVO().setRdYn("Y");
		String rp_type = event.getInfoVO().getPReportType();
		List<StatusReportOutVO> list = null;
		List<StatusReportSpecialCargoOutVO> listSC = null; //Special Cargo
		
		if(rp_type.equals("ak") || rp_type.equals("bb") || rp_type.equals("dg") || rp_type.equals("rf") )
			listSC = command.searchBLStatusListSpecialCargo((event.getInfoVO()));
		else 
			list =command.searchBLStatusList((event.getInfoVO()));
			
	    
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
	    Map<String, String> colValues = null;
		//main page 
	    String orderByTemp ="";
	    String orderByTitle ="";
	    if(rp_type.equals("ak") || rp_type.equals("bb") || rp_type.equals("dg") || rp_type.equals("rf") ){
	    	for (int i = 0; i < listSC.size() ; i++) {
				colValues = listSC.get(i).getColumnValues();	
				orderByTemp =colValues.get("orderby_title");
				pw.print(colValues.get("orderby_title")    +SP);

				pw.print(colValues.get("bst_flg")    +SP);
				pw.print(colValues.get("bdr_flg")    +SP);

				pw.print(colValues.get("bkg_no")    +SP);
				pw.print(colValues.get("bl_no")    +SP);

				pw.print(colValues.get("cntr_no")    +SP);
				if(rp_type.equals("bb") ){
					pw.print(""  +SP);
				}else{
					if(colValues.get("cntr_tpsz_cd").equals("") && colValues.get("cntr_vol_qty").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("cntr_tpsz_cd") + " - " + colValues.get("cntr_vol_qty")   +SP);
					}
				}

				pw.print(colValues.get("cgo_seq")    +SP);

				if(rp_type.equals("ak") ){
					pw.print(colValues.get("grs_wgt")    +SP);

					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}

					pw.print(colValues.get("ovr_fwrd_len")    +SP);
					pw.print(colValues.get("ovr_bkwd_len")    +SP);
					pw.print(colValues.get("ovr_hgt")    +SP);

					pw.print(colValues.get("ovr_lf_len")    +SP);
					pw.print(colValues.get("ovr_rt_len")    +SP);

					pw.print(colValues.get("ovr_void_slt_qty")    +SP);

					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("dcgo_flg")    +SP);

					pw.print(colValues.get("rd_cgo_flg")    +SP);
					pw.print(colValues.get("bb_cgo_flg")    +SP);

					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);

					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);

					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);

					if(!colValues.get("akrep_cmdt").equals("")){
						pw.print("Commdity: "+colValues.get("akrep_cmdt")    +SP);	
					}else{
						pw.print(""    +SP);	
					}
					pw.print(colValues.get("meas_qty")    +SP);

				}else if(rp_type.equals("bb")){
					pw.print(colValues.get("grs_wgt")    +SP);
					
					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}
					
					pw.print(colValues.get("dim_len")    +SP);
					pw.print(colValues.get("dim_wdt")    +SP);
					pw.print(colValues.get("dim_hgt")    +SP);
					
					pw.print(colValues.get("ovr_void_slt_qty")    +SP);
					
					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("dcgo_flg")    +SP);
					pw.print(colValues.get("rd_cgo_flg")    +SP);
					pw.print(colValues.get("awk_cgo_flg")    +SP);
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);
					
					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);
					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);
					if(!colValues.get("bb_cmdt").equals("")){
						pw.print("Commdity: "+colValues.get("bb_cmdt")    +SP);	
					}else{
						pw.print(""    +SP);	
					}
					pw.print(colValues.get("meas_qty")    +SP);
					
				}else if(rp_type.equals("dg")){
					pw.print(colValues.get("imdg_un_no")    +SP);
					pw.print(colValues.get("imdg_clss_cd")    +SP);
					
					pw.print(colValues.get("flsh_pnt_cdo_temp")    +SP);
					pw.print(colValues.get("imdg_pck_grp_cd")    +SP);
					
					pw.print(colValues.get("net_wgt")    +SP);
					pw.print(colValues.get("grs_wgt")    +SP);
					
					pw.print(colValues.get("meas_qty")    +SP);
					
					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}
					
					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("awk_cgo_flg")    +SP);
					pw.print(colValues.get("rd_cgo_flg")    +SP);
					pw.print(colValues.get("bb_cgo_flg")    +SP);
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);
					
					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);
					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);
					
					if(!colValues.get("emer_cntc_phn_no_ctnt").equals("")){
						pw.print("Contact: " + colValues.get("emer_cntc_phn_no_ctnt")    +SP);
					}else{
						pw.print(""    +SP);	
					}
					
					if(!colValues.get("prp_shp_nm").equals("")){
						pw.print("Substance: " + colValues.get("prp_shp_nm")    +SP);
					}else{
						pw.print(""    +SP);	
					}

				}else if(rp_type.equals("rf")){
					pw.print(colValues.get("grs_wgt")    +SP);
					
					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}
					
					pw.print(colValues.get("cdo_temp")    +SP);
					pw.print(colValues.get("fdo_temp")    +SP);
					
					pw.print(colValues.get("humid_no")    +SP);
					pw.print(colValues.get("vltg_no")    +SP);
					
					pw.print(colValues.get("cntr_vent_tp_cd")    +SP);
					pw.print(colValues.get("pwr_spl_cbl_flg")    +SP);
					
					pw.print(colValues.get("ctrl_atms_flg")    +SP);
					pw.print(colValues.get("modi_atms_flg")    +SP);
					pw.print(colValues.get("humid_ctrl_flg")    +SP);
					
					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("awk_cgo_flg")    +SP);
					pw.print(colValues.get("dcgo_flg")    +SP);
					pw.print(colValues.get("bb_cgo_flg")    +SP);
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);
					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);
					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);
					
					pw.print(colValues.get("rf_cmdt")    +SP);
					pw.print(colValues.get("meas_qty")    +SP);
				}
				
				
				if(!colValues.get("remark_detail").equals("")){
					pw.print("Remarks: " +JSPUtil.replace(colValues.get("remark_detail"),"\r\n"," ") +SP);	 //remarks
				}else{
					pw.print(""    +SP);	
				}
				
				pw.print(""    +SP); //stowage	reefer는 해당사항 없음
				
				
				
				if(orderByTitle.equals(orderByTemp)){
					pw.print("0"    +SP);
					pw.print("0"    +SP);
				}else{
					//System.out.println("colValues.get(row_seq):"+colValues.get("no")+" " +colValues.get("bkg_no")+" "+colValues.get("bkg_cnt") );
					pw.print(colValues.get("bkg_cnt")    +SP);
					pw.print(colValues.get("bl_cnt")    +SP);
				}
				pw.print(colValues.get("d2")    +SP);
				pw.print(colValues.get("q4")    +SP);
				pw.print(colValues.get("d4")    +SP);
				pw.print(colValues.get("r2")    +SP);
				pw.print(colValues.get("d5")    +SP);
				pw.print(colValues.get("r4")    +SP);
				pw.print(colValues.get("d7")    +SP);
				pw.print(colValues.get("r5")    +SP);
				pw.print(colValues.get("f2")    +SP);
				pw.print(colValues.get("t2")    +SP);
				pw.print(colValues.get("f4")    +SP);
				pw.print(colValues.get("t4")    +SP);
				pw.print(colValues.get("f5")    +SP);
				pw.print(colValues.get("p2")    +SP);
				pw.print(colValues.get("o2")    +SP);
				pw.print(colValues.get("p4")    +SP);
				pw.print(colValues.get("o4")    +SP);
				pw.print(colValues.get("z4")    +SP);
				pw.print(colValues.get("q2")    +SP);
				pw.print(colValues.get("z2")    +SP);
				pw.print(colValues.get("teu")    +SP);
				pw.print(colValues.get("feu")    +SP);						
			     	                     
																								     	                     
				pw.print("\r\n");	    
				if(!orderByTitle.equals(orderByTemp)){
					orderByTitle = orderByTemp; 
				}
	    	}
	    }else{
	    	
				for (int i = 0; i < list.size() ; i++) {
					colValues = list.get(i).getColumnValues();		
					pw.print(colValues.get("orderby_title") +SP);  //ORDER BY TITLE
					
					pw.print(colValues.get("bkg_sts_cd")    +SP);  //BST               
					pw.print(colValues.get("bdr_flg")       +SP);  //bdr
					
					pw.print(colValues.get("si_flg")        +SP);	 //SR                
																									     	                     
					pw.print(colValues.get("bkg_no")        +SP);	 //Booking No        
					pw.print(colValues.get("bl_no")         +SP);	 //B/L No            
																									     	                     
					pw.print(colValues.get("shpr_name")     +SP);	 //Shipper           
					pw.print(colValues.get("cnee_name")     +SP);	 //Consignee         
																									     	                     
					pw.print(colValues.get("por_cd")        +SP);	 //POR               
					pw.print(colValues.get("del_cd")        +SP);	 //DEL               
																									     	                     
					pw.print(colValues.get("teu")           +SP);	 //TEU - booking Q'ty
					pw.print(colValues.get("feu")           +SP);	 //FEU - booking Q'ty
																									     	                     
					pw.print(colValues.get("rep")           +SP);	 //Rep. CMDT               
					
					pw.print(colValues.get("bkg_mea_qty")   +SP);	 //MEA(CBM)               
					pw.print(colValues.get("bkg_actwgt_qty")+SP);	 //WGT(KGS)          
																									     	                     
					pw.print(colValues.get("pck_qty")       +SP);	 //pkg_qty             
					pw.print(colValues.get("pck_tp_cd")     +SP);	 //pkg_qty_type_cd           
					pw.print(colValues.get("rcv_term_cd")   +SP);	 //R                 
					pw.print(colValues.get("de_term_cd")    +SP);	 //D                 
																									     	                     
					pw.print(colValues.get("dcgo_flg")      +SP);	 //DG                
					pw.print(colValues.get("awk_cgo_flg")   +SP);	 //AK                
																									     	                     
					pw.print(colValues.get("rc_flg")        +SP);	 //RF                
					pw.print(colValues.get("bb_cgo_flg")    +SP);	 //BB                
																									     	                     
					pw.print(colValues.get("fd_grd_flg")    +SP);	 //FG                
					pw.print(colValues.get("pc")            +SP);	 //PC                
																									     	                     
					pw.print(colValues.get("itn_flg")       +SP);	 //ITN               
					pw.print(colValues.get("itn_type")      +SP);	 //ITN Type
					
					pw.print(colValues.get("caed_flg")       +SP);	 //CAED               
					pw.print(colValues.get("caed_type")      +SP);	 //CAED Type
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);	 //B.OFC             
					pw.print(colValues.get("ob_sls_ofc_cd") +SP);	 //L.OFC             
																									     	                     
					pw.print(colValues.get("doc_usr_id")    +SP);	 //BKG STF
					pw.print(colValues.get("ob_srep_cd")    +SP);	 //L.SREP
					
					pw.print(colValues.get("cntr_no")       +SP);	 //cntr_no
					pw.print(colValues.get("cntr_tpsz_cd")  +SP);	 //cntr_tpsz_cd
					
					pw.print(JSPUtil.replace(colValues.get("remark_detail"),"\r\n"," ") +SP);	 //remarks
					
					pw.print(colValues.get("contact") +SP);	 //Contact
					pw.print(colValues.get("tel") +SP);	 //Tel
					
					pw.print(colValues.get("rd_total_d2") +SP);	 //rd_total_d2
					pw.print(colValues.get("rd_total_q4") +SP);	 //rd_total_q4
		
					pw.print(colValues.get("rd_total_d4") +SP);	 //rd_total_d4
					pw.print(colValues.get("rd_total_r2") +SP);	 //rd_total_r2
		
					pw.print(colValues.get("rd_total_d5") +SP);	 //rd_total_d5
					pw.print(colValues.get("rd_total_r4") +SP);	 //rd_total_r4
		
					pw.print(colValues.get("rd_total_d7") +SP);	 //rd_total_d7
					pw.print(colValues.get("rd_total_r5") +SP);	 //rd_total_r5
		
					pw.print(colValues.get("rd_total_f2") +SP);	 //rd_total_f2
					pw.print(colValues.get("rd_total_t2") +SP);	 //rd_total_t2
		
					pw.print(colValues.get("rd_total_f4") +SP);	 //rd_total_f4
					pw.print(colValues.get("rd_total_t4") +SP);	 //rd_total_t4
		
					pw.print(colValues.get("rd_total_f5") +SP);	 //rd_total_f5
					pw.print(colValues.get("rd_total_p2") +SP);	 //rd_total_p2
		
					pw.print(colValues.get("rd_total_o2") +SP);	 //rd_total_o2
					pw.print(colValues.get("rd_total_p4") +SP);	 //rd_total_p4
		
					pw.print(colValues.get("rd_total_o4") +SP);	 //rd_total_o4
					pw.print(colValues.get("rd_total_z4") +SP);	 //rd_total_z4
		
					pw.print(colValues.get("rd_total_q2") +SP);	 //rd_total_q2
					pw.print(colValues.get("rd_total_z2") +SP);	 //rd_total_z2			
				     	                     
																									     	                     
					pw.print("\r\n");
						
				}
	    }
		pw.println(EOR);
		
		//log.debug("#####################################"+sw.toString());
		eventResponse.setCustomData("RD", sw.toString());
		
		return eventResponse;
	}			

	/**
	 * retrieve event process<br>
	 * 0647 B/L Status Report retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStsReportList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0647Event event = (EsmBkg0647Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		
		try{
			List<BlStsReportOutVO> list = command.searchBLStsReportList(event.getInfoVO());
			if(list.size() > 0){
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			}
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err" + ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err" + ex.toString(),ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0647 : Search <br>
	 * Customer Type retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0647(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		
		try{
			/* Customer Type CD */
			List<BkgComboVO> list = command.searchCombo("CD00880");
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err" + ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err" + ex.toString(),ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}	
     
    /**
	 * ESM_BKG_0588 : retrieve event process<br>
	 * Special cargo summary information<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialCargoSummaryReport(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0588Event event = (EsmBkg0588Event)e;
		SpecialReportBC command = new SpecialReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SpecialCargoSummaryReportVO> list = null;
		
		list = command.searchSpecialCargoSummaryReport(event.getSpecialCargoSummaryReportVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
    
    /**
     * ESM_BKG_0588 : combo list retrieve.<br>
     * Special cargo summary information<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0588(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        //Zone
        List<BkgComboVO> list2 = command.searchCombo("CD00206");
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        
        //BKG Status
        List<BkgComboVO> list = command.searchCombo("CD00769");
        list.add(0,combovo);
        eventResponse.setRsVoList(list);
        
        return eventResponse;
    }
    
    /**
	 * ESM_BKG_0727 : retrieve event process<br>
	 * BDR Booking No Status - Inquiry<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBDRBookingNoList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0727Event event = (EsmBkg0727Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BdrBookingNoListVO> list = null;
		
		list = command.searchBDRBookingNoList(event.getBdrBookingNoListVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}


    /**
	 * retrieve event process<br>
	 * ESM_BKG_0111 : C/M Data Cross-Check List (Master BL/Houser BL) retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMCrossCheckList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0111Event event = (EsmBkg0111Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<BkgCMCroChkListByBLVO> list = command.searchCMCrossCheckList(event.getBkgCMCroChkListinVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}  
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0111 : C/M Code retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO bkgComboVO = new BkgComboVO();
    	//Report Type
        List<BkgComboVO> list = command.searchCombo("CD01634");
        
        /*StringBuffer code	= new StringBuffer();
        StringBuffer name	= new StringBuffer();
        
        code.append(" ");
        name.append("All");
        */
       
        bkgComboVO.setVal(" ");
        bkgComboVO.setDesc(" ");
        bkgComboVO.setName(" ");
		
        list.add(0,bkgComboVO);
        /*if (list.size() > 0){
        	
        	for (int i = 0 ; i < list.size() ; i++){
        		
        		bkgComboVO = list.get(i);
        		
        		code.append("|" + bkgComboVO.getVal());
        		name.append("|" + bkgComboVO.getName());
        	}
		}
        
        eventResponse.setETCData("code",code.toString());
        eventResponse.setETCData("name",name.toString());
		*/
        eventResponse.setRsVoList(list);
        
		return eventResponse;
	}  
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0116 : C/M Print by VVD (CM)retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMPrintList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0116Event event = (EsmBkg0116Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<BkgCMPrintListoutVO> list = command.searchCMPrintList(event.getBkgCMPrintListinVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
	
	/**
     * ESM_BKG_0116 : combo list retrieve.<br>
     * C/M Print by VVD<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0116(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        // 01. Combo data retrieve(RTerm)
		List<BkgComboVO> rTerm  = command.searchCombo("CD00764");		
		// 01. Combo data retrieve (DTerm)
		List<BkgComboVO> dTerm  = command.searchCombo("CD00765");
		
		eventResponse.setRsVoList(rTerm);
		eventResponse.setRsVoList(dTerm);
        
        return eventResponse;
    }
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0651 : C/A Detail(s) Pop-up retrieve .<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLCaDetailList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0651Event event = (EsmBkg0651Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String blNo 	= event.getBlNo();
		String bkgNo	= event.getBkgNo();
		String caNo		= event.getCaNo();
		
		List<BlCaDetailListVO> list = command.searchBLCaDetailList(blNo, bkgNo, caNo);
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0651 : History List retrieve in C/A Detail(s) Pop-up.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchBLCaDetailHisList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0651Event event = (EsmBkg0651Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String bkgNo	= event.getBkgNo();
		String corrNo   = event.getCaNo();

		log.debug("bkg_no" + bkgNo);

		List<BlCaDetailListVO> list = command.searchBLCaDetailHisList(bkgNo, corrNo);
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  	
    
    /**
     * ESM_BKG_0110 : combo list retrieve.<br>
     * C/A Performance Report<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0110(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        //Correction Kind
        List<BkgComboVO> list = command.searchCombo("CD02272");
        eventResponse.setRsVoList(list);
        
        return eventResponse;
    }
	
	
//    /**
//	 * retrieve event process<br>
//	 * ESM_BKG_0421 : SR_WRK_STS_CD info modify in Que List .<br>
//	 * 
//	 * @param     Event e
//	 * @return    EventResponse
//	 * @exception EventException
//	 */
//    private EventResponse modifyBkgSrWrkStsCd(Event e) throws EventException {
//		
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmBkg0421Event event = (EsmBkg0421Event)e;
//		PerformanceReportBC command = new PerformanceReportBCImpl();
//		try{	
//			begin();
//			DocQueueDetailListVO[] vos = event.getDocQueueDetailListVOs();
//			
//			if (vos != null && vos.length > 0){
//				for (int i = 0; i < vos.length; i++) {
// 				
//					if (vos[i].getSel().equals("1") ) {
//						vos[i].setComFlg("end");
//						command.manageQueueDetailList(vos[i],account);
//					}
//				}
//				commit();
//			}
//			
//		} catch(EventException ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw ex;
//		} catch(Exception ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//		}
//		return eventResponse;
//	}
    
	 /**
	 * retrieve event process<br>
	 * 0421 Queue List init info retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchUserGroupId(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		 List<SearchUserGroupIdVO> list = searchUserGroupId();
		 /* Current Queue permission*/
		if(list.size() > 0){
			eventResponse.setETCData("grp_cd",   list.get(0).getDpcsWrkGrpCd());
		}else{
			eventResponse.setETCData("grp_cd",   "");
		}
		eventResponse.setRsVoList(list);
		return eventResponse;
		
	}		
	
	/**
	 * retrieve event process<br>
	 * User Group Id info retrieve.<br>
	 * 
	 * @return List<SearchUserGroupIdVO>
	 * @exception EventException
	 */
	
    private List<SearchUserGroupIdVO> searchUserGroupId() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PerformanceReportBC command = new PerformanceReportBCImpl();
		List<SearchUserGroupIdVO> list = command.searchUserGroupId(account.getUsr_id());
		return list;
	}
    	    	
	/**
	 * 0984 related table data create/modify in case of clicking Return to Return button.<br>	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageQueueRtnToRtn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0984Event event = (EsmBkg0984Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailReturnInVO docQueueDetailReturnInVO = event.getInfoVO();
			begin();
			command.manageQueueRtnToRtn(docQueueDetailReturnInVO,account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
     * 0985  Return related table data modify/create in case of clickin Return button<br>	
     * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageQueueDetailReturn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0985Event event = (EsmBkg0985Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailReturnInVO docQueueDetailReturnInVO = event.getInfoVO();
			begin();
			command.manageQueueDetailReturn(docQueueDetailReturnInVO,account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
    /**
	 * retrieve event process<br>
	 * ESM_BKG_0110 : C/A Performance Report retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCAPerformanceReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0110Event event = (EsmBkg0110Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		List<CaPerformanceReportOutVO> list = command.searchCAPerformanceReport(event.getCaPerformanceReportInVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0174 : C/A Summary By VVD & Office retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportTemplateListMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0174Event event = (EsmBkg0174Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		BkgRptDfltVO returnVo = null;
		
		try{
			
			EBookingReceiptBC command2 = new EBookingReceiptBCImpl();
			// Delivery - conti_cd
			List<BkgComboVO> conti_cd = command2.searchComboMdmConti();
			BkgComboVO combovo = new BkgComboVO();
			combovo.setVal(" ");
			combovo.setName("All");
			conti_cd.add(0,combovo);
			
			BkgRptDfltVO vo = event.getBkgRptDfltVO();
			
			vo.setOwnrUsrId(account.getUsr_id());
			
			
	        List<BkgRptDfltVO> list = command.searchReportTemplateList(vo);
	        
	        eventResponse.setRsVoList(list);
	        
	        String listSize			= Integer.toString(list.size());
	        
	        if (list.size() > 0){
	        	
	        	for (int i = 0 ; i < list.size() ; i++){
	
	        		returnVo = (BkgRptDfltVO)list.get(i);
	        		
	        		eventResponse.setETCData("rptNm_" + Integer.toString(i+1), returnVo.getRptNm());
	        		eventResponse.setETCData("rptId_" + Integer.toString(i+1), returnVo.getRptId());
	        		eventResponse.setETCData("kndCd_" + Integer.toString(i+1), returnVo.getBkgRptKndCd());
	        		eventResponse.setETCData("seq_" + Integer.toString(i+1), returnVo.getBzcCondSqlCtnt());
	        		eventResponse.setETCData("ord_" + Integer.toString(i+1), returnVo.getBzcOrdCtnt());
	        	}
	        }
	        
	        eventResponse.setETCData("listSize",listSize);
	        eventResponse.setRsVoList(conti_cd);
		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	} 
    
    
    /**
	 * retrieve event process<br>
	 * 1004 Correspond group USER info retrieve for Super User Authority Change.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchDPSCUserGroup(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
    	EsmBkg1004Event event = (EsmBkg1004Event)e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchUserGroupIdVO> list2 = searchUserGroupId();
			 /* Current Queue permission*/
			if(list2.size() > 0){
				event.getBkgDpcsUsrGrpVO().setDpcsWrkGrpCd(list2.get(0).getDpcsWrkGrpCd());
			}
			List<BkgDpcsUsrGrpVO> list = command.searchDPSCUserGroup(null,null,event.getBkgDpcsUsrGrpVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	    
    
	
	/**
	 * 1004 Super User Authority Change - Related table data modify in case of clicking PIC CHANGE(0421screen) button .<br>	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyDocsUserGroupCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1004Event event = (EsmBkg1004Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocsUserGroupCdVO docsUserGroupCdVO = event.getInfoVO();
			begin();
			command.modifyDocsUserGroupCd(docsUserGroupCdVO,account);
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * retrieve event process<br>
	 * 1006 Queue Detail Amend Reason Detail retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    
    private EventResponse searchAmendDetail(Event e) throws EventException {
		

		EsmBkg1006Event event = (EsmBkg1006Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocsAmendReasonCDVO> list = command.searchAmendDetail(event.getBkgNo(), event.getSrNo());
		if(list.size() > 0){
			eventResponse.setETCData("mis_typ"       ,  list.get(0).getMisTyp());    
			eventResponse.setETCData("mis_rat_sc"    , 	list.get(0).getMisRatSc());  
			eventResponse.setETCData("mis_rat_rfa"   , 	list.get(0).getMisRatRfa()); 
			eventResponse.setETCData("wro_dat_inp"   , 	list.get(0).getWroDatInp()); 
			eventResponse.setETCData("sal"           , 	list.get(0).getSal());       
			eventResponse.setETCData("fo_err"        , 	list.get(0).getFoErr());     
																									                             
			eventResponse.setETCData("dat_mis"       , 	list.get(0).getDatMis());    
			eventResponse.setETCData("unc_fax"       , 	list.get(0).getUncFax());    
			eventResponse.setETCData("bl_dat_cha"    , 	list.get(0).getBlDatCha());  
			eventResponse.setETCData("cod"           , 	list.get(0).getCod());       
			eventResponse.setETCData("spl"           , 	list.get(0).getSpl());       
		}
		
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	     
	/**
	 * retrieve event process<br>
	 * 1007 Queue Detail Return Reason retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchQueueDetail(Event e) throws EventException {
		

		EsmBkg1007Event event = (EsmBkg1007Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocsQueueDetailVO> list = command.searchQueueDetail(event.getSrKndCd(),event.getBkgNo(), event.getSrNo());
		if(list.size() > 0){
			eventResponse.setETCData("bkg_main"              , list.get(0).getBkgMain());             
			eventResponse.setETCData("customer_info"         , list.get(0).getCustomerInfo());        
			eventResponse.setETCData("frt_charge"            , list.get(0).getFrtCharge());           
			eventResponse.setETCData("container"             , list.get(0).getContainer());           
			eventResponse.setETCData("container_manifest"    , list.get(0).getContainerManifest());   
			eventResponse.setETCData("danger"                , list.get(0).getDanger());              
			eventResponse.setETCData("awkward"               , list.get(0).getAwkward());             
			eventResponse.setETCData("reefer"                , list.get(0).getReefer());              
			eventResponse.setETCData("b_bulk"                , list.get(0).getBBulk());               
			eventResponse.setETCData("rly_vvd_port"          , list.get(0).getRlyVvdPort());          
			eventResponse.setETCData("new_bkg"               , list.get(0).getNewBkg());              
			eventResponse.setETCData("bkg_split"             , list.get(0).getBkgSplit());            
			eventResponse.setETCData("bl_inform"             , list.get(0).getBlInform());            
			eventResponse.setETCData("nvo_house_bl"          , list.get(0).getNvoHouseBl());          
			eventResponse.setETCData("customer_verification" , list.get(0).getCustomerVerification());    
		}
		
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
	
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0568 : C/A Report retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchCaIssueDateList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0568Event event = (EsmBkg0568Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		List<CaIssueDateOutVO> list = command.searchCaIssueDateList(event.getCaIssueDateInVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	} 
    
    /**
	 * retrieve event process<br>
	 * ESM_BKG_0568 : History List retrieve on C/A Report .<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchCaIssueDateHisList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0568Event event = (EsmBkg0568Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String bkgNo = event.getCaIssueDateInVO().getBkgNo();
		String corrNo = event.getCaIssueDateInVO().getCorrNo();
		log.debug("bkg_no" + bkgNo);
		log.debug("corr_no"+ corrNo);
		List<BlCaDetailListVO> list = command.searchBLCaDetailHisList(bkgNo,corrNo);
		
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	} 
    
    /**
	 * 멀티 이벤트 처리<br>
	 * ESM_BKG_0568 : Remark modify on C/A Report.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyCaIssueRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0568Event event = (EsmBkg0568Event)e;
		BDRCorrectionBC command = new BDRCorrectionBCImpl();
				
		
		try{
			
			begin();
			
			command.modifyCaIssueRemark(event.getCaIssueDateInVOS(),account);
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");

		} catch(EventException ex) {
			rollback();
			eventResponse.setETCData("success_yn"      ,  "N");
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			eventResponse.setETCData("success_yn"      ,  "N");
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Multi event process<br>
	 * ESM_BKG_0568 : Register Flat File on Manifest after remark modify on C/A Report.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse manageManifestFlatFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0568Event event = (EsmBkg0568Event)e;
		
		UsaManifestListDownloadBC command2 = new UsaManifestListDownloadBCImpl();
//		CndManifestListDownloadBCImpl command3 = new CndManifestListDownloadBCImpl();
		CndManifestListDownloadBackEndJob command3 = new CndManifestListDownloadBackEndJob();
		ManifestListDetailVO[] vos = new ManifestListDetailVO[1];		
		UsaManifestListDetailVO usVo = new UsaManifestListDetailVO();
		CndManifestModificationVO caVo = new CndManifestModificationVO();
		
		//########################################################## 2010.04.20 add
		
		UsaManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
		UsaCustomsTransmissionBC usaCommand = new UsaCustomsTransmissionBCImpl();
		CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
		
		CndCustomsTransmissionBC cndCommand = new CndCustomsTransmissionBCImpl();
		
		//########################################################## 2010.04.20 add end
		try{

			begin();
			log.debug(" vos size >>>>>>>>>>>>>>>>>>> " + event.getCaIssueDateInVOS().length);
			//Create FlatFile and Send Log save after Manifest data retrieve for customs declaration >>> 11/23 modify
			for (int i = 0 ; i < event.getCaIssueDateInVOS().length ; i++){
				
				if (event.getCaIssueDateInVOS()[i].getVvd().length() != 9) continue;
				
				log.debug("vvd >>>>>>>>>>> " + event.getCaIssueDateInVOS()[i].getVvd());
				log.debug("vslCd >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getVvd().substring(0, 4));
				log.debug("SkdVoyNo >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getVvd().substring(4, 8));
				log.debug("skdDirCd >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getVvd().substring(8));
				log.debug("blNo >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getBlNo());
				log.debug("bkgNo >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getBkgNo());
				log.debug("caNo >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getCorrNo());
				log.debug("caDt >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getCorrDt().replaceAll("-", "").replaceAll(":", "").replaceAll(" ", ""));							
				
				log.debug("pod >>> " + event.getCaIssueDateInVOS()[i].getPodCd().substring(0, 2));
				
//				if (event.getCaIssueDateInVOS()[i].getCntCd().equals("US")){
				if (event.getCaIssueDateInVOS()[i].getPodCd().substring(0, 2).equals("US")){
		
					usVo.setPgmNo("ESM_BKG_0568");
					
					usVo.setVslCd(event.getCaIssueDateInVOS()[i].getVvd().substring(0, 4));
					usVo.setSkdVoyNo(event.getCaIssueDateInVOS()[i].getVvd().substring(4, 8));
					usVo.setSkdDirCd(event.getCaIssueDateInVOS()[i].getVvd().substring(8));
					usVo.setBkgNo(event.getCaIssueDateInVOS()[i].getBkgNo());
					usVo.setBlNos(event.getCaIssueDateInVOS()[i].getBlNo());
					usVo.setBlType("M");
					usVo.setPodCd(event.getCaIssueDateInVOS()[i].getPodCd());
					
					usVo.setCaNo(event.getCaIssueDateInVOS()[i].getCorrNo());
					usVo.setCaIssDt(event.getCaIssueDateInVOS()[i].getCorrDt().replaceAll("-", "").replaceAll(":", ""));
					usVo.setCaFlg("Y");
					
					vos[0] = usVo;
					
					command2.manageManifest(vos, account);
					
					
					//########################################################## 2010.04.20 add
					
					// US customs update
					UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
					usaDetailVOs[0] = new UsaManifestListDetailVO();
					usaDetailVOs[0].setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
					usaDetailVOs[0].setCstmsMfTpCd("AI");
					usaDetailVOs[0].setCstmsTrsmStsCd("04");
					usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
					manifestListDownloadBC.manageManifest(usaDetailVOs, account);

					// US customs  AI send
					UsaManifestSearchDetailVO[] usaDetailVO2s = new UsaManifestSearchDetailVO[1];
					usaDetailVO2s[0] = new UsaManifestSearchDetailVO();
					usaDetailVO2s[0].setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
					usaDetailVO2s[0].setVvd(event.getCaIssueDateInVOS()[i].getVvd()); //bkg_vvd
					usaDetailVO2s[0].setPol(event.getCaIssueDateInVOS()[i].getPolCd()); //bkg_vvd
					usaDetailVO2s[0].setPod(event.getCaIssueDateInVOS()[i].getPodCd()); //bkg_vvd 
					usaDetailVO2s[0].setTransmitCd("AI");
					usaDetailVO2s[0].setUsrId(account.getUsr_id());
					usaDetailVO2s[0].setOfcCd(account.getOfc_cd());
					usaCommand.transmitManifest(usaDetailVO2s);

					// CDL auto send
					BlInfoCondVO blInfoCondVO = new BlInfoCondVO();
					blInfoCondVO.setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
					List<BlInfoVO> blInfos = usaCommand.searchTmlBlByVvd(blInfoCondVO);
					if (blInfos.size() > 0)
					{
						CllCdlTransmitVO[] cllCdlTransmitVOs = new CllCdlTransmitVO[blInfos.size()];
						for (int j = 0; j < blInfos.size(); j++)
						{
							UsaTmlBlByVvdVO usaTmlBlByVvdVO = (UsaTmlBlByVvdVO) blInfos.get(j);
							cllCdlTransmitVOs[j] = new CllCdlTransmitVO();
							cllCdlTransmitVOs[j].setBkgNo(usaTmlBlByVvdVO.getBkgNo());
							cllCdlTransmitVOs[j].setBlNo(usaTmlBlByVvdVO.getBlNo());
							cllCdlTransmitVOs[j].setCntrNo(usaTmlBlByVvdVO.getCntrNo());
							cllCdlTransmitVOs[j].setBkgCgoTpCd(usaTmlBlByVvdVO.getBkgCgoTpCd());
							cllCdlTransmitVOs[j].setInListType("D");
							cllCdlTransmitVOs[j].setInVvdCd(usaTmlBlByVvdVO.getVslCd() + usaTmlBlByVvdVO.getSkdVoyNo()
									+ usaTmlBlByVvdVO.getSkdDirCd());
							cllCdlTransmitVOs[j].setInPolCd(usaTmlBlByVvdVO.getCstmsPolCd());
							cllCdlTransmitVOs[j].setInPodCd(usaTmlBlByVvdVO.getCstmsPodCd());
							cllCdlTransmitVOs[j].setInSndId(usaTmlBlByVvdVO.getSndId());
							cllCdlTransmitVOs[j].setInRcvId(usaTmlBlByVvdVO.getRcvId());
							cllCdlTransmitVOs[j].setInYdCd(usaTmlBlByVvdVO.getYdCd());
							cllCdlTransmitVOs[j].setInAreaId("USA");
							cllCdlTransmitVOs[j].setInDestSvrCd("USA");
							cllCdlTransmitVOs[j].setInWhereGubun("DL");
						}
						
						cLLCDLManifestBC.transmitCllCdl(cllCdlTransmitVOs, account);
					}
					//########################################################## 2010.04.20 add end
				}else{
				
					caVo.setVslCd(event.getCaIssueDateInVOS()[i].getVvd().substring(0, 4));
					caVo.setSkdVoyNo(event.getCaIssueDateInVOS()[i].getVvd().substring(4, 8));
					caVo.setSkdDirCd(event.getCaIssueDateInVOS()[i].getVvd().substring(8));
					caVo.setBkgNo(event.getCaIssueDateInVOS()[i].getBkgNo());
					caVo.setBlNos(event.getCaIssueDateInVOS()[i].getBlNo());
					caVo.setBlType("M");
					caVo.setIfFlg("Y");
					caVo.setPodCd(event.getCaIssueDateInVOS()[i].getPodCd());
					
					caVo.setCaNo(event.getCaIssueDateInVOS()[i].getCorrNo());
					caVo.setCaIssDt(event.getCaIssueDateInVOS()[i].getCorrDt().replaceAll("-", "").replaceAll(":", ""));
					
					vos[0] = caVo;
					
					command3.setManifestListDetailVO(vos, account, new CndManifestListDownloadDBDAO());
					command3.doStart();
					
					if (event.getCaIssueDateInVOS()[i].getPodCd().substring(0, 2).equals("CA")){
					
						//########################################################## 2010.04.20 add
						CndCstmsManifestAmendmentVO cndCstmsManifestAmendmentVO = new CndCstmsManifestAmendmentVO();
						cndCstmsManifestAmendmentVO.setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
						cndCstmsManifestAmendmentVO.setMh(""); //master : M, house : H
						cndCstmsManifestAmendmentVO.setFullMtyCd(""); //Full : F, empty : M
	
						CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
						cndManifestModificationVOs[0] = new CndManifestModificationVO();
						cndManifestModificationVOs[0].setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
						cndManifestModificationVOs[0].setCstmsTrsmStsCd("04");
						if ("M".equals(cndCstmsManifestAmendmentVO.getMh())) {
							cndManifestModificationVOs[0].setCstmsMfTpCd("A6A");
							if ("M".equals(cndCstmsManifestAmendmentVO.getFullMtyCd())) {
								cndManifestModificationVOs[0].setCstmsMfTpCd("E10");
							}
						} else {
							cndManifestModificationVOs[0].setCstmsMfTpCd("S10");
						}
						manifestListDownloadBC.manageManifest(cndManifestModificationVOs, account);
	
						// 전송
						cndCstmsManifestAmendmentVO.setMiSndDt(cndManifestModificationVOs[0].getEdiSndDt());
						cndCommand.transAmendManifest(cndCstmsManifestAmendmentVO, account);
						//########################################################## 2010.04.20 add end  
					}
					
				}

			}
	
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		} catch(EventException ex) {
			rollback();
			eventResponse.setETCData("success_yn"      ,  "N");
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			eventResponse.setETCData("success_yn"      ,  "N");
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieve event process<br>
	 * ESM_BKG_0570 : C/A Report_B/L Inquiry retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchCaByBLno(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0570Event event = (EsmBkg0570Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String corrNo = "";
		log.debug("bl no = " + event.getBlNo());
		List<CaInquiryReportVO> list1 = command.searchCaByBLno(event.getBlNo());
		
		if (list1.size() > 0)
			corrNo = list1.get(0).getCorrNo();
		
		List<CaInquiryReportVO> list2 = command.searchCaByCustomerInfo(event.getBlNo(), corrNo);
		List<CaInquiryReportVO> list3 = command.searchCaByMarkDescInfo(event.getBlNo(), corrNo);
		List<CaInquiryReportVO> list4 = command.searchCaByContainerInfo(event.getBlNo(), corrNo);
		
		if (list2.size() == 0){
			
			list2 = command.searchCaByCustomerInfo(event.getBlNo(), "");
		}
		
		if (list3.size() == 0){
			
			list3 = command.searchCaByMarkDescInfo(event.getBlNo(), "");
		}

		if (list4.size() == 0){
			
			list4 = command.searchCaByContainerInfo(event.getBlNo(), "");
		}
		
		eventResponse.setRsVoList(list1);
		eventResponse.setRsVoList(list2);
		eventResponse.setRsVoList(list3);
		eventResponse.setRsVoList(list4);
		return eventResponse;
	} 
	
   
	/**
	 * retrieve event process<br>
	 * 0953 O/B & T/S Loading Report by Location info retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsLoadingReportByLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0953Event event = (EsmBkg0953Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<TsLoadingRptByLocListOutVO> list = command.searchTsLoadingReportByLocation(event.getInfoVO());
		if(list.size() > 0){
			eventResponse.setETCData("total_40t", list.get(0).getTotal40t());
			eventResponse.setETCData("total_20t", list.get(0).getTotal20t());
		}
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}    
	/**
	 * retrieve event process<br>
	 * 0274 General Cargo Manifest by VVD/PORT info retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLCargoManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0274Event event = (EsmBkg0274Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<BlCargoManifestOutVO> list = command.searchBLCargoManifestList(event.getInfoVO());
		if(list.size() > 0){
			eventResponse.setETCData("hd_vvd_cd", list.get(0).getHdVvdCd());
			eventResponse.setETCData("hd_pol_pod", list.get(0).getHdPolPod()  );
			eventResponse.setETCData("hd_pol_pod_cd", list.get(0).getHdPolPodCd());
			eventResponse.setETCData("hd_eta_etd", list.get(0).getHdEtaEtd()  );
			eventResponse.setETCData("hd_eta_etd_cd", list.get(0).getHdEtaEtdCd());
			eventResponse.setETCData("hd_mode_type", list.get(0).getHdModeType());
		}
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}

	/**
	 * retrieve event process<br>
	 * 0953  Sort List info retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search0953SortList(Event e) throws EventException {
		
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
		/* Sort */
		List<BkgComboVO> list = command.searchCombo("CD02370");
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}

	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_0174 : C/A Summary Report Result retrieve.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaSummaryReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0174Event event = (EsmBkg0174Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<CaSummaryReportOutVO> list = command.searchCaSummaryReport(event.getCaSummaryReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 	
    
    /**
	 * retrieve event process<br>
	 * ESM_BKG_0174 : C/A Summary Report BL List retrieve.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaSummaryReportBLList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0174Event event = (EsmBkg0174Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<CaSummaryReportOutVO> list = command.searchCaSummaryReportBLList(event.getCaSummaryReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 		
 
    /**
	 * 0985 Queue Detail Return info retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchQueueDetailReturn(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0985Event event = (EsmBkg0985Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocQueueDetailReturnInVO> list = command.searchQueueDetailReturn(event.getInfoVO());
		if(list.size() > 0){
			eventResponse.setETCData("ui_grp_cd",           list.get(0).getUiGrpCd());
			if(JSPUtil.getNull(list.get(0).getUiGrpCd()).equals("")){
				eventResponse.setETCData("return_yn",           "N");        
			}else{
				eventResponse.setETCData("return_yn",           "Y");        
			}
			eventResponse.setETCData("message",				list.get(0).getMessage());        
																										                                  
			eventResponse.setETCData("rsn_bkg_mn_flg",		list.get(0).getRsnBkgMnFlg());    
			eventResponse.setETCData("rsn_cust_info_flg",	list.get(0).getRsnCustInfoFlg()); 
			eventResponse.setETCData("rsn_frt_chg_flg",		list.get(0).getRsnFrtChgFlg());   
			eventResponse.setETCData("rsn_cntr_flg",		list.get(0).getRsnCntrFlg());     
			eventResponse.setETCData("rsn_cntr_mf_flg",		list.get(0).getRsnCntrMfFlg());   
																										                                  
			eventResponse.setETCData("rsn_dcgo_flg",		list.get(0).getRsnDcgoFlg());     
			eventResponse.setETCData("rsn_awk_cgo_flg",		list.get(0).getRsnAwkCgoFlg());   
			eventResponse.setETCData("rsn_rc_flg",			list.get(0).getRsnRcFlg());       
			eventResponse.setETCData("rsn_bb_cgo_flg",		list.get(0).getRsnBbCgoFlg());    
			eventResponse.setETCData("rsn_rly_port_flg",	list.get(0).getRsnRlyPortFlg());  
																										                                  
			eventResponse.setETCData("rsn_new_bkg_flg",		list.get(0).getRsnNewBkgFlg());   
			eventResponse.setETCData("rsn_split_flg",		list.get(0).getRsnSplitFlg());    
			eventResponse.setETCData("rsn_bl_info_flg",		list.get(0).getRsnBlInfoFlg());   
			eventResponse.setETCData("rsn_hbl_flg",			list.get(0).getRsnHblFlg());
			eventResponse.setETCData("cust_verif_flg",		list.get(0).getCustVerifFlg());      
		}else{
			eventResponse.setETCData("return_yn",           "N");
		}
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
	
	/**
	 * 1073 Customer EDI ID Inquiry info retrieve.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchEDIGrpId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg1073Event event = (EsmBkg1073Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchEDIGrpIDVO> list = command.searchEDIGrpId(event.getInfoVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
    
    /**
     * ESM_BKG_1081 : combo list retrieve.<br>
     * Autorating Accuracy monitoring Report retrieve(ESM_BKG_1081)<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode1081(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		
        //Region
        List<BkgComboVO> list1 = command.searchRgnOfficeCd();
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
        //CTRT CODE - CD02565
        List<BkgComboVO> list2 = command.searchCombo("CD02565");
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        return eventResponse;
    }
    
    /**
	 * retrieve event process<br>
	 * ESM_BKG_1081 : Autorating Accuracy monitoring Report retrieve.<br>
	 * 1.Autorating Accuracy Ration<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoratingReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1081Event event = (EsmBkg1081Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<AutoratingReportVO> list = command.searchAutoratingReport(event.getAutoratingReportVO()); 
		eventResponse.setRsVoList(list);
		
		if (list.size() > 0) {
			eventResponse.setETCData(list.get(0).getColumnValues());
			event.getAutoratingReportVO().setSelScpCd(list.get(0).getSvcScpCd());
			event.getAutoratingReportVO().setSelOfcCd(list.get(0).getBkgOfcCd());
			
			event.getAutoratingReportVO().setSvcScpCd(list.get(0).getSvcScpCd());
			event.getAutoratingReportVO().setBkgOfcCd(list.get(0).getBkgOfcCd());
			List<AutoratingReportVO> list2 = command.searchNonAutoratingReport(event.getAutoratingReportVO()); 
			eventResponse.setRsVoList(list2);
		}
		return eventResponse;
	} 
	
	
	/**
	 * retrieve event process<br>
	 * ESM_BKG_1081 : Autorating Accuracy monitoring Report retrieve.<br>
	 * 2.Non Autorating B/L List<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonAutoratingReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1081Event event = (EsmBkg1081Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		event.getAutoratingReportVO().setSvcScpCd(event.getAutoratingReportVO().getSelScpCd());
		event.getAutoratingReportVO().setBkgOfcCd(event.getAutoratingReportVO().getSelOfcCd());
		
		List<AutoratingReportVO> list = command.searchNonAutoratingReport(event.getAutoratingReportVO()); 
		eventResponse.setRsVoList(list);
		return eventResponse;
	} 
    
    /**
	 * retrieve event process<br>
	 * ESM_BKG_1083 : 2 weeks Daily Booking Trend by Customer >>> B/L Detail retrieve.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingTrendReportBLDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1083Event event = null;
		PerformanceReportBC command = null;
		List<SearchBookingTrendReportVO> list = null; 
		try {
			event = (EsmBkg1083Event)e;
			command = new PerformanceReportBCImpl();
			list = command.searchBookingTrendReportBLDetail(event.getSearchBookingTrendReportVO()); 
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	} 
	
	/**
	 * retrieve event process (ESM_BKG_0174)<br>
	 * MultiCombo retrieve result for search condition<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
/*
	private EventResponse searchComCode0174(Event e) throws EventException {
		try{
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// Delivery - conti_cd
			List<BkgComboVO> conti_cd = command.searchComboMdmConti();

			eventResponse.setCustomData("conti_cd", conti_cd);

			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
	}	
*/
    /**
	 * ESM_BKG_0485 : retrieve event process<br>
	 * Special Cargo Manifest information<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialCargoManifestInfo(Event e) throws EventException {
		EsmBkg0485Event event = (EsmBkg0485Event)e;
		SpecialReportBC command = new SpecialReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SpecialCargoManifestInfoVO> list = null;
		list = command.searchSpecialCargoManifestInfo(event.getSpecialCargoManifestInfoVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}	


	/**
	 * EsmBkgChnEdiReceiveEvent :  <br>
	 * Process in respect of EDI reception message .<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadRcvMsg(Event e) throws EventException {
		
		log.info("SC [loadRcvMsg] Start---------------------");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PerformanceReportBC command = new PerformanceReportBCImpl();
		EsmBkgChnEdiReceiveEvent event = (EsmBkgChnEdiReceiveEvent)e;
		try
		{
			begin();
			command.loadRcvMsg(event.getRcvMsg());
			commit();
		}
		catch (EventException ex)
		{
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		
		log.info("SC [loadRcvMsg] End---------------------");
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0619 :  조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOutBdMovementStsList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0619Event event = (EsmBkg0619Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		/*1.Outbound Container Movement Status*/
		List<OutBdMovementStsListInVO> list = command.searchOutBdMovementStsList(event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list);
		/*2.Outbound Container Movement Status by Yard Report*/
		List<OutBdMovementStsYardSumListOutVO> list2 = command.searchOutBdMovementByYardSum(event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list2);
		/*3.Outbound Container Movement Status by Type/Size Report*/
		List<OutBdMovementStsTPSZSumListOutVO> list3 = command.searchOutBdMovementByTPSZSum(event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list3);
		
		return eventResponse;
	}
	
	/**
     * ESM_BKG_0619 : 화면에 대한 로딩시 콤보리스트 조회.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0619(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
		EsmBkg0619Event event = (EsmBkg0619Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        StatusReportBCImpl command2 = new StatusReportBCImpl();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		
    	//RCV_TERM_CD 
        List<BkgComboVO> list = command.searchCombo("CD00764");
//        list.remove(0);
        list.add(0,combovo);
        eventResponse.setRsVoList(list);
        
        //DE_TERM_CD
        List<BkgComboVO> list2 = command.searchCombo("CD00765");
//        list2.remove(0);
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        
        //BKG Status
        List<BkgComboVO> list3 = command.searchCombo("CD00769");
//        list3.remove(0);
        list3.add(0,combovo);
        eventResponse.setRsVoList(list3);
        
        //BKG Kind
        List<BkgComboVO> list4 = command.searchCombo("CD01619");
//        list4.remove(0);
        list4.add(0,combovo);
        eventResponse.setRsVoList(list4);
        
        //Service Mode
       /* List<BkgComboVO> list5 = command.searchCombo("CD01052");
        eventResponse.setRsVoList(list5);*/
        
        //Cargo Type
        List<BkgComboVO> list6 = command.searchCombo("CD00767");
        list6.remove(0);
        list6.add(0,combovo);
        eventResponse.setRsVoList(list6);
        
        //Customer Type
        List<BkgComboVO> list7 = command.searchCombo("CD00880");
        /*list7.remove(0);
        list7.add(0,combovo);*/
        eventResponse.setRsVoList(list7);
        
		//Trade List
		List<SearchTradeListVO> list8 = command2.searchTradeList("tradeSearch",event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list8);
		
		//Sub Trade List
		event.getOutBdMovementStsListInVO().setTrdCd("");
		List<SearchTradeListVO> list9 = command2.searchTradeList("subTradeSearch",event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list9);
		
		//Lane List
		event.getOutBdMovementStsListInVO().setTrdCd("");
		event.getOutBdMovementStsListInVO().setSubTrdCd("");
		List<SearchTradeListVO> list10 = command2.searchTradeList("revLaneSearch",event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list10);
        
        return eventResponse;
    }
	
    /**
	 * 조회 이벤트 처리<br>
	 * performancereport의 event 에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBDRBookingPfmcStatusList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0072Event event = (EsmBkg0072Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BDRBookingStatusListVO> list = command.searchBDRBookingPfmcStatusList(event.getInfoVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	
	/**
	 * ESM_BKG_0214 : 조회 이벤트 처리<br>
	 * Doc Performance Report<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDOCPerformanceReport(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0214Event event = (EsmBkg0214Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocPFMCOfcListVO > list = null;
		List<DocPFMCBLListVO> list2 = null;
		
		/*1.Office List*/
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)){ 
			
			list = command.searchDocPFMCOfcList(event.getDocPFMCOfcListVO());
			eventResponse.setRsVoList(list);
			if (list.size() >0){
				DocPFMCOfcListVO vo = list.get(0);
				event.getDocPFMCBLListVO().setSelBkgOfcCd(vo.getBkgOfcCd());
			}
		}
		/*2.B/L List*/ 
//		if (e.getFormCommand().isCommand(FormCommand.SEARCH01) || (list != null && list.size() > 0)){
		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
			list2 = command.searchDocPFMCBLList(event.getDocPFMCBLListVO());
			eventResponse.setRsVoList(list2);
		}
		return eventResponse;
	
	}
	/**
     * ESM_BKG_0214 : 화면에 대한 콤보리스트 조회.<br>
     * Doc Performance Report<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0214(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		
        //Region
        List<BkgComboVO> list1 = command.searchRgnOfficeCd();
        //list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
        return eventResponse;
    }	
	
    /**
	 *ESM_BKG_0595 : 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFrtSumList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0595Event event = (EsmBkg0595Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<FreightChargeSummaryReportInVO> list = command.searchFrtSumList(event.getFreightChargeSummaryReportInVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	/**
     * ESM_BKG_0595 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0595(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
    	//E/Q Type/Size
    	List<MdmCntrTpSzVO> list = command.searchTypeSize(null);
        eventResponse.setRsVoList(list);
        
        //Freight & Charge Type
        List<BkgComboVO> list2 = command.searchCombo("CD00630");
        eventResponse.setRsVoList(list2);
        
        //Revenue Class
        List<BkgComboVO> list3 = command.searchCombo("CD00628");
        eventResponse.setRsVoList(list3);
          
        return eventResponse;
    }
	
    /**
	 * ESM_BKG_0631 : 조회 이벤트 처리<br>
	 * Revenue Base VVD 조회
     * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchRBCVesselList(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0631Event event = (EsmBkg0631Event) e;
    	
    	String fromDt	= event.getFromDt();
    	String toDt		= event.getToDt();
    	log.debug("fromDt >>>>>> "+ fromDt);
    	log.debug("toDt >>>>>>>> "+ toDt);
    	
    	PerformanceReportBC command = new PerformanceReportBCImpl();
    	List<RbcvesselVO> list = command.searchRBCVesselList(fromDt, toDt);
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();    	
    	eventResponse.setRsVoList(list);
    	
    	return eventResponse;
    }	
    
    /**
     * ESM_BKG_0632 : 화면에 대한 콤보리스트 조회.<br>
     * Sales Performance Report<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0632(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        SpecialReportBC command2 = new SpecialReportBCImpl();
        
        //Booking Cargo Type Code
        List<BkgComboVO> list = command.searchCombo("CD00767");
        eventResponse.setRsVoList(list);
        
        //Sales Performance Report Kind Code
        List<BkgComboVO> list2 = command.searchCombo("CD02287");
        eventResponse.setRsVoList(list2);
        
        //Sales Performance Group By Code
        List<BkgComboVO> list3 = command.searchCombo("CD02288");
        eventResponse.setRsVoList(list3);
        
        //Service Mode Code
        List<BkgComboVO> list4 = command.searchCombo("CD02149");
        eventResponse.setRsVoList(list4);
        
        BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("ALL CONTINENT");
		combovo.setVal("");
        
        //Service Route 
		list = command2.searchScontiCd();
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
        
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0632 : Sales Performance Report 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchSalesPerformanceReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0632Event event = (EsmBkg0632Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		List<SaelsPerformanceReportOutVO> list = command.searchSalesPerformanceReport(event.getSaelsPerformanceReportInVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0632 : (Sales Performance Report) VVD에 해당하는 Lane 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchVVDByLane(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0632Event event = (EsmBkg0632Event)e;
		BookingUtil command = new BookingUtil();
		
		String lane = "none";
		String vvd  = event.getSaelsPerformanceReportInVO().getVvdSig();
		
		if (command.validateVvd(vvd.substring(0, 4), vvd.substring(4, 8), vvd.substring(8))){
			
			lane = command.searchSvcLaneByVvd(vvd);
		}
		
		eventResponse.setETCData("lane", lane);
		return eventResponse;
	}  
      
    /**
 	 * 조회 이벤트 처리<br>
 	 * ESM_BKG_0746 : Vessel Utilization Status vs. Bsa by Lane 에 Trade Code 를 조회합니다.<br>
 	 * 
 	 * @param  Event e
 	 * @return    EventResponse
 	 * @exception EventException
 	 */
 	private EventResponse searchVesselUtilizationTrade(Event e) throws EventException {

 		GeneralEventResponse eventResponse = new GeneralEventResponse();
 		EsmBkg0746Event event = (EsmBkg0746Event)e;
 		PerformanceReportBC command = new PerformanceReportBCImpl();

 		List<VesselUtilizationStatusReportInVO> list = command.searchVesselUtilizationTrade(event.getVesselUtilizationStatusReportInVO()); 

 		eventResponse.setRsVoList(list);
 		
 		return eventResponse;
 	} 	
     
     /**
 	 * 조회 이벤트 처리<br>
 	 * ESM_BKG_0746 : Vessel Utilization Status vs. Bsa by Lane 에 Sub Trade Code 를 조회합니다.<br>
 	 * 
 	 * @param  Event e
 	 * @return    EventResponse
 	 * @exception EventException
 	 */
 	private EventResponse searchVesselUtilizationSubTrade(Event e) throws EventException {

 		GeneralEventResponse eventResponse = new GeneralEventResponse();
 		EsmBkg0746Event event = (EsmBkg0746Event)e;
 		PerformanceReportBC command = new PerformanceReportBCImpl();

 		List<VesselUtilizationStatusReportInVO> list = command.searchVesselUtilizationSubTrade(event.getVesselUtilizationStatusReportInVO()); 

 		eventResponse.setRsVoList(list);
 		
 		return eventResponse;
 	} 		
     
     /**
 	 * 조회 이벤트 처리<br>
 	 * ESM_BKG_0746 : Vessel Utilization Status vs. Bsa by Lane 에 Bound Code 를 조회합니다.<br>
 	 * 
 	 * @param  Event e
 	 * @return    EventResponse
 	 * @exception EventException
 	 */
 	private EventResponse searchVesselUtilizationBound(Event e) throws EventException {

 		GeneralEventResponse eventResponse = new GeneralEventResponse();
 		EsmBkg0746Event event = (EsmBkg0746Event)e;
 		PerformanceReportBC command = new PerformanceReportBCImpl();

 		List<VesselUtilizationStatusReportInVO> list = command.searchVesselUtilizationBound(event.getVesselUtilizationStatusReportInVO()); 

 		eventResponse.setRsVoList(list);
 		
 		return eventResponse;
 	} 		
     
     /**
 	 * 조회 이벤트 처리<br>
 	 * ESM_BKG_0746 : Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다.<br>
 	 * 
 	 * @param  Event e
 	 * @return    EventResponse
 	 * @exception EventException
 	 */
 	private EventResponse searchVesselUtilizationStatusReport(Event e) throws EventException {

 		GeneralEventResponse eventResponse = new GeneralEventResponse();
 		EsmBkg0746Event event = (EsmBkg0746Event)e;
 		PerformanceReportBC command = new PerformanceReportBCImpl();

 		List<VesselUtilizationStatusReportOutVO> list = command.searchVesselUtilizationStatusReport(event.getVesselUtilizationStatusReportInVO()); 

 		eventResponse.setRsVoList(list);
 		
 		String max_port_seq = "";
 		
 		if (list.size() > 0) max_port_seq = list.get(0).getMaxPortSeq();
 		
 		eventResponse.setETCData("max_port_seq",max_port_seq);
 		
 		return eventResponse;
 	} 		   	
 	
    /**
 	 * 조회 이벤트 처리<br>
 	 * 0940 I/B DOC Performance Report 정보를 조회합니다.<br>
 	 * 
 	 * @param  Event e
 	 * @return EventResponse
 	 * @exception EventException
 	 */
 	private EventResponse searchInBoundPfmcReport(Event e) throws EventException {
 		// PDTO(Data Transfer Object including Parameters)
 		EsmBkg0940Event event = (EsmBkg0940Event)e;
 		PerformanceReportBC command = new PerformanceReportBCImpl();
 		GeneralEventResponse eventResponse = new GeneralEventResponse();
 		
 		List<InBoundReportOutVO> list = command.searchInBoundPfmcReport(event.getInfoVO());
 		eventResponse.setRsVoList(list);
 		
 		return eventResponse;		
 	} 	
 	
	 /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1057 : Freight & Charge List by VVD 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
   private EventResponse searchFCLList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1057Event event = (EsmBkg1057Event)e;
//		String vvdChk = event.getSearchFCLListVO().getVvdChk();
		PerformanceReportBC command = new PerformanceReportBCImpl();
		List<SearchFCLListVO> list = command.searchFCLList(event.getSearchFCLListVO());
		
		eventResponse.setRsVoList(list);
		
		List<SearchFCLListVO> list2 = command.searchFCLList(event.getSearchFCLListVO());
		for (int i = 0; i <list2.size(); i++){
			list2.get(i).setSplFlg("F");
		}
			eventResponse.setRsVoList(list2);

		return eventResponse;
	} 	
   
	/**
	 * 조회 이벤트 처리<br>
	 * 0625 Report template(Default, Detail, User Set) 을 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustVipReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0625Event event = (EsmBkg0625Event)e;
		StatusReportBC command = new StatusReportBCImpl();

		try{
			List<CustVipReportOutVO> list = command.searchCustVipReport(event.getInfoVO());
			if(list.size() > 0){
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			}
			
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		

		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_1110 :  조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOutBdEirMovementStatusList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg1110Event event = (EsmBkg1110Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<OutBdEirMovementStatusListVO> list = command.searchOutBdEirMovementStatusList(event.getOutBdEirMovementStatusListVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}		
	
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1143 : C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrossCheckList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1143Event event = (EsmBkg1143Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<BkgCroChkListByBLVO> list = command.searchCrossCheckList(event.getBkgCroChkListinVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 	
	
	/**
	 * retrieve event process<br>
	 * 1701 Booking Container Report retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBokCntrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1701Event event = (EsmBkg1701Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		
		try{
			List<BokCntrListOutVO> list = command.searchBokCntrList(event.getInfoVO());
			if(list.size() > 0){
				eventResponse.setETCData("ttl_bkg", list.get(0).getTotalBkg());
				eventResponse.setETCData("ttl_cntr", list.get(0).getTotalCntr());
				eventResponse.setETCData("ttl_pck", list.get(0).getTtlPckQty());
				eventResponse.setETCData("ttl_teu", list.get(0).getTtlTeu());
				eventResponse.setETCData("ttl_feu", list.get(0).getTtlFeu());
				eventResponse.setETCData("ttl_grs_kg", list.get(0).getTtlGrsWgtKg());
				eventResponse.setETCData("ttl_grs_lb", list.get(0).getTtlGrsWgtLb());
				eventResponse.setETCData("ttl_tare_kg", list.get(0).getTtlTareWgtKg());
				eventResponse.setETCData("ttl_tare_lb", list.get(0).getTtlTareWgtLb());
				eventResponse.setETCData("ttl_cgo_kg", list.get(0).getTtlCgoWgtKg());
				eventResponse.setETCData("ttl_cgo_lb", list.get(0).getTtlCgoWgtLb());
			}
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1702 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20150112.ADD
	 */
	private EventResponse searchComBoCdList1702(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1702Event event = (EsmBkg1702Event)e;						//SJH.20150203.MOD

		BookingUtil command = new BookingUtil();
		SpecialReportBC comm_sp = new SpecialReportBCImpl();
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setVal("");
		combovo.setName("");	
		
		/* 0. Report Type List */		
		event.getrInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = comm_sp.searchReportTemplateBstVipList(event.getrInfoVO());
		eventResponse.setRsVoList(rlist);			
		
		/* 1. Dir */
		List<BkgComboVO> list = command.searchCombo("CD00714");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* 2. r_term : R/D Term R- OUTBOUND RECEIVED */
		list = command.searchCombo("CD00764");
		eventResponse.setRsVoList(list);
		
		/* 3. d_term : R/D Term D- INBOUND DELIVERY */
		list = command.searchCombo("CD00765");
		eventResponse.setRsVoList(list);
		
		/* 4. cargo release status */
		list = command.searchCombo("CD30016");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* 5. carrier */
		List<MdmCarrierVO> crrlist = command.searchCarrier(null);
		MdmCarrierVO crrvo = new MdmCarrierVO();
		crrvo.setCrrCd("");
		crrvo.setCrrNm("All");
		crrlist.add(0,crrvo);
		eventResponse.setRsVoList(crrlist);
		
		/* 6. bl status */
		list = command.searchCombo("CD30013");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* 7. bl type */
		list = command.searchCombo("CD30014");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* 8. CUSTOMER TYPE */
		list = command.searchCombo("CD00704");
		eventResponse.setRsVoList(list);	
			
		return eventResponse;			
	}	
	
	/**
	 * retrieve event process<br>
	 * 0103 Booking Status Report retrieve.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLCntrInfoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1702Event event = (EsmBkg1702Event)e;
		StatusReportBC command = new StatusReportBCImpl();		

		List<BlCntrInfoReportOutVO> list = command.searchBLCntrInfoList(event.getInfoVO());		
		eventResponse.setRsVoList(list);
		if(list.size() > 0){
			eventResponse.setETCData("cnt_bkg", list.get(0).getCntBkg());
			eventResponse.setETCData("sum_wgt_ton", list.get(0).getSumWgtTon());
			eventResponse.setETCData("sum_grs_mea_cbm", list.get(0).getSumGrsMeaCbm());
			eventResponse.setETCData("cnt_bl", list.get(0).getCntBl());
			eventResponse.setETCData("sum_cct_amt", list.get(0).getSumCctAmt());
			eventResponse.setETCData("sum_grs_wgt_kgs", list.get(0).getSumGrsWgtKgs());
			eventResponse.setETCData("cnt_cntr", list.get(0).getCntCntr());		
			eventResponse.setETCData("sum_ppd_amt", list.get(0).getSumPpdAmt());
			eventResponse.setETCData("sum_net_wgt_kgs", list.get(0).getSumNetWgtKgs());
			eventResponse.setETCData("sum_net_mea_cbm", list.get(0).getSumNetMeaCbm());
			eventResponse.setETCData("cnt_pck", list.get(0).getCntPck());
			eventResponse.setETCData("sum_wgt_lbs", list.get(0).getSumWgtLbs());
		}		
		return eventResponse;
	}		
	
	/**
	 * ESM_BKG_1701: Retrieving Booking Container Report Data and directly Downloading as Excel Format<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBokCntrDownExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1701Event event = (EsmBkg1701Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		
		List<Object> oList = null;
		
		try{
			oList = command.searchBokCntrDownExcel(event.getInfoVO());					
			
			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", "ESM_BKG_1701DL.xls");
			eventResponse.setCustomData("isZip", false);

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
	 * ESM_BKG_1703 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20150130.ADD
	 */
	private EventResponse searchComBoCdList1703(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1703Event event = (EsmBkg1703Event)e;
		BookingUtil command = new BookingUtil();
		SpecialReportBC comm_sp = new SpecialReportBCImpl();
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setVal("");
		combovo.setName("");
		
		/* 0. Report Type List */		
		event.getrInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = comm_sp.searchReportTemplateBstVipList(event.getrInfoVO());
		eventResponse.setRsVoList(rlist);
		
		/* 1. Dir */
		List<BkgComboVO> list = command.searchCombo("CD00714");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* 2. r_term : R/D Term R- OUTBOUND RECEIVED */
		list = command.searchCombo("CD00764");
		eventResponse.setRsVoList(list);
		
		/* 3. d_term : R/D Term D- INBOUND DELIVERY */
		list = command.searchCombo("CD00765");
		eventResponse.setRsVoList(list);
		
		/* 4. cargo type */
		list = command.searchCombo("CD00767");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* 5. eq type/size */
    	List<MdmCntrTpSzVO> eqlist = command.searchTypeSize(null);
        eventResponse.setRsVoList(eqlist);		
		
		/* 6. bkg status */
		list = command.searchCombo("CD00769");
		eventResponse.setRsVoList(list);
			
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1704 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20150202.ADD
	 */
	private EventResponse searchComBoCdList1704(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1704Event event = (EsmBkg1704Event)e;

		BookingUtil command = new BookingUtil();
		SpecialReportBC comm_sp = new SpecialReportBCImpl();
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setVal("");
		combovo.setName("");	
		
		/* 0. Report Type List */		
		event.getrInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = comm_sp.searchReportTemplateBstVipList(event.getrInfoVO());
		eventResponse.setRsVoList(rlist);			
		
		/* 1. Dir */
		List<BkgComboVO> list = command.searchCombo("CD00714");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* 2. r_term : R/D Term R- OUTBOUND RECEIVED */
		list = command.searchCombo("CD00764");
		eventResponse.setRsVoList(list);
		
		/* 3. d_term : R/D Term D- INBOUND DELIVERY */
		list = command.searchCombo("CD00765");
		eventResponse.setRsVoList(list);
		
		/* 4. DELIVERY Mode */
		list = command.searchCombo("CD02455");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
			
		return eventResponse;	
	}
	
	/**
	 * ESM_BKG_1705 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20150203.ADD
	 */
	private EventResponse searchComBoCdList1705(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1705Event event = (EsmBkg1705Event)e;

		BookingUtil command = new BookingUtil();
		SpecialReportBC comm_sp = new SpecialReportBCImpl();
		StatusReportBCImpl comm_trd = new StatusReportBCImpl();
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setVal("");
		combovo.setName("");	
		
		/* 0. Report Type List */		
		event.getrInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = comm_sp.searchReportTemplateBstVipList(event.getrInfoVO());
		eventResponse.setRsVoList(rlist);		
		
		if(e.getFormCommand().isCommand(FormCommand.INIT)) {
			/* 1. r_term : R/D Term R- OUTBOUND RECEIVED */
			List<BkgComboVO> list = command.searchCombo("CD00764");
			eventResponse.setRsVoList(list);
			
			/* 2. d_term : R/D Term D- INBOUND DELIVERY */
			list = command.searchCombo("CD00765");
			eventResponse.setRsVoList(list);
			
			/* 3. Bound = Dir  */
			list = command.searchCombo("CD00714");
			eventResponse.setRsVoList(list);
			
			/* 4. Trade */		
			List<SearchTradeListVO> list_trd = comm_trd.searchTradeList("tradeSearch",event.getOutBdMovementStsListInVO());
			eventResponse.setRsVoList(list_trd);
			
			/* 5. Sub Trade */
			event.getOutBdMovementStsListInVO().setTrdCd("");
			list_trd = comm_trd.searchTradeList("subTradeSearch",event.getOutBdMovementStsListInVO());
			eventResponse.setRsVoList(list_trd);
			
			/* 6. Lane */
//			event.getOutBdMovementStsListInVO().setTrdCd("");
//			event.getOutBdMovementStsListInVO().setSubTrdCd("");
//			list_trd = comm_trd.searchTradeList("revLaneSearch",event.getOutBdMovementStsListInVO());
//			eventResponse.setRsVoList(list_trd);			
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1706 : Common code Handling the inquiry event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20150202.ADD
	 */
	private EventResponse searchComBoCdList1706(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil command = new BookingUtil();
		SpecialReportBC comm_sp = new SpecialReportBCImpl();
		StatusReportBCImpl comm_trd = new StatusReportBCImpl();
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setVal("");
		combovo.setName("");	
		
		/* 0. Report Type List */
		EsmBkg1706Event event = (EsmBkg1706Event)e;
		event.getrInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = comm_sp.searchReportTemplateBstVipList(event.getrInfoVO());
		eventResponse.setRsVoList(rlist);		
		
		/* 1. Trade */		
		List<SearchTradeListVO> list_trd = comm_trd.searchTradeList("tradeSearch",event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list_trd);		
		
		/* 2. Freight & Charge Type */
        List<BkgComboVO> list = command.searchCombo("CD00630");
        eventResponse.setRsVoList(list);
			
		return eventResponse;	
	}	
		
	
	/**
	 * ESM_BKG_1703 ~ ESM_BKG_1706: Report Data and directly Downloading as Excel Format<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author SJH.20150130.ADD
	 */
	private EventResponse searchCmBkgRptDownExcel(Event e, String rptId) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StatusReportBC command = new StatusReportBCImpl();
		
		List<Object> oList = new ArrayList<Object>();
		String fileName = "";
		
		try{
			if(rptId.equals("1702")) {
				EsmBkg1702Event event1702 = (EsmBkg1702Event)e;				
				oList = command.searchCmBkgRptDownExcel(event1702.getInfoVO(), rptId);
				fileName = "ESM_BKG_1702DL.xls";
			} else if(rptId.equals("1703")) {
				EsmBkg1703Event event1703 = (EsmBkg1703Event)e;
				oList = command.searchCmBkgRptDownExcel(event1703.getInfoVO(), rptId);
				fileName = "ESM_BKG_1703DL.xls";
			} else if(rptId.equals("1704")) {
				EsmBkg1704Event event1704 = (EsmBkg1704Event)e; 
				oList = command.searchCmBkgRptDownExcel(event1704.getInfoVO(), rptId);
				fileName = "ESM_BKG_1704DL.xls";
			} else if(rptId.equals("1705")) {
				EsmBkg1705Event event1705 = (EsmBkg1705Event)e; 
				oList = command.searchCmBkgRptDownExcel(event1705.getInfoVO(), rptId);
				if(event1705.getInfoVO().getPBkgRptKndCd().equals("G")) {
					fileName = "ESM_BKG_1705DGDL.xls";
				} else if(event1705.getInfoVO().getPBkgRptKndCd().equals("R")) {
					fileName = "ESM_BKG_1705RFDL.xls";
				} else if(event1705.getInfoVO().getPBkgRptKndCd().equals("A")) {
					fileName = "ESM_BKG_1705AKDL.xls";
				} else if(event1705.getInfoVO().getPBkgRptKndCd().equals("S")) {
					fileName = "ESM_BKG_1705BBDL.xls";
				} else if(event1705.getInfoVO().getPBkgRptKndCd().equals("H")) {
					fileName = "ESM_BKG_1705HGDL.xls";
				} else {
					fileName = "ESM_BKG_1705DL.xls";
				}
			} else if(rptId.equals("1706")) {
				EsmBkg1706Event event1706 = (EsmBkg1706Event)e; 
				oList = command.searchCmBkgRptDownExcel(event1706.getInfoVO(), rptId);
				fileName = "ESM_BKG_1706DL.xls";				
			}			
			eventResponse.setCustomData("rowset", (DBRowSet)oList.get(0));
			eventResponse.setCustomData("title", (String[])oList.get(1));
			eventResponse.setCustomData("columns", (String[])oList.get(2));
			eventResponse.setCustomData("fileName", fileName);
			eventResponse.setCustomData("isZip", false);

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
	 * ESM_BKG_0068 : combo event process.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0168(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		
       
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		RASCommonBC command1 = new RASCommonBCImpl();
		RsltContiListVO contiVo = null;
		List<RsltContiListVO> contiData = null;
		
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("All");
		combovo.setName("All");
		
		/*R/D R- OUTBOUND RECEIVED*/
		List<BkgComboVO> list = command.searchCombo("CD00764");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		
		/*R/D D- INBOUND DELIVERY*/
		list = command.searchCombo("CD00765");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*CUSTOMER TYPE*/
		list = command.searchCombo("CD00880");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
	
        contiVo = new RsltContiListVO();
        contiData = command1.seacrhRasContiList(contiVo);
        eventResponse.setRsVoList(contiData);
        //eventResponse.setCustomData("contiCd", contiData);
		
		return eventResponse;
		
	}
	/**
	 * ESM_BKG_0168 : VGM Dashboard<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVgmList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0168Event event = (EsmBkg0168Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<VgmDashboardVO> list = command.searchVgmDashboardList(event.getInfoVO());
		
//		if(list.size() > 0){
//			list.get(0).setMaxRows(list.get(0).getMaxRows());
//			VgmDashboardVO vo =  list.get(0);
//			eventResponse.setETCData("ttl_bkg",      vo.getTtlBkg());
//			eventResponse.setETCData("ttl_qty_f",    vo.getTtlQtyF());
//			eventResponse.setETCData("ttl_qty_t",    vo.getTtlQtyT());
//			eventResponse.setETCData("ttl_vgm",    vo.getTtlVgm());
//			eventResponse.setETCData("ttl_non_vgm", vo.getTtlNonVgm());
//			eventResponse.setETCData("ttl_non_rcvd_vgm", vo.getTtlNonRcvdVgm());
//			eventResponse.setETCData("ttl_clz_bkg", vo.getTtlClzBkg());
//			eventResponse.setETCData("srch_mlt_bkg", vo.getSrchMltBkg());
//		}
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
	/**
	 * ESM_BKG_0168 : VGM Dashboard<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageVgmDashboard(Event e) throws EventException {
    	EsmBkg0168Event event = (EsmBkg0168Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		StatusReportBC command = new StatusReportBCImpl();
    	
        try {
            begin();
            command.manageVgmDashboard(event.getInfoVOs());
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }
	/**
	 * ESM_BKG_0168 : VGM Dashboard<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCllCdlRdParam(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0168Event event = (EsmBkg0168Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<CllCdlVslSumForRDVO> list = command.searchCllCdlRdParam(event.getInfoVO());
		
		if(list.size() > 0){
			list.get(0).setMaxRows(list.get(0).getMaxRows());
			CllCdlVslSumForRDVO vo =  list.get(0);
			eventResponse.setETCData("un_loc_cd",      vo.getUnLocCd());
			eventResponse.setETCData("vps_eta_dt",      vo.getVpsEtaDt());
			eventResponse.setETCData("vps_etd_dt",      vo.getVpsEtdDt());
			eventResponse.setETCData("vps_etb_dt",      vo.getVpsEtbDt());
			eventResponse.setETCData("cssm_vvd",      vo.getCssmVvd());
			eventResponse.setETCData("d2",      vo.getD2());
			eventResponse.setETCData("d4",      vo.getD4());
			eventResponse.setETCData("d5",      vo.getD5());
			eventResponse.setETCData("d7",      vo.getD7());
			eventResponse.setETCData("d8",      vo.getD8());
			eventResponse.setETCData("d9",      vo.getD9());
			eventResponse.setETCData("dw",      vo.getDw());
			eventResponse.setETCData("dx",      vo.getDx());
			eventResponse.setETCData("r2",      vo.getR2());
			eventResponse.setETCData("r4",      vo.getR4());
			eventResponse.setETCData("r5",      vo.getR5());
			eventResponse.setETCData("f2",      vo.getF2());
			eventResponse.setETCData("f4",      vo.getF4());
			eventResponse.setETCData("f5",      vo.getF5());
			eventResponse.setETCData("o2",      vo.getO2());
			eventResponse.setETCData("o4",      vo.getO4());
			eventResponse.setETCData("o5",      vo.getO5());
			eventResponse.setETCData("s2",      vo.getS2());
			eventResponse.setETCData("s4",      vo.getS4());
			eventResponse.setETCData("t2",      vo.getT2());
			eventResponse.setETCData("t4",      vo.getT4());
			eventResponse.setETCData("a2",      vo.getA2());
			eventResponse.setETCData("a4",      vo.getA4());
			eventResponse.setETCData("p2",      vo.getP2());
			eventResponse.setETCData("p4",      vo.getP4());
			eventResponse.setETCData("z2",      vo.getZ2());
			eventResponse.setETCData("z4",      vo.getZ4());
			eventResponse.setETCData("t20",      vo.getT20());
			eventResponse.setETCData("t40",      vo.getT40());
			eventResponse.setETCData("wgt",      vo.getWgt());
			eventResponse.setETCData("mea",      vo.getMea());
			eventResponse.setETCData("e_wgt",      vo.getEWgt());
			eventResponse.setETCData("lcl",      vo.getLcl());
			eventResponse.setETCData("ts",      vo.getTs());
			eventResponse.setETCData("ttl",      vo.getTtl());
		}
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0169 : VGM History<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVgmHistory(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0169Event event = (EsmBkg0169Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<VgmHistoryVO> list = command.searchVgmHistory(event.getVgmHistoryVO());
		
		if(list.size() > 0){
			list.get(0).setMaxRows(list.get(0).getMaxRows());
//			VgmHistoryVO vo =  list.get(0);
		}
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
	/**
	 * ESM_BKG_0168 : VGM Dashboard<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse manageVgmClz(Event e) throws EventException {
    	EsmBkg0168Event event = (EsmBkg0168Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	StatusReportBC command = new StatusReportBCImpl();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		EBookingReceiptBC ebkgRcBc = new EBookingReceiptBCImpl();
		GeneralBookingReceiptBC bkgRcBc = new GeneralBookingReceiptBCImpl();
		BookingUtil bookingUtil = new BookingUtil();
		GeneralBookingSearchBC bkgScBc = new GeneralBookingSearchBCImpl();
//		int vgmClzCnt = 0;
    	
        try {
            begin();
            String saveFlg = event.getSaveFlg();
            BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();   
            VgmDashboardVO[] vgmDashboardVOs = event.getInfoVOs();
            List<String> bkgNos = new ArrayList<String>();
            String bkgNo = "";
            
            for(int i=0; i < vgmDashboardVOs.length ; i++){
            	VgmDashboardVO vgmDashboardVO =  vgmDashboardVOs[i];
				if ("1".equalsIgnoreCase(vgmDashboardVO.getCheck() ) && !"".equalsIgnoreCase(vgmDashboardVO.getXterVgmWgt()) ) {
//					 Check whether container of booking has VGM or not by booking. 
//					String vgmClzYn = command.checkBkgForVgmClz(vgmDashboardVO.getBkgNo());
//					if("N".equals(vgmClzYn) && "Y".equals(vgmDashboardVO.getVgmClzFlg())){
//						 throw new EventException(new ErrorHandler("BKG08349", new String[]{vgmDashboardVO.getBkgNo()}).getMessage());
//					}
					
					vgmDashboardVO.setVgmWgtUpdUsrId(account.getUsr_id());
					command.manageVgmClz(vgmDashboardVO, saveFlg);
					eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
					
					BkgVgmWgtVO bkgVgmWgtVO = new BkgVgmWgtVO();
					bkgVgmWgtVO.setBkgNo(vgmDashboardVO.getBkgNo());
					bkgVgmWgtVO.setCntrNo(vgmDashboardVO.getCntrNo());
					bkgVgmWgtVO.setVgmSeq(vgmDashboardVO.getVgmSeq());
					bkgVgmWgtVO.setUsrId(account.getUsr_id());
					if("WEB".equals(vgmDashboardVO.getXterSndrId())){
			    		bkgVgmWgtVO.setIfFlg("Y");
			    		bkgVgmWgtVO.setUpldFlg("Y");
			    		ebkgRcBc.modifyBkgVgmUpld(bkgVgmWgtVO, account);
					}else{
						bkgVgmWgtVO.setXterSndrId(vgmDashboardVO.getXterSndrId());
						bkgVgmWgtVO.setXterVgmDocId(vgmDashboardVO.getXterVgmDocId());
						bkgVgmWgtVO.setXterVgmRqstSeq(vgmDashboardVO.getXterVgmRqstSeq());
		    			bkgVgmWgtVO.setVgmUpldStsCd("Y");
		    			ebkgRcBc.modifyBkgXterVgmRqstUpld(bkgVgmWgtVO, account);
					}
		    		bkgNo = vgmDashboardVO.getBkgNo();
					
					// Manage Export MRN when POL = GB
					String polCd = vgmDashboardVO.getPolCd();
					String refId = vgmDashboardVO.getRefId();
		    		if("GB".equals(polCd.substring(0, 2)) && !"".equals(refId)){
		    			BkgReferenceVO[] bkgReferenceVOs = new BkgReferenceVO[9];
		    			
		    			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		    			bkgBlNoVO.setBkgNo(bkgNo);
		    			bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoVO);

		    			List<RefNoVO> list = bkgScBc.searchBkgReference(bkgBlNoVO);
		    			for(int x=0 ; x < list.size() ; x++){
		    				BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
			    			String bkgRefTpCd = list.get(x).getBkgRefTpCd();
			    			String custRefNoCtnt = list.get(x).getCustRefNoCtnt();
			    			String refSeq = list.get(x).getRefSeq();
			    			
			    			bkgReferenceVO.setBkgNo(bkgNo);
			    			bkgReferenceVO.setBkgRefTpCd(bkgRefTpCd);
			    			if("XMRN".equals(bkgRefTpCd) && !"".equals(refId)){
			    				bkgReferenceVO.setCustRefNoCtnt(refId);
			    			}else{
			    				bkgReferenceVO.setCustRefNoCtnt(custRefNoCtnt);
			    			}
			    			if(!"".equals(refSeq)){
			    				bkgReferenceVO.setRefSeq(refSeq);
			    			}
			    			bkgReferenceVOs[x] = bkgReferenceVO;
		    			}
		    			bkgRcBc.manageRefNo(bkgReferenceVOs, account, bkgBlNoVO);
		    		}
		    		

		            int cnt = 0;
		    		
		    		for(int j=0 ; j <bkgNos.size(); j++){
		    			if(bkgNo.equals(bkgNos.get(j)) ){
		    				cnt++;
		    			}
		    		}
		    		if(cnt==0){
		    			bkgVgmWgtVO.setXterVgmRqstCd(vgmDashboardVO.getVgmVia());
		    			bkgRcBc.modifyBkgVgmWgt(bkgVgmWgtVO, account);
		    			
			    		if("Y".equals(vgmDashboardVO.getVgmClzFlg())){
							docProcSkdVO.setBkgNo(vgmDashboardVO.getBkgNo());
							docProcSkdVO.setBkgDocProcTpCd("VGMCLZ");
		                
							bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
							bkgNos.add(vgmDashboardVO.getBkgNo());
			    		}
		    		}
//					vgmClzCnt++;
				}
            }
//            if(vgmClzCnt != vgmDashboardVOs.length){
//            	
//            }

            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_0169 : VGM History<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVgmEdiSup(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0171Event event = (EsmBkg0171Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<VgmEdiSupVO> list = command.searchVgmEdiSup(event.getVgmEdiSupVO());
		
		if(list.size() > 0){
			list.get(0).setMaxRows(list.get(0).getMaxRows());
//			VgmHistoryVO vo =  list.get(0);
		}
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
	/**
	 * ESM_BKG_0171 : VGM EDI send<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendVgmEdi(Event e) throws EventException{
		try{
			EsmBkg0171Event event = (EsmBkg0171Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			boolean isSend = false;
			log.debug("ntc knd cd:[" + event.getNtcKndCd() + "], rcv_id :["+event.getEdiReceiveId()+"]");
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			String bkgNo = event.getBkgNo();
			String hisUiNm = "ESM_BKG_0171";
			String rcvId = event.getEdiReceiveId();
			String sndrId = event.getEdiSndId();
			String refCode = event.getRefCode();
			String ediKnd = event.getNtcKndCd();
			
			// Manual 301 EDI
			if("3C".equals(ediKnd) || "3P".equals(ediKnd) || "3M".equals(ediKnd)){
				BkgNtcHisVO bkgNtcHisVO=command.createTmlBkgReceiptEdi(bkgNo, hisUiNm, rcvId, sndrId, refCode, ediKnd, account);
				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				if(bkgNtcHisVO!=null){
					bkgNtcHisVOs.add(bkgNtcHisVO);
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0171");
				    isSend = true;
				}
			}
			
			// Manual VERMAS EDI
			if("VC".equals(ediKnd) || "VP".equals(ediKnd) || "VT".equals(ediKnd) || "VM".equals(ediKnd)){
				String cntrNos = event.getCntrNos();
				String[] cntrNoForVermas = cntrNos.split(",");
				for(int i=0; i<cntrNoForVermas.length; i++){
					String cntrNo = cntrNoForVermas[i];
					cntrNo = cntrNo.substring(1,12);
					BkgNtcHisVO bkgNtcHisVO =command.createVermasBkgReceiptEdi(bkgNo, rcvId, sndrId, refCode, ediKnd, cntrNo, account);
					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					
					if(bkgNtcHisVO!=null){
						bkgNtcHisVOs.add(bkgNtcHisVO);
						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0171");
					    isSend = true;
					}
				}
			}
			
			if(isSend==false){
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
			return eventResponse;
		} catch(EventException se) {
			rollback();
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0172 : VGM EDI (MULTI)<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVgmEdiSupMlt(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0172Event event = (EsmBkg0172Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<VgmEdiSupVO> list1 = command.searchVgmEdiMltList(event.getVgmEdiSupVO());
		
		List<VgmEdiSupVO> list2 = command.searchVgmEdiSupMlt(event.getVgmEdiSupVO());
		
		eventResponse.setRsVoList(list1);
		eventResponse.setRsVoList(list2);

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0172 : VGM EDI MULTI send<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendVgmEdiMlt(Event e) throws EventException{
		try{
			EsmBkg0172Event event = (EsmBkg0172Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			boolean isSend = false;
			log.debug("ntc knd cd:[" + event.getNtcKndCd() + "], rcv_id :["+event.getEdiReceiveId()+"]");
			List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
			VgmEdiSupVO[] vgmEdiSupVOs = event.getVgmEdiSupVOS();
			String hisUiNm = "ESM_BKG_0172";
			String rcvId = event.getEdiReceiveId();
			String sndrId = event.getEdiSndId();
			String refCode = event.getRefCode();
			String ediKnd = event.getNtcKndCd();
			for(int i=0; i<vgmEdiSupVOs.length ; i++){
				String bkgNo = vgmEdiSupVOs[i].getBkgNo();
				String cntrNo = vgmEdiSupVOs[i].getCntrNo();
				String bkgOrd = vgmEdiSupVOs[i].getBkgOrd();
				// Manual 301 EDI
				if(("3C".equals(ediKnd) || "3P".equals(ediKnd) || "3M".equals(ediKnd)) && "1".equals(bkgOrd)){
					BkgNtcHisVO bkgNtcHisVO=command.createTmlBkgReceiptEdi(bkgNo, hisUiNm, rcvId, sndrId, refCode, ediKnd, account);
					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					if(bkgNtcHisVO!=null){
						bkgNtcHisVOs.add(bkgNtcHisVO);
						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0171");
					    isSend = true;
					}
				}
				
				// Manual VERMAS EDI
				if("VC".equals(ediKnd) || "VP".equals(ediKnd) || "VT".equals(ediKnd) || "VM".equals(ediKnd)){
					BkgNtcHisVO bkgNtcHisVO =command.createVermasBkgReceiptEdi(bkgNo, rcvId, sndrId, refCode, ediKnd, cntrNo, account);
					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					
					if(bkgNtcHisVO!=null){
						bkgNtcHisVOs.add(bkgNtcHisVO);
						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0171");
					    isSend = true;
					}
				}
		
			}
		
			if(isSend==false){
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
			return eventResponse;
		} catch(EventException se) {
			rollback();
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
}

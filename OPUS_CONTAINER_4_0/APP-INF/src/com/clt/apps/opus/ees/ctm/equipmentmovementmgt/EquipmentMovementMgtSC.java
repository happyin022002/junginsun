/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EquipmentMovementMgtSC.java
 *@FileTitle : EquipmentMovementMgtSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBCImpl;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.basic.MgsetMovementHistoryBC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.basic.MgsetMovementHistoryBCImpl;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBC;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.ContainerMovementFinderBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.ContainerMovementFinderBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.LongTxContainerMovementFinderBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.basic.LongTxContainerMovementFinderBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0405Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0408Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0409Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0411Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0412Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0413Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0415Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0417Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0418Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0419Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0420Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0443Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0460Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0470Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0471Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0472Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0473Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.ConCBookingVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmCCLMVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmMvmtIrrVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.CtmVvdHistoryVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.MovementEDIReportVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllEQRRefVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllVVDByBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIErrorVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEDIResultVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEdiMsgVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchEmptyBookingListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByBkgInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByCntrTpszCdVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByEqrRefInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListBySplitBkgNoForMultiComboVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByVvdForMultiComboVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchWoNoByEqrRefInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.UpdateRatioDetailVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.searchMovementHistoryVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic.ContainerMovementMasterDataMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic.ContainerMovementMasterDataMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm0400Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm0421Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm0461Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm1001Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.event.EesCtm1002Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.CntrMvmtSeqVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtForGateNewBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtForGateNewBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0000Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0404Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0406Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0407Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0414Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0430Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0433Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0440Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0442Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0456Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0458Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0462Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0999Event;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.RobkgToOpusCtmEqmvmtEvent;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event.UbizComOpusCtmEqmvmtEvent;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDICtmEqMvmtListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC;
import com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic.WorkOrderManagementBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrMvmtRtnVO;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.CtmMvmtStsDcsnVO;
import com.clt.syscommon.common.table.CtmMvmtXchRsnVO;


/**
 * OPUS-EquipmentMovementMgt Business Logic ServiceCommand
 * handling business transaction for OPUS-EquipmentMovementMgt 
 *
 * @author
 * @see ContainerMovementMgtDBDAO
 * @since J2EE 1.4
 */
public class EquipmentMovementMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * creating Object when calling business scenario
	 */
	public void doStart() {
		log.debug("EquipmentMovementMgtSC start");
		try {
			// checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * closing business scenario for EquipmentMovementMgt system
	 */
	public void doEnd() {
		log.debug("EquipmentMovementMgtSC end");
	}

	/**
	 * handling all cases for OPUS-EquipmentMovementMgt system 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EesCtm0400Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMVMTStatusList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0430Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMVMTHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyMVMTHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0421Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReasonList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReasonList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0412Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIrregularContainerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0415Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDeletedMVMTList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0405Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEmptyBookingList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0408Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMovementListByContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0470Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOSCARCtmCycNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOSCARCtmCycNoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOPUSBKGwithCycNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0471Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAllVVDByBKG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVVDList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0472Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAllBKG(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0473Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAllEQRRef(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0409Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMovementListByBooking(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMovementListByEqrRefNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0440Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCorrectionVLVDListByVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCorrectionVLVDByVVD(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0404Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEDIMovementList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEDIMovement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0442Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEDIByContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0406Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVLVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageInternationalMVMT(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBkgCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getEtaEtdTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkPREVLVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = checkVLVDPreChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkVVDPreChkOnVslSkd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {//20150626 osca 추가
				eventResponse = getVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkPPreMVMTSts(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkCtmBkgVvd(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = resMovement(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0458Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBookingQTY(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0433Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCNTRList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0000Event") || e.getEventName().equalsIgnoreCase("UbizComOpusCtmEqmvmtEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = gateNew(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("RobkgToOpusCtmEqmvmtEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = gateEppBookingNew(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0407Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDomesticMVMT(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0411Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVvdHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0443Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCLMList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0413Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMVMTBKGUnmatchList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0419Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchResultEDIList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0418Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobEDIOnTimeDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIOnTimeDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEDIOnTimeDetailExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getRccList();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getLccList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0417Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobEDIErrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIErrorList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchEDIErrorDetailExcel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0420Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobEDIRstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIResultList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchEDIResultDetailExcel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0456Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPreVLVDList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePreVLVD(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0414Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBookingInfoForEDI(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMVMTHistoryAndEDI(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0460Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobVLVDStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIOnTimeDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0461Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUsAmsLocationList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0999Event")) {
			eventResponse = manageSppMovement(e);
		} else if (e.getEventName().equalsIgnoreCase("EesCtm0462Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {               // It gets a status of backendjob. 2
				eventResponse = comBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {     // It starts a job of backend. 1
				eventResponse = doBackEndJobAutoCreStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {    // It returns a result. 3
				eventResponse = searchEDIOnTimeDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAutoCreSts(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm1001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrMvmtSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCntrMvmtSeqList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCtm1002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCtmMvmtStsDcsn(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCtmMvmtStsDcsn(e);
			}
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0400 : btn_retrive
	 * retrieving Movement Status List 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMVMTStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0400Event event = (EesCtm0400Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			List<RCtmMvmtStsVO> list = command.searchMVMTStatusList(event.getRCtmMvmtStsVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0430 : btn_retrive<br>
	 * retrieving special list for ContainerMovementMasterDataMgt event
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMVMTHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0430Event event = (EesCtm0430Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		ContainerMovementValidationBC commonCommand = new ContainerMovementValidationBCImpl();
		try {
			List<MVMTBookingInfoVO> list1 = command.searchBookingInfoList(event.getCtmMovementVO(), commonCommand.searchUserCntCode(account.getOfc_cd()));
			List<MVMTHistoryListVO> list2 = command.searchMVMTHistoryList(event.getMVMTHistoryListVO());
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_CTM_0430 : btn_save<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMVMTHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0430Event event = (EesCtm0430Event)e;
		try {
			begin();
			String rtnStr = modifyMVMTProcess(event.getCusCtmMovementVOS(), event.getCtmMovementVOS());
			if (rtnStr == null) {
				rollback();
			} else {
				if (!"".equals(rtnStr)) {
					eventResponse.setETCData("rtnStr", rtnStr);
					rollback();
				} else {
					commit();
				}
			}
		} catch (EventException ex) {
			log.error("\n\n[SC - modifyMVMTHistory] EventException :\n\n" + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[SC - modifyMVMTHistory] Exception :\n\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * SC : modifyMVMTHistory / calling from manageMVMTHistoryAndEDI
	 * saving Movement History List modification
	 *
	 * @param CusCtmMovementVO[] ctmMovementVOs
	 * @param MVMTBookingInfoVO[] mvmtBookingInfoVOs
	 * @return String
	 * @exception EventException
	 */
	private String modifyMVMTProcess(CusCtmMovementVO[] cusCtmMovementVOs, MVMTBookingInfoVO[] mvmtBookingInfoVOs) throws EventException {
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		CrossItemVO item = null;
		String rtnStr = null;

		//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes	
		PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();	
		try {
			item = command.modifyMVMTHistory(cusCtmMovementVOs, mvmtBookingInfoVOs, account);

			log.info("조회 결과 DEL FLG :::: " + item.getFinalCfm() + ":::" + item.getUpdateMaster());
			if ("1".equals(item.getFinalCfm())) {
				// stopping all actions and roll back.. already final confirmed in BKG
				rtnStr = "Booking container is already confirmed. If you want to delete these status, please adjust booking container first.";
			}else if("2".equals(item.getFinalCfm())){ // [CHM-201217638]
				// All process stop and RollBack... CNTR attached into O/B without OP/OC.
				rtnStr = "Booking container is already attached into O/B Bkg("+item.getBkgNo()+"). If you want to delete these status, please adjust booking container first.";
			} else {
				List<CusCtmMovementVO> lst = item.getCusCtmMovementVOs();
				List<CusCtmMovementVO> list = new ArrayList<CusCtmMovementVO>();
				for (int i = lst.size() -1; i >= 0; i--) {
					list.add(lst.get(i));
				}

				// calling booking in case first created OC changed
				if (item.getBkgVO() != null) {
					BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
					bkgCommand0.modifyCntrHistoryUpdate(item.getBkgVO() , "2");
				}

				if (item.getUpdateMaster()) {
					item.getCusCtmMovementVO().setCtmUiYn("Y");    
					ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
					mstCommand.updateCntrMasterByMvmtBasic(item);

					// calling BKG in case of not "X"
					if (!"X".equals(item.getFinalCfm())) {
						//Opus BkgNo 과 Oscar BkgNo 분기 처리.
						if(item.getBkgNo().length() == 12){ //[2015.05.29] Add
							
							BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
							if ("O".equals(item.getFinalCfm())) { // deleting OP
								BlRatingBC bkgCommand1 = new BlRatingBCImpl();
								GeneralBookingReceiptBC bkgCommand2 = new GeneralBookingReceiptBCImpl();
								BookingHistoryMgtBC bkgCommand3 = new BookingHistoryMgtBCImpl();
	
								HistoryLineVO historyLineVO = new HistoryLineVO();
								String[] bkgNoList = command.getBookingListByCycle(item.getCntrNo(), item.getCycNo(), item.getCnmvYr());
								for (int idx = 0; idx < bkgNoList.length; idx++) {
									bkgCommand0.removeCntrSealNo(bkgNoList[idx], item.getCntrNo(), null, item.getCaFlg());
									bkgCommand1.removeCntrRateByCntr(bkgNoList[idx], item.getCntrNo(), "");
									bkgCommand2.removeReferenceDetailByCntr(bkgNoList[idx], item.getCntrNo(), item.getCaFlg());
									bkgCommand2.removeReferenceByCntr(bkgNoList[idx], item.getCntrNo(), item.getCaFlg());
									bkgCommand0.removeCntrMfDesc(bkgNoList[idx], item.getCntrNo(), item.getCaFlg());
									bkgCommand0.removeContainer(bkgNoList[idx], item.getCntrNo(), item.getCaFlg());
	
									historyLineVO.setBkgNo(bkgNoList[idx]);
									historyLineVO.setHisCateNm("Container");
									historyLineVO.setCaFlg("N");
									historyLineVO.setUiId("SYSTEM");
									historyLineVO.setCrntCtnt("Detach Container:" + item.getCntrNo());
									historyLineVO.setBkgDocProcTpCd(null);
									bkgCommand3.createBkgHistoryLine(historyLineVO, account);
	
									item.setBkgNo(bkgNoList[idx]);
									// code for confirming attach when calling COP from BKG
									// calling in case of C. deleting in case of D(calling from History)
									item.setAttchCd("D");
								    // setting N by BKG request
									item.setCntrPrtFlg("N");
									// saving ctm_mvmt_irr in case return is true after saving in bkg_container by BKG request
	//								boolean modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);
	//								if (modifyCntrOpResult) {
	//									command.updateEtcModule(item, modifyCntrOpResult);
	//								}
									BkgCntrMvmtRtnVO bkgCntrMvmtRtnVO = bkgCommand0.modifyCntrOp(item);
									if(bkgCntrMvmtRtnVO.getReturnMessage()!=null) {
										rtnStr = bkgCntrMvmtRtnVO.getReturnMessage();
									}
									if(bkgCntrMvmtRtnVO.getReturnFlag().equalsIgnoreCase("Y")) {
										command.updateEtcModule(item, true);
									}
									
									//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
									/* creating container NO, Type by booking no */
									formanceCmd.manageQtyCntrCoposite(bkgNoList[idx], "CN");
								}
	
							} else if ("V".equals(item.getFinalCfm())) { // deleting VL 
								item.setMstBkgCntrOpUpdate(true);
								log.info("original booking no  :::: " + item.getCusCtmMovementVO().getBkgNo());
								log.info("source booking no :::: " + item.getBkgNo());
								item.getCusCtmMovementVO().setBkgNo(item.getBkgNo());
								item.getCusCtmMovementVO().setCnmvCycNo(item.getCycNo());
								bkgCommand0.modifyCntrHistoryUpdate (item.getCusCtmMovementVO(), "0");
	
							} else {
								item.setMstBkgCntrOpUpdate(true);
								bkgCommand0.modifyCntrHistoryUpdate (item.getCusCtmMovementVO(), "1");
							}
							
						}else if(item.getBkgNo().length() == 10){//[2015.05.29] Add
							log.debug("\n modifyMVMTProcess Oscar BkgNo ["+item.getBkgNo()+"]");
							//[2015.05.29] Add UpdateOscarContainerMove Call.
							CusCtmMovementVO cusCtmMovementVO = item.getCusCtmMovementVO();
							if(cusCtmMovementVO != null){
								log.debug("\n modifyMVMTProcess Oscar BkgNo ["+item.getBkgNo()+"] updateOscarContainerMove Call.");
								command.updateOscarContainerMove(cusCtmMovementVO, account);
							}
						}
					}
				}

				if (list.size() > 0) {
					ChassisMovementHistoryBC cgmCommand = new ChassisMovementHistoryBCImpl();
					cgmCommand.manageCHSMovementByCtmBasic(list);
					MgsetMovementHistoryBC cgmCommand2 = new MgsetMovementHistoryBCImpl();
					cgmCommand2.manageMGSMovementByCtmBasic(list);
				}
				
				if(item.getSceActRcvIfVOs().size() > 0){
					CopDetailReceiveBC sceCommand = new CopDetailReceiveBCImpl();
					for(int i = 0; i < item.getSceActRcvIfVOs().size(); i++){
						if(item.getSceActRcvIfVOs().get(i).getBkgNo()!=null && item.getSceActRcvIfVOs().get(i).getBkgNo().length()==12){
							sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i));
						}
					}
			    }

				//TRS Transport Status Update Logic 2016.05.23//
				if(item.getUpdateTrs()) {
					List<CusCtmMovementVO> movementVOs = item.getCusCtmMovementVOs();					
					
					if(movementVOs != null && movementVOs.size() > 0) {
						try {
							for(int i = movementVOs.size()-1 ; i >= 0; i--) {
								log.info("TRS temp log : " + movementVOs.get(i).getMvmtStsCd());
								new WorkOrderManagementBCImpl().modifyWorkOrderExecuteDate(movementVOs.get(i).getCntrNo(),  movementVOs.get(i).getCnmvEvntDt(),  movementVOs.get(i).getWoNo(),  movementVOs.get(i).getOrgYdCd(), movementVOs.get(i).getMvmtStsCd(), movementVOs.get(i).getBkgNo(),  movementVOs.get(i).getUpdUsrId(), movementVOs.get(i).getMvmtCreTpCd());	
							}
						} catch(Exception e) {
							log.error("Error-[TRS]modifyWorkOrderExecuteDate " + e.toString(), e);
						}
					}
				}
				
				if(rtnStr==null){ //bkgCntrMvmtRtnVO.getReturnMessage()==null
					rtnStr = "";
				}
			}

		} catch (EventException ex) {
			log.error("\n\n[SC - modifyMVMTProcess] EventException :\n\n" + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[SC - modifyMVMTProcess] Exception :\n\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return rtnStr;
	}

	/**
	 * EES_CTM_0421 : onload<br>
	 * handling retrieve Restuffing Reason list event
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReasonList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0421Event event = (EesCtm0421Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			List<CtmMvmtXchRsnVO> list = command.searchReasonList(event.getCtmMvmtXchRsnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0412 : btn_retrive<br>
	 * handling retrieve BKG container update Irr list
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIrregularContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0412Event event = (EesCtm0412Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<CtmMvmtIrrVO> list = command.searchIrregularContainerList(event.getCtmMvmtIrrVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0415 : btn_retrive<br>
	 * handling retrieve Deleted CNTR MVMT History list
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDeletedMVMTList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0415Event event = (EesCtm0415Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<SearchDeletedMVMTListVO> list = command.searchDeletedMVMTList(event.getSearchDeletedMVMTListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0405 : btn_retrive<br>
	 * handling retrieve Empty VL List without BKG list
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBookingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0405Event event = (EesCtm0405Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<SearchEmptyBookingListVO> list = command.searchEmptyBookingList(event.getSearchEmptyBookingListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0408 : btn_retrive<br>
	 * handling retrieve Each Container list
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementListByContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0408Event event = (EesCtm0408Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchMovementListByContainerVO> list1 = command.searchMovementListByContainer(event.getSearchMovementListByContainerVO());
			eventResponse.setRsVoList(list1);

			// setting edi_date variable
			String ediDate = "";
			// in case rowdata > 1 
			if (list1.size() > 0) {
				
				ediDate = list1.get(list1.size()-1).getCnmvEvntDt();
			}
		
			event.getSearchEdiMsgVO().setEdiDate(ediDate);
			
			List<SearchEdiMsgVO> list2 = command.searchEdiMsg(event.getSearchEdiMsgVO());
			eventResponse.setRsVoList(list2);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/** searchOSCARCtmCycNo
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOSCARCtmCycNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0470Event event = (EesCtm0470Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchDeletedMVMTListVO> list1 = command.searchOSCARCtmCycNo(event.getSearchDeletedMVMTListVO());
			eventResponse.setRsVoList(list1);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/** searchOPUSBKGwithCycNo
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOPUSBKGwithCycNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0470Event event = (EesCtm0470Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			String rtnStr = command.searchOPUSBKGwithCycNo(event.getSearchDeletedMVMTListVO());
			
			eventResponse.setETCData("rtnValue", rtnStr);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/** searchAllVVDByBKG
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAllVVDByBKG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0471Event event = (EesCtm0471Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchAllVVDByBKGVO> list1 = command.searchAllVVDByBKG(event.getSearchAllVVDByBKGVO());
			eventResponse.setRsVoList(list1);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * retrieving Each Booking List 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementListByBooking(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0409Event event = (EesCtm0409Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();


		String bkgNo = event.getSearchMovementListByBkgInfoVO().getBkgNo();
		String blNo = event.getSearchMovementListByBkgInfoVO().getBlNo();
		StringBuilder comboCode = new StringBuilder();
		StringBuilder comboText = new StringBuilder();

		try {
			if (bkgNo == null || "".equals(bkgNo)) {    // without BKG_NO
				if (blNo != null && !"".equals(blNo)) {      // with BL_NO retrieving by BKG no by BL no
					bkgNo = command.searchMovementListByGetBkgNo(blNo);
				}
			}


			if (bkgNo != null && !"".equals(bkgNo)) {
				
				List<SearchMovementListByBkgInfoVO> list1 = command.searchMovementListByBkgInfo(bkgNo);
				
				for (int i=0 ; i<list1.size(); i++) {
					eventResponse.setETCData(list1.get(i).getColumnValues());
				}

				
				List<SearchMovementListByVvdForMultiComboVO> list2 = command.searchMovementListByVvdForMultiCombo("S", bkgNo);
				
				for (int i=0 ; i<list2.size(); i++) {
					comboCode.append(list2.get(i).getPolCd() + "^#^");
					comboText.append(list2.get(i).getVvdCd() + "^#^");
				}
				eventResponse.setETCData("preVvd_comboCode", comboCode.toString());
				eventResponse.setETCData("preVvd_comboText", comboText.toString());

				comboCode = new StringBuilder();
				comboText = new StringBuilder();
				
				List<SearchMovementListByVvdForMultiComboVO> list3 = command.searchMovementListByVvdForMultiCombo("U", bkgNo);
				
				for (int i=0 ; i<list3.size(); i++) {
					comboCode.append(list3.get(i).getPolCd() + "^#^");
					comboText.append(list3.get(i).getVvdCd() + "^#^");
				}
				eventResponse.setETCData("postVvd_comboCode", comboCode.toString());
				eventResponse.setETCData("postVvd_comboText", comboText.toString());

				comboCode = new StringBuilder();
				comboText = new StringBuilder();
				
				List<SearchMovementListBySplitBkgNoForMultiComboVO> list4 = command.searchMovementListBySplitBkgNoForMultiCombo(bkgNo);
				
				for (int i=0 ; i<list4.size(); i++) {
					comboCode.append(list4.get(i).getBkgNoSplit() + "^#^");
					comboText.append(list4.get(i).getBkgNo() + "|" + list4.get(i).getBkgNoSplit() + "|" + list4.get(i).getBlNo() + "^#^");
				}
				eventResponse.setETCData("splitInfo_comboCode", comboCode.toString());
				eventResponse.setETCData("splitInfo_comboText", comboText.toString());

				comboCode = new StringBuilder();
				comboText = new StringBuilder();
				// retrieving list5 by search option (for MultiCombo data)
				List<SearchMovementListByCntrTpszCdVO> list5 = command.searchMovementListByCntrTpszCd(bkgNo);
				// setting list5 as ETC-DATA
				for (int i=0 ; i<list5.size(); i++) {
					comboCode.append(list5.get(i).getCntrTpszCd() + "^#^");
					comboText.append(list5.get(i).getCntrTpszCd() + "  :  " + list5.get(i).getOpCntrQty() + "^#^");
				}
				eventResponse.setETCData("cntrTpsz_comboCode", comboCode.toString());
				eventResponse.setETCData("cntrTpsz_comboText", comboText.toString());
				comboCode = null;
				comboText = null;

				
				List<SearchMovementListByCntrInfoVO> list6 = command.searchMovementListByCntrInfo(bkgNo);
				eventResponse.setRsVoList(list6);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0409 : btn_retrive<br>
	 * retrieving Each EQR Ref No List 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMovementListByEqrRefNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0409Event event = (EesCtm0409Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		String mtyPlnNo = event.getSearchMovementListByEqrRefInfoVO().getMtyPlnNo();
		StringBuilder comboCode = new StringBuilder();
		StringBuilder comboText = new StringBuilder();

		try {
			if (mtyPlnNo != null && !"".equals(mtyPlnNo)) {
				
				List<SearchMovementListByEqrRefInfoVO> list1 = command.searchMovementListByEqrRefInfo(mtyPlnNo);
				
				for (int i=0 ; i<list1.size(); i++) {
					eventResponse.setETCData(list1.get(i).getColumnValues());
				}
				
				List<SearchWoNoByEqrRefInfoVO> list2 = command.searchWoNoByEqrRefInfo(mtyPlnNo);
				
				for (int i=0 ; i<list2.size(); i++) {
					comboCode.append(list2.get(i).getWoNo() + "^#^");
					comboText.append(list2.get(i).getWoNo() + "^#^");
				}
				eventResponse.setETCData("woNo_comboCode", comboCode.toString());
				eventResponse.setETCData("woNo_comboText", comboText.toString());

				comboCode = new StringBuilder();
				comboText = new StringBuilder();
				
				// retrieving list3 by search option (for MultiCombo data)
				List<SearchMovementListByCntrTpszCdVO> list3 = command.searchCntrTpszCdByEqrRef(mtyPlnNo);
				// setting list3 as ETC-DATA
				for (int i=0 ; i<list3.size(); i++) {
					comboCode.append(list3.get(i).getCntrTpszCd() + "^#^");
					comboText.append(list3.get(i).getCntrTpszCd() + "  :  " + list3.get(i).getOpCntrQty() + "^#^");
				}
				eventResponse.setETCData("eqTpsz_comboCode", comboCode.toString());
				eventResponse.setETCData("eqTpsz_comboText", comboText.toString());
				
				comboCode = null;
				comboText = null;

				for (int i=0 ; i<list1.size(); i++) {
					if (list1.get(0).getBkgNo() != null && !"".equals(list1.get(i).getBkgNo())) {
						List<SearchMovementListByCntrInfoVO> list4 = command.searchMovementListByCntrInfo(list1.get(0).getBkgNo());
						eventResponse.setRsVoList(list4);
					} else {
						List<SearchMovementListByCntrInfoVO> list4 = command.searchCntrInfoByEqrRef(mtyPlnNo);
						eventResponse.setRsVoList(list4);
					}
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/** 
	 * EES_CTM_0472 : btn_retrive<br>
	 * searchAllBKG
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAllBKG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0472Event event = (EesCtm0472Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchAllBKGVO> list1 = command.searchAllBKG(event.getSearchAllBKGVO());
			eventResponse.setRsVoList(list1);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/** 
	 * EES_CTM_0473 : btn_retrive<br>
	 * searchAllEQRRef
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchAllEQRRef(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0473Event event = (EesCtm0473Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();

		try {
			List<SearchAllEQRRefVO> list1 = command.searchAllEQRRef(event.getSearchAllEQRRefVO());
			eventResponse.setRsVoList(list1);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0440, EES_CTM_0405 : btn_save<br>
	 * VL/VD correction by VVD SAVE<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCorrectionVLVDByVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0440Event event = (EesCtm0440Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();

		//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
		PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();
		try {
			CusCtmMovementVO[] cusVO = event.getCusCtmMovementVOS();
			MVMTBookingInfoVO[] ctmVO = event.getMVMTBookingInfoVOS();
			List<CusCtmMovementVO> list = new ArrayList<CusCtmMovementVO>();

			for (int idx = 0; idx < cusVO.length; idx++) {

				begin();

				CrossItemVO item = null;
				CusCtmMovementVO[]  param1 = new CusCtmMovementVO[1];
				MVMTBookingInfoVO[] param2 = new MVMTBookingInfoVO[1];
				param1[0] = cusVO[idx];
				ctmVO[idx].setPCntrno(ctmVO[idx].getCntrNo());
				param2[0] = ctmVO[idx];
				item = command.modifyMVMTHistory(param1, param2, account);

				log.info("조회 결과 DEL FLG :::: " + item.getFinalCfm() + ":::" + item.getUpdateMaster());
				if (item.getFinalCfm().equals("1")) {
					
					rollback();
					eventResponse.setETCData("rtnStr", "Booking container is already confirmed. If you want to delete these status, please adjust booking container first.");
					return eventResponse;
				}
				log.info("대상 서버 :" + param1[0].getCntrSvrId());

				param1[0].setUpdUsrId(account.getUsr_id());
				list.add(param1[0]);

				if (item.getUpdateMaster()) {
					item.getCusCtmMovementVO().setCtmUiYn("Y");    // ctm_ui_yn (0430/0414화면에서의 실행인지 구분값 - MST모듈에서 사용)
					ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
					mstCommand.updateCntrMasterByMvmtBasic(item);

					// returning "X" from BCImpl in case OP and not existed container in BKG_CONTAINER
					// calling BKG module in case of not "X"
					if (!"X".equals(item.getFinalCfm())) {

						if (ctmVO[idx].getLstFlg() != null && !"X".equals(ctmVO[idx].getLstFlg())) {
							
							//Opus BkgNo 과 Oscar BkgNo 분기 처리.
							if(item.getBkgNo().length() == 12){ //[2015.05.29] Add 

								BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
								if ("O".equals(item.getFinalCfm())) { // deleting OP
									BlRatingBC bkgCommand1 = new BlRatingBCImpl();
									GeneralBookingReceiptBC bkgCommand2 = new GeneralBookingReceiptBCImpl();
									BookingHistoryMgtBC bkgCommand3 = new BookingHistoryMgtBCImpl();
	
									bkgCommand0.removeCntrSealNo(item.getBkgNo(), item.getCntrNo(), null, item.getCaFlg());
									bkgCommand1.removeCntrRateByCntr(item.getBkgNo(), item.getCntrNo(), "");
									bkgCommand2.removeReferenceDetailByCntr(item.getBkgNo(), item.getCntrNo(), item.getCaFlg());
									bkgCommand2.removeReferenceByCntr(item.getBkgNo(), item.getCntrNo(), item.getCaFlg());
									bkgCommand0.removeCntrMfDesc(item.getBkgNo(), item.getCntrNo(), item.getCaFlg());
									bkgCommand0.removeContainer(item.getBkgNo(), item.getCntrNo(), item.getCaFlg());
	
									HistoryLineVO historyLineVO = new HistoryLineVO();
									historyLineVO.setBkgNo(item.getBkgNo());
									historyLineVO.setHisCateNm("Container");
									historyLineVO.setCaFlg("N");
									historyLineVO.setUiId("SYSTEM");
									historyLineVO.setCrntCtnt("Detach Container:" + item.getCntrNo());
									historyLineVO.setBkgDocProcTpCd(null);
									bkgCommand3.createBkgHistoryLine(historyLineVO, account);
	
									// code for checking whether attach or not when calling COP from BKG
									// calling in case of 'C', deleting in case of 'D'(calling from History)
									item.setAttchCd("D");
									// setting 'N' manually by BKG request
									item.setCntrPrtFlg("N");
									// saving in ctm_mvmt_irr table by BKG request in case return value is true after saving in bkg_container table 
	//								boolean modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);
	//								if (modifyCntrOpResult) {
	//									command.updateEtcModule(item, modifyCntrOpResult);
	//								}
									BkgCntrMvmtRtnVO bkgCntrMvmtRtnVO = bkgCommand0.modifyCntrOp(item);
									if(bkgCntrMvmtRtnVO.getReturnMessage()!=null) {
										rollback();
										eventResponse.setETCData("rtnStr", bkgCntrMvmtRtnVO.getReturnMessage());
										return eventResponse;
									}
									if(bkgCntrMvmtRtnVO.getReturnFlag().equalsIgnoreCase("Y")) {
										command.updateEtcModule(item, true);
									}
	
									/* creating container no and type by bkg_no*/
									formanceCmd.manageQtyCntrCoposite(item.getBkgNo(), "CN");
								} else if ("V".equals(item.getFinalCfm())) { // deleting VL
									item.setMstBkgCntrOpUpdate(true);
									log.info("원 부킹 번호 :::: " + item.getCusCtmMovementVO().getBkgNo());
									log.info("소스 부킹 번호 :::: " + item.getBkgNo());
									item.getCusCtmMovementVO().setBkgNo(item.getBkgNo());
									item.getCusCtmMovementVO().setCnmvCycNo(item.getCycNo());
									bkgCommand0.modifyCntrHistoryUpdate (item.getCusCtmMovementVO(), "0");
	
								} else {
									item.setMstBkgCntrOpUpdate(true);
									bkgCommand0.modifyCntrHistoryUpdate (item.getCusCtmMovementVO(), "1");
								}
								
							}else if(item.getBkgNo().length() == 10){//[2015.05.29] Add
								log.debug("\n manageCorrectionVLVDByVVD Oscar BkgNo ["+item.getBkgNo()+"]");
								//[2015.05.29] Add UpdateOscarContainerMove Call.
								CusCtmMovementVO cusCtmMovementVO = item.getCusCtmMovementVO();
								if(cusCtmMovementVO != null){
									log.debug("\n manageCorrectionVLVDByVVD Oscar BkgNo ["+item.getBkgNo()+"] updateOscarContainerMove Call.");
									command.updateOscarContainerMove(cusCtmMovementVO, account);
								}
							}
						}
					}
				}
				commit();
			}

			log.info("삭제 대상 리스트 :" + list.size());
			if (list.size() > 0) {
				ChassisMovementHistoryBC cgmCommand = new ChassisMovementHistoryBCImpl();
				cgmCommand.manageCHSMovementByCtmBasic(list);
				MgsetMovementHistoryBC cgmCommand2 = new MgsetMovementHistoryBCImpl();
				cgmCommand2.manageMGSMovementByCtmBasic(list);
			}

		} catch (EventException ex) {
			log.error("\n\n[SC - manageCorrectionVLVDByVVD] EventException :\n\n" + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[SC - manageCorrectionVLVDByVVD] Exception :\n\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0440 : btn_retrive<br>
	 * handling retrieve event for VL/VD correction by VVD list
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCorrectionVLVDListByVVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0440Event event = (EesCtm0440Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<CorrectionVLVDListVO> list = command.searchCorrectionVLVDListByVVD(event.getCorrectionVLVDList());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0404 : btn_retrive<br>
	 *  handling retrieve event for Update of EDI Message list
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIMovementList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0404Event event = (EesCtm0404Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();

		try {
			// defining variables for loading data by determined row
			int iPage = event.getSearchEDIMovementListVO().getIPage().equals("") ? 1 : Integer.parseInt(event.getSearchEDIMovementListVO().getIPage());
			int pageRows = Integer.parseInt(event.getSearchEDIMovementListVO().getPagerows());
			int startRowNo = pageRows * (iPage - 1) + 1;
			int endRowNo = pageRows * iPage;

			// setting values in searchEDIMovementListVO
			event.getSearchEDIMovementListVO().setStartRowNo(String.valueOf(startRowNo));
			event.getSearchEDIMovementListVO().setEndRowNo(String.valueOf(endRowNo));
			// retrieving list by using searchEDIMovementListVO
			List<SearchEDIMovementListVO> list = command.searchEDIMovementList(event.getSearchEDIMovementListVO());

			// XML DATA setting
			eventResponse.setRsVoList(list);

			// in case list.size() >  0 and this it not the first retrieving (not Append retrieving)
			if (iPage < 2) {
				if (list.size() > 0) {
					// setting total count of search options
					int rtvTotal = Integer.parseInt(command.searchEDIMovementCount(event.getSearchEDIMovementListVO()));
					eventResponse.setETCData("rtv_total", String.valueOf(rtvTotal));
					// EDI total count of search options
					  // setting temporarily in variables getting data from original MvmtEdiRsltCd
					String mvmtEdiRsltCd = event.getSearchEDIMovementListVO().getMvmtEdiRsltCd();
					  // setting "ALL" in SearchEDIMovementListVO의 MvmtEdiRsltCd에 "ALL"을 setting(mvmt_edi_rslt_cd = Y,N)
					event.getSearchEDIMovementListVO().setMvmtEdiRsltCd("ALL");
					  // setting retrieve result count in ediMvmtKnt 
					String gndTotal = command.searchEDIMovementCount(event.getSearchEDIMovementListVO());
					  
					event.getSearchEDIMovementListVO().setMvmtEdiRsltCd(mvmtEdiRsltCd);

					// XML ETC-DATA setting
					// for separating EDI total count of retrieve options
					eventResponse.setETCData("mvmt_edi_rslt_cd", event.getSearchEDIMovementListVO().getMvmtEdiRsltCd());
					// EDI total count of retrieve options
					eventResponse.setETCData("gnd_total", gndTotal);
				} else {
					eventResponse.setETCData("rtv_total", "0");
					eventResponse.setETCData("gnd_total", "0");
				}
			}

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0404 : btn_save<br>
	 * handling event for updating of EDI Message and multiple saving
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEDIMovement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0404Event event = (EesCtm0404Event)e;
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();

		SearchEDIMovementListVO[] searchEDIMovementListVOs = event.getSearchEDIMovementListVOS();
		SearchEDIMovementListVO searchEDIMovementListVO = null;
		FlatFileForGateNewVO flatFileForGateNewVO = null;
		List<SearchEDIMovementListVO> searchEDIMovementList = new ArrayList<SearchEDIMovementListVO>();
		int totalCount = 0;
		int okCount = 0;
		int errorCount = 0;
		int ignoredCount = 0;
		int deletedCount = 0;

		if (searchEDIMovementListVOs != null) {

			for (int k=0; k<searchEDIMovementListVOs.length; k++) {
				searchEDIMovementListVO = null;
				flatFileForGateNewVO = null;
				searchEDIMovementListVOs[k].setEdiUiYn("Y");                   // edi_ui_yn (separator for distinguishing 404/0414 screens)
				searchEDIMovementListVOs[k].setUserId(account.getUsr_id());    // user_id
				searchEDIMovementListVOs[k].setUserNm(account.getUsr_nm());    // user_nm

				if ("R".equals(searchEDIMovementListVOs[k].getIbflag()) || "".equals(searchEDIMovementListVOs[k].getIbflag())) {
					log.info("\n\n===============================================================" +
							  "\n [0404UI] GateNew() - Begin!" +
							  "\n===============================================================\n");
					if ("VL".equals(searchEDIMovementListVOs[k].getEdiMvmtStsCd()) || "VD".equals(searchEDIMovementListVOs[k].getEdiMvmtStsCd()) ) {
						searchEDIMovementListVOs[k].setEdiMvmtStsCd("ZZ");
					}

					try {
						// AssignEdiUiVO2FlatFileVO for GateNew ////////////////////////////
						flatFileForGateNewVO = gatenewCommand.assignEdiUiVO2FlatFileVO(searchEDIMovementListVOs[k]);
						log.info("\n\n===============================================================" +
								  "\n begin_flatFile : ColumnValues" +
								  "\n======================================" +
								  "\n" + flatFileForGateNewVO.getColumnValues().toString().replaceAll(", ", "\n") +
								  "\n======================================" +
								  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileForGateNewVO.getBkgNumber()) +
								  "\n===============================================================\n");
						// starting BCImpl.GateNew   ////////////////////////////////////////////
						begin();    // gateNew BEGIN
						flatFileForGateNewVO = gatenewCommand.gateNew(flatFileForGateNewVO);
						commit();
						log.info("\n\n===============================================================" +
								  "\n finish_flatFile : ColumnValues" +
								  "\n======================================" +
								  "\n" + flatFileForGateNewVO.getColumnValues().toString().replaceAll(", ", "\n") +
								  "\n======================================" +
								  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileForGateNewVO.getBkgNumber()) +
								  "\n===============================================================\n");
					} catch (EventException ex) {
						rollback();
						log.error("\n\n[SC - (0404UI) GateNew] EventException :\n\n" + ex.getMessage(), ex);
						throw ex;
					} catch (Exception ex) {
						rollback();
						log.error("\n\n[SC - (0404UI) GateNew] Exception :\n\n" + ex.getMessage(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					// in case returned flatFileForGateNewVO is not null /////////////////
					if (flatFileForGateNewVO != null) {
						// manageGateNewProcess ////////////////////////////////////////
						flatFileForGateNewVO = manageGateNewProcess(flatFileForGateNewVO, false);
						
						if (("0").equals(flatFileForGateNewVO.getGateIo()) || ("1").equals(flatFileForGateNewVO.getGateIo()) || ("ST").equals(flatFileForGateNewVO.getGateIo())) {
							CrossItemVO item = new CrossItemVO();	
							CrossItemVO mnrItem = new CrossItemVO();								
							ContainerMovementMgtBC mgtCommand = new ContainerMovementMgtBCImpl();

							begin();
							item = mgtCommand.modifyCNTRStatus(gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1), account);
							
							String[] rtnStrs = null;
							rtnStrs = item.getRtnStr();
							
							if (rtnStrs[0] == null || rtnStrs[0].equals("X") || rtnStrs[0].equals("")) {
								try {
									if (rtnStrs[0] != null && rtnStrs[0].equals("X")) {
										item.setMnrCallYN("EDI");
										mnrItem = mgtCommand.modifyDMGHistory(item, account);
										rtnStrs = mnrItem.getRtnStr();
									}
								} catch (Exception ex) {
									/*********************************************************
									 * no throwing in case of failure for handling next data *
									 *********************************************************/
									rtnStrs[0] = "N";
									rtnStrs[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
									log.error(ex.getMessage(),ex);
								}
							}
							
							if (rtnStrs[0] != null && (rtnStrs[0].equals("N"))) {
								rollback();
							} else {
								commit();
							}
							
							flatFileForGateNewVO.setResultIndicator(rtnStrs[0]);
							flatFileForGateNewVO.setResultMessage(rtnStrs[1]);
							
						}
						
						// AssignFlatFileVO2EdiUiVO for GateNew ////////////////////////
						searchEDIMovementListVO = gatenewCommand.assignFlatFileVO2EdiUiVO(flatFileForGateNewVO, searchEDIMovementListVOs[k]);
					}
					log.info("\n\n===============================================================" +
							  "\n [0404UI] GateNew() - Finish!" +
							  "\n===============================================================\n");

				} else if ("U".equals(searchEDIMovementListVOs[k].getIbflag())) {	
					
						if (!searchEDIMovementListVOs[k].getMvmtEdiRsltCd().equals("D") && ("0".equals(searchEDIMovementListVOs[k].getEdiGateIoCd()) || "1".equals(searchEDIMovementListVOs[k].getEdiGateIoCd()) || "ST".equals(searchEDIMovementListVOs[k].getEdiGateIoCd()) )) {
						
						CrossItemVO item = new CrossItemVO();		
						CrossItemVO mnrItem = new CrossItemVO();								
						ContainerMovementMgtBC mgtCommand = new ContainerMovementMgtBCImpl();
						flatFileForGateNewVO = gatenewCommand.assignEdiUiVO2FlatFileVO(searchEDIMovementListVOs[k]);
						
						log.info("\n\n===============================================================" +
								  "\n flatFileForGateNewVO" + flatFileForGateNewVO +
								  "\n===============================================================\n");
						
						String[] bkgNumber = new String[1];
						flatFileForGateNewVO.setBkgNumber(bkgNumber);
						
						begin();
						item = mgtCommand.modifyCNTRStatus(gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1), account);
						
						String[] rtnStrs = null;
						rtnStrs = item.getRtnStr();
						
						if (rtnStrs[0] == null || rtnStrs[0].equals("X") || rtnStrs[0].equals("")) {
							try {
								if (rtnStrs[0] != null && rtnStrs[0].equals("X")) {
									item.setMnrCallYN("EDI");
									mnrItem = mgtCommand.modifyDMGHistory(item, account);
									rtnStrs = mnrItem.getRtnStr();
								}
							} catch (Exception ex) {
								/*********************************************************
								 * no throwing in case of failure for handling next data *
								 *********************************************************/
								rtnStrs[0] = "N";
								rtnStrs[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
								log.error(ex.getMessage(),ex);
							}
						}
						
						if (rtnStrs[0] != null && (rtnStrs[0].equals("N"))) {
							rollback();
						} else {
							commit();
						}
						
						flatFileForGateNewVO.setResultIndicator(rtnStrs[0]);
						flatFileForGateNewVO.setResultMessage(rtnStrs[1]);
						
						searchEDIMovementListVO = gatenewCommand.assignFlatFileVO2EdiUiVO(flatFileForGateNewVO, searchEDIMovementListVOs[k]);						
					
					} else {
						log.info("\n\n===============================================================" +
								  "\n [0404UI] manageEDIProcess() - Begin!|" + 
								  "\n===============================================================\n");
					    // EDIProcess //////////////////////////////////////////////////////
						searchEDIMovementListVO = manageEDIProcess(searchEDIMovementListVOs[k]);
						log.info("\n\n===============================================================" +
								  "\n [0404UI] manageEDIProcess() - Finish!" + 
								  "\n===============================================================\n");
					}
				}

				// in case returned searchEDIMovementListVO가 is not null  /////////////////
				if (searchEDIMovementListVO != null) {
					if(searchEDIMovementListVO.getMvmtEdiRsltCd().equals("D")) {
						deletedCount = deletedCount + 1;
					}else{
						try {
							int rtyKnt = Integer.parseInt(searchEDIMovementListVOs[k].getRtyKnt()) + 1;
							searchEDIMovementListVO.setRtyKnt(String.valueOf(rtyKnt));    // rty_knt
							begin();    // resultUpdb BEGIN
							log.debug("\n\n===============================================================" +
									  "\n gatenewCommand.resultUpdb()" +
									  "\n===============================================================\n");
							searchEDIMovementListVO = gatenewCommand.resultUpdb(searchEDIMovementListVO);
							commit();
						} catch (EventException ex) {
							rollback();
							log.error("\n\n resultUpdb : EventException\n" + ex.toString(), ex);
							throw ex;
						} catch (Exception ex) {
							rollback();
							log.error("\n\n resultUpdb : Exception\n" + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}

						// Count : adding to resultList in case mvmtEdiRsltCd is not "Y"
						if ("N".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())) {
							searchEDIMovementList.add(searchEDIMovementListVO);
							errorCount = errorCount + 1;
						} else if ("X".equals(searchEDIMovementListVO.getMvmtEdiRsltCd()) || "I".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())) {
							ignoredCount = ignoredCount + 1;
						} else {
							okCount = okCount + 1;
						}
					}
					totalCount = totalCount + 1;
				}
			}
		}

		// setting result
		eventResponse.setETCData("total_count", String.valueOf(totalCount));
		eventResponse.setETCData("ok_count",  String.valueOf(okCount));
		eventResponse.setETCData("error_count",  String.valueOf(errorCount));
		eventResponse.setETCData("ignored_count",  String.valueOf(ignoredCount));
		eventResponse.setETCData("deleted_count",  String.valueOf(deletedCount));
		eventResponse.setRsVoList(searchEDIMovementList);
		return eventResponse;
	}

	/**
	 * EquipmentMovementMgtSC : calling from manageEDIMovement
	 * handling updating EDI Process
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 */
	private SearchEDIMovementListVO manageEDIProcess(SearchEDIMovementListVO searchEDIMovementListVO) throws EventException {
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		ContainerMovementValidationBC commonCommand = new ContainerMovementValidationBCImpl();
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();

		CusCtmMovementVO[] cusCtmMovementVOs = null;
		String[] returnValues = new String[2];
		String[] bkgNoArray = null;
		log.debug("\n==================== checking DELETE CASE FROM  UI : Update of EDI Message ( EES_CTM_0404 ) ====================");
		if(searchEDIMovementListVO.getMvmtEdiRsltCd().equals("D")) {
			// UPDATE MVMT_EDI_TP_CD & INSERT CTM_EDI_RSLT_RMK
			try {
				command.updateResultAsDelForMvmtEdiMsg(searchEDIMovementListVO);
			} catch (EventException ex) {
				log.error("\n\nerr " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				log.error("\n\nerr " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			return searchEDIMovementListVO;
		}

		log.debug("\n==================== checking ACIAC_DIV_CD ====================");
		String[] checkAciacDivCdYN = new String[3];
		try {
			checkAciacDivCdYN = gatenewCommand.checkAciacDivCd(searchEDIMovementListVO.getCntrNo(), searchEDIMovementListVO.getBkgNo());
			// checkAciacDivCdYN[0] : ResultMessage
			// checkAciacDivCdYN[1] : ResultIndicator
			// checkAciacDivCdYN[2] : checkAciacDivCdYN(Y/N)
			// checkAciacDivCdYN[3] : cntrTpszCd
		} catch (EventException ex) {
			log.error("\n\nerr " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\nerr " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ("N".equals(checkAciacDivCdYN[2])) {
			searchEDIMovementListVO.setMvmtEdiRmk(checkAciacDivCdYN[0]);
			searchEDIMovementListVO.setMvmtEdiRsltCd(checkAciacDivCdYN[1]);

		} else {
			if ("ER".equals(searchEDIMovementListVO.getEdiMvmtStsCd())) {
				log.debug("\n==================== skipping CTM_COMMON in case EdiMvmtSts is ER  ====================");
				searchEDIMovementListVO.setMvmtEdiRmk("STS CHECK ERROR");
				searchEDIMovementListVO.setMvmtEdiRsltCd("N");

			} else {
				log.debug("\n==================== starting CTM_COMMON  ====================");
				// calling in case EdiMvmtSts is  OP or OC only
				if ("OP".equals(searchEDIMovementListVO.getEdiMvmtStsCd()) || "OC".equals(searchEDIMovementListVO.getEdiMvmtStsCd())) {
					try {
						bkgNoArray = command.getBkgNoByEDICntrInfo(searchEDIMovementListVO);
					} catch (EventException ex) {
						log.error("\n\nerr " + ex.toString(), ex);
						throw ex;
					} catch (Exception ex) {
						log.error("\n\nerr " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
				}

				if (bkgNoArray != null && bkgNoArray.length > 0) {
					/* creating as count as getEdiVOs[i] + sub bkg_no */
					cusCtmMovementVOs = new CusCtmMovementVO[1 + bkgNoArray.length];
				} else {
					cusCtmMovementVOs = new CusCtmMovementVO[1];
				}

				for (int i = 0; i < cusCtmMovementVOs.length; i++) {
					cusCtmMovementVOs[i] = new CusCtmMovementVO();

					cusCtmMovementVOs[i].setBkgKnt(cusCtmMovementVOs.length + "");
					if (i == 0) {
						cusCtmMovementVOs[i].setBkgNo(searchEDIMovementListVO.getBkgNo());
					} else {
						cusCtmMovementVOs[i].setBkgNo(bkgNoArray[i - 1]);
					}
				    cusCtmMovementVOs[i].setBlNo(subStr(searchEDIMovementListVO.getBlNo(), 0, 12));
				    cusCtmMovementVOs[i].setCallSgnNo(searchEDIMovementListVO.getCallSgnNo());
				    cusCtmMovementVOs[i].setChssNo(searchEDIMovementListVO.getChssNo());
					cusCtmMovementVOs[i].setCnmvEvntDt(searchEDIMovementListVO.getEvntDt());
					cusCtmMovementVOs[i].setCnmvYr(DateTime.getFormatDate(new java.util.Date(), "yyyy"));
					cusCtmMovementVOs[i].setCntrNo(searchEDIMovementListVO.getCntrNo());
				    cusCtmMovementVOs[i].setCntrSealNo(searchEDIMovementListVO.getCntrSealNo());
					cusCtmMovementVOs[i].setCreUsrId(account.getUsr_id());
					cusCtmMovementVOs[i].setCrntSkdDirCd(searchEDIMovementListVO.getCrntSkdDirCd());
					cusCtmMovementVOs[i].setCrntSkdVoyNo(searchEDIMovementListVO.getCrntSkdVoyNo());
					cusCtmMovementVOs[i].setCrntVslCd(searchEDIMovementListVO.getCrntVslCd());
				    cusCtmMovementVOs[i].setDestYdCd(searchEDIMovementListVO.getDestYdCd());

				    String fullEmptyFlag = (searchEDIMovementListVO.getCntrFullStsCd() == null ? "" : String.valueOf(searchEDIMovementListVO.getCntrFullStsCd()));
					if ("F".equals(fullEmptyFlag) || "L".equals(fullEmptyFlag) || "AH".equals(fullEmptyFlag)) {
						cusCtmMovementVOs[i].setFcntrFlg("F");
					} else if ("M".equals(fullEmptyFlag) || "E".equals(fullEmptyFlag) || "AB".equals(fullEmptyFlag) || "AJ".equals(fullEmptyFlag)) {
						cusCtmMovementVOs[i].setFcntrFlg("M");
				    } else {
						cusCtmMovementVOs[i].setFcntrFlg("F");
					}

				    cusCtmMovementVOs[i].setMgstNo(searchEDIMovementListVO.getMgstNo());
					cusCtmMovementVOs[i].setMvmtEdiMsgAreaCd(searchEDIMovementListVO.getMvmtEdiMsgAreaCd());
					cusCtmMovementVOs[i].setMvmtEdiMsgSeq(searchEDIMovementListVO.getMvmtEdiMsgSeq());
					cusCtmMovementVOs[i].setMvmtEdiMsgTpId(searchEDIMovementListVO.getMvmtEdiMsgTpId());
					cusCtmMovementVOs[i].setMvmtEdiMsgYrmondy(searchEDIMovementListVO.getMvmtEdiMsgYrmondy());
					cusCtmMovementVOs[i].setMvmtEdiTpCd(searchEDIMovementListVO.getMvmtEdiTpCd());
					cusCtmMovementVOs[i].setMvmtStsCd(searchEDIMovementListVO.getEdiMvmtStsCd());
				    cusCtmMovementVOs[i].setMvmtTrspModCd(searchEDIMovementListVO.getMvmtTrspModCd());
					cusCtmMovementVOs[i].setOfcCd(account.getOfc_cd());
					cusCtmMovementVOs[i].setOrgYdCd(searchEDIMovementListVO.getEvntYdCd());
					cusCtmMovementVOs[i].setPkupNo(searchEDIMovementListVO.getPkupNo());
					if ("VD".equals(searchEDIMovementListVO.getEdiMvmtStsCd())) {
					    cusCtmMovementVOs[i].setPodCd(subStr(searchEDIMovementListVO.getEvntYdCd(), 0, 5));
					} else if ("VL".equals(searchEDIMovementListVO.getEdiMvmtStsCd())) {
					    cusCtmMovementVOs[i].setPolCd(subStr(searchEDIMovementListVO.getEvntYdCd(), 0, 5));
					}
					cusCtmMovementVOs[i].setUpdUsrId(account.getUsr_id());
					cusCtmMovementVOs[i].setUsrNm(account.getUsr_nm());
				    cusCtmMovementVOs[i].setVndrSeq(searchEDIMovementListVO.getVndrSeq());
					cusCtmMovementVOs[i].setWblNo(searchEDIMovementListVO.getWblNo());
					cusCtmMovementVOs[i].setCnmvRmk(searchEDIMovementListVO.getCnmvRmk());
					
					//EDI Flat File 추가에 따른 작업 [2014.09.01]
					cusCtmMovementVOs[i].setWoNo(searchEDIMovementListVO.getWoNo());
					cusCtmMovementVOs[i].setEdiVvdCd(searchEDIMovementListVO.getEdiVvdCd());
					cusCtmMovementVOs[i].setTirNo(searchEDIMovementListVO.getTirNo());
					cusCtmMovementVOs[i].setMtyPlnNo(searchEDIMovementListVO.getMtyPlnNo());
					cusCtmMovementVOs[i].setMtyRepoNo(searchEDIMovementListVO.getMtyRepoNo());
					cusCtmMovementVOs[i].setEdiCrrNo(searchEDIMovementListVO.getEdiCrrNo());
					cusCtmMovementVOs[i].setTrspDocNo(searchEDIMovementListVO.getTrspDocNo());
					
					cusCtmMovementVOs[i].setCntrDmgFlg(searchEDIMovementListVO.getCntrDmgFlg());
					cusCtmMovementVOs[i].setDmgFlgDt(searchEDIMovementListVO.getDmgFlgDt());
					cusCtmMovementVOs[i].setDmgUnflgDt(searchEDIMovementListVO.getDmgUnflgDt());

					cusCtmMovementVOs[i].setVgmDocIdNo(searchEDIMovementListVO.getVgmDocIdNo());
					cusCtmMovementVOs[i].setVgmWgt(searchEDIMovementListVO.getVgmWgt());
					if ("K".equals(searchEDIMovementListVO.getVgmEdiWgtUtCd())) {
						cusCtmMovementVOs[i].setVgmWgtUtCd("KGS");
					} else {
						cusCtmMovementVOs[i].setVgmWgtUtCd("LBS");
					}
					cusCtmMovementVOs[i].setVgmDocTpCd(searchEDIMovementListVO.getVgmDocTpCd());
					cusCtmMovementVOs[i].setVgmDtTpCd(searchEDIMovementListVO.getVgmDtTpCd());
					cusCtmMovementVOs[i].setVgmHndlDt(searchEDIMovementListVO.getVgmHndlDt());
					cusCtmMovementVOs[i].setVgmCustCntcTpCd(searchEDIMovementListVO.getVgmCustCntcTpCd());
					cusCtmMovementVOs[i].setVgmCustCntcNm(searchEDIMovementListVO.getVgmCustCntcNm());
					cusCtmMovementVOs[i].setVgmCustFaxNo(searchEDIMovementListVO.getVgmCustFaxNo());
					cusCtmMovementVOs[i].setVgmCustEml(searchEDIMovementListVO.getVgmCustEml());
					cusCtmMovementVOs[i].setVgmCustPhnNo(searchEDIMovementListVO.getVgmCustPhnNo());
					cusCtmMovementVOs[i].setVgmCustAddr(searchEDIMovementListVO.getVgmCustAddr());
					cusCtmMovementVOs[i].setUsaEdiCd(searchEDIMovementListVO.getUsaEdiCd());
					cusCtmMovementVOs[i].setCntrStwgPsnCtnt(searchEDIMovementListVO.getCntrStwgPsnCtnt());
				}
				
				// MvmtStsCd가 "C"로 시작하면 Domestic-COMMON을 호출
				if ("C".equals(subStr(searchEDIMovementListVO.getEdiMvmtStsCd(), 0, 1))) {

					/* Domestic MVMT Common 호출 (S) ++++++++++++++++++++++++++++++++++++++++++++++++++*/
					log.debug("\n\n===============================================================" +
							  "\n manageDomesticMVMT(vos[0], account) ++++++ Domestic MVMT Common 호출" +
							  "\n===============================================================\n");
					
					try {
						begin();    // Domestic-COMMON BEGIN
						CrossItemVO item = command.manageDomesticMVMT(cusCtmMovementVOs[0], commonCommand.searchUserCntCode(account.getOfc_cd()));
						returnValues = item.getRtnStr();
						if ("N".equals(returnValues[0])) {
							rollback();    // Domestic-COMMON ROLLBACK
						} else {
							if (item.getUpdateMaster() == true) {
								ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
								mstCommand.updateCntrMasterByMvmtBasic(item);
							}
							commit();    //  Domestic-COMMON COMMIT
							
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
							if(item.getSceActRcvIfVOs().size() > 0){
								com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
									new com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
								
								for(int i = 0; i < item.getSceActRcvIfVOs().size(); i++){
									if(item.getSceActRcvIfVOs().get(i).getBkgNo()!=null && item.getSceActRcvIfVOs().get(i).getBkgNo().length()==12){
										sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i));
									}
										
								}
							}
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)

						}
					} catch (EventException ex) {
						/******************************************************
						 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
						 ******************************************************/
						rollback();    // Domestic-COMMON ROLLBACK
						returnValues[0] = "N";
						returnValues[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
						log.error("\n\nerr " + ex.toString(), ex);
					} catch (Exception ex) {
						rollback();    // Domestic-COMMON ROLLBACK
						log.error("\n\nerr " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
					log.debug("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_STS : " + returnValues[0] +
							  "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_MSG : " + returnValues[1] + "\n");
					/* Domestic MVMT COmmon 호출 (E) ++++++++++++++++++++++++++++++++++++++++++++++++++*/


				// 아니면 CTM-COMMON을 호출
				} else {				
					/* calling MVMT Common (S) ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					log.debug("\n\n===============================================================" +
							  "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common 호출" +
							  "\n===============================================================\n");
					try {
						begin();    // COMMON BEGIN
						returnValues = manageCreateProcess(cusCtmMovementVOs, cusCtmMovementVOs.length, false, false, false);
						if ("N".equals(returnValues[0])) {
							rollback();    // COMMON ROLLBACK
						} else {
							commit();    //  COMMON COMMIT
						}
					} catch (EventException ex) {
						/******************************************************
						 * no throwing in case of failure for handling next data *
						 ******************************************************/
						rollback();    // COMMON ROLLBACK
						returnValues[0] = "N";
						returnValues[1] = ex.getMessage();
						log.error("\n\nerr " + ex.toString(), ex);
					} catch (Exception ex) {
						rollback();    // COMMON ROLLBACK
						log.error("\n\nerr " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
					log.debug("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS : " + returnValues[0] +
							  "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG : " + returnValues[1] + "\n");
					/* calling MVMT Common (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				}
				
				if (returnValues[0] == null || returnValues[0].trim().equals("") || returnValues[0].trim().equals("null")) {
					returnValues[0] = "";
				} else {
					returnValues[0] = returnValues[0].trim();
				}
				if (returnValues[1] == null || returnValues[1].trim().equals("") || returnValues[1].trim().equals("null")) {
					returnValues[1] = "";
				} else {
					returnValues[1] = returnValues[1].trim();
				}				

				//  setting result in searchEDIMovementListVO
				searchEDIMovementListVO.setMvmtEdiRsltCd(returnValues[0]);
				searchEDIMovementListVO.setMvmtEdiRmk(returnValues[1]);
			}
		}
		return searchEDIMovementListVO;
	}

	/**
	 * EES_CTM_0442 : btn_retrive<br>
	 * handling retrieve event for Detail Information list
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIByContainer(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0442Event event = (EesCtm0442Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<SearchEDIByContainerVO> list1 = command.searchEDIByContainer(event.getSearchEDIByContainerVO());
			// setting list0 as ETC-DATA
			for (int i = 0; i < list1.size(); i++) {
				eventResponse.setETCData(list1.get(i).getColumnValues());
			}

			List<SearchEDIByResultRemarkVO> list2 = command.searchEDIByResultRemark(event.getSearchEDIByResultRemarkVO());
			// setting list1 as DATA
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : btn_retrive<br>
	 * handling retrieve event for International VL/VD
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVLVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			String oscaBkgFlg = event.getCusCtmMovementVO().getOscaBkgFlg();
			List<SearchCLMInfoVO> list = command.searchVLVDList(event.getSearchCLMInfoVO(), oscaBkgFlg);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : Grid (Container onChange Event)<br>
	 * retrieving container no and retrieving reserved booking list for that container
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<SearchBkgCntrListVO> list = command.searchBkgCntrList(event.getSearchBkgCntrListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : btn_save<br>
	 * registering multiple list of Container Movement Status
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInternationalMVMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		String oldCntrNo = null;
		StringBuffer rtnString = new StringBuffer();

		CtmCntrMovInfoVO[] vos = event.getCtmCntrMovInfoVOS();

		CusCtmMovementVO[] opVos = new CusCtmMovementVO[vos.length+1];
		List<CusCtmMovementVO> errVos = new ArrayList<CusCtmMovementVO>();
		CusCtmMovementVO opVo  = null;
		CtmCntrMovInfoVO vo = null;
		int idx = 0;
		boolean autoExec = true;
		for (int i = 0; i < vos.length; i++) {
			vo = vos[i];
			opVo = new CusCtmMovementVO();
			opVo.setBkgNo(vo.getBkgNo());
			opVo.setMtyPlnNo(vo.getMtyPlnNo());	// reference no 추가 by 2015/06/15 황미연
			opVo.setCntrDmgFlg(vo.getCntrDmgFlg());
			opVo.setBkgCgoTpCd(vo.getBkgCgoTpCd());
			opVo.setBkgRcvTermCd(vo.getRcvTermCd());
			opVo.setChssNo(vo.getChssNo());
			opVo.setCnmvEvntDt(vo.getCnmvEvntDt());
//			opVo.setCntrNo(vo.getCntrNo() + vo.getCheckDigit());
			opVo.setCntrNo(vo.getCntrNo());
			opVo.setCntrSealNo(vo.getCntrSealNo());
			opVo.setCntrSvrId(vo.getCntrSvrId());
			opVo.setCntrTpszCd(vo.getCntrTpszCd());
			if (vo.getCreUsrId() != null && !vo.getCreUsrId().equals(""))
				opVo.setCreUsrId(account.getUsr_id());
			else
				opVo.setCreUsrId(vo.getCreUsrId());
			opVo.setDestYdCd(vo.getDestYdCd());
			opVo.setFcntrFlg(vo.getFcntrFlg());
			opVo.setMvmtStsCd(vo.getMvmtStsCd());
			opVo.setOrgYdCd(vo.getOrgYdCd());
			opVo.setVndrSeq(vo.getVndrSeq());
			opVo.setCntrSealNo(vo.getCntrSealNo());
			opVo.setMgstNo(vo.getMgstNo());
			opVo.setCnmvRmk(vo.getCnmvRmk());
			opVo.setMvmtTrspModCd(vo.getMvmtTrspModCd());
			opVo.setSpclCgoFlg(vo.getSpclCgoFlg());
			opVo.setTrnkSkdDirCd(vo.getTrnkSkdDirCd());
			opVo.setTrnkSkdVoyNo(vo.getTrnkSkdVoyNo());
			opVo.setTrnkVslCd(vo.getTrnkVslCd());
			opVo.setCrntSkdDirCd(vo.getCrntSkdDirCd());
			opVo.setCrntSkdVoyNo(vo.getCrntSkdVoyNo());
			opVo.setCrntVslCd(vo.getCrntVslCd());
			opVo.setPolCd(vo.getPolCd());
			opVo.setPodCd(vo.getPodCd());
			opVo.setUsaEdiCd(vo.getUsaEdiCd());
//			String cntrNo = vo.getCntrNo() + vo.getCheckDigit();
			String cntrNo = vo.getCntrNo();

			if (oldCntrNo != null && oldCntrNo.equals(cntrNo)) {
				if (autoExec) {
					opVo.setBkgNoSplit("Y");
				} else {
					opVo.setBkgNoSplit("N");
				}
				opVos[i] = opVo;
			}
			if (oldCntrNo != null && !oldCntrNo.equals(cntrNo)) {
				// in case previous container number exists and that number is different from current container number
				// going to auto creation logic
				begin();
				String[] rtnStrs = null;
				try {
					rtnStrs = manageCreateProcess(opVos, idx, false, true, false);
					if (rtnStrs[0] != null && (rtnStrs[0].equals("N") || rtnStrs[0].equals("I")) ) {
						//opVo.setErrMsg(rtnStrs[1]);
						rollback();
						for (int x = 0; x < idx; x++) {
							opVos[x].setErrMsg(rtnStrs[1]);
							errVos.add(opVos[x]);
							rtnString.append(rtnStrs[1]).append("^^");
							log.debug(rtnStrs[1] + "^^");
						}
					} else {
						commit();
						for (int x = 0; x < idx; x++) {
							rtnString.append(rtnStrs[1]).append("^^");
							log.debug(rtnStrs[1] + "^^");
						}
					}
					opVos = null;
					idx = 0;
					opVos = new CusCtmMovementVO[vos.length+1];
					opVos[idx++] = opVo;
				} catch (Exception ex) {
					/***************************************************************
					 * no throwing in case of failure for handling next data       *
					 ***************************************************************/
					rollback();
					for (int x = 0; x < (idx); x++) {
						opVos[x].setErrMsg(rtnStrs[1]);
						errVos.add(opVos[x]);
						rtnString.append(rtnStrs[1]).append("^^");
						log.debug(rtnStrs[1] + "^^");
					}
					log.error(ex.getMessage(),ex);
				}
			} else {
				//in other cases skipping auto creation and inputing data in array
				opVos[idx] = opVo;
				idx++;
			}
			oldCntrNo = cntrNo;
		}
		// after ending LOOP not processed last container will be handled

		begin();
		String[] rtnStrs = null;
		try {
			log.info("SPP EVENT START ");
			log.info(opVos.length);
			rtnStrs = manageCreateProcess(opVos, idx, false, true, false);
			if (rtnStrs[0] != null && (rtnStrs[0].equals("N") || rtnStrs[0].equals("I"))) {
				rollback();
				for (int x = 0; x < (idx); x++) {
					opVos[x].setErrMsg(rtnStrs[1]);
					errVos.add(opVos[x]);
					rtnString.append(rtnStrs[1]).append("^^");
					log.debug(rtnStrs[1] + "^^");
				}
			} else {
				commit();
				//rollback();
				for (int x = 0; x < (idx); x++) {
					rtnString.append(rtnStrs[1]).append("^^");
					log.debug(rtnStrs[1] + "^^");
				}
			}
		} catch (Exception ex) {
			/***************************************************************
			 * no throwing in case of failure for handling next data *
			 ***************************************************************/
			rollback();
			for (int x = 0; x < (idx); x++) {
				rtnString.append(rtnStrs[1]).append("^^");
				log.debug(rtnStrs[1] + "^^");
				opVos[x].setErrMsg(rtnStrs[1]);
				errVos.add(opVos[x]);
			}
			log.error(ex.getMessage(),ex);
		}

		eventResponse.setRsVoList(errVos);
		//eventResponse.setETCData("rtnStr", rtnString.toString());
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : manageMovement, receiving EDI, receiving SPP(WebService) <br>
	 * registering multiple list of Container Movement Status 
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOS
	 * @param int endCount
	 * @param boolean nBkgNoFlg
	 * @param boolean callType
	 *			- true  : calling from manageInternationalMVMT
	 *			- false : calling from others
	 * @param boolean isReceivedFromEDI
	 *			- true  : received from EqMvmtEDI
	 *			- false : received from others
	 * * @return String[]
	 * @exception EventException
	 */
	public String[] manageCreateProcess(CusCtmMovementVO[] cusCtmMovementVOS, int endCount, boolean nBkgNoFlg, boolean callType, boolean isReceivedFromEDI) throws EventException {
		String[] rtnStr = new String[4];
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
		PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();
		GeneralBookingSearchBC bookingBC = new GeneralBookingSearchBCImpl();
		
		CrossItemVO item = new CrossItemVO();
		String user_Id, user_Nm, ofc_Cd;
		try {
			for (int i = 0; i < endCount; i++) {
				if (cusCtmMovementVOS[i] != null) {
				    // setting endCount as BkgKnt
					cusCtmMovementVOS[i].setBkgKnt(String.valueOf(endCount));
				    // getting current year data
					cusCtmMovementVOS[i].setCnmvYr(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
					// clearing vvd code in case of not VL or not VD
					if (!"VL".equals(cusCtmMovementVOS[i].getMvmtStsCd()) && !"VD".equals(cusCtmMovementVOS[i].getMvmtStsCd())) {
						cusCtmMovementVOS[i].setCrntVslCd("");
						cusCtmMovementVOS[i].setCrntSkdVoyNo("");
						cusCtmMovementVOS[i].setCrntSkdDirCd("");
					}
				}
			}

			// getting ofc_Cd, user_Nm, user_Id
			if (cusCtmMovementVOS[0].getOfcCd() != null && !cusCtmMovementVOS[0].getOfcCd().equals("")) {
				ofc_Cd = cusCtmMovementVOS[0].getOfcCd();
			} else if (account != null) {
				ofc_Cd = account.getOfc_cd();
			} else {
				ofc_Cd = "";
			}

			if (cusCtmMovementVOS[0].getUsrNm() != null && !cusCtmMovementVOS[0].getUsrNm().equals("")) {
				user_Nm = cusCtmMovementVOS[0].getUsrNm();
			}  else if (account != null) {
				user_Nm = account.getUsr_nm();
			} else {
				user_Nm = "";
			}

			if (cusCtmMovementVOS[0].getCreUsrId() != null && !cusCtmMovementVOS[0].getCreUsrId().equals("")) {
				user_Id = cusCtmMovementVOS[0].getCreUsrId();
			} else if (account != null) {
				user_Id = account.getUsr_id();
			} else {
				user_Id = "ETCUSER";
			}
			
			// registering container movemtn information (Container Movement Status Insert)
			item = command.manageStsOperation(cusCtmMovementVOS, user_Id, user_Nm, ofc_Cd, endCount, nBkgNoFlg);

		} catch (Exception ex) {
			/*********************************************************
			 * no throwing in case of failure for handling next data *
			 *********************************************************/
			rtnStr[0] = "N";
			rtnStr[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
			log.error(ex.getMessage(),ex);
			return rtnStr;
		}

		rtnStr = item.getRtnStr();
		CusCtmMovementVO cusVo = null;
		if (rtnStr[0] == null || (rtnStr[0].equals("") || rtnStr[0].equalsIgnoreCase("null")  || rtnStr[0].equals("Y"))) {
			try {
				if (rtnStr[0] != null && rtnStr[0].equals("Y")) {
					int vosLength = 0;
					if (callType) {
						// callType is true means calling from manageInternationalMVMT.
						// skipping last VO in loop
						vosLength = cusCtmMovementVOS.length-1;
					} else {
						// looping as count of VO in case callType is false
						vosLength = cusCtmMovementVOS.length;
					}

					for (int dx = 0; dx < vosLength; dx++) {
						//opVos[dx].setMvmtStsCd(rtnStr[1]);
						cusCtmMovementVOS[dx].setMvmtCreTpCd("R");
						if (rtnStr[0] != null && (rtnStr[1].equals("A") || rtnStr[1].equals("B"))) {
							cusCtmMovementVOS[dx].setNewFlg(rtnStr[1]);    
							// B: creating new MT / C: deleting new MT / X: creating XX / Y: deleting XX of VL and IC
						}
					}
				}
			} catch (Exception ex) {
				/*********************************************************
				 * no throwing in case of failure for handling next data *
				 *********************************************************/
				log.error(ex.getMessage(),ex);
			}

			if (item.getCusCtmMovementVO() != null) {
				cusVo = (CusCtmMovementVO)item.getCusCtmMovementVO().clone();
			} else {
				return item.getRtnStr();
			}

			if (rtnStr[0] != null && rtnStr[0].equals("Y") && rtnStr[1].equals("B")) {
				item.setUpdateMaster(true);
				cusCtmMovementVOS[0].setUpdUsrId(user_Id);
				item.setCusCtmMovementVO(cusCtmMovementVOS[0]);
				rtnStr[1] = "";
			}

			if (rtnStr[0] == null || rtnStr[0].equals("Y") || rtnStr[0].equals("")) {
				try {
					if (rtnStr[0] != null && (rtnStr[0].equals("N") || rtnStr[0].equals("I"))) return rtnStr;
					// MST 호출
					if (item.getUpdateMaster() == true) {
						item.getCusCtmMovementVO().setCntrId(item.getCusCtmMovementVO().getCrntVslCd() + item.getCusCtmMovementVO().getCrntSkdVoyNo() + item.getCusCtmMovementVO().getCrntSkdDirCd());
						ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
						mstCommand.updateCntrMasterByMvmtBasic(item);
					}
				} catch (Exception e) {
					/*********************************************************
					 * no throwing in case of failure for handling next data *
					 *********************************************************/
					rtnStr[0] = "N";
					rtnStr[1] = e.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
					log.error(e.getMessage(),e);
					return rtnStr;
				}

				boolean modifyCntrOpResult = false;
				try {
					// committing even though failure of calling BKG 
					if (item.getMstBkgCntrOpUpdate()) {
						//[2015.05.29] Add Opus BkgNo 과 Oscar BkgNo 분기 처리.
						if(item.getBkgNo().length() == 12){ //[2015.05.29] Add 
							
							String stsCd = item.getCusCtmMovementVO().getMvmtStsCd();
							BLDocumentationCMBC bkgCommand0 = new BLDocumentationCMBCImpl();
							BookingHistoryMgtBC bkgCommand1 = new BookingHistoryMgtBCImpl();
							HistoryLineVO historyLineVO = null;
							if ((stsCd.equals("OP") || stsCd.equals("OC")) && endCount > 1) {
	
								for (int imv = 0; imv < endCount; imv++) {
									if (item.getFindBkgCntr()) {
										// code for confirming attach when calling COP form BKG
										// calling in case of C
										// deleting in case of D(calling from History)
										item.setAttchCd("C");
									} else {
										item.setAttchCd("U");
	
										// calling BKG History management in case of new creation
										historyLineVO = new HistoryLineVO();
										historyLineVO.setBkgNo(cusCtmMovementVOS[imv].getBkgNo());
										historyLineVO.setHisCateNm("Container");
										historyLineVO.setCaFlg("N");
										historyLineVO.setUiId("SYSTEM");
										historyLineVO.setCrntCtnt("Attach Container:" + cusCtmMovementVOS[0].getCntrNo());
										historyLineVO.setBkgDocProcTpCd(null);
										bkgCommand1.createBkgHistoryLine(historyLineVO, account);
									}
	
									item.getCusCtmMovementVO().setBkgNo(cusCtmMovementVOS[imv].getBkgNo());
									// saving ctm_mvmt_irr in case return is ture after saving bkg_container by BKG request (default return is false)
	//								modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);
									BkgCntrMvmtRtnVO bkgCntrMvmtRtnVO = bkgCommand0.modifyCntrOp(item);
									if(bkgCntrMvmtRtnVO.getReturnMessage()!=null) {
										if(isReceivedFromEDI) {
											sendEdiInboundErrorMail(bkgCntrMvmtRtnVO.getReturnMessage());
											throw new Exception(bkgCntrMvmtRtnVO.getReturnMessage());
										}else {
											throw new Exception(bkgCntrMvmtRtnVO.getReturnMessage());
										}
									}
									if(bkgCntrMvmtRtnVO.getReturnFlag().equalsIgnoreCase("Y")) {
										modifyCntrOpResult = true;
									}
	
									//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
									/* creating container NO, Type by bkg_no*/
									formanceCmd.manageQtyCntrCoposite(cusCtmMovementVOS[imv].getBkgNo(), "CN");
									
									//추가 20151012
									String dgCargo = command.searchDgCargo(cusCtmMovementVOS[imv].getBkgNo()); 
									
									if (stsCd.equals("OP") && "N".equals(dgCargo)) {
										
							           Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
							           // VO parameter 설정을 위한 변수 선언 
							           BkgBlNoVO bkgBlNoVO = new BkgBlNoVO(); 
							           bkgBlNoVO.setBkgNo(cusCtmMovementVOS[imv].getBkgNo());                                 // Booking Number
							           bkgBlNoVO.setHisUiNm("CTM"); 
							           String ediKind = "BT";                                                             // EDI Kind : CN(301F) 
							           String autoManualFlg = "N";            
							           // Auto/Manual Flag : N(Manual) 

							           // BKG 메소드 호출을 위한 VO Parameter 설정 
							           vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);                            // BKG_NO : 필수 
							           vender301ParamVO.setEdiKind(ediKind);                                       // EDIKind : 필수 
							           vender301ParamVO.setAutoManualFlg(autoManualFlg);                   // autoManualFlag : 필수 
							           // BKG쪽 Terminal EDI 발송용 BackEnd 메소드 호출 
							           List<BkgNtcHisVO> bkgNtcHisVOs = bookingBC.createTmlBkgReceiptEdi(vender301ParamVO, account); 
							           for(int i=0;i<bkgNtcHisVOs.size();i++){
//											bkgNtcHisVOs.get(i).setSndId("SYSTEM");		
							        	   bkgNtcHisVOs.get(i).setHisUiNm("CTM");
							           }
							           bkgCommand1.createBkgNtcHis(bkgNtcHisVOs, "");
									}
								}
	
							} else {
	
								if (item.getFindBkgCntr()) {
									// code for confirming attach when calling COP form BKG
									// calling in case of C
									// deleting in case of D(calling from History)
									item.setAttchCd("C");
								} else {
									item.setAttchCd("U");
	
									// calling BKG History management in case of new creation
									historyLineVO = new HistoryLineVO();
									historyLineVO.setBkgNo(item.getBkgNo());
									historyLineVO.setHisCateNm("Container");
									historyLineVO.setCaFlg("N");
									historyLineVO.setUiId("SYSTEM");
									historyLineVO.setCrntCtnt("Attach Container:" + cusCtmMovementVOS[0].getCntrNo());
									historyLineVO.setBkgDocProcTpCd(null);
									bkgCommand1.createBkgHistoryLine(historyLineVO, account);
	
								}
								// saving ctm_mvmt_irr in case return is ture after saving bkg_container by BKG request (default return is false)
	//							modifyCntrOpResult = bkgCommand0.modifyCntrOp(item);
								BkgCntrMvmtRtnVO bkgCntrMvmtRtnVO = bkgCommand0.modifyCntrOp(item);
								if(bkgCntrMvmtRtnVO.getReturnMessage()!=null) {
									if(isReceivedFromEDI) {
										sendEdiInboundErrorMail(bkgCntrMvmtRtnVO.getReturnMessage());
										throw new Exception(bkgCntrMvmtRtnVO.getReturnMessage());
									}else {
										throw new Exception(bkgCntrMvmtRtnVO.getReturnMessage());
									}
								}
								if(bkgCntrMvmtRtnVO.getReturnFlag().equalsIgnoreCase("Y")) {
									modifyCntrOpResult = true;
								}
	
								//2011.03.08 BKG  [CHM-201109320] Brisbane booking missing boxes
								/* creating container NO, Type by bkg_no*/
								formanceCmd.manageQtyCntrCoposite(item.getBkgNo(), "CN");
								
								//추가 20151012
								String dgCargo = command.searchDgCargo(cusCtmMovementVOS[0].getBkgNo()); 
								
								if (stsCd.equals("OP") && "N".equals(dgCargo)) {
									
						           Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
						           // VO parameter 설정을 위한 변수 선언 
						           BkgBlNoVO bkgBlNoVO = new BkgBlNoVO(); 
						           bkgBlNoVO.setHisUiNm("CTM"); 
						           bkgBlNoVO.setBkgNo(cusCtmMovementVOS[0].getBkgNo());                                 // Booking Number 
						           String ediKind = "BT";                                                             // EDI Kind : CN(301F) 
						           String autoManualFlg = "N";                                                     // Auto/Manual Flag : N(Manual) 

						           // BKG 메소드 호출을 위한 VO Parameter 설정 
						           vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);                            // BKG_NO : 필수 
						           vender301ParamVO.setEdiKind(ediKind);                                       // EDIKind : 필수 
						           vender301ParamVO.setAutoManualFlg(autoManualFlg);                   // autoManualFlag : 필수 
						           // BKG쪽 Terminal EDI 발송용 BackEnd 메소드 호출 
						           List<BkgNtcHisVO> bkgNtcHisVOs = bookingBC.createTmlBkgReceiptEdi(vender301ParamVO, account); 
						           for(int i=0;i<bkgNtcHisVOs.size();i++){
//										bkgNtcHisVOs.get(i).setSndId("SYSTEM");			
						        	   bkgNtcHisVOs.get(i).setHisUiNm("CTM");			
						           }
						           bkgCommand1.createBkgNtcHis(bkgNtcHisVOs, "");
								}
							
							}
							
						}else if(item.getBkgNo().length() == 10){//[2015.05.29] Add
							log.debug("\n manageCreateProcess Oscar BkgNo ["+item.getBkgNo()+"]");
							//[2015.05.29] Add UpdateOscarContainerMove Call.
							CusCtmMovementVO cusCtmMovementVO = item.getCusCtmMovementVO();
							if(cusCtmMovementVO != null){
								log.debug("\n manageCreateProcess Oscar BkgNo ["+item.getBkgNo()+"] updateOscarContainerMove Call.");
								command.updateOscarContainerMove(cusCtmMovementVO, account);
							}
						}
					}
				} catch (Exception e) {
					/*********************************************************
					 * no throwing in case of failure for handling next data *
					 *********************************************************/
					rtnStr[0] = "N";
					rtnStr[1] = e.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
					log.error(e.getMessage(),e);
					return rtnStr;
				}

				try {
					// committing even though failure of calling STOCK
					String preSts = (item.getPrevSts() == null ? "": item.getPrevSts());
					if ( "EUR".equals(cusVo.getCntrSvrId()) ) {
						String stsCd = (cusVo.getMvmtStsCd() == null ? "": cusVo.getMvmtStsCd());
						log.info("PREV ::: " + preSts + stsCd);
						if ("VL".equals(stsCd) || "XX".equals(stsCd) || "OP".equals(stsCd) || "MT".equals(stsCd) || ( ("EN".equals(stsCd) || "TN".equals(stsCd)) && "MT".equals(preSts)) ){
							com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBC emptyCommand =
								new com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl();
							emptyCommand.updateCimCntrStk(item);
						}
					}

					// committing even though failure of calling COP
					String fCntr = item.getCusCtmMovementVO().getFcntrFlg();
					//if ((("F".equals(fCntr) || "Y".equals(fCntr)) || "F".equals(cusVo.getBkgCgoTpCd())) && cusVo.getBkgNo() != null && !"".equals(cusVo.getBkgNo())) {
					if ( (("F".equals(fCntr) || "Y".equals(fCntr)) || "F".equals(cusVo.getBkgCgoTpCd()) || "R".equals(cusVo.getBkgCgoTpCd())) && cusVo.getBkgNo() != null && !"".equals(cusVo.getBkgNo()) && cusVo.getBkgNo().length()==12) {

						com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO sceVO =
							new com.clt.apps.opus.esd.sce.copdetailreceive.vo.SceActRcvIfVO();
						com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand =
							new com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();

						sceVO.setCntrNo(cusVo.getCntrNo());
						sceVO.setBkgNo(cusVo.getBkgNo());
						sceVO.setNodCd(cusVo.getOrgYdCd());
						sceVO.setActStsMapgCd(cusVo.getMvmtStsCd());
						sceVO.setActDt(cusVo.getCnmvEvntDt());
						sceVO.setEdiMsgTpCd(cusVo.getMvmtEdiMsgTpId());
						sceVO.setCreTpCd(cusVo.getMvmtCreTpCd());
						sceVO.setCreUsrId(cusVo.getCreUsrId());
						sceVO.setVndrSeq(cusVo.getVndrSeq());
						sceVO.setVslCd(cusVo.getCrntVslCd());
						sceVO.setSkdVoyNo(cusVo.getCrntSkdVoyNo());
						sceVO.setSkdDirCd(cusVo.getCrntSkdDirCd());
						sceVO.setBndVskdSeqCd(cusVo.getIbflag());

						sceVO.setCnmvYr(cusVo.getCnmvYr());
						sceVO.setCnmvIdNo(cusVo.getCnmvIdNo());
						sceVO.setCnmvSeq(cusVo.getCnmvSeq());
						sceVO.setCnmvSplitNo(cusVo.getCnmvSplitNo());
						sceVO.setCnmvCycNo(cusVo.getCnmvCycNo());
						sceVO.setImdtExtFlg(cusVo.getImdtExtFlg());

						sceCommand.createCOPMVMT(sceVO);
					}

					// saving ctm_mvmt_irr in case return is ture after saving bkg_container by BKG request (default return is false)
					String rtn = command.updateEtcModule(item, modifyCntrOpResult);
					if (rtn.equals("N")) {
						rtnStr[0] = "N";
						rtnStr[1] = "Insert irr fail!";
					}

					// calling MNR in case item.getMnrCallYN() = 'Y' only 2010.09.03
					// setting flag to call MNR in case status of manageStsOperation is OP and Damage Flag from MST_CONTAINER is Y
					if ("Y".equals(item.getMnrCallYN())) {

						com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC mnrCommand =
							new com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl();
						com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO customMnrEqStsVO =
							new com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO();

						/* mandatory input value
						 *  customMnrEqStsVO.setEqNo(*** );
						 *	customMnrEqStsVO.setEqKndCd(***);
						 *	customMnrEqStsVO.setEqTpszCd(***);
						 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);
						 *  customMnrEqStsVO.setMnrDmgFlg(***);
						 *  customMnrEqStsVO.setMnrFlgInpDt(***);
						 *  customMnrEqStsVO.setMnrFlgRmk(***);
						 *  customMnrEqStsVO.setMnrFlgInpTpCd(***);
						 *  matching table :  MNR_EQ_STS
						 */
						
						String dmgFlg = item.getCusCtmMovementVO().getCntrDmgFlg();
						String evntDt = "";
						
						if ("Y".equals(dmgFlg)) {
							dmgFlg = "1";
							evntDt = item.getCusCtmMovementVO().getDmgFlgDt();
						} else {
							dmgFlg = "0";
							evntDt = item.getCusCtmMovementVO().getDmgUnflgDt();
						}
						
						customMnrEqStsVO.setMnrDmgFlg(dmgFlg);    // flaging : '1', unflaging '0'
//						customMnrEqStsVO.setMnrDmgFlg("0");    // flaging : '1', unflaging '0'
						customMnrEqStsVO.setEqKndCd("U");    // Container=> U, Chassis=> Z, GenSet=> G
						customMnrEqStsVO.setEqNo(item.getCusCtmMovementVO().getCntrNo());    // Container No
						customMnrEqStsVO.setEqTpszCd(item.getCusCtmMovementVO().getCntrTpszCd());    // Type/Size
						customMnrEqStsVO.setMnrDmgFlgYdCd(item.getCusCtmMovementVO().getOrgYdCd());    // yard code occurring damage flagging/unflagging
						customMnrEqStsVO.setMnrFlgInpDt(evntDt);
						customMnrEqStsVO.setMnrFlgRmk("Auto-created by CTM ("+item.getCusCtmMovementVO().getMvmtStsCd()+")");
						customMnrEqStsVO.setMnrFlgInpTpCd("V"); //V:Movement, M:Manual

						if(account == null || "".equals(account)){
							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
							String today = formatter.format(new java.util.Date());
							account = new SignOnUserAccount(item.getCusCtmMovementVO().getUpdUsrId(),null,null,null,null,null,null,null, item.getCusCtmMovementVO().getUpdUsrId(), today , item.getCusCtmMovementVO().getUpdUsrId(), today, item.getCusCtmMovementVO().getOfcCd(), null, null, null, null, null, null, null, null, null);									
						}

						mnrCommand.manageIFFlagForOtherBasic(customMnrEqStsVO, account);
						
					}
					
					List<CusCtmMovementVO> movementVOs = item.getCusCtmMovementVOs();					
					
					if(movementVOs != null && movementVOs.size() > 0) {
						try {
							for(int i = 0 ; i < movementVOs.size(); i++) {
								if (movementVOs.get(i).getMvmtCreTpCd() == null || !"C".equals(movementVOs.get(i).getMvmtCreTpCd())) {
									log.info("TRS temp log : " + movementVOs.get(i).getMvmtStsCd());
									new WorkOrderManagementBCImpl().modifyWorkOrderExecuteDate(movementVOs.get(i).getCntrNo(),  movementVOs.get(i).getCnmvEvntDt(),  movementVOs.get(i).getWoNo(),  movementVOs.get(i).getOrgYdCd(), movementVOs.get(i).getMvmtStsCd(), movementVOs.get(i).getBkgNo(),  movementVOs.get(i).getUpdUsrId(), movementVOs.get(i).getMvmtCreTpCd());	
								}
							}
						} catch(Exception e) {
							log.error("Error-[TRS]modifyWorkOrderExecuteDate " + e.toString(), e);
						}
					}

//					CusCtmMovementVO movementVO = item.getCusCtmMovementVO();
//					if(movementVO != null) {
//						//try {
//							new WorkOrderManagementBCImpl().modifyWorkOrderExecuteDate(movementVO.getCntrNo(),  movementVO.getCnmvEvntDt(),  movementVO.getWoNo(),  movementVO.getOrgYdCd(), movementVO.getMvmtStsCd(), movementVO.getBkgNo(),  movementVO.getUpdUsrId());
//						//} catch(Exception e) {
//						//	log.error("Error-[TRS]modifyWorkOrderExecuteDate " + e.toString(), e);
//						//}
//					}
				} catch (Exception ex) {
					/*********************************************************
					 * no throwing in case of failure for handling next data *
					 *********************************************************/
					log.error("err " + ex.toString(), ex);
				}
			}
		}
		return rtnStr;
	}

	/**
	 * EES_CTM_0406 : TextBox (VVD CODE) On Change<br>
	 * retrieving ETA/ ETD Time with Yard and VVD Code
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getEtaEtdTime(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			String rtnStr = command.getEtaEtdTime(event.getSearchCLMInfoVO());
			eventResponse.setETCData("rtnStr", rtnStr);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/** getVvd
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse getVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			String rtnStr = command.getVvd(event.getSearchCLMInfoVO());
			eventResponse.setETCData("rtnStr", rtnStr);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * EES_CTM_0406 : btn_precheck<br>
	 * validating VL Pre Check
	 * handling event fo Pre Check button before saving 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPREVLVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			CtmCntrMovInfoVO[] vos = event.getCtmCntrMovInfoVOS();
			String oscaBkgFlg = event.getCusCtmMovementVO().getOscaBkgFlg();
			
			String[][] rtnStr = command.checkPREVLVD(vos, account, oscaBkgFlg);
			StringBuffer rtnValue = new StringBuffer();
			for (int i = 0; i < rtnStr.length; i++)
				rtnValue.append(rtnStr[i][0]).append("||");

			eventResponse.setETCData("rtnStr", rtnValue.toString());
			eventResponse.setETCData("errCount", rtnStr[0][1]);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0458 : onLoad<br>
	 * returning count of booking's containers by type/size 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingQTY(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0458Event event = (EesCtm0458Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<BookingQTYVO> list = command.searchBookingQTY(event.getBookingQTY());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0433 : onLoad<br>
	 * returning count of booking's containers by type/size 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCNTRList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0433Event event = (EesCtm0433Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<BkgCNTRListVO> list = command.searchCNTRList(event.getBookingQTY());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : btn_save<br>
	 * registering reservation information in CTM_MVMT_RSV table
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resMovement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			begin();
			CtmCntrMovInfoVO[] vos = event.getCtmCntrMovInfoVOS();
			command.resMovement(vos,account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : Container Movement Change<br>
	 * auto retrieving in case of change of containers
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVLVDPreChk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			CtmCntrMovInfoVO vos = event.getCtmCntrMovInfoVO();
			String oscaBkgFlg = event.getCusCtmMovementVO().getOscaBkgFlg();

			String rtnStr = command.checkVLVDPreChk(vos, oscaBkgFlg);
			eventResponse.setETCData("rtnStr", rtnStr);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : Container Movement Change<br>
	 * auto retrieving in case of change of containers
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVVDPreChkOnVslSkd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			SearchCLMInfoVO vos = event.getSearchCLMInfoVO();
			String rtnStr = command.checkVVDPreChkOnVslSkd(vos);
			eventResponse.setETCData("rtnStr", rtnStr);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * MQ Inbound : MQProxy<br> / EES_CTM_0000(GATENEW test page) : btn_save
	 * handling multiple event for GATENEW 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse gateNew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UbizComOpusCtmEqmvmtEvent eaiMqEvent = null;
		EesCtm0000Event uiTestEvent = null;
		String eventName = e.getEventName();

		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
		FlatFileForGateNewVO[] flatFileVOs = null;
		try {
			if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
				eaiMqEvent = (UbizComOpusCtmEqmvmtEvent)e;
				flatFileVOs = gatenewCommand.assignFlatFileVO(eaiMqEvent.getFlatFile());
			} else {
				uiTestEvent = (EesCtm0000Event)e;
				if (uiTestEvent.getInputRadio().equals("SHEET")) {
					flatFileVOs = uiTestEvent.getFlatFileVOS();
				} else {
					flatFileVOs = gatenewCommand.assignFlatFileVO(uiTestEvent.getFlatFileText());
				}
			}
		} catch (EventException ex) {
			if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
				sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
			}
			throw ex;
		}

		List<SearchEDIMovementListVO> searchEDIMovementListVOlist = new ArrayList<SearchEDIMovementListVO>();
		FlatFileForGateNewVO flatFileForGateNewVO = null;
		SearchEDIMovementListVO searchEDIMovementListVO = null;
		if ( flatFileVOs != null ) {
			for ( int jj=0; jj<flatFileVOs.length; jj++ ) {
				log.info("\n\n===============================================================" +
						  "\n [BATCH] GateNew() - Begin!" +
						  "\n===============================================================\n");
				flatFileForGateNewVO = null;
				searchEDIMovementListVO = null;

				try {
					log.info("\n\n===============================================================" +
							  "\n begin_flatFile : ColumnValues" +
							  "\n======================================" +
							  "\n" + flatFileVOs[jj].getColumnValues().toString().replaceAll(", ", "\n") +
							  "\n======================================" +
							  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileVOs[jj].getBkgNumber()) +
							  "\n===============================================================\n");
					begin();    // gateNew BEGIN
					flatFileForGateNewVO = gatenewCommand.gateNew(flatFileVOs[jj]);
					commit();
					log.info("\n\n===============================================================" +
							  "\n finish_flatFile : ColumnValues" +
							  "\n======================================" +
							  "\n" + flatFileForGateNewVO.getColumnValues().toString().replaceAll(", ", "\n") +
							  "\n======================================" +
							  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileForGateNewVO.getBkgNumber()) +
							  "\n===============================================================\n");
				} catch (EventException ex) {
					/*********************************************************
					 * no throwing in case of failure for handling next data *
					 *********************************************************/
					rollback();
					log.error("\n\n [BATCH] GateNew() : EventException\n" + ex.toString(), ex);
					if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
						sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
					}
				} catch (Exception ex) {
					/*********************************************************
					 * no throwing in case of failure for handling next data *
					 *********************************************************/
					rollback();
					log.error("\n\n [BATCH] GateNew() : Exception\n" + ex.toString(), ex);
					if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
						sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
					}
				}

				if ( flatFileForGateNewVO != null ) {
					try {
						if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
							flatFileForGateNewVO = manageGateNewProcess(flatFileForGateNewVO, true);
						}else{
							flatFileForGateNewVO = manageGateNewProcess(flatFileForGateNewVO, false);
						}
					} catch (EventException ex) {
						/*********************************************************
						 * no throwing in case of failure for handling next data *
						 *********************************************************/
						rollback();
						log.error("\n\n manageGateNewProcess : EventException\n" + ex.toString(), ex);
						if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
							sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
						}
					} catch (Exception ex) {
						/*********************************************************
						 * no throwing in case of failure for handling next data *
						 *********************************************************/
						rollback();
						log.error("\n\n manageGateNewProcess : Exception\n" + ex.toString(), ex);
						if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
							sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
						}
					} finally {

						/* skipping in case message is US 322 and gate status is AR(Rail Arrival At Destination Inter modal Ramp)  */
//						if ( "322".equals(flatFileForGateNewVO.getMsgId()) && "UR".equals(flatFileForGateNewVO.getGateIo() ) ) {
//							/* throwing only in case EES_CTM_0000 */
//							if ( eventName.equals("EesCtm0000Event") ) {
//								throw new EventException(new ErrorHandler("[MsgId : 322 & GateIo : AR] Case. GateNew Skip!").getMessage());
//							} else {
//								log.info("\n\n=============================================================== [MsgId : 322 & GateIo : AR] Case = > Skip\n");
//							}
//						} else {
							flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber()[0] == null ? "" : flatFileForGateNewVO.getBkgNumber()[0] + "");
							// AssignFlatFileVO2EdiUiVO for GateNew ////////////////////////////
							try {
								searchEDIMovementListVO = gatenewCommand.assignFlatFileVO2EdiUiVO(flatFileForGateNewVO, new SearchEDIMovementListVO());
							} catch (EventException ex) {
								if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
									sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
								}
								throw ex;
							}
							// rty_knt
							searchEDIMovementListVO.setRtyKnt("0");
							try {
								begin();    // resultUpdb BEGIN
								log.info("\n\n===============================================================" +
										  "\n resultUpdb()" +
										  "\n===============================================================\n");
								searchEDIMovementListVOlist.add(gatenewCommand.resultUpdb(searchEDIMovementListVO));	
								commit();
								
								if ("Y".equals(searchEDIMovementListVO.getMvmtEdiRsltCd()) && "ST".equals(flatFileForGateNewVO.getGateIo())) {
									CrossItemVO item = new CrossItemVO();	
									CrossItemVO mnrItem = new CrossItemVO();
									ContainerMovementMgtBC mgtCommand = new ContainerMovementMgtBCImpl();

									begin();
									item = mgtCommand.modifyCNTRStatus(gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1), account);
									
									String[] rtnStrs = null;
									rtnStrs = item.getRtnStr();
									
									if (rtnStrs[0] == null || rtnStrs[0].equals("X") || rtnStrs[0].equals("")) {
										if (rtnStrs[0] != null && rtnStrs[0].equals("X")) {
											mnrItem = mgtCommand.modifyDMGHistory(item, account);
											rtnStrs = mnrItem.getRtnStr();
										}
									}
									
									if (rtnStrs[0] != null && (rtnStrs[0].equals("N"))) {
										rollback();
									} else {
										commit();
									}
									
									flatFileForGateNewVO.setResultIndicator(rtnStrs[0]);
									flatFileForGateNewVO.setResultMessage(rtnStrs[1]);
								}			
							} catch (EventException ex) {
								/******************************************************
								 * no throwing in case of failure for handling next data   *
								 ******************************************************/
								rollback();
								log.error("\n\n resultUpdb : EventException\n" + ex.toString(), ex);
								if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
									sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
								}
							} catch (Exception ex) {
								/******************************************************
								 * no throwing in case of failure for handling next data   *
								 ******************************************************/
								rollback();
								log.error("\n\n resultUpdb : Exception\n" + ex.toString(), ex);
								if (eventName.equals("UbizComOpusCtmEqmvmtEvent")) {
									sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
								}
							}
//						}
					}
				}
				log.info("\n\n===============================================================" +
						  "\n [BATCH] GateNew() - Finish!" +
						  "\n===============================================================\n");
			}
		}
		eventResponse.setRsVoList(searchEDIMovementListVOlist);
		return eventResponse;
	}

	/**
	 * SC : gateNew / manageEDIMovement 
	 * handling GATENEW Process 
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param boolean isReceivedFromEDI
	 *			- true  : received from EqMvmtEDI
	 *			- false : received from others
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 */
	private FlatFileForGateNewVO manageGateNewProcess(FlatFileForGateNewVO flatFileForGateNewVO, boolean isReceivedFromEDI) throws EventException {
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
		String[] returnValues = new String[2];

		/* in case @checkNassignData result is Y*/
		if ( "Y".equals(flatFileForGateNewVO.getCheckNassignData()) ) {

			/* calling createChassisMovement in case Chassis Case */
			if ( "Y".equals(flatFileForGateNewVO.getChssCase()) ) {
				/* calling related service in case received data for requested 322 data through gatenew is Chassis( As Is : chs_dbup.pc) */
				log.info("\n\n===============================================================" +
						 "\n Chassis - manageCHSMovementBareByGatenewBasic 호출" +
						 "\n===============================================================\n");
				try {
					ChassisMovementHistoryBC cgmCommand = new ChassisMovementHistoryBCImpl();
					begin();    // Chassis BEGIN
					returnValues = cgmCommand.manageCHSMovementBareByGatenewBasic( flatFileForGateNewVO );
					commit();    //  Chassis COMMIT
				} catch (EventException ex) {
					/*********************************************************
					 * no throwing in case of failure for handling next data *
					 *********************************************************/
					rollback();    // Chassis ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Chassis ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
				} catch (Exception ex) {
					rollback();    // Chassis ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Chassis ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CHASSIS_STS 1 : " + returnValues[1] +
						 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CHASSIS_MSG 1 : " + returnValues[0] + "\n");

				// 정상처리일때 return값 : returnValues[0] = "", returnValues[1] = "Y"
				if ( returnValues[0].equals("") && returnValues[1].equals("Y") ) {    /* Error가 아닐때 */
					flatFileForGateNewVO.setResultMessage("OK.PROCESSED");
					flatFileForGateNewVO.setResultIndicator("Y");

				} else {    /* Error 발생시 */
					flatFileForGateNewVO.setResultMessage(returnValues[0].trim());
					flatFileForGateNewVO.setResultIndicator("N");

				}

			} else if ( "Y".equals(flatFileForGateNewVO.getMgsCase()) ) {
				/* calling related service in case received data for requested 322 data through gatenew is Mgset */
				log.info("\n\n===============================================================" +
						 "\n Mgset - manageMGSMovementBareByGatenewBasic 호출" +
						 "\n===============================================================\n");
				try {
					MgsetMovementHistoryBC cgmCommand2 = new MgsetMovementHistoryBCImpl();
					begin();    // Mgset BEGIN
					returnValues = cgmCommand2.manageMGSMovementBareByGatenewBasic( flatFileForGateNewVO );
					commit();    //  Mgset COMMIT
				} catch (EventException ex) {
					/*********************************************************
					 * no throwing in case of failure for handling next data *
					 *********************************************************/
					rollback();    // Mgset ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Mgset ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
				} catch (Exception ex) {
					rollback();    // Mgset ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Mgset ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% MGSET_STS 1 : " + returnValues[1] +
						 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% MGSET_MSG 1 : " + returnValues[0] + "\n");

				// 정상처리일때 return값 : returnValues[0] = "", returnValues[1] = "Y"
				if ( returnValues[0].equals("") && returnValues[1].equals("Y") ) {    /* Error가 아닐때 */
					flatFileForGateNewVO.setResultMessage("OK.PROCESSED");
					flatFileForGateNewVO.setResultIndicator("Y");

				} else {    /* Error 발생시 */
					flatFileForGateNewVO.setResultMessage(returnValues[0].trim());
					flatFileForGateNewVO.setResultIndicator("N");

				}

			} else {    /* in case Chassis Case is not Y*/

				/* calling CTM-COMMON in case Mvmt Status is not "ER", "ZZ", "" */
				if ( !"ER".equals(flatFileForGateNewVO.getMvmtStatus()) && !"ZZ".equals(flatFileForGateNewVO.getMvmtStatus()) ) {

					/* @generateMovement (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					CusCtmMovementVO[] setCustVOs = null;
					/* _______________________________________________________________________________________________________________________ */
					/* ____________________________________________________________________________________________________________OP, OC Case */
					
					ContainerMovementMgtForGateNewBCImpl cntMvntMgtForGateNewCommand = new ContainerMovementMgtForGateNewBCImpl();
					int domesticCheck = cntMvntMgtForGateNewCommand.searchDomsticBooking(flatFileForGateNewVO.getBkgNumber()[0]);
					if ( ("OP".equals(flatFileForGateNewVO.getMvmtStatus()) || "OC".equals(flatFileForGateNewVO.getMvmtStatus()))
							 && domesticCheck == 0) {
					//String domesticCheck = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 4);
					/*if ( ("OP".equals(flatFileForGateNewVO.getMvmtStatus()) || "OC".equals(flatFileForGateNewVO.getMvmtStatus()))
							  && (!"DLAX".equals(domesticCheck) && !"DCHI".equals(domesticCheck) && !"DHOU".equals(domesticCheck) && !"DMEM".equals(domesticCheck)
							  && !"DNYC".equals(domesticCheck) && !"DSEA".equals(domesticCheck) && !"TCHI".equals(domesticCheck)) ) {*/

						/* calling MVMT Common1 (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						log.info("\n\n===============================================================" +
								 "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common 호출1" +
								 "\n===============================================================\n");
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, (flatFileForGateNewVO.getBkgNumber() == null ? 0 : flatFileForGateNewVO.getBkgNumber().length));
							begin();    // COMMON BEGIN
							returnValues = manageCreateProcess(setCustVOs, setCustVOs.length, false, false, isReceivedFromEDI);
							if ( "N".equals(returnValues[0]) ) {
								rollback();    // COMMON ROLLBACK
							} else {
								commit();    //  COMMON COMMIT
							}
						} catch (EventException ex) {
							/*********************************************************
							 * no throwing in case of failure for handling next data *
							 *********************************************************/
							rollback();    // COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage();
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
							rollback();    // COMMON ROLLBACK
							flatFileForGateNewVO.setResultIndicator("N");
							flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (MVMT Common ERROR)");
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS 1 : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG 1 : " + returnValues[1] + "\n");
						/* calling MVMT Common1 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


					}
					/* _______________________________________________________________________________________________________________________ */
					/* _________________________________________________________________________________________________________ Domestic Case */
					else if ( "USA".equals(flatFileForGateNewVO.getMuidArea())
							 && domesticCheck != 0) {
							 /* && ("DLAX".equals(domesticCheck) || "DCHI".equals(domesticCheck) || "DHOU".equals(domesticCheck) || "DMEM".equals(domesticCheck)
							  || "DNYC".equals(domesticCheck) || "DSEA".equals(domesticCheck) || "TCHI".equals(domesticCheck)) ) {*/

						/* Domestic MVMT Common 호출 (S) ++++++++++++++++++++++++++++++++++++++++++++++++++*/
						log.info("\n\n===============================================================" +
								 "\n manageDomesticMVMT(vos[0], account) ++++++ Domestic MVMT Common 호출" +
								 "\n===============================================================\n");
						
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1 );
							ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
							begin();    // Domestic-COMMON BEGIN
							CrossItemVO item = command.manageDomesticMVMT(setCustVOs[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 2));
							returnValues = item.getRtnStr();
							if ( "N".equals(returnValues[0]) ) {
								rollback();    // Domestic-COMMON ROLLBACK
							} else {
								
								if (item.getUpdateMaster() == true) {
									ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
									mstCommand.updateCntrMasterByMvmtBasic(item);
								}
								commit();    //  Domestic-COMMON COMMIT
							}
							
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
							if(item.getSceActRcvIfVOs().size() > 0){
								com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
									new com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
								
								for(int i = 0; i < item.getSceActRcvIfVOs().size(); i++){
									if(item.getSceActRcvIfVOs().get(i).getBkgNo()!=null && item.getSceActRcvIfVOs().get(i).getBkgNo().length()==12){
										sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i));
									}
										
								}
							}
							// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)

						} catch (EventException ex) {
							/******************************************************
							 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음   *
							 ******************************************************/
							rollback();    // Domestic-COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
							rollback();    // Domestic-COMMON ROLLBACK
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_STS : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_MSG : " + returnValues[1] + "\n");
						/* Domestic MVMT COmmon 호출 (E) ++++++++++++++++++++++++++++++++++++++++++++++++++*/


					}					
					/* _______________________________________________________________________________________________________________________ */
					/* __________________________________________________________________________________ International MVMT ( Except OP, OC ) */
					else {

						boolean nBkgNoFlg = false;
						/*** 2015.04.28 Changed by Mark Lee : Change to process the VD Movement for MT  Start
						 * As-Is
						 * if ( "VL".equals(flatFileForGateNewVO.getMvmtStatus()) && "Y".equals(flatFileForGateNewVO.getNBkgNoFlg()) ) {
						 * 
						 * To-Be
						 * if (("VL".equals(flatFileForGateNewVO.getMvmtStatus()) || "VD".equals(flatFileForGateNewVO.getMvmtStatus())) && "Y".equals(flatFileForGateNewVO.getNBkgNoFlg()) ) {
						***/
						if (("VL".equals(flatFileForGateNewVO.getMvmtStatus()) || "VD".equals(flatFileForGateNewVO.getMvmtStatus())) && "Y".equals(flatFileForGateNewVO.getNBkgNoFlg()) ) {
							nBkgNoFlg = true;
						}

						/* calling MVMT Common2 (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						log.info("\n\n===============================================================" +
								 "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common 호출2" +
								 "\n===============================================================\n");
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1 );
							begin();    // COMMON BEGIN
							returnValues = manageCreateProcess(setCustVOs, setCustVOs.length, nBkgNoFlg, false, isReceivedFromEDI);
							if ( "N".equals(returnValues[0]) ) {
								rollback();    // COMMON ROLLBACK
							} else {
								commit();    //  COMMON COMMIT
							}
						} catch (EventException ex) {
							/*********************************************************
							 * no throwing in case of failure for handling next data *
							 *********************************************************/
							rollback();    // COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage();
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
							rollback();    // COMMON ROLLBACK
							flatFileForGateNewVO.setResultIndicator("N");
							flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (MVMT Common ERROR)");
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS 2 : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG 2 : " + returnValues[1] + "\n");
						/* calling MVMT Common2 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

					}
					/* @generateMovement (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				}

				if (returnValues[0] == null || returnValues[0].trim().equals("") || returnValues[0].trim().equals("null")) {
					returnValues[0] = "";
				} else {
					returnValues[0] = returnValues[0].trim();
				}
				if (returnValues[1] == null || returnValues[1].trim().equals("") || returnValues[1].trim().equals("null")) {
					returnValues[1] = "";
				} else {
					returnValues[1] = returnValues[1].trim();
				}

				// result값을 returnVo에 setting
				flatFileForGateNewVO.setResultIndicator(returnValues[0]);
				flatFileForGateNewVO.setResultMessage(returnValues[1]);
			}
		}
		return flatFileForGateNewVO;
	}

	
	
	/**
	 * MQ Inbound : MQProxy<br> / EES_CTM_0000(GATENEW test page) : btn_save
	 * handling multiple event for GATENEW 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse gateEppBookingNew(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RobkgToOpusCtmEqmvmtEvent eaiRobkgToMqEvent = null;
		EesCtm0000Event eaiMqEvent = null;
		String eventName = e.getEventName();
		
		ContainerMovementMgtForGateNewBC Command = new ContainerMovementMgtForGateNewBCImpl();
		List<SearchEDICtmEqMvmtListVO> flatFileVOs = null;
		
//		try {
			if (eventName.equals("RobkgToOpusCtmEqmvmtEvent")) { //RobkgToOpusCtmEqmvmtEvent
				eaiRobkgToMqEvent = (RobkgToOpusCtmEqmvmtEvent)e;
				begin();
				flatFileVOs        = Command.setEppBookingNew(eaiRobkgToMqEvent.getFlatFile());
				commit(); 
				
//			} 
			} else {
				eaiMqEvent = (EesCtm0000Event)e;
				begin();
				flatFileVOs = Command.setEppBookingNew(eaiMqEvent.getFlatFileText());
				commit(); 
				
			}

//		} catch (EventException ex) {
//			if (eventName.equals("RobkgToOpusCtmEqmvmtEvent")) {
//				sendEaiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
//				insertEaiInboundError(eaiRobkgToMqEvent.getFlatFile(), ExceptionUtils.getStackTrace(ex));
//			} else if (eventName.equals("EesCtm0000Event")) {
//				sendEdiInboundErrorMail(ExceptionUtils.getStackTrace(ex));
//				insertEdiInboundError(eaiEvent.getFlatFileText(), ExceptionUtils.getStackTrace(ex));
//			}
//			throw ex;
//		}
		
//		eventResponse.setRsVoList(flatFileVOs);
		return eventResponse;
	}
	
	
	/**
	 * EES_CTM_0407 : btn_save<br>
	 * Domestic Container Movement Grid내용을 저장한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDomesticMVMT(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0407Event event = (EesCtm0407Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		ContainerMovementValidationBC commonCommand = new ContainerMovementValidationBCImpl();
		StringBuffer srtRes = new StringBuffer();
		CusCtmMovementVO[] vos = event.getCtmMovementVOS();
		for (int i = 0; i < vos.length; i++) {
			try {
				begin();
				vos[i].setCreUsrId(account.getUsr_id());
				vos[i].setUpdUsrId(account.getUsr_id());
				vos[i].setUsrNm(account.getUsr_nm());
				vos[i].setOfcCd(account.getOfc_cd());

				CrossItemVO item = command.manageDomesticMVMT(vos[i], commonCommand.searchUserCntCode(account.getOfc_cd()));
				String[] strs = item.getRtnStr();
				if (strs != null && !strs[0].equals("null") && strs[0].equals("N")) {
					srtRes.append(strs[1]).append("^^");
					rollback();
				} else {
					srtRes.append("").append("^^");
					if (item.getUpdateMaster() == true) {
						ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
						mstCommand.updateCntrMasterByMvmtBasic(item);
					}
					commit();
					// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
					if(item.getSceActRcvIfVOs().size() > 0){
						com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
							new com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
						
						for(int j = 0; j < item.getSceActRcvIfVOs().size(); j++){
							if(item.getSceActRcvIfVOs().get(i).getBkgNo()!=null && item.getSceActRcvIfVOs().get(j).getBkgNo().length()==12){
								sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(j));	
							}
						}
					}
					
					// calling MNR in case item.getMnrCallYN() = 'Y' only 2010.09.03
					if ("Y".equals(item.getMnrCallYN())) {

						com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC mnrCommand =
							new com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl();
						com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO customMnrEqStsVO =
							new com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO();

						/* mandatory input value
						 *  customMnrEqStsVO.setEqNo(*** );
						 *	customMnrEqStsVO.setEqKndCd(***);
						 *	customMnrEqStsVO.setEqTpszCd(***);
						 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);
						 *  customMnrEqStsVO.setMnrDmgFlg(***);
						 *  customMnrEqStsVO.setMnrFlgInpDt(***);
						 *  customMnrEqStsVO.setMnrFlgRmk(***);
						 *  customMnrEqStsVO.setMnrFlgInpTpCd(***);
						 *  matching table :  MNR_EQ_STS
						 */
						
						String dmgFlg = item.getCusCtmMovementVO().getCntrDmgFlg();
						String evntDt = "";
						
						if ("Y".equals(dmgFlg)) {
							dmgFlg = "1";
							evntDt = item.getCusCtmMovementVO().getDmgFlgDt();
						} else {
							dmgFlg = "0";
							evntDt = item.getCusCtmMovementVO().getDmgUnflgDt();
						}
						
						customMnrEqStsVO.setMnrDmgFlg(dmgFlg);    // flaging : '1', unflaging '0'
						customMnrEqStsVO.setEqKndCd("U");    // Container=> U, Chassis=> Z, GenSet=> G
						customMnrEqStsVO.setEqNo(item.getCusCtmMovementVO().getCntrNo());    // Container No
						customMnrEqStsVO.setEqTpszCd(item.getCusCtmMovementVO().getCntrTpszCd());    // Type/Size
						customMnrEqStsVO.setMnrDmgFlgYdCd(item.getCusCtmMovementVO().getOrgYdCd());    // yard code occurring damage flagging/unflagging
						customMnrEqStsVO.setMnrFlgInpDt(evntDt);
						customMnrEqStsVO.setMnrFlgRmk("Auto-created by CTM ("+item.getCusCtmMovementVO().getMvmtStsCd()+")");
						customMnrEqStsVO.setMnrFlgInpTpCd("V"); //V:Movement, M:Manual

						if(account == null || "".equals(account)){
							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
							String today = formatter.format(new java.util.Date());
							account = new SignOnUserAccount(item.getCusCtmMovementVO().getUpdUsrId(),null,null,null,null,null,null,null, item.getCusCtmMovementVO().getUpdUsrId(), today , item.getCusCtmMovementVO().getUpdUsrId(), today, item.getCusCtmMovementVO().getOfcCd(), null, null, null, null, null, null, null, null, null);									
						}

						mnrCommand.manageIFFlagForOtherBasic(customMnrEqStsVO, account);
						
					}
					// 2013.09.24 강   환 [CHM-201325811] Each Container Inquiry 기능 보완 (CO-CP생성시 auto  생성된 MT 를 SCEM에 추가 IF)
				}
			} catch (EventException ex) {
				/***************************************************************
				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
				 ***************************************************************/
				log.error(ex.getMessage(),ex);
				rollback();
				srtRes.append(ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "")).append("^^");
			} catch (Exception ex) {
				/***************************************************************
				 * 실패하더라도 다음 데이터 처리를 위해 Throw하지 않음 *
				 ***************************************************************/
				log.error(ex.getMessage(),ex);
				rollback();
				srtRes.append(ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "")).append("^^");
			}
		}
		eventResponse.setETCData("rtnStr", srtRes.toString());
		return eventResponse;
	}	
	
	/**
	 * EES_CTM_0411 : btn_retrive<br>
	 * retrieving Detail Form of VVD History List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0411Event event = (EesCtm0411Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<CtmVvdHistoryVO> list = command.searchVvdHistory(event.getConINTCommonVO());
			eventResponse.setRsVoList(list);
			List<searchMovementHistoryVO> list1 = command.searchMvmtHistory(event.getConINTCommonVO());
			eventResponse.setRsVoList(list1);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0443 : btn_retrive<br>
	 * retrieving Cargo Location message list
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCLMList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0443Event event = (EesCtm0443Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<CtmCCLMVO> list = command.searchCLMInfo(event.getCtmCCLMVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0413 : btn_retrive<br>
	 * retrieving BKG/MVMT VL/VD Unmatch List 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMVMTBKGUnmatchList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0413Event event = (EesCtm0413Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<ConCBookingVO> list1 = command.searchMVMTBKGUnmatchList(event.getConCBookingVO(), "1");
			eventResponse.setRsVoList(list1);
			List<ConCBookingVO> list2 = command.searchMVMTBKGUnmatchList(event.getConCBookingVO(), "2");
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418 : onLoad<br>
	 * loading data for setting in RCC Combo
	 *
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getRccList() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			String rtn = command.getRccList(account.getOfc_cd());
			eventResponse.setETCData("rtn", rtn);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418 : Combo Change<br>
	 * loading data for setting in RCC Combo
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getLccList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0418Event event = (EesCtm0418Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			String rtn = command.getLccList(event.getMovementEDIReportVO().getRccCd());
			eventResponse.setETCData("rtn", rtn);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BackEndJob common - retruning status of BackEndJob 
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBackEndJob(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			String status = command.comBackEndJob((String) e.getAttribute("KEY"));
			eventResponse.setETCData("jb_sts_flg", status);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418 : btn_retrive<br>
	 * BackEndJob start<br>
	 * doBackEndJob method
	 * @author Jeong-Hoon, KIM
	 * @param e
	 * @return
	 */
	private EventResponse doBackEndJobEDIOnTimeDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0418Event event = (EesCtm0418Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJob(account, event.getMovementEDIReportVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418, EES_CTM_0460, EES_CTM_0462 : BackEndJob<br>
	 * retrieving result of MVMT Timely Update Ratio Long Tx 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIOnTimeDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<MovementEDIReportVO> list = command.searchEDIOnTimeDetailList((String) e.getAttribute("KEY"));
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0418 : btn_excel<br>
	 * retrieving detail data of EDI result for excel down load
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIOnTimeDetailExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0418Event event = (EesCtm0418Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<UpdateRatioDetailVO> list = command.getUpdateRatioDetail(event.getUpdateRatioDetailVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0417 : btn_retrive<br>
	 * starting BackEndJob of 0417
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobEDIErrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0417Event event = (EesCtm0417Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobEDIErrList(account, event.getSearchEDIErrorVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0417 : BackEndJob<br>
	 * retrieving result of EDI Error Detail List Long Tx 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIErrorList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<SearchEDIErrorVO> list = command.searchEDIErrorList((String) e.getAttribute("KEY"));
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0417 : btn_excel<br>
	 * retrieving detail data of EDI error for excel down loading 
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIErrorDetailExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0417Event event = (EesCtm0417Event)e;
		LongTxContainerMovementFinderBCImpl command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<SearchEDIErrorVO> list = command.searchEDIErrorDetailExcel(event.getSearchEDIErrorVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0420 : btn_retrive<br>
	 * retrieving EDI Result Monitoring Data and detail data  
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobEDIRstList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0420Event event = (EesCtm0420Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobEDIRst(account, event.getSearchEDIResultVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0420 : BackEndJob<br>
	 * retrieving result of EDI Result Detail List Long Tx 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIResultList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<SearchEDIResultVO> list = command.searchEDIResultList((String) e.getAttribute("KEY"));
			eventResponse.setRsVoList(list);
		} catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0420 : btn_excel<br>
	 * retrieving detail data of EDI result for excel down loading 
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIResultDetailExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0420Event event = (EesCtm0420Event)e;
		LongTxContainerMovementFinderBCImpl command = new LongTxContainerMovementFinderBCImpl();
		try {
			List<SearchEDIResultVO> list = command.searchEDIResultDetailExcel(event.getSearchEDIResultVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0419 : btn_retrive<br>
	 * retrieving VL/VD EDI Test Result list
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchResultEDIList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0419Event event = (EesCtm0419Event)e;
		ContainerMovementFinderBC command = new ContainerMovementFinderBCImpl();
		try {
			List<ConCBookingVO> list1 = command.searchResultEDIList(event.getConCBookingVO(), "1");
			eventResponse.setRsVoList(list1);
			List<ConCBookingVO> list2 = command.searchResultEDIList(event.getConCBookingVO(), "2");
			eventResponse.setRsVoList(list2);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0456 : btn_retrive<br>
	 * retrieving PreVLVD List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreVLVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0456Event event = (EesCtm0456Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			List<SearchPreVLVDListVO> list = command.searchPreVLVDList(event.getSearchPreVLVDListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0456 : btn_save<br>
	 * modifying/deleting PreVLVD List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePreVLVD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0456Event event = (EesCtm0456Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			begin();
			command.managePreVLVD(event.getSearchPreVLVDListVOS(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * SPP : WebService<br>
	 * registering single data from SPP in Movement Status
	 *
	 * @param Event e
	 * @return String[]
	 * @exception EventException
	 */
	public EventResponse manageSppMovement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0999Event event = (EesCtm0999Event)e;		
//		CusCtmMovementVO[] cusCtmMovementVO = event.getCusCtmMovementVOS();
//		CusCtmMovementVO[] opVo = new CusCtmMovementVO[2];
		StringBuffer rtnString = new StringBuffer();
		
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
		CusCtmMovementVO[] cusCtmMovementVOs = event.getCusCtmMovementVOS();
		FlatFileForGateNewVO flatFileForGateNewVO = null;
		List<SearchEDIMovementListVO> searchEDIMovementListVOlist = new ArrayList<SearchEDIMovementListVO>();
		SearchEDIMovementListVO searchEDIMovementListVO = null;
		if (cusCtmMovementVOs != null) {

			for (int k=0; k<cusCtmMovementVOs.length; k++) {
				log.info("\n\n===============================================================" +
						  "\n SPP : cusCtmMovementVO[" + k + "] : ColumnValues" +
						  "\n======================================" +
						  "\n" + cusCtmMovementVOs[k].getColumnValues().toString().replaceAll(", ", "\n") +
						  "\n===============================================================\n");
				
				flatFileForGateNewVO = null;
				cusCtmMovementVOs[k].setCreUsrId(cusCtmMovementVOs[k].getUpdUsrId());    // user_id

				log.info("\n\n===============================================================" +
						  "\n [SPP] GateNew() - Begin!" +
						  "\n===============================================================\n");
				
				try {
					// AssignEdiUiVO2FlatFileVO for GateNew ////////////////////////////
					flatFileForGateNewVO = gatenewCommand.assignSPPVO2FlatFileVO(cusCtmMovementVOs[k]);
					log.info("\n\n===============================================================" +
							  "\n begin_flatFile : ColumnValues" +
							  "\n======================================" +
							  "\n" + flatFileForGateNewVO.getColumnValues().toString().replaceAll(", ", "\n") +
							  "\n======================================" +
							  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileForGateNewVO.getBkgNumber()) +
							  "\n===============================================================\n");
					// starting BCImpl.GateNew   ////////////////////////////////////////////
					begin();    // gateNew BEGIN
					flatFileForGateNewVO = gatenewCommand.gateNew(flatFileForGateNewVO);
					commit();
					log.info("\n\n===============================================================" +
							  "\n finish_flatFile : ColumnValues" +
							  "\n======================================" +
							  "\n" + flatFileForGateNewVO.getColumnValues().toString().replaceAll(", ", "\n") +
							  "\n======================================" +
							  "\n bkg_number[]=" + java.util.Arrays.toString(flatFileForGateNewVO.getBkgNumber()) +
							  "\n===============================================================\n");
				} catch (EventException ex) {
					rollback();
					log.error("\n\n[SC - (SPP) GateNew] EventException :\n\n" + ex.getMessage(), ex);
					rtnString.append("Transmission failed.").append("^^");
//					throw ex;
				} catch (Exception ex) {
					rollback();
					log.error("\n\n[SC - (SPP) GateNew] Exception :\n\n" + ex.getMessage(), ex);
					rtnString.append("Transmission failed.").append("^^");
//					throw new EventException(ex.getMessage(), ex);
				}
				
				if ( flatFileForGateNewVO != null ) {
					try {
							flatFileForGateNewVO = manageGateNewProcess(flatFileForGateNewVO, false);
					} catch (EventException ex) {
						/*********************************************************
						 * no throwing in case of failure for handling next data *
						 *********************************************************/
						rollback();
						log.error("\n\n manageGateNewProcess : EventException\n" + ex.toString(), ex);
					} catch (Exception ex) {
						/*********************************************************
						 * no throwing in case of failure for handling next data *
						 *********************************************************/
						rollback();
						log.error("\n\n manageGateNewProcess : Exception\n" + ex.toString(), ex);
					} finally {

						/* skipping in case message is US 322 and gate status is AR(Rail Arrival At Destination Inter modal Ramp)  */
//						if ( "322".equals(flatFileForGateNewVO.getMsgId()) && "UR".equals(flatFileForGateNewVO.getGateIo() ) ) {
//							/* throwing only in case EES_CTM_0000 */
//							if ( eventName.equals("EesCtm0000Event") ) {
//								throw new EventException(new ErrorHandler("[MsgId : 322 & GateIo : AR] Case. GateNew Skip!").getMessage());
//							} else {
//								log.info("\n\n=============================================================== [MsgId : 322 & GateIo : AR] Case = > Skip\n");
//							}
//						} else {
							flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber()[0] == null ? "" : flatFileForGateNewVO.getBkgNumber()[0] + "");
							// AssignFlatFileVO2EdiUiVO for GateNew ////////////////////////////
							try {
								searchEDIMovementListVO = gatenewCommand.assignFlatFileVO2EdiUiVO(flatFileForGateNewVO, new SearchEDIMovementListVO());
							} catch (EventException ex) {
								log.error("\n\n assignFlatFileVO2EdiUiVO : Exception\n" + ex.toString(), ex);
								rtnString.append("Transmission failed.").append("^^");
//								throw ex;
							}
							// rty_knt
							searchEDIMovementListVO.setRtyKnt("0");
							try {
								begin();    // resultUpdb BEGIN
								log.info("\n\n===============================================================" +
										  "\n resultUpdb()" +
										  "\n===============================================================\n");
								searchEDIMovementListVOlist.add(gatenewCommand.resultUpdb(searchEDIMovementListVO));		
								rtnString.append("").append("^^");						
								commit();
								
								if ("Y".equals(searchEDIMovementListVO.getMvmtEdiRsltCd()) && "ST".equals(flatFileForGateNewVO.getGateIo())) {
									CrossItemVO item = new CrossItemVO();	
									CrossItemVO mnrItem = new CrossItemVO();
									ContainerMovementMgtBC mgtCommand = new ContainerMovementMgtBCImpl();

									begin();
									item = mgtCommand.modifyCNTRStatus(gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1), account);
									
									String[] rtnStrs = null;
									rtnStrs = item.getRtnStr();
									
									if (rtnStrs[0] == null || rtnStrs[0].equals("X") || rtnStrs[0].equals("")) {
										if (rtnStrs[0] != null && rtnStrs[0].equals("X")) {
											mnrItem = mgtCommand.modifyDMGHistory(item, account);
											rtnStrs = mnrItem.getRtnStr();
										}
									}
									
									if (rtnStrs[0] != null && (rtnStrs[0].equals("N"))) {
										rollback();
									} else {
										commit();
									}
									
									flatFileForGateNewVO.setResultIndicator(rtnStrs[0]);
									flatFileForGateNewVO.setResultMessage(rtnStrs[1]);
								}
							} catch (EventException ex) {
								/******************************************************
								 * no throwing in case of failure for handling next data   *
								 ******************************************************/
								rollback();
								log.error("\n\n resultUpdb : EventException\n" + ex.toString(), ex);
								rtnString.append("Transmission failed.").append("^^");
//								throw ex;
							} catch (Exception ex) {
								/******************************************************
								 * no throwing in case of failure for handling next data   *
								 ******************************************************/
								rollback();
								log.error("\n\n resultUpdb : Exception\n" + ex.toString(), ex);
								rtnString.append("Transmission failed.").append("^^");
//								throw new EventException(ex.getMessage(), ex);
							}
//						}
					}
				}
				log.info("\n\n===============================================================" +
						  "\n [SPP] GateNew() - Finish!" +
						  "\n===============================================================\n");
			}
		}
//		for (int x = 0; x < cusCtmMovementVO.length; x++) {
//			log.info("\n\n===============================================================" +
//					  "\n SPP : cusCtmMovementVO[" + x + "] : ColumnValues" +
//					  "\n======================================" +
//					  "\n" + cusCtmMovementVO[x].getColumnValues().toString().replaceAll(", ", "\n") +
//					  "\n===============================================================\n");
//			try {
//				begin();
//				int idx = 1;
//				opVo[0] = cusCtmMovementVO[x];
//
//				rtnStrs = manageCreateProcess(opVo, idx, false, false, false);
//				if (rtnStrs[0] != null && rtnStrs[0].equals("N")) {
//					rollback();
//					for (int y = 0; y < (idx); y++) {
//						rtnString.append(rtnStrs[1]).append("^^");
//						log.debug(rtnStrs[1] + "^^");
//					}
//				} else {
//					commit();
//					for (int y = 0; y < (idx); y++) {
//						rtnString.append(rtnStrs[1]).append("^^");
//						log.debug(rtnStrs[1] + "^^");
//					}
//				}
//
//			} catch (EventException ex) {
//				rollback();
//				log.error("err " + ex.toString(), ex);
//				throw ex;
//			} catch (Exception ex) {
//				rollback();
//				log.error("err " + ex.toString(), ex);
//				throw new EventException(ex.getMessage(), ex);
//			}
//		}
		
		log.info("Process End :" + rtnString.toString());
		eventResponse.setETCData("rtnStr", rtnString.toString());
		return eventResponse;

	}

	/**
	 * EES_CTM_0414 : btn2_retrive<br>
	 * retrieving MVMTHistory List for sheet2
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingInfoForEDI(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0414Event event = (EesCtm0414Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		ContainerMovementValidationBC commonCommand = new ContainerMovementValidationBCImpl();
		try {
			List<MVMTBookingInfoVO> list = command.searchBookingInfoList(event.getCtmMovementVO(), commonCommand.searchUserCntCode(account.getOfc_cd()));
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0414 : btn2_save<br>
	 * saving sheet1 after saving sheet2
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMVMTHistoryAndEDI(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0414Event event = (EesCtm0414Event)e;
		try {
			begin();
			//===== modifyMVMTProcess (S) ========================================================================
			String rtnStr = modifyMVMTProcess(event.getCusCtmMovementVOS(), event.getCtmMovementVOS());
			//===== modifyMVMTProcess (E)========================================================================
			if (rtnStr == null) {
				rollback();
			} else {
				if (!"".equals(rtnStr)) {
					eventResponse.setETCData("rtnStr", rtnStr);
					rollback();
				} else {
					//===== manageEDIMovement (S)========================================================================
					ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
					SearchEDIMovementListVO searchEDIMovementListVO = event.getSearchEDIMovementListVOS()[0];
					searchEDIMovementListVO.setEdiUiYn("Y");     // edi_ui_yn
					searchEDIMovementListVO.setUserId(account.getUsr_id());    // user_id
					int rtyKnt = Integer.parseInt(searchEDIMovementListVO.getRtyKnt()) + 1;
					searchEDIMovementListVO.setRtyKnt(String.valueOf(rtyKnt));    // rty_knt
					searchEDIMovementListVO.setMvmtEdiRsltCd("Y");
					searchEDIMovementListVO.setMvmtEdiRmk("OK.PROCESSED");
					gatenewCommand.resultUpdb(searchEDIMovementListVO);
					//===== manageEDIMovement (E)========================================================================
					commit();
				}
			}
		} catch (EventException ex) {
			rollback();
			log.error("\n\n[SC - manageMVMTHistoryAndEDI] EventException :\n\n" + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("\n\n[SC - manageMVMTHistoryAndEDI] Exception :\n\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0460 : btn_retrive<br>
	 * BackEndJob start<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse doBackEndJobVLVDStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0460Event event = (EesCtm0460Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobVLVDStatus(account, event.getVLVDUpdateStatusVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0461 : form load<br>
	 * retrieving US AMS LOCATION LIST 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmsLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0461Event event = (EesCtm0461Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			List<UsAmsLocationListVO> list = command.searchAmsLocation(event.getUsLmsLocationListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0461 : btn_save<br>
	 * modifying/deleting US AMS Location List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsAmsLocationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0461Event event = (EesCtm0461Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			begin();
			command.manageAmsLocation(event.getUsLmsLocationListVOS(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0462 : btn_retrive<br>
	 * BackEndJob start<br>
	 * @author Jeong-Hoon, KIM
	 * @param e
	 * @return
	 */
	private EventResponse doBackEndJobAutoCreStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0462Event event = (EesCtm0462Event)e;
		LongTxContainerMovementFinderBC command = new LongTxContainerMovementFinderBCImpl();
		try {
			begin();
			eventResponse.setETCData("BackEndJobKey", command.doBackEndJobAutoCreStatus(account, event.getAutoCreStsListVO()));
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0462 : btn_save<br>
	 * saving movement Event Date modification detail
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAutoCreSts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0462Event event = (EesCtm0462Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			begin();
			List<AutoCreStsListVO> updateVoList = command.manageAutoCreSts(event.getAutoCreStsListVOS(),account);		

			//TRS Transport Status Update Logic 2016.05.23//		
			try {
				if ( updateVoList.size() > 0 ) {
					for ( int i=0; i<updateVoList.size(); i++ ) {
						log.info("TRS temp log : " + updateVoList.get(i).getStsCd());
						new WorkOrderManagementBCImpl().modifyWorkOrderExecuteDate(updateVoList.get(i).getCntrNo(),  updateVoList.get(i).getTarDate(),  "",  updateVoList.get(i).getYdCd(), updateVoList.get(i).getStsCd(), updateVoList.get(i).getBkgNo(),  updateVoList.get(i).getUpdUsrId(), updateVoList.get(i).getMvmtCreTpCd());	
					}
				}
			} catch(Exception ex) {
				log.error("Error-[TRS]modifyWorkOrderExecuteDate " + ex.toString(), ex);
			}

			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * returing subString as total character count in case smaller than determined count
	 *
	 * @param String str
	 * @param int beginIndex
	 * @param int endIndex
	 * @return String
	 */
	private String subStr(String str, int beginIndex, int endIndex) {
		str = ((str == null || "".equals(str.trim())) ? "" : str.trim());
		int firstIndex = str.length() < beginIndex ? str.length() : beginIndex;
		int lastIndex = str.length() < endIndex ? str.length() : endIndex;
		return str.substring(firstIndex, lastIndex);
	}
	
	/**
	 * EES_CTM_0421 : btn_save<br>
	 * modifying/deleting Restuffing Reason List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReasonList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0421Event event = (EesCtm0421Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			begin();
			command.manageReasonList(event.getCtmMvmtXchRsnVOS(),account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	 
	/** manageOSCARCtmCycNoList
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageOSCARCtmCycNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0470Event event = (EesCtm0470Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			begin();
			command.manageOSCARCtmCycNoList(event.getSearchDeletedMVMTListVOs(), event.getSignOnUserAccount().getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	 
	/** manageVVDList
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0471Event event = (EesCtm0471Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			begin();
			command.manageVVDList(event.getSearchAllVVDByBKGVOs(), event.getSignOnUserAccount().getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CTM_1001 : form load / Retrieve<br>
	 * retrieving CNTR MVMT Sequence 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrMvmtSeq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm1001Event event = (EesCtm1001Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			List<CntrMvmtSeqVO> list = command.searchCntrMvmtSeqList(event.getCntrMvmtSeqVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CTM_1001 : btn_save<br>
	 * modifying/deleting CNTR MVMT Sequence List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCntrMvmtSeqList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm1001Event event = (EesCtm1001Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			begin();
			command.manageCntrMvmtSeqList(event.getCntrMvmtSeqVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CTM_1002 : form load / Retrieve<br>
	 * retrieving CNTR MVMT Status Decision 
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCtmMvmtStsDcsn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm1002Event event = (EesCtm1002Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			List<CtmMvmtStsDcsnVO> list = command.searchCtmMvmtStsDcsnList(event.getCtmMvmtStsDcsnVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CTM_1002 : btn_save<br>
	 * modifying/deleting CNTR MVMT Status Decision List
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCtmMvmtStsDcsn(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm1002Event event = (EesCtm1002Event)e;
		ContainerMovementMasterDataMgtBC command = new ContainerMovementMasterDataMgtBCImpl();
		try {
			begin();
			command.manageCtmMvmtStsDcsnList(event.getCtmMvmtStsDcsnVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Calling from EDIErrorMsgRetry.java<br>
	 * 
	 * @param SearchEDIMovementListVO[] searchEDIMovementListVOs
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse manageEDIMovementBatch(SearchEDIMovementListVO[] searchEDIMovementListVOs) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();

		SearchEDIMovementListVO searchEDIMovementListVO = null;
		FlatFileForGateNewVO flatFileForGateNewVO = null;
		List<SearchEDIMovementListVO> searchEDIMovementList = new ArrayList<SearchEDIMovementListVO>();
		int totalCount = 0;
		int okCount = 0;
		int errorCount = 0;
		int ignoredCount = 0;

		if (searchEDIMovementListVOs != null) {

			for (int k=0; k<searchEDIMovementListVOs.length; k++) {
				searchEDIMovementListVO = null;
				flatFileForGateNewVO = null;
				searchEDIMovementListVOs[k].setEdiUiYn("Y");                   // edi_ui_yn (separator for distinguishing 404/0414 screens)
				searchEDIMovementListVOs[k].setUserId("BATCH");    // user_id
				searchEDIMovementListVOs[k].setUserNm("BATCH");    // user_nm

				if ("VL".equals(searchEDIMovementListVOs[k].getEdiMvmtStsCd()) || "VD".equals(searchEDIMovementListVOs[k].getEdiMvmtStsCd()) ) {
					searchEDIMovementListVOs[k].setEdiMvmtStsCd("ZZ");
				}

				try {
					// AssignEdiUiVO2FlatFileVO for GateNew ////////////////////////////
					flatFileForGateNewVO = gatenewCommand.assignEdiUiVO2FlatFileVO(searchEDIMovementListVOs[k]);
					// starting BCImpl.GateNew   ////////////////////////////////////////////
//					begin();    // gateNew BEGIN
					flatFileForGateNewVO = gatenewCommand.gateNew(flatFileForGateNewVO);
//					commit();
				} catch (EventException ex) {
//					rollback();
					throw ex;
				} catch (Exception ex) {
//					rollback();
					throw new EventException(ex.getMessage(), ex);
				}

				// in case returned flatFileForGateNewVO is not null /////////////////
				if (flatFileForGateNewVO != null) {
					// manageGateNewProcess ////////////////////////////////////////
					flatFileForGateNewVO = manageGateNewProcessByBatch(flatFileForGateNewVO);
					// AssignFlatFileVO2EdiUiVO for GateNew ////////////////////////
					searchEDIMovementListVO = gatenewCommand.assignFlatFileVO2EdiUiVO(flatFileForGateNewVO, searchEDIMovementListVOs[k]);
				}

				// in case returned searchEDIMovementListVO가 is not null  /////////////////
				if (searchEDIMovementListVO != null) {
					try {
						int rtyKnt = Integer.parseInt(searchEDIMovementListVOs[k].getRtyKnt()) + 1;
						searchEDIMovementListVO.setRtyKnt(String.valueOf(rtyKnt));    // rty_knt
//						begin();    // resultUpdb BEGIN
						searchEDIMovementListVO = gatenewCommand.resultUpdb(searchEDIMovementListVO);
//						commit();
					} catch (EventException ex) {
//						rollback();
						throw ex;
					} catch (Exception ex) {
//						rollback();
						throw new EventException(ex.getMessage(), ex);
					}

					// Count : adding to resultList in case mvmtEdiRsltCd is not "Y"
					if ("N".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())) {
						searchEDIMovementList.add(searchEDIMovementListVO);
						errorCount = errorCount + 1;
					} else if ("X".equals(searchEDIMovementListVO.getMvmtEdiRsltCd()) || "I".equals(searchEDIMovementListVO.getMvmtEdiRsltCd())) {
						ignoredCount = ignoredCount + 1;
					} else {
						okCount = okCount + 1;
					}
					totalCount = totalCount + 1;
				}
			}
		}

		// setting result
		eventResponse.setETCData("total_count", String.valueOf(totalCount));
		eventResponse.setETCData("ok_count",  String.valueOf(okCount));
		eventResponse.setETCData("error_count",  String.valueOf(errorCount));
		eventResponse.setETCData("ignored_count",  String.valueOf(ignoredCount));
		eventResponse.setRsVoList(searchEDIMovementList);
		return eventResponse;
	}	
	
	/**
	 *calling from  manageEDIMovementBatch<br>
	 * GATENEW Process 처리<br> 
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 */
	private FlatFileForGateNewVO manageGateNewProcessByBatch(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException {
		ContainerMovementMgtForGateNewBC gatenewCommand = new ContainerMovementMgtForGateNewBCImpl();
		String[] returnValues = new String[2];

		/* in case @checkNassignData result is Y*/
		if ( "Y".equals(flatFileForGateNewVO.getCheckNassignData()) ) {

			/* calling createChassisMovement in case Chassis Case */
			if ( "Y".equals(flatFileForGateNewVO.getChssCase()) ) {
				/* calling related service in case received data for requested 322 data through gatenew is Chassis( As Is : chs_dbup.pc) */
				log.info("\n\n===============================================================" +
						 "\n Chassis - manageCHSMovementBareByGatenewBasic call" +
						 "\n===============================================================\n");
				try {
					ChassisMovementHistoryBC cgmCommand = new ChassisMovementHistoryBCImpl();
//					begin();    // Chassis BEGIN
					returnValues = cgmCommand.manageCHSMovementBareByGatenewBasic( flatFileForGateNewVO );
//					commit();    //  Chassis COMMIT
				} catch (EventException ex) {
					/******************************************************
					 * no throwing in case of failure for handling nexst data   *
					 ******************************************************/
//					rollback();    // Chassis ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Chassis ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
				} catch (Exception ex) {
//					rollback();    // Chassis ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Chassis ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CHASSIS_STS 1 : " + returnValues[1] +
						 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% CHASSIS_MSG 1 : " + returnValues[0] + "\n");

				// in case Success  is  return value : returnValues[0] = "", returnValues[1] = "Y"
				if ( returnValues[0].equals("") && returnValues[1].equals("Y") ) {    /* is Not Error */
					flatFileForGateNewVO.setResultMessage("OK.PROCESSED");
					flatFileForGateNewVO.setResultIndicator("Y");

				} else {    /* is Error */
					flatFileForGateNewVO.setResultMessage(returnValues[0].trim());
					flatFileForGateNewVO.setResultIndicator("N");

				}

			} else if ( "Y".equals(flatFileForGateNewVO.getMgsCase()) ) {
				/* calling related service in case received data for requested 322 data through gatenew is Mgset */
				log.info("\n\n===============================================================" +
						 "\n Mgset - manageMGSMovementBareByGatenewBasic call" +
						 "\n===============================================================\n");
				try {
					MgsetMovementHistoryBC cgmCommand2 = new MgsetMovementHistoryBCImpl();
//					begin();    // Mgset BEGIN
					returnValues = cgmCommand2.manageMGSMovementBareByGatenewBasic( flatFileForGateNewVO );
//					commit();    //  Mgset COMMIT
				} catch (EventException ex) {
					/******************************************************
					 * no throwing in case of failure for handling nexst data   *
					 ******************************************************/
//					rollback();    // Mgset ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Mgset ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
				} catch (Exception ex) {
//					rollback();    // Mgset ROLLBACK
					flatFileForGateNewVO.setResultIndicator("N");
					flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (Mgset ERROR)");
					log.error("\n\nerr " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% MGSET_STS 1 : " + returnValues[1] +
						 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% MGSET_MSG 1 : " + returnValues[0] + "\n");

				// in case Success  is  return value : returnValues[0] = "", returnValues[1] = "Y"
				if ( returnValues[0].equals("") && returnValues[1].equals("Y") ) {    /* is Not Error */
					flatFileForGateNewVO.setResultMessage("OK.PROCESSED");
					flatFileForGateNewVO.setResultIndicator("Y");

				} else {    /* is Error */
					flatFileForGateNewVO.setResultMessage(returnValues[0].trim());
					flatFileForGateNewVO.setResultIndicator("N");

				}

			} else {    /* in case Chassis Case is not Y*/

				/* calling CTM-COMMON in case Mvmt Status is not "ER", "ZZ", "" */
				if ( !"ER".equals(flatFileForGateNewVO.getMvmtStatus()) && !"ZZ".equals(flatFileForGateNewVO.getMvmtStatus()) ) {

					/* @generateMovement (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
					CusCtmMovementVO[] setCustVOs = null;
					/* _______________________________________________________________________________________________________________________ */
					/* ____________________________________________________________________________________________________________OP, OC Case */
					//String domesticCheck = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 4);
					ContainerMovementMgtForGateNewBCImpl cntMvntMgtForGateNewCommand = new ContainerMovementMgtForGateNewBCImpl();
					int domesticCheck = cntMvntMgtForGateNewCommand.searchDomsticBooking(flatFileForGateNewVO.getBkgNumber()[0]);
					
					if ( ("OP".equals(flatFileForGateNewVO.getMvmtStatus()) || "OC".equals(flatFileForGateNewVO.getMvmtStatus()))
							 && domesticCheck == 0) {
							 /* && (!"DLAX".equals(domesticCheck) && !"DCHI".equals(domesticCheck) && !"DHOU".equals(domesticCheck) && !"DMEM".equals(domesticCheck)
							  && !"DNYC".equals(domesticCheck) && !"DSEA".equals(domesticCheck) && !"TCHI".equals(domesticCheck)) ) {*/

						/* calling MVMT Common1 (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						log.info("\n\n===============================================================" +
								 "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common Call1" +
								 "\n===============================================================\n");
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, (flatFileForGateNewVO.getBkgNumber() == null ? 0 : flatFileForGateNewVO.getBkgNumber().length));
//							begin();    // COMMON BEGIN
							returnValues = manageCreateProcess(setCustVOs, setCustVOs.length, false, false, false);
//							if ( "N".equals(returnValues[0]) ) {
//								rollback();    // COMMON ROLLBACK
//							} else {
//								commit();    //  COMMON COMMIT
//							}
						} catch (EventException ex) {
							/******************************************************
							 * no throwing in case of failure for handling nexst data   *
							 ******************************************************/
//							rollback();    // COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage();
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
//							rollback();    // COMMON ROLLBACK
							flatFileForGateNewVO.setResultIndicator("N");
							flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (MVMT Common ERROR)");
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS 1 : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG 1 : " + returnValues[1] + "\n");
						/* calling MVMT Common1 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/


					}
					/* _______________________________________________________________________________________________________________________ */
					/* _________________________________________________________________________________________________________ Domestic Case */
					else if ( "USA".equals(flatFileForGateNewVO.getMuidArea())
							&& domesticCheck != 0) {
							 /* && ("DLAX".equals(domesticCheck) || "DCHI".equals(domesticCheck) || "DHOU".equals(domesticCheck) || "DMEM".equals(domesticCheck)
							  || "DNYC".equals(domesticCheck) || "DSEA".equals(domesticCheck) || "TCHI".equals(domesticCheck)) ) {*/

						/* Domestic MVMT Common Call (S) ++++++++++++++++++++++++++++++++++++++++++++++++++*/
						log.info("\n\n===============================================================" +
								 "\n manageDomesticMVMT(vos[0], account) ++++++ Domestic MVMT Common Call" +
								 "\n===============================================================\n");
						
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1 );
							ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
//							begin();    // Domestic-COMMON BEGIN
							CrossItemVO item = command.manageDomesticMVMT(setCustVOs[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 2));
							returnValues = item.getRtnStr();
//							if ( "N".equals(returnValues[0]) ) {
//								rollback();    // Domestic-COMMON ROLLBACK
//							} else {
							if (item.getUpdateMaster() == true) {
								ContainerOnOffhireBC mstCommand = new ContainerOnOffhireBCImpl();
								mstCommand.updateCntrMasterByMvmtBasic(item);
							}
//								commit();    //  Domestic-COMMON COMMIT
//							}
							
							if(item.getSceActRcvIfVOs().size() > 0){
								com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBC sceCommand = 
									new com.clt.apps.opus.esd.sce.copdetailreceive.basic.CopDetailReceiveBCImpl();
								
								for(int i = 0; i < item.getSceActRcvIfVOs().size(); i++){
									if(item.getSceActRcvIfVOs().get(i).getBkgNo()!=null && item.getSceActRcvIfVOs().get(i).getBkgNo().length()==12){
										sceCommand.createCOPMVMT(item.getSceActRcvIfVOs().get(i));
									}
								}
							}
						} catch (EventException ex) {
							/***********************************************************
							 * no throwing in case of failure for handling nexst data *
							 ***********************************************************/
//							rollback();    // Domestic-COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage().replace("APP", "").replaceAll("<", "").replaceAll("\\|", "").replaceAll(">", "");
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
//							rollback();    // Domestic-COMMON ROLLBACK
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_STS : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Domestic-COMMON_MSG : " + returnValues[1] + "\n");
						/* Domestic MVMT COmmon Call (E) ++++++++++++++++++++++++++++++++++++++++++++++++++*/


					}					
					/* _______________________________________________________________________________________________________________________ */
					/* __________________________________________________________________________________ International MVMT ( Except OP, OC ) */
					else {

						boolean nBkgNoFlg = false;
						if ( "VL".equals(flatFileForGateNewVO.getMvmtStatus()) && "Y".equals(flatFileForGateNewVO.getNBkgNoFlg()) ) {
							nBkgNoFlg = true;
						}

						/* calling MVMT Common2 (S) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
						log.info("\n\n===============================================================" +
								 "\n manageCreateProcess(setCustVOs, length) ++++++ MVMT Common Call2" +
								 "\n===============================================================\n");
						try {
							setCustVOs = gatenewCommand.assignCommonVO( flatFileForGateNewVO, 1 );
//							begin();    // COMMON BEGIN
							returnValues = manageCreateProcess(setCustVOs, setCustVOs.length, nBkgNoFlg, false, false);
//							if ( "N".equals(returnValues[0]) ) {
//								rollback();    // COMMON ROLLBACK
//							} else {
//								commit();    //  COMMON COMMIT
//							}
						} catch (EventException ex) {
							/******************************************************
							 * no throwing in case of failure for handling nexst data   *
							 ******************************************************/
//							rollback();    // COMMON ROLLBACK
							returnValues[0] = "N";
							returnValues[1] = ex.getMessage();
							log.error("\n\nerr " + ex.toString(), ex);
						} catch (Exception ex) {
//							rollback();    // COMMON ROLLBACK
							flatFileForGateNewVO.setResultIndicator("N");
							flatFileForGateNewVO.setResultMessage("SYSTEM ERROR (MVMT Common ERROR)");
							log.error("\n\nerr " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}
						log.info("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_STS 2 : " + returnValues[0] +
								 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% COMMON_MSG 2 : " + returnValues[1] + "\n");
						/* calling MVMT Common2 (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

					}
					/* @generateMovement (E) +++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
				}

				if (returnValues[0] == null || returnValues[0].trim().equals("") || returnValues[0].trim().equals("null")) {
					returnValues[0] = "";
				} else {
					returnValues[0] = returnValues[0].trim();
				}
				if (returnValues[1] == null || returnValues[1].trim().equals("") || returnValues[1].trim().equals("null")) {
					returnValues[1] = "";
				} else {
					returnValues[1] = returnValues[1].trim();
				}

				// result값을 returnVo에 setting
				flatFileForGateNewVO.setResultIndicator(returnValues[0]);
				flatFileForGateNewVO.setResultMessage(returnValues[1]);
			}
		}
		return flatFileForGateNewVO;
	}
	
	/**
	 * @param emailMessage
	 * @throws Exception
	 */
	private void sendEdiInboundErrorMail(String emailMessage) {
		sendEdiInboundErrorMail("ilta5pee@cyberlogitec.com", emailMessage);
		sendEdiInboundErrorMail("hwangmiyun@cyberlogitec.com", emailMessage);
	}
	
	
	/**
	 * @param recipients
	 * @param emailMessage
	 * @throws Exception
	 */
	private void sendEdiInboundErrorMail(String recipients, String emailMessage) { 
		try {
			log.debug("@@@@@@ send EDI Inbound Error Mail");
			String sndEml		= "noreply@cyberlogitec.com";
			String sndId		= null;
				
			Mail mail = new Mail();
			mail.setFrom(sndEml, "CTM EDI Inbound Admin.");
			mail.setRecipient(recipients);
			mail.setSubject("opus CTM EDI Inbound Error");
			StringBuffer sbContent = new StringBuffer();
			sbContent.append("\n");
			sbContent.append("=====  CTM EDI DATA INBOUND ERROR  =====");
			sbContent.append("\n");
			sbContent.append("\n * Error Log = " + emailMessage);
			sbContent.append("\n");
			mail.setTextContent(sbContent.toString());
	
			sndId = mail.send();
			log.debug("@@@@@@ EMAIL ID :  " + sndId );
			log.debug("@@@@@@ RECIPIENTS : " + recipients );
		}catch(Exception ee){
			// DO NOT THROW EXCEPTION
			log.error("\n\n EDI INBOUND ERROR EMAIL SEND ERROR : " + ee.toString() );
		}
	}
	

	/**
	 * EES_CTM_0406 : btn_add<br>
	 * handling retrieve event for International VL/VD
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCtmBkgVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			SearchCLMInfoVO vos = event.getSearchCLMInfoVO();
			String rtnStr = command.checkCtmBkgVvd(vos);
			eventResponse.setETCData("rtnStr", rtnStr);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_CTM_0406 : check 2 steps before mvmt status<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPPreMVMTSts(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCtm0406Event event = (EesCtm0406Event)e;
		ContainerMovementMgtBC command = new ContainerMovementMgtBCImpl();
		try {
			log.info("##############"+event.getSearchCLMInfoVO());
			String rtnStr = command.checkPPreMVMTSts(event.getSearchCLMInfoVO());
			eventResponse.setETCData("rtnStr", rtnStr);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

}
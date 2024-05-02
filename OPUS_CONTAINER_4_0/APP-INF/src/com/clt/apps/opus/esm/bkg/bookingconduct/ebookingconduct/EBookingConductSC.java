/*=========================================================
 *@FileName : EBookingConductSC.java
 *@FileTitle : e-Booking n SI Process
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
* -------------------------------------------------------
* 2014.08.26 김태균 임재관-ESM_BKG_0229_01화면중 Reference No Button 개발(ALPS-현행화)
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgXterUsrInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0228Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022901Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022902Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022903Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022904Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022905Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022906Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022907Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022908Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022909Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022910Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022911Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0229Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0235Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0902Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg1801Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg1802Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgEBkgReceiptEvent;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration.EBookingReceiptDBDAO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterRevMsgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstAkVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstDgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl1VO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl2VO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstMndVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstRfVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusCntrTpszVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteOfcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.RerouteUserIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCmShipmentVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterDgRiderVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterInnerPackageVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SearchDgCancelInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.DpcsWebBookingVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.ModifySiValAutoVO;
import com.clt.apps.opus.esm.bkg.common.PegasusMapping;
import com.clt.apps.opus.esm.bkg.common.VermasMapping;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrShpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBC;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.CstmBkgRevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBC;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic.ReceiveOwnBkgCancelRequestMgtBC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic.ReceiveOwnBkgCancelRequestMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.ScgVvdDgCgoCxlRqstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgChnBkgNoGenVO;
import com.clt.syscommon.common.table.BkgCntcPsonVO;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgCustomerVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.BkgXterSrchSetVO;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.MdmPckTpVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;


/**
 * OPUS-EBookingConduct Business Logic ServiceCommand - business transaction handling about OPUS-EBookingConduct
 *
 * @author 
 * @see EBookingReceiptDBDAO
 * @since J2EE 1.4
 */

public class EBookingConductSC extends ServiceCommandSupport {
	// Login User Information 
	private SignOnUserAccount account = null;

	/** 
	 * EBookingConduct system task scenario finish work<br>
	 * In case of closing ESM_BKG_0228 task scenario , inner object has to be relieved <br>
	 */
	public void doEnd() {
		log.debug("EBookingConductSC End");
	}

	/**
	 * EBookingConduct system's task scenario prework<br>
	 * in case of calling ESM_BKG_0228 task scenario, inner object creating<br>
	 */
	public void doStart() {
		try {
	
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 *  working on task scenario for event <br>
	 *  All event generated in OPUS-EBookingConduct system task division handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {

			if (e.getEventName().equalsIgnoreCase("EsmBkg0228Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchComCode0228(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterRqstList(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchXterRqstValidation(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse = searchRerouteUserId(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
					eventResponse = deleteXterRqst(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					eventResponse = pendingXterRqst(e);
//					eventResponse = receiptXterRqstByXml(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
					eventResponse = bkgNoXterRqst(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
					eventResponse = uploadDummyXterRqst(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
					eventResponse = sendRerouteRqstNotice(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = receiptXterRqstEdiMsg(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0229Event")) {
				if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
					eventResponse = uploadXterRqst(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
					eventResponse = cancelBkgByXter(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022901Event")) {
				if (e.getFormCommand().isCommand(FormCommand.DEFAULT)
						|| e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterBkg(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMdmCmdtDesc(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchVslNm(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = createBkgWithoutRouteByXterTx(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = createBkgWithRouteByXterTx(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = modifyBkgWithoutRouteByXterTx(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
					eventResponse = modifyBkgWithRouteByXterTx(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
					eventResponse = createPctlNo(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
					eventResponse = pendingXterRqst(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					eventResponse = reinstateXterRqst(e);				
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					eventResponse = searchBkgBlNo(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)){
					eventResponse = checkIranBlackCustomer(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022902Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterCust(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyBlDocCustTx(e);//for Test
				}
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)){
					eventResponse = checkIranBlackCustomer(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022903Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterCntr(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchTypeSizeByCntr(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageContainerTx(e);//for Test
				}
				else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)){
					eventResponse = checkIranBlackCustomer(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
					eventResponse = cntrPrtFlgCountCheck(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022904Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterMnd(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMndTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022905Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterCm(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCmTx(e);//for Test
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchXterCmShipment(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022906Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterTro(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageTroTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022907Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterRf(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMdmCmdtDesc(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageRfTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022908Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterDg(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageDgTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022909Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterAk(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageAwkTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022910Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterHbl1(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageHblTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022911Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterHbl2(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageHbl2Tx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0902Event")) {
				if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchComCode0902(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
					eventResponse = sendXterRqstRejectEdi(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkgEBkgReceiptEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					receiptXterRqst(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					receiptXterRqstByXls(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					receiptXterRqstByXml(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1801Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchBkgXterRcvMsgList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = receiptXterRqstByXml(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1802Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchBkgXterRcvMsgView(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0235Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchRerouteOfcCd(e);
				}
			}
		}
		catch (EventException ex) {
			throw ex;
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Booking creating (ESM_BKG_0079_01)<br>
	 * @param bookingCreationVO
	 * @param xterRqstNoVO
	 * @return
	 * @throws EventException
	 */
	private BookingCreationVO createBkgInfo(BookingCreationVO bookingCreationVO, XterRqstNoVO xterRqstNoVO) throws EventException {
		try{

			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
//			BLDocumentationBLBC 	blBC 		= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocBC 	= new BLDocumentationCMBCImpl();
			BookingMasterMgtBC 		masterBC 	= new BookingMasterMgtBCImpl();	
			BookingUtil 			bookingUtil = new BookingUtil();
			
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();	
			
			BkgCopManageBC 			copBc 		= new BkgCopManageBCImpl();
			
			// 01. validateBookingSave
			log.debug("createBkgInfo : pctl_no : " + bookingCreationVO.getBkgBlNoVO().getPctlNo());
			bookingCreationVO = receiptBC.validateBookingSave(bookingCreationVO, account);

			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
				return bookingCreationVO;
			}
			
			BkgBlNoVO 		 bkgBlNoVO 		  = bookingCreationVO.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			
			String bkgNo = null;
			String blNo = null;
			
			//00.Legacy newVVD Check
			String tVvd = bookingCreationVO.getBkgBookingInfoVO().getBkgTrunkVvd();
			receiptBC.checkLegacySystemVVD(tVvd); 
			
			// 02. Booking Number creating
			if(!"Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
				//In case bkg no is in agent bkg no list, handling mnl bkg no 
				if(bkgBlNoVO.getBkgNo()!=null && 12==bkgBlNoVO.getBkgNo().length()){
					String mnlBkgNoFlg = masterBC.searchIsChnMnlBkgNo(bkgBlNoVO.getBkgNo());
					if("Y".equals(mnlBkgNoFlg)){
						bkgBookingInfoVO.setMnlBkgNoFlg("Y");
					}
				}
			}
			if(!"Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
				//  In case bkg no is inputted
				if(bkgBlNoVO.getBkgNo() != null && bkgBlNoVO.getBkgNo().length() > 10){
					// booking status code
					String bkgStsCd = null;
                    bkgStsCd = bookingUtil.searchBkgStatusByBkg(bkgBlNoVO);  

                    if(isNull(bkgStsCd)){
                    	if(!bkgBlNoVO.getXterBkgRqstCd().equalsIgnoreCase("WEB")){
    						BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
    						bkgNo = newBkgNoVO.getBkgNo() + "00";
    						blNo  = bkgNo;
    					} else {
							if(bkgBlNoVO.getBkgNo() != null && bkgBlNoVO.getBkgNo().length() == 12){       
								bkgNo = bkgBlNoVO.getBkgNo();
		                    	blNo = bkgNo;  
							}else{
								BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
								bkgNo = newBkgNoVO.getBkgNo() + "00";
								blNo  = bkgNo;
							}
    					}
					} else {
						throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
				} else { //  in case of Saving without bkg no
					BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
					bkgNo = newBkgNoVO.getBkgNo() + "00";
					blNo  = bkgNo;
				}
			} else {
				bkgNo = bkgBlNoVO.getBkgNo();
				blNo  = bkgNo;
				// recording bkg creatation in agent manual booking no getting table
				List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVO = new ArrayList<BkgChnBkgNoGenVO>();
				bkgChnBkgNoGenVO.add(new BkgChnBkgNoGenVO());				
				bkgChnBkgNoGenVO.get(0).setBkgNo(bkgNo);
				masterBC.modifyChnBkgNoUseFlgOnList(bkgChnBkgNoGenVO, bkgBookingInfoVO.getBkgPorCd() , account);
			}
			bkgBlNoVO.setBkgNo(bkgNo);
			if(bkgBlNoVO.getBlNo() == null || bkgBlNoVO.getBlNo().equals(""))
				bkgBlNoVO.setBlNo(blNo);
			
			bkgBookingInfoVO.setBkgNo(bkgNo);
			bkgBookingInfoVO.setBlNo(bkgBlNoVO.getBlNo());
			
			bookingCreationVO.setBkgBlNoVO(bkgBlNoVO);
			bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);

			/* BKG PTY */
			if(bkgBookingInfoVO.getXterBkgRqstCd() != null && bkgBookingInfoVO.getXterBkgRqstCd().equals("WEB")){
				BkgXterUsrInfoVO usrInfoVo = bookingUtil.searchBkgPtyXterUsrInfo(xterRqstNoVO);
				bkgBookingInfoVO.setBkgPtyCntCd(usrInfoVo.getCustCntCd());
				bkgBookingInfoVO.setBkgPtyCustSeq(usrInfoVo.getCustSeq());
			}else{
				bkgBookingInfoVO.setBkgPtyCntCd(bookingCreationVO.getBlCustomerInfoVO().getSCustCntCd());
				bkgBookingInfoVO.setBkgPtyCustSeq(bookingCreationVO.getBlCustomerInfoVO().getSCustSeq());
			}
			
			// 03. createBooking
			receiptBC.createBooking(bookingCreationVO, account);

			// 04. createBkgBlDocByBKG
			blDocBC.createBkgBlDocByBKG(bkgNo, bookingCreationVO.getBookingSaveValidationVO().getBlMoveTpNm(),
											   bkgBookingInfoVO,  
											   account);

			// 09. Booking Status change
			receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
			
			// 05. createBkgHistoryLine
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(bkgNo);
			historyLineVO.setCaFlg("N");
			historyLineVO.setBkgDocProcTpCd("BKGCRE");
			historyLineVO.setUiId("ESM_BKG_0229");
			historyLineVO.setCrntCtnt("Booking Created.");
			historyLineVO.setHisCateNm("Booking Creation"); 

			historyBC.createBkgHistoryLine(historyLineVO, account);

			//In case of inputting sc or rfa
			if((bkgBookingInfoVO.getScNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getScNo().substring(0, 3)))
				||(bkgBookingInfoVO.getRfaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getRfaNo().substring(0, 3)))){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);
			}
			
			// In case of first creation , cnee input
			if(!isNull(bookingCreationVO.getBlCustomerInfoVO().getCCustCntCd())&&!isNull(bookingCreationVO.getBlCustomerInfoVO().getCCustSeq())){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee no input for doc performance				
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);
			} 					
			
			// 09. createBkg
			copBc.createBkg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getPctlNo());	
		}catch(EventException e){
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return bookingCreationVO;		
	}

	/**
	 *  In case of Route, Booking Save.(ESM_BKG_0079_01)<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithoutRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
			BookingUtil            util  = new BookingUtil();
						
			// repository of all Booking  Information
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// collecting Validation result
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();
			
			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());

			// all update at ebkg
			bookingSaveValidationVO.setRouteModifyFlag("Y");
			bookingSaveValidationVO.setCustomerModifyFlag("Y");
			bookingSaveValidationVO.setContactModifyFlag("Y");
			bookingSaveValidationVO.setQtyModifyFlag("Y");
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			/************* findFullRoute *******************/
			PrdParameterVO prdParameterVO = util.findFullRoute(bookingCreationVO);
			util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
			
			// 03. createProdCtlRout 
			String pctlNo = null;
			String mapSeq = null;
			try{
				String pctlNoMapSeqStr = proBC.createPrdCtlgRout(prdParameterVO, account);

				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				pctlNo = pctlNoMapSeq[0];
				mapSeq = pctlNoMapSeq[1];
			} catch (Exception pc_ex){
				eventResponse.setETCData("IsPctlNoPop", "YC");				
				log.debug("Pctl Pop Up Call");
				log.error("Pctl Pop Up Call");
				rollback();
				return eventResponse;	
			}									

			log.debug(" Pctl No : [" + pctlNo + "]");			
		
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
				bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNo);	
				bookingCreationVO.getBkgBlNoVO().setMapSeq(mapSeq);	
			}else{
				eventResponse.setETCData("IsPctlNoPop", "YC");
				
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;				
			}
				
			/********   createBkgWithRoute  ************/
			bookingCreationVO = createBkgInfo(bookingCreationVO, event.getXterRqstNoVO());
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
					rollback();
					eventResponse.setETCData("cbfBkgFlag", "Y");
					eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
					eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else {
				eventResponse.setETCData(bookingCreationVO.getBkgBookingInfoVO().getColumnValues());				
				eventResponse.setETCData("ResultMsg", bookingCreationVO.getBookingSaveValidationVO().getSaveMsg());
				
				String resultMsg = bookingCreationVO.getBookingSaveValidationVO().getSaveMsg();
				if(resultMsg != null && resultMsg.length() > 0 ){
					if(resultMsg.startsWith(",")){
						resultMsg = resultMsg.substring(1, resultMsg.length());
					}
					StringTokenizer st = new StringTokenizer(resultMsg, ",");
					while(st.hasMoreTokens()){
						eventResponse.setUserMessage(new ErrorHandler(st.nextToken()).getUserMessage());
					}
				}			
				eventResponse.setETCData("closeBkgFlag", "N");
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");
				eventResponse.setETCData("psaValMsg", "Y");
			}
			eventResponse.setETCData("bkg_no", bookingCreationVO.getBkgBlNoVO().getBkgNo());
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * In case of changing Route, Booking Save.(ESM_BKG_0079_01)<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithoutRouteByXter(Event e) throws EventException {
		try {
			return createBkgWithoutRoute(e);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * In case of Route, Booking Save.(ESM_BKG_0079_01)<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithoutRouteByXterTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse = (GeneralEventResponse) createBkgWithoutRouteByXter(e);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * In case there's no changing in Route, Booking Save.(ESM_BKG_0079_01)<br>

	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			BookingUtil util = new BookingUtil();

			// repository of Booking all Information 
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// VO of collecting Validation result
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			
			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			
			bookingSaveValidationVO.setRouteModifyFlag("Y");
			bookingSaveValidationVO.setCustomerModifyFlag("Y");
			bookingSaveValidationVO.setContactModifyFlag("Y");
			bookingSaveValidationVO.setQtyModifyFlag("Y");			
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			//pctlNo set
			String [] pctlNoMapSeq = util.splitByToken(event.getPctlNo(), "|");
			bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNoMapSeq[0]);	
			bookingCreationVO.getBkgBlNoVO().setMapSeq(pctlNoMapSeq[1]);	

			BkgDocProcSkdVO toyotaBlDocProcSkdVO = null;
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			/* 도요타 Bl 확인 */
			if(bkgBlNoVO.getBkgTyFlg().equals("Y")){
				BkgBlNoVO toyotaBlNoVO = util.manageToyotaBlNumberGeneration("TYB", account.getOfc_cd(), account.getUsr_id());
				bkgBlNoVO.setBlNo(toyotaBlNoVO.getBlNo());
				bkgBookingInfoVO.setBlNo(toyotaBlNoVO.getBlNo());
				bkgBookingInfoVO.setIrrBlNoFlg("Y");
				
				toyotaBlDocProcSkdVO = new BkgDocProcSkdVO();
				toyotaBlDocProcSkdVO.setCreUsrId(account.getUsr_id());
				toyotaBlDocProcSkdVO.setBkgDocProcTpCd("BLTOYO");
				toyotaBlDocProcSkdVO.setDiffRmk(toyotaBlNoVO.getBlNo());
			}
			
			bookingCreationVO.setBkgBlNoVO(bkgBlNoVO);
			bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
			
			bookingCreationVO = createBkgInfo(bookingCreationVO, event.getXterRqstNoVO());

			if(toyotaBlDocProcSkdVO != null){
				toyotaBlDocProcSkdVO.setBkgNo(bookingCreationVO.getBkgBlNoVO().getBkgNo());
				receiptBC.addBkgDocProcSkd(toyotaBlDocProcSkdVO);
			}
			
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
				rollback();
				eventResponse.setETCData("cbfBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else {
				eventResponse.setETCData(bookingCreationVO.getBkgBookingInfoVO().getColumnValues());				
				eventResponse.setETCData("ResultMsg", bookingCreationVO.getBookingSaveValidationVO().getSaveMsg());		
	
				String resultMsg = bookingCreationVO.getBookingSaveValidationVO().getSaveMsg();
				if(resultMsg != null && resultMsg.length() > 0 ){
					if(resultMsg.startsWith(",")){
						resultMsg = resultMsg.substring(1, resultMsg.length());
					}
					StringTokenizer st = new StringTokenizer(resultMsg, ",");
					while(st.hasMoreTokens()){
						eventResponse.setUserMessage(new ErrorHandler(st.nextToken()).getUserMessage());
					}
				}			
				eventResponse.setETCData("closeBkgFlag", "N");	
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");		
				eventResponse.setETCData("psaValMsg", "Y");
			}
			
			BkgBookingInfoVO bookinginfoVo = bookingCreationVO.getBkgBookingInfoVO();
			BlCustomerInfoVO custVo = bookingCreationVO.getBlCustomerInfoVO();
			if(!bookinginfoVo.getBkgTyFlg().equals("Y") && event.getBkgBlNoVO().getUsrToyotaCheck().equals("N")){
				String count = receiptBC.toyotaBlNoCheck(bookinginfoVo, custVo);
				if(!count.equals("0")){
					eventResponse.setETCData("Toyota", "Y");	
					rollback();
				}
			}
			
			eventResponse.setETCData("bkg_no", bookingCreationVO.getBkgBlNoVO().getBkgNo());
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * In case of Route, Booking Save.(ESM_BKG_0229)<br>

	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithRouteByXter(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse = (GeneralEventResponse) createBkgWithRoute(e);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * In case of Route  Booking Save.(ESM_BKG_0229)<br>
	 * including Transaction 
	 * 

	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithRouteByXterTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse = (GeneralEventResponse) createBkgWithRouteByXter(e);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * getting Product Control No<br>
	 * 

	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPctlNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			BookingUtil util = new BookingUtil();

			//begin();

			// repository of Booking all Information 
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// VO of collecting Validation result
			BookingSaveValidationVO bookingSaveValidationVO = new BookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			/************* findFullRoute *******************/
			PrdParameterVO prdParameterVO = util.findFullRoute(bookingCreationVO);
			util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

			// 03. createProdCtlRout 
			ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
			String pctlNo = null;

			// If P/C creating is failed, keep going on because It is on test
			//			try {
			pctlNo = proBC.createPrdCtlgRout(prdParameterVO, account);				
			//			} catch(EventException ex) {
			//				log.debug("If P/C creating is failed, keep going on because It is on test");
			//			}	

			log.debug(" Pctl No : [" + pctlNo + "]");


			//			pctlNo = null;
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
				//pctlNo set
				bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNo);			
				eventResponse.setETCData("pctl_no", pctlNo);	
			}else{
				eventResponse.setETCData("IsPctlNoPop", "YC");
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;				
			}
		} catch(EventException ex){
			//			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			//			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0228 : DELETE click
	 * changing to delete position for rqst <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0228Event event = (EsmBkg0228Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			command.changeXterRqstStatus(event.getXterRqstNoVOs(), "D", "" ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 *  update recalculating at COA<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param       String remark
	 * @param       SignOnUserAccount account
	 * @return 		void
	 * @exception 	EventException
	 */
	private void interfaceToCoa(BkgBlNoVO bkgBlNoVO, String remark, SignOnUserAccount account)throws EventException{
		CostAssignBC coaBc = new CostAssignBCImpl();
		try {
			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			coaBkgComIfVo.setCostSrcSysCd("BKG");
			coaBkgComIfVo.setIfRmk(remark);
			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
		} catch(EventException ex) {
			log.error("TO COA error bkg no : " + bkgBlNoVO.getBkgNo());
			throw ex;
		} catch(Exception ex) { 
			log.error("TO COA error bkg no : " + bkgBlNoVO.getBkgNo());
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * booking data interface in INV<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO, SignOnUserAccount account
	 * @return 		void
	 * @exception 	EventException
	 */
	private void interfaceToInv(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws EventException{
		BookingARCreationBC invBc = new BookingARCreationBCImpl();
		ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();

		bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
		bkgIfVo.setUserId(account.getUsr_id());
		bkgIfVo.setManDivInd("B");

		try {
			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
		} catch(EventException ex) {
			log.error("TO INV error bkg no : " + bkgBlNoVO.getBkgNo());
			throw ex;
		} catch(Exception ex) { 
			log.error("TO INV error bkg no : " + bkgBlNoVO.getBkgNo());
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * Null check<br>
	 *
	 * @param String str
	 * @return boolean
	 */
	private boolean isNull(String str) {
		return (str==null || str.trim().length()==0 || "null".equals(str));
	}
	/**
	 * ESM_BKG_0229_09 : Awkward Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAwk(Event e) throws EventException {

		EsmBkg022909Event event = (EsmBkg022909Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoReceiptBC specialCargoReceiptBC = new SpecialCargoReceiptBCImpl();
		BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();  
		try {
			AwkCgoApplVO awkCgoApplVO = new AwkCgoApplVO();
			awkCgoApplVO.setBkgAwkCgoVOs(event.getBkgAwkCgoVOs());
			awkCgoApplVO.setAccount(account);
			awkCgoApplVO.setBkgNo(bkgBlNoVO.getBkgNo());
//			awkCgoApplVO.setIbflag("ESM_BKG_0229");
			awkCgoApplVO.setUiId("ESM_BKG_0229");
			specialCargoReceiptBC.manageAwkCargo(awkCgoApplVO, bkgBlNoVO.getCaFlg());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_09 : Awkward Save (including Transaction )
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAwkTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			eventResponse = (GeneralEventResponse) manageAwk(e);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_05 : Save handling<br>
	 * CM contents validation and Save handling<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCm(Event e) throws EventException {
		EsmBkg022905Event event = (EsmBkg022905Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();		

		BookingUtil utilCmd = new BookingUtil();
		List<BkgBookingVO> bkgBookingVOs = null;
		BkgBookingVO bkgBookingVO = new BkgBookingVO();
		String blckStwgCd = null;

		BkgBlNoVO bkgBlNoVO = null;
		if(event.getBkgBlNoVO()==null){
			bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(event.getBkgNo());
			bkgBlNoVO.setCaFlg("N");
		} else {
			bkgBlNoVO = event.getBkgBlNoVO();
		}
		String bkgNo = bkgBlNoVO.getBkgNo();
		String caFlg = bkgBlNoVO.getCaFlg();
		 
		//cntr of cntr tab
		ContainerVO[] containerVOs = event.getContainerVOs();
		CmVO cmVO = event.getCmVO();
		cmVO.getCmBkgInfoVO().setBkgNo(bkgNo);
		CmBkgInfoVO cmBkgInfoVO = cmVO.getCmBkgInfoVO();

		List<BkgCntrMfDescVO> cntrMfDescVO = cmVO.getBkgCntrMfDescVOs();
		List<BkgCntrMfDescVO> bkgCntrMfDescVOs = new ArrayList<BkgCntrMfDescVO>();
		try {			
            int len_cntr = containerVOs == null ? 0 : containerVOs.length;
            int len_cm = cntrMfDescVO == null ? 0 : cntrMfDescVO.size();
            int len_cm_cntr = 0;
            
            if ( len_cntr != 0 ) {
	            for(int i = 0; i < len_cm; i++) {
	            	len_cm_cntr = 0;
	                for(int j = 0; j < len_cntr; j++) {
	                	//exception if there is no cntrNo
	                	if ( cntrMfDescVO.get(i).getCntrNo().equals(containerVOs[j].getCntrNo()) ){
	                		//in case of deleting cntr, delete cm
	                		if ("D".equals(containerVOs[j].getIbflag())) {
	                			cntrMfDescVO.get(i).setIbflag("D");
	                		}
	                		len_cm_cntr++;
	                	} 
	                }
	                if ( len_cm_cntr > 0 )
	                	bkgCntrMfDescVOs.add(cntrMfDescVO.get(i));
	            }
	
	            cmVO.setCntrMfDescVOs(bkgCntrMfDescVOs);
	            
				/* Validate Container */
	            blCmBC.validateCm(cmVO);
				
	            /* 툭수문자 처리 */
	            cmVO = blCmBC.checkSpecialValue(cmVO);
	            
				/* Manage CM */
	            blCmBC.manageCmByXter(cmVO, account, caFlg);
	            
				/*
				 * BOOKING.BLOCK STOWAGE CODE update : If commodity is NOTE BOOK, LCD-TFT, COLOR MONITOR, MONITOR, SHOE and POD가
				 * "USLAX"or  "USLGB" , update BOOKING.BLOCK STOWAGE CODE to LB4.
				 */

				bkgBookingVOs = utilCmd.searchBookingSplitNo(bkgNo);
				if(bkgBookingVOs.size()>0) {
					bkgBookingVO = bkgBookingVOs.get(0);
					blckStwgCd = bkgBookingVO.getBlckStwgCd();
				}
	            if(bkgCntrMfDescVOs != null && bkgCntrMfDescVOs.size() > 0){
					// update handling in case of LB2, LB3                
                    if("LB2".equals(blckStwgCd) || "LB3".equals(blckStwgCd)) {
                         for(int i=0;i<bkgCntrMfDescVOs.size();i++){
                             String gdsDesc = bkgCntrMfDescVOs.get(i).getCntrMfGdsDesc();
                             if (gdsDesc != null && 
                               (gdsDesc.indexOf("NOTE BOOK") >= 0 || 
                                gdsDesc.indexOf("NOTEBOOK") >= 0 || 
                                gdsDesc.indexOf("LCD") >= 0 || 
                                gdsDesc.indexOf("TFT") >= 0 || 
                                gdsDesc.indexOf("MONITOR") >= 0 || 
                                gdsDesc.indexOf("SHOE") >= 0 || 
                                gdsDesc.indexOf("FOOTWEAR") >= 0 || 
                                gdsDesc.indexOf("FOOT WEAR") >= 0) && 
                               ("USLAX".equals(cmBkgInfoVO.getPodCd()) || "USLGB".equals(cmBkgInfoVO.getPodCd()))) {
           							bkgBookingVO.setBkgNo(bkgNo);
           							bkgBookingVO.setBlckStwgCd("LB4");
           							receiptBC.modifyBkgByCm(bkgBookingVO, caFlg);
           							break;
                             }
                         }
                    }
	            }
            }
            
            BkgCntrShpVO[] bkgCntrShpVOs = event.getBkgCntrShpVOs();
            blCmBC.manageCmBkgCntrShp(account, bkgNo, bkgCntrShpVOs);
            
			/* Set Message */
			eventResponse.setUserMessage("");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_05 : Save handling<br>
	 * CM contents validation and Save handling<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCmTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageCm(e);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Container Tab(ESM_BKG_0229_03) Save handling<br>
	 * (There's no Transaction handling (begin, commit, rollback) )<br> 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainer(Event e) throws EventException {
		EsmBkg022903Event event = (EsmBkg022903Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();
			BLDocumentationCMBC 	blCmBC 		= new BLDocumentationCMBCImpl();
			BookingUtil 			util 		= new BookingUtil();
			BlRatingBC 				rateBC	 	= new BlRatingBCImpl();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BookingHistoryMgtBC 	histCmd 	= new BookingHistoryMgtBCImpl();
	        BkgCopManageBC 			copCmd 		= new BkgCopManageBCImpl();
		
			BkgBlNoVO bkgBlNoVO = null;
			if(event.getBkgBlNoVO()==null){
				bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(event.getBkgNo());
			} else {
				bkgBlNoVO = event.getBkgBlNoVO();
			}
			String bkgNo = bkgBlNoVO.getBkgNo();			
			String caFlag = bkgBlNoVO.getCaFlg();
	
			CntrEtcInfoVO 		bkgEtcInfoVO 		= event.getBkgEtcInfoVO();
			ContainerVO[] 		containerVOs 		= event.getContainerVOs();
			BkgCntrSealNoVO[] 	bkgCntrSealNoVOs 	= event.getBkgCntrSealNoVOs();
						
			//define Container Type Size Code 
			List<MstContainerVO> list = null;
			String cntrTpszCd = null;
			CntrDetailInfoVO detailVo = null;
			
			/* final confirm */
			String fnlCfmFlg = (bkgEtcInfoVO.getFnlCfmFlg()==null)?"N":bkgEtcInfoVO.getFnlCfmFlg();
				
			/* Validate Container */
			CntrEtcInfoVO 		bkgEtcInfoVvdVO 		= null;
			bkgEtcInfoVvdVO = command.manageCntrEtcInfo(bkgBlNoVO);
			
//			bkgEtcInfoVO.setBkgNo(bkgNo);
//			bkgEtcInfoVO.setTVvd(bkgEtcInfoVvdVO.getTVvd());
//			bkgEtcInfoVO.setBkgCgoTpCd(bkgEtcInfoVvdVO.getBkgCgoTpCd());
//			blCmBC.validateContainer(bkgEtcInfoVO, containerVOs, fnlCfmFlg);
//			blCmBC.validateContainer(bkgEtcInfoVvdVO, containerVOs, fnlCfmFlg);

			List<Map<String,Object>> copCallList = null;
			HistoryLineVO historyLineVO = null;
			BkgDocProcSkdVO bkgDocProcSkdVO = null;
			String uiId = "ESM_BKG_0229_03";
			
			copCallList = blCmBC.validateContainer(bkgEtcInfoVvdVO, containerVOs, fnlCfmFlg);
			if (null!=copCallList && 0<copCallList.size()) {
				for (Map<String,Object> map : copCallList) {
					historyLineVO = new HistoryLineVO();
					historyLineVO.setBkgNo((String)map.get("bkgNo"));
					historyLineVO.setCaFlg((String)map.get("caFlg"));
					historyLineVO.setCrntCtnt("Detach Container : "+(String)map.get("cntrNo"));
					historyLineVO.setHisCateNm("Container No.");
					historyLineVO.setLocalTime("");
					historyLineVO.setPreCtnt(" ");
					historyLineVO.setUiId(uiId);
					histCmd.createBkgHistoryLine(historyLineVO, account);

					bkgDocProcSkdVO = new BkgDocProcSkdVO();
					bkgDocProcSkdVO.setBkgNo((String)map.get("bkgNo"));
					bkgDocProcSkdVO.setBkgDocProcTpCd("CNTCFM");
					bkgDocProcSkdVO.setDocPerfDeltFlg("N");
					if (null!=util.searchDocProcSkd(bkgDocProcSkdVO,(String)map.get("caFlg"))) {
						this.cancelContainerConfirm((String)map.get("bkgNo"), null);
					}
					//calling cop
					copCmd.detachCntr((String)map.get("bkgNo"), (String)map.get("cntrNo"), (String)map.get("cntrPrtFlg"));
				}
			}

			/* SealNo */
			List<BkgCntrSealNoVO> updateSealVoList = new ArrayList<BkgCntrSealNoVO>();
			List<BkgCntrSealNoVO> deleteSealVoList = new ArrayList<BkgCntrSealNoVO>();
			int sealLen = (bkgCntrSealNoVOs == null) ? 0 : bkgCntrSealNoVOs.length;
			for (int i = 0; i < sealLen; i++) {
				if ("D".equals(bkgCntrSealNoVOs[i].getIbflag())) {
					deleteSealVoList.add(bkgCntrSealNoVOs[i]);
				} else {
					BkgCntrSealNoVO sealNoVO = bkgCntrSealNoVOs[i];
					if ( sealNoVO.getCntrSealNo().trim().length() > 0 
							&& sealNoVO.getCntrSealNo().trim() != null
							&& sealNoVO.getCntrSealNo().trim() != "") {
						bkgCntrSealNoVOs[i].setCreUsrId(account.getUsr_id());
						bkgCntrSealNoVOs[i].setUpdUsrId(account.getUsr_id());
						bkgCntrSealNoVOs[i].setBkgNo(bkgNo);
						bkgCntrSealNoVOs[i].setPrnFlg("1");
						if ("I".equals(bkgCntrSealNoVOs[i].getIbflag()) && "Y".equals(bkgEtcInfoVvdVO.getCnFlg())) {
							bkgCntrSealNoVOs[i].setSealKndCd("M");
						}
						updateSealVoList.add(bkgCntrSealNoVOs[i]);
					}
				}
			}

			/* Container */
			//List<ContainerVO> insertVoList = new ArrayList<ContainerVO>();
			List<ContainerVO> updateVoList = new ArrayList<ContainerVO>();
			List<ContainerVO> deleteVoList = new ArrayList<ContainerVO>();
			List<ContainerVO> changeVoList = new ArrayList<ContainerVO>();
			int cntrLen = containerVOs == null ? 0 : containerVOs.length;
			for (int i = 0; i < cntrLen; i++) {
				detailVo = null;
				String ibflag = containerVOs[i].getIbflag();
				containerVOs[i].setCreUsrId(account.getUsr_id());
				containerVOs[i].setUpdUsrId(account.getUsr_id());
				
				//getting R/D Term data in Booking
//				containerVOs[i].setRcvTermCd(bkgBookingInfoVO.getRcvTermCd());
//				containerVOs[i].setDeTermCd(bkgBookingInfoVO.getDeTermCd());
				
				// getting Container Type Size Code
				list = util.searchTypeSizeByCntr(containerVOs[i].getCntrNo());
				if (list != null && list.size() > 0) {
					MstContainerVO mstContainerVO = (MstContainerVO) list.get(0);
					cntrTpszCd = mstContainerVO.getCntrTpszCd();
				}
				containerVOs[i].setCntrTpszCd(cntrTpszCd);
				if (null!=cntrTpszCd && 0==cntrTpszCd.indexOf("R")) {
					containerVOs[i].setRdCgoFlg("Y");
				}
				
				//Incase R type Container is inputted , rdCgoFlg Default Setting to ‘Y’ 
				if (null!=cntrTpszCd && 0==cntrTpszCd.indexOf("R")) {
					containerVOs[i].setRdCgoFlg("Y");
				}
				if ("I".equals(ibflag)) {
					detailVo = blCmBC.searchCntrDtlInfo(containerVOs[i].getCntrNo());
					containerVOs[i].setSocFlg(detailVo.getSocFlg());
					if (containerVOs[i].getCntrVolQty() == null 
						|| "".equals(containerVOs[i].getCntrVolQty().trim()) 
						|| new Float (containerVOs[i].getCntrVolQty()).compareTo(new Float(0.0)) == 0) {
						containerVOs[i].setCntrVolQty("1");
						containerVOs[i].setBkgNo(bkgNo);
					}
					updateVoList.add(containerVOs[i]);
				} else if ("U".equals(ibflag)) {
					if (containerVOs[i].getCntrNo().equals(containerVOs[i].getCntrNoOld())) {
						updateVoList.add(containerVOs[i]);
					} else {
						detailVo = blCmBC.searchCntrDtlInfo(containerVOs[i].getCntrNo());
						containerVOs[i].setSocFlg(detailVo.getSocFlg());
						if (containerVOs[i].getCntrVolQty() == null 
							|| "".equals(containerVOs[i].getCntrVolQty().trim()) 
							|| new Float (containerVOs[i].getCntrVolQty()).compareTo(new Float(0.0)) == 0) {
							containerVOs[i].setCntrVolQty("1");
						}
						changeVoList.add(containerVOs[i]);
					}
				} else if ("D".equals(ibflag)) {
					deleteVoList.add(containerVOs[i]);
				}
			}

			/* SealNo Delete */
			if (deleteSealVoList.size() > 0) {
				blCmBC.removeCntrSealNo(deleteSealVoList, caFlag);
			}
			/* Container Delete */
			for (int i = 0; i < deleteVoList.size(); i++) {
				String cntrNo = deleteVoList.get(i).getCntrNo();
				// 1. remove SealNo
				blCmBC.removeCntrSealNo(bkgNo, cntrNo, "", caFlag);
				// 2. remove Rate
				rateBC.removeCntrRateByCntr(bkgNo, cntrNo, "");
				// 3. remove Reference detail
				receiptBC.removeReferenceByCntr(bkgNo, cntrNo, caFlag);
				// 4. remove Reference
				receiptBC.removeReferenceDetailByCntr(bkgNo, cntrNo, caFlag);
				// 5. remove Manifest
				blCmBC.removeCntrMfDesc(bkgNo, cntrNo, caFlag);
				// 6. remove Container
				blCmBC.removeContainer(bkgNo, cntrNo, caFlag);
//				// 7. remove Po No
//				blCmBC.removePoNo(bkgNo, cntrNo, caFlag);
			}

			/* Container Merge */
			blCmBC.manageContainer(updateVoList, caFlag, "ESM_BKG_0229");
			
			/* Container Change */
			for (int i = 0; i < changeVoList.size(); i++) {
				String cntrNo = changeVoList.get(i).getCntrNo();
				String cntrNoOld = changeVoList.get(i).getCntrNoOld();
				// 1. insert Container
				// 4. change Manifest
				blCmBC.changeCntrMfDesc(bkgNo, cntrNo, cntrNoOld, caFlag);
				// 5. change Rate
				rateBC.changeCntrRate(bkgNo, cntrNo, cntrNoOld);
				// 6. delete Container(Old)
				blCmBC.removeContainer(bkgNo, cntrNoOld, caFlag);
			}
			/* SealNo Merge */
			if (updateSealVoList.size() > 0) {
				blCmBC.manageCntrSealNo(updateSealVoList, caFlag);
			}

			/* Manage Credit Date */
			rateBC.manageCrdDt(bkgNo, bkgEtcInfoVO.getEvntDt(), caFlag);

			/* Manage Doc Process */
			// There's no final confirm in eBKG
//			if (!"".equals(modifyFnlCfmFlg) && "N".equals(caFlag)) {
//				String uiId = "ESM_BKG_0229_03";
//				HistoryLineVO historyLineVO = new HistoryLineVO();			
//				historyLineVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
//				historyLineVO.setBkgNo(bkgNo);
//				historyLineVO.setCaFlg(caFlag);
//				historyLineVO.setCrntCtnt("");
//				historyLineVO.setHisCateNm("");
//				historyLineVO.setLocalTime("");
//				historyLineVO.setUiId(uiId);
//				historyBC.createBkgHistoryLine(historyLineVO, account);
//			}
			
			/* VGM 신규 조건 */
			try{
				List<XterCntrVO> vgmList = command.searchXterCntrVgm(bkgEtcInfoVO.getSenderId(), bkgEtcInfoVO.getRqstNo(), bkgEtcInfoVO.getRqstSeq());
				if(vgmList != null){
					for (int i = 0; i < vgmList.size(); i++) {
						XterCntrVO xter = vgmList.get(i);
						xter.setBkgNo(bkgNo);
						xter.setUsrId("304");
						if(account == null)
							xter.setCreUsrId("SYSTEM");
						else
							xter.setCreUsrId(account.getUsr_id());
						String count = command.selectBkgXterVgm(xter);
						if((count == null || count.equals("0")) && (xter.getVgmWgt() != null && !xter.getVgmWgt().equals("") && !xter.getVgmWgt().equals("0"))){
							command.manageXterVgm(xter);
						}
					}
				}
			}catch(Exception e1){
				log.error(e1);
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_03 : Save handling<br>
	 * Container contents Checking and Save handling<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			manageContainer(e);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_08 : Danger Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDg(Event e) throws EventException {

		EsmBkg022908Event event = (EsmBkg022908Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoReceiptBC specialCargoReceiptBC = new SpecialCargoReceiptBCImpl();
		BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();  
		try {
			DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
			dgCgoApplVO.setDgCgoListVOs(event.getDgCgoListVOs());
			dgCgoApplVO.setAccount(account);
			dgCgoApplVO.setBkgNo(bkgBlNoVO.getBkgNo());
//			dgCgoApplVO.setIbflag("ESM_BKG_0229");
			dgCgoApplVO.setUiId("ESM_BKG_0229");
			specialCargoReceiptBC.manageDgCargo(dgCgoApplVO, bkgBlNoVO.getCaFlg());
			
			if(event.getBkgImgStoVO() != null){
				SpecialCargoRiderBC specialCargoRiderBC = new SpecialCargoRiderBCImpl();
				specialCargoRiderBC.manageSpclRider(event, account);
			}
			
			// d/g rider 처리
//			if (event.getSpclRiderInVO() != null) {
//				SpecialCargoRiderBC specialCargoRiderBC = new SpecialCargoRiderBCImpl();
//				SpclRiderInVO spclRiderInVO = event.getSpclRiderInVO();
//				spclRiderInVO.setAccount(account); 
//				BkgImgStoVO[] bkgImgStoVO = spclRiderInVO.getBkgImgStoVOs();
//				if( null != bkgImgStoVO ){
//					specialCargoRiderBC.manageSpclRider(spclRiderInVO);
//				}
//			}
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_08 : Danger Save<br>
	 * Transaction handling 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDgTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageDg(e);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_10 : Save handling<br>
	 * HBL contents checking and Save handling<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHbl(Event e) throws EventException {

		EsmBkg022910Event event = (EsmBkg022910Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		
		HblVO hblVO = event.getHblVO();
		XterRqstNoVO rqstNoVO = event.getXterRqstNoVO();		
		BkgBlNoVO bkgBlNoVO = null;	
		
		List<HblDtlInfoVO> hblDtlVO = hblVO.getHblDtlInfoVOs();
        String mfNo   = null;	
        String hblSeq = null;
        
		
		if(event.getBkgBlNoVO()==null){
			bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(event.getBkgNo());
		} else {
			bkgBlNoVO = event.getBkgBlNoVO();
		}
		
		try {
			// validate
			docCmd.validateHbl(hblVO);
			// manage house b/l
			docCmd.manageHblByXter(hblVO, rqstNoVO, account, bkgBlNoVO.getCaFlg());
			
			for(int i = 0; i < hblDtlVO.size(); i++) {
				if("I".equals(hblDtlVO.get(i).getIbflag())) {
					hblSeq = hblDtlVO.get(i).getHblSeq();
		            /* search maximum MfNo */
		            
					String bl_no = bkgBlNoVO.getBlNo();
		            if(bl_no != null){
		            	if(!"".equals(bl_no) && bl_no.length() >= 12){
			        		bl_no = bl_no.substring(0,12);
			    		}else if (!"".equals(bl_no) && bl_no.length() >= 10){
			    			bl_no = bl_no.substring(0,10);
			    		} 
		            }
		            mfNo = docCmd.searchMaxMfNo(bkgBlNoVO.getBkgNo(), bl_no, bkgBlNoVO.getCaFlg());               
		            log.debug("=====> mfNo    : " + mfNo);
		            
		            /* update MfNo */
		            docCmd.modifyNvoccFileNo(bkgBlNoVO.getBkgNo(), hblSeq, mfNo, account, bkgBlNoVO.getCaFlg());
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_11 : Save handling<br>
	 * HBL2 contents checking and  Save handling<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHbl2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022911Event event = (EsmBkg022911Event) e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		try {
			// 01. managing Direct NVO-AMS File No
			receiptBC.manageNVOFileNumber(event.getBkgUsaCstmsFileNoVOs(), account, event.getBkgBlNoVO());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_11 : Save handling<br>
	 * HBL2 contents checking and Save handling<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHbl2Tx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageHbl2(e);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_10 : Save handling<br>
	 * HBL contents checking and Save handling<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHblTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageHbl(e);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}
	/**
	 * M&D TAB(ESM_BKG_0229_04) contents checking and Save handling<br>
	 * (Transaction begin, commit, rollback )<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMnd(Event e) throws EventException {
		EsmBkg022904Event event = (EsmBkg022904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BlRatingBC rateCmd = new BlRatingBCImpl();
			BookingUtil util = new BookingUtil();
			
			BkgBlNoVO bkgBlNoVO = null;
			if(event.getBkgBlNoVO()==null){
				bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(event.getBkgNo());
				bkgBlNoVO.setCaFlg("N");
			} else {
				bkgBlNoVO = event.getBkgBlNoVO();
			}
			
			/* Validate MnD */
			event.getMndVO().setBkgNo(bkgBlNoVO.getBkgNo());
			event.getMndVO().setBdrFlg(bkgBlNoVO.getBdrFlg());
			blDocBC.validateMnd( event.getMndVO());
			
			event.getMndVO().setMkDesc(util.makeWordWrap(event.getMndVO().getMkDesc(), 16));
			event.getMndVO().setDgCmdtDesc(util.makeWordWrap(event.getMndVO().getDgCmdtDesc(), 33));
			
			/* Manage MnD */
			blDocBC.manageMnd( event.getMndVO(), account, bkgBlNoVO.getCaFlg());
			
			/* Manage Rate*/
			event.getMndVO().setFrtTermPrnFlg("Y");
			rateCmd.manageFrtTerm(bkgBlNoVO.getBkgNo(), event.getMndVO().getFrtTermCd(), event.getMndVO().getFrtTermPrnFlg(), account, bkgBlNoVO.getCaFlg());
			
			/* Export License Number */
			blDocBC.manageXptLicByXter(bkgBlNoVO, event.getOpusXptImpLicListVOs(), account);

			
			/* P/O & Other No */
			PoOtherNoVO poOtherNoVO = new PoOtherNoVO();
			PoOtherNoBkgVO poOtherNoBkgVO = new PoOtherNoBkgVO();
			poOtherNoBkgVO.setBkgNo(bkgBlNoVO.getBkgNo());
						
			poOtherNoVO.setIo_poOtherNoBkgVO(poOtherNoBkgVO);//condition
			poOtherNoVO.setI_poOtherNoBkgVOs(event.getPoOtherNoBkgVOs());//bkg
			poOtherNoVO.setI_poOtherShipVOs(event.getPoOtherShipVOs());// ship -> eBKG에는 없음
			poOtherNoVO.setI_poOtherCntrVOs(event.getPoOtherCntrVOs());// cntr
			poOtherNoVO.setI_poOtherCmVOs(event.getPoOtherCmVOs()); // cm
			poOtherNoVO.setAccount(account);

			receiptBC.manageRefNo(poOtherNoVO, bkgBlNoVO.getCaFlg());
			
			receiptBC.manageRefDetail(poOtherNoVO, bkgBlNoVO.getCaFlg());
//			if(event.getPoOtherCmVOs()!=null && event.getPoOtherCmVOs().length>0){
//				BkgRefDtlVO[] cmPoVOs = event.getPoOtherCmVOs();
//				
//				for(int i=0;i<cmPoVOs.length;i++){
//					BkgRefDtlVO[] cmPoVO = new BkgRefDtlVO[1];
//					cmPoVO[0] = cmPoVOs[i];
//					poOtherNoVO.setI_poOtherCmVOs(cmPoVO); // cm
//					poOtherNoVO.getIo_poOtherNoBkgVO().setCntrNo(cmPoVO[0].getCntrNo());
//					receiptBC.manageRefDetail(poOtherNoVO, bkgBlNoVO.getCaFlg());
//				}
//			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}
	/**
	 * M&D TAB(ESM_BKG_0229_04) contents checking and Save handling<br>
	 * (Transaction begin, commit, rollback )<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMndTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageMnd(e);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_07 : Reefer Save
	 * (There's no Transaction begin, commit, rollback )
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRf(Event e) throws EventException {

		EsmBkg022907Event event = (EsmBkg022907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoReceiptBC specialCargoReceiptBC = new SpecialCargoReceiptBCImpl();
		BLDocumentationCMBC bldocumentationCMBC = new BLDocumentationCMBCImpl();
		BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
		try {
			RfCgoApplVO rfCgoApplVO = new RfCgoApplVO();				        
			rfCgoApplVO.setBkgRfCgoVOs(event.getBkgRfCgoVOs());
			rfCgoApplVO.setAccount(account);
			rfCgoApplVO.setBkgNo(bkgBlNoVO.getBkgNo());
			rfCgoApplVO.setUiId("ESM_BKG_0229");
			specialCargoReceiptBC.manageRfCargo(rfCgoApplVO, bkgBlNoVO.getCaFlg());
			bldocumentationCMBC.modifyCntrFlgByRfCgo(rfCgoApplVO, bkgBlNoVO.getCaFlg());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}	


	/**
	 * ESM_BKG_0229_07 : Reefer Save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRfTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageRf(e);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_06  Tro  Save(eBooking )<br>

	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTro(Event e) throws EventException {

		EsmBkg022906Event event = (EsmBkg022906Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		try{
			String isEurFlg   = JSPUtil.getNullNoTrim(event.getIsEurFlg());  //eBooking의 경우, Eur 여부
			
			EurTroVO      eurTroVO       = new EurTroVO();
//			EurTroMstVO[] arrEurTroMstVO = null;  
//			EurTroDtlVO[] arrEurTroDtlVO = null;  
			TroMstVO[]    arrTroMstVO    = event.getTroVO().getArrTroMstVO();
			TroDtlVO[]    arrTroDtlVO    = null;
			String bkgNo      = event.getBkgBlNoVO().getBkgNo();
			String boundCd    = event.getBoundCd();
			String rtnTroFlg  = event.getRtnTroFlg();

			if ("Y".equals(isEurFlg)) {
				EurTroMstVO[] arrEurTroMstVO = event.getTroVO().getArrEurTroMstVO();
				EurTroDtlVO[] arrEurTroDtlVO = event.getTroVO().getArrEurTroDtlVO();
				if(arrEurTroMstVO != null){
					for (int i = 0; i < arrEurTroMstVO.length; i++) {
						arrEurTroMstVO[i].setBkgNo       (bkgNo);
						arrEurTroMstVO[i].setIoBndCd     (boundCd);
						arrEurTroMstVO[i].setSpclInstrRmk(arrEurTroMstVO[i].getDiffRmk());	
							
					}
				}
				if(arrEurTroDtlVO != null){
					for (int i = 0; i < arrEurTroDtlVO.length; i++) {
						arrEurTroDtlVO[i].setBkgNo       (bkgNo);
						arrEurTroDtlVO[i].setIoBndCd     (boundCd);
					}
				}
				
				eurTroVO.setBkgNo  (bkgNo);
				eurTroVO.setIoBndCd(boundCd);
				eurTroVO.setArrEurTroMstVO(arrEurTroMstVO);
				eurTroVO.setArrEurTroDtlVO(arrEurTroDtlVO);
			} else {	
				if (arrTroMstVO != null) {
					for (int i=0; i<arrTroMstVO.length; i++) {
						arrTroMstVO[i].setBkgNo    (bkgNo);
						arrTroMstVO[i].setIoBndCd  (boundCd);
						arrTroMstVO[i].setRtnTroFlg(rtnTroFlg);
					}
					event.getTroVO().setArrTroMstVO(arrTroMstVO);
				}
				arrTroDtlVO = event.getTroVO().getArrTroDtlVO();	
				if (arrTroDtlVO != null) {
					// revision about NOT NULL column
					for (int i = 0; i < arrTroDtlVO.length; i++) {
						if (arrTroDtlVO[i].getCxlFlg() == null || !"Y".equals(arrTroDtlVO[i].getCxlFlg())){
							arrTroDtlVO[i].setCxlFlg("N");
						}
						arrTroDtlVO[i].setBkgNo    (bkgNo);
						arrTroDtlVO[i].setIoBndCd  (boundCd);
						arrTroDtlVO[i].setRtnTroFlg(rtnTroFlg);
						arrTroDtlVO[i].setTroQty("1");
					}
					event.getTroVO().setArrTroDtlVO(arrTroDtlVO);
				}
			}

			//02. Tro Save
			command.manageTroByXter(event.getTroVO(), eurTroVO, event.getIsEurFlg(), account);  //containVO

			//---------------------------
			//03. Qty Save
			//BkgQuantityVO[] arrBkgQuantityVO = (BkgQuantityVO[])responseData.get(WebKeys.ER_DBROWSETS);
			//command3.modifyBkgQtyByTro(arrBkgQuantityVO, boundCd, account);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_06 Tro Save(eBooking)<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTroTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			eventResponse = (GeneralEventResponse)manageTro(e);
			commit();
		} catch (EventException ex){
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
		return eventResponse;
	}

	/**
	 * Booking modifying(ESM_BKG_0079_01)<br>
	 * 

	 * @param 	bookingCreationVO BookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException 
	 */
	private BookingCreationVO modifyBkgInfo(BookingCreationVO bookingCreationVO) throws EventException {
		try{
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BkgCopManageBC 			copBC       = null;
			BookingUtil				util		= new BookingUtil();

			BkgBlNoVO        bkgBlNoVO        = bookingCreationVO.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();

			// 01. validateBookingSave
			bookingCreationVO = receiptBC.validateBookingSave(bookingCreationVO, account);
			BookingSaveValidationVO bookingSaveValidationVO = bookingCreationVO.getBookingSaveValidationVO();

			// Auto COD
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				CODCorrectionBC codBC = new CODCorrectionBCImpl();
//				codBC.manageAutoCod(bkgBlNoVO, account, "BK");
				
				//POD,DEL 국가 변경시 COP 호출
				CodEtcVO codEtcVO = codBC.searchCopForBkgCodParam(bkgBlNoVO);
				if(codEtcVO!=null){
					copBC = new BkgCopManageBCImpl();	
					UpdBkgForBkgCodVO updBkgForBkgCodVO = new UpdBkgForBkgCodVO();
					updBkgForBkgCodVO.setBkgNo(bkgBlNoVO.getBkgNo());
					updBkgForBkgCodVO.setOldPodYdCd(codEtcVO.getOldPodNodCd());
					updBkgForBkgCodVO.setOldDelYdCd(codEtcVO.getOldDelNodCd());
					updBkgForBkgCodVO.setNewPodYdCd(codEtcVO.getNewPodNodCd());
					updBkgForBkgCodVO.setNewDelYdCd(codEtcVO.getNewDelNodCd());
					copBC.updateBkgForBkgCod(updBkgForBkgCodVO);
					
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId("ESM_BKG_0079_01");			
					historyLineVO.setHisCateNm("COD");
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg("N");
					historyLineVO.setCrntCtnt("COD Request Created");				
					historyBC.createBkgHistoryLine(historyLineVO, account);
				}
			}
			
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
				return bookingCreationVO;
			} else {
				bookingCreationVO.getBookingSaveValidationVO().setCloseBkgFlag("N");
				bookingCreationVO.getBookingSaveValidationVO().setCbfBkgFlag("N");
			}
			
			//00.Legacy newVVD Check
			String tVvd = bookingCreationVO.getBkgBookingInfoVO().getBkgTrunkVvd();
			receiptBC.checkLegacySystemVVD(tVvd);
			
			// 04. searchOldBkgInfo
			OldBkgInfoVO oldBkgInfoVO = receiptBC.searchOldBkgInfo(bkgBlNoVO);
			String oldVvd = util.searchBkgVvd(bkgBlNoVO.getBkgNo());

			bookingCreationVO.setOldBkgInfoVO(oldBkgInfoVO);
						
			// 05. modifyBooking
			bookingCreationVO.setBkgBlNoVO(bkgBlNoVO);
			bookingSaveValidationVO = receiptBC.modifyBooking(bookingCreationVO, account);
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			bookingCreationVO.getBookingSaveValidationVO().setCloseBkgFlag("N");
			bookingCreationVO.getBookingSaveValidationVO().setCbfBkgFlag("N");

			// addition: 20090706 BkgBlDoc에 ActWgt,WgtUtCd Update
			String vslUpdate = "Y"; //Flag to decide whether system update VSL_NM, PRE_VSL_NM of BKG_BL_DOC
			if(oldVvd.equals(util.searchBkgVvd(bkgBlNoVO.getBkgNo()))){ //If any VVD information is changed, update vessel name.
				vslUpdate="N";
			}
//			blDocCmBC.modifyBlActWgt(bkgBlNoVO, bkgBookingInfoVO.getActWgt(), bkgBookingInfoVO.getWgtUtCd(), account);
			blDocCmBC.modifyBlActWgt(bkgBlNoVO, bkgBookingInfoVO.getActWgt(), bkgBookingInfoVO.getWgtUtCd(), account, vslUpdate);
			blDocCmBC.modifyBkgRouteNm(bkgBlNoVO, bkgBookingInfoVO, account);
			

			String oldRcvTermCd = oldBkgInfoVO.getRcvTermCd();
			String oldDeTermCd = oldBkgInfoVO.getDeTermCd();
			String rcvTermCd = bkgBookingInfoVO.getRcvTermCd();
			String deTermCd = bkgBookingInfoVO.getDeTermCd();

			if(!oldRcvTermCd.equals(rcvTermCd) || oldDeTermCd.equals(deTermCd)){
				if(!"M".equals(rcvTermCd) || !"M".equals(deTermCd)){
					BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();
					BkgContainerVO bkgContainerVO = new BkgContainerVO();
					bkgContainerVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgContainerVO.setRcvTermCd(rcvTermCd);
					bkgContainerVO.setDeTermCd(deTermCd);
					bkgContainerVO.setUpdUsrId(account.getUsr_id());

					blCmBC.modifyCntrRDTerm(bkgContainerVO, bkgBlNoVO);

					// modifySpclRDTerm add
					if("Y".equals(bookingCreationVO.getBkgBookingInfoVO().getAwkFlg())||"Y".equals(bookingCreationVO.getBkgBookingInfoVO().getBbFlg())){
						SpecialCargoReceiptBC spclReceiptBC = new SpecialCargoReceiptBCImpl();
						spclReceiptBC.modifySpclRDTerm(bkgBlNoVO, rcvTermCd, deTermCd, account);
					}
				}
			}

			// 09. Booking Status modifying
			receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
			
			if("Y".equals(bookingSaveValidationVO.getRouteModifyFlag())){
				String porCd      = bkgBookingInfoVO.getBkgPorCd();
				String polCd      = bkgBookingInfoVO.getBkgPolCd();
				String oldPorCd   = oldBkgInfoVO.getPorCd();
				String oldPolCd   = oldBkgInfoVO.getPolCd();

				// check whether TroCfmFlag = 'Y' or not
				if(!bkgBlNoVO.getBdrFlg().equals("Y")){
					if((!oldPorCd.equals(porCd) || !oldPolCd.equals(polCd) || !oldRcvTermCd.equals(rcvTermCd)) && "Y".equals(bookingSaveValidationVO.getTroCfrmFlg())){
						TransferOrderIssueBC 	troBC = new TransferOrderIssueBCImpl();
						if(!"E".equals(bkgBookingInfoVO.getOrgScontiCd().substring(0, 1))){
							// 14. porScontiCd <> 'E' -> unconfirmTro
							troBC.unconfirmTro(bkgBlNoVO, account);
						} else {
						    // 15. porScontiCd = 'E' ->unconfirmEurTro
							troBC.unconfirmEurTro(bkgBlNoVO,  "O", account);
						}
						copBC = new BkgCopManageBCImpl();	
						copBC.unconfirmTro(bkgBlNoVO.getBkgNo(), "O");
						bookingSaveValidationVO.setSaveMsg(bookingSaveValidationVO.getSaveMsg() + ",BKG00088");
					}
				}
			}

			if((isNull(bkgBookingInfoVO.getScNoOld()) ||(!isNull(bkgBookingInfoVO.getScNoOld()) &&"DUM".equals(bkgBookingInfoVO.getScNoOld().substring(0,3))))||

			   (isNull(bkgBookingInfoVO.getRfaNoOld())||(!isNull(bkgBookingInfoVO.getRfaNoOld())&&"DUM".equals(bkgBookingInfoVO.getRfaNoOld().substring(0,3))))){

				if((bkgBookingInfoVO.getScNo().length() >0 &&!"DUM".equals(bkgBookingInfoVO.getScNo().substring(0, 3)))
				 ||(bkgBookingInfoVO.getRfaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getRfaNo().substring(0, 3)))){
					BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
					bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
					historyBC.manageDocProcess(bkgDocProcSkdVO, account);
				}
			}
			// in case of changing customer code
			if("Y".equals(bookingSaveValidationVO.getCustomerModifyFlag())){
				BlCustomerInfoVO custInfoVO = bookingCreationVO.getBlCustomerInfoVO();
				// in case of updating cnee input
				if(isNull(custInfoVO.getCCustCntCdOld())&&isNull(custInfoVO.getCCustSeqOld())
					&&!isNull(custInfoVO.getCCustCntCd())&&!isNull(custInfoVO.getCCustSeq())){
					BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
					bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee input for doc performance
					historyBC.manageDocProcess(bkgDocProcSkdVO, account);
				}
				// i/b code validation initialization
				if(!isNull(custInfoVO.getCCustCntCdOld())&&!isNull(custInfoVO.getCCustSeqOld())
					&&!isNull(custInfoVO.getCCustCntCd())&&!isNull(custInfoVO.getCCustSeq())
					&&(!custInfoVO.getCCustCntCdOld().equals(custInfoVO.getCCustCntCd())||!custInfoVO.getCCustSeqOld().equals(custInfoVO.getCCustSeq()))){

					receiptBC.cancelCustCdVal(bkgBlNoVO.getBkgNo());					
					ArrivalNoticeBC anBC = new ArrivalNoticeBCImpl();
					anBC.cancelArrNtcCustCdVal(bkgBlNoVO.getBkgNo());
				}
			}	
		
			// 18. updateBkg
//			if("Y".equals(bookingSaveValidationVO.getRouteModifyFlag())||"Y".equals(bookingSaveValidationVO.getQtyModifyFlag())){
			if(!oldBkgInfoVO.getPctlNo().equals(bkgBlNoVO.getPctlNo())){
				copBC = new BkgCopManageBCImpl();
				copBC.updateBkg(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getMapSeq());
			}
			return bookingCreationVO;
		}catch(EventException e){
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
	}

	/**
	 * In case of changing Route, Booking modifying.(ESM_BKG_0079_01)<br>
	 * 

	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithoutRoute(Event e) throws EventException {
		ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();
		BookingUtil            util  = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			// repository of Booking all Information 
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// VO of Validation result
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO	(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs			(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO			(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO	(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs		(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs		(event.getBkgQtyDtlVOs());
			
			bookingSaveValidationVO.setRouteModifyFlag("Y");
			bookingSaveValidationVO.setCustomerModifyFlag("Y");
			bookingSaveValidationVO.setContactModifyFlag("Y");
			bookingSaveValidationVO.setQtyModifyFlag("Y");			
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			/************* findFullRoute *******************/
			PrdParameterVO prdParameterVO = util.findFullRoute(bookingCreationVO);		
			util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

			// 03. createProdCtlRout
			String pctlNo = null;
			String mapSeq = null;
			try{
				String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);

				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				pctlNo = pctlNoMapSeq[0];
				mapSeq = pctlNoMapSeq[1];
			} catch (Exception pc_ex){
				eventResponse.setETCData("IsPctlNoPop", "YM");				
				log.debug("Pctl Pop Up Call");
				log.error("Pctl Pop Up Call");
				rollback();
				return eventResponse;
			}

			log.debug("Event Pctl No : " + pctlNo);
			// According to getting PctlNo, going to next step
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
				bookingCreationVO.getBkgBookingInfoVO().setPctlNo(pctlNo);
				bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNo);	
				bookingCreationVO.getBkgBlNoVO().setMapSeq(mapSeq);				
				log.debug("Event Pctl No Set Success");
			}else{
				eventResponse.setETCData("IsPctlNoPop", "YM");				
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;
			}			

			/********   modifyBkgWithRoute  ************/
			bookingCreationVO = modifyBkgInfo(bookingCreationVO);

			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
					rollback();
					eventResponse.setETCData("cbfBkgFlag", "Y");
					eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
					eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else {
				eventResponse.setETCData("ResultMsg", bookingCreationVO.getBookingSaveValidationVO().getSaveMsg());		
	
				String resultMsg = bookingCreationVO.getBookingSaveValidationVO().getSaveMsg();
				if(resultMsg != null && resultMsg.length() > 0 ){
					if(resultMsg.startsWith(",")){
						resultMsg = resultMsg.substring(1, resultMsg.length());
					}
					StringTokenizer st = new StringTokenizer(resultMsg, ",");
					while(st.hasMoreTokens()){
						eventResponse.setUserMessage(new ErrorHandler(st.nextToken()).getUserMessage());
					}
				}			
				eventResponse.setETCData("closeBkgFlag", "N");		
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");	
				eventResponse.setETCData("change_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeVvd());
				eventResponse.setETCData("psaValMsg", "Y");
			}		
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * In case of changing Route, Booking modifying .(ESM_BKG_0079_01)<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithoutRouteByXter(Event e) throws EventException {
		return modifyBkgWithoutRoute(e);
	}

	/**
	 * In case of changing Route, Booking modifying.(ESM_BKG_0079_01)<br>
	 * including Transaction

	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithoutRouteByXterTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse =  (GeneralEventResponse)modifyBkgWithoutRouteByXter(e);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * There's no changing in Route, Booking Save.(ESM_BKG_0079_01)<br>

	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			BookingUtil util = new BookingUtil();
			
			// repository of Booking all Information 
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// VO of Validation result
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			
//			bookingSaveValidationVO.setRouteModifyFlag("Y");
			bookingSaveValidationVO.setCustomerModifyFlag("Y");
			bookingSaveValidationVO.setContactModifyFlag("Y");
//			bookingSaveValidationVO.setQtyModifyFlag("Y");			
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			//pctlNo set
			String [] pctlNoMapSeq = util.splitByToken(event.getPctlNo(), "|");
			bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNoMapSeq[0]);	
			bookingCreationVO.getBkgBlNoVO().setMapSeq(pctlNoMapSeq[1]);	

			bookingCreationVO = modifyBkgInfo(bookingCreationVO);

			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
					rollback();
					eventResponse.setETCData("cbfBkgFlag", "Y");
					eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
					eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else {
				eventResponse.setETCData("ResultMsg", bookingCreationVO.getBookingSaveValidationVO().getSaveMsg());		
	
				String resultMsg = bookingCreationVO.getBookingSaveValidationVO().getSaveMsg();
				if(resultMsg != null && resultMsg.length() > 0 ){
					if(resultMsg.startsWith(",")){
						resultMsg = resultMsg.substring(1, resultMsg.length());
					}
					StringTokenizer st = new StringTokenizer(resultMsg, ",");
					while(st.hasMoreTokens()){
						eventResponse.setUserMessage(new ErrorHandler(st.nextToken()).getUserMessage());
					}
				}			
				eventResponse.setETCData("closeBkgFlag", "N");
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");	
				eventResponse.setETCData("change_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeVvd());	
				eventResponse.setETCData("psaValMsg", "Y");
			}	
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * In case of changing Route, Booking modifying.(ESM_BKG_0079_01)<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithRouteByXter(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse = (GeneralEventResponse) modifyBkgWithRoute(e);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  
		}
		return eventResponse;
	}

	/**
	 * In case of changing Route, Booking modifying.(ESM_BKG_0079_01)<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithRouteByXterTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse = (GeneralEventResponse) modifyBkgWithRoute(e);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  
		}
		return eventResponse;
	}

	/**
	 * Customer Information modifying.(ESM_BKG_0079_05)<br>
	 * 

	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse modifyBlDocCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022902Event event = (EsmBkg022902Event)e;
		try{
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			//CNHKG CASE checking is needed
//			GeneralBookingSearchBC 	searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBC 	= new BLDocumentationBLBCImpl();
			EBookingReceiptBC 		eBkgBC 		= new EBookingReceiptBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();

			XterRqstNoVO rqstNoVO = event.getXterRqstNoVO();
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			
			BlCustomerVO blCustomerVO = new BlCustomerVO();
			blCustomerVO.setBkgBlNoVO  (bkgBlNoVO);

//			blCustomerVO.setBlDocCustVO(event.getBlDocCustVOs()[0]);
			blCustomerVO.setBlDocCustVO(event.getBlDocCustVO());

//			blCustomerVO.setCustEtcVO(event.getCustEtcVOs()[0]);
			blCustomerVO.setCustEtcVO(event.getCustEtcVO());		
			boolean ibCustCdVal = false;
			String bkgNo = bkgBlNoVO.getBkgNo();

			// 31. validationBlDocCust working on
			receiptBC.validateBlDocCust(blCustomerVO);

			// 18. searchOldBkgForHistory working on
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0229", bkgBlNoVO);

			// 23. modifyBkgBlDocByCust working on
			blDocBC.modifyBkgBlDocByCust(bkgBlNoVO, event.getCustEtcVO().getOrgCntNm(), account, "", "");
			
			// 32. modifyBlDocCust working on
			receiptBC.modifyBlDocCust(blCustomerVO, "E", account);
			
			XterRqstMstVO XterRqstMstVO = event.getXterRqstMstVO();
			XterRqstMstVO.setBkgNo(bkgNo);
			eBkgBC.modifyBkgReferenceNo(event.getXterRqstMstVO(), account);
			
			//  cnee input at first in customer 
			for(int i=0;i<historyTableVO.getBkgCustomerVOs().size();i++){
				List<BkgCustomerVO> oldCustVOs = historyTableVO.getBkgCustomerVOs();
				if("C".equals(oldCustVOs.get(i).getBkgCustTpCd())){ //cnee
					if(isNull(oldCustVOs.get(i).getCustCntCd())&&isNull(oldCustVOs.get(i).getCustSeq())// It is not in old
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustSeq())){// It is in new, Thinking about inputting new consignee 
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
						bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee input for doc performance		
						historyBC.manageDocProcess(bkgDocProcSkdVO, account);
					}					
					if(!isNull(oldCustVOs.get(i).getCustCntCd())&&!isNull(oldCustVOs.get(i).getCustSeq())// It is in old
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustSeq())// It is in new
						//they are different
						&&(!oldCustVOs.get(i).getCustCntCd().equals(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							||!oldCustVOs.get(i).getCustSeq().equals(blCustomerVO.getBlDocCustVO().getCnCustSeq()))){
						ibCustCdVal = true;
					}					
				}
				if(false==ibCustCdVal&&"N".equals(oldCustVOs.get(i).getBkgCustTpCd())){ //cnee
					if(!isNull(oldCustVOs.get(i).getCustCntCd())&&!isNull(oldCustVOs.get(i).getCustSeq())// It is in old
							&&!isNull(blCustomerVO.getBlDocCustVO().getNfCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getNfCustSeq())// It is in new
						//they are different
						&&(!oldCustVOs.get(i).getCustCntCd().equals(blCustomerVO.getBlDocCustVO().getNfCustCntCd())
							||!oldCustVOs.get(i).getCustSeq().equals(blCustomerVO.getBlDocCustVO().getNfCustSeq()))){
						ibCustCdVal = true;
					}	
				}
			}
			if ("Y".equalsIgnoreCase(event.getOfcChgProcVO().getOfcChgPpdProc()) || "Y".equalsIgnoreCase(event.getOfcChgProcVO().getOfcChgCctProc())) {
				BkgModiOfcPrcVO bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
				bkgModiOfcPrcVO.setInBkgNo(bkgNo);
				bkgModiOfcPrcVO.setInCaFlg(bkgBlNoVO.getCaFlg());
				bkgModiOfcPrcVO.setInPpdFlg(event.getOfcChgProcVO().getOfcChgPpdProc());
				bkgModiOfcPrcVO.setInCctFlg(event.getOfcChgProcVO().getOfcChgCctProc());
				(new BlRatingBCImpl()).callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
			}
			// In case of going on c/a , Don't update  i/b arrival notic
			if(ibCustCdVal){
				receiptBC.cancelCustCdVal(bkgNo);					
				ArrivalNoticeBC anBC = new ArrivalNoticeBCImpl();
				anBC.cancelArrNtcCustCdVal(bkgNo);
			}
			
			// update Customer Code to  eBKG
			eBkgBC.modifyXterCustCustCd(rqstNoVO, account);
			
			if (!"".equals(event.getBlDocCustVO().getNmAndAddrOvflwFlg())) {
				// update Customer Code to  eBKG
				eBkgBC.modifyNmAndAddrOvflwFlg(rqstNoVO, event.getBlDocCustVO().getNmAndAddrOvflwFlg(), account);
				
			}
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * Customer Information modifying.(ESM_BKG_0079_05)<br>
	 * including Transaction 
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse modifyBlDocCustTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			begin();
			eventResponse = (GeneralEventResponse)modifyBlDocCust(e);
			commit();
		} catch (EventException ex){
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0228, ESM_BKG_0229 : PENDING click
	 * changing EBookingReceipt position to PENDING<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse pendingXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0228Event")) {
				EsmBkg0228Event event = (EsmBkg0228Event)e;
				command.changeXterRqstStatus(event.getXterRqstNoVOs(), "P", "" ,account);
			} else {
				EsmBkg022901Event event = (EsmBkg022901Event)e;
				command.changeXterRqstStatus(event.getXterRqstNoVOs(), "P", "" ,account);
				eventResponse.setETCData("SuccessYn", "Y");
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}


	private EventResponse cancelBkgByXter(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0229Event event = (EsmBkg0229Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationCMBC blDocCmBC = new BLDocumentationCMBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		BkgCopManageBC copBC = new BkgCopManageBCImpl();
		EBookingReceiptBC eBkgBC = new EBookingReceiptBCImpl();
		BookingUtil util = new BookingUtil();

		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
		GeneralBookingSearchBC  searchBC	= new GeneralBookingSearchBCImpl();
		OwnContainerBookingForecastMgtBC owncontainer = new OwnContainerBookingForecastMgtBCImpl();
		SpecialCargoReceiptBC 	spclCgoReceiptBC= new SpecialCargoReceiptBCImpl();
		ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC = new ReceiveOwnBkgCancelRequestMgtBCImpl();
		
		String mrdNm = "";
		String sType = null;
		String sLevel = null;
		String sMrd = null;
		StringBuilder sbParam = null;
		sbParam = new StringBuilder();
		
		DblWblVO[] dblWblVOs = null;
		
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		List<BkgNtcHisVO> bkgNtcHisSysVOs = new ArrayList<BkgNtcHisVO>();
		
		try{
			begin();

			String bkgStsCd = null; 
			bkgStsCd = util.searchBkgStatusByBkg(event.getBkgBlNoVO());  

            if(isNull(bkgStsCd)){
				throw new EventException((String)new ErrorHandler("BKG00183",new String[]{event.getBkgBlNoVO().getBkgNo()}).getMessage());
            }
            
			// 20100205 Booking Close 로직 추가
			String closeBkgMsg = "";
			String closeVvd = "";
			boolean isCloseMail = false;
			boolean isCbfMail = false;
			if("N".equals(event.getBkgBlNoVO().getCaFlg())){
				if(!"Y".equals(event.getCloseBkgFlag())){
					BkgCloseVO bkgCloseVO = util.searchBkgClose(event.getBkgBlNoVO(), account.getOfc_cd());
					if(bkgCloseVO != null){
						String[] strParam = new String[11];
						strParam[0] = event.getBkgBlNoVO().getBkgNo();
						strParam[5] = bkgCloseVO.getCntrList();
						strParam[6] = bkgCloseVO.getPreVvd();
						strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
						strParam[10] = bkgCloseVO.getCntrList();					
						
						closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
						closeVvd = bkgCloseVO.getCloseVvd();
						isCloseMail = true;
					}
				}
				if(!"Y".equals(event.getCbfBkgFlag())){
	
					boolean isCbfFinal = false;
					BkgCloseVO bkgCloseVO = util.searchBkgCbf(event.getBkgBlNoVO());
					if(bkgCloseVO != null && bkgCloseVO.getNewVvd() != null && !bkgCloseVO.getNewVvd().trim().equals("")){
						String[] arrCBF  = owncontainer.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
						for (int i=0;i<arrCBF.length;i++){
							if(i%4 == 0){
								if("Final".equals(arrCBF[i])){
									isCbfFinal = true;
									break;
								}
							}
						}
						if(arrCBF != null && isCbfFinal == true ){
							String[] strParam = new String[11];
							strParam[0] = event.getBkgBlNoVO().getBkgNo();
							strParam[5] = bkgCloseVO.getCntrList();
							strParam[6] = bkgCloseVO.getPreVvd();
							strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
							strParam[10] = bkgCloseVO.getCntrList();					
							
							closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
							closeVvd = bkgCloseVO.getCloseVvd();
							isCbfMail = true;
						}
					}
				}
			}
			if(isCloseMail){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", closeVvd);
				eventResponse.setETCData("closeBkgMsg", closeBkgMsg);		
			} else if(isCbfMail){
				rollback();
				eventResponse.setETCData("cbfBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", closeVvd);
				eventResponse.setETCData("closeBkgMsg", closeBkgMsg);			
			}else{

				//keep VVD information for DG cancel about source BKG
				List<SearchDgCancelInfoVO> dgCancelInfoBefore = null;
				dgCancelInfoBefore = spclCgoReceiptBC.searchDgCancelInfo(event.getBkgBlNoVO().getBkgNo());

				// 01. Cancel Booking
				receiptBC.cancelBooking(event.getBkgBlNoVO(), account); 

				//call cancel DG
				if(dgCancelInfoBefore.size()>0){
					List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
					spclCgoReceiptBC.manageDgBkgCancel(event.getBkgBlNoVO().getBkgNo(), account, scgVvdDgCgoCxlRqstVOs, "Booking Cancel");
					bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
				}
				
				// 02. Cancel Container
				blDocCmBC.cancelBkgCntr(event.getBkgBlNoVO(), account);
	
				// 03. BookingHistoryMgtBC의 createBkgHistoryLine 호출
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				historyLineVO.setCaFlg(event.getBkgBlNoVO().getCaFlg());
				historyLineVO.setBkgDocProcTpCd("BKGCAN");//booking cancel for doc performance
				historyLineVO.setUiId("ESM_BKG_0229");
				historyLineVO.setCrntCtnt("Booking Canceled.");
				historyLineVO.setHisCateNm("Booking Cancel."); 
				
				if(event.getBkgBlNoVO().getMessage() != null){
					historyBC.createBkgHistoryLine(historyLineVO, "Cancel Reason", event.getBkgBlNoVO().getMessage(), account);
				}else{
					historyBC.createBkgHistoryLine(historyLineVO, account);
				}
				
				copBC.cancelBkg(event.getBkgBlNoVO().getBkgNo());
				
				//  In case of Auto Notification Check in eBooking Booking Tab, send email	
				
				String bkgCntcPsonEml = event.getEsmBkg022901Event().getBkgCntcPsonEml();
				
				if(event.getEsmBkg022901Event() != null && "Y".equals(event.getEsmBkg022901Event().getAutoNotification()) && bkgCntcPsonEml != null  && !StringUtils.containsNone(bkgCntcPsonEml.trim(), "@")) {
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					String [] eml = new String[bkgCntcPsonEml.length()];
					eml[0] = bkgCntcPsonEml;
					String [] rmk = new String[1];
					rmk[0] = "";
					if ("B".equals(event.getEsmBkg022901Event().getDocTpCd())){
						StringBuilder titleSb = new StringBuilder("Internet Booking Cancellation Request Accepted - ");
						titleSb.append(" ( ").append(event.getXterRqstNoVO().getRqstNo()).append(" )");

						StringBuilder contentSb = new StringBuilder("<br>");
						contentSb.append("Thank you for shipping with NYK Line!").append("<br><br>");

						contentSb.append("Your booking cancellation request for the following shipment has been").append("<br>");
						contentSb.append("confirmed and are available for review on the NYK Line Web site at http://www.nykline.com. ").append("<br>");
						contentSb.append("Please follow this link to review the details of your booking.").append("<br><br>");
						contentSb.append("If you have any further questions regarding this booking, please contact your").append("<br>");
						contentSb.append("NYK Customer Service Representative.").append("<br><br>");
						contentSb.append("Request Number : ").append(event.getXterRqstNoVO().getRqstNo()).append("<br>");
						contentSb.append("NYK Booking Number : ").append(event.getXterRqstNoVO().getBkgNo()).append("<br>").append("<br>");
						contentSb.append("To access NYK Group on-line, please go to http://www.nykline.com").append("<br>");
						contentSb.append("Please contact your local NYK office if you need any assistance ").append("<br>").append("<br>");
						contentSb.append("Thank you for shipping with NYK Line. ").append("<br>").append("<br>");
						contentSb.append("*** NOTE - Please do not respond to this email.*** ").append("<br>");

						BkgBlNoVO[] bkgBlNoVOs = new BkgBlNoVO[] {new BkgBlNoVO() };
						
						String [] cct = new String[bkgCntcPsonEml.length()];
						for(int j=0; j < cct.length; j++){
							cct[j] = "";
						}
						String vslNm = bLIssuanceBC.searchVesselNameByBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgBlNoVOs[0].setBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgNtcHisVOs = searchBC.sendXterReceiptByEmail(bkgBlNoVOs, eml, rmk, mrdNm, cct, account, titleSb.toString(), contentSb.toString(), vslNm);
						
					} else if ("S".equals(event.getEsmBkg022901Event().getDocTpCd())){
						sbParam = new StringBuilder();
						StringBuilder titleSb = new StringBuilder("Web B/L Instruction Notification ");
						titleSb.append(" ( ").append(event.getBkgBlNoVO().getBkgNo()).append(" :  Canceled )");
						StringBuilder contentSb = new StringBuilder("Dear Customer");
						contentSb.append("<br><br>Thank you for using our website");
						contentSb.append("<br>Your B/L instruction request for '").append(event.getBkgBlNoVO().getBkgNo()).append("'  request is successfully processed in our booking & documentation system.");
						contentSb.append("<br>For your cargo information, refer to the attached file");
						contentSb.append("<br><br><br>If you have any question, please contact our booking & documentation");
						contentSb.append("<br>").append(account.getUsr_id());
						contentSb.append("<br><br><br>We would like to listen to how you think of our service, If you have any suggestions or comments");
						contentSb.append("<br>please visit our website and leave your comments into the section of Voice of Customer").append("<br>").append("<br>");
						contentSb.append("To access NYK Group on-line, please go to http://www.nykline.com").append("<br>");
						contentSb.append("Please contact your local NYK office if you need any assistance ").append("<br>").append("<br>");
						contentSb.append("Thank you for shipping with NYK Line. ").append("<br>").append("<br>");
						contentSb.append("*** NOTE - Please do not respond to this email.*** ").append("<br>");
						//sType="2";
						sType="7";
						//sMrd="ESM_BKG_0109_DBL.mrd";
						sMrd="ESM_BKG_0109_OBL_A4.mrd";
						sLevel="1"; 
						
						sbParam.append("/rv");
						sbParam.append(" form_bkgNo[('").append(event.getBkgBlNoVO().getBkgNo()).append("')]");
						sbParam.append(" form_type[").append(sType).append("]");
						sbParam.append(" form_dataOnly[N]");
						sbParam.append(" form_manifest[N]");
						sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
						sbParam.append(" form_hiddeData[N]");
						sbParam.append(" form_level[(").append(sLevel).append(")]");
						sbParam.append(" form_remark[").append(rmk[0]).append(")]");
						sbParam.append(" form_Cntr[1]");
						sbParam.append(" form_mainOnly[N]");
						sbParam.append(" form_CorrNo[]");
						sbParam.append(" form_his_cntr[BKG_CONTAINER]");
						sbParam.append(" form_his_bkg[BKG_BOOKING]");
						sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
						sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
						sbParam.append(" form_his_bl[BKG_BL_DOC]");
						sbParam.append(" form_rqst_via_cd[]");
						sbParam.append(" form_his_bl_mkd[BKG_BL_ISS]"); 						
						sbParam.append(" /rp []");
						sbParam.append(" /riprnmargin");
						dblWblVOs = new DblWblVO[1];
						dblWblVOs[0] = new DblWblVO();
						dblWblVOs[0].setBkgNo(event.getBkgBlNoVO().getBkgNo());
						dblWblVOs[0].setBlNo(event.getBkgBlNoVO().getBlNo());
						dblWblVOs[0].setSyscd("BKG");
						dblWblVOs[0].setTmplmrd(sMrd);
						dblWblVOs[0].setBatchflg("N");
						dblWblVOs[0].setTmplparam(sbParam.toString());
						dblWblVOs[0].setRcveml(eml[0]);
						dblWblVOs[0].setTmplmrdpdf("Original.pdf");
						dblWblVOs[0].setItr("|$$|");
//						dblWblVOs[0].setNtcKndCd("");
//						dblWblVOs[0].setHiddOpt("N");
						dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setTitle(titleSb.toString()); /* 제목 */
						dblWblVOs[0].setContents(contentSb.toString()); /* contents */
						bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, null, account);
					}
					if (bkgNtcHisVOs != null) {
						bkgNtcHisVO = bkgNtcHisVOs.get(0);
	                    bkgNtcHisVO.setSndUsrId("SYSTEM");
	                    bkgNtcHisSysVOs.add(bkgNtcHisVO);
					}
					historyBC.createBkgNtcHis(bkgNtcHisSysVOs, "ESM_BKG_0229");
				}
				
				// 04. interfaceCoa
				interfaceToCoa(event.getBkgBlNoVO(), "Booking Cancel", account);
	
				// 05. interfaceBkgARInvoiceToINV
				interfaceToInv(event.getBkgBlNoVO(), account);	
				
				// 06. Complete Upload
				eBkgBC.completeUpload(event.getXterRqstNoVO(), account);

				commit();
				
				// 07. sendBkgCustEdi
				searchBC.createCustBkgReceiptEdiBackEnd(event.getBkgBlNoVO(), null, "Y", account);
				
				// 08. sendBkgTmlEdi
				// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
				vender301ParamVO.setBkgBlNoVO(event.getBkgBlNoVO());
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd("R");
				vender301ParamVO.setEdiKind("BT");
				vender301ParamVO.setAutoManualFlg("Y");
				
				searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);					
				
				eventResponse.setETCData("SuccessYn", "Y");
			}
		}catch(EventException ex){
			rollback();			
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * MQ connection handling<br>
	 * eBKG, eSI sending message handling throughout UBIZCOM_OPUSBKG_IB IBM MQ<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkgEBkgReceiptEvent event = (EsmBkgEBkgReceiptEvent)e;
		String flatFileStr = event.getRcvMsg();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		XterRqstNoVO rqstNoVo = new XterRqstNoVO();
		String upldFlg = "Y";
		String senderId = "";
		try{
			begin();
			String[] headers = command.getReceiptXterRqstEdiMsgType(flatFileStr.split("\n")[0]);
			if(headers != null && headers[2].equalsIgnoreCase("VERMAS")){
				senderId = "VERMAS";
				rqstNoVo = command.receiptXterRqstVermas(headers, flatFileStr);
				if(rqstNoVo.getAckRcv() != null && rqstNoVo.getAckRcv().equals("Y")){
					command.createVermasBkgAckEdi(headers, rqstNoVo);
				}
			}else{
				senderId = "EDI";
				rqstNoVo = command.receiptXterRqst(flatFileStr);
				if ("S".equals(rqstNoVo.getDocTpCd())){
					log.info("\n[[[ uploadXterRqst - createXterBkgAckEdi ]]]");
					command.createXterBkgAckEdi(rqstNoVo.getDocTpCd(), "XTER_ACK_RECEIVER", rqstNoVo);
				}
				
				if(!"E".equals(rqstNoVo.getDocTpCd()) || "".equals(rqstNoVo.getDocTpCd())){
					if(!rqstNoVo.getSenderId().equalsIgnoreCase("PEGASUS")){
						command.sendXterRqstNotice(rqstNoVo);
					}
				}
				
				if(rqstNoVo!=null){
					command.assignBkgNoToXterRqst(rqstNoVo);
					PerformanceReportBC command2 = new PerformanceReportBCImpl();
					DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
					dpcsWebBookingVO.setXterSndrId(rqstNoVo.getSenderId());
					dpcsWebBookingVO.setXterRqstNo(rqstNoVo.getRqstNo());
					dpcsWebBookingVO.setXterRqstSeq(rqstNoVo.getRqstSeq());
					if ( !"E".equals(rqstNoVo.getDocTpCd()) && !"H".equals(rqstNoVo.getXterBlTpCd())) {
						command2.addBkgSrRequest(dpcsWebBookingVO);	
					}
				}
			}
			commit();
			
			if(senderId != null && senderId.equals("EDI")){
				/* DOC Type = S 일때 BKG_Booking.SI_FLG = Y 업데이트 */
				if(rqstNoVo != null && rqstNoVo.getDocTpCd().equals("S") && rqstNoVo.getBkgNo() != null && !rqstNoVo.getBkgNo().equals("")){
					try{
						begin();
						BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
						BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
						bkgBlNoVO.setBkgNo(rqstNoVo.getBkgNo());
						HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0229", bkgBlNoVO);
						command.manageXterVgm(rqstNoVo);
						historyBC.manageBookingHistory("ESM_BKG_0229", historyTableVO, new SignOnUserAccount("EDI AUTO", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
						commit();
					}catch(Exception e1){
						sendErrLogMail(flatFileStr, e1);
					}
				}
			}
			
		}catch(EventException ex){
			rollback();
			upldFlg = "N";
			sendErrLogMail(flatFileStr, ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			upldFlg = "N";
			sendErrLogMail(flatFileStr, ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}finally{
			if(upldFlg == "N"){
				try{
					begin();
					rqstNoVo.setUpldFlg(upldFlg);
					rqstNoVo.setSenderId(senderId);
					rqstNoVo = genXterRqstNoVO(rqstNoVo, flatFileStr);
					command.createBkgXterRcvMsg(rqstNoVo, flatFileStr);
					commit();
				}catch(Exception e1){
					log.error("err " + e1.toString(), e1);
				}
			}
		}
		return eventResponse;
	}

	/**
	 * MQ connection handling(xls)<br>
	 * eBKG, eSI sending message handling throughout UBIZCOM_OPUSBKG_IB IBM MQ<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptXterRqstByXls(Event e) throws EventException {
		final String colon = ":";
		final String[] arrValue = {
			"X",					//0. add to I_BOOKING (IB_IE_IND:X)
			"EXCEL",				//1. add to I_BOOKING (IB_EDI_ID:EXCEL)
			"P",					//2. add to I_BOOKING (IB_FRT_TERM:P)
			"C",					//3. add to I_BOOKING (IB_FRT_TERM:C) 
			"W",					//4. add to I_BOOKING (IB_TP:W)
			"H",					//5. add to I_BOOKING(IB_TP:H), 2.add reference no to H
			"S"						//6. doc_tp_cd
		};
		final String[] arrName = {
			"I_BKG_CNTR",			//0. roof
			"CNTR_NO",				//1. roof
			"IB_BKG_NO",			//2. add value not being inputted
			"IB_IE_IND",			//3. add value not being inputted
			"IB_EDI_ID",			//4. add value not being inputted
			"IB_NO",				//5. recording value at refNo 
			"IB_FRT_TERM",			//6. 
			"IB_TP",				//7. 
			"IB_PRE_VSL_NM",		//8.
			"IB_SKD_VOYAGE_NO",		//9. add value not being inputted
			"IB_SKD_DIR_CD",		//10. add value not being inputted
			"HBL.I_CM_MARK_DESC",	//11. HBL : roof
			"IB_ORG_NM",			//12. HBL : add value not being inputted(IB_NO,IB_BKG_NO,IB_IE_IND,IB_EDI_ID,IB_TP)
			"IB_SKD_VOYAGE_NO",		//13. add value not being inputted
			"IB_SKD_DIR_CD",		//14. add value not being inputted
			"IB_MSG_FLAG",			//15. doc_tp_cd
			"IBCS_STATE"			//16. mdm_state
		};
		final String[] arrTemp = {
			"I_BOOKING.",
			"PREPAID",
			"SEAWAYBILL"
		};
		GeneralEventResponse eventResponse = null;
		EBookingReceiptBC command = null;
		BookingUtil util = null;
		BkgHrdCdgCtntVO paramVO = null;
		List<BkgHrdCdgCtntVO> grpList = null;
		List<BkgHrdCdgCtntVO> mapList = null;
		Workbook wb = null;
		Sheet sheet1 = null;
		Sheet sheet2 = null;
		Cell cell = null;
		List<Cell> cells = null;
		DateFormat dateFormat = null;
		StringBuilder flatFile = new StringBuilder();
		String bkgNo = "";
		String refNo = "";
		String lineSep = "";
		String val = "";
		int idx=0,x=0,y=0,icmdSeq=0;
		boolean isEndCntr = false;
		try {
			eventResponse = new GeneralEventResponse();
			command = new EBookingReceiptBCImpl();
			paramVO = new BkgHrdCdgCtntVO();
			wb = WorkbookFactory.create(((EsmBkgEBkgReceiptEvent)e).getRcvXls());
			sheet1 = wb.getSheetAt(0);  //EDI_MAIN
			sheet2 = wb.getSheetAt(1);  //HBL
			String lineSepTmp = System.getProperty("line.separator");				
			
			if (lineSepTmp != null) {
				lineSep = lineSepTmp;
			}
			dateFormat = new SimpleDateFormat("yyyyMMdd");
			begin();
			if (null!=wb) {
				if (null!=sheet1) {
					idx = 0;
					flatFile = new StringBuilder();
					util = new BookingUtil();
					paramVO.setAttrCtnt10(sheet1.getSheetName());
					grpList = command.searchMqXlsGroupList(paramVO);  //XTER_BKG_RECEIPT_ORD
					mapList = command.searchMqXlsMappingList(paramVO);  //XTER_BKG_RECEIPT_XLS
					for (BkgHrdCdgCtntVO vo : mapList) {
						//open group///////////////////////////////////////
						if (0>flatFile.indexOf(vo.getAttrCtnt4()) && !arrName[0].equalsIgnoreCase(vo.getAttrCtnt1())) {
							LOOP_FLAT_FILE_GROUP_OPEN:
							for (BkgHrdCdgCtntVO group : grpList) {
								if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
									flatFile.append(group.getAttrCtnt4()).append(lineSep);
									break LOOP_FLAT_FILE_GROUP_OPEN;
								}
							}
						}
						cells = findCellsByName(wb,vo.getAttrCtnt2());
						if (null!=cells) {
							idx+=1;
							if (1<cells.size()) {
								for (Cell temp : cells) {
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(temp.getStringCellValue()).append(lineSep);
								}
							} else {
								cell = cells.get(0);
								x = cell.getRowIndex();
								y = cell.getColumnIndex();
								if (Cell.CELL_TYPE_NUMERIC==cell.getCellType()) {
									if (null!=cell.getDateCellValue()) {
										val = dateFormat.format(cell.getDateCellValue());
									}
								} else {
									val = cell.getStringCellValue();
								}
								//contents///////////////////////////////////////
								//1.container
								if (!isEndCntr && arrName[1].equalsIgnoreCase(vo.getAttrCtnt3())) {
									LOOP_CNTR:
									while (null!=sheet1 && null!=sheet1.getRow(x) && null!=sheet1.getRow(x).getCell(y)) {
										if (!"".equalsIgnoreCase(sheet1.getRow(x).getCell(y).getStringCellValue())) {
											flatFile.append(this.getCntrEdiFlatFile(sheet1, x, y, true));
										} else {
											isEndCntr = true;
											break LOOP_CNTR;
										}
										if (!"".equalsIgnoreCase(sheet1.getRow(x).getCell(6+y).getStringCellValue())) {
											flatFile.append(this.getCntrEdiFlatFile(sheet1, x, 6+y, false));
										} else {
											isEndCntr = true;
											break LOOP_CNTR;
										}
										x+=7;
									}
								//2.container외
								} else if (arrName[2].equalsIgnoreCase(vo.getAttrCtnt3())) {
									bkgNo = val;
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(val).append(lineSep);
									flatFile.append(arrName[3]).append(colon).append(arrValue[0]).append(lineSep);
									flatFile.append(arrName[4]).append(colon).append(arrValue[1]).append(lineSep);
									flatFile.append(arrName[15]).append(colon).append(arrValue[6]).append(lineSep);
								} else if (arrName[5].equalsIgnoreCase(vo.getAttrCtnt3())) {
									refNo = !"".equals(val) ? val : findCellsByName(wb,arrTemp[0]+arrName[2]).get(0).getStringCellValue();  //ref no 없는경우에 bkg no 로 대체함
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(refNo).append(lineSep);
								} else if (arrName[6].equalsIgnoreCase(vo.getAttrCtnt3())) {
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(arrTemp[1].equals(val.toUpperCase()) ? arrValue[2]:arrValue[3]).append(lineSep);
								} else if (arrName[7].equalsIgnoreCase(vo.getAttrCtnt3())) {
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(arrTemp[2].equals(val.toUpperCase()) ? arrValue[4]:"").append(lineSep);
								} else if (arrName[8].equalsIgnoreCase(vo.getAttrCtnt3())) {
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(val+sheet1.getRow(x).getCell(3+y).getStringCellValue()).append(lineSep);
								} else if (arrName[13].equalsIgnoreCase(vo.getAttrCtnt3())) {
									if (!"".equals(val) && 4<=val.length()) {
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.substring(0,4)).append(lineSep);
										if (5<=val.length()) {
											flatFile.append(arrName[14]).append(colon).append(val.substring(4,5)).append(lineSep);
										}
									}
								} else if (arrName[16].equalsIgnoreCase(vo.getAttrCtnt3())) {
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(util.searchSteCodeByName(val).getSteCd()).append(lineSep);
								} else {
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(val).append(lineSep);
								}
							}
						}
						//close group///////////////////////////////////////
						if (!arrName[0].equalsIgnoreCase(vo.getAttrCtnt1())) {
							if (idx < mapList.size()) {
								if (!vo.getAttrCtnt1().equalsIgnoreCase(mapList.get(idx).getAttrCtnt1())) {
									LOOP_FLAT_FILE_GROUP_CLOSE:
									for (BkgHrdCdgCtntVO group : grpList) {
										if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
											flatFile.append(group.getAttrCtnt5()).append(lineSep);
											break LOOP_FLAT_FILE_GROUP_CLOSE;
										}
									}
								}
							} else {
								flatFile.append(vo.getAttrCtnt5()).append(lineSep);
							}
						}
					}
log.info("\n\n\n\n\n\n\n\n\n\n\n\n"
		+"\n==EDI_MAIN==========\n"
		+flatFile
		+"\n====================\n"
		+"\n\n\n\n\n\n\n\n\n\n\n\n");
					command.receiptXterRqst(flatFile.toString());
				}
				if (null!=sheet2) {
					isEndCntr = false;
					idx = 0;
					flatFile = new StringBuilder();
					paramVO.setAttrCtnt10(sheet2.getSheetName());
					grpList = command.searchMqXlsGroupList(paramVO);  //XTER_BKG_RECEIPT_ORD
					mapList = command.searchMqXlsMappingList(paramVO);  //XTER_BKG_RECEIPT_XLS
					for (BkgHrdCdgCtntVO vo : mapList) {
						//open group///////////////////////////////////////
						if (0>flatFile.indexOf(vo.getAttrCtnt4()) && !arrName[11].equalsIgnoreCase(vo.getAttrCtnt1())) {
							LOOP_FLAT_FILE_GROUP_OPEN:
							for (BkgHrdCdgCtntVO group : grpList) {
								if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
									flatFile.append(group.getAttrCtnt4()).append(lineSep);
									break LOOP_FLAT_FILE_GROUP_OPEN;
								}
							}
						}
						cells = findCellsByName(wb,vo.getAttrCtnt2());
						if (null!=cells) {
							idx+=1;
							if (1<cells.size()) {
								for (Cell temp : cells) {
									flatFile.append(vo.getAttrCtnt3()).append(colon).append(temp.getStringCellValue()).append(lineSep);
								}
							} else {
								cell = cells.get(0);
								x = cell.getRowIndex();
								y = cell.getColumnIndex();
								if (Cell.CELL_TYPE_NUMERIC==cell.getCellType()) {
									if (null!=cell.getDateCellValue()) {
										val = dateFormat.format(cell.getDateCellValue());
									}
								} else {
									val = cell.getStringCellValue();
								}
								//contents///////////////////////////////////////
								//1.container
								if (!isEndCntr && arrName[1].equalsIgnoreCase(vo.getAttrCtnt3())) {
									LOOP_CNTR:
									while (null!=sheet2 && null!=sheet2.getRow(x) && null!=sheet2.getRow(x).getCell(y)) {
										if (!"".equalsIgnoreCase(sheet2.getRow(x).getCell(y).getStringCellValue())) {
											flatFile.append(this.getCntrEdiFlatFile(sheet2, x, y, true, ++icmdSeq));
										} else {
											isEndCntr = true;
											break LOOP_CNTR;
										}
										if (!"".equalsIgnoreCase(sheet2.getRow(x).getCell(4+y).getStringCellValue())) {
											flatFile.append(this.getCntrEdiFlatFile(sheet2, x, 4+y, false, ++icmdSeq));
										} else {
											isEndCntr = true;
											break LOOP_CNTR;
										}
										x+=7;
									}
								//2.container
								} else {
									if (arrName[12].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(arrName[5]).append(colon).append(refNo).append(arrValue[5]).append(lineSep);
										flatFile.append(arrName[2]).append(colon).append(bkgNo).append(lineSep);
										flatFile.append(arrName[3]).append(colon).append(arrValue[0]).append(lineSep);
										flatFile.append(arrName[4]).append(colon).append(arrValue[1]).append(lineSep);
										flatFile.append(arrName[7]).append(colon).append(arrValue[5]).append(lineSep);
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(val).append(lineSep);
									} else {
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(val).append(lineSep);
									}
								}
							}
						}
						//close group///////////////////////////////////////
						if (!arrName[11].equalsIgnoreCase(vo.getAttrCtnt1())) {
							if (idx < mapList.size()) {
								if (!vo.getAttrCtnt1().equalsIgnoreCase(mapList.get(idx).getAttrCtnt1())) {
									LOOP_FLAT_FILE_GROUP_CLOSE:
									for (BkgHrdCdgCtntVO group : grpList) {
										if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
											flatFile.append(group.getAttrCtnt5()).append(lineSep);
											break LOOP_FLAT_FILE_GROUP_CLOSE;
										}
									}
								}
							} else {
								flatFile.append(vo.getAttrCtnt5()).append(lineSep);
							}
						}
					}
log.info("\n\n\n\n\n\n\n\n\n\n\n\n"
		+"\n==HBL===============\n"
		+flatFile
		+"\n====================\n"
		+"\n\n\n\n\n\n\n\n\n\n\n\n");
					command.receiptXterRqst(flatFile.toString());
				}
			}
			commit();
		} catch(EventException ex) {
			rollback();
			sendErrLogMail(flatFile.toString(), ex);
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			sendErrLogMail(flatFile.toString(), ex);
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse receiptXterRqstEdiMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0228Event event = (EsmBkg0228Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		String flatFileStr = event.getMsg();
		XterRqstNoVO rqstNoVo = new XterRqstNoVO();
		try {
			begin();
			String[] headers = command.getReceiptXterRqstEdiMsgType(flatFileStr.split("\n")[0]);
			if(headers != null && headers[2].equalsIgnoreCase("VERMAS")){
				rqstNoVo = command.receiptXterRqstVermas(headers, flatFileStr);
				if(rqstNoVo.getAckRcv() != null && rqstNoVo.getAckRcv().equals("Y") && (event.getCommit() != null && event.getCommit().equalsIgnoreCase("ON"))){
					command.createVermasBkgAckEdi(headers, rqstNoVo);
				}
			}else{
				rqstNoVo = command.receiptXterRqst(flatFileStr);
				if ("S".equals(rqstNoVo.getDocTpCd())){
					command.createXterBkgAckEdi(rqstNoVo.getDocTpCd(), "XTER_ACK_RECEIVER", rqstNoVo);
				}
				if(!"E".equals(rqstNoVo.getDocTpCd()) || "".equals(rqstNoVo.getDocTpCd())){
					if(!rqstNoVo.getSenderId().equalsIgnoreCase("PEGASUS")){
						command.sendXterRqstNotice(rqstNoVo);
					}
				}
				
				if(rqstNoVo!=null){
					command.assignBkgNoToXterRqst(rqstNoVo);
					PerformanceReportBC command2 = new PerformanceReportBCImpl();
					DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
					dpcsWebBookingVO.setXterSndrId(rqstNoVo.getSenderId());
					dpcsWebBookingVO.setXterRqstNo(rqstNoVo.getRqstNo());
					dpcsWebBookingVO.setXterRqstSeq(rqstNoVo.getRqstSeq());
					if ( !"E".equals(rqstNoVo.getDocTpCd()) && !"H".equals(rqstNoVo.getXterBlTpCd())) {
						command2.addBkgSrRequest(dpcsWebBookingVO);	
					}
				}
			}
			
			if(event.getCommit() != null && event.getCommit().equalsIgnoreCase("ON")){
				commit();
			}else{
				rollback();
			}
		} catch (EventException ex) {
			rollback();
			throw new EventException(ex.getCause().getCause().getLocalizedMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getCause().getCause().getLocalizedMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * MQ connection handling(xml)<br>
	 * eBKG, eSI sending message handling throughout UBIZCOM_OPUSBKG_IB IBM MQ<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private EventResponse receiptXterRqstByXml(Event e) throws EventException {		
		GeneralEventResponse eventResponse = null;
		EBookingReceiptBC command = null;
		BkgHrdCdgCtntVO paramVO = null;
		List<BkgHrdCdgCtntVO> mapList = null;
		DateFormat dateFormat = null;
		StringBuilder flatFile = new StringBuilder();
		String msgSeq = "";
		String rcvMsg = "";
		String upldFlg = "Y";

		//[CWE-476] Return Value Testing on System.getProperty()
		try {
			eventResponse = new GeneralEventResponse();

			command = new EBookingReceiptBCImpl();
			paramVO = new BkgHrdCdgCtntVO();
			
			dateFormat = new SimpleDateFormat("yyyyMMdd");
			
			Document document = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);

			DocumentBuilder builder = factory.newDocumentBuilder();				

			//Batch에서 호출시
			EsmBkg1801Event event = (EsmBkg1801Event)e;
			
			if ("".equals(event.getRcvSeq()) || event.getRcvSeq() == null) {
				log.info("======================================");
				log.info("event : " + event.getRcvMsg());
				log.info("======================================");
				rcvMsg = event.getRcvMsg();
			} else {
				BkgXterRevMsgVO rcvMsgVO =  new BkgXterRevMsgVO();
				rcvMsgVO.setBkgXterRcvMsgSeq(event.getRcvSeq());
				BkgXterRevMsgVO bkgXterRevMsgVO = command.searchBkgXterRcvMsgView(rcvMsgVO);
				rcvMsg = bkgXterRevMsgVO.getXmlAndEdiMsgDesc().replace("※", "?");
			}			
			
			StringReader strXml = new StringReader(rcvMsg);
			InputSource socXml = new InputSource(strXml);			
			document = builder.parse(socXml);			

			if ("".equals(event.getRcvSeq()) || event.getRcvSeq() == null) {
				begin();
				upldFlg = "Y";				
//				msgSeq = command.createBkgXterRcvMsg(rcvMsg);
				commit();
			}else{
				upldFlg = "M";
				msgSeq = event.getRcvSeq();
			}
			
			//파일 직접 테스트시 주석제거
//			document = builder.parse("D:\\project\\BKG\\Transition Strategy\\Pegasus_UI_Bkg_rqst.xml");
						
			if (document != null) {
				paramVO.setHrdCdgId("XTER_BKG_RECEIPT_XML");
				mapList = command.searchMqXmlMappingList(paramVO);  //XTER_BKG_RECEIPT_XLS 
				if(mapList != null && mapList.size() > 0){
					begin();
					PegasusMapping pegasus = new PegasusMapping();
					String opusMapping = pegasus.mappingStart(command, mapList, document);
					log.debug("\n" + opusMapping);
					XterRqstNoVO rqstNoVo = command.receiptXterRqst(opusMapping);
					command.createBkgXterQtyByXml(rqstNoVo);
					command.modifyBkgXterRqstMst(rqstNoVo);
					
					try{
						command.ediPegasusBkgXterCntrDelete(rqstNoVo.getRqstNo(), rqstNoVo.getRqstSeq());
						command.ediPegasusBkgXterTroUpdate(rqstNoVo.getRqstNo(), rqstNoVo.getRqstSeq());
						command.ediPegasusBkgXterDgCgoUpdate(rqstNoVo.getSenderId(), rqstNoVo.getRqstNo(), rqstNoVo.getRqstSeq());
					}catch(Exception e1){
						log.error(e1);
					}
					
					command.modifyBkgXterRcvMsg(msgSeq, rqstNoVo.getSenderId(), rqstNoVo.getRqstNo(), rqstNoVo.getRqstSeq(), upldFlg);
					commit();
					if(rqstNoVo.getSenderId().equalsIgnoreCase("PEGASUS")){
						begin();
						command.sendXterRqstNotice(rqstNoVo);
						commit();
					}
				}
			}
			
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
			rollback();
			sendErrLogMail(flatFile.toString(), ex);
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
	 * ESM_BKG_0229 : REINSTATE click
	 * return EBookingReceipt position.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reinstateXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			
//			XterRqstNoVO[] XterRqstNoVOs = event.getXterRqstNoVOs();
			command.changeXterRqstStatus(event.getXterRqstNoVOs(), "N", "" ,account);
			eventResponse.setETCData("SuccessYn", "Y");
			
			commit();
				
//			for (int i = 0; i < XterRqstNoVOs.length; i++) {
//				Mail mail = new Mail();
//				mail.setFrom(account.getUsr_eml(), account.getUsr_nm());
//				mail.setSubject("Reinstate Notification");
//				mail.setRecipient(XterRqstNoVOs[i].getBkgCntcPsonEml());
//				StringBuilder sb = new StringBuilder(); 
//				sb.append("Dear Customer").append("</br>");
//				sb.append("Reinstate Booking no : " + XterRqstNoVOs[i].getBkgNo()).append("</br>");
//				sb.append("If you have any question, please contact our bookint & documentation").append("</br>");
//				sb.append("NYK Lines");
//				mail.setHtmlContent(sb.toString());
//				mail.send();
//			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * vaidation check if there is BKG No<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgBlNo(Event e) throws EventException {
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			BookingUtil utilCmd = new BookingUtil();
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(event.getBkgBlNoVO());
			if (bkgBlNoVO == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkgBlNoVO().getBkgNo() }).getMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_BKG_0228retrieve's COMBO value retrieve( CODE retrieve)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0228(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			BookingUtil comboUtil = new BookingUtil();
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			
			BkgComboVO combovo = new BkgComboVO();
			combovo.setDesc("All");
			combovo.setVal("All");

			// Request Status - xter_bkg_rqst_sts_cd
			List<BkgComboVO> xter_bkg_rqst_sts_cd = comboUtil.searchCombo("CD01620");
			// STS Code에서 'T'를 뺀다.
			List<BkgComboVO> list_xter_bkg_rqst_sts_cd = new ArrayList<BkgComboVO>();

			for(int i=0;i<xter_bkg_rqst_sts_cd.size();i++){
	            BkgComboVO vo = xter_bkg_rqst_sts_cd.get(i);
	            if ( !vo.getVal().equals("T") ){
					BkgComboVO comboVo = new BkgComboVO();
					comboVo.setComboCd(vo.getComboCd());
					comboVo.setVal(vo.getVal());
					comboVo.setName(vo.getVal());
					comboVo.setDesc(vo.getDesc());
					list_xter_bkg_rqst_sts_cd.add(comboVo);
	            }
	        }

			// Upload Status - bkg_upld_sts_cd
			List<BkgComboVO> bkg_upld_sts_cd = comboUtil.searchCombo("CD01630");

			// Via - xter_rqst_via_cd
			List<BkgComboVO> xter_rqst_via_cd = comboUtil.searchCombo("CD01622");

			// DOCType - doc_tp_cd
			List<BkgComboVO> doc_tp_cd = comboUtil.searchCombo("CD02090");

			// Delivery - conti_cd
			List<BkgComboVO> delivery = command.searchComboMdmConti();

			//bkg_cust_tp_cd
			List<BkgComboVO> bkg_cust_tp_cd = comboUtil.searchCombo("CD02140");

			eventResponse.setRsVoList(list_xter_bkg_rqst_sts_cd);
			eventResponse.setRsVoList(bkg_upld_sts_cd);
			eventResponse.setRsVoList(xter_rqst_via_cd);
			eventResponse.setRsVoList(doc_tp_cd);
			eventResponse.setRsVoList(delivery);
			eventResponse.setRsVoList(bkg_cust_tp_cd);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_BKG_0228retrieve's COMBO value retrieve( CODE retrieve)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0902(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg0902Event event = (EsmBkg0902Event)e;
			BookingUtil comboUtil = new BookingUtil();

			// Reject Reason Code - reject_reason_cd
			List<BkgComboVO> reject_reason_cd  = comboUtil.searchCombo("CD02193");

			eventResponse.setCustomData("reject_reason_cd", reject_reason_cd);
			eventResponse.setCustomData("xterRqstNoVO", event.getXterRqstNoVO());
			eventResponse.setCustomData("cntc_eml", event.getCntcEml());
			eventResponse.setCustomData("docTpCd", event.getDocTpCd());
			eventResponse.setCustomData("xterBkgRqstStsCd", event.getXterBkgRqstStsCd());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EBooking commodity description retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCmdtDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022907Event event = (EsmBkg022907Event)e;
			BookingUtil bUtil = new BookingUtil();
			String cmdtDesc = null;
			
			cmdtDesc = bUtil.searchMdmCmdtDesc(event.getCmdtCd());
			eventResponse.setETCData("cmdt_desc", cmdtDesc);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EBooking CONTAINER TAB's type/size retrieve for each container<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTypeSizeByCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022903Event event = (EsmBkg022903Event)e;
			BookingUtil bUtil = new BookingUtil();
			List<MstContainerVO> list = null;
			String cntrTpszCd = "";
			String cntrNo = "";
			
			list = bUtil.searchTypeSizeByCntr(event.getCntrNo());
			if (list != null && list.size() > 0) {
				MstContainerVO mstContainerVO = (MstContainerVO) list.get(0);
				cntrTpszCd = mstContainerVO.getCntrTpszCd();
				cntrNo = mstContainerVO.getCntrNo();				
			}
			eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);
			eventResponse.setETCData("cntr_no", cntrNo);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse cntrPrtFlgCountCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg022903Event event = (EsmBkg022903Event)e;
			BookingUtil bUtil = new BookingUtil();
			String bkgNo = "";
			bkgNo = bUtil.cntrPrtFlgCountCheck(event.getBkgNo(), event.getCntrNo());
			eventResponse.setETCData("bkgNo", bkgNo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * ESM_BKG_0229 : VVD CHANGE
	 * In case of inputting VESSEL , VESSEL NAME retrieve in EBookingReceipt BOOKING TAB<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslNm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022901Event event = (EsmBkg022901Event)e;
			BookingUtil bUtil = new BookingUtil();
			String vslNm = null;

			vslNm = bUtil.searchVslNm(event.getBkgTrunkVvd());
			eventResponse.setETCData("vsl_nm", vslNm);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_09 : OPEN
	 * EBookingReceipt AWKWARD CARGO Information retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterAk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022909Event event = (EsmBkg022909Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			
			ExternalRqstAkVO externalRqstAkVO = command.searchXterAk(event.getXterRqstNoVO());

			BookingUtil comboUtil = new BookingUtil();
			List<BkgComboVO> wgt_cd = comboUtil.searchCombo("CD00775");

			List<OpusCntrTpszVO> cntrTpsz = externalRqstAkVO.getOpusCntrTpszVO();
			eventResponse.setCustomData("cntr_tpsz", cntrTpsz);
			eventResponse.setCustomData("wgt_cd", wgt_cd);

			eventResponse.setCustomData("externalRqstAkVO", externalRqstAkVO);
			eventResponse.setRsVoList(externalRqstAkVO.getOpusAkVO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229 : OPEN
	 * Booking Information being gotten from eSVC(EDI, WEB ) retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event	= (EsmBkg022901Event)e;
		try {
			EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BookingUtil				util 		= new BookingUtil();
			BLIssuanceBC 			blIssBC 	= new BLIssuanceBCImpl();
			
			List<BkgComboVO> rcv_term 			= util.searchCombo("CD00764");
			List<BkgComboVO> dlv_term  			= util.searchCombo("CD00765");
			List<BkgComboVO> frt_term_cd  		= util.searchCombo("CD02080");
			List<BkgComboVO> usa_cstms_file_cd  = util.searchCombo("CD02098");
			List<BkgComboVO> cnd_cstms_file_cd  = util.searchCombo("CD01634");
			List<BkgComboVO> wgt_ut_cd  		= util.searchCombo("CD00775");

			eventResponse.setRsVoList(rcv_term);			//arrXml[0]
			eventResponse.setRsVoList(dlv_term);			//arrXml[1]
			eventResponse.setRsVoList(frt_term_cd);			//arrXml[2]
			eventResponse.setRsVoList(usa_cstms_file_cd);	//arrXml[3]
			eventResponse.setRsVoList(cnd_cstms_file_cd);	//arrXml[4]
			eventResponse.setRsVoList(wgt_ut_cd);			//arrXml[5]

			ExternalRqstBkgVO externalRqstBkgVO = command.searchXterBkg(event.getXterRqstNoVO());
			eventResponse.setCustomData("externalRqstBkgVO", externalRqstBkgVO);
			eventResponse.setRsVoList(externalRqstBkgVO.getBkgXterQtyVO());//arrXml[6]
			
			BookingCreationVO bookingCreationVO = null;
			if(event.getBkgBlNoVO().getBkgNo()!=null){
				bookingCreationVO = receiptBC.searchBooking(event.getBkgBlNoVO());
				
				//2014.08.26 김태균 임재관-ESM_BKG_0229_01화면중 Reference No Button 개발(ALPS-현행화)
				// searchReference No.  
				GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
				List<RefNoVO> refNoVOs = null; 
				BkgBlNoVO schBkgBlNoVO = new BkgBlNoVO();
				schBkgBlNoVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				schBkgBlNoVO.setCaFlg("N");
				refNoVOs = searchBC.searchBkgReference(schBkgBlNoVO);				
				if (refNoVOs.size() > 0) {
					for (RefNoVO refNoVO : refNoVOs) {
						String bkgRefTpCd = refNoVO.getBkgRefTpCd();
						String custRefNoCtnt = refNoVO.getCustRefNoCtnt();
						if ("FINV".equals(bkgRefTpCd)) {
							eventResponse.setETCData("inv_ref_no",custRefNoCtnt);
						} else if ("EBRF".equals(bkgRefTpCd)) {
							eventResponse.setETCData("bkg_ref_no",custRefNoCtnt);
						} else if ("EBSH".equals(bkgRefTpCd)) {
							eventResponse.setETCData("bkg_sh_ref_no",custRefNoCtnt);
						} else if ("EBFF".equals(bkgRefTpCd)) {
							eventResponse.setETCData("bkg_ff_ref_no",custRefNoCtnt);
						} else if ("ESRF".equals(bkgRefTpCd)) {
							eventResponse.setETCData("si_ref_no",custRefNoCtnt);
						} else if ("ESSH".equals(bkgRefTpCd)) {
							eventResponse.setETCData("si_sh_ref_no",custRefNoCtnt);
						} else if ("ESFF".equals(bkgRefTpCd)) {
							eventResponse.setETCData("si_ff_ref_no",custRefNoCtnt);
						} else if ("RGBK".equals(bkgRefTpCd)) {
							eventResponse.setETCData("reg_bkg_no",custRefNoCtnt);
						} else if ("XMRN".equals(bkgRefTpCd)) {
							eventResponse.setETCData("ext_mrn_no",custRefNoCtnt);
						}
					}
				}
				
				// 1. Documentation Requirement retrieve
				List<DocRqstVO> docRqstList = blIssBC.searchDocRqst(event.getBkgBlNoVO().getBkgNo(), account.getOfc_cd());
				if(docRqstList.size() > 0) {
					eventResponse.setCustomData("DocRqst", docRqstList.get(0));
				}
				
				
				String rstYn = searchBC.searchManualYn(schBkgBlNoVO);
				eventResponse.setETCData("mnl_bkg_no_flg",       rstYn == null?"N":"Y");
				
			}
			
			// If ther's no bkg data
			if(bookingCreationVO == null){
				// 06. Default setting
				BkgUsrDfltSetVO dfltVO = receiptBC.searchUserBkgDefault(account);

				eventResponse.setETCData("frt_term_cd",       "");
				eventResponse.setETCData("usa_cstms_file_cd", "");
				eventResponse.setETCData("cnd_cstms_file_cd", "");
				
				if(dfltVO != null){
					eventResponse.setETCData("rcv_term", 		dfltVO.getRcvTermCd());
					eventResponse.setETCData("de_term", 		dfltVO.getDeTermCd());
					eventResponse.setETCData("cntr_tpsz_cd", 	dfltVO.getCntrTpszCd());
					eventResponse.setETCData("wgt_ut_cd", 		dfltVO.getWgtUtCd());
					eventResponse.setETCData("auto_edi_hld_flg",dfltVO.getAutoEdiHldFlg());
				}else{
					eventResponse.setETCData("rcv_term", 		"");
					eventResponse.setETCData("dlv_term", 		"");
					eventResponse.setETCData("wgt_ut_cd", 		"");
					eventResponse.setETCData("cntr_tpsz_cd", 	"");
					eventResponse.setETCData("auto_edi_hld_flg","");
				}
				eventResponse.setETCData("DataYn", "N");
			} else {
				BkgBookingInfoVO bkgBookingInfoVO =  bookingCreationVO.getBkgBookingInfoVO();
				// BL No
				String orgBlNo = "";
				if(bookingCreationVO.getSplitMstBlNoVO() != null){
					orgBlNo = bookingCreationVO.getSplitMstBlNoVO().getBlNo();
				}
				eventResponse.setETCData("OrgBlNo",orgBlNo);	
				
				eventResponse.setETCData(bookingCreationVO.getBkgBlNoVO().getColumnValues());	
				// Booking Information
				eventResponse.setETCData(bkgBookingInfoVO.getColumnValues());	
				// Vsk Information
				List<VslSkdVO> vslSkd = bookingCreationVO.getVslSkd();
				eventResponse.setRsVoList(vslSkd);//arrXml[7]	
				// Quantity Information
				List<BkgQuantityVO> bkgQuantity = bookingCreationVO.getBkgQuantity();
				eventResponse.setRsVoList(bkgQuantity);//arrXml[8]
				// QtyDtl Information
				List<BkgQtyDtlVO> bkgQtyDtl = bookingCreationVO.getBkgQtyDtl();
				eventResponse.setRsVoList(bkgQtyDtl);////arrXml[9]	
				
				// CustomerInformation
				BlCustomerInfoVO blCustomerInfoVO = bookingCreationVO.getBlCustomerInfoVO();
				if(blCustomerInfoVO != null){
					eventResponse.setETCData(blCustomerInfoVO.getColumnValues());	
				}		
				// Contact Information
				eventResponse.setETCData("bkg_cntc_pson_nm", "");
				eventResponse.setETCData("bkg_cntc_pson_phn_no", "");	
				eventResponse.setETCData("bkg_cntc_pson_eml", "");	
				eventResponse.setETCData("bkg_cntc_pson_mphn_no", "");	
				eventResponse.setETCData("bkg_cntc_pson_fax_no", "");	
				eventResponse.setETCData("si_cntc_pson_nm", "");
				eventResponse.setETCData("si_cntc_pson_phn_no", "");	
				eventResponse.setETCData("si_cntc_pson_eml", "");	
				eventResponse.setETCData("si_cntc_pson_mphn_no", "");	
				eventResponse.setETCData("si_cntc_pson_fax_no", "");						
				List<BkgCntcPsonVO> bkgCntcPson = bookingCreationVO.getBkgCntcPson();					
				if(bkgCntcPson != null){
					BkgCntcPsonVO bkgCntcPsonVO = null;
					for(int i = 0 ; i < bkgCntcPson.size() ; i++){
						bkgCntcPsonVO = bkgCntcPson.get(i);
						if("BK".equals(bkgCntcPsonVO.getBkgCntcPsonTpCd())){
							eventResponse.setETCData("bkg_cntc_pson_nm", bkgCntcPsonVO.getCntcPsonNm());
							eventResponse.setETCData("bkg_cntc_pson_phn_no", bkgCntcPsonVO.getCntcPsonPhnNo());	
							eventResponse.setETCData("bkg_cntc_pson_eml", bkgCntcPsonVO.getCntcPsonEml());	
							eventResponse.setETCData("bkg_cntc_pson_mphn_no", bkgCntcPsonVO.getCntcPsonMphnNo());	
							eventResponse.setETCData("bkg_cntc_pson_fax_no", bkgCntcPsonVO.getCntcPsonFaxNo());	
						}else if("SI".equals(bkgCntcPsonVO.getBkgCntcPsonTpCd())){
							eventResponse.setETCData("si_cntc_pson_nm", bkgCntcPsonVO.getCntcPsonNm());
							eventResponse.setETCData("si_cntc_pson_phn_no", bkgCntcPsonVO.getCntcPsonPhnNo());	
							eventResponse.setETCData("si_cntc_pson_eml", bkgCntcPsonVO.getCntcPsonEml());	
							eventResponse.setETCData("si_cntc_pson_mphn_no", bkgCntcPsonVO.getCntcPsonMphnNo());	
							eventResponse.setETCData("si_cntc_pson_fax_no", bkgCntcPsonVO.getCntcPsonFaxNo());					
						}
					}
				}
				
				// If there is vl 
				if(!"Y".equals(bkgBookingInfoVO.getBdrFlg())){
					String mvmtStsCd[] = util.searchMVMTStatus(event.getBkgBlNoVO(), null);
					for(int i = 0 ; i < mvmtStsCd.length ; i++){
						if("VL".equals(mvmtStsCd[i])){
							eventResponse.setETCData("is_vl_flg","Y"); 
							break;
						}
					}
				}
				if("Y".equals(bkgBookingInfoVO.getRejectFlag())){
					eventResponse.setUserMessage(new ErrorHandler("BKG01035").getUserMessage());
				}
				
				String vslNm = util.searchVslNm(bkgBookingInfoVO.getBkgTrunkVvd());
				eventResponse.setETCData("vsl_nm", (vslNm==null)?"":vslNm);
				String frtTermCd = util.searchFrtTerm(bkgBookingInfoVO.getBkgNo());
				String blPrfShprFlg = util.searchBlPrfShprFlg(bkgBookingInfoVO.getBkgNo());
				eventResponse.setETCData("bl_prf_shpr_flg", blPrfShprFlg);
				eventResponse.setETCData("frt_term_cd",       frtTermCd);
				eventResponse.setETCData("DataYn", "Y");				
			}
			
			String xmlYn = "N";
			XterRqstNoVO vo = event.getXterRqstNoVO();
			if(vo != null){
				if(!StringUtils.isEmpty(vo.getSenderId()) || 
						!StringUtils.isEmpty(vo.getRqstNo()) || 
						!StringUtils.isEmpty(vo.getRqstSeq())
						){
					BkgXterRevMsgVO rcvMsgVO =  new BkgXterRevMsgVO();
					rcvMsgVO.setXterSndrId(vo.getSenderId());
					rcvMsgVO.setXterRqstNo(vo.getRqstNo());
					rcvMsgVO.setXterRqstSeq(vo.getRqstSeq());
					BkgXterRevMsgVO bkgXterRevMsgVO = command.searchBkgXterRcvMsgView(rcvMsgVO);
					if (bkgXterRevMsgVO != null) { 
						xmlYn = "Y";
					}
				}
			}
			eventResponse.setETCData("xml_yn", xmlYn);
			eventResponse.setETCData("DataYn", "Y");						
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_05 : OPEN
	 * EBookingReceipt의 CONTAINER MANIFEST Information retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterCm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022905Event event = (EsmBkg022905Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			ExternalRqstCmVO externalRqstCmVO = command.searchXterCm(event.getXterRqstNoVO());

			eventResponse.setRsVoList(externalRqstCmVO.getOpusCmVO());
			eventResponse.setRsVoList(externalRqstCmVO.getBkgXterCntrMkDescVO());
			eventResponse.setRsVoList(externalRqstCmVO.getBkgDgCgoVOs());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchXterCmShipment(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022905Event event = (EsmBkg022905Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			List<XterCmShipmentVO> list = command.searchXterCmShipment(event.getXterRqstNoVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0229_03 : OPEN
	 * EBookingReceipt의 CONTAINER TAB retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022903Event event = (EsmBkg022903Event)e;
			EBookingReceiptBC eBkgBC = new EBookingReceiptBCImpl();

			BookingUtil comboUtil = new BookingUtil();
			List<BkgComboVO> wgt_cd  			= comboUtil.searchCombo("CD00775");
			List<BkgComboVO> meas_cd  			= comboUtil.searchCombo("CD01116");
			List<BkgComboVO> rcv_term 			= comboUtil.searchCombo("CD00764");
			List<BkgComboVO> dlv_term  			= comboUtil.searchCombo("CD00765");


			List<BkgComboVO> list_rcv = new ArrayList<BkgComboVO>();
			List<BkgComboVO> list_de = new ArrayList<BkgComboVO>();
			
			for(int i=0;i<rcv_term.size();i++){
	            BkgComboVO vo = rcv_term.get(i);
	            if ( !vo.getVal().equals("M") ){
					BkgComboVO voRcv = new BkgComboVO();
					voRcv.setComboCd(vo.getComboCd());
					voRcv.setVal(vo.getVal());
					voRcv.setName(vo.getVal());
					voRcv.setDesc(vo.getDesc());
					list_rcv.add(voRcv);
	            }
	        }
			
			for(int i=0;i<dlv_term.size();i++){
	            BkgComboVO vo = dlv_term.get(i);
	            if ( !vo.getVal().equals("M") ){
					BkgComboVO voRcv = new BkgComboVO();
					voRcv.setComboCd(vo.getComboCd());
					voRcv.setVal(vo.getVal());
					voRcv.setName(vo.getVal());
					voRcv.setDesc(vo.getDesc());
					list_de.add(voRcv);
	            }
	        }
			eventResponse.setCustomData("wgt_cd", wgt_cd);
			eventResponse.setCustomData("meas_cd", meas_cd);
			eventResponse.setCustomData("rcv_term_cd", list_rcv);
			eventResponse.setCustomData("de_term_cd", list_de); 
//			eventResponse.setRsVoList(rcv_term);
//			eventResponse.setRsVoList(dlv_term);
			
			ExternalRqstCntrVO xterRqstCnrtVO = eBkgBC.searchXterCntr(event.getXterRqstNoVO());
			eventResponse.setCustomData("externalRqstCntrVO", xterRqstCnrtVO);

			String bkgNo = null;
			if(event.getBkgBlNoVO()==null){
				bkgNo = event.getXterRqstNoVO().getBkgNo();
			} else {
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			}
			
			if(bkgNo!=null){
				BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();
				CntrInfoOutVO bkgCntrVO = blCmBC.searchContainer(bkgNo, "N");
				if(bkgCntrVO!=null){
					//to form
					eventResponse.setCustomData("bkgCntrVO", bkgCntrVO);
					//to grid
					eventResponse.setRsVoList(bkgCntrVO.getCntrs());
					eventResponse.setRsVoList(bkgCntrVO.getCntrSealNos());
					eventResponse.setETCData("fnl_cfm_flg", bkgCntrVO.getCntrEtcInfo().getFnlCfmFlg());
					eventResponse.setETCData("evnt_usr_id", bkgCntrVO.getCntrEtcInfo().getEvntUsrId());
					eventResponse.setETCData("evnt_dt", bkgCntrVO.getCntrEtcInfo().getEvntDt());
				}
//				eventResponse.setRsVoList(bkgCntrVO.getCntrs());
//				eventResponse.setRsVoList(bkgCntrVO.getCntrSealNos());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_02 : OPEN
	 * EBookingReceipt CUSTOMER TAB retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterCust(Event e) throws EventException {
		EsmBkg022902Event event = (EsmBkg022902Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {			
			EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();			
			BookingUtil 			comboUtil 	= new BookingUtil();

			// KOREA CUSTOMS CUSTOMER TYPE CODE
			List<BkgComboVO> tp_cd  = comboUtil.searchCombo("CD02125");	
			eventResponse.setRsVoList(tp_cd);
			//eBKG
			ExternalRqstCustVO externalRqstCustVO = command.searchXterCust(event.getXterRqstNoVO());			
			eventResponse.setCustomData("externalRqstCustVO", externalRqstCustVO);

			//BKG
//			event.getBkgBlNoVO().setBkgNo(event.getXterRqstNoVO().getBkgNo());
			BkgBlNoVO bkgBlNoVO = null;
			if(event.getBkgBlNoVO()==null){
				bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(event.getXterRqstNoVO().getBkgNo());
			} else {
				bkgBlNoVO = event.getBkgBlNoVO();
			}			
			
			if(bkgBlNoVO!=null){
				GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
				
				BlCustomerVO blCustomerVO = null;
				blCustomerVO = receiptBC.searchBlDocCust(bkgBlNoVO);
				
				if(blCustomerVO!=null){				
					if(blCustomerVO.getBlDocCustVO() != null)
						eventResponse.setETCData(blCustomerVO.getBlDocCustVO().getColumnValues());
					if(blCustomerVO.getCustEtcVO() != null)
						eventResponse.setETCData(blCustomerVO.getCustEtcVO().getColumnValues());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_08 : OPEN
	 * EBookingReceipt DANGER CARGO Information retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterDg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg022908Event event = (EsmBkg022908Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			BookingUtil util = new BookingUtil();
			ExternalRqstDgVO externalRqstDgVO = command.searchXterDg(event.getXterRqstNoVO());

			List<OpusCntrTpszVO> cntrTpsz  = externalRqstDgVO.getOpusCntrTpszVO();
			eventResponse.setCustomData("cntr_tpsz", cntrTpsz);

			eventResponse.setCustomData("externalRqstDgVO", externalRqstDgVO);
			eventResponse.setRsVoList(externalRqstDgVO.getOpusDgVO());
			eventResponse.setRsVoList(externalRqstDgVO.getBkgXterDgCgoVO());
//			eventResponse.setRsVoList(comboUtil.searchCombo("CD01164"));
			
			//D/G Rider 조회
			//Opus dg rider 
			List<XterDgRiderVO> opusDgRiderVOs = command.searchOpusDgRiderList(event.getXterRqstNoVO());
			eventResponse.setRsVoList(opusDgRiderVOs);
			String opusCheckBoxString = command.searchOpusDgRiderCntrList(event.getXterRqstNoVO());
			eventResponse.setETCData("opusCheckBoxString", opusCheckBoxString);
			
			// e-svc dg rider
			List<XterDgRiderVO> xterBlRiderVOs = command.searchXterDgRiderList(event.getXterRqstNoVO());
			eventResponse.setRsVoList(xterBlRiderVOs);
			String checkBoxString = command.searchXterDgRiderCntrList(event.getXterRqstNoVO());
			eventResponse.setETCData("xterCheckBoxString", checkBoxString);
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("EBKG_DG_SEQ");			
			List<BkgHrdCdgCtntVO> dgSeq = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			if(dgSeq == null || dgSeq.size() == 0){
				eventResponse.setETCData("EBKG_DG_SEQ", "OFF");
			}else{
				if(dgSeq.get(0).getAttrCtnt1().equals("ON")){
					eventResponse.setETCData("EBKG_DG_SEQ", "ON");	
				} else {
					eventResponse.setETCData("EBKG_DG_SEQ", "OFF");
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_10 : OPEN
	 * EBookingReceipt의 HOUSE B/L Information retrievebr>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterHbl1(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022910Event event = (EsmBkg022910Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			BookingUtil util = new BookingUtil();

			List<BkgComboVO> wgt_cd  = util.searchCombo("CD00775");
			List<BkgComboVO> meas_cd  = util.searchCombo("CD01116");
			eventResponse.setRsVoList(wgt_cd);			//arrXml[0]
			eventResponse.setRsVoList(meas_cd);			//arrXml[1]			
			
			ExternalRqstHbl1VO externalRqstHbl1VO = command.searchXterHbl1(event.getXterRqstNoVO());

			eventResponse.setRsVoList(externalRqstHbl1VO.getOpusHbl1VO());
			eventResponse.setRsVoList(externalRqstHbl1VO.getXterHbl1VO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_11 : OPEN
	 *  HOUSE B/L's NVOCC NO Information retrieve EBookingReceipt<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterHbl2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022911Event event = (EsmBkg022911Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			ExternalRqstHbl2VO externalRqstHbl2VO = command.searchXterHbl2(event.getXterRqstNoVO());

			eventResponse.setRsVoList(externalRqstHbl2VO.getBkgUsaCstmsFileNoVO());
			eventResponse.setRsVoList(externalRqstHbl2VO.getXterUsaCstmsFileNoVO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_04 : OPEN
	 * MARK & DESCRIPTION TAB retrieve in EBookingReceipt<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterMnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = null;
		try {
			EsmBkg022904Event event = (EsmBkg022904Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			BookingUtil comboUtil = new BookingUtil();
			
			List<BkgComboVO> wgt_cd = comboUtil.searchCombo("CD00775");
			List<BkgComboVO> meas_cd = comboUtil.searchCombo("CD01116");
			List<BkgComboVO> aes_exception = comboUtil.searchCombo("CD02570");
			bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("CNTR_TP_SZ_DESC");
			List<BkgHrdCdgCtntVO> cntrTpSzDesc = comboUtil.searchHardCoding(bkgHrdCdgCtntListCondVO);
			eventResponse.setCustomData("wgt_cd", wgt_cd);
			eventResponse.setCustomData("meas_cd", meas_cd);
			
			ExternalRqstMndVO externalRqstMndVO = command.searchXterMnd(event.getXterRqstNoVO(), account.getOfc_cd());
			eventResponse.setCustomData("externalRqstMndVO", externalRqstMndVO);
			//E-SVC EXPORT LICENSE NUMBER
			eventResponse.setRsVoList(externalRqstMndVO.getKrXptLicNoVOs());
			
			//E-SVC P/O NO
			eventResponse.setRsVoList(externalRqstMndVO.getXterCntrPoNoVOs());
			eventResponse.setRsVoList(externalRqstMndVO.getXterPoDtlVOs());
			
			List<XterInnerPackageVO> xterInnerPackageVOs = command.searchXterInnerPackage(event.getXterRqstNoVO());
//			eventResponse.setCustomData("innerPackage", xterInnerPackageVOs);			
			eventResponse.setRsVoList(xterInnerPackageVOs);
			/* XTER Ship ID */
			eventResponse.setRsVoList(command.searchXterRefForRejectEdi(event.getXterRqstNoVO()));
			
			BkgBlNoVO bkgBlNoVO = null;
			if(event.getBkgBlNoVO()==null){
				bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(event.getXterRqstNoVO().getBkgNo());
			} else {
				bkgBlNoVO = event.getBkgBlNoVO();
			}
			
			if(bkgBlNoVO.getBkgNo()!=null){
				BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
				MndVO mndVO = blBC.searchMnd(bkgBlNoVO);
				eventResponse.setCustomData("MndVO", mndVO);
				//OPUS EXPORT LICENSE NUMBER
				eventResponse.setRsVoList(externalRqstMndVO.getOpusXptImpLicListVOs());

				//e-SVC P/O NO
				GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
				PoOtherNoVO rPoOtherNoVO = receiptBC.searchPoOtherNoByXter(bkgBlNoVO);
				
				List<PoOtherNoBkgVO> rlistNoBkgVOs = rPoOtherNoVO.getO_poOtherNoBkgVOs();
				List<PoOtherCntrVO> rlistCntrVOs = rPoOtherNoVO.getO_poOtherCntrVOs();
				List<PoOtherCmVO> rlistCmVOs = rPoOtherNoVO.getO_poOtherCmVOs();
				
				eventResponse.setRsVoList(rlistNoBkgVOs);
				eventResponse.setRsVoList(rlistCntrVOs);
				eventResponse.setRsVoList(rlistCmVOs);
			}

			eventResponse.setRsVoList(aes_exception);
			eventResponse.setRsVoList(cntrTpSzDesc);
			
			if(bkgBlNoVO.getBkgNo() != null){
				eventResponse.setRsVoList(command.searchPoNoByShip(bkgBlNoVO.getBkgNo()));
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_07 : OPEN
	 * REEFER CARGO Information retrieve in EBookingReceipt<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterRf(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil comboUtil = null;
		try {
			EsmBkg022907Event event = (EsmBkg022907Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			comboUtil = new BookingUtil();
			ExternalRqstRfVO externalRqstRfVO = command.searchXterRf(event.getXterRqstNoVO());

			List<OpusCntrTpszVO> cntrTpsz  = externalRqstRfVO.getOpusCntrTpszVO();
			eventResponse.setCustomData("cntr_tpsz", cntrTpsz);

			eventResponse.setCustomData("externalRqstRfVO", externalRqstRfVO);
			eventResponse.setRsVoList(externalRqstRfVO.getOpusRfVO());
			eventResponse.setRsVoList(externalRqstRfVO.getBkgXterRfCgoVO());
			eventResponse.setRsVoList(comboUtil.searchCombo("CD02095"));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0228 : RETREVE click
	 * EBKG/SI requesting LIST retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterRqstList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// PDTO(Data Transfer Object including Parameters)
			EsmBkg0228Event event = (EsmBkg0228Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			List<BkgXterSrchSetVO> searchSetList = null;
			StringBuffer qryWhere = new StringBuffer();

			if ("Y".equals(event.getXterRqstListInputVO().getSetSlctFlg())) {
				searchSetList = command.searchXterSrchSetForList(account.getUsr_id());
				for (int i=0;i<searchSetList.size();i++) {
					BkgXterSrchSetVO bkgXterSrchSetVO = new BkgXterSrchSetVO();
					bkgXterSrchSetVO = searchSetList.get(i);
					qryWhere.append(bkgXterSrchSetVO.getCustNm() + " \n");
				}
				event.getXterRqstListInputVO().setSetQryWhere(qryWhere.toString());
				log.debug(">>> WHERE SQL:"+event.getXterRqstListInputVO().getSetQryWhere());
			} else event.getXterRqstListInputVO().setSetQryWhere("");

			ExternalRqstListInputVO externalRqstListInputTmpVO = event.getXterRqstListInputVO();
			ExternalRqstListInputVO externalRqstListInputVO = new ExternalRqstListInputVO();
			if ( !isNull(externalRqstListInputTmpVO.getXterRqstNo()) || !isNull(externalRqstListInputTmpVO.getBkgNo()) ) {
				externalRqstListInputVO.setXterRqstNo(externalRqstListInputTmpVO.getXterRqstNo());
				externalRqstListInputVO.setBkgNo(externalRqstListInputTmpVO.getBkgNo());
				externalRqstListInputVO.setSplit(externalRqstListInputTmpVO.getSplit());
			} else externalRqstListInputVO = externalRqstListInputTmpVO;

			List<ExternalRqstListVO> list = command.searchXterRqstList(externalRqstListInputVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_06 : OPEN
	 * EBookingReceipt's TRO Information retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterTro(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022906Event event = (EsmBkg022906Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			GeneralBookingSearchBCImpl  tabByUserBC = new GeneralBookingSearchBCImpl();
			ExternalRqstTroVO externalRqstTroVO = command.searchXterTro(event.getXterRqstNoVO());

			eventResponse.setRsVoList(externalRqstTroVO.getOpusTroDtlVO());
			eventResponse.setRsVoList(externalRqstTroVO.getBkgXterTroDtlVO());
			eventResponse.setRsVoList(externalRqstTroVO.getOpusTroMstVO());
			eventResponse.setRsVoList(externalRqstTroVO.getBkgXterTroVO());
			
			String TroType = tabByUserBC.searchBkgCreTabByUser(account);
			if(TroType.equalsIgnoreCase("EUR")){
				eventResponse.setRsVoList(externalRqstTroVO.getOpusTroMstVO());
				List<OpusTroDtlVO> list = externalRqstTroVO.getOpusTroDtlVO();
				eventResponse.setRsVoList(list);
			}
			eventResponse.setETCData("TroType", TroType);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * After sending eBKG and eSI,if there is the error occured, Information sending<br>
	 * @param flatFileStr
	 * @param ex
	 * @param rcvMsgSeq
	 */
	private void sendErrLogMail(String flatFileStr, Exception ex) {
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			command.sendErrLogMail(ex.getMessage(), flatFileStr);
			commit();
		} catch(Exception ec){
			rollback();
			log.error(ec.getMessage()); // 2011.07.14
		}
	}

	/**
	 * ESM_BKG_0902 : OK CLICK
	 * In case of EBkg rejecting,  sending EDI.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendXterRqstRejectEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0902Event event = (EsmBkg0902Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			log.debug("getEmlSndYn:"+event.getEmlSndYn());
			if ( "Y".equals(event.getEmlSndYn()) && !event.getCntcEml().equals("")) {
				command.sendXterRqstRejectEmail(event);
			}
			
			XterRqstNoVO xterRqstNoVO = event.getXterRqstNoVO();
			command.createXterRqstRejectEdi(event.getRjctRsnRmk(), event.getXterRjctRsnCd(), xterRqstNoVO, account);
			
			if(xterRqstNoVO.getDocTpCd().equals("S")){
				command.createXterBkgAckEdi(xterRqstNoVO.getDocTpCd(), "XTER_ACK_REJECT", xterRqstNoVO);
			}
			eventResponse.setETCData("SuccessYn", "Y");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229 : UPLOAD click
	 * upload BKG_XTER_RQST_MST Information to OPUS (All TAB Upload)<br>
	 * Incase there are Route Information<br>
	 * multi event handling about EBookingReceipt's event<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		EsmBkg0229Event 	 event 			= (EsmBkg0229Event)e;
		log.info("\n[[[ uploadXterRqst - Start ]]]");
		try{
			String uiId = "ESM_BKG_0229";
        	GeneralBookingReceiptBC receiptBC  	= new GeneralBookingReceiptBCImpl();
			EBookingReceiptBC 		eBkgBC 		= new EBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC	= new GeneralBookingSearchBCImpl();
			BlRatingBC				rateBC		= new BlRatingBCImpl();
			BookingHistoryMgtBC 	historyBC	= new BookingHistoryMgtBCImpl();
			PerformanceReportBC     reportBC    = new PerformanceReportBCImpl();
        	BookingUtil             util      	= new BookingUtil();
			BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
			BLIssuanceBC            blIssBC    	= new BLIssuanceBCImpl();
						
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			XterRqstNoVO rqstVO = event.getXterRqstNoVO();
			String bkgNo = "";
			String blNo = "";
			String saveModeCd = "";
			HistoryTableVO historyTableVO = null;
			String replanFlg = "Y";
			String changeVvdFlag = "N";	
			String sType = null;
			String sLevel = null;
			String sMrd = null;
			StringBuilder sbParam = null;
			sbParam = new StringBuilder();
			
			DblWblVO[] dblWblVOs = null;
			BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
			List<BkgNtcHisVO> bkgNtcHisSysVOs = new ArrayList<BkgNtcHisVO>();
			OfcChgProcVO ofcChgProcVO = null;
			
			begin();

			if (event.getEsmBkg022901Event() == null) {
				throw new EventException(new ErrorHandler("BKG00391").getMessage()); 				
			} else {
				if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI01)
						||event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI02)) {
					saveModeCd = "C";
				} else if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI03)
						||event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI04)) {
					saveModeCd = "U";
				}
			}
			
			log.info("\n[[[ uploadXterRqst - saveModeCd ((( " + saveModeCd + " ))) ]]]");
			//create booking
			if("C".equals(saveModeCd)){
				if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI01)) {
					log.info("\n[[[ uploadXterRqst - createBkgWithoutRouteByXter ]]]");
					eventResponse = (GeneralEventResponse)createBkgWithoutRouteByXter(event.getEsmBkg022901Event());
				} else if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI02)) {
					log.info("\n[[[ uploadXterRqst - createBkgWithRouteByXter ]]]");
					eventResponse = (GeneralEventResponse)createBkgWithRouteByXter(event.getEsmBkg022901Event());
				}		
				
				if(eventResponse.getETCData("Toyota") != null && eventResponse.getETCData("Toyota").equals("Y"))
					return eventResponse;
				
				bkgNo = eventResponse.getETCData("bkg_no");
				blNo = eventResponse.getETCData("bl_no");
				bkgBlNoVO.setBkgNo(bkgNo);
				bkgBlNoVO.setBlNo(blNo);	
				//In case Bkg No id creating from eBkg, Information should be updated in BKG_XTER_RQST_MST
				rqstVO.setBkgNo(bkgNo);
//				eBkgBC.modifyXterBkgNo(rqstVO, account);	
				//getting  flag before customer updating
				if (event.getEsmBkg022902Event() != null) {
					log.info("\n[[[ uploadXterRqst - searchOfcChgProc 1 ]]]");
					ofcChgProcVO = new OfcChgProcVO();
					ofcChgProcVO.setType("C");  //customer
					ofcChgProcVO.setCaFlg(bkgBlNoVO.getCaFlg());
					ofcChgProcVO.setBkgNo(bkgNo);
					ofcChgProcVO.setCustToOrdFlg(event.getEsmBkg022902Event().getCustEtcVO().getCustToOrdFlg());
					ofcChgProcVO.setShCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getShCustCntCd());
					ofcChgProcVO.setShCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getShCustSeq());
					ofcChgProcVO.setCnCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getCnCustCntCd());
					ofcChgProcVO.setCnCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getCnCustSeq());
					ofcChgProcVO.setNfCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getNfCustCntCd());
					ofcChgProcVO.setNfCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getNfCustSeq());
					ofcChgProcVO = util.searchOfcChgProc(ofcChgProcVO);
				}
				
				// Doc Requirement  Save
				DocRqstVO docRqstVO = event.getEsmBkg022901Event().getDocRqstVO();
				if ( docRqstVO != null ) {
					docRqstVO.setUserId(account.getUsr_id());
					docRqstVO.setBkgNo(bkgNo);
					log.info("\n[[[ uploadXterRqst - modifyDocRqst ]]]");
					String rqstBlTpCd = docRqstVO.getRqstBlTpCd();
					if(rqstBlTpCd != null && (rqstBlTpCd.equals("O") || rqstBlTpCd.equals("S"))) rqstBlTpCd = "B";
					docRqstVO.setBlIssTpCd(rqstBlTpCd);
					bLIssuanceBC.modifyDocRqst(docRqstVO);
				}
				
			} else { // update booking
				bkgNo = bkgBlNoVO.getBkgNo();
				EsmBkg022901Event esmBkg022901Event = event.getEsmBkg022901Event();
				BkgBookingInfoVO bkgBookingInfoVO = event.getEsmBkg022901Event().getBkgBookingInfoVO();
				
				//////////////////////저장가능한지 체크 ///////////////////////
				String lstSavDt = util.bkgBookingSaveCheck(bkgBookingInfoVO);
				if(lstSavDt != null){
					if(!lstSavDt.equals(bkgBookingInfoVO.getLstSavDt()))
						throw new EventException(new ErrorHandler("BKG95064").getMessage()); 
				}
				
				bkgBlNoVO.setBdrFlg(event.getEsmBkg022901Event().getBdrFlg());
				if("Y".equals(bkgBlNoVO.getBdrFlg())){
					bkgBlNoVO.setCaFlg("Y");
					bkgBookingInfoVO.setCaFlg("Y");
				} else {
					bkgBlNoVO.setCaFlg("N");
					bkgBookingInfoVO.setCaFlg("N");
				}
				//getting  flag before customer updating
				if (event.getEsmBkg022902Event() != null) {
					log.info("\n[[[ uploadXterRqst - searchOfcChgProc 2 ]]]");
					ofcChgProcVO = new OfcChgProcVO();
					ofcChgProcVO.setType("C");  //customer
					ofcChgProcVO.setCaFlg(bkgBlNoVO.getCaFlg());
					ofcChgProcVO.setBkgNo(bkgNo);
					ofcChgProcVO.setCustToOrdFlg(event.getEsmBkg022902Event().getCustEtcVO().getCustToOrdFlg());
					ofcChgProcVO.setShCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getShCustCntCd());
					ofcChgProcVO.setShCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getShCustSeq());
					ofcChgProcVO.setCnCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getCnCustCntCd());
					ofcChgProcVO.setCnCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getCnCustSeq());
					ofcChgProcVO.setNfCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getNfCustCntCd());
					ofcChgProcVO.setNfCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getNfCustSeq());
					ofcChgProcVO = util.searchOfcChgProc(ofcChgProcVO);
				}

				log.info("\n[[[ uploadXterRqst - searchBlIss ]]]");
				eBkgBC.searchBlIss(bkgBlNoVO, account);
				
				log.info("\n[[[ uploadXterRqst - searchOldBkgForHistory ]]]");
				historyTableVO = historyBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
				
				bkgBookingInfoVO.setBkgPtyCntCd(historyTableVO.getBkgBookingVO().getBkgPtyCntCd());
				bkgBookingInfoVO.setBkgPtyCustSeq(historyTableVO.getBkgBookingVO().getBkgPtyCustSeq());
				
				esmBkg022901Event.setBkgBookingInfoVO(bkgBookingInfoVO);
				event.setEsmBkg022901Event(esmBkg022901Event);
				
				if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI03)) {
					log.info("\n[[[ uploadXterRqst - modifyBkgWithoutRouteByXter ]]]");
					eventResponse = (GeneralEventResponse)modifyBkgWithoutRouteByXter(event.getEsmBkg022901Event());
					//replanFlg = "Y";
				} else if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI04)) {
					log.info("\n[[[ uploadXterRqst - modifyBkgWithRouteByXter ]]]");
					eventResponse = (GeneralEventResponse)modifyBkgWithRouteByXter(event.getEsmBkg022901Event());
					//replanFlg = "N";
				}
				changeVvdFlag = eventResponse.getETCData("change_vvd");
				
				
//				 2015.07.22 by kimtaekyun -- old VVD search
				List<BkgVvdVO> tempOldVvds = historyTableVO.getBkgVvdVOs();
				List<BkgVvdVO> oldVvds = new ArrayList<BkgVvdVO>();
				if(tempOldVvds != null){
					for(int i=0;i<tempOldVvds.size();i++){
						if("U".equals(tempOldVvds.get(i).getVslPrePstCd()))		continue;
						oldVvds.add(tempOldVvds.get(i));
					}
				}
				
				List<BkgVvdVO> newVvds = receiptBC.searchBkgVvd(bkgBlNoVO);
				if(oldVvds.size()>0){
					for(int i = 0 ; i < oldVvds.size() ; i++){
						for(int j = 0 ; j < newVvds.size(); j++){
							if(newVvds.get(j).getVslPrePstCd().equals("U")) continue;
							
							if(oldVvds.get(i).getVslPrePstCd().equals(newVvds.get(j).getVslPrePstCd())
									&& oldVvds.get(i).getVslSeq().equals(newVvds.get(j).getVslSeq())
									&& oldVvds.get(i).getVslCd().equals(newVvds.get(j).getVslCd())
									&& oldVvds.get(i).getSkdVoyNo().equals(newVvds.get(j).getSkdVoyNo())
									&& oldVvds.get(i).getSkdDirCd().equals(newVvds.get(j).getSkdDirCd())
							)
								continue;
							
							String cateSepCd = "";
							if(oldVvds.get(i).getVslPrePstCd().equals("S")){
								cateSepCd = "VVSV";
							}else if(oldVvds.get(i).getVslPrePstCd().equals("T")){
								cateSepCd = "VVTV";
							}
							util.interfaceToTrs(cateSepCd, bkgBlNoVO.getBkgNo(), "O", "0", "0","",account, oldVvds.get(i).getVslPrePstCd(), oldVvds.get(i).getVslSeq());
						}
					}
				}
			}
			
			String psaValMsg = eventResponse.getETCData("psaValMsg");			
			
			if ( "N".equals(bkgBlNoVO.getCaFlg())) {
				// Doc Requirement  Save
				DocRqstVO docRqstVO = event.getEsmBkg022901Event().getDocRqstVO();
				if ( docRqstVO != null ) {
					docRqstVO.setUserId(account.getUsr_id());
					log.info("\n[[[ uploadXterRqst - modifyDocRqst ]]]");
					String rqstBlTpCd = docRqstVO.getRqstBlTpCd();
					if(rqstBlTpCd != null && (rqstBlTpCd.equals("O") || rqstBlTpCd.equals("S"))) rqstBlTpCd = "B";
					docRqstVO.setBlIssTpCd(rqstBlTpCd);
					bLIssuanceBC.modifyDocRqst(docRqstVO);
				}
			}
			

			if("YC".equals(eventResponse.getETCData("IsPctlNoPop"))||"YM".equals(eventResponse.getETCData("IsPctlNoPop"))
					||"Y".equals(eventResponse.getETCData("closeBkgFlag"))||"Y".equals(eventResponse.getETCData("cbfBkgFlag"))){
				return eventResponse;
			}
			
			//give bkg no of bkg tab to Save of each tab(creation, update same)
			// Customer 
			if (event.getEsmBkg022902Event() != null) {
				event.getEsmBkg022902Event().setBkgBlNoVO(bkgBlNoVO);
				event.getEsmBkg022902Event().setOfcChgProcVO(ofcChgProcVO);
				log.info("\n[[[ uploadXterRqst - modifyBlDocCust ]]]");
				eventResponse = (GeneralEventResponse)modifyBlDocCust(event.getEsmBkg022902Event());
			}

			//input prepaid/collect payer
			if (!"C".equals(saveModeCd)) {
				log.info("\n[[[ uploadXterRqst - modifyRateCntCd ]]]");
				rateBC.modifyRateCntCd(bkgNo, account, bkgBlNoVO.getCaFlg());
				
				//Incase por_cd, del_cd are different, prepaid, collect payer  modifying 
				String oldPorCd  = historyTableVO.getBkgBookingVO().getPorCd();
				String oldDelCd  = historyTableVO.getBkgBookingVO().getDelCd();
				String bkgPorCd  = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPorCd();
				String bkgDelCd  = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgDelCd();
				if("Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getRouteModifyFlag()) && ( !oldPorCd.equals(bkgPorCd) || !oldDelCd.equals(bkgDelCd) )){
					log.info("\n[[[ uploadXterRqst - createRateForTro ]]]");
					rateBC.createRateForTro(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg(), account);
				}
				
				String ctrtTpCd = "X";
				if(event.getEsmBkg022901Event().getBkgBookingInfoVO().getScNo().length()>0){
					ctrtTpCd = "S";
				}
				if(event.getEsmBkg022901Event().getBkgBookingInfoVO().getRfaNo().length()>0){
					ctrtTpCd = "R";
				}
				if(event.getEsmBkg022901Event().getBkgBookingInfoVO().getTaaNo().length()>0){
					ctrtTpCd = "T"; 
				}
				log.info("\n[[[ uploadXterRqst - modifyCtrtTpCd ]]]");
				rateBC.modifyCtrtTpCd(bkgBlNoVO.getBkgNo(), ctrtTpCd, account, bkgBlNoVO.getCaFlg());
			}

			// Container
			if (event.getEsmBkg022903Event() != null) {
				event.getEsmBkg022903Event().setBkgBlNoVO(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - manageContainer ]]]");
				eventResponse = (GeneralEventResponse)manageContainer(event.getEsmBkg022903Event());
			}
			// M&D
			if (event.getEsmBkg022904Event() != null) {
				event.getEsmBkg022904Event().setBkgBlNoVO(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - manageMnd ]]]");
				eventResponse = (GeneralEventResponse)manageMnd(event.getEsmBkg022904Event());
			}
			// C/M
			if (event.getEsmBkg022905Event() != null) {
				event.getEsmBkg022905Event().setBkgBlNoVO(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - manageCm ]]]");
				eventResponse = (GeneralEventResponse)manageCm(event.getEsmBkg022905Event());
			}
			// TRO/O
			if (event.getEsmBkg022906Event() != null) {
				event.getEsmBkg022906Event().setBkgBlNoVO(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - manageTro ]]]");
				eventResponse = (GeneralEventResponse)manageTro(event.getEsmBkg022906Event());
			}
			// Reefer
			if (event.getEsmBkg022907Event() != null ) {
				event.getEsmBkg022907Event().setBkgBlNoVO(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - manageRf ]]]");
				eventResponse = (GeneralEventResponse)manageRf(event.getEsmBkg022907Event());
			}
			// Danger
			if (event.getEsmBkg022908Event() != null ) {
				event.getEsmBkg022908Event().setBkgBlNoVO(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - manageDg ]]]");
				eventResponse = (GeneralEventResponse)manageDg(event.getEsmBkg022908Event());
			}
			// Awkward
			if (event.getEsmBkg022909Event() != null ) {
				event.getEsmBkg022909Event().setBkgBlNoVO(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - manageAwk ]]]");
				eventResponse = (GeneralEventResponse)manageAwk(event.getEsmBkg022909Event());
			}
			// House B/L 1
			if (event.getEsmBkg022910Event() != null ) {
				event.getEsmBkg022910Event().setBkgBlNoVO(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - manageHbl ]]]");
				eventResponse = (GeneralEventResponse)manageHbl(event.getEsmBkg022910Event());
			}
			
			// House B/L 2
			if (event.getEsmBkg022911Event() != null ) {
				event.getEsmBkg022911Event().setBkgBlNoVO(bkgBlNoVO);	
				log.info("\n[[[ uploadXterRqst - manageHbl2 ]]]");
				eventResponse = (GeneralEventResponse)manageHbl2(event.getEsmBkg022911Event());
			}
			// Complete Upload
			event.getXterRqstNoVO().setBkgNo(bkgNo);
			rqstVO.setDocTpCd(event.getEsmBkg022901Event().getDocTpCd());
			log.info("\n[[[ uploadXterRqst - modifyBkgByXter ]]]");
			receiptBC.modifyBkgByXter(event.getEsmBkg022901Event().getXterRqstViaCd(), saveModeCd, event.getEsmBkg022901Event().getAutoNotification(), rqstVO, account);
			log.info("\n[[[ uploadXterRqst - completeUpload ]]]");
			eBkgBC.completeUpload(rqstVO, account);
			
			//container attach detach cop handling
			if (event.getEsmBkg022903Event() != null && !"Y".equals(bkgBlNoVO.getBdrFlg())) {
				log.info("\n[[[ uploadXterRqst - saveModeCd ((( " + saveModeCd + " ))) ]]]");
				if("C".equals(saveModeCd)){
					if (event.getEsmBkg022903Event().getContainerVOs()!=null) {
						ContainerVO [] containerVOs = event.getEsmBkg022903Event().getContainerVOs();
						for(int i=0;i<containerVOs.length;i++){
							copBC.attachCntr(bkgBlNoVO.getBkgNo(), containerVOs[i].getCntrNo(), containerVOs[i].getCntrPrtFlg());
						}
					}
				}  else {
					if (event.getEsmBkg022903Event().getContainerVOs()!=null) {
						ContainerVO [] containerVOs = event.getEsmBkg022903Event().getContainerVOs();
						for(int i=0;i<containerVOs.length;i++){
							if("I".equals(containerVOs[i].getIbflag()) || "U".equals(containerVOs[i].getIbflag())){
								copBC.attachCntr(bkgBlNoVO.getBkgNo(), containerVOs[i].getCntrNo(), containerVOs[i].getCntrPrtFlg());
							} else if("D".equals(containerVOs[i].getIbflag())){
								copBC.detachCntr(bkgBlNoVO.getBkgNo(), containerVOs[i].getCntrNo(), containerVOs[i].getCntrPrtFlg());
							}
						}		
					}
				}				
			}
			log.info("\n[[[ uploadXterRqst - manageQtyCntrCoposite ]]]");
			reportBC.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CQ");	
			log.info("\n[[[ uploadXterRqst - saveModeCd ((( " + saveModeCd + " ))) ]]]");
			// 19. coa interface 
			if("C".equals(saveModeCd)){
				interfaceToCoa(bkgBlNoVO, "E-Booking Create", account);
			} else {
				interfaceToCoa(bkgBlNoVO, "E-Booking Update", account);
			}
			
			if("U".equals(saveModeCd)&&"Y".equals(bkgBlNoVO.getBdrFlg())){
				//BC for auto c/a
	    		BLDocumentationBLBC     blDocBlBC  		= new BLDocumentationBLBCImpl();
	    		SpecialCargoReceiptBC   spclCgoBC  		= new SpecialCargoReceiptBCImpl();
	    		BlRatingBC              blRatingBC		= new BlRatingBCImpl();
		    	BDRCorrectionBC         bdrBC      		= new BDRCorrectionBCImpl();
				RevenueDebitNoteBC      rdnBC      		= new RevenueDebitNoteBCImpl();
				CargoReleaseOrderBC     cgoRelBC   		= new CargoReleaseOrderBCImpl();
				    			
				// 1st C/A History
            	String strReturn  = "N";    		
    			String copyTypeCd = "HIST000";
    			log.info("\n[[[ uploadXterRqst - add1stCaHist ]]]");
    			strReturn = bdrBC.add1stCaHist(bkgBlNoVO, account);	    						
    			if ("N".equals(strReturn)) {
    				bkgBlNoVO.setCaNo("0000000001"); 
    				receiptBC.createBookingCA(bkgBlNoVO, copyTypeCd);  
    				blDocBlBC.createBlCA     (bkgBlNoVO, copyTypeCd);  
    				spclCgoBC.createSpclCA   (bkgBlNoVO, copyTypeCd);  
    				blRatingBC.createRateCA  (bkgBlNoVO, copyTypeCd);  
    				blIssBC.createIssCA      (bkgBlNoVO, copyTypeCd); 
    			}	    			

    			log.info("\n[[[ uploadXterRqst - searchCorrReplan ]]]");
				//Replan  retrieve 
				List<CorrReplanVO> corrReplanVOs = bdrBC.searchCorrReplan(bkgBlNoVO);
				
				// C/A Complete handling (temp -> BKG)
				copyTypeCd = "BKG";
				bdrBC.modifyCngItemFlag     (bkgBlNoVO, account);
				blDocBlBC.modifyCaComplete  (bkgBlNoVO);
				receiptBC.createBookingCA	(bkgBlNoVO, copyTypeCd);
				blDocBlBC.createBlCA        (bkgBlNoVO, copyTypeCd);
				blRatingBC.createRateCA     (bkgBlNoVO, copyTypeCd);
				spclCgoBC.createSpclCA     	(bkgBlNoVO, copyTypeCd);
				blIssBC.createIssCA         (bkgBlNoVO, copyTypeCd); 			
				
				// C/A History creating createTempHist (bkg -> hist)
				copyTypeCd = "HIST";
				log.info("\n[[[ uploadXterRqst - createTempHist ]]]");
				bkgBlNoVO = bdrBC.createTempHist(bkgBlNoVO, "H", null, account);//getting corr no 
				String caNo = bkgBlNoVO.getCaNo();
				receiptBC.createBookingCA	(bkgBlNoVO, copyTypeCd);
				blDocBlBC.createBlCA        (bkgBlNoVO, copyTypeCd);
				spclCgoBC.createSpclCA     	(bkgBlNoVO, copyTypeCd);
				blRatingBC.createRateCA     (bkgBlNoVO, copyTypeCd);
				blIssBC.createIssCA         (bkgBlNoVO, copyTypeCd);

				// In case of c/a History
				log.info("\n[[[ uploadXterRqst - manageBookingHistory ]]]");
				historyBC.manageBookingHistory(uiId, historyTableVO, account);
				log.info("\n[[[ uploadXterRqst - modifyCaCorrNoForHistory ]]]");
				bkgBlNoVO.setCaNo(caNo);
				historyBC.modifyCaCorrNoForHistory(bkgBlNoVO);
				
				// C/A History Temp deleting
				copyTypeCd = "TEMP";
				log.info("\n[[[ uploadXterRqst - removeCA 1 ]]]");
				spclCgoBC.removeCA  		(bkgBlNoVO, copyTypeCd);
				log.info("\n[[[ uploadXterRqst - removeCA 2 ]]]");
				blRatingBC.removeCA         (bkgBlNoVO, copyTypeCd);
				log.info("\n[[[ uploadXterRqst - removeCA 3 ]]]");
				blIssBC.removeCA           	(bkgBlNoVO, copyTypeCd);
				log.info("\n[[[ uploadXterRqst - removeCA 4 ]]]");
				blDocBlBC.removeCA    		(bkgBlNoVO, copyTypeCd);
				log.info("\n[[[ uploadXterRqst - removeCA 5 ]]]");
				receiptBC.removeCA			(bkgBlNoVO, copyTypeCd);
				log.info("\n[[[ uploadXterRqst - removeCATemp ]]]");
				bdrBC.removeCATemp    		(bkgBlNoVO);
				log.info("\n[[[ uploadXterRqst - distributeCntrRate ]]]");
				blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);

				for(int i=0;i<corrReplanVOs.size();i++){
					log.debug("operation:"+corrReplanVOs.get(i).getOperation());
				}

				if(corrReplanVOs.size()>0){
					for(int i=0;i<corrReplanVOs.size();i++){
						if("CNTR_ATTACH".equals(corrReplanVOs.get(i).getOperation())){	
							log.info("\n[[[ uploadXterRqst - attachCntr ]]]");
							copBC.attachCntr(bkgBlNoVO.getBkgNo(), corrReplanVOs.get(i).getCntrNo(), corrReplanVOs.get(i).getCntrPrtFlg());
						}
						if("CNTR_DETACH".equals(corrReplanVOs.get(i).getOperation())){	
							log.info("\n[[[ uploadXterRqst - detachCntr ]]]");
							copBC.detachCntr(bkgBlNoVO.getBkgNo(), corrReplanVOs.get(i).getCntrNo(), corrReplanVOs.get(i).getCntrPrtFlg());
						}
					}
					for(int i=0;i<corrReplanVOs.size();i++){
						if("REPLAN".equals(corrReplanVOs.get(i).getOperation())){	
							ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();			
							PrdParameterVO prdParameterVO = new PrdParameterVO();
							PrdMainInfoVO  prdMainInfoVO = new PrdMainInfoVO();
							BkgBlNoVO      caBkgBlNoVO = bkgBlNoVO;
										
							caBkgBlNoVO.setCaFlg("N");
							prdMainInfoVO.setFCmd("3");
							prdMainInfoVO.setBkgNo(caBkgBlNoVO.getBkgNo());
							prdMainInfoVO.setPcMode("R");
							prdParameterVO.setBkgBlNoVO(caBkgBlNoVO);
							prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
							prdParameterVO = util.searchPrdParmForFullRoute(prdParameterVO);
							prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("");
							prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("");
							log.info("\n[[[ uploadXterRqst - prdParameterLog ]]]");
							util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
							// 03. createProdCtlRout 
							log.info("\n[[[ uploadXterRqst - createPrdCtlgRout ]]]");
							String pctlNoMapStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
							log.info("\n[[[ uploadXterRqst - splitByToken ]]]");
							String [] pctlNoMapSeq = util.splitByToken(pctlNoMapStr,"|");
							log.info("\n[[[ uploadXterRqst - updateBkg ]]]");
							copBC.updateBkg(caBkgBlNoVO.getBkgNo(), pctlNoMapSeq[1]);
						}
					}
				}			
				
				log.info("\n[[[ uploadXterRqst - searchOblIssue ]]]");
				//RDN								
				OblIssVO oblIssVO = util.searchOblIssue(bkgBlNoVO); 
				RevDrNoteVO revDrNoteVO 		  = new RevDrNoteVO(); 
				CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
				bkgRevDrNoteVO.setBkgNo      (bkgBlNoVO.getBkgNo());  
				bkgRevDrNoteVO.setBkgCorrNo  (bkgBlNoVO.getCaNo()); 
				bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
				bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
				bkgRevDrNoteVO.setReceiverRmk("");
				revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);	
				log.info("\n[[[ uploadXterRqst - acceptRDNbyReceiptOffice ]]]");
				rdnBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
				
				//cargo release
				OblRdemVO oblRdem = new OblRdemVO();
				oblRdem.setBlNo      (oblIssVO.getBlNo());  
				oblRdem.setCgorTeamCd("C");
				oblRdem.setCgoEvntNm ("B/L Correct");
				oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				oblRdem.setEvntOfcCd (account.getOfc_cd());
				oblRdem.setEvntUsrId (account.getUsr_id());
				oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 				

				try{
					log.info("\n[[[ uploadXterRqst - setupFocByObl ]]]");
					cgoRelBC.setupFocByObl(oblRdem);	
				} catch(Exception crEx){
					log.error("err " + crEx.toString(), crEx);
				}	

			}
			
			if("U".equals(saveModeCd)&&!"Y".equals(bkgBlNoVO.getBdrFlg())){
				log.info("\n[[[ uploadXterRqst - changeVvdFlag ((( " + changeVvdFlag + " ))) ]]]");
				if("Y".equals(changeVvdFlag)){
					//In case of not c/a, spcl cgo auto request
					log.info("\n[[[ uploadXterRqst - searchBkgForSpclRqst ]]]");
					ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, "EBKG", account);
			        
					// In case of there is spcl cgo, handling
			        if(scgAproRqstVOs.length>0){
						OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
						SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();
						
						try{
							log.info("\n[[[ uploadXterRqst - searchBkgVvd ]]]");
					        ScgVvdAproRqstVO[] scgVvdVOs = spclReceiptBC.searchBkgVvd(bkgBlNoVO.getBkgNo());
					        if(scgVvdVOs.length>0){
							
								SpclCgoAproApplVO           spclCgoAproVO = new SpclCgoAproApplVO();
								spclCgoAproVO.setBkgNo(bkgBlNoVO.getBkgNo());
								spclCgoAproVO.setAccount(account);
								spclCgoAproVO.setCreUsrId(account.getUsr_id());
								spclCgoAproVO.setUpdUsrId(account.getUsr_id());
								log.info("\n[[[ uploadXterRqst - searchSpclReqInVO ]]]");
								spclCgoAproVO.setSpclReqInVOs(searchBC.searchSpclReqInVO(bkgBlNoVO));
								
								for(int i=0;i<scgAproRqstVOs.length;i++){
									if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
										spclCgoAproVO.setSpclCgoTp("D");
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 1 ]]]");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);	
									}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
										spclCgoAproVO.setSpclCgoTp("R");
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 2 ]]]");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
										spclCgoAproVO.setSpclCgoTp("A");
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 3 ]]]");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
										spclCgoAproVO.setSpclCgoTp("B");
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 4 ]]]");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}else if ("SS".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //Stowage
										spclCgoAproVO.setSpclCgoTp("S");
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 5 ]]]");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}	
								}		
			
								//calling SCG module	        
						        for(int i=0;i<scgAproRqstVOs.length;i++){
						        	ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
						        	scgAproRqstVO[0] = scgAproRqstVOs[i];
									if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 1 ]]]");
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 2 ]]]");
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 3 ]]]");
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 4 ]]]");
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}else if ("SS".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //Stowage
										log.info("\n[[[ uploadXterRqst - manageSpclCgoApro 5 ]]]");
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}	
						        }
					        }
						} catch(Exception spclEx){
							log.error(spclEx);
						}
			        }
				}
				log.info("\n[[[ uploadXterRqst - manageBookingHistory ]]]");
				// In case of not c/a ,It's History
				historyBC.manageBookingHistory(uiId, historyTableVO, account);
			}
			commit();
			//Incase of changing route or volume
			if(!"Y".equals(bkgBlNoVO.getBdrFlg())&&"Y".equals(replanFlg)){	
				log.info("\n[[[ uploadXterRqst - manageBookingHistory ]]]");
				try{// cut off time (After cop creating, handling)					
					String fromDt = null;
					String toDt   = null;					
					if("US".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPorCd().substring(0, 2)) || "CA".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPorCd().substring(0, 2))){
						ProductCatalogCreateBC prdBC   = new ProductCatalogCreateBCImpl();
//						BkgQuantityVO[] bkgQuantityVOs = event.getEsmBkg022901Event().getBookingCreationVO().getBkgQuantityVOs();
						BkgQuantityVO[] bkgQuantityVOs = event.getEsmBkg022901Event().getBkgQuantityVOs();
						PrdQtyInfoVO[]  prdQtyInfo 	   = new PrdQtyInfoVO[bkgQuantityVOs.length];						
						for(int i = 0 ; i < bkgQuantityVOs.length ; i++){	
							prdQtyInfo[i] = new PrdQtyInfoVO();				
							prdQtyInfo[i].setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
							prdQtyInfo[i].setCQty(bkgQuantityVOs[i].getOpCntrQty());				
						}						
						log.info("\n[[[ uploadXterRqst - getRailRecevingTime ]]]");
						Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null);
						fromDt= (String)railTime.get("RTN_TIME");
						toDt  = (String)railTime.get("CUT_OFF");
					}
					HistoryTableVO clzTmHistVO = null;
					log.info("\n[[[ uploadXterRqst - searchOldBkgForHistory ]]]");
					if("U".equals(saveModeCd)) clzTmHistVO = historyBC.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVO);
					
					begin(); //devide Transaction for batch server access
					log.info("\n[[[ uploadXterRqst - createCargoClosingTime ]]]");
					receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);	
					log.info("\n[[[ uploadXterRqst - searchCargoClosingTime ]]]");
					ClzTmListVO clzTmListVO = searchBC.searchCargoClosingTime(bkgBlNoVO, account);	
					for(int j=0;j<clzTmListVO.getClzTmVO().size();j++){
						if("F".equals(clzTmListVO.getClzTmVO().get(j).getClzTpCd())){
							if(clzTmListVO.getClzTmVO().get(j).getManualupdatetime()!=null||
								clzTmListVO.getClzTmVO().get(j).getManualupdatetime().length()>1){
								fromDt = clzTmListVO.getClzTmVO().get(j).getManualupdate(); 
							} else {
								fromDt = clzTmListVO.getClzTmVO().get(j).getSystemdate();
							}
						}
						if("O".equals(clzTmListVO.getClzTmVO().get(j).getClzTpCd())){
							if(clzTmListVO.getClzTmVO().get(j).getManualupdatetime()!=null||
								clzTmListVO.getClzTmVO().get(j).getManualupdatetime().length()>1){
								toDt = clzTmListVO.getClzTmVO().get(j).getManualupdate(); 
							} else {
								toDt = clzTmListVO.getClzTmVO().get(j).getSystemdate();
							}
						}
					}
					log.info("\n[[[ uploadXterRqst - modifyRailRcvCoffDt ]]]");
					copBC.modifyRailRcvCoffDt(bkgBlNoVO.getBkgNo(), fromDt, toDt, account.getUsr_id());
					if("U".equals(saveModeCd)) {
						log.info("\n[[[ uploadXterRqst - manageBookingHistory ]]]");
						historyBC.manageBookingHistory("ESM_BKG_0721", clzTmHistVO, account);
					}
					
					commit();				
				} catch(Exception prdEx){
					rollback();
					log.error("err"+prdEx.toString(),prdEx);
				}		
			}			
			begin();
//			if ("S".equals(event.getEsmBkg022901Event().getDocTpCd())){
//				log.info("\n[[[ uploadXterRqst - createXterBkgAckEdi ]]]");
//				eBkgBC.createXterBkgAckEdi(event.getEsmBkg022901Event().getDocTpCd(), rqstVO);
//			}
			
			if( "Y".equals(event.getEsmBkg022901Event().getAutoNotification()) && event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().trim().length() > 0
			&& !StringUtils.containsNone(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().trim(), "@")) { 
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				
				BkgBookingInfoVO bkgBookingInfoVO = event.getEsmBkg022901Event().getBkgBookingInfoVO();
				String [] eml = new String[bkgBookingInfoVO.getBkgCntcPsonEml().length()];
				eml[0] = bkgBookingInfoVO.getBkgCntcPsonEml();
				String [] rmk = new String[1];
				rmk[0] = "";
				if ("B".equals(event.getEsmBkg022901Event().getDocTpCd())){
					
					boolean mailSendFlg = true;
					
					log.debug("\n <<<<< getBkgWtChkFlg : " + bkgBlNoVO.getBkgWtChkFlg() + " >>>>>>");
					log.debug("\n <<<<< getDcgoFlg : " + bkgBookingInfoVO.getDcgoFlg() + " >>>>>>");
					log.debug("\n <<<<< getRcFlg : " + bkgBookingInfoVO.getRcFlg() + " >>>>>>");
					log.debug("\n <<<<< getAwkCgoFlg : " + bkgBookingInfoVO.getAwkCgoFlg() + " >>>>>>");
					log.debug("\n <<<<< getBkgStsCd : " + bkgBookingInfoVO.getBkgStsCd() + " >>>>>>");
					
					/* Wait 체크일때는 메일이 발송되지 않는다. */
					if(bkgBlNoVO.getBkgWtChkFlg().equals("Y")){
						mailSendFlg = false;
						
					/* Special DG,RF,AK 체크되어있으면 Status가 null,W 일경우 메일이 발송되지 않는다. */
					}else if(bkgBookingInfoVO.getDcgoFlg().equals("Y") || bkgBookingInfoVO.getRcFlg().equals("Y") || bkgBookingInfoVO.getAwkCgoFlg().equals("Y")){
						if(bkgBookingInfoVO.getBkgStsCd().equals("") || bkgBookingInfoVO.getBkgStsCd().equals("W")){
							mailSendFlg = false;
						}
					}
					
					log.debug("\n <<<<< mailSendFlg : " + mailSendFlg + " >>>>>>");
					/* 메일 발송 */
					if(mailSendFlg){
						// 신규
						log.debug("<<<<< RqstSeq : " + rqstVO.getRqstSeq() + " >>>>>>");
						int contentType = 0;
						/* Special CaGo 체크 로직으로 메일 내용 변경*/
						if(bkgBookingInfoVO.getRcFlg().equals("Y") || bkgBookingInfoVO.getDcgoFlg().equals("Y") || bkgBookingInfoVO.getAwkCgoFlg().equals("Y")){
							contentType = 1;
						}
						
						if(rqstVO.getRqstSeq().equals("1")){
							util.sendXterReceiptByEmail(bkgBlNoVO.getBkgNo(), bkgBookingInfoVO.getBkgCntcPsonEml(), account, 0, contentType, "ESM_BKG_0229");
						}
						// 수정
						else{
							util.sendXterReceiptByEmail(bkgBlNoVO.getBkgNo(), bkgBookingInfoVO.getBkgCntcPsonEml(), account, 1, contentType, "ESM_BKG_0229");
						}
					}else{
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgNo);
						bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
						bkgDocProcSkdVO.setBkgDocProcTpCd("EBKNTC");
						BkgDocProcSkdVO temp = util.searchDocProcSkd(bkgDocProcSkdVO, "");
						
						if(temp == null){
							bkgDocProcSkdVO.setDocProcSeq("0");
							bkgDocProcSkdVO.setDocPerfDeltFlg("N");
							util.addBkgDocProcSkd(bkgDocProcSkdVO);
						}
					}
				} else if ("S".equals(event.getEsmBkg022901Event().getDocTpCd()) || "U".equals(event.getEsmBkg022901Event().getDocTpCd())){
					sbParam = new StringBuilder();
					StringBuilder titleSb = new StringBuilder("Web B/L Instruction Notification ");
					titleSb.append(" ( ").append(bkgBlNoVO.getBkgNo()).append(" :  Uploaded )");
					StringBuilder contentSb = new StringBuilder("Dear Customer");
					contentSb.append("\n\nThank you for using our website");
					contentSb.append("\nYour B/L instruction request for '").append(bkgBlNoVO.getBkgNo()).append("'  request is successfully processed in our booking & documentation system.");
					contentSb.append("\nFor your cargo information, refer to the attached file");
					contentSb.append("\n\n\nIf you have any question, please contact our booking & documentation");
					contentSb.append("\n").append(account.getUsr_id());
					contentSb.append("\n\n\nWe would like to listen to how you think of our service, If you have any suggestions or comments");
					contentSb.append("\nplease visit our website and leave your comments into the section of Voice of Customer");
					
					contentSb.append("To access NYK Group on-line, please go to <a>http://www.nykline.com</a>").append("<br>");
					contentSb.append("Please contact your local NYK Line office if you need any assistance.").append("<br>").append("<br>");
					contentSb.append("Thank you for shipping with NYK Line. ").append("<br>").append("<br>");
					contentSb.append("*** NOTE - Please do not respond to this email.***").append("<br>");
					
					//sType="2";
					sType="7";
					//sMrd="ESM_BKG_0109_DBL.mrd";
					sMrd="ESM_BKG_0109_OBL_A4.mrd";
					sLevel="1"; 
					
					sbParam.append("/rv");
					sbParam.append(" form_bkgNo[('").append(bkgBlNoVO.getBkgNo()).append("')]");
					sbParam.append(" form_type[").append(sType).append("]");
					sbParam.append(" form_dataOnly[N]");
					sbParam.append(" form_manifest[N]");
					sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
					sbParam.append(" form_hiddeData[N]");
					sbParam.append(" form_level[(").append(sLevel).append(")]");
					sbParam.append(" form_remark[").append(rmk[0]).append(")]");
					sbParam.append(" form_Cntr[1]");
					sbParam.append(" form_mainOnly[N]");
					sbParam.append(" form_CorrNo[]");
					sbParam.append(" form_his_cntr[BKG_CONTAINER]");
					sbParam.append(" form_his_bkg[BKG_BOOKING]");
					sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
					sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
					sbParam.append(" form_his_bl[BKG_BL_DOC]");
					sbParam.append(" form_rqst_via_cd[]");
					sbParam.append(" form_his_bl_mkd[BKG_BL_ISS]"); 						
					sbParam.append(" /rp []");
					sbParam.append(" /riprnmargin");
					dblWblVOs = new DblWblVO[1];
					dblWblVOs[0] = new DblWblVO();
					dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
					dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
					dblWblVOs[0].setSyscd("BKG");
					dblWblVOs[0].setTmplmrd(sMrd);
					dblWblVOs[0].setBatchflg("N");
					dblWblVOs[0].setTmplparam(sbParam.toString());
					dblWblVOs[0].setRcveml(eml[0]);
					dblWblVOs[0].setTmplmrdpdf("Original.pdf");
					dblWblVOs[0].setItr("|$$|");
					dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setTitle(titleSb.toString()); /* 제목 */
					dblWblVOs[0].setContents(contentSb.toString()); /* contents */
					List<BkgNtcHisVO> bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, null, account);
					bkgNtcHisVO = bkgNtcHisVOs.get(0);
		            bkgNtcHisVO.setSndUsrId("SYSTEM");
		            bkgNtcHisSysVOs.add(bkgNtcHisVO);
		            log.info("\n[[[ uploadXterRqst - createBkgNtcHis ]]]");
					historyBC.createBkgNtcHis(bkgNtcHisSysVOs, "ESM_BKG_0229");
				}
			}
			
			if(!"Y".equals(bkgBlNoVO.getBdrFlg())||!"Y".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getEdiHldFlg())){
				log.info("\n[[[ uploadXterRqst - createCustBkgReceiptEdiBackEnd ]]]");
				searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);
				if("C".equals(saveModeCd)){
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("N");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					log.info("\n[[[ uploadXterRqst - createTmlBkgReceiptEdiBackEnd 1 ]]]");
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);	
				} else {
					String brac = "X";
					brac = "Y".equals(changeVvdFlag)?"B":"U";
					if(!"X".equals(brac)){
						if("B".equals(brac)){
							// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(historyTableVO.getBkgVvdVOs());
							vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
							vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
							vender301ParamVO.setBracCd(brac);
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							log.info("\n[[[ uploadXterRqst - createTmlBkgReceiptEdiBackEnd 2 ]]]");
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);	
						} else {
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(historyTableVO.getBkgVvdVOs());
							vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
							vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
							vender301ParamVO.setBracCd(brac);
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							log.info("\n[[[ uploadXterRqst - createTmlBkgReceiptEdiBackEnd 3 ]]]");
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);		
						}
					}
				}
			}
			
			if("U".equals(saveModeCd)){
				log.info("\n[[[ uploadXterRqst - interfaceToInv ]]]");
				interfaceToInv(bkgBlNoVO, account);
			}
			eventResponse.setETCData("bkg_no", bkgNo);
			commit();

			
			if(psaValMsg != null && psaValMsg.equals("Y")){
				String psaAuto = "N";
				if ( "Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getQtyModifyFlag())){
					psaAuto = "Y";
				} else {
					log.info("\n[[[ uploadXterRqst - searchBookingSplitNo ]]]");
					// Mty Pkup YD CD to retrieve the value when changing the PSA should be sending to the newly created.
					List<BkgBookingVO> bkgBookingVOs = util.searchBookingSplitNo(bkgBlNoVO.getBkgNo());
					if ( !bkgBookingVOs.get(0).getMtyPkupYdCd().equals(historyTableVO.getBkgBookingVO().getMtyPkupYdCd())){
						psaAuto = "Y";
					}
				}
				log.info("\n[[[ uploadXterRqst - managePSABKGAuto ]]]");
				// In case of PSA sending,If there are some error, send
				String errMsg = this.managePSABKGAuto(bkgNo, psaAuto);
				eventResponse.setETCData("psaValCode", errMsg);
			}
			
			/*
			if("SGSIN".equals(event.getEsmBkg022901Event().getBkgPolCd())){	
				String psaAuto = "N";
				if ( "Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getQtyModifyFlag())){
					psaAuto = "Y";
				} else {
					log.info("\n[[[ uploadXterRqst - searchBookingSplitNo ]]]");
					// Mty Pkup YD CD to retrieve the value when changing the PSA should be sending to the newly created.
					List<BkgBookingVO> bkgBookingVOs = util.searchBookingSplitNo(bkgBlNoVO.getBkgNo());
					if ( !bkgBookingVOs.get(0).getMtyPkupYdCd().equals(historyTableVO.getBkgBookingVO().getMtyPkupYdCd())){
						psaAuto = "Y";
					}
				}
				log.info("\n[[[ uploadXterRqst - managePSABKGAuto ]]]");
				// In case of PSA sending,If there are some error, send
				String errMsg = this.managePSABKGAuto(bkgNo, psaAuto);
				eventResponse.setETCData("psaValCode", errMsg);
			}
			*/
			log.info("\n[[[ uploadXterRqst - END ]]]");
		}catch(EventException ex){
			log.error("\n[[[ uploadXterRqst ]]] \n", ex);
			rollback();
			throw ex;
		}catch(Exception ex){
			log.error("\n[[[ uploadXterRqst ]]] \n", ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0228 : BKG NO SAVE click
	 * changing Booking No of EBookingReceipt<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse bkgNoXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			EsmBkg0228Event event = (EsmBkg0228Event)e;
			command.changeXterRqstBkgNo(event.getXterRqstNoVOs());

			for ( int i=0; i<event.getXterRqstNoVOs().length; i++ ) {
				if ( event.getXterRqstNoVOs()[i].getIbflag().equals("U")){

					PerformanceReportBC command2 = new PerformanceReportBCImpl();
					DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
					dpcsWebBookingVO.setXterSndrId(event.getXterRqstNoVOs()[i].getSenderId());
					dpcsWebBookingVO.setXterRqstNo(event.getXterRqstNoVOs()[i].getRqstNo());
					dpcsWebBookingVO.setXterRqstSeq(event.getXterRqstNoVOs()[i].getRqstSeq());
					dpcsWebBookingVO.setXterRqstChgFlg("Y");
					command2.addBkgSrRequest(dpcsWebBookingVO);
				}
			}
				
			eventResponse.setETCData("SuccessYn", "Y");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}

	/**
	 * Container Confirm Cancel
	 * 
     * @param String bkgNo
	 * @param String blNo
     * @exception Exception
	 */
	private void cancelContainerConfirm(String bkgNo, String blNo) throws Exception {
		String uiId = "ESM_BKG_0229_03";
		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(bkgNo);
		bkgBlNoIN.setBlNo(blNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

//			HistoryTableVO historyTableVO = null;
		//BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
//			boolean usaCstmsDownload = false;

		BookingUtil utilCmd = new BookingUtil();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();

log.debug("+++++++++++++++++++=================>"+bkgNo);
		/* searchBkgBlNoVO */
		BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
		if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
			throw new EventException(new ErrorHandler("BKG01049", new String[]{bkgNo}).getMessage());
		}
		log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

		/* Validate Container */
//			docCmd.validateContainer(cntrEtcInfoVO, containerVOs, fnlCfmFlg);

		/* Search Booking History */
//            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
					
		/* Container */	
		docCmd.modifyCntrCfmFlg(bkgBlNoVO.getBkgNo(), "N", bkgBlNoVO.getCaFlg());

		log.debug("########## Manage Doc Process ##########");
		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
		docProcSkdVO.setBkgDocProcTpCd("CNTRLS");
		docProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
		histCmd.manageDocProcess(docProcSkdVO, account);    
		
		// HistoryLine
		log.debug("########## History Line ##########");

		HistoryLineVO historyLineVO = new HistoryLineVO();
//			historyLineVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
		historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
		historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
		historyLineVO.setCrntCtnt(account.getUsr_id() + "/" + "Cancel Container Final Confirm");
		historyLineVO.setPreCtnt(" ");
		historyLineVO.setHisCateNm("F.CFM");
		historyLineVO.setLocalTime("");
		historyLineVO.setUiId(uiId);
		histCmd.createBkgHistoryLine(historyLineVO, account);
		            
		/* Manage Booking History */
//            histCmd.manageBookingHistory(uiId, historyTableVO, account);
		
		/* Set Message */
//            eventResponse.setETCData("USA_CSTMS_DOWNLOAD", String.valueOf(usaCstmsDownload));
	}

	/**
	 * ESM_BKG_0228 : in case of opening DETIAL ,Validation in 0228
	 * EBookingReceipt의 Seanaccs Validation Information retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterRqstValidation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		XterRqstValidationVO xterRqstValidationVO = null;
		
		try {
			EsmBkg0228Event event = (EsmBkg0228Event)e;

			EBookingReceiptBC command = new EBookingReceiptBCImpl();

			ExternalRqstListInputVO externalRqstListInputVO = event.getXterRqstListInputVO();

			xterRqstValidationVO = command.searchXterRqstValidation(externalRqstListInputVO);

			if("Y".equals(xterRqstValidationVO.getXterCreFlag())){
				eventResponse.setETCData("xterCreFlag", "Y");
			} else {
				eventResponse.setETCData("xterCreFlag", "N");
			}
			if("Y".equals(xterRqstValidationVO.getXterSrFlag())){
				eventResponse.setETCData("xterSrFlag", "Y");
			} else {
				eventResponse.setETCData("xterSrFlag", "N");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0228 : Upload 클릭
	 * BOOKING S/I KIND에 따른 VALUE 자동 세팅.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadDummyXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg0228Event event = (EsmBkg0228Event)e;
		
		try{
			ModifySiValAutoVO modifySiValAutoVO = event.getModifySiValAutoVO();
			begin();
			BlIssInfoVO blIssInfoVO = new BlIssInfoVO();
			blIssInfoVO.setBkgNo(modifySiValAutoVO.getBkgNo());
			blIssInfoVO.setUpdUsrId(account.getUsr_id());
			
			command.modifyBlIssByBkgNo(blIssInfoVO);
			
			XterRqstNoVO xterRqstNoVO = new XterRqstNoVO();
			xterRqstNoVO.setBkgNo(modifySiValAutoVO.getBkgNo());
			xterRqstNoVO.setSenderId(modifySiValAutoVO.getXterSndrId());
			xterRqstNoVO.setRqstNo(modifySiValAutoVO.getXterRqstNo());
			xterRqstNoVO.setRqstSeq(modifySiValAutoVO.getXterRqstSeq());
			EBookingReceiptBC command2 = new EBookingReceiptBCImpl();
			command2.completeUpload(xterRqstNoVO, account); 
			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.toString(),ex); 
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0229_01 <br>  
	 * ESM_BKG_0229_02<br>
	 * Black Customer check<br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkIranBlackCustomer(Event e) throws EventException{
		try{

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil util = new BookingUtil();
			ArrayList <String> custNms = new ArrayList<String>();
			
			// ESM_BKG_0229_01
			if(e.getEventName().equalsIgnoreCase("EsmBkg022901Event")){
				EsmBkg022901Event event = (EsmBkg022901Event)e;
				BlCustomerInfoVO blCustomerInfoVO = event.getBlCustomerInfoVO();
				custNms.add(blCustomerInfoVO.getSCustNm());
				custNms.add(blCustomerInfoVO.getFCustNm());
				
			// ESM_BKG_0229_02
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg022902Event")){
				EsmBkg022902Event event = (EsmBkg022902Event)e;
				BlDocCustVO blDocCustVO = event.getBlDocCustVO();
				custNms.add(blDocCustVO.getShCustNm());
				custNms.add(blDocCustVO.getCnCustNm());
				custNms.add(blDocCustVO.getNfCustNm());
				custNms.add(blDocCustVO.getFfCustNm());
				custNms.add(blDocCustVO.getAnCustNm());
				custNms.add(blDocCustVO.getExCustNm());
			}

			int blackCustFlagCnt = 0; 
			String blackCustFlag = "";
			String blackCustList = "";
			StringBuffer blackCustListBuf = new StringBuffer();
			
			for(int i=0; i<custNms.size(); i++){
				
				String custNm = (String)custNms.get(i);
				if(custNm != null && !"".equals(custNm)){
					
					blackCustFlag = util.checkIranBlackCustomer(custNm);
					
					if("Y".equals(blackCustFlag)){
						blackCustListBuf.append(custNm);
						blackCustListBuf.append(", ");
						
						blackCustFlagCnt++;
					}
				}
			} // end for
			
			blackCustList = blackCustListBuf.toString();
			if(blackCustList.lastIndexOf(",") > -1){
				blackCustList = blackCustList.substring(0, blackCustList.lastIndexOf(","));
			}

			if(blackCustFlagCnt > 0){
				blackCustFlag = "Y";
			}
			
			eventResponse.setETCData("black_cust_flag",   blackCustFlag);
			eventResponse.setETCData("black_cust_list", blackCustList);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}	

	/**
	 * getCntrEdiFlatFile : EDI sending Flat File from Exel
	 * 
	 * @param Sheet sheet
	 * @param int x
	 * @param int y
	 * @param boolean isFirst
	 * @return String
	 */
	private String getCntrEdiFlatFile(Sheet sheet, int x, int y, boolean isFirst) throws Exception {
		return this.getCntrEdiFlatFile(sheet, x, y, isFirst, 0);
	}

	/**
	 * getCntrEdiFlatFile : EDI sending Flat File from Exel
	 * 
	 * @param Sheet sheet
	 * @param int x
	 * @param int y
	 * @param boolean isFirst  
	 * @param int icmdSeq
	 * @return String
	 */
	private String getCntrEdiFlatFile(Sheet sheet, int x, int y, boolean isFirst, int icmdSeq) throws Exception {
		final String[] arrName = {
			"EDI_MAIN",			//0
			"{I_BKG_CNTR",		//1
			"CNTR_NO:",			//2
			"IBCNTR_SEAL_NO:",	//3
			"IBCNTR_SEAL_NO2:",	//4
			"IBCNTR_SEAL_NO3:",	//5
			"IBCNTR_PKG_QTY:",	//6
			"IBCNTR_PKG_CD:",	//7
			"IBCNTR_WGT_QTY:",	//8
			"IBCNTR_WGT_TP:",	//9
			"IBCNTR_MEA_QTY:",	//10
			"IBCNTR_MEA_TP:",	//11
			"}I_BKG_CNTR",		//12
			"HBL",				//13
			"{I_CM_MARK_DESC",	//14
			"ICMD_SEQ:",		//15
			"ICMD_PKG_QTY:",	//16
			"ICMD_PKG_CD:",		//17
			"ICMD_WGT_QTY:",	//18
			"ICMD_WGT_TP:",		//19
			"ICMD_MEA_QTY:",	//20
			"ICMD_MEA_TP:",		//21
			"}I_CM_MARK_DESC"	//22
		};
		BookingUtil util = null;
		MdmPckTpVO pckVO = null;
		StringBuilder sb = null;
		String lineSeparator = null;
		int add = 0;
		try {
			util = new BookingUtil();
			sb = new StringBuilder();
			lineSeparator = System.getProperty("line.separator");
			if (arrName[0].equalsIgnoreCase(sheet.getSheetName())) {
				add = isFirst ? 3 : 4;
				if (!"".equals(sheet.getRow(4+x).getCell(add+y).getStringCellValue())) {
					pckVO = util.searchPkgTypeByName(sheet.getRow(4+x).getCell(add+y).getStringCellValue().toUpperCase());
				}
				sb.append(arrName[1]).append(lineSeparator);
				sb.append(arrName[2]).append(sheet.getRow(x).getCell(y).getStringCellValue()).append(lineSeparator);
				sb.append(arrName[3]).append(sheet.getRow(1+x).getCell(y).getStringCellValue()).append(lineSeparator);
				sb.append(arrName[4]).append(sheet.getRow(2+x).getCell(y).getStringCellValue()).append(lineSeparator);
				sb.append(arrName[5]).append(sheet.getRow(3+x).getCell(y).getStringCellValue()).append(lineSeparator);
				sb.append(arrName[6]).append(sheet.getRow(4+x).getCell(y).getStringCellValue().replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[7]).append(null!=pckVO ? pckVO.getPckCd():"").append(lineSeparator);
				sb.append(arrName[8]).append(sheet.getRow(5+x).getCell(y).getStringCellValue().replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[9]).append(sheet.getRow(5+x).getCell(add+y).getStringCellValue().toUpperCase()).append(lineSeparator);
				sb.append(arrName[10]).append(sheet.getRow(6+x).getCell(y).getStringCellValue().replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[11]).append(sheet.getRow(6+x).getCell(add+y).getStringCellValue().toUpperCase()).append(lineSeparator);
				sb.append(arrName[12]).append(lineSeparator);
			} else if (arrName[13].equalsIgnoreCase(sheet.getSheetName())) {
				if (!"".equals(sheet.getRow(4+x).getCell(1+y).getStringCellValue())) {
					pckVO = util.searchPkgTypeByName(sheet.getRow(4+x).getCell(1+y).getStringCellValue().toUpperCase());
				}
				sb.append(arrName[14]).append(lineSeparator);
				sb.append(arrName[2]).append(sheet.getRow(x).getCell(y).getStringCellValue()).append(lineSeparator);
				sb.append(arrName[15]).append(icmdSeq).append(lineSeparator);
				sb.append(arrName[16]).append(sheet.getRow(4+x).getCell(y).getStringCellValue().replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[17]).append(null!=pckVO ? pckVO.getPckCd():"").append(lineSeparator);
				sb.append(arrName[18]).append(sheet.getRow(5+x).getCell(y).getStringCellValue().replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[19]).append(sheet.getRow(5+x).getCell(1+y).getStringCellValue().toUpperCase()).append(lineSeparator);
				sb.append(arrName[20]).append(sheet.getRow(6+x).getCell(y).getStringCellValue().replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[21]).append(sheet.getRow(6+x).getCell(1+y).getStringCellValue().toUpperCase()).append(lineSeparator);
				sb.append(arrName[22]).append(lineSeparator);
			}
		} catch(Exception e) {
			throw e;
		}
		return sb.toString();
	}

	/**
	 * findCellsByName : Finding CellObject by name in Exel
	 * 
	 * @param Workbook wb
	 * @param String name
	 * @return List<Cell>
	 * @throws Exception
	 */
	private List<Cell> findCellsByName(Workbook wb,String name) throws Exception {
		Name oname = null;
		List<Cell> cells = null;
		CellReference[] crs = null;
		try {
			oname = wb.getName(name);
			if (null!=oname && !oname.isDeleted()) {
				crs = (new AreaReference(oname.getRefersToFormula())).getAllReferencedCells();
				if (null!=crs && 0<crs.length) {
					cells = new ArrayList<Cell>(crs.length);
					for (CellReference cr : crs) {
						cells.add(wb.getSheet(cr.getSheetName()).getRow(cr.getRow()).getCell(cr.getCol()));
					}
				}
			}
		} catch (FormulaParseException fpe) {
			throw new Exception(fpe);
		} catch (Exception e) {
			throw e;
		}
		return cells;
	}

	
	/**
	 * Auto PSA EDI sending
	 * Decide Rail Receiving Date
	 *  
	 * @author		
	 * @param 		String bkgNo
	 * @param 		String qtyModifyFlag
	 * @return		String
	 */
	private String managePSABKGAuto(String bkgNo, String qtyModifyFlag) {
		String returnVal = "";
		try{
			begin();
		
			//BookingHistoryMgtBC createBkgHistoryLine calling	
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			
			PSAManifestBC psaBC = new PSAManifestBCImpl();
			PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
			psaBkgVOs[0] = new PsaBkgVO();
			psaBkgVOs[0].setBkgNo(bkgNo);
			psaBkgVOs[0].setSndUsrId(account.getUsr_id());
			psaBkgVOs[0].setQtyModifyFlag(qtyModifyFlag);
			
			psaBC.managePSABKG(psaBkgVOs);

			bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(bkgNo);
			bkgNtcHisVO.setNtcViaCd("E");
			bkgNtcHisVO.setNtcKndCd("PS");
			bkgNtcHisVO.setEdiId("PSACBI");
			bkgNtcHisVO.setEsvcGrpCd("");
			bkgNtcHisVO.setBkgNtcSndRsltCd("A");
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
			bkgNtcHisVOs.add(bkgNtcHisVO);
			
			if(bkgNtcHisVOs!=null){
				if(bkgNtcHisVOs.size()>0){
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079");
				}
			}
			commit();
			returnVal = "Y";
		} catch(Exception ex){
			rollback();
			returnVal = ex.getMessage();
			log.error("err " + returnVal);
			//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return  returnVal;
	}	
		


	
	
	/**
	 * ESM_BKG_1801 : RETREVE click
	 *Pegasus XML Monitoring LIST retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgXterRcvMsgList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// PDTO(Data Transfer Object including Parameters)
			EsmBkg1801Event event = (EsmBkg1801Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();

			List<BkgXterRevMsgVO> list = command.searchBkgXterRcvMsgList(event.getRcvFromDt(), event.getRcvToDt(), event.getUpldCd(), event.getRqstNo(), event.getMsgSeq(), event.getMsgDesc());

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_BKG_1802 : RETREVE click
	 *Pegasus XML View retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgXterRcvMsgView(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// PDTO(Data Transfer Object including Parameters)
			EsmBkg1802Event event = (EsmBkg1802Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			BkgXterRevMsgVO rcvMsgVO =  new BkgXterRevMsgVO();
			rcvMsgVO.setXterSndrId(event.getSndrId());
			rcvMsgVO.setXterRqstNo(event.getRqstNo());
			rcvMsgVO.setXterRqstSeq(event.getRqstSeq());
			rcvMsgVO.setBkgXterRcvMsgSeq(event.getMsgSeq());
			
			BkgXterRevMsgVO bkgXterRevMsgVO = command.searchBkgXterRcvMsgView(rcvMsgVO);

			eventResponse.setRsVo(bkgXterRevMsgVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0235 : RETREVE click
	 * OPUS Container Office Setup retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRerouteOfcCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// PDTO(Data Transfer Object including Parameters)
			EsmBkg0235Event event = (EsmBkg0235Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			RerouteOfcVO ofcVO =  new RerouteOfcVO();
			ofcVO.setHndlOfcCd(event.getOfcCd());
			ofcVO.setOfcEngNm(event.getOfcNm());
			
			List<RerouteOfcVO> list = command.searchRerouteOfcCd(ofcVO, account.getUsr_id());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0228 : Reroute
	 * changing Route of EBookingReceipt<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendRerouteRqstNotice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			EsmBkg0228Event event = (EsmBkg0228Event)e;

			for ( int i=0; i<event.getXterRqstNoVOs().length; i++ ) {
				if ( "U".equals(event.getXterRqstNoVOs()[i].getIbflag()) && event.getXterRqstNoVOs()[i].getNewEmail() != null){
					event.getXterRqstNoVOs()[i].setDocTpCd(event.getXterRqstNoVOs()[i].getDocTp());
					event.getXterRqstNoVOs()[i].setUserId(account.getUsr_id());
					command.sendRerouteRqstNotice(event.getXterRqstNoVOs()[i]);
					command.changeRerouteRqstOfcCd(event.getXterRqstNoVOs()[i], account.getUsr_id());
				}
			}
			eventResponse.setETCData("SuccessYn", "Y");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0228 : RETREVE click
	 * OPUS Container Office Setup retrieve<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRerouteUserId(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String authYn = "N";
		try {
			// PDTO(Data Transfer Object including Parameters)
			//EsmBkg0228Event event = (EsmBkg0228Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			
			List<RerouteUserIdVO> list = command.searchRerouteUserId();
			
			for (int i=0; i < list.size(); i++) {
				if (account.getUsr_id().equals(list.get(i).getUserId())) authYn = "Y";
			}
			
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("authYn", authYn);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * 
	 * @param rqstNoVo
	 * @return
	 */
	private XterRqstNoVO genXterRqstNoVO(XterRqstNoVO rqstNoVo, String flatFileStr){
		VermasMapping vermas = new VermasMapping();
		if(rqstNoVo.getSenderId().equals("VERMAS")){
			LinkedHashMap<String, String> header = vermas.createNodePath("I_VERMAS", vermas.getNodeData("I_VERMAS", flatFileStr));
			rqstNoVo.setRqstNo(header.get("I_VERMAS/MSG_REF_NO"));
		}else{
			LinkedHashMap<String, String> header = vermas.createNodePath("I_BOOKING", vermas.getNodeData("I_BOOKING", flatFileStr));
			rqstNoVo.setRqstNo(header.get("I_BOOKING/IB_NO"));
		}
		return rqstNoVo;
	}
}

/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OutboundBLMgtSC.java
 *@FileTitle : Container Information
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import weblogic.wsee.util.StringUtil;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SearchDgCancelInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodMailSendVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007904Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007906Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007907Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0170Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0178Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0360Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg036101Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0366Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0391Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0399Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0648Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0707Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0892Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0901Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1050Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1051Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration.BLDocumentationBLDBDAO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrShpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmByCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCntrInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCopyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmGoodsDescVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmDescInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrPkgWgtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrTpszQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.DGCargoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblForMndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblTmpltVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.NvoccFileNoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.RataBkgQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0059Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg007909Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0179Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0218Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0221Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0278Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0400Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0418Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0649Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0726Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0927Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1071Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1074Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1096Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkgWeb0040001Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AgentEmlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AuthCustVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssueVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlPrintRcvFtpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlStatusVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblCntVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MultiNtcHisVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SrndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic.EmptyReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic.EmptyReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event.EsmBkg0236Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event.EsmBkg0252Event;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogDtlVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.BkgLodFctrDlLogHdrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.FtpInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelBKgVvdVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelBkgQtyVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelBkgRootVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelCMVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelCntrVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelDGVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdExcelRFVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBC;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic.ReceiveOwnBkgCancelRequestMgtBC;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic.ReceiveOwnBkgCancelRequestMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.ScgVvdDgCgoCxlRqstVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.javamail.Mail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.CompressUtil;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.upload.Uploader;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.net.ftp.FtpManager;
import com.clt.syscommon.common.table.BkgCntcPsonVO;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgDgCgoVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgNvoccProfCntrMfVO;
import com.clt.syscommon.common.table.BkgNvoccProfVO;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmPckTpVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.utilitybox.container.BeanContainer;
import com.clt.utilitybox.utility.CheckUtilities;

/**
 * OPUS-OutboundBLMgt Business Logic ServiceCommand - OPUS-OutboundBLMgt handling business transaction.
 * 
 * @author
 * @see BLDocumentationBLDBDAO
 * @since J2EE 1.4
 */

public class OutboundBLMgtSC extends ServiceCommandSupport {

	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OutboundBLMgt system preceding process for biz scenario<br>
	 * UI_BKG-0079-04 related objects creation<br>
	 */
	public void doStart() {
		log.debug("OutboundBLMgtSC Start..");
		try {
			// Logon check
			account = getSignOnUserAccount();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * OutboundBLMgt system biz scenario closing<br>
	 * UI_BKG-0079-04 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("OutboundBLMgtSC End..");
	}

	/**
	 * @author
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		log.debug("::CALL:: OutboundBLMgtSC =====> " + e.getEventName());

		/* ESM_BKG_0079_09Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg007909Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchBlIssInfoDefault(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlIssInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlIssInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageBlIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitFTP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = checkToyotaBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)){
				eventResponse = checkOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)){
				eventResponse = checkBlPrintRcvFtp(e);
			}
		} else
		/* ESM_BKG_0649Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0649Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlReIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlReIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmBlReIssue(e);
			}
		} else
		/* ESM_BKG_0400Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0400Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurrenderInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySurrenderInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeSurrenderInfo(e);
			}
		} else
			/* EsmBkg1074Event */
			if (e.getEventName().equalsIgnoreCase("EsmBkg1074Event")) {
					if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
						eventResponse = searchCustInfo(e);
					} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
						eventResponse = manageBlIssue(e);
					} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
						eventResponse = sendAuthEmail(e);
					} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
						eventResponse = searchEmlTemplate(e);
					}
		} else
		/* ESM_BKG_0059Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDocRqst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyDocRqst(e);
			}
		} else
		/* EsmBkg0079Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0079Event")) {
			eventResponse = new GeneralEventResponse();
		} else
		/* EsmBkg007904Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg007904Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntrDtlInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchPartialConfirm(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchDamageMstContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = cancelContainerConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyCrdDt(e);
			}
		} else
		/* EsmBkg007906Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg007906Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUserTmpltList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPckTp(e);
			}
		} else
		/* EsmBkg007907Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg007907Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchPckTpForCM(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = validateHsCd(e);
			}
		} else
		/* EsmBkg0170Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = new GeneralEventResponse();
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = moveContainer(e);
			}
		} else
		/* EsmBkg0178Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0178Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmByCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCmByCntr(e);
			}
		} else
		/* EsmBkg0252Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0252Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = new GeneralEventResponse();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRlseOrdForSimple(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyRlseOrdForDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMtyRlseOrdForUsa(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = sendMtyRlseOrdByFax(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendMtyRlseOrdByEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = sendMtyRlseOrdByEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMtyRlseOrdForExcelDownload(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMtyRlseOrdForExcelDownloadBatch(e);
			}
		} else
		/* EsmBkg0278Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0278Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCommonCdListVO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListForGrpBlPr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendGroupBLEmail(e);
			}
		} else
		/* EsmBkg0360Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0360Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHblForMnd(e);
			}
		} else
		/* EsmBkg036101Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg036101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = new GeneralEventResponse();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExportImportNumber(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExportImportNumber(e);
			/* WebService EAI [WEB_006_0001] */
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageExportImportNumber(e);
			}
		} else
		/* EsmBkg0366Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0366Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHbl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHbl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = asgnMfNo(e);
			}
		} else
		/* EsmBkg0399Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0399Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHblTmplt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHblTmplt(e);
			}
		} else
		/* EsmBkg0697Event */
		//if (e.getEventName().equalsIgnoreCase("EsmBkg0697Event")) {
			// if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			// eventResponse = searchBkgListForGrpBlPr(e);
			// }
		//} else
		/* EsmBkg0707Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0707Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGoodsDescByCm(e);
			}
		} else
		/* EsmBkg0726Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0726Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlListForGroupUpdate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyGroupBlUpdate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupBlUpdateBackEndJobStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupBlUpdateBackEndJobResult(e);
			}
		} else
		/* UiBkg0892Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0892Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrListByVvd(e);
			}
		} else
		/* EsmBkg0901Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0901Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNotUpdCntr(e);
			}
		} else
			/* EsmBkg0958Event */
			//if (e.getEventName().equalsIgnoreCase("EsmBkg0958Event")) {
				// if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				// eventResponse = searchNotUpdCntr(e);
				// }
		//} else
		/* EsmBkg0648Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0648Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchForCopyBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyBl(e);
			}
		} else
		/* EsmBkg1051Event */
		if(e.getEventName().equalsIgnoreCase("EsmBkg1051Event")){
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchBkgCntrVol(e);
            }
		} else
		/* EsmBkg1050Event */
        if(e.getEventName().equalsIgnoreCase("EsmBkg1050Event")){
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCntrAdjVol(e);
            }
        } else
		/* EsmBkg0218Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0218Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchComCode0218(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBkgListForObDblWbl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBkgListForIbDblWbl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {  //outbound-fax
				eventResponse = sendDblWblByFax(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {  //outbound-email
				eventResponse = sendDblWblByEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {  //outbound-groupemail
				eventResponse = sendDblWblByGroupEmail(e);					 //2017.01.06
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {  //inbound-fax
				eventResponse = sendDblWblByFax(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {  //inbound-email
				eventResponse = sendDblWblByEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI13)) {  //inbound-groupemail
				eventResponse = sendDblWblByGroupEmail(e);                   //2017.01.06
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {  //assign email
				eventResponse = searchBkgAgentEml(e);
			}
		} else
		/* EsmBkg1071Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1071Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultiNtcHis(e);
			}
		} else
		/* EsmBkg0927Event */
			if (e.getEventName().equalsIgnoreCase("EsmBkg0927Event")) {
				if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchUserDefaultSetting(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchBlInfoForPreview(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					// Email
					eventResponse = sendDblWblByEmail(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					// Fax
					eventResponse = sendDblWblByFax(e);
				}
		} else
		/* EsmBkg0418Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0418Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = validMfForPrtByBl(e);
			}
		} else
		/* EsmBkg0221Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0221Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchBkgInfoForFaxEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = sendFaxEmailByBkgNoList(e);
			}
		} else
		/* EsmBkg1096Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1096Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEmailEdit(e);
			}
		} else
		/* EsmBkg0179Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0179Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlClauseInfo(e);
			}
    	} else
		/* WebService EAI [WEB_004_0001] */
		if (e.getEventName().equalsIgnoreCase("EsmBkgWeb0040001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyWeb0040001ControlMgmt(e);				
			} 
		} else
		/* EsmBkg0236Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0236Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgLodFctrDlLogHdr(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBkgLodFctrDlLogDtl(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchMtyRlseOrdForFtpRetry(e);
			}
		/* EsmBkg0391Event */
		}else if( e.getEventName().equalsIgnoreCase("EsmBkg0391Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBookingContainerShipment(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyMultiShpCntrPrn(e);
			}
		}
    		
		
		return eventResponse;
	}
	
    /**
     * Retrieving BKG No and Vol using same Container in same VVD in case of adjust Partial Container Volume.(ESM_BKG_1050)<br>
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCntrAdjVol(Event e) throws EventException {
      
        EsmBkg1050Event event = (EsmBkg1050Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();

        log.debug("==========>" + event.getBkgNo());
        log.debug("==========>" + event.getCntrNo());

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        try {
            /* searchBkgBlNoVO */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            
            List<CntrAdjVolVO> cntrAdjVolVOs = docCmd.searchCntrAdjVol(event.getBkgNo(), event.getCntrNo());

            eventResponse.setRsVoList(cntrAdjVolVOs);

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
     * retrieve EQ Detail for compare EQ Detail and container Info. -- UI_BKG-1051 (BKG_QTY_DTL)(ESM_BKG_1051)<br>
     * 
     * @author 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBkgCntrVol(Event e) throws EventException {
        log.debug("[START:: OutboundBLMgtSC.searchBkgCntrVol]");
        EsmBkg1051Event event = (EsmBkg1051Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();

        String bkgNo = event.getBkgNo();
        log.debug("==========>" + bkgNo);

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(bkgNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        try {
            /* searchBkgBlNoVO */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{bkgNo}).getMessage());
            }
            
            List<RataBkgQtyVO> rageBkgQtyVOs = docCmd.searchBkgCntrVol(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());

            eventResponse.setRsVoList(rageBkgQtyVOs);

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
	 * B/L Issue Default retrieve event process.(ESM_BKG_0079_09)<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlIssInfoDefault(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil bookingUtil = new BookingUtil();
		UserSetupMgtBC userSetupMgtBC = new UserSetupMgtBCImpl();
		List<BkgInternetAuthorityVO> listAuthroity = null;

		try{
			// 01. on_board_type retrieve
			List<BkgComboVO> on_board_type  = bookingUtil.searchCombo("CD01645");
			eventResponse.setRsVoList(on_board_type);
			// 02. bl_ready_type retrieve
			List<BkgComboVO> bl_ready_type  = bookingUtil.searchCombo("CD01647");
			eventResponse.setRsVoList(bl_ready_type);
			// 03. bl_ready_type retrieve
			List<BkgComboVO> confirm  = bookingUtil.searchCombo("CD02393");
			eventResponse.setRsVoList(confirm);
			// 04. BL Move Type
			List<BkgComboVO> bl_move_type  = bookingUtil.searchCombo("CD30020");
			eventResponse.setRsVoList(bl_move_type);
			// 05. BL Issue Type
			List<BkgComboVO> bl_issuebl_type  = bookingUtil.searchCombo("CD01556");
			eventResponse.setRsVoList(bl_issuebl_type);
			// 06. BKG_INET_AUTH inet_ftp_auth_flg
			BkgInternetAuthorityVO bkgInternetAuthorityVO = new BkgInternetAuthorityVO();
			bkgInternetAuthorityVO.setUsrId(account.getUsr_id());
			bkgInternetAuthorityVO.setIbflag("R");
			listAuthroity = userSetupMgtBC.searchUserInternetAuth(bkgInternetAuthorityVO);
			if(listAuthroity != null && listAuthroity.size()>0){
				eventResponse.setETCData("INET_FTP_AUTH_FLG", listAuthroity.get(0).getInetFtpAuthFlg());
			}else{
				eventResponse.setETCData("INET_FTP_AUTH_FLG", "");
			}
			
		}catch(EventException ex){
			log.debug("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.debug("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;	
	}
    /**
	 * EsmBkg007909Event retrieve event process.(ESM_BKG_0079_09)<br>
	 * retrieving B/L Issue information<br>
	 * fill out needs(B/L type, Freight pay Y/N etc) before B/L publication.<br>
	 * 
	 * @author 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlIssInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg007909Event event = (EsmBkg007909Event) e;
		String bkg_no 	= event.getBkg_no();
		String bl_no 	= event.getBl_no();

		try {
			
			log.debug("[add condition] ========== searchBkgCgoTp [START] ==========> ");
			// get bkg_no by bl_no in case of not existing bkg_no
			BookingUtil bookingUtil = new BookingUtil();
        	if(!"".equals(bl_no) && bl_no.length()>=12){
        		bl_no = bl_no.substring(0,12);
			}else if (!"".equals(bl_no) && bl_no.length() >= 10){
				bl_no = bl_no.substring(0,10);
			}
			if(bkg_no.length() == 0 && !bl_no.equals("") ){
				if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
				bkg_no = bookingUtil.searchBkgNoByBlNo(bl_no);	
			}
        	
			// checking whether bkg_no exists or not
			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
			bkgBlNo.setBkgNo(bkg_no);
			bkgBlNo.setBlNo(bl_no);	
			bkgBlNo.setCaUsrId(account.getUsr_id());
			
			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				//throw new Exception(new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
//				throw new EventException(new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
	        	eventResponse.setETCData("corr_flg", "");
	            eventResponse.setETCData("ca_exist_flg", "");
				eventResponse.setETCData("caflag"    	, "");
	            eventResponse.setETCData("bdrflag"    	, "");
	            eventResponse.setETCData("vesselVoyageDirectionEqual", "");
	            eventResponse.setETCData("docReqButton", "");
	            eventResponse.setETCData("tpbStatus"    , "");
	            eventResponse.setETCData("blNoReady"    , "");
				eventResponse.setRsVoList(null);
				eventResponse.setRsVoList(null);
				eventResponse.setRsVoList(null);
				eventResponse.setRsVo(null);
				
				return eventResponse;
			}
			// return bkg_no in case of bkg_no = 'P'
        	String bkgStsCd = bookingUtil.searchBkgCgoTp(bkgBlNoVO);
        	if (bkgStsCd.equals("P")) {
//        		throw new EventException(new ErrorHandler("BKG40030").getMessage());
        		eventResponse.setUserMessage(new ErrorHandler("BKG40030").getUserMessage());
	        	eventResponse.setETCData("corr_flg", "");
	            eventResponse.setETCData("ca_exist_flg", "");
				eventResponse.setETCData("caflag"    	, "");
	            eventResponse.setETCData("bdrflag"    	, "");
	            eventResponse.setETCData("vesselVoyageDirectionEqual", "");
	            eventResponse.setETCData("docReqButton", "");
	            eventResponse.setETCData("tpbStatus"    , "");
	            eventResponse.setETCData("blNoReady"    , "");
				eventResponse.setRsVoList(null);
				eventResponse.setRsVoList(null);
				eventResponse.setRsVoList(null);
				eventResponse.setRsVo(null);
				return eventResponse;
        	}
        	
			log.debug(" ========== searchBkgCgoTp [END] ==========> ");
			bl_no=bkgBlNoVO.getBlNo();
			BlIssueVO blIssueVO = new BlIssueVO();
			blIssueVO.setAccount(account);
			blIssueVO.setBkg_no(bkg_no);
			blIssueVO.setBl_no(bl_no);

			// 1. retrieve OFT Note
			BlIssueVO rBlIssueVO = command.searchBlIssInfo(blIssueVO);
			
			if(rBlIssueVO.getBlIssInfoList() != null){
				// 2. retrieve tpbStatus
				StatusInquiryBCImpl tpbIF = new StatusInquiryBCImpl(); //declaration TPB BC
				SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
	            searchTpbStatusByBkgNoVO.setSbkgno(bkg_no);
	            String tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
				
				List<DocRqstVO> docRqstList = command.searchDocRqst(bkg_no, "");
				String docReqButton ="N";
				String docRqstTtl   ="0";
		
				if(docRqstList.size()>0){
				
					DocRqstVO dvo = docRqstList.get(0);
			
					int vOblTtlKnt = (dvo.getOblTtlKnt().trim().length() == 0 ? 0 : Integer.parseInt(dvo.getOblTtlKnt()));
					int vCpyTtlKnt = (dvo.getCpyTtlKnt().trim().length() == 0 ? 0 : Integer.parseInt(dvo.getCpyTtlKnt()));
					int totCount = vOblTtlKnt + vCpyTtlKnt;
					docRqstTtl = ""+totCount;
				    if(!"".equals(docRqstList.get(0).getRqstBlTpCd())){
				    	totCount += 1;
				    }
					totCount = totCount 
								+dvo.getRqstIssDt().trim().length() 
								+dvo.getRqstIssPlcNm().trim().length()
								+dvo.getBlDeMzdCd().trim().length()
								+dvo.getBlDeToCd().trim().length()
								+dvo.getBlDocRqstRmk().trim().length();
					if(totCount>0){ 
						docReqButton ="Y";
					}
				}
	        	eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
	            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
				// Caflag
				eventResponse.setETCData("caflag"    	, bkgBlNoVO.getCaFlg());
				// Bdrflag
	            eventResponse.setETCData("bdrflag"    	, bookingUtil.searchBdrFlgByBkg(bkgBlNoVO));
	            
				String vesselVoyageDirectionEqual = bookingUtil.vesselVoyageDirectionEqual(bkg_no);
				//docReqButton
		         eventResponse.setETCData("vesselVoyageDirectionEqual", vesselVoyageDirectionEqual);
				//docReqButton
		         eventResponse.setETCData("docReqButton", docReqButton);
	            // tpbStatus
	            eventResponse.setETCData("tpbStatus"    , tpbStatus);
	            //bl_not_ready
	            eventResponse.setETCData("blNoReady"    , rBlIssueVO.getBl_not_ready());
	            
	            eventResponse.setETCData("docRqstTtl", docRqstTtl);
				// biissinfo
				eventResponse.setRsVoList(rBlIssueVO.getBlIssInfoList());
				// precarriage
				eventResponse.setRsVoList(rBlIssueVO.getPreCarriageList());
				// vesselvoyage
				eventResponse.setRsVoList(rBlIssueVO.getVesselVoyagedList());
				//otsRcvInfoVO
				eventResponse.setRsVo(rBlIssueVO.getOtsRcvInfoVO());
			}else{
				// No data found.
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
	        	eventResponse.setETCData("corr_flg", "");
	            eventResponse.setETCData("ca_exist_flg", "");
				eventResponse.setETCData("caflag"    	, "");
	            eventResponse.setETCData("bdrflag"    	, "");
	            eventResponse.setETCData("vesselVoyageDirectionEqual", "");
	            eventResponse.setETCData("docReqButton", "");
	            eventResponse.setETCData("tpbStatus"    , "");
	            eventResponse.setETCData("blNoReady"    , "");
	            eventResponse.setETCData("docRqstTtl", "0");
				eventResponse.setRsVoList(null);
				eventResponse.setRsVoList(null);
				eventResponse.setRsVoList(null);
				eventResponse.setRsVo(null);
			}
			
			
			
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkg007909Event save event process.(ESM_BKG_0079_09)<br>
	 * B/L Issue Info manage.<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlIssInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg007909Event event = (EsmBkg007909Event) e;
		String uiId = "ESM_BKG_0079_09";
		String bkg_no = event.getBkg_no();
		String bl_no = event.getBl_no();
		BlIssInfoVO[] blIssInfoVOs = event.getBlIssInfoVOs();
		
		BlIssueVO blIssueVO = new BlIssueVO();
		blIssueVO.setAccount(account);
		blIssueVO.setBkg_no(bkg_no);
		blIssueVO.setBl_no(bl_no);
		
		BlIssInfoVO blIssInfoVO = blIssInfoVOs[0];
		blIssInfoVO.setUpdUsrId(account.getUsr_id());
		blIssueVO.setBlIssInfoVO(blIssInfoVO);
		
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		
		try {
			/*
			BookingUtil utilCmd = new BookingUtil();
        	String existThird  = utilCmd.existThirdCode(blIssInfoVO.getPpdRcvUserOffice());
        	if(existThird.equals("N")){
        		 throw new EventException(new ErrorHandler("BKG00905").getMessage());//Third Office is not available
        	}
			*/
			
			// 1.[] IBookingHistoryMgtBC::manageBkgHistory ( historyTableVO , uiId )
			/* Manage Booking History */

			//I BookingHistoryMgtBC::searchOldBkgForHistory ( uiId , bkgBlNoVo )
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			BookingUtil utilCmd = new BookingUtil();
			
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkg_no);
//			bkgBlNoVO.setBlNo(bl_no);	
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			
			
			
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			// 2.[] IBLIssuanceBC::manageBlIssInfo ( blIssueVO )
			// [] BLIssuanceDBDAO::manageBlIssInfo ( blIssueVO )
			command.manageBlIssInfo(blIssInfoVO);
			// 2-1. ca_no ='TMP0000001' , BKG_BL_ISS_HIS update
			String caNo = bkgBlNoVO.getCaNo();
			if("TMP0000001".equals(caNo)){
				command.manageBlIssInfoHistory(blIssInfoVO);
			}
			
			// 3. [] IGeneralBookingReceiptBC::modifyBlType ( bkgNo , blTpCd )
			// [] GeneralBookingReceiptDBDAO::modifyBlType ( bkgNo , blTpCd )
			GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
			String blIssTpCd = blIssInfoVO.getBlIssTpCd();
			generalBookingReceiptBC.modifyBlType(bkg_no,blIssTpCd);
			
			// 3-1. ca_no ='TMP0000001' , BKG_BKG_HIS update
			if("TMP0000001".equals(caNo)){
				generalBookingReceiptBC.modifyBlTypeHistory(bkg_no,blIssTpCd);
			}

			// 4. [] IBLDocumentationBLBC::modifyBlIssInfoForBlDoc ( blIssueVO )
			// [] BLDocumentationBLDBDAO::modifyBlIssInfoForBlDoc ( blIssueVO )
			BLDocumentationBLBC bLDocumentationBLBC= new BLDocumentationBLBCImpl();
			bLDocumentationBLBC.modifyBlIssInfoForBlDoc(blIssInfoVO);  
			
			// 4-1. ca_no ='TMP0000001' , BKG_BL_DOC_HIS update
			if("TMP0000001".equals(caNo)){
				bLDocumentationBLBC.modifyBlIssInfoHistoryForBlDoc(blIssInfoVO);
			}
			// 5. before manageBookingHistoty... CA_FLG ='N', CA_NO =''
			bkgBlNoVO.setCaFlg("N");
			bkgBlNoVO.setCaNo("");
			historyTableVO.setBkgBlNoVO(bkgBlNoVO);
	  	  
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);

			//2014.11.21 MAEDA Add Send BL Complete Email
//			if (!(blIssInfoVO.getBlReadyBy().equals("")) && (!(blIssInfoVO.getBlReadyOffice().equals(""))) && (!(blIssInfoVO.getBlReadyDate().equals("000000"))) ){
			if 	(	 !(blIssInfoVO.getBlReadyBy().equals("")) 
				&& 	(!(blIssInfoVO.getBlReadyOffice().equals(""))) 
				&& 	(!(blIssInfoVO.getBlReadyDate().equals("000000"))) 
				&& 	(blIssInfoVO.getBlReadyCheckbox().equals("Y"))  ){
				command.sendBlCompleteEmail(bkg_no, account);
			}
			//2014.11.21 MAEDA Add End
			
			
			if 	(	 !(blIssInfoVO.getBlReadyBy().equals("")) 
					&& 	(!(blIssInfoVO.getBlReadyOffice().equals(""))) 
					&& 	(!(blIssInfoVO.getBlReadyDate().equals("000000"))) 
					&& 	(blIssInfoVO.getBlReadyCheckbox().equals("Y"))  ){
				log.debug("===============================================================");
				log.debug("[start][======== [BLIssuanceBC] :: sendBlRDFtp ]");
				log.debug("===============================================================");

				begin();
				try{
					command.sendBlRDFtp(bkg_no, bkgBlNoVO, account, event.getFileDownPath(), "BLD");
				}catch(Exception ef){
					log.error("[exception:: BLIssuanceBC == sendBlRDFtp ]=========="+ef.getMessage());
				}
				commit();
				log.error("[end:: BLIssuanceBC == sendBlRDFtp ]==========");
			}

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EsmBkg007909Event save event process.(ESM_BKG_0079_09,ESM_BKG_1074)<br>
	 * B/L Issue Info manage.<br>
	 * Issue/Internet AUTH/SWB Release/Cancel AUTH<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlIssue(Event e) throws EventException {
		
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		BLIssuanceBC 			command 	= new BLIssuanceBCImpl();
		BLDocumentationBLBC 	blBC 		= new BLDocumentationBLBCImpl();
		EsmBkg007909Event event 			= (EsmBkg007909Event) e;
		String bkg_no 						= event.getBkg_no();
		String bl_no 						= event.getBl_no();
		String buttonType 					= event.getButtonType();
		String setupfocoblflag 				= event.getSetupfocoblflag();
		
    	if(!"".equals(bl_no) && bl_no.length()>=12){
    		bl_no = bl_no.substring(0,12);
		}else if (!"".equals(bl_no) && bl_no.length() >= 10){
			bl_no = bl_no.substring(0,10);
		}
		
		BlIssInfoVO[] blIssInfoVOs 			= event.getBlIssInfoVOs();
		BlIssueVO blIssueVO 				= new BlIssueVO();
		blIssueVO.setAccount(account);
		blIssueVO.setBkg_no(bkg_no);
		blIssueVO.setBl_no(bl_no);
		
		BlIssInfoVO blIssInfoVO 			= blIssInfoVOs[0];
		blIssInfoVO.setUpdUsrId(account.getUsr_id());
		blIssInfoVO.setUpdOffice(account.getOfc_cd());
		blIssueVO.setBlIssInfoVO(blIssInfoVO);
		String uiId = "ESM_BKG_0079_09";
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		BookingUtil utilCmd = new BookingUtil();

		try {

			//I BLIssuanceBC::validateBlIssue ( bkgNo , issueType )
			//[] BLIssuanceDBDAO::searchBlStatus ( bkgNo )
			BlStatusVO blStatusVO = command.validateBlIssue(bkg_no,"");

			
			if( 
				!( buttonType.equals("btn_t11CancelRelease"))
			){
				if(blStatusVO.getCntrReady() == null || blStatusVO.getCntrReady().equals("N")) {
					//Container Data is not Ready !
					throw new EventException(new ErrorHandler("BKG08193", new String[]{}).getMessage());
				}
				if(blStatusVO.getChgReady() == null || blStatusVO.getChgReady().equals("N")) {
					//Rate Data is not Ready !
					throw new EventException(new ErrorHandler("BKG08078", new String[]{}).getMessage());
				}
				if(blStatusVO.getMkReady() == null || blStatusVO.getMkReady().equals("N")) {
					//M&D data is not Ready
					throw new EventException(new ErrorHandler("BKG08077", new String[]{}).getMessage());
				}
			}			
			// need not check in case of click issue button
			// need not check in case of click btn_t11CancelRelease
			if( 
				!( buttonType.equals("btn_t11Issue")||buttonType.equals("btn_t11CancelRelease"))
			){
				if(blStatusVO.getChgPpdInd() == null || blStatusVO.getChgPpdInd().equals("N")) {
					//PPD Data is not Ready !
	                throw new EventException(new ErrorHandler("BKG08079", new String[]{}).getMessage());
	            }	
				if(blStatusVO.getChgPpdThirdInd() == null || blStatusVO.getChgPpdThirdInd().equals("N")) {
					//PPD Data is not Ready !
	                throw new EventException(new ErrorHandler("BKG08079", new String[]{}).getMessage());
	            }
			}
			if(blStatusVO.getDoChkInd() == null || blStatusVO.getDoChkInd().equals("N")) {
                throw new EventException(new ErrorHandler("BKG00434", new String[]{}).getMessage());
                //D/O already issued
            }
			log.debug("[end][======== [BLIssuanceBC] :: validateBlIssue ]==========");
			
			
			log.debug("===============================================================");
			log.debug("[start][======== [BLIssuanceBC] :: searchOldBkgForHistory ]"+buttonType);
			log.debug("===============================================================");
			//I BookingHistoryMgtBC::searchOldBkgForHistory ( uiId , bkgBlNoVo )

			// History search
			bkgBlNoVO.setBkgNo(bkg_no);
			bkgBlNoVO.setCaUsrId(account.getUsr_id());			
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);			
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			/**
			 *  OBLISS	ORIGINAL B/L ISSUE
			 *  OBLRED	ORIGINAL B/L REDEMPTION
			 *  OBLRIS	ORIGINAL B/L REISSUE
			 *  OBLREL	ORIGINAL B/L RELEASE
			 *  OBLSRD	ORIGINAL B/L SURRENDER
			 *  BKGRAT	RATING
			 */
			String oRIGINAL_BL = "";
			if(buttonType.equals("btn_t11Issue")&&"B".equalsIgnoreCase(blIssInfoVO.getBlIssTpCd())){
				oRIGINAL_BL="OBLISS";
			}else if(buttonType.equals("btn_t11Issue")&&"W".equalsIgnoreCase(blIssInfoVO.getBlIssTpCd())){
				oRIGINAL_BL="SWBISS";
			}else if(buttonType.equals("btn_t11BLRelease")&&"W".equalsIgnoreCase(blIssInfoVO.getBlIssTpCd())){
				oRIGINAL_BL="SWBREL";
			}else if(buttonType.equals("btn_t11BLRelease")&&"B".equalsIgnoreCase(blIssInfoVO.getBlIssTpCd())){
				oRIGINAL_BL="OBLREL";
			}else if(buttonType.equals("btn_t11InternetAUTH")){
				oRIGINAL_BL="OBLREL";
			}else if(buttonType.equals("btn_t11OBLSurrender")){
				oRIGINAL_BL="OBLSRD";
			}
			
			if(!oRIGINAL_BL.equals("")){
				log.debug("[method][======== [BLIssuanceBC] :: oRIGINAL_BL]=========="+oRIGINAL_BL);
	
				// < in case of docPrcModyFlg='Y'> 
				// 5. [] IBookingHistoryMgtBC::manageDocProcess ( docProcSkd )
	            BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
	            docProcSkdVO.setBkgNo(bkg_no);
	            docProcSkdVO.setBkgDocProcTpCd(oRIGINAL_BL);
	            
	            bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
			}

			//I GeneralBookingReceiptBC::modifyBlType ( bkgNo , blTpCd )
			GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
			String blTpCd = blIssInfoVO.getBlIssTpCd();
			generalBookingReceiptBC.modifyBlType(bkg_no,blTpCd);
			String caNo = bkgBlNoVO.getCaNo();
			if("TMP0000001".equals(caNo)){
				generalBookingReceiptBC.modifyBlTypeHistory(bkg_no,blTpCd);
			}

			//IBLIssuanceBC::manageBlIssueFlg ( blIssInfoVO )
			blIssInfoVO.setButtontype(buttonType);
			command.manageBlIssueFlg(blIssInfoVO);
			if("TMP0000001".equals(caNo)){
				command.manageBlIssueFlgHistory(blIssInfoVO);
			}

			//BLDocumentationBLBC::manageBlIssueFlg ( blIssInfoVO )
			blBC.manageBlIssueFlg(blIssInfoVO);
			if("TMP0000001".equals(caNo)){
				blBC.manageBlIssueFlgHistory(blIssInfoVO);
			}
			//2014.11.24 Maeda Add
			 if(buttonType.equals("btn_t11InternetAUTH")){
				 command.sendOblPrintAuthEmail(bkg_no, account);
//			 }else if (buttonType.equals("btn_t11SWBRelease")){
			 }else if ("W".equals(blTpCd) && "btn_t11BLRelease".equals(buttonType)){
//				 command.sendWblReleaseEmail(bkg_no, bkgBlNoVO, account);
				 command.sendWblReleaseEmail(bkg_no, bkgBlNoVO, account, event.getFileDownPath());
			 }
			//2014.11.24 Maeda End
			 
            // save transaction in case of issue 
            if(buttonType.equals("btn_t11Issue")){
            	 this.manageBlIssInfo(e);
            }

            // BKG_HIS_MST( CORR_NO), "TMP0000001" blank process logic
            bkgBlNoVO.setCaFlg("N");
            bkgBlNoVO.setCaNo("");
            historyTableVO.setBkgBlNoVO(bkgBlNoVO);
            
            bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
			//ICargoReleaseOrderBC::setupFocByObl ( OblRdemVO )
//			if("Y".equals(setupfocoblflag) && "btn_t11SWBRelease".equals(buttonType)){
            if("Y".equals(setupfocoblflag) && "W".equals(blTpCd) && "btn_t11BLRelease".equals(buttonType)){
				log.debug("===============================================================");
				log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByObl ]");
				log.debug("===============================================================");
				begin();
				CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
				OblRdemVO oblRdem = new OblRdemVO();
				oblRdem.setBlNo(bl_no);
				oblRdem.setCgorTeamCd("S");
				oblRdem.setCgoEvntNm("SWB Release");
				oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				oblRdem.setEvntOfcCd(account.getOfc_cd());
				oblRdem.setEvntUsrId(account.getUsr_id());
				oblRdem.setOblRdemFlg(blIssInfoVO.getReleased());

				try{
				cargoBC.setupFocByObl(oblRdem);
				}catch(Exception e1){
					log.error("[end:: CargoReleaseOrderBC == manageBlIssue update ]==========");
				}

				commit();
			}
            // save transaction in case of issue 
            if(buttonType.equals("btn_t11Issue")){
	            log.debug("\n======= Auto EDI Send ======\n");
	        	List<BkgNtcHisVO> bkgNtcHisVOs = command.createDraftBlEdiAuto(bkgBlNoVO.getBkgNo(), account);
	
				if (bkgNtcHisVOs != null) {
					if (bkgNtcHisVOs.size() > 0) {
						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
					}
				}	
            }
			
			
			//by kim-tk. 2015.06.03. FTP
//			if("btn_t11SWBRelease".equals(buttonType)){
            if("W".equals(blTpCd) && "btn_t11BLRelease".equals(buttonType)){
				log.debug("===============================================================");
				log.debug("[start][======== [BLIssuanceBC] :: sendBlRDFtp ]");
				log.debug("===============================================================");
				begin();
				
				try{
					command.sendBlRDFtp(bkg_no, bkgBlNoVO, account, event.getFileDownPath(), "SWB");
				}catch(Exception ef){
					log.error("[exception:: BLIssuanceBC == sendBlRDFtp ]=========="+ef.getMessage());
				}
				log.error("[end:: BLIssuanceBC == sendBlRDFtp ]==========");
				
				commit();
			}
		} catch (EventException ex){
			rollback();
			log.error("err " + e.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse transmitFTP(Event e) throws EventException {
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		BLIssuanceBC command 				= new BLIssuanceBCImpl();
		BookingUtil utilCmd 				= new BookingUtil();

		EsmBkg007909Event event 			= (EsmBkg007909Event) e;
		String bkgNo 						= event.getBkg_no();
		BlIssInfoVO[] blIssInfoVOs 			= event.getBlIssInfoVOs();
		
		
		BkgBlNoVO bkgBlNoVO 				= new BkgBlNoVO();
		
		try{
			begin();
			String[] totalpages					= new String[4];
			totalpages[0] = event.getTotalpage();
			totalpages[1] = event.getTotalunrated();
			
			BlIssInfoVO blIssInfoVO = blIssInfoVOs[0];
			blIssInfoVO.setUpdUsrId(account.getUsr_id());			
			
			bkgBlNoVO.setBkgNo(bkgNo);
			bkgBlNoVO.setCaUsrId(account.getUsr_id());			
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);			
			command.transmitFtp(bkgBlNoVO, blIssInfoVO, totalpages, account, event.getFileDownPath());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * EsmBkg0649Event retrieve event process.<br>
	 * B/L Issue Info retrieve.<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlReIssue(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg0649Event event = (EsmBkg0649Event) e;
		String bl_no = event.getBl_no();
		String bkg_no = event.getBkg_no();
		try {

			// 1. retrieve by bl_no in case of not existing bkg_no
			 if(bkg_no == null || bkg_no.length() == 0){
                if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
                BookingUtil bookingUtilBC = new BookingUtil();
                bkg_no = bookingUtilBC.searchBkgNoByBlNo(bl_no);  
             }

			// checking whether bkg_no exists or not
			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
			bkgBlNo.setBkgNo(bkg_no);
			bkgBlNo.setBlNo(bl_no);	
			bkgBlNo.setCaUsrId(account.getUsr_id());
			BookingUtil bookingUtil = new BookingUtil();
			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new Exception(new ErrorHandler("BKG03055", new String[] { bkg_no }).getMessage());
			}

			// 1. retrieve bl_no
			ReIssueVO reIssueVO = command.searchBlReIssue(bkg_no);

			// 2. return result
			eventResponse.setRsVoList(reIssueVO.getReIssueInfoVO());
			
			/*
			3. showing msg[BKG00457] and not retrieve in case of Surrender 
			4. showing msg[BKG00478] and not retrieve in case of Not Issue
			5. showing msg[BKG00434] and not retrieve in case of Issue D/O
			*/
			if(reIssueVO.getReIssueInfoVO().size() != 0){
				ReIssueInfoVO vo = (ReIssueInfoVO)reIssueVO.getReIssueInfoVO().get(0);
				if("Y".equals(vo.getOblSrndFlg())){

					throw new EventException(new ErrorHandler("BKG00457", new String[]{}).getMessage());
					
				}
				if("N".equals(vo.getOblIssFlg())){
					throw new EventException(new ErrorHandler("BKG00478", new String[]{}).getMessage());
					
				}
				if("Y".equals(vo.getDoYn())){
					throw new EventException(new ErrorHandler("BKG00434", new String[]{}).getMessage());
				
				}
			}

			eventResponse.setRsVoList(reIssueVO.getBkgDocIssHisVO());
			eventResponse.setRsVoList(reIssueVO.getBkgDocIssRdemVO());

		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {			
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkg0649Event save event process.<br>
	 * B/L Re-Issue Info insert/modify.<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlReIssue(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg0649Event event = (EsmBkg0649Event) e;
		ReIssueVO reIssueVO = new ReIssueVO();
		reIssueVO.setBkgDocIssHisVOs(event.getBkgDocIssHisVOs());
		reIssueVO.setBkgDocIssRdemVOs(event.getBkgDocIssRdemVOs());
		reIssueVO.setAccount(account);
		reIssueVO.setBkg_no(event.getBkg_no());
		reIssueVO.setHis_seq(event.getHis_seq());
		
		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		String uiId = "ESM_BKG_0649";

		
		try {

			begin();
			/*validate*/
			this.validateBlReIssue(e);
			log.debug("=====> validateBlReIssue    : OK!");
			
			eventResponse = new GeneralEventResponse();
			
			/* search old history */
			bkgBlNoVO.setBkgNo(reIssueVO.getBkg_no());
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			
			reIssueVO.setCommand_type("Save");
			command.manageBlReIssue(reIssueVO);
			
			/* create history */
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
		
			commit();
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * EsmBkg0649Event retrieve event process.<br>
	 * B/L Issue Info validation.<br>
	 * 
	 * @author
     * @param e Event
     * @exception EventException
	 */
	private void validateBlReIssue(Event e) throws EventException {
		try{
			this.searchBlReIssue(e);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {			
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0649Event save event process.<br>
	 * B/L Re-Issue Info insert/modify.<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse confirmBlReIssue(Event e) throws EventException {
		
		GeneralEventResponse eventResponse	= new GeneralEventResponse();
		BLIssuanceBC bLIssuanceBC			= new BLIssuanceBCImpl();
		
		EsmBkg0649Event event 				= (EsmBkg0649Event) e;
		
		String bkg_no 						= event.getBkg_no();
		String released 					= event.getReleased();
		String issued 						= event.getIssued();
		String setupfocoblflag 				= event.getSetupfocoblflag();
		String bl_no 						= event.getBl_no();
		
		ReIssueVO reIssueVO = new ReIssueVO();
		reIssueVO.setBkgDocIssHisVOs(event.getBkgDocIssHisVOs());
		reIssueVO.setBkgDocIssRdemVOs(event.getBkgDocIssRdemVOs());
		reIssueVO.setAccount(account);
		reIssueVO.setBkg_no(bkg_no);
		reIssueVO.setHis_seq(event.getHis_seq());

		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		String uiId = "ESM_BKG_0649";

		
		log.debug("===============================================================");
		log.debug("[start][======== confirmBlReIssue " + setupfocoblflag);
		log.debug("===============================================================");
		
		try {
			/*validate*/
			this.validateBlReIssue(e);
			log.debug("=====> validateBlReIssue    : OK!");

			/* search old history */
			bkgBlNoVO.setBkgNo(bkg_no);
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			
			/* searchBkgBlNo */
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049").getMessage());
			}
			
			BlIssueVO blIssueVO = new BlIssueVO();
			blIssueVO.setAccount(account);
			blIssueVO.setBkg_no(bkg_no);
			blIssueVO.setBl_no(bl_no);
			
			
			begin();
			
			BlIssueVO rBlIssueVO = bLIssuanceBC.searchBlIssInfo(blIssueVO);
			
			/* SearchOld Booking History */

			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			/* Manage Booking BlReIssue */
			reIssueVO.setCommand_type("COMFIRM");
			bLIssuanceBC.manageBlReIssue(reIssueVO);
			
			/* [History in case of Cancel] */
			BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
            docProcSkdVO.setBkgNo(bkg_no);
            
            if(released.equals("Y")){
            	
            	/* [Delete and Insert OBLRLC in case of Release Cancel] */ 
            	if("B".equalsIgnoreCase(rBlIssueVO.getBlIssInfoList().get(0).getBlIssTpCd())){
            		docProcSkdVO.setBkgDocProcTpCd("OBLRLC");
            	}else if("W".equalsIgnoreCase(rBlIssueVO.getBlIssInfoList().get(0).getBlIssTpCd())){
            		docProcSkdVO.setBkgDocProcTpCd("SWBRLC");
            	}
    			bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
            }
            if(issued.equals("Y")){
            	
            	/* [Issue Cancel �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋占쎌젂占쎈뼇占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼇�븶占쎄덩占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�몱占쎌맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎄슈占쎄섶占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈콦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌겲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛筌��맮�삕占쎌��윜諛잙쳛占쎄뎡�뜝�럥夷⑨옙�쐻�뜝占� OBLISC �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윪占쎌맚占쎈쐻占쎈윪占쎈츎�뜝�럥���뜝�럥�맋�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡�뒋占쎈닱占쎈쐞占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑟�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럡�맜�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈듃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡�뒋占쎈닱占쎈쐞占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅勇싲즾維낉옙�굲�뜝�럥占썲뜝�럡肄э옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌앸쑚�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥�걤�뜝�럡�븫�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�] */
            	/* [Delete and Insert OBLISC in case of Issue Cancel] */
            	if("B".equalsIgnoreCase(rBlIssueVO.getBlIssInfoList().get(0).getBlIssTpCd())){
            		docProcSkdVO.setBkgDocProcTpCd("OBLISC");
            	}else if("W".equalsIgnoreCase(rBlIssueVO.getBlIssInfoList().get(0).getBlIssTpCd())){
            		docProcSkdVO.setBkgDocProcTpCd("SWBISC");
            	}
	            bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
            }
            
            /* manage Booking History */
        	bkgBlNoVO.setCaFlg("N");
        	bkgBlNoVO.setCaNo("");
        	historyTableVO.setBkgBlNoVO(bkgBlNoVO);
            bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);

            
			//ICargoReleaseOrderBC::setupFocByObl ( OblRdemVO )
			if("Y".equals(setupfocoblflag)){
				log.debug("===============================================================");
				log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByObl ]");
				log.debug("===============================================================");
				CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
				OblRdemVO oblRdem = new OblRdemVO();
				oblRdem.setBlNo(bl_no);
				oblRdem.setCgorTeamCd("S");
				oblRdem.setCgoEvntNm("SWB Release cancel");
				oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				oblRdem.setEvntOfcCd(account.getOfc_cd());
				oblRdem.setEvntUsrId(account.getUsr_id());
				oblRdem.setOblRdemFlg("N");

				try{
				cargoBC.setupFocByObl(oblRdem);
				}catch(Exception e1){
					log.error("[end:: CargoReleaseOrderBC == confirmBlReIssue update ]==========");					
				}
			}            
            
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * EsmBkg0400Event retrieve event process.(ESM_BKG_0400)<br>
	 * O.B/L Surrender retrieve.<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchSurrenderInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<SrndVO> srndVOList = null;
		EsmBkg0400Event event = (EsmBkg0400Event) e;
		String bkg_no = event.getBkg_no();
		String bl_no = event.getBl_no();

		try {
			// checking whether bkg_no exists or not
   			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
   			bkgBlNo.setBkgNo(bkg_no);
   			bkgBlNo.setBlNo(bl_no);	
   			bkgBlNo.setCaUsrId(account.getUsr_id());
   			BookingUtil bookingUtil = new BookingUtil();
   			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG03055", new String[] { bkg_no }).getMessage());
			}
			 
			if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
			// 1. retrieve O.B/L Surrender
			srndVOList = command.searchSurrenderInfo(bkg_no, bl_no);

			eventResponse.setRsVoList(srndVOList);
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
	 * surrender OBL.(ESM_BKG_0400)
     * using in case of need not OBL & Publication.
     * Handling redemption and surrender at the same time.
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifySurrenderInfo(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == modifySurrenderInfo update ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg0400Event event = (EsmBkg0400Event) e;
		SrndVO[] srndVOs = event.getSrndVOs();
		srndVOs[0].setAccount(account);
		
		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		String uiId = "ESM_BKG_0400";
		String bkg_no = event.getBkg_no();
		
		/*
		- OBL surrender transaction
		- in case of need not OBL and Issus
		- surrender and redemption transaction .-- UI_BKG-0400
		*/
		
		try {
			begin();
			
			//
			this.validateSurrenderInfo(e, "S");		//Save
			log.debug("validateSurrenderInfo OK!! ");
			
			//1. retrieve by BKG_No
			//2. check Exception. (include D/O status)
			//3. update Surrender at B/L Info.
			
			/* search old history */
			bkgBlNoVO.setBkgNo(srndVOs[0].getBkgNo());
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			command.modifySurrenderInfo(srndVOs[0]);	
			
			//ca_no ='TMP0000001' , BKG_BL_ISS_HIS update
			String caNo = bkgBlNoVO.getCaNo();
			if("TMP0000001".equals(caNo)){
				command.modifySurrenderInfoHistory(srndVOs[0]);
			}	

			//2. -> [] IFullReleaseOrderBC::setupFOC ( blNo , blNoTp , blNoChk , focTp , focStatus , acount )
				//2-1. BKG_CGO_RLSE.OBL_RDEM_FLG = 'Y'
				//2-2. Call the related D/O to Inbound (type = 'O', stsFlag = 'Y')
			
			//3. -> [] IBookingHistoryMgtBC::createBkgHistoryLine ( bkgNo , eventDesc , issTpCd )

			/**
			 *  OBLISS	ORIGINAL B/L ISSUE
			 *  OBLRED	ORIGINAL B/L REDEMPTION
			 *  OBLRIS	ORIGINAL B/L REISSUE
			 *  OBLREL	ORIGINAL B/L RELEASE
			 *  OBLSRD	ORIGINAL B/L SURRENDER
			 *  BKGRAT	RATING
			 */
	
			// < docPrcModyFlg='Y'> 
		    // IBookingHistoryMgtBC::manageDocProcess ( docProcSkd )
			BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
	        docProcSkdVO.setBkgNo(bkg_no);
	        docProcSkdVO.setBkgDocProcTpCd("OBLSRD");
	        bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
	        
			/* create history */
	        bkgBlNoVO.setCaFlg("N");
	        bkgBlNoVO.setCaNo("");
	        historyTableVO.setBkgBlNoVO(bkgBlNoVO);
	        bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
			//ICargoReleaseOrderBC::setupFocByObl ( OblRdemVO )
			
			log.debug("===============================================================");
			log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByObl ]");
			log.debug("===============================================================");
				
			CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
			OblRdemVO oblRdem = new OblRdemVO();
			oblRdem.setBlNo(bkgBlNoVO.getBlNo());
			oblRdem.setCgorTeamCd("S");
			oblRdem.setCgoEvntNm("Surrender");
			oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			oblRdem.setEvntOfcCd(account.getOfc_cd());
			oblRdem.setEvntUsrId(account.getUsr_id());
			oblRdem.setOblRdemFlg("Y");

			try{
				cargoBC.setupFocByObl(oblRdem);
			}catch(Exception e1){
				log.error("[end:: CargoReleaseOrderBC == manageBlIssInfo update ]==========");				
			}			
			commit();
			 
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == manageBlIssInfo update ]==========");
		return eventResponse;
	}
	/**
	 * EsmBkg0400Event retrieve event process.(ESM_BKG_0400)<br>
	 * O.B/L Surrender retrieve.<br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	private void validateSurrenderInfo(Event e, String type) throws EventException {
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<SrndVO> srndVOList = null;
		EsmBkg0400Event event = (EsmBkg0400Event) e;
		String bkg_no = event.getBkg_no();
		String bl_no = event.getBl_no();

		try {
			// checking whether bkg_no exists or not
   			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
   			bkgBlNo.setBkgNo(bkg_no);
   			bkgBlNo.setBlNo(bl_no);	
   			bkgBlNo.setCaUsrId(account.getUsr_id());
   			BookingUtil bookingUtil = new BookingUtil();
   			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG03055", new String[] { bkg_no }).getMessage());
			}
			
			// 1. retrieve O.B/L Surrender
			srndVOList = command.searchSurrenderInfo(bkg_no, bl_no);
			if( srndVOList != null && srndVOList.size() > 0){
				if("S".equals(type)){			//Save
					if("W".equals(srndVOList.get(0).getBlTpCd())){
						throw new EventException(new ErrorHandler("BKG00372").getMessage());
					}
					if(!"Y".equals(srndVOList.get(0).getOblRlseFlg())){
						throw new EventException(new ErrorHandler("BKG08081").getMessage());
					}
					if("N".equals(srndVOList.get(0).getOblRlseFlg())){
						throw new EventException(new ErrorHandler("BKG00373").getMessage());
					}
					if("Y".equals(srndVOList.get(0).getCustToOrdFlg())){
						throw new EventException(new ErrorHandler("BKG00374").getMessage());
					}
				}else if("C".equals(type)){		//Cancel
					if(!"Y".equals(srndVOList.get(0).getOblSrndFlg())){
						throw new EventException(new ErrorHandler("BKG08083").getMessage());
					}
				}
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		  
	}	

	/**
	 * EsmBkg0400Event delete event process.(ESM_BKG_0400)<br>
	 * initializing Surrender Info.<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse removeSurrenderInfo(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == removeSurrenderInfo update ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC bLIssuanceBC 					= new BLIssuanceBCImpl();

		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC 	= new BookingHistoryMgtBCImpl();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		BookingUtil utilCmd = new BookingUtil();
		String uiId = "ESM_BKG_0400";
		
		EsmBkg0400Event event						= (EsmBkg0400Event) e;
		String bkg_no 								= event.getBkg_no();
		
		try {
			begin();

			//
			this.validateSurrenderInfo(e,"C");		//Cancel
			log.debug("validateSurrenderInfo OK!! ");
			
			/* search old history */
			bkgBlNoVO.setBkgNo(bkg_no);
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			//[] BLIssuanceDBDAO::removeSurrenderInfo ( bkgNo )
			//Initializing Surrender Info
			//占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥�뜮�빆�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇘솾�꺂�뒧占쎈�뽩뜝�럥裕앾옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� removeSurrenderInfo ( [in] bkgNo : String ) : void
			bLIssuanceBC.removeSurrenderInfo(bkg_no);
			
			//ca_no ='TMP0000001' , BKG_BL_ISS_HIS update
			String caNo = bkgBlNoVO.getCaNo();
			if("TMP0000001".equals(caNo)){
				bLIssuanceBC.removeSurrenderInfoHistory(bkg_no);
			}
			
			// < docPrcModyFlg='Y'> 
			// 5. [] IBookingHistoryMgtBC::manageDocProcess ( docProcSkd )
			BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
			docProcSkdVO.setBkgNo(bkg_no);
			docProcSkdVO.setBkgDocProcTpCd("OBLSRC");
			bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);

			/* create history */
	        bkgBlNoVO.setCaFlg("N");
	        bkgBlNoVO.setCaNo("");
	        historyTableVO.setBkgBlNoVO(bkgBlNoVO);
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
			//ICargoReleaseOrderBC::setupFocByObl ( OblRdemVO )
			log.debug("===============================================================");
			log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByObl ]");
			log.debug("===============================================================");
			
			CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
			OblRdemVO oblRdem = new OblRdemVO();
			oblRdem.setBlNo(bkgBlNoVO.getBlNo());
			oblRdem.setCgorTeamCd("S");
			oblRdem.setCgoEvntNm("Surrender Cancel");
			oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			oblRdem.setEvntOfcCd(account.getOfc_cd());
			oblRdem.setEvntUsrId(account.getUsr_id());
			oblRdem.setOblRdemFlg("N");

			try{
			cargoBC.setupFocByObl(oblRdem);
			}catch(Exception e1){
				log.error("[end:: CargoReleaseOrderBC == removeSurrenderInfo update ]==========");				
			}
			
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == removeSurrenderInfo update ]==========");
		return eventResponse;
	}

	/**
	 * EsmBkg00059Event retrieve event process.(ESM_BKG_0059)<br>
	 * Documentation Requirement(ESM_BKG-0079 B/L INFO POP-UP)<br>
	 * retrieving Documentation Requirement data. -- UI_BKG-0059 <br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchDocRqst(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == searchDocRqst SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg0059Event event = (EsmBkg0059Event) e;
		String bkg_no = event.getBkg_no();
		String ofc_cd = account.getOfc_cd();
		try {
			// 1. Documentation Requirement retrieve
			List<DocRqstVO> docRqstList = command.searchDocRqst(bkg_no, ofc_cd);

			eventResponse.setRsVoList(docRqstList);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == searchDocRqst SEARCH ]==========");
		return eventResponse;
	}

	/**
	 * Documentation Requirement Info save(ESM_BKG_0059)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyDocRqst(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == modifyDocRqst update ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg0059Event event = (EsmBkg0059Event) e;
		DocRqstVO[] docRqstVOs = event.getDocRqstVOs();
		docRqstVOs[0].setUserId(account.getUsr_id());
		try {
			begin();
			command.modifyDocRqst(docRqstVOs[0]);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == modifyDocRqst update ]==========");
		return eventResponse;
	}

	/**
	 * retrieving Package Description.(ESM_BKG_0079_06)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchPckTp(Event e) throws EventException {
		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();

		try {
			MdmPckTpVO pckTpVO = utilCmd.searchPkgType(event.getPckTpCd());
			eventResponse.setETCData("pck_nm", (pckTpVO.getPckNm() == null ? "" : pckTpVO.getPckNm()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving template Info by shipper of B/L.(ESM_BKG_0079_06)<br>
	 * 
	 * @author 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchUserTmpltList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		UserSetupMgtBC command = new UserSetupMgtBCImpl();

		try {
			BkgUsrTmpltVO vo = new BkgUsrTmpltVO();
			vo.setUsrId(account.getUsr_id());

			List<BkgUsrTmpltVO> list = command.searchUserTmpltList(vo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * dangerous cargo Info retrieve.(ESM_BKG_0079_06)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchDG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();

		String bkgNo = event.getBkgNo();
		log.debug("searchDG ================> " + bkgNo);

		try {
			/*
			 * make set by DG seq and transaction
			 */
			StringBuffer sbuf = new StringBuffer("");
			List<DGCargoVO> list = command.searchDG(bkgNo);
			DGCargoVO vo = null;
			int pkg_qty = 0;
			int len = list == null ? 0 : list.size();
			for (int i = 0; i < len; i++) {
				vo = list.get(i);
				pkg_qty = (vo.getPckQty() == null || vo.getPckQty().length() == 0) ? 0 : Integer.parseInt(vo.getPckQty());
				sbuf.append(pkg_qty + " " + vo.getPckNm() + "\n");
				sbuf.append("UN" + vo.getImdgUnNo() + ", CLASS " + vo.getImdgClssCd() + "\n");
				sbuf.append(vo.getPrpShpNm() + "\n");
				// if(vo.getHzdDesc()!=null && vo.getHzdDesc().length()>0){
				sbuf.append("(" + (vo.getHzdDesc()==null ? "" : vo.getHzdDesc().trim()) + ")\n");
				// }
				if (vo.getImdgClssCd() != null && vo.getImdgClssCd().startsWith("3")) {
					sbuf.append("F.P. " + (vo.getFlshPntCdoTemp()==null ? "" : vo.getFlshPntCdoTemp().trim()) + "\n");
				}
				sbuf.append("EMERGENCY CONTACT " + (vo.getEmerCntcPhnNoCtnt()==null ? "" : vo.getEmerCntcPhnNoCtnt().trim()) + "\n");
			}
			log.debug("\n******************** COPY_FROM_DG ********************\n" + sbuf.toString());
			eventResponse.setETCData("copy_from_dg", sbuf.toString());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_BKG_0079_07 : Retrieve<br>
	 * Container Manifest Info retrieve.(ESM_BKG_0079_07)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007907Event event = (EsmBkg007907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
		
		BLDocumentationBLBC bLDocumentationBLBC= new BLDocumentationBLBCImpl();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		try {
			// searchBkgBlNo
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
			}
			log.debug("=====> CA Flag    : " + bkgBlNoVO.getCaFlg());
            
			/* update on 2009.12.31 */
            String cgoTp = utilCmd.searchBkgCgoTp(bkgBlNoIN);
            if("P".equals(cgoTp)) {
                throw new EventException(new ErrorHandler("BKG00092", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> Cgargo Tpye : " + cgoTp);
            
            
			CmVO cmVO = docCmd.searchCm(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());

			CmBkgInfoVO cmInfoVO = cmVO.getCmBkgInfoVO();
			List<CmCntrInfoVO> cmCntrInfoVOs = cmVO.getCmCntrInfoVOs();
			// List<BkgCntrSealNoVO> cntrSealNoVOs = cmVO.getCntrSealNoVOs();
			List<BkgCntrMfDescVO> cntrMfDescVOs = cmVO.getBkgCntrMfDescVOs();
			//2010-12-08
			List<BkgDgCgoVO> bkgDgCgoVOs = cmVO.getBkgDgCgoVOs();

			eventResponse.setRsVoList(cmCntrInfoVOs);
			eventResponse.setETCData(cmInfoVO.getColumnValues());
			eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
			eventResponse.setETCData("obl_iss_flg", utilCmd.oblIssFlgCheck(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg()));
			// eventResponse.setRsVoList(cntrSealNoVOs);
			eventResponse.setRsVoList(cntrMfDescVOs);
			//2010-12-08
			eventResponse.setRsVoList(bkgDgCgoVOs);
			
			List<BkgCntrShpVO> listBkgCntrShp = bLDocumentationBLBC.searchBkgCntrShp(bkgBlNoVO.getBkgNo());
			
			if(listBkgCntrShp != null && listBkgCntrShp.size()>0)		eventResponse.setETCData("mlt_shp_flg", "Y");
			else														eventResponse.setETCData("mlt_shp_flg", "N");

			/*
			 * CmVO cmVO = docCmd.searchCM(bkgNo, blNo);
			 * 
			 * List<BkgCntrSealNoVO> cntrSealNoVOs = cmVO.getCntrSealNoVOs();
			 * 
			 * StringBuffer sbuf = new StringBuffer(); int len =
			 * (cntrSealNoVOs==null) ? 0 : cntrSealNoVOs.size(); for(int
			 * i=0;i<len;i++){
			 * sbuf.append(cntrSealNoVOs.get(i).getCntrSealNo()); if(i+1 != len)
			 * sbuf.append("|"); }
			 * 
			 * List<BkgCntrMfDescVO> cntrMfDescVOs = cmVO.getBkgCntrMfDescVOs();
			 * 
			 * eventResponse.setRsVoList(cntrMfDescVOs);
			 * eventResponse.setETCData("cntr_seal_no", sbuf.toString());
			 */
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * container to copy to other Booking.(ESM_BKG_0079_07)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageCm(Event e) throws EventException {

		EsmBkg007907Event event = (EsmBkg007907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
		BookingUtil utilCmd = new BookingUtil();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        //BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();

		CmVO cmVO = event.getCmVO();

		CmBkgInfoVO vo1 = cmVO.getCmBkgInfoVO();
		// List<CmCntrInfoVO> vo2 = cmVO.getCmCntrInfoVOs();
		log.debug("******** BkgNo : " + vo1.getBkgNo());

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(vo1.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		HistoryTableVO historyTableVO = null;

		String uiId = "ESM_BKG_0079_07";

		try {
			begin();
			/* searchBkgBlNo */
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049").getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

			/* Validate Container */
			docCmd.validateCm(cmVO);
			log.debug("=====> validateCm    : OK!");
			
			/* checkSpecialValue */
			docCmd.checkSpecialValue(cmVO);
            
            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

			/* modifyCngScreenFlag */
			//if ("Y".equals(bkgBlNoVO.getCaFlg())) {
				//correctCmd.modifyCngScreenFlag("", bkgBlNoVO);
			//}
			
			/* Manage CM */
			docCmd.manageCm(cmVO, account, bkgBlNoVO.getCaFlg());

            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
			/* Set Message */
			eventResponse.setUserMessage("");
			commit();
		} catch (EventException ex) {
			rollback();
			//eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_06 : initializing screen.(ESM_BKG_0079_04,ESM_BKG_0079_06)<br>
	 * BLDocumentationBL retrieve event process.<br>
	 *
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil comboUtil = new BookingUtil();

		try {
			// freight term code, CD02080
			List<BkgComboVO> frt_terms = comboUtil.searchCombo("CD02080");
			int len = frt_terms == null ? 0 : frt_terms.size();
			for (int i = 0; i < len; i++) {
				BkgComboVO vo = frt_terms.get(i);
				vo.setName(vo.getVal() + "-" + vo.getName());
			}
			// weight unit, CD00775
			List<BkgComboVO> wgt_units = comboUtil.searchCombo("CD00775");
			// measure unit, CD01116
			List<BkgComboVO> meas_units = comboUtil.searchCombo("CD01116");

			eventResponse.setCustomData("frt_terms", frt_terms);
			eventResponse.setCustomData("wgt_units", wgt_units);
			eventResponse.setCustomData("meas_units", meas_units);

			// eventResponse.setRsVoList(frt_terms);
			// eventResponse.setRsVoList(wgt_units);
			// eventResponse.setRsVoList(meas_units);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
     * retrieving information(Type Size, Status etc) by a Container No.(ESM_BKG_0079_04)<br>
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCntrDtlInfo(Event e) throws EventException {
    	EsmBkg007904Event event = (EsmBkg007904Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    
    	BLDocumentationCMBC command = new BLDocumentationCMBCImpl();
    
    	String bkgNo = event.getBkgNo();
    	String cntrNo = event.getCntrNo();
    
    	try {
    		CntrDetailInfoVO detailVo = command.searchCntrDtlInfo(cntrNo);
/*
    		if (detailVo == null) {
    			// BKG00173 : "failed to find CNTR("+cntrNo+")"
    			// throw new EventException(new
    			// ErrorHandler("BKG00173").getMessage());
    		} else {
    			detailVo.setBkgNo(bkgNo);
    			// detailVo.setBkgNoSplit(bkgNoSplit);
    			eventResponse.setETCData(detailVo.getColumnValues());
    		}
*/
    		if (null != detailVo) {
    			detailVo.setBkgNo(bkgNo);
    			eventResponse.setETCData(detailVo.getColumnValues());
    		}
    	} catch (EventException ex) {
    		throw ex;
    	} catch (Exception ex) {
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	}
    	return eventResponse;
    }

    /**
	 * retrieving B/L Mark and Description Info.(ESM_BKG_0079_06)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMnd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		try {
			// searchBkgBlNo
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* update on 2009.12.31 */
            String cgoTp = utilCmd.searchBkgCgoTp(bkgBlNoIN);
            if("P".equals(cgoTp)) {
                throw new EventException(new ErrorHandler("BKG00092", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> Cgargo Tpye : " + cgoTp);
            
            
			/* 
			 * need UserId for Default User Setting.
			 */ 
			bkgBlNoVO.setIbflag(account.getUsr_id());
			
			MndVO mndVO = docCmd.searchMnd(bkgBlNoVO);
			eventResponse.setETCData(mndVO.getColumnValues());
            eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
			eventResponse.setETCData("obl_iss_flg", utilCmd.oblIssFlgCheck(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg()));
			
			List<BkgCntrShpVO> listBkgCntrShp = docCmd.searchBkgCntrShp(bkgBlNoVO.getBkgNo());
			if(listBkgCntrShp != null && listBkgCntrShp.size()>0)		eventResponse.setETCData("mlt_shp_flg", "Y");
			else 														eventResponse.setETCData("mlt_shp_flg", "N");

			// HashMap<String, String> returnMap = mndVO.getColumnValues();
			// Iterator<String> iter = returnMap.keySet().iterator();
			// while(iter.hasNext()){
			// String key = iter.next();
			// String val = returnMap.get(key);
			// eventResponse.setETCData(key, (val==null ? "" : val));
			// }
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * saving(modify) B/L Mark and Description Info.(ESM_BKG_0079_06)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageMnd(Event e) throws EventException {

		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		BlRatingBC rateCmd = new BlRatingBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
//		BLIssuanceBC issCmd = new BLIssuanceBCImpl();
		
        //BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();

		MndVO mndVO = event.getMndVO();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(mndVO.getBkgNo());
		bkgBlNoIN.setBlNo(mndVO.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		HistoryTableVO historyTableVO = null;

		String uiId = "ESM_BKG_0079_06";

		try {
			begin();
			/* searchBkgBlNoVO */
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049").getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

			/* Validate MnD */
			docCmd.validateMnd(mndVO);

			/* Search Booking History */
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);


			if(null != mndVO.getCntrWgtPrnFlg() && "Y".equals(mndVO.getCntrWgtPrnFlg())){
				mndVO.setCntrWgtPrnFlg("Y");
			}else{
				mndVO.setCntrWgtPrnFlg("N");
			}
			if(null != mndVO.getCntrMeasPrnFlg() && "Y".equals(mndVO.getCntrMeasPrnFlg())){
				mndVO.setCntrMeasPrnFlg("Y");
			}else{
				mndVO.setCntrMeasPrnFlg("N");
			}
			if(null != mndVO.getFrtTermPrnFlg() && "Y".equals(mndVO.getFrtTermPrnFlg())){
				mndVO.setFrtTermPrnFlg("Y");
			}else{
				mndVO.setFrtTermPrnFlg("N");
			}
			if(null != mndVO.getActWgtPrnFlg() && "Y".equals(mndVO.getActWgtPrnFlg())){
				mndVO.setActWgtPrnFlg("Y");
			}else{
				mndVO.setActWgtPrnFlg("N");
			}
			if(null != mndVO.getMeasQtyPrnFlg() && "Y".equals(mndVO.getMeasQtyPrnFlg())){
				mndVO.setMeasQtyPrnFlg("Y");
			}else{
				mndVO.setMeasQtyPrnFlg("N");
			}
			if(null != mndVO.getMkDescPrnFlg() && "Y".equals(mndVO.getMkDescPrnFlg())){
				mndVO.setMkDescPrnFlg("Y");
			}else{
				mndVO.setMkDescPrnFlg("N");
			}
			if(null != mndVO.getMfDescPrnFlg() && "Y".equals(mndVO.getMfDescPrnFlg())){
				mndVO.setMfDescPrnFlg("Y");
			}else{
				mndVO.setMfDescPrnFlg("N");
			}
			if(null != mndVO.getFrtPayOfcPrnFlg() && "Y".equals(mndVO.getFrtPayOfcPrnFlg())){
				mndVO.setFrtPayOfcPrnFlg("Y");
			}else{
				mndVO.setFrtPayOfcPrnFlg("N");
			}
			
			/* Change Screen Flag */
			//if ("Y".equals(bkgBlNoVO.getCaFlg())) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoVO);
			//}

			/* Manage MnD */
			docCmd.manageMnd(mndVO, account, bkgBlNoVO.getCaFlg());
            
            /* Manage Rate*/
            rateCmd.manageFrtTerm(bkgBlNoVO.getBkgNo(), mndVO.getFrtTermCd(), mndVO.getFrtTermPrnFlg(), account, bkgBlNoVO.getCaFlg());
                      
//            if (!mndVO.getPckCmdtDesc().equals(historyTableVO.getBkgBlDocVO().getPckCmdtDesc())
//            		 || !mndVO.getCntrCmdtDesc().equals(historyTableVO.getBkgBlDocVO().getCntrCmdtDesc())
//            	     || (!mndVO.getDgCmdtDesc().equals(historyTableVO.getBkgBlMkDescVO().getCmdtDesc()) 
//            	    		 && historyTableVO.getBkgBlMkDescVO().getCmdtDesc() != null)) {
//            	log.debug("\n======= Auto EDI Send ======\n");
//            	List<BkgNtcHisVO> bkgNtcHisVOs = issCmd.createDraftBlEdiAuto(bkgBlNoVO.getBkgNo(), account);
//
//				if (bkgNtcHisVOs != null) {
//					if (bkgNtcHisVOs.size() > 0) {
//						histCmd.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
//					}
//				}	
//			}
            
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
			/* Set Message */
			eventResponse.setUserMessage("");
			commit();
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
	 * Not Updated Container retrieve.(ESM_BKG_0901)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchNotUpdCntr(Event e) throws EventException {
		EsmBkg0901Event event = (EsmBkg0901Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

		String bkgNo = event.getBkgNo();

		try {
			List<EdiNotUpdCntrVO> list = command.searchNotUpdCntr(bkgNo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * retrieve a container list through VVD(ESM_BKG_0892)<br>
	 *
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCntrListByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0892Event event = (EsmBkg0892Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

		String vvd = event.getBkgVvd();
		String ofcCd = event.getBkgOfcCd();
		String pol = event.getBkgPol();
		String pod = event.getBkgPod();
		String cfmYn = event.getCfmFlg();

        try {
            List<CmCopyVO> list = command.searchCntrListByVvd(vvd, ofcCd, pol, pod, cfmYn);

            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

		return eventResponse;
	}

	/*
	 * private List<BkgComboVO> convertComboList(List<BkgUsrTmpltVO> list){
	 * List<BkgComboVO> comboVOs = new ArrayList<BkgComboVO>(); BkgComboVO
	 * firstVO = new BkgComboVO(); firstVO.setComboCd("word_tmplts");
	 * firstVO.setVal("0"); firstVO.setName("Select Template");
	 * firstVO.setDesc("Select Template"); comboVOs.add(firstVO);
	 * 
	 * int len = list==null ? 0 : list.size(); for(int i=0;i<len;i++){
	 * BkgComboVO tgtVO = new BkgComboVO(); BkgUsrTmpltVO orgVO = list.get(i);
	 * tgtVO.setComboCd("word_tmplts"); tgtVO.setVal(orgVO.getTmpltHdrNm());
	 * tgtVO.setName(orgVO.getTmpltHdrNm());
	 * tgtVO.setDesc(orgVO.getTmpltHdrNm()); comboVOs.add(tgtVO); } return
	 * comboVOs; }
	 */

	/**
	 * retrieve event process.<br>
	 * MultiCombo result for search condition.(ESM_BKG_0278)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCommonCdListVO(Event e) throws EventException {
		EsmBkg0278Event event = (EsmBkg0278Event) e;
		BookingUtil comboUtil = new BookingUtil();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// R/D Term - rcv_term_cd - CD00764
			List<BkgComboVO> rcv_term_cd = comboUtil.searchCombo("CD00764");
			eventResponse.setRsVoList(rcv_term_cd);

			// R/D Term - de_term_cd - CD00765
			List<BkgComboVO> de_term_cd = comboUtil.searchCombo("CD00765");
			eventResponse.setRsVoList(de_term_cd);

			// S.Route(From) - org_sconti_cd - getBkgcombovo
			List<BkgComboVO> org_sconti_cd = command.searchSRouteFromList(event.getBkgcombovo());
			eventResponse.setRsVoList(org_sconti_cd);

			// S.Route(To) - org_sconti_cd - getBkgcombovo
			List<BkgComboVO> desc_sconti_cd = command.searchSRouteFromList(event.getBkgcombovo());
			eventResponse.setRsVoList(desc_sconti_cd);

			// S.Mode(From) - org_svc_mod_cd - CD02149
			List<BkgComboVO> org_svc_mod_cd = comboUtil.searchCombo("CD02149");
			eventResponse.setRsVoList(org_svc_mod_cd);

			// S.Mode(To) - desc_inlnd_svc_mod_cd - CD02149
			List<BkgComboVO> desc_inlnd_svc_mod_cd = comboUtil.searchCombo("CD02149");
			eventResponse.setRsVoList(desc_inlnd_svc_mod_cd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieving list for O B/L print by group.(ESM_BKG_0278)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgListForGrpBlPr(Event e) throws EventException {
		EsmBkg0278Event event = null;
		BLIssuanceBC command = null;
		BookingUtil codeUtil = null;
		GrpBlPrtOutVO cVo = null;
		List<GrpBlPrtVO> grpBlPrt = null;
		List<BkgComboVO> codeList = null;
		String[] arrString = null;
		StringBuilder sbSortHeader = null;
		StringBuilder sbQuerySort = null;
		GeneralEventResponse eventResponse = null;
		try {
			event = (EsmBkg0278Event) e;
			command = new BLIssuanceBCImpl();
			codeUtil = new BookingUtil();
			cVo = new GrpBlPrtOutVO();
			eventResponse = new GeneralEventResponse();
			codeList = codeUtil.searchCombo("CD02347");
			arrString = event.getGrpBlPrtInVO().getQuerySort().split("\\|");
			sbSortHeader = new StringBuilder();
			sbQuerySort = new StringBuilder();
			for (String sort : arrString) {
				for (BkgComboVO code : codeList) {
					if (sort.equals(code.getVal())) {
						//sb.append(code.getName().replaceAll("\\p{Punct}|\\p{Space}", "_")).append("|");
						sbSortHeader.append("'").append(code.getName()).append(" : '||").append(getColumnMapping(code.getName())).append("||' / '||");
						sbQuerySort.append(getColumnMapping(code.getName())).append(",");
						break;
					}
				}
			}
			if (0<=sbSortHeader.indexOf("||' / '||")) {
				sbSortHeader.delete(sbSortHeader.length()-9, sbSortHeader.length());
			}
			if (0<=sbQuerySort.indexOf(",")) {
				sbQuerySort.delete(sbQuerySort.length()-1, sbQuerySort.length());
			}
			event.getGrpBlPrtInVO().setSortHeader(sbSortHeader.toString());  //orderby_title
			event.getGrpBlPrtInVO().setQuerySort(sbQuerySort.toString());  //order by
			cVo = command.searchBkgListForGrpBlPr(event.getGrpBlPrtInVO());
			grpBlPrt = cVo.getGrpBlPrts();
			eventResponse.setRsVoList(codeList);
			eventResponse.setRsVoList(grpBlPrt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * hard coding column for sort by CD02347 Code<br>
	 * CD02347 INTG_CD_VAL_DP_DESC : column alias used by query(BLIssuanceDBDAOsearchBkgListForGrpBlPrRSQL)<br>
	 * 
	 * @author
     * @param String code
     * @return String
     * @exception Exception
	 */
	private String getColumnMapping(String code) throws Exception {
		String columnName = "";
		List<String[]> listCodeMap = new ArrayList<String[]>(42);
		listCodeMap.add(new String[]{"DATE"             ,"BKG_CRE_DT"    });
		listCodeMap.add(new String[]{"B/OFC"            ,"BKG_OFC_CD"    });
		listCodeMap.add(new String[]{"S/OFC"            ,"OB_SLS_OFC_CD" });
		listCodeMap.add(new String[]{"B/STF"            ,"DOC_USR_ID"    });
		listCodeMap.add(new String[]{"S/REP"            ,"OB_SREP_CD"    });
		listCodeMap.add(new String[]{"B.STS"            ,"BKG_STS_CD"    });
		listCodeMap.add(new String[]{"SHPR"             ,"SHIPPER"       });
		listCodeMap.add(new String[]{"CNEE"             ,"CONSIGNEE"     });
		listCodeMap.add(new String[]{"NTFY"             ,"NTFY"          });
		listCodeMap.add(new String[]{"FFDR"             ,"FFDR"          });

		listCodeMap.add(new String[]{"CMDT"             ,"COMMODITY"     });
		listCodeMap.add(new String[]{"R/TRM"            ,"RCV_TERM_CD"   });
		listCodeMap.add(new String[]{"D/TRM"            ,"DE_TERM_CD"    });
		listCodeMap.add(new String[]{"O.S/M"            ,"ORG_SVC"       });
		listCodeMap.add(new String[]{"D.S/M"            ,"DST_SVC"       });
		listCodeMap.add(new String[]{"O.S/R"            ,"BKG_ORG_ROUTE" });
		listCodeMap.add(new String[]{"D.S/R"            ,"BKG_DST_ROUTE" });
		listCodeMap.add(new String[]{"POR"              ,"POR_CD"        });
		listCodeMap.add(new String[]{"POL"              ,"POL_CD"        });
		listCodeMap.add(new String[]{"POD"              ,"POD_CD"        });

		listCodeMap.add(new String[]{"DEL"              ,"DEL_CD"        });
		listCodeMap.add(new String[]{"P/POL"            ,"SORT_PRE_POL"  });
		listCodeMap.add(new String[]{"P/POD"            ,"SORT_PRE_POD"  });
		listCodeMap.add(new String[]{"S/POL"            ,"SORT_POST_POL" });
		listCodeMap.add(new String[]{"S/POD"            ,"SORT_POST_POD" });
		listCodeMap.add(new String[]{"T.VVD"            ,"TRUNK_VVD"     });
		listCodeMap.add(new String[]{"Pre_V"            ,"SORT_PRE_VVD"  });
		listCodeMap.add(new String[]{"Pst_V"            ,"SORT_POST_VVD" });
		listCodeMap.add(new String[]{"LANE"             ,"BKG_LANE"      });
		listCodeMap.add(new String[]{"T/POL"            ,"TRUNK_POL"     });

		listCodeMap.add(new String[]{"T/POD"            ,"TRUNK_POD"     });
		listCodeMap.add(new String[]{"BLSTF"            ,"OBL_ISS_USR_ID"});
		listCodeMap.add(new String[]{"BLOFC"            ,"OBL_ISS_OFC_CD"});
		listCodeMap.add(new String[]{"C.TP"             ,"BKG_CGO_TP"    });
		listCodeMap.add(new String[]{"B.AGT"            ,"CHINA_AGENT_CD"});
		listCodeMap.add(new String[]{"POR EQ OFC"       ,"POR_EQ_OFC"    });
		listCodeMap.add(new String[]{"DEL EQ OFC"       ,"DEL_EQ_OFC"    });
		listCodeMap.add(new String[]{"SC NO"            ,"SC_NO"         });
		listCodeMap.add(new String[]{"MF-MANIFEST READY","MANIFEST"      });
		listCodeMap.add(new String[]{"FC-RATING"        ,"RATE"          });

		listCodeMap.add(new String[]{"CNEE NAME(by 20c)","CNEE_NAME"     });
		listCodeMap.add(new String[]{"SHPR NAME(by 20c)","SHPR_NAME"     });
		for (String[] arr : listCodeMap) {
			if (code.equals(arr[0])) {
				columnName = arr[1];
				break;
			}
		}
		return columnName;
	}

	/**
     * checking container confirm status in case Partial Container Booking is same VVD and container No.(ESM_BKG_0079_04)<br>
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPartialConfirm(Event e) throws EventException {
        EsmBkg007904Event event = (EsmBkg007904Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

        String bkgNo = event.getBkgNo();
        String cntrNo = event.getCntrNo();
        log.debug(">>>>>>Bkg : " + bkgNo);
        log.debug(">>>>>>Cntr: " + cntrNo);
        try {
            String flag = command.searchPartialConfirm(bkgNo, cntrNo);
            
            eventResponse.setETCData("PTL_CFRM_FLG", flag);
            
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
     * Master Container Damage Search(ESM_BKG_0079_04)<br>
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDamageMstContainer(Event e) throws EventException {
        EsmBkg007904Event event = (EsmBkg007904Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

        try {
        	
        	ContainerVO[] containerVOs = event.getContainerVOs();
        	if(containerVOs == null){
        		eventResponse.setETCData("DMG_FLG", "N");
        	}else{
        		String strValid = command.searchDamageMstContainer(containerVOs);
        		eventResponse.setETCData("DMG_FLG", strValid);
        	}
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }    
    
	/**
	 * container Info retrieve.(ESM_BKG_0079_04)
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchContainer(Event e) throws EventException {
		EsmBkg007904Event event = (EsmBkg007904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
		BLDocumentationBLBC bLDocumentationBLBC= new BLDocumentationBLBCImpl();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		try {
			// searchBkgBlNo
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* update on 2009.12.31 */
            String cgoTp = utilCmd.searchBkgCgoTp(bkgBlNoIN);
            if("P".equals(cgoTp)) {
                throw new EventException(new ErrorHandler("BKG00092", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> Cgargo Tpye : " + cgoTp);
            
            
			CntrInfoOutVO outVo = docCmd.searchContainer(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			// eventResponse.setRsVoList(list);
			CntrEtcInfoVO etcInfoVO = outVo.getCntrEtcInfo();
			List<CntrTpszQtyVO> tpszQtys = outVo.getCntrTpszQtys();
			CntrPkgWgtVO pkgWgts = outVo.getCntrPkgWgts();
			List<ContainerVO> containers = outVo.getCntrs();
			List<BkgCntrSealNoVO> cntrSealNos = outVo.getCntrSealNos();
			List<RataBkgQtyVO> rataBkgQtys = outVo.getRataBkgQtys();
			
			//search BKG_MLT_SHP
			List<BkgCntrShpVO> listBkgCntrShp = bLDocumentationBLBC.searchBkgCntrShp(event.getBkgNo());
			
			if (etcInfoVO != null && etcInfoVO.getBkgNo() != null) {
				eventResponse.setRsVoList(containers);
				eventResponse.setETCData(pkgWgts.getColumnValues());
                eventResponse.setETCData(etcInfoVO.getColumnValues());
				eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
	            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
				eventResponse.setETCData("obl_iss_flg", utilCmd.oblIssFlgCheck(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg()));
				eventResponse.setRsVoList(tpszQtys);
				eventResponse.setRsVoList(cntrSealNos);
				eventResponse.setRsVoList(rataBkgQtys);
				
				if(listBkgCntrShp != null && listBkgCntrShp.size()>0)	eventResponse.setETCData("mlt_shp_flg", "Y");
				else													eventResponse.setETCData("mlt_shp_flg", "N");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * container Info manage.(ESM_BKG_0079_04)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageContainer(Event e) throws EventException {

		EsmBkg007904Event event = (EsmBkg007904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		//BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		BlRatingBC rateCmd = new BlRatingBCImpl();
		ContainerMovementMgtBC ctmCmd = new ContainerMovementMgtBCImpl();
        BkgCopManageBC copCmd = new BkgCopManageBCImpl();
        CostAssignBC coaCmd = new CostAssignBCImpl();
        //BLIssuanceBC issuCmd = new BLIssuanceBCImpl();
		GeneralBookingReceiptBC receiptCmd = new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();

		// String bkgNo = event.getBkgNo();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		CntrEtcInfoVO cntrEtcInfoVO = event.getBkgEtcInfoVO();
		ContainerVO[] containerVOs = event.getContainerVOs();				//SHEET1
		BkgCntrSealNoVO[] bkgCntrSealNoVOs = event.getBkgCntrSealNoVOs();	//SHEET2
		CntrAdjVolVO[] cntrAdjVolVOs = event.getCntrAdjVolVOs();			//SHEET3
		HistoryTableVO historyTableVO = null;
        //BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
		boolean usaCstmsDownload = false;
		
		/* final confirm */
		//String evntDt = cntrEtcInfoVO.getEvntDt();
		String fnlCfmFlg = cntrEtcInfoVO.getFnlCfmFlg();
		String modifyFnlCfmFlg = cntrEtcInfoVO.getModifyFnlCfmFlg();
		String rcvTermCd = cntrEtcInfoVO.getRcvTermCd();
		
		/* shp_flg check */
		String shpFlg = cntrEtcInfoVO.getShpFlg();
		/* ucr_flg check */
		String ucrFlg = cntrEtcInfoVO.getUcrFlg();
		String cntrUCR = "";

		String uiId = "ESM_BKG_0079_04";
		String ediHldFlg		= "N";

        List<BkgCntrSealNoVO> updateSealVoList = null;
		List<BkgCntrSealNoVO> deleteSealVoList = null;
		List<ContainerVO> insertCntrList = null;
		List<ContainerVO> updateCntrList = null;
		List<ContainerVO> changeCntrList = null;
		List<ContainerVO> deleteCntrList = null;

		List<Map<String,Object>> copCallList = null;
		HistoryLineVO historyLineVO = null;
		ContainerVO containerVO = null;
		BkgDocProcSkdVO bkgDocProcSkdVO = null;
		String fnlCfmTp = null;

		try {
			begin();

			/* searchBkgBlNoVO */
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

			/* Validation 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪甕곌낑�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�뤃占� Break Bulk 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦룂�굲 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪鈺곤옙 Container Number 占쎈쐻占쎈윪占쎈츐占쎈쐻占쎈윥占쎌넅占쎈쐻占쎈윪�뤃占� 占쎈쐻占쎈윪占쎈�뉛옙�쐺獄쏆옓爾쎾뜝�럡�렊占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렓�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럩�쟼占쎈쐻�뜝占� */
			int bbLen = containerVOs == null ? 0 : containerVOs.length;
			
			CntrInfoOutVO outVo = docCmd.searchBbContainer(bkgBlNoVO.getBkgNo(), bbLen);
			List<ContainerVO> containers = outVo.getCntrs();
			for (int i = 0; i <bbLen; i++){
				if("BREAKBULK".equals(containerVOs[i].getCntrNo().toUpperCase())){
					if(null == containers && "".equals(containers)){
						throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
					}
					containerVOs[i].setCntrNo(containers.get(i).getCntrNo());
				}
			}
			/* Validate Container */
			copCallList = docCmd.validateContainer(cntrEtcInfoVO, containerVOs, fnlCfmFlg);
			if (null!=copCallList && 0<copCallList.size()) {
				for (Map<String,Object> map : copCallList) {
					containerVO = (ContainerVO)map.get("containerVO");
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
					if (null!=utilCmd.searchDocProcSkd(bkgDocProcSkdVO,(String)map.get("caFlg"))) {
						this.cancelContainerConfirm((String)map.get("bkgNo"), null);
					}
					//call cop
					copCmd.detachCntr((String)map.get("bkgNo"), (String)map.get("cntrNo"), (String)map.get("cntrPrtFlg"));
				}
			}

            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
            
			/* Change Screen Flag */
			//if ("Y".equals(bkgBlNoVO.getCaFlg())) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoVO);
			//}
			
			/* SealNo */
			int sealLen = bkgCntrSealNoVOs == null ? 0 : bkgCntrSealNoVOs.length;
			int idx1=0, idx2=0, idx3=0, idx4=0;
			for (int i = 0; i < sealLen; i++) {
				if ("D".equals(bkgCntrSealNoVOs[i].getIbflag())) {
					idx1++;
				} else if ("I".equals(bkgCntrSealNoVOs[i].getIbflag()) || "U".equals(bkgCntrSealNoVOs[i].getIbflag())) {
					idx2++;
				}
			}
			/* SealNo Change count */
			int idxSeal=0;
			for (int i = 0; i < sealLen; i++) {
				if ("D".equals(bkgCntrSealNoVOs[i].getIbflag())) {
					idxSeal++;
				} else if ("I".equals(bkgCntrSealNoVOs[i].getIbflag())){
					idxSeal++;
				} else if ("U".equals(bkgCntrSealNoVOs[i].getIbflag()) 
						&& (!bkgCntrSealNoVOs[i].getOldCntrSealNo().equals(bkgCntrSealNoVOs[i].getCntrSealNo()))){
					idxSeal++;
				}
			}
            updateSealVoList = new ArrayList<BkgCntrSealNoVO>(idx1);
			deleteSealVoList = new ArrayList<BkgCntrSealNoVO>(idx2);
			for (int i = 0; i < sealLen; i++) {
                log.debug("*** CntrSealNoVO - " + bkgCntrSealNoVOs[i].getIbflag() + " : " + bkgCntrSealNoVOs[i].getBkgNo() + " : " + bkgCntrSealNoVOs[i].getCntrNo());
				String ibflag = bkgCntrSealNoVOs[i].getIbflag();
				bkgCntrSealNoVOs[i].setCreUsrId(account.getUsr_id());
				bkgCntrSealNoVOs[i].setUpdUsrId(account.getUsr_id());
				if ("D".equals(ibflag)) {
					deleteSealVoList.add(bkgCntrSealNoVOs[i]);
				} else if ("I".equals(ibflag) || "U".equals(ibflag)) {
					updateSealVoList.add(bkgCntrSealNoVOs[i]);
				}
			}

			/* Container */
			int cntrLen = containerVOs == null ? 0 : containerVOs.length;
			for (int i = 0; i < cntrLen; i++) {
				if ("I".equals(containerVOs[i].getIbflag())) {
					idx1++;
				} else if ("U".equals(containerVOs[i].getIbflag())) {
					if (containerVOs[i].getCntrNoOld() == null || containerVOs[i].getCntrNoOld().equals("") || containerVOs[i].getCntrNoOld().equals(containerVOs[i].getCntrNo())) {
						idx2++;		//CNTR占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜쨌�뙼�봿留띰옙�쐻占쎈윥占쎌몗癲ル슣鍮뽳옙�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷⑨옙�쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥�룏占쎌굲�뜝�럩留놂옙�쎗占쎈즵占쎌굦占쎈뙕占쎈젿占쎌맶�뜝�럥�쐾�뜝�럥�젃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈괘�뜝�럥�맶�뜝�럥�쑅�뜝�럥�늸�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뿶�뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럥�맚�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥夷ⓨ뜝�럩�룯�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럡�떓 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌맲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈읁�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럡愿댐옙�쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
					} else {
						idx3++;		//CNTR占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜쨌�뙼�봿留띰옙�쐻占쎈윥占쎌몗癲ル슣鍮뽳옙�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷⑨옙�쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥�룏占쎌굲�뜝�럩留놂옙�쎗占쎈즵占쎌굦占쎈뙕占쎈젿占쎌맶�뜝�럥�쐾�뜝�럥�젃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈괘�뜝�럥�맶�뜝�럥�쑅�뜝�럥�늸�뜝�럥�맶�뜝�럥�쑅�뜝�럥�삓�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥裕싷옙�쐻占쎈윥�댚占썲뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈짗占쎌굲�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
					}
				} else if ("D".equals(containerVOs[i].getIbflag())) {
					idx4++;
				}
			}
			insertCntrList = new ArrayList<ContainerVO>(idx1);		//I
			updateCntrList = new ArrayList<ContainerVO>(idx2);		//U- CNTR no change
			changeCntrList = new ArrayList<ContainerVO>(idx3);		//U- CNTR change
			deleteCntrList = new ArrayList<ContainerVO>(idx4);		//D
			for (int i = 0; i < cntrLen; i++) {
                log.debug("*** ContainerVO - " + containerVOs[i].getIbflag() + " : " + containerVOs[i].getCntrNo() + " : " + containerVOs[i].getCntrNoOld());
				// ContainerVO containerVO = containerVOs[i];
				String ibflag = containerVOs[i].getIbflag();
				containerVOs[i].setCreUsrId(account.getUsr_id());
				containerVOs[i].setUpdUsrId(account.getUsr_id());
				if ("I".equals(ibflag)) {
					insertCntrList.add(containerVOs[i]);
				} else if ("U".equals(ibflag)) {
					if (containerVOs[i].getCntrNoOld() == null || containerVOs[i].getCntrNoOld().equals("") || containerVOs[i].getCntrNoOld().equals(containerVOs[i].getCntrNo())) {
						updateCntrList.add(containerVOs[i]);
					} else {
						changeCntrList.add(containerVOs[i]);
					}
				} else if ("D".equals(ibflag)) {
					deleteCntrList.add(containerVOs[i]);
				}
				
				//cntrUCR setting
				if("I".equals(ibflag)) {
					cntrUCR = containerVOs[i].getCntrNo();
				}else if("U".equals(ibflag)) {
					if (containerVOs[i].getCntrNoOld() == null || containerVOs[i].getCntrNoOld().equals("") || !containerVOs[i].getCntrNoOld().equals(containerVOs[i].getCntrNo())) {
						cntrUCR = containerVOs[i].getCntrNo();
					}
				}
				
			}
			
            /* Adjust Container Volumn */
			int adjLen = cntrAdjVolVOs == null ? 0 : cntrAdjVolVOs.length;
			for(int i=0;i<adjLen;i++){
			    log.debug("*** CntrAdjVolVO - " + cntrAdjVolVOs[i].getCntrNo() + " : " + cntrAdjVolVOs[i].getAdjVolQty());
                if("0".equals(cntrAdjVolVOs[i].getAdjVolQty())){
                    ContainerVO cntrVO = new ContainerVO();
                    cntrVO.setBkgNo(cntrAdjVolVOs[i].getBkgNo());
                    cntrVO.setCntrNo(cntrAdjVolVOs[i].getCntrNo());
                    //
                    deleteCntrList.add(cntrVO);
                }else {
                    //updateAdjVoList.add(cntrAdjVolVOs[i]);
                    BkgBlNoVO bkgNoVO = new BkgBlNoVO();
                    bkgNoVO.setBkgNo(cntrAdjVolVOs[i].getBkgNo());
                    
                    // Adjust Container Volumn
                    docCmd.modifyCntrVol(cntrAdjVolVOs[i], bkgBlNoVO.getCaFlg());
                    
                    //
                    BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                    docProcSkdVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
                    docProcSkdVO.setBkgNo(cntrAdjVolVOs[i].getBkgNo());
                    histCmd.manageDocProcess(docProcSkdVO, account);
                    
                    //histCmd.manageBookingHistory(uiId, oldHistoryTableVO, account);
                }
			}
            
			/* SealNo Delete */
			if (deleteSealVoList.size() > 0) {
				docCmd.removeCntrSealNo(deleteSealVoList, bkgBlNoVO.getCaFlg());
			}
			
			
			
			/* Container Delete */
			for (int i = 0; i < deleteCntrList.size(); i++) {
				containerVO = deleteCntrList.get(i);
				// 1. remove SealNo
				log.debug(">>>>>>removeCntrSealNo: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				docCmd.removeCntrSealNo(containerVO.getBkgNo(), containerVO.getCntrNo(), "", bkgBlNoVO.getCaFlg());
				// 2. remove Rate
				log.debug(">>>>>>removeCntrRate: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				rateCmd.removeCntrRateByCntr(containerVO.getBkgNo(), containerVO.getCntrNo(), "");
				// 3. remove Reference detail
				log.debug(">>>>>>removeReferenceDetailByCntr: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				receiptCmd.removeReferenceDetailByCntr(containerVO.getBkgNo(), containerVO.getCntrNo(), bkgBlNoVO.getCaFlg());
				// 4. remove Reference
				log.debug(">>>>>>removeReferenceByCntr: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				receiptCmd.removeReferenceByCntr(containerVO.getBkgNo(), containerVO.getCntrNo(), bkgBlNoVO.getCaFlg());
				// 5. remove Manifest
				log.debug(">>>>>>removeCntrMfDesc: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				docCmd.removeCntrMfDesc(containerVO.getBkgNo(), containerVO.getCntrNo(), bkgBlNoVO.getCaFlg());
				// 6. remove Container
				log.debug(">>>>>>removeCntr: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				docCmd.removeContainer(containerVO.getBkgNo(), containerVO.getCntrNo(), bkgBlNoVO.getCaFlg());

                // usaCstmsDownload
                if(!usaCstmsDownload){
                    usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoVO);
                }
                				
			}
	         
            /* Container Insert */
            if(insertCntrList.size() > 0){
                docCmd.manageContainer(insertCntrList, bkgBlNoVO.getCaFlg());

                // usaCstmsDownload
                if(!usaCstmsDownload){
                    usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoVO);
                }
             
            }
            
			/* Container Update */
			if(updateCntrList.size() > 0){
			    docCmd.manageContainer(updateCntrList, bkgBlNoVO.getCaFlg());
			}
			
			/* Update C/M by container wgt./meas. unit */
            String bkgWgtUtCd  = cntrEtcInfoVO.getBkgWgtUtCd();
            String bkgMeasUtCd = cntrEtcInfoVO.getBkgMeasUtCd();
            log.debug("$ bkgWgtUtCd  : " + bkgWgtUtCd);
            log.debug("$ bkgMeasUtCd : " + bkgMeasUtCd);
            docCmd.modiftyCmUnitByCntr(bkgBlNoVO.getBkgNo(), bkgWgtUtCd, bkgMeasUtCd, account, bkgBlNoVO.getCaFlg());
            
			
            /* in case of FNL_CFM_FLG = 'Y' and  RVC_TERM_CD = 'S' */
            log.debug(">>>>>>modifyBlByFinalCfm: fnlCfmFlg=" + fnlCfmFlg + ", rcvTermCd=" + rcvTermCd);
			if("Y".equals(fnlCfmFlg) && !"S".equals(rcvTermCd)) {
			    String blIssFlg = docCmd.searchBlIssFlg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			    /* in case of OBL_ISS_FLG != 'Y' */
			    log.debug(">>>>>>modifyBlByFinalCfm: blIssFlg=" + blIssFlg);
			    if(!"Y".equals(blIssFlg)){
	                docCmd.modifyBlByFinalCfm(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			    }
            }
			
			/* Container No. Changed */
			for (int i = 0; i < changeCntrList.size(); i++) {
				containerVO = changeCntrList.get(i);
				String cntrNo = containerVO.getCntrNo();
				String cntrNoOld = containerVO.getCntrNoOld();
				// 1. insert Container
				log.debug(">>>>>>insertCntr: " + bkgBlNoVO.getBkgNo() + " - " + cntrNo);
				log.debug(">>>>>>" + containerVO.getUpdUsrId());
				docCmd.insertContainer(containerVO, bkgBlNoVO.getCaFlg());
				// 2. change Reference Detail
				log.debug(">>>>>>changeReferenceDetailByCntr: " + cntrNo + " - " + cntrNoOld);
				receiptCmd.changeReferenceDetailByCntr(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld, bkgBlNoVO.getCaFlg());
				// 3. change Reference
				log.debug(">>>>>>changeReferenceByCntr: " + cntrNo + " - " + cntrNoOld);
				receiptCmd.changeReferenceByCntr(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld, bkgBlNoVO.getCaFlg());
				// 4. change Manifest
				log.debug(">>>>>>changeCntrMfDesc: " + cntrNo + " - " + cntrNoOld);
				docCmd.changeCntrMfDesc(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld, bkgBlNoVO.getCaFlg());
				// 5. change Rate
				log.debug(">>>>>>changeCntrRate: " + cntrNo + " - " + cntrNoOld);
				rateCmd.changeCntrRate(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld);
				// 6. remove SealNo
				log.debug(">>>>>>removeCntrSealNo: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				docCmd.removeCntrSealNo(bkgBlNoVO.getBkgNo(), cntrNoOld, "", bkgBlNoVO.getCaFlg());
				// 6. delete Container(Old)
				log.debug(">>>>>>removeCntr: " + cntrNo + " - " + cntrNoOld);
				log.debug(">>>>>>" + containerVO.getUpdUsrId());
				docCmd.removeContainer(bkgBlNoVO.getBkgNo(), cntrNoOld, bkgBlNoVO.getCaFlg());

                // usaCstmsDownload
                if(!usaCstmsDownload){
                    usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoVO);
                }
                
			}
			
			/* SealNo Merge */
			if (updateSealVoList.size() > 0) {
				docCmd.manageCntrSealNo(updateSealVoList, bkgBlNoVO.getCaFlg());
			}
			
			/* validate confrim */
			docCmd.validateContainerConfirm(cntrEtcInfoVO, containerVOs, fnlCfmFlg);

			/* Manage Credit Date */
			rateCmd.manageCrdDt(bkgBlNoVO.getBkgNo(), cntrEtcInfoVO.getCgoRcvDt(), bkgBlNoVO.getCaFlg());

			if ("N".equals(bkgBlNoVO.getCaFlg())) {
			    /* Interface TO SCE */
                log.debug("########## Cntr Detach ##########");
				for (int i = 0; i < deleteCntrList.size(); i++) {
				    // cop
                    //try{
				        String flgPartial = ("1".equals(deleteCntrList.get(i).getCntrPrtFlg())? "Y" : "N");   
				        utilCmd.addBkgLog("BKG_COP_DETACH", deleteCntrList.get(i).getBkgNo(),deleteCntrList.get(i).getCntrNo());
                        copCmd.detachCntr(deleteCntrList.get(i).getBkgNo(), deleteCntrList.get(i).getCntrNo(), flgPartial);
                    //}catch(Exception ex){
                    //    log.error(ex.getMessage(), ex);
                    //}                        
				}
                log.debug("########## Cntr Attach ##########");
				for (int i = 0; i < insertCntrList.size(); i++) {
				    // ctm
				    ctmCmd.updateCtmMvmtIrrFromBkg(insertCntrList.get(i).getCntrNo(), insertCntrList.get(i).getBkgNo());
				    // cop
				    //try{
                        String flgPartial = ("1".equals(insertCntrList.get(i).getCntrPrtFlg())? "Y" : "N");
                        utilCmd.addBkgLog("BKG_COP_ATTACH", insertCntrList.get(i).getBkgNo(),insertCntrList.get(i).getCntrNo());
				        copCmd.attachCntr(insertCntrList.get(i).getBkgNo(), insertCntrList.get(i).getCntrNo(), flgPartial);
										        
				    //}catch(Exception ex){
				    //    log.error(ex.getMessage(), ex);
				    //} 
                        
				}

				log.debug("########## Cntr Change ##########");
				for (int i = 0; i < changeCntrList.size(); i++) {
                    // ctm
                    ctmCmd.updateCtmMvmtIrrFromBkg(changeCntrList.get(i).getCntrNo(), changeCntrList.get(i).getBkgNo());
                    // cop
                    //try{
                        String flgPartial = ("1".equals(changeCntrList.get(i).getCntrPrtFlg())? "Y" : "N");  
                        copCmd.attachCntr(changeCntrList.get(i).getBkgNo(), changeCntrList.get(i).getCntrNo(), flgPartial);
                        // cop
                        copCmd.detachCntr(changeCntrList.get(i).getBkgNo(), changeCntrList.get(i).getCntrNoOld(), flgPartial);
                    //}catch(Exception ex){
                    //    log.error(ex.getMessage(), ex);
                    //}               
				}
				
				/* COA */
                CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
                coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
                coaBkgComIfVo.setCostSrcSysCd("BKG");
                coaBkgComIfVo.setIfRmk("Cntr Attach");
                coaBkgComIfVo.setCreUsrId(account.getUsr_id());
                coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
                coaCmd.modifyCoaCommonInterface(coaBkgComIfVo);
                
                /* 
                 * create container NO, Type by bkg_no
                 */
                PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();
                formanceCmd.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CN"); 

                /* Manage Doc Process */
                if ("Y".equals(modifyFnlCfmFlg)){
                    
                    //createDraftBlEdi
                    log.debug("########## Create Draft B/L EDI ##########");
//                    try {
//                        //issuCmd.createDraftBlEdi(dblEdiInVOs, account);
//                      DblEdiInVO dblEdiInVO = new DblEdiInVO();
//                      dblEdiInVO.setBkgNo(bkgBlNoVO.getBkgNo());
//                      dblEdiInVO.setEdiReceiveId("KLNETTCS");
//                      
//                      DblEdiInVO[] dblEdiInVOs = new DblEdiInVO[1];
//                      dblEdiInVOs[0] = dblEdiInVO;
//
//                      BackEndJobManager backEndJobManager = new BackEndJobManager(); 
//                      BLIssuanceDraftBlEdiBEImpl command = new BLIssuanceDraftBlEdiBEImpl();
//                      command.setDblEdiInVOs(dblEdiInVOs);
//                      command.setAccount(account);
//                     
//                      backEndJobManager.execute(command, account.getUsr_id(), "Create Draft B/L via EDI"); 
//                      log.debug("-> backend_job_key : OK");
//                    } catch(Exception ex) {
//                        log.error("issuCmd.createDraftBlEdi(dblEdiInVOs, account)", ex);
//                    }                   
                    
//                    log.debug("\n\n\n\n\n"+cntrEtcInfoVO.getPolCd().substring(0, 2)+"\n\n\n\n\n\n"+cntrEtcInfoVO.getPolCd().startsWith("KR", 0));
//                  if ("Y".equals(fnlCfmFlg) && "KR".equals(cntrEtcInfoVO.getPolCd().substring(0, 2))) {                    	
//                    DblEdiInVO dblEdiInVO = new DblEdiInVO();                   
//                    BLIssuanceBC issueCmd = new BLIssuanceBCImpl();                    
//                    List<BkgNtcHisVO> bkgNtcHisVOs = null;
//
//					dblEdiInVO.setBkgNo(bkgBlNoVO.getBkgNo());
//					dblEdiInVO.setEdiReceiveId("KLNETTCS");
////					dblEdiInVO.setGroupEdiId(custTpVO2.getGroupId());
//					DblEdiVO dblEdiVo=issueCmd.createDraftBlEdi(dblEdiInVO, account);
//					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(dblEdiVo.getFlatFileAckVOs().size());	
//					
//					// History
//					for(int j=0;j<dblEdiVo.getFlatFileAckVOs().size();j++){
//						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
//						bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
//						bkgNtcHisVO.setHisSeq(String.valueOf(j+1).toString());
//						bkgNtcHisVO.setNtcViaCd("E");
//						bkgNtcHisVO.setNtcKndCd("BL");
//						bkgNtcHisVO.setEdiId("KLNETTCS");
////						bkgNtcHisVO.setEsvcGrpCd(custTpVO2.getGroupId());
//						bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVo.getFlatFileAckVOs().get(j).getAckStsCd());
//						bkgNtcHisVO.setSndUsrId(account.getUsr_id());
//						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
//						bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
//						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
//						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
//						bkgNtcHisVOs.add(bkgNtcHisVO);
//					}
//					
//					if(bkgNtcHisVOs!=null){
//						if(bkgNtcHisVOs.size()>0){
//							histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
//						}
//					}
//                }
                    
                    
                    //confirmCntr
                    log.debug("########## Confirm Container ##########");
//                    try {
                          copCmd.confirmCntr(bkgBlNoVO.getBkgNo());
//                    } catch(Exception ex) {
//                        log.error("copMgt.confirmCntr(bkgBlNoVO.getBkgNo())", ex);
//                    }
                } // IF : "Y".equals(modifyFnlCfmFlg)
				
			} // IF : "N".equals(bkgBlNoVO.getCaFlg())

			if ("Y".equals(modifyFnlCfmFlg)){
                
				// HistoryLine
				log.debug("########## History Line ##########");
				fnlCfmTp = "Y".equals(fnlCfmFlg) ? "Container Final Confirm" : "Cancel Container Final Confirm";

				historyLineVO = new HistoryLineVO();
//				historyLineVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
				historyLineVO.setCrntCtnt(account.getUsr_id() + "/" + fnlCfmTp);
				historyLineVO.setPreCtnt(" ");
				historyLineVO.setHisCateNm("F.CFM");
				historyLineVO.setLocalTime("");
				historyLineVO.setUiId(uiId);
				histCmd.createBkgHistoryLine(historyLineVO, account);

                // manageDocProcess
                log.debug("########## Manage Doc Process ##########");
                BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                docProcSkdVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
                docProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
                histCmd.manageDocProcess(docProcSkdVO, account);    
			}
	         
            /* Distribute Contaner Charge */
            if(!"X".equals(bkgBlNoVO.getBkgStsCd()) && !"Y".equals(bkgBlNoVO.getCaFlg())) {
                rateCmd.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);         
            }
            /* modifyShpFlg */
            if("Y".equals(shpFlg)){
            	docCmd.modifyShpFlg(bkgBlNoVO.getBkgNo(), account);
            }
            /* modifyUCR NO update */
            String ediFlg = "";
            if("Y".equals(ucrFlg) && !"".equals(cntrUCR)){
            	BkgRefDtlVO bkgRefDtlVO = new BkgRefDtlVO();
            	bkgRefDtlVO.setBkgNo(bkgBlNoVO.getBkgNo());
            	bkgRefDtlVO.setCntrNo(cntrUCR);
            	
            	log.debug("$ cntrUCR : " + cntrUCR);
            	ediFlg = receiptCmd.modifyCntrNoUCR(bkgRefDtlVO, account);
//            	ediFlg = "Y";
            	log.debug("$ UCR ediFlg : " + ediFlg);
//            	if("Y".equals(ediFlg)){
//    				Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
//    				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
//    				vender301ParamVO.setOldVvdVOs(null);
//    				vender301ParamVO.setOldQtyVOs(null);
//    				vender301ParamVO.setOldMtyPkupYdCd(null);
//    				vender301ParamVO.setBracCd("U");
//    				vender301ParamVO.setEdiKind("BT");
//    				vender301ParamVO.setAutoManualFlg("N");
//    				vender301ParamVO.setRcvId("");
//    		    	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);   
//    		    	histCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
//            	}
            }
            ediHldFlg = utilCmd.searchVenderEdiBkg(bkgBlNoVO.getBkgNo());
            /* EDI  */
            if("Y".equals(ediHldFlg) && ("Y".equals(ediFlg) || idxSeal>0)){
				log.debug("########## createTmlBkgReceiptEdi EDI ( modify UCR OR change seal no ) ##########");
				log.debug("########## modifyCntrNoUCR ( " + ediFlg + " ) idxSeal ( "+idxSeal+" )  ##########");
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
//				vender301ParamVO.setBracCd("U");
				vender301ParamVO.setEdiKind("BT");
				vender301ParamVO.setAutoManualFlg("N");
				vender301ParamVO.setRcvId("");
		    	List<BkgNtcHisVO> bkgNtcHisVOs = genSearchCmd.createTmlBkgReceiptEdi(vender301ParamVO, account);   
		    	histCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());

            }
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
			/* Set Message */
            eventResponse.setETCData("USA_CSTMS_DOWNLOAD", String.valueOf(usaCstmsDownload));
			eventResponse.setUserMessage("");
			commit();
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
	 * Container Confirm Cancel.(ESM_BKG_0079_04)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse cancelContainerConfirm(Event e) throws EventException {
		EsmBkg007904Event event = (EsmBkg007904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			this.cancelContainerConfirm(event.getBkgNo(), event.getBlNo());
			eventResponse.setUserMessage("");
			commit();
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
	 * CNTR IRR(ESM_BKG_0079_04)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyCrdDt(Event e) throws EventException {
		EsmBkg007904Event event = (EsmBkg007904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BLDocumentationCMBC docCmd = null;
		try {
			begin();
	        docCmd = new BLDocumentationCMBCImpl();
			docCmd.modifyCrdDt(event.getContainerVOs(), event.getBkgEtcInfoVO().getCorrFlg(), account);
			eventResponse.setUserMessage("");
			commit();
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
	 * Container Confirm Cancel.<br>
	 * 
	 * @author
     * @param String bkgNo
	 * @param String blNo
     * @exception Exception
	 */
	private void cancelContainerConfirm(String bkgNo, String blNo) throws Exception {
		String uiId = "ESM_BKG_0079_04";
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

		log.debug("=================>"+bkgNo);
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
	 * copying container to another booking.(ESM_BKG_0170)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
    private EventResponse copyContainer(Event e) throws EventException {
        EsmBkg0170Event event = (EsmBkg0170Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
        SpecialCargoReceiptBC spclCmd = new SpecialCargoReceiptBCImpl();
        GeneralBookingReceiptBC receiptCmd = new GeneralBookingReceiptBCImpl();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BkgCopManageBC copCmd = new BkgCopManageBCImpl();
        CostAssignBC coaCmd = new CostAssignBCImpl();

        String orgBkgNo = event.getBkgNo();
        String orgCntrNo = event.getCntrNo();
        String orgCntrVol = event.getCntrVol();
        CntrCopyVO[] cntrCopyVOs = event.getCntrCopyVOs();
        boolean usaCstmsDownload = false;
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(orgBkgNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        BkgBlNoVO bkgBlNoOut = null;
        CntrCopyVO orgCntrCopyVO = null;
        HistoryTableVO historyTableVO = null;
        HistoryLineVO historyLineVO = null;

        String uiId = "ESM_BKG_0170";

        try {
            begin();
            /* searchBkgBlNoVO */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{orgBkgNo}).getMessage());
            }
            String stsCd = bkgBlNoVO.getBkgStsCd();
            String caFlg = bkgBlNoVO.getCaFlg();
            log.debug("##########> BKG_STATUS : " + orgBkgNo + " - " + stsCd);
            if(stsCd != null && stsCd.equals("X")) {
                throw new EventException(new ErrorHandler("BKG00113", new String[]{orgBkgNo}).getMessage());
            }

            int cnt = (cntrCopyVOs == null) ? 0 : cntrCopyVOs.length;
            log.debug("##########> Target Booking Count : " + cnt);
            for(int i = 0; i < cnt; i++) {
                if(cntrCopyVOs[i] == null || cntrCopyVOs[i].getTgtBkgNo() == null){
                    continue;
                }                
                cntrCopyVOs[i].setCreUsrId(account.getUsr_id());
                cntrCopyVOs[i].setUpdUsrId(account.getUsr_id());
                cntrCopyVOs[i].setOfcCd(account.getOfc_cd());
                cntrCopyVOs[i].setCntrNo(orgCntrNo);
                cntrCopyVOs[i].setSrcBkgNo(orgBkgNo);
                cntrCopyVOs[i].setSrcCntrVol(orgCntrVol);

                log.debug("##########> Origin Booking : " + cntrCopyVOs[i].getOriginFlg());
                //if("Y".equals(cntrCopyVOs[i].getOriginFlg())){
                //    cntrCopyVOs[i].setCaFlg(caFlg);
                //    orgCntrCopyVO = cntrCopyVOs[i];
                //}else{
                    cntrCopyVOs[i].setCaFlg("N");

                    /* Search Booking History */
                    bkgBlNoIN.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
            		bkgBlNoIN.setCaUsrId(account.getUsr_id());
                    bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                    historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOut);

                    // copy Container
                    docCmd.copyContainer(cntrCopyVOs[i]);
                    // copy Special Cargo
                    spclCmd.copySpclCgoByCntr(cntrCopyVOs[i], "C");
                    // copy Reference
                    receiptCmd.copyBkgRefByCntr(cntrCopyVOs[i]);
                    reRequestSpclCgoApproval(bkgBlNoOut);
                    // change Booking Status
                    receiptCmd.changeBkgStatus("Y", bkgBlNoOut, false, account);

                    // usaCstmsDownload
                    if(!usaCstmsDownload){
                        usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoOut);
                    }
                    
                    // cop
                    //try {
                        String flgPartial = ("1".equals(orgCntrVol)) ? "N" : "Y";
                        copCmd.attachCntr(cntrCopyVOs[i].getTgtBkgNo(), cntrCopyVOs[i].getCntrNo(), flgPartial);
                    //} catch(Exception ex) {
                    //    log.error(ex.getMessage(), ex);
                    //}

                    // coa
                    log.debug("##########> COA - Copy Container : " + cntrCopyVOs[i].getTgtBkgNo());
                    CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
                    coaBkgComIfVo.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    coaBkgComIfVo.setCostSrcSysCd("BKG");
                    coaBkgComIfVo.setIfRmk("Copy Container");
                    coaBkgComIfVo.setCreUsrId(cntrCopyVOs[i].getCreUsrId());
                    coaBkgComIfVo.setUpdUsrId(cntrCopyVOs[i].getUpdUsrId());
                    coaCmd.modifyCoaCommonInterface(coaBkgComIfVo);
                    
                    /* Manage Booking History */
                    histCmd.manageBookingHistory(uiId, historyTableVO, account);
                                                  
                //}

                //
                String curr_cfm_flg = docCmd.searchDocProcessByCntr(cntrCopyVOs[i].getTgtBkgNo(), "N");
                log.debug("##########> curr_cfm_flg : " + curr_cfm_flg);
                if("Y".equals(curr_cfm_flg)){
                    /* Manage Booking History */
                    historyLineVO = new HistoryLineVO();
                    historyLineVO.setBkgDocProcTpCd("CNTRLS");
                    historyLineVO.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    historyLineVO.setCaFlg("N");
                    historyLineVO.setCrntCtnt(orgCntrNo + "/ copied from " + cntrCopyVOs[i].getSrcBkgNo());
                    historyLineVO.setHisCateNm("");
                    historyLineVO.setLocalTime("");
                    historyLineVO.setUiId(uiId);
                    histCmd.createBkgHistoryLine(historyLineVO, account);
                }

            }
            
            // origine container
            //if(orgCntrCopyVO != null){
                
                orgCntrCopyVO = new CntrCopyVO();
                orgCntrCopyVO.setCntrNo(orgCntrNo);
                orgCntrCopyVO.setSrcBkgNo(orgBkgNo);
                orgCntrCopyVO.setSrcCntrVol(orgCntrVol);
                orgCntrCopyVO.setTgtCntrVol(orgCntrVol);
                orgCntrCopyVO.setCaFlg(caFlg);
                orgCntrCopyVO.setCreUsrId(account.getUsr_id());
                orgCntrCopyVO.setUpdUsrId(account.getUsr_id());
                

                /* Search Booking History */
                bkgBlNoIN.setBkgNo(orgCntrCopyVO.getSrcBkgNo());
        		bkgBlNoIN.setCaUsrId(account.getUsr_id());
                bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOut);

                // modify Volumn
                docCmd.modifyCntrVol(orgCntrCopyVO);

                // coa
                log.debug("##########> COA - Copy Container : " + orgCntrCopyVO.getSrcBkgNo());
                CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
                coaBkgComIfVo.setBkgNo(orgCntrCopyVO.getSrcBkgNo());
                coaBkgComIfVo.setCostSrcSysCd("BKG");
                coaBkgComIfVo.setIfRmk("Copy Container");
                coaBkgComIfVo.setCreUsrId(orgCntrCopyVO.getCreUsrId());
                coaBkgComIfVo.setUpdUsrId(orgCntrCopyVO.getUpdUsrId());
                coaCmd.modifyCoaCommonInterface(coaBkgComIfVo);
                
                /* Manage Booking History */
                histCmd.manageBookingHistory(uiId, historyTableVO, account);
                                
            //}

            /* Set Message */
            eventResponse.setETCData("USA_CSTMS_DOWNLOAD", String.valueOf(usaCstmsDownload));
            eventResponse.setUserMessage("");
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
	 * moving container info to another booking.(ESM_BKG_0170)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse moveContainer(Event e) throws EventException {
        EsmBkg0170Event event = (EsmBkg0170Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
        SpecialCargoReceiptBC spclCmd = new SpecialCargoReceiptBCImpl();
        GeneralBookingReceiptBC receiptCmd = new GeneralBookingReceiptBCImpl();
        BlRatingBC rateCmd = new BlRatingBCImpl();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BkgCopManageBC copCmd = new BkgCopManageBCImpl();
        CostAssignBC coaCmd = new CostAssignBCImpl();
        ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC = new ReceiveOwnBkgCancelRequestMgtBCImpl();
        WorkOrderIssueBC		trsBC		= new WorkOrderIssueBCImpl();

        String orgBkgNo = event.getBkgNo();
        String orgCntrNo = event.getCntrNo();
        String orgCntrVol = event.getCntrVol();
        CntrCopyVO[] cntrCopyVOs = event.getCntrCopyVOs();
        boolean usaCstmsDownload = false;
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(orgBkgNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        BkgBlNoVO tgtBkgBlNoOut = null;
        BkgBlNoVO srcBkgBlNoOut = null;
        CntrCopyVO orgCntrCopyVO = null;
        HistoryTableVO historyTableVO = null;
        HistoryLineVO historyLineVO = null;

        String uiId = "ESM_BKG_0170";
        String spclCargoCopyCd = "M";

        try {
            begin();
            /* searchBkgBlNoVO */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{orgBkgNo}).getMessage());
            }
            String stsCd = bkgBlNoVO.getBkgStsCd();
            String caFlg = bkgBlNoVO.getCaFlg();
            log.debug("##########> BKG_STATUS : " + orgBkgNo + " - " + stsCd);
            if(stsCd != null && stsCd.equals("X")) {
                throw new EventException(new ErrorHandler("BKG00113", new String[]{orgBkgNo}).getMessage());
            }
            
            //keep VVD information for DG cancel about source BKG
			List<SearchDgCancelInfoVO> dgCancelInfoBefore = null;
			dgCancelInfoBefore = spclCmd.searchDgCancelInfo(orgBkgNo);
			
            int cnt = (cntrCopyVOs == null) ? 0 : cntrCopyVOs.length;
            /* target booking */
            String[] targetBkg = new String[cnt];
            int targetBkgIdx = 0;
            
            log.debug("##########> Target Booking Count : " + cnt);
            for(int i = 0; i < cnt; i++) {
                if(cntrCopyVOs[i] == null || cntrCopyVOs[i].getTgtBkgNo() == null) {
                    continue;
                }
                cntrCopyVOs[i].setCreUsrId(account.getUsr_id());
                cntrCopyVOs[i].setUpdUsrId(account.getUsr_id());
                cntrCopyVOs[i].setOfcCd(account.getOfc_cd());
                cntrCopyVOs[i].setCntrNo(orgCntrNo);
                cntrCopyVOs[i].setSrcBkgNo(orgBkgNo);
                cntrCopyVOs[i].setSrcCntrVol(orgCntrVol);

                log.debug("##########> Origin Booking : " + cntrCopyVOs[i].getOriginFlg());
                //if("Y".equals(cntrCopyVOs[i].getOriginFlg())){
                //    cntrCopyVOs[i].setCaFlg(caFlg);
                //    orgCntrCopyVO = cntrCopyVOs[i];
                //}else{
                    cntrCopyVOs[i].setCaFlg("N");

                    /* Search Booking History */
                    bkgBlNoIN.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    tgtBkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                    historyTableVO = histCmd.searchOldBkgForHistory(uiId, tgtBkgBlNoOut);

                    // copy Container
                    docCmd.copyContainer(cntrCopyVOs[i]);
                    // copy Special Cargo
//                    spclCmd.copySpclCgoByCntr(cntrCopyVOs[i], "M");
                    //To use existing DG Ref No, set "M" only for first container
                    if(i > 0){
                    	spclCargoCopyCd = "C";
                    }
                    spclCmd.copySpclCgoByCntr(cntrCopyVOs[i], spclCargoCopyCd);
                    // copy Reference
                    receiptCmd.copyBkgRefByCntr(cntrCopyVOs[i]);
                    // delete change Booking Status
//                    receiptCmd.changeBkgStatus("Y", tgtBkgBlNoOut, false, account);
                    // usaCstmsDownload
                    if(!usaCstmsDownload){
                        usaCstmsDownload = utilCmd.searchUsaCstmsDownload(tgtBkgBlNoOut);
                    }
                    
                    // cop
                    targetBkg[targetBkgIdx++] = cntrCopyVOs[i].getTgtBkgNo();
                    //try {
//                        log.debug("##########> COP - attachCntr : " + cntrCopyVOs[i].getTgtBkgNo());
//                        String flgPartial = ("1".equals(cntrVol)) ? "N" : "Y";
//                        copCmd.attachCntr(cntrCopyVOs[i].getTgtBkgNo(), cntrCopyVOs[i].getCntrNo(), flgPartial);
                    //} catch(Exception ex) {
                    //    log.error(ex.getMessage(), ex);
                    //}
                 
                    // coa
                    log.debug("##########> COA - Move Container : " + cntrCopyVOs[i].getTgtBkgNo());
                    CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
                    coaBkgComIfVo.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    coaBkgComIfVo.setCostSrcSysCd("BKG");
                    coaBkgComIfVo.setIfRmk("Move Container");
                    coaBkgComIfVo.setCreUsrId(cntrCopyVOs[i].getCreUsrId());
                    coaBkgComIfVo.setUpdUsrId(cntrCopyVOs[i].getUpdUsrId());
                    coaCmd.modifyCoaCommonInterface(coaBkgComIfVo);
                    
                    /* Manage Booking History */
                    histCmd.manageBookingHistory(uiId, historyTableVO, account);

                //}
                
                /* Manage Booking History */
                String curr_cfm_flg = docCmd.searchDocProcessByCntr(cntrCopyVOs[i].getTgtBkgNo(), "N");
                log.debug("##########> curr_cfm_flg : " + curr_cfm_flg);
                if("Y".equals(curr_cfm_flg)){
                    historyLineVO = new HistoryLineVO();
                    historyLineVO.setBkgDocProcTpCd("CNTRLS");
                    historyLineVO.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    historyLineVO.setCaFlg("N");
                    historyLineVO.setCrntCtnt(orgCntrNo + "/ copied from " + cntrCopyVOs[i].getSrcBkgNo());
                    historyLineVO.setHisCateNm("");
                    historyLineVO.setLocalTime("");
                    historyLineVO.setUiId(uiId);
                    histCmd.createBkgHistoryLine(historyLineVO, account);
                }
               
            }
            // remove origin container
            //if(orgCntrCopyVO != null){
            
                orgCntrCopyVO = new CntrCopyVO();
                orgCntrCopyVO.setCntrNo(orgCntrNo);
                orgCntrCopyVO.setSrcBkgNo(orgBkgNo);
                orgCntrCopyVO.setSrcCntrVol(orgCntrVol);
                orgCntrCopyVO.setTgtCntrVol(orgCntrVol);
                orgCntrCopyVO.setCaFlg(caFlg);
                orgCntrCopyVO.setCreUsrId(account.getUsr_id());
                orgCntrCopyVO.setUpdUsrId(account.getUsr_id());
                
                /* Search Booking History */
                bkgBlNoIN.setBkgNo(orgCntrCopyVO.getSrcBkgNo());
                srcBkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                historyTableVO = histCmd.searchOldBkgForHistory(uiId, srcBkgBlNoOut);

                // remove special cargo
                spclCmd.removeSpclCgoByCntr(orgCntrCopyVO.getSrcBkgNo(), orgCntrCopyVO.getCntrNo(), "");
                // remove reference
                receiptCmd.removeBkgRefByCntr(orgCntrCopyVO.getSrcBkgNo(), orgCntrCopyVO.getCntrNo(), "N");
                // remove conatainer rate
                rateCmd.removeCntrRateByCntr(orgBkgNo, orgCntrNo, "");
                // remove container
                docCmd.moveContainer(orgCntrCopyVO.getSrcBkgNo(), orgCntrCopyVO.getCntrNo(), caFlg);
                // delete Booking Status
//                receiptCmd.changeBkgStatus("Y", srcBkgBlNoOut, false, account);
                
                /* Manage Booking History */
                histCmd.manageBookingHistory(uiId, historyTableVO, account);
                
				//call cancel DG
				if(dgCancelInfoBefore.size()>0){
					//check DG again
					List<SearchDgCancelInfoVO> dgCancelInfoAfter = null;
					dgCancelInfoAfter = spclCmd.searchDgCancelInfo(orgBkgNo);
					if(dgCancelInfoAfter.size() < 1){
						//call spc module to tell DG cancel
						List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
						spclCmd.manageDgDgCancel(dgCancelInfoBefore, account, scgVvdDgCgoCxlRqstVOs, "Container Move");
						bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
					}
				}
				
                // usaCstmsDownload
                if(!usaCstmsDownload){
                    usaCstmsDownload = utilCmd.searchUsaCstmsDownload(srcBkgBlNoOut);
                }
                
                // cop
                copCmd.moveCntr(orgCntrCopyVO.getSrcBkgNo(), targetBkg, orgCntrCopyVO.getCntrNo());
                //try {
                    log.debug("##########> COP - detachCntr : " + orgCntrCopyVO.getSrcBkgNo());
//                    String flgPartial = ("1".equals(cntrVol)) ? "N" : "Y";
//                    copCmd.detachCntr(orgCntrCopyVO.getSrcBkgNo(), orgCntrCopyVO.getCntrNo(), flgPartial);
                //} catch(Exception ex) {
                //    log.error(ex.getMessage(), ex);
                //}
                reRequestSpclCgoApproval(tgtBkgBlNoOut);
                reRequestSpclCgoApproval(srcBkgBlNoOut);
                // COA
                log.debug("##########> COA - Move Container : " + orgCntrCopyVO.getSrcBkgNo());
                CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
                coaBkgComIfVo.setBkgNo(orgCntrCopyVO.getSrcBkgNo());
                coaBkgComIfVo.setCostSrcSysCd("BKG");
                coaBkgComIfVo.setIfRmk("Move Container");
                coaBkgComIfVo.setCreUsrId(orgCntrCopyVO.getCreUsrId());
                coaBkgComIfVo.setUpdUsrId(orgCntrCopyVO.getUpdUsrId());
                coaCmd.modifyCoaCommonInterface(coaBkgComIfVo);
                
                //TRS 
                int targetCnt = (cntrCopyVOs == null) ? 0 : cntrCopyVOs.length;
                int targetBkgsIdx = 0;
                String[] targetBkgs = new String[targetCnt];
                for(int i = 0; i < targetCnt; i++) {
                    if(cntrCopyVOs[i] == null || cntrCopyVOs[i].getTgtBkgNo() == null) {
                        continue;
                    }
                targetBkgs[targetBkgsIdx++] = cntrCopyVOs[i].getTgtBkgNo();
                }
                /* target booking */
                
                log.debug("##########> TRS Changemanagement");
                if(null != targetBkgs && targetBkgs.length > 0 ){
                	trsBC.updateShipmentCm(targetBkgs);
                }

            /* Set Message */
            eventResponse.setETCData("USA_CSTMS_DOWNLOAD", String.valueOf(usaCstmsDownload));
            eventResponse.setUserMessage("");
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
	 * ESM_BKG_0361_01~06 : retrieve event process.<br>
	 * Export / Import Information by country retrieve event process.(ESM_BKG_0361_01)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchExportImportNumber(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg036101Event event = (EsmBkg036101Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();
		BookingUtil utilCmd = new BookingUtil();

		String bkgNo = event.getBkgNo();
		String ioBndCd = event.getIoBndCd();
		String cntCd = event.getCntCd();
		String popUpTpCd = event.getPopUpTpCd();
		String xterSndrId = event.getXterSndrId();
		String xterRqstNo = event.getXterRqstNo();
		String xterRqstSeq = event.getXterRqstSeq();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(bkgNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
		BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
		
		XptImpLicInVO xptImpLicIn = new XptImpLicInVO();
		xptImpLicIn.setBkgNo(bkgNo);
		xptImpLicIn.setIoBndCd(ioBndCd);
		xptImpLicIn.setCntCd(cntCd);
		xptImpLicIn.setPopuptpcd(popUpTpCd);
		xptImpLicIn.setXterSndrId(xterSndrId);
		xptImpLicIn.setXterRqstNo(xterRqstNo);
		xptImpLicIn.setXterRqstSeq(xterRqstSeq);

		BookingUtil comboUtil = new BookingUtil();
		try {
			List<XptImpLicVO> list = command.searchExportImportNumber(xptImpLicIn, bkgBlNoVO.getCaFlg());
			eventResponse.setRsVoList(list);
			if ("US".equalsIgnoreCase(event.getCntCd())) {
				List<BkgComboVO> aes_expt_id = comboUtil.searchCombo("CD02570");
				eventResponse.setRsVoList(aes_expt_id);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0361_01~06 : Insert, Modify, Delete<br>
	 * Export / Import Information by country insert(update,delete) event process.(ESM_BKG_0361_01)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageExportImportNumber(Event e) throws EventException {

		EsmBkg036101Event event = (EsmBkg036101Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();

		XptImpLicVO[] xptImpLicVOs = event.getXptImpLicVOs();

		HistoryTableVO hisTblVO = new HistoryTableVO();
		BkgReferenceVO refVO = new BkgReferenceVO();
		hisTblVO.setBkgReferenceVO(refVO);
		HistoryTableVO historyTableVO = null;

		String bkgNo = event.getBkgNo();
		String cntCd = event.getCntCd();
		String pkgTpCd = event.getPkgTp();
		String uiId = "ESM_BKG_0361";

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(bkgNo);
		String webId = ""; // EAI I/F �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥�뙴�뮋�삕占쎌맶�뜝�럥�쑅鶯ㅼ룆占쏙퐢�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈�λ돗�뜝�럩�뮛�뜝�럥裕싷옙�쐻占쎈윥占쎈㎞�뜝�럥�맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅占쎈쑏占쎈퉯�떋�띿삕�몭�궪�삕占쎄뎡�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� BKGWeb0060001WSProxy �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄ゅ뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋占쎌젂占쎈뼇占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�걨占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒱占쎈쭒嶺뚣끇�꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윻�뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎌넁�뜝�뜦維�占쎈뮛�뜝�럩沅ⓨ뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅嶺뚯빘猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎈뙀占쎈엠占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�뮋�뜝�럥堉붹뤆�룊�삕�뜝�럡愿닷뜝�럥�맶�뜝�럥�몞占쎈뙀占쎈쐣占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썩뫁占썲뜝�럡�뀷占쎄덩占쎄�椰꾟댙�삕�젆�먯삕占쎄뎡�뜝�럥鍮앾옙�쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥�댆臾덈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊筌ㅻ낑�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼇�븶占쎄덩占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄괼占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈군占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類㏃삕占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�굛�ｏ옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅占쎈쐻占쎈윥占쎈룈�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈쟿癲ル슢��泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡�뒋占쎈닱占쎈쐞占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅勇싲즾維낉옙�굲�뜝�럥占썲뜝�럡肄э옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌앸쑚�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥�걤�뜝�럡�븫�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎄섈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌앹룞�삕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎄틟�뜝�럩援뀐옙�쐻占쎈윪占쎌쓠�뜝�럥�맶�뜝�럥�쑅嶺뚯빖諭띰옙�맶�뜝�럥�쑋占쎈쨨�뜝�룞�삕占쎌맶�뜝�럥�쑅�뜝�럩�꼪�뜝�럥�맶�뜝�럥�쑅�뜝�럩二멨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럡肄욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
		String porCd = ""; // date �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊�굢�룇�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥利쏙옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅占쎈쐻占쎈윥�뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�뀵�뜝�럥�맶�뜝�럥�쑅占쎈뙀占쎈엠占쎌맶�뜝�럥�쑋占쎈쨨饔낅똻�쐪占쎈쐻占쎈쑟占쎌뇢�뜝�럥�뿭�뜝�럡�돟�뜝�럥�맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럡�떐�뜝�럥�늾占쎈쇊占쎈늄揶쏅틹異�占쎈퉾獄��씛�삕占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥塋딅�ｋ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾占쎈닱占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럥�읈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥泥뗥뜝�럥�럸占쎈쐻占쎈짗占쎌굲占쎈뙀�뜝�뜴�쐻占쎈윥�뜝�룞�삕占쎌맶�뜝�럥�쑋占쎌뼲�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럡肄ｏ옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌젶�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� POR �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윪筌띾쑚�쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
		
		//EAI I/F�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎄슈占쎄섶占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈콦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌겲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛筌��맮�삕占쎌��윜諛잙쳛占쎄뎡�뜝�럥夷⑨옙�쐻�뜝占� account �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥�댆臾덈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊筌ㅻ낑�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼇�븶占쎄덩占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥彛ⓨ뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧筌ㅻØ�쇀占쎌돸占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
		if (account != null && account.getUsr_id() != null){
			bkgBlNoIN.setCaUsrId(account.getUsr_id());
		}
		else { 
			bkgBlNoIN.setCaUsrId("WEB");
		}
		
		BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);

		XptImpLicVO xptImpLicVO = new XptImpLicVO();
		xptImpLicVO.setPckTpCd(pkgTpCd);

		List<XptImpLicVO> insertVoList = null;
		List<XptImpLicVO> updateVoList = null;
		List<XptImpLicVO> deleteVoList = null;

		try {
			begin();


			/* Search Booking History */
			if("US".equals(cntCd) || "CA".equals(cntCd)) {
				historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
			}
			
			/* Validate Package TypeCd */
			/*if (cntCd.equals("KR")) {
				docCmd.validateExportImportNumber(xptImpLicVOs);
			}*/

			/* searchBkgBlNoVO */
			//boolean caFlag = "".equals(utilCmd.searchBkgBlNoVO(bkgBlNoVO));
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[]{bkgNo}).getMessage());
			}

			/* Change Screen Flag */
			//if (caFlag) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoVO);
			//}

			/* Insert, Modify, Delete */
			int idx1=0, idx2=0, idx3=0;
			if (xptImpLicVOs != null) {
				for (int i = 0; i < xptImpLicVOs.length; i++) {
					if ("I".equals(xptImpLicVOs[i].getIbflag())) {
						idx1++;
					} else if ("U".equals(xptImpLicVOs[i].getIbflag())) {
						idx2++;
					} else if ("D".equals(xptImpLicVOs[i].getIbflag())) {
						idx3++;
					}
				}
			}
			insertVoList = new ArrayList<XptImpLicVO>(idx1);
			updateVoList = new ArrayList<XptImpLicVO>(idx2);
			deleteVoList = new ArrayList<XptImpLicVO>(idx3);
			if (xptImpLicVOs != null) {
				int insCnt = 0;
				for (int i = 0; i < xptImpLicVOs.length; i++) {
					log.debug("<::" + xptImpLicVOs[i].getIbflag() + "::" + xptImpLicVOs[i].getBkgNo());
					
					if (e.getFormCommand().isCommand(FormCommand.MULTI01)){ //Homepage�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋占쎌젂占쎈뼇占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�걨占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� I/F �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뛾占썽뀎���맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮칾�맍逾쏉옙�쐻占쎈윥�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈뙑�⑤벡�깵�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥궘占쏙옙�걠�뙴�돍�삕占쎄돈占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쑅占쎌젂筌먯빖�맶�뜝�럥�쑅嶺뚯쉳�옱占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥궘占쏙옙�걠�뙴�돍�삕占쎄돈占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑋占쎌젂�뀎洹μ굲�뜝�럡�뜐占쎈㎍占쎈쐻占쎈윥占쎈첋占쎈탶�ⓦ끉�굲�뜝�럥�맶�뜝�럥�쐾占쎄턀占쎈씮�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽 �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎄슈占쎄섶占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈콦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌겲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛筌��맮�삕占쎌��윜諛잙쳛占쎄뎡�뜝�럥夷⑨옙�쐻�뜝占�
						webId = xptImpLicVOs[i].getUpdUsrId(); //BKGWeb0060001WSProxy �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄ゅ뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋占쎌젂占쎈뼇占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�걨占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� WEB:�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥�뙴�뮋�삕占쎌맶�뜝�럥�쑅鶯ㅼ룆占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈뙑�⑤벡�깵�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌젦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윥占쎈뼓占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슢�뒧占쎌럶�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛占쎌뵗�뜝�럥���뜝�럥爰뤷＄�렮維쒙옙�굲�뛾占쏙옙�뵛占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎄섈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥�젆�뿰�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲�젆�룇�뒻占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類㏃삕占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�굛�ｏ옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅占쎈쐻占쎈윥占쎈룈�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈쟿癲ル슢��泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몞占쎈쨨占쎈쳹占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈쟿占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥琉곻옙�쐻占쎈윪占쎈�∽옙�쐻占쎈윞占쎈젇
						porCd = xptImpLicVOs[i].getPorCd(); //date �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊�굢�룇�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥利쏙옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅占쎈쐻占쎈윥�뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�뀵�뜝�럥�맶�뜝�럥�쑅占쎈뙀占쎈엠占쎌맶�뜝�럥�쑋占쎈쨨饔낅똻�쐪占쎈쐻占쎈쑟占쎌뇢�뜝�럥�뿭�뜝�럡�돟�뜝�럥�맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럡�떐�뜝�럥�늾占쎈쇊占쎈늄揶쏅틹異�占쎈퉾獄��씛�삕占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥塋딅�ｋ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾占쎈닱占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럥�읈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥泥뗥뜝�럥�럸占쎈쐻占쎈짗占쎌굲占쎈뙀�뜝�뜴�쐻占쎈윥�뜝�룞�삕占쎌맶�뜝�럥�쑋占쎌뼲�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럡肄ｏ옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌젶�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� POR �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類㏃삕占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�굛�ｏ옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅占쎈쐻占쎈윥占쎈룈�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈쟿�뜝�럥�맶占쎈쐻�뜝占�
						log.debug("@@@@@@@SC : updUsrId["+i+"] = "+webId);					
					} else {
						xptImpLicVOs[i].setCreUsrId(account.getUsr_id());
						xptImpLicVOs[i].setUpdUsrId(account.getUsr_id());
					}
					if ("I".equals(xptImpLicVOs[i].getIbflag())) {
						insCnt++;
						xptImpLicVOs[i].setSeq(Integer.toString(insCnt));
						insertVoList.add(xptImpLicVOs[i]);
					} else if ("U".equals(xptImpLicVOs[i].getIbflag())) {
						updateVoList.add(xptImpLicVOs[i]);
					} else if ("D".equals(xptImpLicVOs[i].getIbflag())) {
						deleteVoList.add(xptImpLicVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				docCmd.createExportImportNumber(insertVoList, cntCd, bkgBlNoVO.getCaFlg());
			}

			if (updateVoList.size() > 0) {
				docCmd.modifyExportImportNumber(updateVoList, cntCd, bkgBlNoVO.getCaFlg());
			}

			if (deleteVoList.size() > 0) {
				docCmd.removeExportImportNumber(deleteVoList, bkgBlNoVO.getCaFlg());
			}

            /* Manage Booking History */
			if("US".equals(cntCd) || "CA".equals(cntCd)) {
				if (account == null){
					histCmd.eaiManageBookingHistory(uiId, historyTableVO, webId, porCd);	
				}else{
					histCmd.manageBookingHistory(uiId, historyTableVO, account);
				}
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getMessage());
			}
            
			commit();
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
	 * ESM_BKG_0252 : Simple retrieve event process.<br>
	 * EmptyReleaseOrder event retrieve event process.(ESM_BKG_0252)<br>
	 * 
	 * retrieving booking list by simple type for order Empty Release Order. --UI_BKG-0252<br>
	 * checking transfer result in the BKG EDI HISTORY, BKG NOTICE HISTORY(Fax, e-Mail).<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMtyRlseOrdForSimple(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();

		try {

			List<MtyRlseOrdSimpleOutVO> list = command.searchMtyRlseOrdForSimple(event.getMtyRlseOrdInVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Empty Container Release Order Excel Download
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMtyRlseOrdForExcelDownload(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();

		try {
			/* BKG_QTY */
			List<?> list = command.searchMtyRlseOrdForExcelDownload(event.getMtyRlseOrdInVO());
			eventResponse.setRsVoList(list);
			
//			List<?> list1 = command.searchMtyRlseOrdForExcelDownload(event.getMtyRlseOrdInVO(), 1);
//			List<?> list2 = command.searchMtyRlseOrdForExcelDownload(event.getMtyRlseOrdInVO(), 2);
//			List<?> list3 = command.searchMtyRlseOrdForExcelDownload(event.getMtyRlseOrdInVO(), 3);
//			List<?> list4 = command.searchMtyRlseOrdForExcelDownload(event.getMtyRlseOrdInVO(), 4);
//			List<?> list5 = command.searchMtyRlseOrdForExcelDownload(event.getMtyRlseOrdInVO(), 5);
//			List<?> list6 = command.searchMtyRlseOrdForExcelDownload(event.getMtyRlseOrdInVO(), 6);
//			eventResponse.setRsVoList(list1);
//			eventResponse.setRsVoList(list2);
//			eventResponse.setRsVoList(list3);
//			eventResponse.setRsVoList(list4);
//			eventResponse.setRsVoList(list5);
//			eventResponse.setRsVoList(list6);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0252 : Detail retrieve event process.<br>
	 * EmptyReleaseOrder�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윥�뜝�뜴�쐻占쎈윥占쎈쟿�뜝�럥�돯耀붾굟占쏙옙 retrieve event process.(ESM_BKG_0252)<br>
	 * 
	 * retrieving booking list by detail(s) type for order Empty Release Order. --UI_BKG-0252<br>
	 * checking transfer result in the BKG EDI HISTORY, BKG NOTICE HISTORY(Fax, e-Mail).<br>
	 * 1. Fax and Email has each notice history so need merge.<br>
	 * 2. Using recently Remark of Fax or Email.<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMtyRlseOrdForDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();

		try {

			List<MtyRlseOrdDetailOutVO> list = command.searchMtyRlseOrdForDetail(event.getMtyRlseOrdInVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0252 : Detail(USA) retrieve event process.<br>
	 * EmptyReleaseOrder event retrieve event process.(ESM_BKG_0252)<br>
	 * 
	 * retrieving booking list by detail(s) USA type for order Empty Release Order. --UI_BKG-0252<br>
	 * checking transfer result in the BKG EDI HISTORY, BKG NOTICE HISTORY(Fax, e-Mail).<br>
	 * 1. Fax and Email has each notice history so need merge.<br>
	 * 2. Using recently Remark of Fax or Email.<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMtyRlseOrdForUsa(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();

		try {

			List<MtyRlseOrdUsaOutVO> list = command.searchMtyRlseOrdForUsa(event.getMtyRlseOrdInVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0252 : fax event process.<br>
	 * EmptyReleaseOrder fax event process.(ESM_BKG_0252)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendMtyRlseOrdByFax(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0252Event event = (EsmBkg0252Event) e;

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

		try {

			begin();
			/* 1. Send FAX */
			List<BkgNtcHisVO> bkgNtcHisVOs = command.sendMtyRlseOrdByFax(event.getSendMtyRlseOrdVOs(), account);
			/* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("BKG00496").getUserMessage());

			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00265").getMessage(), ex);
		}

		return eventResponse;

	}

	/**
	 * ESM_BKG_0252 : e-mail event process.<br>
	 * EmptyReleaseOrder e-mail event process.(ESM_BKG_0252)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendMtyRlseOrdByEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		try {
			begin();
			/* 1. Send Email */
			List<BkgNtcHisVO> bkgNtcHisVOs = command.sendMtyRlseOrdByEmail(event.getSendMtyRlseOrdVOs(), event.getBkgEmlEdtVO(), account);
			/* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("BKG00497").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00265").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0252 : EDI event process.<br>
	 * EmptyReleaseOrder EDI event process.(ESM_BKG_0252)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendMtyRlseOrdByEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0252Event event = (EsmBkg0252Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC command2 = new BookingHistoryMgtBCImpl();
		BkgBlNoVO bkgBlNoVO = null;
		SendMtyRlseOrdVO[] sendMtyRlseOrdVOs = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		String ntcKndCd = null;
		try {
			begin();
			sendMtyRlseOrdVOs = event.getSendMtyRlseOrdVOs();
			if (null!=sendMtyRlseOrdVOs && 0<sendMtyRlseOrdVOs.length) {
				for (SendMtyRlseOrdVO vo : sendMtyRlseOrdVOs) {
					bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(vo.getBkgNo());
					ntcKndCd = "F".equalsIgnoreCase(vo.getYardType()) ? "FC" :("T".equalsIgnoreCase(vo.getYardType()) ?  "BT":"CN");

					// Vender301ParamVO�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲�젆�룇�뒻占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾占쎄슈�뜝占� EDI�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎄섈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈꺏占쎌굲嶺뚮Ĳ猷귨옙援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎄섈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩�벂�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈쭢占쎈쐻占쎈윥占쎈윾占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윥�뜝�룞�삕筌뚮냵�삕�뙴�뛽�떐獄쏇꽟eter占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇔뜝�럥�맶�뜝�럥�쑅�뜝�럥爰묈뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�꽠�ⓑ살┯占쎈쐻占쎈윪�뜝�룞�삕�뜝�럩援뀐쫲�냲�삕亦껋꼻�삕鶯ㅼ렯援좂댚紐뚯삕�뙴���삕筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎌넁�뜝�뜦維�占쎈뮛�뜝�럩沅ⓨ뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥�뙴�뮋�삕占쎌맶�뜝�럥�쑅鶯ㅼ룆占쏙퐢�맶�뜝�럥�쑅�뜝�룞�삕�솾�꺂�뒧占쎈뮛櫻뗫봿瑗삼옙�굲嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪獄��슱�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("U");
					vender301ParamVO.setEdiKind(ntcKndCd);
					vender301ParamVO.setAutoManualFlg("N");
					vender301ParamVO.setEventPage(e.getEventName());

					bkgNtcHisVOs = command.createTmlBkgReceiptEdi(vender301ParamVO, account);
					
					if (null!=bkgNtcHisVOs && 0<bkgNtcHisVOs.size()) {
						command2.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0252");
					}
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00101").getUserMessage());
			}
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00265").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieve container at the BKG CONTAINER MANIFEST DESCRIPTION Table.(ESM_BKG_0178)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCmByCntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0178Event event = (EsmBkg0178Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

		log.debug("==========>" + event.getCntrNo());
		log.debug("==========>" + event.getTVvd());

		try {

			CmByCntrVO cmVO = command.searchCmByCntr(event.getCntrNo(), event.getTVvd());
			CntrCmEtcInfoVO cntrCmEtcInfoVO = cmVO.getCntrCmEtcInfoVO();
			List<CntrCmBkgInfoVO> cntrCmBkgInfoVOs = cmVO.getCntrCmBkgInfoVOs();
			List<CntrCmDescInfoVO> cntrCmDescInfoVOs = cmVO.getCntrCmDescInfoVOs();

			eventResponse.setRsVoList(cntrCmBkgInfoVOs);
			eventResponse.setETCData(cntrCmEtcInfoVO.getColumnValues());
			eventResponse.setRsVoList(cntrCmDescInfoVOs);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Insert(Modify/Delete) C/M by Container.(ESM_BKG_0178)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageCmByCntr(Event e) throws EventException {
		EsmBkg0178Event event = (EsmBkg0178Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		
		CmByCntrVO cmVO = event.getCmByCntrVO();
		CntrCmEtcInfoVO cmEtcVO = cmVO.getCntrCmEtcInfoVO();
		
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(cmEtcVO.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        HistoryTableVO historyTableVO = null;

        String uiId = "ESM_BKG_0178";

		
		try {
			begin();
            /* searchBkgBlNo */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049").getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

			/* manageCmByCntr */
			docCmd.manageCmByCntr(cmVO, account, "N");
			
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            			
			/* Set Message */
			eventResponse.setUserMessage("");
			commit();
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
	 * retrieve Goods Description by a C/M.(ESM_BKG_0707)
	 *
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchGoodsDescByCm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0707Event event = (EsmBkg0707Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLDocumentationBLBC blCmd = new BLDocumentationBLBCImpl();
		BLDocumentationCMBC cmCmd = new BLDocumentationCMBCImpl();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

			CmGoodsDescVO goodsDescVO = blCmd.searchGoodsDescByCm(bkgBlNoVO.getBkgNo());
			List<BkgCntrMfDescVO> list = cmCmd.searchCntrMfDesc(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			String cntrKnt = cmCmd.searchCntrKnt(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());

			eventResponse.setRsVoList(list);
			eventResponse.setETCData(goodsDescVO.getColumnValues());
			eventResponse.setETCData("cntr_knt", cntrKnt);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Retrieving target list to modify B/L by group.(ESM_BKG_0726)
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlListForGroupUpdate(Event e) throws EventException {
		EsmBkg0726Event event = (EsmBkg0726Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLIssuanceBC issueCmd = new BLIssuanceBCImpl();

		GrpBlDtVO grpBlDtIN = event.getGrpBlDtVO();

		try {
			GrpBlDtVO grpBlDtOUT = issueCmd.searchBlListForGroupUpdate(grpBlDtIN.getGrpBlDtInVO());

			GrpBlDtInVO grpBlEtcVO = grpBlDtOUT.getGrpBlDtInVO();
			List<GrpBlDtListVO> grpBlDtListVOs = grpBlDtOUT.getGrpBlDtListVOs();

			eventResponse.setRsVoList(grpBlDtListVOs);
			eventResponse.setETCData(grpBlEtcVO.getColumnValues());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * modify B/L(onboard date, issue date etc) by group<br>
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyGroupBlUpdate(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		BLIssuanceBC command = null;
		String jobId = null;
		EsmBkg0726Event event = (EsmBkg0726Event) e;
		
		try{
			begin();
			eventResponse = new GeneralEventResponse();
			command = new BLIssuanceBCImpl();
			GrpBlDtVO grpBlDtIN = event.getGrpBlDtVO();

			jobId = command.modifyGroupBlUpdate(grpBlDtIN, account);
			log.debug("modifyGroupBlUpdate BackEndJobId==>"+jobId);
			eventResponse.setETCData("jobID", jobId);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}
	
	/**
	 * modifyGroupBlUpdate BackEndJob 占쎈뼄占쎈뻬<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchGroupBlUpdateBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = null;
    	DBRowSet rowSet = null;
    	EsmBkg0726Event event = (EsmBkg0726Event) e;
		String key = null;
		String jobStsFlg = "";
		
    	try {    		
    		eventResponse = new GeneralEventResponse();
    		key = event.getKey();
			log.debug("searchGroupBlUpdateBackEndJobStatus BackEndJobKey==>"+key);

    		if (null != key && !"".equals(key)) {
    			// Backend job 占쎌끏�뙴�슣肉ч겫占썹몴占� 野껓옙占쎄텢占쎈립占쎈뼄.
		    	backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(key);
		    	rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	
		    	while(rowSet.next())
				{
		    		jobStsFlg = rowSet.getString("JB_STS_FLG");
		    		if ("4".equals(rowSet.getString("JB_STS_FLG")))
					{
						if (!"".equals(rowSet.getString("JB_ERR_MSG"))) {
							StringTokenizer st = new StringTokenizer(rowSet.getString("JB_ERR_MSG"), "<||>");
							st.nextToken();
							st.nextToken();
							st.nextToken();
							String strErrMsg = st.nextToken();
							eventResponse.setUserMessage(strErrMsg);
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00205").getUserMessage());
						}
					}
				}
		    	eventResponse.setETCData("JB_STS_FLG", jobStsFlg);
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
    	return eventResponse;
    }
	
	/**
	 * BackEndJob 野껉퀗�궢 占쎌넇占쎌뵥<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchGroupBlUpdateBackEndJobResult(Event e) throws EventException{
		GeneralEventResponse eventResponse = null;
		BLIssuanceBC command = null;
		String result = null;
		EsmBkg0726Event event = (EsmBkg0726Event) e;
		String key = null;
		try{
    		key = event.getKey();
			eventResponse = new GeneralEventResponse();
			command = new BLIssuanceBCImpl();
			log.debug("searchGroupBlUpdateBackEndJobResult BackEndJobKey==>"+key);
			result = command.searchGroupBlUpdateBackEndJobResult(key);
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}	

	/**
	 * house B/L Description retrieve.<br>
     * Insert HB/L Info to M&D.(ESM_BKG_0360)<br>
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchHblForMnd(Event e) throws EventException {
		EsmBkg0360Event event = (EsmBkg0360Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		String bkgNo = event.getBkgNo();

		try {
			List<HblForMndVO> hblForMndVOs = docCmd.searchHblForMnd(bkgNo);

			eventResponse.setRsVoList(hblForMndVOs);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * house B/L Info retrieve.(ESM_BKG_0366)<br>
	 *
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchHbl(Event e) throws EventException {
		EsmBkg0366Event event = (EsmBkg0366Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		UserSetupMgtBC userCmd = new UserSetupMgtBCImpl();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		try {
			// searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* update on 2009.12.31 */
            String cgoTp = utilCmd.searchBkgCgoTp(bkgBlNoIN);
            if("P".equals(cgoTp)) {
                throw new EventException(new ErrorHandler("BKG00092", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> Cgargo Tpye : " + cgoTp);
            
            
            /* 
             * need UserId for Default User Setting.
             */ 
            bkgBlNoVO.setIbflag(account.getUsr_id());
            
			HblVO hblVO = docCmd.searchHbl(bkgBlNoVO);

			HblBkgInfoVO hblBkgInfoVO = hblVO.getHblBkgInfoVO();
			BkgUsrDfltSetVO usrDfltSetVO = userCmd.searchUserDefaultSetting(account.getUsr_id());
			List<HblDtlInfoVO> hblVOs = hblVO.getHblDtlInfoVOs();
			List<HblCntrVO> hblCntrVOs = hblVO.getHblCntrVOs();
			List<BkgCntrMfDescVO> cntrMfDescVO = hblVO.getBkgCntrMfDescVOs();

			eventResponse.setRsVoList(hblVOs);
			eventResponse.setETCData(hblBkgInfoVO.getColumnValues());
            eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
			eventResponse.setETCData("obl_iss_flg", utilCmd.oblIssFlgCheck(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg()));
            eventResponse.setETCData("default_wgt_ut_cd", (usrDfltSetVO==null ? "" : usrDfltSetVO.getWgtUtCd()));
            eventResponse.setETCData("default_meas_ut_cd", (usrDfltSetVO==null ? "" : usrDfltSetVO.getMeasUtCd()));
            
			eventResponse.setRsVoList(hblCntrVOs);
			eventResponse.setRsVoList(cntrMfDescVO);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * House B/L and Customer Info Modify.(ESM_BKG_0366)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageHbl(Event e) throws EventException {

	    EsmBkg0366Event event = (EsmBkg0366Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationBLBC blCmd = new BLDocumentationBLBCImpl();
        BLDocumentationCMBC cmCmd = new BLDocumentationCMBCImpl();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        //BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();

        HblVO hblVO = event.getHblVO();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        HistoryTableVO historyTableVO = null;

        String uiId = "ESM_BKG_0366";

        try {
            begin();
            /* searchBkgBlNo */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* validate */
            blCmd.validateHbl(hblVO);
            log.debug("=====> validateHbl    : OK!");

            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

            /* modifyCngScreenFlag */
            //if ("Y".equals(bkgBlNoVO.getCaFlg())) {
                //correctCmd.modifyCngScreenFlag("", bkgBlNoVO);
            //}
            
            /* manage CM */
            cmCmd.manageCmByHbl(hblVO, account, bkgBlNoVO.getCaFlg());
            
            /* manage HBL */
            blCmd.manageHbl(hblVO, account, bkgBlNoVO.getCaFlg());
            
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
            /* Set Message */
            eventResponse.setUserMessage("");
            commit();
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
	 * setting filer number to house B/L.(ESM_BKG_0366)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse asgnMfNo(Event e) throws EventException {

        EsmBkg0366Event event = (EsmBkg0366Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        //BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();

        NvoccFileNoVO fileNoVO = event.getNvoccFileNoVO();
        log.debug("******** BkgNo : " + fileNoVO.getBkgNo());

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        BkgBlNoVO toyotaBlNoVO = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(fileNoVO.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        HistoryTableVO historyTableVO = null;

        String bkgNo  = null;
        String blNo   = null;
        String hblSeq = null;
        String mfNo   = null;
        
        String uiId   = "ESM_BKG_0366";

        try {
            begin();
            /* searchBkgBlNo */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{fileNoVO.getBkgNo()}).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

            bkgNo = bkgBlNoVO.getBkgNo();
            blNo = bkgBlNoVO.getBlNo();
            hblSeq = fileNoVO.getHblSeq();
            log.debug("=====> bkgNo=" + bkgNo + ", blNo=" + blNo + ", hblSeq=" + hblSeq);
            
            // assign Nvocc File Number
            docCmd.validateMfNo(bkgBlNoVO);
            log.debug("=====> validateMfNo : OK!");

            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

            /* modifyCngScreenFlag */
            //if ("Y".equals(bkgBlNoVO.getCaFlg())) {
                //correctCmd.modifyCngScreenFlag("", bkgBlNoVO);
            //}
            
            /* search maximum MfNo */
            if(blNo.length() == 10){
            	toyotaBlNoVO = utilCmd.manageToyotaBlNumberGeneration("TYB", account.getOfc_cd(), account.getUsr_id());
            	mfNo = toyotaBlNoVO.getBlNo();
            }else{
            	mfNo = docCmd.searchMaxMfNo(bkgNo, blNo, bkgBlNoVO.getCaFlg());
            }
            log.debug("=====> mfNo    : " + mfNo);
            
            /* update MfNo */
            docCmd.modifyNvoccFileNo(bkgNo, hblSeq, mfNo, account, bkgBlNoVO.getCaFlg());
            
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
            /* Set Message */
            eventResponse.setETCData("cntr_mf_no", mfNo);
            eventResponse.setUserMessage("");
            commit();
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
	 * retrieving template Info by house B/L.(ESM_BKG_0399)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchHblTmplt(Event e) throws EventException {
		EsmBkg0399Event event = (EsmBkg0399Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		String cneeNm = event.getCneeNm();
		String shprNm = event.getShprNm();
		String ofcCd = account.getOfc_cd();

		try {
			// BLDocumentationBLBC::searchHblTmplt ( ShprNm , cneeNm , ofcCd )
			HblTmpltVO hblTmpltVO = docCmd.searchHblTmplt(shprNm, cneeNm, ofcCd);

			List<BkgNvoccProfVO> custProfVOs = hblTmpltVO.getBkgNvoccProfVOs();
			List<BkgNvoccProfCntrMfVO> cmProfVOs = hblTmpltVO.getBkgNvoccProfCntrMfVOs();

			eventResponse.setRsVoList(custProfVOs);
			eventResponse.setRsVoList(cmProfVOs);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * manage template Info by house B/L.(ESM_BKG_0399)<br>
	 *
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageHblTmplt(Event e) throws EventException {
		EsmBkg0399Event event = (EsmBkg0399Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		HblTmpltVO hblTmpltVO = event.getHblTmpltVO();

		try {
			begin();
			// manageBkgHistory
			docCmd.manageHblTmplt(hblTmpltVO, account.getUsr_id());
			// set message
			eventResponse.setUserMessage("");
			commit();
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
	 * ESM_BKG_0648 : Retrieve<br>
	 * B/L Copy target retrieve.(ESM_BKG_0648)<br>
	 * 
	 * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchForCopyBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0648Event event = (EsmBkg0648Event)e;
		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();
		try {
			BlCopyOutVO rsVo = command.searchForCopyBl(event.getBkgNo());
			eventResponse.setETCData(rsVo.getColumnValues());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_BKG_0648 : Copy B/L Copy(ESM_BKG_0648)<br>
	 * 
	 * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse copyBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkg0648Event event = null;
		try {
			event = (EsmBkg0648Event) e;
			if (null!=event.getBlCopyIns() && 0<event.getBlCopyIns().length) {
				begin();
				eventResponse = copyBlProc(event);
				//eventResponse.setUserMessage(new ErrorHandler("PRI00110").getMessage()); //Data copied successfully.
				commit();
			}
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * called by copy B/L<br>
	 * B/L Copy Process<br>
	 * 
	 * @author
     * @param EsmBkg0648Event event
     * @return GeneralEventResponse
     * @exception EventException
	 */
	private GeneralEventResponse copyBlProc(EsmBkg0648Event event) throws EventException {
		GeneralEventResponse eventResponse;
		BLDocumentationBLBC command;
		BookingHistoryMgtBC command2;
		GeneralBookingReceiptBC command3;
		ArrivalNoticeBC command4;
        BookingUtil utilCmd;
		BkgBlNoVO bkgBlNoIN;
		BkgBlNoVO bkgBlNoVo;
		HistoryTableVO historyTableVo;
		List<BlCopyInVO> list;
		String uiId;
		String copyBkgNo;
		eventResponse = new GeneralEventResponse();
		command = new BLDocumentationBLBCImpl();
		command2 = new BookingHistoryMgtBCImpl();
		command3 = new GeneralBookingReceiptBCImpl();
		command4 = new ArrivalNoticeBCImpl();
		utilCmd = new BookingUtil();
		list = new ArrayList<BlCopyInVO>(event.getBlCopyIns().length);
		uiId = "ESM_BKG_0648";
		//7.loop
		for (BlCopyInVO blCopyInVo : event.getBlCopyIns()) {
			copyBkgNo = blCopyInVo.getCopyBkgNo();
			bkgBlNoIN = new BkgBlNoVO();
			bkgBlNoIN.setBkgNo(blCopyInVo.getCopyBkgNo());
			bkgBlNoIN.setCaUsrId(account.getUsr_id());
			bkgBlNoVo = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			blCopyInVo.setResultMsg("");
			//8. retreive History table
			historyTableVo = command2.searchOldBkgForHistory(uiId, bkgBlNoVo);
			//9. check bkgStatus,bdrFlg,shprCd 
			blCopyInVo = command.searchForCopyBl(blCopyInVo);
			if (!StringUtil.isEmpty(blCopyInVo.getResultMsg())) {
				blCopyInVo.setResultMsg("Fail ("+blCopyInVo.getResultMsg()+")");
				list.add(blCopyInVo);
				continue;
			}
			try {
				//15.if custFlg='Y'
				if ("Y".equalsIgnoreCase(blCopyInVo.getCustFlg())) {
					//16.copyCustByBlCopy
					command3.copyCustByBlCopy(blCopyInVo, account);
					command3.cancelCustCdVal(copyBkgNo);
					command4.cancelArrNtcCustCdVal(copyBkgNo);
				}
				//20.copyDocByBlCopy
				blCopyInVo = command.copyDocByBlCopy(blCopyInVo, account);
				if (StringUtil.isEmpty(blCopyInVo.getResultMsg())) {  // in case of Success
					blCopyInVo.setResultMsg("Success");
				} else {
					blCopyInVo.setResultMsg("Fail ("+blCopyInVo.getResultMsg()+")");
				}
				//25.the related history
				command2.manageBookingHistory(uiId, historyTableVo, account);
				list.add(blCopyInVo);
				continue;
			} catch(Exception ex2) {  // not throw for return fail in case of not copy.
				blCopyInVo.setResultMsg("Fail");
				list.add(blCopyInVo);
				//continue;
				log.error(ex2.getMessage(), ex2);
			}
		}
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

    /**
	 * retrieve event process.<br>
	 * MultiCombo result for search condition.(ESM_BKG_0218)<br>
	 *
	 * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchComCode0218(Event e) throws EventException {
		BookingUtil comboUtil = null;
		UserSetupMgtBC command = null;
		GeneralEventResponse eventResponse = null;
		List<BkgComboVO> bkg_sts_cd = null;
		List<BkgComboVO> bkg_cust_tp_cd = null;
		List<BkgComboVO> fax_sts_cd = null;
		List<BkgComboVO> eml_sts_cd = null;
		try {
			comboUtil = new BookingUtil();
			command   = new UserSetupMgtBCImpl();
			eventResponse = new GeneralEventResponse();

			BkgUsrDfltSetVO usrDfltSetVO = command.searchUserDefaultSetting(account.getUsr_id());
			
			String blPrnChgTpCd = "";
			if(usrDfltSetVO != null){
				blPrnChgTpCd = usrDfltSetVO.getBlPrnChgTpCd();
			}
			eventResponse.setCustomData("bl_prn_chg_tp_cd", blPrnChgTpCd);
			log.debug("bl_prn_chg_tp_cd:"+blPrnChgTpCd);
			
			bkg_sts_cd = comboUtil.searchCombo("CD00769");  // bkg_status
			bkg_cust_tp_cd = comboUtil.searchCombo("CD00880");  // bkg_cust_tp_cd
			fax_sts_cd = comboUtil.searchCombo("CD02396");  // fax_sts_cd(CD00959)
			eml_sts_cd = comboUtil.searchCombo("CD02396");  // eml_sts_cd(CD00960)
			bkg_sts_cd.remove(bkg_sts_cd.size()-1);
			bkg_sts_cd.remove(bkg_sts_cd.size()-1);
			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
			eventResponse.setCustomData("bkg_cust_tp_cd", bkg_cust_tp_cd);
			eventResponse.setCustomData("fax_sts_cd", fax_sts_cd);
			eventResponse.setCustomData("eml_sts_cd", eml_sts_cd);
//			eventResponse.setCustomData("bl_prn_chg_tp_cd", usrDfltSetVO.getBlPrnChgTpCd());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0218 : Retrieve<br>
	 * retrieving Outbound booking list to send Draft BL and Waybill.(ESM_BKG_0218)<br>
	 * 
	 * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgListForObDblWbl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0218Event event = (EsmBkg0218Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		try {
			if ((!"".equals(event.getObDblWblInVO().getVslCd().trim()) && !"".equals(event.getObDblWblInVO().getPolCd().trim())) ||
		    		(!"".equals(event.getObDblWblInVO().getOblIssDtFrom().trim()) && !"".equals(event.getObDblWblInVO().getOblIssDtTo().trim()) && !"".equals(event.getObDblWblInVO().getPolCd().trim())) ||
		    		(!"".equals(event.getObDblWblInVO().getBlObrdDtFrom().trim()) && !"".equals(event.getObDblWblInVO().getBlObrdDtTo().trim()) && !"".equals(event.getObDblWblInVO().getPolCd().trim())) ||
		    		!"".equals(event.getObDblWblInVO().getBkgNo().trim()) || !"".equals(event.getObDblWblInVO().getBlNo().trim())) {
	    		
	    		if(!"".equals(event.getObDblWblInVO().getOblIssDtFrom().trim())){
	                if (DateTime.daysBetween(event.getObDblWblInVO().getOblIssDtFrom(), event.getObDblWblInVO().getOblIssDtTo()) > 31 ) {
	                    throw new EventException(new ErrorHandler("BKG00756", new String[]{"Duration","31Days"}).getMessage());
	                }
	    		}
	    		if(!"".equals(event.getObDblWblInVO().getBlObrdDtFrom().trim())){
	                if (DateTime.daysBetween(event.getObDblWblInVO().getBlObrdDtFrom(), event.getObDblWblInVO().getBlObrdDtTo()) > 31 ) {
	                    throw new EventException(new ErrorHandler("BKG00756", new String[]{"Duration","31Days"}).getMessage());
	                }
	    		}
 
		    } else {
		    		throw new EventException(new ErrorHandler("BKG95066", new String[]{}).getMessage());
		    }
		
			DblWblOutVO rsVo = command.searchBkgListForObDblWbl(event.getObDblWblInVO());
			if (null!=rsVo) {
				eventResponse.setRsVoList(rsVo.getDblWbls());
				if (null!=rsVo.getDblWblCnts() && 0<rsVo.getDblWblCnts().size()) {
					DblWblCntVO dblWblCntVO = rsVo.getDblWblCnts().get(0);
					eventResponse.setETCData("faxBlTotal1",dblWblCntVO.getFaxBlTotal());
					eventResponse.setETCData("faxTotal1"  ,dblWblCntVO.getFaxTotal());
					eventResponse.setETCData("faxSuccess1",dblWblCntVO.getFaxSuccess());
					eventResponse.setETCData("faxSending1",dblWblCntVO.getFaxSending());
					eventResponse.setETCData("faxUnSent1" ,String.valueOf(Integer.parseInt(dblWblCntVO.getFaxNoSend())+Integer.parseInt(dblWblCntVO.getFaxFailed()))
							                               +" (No Send : "+dblWblCntVO.getFaxNoSend()+" / Failed : "+dblWblCntVO.getFaxFailed()+")");
					eventResponse.setETCData("emlBlTotal1",dblWblCntVO.getEmlBlTotal());
					eventResponse.setETCData("emlTotal1"  ,dblWblCntVO.getEmlTotal());
					eventResponse.setETCData("emlSuccess1",dblWblCntVO.getEmlSuccess());
					eventResponse.setETCData("emlSending1",dblWblCntVO.getEmlSending());
					eventResponse.setETCData("emlUnSent1" ,String.valueOf(Integer.parseInt(dblWblCntVO.getEmlNoSend())+Integer.parseInt(dblWblCntVO.getEmlFailed()))
														   +" (No Send : "+dblWblCntVO.getEmlNoSend()+" / Failed : "+dblWblCntVO.getEmlFailed()+")");
				}
			} else {
				eventResponse.setETCData("faxBlTotal1","0");
				eventResponse.setETCData("faxTotal1"  ,"0");
				eventResponse.setETCData("faxSuccess1","0");
				eventResponse.setETCData("faxSending1","0");
				eventResponse.setETCData("faxUnSent1" ,"0 (No Send : 0 / Failed : 0)");
				eventResponse.setETCData("emlBlTotal1","0");
				eventResponse.setETCData("emlTotal1"  ,"0");
				eventResponse.setETCData("emlSuccess1","0");
				eventResponse.setETCData("emlSending1","0");
				eventResponse.setETCData("emlUnSent1" ,"0 (No Send : 0 / Failed : 0)");
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_BKG_0218 : Retrieve<br>
	 * retrieving Inbound booking list to send Draft BL and Waybill.(ESM_BKG_0218)<br>
	 * 
	 * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgListForIbDblWbl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0218Event event = (EsmBkg0218Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		try{
			DblWblOutVO rsVo = command.searchBkgListForIbDblWbl(event.getInDblWblInVO());
			if (null!=rsVo) {
				eventResponse.setRsVoList(rsVo.getDblWbls());
				if (null!=rsVo.getDblWblCnts() && 0<rsVo.getDblWblCnts().size()) {
					DblWblCntVO dblWblCntVO = rsVo.getDblWblCnts().get(0);
					eventResponse.setETCData("faxBlTotal2",dblWblCntVO.getFaxBlTotal());
					eventResponse.setETCData("faxTotal2"  ,dblWblCntVO.getFaxTotal());
					eventResponse.setETCData("faxSuccess2",dblWblCntVO.getFaxSuccess());
					eventResponse.setETCData("faxSending2",dblWblCntVO.getFaxSending());
					eventResponse.setETCData("faxUnSent2" ,String.valueOf(Integer.parseInt(dblWblCntVO.getFaxNoSend())+Integer.parseInt(dblWblCntVO.getFaxFailed()))
							                               +" (No Send : "+dblWblCntVO.getFaxNoSend()+" / Failed : "+dblWblCntVO.getFaxFailed()+")");
					eventResponse.setETCData("emlBlTotal2",dblWblCntVO.getEmlBlTotal());
					eventResponse.setETCData("emlTotal2"  ,dblWblCntVO.getEmlTotal());
					eventResponse.setETCData("emlSuccess2",dblWblCntVO.getEmlSuccess());
					eventResponse.setETCData("emlSending2",dblWblCntVO.getEmlSending());
					eventResponse.setETCData("emlUnSent2" ,String.valueOf(Integer.parseInt(dblWblCntVO.getEmlNoSend())+Integer.parseInt(dblWblCntVO.getEmlFailed()))
														   +" (No Send : "+dblWblCntVO.getEmlNoSend()+" / Failed : "+dblWblCntVO.getEmlFailed()+")");
				}
			} else {
				eventResponse.setETCData("faxBlTotal2","0");
				eventResponse.setETCData("faxTotal2"  ,"0");
				eventResponse.setETCData("faxSuccess2","0");
				eventResponse.setETCData("faxSending2","0");
				eventResponse.setETCData("faxUnSent2" ,"0 (No Send : 0 / Failed : 0)");
				eventResponse.setETCData("emlBlTotal2","0");
				eventResponse.setETCData("emlTotal2"  ,"0");
				eventResponse.setETCData("emlSuccess2","0");
				eventResponse.setETCData("emlSending2","0");
				eventResponse.setETCData("emlUnSent2" ,"0 (No Send : 0 / Failed : 0)");
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_BKG_0218 : Assign BKG Agent E-mail<br>
	 * retrieving Email address in Chinese Booking Agent Code in case Draft B/L corresponding to BKG is sent.(ESM_BKG_0218)<br>
	 * 
	 * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgAgentEml(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0218Event event = (EsmBkg0218Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<AgentEmlVO> agentEmlVOs = null;
		try {
			agentEmlVOs = command.searchBkgAgentEml((List<String>)event.getAttribute("bkgNos"));
			eventResponse.setRsVoList(agentEmlVOs);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_BKG_1071 : Retrieve<br>
     * retrieving fax and mail transfer results by Booking.(ESM_BKG_1071)<br>
     *
     * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMultiNtcHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1071Event event = (EsmBkg1071Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<MultiNtcHisVO> rsVo = null;
		try {
			rsVo = command.searchMultiNtcHis(event.getMultiNtcHisVO());
			if (null!=rsVo && 0<rsVo.size()) {
				eventResponse.setRsVoList(rsVo);
				eventResponse.setETCData("txt_bkg_no", rsVo.get(0).getBkgNo());
				eventResponse.setETCData("txt_bl_no", rsVo.get(0).getBlNo());
				eventResponse.setETCData("txt_ntc_knd_cd", rsVo.get(0).getNtcKndCd());
				eventResponse.setETCData("txt_ntc_via_cd", rsVo.get(0).getNtcViaCd());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * retrieving data for setting Client Default for Booking.(ESM_BKG_0927)<br>
	 *
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchUserDefaultSetting(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
         
        try {
            BkgUsrDfltSetVO usrDfltSetVO = command.searchUserDefaultSetting(account.getUsr_id());
        	if(usrDfltSetVO!=null){
        		eventResponse.setETCData("bl_prn_chg_tp_cd",usrDfltSetVO.getBlPrnChgTpCd());
        	}else{
        		eventResponse.setETCData("bl_prn_chg_tp_cd","");
        	}
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
	 * retrieving data for setting screen of B/L preview.(ESM_BKG_0927)<br>
	 *
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlInfoForPreview(Event e) throws EventException {
		EsmBkg0927Event event = (EsmBkg0927Event) e;
		GeneralEventResponse eventResponse = null;

		BookingUtil utilCmd = null;
		BLIssuanceBC command = null;
		GeneralBookingReceiptBC receiptBC = null;
		UserSetupMgtBC command2 = null;
		
		BkgBlNoVO bkgBlNoIN = null;
		BookingCreationVO bookingCreationVO = null;
		
		BkgUsrDfltSetVO bkgUsrDfltSetVO = null;

		String bkg_no = "";
		String bl_no = "";
		String bl_tp_cd = "";
		String hiddenData = "";
		String rate = "";
		String cntr = "";
		String rider_yn = "";
		String houseBl_yn = "";
		String corr_no = "";
		String email = "";
		String fax_no = "";
		String obl_iss_flg = "";

		try {
			eventResponse = new GeneralEventResponse();
			utilCmd = new BookingUtil();
			command = new BLIssuanceBCImpl();
			receiptBC = new GeneralBookingReceiptBCImpl();
			command2 = new UserSetupMgtBCImpl();

			// searchBkgBlNo
			bkgBlNoIN = new BkgBlNoVO();
			bkgBlNoIN.setBkgNo(event.getBkg_no());
			bkgBlNoIN.setBlNo(event.getBl_no());
			bkgBlNoIN.setCaUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkg_no() }).getMessage());
			}
			bookingCreationVO = receiptBC.searchBooking(bkgBlNoVO);
			for (BkgCntcPsonVO vo : bookingCreationVO.getBkgCntcPson()) {
				if ("SI".equalsIgnoreCase(vo.getBkgCntcPsonTpCd())) {
					fax_no = vo.getCntcPsonFaxNo();
					email = vo.getCntcPsonEml();
					break;
				}
			}

			bkg_no = bkgBlNoVO.getBkgNo(); // bkg_no
			bl_no = bkgBlNoVO.getBlNo(); // bl_no
			//bl_tp_cd = (event.getBlTpCd() == null || event.getBlTpCd().equals("")) ? bkgBlNoVO.getBlTpCd() : event.getBlTpCd(); // bl_tp_cd
			bl_tp_cd = bkgBlNoVO.getBlTpCd(); // bl_tp_cd
			hiddenData = event.getHiddenData();
			
			rate = event.getFormLevel() == null || event.getFormLevel().equals("") ? "1" : event.getFormLevel();
			cntr = event.getForm_Cntr() == null || event.getForm_Cntr().equals("") ? "1" : event.getForm_Cntr();
			log.error("**********************************************"+rate);
			corr_no = event.getForm_corr_no();

			rider_yn = command.searchRiderYn(bkg_no, hiddenData, rate, cntr, corr_no);
			houseBl_yn = command.searchHouseBlYn(bkg_no);
			obl_iss_flg = command.searchOblIssFlg(bkg_no);
			
			//sign flg
			bkgUsrDfltSetVO = new BkgUsrDfltSetVO();
			bkgUsrDfltSetVO.setBkgNo(bkg_no);
			bkgUsrDfltSetVO.setBlNo(bl_no);
			bkgUsrDfltSetVO.setUsrId(account.getUsr_id());
//			bkgUsrDfltSetVO.setBlNo(bl_no);
			List<BkgUsrDfltSetVO> list = command2.searchUserPrintSetup(bkgUsrDfltSetVO,account);
			if(null != list && list.size() > 0){
				eventResponse.setETCData("bl_cpy_esig_flg",  list.get(0).getBlCpyEsigFlg());
				eventResponse.setETCData("bl_prn_chg_tp_cd",list.get(0).getBlPrnChgTpCd());
			}else{
				eventResponse.setETCData("bl_cpy_esig_flg",  "");
				eventResponse.setETCData("bl_prn_chg_tp_cd", "");
			}

			/*
			log.debug("####################################################");
			log.debug("");
			log.debug("bkg_no : [" + bkg_no + "]");
			log.debug("bl_no" + bl_no + "]");
			log.debug("bl_tp_cd : [" + bl_tp_cd + "]");
			log.debug("hiddenData : [" + hiddenData + "]");
			log.debug("rate : [" + rate + "]");
			log.debug("cntr : [" + cntr + "]");
			log.debug("corr_no : [" + corr_no + "]");
			log.debug("rider_yn : [" + rider_yn + "]");
			log.debug("houseBl_yn : [" + houseBl_yn + "]");
			log.debug("");
			log.debug("####################################################");
			*/
			
			eventResponse.setETCData("bkg_no", bkg_no);
			eventResponse.setETCData("bl_no", bl_no);
			eventResponse.setETCData("bl_tp_cd", bl_tp_cd);
			eventResponse.setETCData("rider_yn", rider_yn);
			eventResponse.setETCData("houseBl_yn", houseBl_yn);
			eventResponse.setETCData("fax_no", fax_no);
			eventResponse.setETCData("email", email);
			eventResponse.setETCData("obl_iss_flg", obl_iss_flg);
			if (null!=bookingCreationVO && null!=bookingCreationVO.getBkgBookingInfoVO()) {
				eventResponse.setETCData("por_cd",bookingCreationVO.getBkgBookingInfoVO().getBkgPorCd());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * Email transfer event process<br>
     * Email transfer.(ESM_BKG_0218,ESM_BKG_0927)<br>
     *
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendDblWblByEmail(Event e) throws EventException {
        GeneralEventResponse eventResponse = null;
        EsmBkg0218Event event0218 = null;
        EsmBkg0927Event event0927 = null;        
        BLIssuanceBC command = null;
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
        try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();
			if ("EsmBkg0218Event".equalsIgnoreCase(e.getEventName())) {
				uiId = "ESM_BKG_0218";
				event0218 = (EsmBkg0218Event)e;
	        	bkgNtcHisVOs = command.sendDblWblByEmail(event0218.getDblWblVOs(), event0218.getBkgEmlEdtVO(), account);
			} else if ("EsmBkg0927Event".equalsIgnoreCase(e.getEventName())) {
            	uiId = "ESM_BKG_0927";
				event0927 = (EsmBkg0927Event)e;
	        	bkgNtcHisVOs = command.sendDblWblByEmail(event0927.getDblwblvos(), null, account);
			} 
        	hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

//    /**
//     * Email transfer event process<br>
//     * Email transfer.(ESM_BKG_0218)<br>
//     *
//     * @author
//     * @param e Event
//     * @return EventResponse
//     * @exception EventException
//     */
//	private EventResponse sendDblWblByGroupEmail(Event e) throws EventException {
//        GeneralEventResponse eventResponse = null;
//        EsmBkg0218Event event0218 = null;
//        BLIssuanceBC command = null;
//        BookingHistoryMgtBC hisBC = null;
//    	String uiId = null;
//    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
//        try {
//        	begin();
//            eventResponse = new GeneralEventResponse();
//            command = new BLIssuanceBCImpl();
//            hisBC = new BookingHistoryMgtBCImpl();
//			uiId = "ESM_BKG_0218";
//			event0218 = (EsmBkg0218Event)e;
//        	bkgNtcHisVOs = command.sendDblWblByGroupEmail(event0218.getDblWblVOs(), event0218.getBkgEmlEdtVO(), account);
//        	hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
//            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
//            commit();
//        } catch(EventException ex) {
//        	rollback();
//            throw ex;
//		} catch (Exception ex) {
//            rollback();
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//		}
//        return eventResponse;
//    }	
    /**
     * Email transfer event process<br>
     * Email transfer.(ESM_BKG_0218)<br>
     *
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendDblWblByGroupEmail(Event e) throws EventException {
        GeneralEventResponse eventResponse = null;
        EsmBkg0218Event event0218 = null;
        BLIssuanceBC command = null;
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
        try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();
			uiId = "ESM_BKG_0218";
			event0218 = (EsmBkg0218Event)e;
        	bkgNtcHisVOs = command.sendDblWblByGroupEmail2(event0218.getDblWblVOs(), event0218.getBkgEmlEdtVO(), account);
        	hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }	    
    /**
     * Fax transfer event process<br>
     * Fax transfer.(ESM_BKG_0218,ESM_BKG_0927)<br>
     *
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse sendDblWblByFax(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = null;
        EsmBkg0218Event event0218 = null;
        EsmBkg0927Event event0927 = null;
        
        BLIssuanceBC command = null;
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
        try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();
			if ("EsmBkg0218Event".equalsIgnoreCase(e.getEventName())) {
				uiId = "ESM_BKG_0218";
				event0218 = (EsmBkg0218Event)e;
	        	bkgNtcHisVOs = command.sendDblWblByFax(event0218.getDblWblVOs(), account);
			} else if ("EsmBkg0927Event".equalsIgnoreCase(e.getEventName())) {
            	uiId = "ESM_BKG_0927";
				event0927 = (EsmBkg0927Event)e;
	        	bkgNtcHisVOs = command.sendDblWblByFax(event0927.getDblwblvos(), account);
    		} 
        	hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * retrieving data for setting screen of B/L preview.(ESM_BKG_0418)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse validMfForPrtByBl(Event e) throws EventException {
		EsmBkg0418Event event = (EsmBkg0418Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		VskVslPortSkdVO vskVslPortSkd = new VskVslPortSkdVO();
		
		String mode = "";
		String vvd = "";
		String port = "";
		// --- Vessel Schedule ---
		String vsl_cd = "";
		String voy_no = "";
		String dir_cd = "";
		String clpt_ind_seq = "";
		// --- Vessel Schedule ---
		String[] bkgBlNos = null;
		
		// VESSEL SKD ERROR
		boolean bVesselSkd = false;
		// VVD Registration ERROR
		boolean bVvd = false;
		// B/L no or BKG no ERROR
		boolean bBkgBlNo = false;
		String strBkgNo = "";

		try {
			
			mode = event.getMode();
			vvd = event.getVvd();
			port = event.getPort();
			vsl_cd = event.getVslCd();
			voy_no = event.getVoyNo();
			dir_cd = event.getDirCd();
			clpt_ind_seq = event.getClptIndSeq();
			
			bkgBlNos = event.getBkgBlNos();
			
			// Vessel Schedule retrieve - searchEtbEtdEta(vslCd, voyNo, dirCd, portCd, clptlndSeq)
			// ERROR transaction in case of not registrated VESSEL SKD - CoBkg.js ===> BKG00100
			vskVslPortSkd = utilCmd.searchEtbEtdEta(vsl_cd, voy_no, dir_cd, port, clpt_ind_seq);
			
			if (vskVslPortSkd != null) {
				//
				bVesselSkd = true;
			}
			
			// checking whether VVD exists or not
			// - validateVvdLoc(vslCd, voyNo, dirCd, locCd)
			// error return in case of when Calling Port not registrated VVD
			// - CoBkg.js ===> BKG00007
			if (bVesselSkd) {
				//
				if (utilCmd.validateVvdLoc(vsl_cd, voy_no, dir_cd, port)) {
					bVvd = true;
				}
			}
			
			// check error (B/L no or BKG no) 
			// in case of B/L no or BKG no error - CoBkg.js ===> BKG00273
			if ( bVesselSkd == true && bVvd == true && bkgBlNos != null && bkgBlNos.length > 0) {
				//
				strBkgNo = command.validBkgBlNo(mode, vvd, port, bkgBlNos);
				
				if (!strBkgNo.equals("")) {
					bBkgBlNo = strBkgNo.indexOf("Error_") == 0 ? false : true;
				}
			}
			
			eventResponse.setETCData("bVesselSkd", bVesselSkd == false ? "BKG00100": "");
			eventResponse.setETCData("bVvd", bVvd == false ? "BKG00007": "");
			eventResponse.setETCData("bBkgBlNo", bBkgBlNo == false ? "BKG00273": "");
			eventResponse.setETCData("bkgNos", strBkgNo);
			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * searchBkgInfoForFaxEmail(ESM_BKG_0221)
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgInfoForFaxEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
        EsmBkg0221Event event = (EsmBkg0221Event)e;
    	BookingUtil util = null;
    	BkgRouteVO bkgRouteVO = null; 
    	try {
    		util = new BookingUtil();
    		bkgRouteVO = util.searchBkgRoute(event.getBkg_no());
    		if (null!=bkgRouteVO) {
    			eventResponse.setETCData("por_cd",bkgRouteVO.getPorCd());
    		}
        } catch(EventException ex) {
            throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
	}

	/**
	 * sendFaxEmailByBkgNoList(ESM_BKG_0221)
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendFaxEmailByBkgNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

        EsmBkg0221Event event = null;
        BLIssuanceBC command = null;
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
    	BookingUtil utilBC = null;
    	try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();
        	uiId = "ESM_BKG_0221";
        	event = (EsmBkg0221Event)e;
        	
        	log.debug("sendFaxEmailByBkgNoList==========121212121212");
        	
        	DblWblVO[] faxDblwblvos = new DblWblVO[1];
        	
        	DblWblVO[] emlDblwblvos = new DblWblVO[1];
        	
        	if (!event.getDblwblvos()[0].getRcvinfo().equalsIgnoreCase("")) {
        		faxDblwblvos[0] = event.getDblwblvos()[0];
        		bkgNtcHisVOs = command.sendDblWblByFax(faxDblwblvos, account);
        		if (!"N".equals(event.getDblwblvos()[0].getHistoryGubun())) {
        			hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
        		}
        	}
        	
        	if (!event.getDblwblvos()[1].getRcveml().equalsIgnoreCase("")) {
        		emlDblwblvos[0] = event.getDblwblvos()[1];
        		if (0>emlDblwblvos[0].getBkgNo().indexOf("|")) {
	        		utilBC = new BookingUtil();
	        		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
	        		bkgBlNoVO.setBkgNo(emlDblwblvos[0].getBkgNo());
	        		bkgBlNoVO = utilBC.searchBkgBlNoVO(bkgBlNoVO);
	        		emlDblwblvos[0].setBlNo(bkgBlNoVO.getBlNo());
        		}
            	bkgNtcHisVOs = command.sendDblWblByEmail(emlDblwblvos, null, account);
           		if (!"N".equals(event.getDblwblvos()[1].getHistoryGubun())) {
            		hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
        		}
        	}
        	
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
	}

	/**
	 * searchEmailEdit(ESM_BKG_1096)
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchEmailEdit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
        EsmBkg1096Event event = (EsmBkg1096Event)e;
        BkgEmlEdtVO bkgEmlEdtVO = null;
        BkgBlNoVO bkgBlNoVO = null;
    	BookingUtil util = null;
    	BookingUtil vvd = null;
		List<String> bkgNoList = null;
    	String ntcKndCd = null;
    	StringBuilder subjectSb = null;
        Hashtable<String,String> templateArgs = null;
    	String template = "";
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String brRead = null;
        String outRead = null;
		ComUserVO comUserVO = null;
		BLIssuanceBC blBC = null;
		CODCorrectionBC codBC = null;
//		CodVO codVO = null;
		CodMailSendVO codMailSendVO = null;
		
    	try {
    		util = new BookingUtil();
    		blBC = new BLIssuanceBCImpl();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
    		bkgEmlEdtVO = event.getBkgEmlEdtVO();
    		if (null!=bkgEmlEdtVO.getEdtBkgNoList() && !"".equals(bkgEmlEdtVO.getEdtBkgNoList())) {
    			bkgNoList = Arrays.asList(bkgEmlEdtVO.getEdtBkgNoList().split("\\|"));
        		ntcKndCd = bkgEmlEdtVO.getEdtNtcKndCd();
    			if (null!=bkgNoList && 0<bkgNoList.size()) {
		    		bkgBlNoVO = new BkgBlNoVO();
		    		bkgBlNoVO.setBkgNo(bkgNoList.get(0));
		    		bkgBlNoVO.setCaUsrId(account.getUsr_id());
		    		bkgBlNoVO = util.searchBkgBlNoVO(bkgBlNoVO);
		    		if(!bkgBlNoVO.getBlNo().equals("")){
		    			bkgBlNoVO.setBlNo("NYKS"+bkgBlNoVO.getBlNo());
		    		}
		    		subjectSb = new StringBuilder();
		    		templateArgs = new Hashtable<String,String>();
		    		if ("BK".equalsIgnoreCase(ntcKndCd)) {
			    		if (1<bkgNoList.size()) {
			    			subjectSb.append("Booking Receipt Notice (BKG No : ").append(bkgNoList.get(0)).append(" and ").append(bkgNoList.size()-1).append(" bookings)");
							templateArgs.put("bkgNoTitle", "BKG No : "+bkgEmlEdtVO.getEdtBkgNoList().replaceAll("\\|", ", "));
							templateArgs.put("bkgNoBody", bkgEmlEdtVO.getEdtBkgNoList().replaceAll("\\|", ", "));
			    		} else {
			    			subjectSb.append("Booking Receipt Notice (BKG No : ").append(bkgNoList.get(0)).append(")");
							templateArgs.put("bkgNoTitle", "BKG No : "+bkgNoList.get(0));
							templateArgs.put("bkgNoBody", bkgNoList.get(0));
			    		}
						template = "ESM_BKG_0098_01T.html";
					} else if ("CN".equalsIgnoreCase(ntcKndCd)) {
						subjectSb.append("Empty Release Order (BKG No : ").append(bkgNoList.get(0)).append(")");
						template= "ESM_BKG_0252_01T.html";
						templateArgs.put("bkgNoTitle", "BKG No : "+bkgNoList.get(0));
						templateArgs.put("bkgNoBody", bkgNoList.get(0));
					} else if ("BL".equalsIgnoreCase(ntcKndCd) || "WB".equalsIgnoreCase(ntcKndCd) || "NN".equalsIgnoreCase(ntcKndCd) || "CW".equalsIgnoreCase(ntcKndCd)) {
			    		if ("BL".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("Draft B/L(s)");
							template = "ESM_BKG_0218_01T.html";
			    		} else if ("WB".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("Sea Waybills");
							template = "ESM_BKG_0218_02T.html";
			    		} else if ("NN".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("B/L Copy");
							template = "ESM_BKG_0218_03T.html";
			    		} else if ("CW".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("Copy Sea Waybills");
							template = "ESM_BKG_0218_04T.html";
			    		}
			    		vvd = new BookingUtil();
			    		String vsl = vvd.searchVslEngNmCssmVoyNo(bkgBlNoVO.getBkgNo());
			    		if (1<bkgNoList.size()) {
			    			subjectSb.append(" (B/L No : ").append(bkgBlNoVO.getBlNo()).append(" and ").append(bkgNoList.size()-1).append(" B/Ls)");
							templateArgs.put("blNoTitle", "B/L No : "+bkgBlNoVO.getBlNo()+" and "+(bkgNoList.size()-1)+" B/Ls");
			    			StringBuilder sb = new StringBuilder();
			    			for (String bkgNo : bkgNoList) {
					    		bkgBlNoVO = new BkgBlNoVO();
					    		bkgBlNoVO.setBkgNo(bkgNo);
					    		bkgBlNoVO.setCaUsrId(account.getUsr_id());
					    		bkgBlNoVO = util.searchBkgBlNoVO(bkgBlNoVO);
					    		if(!bkgBlNoVO.getBlNo().equals("")){
					    			bkgBlNoVO.setBlNo("NYKS"+bkgBlNoVO.getBlNo());
					    		}
					    		sb.append(bkgBlNoVO.getBlNo()).append(", ");
			    			}
	    					sb.delete(sb.lastIndexOf(","), sb.length());
							templateArgs.put("blNoBody", sb.toString());
			    		} else {
			    			subjectSb.append(" (B/L No : ").append(bkgBlNoVO.getBlNo()).append(")");
							templateArgs.put("blNoTitle", "T/VVD : "+vsl+" / B/L No : "+bkgBlNoVO.getBlNo());
							templateArgs.put("blNoBody", bkgBlNoVO.getBlNo());
			    		}
			    		
			    		if("BL".equalsIgnoreCase(ntcKndCd)) {
			    			List<DblWblVO> rmkList = blBC.searchDblRemarkByBkgNo(bkgBlNoVO.getBkgNo());
			    			String rmk = "";
			    			String diffRmk = "";
			    			if(rmkList != null){
			    				if(rmkList.size()>0){
			    					rmk = rmkList.get(0).getRemark().replaceAll("(\r\n|\n)", "<br>");
			    					if(rmk.endsWith("<br>")){
			    						rmk = rmk.substring(0, rmk.length()-4);
			    					}
			    					
			    					diffRmk = rmkList.get(0).getDiffRmk();
			    				}
			    				if(rmk.length()==0 && diffRmk.length()==0){
			    					templateArgs.put("blRemark", "");
			    				}else if(rmk.length()==0){
			    					templateArgs.put("blRemark", "<br><br>"+diffRmk);
			    				}else if(diffRmk.length()==0){
			    					templateArgs.put("blRemark", "<br><br>"+rmk);
			    				}else{
			    					templateArgs.put("blRemark", "<br><br>"+rmk+"<BR>"+diffRmk);
			    				}
			    			}
			    		}
			    		
					} else if ("SN".equalsIgnoreCase(ntcKndCd) || "HI".equalsIgnoreCase(ntcKndCd) || "HO".equalsIgnoreCase(ntcKndCd)) {
						if ("SN".equalsIgnoreCase(ntcKndCd)) {
							subjectSb.append("O.B/L Surrender Notice [B/L No : "+bkgBlNoVO.getBlNo()+"]");
							template = "ESM_BKG_0095_01T.html";
							templateArgs.put("blNo",bkgBlNoVO.getBlNo());
						} else if ("HI".equalsIgnoreCase(ntcKndCd) || "HO".equalsIgnoreCase(ntcKndCd)) {
							subjectSb.append("TRO Notice [B/L No : "+bkgBlNoVO.getBlNo()+"]");
							template = "ESM_BKG_0095_02T.html";
							templateArgs.put("blNo",bkgBlNoVO.getBlNo());
						}
	    			} else if ("CD".equalsIgnoreCase(ntcKndCd)){
	    				codBC = new CODCorrectionBCImpl();
	    				codMailSendVO = new CodMailSendVO();
	    				codMailSendVO.setBkgNo(bkgEmlEdtVO.getEdtBkgNoList());
	    				codMailSendVO.setCodRqstSeq(bkgEmlEdtVO.getCodRqstSeq());
	    				codMailSendVO = codBC.searchCODEmailInfo(codMailSendVO, account);
//	    				String[] content = bkgEmlEdtVO.getComContent().split(",");
	    				subjectSb.append(bkgEmlEdtVO.getComSubject());
	    				template = "ESM_BKG_0156_01T.html";
//						templateArgs.put("codSts", content[3]); 	//codSts
//						templateArgs.put("bkgNo", content[5]); 		//bkgNo
//						templateArgs.put("vslEngNm", content[6]);	//vslEngNm
//						templateArgs.put("obCssmVoyNm", content[7]);//obCssmVoyNm
//						templateArgs.put("codRemark", content[4]);
	    				templateArgs.put("codSts", codMailSendVO.getCodSts());
	    				templateArgs.put("bkgNo", codMailSendVO.getBkgNo());
	    				templateArgs.put("vslEngNm", codMailSendVO.getVslEngNm());
	    				templateArgs.put("obCssmVoyNm", codMailSendVO.getObCssmVoyNm());
	    				codMailSendVO.setCodRemark(codMailSendVO.getCodRemark().replace("\n","<br/>"));
	    				templateArgs.put("codRemark", codMailSendVO.getCodRemark());
//						codBC = new CODCorrectionBCImpl();
//						codVO = codBC.searchCODCntrforMail(codMailSendVO.getBkgNo(), codMailSendVO.getCodSts(), bkgEmlEdtVO.getCodRqstSeq());
//						List<CodCntrVO> list = codVO.getCodCntrVO();
//						StringBuffer cntr_content = new StringBuffer();
//						for(int i=0; i < list.size(); i++){
//							if("N".equalsIgnoreCase(list.get(i).getChk())){
//								continue;
//							}
//							cntr_content.append("<tr align=center>");
//							cntr_content.append("<td>"+ list.get(i).getCntrNo() +"</td>");
//							cntr_content.append("<td>"+ list.get(i).getCntrTpszCd()+" ["+list.get(i).getCntrTpszDesc()+"]" +"</td>");
// 							cntr_content.append("<td>"+ list.get(i).getCntrWgt() +"</td>");
//							cntr_content.append("</tr>");
//						}
						templateArgs.put("cntrList", codMailSendVO.getCntrList());
						templateArgs.put("oldPol", codMailSendVO.getOldPol());
						templateArgs.put("oldPod", codMailSendVO.getOldPod());
						templateArgs.put("newPod", codMailSendVO.getNewPod());
					}
						
	    			file = new File(SiteConfigFactory.getWhenNullThrowException("COM.CLT.JAF.MAIL.TEMPLATE.DIR"), template);
	                fis = new FileInputStream(file);
	                isr = new InputStreamReader(fis, "UTF-8");
	                br = new BufferedReader(isr);
	                for(outRead = ""; (brRead = br.readLine()) != null; outRead = (new StringBuilder(String.valueOf(outRead))).append("\n").append(brRead).toString());
	                bkgEmlEdtVO.setEdtCcEml(util.searchCcEmailAddrRSQL(ntcKndCd, account.getUsr_id()));
//	                bkgEmlEdtVO.setEdtFromEml(account.getUsr_eml());
	                bkgEmlEdtVO.setEdtFromEml(sUsrEml);
	                bkgEmlEdtVO.setEdtSubject(subjectSb.toString());
	                bkgEmlEdtVO.setEdtContents(parseTemplate(outRead.toString(),templateArgs));
	                br.close();		//by kimtk. 2015.05.22 //Security	[CWE-404] I/O release	I/O�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋占쎌젂占쎈뼇占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎈쾫 �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�뮋�뜝�럥堉붹뤆�룊�삕�뜝�럡愿닷뜝�럥�맶�뜝�럥�쐾�뜝�럥�쐻占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윪占쎌맚占쎈쐻占쎈윪占쎈츎嚥싲갭큔鸚룔굩�삕占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇔뜝�럥�맶�뜝�럥�쑅�뜝�럥爰묈뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쐾�뜝�럥堉껓옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥筌뚭내�삕占쎌맶�뜝�럥�쐾�뜝�럥占쎈짘�쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈뙑�ⓦ끉�굲.
    			}
    		}
            eventResponse.setRsVo(bkgEmlEdtVO);
    	} catch (FileNotFoundException ex) {
			log.error(ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (IOException ex) {
			log.error(ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	} catch(EventException ex) {
            throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
	}

	/**
	 * parseTemplate(ESM_BKG_1096)<br>
	 * retrieving TemplateMail class for preview template email.<br>
	 * 
	 * @author
     * @param String s
     * @param Hashtable<String,String> args
     * @return String
     * @exception Exception
	 */
    private String parseTemplate(String s,Hashtable<String,String> args) throws Exception {
        StringBuffer content = new StringBuffer();
        String remainder;
        int markEndPos;
        for(; s.length() > 0; s = remainder.substring(markEndPos + 1)) {
            int position = s.indexOf("<@");
            if(position == -1) {
                content.append(s);
                break;
            }
            if(position != 0) {
                content.append(s.substring(0, position));
            }
            if (s.length() == position + 2) {
                break;
            }
            remainder = s.substring(position + 2);
            markEndPos = remainder.indexOf(">");
            if(markEndPos == -1) {
                break;
            }
            String argname = remainder.substring(0, markEndPos).trim();
            String value = null;
            value = (String)args.get(argname);
            if (value != null) {
                content.append(value);
            }
            if (remainder.length() == markEndPos + 1) {
                break;
            }
        }
        return content.toString();
    }


	/**
	 * booking creation, split, c/a confirm�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒱占쎈쭒嶺뚣끇�꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�맱�뇯�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럡�뜦�뜝�럡�꼤�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌욌쪋�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅嶺뚋욌９�뀋�뜝�럡�땽�뜝�럥裕됵옙�쐻占쎈윞�굜�굩�삕占쎌뒗占쎌슱�삕占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈굻�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥筌뚭내�삕占쎌맶�뜝�럥�쐾�뜝�럥占쎈짘�쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈뙑�ⓦ끉�굲<br>
	 * VVD �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌앹룞�삕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎄틟�뜝�럩援뀐옙�쐻占쎈윪占쎌쓠�뜝�럥�맶�뜝�럥�쑅嶺뚯빖諭띰옙�맶�뜝�럥�쑋占쎈쨨�뜝�룞�삕占쎌맶�뜝�럥�쑅�뜝�럩�꼪�뜝�럥�맶�뜝�럥�쑅�뜝�럩二멨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼�뜝�럥�떛�뜝�럥�맄�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎈첋占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎄틢占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉굋cl Cargo �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윥�뜝�룞�삕占쎌맶�뜝�럥�쑋�뜝�럩留푧uest �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ猷귨옙援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈꺏占쎌굲�뜝�럡�떅�뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡�뒋占쎈닱占쎈쐞占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋占쎌젂占쎈뼠占쎌굲�뜝�럩二멨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇔뜝�럥�맶�뜝�럥�쑋�뜝�럥占쏙옙�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	private String reRequestSpclCgoApproval(BkgBlNoVO bkgBlNoVO) throws EventException {
		try{
			String result = "Not Request";
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();			
			ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, null, account);
			ScgVvdAproRqstVO[] scgVvdVOs = null;
			// spcl cgo�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쐾�뜝�럥堉껓옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼇�븶占쎄덩占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�몱占쎌맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄わ┼�슣鍮볡몭�뜉�삕占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슢�뵯占쎈뮦�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾袁㏉�쀯옙維믧큺�봿裕뗰옙�굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋占쎈쐻占쎈짗占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윞�눧�뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇 �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ猷귨옙援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈꺏占쎌굲�뜝�럡�떅�뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡�뒋占쎈닱占쎈쐞占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋占쎌젂占쎈뼠占쎌굲�뜝�럩二멨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇔뜝�럥�맶�뜝�럥�쑋�뜝�럥占쏙옙�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
	        if(scgAproRqstVOs.length>0){
				OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
				SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();
				
				SpclCgoAproApplVO           spclCgoAproVO = new SpclCgoAproApplVO();
				try {
					scgVvdVOs = spclReceiptBC.searchBkgVvd(bkgBlNoVO.getBkgNo());
			        
			        boolean isDg = false;
					for(int i=0;i<scgAproRqstVOs.length;i++){
						if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
							isDg = true;
							break;
						}
					}
					
					//target lane�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎄슈占쎄섶占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈콦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌겲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛筌��맮�삕占쎌��윜諛잙쳛占쎄뎡�뜝�럥夷⑨옙�쐻�뜝占� 
					if(scgVvdVOs.length>0){						
						//danger�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쐾�뜝�럥堉껓옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼇�븶占쎄덩占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�몱占쎌맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎄슈占쎄섶占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈콦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌겲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛筌��맮�삕占쎌��윜諛잙쳛占쎄뎡�뜝�럥夷⑨옙�쐻�뜝占� 
						if(isDg){
							for(int vvdIdx=0; vvdIdx<scgVvdVOs.length; vvdIdx++){
								/********************************************************************************************************************************************
								 * cf.) 
								 * PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
								 * preRestrictionInputVO.setBkgNo("ATLX1210006");
								 * preRestrictionInputVO.setVslCd("HNBR");
								 * preRestrictionInputVO.setSkdVoyNo("0039");
								 * preRestrictionInputVO.setSkdDirCd("E");
								 * PreRestrictionOutputVO chkRslt = checkPreRestriction(preRestrictionInputVO, false, true, true);
								 * boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
								 * boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶占쎈쐻�뜝占� Prohibition
								 * boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
								 * List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();		//Detail of Segregation Validation
								 * List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶占쎈쐻�뜝占� Prohibition
								 * List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
								 ********************************************************************************************************************************************/
								PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
								preRestrictionInputVO.setBkgNo(bkgBlNoVO.getBkgNo());
								preRestrictionInputVO.setVslCd(scgVvdVOs[vvdIdx].getVslCd());
								preRestrictionInputVO.setSkdVoyNo(scgVvdVOs[vvdIdx].getSkdVoyNo());
								preRestrictionInputVO.setSkdDirCd(scgVvdVOs[vvdIdx].getSkdDirCd());
								preRestrictionInputVO.setInnerPreRestrictionInputVO(preRestrictionInputVO);
								PreRestrictionOutputVO chkRslt = spclAproBC.checkPreRestriction(preRestrictionInputVO, false, true, true);
								
								boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
								boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶占쎈쐻�뜝占� Prohibition
								boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
			//					List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();	//Detail of Segregation Validation
								List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶占쎈쐻�뜝占� Prohibition
								List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
								
			//					pre check�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋占쎌젂占쎈뼇占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�걨占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윞占쎈㎞占쎈쐻占쎈쑆獄��꺈�삕亦끸댙�삕�얘퉵�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄텫占쎈쐻占쎈윥�댆�뿥�쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌뚳옙�뜝�럥�맶�뜝�럥�쑅�뜝�럥猷억옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥�젆占쏙옙�쐻占쎈윞占쎄샴占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥泥뗥뜝�럥�맶�뜝�럥�쑅�뜝�럥瑗⑨옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥裕쎿セ�뿫遊욜몭�궪�삕占쎄뎡癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉굋cl request �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈짎�뜝�럥�맶�뜝�럥�쑅�뜏類ｋ염占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럩�쟼占쎄껀獄쏅챷쨘占쎈쐻占쎈윥筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲�젆�룇�뒻占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌앹룞�삕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎄틟�뜝�럩援뀐옙�쐻占쎈윪占쎌쓠�뜝�럥�맶�뜝�럥�쑅嶺뚯빖諭띰옙�맶�뜝�럥�쑋占쎈쨨�뜝�룞�삕占쎌맶�뜝�럥�쑅�뜝�럩�꼪�뜝�럥�맶�뜝�럥�쑅�뜝�럩二멨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼�뜝�럥�떛�뜝�럥�맄�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎈첋占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎄틢占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥筌뚭내�삕占쎌맶�뜝�럥�쐾�뜝�럥占쎈짘�쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈뙑�ⓦ끉�굲.
								if(segRslt == true || vslRslt == true || prtRslt == true){
									result = "pre-checking";
									String spclRqstDesc = "After implementation pre-checking routines at T/S port, found some conflicts or prohibitions.\n" +
														  "Please check the conflicts or prohibitions.";
									if(vslRsltDtl.size()>0){
										for(int vslIdx=0; vslIdx<vslRsltDtl.size(); vslIdx++){
											spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, vslRsltDtl.get(vslIdx).getSpclCgoSeq(), account);
										}
									}
									
									if(prtRsltDtl.size()>0){
										for(int prtIdx=0; prtIdx<prtRsltDtl.size(); prtIdx++){
											spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, prtRsltDtl.get(prtIdx).getSpclCgoSeq(), account);
										}
									}
								}
							}
						}
						
			        	// bkg update, c/a confirm�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윥�뜝�룞�삕占쎌맶�뜝�럥�쑅占쎈쨨占쎈뀊 checking�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲占쎈쨨占쎈즸占쎌굲壤깍옙�몴怨멸뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윞占쎈㎞占쎈쐻占쎈쑆獄��꺈�삕亦끸댙�삕�얘퉵�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄텫占쎈쐻占쎈윥�댆�뿥�쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌뚳옙�뜝�럥�맶�뜝�럥�쑅�뜝�럥猷억옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇔뜝�럥�맶�뜝�럥�쑋�뜝�럥占쏙옙�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄괼�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걖�뜝�럥�맶�뜝�럥�쑅占쎈뙀占쎈쑕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먲퐢�뿼�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�룞�삕占쎌녇熬곥룊占쎌���삕泳�誘ｋ쐻占쎈윥占쎈폇�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎄섈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈꺏占쎌굲嶺뚮Ĳ猷귨옙援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쇀�뜝�룞�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
						spclCgoAproVO.setBkgNo(bkgBlNoVO.getBkgNo());
						spclCgoAproVO.setAccount(account);
						spclCgoAproVO.setCreUsrId(account.getUsr_id());
						spclCgoAproVO.setUpdUsrId(account.getUsr_id());
						spclCgoAproVO.setSpclReqInVOs(searchBC.searchSpclReqInVO(bkgBlNoVO));
						
						for(int i=0;i<scgAproRqstVOs.length;i++){
							if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
								spclCgoAproVO.setSpclCgoTp("D");
								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);	
							}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
								spclCgoAproVO.setSpclCgoTp("R");
								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
							}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
								spclCgoAproVO.setSpclCgoTp("A");
								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
							}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
								spclCgoAproVO.setSpclCgoTp("B");
								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
							}	
						}		
		
						//SCG �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�몺占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜝�뜫�걦占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럡愿쇔뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뜝�럥援겼뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럡肄ゅ뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�걨占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類㏃삕占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�굛�ｏ옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜏類ㅻ뼠占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥�솗占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶占쎈쐻�뜝占�		        
				        for(int i=0;i<scgAproRqstVOs.length;i++){
				        	ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
				        	scgAproRqstVO[0] = scgAproRqstVOs[i];
							if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
							}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
							}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
							}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
							}	
				        }
		        	}
				} catch (Exception se){
			        log.error(se.toString(), se);					
				}
	        }
	        return result;
	    }catch(EventException ex){
	        log.error(ex.toString());
	    	throw ex;
	    }catch(Exception ex){
	        log.error(ex.toString());
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
	    }
	}
	
	/**
	* EsmBkg1074Event (ESM_BKG_1074)<br>
	* 
	* @author 
	* @param e Event
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchCustInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<AuthCustVO> authCustVOs = null;
		EsmBkg1074Event event = (EsmBkg1074Event) e;
		String bkg_no = event.getBkgNo();
		//String bl_no = event.getBlNo();

		try {
			log.debug("START: searchCustInfo() ====> [" + e.getEventName() + "]");
			// 1. CUSTOMER SHPR/FWDR �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥궘占쏙옙�걠�뙴�돍�삕占쎄돈占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쑅占쎌젂筌먯빖�맶�뜝�럥�쑅嶺뚯쉳�옱占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�떌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌ｋ뿧�녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ŋ�뼔占쎄숲占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윥�뜝�뜫援⑼옙�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윪�젆癒るき占쎈쐣占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺쇳닧�뙴遺쎈��뜝�럩援뀐옙�쐻占쎈윞占쎈젇
			authCustVOs = command.searchCustInfo(bkg_no);
			log.debug("END: searchCustInfo() ====> [" + e.getEventName() + "]");
			eventResponse.setRsVoList(authCustVOs);
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
	* EsmBkg1074Event (ESM_BKG_1074)<br>
	* send email<br>
	* 
	* @author 
	* @param e Event
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse sendAuthEmail(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command 	= new BLIssuanceBCImpl();
		EsmBkg1074Event event 	= (EsmBkg1074Event) e;
    	BookingUtil util = null;

		String recipient		= event.getEmailTo();
		String subject 			= event.getEmailSubject();
		String cntent 			= event.getEmailContents();

		try {
			
			begin();
			
			log.debug("START: sendAuthEmail() ====> [" + recipient + "]");
			log.debug("START: sendAuthEmail() ====> [" + subject + "]");
			log.debug("START: sendAuthEmail() ====> [" + cntent + "]");
			// �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡�뒋占쎈닱占쎈늉占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜏類ㅻ뼠占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥�솗占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럩�쐪�뜝�럩�뮦�뜝�럩援�  account.getUsr_Eml() -> getDfltEml()

			ComUserVO comUserVO = null;
			util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = new BookingUtil().searchComUserInfo(account.getUsr_id()).getDfltEml();
			
			String[] recipientArr    = recipient.split("\\;");
			int size = recipientArr.length;
			for(int i=0;i<size;i++){
				 if(recipientArr[i].equals("")) continue;
				 	Mail amail = new Mail();	        	
		        	
		    		amail.setRecipient(recipientArr[i]);
//		    		amail.setFrom(account.getUsr_eml());
//		    		amail.setFrom(sUsrEml);
		    		amail.setFrom("noreply@nykline.com");
		    		amail.setSubject(subject);
		    		amail.setHtmlContent(cntent);
		        	// CC, BCC�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋嶺뚮씮�뼠占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄괼占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥占쎈뱜�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥���뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럥�읇�뜝�럥�맶�뜝�럥�쑋�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類㏃삕占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎌넇占쎈쐻占쎈윥�댆�뿥�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�뙴�눦�삕占쎌맶�뜝�럥�쑅�뜝�럥猷억옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅占쎈き�맦占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걮�뜝�럥�맶�뜝�럥�쑋占쎈쐻占쎈짗占쎌굲�뜝�럩留놂옙�쎗占쎈즵占쎌굦占쎈뙕占쎈젿占쎌맶�뜝�럥�쐾�뜝�럥�젃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥堉℡뜝�럡�뀷占쎈쇀占쎈젿占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅嶺뚋욎쉵逾얍뜝�럩�뮦�뜝�럩援꿨뜝�럥�맶�뜝�럥�쑅鶯ㅼ룇짹占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�룞�삕�뜝�럥�맶�뜝�럥�쐾�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럥吏륅옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥筌Ξ룹녇占쎄틓占쎈뮉�뜝�럡肄わ옙�쐻占쎈윞占쎈윝�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽 null�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒱占쎈쭒嶺뚣끇�꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎈쭨�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뛾占쏙옙�뒅占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔낃퉮占썲뜝�럡�뀷占쎄덩占쎄�椰꾟댙�삕占쎈뮲�뜝�럩援뀐옙�쐻占쎈윥�굜�껊쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥吏쀥뜝�럥�룛占쎈쐻占쎈윪占쎈츥占쎈쐻占쎈윥�뜝�럥�돇占쎌맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏁춯占쏙옙留�占쎌굲�뜝�럩占쏙옙�쐺獄쏆옓爾쎾뜝�럡�렊占쎈쐻占쎈윥鸚룐뫅�삕占쎌맶占쎈쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럩�뀇�윜諭�瑗띄뙴湲룸쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�젆�옚�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럩�꼪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럩�꼤占쎈쐻占쎈쑆泳�占썹뵓怨쀂깍옙�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뛾占쏙옙�뒻占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� set 2010.01.14 by cateshin
		        	//mailCustomVO.setCarbonCopy(cc);
		        	//mailCustomVO.setBlindCarbonCopy(cc);
	
					// �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉껓옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎄섈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊
					command.sendAuthEmail(amail);					
			}
			commit();
			log.debug("END: sendAuthEmail() ====> [" + recipient + "]");

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
	 * WEB_004_0001 : MULTI01<br>
	 * WebService EAI(WEB_004_0001)<br>
	 * @author Jong-ho Kim
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyWeb0040001ControlMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkgWeb0040001Event event = null;
		BLIssuanceBC command = null;
		try{
			eventResponse = new GeneralEventResponse();
			event = (EsmBkgWeb0040001Event)e;
			command = new BLIssuanceBCImpl();
			begin();
			BkgWebService004VO webVO = event.getBkgWebService004VO();

			command.modifyWeb0040001Control(webVO);
			
			// �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅占쎌젂占쎈�わ옙�맶�뜝�럥�쐾�뜝�럡�꺏�뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉껓옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒗占쎄콪�뜝�럡�럠占쎈쐻占쎈윪�뤃�먥뵾占쎌뒧占쎈뎐�뜝�럥�꽍占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚯쉶履뗰옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル쉵�끂�젞�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�쐻占쎈윪筌띾뿰�삕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윪筌띾쑚�쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}

		return eventResponse;
	}		

	/**
	 * retrieving e-mail template Info <br>
	 * 
	 * @author 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchEmlTemplate(Event e) throws EventException {

		EsmBkg1074Event event = (EsmBkg1074Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLIssuanceBC command = new BLIssuanceBCImpl();

		try {
			String[] template = command.searchEmlTemplate(event.getBkgNo(), "ESM_BKG_0079_09_02T.html");
			eventResponse.setETCData("emlTitle", template[0]);
			eventResponse.setETCData("emlBody", template[1]);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Empty Container Release Order Excel Download and Send FTP
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMtyRlseOrdForExcelDownloadBatch(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MtyRlseOrdInVO mtyRlseOrdInVO = new MtyRlseOrdInVO();
		
		String ftpYn = "N";
		String filePath = "";
		String fileType = "";
		String tempName = "";
		String fileHdName = "";
		String fileTaNm = "";
		String fileZipNm = "";
		
		String[] title1 = {"BOOKING NO","BOOKING DATE","BKG IND","TRUNK VESSEL LANE","VVD1 LANE","VVD1 VESSEL CODE","VVD1 LLOYD NO","VVD1 VESSEL NAME","VVD1 CALL SIGN","VVD1 VOYAGE","VVD1 DIR","CONS VOY","VVD1 POL ETD","VVD1 POD ETA","TRUNK VESSEL CODE","TRUNK VESSEL LLOYD NO","TRUNK VESSEL NAME","TRUNK VESSEL CALL SIGN","TVVD VOYAGE NO","TRUNK VESSEL VOYAGE DIR","POR NAME","POR OPUSCODE","POR UNCODE","POR YARD CODE","FIRST POL NAME","FIRST POL UNCODE","FIRST POL YARD","FIRST POL ETA","FIRST POD ETD","CUT OFF TIME FIRST POL","FINAL POD NAME","FINAL POD UNCODE","DEL OPUS CODE","DEL NAME","DEL UNCODE","REC DEL TYPE","REMARK FOR CUSTOMER","REMARK FOR VENDOR","COMMODITY CODE","COMMODITY CODE DESCRIPTION","MTY CNTR PICKUP CY","SHIPPER NAME","FORWARDER NAME","CONSIGNEE NAME","SHIPPER CODE","FWDR CODE","CONSIGNEE CODE","BKG STATUS","DRY IND","RFR IND","AWK IND","BBK IND","HAN IND","STOW IND","STOWAGE CODE","BKG OFFICE","BKG CONTACT POINT","SO NO","BLOCK STOW CODE","MTY PICKUP DATE","FULL RETURN DATE","MTY PICKUP CY COUNTRY","MTY PICKUP CY NAME","FULL RETURN YARD COUNTRY","FULL RETURN YARD NAME","STOW REMARK","EXPORT MRN NO.","SC NO","RFA NO","TAA NO"};
		String[] title2 = {"BOOKING NO","EQ TPSZ","ISO CODE","SPLIT COMB IND","MASTER BKG","BOOK EQ QTY","SOC IND","RD IND","CHS S","CHS D","CHS T","MHG"};
		String[] title3 = {"BOOKING NO","CNTR NO","CNTR TPSZ","SEAL NO","RF IND","DG IND","AK IND","BB IND","SOC IND","WGT QTY","WGT TP","RF CMDT CD","RF CMDT DESC","RF NET WT","RF GRS WT","RF WGT UNIT","TEMP UF","TEMP F","TEMP UC","TEMP C","RF VOLTAGE","VENT TYPE","VENT OPEN","VENT CMH","HUMID PC","GENSET REQ","RF REMARK","RF DRY","RF DRAIN","OVL FRONT","OVL REAR","OVH HIGH","OVW LEFT","OVW RIGHT","MOVE STS","EVENT YARD","EVENT TIME","VGM WEIGHT", "VGM WEIGHT UNIT CODE"};
		String[] title4 = {"BOOKING NO","LEG SEQ","TRANSPORT TYPE","LANE CODE","VESSEL CODE","LLOYD NO","VESSEL NAME","CALLSIGN","VOYAGE","VOY DIR","POL UNCODE","POL YARD","CALL SEQ","POL NAME","POL ETA","POL ETD","POD UNCODE","POD YARD","POD NAME","CONS VVD ARR","CONS VVD DEP"};
		String[] title5 = {"BOOKING NO","CNTR SEQ","CNTR TPSZ","CGO SEQ","CNTR NO","UNNO","CLASS","PSN","EMC PHONE","UN PAGE NO","FLASH POINT","F.POINT C","DG REMARKS","EMS NO","PSA CLASS","PACK GRP","MFAG","M.POLLUTE","SUB RISK1","OUTER PKG QTY","OUTER PKG UNIT","NET WGT","UOM","GRS WGT","UOM (KGS)","HAZ. CONTENTS","SUB RISK2","LTD QTY"};
		String[] title6 = {"BOOKING NO","CNTR NO","SEQ","PKG QTY","PKG UNIT","WGT QTY","WGT TP","MEASURE","MEA UNIT","COMMODITY"};
		String[] title7 = {"BOOKING NO","CNTR SEQ","CNTR TPSZ","CNTR NO","CMDT CODE","COMMODITY","TEMP","TEMP UNIT","VENT","REEFER RMK","PCK COUNT","NET WGT","GRS WGT","LENGTH","WIDTH","HEIGHT","OL FRONT","OL REAR","OW RIGHT","OW LEFT","OVER HIGH","AWK RMK"};
				
		String[] titleField1 = {"bkg_no","bkg_cre_dt","status","slan_cd","slan_cd1","vsl_cd","vvd_lloyd_no","vsl_eng_nm","vvd_call_sign","skd_voy_no","skd_dir_cd","cons_voy","vps_etd_dt","vps_eta_dt","vsl_cd1","trunk_vessel_lloyd_no","vsl_eng_nm1","trunk_vessel_call_sign","skd_voy_no1","skd_dir_cd_t","loc_nm","por_opscode","un_loc_cd","por_nod_cd","loc_nm1","un_loc_cd1","pol_nod_cd","vps_eta_dt1","vps_etd_dt1","cut_off_time_first_pol","loc_nm2","un_loc_cd2","del_opus_code","loc_nm3","un_loc_cd3","rcv_term_cd","xter_rmk","vndr_rmk","cmdt_cd","cmdt_nm","mty_pkup_yd_cd","cust_nm","cust_nm1","cust_nm2","cust_cnt_cd1","cust_cnt_cd2","cust_cnt_cd3","bkg_sts_cd","rd_cgo_flg","rc_flg","awk_cgo_flg","bb_cgo_flg","hngr_flg","stwg_rmk","stwg_cd","bkg_ofc_cd","bkg_contact_point","twn_so_no","blck_stwg_cd","mty_pkup_date","mty_pkup_date1","mty_pkup_yd_cd_t","full_return_yard_country","full_rtn_yd_cd","full_return_yard_name","stow_remark","cust_ref_no_ctnt","sc_no","rfa_no","taa_no"};
		String[] titleField2 = {"bkg_no","cntr_tpsz_cd","cntr_tpsz_iso_cd","spilt_combine","master_bkg","op_cntr_qty","soc_ind","eq_subst_cntr_tpsz_cd","chs_s","chs_d","chs_t","mhg"};
		String[] titleField3 = {"bkg_no","cntr_no","cntr_tpsz_cd","seal_no","rc_flg","dcgo_flg","awk_cgo_flg","bb_cgo_flg","soc_flg","cntr_wgt","wgt_ut_cd","cmdt_cd","cmdt_desc","net_wgt","grs_wgt","wgt_ut_cd1","temp_uf","fdo_temp","temp_uc","cdo_temp","vltg_no","cntr_vent_tp_cd","vent_rto","vent_cmh","humid_no","pwr_spl_cbl_flg","diff_rmk","rf_dry","rf_drain","ovr_fwrd_len","ovr_bkwd_len","ovr_hgt","ovr_lf_len","ovr_rt_len","move_sts","event_yard","event_time", "vgm_wgt", "vgm_wgt_ut_cd"};
		String[] titleField4 = {"bkg_no","leg_seq","vsl_pre_pst_cd","slan_cd","vsl_cd","lloyd_no","vsl_eng_nm","callsign","skd_voy_no","skd_dir_cd","un_loc_cd","pol_yd_cd","pol_clpt_ind_seq","loc_nm","vps_eta_dt","vps_etd_dt","un_loc_cd1","pod_yd_cd","loc_nm1","cons_vvd_arr","cons_vvd_dep"};
		String[] titleField5 = {"bkg_no","dcgo_seq","cntr_tpsz_cd","cntr_cgo_seq","cntr_no","imdg_un_no","imdg_clss_cd","prp_shp_nm","emer_cntc_phn_no_ctnt","un_page_no","flsh_pnt_cdo_temp","point_c","diff_rmk","ems_no","psa_no","imdg_pck_grp_cd","mfag","mrn_polut_flg","imdg_subs_rsk_lbl_cd1","out_imdg_pck_qty1","out_imdg_pck_cd1","net_wgt","wgt_ut_cd","grs_wgt","wgt_ut_cd1","hzd_ctnt","imdg_subs_rsk_lbl_cd2","imdg_lmt_qty_flg"};
		String[] titleField6 = {"bkg_no","cntr_no","cntr_mf_seq","pck_qty","pck_tp_cd","cntr_mf_wgt","wgt_ut_cd","meas_qty","meas_ut_cd","cntr_mf_gds_desc"};
		String[] titleField7 = {"bkg_no","cntr_seq","cntr_tpsz","cntr_no","cmdt_code","commodity","cdo_temp","temp_unit","vent_rto","diff_rmk","pck_qty","net_wgt","grs_wgt","ttl_dim_len","ttl_dim_wdt","ttl_dim_hgt","ovr_fwrd_len","ovr_bkwd_len","ovr_rt_len","ovr_lf_len","ovr_hgt","awk_rmk"};
				
		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
		
		try {
			String[] bkgNos = null;
			String hrdCdgId = "BKG_LDF_T";
			if ("CNTR".equals(String.valueOf(SiteConfigFactory.get("COM.CLT.JAF.MAIL.TEMPLATE.DIR")).split("/")[2])) {
				hrdCdgId = "BKG_LDF";
			}
			List<FtpInfoVO> ftpInfos = command.sendMtyRlseOrdByFTP(hrdCdgId);
			
			for (int z=0; z < ftpInfos.size(); z++) {
				mtyRlseOrdInVO.setDatetype("FTP");
				mtyRlseOrdInVO.setBkgOfcCd(ftpInfos.get(z).getOfcCd());
				mtyRlseOrdInVO.setFromDt(ftpInfos.get(z).getFromDt());
				mtyRlseOrdInVO.setEndDt(ftpInfos.get(z).getEndDt());
								
				fileHdName = ftpInfos.get(z).getOfcCd().substring(0, 3);
				fileType   = (!"".equals(ftpInfos.get(z).getFileType()) && ftpInfos.get(z).getFileType() != null) ? "."+ftpInfos.get(z).getFileType() : "";
				fileTaNm   = ftpInfos.get(z).getFileSeq()+fileType;
				fileZipNm  = fileHdName + ftpInfos.get(z).getFileSeq();
				
				List<String> zipLocations = new ArrayList<String>();
				
				for (int i = 1; i <= 7; i++) {
					String[] reTitle = null;
					String[] reTitleField = null;
					mtyRlseOrdInVO.setExcelSeq(String.valueOf(i));
					List<?> list = command.searchMtyRlseOrdForExcelDownload(mtyRlseOrdInVO);

					ArrayList<AbstractValueObject> vos = new ArrayList<AbstractValueObject>();
					
					if (i == 1) {
						reTitle = title1;
						reTitleField = titleField1;
						tempName = fileHdName+"R"+fileTaNm;
						bkgNos = new String[list.size()];

						//Root�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡�뜝�럥夷ⓨ뜝�럥痢끻뜝�럥占쏙옙�쐻占쎈윪占쎈쭨a�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺룔뀋占쎌뒱占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮�⑸걙占쎄뎡占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧筌ㅻØ�쇀占쎌돸占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇔뜝�럥�맶�뜝�럥�쑅占쎈쐩占쎈쎕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎄틦占쎈눇�뙼�봿援∽옙�뙕占쎌뿺占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦Skip�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥�뙴�뮋�삕占쎌맶�뜝�럥�쑅鶯ㅼ룆占쏙퐢�맶�뜝�럥�쑅�뜝�룞�삕�솾�꺂�뒧占쎈뮛櫻뗫봿瑗삼옙�굲嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪獄��슱�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
						if (list.size() < 1) break;
					} else if (i == 2) {
						reTitle = title2;
						reTitleField = titleField2;
						tempName = fileHdName+"Q"+fileTaNm;
					} else if (i == 3) {
						reTitle = title3;
						reTitleField = titleField3;
						tempName = fileHdName+"C"+fileTaNm;
					} else if (i == 4) {
						reTitle = title4;
						reTitleField = titleField4;
						tempName = fileHdName+"V"+fileTaNm;
					} else if (i == 5) {
						reTitle = title5;
						reTitleField = titleField5;
						tempName = fileHdName+"D"+fileTaNm;
					} else if (i == 6) {
						reTitle = title6;
						reTitleField = titleField6;
						tempName = fileHdName+"M"+fileTaNm;
					} else if (i == 7) {
						reTitle = title7;
						reTitleField = titleField7;
						tempName = fileHdName+"S"+fileTaNm;
					}
					
					for (int j = 0; j < list.size(); j++){
						if (i == 1) {
							MtyRlseOrdExcelBkgRootVO vo = new MtyRlseOrdExcelBkgRootVO();
							vo = (MtyRlseOrdExcelBkgRootVO) list.get(j);
							bkgNos[j] = vo.getBkgNo();
							vos.add(vo);
						} else if (i == 2) {
						    MtyRlseOrdExcelBkgQtyVO vo = new MtyRlseOrdExcelBkgQtyVO();					    
							vo = (MtyRlseOrdExcelBkgQtyVO) list.get(j);
							vos.add(vo);
						} else if (i == 3) {
							MtyRlseOrdExcelCntrVO vo = new MtyRlseOrdExcelCntrVO();					    
							vo = (MtyRlseOrdExcelCntrVO) list.get(j);
							vos.add(vo);
						} else if (i == 4) {
							MtyRlseOrdExcelBKgVvdVO vo = new MtyRlseOrdExcelBKgVvdVO();					    
							vo = (MtyRlseOrdExcelBKgVvdVO) list.get(j);
							vos.add(vo);
						} else if (i == 5) {
							MtyRlseOrdExcelDGVO vo = new MtyRlseOrdExcelDGVO();					    
							vo = (MtyRlseOrdExcelDGVO) list.get(j);
							vos.add(vo);
						} else if (i == 6) {
							MtyRlseOrdExcelCMVO vo = new MtyRlseOrdExcelCMVO();					    
							vo = (MtyRlseOrdExcelCMVO) list.get(j);
							vos.add(vo);
						} else if (i == 7) {
							MtyRlseOrdExcelRFVO vo = new MtyRlseOrdExcelRFVO();
							vo = (MtyRlseOrdExcelRFVO) list.get(j);
							vos.add(vo);
						}
					}

					//File Upload
					String fileName = createdLdfFilePath("BKG_LDF") + tempName; 
					filePath = Uploader.writeFile(vos, reTitle, reTitleField,  fileName, ",");						
					log.debug("filePath : " + filePath);
					log.debug("Seq : " + z + " , Zip Yn : " + ftpInfos.get(z).getZipYn());
					//zip�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎌넇�뜝�럡援�占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럡�븫�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥愿섓옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈듃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈옅占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈쭦癲ル슢캉�뙴洹⑥삕�뤃占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔夷뚳옙�쇊占쎈늉筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩�뜮戮녹삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥占쎈즽�뜝�럩援뀐옙�쐻占쎈윪筌띾냲�삕占쎌럸�뜝�럥利드뜝�럩援��뜝�럥�솗�뜝�럥�졒�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎌넇�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗傭��끉猷딉옙�굲
					if (!"Y".equals(ftpInfos.get(z).getZipYn())) {
						log.debug("fileName : " + fileName);
						if(!"".equals(filePath)  && !"".equals(fileName)){
							//Send FTP
							String retry = "N";
							log.debug("ftpYn : " + ftpYn);
							for (int k = 0; k < 3; k++) {
								if(retry.equals("Y")){break;}
								log.info("\n sendFtpManager Retry Count : " + k);
								ftpYn = sendFtpManager(ftpInfos.get(z).getFtpAddr(), ftpInfos.get(z).getUserId(), ftpInfos.get(z).getUserPw(), filePath, ftpInfos.get(z).getFtpPath(), ftpInfos.get(z).getZipYn()) ;
								retry = ftpYn;
							}
								
							if (i==1) {
								manageLodFctrDlLog(ftpInfos.get(z), bkgNos, new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), fileName, ftpYn, "SYSTEM");
							}
						}
					}else{
						zipLocations.add(filePath);
					}
					
				}//for
				ftpYn = "N";
				//zip �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄ゅ뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뿪占쎌굲 �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈쇀疫뀀８�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼�뜝�럥�떛�뜝�럥�맄�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎈첋占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎄틢占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩�쓥ip�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈쑕占쎌맶�뜝�럥�쑋�뜝�럥痢먨뜝�럥�맶�뜝�럥�쑅占쎌젂筌먯빖�맶�뜝�럥�쑅嶺뚮슡�뇢占쎌맶�뜝�럥�쑅�뜝�럡愿묈뜝�럥�맶�뜝�럥�쑅�뜝�럥�럵占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먯떜�솕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럩�뀇�윜誘쇱눘援�占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈뙀�눧�뜄�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃�궪�삕占쎌맶�뜝�럥�쑋�뜝�럥痢먨뜝�럥�맶�뜝�럥�쑅占쎌젂�겫諛몄º�뜝�럥利멨뜝�럩援꿨뜝�럥�맶�뜝�럥�쐾占쎄슈占쎈뼠占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐댐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럥�읈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥泥뗧솾�봾�꺋占쎌굲占쎈쐻占쎈윞占쎈쑆占쎈쐻占쎈윪�뤃�먥뵾占쎌뒧占쎈뎐占쎌뼐�뜙占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥瑗わ옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥���뜝�럥�뿞�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� 
				if ("Y".equals(ftpInfos.get(z).getZipYn()) && zipLocations != null && zipLocations.size() > 0) {
					String fileName = createdLdfFilePath("BKG_LDF") + fileZipNm; 
					String zipPath = CompressUtil.compress(zipLocations, fileName);
					log.debug("zipLocations : "+zipLocations);
	
					if(!"".equals(zipPath)){
						//Send FTP
						String retry = "N";
						log.debug("ZIP ftpYn : " + ftpYn);
						for (int k = 0; k < 3; k++) {
							if(retry.equals("Y")){break;}
							log.info("\n ZIP sendFtpManager Retry Count : " + k);
							ftpYn = sendFtpManager(ftpInfos.get(z).getFtpAddr()
									 , ftpInfos.get(z).getUserId()
									 , ftpInfos.get(z).getUserPw()
									 , zipPath
									 , ftpInfos.get(z).getFtpPath()
									 , ftpInfos.get(z).getZipYn()
									 ) ;
							retry = ftpYn;
						}

						manageLodFctrDlLog(ftpInfos.get(z), bkgNos, new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), fileName, ftpYn, "SYSTEM");
					}
				}
				
			}//for
			
			//占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윞�뙼占쏙옙�쐻占쎈윥占쎈♥占쎈쐻占쎈윞占쎄틢占쎌녇占쎄틓占쎈뮦�뜝�럩援꿰솾�꺂�뒧占쏙옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗傭��끉猷뉛옙�굷�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윥占쎈쭦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥鸚룐벂�쐻占쎈윥�눧袁��쐻占쎈윪�뤃�먥뵾占쎌뒧罹됵옙�쇀域밟뫁�굲占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅占쎈쐻占쎈윥占쎈룈�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윞占쎈뼇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾占쎄슈�눧�뜄�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥鸚룐벂�쐻占쎈윥占쎄숲占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�걨占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪獄�酉대쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏筌믍곴텣占쎈눀占쎈튂占쎄뎡占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛�뜝�럥猷쒙옙�쐻占쎈윥壤쏅���삕占쎌맶�뜝�럥�쑋�댖怨뺧옙節뗭맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윥�뜝�뜴�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럡肄ゅ뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥釉붾���뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윞�굜�껊쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뤁�뜝�럥�땻�뜝�럩二멨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌뱺�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�몱占쎌맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�걫占쎈쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪獄�酉대쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏筌믍곴텣占쎈눀占쎈튂占쎄뎡占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛�뜝�럥猷쒙옙�쐻占쎈윥壤쏅�ｋ쐻占쎈윥占쏙옙癲ル슢�뒧塋딆꼻�삕筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈ぁ占쎈쐻占쎈윥占쎈룶占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩�젪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럡肄ゅ뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뜝�럩諭울옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
			searchMtyRlseOrdForExcelDownloadRetry(e);
		
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BL REMARK POPUP
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBlClauseInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0179Event event = (EsmBkg0179Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		
		try{
			eventResponse.setRsVo(command.searchBlClauseInfo(event.getBlRemarkVO()));
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * SEND FTP
	 * @param String hostName
	 * @param String userName
	 * @param String userPwd
	 * @param String filePath
	 * @param String ftpPath
	 * @param String zipYn
	 * @throws Exception
	 */
	private String sendFtpManager(String hostName, String userName, String userPwd, String filePath, String ftpPath, String zipYn) throws Exception {
		log.debug("hostName : " + hostName);
		log.debug("Local filePath : " + filePath);
		log.debug("ChangeWorkingDirectory : " + ftpPath);
		log.debug("zipYn : " + zipYn);
		FtpManager ftpManager = BeanContainer.getBean("com.clt.net.ftp.FtpManager");
		ftpManager.setHostName(hostName);
		ftpManager.setFtpUserName(userName);
		ftpManager.setFtpPassword(userPwd);
		ftpManager.setFileAbsolutePath(filePath);
		ftpManager.setUserId("BATCH");
		ftpManager.setEncodingUtf8();
		if ("Y".equals(zipYn)) {
			ftpManager.setFileTypeBinary();
		}else{
			ftpManager.setFileTypeAscii();
		}
		
		ftpManager.setChangeWorkingDirectory(ftpPath);
		
		if (!(CheckUtilities.isNullAndNullString(ftpManager.getChangeWorkingDirectory()))) {
			log.debug("isNullAndNullString ChangeWorkingDirectory : " + ftpManager.getChangeWorkingDirectory());
		}
		
		try {
			ftpManager.send();
			return "Y";
		} catch (Exception ex) {
			log.error("err : " + ex.toString(), ex);
			return "N";
		}
	}

	/**
     * BATCH : Container Release Order Excel FTP Info History
     * @param FtpInfoVO ftpInfoVO
     * @param String[] bkgNos
     * @param String sendDate
     * @param String fileName
     * @param String ftpYn
     * @param String usrId
     * @exception Exception
	 */
	private void manageLodFctrDlLog(FtpInfoVO ftpInfoVO, String[] bkgNos, String sendDate, String fileName, String ftpYn, String usrId) throws Exception {
		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
		try {
			begin();
	        
			command.manageLodFctrDlLog(ftpInfoVO, bkgNos, sendDate, fileName, ftpYn, usrId);
			commit();
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return;
	}
	
	/**
	 * BL REMARK POPUP
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBkgLodFctrDlLogHdr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// PDTO(Data Transfer Object including Parameters)
			EsmBkg0236Event event = (EsmBkg0236Event)e;
			EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
			BkgLodFctrDlLogHdrVO logHdrVO =  new BkgLodFctrDlLogHdrVO();
			logHdrVO.setBkgOfcCd(event.getOfcCd());
			logHdrVO.setLdfDlDt(event.getLdfDt());

			List<BkgLodFctrDlLogHdrVO> list = command.searchBkgLodFctrDlLogHdr(logHdrVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BL REMARK POPUP
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBkgLodFctrDlLogDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// PDTO(Data Transfer Object including Parameters)
			EsmBkg0236Event event = (EsmBkg0236Event)e;
			EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
			BkgLodFctrDlLogHdrVO logHdrVO =  new BkgLodFctrDlLogHdrVO();
			logHdrVO.setBkgOfcCd(event.getOfcCd());
			logHdrVO.setLdfDlDt(event.getLdfDt());
			
			List<BkgLodFctrDlLogDtlVO> list = command.searchBkgLodFctrDlLogDtl(logHdrVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Empty Container Release Order Excel Download and Send FTP
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMtyRlseOrdForExcelDownloadRetry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		MtyRlseOrdInVO mtyRlseOrdInVO = new MtyRlseOrdInVO();
		
		String ftpYn = "N";
		String filePath = "";
		String fileType = "";
		String tempName = "";
		String fileHdName = "";
		String fileTaNm = "";
		String fileZipNm = "";
		
		String[] title1 = {"BOOKING NO","BOOKING DATE","BKG IND","TRUNK VESSEL LANE","VVD1 LANE","VVD1 VESSEL CODE","VVD1 LLOYD NO","VVD1 VESSEL NAME","VVD1 CALL SIGN","VVD1 VOYAGE","VVD1 DIR","CONS VOY","VVD1 POL ETD","VVD1 POD ETA","TRUNK VESSEL CODE","TRUNK VESSEL LLOYD NO","TRUNK VESSEL NAME","TRUNK VESSEL CALL SIGN","TVVD VOYAGE NO","TRUNK VESSEL VOYAGE DIR","POR NAME","POR OPUSCODE","POR UNCODE","POR YARD CODE","FIRST POL NAME","FIRST POL UNCODE","FIRST POL YARD","FIRST POL ETA","FIRST POD ETD","CUT OFF TIME FIRST POL","FINAL POD NAME","FINAL POD UNCODE","DEL OPUS CODE","DEL NAME","DEL UNCODE","REC DEL TYPE","REMARK FOR CUSTOMER","REMARK FOR VENDOR","COMMODITY CODE","COMMODITY CODE DESCRIPTION","MTY CNTR PICKUP CY","SHIPPER NAME","FORWARDER NAME","CONSIGNEE NAME","SHIPPER CODE","FWDR CODE","CONSIGNEE CODE","BKG STATUS","DRY IND","RFR IND","AWK IND","BBK IND","HAN IND","STOW IND","STOWAGE CODE","BKG OFFICE","BKG CONTACT POINT","SO NO","BLOCK STOW CODE","MTY PICKUP DATE","FULL RETURN DATE","MTY PICKUP CY COUNTRY","MTY PICKUP CY NAME","FULL RETURN YARD COUNTRY","FULL RETURN YARD NAME","STOW REMARK","EXPORT MRN NO.","SC NO","RFA NO","TAA NO"};
		String[] title2 = {"BOOKING NO","EQ TPSZ","ISO CODE","SPLIT COMB IND","MASTER BKG","BOOK EQ QTY","SOC IND","RD IND","CHS S","CHS D","CHS T","MHG"};
		String[] title3 = {"BOOKING NO","CNTR NO","CNTR TPSZ","SEAL NO","RF IND","DG IND","AK IND","BB IND","SOC IND","WGT QTY","WGT TP","RF CMDT CD","RF CMDT DESC","RF NET WT","RF GRS WT","RF WGT UNIT","TEMP UF","TEMP F","TEMP UC","TEMP C","RF VOLTAGE","VENT TYPE","VENT OPEN","VENT CMH","HUMID PC","GENSET REQ","RF REMARK","RF DRY","RF DRAIN","OVL FRONT","OVL REAR","OVH HIGH","OVW LEFT","OVW RIGHT","MOVE STS","EVENT YARD","EVENT TIME"};
		String[] title4 = {"BOOKING NO","LEG SEQ","TRANSPORT TYPE","LANE CODE","VESSEL CODE","LLOYD NO","VESSEL NAME","CALLSIGN","VOYAGE","VOY DIR","POL UNCODE","POL YARD","CALL SEQ","POL NAME","POL ETA","POL ETD","POD UNCODE","POD YARD","POD NAME","CONS VVD ARR","CONS VVD DEP"};
		String[] title5 = {"BOOKING NO","CNTR SEQ","CNTR TPSZ","CGO SEQ","CNTR NO","UNNO","CLASS","PSN","EMC PHONE","UN PAGE NO","FLASH POINT","F.POINT C","DG REMARKS","EMS NO","PSA CLASS","PACK GRP","MFAG","M.POLLUTE","SUB RISK1","OUTER PKG QTY","OUTER PKG UNIT","NET WGT","UOM","GRS WGT","UOM (KGS)","HAZ. CONTENTS","SUB RISK2","LTD QTY"};
		String[] title6 = {"BOOKING NO","CNTR NO","SEQ","PKG QTY","PKG UNIT","WGT QTY","WGT TP","MEASURE","MEA UNIT","COMMODITY"};
		String[] title7 = {"BOOKING NO","CNTR SEQ","CNTR TPSZ","CNTR NO","CMDT CODE","COMMODITY","TEMP","TEMP UNIT","VENT","REEFER RMK","PCK COUNT","NET WGT","GRS WGT","LENGTH","WIDTH","HEIGHT","OL FRONT","OL REAR","OW RIGHT","OW LEFT","OVER HIGH","AWK RMK"};
				
		String[] titleField1 = {"bkg_no","bkg_cre_dt","status","slan_cd","slan_cd1","vsl_cd","vvd_lloyd_no","vsl_eng_nm","vvd_call_sign","skd_voy_no","skd_dir_cd","cons_voy","vps_etd_dt","vps_eta_dt","vsl_cd1","trunk_vessel_lloyd_no","vsl_eng_nm1","trunk_vessel_call_sign","skd_voy_no1","skd_dir_cd_t","loc_nm","por_opscode","un_loc_cd","por_nod_cd","loc_nm1","un_loc_cd1","pol_nod_cd","vps_eta_dt1","vps_etd_dt1","cut_off_time_first_pol","loc_nm2","un_loc_cd2","del_opus_code","loc_nm3","un_loc_cd3","rcv_term_cd","xter_rmk","vndr_rmk","cmdt_cd","cmdt_nm","mty_pkup_yd_cd","cust_nm","cust_nm1","cust_nm2","cust_cnt_cd1","cust_cnt_cd2","cust_cnt_cd3","bkg_sts_cd","rd_cgo_flg","rc_flg","awk_cgo_flg","bb_cgo_flg","hngr_flg","stwg_rmk","stwg_cd","bkg_ofc_cd","bkg_contact_point","twn_so_no","blck_stwg_cd","mty_pkup_date","mty_pkup_date1","mty_pkup_yd_cd_t","full_return_yard_country","full_rtn_yd_cd","full_return_yard_name","stow_remark","cust_ref_no_ctnt","sc_no","rfa_no","taa_no"};
		String[] titleField2 = {"bkg_no","cntr_tpsz_cd","cntr_tpsz_iso_cd","spilt_combine","master_bkg","op_cntr_qty","soc_ind","eq_subst_cntr_tpsz_cd","chs_s","chs_d","chs_t","mhg"};
		String[] titleField3 = {"bkg_no","cntr_no","cntr_tpsz_cd","seal_no","rc_flg","dcgo_flg","awk_cgo_flg","bb_cgo_flg","soc_flg","cntr_wgt","wgt_ut_cd","cmdt_cd","cmdt_desc","net_wgt","grs_wgt","wgt_ut_cd1","temp_uf","fdo_temp","temp_uc","cdo_temp","vltg_no","cntr_vent_tp_cd","vent_rto","vent_cmh","humid_no","pwr_spl_cbl_flg","diff_rmk","rf_dry","rf_drain","ovr_fwrd_len","ovr_bkwd_len","ovr_hgt","ovr_lf_len","ovr_rt_len","move_sts","event_yard","event_time"};
		String[] titleField4 = {"bkg_no","leg_seq","vsl_pre_pst_cd","slan_cd","vsl_cd","lloyd_no","vsl_eng_nm","callsign","skd_voy_no","skd_dir_cd","un_loc_cd","pol_yd_cd","pol_clpt_ind_seq","loc_nm","vps_eta_dt","vps_etd_dt","un_loc_cd1","pod_yd_cd","loc_nm1","cons_vvd_arr","cons_vvd_dep"};
		String[] titleField5 = {"bkg_no","dcgo_seq","cntr_tpsz_cd","cntr_cgo_seq","cntr_no","imdg_un_no","imdg_clss_cd","prp_shp_nm","emer_cntc_phn_no_ctnt","un_page_no","flsh_pnt_cdo_temp","point_c","diff_rmk","ems_no","psa_no","imdg_pck_grp_cd","mfag","mrn_polut_flg","imdg_subs_rsk_lbl_cd1","out_imdg_pck_qty1","out_imdg_pck_cd1","net_wgt","wgt_ut_cd","grs_wgt","wgt_ut_cd1","hzd_ctnt","imdg_subs_rsk_lbl_cd2","imdg_lmt_qty_flg"};
		String[] titleField6 = {"bkg_no","cntr_no","cntr_mf_seq","pck_qty","pck_tp_cd","cntr_mf_wgt","wgt_ut_cd","meas_qty","meas_ut_cd","cntr_mf_gds_desc"};
		String[] titleField7 = {"bkg_no","cntr_seq","cntr_tpsz","cntr_no","cmdt_code","commodity","cdo_temp","temp_unit","vent_rto","diff_rmk","pck_qty","net_wgt","grs_wgt","ttl_dim_len","ttl_dim_wdt","ttl_dim_hgt","ovr_fwrd_len","ovr_bkwd_len","ovr_rt_len","ovr_lf_len","ovr_hgt","awk_rmk"};
				
		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
		
		try {
			
			String[] bkgNos = null;
			String hrdCdgId = "BKG_LDF_T";
			if ("CNTR".equals(String.valueOf(SiteConfigFactory.get("COM.CLT.JAF.MAIL.TEMPLATE.DIR")).split("/")[2])) {
				hrdCdgId = "BKG_LDF";
			}
			List<FtpInfoVO> ftpInfos = command.sendMtyRlseOrdByFTPRetry(hrdCdgId);
			
			for (int z=0; z < ftpInfos.size(); z++) {
				mtyRlseOrdInVO.setDatetype("FTP");
				mtyRlseOrdInVO.setBkgOfcCd(ftpInfos.get(z).getOfcCd());
				mtyRlseOrdInVO.setFromDt(ftpInfos.get(z).getFromDt());
				mtyRlseOrdInVO.setEndDt(ftpInfos.get(z).getEndDt());
								
				fileHdName = ftpInfos.get(z).getOfcCd().substring(0, 3);
				fileType   = (!"".equals(ftpInfos.get(z).getFileType()) && ftpInfos.get(z).getFileType() != null) ? "."+ftpInfos.get(z).getFileType() : "";
				fileTaNm   = ftpInfos.get(z).getFileSeq()+fileType;
				fileZipNm  = fileHdName + ftpInfos.get(z).getFileSeq();
				
				List<String> zipLocations = new ArrayList<String>();
				
				for (int i = 1; i <= 7; i++) {
					String[] reTitle = null;
					String[] reTitleField = null;
					mtyRlseOrdInVO.setExcelSeq(String.valueOf(i));
					List<?> list = command.searchMtyRlseOrdForExcelDownload(mtyRlseOrdInVO);

					ArrayList<AbstractValueObject> vos = new ArrayList<AbstractValueObject>();
					
					if (i == 1) {
						reTitle = title1;
						reTitleField = titleField1;
						tempName = fileHdName+"R"+fileTaNm;
						bkgNos = new String[list.size()];

						//Root�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕�뤃�뮂�뼀占쎌쐫a�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔夷뚳옙�쇊占쎈늉筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩�뜮戮녹삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅嶺뚮쵐猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡�뒋�뜝�럥荑덂뜝�럩援뀐옙�쐻占쎈윥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈탶野껊챶爾잌뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽Skip�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧占쎈룜�뜝�럥彛믣뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
						if (list.size() < 1) break;
					} else if (i == 2) {
						reTitle = title2;
						reTitleField = titleField2;
						tempName = fileHdName+"Q"+fileTaNm;
					} else if (i == 3) {
						reTitle = title3;
						reTitleField = titleField3;
						tempName = fileHdName+"C"+fileTaNm;
					} else if (i == 4) {
						reTitle = title4;
						reTitleField = titleField4;
						tempName = fileHdName+"V"+fileTaNm;
					} else if (i == 5) {
						reTitle = title5;
						reTitleField = titleField5;
						tempName = fileHdName+"D"+fileTaNm;
					} else if (i == 6) {
						reTitle = title6;
						reTitleField = titleField6;
						tempName = fileHdName+"M"+fileTaNm;
					} else if (i == 7) {
						reTitle = title7;
						reTitleField = titleField7;
						tempName = fileHdName+"S"+fileTaNm;
					}
					
					for (int j = 0; j < list.size(); j++){
						if (i == 1) {
							MtyRlseOrdExcelBkgRootVO vo = new MtyRlseOrdExcelBkgRootVO();
							vo = (MtyRlseOrdExcelBkgRootVO) list.get(j);
							bkgNos[j] = vo.getBkgNo();
							vos.add(vo);
						} else if (i == 2) {
						    MtyRlseOrdExcelBkgQtyVO vo = new MtyRlseOrdExcelBkgQtyVO();					    
							vo = (MtyRlseOrdExcelBkgQtyVO) list.get(j);
							vos.add(vo);
						} else if (i == 3) {
							MtyRlseOrdExcelCntrVO vo = new MtyRlseOrdExcelCntrVO();					    
							vo = (MtyRlseOrdExcelCntrVO) list.get(j);
							vos.add(vo);
						} else if (i == 4) {
							MtyRlseOrdExcelBKgVvdVO vo = new MtyRlseOrdExcelBKgVvdVO();					    
							vo = (MtyRlseOrdExcelBKgVvdVO) list.get(j);
							vos.add(vo);
						} else if (i == 5) {
							MtyRlseOrdExcelDGVO vo = new MtyRlseOrdExcelDGVO();					    
							vo = (MtyRlseOrdExcelDGVO) list.get(j);
							vos.add(vo);
						} else if (i == 6) {
							MtyRlseOrdExcelCMVO vo = new MtyRlseOrdExcelCMVO();					    
							vo = (MtyRlseOrdExcelCMVO) list.get(j);
							vos.add(vo);
						} else if (i == 7) {
							MtyRlseOrdExcelRFVO vo = new MtyRlseOrdExcelRFVO();
							vo = (MtyRlseOrdExcelRFVO) list.get(j);
							vos.add(vo);
						}
					}

					//File Upload
					String fileName = createdLdfFilePath("BKG_LDF") + tempName; 
					filePath = Uploader.writeFile(vos, reTitle, reTitleField,  fileName, ",");						
					log.debug("filePath : " + filePath);
					log.debug("Seq : " + z + " , Zip Yn : " + ftpInfos.get(z).getZipYn());
					//zip�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎌넇�뜝�럡援�占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럡�븫�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥愿섓옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈듃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈옅占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈쭦癲ル슢캉�뙴洹⑥삕�뤃占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔夷뚳옙�쇊占쎈늉筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩�뜮戮녹삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥占쎈즽�뜝�럩援뀐옙�쐻占쎈윪筌띾냲�삕占쎌럸�뜝�럥利드뜝�럩援��뜝�럥�솗�뜝�럥�졒�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎌넇�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗傭��끉猷딉옙�굲
					if (!"Y".equals(ftpInfos.get(z).getZipYn())) {
						log.debug("fileName : " + fileName);
						if(!"".equals(filePath)  && !"".equals(fileName)){
							//Send FTP
							String retry = "N";
							log.debug("ftpYn : " + ftpYn);
							for (int k = 0; k < 3; k++) {
								if(retry.equals("Y")){break;}
								log.info("\n sendFtpManager Retry Count : " + k);
								ftpYn = sendFtpManager(ftpInfos.get(z).getFtpAddr(), ftpInfos.get(z).getUserId(), ftpInfos.get(z).getUserPw(), filePath, ftpInfos.get(z).getFtpPath(), ftpInfos.get(z).getZipYn()) ;
								retry = ftpYn;
							}
								
							if (i==1) {
								modifyLodFctrDlLog(ftpInfos.get(z).getLdfDlDt(), ftpInfos.get(z).getOfcCd(), ftpYn, "SYSTEM");	
							}
						}
					}else{
						zipLocations.add(filePath);
					}
					
				}//for
				ftpYn = "N";
				//zip �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄ゅ뜝�럥�떛�넭怨살삕�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뿪占쎌굲 �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈쇀疫뀀８�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼�뜝�럥�떛�뜝�럥�맄�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎈첋占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎄틢占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩�쓥ip�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈쑕占쎌맶�뜝�럥�쑋�뜝�럥痢먨뜝�럥�맶�뜝�럥�쑅占쎌젂筌먯빖�맶�뜝�럥�쑅嶺뚮슡�뇢占쎌맶�뜝�럥�쑅�뜝�럡愿묈뜝�럥�맶�뜝�럥�쑅�뜝�럥�럵占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먯떜�솕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럩�뀇�윜誘쇱눘援�占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈뙀�눧�뜄�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃�궪�삕占쎌맶�뜝�럥�쑋�뜝�럥痢먨뜝�럥�맶�뜝�럥�쑅占쎌젂�겫諛몄º�뜝�럥利멨뜝�럩援꿨뜝�럥�맶�뜝�럥�쐾占쎄슈占쎈뼠占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐댐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럥�읈�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥泥뗧솾�봾�꺋占쎌굲占쎈쐻占쎈윞占쎈쑆占쎈쐻占쎈윪�뤃�먥뵾占쎌뒧占쎈뎐占쎌뼐�뜙占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥瑗わ옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥���뜝�럥�뿞�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� 
				if ("Y".equals(ftpInfos.get(z).getZipYn()) && zipLocations != null && zipLocations.size() > 0) {
					String fileName = createdLdfFilePath("BKG_LDF") + fileZipNm; 
					String zipPath = CompressUtil.compress(zipLocations, fileName);
					log.debug("zipLocations : "+zipLocations);
	
					if(!"".equals(zipPath)){
						//Send FTP
						String retry = "N";
						log.debug("ZIP ftpYn : " + ftpYn);
						for (int k = 0; k < 3; k++) {
							if(retry.equals("Y")){break;}
							log.info("\n ZIP sendFtpManager Retry Count : " + k);
							ftpYn = sendFtpManager(ftpInfos.get(z).getFtpAddr()
									 , ftpInfos.get(z).getUserId()
									 , ftpInfos.get(z).getUserPw()
									 , zipPath
									 , ftpInfos.get(z).getFtpPath()
									 , ftpInfos.get(z).getZipYn()
									 ) ;
							retry = ftpYn;
						}
						modifyLodFctrDlLog(ftpInfos.get(z).getLdfDlDt(), ftpInfos.get(z).getOfcCd(), ftpYn, "SYSTEM");
					}
				}
				
			}//for
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * BATCH : Container Release Order Excel FTP Info History
     * @param String ldfDlDt
     * @param String bkgOfcCd
     * @param String ftpYn
     * @param String usrId
     * @exception Exception
	 */
	private void modifyLodFctrDlLog(String ldfDlDt, String bkgOfcCd, String ftpYn, String usrId) throws Exception {
		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
		try {
			begin();
	        
			command.modifyLodFctrDlLog(ldfDlDt, bkgOfcCd, ftpYn, usrId);
			commit();
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return;
	}
	
	/**
     * Container Release Order Excel FTP Info History
	 * 
	 * @author 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMtyRlseOrdForFtpRetry(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0236Event event = (EsmBkg0236Event)e;
		String ofcCd = event.getOfcCd();
		String ldfDt = event.getLdfDt().replace("-", "").replace(":", "").replace(" ", "");

		try {
			modifyLodFctrDlLog(ldfDt, ofcCd, "R", account.getUsr_id());
			eventResponse.setETCData("SuccessYn", "R");
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援꿨뜝�럥���뜝�럥�걶�뜝�럡�뀭�뜝�럥�맶�뜝�럥�몷�뜝�럩占쏙옙�쐻占쎈윥�댆琉뤄펲占쎈즴甕겸벂�맪占쎈뼠占쎌굲占쎈쇀域밟뫁�굲占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬�뜝�럩�젧占쎈쐻占쎈윪�얘꼈�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼占쎈쐻占쎈윥占쎈꺑占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎌젂癰귘돦�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈짗占쎌굲�솾�봾�꺋占쎌굲�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈뙑�⑤벡�깵�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩�젪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럡肄ゅ뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뜝�럩諭울옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�. 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶占쎈쐻�뜝占�/占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�뿭占쎈쐻占쎈윪�뤃占�/占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윞�뙼占쏙옙�쐻占쎈윥占쎈♥占쎈쐻占쎈윞占쎄틢占쎌녇占쎄틓占쎈뮦�뜝�럩援꿰솾�꺂�뒧占쏙옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�걨占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
	 * @param baseName
	 * @return
	 */
	private String createdLdfFilePath(String baseName){
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
	    String today = df.format(date);
	    baseName = baseName + "/" + today;
	    
	    File file = new File(SiteConfigFactory.getWhenNullThrowException("COM.FILE.UPLOAD.STRING") + baseName);
	    if(!file.isDirectory()) file.mkdirs();
	    
	    return baseName + "/";
	}
	
	/**
     * Group Bl Send Email
	 * 
	 * @author 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendGroupBLEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0278Event event = (EsmBkg0278Event)e;
		BLIssuanceBC bLIssuanceBC = null;
		String grpBlEmail = "";
		String sType = "7";							//test hard coding.
		String sSigned = "Y";
		String sSignedCopy = "Y";
		String sMrd = "ESM_BKG_0109_OBL_A4.mrd";	//test hard coding.
		String sLevel = "1";
		StringBuilder sbParam = null;
		DblWblVO[] dblWblVOs = null;
		BkgEmlEdtVO bkgEmlEdtVO = null;

		try {
			GrpBlPrtInVO inVO = event.getGrpBlPrtInVO();
			GrpBlPrtVO[] listVOs = event.getGrpBlPrtVOs();
			
			bLIssuanceBC = new BLIssuanceBCImpl();
			bkgEmlEdtVO = new BkgEmlEdtVO();
			bkgEmlEdtVO.setEdtToEml(inVO.getGrpBlEmail());
			
			if(inVO != null){
				grpBlEmail = inVO.getGrpBlEmail();
				if(grpBlEmail == null || grpBlEmail.equals("")){
					eventResponse.setETCData("SuccessYn", "N");
					return eventResponse;
				}
			}
			String tmplMrd = "";
			String tmplparam = "";
			String tmplmrdpdf = "";
			String bkgNos = "";
			StringBuffer bufBkgNo = new StringBuffer();
			
			if(listVOs != null){
				dblWblVOs = new DblWblVO[listVOs.length];
				for(int i = 0 ; i < listVOs.length ; i++){
					GrpBlPrtVO vo = listVOs[i];
//					bkgNos = bkgNos + vo.getBkgNo() + "','";
					bufBkgNo.append(vo.getBkgNo()+"','");
					if(i == 0){
						tmplmrdpdf = vo.getBkgNo();
					}
				}
				bkgNos = bufBkgNo.toString();
				if(bkgNos.length() == 1){
					tmplmrdpdf = tmplmrdpdf+" B/L";
					bkgNos = bkgNos.substring(0, bkgNos.length()-3);
				}else{
					tmplmrdpdf = tmplmrdpdf + " and "+ (listVOs.length -1 )+" B/Ls";
					bkgNos = bkgNos.substring(0, bkgNos.length()-3);
				}
			}
			
				
			sbParam = new StringBuilder();
			sbParam.append("/rv");
			sbParam.append(" form_bkgNo[('").append(bkgNos).append("')]");
			sbParam.append(" form_type[").append(sType).append("]");
			sbParam.append(" form_dataOnly[N]");
			sbParam.append(" form_manifest[N]");
			sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
			sbParam.append(" form_hiddeData[N]");
			sbParam.append(" form_level[(").append(sLevel).append(")]");
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
			sbParam.append(" form_path[").append(event.getFileDownPath()).append("]");
			sbParam.append(" form_esig[").append(sSigned).append("]");
			sbParam.append(" form_cpy_esig[").append(sSignedCopy).append("]");
			sbParam.append(" form_knt_flg[]");
			sbParam.append(" form_count[]");
			sbParam.append(" isEncode[Y]");
			sbParam.append(" /rp []");  
			sbParam.append(" /riprnmargin");
			sbParam.append(" /rexceptiserr [1]");
			
			
			tmplMrd 	= sMrd;
			tmplparam 	= sbParam.toString();
			log.debug(">>>>>>>>"+tmplparam);
			dblWblVOs = new DblWblVO[1];
			dblWblVOs[0] = new DblWblVO();
			dblWblVOs[0].setBkgNo(bkgNos);
			dblWblVOs[0].setSyscd("BKG");
			dblWblVOs[0].setTmplmrd(tmplMrd);
			dblWblVOs[0].setBatchflg("N");
			dblWblVOs[0].setTmplparam(tmplparam);
			dblWblVOs[0].setRcveml(grpBlEmail);
			dblWblVOs[0].setTmplmrdpdf(tmplmrdpdf);
			begin();
			bLIssuanceBC.sendGroupBLEmail(dblWblVOs, bkgEmlEdtVO, account);
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
			
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * Retrieving Multi Shipment Detail(ESM_BKG_0391)<br>
     * 
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBookingContainerShipment(Event e) throws EventException {
    	EsmBkg0391Event event = (EsmBkg0391Event) e;
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
		BLDocumentationBLBC bLDocumentationBLBC	= new BLDocumentationBLBCImpl();
		BookingUtil utilCmd 					= new BookingUtil();
        BkgCntrShpVO inVO 						= event.getBkgCntrShpVO();
        
        try {
        	BkgRouteVO vo = utilCmd.searchBkgRoute(inVO.getBkgNo());
            List<BkgCntrShpVO> list = bLDocumentationBLBC.searchBkgCntrShp(inVO.getBkgNo());
            if(vo != null)
            	eventResponse.setETCData(vo.getColumnValues());
            eventResponse.setRsVoList(list);
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
	 * ContainerNo./Print Flag update (ESM_BKG_0391)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyMultiShpCntrPrn(Event e) throws EventException {
		EsmBkg0391Event event = (EsmBkg0391Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BLDocumentationBLBC bLDocumentationBLBC	= new BLDocumentationBLBCImpl();
		try {
			begin();
			bLDocumentationBLBC.modifyMultiShpCntrPrn(event.getBkgCntrShpVOs(), event.getBkgNo(), account);
			eventResponse.setUserMessage("");
			commit();
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
     * Retrieving Multi Shipment Detail(ESM_BKG_0391)<br>
     * 
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException 
     */
    private EventResponse checkToyotaBl(Event e) throws EventException {
    	EsmBkg007909Event event = (EsmBkg007909Event) e;
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
	    GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
	    BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		BkgBookingInfoVO bkgBookingInfoVO = new BkgBookingInfoVO();
		BlCustomerInfoVO custVo = new BlCustomerInfoVO();
		BookingCreationVO bookingCreationVO = new BookingCreationVO();
		
        String count = "";
        
        try {
        	bkgBlNoVO.setBkgNo(event.getBkg_no());
        	bookingCreationVO = receiptBC.searchBooking(bkgBlNoVO);
        	bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			custVo = bookingCreationVO.getBlCustomerInfoVO();
			// Check if BL is Toyota B/L or not
        	count = receiptBC.toyotaBlNoCheck(bkgBookingInfoVO, custVo);
        	
			if(!count.equals("0")){
				eventResponse.setETCData("Toyota", "Y");	
			}else if(count.equals("0")){
				eventResponse.setETCData("Toyota", "N");
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
     * Check Office Code<br>
     * 
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException 
     */
    private EventResponse checkOfcCd(Event e) throws EventException {
    	EsmBkg007909Event event = (EsmBkg007909Event) e;
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        BookingUtil bookingUtil = new BookingUtil();
        String ofcCd = event.getOfc_cd();
        String chkOfcCd = "";
        
        try {
        	MdmOrganizationVO mdmOrganizationVO = bookingUtil.searchMdmOrganization(ofcCd);
        	if(mdmOrganizationVO != null){
        		chkOfcCd = "Y";
        	}else{
        		chkOfcCd = "N";
        	}
        	eventResponse.setETCData("chk_ofc_cd",chkOfcCd);
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
     * Check Receive FTP address<br>
     * 
     * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException 
     */
    private EventResponse checkBlPrintRcvFtp(Event e) throws EventException {
    	EsmBkg007909Event event = (EsmBkg007909Event) e;
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        BLIssuanceBC bLIssuanceBC				= new BLIssuanceBCImpl();
        String bkgNo = event.getBkg_no();
        String chkRcvFtp = "N";
        String chkPageCnt= "N";
        String chkFfrefno= "N";
        List<BlPrintRcvFtpVO> blPrintRcvFtpVOs = null;
        
        try {
        	blPrintRcvFtpVOs = bLIssuanceBC.searchBlPrintGrpRcvFtp(bkgNo);
        	
        	if(blPrintRcvFtpVOs != null && blPrintRcvFtpVOs.size() > 0){
        		chkRcvFtp = "Y";
        		for(int i=0; i< blPrintRcvFtpVOs.size(); i++){
        			if("KNN".equals(blPrintRcvFtpVOs.get(i).getXptFileNm())){
        				chkPageCnt = "Y";
        				int lenFfrefno = blPrintRcvFtpVOs.get(i).getFfrefno().length();
        				
						if(lenFfrefno> 11 && lenFfrefno < 17 )
						{
							lenFfrefno = getNumberExSpecial(blPrintRcvFtpVOs.get(i).getFfrefno()).length();
							if(lenFfrefno >0){
								chkFfrefno = "N";
							}else{
								chkFfrefno = "Y";
							}
						}else{
							chkFfrefno = "Y";
						}
        				break;
        			}
        		}
        	}
        	eventResponse.setETCData("chk_ffrefno",chkFfrefno);
        	eventResponse.setETCData("chk_rcv_ftp",chkRcvFtp);
        	eventResponse.setETCData("exist_pagecnt",chkPageCnt);
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
    
	/** 특수문자를 제외한 숫자형 리턴<br>
	 * @param String s
	 * @return static boolean
	 */
	private static String getNumberExSpecial(String s) {  
		String match = "[^0-9]"; //특수문자제거 정규식
		if(s != null && s.equals("")){
			s = s.replaceAll(match, "");
		}
        return s;  
    }
	/**
	 * retrieving Package Description.(ESM_BKG_0079_07)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchPckTpForCM(Event e) throws EventException {
		EsmBkg007907Event event = (EsmBkg007907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();

		try {
			MdmPckTpVO pckTpVO = utilCmd.searchPkgType(event.getPckTpCd());
			eventResponse.setETCData("pck_nm", (pckTpVO.getPckNm() == null ? "" : pckTpVO.getPckNm()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Validate HS Code (ESM_BKG_0079_07)<br>
	 * 
	 * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse validateHsCd(Event e) throws EventException {
		EsmBkg007907Event event = (EsmBkg007907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingMasterMgtBC bookingMasterMgtBC = new BookingMasterMgtBCImpl();
		String hsCd = event.getHsCd();
		String hsAplyDt = event.getHsAplyDt();
		String hamoTpCd = event.getHamoTpCd();

		try {
			String hsCdRslt = bookingMasterMgtBC.validateHsCd(hsCd, hsAplyDt, hamoTpCd);
			eventResponse.setETCData("hs_cd_rslt", hsCdRslt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingConductSC.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBC;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.basic.CntrRepoExecutionPlanEstablishBCImpl;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.MtyBkgVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.TrsChgMgmtBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.event.EsmBkgUsaTmlEdiAckEvent;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistCtntVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.TableListVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgMdmCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdTroInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.basic.CancellationMessageBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.basic.CancellationMessageBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.event.EsmBkg0620Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic.GeneralBookingListSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic.GeneralBookingListSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0098Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0102Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0587Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0614Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0616Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0618Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0702Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg9425Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgCoffTmListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptCntVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForGeneralTmlEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForTmlEdiInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForUsaTmlEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgReceiptListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0077Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007901Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007905Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0079Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0092Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg036701Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg036702Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0890Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg1024Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg9424Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDetailVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDtlEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CmdtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ExportReferencesVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ManualBookingCopyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.N1stEtaDelEtaVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OceanRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherMdtItmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SearchCutOffDateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectSpclCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VvdAssignVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.XterCustOvflwFlgStatusVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0083Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0095Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0096Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0097Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0190Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0566Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0650Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0652Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0654Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0655Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0656Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0657Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0658Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0721Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0724Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0744Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0972Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0998Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1062Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1069Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1078Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg9450Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg9454Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg9455Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgYardCdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrChkDigitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HblCountVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistMainVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistUiNmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.MtyBkgTsRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NoticeHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PrdConstraintVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.QtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVvdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchActualCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgFaxEmailVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TSRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.UsaCstmsFileListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0076Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0099Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0709Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0710Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0715Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0716Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0732Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0974Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg1025Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.AkSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BbSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgBlForSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgForSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForMstBkgSelectVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrListForCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.DgSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.RfSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.TroSplitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.ValidateCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902aEvent;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902bEvent;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902cEvent;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0703Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0905Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0906Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0907Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0920Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0921Event;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.AwkSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgInfoForTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroChangeVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.RfSeqVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustDefaultVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiBkgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiCancelFrustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SearchDgCancelInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0997Event;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodSplitVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustInqVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.clt.apps.opus.esm.bkg.common.Constants;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic.EmptyReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic.EmptyReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBC;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.CstmBkgRevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CntrListForImportDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgIfVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaYardCdVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBC;
import com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBCImpl;
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
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.util.WebKeys;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComBakEndJbVO;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgChnBkgNoGenVO;
import com.clt.syscommon.common.table.BkgClzTmVO;
import com.clt.syscommon.common.table.BkgCntcPsonVO;
import com.clt.syscommon.common.table.BkgContainerVO;
import com.clt.syscommon.common.table.BkgCorrectionVO;
import com.clt.syscommon.common.table.BkgCustomerVO;
import com.clt.syscommon.common.table.BkgDocProcSkdVO;
import com.clt.syscommon.common.table.BkgEurTroDgSeqVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgRollOvrVO;
import com.clt.syscommon.common.table.BkgTroActCustVO;
import com.clt.syscommon.common.table.BkgTroActRepVO;
import com.clt.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.clt.syscommon.common.table.BkgTroVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.MdmCustomerVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.MdmSvcScpVO;
import com.clt.syscommon.common.table.MstContainerVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;

/**
 * OPUS-GeneralBookingConduct Business Logic ServiceCommand - OPUS-GeneralBookingConduct business transaction handling.
 * 
 * @author 
 * @see 
 * @since 
 */

public class GeneralBookingConductSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
 
	/**=[
	 * GeneralBookingConduct system task scenario<br>
	 * ESM_BKG_0079_02C Object creation about task scenario calling<br>
	 */
	public void doStart() {
		try {
			// comment --> log in check
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * GeneralBookingConduct system task scenario end work<br>
	 * ESM_BKG_0079_02C As ending of task scenario, 
	 */
	public void doEnd() {
		log.debug("GeneralBookingConductSC ");
	}

	/**
	 * task scenario for event<br>
	 * OPUS-GeneralBookingConduct system event division process<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// using part when SC have to process a lot of event
        if(e.getEventName().equalsIgnoreCase("EsmBkg0079Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgBlNoVO(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)
        			||e.getFormCommand().isCommand(FormCommand.DEFAULT)){
            	eventResponse = searchBkgCreTabByUser(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = completeCA(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
            	eventResponse = cancelCA(e);
            } 
        } 
        else if (e.getEventName().equalsIgnoreCase("EsmBkg007902aEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTro(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
                eventResponse = searchBkgSplitNo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
                eventResponse = searchSysDate(e);  //system date retrieve
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg007902bEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKrTro(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchTypeSizeByCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKrTro(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
                eventResponse = searchBkgSplitNo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
                eventResponse = searchSysDate(e);  //system date retrieve
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg007902cEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEurTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEurTro(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
                eventResponse = sendTroNotice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
                eventResponse = searchBkgSplitNo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
                eventResponse = searchBkgCntrWgt(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocValid(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0907Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEurTroCntrList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0905Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMdmCustForTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTroActCustByCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchActCustRep(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTroActCustByEq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchVndrName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTroActCustDefault(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTroActCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTroActCust(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0703Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEurTroForCancelFrust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = cancelFrustEurTro(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0921Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultiBkg(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0920Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyTro(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0906Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEurTroListForCfm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = confirmEurTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				EsmBkg0906Event event = (EsmBkg0906Event)e;
				event.getBkgBlNoVO().setCaFlg("N"); 
				interfaceToInv(event.getBkgBlNoVO(),account);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0566Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlHist(e);
				//eventResponse = searchHist(e);
			//} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				//eventResponse = searchBlHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchNoticeHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCustomsHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDocHist(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0650Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIbTsRoute(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0652Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBkgCreCustCntc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchCustContact(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBkgCreCustCntc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = searchMdmCustomerCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0972Event")) {
			//eventResponse = searchSvcRouteMode(e);
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSvcRouteMode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBlckStwgFlg(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageBlckStwgCd(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStowageCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0998Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchConstraint(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0083(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNodeCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0097Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReferenceList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReferenceNo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg036701Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				//[SEARCH]  retrieve
				eventResponse = searchPoOtherNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				//[SEARCH02] Button: Copy from C/M  
				eventResponse = searchCmForPo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				//[SEARCH02] MRN. UCR No -- Container No. list  
				eventResponse = searchCntrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				//[MULTI] Button: save  
				eventResponse = managePoOtherNo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg036702Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				//[SEARCH]  retrieve
				eventResponse = searchExportReferences(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0744Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNVOFileNumberList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageNVOFileNumber(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0587Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
	                eventResponse = searchClzStatus(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchBkgOfcListForBkgClz(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCoffTm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = closeBkgForBayPlan(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = reopenBkgForBayPlan(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchBkgListForCompFirm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListForCompFirm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCustName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = compFirm(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0092Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTsRoute(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneEtaEtd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = validateTsRoute(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg007901Event")) {
			//if (e.getFormCommand().isCommand(FormCommand.INIT)) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchUserBkgDefault(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBooking(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				eventResponse = validatePrecaution(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)){
				eventResponse = searchCustNm(e);				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = createBkgWithoutRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = createBkgWithRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = modifyBkgWithoutRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
				eventResponse = modifyBkgWithRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
                eventResponse = searchBkgSplitNo (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
                eventResponse = changeBkgStatus (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
                eventResponse = changeBkgStatus (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY06)) {
                eventResponse = cancelBooking (e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = checkIranBlackCustomer (e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchBkgContainerNo (e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchBkgCustCntInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = createdToyotaBlNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = validationToyotaBlNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY07)){
				eventResponse = bkgCustremarkSave(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0658Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = validateLocation(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0721Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchCargoClosingTime(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCargoClosingTime(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0709Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchDgSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0710Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchRfSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0715Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchAkSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0716Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchBbSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0099Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchBkgForSplit (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCbfFlag(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
	            eventResponse = searchBkgSplitNo (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = splitBooking(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchSplitRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
			    eventResponse = searchSplitTsRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
                eventResponse = splitBookingMulti(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1025Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchTroSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0190Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActualCustomer(e);
			}	
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9450Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEmptyCntrByBKG(e);
			}		
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0654Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchSvcScp(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchRfaList(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0655Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScList(e);
			}		
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0656Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmdtByRfa(e);
			}		
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0657Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmdtBySc(e);
			}		
		}				
		else if (e.getEventName().equalsIgnoreCase("EsmBkg007905Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBlDocCust(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				eventResponse = searchMdmCustNm(e);			
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchXterCustOvrLenFlgStatus (e);	                
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyBlDocCust (e);	                
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = checkIranBlackCustomer (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0890Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgQtyDtl(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyBkgQtyDtl(e);			
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0732Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCntrListForCombine(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0974Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchBkgListForMstBkgSelect(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0614Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchComCode0614(e);
			}
//			else if(e.getFormCommand().isCommand(FormCommand.INIT)){
//				eventResponse = searchInitComCode0614(e);
//			}			
			else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)){
				eventResponse = combineBooking(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListForWorkWithBkg(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0076Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListForCombine(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)){
				eventResponse = combineBooking(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MODIFY02)){
				eventResponse = cancelBookingMulti(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0997Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCodSplit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = splitCodBooking(e);
			}
			 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1024Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchPartialCntrBkg(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyBkgRouteForPartialBkg(e);
			}			
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0077Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgForCopy(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchMnlBkgSts(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = copyBkgWithoutRoute(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = copyBkgWithRoute(e);				
			}			
		}				
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0095Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)||e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgFaxEmailEdi(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendBkgFaxNotice(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = sendBkgEmailNotice(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = sendBkgEdi(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0098Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchComCode0098(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListForBkgReceiptNtc(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendBkgReceiptByFax(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = sendBkgReceiptByEmail(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI03) || e.getFormCommand().isCommand(FormCommand.MULTI04)){
				eventResponse = sendBkgReceiptByGroupEmail(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0702Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchComCode0702(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListFor301310Edi(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = sendBkgCustEdiMulti(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchSendBkgCustEdiMultiStatus(e); 
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchSendBkgCustEdiMulti(e);  
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendBkgTmlEdiMulti(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0616Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchComCode0616(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListForGeneralTmlEdi(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchBkgListForUsaTmlEdi(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageMyFwrdRefVvd(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendBkgTmlEdiMulti(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				sendBkgTmlEdiMultiBatch(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				sendBkgTmlEdiMultiBatchTest(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9424Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchEmptyBooking(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				eventResponse = searchCntrChkDigit(e);
			}	
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
				eventResponse = searchMtyCntrList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = modifyMtyRepoBkg(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = cancelEmptyBkg(e);
				
			}						
			else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = checkOutBkg(e);
			}	
			else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
				eventResponse = checkInBkg(e);
			}	
		}	        
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9454Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchEmptyBkgTsRoute(e);
			}
		}	 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9455Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCntrByYard(e);
			}
		}	    
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9425Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
//				eventResponse = searchComCode9425(e);
//			} else 
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEmptyBkgList(e);
			}
		}	 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0096Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchYardAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = validateYardAssign(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode1069(e);
			} if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRouteDetail(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmBkgUsaTmlEdiAckEvent")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = receiptUsaTmlEdiAck(e);
			} 
		}        
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchSvcScpByTaa(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchTaaList(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1078Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmdtByTaa(e);
			}		
		}		        
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0724Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchRollOver(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageRollOver(e);
			}			
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0618Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchLoadPortFacility(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBatchEdiVvdList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = bookingEdiTransmitToTerminalBatch(e);
			}
		}
		else if(e.getEventName().equalsIgnoreCase("EsmBkg0620Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = cancellationMessageList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = sned301UEdiCheck(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0079_01 : Search Container Number
	 * 
	 * @author KYOUNGIL MOON
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgContainerNo(Event e) throws EventException {
		try{
			EsmBkg007901Event event = (EsmBkg007901Event)e;
			
			EventResponse eventResponse = new GeneralEventResponse();
			
			GeneralBookingReceiptBC command = new GeneralBookingReceiptBCImpl();
			
			List searchBkgContainerVOs = command.searchBkgContainerNo(event.getBkgNo());
			
			eventResponse.setRsVoList(searchBkgContainerVOs);
			return eventResponse;
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBkgCustCntInfo(Event e) throws EventException {
		try{
			EsmBkg007901Event event = (EsmBkg007901Event)e;
			EventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingReceiptBC command = new GeneralBookingReceiptBCImpl();
			PriSpCtrtPtyVO priSpCtrtPtyVO = command.searchBkgCustCntInfo(event.getPriRpHdrVO());
			if(priSpCtrtPtyVO != null){
				eventResponse.setETCData("cust_cnt_cd", priSpCtrtPtyVO.getCustCntCd());
				eventResponse.setETCData("cust_lgl_eng_nm", priSpCtrtPtyVO.getCustLglEngNm());
				eventResponse.setETCData("cust_seq", priSpCtrtPtyVO.getCustSeq());
			}else{
				eventResponse.setETCData("cust_cnt_cd", "");
				eventResponse.setETCData("cust_lgl_eng_nm", "");
				eventResponse.setETCData("cust_seq", "");
			}
			return eventResponse;
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse createdToyotaBlNo(Event e) throws EventException {
		try{
			EventResponse eventResponse = new GeneralEventResponse();
			BookingUtil util = new BookingUtil();
			BkgBlNoVO toyotaBlNoVO = util.manageToyotaBlNumberGeneration("TYB", account.getOfc_cd(), account.getUsr_id());
			eventResponse.setETCData("toyota_bl_no", toyotaBlNoVO.getBlNo());
			return eventResponse;
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse validationToyotaBlNo(Event e) throws EventException {
		try{
			EsmBkg007901Event event = (EsmBkg007901Event)e;
			EventResponse eventResponse = new GeneralEventResponse();
			BookingUtil util = new BookingUtil();
			eventResponse.setETCData("check_seq", util.validationToyotaBlNo(event.getBkgBlNoVO()));
			return eventResponse;
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse bkgCustremarkSave(Event e) throws EventException {
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		EventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingReceiptBC	command	= new GeneralBookingReceiptBCImpl();
		BkgBookingInfoVO bkgBookingInfoVO = event.getBkgBookingInfoVO();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		try{
			bkgBookingInfoVO.setUpdUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgBookingInfoVO.getBkgNo());
			bkgBlNoVO.setCaFlg(bkgBookingInfoVO.getCaFlg());
			begin();
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0079_01", bkgBlNoVO);
			command.bkgCustremarkSave(bkgBookingInfoVO);
			historyBC.manageBookingHistory("ESM_BKG_0079_01", historyTableVO, account);
			commit();
			return eventResponse;
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESM_BKG_0367_01 : Save
	 * Purchase Other Number multi event process<br>
	 * Purchase Other Number and other number information input/modify/delete
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePoOtherNo(Event e) throws EventException {
		log.debug("============================>[[ GeneralBookingConductSC  managePoOtherNo START ]]<============================");
		EsmBkg036701Event			event			= (EsmBkg036701Event)e;
		GeneralBookingReceiptBC		command			= new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC 		genSearchCmd 	= new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC 		histCmd 		= new BookingHistoryMgtBCImpl();
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();
		PoOtherNoVO					poOtherNoVO 	= new PoOtherNoVO();
		BookingUtil 				util 			= new BookingUtil();
		BkgBlNoVO 					bkgBlNoIN 		= new BkgBlNoVO();
		String 						caFlg 			= "";
		boolean						isChg			= false;
		String						ediHldFlg		= "N";
		HistoryTableVO historyTableVO = null;
		
		String uiId = "ESM_BKG_0367";

		/** validation check // value check : BKG_NO , BKG_NO_SPLIT */
		if (event.getPoOtherNoBkgVO() == null )return eventResponse;
//		String bkgNo      = event.getPoOtherNoBkgVO().getBkgNo();

		try{
			//1.Before Save, input parameter and set as selected value
			poOtherNoVO.setIo_poOtherNoBkgVO(event.getPoOtherNoBkgVO());//condition
			poOtherNoVO.setI_poOtherNoBkgVOs(event.getPoOtherNoBkgVOs());//bkg
			poOtherNoVO.setI_poOtherShipVOs(event.getPoOtherShipVOs());// ship
			poOtherNoVO.setI_poOtherCntrVOs(event.getPoOtherCntrVOs());// cntr
			poOtherNoVO.setI_poOtherCmVOs(event.getPoOtherCmVOs()); // cm
			poOtherNoVO.setI_poOtherMrnUcrVOs(event.getPoOtherMrnUcrVOs());// mrn_ucr
			poOtherNoVO.setAccount(account);

			//2.Save conditions, retrieve
			begin();
			
			bkgBlNoIN.setBkgNo(event.getPoOtherNoBkgVO().getBkgNo());
			bkgBlNoIN.setCaUsrId(account.getUsr_id());;
			BkgBlNoVO bkgBlNoOUT = util.searchBkgBlNoVO(bkgBlNoIN);
			if(bkgBlNoOUT != null){
				caFlg = bkgBlNoOUT.getCaFlg();
			}
			
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOUT);
	
//			command.manageRefNo(poOtherNoVO, "N");
//			command.manageRefDetail(poOtherNoVO, "N");
//			command.manageMRNNoUCRNo(poOtherNoVO);
			command.manageRefNo(poOtherNoVO, caFlg);
			command.manageRefDetail(poOtherNoVO, caFlg);
			command.manageMRNNoUCRNo(poOtherNoVO, caFlg);
			
			BkgRefDtlVO[] bkgRefDtlVOs = poOtherNoVO.getI_poOtherMrnUcrVOs();
			if(bkgRefDtlVOs != null){
				for(int i=0; i<bkgRefDtlVOs.length; i++ ){
					if("U".equals(bkgRefDtlVOs[i].getIbflag())){
						//UCR - update check
						if("CUCR".equals(bkgRefDtlVOs[i].getBkgRefTpCd())){
							//1.CustRefNoCtnt value change..
							if("CUCR".equals(bkgRefDtlVOs[i].getOldBkgRefTpCd())){
								if(!bkgRefDtlVOs[i].getOldCustRefNoCtnt().equals(bkgRefDtlVOs[i].getCustRefNoCtnt())){
									isChg=true;
									break;
								}
							//2.MRN->UCR Combo change..
							}else if("CMRN".equals(bkgRefDtlVOs[i].getOldBkgRefTpCd())){
								//CustRefNoCtnt value change..
								if(!"".equals(bkgRefDtlVOs[i].getCustRefNoCtnt()) || !"".equals(bkgRefDtlVOs[i].getOldCustRefNoCtnt())){
									isChg=true;
									break;
								}
							}
						}else if("CMRN".equals(bkgRefDtlVOs[i].getBkgRefTpCd())){
							//3.UCR->MRN Combo change..
							if("CUCR".equals(bkgRefDtlVOs[i].getOldBkgRefTpCd())){
								if(!"".equals(bkgRefDtlVOs[i].getOldCustRefNoCtnt())){
									isChg=true;
									break;
								}
							}
						}
					}else if("I".equals(bkgRefDtlVOs[i].getIbflag())){
						//UCR - insert check
						if("CUCR".equals(bkgRefDtlVOs[i].getBkgRefTpCd())){
							//1.CustRefNoCtnt value change..
							if(!"".equals(bkgRefDtlVOs[i].getCustRefNoCtnt())) {
								isChg=true;
								break;
							}
						}
					}else if("D".equals(bkgRefDtlVOs[i].getIbflag())){
						//UCR - delete check
						if("CUCR".equals(bkgRefDtlVOs[i].getOldBkgRefTpCd())){
							//1.CustRefNoCtnt value change..
							if(!"".equals(bkgRefDtlVOs[i].getOldCustRefNoCtnt())) {
								isChg=true;
								break;
							}
						}
					}
				}
			}
			ediHldFlg = util.searchVenderEdiBkg(event.getPoOtherNoBkgVO().getBkgNo());
			
			if(isChg && "Y".equals(ediHldFlg)){
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoOUT);
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
			
			histCmd.manageBookingHistory(uiId, historyTableVO, account);
			
			commit();

			//3.After Save, result process
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		log.debug("============================>[[ GeneralBookingConductSC  managePoOtherNo END ]]<============================");
		return eventResponse;
	}
	/**
	 * ESM_BKG_0367_01 : Open
	 * searchPoOtherNo multi event process<br>
	 * Purchase Other Number and number information retrieve
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchPoOtherNo(Event e) throws EventException {
		log.debug("============================>[[ GeneralBookingConductSC  searchPoOtherNo START ]]<============================");
		EsmBkg036701Event			event			= (EsmBkg036701Event)e;
		GeneralBookingReceiptBC		command			= new GeneralBookingReceiptBCImpl();
//        BookingUtil 				command_combo 	= new BookingUtil();
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();

		// validation check : BKG_NO , BKG_NO_SPLIT
		if (event.getPoOtherNoBkgVO() == null )return eventResponse;
//		String bkgNo      = event.getPoOtherNoBkgVO().getBkgNo();

		try{
			//1.Before retrieve, input parameter and set as selected value
			PoOtherNoVO poOtherNoVO = new PoOtherNoVO();
			poOtherNoVO.setAccount(account);//�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅嶺뚮슡�굫占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쑅嶺뚯빖諭띰옙�맶�뜝�럥�쑅�뜏類ｏ옙癒��굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�맱�룞�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�씤逾녑칰�럥�룯�뜝�럥爾쎾뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩堉싧뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞鈺곌낑�쐻占쎈윞占쎈름�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뿶占쎈쐻占쎈윞�꽴�슗�쐻占쎈윪占쎈�癲ル슢履뗰옙�굲�뜝�럥�맶�뜝�럥�쐾�뜝�럥由듿뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥獒뺤떑�쐻占쎈윞占쏙옙占쎈쐻占쎈윥�댚已썄mation Save
			poOtherNoVO.setIo_poOtherNoBkgVO(event.getPoOtherNoBkgVO());//retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎌젂域밟뫁�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮦�뜝�럥彛믣뜝�럡�뜦�뜝�럥利드뜝�럩援뀐옙�쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�맱硫⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥筌묒뼲�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쎾뜝�럩逾쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥利띰옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌끍占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤빢�삕占쎌맶�뜝�럥�쑅嶺뚮슢寃�占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅占쎌젂占쎄퐩占쎌맶�뜝�럥�쐾�뜝�룞�삕�솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼲彛쀯옙堉꿨퐲�꺈�삕�뙴�뵃�삕占쎄뎡�뜝�럥夷ⓨ뜝�럥利멨뜝�럩援꿨＄源띿삕占쎈ご�⑤㈇�렊�뜝�럥�맶�뜝�럥�쑅占쎄덩�ⓦ끉�굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�몡�뜝�럩肉뷴뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈쭦癲ル슢캉占쎄콪嶺뚯빖�占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄ゅ뜝�럩�쟼�댖怨쀫폇占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈꺏占쎌굲占쎈쨨占쎄뭍占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�뙴�슱�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럡猿�占쎈쇀獄�袁る♥�뜝�럥�맶�뜝�럥�쑅�뜝�럥萸썲뜝�럥�맶�뜝�럥�쑅占쎈쑏�뙼蹂��굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄텠�뜝�뜦維�占쎈뮝力놂옙沃섓퐢�맶�뜝�럥�쑅嶺뚯빜�윥ve
			poOtherNoVO.setFirst(event.isFirst());

			//2.retrieve conditions, retrieve
			PoOtherNoVO rPoOtherNoVO = command.searchPoOtherNo(poOtherNoVO);
			
			//3.combo box retrieve
			//List<BkgComboVO> list_wgt_ut_cd = command_combo.searchCombo("CD00775");//wgt_ut_cd
			//List<BkgComboVO> list_meas_ut_cd = command_combo.searchCombo("CD01116");//meas_ut_cd

			//4.After retrieve, result process
			List rlistCntrVOs 	= rPoOtherNoVO.getO_poOtherCntrVOs();
			List rlistCmVOs 	= rPoOtherNoVO.getO_poOtherCmVOs();
			List rlistShipVOs 	= rPoOtherNoVO.getO_poOtherShipVOs();
			List rlistNoBkgVOs 	= rPoOtherNoVO.getO_poOtherNoBkgVOs();
			List rlistMrnUcrVOs = rPoOtherNoVO.getO_poOtherMrnUcrVOs();
			PoOtherMdtItmVO rPoOtherMdtItmVO = rPoOtherNoVO.getO_PoOtherMdtItmVO();

			//4.XML creation result process
			if(rlistCntrVOs != null )		{eventResponse.setRsVoList(rlistCntrVOs);}
			if(rlistCmVOs != null )			{eventResponse.setRsVoList(rlistCmVOs);}
			if(rlistShipVOs != null)		{eventResponse.setRsVoList(rlistShipVOs);}
			if(rlistMrnUcrVOs != null)		{eventResponse.setRsVoList(rlistMrnUcrVOs);}
			if(rlistNoBkgVOs != null)		{eventResponse.setRsVoList(rlistNoBkgVOs);}
			if(rlistMrnUcrVOs != null)		{eventResponse.setRsVoList(rlistMrnUcrVOs);}		//hidden data
			if(rPoOtherMdtItmVO != null )	{eventResponse.setETCData("man_Item",rPoOtherMdtItmVO.getPathItem());}
			
			eventResponse.setETCData("CNTR_DUPLICATED", rPoOtherNoVO.getCntrNoDuplicated());

			//eventResponse.setRsVoList(list_wgt_ut_cd);
			//eventResponse.setRsVoList(list_meas_ut_cd);

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
		log.debug("============================>[[ GeneralBookingConductSC  searchPoOtherNo END ]]<============================");
		//if (list.isEmpty())	eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
		return eventResponse;
	}

	/**
	 * ESM_BKG_0367_01 : Copy from C/M
	 * searchCmForPo multi event process<br>
	 * retrieve to copy CMinformation in PO & Other No(Description, Package Qty/Type, Weight Qty, Measure Qty )
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCmForPo(Event e) throws EventException {
		log.debug("============================>[[ GeneralBookingConductSC  searchCmForPo START ]]<============================");
		EsmBkg036701Event			event			= (EsmBkg036701Event)e;
		GeneralBookingReceiptBC		command			= new GeneralBookingReceiptBCImpl();
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();

		// validation check : BKG_NO , BKG_NO_SPLIT
		if (event.getPoOtherNoBkgVO() == null )return eventResponse;
//		String bkgNo      = event.getPoOtherNoBkgVO().getBkgNo();

		try{
			//1.Before retrieve, input parameter and set as selected value
			PoOtherNoVO poOtherNoVO = new PoOtherNoVO();
			poOtherNoVO.setAccount(account);//log in information Save
			poOtherNoVO.setIo_poOtherNoBkgVO(event.getPoOtherNoBkgVO());//retrieve conditions VOSave

			//2.retrieve conditions, retrieve
			PoOtherNoVO rpoOtherNoVO = command.searchCmForPo(poOtherNoVO);

			//3.After retrieve, result process
			List rlistCmVOs = rpoOtherNoVO.getO_poOtherCmVOs();
			eventResponse.setRsVoList(rlistCmVOs);

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		log.debug("============================>[[ GeneralBookingConductSC  searchCmForPo END ]]<============================");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02A  : retrieve <br>
	 * General TRO  retrieve <br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007902aEvent event = (EsmBkg007902aEvent)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try 
		{
			TroVO troVO = command.searchTro(event.getBkgBlNoVO(), event.getBoundCd(), event.getRtnTroFlg(), account);
			
			//==============================================
			//Etc-1)for Booking information output : EtcData
			BkgInfoForTroVO bkgInfoForTroVO = troVO.getBkgInfoForTroVO();
	
			if (bkgInfoForTroVO == null || "".equals(JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()))) 
			{
	    		eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
	    		eventResponse.setETCData("DataYn", "N");
			} else {
				eventResponse.setETCData("por_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd()));
				eventResponse.setETCData("conti_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getContiCd()));
				eventResponse.setETCData("vsl_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getVslCd()));
				eventResponse.setETCData("bkg_cgo_tp_cd",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgCgoTpCd()));
				eventResponse.setETCData("cust_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustNm()));
				eventResponse.setETCData("bkg_rep_cmdt_cd",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtCd()));
				eventResponse.setETCData("rd_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRdCgoFlg()));
				eventResponse.setETCData("bkg_rep_cmdt_nm",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtNm()));
				eventResponse.setETCData("dor_arr_dt",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDt()));
				eventResponse.setETCData("bkg_sts_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgStsCd()));
				eventResponse.setETCData("fd_grd_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getFdGrdFlg()));
				eventResponse.setETCData("spcl_hide_flg",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSpclHideFlg()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlNo()));
				eventResponse.setETCData("pol_code",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPolCd()));
				eventResponse.setETCData("cmdt_cd",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtCd()));
				eventResponse.setETCData("bb_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBbCgoFlg()));
				eventResponse.setETCData("wgt_ut_cd",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getWgtUtCd()));
				eventResponse.setETCData("dcgo_flg",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDcgoFlg()));
				eventResponse.setETCData("etb_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getEtbDt()));
				eventResponse.setETCData("cust_cnt_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustCntCd()));
				eventResponse.setETCData("hcdg",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getHcdg()));
				eventResponse.setETCData("por_nod_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorNodCd()));
				eventResponse.setETCData("awk_cgo_flg",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAwkCgoFlg()));
				eventResponse.setETCData("del_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDelCd()));
				eventResponse.setETCData("pickup_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPickupCy()));
				eventResponse.setETCData("skd_voy_no",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdVoyNo()));
				eventResponse.setETCData("cust_seq",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustSeq()));
				eventResponse.setETCData("cmdt_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtNm()));
				eventResponse.setETCData("skd_dir_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdDirCd()));
				eventResponse.setETCData("act_wgt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getActWgt()));
				//eventResponse.setETCData("bl_tp_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlTpCd()));
				eventResponse.setETCData("pod_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPodCd()));
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()));
				eventResponse.setETCData("dor_arr_dt_hhmi",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDtHhmi()));
				eventResponse.setETCData("term",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getTerm()));
				eventResponse.setETCData("rc_flg",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRcFlg()));
				eventResponse.setETCData("return_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getReturnCy()));					
				eventResponse.setETCData("rtn_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDt()));
				eventResponse.setETCData("rtn_dt_hhmi",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDtHhmi()));
				eventResponse.setETCData("pkup_dt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDt()));
				eventResponse.setETCData("pkup_dt_hhmi",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDtHhmi()));
				eventResponse.setETCData(troVO.getBkgBlNoVO().getColumnValues());	
				
				//==============================================
		        //Data-1) TRO Master information output
				eventResponse.setRsVoList(troVO.getBkgTroVOs());
	
				//==============================================
		        //Data-2) TRO Detail information output
				eventResponse.setRsVoList(troVO.getTroDtlVOs());
	
				//==============================================
		        //Data-3) TRO Master - Dg information output
				//eventResponse.setRsVoList(troVO.getBkgTroDgSeqVOs());
				eventResponse.setRsVoList(troVO.getBkgTroSpclCgoSeqVOs());
	
				//==============================================
		        //Data-4) Booking�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏占쎄섞占쎌��뜝�럩�뤈�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥筌묒뼲�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃怨ㅼ삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮칾怨댄뀭占쎈쐻占쎈윪�얠렱�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럩�쐪�뜝�럩�뮛�뜝�뜴�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝占�- Dg combo list retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
				eventResponse.setRsVoList(troVO.getDgSeqVOs());
				//==============================================
		        //Data-5) Booking�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏占쎄섞占쎌��뜝�럩�뤈�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥筌묒뼲�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃怨ㅼ삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮칾怨댄뀭占쎈쐻占쎈윪�얠렱�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럩�쐪�뜝�럩�뮛�뜝�뜴�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝占�- Rf combo list retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
				eventResponse.setRsVoList(troVO.getRfSeqVOs());
				//==============================================
		        //Data-6) Booking�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏占쎄섞占쎌��뜝�럩�뤈�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥筌묒뼲�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃怨ㅼ삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮칾怨댄뀭占쎈쐻占쎈윪�얠렱�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럩�쐪�뜝�럩�뮛�뜝�뜴�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝占�- Awk combo list retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
				eventResponse.setRsVoList(troVO.getAwkSeqVOs());
	
				//==============================================
		        //Data-7) TRO - Sum Qty information output
				eventResponse.setRsVoList(troVO.getQtyInfoForTroVOs());
				eventResponse.setETCData("DataYn", "Y");
				bkgInfoForTroVO.getPolCd();
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02B : retrieve <br>
	 * korea TRO �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�떋�굩�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜竊쎾칰�윎ieve <br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKrTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007902bEvent event = (EsmBkg007902bEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		TransferOrderIssueBC command   = new TransferOrderIssueBCImpl();		
		
		try 
		{
			TroVO troVO = command.searchTro(event.getBkgBlNoVO(), event.getBoundCd(), event.getRtnTroFlg(), account);
			
	
			//==============================================
			//Etc-1) upper Booking information output : EtcData
			BkgInfoForTroVO bkgInfoForTroVO = troVO.getBkgInfoForTroVO();
	
			if (bkgInfoForTroVO == null || "".equals(JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()))) 
			{
	    		eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
	    		eventResponse.setETCData("DataYn", "N");
			} else {
				eventResponse.setETCData("por_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd()));
				eventResponse.setETCData("conti_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getContiCd()));
				eventResponse.setETCData("vsl_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getVslCd()));
				eventResponse.setETCData("bkg_cgo_tp_cd",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgCgoTpCd()));
				eventResponse.setETCData("cust_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustNm()));
				eventResponse.setETCData("bkg_rep_cmdt_cd",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtCd()));
				eventResponse.setETCData("rd_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRdCgoFlg()));
				eventResponse.setETCData("bkg_rep_cmdt_nm",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtNm()));
				eventResponse.setETCData("dor_arr_dt",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDt()));
				eventResponse.setETCData("bkg_sts_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgStsCd()));
				eventResponse.setETCData("fd_grd_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getFdGrdFlg()));
				eventResponse.setETCData("spcl_hide_flg",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSpclHideFlg()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlNo()));
				eventResponse.setETCData("pol_code",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPolCd()));
				eventResponse.setETCData("cmdt_cd",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtCd()));
				eventResponse.setETCData("bb_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBbCgoFlg()));
				eventResponse.setETCData("wgt_ut_cd",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getWgtUtCd()));
				eventResponse.setETCData("dcgo_flg",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDcgoFlg()));
				eventResponse.setETCData("etb_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getEtbDt()));
				eventResponse.setETCData("cust_cnt_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustCntCd()));
				eventResponse.setETCData("hcdg",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getHcdg()));
				eventResponse.setETCData("por_nod_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorNodCd()));
				eventResponse.setETCData("awk_cgo_flg",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAwkCgoFlg()));
				eventResponse.setETCData("del_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDelCd()));
				eventResponse.setETCData("pickup_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPickupCy()));
				eventResponse.setETCData("skd_voy_no",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdVoyNo()));
				eventResponse.setETCData("cust_seq",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustSeq()));
				eventResponse.setETCData("cmdt_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtNm()));
				eventResponse.setETCData("skd_dir_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdDirCd()));
				eventResponse.setETCData("act_wgt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getActWgt()));
				//eventResponse.setETCData("bl_tp_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlTpCd()));
				eventResponse.setETCData("pod_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPodCd()));
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()));
				eventResponse.setETCData("dor_arr_dt_hhmi",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDtHhmi()));
				eventResponse.setETCData("term",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getTerm()));
				eventResponse.setETCData("rc_flg",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRcFlg()));
				eventResponse.setETCData("return_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getReturnCy()));
				eventResponse.setETCData("rtn_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDt()));
				eventResponse.setETCData("rtn_dt_hhmi",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDtHhmi()));
				eventResponse.setETCData("pkup_dt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDt()));
				eventResponse.setETCData("pkup_dt_hhmi",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDtHhmi()));
				eventResponse.setETCData(troVO.getBkgBlNoVO().getColumnValues());
				
				//==============================================
		        //Data-1) for TRO Master information output
				eventResponse.setRsVoList(troVO.getBkgTroVOs());
			
				//==============================================
		        //Data-2) for TRO Detail information output
				eventResponse.setRsVoList(troVO.getTroDtlVOs());
	
				//==============================================
		        //Data-3) for TRO Master - Dg information output
				//eventResponse.setRsVoList(troVO.getBkgTroDgSeqVOs());
				eventResponse.setRsVoList(troVO.getBkgTroSpclCgoSeqVOs());
	
				//==============================================
		        //Data-4) Booking - Dg combo list retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
				eventResponse.setRsVoList(troVO.getDgSeqVOs());
				//==============================================
		        //Data-5) Booking�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏占쎄섞占쎌��뜝�럩�뤈�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥筌묒뼲�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃怨ㅼ삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮칾怨댄뀭占쎈쐻占쎈윪�얠렱�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럩�쐪�뜝�럩�뮛�뜝�뜴�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝占�- Rf combo list retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
				eventResponse.setRsVoList(troVO.getRfSeqVOs());
				//==============================================
		        //Data-6) Booking�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏占쎄섞占쎌��뜝�럩�뤈�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥筌묒뼲�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃怨ㅼ삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮칾怨댄뀭占쎈쐻占쎈윪�얠렱�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럩�쐪�뜝�럩�뮛�뜝�뜴�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝占�- Awk combo list retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
				eventResponse.setRsVoList(troVO.getAwkSeqVOs());
	
				//==============================================
		        //Data-7) TRO - Sum Qty information output
				eventResponse.setRsVoList(troVO.getQtyInfoForTroVOs());
				
				String strPorCd = "";
		        if (bkgInfoForTroVO != null) {
		        	strPorCd = JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd());
		        }            
		        if ( strPorCd.length() >= 2 && "KR".equals(strPorCd.substring(0, 2)) ) 
				{
					//==============================================
			        //Data-8) [Rtn_cago]TRO Master information output
					eventResponse.setRsVoList(troVO.getBkgTroVOsrtn());
			
					//==============================================
			        //Data-9) [Rtn_cago]TRO Detail information output
					eventResponse.setRsVoList(troVO.getTroDtlVOsrtn());
	
					//==============================================
			        //add) 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺧옙�뜝�럥�맶�뜝�럥�쑅鶯ㅼ룆占쏙퐢�맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑅嶺뚯빖諭띰옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�쑅占쎄덩�ⓦ끉�굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅嶺뚮　維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슢理먨젆�먯삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡�뒋�뜝�럥�떚�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿�뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥占쏙옙�뜝�럥猷��뜝�럥�벓�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럥彛⑨옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊�굢�룇�삕占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄괼�뜝�럥�맶�뜝�럥�쑋占쎌젂�뀎洹μ굲�뜝�럡萸у뜝�럥�쑆�뜝�뜦踰�占쎄콬占쎈퉲占쎄땔占쎌굲�뜝�럩�눁占쎈쐻占쎈윥占쎈뭽占쎈쐻占쎈윞占쏙옙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀖占쎈떚�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�댖怨뚰뜉占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�씤逾녑칰�럥�룯�뜝�럥爾쎾뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩堉싧뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅅ猷뉛옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉끻뜝�럥�맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�뙴�슱�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럡猿�占쎈눀�솒占썽뇡紐뚯삕占쎌맶�뜝�럥�쑅�뜝�럥萸듸옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윪�앓우삕占쎈폇占쎌꼯�럦�ⓦ끉�굲�뜝�럩�몗占쎈쐻占쎈윥塋딅ㅇ�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�솗�뜝�럥�졒�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슢�뒦占쎄땀�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥鸚룔굝�윺占쎄뭔�뜝�뜦維�占쎈뮡�뜏類ｌ챾占쎌굲�뜝�럥�뒌雅�猿뗪섶占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�럸占쎈쐻占쎈쑟筌랃옙占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥肄�占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌ｋ뿧�녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앭슖�떜媛��씙�뜝�럥鍮껓옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛嶺뚣끇占썬룊�젺�뜝�럥痢먨뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊�뜝�럥�늾占쎈쇊癰귨옙占쎄뎡占쎌녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�럸占쎈쐻占쎈짗占쎌굲�뜝�럥裕뀐옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뜝�럥援곤옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏筌믩끃�굲占쎌젂影�瑜곸굲占쎈쑏占쎈꺽占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럥�걮�뜝�럥�맶�뜝�럥�쑋占쎈쐻占쎈짗占쎌굲�뜝�럩�읁占쎈쐻占쎈윥筌앸떦異��뜝�룞�삕占쎈굵占쎈뙕占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� - Cntr combo list 
					String[] arrCntr = troVO.getArrCntr();
		            ArrayList<BkgComboVO> combo1 = new ArrayList<BkgComboVO>(); 
	
					BkgComboVO bkgComboVO1 = new BkgComboVO();
					bkgComboVO1.setComboCd("CNTRLIST01");
					bkgComboVO1.setVal (" ");
					bkgComboVO1.setDesc(" ");
					bkgComboVO1.setName(" ");
					combo1.add(bkgComboVO1);
					
					for (int i=0; i<arrCntr.length; i++) {
						BkgComboVO bkgComboVO = new BkgComboVO();
						bkgComboVO.setComboCd("CNTRLIST01");
						bkgComboVO.setVal (arrCntr[i]);
						bkgComboVO.setDesc(arrCntr[i]);
						bkgComboVO.setName(arrCntr[i]);
						combo1.add(bkgComboVO);
					}
					eventResponse.setRsVoList(combo1);	
				}
		        eventResponse.setETCData("DataYn", "Y");
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02C : retrieve <br>
	 * europe TRO �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�떋�굩�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜竊쎾칰�윎ieve <br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007902cEvent   event     = (EsmBkg007902cEvent)e;
		TransferOrderIssueBC command   = new TransferOrderIssueBCImpl();
		BookingUtil    comboUtil = new BookingUtil();
				
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try 
		{
			EurTroVO eurTroVO = command.searchEurTro(event.getBkgBlNoVO(), event.getBoundCd(), account);  			
	
			//==============================================
			//Etc-1) upper Booking information output : EtcData 
			BkgInfoForTroVO bkgInfoForTroVO = eurTroVO.getBkgInfoForTroVO(); 
			
			if (bkgInfoForTroVO == null || "".equals(JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()))) 
			{
	    		eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
	    		eventResponse.setETCData("DataYn", "N");
			} else {
				eventResponse.setETCData("por_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd()));
				eventResponse.setETCData("conti_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getContiCd()));
				eventResponse.setETCData("vsl_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getVslCd()));
				eventResponse.setETCData("bkg_cgo_tp_cd",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgCgoTpCd()));
				eventResponse.setETCData("cust_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustNm()));
				eventResponse.setETCData("bkg_rep_cmdt_cd",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtCd()));
				eventResponse.setETCData("rd_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRdCgoFlg()));
				eventResponse.setETCData("bkg_rep_cmdt_nm",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtNm()));
				eventResponse.setETCData("dor_arr_dt",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDt()));
				eventResponse.setETCData("bkg_sts_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgStsCd()));
				eventResponse.setETCData("fd_grd_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getFdGrdFlg()));
				eventResponse.setETCData("spcl_hide_flg",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSpclHideFlg()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlNo()));
				eventResponse.setETCData("pol_code",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPolCd()));
				eventResponse.setETCData("cmdt_cd",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtCd()));
				eventResponse.setETCData("bb_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBbCgoFlg()));
				eventResponse.setETCData("wgt_ut_cd",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getWgtUtCd()));
				eventResponse.setETCData("dcgo_flg",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDcgoFlg()));
				eventResponse.setETCData("etb_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getEtbDt()));
				eventResponse.setETCData("cust_cnt_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustCntCd()));
				eventResponse.setETCData("hcdg",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getHcdg()));
				eventResponse.setETCData("por_nod_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorNodCd()));
				eventResponse.setETCData("awk_cgo_flg",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAwkCgoFlg()));
				eventResponse.setETCData("del_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDelCd()));
				eventResponse.setETCData("pickup_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPickupCy()));
				eventResponse.setETCData("skd_voy_no",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdVoyNo()));
				eventResponse.setETCData("cust_seq",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustSeq()));
				eventResponse.setETCData("cmdt_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtNm()));
				eventResponse.setETCData("skd_dir_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdDirCd()));
				eventResponse.setETCData("act_wgt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getActWgt()));
				//eventResponse.setETCData("bl_tp_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlTpCd()));
				eventResponse.setETCData("pod_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPodCd()));
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()));
				eventResponse.setETCData("dor_arr_dt_hhmi",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDtHhmi()));
				eventResponse.setETCData("term",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getTerm()));
				eventResponse.setETCData("rc_flg",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRcFlg()));
				eventResponse.setETCData("return_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getReturnCy()));
				eventResponse.setETCData("rtn_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDt()));
				eventResponse.setETCData("rtn_dt_hhmi",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDtHhmi()));
				eventResponse.setETCData("pkup_dt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDt()));
				eventResponse.setETCData("pkup_dt_hhmi",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDtHhmi()));
				eventResponse.setETCData("rep_zn_cd",     	 JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRepZnCd()));
				eventResponse.setETCData("flex_hgt_flg",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getFlexHgtFlg()));
				eventResponse.setETCData(eurTroVO.getBkgBlNoVO().getColumnValues());
	
				//==============================================
		        //Data-1) TRO Master information output 
				eventResponse.setRsVoList(eurTroVO.getEurTroMstVOs());
	
				//==============================================
		        //Data-2) TRO Detail information output 
				eventResponse.setRsVoList(eurTroVO.getEurTroDtlVOs());
	
				//==============================================
		        //Data-3) TRO Master - for Dg information output 
				eventResponse.setRsVoList(eurTroVO.getBkgEurTroDgSeqVOs());
	
				//==============================================
		        //Data-4) Booking - for Dg combo list retrieve
				eventResponse.setRsVoList(eurTroVO.getDgSeqVOs());
				//==============================================
		        //Data-5) Booking - for Rf combo list retrieve 
				List<RfSeqVO> rfSeqVOs = eurTroVO.getRfSeqVOs();
				RfSeqVO rfSeqVO = new RfSeqVO();
				rfSeqVO.setRfSeq("");
				rfSeqVO.setDisplayNm("");
				rfSeqVO.setRfTroRmk("");
				rfSeqVOs.add(0, rfSeqVO);
				eventResponse.setRsVoList(rfSeqVOs);	
				//==============================================
		        //Data-6) Booking�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝占쎈쑏占쎄섞占쎌��뜝�럩�뤈�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥筌묒뼲�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃怨ㅼ삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡嶺뚮칾怨댄뀭占쎈쐻占쎈윪�얠렱�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利양땟�굢�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럩�쐪�뜝�럩�뮛�뜝�뜴�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝占�- Awk combo list retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
				List<AwkSeqVO> awkSeqVOs = eurTroVO.getAwkSeqVOs();
				AwkSeqVO awkSeqVO = new AwkSeqVO();
				awkSeqVO.setAwkSeq("");
				awkSeqVOs.add(0, awkSeqVO);
				eventResponse.setRsVoList(awkSeqVOs);	
	
				//==============================================
		        //Data-7) TRO - Sum Qty information output 
				eventResponse.setRsVoList(eurTroVO.getQtyInfoForTroVOs());
				
				//==============================================
		        //Data-8)common code - for bkg_trsp_mzd_cd combo list retrieve
				//List<BkgComboVO> combo1 = comboUtil.searchCombo("CD00277");
				List<BkgComboVO> combo1 = comboUtil.searchCombo("CD01720");
				BkgComboVO bkgComboVO = new BkgComboVO();
				//bkgComboVO.setComboCd("CD00277");
				bkgComboVO.setComboCd("CD01720");
				bkgComboVO.setVal("");
				bkgComboVO.setDesc("");
				bkgComboVO.setName("");
				combo1.add(0, bkgComboVO);
				eventResponse.setRsVoList(combo1);	
				
				eventResponse.setETCData("DataYn", "Y");
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
	
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0079_02A : save <br>
	 * general TRO Save process <br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTro(Event e) throws EventException {
		
		EsmBkg007902aEvent event = (EsmBkg007902aEvent)e;
		TransferOrderIssueBC    command    = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC     command2   = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC command3   = new GeneralBookingReceiptBCImpl();		
		BookingUtil             util       = new BookingUtil();
		ProductCatalogCreateBC  prdCtlBC   = new ProductCatalogCreateBCImpl(); 
		BkgCopManageBC          copBC      = new BkgCopManageBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String uiId = "ESM_BKG_0079_02A";
		boolean troCfm = false;
		try{
			begin();

			//------------------------------------------->
			event.getBkgBlNoVO().setCaFlg("N"); 
			String bkgNo      = event.getBkgBlNoVO().getBkgNo();
			String boundCd    = event.getBoundCd();
			String rtnTroFlg  = event.getRtnTroFlg();
			String delFlg     = event.getDelFlg();
			String currTroSeq = event.getCurrTroSeq();

			//----------------
			//1) general
			event.getTroVO().setEBkgFlg("N"); 
			event.getTroVO().setDelFlg (delFlg);
			
			TroMstVO[] arrTroMstVO = event.getTroVO().getArrTroMstVO();
			if (arrTroMstVO != null) {
				for (int i=0; i<arrTroMstVO.length; i++) {
					arrTroMstVO[i].setBkgNo    (bkgNo);
					arrTroMstVO[i].setIoBndCd  (boundCd);
					arrTroMstVO[i].setRtnTroFlg(rtnTroFlg);
				}
				event.getTroVO().setArrTroMstVO(arrTroMstVO);
			}


			TroDtlVO[] arrTroDtlVO = event.getTroVO().getArrTroDtlVO();
			if (arrTroDtlVO != null) {
				for (int i=0; i<arrTroDtlVO.length; i++) {
					arrTroDtlVO[i].setBkgNo(bkgNo);
					arrTroDtlVO[i].setIoBndCd(boundCd);
					arrTroDtlVO[i].setRtnTroFlg(rtnTroFlg);
				}
				event.getTroVO().setArrTroDtlVO(arrTroDtlVO);
			}

			BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = event.getTroVO().getArrBkgTroSpclCgoSeqVO();
			if (arrBkgTroSpclCgoSeqVO != null) {
				for (int i=0; i<arrBkgTroSpclCgoSeqVO.length; i++) {
					arrBkgTroSpclCgoSeqVO[i].setBkgNo(bkgNo);
					arrBkgTroSpclCgoSeqVO[i].setIoBndCd(boundCd);
					arrBkgTroSpclCgoSeqVO[i].setRtnTroFlg(rtnTroFlg);
				}
				event.getTroVO().setArrBkgTroSpclCgoSeqVO(arrBkgTroSpclCgoSeqVO);
			}
			//<-------------------------------------------

			//---------------------------
			//01. Before history Save, process			
			event.getBkgBlNoVO().setCaFlg("N");
			HistoryTableVO historyTableVO = command2.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());

			//---------------------------
			//02. Tro Save
			Map<String,Object> responseData = new HashMap<String,Object>();
			responseData = command.manageTro(event.getTroVO(), account, currTroSeq);  //containVO

			//---------------------------
			//03. Qty Save
			BkgQuantityVO[] arrBkgQuantityVO = (BkgQuantityVO[])responseData.get(WebKeys.ER_DBROWSETS);
			command3.modifyBkgQtyByTro(arrBkgQuantityVO, boundCd, account);
	

			if (arrTroMstVO != null) 
			{
				for (int i=0; i<arrTroMstVO.length; i++)
				{	
					//get rid of not to reprocess 
					//String strIbFlg = arrTroMstVO[i].getIbflag();
					//if ( !("U".equals(strIbFlg) || "I".equals(strIbFlg)) ) {
					//	continue; 
					//}
					
					String strCfmFlg    = JSPUtil.getNullNoTrim(arrTroMstVO[i].getCfmFlg(),    "N");
					String strCfmFlgOld = JSPUtil.getNullNoTrim(arrTroMstVO[i].getCfmFlgOld(), "N");
					String strCxlFlg    = JSPUtil.getNullNoTrim(arrTroMstVO[i].getCxlFlg(),    "N");
					String strCxlFlgOld = JSPUtil.getNullNoTrim(arrTroMstVO[i].getCxlFlgOld(), "N");
					log.debug("strCfmFlgOld:["+strCfmFlgOld+"], strCfmFlg:["+ strCfmFlg+"], strCxlFlgOld:["+ strCxlFlgOld+"], strCxlFlg:["+ strCxlFlg+"]");
					

					//unconfirm->confirm 
					if ("N".equals(strCfmFlgOld) && "Y".equals(strCfmFlg) && "N".equals(strCxlFlg) && ("I".equals(arrTroMstVO[i].getIbflag()) || "U".equals(arrTroMstVO[i].getIbflag()))){
						troCfm = true;
						String strTroSeq = arrTroMstVO[i].getTroSeq();
						
						log.debug(arrTroMstVO[i].getReturnCyNo()+","+ arrTroMstVO[i].getZnCd());

						command.validateInlaneRoute(event.getBkgBlNoVO(), "O", 
								//arrTroDtlVO[k].getRtnLocCd() +arrTroDtlVO[k].getRtnYdCd(), 
								arrTroMstVO[i].getReturnCyNo(),
								arrTroMstVO[i].getDorLocCd() +arrTroMstVO[i].getZnCd(), null, "Y");
						//---------------------------
						//04. searchPrdParmForInlandRoute 
						PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd  ("3");
						prdMainInfoVO.setPcMode("O");
						prdMainInfoVO.setBkgNo (bkgNo);
						
						BkgBlNoVO prdBkgBlNoVO = new BkgBlNoVO();
						prdBkgBlNoVO.setBkgNo(bkgNo);
						prdBkgBlNoVO.setCaFlg("N");
						String pctlNo = null;
						String seq = null;
						
						// SUBSEQ add for Detail
						BkgTroVO tVO = new BkgTroVO();
						tVO.setCxlFlg("TRO");
						tVO.setBkgNo(bkgNo);
						tVO.setTroSeq(strTroSeq);
						tVO.setRtnTroFlg(rtnTroFlg);
						
						BkgTroVO bkgTroVO = util.searchPcNoforTro(tVO);
						seq = bkgTroVO.getPctlNo();
						// seq finding end
						
						log.debug("\n (creation no) prd call" + i +  "   #################################");
						//log.debug("\n CxlFlg : " + arrTroDtlVO[k].getCxlFlg() +  " strCfmFlgOld : " + strCfmFlgOld +  " strCfmFlg : " + strCfmFlg  );
						//---------------------------
						//05. createProdCtlRoute : ESD/PRD module call
						PrdTroInfoVO prdTroInfoVO = new PrdTroInfoVO(); 
						prdTroInfoVO.setTroSeq(strTroSeq);
						//prdTroInfoVO.setTroSubSeq(arrTroDtlVO[k].getTroSubSeq());
						prdTroInfoVO.setTroSubSeq(seq);
						prdTroInfoVO.setAreaContiCd("X");
						//prdTroInfoVO.setCntrNo   (arrTroDtlVO[k].getCntrNo()); 	
						prdTroInfoVO.setCntrNo   ("");
						prdTroInfoVO.setDorZone  (arrTroMstVO[i].getDorLocCd() +arrTroMstVO[i].getZnCd());
						
						//prdTroInfoVO.setTroPkupCy(arrTroDtlVO[k].getPkupLocCd()+arrTroDtlVO[k].getPkupYdCd()); 
						prdTroInfoVO.setTroRtnCy (arrTroMstVO[i].getReturnCyNo()); 
						log.debug("\n ############ prdTroInfoVO.setTroRtnCy:"+arrTroMstVO[i].getReturnCyNo());
						prdTroInfoVO.setHaulage  ("");   //only use 02C
						prdTroInfoVO.setTrMode   ("");   //only use 02C(I/B) 
						
						//prdMainInfoVO.setMPu(arrTroDtlVO[k].getPkupLocCd()+arrTroDtlVO[k].getPkupYdCd());
						prdMainInfoVO.setMPu(arrTroMstVO[i].getPickupCyNo());
						//prdMainInfoVO.setFRt(arrTroDtlVO[k].getRtnLocCd() +arrTroDtlVO[k].getRtnYdCd());
						log.debug("\n ############ prdMainInfoVO.setMPu:"+arrTroMstVO[i].getPickupCyNo());
						//log.debug("\n ############ prdMainInfoVO.setFRt:"+arrTroDtlVO[k].getRtnLocCd() +arrTroDtlVO[k].getRtnYdCd());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO(); 
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO); 
						prdParameterVO.setBkgBlNoVO    (prdBkgBlNoVO); 
						prdParameterVO.setPrdTroInfoVO (prdTroInfoVO); 
						PrdParameterVO schPrdParameterVO = util.searchPrdParmForInlandRoute(prdParameterVO); 

						pctlNo = prdCtlBC.createPrdCtlgRout(schPrdParameterVO, account); 

						if(pctlNo == null ||pctlNo.length()==0){
							throw new EventException((String)new ErrorHandler("BKG02032").getMessage());
						}
						// In case of pct CALL, change location
						// confirm -> In case of confirm, not  modifyTroPctlNo
						//log.debug("\n version 1 ### bkgNo:"+bkgNo + ", troSeq:"+strTroSeq+",troSubSeq:"+arrTroDtlVO[k].getTroSubSeq()+"----->pctl_no:"+pctlNo);
						prdBkgBlNoVO.setPctlNo(pctlNo);
						command.modifyTroPctlNo(prdBkgBlNoVO, strTroSeq, account);
						
						
						if (arrTroDtlVO != null) 
						{
							for (int k=0; k<arrTroDtlVO.length; k++) 
							{
								//If it is not dtl for troSeq, exception process : send all list 
								if ( !strTroSeq.equals(arrTroDtlVO[k].getTroSeq()) ) {
							        continue;
								}
//								String strDtlIbFlg = arrTroDtlVO[k].getIbflag();
//								if ( !("U".equals(strDtlIbFlg) || "I".equals(strDtlIbFlg)) ) {
//								
//									 continue; 
//								}
								
//							if ("N".equals(arrTroDtlVO[k].getCxlFlg())&&"N".equals(strCfmFlgOld)&& "Y".equals(strCfmFlg)){
					
//								}
							/*	else{
									/** 
									 * =======================================
									 * searchPcNoforTro
									 * Do not know, may be used in the future for multi confirm - don't delete
									 * =======================================
									 
									log.debug("\n new prd call #################################");
									BkgTroVO tVO = new BkgTroVO();
									tVO.setCxlFlg("TRO");
									tVO.setBkgNo(bkgNo);
									tVO.setTroSeq(strTroSeq);
									tVO.setRtnTroFlg(rtnTroFlg);
									
									BkgTroVO bkgTroVO = util.searchPcNoforTro(tVO);
									pctlNo = bkgTroVO.getPctlNo();
									log.debug("\n version 2 ###bkgNo:"+bkgNo + ", troSeq:"+strTroSeq+",troSubSeq:"+arrTroDtlVO[k].getTroSubSeq()+"----->pctl_no:"+pctlNo);

								}
							*/
								
								// In case of  confirm after confirm to delete cop unconfirm call 
								//if ("Y".equals(strCfmFlgOld) && "Y".equals(strCfmFlg)){
								//	log.debug("\n unconfirmTro call #################################");
								//	copBC.unconfirmTro(bkgNo, strTroSeq, arrTroDtlVO[k].getTroSubSeq(), "O");
								//	log.debug("\n unconfirmTro end #################################");
								//}
								
								
								//---------------------------
								//06. confirmTro : SCE module call
								if("N".equals(arrTroDtlVO[k].getCxlFlg())){
									log.debug("\n confirmTro call #################################");
									log.debug(" SCE confirm call ######bkgNo:"+bkgNo + ", troSeq:"+strTroSeq+",troSubSeq:"+arrTroDtlVO[k].getTroSubSeq()+"----->pctl_no:"+pctlNo);
									copBC.confirmTro(bkgNo, strTroSeq, arrTroDtlVO[k].getTroSubSeq(), "O", pctlNo, "X" ); 
									log.debug("\n confirmTro end #################################");
								}
							}
							//---------------------------
							// 07. interfaceCoa : COA module call
							// changing to booking base call
							log.debug("\n interfaceToCoa call #################################");
							interfaceToCoa(event.getBkgBlNoVO(), "TRO Confirm", account);
							log.debug("\n interfaceToCoa end #################################");
						}
					}
					// unconfirm -> confirmcompletion : detail???????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??cel case???????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????占쎈쐻占쎈윥占쎈눁??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????�솾�돃�굫占쎌굲???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????嚥싲갭�돘占쎌굲?�솾�돃�굫占쎌굲??????占쎈쐻占쎈윥占쎌죳???????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎈꽨?????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�?????????????????????????????占쎈쐻占쎈윞占쎈뤊???????????????????????????????????????????????占쎈쐻占쎈윥�뜝�룞�삕??占쎈쐻占쎈윥占쎌죸???????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎈뇲??????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????占쎈쐻占쎈윥占쎈눁?�뜝�럡�뒋潁뺛꺆�뵥??�뜝�럩�꼥占쎈쐻�뜝占�??????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??cel???????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????b seq???????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????嚥싲갭�돘占쎌굲?�솾�돃�굫占쎌굲??????占쎈쐻占쎈윥占쎌죳???????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????????占쎈쐻占쎈윥占쎈떆??????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????�솾�돃�굫占쎌굲?????????癲ル슢占쏙옙占쎌굲???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�?????占쎈쐻占쎈윥�땻占�?�뜝�럩�꼥占쎈쐻�뜝占�????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럥夷①툞�꺈�삕占쎈닪�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?�썒占쏙옙援앾옙�뽳옙�뵥??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????占쎈쐻占쎈윥占쎌몗??????????�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????占쎈쐻占쎈윥占쎌졆?????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????占쎈쐻占쎈윥占쎈걤??????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎈젌????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�?????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�?????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥�젆占�??�솾�돃�굫占쎌굲????????????�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????�솾�돃�굫占쎌굲??占쎈쐻占쎈윥占쎈뇲?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?�썒占쏙옙援앾옙�뽳옙�뵥??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????占쎈쐻占쎈윥�땻占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윪占쎌맗???????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗?????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�?????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????�뜝�럩�꼥占쎈쐻�뜝占�?? ???????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎈꽨?????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????????占쎈쐻占쎈윥占쎈떆??????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????�솾�돃�굫占쎌굲??占쎈쐻占쎈윥占쎈뇲???????????????�뜝�럩�꼥占쎈쐻�뜝占�????�뜝�럩�꼥占쎈쐻�뜝占�?
					
					//confirm->unconfirm or cancel
					else if (("Y".equals(strCfmFlgOld) && "N".equals(strCfmFlg)) 
							||("Y".equals(strCfmFlgOld) && "N".equals(strCxlFlgOld) && "Y".equals(strCxlFlg)) 
							) 
					{
						if ("I".equals(arrTroMstVO[i].getIbflag()) || "U".equals(arrTroMstVO[i].getIbflag())){
							String strTroSeq = arrTroMstVO[i].getTroSeq();					
							if (arrTroDtlVO != null) 
							{
								for (int k=0; k<arrTroDtlVO.length; k++) 
								{
									if ( !strTroSeq.equals(arrTroDtlVO[k].getTroSeq()) ) {
										continue;
									}
									// So No???????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????占쎈쐻占쎈윥占쎈눁??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????�솾�돃�굫占쎌굲???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????嚥싲갭�돘占쎌굲?�솾�돃�굫占쎌굲??????占쎈쐻占쎈윥占쎌죳???????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎈꽨?????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????????占쎈쐻占쎈윥占쎈떆??????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????�솾�돃�굫占쎌굲??占쎈쐻占쎈윞占쎈쑞??????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥�젆占�????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????????占쎈쐻占쎈윥占쎈떆??????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????�솾�돃�굫占쎌굲??占쎈쐻占쎈윥占쎈뇲????????�뜝�럩�꼥占쎈쐻�뜝占�??????�뜝�럩�꼥占쎈쐻�뜝占�????r?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�?????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????占쎈쐻占쎈윥�땻占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윪占쎌맗???????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????????占쎈쐻占쎈윥占쎈떆??????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????�솾�돃�굫占쎌굲???????????????�뜝�럩�꼥占쎈쐻�뜝占�?�뜝�럡�뒋占쎈쐻占쎈쑟占쎈꼥占쎈쐻�뜝占�???占쎈쐻占쎈윥�땻占�????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????�뜝�럩�꼥占쎈쐻�뜝占�????�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥筌묕옙????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎈꽨?????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????????????????????????????????????????????????????????????????????占쎌녃域밟뫁�굲????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�??????????�뜝�럩�꼥占쎈쐻�뜝占�????�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�?????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????占쎈쐻占쎈윥占쎈쭡?占쎈쐻占쎈윥占쎌뱼?�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲??????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎈꽨占쎈쐻占쎈윥�땻占�?????�뜝�럩�꼥占쎈쐻�뜝占�? ???????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�????�뜝�럩�꼥占쎈쐻�뜝占�?2010.04.01 cateshin
									int soNo = arrTroDtlVO[k].getTrspSoNo().length();
									log.debug("\n SO NO ##################################### " + soNo + "##" + k);
									//2010.06.17 frustrate case exception�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥筌묕옙??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????�솾�돃�굫占쎌굲????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥筌묕옙?????�뜝�럩�꼥占쎈쐻�뜝占�????????????占쎈쐻占쎈윥占쎌졆????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�?????????????????????????????????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�?????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲???�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎌졆????�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????????????????�뜝�럩�꼥占쎈쐻�뜝占�????�뜝�럩�꼥占쎈쐻�뜝占�??????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�???????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�?????占쎈쐻占쎈윥�땻占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???嚥싲갭�돘占쎌굲??????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??????占쎈쐻占쎈윥占쎈꽨?????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗????�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??占쎈쐻占쎈윥占쎌몗??�뜝�럥��占쎈쐻�뜝占�?�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�???????????????????????????????????????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????????????????�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�??�뜝�럩�꼥占쎈쐻�뜝占�????????�뜝�럩�꼥占쎈쐻�뜝占�????�뜝�럩�꼥占쎈쐻�뜝占�?
									//if (soNo != 0){
									// 
									//	throw new EventException((String)new ErrorHandler("BKG08151").getMessage());
									//}
									//---------------------------
									//04. unconfirmTro : SCE module call
									log.debug("\n cancel unconfirmTro call #################################");
									copBC.unconfirmTro(bkgNo, strTroSeq, arrTroDtlVO[k].getTroSubSeq(), "O");
									log.debug("\n cancel unconfirmTro end #################################");
								}
								//---------------------------
								//07. interfaceCoa : COA module call
								interfaceToCoa(event.getBkgBlNoVO(), "TRO Unconfirm", account);
							}
						}
						
					}
				}
			}
			
			//2015.03.10 kimtaekyun TRS interface
			String category 	= "ATUS";
			String troSeq		= "";
			String troSubSeq	= "";
			String deltFlg		= "";
			
			if (arrTroMstVO != null) 
			{
				//Cancel All, Cancel, Row Delete
				if ("Y".equals(delFlg)) {
//					for (int i=0; i<arrTroMstVO.length; i++)
//					{
						if (arrTroDtlVO != null) 
						{
							for (int k=0; k<arrTroDtlVO.length; k++) 
							{
								troSeq 	  = arrTroDtlVO[k].getTroSeq();
								troSubSeq = arrTroDtlVO[k].getTroSubSeq();
								deltFlg	  = "Y";
								util.interfaceToTrs(category, bkgNo, boundCd, troSeq, troSubSeq, deltFlg, account, "N", "0");
								
							}
						}
//					}
				}else{
//					for (int i=0; i<arrTroMstVO.length; i++)
//					{
						if (arrTroDtlVO != null) 
						{
							for (int k=0; k<arrTroDtlVO.length; k++) 
							{
								troSeq 	  = arrTroDtlVO[k].getTroSeq();
								troSubSeq = arrTroDtlVO[k].getTroSubSeq();
								util.interfaceToTrs(category, bkgNo, boundCd, troSeq, troSubSeq, "", account, "N", "0");
							}
						}
//					}
				}
			}
			
			//---------------------------
			//08. BkgHistory Save 
			command2.manageBookingHistory(uiId, historyTableVO, account);			

			if(troCfm){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("TROCFM");// TRO CONFIRM input for doc performance
				command2.manageDocProcess(bkgDocProcSkdVO, account);
			}
			//---------------------------
			//*) Normal at the completion of the return process messages
			String resultMsg = (String)responseData.get(WebKeys.ER_MESSAGE);
			resultMsg = ((resultMsg==null)? "": resultMsg);
			if ("".equals(resultMsg)) {
				if ("Y".equals(delFlg)) {
					eventResponse.setUserMessage("[SUCCESS] "+new ErrorHandler("GEM00010").getUserMessage());  //GEM00010 : del success
				} else {
					eventResponse.setUserMessage("[SUCCESS] "+new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
				}
			} else {
				eventResponse.setUserMessage("[SUCCESS] "+resultMsg);
			}

			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}

		return eventResponse;
	}
	/**
	 * ESM_BKG_0079_02B : save <br>
	 * TRO  Save process <br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKrTro(Event e) throws EventException {

		EsmBkg007902bEvent event = (EsmBkg007902bEvent)e;
		TransferOrderIssueBC    command    = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC     command2   = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC command3   = new GeneralBookingReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String uiId = "ESM_BKG_0079_02B";
		boolean troCfm = false;
		try{
			begin();

			//------------------------------------------->
			event.getBkgBlNoVO().setCaFlg("N"); 
			String bkgNo      = event.getBkgBlNoVO().getBkgNo();
			String boundCd    = event.getBoundCd();
			String rtnTroFlg  = event.getRtnTroFlg();
			String delFlg     = event.getDelFlg();  //event assortment (delete:Y, request:R, save:N)
			String currTroSeq = event.getCurrTroSeq();

			//--------------
			//1) general
			event.getTroVO().setEBkgFlg("N"); 
			event.getTroVO().setDelFlg (delFlg);
			
			TroMstVO[] arrTroMstVO = event.getTroVO().getArrTroMstVO();
			if (arrTroMstVO != null) {
				for (int i=0; i<arrTroMstVO.length; i++) {
					arrTroMstVO[i].setBkgNo     (bkgNo);
					arrTroMstVO[i].setIoBndCd   (boundCd);
					arrTroMstVO[i].setRtnTroFlg (rtnTroFlg);
					if ("N".equals(arrTroMstVO[i].getCfmFlgOld()) && "Y".equals(arrTroMstVO[i].getCfmFlg())){
						troCfm = true;
					}
				}
				event.getTroVO().setArrTroMstVO(arrTroMstVO);
			}

			TroDtlVO[] arrTroDtlVO = event.getTroVO().getArrTroDtlVO();
			if (arrTroDtlVO != null) {
				for (int i=0; i<arrTroDtlVO.length; i++) {
					arrTroDtlVO[i].setBkgNo     (bkgNo);
					arrTroDtlVO[i].setIoBndCd   (boundCd);
					arrTroDtlVO[i].setRtnTroFlg (rtnTroFlg);
				}
				event.getTroVO().setArrTroDtlVO(arrTroDtlVO);
			}

			BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = event.getTroVO().getArrBkgTroSpclCgoSeqVO();
			if (arrBkgTroSpclCgoSeqVO != null) {
				for (int i=0; i<arrBkgTroSpclCgoSeqVO.length; i++) {
					arrBkgTroSpclCgoSeqVO[i].setBkgNo     (bkgNo);
					arrBkgTroSpclCgoSeqVO[i].setIoBndCd   (boundCd);
					arrBkgTroSpclCgoSeqVO[i].setRtnTroFlg (rtnTroFlg);
				}
				event.getTroVO().setArrBkgTroSpclCgoSeqVO(arrBkgTroSpclCgoSeqVO);
			}

			//----------------
			//2) rtn_cago
			TroMstVO[] arrTroMstVOrtn = event.getTroVO().getArrTroMstVOrtn();
			if (arrTroMstVOrtn != null) {
				for (int i=0; i<arrTroMstVOrtn.length; i++) {
					arrTroMstVOrtn[i].setBkgNo(bkgNo);
					arrTroMstVOrtn[i].setIoBndCd(boundCd);
					arrTroMstVOrtn[i].setRtnTroFlg("Y");
				}
				event.getTroVO().setArrTroMstVOrtn(arrTroMstVOrtn);
			}

			TroDtlVO[] arrTroDtlVOrtn = event.getTroVO().getArrTroDtlVOrtn();
			if (arrTroDtlVOrtn != null) {
				for (int i=0; i<arrTroDtlVOrtn.length; i++) {
					arrTroDtlVOrtn[i].setBkgNo(bkgNo);
					arrTroDtlVOrtn[i].setIoBndCd(boundCd);
					arrTroDtlVOrtn[i].setRtnTroFlg("Y");
				}
				event.getTroVO().setArrTroDtlVOrtn(arrTroDtlVOrtn);
			}
			//<-------------------------------------------

			//---------------------------
			//01.Before history Save, process			
			HistoryTableVO historyTableVO = command2.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());

			//---------------------------
			//02. Tro Save
			Map<String,Object> responseData = new HashMap<String,Object>();
			responseData = command.manageTro(event.getTroVO(), account, currTroSeq);  //containVO

			//---------------------------
			//03. Qty Save
			BkgQuantityVO[] arrBkgQuantityVO = (BkgQuantityVO[])responseData.get(WebKeys.ER_DBROWSETS);
			command3.modifyBkgQtyByTro(arrBkgQuantityVO, boundCd, account);

			//---------------------------
			//04. BkgHistory Save 
			command2.manageBookingHistory(uiId, historyTableVO, account); 

			if(troCfm){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("TROCFM");// TRO CONFIRM input for doc performance
				command2.manageDocProcess(bkgDocProcSkdVO, account);
			}
			
			eventResponse.setETCData("post_flg", delFlg); 
			
			//---------------------------
			//*) Normal at the completion of the return process messages
			String resultMsg = (String)responseData.get(WebKeys.ER_MESSAGE);
			resultMsg = ((resultMsg==null)? "": resultMsg);
			
			if ("".equals(resultMsg)) {
				if ("Y".equals(delFlg)) {
					eventResponse.setUserMessage("[Success] "+new ErrorHandler("GEM00010").getUserMessage());  //GEM00010 : del success
				} else if ("N".equals(delFlg) || "C".equals(delFlg)) {
					eventResponse.setUserMessage("[Success] "+new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
				} //"R" :  success message not return 
			} else {
				eventResponse.setUserMessage("[Success] "+resultMsg);
			}

			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0079_02C : save <br>
	 * europe tro  Save process<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEurTro(Event e) throws EventException {

		EsmBkg007902cEvent event = (EsmBkg007902cEvent)e;
		TransferOrderIssueBC    troCmd       = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC     histCmd      = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC generalCmd   = new GeneralBookingReceiptBCImpl();
		BookingUtil             util         = new BookingUtil();
		GeneralEventResponse    eventResponse = new GeneralEventResponse();
		
		String uiId = "ESM_BKG_0079_02C";	
		boolean isMstChk = false;
		boolean isDtlChk = false;

		try{
			begin();

			//------------------------------------------->
			event.getBkgBlNoVO().setCaFlg("N"); 
			String bkgNo   = event.getBkgNo();
			String boundCd = event.getBoundCd();
			String delFlg  = event.getDelFlg(); // Save(Seq) -> C; Save All -> N; Dtl Delete -> Y
			String currTroSeq = event.getCurrTroSeq();

			//----------------
			//1) general
			event.getEurTroVO().setEBkgFlg("N");
			event.getEurTroVO().setDelFlg (delFlg);
			
			EurTroMstVO[] arrEurTroMstVO = event.getEurTroVO().getArrEurTroMstVO();
			if (arrEurTroMstVO != null) {
				isMstChk = true;
				for (int i=0; i<arrEurTroMstVO.length; i++) {
					arrEurTroMstVO[i].setBkgNo(bkgNo);
					arrEurTroMstVO[i].setIoBndCd(boundCd);
				}
				event.getEurTroVO().setArrEurTroMstVO(arrEurTroMstVO);
			}

			EurTroDtlVO[] arrEurTroDtlVO = event.getEurTroVO().getArrEurTroDtlVO();
			if (arrEurTroDtlVO != null) {
				isDtlChk = true;
				for (int i=0; i<arrEurTroDtlVO.length; i++) {
					arrEurTroDtlVO[i].setBkgNo(bkgNo);
					arrEurTroDtlVO[i].setIoBndCd(boundCd);
				}
				event.getEurTroVO().setArrEurTroDtlVO(arrEurTroDtlVO);
			}

			BkgEurTroDgSeqVO[] arrBkgEurTroDgSeqVO = event.getEurTroVO().getArrBkgEurTroDgSeqVO();
			if (arrBkgEurTroDgSeqVO != null) {
				for (int i=0; i<arrBkgEurTroDgSeqVO.length; i++) {
					arrBkgEurTroDgSeqVO[i].setBkgNo(bkgNo);
					arrBkgEurTroDgSeqVO[i].setIoBndCd(boundCd);
				}
				event.getEurTroVO().setArrBkgEurTroDgSeqVO(arrBkgEurTroDgSeqVO);
			}
			//<-------------------------------------------

			//---------------------------
			//01. Before history Save, process			
			HistoryTableVO historyTableVO = histCmd.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());
			
			//Keep the key information to check change for TRS call
			List<EurTroChangeVO> eurTroBefore = troCmd.searchEurTroChange(bkgNo, boundCd, "");

			//---------------------------
			//02. Tro Save
			Map<String,Object> responseData = new HashMap<String,Object>();
			responseData = troCmd.manageEurTro(event.getEurTroVO(), bkgNo, currTroSeq, account);  //containVO

			//---------------------------
			//03. Qty Save
			BkgQuantityVO[] arrBkgQuantityVO = (BkgQuantityVO[])responseData.get(WebKeys.ER_DBROWSETS);
			generalCmd.modifyBkgQtyByTro(arrBkgQuantityVO, boundCd, account);
			
			//2015.03.10 kimtaekyun TRS interface
			String category 	= "ATEU";
			String troSeq		= "";
			String troSubSeq	= "";
			String deltFlg		= "";
			log.debug("\n ############ start interface TRS ");
			
			
			//Master�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥猷울옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼占쎄껀�뙴遺억옙�뿥�쐻占쎈윪占쎈��占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋�뜝�럥�듃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�맱�뜾�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ퉮占쎌맶�뜝�럥�쑅�뜝�럥�걖�솾�꺂�뒧�뜝�뜦維뽩쳞�눨�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣鍮섊뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈군�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩�뜮戮с궘占쎌뵛占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럡�꼫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�썒�슢�占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈��뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윞占쎈뭼占쎈쐻占쎈윞占쎄쉥占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굜占쏙옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�쑅�뜝�럥利쏙옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�꺋占쎌굲�뜝�럩�읁占쎈쐻占쎈윥筌앸뱶�쐻占쎈윪�뤃占쏙옙�쐻占쎈윥占쎌넇占쎈쐻占쎈윥占쎌죸占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡�뜝�럡�꽫�뜝�럩援뀐옙�쐻占쎈윥占쎈퉻占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럡�뜦占썩벀�걠占쎄뎡占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈ぁ占쎈쐻占쎈윪�굢酉대쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄わ┼�슣鍮뽳옙�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼆占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�뜝�럥�뒌占쎈쨨占쎈뙔占쎌굲�뜝�럥�넇占쎈쐻占쎈윪�굢酉대쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈� master �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럡�뜦占썩벀�걠占쎄뎡占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈ぁ占쎈쐻占쎈윪�굢酉대쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄わ┼�슣鍮뽳옙�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈짗占쎌굲�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�, Detail�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뜝�럩諭욕뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦 �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣鍮섊뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈군�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩�뜮戮с궘占쎌뵛占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럡�꼫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�썒�슢�占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈��뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윞占쎈뭼占쎈쐻占쎈윞占쎄쉥占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굜占쏙옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪野껉엥�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�졑占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뜝�럩二わ옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�읉�뜝�럥�맶�뜝�럥�쑅占쎈쐩占쎈쎕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄퐫占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럥援▼뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�꽴�뫜�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� detail �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윞占쎈뭼占쎈쐻占쎈윞占쎄쉥占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굜占쏙옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌졁占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜�뜝�럥�맶�뜝�럥�쑅�뜝�럥�읉�뜝�럥�맶�뜝�럥�쑋�뜝�럥占쎈럽�쐻占쎈윥�젆占썲뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎄섯占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�룞�삕�뜝�럥�맶�뜝�럥�쐾�뜝�럥�맜占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럥�떛�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀, �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔占쎈쇀占쎌돸占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럥�닍�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎄숱占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뭶�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅占쎈쑏占쎈묄占쎌굲�뜝�럡�맮�뜝�럥�떛亦껋꼨援ㅿ옙�젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럡�뒋�뜝�럥堉졾뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜝�럡瑗덌옙�맶�뜝�럥�쐾�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럵占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣鍮섊뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈군�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩�뜮戮с궘占쎌뵛占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럡�꼫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�썒�슢�占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈��뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윞占쎈뭼占쎈쐻占쎈윞占쎄쉥占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굜占쏙옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�쑅�뜝�럥利쏙옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�꺋占쎌굲�뜝�럩�읁占쎈쐻占쎈윥筌앸뱶�쐻占쎈윪�뤃占쏙옙�쐻占쎈윥占쎌넇占쎈쐻占쎈윥占쎌죸占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앭뜝�럥�몡�뜝�럡�꽫�뜝�럩援뀐옙�쐻占쎈윥占쎈퉻占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럡�뜦占썩벀�걠占쎄뎡占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈ぁ占쎈쐻占쎈윪�굢酉대쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됧뜝�럡肄わ┼�슣鍮뽳옙�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼆占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�뜝�럥�뒌占쎈쨨占쎈뙔占쎌굲�뜝�럥�넇占쎈쐻占쎈윪�굢酉대쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈� master�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윞占쎈뭼占쎈쐻占쎈윞占쎄쉥占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굜占쏙옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌졁占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜�솾�꺂�뒩占쎈뤂�뤆�룆逾껓옙�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈눓占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈쭢占쎈쐻占쎈윥占쎈윾占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥琉곩뜝�럩�쟼�뜝�럥利드뜝�럥裕뀐옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럡�뜦占썩벀�걠占쎄뎡占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈ぁ占쎈쐻占쎈윪�굢酉대쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됵옙�쇀域밟뫁�굲占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥釉붾���뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윞�굜�껊쐻占쎈윥占쏙옙占쎈쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥六뷴뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇽옙�쐻占쎈윥占쎈뼓占쎈쐻占쎈윥占쎈쭊占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윥�젆議얜쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋�썒�슢�占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼲彛쀯옙堉꿨퐲�꺈�삕�뙴�뵃�삕占쎄뎡占쎈눇�뙼蹂��굲�솾�봾�꺋占쎌굲�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈눓占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈짗占쎌굲�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈탶野껊챶爾잌뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�뜝�떥�궠猷쎾뜝�럥�맶�뜝�럥�쑋�뜝�럥痢ε뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌죪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡���뜝�럡�꼤�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뮲�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
			if(isMstChk){
				log.debug("mstVO....");
				if ("Y".equals(delFlg)) {			//Cancel Frustrate
					deltFlg	  = "Y";
					for (int i=0; i<arrEurTroMstVO.length; i++)
					{
						//dtl seq占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈눓占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈뙀�눧�뜄�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쐾�뜝�럥堉귨옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊�굢�룇�삕占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧�씙�뜝�럥�룈占쎈쐻占쎈윞占쎈뙃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몞占쎈쨨占쎈쳹占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩�쟼占쎌넂占쎄데占쎄광占쎈쐻占쎈윥占쎈쭓占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥猷울옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼占쎄껀�뇡癒�釉몌옙�쐻占쎈윪占쎈쨧�뜝�럥夷⑨옙�쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪鈺곌낑�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌죪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡���뜝�럡�꼤�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뮲�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
						List<TroDtlVO> list = troCmd.searchEurTroSubSeqList(bkgNo, boundCd, currTroSeq);
						if(list != null){
							for(int k=0; k<list.size(); k++){
//								interfaceToTrs(category, bkgNo, boundCd, currTroSeq, list.get(i).getTroSubSeq(), deltFlg, account);
								util.interfaceToTrs(category, bkgNo, boundCd, currTroSeq, list.get(k).getTroSubSeq(), deltFlg, account, "N", "0");
							}
						}						
					}
				}else if("C".equals(delFlg)){		//SAVE SEQ - currTroSeq
					for (int i=0; i<arrEurTroMstVO.length; i++)
					{
						//dtl seq占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈눓占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈뙀�눧�뜄�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쐾�뜝�럥堉귨옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊�굢�룇�삕占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧�씙�뜝�럥�룈占쎈쐻占쎈윞占쎈뙃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몞占쎈쨨占쎈쳹占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩�쟼占쎌넂占쎄데占쎄광占쎈쐻占쎈윥占쎈쭓占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥猷울옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼占쎄껀�뇡癒�釉몌옙�쐻占쎈윪占쎈쨧�뜝�럥夷⑨옙�쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪鈺곌낑�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌죪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡���뜝�럡�꼤�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뮲�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
						List<TroDtlVO> list = troCmd.searchEurTroSubSeqList(bkgNo, boundCd, currTroSeq);
						if(list != null){
							for(int k=0; k<list.size(); k++){
//								interfaceToTrs(category, bkgNo, boundCd, currTroSeq, list.get(i).getTroSubSeq(), "", account);
								util.interfaceToTrs(category, bkgNo, boundCd, currTroSeq, list.get(k).getTroSubSeq(), "", account, "N", "0");
							}
						}
					}
				}else{								//SAVE ALL
					for (int i=0; i<arrEurTroMstVO.length; i++)
					{
						troSeq = arrEurTroMstVO[i].getTroSeq();
						//dtl seq占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰�뙴�쉻�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈㎟占쎈눓占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈뙀�눧�뜄�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쐾�뜝�럥堉귨옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊�굢�룇�삕占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧�씙�뜝�럥�룈占쎈쐻占쎈윞占쎈뙃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몞占쎈쨨占쎈쳹占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩�쟼占쎌넂占쎄데占쎄광占쎈쐻占쎈윥占쎈쭓占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥猷울옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼占쎄껀�뇡癒�釉몌옙�쐻占쎈윪占쎈쨧�뜝�럥夷⑨옙�쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪鈺곌낑�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌죪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡���뜝�럡�꼤�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뮲�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
						List<TroDtlVO> list = troCmd.searchEurTroSubSeqList(bkgNo, boundCd, troSeq);
						if(list != null){
							for(int k=0; k<list.size(); k++){
								util.interfaceToTrs(category, bkgNo, boundCd, troSeq, list.get(k).getTroSubSeq(), "", account, "N", "0");
							}
						}
					}
					
				}
			}
			
			if(!isMstChk && isDtlChk){
				log.debug("dtlVO....");
				if ("Y".equals(delFlg)) {			//Cancel Frustrate
					deltFlg	  = "Y";
					for (int k=0; k<arrEurTroDtlVO.length; k++) 
					{
						troSeq 	  = arrEurTroDtlVO[k].getTroSeq();
						troSubSeq = arrEurTroDtlVO[k].getTroSubSeq();
						util.interfaceToTrs(category, bkgNo, boundCd, troSeq, troSubSeq, deltFlg, account, "N", "0");
						
					}
				}else if("C".equals(delFlg)){		//SAVE SEQ - currTroSeq
					for (int k=0; k<arrEurTroDtlVO.length; k++) 
					{
						troSeq 	  = arrEurTroDtlVO[k].getTroSeq();
						troSubSeq = arrEurTroDtlVO[k].getTroSubSeq();
						util.interfaceToTrs(category, bkgNo, boundCd, troSeq, troSubSeq, "", account, "N", "0");
					}
				}else{								//SAVE ALL
					for (int k=0; k<arrEurTroDtlVO.length; k++) 
					{
						troSeq 	  = arrEurTroDtlVO[k].getTroSeq();
						troSubSeq = arrEurTroDtlVO[k].getTroSubSeq();
						util.interfaceToTrs(category, bkgNo, boundCd, troSeq, troSubSeq, "", account, "N", "0");
					}
				}
			}

			//Change after confirm
			if(eurTroBefore!=null){
				for (int m=0; m<eurTroBefore.size(); m++){
					List<EurTroChangeVO> eurTroAfter = troCmd.searchEurTroChange(bkgNo, boundCd, eurTroBefore.get(m).getTroSeq());
					if(eurTroAfter!=null){
						if(!eurTroBefore.get(m).getZnCd().equals(eurTroAfter.get(0).getZnCd())){
							//Call COP. Almost same as TRO confirm process
							if("C".equals(eurTroAfter.get(0).getHlgTpCd())){
								ProductCatalogCreateBC  prdCtlBC = new ProductCatalogCreateBCImpl(); 
								BkgCopManageBC 			copBC    = new BkgCopManageBCImpl();	

								String pctlNo = null;
								
								if ("O".equals(boundCd)) {
									troCmd.validateInlaneRoute(event.getBkgBlNoVO(), "O", 
											eurTroAfter.get(0).getCntrRtnYdCd(), 
											eurTroAfter.get(0).getZnCd(), null, "");
								} else {
									troCmd.validateInlaneRoute(event.getBkgBlNoVO(), "I", 
											eurTroAfter.get(0).getCntrPkupYdCd(), 
											eurTroAfter.get(0).getZnCd(), null, "");								
								}
								
								//Check S/O is created or not
								if(util.searchSoExistByTro(bkgNo, boundCd, eurTroBefore.get(m).getTroSeq())){
									throw new EventException((String)new ErrorHandler("BKG08358").getMessage());
								}

								//if ("No".equals(strCfmFlgOld) && "Yes".equals(strCfmFlg)){
								log.debug("\n new PRD call####################################################");
								PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
								prdMainInfoVO.setFCmd  ("3");
								prdMainInfoVO.setPcMode(boundCd);
								prdMainInfoVO.setBkgNo (bkgNo);
							
								BkgBlNoVO prdBkgBlNoVO = new BkgBlNoVO();
								prdBkgBlNoVO.setBkgNo(bkgNo);
								prdBkgBlNoVO.setCaFlg("N"); 
								
								//Get Min Tro Sub Seq
								String minEurTroSubSeq = troCmd.searchMinEurTroSubSeq(bkgNo, boundCd , eurTroAfter.get(0).getTroSeq());

								//Call TRO confirm cancel process
								copBC.unconfirmTro(bkgNo, eurTroBefore.get(m).getTroSeq(), minEurTroSubSeq, boundCd);

								PrdTroInfoVO prdTroInfoVO = new PrdTroInfoVO(); 
								prdTroInfoVO.setAreaContiCd("E");
								prdTroInfoVO.setTroSeq   (eurTroAfter.get(0).getTroSeq());
								prdTroInfoVO.setTroSubSeq(minEurTroSubSeq);
								prdTroInfoVO.setCntrNo   (eurTroAfter.get(0).getCntrNo()); 
								prdTroInfoVO.setDorZone  (eurTroAfter.get(0).getZnCd()); 
								prdTroInfoVO.setTroPkupCy(eurTroAfter.get(0).getCntrPkupYdCd()); 
								prdTroInfoVO.setTroRtnCy (eurTroAfter.get(0).getCntrRtnYdCd()); 
								prdTroInfoVO.setHaulage  (eurTroAfter.get(0).getHlgTpCd());        //02C �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쐾�뜝�럥�몘占쎈쐻占쎈쑆甕곤옙�뜝�럡肄э옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럡�뜦占쎈�롳옙占쏙옙留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏁춯占쏙옙留뺧옙�맶�뜝�럥�쐾占쎄턀占쎄뎀占쎈돗�뜝�럩�뮝占쎈쑏筌믩끃�굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뭶�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚳퐢理볩옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�솗�뛾�렯猷쀯옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎈쾫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮚�뜝�럡��占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몘�뜝�럥�넅占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦
								prdTroInfoVO.setTrMode   (changeTrspModeCd(eurTroAfter.get(0).getBkgTrspMzdCd()));   //02C �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쐾�뜝�럥�몘占쎈쐻占쎈쑆甕곤옙�뜝�럡肄э옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럡�뜦占쎈�롳옙占쏙옙留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏁춯占쏙옙留뺧옙�맶�뜝�럥�쐾占쎄턀占쎄뎀占쎈돗�뜝�럩�뮝占쎈쑏筌믩끃�굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뭶�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚳퐢理볩옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�솗�뛾�렯猷쀯옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎈쾫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮚�뜝�럡��占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몘�뜝�럥�넅占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦
							
								PrdParameterVO prdParameterVO = new PrdParameterVO(); 
								prdParameterVO.setPrdMainInfoVO(prdMainInfoVO); 
								prdParameterVO.setBkgBlNoVO    (prdBkgBlNoVO); 
								prdParameterVO.setPrdTroInfoVO (prdTroInfoVO); 
								PrdParameterVO schPrdParameterVO = util.searchPrdParmForInlandRoute(prdParameterVO); 
	
								//---------------------------
								//06. createProdCtlRoute : ESD/PRD module call
								pctlNo = prdCtlBC.createPrdCtlgRout(schPrdParameterVO, account);
							
								if(pctlNo == null ||pctlNo.length()==0){
									throw new EventException((String)new ErrorHandler("BKG02032").getMessage());
								}
								prdBkgBlNoVO.setPctlNo(pctlNo);
								log.debug("\n modifyEurTroPctlNo ##################" + pctlNo);
								troCmd.modifyEurTroPctlNo(prdBkgBlNoVO, boundCd, eurTroAfter.get(0).getTroSeq(), account);

								//---------------------------
								//07. confirmTro : SCE module call
								log.debug("\n confirmTro call (edit after confirm) ###################################################");
								copBC.confirmTro(bkgNo, eurTroAfter.get(0).getTroSeq(), minEurTroSubSeq, boundCd, pctlNo, "E");
								log.debug("\n confirmTro end####################################################");
								//---------------------------
								//08. interfaceCoa : COA module call
								log.debug("\n interfaceToCoa Confirm call###################################################");
								interfaceToCoa(event.getBkgBlNoVO(), "TRO Confirm", account);
								log.debug("\n interfaceToCoa Confirm end####################################################");
							}
						}								
					}
				}
			}

			//---------------------------
			//04. BkgHistory Save 
			histCmd.manageBookingHistory(uiId, historyTableVO, account); 
			
			eventResponse.setETCData("post_flg", delFlg); 
			//---------------------------
			//*) Normal at the completion of the return process messages
			String resultMsg = (String)responseData.get(WebKeys.ER_MESSAGE);
			resultMsg = ((resultMsg==null)? "": resultMsg);
			if ("".equals(resultMsg)) {
				if ("Y".equals(delFlg)) {
					eventResponse.setUserMessage("[SUCCESS] "+new ErrorHandler("GEM00010").getUserMessage());  //GEM00010 : del success
				} else if ("N".equals(delFlg) || "C".equals(delFlg)) {
					eventResponse.setUserMessage("[SUCCESS] "+new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
				} //"CF" :  success message not return 	
			} else {
				eventResponse.setUserMessage("[SUCCESS] "+resultMsg);
			}

			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02C : Cancel/Frust <br>
	 * europe tro  cancel/Frust Popup
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelFrustEurTro(Event e) throws EventException {
		TransferOrderIssueBC command  = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC  command1 = new BookingHistoryMgtBCImpl();
//		BlRatingBC           command2 = new BlRatingBCImpl();
		BkgCopManageBC 		 copBC    = new BkgCopManageBCImpl();	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			begin();

			String uiId = "ESM_BKG_0079_02C";
			TroMultiCancelFrustVO[] arrTroMultiCancelFrustVO = null;
			EsmBkg0703Event event = (EsmBkg0703Event)e;
			arrTroMultiCancelFrustVO = event.getTroMultiCancelFrustVOs();
			
			//01. BkgHistory
			log.debug("bkg_no:"+ event.getBkgBlNoVO().getBkgNo());
			event.getBkgBlNoVO().setCaFlg("N"); 
			HistoryTableVO historyTableVO = command1.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());

			//02. Cancel/Frust
			command.cancelFrustEurTro(arrTroMultiCancelFrustVO, account);
			
//			if ("I".equals(event.getIoBndCd())) {
//				//03. vat process
//				TroCfmVO troCfmVO = new TroCfmVO();
//				TroListForCfmVO[] arrTroListForCfmVO = new TroListForCfmVO[arrTroMultiCancelFrustVO.length];

//				for (int i=0; i<arrTroListForCfmVO.length; i++) {
//					arrTroListForCfmVO[i].setBkgNo     (event.getBkgBlNoVO().getBkgNo());
//					arrTroListForCfmVO[i].setHlgTpCd   (arrTroMultiCancelFrustVO[i].getHlgTpCd());
//					arrTroListForCfmVO[i].setCurrCd    (arrTroMultiCancelFrustVO[i].getCurrCd());
//					arrTroListForCfmVO[i].setTrnsRevAmt(arrTroMultiCancelFrustVO[i].getTrnsRevAmt());
//					arrTroListForCfmVO[i].setCntrNo    (arrTroMultiCancelFrustVO[i].getCntrNo());
//				}
//				troCfmVO.setArrTroListForCfmVO(arrTroListForCfmVO);
//				command2.createCHRevenue(troCfmVO, account);
				
				//04. CA History creation
//				String strCaRsnCd    = ""; 
//				String strCaCorrRmk  = "";
//				String strRdnAcptFlg = "N";
				//addCaHistory(strCaRsnCd, strCaCorrRmk, event.getBkgBlNoVO());
//				addCaHistory(strCaRsnCd, strCaCorrRmk, event.getBkgBlNoVO(), strRdnAcptFlg);
//			}

			for(int i=0;i<arrTroMultiCancelFrustVO.length;i++){		
				log.debug("ibFlg:"      + arrTroMultiCancelFrustVO[i].getIbflag() + 
						", tro_seq:"    + arrTroMultiCancelFrustVO[i].getTroSeq() +
						", cxl_flg:"    + arrTroMultiCancelFrustVO[i].getCxlFlg() +
						", cxl_flg_chk:"+ arrTroMultiCancelFrustVO[i].getCxlFlgChk() +
						", frust:"      + arrTroMultiCancelFrustVO[i].getFrustrate() +
						", frustCheck:" + arrTroMultiCancelFrustVO[i].getFrustrateChk());
		
				if( "U".equals(arrTroMultiCancelFrustVO[i].getIbflag())
				 && ( "Y".equals(arrTroMultiCancelFrustVO[i].getCxlFlgChk())||
						 "Y".equals(arrTroMultiCancelFrustVO[i].getFrustrateChk()))) 
				{
					String minEurTroSubSeq = command.searchMinEurTroSubSeq(arrTroMultiCancelFrustVO[i].getBkgNo(), arrTroMultiCancelFrustVO[i].getIoBndCd(), arrTroMultiCancelFrustVO[i].getTroSeq());
					log.debug("\n (CANCEL/FRUST)confirmTro call####################################################");
					copBC.unconfirmTro(arrTroMultiCancelFrustVO[i].getBkgNo(), arrTroMultiCancelFrustVO[i].getTroSeq(), minEurTroSubSeq, arrTroMultiCancelFrustVO[i].getIoBndCd());
				}
			}
			//06. interfaceCoa : COA module call
			log.debug("\n (CANCEL/FRUST)interfaceToCoa call####################################################");
			interfaceToCoa(event.getBkgBlNoVO(), "TRO Unconfirm", account);

			//05. BkgHistory
			command1.manageBookingHistory(uiId, historyTableVO, account); 
			
			commit();

			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0906 : Confirm <br>
	 * europe tro Confirm Popup Confirm process<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmEurTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0906Event event = (EsmBkg0906Event)e;
		TransferOrderIssueBC    troCmd  = new TransferOrderIssueBCImpl();
		BlRatingBC              rateCmd = new BlRatingBCImpl();	
		BookingHistoryMgtBC     histCmd = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC generalCmd = new GeneralBookingReceiptBCImpl(); 
		BookingUtil             util     = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String uiId = "ESM_BKG_0906";
		boolean eurTroCfm = false;
		try{
			begin();			
			event.getBkgBlNoVO().setCaFlg("N"); 
			
			//01. confirmEurTro
			troCmd.confirmEurTro(event.getTroCfmVO(), account);
			
			//02. pre-BkgHistory
			HistoryTableVO historyTableVO = histCmd.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());		
				
			//03. createCHRevenue
			String strMasterBkgNo = rateCmd.createCHRevenue(event.getTroCfmVO(), account);
			event.setBkgNo(strMasterBkgNo); 
				
			if ("O".equals(event.getIoBndCd())) {
			//04. modifyKrPkupRtnCy 
			//to be same with KOR -- As korea tro, pickupinformation update
				generalCmd.modifyEurPkupRtnCy(event.getBkgBlNoVO());
			}
			
			//05. BkgHistory
			histCmd.manageBookingHistory(uiId, historyTableVO, account); 

			
			TroListForCfmVO[] arrTroListForCfmVO = event.getTroCfmVO().getArrTroListForCfmVO(); 
			if (arrTroListForCfmVO != null) 
			{
				for (int i=0; i<arrTroListForCfmVO.length; i++)
				{
					if ("C".equals(arrTroListForCfmVO[i].getHlgTpCd())) 
					{
						ProductCatalogCreateBC  prdCtlBC = new ProductCatalogCreateBCImpl(); 
						BkgCopManageBC 			copBC    = new BkgCopManageBCImpl();	
						
						String strCfmFlg    = JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getCfmFlg(),    "No");
						String strCfmFlgOld = JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getCfmFlgOld(), "No");
						String pctlNo = null;
											
						//unconfirm->confirm : As confirm
						if ("Yes".equals(strCfmFlg) && "No".equals(strCfmFlgOld)){
							eurTroCfm = true;
							
							if ("O".equals(event.getIoBndCd())) {
								troCmd.validateInlaneRoute(event.getBkgBlNoVO(), "O", 
										arrTroListForCfmVO[i].getCntrRtnYdCd(), 
										arrTroListForCfmVO[i].getZnCd(), null, "Y");
							} else {
								troCmd.validateInlaneRoute(event.getBkgBlNoVO(), "I", 
										arrTroListForCfmVO[i].getCntrPkupYdCd(), 
										arrTroListForCfmVO[i].getZnCd(), null, "Y");								
							}
							
							//if ("No".equals(strCfmFlgOld) && "Yes".equals(strCfmFlg)){
								log.debug("\n new PRD call####################################################");
								PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
								prdMainInfoVO.setFCmd  ("3");
								prdMainInfoVO.setPcMode(arrTroListForCfmVO[i].getIoBndCd());
								prdMainInfoVO.setBkgNo (arrTroListForCfmVO[i].getBkgNo());
							
								BkgBlNoVO prdBkgBlNoVO = new BkgBlNoVO();
								prdBkgBlNoVO.setBkgNo(arrTroListForCfmVO[i].getBkgNo());
								prdBkgBlNoVO.setCaFlg("N"); 
								
								//Get Min Tro Sub Seq
								String minEurTroSubSeq = troCmd.searchMinEurTroSubSeq(arrTroListForCfmVO[i].getBkgNo(),event.getIoBndCd() , arrTroListForCfmVO[i].getTroSeq());
							
								PrdTroInfoVO prdTroInfoVO = new PrdTroInfoVO(); 
								prdTroInfoVO.setAreaContiCd("E");
								prdTroInfoVO.setTroSeq   (arrTroListForCfmVO[i].getTroSeq());
								prdTroInfoVO.setTroSubSeq(minEurTroSubSeq);
								prdTroInfoVO.setCntrNo   (arrTroListForCfmVO[i].getCntrNo()); 
								prdTroInfoVO.setDorZone  (arrTroListForCfmVO[i].getZnCd()); 
								prdTroInfoVO.setTroPkupCy(arrTroListForCfmVO[i].getCntrPkupYdCd()); 
								prdTroInfoVO.setTroRtnCy (arrTroListForCfmVO[i].getCntrRtnYdCd()); 
								prdTroInfoVO.setHaulage  (arrTroListForCfmVO[i].getHlgTpCd());        //02C �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쐾�뜝�럥�몘占쎈쐻占쎈쑆甕곤옙�뜝�럡肄э옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럡�뜦占쎈�롳옙占쏙옙留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏁춯占쏙옙留뺧옙�맶�뜝�럥�쐾占쎄턀占쎄뎀占쎈돗�뜝�럩�뮝占쎈쑏筌믩끃�굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뭶�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚳퐢理볩옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�솗�뛾�렯猷쀯옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎈쾫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮚�뜝�럡��占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몘�뜝�럥�넅占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦
								prdTroInfoVO.setTrMode   (changeTrspModeCd(arrTroListForCfmVO[i].getBkgTrspMzdCd()));   //02C �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쐾�뜝�럥�몘占쎈쐻占쎈쑆甕곤옙�뜝�럡肄э옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럡�뜦占쎈�롳옙占쏙옙留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏁춯占쏙옙留뺧옙�맶�뜝�럥�쐾占쎄턀占쎄뎀占쎈돗�뜝�럩�뮝占쎈쑏筌믩끃�굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뭶�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚳퐢理볩옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�솗�뛾�렯猷쀯옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎈쾫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮚�뜝�럡��占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몘�뜝�럥�넅占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦
							
								PrdParameterVO prdParameterVO = new PrdParameterVO(); 
								prdParameterVO.setPrdMainInfoVO(prdMainInfoVO); 
								prdParameterVO.setBkgBlNoVO    (prdBkgBlNoVO); 
								prdParameterVO.setPrdTroInfoVO (prdTroInfoVO); 
								PrdParameterVO schPrdParameterVO = util.searchPrdParmForInlandRoute(prdParameterVO); 
	
								//---------------------------
								//06. createProdCtlRoute : ESD/PRD module call
								pctlNo = prdCtlBC.createPrdCtlgRout(schPrdParameterVO, account);
							
								if(pctlNo == null ||pctlNo.length()==0){
									//throw new EventException((String)new ErrorHandler("BKG00658").getMessage());
									throw new EventException((String)new ErrorHandler("BKG02032").getMessage());
								}
								prdBkgBlNoVO.setPctlNo(pctlNo);
								log.debug("\n modifyEurTroPctlNo ##################" + pctlNo);
								troCmd.modifyEurTroPctlNo(prdBkgBlNoVO, arrTroListForCfmVO[i].getIoBndCd(), arrTroListForCfmVO[i].getTroSeq(), account);
							//}else{
							//	log.debug("\n old PRD call####################################################");
								/** 
								 * =======================================
								 * searchPcNoforTro 
								 * =======================================
								 */
							//	BkgTroVO tVO = new BkgTroVO();
							//	tVO.setCxlFlg("EUR");
							//	tVO.setBkgNo(bkgNo);
							//	tVO.setTroSeq(arrTroListForCfmVO[i].getTroSeq());
							//	tVO.setRtnTroFlg("");
							//	BkgTroVO bkgTroVO = util.searchPcNoforTro(tVO);
							//	pctlNo = bkgTroVO.getPctlNo();
							//	log.debug("\n old PRD end####################################################");
							//}
							//if ("Yes".equals(strCfmFlg) && "Yes".equals(strCfmFlgOld)){
							//	log.debug("\n unconfirmTro call####################################################");
							//	copBC.unconfirmTro(arrTroListForCfmVO[i].getBkgNo(), arrTroListForCfmVO[i].getTroSeq(), "1", arrTroListForCfmVO[i].getIoBndCd());
							//	log.debug("\n unconfirmTro end####################################################");
							//}
							//---------------------------
							//07. confirmTro : SCE module call
							log.debug("\n confirmTro call###################################################");
							copBC.confirmTro(arrTroListForCfmVO[i].getBkgNo(), arrTroListForCfmVO[i].getTroSeq(), minEurTroSubSeq, arrTroListForCfmVO[i].getIoBndCd(), pctlNo, "E");
							log.debug("\n confirmTro end####################################################");
							//---------------------------
							//08. interfaceCoa : COA module call
							log.debug("\n interfaceToCoa Confirm call###################################################");
							interfaceToCoa(event.getBkgBlNoVO(), "TRO Confirm", account);
							log.debug("\n interfaceToCoa Confirm end####################################################");
						} 
						//confirm->unconfirm : cancel �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥占썲뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윥壤쏅���삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕앾옙�쐻占쎈윥筌뚮겭�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥堉℡뜝�럡�뀷占쎈쇀占쎈젿占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅嶺뚋욌벉�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�젆議얜쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌쓧�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�뙴琉꾩삕占쎌맶�뜝�럥�쑅占쎌젂�뜝�룞�삕占쎌맶�뜝�럥�쑅�뜝�럥�럵占쎈쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럡愿묈뜝�럥�맶�뜝�럥�쐾�뜝�럥由듿뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�뤈�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
						else if ("No".equals(strCfmFlg) && "Yes".equals(strCfmFlgOld)) 
						{
							//---------------------------
							//07. unconfirmTro : SCE module call
							log.debug("\n unconfirmTro call###################################################");
							copBC.unconfirmTro(arrTroListForCfmVO[i].getBkgNo(), arrTroListForCfmVO[i].getTroSeq(), "1", arrTroListForCfmVO[i].getIoBndCd());
							log.debug("\n unconfirmTro end####################################################");
							//---------------------------
							//08. interfaceCoa : COA module call
							log.debug("\n interfaceToCoa Unconfirm call###################################################");
							interfaceToCoa(event.getBkgBlNoVO(), "TRO Unconfirm", account);
							log.debug("\n interfaceToCoa Unconfirm end####################################################");
						}
					 // Merchant Haulage 占쎈눇�뙼�뿫�쑋�뜝�럥裕∽옙�쐻占쎈윥筌앾옙 COA I/F �뜝�럥�돯占쎄껀占쎈짗占쎌굲	
					}else if ("M".equals(arrTroListForCfmVO[i].getHlgTpCd())){
						
						String strCfmFlg    = JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getCfmFlg(),    "No");
						String strCfmFlgOld = JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getCfmFlgOld(), "No");
						
						if ("Yes".equals(strCfmFlg) && "No".equals(strCfmFlgOld)){
							interfaceToCoa(event.getBkgBlNoVO(), "TRO Confirm", account);
						}
						else if ("No".equals(strCfmFlg) && "Yes".equals(strCfmFlgOld)){
							interfaceToCoa(event.getBkgBlNoVO(), "TRO Unconfirm", account);
						}
					}
				}
			}
			if(eurTroCfm){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("TROCFM");// TRO CONFIRM input for doc performance
				histCmd.manageDocProcess(bkgDocProcSkdVO, account);
			}		
			
			commit();
			//interfaceToInv(event.getBkgBlNoVO(), account);
			eventResponse.setETCData("isSuccess","Y");
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
		}catch(EventException ex){
			rollback();
			throw ex;  			
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0920 : copy <br>
	 * Copy TRO  Saveprocess<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse copyTro(Event e) throws EventException {
		EsmBkg0920Event event = (EsmBkg0920Event)e;
		TransferOrderIssueBC command  = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC  command3 = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			begin();
			
			//1) TroCopy
			command.copyTro(event.getBkgBlNoVO(), event.getBoundCd(), event.getTroSeq(), event.getArrBkgBlNoVO(), account);
			
			//2) History 
			String hisCateNm      = "Tro Copy"; 
			String crntCtnt       = "Copy from Booking No:"+event.getBkgBlNoVO().getBkgNo(); 
			
			BkgBlNoVO[] arrBkgBlNoVO = event.getArrBkgBlNoVO();
			for(int i=0; i<arrBkgBlNoVO.length; i++) {
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo         (arrBkgBlNoVO[i].getBkgNo());
				historyLineVO.setUiId          (event.getUiId());
				historyLineVO.setCrntCtnt      (crntCtnt);
				historyLineVO.setHisCateNm     (hisCateNm);
				command3.createBkgHistoryLine(historyLineVO, account);
			}
			
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0907 : open <br>
	 * TRO-Container Inquiry  Container popup(ESM_BKG_0907) retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTroCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0907Event event = (EsmBkg0907Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BkgEurCntrListVO> list = command.searchEurTroCntrList(event.getBkgBlNoVO(), event.getIoBndCd());		
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0703 : open <br>
	 * europe tro Cancel/Frustrate popup(ESM_BKG_0703) retrieve<br>
	 * @author  
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTroForCancelFrust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0703Event event = (EsmBkg0703Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<TroMultiCancelFrustVO> list = command.searchEurTroForCancelFrust(event.getIoBndCd(), event.getBkgBlNoVO());		
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0921 : open <br>
	 * TRO-Multi popup  retrieve process<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultiBkg(Event e) throws EventException {
		EsmBkg0921Event event = (EsmBkg0921Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<TroMultiBkgVO> list = command.searchMultiBkg(event.getBkgBlNoVO(), event.getCntrNo(), event.getBoundCd());			
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0566_01 : open <br>
	 * History popup Header + commbolist + B/L Data retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlHist(Event e) throws EventException {
		EsmBkg0566Event event = (EsmBkg0566Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
        try {        	
			HistMainVO histMainVO = command.searchBlHist(event.getBkgBlNoVO());
			
			//==============================================
			//Etc-1) upper Booking information output : EtcData 
			BkgInforForHistVO bkgInforForHistVO = histMainVO.getBkgInforForHistVO(); 
			
			if (bkgInforForHistVO == null || bkgInforForHistVO == null ) 
			{
				// No data found.
				eventResponse.setETCData("bkg_no",           "");
				eventResponse.setETCData("bl_no",            "");
				eventResponse.setETCData("port_closing",     "");			
				eventResponse.setETCData("bdr_dt",           "");
				eventResponse.setETCData("n1st_vvd",         "");
				eventResponse.setETCData("n1st_pol",         "");
				eventResponse.setETCData("n1st_etb",         "");
				eventResponse.setETCData("n1st_etd",         "");
				eventResponse.setETCData("trnk_vvd",         "");
				eventResponse.setETCData("trnk_pol",         "");
				eventResponse.setETCData("trnk_etb",         "");
				eventResponse.setETCData("trnk_etd",         "");
				
				//eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());	//�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�떋�굩�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤빢�삕占쎌맶�뜝�럥�쑅嶺뚮슢寃�占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅占쎌젂占쎄퐩占쎌맶�뜝�럥�쐾�뜝�룞�삕�솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼲彛쀯옙堉꿨퐲�꺈�삕�뙴�뵃�삕占쎄뎡�뜝�럥夷ⓨ뜝�럥利멨뜝�럩援꿨＄源띿삕占쎈ご�⑤㈇�렊�뜝�럥�맶�뜝�럥�쑅占쎄덩�ⓦ끉�굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�몡�뜝�럩肉뷴뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈쭦癲ル슢캉占쎄콪嶺뚯빖�占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�룞�삕占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼇�븶占쎄덩占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�몱占쎌맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� process 
				eventResponse.setETCData("DataYn", "N");
			} else {		
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(bkgInforForHistVO.getBkgNo()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(bkgInforForHistVO.getBlNo()));
				eventResponse.setETCData("port_closing",     JSPUtil.getNullNoTrim(bkgInforForHistVO.getPortClosing()));
				eventResponse.setETCData("bdr_dt",           JSPUtil.getNullNoTrim(bkgInforForHistVO.getBdrDt()));
				eventResponse.setETCData("n1st_vvd",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getN1stVvd()));
				eventResponse.setETCData("n1st_pol",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getN1stPol()));
				eventResponse.setETCData("n1st_etb",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getN1stEtb()));
				eventResponse.setETCData("n1st_etd",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getN1stEtd()));
				eventResponse.setETCData("trnk_vvd",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getTrnkVvd()));
				eventResponse.setETCData("trnk_pol",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getTrnkPol()));
				eventResponse.setETCData("trnk_etb",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getTrnkEtb()));
				eventResponse.setETCData("trnk_etd",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getTrnkEtd()));
				
				//02. list
				//==============================================
		        //Data-1) Booking History Master information output 
				eventResponse.setRsVoList(histMainVO.getBlHistVOs());
				eventResponse.setETCData("DataYn", "Y");
				
				//==============================================
		        //Data-2) Booking - for Item combo list retrieve
				List<HistUiNmVO> histUiNmVOs = histMainVO.getHistUiNmVOs();
				HistUiNmVO histUiNmVO = new HistUiNmVO();
				histUiNmVO.setUdNm("All"); 
				histUiNmVO.setUiId("");	
				histUiNmVOs.add(0, histUiNmVO);
				eventResponse.setRsVoList(histUiNmVOs);	
			}
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0566_02 : Fax/EDI tab click <br>
	 * History popup  FAX/EDI tab retrieve process<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoticeHist(Event e) throws EventException {
		EsmBkg0566Event event = (EsmBkg0566Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		try {
			List<NoticeHistVO> noticeHistVOs = command.searchNoticeHist(event.getBkgBlNoVO());
			eventResponse.setRsVoList(noticeHistVOs);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0566_03 : Customs Tab click <br>
	 * History popup  Customs Tab retrieve process<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomsHist(Event e) throws EventException {
		EsmBkg0566Event event = (EsmBkg0566Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<CustomsHistVO> customsHistVOs = command.searchCustomsHist(event.getBkgBlNoVO());
			eventResponse.setRsVoList(customsHistVOs);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0566_04 : Document tab Click <br>
	 * History popup Documnents tab retrieve process<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocHist(Event e) throws EventException {
		EsmBkg0566Event event = (EsmBkg0566Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<DocHistVO> docHistVOs = command.searchDocHist(event.getBkgBlNoVO());
			eventResponse.setRsVoList(docHistVOs);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0906 : open <br>
	 * europe tro confirm popup retrieve process<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTroListForCfm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0906Event event = (EsmBkg0906Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			TroCfmVO troCfmVO = command.searchEurTroListForCfm(event.getBkgBlNoVO(), event.getIoBndCd());
			
			if ("I".equals(event.getIoBndCd())) {
				//1) EtcData : null change add
				EurPayerVO eurPayerVO = troCfmVO.getEurPayerVO();
				Map<String,String>     etcData = new HashMap<String,String>();
				HashMap<String,String> hashVO  = eurPayerVO.getColumnValues();
				for (Iterator<String> iter = hashVO.keySet().iterator(); iter.hasNext(); )
		        {
		            String key = iter.next();
		            String val = hashVO.get(key);
		            etcData.put(key, JSPUtil.getNullNoTrim(val));
		        }
				eventResponse.setETCData(etcData);
			}

			//2) list
			List<TroListForCfmVO> list = troCfmVO.getTroListForCfmVOs();
			eventResponse.setRsVoList(list);

			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : save <br>
	 * Tro Actual Customer Master/Dtl I/U/D process<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTroActCust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			String strErrCd = command.manageTroActCust(event.getTroActCustVO(),account);  
			if ("BKG00441".equals(strErrCd))		//invalid location or Zone code
			{
				throw new EventException(new ErrorHandler(strErrCd).getMessage());
			}else if("BKG40120".equals(strErrCd))	//You can't delete the E/Q Office because Customer information exists.
			{
				throw new EventException(new ErrorHandler(strErrCd).getMessage());
			}
			commit();

			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage()); //due to a lot of grid, process on the screen
			//eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0905 : retrieve <br>
	 * Tro Actual Customer Customer tab master information retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCustForTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<MdmCustomerVO> list = command.searchMdmCustForTro(event.getCustCntCd(), event.getCustSeq(), event.getCustNm());		
			eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0905 : master data row click <br>
	 * Tro Actual Customer Customer tab detail retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroActCustByCust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BkgTroActCustVO> list = command.searchTroActCustByCust(event.getOfcCd(), event.getCntCd(), event.getCustSeq());		
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : retrieve <br>
	 * Tro Actual Customer  Eq tab Master retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActCustRep(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BkgTroActRepVO> list = command.searchActCustRep(event.getDorLocCd(), event.getOfcCd(), event.getCustNm());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : master data row click <br>
	 * Tro Actual Customer Eq tab detail retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroActCustByEq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BkgTroActCustExtVO> list = command.searchTroActCustByEq(event.getDorLocCd(), event.getOfcCd(), event.getTroActRepSeq());		
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : vendor code change <br>
	 * Tro Actual Customer  Vendor Name retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String vndrLglEngNm = command.searchVndrName(event.getCntCd(), event.getVndrSeq());

			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("vndr_lgl_eng_nm", JSPUtil.getNullNoTrim(vndrLglEngNm));
			eventResponse.setETCData(etcData);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : open <br>
	 * As Tro Actual Customer Open, Default value initialization information retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroActCustDefault(Event e) throws EventException {
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			TroActCustDefaultVO troActCustDefaultVO = command.searchTroActCustDefault(event.getDorLocCd(), event.getBkgBlNoVO());

			Map<String,String> etcData = new HashMap<String,String>();
			if (troActCustDefaultVO == null) {
				etcData.put("p_cust_cnt_cd",    "");
				etcData.put("p_cust_seq",       "");
				etcData.put("p_eq_ctrl_ofc_cd", "");
			} else {
				etcData.put("p_cust_cnt_cd",    JSPUtil.getNullNoTrim(troActCustDefaultVO.getCustCntCd()));
				etcData.put("p_cust_seq",       JSPUtil.getNullNoTrim(troActCustDefaultVO.getCustSeq()));
				etcData.put("p_eq_ctrl_ofc_cd", JSPUtil.getNullNoTrim(troActCustDefaultVO.getEqCtrlOfcCd()));
			}
			eventResponse.setETCData(etcData);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0650 : Open <br>
	 * Routeinformation retrieve process <br>
	 * 
	 * @author    
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIbTsRoute(Event e) throws EventException {
		try{
			EsmBkg0650Event event = (EsmBkg0650Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<TSRouteVO> list = command.searchIbTsRoute(event.getBkgBlNoVO(), event.getCodRqstSeq(), event.getOpCd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0652 : open/retrieve <br>
	 * Customer information retrieve process<br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgCreCustCntc(Event e) throws EventException {
		try{
			EsmBkg0652Event event = (EsmBkg0652Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();

			// ContainerVO�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅嶺뚮슡�굫占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쑅嶺뚯빖諭띰옙�맶�뜝�럥�쑅�뜏類ｏ옙癒��굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈엥力놂옙占쎈눁ieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�맱�뇯�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎈룦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럡��占쎈쐻占쎈짗占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪鈺곌내�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤빢�삕占쎌맶�뜝�럥�쑅嶺뚮슢寃�占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅占쎌젂占쎄퐩占쎌맶�뜝�럥�쐾�뜝�룞�삕�솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼲彛쀯옙堉꿨퐲�꺈�삕�뙴�뵃�삕占쎄뎡占쎈눇�뙼蹂��굲�솾�봾�꺋占쎌굲�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�씤逾녑칰�럥�룯�뜝�럥爾쎾뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩堉싧뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럥夷ⓨ뜝�럥堉졾뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜏類ｏ옙占쏙옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈쭦癲ル슢캉占쎄콪占쎈닱熬곻옙占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧占쎈룜�뜝�럥彛믣뜝�럩�쟼占쎈쐻占쎈짗占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뛾占쏙옙�뒅占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럡�꺎占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈첋癲딅냲�삕占썩뱿維뽳옙留띰옙�쐻占쎈윥占쎈첑�뜝�럥���뜝�럥嫄앭뜝�럩占쏙옙�쐻占쎈윥占쎈쭓占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥�렂�뜝�럩援뀐옙�쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐ο옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥�젆臾뺤삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌맽�뜝�럡���뜝�럥�뵰占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎄숱占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�쑅占쎄덩�ⓦ끉�굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�몡�뜝�럩肉뷴뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈쭦癲ル슢캉占쎄콪嶺뚯빖�占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥���뜝�럥�맋�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛筌��맕�쐻占쎈윞�굜�굝�쐻占쎈윥占쎈뼓占쎈꽠�⑥궡�굲占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뜝�럥占썲뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅅ猷뉛옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎌쐺獄�占썹뙴�냵�삕筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥占썲뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���뜝�뜦維뽳옙占쏙┼�슢��泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾袁㏉�쀯옙維믧큺�봿裕뗰옙�굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋占쎈쐻占쎈짗占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥���뜝�럥�젾�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슣�돰占쎌삺�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥�렂�뜝�럩援뀐옙�쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐ο옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥�젆臾뺤삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
			BkgCreCustInqVO bkgCreCustInqVO = command.searchBkgCreCustCntc(	event.getCustCntCd(),
																													event.getCustSeq(),
																													event.getCustNm(),
																													event.getLocCd(),
																													event.getOfcCd());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList((List)bkgCreCustInqVO.getBkgCreCustomer());
//			eventResponse.setRsVoList((List)bkgCreCustInqVO.getCustSrep());
//			eventResponse.setRsVoList((List)bkgCreCustInqVO.getBkgCustCntcPson());

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0652 : retrieve <br>
	 * Customer contact information retrieve process<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCustContact(Event e) throws EventException {
		try{
			EsmBkg0652Event event = (EsmBkg0652Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BkgCreCustInqVO bkgCreCustInqVO = command.searchCustContact(	event.getDetailCustCntCd(),
																												event.getDetailCustSeq());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList((List)bkgCreCustInqVO.getCustSrep());
			eventResponse.setRsVoList((List)bkgCreCustInqVO.getBkgCustCntcPson());

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchMdmCustomerCode(Event e) throws EventException {
		try{
			EsmBkg0652Event event = (EsmBkg0652Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil command = new BookingUtil();
			BkgMdmCustomerVO bkgMdmCustomerVO = command.searchMdmCustomerCode(event.getBkgMdmCustomerVO());
			if(bkgMdmCustomerVO != null){
				eventResponse.setETCData("custCntCd", bkgMdmCustomerVO.getCustCntCd());
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0652 : save <br>
	 * Customer Inquiry Save<br>
	 *
	 * @author 	
	 * @param e  Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgCreCustCntc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0652Event event = (EsmBkg0652Event) e;
		BookingUtil bookingUtil = new BookingUtil();
		BookingMasterMgtBC masterMgt = new BookingMasterMgtBCImpl();
		try {
			// �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪雅뚳옙占쎌녇占쎄틓占쎈뮛�뜝�럥占쎈쉘�쐻占쎈윪占쎄틧�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌묐씛�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윞占쎈뼂占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌읆�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮猷욑옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�맱�뇯�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥筌λ�ｋ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뛾占쏙옙�뒅占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럡�꺎占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈첋癲딅냲�삕占썩뱿維뽳옙留띰옙�쐻占쎈윥占쎈첑�뜝�럥���뜝�럥嫄앭뜝�럩占쏙옙�쐻占쎈윥占쎈쭓占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�씤逾녑칰�럥�룯�뜝�럥爾쎾뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩堉싧뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뭶�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윞占쎄틢�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥泥뗧솾�봾�꺋占쎌굲�뜝�뜦諭욜땟戮녹삕筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럥泥묕옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥椰꾩빆�쐻占쎈윪�뜝�룞�삕占쎌맶�뜝�럥�쑅�뜝�럥彛볟뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쎾뜝�럥夷⑨옙�쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쏙옙�뜝�럥�맶�뜝�럥�쑅嶺뚯쉶�젎omerinformation�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌ｋ쵓�삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럩�맳�뛾�룇�삌�댚�렱�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럡�뜦占썩벀�걠占쎄뎡占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈ぁ占쎈쐻占쎈윪�굢酉대쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥彛��솾�꺂�뒧罹됵옙�쇀域밟뫁�굲占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럡肄ⓨ뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈쨮占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�룞�삕�뜝�럥�맶�뜝�럥�쐾�뜝�럡�꺎�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥�렂�뜝�럩援뀐옙�쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐ο옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥�젆臾뺤삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쎗�뜝�룞�삕占쎈뭶�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚳퐢理볩옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�솗�뛾�렯猷쀯옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥鸚룐벂�쐻占쎈윞占쎈�싷옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윥�뜝�뜴�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎄슈占쎄섶占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈콦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�셾�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆轅⑦맪占쏙옙占쎌굲占쎌젂饔끸뫂留ゅ뜝�럡�떅�뜝�럩援꿨뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럩�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�뤈�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
			MdmCustVO mdmCustVO = bookingUtil.searchMdmCust(event.getDetailCustCntCd(), event.getDetailCustSeq(), "Y");
			if(mdmCustVO != null){
				if("P".equals(mdmCustVO.getCustTpCd())){
					eventResponse.setUserMessage(new ErrorHandler("BKG00187").getUserMessage());
				}else{
					begin();
					masterMgt.manageCustContact(	event.getBkgCustCntcPsonVOS(),
																	account.getUsr_id() );
					commit();
				}
			}

		} catch (EventException ex) {
			rollback();
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0972 : open <br>
	 * Service Mode & Route retrieve<br>
	 *
	 * @author 		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcRouteMode(Event e) throws EventException {
		try{
			EsmBkg0972Event event = (EsmBkg0972Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingUtil util = new BookingUtil();
			
			BkgBookingVO bkgBookingVO = command.searchSvcRouteMode(event.getBkgBlNoVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(bkgBookingVO != null){
				eventResponse.setETCData("org_sconti_cd",bkgBookingVO.getOrgScontiCd());
				eventResponse.setETCData("dest_sconti_cd",bkgBookingVO.getDestScontiCd());
				eventResponse.setETCData("org_trns_svc_mod_cd",bkgBookingVO.getOrgTrnsSvcModCd());
				eventResponse.setETCData("dest_trns_svc_mod_cd",bkgBookingVO.getDestTrnsSvcModCd());
				eventResponse.setETCData("blck_stwg_cd",bkgBookingVO.getBlckStwgCd());

				List<BkgComboVO> list = util.searchCombo("CD02149");
				if(list.size()>0){
					for(int i=0; i<list.size(); i++){
						if(list.get(i).getVal().equals(bkgBookingVO.getOrgTrnsSvcModCd())){
							eventResponse.setETCData("org_trns_svc_mod_nm",list.get(i).getDesc());
						}
						if(list.get(i).getVal().equals(bkgBookingVO.getDestTrnsSvcModCd())){
							eventResponse.setETCData("dest_trns_svc_mod_nm",list.get(i).getDesc());
						}
					}
				}
				event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
				BkgBlNoVO bkgBlNoVO = util.searchBkgBlNoVO(event.getBkgBlNoVO());
				if(bkgBlNoVO != null){
					eventResponse.setETCData("ca_flg",bkgBlNoVO.getCaFlg());
				}
			}else{
				eventResponse.setETCData("org_sconti_cd","");
				eventResponse.setETCData("dest_sconti_cd","");
				eventResponse.setETCData("org_trns_svc_mod_cd","");
				eventResponse.setETCData("org_trns_svc_mod_cd","");
				eventResponse.setETCData("dest_trns_svc_mod_cd","");
				eventResponse.setETCData("dest_trns_svc_mod_cd","");
				eventResponse.setETCData("blck_stwg_cd","");
				eventResponse.setETCData("ca_flg","");
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0972 : SEARCH02 <br>
	 * Block Stowage check Retrieve<br>
	 *
	 * @author 		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlckStwgFlg(Event e) throws EventException {
		try{
			EsmBkg0972Event event = (EsmBkg0972Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			
			BkgBookingVO bkgBookingVO = command.searchBlckStwgFlg(event.getBkgBookingVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("blck_stwg_flg",bkgBookingVO.getBlckStwgFlg());
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_0972 : MULTI <br>
	 * Block Stowage UPDATE<br>
	 *
	 * @author 		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlckStwgCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String uiId = "ESM_BKG_0972";	
		GeneralBookingSearchBC	command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC		command2= new BookingHistoryMgtBCImpl();
		BkgBlNoVO vo = new BkgBlNoVO();
		try{
			begin();
			EsmBkg0972Event event = (EsmBkg0972Event)e;
			vo.setBkgNo(event.getBkgBookingVO().getBkgNo());
			
			//01. Before history Save, process			
			HistoryTableVO historyTableVO = command2.searchOldBkgForHistory(uiId, vo);			
			command.manageBlckStwgCd(event.getBkgBookingVO(),account);
			
			//02. After history Save, process
			command2.manageBookingHistory(uiId, historyTableVO, account);
			commit();
			
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;

	}	
	/**
	 * ESM_BKG_0090 : open <br>
	 * Stowage Code retrieve<br>
	 *
	 * @author 		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageCode(Event e) throws EventException {
		try{
			BookingUtil command = new BookingUtil();
			// 20090623 'CD02146'�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅嶺뚮슡�굫占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쑅嶺뚯빖諭띰옙�맶�뜝�럥�쑅�뜏類ｏ옙癒��굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌젶占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈쭦癲ル슢�돘占쎌굲�뜝�럥�렓�뜝�럥�쑠ing
			List<BkgComboVO> list = command.searchCombo("CD02146");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0998 : open <br>
	 * Constraint retrieve<br>
	 *
	 * @author 		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchConstraint(Event e) throws EventException {
		try{
			EsmBkg0998Event event = (EsmBkg0998Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<PrdConstraintVO> list = command.searchConstraint(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0083 : RETRIEVE <br>
	 * Node Search information retrieve<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNodeCode(Event e) throws EventException {
		try{
			EsmBkg0083Event event = (EsmBkg0083Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<NodeListVO> list = command.searchNodeCode(event.getNodeListInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0083 : retrieve <br>
	 * Locaton information retrieve<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationList(Event e) throws EventException {
		try{
			EsmBkg0083Event event = (EsmBkg0083Event)e;
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			List<LocationListVO> list = searchBC.searchLocationList(event.getLocationListInputVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_0097 : Open <br>
	 * Reference information retrieve<br>
	 *
	 * @author 		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReferenceList(Event e) throws EventException {
		try{
			EsmBkg0097Event event = (EsmBkg0097Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingUtil util = new BookingUtil();
			
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoVO = util.searchBkgBlNoVO(event.getBkgBlNoVO());
			
			List<RefNoVO> list = command.searchBkgReference(bkgBlNoVO);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG-0097 : Save <br>
	 * Reference information Save<br>
	 *
	 * @author 	
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReferenceNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0097Event event = (EsmBkg0097Event) e;

		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		try {
			begin();
			// 01. History information retrieve
			HistoryTableVO historyTableVO = hisBC.searchOldBkgForHistory("ESM_BKG_0097", event.getBkgBlNoVO());

			// 03. manage Reference information
			receiptBC.manageRefNo(event.getBkgReferenceVOs(), account, event.getBkgBlNoVO());
			
			// 04. manageBkgHistory
			hisBC.manageBookingHistory("ESM_BKG_0097", historyTableVO, account);
			commit();
			eventResponse.setETCData("isSuccess","Y");
		} catch (EventException ex) {
			log.error("err"+ex.toString(),ex);	
//			eventResponse.setUserMessage(new ErrorHandler(ex).getUserMessage());
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0744 : open/retrieve <br>
	 * Direct NVO-AMS File No retrieve.<br>
	 *
	 * @author 	
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNVOFileNumberList(Event e) throws EventException {
		try{
			EsmBkg0744Event event = (EsmBkg0744Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();

			UsaCstmsFileListVO usaCstmsFileListVO = command.searchNVOFileNumberList(event.getBkgBlNoVO());

			List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNoVO = usaCstmsFileListVO.getBkgUsaCstmsFileNo();

			HblCountVO hblCountVO = usaCstmsFileListVO.getHblCountVO();
			String hblCount = "";
			if(hblCountVO != null){
				hblCount = hblCountVO.getHblTtlKnt();
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(bkgUsaCstmsFileNoVO);
			eventResponse.setETCData("hbl_count",hblCount);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0744 : save <br>
	 * manage Direct NVO-AMS File No information<br>
	 *
	 * @author 
	 * @param e  Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNVOFileNumber(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0744Event event = (EsmBkg0744Event) e;

		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();

		try {
			begin();
			// 01. �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럡猿��뛾�룆梨룹쮼�뜝�럥�맶�뜝�럥�쑅嶺뚯빖�占쎌맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼占쎈쐻占쎈윥�젆議얜쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮛�뇦猿볦삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윞占쎈쭢占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�돍�삕�뇡�쑚�쐻占쎈윞占쎈쑆占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル쉵堉쏆슱�삕占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쐾�뜝�럥堉뇋tory information占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�릮etrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥占썲뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윥壤쏅���삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑋�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐪筌먦끇議곩뜝�럡�븧占쎈쐻占쎈윥占쎈엶�뜝�럡愿뚦뜝�럩�뮀嶺뚮쪋�삕占쎈쐻占쎈윞占쎈릊占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆轅⑦맪占쏙옙占쎌굲占쎌젂饔끸뫂留ゅ뜝�럡�떅�뜝�럩援꿨뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럩�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�뤈�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
			HistoryTableVO historyTableVO = hisBC.searchOldBkgForHistory("ESM_BKG_0744", event.getBkgBlNoVO());

			// 02. Direct NVO-AMS File No占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗傭��끉猷딉옙�굲占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅占쎈쇀占쎈츐占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗傭��끉猷뉛옙�굷�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�떍占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎌뵥�얜뀘移곤옙�윥占쎈／占쎈쐻占쎈윥�댚�렱�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윪�젆�떑�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉끻뜝�럥�맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎌뵥�얜뀘移곤옙�윥占쎈／占쎈쐻占쎈윥�댚�렱�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윪�젆�떑�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�졑占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅占쎌젂占쎄퐩占쎌맶�뜝�럥�쐾�뜝�룞�삕�솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚳퐢肉㏆옙�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�몘�뛾占쏙옙�뒏占쎈마嶺뚮�⑸걙占쎄뎡癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럥�몦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕싷옙�쐻占쎈윞占쏙옙�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈읁�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윥獒뺣�먯삕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
			receiptBC.manageNVOFileNumber(event.getBkgUsaCstmsFileNoVOs(), account, event.getBkgBlNoVO());
			
			// 03. HBL Count占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�릧odifying�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥占썲뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윥壤쏅���삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑋�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐪筌먦끇議곩뜝�럡�븧占쎈쐻占쎈윥占쎈엶�뜝�럡愿뚦뜝�럩�뮀嶺뚮쪋�삕占쎈쐻占쎈윞占쎈릊占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆轅⑦맪占쏙옙占쎌굲占쎌젂饔끸뫂留ゅ뜝�럡�떅�뜝�럩援꿨뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럩�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�뤈�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
			int hblCount = 0;
			if(event.getHblCountVO() != null && event.getHblCountVO().getHblTtlKnt() != null && !"".equals(event.getHblCountVO().getHblTtlKnt())){
				hblCount = Integer.parseInt(event.getHblCountVO().getHblTtlKnt());
			}
			blDocBC.modifyHblCount(hblCount, event.getBkgBlNoVO(), account);
			
			// 04. manageBkgHistory
			hisBC.manageBookingHistory("ESM_BKG_0744", historyTableVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0587 : pol_code_keyup<br>
	 * Booking Office retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgOfcListForBkgClz(Event e)throws EventException{
		try{
			EsmBkg0587Event event =(EsmBkg0587Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			List<BkgComboVO> list = command.searchBkgOfcListForBkgClz(event.getPolCd(),event.getVslCd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0587:btn_Retrieve<br>
	 * Booking Closing for Bayplan retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCoffTm(Event e)throws EventException{
		try{
			EsmBkg0587Event event =(EsmBkg0587Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			List<BkgCoffTmListVO> list = command.searchBkgCoffTm(event.getBkgListForBayPlanInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
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
	 * ESM_BKG_0587:btn_Booking_Close<br>
	 * Booking Close for Bayplan information Save<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse closeBkgForBayPlan(Event e)throws EventException{
		
		try{
			EsmBkg0587Event event = (EsmBkg0587Event)e;
			BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
			BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.closeBKGForBayPlan(event.getBkgCoffTmVOs(), account);
			blBC.modifyBkgClose(event.getBkgCoffTmVOs(), account);
			commit();

			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0587:btn_Re_Open<br>
	 * Booking ReOpen for Bayplan information Save<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reopenBkgForBayPlan(Event e)throws EventException{
		try{
			EsmBkg0587Event event = (EsmBkg0587Event)e;
			BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
			BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			command.reopenBkgForBayPlan(event.getBkgCoffTmVOs(), account);
			blBC.modifyBkgClose(event.getBkgCoffTmVOs(), account);
			commit();

			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0587:loadPage<br>
	 * Closing retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClzStatus(Event e)throws EventException{
		try{
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 List<BkgComboVO> bkg_clz_sts_list  = comboUtil.searchCombo("CD02111");
	         eventResponse.setCustomData("bkg_clz_sts_list", bkg_clz_sts_list);
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
	 * ESM_BKG_0102 : retrieve <br>
	 * Compulsory Firm List retriev<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgListForCompFirm(Event e) throws EventException {
		try{
			EsmBkg0102Event event = (EsmBkg0102Event)e;		 
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			if(event.getBkgListForCompFirmInputVO()!=null){
				GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();	
				List<BkgListForCompFirmVO> list = command.searchBkgListForCompFirm(event.getBkgListForCompFirmInputVO());
				eventResponse.setRsVoList(list);
			} else {
				BookingUtil comboUtil = new BookingUtil();
				List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");
				List<BkgComboVO> bkgStsCd = new ArrayList<BkgComboVO>();
				for(int i=0;i<bkg_sts_cd.size();i++){
					if("F".equals(bkg_sts_cd.get(i).getVal())||"W".equals(bkg_sts_cd.get(i).getVal())){
						bkgStsCd.add(bkg_sts_cd.get(i));
					}
				}
				eventResponse.setRsVoList(bkgStsCd);
			}
		
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0102 : customer code change <br>
	 * Customer Name retrieve<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCustName(Event e) throws EventException {
		try{
			EsmBkg0102Event event = (EsmBkg0102Event)e;
			BookingUtil bookingUtil = new BookingUtil();

			MdmCustVO mdmCustVO = bookingUtil.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(mdmCustVO != null){
				eventResponse.setETCData("cust_nm",mdmCustVO.getName());
			}else{
				eventResponse.setETCData("cust_nm","");
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKg_0102 : compulsory firm <br>
	 * Compulsory Firm process(change Booking condition)<br>
	 *
	 * @author 
	 * @param e  Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse compFirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0102Event event = (EsmBkg0102Event) e;

		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		
		try {
			if(event.getBkgBlNoVOs()!=null){
				for(int i = 0; i < event.getBkgBlNoVOs().length; i++) {
					begin();
					// 01. change Booking condition
					receiptBC.compFirm(event.getBkgBlNoVOs()[i], account);

					// 02. iterfaceCoa calling(other module)
					interfaceToCoa(event.getBkgBlNoVOs()[i], "Booking Firm", account);
		
					// 03. BookingHistoryMgtBC createBkgHistoryLine calling
					BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
	
//					if(event.getBkgBlNoVOs()[i].getIbflag().equals("U")) {
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setBkgNo(event.getBkgBlNoVOs()[i].getBkgNo());
						historyLineVO.setCaFlg(event.getBkgBlNoVOs()[i].getCaFlg());
						historyLineVO.setBkgDocProcTpCd("BKGFRM");// booking firm for doc performance
						historyLineVO.setUiId("ESM_BKG_0102");
						historyLineVO.setCrntCtnt("Compulsory Firm.");
						historyLineVO.setHisCateNm("Compulsory Firm."); 
						
						historyBC.createBkgHistoryLine(historyLineVO, account);
						
//					}
					// 04. BookingHistoryMgtBC manageDocProcess calling -- BKGSTF
					BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
		            docProcSkdVO.setBkgNo(event.getBkgBlNoVOs()[i].getBkgNo());
		            docProcSkdVO.setBkgDocProcTpCd("BKGSTF");
		            bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
						
					commit();
					
					begin();
					interfaceToInv(event.getBkgBlNoVOs()[i], account);
					commit();
				}
			} 
			if(event.getBkgBlNoVO()!=null){
				begin();
				// 01. change Booking condition
				receiptBC.compFirm(event.getBkgBlNoVO(), account);

				// 02. iterfaceCoa calling(other module)
				interfaceToCoa(event.getBkgBlNoVO(), "Booking Firm", account);
	
				// 03. BookingHistoryMgtBC�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌젶占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒗占쎄콪�뜝�럥猷쒙옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�눆eBkgHistoryLine calling
				BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();

//				if(event.getBkgBlNoVO().getIbflag().equals("U")) {
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					historyLineVO.setCaFlg(event.getBkgBlNoVO().getCaFlg());
					historyLineVO.setBkgDocProcTpCd("BKGFRM");// booking firm for doc performance
					historyLineVO.setUiId("ESM_BKG_0102");
					historyLineVO.setCrntCtnt("Compulsory Firm.");
					historyLineVO.setHisCateNm("Compulsory Firm."); 
					
					historyBC.createBkgHistoryLine(historyLineVO, account);
//				}
					
				// 04. BookingHistoryMgtBC manageDocProcess calling -- BKGSTF
				BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
	            docProcSkdVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
	            docProcSkdVO.setBkgDocProcTpCd("BKGSTF");
	            bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
					
				commit();
				
				begin();
				interfaceToInv(event.getBkgBlNoVO(), account);
				commit();
			}
		} catch (EventException ex) {
			rollback();
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0092 : open <br>
	 * Ocean Route retrieve process.<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsRoute(Event e) throws EventException {
		try{
			EsmBkg0092Event event = (EsmBkg0092Event)e;
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingUtil bookingUtil = new BookingUtil();
			String dataYn = event.getDataYn();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// 01. TransMode Combo
			List<BkgComboVO> bkgTransMode  = bookingUtil.searchCombo("CD01720");
			eventResponse.setRsVoList(bkgTransMode);

			if("Y".equals(dataYn)){
				OceanRouteVO oceanRouteVO = new OceanRouteVO();
				PolPodVvdVO[] vvd = event.getPolPodVvdVOs();
				for (int i = 0; i < vvd.length; i++) {
					vvd[i].setBkgNo(event.getBkgNo());
				}
				
				oceanRouteVO = receiptBC.searchTsRoute(vvd, event.getBkgNo());
				List<VslSkdVO> vslSkds = oceanRouteVO.getVslSkd();
				
//				if(event.getBkgNo().length()<11){
//					for(int i = 0; i<vslSkds.size();i++){
//						if(0 != i){
//							vslSkds.get(i).setPolYdCd("");
//							vslSkds.get(i).setPolClptIndSeq("");						
//						}
//						if(vslSkds.size()-1 != i){
//							vslSkds.get(i).setPodYdCd("");
//							vslSkds.get(i).setPodClptIndSeq("");						
//						}
//					}
//				}
				// 02. Ocean Route list
				eventResponse.setRsVoList(vslSkds);
				// 03. ETA of 1st VVD, ETA of DEL 
				N1stEtaDelEtaVO n1stEtaDelEtaVO = oceanRouteVO.getN1stEtaDelEtaVO();
				if(n1stEtaDelEtaVO != null){
					eventResponse.setETCData("n1st_eta_day",n1stEtaDelEtaVO.getN1stEtaDay());
					eventResponse.setETCData("n1st_eta_time",n1stEtaDelEtaVO.getN1stEtaTime());
					eventResponse.setETCData("del_eta_day",n1stEtaDelEtaVO.getDelEtaDay());
					eventResponse.setETCData("del_eta_time",n1stEtaDelEtaVO.getDelEtaTime());
				}else{
					eventResponse.setETCData("n1st_eta_day","");
					eventResponse.setETCData("n1st_eta_time","");
					eventResponse.setETCData("del_eta_day","");
					eventResponse.setETCData("del_eta_time","");
				}

//				String trunkSeq = receiptBC.searchTrnkVvdByRlane(event.getPolPodVvdVOs());
//				eventResponse.setETCData("trunk_seq", trunkSeq);
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0092 : pol, pol yard, pol calling seq, pod, pod yard, pod calling seq, vvd change <br>
	 * Ocean Route Lane/POL ETD/POD ETA retrieve.<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneEtaEtd(Event e) throws EventException {
		try{
			EsmBkg0092Event event = (EsmBkg0092Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
//			for(int i = 0 ;i<event.getPolPodVvdVOs().length;i++){
//				log.debug(i+":"+event.getPolPodVvdVOs()[i].getPodCd());
//			}
			int editRow = Integer.parseInt(event.getEditRow()) - 1;
			VslSkdVO vslSkdVO = receiptBC.searchLaneEtaEtd(event.getPolPodVvdVOs()[editRow]);
			
			String trunkSeq = receiptBC.searchTrnkVvdByRlane(event.getPolPodVvdVOs());
			eventResponse.setETCData("trunk_seq", trunkSeq);
			
			if(vslSkdVO != null){
				eventResponse.setETCData(vslSkdVO.getColumnValues());
			}
/*			
			if(vslSkdVO != null){
				eventResponse.setETCData("eta_day",vslSkdVO.getEtaDay());
				eventResponse.setETCData("eta_time",vslSkdVO.getEtaTime());
				eventResponse.setETCData("etd_day",vslSkdVO.getEtdDay());
				eventResponse.setETCData("etd_time",vslSkdVO.getEtdTime());
				eventResponse.setETCData("eta",vslSkdVO.getEta());
				eventResponse.setETCData("etd",vslSkdVO.getEtd());
				eventResponse.setETCData("slan_cd",vslSkdVO.getSlanCd());
				eventResponse.setETCData("pol_yd_cd",vslSkdVO.getPolYdCd());
				eventResponse.setETCData("pod_yd_cd",vslSkdVO.getPodYdCd());
			}else{
				eventResponse.setETCData("eta_day","");
				eventResponse.setETCData("eta_time","");
				eventResponse.setETCData("etd_day","");
				eventResponse.setETCData("etd_time","");
				eventResponse.setETCData("eta","");
				eventResponse.setETCData("etd","");
				eventResponse.setETCData("slan_cd","");
				eventResponse.setETCData("pol_yd_cd","");
				eventResponse.setETCData("pod_yd_cd","");
			}
*/			
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
	}

	/**
	 * ESM_BKG_0092 : ok <br>
	 * Ocean Route Check availability.<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateTsRoute(Event e) throws EventException {
		try{
			EsmBkg0092Event event = (EsmBkg0092Event)e;
			GeneralBookingReceiptBC receptBC = new GeneralBookingReceiptBCImpl();

			receptBC.validateTsRoute(event.getPolPodVvdVOs());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0079_01 : open <br>
	 * BookingCreation Default retrieve.<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserBkgDefault(Event e) throws EventException {
		try{
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();

			BookingUtil bookingUtil = new BookingUtil();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// 01. Combo data retrieve (RTerm)
			List<BkgComboVO> rTterm  = bookingUtil.searchCombo("CD00764");
			eventResponse.setRsVoList(rTterm);
			// 01. Combo data retrieve (DTerm)
			List<BkgComboVO> dTerm  = bookingUtil.searchCombo("CD00765");
			eventResponse.setRsVoList(dTerm);
			// 02. Combo data retrieve (Filer1)
			List<BkgComboVO> filer1  = bookingUtil.searchCombo("CD02098");
			eventResponse.setRsVoList(filer1);
			// 03. Combo data retrieve (Filer2)
			List<BkgComboVO> filer2  = bookingUtil.searchCombo("CD01634");
			eventResponse.setRsVoList(filer2);
			// 04. Combo data retrieve (Weight)
			List<BkgComboVO> wgt  = bookingUtil.searchCombo("CD01957");
			eventResponse.setRsVoList(wgt);
			// 05. Combo data retrieve (RailBulk)
			List<BkgComboVO> railBulk  = bookingUtil.searchCombo("CD01566");
			eventResponse.setRsVoList(railBulk);

			// 06. Default setting
			BkgUsrDfltSetVO bkgUsrDfltSetVO = receiptBC.searchUserBkgDefault(account);

			if(bkgUsrDfltSetVO != null){
				eventResponse.setETCData(bkgUsrDfltSetVO.getColumnValues());
			}else{
				eventResponse.setETCData("rcv_term_cd", "");
				eventResponse.setETCData("de_term_cd", "");
				eventResponse.setETCData("mty_pkup_yd_cd", "");
				eventResponse.setETCData("cntr_tpsz_cd", "");
				eventResponse.setETCData("wgt_ut_cd", "");
				eventResponse.setETCData("meas_ut_cd", "");
				eventResponse.setETCData("auto_edi_hld_flg", "");
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0658 : ok <br>
	 * As Stop Off Cargo Order Save, Location check.<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateLocation(Event e) throws EventException {
		try{
			EsmBkg0658Event event = (EsmBkg0658Event)e;
			BookingUtil bookingUtil = new BookingUtil();

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(!bookingUtil.validateLoc(event.getStopOffLocCd())){
				throw new EventException(new ErrorHandler("BKG00061",new String[]{event.getStopOffLocCd()}).getMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0079_01 : commodify change <br>
	 * BookingCreation CmdtCd�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅嶺뚮슡�굫占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쑅嶺뚯빖諭띰옙�맶�뜝�럥�쑅�뜏類ｏ옙癒��굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑅�뜝�럥吏륅옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥筌Ξ룹녇占쎄틓占쎈뮉�뜝�럡肄わ옙�쐻占쎈윥�뙴�뮋�삕占쎌맶�뜝�럥�쑅�뜝�럩諭삼옙�쐻占쎈윥占쎈읁�뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥���뜝�럥猷둧tion retrieve.<br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validatePrecaution(Event e) throws EventException {
		try{
			EsmBkg007901Event event = (EsmBkg007901Event)e;
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CmdtVO cmdtVO = receiptBC.validatePrecaution(event.getCmdtCd());

			if(cmdtVO != null){
				eventResponse.setETCData(cmdtVO.getColumnValues());
			}else{
				eventResponse.setETCData("rep_cmdt_cd","");
				eventResponse.setETCData("cmdt_nm","");
				eventResponse.setETCData("rep_imdg_lvl_cd","");
				eventResponse.setUserMessage(new ErrorHandler("BKG00010").getUserMessage());
			}
			
//			//TEST
//			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
//			List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs = new ArrayList<VslSkdCngNoticeVO>();  
//			VslSkdCngNoticeVO noticeVO = new VslSkdCngNoticeVO();
//			noticeVO.setVslCd("HNMI");
//			noticeVO.setSkdVoyNo("0044");
//			noticeVO.setSkdDirCd("E");
//			noticeVO.setPortCd("KRPUS");
//			noticeVO.setTypeCd("type");
//			noticeVO.setRemark("remark");
//			noticeVO.setClptIndSeq("1");
//			vslSkdCngNoticeVOs.add(noticeVO);
//			command.sendVslSkdCngNotice(vslSkdCngNoticeVOs);
			
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}
	/**
	 * ESM_BKG_0721 : open <br>
	 * booking cut off time information retrieve process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCargoClosingTime(Event e)throws EventException{
		try{
			EsmBkg0721Event event =(EsmBkg0721Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			ClzTmListVO  clzTmListVO = command.searchCargoClosingTime(event.getBkgBlNoVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(clzTmListVO.getClzTmVO());
	
			if(clzTmListVO.getBkgForCargoClosingVO().size()>0){
				eventResponse.setETCData("bkg_no",clzTmListVO.getBkgForCargoClosingVO().get(0).getBkgNo());
				eventResponse.setETCData("vvd",clzTmListVO.getBkgForCargoClosingVO().get(0).getVvd());
				eventResponse.setETCData("pol",clzTmListVO.getBkgForCargoClosingVO().get(0).getPolCd());
				eventResponse.setETCData("etb",clzTmListVO.getBkgForCargoClosingVO().get(0).getEtb());
				eventResponse.setETCData("etd",clzTmListVO.getBkgForCargoClosingVO().get(0).getEtd());
			}else{
				eventResponse.setETCData("vvd","");
				eventResponse.setETCData("pol","");
				eventResponse.setETCData("etb","");
				eventResponse.setETCData("etd","");
			}
			return eventResponse;
		} catch(EventException se) {
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0721 : save <br>
	 * booking cut off time information Save process <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCargoClosingTime(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0721Event event = (EsmBkg0721Event)e;
			GeneralBookingReceiptBC command = new GeneralBookingReceiptBCImpl();
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			BookingUtil util = new BookingUtil();
//			String portCutOffUpdateFlg = "N";
			String troCategoryCd = "";

			begin();
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(event.getBkgClzTmVOs()[0].getBkgNo());
			bkgBlNoVO.setCaFlg("N");
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVO);
			//Check whether Port Cut Off date will be updated or not to call TRO module 
//			portCutOffUpdateFlg = command.searchPortCutOffChange(event.getBkgClzTmVOs());
			
			//Keep Port cut-off date and Cargo cut-off date before update
			List<SearchCutOffDateVO> cutOffDateVOs = command.searchCutOffDate(bkgBlNoVO.getBkgNo());
			
			command.manageCargoClosingTime(event.getBkgClzTmVOs(), account);
			
			if(cutOffDateVOs != null){
				for(int i = 0; i<cutOffDateVOs.size();i++){
					//Check whether cut-off date is updated or not
					troCategoryCd = command.searchCutOffDateChange(cutOffDateVOs.get(i));
					if(!"".equals(troCategoryCd)){
						// Call TRO module to notice the change of Cut-Off date
						util.interfaceToTrs(troCategoryCd, bkgBlNoVO.getBkgNo(), "", "0", "0", "", account, "N", "0");
					}
				}
			}
			
//			if(portCutOffUpdateFlg.equals("Y")){ // Call TRO module to notice the change of Port Cut-Off date
//				interfaceToTrs("CUFF", bkgBlNoVO.getBkgNo(), "", "0", "0", "", account);
//			}
			historyBC.manageBookingHistory("ESM_BKG_0721", historyTableVO, account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
		
	}

	/**
	 * ESM_BKG_0709 : open <br>
	 * reference for danger cargo split retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgSplit(Event e) throws EventException{
		try{
			EsmBkg0709Event event = (EsmBkg0709Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<DgSplitVO>  dgSplitVO = command.searchDgSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(dgSplitVO);
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
	 * ESM_BKG_0710 : open <br>
	 * reference for danger cargo split retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfSplit(Event e) throws EventException{
		try{
			EsmBkg0710Event event = (EsmBkg0710Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<RfSplitVO>  rfSplitVO = command.searchRfSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(rfSplitVO);
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
	 * ESM_BKG_0715 : open <br>
	 * awkward cargo split�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣鍮뽳옙�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維낉옙�젩嚥싲갭큔占쎈뎔�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럡愿댐옙�쐻占쎈쑆泳�占썲뜝�럥�뱥占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쐾�뜝�럥�몘占쎈쐻占쎈쑆甕곤옙�뜝�럡肄э옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럡�뜦占쎈�롳옙占쏙옙留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥�뙴�뮋�삕占쎌맶�뜝�럥�쑅鶯ㅼ룆占썬룗釉멨뜝�럥嫄좑옙�쇀占쎈룇占쎈짂�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒱占쎈쭒占쎄덩占쎈즵占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쑅�뜝�럥萸멨뜝�럥�맶�뜝�럥�쐾�뜝�럥六억옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뤁占쎌젂占쎈즵占쎈뮲�뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럥�닍�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뙴占쏙옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뛾占쏙옙�뒅占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥筌ｋ쵓�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎈뙕獄쎼룗�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿�뜝�럥�맶�뜝�럥�쑋�뜝�럡�꺏�뜝�럥�맶�뜝�럥�쐾�뜝�럥�몥�뜝�럥�맶�뜝�럥�쐾占쎄슈�눧�뜄�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룆�ワ옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�룞�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈쇀占쎌뒻占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥占쎈쐻占쎈윞�뙼占썲뜝�럥���뛾占썼쥈�굥�솯占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�맱�뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�몡占쎈쇊癰귨옙占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈‥�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥壤쎻뼹�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�릮etrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥占썲뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윥壤쏅���삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑋�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐪筌먦끇議곩뜝�럡�븧占쎈쐻占쎈윥占쎈엶�뜝�럡愿뚦뜝�럩�뮀嶺뚮쪋�삕占쎈쐻占쎈윞占쎈릊占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆轅⑦맪占쏙옙占쎌굲占쎌젂饔끸뫂留ゅ뜝�럡�떅�뜝�럩援꿨뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럩�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�뤈�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAkSplit(Event e) throws EventException{
		try{
			EsmBkg0715Event event = (EsmBkg0715Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<AkSplitVO>  akSplitVO = command.searchAkSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(akSplitVO);
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
	 * ESM_BKG_0716 : open <br>
	 * reference for break bulk cargo split retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBbSplit(Event e) throws EventException{
		try{
			EsmBkg0716Event event = (EsmBkg0716Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<BbSplitVO>  bbSplitVO = command.searchBbSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(bbSplitVO);
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
	 * ESM_BKG_1025 : open <br>
	 * reference for tro split retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroSplit(Event e) throws EventException{
		try{
			EsmBkg1025Event event = (EsmBkg1025Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<TroSplitVO>  troSplitVO = command.searchTroSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(troSplitVO);
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
	 * ESM_BKG_0079_01 : retrieve <br>
	 * BookingCreation information retrieve process
	 *As init loading, Validation process in SC due to bring Combo information
	 * 
	 * @author  
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBooking(Event e) throws EventException {
		try{
			EsmBkg007901Event event = (EsmBkg007901Event)e;
			
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BookingUtil 			bookingUtil = new BookingUtil();	
			ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			
			// 01. Combo data retrieve (RTerm)
			List<BkgComboVO> rTterm  = bookingUtil.searchCombo("CD00764");
			eventResponse.setRsVoList(rTterm);
			// 01. Combo data retrieve (DTerm)
			List<BkgComboVO> dTerm  = bookingUtil.searchCombo("CD00765");		
			eventResponse.setRsVoList(dTerm);				
			// 02. Combo data retrieve (Filer1)
			List<BkgComboVO> filer1  = bookingUtil.searchCombo("CD02098");
			eventResponse.setRsVoList(filer1);	
			// 03. Combo data retrieve (Filer2)
			List<BkgComboVO> filer2  = bookingUtil.searchCombo("CD01634");
			eventResponse.setRsVoList(filer2);			
			// 04. Combo data retrieve (Weight)
			List<BkgComboVO> wgt  = bookingUtil.searchCombo("CD01957");	
			eventResponse.setRsVoList(wgt);		
			// 05. Combo data retrieve (RailBulk)
			List<BkgComboVO> railBulk  = bookingUtil.searchCombo("CD01566");
			eventResponse.setRsVoList(railBulk);		

			// 06. Booking information retrieve
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());			
			BookingCreationVO bookingCreationVO = receiptBC.searchBooking(event.getBkgBlNoVO());
			
			if(bookingCreationVO != null){
				BkgBookingInfoVO bkgBookingInfoVO =  bookingCreationVO.getBkgBookingInfoVO();
				
				if(bkgBookingInfoVO != null){
					if("M".equals(bkgBookingInfoVO.getBkgCgoTpCd())){
						// You can not retrieve Empty Reposition BKG Data
						eventResponse.setUserMessage(new ErrorHandler("BKG00092").getUserMessage());
						eventResponse.setETCData("DataYn", "N");
					}else{
						if("Y".equals(bkgBookingInfoVO.getBdrFlg())){
					
							String caUsrId = receiptBC.searchCaTmp(event.getBkgBlNoVO()); 
							if(caUsrId!=null && caUsrId.length()>1){
								if(!caUsrId.equals(account.getUsr_id())){
									BDRCorrectionBC         bDRCorrectionBC     = new BDRCorrectionBCImpl();
									BLDocumentationBLBC     bLDocumentationBLBC = new BLDocumentationBLBCImpl();
									SpecialCargoReceiptBC   spclCgoReceiptBC   	= new SpecialCargoReceiptBCImpl();
									BlRatingBC              blRatingBC          = new BlRatingBCImpl();
									BookingHistoryMgtBC     historyMgtBC    	= new BookingHistoryMgtBCImpl();
									BLIssuanceBC            bLIssuanceBC        = new BLIssuanceBCImpl();
									 		
									//00. RemoveRollOver
									receiptBC.removeCARollOvr(event.getBkgBlNoVO().getBkgNo());
									
									String copyTypeCd = "TEMP";
									spclCgoReceiptBC.removeCA  	(event.getBkgBlNoVO(), copyTypeCd);
									blRatingBC.removeCA         (event.getBkgBlNoVO(), copyTypeCd);
									bLDocumentationBLBC.removeCA(event.getBkgBlNoVO(), copyTypeCd);
									receiptBC.removeCA			(event.getBkgBlNoVO(), copyTypeCd);
									bLIssuanceBC.removeCA       (event.getBkgBlNoVO(), copyTypeCd);
									bDRCorrectionBC.removeCATemp(event.getBkgBlNoVO());
									historyMgtBC.removeTmpHistory(event.getBkgBlNoVO());
								}								
							}
						}
						// original BL No
						String orgBlNo = "";
						if(bookingCreationVO.getSplitMstBlNoVO() != null){
							orgBlNo = bookingCreationVO.getSplitMstBlNoVO().getBlNo();
						}
						eventResponse.setETCData("OrgBlNo",orgBlNo);	
						
						eventResponse.setETCData(bookingCreationVO.getBkgBlNoVO().getColumnValues());	
						// Booking information
						eventResponse.setETCData(bkgBookingInfoVO.getColumnValues());	
						// Vsk information
						List<VslSkdVO> vslSkd = bookingCreationVO.getVslSkd();
						eventResponse.setRsVoList(vslSkd);	
						// Quantity information
						List<BkgQuantityVO> bkgQuantity = bookingCreationVO.getBkgQuantity();
						eventResponse.setRsVoList(bkgQuantity);	
						// QtyDtl information
						List<BkgQtyDtlVO> bkgQtyDtl = bookingCreationVO.getBkgQtyDtl();
						eventResponse.setRsVoList(bkgQtyDtl);	
						
						// Customerinformation
						BlCustomerInfoVO blCustomerInfoVO = bookingCreationVO.getBlCustomerInfoVO();
						if(blCustomerInfoVO != null){
							eventResponse.setETCData(blCustomerInfoVO.getColumnValues());	
						}		
						// Contact information
						eventResponse.setETCData("bkg_cntc_pson_nm", "");
						eventResponse.setETCData("bkg_cntc_pson_phn_no", "");	
						eventResponse.setETCData("bkg_cntc_pson_eml", "");	
						eventResponse.setETCData("bkg_cntc_posn_mphn_no", "");	
						eventResponse.setETCData("bkg_cntc_pson_fax_no", "");	
						eventResponse.setETCData("si_cntc_pson_nm", "");
						eventResponse.setETCData("si_cntc_pson_phn_no", "");	
						eventResponse.setETCData("si_cntc_pson_eml", "");	
						eventResponse.setETCData("si_cntc_posn_mphn_no", "");	
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
//						eventResponse.setETCData("filer_cd", bkgBookingInfoVO.getFilerCd());		
//						eventResponse.setETCData("vvd_flag", bkgBookingInfoVO.getVvdFlag());	
//						eventResponse.setETCData("rfa_available", bkgBookingInfoVO.getRfaAvailable());	
//						eventResponse.setETCData("sc_available", bkgBookingInfoVO.getScAvailable());	
//						eventResponse.setETCData("taa_available", bkgBookingInfoVO.getTaaAvailable());
						
					
						if(!"Y".equals(bkgBookingInfoVO.getBdrFlg())){
							String mvmtStsCd[] = bookingUtil.searchMVMTStatus(event.getBkgBlNoVO(), null);
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
						EventResponse prdCnst = prdBC.searchPrdConstraint(bookingCreationVO.getBkgBookingInfoVO().getPctlNo());
						 
						if(prdCnst != null && prdCnst.getRsList().size() > 0){
							eventResponse.setETCData("constraint_flag", "Y");
						}else{
							eventResponse.setETCData("constraint_flag", "N");
						}
						eventResponse.setETCData("DataYn", "Y");						
					}
					
				}
			}else{
				// No data found.
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
				eventResponse.setETCData("DataYn", "N");
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0190 : Retrieve <BR>
	 * 0190 Customer Code retrieve<br>
	 * 
	 * @param e EsmBkg0190Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomer(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0190Event event = (EsmBkg0190Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try 
		{
			List<SearchActualCustomerVO> list = command.searchActualCustomer(event.getInfoVO());
	
			eventResponse.setRsVoList(list);
			if(list.size() > 0){
				eventResponse.setETCData("from_dt", list.get(0).getFromDt());
				eventResponse.setETCData("to_dt", list.get(0).getToDt());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_01 : save <br> 
	 * In case of changing Route ,Booking Save process.<br>
	 * 
	 * @author  
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithoutRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
		BookingUtil            util  = new BookingUtil();		

		String pctlNo = null;
		String mapSeq = null;
		
		begin();

		// Container VO for Booking information
		BookingCreationVO bookingCreationVO = new BookingCreationVO();
		// VO for result of Validation
		BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();
		PrdParameterVO prdParameterVO = null;
		
		log.debug("routeModifyFlag : "+ bookingSaveValidationVO.getRouteModifyFlag());
		log.debug("customerModifyFlag : "+ bookingSaveValidationVO.getCustomerModifyFlag());
		log.debug("contactModifyFlag : "+ bookingSaveValidationVO.getContactModifyFlag());
		log.debug("qtyModifyFlag : "+ bookingSaveValidationVO.getQtyModifyFlag());
		
		bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
		bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
		bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
		bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
		bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
		bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
		bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
log.debug("############### flex height" + event.getBkgBookingInfoVO().getFlexHgtFlg());		
		// 03. createProdCtlRout 
		try{
			/************* findFullRoute *******************/
			prdParameterVO = util.findFullRoute(bookingCreationVO);
			util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		
		try{
			String pctlNoMapSeqStr = proBC.createPrdCtlgRout(prdParameterVO, account);

			String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
			pctlNo = pctlNoMapSeq[0];
			mapSeq = pctlNoMapSeq[1];
		} catch (Exception pc_ex){
			eventResponse.setETCData("IsPctlNoPop", "YC");	
			rollback();	
			log.debug("Pctl Pop Up Call");
			log.error("Pctl Pop Up Call : " + pc_ex.toString(), pc_ex);
		}						
		
		if("YC".equals(eventResponse.getETCData("IsPctlNoPop"))){
			return eventResponse;
		}
		
		try{
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
			commit();
				
			/********   createBkgWithRoute  ************/
			bookingCreationVO = createBkgInfo(bookingCreationVO);
			if(bookingCreationVO.getToyota()){
				eventResponse.setETCData("Toyota", "Y");	
			}else{
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
					
					// In case of PSA sending,If there are some error, send
					eventResponse.setETCData("psaValCode", bookingCreationVO.getPsaValCode());
				}
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_01 : save <br>
	 * There's no changing in route Booking Save process <br>
	 * 
	 * @author  
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		
		try{
			// Container VO for Booking information
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BookingUtil util = new BookingUtil();
			// VO for result of Validation
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			log.debug("routeModifyFlag : "+ bookingSaveValidationVO.getRouteModifyFlag());
			log.debug("customerModifyFlag : "+ bookingSaveValidationVO.getCustomerModifyFlag());
			log.debug("contactModifyFlag : "+ bookingSaveValidationVO.getContactModifyFlag());
			log.debug("qtyModifyFlag : "+ bookingSaveValidationVO.getQtyModifyFlag());
			
			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
			//pctlNo set
			String [] pctlNoMapSeq = util.splitByToken(event.getPctlNo(), "|");
			bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNoMapSeq[0]);
			bookingCreationVO.getBkgBlNoVO().setMapSeq(pctlNoMapSeq[1]);
			bookingCreationVO = createBkgInfo(bookingCreationVO);
			
			if(bookingCreationVO.getToyota()){
				eventResponse.setETCData("Toyota", "Y");	
			}else{
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
					
					// In case of PSA sending,If there are some error, send
					eventResponse.setETCData("psaValCode", bookingCreationVO.getPsaValCode());
				}
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

//	/**
//	 * If route has to be changed, Routeinformation占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�릮etrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥占썲뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윥壤쏅���삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑋�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐪筌먦끇議곩뜝�럡�븧占쎈쐻占쎈윥占쎈엶�뜝�럡愿뚦뜝�럩�뮀嶺뚮쪋�삕占쎈쐻占쎈윞占쎈릊占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆轅⑦맪占쏙옙占쎌굲占쎌젂饔끸뫂留ゅ뜝�럡�떅�뜝�럩援꿨뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럩�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�뤈�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�(ESM_BKG_0079_01)<br>
//	 *
//	 * @author 	
//	 * @param 	BookingCreationVO bookingCreationVO
//	 * @return 	BookingSaveValidationVO
//	 * @exception EventException
//	 */
//	private PrdParameterVO findFullRoute(BookingCreationVO bookingCreationVO) throws EventException {
//		PrdParameterVO schPrdParameterVO = null;
//		try{
//			BookingUtil util = new BookingUtil();
//			
//			// PrdMainInfoVO Set
//			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
//			BlCustomerInfoVO blCustomerInfoVO = bookingCreationVO.getBlCustomerInfoVO();
//			VslSkdVO[] vslSkdVOs = bookingCreationVO.getVslSkdVOs();
//			PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
//			
//			prdMainInfoVO.setRcvT(bkgBookingInfoVO.getRcvTermCd());
//			prdMainInfoVO.setDelT(bkgBookingInfoVO.getDeTermCd());
//			prdMainInfoVO.setPor(bkgBookingInfoVO.getBkgPorCd());
//			if(bkgBookingInfoVO.getBkgPorYdCd() != null && bkgBookingInfoVO.getBkgPorYdCd().length() > 0){
//				prdMainInfoVO.setPorN(bkgBookingInfoVO.getBkgPorCd()+bkgBookingInfoVO.getBkgPorYdCd());
//			}else{
//				prdMainInfoVO.setPorN(null);
//			}
//			
//			prdMainInfoVO.setPol(bkgBookingInfoVO.getBkgPolCd());
//			if(bkgBookingInfoVO.getBkgPolYdCd() != null && bkgBookingInfoVO.getBkgPolYdCd().length() > 0){
//				prdMainInfoVO.setPolN(bkgBookingInfoVO.getBkgPolCd()+bkgBookingInfoVO.getBkgPolYdCd());
//			}else{
//				prdMainInfoVO.setPolN(null);
//			}			
//			prdMainInfoVO.setPod(bkgBookingInfoVO.getBkgPodCd());
//			if(bkgBookingInfoVO.getBkgPodYdCd() != null && bkgBookingInfoVO.getBkgPodYdCd().length() > 0){
//				prdMainInfoVO.setPodN(bkgBookingInfoVO.getBkgPodCd()+bkgBookingInfoVO.getBkgPodYdCd());
//			}else{
//				prdMainInfoVO.setPodN(null);
//			}						
//			prdMainInfoVO.setDel(bkgBookingInfoVO.getBkgDelCd());
//			if(bkgBookingInfoVO.getBkgDelYdCd() != null && bkgBookingInfoVO.getBkgDelYdCd().length() > 0){
//				prdMainInfoVO.setDelN(bkgBookingInfoVO.getBkgDelCd()+bkgBookingInfoVO.getBkgDelYdCd());
//			}else{
//				prdMainInfoVO.setDelN(null);
//			}							
//			prdMainInfoVO.setTVvd(bkgBookingInfoVO.getBkgTrunkVvd());
//
//			if(vslSkdVOs != null && vslSkdVOs.length > 0){
//				prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
//				if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
//					prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
//				}else{
//					prdMainInfoVO.setPod1N(null);
//				}						
//				prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
//				prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
//				if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
//					prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
//				}else{
//					prdMainInfoVO.setPol1N(null);
//				}
//				prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
//				prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());
//				
//				prdMainInfoVO.setLane1(null);				
//			}else{
//				prdMainInfoVO.setPod1(null);
//				prdMainInfoVO.setPod1N(null);
//				prdMainInfoVO.setPod1C(null);
//				prdMainInfoVO.setPol1(null);
//				prdMainInfoVO.setPol1N(null);
//				prdMainInfoVO.setPol1C(null);
//				prdMainInfoVO.setVvd1(null);
//				prdMainInfoVO.setLane1(null);					
//			}
//			if(vslSkdVOs != null && vslSkdVOs.length > 1){
//				prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
//				if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
//					prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
//				}else{
//					prdMainInfoVO.setPod2N(null);
//				}					
//				prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
//				prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
//				if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
//					prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
//				}else{
//					prdMainInfoVO.setPol2N(null);
//				}					
//				prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
//				prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
//				prdMainInfoVO.setLane2(null);				
//			}else{
//				prdMainInfoVO.setPod2(null);
//				prdMainInfoVO.setPod2N(null);
//				prdMainInfoVO.setPod2C(null);
//				prdMainInfoVO.setPol2(null);
//				prdMainInfoVO.setPol2N(null);
//				prdMainInfoVO.setPol2C(null);
//				prdMainInfoVO.setVvd2(null);
//				prdMainInfoVO.setLane2(null);					
//			}
//			if(vslSkdVOs != null && vslSkdVOs.length > 2){
//				prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
//				if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
//					prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
//				}else{
//					prdMainInfoVO.setPod3N(null);
//				}					
//				prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
//				prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
//				if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
//					prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
//				}else{
//					prdMainInfoVO.setPol3N(null);
//				}					
//				prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
//				prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
//				prdMainInfoVO.setLane3(null);				
//			}else{
//				prdMainInfoVO.setPod3(null);
//				prdMainInfoVO.setPod3N(null);
//				prdMainInfoVO.setPod3C(null);
//				prdMainInfoVO.setPol3(null);
//				prdMainInfoVO.setPol3N(null);
//				prdMainInfoVO.setPol3C(null);
//				prdMainInfoVO.setVvd3(null);
//				prdMainInfoVO.setLane3(null);					
//			}
//			if(vslSkdVOs != null && vslSkdVOs.length > 3){
//				prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
//				if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
//					prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
//				}else{
//					prdMainInfoVO.setPod4N(null);
//				}					
//				prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
//				prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
//				if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
//					prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
//				}else{
//					prdMainInfoVO.setPol4N(null);
//				}				
//				prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
//				prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
//				prdMainInfoVO.setLane4(null);				
//			}else{
//				prdMainInfoVO.setPod4(null);
//				prdMainInfoVO.setPod4N(null);
//				prdMainInfoVO.setPod4C(null);
//				prdMainInfoVO.setPol4(null);
//				prdMainInfoVO.setPol4N(null);
//				prdMainInfoVO.setPol4C(null);
//				prdMainInfoVO.setVvd4(null);
//				prdMainInfoVO.setLane4(null);					
//			}		
//		
//			if(bkgBookingInfoVO.getLodgDueDt() != null){
//				prdMainInfoVO.setLdDt(bkgBookingInfoVO.getLodgDueDt().replaceAll("-", ""));
//			}		
//			if(bkgBookingInfoVO.getMtyDorArrDt() != null){
//				prdMainInfoVO.setDrDt(bkgBookingInfoVO.getMtyDorArrDt().replaceAll("-", ""));
//			}		
//			if(bkgBookingInfoVO.getMtyPkupDt() != null){
//				prdMainInfoVO.setMtPkupDt(bkgBookingInfoVO.getMtyPkupDt().replaceAll("-", ""));
//			}					
//			prdMainInfoVO.setMPu(bkgBookingInfoVO.getMtyPkupYdCd());
//			prdMainInfoVO.setFRt(bkgBookingInfoVO.getFullRtnYdCd());
//			prdMainInfoVO.setOrgTrnsMode(bkgBookingInfoVO.getOrgTrnsModCd());
//			prdMainInfoVO.setDestTrnsMode(bkgBookingInfoVO.getDestTrnsModCd());
//			if(bkgBookingInfoVO.getBkgCgoTpCd() != null){
//				prdMainInfoVO.setCgoTp(bkgBookingInfoVO.getBkgCgoTpCd());
//			}else{
//				prdMainInfoVO.setCgoTp("N");
//			}
//			if(bkgBookingInfoVO.getHotDeFlg() != null){
//				prdMainInfoVO.setPmF(bkgBookingInfoVO.getHotDeFlg());
//			}else{
//				prdMainInfoVO.setPmF("N");
//			}			
//			if(bkgBookingInfoVO.getDcgoFlg() != null){
//				prdMainInfoVO.setDgF(bkgBookingInfoVO.getDcgoFlg());
//			}else{
//				prdMainInfoVO.setDgF("N");
//			}					
//			if(bkgBookingInfoVO.getRcFlg() != null){
//				prdMainInfoVO.setRfF(bkgBookingInfoVO.getRcFlg());
//			}else{
//				prdMainInfoVO.setRfF("N");
//			}					
//			if(bkgBookingInfoVO.getAwkCgoFlg() != null){
//				prdMainInfoVO.setAkF(bkgBookingInfoVO.getAwkCgoFlg());
//			}else{
//				prdMainInfoVO.setAkF("N");
//			}					
//			if(bkgBookingInfoVO.getBbCgoFlg() != null){
//				prdMainInfoVO.setBbF(bkgBookingInfoVO.getBbCgoFlg());
//			}else{
//				prdMainInfoVO.setBbF("N");
//			}					
//			prdMainInfoVO.setRdF(bkgBookingInfoVO.getRdCgoFlg());
//			prdMainInfoVO.setSocF(bkgBookingInfoVO.getSocFlg());
//			prdMainInfoVO.setCom(bkgBookingInfoVO.getCmdtCd());
//			prdMainInfoVO.setRepCom(bkgBookingInfoVO.getRepCmdtCd());
//			prdMainInfoVO.setBkgOfc(bkgBookingInfoVO.getBkgOfcCd());
//			prdMainInfoVO.setOrgSalOfc(bkgBookingInfoVO.getObSlsOfcCd());
//			prdMainInfoVO.setRfa(bkgBookingInfoVO.getRfaNo());
//			prdMainInfoVO.setSc(bkgBookingInfoVO.getScNo());
//			prdMainInfoVO.setShpr(blCustomerInfoVO.getSCustCntCd()+blCustomerInfoVO.getSCustSeq());
//			prdMainInfoVO.setCngn(blCustomerInfoVO.getCCustCntCd()+blCustomerInfoVO.getCCustSeq());
//			prdMainInfoVO.setWgt(bkgBookingInfoVO.getActWgt());
//			prdMainInfoVO.setWgtUn(bkgBookingInfoVO.getWgtUtCd());
//			prdMainInfoVO.setHgF(bkgBookingInfoVO.getHngrFlg());
//			prdMainInfoVO.setSubF(bkgBookingInfoVO.getEqSubstFlg());
//
//			if(!"Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
//				prdMainInfoVO.setBkgNo(bkgBookingInfoVO.getBkgNo());
//			} else {
//				BkgBlNoVO schBkg = util.searchBkgBlNoVO(bookingCreationVO.getBkgBlNoVO());
//				if(schBkg!=null){
//					prdMainInfoVO.setBkgNo(bkgBookingInfoVO.getBkgNo());
//				}
//			}
//			
//			// PrdQuantityVO Set
//			List<PrdQtyInfoVO> prdQtyInfo 	= new ArrayList<PrdQtyInfoVO>();
//			
//			BkgQuantityVO[] bkgQuantityVOs = bookingCreationVO.getBkgQuantityVOs();
//			for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
//				PrdQtyInfoVO prdQtyInfoVO = new PrdQtyInfoVO();
//				
//				prdQtyInfoVO.setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
//				prdQtyInfoVO.setCQty(bkgQuantityVOs[i].getOpCntrQty());
//				
//				prdQtyInfo.add(prdQtyInfoVO);
//			}
//			
//			PrdParameterVO prdParameterVO = new PrdParameterVO();			
//			prdParameterVO.setPrdQtyInfo(prdQtyInfo);
//			prdParameterVO.setBkgBlNoVO(bookingCreationVO.getBkgBlNoVO());
//			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
//			
//			// f_cmd,pc_mode Set
//			prdParameterVO.getPrdMainInfoVO().setFCmd("3");
//
//			// 01. searchPrdParameter
//			schPrdParameterVO = util.searchPrdParmForFullRoute(prdParameterVO);
//
//			schPrdParameterVO.getPrdMainInfoVO().setBkgNo(bkgBookingInfoVO.getBkgNo());
//			if(schPrdParameterVO.getPrdMainInfoVO().getBkgNo() != null && schPrdParameterVO.getPrdMainInfoVO().getBkgNo().length() > 0){
//				// need split, tro, copy assortment
//				schPrdParameterVO.getPrdMainInfoVO().setPcMode("R");
//			}else{
//				schPrdParameterVO.getPrdMainInfoVO().setPcMode("B");
//			}
//			
//
//			if(vslSkdVOs != null && vslSkdVOs.length > 0){
//				schPrdParameterVO.getPrdMainInfoVO().setVvd1(vslSkdVOs[0].getBkgVvdCd());				
//				schPrdParameterVO.getPrdMainInfoVO().setLane1(null);				
//			}else{
//				schPrdParameterVO.getPrdMainInfoVO().setPod1(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPod1N(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPod1C(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol1(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol1N(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol1C(null);
//				schPrdParameterVO.getPrdMainInfoVO().setVvd1(null);
//				schPrdParameterVO.getPrdMainInfoVO().setLane1(null);					
//			}
//			if(vslSkdVOs != null && vslSkdVOs.length > 1){
//				schPrdParameterVO.getPrdMainInfoVO().setVvd2(vslSkdVOs[1].getBkgVvdCd());
//				schPrdParameterVO.getPrdMainInfoVO().setLane2(null);				
//			}else{
//				schPrdParameterVO.getPrdMainInfoVO().setPod2(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPod2N(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPod2C(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol2(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol2N(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol2C(null);
//				schPrdParameterVO.getPrdMainInfoVO().setVvd2(null);
//				schPrdParameterVO.getPrdMainInfoVO().setLane2(null);					
//			}
//			if(vslSkdVOs != null && vslSkdVOs.length > 2){
//				schPrdParameterVO.getPrdMainInfoVO().setVvd3(vslSkdVOs[2].getBkgVvdCd());
//				schPrdParameterVO.getPrdMainInfoVO().setLane3(null);				
//			}else{
//				schPrdParameterVO.getPrdMainInfoVO().setPod3(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPod3N(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPod3C(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol3(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol3N(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol3C(null);
//				schPrdParameterVO.getPrdMainInfoVO().setVvd3(null);
//				schPrdParameterVO.getPrdMainInfoVO().setLane3(null);					
//			}
//			if(vslSkdVOs != null && vslSkdVOs.length > 3){
//				schPrdParameterVO.getPrdMainInfoVO().setVvd4(vslSkdVOs[3].getBkgVvdCd());
//				schPrdParameterVO.getPrdMainInfoVO().setLane4(null);				
//			}else{
//				schPrdParameterVO.getPrdMainInfoVO().setPod4(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPod4N(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPod4C(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol4(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol4N(null);
//				schPrdParameterVO.getPrdMainInfoVO().setPol4C(null);
//				schPrdParameterVO.getPrdMainInfoVO().setVvd4(null);
//				schPrdParameterVO.getPrdMainInfoVO().setLane4(null);					
//			}		
//			if(bkgBookingInfoVO.getBkgPorYdCd() == null || bkgBookingInfoVO.getBkgPorYdCd().length() == 0){
//				schPrdParameterVO.getPrdMainInfoVO().setPorN(null);
//			}
//			if(bkgBookingInfoVO.getBkgPolYdCd() == null || bkgBookingInfoVO.getBkgPolYdCd().length() == 0){
//				schPrdParameterVO.getPrdMainInfoVO().setPolN(null);				
//			}
//			if(bkgBookingInfoVO.getBkgPodYdCd() == null || bkgBookingInfoVO.getBkgPodYdCd().length() == 0){
//				schPrdParameterVO.getPrdMainInfoVO().setPodN(null);
//			}
//			if(bkgBookingInfoVO.getBkgDelYdCd() == null || bkgBookingInfoVO.getBkgDelYdCd().length() == 0){
//				schPrdParameterVO.getPrdMainInfoVO().setDelN(null);
//			}
//			if(bkgBookingInfoVO.getBkgTrunkVvd() == null || bkgBookingInfoVO.getBkgTrunkVvd().length() == 0){
//				schPrdParameterVO.getPrdMainInfoVO().setTVvd(null);
//			}
//			
//		}catch(EventException e){
//			log.error("err"+e.toString(),e);
//			throw e;
//		}catch(Exception ex){
//			log.error("err"+ex.toString(),ex);
//			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
//		}
//		return schPrdParameterVO;
//	}

	/**
	 * createBkgWithoutRoute(), createBkgWithRoute() <br>
	 * Booking creation<br>
	 * 
	 * @author 	
	 * @param 	BookingCreationVO bookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException
	 */
	private BookingCreationVO createBkgInfo(BookingCreationVO bookingCreationVO) throws EventException {
		try{
			begin();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC	searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationCMBC 	blDocBC 	= new BLDocumentationCMBCImpl();
			BookingMasterMgtBC 		masterBC 	= new BookingMasterMgtBCImpl();		
			BlRatingBC				rateBC		= new BlRatingBCImpl();
			BookingUtil 			util 		= new BookingUtil();		
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();	
			
			BkgCopManageBC 			copBc 		= new BkgCopManageBCImpl();
			WorkOrderIssueBC		trsBC		= new WorkOrderIssueBCImpl();
			 
			// 01. validateBookingSave
			log.debug("createBkgInfo : pctl_no : " + bookingCreationVO.getBkgBlNoVO().getPctlNo());
			
			bookingCreationVO = receiptBC.validateBookingSave(bookingCreationVO, account);
			
			//00.Legacy newVVD Check
			String tVvd = bookingCreationVO.getBkgBookingInfoVO().getBkgTrunkVvd();
			receiptBC.checkLegacySystemVVD(tVvd);
			
			
			// 20100204 Bkg Close 
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				return bookingCreationVO;
			}
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
				return bookingCreationVO;
			}
			
			BkgBlNoVO 		 bkgBlNoVO 		  = bookingCreationVO.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			
			String bkgNo = null;
			// 02. Booking Number creation
			if(!"Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
				BkgBlNoVO newBkgNoVO = util.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
				
				bkgNo = newBkgNoVO.getBkgNo()+"00";
				bkgBlNoVO.setBkgNo(bkgNo);
			} else {
				bkgNo = bkgBlNoVO.getBkgNo();
				// record  bkg creation
				List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVO = new ArrayList<BkgChnBkgNoGenVO>();
				bkgChnBkgNoGenVO.add(new BkgChnBkgNoGenVO());
				bkgChnBkgNoGenVO.get(0).setBkgNo(bkgNo);
				masterBC.modifyChnBkgNoUseFlgOnList(bkgChnBkgNoGenVO, bkgBookingInfoVO.getBkgPorCd(), account);
			}
			
			bkgBlNoVO.setBlNo(bkgNo);
			bkgBookingInfoVO.setBkgNo(bkgNo);
			//getting nwe BL no
			if(bkgNo.length()==11 && "Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){ 
				BkgBlNoVO newBkgNoVO = util.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
				bkgBookingInfoVO.setBlNo(newBkgNoVO.getBkgNo()+"00");
			} else {
				bkgBookingInfoVO.setBlNo(bkgNo);
			}
			
			BkgDocProcSkdVO toyotaBlDocProcSkdVO = null;
			/* 占쎈쐻占쎈윥筌앷엥�쐻占쎈윪占쎈�듸옙�쐻占쎈짗占쎌굲 Bl 占쎈쐻占쎈윪占쎄섈占쎈쐻占쎈윪�억옙 */
			if(bkgBlNoVO.getBkgTyFlg().equals("Y")){
				BkgBlNoVO toyotaBlNoVO = util.manageToyotaBlNumberGeneration("TYB", account.getOfc_cd(), account.getUsr_id());
				bkgBlNoVO.setBlNo(toyotaBlNoVO.getBlNo());
				bkgBookingInfoVO.setBlNo(toyotaBlNoVO.getBlNo());
				bkgBookingInfoVO.setIrrBlNoFlg("Y");
				
				toyotaBlDocProcSkdVO = new BkgDocProcSkdVO();
				toyotaBlDocProcSkdVO.setBkgNo(bkgNo);
				toyotaBlDocProcSkdVO.setCreUsrId(account.getUsr_id());
				toyotaBlDocProcSkdVO.setBkgDocProcTpCd("BLTOYO");
				toyotaBlDocProcSkdVO.setDiffRmk(toyotaBlNoVO.getBlNo());
			}
			
			bookingCreationVO.setBkgBlNoVO(bkgBlNoVO);
			bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);

			// 03. createBooking
			receiptBC.createBooking(bookingCreationVO, account);
			
			if(toyotaBlDocProcSkdVO != null){
				receiptBC.addBkgDocProcSkd(toyotaBlDocProcSkdVO);
			}
			
			// 04. createBkgBlDocByBKG
			bkgBookingInfoVO.setFnlDestNm("");		//FnlDestNm
			blDocBC.createBkgBlDocByBKG(bkgBlNoVO.getBkgNo(), 
										bookingCreationVO.getBookingSaveValidationVO().getBlMoveTpNm(),
										bkgBookingInfoVO,  account);

			// 05. 
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCaNewCreationFlag())){
				BLDocumentationBLBC 	blBC 	= new BLDocumentationBLBCImpl();
				blBC.modifyBKGBDR(bkgNo, "Y", account.getUsr_id());
				add1stCaHist(bkgBlNoVO);

				BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
				bkgCorrectionVO.setNewBkgCreFlg("Y");
				bkgCorrectionVO.setCaRsnCd   (bookingCreationVO.getBookingSaveValidationVO().getCaRsnCd());
				bkgCorrectionVO.setBkgCorrRmk(bookingCreationVO.getBookingSaveValidationVO().getCaRemark());
				
				BDRCorrectionBC bdrBC = new BDRCorrectionBCImpl();
				bdrBC.addAutoCaTemp(bkgBlNoVO, "CA_NEW", bkgCorrectionVO, account);

				BkgBlNoVO corrBkgBlNoVO = addCaHistory(bookingCreationVO.getBookingSaveValidationVO().getCaRsnCd(),
													   bookingCreationVO.getBookingSaveValidationVO().getCaRemark(), bkgBlNoVO, "N", "Y");
				bkgBlNoVO.setCaNo(corrBkgBlNoVO.getCaNo());
				
				bdrBC.removeCATemp(bkgBlNoVO);	
				// 05. createBkgHistoryLine
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(bkgNo);
				historyLineVO.setCorrNo(corrBkgBlNoVO.getCaNo());				
				historyLineVO.setBkgDocProcTpCd("BKGCRE");
				historyLineVO.setUiId("ESM_BKG_0079_01");
				historyLineVO.setCrntCtnt("Booking Created.");
				historyLineVO.setHisCateNm("Booking Creation"); 
				
				historyBC.createBkgHistoryLine(historyLineVO, account);
			} else {
				// 09. Booking Status changing
				receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
				
				// 05. createBkgHistoryLine
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(bkgNo);
				historyLineVO.setCaFlg("N");
				historyLineVO.setBkgDocProcTpCd("BKGCRE");
				historyLineVO.setUiId("ESM_BKG_0079_01");
				historyLineVO.setCrntCtnt("Booking Created.");
				historyLineVO.setHisCateNm("Booking Creation"); 
				
				historyBC.createBkgHistoryLine(historyLineVO, account);
			}
			
			//If sc or rfa is inputted
			if((bkgBookingInfoVO.getScNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getScNo().substring(0, 3)))
				||(bkgBookingInfoVO.getRfaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getRfaNo().substring(0, 3)))
				||(bkgBookingInfoVO.getTaaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getTaaNo().substring(0, 3)))){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgNo);
				bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);
			}
			
			// As init creation, cnee input
			if(!isNull(bookingCreationVO.getBlCustomerInfoVO().getCCustCntCd())&&!isNull(bookingCreationVO.getBlCustomerInfoVO().getCCustSeq())){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgNo);
				bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee no input for doc performance				
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);
			} 											
			
			rateBC.createRateForTro(bkgNo,"N", account);
			
			// 09. create Bkg(other module calling)
			log.debug("TO COP bkg no : " + bkgNo + ", pctl_no : " + bkgBlNoVO.getPctlNo());
			copBc.createBkg(bkgNo, bkgBlNoVO.getPctlNo());
			
			boolean toyota = false;
			BkgBookingInfoVO bookinginfoVo = bookingCreationVO.getBkgBookingInfoVO();
			BlCustomerInfoVO custVo = bookingCreationVO.getBlCustomerInfoVO();
			if(!bookinginfoVo.getBkgTyFlg().equals("Y") && bkgBlNoVO.getUsrToyotaCheck().equals("N")){
				String count = receiptBC.toyotaBlNoCheck(bookinginfoVo, custVo);
				if(!count.equals("0")){
					toyota = true;
					bookingCreationVO.setToyota(toyota);
					rollback();
				}
			}
			
			if(!toyota){
				// 10. interfaceCoa
				interfaceToCoa(bkgBlNoVO, "Booking Create", account);	
				commit();
				
				// cut off time (after cop creation, process)
				try{
					String fromDt = "";
					String toDt = "";
					
					if("US".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2)) || "CA".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))){
						BkgQuantityVO[] bkgQuantityVOs = bookingCreationVO.getBkgQuantityVOs();
						PrdQtyInfoVO[] prdQtyInfo 	= new PrdQtyInfoVO[bkgQuantityVOs.length];
						
						for(int i = 0 ; i < bkgQuantityVOs.length ; i++){	
							prdQtyInfo[i] = new PrdQtyInfoVO();				
							prdQtyInfo[i].setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
							prdQtyInfo[i].setCQty(bkgQuantityVOs[i].getOpCntrQty());				
						}

						ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();
						Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null);

						fromDt= (String)railTime.get("RTN_TIME");
						toDt  = (String)railTime.get("CUT_OFF");
						
					}
					begin(); //Transaction devision			
					receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);
					String[] railTime = splitRailReceiveDate(bkgBlNoVO);
					fromDt = railTime[0];
					toDt   = railTime[1];
					copBc.modifyRailRcvCoffDt(bkgBlNoVO.getBkgNo(), fromDt, toDt, account.getUsr_id());
					commit();			
				} catch(Exception prdEx){
					log.error("err rail time:"+prdEx.toString(),prdEx);
				}
				
				//interface to trs - Cargo Nature(CNCN)
				String dcgoFlg 		= bkgBookingInfoVO.getDcgoFlg().equals("") ? "N":bkgBookingInfoVO.getDcgoFlg();
				String dcgoFlgOld 	= bkgBookingInfoVO.getDcgoFlgOld().equals("") ? "N":bkgBookingInfoVO.getDcgoFlgOld();
				String rcFlg		= bkgBookingInfoVO.getRcFlg().equals("") ? "N":bkgBookingInfoVO.getRcFlg();
				String rcFlgOld		= bkgBookingInfoVO.getRcFlgOld().equals("") ? "N":bkgBookingInfoVO.getRcFlgOld();
				String awkCgoFlg	= bkgBookingInfoVO.getAwkCgoFlg().equals("") ? "N":bkgBookingInfoVO.getAwkCgoFlg();
				String awkCgoFlgOld	= bkgBookingInfoVO.getAwkCgoFlgOld().equals("") ? "N":bkgBookingInfoVO.getAwkCgoFlgOld();
				
				if(!dcgoFlg.equals(dcgoFlgOld) ||
						!rcFlg.equals(rcFlgOld) ||
						!awkCgoFlg.equals(awkCgoFlgOld)){
					
					log.debug("----DCGO------>[dcgo_flg]"+bkgBookingInfoVO.getDcgoFlg()+":[dcgo_flg_old]"+bkgBookingInfoVO.getDcgoFlgOld());
					log.debug("----RC-------->[rc_flg]"+bkgBookingInfoVO.getRcFlg()+":[rc_flg_old]"+bkgBookingInfoVO.getRcFlgOld());
					log.debug("----AWK------->[awk_cgo_flg]"+bkgBookingInfoVO.getAwkCgoFlg()+":[awk_cgo_flg_old]"+bkgBookingInfoVO.getAwkCgoFlgOld());
					
					begin();
					TrsChgMgmtBkgVO trsVO	= new TrsChgMgmtBkgVO();

					trsVO.setCateSepCd("CNCN");
					trsVO.setChageFlg("Y");
					trsVO.setBkNo(bkgBlNoVO.getBkgNo());
					trsVO.setBndCd("O");
					trsVO.setRtnPrdFlg("0");
					trsVO.setTroSeq("0");
					trsVO.setTroSubSeq("0");
					trsVO.setSpclSeq("0");
					trsVO.setVslSeq("0");
					trsVO.setDeltFlg("");
					trsVO.setUsrId(account.getUsr_id());
					trsVO.setUsrOffCd(account.getOfc_cd());
					
					log.debug(" ###### insertTrsChgMgmtBkgPrc ==>CNCN:"+bkgBlNoVO.getBkgNo());
					trsBC.insertTrsChgMgmtBkgPrc(trsVO);
					commit();
				}
				
				if(!"Y".equals(bkgBookingInfoVO.getEdiHldFlg())){
					// 07. sendBkgCustEdi
					searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);

					// 08. sendBkgTmlEdi

					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("N");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
//					searchBC.createTmlBkgReceiptEdiBackEnd(bkgBlNoVO, null, "N", "BT", "Y", account);				
					// 0.9 psa I/f auto sending add. 
					if("SGSIN".equals(bkgBookingInfoVO.getBkgPolCd())){
						bookingCreationVO.setPsaValCode(this.managePSABKGAuto(bkgBookingInfoVO.getBkgNo(), bookingCreationVO.getBookingSaveValidationVO().getQtyModifyFlag()));
					}
				}
			}
		}catch(EventException e){
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return bookingCreationVO;
	}

	/**
	 * ESM_BKG_0079_01 : save <br>
	 * If route has to be changed, Booking modifying process <br>
	 * 
	 * @author  
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithoutRoute(Event e) throws EventException {
		ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();
		BookingUtil            util  = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		try{
			// Container VO for Booking information 
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// VO for result of Validation
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());

			log.error("bkg_no:"+ bookingCreationVO.getBkgBookingInfoVO().getBkgNo());
			log.error("routeModifyFlag : "+ bookingSaveValidationVO.getRouteModifyFlag());
			log.debug("customerModifyFlag : "+ bookingSaveValidationVO.getCustomerModifyFlag());
			log.debug("contactModifyFlag : "+ bookingSaveValidationVO.getContactModifyFlag());
			log.debug("qtyModifyFlag : "+ bookingSaveValidationVO.getQtyModifyFlag());
			log.debug("$$$$$$$$$$$$ FlexHgtFlg" +bookingCreationVO.getBkgBookingInfoVO().getFlexHgtFlg());
			if("Y".equals(bookingCreationVO.getBkgBlNoVO().getCaFlg()) 
					&& bookingCreationVO.getVslSkdVOs() != null 
					&& bookingCreationVO.getVslSkdVOs().length>4){
				String oldPctlNo = "Over T/S";
				bookingCreationVO.getBkgBlNoVO().setPctlNo(oldPctlNo);
				bookingCreationVO.getBkgBookingInfoVO().setPctlNo(oldPctlNo);
				bookingCreationVO = modifyBkgInfo(bookingCreationVO);
			} else {
				begin();
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
					log.error("Pctl Pop Up Call : " + pc_ex.toString(), pc_ex);
					rollback();
					return eventResponse;
				}
				
				log.debug("Event Pctl No : " + pctlNo);			
				
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
				commit();
				bookingCreationVO = modifyBkgInfo(bookingCreationVO);
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
				eventResponse.setETCData("pre_checking", bookingCreationVO.getBookingSaveValidationVO().getPrecheckingFlag());	
				
				// In case of PSA sending,If there are some error, send
				eventResponse.setETCData("psaValCode", bookingCreationVO.getPsaValCode());
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_01 : save <br>
	 * There's no changing in route Booking Save process <br>
	 * 
	 * @author  
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil util = new BookingUtil();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		try{
			// Container VO for Booking information
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// VO for result of Validation
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			log.error("bkg_no:"+ event.getBkgBookingInfoVO().getBkgNo());
			log.error("routeModifyFlag : "+ bookingSaveValidationVO.getRouteModifyFlag());
			log.debug("customerModifyFlag : "+ bookingSaveValidationVO.getCustomerModifyFlag());
			log.debug("contactModifyFlag : "+ bookingSaveValidationVO.getContactModifyFlag());
			log.debug("qtyModifyFlag : "+ bookingSaveValidationVO.getQtyModifyFlag());
			log.error("pctl no :"+ event.getPctlNo());
			 
			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());

			log.debug("start pctlNoMapSeq!!!!");
			//pctlNo set
			String [] pctlNoMapSeq = util.splitByToken(event.getPctlNo(), "|");
			bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNoMapSeq[0]);
			bookingCreationVO.getBkgBlNoVO().setMapSeq(pctlNoMapSeq[1]);
			log.debug("end pctlNoMapSeq!!!!");

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
				eventResponse.setETCData("pre_checking", bookingCreationVO.getBookingSaveValidationVO().getPrecheckingFlag());
				
				// In case of PSA sending,If there are some error, send
				eventResponse.setETCData("psaValCode", bookingCreationVO.getPsaValCode());
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * modifyBkgWithoutRoute(), modifyBkgWithRoute() <br>
	 * 
	 * @author  
	 * @param 	BookingCreationVO bookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException 
	 */
	private BookingCreationVO modifyBkgInfo(BookingCreationVO bookingCreationVO) throws EventException {
		try{
			begin();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BlRatingBC				ratingBC	= new BlRatingBCImpl();
			BookingUtil				util		= new BookingUtil();
			WorkOrderIssueBC		trsBC		= new WorkOrderIssueBCImpl();
			SpecialCargoReceiptBC	spclReceiptBC = new SpecialCargoReceiptBCImpl();
			
			BkgCopManageBC 			copBC       = null;
						
			BkgBlNoVO        bkgBlNoVO        = bookingCreationVO.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			
			String lstSavDt = util.bkgBookingSaveCheck(bkgBookingInfoVO);
			if(lstSavDt != null){
				if(!lstSavDt.equals(bkgBookingInfoVO.getLstSavDt()))
					throw new EventException(new ErrorHandler("BKG95064").getMessage()); 
			}
			
			//00.Legacy oldVVD Check
//			String tVvdOld = bkgBookingInfoVO.getBkgTrunkVvdOld();
//			receiptBC.checkLegacySystemVVD(tVvdOld);

			// 01. validateBookingSave
			bookingCreationVO = receiptBC.validateBookingSave(bookingCreationVO, account);
			BookingSaveValidationVO bookingSaveValidationVO = bookingCreationVO.getBookingSaveValidationVO();
			
			// Auto COD
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				CODCorrectionBC codBC = new CODCorrectionBCImpl();
//				codBC.manageAutoCod(bkgBlNoVO, account, "BK");
				
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
			
			//00.Legacy newVVD Check
			String tVvd = bkgBookingInfoVO.getBkgTrunkVvd();
			receiptBC.checkLegacySystemVVD(tVvd);
						
			// 20100204 Bkg Close 
			if("Y".equals(bookingSaveValidationVO.getCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingSaveValidationVO.getCbfBkgFlag())){
				return bookingCreationVO;
			} else {
				bookingSaveValidationVO.setCloseBkgFlag("N");
				bookingSaveValidationVO.setCbfBkgFlag("N");
			}
			
			// 04. searchOldBkgInfo
			OldBkgInfoVO oldBkgInfoVO = new OldBkgInfoVO();

			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0079_01", bkgBlNoVO);
			
//			 2015.07.22 by kimtaekyun -- old VVD search
			List<BkgVvdVO> tempOldVvds = historyTableVO.getBkgVvdVOs();
			List<BkgVvdVO> oldVvds = new ArrayList<BkgVvdVO>();
			if(tempOldVvds != null){
				for(int i=0;i<tempOldVvds.size();i++){
					if("U".equals(tempOldVvds.get(i).getVslPrePstCd()))		continue;
					oldVvds.add(tempOldVvds.get(i));
				}
			}

			OfcChgProcVO ofcChgProcVO = new OfcChgProcVO();
			ofcChgProcVO.setType("M");  //bkg master
			ofcChgProcVO.setCaFlg(bkgBlNoVO.getCaFlg());
			ofcChgProcVO.setBkgNo(bkgBlNoVO.getBkgNo());
			ofcChgProcVO.setShCustCntCd(bookingCreationVO.getBlCustomerInfoVO().getSCustCntCd());
			ofcChgProcVO.setShCustSeq(bookingCreationVO.getBlCustomerInfoVO().getSCustSeq());
			ofcChgProcVO.setCnCustCntCd(bookingCreationVO.getBlCustomerInfoVO().getCCustCntCd());
			ofcChgProcVO.setCnCustSeq(bookingCreationVO.getBlCustomerInfoVO().getCCustSeq());
			ofcChgProcVO = (new BookingUtil()).searchOfcChgProc(ofcChgProcVO);

			oldBkgInfoVO.setFirstVvd(historyTableVO.getBkgVvdVOs().get(0).getVslCd()
					+historyTableVO.getBkgVvdVOs().get(0).getSkdVoyNo()
					+historyTableVO.getBkgVvdVOs().get(0).getSkdDirCd());
			bookingCreationVO.setOldBkgInfoVO(oldBkgInfoVO);
						
			// The comparison information is not changing history is not
			List<TableListVO> newTableListVOs = new ArrayList<TableListVO>();
			for(int i=0;i<historyTableVO.getTableListVOs().size();i++){
				if("BKG_CUSTOMER".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
					"N".equals(bookingSaveValidationVO.getCustomerModifyFlag())) continue;
				if("BKG_CNTC_PSON".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
					"N".equals(bookingSaveValidationVO.getContactModifyFlag()))  continue;
				if("BKG_VVD".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
					"N".equals(bookingSaveValidationVO.getRouteModifyFlag()))    continue;
				if("BKG_QUANTITY".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
					"N".equals(bookingSaveValidationVO.getQtyModifyFlag())) 	 continue;
				if("BKG_QTY_DTL".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
						"N".equals(bookingSaveValidationVO.getQtyModifyFlag())) 	 continue;
				newTableListVOs.add(historyTableVO.getTableListVOs().get(i));				
			}
			historyTableVO.setTableListVOs(newTableListVOs);

			String replanFlg = null;
			if(isNull(historyTableVO.getBkgBookingVO().getPctlNo())&&!isNull(bkgBlNoVO.getPctlNo())){
				replanFlg = "Y";
			} else if(historyTableVO.getBkgBookingVO().getPctlNo().equals((bkgBlNoVO.getPctlNo()))){
				replanFlg = "N";
			} else {
				replanFlg = "Y";
			}
			
            //keep VVD information for DG cancel about source BKG
			List<SearchDgCancelInfoVO> dgCancelInfoBefore = null;
			dgCancelInfoBefore = spclReceiptBC.searchDgCancelInfo(bkgBlNoVO.getBkgNo());
			
			//Keep previous VVD information
			String oldVvd = util.searchBkgVvd(bkgBlNoVO.getBkgNo());

			//Keep Port cut-off date and Cargo cut-off date before update
			List<SearchCutOffDateVO> cutOffDateVOs = receiptBC.searchCutOffDate(bkgBlNoVO.getBkgNo());
		
			// 05. modifyBooking
			bookingSaveValidationVO = receiptBC.modifyBooking(bookingCreationVO, account);
//			/* pctl no 동기화 */
//			receiptBC.bkgPctlNoSync(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getPctlNo(), bkgBlNoVO.getCaFlg());
			
			String bkgTyFlg = bookingCreationVO.getBkgBlNoVO().getBkgTyFlg() == ""? "N":bookingCreationVO.getBkgBlNoVO().getBkgTyFlg();
			if(!bkgTyFlg.equals(historyTableVO.getBkgBookingVO().getIrrBlNoFlg())){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bookingCreationVO.getBkgBookingInfoVO().getBkgNo());
				bkgDocProcSkdVO.setCreUsrId(account.getUsr_id());
				bkgDocProcSkdVO.setBkgDocProcTpCd("BLTOYO");
				bkgDocProcSkdVO.setDiffRmk(bookingCreationVO.getBkgBookingInfoVO().getBlNo());
				receiptBC.addBkgDocProcSkd(bkgDocProcSkdVO);
			}
			
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
			
			String vslUpdate = "Y"; //Flag to decide whether system update VSL_NM, PRE_VSL_NM of BKG_BL_DOC
			if(oldVvd.equals(util.searchBkgVvd(bkgBlNoVO.getBkgNo()))){ //If any VVD information is changed, update vessel name.
				vslUpdate="N";
			}
//			blDocCmBC.modifyBlActWgt(bkgBlNoVO, bkgBookingInfoVO.getActWgt(),  bkgBookingInfoVO.getWgtUtCd(), account);
			blDocCmBC.modifyBlActWgt(bkgBlNoVO, bkgBookingInfoVO.getActWgt(),  bkgBookingInfoVO.getWgtUtCd(), account, vslUpdate);

			// 06. modifyCntrRDTerm
			String oldRcvTermCd = historyTableVO.getBkgBookingVO().getRcvTermCd();
			String oldDeTermCd  = historyTableVO.getBkgBookingVO().getDeTermCd();
			String rcvTermCd    = bkgBookingInfoVO.getRcvTermCd();
			String deTermCd     = bkgBookingInfoVO.getDeTermCd();
			
			if(!oldRcvTermCd.equals(rcvTermCd) || !oldDeTermCd.equals(deTermCd)){
				BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();
				if(!"M".equals(rcvTermCd) || !"M".equals(deTermCd)){
					BkgContainerVO bkgContainerVO = new BkgContainerVO();
					bkgContainerVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgContainerVO.setRcvTermCd(rcvTermCd);
					bkgContainerVO.setDeTermCd(deTermCd);
					bkgContainerVO.setUpdUsrId(account.getUsr_id());

					blCmBC.modifyCntrRDTerm(bkgContainerVO, bkgBlNoVO);
					
					// modifySpclRDTerm add
					if("Y".equals(bookingCreationVO.getBkgBookingInfoVO().getAwkFlg())||"Y".equals(bookingCreationVO.getBkgBookingInfoVO().getBbFlg())){
	//					SpecialCargoReceiptBC spclReceiptBC = new SpecialCargoReceiptBCImpl();
						spclReceiptBC.modifySpclRDTerm(bkgBlNoVO, rcvTermCd, deTermCd, account);
					}
				}
				blCmBC.modifyMoveTypeByBkg(bkgBlNoVO.getBkgNo(), rcvTermCd, deTermCd, account.getUsr_id());
			}

			// CA 
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				// In case of spclCgoFlg = 'Y' and vvdchanging
//				if("Y".equals(bookingSaveValidationVO.getSpclCgoFlg()) && "Y".equals(bookingSaveValidationVO.getChangeVvd())){
				if("Y".equals(bookingSaveValidationVO.getSpclCgoFlg()) && ("Y".equals(bookingSaveValidationVO.getSpclCgoApproval()) || "Y".equals(bookingSaveValidationVO.getChangeLoc()) || "Y".equals(bookingSaveValidationVO.getChangeVvd())) ){
					// 07.Special Cargo Approval auto request
					//String spclRqstResult = reRequestSpclCgoApproval(bkgBlNoVO, "UPDATE", null);
					String dgOnlyFlg = "N";
					if((!"Y".equals(bookingSaveValidationVO.getSpclCgoApproval())) && ("Y".equals(bookingSaveValidationVO.getSpclCgoApproval()))){
						dgOnlyFlg = "Y";
					}
//					String spclRqstResult = reRequestSpclCgoApproval(bkgBlNoVO, "UPDATE", null, bookingSaveValidationVO.getChangeLoc());
					String spclRqstResult = reRequestSpclCgoApproval(bkgBlNoVO, "UPDATE", null, dgOnlyFlg);
					
					//call cancel DG if vvd change from trunk to feeder
					if(dgCancelInfoBefore.size()>0){
						//check DG again
						List<SearchDgCancelInfoVO> dgCancelInfoAfter = null;
						dgCancelInfoAfter = spclReceiptBC.searchDgCancelInfo(bkgBlNoVO.getBkgNo());
						if(dgCancelInfoAfter.size() < 1){
							//call spc module to tell DG cancel
							List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
							spclReceiptBC.manageDgDgCancel(dgCancelInfoBefore, account, scgVvdDgCgoCxlRqstVOs, "Change VVD to Common Feeder");
					        ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC = new ReceiveOwnBkgCancelRequestMgtBCImpl();
							bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
						}
					}

					if("pre-checking".equals(spclRqstResult)){
						bookingSaveValidationVO.setPrecheckingFlag("Y");
					} else {
						bookingSaveValidationVO.setPrecheckingFlag("N");						
					}
				}

				// 09. Booking Status changing
				receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
				
				// changing advance bkg to bkg, cntr rate deivision
				if("A".equals(historyTableVO.getBkgBookingVO().getBkgStsCd())){
					if("F".equals(util.searchBkgStatusByBkg(bkgBlNoVO))){
						ratingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);
					}
				}
				
				if("Y".equals(bookingSaveValidationVO.getTroCfrmFlg())){
					TransferOrderIssueBC 	troBC = new TransferOrderIssueBCImpl();
					if(!"E".equals(bkgBookingInfoVO.getOrgScontiCd().substring(0, 1))){
						// 14. If porScontiCd <> 'E' , unconfirmTro
						troBC.unconfirmTro(bkgBlNoVO, account);
					} else {
					    // 15. If porScontiCd = 'E' , unconfirmEurTro
						troBC.unconfirmEurTro(bkgBlNoVO,  "O", account);
					}
					copBC = new BkgCopManageBCImpl();	
					copBC.unconfirmTro(bkgBlNoVO.getBkgNo(), "O");
					bookingSaveValidationVO.setSaveMsg(bookingSaveValidationVO.getSaveMsg() + ",BKG00088");
				}
			}			
			
			// prepaid, collect payer changing
			if("Y".equals(bookingSaveValidationVO.getCustomerModifyFlag())) {
					ratingBC.modifyRateCntCd(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());
			}
			
			// If por_cd, del_cd are different  prepaid, collect payer changing modifying 
			String oldPorCd  = historyTableVO.getBkgBookingVO().getPorCd();
			String oldDelCd  = historyTableVO.getBkgBookingVO().getDelCd();
			String bkgPorCd  = bkgBookingInfoVO.getBkgPorCd();
			String bkgDelCd  = bkgBookingInfoVO.getBkgDelCd();
			if("Y".equals(bookingSaveValidationVO.getRouteModifyFlag()) && ( !oldPorCd.equals(bkgPorCd) || !oldDelCd.equals(bkgDelCd) ) ){
				ratingBC.createRateForTro(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg(), account);
			}
			String ctrtTpCd = "X";
			if(bkgBookingInfoVO.getScNo().length()>0){
				ctrtTpCd = "S";
			}
			if(bkgBookingInfoVO.getRfaNo().length()>0){
				ctrtTpCd = "R";
			}
			if(bkgBookingInfoVO.getTaaNo().length()>0){
				ctrtTpCd = "T";
			}
			ratingBC.modifyCtrtTpCd(bkgBlNoVO.getBkgNo(), ctrtTpCd, account, bkgBlNoVO.getCaFlg());
			
			if ("Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgPpdProc()) || "Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgCctProc())) {
				BkgModiOfcPrcVO bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
				bkgModiOfcPrcVO.setInBkgNo(bkgBlNoVO.getBkgNo());
				bkgModiOfcPrcVO.setInCaFlg(bkgBlNoVO.getCaFlg());
				bkgModiOfcPrcVO.setInPpdFlg(ofcChgProcVO.getOfcChgPpdProc());
				bkgModiOfcPrcVO.setInCctFlg(ofcChgProcVO.getOfcChgCctProc());
				(new BlRatingBCImpl()).callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
			}
			
			historyBC.manageBookingHistory("ESM_BKG_0079_01", historyTableVO, account);



			//If it is not c/a
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				// sc does not exist or if there was a dummy 
				if((isNull(bkgBookingInfoVO.getScNoOld()) ||(!isNull(bkgBookingInfoVO.getScNoOld()) &&"DUM".equals(bkgBookingInfoVO.getScNoOld().substring(0,3))))||
					//Rfa already exist or if there was a dummy
				   (isNull(bkgBookingInfoVO.getRfaNoOld())||(!isNull(bkgBookingInfoVO.getRfaNoOld())&&"DUM".equals(bkgBookingInfoVO.getRfaNoOld().substring(0,3))))){
					//If available, enter a new contract
					if((bkgBookingInfoVO.getScNo().length() >0 &&!"DUM".equals(bkgBookingInfoVO.getScNo().substring(0, 3)))
					 ||(bkgBookingInfoVO.getRfaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getRfaNo().substring(0, 3)))
					 ||(bkgBookingInfoVO.getTaaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getTaaNo().substring(0, 3)))){
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
						bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
						historyBC.manageDocProcess(bkgDocProcSkdVO, account);
					}
				}
				// If customer code are changed 
				if("Y".equals(bookingSaveValidationVO.getCustomerModifyFlag())){
					BlCustomerInfoVO custInfoVO = bookingCreationVO.getBlCustomerInfoVO();
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
				
				//c / a If you change the volume while not for report performance
				if("Y".equals(bookingSaveValidationVO.getQtyModifyFlag())){
					PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
					performReportBc.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CQ");	
				}

				// 19. coa interface 
				interfaceToCoa(bkgBlNoVO, "Booking Update", account);	
				//If you change your route or volumne
				if("Y".equals(replanFlg)){
					copBC = new BkgCopManageBCImpl();		
					// 18. updateBkg( module calling)				
					copBC.updateBkg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getMapSeq());
									
					commit();
					try{
						// cut off time (after cop creation  process)
						String fromDt = "";
						String toDt   = "";
						
						if("US".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))||"CA".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))){
							ProductCatalogCreateBC prdBC   = new ProductCatalogCreateBCImpl();
							BkgQuantityVO[] bkgQuantityVOs = bookingCreationVO.getBkgQuantityVOs();
							PrdQtyInfoVO[]  prdQtyInfo 	   = new PrdQtyInfoVO[bkgQuantityVOs.length];
							
							for(int i = 0 ; i < bkgQuantityVOs.length ; i++){	
								prdQtyInfo[i] = new PrdQtyInfoVO();				
								prdQtyInfo[i].setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
								prdQtyInfo[i].setCQty(bkgQuantityVOs[i].getOpCntrQty());				
							}
							
							Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null);
							
							fromDt= (String)railTime.get("RTN_TIME");
							toDt  = (String)railTime.get("CUT_OFF");
						}
						
						HistoryTableVO clzTmHistVO = historyBC.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVO);
						
						begin(); // Transaction devision for accessing batch
						receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);
						String[] railTime = splitRailReceiveDate(bkgBlNoVO);
						fromDt = railTime[0];
						toDt   = railTime[1];
//						copBC.modifyRailRcvCoffDt(bkgBlNoVO.getBkgNo(), fromDt, toDt, account.getUsr_id());						
						historyBC.manageBookingHistory("ESM_BKG_0721", clzTmHistVO, account);
						
						commit();		
					} catch(Exception prdEx){
						rollback();
						log.error("err rail time:"+prdEx.toString(),prdEx);
					}		
				} else {		
					//If you do not change route or volumne two
					commit();
				}

				//Before you commit should be On backEndJop
				// 17. interfaceBKGARInvoiceToINV
				interfaceToInv(bkgBlNoVO, account);
				
				//2015.07.22 by kimtaekyun oldVvd , newVvd -> compare
				begin();
				
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
//							TrsChgMgmtBkgVO trsVO	= new TrsChgMgmtBkgVO();
//							
//							trsVO.setCateSepCd(cateSepCd);
//							trsVO.setChageFlg("Y");
//							trsVO.setBkNo(bkgBlNoVO.getBkgNo());
//							trsVO.setBndCd("O");
//							trsVO.setRtnPrdFlg(oldVvds.get(i).getVslPrePstCd());
//							trsVO.setTroSeq("0");
//							trsVO.setTroSubSeq("0");
//							trsVO.setSpclSeq("0");
//							trsVO.setVslSeq(oldVvds.get(i).getVslSeq());
//							trsVO.setDeltFlg("");
//							trsVO.setUsrId(account.getUsr_id());
//							trsVO.setUsrOffCd(account.getOfc_cd());
//							
//							log.debug(" ###### insertTrsChgMgmtBkgPrc ==>:"+cateSepCd+":"+bkgBlNoVO.getBkgNo()+":"+oldVvds.get(i).getVslSeq());
//							trsBC.insertTrsChgMgmtBkgPrc(trsVO);
							
						}
					}
				}
				
				if(cutOffDateVOs != null){
					String troCategoryCd = "";
					for(int i = 0; i<cutOffDateVOs.size();i++){
						//Check whether cut-off date is updated or not
						troCategoryCd = receiptBC.searchCutOffDateChange(cutOffDateVOs.get(i));
						if(!"".equals(troCategoryCd)){
							// Call TRO module to notice the change of Cut-Off date
							util.interfaceToTrs(troCategoryCd, bkgBlNoVO.getBkgNo(), "",  "0", "0", "", account, "", "" );
						}
					}
				}
				
				commit();
				
				//2016.03.30 by kimtaekyun oldVvd , newVvd -> compare BKG_INV_TAX_IF INSERT
				List<HistCtntVO> histCtntList = historyBC.searchChangeVVDHistory(historyTableVO);
				if(histCtntList != null && histCtntList.size()>0){
					begin();
					String remark = new StringBuffer("BKG|VVD:VVD Changed/UID[").append("ESM_BKG_0079_01").append("]").toString();
					BkgChgRateVO bkgChgRateVO = new BkgChgRateVO();
					bkgChgRateVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgChgRateVO.setIfRmk(remark);
					receiptBC.addBkgInvTaxIF(bkgChgRateVO, account);
					commit();				
				}
				
				//interface to trs - Cargo Nature(CNCN)
				String dcgoFlg 		= bkgBookingInfoVO.getDcgoFlg().equals("") ? "N":bkgBookingInfoVO.getDcgoFlg();
				String dcgoFlgOld 	= bkgBookingInfoVO.getDcgoFlgOld().equals("") ? "N":bkgBookingInfoVO.getDcgoFlgOld();
				String rcFlg		= bkgBookingInfoVO.getRcFlg().equals("") ? "N":bkgBookingInfoVO.getRcFlg();
				String rcFlgOld		= bkgBookingInfoVO.getRcFlgOld().equals("") ? "N":bkgBookingInfoVO.getRcFlgOld();
				String awkCgoFlg	= bkgBookingInfoVO.getAwkCgoFlg().equals("") ? "N":bkgBookingInfoVO.getAwkCgoFlg();
				String awkCgoFlgOld	= bkgBookingInfoVO.getAwkCgoFlgOld().equals("") ? "N":bkgBookingInfoVO.getAwkCgoFlgOld();
				
				if(!dcgoFlg.equals(dcgoFlgOld) ||
						!rcFlg.equals(rcFlgOld) ||
						!awkCgoFlg.equals(awkCgoFlgOld)){
				
//				if((bkgBookingInfoVO.getDcgoFlg() != bkgBookingInfoVO.getDcgoFlgOld()) ||
//						(bkgBookingInfoVO.getRcFlg() != bkgBookingInfoVO.getRcFlgOld()) ||
//						(bkgBookingInfoVO.getAwkCgoFlg() != bkgBookingInfoVO.getAwkCgoFlgOld())){
					
					log.debug("----DCGO------>[dcgo_flg]"+bkgBookingInfoVO.getDcgoFlg()+":[dcgo_flg_old]"+bkgBookingInfoVO.getDcgoFlgOld());
					log.debug("----RC-------->[rc_flg]"+bkgBookingInfoVO.getRcFlg()+":[rc_flg_old]"+bkgBookingInfoVO.getRcFlgOld());
					log.debug("----AWK------->[awk_cgo_flg]"+bkgBookingInfoVO.getAwkCgoFlg()+":[awk_cgo_flg_old]"+bkgBookingInfoVO.getAwkCgoFlgOld());
					
					begin();
					TrsChgMgmtBkgVO trsVO	= new TrsChgMgmtBkgVO();

					trsVO.setCateSepCd("CNCN");
					trsVO.setChageFlg("Y");
					trsVO.setBkNo(bkgBlNoVO.getBkgNo());
					trsVO.setBndCd("O");
					trsVO.setRtnPrdFlg("0");
					trsVO.setTroSeq("0");
					trsVO.setTroSubSeq("0");
					trsVO.setSpclSeq("0");
					trsVO.setVslSeq("0");
					trsVO.setDeltFlg("");
					trsVO.setUsrId(account.getUsr_id());
					trsVO.setUsrOffCd(account.getOfc_cd());
					
					log.debug(" ###### insertTrsChgMgmtBkgPrc ==>CNCN:"+bkgBlNoVO.getBkgNo());
					trsBC.insertTrsChgMgmtBkgPrc(trsVO);
					commit();
				}
				
				if(!"Y".equals(bkgBookingInfoVO.getEdiHldFlg())){			
					// 12. sendBkgCustEdi
					searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);
					
					// 13. sendBkgTmlEdi
					String brac = "X";
					brac = "Y".equals(bookingSaveValidationVO.getChangeVvd())?"B":"U";
					if(!"X".equals(brac)){
						Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
						if("B".equals(brac)){
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(historyTableVO.getBkgVvdVOs());
							vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
							vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
							vender301ParamVO.setBracCd(brac);
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							vender301ParamVO.setPolNodCd(historyTableVO.getBkgBookingVO().getPolNodCd());
						} else {
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
							vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
							vender301ParamVO.setBracCd(brac);
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
						}
						searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
					}

					if("SGSIN".equals(bkgBookingInfoVO.getBkgPolCd())){	
						String psaAuto = "N";
						if ( "Y".equals(bookingCreationVO.getBookingSaveValidationVO().getQtyModifyFlag())){
							psaAuto = "Y";
						} else {
							// Mty Pkup YD CD to retrieve the value when changing the PSA should be sending to the newly created.
							List<BkgBookingVO> bkgBookingVOs = util.searchBookingSplitNo(bkgBlNoVO.getBkgNo());
							if ( !bkgBookingVOs.get(0).getMtyPkupYdCd().equals(historyTableVO.getBkgBookingVO().getMtyPkupYdCd())){
								psaAuto = "Y";
							}
						}
						bookingCreationVO.setPsaValCode(this.managePSABKGAuto(bkgBookingInfoVO.getBkgNo(), psaAuto));
					}
				}
			} else {
				//c / a is in progress if
				commit();
			}
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
		}catch(EventException e){			
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
		return bookingCreationVO;
	}
	/**
	 * ESM_BKG_0099 : retrieve <br>  
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgForSplit(Event e) throws EventException{
		try{
			EsmBkg0099Event event = (EsmBkg0099Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			BookingUtil util = new BookingUtil();
			
			BkgForSplitVO bkgForSplitVO = new BkgForSplitVO();
			bkgForSplitVO = command.searchBkgForSplit (event.getBkgBlNoVO(),account);
			
			List<BkgBlForSplitVO> splitVOs = bkgForSplitVO.getBkgBlForSplitVO();
			
			eventResponse.setETCData("bkg_no",			(splitVOs.size()>0)? splitVOs.get(0).getBkgNo():"");
			eventResponse.setETCData("bl_no",			(splitVOs.size()>0)? splitVOs.get(0).getBlNo():"");
			eventResponse.setETCData("tvvd",			(splitVOs.size()>0)? splitVOs.get(0).getTvvd():"");
			eventResponse.setETCData("por_cd",			(splitVOs.size()>0)? splitVOs.get(0).getPorCd():"");
			eventResponse.setETCData("pol_cd",			(splitVOs.size()>0)? splitVOs.get(0).getPolCd():"");
			eventResponse.setETCData("pod_cd",			(splitVOs.size()>0)? splitVOs.get(0).getPodCd():"");
			eventResponse.setETCData("del_cd",			(splitVOs.size()>0)? splitVOs.get(0).getDelCd():"");
			eventResponse.setETCData("stwg_cd",			(splitVOs.size()>0)? splitVOs.get(0).getStwgCd():"");
			eventResponse.setETCData("rail_blk_cd",		(splitVOs.size()>0)? splitVOs.get(0).getRailBlkCd():"");
			eventResponse.setETCData("fd_grd_flg",		(splitVOs.size()>0)? splitVOs.get(0).getFdGrdFlg():"");
			eventResponse.setETCData("hngr_flg",		(splitVOs.size()>0)? splitVOs.get(0).getHngrFlg():"");
			eventResponse.setETCData("hot_de_flg",		(splitVOs.size()>0)? splitVOs.get(0).getHotDeFlg():"");
			eventResponse.setETCData("prct_flg",		(splitVOs.size()>0)? splitVOs.get(0).getPrctFlg():"");
			eventResponse.setETCData("stop_off_loc_cd",	(splitVOs.size()>0)? splitVOs.get(0).getStopOffLocCd():"");
			eventResponse.setETCData("spcl_hide_flg",	(splitVOs.size()>0)? splitVOs.get(0).getSpclHideFlg():"");
			eventResponse.setETCData("remark",			(splitVOs.size()>0)? splitVOs.get(0).getRemark():"");
			eventResponse.setETCData("dg",				(splitVOs.size()>0)? splitVOs.get(0).getDg():"");
			eventResponse.setETCData("rf",				(splitVOs.size()>0)? splitVOs.get(0).getRf():"");
			eventResponse.setETCData("ak",				(splitVOs.size()>0)? splitVOs.get(0).getAk():"");
			eventResponse.setETCData("bb",				(splitVOs.size()>0)? splitVOs.get(0).getBb():"");
			eventResponse.setETCData("pctl_no",			(splitVOs.size()>0)? splitVOs.get(0).getPctlNo():"");
			eventResponse.setETCData("bdr_flag",		(splitVOs.size()>0)? splitVOs.get(0).getBdrFlg():"");
			eventResponse.setETCData("tro_flg",			(splitVOs.size()>0)? splitVOs.get(0).getTroFlg():"");
			eventResponse.setETCData("splitFlg",		(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getSplitFlg()):"");
			eventResponse.setETCData("bkgStsCd",		(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getBkgStsCd()):"");
			eventResponse.setETCData("troTp",			(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getTroTp()):"");
			eventResponse.setETCData("bkg_close_flg",	(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getBkgClose()):"");
			eventResponse.setETCData("obl_iss_flg",		(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getOblIssFlg()):"");
			
			eventResponse.setETCData("custSplitNo",		(bkgForSplitVO.getLastSplitNoVO().size()>0)? bkgForSplitVO.getLastSplitNoVO().get(0).getCustsplitno():"");
			eventResponse.setETCData("memoSplitNo",		(bkgForSplitVO.getLastSplitNoVO().size()>0)? bkgForSplitVO.getLastSplitNoVO().get(0).getMemosplitno():"");
			eventResponse.setETCData("bkgsplitno",		(bkgForSplitVO.getLastSplitNoVO().size()>0)? JSPUtil.getNull(bkgForSplitVO.getLastSplitNoVO().get(0).getBkgsplitno()):"");
			
			eventResponse.setETCData("bkg_wt_chk_flg",			(splitVOs.size()>0)? splitVOs.get(0).getBkgWtChkFlg():"");
			eventResponse.setETCData("edi_hld_flg",			(splitVOs.size()>0)? splitVOs.get(0).getEdiHldFlg():"");
			
			eventResponse.setRsVoList(bkgForSplitVO.getBkgBlForSplitVO());
			eventResponse.setRsVoList(bkgForSplitVO.getBkgQuantityVO());
			eventResponse.setRsVoList(bkgForSplitVO.getCntrSpclTroSelectVO());
			eventResponse.setRsVoList(bkgForSplitVO.getSpclSeqForSplitVO());
	
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("MULTI_SPLIT");			
			List<BkgHrdCdgCtntVO> multiSplit = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			String multiSplitFlg = "";
			if(multiSplit.size() > 0){
				multiSplitFlg = multiSplit.get(0).getAttrCtnt1();
			}
			
			eventResponse.setETCData("multiSplitFlg", multiSplitFlg);
			
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
	 * ESM_BKG_0079_02C : cntr_no change <br>
	 * 
	 * @author 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCntrWgt(Event e) throws EventException{
		try{
			EsmBkg007902cEvent   event = (EsmBkg007902cEvent)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			TransferOrderIssueBC command = new TransferOrderIssueBCImpl();			
			BookingUtil          util    = new BookingUtil();
			
			//01. cgo_wgt retrieve 
			String strCgoWgt = command.searchBkgCntrWgt(event.getBkgBlNoVO().getBkgNo(), event.getCntrNo());	
			strCgoWgt = JSPUtil.getNullNoTrim(strCgoWgt);
			//if ("".equals(strCgoWgt)) {
				//eventResponse.setUserMessage(new ErrorHandler("BKG00379").getUserMessage()); //process 
			//}
			eventResponse.setETCData("cgo_wgt", strCgoWgt);
			
			//02. tpsz retrieve 
        	String cntrTpszCd = "";
            List<MstContainerVO> list = util.searchTypeSizeByCntr(event.getCntrNo()); 
    		if(list.size() > 0){
    			cntrTpszCd = JSPUtil.getNullNoTrim(list.get(0).getCntrTpszCd());
    		}
			eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);
			
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0079_02A, ESM_BKG_0079_02B : confirm check <br>
	 * system Date retrieve <br>
	 * 
	 * @author  
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSysDate(Event e) throws EventException{
		try {   
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil command = new BookingUtil();
			
			String sSysdate = command.searchTimeLocalOfcFnc(account.getOfc_cd());   //Ofc_cd of the logged in user
			sSysdate = sSysdate.substring(0, 16);
			eventResponse.setETCData("cfm_sys_date", sSysdate);
			
			return eventResponse;
		} catch(EventException se) {
			throw se;
		} catch(Exception ex) { 
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0099, ESM_BKG_0079_01, ESM_BKG_0079_02A, ESM_BKG_0079_02B, ESM_BKG_0079_02C : btn_bkg_split <br>
	 * Booking Split No List retrieve <br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgSplitNo(Event e) throws EventException{
		try{
			String bkgNo="";
			if (e.getEventName().equalsIgnoreCase("EsmBkg0099Event")) {
				EsmBkg0099Event event = (EsmBkg0099Event)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007901Event")) {
				EsmBkg007901Event event = (EsmBkg007901Event)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007902aEvent")) {
				EsmBkg007902aEvent event = (EsmBkg007902aEvent)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007902bEvent")) {
				EsmBkg007902bEvent event = (EsmBkg007902bEvent)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007902cEvent")) {
				EsmBkg007902cEvent event = (EsmBkg007902cEvent)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			}
			BookingUtil command = new BookingUtil();
			String sBkgSplitNo = command.searchBkgSplitNoByOptional(bkgNo,"");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("bkg_split_no_list",sBkgSplitNo);
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
	 * ESM_BKG_0079_01 : waiting, firm click <br>
	 * Wating->Firm,Firm->Waiting process. <br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse changeBkgStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BookingUtil util = new BookingUtil();
		try{
			begin();
			// 01. Change Booking Status
			receiptBC.changeBkgStatus(event.getNewStsCd(), event.getBkgBlNoVO(), true, account);

			// 02. BookingHistoryMgtBC createBkgHistoryLine calling	
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setUiId("ESM_BKG_0079_01");			
			historyLineVO.setHisCateNm("Booking Status");
			historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			historyLineVO.setCaFlg(event.getBkgBlNoVO().getCaFlg());
			if ("P".equals(event.getNewStsCd())){
				historyLineVO.setBkgDocProcTpCd("BKGWAI");// booking wait for doc performance
				historyLineVO.setCrntCtnt("Status change F to W");
			} else {
				historyLineVO.setBkgDocProcTpCd("BKGFRM");// booking firm for doc performance
				historyLineVO.setCrntCtnt("Status change W to F");
			}
			
			historyBC.createBkgHistoryLine(historyLineVO, account);

			// 03. interfaceCoa
			interfaceToCoa(event.getBkgBlNoVO(), "Booking Status Change", account);

			commit();
			
			begin();
			// 04. interfaceBkgARInvoiceToINV 
			interfaceToInv(event.getBkgBlNoVO(), account);	
			commit();
			
			if(event.getBkgBlNoVO().getBkgWtChkFlg().equals("Y") && event.getBkgBlNoVO().getEdiHldFlg().equals("Y")){
				begin();
				util.executeBkgReceiptEdi(eventResponse, account, event.getBkgBlNoVO().getBkgNo(), event.getBkgBlNoVO().getQtyModifyFlag(), event.getBkgBlNoVO().getHisUiNm());
				commit();
			}
			
			/* e-booking 占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�렰占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄틣�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩留� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥�룏占쎌굲�뜝�럩留놂옙�쎗�뜝�띁伊덌옙援ε퐲�옚�삕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럥�맚�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쐾�뜝�럡�떍�뜝�럥�맶�뜝�럥�쑅�뜝�럥堉볟뜝�럥�맶�뜝�럥�쑅�뜝�럥�젴�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�몱占쎌맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� */
//			if(event.getNewStsCd() != null && event.getNewStsCd().equalsIgnoreCase("F")){
//				begin();
//				util.internetBookingRequestAcceptedEmail(event.getBkgBlNoVO().getBkgNo(), account);
//				commit();
//			}
			
			eventResponse.setETCData("isSuccess","Y");
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
	 * ESM_BKG_0079_01 : cancel click <br>
	 * As Booking Cancel, process.<br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelBooking(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		BLDocumentationCMBC blDocCmBC = new BLDocumentationCMBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		BkgCopManageBC copBC = new BkgCopManageBCImpl();
		BookingUtil util = new BookingUtil();
		OwnContainerBookingForecastMgtBC owncontainer = new OwnContainerBookingForecastMgtBCImpl();
		SpecialCargoReceiptBC 	spclCgoReceiptBC= new SpecialCargoReceiptBCImpl();
		ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC = new ReceiveOwnBkgCancelRequestMgtBCImpl();
		
		try{
			begin();
			
			// 20100205 Booking Close logic add
			String closeBkgMsg = "";
			String closeVvd = "";
			boolean isCloseMail = false;
			boolean isCbfMail = false;
			BkgCloseVO bkgCloseVO = null;
			if(!"Y".equals(event.getBkgBlNoVO().getCaFlg())){
				if(!"Y".equals(event.getBookingSaveValidationVO().getCloseBkgFlag())){
					bkgCloseVO = util.searchBkgClose(event.getBkgBlNoVO(), account.getOfc_cd());
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
				if(!"Y".equals(event.getBookingSaveValidationVO().getCbfBkgFlag()) && bkgCloseVO == null){

					boolean isCbfFinal = false;
					bkgCloseVO = util.searchBkgCbf(event.getBkgBlNoVO());
					if(bkgCloseVO != null && bkgCloseVO.getPreVvd() != null && !bkgCloseVO.getPreVvd().trim().equals("")){
						String[] arrCBF  = owncontainer.searchCBFBS(bkgCloseVO.getPreVvd().substring(0, 4), bkgCloseVO.getPreVvd().substring(4, 8), bkgCloseVO.getPreVvd().substring(8, 9), bkgCloseVO.getPreYdCdSeq());
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
				// 01. Cancel Booking
				receiptBC.cancelBooking(event.getBkgBlNoVO(), account);

				if(!"Y".equals(event.getBkgBlNoVO().getCaFlg())){
					//keep VVD information for DG cancel about source BKG
					List<SearchDgCancelInfoVO> dgCancelInfo = null;
					dgCancelInfo = spclCgoReceiptBC.searchDgCancelInfo(event.getBkgBlNoVO().getBkgNo());
					//DG cancel
					if(dgCancelInfo != null && dgCancelInfo.size() > 0){
						List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
						scgVvdDgCgoCxlRqstVOs = spclCgoReceiptBC.manageDgBkgCancel(event.getBkgBlNoVO().getBkgNo(), account, scgVvdDgCgoCxlRqstVOs, "Booking Canceled");
						bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
					}
				}

				// 02. Cancel Container
				blDocCmBC.cancelBkgCntr(event.getBkgBlNoVO(), account);

				// 03. BookingHistoryMgtBC createBkgHistoryLine calling
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				historyLineVO.setCaFlg(event.getBkgBlNoVO().getCaFlg());
				historyLineVO.setCorrNo(event.getBkgBlNoVO().getCaNo());
				historyLineVO.setBkgDocProcTpCd("BKGCAN");//booking cancel for doc performance
				historyLineVO.setUiId("ESM_BKG_0079_01");
				historyLineVO.setCrntCtnt("Booking Canceled.");
				historyLineVO.setHisCateNm("Booking Cancel."); 
				
				if(event.getBkgBlNoVO().getMessage() != null){
					historyBC.createBkgHistoryLine(historyLineVO, "Cancel Reason", event.getBkgBlNoVO().getMessage(), account);
				}else{
					historyBC.createBkgHistoryLine(historyLineVO, account);
				}
				
				if(!"Y".equals(event.getBkgBlNoVO().getCaFlg())){
					copBC.cancelBkg(event.getBkgBlNoVO().getBkgNo());
					
					// 04. interfaceCoa
					interfaceToCoa(event.getBkgBlNoVO(), "Booking Cancel", account);

					commit();
					// 05. interfaceBkgARInvoiceToINV
					interfaceToInv(event.getBkgBlNoVO(), account);				
	
					// 07. sendBkgCustEdi
					searchBC.createCustBkgReceiptEdiBackEnd(event.getBkgBlNoVO(), null, "Y", account);
	
					// 08. sendBkgTmlEdi
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(event.getBkgBlNoVO());
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("R");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
					this.managePSABKGAuto(event.getBkgBlNoVO().getBkgNo(), "N");
				} else {
					commit();
				}
				eventResponse.setETCData("closeBkgFlag", "N");
				eventResponse.setETCData("cbfBkgFlag", "N");
			}

			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			if(bkgBlNoVO.getXterBkgRqstCd().equals("WEB") && bkgBlNoVO.getBkgCntcPsonEml() != null && !bkgBlNoVO.getBkgCntcPsonEml().equals("")){
				String subject = "Internet Booking Cancellation Request of Booking Accepted - <" + bkgBlNoVO.getXterBkgRqstRefNo() + ">";
				MdmOrganizationVO mdmOrganizationVO = util.searchMdmOrganization(bkgBlNoVO.getBkgOfcCd());
				Map<String, String> args = new HashMap<String, String>();
				args.put("BkgNo", bkgBlNoVO.getBkgNo());
				args.put("XterRmk", bkgBlNoVO.getXterRmk());
				args.put("BkgOfcCd", mdmOrganizationVO.getOfcEngNm());
				args.put("BkgOfcCdEml", mdmOrganizationVO.getOfcRepEml());
				args.put("Comment", "");
				args.put("RequestNo", bkgBlNoVO.getXterBkgRqstRefNo());
				
				log.debug("BkgNo : " + bkgBlNoVO.getBkgNo());
				log.debug("XterRmk : " + bkgBlNoVO.getXterRmk());
				log.debug("BkgOfcCd : " + mdmOrganizationVO.getOfcEngNm());
				log.debug("BkgOfcCdEml : " + mdmOrganizationVO.getOfcRepEml());
				log.debug("Comment : " + "");
				log.debug("RequestNo : " + bkgBlNoVO.getXterBkgRqstRefNo());
				log.debug("CntcPsonEml : " + bkgBlNoVO.getBkgCntcPsonEml());
				
				util.bkgSendMail(account, bkgBlNoVO.getBkgCntcPsonEml(), subject, "ESM_BKG_0079_01_C", args, null);
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
	 * ESM_BKG_0099 : split click <br>
	 * Booking Split process <br>
	 *  
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse splitBooking(Event e) throws EventException{		
		try{
			EsmBkg0099Event 				event 			= (EsmBkg0099Event)e;
			GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();			
			GeneralBookingSplitCombineBC 	command 		= new GeneralBookingSplitCombineBCImpl();
			
			//Bkg data reflection
			GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBlBC 	= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BlRatingBC 				blRatingBC 	= new BlRatingBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BDRCorrectionBC         bdrBC       = new BDRCorrectionBCImpl();
			PerformanceReportBC 	reportBC	= new PerformanceReportBCImpl();
			BookingUtil             util        = new BookingUtil();
			
			BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
        	ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();
        	
        	TransferOrderIssueBC	troBC		= new TransferOrderIssueBCImpl();
			SpecialCargoReceiptBC 	spclCgoBC 	= new SpecialCargoReceiptBCImpl();
			ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC = new ReceiveOwnBkgCancelRequestMgtBCImpl();
			
			//orgin bkg
			BkgBlNoVO sourceBkg = event.getSourceBkg();
			
			// for splitprocess 
			SplitBkgVO 				splitBkgVO 		= event.getSplitBkgVO();
			List<SelectCntrVO> 		selectCntrVO	= splitBkgVO.getSelectCntrVO();
			List<SplitQtyVO>   		selectQtyVO 	= splitBkgVO.getSplitQtyVO();
			List<SelectSpclCgoVO>	selectSpclCgoVO = splitBkgVO.getSelectSpclCgoVO();

//			List<SelectTroVO>		selectTroVO		= splitBkgVO.getSelectTroVO();					
			
			//for History
			String      splitToBkgNoStr = "";
			String []   cntrHistStr 	= new String[event.getTargetBkg().length];
			String 	    preCntrHistStr	= "";
			String      orgTvvd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getTvvd();
			String 		polCd			= splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd();			
			String		splitRsnCd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason();
			HistoryTableVO histTableVO  = new HistoryTableVO();
			
			//for auto c/a
			String bdrFlag = "N";
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getBdrFlag().equals("Y")){
				bdrFlag = "Y";
			}			
			
			// prd calling
			ArrayList<String> cntrNoList  = null;
			String [][] 	  pctlMapSeq  = new String[event.getTargetBkg().length][2];	
			
			//bkg list being sent to prd
			ArrayList<String> bkgNoList = new ArrayList<String>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				bkgNoList.add(event.getTargetBkg()[i].getBkgNo());				
				// for history
				if(i==0){
					splitToBkgNoStr = event.getTargetBkg()[i].getBkgNo();
				} else {
					splitToBkgNoStr = splitToBkgNoStr + ", " + event.getTargetBkg()[i].getBkgNo();
					if(i%3==0){
						splitToBkgNoStr = splitToBkgNoStr + "\n";
					}
				}
			}

			//keep VVD information for DG cancel about source BKG
			List<SearchDgCancelInfoVO> dgCancelInfoBefore = null;
			dgCancelInfoBefore = spclCgoBC.searchDgCancelInfo(sourceBkg.getBkgNo());

			begin();
			
			//  calling in prd
			for (int i=0;i<event.getTargetBkg().length;i++){
				//In case of  memo split, P/C add call
				if(0==i && splitRsnCd.equals("M")){
	                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
	                prdMainInfoVO.setPcMode("S");
	                prdMainInfoVO.setFCmd("3");
	                prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
	                
	                PrdParameterVO prdParameterVO = new PrdParameterVO();
	                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
	                
	                //for qty
	                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
	                PrdQtyInfoVO[] 			prdQtyInfos = receiptBC.searchBkgQtyForRailTime(sourceBkg);
	                PrdQtyInfoVO 			prdQtyInfo = null;
	                for(int icnt=0;icnt<prdQtyInfos.length; icnt++) {
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (prdQtyInfos[icnt].getCQty());
                		prdQtyInfo.setCTpsz(prdQtyInfos[icnt].getCTpsz());
                		prdQtyList.add(prdQtyInfo); 
	                }
	                
	                prdParameterVO.setPrdQtyInfo(prdQtyList);

	                //for cntr
	                cntrNoList = new ArrayList<String>();
	                String [] cntrNos = util.searchCntrListByBkg(sourceBkg);
	                for(int icnt=0;icnt<cntrNos.length; icnt++) {
	                    cntrNoList.add(cntrNos[icnt]);
	                }
	                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
	                String [] memoPctlMapSeq = util.splitByToken(pctlNoMapSeqStr, "|"); 
	            	sourceBkg.setPctlNo(memoPctlMapSeq[0]); 
	            	sourceBkg.setMapSeq(memoPctlMapSeq[1]);
				}
				
				BkgBlNoVO targetBkg = event.getTargetBkg()[i];
				log.debug("\nprocessing bkg no:"+targetBkg.getBkgNo());
                
                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
                prdMainInfoVO.setPcMode("S");
                prdMainInfoVO.setFCmd("3");
                prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
                
                PrdParameterVO prdParameterVO = new PrdParameterVO();
                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
                
                //for qty
                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
                PrdQtyInfoVO 			prdQtyInfo = null;                       

                for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {
                	int targetBkgSeq = icnt%splitBkgVO.getSplitBlInfoVO().size();
                	selectQtyVO.get(icnt).setSplitNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
                	double iQty =(selectQtyVO.get(icnt).getOpCntrQty()==null)? 0:Double.parseDouble(selectQtyVO.get(icnt).getOpCntrQty());

                	if (targetBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo())
       					&& iQty>0.0){
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
                		prdQtyInfo.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
                		prdQtyList.add(prdQtyInfo); 
                	}
                }
                prdParameterVO.setPrdQtyInfo(prdQtyList);

                //for cntr
                cntrNoList = new ArrayList<String>();
                cntrHistStr[i] = "";
                for(int icnt=0;icnt<selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg.getBkgNo())
                        && selectCntrVO.get(icnt).getSplitNo().length()>1){
                    	cntrNoList.add(selectCntrVO.get(icnt).getCntr_no());
                    	//for history
                    	if(cntrNoList.size() == 1){
                    		cntrHistStr[i] = selectCntrVO.get(icnt).getCntr_no();
                    	} else {
                    		if(cntrNoList.size()%3==1){
                    			cntrHistStr[i] = cntrHistStr[i] + ",\n" + selectCntrVO.get(icnt).getCntr_no();
                    		} else {
                    			cntrHistStr[i] = cntrHistStr[i] + ", " + selectCntrVO.get(icnt).getCntr_no();
                    		}
                    	}
                    }
                }
                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
            	pctlMapSeq[i] = util.splitByToken(pctlNoMapSeqStr, "|");
			}// prd calling send			
			commit();
			
			// for quantity history
			List<BkgQuantityVO> oldBkgQtys = receiptBC.searchBkgQuantity(sourceBkg);
			String oldMtyPkupYdCd = ((OldBkgInfoVO)receiptBC.searchOldBkgInfo(sourceBkg)).getMtyPkupYdCd();
			//for cntr history
			if(selectCntrVO.size()>0){
				String [] cntrList = util.searchCntrListByBkg(sourceBkg);
				for(int i=0;i<cntrList.length;i++){
                	if(i == 0){
                		preCntrHistStr = cntrList[i];
                	} else {
                		if((i+1)%3==1){
                			preCntrHistStr = preCntrHistStr + ",\n" + cntrList[i];
                		} else {
                			preCntrHistStr = preCntrHistStr + ", " + cntrList[i];
                		}
                	}
				}				
			}
			
			if (command.validateSplit(event.getSplitBkgVO(), sourceBkg).equals("Y")){
				begin();
				if(bdrFlag.equals("Y")){
					// add1stCaHist :input init  c/a hist of  sourcebkg(corr_no : 0000000001)
					add1stCaHist(event.getSourceBkg());
				}			
				String splitFlg = receiptBC.copyBookingForSplit   (sourceBkg, event.getTargetBkg(), splitBkgVO, account);
				eventResponse.setETCData("split_flag", splitFlg);
				
				blDocBlBC.copyBlDocByBkg		(sourceBkg, event.getTargetBkg(), splitBkgVO, account );
				if(selectCntrVO.size()>0){
					String[] param = {"S", ""};//for source quality, Parameter Counts
					blDocCmBC.copyCntrCmByBkg   (param, sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				}
				blDocBlBC.copyHblByBkg      ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				if(selectSpclCgoVO.size()>0){
					spclCgoBC.copySpclCgoByBkg  ("S", sourceBkg, event.getTargetBkg(), selectSpclCgoVO, account);
				}
				blRatingBC.copyManualChgByBkg   (sourceBkg, event.getTargetBkg(), account);
				//Temporary annotations process
				if(selectSpclCgoVO.size()>0){
					//bkg spcl flag recalculation
					receiptBC.modifySpclFlag(event.getTargetBkg(), account);
					if(selectCntrVO.size()>0){
						//container spcl flag recalculation
						blDocCmBC.modifyCntrSpclFlag(event.getTargetBkg(), account);
					}
				}

				//call cancel DG
				if(dgCancelInfoBefore.size()>0){

					//call spc module to tell DG cancel always in case of memo B/L
					List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
					spclCgoBC.manageDgDgCancel(dgCancelInfoBefore, account, scgVvdDgCgoCxlRqstVOs, "BKG Split");
					bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
				}
								
				//split reflection in cop
				String [] targetBkgNoList = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				String [] copMapSeq       = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				for(int i=0;i<event.getTargetBkg().length;i++){
					targetBkgNoList[i] = event.getTargetBkg()[i].getBkgNo();	
					copMapSeq[i]       = pctlMapSeq[i][1]; 
				}				
				if(splitRsnCd.equals("M")){
					targetBkgNoList[targetBkgNoList.length-1] = sourceBkg.getBkgNo();	
					copMapSeq      [targetBkgNoList.length-1] = sourceBkg.getMapSeq(); 
				}
				copBC.splitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				
				// S 2010.08.31 KMJ TRO Split add
				// 81. copyTroBySplit
				troBC.copyTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 82. cancelTroBySplit
				troBC.cancelTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 2010.08.31 KMJ TRO Split add
				
				for (int i=0;i<event.getTargetBkg().length;i++){
					BkgBlNoVO targetBkg = event.getTargetBkg()[i];
					
					//for performance report
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");	
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");			
				
					// If the status of those previously bdr Booking must recalculate.
					if(bdrFlag.equals("Y")){
						// If bdr later than
						bkgCorrectionVO.setBkgNo(targetBkg.getBkgNo());
						
						if (!event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							add1stCaHist(targetBkg);
						}
					}
					
					//In case of VVD is changed
					log.debug("\nbkg:"+targetBkg.getBkgNo()+",tVvd:"+splitBkgVO.getSplitBlInfoVO().get(i).getTvvd()
							+ "\nroute String:"+splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute());	
					if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null 
						&& splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute().length()>10
						&& !orgTvvd.equals(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd())){
						
						//PrdMainInfoVO Set
						PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd("3");
						prdMainInfoVO.setPcMode("R");
						prdMainInfoVO.setTVvd (splitBkgVO.getSplitBlInfoVO().get(i).getTvvd());
						prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO();
						prdParameterVO.setBkgBlNoVO(targetBkg);
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
						prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
						
						PrdMainInfoVO rtnPrdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
						util.resetNthRoute(rtnPrdMainInfoVO, 1);
						util.resetNthRoute(rtnPrdMainInfoVO, 2);
						util.resetNthRoute(rtnPrdMainInfoVO, 3);
						util.resetNthRoute(rtnPrdMainInfoVO, 4);
						rtnPrdMainInfoVO.setOrgTrnsMode("");
						rtnPrdMainInfoVO.setDestTrnsMode("");
						
						String rtnRoute = splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute();
						String [] rtnRouteVvds = util.splitByToken(rtnRoute, ",");
						for(int j=0;j<rtnRouteVvds.length;j++){
							if(rtnRouteVvds[j].length()==0) break;
							String [] rtnRouteInfo = util.splitByToken(rtnRouteVvds[j], "|");
							log.debug("\npol:"+rtnRouteInfo[0]+"/polYd:"+rtnRouteInfo[1]+"/pol_clpt:"+rtnRouteInfo[6]+
									   "/pod:"+rtnRouteInfo[2]+"/podYd:"+rtnRouteInfo[3]+"/pod_clpt:"+rtnRouteInfo[7] +
									   "/vvd:"+rtnRouteInfo[4]+"/lane:"+rtnRouteInfo[5]);
							if(j==0){
								rtnPrdMainInfoVO.setPol1 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol1N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol1C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod1 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod1N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod1C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd1 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane1(rtnRouteInfo[5]);
							} else if(j==1){
								rtnPrdMainInfoVO.setPol2 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol2N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol2C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod2 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod2N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod2C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd2 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane2(rtnRouteInfo[5]);
							} else if(j==2){
								rtnPrdMainInfoVO.setPol3 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol3N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol3C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod3 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod3N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod3C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd3 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane3(rtnRouteInfo[5]);
							} else if(j==3){
								rtnPrdMainInfoVO.setPol4 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol4N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol4C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod4 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod4N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod4C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd4 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane4(rtnRouteInfo[5]);
							}
						}
						
						prdParameterVO.setPrdMainInfoVO(rtnPrdMainInfoVO);
						util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

						// 12. createProdCtlRoute
						String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
						String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
						
						targetBkg.setPctlNo(pctlNoMapSeq[0]);
						targetBkg.setMapSeq(pctlNoMapSeq[1]);						

						//	old vvd retrieve about vvd changing
						histTableVO = new HistoryTableVO();
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							histTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0099", targetBkg);
						}
						
						// real  vvd changing
						VvdAssignVO vvdAssignVO = new VvdAssignVO();
						vvdAssignVO.setBkgBlNoVO(targetBkg);
//						BdrSpclVO bdrSpclVO = receiptBC.modifyOceanRoute(vvdAssignVO, account);
						receiptBC.modifyOceanRoute(vvdAssignVO, account);
												
						//scond time replan reflection cop
						copBC.updateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
					}//In case of VVD is changed end
					
					if(selectSpclCgoVO.size()>0){
//						reRequestSpclCgoApproval(targetBkg, "SPLIT", null);
						reRequestSpclCgoApproval(targetBkg, "SPLIT", null, "");
					}
					
					// If the status of those previously bdr Booking must recalculate.
					if(bdrFlag.equals("N")){
						receiptBC.changeBkgStatus("Y",targetBkg, false, account);
					}

					// auto c/a process
					if(bdrFlag.equals("Y")){						
						// In case of In case of vvd is changed
						if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null){
							bkgCorrectionVO.setRoutCorrFlg("Y");
							bkgCorrectionVO.setTrnkVslCorrFlg("Y");
						}
						
						if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							bdrBC.addAutoCaTemp(sourceBkg, "SPLIT_MASTER", bkgCorrectionVO, account);
						} else {
							bdrBC.addAutoCaTemp(targetBkg, "SPLIT_NEW", bkgCorrectionVO, account);
						}
						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(event.getCaRsnCd(), event.getCaRemark(), targetBkg, "N", "Y");
						targetBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						event.getTargetBkg()[i].setCaNo(corrBkgBlNoVO.getCaNo());
						
						bdrBC.removeCATemp(targetBkg);
						
						blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);
						
			            //add2. 
						OblIssVO oblIssVO = util.searchOblIssue(targetBkg); 
						
						//add2. 
						RevDrNoteVO        revDrNoteVO    = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (targetBkg.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (targetBkg.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);

						RevenueDebitNoteBC revenueDebitNoteBC = new RevenueDebitNoteBCImpl();
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
						
						//add2. 
						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						CargoReleaseOrderBC cargoReleaseOrderBC = new CargoReleaseOrderBCImpl();
						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}	
					} else {
						targetBkg.setCaNo("");
					}// auto c/a process end

					// history process
					HistoryLineVO historyLineVO = new HistoryLineVO();
					
					historyLineVO.setBkgNo (targetBkg.getBkgNo());
					historyLineVO.setCorrNo(targetBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						historyLineVO.setCrntCtnt("Split into :"+splitToBkgNoStr);		
						historyLineVO.setBkgDocProcTpCd("BKGSPT");				
					} else {
						historyLineVO.setCrntCtnt("Split from BKG No :"+sourceBkg.getBkgNo()); //new -> Splited from BKG No : %, old -> Splited.			
						historyLineVO.setBkgDocProcTpCd("SPTCRE");
					}
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
					
					//	 history about vvd changing
					if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null 
								&& splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute().length()>10
								&& !orgTvvd.equals(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd())){
							histTableVO.getBkgBlNoVO().setCaNo(targetBkg.getCaNo());
							historyBC.manageBookingHistory("ESM_BKG_0099", histTableVO, account);
						}
					}
					if(cntrHistStr[i].length()>0){
						//	 histiry about cntr
						historyLineVO.setCrntCtnt(cntrHistStr[i]); 
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							historyLineVO.setPreCtnt(preCntrHistStr);
						} 
						historyLineVO.setHisCateNm("Container No.");						
						historyBC.createBkgHistoryLine (historyLineVO,account);					
						historyBC.releaseCntrFinalConfirm(targetBkg, account);
						// history process end
					}
				}

				//In case of memo split, history of master bkghistory
				if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){
					interfaceToCoa(sourceBkg, "Booking Split", account);	
					
					HistoryLineVO historyLineVO = new HistoryLineVO();
				
					historyLineVO.setBkgNo (sourceBkg.getBkgNo());
					historyLineVO.setCorrNo(sourceBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					historyLineVO.setCrntCtnt("Memo Split into :"+splitToBkgNoStr);		
					historyLineVO.setBkgDocProcTpCd("BKGSPT");
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
				}
			
				//interface inv, coa
				for (int i=0;i<event.getTargetBkg().length;i++){	
					BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 	

					// 87: interfaceCoa
					interfaceToCoa(targetBkg, "Booking Split", account);	
					
					//org bkg
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						// do not in memo split master
						if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){
							
							// only CNHKG exception
							if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){

								String bracCd = "U";
								if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null 
										&& splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute().length()>10
										&& !orgTvvd.equals(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd())){
									bracCd = "B";
								}								
								Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
								vender301ParamVO.setBkgBlNoVO(targetBkg);
								vender301ParamVO.setOldVvdVOs(null);
								vender301ParamVO.setOldQtyVOs(oldBkgQtys);
								vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
								vender301ParamVO.setBracCd(bracCd);
								vender301ParamVO.setEdiKind("BT");
								vender301ParamVO.setAutoManualFlg("Y");
								
								searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
								searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
							}						
						}					
					} else {							
						// only CNHKG exception
						if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){							
							// 20091127 BackEndJob changing
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(targetBkg);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
							vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
							vender301ParamVO.setBracCd("N");
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
							searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
						}
					}
				}
				
				/* 占쎄껀�뜝�룞�삕亦끹룇�삕占쎈���삕占쎈턄占쎈눀�뜝占� �뜝�럥吏쀧뼨轅명�э옙�꼨占쎈ご�뜝占� �뜝�럩留꾢뜝�럥�뱺 DT �뜝�룞�삕�뜝�럩�궋 */
				util.bkgBookingLstSavDtSave(sourceBkg.getBkgNo());
				
				commit();
				
				begin();
				for (int i=0;i<event.getTargetBkg().length;i++){
					// invoice interface
					interfaceToInv(event.getTargetBkg()[i], account);
				}				
				commit();
				
				try{		
					for (int i=0;i<event.getTargetBkg().length;i++){	
						BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 
						// cut off time (After cop creation, process)
						String fromDt = null;
						String toDt = null;
						if(("US".equals(polCd.substring(0,2)) || "CA".equals(polCd.substring(0,2))) && bdrFlag.equals("Y")){	
							PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(targetBkg);
													
							Map railTime = prdBC.getRailRecevingTime(targetBkg.getPctlNo(), prdQtyInfo, null, null);

							fromDt= (String)railTime.get("RTN_TIME");
							toDt  = (String)railTime.get("CUT_OFF");
						}
						begin(); //Transaction devision
						receiptBC.createCargoClosingTime(targetBkg, fromDt, toDt, account);
						String[] railTime = splitRailReceiveDate(targetBkg);
						fromDt = railTime[0];
						toDt   = railTime[1];
						copBC.modifyRailRcvCoffDt(targetBkg.getBkgNo(), fromDt, toDt, account.getUsr_id());	
						commit();	
					} 
				} catch (Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
			}
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	
	/**
	 * ESM_BKG_0099 : split click <br>
	 *
	 *  
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse splitBookingMulti(Event e) throws EventException{		
		try{
			EsmBkg0099Event 				event 			= (EsmBkg0099Event)e;
			GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();			
			GeneralBookingSplitCombineBC 	command 		= new GeneralBookingSplitCombineBCImpl();
			
			
			GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBlBC 	= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BlRatingBC 				blRatingBC 	= new BlRatingBCImpl();
			SpecialCargoReceiptBC 	spclCgoBC 	= new SpecialCargoReceiptBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BDRCorrectionBC         bdrBC       = new BDRCorrectionBCImpl();
			PerformanceReportBC 	reportBC	= new PerformanceReportBCImpl();
			BLIssuanceBC            blIssBC		= new BLIssuanceBCImpl();
			BookingUtil             util        = new BookingUtil();
			
			
			BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
        	ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();
        	TransferOrderIssueBC	troBC		= new TransferOrderIssueBCImpl();
			ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC = new ReceiveOwnBkgCancelRequestMgtBCImpl();
			
			//00.Legacy VVD Check
			receiptBC.checkLegacySystemVVD(event.getSplitBkgVO().getCopySplitBkgEtcVO().get(0).getTvvd());
			
			//orgin bkg
			BkgBlNoVO sourceBkg = event.getSourceBkg();
			String currSplitBkg = event.getCurrSplitBkg();

			BkgBlNoVO dupChkBkgVO = new BkgBlNoVO();
			dupChkBkgVO.setBkgNo(currSplitBkg);
			if(util.searchBkgStatusByBkg(dupChkBkgVO) != null){
				return eventResponse;				
			}

			SplitBkgVO 				splitBkgVO 		  = event.getSplitBkgVO();
			List<SelectCntrVO> 		selectCntrVO	  = splitBkgVO.getSelectCntrVO();
			List<SplitQtyVO>   		selectQtyVO 	  = splitBkgVO.getSplitQtyVO();
			List<SelectSpclCgoVO>	selectSpclCgoVO   = splitBkgVO.getSelectSpclCgoVO();
			List<SplitBlInfoVO>     splitBlInfoVOList = splitBkgVO.getSplitBlInfoVO();				
			
			//for History
			String      splitToBkgNoStr = "";
			String []   cntrHistStr 	= new String[event.getTargetBkg().length];
			String 	    preCntrHistStr	= "";
			String      orgTvvd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getTvvd();
			String 		polCd			= splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd();			
			String		splitRsnCd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason();
			HistoryTableVO histTableVO  = null;
			
			//for auto c/a
			String bdrFlag = "N";
			String lstCorrNo = "";			
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getBdrFlag().equals("Y")){
				bdrFlag = "Y";
			}			

			//keep VVD information for DG cancel about source BKG
			List<SearchDgCancelInfoVO> dgCancelInfoBefore = null;
			dgCancelInfoBefore = spclCgoBC.searchDgCancelInfo(sourceBkg.getBkgNo());

			begin();
			String bkgNo = "";
			BkgBlNoVO[] tagetBkgs = event.getTargetBkg();
			for (int i=0; i < tagetBkgs.length; i++){
				try{
					BkgBlNoVO tagetBkg = tagetBkgs[i];
					if(bkgNo.equals("")) bkgNo = event.getTargetBkg()[0].getBkgNo();
					command.bkgXterRqstMstUpdate(bkgNo, tagetBkg.getBkgNo(), String.valueOf(1+i));
				}catch (Exception e2) {
					log.error(e2);			
				}
			}				
			commit(); 
			
			int currSeq = 0;			
			int orgSplitSize = splitBlInfoVOList.size();
			int currSplitBkgSeq = 0;
			for (int i=0;i<event.getTargetBkg().length;i++){
				event.getTargetBkg()[i].setPctlNo(sourceBkg.getPctlNo());
				if(currSplitBkg.equals(event.getTargetBkg()[i].getBkgNo())){
					currSplitBkgSeq = i;
				}
			}
			BkgBlNoVO[] tempTargetBkg = new BkgBlNoVO[2];
			List<SplitBlInfoVO> tempSplitblInfoVOList = new ArrayList<SplitBlInfoVO>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				if(event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
					tempTargetBkg[0] = event.getTargetBkg()[i];
					tempSplitblInfoVOList.add(splitBlInfoVOList.get(i));
				}
				if(event.getTargetBkg()[i].getBkgNo().equals(currSplitBkg)){
					tempTargetBkg[1] = event.getTargetBkg()[i];
					tempSplitblInfoVOList.add(splitBlInfoVOList.get(i));
					currSeq = i;
				}
				
				if(currSeq > 0 && currSeq < i){
					tempSplitblInfoVOList.get(0).setActWgt("" +
						(Float.parseFloat(tempSplitblInfoVOList.get(0).getActWgt())
							+ Float.parseFloat(splitBlInfoVOList.get(i).getActWgt())
						));;
					tempSplitblInfoVOList.get(0).setMeasQty("" +
						(Float.parseFloat(tempSplitblInfoVOList.get(0).getMeasQty())
							+ Float.parseFloat(splitBlInfoVOList.get(i).getMeasQty())
						));;
					tempSplitblInfoVOList.get(0).setPckQty("" +
						(Float.parseFloat(tempSplitblInfoVOList.get(0).getPckQty())
							+ Float.parseFloat(splitBlInfoVOList.get(i).getPckQty())
						));;
				}
			}			
			event.setTargetBkg(tempTargetBkg);
			splitBlInfoVOList = tempSplitblInfoVOList;
			splitBkgVO.setSplitBlInfoVO(splitBlInfoVOList);
			
			String tempCntrNo = "";
			Boolean deleteCntrFlag = false;
			int deleteCntrSeq = 0;
			List<SelectCntrVO> orgSelectCntrVO = selectCntrVO;
			for(int i=0;i<selectCntrVO.size();i++){
				if(selectCntrVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())){
					tempCntrNo = selectCntrVO.get(i).getCntr_no();
					deleteCntrFlag = true;
					deleteCntrSeq = i;
					currSeq = 0;
				}
				if(selectCntrVO.get(i).getBkg_no().equals(currSplitBkg)){
					currSeq = i;
				}
				if(currSeq > 0 && currSeq < i){
					if(tempCntrNo.equals(selectCntrVO.get(i).getCntr_no())
							&& selectCntrVO.get(i).getSplitNo().length() > 1){
						deleteCntrFlag = false;
					}
				}
				if(orgSplitSize-1 == i%orgSplitSize){
			
					if(selectCntrVO.get(deleteCntrSeq).getSplitNo().length()<1){
						if(deleteCntrFlag){
							selectCntrVO.get(deleteCntrSeq).setSplitNo("");
						} else {
			
							selectCntrVO.get(deleteCntrSeq).setSplitNo(sourceBkg.getBkgNo().substring(10, 12));
						}
					}
				}
			}

			List<SelectCntrVO> tempSelectCntrVO = new ArrayList<SelectCntrVO>();
			for(int i=0;i<selectCntrVO.size();i++){
				if(selectCntrVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())){
					tempSelectCntrVO.add(selectCntrVO.get(i));
				}
				if(selectCntrVO.get(i).getBkg_no().equals(currSplitBkg)){
					tempSelectCntrVO.add(selectCntrVO.get(i));
				}
			}
			
			selectCntrVO = tempSelectCntrVO;
			splitBkgVO.setSelectCntrVO(selectCntrVO);
									
			for(int i=0;i<selectQtyVO.size();i++){
				
				if(0==i%orgSplitSize){
					currSeq = 0;
					for(int j=i;j<i+orgSplitSize;j++){
						if(selectQtyVO.get(j).getSplitNo().equals(currSplitBkg.substring(10, 12))){
							currSeq = j;							
						}			
						if(currSeq > 0 && currSeq < j){
							selectQtyVO.get(i).setOpCntrQty(""+
									(Float.parseFloat(selectQtyVO.get(i).getOpCntrQty())
											+ Float.parseFloat(selectQtyVO.get(j).getOpCntrQty())
									));			
						}
					}
				}
			}
			
			List<SplitQtyVO> tempSelectQtyVO = new ArrayList<SplitQtyVO>();
			for(int i=0;i<selectQtyVO.size();i++){
				if(selectQtyVO.get(i).getSplitNo().equals(selectQtyVO.get(0).getSplitNo())){
					tempSelectQtyVO.add(selectQtyVO.get(i));
				}
				if(selectQtyVO.get(i).getSplitNo().equals(currSplitBkg.substring(10, 12))){
					tempSelectQtyVO.add(selectQtyVO.get(i));
				}		
			}
			selectQtyVO = tempSelectQtyVO;
			splitBkgVO.setSplitQtyVO(selectQtyVO);
			
			String tempSpclCntrNo = "";
			Boolean deleteSpclCntrFlag = false;
			int deleteSpclCntrSeq = 0;
			for(int i=0;i<selectSpclCgoVO.size();i++){
//				if(!selectSpclCgoVO.get(i).getSpclCagoFlag().equals("S")){		
				if(!selectSpclCgoVO.get(i).getSpclCagoFlag().equals("S") 
				&& !selectSpclCgoVO.get(i).getSpclCagoFlag().equals("D") 
				&& !selectSpclCgoVO.get(i).getSpclCagoFlag().equals("R")
				&& !selectSpclCgoVO.get(i).getSpclCagoFlag().equals("A")
				&& !selectSpclCgoVO.get(i).getSpclCagoFlag().equals("B")
				){		
					if(selectSpclCgoVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())){
						tempSpclCntrNo = selectSpclCgoVO.get(i).getCntrNo();
						deleteSpclCntrFlag = true;
						deleteSpclCntrSeq = i;
						currSeq = 0;
					}
					if(selectSpclCgoVO.get(i).getBkg_no().equals(currSplitBkg)){
						currSeq = i;
					}
					if(currSeq > 0 && currSeq < i){
						if(tempSpclCntrNo.equals(selectSpclCgoVO.get(i).getCntrNo())
								&& selectSpclCgoVO.get(i).getSplitNo().length() > 1){
							deleteSpclCntrFlag = false;
						}
					}
					if(orgSplitSize-1 == i%orgSplitSize){
						
						if(selectSpclCgoVO.get(deleteSpclCntrSeq).getSplitNo().length()<1){
							if(deleteSpclCntrFlag){
								selectSpclCgoVO.get(deleteSpclCntrSeq).setSplitNo("");
							} else {
								
								selectSpclCgoVO.get(deleteSpclCntrSeq).setSplitNo(sourceBkg.getBkgNo().substring(10, 12));
							}
						}
					}
				}
				
				//Not to delete source booking information until the last split 
				if(!"Y".equals(event.getLastTarget())){
					if((selectSpclCgoVO.get(i).getSpclCagoFlag().equals("D")) 
					|| (selectSpclCgoVO.get(i).getSpclCagoFlag().equals("R"))
					|| (selectSpclCgoVO.get(i).getSpclCagoFlag().equals("A"))
					|| (selectSpclCgoVO.get(i).getSpclCagoFlag().equals("B"))
					){
						if((selectSpclCgoVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())) && selectSpclCgoVO.get(i).getSplitNo().length()<1){
							selectSpclCgoVO.get(i).setSplitNo(sourceBkg.getBkgNo().substring(10, 12));
						}
					}
				}
			}

			List<SelectSpclCgoVO> tempSelectSpclCgoVO = new ArrayList<SelectSpclCgoVO>();
			for(int i=0;i<selectSpclCgoVO.size();i++){
				if(selectSpclCgoVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())){
					tempSelectSpclCgoVO.add(selectSpclCgoVO.get(i));
				}
				if(selectSpclCgoVO.get(i).getBkg_no().equals(currSplitBkg)){
					tempSelectSpclCgoVO.add(selectSpclCgoVO.get(i));
				}				
			}
			selectSpclCgoVO = tempSelectSpclCgoVO;
			splitBkgVO.setSelectSpclCgoVO(selectSpclCgoVO);
			
			
			ArrayList<String> cntrNoList  = null;
			String [][] 	  pctlMapSeq  = new String[event.getTargetBkg().length][2];	
			
			ArrayList<String> bkgNoList = new ArrayList<String>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				bkgNoList.add(event.getTargetBkg()[i].getBkgNo());				
				// for history
				if(i==0){
					splitToBkgNoStr = event.getTargetBkg()[i].getBkgNo();
				} else {
//					splitToBkgNoStr = splitToBkgNoStr + ", " + event.getTargetBkg()[i].getBkgNo();
					StringBuffer tmpBuffer = new StringBuffer(splitToBkgNoStr).append(", ").append(event.getTargetBkg()[i].getBkgNo());
					splitToBkgNoStr = tmpBuffer.toString();
					if(i%3==0){
//						splitToBkgNoStr = splitToBkgNoStr + "\n";
						StringBuffer tmpBuffer2 = new StringBuffer(splitToBkgNoStr).append("\n");
						splitToBkgNoStr = tmpBuffer2.toString();
					}
				}
			}
			
			begin();
			
			for (int i=0;i<event.getTargetBkg().length;i++){
				
				if(0==i && splitRsnCd.equals("M")){
	                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
	                prdMainInfoVO.setPcMode("S");
	                prdMainInfoVO.setFCmd("3");
	                prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
	                
	                PrdParameterVO prdParameterVO = new PrdParameterVO();
	                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
	                
	                //for qty
	                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
	                PrdQtyInfoVO[] 			prdQtyInfos = receiptBC.searchBkgQtyForRailTime(sourceBkg);
	                PrdQtyInfoVO 			prdQtyInfo = null;
	                for(int icnt=0;icnt<prdQtyInfos.length; icnt++) {
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (prdQtyInfos[icnt].getCQty());
                		prdQtyInfo.setCTpsz(prdQtyInfos[icnt].getCTpsz());
                		prdQtyList.add(prdQtyInfo); 
	                }
	                
	                prdParameterVO.setPrdQtyInfo(prdQtyList);

	                //for cntr
	                cntrNoList = new ArrayList<String>();
	                String [] cntrNos = util.searchCntrListByBkg(sourceBkg);
	                for(int icnt=0;icnt<cntrNos.length; icnt++) {
	                    cntrNoList.add(cntrNos[icnt]);
	                }
	                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
	                String [] memoPctlMapSeq = util.splitByToken(pctlNoMapSeqStr, "|"); 
	            	sourceBkg.setPctlNo(memoPctlMapSeq[0]); 
	            	sourceBkg.setMapSeq(memoPctlMapSeq[1]);
				}
				
				BkgBlNoVO targetBkg = event.getTargetBkg()[i];
				log.debug("\nprocessing bkg no:"+targetBkg.getBkgNo());
                
                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
                prdMainInfoVO.setPcMode("S");
                prdMainInfoVO.setFCmd("3");
                prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
                
                PrdParameterVO prdParameterVO = new PrdParameterVO();
                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
                
                //for qty
                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
                PrdQtyInfoVO 			prdQtyInfo = null;                       

                for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {
                	int targetBkgSeq = icnt%splitBlInfoVOList.size();
                	selectQtyVO.get(icnt).setSplitNo(splitBlInfoVOList.get(targetBkgSeq).getBkgNo());
                	double iQty =(selectQtyVO.get(icnt).getOpCntrQty()==null)? 0:Double.parseDouble(selectQtyVO.get(icnt).getOpCntrQty());

                	if (targetBkg.getBkgNo().equals(splitBlInfoVOList.get(targetBkgSeq).getBkgNo())
       					&& iQty>0.0){
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
                		prdQtyInfo.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
                		prdQtyList.add(prdQtyInfo); 
                	}
                }
                prdParameterVO.setPrdQtyInfo(prdQtyList);

                //for cntr
                cntrNoList = new ArrayList<String>();
                cntrHistStr[i] = "";
                for(int icnt=0;icnt<selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg.getBkgNo())
                        && selectCntrVO.get(icnt).getSplitNo().length()>1){
                    	cntrNoList.add(selectCntrVO.get(icnt).getCntr_no());
                    	//for history
                    	if(cntrNoList.size() == 1){
                    		cntrHistStr[i] = selectCntrVO.get(icnt).getCntr_no();
                    	} else {
                    		if(cntrNoList.size()%3==1){
//                    			cntrHistStr[i] = cntrHistStr[i] + ",\n" + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(",\n").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		} else {
//                    			cntrHistStr[i] = cntrHistStr[i] + ", " + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(", ").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		}
                    	}
                    }
                }
                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
            	pctlMapSeq[i] = util.splitByToken(pctlNoMapSeqStr, "|");
			}
			commit();
			
			// for quantity history
			List<BkgQuantityVO> oldBkgQtys = receiptBC.searchBkgQuantity(sourceBkg);
			String oldMtyPkupYdCd = ((OldBkgInfoVO)receiptBC.searchOldBkgInfo(sourceBkg)).getMtyPkupYdCd();
			
			//for cntr history
			if(selectCntrVO.size()>0){
				String [] cntrList = util.searchCntrListByBkg(sourceBkg);
				for(int i=0;i<cntrList.length;i++){
                	if(i == 0){
                		preCntrHistStr = cntrList[i];
                	} else {
                		if((i+1)%3==1){
//                			preCntrHistStr = preCntrHistStr + ",\n" + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(",\n").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		} else {
//                			preCntrHistStr = preCntrHistStr + ", " + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(", ").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		}
                	}
				}				
			}
			
			if (command.validateSplit(event.getSplitBkgVO(), sourceBkg).equals("Y")){
				begin();
				if(bdrFlag.equals("Y")){
					
					add1stCaHist(event.getSourceBkg());
				}

				String splitFlg = receiptBC.copyBookingForSplit   (sourceBkg, event.getTargetBkg(), splitBkgVO,   account);
				eventResponse.setETCData("split_flag", splitFlg);

				blDocBlBC.copyBlDocByBkg		(sourceBkg, event.getTargetBkg(), splitBkgVO, account );
				if(selectCntrVO.size()>0){
//					blDocCmBC.copyCntrCmByBkg   (sourceBkg, event.getTargetBkg(), selectCntrVO, bkgCopyCntrCmByBkgVO ,account);
					blDocCmBC.copyCntrCmByBkgMulti(sourceBkg, event.getTargetBkg(), orgSelectCntrVO, selectCntrVO, account);
				}
				blDocBlBC.copyHblByBkg      ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				if(selectSpclCgoVO.size()>0){
					spclCgoBC.copySpclCgoByBkg  ("S", sourceBkg, event.getTargetBkg(), selectSpclCgoVO, account);
				}
				blRatingBC.copyManualChgByBkg   (sourceBkg, event.getTargetBkg(), account, splitRsnCd);

				if(selectSpclCgoVO.size()>0){
				
					receiptBC.modifySpclFlag(event.getTargetBkg(), account);
					if(selectCntrVO.size()>0){
				
						blDocCmBC.modifyCntrSpclFlag(event.getTargetBkg(), account);
					}
				}

				String [] targetBkgNoList = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				String [] copMapSeq       = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				for(int i=0;i<event.getTargetBkg().length;i++){
					targetBkgNoList[i] = event.getTargetBkg()[i].getBkgNo();	
					copMapSeq[i]       = pctlMapSeq[i][1]; 
				}				
				if(splitRsnCd.equals("M")){
					targetBkgNoList[targetBkgNoList.length-1] = sourceBkg.getBkgNo();	
					copMapSeq      [targetBkgNoList.length-1] = sourceBkg.getMapSeq(); 
				}
				copBC.splitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);

				// 81. copyTroBySplit
				troBC.copyTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 82. cancelTroBySplit
				troBC.cancelTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);

				String sourceSiFlg = receiptBC.searchSiFlg(sourceBkg);
				
				for (int i=0;i<event.getTargetBkg().length;i++){
					BkgBlNoVO targetBkg = event.getTargetBkg()[i];
					
					//for performance report
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");	
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");			

					if(bdrFlag.equals("Y")){
					
						bkgCorrectionVO.setBkgNo(targetBkg.getBkgNo());
					
						if (!event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							add1stCaHist(targetBkg);
						}
					}

					log.debug("\nbkg:"+targetBkg.getBkgNo()+",tVvd:"+splitBlInfoVOList.get(i).getTvvd()
							+ "\nroute String:"+splitBlInfoVOList.get(i).getRtnRoute());	
					if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
						&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
						&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
						
						//PrdMainInfoVO Set
						PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd("3");
						prdMainInfoVO.setPcMode("R");
						prdMainInfoVO.setTVvd (splitBlInfoVOList.get(i).getTvvd());
						prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO();
						prdParameterVO.setBkgBlNoVO(targetBkg);
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
						prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
						
						PrdMainInfoVO rtnPrdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
						util.resetNthRoute(rtnPrdMainInfoVO, 1);
						util.resetNthRoute(rtnPrdMainInfoVO, 2);
						util.resetNthRoute(rtnPrdMainInfoVO, 3);
						util.resetNthRoute(rtnPrdMainInfoVO, 4);
						rtnPrdMainInfoVO.setOrgTrnsMode("");
						rtnPrdMainInfoVO.setDestTrnsMode("");
						
						String rtnRoute = splitBlInfoVOList.get(i).getRtnRoute();
						String [] rtnRouteVvds = util.splitByToken(rtnRoute, ",");
						for(int j=0;j<rtnRouteVvds.length;j++){
							if(rtnRouteVvds[j].length()==0) break;
							String [] rtnRouteInfo = util.splitByToken(rtnRouteVvds[j], "|");
							log.debug("\npol:"+rtnRouteInfo[0]+"/polYd:"+rtnRouteInfo[1]+"/pol_clpt:"+rtnRouteInfo[6]+
									   "/pod:"+rtnRouteInfo[2]+"/podYd:"+rtnRouteInfo[3]+"/pod_clpt:"+rtnRouteInfo[7] +
									   "/vvd:"+rtnRouteInfo[4]+"/lane:"+rtnRouteInfo[5]);
							if(j==0){
								rtnPrdMainInfoVO.setPol1 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol1N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol1C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod1 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod1N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod1C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd1 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane1(rtnRouteInfo[5]);
							} else if(j==1){
								rtnPrdMainInfoVO.setPol2 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol2N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol2C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod2 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod2N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod2C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd2 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane2(rtnRouteInfo[5]);
							} else if(j==2){
								rtnPrdMainInfoVO.setPol3 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol3N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol3C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod3 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod3N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod3C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd3 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane3(rtnRouteInfo[5]);
							} else if(j==3){
								rtnPrdMainInfoVO.setPol4 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol4N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol4C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod4 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod4N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod4C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd4 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane4(rtnRouteInfo[5]);
							}
						}
						
						prdParameterVO.setPrdMainInfoVO(rtnPrdMainInfoVO);
//						util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

						// 12. createProdCtlRoute
						String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
						String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
						
						targetBkg.setPctlNo(pctlNoMapSeq[0]);
						targetBkg.setMapSeq(pctlNoMapSeq[1]);						

						histTableVO = new HistoryTableVO();
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							histTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0099", targetBkg);
						}

						VvdAssignVO vvdAssignVO = new VvdAssignVO();
						vvdAssignVO.setBkgBlNoVO(targetBkg);
//						BdrSpclVO bdrSpclVO = receiptBC.modifyOceanRoute(vvdAssignVO, account);
						receiptBC.modifyOceanRoute(vvdAssignVO, account);

						copBC.updateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
					}
					
					if(selectSpclCgoVO.size()>0){
//						reRequestSpclCgoApproval(targetBkg, "SPLIT", null);
						reRequestSpclCgoApproval(targetBkg, "SPLIT", null, "");
					}

					if(bdrFlag.equals("N")){
						receiptBC.changeBkgStatus("Y",targetBkg, false, account);
					}

					if(bdrFlag.equals("Y")){						
						
						if(splitBlInfoVOList.get(i).getRtnRoute()!=null){
							bkgCorrectionVO.setRoutCorrFlg("Y");
							bkgCorrectionVO.setTrnkVslCorrFlg("Y");
						}
						bkgCorrectionVO.setCaRsnCd(event.getCaRsnCd());
						bkgCorrectionVO.setBkgCorrRmk(event.getCaRemark());
						
						if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							bdrBC.addAutoCaTemp(sourceBkg, "SPLIT_MASTER", bkgCorrectionVO, account);

							if(currSplitBkgSeq > 1){
								
								BkgBlNoVO splitSourceBkg = bdrBC.searchLstCorrNo(sourceBkg);
								lstCorrNo = splitSourceBkg.getCaNo();
								
								String copyTypeCd = "SPLIT_MASTER";
								spclCgoBC.removeCA(splitSourceBkg, copyTypeCd);
								blRatingBC.removeCA(splitSourceBkg, copyTypeCd);
								blDocBlBC.removeCA(splitSourceBkg, copyTypeCd);
								receiptBC.removeCA(splitSourceBkg, copyTypeCd);
								blIssBC.removeCA(splitSourceBkg, copyTypeCd);
							}
						} else {
							bdrBC.addAutoCaTemp(targetBkg, "SPLIT_NEW", bkgCorrectionVO, account);				
						}						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(event.getCaRsnCd(), event.getCaRemark(), targetBkg, "N", "Y");
						targetBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						event.getTargetBkg()[i].setCaNo(corrBkgBlNoVO.getCaNo());
						if(event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							sourceBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						}
						bdrBC.removeCATemp(corrBkgBlNoVO);
						if(currSplitBkgSeq > 1){
							BkgBlNoVO splitSourceBkg = sourceBkg;
							splitSourceBkg.setCaNo(lstCorrNo);
							bdrBC.removeCA(splitSourceBkg);
						}
						blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);

						OblIssVO oblIssVO = util.searchOblIssue(targetBkg); 

						RevDrNoteVO        revDrNoteVO    = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (targetBkg.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (targetBkg.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);

						RevenueDebitNoteBC revenueDebitNoteBC = new RevenueDebitNoteBCImpl();
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  

						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						CargoReleaseOrderBC cargoReleaseOrderBC = new CargoReleaseOrderBCImpl();
						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}	
					} else {
						targetBkg.setCaNo("");
					}

					HistoryLineVO historyLineVO = new HistoryLineVO();
					
					historyLineVO.setBkgNo (targetBkg.getBkgNo());
					historyLineVO.setCorrNo(targetBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						historyLineVO.setCrntCtnt("Split into :"+splitToBkgNoStr);		
						historyLineVO.setBkgDocProcTpCd("BKGSPT");			
						if(currSplitBkgSeq > 1){	
							historyBC.modifyCorrNo(targetBkg, lstCorrNo);
						}
					} else {
						historyLineVO.setCrntCtnt("Split from BKG No :"+sourceBkg.getBkgNo()); //new -> Splited from BKG No : %, old -> Splited.			
						historyLineVO.setBkgDocProcTpCd("SPTCRE");
					}
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);

					if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
								&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
								&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
							histTableVO.getBkgBlNoVO().setCaNo(targetBkg.getCaNo());
							historyBC.manageBookingHistory("ESM_BKG_0099", histTableVO, account);
						}

						//call cancel DG
						if(dgCancelInfoBefore.size()>0){
							//check DG again
							List<SearchDgCancelInfoVO> dgCancelInfoAfter = null;
							dgCancelInfoAfter = spclCgoBC.searchDgCancelInfo(sourceBkg.getBkgNo());
							if(dgCancelInfoAfter.size() < 1){
								//call spc module to tell DG cancel
								List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
								spclCgoBC.manageDgDgCancel(dgCancelInfoBefore, account, scgVvdDgCgoCxlRqstVOs, "BKG Split");
								bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
							}
						}					
					
					}
					if(cntrHistStr[i].length()>0){
						
						historyLineVO.setCrntCtnt(cntrHistStr[i]); 
						historyLineVO.setHisCateNm("Container No.");	
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							historyLineVO.setCaFlg(targetBkg.getCaNo());
							historyLineVO.setPreCtnt(preCntrHistStr);
							historyBC.createdAmsAi(historyLineVO, account);
						} 
						historyBC.createBkgHistoryLine (historyLineVO,account);					
						historyBC.releaseCntrFinalConfirm(targetBkg, account);
					}

					if(!targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(sourceSiFlg!=null && "Y".equals(sourceSiFlg)){
							HistoryLineVO historyLineVO2 = new HistoryLineVO();
							historyLineVO2.setUiId("ESM_BKG_0099");			
							historyLineVO2.setHisCateNm("S/I");
							historyLineVO2.setBkgNo(targetBkg.getBkgNo());
							historyLineVO2.setCaFlg(targetBkg.getCaFlg());
							historyLineVO2.setCrntCtnt("S/I Check");
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						}
					}
				}

				if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){
					interfaceToCoa(sourceBkg, "Booking Split", account);	
					
					HistoryLineVO historyLineVO = new HistoryLineVO();
				
					historyLineVO.setBkgNo (sourceBkg.getBkgNo());
					historyLineVO.setCorrNo(sourceBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					historyLineVO.setCrntCtnt("Memo Split into :"+splitToBkgNoStr);		
					historyLineVO.setBkgDocProcTpCd("BKGSPT");
					historyLineVO.setHisCateNm("SPLIT");		
					if(currSplitBkgSeq > 1){	
						historyBC.modifyCorrNo(sourceBkg, lstCorrNo);
					}
					historyBC.createBkgHistoryLine (historyLineVO,account);
				}
				
				util.bkgBookingLstSavDtSave(bkgNo);
				
				commit();
				
				//interface inv, coa
				for (int i=0;i<event.getTargetBkg().length;i++){	
					BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 	

					// 87: interfaceCoa
					interfaceToCoa(targetBkg, "Booking Split", account);	
					
					//org bkg
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						
						if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){

							if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){

								String bracCd = "U";
								if(splitBlInfoVOList.get(i).getRtnRoute()!=null  && splitBlInfoVOList.get(i).getRtnRoute().length()>10 && !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
									bracCd = "B";
								}
								
								Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
								vender301ParamVO.setBkgBlNoVO(targetBkg);
								vender301ParamVO.setOldVvdVOs(null);
								vender301ParamVO.setOldQtyVOs(oldBkgQtys);
								vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
								vender301ParamVO.setBracCd(bracCd);
								vender301ParamVO.setEdiKind("BT");
								vender301ParamVO.setAutoManualFlg("Y");
								
								searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
								searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
								
							}						
						}					
					} else {							
						// CNHKG
						if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){							
							// 20091127 BackEndJob
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(targetBkg);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
							vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
							vender301ParamVO.setBracCd("N");
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
							searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
						}
					}
				}
				
				begin();
				for (int i=0;i<event.getTargetBkg().length;i++){
					// invoice interface
					interfaceToInv(event.getTargetBkg()[i], account);
				}				
				commit();
				
				try{		
					for (int i=0;i<event.getTargetBkg().length;i++){	
						BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 
						
						String fromDt = null;
						String toDt = null;
						if("US".equals(polCd.substring(0,2)) || "CA".equals(polCd.substring(0,2))){	
							
							if(bdrFlag.equals("N")){
								PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(targetBkg);
														
								Map railTime = prdBC.getRailRecevingTime(targetBkg.getPctlNo(), prdQtyInfo, null, null);
	
								fromDt= (String)railTime.get("RTN_TIME");
								toDt  = (String)railTime.get("CUT_OFF");
							}
							
						}
						begin();
						receiptBC.createCargoClosingTime(targetBkg, fromDt, toDt, account);
						commit();
					} 
				} catch (Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
			}
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}	
	/**
	 * ESM_BKG_0997 : open <br>
	 *  Split about cod<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodSplit(Event e) throws EventException{
		try{
			EsmBkg0997Event event = (EsmBkg0997Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CodSplitVO codSplit = command.searchCodSplit(event.getBkgBlNoVO(), event.getCodRqstSeq(), account);
			event.getBkgBlNoVO().setPctlNo(codSplit.getBkgBlForSplitVO().get(0).getPctlNo());
			String codRoute = command.searchNewTsRoute(event.getBkgBlNoVO()); 
			
			eventResponse.setETCData("bkg_no",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getBkgNo():"");
			eventResponse.setETCData("bl_no",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getBlNo():"");
			eventResponse.setETCData("tvvd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getTvvd():"");
			eventResponse.setETCData("por_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPorCd():"");
			eventResponse.setETCData("pol_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPolCd():"");
			eventResponse.setETCData("pod_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPodCd():"");
			eventResponse.setETCData("del_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getDelCd():"");
			eventResponse.setETCData("stwg_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getStwgCd():"");
			eventResponse.setETCData("rail_blk_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getRailBlkCd():"");
			eventResponse.setETCData("fd_grd_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getFdGrdFlg():"");
			eventResponse.setETCData("hngr_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getHngrFlg():"");
			eventResponse.setETCData("hot_de_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getHotDeFlg():"");
			eventResponse.setETCData("prct_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPrctFlg():"");
			eventResponse.setETCData("stop_off_loc_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getStopOffLocCd():"");
			eventResponse.setETCData("spcl_hide_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getSpclHideFlg():"");
			eventResponse.setETCData("remark",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getRemark():"");
			eventResponse.setETCData("dg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getDg():"");
			eventResponse.setETCData("rf",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getRf():"");
			eventResponse.setETCData("ak",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getAk():"");
			eventResponse.setETCData("bb",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getBb():"");
			eventResponse.setETCData("pctl_no",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPctlNo():"");
			eventResponse.setETCData("bdr_flag",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getBdrFlg():"");
			eventResponse.setETCData("tro_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getTroFlg():"");
			eventResponse.setETCData("splitFlg",(codSplit.getBkgBlForSplitVO().size()>0)? JSPUtil.getNull(codSplit.getBkgBlForSplitVO().get(0).getSplitFlg()):"");
			eventResponse.setETCData("bkgStsCd",(codSplit.getBkgBlForSplitVO().size()>0)? JSPUtil.getNull(codSplit.getBkgBlForSplitVO().get(0).getBkgStsCd()):"");
			
			eventResponse.setETCData("custSplitNo",(codSplit.getLastSplitNoVO().size()>0)? codSplit.getLastSplitNoVO().get(0).getCustsplitno():"");
			eventResponse.setETCData("memoSplitNo",(codSplit.getLastSplitNoVO().size()>0)? codSplit.getLastSplitNoVO().get(0).getMemosplitno():"");
			eventResponse.setETCData("bkgsplitno",(codSplit.getLastSplitNoVO().size()>0)? JSPUtil.getNull(codSplit.getLastSplitNoVO().get(0).getBkgsplitno()):"");
			eventResponse.setETCData("rtn_route", codRoute);
			
			eventResponse.setRsVoList(codSplit.getBkgBlForSplitVO());
			eventResponse.setRsVoList(codSplit.getBkgQuantityVO());
			eventResponse.setRsVoList(codSplit.getCntrSpclTroSelectVO());
			eventResponse.setRsVoList(codSplit.getSpclSeqForSplitVO());
			eventResponse.setRsVoList(event.getBkgCodVvdVO()); 
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
	 *  ESM_BKG_0997 : ok click <br>
	 *  Cod�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌죷�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷③쪛�겦維�占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럥�젾�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡���뜝�럩�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎌젂癰귥옓�맶�뜝�럥�쑅占쎈빝�넫臾믪굲�뜝�럥爾쎽벧�겦�뙔占쎌굲占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮚�뜝�럩�궨占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷⑨옙�뼀占쎈┬ing Split process<br>
	 *  
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse splitCodBooking(Event e) throws EventException{
		try{
			EsmBkg0997Event 				event		    = (EsmBkg0997Event)e;
			GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();			
			GeneralBookingSplitCombineBC 	command 		= new GeneralBookingSplitCombineBCImpl();
			
			//Bkg data reflection
			GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
			BLDocumentationBLBC 	blDocBlBC 	= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BlRatingBC 				blRatingBC 	= new BlRatingBCImpl();
			BDRCorrectionBC         bdrBC       = new BDRCorrectionBCImpl();
			CODCorrectionBC         codBC       = new CODCorrectionBCImpl();
			PerformanceReportBC 	reportBC 	= new PerformanceReportBCImpl();
			BookingUtil             util        = new BookingUtil();
			
			// �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲占쎈눀占쎈ぜ占쎄텣占쎈쐻占쎈쑟占쎌��뜝�럥嫄앭뜝�럥留덌옙�쐻占쎈윥占쎈데e connections
			BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
        	ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();
			
			//orgin bkg
			BkgBlNoVO sourceBkg = event.getSourceBkg();
			
			//for splitprocess
			SplitBkgVO 				splitBkgVO 		= event.getSplitBkgVO();
			List<SelectCntrVO> 		selectCntrVO	= splitBkgVO.getSelectCntrVO();
			List<SplitQtyVO>   		selectQtyVO 	= splitBkgVO.getSplitQtyVO();
			List<SelectSpclCgoVO>	selectSpclCgoVO = splitBkgVO.getSelectSpclCgoVO();			
			
			//for History
			String      splitToBkgNoStr = "";
			String []   cntrHistStr 	= new String[event.getTargetBkg().length];
			String 	    preCntrHistStr	= "";
			String      orgTvvd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getTvvd();
//			String 		polCd			= splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd();	
			String      codRqstSeq      = event.getCodRqstSeq();
			String		splitRsnCd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason();
			
			HistoryTableVO histTableVO  = new HistoryTableVO();
			
			//for auto c/a
			String bdrFlag = "N";
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getBdrFlag().equals("Y")){
				bdrFlag = "Y";
			}			
			
			// prd calling
			ArrayList<String> cntrNoList  = null;
			String [][] 	  pctlMapSeq  = new String[event.getTargetBkg().length][2];	
			
			//  bkg list being sent to prd
			ArrayList<String> bkgNoList = new ArrayList<String>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				bkgNoList.add(event.getTargetBkg()[i].getBkgNo());				
				// for history
				if(i==0){
					splitToBkgNoStr = event.getTargetBkg()[i].getBkgNo();
				} else {
					splitToBkgNoStr = splitToBkgNoStr + ", " + event.getTargetBkg()[i].getBkgNo();
					if(i%3==0){
						splitToBkgNoStr = splitToBkgNoStr + "\n";
					}
				}
			}
			
			begin();			
			
			// calling in prd for split bkg
			for (int i=0;i<event.getTargetBkg().length;i++){
				//In case fod memo split, P/C add call
				if(0==i && splitRsnCd.equals("M")){
	                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
	                prdMainInfoVO.setPcMode("S");
	                prdMainInfoVO.setFCmd("3");
	                prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
	                
	                PrdParameterVO prdParameterVO = new PrdParameterVO();
	                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
	                
	                //for qty
	                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
	                PrdQtyInfoVO[] 			prdQtyInfos = receiptBC.searchBkgQtyForRailTime(sourceBkg);
	                PrdQtyInfoVO 			prdQtyInfo = null;
	                for(int icnt=0;icnt<prdQtyInfos.length; icnt++) {
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (prdQtyInfos[icnt].getCQty());
                		prdQtyInfo.setCTpsz(prdQtyInfos[icnt].getCTpsz());
                		prdQtyList.add(prdQtyInfo); 
	                }
	                
	                prdParameterVO.setPrdQtyInfo(prdQtyList);

	                //for cntr
	                cntrNoList = new ArrayList<String>();
	                String [] cntrNos = util.searchCntrListByBkg(sourceBkg);
	                for(int icnt=0;icnt<cntrNos.length; icnt++) {
	                    cntrNoList.add(cntrNos[icnt]);
	                }
	                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
	                String [] memoPctlMapSeq = util.splitByToken(pctlNoMapSeqStr, "|"); 
	            	sourceBkg.setPctlNo(memoPctlMapSeq[0]); 
	            	sourceBkg.setMapSeq(memoPctlMapSeq[1]);
				}
				BkgBlNoVO targetBkg = event.getTargetBkg()[i];
				log.debug("\nprocessing bkg no:"+targetBkg.getBkgNo());
                
                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
                prdMainInfoVO.setPcMode("S");
                prdMainInfoVO.setFCmd("3");
                prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
                
                PrdParameterVO prdParameterVO = new PrdParameterVO();
                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
                
                //for qty
                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
                PrdQtyInfoVO 			prdQtyInfo = null;                       

                for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {
                	int targetBkgSeq = icnt%splitBkgVO.getSplitBlInfoVO().size();
                	selectQtyVO.get(icnt).setSplitNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
                	double iQty =(selectQtyVO.get(icnt).getOpCntrQty()==null)? 0:Double.parseDouble(selectQtyVO.get(icnt).getOpCntrQty());

                	if (targetBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo())
       					&& iQty>0.0){
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
                		prdQtyInfo.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
                		prdQtyList.add(prdQtyInfo); 
                	}
                }
                prdParameterVO.setPrdQtyInfo(prdQtyList);

                //for cntr
                cntrNoList = new ArrayList<String>();
                cntrHistStr[i] = "";
                for(int icnt=0;icnt<selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg.getBkgNo())
                        && selectCntrVO.get(icnt).getSplitNo().length()>1){
                    	cntrNoList.add(selectCntrVO.get(icnt).getCntr_no());
                    	//for history
                    	if(cntrNoList.size() == 1){
                    		cntrHistStr[i] = selectCntrVO.get(icnt).getCntr_no();
                    	} else {
                    		if(cntrNoList.size()%3==1){
                    			cntrHistStr[i] = cntrHistStr[i] + ",\n" + selectCntrVO.get(icnt).getCntr_no();
                    		} else {
                    			cntrHistStr[i] = cntrHistStr[i] + ", " + selectCntrVO.get(icnt).getCntr_no();
                    		}
                    	}
                    }
                }
                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
            	pctlMapSeq[i] = util.splitByToken(pctlNoMapSeqStr, "|");
			}// prd calling ending			
			commit();
			
			//for cntr history
			if(selectCntrVO.size()>0){
				String [] cntrList = util.searchCntrListByBkg(sourceBkg);
				for(int i=0;i<cntrList.length;i++){
                	if(i == 0){
                		preCntrHistStr = cntrList[i];
                	} else {
                		if((i+1)%3==1){
                			preCntrHistStr = preCntrHistStr + ",\n" + cntrList[i];
                		} else {
                			preCntrHistStr = preCntrHistStr + ", " + cntrList[i];
                		}
                	}
				}				
			}
			
			if (command.validateSplit(event.getSplitBkgVO(), sourceBkg).equals("Y")){
				begin();
				if(bdrFlag.equals("Y")){
					// add1stCaHist :input init  c/a hist of  sourcebkg(corr_no : 0000000001)
					add1stCaHist(event.getSourceBkg());
				}			
				receiptBC.copyBookingForSplit   (sourceBkg, event.getTargetBkg(), splitBkgVO,   account);
				blDocBlBC.copyBlDocByBkg		(sourceBkg, event.getTargetBkg(), splitBkgVO,   account );
				String[] param = {"S", ""};//for source quality, Parameter Counts
				blDocCmBC.copyCntrCmByBkg  (param, sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				blDocBlBC.copyHblByBkg     ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				if(selectSpclCgoVO.size()>0){
					SpecialCargoReceiptBC spclCgoBC = new SpecialCargoReceiptBCImpl();
					spclCgoBC.copySpclCgoByBkg  ("S", sourceBkg, event.getTargetBkg(),selectSpclCgoVO, account);
				}

			
//				if(selectSpclCgoVO.size()>0){
//					//bkg�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾占쎄턀筌�硫� flag recalculation
//					receiptBC.modifySpclFlag(event.getTargetBkg(), account);
//					if(selectCntrVO.size()>0){
//						//container�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾占쎄턀筌�硫� flag recalculation
//						blDocCmBC.modifyCntrSpclFlag(event.getTargetBkg(), account);
//					}
//				}
				
				//split reflection in cop
				String [] targetBkgNoList = new String[event.getTargetBkg().length];
				String [] copMapSeq       = new String[event.getTargetBkg().length];
				for(int i=0;i<event.getTargetBkg().length;i++){
					targetBkgNoList[i] = event.getTargetBkg()[i].getBkgNo();	
					copMapSeq[i]       = pctlMapSeq[i][1]; 
				}				
				copBC.splitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				
				for (int i=0;i<event.getTargetBkg().length;i++){
					BkgBlNoVO targetBkg = event.getTargetBkg()[i];
					
					//for performance report
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");		
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");				
					
					// before bdr , Booking status recalculation
					if(bdrFlag.equals("Y")){
						// After bdr 
						bkgCorrectionVO.setBkgNo(targetBkg.getBkgNo());
						//After BDR about split new Bkgfirst c/a(dummy)
						if (!event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							add1stCaHist(targetBkg);
						}
					}
					
					//In case of VVD is changed
					log.debug("\nbkg:"+targetBkg.getBkgNo()+",tVvd:"+splitBkgVO.getSplitBlInfoVO().get(i).getTvvd()
							+ "\nroute String:"+splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute());	
					if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null 
						&& splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute().length()>10){
						
						//PrdMainInfoVO Set
						PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd("3");
						prdMainInfoVO.setPcMode("R");
						prdMainInfoVO.setTVvd (splitBkgVO.getSplitBlInfoVO().get(i).getTvvd());
						prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO();
						prdParameterVO.setBkgBlNoVO(targetBkg);
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
						prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
						
						PrdMainInfoVO rtnPrdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
						util.resetNthRoute(rtnPrdMainInfoVO, 1);
						util.resetNthRoute(rtnPrdMainInfoVO, 2);
						util.resetNthRoute(rtnPrdMainInfoVO, 3);
						util.resetNthRoute(rtnPrdMainInfoVO, 4);
						rtnPrdMainInfoVO.setOrgTrnsMode("");
						rtnPrdMainInfoVO.setDestTrnsMode("");
						
						String rtnRoute = splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute();
						String [] rtnRouteVvds = util.splitByToken(rtnRoute, ",");
						for(int j=0;j<rtnRouteVvds.length;j++){
							if(rtnRouteVvds[j].length()==0) break;
							String [] rtnRouteInfo = util.splitByToken(rtnRouteVvds[j], "|");
							log.debug("\npol:"+rtnRouteInfo[0]+"/polYd:"+rtnRouteInfo[1]+"/pol_clpt:"+rtnRouteInfo[6]+
									   "/pod:"+rtnRouteInfo[2]+"/podYd:"+rtnRouteInfo[3]+"/pod_clpt:"+rtnRouteInfo[7] +
									   "/vvd:"+rtnRouteInfo[4]+"/lane:"+rtnRouteInfo[5]);
							if(j==0){
								rtnPrdMainInfoVO.setPol1 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol1N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol1C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod1 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod1N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod1C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd1 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane1(rtnRouteInfo[5]);
							} else if(j==1){
								rtnPrdMainInfoVO.setPol2 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol2N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol2C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod2 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod2N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod2C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd2 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane2(rtnRouteInfo[5]);
							} else if(j==2){
								rtnPrdMainInfoVO.setPol3 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol3N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol3C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod3 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod3N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod3C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd3 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane3(rtnRouteInfo[5]);
							} else if(j==3){
								rtnPrdMainInfoVO.setPol4 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol4N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol4C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod4 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod4N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod4C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd4 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane4(rtnRouteInfo[5]);
							}
						}
						CodEtcVO codEtcVO = codBC.searchCodSplitRoute(sourceBkg, codRqstSeq);
						rtnPrdMainInfoVO.setPod (codEtcVO.getNewPodCd());
						rtnPrdMainInfoVO.setPodN(codEtcVO.getNewPodCd() + codEtcVO.getNewPodNodCd());
						rtnPrdMainInfoVO.setDel (codEtcVO.getNewDelCd());
						rtnPrdMainInfoVO.setDelN(codEtcVO.getNewDelCd() + codEtcVO.getNewDelNodCd());
						rtnPrdMainInfoVO.setDelT(codEtcVO.getNewDeTermCd());
						rtnPrdMainInfoVO.setDestTrnsMode("");
						prdParameterVO.setPrdMainInfoVO(rtnPrdMainInfoVO);
						util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

						// 12. createProdCtlRoute
						String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
						String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
						
						targetBkg.setPctlNo(pctlNoMapSeq[0]);
						targetBkg.setMapSeq(pctlNoMapSeq[1]);						

						//	 old vvd retrieve about vvd changing
						histTableVO = new HistoryTableVO();
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							histTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0997", targetBkg);
						}
						
						// real vvd changing
						receiptBC.modifyBookingFromCod(targetBkg, sourceBkg, event.getCodRqstSeq(), account);
												
						//second replan reflection in cop
						copBC.updateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
					}//In case of VVD is changed �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄괩�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�

					// Before bdr , Booking status recalculation
					if(bdrFlag.equals("N")){
						receiptBC.changeBkgStatus("Y",targetBkg, false, account);
					}

					// auto c/a process
					if(bdrFlag.equals("Y")){						
						// In case of vvd is changed
						if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null){
							bkgCorrectionVO.setRoutCorrFlg("Y");
							bkgCorrectionVO.setTrnkVslCorrFlg("Y");
						}
						
						if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							bdrBC.addAutoCaTemp(sourceBkg, "SPLIT_MASTER", bkgCorrectionVO, account);
						} else {
							bdrBC.addAutoCaTemp(targetBkg, "SPLIT_NEW", bkgCorrectionVO, account);
						}
						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(event.getCaRsnCd(), event.getCaRemark(), targetBkg, "N", "Y");
						targetBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						event.getTargetBkg()[i].setCaNo(corrBkgBlNoVO.getCaNo());
						
						bdrBC.removeCATemp(targetBkg);

						blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);
			            //add2. 
						OblIssVO oblIssVO = util.searchOblIssue(targetBkg); 
						
						//add2. 
						RevDrNoteVO        revDrNoteVO    = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (targetBkg.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (targetBkg.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);

						RevenueDebitNoteBC revenueDebitNoteBC = new RevenueDebitNoteBCImpl();
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
						
						//add2. 
						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						CargoReleaseOrderBC cargoReleaseOrderBC = new CargoReleaseOrderBCImpl();
						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}
					} else {
						targetBkg.setCaNo("");
					}// auto c/a process end

					// history process
					HistoryLineVO historyLineVO = new HistoryLineVO();
					
					historyLineVO.setBkgNo (targetBkg.getBkgNo());
					historyLineVO.setCorrNo(targetBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0997");
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						historyLineVO.setCrntCtnt("Cod split into :"+splitToBkgNoStr);		
						historyLineVO.setBkgDocProcTpCd("BKGSPT");
					} else {
						historyLineVO.setCrntCtnt("Cod split from BKG No :"+sourceBkg.getBkgNo()); //new -> Splited from BKG No : %, old -> Splited.
					}
					historyLineVO.setHisCateNm("COD SPLIT");			
					historyBC.createBkgHistoryLine (historyLineVO,account);
					
					//	 history about vvd changing
					if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null 
								&& splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute().length()>10
								&& !orgTvvd.equals(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd())){
							histTableVO.getBkgBlNoVO().setCaNo(targetBkg.getCaNo());
							historyBC.manageBookingHistory("ESM_BKG_0997", histTableVO, account);
						}
					}
					if(cntrHistStr[i].length()>0){
						// histiry about cntr
						historyLineVO.setCrntCtnt(cntrHistStr[i]); 
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							historyLineVO.setPreCtnt(preCntrHistStr);
						} 
						historyLineVO.setHisCateNm("Container No.");						
						historyBC.createBkgHistoryLine (historyLineVO,account);					
						historyBC.releaseCntrFinalConfirm(targetBkg, account);
						// history process end
					}
				}

				//In case of memo split, history of master bkg
				if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){
					HistoryLineVO historyLineVO = new HistoryLineVO();
				
					historyLineVO.setBkgNo (sourceBkg.getBkgNo());
					historyLineVO.setCorrNo(sourceBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0997");
					historyLineVO.setCrntCtnt("Memo Split into :"+splitToBkgNoStr);		
					historyLineVO.setBkgDocProcTpCd("BKGSPT");
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
				}

				//interface coa
				for (int i=0;i<event.getTargetBkg().length;i++){
					interfaceToCoa(event.getTargetBkg()[i], "Booking Cod Split", account);
				}

//				codBC.modifyCodStatus(sourceBkg, codRqstSeq, "F", "", account);
				commit();
				
				begin();
				for (int i=0;i<event.getTargetBkg().length;i++){	
					// invoice interface
					interfaceToInv(event.getTargetBkg()[i], account);					
				}		
				commit();
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
			}
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	
	/**
	 * ESM_BKG_9450 : retrieve <br>
	 * Container No List in Empty Repo Bkg retrieve<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchEmptyCntrByBKG(Event e) throws EventException{
		try{
			EsmBkg9450Event event = (EsmBkg9450Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<CntrInfoForEmptyVO> list =  command.searchEmptyCntrByBKG(event.getBkgBlNoVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	

	/**
	 * ESM_BKG_0654 : open <br>
	 * All Service Scope�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲�뇡遺얠맋占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇瑗삼옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈뙑�⑤슦�젾 Name retrieve <br>
	 * Rfa List retrieve<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchSvcScp(Event e) throws EventException{
		try{
			EsmBkg0654Event event = (EsmBkg0654Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<MdmSvcScpVO> svcScpList =  command.searchSvcScp();
			List<RfaListVO> rfaList =  command.searchRfaList(event.getRfaListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(svcScpList);		
			eventResponse.setRsVoList(rfaList);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0654 : retrieve <br>
	 * ship owner contract's RFA占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�릮etrieve <br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchRfaList(Event e) throws EventException{
		try{
			EsmBkg0654Event event = (EsmBkg0654Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<RfaListVO> list =  command.searchRfaList(event.getRfaListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	

	/**
	 * ESM_BKG_0654 : retrieve <br>
	 * ship owner contract's  S/C占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�릮etrieve<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchScList(Event e) throws EventException{
		try{
			EsmBkg0655Event event = (EsmBkg0655Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<ScListVO> list =  command.searchScList(event.getScListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}		

	/**
	 * ESM_BKG_0656 : retrieve <br>
	 * contract's RFA  Commodity retrieve <br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCmdtByRfa(Event e) throws EventException{
		try{
			EsmBkg0656Event event = (EsmBkg0656Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<RfaCmdtListVO> list = command.searchCmdtByRfa(event.getRfaListInputVO(), event.getCmdtNm(), event.getCmdtCd(), event.getUiNm());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		

	/**
	 * ESM_BKG_0657 : retreive <br>
	 * contract in S/C Commodity retrieve <br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCmdtBySc(Event e) throws EventException{
		try{
			EsmBkg0657Event event = (EsmBkg0657Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<ScCmdtListVO> list = command.searchCmdtBySc(event.getScListInputVO(), event.getCmdtNm(), event.getCmdtCd(), event.getSvcScpCd(), event.getUiId());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}	
	
	/**
	 * ESM_BKG_0079_02B : cntr_no change <br>
	 * containers type/size retrieve<br>
	 * @author	
	 * @param 	e Event
	 * @return  eventResponse EventResponse
	 * @exception 	EventException
	 */
    private EventResponse searchTypeSizeByCntr(Event e) throws EventException {
    	EsmBkg007902bEvent event = (EsmBkg007902bEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();        
        BookingUtil command = new BookingUtil();
        
        try {
        	String cntrNo     = event.getCntrNo();
        	String cntrTpszCd = "";
            List<MstContainerVO> list = command.searchTypeSizeByCntr(cntrNo); 
    		if(list.size() > 0){
    			cntrTpszCd = JSPUtil.getNullNoTrim(list.get(0).getCntrTpszCd());
    		}
			eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_0079_05 : retrieve <br>
	 * Customer Information information retrieve.<br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlDocCust(Event e) throws EventException {
		try{
			EsmBkg007905Event event = (EsmBkg007905Event)e;
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingUtil bookingUtil = new BookingUtil();	

			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			
			// 01. Combo data retrieve (Shipper FF)
			List<BkgComboVO> ffShiper  = bookingUtil.searchCombo("CD02125");			
			eventResponse.setRsVoList(ffShiper);
			
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			
			// 02. Customer Information information retrieve
			BlCustomerVO blCustomerVO = receiptBC.searchBlDocCust(event.getBkgBlNoVO());
			CustEtcVO custEtcVO = new CustEtcVO();
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			if(blCustomerVO != null){
				BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();
				custEtcVO = blCustomerVO.getCustEtcVO();
				bkgBlNoVO = blCustomerVO.getBkgBlNoVO();
				if(bkgBlNoVO != null){
					eventResponse.setETCData(bkgBlNoVO.getColumnValues());
					// Usr is a different c / a to proceed If you retrieve regular mode
					if(!bkgBlNoVO.getCaUsrId().equals(account.getUsr_id())){
						eventResponse.setETCData("ca_flg", "N");
					}
				}			
				if(blDocCustVO != null){
					eventResponse.setETCData(blDocCustVO.getColumnValues());
				}	
				if(custEtcVO != null){
					eventResponse.setETCData(custEtcVO.getColumnValues());
				}

				// original BL No
				String orgBlNo = "";
				if(blCustomerVO.getSplitMstBlNoVO() != null){
					orgBlNo = blCustomerVO.getSplitMstBlNoVO().getBlNo();
				}
				eventResponse.setETCData("OrgBlNo",orgBlNo);		
				
			}else{
				// No data found.
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
				eventResponse.setETCData("DataYn", "N");
			}		
			
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}    

	/**
	 * ESM_BKG_0079_05 : cust_cnt_cd, cust_seq change <br>
	 *Mdm Customer CustName as  CustCntCd and CustSeq retrieve<br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCustNm(Event e) throws EventException {
		try{
			EsmBkg007905Event event = (EsmBkg007905Event)e;
			BookingUtil bookingUtil = new BookingUtil();

			MdmCustVO mdmCustVO = bookingUtil.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(mdmCustVO != null){
				eventResponse.setETCData("cust_nm",mdmCustVO.getName());
				eventResponse.setETCData("cust_addr",mdmCustVO.getAddress());
				eventResponse.setETCData("frt_fwrd_fmc_no",mdmCustVO.getFrtFwrdFmcNo());
				eventResponse.setETCData("cust_tp",mdmCustVO.getCustTpCd());
				eventResponse.setETCData("rvis_cntr_cust_tp_cd",mdmCustVO.getCntrCustTpCd());
			}else{
				eventResponse.setETCData("cust_nm","");
				eventResponse.setETCData("cust_addr","");
				eventResponse.setETCData("frt_fwrd_fmc_no","");
				eventResponse.setETCData("cust_tp","");
				eventResponse.setETCData("rvis_cntr_cust_tp_cd","");
			}
		
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_0079_05 : SEARCH01 serach xter customer name and adress over flow information <br>
	 * serach xter customer name and adress over flow status information<br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterCustOvrLenFlgStatus(Event e) throws EventException {
		try{
			EsmBkg007905Event event = (EsmBkg007905Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			
			XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO = new XterCustOvflwFlgStatusVO() ;
			xterCustOvflwFlgStatusVO = receiptBC.searchXterCustOvrLenFlgStatus(event.getXterCustOvflwFlgStatusVO());
			eventResponse.setRsVo(xterCustOvflwFlgStatusVO);
		
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	

	/**
	 * ESM_BKG_0079_05 : save <br>
	 * Customer Information information modifying.<br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBlDocCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007905Event event = (EsmBkg007905Event)e;
		try{
			begin();		
			
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC 	searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBC 	= new BLDocumentationBLBCImpl();
			BlRatingBC				ratingBC	= new BlRatingBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();

			BkgBlNoVO bkgBlNoVO       = event.getBkgBlNoVO();
			XterCustOvflwFlgStatusVO xterCustOvflwFlgStatusVO = event.getXterCustOvflwFlgStatusVO();
			
			BlCustomerVO blCustomerVO = new BlCustomerVO();
			blCustomerVO.setBkgBlNoVO  (bkgBlNoVO);
			blCustomerVO.setBlDocCustVO(event.getBlDocCustVO());
			blCustomerVO.setCustEtcVO  (event.getCustEtcVO());			
			boolean ibCustCdVal = false;
			String bkgNo = bkgBlNoVO.getBkgNo();
						
			// 10. validationBlDocCust process
			String[] alertMsg = receiptBC.validateBlDocCust(blCustomerVO);
			
			// 18. searchOldBkgForHistory process
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0079_05", bkgBlNoVO);
			
			//by kimtaekyun 2016.03.30. BKG_INV_TAX_IF 占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈윪占쎄텑
			List<BkgCustomerVO> tmpOldCustomers = historyTableVO.getBkgCustomerVOs();
			String sCustCdOld = "";
			String sCustCd = "";
			String cCustCdOld = "";
			String cCustCd = "";
			String fCustCdOld = "";
			String fCustCd = "";

			if(tmpOldCustomers != null){
				for(int i=0;i<tmpOldCustomers.size();i++){
					if("S".equals(tmpOldCustomers.get(i).getBkgCustTpCd())){
						sCustCdOld = tmpOldCustomers.get(i).getCustCntCd() + tmpOldCustomers.get(i).getCustSeq();
					}else if("C".equals(tmpOldCustomers.get(i).getBkgCustTpCd())){
						cCustCdOld = tmpOldCustomers.get(i).getCustCntCd() + tmpOldCustomers.get(i).getCustSeq();
					}else if("F".equals(tmpOldCustomers.get(i).getBkgCustTpCd())){
						fCustCdOld = tmpOldCustomers.get(i).getCustCntCd() + tmpOldCustomers.get(i).getCustSeq();
					}
				}
			}
			
			log.debug(sCustCdOld+"/"+cCustCdOld+"/"+fCustCdOld);
			
			boolean shFlag = true;
			sCustCd = event.getBlDocCustVO().getShCustCntCd() + event.getBlDocCustVO().getShCustSeq();
			if(sCustCd != null && sCustCd.length() > 0){
				if(sCustCd.equals(sCustCdOld)) shFlag = false;
			} else {
				if(sCustCdOld == null || sCustCdOld.length() < 1) shFlag = false;
			}

			boolean cnFlag = true;
			cCustCd = event.getBlDocCustVO().getCnCustCntCd() + event.getBlDocCustVO().getCnCustSeq();
			if(cCustCd != null && cCustCd.length() > 0){
				if(cCustCd.equals(cCustCdOld)) cnFlag = false;
			} else {
				if(cCustCdOld == null || cCustCdOld.length() < 1) cnFlag = false;
			}

			boolean fwFlag = true;
			fCustCd = event.getBlDocCustVO().getFfCustCntCd() + event.getBlDocCustVO().getFfCustSeq();
			if(fCustCd != null && fCustCd.length() > 0){
				if(fCustCd.equals(fCustCdOld)) fwFlag = false;
			} else {
				if(fCustCdOld == null || fCustCdOld.length() < 1) fwFlag = false;
			}
			if(shFlag || fwFlag || cnFlag){
				StringBuffer remarkSbr = new StringBuffer("BKG|");
				if(shFlag){
					remarkSbr.append("|SHPR/OLD:").append(sCustCdOld).append("/NEW:").append(sCustCd);
				}
				if(fwFlag){
					remarkSbr.append("|FWDR/OLD:").append(fCustCdOld).append("/NEW:").append(fCustCd);
				}
				if(cnFlag){
					remarkSbr.append("|CNEE/OLD:").append(cCustCdOld).append("/NEW:").append(cCustCd);
				}
				
				BkgChgRateVO bkgChgRateVO = new BkgChgRateVO();
				bkgChgRateVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgChgRateVO.setIfRmk(remarkSbr.toString());
				receiptBC.addBkgInvTaxIF(bkgChgRateVO, account);
			}
			
			OfcChgProcVO ofcChgProcVO = new OfcChgProcVO();
			ofcChgProcVO.setType("C");  //customer
			ofcChgProcVO.setCaFlg(bkgBlNoVO.getCaFlg());
			ofcChgProcVO.setBkgNo(bkgNo);
			ofcChgProcVO.setCustToOrdFlg(event.getCustEtcVO().getCustToOrdFlg());
			ofcChgProcVO.setShCustCntCd(event.getBlDocCustVO().getShCustCntCd());
			ofcChgProcVO.setShCustSeq(event.getBlDocCustVO().getShCustSeq());
			ofcChgProcVO.setCnCustCntCd(event.getBlDocCustVO().getCnCustCntCd());
			ofcChgProcVO.setCnCustSeq(event.getBlDocCustVO().getCnCustSeq());
			ofcChgProcVO.setNfCustCntCd(event.getBlDocCustVO().getNfCustCntCd());
			ofcChgProcVO.setNfCustSeq(event.getBlDocCustVO().getNfCustSeq());
			ofcChgProcVO = (new BookingUtil()).searchOfcChgProc(ofcChgProcVO);

			// 20. modifyBlDocCust process
			receiptBC.modifyBlDocCust(blCustomerVO, "M", account);
			
			// 23. modifyBkgBlDocByCust process
			
			log.debug("oldcustCd = "+ event.getOldActCustCd());
			log.debug("newcustCd = "+ event.getNewActCustCd());
			blDocBC.modifyBkgBlDocByCust(bkgBlNoVO, event.getCustEtcVO().getOrgCntNm(), account, event.getOldActCustCd(), event.getNewActCustCd());			

			// cnee init input in customer 
			for(int i=0;i<historyTableVO.getBkgCustomerVOs().size();i++){
				List<BkgCustomerVO> oldCustVOs = historyTableVO.getBkgCustomerVOs();
				if("C".equals(oldCustVOs.get(i).getBkgCustTpCd())){ //cnee
					if(isNull(oldCustVOs.get(i).getCustCntCd())&&isNull(oldCustVOs.get(i).getCustSeq())// were not in the old
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustSeq())){// If you enter a new judge to the new consignee
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgNo);
						bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee input for doc performance		
						historyBC.manageDocProcess(bkgDocProcSkdVO, account);
					}					
					if(!isNull(oldCustVOs.get(i).getCustCntCd())&&!isNull(oldCustVOs.get(i).getCustSeq())// were in the old
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustSeq())// were in the new
						//If they are different
						&&(!oldCustVOs.get(i).getCustCntCd().equals(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							||!oldCustVOs.get(i).getCustSeq().equals(blCustomerVO.getBlDocCustVO().getCnCustSeq()))){
						ibCustCdVal = true;
					}					
				}
				if(false==ibCustCdVal&&"N".equals(oldCustVOs.get(i).getBkgCustTpCd())){ //cnee
					if(!isNull(oldCustVOs.get(i).getCustCntCd())&&!isNull(oldCustVOs.get(i).getCustSeq())// were in the old
							&&!isNull(blCustomerVO.getBlDocCustVO().getNfCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getNfCustSeq())// were in the new
						//If they are different
						&&(!oldCustVOs.get(i).getCustCntCd().equals(blCustomerVO.getBlDocCustVO().getNfCustCntCd())
							||!oldCustVOs.get(i).getCustSeq().equals(blCustomerVO.getBlDocCustVO().getNfCustSeq()))){
						ibCustCdVal = true;
					}	
				}
			}
			
			//xter cust over flow update
			
			int xterCustTpListNum = 0;
			if(xterCustOvflwFlgStatusVO.getShOvflwChkFlg().equals("Y")){
				xterCustTpListNum = xterCustTpListNum +1;
			}
			if(xterCustOvflwFlgStatusVO.getCnOvflwChkFlg().equals("Y")){
				xterCustTpListNum = xterCustTpListNum +1;
			}
			if(xterCustOvflwFlgStatusVO.getNfOvflwChkFlg().equals("Y")){
				xterCustTpListNum = xterCustTpListNum +1;
			}
			if(xterCustOvflwFlgStatusVO.getFfOvflwChkFlg().equals("Y")){
				xterCustTpListNum = xterCustTpListNum +1;
			}
			if(xterCustOvflwFlgStatusVO.getAnOvflwChkFlg().equals("Y")){
				xterCustTpListNum = xterCustTpListNum +1;
			}
			if(xterCustOvflwFlgStatusVO.getExOvflwChkFlg().equals("Y")){
				xterCustTpListNum = xterCustTpListNum +1;
			}
			
			if(xterCustTpListNum > 0){
				String [] xterCustTpList = new String[xterCustTpListNum];
				int xterCustTpListSetNum = 0;
				if(xterCustOvflwFlgStatusVO.getShOvflwChkFlg().equals("Y")){
					xterCustTpList[xterCustTpListSetNum] = "S";
					xterCustTpListSetNum = xterCustTpListSetNum +1;
				}
				if(xterCustOvflwFlgStatusVO.getCnOvflwChkFlg().equals("Y")){
					xterCustTpList[xterCustTpListSetNum] = "C";
					xterCustTpListSetNum = xterCustTpListSetNum +1;
				}
				if(xterCustOvflwFlgStatusVO.getNfOvflwChkFlg().equals("Y")){
					xterCustTpList[xterCustTpListSetNum] = "N";
					xterCustTpListSetNum = xterCustTpListSetNum +1;
				}
				if(xterCustOvflwFlgStatusVO.getFfOvflwChkFlg().equals("Y")){
					xterCustTpList[xterCustTpListSetNum] = "F";
					xterCustTpListSetNum = xterCustTpListSetNum +1;
				}
				if(xterCustOvflwFlgStatusVO.getAnOvflwChkFlg().equals("Y")){
					xterCustTpList[xterCustTpListSetNum] = "A";
					xterCustTpListSetNum = xterCustTpListSetNum +1;
				}
				if(xterCustOvflwFlgStatusVO.getExOvflwChkFlg().equals("Y")){
					xterCustTpList[xterCustTpListSetNum] = "E";
					xterCustTpListSetNum = xterCustTpListSetNum +1;
				}
				receiptBC.modifyXterCustOverFlowStatus(xterCustOvflwFlgStatusVO, xterCustTpList, account);
			}

			// prepaid collect payer modifying
			ratingBC.modifyRateCntCd(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());
			
			if ("Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgPpdProc()) || "Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgCctProc())) {
				BkgModiOfcPrcVO bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
				bkgModiOfcPrcVO.setInBkgNo(bkgNo);
				bkgModiOfcPrcVO.setInCaFlg(bkgBlNoVO.getCaFlg());
				bkgModiOfcPrcVO.setInPpdFlg(ofcChgProcVO.getOfcChgPpdProc());
				bkgModiOfcPrcVO.setInCctFlg(ofcChgProcVO.getOfcChgCctProc());
				(new BlRatingBCImpl()).callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
			}

			historyBC.manageBookingHistory("ESM_BKG_0079_05", historyTableVO, account);
			
			// c / a is in progress, i / b arrival notice does not update the value of the relevant
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				// i/b code validation initialization
				if(ibCustCdVal){
					receiptBC.cancelCustCdVal(bkgNo);					
					ArrivalNoticeBC anBC = new ArrivalNoticeBCImpl();
					anBC.cancelArrNtcCustCdVal(bkgNo);
				}
			}
			
			//

			commit();

			// c / a is in progress, i / b arrival notice does not update the value of the relevant
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){	
				begin();
				// CNHKG exception
				if(!"CNHKG".equals(event.getCustEtcVO().getPolCd())){
//					if(bkgNo.length() > 12 || (bkgNo.length() == 12 && !"00".equals(bkgNo.substring(11)))){
						// 13. sendBkgTmlEdi
						// 20091127 BackEndJob�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌쓨占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲�젆�룇�뒻占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿占쎌녇占쎄틓占쎈뮛占쎌뵗�뜝�럥�몡嶺뚮�⑸걙占쎄뎡癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥獒뺤떣�삕占쎌맶�뜝�럥�쑅�뜝�럥�뱜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쎈뭼�뜝�럥�떛�뜝�럥�맄�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐댐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥壤쏉옙占쎌녇占쎄틓占쎈뮛占쎌뵗占쎈쐻占쎈윥占쎈즶�뜝�럥�맶�뜝�럥�쑋�뜝�럡���뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럩紐㏆옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�뜝�럥占폺hanging
						Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
						vender301ParamVO.setOldVvdVOs(null);
						vender301ParamVO.setOldQtyVOs(null);
						vender301ParamVO.setOldMtyPkupYdCd(null);
						vender301ParamVO.setBracCd("U");
						vender301ParamVO.setEdiKind("BT");
						vender301ParamVO.setAutoManualFlg("Y");
					
						searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);	
//						searchBC.createTmlBkgReceiptEdiBackEnd(bkgBlNoVO, null, "U", "BT", "Y", account);					
//					}
				}
				// interfaceBkgARInvoiceToINV calling
				interfaceToInv(bkgBlNoVO, account);
				commit();
			}
			
			if(alertMsg != null && alertMsg.length > 0){
				for(int i = 0 ; i < alertMsg.length ; i++){
					eventResponse.setUserMessage(new ErrorHandler(alertMsg[i]).getUserMessage());		
				}
			}
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * ESM_BKG_0890 : open <br>
	 * Cargo Detail Information retrieve <br>)
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgQtyDtl(Event e) throws EventException{
		try{
			EsmBkg0890Event event = (EsmBkg0890Event)e;
			
			BookingUtil utilBC = new BookingUtil();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			
			// 01. Combo data retrieve (RTerm)
			List<BkgComboVO> rTterm  = utilBC.searchCombo("CD02192");
			eventResponse.setRsVoList(rTterm);
			// 02. Combo data retrieve (DTerm)
			List<BkgComboVO> dTerm  = utilBC.searchCombo("CD02191");		
			eventResponse.setRsVoList(dTerm);				
			
			// 03. Cargo Detail Information retrieve
			CargoDetailVO cargeDetailVO = receiptBC.searchCargoDetail(event.getBkgBlNoVO());
			
			List<BkgQuantityVO> bkgQuantity = cargeDetailVO.getBkgQuantity();
			List<BkgQtyDtlVO> bkgQtyDtl = cargeDetailVO.getBkgQtyDtl();
			CargoDtlEtcVO cargoDtlEtcVO = cargeDetailVO.getCargoDtlEtcVO();
			
			eventResponse.setRsVoList(bkgQtyDtl);
			
			if(!"B".equals(event.getCallTp())){
				eventResponse.setRsVoList(bkgQuantity);

				if(cargoDtlEtcVO != null){
					eventResponse.setETCData(cargoDtlEtcVO.getColumnValues());	
				}					
			}

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		

	/**
	 * ESM_BKG_0890 : save <br>
	 * Cargo Detail Information Save <br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgQtyDtl(Event e) throws EventException{
		EsmBkg0890Event event = (EsmBkg0890Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try{
			begin();			
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			// 9. searchOldBkgForHistory
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0890", event.getBkgBlNoVO());
			
			// 10. manageBkgQtyDtl
			receiptBC.manageBkgQtyDtl(event.getBkgQtyDtlVOs(), event.getBkgBlNoVO(), account);
			
			// 13. manageBookingHistory
			historyBC.manageBookingHistory("ESM_BKG_0890", historyTableVO, account);

			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0732 : open <br>
	 * BKG container retrieve<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCntrListForCombine(Event e) throws EventException{
		EsmBkg0732Event event = (EsmBkg0732Event)e;
		GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CntrListForCombineVO> list =  command.searchCntrListForCombine(event.getBkgBlNoVO());			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		
		return eventResponse;
	}		

	/**
	 * ESM_BKG_0974 : retrieve <br>
	 * Combine Booking List retrieve<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForMstBkgSelect(Event e) throws EventException{
		try{
			EsmBkg0974Event event = (EsmBkg0974Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<BkgListForMstBkgSelectVO> list =  command.searchBkgListForMstBkgSelect(event.getBkgBlNoVOs());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
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

	/**
	 * ESM_BKG_0614 : RETRIEVE <br>
	 * Booking list retrieve(ESM_BKG_0614)<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForWorkWithBkg(Event e) throws EventException{
		try{
			EsmBkg0614Event event = (EsmBkg0614Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputTmpVO = event.getBkgListForWorkWithBkgInputVO();
			BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO = new BkgListForWorkWithBkgInputVO();
			
//			bkgListForWorkWithBkgInputVO.setBroKenRoute(bkgListForWorkWithBkgInputTmpVO.getBroKenRoute());
			if ( !isNull(event.getBkgListForWorkWithBkgInputVO().getBkgNo()) ) {
	        	bkgListForWorkWithBkgInputVO.setBkgNo(bkgListForWorkWithBkgInputTmpVO.getBkgNo());
			} else if ( !isNull(event.getBkgListForWorkWithBkgInputVO().getMultBkgNo()) ) {
		        bkgListForWorkWithBkgInputVO.setMultBkgNo(bkgListForWorkWithBkgInputTmpVO.getMultBkgNo());
	        } else {
	        	bkgListForWorkWithBkgInputVO = bkgListForWorkWithBkgInputTmpVO;
	        }
	
			List<BkgListForWorkWithBkgVO> list = command.searchBkgListForWorkWithBkg(bkgListForWorkWithBkgInputVO);
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
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

	/**
	 * ESM_BKG_0098 : retrieve <br>
	 *  Booking list for booking receipt sending retrieve<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForBkgReceiptNtc(Event e) throws EventException{		
		try{
			EsmBkg0098Event event = (EsmBkg0098Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			
		
			BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputTmpVO = event.getBkgListForBkgReceiptInputVO();
			BkgListForBkgReceiptInputVO bkgListForWorkWithBkgInputVO = new BkgListForBkgReceiptInputVO();
			if ( !isNull(event.getBkgListForBkgReceiptInputVO().getBkgNo()) ) {
				bkgListForWorkWithBkgInputVO.setBkgNo(bkgListForBkgReceiptInputTmpVO.getBkgNo());
			}else if ( !isNull(event.getBkgListForBkgReceiptInputVO().getMultBkgNo()) ) {
				bkgListForWorkWithBkgInputVO.setMultBkgNo(bkgListForBkgReceiptInputTmpVO.getMultBkgNo());
	        } else bkgListForWorkWithBkgInputVO = bkgListForBkgReceiptInputTmpVO;
	
			BkgReceiptListVO bkgReceiptListVO = command.searchBkgListForBkgReceiptNtc(bkgListForWorkWithBkgInputVO);
			List<BkgListForBkgReceiptVO> list = bkgReceiptListVO.getBkgListForBkgReceiptVOs();
			List<BkgListForBkgReceiptCntVO> cnt = bkgReceiptListVO.getBkgListForBkgReceiptCntVOs();
			
			eventResponse.setRsVoList(list);
	
		
			if (null!=cnt && 0<cnt.size()) {
				BkgListForBkgReceiptCntVO cntVO = cnt.get(0);
				eventResponse.setETCData("faxBkgTotal",cntVO.getFaxBkgTotal());
				eventResponse.setETCData("faxTotal"   ,cntVO.getFaxTotal());
				eventResponse.setETCData("faxSuccess" ,cntVO.getFaxSuccess());
				eventResponse.setETCData("faxSending" ,cntVO.getFaxSending());
				eventResponse.setETCData("faxUnSent"  ,String.valueOf(Integer.parseInt(cntVO.getFaxNoSend())+Integer.parseInt(cntVO.getFaxFailed()))
						                              +" (No Send : "+cntVO.getFaxNoSend()+" / Failed : "+cntVO.getFaxFailed()+")");
				eventResponse.setETCData("emlBkgTotal",cntVO.getEmlBkgTotal());
				eventResponse.setETCData("emlTotal"   ,cntVO.getEmlTotal());
				eventResponse.setETCData("emlSuccess" ,cntVO.getEmlSuccess());
				eventResponse.setETCData("emlSending" ,cntVO.getEmlSending());
				eventResponse.setETCData("emlUnSent"  ,String.valueOf(Integer.parseInt(cntVO.getEmlNoSend())+Integer.parseInt(cntVO.getEmlFailed()))
													  +" (No Send : "+cntVO.getEmlNoSend()+" / Failed : "+cntVO.getEmlFailed()+")");
			} else {
				eventResponse.setETCData("faxBkgTotal","0");
				eventResponse.setETCData("faxTotal"   ,"0");
				eventResponse.setETCData("faxSuccess" ,"0");
				eventResponse.setETCData("faxSending" ,"0");
				eventResponse.setETCData("faxUnSent"  ,"0 (No Send : 0 / Failed : 0)");
				eventResponse.setETCData("emlBlTotal" ,"0");
				eventResponse.setETCData("emlTotal"   ,"0");
				eventResponse.setETCData("emlSuccess" ,"0");
				eventResponse.setETCData("emlSending" ,"0");
				eventResponse.setETCData("emlUnSent"  ,"0 (No Send : 0 / Failed : 0)");
			}
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

	private boolean isNull(String str) {
        return (str==null || str.trim().length()==0 || "null".equals(str));
    }

	/**
	 * ESM_BKG_0098 : fax <br>
	 * send Booking list 5005RD in FAX<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgReceiptByFax(Event e) throws EventException {
		EsmBkg0098Event event = (EsmBkg0098Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
		BookingUtil util = new BookingUtil();
//		BkgClzTmVO bkgClzTmVO = null;
		BkgClzTmVO[] bkgClzTmVOs = null;
		HistoryTableVO historyTableVO = null;
//		String portCutOffUpdateFlg = "";
		List<SearchCutOffDateVO> cutOffDateVOs = null;
		String troCategoryCd = "";
		try{
			begin();
			BkgBlNoVO[] bkgBlNoVOs = event.getBkgBlNoVOs();
			if (bkgBlNoVOs.length > 0) {
				String[] newCct = new String[event.getCct().length];
				for (int i=0; i<bkgBlNoVOs.length; i++) {
					bkgBlNoVOs[i].setCaFlg("N");

//					bkgClzTmVOs = new BkgClzTmVO[2];
//					bkgClzTmVO = new BkgClzTmVO();
//					bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
//					bkgClzTmVO.setClzTpCd("T");
//					bkgClzTmVO.setMnlSetDt(event.getCctMnl()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
//					bkgClzTmVO.setNtcFlg("Y");
//					bkgClzTmVO.setUpdUsrId(account.getUsr_id());
//					bkgClzTmVOs[0] = bkgClzTmVO;
//
//					bkgClzTmVO = new BkgClzTmVO();
//					bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
//					bkgClzTmVO.setClzTpCd("D");
//					bkgClzTmVO.setMnlSetDt(event.getDocCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
//					bkgClzTmVO.setNtcFlg("Y");
//					bkgClzTmVO.setUpdUsrId(account.getUsr_id());
//					bkgClzTmVOs[1] = bkgClzTmVO;

					//set manual updated CCT information into BkgClzTmVO[] about Full cargo CCTT, Port CCT, Doc CCT
					bkgClzTmVOs = manageManualCctDate(bkgBlNoVOs, event, i);

					historyTableVO = bkgHisCmd.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVOs[i]);
					
//					portCutOffUpdateFlg = "N";
					//Check whether Port Cut Off date will be updated or not to call TRO module 
//					portCutOffUpdateFlg = command2.searchPortCutOffChange(bkgClzTmVOs);

					//Keep Port cut-off date and Cargo cut-off date before update
					cutOffDateVOs = command2.searchCutOffDate(bkgBlNoVOs[i].getBkgNo());

					command2.manageCargoClosingTime(bkgClzTmVOs, account);
					
					if(cutOffDateVOs != null){
						for(int j = 0; j<cutOffDateVOs.size();j++){
							//Check whether cut-off date is updated or not
							troCategoryCd = command2.searchCutOffDateChange(cutOffDateVOs.get(j));
							if(!"".equals(troCategoryCd)){
								// Call TRO module to notice the change of Cut-Off date
								util.interfaceToTrs(troCategoryCd, bkgBlNoVOs[i].getBkgNo(), "", "0", "0", "", account, "N", "0");
							}
						}
					}

//					if(portCutOffUpdateFlg.equals("Y")){ // Call TRO module to notice the change of Port Cut-Off date
//						interfaceToTrs("CUFF", bkgBlNoVOs[i].getBkgNo(), "", "0", "0", "", account);
//					}					
					bkgHisCmd.manageBookingHistory("ESM_BKG_0721", historyTableVO, account);
					
					if(!CheckUtilities.isNull(event.getCctMnl()[i])){
						newCct[i] = event.getCctMnl()[i];
					}else {
						newCct[i] = command2.serchSystemCargoClosingTime(bkgBlNoVOs[i].getBkgNo(), "T");
					}
				}
				BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
				bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
				bkgReceiptSendVO.setFaxNos(event.getFax());
				bkgReceiptSendVO.setRemarks(event.getRemark());
				bkgReceiptSendVO.setMrdNm(event.getMrdNm());
				bkgReceiptSendVO.setCcts(newCct);
				bkgReceiptSendVO.setDocCcts(event.getDocCct());
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgReceiptByFax(bkgReceiptSendVO, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0098");
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
		return eventResponse;
	}		

	/**
	 * ESM_BKG_0098 : email <br>
	 * send 5005RD in Booking list using Mail<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgReceiptByEmail(Event e) throws EventException {
		EsmBkg0098Event event = (EsmBkg0098Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
		GeneralBookingListSearchBC bkgListSearchCmd = new GeneralBookingListSearchBCImpl();
		BookingUtil util = new BookingUtil();
		BkgClzTmVO[] bkgClzTmVOs = null;
		BkgBlNoVO[] bkgBlNoVOs = null;
		HistoryTableVO historyTableVO = null;
		List<SearchCutOffDateVO> cutOffDateVOs = null;
		String troCategoryCd = "";
		try{
			begin();
			bkgBlNoVOs = event.getBkgBlNoVOs();
			if (bkgBlNoVOs.length > 0) { 
				String[] newCct = new String[event.getCct().length];
				for (int i=0; i<bkgBlNoVOs.length; i++) {
					bkgBlNoVOs[i].setCaFlg("N");

					//set manual updated CCT information into BkgClzTmVO[] about Full cargo CCTT, Port CCT, Doc CCT
					bkgClzTmVOs = manageManualCctDate(bkgBlNoVOs, event, i);

					historyTableVO = bkgHisCmd.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVOs[i]);
					
					//Keep Port cut-off date and Cargo cut-off date before update
					cutOffDateVOs = command2.searchCutOffDate(bkgBlNoVOs[i].getBkgNo());

					command2.manageCargoClosingTime(bkgClzTmVOs, account);
					
					if(cutOffDateVOs != null){
						for(int j = 0; j<cutOffDateVOs.size();j++){
							//Check whether cut-off date is updated or not
							troCategoryCd = command2.searchCutOffDateChange(cutOffDateVOs.get(j));
							if(!"".equals(troCategoryCd)){
								// Call TRO module to notice the change of Cut-Off date
								util.interfaceToTrs(troCategoryCd, bkgBlNoVOs[i].getBkgNo(), "", "0", "0", "", account, "N", "0");
							}
						}
					}
					
					bkgHisCmd.manageBookingHistory("ESM_BKG_0721", historyTableVO, account);
					
					if(!CheckUtilities.isNull(event.getCctMnl()[i])){
						newCct[i] = event.getCctMnl()[i];
					}else {
						newCct[i] = command2.serchSystemCargoClosingTime(bkgBlNoVOs[i].getBkgNo(), "T");
					}
				}
				BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
				bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
				bkgReceiptSendVO.setEmlAddrs(event.getEml());
				bkgReceiptSendVO.setRemarks(event.getRemark());
				bkgReceiptSendVO.setMrdNm(event.getMrdNm());
				bkgReceiptSendVO.setCcts(newCct);
				bkgReceiptSendVO.setDocCcts(event.getDocCct());
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgReceiptByEmail(bkgReceiptSendVO, account, "0098");
				if (null!=bkgNtcHisVOs && 0<bkgNtcHisVOs.size()) {
					bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0098");
				}
				//added the remark to the TRS_INTER_RMK
		    	String interRmkCtntRmk = "";

		    	for (int i=0; i<bkgBlNoVOs.length; i++) {
		    		if(event.getRmkChangeFlg()[i].equals("Y")){
			    		/* remark */
			    		if(!"".equalsIgnoreCase(event.getRemark()[i])){
			    			StringBuffer rmkBuffer = new StringBuffer();
			    			rmkBuffer.append("[Remark]");
			    			rmkBuffer.append(System.getProperty("line.separator"));
			    			String remark = URLDecoder.decode(event.getRemark()[i], "UTF-8");
			    			rmkBuffer.append(remark);
			    			interRmkCtntRmk = rmkBuffer.toString();
			    			/* remark */
			    			bkgListSearchCmd.addInternalRemark(bkgBlNoVOs[i].getBkgNo(),event.getBtnTp(), account, interRmkCtntRmk);
			    		}			    				
			    	}				
		    	}			
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
		return eventResponse;
	}		

	/**
	 * ESM_BKG_0098 : group email <br>
	 * send 5005RD in Booking list using Group Mail<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgReceiptByGroupEmail(Event e) throws EventException {
		EsmBkg0098Event event = (EsmBkg0098Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		BookingUtil util = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
		GeneralBookingListSearchBC bkgListSearchCmd = new GeneralBookingListSearchBCImpl();
//		BkgClzTmVO bkgClzTmVO = null;
		BkgClzTmVO[] bkgClzTmVOs = null;
		HistoryTableVO historyTableVO = null;
//		String portCutOffUpdateFlg = "";
		List<SearchCutOffDateVO> cutOffDateVOs = null;
		String troCategoryCd = "";
		try{
			begin();
			BkgBlNoVO[] bkgBlNoVOs = event.getBkgBlNoVOs();
			if (bkgBlNoVOs.length > 0) {
				for (int i=0; i<bkgBlNoVOs.length; i++) {
					bkgBlNoVOs[i].setCaFlg("N");

					//set manual updated CCT information into BkgClzTmVO[] about Full cargo CCTT, Port CCT, Doc CCT
					bkgClzTmVOs = manageManualCctDate(bkgBlNoVOs, event, i);

					historyTableVO = bkgHisCmd.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVOs[i]);

					//Keep Port cut-off date and Cargo cut-off date before update
					cutOffDateVOs = command2.searchCutOffDate(bkgBlNoVOs[i].getBkgNo());

					command2.manageCargoClosingTime(bkgClzTmVOs, account);
					
					if(cutOffDateVOs != null){
						for(int j = 0; j<cutOffDateVOs.size();j++){
							//Check whether cut-off date is updated or not
							troCategoryCd = command2.searchCutOffDateChange(cutOffDateVOs.get(j));
							if(!"".equals(troCategoryCd)){
								// Call TRO module to notice the change of Cut-Off date
								util.interfaceToTrs(troCategoryCd, bkgBlNoVOs[i].getBkgNo(), "", "0", "0", "", account, "N", "0");
							}
						}
					}

					bkgHisCmd.manageBookingHistory("ESM_BKG_0721", historyTableVO, account);
				}
				BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
				bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
				bkgReceiptSendVO.setEmlAddrs(event.getEml());
				bkgReceiptSendVO.setRemarks(event.getRemark());
				bkgReceiptSendVO.setMrdNm(event.getMrdNm());
				bkgReceiptSendVO.setBkgEmlEdtVo(event.getBkgEmlEdtVO());
				if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
					bkgReceiptSendVO.setCustBody(event.getCustBody());
				}
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgReceiptByGroupEmail(bkgReceiptSendVO, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0098");
				
				//added the remark or the content to the TRS_INTER_RMK
			    for (int i=0; i<bkgBlNoVOs.length; i++) {
		    		if("E".equals(event.getBtnTp()) ||"C".equals(event.getBtnTp())){
			    		
		    			/* content */
		    			String content = "";
		    			if("C".equals(event.getBtnTp())){
		    				content = event.getCustBody().replaceAll("<.+?>", "").replace("&nbsp;", "");
		    			} else if("E".equals(event.getBtnTp())){
		    				content = event.getBkgEmlEdtVO().getEdtContents().replaceAll("<.+?>", "").replace("&nbsp;", "");
		    			}
		    			if(content != null && !"".equalsIgnoreCase(content.replace("\n", "").replace("\t", ""))){
		    				String interRmkCtntCtnt = "";
		    				StringBuffer rmkBuffer = new StringBuffer();
		    				rmkBuffer.append("[Content]");
		    				rmkBuffer.append(System.getProperty("line.separator"));
		    				rmkBuffer.append(content);
		    				interRmkCtntCtnt = rmkBuffer.toString();
		    				/* content */
		    				bkgListSearchCmd.addInternalRemark(bkgBlNoVOs[i].getBkgNo(),event.getBtnTp(), account, interRmkCtntCtnt);			    		
		    			}
		    		}
			    
			    	if(event.getRmkChangeFlg()[i].equals("Y")){
			    		/* remark */
			    		if(!"".equalsIgnoreCase(event.getRemark()[i])){
			    			String interRmkCtntRmk = "";
			    			StringBuffer rmkBuffer = new StringBuffer();
			    			rmkBuffer.append("[Remark]");
			    			rmkBuffer.append(System.getProperty("line.separator"));
			    			rmkBuffer.append(URLDecoder.decode(event.getRemark()[i], "UTF-8"));
			    			interRmkCtntRmk = rmkBuffer.toString();
			    			/* remark */
			    			bkgListSearchCmd.addInternalRemark(bkgBlNoVOs[i].getBkgNo(),event.getBtnTp(), account, interRmkCtntRmk);
			    		}			    				
			    	}				
			    }			
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG40121", new String[] {ex.toString() + "\n" + ex.getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n"  + new Date().toString()}).getMessage());
		}
		return eventResponse;
	}		

	/**
	 * ESM_BKG_0702 : retrieve <br>
	 * 301/310 edi sending Booking list retrieve<br>
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListFor301310Edi(Event e) throws EventException{	
		try{
			EsmBkg0702Event event = (EsmBkg0702Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();	
	
			BkgListFor301310EdiInputVO bkgListFor301310EdiInputTmpVO = event.getBkgListFor301310EdiInputVO();
			BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO = new BkgListFor301310EdiInputVO();
			
			if ( !isNull(event.getBkgListFor301310EdiInputVO().getBkgNo()) ) {
				bkgListFor301310EdiInputVO.setBkgNo(bkgListFor301310EdiInputTmpVO.getBkgNo());
			} else if(!isNull(event.getBkgListFor301310EdiInputVO().getBlNo())){
				bkgListFor301310EdiInputVO.setBlNo(bkgListFor301310EdiInputTmpVO.getBlNo()); 
			}else if(!isNull(event.getBkgListFor301310EdiInputVO().getMultBkgNo())){
				bkgListFor301310EdiInputVO.setMultBkgNo(bkgListFor301310EdiInputTmpVO.getMultBkgNo()); 
	        } else bkgListFor301310EdiInputVO = bkgListFor301310EdiInputTmpVO;
			
			List<BkgListFor301310EdiVO> list = command.searchBkgListFor301310Edi(bkgListFor301310EdiInputVO, event.getTypeGbn());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	

			int total = 0;
			int success = 0;
			int sending = 0;
			int noSend = 0;
			int fail = 0;
			if (null!=list && 0<list.size()) {
				for (int i=0;i<list.size();i++) {
					BkgListFor301310EdiVO listVO = (BkgListFor301310EdiVO)list.get(i);
					if ( !isNull(listVO.getSentStatus()) ) total++;
					if ( "Success".equals(listVO.getSentStatus()) ) success++;
					if ( "Fail".equals(listVO.getSentStatus()) ) fail++;
					if ( isNull(listVO.getSentDt()) ) noSend++;
				}
			}
			eventResponse.setETCData("total",String.valueOf(total));
			eventResponse.setETCData("success",String.valueOf(success));
			eventResponse.setETCData("sending",String.valueOf(sending));
			eventResponse.setETCData("unSent",String.valueOf(noSend + fail));
			eventResponse.setETCData("noSend",String.valueOf(noSend));
			eventResponse.setETCData("fail",String.valueOf(fail));
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

	/**
	 * ESM_BKG_0614 : Open <br>
	 * MultiCombo retrieve process<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0614(Event e) throws EventException {
		try{
			BookingUtil comboUtil = new BookingUtil();
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// bkg_sts
			List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");
			// bkg_cust_tp_cd
			List<BkgComboVO> bkg_cust_tp_cd = comboUtil.searchCombo("CD00880");
			// cust_ref_no
			List<BkgComboVO> cust_ref_no = comboUtil.searchCombo("CD02289");
			// Delivery - conti_cd
			List<BkgComboVO> conti_cd = command.searchComboMdmConti();
			// bkg_via
			List<BkgComboVO> bkg_via_cd_temp = comboUtil.searchCombo("CD01622");
			// si_via
			List<BkgComboVO> si_via_cd = comboUtil.searchCombo("CD01619");
			// eq_tp_sz_cd
			List<BkgComboVO> eq_tp_sz_cd = comboUtil.searchMdmCntrTpSz();
			
			List<BkgComboVO> bkg_via_cd = new ArrayList<BkgComboVO>();
			for(int i=0; i < bkg_via_cd_temp.size(); i++){
				if(i == 0){
					BkgComboVO off = new BkgComboVO();
					off.setVal("OFF|COM");
					off.setName("OFF");
					off.setDesc("OFF");
					bkg_via_cd.add(off);
				}
				BkgComboVO vo = bkg_via_cd_temp.get(i);
				if(!"COM".equals(vo.getVal())){
					bkg_via_cd.add(vo);
				}
			}
			
			for(int i=0;i<si_via_cd.size();i++){
				if("COM".equals(si_via_cd.get(i).getVal())){
					si_via_cd.get(i).setVal("OFF");
					si_via_cd.get(i).setName("OFF");
				}
			}
			eventResponse.setRsVoList(bkg_via_cd);
			eventResponse.setRsVoList(si_via_cd);	
			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
			eventResponse.setCustomData("bkg_cust_tp_cd", bkg_cust_tp_cd);
			eventResponse.setCustomData("cust_ref_no", cust_ref_no);
			eventResponse.setCustomData("conti_cd", conti_cd);
			eventResponse.setRsVoList(eq_tp_sz_cd);

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

//	/**
//	 * retrieve event process (ESM_BKG_0614)<br>
//	 * for getting retrieve, MultiComboretrieve result<br>
//	 *
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchInitComCode0614(Event e) throws EventException {
//		try{
//			BookingUtil comboUtil = new BookingUtil();
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//			// bkg_via
//			List<BkgComboVO> bkg_via_cd = comboUtil.searchCombo("CD01619");
//			// si_via
//			List<BkgComboVO> si_via_cd = comboUtil.searchCombo("CD01619");
//	
//			eventResponse.setRsVoList(bkg_via_cd);
//			eventResponse.setRsVoList(si_via_cd);
//	
//			return eventResponse;
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		} catch(Exception ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
//		}
//	}	
	
    /**
	 * ESM_BKG_0098 : open <br>
	 *MultiCombo retrieve process<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0098(Event e) throws EventException {
		try{
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			String rtnOfcCd = command.searchBkgReceiptType(account.getUsr_id());
			eventResponse.setCustomData("rtn_ofc_cd", rtnOfcCd);
	
			// bkg_status
			List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");
			bkg_sts_cd.remove(bkg_sts_cd.size()-1);
			bkg_sts_cd.remove(bkg_sts_cd.size()-1);
			// bkg_kind
			List<BkgComboVO> bkg_kind = comboUtil.searchCombo("CD01619");
			// bkg_cust_tp_cd
			List<BkgComboVO> bkg_cust_tp_cd = comboUtil.searchCombo("CD00880");
			// fax_sts_cd
			List<BkgComboVO> fax_sts_cd = comboUtil.searchCombo("CD02396");  //CD00959
			// eml_sts_cd
			List<BkgComboVO> eml_sts_cd = comboUtil.searchCombo("CD02396");  //CD02045
	
			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
			eventResponse.setCustomData("bkg_kind", bkg_kind);
			eventResponse.setCustomData("bkg_cust_tp_cd", bkg_cust_tp_cd);
			eventResponse.setCustomData("fax_sts_cd", fax_sts_cd);
			eventResponse.setCustomData("eml_sts_cd", eml_sts_cd);
	
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

    /**
	 * ESM_BKG_0702 : open <br>
	 * MultiCombo retrieve process<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0702(Event e) throws EventException {
		try{
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// bkg_cust_tp_cd
			List<BkgComboVO> bkg_cust_tp_cd = comboUtil.searchCombo("CD00880");
	
			eventResponse.setCustomData("bkg_cust_tp_cd", bkg_cust_tp_cd);

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

    /**
	 * ESM_BKG_0616 : open <br>
	 *  drop down code retrieve<br>
	 * Location Code retrieve with log in user Id<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0616(Event e) throws EventException {
		try{
			BookingUtil comboUtil = new BookingUtil();
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// User Location Code
			String cntCd = command.searchUsrCntCd(account);
			// bkg_sts_cd
			List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");
			// ack_cd
			List<BkgComboVO> ack_cd = comboUtil.searchCombo("CD02160");
			// edi_msg
			List<BkgComboVO> edi_msg = comboUtil.searchCombo("CD02359");
	
			eventResponse.setCustomData("cnt_cd", cntCd);
			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
			eventResponse.setCustomData("ack_cd", ack_cd);
			eventResponse.setCustomData("edi_msg", edi_msg);
	
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

	/**
	 * ESM_BKG_0076 : retrieve <br>
	 *Booking list to Combine retrieve�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅嶺뚋뼛울옙�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸블뀭占쎈쐻占쎈짗占쎌굲�뜝�럡肄у뜝�럥���뜝�럥占썲뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윥壤쏅���삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑋�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐪筌먦끇議곩뜝�럡�븧占쎈쐻占쎈윥占쎈엶�뜝�럡愿뚦뜝�럩�뮀嶺뚮쪋�삕占쎈쐻占쎈윞占쎈릊占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆轅⑦맪占쏙옙占쎌굲占쎌젂饔끸뫂留ゅ뜝�럡�떅�뜝�럩援꿨뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럩�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�뤈�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForCombine(Event e) throws EventException{
		try{
			EsmBkg0076Event event = (EsmBkg0076Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<BkgListForCombineVO> list = null;
	
			if ( "B".equals(event.getCombineCommonInputVO().getSearchGbn()) ) {
				list = command.searchBkgListForCombineByBkg(event.getCombineCommonInputVO(), event.getCombineByBkgInputVOs());
			} else {
				list = command.searchBkgListForCombineByRoute(event.getCombineCommonInputVO(), event.getCombineByRouteInputVO());
			}
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
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

	/**
	 * UI_BKG-0614 : COMBINE button click<br>
	 * ESM_BKG_0076 : COMBINE button click<br>
	 * seleced bkg combine <br>
	 * 
	 * @author	
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse combineBooking(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String mstBkgNo 			= null;
		String hitchmentYn 			= null;
		String message 				= null;
		String[] porCd 				= null;
		BkgBlNoVO[] targetBkgBlNoVOs= null;
		String prechecking			= "N";
		
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
		
		if (e.getEventName().equalsIgnoreCase("EsmBkg0076Event")) {
			EsmBkg0076Event event = (EsmBkg0076Event)e;
			mstBkgNo 			  = event.getMstBkgNo();
			hitchmentYn 		  = event.getHitchmentYn();
			targetBkgBlNoVOs 	  = event.getBkgBlNoVOs();
			message				  = event.getMessage();
			porCd 				  = new String[event.getBkgListForCombineVOs().length];
			for(int i=0;i<event.getBkgListForCombineVOs().length;i++){
				porCd[i] = event.getBkgListForCombineVOs()[i].getPorCd();
			}
			bkgCorrectionVO.setCaRsnCd(event.getCaRsnCd());
			bkgCorrectionVO.setBkgCorrRmk(event.getCaRmk());
		} else {
			EsmBkg0614Event event = (EsmBkg0614Event)e;
			mstBkgNo 			  = event.getMstBkgNo();
			hitchmentYn 		  = event.getHitchmentYn();
			targetBkgBlNoVOs 	  = event.getBkgBlNoVOs();
			message				  = event.getMessage();
			porCd = new String[event.getBkgListForWorkWithBkgVOs().length];
			for(int i=0;i<event.getBkgListForWorkWithBkgVOs().length;i++){
				porCd[i] = event.getBkgListForWorkWithBkgVOs()[i].getPor();
				targetBkgBlNoVOs[i].setBdrFlg(event.getBkgListForWorkWithBkgVOs()[i].getBdr().equals("YES")||event.getBkgListForWorkWithBkgVOs()[i].getBdr().equals("Y")?"Y":"N");				
			}
			bkgCorrectionVO.setCaRsnCd(event.getCaRsnCd());
			bkgCorrectionVO.setBkgCorrRmk(event.getCaRmk());
		}
		
		GeneralBookingSplitCombineBC command 	= new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC 	 receiptBC 	= new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC 		 searchBC 	= new GeneralBookingSearchBCImpl();
		BLDocumentationBLBC 		 blDocBlBC 	= new BLDocumentationBLBCImpl();
		BLDocumentationCMBC 		 cmDocBlBC 	= new BLDocumentationCMBCImpl();
		TransferOrderIssueBC 		 troBC 		= new TransferOrderIssueBCImpl();
		SpecialCargoReceiptBC 		 spclCgoBC 	= new SpecialCargoReceiptBCImpl();
		SpecialCargoRiderBC 		 spclRdrBC 	= new SpecialCargoRiderBCImpl(); 
		BlRatingBC 					 blRatingBC = new BlRatingBCImpl();
		BDRCorrectionBC				 bdrBC		= new BDRCorrectionBCImpl();
		BookingHistoryMgtBC 	     historyBC 	= new BookingHistoryMgtBCImpl();
		BookingUtil             	 util       = new BookingUtil(); 

		CargoReleaseOrderBC     	 cargoReleaseOrderBC     = new CargoReleaseOrderBCImpl();

		BkgCopManageBC 				 copBC 					 = new BkgCopManageBCImpl();	
		RevenueDebitNoteBC      	 revenueDebitNoteBC      = new RevenueDebitNoteBCImpl();
		ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC 		 = new ReceiveOwnBkgCancelRequestMgtBCImpl();
				
		try{
			begin();
			
			int seq = 0;
			BkgBlNoVO targetBkg = new BkgBlNoVO();
			BkgBlNoVO[] sourceBkg = new BkgBlNoVO[targetBkgBlNoVOs.length-1];
			for (int i=0;i<targetBkgBlNoVOs.length;i++) {				
				//check if they are the same office -> not check 
//				if(!"Y".equals(targetBkgBlNoVOs[i].getBdrFlg())){
//					util.searchOfcVsBkgOfc(targetBkgBlNoVOs[i], account);
//				}
				if ( mstBkgNo.equals(targetBkgBlNoVOs[i].getBkgNo()) ) {
					if(targetBkgBlNoVOs[i] != null)
						targetBkg = targetBkgBlNoVOs[i];
				} else {
					targetBkgBlNoVOs[i].setMessage(message);
					sourceBkg[seq] = targetBkgBlNoVOs[i];
					seq++;
				}
			}
			
			// add1stCaHist : input init  c/a hist�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆占썲뜝�럥��占쎄껀占쎈섣占쎌굲占쎈쐻占쎈짗占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쏙옙占쎈쐻占쎈윞占쎈쐫�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉끻뜝�럥�맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴뼹�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊�뜝�럥�늾占쎈쇊癰귨옙占쎄뎡占쎌녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂饔끸뫂留ゅ뜝�룞�삕�뜝�럩援꿨뜝�럩�쟼耀붾겦維귨쭕�굝�쐻占쎈윞占쎈뻺占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎄묽占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱥占쎈쐻占쎈윥占쎈눁占쎌녃域밟뫁�굲占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윪占쎈�뗰옙�쐻占쎈윥占쎈뭸占쎈쐻占쎈윞占쎈뻾�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈쇀占쎌뒻占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥占쎈쐻占쎈윞�뙼占썲뜝�럥���뛾占썼쥈�굥�솯占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�맱�뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�몡占쎈쇊癰귨옙占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵�뜝�럥�렓�뜝�룞�삕_no : 0000000001)
			//if ( targetBkg != null ) {
				if("Y".equals(targetBkg.getBdrFlg())){
					add1stCaHist(targetBkg);
				}
			//}
			if ( sourceBkg != null ) {
				for (int k=0;k<sourceBkg.length;k++) {
					if("Y".equals(sourceBkg[k].getBdrFlg())){
						add1stCaHist(sourceBkg[k]);
					}						
				}
			}
			
			// 01. Validate Mster Booking Customer
			ValidateCombineVO validateCombineVO = command.validateCombine(targetBkg);
			eventResponse.setETCData("custAlertMsg",validateCombineVO.getAlertMsg());

			// 02. Combine Qty, b/l
			receiptBC.combineQty        (sourceBkg, targetBkg, hitchmentYn, account);
			blDocBlBC.combineBlDoc      (sourceBkg, targetBkg, account);

			// 04. Combine Cm, spcl, tro
			String[] param = {"M", hitchmentYn};//for source quality, Parameter Counts
			cmDocBlBC.copyCntrCmByBkg   (param, targetBkg, sourceBkg, null, account);
			spclCgoBC.copySpclCgoByBkg	("M", targetBkg, sourceBkg, null, account);
			
			spclRdrBC.copySpclRiderAfterCombine	(targetBkg, sourceBkg, account);
			spclRdrBC.removeSpclRiderAfterCombine (sourceBkg); 
			
			List<CombineTroNewSeqVO> combineTroNewSeqVOs = troBC.copyTroByBkg("M", targetBkg, sourceBkg, null, "", account);
			
			// combine rate
			blRatingBC.copyChgRateByBkg (sourceBkg, targetBkg, account);
			
			// After combine ,update spcl flg as spcl cgo information.
			BkgBlNoVO[] bkgBlNoVO = new BkgBlNoVO[1];
			bkgBlNoVO[0] = targetBkg;
			receiptBC.modifySpclFlag(bkgBlNoVO, account);
			
			// 07. about toBkg
			if ( targetBkg != null ) {
				String corrNo = null;
								
				//for performance report
				PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
				performReportBc.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");
				performReportBc.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");
				
				//07-1.Later than for the BDR if Master Bkg
				if("Y".equals(targetBkg.getBdrFlg())){
					bdrBC.addAutoCaTemp(targetBkg, "COMBINE_MASTER", bkgCorrectionVO, account);
					
					BkgBlNoVO corrBkgBlNoVO = addCaHistory(bkgCorrectionVO.getCaRsnCd(), bkgCorrectionVO.getBkgCorrRmk(), targetBkg, "N", "Y");
					corrNo = corrBkgBlNoVO.getCaNo();
					
					bdrBC.removeCATemp(targetBkg);
					
					blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);
					
		            //add2. 
					OblIssVO oblIssVO = util.searchOblIssue(corrBkgBlNoVO); 
					
					//add2. 
					RevDrNoteVO revDrNoteVO 		  = new RevDrNoteVO(); 
					CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
					bkgRevDrNoteVO.setBkgNo      (corrBkgBlNoVO.getBkgNo());  
					bkgRevDrNoteVO.setBkgCorrNo  (corrBkgBlNoVO.getCaNo()); 
					bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
					bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
					bkgRevDrNoteVO.setReceiverRmk("");
					revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);
					
					revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
					
					//add2. 
					OblRdemVO oblRdem = new OblRdemVO();
					oblRdem.setBlNo      (oblIssVO.getBlNo());  
					oblRdem.setCgorTeamCd("C");
					oblRdem.setCgoEvntNm ("B/L Correct");
					oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
					oblRdem.setEvntOfcCd (account.getOfc_cd());
					oblRdem.setEvntUsrId (account.getUsr_id());
					oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

					try{
						cargoReleaseOrderBC.setupFocByObl(oblRdem);
					} catch(Exception crEx){
						log.error("err " + crEx.toString(), crEx);
					}	
				}

//				String spclRqstResult = reRequestSpclCgoApproval(targetBkg, "COMBINE", null);
				String spclRqstResult = reRequestSpclCgoApproval(targetBkg, "COMBINE", null, "");
				if("pre-checking".equals(spclRqstResult)){
					prechecking = "Y";
				} else {
					prechecking = "N";						
				}
				
				if(!"Y".equals(targetBkg.getBdrFlg())){
					receiptBC.changeBkgStatus("Y", targetBkg, false, account);
				}
				
				//07-4. createBkgHistoryLine calling
				StringBuffer sourceBkgList = new StringBuffer();
				for (int j=0;j<sourceBkg.length;j++) {
					if (j>0) { 
						sourceBkgList.append(", ");
						sourceBkgList.append(sourceBkg[j].getBkgNo());
					}else{
						sourceBkgList.append(sourceBkg[j].getBkgNo());
					}
//					sourceBkgList = sourceBkgList + ((j>0)?", ":"")+sourceBkg[j].getBkgNo();
				}
				HistoryLineVO targetBkghistoryLineVO = new HistoryLineVO();
				targetBkghistoryLineVO.setBkgNo         (targetBkg.getBkgNo());
				targetBkghistoryLineVO.setCorrNo		(corrNo);
				targetBkghistoryLineVO.setUiId          ("ESM_BKG_0076");
				targetBkghistoryLineVO.setHisCateNm     ("COMBINE");
				targetBkghistoryLineVO.setCrntCtnt      ("Combined from source:"+sourceBkgList.toString());
				historyBC.createBkgHistoryLine(targetBkghistoryLineVO, account);

				historyBC.releaseCntrFinalConfirm(targetBkg, account);
			
				//07-2. interfaceCoa
				interfaceToCoa(targetBkg, "Booking Combine", account);
				
			}

			// 08. About sourceBkg
			if ( sourceBkg != null ) {
				for (int k=0;k<sourceBkg.length;k++) {
					String corrNo = null;
					
					//08-1. Later than for the BDR if Source Bkg
					if("Y".equals(sourceBkg[k].getBdrFlg())){
						bdrBC.addAutoCaTemp(sourceBkg[k], "COMBINE_SOURCE", bkgCorrectionVO, account);
						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(bkgCorrectionVO.getCaRsnCd(), bkgCorrectionVO.getBkgCorrRmk(), sourceBkg[k], "N", "Y");
						corrNo = corrBkgBlNoVO.getCaNo();
						
						bdrBC.removeCATemp(sourceBkg[k]);
						
			            //add2. 
						OblIssVO oblIssVO = util.searchOblIssue(corrBkgBlNoVO); 
						
						//add2. 
						RevDrNoteVO revDrNoteVO 		  = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (corrBkgBlNoVO.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (corrBkgBlNoVO.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);
						
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
						
						//add2. 
						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}	
					}

					//08-4. createBkgHistoryLine calling
					HistoryLineVO sourceBkghistoryLineVO = new HistoryLineVO();
					sourceBkghistoryLineVO.setBkgNo         (sourceBkg[k].getBkgNo());
					sourceBkghistoryLineVO.setCorrNo		(corrNo);
					sourceBkghistoryLineVO.setUiId          ("ESM_BKG_0076");
					sourceBkghistoryLineVO.setHisCateNm     ("COMBINE");
					sourceBkghistoryLineVO.setCrntCtnt      ("Combined to target bkg no:"+targetBkg.getBkgNo());
					historyBC.createBkgHistoryLine(sourceBkghistoryLineVO, account);

					//08-2. interfaceCoa
					interfaceToCoa(sourceBkg[k], "Booking Cancel", account);
					
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createCustBkgReceiptEdi(sourceBkg[k], null, "Y", account);
					for(int i=0;i<bkgNtcHisVOs.size();i++){
						String hisUiNm = sourceBkg[k].getHisUiNm() == null ? "" : sourceBkg[k].getHisUiNm();
						bkgNtcHisVOs.get(i).setHisUiNm(hisUiNm);
					}
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
					
//					searchBC.createCustBkgReceiptEdiBackEnd(sourceBkg[k], null, "Y", account);
					
					//keep VVD information for DG cancel about source BKG
					List<SearchDgCancelInfoVO> dgCancelInfo = null;
					dgCancelInfo = spclCgoBC.searchDgCancelInfo(sourceBkg[k].getBkgNo());
					//DG cancel call of source BKG
					if(dgCancelInfo != null && dgCancelInfo.size() > 0){
						List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
						scgVvdDgCgoCxlRqstVOs = spclCgoBC.manageDgBkgCancel(sourceBkg[k].getBkgNo(), account, scgVvdDgCgoCxlRqstVOs, "Booking Combined");
						bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
					}


				}
			}
			
			String[] combinedBkgNo = new String[targetBkgBlNoVOs.length];
			for(int i=0;i<targetBkgBlNoVOs.length;i++){
				combinedBkgNo[i] = targetBkgBlNoVOs[i].getBkgNo();
			}
			
			String bkgNo = "";
			if(targetBkg != null)
				bkgNo = targetBkg.getBkgNo();
			
			copBC.combineBkg(combinedBkgNo, bkgNo, combineTroNewSeqVOs);
//			copBC.combineBkg(combinedBkgNo, targetBkg.getBkgNo());
			
			// S 2010.08.31 KMJ TRO Split add
			// 81. copyTroBySplit
			String[] arrTargetBkgNo = new String[1];
			if(targetBkg != null)
				arrTargetBkgNo[0] = targetBkg.getBkgNo();
			
			for(int i=0;i<targetBkgBlNoVOs.length;i++){
//				troBC.copyTroBySplit(combinedBkgNo[i], arrTargetBkgNo, account);
//				// 82. cancelTroBySplit
				troBC.cancelTroBySplit(combinedBkgNo[i], arrTargetBkgNo, account);
				// 2010.08.31 KMJ TRO Split add
			}
			
			/* 占쎄껀�뜝�룞�삕亦끹룇�삕占쎈���삕占쎈턄占쎈눀�뜝占� �뜝�럥吏쀧뼨轅명�э옙�꼨占쎈ご�뜝占� �뜝�럩留꾢뜝�럥�뱺 DT �뜝�룞�삕�뜝�럩�궋 */
			util.bkgBookingLstSavDtSave(bkgNo);
			
			commit();
			//After commit(), inv i/f
			//07-5. bookingARCreationBC.interfaceBKGARInvoiceToINV(BkgIfVo);
			interfaceToInv(targetBkg, account);	
			// 08. about sourceBkg
			if ( sourceBkg != null ) {
				for (int k=0;k<sourceBkg.length;k++) {
					//08-5:bookingARCreationBC.interfaceBKGARInvoiceToINV(BkgIfVo);
					interfaceToInv(sourceBkg[k], account);	
				}
			}
			eventResponse.setETCData("pre_checking", prechecking);
			eventResponse.setETCData("isSuccess","Y");
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
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse cancelBookingMulti(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0076Event event = (EsmBkg0076Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationCMBC blDocCmBC = new BLDocumentationCMBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		BkgCopManageBC bkgCopManageBC = new BkgCopManageBCImpl();
		SpecialCargoReceiptBC 	spclCgoReceiptBC= new SpecialCargoReceiptBCImpl();
		ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC = new ReceiveOwnBkgCancelRequestMgtBCImpl();
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		
		try{
			if(event.getBkgBlNoVOs() != null){
				for(int i=0;i<event.getBkgBlNoVOs().length;i++) {
					BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVOs()[i];

					begin();
					// 01. Cancel Booking
					receiptBC.cancelBooking(bkgBlNoVO, account);
					
					//keep VVD information for DG cancel about source BKG
					List<SearchDgCancelInfoVO> dgCancelInfo = null;
					dgCancelInfo = spclCgoReceiptBC.searchDgCancelInfo(bkgBlNoVO.getBkgNo());
					//DG cancel
					if(dgCancelInfo != null && dgCancelInfo.size() > 0){
						List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
						scgVvdDgCgoCxlRqstVOs = spclCgoReceiptBC.manageDgBkgCancel(bkgBlNoVO.getBkgNo(), account, scgVvdDgCgoCxlRqstVOs, "Booking Canceled");
						bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
					}
					
					// 02. Cancel Container
					blDocCmBC.cancelBkgCntr(bkgBlNoVO, account);

					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
					historyLineVO.setBkgDocProcTpCd("BKGCAN");//booking cancel for doc performance
					historyLineVO.setUiId("ESM_BKG_0076");
					historyLineVO.setCrntCtnt("Booking Canceled.");
					historyLineVO.setHisCateNm("Booking Cancel."); 
					
					if(event.getBkgBlNoVOs()[0].getMessage() != null){
						historyBC.createBkgHistoryLine(historyLineVO, "Cancel Reason",event.getBkgBlNoVOs()[0].getMessage(), account);
					}else{
						historyBC.createBkgHistoryLine(historyLineVO, account);
					}

					bkgCopManageBC.cancelBkg(bkgBlNoVO.getBkgNo());
					
					// 04. interfaceCoa
					interfaceToCoa(bkgBlNoVO, "Booking cancel", account);
					
					commit();
					
					/* cencal message */
					// 07. sendBkgCustEdi
					searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);
	
					// 08. sendBkgTmlEdi
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("R");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);

				}
			}

			if(event.getBkgBlNoVOs() != null){
				for(int i=0;i<event.getBkgBlNoVOs().length;i++) {
					BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVOs()[i];
					interfaceToInv(bkgBlNoVO, account);	
				}
			}
			
			eventResponse.setETCData("isSuccess","Y");
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
	 * ESM_BKG_0099 : P/C click <br>
	 * In booking split, Ocean Route retrieve<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplitRoute(Event e) throws EventException{
		try{
			EsmBkg0099Event 	 event 		   = (EsmBkg0099Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			ProductCatalogCreateBC 	proBC = new ProductCatalogCreateBCImpl();
			BookingUtil 			util  = new BookingUtil();

			BkgBlNoVO  sourceBkg  = event.getSourceBkg();			
			SplitBkgVO splitBkgVO = event.getSplitBkgVO();
			List<SplitQtyVO> selectQtyVO = splitBkgVO.getSplitQtyVO();

			BkgBlNoVO targetBkg = new BkgBlNoVO();
			targetBkg.setBkgNo(splitBkgVO.getSplitBlInfoVO().get(0).getBkgNo());

			//PrdMainInfoVO Set
			PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
			prdMainInfoVO.setFCmd("3");
			if(sourceBkg.getBkgNo().equals(targetBkg.getBkgNo())){
				prdMainInfoVO.setPcMode("R");
			} else {
				prdMainInfoVO.setPcMode("B");
			}
			prdMainInfoVO.setTVvd (splitBkgVO.getSplitBlInfoVO().get(0).getTvvd());
			prdMainInfoVO.setWgt  (splitBkgVO.getSplitBlInfoVO().get(0).getActWgt());
			prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
			
			PrdParameterVO prdParameterVO = new PrdParameterVO();
			prdParameterVO.setBkgBlNoVO(sourceBkg);
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
			
			// maintain T/S port, vvd exception
			prdParameterVO.getPrdMainInfoVO().setVvd1("");
			prdParameterVO.getPrdMainInfoVO().setPol1C("");
			prdParameterVO.getPrdMainInfoVO().setPod1C("");
			prdParameterVO.getPrdMainInfoVO().setLane1("");
			
			prdParameterVO.getPrdMainInfoVO().setVvd2("");
			prdParameterVO.getPrdMainInfoVO().setPol2C("");
			prdParameterVO.getPrdMainInfoVO().setPod2C("");
			prdParameterVO.getPrdMainInfoVO().setLane2("");
			
			prdParameterVO.getPrdMainInfoVO().setVvd2("");
			prdParameterVO.getPrdMainInfoVO().setPol2C("");
			prdParameterVO.getPrdMainInfoVO().setPod2C("");
			prdParameterVO.getPrdMainInfoVO().setLane2("");
			
			prdParameterVO.getPrdMainInfoVO().setVvd2("");
			prdParameterVO.getPrdMainInfoVO().setPol2C("");
			prdParameterVO.getPrdMainInfoVO().setPod2C("");
			prdParameterVO.getPrdMainInfoVO().setLane2("");
			
			if(sourceBkg.getBkgNo().equals(targetBkg.getBkgNo())){
				prdParameterVO.getPrdMainInfoVO().setMtPkupDt("");
			}
			
			List<PrdQtyInfoVO> prdQtyInfoList = new ArrayList<PrdQtyInfoVO>();
			log.debug("cnt:"+selectQtyVO.size());
            for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {        	
            	int targetBkgSeq = icnt%Integer.parseInt(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitcount());
            	
            	if((event.getPcIdx())==targetBkgSeq){
            		PrdQtyInfoVO prdQtyInfoVO = new PrdQtyInfoVO();
            		prdQtyInfoVO = new PrdQtyInfoVO();
            		prdQtyInfoVO.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
            		prdQtyInfoVO.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
            		
            		prdQtyInfoList.add(prdQtyInfoVO); 
            	}
            }
            
			prdParameterVO.setPrdQtyInfo(prdQtyInfoList);
			prdParameterVO.getBkgBlNoVO().setBkgNo(targetBkg.getBkgNo());
			prdParameterVO.getPrdMainInfoVO().setBkgNo(targetBkg.getBkgNo());
			prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("");
			prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("");
			String pctlNo="";
			String mapSeq="";

	    	util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
	    	
			//P/C connection 
			try{
				String pctlNoMapSeqStr = proBC.createPrdCtlgRout(prdParameterVO, account);
				log.debug("pctl_no:"+pctlNoMapSeqStr);
				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				pctlNo = pctlNoMapSeq[0];
				mapSeq = pctlNoMapSeq[1];
			} catch (Exception pc_ex){
				eventResponse.setETCData("IsPctlNoPop", "Y");
				eventResponse.setETCData(prdParameterVO.getPrdMainInfoVO().getColumnValues());	
				eventResponse.setRsVoList(prdParameterVO.getPrdQtyInfo());	
				
				log.debug("Pctl Pop Up Call");
				log.error("Pctl Pop Up Call : " + pc_ex.toString(), pc_ex);
				rollback();
				return eventResponse;
			}
			log.debug(" Pctl No : [" + pctlNo + "]");
			
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
				targetBkg.setPctlNo(pctlNo);
				targetBkg.setMapSeq(mapSeq);
				
			}else{
				eventResponse.setETCData("IsPctlNoPop", "Y");
				eventResponse.setETCData(prdParameterVO.getPrdMainInfoVO().getColumnValues());	
				eventResponse.setRsVoList(prdParameterVO.getPrdQtyInfo());	
				
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;
			}
			
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			String rtnRoute = command.searchNewTsRoute(targetBkg);
			eventResponse.setETCData("rtn_route", rtnRoute);
			eventResponse.setETCData("pctl_no",   pctlNo);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_1024 : open <br>
	 * bkg information retrieve<br>
	 *  
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartialCntrBkg(Event e) throws EventException{
		try{
			EsmBkg1024Event event = (EsmBkg1024Event)e;
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			
			PartialBkgVO partialBkgVO = receiptBC.searchPartialCntrBkg(event.getBkgBlNoVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRs(partialBkgVO.getPartialBkgCntrRS());
			eventResponse.setRsVoList(partialBkgVO.getPartialBkgInfo());
			
			// combine Title
			List<String> cntrNoList = partialBkgVO.getCntrNoList();
			String saveName = "";
			
			for(int i = 0 ; i < cntrNoList.size() ; i++){
				if(i == 0){
					saveName = cntrNoList.get(i).toLowerCase();
				}else{
					saveName = saveName + "|" + cntrNoList.get(i).toLowerCase();	
				}
			}
			eventResponse.setETCData("SaveName", saveName);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_1024 : save <br>
	 * Partial Booking Routeinformation Save<br>
	 *  
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse modifyBkgRouteForPartialBkg(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		EsmBkg1024Event 	 	event 			= (EsmBkg1024Event)e;
		GeneralBookingReceiptBC receiptBC 		= new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC  searchBC 		= new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC  	historyBC 		= new BookingHistoryMgtBCImpl();
		BookingUtil 			util 			= new BookingUtil();

		ProductCatalogCreateBC 	prdBC 			= new ProductCatalogCreateBCImpl();
		BkgCopManageBC 			copBC 			= new BkgCopManageBCImpl();

		try{			
			PartialBkgInfoVO[] partialBkgInfoVOs = event.getPartialBkgInfoVOs();
			VslSkdVO[] vslSkdVOs = event.getVslSkdVOs();
			for(int i = 1 ; i < partialBkgInfoVOs.length ; i++){
				begin();
				// 11. searchPrdParmForFullRoute
				PrdParameterVO prdParameterVO = new PrdParameterVO();
				PrdMainInfoVO  prdMainInfoVO  = new PrdMainInfoVO();
				prdMainInfoVO.setFCmd  ("3");
				prdMainInfoVO.setPcMode("R");		
				prdMainInfoVO.setBkgNo(partialBkgInfoVOs[i].getBkgNo());
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
				
				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(partialBkgInfoVOs[i].getBkgNo());
				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				
				// 01. searchPrdParameter
				PrdParameterVO schPrdParameterVO = util.searchPrdParmForFullRoute(prdParameterVO);
				
				prdMainInfoVO = schPrdParameterVO.getPrdMainInfoVO();
				
				boolean vslChange = false;
				for(int vslIdx=0;vslIdx<vslSkdVOs.length;vslIdx++){
					if(0==vslIdx){
						if(!prdMainInfoVO.getVvd1().equals(vslSkdVOs[0].getBkgVvdCd())) vslChange = true;
					} else if(1==vslIdx){
						if(!prdMainInfoVO.getVvd2().equals(vslSkdVOs[1].getBkgVvdCd())) vslChange = true;
					} else if(2==vslIdx){
						if(!prdMainInfoVO.getVvd3().equals(vslSkdVOs[2].getBkgVvdCd())) vslChange = true;
					} else if(3==vslIdx){
						if(!prdMainInfoVO.getVvd4().equals(vslSkdVOs[3].getBkgVvdCd())) vslChange = true;
					}
				}
				if("Y".equals(partialBkgInfoVOs[i].getOrg())){
					prdMainInfoVO.setPor(partialBkgInfoVOs[i].getPorCd());
					if(partialBkgInfoVOs[i].getPorNodCd() != null && partialBkgInfoVOs[i].getPorNodCd().length() > 0){
						prdMainInfoVO.setPorN(partialBkgInfoVOs[i].getPorCd()+partialBkgInfoVOs[i].getPorNodCd());
					}else{
						prdMainInfoVO.setPorN(null);
					}
					
					prdMainInfoVO.setPol(partialBkgInfoVOs[i].getPolCd());
					if(partialBkgInfoVOs[i].getPolNodCd() != null && partialBkgInfoVOs[i].getPolNodCd().length() > 0){
						prdMainInfoVO.setPolN(partialBkgInfoVOs[i].getPolCd()+partialBkgInfoVOs[i].getPolNodCd());
					}else{
						prdMainInfoVO.setPolN(null);
					}		
					prdMainInfoVO.setRcvT(partialBkgInfoVOs[i].getRcvTermCd());
				}
				if("Y".equals(partialBkgInfoVOs[i].getDest())){
					prdMainInfoVO.setPod(partialBkgInfoVOs[i].getPodCd());
					if(partialBkgInfoVOs[i].getPodNodCd() != null && partialBkgInfoVOs[i].getPodNodCd().length() > 0){
						prdMainInfoVO.setPodN(partialBkgInfoVOs[i].getPodCd()+partialBkgInfoVOs[i].getPodNodCd());
					}else{
						prdMainInfoVO.setPodN(null);
					}						
					prdMainInfoVO.setDel(partialBkgInfoVOs[i].getDelCd());
					if(partialBkgInfoVOs[i].getDelNodCd() != null && partialBkgInfoVOs[i].getDelNodCd().length() > 0){
						prdMainInfoVO.setDelN(partialBkgInfoVOs[i].getDelCd()+partialBkgInfoVOs[i].getDelNodCd());
					}else{
						prdMainInfoVO.setDelN(null);
					}		
					prdMainInfoVO.setDelT(partialBkgInfoVOs[i].getDeTermCd());
				}
				prdMainInfoVO.setTVvd(partialBkgInfoVOs[i].getBkgTrunkVvd());

				if(vslSkdVOs!=null&&vslSkdVOs.length > 0){
					prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
					if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
					}else{
						prdMainInfoVO.setPod1N(null);
					}						
					prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
					prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
					if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
					}else{
						prdMainInfoVO.setPol1N(null);
					}
					prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
					prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());	
					prdMainInfoVO.setLane1(util.searchSvcLaneByVvd(vslSkdVOs[0].getBkgVvdCd()));							
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 1);
				}
				if(vslSkdVOs!=null&&vslSkdVOs.length > 1){
					prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
					if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
					}else{
						prdMainInfoVO.setPod2N(null);
					}					
					prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
					prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
					if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
					}else{
						prdMainInfoVO.setPol2N(util.searchSvcLaneByVvd(vslSkdVOs[1].getBkgVvdCd()));
					}					
					prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
					prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
					prdMainInfoVO.setLane2(null);	
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 2);
				}
				if(vslSkdVOs!=null&&vslSkdVOs.length > 2){
					prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
					if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
					}else{
						prdMainInfoVO.setPod3N(null);
					}					
					prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
					prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
					if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
					}else{
						prdMainInfoVO.setPol3N(null);
					}					
					prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
					prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
					prdMainInfoVO.setLane3(util.searchSvcLaneByVvd(vslSkdVOs[2].getBkgVvdCd()));
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 3);			
				}
				if(vslSkdVOs!=null&&vslSkdVOs.length > 3){
					prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
					if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
					}else{
						prdMainInfoVO.setPod4N(null);
					}					
					prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
					prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
					if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
					}else{
						prdMainInfoVO.setPol4N(null);
					}				
					prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
					prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
					prdMainInfoVO.setLane4(util.searchSvcLaneByVvd(vslSkdVOs[3].getBkgVvdCd()));	
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 4);			
				}		

				if("Y".equals(partialBkgInfoVOs[i].getOrg())){				
					if(partialBkgInfoVOs[i].getLodgDueDt() != null){
						prdMainInfoVO.setLdDt(partialBkgInfoVOs[i].getLodgDueDt().replaceAll("-", ""));
					}else{
						prdMainInfoVO.setLdDt(null);	
					}
					if(partialBkgInfoVOs[i].getMtyDorArrDt() != null){
						prdMainInfoVO.setDrDt(partialBkgInfoVOs[i].getMtyDorArrDt().replaceAll("-", ""));
					}else{
						prdMainInfoVO.setDrDt(null);
					}
					prdMainInfoVO.setMPu(partialBkgInfoVOs[i].getMtyPkupYdCd());
					prdMainInfoVO.setFRt(partialBkgInfoVOs[i].getFullRtnYdCd());
				}
				prdMainInfoVO.setOrgTrnsMode("");
				prdMainInfoVO.setDestTrnsMode("");
				
				schPrdParameterVO.setPrdMainInfoVO(prdMainInfoVO);				
				util.prdParameterLog(prdMainInfoVO);
				
				//In case of pseudo,ocean route check exception 
//				String trunkVslCd = prdMainInfoVO.getTVvd().substring(0, 4);
//				if(!trunkVslCd.equals("HJXX") && !trunkVslCd.equals("HJYY") && !trunkVslCd.equals("HJZZ")){
					receiptBC.validateOceanRoute(prdMainInfoVO);
//				}
				
				// 12. createProdCtlRoute
				String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(schPrdParameterVO, account);
				
				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				
				// 13. modifyBkgRouteForParialBkg
				BkgBlNoVO partialBkg = new BkgBlNoVO();
				partialBkg.setPctlNo(pctlNoMapSeq[0]);
				partialBkg.setCaFlg("N");
				partialBkg.setBkgNo(partialBkgInfoVOs[i].getBkgNo());
				
				HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_1024", partialBkg);

				receiptBC.modifyBkgRouteForPartialBkg(partialBkgInfoVOs[i], event.getVslSkdVOs(), partialBkg, account);
				
				//In case of vvd changing , spcl auto re-request
//				reRequestSpclCgoApproval(bkgBlNoVO, "PARTIAL", null);
				reRequestSpclCgoApproval(bkgBlNoVO, "PARTIAL", null, "");
					
				copBC.updateBkg(partialBkg.getBkgNo(), pctlNoMapSeq[1]);
				
				historyBC.manageBookingHistory("ESM_BKG_1024", historyTableVO, account);

				String brac = "X";
				brac = (vslChange)?"B":"U";
				if(!"X".equals(brac)){
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(historyTableVO.getBkgVvdVOs());
					vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
					vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
					vender301ParamVO.setBracCd(brac);
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
//					searchBC.createTmlBkgReceiptEdiBackEnd(bkgBlNoVO, historyTableVO.getBkgVvdVOs(), brac, "BT", "Y", account);
				}
				// 22. updateBkg(bkgNo)
				interfaceToCoa(partialBkg, "Booking Update", account);
				
				commit();
						
				try{	
					// cut off time (After cop creation , process)
					String fromDt = "";
					String toDt = "";
					
					if("US".equals(partialBkgInfoVOs[i].getPorCd()) || "CA".equals(partialBkgInfoVOs[i].getPorCd())){					
						PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(bkgBlNoVO);
											
						Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null);

						fromDt= (String)railTime.get("RTN_TIME");
						toDt  = (String)railTime.get("CUT_OFF");
					}
					begin(); //Transaction devision for accessiong batch server
					receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);
					String[] railTime = splitRailReceiveDate(bkgBlNoVO);
					fromDt = railTime[0];
					toDt   = railTime[1];
					copBC.modifyRailRcvCoffDt(bkgBlNoVO.getBkgNo(), fromDt, toDt, account.getUsr_id());	
					commit();	
				} catch(Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}		

				interfaceToInv(partialBkg, account);
			}
			eventResponse.setETCData("isSuccess","Y");
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
	 * ESM_BKG_0077 : open <br>
	 * booking data to booking Copy retrieve<br>
	 *  
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgForCopy(Event e) throws EventException{
		try{
			EsmBkg0077Event event = (EsmBkg0077Event)e;
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			
			BookingCopyVO bookingCopyVO = receiptBC.searchBkgForCopy(event.getBkgBlNoVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			List<VslSkdVO> vslSkd = bookingCopyVO.getVslSkd();
			BkgForCopyVO bkgForCopyVO = bookingCopyVO.getBkgForCopyVO();
			BlCustomerInfoVO blCustomerInfoVO = bookingCopyVO.getBlCustomerInfoVO();
			
			if(bkgForCopyVO != null){
				eventResponse.setETCData(bkgForCopyVO.getColumnValues());	
				if(blCustomerInfoVO != null){
					eventResponse.setETCData(blCustomerInfoVO.getColumnValues());	
				}				
				eventResponse.setRsVoList(vslSkd);	
				
				eventResponse.setETCData("DataYn", "Y");
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
				eventResponse.setETCData("DataYn", "N");
			}
//			searchTrnkVvdByRlane(PolPodVvdVO[] polPodVvdVOs
			PolPodVvdVO[] polPodVvdVOs = new PolPodVvdVO[vslSkd.size()];
			for(int i=0;i<polPodVvdVOs.length;i++){
				PolPodVvdVO polPodVvdVO = new PolPodVvdVO();
				polPodVvdVO.setBkgVvdCd(vslSkd.get(i).getBkgVvdCd());
				polPodVvdVO.setPolCd(vslSkd.get(i).getPolCd());
				polPodVvdVO.setPodCd(vslSkd.get(i).getPodCd());
				polPodVvdVOs[i] = polPodVvdVO;
			}
			String trunkSeq = receiptBC.searchTrnkVvdByRlane(polPodVvdVOs);
			eventResponse.setETCData("trunk_seq", trunkSeq);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_0077 : input manual booking number <br>
	 * booking data to manual booking Copy retrieve<br>
	 *  
	 * @author Moon Hwan Choi
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMnlBkgSts(Event e) throws EventException{
		try{
			EsmBkg0077Event event = (EsmBkg0077Event)e;			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			ManualBookingCopyVO[] manualBookingCopyVOs = event.getManualBookingCopyVOs();
			String mnlBkgSts = "";
			if(manualBookingCopyVOs != null){
				manualBookingCopyVOs = receiptBC.searchManualBookingStatus(manualBookingCopyVOs, bkgBlNoVO.getBkgNo());
				for(int i = 0 ; i < manualBookingCopyVOs.length ; i++){
					if(i == 0){
						mnlBkgSts = manualBookingCopyVOs[i].getMnlBkgSts();
					}else {
						mnlBkgSts = mnlBkgSts + "|" + manualBookingCopyVOs[i].getMnlBkgSts();	
					}
				}
			}
			
			eventResponse.setETCData("MnlBkgSts", mnlBkgSts);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0077 : copy <br>
	 * As Route changing Booking Copy<br>
	 *  
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyBkgWithoutRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		EsmBkg0077Event 	 event 		   	= (EsmBkg0077Event)e;
		GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
		BookingUtil 			util 		= new BookingUtil();
		try{
			PrdParameterVO prdParameterVO = new PrdParameterVO();
			
			String vvdModifyFlg = event.getVvdModifyFlg();
			log.debug("Event vvdModifyFlg : " + vvdModifyFlg);
			BookingCopyVO bookingCopyVO = new BookingCopyVO();
			
			bookingCopyVO.setBkgForCopyVO(event.getBkgForCopyVO());
			bookingCopyVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCopyVO.setBkgBlNoVO(event.getBkgBlNoVO());
			
			//00.Legacy VVD Check
			String tVvd = bookingCopyVO.getBkgForCopyVO().getBkgTrunkVvd();
			receiptBC.checkLegacySystemVVD(tVvd);

			receiptBC.validateBkgCopy(bookingCopyVO, account);
			
			
			
			BkgForCopyVO bkgForCopyVO = event.getBkgForCopyVO();
			String pctlNo = event.getPctlNo();
			
		
			if(pctlNo.length() > 0 && !"FAIL".equals(pctlNo.length())){				
				bkgForCopyVO.setPctlNo(pctlNo);
			}else{
				if("Y".equals(vvdModifyFlg)){
					// As With Route 
					VslSkdVO[] vslSkdVOs = event.getVslSkdVOs();
					PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();

					prdMainInfoVO.setTVvd(bkgForCopyVO.getBkgTrunkVvd());
					if(vslSkdVOs.length > 0){
						prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
						if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
							prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
						}else{
							prdMainInfoVO.setPod1N(null);
						}						
						prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
						prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
						if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
							prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
						}else{
							prdMainInfoVO.setPol1N(null);
						}
						prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
						prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());
						
						prdMainInfoVO.setLane1(null);				
					}else{
						prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 1);
					}
					if(vslSkdVOs.length > 1){
						prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
						if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
							prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
						}else{
							prdMainInfoVO.setPod2N(null);
						}					
						prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
						prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
						if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
							prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
						}else{
							prdMainInfoVO.setPol2N(null);
						}					
						prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
						prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
						prdMainInfoVO.setLane2(null);				
					}else{
						prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 2);			
					}
					if(vslSkdVOs.length > 2){
						prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
						if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
							prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
						}else{
							prdMainInfoVO.setPod3N(null);
						}					
						prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
						prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
						if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
							prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
						}else{
							prdMainInfoVO.setPol3N(null);
						}					
						prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
						prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
						prdMainInfoVO.setLane3(null);				
					}else{
						prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 3);			
					}
					if(vslSkdVOs.length > 3){
						prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
						if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
							prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
						}else{
							prdMainInfoVO.setPod4N(null);
						}					
						prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
						prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
						if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
							prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
						}else{
							prdMainInfoVO.setPol4N(null);
						}				
						prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
						prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
						prdMainInfoVO.setLane4(null);				
					}else{
						prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 4);			
					}			
					prdMainInfoVO.setPmF((bkgForCopyVO.getHotDeFlg() != null)?bkgForCopyVO.getHotDeFlg():"N");	
					prdMainInfoVO.setDgF((bkgForCopyVO.getDcgoFlg()  != null)?bkgForCopyVO.getDcgoFlg():"N");			
					prdMainInfoVO.setRfF((bkgForCopyVO.getRcFlg()    != null)?bkgForCopyVO.getRcFlg():"N");					
					prdMainInfoVO.setAkF((bkgForCopyVO.getAwkCgoFlg()!= null)?bkgForCopyVO.getAwkCgoFlg():"N");				
					prdMainInfoVO.setBbF((bkgForCopyVO.getBbCgoFlg() != null)?bkgForCopyVO.getBbCgoFlg():"N");				
					prdMainInfoVO.setHgF((bkgForCopyVO.getHngrFlg()  != null)?bkgForCopyVO.getHngrFlg():"N");	

					prdMainInfoVO.setRfa(bkgForCopyVO.getRfaNo());
					prdMainInfoVO.setSc(bkgForCopyVO.getScNo());
					prdMainInfoVO.setBkgNo(bkgForCopyVO.getBkgNo());	
					
					// BkgBlNoVO creation
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(bkgForCopyVO.getBkgNo());
								
					prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
					prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
					prdParameterVO.setUiNo("ESM_BKG_0077");
					prdParameterVO = util.searchPrdParmForFullRoute(prdParameterVO);
					
					//ocean route check 
					if(!"COXX".equals(prdParameterVO.getPrdMainInfoVO().getTVvd().substring(0,4))
							&&!"COYY".equals(prdParameterVO.getPrdMainInfoVO().getTVvd().substring(0,4))
							&&!"COZZ".equals(prdParameterVO.getPrdMainInfoVO().getTVvd().substring(0,4))){
						receiptBC.validateOceanRoute(prdParameterVO.getPrdMainInfoVO());
					}
					
					prdParameterVO.getPrdMainInfoVO().setFCmd("3");
					prdParameterVO.getPrdMainInfoVO().setPcMode("B");
		
					prdParameterVO.getPrdMainInfoVO().setBkgNo("");
					prdParameterVO.getBkgBlNoVO().setBkgNo("");
					
					// 03. createProdCtlRout	
					ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
					try{
						pctlNo= proBC.createPrdCtlgRout(prdParameterVO, account);
					} catch (Exception prdEx){
						eventResponse.setETCData("IsPctlNoPop", "YC");
						
						eventResponse.setETCData(prdParameterVO.getPrdMainInfoVO().getColumnValues());	
						eventResponse.setRsVoList(prdParameterVO.getPrdQtyInfo());	
						
						log.debug("Pctl Pop Up Call");
						log.error("Pctl Pop Up Call : " + prdEx.toString(), prdEx);
						rollback();
						return eventResponse;
					}
					if(pctlNo.trim().length() < 1 || "FAIL".equals(pctlNo)){
						eventResponse.setETCData("IsPctlNoPop", "YC");
						
						eventResponse.setETCData(prdParameterVO.getPrdMainInfoVO().getColumnValues());	
						eventResponse.setRsVoList(prdParameterVO.getPrdQtyInfo());	
						
						log.debug("Pctl Pop Up Call");
						rollback();
						return eventResponse;
					}
				}
			}					
			eventResponse = copyBkgInfo(e, pctlNo);
			eventResponse.setETCData("isSuccess","Y");
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}		
	
	/**
	 * ESM_BKG_0077 : copy <br>
	 * Booking Copy<br>
	 * 
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			eventResponse = copyBkgInfo(e, "");
			eventResponse.setETCData("isSuccess","Y");
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
	 * copyBkgWithoutRoute(), copyBkgWithRoute() <br>
	 * Booking Copyprocess<br>
	 * 
	 * @author 
	 * @param Event e, String pctlNo
	 * @return GeneralEventResponse
	 * @exception EventException
	 */	
	@SuppressWarnings("unchecked")
	private GeneralEventResponse copyBkgInfo(Event e, String pctlNo) throws EventException{
		try{
			EsmBkg0077Event 		event 			= (EsmBkg0077Event)e;
			GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
			GeneralBookingReceiptBC receiptBC 		= new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC 	searchBC 		= new GeneralBookingSearchBCImpl();
			BLDocumentationCMBC 	blDocCmBC 		= new BLDocumentationCMBCImpl();
			BlRatingBC 				blRatingBC 		= new BlRatingBCImpl();
			BookingHistoryMgtBC  	historyBC 		= new BookingHistoryMgtBCImpl();
			BookingUtil 		    util 			= new BookingUtil();
			BookingMasterMgtBC      masterBC        = new BookingMasterMgtBCImpl(); 

			SpecialCargoReceiptBC 	spclCgoReceiptBC= new SpecialCargoReceiptBCImpl();
			ProductCatalogCreateBC 	prdBC 			= new ProductCatalogCreateBCImpl();
			BkgCopManageBC 			copBC 			= new BkgCopManageBCImpl();

			OwnContainerBookingForecastMgtBC owncontainer = new OwnContainerBookingForecastMgtBCImpl();
			ManualBookingCopyVO manualBookingCopyVO = event.getManualBookingCopyVO();
			ManualBookingCopyVO[] manualBookingCopyVOs = event.getManualBookingCopyVOs();

			int copyCnt = Integer.parseInt(event.getCopyCnt());
			String vvdModifyFlg = event.getVvdModifyFlg();
			
			BookingCopyVO bookingCopyVO = new BookingCopyVO();
			bookingCopyVO.setBkgForCopyVO(event.getBkgForCopyVO());
			bookingCopyVO.setVslSkdVOs(event.getVslSkdVOs());
			
			String routePctlNo = "";
			String bkgNoForPctlNo = "";
			
			//00.Legacy OldVVD Check
			String tVvdOld = receiptBC.searchTrunkVvdByBkg(event.getBkgForCopyVO().getBkgNo());
			receiptBC.checkLegacySystemVVD(tVvdOld);
			
			//00.Legacy NewVVD Check
			String tVvdNew = bookingCopyVO.getBkgForCopyVO().getBkgTrunkVvd();
			receiptBC.checkLegacySystemVVD(tVvdNew);
			
			//Cehctk EDI hold flag to hold auto edi
			BookingCreationVO bookingCreationVO = receiptBC.searchBooking(event.getBkgBlNoVO());
			String ediHldFlg = bookingCreationVO.getBkgBookingInfoVO().getEdiHldFlg();
			
			if("Y".equals(vvdModifyFlg)){
				bkgNoForPctlNo = event.getBkgForCopyVO().getBkgNo();
			}
//			String trnkVslCd = event.getBkgForCopyVO().getBkgTrunkVvd().substring(0,4);
//			String preVslCd = "";
//			if(!"T".equals(event.getVslSkdVOs()[0].getVslPrePstCd())){
//				preVslCd = event.getVslSkdVOs()[0].getBkgVvdCd().substring(0,4);
//			}
						
			String newBkgNum = "";
			String copyToHistStr = "";
			String mnlFlg ="N";
			for(int i = 0 ; i < copyCnt ; i++){
				begin();

				if("Y".equals(vvdModifyFlg)){
					if(i > 0){
						routePctlNo = searchPctlNoForCopy(event.getBkgForCopyVO(), event.getVslSkdVOs(), "N", bkgNoForPctlNo);		
					} else {
			
						routePctlNo = pctlNo;
					}
				}else{
					routePctlNo = searchPctlNoForCopy(event.getBkgForCopyVO(), event.getVslSkdVOs(), "N", bkgNoForPctlNo);
				}
				log.debug("bkgNoForPctlNo:["+bkgNoForPctlNo+"],"+routePctlNo+":["+routePctlNo+ "]");
				
				bookingCopyVO.getBkgForCopyVO().setPctlNo(routePctlNo);
				// 23. Booking No creation
				if(manualBookingCopyVO != null){
					if(manualBookingCopyVO.getMnlFlg().equals("Y")){
						mnlFlg = "Y";
					}
				}
				BkgBlNoVO newBkgNoVO = new BkgBlNoVO();
				if(mnlFlg.equals("N")){
						newBkgNoVO = util.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
						bkgNoForPctlNo = newBkgNoVO.getBkgNo()+"00";
						newBkgNoVO.setBlNo(bkgNoForPctlNo);
						newBkgNoVO.setBkgNo(bkgNoForPctlNo);
				}else{
					newBkgNoVO.setBlNo(manualBookingCopyVOs[i].getMnlBkgNo());
					newBkgNoVO.setBkgNo(manualBookingCopyVOs[i].getMnlBkgNo());
					
					List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVO = new ArrayList<BkgChnBkgNoGenVO>();
					bkgChnBkgNoGenVO.add(new BkgChnBkgNoGenVO());
					bkgChnBkgNoGenVO.get(0).setBkgNo(newBkgNoVO.getBkgNo());
					masterBC.modifyChnBkgNoUseFlgOnList(bkgChnBkgNoGenVO,account.getOfc_cd(), account);
				}
				
				String [] pctlNoMapSeq = util.splitByToken(routePctlNo, "|");
				newBkgNoVO.setPctlNo(pctlNoMapSeq[0]);
				
//----------------------------------------------------------------------------------------------------------------
				BkgCloseVO bkgCloseVO = null;
				BkgBlNoVO closeBkgBlNoVO = new BkgBlNoVO();
				closeBkgBlNoVO.setBkgNo(newBkgNoVO.getBkgNo());
				closeBkgBlNoVO.setPctlNo(routePctlNo);
				String closeVvd = "";
				String closeBkgMsg = "";
				
				if(!"Y".equals(event.getCloseBkgFlag())){
					
					bkgCloseVO = util.searchBkgClose(closeBkgBlNoVO, account.getOfc_cd());		
					if(bkgCloseVO != null){
								
						String[] strParam = new String[11];
						strParam[0] = newBkgNum.replace("||", ",");
						strParam[1] = "";
						strParam[2] = "";
						strParam[3] = "";
						strParam[4] = "";
						strParam[5] = "";
						strParam[6] = bkgCloseVO.getNewVvd();
						strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
						strParam[10] = bkgCloseVO.getNewCntrList();				
						
						closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
						closeVvd = bkgCloseVO.getCloseVvd();
						
						eventResponse.setETCData("closeBkgFlag", "Y");
						
						eventResponse.setETCData("closeBkgResult", "Y");
						eventResponse.setETCData("first_vvd", closeVvd);
						eventResponse.setETCData("closeBkgMsg", closeBkgMsg);		
						
						return eventResponse;
					} 
				}
				if(!"Y".equals(event.getCbfBkgFlag())){
					boolean isCbfFinal = false;
					bkgCloseVO = util.searchBkgCbf(newBkgNoVO);
					if ( bkgCloseVO != null && bkgCloseVO.getNewVvd() != null && !bkgCloseVO.getNewVvd().trim().equals("")){
						String[] arrCBF  = owncontainer.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
						for (int j=0;j<arrCBF.length;j++){
							if(j%4 == 0){
								if("Final".equals(arrCBF[j])){
									isCbfFinal = true;
									break;
								}
							}
						}	
						if(arrCBF != null && isCbfFinal == true){
							String[] strParam = new String[11];
							strParam[0] = newBkgNum.replace("||", ",");
							strParam[1] = "";
							strParam[2] = "";
							strParam[3] = "";
							strParam[4] = "";
							strParam[5] = "";
							strParam[6] = bkgCloseVO.getNewVvd();
							strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
							strParam[10] = bkgCloseVO.getNewCntrList();				
							
							closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
							closeVvd = bkgCloseVO.getCloseVvd();	
							
							eventResponse.setETCData("cbfBkgFlag", "Y");
							
							eventResponse.setETCData("closeBkgResult", "Y");
							eventResponse.setETCData("first_vvd", closeVvd);
							eventResponse.setETCData("closeBkgMsg", closeBkgMsg);		
							
							return eventResponse;
						}
					}
				}
				
//----------------------------------------------------------------------------------------------------------------
				
				//chowing list after copy
				if(i < 1){
					newBkgNum = newBkgNoVO.getBkgNo();
					copyToHistStr = newBkgNoVO.getBkgNo();
				}else{
					newBkgNum = newBkgNum + "||" + newBkgNoVO.getBkgNo();
					copyToHistStr = copyToHistStr+", "+newBkgNoVO.getBkgNo();
				}
				
				// 24. Copy Booking
				receiptBC.copyBooking(bookingCopyVO, event.getBkgBlNoVO(), newBkgNoVO, account);
				
				// 37. Copy BkgBlDoc
//				blDocCmBC.copyBkgBlDoc(trnkVslCd, preVslCd, event.getBkgBlNoVO(), newBkgNoVO, account);
				blDocCmBC.copyBkgBlDoc("", "", event.getBkgBlNoVO(), newBkgNoVO, account);
				PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
				performReportBc.manageQtyCntrCoposite(newBkgNoVO.getBkgNo(), "CQ");		

				// 39. copySpclCgoByBkg
				List<SelectSpclCgoVO> selectSpclCgo = new ArrayList<SelectSpclCgoVO>();
				if("Y".equals(event.getBkgForCopyVO().getDcgoFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("D");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}
				if("Y".equals(event.getBkgForCopyVO().getRcFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("R");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}
				if("Y".equals(event.getBkgForCopyVO().getAwkCgoFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("A");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}
				if("Y".equals(event.getBkgForCopyVO().getBbCgoFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("B");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}			
				if("Y".equals(event.getBkgForCopyVO().getStowageFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("S");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}
				BkgBlNoVO[] bkgBlNoVOs = new BkgBlNoVO[1];
				bkgBlNoVOs[0] = newBkgNoVO;
				spclCgoReceiptBC.copySpclCgoByBkg("C", event.getBkgBlNoVO(), bkgBlNoVOs, selectSpclCgo, account);
				
				receiptBC.changeBkgStatus("Y", newBkgNoVO, false, account);
				
				blRatingBC.createRateForTro(newBkgNoVO.getBkgNo(),"N", account);	
				// 44. createBkg(other  module calling)
				copBC.createBkg(newBkgNoVO.getBkgNo(), newBkgNoVO.getPctlNo());
								
				// 45. interfaceCoa(other  module calling)
				interfaceToCoa(newBkgNoVO, "Booking Create", account);
				
				// 46. createBkgHistoryLine
				// History information
				String hisCateNm      = "Booking Copy"; 
				String crntCtnt       = "Copied From "+event.getBkgBlNoVO().getBkgNo();
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(newBkgNoVO.getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setUiId("ESM_BKG_0077");
				historyLineVO.setCrntCtnt(crntCtnt);
				historyLineVO.setHisCateNm(hisCateNm);
				historyLineVO.setBkgDocProcTpCd("CPYCRE");
				historyBC.createBkgHistoryLine(historyLineVO, account);	

				commit();
					
				try{
					String fromDt = "";
					String toDt = "";
					
					if("US".equals(event.getVslSkdVOs()[0].getPolCd().substring(0, 2)) || "CA".equals(event.getVslSkdVOs()[0].getPolCd().substring(0, 2))){
						// cut off time (after cop creation, process)
						PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(newBkgNoVO);
											
						Map railTime = prdBC.getRailRecevingTime(newBkgNoVO.getPctlNo(), prdQtyInfo, null, null);

						fromDt= (String)railTime.get("RTN_TIME");
						toDt  = (String)railTime.get("CUT_OFF");
					}
					begin(); //Transaction devision
					receiptBC.createCargoClosingTime(newBkgNoVO, fromDt, toDt, account);	
					String[] railTime = splitRailReceiveDate(newBkgNoVO);
					fromDt = railTime[0];
					toDt   = railTime[1];
					copBC.modifyRailRcvCoffDt(newBkgNoVO.getBkgNo(), fromDt, toDt, account.getUsr_id());
					commit();	
				} catch(Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}
				if(!"Y".equals(ediHldFlg)){
					// 07. sendBkgCustEdi
					searchBC.createCustBkgReceiptEdiBackEnd(newBkgNoVO, null, "Y", account);
	
					// 08. sendBkgTmlEdi
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(newBkgNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("N");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);	
	
					// 09. psa I/f auto sending add
					this.managePSABKGAuto(newBkgNoVO.getBkgNo(), "N");
				}
			}			
			
			eventResponse.setETCData("closeBkgFlag", "N");
			eventResponse.setETCData("cbfBkgFlag", "N");
			eventResponse.setETCData("closeBkgResult", "N");
			
			begin();
			
			// 46. createBkgHistoryLine
			// History information
			String hisCateNm      = "Booking Copy"; 
			String crntCtnt       = "Copied to "+copyToHistStr;
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			historyLineVO.setCaFlg("N");
			historyLineVO.setUiId("ESM_BKG_0077");
			historyLineVO.setCrntCtnt(crntCtnt);
			historyLineVO.setHisCateNm(hisCateNm);
			historyLineVO.setBkgDocProcTpCd("BKGCRE");
			historyBC.createBkgHistoryLine(historyLineVO, account);
			eventResponse.setETCData("new_booking_num", newBkgNum);
			commit();
			return eventResponse;			
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  					
		}		
	
	}
	
	
	/**
	 * copyBkgInfo() <br>
	 * If route has to be changed, Routeinformation retrieve <br>
	 * 
	 * @param 	BkgForCopyVO bkgForCopyVO, VslSkdVO[] vslSkdVOs, String withoutRoute, String bkgNo
	 * @return 	String
	 * @exception EventException
	 */
	private String searchPctlNoForCopy(BkgForCopyVO bkgForCopyVO, VslSkdVO[] vslSkdVOs, String withoutRoute, String bkgNo) throws EventException {
		String pctlNo = "";
		try{
			BookingUtil utilBC = new BookingUtil();
			
			// PrdMainInfoVO Set
			PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
			if("Y".equals(withoutRoute)){
				prdMainInfoVO.setTVvd(bkgForCopyVO.getBkgTrunkVvd());
				if(vslSkdVOs.length > 0){
					prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
					if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
					}else{
						prdMainInfoVO.setPod1N(null);
					}						
					prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
					prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
					if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
					}else{
						prdMainInfoVO.setPol1N(null);
					}
					prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
					prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());
					
					prdMainInfoVO.setLane1(null);				
				}else{
					prdMainInfoVO.setPod1(null);
					prdMainInfoVO.setPod1N(null);
					prdMainInfoVO.setPod1C(null);
					prdMainInfoVO.setPol1(null);
					prdMainInfoVO.setPol1N(null);
					prdMainInfoVO.setPol1C(null);
					prdMainInfoVO.setVvd1(null);
					prdMainInfoVO.setLane1(null);					
				}
				if(vslSkdVOs.length > 1){
					prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
					if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
					}else{
						prdMainInfoVO.setPod2N(null);
					}					
					prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
					prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
					if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
					}else{
						prdMainInfoVO.setPol2N(null);
					}					
					prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
					prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
					prdMainInfoVO.setLane2(null);				
				}else{
					prdMainInfoVO.setPod2(null);
					prdMainInfoVO.setPod2N(null);
					prdMainInfoVO.setPod2C(null);
					prdMainInfoVO.setPol2(null);
					prdMainInfoVO.setPol2N(null);
					prdMainInfoVO.setPol2C(null);
					prdMainInfoVO.setVvd2(null);
					prdMainInfoVO.setLane2(null);					
				}
				if(vslSkdVOs.length > 2){
					prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
					if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
					}else{
						prdMainInfoVO.setPod3N(null);
					}					
					prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
					prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
					if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
					}else{
						prdMainInfoVO.setPol3N(null);
					}					
					prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
					prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
					prdMainInfoVO.setLane3(null);				
				}else{
					prdMainInfoVO.setPod3(null);
					prdMainInfoVO.setPod3N(null);
					prdMainInfoVO.setPod3C(null);
					prdMainInfoVO.setPol3(null);
					prdMainInfoVO.setPol3N(null);
					prdMainInfoVO.setPol3C(null);
					prdMainInfoVO.setVvd3(null);
					prdMainInfoVO.setLane3(null);					
				}
				if(vslSkdVOs.length > 3){
					prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
					if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
					}else{
						prdMainInfoVO.setPod4N(null);
					}					
					prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
					prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
					if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
					}else{
						prdMainInfoVO.setPol4N(null);
					}				
					prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
					prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
					prdMainInfoVO.setLane4(null);				
				}else{
					prdMainInfoVO.setPod4(null);
					prdMainInfoVO.setPod4N(null);
					prdMainInfoVO.setPod4C(null);
					prdMainInfoVO.setPol4(null);
					prdMainInfoVO.setPol4N(null);
					prdMainInfoVO.setPol4C(null);
					prdMainInfoVO.setVvd4(null);
					prdMainInfoVO.setLane4(null);					
				}			
				
				if(bkgForCopyVO.getHotDeFlg() != null){
					prdMainInfoVO.setPmF(bkgForCopyVO.getHotDeFlg());
				}else{
					prdMainInfoVO.setPmF("N");
				}			
				if(bkgForCopyVO.getDcgoFlg() != null){
					prdMainInfoVO.setDgF(bkgForCopyVO.getDcgoFlg());
				}else{
					prdMainInfoVO.setDgF("N");
				}					
				if(bkgForCopyVO.getRcFlg() != null){
					prdMainInfoVO.setRfF(bkgForCopyVO.getRcFlg());
				}else{
					prdMainInfoVO.setRfF("N");
				}					
				if(bkgForCopyVO.getAwkCgoFlg() != null){
					prdMainInfoVO.setAkF(bkgForCopyVO.getAwkCgoFlg());
				}else{
					prdMainInfoVO.setAkF("N");
				}					
				if(bkgForCopyVO.getBbCgoFlg() != null){
					prdMainInfoVO.setBbF(bkgForCopyVO.getBbCgoFlg());
				}else{
					prdMainInfoVO.setBbF("N");
				}	
				if(bkgForCopyVO.getHngrFlg() != null){
					prdMainInfoVO.setHgF(bkgForCopyVO.getHngrFlg());
				}else{
					prdMainInfoVO.setHgF("N");
				}					
			}else{
				prdMainInfoVO.setCopyCnt("1");	
			}

			prdMainInfoVO.setRfa(bkgForCopyVO.getRfaNo());
			prdMainInfoVO.setSc(bkgForCopyVO.getScNo());			
			prdMainInfoVO.setBkgNo(bkgNo);				
			
			
			// BkgBlNoVO creation
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			
			PrdParameterVO prdParameterVO = new PrdParameterVO();			
			prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			if("Y".equals(withoutRoute)){
				// 01. searchPrdParameter
				prdParameterVO = utilBC.searchPrdParmForFullRoute(prdParameterVO);
			}
			
			// f_cmd,pc_mode Set
			prdParameterVO.getPrdMainInfoVO().setFCmd("3");
			if("Y".equals(withoutRoute)){
				prdParameterVO.getPrdMainInfoVO().setPcMode("B");
				// AS Creating, send without Booking no
				prdParameterVO.getPrdMainInfoVO().setBkgNo("");
				prdParameterVO.getBkgBlNoVO().setBkgNo("");				
			}else{
				prdParameterVO.getPrdMainInfoVO().setPcMode("Y");
				prdParameterVO.getPrdMainInfoVO().setBkgNo(bkgNo);
				prdParameterVO.getBkgBlNoVO().setBkgNo(bkgNo);
			}
			// 03. createProdCtlRout
			ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
			
			pctlNo = proBC.createPrdCtlgRout(prdParameterVO, account);			
		}catch(EventException e){
			log.error("err"+e.toString(),e);
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);			
		}
		return pctlNo;
	}	
	
	/**
	 * ESM_BKG_0079 : open <br>
	 * for button visible, enable process,BkgBlNoVO  retrieve<br>
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgBlNoVO(Event e) throws EventException {
		EsmBkg0079Event event = (EsmBkg0079Event)e;
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoVO = command.searchBkgBlNoVO(event.getBkgBlNoVO());
			
			if (bkgBlNoVO == null) {
				eventResponse.setETCData("bkg_no",       "");
				eventResponse.setETCData("ca_no",        "");
				eventResponse.setETCData("ca_flg",       "");
				eventResponse.setETCData("bdr_flg",      "");		
				eventResponse.setETCData("ca_exist_flg", "");
			} else {
				eventResponse.setETCData("bkg_no",       JSPUtil.getNullNoTrim(bkgBlNoVO.getBkgNo()));
				eventResponse.setETCData("ca_no",        JSPUtil.getNullNoTrim(bkgBlNoVO.getCaNo()));
				eventResponse.setETCData("ca_flg",       JSPUtil.getNullNoTrim(bkgBlNoVO.getCaFlg()));
				eventResponse.setETCData("bdr_flg",      JSPUtil.getNullNoTrim(bkgBlNoVO.getBdrFlg()));		
				eventResponse.setETCData("ca_exist_flg", JSPUtil.getNullNoTrim(bkgBlNoVO.getCaExistFlg()));
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0079 : c/a confirm <br>
	 * C/A completion
	 * 
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse completeCA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0079Event event = (EsmBkg0079Event)e;
				 
		try {
			begin();	
			BookingUtil util = new BookingUtil();
			String caRtnStr = completeCA(event.getBkgBlNoVO());
			String [] arrCaRtn = util.splitByToken(caRtnStr, "|");
			String corrNo = arrCaRtn[0];
			String preChecking = arrCaRtn[1];
			eventResponse.setETCData("ca_no", corrNo);
			eventResponse.setETCData("pre_checking", preChecking);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
			
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}	
	
	/**
	 * completeCA() <br> 
	 * C/A completion and close handling. <br>
	 * 
	 * @author    
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	private String completeCA(BkgBlNoVO bkgBlNoVO) throws EventException {
		
		BDRCorrectionBC         bDRCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     bLDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BLIssuanceBC            bLIssuanceBC            = new BLIssuanceBCImpl();
		BookingHistoryMgtBC     bookingHistoryMgtBC     = new BookingHistoryMgtBCImpl();
		RevenueDebitNoteBC      revenueDebitNoteBC      = new RevenueDebitNoteBCImpl();
		BookingUtil             bookingUtil             = new BookingUtil(); 
		CargoReleaseOrderBC     cargoReleaseOrderBC     = new CargoReleaseOrderBCImpl();
		ProductCatalogCreateBC  prdBC			     	= new ProductCatalogCreateBCImpl(); 
		BkgCopManageBC          copBC    			    = new BkgCopManageBCImpl();	
		ReceiveOwnBkgCancelRequestMgtBC bkgCancelReqBC  = new ReceiveOwnBkgCancelRequestMgtBCImpl();
		BookingUtil utilBC 								= new BookingUtil();	
		 
		try {			
			//If Replan List ard changed, retrieve
			List<CorrReplanVO> corrReplanVOs = bDRCorrectionBC.searchCorrReplan(bkgBlNoVO);

			String spclVvdChange = "";
			String preChecking = "N/A";
			for(int i=0;i<corrReplanVOs.size();i++){
				if("SPCL_VVD_CHANGE".equals(corrReplanVOs.get(i).getOperation())){
					spclVvdChange = "SPCL_VVD_CHANGE";
				}
			}
			ScgVvdAproRqstVO[] caScgVvdVOs = null;
			if(spclVvdChange.equals("SPCL_VVD_CHANGE")){
				caScgVvdVOs = specialCargoReceiptBC.searchBkgVvdCa(bkgBlNoVO.getBkgNo());
			}

			for(int i=0;i<corrReplanVOs.size();i++){
				if("REPLAN".equals(corrReplanVOs.get(i).getOperation())){
					OldBkgInfoVO oldBkgInfoVO = generalBookingReceiptBC.searchOldBkgInfo(bkgBlNoVO);
					BkgBlNoVO codBkgBlNoVO = bkgBlNoVO;
					codBkgBlNoVO.setPctlNo(oldBkgInfoVO.getPctlNo());
					CODCorrectionBC codBC = new CODCorrectionBCImpl();
					
					//POD,DEL 占쎈쨨�뜝�뜴泥롥뜝占� �솻洹⑥삕�뇦猿뗫윪占쎈뻣 COP �뜝�럩源덌옙鍮듿뜝占�
					CodEtcVO codEtcVO = codBC.searchCopForBkgCodParam(codBkgBlNoVO);
					if(codEtcVO!=null){
						UpdBkgForBkgCodVO updBkgForBkgCodVO = new UpdBkgForBkgCodVO();
						updBkgForBkgCodVO.setBkgNo(codBkgBlNoVO.getBkgNo());
						updBkgForBkgCodVO.setOldPodYdCd(codEtcVO.getOldPodNodCd());
						updBkgForBkgCodVO.setOldDelYdCd(codEtcVO.getOldDelNodCd());
						updBkgForBkgCodVO.setNewPodYdCd(codEtcVO.getNewPodNodCd());
						updBkgForBkgCodVO.setNewDelYdCd(codEtcVO.getNewDelNodCd());
						copBC.updateBkgForBkgCod(updBkgForBkgCodVO);
						
						BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setUiId("ESM_BKG_0079_01");			
						historyLineVO.setHisCateNm("COD");
						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
						historyLineVO.setCaFlg("Y");
						historyLineVO.setCrntCtnt("COD Request Created");				
						historyBC.createBkgHistoryLine(historyLineVO, account);
					}
				}
			}
			
			//keep VVD information for DG cancel about source BKG
			List<SearchDgCancelInfoVO> dgCancelInfo = null;
			dgCancelInfo = specialCargoReceiptBC.searchDgCancelInfo(bkgBlNoVO.getBkgNo());

			//------------------------
			// CA Complete process
			//------------------------
			String copyTypeCd = "BKG";
			
			//add. location changing
			add1stCaHist(bkgBlNoVO);
			
			//01. 
			bDRCorrectionBC.modifyCngItemFlag      (bkgBlNoVO, account);
			//02. 
			bLDocumentationBLBC.modifyCaComplete   (bkgBlNoVO);			
			
			//03. 
			generalBookingReceiptBC.createBookingCA(bkgBlNoVO, copyTypeCd);
			//04. 
			bLDocumentationBLBC.createBlCA         (bkgBlNoVO, copyTypeCd);
			//05. 
			blRatingBC.createRateCA                (bkgBlNoVO, copyTypeCd);
			//06. 
			specialCargoReceiptBC.createSpclCA     (bkgBlNoVO, copyTypeCd);
			//add : createIssCA 
			bLIssuanceBC.createIssCA               (bkgBlNoVO, copyTypeCd); 	
			
			//AddBKgInvTaxIF
			BkgChgRateVO bkgChgRateVO = new BkgChgRateVO();
			bkgChgRateVO.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgChgRateVO.setIfRmk("C/A Confirm");
			generalBookingReceiptBC.addBkgInvTaxIF(bkgChgRateVO, account);
			//------------------------
			// CA History creation
			//------------------------
			//07. addCaHistory(e) call 

			String strCaRsnCd    = ""; 
			String strCaCorrRmk  = "";
			String strRdnAcptFlg = "N";
			addCaHistory(strCaRsnCd, strCaCorrRmk, bkgBlNoVO, strRdnAcptFlg, "N");			

			//------------------------
			// CA History Temp delete
			//------------------------
			copyTypeCd = "TEMP";
			
			//08. 
			specialCargoReceiptBC.removeCA  (bkgBlNoVO, copyTypeCd);


			if(dgCancelInfo != null && dgCancelInfo.size() > 0){
				
				//DG BKG cancel if booking is canceled
				String bkgStsCd = utilBC.searchBkgStatusByBkg(bkgBlNoVO);

				//check DG deleted
				List<SearchDgCancelInfoVO> dgCancelInfoAfter = null;
				dgCancelInfoAfter = specialCargoReceiptBC.searchDgCancelInfo(bkgBlNoVO.getBkgNo());
				
				List<ScgVvdDgCgoCxlRqstVO> scgVvdDgCgoCxlRqstVOs = new ArrayList<ScgVvdDgCgoCxlRqstVO>();
				if("X".equals(bkgStsCd)){ //call BKG cancel
					scgVvdDgCgoCxlRqstVOs = specialCargoReceiptBC.manageDgBkgCancel(bkgBlNoVO.getBkgNo(), account, scgVvdDgCgoCxlRqstVOs, "Booking Canceled");
					bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
				}else if (dgCancelInfoAfter.size() < 1){ //call DG cancel
					specialCargoReceiptBC.manageDgDgCancel(dgCancelInfo, account, scgVvdDgCgoCxlRqstVOs, "DG Cancel");
					bkgCancelReqBC.addScgVvdDgCgoCxlRqst(scgVvdDgCgoCxlRqstVOs);
				}
			}

			//09. 
			blRatingBC.removeCA             (bkgBlNoVO, copyTypeCd);
			//10. 
			bLDocumentationBLBC.removeCA    (bkgBlNoVO, copyTypeCd);
			//11. 
			generalBookingReceiptBC.removeCA(bkgBlNoVO, copyTypeCd);
			//add. 
			bLIssuanceBC.removeCA           (bkgBlNoVO, copyTypeCd);
			//12. 
			bDRCorrectionBC.removeCATemp    (bkgBlNoVO);
						
			//add. 
			bookingHistoryMgtBC.modifyCaCorrNoForHistory(bkgBlNoVO);
			
			blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);
			
			if ("X".equalsIgnoreCase(bookingUtil.searchBkgStatusByBkg(bkgBlNoVO))) {
				copBC.cancelBkg(bkgBlNoVO.getBkgNo());
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setCorrNo(bkgBlNoVO.getCaNo());
				historyLineVO.setBkgDocProcTpCd("BKGCAN");//booking cancel for doc performance
				historyLineVO.setUiId("ESM_BKG_0079_01");
				historyLineVO.setCrntCtnt("Booking Canceled.");
				historyLineVO.setHisCateNm("Booking Cancel."); 
				bookingHistoryMgtBC.createBkgHistoryLine(historyLineVO, account);
			}
			
			if(corrReplanVOs.size()>0){
				for(int i=0;i<corrReplanVOs.size();i++){
					if("CNTR_ATTACH".equals(corrReplanVOs.get(i).getOperation())){	
						copBC.attachCntr(bkgBlNoVO.getBkgNo(), corrReplanVOs.get(i).getCntrNo(), corrReplanVOs.get(i).getCntrPrtFlg());
					}
					if("CNTR_DETACH".equals(corrReplanVOs.get(i).getOperation())){	
						copBC.detachCntr(bkgBlNoVO.getBkgNo(), corrReplanVOs.get(i).getCntrNo(), corrReplanVOs.get(i).getCntrPrtFlg());
					}
					if("CNTR_CONFIRM".equals(corrReplanVOs.get(i).getOperation())){
						copBC.confirmCntr(bkgBlNoVO.getBkgNo());
					}
				}
				
				for(int i=0;i<corrReplanVOs.size();i++){
					if("REPLAN".equals(corrReplanVOs.get(i).getOperation())){		
						PrdParameterVO prdParameterVO = new PrdParameterVO();
						PrdMainInfoVO  prdMainInfoVO = new PrdMainInfoVO();
						BkgBlNoVO      caBkgBlNoVO = bkgBlNoVO;
									
						caBkgBlNoVO.setCaFlg("N");
						prdMainInfoVO.setFCmd("3");
						prdMainInfoVO.setBkgNo(caBkgBlNoVO.getBkgNo());
						prdMainInfoVO.setPcMode("R");
						prdParameterVO.setBkgBlNoVO(caBkgBlNoVO);
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
						prdParameterVO = bookingUtil.searchPrdParmForFullRoute(prdParameterVO);

						log.debug("operation:"+corrReplanVOs.get(i).getOcnSeq());
						
						prdParameterVO.getPrdMainInfoVO().setOcnSeq(corrReplanVOs.get(i).getOcnSeq());
												
						bookingUtil.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
						// 03. createProdCtlRout 
						String pctlNoMapStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
						String [] pctlNoMapSeq = bookingUtil.splitByToken(pctlNoMapStr,"|");
						copBC.updateBkg(caBkgBlNoVO.getBkgNo(), pctlNoMapSeq[1]);
						
//						BkgBlNoVO codBkgBlNoVO = bkgBlNoVO;
//						codBkgBlNoVO.setPctlNo(oldBkgInfoVO.getPctlNo());
//						CODCorrectionBC codBC = new CODCorrectionBCImpl();
//						codBC.manageAutoCod(codBkgBlNoVO, account, "CA");
//						
//						//POD,DEL 占쎈쨨�뜝�뜴泥롥뜝占� �솻洹⑥삕�뇦猿뗫윪占쎈뻣 COP �뜝�럩源덌옙鍮듿뜝占�
//						CodEtcVO codEtcVO = codBC.searchCopForBkgCodParam(codBkgBlNoVO);
//						if(codEtcVO!=null){
//							UpdBkgForBkgCodVO updBkgForBkgCodVO = new UpdBkgForBkgCodVO();
//							updBkgForBkgCodVO.setBkgNo(codBkgBlNoVO.getBkgNo());
//							updBkgForBkgCodVO.setOldPodYdCd(codEtcVO.getOldPodNodCd());
//							updBkgForBkgCodVO.setOldDelYdCd(codEtcVO.getOldDelNodCd());
//							updBkgForBkgCodVO.setNewPodYdCd(codEtcVO.getNewPodNodCd());
//							updBkgForBkgCodVO.setNewDelYdCd(codEtcVO.getNewDelNodCd());
//							copBC.updateBkgForBkgCod(updBkgForBkgCodVO);
//							
//							BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
//							HistoryLineVO historyLineVO = new HistoryLineVO();
//							historyLineVO.setUiId("ESM_BKG_0079_01");			
//							historyLineVO.setHisCateNm("COD");
//							historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
//							historyLineVO.setCaFlg("Y");
//							historyLineVO.setCrntCtnt("COD Request Created");				
//							historyBC.createBkgHistoryLine(historyLineVO, account);
//						}
					}
				}
			}			
			
			//14. interfaceCoa call
			interfaceToCoa(bkgBlNoVO, "Booking Update", account);	

			//13. interfaceToInv call
			interfaceToInv(bkgBlNoVO, account);  
			
			//If vvd changing spcl cgo withstand both automatic re-request
			if(spclVvdChange.equals("SPCL_VVD_CHANGE")){
				preChecking = reRequestSpclCgoApproval(bkgBlNoVO, "C/A VVD CHANGE", caScgVvdVOs, "");

				if("pre-checking".equals(preChecking)){
					preChecking = "Y";
				} else {
					preChecking = "N";						
				}
			}
			
            //add2. 
			OblIssVO oblIssVO = bookingUtil.searchOblIssue(bkgBlNoVO); 
			
			if("Y".equals(oblIssVO.getRdnAcptFlg())){
				//add2. 
				RevDrNoteVO revDrNoteVO = new RevDrNoteVO(); 
				CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
				bkgRevDrNoteVO.setBkgNo      (bkgBlNoVO.getBkgNo());  
				bkgRevDrNoteVO.setBkgCorrNo  (bkgBlNoVO.getCaNo()); 
				bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
				bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
				bkgRevDrNoteVO.setReceiverRmk("");
				revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);
				
				revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
			}			
			//add2. 
			OblRdemVO oblRdem = new OblRdemVO();
			oblRdem.setBlNo      (oblIssVO.getBlNo());  
			oblRdem.setCgorTeamCd("C");
			oblRdem.setCgoEvntNm ("B/L Correct");
			oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			oblRdem.setEvntOfcCd (account.getOfc_cd());
			oblRdem.setEvntUsrId (account.getUsr_id());
			oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

			try{
				cargoReleaseOrderBC.setupFocByObl(oblRdem);
			} catch(Exception crEx){
				log.error("err " + crEx.toString(), crEx);
			}	
			return bkgBlNoVO.getCaNo()+"|"+preChecking;			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
	}	
	
	/**
	 * C/A confirm, auto c/a process<br>
	 * C / A retrieve the presence and absence of history, dummy c/a information creation<br>
	 * 
	 * @author    
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    String
	 * @exception EventException
	 */
	private String add1stCaHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		
		BDRCorrectionBC         bDRCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     bLDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BLIssuanceBC            bLIssuanceBC            = new BLIssuanceBCImpl();

		String strReturn = "N";
		
		try {
			String copyTypeCd = "HIST000"; 
			
			//01. 
			strReturn = bDRCorrectionBC.add1stCaHist(bkgBlNoVO, account);
						
			if ("N".equals(strReturn)) {
				//02. 
				bkgBlNoVO.setCaNo("0000000001"); 
				generalBookingReceiptBC.createBookingCA(bkgBlNoVO, copyTypeCd); 
				
				//03. 
				bLDocumentationBLBC.createBlCA         (bkgBlNoVO, copyTypeCd); 
				
				//04. 
				specialCargoReceiptBC.createSpclCA     (bkgBlNoVO, copyTypeCd); 
				
				//05. 
				blRatingBC.createRateCA                (bkgBlNoVO, copyTypeCd); 
				
				//06. 
				bLIssuanceBC.createIssCA               (bkgBlNoVO, copyTypeCd); 
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		
		return strReturn; 
	}	
	
	/**
	 * start C/A , History data creation(ESM_BKG_0079)<br>

	 * 
	 * @author    
	 * @param     String caRsnCd
	 * @param     String caCorrRmk
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String rdnAcptFlg
	 * @param     String autoCaFlg
	 * @return    BkgBlNoVO
	 * @exception EventException
	 */
	private BkgBlNoVO addCaHistory(String caRsnCd, String caCorrRmk, BkgBlNoVO bkgBlNoVO, String rdnAcptFlg, String autoCaFlg) throws EventException {
		
		BDRCorrectionBC         bDRCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     bLDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BLIssuanceBC            bLIssuanceBC            = new BLIssuanceBCImpl();
		 
		BkgBlNoVO schBkgBlNoVO = new BkgBlNoVO();
		
		try {
			String tempHistCd = "H";
			String copyTypeCd = "HIST";

			//01. createTempHist
			//schBkgBlNoVO = bDRCorrectionBC.createTempHist(bkgBlNoVO, tempHistCd, caRsnCd, caCorrRmk, account);
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			bkgCorrectionVO.setCaRsnCd   (caRsnCd);
			bkgCorrectionVO.setBkgCorrRmk(caCorrRmk);
			bkgCorrectionVO.setRdnAcptFlg(rdnAcptFlg);
			schBkgBlNoVO = bDRCorrectionBC.createTempHist(bkgBlNoVO, tempHistCd, bkgCorrectionVO, account);

			//02. createBookingCA
			generalBookingReceiptBC.createBookingCA(schBkgBlNoVO, copyTypeCd);
			
			//03. createBlCA 
			bLDocumentationBLBC.createBlCA         (schBkgBlNoVO, copyTypeCd);
			
			//04. createSpclCA
			specialCargoReceiptBC.createSpclCA     (schBkgBlNoVO, copyTypeCd);
			
			//05. createRateCA
			blRatingBC.createRateCA                (schBkgBlNoVO, copyTypeCd);
			
			//06. createIssCA -> add 
			bLIssuanceBC.createIssCA               (schBkgBlNoVO, copyTypeCd);
			
			// auto c / a is not only executed 
			// - Auto C / A without the direct input tray.
//			if("N".equals(autoCaFlg)){
//				//07. modifyCngItemFlag
//				bDRCorrectionBC.modifyCngItemFlag      (schBkgBlNoVO, account);
//			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		
		return schBkgBlNoVO; 
	}	
	
	/**
	 * ESM_BKG_0079 : c/a cancel <br>
	 *  c/a cancel handling.<br>
	 * 
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0079Event event = (EsmBkg0079Event)e;
		BDRCorrectionBC         bDRCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     bLDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BookingHistoryMgtBC     bookingHistoryMgtBC     = new BookingHistoryMgtBCImpl();
		BLIssuanceBC            bLIssuanceBC            = new BLIssuanceBCImpl();
		 
		try {
			begin();			
			String copyTypeCd = "TEMP";
			
			//00. RemoveRollOver
			generalBookingReceiptBC.removeCARollOvr(event.getBkgBlNoVO().getBkgNo());
			
			//01. cancelCA
			bDRCorrectionBC.cancelCA(event.getBkgBlNoVO(), account);
						
			//02. 
			specialCargoReceiptBC.removeCA  (event.getBkgBlNoVO(), copyTypeCd);
			//03. 
			blRatingBC.removeCA             (event.getBkgBlNoVO(), copyTypeCd);
			//04. 
			bLDocumentationBLBC.removeCA    (event.getBkgBlNoVO(), copyTypeCd);
			//05. 
			generalBookingReceiptBC.removeCA(event.getBkgBlNoVO(), copyTypeCd);
			//add. 
			bLIssuanceBC.removeCA           (event.getBkgBlNoVO(), copyTypeCd);
			//06. 
			bDRCorrectionBC.removeCATemp    (event.getBkgBlNoVO());
			//07. 
			bookingHistoryMgtBC.removeTmpHistory(event.getBkgBlNoVO());
			
			commit();			
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : Save success
			
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_9424 : retrieve <br>
	 * mty bkg update bkg data and cntr data, VL container List  retrieve<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBooking(Event e) throws EventException{
		try{
			EsmBkg9424Event event = (EsmBkg9424Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			
			RepoBkgForUpdateVO repoBkgForUpdateVO = searchBC.searchEmptyBooking(event.getBkgBlNoVO(), event.getBkgMvmtCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setETCData(repoBkgForUpdateVO.getRepoBkgVO().getColumnValues());
			eventResponse.setRsVoList(repoBkgForUpdateVO.getRepoCntr());	
			eventResponse.setRsVoList(repoBkgForUpdateVO.getVlCntr());				
			eventResponse.setRsVoList(repoBkgForUpdateVO.getCntrTpSz());		
			if(repoBkgForUpdateVO.getBkgQuantity() != null){
				eventResponse.setRsVoList(repoBkgForUpdateVO.getBkgQuantity());		
			}
			eventResponse.setETCData("SuccessYn", "Y");		
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_9424 : cntr_no change <br>
	 * Container Digit,T/S,STS retrieve<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrChkDigit(Event e) throws EventException{
		try{
			EsmBkg9424Event event = (EsmBkg9424Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			
			CntrChkDigitVO cntrChkDigitVO = searchBC.searchCntrChkDigit(event.getCntrNo());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			if(cntrChkDigitVO != null){
				eventResponse.setETCData(cntrChkDigitVO.getColumnValues());
			}			
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}		
	
	
	/**
	 * ESM_BKG_9424 : stowage check <br>
	 * Stowage Plan retrieve <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyCntrList(Event e) throws EventException{
		try{
			EsmBkg9424Event event = (EsmBkg9424Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchBC.searchMtyCntrList(event.getMvmtOption(), event.getRepoBkgVO().getBkgTrunkVvd(), event.getRepoBkgVO().getOrgYdCd()));	
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}				

	/**
	 * ESM_BKG_9424 : cancel <br>
	 * Empty Booking Cancel process.<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelEmptyBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg9424Event event = (EsmBkg9424Event)e;

		BLDocumentationCMBC     blDocCMBC     = new BLDocumentationCMBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		CntrRepoExecutionPlanEstablishBC cntrRepoBC = new CntrRepoExecutionPlanEstablishBCImpl();
		 
		try {
			begin();			
			
			// 58. cancelContainer
			blDocCMBC.cancelBkgCntr(event.getBkgBlNoVO(), account);
			// 60. cancelEmptyBkg
			receiptBC.cancelMtyBkg(event.getBkgBlNoVO(), account);
			
			// 62. modifyMtyCancel -EQR
			MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(event.getBkgBlNoVO().getBkgNo());
			
			if(event.getBkgBlNoVO().getBkgNo().length()==11 
					||(event.getBkgBlNoVO().getBkgNo().length()==12&&"00".equals(event.getBkgBlNoVO().getBkgNo().substring(10)))){
				mtyBkgVO.setSplitFlg("N");				
			} else {
				mtyBkgVO.setSplitFlg("Y");	
			}
			log.debug("splitFlag:"+mtyBkgVO.getSplitFlg());
			mtyBkgVO.setUsrId(account.getUsr_id());
			
			// In case of cancel do not vol change process(
//			cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);			
			cntrRepoBC.modifyMtyBkgCancel(mtyBkgVO);

			commit();		
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}	


	/**
	 * ESM_BKG_9424 : save <br>
	 * Empty Booking Save<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMtyRepoBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg9424Event event = (EsmBkg9424Event)e;

		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationBLBC     blDocBLBC = new BLDocumentationBLBCImpl();
		BookingUtil           utilBC    = new BookingUtil();
		ContainerMovementMgtBC  ctmCmd    = new ContainerMovementMgtBCImpl();
		CntrRepoExecutionPlanEstablishBC cntrRepoBC = new CntrRepoExecutionPlanEstablishBCImpl();
		 
		try {
			begin();			
			RepoBkgForUpdateVO repoBkgForUpdateVO = new RepoBkgForUpdateVO();
			repoBkgForUpdateVO.setBkgBlNoVO(event.getBkgBlNoVO());
			repoBkgForUpdateVO.setRepoBkgVO(event.getRepoBkgVO());
			repoBkgForUpdateVO.setRepoCntrVOs(event.getRepoCntrVOs());
			String trunkVvd = event.getTrunkVvd();
			String bkgNo = event.getBkgBlNoVO().getBkgNo();
			
			// 15. modifyRepoBkg 
			receiptBC.modifyMtyRepoBkg(repoBkgForUpdateVO, account);
			
			// 26. manageEmptyCntr
			List<CusCtmMovementVO> ctmMovementVO = blDocBLBC.manageEmptyCntr(repoBkgForUpdateVO, trunkVvd, account);
			
			// 42. completeModifyMtyRepoBkg
			List<BkgQuantityVO> bkgQtyVO = receiptBC.completeModifyMtyRepoBkg(repoBkgForUpdateVO, account);

			// 64. 
			log.debug("to ctm ["+ctmMovementVO.size()+"] VL container");
			for(int i=0;i<ctmMovementVO.size();i++){
				// In case of VL ,  update as CTM
				if(!"VL".equals(ctmMovementVO.get(i).getMvmtStsCd())) 
					continue;
				log.debug("cntr_no:"+ctmMovementVO.get(i).getCntrNo());
				log.debug("cnmv_yr:"+ctmMovementVO.get(i).getCnmvYr());
				log.debug("cnmv_id_no:"+ctmMovementVO.get(i).getCnmvIdNo());
				log.debug("trnk_vsl_cd:"+ctmMovementVO.get(i).getTrnkVslCd());
				log.debug("crnt_vsl_cd:"+ctmMovementVO.get(i).getCrntVslCd());				
				ctmCmd.modifyMovementFromBkgForPreVL(ctmMovementVO.get(i));
			}
			
			// 65. PRE_STS_FLG,BKG_NO,VVD information UPDATE(20091123 add)			
			if(event.getRepoCntrVOs() != null && event.getRepoCntrVOs().length > 0){
				int cntrCnt = event.getRepoCntrVOs().length;
				MstContainerVO mstContainerVO = null;
				BLDocumentationCMBC cmBlBC = new BLDocumentationCMBCImpl();
				ContainerOnOffhireBC cntrOffBC = new ContainerOnOffhireBCImpl();
				CrossItemVO crossItemVO = new CrossItemVO();
				CusCtmMovementVO custCtmVO = new CusCtmMovementVO();
				String cntrNo = "";
				for(int i = 0 ; i < cntrCnt ; i++){
					cntrNo = event.getRepoCntrVOs()[i].getCntrNo()+event.getRepoCntrVOs()[i].getCntrNoPst();
					// In case of VL, MST_CONTAINER�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥�몡�뜝�럥�돷勇싲８媛숂뙼占쏙옙�쐻占쎈윞占쎈릊TE
					if("VL".equals(event.getRepoCntrVOs()[i].getStsCd())){
						mstContainerVO = cmBlBC.searchMstCntrForMst(cntrNo);
						if(mstContainerVO != null){
							custCtmVO.setCntrSvrId(mstContainerVO.getSysAreaGrpId());
							custCtmVO.setCnmvYr(mstContainerVO.getCnmvYr());
							custCtmVO.setCnmvIdNo(mstContainerVO.getCnmvIdNo());
							custCtmVO.setCnmvSeq(mstContainerVO.getCnmvSeq());
							custCtmVO.setCnmvSplitNo(mstContainerVO.getCnmvSplitNo());
							custCtmVO.setCnmvCycNo(mstContainerVO.getCnmvCycNo());
							custCtmVO.setCnmvEvntDt(mstContainerVO.getCnmvDt());
							custCtmVO.setPreStsFlg("N");
							custCtmVO.setBkgNo(bkgNo);
							custCtmVO.setBkgKnt(mstContainerVO.getBkgKnt());
							custCtmVO.setFcntrFlg("N");
							custCtmVO.setOrgYdCd(mstContainerVO.getCrntYdCd());
							custCtmVO.setDestYdCd(mstContainerVO.getDestYdCd());
							custCtmVO.setCntrId(trunkVvd);
							custCtmVO.setMvmtStsCd(mstContainerVO.getCnmvStsCd());
							custCtmVO.setAciacDivCd(mstContainerVO.getAciacDivCd());
							custCtmVO.setUpdUsrId(account.getUsr_id());
							custCtmVO.setCntrNo(cntrNo);

							crossItemVO.setUpdateMaster(true);
							crossItemVO.setCusCtmMovementVO(custCtmVO);
							
							cntrOffBC.updateCntrMasterByMvmtBasic(crossItemVO);
						}
					}
				}
			}

			MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(bkgNo);
			mtyBkgVO.setUsrId(account.getUsr_id());
			
			if(bkgNo.length()==11 
					||(bkgNo.length()==12&&"00".equals(bkgNo.substring(10)))){
				mtyBkgVO.setSplitFlg("N");				
			} else {
				mtyBkgVO.setSplitFlg("Y");	
			}
			
			if("Y".equals(mtyBkgVO.getSplitFlg())){
//				1. Splitchanging
//				   1) volumeChange Call
//				
				cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
				if(bkgQtyVO.size()==0){
					cntrRepoBC.modifyMtyBkgCancel(mtyBkgVO);
				} 

//				   2) Original BKG volumeChange Call
				MtyBkgVO mstMtyBkgVO = new MtyBkgVO();
				mstMtyBkgVO.setMtyBkgNo(utilBC.searchSplitMstBkgNo(bkgNo));
				mstMtyBkgVO.setUsrId(account.getUsr_id());
				mstMtyBkgVO.setSplitFlg("N");	
				cntrRepoBC.modifyMtyBkgVolChange(mstMtyBkgVO);
			} else {
//				2. Original changing
//				   1) volumeChange Call
				if(bkgQtyVO.size()==0){
//					cntrRepoBC.modifyMtyBkgCancel(mtyBkgVO);
					cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
				} else {
					cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
				} 
			}
			commit();		
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * sendBkgTmlEdiMulti() <br>
	 * creating Terminal information as Flat File and sending it with EDI<br>
	 * 
	 * @author	
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   List<BkgVvdVO> oldVvdVOs
	 * @param   String bracCd
	 * @param   String ediKind
	 * @param   String autoManualFlg
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgTmlEdi(BkgBlNoVO bkgBlNoVO, List<BkgVvdVO> oldVvdVOs, String rcvId, String bracCd, String ediKind, String autoManualFlg) throws EventException{
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			if (bkgBlNoVO != null) {
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(oldVvdVOs);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg(autoManualFlg);
				vender301ParamVO.setRcvId(rcvId);				
				
				List<BkgNtcHisVO> bkgNtcHisVOs = command.createTmlBkgReceiptEdi(vender301ParamVO, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "");
			}

			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		return eventResponse;
	}		

	/**
	 * ESM_BKG_0702 : edi transmit <br>
	 * creating Terminal information as Flat File and sending it with EDI<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgTmlEdiMulti(Event e) throws EventException{
		BkgBlNoVO[] bkgBlNoVO = null;
		CustTpIdVO[] custTpIdVO = null;
		String bracCd = null;
		String ediKind = null;
		String autoManualFlg = null;
		if (e.getEventName().equalsIgnoreCase("EsmBkg0702Event")) {
			EsmBkg0702Event event = (EsmBkg0702Event)e;
			bkgBlNoVO = event.getBkgBlNoVOs();
			custTpIdVO = event.getCustTpIdVOs();
			bracCd = "M";
			ediKind = "BM";
			autoManualFlg = "N";
		} else {
			EsmBkg0616Event event = (EsmBkg0616Event)e;
			custTpIdVO = event.getCustTpIdVOs();
			bkgBlNoVO = event.getBkgBlNoVOs();
			bracCd = event.getBracCd();
			ediKind = "BM";
			/*	CD	DESC		BRAC
		 		A	Add			A
				B	Original	N
				C	Change		G
				R	Replace		U
				X	Cancel		R*/
			if(bracCd.equals("B")){
				bracCd = "N";
			} else if(bracCd.equals("C")){
				bracCd = "G";
			} else if(bracCd.equals("R")){
				bracCd = "U";
			} else if(bracCd.equals("X")){
				bracCd = "R";
			} else {
				bracCd = "U";
			}
			autoManualFlg = "N";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();			

			if (bkgBlNoVO.length > 0) {
				for(int i=0;i<bkgBlNoVO.length;i++) {
					sendBkgTmlEdi(bkgBlNoVO[i], null, custTpIdVO[i].getRcvId(), bracCd, ediKind, autoManualFlg);
				}
			}

			commit();
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * ESM_BKG_0702 : edi transmit <br>
	 * creating Terminal information as Flat File and sending it with EDI<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgTmlEdiMultiBatchTest(Event e) throws EventException{
		log.debug("<<<<<<<<<< sendBkgTmlEdiMultiBatchTest Start >>>>>>>>>>>>>>>>");
		List<BkgYardCdVO> bkgYardCdVOs = null;
		BkgBlNoVO[] bkgBlNoVO = null;
		CustTpIdVO[] custTpIdVO = null;
		String bracCd = null;
		String ediKind = null;
		String autoManualFlg = null;
		EsmBkg0616Event event = (EsmBkg0616Event)e;
		custTpIdVO = event.getCustTpIdVOs();
		bkgBlNoVO = event.getBkgBlNoVOs();
		bracCd = event.getBracCd();
		bracCd = "U";
		ediKind = "BT";
		autoManualFlg = "N";
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();			
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			bkgYardCdVOs = command.searchBkgTmlEdiBatchYardCd();

			if (bkgBlNoVO.length > 0) {
				sendBkgTmlEdiBatch(bkgBlNoVO, null, custTpIdVO, bracCd, ediKind, autoManualFlg, bkgYardCdVOs.get(0));
			}
			log.debug("<<<<<<<<<< sendBkgTmlEdiMultiBatchTest End >>>>>>>>>>>>>>>>");

			commit();
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * ESM_BKG_0702 : edi transmit <br>
	 * creating Terminal information as Flat File and sending it with EDI<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgTmlEdiMultiBatch(Event e) throws EventException{
		log.debug("<<<<<<<<<< sendBkgTmlEdiMultiBatch Start >>>>>>>>>>>>>>>>");
		List<BkgYardCdVO> bkgYardCdVOs = null;
		BkgBlNoVO[] bkgBlNoVOs = null;
		String ediKind = null;
		String autoManualFlg = null;
		/*	CD	DESC		BRAC
 		A	Add			A
		B	Original	N
		C	Change		G
		R	Replace		U
		X	Cancel		R*/
		
//		bracCd = "U";
		ediKind = "BT";
		autoManualFlg = "N";
				
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			begin();
			
			bkgYardCdVOs = command.searchBkgTmlEdiBatchYardCd();
			
			for (int j=0; j < bkgYardCdVOs.size(); j++) {
				BkgYardCdVO bkgYardCdVO = bkgYardCdVOs.get(j);
				bkgYardCdVO.setEdiRefCd(bkgYardCdVO.getPort());
				
				String vvdList = command.searchBatchEdiVvdList(bkgYardCdVO.getPort());
				String[] vvds = null;
				if(vvdList.indexOf(",") > -1){
					vvds = vvdList.split(",");
				}else{
					vvds = new String[]{vvdList.trim()};
				}
				for (int i = 0; i < vvds.length; i++) {
					if(vvds[i].trim().equals("")) continue;
					bkgBlNoVOs = command.searchBkgTmlEdiBatch(bkgYardCdVO.getPort(), vvds[i].trim());
					log.debug(">>>>>>>>>>>>>>>> bkgBlNoVOs.length : " + bkgBlNoVOs.length);
					
					if (bkgBlNoVOs.length > 0) {
						CustTpIdVO[] custTpIdVOs = new CustTpIdVO[bkgBlNoVOs.length]; 
						for (int ii=0; ii < bkgBlNoVOs.length; ii++) {
							CustTpIdVO custTpIdVO = new CustTpIdVO();
							custTpIdVO.setIbflag("U");
							custTpIdVOs[ii] = custTpIdVO;
						}
						
						sendBkgTmlEdiBatch(bkgBlNoVOs, null, custTpIdVOs, null, ediKind, autoManualFlg, bkgYardCdVO);
					}	
				}
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
			log.debug("<<<<<<<<<< sendBkgTmlEdiMultiBatch End >>>>>>>>>>>>>>>>");
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
	 * sendBkgTmlEdiMulti() <br>
	 * creating Terminal information as Flat File and sending it with EDI<br>
	 * 
	 * @author	
	 * @param 	BkgBlNoVO[] bkgBlNoVOs
	 * @param   List<BkgVvdVO> oldVvdVOs
	 * @param   CustTpIdVO[] custTpIdVOs
	 * @param   String bracCd
	 * @param   String ediKind
	 * @param   String autoManualFlg
	 * @param   BkgYardCdVO bkgYardCdVO
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgTmlEdiBatch(BkgBlNoVO[] bkgBlNoVOs, List<BkgVvdVO> oldVvdVOs, CustTpIdVO[] custTpIdVOs, String bracCd, String ediKind, String autoManualFlg, BkgYardCdVO bkgYardCdVO) throws EventException{
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
//		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			if (bkgBlNoVOs.length > 0) {
				// Vender301ParamVO占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥筌뚭낑�쐻占쎈윪占쎌읆占쎈쐻占쎈윥筌앸뱶�쐻占쎈윥獒뺣�먯삕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�씤逾녑칰�럥�룯�뜝�럥爾쎾뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩堉싧뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻占쎈쐻占쎈윥占쏙옙占쎈쐻占쎈윪占쎈쨮占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굜占썲뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾占쎄턀占쎄턁占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇽옙�쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� EDI占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅅ猷뉛옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢�뇡遺억옙占쏙옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾占쎄턀占쎄퍓�맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈�λ돗�뜝�럩�뮛筌��맮�삕占쎌��윜諛잙쳛占쎄뎡�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮛�뇦猿볦삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윞占쎈쭢占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆轅⑦맪占쏙옙占쎌굲占쎌젂饔끸뫂留ゅ뜝�럡�떅�뜝�럩援꿨뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럩�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�떋�깷�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ렮苑믭옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐룟뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮛�뇦猿볦삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윞占쎈쭢占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�돍�삕�뇡�쑚�쐻占쎈윞占쎈쑆占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먥뵾占쎌뒧占쎈뮛�뜝�럡�떍占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎈윿占쎈쐻占쎈윥�젆�냵�삕占쎌럸�뜝�럥利띰옙�빝占쎌뜟ter�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔占쎈쇀占쎌돸占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럥�닍�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥��占쎈닱占쎈쐞占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮛�뇦猿볦삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윞占쎈쭢占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�씤逾녑칰�럥�룯�뜝�럥爾쎾뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩堉싧뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윞占쎈㎞占쎈쐻占쎈쑆獄��꺈�삕亦끸댙�삕�얘퉵�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄텫占쎈쐻占쎈윥�댆�뿥�쐻占쎈윪�뤃轅댁뜏�뜝�뜾�쇊占쎈역占쎄쉥占쎈쐻占쎈윪�뤃轅④텣�뜝�룞�삕占쎄콬�뜝�럩議먨뜝�럥夷⑨옙�꽞域뱄퐢�넇癲ル슢�뀖占쎈뮝�뜝�럡�렊占쎈쐻占쎈윥占쏙옙占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먥뵾占쎌뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럡�꺎占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈첋癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�썒占쏙옙寃�甕곌랬�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럥彛믭옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜏類ㅻ졁占쎄땐�뜝�럥�뿮占쎄괌占쎌뒏筌륅옙�뜝�럡�븫�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊�뜝�럥�늾占쎈쇊癰귨옙占쎄뎡占쎌녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�럸占쎈쐻占쎈짗占쎌굲�뜝�럥裕뀐옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVOs(bkgBlNoVOs);
				vender301ParamVO.setOldVvdVOs(oldVvdVOs);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg(autoManualFlg);
				vender301ParamVO.setRefCode(bkgYardCdVO.getEdiRefCd());
				vender301ParamVO.setRcvId(bkgYardCdVO.getEdiRcvId());
				vender301ParamVO.setCustTpIdVOs(custTpIdVOs);

				command.createTmlBkgReceiptEdiBatch(vender301ParamVO, account);
//				List<BkgNtcHisVO> bkgNtcHisVOs = command.createTmlBkgReceiptEdiBatch(vender301ParamVO, account);
//				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "");
			}
 
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		return eventResponse;
	}		
	
	/**
	 * sendBkgCustEdiMulti() <br>
	 * creating Customer information as Flat File and sending it with EDI<br>
	 * 
	 * @author	
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   CustTpIdVO custTpIdVO
	 * @param   String autoManualFlg
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	/**
	private EventResponse sendBkgCustEdi(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg) throws EventException{
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{

			if (bkgBlNoVO != null) {
				List<BkgNtcHisVO> bkgNtcHisVOs = command.createCustBkgReceiptEdi(bkgBlNoVO, custTpIdVO, autoManualFlg, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "");
			}

			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}		
	**/
	/**
	 * ESM_BKG_0702 : customer click <br>
	 * creating Customer information as Flat File and sending it with EDI<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgCustEdiMulti(Event e) throws EventException{
		EsmBkg0702Event event = (EsmBkg0702Event)e;
		GeneralEventResponse eventResponse = null;
		GeneralBookingReceiptBC command = null;
		BkgBlNoVO[] bkgBlNoVO = null;
		CustTpIdVO[] custTpIdVO = null;
		String typeGbn = null;
		String jobID = null;
		try{
			begin();
			eventResponse = new GeneralEventResponse();
			command = new GeneralBookingReceiptBCImpl();
			bkgBlNoVO = event.getBkgBlNoVOs();
			custTpIdVO = event.getCustTpIdVOs();
			typeGbn = event.getTypeGbn();
			jobID = command.sendBkgCustEdiMulti(bkgBlNoVO,custTpIdVO,typeGbn,account);
			eventResponse.setETCData("jobID", jobID);
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
	 * sending BackEndJob check with Customer EDI<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchSendBkgCustEdiMultiStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = null;
    	List<ComBakEndJbVO> dbRowSetlist = null;
    	DBRowSet rowSet = null;
    	ComBakEndJbVO jobVo = null;
		String key = null;
    	try {    		
    		eventResponse = new GeneralEventResponse();
    		key = JSPUtil.getNullNoTrim((String)e.getAttribute("key"));
	    	if (null != key && !"".equals(key)) {
    			// Backend job completion check
		    	backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(key);
		    	rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	if (0==dbRowSetlist.size()) { 
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
    	return eventResponse;
    }

	/**
	 * sending BackEndJob check swith Customer EDI<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchSendBkgCustEdiMulti(Event e) throws EventException{
		GeneralEventResponse eventResponse = null;
		GeneralBookingReceiptBC command = null;
		String result = null;
		try{
			eventResponse = new GeneralEventResponse();
			command = new GeneralBookingReceiptBCImpl();
			result = command.searchSendBkgCustEdiMulti(JSPUtil.getNullNoTrim((String)e.getAttribute("key")));
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
	 * ESM_BKG_9454 : open <br>
	 * Empty booking Transhipment Route retrieve <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBkgTsRoute(Event e) throws EventException{
		try{
			EsmBkg9454Event event = (EsmBkg9454Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			
			List<MtyBkgTsRouteVO> mtyBkgTsRoute = searchBC.searchEmptyBkgTsRoute(event.getBkgBlNoVO());
			
			List<MtyBkgTsRouteVO> preVvd = new ArrayList<MtyBkgTsRouteVO>();
			List<MtyBkgTsRouteVO> trunkVvd = new ArrayList<MtyBkgTsRouteVO>();
			List<MtyBkgTsRouteVO> postVvd = new ArrayList<MtyBkgTsRouteVO>();
			
			if(mtyBkgTsRoute != null){
				for(int i = 0 ; i < mtyBkgTsRoute.size() ; i++){
					if("S".equals(mtyBkgTsRoute.get(i).getVslPrePstCd())){
						preVvd.add(mtyBkgTsRoute.get(i));
					}else if("T".equals(mtyBkgTsRoute.get(i).getVslPrePstCd())){
						trunkVvd.add(mtyBkgTsRoute.get(i));
					}else{
						postVvd.add(mtyBkgTsRoute.get(i));
					}
				}
			}
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(preVvd);
			eventResponse.setRsVoList(trunkVvd);	
			eventResponse.setRsVoList(postVvd);	
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		
	

	/**
	 * ESM_BKG_9455 : open <br>
	 * Container List retrieve<br>
	 *
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrByYard(Event e) throws EventException{
		try{
			EsmBkg9455Event event = (EsmBkg9455Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();		

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchBC.searchCntrByYard(event.getVvd(), event.getYdCd(), event.getCntrTpsz()));

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		

	/**
	 * ESM_BKG_9425 : open <br>
	 * empty booking list retrieve<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBkgList(Event e) throws EventException{
		try{
			EsmBkg9425Event event = (EsmBkg9425Event)e;
			
			GeneralBookingListSearchBC listSearchBC = new GeneralBookingListSearchBCImpl();		
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			EmptyBkgListInqVO emptyBkgListInqVO = listSearchBC.searchEmptyBkgList(event.getEmptyBkgListInputVO());
			
			if(emptyBkgListInqVO.getEmptyBkgList() != null && emptyBkgListInqVO.getEmptyBkgList().size() > 0){
				eventResponse.setRsVoList(emptyBkgListInqVO.getEmptyBkgList());
				eventResponse.setETCData(emptyBkgListInqVO.getEmptyCntrSumVO().getColumnValues());			
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}			

	/**
	 * ESM_BKG_0616 : retrieve <br>
	 * for sending terminal edi to other country execept America, Booking list retrieve<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForGeneralTmlEdi(Event e) throws EventException{
		try{
			EsmBkg0616Event event = (EsmBkg0616Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			ArrayList<String> bkgNoTmp = new ArrayList<String>();
			ArrayList<String> bkgNoCnt = new ArrayList<String>();
	

			BkgListForTmlEdiInputVO bkgListForTmlEdiInputTmpVO = event.getBkgListForTmlEdiInputVO();
			BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO = new BkgListForTmlEdiInputVO();
			if ( !isNull(event.getBkgListForTmlEdiInputVO().getBkgNo()) ) {
				bkgListForTmlEdiInputVO.setBkgNo(bkgListForTmlEdiInputTmpVO.getBkgNo());
	        } else bkgListForTmlEdiInputVO = bkgListForTmlEdiInputTmpVO;
	
			List<BkgListForGeneralTmlEdiVO> list = command.searchBkgListForGeneralTmlEdi(bkgListForTmlEdiInputVO);
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	
			int crnTotal = 0;
			int ediSent = 0;
			int ediUnSent = 0;
			int ackRcv = 0;
			int tmlErr = 0;
			
			// data combination
			for (int i=0;i<list.size();i++) {
				BkgListForGeneralTmlEdiVO listVO = (BkgListForGeneralTmlEdiVO)list.get(i);
				bkgNoTmp.add(listVO.getBkgNo());
				if ( !isNull(listVO.getCrn()) ) crnTotal++;
				if ( !isNull(listVO.getSendDate()) ) ediSent++;
				if ( isNull(listVO.getSendDate()) ) ediUnSent++;
				if ( !isNull(listVO.getAck()) ) ackRcv++;
				if ( !isNull(listVO.getTmlErrMsg()) ) tmlErr++;
			}
	

			HashSet<String> hs = new HashSet<String>(bkgNoTmp);
			Iterator it = hs.iterator();
			while(it.hasNext()){
				bkgNoCnt.add(it.next().toString());
			}
	
			eventResponse.setETCData("bkgTotal",String.valueOf(bkgNoCnt.size()));
			eventResponse.setETCData("crnTotal",String.valueOf(crnTotal));
			eventResponse.setETCData("ediSent",String.valueOf(ediSent));
			eventResponse.setETCData("ediUnSent",String.valueOf(ediUnSent));
			eventResponse.setETCData("ackRcv",String.valueOf(ackRcv));
			eventResponse.setETCData("tmlErr",String.valueOf(tmlErr));

			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
	}		

	/**
	 * ESM_BKG_0616 : retrieve <br>
	 *  Sending and revieving record about terminal ediin Americaand Booking list retrieve<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgListForUsaTmlEdi(Event e) throws EventException{
		try{
			EsmBkg0616Event event = (EsmBkg0616Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			ArrayList<String> bkgNoTmp = new ArrayList();
			ArrayList<String> bkgNoCnt = new ArrayList();
	

			BkgListForTmlEdiInputVO bkgListForTmlEdiInputTmpVO = event.getBkgListForTmlEdiInputVO();
			BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO = new BkgListForTmlEdiInputVO();
			if ( !isNull(event.getBkgListForTmlEdiInputVO().getBkgNo()) ) {
				bkgListForTmlEdiInputVO.setBkgNo(bkgListForTmlEdiInputTmpVO.getBkgNo());
	        } else bkgListForTmlEdiInputVO = bkgListForTmlEdiInputTmpVO;
	
			List<BkgListForUsaTmlEdiVO> list = command.searchBkgListForUsaTmlEdi(bkgListForTmlEdiInputVO);
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	
			int ediSent = 0;
			int ediUnSent = 0;
			int ackRcv = 0;
			int tmlErr = 0;
	
			// data combination
			for (int i=0;i<list.size();i++) {
				BkgListForUsaTmlEdiVO listVO = (BkgListForUsaTmlEdiVO)list.get(i);
				bkgNoTmp.add(listVO.getBkgNo());
				if ( !isNull(listVO.getSendDate()) ) ediSent++;
				if ( isNull(listVO.getSendDate()) ) ediUnSent++;
				if ( !isNull(listVO.getAck()) ) ackRcv++;
				if ( !isNull(listVO.getTmlErrMsg()) ) tmlErr++;
			}
			log.debug("ackRcv:"+ackRcv);
	
			HashSet<String> hs = new HashSet<String>(bkgNoTmp);
			Iterator it = hs.iterator();
			while(it.hasNext()){
				bkgNoCnt.add(it.next().toString());
			}
	
			eventResponse.setETCData("bkgTotal",String.valueOf(bkgNoCnt.size()));
			eventResponse.setETCData("crnTotal","");
			eventResponse.setETCData("ediSent",String.valueOf(ediSent));
			eventResponse.setETCData("ediUnSent",String.valueOf(ediUnSent));
			eventResponse.setETCData("ackRcv",String.valueOf(ackRcv));
			eventResponse.setETCData("tmlErr",String.valueOf(tmlErr));

			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
	}

	/**
	 * ESM_BKG_0616 : save <br> 
	 *  Booking forwarder code and vsl reference information in Malaysia modifying<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMyFwrdRefVvd(Event e) throws EventException{
		EsmBkg0616Event event = (EsmBkg0616Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try{
			begin();			

			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			receiptBC.manageMyFwrdRefVvd(event.getFwrdRefVvdVOs(), account);

			commit();
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * ESM_BKG_0095 : Open <br>
	 * Fax/Email/EDI sending list retrieve<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgFaxEmailEdi(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		UserSetupMgtBC command2 = new UserSetupMgtBCImpl();
		EsmBkg0095Event event = (EsmBkg0095Event)e;

		try{
			event.getBkgBlNoVO().setPolCd(event.getPolCd());
			String arrNtcKndCd[] = event.getNtcKndCd();
			String arrFrtTerm[]  = event.getFrtTerm();
			
			
			List<SendBkgFaxEmailVO> list1 =  command.searchFaxEmailForNotice(event.getBkgBlNoVO(), account);
			List<SendBkgEdiVO> list2 =  command.searchEdiForNotice(event.getBkgBlNoVO());
			String receiptType = command.searchBkgReceiptType(account.getUsr_id());
			BkgUsrDfltSetVO usrDfltSetVO = command2.searchUserDefaultSetting(account.getUsr_id());
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				if(list1 != null && list1.size() > 0 ){
					for(int i=0; i<list1.size(); i++){
						SendBkgFaxEmailVO tempVO = (SendBkgFaxEmailVO)list1.get(i);
						
						String ntcKndCd = tempVO.getNtcKndCd();
						if("BL".equals(ntcKndCd) ||"NN".equals(ntcKndCd) ||"WB".equals(ntcKndCd)){
							for(int j=0; j < arrNtcKndCd.length; j++){
								if(ntcKndCd.equals(arrNtcKndCd[j])){
									tempVO.setFrtTerm(arrFrtTerm[j]);
									break;
								}
							}
						}
						list1.set(i, tempVO);
					}
				}
			}
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setCustomData("receipt_type", receiptType);
			String blPrnChgTpCd = "";
			if(usrDfltSetVO != null){
				blPrnChgTpCd = usrDfltSetVO.getBlPrnChgTpCd();
			}
			eventResponse.setCustomData("bl_prn_chg_tp_cd", blPrnChgTpCd);

			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
	}		

	/**
	 * ESM_BKG_0095 : FAX button click <br>
	 *   RD FAX sending from Booking<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgFaxNotice(Event e) throws EventException{
		EsmBkg0095Event event = (EsmBkg0095Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		EmptyReleaseOrderBC emptyRlsBC = new EmptyReleaseOrderBCImpl();
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		BkgBlNoVO bkgBlNoVO = null;
		BkgBlNoVO [] bkgBlNoVOs = null;
		String [] ntcKndCd = null;
		String [] faxNo = null;
		String [] rmk = null;
		String mrdNm = "";
		String param = "";
		String sType = "";
		String sLevel = "";
		String sMrd = "";
		String sSigned = "";
		String sSignedCopy = null;
		String bkSndFlg = null;
		BkgRouteVO bkgRouteVO = null;
		BookingUtil utilBC = null;
		
		try{
			begin();
			bkgBlNoVO = event.getBkgBlNoVO();
			bkgBlNoVOs = event.getBkgBlNoVOs();
			ntcKndCd = event.getNtcKndCd();
			faxNo = event.getFaxNo();
			rmk = event.getRemark();
			utilBC = new BookingUtil();
			bkSndFlg = "N";
			for(int i=0;i<bkgBlNoVOs.length;i++) {
				log.debug("Notice Kind : " + ntcKndCd[i]);
				bkgBlNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
				
				if ("BK".equals(ntcKndCd[i]) && bkSndFlg.equals("N")) {
					log.debug("receiveType:"+ event.getReceiveType());
					mrdNm = "Normal".equals(event.getReceiveType())?"ESM_BKG_5005G":"ESM_BKG_5005C";
					
					if(mrdNm.equals("ESM_BKG_5005G")){
						bkgRouteVO = utilBC.searchBkgRoute(bkgBlNoVO.getBkgNo());
						if (0 == bkgRouteVO.getPorCd().indexOf("US")) {
							mrdNm ="ESM_BKG_5005G_LETTER";
						}
					}
					
					String [] cct = new String[event.getFaxNo().length];
					String [] docCct = new String[event.getFaxNo().length];
					for(int j=0;j<cct.length;j++){
						cct[j]="";
						docCct[j]="";
					}
					
					for(int k=0;k<bkgBlNoVOs.length;k++) {
						log.debug("Notice Kind : " + ntcKndCd[k]);
						bkgBlNoVOs[k].setBkgNo(bkgBlNoVO.getBkgNo());
						log.debug("mrd:"+mrdNm+", fax:" + faxNo[k]);
					}
					
					BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
					bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
					bkgReceiptSendVO.setFaxNos(faxNo);
					bkgReceiptSendVO.setRemarks(rmk);
					bkgReceiptSendVO.setMrdNm(mrdNm);
					bkgReceiptSendVO.setCcts(cct);
					bkgReceiptSendVO.setDocCcts(docCct);
					bkgNtcHisVOs = command.sendBkgReceiptByFax(bkgReceiptSendVO, account);
					bkSndFlg = "Y";
				} else if ("CN".equals(ntcKndCd[i])) {
					param = "/rv bkg_no[('"+bkgBlNoVOs[i].getBkgNo()+"')] "
										+ " remark[" +rmk[i]+"@@ ] "
										+ " usr_id[" +account.getUsr_id()+"] "
										+ " type[detail] "
										+ " isEncode[Y] ";
					log.debug("param:"+param);
					SendMtyRlseOrdVO [] sendMtyRlseOrdVO = new SendMtyRlseOrdVO[1];
					sendMtyRlseOrdVO[0] = new SendMtyRlseOrdVO();
					sendMtyRlseOrdVO[0].setDiffRmk("");
					sendMtyRlseOrdVO[0].setBkgNo(bkgBlNoVOs[i].getBkgNo());
					sendMtyRlseOrdVO[0].setNtcFaxNo(faxNo[i]);					
					sendMtyRlseOrdVO[0].setTmplParam(param);
					
					bkgNtcHisVOs = emptyRlsBC.sendMtyRlseOrdByFax(sendMtyRlseOrdVO, account);
				
				} else if ("BL".equals(ntcKndCd[i]) || "WB".equals(ntcKndCd[i]) || "NN".equalsIgnoreCase(ntcKndCd[i])) {
					bkgRouteVO = utilBC.searchBkgRoute(bkgBlNoVOs[i].getBkgNo());
					if ("BL".equalsIgnoreCase(ntcKndCd[i])) {
						sType="7";
						sMrd="ESM_BKG_0109_OBL_A4.mrd";
						sSigned="";
						sSignedCopy="";
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
					} else if ("WB".equalsIgnoreCase(ntcKndCd[i])) {
						sType="5";
						sMrd="ESM_BKG_0109_OBL_A4.mrd";
//						sSigned=bkgBlNoVOs[i].getBlEsigFlg();
						if("".equals(sSigned)){
							sSigned = "N";
						}else if(sSigned.equals("1")){
							sSigned = "Y";
						}else if(sSigned.equals("0")){
							sSigned = "N";
						}else{
							sSigned = bkgBlNoVOs[i].getBlEsigFlg();
						}
						sSignedCopy="";
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
						
					} else if ("NN".equalsIgnoreCase(ntcKndCd[i])) {
						sType="2";
						sMrd="ESM_BKG_0109_OBL_A4.mrd";
						sSigned="";
						sSignedCopy=bkgBlNoVOs[i].getBlCpyEsigFlg();
						if("".equals(sSignedCopy)){
							sSignedCopy = "N";
						}else if(sSignedCopy.equals("1")){
							sSignedCopy = "Y";
						}else if(sSignedCopy.equals("0")){
							sSignedCopy = "N";
						}else{
							sSignedCopy=bkgBlNoVOs[i].getBlCpyEsigFlg();
						}
						
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
					}
					if ("ALL".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="1";
					} else if ("C".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="5";
					} else if ("P".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="4";
					} else if ("N".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="6";
					} else if ("A".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="3";
					} else {
						sLevel="1";
					}
					param="/rv form_bkgNo[( '" + bkgBlNoVOs[i].getBkgNo() + "') ]"
						  + "  form_type["+sType+"]"
					      + " form_dataOnly[N]"
					      + " form_manifest[N]"
					      + " form_usrId[" +account.getUsr_id()+"] "
					      + " form_hiddeData[N]"
					      + " form_level[("+sLevel+")]"
						  + " form_remark[" +rmk[i]+"]"
						  + " form_Cntr[1]"
						  + " form_mainOnly[N]"
						  + " form_CorrNo[]"
						  + " form_his_cntr[BKG_CONTAINER]"
						  + " form_his_bkg[BKG_BOOKING]"
						  + " form_his_mkd[BKG_BL_MK_DESC]"
						  + " form_his_xpt[BKG_XPT_IMP_LIC]"
						  + " form_his_bl[BKG_BL_DOC]"
						  + " form_rqst_via_cd[]"
						  + " form_his_bl_mkd[BKG_BL_ISS]"
						  + " form_path[" + event.getFileDownPath()+"]"
						  + " form_esig[" + sSigned +"]" 
						  + " form_cpy_esig[" + sSignedCopy +"]"
						  + " form_knt_flg[]"
						  + " form_count[]"
						  + " isEncode[Y]"
						  + " /rp []"
						  + " /riprnmargin";
					
					log.debug("FAX SEND PARAM==>"+param);
					log.debug("FAX SEND sMrd==>"+sMrd);
						  
					DblWblVO dblWblVO = new DblWblVO();
					DblWblVO[] dblWblVOs = new DblWblVO[1];
					dblWblVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					dblWblVO.setSyscd("BKG");
					dblWblVO.setTmplmrd(sMrd);
					dblWblVO.setBatchflg("N");
					dblWblVO.setTmplparam(param);
					dblWblVO.setRcvinfo(event.getFaxNo()[i]);
					dblWblVO.setTmplmrdpdf("Original.pdf");
					dblWblVO.setItr("|$$|");
					dblWblVO.setNtcKndCd(event.getNtcKndCd()[i]);
					
					if ("ALL".equalsIgnoreCase(event.getFrtTerm()[i])) {
						dblWblVO.setHiddOpt("N");
						dblWblVO.setFrtAllFlg("Y");
						dblWblVO.setFrtCltFlg("N");
						dblWblVO.setFrtPpdFlg("N");
						dblWblVO.setFrtChgFlg("N");
						dblWblVO.setFrtArrFlg("N");
					} else if ("C".equalsIgnoreCase(event.getFrtTerm()[i])) {
						dblWblVO.setHiddOpt("N");
						dblWblVO.setFrtAllFlg("N");
						dblWblVO.setFrtCltFlg("Y");
						dblWblVO.setFrtPpdFlg("N");
						dblWblVO.setFrtChgFlg("N");
						dblWblVO.setFrtArrFlg("N");
					} else if ("P".equalsIgnoreCase(event.getFrtTerm()[i])) {
						dblWblVO.setHiddOpt("N");
						dblWblVO.setFrtAllFlg("N");
						dblWblVO.setFrtCltFlg("N");
						dblWblVO.setFrtPpdFlg("Y");
						dblWblVO.setFrtChgFlg("N");
						dblWblVO.setFrtArrFlg("N");
					} else if ("N".equalsIgnoreCase(event.getFrtTerm()[i])) {
						dblWblVO.setHiddOpt("N");
						dblWblVO.setFrtAllFlg("N");
						dblWblVO.setFrtCltFlg("N");
						dblWblVO.setFrtPpdFlg("N");
						dblWblVO.setFrtChgFlg("Y");
						dblWblVO.setFrtArrFlg("N");
					} else if ("A".equalsIgnoreCase(event.getFrtTerm()[i])) {
						dblWblVO.setHiddOpt("N");
						dblWblVO.setFrtAllFlg("N");
						dblWblVO.setFrtCltFlg("N");
						dblWblVO.setFrtPpdFlg("N");
						dblWblVO.setFrtChgFlg("N");
						dblWblVO.setFrtArrFlg("Y");
					} else {
						dblWblVO.setHiddOpt("N");
						dblWblVO.setFrtAllFlg("Y");
						dblWblVO.setFrtCltFlg("N");
						dblWblVO.setFrtPpdFlg("N");
						dblWblVO.setFrtChgFlg("N");
						dblWblVO.setFrtArrFlg("N");
					}
					
					dblWblVOs[0]=dblWblVO;
					bkgNtcHisVOs = bLIssuanceBC.sendDblWblByFax(dblWblVOs, account);
				
				} else if ("SN".equals(ntcKndCd[i]) || "HI".equals(ntcKndCd[i]) || "HO".equals(ntcKndCd[i])) {
					if ( "SN".equals(ntcKndCd[i])) {
						mrdNm = "ESM_BKG_0866";
						param = "/rp ["+bkgBlNoVO.getBkgNo()+"] [Y]";						
					} else if ( "HI".equals(ntcKndCd[i]) ) {
						mrdNm = "ESM_BKG_5021";
						param = "/rp ['"+bkgBlNoVO.getBkgNo()+"'] ['I']";						
					} else if ( "HO".equals(ntcKndCd[i]) ) {
						mrdNm = "ESM_BKG_5021";		
						param = "/rp ['"+bkgBlNoVO.getBkgNo()+"'] ['O']";
					}
					bkgNtcHisVOs = command.sendBkgNoticeByFax(mrdNm, ntcKndCd[i], faxNo[i], param, bkgBlNoVOs[i], account);
				}
			}		
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * ESM_BKG_0095 : Email button click <br>
	 *  RD占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�룣MAIL sending from Booking list.<br>
	 * 
	 * @author	
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgEmailNotice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0095Event event = (EsmBkg0095Event)e;
		GeneralBookingSearchBC command  = new GeneralBookingSearchBCImpl();
		EmptyReleaseOrderBC emptyRlsBC = new EmptyReleaseOrderBCImpl();
		BLIssuanceBC bLIssuanceBC = null;
		BookingUtil utilBC = null;
		BookingHistoryMgtBC bkgHisCmd = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		List<DblWblVO> listDblWblVO = new ArrayList<DblWblVO>();
		StringBuilder sbParam = null;
		String mrdNm = "";
		String sType = null;
		String sLevel = null;
		String sMrd = null;
		String sSigned = "";
		String sSignedCopy = "";
		SendMtyRlseOrdVO[] sendMtyRlseOrdVOs = null;
		DblWblVO[] dblWblVOs = null;
		BkgBlNoVO bkgBlNoVO = null;
		BkgBlNoVO[] bkgBlNoVOs = null;
		String[] ntcKndCd = null;
		String[] eml= null;
		String[] rmk = null;
		BkgRouteVO bkgRouteVO = null;
		BkgEmlEdtVO bkgEmlEdtVO = null;
		String bkSndFlg = null;
		
		try {
			begin();
			command  = new GeneralBookingSearchBCImpl();
			emptyRlsBC = new EmptyReleaseOrderBCImpl();
			bLIssuanceBC = new BLIssuanceBCImpl();
			utilBC = new BookingUtil();
			bkgHisCmd = new BookingHistoryMgtBCImpl();
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilBC.searchBkgBlNoVO(event.getBkgBlNoVO());
			bkgBlNoVOs = event.getBkgBlNoVOs();
			ntcKndCd = event.getNtcKndCd();
			bkgEmlEdtVO = event.getBkgEmlEdtVO();
			eml= event.getEml();
			rmk = event.getRemark();
			sType = sLevel = sMrd = "";
			bkSndFlg = "N";
			for (int i=0; i<bkgBlNoVOs.length; i++) {
				bkgBlNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
				bkgBlNoVOs[i].setBlNo(bkgBlNoVO.getBlNo());
				sbParam = new StringBuilder();
				/*
				BK : Booking Receipt
				CN : Empty Release Order
				BL : Draft B/L
				WB : Waybill
				*/
				if ("BK".equalsIgnoreCase(ntcKndCd[i])&& bkSndFlg.equals("N")) {
					mrdNm = "Normal".equalsIgnoreCase(event.getReceiveType())?"ESM_BKG_5005G":"ESM_BKG_5005C";
					
					String [] cct = new String[event.getEml().length];
					String [] docCct = new String[event.getEml().length];
					for(int j=0;j<cct.length;j++){
						cct[j]="";
						docCct[j]="";
					}
					for (int k=0; k<bkgBlNoVOs.length; k++) {
						bkgBlNoVOs[k].setBkgNo(bkgBlNoVO.getBkgNo());
						bkgBlNoVOs[k].setBlNo(bkgBlNoVO.getBlNo());
					}
					
					BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
					bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
					bkgReceiptSendVO.setEmlAddrs(eml);
					bkgReceiptSendVO.setRemarks(rmk);
					bkgReceiptSendVO.setMrdNm(mrdNm);
					bkgReceiptSendVO.setCcts(cct);
					bkgReceiptSendVO.setDocCcts(docCct);
					if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
						bkgReceiptSendVO.setBkgEmlEdtVo(bkgEmlEdtVO);
						bkgNtcHisVOs = command.sendBkgReceiptByGroupEmail(bkgReceiptSendVO, account);
					} else {
						bkgNtcHisVOs = command.sendBkgReceiptByEmail(bkgReceiptSendVO, account, "0095");
					}
					bkSndFlg = "Y";
				} else if ("CN".equalsIgnoreCase(ntcKndCd[i])) {
					sbParam.append("/rv");
					sbParam.append(" bkg_no[('").append(bkgBlNoVOs[i].getBkgNo()).append("')]");
					sbParam.append(" remark[").append(rmk[i]).append("@@ ]");
					sbParam.append(" usr_id[").append(account.getUsr_id()).append("]");
					sbParam.append(" type[detail]");
					sbParam.append(" isEncode[Y]");
					sendMtyRlseOrdVOs = new SendMtyRlseOrdVO[1];
					sendMtyRlseOrdVOs[0] = new SendMtyRlseOrdVO();
					sendMtyRlseOrdVOs[0].setDiffRmk("");
					sendMtyRlseOrdVOs[0].setBkgNo(bkgBlNoVOs[i].getBkgNo());
					sendMtyRlseOrdVOs[0].setNtcEml(eml[i]);
					sendMtyRlseOrdVOs[0].setTmplParam(sbParam.toString());
					bkgNtcHisVOs = emptyRlsBC.sendMtyRlseOrdByEmail(sendMtyRlseOrdVOs, bkgEmlEdtVO, account);
				} else if ("BL".equalsIgnoreCase(ntcKndCd[i]) || "WB".equalsIgnoreCase(ntcKndCd[i]) || "NN".equalsIgnoreCase(ntcKndCd[i])) {
					bkgRouteVO = utilBC.searchBkgRoute(bkgBlNoVOs[i].getBkgNo());
					if ("BL".equalsIgnoreCase(ntcKndCd[i])) {
						sType="7";
						sSigned="";
						sSignedCopy="";
						sMrd="ESM_BKG_0109_OBL_A4.mrd";
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
					} else if ("WB".equalsIgnoreCase(ntcKndCd[i])) {
						sType="5";
						sSigned=bkgBlNoVOs[i].getBlEsigFlg();
						
						if("".equals(sSigned)){
							sSigned = "N";
						}else if(sSigned.equals("1")){
							sSigned = "Y";
						}else if(sSigned.equals("0")){
							sSigned = "N";
						}else{
							sSigned = bkgBlNoVOs[i].getBlEsigFlg();
						}
						
						sSignedCopy="";
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
					} else if ("NN".equalsIgnoreCase(ntcKndCd[i])) {
						sType="2";
						sSigned="";
						sSignedCopy=bkgBlNoVOs[i].getBlCpyEsigFlg();

						if("".equals(sSignedCopy)){
							sSignedCopy = "N";
							log.debug("EMAIL SEND signedCopy null ################");
						}else if(sSignedCopy.equals("1")){
							sSignedCopy = "Y";
							log.debug("EMAIL SEND signedCopy 1 ################");
						}else if(sSignedCopy.equals("0")){
							sSignedCopy = "N";
							log.debug("EMAIL SEND signedCopy 0 ################");
						}else{
							sSignedCopy=bkgBlNoVOs[i].getBlCpyEsigFlg();
							log.debug("EMAIL SEND signedCopy else ################");
						}
						
//						sSignedCopy=bkgBlNoVOs[i].getBlCpyEsigFlg();
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
					}
					if ("ALL".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="1";
					} else if ("C".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="5";
					} else if ("P".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="4";
					} else if ("N".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="6";
					} else if ("A".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="3";
					} else {
						sLevel="1";
					}
					sbParam.append("/rv");
					sbParam.append(" form_bkgNo[('").append(bkgBlNoVOs[i].getBkgNo()).append("')]");
					sbParam.append(" form_type[").append(sType).append("]");
					sbParam.append(" form_dataOnly[N]");
					sbParam.append(" form_manifest[N]");
					sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
					sbParam.append(" form_hiddeData[N]");
					sbParam.append(" form_level[(").append(sLevel).append(")]");
					sbParam.append(" form_remark[").append(rmk[i]).append("]");
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
					sbParam.append(" form_path[" + event.getFileDownPath()+"]");
					sbParam.append(" form_esig[").append(sSigned).append("]");
					sbParam.append(" form_cpy_esig[").append(sSignedCopy).append("]");
					sbParam.append(" form_knt_flg[]");
					sbParam.append(" form_count[]");
					sbParam.append(" isEncode[Y]");
					sbParam.append(" /rp []");
					sbParam.append(" /riprnmargin");
					sbParam.append(" /rexceptiserr [1]");			//2015.07.21. RD loadImage �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ룊�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐몾履쏉옙寃�泳�占썲뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈뼓占쎈꽠�⑥궡�굲占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�뜝�떥�궠猷쎾뜝�럥�맶�뜝�럥�쑋�뜝�럥痢ο┼�슪�삕�뜝�럥�렂�뜝�럩援뀐옙�쐻占쎈윪�뜝�룞�삕占쎌맳�뛾�룇�삌�댚�렱�쐻占쎈윞占쎈젇�뜝�럥�맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞筌앸ŀ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅占쎈쇀占쎈쐣占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤂�뜝�럥踰⑨옙�굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�꽴�뫜�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� excepiton �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎄콪占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쐾�뜝�럥堉껃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占썬룂�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜏類ｌ뿪占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲�젆�룇�뒻占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅鶯ㅼ룇�돸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗傭��끉猷놅옙�꺈�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮씮�쑕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럩�벀�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥堉볟뜝�럥苑좑옙�뫁沅∽옙援꿨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡愿⑼옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥彛ⓨ뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔占쎈쇀占쎌돸占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈콦�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� by �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲�젆�룇�뒻占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎌뱿�뜝�럥�맶�뜝�럥�쐾占쎈쇊�뜝�룞�삕占쎌럸�뜝�럥利당춯占썹뙴諭�占쎌눦�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩�뜮戮녹삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲�젆�룇�뒻占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊�뜝�럥�늾占쎈쇊癰귨옙占쎄뎡占쎌녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻占쎈쐻占쎈윥占쏙옙占쎈쐻占쎈윪占쎈쨮占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럩�뀇�윜誘쇱눘援�占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅占쎈쐻占쎈윥占쎈뼣占쎈퉲�뜝�뜴�쐻占쎈윪�억옙癲ル슢�뿪占쎌굲�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥筌묒뼲�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뤃寃쇰쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥夷③뇦猿뗫윥�뜝�럩�눛占쎈뼆�뜝�럡�꼤�뜝�럥�젋占쎈쐻占쎈윞�꽴�슗�쐻占쎈윥占쎄퐫占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅鶯ㅼ룆�ワ옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�뀵�뜝�럥�맶�뜝�럥�쑅占쎈뙀占쎈엠占쎌맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔낃퀣�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥獒뺤떣�삕占쎌맶�뜝�럥�쑅�뜝�럥彛볩옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�
					
					log.debug("EMAIL SEND PARAM==>"+sbParam.toString());
					log.debug("EMAIL SEND sMrd==>"+sMrd);
					
					dblWblVOs = new DblWblVO[1];
					dblWblVOs[0] = new DblWblVO();
					dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
					dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
					dblWblVOs[0].setSyscd("BKG");
					dblWblVOs[0].setTmplmrd(sMrd);
					dblWblVOs[0].setBatchflg("N");
					dblWblVOs[0].setTmplparam(sbParam.toString());
					dblWblVOs[0].setRcveml(event.getEml()[i]);
					dblWblVOs[0].setTmplmrdpdf("Original.pdf");
					dblWblVOs[0].setItr("|$$|");
					dblWblVOs[0].setNtcKndCd(event.getNtcKndCd()[i]);
					dblWblVOs[0].setHiddOpt("1".equalsIgnoreCase(event.getFrtCltFlg()[i])?"Y":"N");
					dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
					
					//REMARK, DIFF_REMARK �뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒩占쎈뤅占쎈쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슣�돵�뜝�떥�궡留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윥占쎈눁�뜝�럥�맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩�꽣�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쐾�뜝�럥堉귛뜝�럥�맶�뜝�럥�쑋�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類㏃삕占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷③쪛�굛�ｏ옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒱占쎈쭒占쎄덩�걹占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎄광占쎈쐻占쎈윥�댚�엺�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윥占쎈짎�뜝�럥�맶�뜝�럥�쑅�뜝�럥吏륅옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥筌Ξ욋뵾占쎌뒱占쎌굲占쎈쐻占쎈윥壤쏆±�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留쏙옙�쐻占쎈윞占쏙옙占쎈쐻占쎈윥占쎈뎔�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슣鍮뽳쭪�꼻�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼲彛쀯옙堉꿨퐲�꺈�삕�뙴�뵃�삕占쎄뎡占쎈눇�뙼蹂��굲�솾�봾�꺋占쎌굲�뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽�뜝�럡���뜝�럩�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉┼�슢�뵯甕겸뫅�삕占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�꽴�꼻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�뱜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈첋癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋濚밸Ŋ�땬占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢理먧펺�뮋�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利억쭗�뼲彛ワ옙猷딉옙�굲�뇦猿볦삕癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔鸚룔굩�삕占쎄뎡�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮�占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�땱�떜利얕린洹⑥삕占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩逾쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈� 2015.08.20
					listDblWblVO = bLIssuanceBC.searchDblRemarkByBkgNo(bkgBlNoVO.getBkgNo());
					if(null!=listDblWblVO && listDblWblVO.size()>0){
						dblWblVOs[0].setRemark(listDblWblVO.get(0).getRemark());
						dblWblVOs[0].setDiffRmk(listDblWblVO.get(0).getDiffRmk());
					}else{
						dblWblVOs[0].setRemark("");
						dblWblVOs[0].setDiffRmk("");
					}
					
					bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, bkgEmlEdtVO, account);
				} else if ("SN".equalsIgnoreCase(ntcKndCd[i]) || "HI".equalsIgnoreCase(ntcKndCd[i]) || "HO".equalsIgnoreCase(ntcKndCd[i])) {
					if ("SN".equalsIgnoreCase(ntcKndCd[i])) {
						mrdNm = "ESM_BKG_0866";		
						sbParam.append("/rp [").append(bkgBlNoVO.getBkgNo()).append("] [Y]");
					} else if ("HI".equalsIgnoreCase(ntcKndCd[i])) {
						mrdNm = "ESM_BKG_5021";		
						sbParam.append("/rp ['").append(bkgBlNoVO.getBkgNo()).append("'] ['I']");
					} else if ("HO".equalsIgnoreCase(ntcKndCd[i])) {
						mrdNm = "ESM_BKG_5021";		
						sbParam.append("/rp ['").append(bkgBlNoVO.getBkgNo()).append("'] ['O']");
					}
					bkgNtcHisVOs = command.sendBkgNoticeByEmail(mrdNm, ntcKndCd[i], eml[i], sbParam.toString(), bkgBlNoVOs[i], bkgEmlEdtVO, account);
				}
			}
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
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
	
 	/**
 	 * ESM_BKG_0079_02 : notice <br>
	 * Tro RD Fax sending and EMAIL sending<br>
	 *
	 * @author  
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception EventException
	 */
	private EventResponse sendTroNotice(Event e) throws EventException {
		try {
			begin();
			
			EsmBkg007902cEvent event = (EsmBkg007902cEvent)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingSearchBC command   = new GeneralBookingSearchBCImpl();
			BookingHistoryMgtBC    bkgHisCmd = new BookingHistoryMgtBCImpl();
			
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			String    boundCd   = JSPUtil.getNullNoTrim(event.getBoundCd());
			String    faxNo     = JSPUtil.getNullNoTrim(event.getFaxNo());
			String    eml       = JSPUtil.getNullNoTrim(event.getEml());
			
			String strEml   = "N";
			String strFax   = "N";
			String param    = "/rp ['"+bkgBlNoVO.getBkgNo()+"'] ['"+boundCd+"']"; 
			String mrdNm    = "ESM_BKG_5021";
			String ntcKndCd = "H"+boundCd;

			if (!"".equals(eml)) {
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgNoticeByEmail(mrdNm, ntcKndCd, eml, param, bkgBlNoVO, null, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_02C");
				eventResponse.setETCData("SuccessYn", "YM");
				strEml = "Y";
			}
			if (!"".equals(faxNo)) {
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgNoticeByFax(mrdNm, ntcKndCd, faxNo, param, bkgBlNoVO, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_02C");
				eventResponse.setETCData("SuccessYn", "YF");
				strFax = "Y";
			}
			
			commit();			
			if ("Y".equals(strEml) && "Y".equals(strFax)) {
				eventResponse.setETCData("SuccessYn", "Y");
			}
			
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
 	/**
	 * MQ connection process<br>
	 * UBIZCOM_OPUSBKG_USTMNL_ACK IBM MQ input process<br>
	 *
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptUsaTmlEdiAck(Event e) throws EventException {
		try {
			begin();
			EsmBkgUsaTmlEdiAckEvent event = (EsmBkgUsaTmlEdiAckEvent)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingHistoryMgtBC command = new BookingHistoryMgtBCImpl();

			command.receiptUsaTmlEdiAck(event.getRcvMsg());
			commit();
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * booking creation, booking update, split, combine, customer update<br>
	 * to be recalculation is updated in COA<br>
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
    * booking creation, booking update, split, combine, customer update<br>
	*  booking data interface in INV<br>
	*
	* @param 		BkgBlNoVO bkgBlNoVO, SignOnUserAccount account
	* @return 		void
	* @exception 	EventException
	*/
	private void interfaceToInv(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws EventException{
		BookingARCreationBC invBc = new BookingARCreationBCImpl();		
		try{
			ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
			bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgIfVo.setBkgCorrNo(bkgBlNoVO.getCaNo());
			bkgIfVo.setUserId(account.getUsr_id());
			bkgIfVo.setManDivInd("B");
				
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
	 * ESM_BKG_0096 : Open <br>
	 * As edi sending , information占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥吏쀥뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋占쎌뼚占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럵占쎈쐻占쎈윪筌뤵룇�삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�릮etrieve for yard assortment<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardAssign(Event e) throws EventException{
		try{
			EsmBkg0096Event event = (EsmBkg0096Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			PSAManifestBC psaBC = new PSAManifestBCImpl();
						
			PsaBkgIfVO psaBkgIfVO = new PsaBkgIfVO();
			psaBkgIfVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			psaBkgIfVO.setUsrId(account.getUsr_id());
			PsaBkgIfVO[] rtnPsaBkgIfVOs = psaBC.searchPSAIFInfo(psaBkgIfVO);
			
			if (rtnPsaBkgIfVOs!=null && rtnPsaBkgIfVOs.length > 0) {
				eventResponse.setETCData("bkg_no",	JSPUtil.getNull(rtnPsaBkgIfVOs[0].getBkgNo())	  );
				eventResponse.setETCData("bkg_qty",	JSPUtil.getNull(rtnPsaBkgIfVOs[0].getMainBkgQty()));
				eventResponse.setETCData("yd_cd",	JSPUtil.getNull(rtnPsaBkgIfVOs[0].getYdCd())	  );
				if (rtnPsaBkgIfVOs[0].getBkgSeq()!=null && rtnPsaBkgIfVOs[0].getBkgSeq().length() > 0) 
					eventResponse.setRsVoList(Arrays.asList(rtnPsaBkgIfVOs));
			}else {
				throw new EventException(new ErrorHandler("BKG00095").getMessage());
			}
			
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
	* ESM_BKG_0096 : SAVE button click<br>
    * If inputted yard is in mdm_yard, check.<br>
    * 
    * @param Event e
	* @return EventResponse
    * @exception EventException
    */
   private EventResponse validateYardAssign(Event e) throws EventException{
	   try{
		   EsmBkg0096Event event = (EsmBkg0096Event)e;
		   GeneralEventResponse eventResponse = new GeneralEventResponse();
		   
		   GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		   
		   command.validateYardAssign(event.getYardAssignVO().getQtyInfoVOs());
		   
		   // changing data process
		   if (event.getYardAssignVO().getQtyInfoVOs()!=null) {
			   
			   begin();
			   // PSA BC declaration
			   PSAManifestBC command2 = new PSAManifestBCImpl();
			   
			   //  data from screen
			   QtyInfoVO[] qtyInfoVOs = event.getYardAssignVO().getQtyInfoVOs();
			   
			   PsaYardCdVO[] psaYardCdVOs = new PsaYardCdVO[qtyInfoVOs.length];
		
			   for(int i=0; i < psaYardCdVOs.length; i++) {
				   psaYardCdVOs[i] = new PsaYardCdVO();				   
				   ObjectCloner.build(qtyInfoVOs[i], psaYardCdVOs[i]);
				   psaYardCdVOs[i].setUsrId(account.getUsr_id());
			   }
			   
			   // task request to BC 
			   command2.managePsaYardCode(psaYardCdVOs);
			   

				BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
				List<BkgNtcHisVO> bkgNtcHisVOs = null;
				
				PSAManifestBC psaBC = new PSAManifestBCImpl();
				PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
				psaBkgVOs[0] = new PsaBkgVO();
				psaBkgVOs[0].setBkgNo(psaYardCdVOs[0].getBkgNo());
				psaBkgVOs[0].setSndUsrId(account.getUsr_id());
				psaBkgVOs[0].setQtyModifyFlag("N");
				psaBC.managePSABKG(psaBkgVOs);

				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(psaYardCdVOs[0].getBkgNo());
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
			   
//			   this.managePSABKGAuto(psaYardCdVOs[0].getBkgNo(), "N");
		   }
		   
		   //  success messege setting
		   eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		   
		   return eventResponse;
	   } catch(EventException se) {
		    rollback();
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	   
   }
   
   /**
	 * ESM_BKG_1069 : open <br>
	 * Route Detail information retrieve <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRouteDetail(Event e) throws EventException {
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       EsmBkg1069Event event = (EsmBkg1069Event) e;   
       
       GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
              
       try{      	       	
    	   RouteDtlVO routeDtlVo = command.searchRouteDetail(event.getBkgNo());

	   	   RouteDtlInfoVO routeDtlInfo = routeDtlVo.getRouteDtlInfo();       	
	       List<RouteDtlVvdVO> routeDtlVvd = routeDtlVo.getRouteDtlVvd();                           
	      
	       eventResponse.setETCData(routeDtlInfo.getColumnValues());   
	       eventResponse.setRsVoList(routeDtlVvd);                
          
       }catch(EventException ex){
           throw ex;
       }catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
       }
       return eventResponse;
    }

	/**
	 * ESM_BKG_0079 : open <br>
	 * wich tab should be showing in Booking Creation tab retrieve<br>
	 * 
	 * @author    
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCreTabByUser(Event e) throws EventException {
		//EsmBkg0079Event event = (EsmBkg0079Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String strTroTab = command.searchBkgCreTabByUser(account); 
			eventResponse.setETCData("tro_tab", JSPUtil.getNullNoTrim(strTroTab));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}			

		return eventResponse;
	}

	/**
	 * ESM_BKG_00985 : EDI Transmit button click<br>
	 * sending edi in bkg<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendBkgEdi(Event e) throws EventException{
		try{
			EsmBkg0095Event event = (EsmBkg0095Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
//			CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
			BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
			CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			GeneralBookingReceiptBC rcpCmd = new GeneralBookingReceiptBCImpl();
			BookingUtil utilBC = new BookingUtil();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			boolean isSend = false;
			for(int i=0;i<event.getCustTpIdVOs().length;i++){
				log.debug("ntc knd cd:[" + event.getNtcKndCd()[i] + "], rcv_id :["+event.getCustTpIdVOs()[i].getRcvId()+"]");
				List<BkgNtcHisVO> bkgNtcHisVOs = null;
				if (event.getNtcKndCd()[i].equals("BK")){
					bkgNtcHisVOs=command.createCustBkgReceiptEdi(event.getBkgBlNoVO(), event.getCustTpIdVOs()[i], "N", account);
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}
				}
				
				if(event.getNtcKndCd()[i].equals("PS")){ 
					PSAManifestBC psaBC = new PSAManifestBCImpl();
					PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
					psaBkgVOs[0] = new PsaBkgVO();
					psaBkgVOs[0].setBkgNo(event.getBkgBlNoVO().getBkgNo());
					psaBkgVOs[0].setSndUsrId(account.getUsr_id());
					psaBC.managePSABKG(psaBkgVOs);

					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					bkgNtcHisVO.setNtcViaCd("E");
					bkgNtcHisVO.setNtcKndCd("PS");
					bkgNtcHisVO.setEdiId(event.getCustTpIdVOs()[i].getRcvId());
					bkgNtcHisVO.setEsvcGrpCd(event.getCustTpIdVOs()[i].getGroupId());
					bkgNtcHisVO.setBkgNtcSndRsltCd("A");
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
					bkgNtcHisVOs.add(bkgNtcHisVO);
					
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}
				}				
				if (event.getNtcKndCd()[i].equals("BT")||event.getNtcKndCd()[i].equals("CN")
					||event.getNtcKndCd()[i].equals("FC")){
					if(event.getCustTpIdVOs()[i].getRcvId()!=null&&event.getCustTpIdVOs()[i].getRcvId().length()>0){
						// Vender301ParamVO占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�뜫猷귨옙�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥筌뚭낑�쐻占쎈윪占쎌읆占쎈쐻占쎈윥筌앸뱶�쐻占쎈윥獒뺣�먯삕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�씤逾녑칰�럥�룯�뜝�럥爾쎾뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩堉싧뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻占쎈쐻占쎈윥占쏙옙占쎈쐻占쎈윪占쎈쨮占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥�굜占썲뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾占쎄턀占쎄턁占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�냵�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿룞�삕占쎌맶�뜝�럥�쐾�뜝�럥萸쇽옙�쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� EDI占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅅ猷뉛옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢�뇡遺억옙占쏙옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾占쎄턀占쎄퍓�맶�뜝�럥�쑅�뜝�룞�삕�뜝�럥�맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈�λ돗�뜝�럩�뮛筌��맮�삕占쎌��윜諛잙쳛占쎄뎡�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮛�뇦猿볦삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윞占쎈쭢占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆轅⑦맪占쏙옙占쎌굲占쎌젂饔끸뫂留ゅ뜝�럡�떅�뜝�럩援꿨뜝�럥���뜝�럥�깱�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈듋�뜝�럥�뇢�솻洹⑥삕�뜝�럡�렊�뜝�럩�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럥�걞�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑜占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뀉�뙴�돍�삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쐾�뜝�럡�꼸占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞�굜�굝�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�떋�깷�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅鶯ㅼ렮苑믭옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐룟뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮛�뇦猿볦삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윞占쎈쭢占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�돍�삕�뇡�쑚�쐻占쎈윞占쎈쑆占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먥뵾占쎌뒧占쎈뮛�뜝�럡�떍占쎈쐻占쎈윪�뤃轅⑤쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎈윿占쎈쐻占쎈윥�젆�냵�삕占쎌럸�뜝�럥利띰옙�빝占쎌뜟ter�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔占쎈쇀占쎌돸占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럥�닍�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥��占쎈닱占쎈쐞占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮛�뇦猿볦삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윞占쎈쭢占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�씤逾녑칰�럥�룯�뜝�럥爾쎾뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럩堉싧뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪占쎌쓦占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윞占쎈㎞占쎈쐻占쎈쑆獄��꺈�삕亦끸댙�삕�얘퉵�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄텫占쎈쐻占쎈윥�댆�뿥�쐻占쎈윪�뤃轅댁뜏�뜝�뜾�쇊占쎈역占쎄쉥占쎈쐻占쎈윪�뤃轅④텣�뜝�룞�삕占쎄콬�뜝�럩議먨뜝�럥夷⑨옙�꽞域뱄퐢�넇癲ル슢�뀖占쎈뮝�뜝�럡�렊占쎈쐻占쎈윥占쏙옙占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈윪�뤃�먥뵾占쎌뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐∽옙�쐻占쎈윥�댆琉룸쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋�뜝�럡�꺎占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈첋癲딅냲�삕占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�썒占쏙옙寃�甕곌랬�삕占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럥彛믭옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜏類ㅻ졁占쎄땐�뜝�럥�뿮占쎄괌占쎌뒏筌륅옙�뜝�럡�븫�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊�뜝�럥�늾占쎈쇊癰귨옙占쎄뎡占쎌녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�럸占쎈쐻占쎈짗占쎌굲�뜝�럥裕뀐옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.
						Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
						vender301ParamVO.setBkgBlNoVO(event.getBkgBlNoVO());
						vender301ParamVO.setOldVvdVOs(null);
						vender301ParamVO.setOldQtyVOs(null);
						vender301ParamVO.setOldMtyPkupYdCd(null);
						vender301ParamVO.setBracCd("U");
						vender301ParamVO.setEdiKind(event.getNtcKndCd()[i]);
						vender301ParamVO.setAutoManualFlg("N");
						vender301ParamVO.setRcvId(event.getCustTpIdVOs()[i].getRcvId());
						vender301ParamVO.setRefCode(event.getCustTpIdVOs()[i].getRefCode());

						bkgNtcHisVOs=command.createTmlBkgReceiptEdi(vender301ParamVO, account);
						if(bkgNtcHisVOs!=null){
							if(bkgNtcHisVOs.size()>0){
								bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
								isSend = true;
							}
						}
					}
				}
				if (event.getNtcKndCd()[i].equals("IM")){
					BkgBlNoVO vo = new BkgBlNoVO();
					vo.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					String[] cntrArr = utilBC.searchCntrListByBkg(vo);
					
					if(cntrArr.length == 0){
						throw new EventException(new ErrorHandler("BKG01028",new String[]{}).getMessage());
					}

					List<CntrListForImportDetailVO> cntrListForImportDetailVOs = cLLCDLManifestBC.searchCntrListForImport(event.getBkgBlNoVO().getBkgNo());
				
					CllCdlTransmitVO[] cllCdlTransmitVOs = new CllCdlTransmitVO[cntrListForImportDetailVOs.size()];
						
					for ( int j=0 ; j<cntrListForImportDetailVOs.size() ; j++ )
					{
						CntrListForImportDetailVO cntrListForImportDetailVO = cntrListForImportDetailVOs.get(j);
						CllCdlTransmitVO cllCdlTransmitVO = new CllCdlTransmitVO();
						cllCdlTransmitVO.setInListType("D");
						cllCdlTransmitVO.setInListType("D");
						cllCdlTransmitVO.setBkgNo(cntrListForImportDetailVO.getBkgNo());
						cllCdlTransmitVO.setCntrNo(cntrListForImportDetailVO.getCntrNo());
						cllCdlTransmitVO.setInEdiMsgFunc("ORIGINAL");
						cllCdlTransmitVO.setInPodCd(cntrListForImportDetailVO.getPodCd());
						cllCdlTransmitVO.setInVvdCd(cntrListForImportDetailVO.getVvdCd());
						cllCdlTransmitVO.setInRcvId(event.getCustTpIdVOs()[i].getRcvId());
						cllCdlTransmitVO.setInAreaId(cntrListForImportDetailVO.getAreaId());
						cllCdlTransmitVO.setInYdCd(event.getCustTpIdVOs()[i].getRefCode());
						cllCdlTransmitVO.setInSndId("");
						cllCdlTransmitVO.setInWhereGubun("BKG");
						
						cllCdlTransmitVOs[j] = cllCdlTransmitVO;
					}
					if ( cllCdlTransmitVOs.length > 0 )
					{
						cLLCDLManifestBC.transmitCllCdl(cllCdlTransmitVOs, account);
						isSend = true;
					}
				}
				if (event.getNtcKndCd()[i].equals("BL")){
					CustTpIdVO custTpVO2 = event.getCustTpIdVOs()[i];
					
					DblEdiInVO dblEdiInVO = new DblEdiInVO();
					dblEdiInVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					dblEdiInVO.setEdiReceiveId(custTpVO2.getRcvId());
					dblEdiInVO.setGroupEdiId(custTpVO2.getGroupId());
					dblEdiInVO.setFuncCode(custTpVO2.getFuncCode());
					DblEdiVO dblEdiVo=bLIssuanceBC.createDraftBlEdi(dblEdiInVO, account);
					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();						
					
					// History
					for(int j=0;j<dblEdiVo.getFlatFileAckVOs().size();j++){
						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
						bkgNtcHisVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgNtcHisVO.setNtcViaCd("E");
						bkgNtcHisVO.setNtcKndCd("BL");
						bkgNtcHisVO.setEdiId(custTpVO2.getRcvId());
						bkgNtcHisVO.setEsvcGrpCd(custTpVO2.getGroupId());
						bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVo.getFlatFileAckVOs().get(j).getAckStsCd());
						bkgNtcHisVO.setSndUsrId(account.getUsr_id());
						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
						bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());	
						bkgNtcHisVO.setDiffRmk(dblEdiVo.getDblEdiRefNo());
						bkgNtcHisVOs.add(bkgNtcHisVO);						
					}
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}
	    			if (Constants.SAMF_LIST.contains(custTpVO2.getRcvId())) {
						BkgReferenceVO[] bkgReferenceVOs = new BkgReferenceVO[1];
						BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
						bkgReferenceVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgReferenceVO.setBkgRefTpCd("SAMF");						
						bkgReferenceVO.setCustRefNoCtnt(dblEdiVo.getDblEdiSamf());
						bkgReferenceVOs[0] = bkgReferenceVO;

						rcpCmd.manageRefNo(bkgReferenceVOs, account, event.getBkgBlNoVO());
					}
	    			
	    			//Auto Email Send
	    			BkgBlNoVO bkgBlNoVO = utilBC.searchBkgBlNoVO(event.getBkgBlNoVO());
	    			
	    			DblWblVO dblWblVO = new DblWblVO();
	    			dblWblVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
	    			dblWblVO.setTitle("BLUPLOAD:COMPANYSHIP");
	    			dblWblVO.setContents(" ");
	    			dblWblVO.setBlNo(bkgBlNoVO.getBlNo());
//	    			dblWblVO.setNtcKndCd("BL");
	                dblWblVO.setHiddOpt("N");
	                dblWblVO.setFrtAllFlg("N");
	                dblWblVO.setFrtCltFlg("N");
	                dblWblVO.setFrtPpdFlg("N");
	                dblWblVO.setFrtChgFlg("Y");
	                dblWblVO.setFrtArrFlg("N");
	                
	    			List<BkgNtcHisVO> mailBkgNtcHisVOs = bLIssuanceBC.sendDblAutoEmail(dblWblVO, event.getCustTpIdVOs()[i].getRcvId(), account);
	    			// History
	    			if(mailBkgNtcHisVOs!=null){
						if(mailBkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(mailBkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}			
				}
				if (event.getNtcKndCd()[i].equals("BI")){
					CustTpIdVO custTpVO2 = event.getCustTpIdVOs()[i];
					
					DblEdiInVO dblEdiInVO = new DblEdiInVO();
					dblEdiInVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					dblEdiInVO.setEdiReceiveId(custTpVO2.getRcvId());
					dblEdiInVO.setGroupEdiId(custTpVO2.getGroupId());
					dblEdiInVO.setFuncCode(custTpVO2.getFuncCode());
					DblEdiVO dblEdiVo=bLIssuanceBC.createInvoiceBlEdi(dblEdiInVO, account);
					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();						
					
					// History
					for(int j=0;j<dblEdiVo.getFlatFileAckVOs().size();j++){
						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
						bkgNtcHisVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgNtcHisVO.setNtcViaCd("E");
						bkgNtcHisVO.setNtcKndCd("BI");
						bkgNtcHisVO.setEdiId(custTpVO2.getRcvId());
						bkgNtcHisVO.setEsvcGrpCd(custTpVO2.getGroupId());
						bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVo.getFlatFileAckVOs().get(j).getAckStsCd());
						bkgNtcHisVO.setSndUsrId(account.getUsr_id());
						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
						bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());	
						bkgNtcHisVOs.add(bkgNtcHisVO);						
					}
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}
	    			
	    			//Auto Email Send
	    			BkgBlNoVO bkgBlNoVO = utilBC.searchBkgBlNoVO(event.getBkgBlNoVO());
	    			
	    			DblWblVO dblWblVO = new DblWblVO();
	    			dblWblVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
	    			dblWblVO.setTitle("BLUPLOAD:COMPANYSHIP");
	    			dblWblVO.setContents(" ");
	    			dblWblVO.setBlNo(bkgBlNoVO.getBlNo());
//	    			dblWblVO.setNtcKndCd("BI");
	                dblWblVO.setHiddOpt("N");
	                dblWblVO.setFrtAllFlg("N");
	                dblWblVO.setFrtCltFlg("N");
	                dblWblVO.setFrtPpdFlg("N");
	                dblWblVO.setFrtChgFlg("Y");
	                dblWblVO.setFrtArrFlg("N");
	                
	    			List<BkgNtcHisVO> mailBkgNtcHisVOs = bLIssuanceBC.sendDblAutoEmail(dblWblVO, event.getCustTpIdVOs()[i].getRcvId(), account);
	    			// History
	    			if(mailBkgNtcHisVOs!=null){
						if(mailBkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(mailBkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
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
	 * ESM_BKG_1069 : customer change <br>
	 * customer information about inputted customer code retrieve<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustNm(Event e) throws EventException {
       
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       EsmBkg007901Event event = (EsmBkg007901Event) e;

       GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
       try{      	
    	   BkgCreCustomerVO bkgCreCustomerVO = searchBC.searchCustNm(event.getCustCntCd(), event.getCustSeq());
	      
    	   if(bkgCreCustomerVO != null && bkgCreCustomerVO.getCustLglEngNm() != null){
    		   eventResponse.setETCData("cust_nm", bkgCreCustomerVO.getCustLglEngNm());    
    		   eventResponse.setETCData("fmc_cd", bkgCreCustomerVO.getFrtFwrdFmcNo());
    		   eventResponse.setETCData("cust_addr", bkgCreCustomerVO.getBzetAddr());
    	   }else{
    		   eventResponse.setETCData("cust_nm", "");
    		   eventResponse.setETCData("fmc_cd", "");
    		   eventResponse.setETCData("cust_addr", "");
    	   }          
       }catch(EventException ex){
           throw ex;
       }catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
       }
       return eventResponse;
    }	
		
	/** 
	 * transmode  change PRI -> PRD
	 * 
	 * @param String code
	 * @return String
	 */
	private String changeTrspModeCd(String code) {
		String rtnStr = null;
		if("B".equals(code)){
			rtnStr = "WD";
		} else if("R".equals(code)){
			rtnStr = "RD";
		} else if("T".equals(code)){
			rtnStr = "TD";
		} else if("A".equals(code)){
			rtnStr = "TR";
		} else if("U".equals(code)){
			rtnStr = "TW";			
		} else {
			rtnStr = "AL";
		}
		return rtnStr;
	}

   	/**
	 * booking creation, split, c/a confirm<br>
	 * Changing VVD, spcl Cargo request process<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param ScgVvdAproRqstVO[] inputScgVvdVOs
	 * @return 		String
	 * @exception 	EventException
	 */
//	private String reRequestSpclCgoApproval(BkgBlNoVO bkgBlNoVO, String rqstType, ScgVvdAproRqstVO[] inputScgVvdVOs) throws EventException {
	private String reRequestSpclCgoApproval(BkgBlNoVO bkgBlNoVO, String rqstType, ScgVvdAproRqstVO[] inputScgVvdVOs, String onlyDG) throws EventException {
		try{
			String result = "Not Request";
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();			
			ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, rqstType, account);
			ScgVvdAproRqstVO[] scgVvdVOs = null;
			// only when there is spcl cgo, process
	        if(scgAproRqstVOs.length>0){
				OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
				SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();
				
				SpclCgoAproApplVO           spclCgoAproVO = new SpclCgoAproApplVO();
				try {
					if(inputScgVvdVOs != null){
						scgVvdVOs = inputScgVvdVOs;
					} else {
						scgVvdVOs = spclReceiptBC.searchBkgVvd(bkgBlNoVO.getBkgNo());
					}
			        
			        boolean isDg = false;
					for(int i=0;i<scgAproRqstVOs.length;i++){
						if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
							isDg = true;
							break;
						}
					}
					
					//only when there is target lane
					if(scgVvdVOs.length>0){						
						//If there is danger
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
								 * boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� Prohibition
								 * boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
								 * List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();		//Detail of Segregation Validation
								 * List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� Prohibition
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
								boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� Prohibition
								boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
			//					List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();	//Detail of Segregation Validation
								List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎈돗�뜝�럩�뮝�뜝�럩援�占쎈쐻占쎈윥占쎌넰�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅄ�뙔占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗�뜝�럥��嶺뚮슢竊섓옙留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉뉛옙釉뜹뜝�럡�뜦�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈け�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� Prohibition
								List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
								
			//					When taken in the pre check spcl request state is changing.
								if(segRslt == true || vslRslt == true || prtRslt == true){
//									result = "pre-checking";  //Auto request even if DG has restriction 2016.04.19
									String spclRqstDesc = "After implementation pre-checking routines at T/S port, found some conflicts or prohibitions.\n" +
														  "Please check the conflicts or prohibitions.";
									if(vslRsltDtl != null){
										if(vslRsltDtl.size()>0){
											for(int vslIdx=0; vslIdx<vslRsltDtl.size(); vslIdx++){
												spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, vslRsltDtl.get(vslIdx).getSpclCgoSeq(), account);
											}
										}
									}
									
									if(prtRsltDtl != null){
										if(prtRsltDtl.size()>0){
											for(int prtIdx=0; prtIdx<prtRsltDtl.size(); prtIdx++){
												spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, prtRsltDtl.get(prtIdx).getSpclCgoSeq(), account);
											}
										}
									}
								}
							}
						}
						
			        	// During bkg update, c/a confirm, pre checking if I get caught in, sending is Unnecessary
			        	if("pre-checking".equals(result) 
			        		&& ("COMBINE".equals(rqstType) || "UPDATE".equals(rqstType) || "C/A VVD CHANGE".equals(rqstType))){
			        		log.debug("pre-checking -> not auto re-request case");
			        	} else { 
							spclCgoAproVO.setBkgNo(bkgBlNoVO.getBkgNo());
							spclCgoAproVO.setAccount(account);
							spclCgoAproVO.setCreUsrId(account.getUsr_id());
							spclCgoAproVO.setUpdUsrId(account.getUsr_id());
							spclCgoAproVO.setSpclReqInVOs(searchBC.searchSpclReqInVO(bkgBlNoVO));
							
							if (!"Y".equals(onlyDG)){
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
									}else if ("SS".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
										spclCgoAproVO.setSpclCgoTp("S");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
									}	
								}		
				
								//SCG module calling		        
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
									}else if ("SS".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //Stowage
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}	
						        }
							}else{
								for(int i=0;i<scgAproRqstVOs.length;i++){
									if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
										spclCgoAproVO.setSpclCgoTp("D");
										spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);	
									}	
								}		
				
								//SCG module calling		        
						        for(int i=0;i<scgAproRqstVOs.length;i++){
						        	ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
						        	scgAproRqstVO[0] = scgAproRqstVOs[i];
									if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
								        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
									}	
						        }								
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
	
//   	/**
//	 * booking creation, split, c/a confirm<br>
//	 * old version <br>
//	 * VVD changing�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돍�삕占쎈／占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥占쎈첑�뜝�럥���윜諛잙쳛占쎄뎡占쎈쐻占쎈윥�굢怨ㅼ삕占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅占쎈쑏占쎌뿺占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맚嶺뚮Ĳ�걞�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮛�뜝�럥裕쏉옙�눇�뙼蹂��굲�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑋�뜝�럩�쓥�뜝�럥�맶�뜝�럥�쐾�뜝�럥彛℡뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜝�럥�쑓占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윞占쎈뼑�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈♥�뜝�럩紐▼뜝�럥�맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윥占쎈룿�뜝�럥�맶�뜝�럥�쑅占쎌젂�겫釉먮븸�뜝�럥�뒄占쎌젂占쎈룏占쎌굲占쎈눀占쎌몱占쎌맶�뜝�럥�쐾�뜝�럥�몘�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾占쎄턀筌�硫� Cargo request process<br>
//	 *
//	 * @param BkgBlNoVO bkgBlNoVO
//	 * @return 		void
//	 * @exception 	EventException
//	 */
//	private void reRequestSpclCgoApproval(BkgBlNoVO bkgBlNoVO, String rqstType) throws EventException {
//		try{
//			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();			
//			ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, rqstType, account);
//	        
//			
//	        if(scgAproRqstVOs.length>0){
//				OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
//				SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();
//				
//				SpclCgoAproApplVO           spclCgoAproVO = new SpclCgoAproApplVO();
//								
//				try{
//					ScgVvdAproRqstVO[] scgVvdVOs = spclReceiptBC.searchBkgVvd(bkgBlNoVO.getBkgNo());
//					
//			        if(scgVvdVOs.length>0){
//	
//						spclCgoAproVO.setBkgNo(bkgBlNoVO.getBkgNo());
//						spclCgoAproVO.setAccount(account);
//						spclCgoAproVO.setCreUsrId(account.getUsr_id());
//						spclCgoAproVO.setUpdUsrId(account.getUsr_id());
//						spclCgoAproVO.setSpclReqInVOs(searchBC.searchSpclReqInVO(bkgBlNoVO));
//						
//						for(int i=0;i<scgAproRqstVOs.length;i++){
//							if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
//								spclCgoAproVO.setSpclCgoTp("D");
//								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);	
//							}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
//								spclCgoAproVO.setSpclCgoTp("R");
//								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
//							}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
//								spclCgoAproVO.setSpclCgoTp("A");
//								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
//							}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
//								spclCgoAproVO.setSpclCgoTp("B");
//								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
//							}	
//						}		
//		
//						//SCG module calling		        
//				        for(int i=0;i<scgAproRqstVOs.length;i++){
//				        	ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
//				        	scgAproRqstVO[0] = scgAproRqstVOs[i];
//							if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
//						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
//							}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
//						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
//							}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
//						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
//							}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
//						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
//							}	
//				        }
//		        	}
//				} catch (Exception ex){
//			        log.error(ex.toString(), ex);
//				}
//	        }
//	    }catch(EventException ex){
//	        log.error(ex.toString());
//	    	throw ex;
//	    }catch(Exception ex){
//	        log.error(ex.toString());
//			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
//	    }
//	}
	/**
	 * ESM_BKG_0099 : P/C pop-up call back <br>
	 *  As vvd changing,  new route information retrieve in split<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplitTsRoute(Event e) throws EventException {
       try{
	       GeneralEventResponse eventResponse = new GeneralEventResponse();
	       EsmBkg0099Event      event         = (EsmBkg0099Event) e;
	       GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();	       

	       BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
	       bkgBlNoVO.setBkgNo (event.getSplitBkgVO().getSplitBlInfoVO().get(0).getBkgNo());
	       bkgBlNoVO.setPctlNo(event.getSplitBkgVO().getSplitBlInfoVO().get(0).getPctlNo());
	       log.debug("bkg_no:"+bkgBlNoVO.getBkgNo());
	       log.debug("pctl_no:"+bkgBlNoVO.getPctlNo());
	       String rtnRoute = command.searchNewTsRoute(bkgBlNoVO);
	       eventResponse.setETCData("rtn_route", rtnRoute);
	       eventResponse.setETCData("pctl_no",   bkgBlNoVO.getPctlNo());
	       return eventResponse;     
       }catch(EventException ex){
           throw ex;
       }catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
       }
    }	


	/**
	 * ESM_BKG_1062 : open <br>
	 * Code and Name of all Service Scope retrieve<br>
	 * Taa List retrieve with init value<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchSvcScpByTaa(Event e) throws EventException{
		try{
			EsmBkg1062Event event = (EsmBkg1062Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<MdmSvcScpVO> svcScpList =  command.searchSvcScp();
			List<TaaListVO> taaList =  command.searchTaaList(event.getTaaListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(svcScpList);		
			eventResponse.setRsVoList(taaList);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_1062 : retrieve <br>
	 * TAA in ship owner contract retrieve<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchTaaList(Event e) throws EventException{
		try{
			EsmBkg1062Event event = (EsmBkg1062Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<TaaListVO> list =  command.searchTaaList(event.getTaaListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		


	/**
	 * ESM_BKG_1078 : retrieve <br>
	 * Commodity in ship owner contract retrieve<br>
	 *  
	 * @author	
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCmdtByTaa(Event e) throws EventException{
		try{
			EsmBkg1078Event event = (EsmBkg1078Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<TaaCmdtListVO> list = command.searchCmdtByTaa(event.getTaaListInputVO(), event.getCmdtNm(), event.getCmdtCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * execting when bkg is replaned
	 * decide Rail Receiving Date
	 *  
	 * @author		Ryu DaeYoung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		String[]
	 * @exception 	EventException
	 */
	private String[] splitRailReceiveDate(BkgBlNoVO bkgBlNoVO) throws EventException{
		try{
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();		
			ClzTmListVO clzTmListVO = searchBC.searchCargoClosingTime(bkgBlNoVO, account);	
			String fromDt = "";
			String toDt = "";
			String[] railTime = new String[2];
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
			railTime[0] = fromDt;
			railTime[1] = toDt;
			return railTime;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Auto PSA EDI sending
	 * Decide Rail Receiving Date
	 *  
	 * @author		YoungCheal Kim
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
			log.error("err " + ex.toString(), ex);
			//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return  returnVal;
	}	
	
	/**
	 * ESM_BKG_0099 : CBF retrieve <br>  
	 *  As split,CBF in booking split retrieve<br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchCbfFlag(Event e) throws EventException{
		try{
			EsmBkg0099Event event = (EsmBkg0099Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();	
			
			String		cbfFlag = "N"; 
			
			for (int i=0;i<event.getTargetBkg().length;i++){
				BkgBlNoVO bkgBlNoVO = null;
				bkgBlNoVO = event.getTargetBkg()[i];		
				
				cbfFlag = "N";

				cbfFlag = receiptBC.searchCbfFlag (bkgBlNoVO,account);
				
				if ( "Y".equals(cbfFlag)) {
					break;
				}
				
			}
			
			eventResponse.setETCData("cbf_flag",   cbfFlag);
	
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
	 * ESM_BKG_0079_01 <br>  
	 * ESM_BKG_0079_05<br>
	 * If Customer is Black Customer ,check <br>
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
			
			// ESM_BKG_0079_01
			if(e.getEventName().equalsIgnoreCase("EsmBkg007901Event")){
				EsmBkg007901Event event = (EsmBkg007901Event)e;
				BlCustomerInfoVO blCustomerInfoVO = event.getBlCustomerInfoVO();
				custNms.add(blCustomerInfoVO.getSCustNm());
				custNms.add(blCustomerInfoVO.getFCustNm());
				custNms.add(blCustomerInfoVO.getCCustNm());
				
			// ESM_BKG_0079_05
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007905Event")){
				EsmBkg007905Event event = (EsmBkg007905Event)e;
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
	 * ESM_BKG_0083 : Open <br>
	 *  MultiCombo retrieve process<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0083(Event e) throws EventException {
		BookingUtil bookingUtil = null;
		GeneralEventResponse eventResponse = null;
		BkgComboVO bkgComboVO = null;
		try {
			bookingUtil = new BookingUtil();
			eventResponse = new GeneralEventResponse();
			// 01. Combo data retrieve (rcc_cd)
			List<BkgComboVO> rccCd = bookingUtil.searchCombo("CD00255");
			bkgComboVO = new BkgComboVO();
			bkgComboVO.setComboCd("CD00255");
			bkgComboVO.setName("All");
			bkgComboVO.setVal("All");
			rccCd.add(0,bkgComboVO);
			eventResponse.setRsVoList(rccCd);
			// 02. Combo data retrieve (select)
			List<BkgComboVO> select = bookingUtil.searchCombo("CD20049");
			if (null!=select && 0<select.size()) {
				bkgComboVO = new BkgComboVO();
				bkgComboVO.setComboCd("CD20049");
				bkgComboVO.setName("All");
				bkgComboVO.setVal(" ");
				select.add(0,bkgComboVO);
				eventResponse.setRsVoList(select);
			}
			// 03. Combo data retrieve (postal_cd)
			List<BkgComboVO> postalCd = bookingUtil.searchCombo("CD20050");
			if (null!=postalCd && 0<postalCd.size()) {
				eventResponse.setRsVoList(postalCd);
			}
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),ex);  			
		}
	}

	/**
	 * ESM_BKG_1069 : Open <br>
	 * MultiCombo 	retrieve process<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1069(Event e) throws EventException {
		BookingUtil bookingUtil = null;
		GeneralEventResponse eventResponse = null;
		BkgComboVO bkgComboVO = null;
		try {
			bookingUtil = new BookingUtil();
			eventResponse = new GeneralEventResponse();
			// 01. Combo data retrieve (org_trns_mod_cd)
			List<BkgComboVO> orgTrnsModCd = bookingUtil.searchCombo("CD01720");
			bkgComboVO = new BkgComboVO();
			bkgComboVO.setComboCd("CD01720");
			bkgComboVO.setName("");
			bkgComboVO.setVal("N");
			orgTrnsModCd.add(0,bkgComboVO);
			eventResponse.setRsVoList(orgTrnsModCd);
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),ex);  			
		}
	}

	/**
	 * ESM_BKG_0367_02 : Open
	 * EXPORT REFERENCES�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉┼�슣�삌占쎈젾�뜝�럩留띰옙�쐻占쎈윥�젆�꽒�쐻占쎈윞占쏙옙癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔占쎈쇀占쎌돸占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥�렅�뜝�럥�닍�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥��占쎈닱占쎈쐞占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼇�븶占쎄덩占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈쑕占쎌맶�뜝�럥�쐾占쎄턀占쎈씮�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅅ猷뉛옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉끻뜝�럥�맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮ㅏ�솇占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈�占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�뙴�슱�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럡猿�占쎈눀�솒占썽뇡紐뚯삕占쎌맶�뜝�럥�쑋�뜝�럥夷㏆옙�쐻占쎈윥鸚룐뫅�삕占쎌맶�뜝�럥�몧�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�맶�뜝�럥�쑋�댖怨뚮굫占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럥彛믭옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜏類ㅻ졁占쎄땐�뜝�럥�뿮占쎄괌占쎌뒏筌륅옙�뜝�럡�븫�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊�뜝�럥�늾占쎈쇊癰귨옙占쎄뎡占쎌녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�럸占쎈쐻占쎈짗占쎌굲�뜝�럥裕뀐옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�.<br>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExportReferences(Event e) throws EventException {
		log.debug("============================>[[ GeneralBookingConductSC  searchExportReferencesByBkg START ]]<============================");
		EsmBkg036702Event			event		  = (EsmBkg036702Event)e;
		GeneralBookingReceiptBC		command		  = new GeneralBookingReceiptBCImpl();
		GeneralEventResponse		eventResponse = new GeneralEventResponse();

		try{
			//1.EXPORT REFERENCES
			List<ExportReferencesVO> list = command.searchExportReferencesByBkg(event.getExportReferencesVO());
			List<ExportReferencesVO> list2 = command.searchExportReferencesByCntr(event.getExportReferencesVO());
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);

		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		log.debug("============================>[[ GeneralBookingConductSC  searchExportReferencesByBkg END ]]<============================");
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0724 : open<br>
	 * 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�졑占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅嶺뚯쉸占싸살맶�뜝�럥�쑋占쎈쨨饔끸뫀�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈쑌�뙴洹⑥삕占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ묄占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗癲ル슢�뒧野껓옙�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럡�맗�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈짗占쎌굲占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊�뜝�럥�늾占쎈쇊癰귨옙占쎄뎡占쎌녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�럸占쎈쐻占쎈짗占쎌굲�뜝�럥裕뀐옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占� booking占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥�몞占쎈쇀域밟뫁�굲�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇臾꾢뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�뒧占쎈뮛�뇦猿볦삕占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윞占쎈쭢占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥吏쀥뜝�럩援꿨뜝�럩�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�뢾占쎌몡占쎈쐻占쎈쑕占쎌맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럥�돰占쎈쐻占쎈윥�젆遺븐땡占쎈튂�젆�돍�삕�뇡�쑚�쐻占쎈윞占쎈쑆占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥�젃�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빆�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�쑎l over 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�졑占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅占쎌젂占쎄퐩占쎌맶�뜝�럥�쐾�뜝�룞�삕�솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚳퐢肉㏆옙�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�몘�뛾占쏙옙�뒏占쎈마嶺뚮�⑸걙占쎄뎡癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윥�뜝�뜫援⑼옙�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈꽠�⑥궢由삼옙�쐻占쎈쑟占쎄퐷占썩뫅�맊�댚�뀘�쐻占쎈윥�젆遺룸쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥鸚룐벂�쐻占쎈윥�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥琉덂뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럥�룚占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉끻뜝�럥�맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥堉볟뜝�럥苑좑옙�뫁沅∽옙援꿨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윞占쎈뼇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅占쎌젂占쎄퐩占쎌맶�뜝�럥�쐾�뜝�럥占쎈짘�쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎌죸占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲占쎌돳甕곕맮�삕筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥���뜝�럥�맋�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉귨옙�쐻占쎈윥甕겸뫅�삕占쎄뎡占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�룞�삕�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼇�븶占쎄덩占쎌굲�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑅占쎈쐻占쎈쑕占쎌맶�뜝�럥�쐾占쎄턀占쎈씮�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇�돥占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윻�뜝�럥�맶�뜝�럥�쑋嶺뚮ㅅ猷뉛옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉끻뜝�럥�맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮占썲뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�빋占쎈뼔筌앹뼍由경뉩�뫁�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪�얠�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌맽占쎈쐻占쎈윥占쎌쟽占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙뎽�쐻占쎈뼢占쎄땀筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮ㅏ�솇占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵰占쎌몧�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윪占쎈�占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥吏쀥뜝�럩援꿨뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥�뙴�슱�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆�뜝�럡猿��뜝�럥�떁�뜝�럥堉뉛옙�쐻占쎈윥占쏙옙�뜝�럡猿��뜝�럥�쑅占쎈쐻占쎈짗占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩留썲뜝�럥�맶�뜝�럥�쑅�뜝�럩�읇<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRollOver(Event e) throws EventException{
		try{
			EsmBkg0724Event event = (EsmBkg0724Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			RollOvrInfoVO rollOvrInfoVO =  command.searchRollOvr(event.getBkgBlNoVO());
			eventResponse.setETCData("bkg_no",(rollOvrInfoVO.getBkgInforForHistVO().getBkgNo()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getBkgNo():"");
			eventResponse.setETCData("bl_no",(rollOvrInfoVO.getBkgInforForHistVO().getBlNo()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getBlNo():"");
			if (rollOvrInfoVO.getBkgInforForHistVO().getN1stVvd()!=null && rollOvrInfoVO.getBkgInforForHistVO().getN1stVvd().length()>1){
				eventResponse.setETCData("vvd",rollOvrInfoVO.getBkgInforForHistVO().getN1stVvd());
			}else{
				eventResponse.setETCData("vvd",(rollOvrInfoVO.getBkgInforForHistVO().getTrnkVvd()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getTrnkVvd():"");
			}
			if (rollOvrInfoVO.getBkgInforForHistVO().getN1stPol()!=null && rollOvrInfoVO.getBkgInforForHistVO().getN1stPol().length()>1){
				eventResponse.setETCData("pol",rollOvrInfoVO.getBkgInforForHistVO().getN1stPol());
			}else{
				eventResponse.setETCData("pol",(rollOvrInfoVO.getBkgInforForHistVO().getTrnkPol()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getTrnkPol():"");
			}
			if (rollOvrInfoVO.getBkgInforForHistVO().getN1stEtb()!=null && rollOvrInfoVO.getBkgInforForHistVO().getN1stEtb().length()>1){
				eventResponse.setETCData("etb",rollOvrInfoVO.getBkgInforForHistVO().getN1stEtb());
			}else{
				eventResponse.setETCData("etb",(rollOvrInfoVO.getBkgInforForHistVO().getTrnkEtb()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getTrnkEtb():"");
			}
			if(rollOvrInfoVO.getBkgInforForHistVO().getN1stEtd()!=null && rollOvrInfoVO.getBkgInforForHistVO().getN1stEtd().length()>1){
				eventResponse.setETCData("etd",rollOvrInfoVO.getBkgInforForHistVO().getN1stEtd());
			}else{
				eventResponse.setETCData("etd",(rollOvrInfoVO.getBkgInforForHistVO().getTrnkEtd()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getTrnkEtd():"");
			}
			
			eventResponse.setRsVoList(rollOvrInfoVO.getRollOvrVO());
			return eventResponse;
		} catch(EventException se) {
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_BKG_0724 : save <br>
	 * roll over 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�졑占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅占쎌젂占쎄퐩占쎌맶�뜝�럥�쐾�뜝�룞�삕�솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌띿뜴�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럩�쟼�뜝�럥爰뤷뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅嶺뚳퐢肉㏆옙�뀋�뜝�럥�뒇�뜝�럡�떉占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�몘�뛾占쏙옙�뒏占쎈마嶺뚮�⑸걙占쎄뎡癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윪占쎌읆占쎈쐻占쎈윥�뜝�뜫援⑼옙�굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈꽠�⑥궢由삼옙�쐻占쎈쑟占쎄퐷占썩뫅�맊�댚�뀘�쐻占쎈윥�젆遺룸쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥鸚룐벂�쐻占쎈윥�눧袁��쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쐾�뜝�럥琉덂뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎔�뜝�럥�룚占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉끻뜝�럥�맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾紐억쭫�룊�삕野껓옙力놂옙�뜝�뜴�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥堉볟뜝�럥苑좑옙�뫁沅∽옙援꿨뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윞占쎈뼇�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앾옙�쐻占쎈윥鸚룐벂�쐻占쎈윥�씙�뜝�럡�렊�뜝�럥�맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉띸뵳寃쎈돥占쎈쳛占쎄뎡占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅占쎌젂占쎄퐩占쎌맶�뜝�럥�쐾�뜝�럥占쎈짘�쐻占쎈윥占쏙옙占쎈쐻占쎈윥占쎌죸占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀧솾�꺂�돲占쎌돳甕곕맮�삕筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占쏙옙占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗�뜝�럥���뜝�럥�맋�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�㏃녇占쎄틓占쎈뮝�뜝�럥琉귨옙�쐻占쎈윥甕겸뫅�삕占쎄뎡占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈㎜占쎌굲�뜝�럥占쎈뿰�삕占쎌맶�뜝�럥�쐾�뜝�럥鍮잌뜝�럥�맶�뜝�럥�쑅�뜏類ㅻ즸占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몥�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쐾�뜝�럥堉묕옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빢�삕占쎌맶�뜝�럥�쑅勇싲즾踰귨옙�맶�뜝�럥�쑅占쎌뵗占쎈쐻占쎈윞占쎈젇占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮됵옙�뀋�뜝�럡�땽�뜝�럥裕쏉옙�쐻占쎈윥占쎈윲�뜝�럥�맶�뜝�럥�쑅�뜝�럡�떙占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝�뜝�럥夷ⓨ뜝�럥흮占쎄뎡占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧占쎈뎐�뜝�럥�꺙占쎈쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗癲ル슪�맊藥뀄뤋ate 占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉛옙�룯�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉩�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁빉�녇占쎄틓占쎈뮛嶺뚯옓�렰占쎌맶�뜝�럥堉℡뜝�럡��嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉔뜮�맮�삕占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�뵾占쎌뒩占쎌굦�뜝�럥�솯占쎈쐻占쎈윪筌뤴댙�삕占쎌맶�뜝�럥�쑅占쎈뙀筌뚮８�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈탟占쎌굲�뜝�럡�렊占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝占쎈쐻占쎈윥�뜝�럥肉곤옙�굲�뜝�럩留띰옙�쐻占쎈윥占쎌맽占쎈쐻占쎈윥�뜮�엺�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐪筌먦끇利멨뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀯옙�쐻占쎈윥占쏙옙占쎈쐻占쎈윥筌λĿ�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�κ텣�뜝�룞�삕占쎄콬占쎈쇀占쎈�占쎌맶�뜝�럥吏쀥뜝�럥彛믭옙�쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥筌욎�λ쐻占쎈윪�뤃轅⑤쐻占쎈윪占쎈�뗰옙�쐻占쎈윞占쎈빟占쎈쐻占쎈윥獒뺤룊�삕占쎌맶�뜝�럥�쑅�뜏類ㅻ졁占쎄땐�뜝�럥�뿮占쎄괌占쎌뒏筌륅옙�뜝�럡�븫�뜝�럩援뀐옙�쐻占쎈윞占쎈젇占쎌녇占쎄틓占쎈뮛�뜝�럥�럯占쎈쐻占쎈윥占쎄틯�뜝�럥�맶�뜝�럥�쑋占쎈쨨占쎈Ŋ�굲�뜝�럩留띰옙�쐻占쎈윥占쎌몝癲ル슢�뵯占쎈탿�뜝�럩援뀐옙�쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏�뜝�뜴�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁���삕占쎈퉳�뜝�럥堉붺춯�빘堉꿨퐲���삕�젆轅⑦맪占쎄틛占쎌굲占쎈쇀占쎈탟占쎌굲�뜝�럡�렊�뜝�럥�늾占쎈쇊癰귨옙占쎄뎡占쎌녇占쎈늅占쎄틟�뜝�럩援뀐옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎈ぇ占쎈쐻占쎈윪筌띾씛�삕占쎌맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욃뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앯솾�꺂�뒧筌잙돁�쑏占쎈꺏占쎌굲�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇鍮놅옙�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐앭뜝�럥�럸占쎈쐻占쎈짗占쎌굲�뜝�럥裕뀐옙�쐻占쎈윪�뤃�먯삕占쎌맶�뜝�럥�쑋嶺뚮씭�뵛占쎌굲�뜝�럩留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몝癲ル슢履뉐뜝�떥�궡留띰옙�쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁쉻�삕占쎌맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑋嶺뚮쪇占싸살맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럩紐욑옙�쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윪筌륁�λ쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎌몞�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪�뜝�럥�맶�뜝�럥�쑅�뜝�럩紐쀥뜝�럥�맶�뜝�럥�쑅�뜝�럥�쑌占쎈쐻占쎈윥占쎈㎍占쎈쐻占쎈윥占쎌몗占쎈쐻占쎈윥占쎈윫�뜝�럥�맶�뜝�럥�쑅�뜝�럥�럪占쎈쐻占쎈윥占쎈㎍�뜝�럥�맶占쎈쐻�뜝占�<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRollOver(Event e) throws EventException {
		
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0724Event event = (EsmBkg0724Event) e;

			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			begin();
			BkgRollOvrVO[] bkgRollOvrVOs=new BkgRollOvrVO[event.getRollOvrVOs().length];
			
			for(int i=0;i<event.getRollOvrVOs().length;i++){
				BkgRollOvrVO bkgRollOvrVO = new BkgRollOvrVO();
				bkgRollOvrVO.setIbflag(event.getRollOvrVOs()[i].getIbflag());
				bkgRollOvrVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				bkgRollOvrVO.setRollOvrRsnCd(event.getRollOvrVOs()[i].getRollOvrRsnCd());
				bkgRollOvrVO.setDiffRmk(event.getRollOvrVOs()[i].getDiffRmk());
				bkgRollOvrVO.setEvntDt(event.getRollOvrVOs()[i].getEvntDt());
				bkgRollOvrVO.setUpdUsrId(account.getUsr_id());
				bkgRollOvrVO.setRollOvrSeq(event.getRollOvrVOs()[i].getRollOvrSeq());
				bkgRollOvrVOs[i]=bkgRollOvrVO;
			}
			receiptBC.manageBkgRollOver(bkgRollOvrVOs);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}	
	
	/**
	 * ESM_BKG_0367_01 Container Combo LIST
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCntrList(Event e) throws EventException {
		BookingUtil util = new BookingUtil();
		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		String caFlg = "";

		try{
			GeneralEventResponse eventResponse 	= new GeneralEventResponse();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			EsmBkg036701Event event 			= (EsmBkg036701Event) e;
			
			bkgBlNoIN.setBkgNo(event.getPoOtherNoBkgVO().getBkgNo());
	        bkgBlNoIN.setCaUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoOUT = util.searchBkgBlNoVO(bkgBlNoIN);
			if(bkgBlNoOUT != null){
				caFlg = bkgBlNoOUT.getCaFlg();
			}
			
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			if(event.getPoOtherNoBkgVO() != null){
				bkgBlNoVO.setBkgNo(event.getPoOtherNoBkgVO().getBkgNo());
				bkgBlNoVO.setCaFlg(caFlg);
				List<BkgComboVO> list = receiptBC.searchContainerMrnUcr(bkgBlNoVO);
				eventResponse.setRsVoList(list);
			}
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
	 * ESM_BKG_0079_02C : LOCATION CHANGE <br>
	 * check location<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocValid(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007902cEvent event = (EsmBkg007902cEvent)e;
		BookingUtil util = new BookingUtil();
		
		try{
			SearchLocationCodeVO vo = util.searchLocationCode(event.getLocCd());
			
			String locUse = vo==null?"N":"Y";//N : not usable
			eventResponse.setETCData("loc_use", locUse);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * manageManualCctDate() <br>
	 * Common logics to save CutOff date at Booking Receipt Notice Screen <br>
	 * 
	 * @param 	BkgBlNoVO[] bkgBlNoVOs, EsmBkg0098Event event, int i
	 * @return 	BkgClzTmVO[]
	 * @exception EventException
	 */
	private BkgClzTmVO[] manageManualCctDate(BkgBlNoVO[] bkgBlNoVOs, EsmBkg0098Event event, int i) throws EventException {

		BkgClzTmVO bkgClzTmVO = null;
		BkgClzTmVO[] bkgClzTmVOs = null;

		try{

			bkgClzTmVOs = new BkgClzTmVO[3];
			bkgClzTmVO = new BkgClzTmVO();
			bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
			bkgClzTmVO.setClzTpCd("T");
			bkgClzTmVO.setMnlSetDt(event.getCctMnl()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
			bkgClzTmVO.setNtcFlg("Y");
			bkgClzTmVO.setUpdUsrId(account.getUsr_id());
			bkgClzTmVOs[0] = bkgClzTmVO;

			bkgClzTmVO = new BkgClzTmVO();
			bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
			bkgClzTmVO.setClzTpCd("D");
			bkgClzTmVO.setMnlSetDt(event.getDocCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
			bkgClzTmVO.setNtcFlg("Y");
			bkgClzTmVO.setUpdUsrId(account.getUsr_id());
			bkgClzTmVOs[1] = bkgClzTmVO;

			bkgClzTmVO = new BkgClzTmVO();
			bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
			bkgClzTmVO.setClzTpCd("R");
			bkgClzTmVO.setMnlSetDt(event.getCargoCctMnl()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
			bkgClzTmVO.setNtcFlg("Y");
			bkgClzTmVO.setUpdUsrId(account.getUsr_id());
			bkgClzTmVOs[2] = bkgClzTmVO;
			
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);			
		}
		return bkgClzTmVOs;
	}	
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLoadPortFacility(Event e) throws EventException {
		try{
			GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// bkg_sts_cd
			List<BkgYardCdVO> loadPort = genSearchCmd.searchBkgTmlEdiBatchYardCd();
			List<BkgComboVO> comboList = new ArrayList<BkgComboVO>();
			for (int i = 0; i < loadPort.size(); i++) {
				BkgYardCdVO yardVo = loadPort.get(i);
				BkgComboVO comboVo = new BkgComboVO();
				comboVo.setName(yardVo.getEdiRcvDesc());
				comboVo.setVal(yardVo.getEdiRefCd());
				comboList.add(comboVo);
			}
			eventResponse.setCustomData("load_port", comboList);
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
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchBatchEdiVvdList(Event e) throws EventException {
		try{
			EsmBkg0618Event event = (EsmBkg0618Event)e;
			GeneralBookingSearchBC genSearchCmd = new GeneralBookingSearchBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			String vvdList = genSearchCmd.searchBatchEdiVvdList(event.getEdirefCd());
			eventResponse.setETCData("vvd", vvdList);
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
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse bookingEdiTransmitToTerminalBatch(Event e) throws EventException {
		try{
			EsmBkg0618Event event = (EsmBkg0618Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BkgBlNoVO[] bkgBlNoVOs = command.searchBkgTmlEdiBatch(event.getEdirefCd(), event.getVvd());	
			if(bkgBlNoVOs.length > 0){
				CustTpIdVO[] custTpIdVOs = new CustTpIdVO[bkgBlNoVOs.length]; 
				for (int i=0; i < bkgBlNoVOs.length; i++) {
					CustTpIdVO custTpIdVO = new CustTpIdVO();
					custTpIdVO.setIbflag("U");
					custTpIdVOs[i] = custTpIdVO;
				}
				BkgYardCdVO bkgYardCdVO = new BkgYardCdVO();
				bkgYardCdVO.setEdiRefCd(event.getEdirefCd());
				bkgYardCdVO.setEdiRcvId(event.getEdirefId());
				eventResponse = (GeneralEventResponse) sendBkgTmlEdiBatch(bkgBlNoVOs, null, custTpIdVOs, null, "BT", "N", bkgYardCdVO);
			}
			
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
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse cancellationMessageList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<BkgComboVO> list = new ArrayList<BkgComboVO>();
			list.add(new BkgComboVO("R","","S","Sales Guidance","",""));
			list.add(new BkgComboVO("R","","G","Marketing Guidance","",""));
			list.add(new BkgComboVO("R","","M","Missing Documents","",""));
			list.add(new BkgComboVO("R","","L","Lack of Space and Equipment","",""));
			list.add(new BkgComboVO("R","","D","Duplicate booking","",""));
			list.add(new BkgComboVO("R","","C","Customer Request","",""));
			list.add(new BkgComboVO("R","","N","No Show (Confirm bookings but no pickup container)","",""));
			list.add(new BkgComboVO("R","","I","Internal Error","",""));
			list.add(new BkgComboVO("R","","O","Other","",""));
			eventResponse.setRsVoList(list);
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse sned301UEdiCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EsmBkg0620Event event = (EsmBkg0620Event)e;
			CancellationMessageBC command = new CancellationMessageBCImpl();
			eventResponse.setETCData("CNT", String.valueOf(command.sned301UEdiCheck(event.getBkgNo(), event.getType())));
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_9424 : Check Out <br>
	 * Empty Booking Save<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOutBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg9424Event event = (EsmBkg9424Event)e;

		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		 
		try {
			begin();			
			RepoBkgForUpdateVO repoBkgForUpdateVO = new RepoBkgForUpdateVO();
			repoBkgForUpdateVO.setBkgBlNoVO(event.getBkgBlNoVO());
			repoBkgForUpdateVO.setRepoCntrVOs(event.getRepoCntrVOs());
			
			// 15. Check Out 
			receiptBC.modifyCheckOutBkg(repoBkgForUpdateVO, account);
			
			commit();		
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * ESM_BKG_9424 : Check In <br>
	 * Empty Booking Save<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse checkInBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg9424Event event = (EsmBkg9424Event)e;

		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		 
		try {
			begin();			
			RepoBkgForUpdateVO repoBkgForUpdateVO = new RepoBkgForUpdateVO();
			repoBkgForUpdateVO.setBkgBlNoVO(event.getBkgBlNoVO());
			repoBkgForUpdateVO.setRepoCntrVOs(event.getRepoCntrVOs());
			
			// 15. Check In 
			receiptBC.modifyCheckInBkg(repoBkgForUpdateVO, account);
			
			commit();		
			eventResponse.setETCData("SuccessYn", "Y");
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
	
	
}

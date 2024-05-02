/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportBC.java
*@FileTitle : StatusReport
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByBLVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListinVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListinVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListoutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgClearanceCrossCheckListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListByBLVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListinVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlCntrInfoReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlStsReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BokCntrListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.BokCntrListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CllCdlVslSumForRDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CmBkgRptVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CustVipReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CustVipReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.LoadingConfirmationinVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsTPSZSumListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsYardSumListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.SearchTradeListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportSpecialCargoOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportSummaryOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListInVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListOutVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmDashboardVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmEdiSupVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmHistoryVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;

 
/**
 * -Bookingreport Business Logic Command Interface<br>
 * - Bookingreport business logic Interface<br>
 *
 * @author
 * @see StatusreportEventResponse reference
 * @since J2EE 1.6
 */
public interface StatusReportBC {

	/**
	 * BDR Status Inquiry information retrieve
	 * @param SearchBDRBookingStatusListVO searchBDRBookingStatusListVO
	 * @return List<SearchBDRBookingStatusListVO>
	 * @exception EventException
	 */		
	 public List<SearchBDRBookingStatusListVO> searchBDRBookingStatusList(SearchBDRBookingStatusListVO searchBDRBookingStatusListVO) throws EventException;
	 
	 /**
	  * getting retrieve time
	  * @param BDRBookingStatusListVO vo
	  * @return List<SearchInternetUserAuthVO>
	  * @exception EventException
	  */		
	 public List<SearchBDRBookingStatusListVO> getRuntime() throws EventException;
	 
	 /**
		 * B/L Data insert end confirm report function
		 * @param BkgClearanceCrossCheckListInVO bkgClearanceCrossCheckListInVO
		 * @return List<BkgClearanceCrossCheckListInVO>
		 * @exception EventException
		 */	
	 public List<BkgClearanceCrossCheckListInVO> bkgClearanceCrossCheckList(BkgClearanceCrossCheckListInVO bkgClearanceCrossCheckListInVO) throws EventException ;
	 
	 /**
		 * Container List on Stowage & B/L<BR>
		 * ESM_BKG_0162<BR>
		 * showing result of Cross check at Bay-Plan and Booking Data
		 * @param CntrStowageintVO vo
		 * @return List<CntrStowageintVO>
		 * @exception EventException
		 */	
	 public List<CntrStowageintVO> searchContainerStowageList(CntrStowageintVO vo) throws  EventException ;	 
	
	
	
	 /**
	 * Outbound Container Movement Status<br>
	 * 2.Outbound Container Movement Status by Yard Report(ESM_BKG_0619)<BR>
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsYardSumListOutVO>
	 * @throws EventException
	 */
	public List<OutBdMovementStsYardSumListOutVO> searchOutBdMovementByYardSum(OutBdMovementStsListInVO vo) throws EventException ;
	
	/**
	 * Outbound Container Movement Status(ESM_BKG_0619)<br>
	 * Outbound Container Movement Status by Type/Size Report(ESM_BKG_0619)<br>
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsTPSZSumListOutVO>
	 * @throws EventException
	 */
	public List<OutBdMovementStsTPSZSumListOutVO> searchOutBdMovementByTPSZSum(OutBdMovementStsListInVO vo) throws EventException;
	
		
	/**
	 * sending Container Loading Confirmation mail to customer
	 * @param LoadingConfirmationinVO vo
	 * @param LoadingConfirmationinVO[] vos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendEmailByBkgNoList(LoadingConfirmationinVO vo,LoadingConfirmationinVO[] vos, SignOnUserAccount account) throws EventException ;
	
	/**
	 * sending Container Loading Confirmation fax to customer
	 * @param LoadingConfirmationinVO vo
	 * @param LoadingConfirmationinVO[] vos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendFaxByBkgNoList(LoadingConfirmationinVO vo,LoadingConfirmationinVO[] vos, SignOnUserAccount account) throws EventException ;
	
	/**
	 * checking validation in case of sending Container Loading Confirmation mail and fax to customer
	 * @param List<BkgNtcHisVO> bkgNtcHisVOs
	 * @param String key
	 * @return boolean
	 * @throws Exception
	 */
	public boolean checkDupReceiver(List<BkgNtcHisVO> bkgNtcHisVOs, String key) throws Exception ;

	/**
	 * 0103 Booking Status Report information retrieve<br>
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportOutVO>
	 * @throws EventException
	 */
	 public List<StatusReportOutVO> searchBLStatusList(StatusReportInVO statusReportInVO)  throws EventException ;
	 
	 
	 /**
		 * retrieve BKG OFC SUB information for Booking Status Report information
		 * @param StatusReportInVO statusReportInVO
		 * @return List<StatusReportOutVO>
		 * @throws EventException
		 */
	public String searchBLStatusList2(StatusReportInVO statusReportInVO)  throws EventException;	 
	 
	/**
	 * 0103 Booking Status Report SpecialCargo information retrieve<br>
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportSpecialCargoOutVO>
	 * @throws EventException
	 */
	public List<StatusReportSpecialCargoOutVO> searchBLStatusListSpecialCargo(StatusReportInVO statusReportInVO)  throws EventException;
	

	/**
	 * 0103 Booking Status Report Summary information retrieve<br>
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportSummaryOutVO>
	 * @throws EventException
	 */
	public List<StatusReportSummaryOutVO> searchBLStatusListSummary(StatusReportInVO statusReportInVO)   throws EventException;
	 
	 /**
	 * BDR Booking No Status - Inquiry(ESM_BKG_0727)<BR>
	 * @param BdrBookingNoListVO vo
	 * @return List<BdrBookingNoListVO>
	 * @throws EventException
	 */
	public List<BdrBookingNoListVO> searchBDRBookingNoList(BdrBookingNoListVO vo) throws EventException ;
	
	/**
	 * C/M Data Cross-Check List (Master BL/Houser BL) retrieve.<br>
	 * @param BkgCMCroChkListinVO vo
	 * @return List<BkgCMCroChkListByBLVO>
	 * @throws EventException
	 */
	public List<BkgCMCroChkListByBLVO> searchCMCrossCheckList(BkgCMCroChkListinVO vo)  throws EventException ;
	
	/**
	 * C/M Print by VVD (CM,FAX) retrieve<br>
	 * @param BkgCMPrintListinVO vo
	 * @return List<BkgCMPrintListoutVO>
	 * @throws EventException
	 */
	public List<BkgCMPrintListoutVO> searchCMPrintList(BkgCMPrintListinVO vo)  throws EventException ;
	
	/**
	 * B/L Status Report(0647) information retrieve<br>
	 * @param BlStsReportInVO blStsReportInVO
	 * @return List<BlStsReportOutVO>
	 * @throws EventException
	 */
	public List<BlStsReportOutVO> searchBLStsReportList(BlStsReportInVO blStsReportInVO)  throws EventException ;
	
	/**
	 * 1006 Queue Detail Amend Reason Detail retrieve
	 * @param String bkgNo
	 * @param String srNo
	 * @return List<DocsAmendReasonCDVO>
	 * @throws EventException
	 */
	public List<DocsAmendReasonCDVO> searchAmendDetail( String bkgNo, String srNo) throws EventException ;

	
	/**
	 * 1007 Queue Detail Return Reason retrieve
	 * @param String srKndCd
	 * @param String bkgNo
	 * @param String srNo
	 * @return List<DocsQueueDetailVO>
	 * @throws EventException
	 */
	public List<DocsQueueDetailVO> searchQueueDetail( String srKndCd,String bkgNo, String srNo) throws EventException;
	
	
	/**
	 * 0953 O/B & T/S Loading Report by Location information retrieve.<br>
	 * @param tsLoadingRptByLocListInVO TsLoadingRptByLocListInVO
	 * @return List<TsLoadingRptByLocListOutVO>
	 * @exception EventException
	 */
	public List<TsLoadingRptByLocListOutVO> searchTsLoadingReportByLocation(TsLoadingRptByLocListInVO tsLoadingRptByLocListInVO)  throws EventException ;
	
	 /**
	 * Outbound Container Movement Status(ESM_BKG_0619)<BR>
	 * 1.Outbound Container Movement Status<BR>
	 * 
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsListInVO>
	 * @exception EventException
	 */	
	 public List<OutBdMovementStsListInVO> searchOutBdMovementStsList(OutBdMovementStsListInVO vo) throws  EventException ;	 

	 /**
	 * Trade,Sub Trade를 조회합니다.<br>
	 * @param div
	 * @param inputVO
	 * @return List<SearchTradeListVO>
	 * @throws EventException
	 */
	public List<SearchTradeListVO> searchTradeList(String div, OutBdMovementStsListInVO inputVO) throws EventException;
		
		
	/**
	 * VIP Customer Report(0625) 정보를 조회합니다.<br>
	 * @param CustVipReportInVO custVipReportInVO
	 * @return List<CustVipReportOutVO>
	 * @throws EventException
	 */		
	public List<CustVipReportOutVO> searchCustVipReport(CustVipReportInVO custVipReportInVO) throws EventException;
	
	 /**
	  * Outbound Container Movement Status(ESM_BKG_1110)<BR>
	  * 1.Outbound Container Movement Status<BR>
	  * 
	  * @param OutBdEirMovementStatusListVO vo
	  * @return List<OutBdEirMovementStatusListVO>
	  * @exception EventException
	  */	
	 public List<OutBdEirMovementStatusListVO> searchOutBdEirMovementStatusList(OutBdEirMovementStatusListVO vo) throws  EventException ;	 

	/**
	* C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	* @param BkgCroChkListinVO bkgCroChkListinVO
	* @return List<BkgCroChkListByBLVO>
	* @throws EventException
	*/
	public List<BkgCroChkListByBLVO> searchCrossCheckList(BkgCroChkListinVO bkgCroChkListinVO)  throws EventException ;

	/**
	 * 1701 Booking Container Report information retrieve<br>
	 * @param BokCntrListInVO bokCntrListInVO
	 * @return List<BokCntrListOutVO>
	 * @throws EventException
	 */
	public List<BokCntrListOutVO> searchBokCntrList(BokCntrListInVO bokCntrListInVO) throws EventException;
	
	/**
	 * 1702 BL Container Information Report retrieve<br>
	 * @param CmBkgRptVO cmBkgRptVO
	 * @return List<BlCntrInfoReportOutVO>
	 * @throws EventException
	 * @author SJH.20150113.ADD
	 */
	 public List<BlCntrInfoReportOutVO> searchBLCntrInfoList(CmBkgRptVO cmBkgRptVO)  throws EventException ;	
	 
	/**
	 * 1701 Booking Container Report information retrieve (Down Excel)<br>
	 * @param BokCntrListInVO bokCntrListInVO
	 * @return List<Object>
	 * @throws EventException
	 */
	 public List<Object> searchBokCntrDownExcel(BokCntrListInVO bokCntrListInVO) throws EventException;
	 
	 /**
	 * 1703 Booking Loading Report information retrieve (Down Excel)<br>
	 * @param CmBkgRptVO cmBkgRptVO
	 * @param String rptId
	 * @return List<Object>
	 * @throws EventException
	 * @author SJH.20150130.ADD
	 */
	 public List<Object> searchCmBkgRptDownExcel(CmBkgRptVO cmBkgRptVO, String rptId) throws EventException;
	
	 /**
		 * VGM Dashboard
		 * @param VgmDashboardVO vgmDashboardVO
		 * @return List<VgmDashboardVO>
		 * @exception EventException
		 */
		public List<VgmDashboardVO> searchVgmDashboardList(VgmDashboardVO vgmDashboardVO) throws EventException;
		
	 /**
		 * VGM Dashboard
		 * @param VgmDashboardVO vgmDashboardVO
		 * @exception EventException
		 */
		public void manageVgmDashboard(VgmDashboardVO[] vgmDashboardVO) throws EventException;
		 /**
			 * VGM Dashboard
			 * @param VgmDashboardVO vgmDashboardVO
			 * @return List<CllCdlVslSumForRDVO>
			 * @exception EventException
			 */
			public List<CllCdlVslSumForRDVO> searchCllCdlRdParam(VgmDashboardVO vgmDashboardVO) throws EventException;
			
			 /**
			 * VGM History
			 * @param VgmHistoryVO vgmHistoryVO
			 * @return List<VgmHistoryVO>
			 * @exception EventException
			 */
			public List<VgmHistoryVO> searchVgmHistory(VgmHistoryVO vgmHistoryVO) throws EventException;
			 /**
			 * VGM Close
			 * @param VgmDashboardVO vgmDashboardVO
			 * @param String saveFlg
			 * @exception EventException
			 */
			public void manageVgmClz(VgmDashboardVO vgmDashboardVO, String saveFlg) throws EventException;
			 /**
			 * Search VGM EDI SUP
			 * @param VgmEdiSupVO vgmEdiSupVO
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmEdiSup(VgmEdiSupVO vgmEdiSupVO) throws EventException;
			 /**
			 * Search VGM Auto 301 EDI SUP
			 * @param String bkgNo
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmAuto301EdiSup(String bkgNo) throws EventException;
			 /**
			 * Search VGM Auto 301 EDI SUP
			 * @param String bkgNo
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmAutoVermasEdiSup(String bkgNo) throws EventException;
			
			/**
			 * Check BKG for VGM CLZ
			 * @param String bkgNo
			 * @return String vgmClzYn
			 * @exception EventException
			 */
			public String checkBkgForVgmClz(String bkgNo) throws EventException;
			
			/**
			 * Search VGM EDI SUP
			 * @param VgmEdiSupVO vgmEdiSupVO
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmEdiSupMlt(VgmEdiSupVO vgmEdiSupVO) throws EventException;
			
			/**
			 * Search VGM EDI MULTI List
			 * @param VgmEdiSupVO vgmEdiSupVO
			 * @return List<VgmEdiSupVO>
			 * @exception EventException
			 */
			public List<VgmEdiSupVO> searchVgmEdiMltList(VgmEdiSupVO vgmEdiSupVO) throws EventException;
}

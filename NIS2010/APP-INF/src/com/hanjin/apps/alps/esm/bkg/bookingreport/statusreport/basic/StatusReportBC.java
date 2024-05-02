/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportBC.java
*@FileTitle : StatusReport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.28 김경섭
* 1.0 Creation 
* 1.23 2010.09.27 이재위 [CHM-201005253-01] [BKG/DOC] EIR Exchange & Customs Release Check Report 신규개발(ESM_BKG_1110)[SZPBB]
* 2013.01.10 조정민 [CHM-201222115][BL Issue&Print기능] (1) BL Status Report-GSO추가 (2) BL Issue&Onboard Date Update-FWDR정보 추가
* 2013.04.08 김진주 [CHM-201323813] 미반입 관리 관련 sms 전송 기능 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListoutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgClearanceCrossCheckListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListByBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BlStsReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CustVipReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CustVipReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.LoadingConfirmationinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsTPSZSumListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsYardSumListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListSumVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchRollOverInformationVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchTradeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportSpecialCargoOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportSummaryOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SurchageSummaryInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByExportBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.VgmStatusReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportOutVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;

 
/**
 * NIS2010-Bookingreport Business Logic Command Interface<br>
 * - NIS2010-Bookingreport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Gyoung Sub
 * @see StatusreportEventResponse 참조
 * @since J2EE 1.6
 */

public interface StatusReportBC {

	/**
	 * BDR Status Inquiry 정보를 조회합니다.
	 * @param SearchBDRBookingStatusListVO searchBDRBookingStatusListVO
	 * @return List<SearchBDRBookingStatusListVO>
	 * @exception EventException
	 */		
	 public List<SearchBDRBookingStatusListVO> searchBDRBookingStatusList(SearchBDRBookingStatusListVO searchBDRBookingStatusListVO) throws EventException;
	 
	/**
	 * Roll Over Information Inquiry 정보를 조회합니다.
	 * @param SearchRollOverInformationVO searchRollOverInformationVO
	 * @return List<SearchRollOverInformationVO>
	 * @exception EventException
	 */		
	 public List<SearchRollOverInformationVO> searchRollOverInformationList(SearchRollOverInformationVO searchRollOverInformationVO) throws EventException;
	 
	 /**
	  * 조회시간을 가져온다.
	  * @param BDRBookingStatusListVO vo
	  * @return 
	  * @exception EventException
	  */		
	 public List<SearchBDRBookingStatusListVO> getRuntime() throws EventException;
	 
	 /**
	  * B/L Data  입력 완료 확인 리포트 기능 
	  * @param BkgClearanceCrossCheckListInVO bkgClearanceCrossCheckListInVO
	  * @return List<BkgClearanceCrossCheckListInVO> 
	  * @exception EventException
	  */	
	 public List<BkgClearanceCrossCheckListInVO> bkgClearanceCrossCheckList(BkgClearanceCrossCheckListInVO bkgClearanceCrossCheckListInVO) throws EventException ;
	 
	 /**
	 * Container List on Stowage & B/L<BR>
	 * 화면 - ESM_BKG_0162<BR>
	 * Bay-Plan과 NIS Booking Data를 Cross Check한 결과를 보여주는 화면 
	 * @param CntrStowageintVO vo
	 * @return List<CntrStowageintVO>
	 * @exception EventException
	 */	
	 public List<CntrStowageintVO> searchContainerStowageList(CntrStowageintVO vo) throws  EventException ;	 
	
	 /**
	 * Loading Confirmation by Shipper (Fax / E-Mail)<BR>
	 * 화면 - ESM_BKG_0618<BR>
	 * 고객에게 Container Loading Confirmation을 발송하는 기능 
	 * 
	 * @param LoadingConfirmationinVO vo
	 * @return List<LoadingConfirmationinVO>
	 * @exception EventException
	 */	
	 public List<LoadingConfirmationinVO> searchBookingListForLoadingConfirmation(LoadingConfirmationinVO vo) throws  EventException;	 
	 
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
	 * Outbound Container Movement Status(ESM_BKG_0619)<BR>
	 * 1.Outbound Container Movement Status<BR>
	 * 
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsListInVO>
	 * @exception EventException
	 */	
	 public List<OutBdMovementStsListInVO> searchOutBdMovementStsList(OutBdMovementStsListInVO vo) throws  EventException ;	 

	 /**
	 * Outbound Container Movement Status<br>
	 * 2.Outbound Container Movement Status by Yard Report(ESM_BKG_0619)<BR>
	 * 
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsYardSumListOutVO>
	 * @throws EventException
	 */
	public List<OutBdMovementStsYardSumListOutVO> searchOutBdMovementByYardSum(OutBdMovementStsListInVO vo) throws EventException ;
	
	/**
	 * Outbound Container Movement Status(ESM_BKG_0619)<br>
	 * 3.Outbound Container Movement Status by Type/Size Report(ESM_BKG_0619)<br>
	 * 
	 * @param OutBdMovementStsListInVO vo
	 * @return List<OutBdMovementStsTPSZSumListOutVO>
	 * @throws EventException
	 */
	public List<OutBdMovementStsTPSZSumListOutVO> searchOutBdMovementByTPSZSum(OutBdMovementStsListInVO vo) throws EventException;
	
		
	 /**
	 * 고객에게 Container Loading Confirmation을 메일을 발송하는 기능 
	 * 
	 * @param LoadingConfirmationinVO vo
	 * @param LoadingConfirmationinVO[] vos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendEmailByBkgNoList(LoadingConfirmationinVO vo,LoadingConfirmationinVO[] vos, SignOnUserAccount account) throws EventException ;
	
	/**
	 * 고객에게 Container Loading Confirmation 팩스를 발송하는 기능 
	 * 
	 * @param LoadingConfirmationinVO vo
	 * @param LoadingConfirmationinVO[] vos
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendFaxByBkgNoList(LoadingConfirmationinVO vo,LoadingConfirmationinVO[] vos, SignOnUserAccount account) throws EventException ;
	
	/**
	 * 고객에게 Container Loading Confirmation 메일,팩스를 발송시 중복 체크
	 * 
	 * @param List<BkgNtcHisVO> bkgNtcHisVOs
	 * @param String key
	 * @return boolean
	 * @throws Exception
	 */
	
	public boolean checkDupReceiver(List<BkgNtcHisVO> bkgNtcHisVOs, String key) throws Exception ;

	/**
	 * 0103 Booking Status Report 정보를 조회합니다.<br>
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportOutVO>
	 * @throws EventException
	 */
	 public List<StatusReportOutVO> searchBLStatusList(StatusReportInVO statusReportInVO)  throws EventException ;
	 
	 
	/**
	 * 0103 Booking Status Report 정보를 위한 BKG OFC SUB정보를조회합니다.<br>
	 * 
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportOutVO>
	 * @throws EventException
	 */
	public String searchBLStatusList2(StatusReportInVO statusReportInVO)  throws EventException;	 
	 
	 /**
	 * 0103 Booking Status Report SpecialCargo 정보를 조회합니다.<br>
	 * 
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportSpecialCargoOutVO>
	 * @throws EventException
	 */
	public List<StatusReportSpecialCargoOutVO> searchBLStatusListSpecialCargo(StatusReportInVO statusReportInVO)  throws EventException;
	

	/**
	 * 0103 Booking Status Report Summary 정보를 조회합니다.<br>
	 * 
	 * @param StatusReportInVO statusReportInVO
	 * @return List<StatusReportSummaryOutVO>
	 * @throws EventException
	 */
	public List<StatusReportSummaryOutVO> searchBLStatusListSummary(StatusReportInVO statusReportInVO)   throws EventException;
	 
	 /**
	 * BDR Booking No Status - Inquiry(ESM_BKG_0727)<BR>
	 * 
	 * @param BdrBookingNoListVO vo
	 * @return List<BdrBookingNoListVO>
	 * @throws EventException
	 */
	public List<BdrBookingNoListVO> searchBDRBookingNoList(BdrBookingNoListVO vo) throws EventException ;
	
	/**
	* C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	* @param BkgCMCroChkListinVO bkgCMCroChkListinVO
	* @return List<BkgCMCroChkListByBLVO>
	* @throws EventException
	*/
	public List<BkgCMCroChkListByBLVO> searchCMCrossCheckList(BkgCMCroChkListinVO bkgCMCroChkListinVO)  throws EventException ;
	
	/**
	* Export Export Data Cross-Check List를 조회합니다.<br>
	* @param BkgCMCroChkListByExportBLVO bkgCMCroChkListByExportBLVO
	* @return List<BkgCMCroChkListByExportBLVO>
	* @throws EventException
	*/
	public List<BkgCMCroChkListByExportBLVO> searchCMCrossExportCheckList(BkgCMCroChkListByExportBLVO bkgCMCroChkListByExportBLVO)  throws EventException ;	
	
	/**
	* C/M Print by VVD (CM)를 조회합니다.<br>
	* @param BkgCMPrintListinVO bkgCMPrintListinVO
	* @return List<BkgCMPrintListoutVO>
	* @throws EventException
	*/
	public List<BkgCMPrintListoutVO> searchCMPrintList(BkgCMPrintListinVO bkgCMPrintListinVO)  throws EventException ;

	
	/**
	 * VIP Customer Report(0625) 정보를 조회합니다.<br>
	 * @param CustVipReportInVO custVipReportInVO
	 * @return List<CustVipReportOutVO>
	 * @throws EventException
	 */		
	public List<CustVipReportOutVO> searchCustVipReport(CustVipReportInVO custVipReportInVO) throws EventException;
	
	/**
	 * B/L Status Report(0647) 정보를 조회합니다.<br>
	 * @param BlStsReportInVO blStsReportInVO
	 * @return List<BlStsReportOutVO>
	 * @throws EventException
	 */
	public List<BlStsReportOutVO> searchBLStsReportList(BlStsReportInVO blStsReportInVO)  throws EventException ;
	
	/**
	 *  1006 Queue Detail Amend Reason Detail을 조회합니다.
	 * 
	 * @param  String bkgNo
	 * @param  String srNo
	 * @return List<DocsAmendReasonCDVO>
	 * @throws EventException
	 */
	public List<DocsAmendReasonCDVO> searchAmendDetail( String bkgNo, String srNo) throws EventException ;

	
	/**
	 *  1007 Queue Detail Return Reason을 조회합니다.
	 * 
	 * @param  String srKndCd
	 * @param  String bkgNo
	 * @param  String srNo
	 * @return List<DocsQueueDetailVO>
	 * @throws EventException
	 */
	public List<DocsQueueDetailVO> searchQueueDetail( String srKndCd,String bkgNo, String srNo) throws EventException;
	
	
	 /**
	 * 0953 O/B & T/S Loading Report by Location 정보를 조회합니다.<br>
	 * 
	 * @param tsLoadingRptByLocListInVO TsLoadingRptByLocListInVO
	 * @return List<TsLoadingRptByLocListOutVO>
	 * @exception EventException
	 */
	public List<TsLoadingRptByLocListOutVO> searchTsLoadingReportByLocation(TsLoadingRptByLocListInVO tsLoadingRptByLocListInVO)  throws EventException ;

	/**
	* C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	* @param BkgCroChkListinVO bkgCroChkListinVO
	* @return List<BkgCroChkListByBLVO>
	* @throws EventException
	*/
	public List<BkgCroChkListByBLVO> searchCrossCheckList(BkgCroChkListinVO bkgCroChkListinVO)  throws EventException ;
	
	/**
	 * Trade,Sub Trade를 조회합니다.<br>
	 * @param div
	 * @param inputVO
	 * @return List<SearchTradeListVO>
	 * @throws EventException
	 */
	public List<SearchTradeListVO> searchTradeList(String div, OutBdMovementStsListInVO inputVO) throws EventException;
	
	/** 
	 * GSO에 속한 Sub Office 를 조회
	 * @param String gso
	 * @return List<BlStsReportOutVO>
	 * @throws EventException
	 */
	public List<BlStsReportOutVO> searchGsoOfcList(String gso) throws EventException;
	
	
	 /**
	 * Outbound Container Movement Status (E-MAIL,SMS) (ESM_BKG_0622)<BR>
	 * @param OutBdMvntStsNtcListInVO vo
	 * @return List<OutBdMvntStsNtcListInVO>
	 * @throws EventException
	 */
	public List<OutBdMvntStsNtcListInVO> searchOutBdMovementStsNtcList(OutBdMvntStsNtcListInVO vo) throws  EventException ;	 
	 /**
	 * Outbound Container Movement Status (E-MAIL,SMS)Summary (ESM_BKG_0622)<BR>
	 * @param OutBdMvntStsNtcListSumVO vo
	 * @return List<OutBdMvntStsNtcListSumVO>
	 * @throws EventException
	 */
	public List<OutBdMvntStsNtcListSumVO> searchOutBdMovementStsNtcListSum(OutBdMvntStsNtcListSumVO vo) throws  EventException ;	
	
	/**
	 * ESM_BKG_0622 : multi <br>
	 * 미반입 안내메일 send
	 * @param OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO
	 * @param SignOnUserAccount account
	 * @return BkgNtcHisVO
	 * @throws EventException
	 */
	public BkgNtcHisVO sendCntrListByEmail(OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_BKG_0622 : multi <br>
	 * 미반입 안내메일 send
	 * @param OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO
	 * @param SignOnUserAccount account
	 * @return BkgNtcHisVO
	 * @throws EventException
	 */
	public BkgNtcHisVO sendShprCntrListBySms(OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * ESM_BKG_0622 : multi <br>
	 * 미반입 안내메일 send
	 * @param OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO
	 * @param SignOnUserAccount account
	 * @return BkgNtcHisVO
	 * @throws EventException
	 */
	public BkgNtcHisVO sendCntrListBySms(OutBdMvntStsNtcListInVO outBdMvntStsNtcListInVO, SignOnUserAccount account) throws EventException;
	
	/**
	* Surchage Summary Repot를 조회합니다.<br>
	* @param SurchageSummaryInVO surchageSummaryInVO
	* @return List<BkgCroChkListByBLVO>
	* @throws EventException
	*/
	public List<SurchageSummaryInVO> searchSurchageSummary(SurchageSummaryInVO surchageSummaryInVO)  throws EventException ;
	
	/**
	* Surchage Detail Repot를 조회합니다.<br>
	* @param SurchageSummaryInVO surchageSummaryInVO
	* @return List<BkgCroChkListByBLVO>
	* @throws EventException
	*/
	public List<SurchageSummaryInVO> searchSurchageDetail(SurchageSummaryInVO surchageSummaryInVO)  throws EventException ;

	
	/**
	 * @param WarningReportInVO warningReportInVO
	 * @return List<WarningReportOutVO>
	 * @throws EventException
	 */
	public List<WarningReportOutVO> searchWarningReportList(WarningReportInVO warningReportInVO) throws EventException ;		
	/**
	 * @param VgmStatusReportVO vgmStatusReportVO
	 * @return List<VgmStatusReportVO>
	 * @throws EventException
	 */
	public List<VgmStatusReportVO> searchVgmCrossCheckList(VgmStatusReportVO vgmStatusReportVO) throws EventException ;	
}
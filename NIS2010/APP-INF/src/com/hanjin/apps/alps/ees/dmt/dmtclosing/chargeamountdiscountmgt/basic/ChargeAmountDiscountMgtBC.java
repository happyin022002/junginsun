/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtBC.java
*@FileTitle : DEM/DET Adjustment Request - After Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.07.21 이성훈
* 1.0 Creation
* 2010.09.16 김태균 [] [EES-DMT] AFTER BOOKING BACKENDJOB 메시지 수정
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ActualCostListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBkgRqstAproStsVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingAproItmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailFlgVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingExptClrRqstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFileListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFullHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingMasListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingPfmcListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDescVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingRequestDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.BackEndJobResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.CommentHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Dmtclosing Business Logic Command Interface<br>
 * - NIS2010-Dmtclosing에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SungHoon, Lee
 * @see Ees_dmt_2008EventResponse 참조
 * @since J2EE 1.6
 */

public interface ChargeAmountDiscountMgtBC {
	/**
	 * After Booking 목록을 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListVO>
	 * @exception EventException
	 */
	public List<AfterBKGListVO> searchAfterBookingList(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * After Booking 의 기타정보를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBKGListInputVO>
	 * @exception EventException
	 */
	public List<AfterBKGListInputVO> searchAfterBookingDAR(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * Booking No. 에 해당하는 컨테이너 정보를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerChargeByBooking(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException;
	
	/**
	 * 컨테이너의 Quantity를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerQuantity(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException;
	
	/**
	 * 컨테이너의 Currency를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO chargeBookingContainerParmVO
	 * @return List<ChargeBookingContainerVO>
	 * @exception EventException
	 */
	public List<ChargeBookingContainerVO> searchContainerCurrency(ChargeBookingContainerParmVO chargeBookingContainerParmVO) throws EventException;
	
	/**
	 * Comment History를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<CommentHistoryVO>
	 * @exception EventException
	 */
	public List<CommentHistoryVO> searchCommentHistory(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * Booking Data 를 조회 합니다. <br>
	 * 
	 * @param AfterBKGDetailInputVO afterBKGDetailInputVO
	 * @return List<AfterBKGDetailVO>
	 * @exception EventException
	 */
	public List<AfterBKGDetailVO> searchBookingData(AfterBKGDetailInputVO afterBKGDetailInputVO) throws EventException;
	
	/**
	 * BKG/B/L No 의 Tariff Type 이 맞는지 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkCalcuationType(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * BKG/B/L No 의 Tariff Type 에 맞는 Location Code를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationByBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * Tariff Type 과 BKG 또는 B/L No. 가 중복되는지 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return String
	 * @exception EventException
	 */
	public String checkDupTariffBKGBLNo(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * Balance Charge 가 있는 CNTR 인지 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkBalanceCharge(AfterBKGListInputVO afterBKGListInputVO) throws EventException;
	
	/**
	 * 등록된 After Booking DAR 를 Cancel 상태로 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void cancelAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * 등록된 After Booking DAR 를 Approved 상태로 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void approveAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * After Booking 에 대한 승인처리시 Calculation 을 실행 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @param SignOnUserAccount account
	 * @param DmtResultVO dmtResultVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> processCalculation(AfterProgressVO afterProgressVO, SignOnUserAccount account, DmtResultVO dmtResultVO) throws EventException;
	
	/**
	 * 등록된 After Booking DAR 를 Counter Offered 상태로 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void counterofferAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * 등록된 After Booking DAR 를 Reject 상태로 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void rejectAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void requestAfterBookingDAR(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Location Code 와 I/O Bound Code 에 해당하는 Calcuation Type을 조회 합니다. <br>
	 * 
	 * @param String locCd
	 * @param String ioBndCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCalcTypeCode(String locCd, String ioBndCd) throws EventException;	
	
	/**
	 * 승인처리를 위해서 BackEndJob 을 실행 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String doBackEndJobApproval(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account);
	
	/**
	 * 승인처리를 위해서 실행한 BackEndJob 의 현재 진행상태를 조회 합니다. <br>
	 * 
	 * @param String jobKey
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJobApproval(String jobKey) throws EventException;	
	
	/**
	 * BackEndJob 이 완료된 후 결과를 조회 합니다. <br>
	 * 
	 * @param String jobKey
	 * @return BackEndJobResultVO
	 * @exception EventException
	 */
	public BackEndJobResultVO completeBackEndJobApproval(String jobKey) throws EventException;
	
	/**
	 * After Booking Request 의 Update Date 정보를 조회 합니다.<br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUpdateDate(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * After Booking DAR 의 상태를 수정 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @exception EventException
	 */
	public void approveOfcAfterBookingDAR(AfterProgressVO afterProgressVO) throws EventException;
	
	/**
	 * AfterBooking 승인처리 후, Reject/Counter Offer 실행시 가상Inovice 생성된게 있다면, 가상Invoice 상태를 해제해준다. <br>
	 * 
	 * @param String aftExptDarNo
	 * @param String loginUsrId
	 * @param String loginOfcCd
	 * @exception EventException
	 */
	public void cancelVirtualInvoice(String aftExptDarNo, String loginUsrId, String loginOfcCd) throws EventException;

	/**
	 * After Booking Actual Cost List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<ActualCostListVO>
	 * @exception EventException
	 */
	public List<ActualCostListVO> searchActualCostList(AfterBKGListInputVO InputVO) throws EventException;
	

	/**
	 * After Booking File List 조회 <br>
	 * 
	 * @param AfterBookingFileListVO InputVO
	 * @return List<AfterBookingFileListVO>
	 * @exception EventException
	 */
	public List<AfterBookingFileListVO> searchAfterBookingFileList(AfterBookingFileListVO InputVO) throws EventException;
	

	/**
	 * After Booking Expt Clr Rqst  조회 <br>
	 * 
	 * @param AfterBKGListVO[] InputVOs
	 * @return List<AfterBookingExptClrRqstVO>
	 * @exception EventException
	 */
	public List<AfterBookingExptClrRqstVO> searchAfterBookingExptClrRqst(AfterBKGListVO[] InputVOs) throws EventException;

	/**
	 * After Booking FULL HISTORY 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingFullHistoryVO>
	 * @exception EventException
	 */
	public List<AfterBookingFullHistoryVO> searchAfterBookingFullHistory(AfterBKGListInputVO InputVO) throws EventException;

	/**
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @return List<AfterBookingReasonDescVO>
	 * @exception EventException
	 */
	public List<AfterBookingReasonDescVO> searchAfterBookingReasonDesc() throws EventException;

	/**
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingReasonDetailVO>
	 * @exception EventException
	 */
	public List<AfterBookingReasonDetailVO> searchAfterBookingReasonDetail(AfterBKGListInputVO InputVO) throws EventException;
	
	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingReasonDescVO InputVO
	 * @return List<AfterBookingDetailReasonListVO>
	 * @exception EventException
	 */
	public List<AfterBookingDetailReasonListVO> searchAfterBookingDetailReasonList(AfterBookingReasonDescVO InputVO) throws EventException;

	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingPfmcListVO InputVO
	 * @return List<AfterBookingPfmcListVO>
	 * @exception EventException
	 */
	public List<AfterBookingPfmcListVO> searchAfterBookingPfmcList(AfterBookingPfmcListVO InputVO) throws EventException;
	

	/**
	 * After Booking Detail Request 생성 합니다. <br>
	 * 
	 * @param AfterBookingRequestDetailVO afterBookingRequestDetailVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void createAfterBookingRequestDetail(AfterBookingRequestDetailVO afterBookingRequestDetailVO, SignOnUserAccount account) throws EventException;

	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void requestAfterBookingTSave(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account) throws EventException;


	/**
	 * After Booking Detail 목록을 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<AfterBookingDetailFlgVO>
	 * @throws DAOException
	 */
	public List<AfterBookingDetailFlgVO> searchAfterBookingDetailFlg(AfterBKGListInputVO afterBKGListInputVO) throws EventException;

	/**
	 * After Booking Approval Item List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingAproItmVO>
	 * @exception EventException
	 */
	public List<AfterBookingAproItmVO> searchAfterBookingAproItm(AfterBKGListInputVO InputVO) throws EventException;
	
	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void requestAfterBookingSave(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Comment History를 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO afterBKGListInputVO
	 * @return List<CommentHistoryVO>
	 * @exception EventException
	 */
	public List<CommentHistoryVO> searchAproPath(AfterBKGListInputVO afterBKGListInputVO) throws EventException;

	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterProgressVO afterProgressVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void modifyAfterBookingStatusUpdate(AfterProgressVO afterProgressVO,	SignOnUserAccount account) throws EventException;

	/**
	 * After Booking Path Code, Role Status Code 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingPathRole(AfterBKGListInputVO InputVO) throws EventException;

	/**
	 * BKG/B/L No 의 Tariff Type 에 맞는 Location Code를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerParmVO paramVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExchangeRate(ChargeBookingContainerParmVO paramVO) throws EventException;
	
	/**
	 * BKG/B/L No 의 Tariff Type 에 맞는 Location Code를 조회 합니다. <br>
	 * 
	 * @param ChargeBookingContainerVO chargeBookingContainerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingRsnVal(ChargeBookingContainerVO chargeBookingContainerVO) throws EventException;

	/**
	 * After Booking Reason Detail List 조회 <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return List<AfterBookingReasonDetailVO>
	 * @exception EventException
	 */
	public List<AfterBookingReasonDetailVO> searchAfterBookingReasonUcTtl(AfterBKGListInputVO InputVO) throws EventException;

	/**
	 * uc_cgo_psbl_flg 조회 합니다. <br>
	 * 
	 * @param AfterBKGListInputVO InputVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUcCgoPsblFlg(AfterBKGListInputVO InputVO) throws EventException;
	

	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param AfterBookingMasListVO InputVO
	 * @return List<AfterBookingMasListVO>
	 * @exception EventException
	 */
	public List<AfterBookingMasListVO> searchAfterBookingMasList(AfterBookingMasListVO InputVO) throws EventException;

	/**
	 * After Booking Detail Reason List 조회 <br>
	 * 
	 * @param String vvdCd
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingVvdCd(String vvdCd) throws EventException;

	/**
	 * After Booking 제목 조회 합니다. <br>
	 * 
	 * @param String darNo
	 * @return String
	 * @exception EventException
	 */
	public String searchAfterBookingSubject(String darNo) throws EventException;

	/**
	 * After Booking Request & Approval STS List 조회 <br>
	 * 
	 * @param AfterBkgRqstAproStsParamVO afterBkgRqstAproStsParamVO
	 * @param SignOnUserAccount account
	 * @return List<AfterBkgRqstAproStsVO>
	 * @exception EventException
	 */
	public List<AfterBkgRqstAproStsVO> searchAfterBookingrRequestApprovalStatusList(AfterBkgRqstAproStsParamVO afterBkgRqstAproStsParamVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * After Booking DAR를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param AfterBKGGRPVO afterBKGGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void approvalAfterBookingDAR(AfterBKGGRPVO afterBKGGRPVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * After Booking Office Code Check 로직 조회 <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcChkFlg() throws EventException;
	
}
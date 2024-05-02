/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationBC.java
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : Hwang HyoKeun
*@LastVersion : 1.0
* 2009.05.21 Hwang HyoKeun
* 1.0 Creation
* 2010.10.20 김태균 [CHM-201006558-01] [EES-DMT] confirm, delete, delete cancel, office transfer 멀티 팝업창에서 처리 안되게 처리
* 2010.10.28 김태균 [] [EES-DMT] 표준위배 수정 및 office transfer 수정사항 반영
* 2010.12.07 김태균 [] [EES-DMT] 표준위배 수정
* 2011.08.04 김경섭 [] [EES-DMT] 표준위배 수정
* 2011.11.09 김현화 [CHM-201113641-01] sendEDOChargeFreeTime추가.
* 2012.09.11 김현화[CHM-201219003-01]OP-MT Detention Calculation 화면/기능 개발. 
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AftBkgPathSetupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeltSpecRsnRmkVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivFileVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivHisListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltPathStupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltRqstFileVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCorrHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.InactiveReasonVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.OPMTChargeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchChgDeltPathStupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiDetailReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchInactiveCheckVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS2010-Dmtclosing Business Logic Command Interface<br>
 * - NIS2010-Dmtclosing에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see Ees_dmt_3001EventResponse 참조
 * @since J2EE 1.6
 */

public interface ChargeCalculationBC {
	
	/**
	 * Office별 또는 VVD별 Charge List를 조회한다<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO  
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchChargeListByOfficeOrVVD(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException;

	
	/**
	 * Yard별 Container List를 조회한다.<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO  
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeListByPodEta(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException;

	
	/**
	 * Charge 발생된 금액에 대해서 확정(Confirm)한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String confirmContainerCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
			SignOnUserAccount account) throws EventException;

	/**
	 * 해당 Charge의 CorrRmk 정보를 수정한다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @exception EventException
	 */
	public void modifyChargeCorrRmk(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	/**
	 * GRP INV Creation 대상 Charge의 Exchange Rate 정보를 조회한다.
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchGrpInvExRate(ChargeCalculationContainerVO[] chargeCalculationContainerVOs) throws EventException;
	
	/**
	 * Booking별 Container Charge List를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeByBookingList(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * Customer에 대한 Charge 정보를 조회한다.<br>
	 * @param ChargeByBookingCustomerParmVO  chargeByBookingCustomerParmVO
	 * @return ChargeByBookingCustomerGrpVO
	 * @exception EventException
	 */
	public ChargeByBookingCustomerGrpVO searchChargeByCustomer(ChargeByBookingCustomerParmVO  chargeByBookingCustomerParmVO) throws EventException;

	
//	/**
//	 * Delete한 Charge를 이전 Status로 복구한다.<br>
//	 * 
//	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
//	 * @param SignOnUserAccount account
//	 * @return String
//	 * @exception EventException
//	 */
//	public String removeCancelCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
//			SignOnUserAccount account) throws EventException;

	
	/**
	 * Charge의 To Data에 DR Data를 입력하고 저장전에 미리 얼마의 금액이 계산되는지 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account 
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO precalDRDateCharge(ChargeArgumentVO chargeArgumentVO,
				ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)  throws EventException;
	
	
	/**
	 * Container Charge 정보를 수정한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs 
	 * @param SignOnUserAccount account 
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO modifyCharge(ChargeArgumentVO chargeArgumentVO,
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException;


	/**
	 * Balance Charge를 생성한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs 
	 * @param SignOnUserAccount account 
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createBalanceCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs
											, SignOnUserAccount account) throws EventException;

	
	/**
	 * Container 및 Tariff Type별로 한 건의 Charge 정보를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeByContainer(ChargeArgumentVO chargeArgumentVO) throws EventException;

	
	/**
	 * Office 및 VVD별  Charge List 정보를 조회한다.<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchChargeStatusListByOfficeOrVVD(
			ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException;

	
	/**
	 * Office Transfer 처리에 따른 Charge 정보를 수정한다.<br>
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs 
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String modifyChargeByOfficeTransfer(OfficeTransferParmVO[] officeTransferParmVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * Office Transfer 처리에 따른 Charge 정보를 생성한다.<br>
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs 
	 * @exception EventException
	 */
	public void createChargeByOfficeTransfer(OfficeTransferParmVO[] officeTransferParmVOs) throws EventException;
	
	
	/**
	 * Charge별 계산한 History를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @return List<DmtChgCorrHisVO>
	 * @exception EventException
	 */
	public List<DmtChgCorrHisVO> searchCorrectionHistory(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * Partial할 대상 Charge를 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchPartialPayment(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회하고,
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다.<br>
	 * 
	 * @return List<DeleteReasonListVO>
	 * @exception EventException
	 */
	public List<DeleteReasonListVO> searchDeleteReasonList() throws EventException;
	
	
	/**
	 * DEM/DET Billing 담당자가 DEM/DET Charge 확정 하는 과정에서 화주의 귀책이 아니거나,
	 * Manual Invoice가 필요한 Charge를 Delete한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String removeCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * Charge를 Partial 처리한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * General Charge를 제외한 DR로 생성된 모든 Balance Charge를 삭제한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelDRBalanceCharge(ChargeCalculationContainerVO chargeCalculationContainerVO, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * Container Charge 정보를 수정한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO modifyChargeByContainer(ChargeCalculationContainerVO chargeCalculationContainerVO, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * POD ETA 날짜를 조회한다.<br>
	 * 
	 * @param ManualChargeCreationVO[] manualChargeCreationVOs
	 * @return List<ManualChargeCreationVO>
	 * @exception EventException
	 */
	public List<ManualChargeCreationVO> searchPODEta(ManualChargeCreationVO[] manualChargeCreationVOs)
		throws EventException;
	
	
	/**
	 * Container별 VD Movement Date를 조회한다.<br>
	 * 
	 * @param VDMovementVO[] vdMovementVOs
	 * @return List<VDMovementVO>
	 * @exception EventException
	 */
	public List<VDMovementVO> searchVDMovementByPodEta(VDMovementVO[] vdMovementVOs) throws EventException;
	
	
	/**
	 * Batch로 생성되지 않은 Batch를 미리 Manual로 Charge를 생성한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createManualCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * CHARGE HISTORY를 저장한다.<br>
	 * 
	 * @param InvoiceIssueMgtVO invoiceIssueMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * 해당 Container Charge에 적용된 Basic 및 Exception Tariff와 Clock Stop 등의 계산 내역을 조회한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeCalculationDetailVO
	 * @exception EventException
	 */
	public ChargeCalculationDetailVO searchChargeDetail(ChargeArgumentVO chargeArgumentVO) throws EventException;

	/**
	 * Invoice Group에 대한 CHARGE HISTORY를 저장한다.<br>
	 * 
	 * @param List<InvoiceIssueVO> invoiceIssueVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoiceByGroup(List<InvoiceIssueVO> invoiceIssueVOs, SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * SZPBB Office로 생성된 Container Charge List를 조회한다.<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO  
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchChargeBySZPBB(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException;

	
	/**
	 * SZPBB Office로 발생한 Charge관련한 Movement Data를 조회한다.<br>
	 * 
	 * @param MovementSZPBBParmVO[] movementSZPBBParmVOs
	 * @return List<MovementSZPBBVO>
	 * @exception EventException
	 */
	public List<MovementSZPBBVO> searchMovementBySZPBB(MovementSZPBBParmVO[] movementSZPBBParmVOs) throws EventException;
	
	
	/**
	 * SZPBB Office의 "DMOF', "DMIF" Charge를 생성한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createChargeBySZPBB(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
			SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Invoice Cancel에 대한 CHARGE HISTORY를 저장한다.<br>
	 * 
	 * @param List<ChargeArgumentVO> chargeArgumentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoiceByCancel(List<ChargeArgumentVO> chargeArgumentVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * CHARGE Trucker 정보를 저장한다.<br>
	 * 
	 * @param InvoiceIssueMgtVO invoiceIssueMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeTruckerForInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account ) throws EventException;
	
	/**
	 * Booking Container 정보를 갱신한다.<br>
	 * 
	 * @param DmtChgBkgCntrVO dmtChgBkgCntrVO
	 * @exception EventException
	 */
	public void modifyBookingContainer(DmtChgBkgCntrVO dmtChgBkgCntrVO ) throws EventException;
	
	/**
	 * Charge Calculation 정보를 갱신한다.<br>
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @exception EventException
	 */
	public void modifyChargeCalculation(DmtChgCalcVO dmtChgCalcVO ) throws EventException;
	
	/**
	 * Charge Calculation 정보를 저장한다.<br>
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @exception EventException
	 */
	public void createCharge(DmtChgCalcVO dmtChgCalcVO ) throws EventException;
	
	/**
	 * Charge 계산시 적용된 Clock Stop 이 있을경우 History 를 생성한다.<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @param List<String> cStopNoList
	 * @exception EventException
	 */
	public void modifyClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO, List<String> cStopNoList ) throws EventException;
	
	/**
	 * Clock Stop 이 있을경우 History 를 삭제한다<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @exception EventException
	 */
	public void deleteClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO ) throws EventException;
	
	/**
	 * Clock Stop History가 존재하면 Clock Stop History를 Insert한다.<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @exception EventException
	 */
	public void addClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO) throws EventException;
	
	/**
	 * VVD 정보를 저장 합니다.<br>
	 * 
	 * @param VVDCheckDataVO vVDCheckDataVO
	 * @throws EventException
	 */
	public void modifyBookingContainerVVD(VVDCheckDataVO vVDCheckDataVO) throws EventException;
	
	/**
	 * EDI 로 각 모듈별 정보를 전송 합니다.<br>
	 * 
	 * @param List<EDIVO> EDIVOs
	 * @throws EventException
	 */
	public void sendToEDI(List<EDIVO> EDIVOs) throws EventException;
	
	/**
	 * CTOC/CTIC 대상으로 해당 정보를 수정한다.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws EventException
	 */
	public void modifyOrgChgAmt(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * Dual Charge Tariff List를 조회한다<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchDualChargeTariff(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * 해당 Back End Job의 상태를 리턴한다.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException;
	
	
	/**
	 * 해당 Back End Job을 실행시킨다.
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String doBackEndJob(ChargeArgumentVO chargeArgumentVO,
				ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)  throws EventException;
	
	
	 /**
	  * Charge를 Delete하기 위해서 Request 한다.
	  * 
	  * @param ChargeInactivDetailVO[] chargeInactivDetailVOs
	  * @param ChargeInactivFileVO[] chargeInactivFileVOs
	  * @param SignOnUserAccount account 
	  * @param String RqstNo
	  * @return String
	  * @exception EventException
	  */	
	public String requestChargeDeletion(ChargeInactivDetailVO[] chargeInactivDetailVOs, ChargeInactivFileVO[] chargeInactivFileVOs,SignOnUserAccount account, String RqstNo) throws EventException;
	
//	 /**
//	  * Charge를 Delete Reject 처리한다.
//	  * 
//	  * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
//	  * @param SignOnUserAccount account 
//	  * @exception EventException
//	  */
//	public void rejectChargeDeletion(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account ) throws EventException ;
	
	/**
	  * Office Code에 대한 DMT Office 정보를 조회한다.
	  * 
 	  * @param String OfcCd
	  * @param String rhq
	  * @return List<OfficeNameVO>
	  * @exception EventException
	  */
	public List<OfficeNameVO> searchDMTOfficeByApprovalOffice(String ofcCd, String rhq) throws EventException;
	
	/**
	  * Charge Delete 대상 Data들의 List를 조회.
	  * 
	  * @param ChargeDeletionRequstVO chargeDeletionRequstVO
	  * @return List<ChargeCalculationContainerVO>
	  * @exception EventException
	  */
	public List<ChargeCalculationContainerVO> searchChargeDeletionRequest(ChargeDeletionRequstVO chargeDeletionRequstVO) throws EventException;
	
	/**
	 *Charge 정보를 재계산하여 수정한다.(Recalculation)<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO modifyChargeByBooking(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;
		
	/**
	 * FT_END_DT 변경에 따라 EDI 전송함.
	 * @param List<EDIVO> ftEndDtEDIVOs
	 * @throws EventException
	 */
	public void sendEDOChargeFreeTime(List<EDIVO> ftEndDtEDIVOs) throws EventException;
	
	/**
	 * OP-MT Detention Inquiry 대상 Charge List를 조회한다.<br>
	 * 
	 * @param OPMTChargeParmVO oPMTChargeParmVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchOPMTChargeListbyInquiry(
			OPMTChargeParmVO oPMTChargeParmVO) throws EventException;
	
	/**
	 *OP-MT Detention Calculation 대상 Charge List를 조회한다.<br>
	 * 
	 * @param OPMTChargeParmVO oPMTChargeParmVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchOPMTChargeListbyCalculation(
			OPMTChargeParmVO oPMTChargeParmVO) throws EventException;

	/**
	 * DMT Booking, Container & Charge 정보를 조회한다<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeCalculationContainerVO
	 * @exception EventException
	 */
	public ChargeCalculationContainerVO searchBookingNChargeInfo(
			ChargeArgumentVO chargeArgumentVO) throws EventException ;

	/**
	 * DMT Booking SUM Charge 정보를 조회한다 ( DTOC, DMOF )<br>
	 * @param bkgNo
	 * @return
	 * @throws EventException
	 */
	public String searchBookingChargeOB(String bkgNo) throws EventException ;
	
	/**
	 * Charge Deletion 승인경로 테이블에 등록된 승인경로정보를 조회합니다. <br>
	 * @param SearchChgDeltPathStupVO searchChgDeltPathStupVO
	 * @return List<ChgDeltPathStupVO>
	 * @throws EventException
	 */	
	public List<ChgDeltPathStupVO> searchChargeDeletionPathSetupList(SearchChgDeltPathStupVO searchChgDeltPathStupVO) throws EventException;	
	
	/**
	 * Deletion Authority Setup 메뉴에서 등록 및 수정, 삭제된 설정정보에 대한 트랜잭션처리를 관리합니다. <br> 
	 * 
	 * @param ChgDeltPathStupVO[] chgDeltPathStupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChargeDeletionPathSetup(ChgDeltPathStupVO[] chgDeltPathStupVOs, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Charge Deletion 승인처리 전 승인권한과 승인상태의 유효여부를 체크합니다. <br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void checkChargeDeletionValidation(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
			throws EventException;
	
	/**
	 * Charge Deletion 요청에 대해서 각 승인단계별 권한자가 승인 or 거절시 해당 처리를 실행한다. <br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyChargeDeletionProcessStatus(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;
	
	/**
	 * 승인처리후 하위Office 결재자에게 메일을 전송한 후, 메일전송번호를 변경이력에 갱신해준다. <br>
	 * 
	 * @param List<ChargeCalculationContainerVO> chargeCalculationContainerVOList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyChargeDeletionEmlSndNo(List<ChargeCalculationContainerVO> chargeCalculationContainerVOList, SignOnUserAccount account)
		throws EventException;
	
	/**
	 * 로그인 사용자의 승인권한이 있는 승인경로를 조회한다. <br>
	 * 
	 * @param String lginUsrId
	 * @param String lginOfcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeDeletionPath(String lginUsrId, String lginOfcCd) throws EventException;	
	
	/**
	 * Charge Deletion Request File 을 조회합니다. <br>
	 * @param ChgDeltRqstFileVO chgDeltRqstFileVO
	 * @return List<ChgDeltRqstFileVO>
	 * @throws EventException
	 */	
	public List<ChgDeltRqstFileVO> searchChargeDeletionRequestFileList(ChgDeltRqstFileVO chgDeltRqstFileVO) throws EventException;	
	
	/**
	 * Charge Deletion 요청을 취소합니다. <br>
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */		
	public void cancelChargeDeletionRequest(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회하고,
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다.<br>
	 * 
	 * @return List<SearchDeleteMultiReasonListVO>
	 * @exception EventException
	 */
	public List<SearchDeleteMultiReasonListVO> searchDeleteMultiReasonList() throws EventException;	
	
	/**
	 * Charge Delete시 Delete Reason Data들의 List를 조회하고,
	 * 공통코드 테이블에서 Delete Reason Code와 Description을 조회한다.<br>
	 * 
	 * @param SearchDeleteMultiReasonListVO searchDeleteMultiReasonListVO
	 * @return List<SearchDeleteMultiDetailReasonListVO>
	 * @exception EventException
	 */
	public List<SearchDeleteMultiDetailReasonListVO> searchDeleteMultiDetailReasonList(SearchDeleteMultiReasonListVO searchDeleteMultiReasonListVO) throws EventException;
	
	/**
	 * Charge Deletion 요청시 입력한 Specific Reason 별 Remark 상세내역을 조회한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return List<ChargeDeltSpecRsnRmkVO>
	 * @exception EventException
	 */
	public List<ChargeDeltSpecRsnRmkVO> searchDeletionSpecificReasonRemarkList(ChargeCalculationContainerVO chargeCalculationContainerVO) throws EventException;	
	
	/**
	 * 해당 Charge의 Correction UC Flag 정보를 수정한다.
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String ucFlag
	 * @param String ofcCd
	 * @param String usrId
	 * @exception EventException
	 */
	public void modifyChargeUcFlag (String bkgNo, String cntrNo, String ucFlag, String ofcCd, String usrId) throws EventException ;

	/**
	 * 해당 Charge의 Correction UC Flag 정보를 수정한다.
	 * 
	 * @param String ucCsNo
	 * @param String blNo
	 * @exception EventException
	 */
	public void modifyChargeUcFlagBlNo (String ucCsNo, String blNo) throws EventException ;
	
	/**
	 * After BKG Approval 등록된 경로 목록을 조회한다. <br> 
	 * 
	 * @param AftBkgPathSetupVO aftBkgPathSetupVO
	 * @return
	 * @throws EventException
	 */
	public List<AftBkgPathSetupVO> searchAftBkgPathList(AftBkgPathSetupVO aftBkgPathSetupVO) throws EventException ;
	
	/**
	 * After BKG Approval Setup 메뉴에서 등록 및 수정, 삭제된 설정정보에 대한 트랜잭션처리를 관리합니다. <br> 
	 * 
	 * @param AftBkgPathSetupVO[] aftBkgPathSetupVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAftBkgPathSetup(AftBkgPathSetupVO[] aftBkgPathSetupVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Inactive History 조회한다.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return List<ChargeInactivHisListVO>
	 * @exception EventException
	 */
	public List<ChargeInactivHisListVO> searchInactiveHistoryList(ChargeCalculationContainerVO chargeCalculationContainerVO) throws EventException;	
	

	/**
	 * Charge Detail 조회한다.<br>
	 * 
	 * @param ChargeInactivDetailVO chargeInactivDetailVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCharge(ChargeInactivDetailVO chargeInactivDetailVO) throws EventException;	
	
	/**
	 * Inactive Reason 조회한다.<br>
	 * 
	 * @param InactiveReasonVO inactiveReasonVO
	 * @return List<InactiveReasonVO>
	 * @exception EventException
	 */
	public List<InactiveReasonVO> searchInactiveReason(InactiveReasonVO inactiveReasonVO) throws EventException;

	/**
	 * Inactive List 조회한다.<br>
	 * 
	 * @param InactiveInputVO inactiveInputVO
	 * @param SignOnUserAccount account
	 * @return List<InactiveListVO>
	 * @exception EventException
	 */
	public List<InactiveListVO> searchInactiveList(InactiveInputVO inactiveInputVO, SignOnUserAccount account) throws EventException;


	/**
	 * Booking Info, INV Validation<br>
	 * 
	 * @param SearchInactiveCheckVO searchInactiveCheckVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBookingInfo(SearchInactiveCheckVO searchInactiveCheckVO) throws EventException;


	/**
	 * Inactive 최종인지 아닌지 확인하는 부분임.<br>
	 * 
	 * @param ChargeCalculationContainerVO chgCalcCntrVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isChargeDeletionLastApprovalPath(ChargeCalculationContainerVO chgCalcCntrVO) throws EventException;
	
	
	/**
	 * Inactive Reason 중 FESCO S/C case Contract Customer(US067219)여부를 확인한다<br>
	 * 
	 * @param String scNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchContractCustomer(String scNo) throws EventException;
	
	
	/**
	 * Inactive Reason 중 FESCO S/C case 입력받은 Invoice Cancel 여부를 확인한다<br>
	 * Y: cancelled, N: not cancelled, X: not exists
	 * 
	 * @param String invNo
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceStatus(String invNo) throws EventException;
	
	
	/**
	 * OC 시점의 Container Movement Date 조회
	 * @param String temp_bkg_no, String temp_cntr_no, String temp_cntr_cyc_no
	 * @return String
	 * @throws EventException
	 */
	public String searchOcCnmvDt(String temp_bkg_no, String temp_cntr_no, String temp_cntr_cyc_no ) throws EventException;

	
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationBC.java
*@FileTitle : Charge Calculation by Office & VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeByOfficeOrVVDVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationDetailVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DeleteReasonListVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCorrHisVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ManualChargeCreationVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBParmVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.MovementSZPBBVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.VDMovementVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.vo.OfficeTransferParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Dmtclosing Business Logic Command Interface<br>
 * @author 
 * @see reference Ees_dmt_3001EventResponse
 * @since J2EE 1.6
 */

public interface ChargeCalculationBC {
	
	/**
	 * search Charge List by Office or VVD<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO  
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchChargeListByOfficeOrVVD(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException;

	
	/**
	 * search Container List by Yard<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO  
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeListByPodEta(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException;

	
	/**
	 * Confirm to Charge.<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String confirmContainerCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
			SignOnUserAccount account) throws EventException;

	/**
	 * modify CorrRmk of Charge
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @exception EventException
	 */
	public void modifyChargeCorrRmk(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	/**
	 * Search Exchange Rate of GRP INV Creation Charge
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchGrpInvExRate(ChargeCalculationContainerVO[] chargeCalculationContainerVOs) throws EventException;
	
	/**
	 * Search Container Charge List by Booking no <br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeByBookingList(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * Search Charge by Customer<br>
	 * @param ChargeByBookingCustomerParmVO  chargeByBookingCustomerParmVO
	 * @return ChargeByBookingCustomerGrpVO
	 * @exception EventException
	 */
	public ChargeByBookingCustomerGrpVO searchChargeByCustomer(ChargeByBookingCustomerParmVO  chargeByBookingCustomerParmVO) throws EventException;

	
	/**
	 * recover status of  Deleted Charge<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String removeCancelCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
			SignOnUserAccount account) throws EventException;

	
	/**
	 * Search precalculation amount before save and input DR Data of Charge to To Data<br>
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
	 * Modify Container Charge<br>
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
	 * Create Balance Charge data<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs 
	 * @param SignOnUserAccount account 
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createBalanceCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs
											, SignOnUserAccount account) throws EventException;

	
	/**
	 * Search Charge by Container and  Tariff Type<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO searchChargeByContainer(ChargeArgumentVO chargeArgumentVO) throws EventException;

	
	/**
	 * search Charge List by Office or VVD<br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchChargeStatusListByOfficeOrVVD(
			ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException;

	
	/**
	 *  modify ChargeOffice Transfer <br>
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs 
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String modifyChargeByOfficeTransfer(OfficeTransferParmVO[] officeTransferParmVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 *  create Office Transfer .<br>
	 * 
	 * @param OfficeTransferParmVO[] officeTransferParmVOs 
	 * @exception EventException
	 */
	public void createChargeByOfficeTransfer(OfficeTransferParmVO[] officeTransferParmVOs) throws EventException;
	
	
	/**
	 * search History by Charge<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @return List<DmtChgCorrHisVO>
	 * @exception EventException
	 */
	public List<DmtChgCorrHisVO> searchCorrectionHistory(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * search Charge for Partial.<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO 
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchPartialPayment(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * when Charge Delete, search Delete Reason of List Data,
	 * search Delete Reason Code and  Description in common table.<br>
	 * 
	 * @return List<DeleteReasonListVO>
	 * @exception EventException
	 */
	public List<DeleteReasonListVO> searchDeleteReasonList() throws EventException;
	
	
	/**
	 * Delete Charge when the clerk in charge of DEM/DET Billing  settle DEM/DET Charge,
	 * it's not customer' fault or need Manual Invoice. <br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String removeCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * Partial Charge<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createPartialPayment(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 *  Delete all DR Balance Charge except General Charge<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelDRBalanceCharge(ChargeCalculationContainerVO chargeCalculationContainerVO, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * modify Container Charge info.<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO modifyChargeByContainer(ChargeCalculationContainerVO chargeCalculationContainerVO, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * search Balance Count<br>
	 * 
	 * @param ChargeCalculationContainerVO chargeCalculationContainerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBalanceCount(ChargeCalculationContainerVO chargeCalculationContainerVO)
		throws EventException;
	
	
	/**
	 * Search POD ETA date.<br>
	 * 
	 * @param ManualChargeCreationVO[] manualChargeCreationVOs
	 * @return List<ManualChargeCreationVO>
	 * @exception EventException
	 */
	public List<ManualChargeCreationVO> searchPODEta(ManualChargeCreationVO[] manualChargeCreationVOs)
		throws EventException;
	
	
	/**
	 * Search VD Movement Date by Container <br>
	 * 
	 * @param VDMovementVO[] vdMovementVOs
	 * @return List<VDMovementVO>
	 * @exception EventException
	 */
	public List<VDMovementVO> searchVDMovementByPodEta(VDMovementVO[] vdMovementVOs) throws EventException;
	
	
	/**
	 * Manual creation of Charge, not create in Batch <br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createManualCharge(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account)
		throws EventException;
	
	
	/**
	 * Saving CHARGE HISTORY.<br>
	 * 
	 * @param InvoiceIssueMgtVO invoiceIssueMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * search calculate contents of Container Charge that applied Basic and Exception Tariff , Clock Stop<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return ChargeCalculationDetailVO
	 * @exception EventException
	 */
	public ChargeCalculationDetailVO searchChargeDetail(ChargeArgumentVO chargeArgumentVO) throws EventException;

	/**
	 * saving CHARGE HISTORY about Invoice Group.<br>
	 * 
	 * @param List<InvoiceIssueVO> invoiceIssueVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoiceByGroup(List<InvoiceIssueVO> invoiceIssueVOs, SignOnUserAccount account ) throws EventException;
	
	
	/**
	 * search Container Charge List that are created SZPBB Office <br>
	 * 
	 * @param ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO  
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchChargeBySZPBB(ChargeByOfficeOrVVDVO chargeByOfficeOrVVDVO) throws EventException;

	
	/**
	 * search Movement Data that are created SZPBB Office <br>
	 * 
	 * @param MovementSZPBBParmVO[] movementSZPBBParmVOs
	 * @return List<MovementSZPBBVO>
	 * @exception EventException
	 */
	public List<MovementSZPBBVO> searchMovementBySZPBB(MovementSZPBBParmVO[] movementSZPBBParmVOs) throws EventException;
	
	
	/**
	 * create "DMOF', "DMIF" of  Charge that are created SZPBB Office<br>
	 * 
	 * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	 * @param SignOnUserAccount account
	 * @return DmtResultVO
	 * @exception EventException
	 */
	public DmtResultVO createChargeBySZPBB(ChargeCalculationContainerVO[] chargeCalculationContainerVOs,
			SignOnUserAccount account) throws EventException;
	
	
	/**
	 * saving CHARGE HISTORY about Invoice Cancel.<br>
	 * 
	 * @param List<ChargeArgumentVO> chargeArgumentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeChargeStatusForInvoiceByCancel(List<ChargeArgumentVO> chargeArgumentVOs, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * saving CHARGE Trucker info.<br>
	 * 
	 * @param InvoiceIssueMgtVO invoiceIssueMgtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeTruckerForInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account ) throws EventException;
	
	/**
	 * modify Booking Container info.<br>
	 * 
	 * @param DmtChgBkgCntrVO dmtChgBkgCntrVO
	 * @exception EventException
	 */
	public void modifyBookingContainer(DmtChgBkgCntrVO dmtChgBkgCntrVO ) throws EventException;
	
	/**
	 * modify Charge Calculation info.<br>
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @exception EventException
	 */
	public void modifyChargeCalculation(DmtChgCalcVO dmtChgCalcVO ) throws EventException;
	
	/**
	 *  saving  Charge Calculation info.<br>
	 * 
	 * @param DmtChgCalcVO dmtChgCalcVO
	 * @exception EventException
	 */
	public void createCharge(DmtChgCalcVO dmtChgCalcVO ) throws EventException;
	
	/**
	 * when exists appiled Clock Stop Charge, create History .<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @param List<String> cStopNoList
	 * @exception EventException
	 */
	public void modifyClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO, List<String> cStopNoList ) throws EventException;
	
	/**
	 * when exists Clock Stop, delete History<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @exception EventException
	 */
	public void deleteClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO ) throws EventException;
	
	/**
	 * when exists Clock Stop History, create Clock Stop History.<br>
	 * 
	 * @param DmtChgTmCskStopVO dmtChgTmCskStopVO
	 * @exception EventException
	 */
	public void addClockStopHistory(DmtChgTmCskStopVO dmtChgTmCskStopVO) throws EventException;
	
	/**
	 * saving VVD info.<br>
	 * 
	 * @param VVDCheckDataVO vVDCheckDataVO
	 * @throws EventException
	 */
	public void modifyBookingContainerVVD(VVDCheckDataVO vVDCheckDataVO) throws EventException;
	
	/**
	 *Sending to EDI <br>
	 * 
	 * @param List<EDIVO> EDIVOs
	 * @throws EventException
	 */
	public void sendToEDI(List<EDIVO> EDIVOs) throws EventException;
	
	/**
	 * modify infomation about CTOC/CTIC .<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @throws EventException
	 */
	public void modifyOrgChgAmt(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * search Dual Charge Tariff List<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */
	public List<ChargeCalculationContainerVO> searchDualChargeTariff(ChargeArgumentVO chargeArgumentVO) throws EventException;
	
	
	/**
	 * return  Back End Job' status.
	 *
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkBackEndJob(String key) throws EventException;
	
	
	/**
	 * run Back End Job.
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
	  * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	  * @param SignOnUserAccount account 
	  * @return String
	  * @exception EventException
	  */	
	public String requestChargeDeletion(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account) throws EventException;
	
	 /**
	  * Charge를 Delete Reject 처리한다.
	  * 
	  * @param ChargeCalculationContainerVO[] chargeCalculationContainerVOs
	  * @param SignOnUserAccount account 
	  * @exception EventException
	  */
	public void rejectChargeDeletion(ChargeCalculationContainerVO[] chargeCalculationContainerVOs, SignOnUserAccount account ) throws EventException ;
	
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
	 *Charge 정보를 재계산하여 수정한다.(Recalculation)<br>
	 * 
	 * @param bkgNo String
	 * @param cntrNo String
	 * @param ydCd String
	 * @param notificationDt String
	 * @param account SignOnUserAccount
	 * @return DmtResultVO
	 */
	public DmtResultVO modifyChargeByNTdate(String bkgNo, String cntrNo, String ydCd, String notificationDt, SignOnUserAccount account);
	
    /**
     * 화면에서 당일 일배치를 Call
     * @param ChargeArgumentVO chargeArgumentVO
     * @param account
     * @return
     * @throws EventException
     */
    public String createDailyBatchByBooking(ChargeArgumentVO chargeArgumentVO, SignOnUserAccount account) throws EventException;

    /**
     * 일 배치에 대한 대상 건수가 존재하는지 체크한다.
     * @param ChargeArgumentVO chargeArgumentVO
     * @param account
     * @param date
     * @return String
     * @throws EventException
     */
	public String checkDailyMovementCalculationByBooking(ChargeArgumentVO chargeArgumentVO, SignOnUserAccount account, String date) throws EventException;


    /**
     * 일 배치에 대한 대상 건수가 존재하는지 체크한다.
     * @param ChargeArgumentVO chargeArgumentVO
     * @return
     * @throws EventException
     */
	public String checkCalculationByBooking(ChargeArgumentVO chargeArgumentVO) throws EventException;

    /**
     * 일자 조회
     * @return
     * @throws EventException
     */
	public String searchDate() throws EventException;
}
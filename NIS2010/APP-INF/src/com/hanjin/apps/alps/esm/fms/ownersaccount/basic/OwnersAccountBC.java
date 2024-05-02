/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountBC.java
*@FileTitle : Owner's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.02.18 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.fmscommon.fmsfileupload.vo.FileUploadListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.CancelSlipVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.CondOwnrAcctForCnclVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsConsultationVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrCurrVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.SearchOwnrAcctForCnclListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.searchFinancialVVDForOtherOffcVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;


/**
 * Common CSR Business Logic Command Interface<br>
 * - Common CSR에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Son, Jin-Hwan
 * @see 
 * @since J2EE 1.6
 */

public interface OwnersAccountBC {

	/**
	 * [Owner's Account Consultation / Slip]을 [Save] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param FmsCsulSlpVO[] fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @param CustomTaxVO[] customTaxVOs
	 * @param CustomTaxDtlVO[] customTaxDtlVOs
	 * @return String 
	 * @exception EventException
	 */
	public String manageOwnersAccountSlip(FmsConsultationVO fmsConsultationVO, FmsCsulSlpVO[] fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs) throws EventException;

	/**
	 * [Tax 과세 USD인 경우에 Owner's Account Consultation / Slip]을 [Save] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param FmsCsulSlpVO[] fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @param CustomTaxVO[] customTaxVOs
	 * @param CustomTaxDtlVO[] customTaxDtlVOs
	 * @return String 
	 * @exception EventException
	 */
	public String manageOwnersAccountSlipTax(FmsConsultationVO fmsConsultationVO, FmsCsulSlpVO[] fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount, CustomTaxVO[] customTaxVOs, CustomTaxDtlVO[] customTaxDtlVOs) throws EventException;
	
	
	/**
	 * [Owner's Account Consultation / Slip]을 [Delete] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @exception EventException
	 */
	public void removeOwnersAccountSlip(String csrNo) throws EventException;

	/**
	 * [Owner's Account Exchange Consultation / Slip]을 [Save] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @param String usrId
	 * @param String ofcCd
	 * @param String canFlg
	 * @exception EventException
	 */
	public void manageOwnersAccountExchangeSlip(FmsConsultationVO fmsConsultationVO, List<FmsCsulSlpVO> fmsCsulSlpVOs, String usrId, String ofcCd, String canFlg) throws EventException;

	/**
	 * [Owner's Account Consultation / Slip]을 [Cancel전표 생성] 합니다.<br>
	 * 
	 * @param FmsConsultationVO fmsConsultationVO
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return CancelSlipVO
	 * @exception EventException
	 */
	public CancelSlipVO cancelOwnersAccountSlip(FmsConsultationVO fmsConsultationVO, List<FmsCsulSlpVO> fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * [O/A Cancellation Consultation / Slip]을 [Cancel전표 생성] 합니다.<br>
	 * 
	 * @param List<FmsCsulSlpVO> fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return CancelSlipVO
	 * @exception EventException
	 */
	public CancelSlipVO manageOwnersAccountCancellationSlip(List<FmsCsulSlpVO> fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * [Owner's Account Consulation]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String sFlg
	 * @return FmsConsultationVO
	 * @exception EventException
	 */
	public FmsConsultationVO searchOwnersAccountConsultation(String csrNo, String sFlg) throws EventException;
	
	/**
	 * [Owner's Account Slip]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @param String sFlg
	 * @return List<FmsCsulSlpVO>
	 * @exception EventException
	 */
	public List<FmsCsulSlpVO> searchOwnersAccountCsulSlps(String csrNo, String sFlg) throws EventException;
	
	/**
	 * [O/A Cancellation에서 취소를 위해 선택한 전표]을 [조회]합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<FmsCsulSlpVO>
	 * @exception EventException
	 */
	public List<FmsCsulSlpVO> searchOwnersAccountCancellationSlip(String csrNo) throws EventException;
	
	/**
	 * [Approval Type ( GW or ALPS) ]을 [Search] 합니다.<br>
	 * 
	 * @param String orgCur
	 * @param String orgAmt
	 * @return String
	 * @exception EventException
	 */
	public String searchApprovalType(String orgCur, String orgAmt) throws EventException;
	
	/**
	 * [G/L Date ]을 [Search] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchGlDate(String ofcCd) throws EventException;
	
	/**
	 * [G/L Date - Payments Slip]을 [Search] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchGlDate2(String ofcCd) throws EventException;
	
	/**
	 * Owner's Account 목록을 조회한다<br>
	 * 
	 * @param OwnrAcctVO ownrAcctVO
	 * @param String offCd
	 * @return List<OwnrAcctListVO>
	 * @exception EventException
	 */
	public List<OwnrAcctListVO> searchOwnersAccountList(OwnrAcctVO ownrAcctVO, String offCd) throws EventException;	
	
	/**
	 * Office 코드List를 조회한다.
	 * 
	 * @param String offCd
	 * @return List<OwnrAcctVO>
	 * @throws EventException
	 */
	public List<OwnrAcctVO> searchOwnOfficeList(String offCd) throws EventException;	
	
	/**
	 * Currency 코드List를 조회한다.
	 * 
	 * @param String offCd
	 * @return List<OwnrCurrVO>
	 * @throws EventException
	 */
	public List<OwnrCurrVO> searchOwnCurrList(String offCd) throws EventException;
	
 	/**
	 * Invoice No 중복 체크<br>
	 * 
	 * @param String vndrSeq
	 * @param String toInvNo
	 * @param String csrNo
	 * @param String vvd
	 * @return Boolean
	 * @exception EventException
	 */
	public Boolean checkInvNo(String vndrSeq, String toInvNo, String csrNo, String vvd) throws EventException;
	
 	/**
	 * Local Currency 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalCurrency(String ofcCd) throws EventException;
	
	/**
	 * Owner's Account For Cancellation 정보를 조회한다<br>
	 * [ESM_FMS_0101] O/A Inquiry for Cancellation
	 * 
	 * @param CondOwnrAcctForCnclVO condOwnrAcctForCnclVO
	 * @return List<SearchOwnrAcctForCnclListVO>
	 * @exception EventException
	 */
	public List<SearchOwnrAcctForCnclListVO> searchOwnrsAccntForCnclList(CondOwnrAcctForCnclVO condOwnrAcctForCnclVO) throws EventException;
	
	/**
	 * [Owner's Account Exchange Consultation / Slip의 File]을 [Save] 합니다.<br>
	 * 
	 * @param String csrNo	  
	 * @param FmsCsulSlpVO[] fmsCsulSlpVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageFileSav(String csrNo, FmsCsulSlpVO[] fmsCsulSlpVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * [Owner's Account Exchange Consultation / Slip의 File]을 [Save] 합니다.<br>
	 * 
	 * @param String csrNo	  
	 * @param String newCsrNo
	 * @param int seqNo
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageCancelFileSav(String csrNo, String newCsrNo, int seqNo, SignOnUserAccount signOnUserAccount) throws EventException;
	
 	/**
	 * CSR_NO에 해당하는 첨부파일을 GW폴더로 복사한다.<br>
	 * 
	 * @param String ofcCd
	 * @exception EventException
	 */
	public void sendOwnersAccountAtchFile(String ofcCd) throws EventException;
	
	/**
	 * ESM_FSM_B002 CsulSlpOAIf로 부터 호출되며,<br>
	 * ERP I/F를 수행
	 * 
	 * @param ArrayList<FmsConsultationVO> arrayCsulVo
	 * @exception EventException
	 */
	public void altSlpERPIf(ArrayList<FmsConsultationVO> arrayCsulVo) throws EventException;
	
	/**
	 * ESM_FSM_B002 CsulSlpOAIf로 부터 호출되며,<br>
	 * 원전표 : 대상 목록을 FMS_OWNR_ACCT_SLP insert(Pair 포함), FMS_OWNR_ACCT_SLP Update(pair 포함)
	 * 
	 * @param ArrayList<FmsCsulSlpVO> arrayCsulSlpVo
	 * @exception EventException
	 */
	public void oriSlpManage(ArrayList<FmsCsulSlpVO> arrayCsulSlpVo) throws EventException;
	
	/**
	 * ESM_FMS_0095 : [COMMAND02]<br>
	 * [운항팀(PUSMOV)을 제외한 Office의 재무항차와 ETD를 [조회]합니다.<br>
	 *
	 * @param String vvdCd
	 * @param String OaLocCd
	 * @return searchFinancialVVDForOtherOffcVO
	 * @exception EventException 
	 */
	public searchFinancialVVDForOtherOffcVO searchFinancialVVDForOtherOffc(String vvdCd, String OaLocCd) throws EventException;
	
	/**
	 * [Custom Tax]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<CustomTaxVO>
	 * @exception EventException
	 */
	public List<CustomTaxVO> searchCustomTax(String csrNo) throws EventException;
	
	/**
	 * [Custom Tax Detal]을 [Select] 합니다.<br>
	 * 
	 * @param String csrNo
	 * @return List<CustomTaxDtlVO>
	 * @exception EventException
	 */
	public List<CustomTaxDtlVO> searchCustomTaxDtl(String csrNo) throws EventException;	
	
 	/**
	 * 국가 코드 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCountryCodeByOfcCd(String ofcCd) throws EventException;
	
	/**
	 * AR_INV_HDR 의  RQST_APRO_STEP_FLG 업데이트
	 * 
	 * @param csr_no String
	 * @exception EventException
	 */
	public void updateApInvHdr(String csr_no) throws EventException;				
}

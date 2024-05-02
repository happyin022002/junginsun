/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ClaimMainBC.java
 *@FileTitle : Container Cargo Claim 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
-----------------------------------------------------------
 * History 
 * 2011.02.16 이준범 CRM Call 삭제
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.BlGetVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.BookingNoVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ClaimMainCntVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ClaimMainVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniAreaOfcVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmBlDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCntrDtlVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCostVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCtrtVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ContractCarriageVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.FindCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.FindVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.HandlingCostInfoVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.HandlingCostVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ImpendingTBIndemnityClaimVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.ImpendingTBMainClaimVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.PaymentVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.TransferCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.TransferVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.ApplicationStatusVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * Container Cargo Claim Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface ClaimMainBC {
    
	
    // ===========================================================================
    // 진윤오
    // ===========================================================================
	// ---------------------------------------------------------------------------
	// [COM005_R001] GW 웹서비스 승인정보 수신
	// ---------------------------------------------------------------------------	
	
	/**
	 * GW 웹서비스 승인정보 수신시 카고클레임 정보 취득<br>
	 * @author 진윤오
	 * @category COM005_R001
	 * @category searchCargoClaim 
	 * @param String cgoClmNo
	 * @return CniCgoClmVO
	 * @exception EventException
	 */
	public CniCgoClmVO searchCargoClaim(String cgoClmNo) throws EventException;	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0001] Client Default Setup
	// ---------------------------------------------------------------------------	    
	/** 
	 * Area Cd 정보 수정,등록<br>
	 * @author 진윤오
	 * @category CPS_CNI_0001
	 * @category manageAreaOfc 
	 * @param CniAreaOfcVO cniAreaOfcVO
	 * @exception EventException
	 */
	public void manageAreaOfc(CniAreaOfcVO cniAreaOfcVO) throws EventException;
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0043] Impending TB Claim
	// ---------------------------------------------------------------------------	
	/**
	 * Impending TB Main Claim  조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0043
	 * @category searchImpendingTBMainClaimList 
	 * @param String usrId 로그인 사용자
	 * @param String condFor 검색 조건 1,2,3,4
     * @return List<ImpendingTBMainClaimVO>
     * @throws EventException
     */
    public List<ImpendingTBMainClaimVO> searchImpendingTBMainClaimList(String usrId , String condFor) throws EventException;
    
	/**
	 * Impending TB Main Claim  조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0043
	 * @category searchImpendingTBIndemnityClaimList 
	 * @param String usrId 로그인 사용자
	 * @param String condFor 검색 조건 1,2,3,4
     * @return List<ImpendingTBIndemnityClaimVO>
     * @throws EventException
     */
    public List<ImpendingTBIndemnityClaimVO> searchImpendingTBIndemnityClaimList(String usrId , String condFor) throws EventException;
	
    // ===========================================================================
    // 양정란
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0002] Find
	// ---------------------------------------------------------------------------
	
	/**
	 * Find 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0002
	 * @category searchFindList 
	 * @param FindCondVO findCondVO
     * @return List<FindVO> 
     * @throws EventException
     */
	public List<FindVO> searchFindList(FindCondVO findCondVO) throws EventException;
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0008] Payment
	// ---------------------------------------------------------------------------
	
	/**
	 * Payment 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0008
	 * @category searchPaymentInfo 
	 * @param String cgoClmNo
     * @return List<PaymentVO> 
     * @throws EventException
     */
	public List<PaymentVO> searchPaymentInfo(String cgoClmNo) throws EventException;
	
	/** 
	 * Payment 정보 수정,등록<br>
	 * @author 양정란
	 * @category CPS_CNI_0008
	 * @category managePayment 
	 * @param PaymentVO paymentVO
	 * @exception EventException
	 */
	public void managePayment(PaymentVO paymentVO) throws EventException;	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0036] Transfer
	// ---------------------------------------------------------------------------
	/**
	 * Transfer 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchTransferList 
	 * @param TransferCondVO transferCondVO
     * @return List<TransferVO> 
     * @throws EventException
     */
	public List<TransferVO> searchTransferList(TransferCondVO transferCondVO) throws EventException;
	
	/**
	 * Transfer 멀티 이벤트 처리<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category manageTransfer
	 * @param TransferVO[] transferVO
	 * @exception EventException  
	 */
	public void manageTransfer(TransferVO[] transferVO) throws EventException;	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0009] Handling Costs
	// ---------------------------------------------------------------------------
	/**
	 * Handling Costs 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category searchHandlingCostList 
	 * @param String cgoClmNo
     * @return List<HandlingCostVO> 
     * @throws EventException
     */
	public List<HandlingCostVO> searchHandlingCostList(String cgoClmNo) throws EventException;	
	
	/**
	 * Handling Costs 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category searchHandlingCostInfo 
	 * @param String cgoClmNo
     * @return HandlingCostInfoVO
     * @throws EventException
     */
	public HandlingCostInfoVO searchHandlingCostInfo(String cgoClmNo) throws EventException;		
	
	/**
	 * Handling Costs 멀티 이벤트 처리<br>
	 * @author 양정란
	 * @category CPS_CNI_0009
	 * @category manageHandlingCost
	 * @param CniCgoClmCostVO[] cniCgoClmCostVO
	 * @return String
	 * @exception EventException
	 */
	public String manageHandlingCost(CniCgoClmCostVO[] cniCgoClmCostVO) throws EventException;
	
	/**
	 * Handling Costs 멀티 이벤트 처리<br>
	 * @author 양정란
	 * @category CPS_CNI_0045
	 * @category manageHandlingCostInvRgstNo
	 * @param CniCgoClmCostVO cniCgoClmCostVO
	 * @exception EventException
	 */
	public void manageHandlingCostInvRgstNo(CniCgoClmCostVO cniCgoClmCostVO) throws EventException;
	
		
	// ===========================================================================
    // 정행룡
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0003] Claim Main
	// ---------------------------------------------------------------------------
	/** 
	 * Claim Main 정보 수정,등록<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category manageClaimMain 
	 * @param ClaimMainCntVO claimMainCntVO
	 * @return ClaimMainCntVO
	 * @exception EventException
	 */
	public ClaimMainCntVO manageClaimMain(ClaimMainCntVO claimMainCntVO) throws EventException;
	
	/** 
	 * Claim Status 변경(Cancel)<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimStatus 
	 * @param CniCgoClmVO cniCgoClmVO
	 * @exception EventException
	 */
	public void modifyClaimStatus(CniCgoClmVO cniCgoClmVO) throws EventException;
    
	/** 
	 * Claim ReOpen 변경(ReOpen 처리)<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyClaimReOpen 
	 * @param String cgoClmNo
	 * @param String updUsrId 
	 * @param String cgoClmStlTpCd
	 * @exception EventException
	 */
	public void modifyClaimReOpen(String cgoClmNo , String updUsrId , String cgoClmStlTpCd) throws EventException;
	
	/** 
	 * Claim Status 이전 단계 변경<br>
	 * @author 진윤오
	 * @category CPS_CNI_0003
	 * @category modifyClaimPreStatus
	 * @param String cgoClmNo
	 * @param String updUsrId 
	 * @exception EventException
	 */
	public void modifyClaimPreStatus(String cgoClmNo , String updUsrId) throws EventException; 	
	
	/**
	 * Claim Status 취득<br>
	 * @author 진윤오
	 * @category CPS_CNI_0003
	 * @category searchClaimStatus
	 * @param String cgoClmNo 
	 * @return String status code
     * @throws EventException
     */
   public String searchClaimStatus(String cgoClmNo) throws EventException;	
	
	/**
	 * Claim 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchClaimMain 
	 * @param cgoClmNo Cargo Claim No
     * @return Claim 정보 
     * @throws EventException
     */
	public ClaimMainVO searchClaimMain(String cgoClmNo) throws EventException;

	/**
	 * Area Cd 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchAreaCd
	 * @param ofcCd Office Cd
     * @return Area Cd 정보 
     * @throws EventException
     */
	public CniAreaOfcVO searchAreaCd(String ofcCd) throws EventException;
	/**
	 * B/L 정보 체크<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBlGetChk
	 * @param String cgoClmRefBlNo
     * @return String
     * @throws EventException
     */
	public String searchBlGetChk(String cgoClmRefBlNo) throws EventException;
	
	/**
	 * B/L 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchBlGet
	 * @param String cgoClmRefBlNo
     * @return BlGetVO
     * @throws EventException
     */
	public BlGetVO searchBlGet(String cgoClmRefBlNo) throws EventException ;
    
    // ===========================================================================
    // 박제성
    // ===========================================================================

	/**
	 * ContractCarriage 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageInfo
	 * @return ContractCarriageVO
	 * @param String cgoClmNo
	 * @exception EventException
	 */
	
	public ContractCarriageVO searchContractCarriageInfo(String cgoClmNo) throws EventException;
	
	/**
	 * ContractCarriage BL Get <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchContractCarriageBLGet
	 * @return ContractCarriageVO
	 * @param String cgoClmNo
	 * @param String blNo
	 * @param String bkgNo
	 * @exception EventException
	 */
	
	public ContractCarriageVO searchContractCarriageBLGet(String cgoClmNo,String blNo,String bkgNo) throws EventException;	
	
	
	/**
	 * ClaimBlDetailList 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchClaimBlDetailList
	 * @return List<CniCgoClmBlDtlVO>  
	 * @param String cgoClmNo
	 * @exception EventException
	 */
	
	public List<CniCgoClmBlDtlVO> searchClaimBlDetailList(String cgoClmNo) throws EventException;	
	
	
	/**
	 * ClaimContractDetailList 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchClaimContractDetailList
	 * @return List<CniCgoClmCntrDtlVO>  
	 * @param String cgoClmNo
	 * @param String cgoClmRefBlNo
	 * @exception EventException
	 */
	
	public List<CniCgoClmCntrDtlVO> searchClaimContractDetailList(String cgoClmNo, String cgoClmRefBlNo) throws EventException;	
	
	/**
	 * ClaimContractDetailList 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchClaimContractBLGetDetailList
	 * @return List<CniCgoClmCntrDtlVO>  
	 * @param String cgoClmNo
	 * @param String blNo
	 * @param String bkgNo
	 * @exception EventException
	 */
	
	public List<CniCgoClmCntrDtlVO> searchClaimContractBLGetDetailList(String cgoClmNo,String blNo,String bkgNo) throws EventException;	
	
	/**
	 * ContractCarriage 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category manageContractCarriage
	 * @return String 
	 * @param CniCgoClmCtrtVO cniCgoClmCtrtVO 
	 * @param CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs
	 * @param CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public String manageContractCarriage(CniCgoClmCtrtVO cniCgoClmCtrtVO, CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs, CniCgoClmCntrDtlVO[] cniCgoClmCntrDtlVOs, SignOnUserAccount account) throws EventException;		

	
	/**
	 * ContractCarriage 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category manageContractCarriageBL
	 * @return String 
	 * @param String cgoClmNo
	 * @param CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs	
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public String manageContractCarriageBL(String cgoClmNo, CniCgoClmBlDtlVO[] cniCgoClmBlDtlVOs, SignOnUserAccount account) throws EventException;		

	
	/**
	 * Booking No 공통 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0010
	 * @category searchBookingNoInfo
	 * @return BookingNoVO
	 * @param String blNo
	 * @exception EventException
	 */
	
	public BookingNoVO searchBookingNoInfo(String blNo) throws EventException;	
	
	/** 
	 * Application 변경(Cancel 처리)<br>
	 * @author 이준범
	 * @category CPS_CNI_0014
	 * @category modifyApplication 
	 * @param ApplicationStatusVO applicationStatusVO
	 * @exception EventException
	 */
	public void modifyApplication(ApplicationStatusVO applicationStatusVO) throws EventException ;
	
	/** 
	 * Claim Status 변경(Cancel 처리)<br>
	 * @author 정행룡
	 * @category CPS_CNI_0014
	 * @category modifyClaimStatus 
	 * @param CniCgoClmVO cniCgoClmVO
	 * @exception EventException
	 */
	public void modifyAppliedStatus(CniCgoClmVO cniCgoClmVO) throws EventException ;

}
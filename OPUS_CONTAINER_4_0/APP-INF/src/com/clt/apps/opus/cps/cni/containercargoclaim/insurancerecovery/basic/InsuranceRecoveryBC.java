/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : InsuranceRecoveryBC.java
 *@FileTitle : InsuranceRecoveryBC 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.30 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.CniCgoClmInsurVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.EntryStatusVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByCaseVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo.InsuranceRecoveryByVvdVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * CNI Code Business Logic Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface InsuranceRecoveryBC {
	
	
	// 진윤오  ===========================================================================	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0016] Insurance Recovery by VVD 
	// ---------------------------------------------------------------------------
	
	/**
	 * VVD 정보 및 보험관련 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category searchEntryStatusInfo 
	 * @param String vslCd
	 * @param String insurClmPtyNo
	 * @param String insurPlcyYr
     * @return EntryStatusVO
     * @throws EventException
     */
    public EntryStatusVO searchEntryStatusInfo(String vslCd , String insurClmPtyNo , String insurPlcyYr) throws EventException;	
	
	/**
	 * VVD InsuranceRecovery정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category searchInsuranceRecoveryByVvdList 
	 * @param String trnkRefVvdNo
     * @return List<InsuranceRecoveryByVvdVO>
     * @throws EventException
     */
    public List<InsuranceRecoveryByVvdVO> searchInsuranceRecoveryByVvdList(String trnkRefVvdNo) throws EventException; 
    
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0017] Insurance Recovery by Case 
	// ---------------------------------------------------------------------------
    
	/**
	 * Case InsuranceRecovery정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category searchInsuranceRecoveryByCaseInfo 
	 * @param String cgoClmNo
     * @return InsuranceRecoveryByCaseVO
     * @throws EventException
     */
    public InsuranceRecoveryByCaseVO searchInsuranceRecoveryByCaseInfo(String cgoClmNo) throws EventException;    
    
	/**
	 * Case InsuranceRecovery 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category manageInsuranceRecoveryByCase
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO 
	 * @exception EventException
	 */
	public void  manageInsuranceRecoveryByCase(CniCgoClmInsurVO cniCgoClmInsurVO) throws EventException;
	
	/**    
	 * Case InsuranceRecovery Recovery Cancel <br>
	 * INS Claimed Amount, INS DOF, R.O.E, USD 삭제
	 * @author 진윤오
	 * @category CPS_CNI_0017
	 * @category manageInsuranceRecoveryCancel 
	 * @param String cgoClmNo
	 * @param String updUsrId    
	 * @exception EventException
	 */
	public void  manageInsuranceRecoveryCancel(String cgoClmNo , String updUsrId) throws EventException;	
	
    // ===========================================================================
    // 정행룡
    // ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0003] Claim Main
	// ---------------------------------------------------------------------------
	
	/**
	 * Claim Main Insurance 멀티 이벤트 처리<br>
	 * 
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category manageClaimMainInsurance
	 * @param CniCgoClmInsurVO cniCgoClmInsurVO
	 * @exception EventException
	 */
	public void manageClaimMainInsurance(CniCgoClmInsurVO cniCgoClmInsurVO) throws EventException;
	
	/**
	 * VVD InsuranceRecovery 등록 , 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0016
	 * @category manageInsuranceRecoveryByVvd
	 * @param CniCgoClmInsurVO[] cniCgoClmInsurVOs	 * 
	 * @exception EventException
	 */
	public void  manageInsuranceRecoveryByVvd(CniCgoClmInsurVO[] cniCgoClmInsurVOs) throws EventException;
	
}
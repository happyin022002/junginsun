/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SettlementClaimBC.java
 *@FileTitle : SettlementClaimBC 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.22 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.CniSettlementVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.GwApproveStatusVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.settlementclaim.vo.SettlementVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * CNI Code Business Logic Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface SettlementClaimBC {
	
    // ===========================================================================
    // 박제성
    // ===========================================================================

	/**
	 * Settlement 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category searchSettlementInfo
	 * @return List<LiablePartyVO>  
	 * @param String cgoClmNo
	 * @exception EventException
	 */
	
	public List<SettlementVO> searchSettlementInfo(String cgoClmNo) throws EventException;	
	
	/**
	 * Settlement 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category manageSettlement
	 * @return String 
	 * @param CniSettlementVO cniSettlementVO
	 * @exception EventException
	 */
	public String  manageSettlement(CniSettlementVO cniSettlementVO) throws EventException;		

	/**
	 * Settlement 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0014
	 * @category modifyClaimCancel	
	 * @param CniSettlementVO cniSettlementVO
	 * @exception EventException
	 */
	public void  modifyClaimCancel(CniSettlementVO cniSettlementVO) throws EventException;		

	/** 
	 * Reopen시 Settlement 값 변경<br>
	 * @author 정행룡
	 * @category CPS_CNI_0037
	 * @category modifyReOpenSettlement
	 * @param String cgoClmNo
	 * @param String updUsrId 
	 * @exception EventException
	 */
	public void modifyReOpenSettlement(String cgoClmNo , String updUsrId) throws EventException;
	
}
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndemnityClaimBC.java
 *@FileTitle : IndemnityClaimBC 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.22 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.vo.CniLiablePartyVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.indemnityclaim.vo.LiablePartyVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * CNI Code Business Logic Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface IndemnityClaimBC {
	
    // ===========================================================================
    // 박제성
    // ===========================================================================

	/**
	 * LiableParty 조회 <br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category searchLiablePartyInfo
	 * @return List<LiablePartyVO>  
	 * @param String cgoClmNo
	 * @exception EventException
	 */
	
	public List<LiablePartyVO> searchLiablePartyInfo(String cgoClmNo) throws EventException;	
	
	/**
	 * LiableParty 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0015
	 * @category manageLiableParty
	 * @return String 
	 * @param CniLiablePartyVO cniLiablePartyVO
	 * @exception EventException
	 */
	public String manageLiableParty(CniLiablePartyVO cniLiablePartyVO) throws EventException;		



}
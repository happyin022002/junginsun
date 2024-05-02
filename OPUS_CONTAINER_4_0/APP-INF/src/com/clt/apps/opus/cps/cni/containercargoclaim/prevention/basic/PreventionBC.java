/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PreventionBC.java
 *@FileTitle : PreventionBC 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.22 진윤오 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.prevention.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.CniClmPrveVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.PreventionCondVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.PreventionInfoVO;
import com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo.PreventionVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * CNI Code Business Logic Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface PreventionBC {
	
    // ===========================================================================
    // 진윤오
    // ===========================================================================

	/**
	 * Prevention 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0022
	 * @category searchPreventionList 
	 * @param PreventionCondVO condVo
     * @return List<PreventionVO>
     * @throws EventException
     */	
	public List<PreventionVO> searchPreventionList(PreventionCondVO condVo) throws EventException;	
	
    // ---------------------------------------------------------------------------
    // [CPS_CNI_0023] Prevention-Register
    // ---------------------------------------------------------------------------
	
	/**
	 * Prv No 별 Prevention 정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category searchPreventionInfo 
	 * @param String clmPrveNo
     * @return PreventionInfoVO
     * @throws EventException
     */	
	public PreventionInfoVO searchPreventionInfo(String clmPrveNo) throws EventException;
	
	/**
	 * Prv No 최대값 취득<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category searchMaxClmPrevNo
     * @return String Max claim prevention no
     * @throws EventException
     */	
	public String searchMaxClmPrevNo() throws EventException; 	
	
	/**
	 * Prevention 추가<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category createPrevention 
	 * @param CniClmPrveVO cniClmPrveVO
     * @throws EventException
     */	
	public void createPrevention(CniClmPrveVO cniClmPrveVO) throws EventException;
	
	/**
	 * Prevention 수정<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category modifyPrevention 
	 * @param CniClmPrveVO cniClmPrveVO
     * @throws EventException
     */	
	public void modifyPrevention(CniClmPrveVO cniClmPrveVO) throws EventException;
	
	/**
	 * Prevention 추가<br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category removePrevention 
	 * @param String clmPrveNo
     * @throws EventException
     */	
	public void removePrevention(String clmPrveNo) throws EventException;	

	
	/**
	 * Prevention View + 1 수정 <br>
	 * @author 진윤오
	 * @category CPS_CNI_0023
	 * @category modifyPreventionViewCnt 
	 * @param String clmPrveNo
     * @throws EventException
     */	
	public void modifyPreventionViewCnt(String clmPrveNo) throws EventException;
	
}
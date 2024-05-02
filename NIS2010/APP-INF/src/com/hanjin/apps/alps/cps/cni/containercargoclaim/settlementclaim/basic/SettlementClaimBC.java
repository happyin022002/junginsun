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
package com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.basic;

import java.util.List;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.CniSettlementVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.GwApproveStatusVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.SettlementVO;
import com.hanjin.framework.core.layer.event.EventException;

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
	 * Settlement GW 정보 eai 전송<br>
	 * 
	 * @author 진윤오
	 * @category CNI_COM00050001
	 * @category searchGwCargoInfo
	 * @param String cgoClmNo
	 * @param String usrId
	 * @return String gwURL 
	 * @exception EventException
	 */
	public String sendGwCargoClaimInfo(String cgoClmNo , String usrId) throws EventException;
	
	/**
	 * Settlement GW Litigation 정보 eai 전송<br>
	 * 
	 * @author 진윤오
	 * @category CNI_COM00050001
	 * @category searchGwCargoInfo
	 * @param String cgoClmNo
	 * @param String usrId
	 * @return String gwURL 
	 * @exception EventException
	 */
	public String sendGwCargoLitigationInfo(String cgoClmNo , String usrId) throws EventException;	
	
	/**
	 *  Gw Status 정보 수정 EAI에서 수신<br>
	 * 
	 * @author 진윤오
	 * @category COM005R001
	 * @category manageGwStatus
	 * @param GwApproveStatusVO vo
	 * @exception EventException
	 */
	public void  manageGwStatus(GwApproveStatusVO vo) throws EventException ;
	
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
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SpaceAllocationManageBC.java
*@FileTitle      : SpaceAllocationManage
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.07.29
*@LastModifier   : 최윤성
*@LastVersion    : 1.0
* 2009.07.29
* 1.0 Creation
=========================================================
*/
package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpcAlocCtrlOptVO;
import com.clt.syscommon.common.table.SpcAlocPolPodVO;
import com.clt.syscommon.common.table.SpcFcastDwnLodSkdVO;
import com.clt.syscommon.common.table.SpcNshwRsltVO;

/**
 * Spaceallocationmanage Business Logic Command Interface<br>
 * - Spaceallocationmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI Yun Sung
 * @see Esm_spc_0042EventResponse 참조
 * @since J2EE 1.6
 */

public interface SpaceAllocationManageBC {

	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationDetailList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocationMasterList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCtrlOptVO[] spcAlocCtrlOptVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiControlOption(SpcAlocCtrlOptVO[] spcAlocCtrlOptVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0071]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SearchVesselSKDListVO> searchVesselSKDList(ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0044MasterList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0044DetailList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0044Manage(
			SpcAlocPolPodVO[] spcAlocPolPodVOS, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0045]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045VVDList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0045]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045QtyList(
			ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0047MasterList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0047DetailList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0047Manage(
			SpcAlocPolPodVO[] spcAlocPolPodVOS, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0053]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0053ManageListVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocationManageList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRemarkFlagOffice(String ofcCd) throws EventException;
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchNoShowAdjustmentList(
			ConditionVO conditionVO) throws EventException;


	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchNoShowDownloadDateList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SpcNshwRsltVO[] SpcNshwRsltVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNoShowAdjustment(
			SpcNshwRsltVO[] SpcNshwRsltVOS, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiForcastDownloadDate(
			SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVOS, SignOnUserAccount account) throws EventException;

	
}
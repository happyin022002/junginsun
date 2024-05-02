/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
*
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1009ConditionVO;

import com.clt.syscommon.common.table.EqrCtrlGlineHdrVO;
import com.clt.syscommon.common.table.EqrCtrlLodgGlineVO;
import com.clt.syscommon.common.table.EqrCtrlDchgGlineVO;
import com.clt.syscommon.common.table.EqrCtrlDchgGlineValVO;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS- Mty Repo Guideline Management Business Logic Command Interface<br>
 * - OPUS- Mty Repo Guideline Management 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1018EventResponse 참조
 * @since J2EE 1.6
 */
public interface CntrPlanGuidelineManageBC {

	/**
	 * [ EES_EQR_1008 : Mty Repo Guideline Info ]<br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchGuidelineConfig(EesEqr1008ConditionVO condVO) throws EventException;
	
	
	/**
	 * [ EES_EQR_1009 : Mty Repo Guideline Info ]<br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchAddGuidelineConfig(EesEqr1009ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_1009 : Guideline Add시 VVD 조회 ]<br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchAddGlineVvd(EesEqr1009ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_1009 : Guideline Add시 POL CD변경시 ETA DT 조회 ]<br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchAddGlineEtaDt(EesEqr1009ConditionVO conditionVO) throws EventException;
	
	
	/**
	 * [ EES_EQR_1009 : Mty Repo Guideline POL Search ]<br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchPolCdList(EesEqr1009ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_1008 : Mty Repo Guideline Management Search]<br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchGuidelineList(EesEqr1008ConditionVO condVO) throws EventException;

	/**
	 * [ EES_EQR_1008 : Mty Repo Guideline Management Save ]<br>
	 * @param eqrCtrlGlineHdrVOs
	 * @param eqrCtrlLodgGlineVOs
	 * @param eqrCtrlDchgGlineVOs
	 * @param eqrCtrlDchgGlineValVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiGuidelineList(List<EqrCtrlGlineHdrVO> eqrCtrlGlineHdrVOs, List<EqrCtrlLodgGlineVO> eqrCtrlLodgGlineVOs, List<EqrCtrlDchgGlineVO> eqrCtrlDchgGlineVOs, List<EqrCtrlDchgGlineValVO> eqrCtrlDchgGlineValVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ EES_EQR_1009 : Mty Repo Guideline Add/Amend ]<br>
	 * @param EesEqr1009ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchAddGuidelineList(EesEqr1009ConditionVO condVO) throws EventException;
	
	
	/**
	 * [ EES_EQR_1008 : Mty Repo Guideline Management Search]<br>
	 * @param EesEqr1009ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchAmendPortion(EesEqr1009ConditionVO condVO) throws EventException;
	
	
	/**
	 * [ EES_EQR_1009 : Lane의 유요한 VVD 체크 ]<br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckVvdCd(EesEqr1009ConditionVO conditionVO) throws EventException;
	
	
	/**
	 * [ EES_EQR_1009 : Lane의 유요한 VVD 체크 ]<br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchVvdCd(EesEqr1009ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_1008 :입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크]<br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String checkSubLocCd(EesEqr1008ConditionVO condVO) throws EventException;
	 
	 
	/**
	 * [ EES_EQR_1008 :Guideline 최종 차수 체크] <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String checkMaxEqGlineSeq(EesEqr1008ConditionVO condVO) throws EventException;
	 
	/**
	 * [ EES_EQR_1008 : 유효한 POL 체크] <br>
	 * @param EesEqr1008ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String checkPodCd(EesEqr1008ConditionVO condVO) throws EventException;
	 
	/**
	 * [ EES_EQR_1009 : Guideline 유무 체크] <br>
	 * @param EesEqr1009ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String checkGline(EesEqr1009ConditionVO conditionVO) throws EventException; 
		
	
}
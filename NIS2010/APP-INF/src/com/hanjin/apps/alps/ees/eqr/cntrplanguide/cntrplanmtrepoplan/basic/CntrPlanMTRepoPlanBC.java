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
 
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.basic;


import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013PlnRsnVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS- Mty Repo Guideline Management Business Logic Command Interface<br>
 * - ALPS- Mty Repo Guideline Management 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1018EventResponse 참조
 * @since J2EE 1.6
 */

public interface CntrPlanMTRepoPlanBC {

	final static int MTY_REPO_PLN_DEF_VAL_LENGTH = 9;
	
	/**
	 * 화면 로딩시 기본 설정 데이터
	 * @param condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchLoadingTrendByLaneDefault(EesEqr1013ConditionVO condVO) throws EventException;

	/**
	 * VVD Combo 대상 조회
	 * @param condVO
	 * @return String
	 * @throws EventException
	 */
	public String searchVvdResult(EesEqr1013ConditionVO condVO) throws EventException;

	/**
	 * PlnRsnHdr 조회
	 * @return String
	 * @throws EventException
	 */
	public String searchPlnRsnHdrList() throws EventException;
	
	/**
	 * PlnRsnHdr 조회
	 * @param condVO
	 * @return String
	 * @throws EventException
	 */
	public String searchPlnRsnSubList(EesEqr1013ConditionVO condVO) throws EventException;
	
	/**
	 * Mt Repo Plan data 조회
	 * @param condVO
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchMtyRepoPlanList(EesEqr1013ConditionVO condVO) throws EventException;
	
	/**
	 * Mt Repo Reference data 조회
	 * @param condVO
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchMtyRepoRefList(EesEqr1013ConditionVO condVO) throws EventException;
	
	/**
	 * Mt Repo Plan data 저장
	 * @param e
	 * @throws EventException
	 */
	public void manageMtRepoPlanInfo(Event e) throws EventException;
}
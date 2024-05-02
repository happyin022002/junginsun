/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireBalanceBC.java
*@FileTitle : On-Hire Status
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.05
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.08.05 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.OnhireStatusVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Cntrfcstsimul Business Logic Command Interface<br>
 * - ALPS-Cntrfcstsimul에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dong-sun Moon
 * @see
 * @since J2EE 1.6
 */
public interface OnhireBalanceBC {

	/**
	 * On hire Status 데이터를 조회 합니다.<br>
	 * 
	 * @param OnhireStatusVO onhireStatusVO
	 * @return List<OnhireStatusVO>
	 * @exception EventException
	 */
	public List<OnhireStatusVO> searchOnhireStatusBasic(OnhireStatusVO onhireStatusVO) throws EventException;
	
	/**
	 * On hire Status 데이터를 Insert/Update/Delete 합니다.<br>
	 * 
	 * @param OnhireStatusVO[] onhireStatusVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageOnhireStatusBasic(OnhireStatusVO[] onhireStatusVOs,SignOnUserAccount account) throws EventException;

	/**
	 * RCC, LCC 콤보 조회 <br>
	 * 
	 * @param String loc_grp_cd
	 * @param String loc_cd
	 * @return CommonRsVO
	 * @exception EventException
	 */	
	public CommonRsVO searchRccLccCd(String loc_grp_cd, String loc_cd) throws EventException;
	
	/**
	 * LT ST OW Plan and Approval 을 조회 합니다.<br>
	 * 
	 * @param PlanAndApprovalConditionVO planAndApprovalConditionVO
	 * @return List<PlanAndApprovalVO>
	 * @exception EventException
	 */
	public List<PlanAndApprovalVO> searchPlanAndApprovalBasic(PlanAndApprovalConditionVO planAndApprovalConditionVO) throws EventException;
	
	/**
	 * LT ST OW Plan and Approval 을 Insert/Update/Delete 합니다.<br>
	 * 
	 * @param PlanAndApprovalVO[] planAndApprovalVOs
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePlanAndApprovalBasic(PlanAndApprovalVO[] planAndApprovalVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * LT ST OW Plan and Approval 을 Request/Request Cancel 합니다.<br>
	 * 
	 * @param PlanAndApprovalVO[] planAndApprovalVOs
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePlanAndApprovalRequestBasic(PlanAndApprovalVO[] planAndApprovalVOs, SignOnUserAccount account) throws EventException;
	
}
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OnhireBalanceBC.java
*@FileTitle : On-Hire Status
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.OnhireStatusVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Cntrfcstsimul Business Logic Command Interface<br>
 *
 * @author 
 * @see
 * @since J2EE 1.6
 */
public interface OnhireBalanceBC {

	/**
	 * On hire Status <br>
	 * 
	 * @param OnhireStatusVO onhireStatusVO
	 * @return List<OnhireStatusVO>
	 * @exception EventException
	 */
	public List<OnhireStatusVO> searchOnhireStatusBasic(OnhireStatusVO onhireStatusVO) throws EventException;
	
	/**
	 * On hire Status - Insert/Update/Delete <br>
	 * 
	 * @param OnhireStatusVO[] onhireStatusVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageOnhireStatusBasic(OnhireStatusVO[] onhireStatusVOs,SignOnUserAccount account) throws EventException;

	/**
	 * RCC, LCC <br>
	 * 
	 * @param String loc_grp_cd
	 * @param String loc_cd
	 * @return CommonRsVO
	 * @exception EventException
	 */	
	public CommonRsVO searchRccLccCd(String loc_grp_cd, String loc_cd) throws EventException;
	
	/**
	 * LT ST OW Plan and Approval <br>
	 * 
	 * @param PlanAndApprovalConditionVO planAndApprovalConditionVO
	 * @return List<PlanAndApprovalVO>
	 * @exception EventException
	 */
	public List<PlanAndApprovalVO> searchPlanAndApprovalBasic(PlanAndApprovalConditionVO planAndApprovalConditionVO) throws EventException;
	
	/**
	 * LT ST OW Plan and Approval - Insert/Update/Delete<br>
	 * 
	 * @param PlanAndApprovalVO[] planAndApprovalVOs
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePlanAndApprovalBasic(PlanAndApprovalVO[] planAndApprovalVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * LT ST OW Plan and Approval - Request/Request Cancel <br>
	 * 
	 * @param PlanAndApprovalVO[] planAndApprovalVOs
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String managePlanAndApprovalRequestBasic(PlanAndApprovalVO[] planAndApprovalVOs, SignOnUserAccount account) throws EventException;
	
}
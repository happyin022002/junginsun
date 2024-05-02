/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageBC.java
*@FileTitle : managing CNTR repo plan
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0045ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0051ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053MultiVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0054ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0129ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.GetRepoPlanListVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrOnHireApprovalVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanLaneVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanVVDVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchTSGuidelineVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrAddPlnVO;

/**
 * -CntrRepoPlanManage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_eqr_0045EventResponse
 * @since J2EE 1.6
 */

public interface CntrRepoPlanManageBC {

	/**
	 * retrieving for CNTR repo plan<br>
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @return List<GetRepoPlanListVO>
	 * @exception EventException
	 */
	public List<GetRepoPlanListVO> searchRepoPlanList(EesEqr0045ConditionVO conditionVO) throws EventException;
	
	/**
	 * creating new repo plan id<br>
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @param usrId		String
	 * @exception EventException
	 */
	public void createNewRepoPlanID(EesEqr0045ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * removing CNTR repo plan id<br>
	 * 
	 * @param conditionVO EesEqr0045ConditionVO
	 * @exception EventException
	 */
	public void removeRepoPlanID(EesEqr0045ConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for forecasted land inventory<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchForecastedLandInventory(EesEqr0051ConditionVO conditionVO) throws EventException;
	
	/**
	 * saving forecasted land inventory<br>
	 * 
	 * @param eqrAddPlnVOS EqrAddPlnVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyForecastedLandInventory(EqrAddPlnVO[] eqrAddPlnVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving for Distribution forecasted land inventory<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDtrbForecastedLandInventory(EesEqr0051ConditionVO conditionVO) throws EventException;
	
	/**
	 * Distribution  forecasted land inventory<br>
	 * 
	 * @param conditionVO EesEqr0051ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void dtrbForecastedLandInventory(EesEqr0051ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * retriving for CNTR repo InOut plan <br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoInOutPlanDtInfo(EesEqr0052ConditionVO conditionVO) throws EventException;
	
	/**
	 * retriving for CNTR repo InOut plan lane info<br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return List<SearchCntrRepoInOutPlanLaneVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoInOutPlanLaneVO> searchCntrRepoInOutPlanLaneInfo(EesEqr0052ConditionVO conditionVO) throws EventException;
	
	/**
	 * retriving for CNTR repo InOut plan VVD info<br>
	 * 
	 * @param conditionVO EesEqr0052ConditionVO
	 * @return List<SearchCntrRepoInOutPlanVVDVO>
	 * @exception EventException
	 */
	public List<SearchCntrRepoInOutPlanVVDVO> searchCntrRepoInOutPlanVvdInfo(EesEqr0052ConditionVO conditionVO) throws EventException;
	
	/**
	 * saving CNTR repo InOut plan info<br>
	 * 
	 * @param eesEqr0052MultiVOS EesEqr0052MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrRepoInOutPlanDtInfo(EesEqr0052MultiVO[] eesEqr0052MultiVOS, String usrId) throws EventException;
	
	/**
	 * retreiving for TS Guideline PopUp<br>
	 * 
	 * @param conditionVO EesEqr0129ConditionVO
	 * @return List<SearchTSGuidelineVO>
	 * @exception EventException
	 */
	public List<SearchTSGuidelineVO> searchTSGuideline(EesEqr0129ConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for CNTR on hire repo plan info(On-Hire)<br>
	 * 
	 * @param conditionVO EesEqr0053ConditionVO
	 * @return
	 * @exception EventException
	 */
	public CommonRsVO searchCntrOnHireRepoPlanDtInfo(EesEqr0053ConditionVO conditionVO) throws EventException;
	
	/**
	 * retrieving for On-Hire approval<br>
	 * 
	 * @param conditionVO EesEqr0053ConditionVO
	 * @return List<SearchCntrOnHireApprovalVO>
	 * @exception EventException
	 */
	public List<SearchCntrOnHireApprovalVO> searchOnHireApproval(EesEqr0053ConditionVO conditionVO) throws EventException;
	
	/**
	 * saving CNTR on hire repo plan info(On-Hire)<br>
	 * 
	 * @param eesEqr0053MultiVOS EesEqr0053MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrOnHireRepoPlanDtInfo(EesEqr0053MultiVO[] eesEqr0053MultiVOS, String usrId) throws EventException;
	
	/**
	 * retrieving for CNTR off hire repo plan info(On-Hire)<br>
	 * 
	 * @param conditionVO EesEqr0054ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrOffHireRepoPlanDtInfo(EesEqr0054ConditionVO conditionVO) throws EventException;
	
	/**
	 * saving CNTR off hire repo plan info(On-Hire)<br>
	 * 
	 * @param eesEqr0053MultiVOS EesEqr0053MultiVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyCntrOffHireRepoPlanDtInfo(EesEqr0053MultiVO[] eesEqr0053MultiVOS, String usrId) throws EventException;
	
	/**
	 * retrieving for RLA repo plan info(RLA List)<br>
	 * 
	 * @param conditionVO EesEqr0048ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchRLARepoPlanDtList(EesEqr0048ConditionVO conditionVO) throws EventException;
	
	/**
	 * saving RLA repo plan info(RLA List)<br>
	 * 
	 * @param eesEqr0048MultiVOS EesEqr0048MultiVO[]
	 * @param conditionVO EesEqr0048ConditionVO
	 * @param usrId String
	 * @exception EventException
	 */
	public void modifyRLARepoPlanDtList(EesEqr0048MultiVO[] eesEqr0048MultiVOS, EesEqr0048ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 *  <br>
	 * @param EesEqr0059ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchToEta(EesEqr0059ConditionVO condVO) throws EventException;
	
	
	/**
	 *  <br>
	 * @param EesEqr0059ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchNowWeek(EesEqr0059ConditionVO condVO) throws EventException;
	
}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupKpiTargetManageBC.java
*@FileTitle : KPI Target
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetConditionVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetManageVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpKpiTgtRtoVO;

/**
 * ALPS-Evaluationgrouptargetmanage Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-Evaluationgrouptargetmanage<br>
 *
 * @author 
 * @see Esd_spe_0008EventResponse 
 * @since J2EE 1.6
 */
public interface EvaluationGroupKpiTargetManageBC {

	/**
	 * Retrieving EGKpi target.
	 * 
	 * @param SearchEGKpiTargetConditionVO	searchEGKpiTargetConditionVO
	 * @return List<SearchEGKpiTargetManageVO>
	 * @exception EventException
	 */
	public List<SearchEGKpiTargetManageVO> searchEGKpiTargetManage(SearchEGKpiTargetConditionVO searchEGKpiTargetConditionVO) throws EventException;
	
	/**
	 * Saving the data of EGKpiTarget<br>
	 * 
	 * @param SpeEvGrpKpiTgtRtoVO[] speEvGrpKpiTgtRtoVOs
	 * @param account SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGKpiTargetManage(SpeEvGrpKpiTgtRtoVO[] speEvGrpKpiTgtRtoVOs,SignOnUserAccount account) throws EventException;
}
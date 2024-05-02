/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupManageBC.java
*@FileTitle : Evaluation Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEgidConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpVO;

/**
 * ALPS-Mastermanage Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-Mastermanage<br>
 *
 * @author 
 * @see Esd_spe_0001EventResponse 
 * @since J2EE 1.6
 */

public interface EvaluationGroupManageBC {

	/**
	 * Retrieving the list of EGId<br>
	 * 
	 * @param SearchEgidConditionVO	searchEgidConditionVO
	 * @return List<SearchEGIdListVO>
	 * @exception EventException
	 */
	public List<SearchEGIdListVO> searchEGIdList(SearchEgidConditionVO searchEgidConditionVO) throws EventException;
	
	/**
	 * Retrieving the list of all EGId<br>
	 * 
	 * @return List<SearchEGIdAllListVO>
	 * @exception EventException
	 */
	public List<SearchEGIdAllListVO> searchEGIdAllList() throws EventException;
	
	/**
	 * Saving the EG data<br>
	 * 
	 * @param SpeEvGrpVO[] speEvGrpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGManage(SpeEvGrpVO[] speEvGrpVOs,SignOnUserAccount account) throws EventException;
}
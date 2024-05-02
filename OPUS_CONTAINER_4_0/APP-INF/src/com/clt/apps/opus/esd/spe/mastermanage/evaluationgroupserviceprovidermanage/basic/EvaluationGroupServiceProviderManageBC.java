/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupServiceProviderManageBC.java
*@FileTitle : EG VS S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.03 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEgidConditionVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.vo.SearchEGSPManageVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpSvcProvMtchVO;

/**
 * ALPS-Mastermanage Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-Mastermanage<br>
 *
 * @author 
 * @see Esd_spe_0014EventResponse 
 * @since J2EE 1.6
 */

public interface EvaluationGroupServiceProviderManageBC {

	/**
	 * Retrieving the managing EGSP<br>
	 * 
	 * @param SearchEgidConditionVO	searchEgidConditionVO
	 * @return List<SearchEGSPManageVO>
	 * @exception EventException
	 */
	public List<SearchEGSPManageVO> searchEGSPManage(SearchEgidConditionVO searchEgidConditionVO) throws EventException;
	
	/**
	 * Getting the EG choicer<br>
	 * 
	 * @param String egId
	 * @return SearchEGSPManageVO
	 * @exception EventException
	 */
	public SearchEGSPManageVO getEgChoicer(String egId) throws EventException;
	
	
	/**
	 * Saving EGSP.<br>
	 * 
	 * @param SpeEvGrpSvcProvMtchVO[] speEvGrpSvcProvMtchVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiEGSPManage(SpeEvGrpSvcProvMtchVO[] speEvGrpSvcProvMtchVOs,SignOnUserAccount account) throws EventException;
}
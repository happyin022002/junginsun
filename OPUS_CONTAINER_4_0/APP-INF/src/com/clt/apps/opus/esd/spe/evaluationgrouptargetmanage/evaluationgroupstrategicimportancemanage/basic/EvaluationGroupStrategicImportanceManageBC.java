/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupStrategicImportanceManageBC.java
*@FileTitle : SI Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchEvaluationGroupStrategicImportanceManageListVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchInputListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpStrgImptRsltVO;

/**
 * ALPS-Evaluationgrouptargetmanage Business Logic Command Interface<br>
 * - The interface of the business logic about ALPS-Evaluationgrouptargetmanage<br>
 *
 * @author 
 * @see Esd_spe_0003EventResponse 
 * @since J2EE 1.6
 */

public interface EvaluationGroupStrategicImportanceManageBC {

	/**
	 * Retrieving the list of the managing evaluation group strategic importance.
	 * 
	 * @param SearchInputListVO	searchInputListVO
	 * @return List<SearchEvaluationGroupStrategicImportanceManageListVO>
	 * @exception EventException
	 */
	public List<SearchEvaluationGroupStrategicImportanceManageListVO> searchEvaluationGroupStrategicImportanceManageList(SearchInputListVO searchInputListVO) throws EventException;
	
	/**
	 * Saving the data of SpeEvGrpStrgImptRslt<br>
	 * 
	 * @param SpeEvGrpStrgImptRsltVO[] speEvGrpStrgImptRsltVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpeEvGrpStrgImptRslt(SpeEvGrpStrgImptRsltVO[] speEvGrpStrgImptRsltVOs,SignOnUserAccount account) throws EventException;
	
}
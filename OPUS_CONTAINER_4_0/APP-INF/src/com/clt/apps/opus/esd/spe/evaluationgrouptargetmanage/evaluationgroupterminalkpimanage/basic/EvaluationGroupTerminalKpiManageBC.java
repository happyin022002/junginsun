/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupTerminalKpiManageBC.java
*@FileTitle : EvaluationGroupTargetManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchEGTerminalKpiManageVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchVndrSeqVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpTmlKpiTgtRtoVO;

/**
 * ALPS-Evaluationgrouptargetmanage Business Logic Command Interface<br>
 * - The interface of the business logic aobut ALPS-Evaluationgrouptargetmanage
 *
 * @author 
 * @see Esd_spe_0009EventResponse 
 * @since J2EE 1.6
 */

public interface EvaluationGroupTerminalKpiManageBC {

	/**
	 * Retrieving EG Terminal Kpi<br>
	 * 
	 * @param SearchEGTerminalKpiManageVO	searchEGTerminalKpiManageVO
	 * @return List<SearchEGTerminalKpiManageVO>
	 * @exception EventException
	 */
	public List<SearchEGTerminalKpiManageVO> searchEGTerminalKpiManage(SearchEGTerminalKpiManageVO searchEGTerminalKpiManageVO) throws EventException;
	
	/**
	 * Saving the data of SpeEvGrpTmlKpiTgtRto<br>
	 * 
	 * @param SpeEvGrpTmlKpiTgtRtoVO[] speEvGrpTmlKpiTgtRtoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpeEvGrpTmlKpiTgtRto(SpeEvGrpTmlKpiTgtRtoVO[] speEvGrpTmlKpiTgtRtoVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving the vendor sequence<br>
	 * 
	 * @param SearchVndrSeqVO	searchVndrSeqVO
	 * @return List<SearchVndrSeqVO>
	 * @exception EventException
	 */
	public List<SearchVndrSeqVO> searchVndrSeq(SearchVndrSeqVO searchVndrSeqVO) throws EventException;
	
}